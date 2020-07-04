package com.myfun.repository.erpdb.po;

import com.myfun.repository.support.generator.shard.ShardDb;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ErpFunAttendanceStatisticsExample extends ShardDb {
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
	public ErpFunAttendanceStatisticsExample() {
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

		public Criteria andAttDateIsNull() {
			addCriterion("ATT_DATE is null");
			return (Criteria) this;
		}

		public Criteria andAttDateIsNotNull() {
			addCriterion("ATT_DATE is not null");
			return (Criteria) this;
		}

		public Criteria andAttDateEqualTo(Date value) {
			addCriterion("ATT_DATE =", value, "attDate");
			return (Criteria) this;
		}

		public Criteria andAttDateNotEqualTo(Date value) {
			addCriterion("ATT_DATE <>", value, "attDate");
			return (Criteria) this;
		}

		public Criteria andAttDateGreaterThan(Date value) {
			addCriterion("ATT_DATE >", value, "attDate");
			return (Criteria) this;
		}

		public Criteria andAttDateGreaterThanOrEqualTo(Date value) {
			addCriterion("ATT_DATE >=", value, "attDate");
			return (Criteria) this;
		}

		public Criteria andAttDateLessThan(Date value) {
			addCriterion("ATT_DATE <", value, "attDate");
			return (Criteria) this;
		}

		public Criteria andAttDateLessThanOrEqualTo(Date value) {
			addCriterion("ATT_DATE <=", value, "attDate");
			return (Criteria) this;
		}

		public Criteria andAttDateIn(List<Date> values) {
			addCriterion("ATT_DATE in", values, "attDate");
			return (Criteria) this;
		}

		public Criteria andAttDateNotIn(List<Date> values) {
			addCriterion("ATT_DATE not in", values, "attDate");
			return (Criteria) this;
		}

		public Criteria andAttDateBetween(Date value1, Date value2) {
			addCriterion("ATT_DATE between", value1, value2, "attDate");
			return (Criteria) this;
		}

		public Criteria andAttDateNotBetween(Date value1, Date value2) {
			addCriterion("ATT_DATE not between", value1, value2, "attDate");
			return (Criteria) this;
		}

		public Criteria andAttGrIdIsNull() {
			addCriterion("ATT_GR_ID is null");
			return (Criteria) this;
		}

		public Criteria andAttGrIdIsNotNull() {
			addCriterion("ATT_GR_ID is not null");
			return (Criteria) this;
		}

		public Criteria andAttGrIdEqualTo(Integer value) {
			addCriterion("ATT_GR_ID =", value, "attGrId");
			return (Criteria) this;
		}

		public Criteria andAttGrIdNotEqualTo(Integer value) {
			addCriterion("ATT_GR_ID <>", value, "attGrId");
			return (Criteria) this;
		}

		public Criteria andAttGrIdGreaterThan(Integer value) {
			addCriterion("ATT_GR_ID >", value, "attGrId");
			return (Criteria) this;
		}

		public Criteria andAttGrIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("ATT_GR_ID >=", value, "attGrId");
			return (Criteria) this;
		}

		public Criteria andAttGrIdLessThan(Integer value) {
			addCriterion("ATT_GR_ID <", value, "attGrId");
			return (Criteria) this;
		}

		public Criteria andAttGrIdLessThanOrEqualTo(Integer value) {
			addCriterion("ATT_GR_ID <=", value, "attGrId");
			return (Criteria) this;
		}

		public Criteria andAttGrIdIn(List<Integer> values) {
			addCriterion("ATT_GR_ID in", values, "attGrId");
			return (Criteria) this;
		}

		public Criteria andAttGrIdNotIn(List<Integer> values) {
			addCriterion("ATT_GR_ID not in", values, "attGrId");
			return (Criteria) this;
		}

		public Criteria andAttGrIdBetween(Integer value1, Integer value2) {
			addCriterion("ATT_GR_ID between", value1, value2, "attGrId");
			return (Criteria) this;
		}

		public Criteria andAttGrIdNotBetween(Integer value1, Integer value2) {
			addCriterion("ATT_GR_ID not between", value1, value2, "attGrId");
			return (Criteria) this;
		}

		public Criteria andAttClassIdIsNull() {
			addCriterion("ATT_ClASS_ID is null");
			return (Criteria) this;
		}

		public Criteria andAttClassIdIsNotNull() {
			addCriterion("ATT_ClASS_ID is not null");
			return (Criteria) this;
		}

		public Criteria andAttClassIdEqualTo(Integer value) {
			addCriterion("ATT_ClASS_ID =", value, "attClassId");
			return (Criteria) this;
		}

		public Criteria andAttClassIdNotEqualTo(Integer value) {
			addCriterion("ATT_ClASS_ID <>", value, "attClassId");
			return (Criteria) this;
		}

		public Criteria andAttClassIdGreaterThan(Integer value) {
			addCriterion("ATT_ClASS_ID >", value, "attClassId");
			return (Criteria) this;
		}

		public Criteria andAttClassIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("ATT_ClASS_ID >=", value, "attClassId");
			return (Criteria) this;
		}

		public Criteria andAttClassIdLessThan(Integer value) {
			addCriterion("ATT_ClASS_ID <", value, "attClassId");
			return (Criteria) this;
		}

		public Criteria andAttClassIdLessThanOrEqualTo(Integer value) {
			addCriterion("ATT_ClASS_ID <=", value, "attClassId");
			return (Criteria) this;
		}

		public Criteria andAttClassIdIn(List<Integer> values) {
			addCriterion("ATT_ClASS_ID in", values, "attClassId");
			return (Criteria) this;
		}

		public Criteria andAttClassIdNotIn(List<Integer> values) {
			addCriterion("ATT_ClASS_ID not in", values, "attClassId");
			return (Criteria) this;
		}

		public Criteria andAttClassIdBetween(Integer value1, Integer value2) {
			addCriterion("ATT_ClASS_ID between", value1, value2, "attClassId");
			return (Criteria) this;
		}

		public Criteria andAttClassIdNotBetween(Integer value1, Integer value2) {
			addCriterion("ATT_ClASS_ID not between", value1, value2, "attClassId");
			return (Criteria) this;
		}

		public Criteria andAttClassNameIsNull() {
			addCriterion("ATT_ClASS_NAME is null");
			return (Criteria) this;
		}

		public Criteria andAttClassNameIsNotNull() {
			addCriterion("ATT_ClASS_NAME is not null");
			return (Criteria) this;
		}

		public Criteria andAttClassNameEqualTo(String value) {
			addCriterion("ATT_ClASS_NAME =", value, "attClassName");
			return (Criteria) this;
		}

		public Criteria andAttClassNameNotEqualTo(String value) {
			addCriterion("ATT_ClASS_NAME <>", value, "attClassName");
			return (Criteria) this;
		}

		public Criteria andAttClassNameGreaterThan(String value) {
			addCriterion("ATT_ClASS_NAME >", value, "attClassName");
			return (Criteria) this;
		}

		public Criteria andAttClassNameGreaterThanOrEqualTo(String value) {
			addCriterion("ATT_ClASS_NAME >=", value, "attClassName");
			return (Criteria) this;
		}

		public Criteria andAttClassNameLessThan(String value) {
			addCriterion("ATT_ClASS_NAME <", value, "attClassName");
			return (Criteria) this;
		}

		public Criteria andAttClassNameLessThanOrEqualTo(String value) {
			addCriterion("ATT_ClASS_NAME <=", value, "attClassName");
			return (Criteria) this;
		}

		public Criteria andAttClassNameLike(String value) {
			addCriterion("ATT_ClASS_NAME like", value, "attClassName");
			return (Criteria) this;
		}

		public Criteria andAttClassNameNotLike(String value) {
			addCriterion("ATT_ClASS_NAME not like", value, "attClassName");
			return (Criteria) this;
		}

		public Criteria andAttClassNameIn(List<String> values) {
			addCriterion("ATT_ClASS_NAME in", values, "attClassName");
			return (Criteria) this;
		}

		public Criteria andAttClassNameNotIn(List<String> values) {
			addCriterion("ATT_ClASS_NAME not in", values, "attClassName");
			return (Criteria) this;
		}

		public Criteria andAttClassNameBetween(String value1, String value2) {
			addCriterion("ATT_ClASS_NAME between", value1, value2, "attClassName");
			return (Criteria) this;
		}

		public Criteria andAttClassNameNotBetween(String value1, String value2) {
			addCriterion("ATT_ClASS_NAME not between", value1, value2, "attClassName");
			return (Criteria) this;
		}

		public Criteria andAttClassClocktimeIsNull() {
			addCriterion("ATT_CLASS_CLOCKTIME is null");
			return (Criteria) this;
		}

		public Criteria andAttClassClocktimeIsNotNull() {
			addCriterion("ATT_CLASS_CLOCKTIME is not null");
			return (Criteria) this;
		}

		public Criteria andAttClassClocktimeEqualTo(String value) {
			addCriterion("ATT_CLASS_CLOCKTIME =", value, "attClassClocktime");
			return (Criteria) this;
		}

		public Criteria andAttClassClocktimeNotEqualTo(String value) {
			addCriterion("ATT_CLASS_CLOCKTIME <>", value, "attClassClocktime");
			return (Criteria) this;
		}

		public Criteria andAttClassClocktimeGreaterThan(String value) {
			addCriterion("ATT_CLASS_CLOCKTIME >", value, "attClassClocktime");
			return (Criteria) this;
		}

		public Criteria andAttClassClocktimeGreaterThanOrEqualTo(String value) {
			addCriterion("ATT_CLASS_CLOCKTIME >=", value, "attClassClocktime");
			return (Criteria) this;
		}

		public Criteria andAttClassClocktimeLessThan(String value) {
			addCriterion("ATT_CLASS_CLOCKTIME <", value, "attClassClocktime");
			return (Criteria) this;
		}

		public Criteria andAttClassClocktimeLessThanOrEqualTo(String value) {
			addCriterion("ATT_CLASS_CLOCKTIME <=", value, "attClassClocktime");
			return (Criteria) this;
		}

		public Criteria andAttClassClocktimeLike(String value) {
			addCriterion("ATT_CLASS_CLOCKTIME like", value, "attClassClocktime");
			return (Criteria) this;
		}

		public Criteria andAttClassClocktimeNotLike(String value) {
			addCriterion("ATT_CLASS_CLOCKTIME not like", value, "attClassClocktime");
			return (Criteria) this;
		}

		public Criteria andAttClassClocktimeIn(List<String> values) {
			addCriterion("ATT_CLASS_CLOCKTIME in", values, "attClassClocktime");
			return (Criteria) this;
		}

		public Criteria andAttClassClocktimeNotIn(List<String> values) {
			addCriterion("ATT_CLASS_CLOCKTIME not in", values, "attClassClocktime");
			return (Criteria) this;
		}

		public Criteria andAttClassClocktimeBetween(String value1, String value2) {
			addCriterion("ATT_CLASS_CLOCKTIME between", value1, value2, "attClassClocktime");
			return (Criteria) this;
		}

		public Criteria andAttClassClocktimeNotBetween(String value1, String value2) {
			addCriterion("ATT_CLASS_CLOCKTIME not between", value1, value2, "attClassClocktime");
			return (Criteria) this;
		}

		public Criteria andOffWorkIsNull() {
			addCriterion("OFF_WORK is null");
			return (Criteria) this;
		}

		public Criteria andOffWorkIsNotNull() {
			addCriterion("OFF_WORK is not null");
			return (Criteria) this;
		}

		public Criteria andOffWorkEqualTo(Byte value) {
			addCriterion("OFF_WORK =", value, "offWork");
			return (Criteria) this;
		}

		public Criteria andOffWorkNotEqualTo(Byte value) {
			addCriterion("OFF_WORK <>", value, "offWork");
			return (Criteria) this;
		}

		public Criteria andOffWorkGreaterThan(Byte value) {
			addCriterion("OFF_WORK >", value, "offWork");
			return (Criteria) this;
		}

		public Criteria andOffWorkGreaterThanOrEqualTo(Byte value) {
			addCriterion("OFF_WORK >=", value, "offWork");
			return (Criteria) this;
		}

		public Criteria andOffWorkLessThan(Byte value) {
			addCriterion("OFF_WORK <", value, "offWork");
			return (Criteria) this;
		}

		public Criteria andOffWorkLessThanOrEqualTo(Byte value) {
			addCriterion("OFF_WORK <=", value, "offWork");
			return (Criteria) this;
		}

		public Criteria andOffWorkIn(List<Byte> values) {
			addCriterion("OFF_WORK in", values, "offWork");
			return (Criteria) this;
		}

		public Criteria andOffWorkNotIn(List<Byte> values) {
			addCriterion("OFF_WORK not in", values, "offWork");
			return (Criteria) this;
		}

		public Criteria andOffWorkBetween(Byte value1, Byte value2) {
			addCriterion("OFF_WORK between", value1, value2, "offWork");
			return (Criteria) this;
		}

		public Criteria andOffWorkNotBetween(Byte value1, Byte value2) {
			addCriterion("OFF_WORK not between", value1, value2, "offWork");
			return (Criteria) this;
		}

		public Criteria andFirstWorkOnIsNull() {
			addCriterion("FIRST_WORK_ON is null");
			return (Criteria) this;
		}

		public Criteria andFirstWorkOnIsNotNull() {
			addCriterion("FIRST_WORK_ON is not null");
			return (Criteria) this;
		}

		public Criteria andFirstWorkOnEqualTo(Byte value) {
			addCriterion("FIRST_WORK_ON =", value, "firstWorkOn");
			return (Criteria) this;
		}

		public Criteria andFirstWorkOnNotEqualTo(Byte value) {
			addCriterion("FIRST_WORK_ON <>", value, "firstWorkOn");
			return (Criteria) this;
		}

		public Criteria andFirstWorkOnGreaterThan(Byte value) {
			addCriterion("FIRST_WORK_ON >", value, "firstWorkOn");
			return (Criteria) this;
		}

		public Criteria andFirstWorkOnGreaterThanOrEqualTo(Byte value) {
			addCriterion("FIRST_WORK_ON >=", value, "firstWorkOn");
			return (Criteria) this;
		}

		public Criteria andFirstWorkOnLessThan(Byte value) {
			addCriterion("FIRST_WORK_ON <", value, "firstWorkOn");
			return (Criteria) this;
		}

		public Criteria andFirstWorkOnLessThanOrEqualTo(Byte value) {
			addCriterion("FIRST_WORK_ON <=", value, "firstWorkOn");
			return (Criteria) this;
		}

		public Criteria andFirstWorkOnIn(List<Byte> values) {
			addCriterion("FIRST_WORK_ON in", values, "firstWorkOn");
			return (Criteria) this;
		}

		public Criteria andFirstWorkOnNotIn(List<Byte> values) {
			addCriterion("FIRST_WORK_ON not in", values, "firstWorkOn");
			return (Criteria) this;
		}

		public Criteria andFirstWorkOnBetween(Byte value1, Byte value2) {
			addCriterion("FIRST_WORK_ON between", value1, value2, "firstWorkOn");
			return (Criteria) this;
		}

		public Criteria andFirstWorkOnNotBetween(Byte value1, Byte value2) {
			addCriterion("FIRST_WORK_ON not between", value1, value2, "firstWorkOn");
			return (Criteria) this;
		}

		public Criteria andFirstWorkonTypeIsNull() {
			addCriterion("FIRST_WORKON_TYPE is null");
			return (Criteria) this;
		}

		public Criteria andFirstWorkonTypeIsNotNull() {
			addCriterion("FIRST_WORKON_TYPE is not null");
			return (Criteria) this;
		}

		public Criteria andFirstWorkonTypeEqualTo(Byte value) {
			addCriterion("FIRST_WORKON_TYPE =", value, "firstWorkonType");
			return (Criteria) this;
		}

		public Criteria andFirstWorkonTypeNotEqualTo(Byte value) {
			addCriterion("FIRST_WORKON_TYPE <>", value, "firstWorkonType");
			return (Criteria) this;
		}

		public Criteria andFirstWorkonTypeGreaterThan(Byte value) {
			addCriterion("FIRST_WORKON_TYPE >", value, "firstWorkonType");
			return (Criteria) this;
		}

		public Criteria andFirstWorkonTypeGreaterThanOrEqualTo(Byte value) {
			addCriterion("FIRST_WORKON_TYPE >=", value, "firstWorkonType");
			return (Criteria) this;
		}

		public Criteria andFirstWorkonTypeLessThan(Byte value) {
			addCriterion("FIRST_WORKON_TYPE <", value, "firstWorkonType");
			return (Criteria) this;
		}

		public Criteria andFirstWorkonTypeLessThanOrEqualTo(Byte value) {
			addCriterion("FIRST_WORKON_TYPE <=", value, "firstWorkonType");
			return (Criteria) this;
		}

		public Criteria andFirstWorkonTypeIn(List<Byte> values) {
			addCriterion("FIRST_WORKON_TYPE in", values, "firstWorkonType");
			return (Criteria) this;
		}

		public Criteria andFirstWorkonTypeNotIn(List<Byte> values) {
			addCriterion("FIRST_WORKON_TYPE not in", values, "firstWorkonType");
			return (Criteria) this;
		}

		public Criteria andFirstWorkonTypeBetween(Byte value1, Byte value2) {
			addCriterion("FIRST_WORKON_TYPE between", value1, value2, "firstWorkonType");
			return (Criteria) this;
		}

		public Criteria andFirstWorkonTypeNotBetween(Byte value1, Byte value2) {
			addCriterion("FIRST_WORKON_TYPE not between", value1, value2, "firstWorkonType");
			return (Criteria) this;
		}

		public Criteria andFirstWorkonChangeuserIsNull() {
			addCriterion("FIRST_WORKON_CHANGEUSER is null");
			return (Criteria) this;
		}

		public Criteria andFirstWorkonChangeuserIsNotNull() {
			addCriterion("FIRST_WORKON_CHANGEUSER is not null");
			return (Criteria) this;
		}

		public Criteria andFirstWorkonChangeuserEqualTo(Integer value) {
			addCriterion("FIRST_WORKON_CHANGEUSER =", value, "firstWorkonChangeuser");
			return (Criteria) this;
		}

		public Criteria andFirstWorkonChangeuserNotEqualTo(Integer value) {
			addCriterion("FIRST_WORKON_CHANGEUSER <>", value, "firstWorkonChangeuser");
			return (Criteria) this;
		}

		public Criteria andFirstWorkonChangeuserGreaterThan(Integer value) {
			addCriterion("FIRST_WORKON_CHANGEUSER >", value, "firstWorkonChangeuser");
			return (Criteria) this;
		}

		public Criteria andFirstWorkonChangeuserGreaterThanOrEqualTo(Integer value) {
			addCriterion("FIRST_WORKON_CHANGEUSER >=", value, "firstWorkonChangeuser");
			return (Criteria) this;
		}

		public Criteria andFirstWorkonChangeuserLessThan(Integer value) {
			addCriterion("FIRST_WORKON_CHANGEUSER <", value, "firstWorkonChangeuser");
			return (Criteria) this;
		}

		public Criteria andFirstWorkonChangeuserLessThanOrEqualTo(Integer value) {
			addCriterion("FIRST_WORKON_CHANGEUSER <=", value, "firstWorkonChangeuser");
			return (Criteria) this;
		}

		public Criteria andFirstWorkonChangeuserIn(List<Integer> values) {
			addCriterion("FIRST_WORKON_CHANGEUSER in", values, "firstWorkonChangeuser");
			return (Criteria) this;
		}

		public Criteria andFirstWorkonChangeuserNotIn(List<Integer> values) {
			addCriterion("FIRST_WORKON_CHANGEUSER not in", values, "firstWorkonChangeuser");
			return (Criteria) this;
		}

		public Criteria andFirstWorkonChangeuserBetween(Integer value1, Integer value2) {
			addCriterion("FIRST_WORKON_CHANGEUSER between", value1, value2, "firstWorkonChangeuser");
			return (Criteria) this;
		}

		public Criteria andFirstWorkonChangeuserNotBetween(Integer value1, Integer value2) {
			addCriterion("FIRST_WORKON_CHANGEUSER not between", value1, value2, "firstWorkonChangeuser");
			return (Criteria) this;
		}

		public Criteria andFirstWorkonChangedeptIsNull() {
			addCriterion("FIRST_WORKON_CHANGEDEPT is null");
			return (Criteria) this;
		}

		public Criteria andFirstWorkonChangedeptIsNotNull() {
			addCriterion("FIRST_WORKON_CHANGEDEPT is not null");
			return (Criteria) this;
		}

		public Criteria andFirstWorkonChangedeptEqualTo(Integer value) {
			addCriterion("FIRST_WORKON_CHANGEDEPT =", value, "firstWorkonChangedept");
			return (Criteria) this;
		}

		public Criteria andFirstWorkonChangedeptNotEqualTo(Integer value) {
			addCriterion("FIRST_WORKON_CHANGEDEPT <>", value, "firstWorkonChangedept");
			return (Criteria) this;
		}

		public Criteria andFirstWorkonChangedeptGreaterThan(Integer value) {
			addCriterion("FIRST_WORKON_CHANGEDEPT >", value, "firstWorkonChangedept");
			return (Criteria) this;
		}

		public Criteria andFirstWorkonChangedeptGreaterThanOrEqualTo(Integer value) {
			addCriterion("FIRST_WORKON_CHANGEDEPT >=", value, "firstWorkonChangedept");
			return (Criteria) this;
		}

		public Criteria andFirstWorkonChangedeptLessThan(Integer value) {
			addCriterion("FIRST_WORKON_CHANGEDEPT <", value, "firstWorkonChangedept");
			return (Criteria) this;
		}

		public Criteria andFirstWorkonChangedeptLessThanOrEqualTo(Integer value) {
			addCriterion("FIRST_WORKON_CHANGEDEPT <=", value, "firstWorkonChangedept");
			return (Criteria) this;
		}

		public Criteria andFirstWorkonChangedeptIn(List<Integer> values) {
			addCriterion("FIRST_WORKON_CHANGEDEPT in", values, "firstWorkonChangedept");
			return (Criteria) this;
		}

		public Criteria andFirstWorkonChangedeptNotIn(List<Integer> values) {
			addCriterion("FIRST_WORKON_CHANGEDEPT not in", values, "firstWorkonChangedept");
			return (Criteria) this;
		}

		public Criteria andFirstWorkonChangedeptBetween(Integer value1, Integer value2) {
			addCriterion("FIRST_WORKON_CHANGEDEPT between", value1, value2, "firstWorkonChangedept");
			return (Criteria) this;
		}

		public Criteria andFirstWorkonChangedeptNotBetween(Integer value1, Integer value2) {
			addCriterion("FIRST_WORKON_CHANGEDEPT not between", value1, value2, "firstWorkonChangedept");
			return (Criteria) this;
		}

		public Criteria andFirstWorkOntimeIsNull() {
			addCriterion("FIRST_WORK_ONTIME is null");
			return (Criteria) this;
		}

		public Criteria andFirstWorkOntimeIsNotNull() {
			addCriterion("FIRST_WORK_ONTIME is not null");
			return (Criteria) this;
		}

		public Criteria andFirstWorkOntimeEqualTo(Date value) {
			addCriterion("FIRST_WORK_ONTIME =", value, "firstWorkOntime");
			return (Criteria) this;
		}

		public Criteria andFirstWorkOntimeNotEqualTo(Date value) {
			addCriterion("FIRST_WORK_ONTIME <>", value, "firstWorkOntime");
			return (Criteria) this;
		}

		public Criteria andFirstWorkOntimeGreaterThan(Date value) {
			addCriterion("FIRST_WORK_ONTIME >", value, "firstWorkOntime");
			return (Criteria) this;
		}

		public Criteria andFirstWorkOntimeGreaterThanOrEqualTo(Date value) {
			addCriterion("FIRST_WORK_ONTIME >=", value, "firstWorkOntime");
			return (Criteria) this;
		}

		public Criteria andFirstWorkOntimeLessThan(Date value) {
			addCriterion("FIRST_WORK_ONTIME <", value, "firstWorkOntime");
			return (Criteria) this;
		}

		public Criteria andFirstWorkOntimeLessThanOrEqualTo(Date value) {
			addCriterion("FIRST_WORK_ONTIME <=", value, "firstWorkOntime");
			return (Criteria) this;
		}

		public Criteria andFirstWorkOntimeIn(List<Date> values) {
			addCriterion("FIRST_WORK_ONTIME in", values, "firstWorkOntime");
			return (Criteria) this;
		}

		public Criteria andFirstWorkOntimeNotIn(List<Date> values) {
			addCriterion("FIRST_WORK_ONTIME not in", values, "firstWorkOntime");
			return (Criteria) this;
		}

		public Criteria andFirstWorkOntimeBetween(Date value1, Date value2) {
			addCriterion("FIRST_WORK_ONTIME between", value1, value2, "firstWorkOntime");
			return (Criteria) this;
		}

		public Criteria andFirstWorkOntimeNotBetween(Date value1, Date value2) {
			addCriterion("FIRST_WORK_ONTIME not between", value1, value2, "firstWorkOntime");
			return (Criteria) this;
		}

		public Criteria andSecondWorkOnIsNull() {
			addCriterion("SECOND_WORK_ON is null");
			return (Criteria) this;
		}

		public Criteria andSecondWorkOnIsNotNull() {
			addCriterion("SECOND_WORK_ON is not null");
			return (Criteria) this;
		}

		public Criteria andSecondWorkOnEqualTo(Byte value) {
			addCriterion("SECOND_WORK_ON =", value, "secondWorkOn");
			return (Criteria) this;
		}

		public Criteria andSecondWorkOnNotEqualTo(Byte value) {
			addCriterion("SECOND_WORK_ON <>", value, "secondWorkOn");
			return (Criteria) this;
		}

		public Criteria andSecondWorkOnGreaterThan(Byte value) {
			addCriterion("SECOND_WORK_ON >", value, "secondWorkOn");
			return (Criteria) this;
		}

		public Criteria andSecondWorkOnGreaterThanOrEqualTo(Byte value) {
			addCriterion("SECOND_WORK_ON >=", value, "secondWorkOn");
			return (Criteria) this;
		}

		public Criteria andSecondWorkOnLessThan(Byte value) {
			addCriterion("SECOND_WORK_ON <", value, "secondWorkOn");
			return (Criteria) this;
		}

		public Criteria andSecondWorkOnLessThanOrEqualTo(Byte value) {
			addCriterion("SECOND_WORK_ON <=", value, "secondWorkOn");
			return (Criteria) this;
		}

		public Criteria andSecondWorkOnIn(List<Byte> values) {
			addCriterion("SECOND_WORK_ON in", values, "secondWorkOn");
			return (Criteria) this;
		}

		public Criteria andSecondWorkOnNotIn(List<Byte> values) {
			addCriterion("SECOND_WORK_ON not in", values, "secondWorkOn");
			return (Criteria) this;
		}

		public Criteria andSecondWorkOnBetween(Byte value1, Byte value2) {
			addCriterion("SECOND_WORK_ON between", value1, value2, "secondWorkOn");
			return (Criteria) this;
		}

		public Criteria andSecondWorkOnNotBetween(Byte value1, Byte value2) {
			addCriterion("SECOND_WORK_ON not between", value1, value2, "secondWorkOn");
			return (Criteria) this;
		}

		public Criteria andSecondWorkonTypeIsNull() {
			addCriterion("SECOND_WORKON_TYPE is null");
			return (Criteria) this;
		}

		public Criteria andSecondWorkonTypeIsNotNull() {
			addCriterion("SECOND_WORKON_TYPE is not null");
			return (Criteria) this;
		}

		public Criteria andSecondWorkonTypeEqualTo(Byte value) {
			addCriterion("SECOND_WORKON_TYPE =", value, "secondWorkonType");
			return (Criteria) this;
		}

		public Criteria andSecondWorkonTypeNotEqualTo(Byte value) {
			addCriterion("SECOND_WORKON_TYPE <>", value, "secondWorkonType");
			return (Criteria) this;
		}

		public Criteria andSecondWorkonTypeGreaterThan(Byte value) {
			addCriterion("SECOND_WORKON_TYPE >", value, "secondWorkonType");
			return (Criteria) this;
		}

		public Criteria andSecondWorkonTypeGreaterThanOrEqualTo(Byte value) {
			addCriterion("SECOND_WORKON_TYPE >=", value, "secondWorkonType");
			return (Criteria) this;
		}

		public Criteria andSecondWorkonTypeLessThan(Byte value) {
			addCriterion("SECOND_WORKON_TYPE <", value, "secondWorkonType");
			return (Criteria) this;
		}

		public Criteria andSecondWorkonTypeLessThanOrEqualTo(Byte value) {
			addCriterion("SECOND_WORKON_TYPE <=", value, "secondWorkonType");
			return (Criteria) this;
		}

		public Criteria andSecondWorkonTypeIn(List<Byte> values) {
			addCriterion("SECOND_WORKON_TYPE in", values, "secondWorkonType");
			return (Criteria) this;
		}

		public Criteria andSecondWorkonTypeNotIn(List<Byte> values) {
			addCriterion("SECOND_WORKON_TYPE not in", values, "secondWorkonType");
			return (Criteria) this;
		}

		public Criteria andSecondWorkonTypeBetween(Byte value1, Byte value2) {
			addCriterion("SECOND_WORKON_TYPE between", value1, value2, "secondWorkonType");
			return (Criteria) this;
		}

		public Criteria andSecondWorkonTypeNotBetween(Byte value1, Byte value2) {
			addCriterion("SECOND_WORKON_TYPE not between", value1, value2, "secondWorkonType");
			return (Criteria) this;
		}

		public Criteria andSecondWorkonChangeuserIsNull() {
			addCriterion("SECOND_WORKON_CHANGEUSER is null");
			return (Criteria) this;
		}

		public Criteria andSecondWorkonChangeuserIsNotNull() {
			addCriterion("SECOND_WORKON_CHANGEUSER is not null");
			return (Criteria) this;
		}

		public Criteria andSecondWorkonChangeuserEqualTo(Integer value) {
			addCriterion("SECOND_WORKON_CHANGEUSER =", value, "secondWorkonChangeuser");
			return (Criteria) this;
		}

		public Criteria andSecondWorkonChangeuserNotEqualTo(Integer value) {
			addCriterion("SECOND_WORKON_CHANGEUSER <>", value, "secondWorkonChangeuser");
			return (Criteria) this;
		}

		public Criteria andSecondWorkonChangeuserGreaterThan(Integer value) {
			addCriterion("SECOND_WORKON_CHANGEUSER >", value, "secondWorkonChangeuser");
			return (Criteria) this;
		}

		public Criteria andSecondWorkonChangeuserGreaterThanOrEqualTo(Integer value) {
			addCriterion("SECOND_WORKON_CHANGEUSER >=", value, "secondWorkonChangeuser");
			return (Criteria) this;
		}

		public Criteria andSecondWorkonChangeuserLessThan(Integer value) {
			addCriterion("SECOND_WORKON_CHANGEUSER <", value, "secondWorkonChangeuser");
			return (Criteria) this;
		}

		public Criteria andSecondWorkonChangeuserLessThanOrEqualTo(Integer value) {
			addCriterion("SECOND_WORKON_CHANGEUSER <=", value, "secondWorkonChangeuser");
			return (Criteria) this;
		}

		public Criteria andSecondWorkonChangeuserIn(List<Integer> values) {
			addCriterion("SECOND_WORKON_CHANGEUSER in", values, "secondWorkonChangeuser");
			return (Criteria) this;
		}

		public Criteria andSecondWorkonChangeuserNotIn(List<Integer> values) {
			addCriterion("SECOND_WORKON_CHANGEUSER not in", values, "secondWorkonChangeuser");
			return (Criteria) this;
		}

		public Criteria andSecondWorkonChangeuserBetween(Integer value1, Integer value2) {
			addCriterion("SECOND_WORKON_CHANGEUSER between", value1, value2, "secondWorkonChangeuser");
			return (Criteria) this;
		}

		public Criteria andSecondWorkonChangeuserNotBetween(Integer value1, Integer value2) {
			addCriterion("SECOND_WORKON_CHANGEUSER not between", value1, value2, "secondWorkonChangeuser");
			return (Criteria) this;
		}

		public Criteria andSecondWorkonChangedeptIsNull() {
			addCriterion("SECOND_WORKON_CHANGEDEPT is null");
			return (Criteria) this;
		}

		public Criteria andSecondWorkonChangedeptIsNotNull() {
			addCriterion("SECOND_WORKON_CHANGEDEPT is not null");
			return (Criteria) this;
		}

		public Criteria andSecondWorkonChangedeptEqualTo(Integer value) {
			addCriterion("SECOND_WORKON_CHANGEDEPT =", value, "secondWorkonChangedept");
			return (Criteria) this;
		}

		public Criteria andSecondWorkonChangedeptNotEqualTo(Integer value) {
			addCriterion("SECOND_WORKON_CHANGEDEPT <>", value, "secondWorkonChangedept");
			return (Criteria) this;
		}

		public Criteria andSecondWorkonChangedeptGreaterThan(Integer value) {
			addCriterion("SECOND_WORKON_CHANGEDEPT >", value, "secondWorkonChangedept");
			return (Criteria) this;
		}

		public Criteria andSecondWorkonChangedeptGreaterThanOrEqualTo(Integer value) {
			addCriterion("SECOND_WORKON_CHANGEDEPT >=", value, "secondWorkonChangedept");
			return (Criteria) this;
		}

		public Criteria andSecondWorkonChangedeptLessThan(Integer value) {
			addCriterion("SECOND_WORKON_CHANGEDEPT <", value, "secondWorkonChangedept");
			return (Criteria) this;
		}

		public Criteria andSecondWorkonChangedeptLessThanOrEqualTo(Integer value) {
			addCriterion("SECOND_WORKON_CHANGEDEPT <=", value, "secondWorkonChangedept");
			return (Criteria) this;
		}

		public Criteria andSecondWorkonChangedeptIn(List<Integer> values) {
			addCriterion("SECOND_WORKON_CHANGEDEPT in", values, "secondWorkonChangedept");
			return (Criteria) this;
		}

		public Criteria andSecondWorkonChangedeptNotIn(List<Integer> values) {
			addCriterion("SECOND_WORKON_CHANGEDEPT not in", values, "secondWorkonChangedept");
			return (Criteria) this;
		}

		public Criteria andSecondWorkonChangedeptBetween(Integer value1, Integer value2) {
			addCriterion("SECOND_WORKON_CHANGEDEPT between", value1, value2, "secondWorkonChangedept");
			return (Criteria) this;
		}

		public Criteria andSecondWorkonChangedeptNotBetween(Integer value1, Integer value2) {
			addCriterion("SECOND_WORKON_CHANGEDEPT not between", value1, value2, "secondWorkonChangedept");
			return (Criteria) this;
		}

		public Criteria andSecondWorkOntimeIsNull() {
			addCriterion("SECOND_WORK_ONTIME is null");
			return (Criteria) this;
		}

		public Criteria andSecondWorkOntimeIsNotNull() {
			addCriterion("SECOND_WORK_ONTIME is not null");
			return (Criteria) this;
		}

		public Criteria andSecondWorkOntimeEqualTo(Date value) {
			addCriterion("SECOND_WORK_ONTIME =", value, "secondWorkOntime");
			return (Criteria) this;
		}

		public Criteria andSecondWorkOntimeNotEqualTo(Date value) {
			addCriterion("SECOND_WORK_ONTIME <>", value, "secondWorkOntime");
			return (Criteria) this;
		}

		public Criteria andSecondWorkOntimeGreaterThan(Date value) {
			addCriterion("SECOND_WORK_ONTIME >", value, "secondWorkOntime");
			return (Criteria) this;
		}

		public Criteria andSecondWorkOntimeGreaterThanOrEqualTo(Date value) {
			addCriterion("SECOND_WORK_ONTIME >=", value, "secondWorkOntime");
			return (Criteria) this;
		}

		public Criteria andSecondWorkOntimeLessThan(Date value) {
			addCriterion("SECOND_WORK_ONTIME <", value, "secondWorkOntime");
			return (Criteria) this;
		}

		public Criteria andSecondWorkOntimeLessThanOrEqualTo(Date value) {
			addCriterion("SECOND_WORK_ONTIME <=", value, "secondWorkOntime");
			return (Criteria) this;
		}

		public Criteria andSecondWorkOntimeIn(List<Date> values) {
			addCriterion("SECOND_WORK_ONTIME in", values, "secondWorkOntime");
			return (Criteria) this;
		}

		public Criteria andSecondWorkOntimeNotIn(List<Date> values) {
			addCriterion("SECOND_WORK_ONTIME not in", values, "secondWorkOntime");
			return (Criteria) this;
		}

		public Criteria andSecondWorkOntimeBetween(Date value1, Date value2) {
			addCriterion("SECOND_WORK_ONTIME between", value1, value2, "secondWorkOntime");
			return (Criteria) this;
		}

		public Criteria andSecondWorkOntimeNotBetween(Date value1, Date value2) {
			addCriterion("SECOND_WORK_ONTIME not between", value1, value2, "secondWorkOntime");
			return (Criteria) this;
		}

		public Criteria andThreeWorkOnIsNull() {
			addCriterion("THREE_WORK_ON is null");
			return (Criteria) this;
		}

		public Criteria andThreeWorkOnIsNotNull() {
			addCriterion("THREE_WORK_ON is not null");
			return (Criteria) this;
		}

		public Criteria andThreeWorkOnEqualTo(Byte value) {
			addCriterion("THREE_WORK_ON =", value, "threeWorkOn");
			return (Criteria) this;
		}

		public Criteria andThreeWorkOnNotEqualTo(Byte value) {
			addCriterion("THREE_WORK_ON <>", value, "threeWorkOn");
			return (Criteria) this;
		}

		public Criteria andThreeWorkOnGreaterThan(Byte value) {
			addCriterion("THREE_WORK_ON >", value, "threeWorkOn");
			return (Criteria) this;
		}

		public Criteria andThreeWorkOnGreaterThanOrEqualTo(Byte value) {
			addCriterion("THREE_WORK_ON >=", value, "threeWorkOn");
			return (Criteria) this;
		}

		public Criteria andThreeWorkOnLessThan(Byte value) {
			addCriterion("THREE_WORK_ON <", value, "threeWorkOn");
			return (Criteria) this;
		}

		public Criteria andThreeWorkOnLessThanOrEqualTo(Byte value) {
			addCriterion("THREE_WORK_ON <=", value, "threeWorkOn");
			return (Criteria) this;
		}

		public Criteria andThreeWorkOnIn(List<Byte> values) {
			addCriterion("THREE_WORK_ON in", values, "threeWorkOn");
			return (Criteria) this;
		}

		public Criteria andThreeWorkOnNotIn(List<Byte> values) {
			addCriterion("THREE_WORK_ON not in", values, "threeWorkOn");
			return (Criteria) this;
		}

		public Criteria andThreeWorkOnBetween(Byte value1, Byte value2) {
			addCriterion("THREE_WORK_ON between", value1, value2, "threeWorkOn");
			return (Criteria) this;
		}

		public Criteria andThreeWorkOnNotBetween(Byte value1, Byte value2) {
			addCriterion("THREE_WORK_ON not between", value1, value2, "threeWorkOn");
			return (Criteria) this;
		}

		public Criteria andThreeWorkonTypeIsNull() {
			addCriterion("THREE_WORKON_TYPE is null");
			return (Criteria) this;
		}

		public Criteria andThreeWorkonTypeIsNotNull() {
			addCriterion("THREE_WORKON_TYPE is not null");
			return (Criteria) this;
		}

		public Criteria andThreeWorkonTypeEqualTo(Byte value) {
			addCriterion("THREE_WORKON_TYPE =", value, "threeWorkonType");
			return (Criteria) this;
		}

		public Criteria andThreeWorkonTypeNotEqualTo(Byte value) {
			addCriterion("THREE_WORKON_TYPE <>", value, "threeWorkonType");
			return (Criteria) this;
		}

		public Criteria andThreeWorkonTypeGreaterThan(Byte value) {
			addCriterion("THREE_WORKON_TYPE >", value, "threeWorkonType");
			return (Criteria) this;
		}

		public Criteria andThreeWorkonTypeGreaterThanOrEqualTo(Byte value) {
			addCriterion("THREE_WORKON_TYPE >=", value, "threeWorkonType");
			return (Criteria) this;
		}

		public Criteria andThreeWorkonTypeLessThan(Byte value) {
			addCriterion("THREE_WORKON_TYPE <", value, "threeWorkonType");
			return (Criteria) this;
		}

		public Criteria andThreeWorkonTypeLessThanOrEqualTo(Byte value) {
			addCriterion("THREE_WORKON_TYPE <=", value, "threeWorkonType");
			return (Criteria) this;
		}

		public Criteria andThreeWorkonTypeIn(List<Byte> values) {
			addCriterion("THREE_WORKON_TYPE in", values, "threeWorkonType");
			return (Criteria) this;
		}

		public Criteria andThreeWorkonTypeNotIn(List<Byte> values) {
			addCriterion("THREE_WORKON_TYPE not in", values, "threeWorkonType");
			return (Criteria) this;
		}

		public Criteria andThreeWorkonTypeBetween(Byte value1, Byte value2) {
			addCriterion("THREE_WORKON_TYPE between", value1, value2, "threeWorkonType");
			return (Criteria) this;
		}

		public Criteria andThreeWorkonTypeNotBetween(Byte value1, Byte value2) {
			addCriterion("THREE_WORKON_TYPE not between", value1, value2, "threeWorkonType");
			return (Criteria) this;
		}

		public Criteria andThreeWorkonChangeuserIsNull() {
			addCriterion("THREE_WORKON_CHANGEUSER is null");
			return (Criteria) this;
		}

		public Criteria andThreeWorkonChangeuserIsNotNull() {
			addCriterion("THREE_WORKON_CHANGEUSER is not null");
			return (Criteria) this;
		}

		public Criteria andThreeWorkonChangeuserEqualTo(Integer value) {
			addCriterion("THREE_WORKON_CHANGEUSER =", value, "threeWorkonChangeuser");
			return (Criteria) this;
		}

		public Criteria andThreeWorkonChangeuserNotEqualTo(Integer value) {
			addCriterion("THREE_WORKON_CHANGEUSER <>", value, "threeWorkonChangeuser");
			return (Criteria) this;
		}

		public Criteria andThreeWorkonChangeuserGreaterThan(Integer value) {
			addCriterion("THREE_WORKON_CHANGEUSER >", value, "threeWorkonChangeuser");
			return (Criteria) this;
		}

		public Criteria andThreeWorkonChangeuserGreaterThanOrEqualTo(Integer value) {
			addCriterion("THREE_WORKON_CHANGEUSER >=", value, "threeWorkonChangeuser");
			return (Criteria) this;
		}

		public Criteria andThreeWorkonChangeuserLessThan(Integer value) {
			addCriterion("THREE_WORKON_CHANGEUSER <", value, "threeWorkonChangeuser");
			return (Criteria) this;
		}

		public Criteria andThreeWorkonChangeuserLessThanOrEqualTo(Integer value) {
			addCriterion("THREE_WORKON_CHANGEUSER <=", value, "threeWorkonChangeuser");
			return (Criteria) this;
		}

		public Criteria andThreeWorkonChangeuserIn(List<Integer> values) {
			addCriterion("THREE_WORKON_CHANGEUSER in", values, "threeWorkonChangeuser");
			return (Criteria) this;
		}

		public Criteria andThreeWorkonChangeuserNotIn(List<Integer> values) {
			addCriterion("THREE_WORKON_CHANGEUSER not in", values, "threeWorkonChangeuser");
			return (Criteria) this;
		}

		public Criteria andThreeWorkonChangeuserBetween(Integer value1, Integer value2) {
			addCriterion("THREE_WORKON_CHANGEUSER between", value1, value2, "threeWorkonChangeuser");
			return (Criteria) this;
		}

		public Criteria andThreeWorkonChangeuserNotBetween(Integer value1, Integer value2) {
			addCriterion("THREE_WORKON_CHANGEUSER not between", value1, value2, "threeWorkonChangeuser");
			return (Criteria) this;
		}

		public Criteria andThreeWorkonChangedeptIsNull() {
			addCriterion("THREE_WORKON_CHANGEDEPT is null");
			return (Criteria) this;
		}

		public Criteria andThreeWorkonChangedeptIsNotNull() {
			addCriterion("THREE_WORKON_CHANGEDEPT is not null");
			return (Criteria) this;
		}

		public Criteria andThreeWorkonChangedeptEqualTo(Integer value) {
			addCriterion("THREE_WORKON_CHANGEDEPT =", value, "threeWorkonChangedept");
			return (Criteria) this;
		}

		public Criteria andThreeWorkonChangedeptNotEqualTo(Integer value) {
			addCriterion("THREE_WORKON_CHANGEDEPT <>", value, "threeWorkonChangedept");
			return (Criteria) this;
		}

		public Criteria andThreeWorkonChangedeptGreaterThan(Integer value) {
			addCriterion("THREE_WORKON_CHANGEDEPT >", value, "threeWorkonChangedept");
			return (Criteria) this;
		}

		public Criteria andThreeWorkonChangedeptGreaterThanOrEqualTo(Integer value) {
			addCriterion("THREE_WORKON_CHANGEDEPT >=", value, "threeWorkonChangedept");
			return (Criteria) this;
		}

		public Criteria andThreeWorkonChangedeptLessThan(Integer value) {
			addCriterion("THREE_WORKON_CHANGEDEPT <", value, "threeWorkonChangedept");
			return (Criteria) this;
		}

		public Criteria andThreeWorkonChangedeptLessThanOrEqualTo(Integer value) {
			addCriterion("THREE_WORKON_CHANGEDEPT <=", value, "threeWorkonChangedept");
			return (Criteria) this;
		}

		public Criteria andThreeWorkonChangedeptIn(List<Integer> values) {
			addCriterion("THREE_WORKON_CHANGEDEPT in", values, "threeWorkonChangedept");
			return (Criteria) this;
		}

		public Criteria andThreeWorkonChangedeptNotIn(List<Integer> values) {
			addCriterion("THREE_WORKON_CHANGEDEPT not in", values, "threeWorkonChangedept");
			return (Criteria) this;
		}

		public Criteria andThreeWorkonChangedeptBetween(Integer value1, Integer value2) {
			addCriterion("THREE_WORKON_CHANGEDEPT between", value1, value2, "threeWorkonChangedept");
			return (Criteria) this;
		}

		public Criteria andThreeWorkonChangedeptNotBetween(Integer value1, Integer value2) {
			addCriterion("THREE_WORKON_CHANGEDEPT not between", value1, value2, "threeWorkonChangedept");
			return (Criteria) this;
		}

		public Criteria andThreeWorkOntimeIsNull() {
			addCriterion("THREE_WORK_ONTIME is null");
			return (Criteria) this;
		}

		public Criteria andThreeWorkOntimeIsNotNull() {
			addCriterion("THREE_WORK_ONTIME is not null");
			return (Criteria) this;
		}

		public Criteria andThreeWorkOntimeEqualTo(Date value) {
			addCriterion("THREE_WORK_ONTIME =", value, "threeWorkOntime");
			return (Criteria) this;
		}

		public Criteria andThreeWorkOntimeNotEqualTo(Date value) {
			addCriterion("THREE_WORK_ONTIME <>", value, "threeWorkOntime");
			return (Criteria) this;
		}

		public Criteria andThreeWorkOntimeGreaterThan(Date value) {
			addCriterion("THREE_WORK_ONTIME >", value, "threeWorkOntime");
			return (Criteria) this;
		}

		public Criteria andThreeWorkOntimeGreaterThanOrEqualTo(Date value) {
			addCriterion("THREE_WORK_ONTIME >=", value, "threeWorkOntime");
			return (Criteria) this;
		}

		public Criteria andThreeWorkOntimeLessThan(Date value) {
			addCriterion("THREE_WORK_ONTIME <", value, "threeWorkOntime");
			return (Criteria) this;
		}

		public Criteria andThreeWorkOntimeLessThanOrEqualTo(Date value) {
			addCriterion("THREE_WORK_ONTIME <=", value, "threeWorkOntime");
			return (Criteria) this;
		}

		public Criteria andThreeWorkOntimeIn(List<Date> values) {
			addCriterion("THREE_WORK_ONTIME in", values, "threeWorkOntime");
			return (Criteria) this;
		}

		public Criteria andThreeWorkOntimeNotIn(List<Date> values) {
			addCriterion("THREE_WORK_ONTIME not in", values, "threeWorkOntime");
			return (Criteria) this;
		}

		public Criteria andThreeWorkOntimeBetween(Date value1, Date value2) {
			addCriterion("THREE_WORK_ONTIME between", value1, value2, "threeWorkOntime");
			return (Criteria) this;
		}

		public Criteria andThreeWorkOntimeNotBetween(Date value1, Date value2) {
			addCriterion("THREE_WORK_ONTIME not between", value1, value2, "threeWorkOntime");
			return (Criteria) this;
		}

		public Criteria andFirstWorkOffIsNull() {
			addCriterion("FIRST_WORK_OFF is null");
			return (Criteria) this;
		}

		public Criteria andFirstWorkOffIsNotNull() {
			addCriterion("FIRST_WORK_OFF is not null");
			return (Criteria) this;
		}

		public Criteria andFirstWorkOffEqualTo(Byte value) {
			addCriterion("FIRST_WORK_OFF =", value, "firstWorkOff");
			return (Criteria) this;
		}

		public Criteria andFirstWorkOffNotEqualTo(Byte value) {
			addCriterion("FIRST_WORK_OFF <>", value, "firstWorkOff");
			return (Criteria) this;
		}

		public Criteria andFirstWorkOffGreaterThan(Byte value) {
			addCriterion("FIRST_WORK_OFF >", value, "firstWorkOff");
			return (Criteria) this;
		}

		public Criteria andFirstWorkOffGreaterThanOrEqualTo(Byte value) {
			addCriterion("FIRST_WORK_OFF >=", value, "firstWorkOff");
			return (Criteria) this;
		}

		public Criteria andFirstWorkOffLessThan(Byte value) {
			addCriterion("FIRST_WORK_OFF <", value, "firstWorkOff");
			return (Criteria) this;
		}

		public Criteria andFirstWorkOffLessThanOrEqualTo(Byte value) {
			addCriterion("FIRST_WORK_OFF <=", value, "firstWorkOff");
			return (Criteria) this;
		}

		public Criteria andFirstWorkOffIn(List<Byte> values) {
			addCriterion("FIRST_WORK_OFF in", values, "firstWorkOff");
			return (Criteria) this;
		}

		public Criteria andFirstWorkOffNotIn(List<Byte> values) {
			addCriterion("FIRST_WORK_OFF not in", values, "firstWorkOff");
			return (Criteria) this;
		}

		public Criteria andFirstWorkOffBetween(Byte value1, Byte value2) {
			addCriterion("FIRST_WORK_OFF between", value1, value2, "firstWorkOff");
			return (Criteria) this;
		}

		public Criteria andFirstWorkOffNotBetween(Byte value1, Byte value2) {
			addCriterion("FIRST_WORK_OFF not between", value1, value2, "firstWorkOff");
			return (Criteria) this;
		}

		public Criteria andFirstWorkoffTypeIsNull() {
			addCriterion("FIRST_WORKOFF_TYPE is null");
			return (Criteria) this;
		}

		public Criteria andFirstWorkoffTypeIsNotNull() {
			addCriterion("FIRST_WORKOFF_TYPE is not null");
			return (Criteria) this;
		}

		public Criteria andFirstWorkoffTypeEqualTo(Byte value) {
			addCriterion("FIRST_WORKOFF_TYPE =", value, "firstWorkoffType");
			return (Criteria) this;
		}

		public Criteria andFirstWorkoffTypeNotEqualTo(Byte value) {
			addCriterion("FIRST_WORKOFF_TYPE <>", value, "firstWorkoffType");
			return (Criteria) this;
		}

		public Criteria andFirstWorkoffTypeGreaterThan(Byte value) {
			addCriterion("FIRST_WORKOFF_TYPE >", value, "firstWorkoffType");
			return (Criteria) this;
		}

		public Criteria andFirstWorkoffTypeGreaterThanOrEqualTo(Byte value) {
			addCriterion("FIRST_WORKOFF_TYPE >=", value, "firstWorkoffType");
			return (Criteria) this;
		}

		public Criteria andFirstWorkoffTypeLessThan(Byte value) {
			addCriterion("FIRST_WORKOFF_TYPE <", value, "firstWorkoffType");
			return (Criteria) this;
		}

		public Criteria andFirstWorkoffTypeLessThanOrEqualTo(Byte value) {
			addCriterion("FIRST_WORKOFF_TYPE <=", value, "firstWorkoffType");
			return (Criteria) this;
		}

		public Criteria andFirstWorkoffTypeIn(List<Byte> values) {
			addCriterion("FIRST_WORKOFF_TYPE in", values, "firstWorkoffType");
			return (Criteria) this;
		}

		public Criteria andFirstWorkoffTypeNotIn(List<Byte> values) {
			addCriterion("FIRST_WORKOFF_TYPE not in", values, "firstWorkoffType");
			return (Criteria) this;
		}

		public Criteria andFirstWorkoffTypeBetween(Byte value1, Byte value2) {
			addCriterion("FIRST_WORKOFF_TYPE between", value1, value2, "firstWorkoffType");
			return (Criteria) this;
		}

		public Criteria andFirstWorkoffTypeNotBetween(Byte value1, Byte value2) {
			addCriterion("FIRST_WORKOFF_TYPE not between", value1, value2, "firstWorkoffType");
			return (Criteria) this;
		}

		public Criteria andFirstWorkoffChangeuserIsNull() {
			addCriterion("FIRST_WORKOFF_CHANGEUSER is null");
			return (Criteria) this;
		}

		public Criteria andFirstWorkoffChangeuserIsNotNull() {
			addCriterion("FIRST_WORKOFF_CHANGEUSER is not null");
			return (Criteria) this;
		}

		public Criteria andFirstWorkoffChangeuserEqualTo(Integer value) {
			addCriterion("FIRST_WORKOFF_CHANGEUSER =", value, "firstWorkoffChangeuser");
			return (Criteria) this;
		}

		public Criteria andFirstWorkoffChangeuserNotEqualTo(Integer value) {
			addCriterion("FIRST_WORKOFF_CHANGEUSER <>", value, "firstWorkoffChangeuser");
			return (Criteria) this;
		}

		public Criteria andFirstWorkoffChangeuserGreaterThan(Integer value) {
			addCriterion("FIRST_WORKOFF_CHANGEUSER >", value, "firstWorkoffChangeuser");
			return (Criteria) this;
		}

		public Criteria andFirstWorkoffChangeuserGreaterThanOrEqualTo(Integer value) {
			addCriterion("FIRST_WORKOFF_CHANGEUSER >=", value, "firstWorkoffChangeuser");
			return (Criteria) this;
		}

		public Criteria andFirstWorkoffChangeuserLessThan(Integer value) {
			addCriterion("FIRST_WORKOFF_CHANGEUSER <", value, "firstWorkoffChangeuser");
			return (Criteria) this;
		}

		public Criteria andFirstWorkoffChangeuserLessThanOrEqualTo(Integer value) {
			addCriterion("FIRST_WORKOFF_CHANGEUSER <=", value, "firstWorkoffChangeuser");
			return (Criteria) this;
		}

		public Criteria andFirstWorkoffChangeuserIn(List<Integer> values) {
			addCriterion("FIRST_WORKOFF_CHANGEUSER in", values, "firstWorkoffChangeuser");
			return (Criteria) this;
		}

		public Criteria andFirstWorkoffChangeuserNotIn(List<Integer> values) {
			addCriterion("FIRST_WORKOFF_CHANGEUSER not in", values, "firstWorkoffChangeuser");
			return (Criteria) this;
		}

		public Criteria andFirstWorkoffChangeuserBetween(Integer value1, Integer value2) {
			addCriterion("FIRST_WORKOFF_CHANGEUSER between", value1, value2, "firstWorkoffChangeuser");
			return (Criteria) this;
		}

		public Criteria andFirstWorkoffChangeuserNotBetween(Integer value1, Integer value2) {
			addCriterion("FIRST_WORKOFF_CHANGEUSER not between", value1, value2, "firstWorkoffChangeuser");
			return (Criteria) this;
		}

		public Criteria andFirstWorkoffChangedeptIsNull() {
			addCriterion("FIRST_WORKOFF_CHANGEDEPT is null");
			return (Criteria) this;
		}

		public Criteria andFirstWorkoffChangedeptIsNotNull() {
			addCriterion("FIRST_WORKOFF_CHANGEDEPT is not null");
			return (Criteria) this;
		}

		public Criteria andFirstWorkoffChangedeptEqualTo(Integer value) {
			addCriterion("FIRST_WORKOFF_CHANGEDEPT =", value, "firstWorkoffChangedept");
			return (Criteria) this;
		}

		public Criteria andFirstWorkoffChangedeptNotEqualTo(Integer value) {
			addCriterion("FIRST_WORKOFF_CHANGEDEPT <>", value, "firstWorkoffChangedept");
			return (Criteria) this;
		}

		public Criteria andFirstWorkoffChangedeptGreaterThan(Integer value) {
			addCriterion("FIRST_WORKOFF_CHANGEDEPT >", value, "firstWorkoffChangedept");
			return (Criteria) this;
		}

		public Criteria andFirstWorkoffChangedeptGreaterThanOrEqualTo(Integer value) {
			addCriterion("FIRST_WORKOFF_CHANGEDEPT >=", value, "firstWorkoffChangedept");
			return (Criteria) this;
		}

		public Criteria andFirstWorkoffChangedeptLessThan(Integer value) {
			addCriterion("FIRST_WORKOFF_CHANGEDEPT <", value, "firstWorkoffChangedept");
			return (Criteria) this;
		}

		public Criteria andFirstWorkoffChangedeptLessThanOrEqualTo(Integer value) {
			addCriterion("FIRST_WORKOFF_CHANGEDEPT <=", value, "firstWorkoffChangedept");
			return (Criteria) this;
		}

		public Criteria andFirstWorkoffChangedeptIn(List<Integer> values) {
			addCriterion("FIRST_WORKOFF_CHANGEDEPT in", values, "firstWorkoffChangedept");
			return (Criteria) this;
		}

		public Criteria andFirstWorkoffChangedeptNotIn(List<Integer> values) {
			addCriterion("FIRST_WORKOFF_CHANGEDEPT not in", values, "firstWorkoffChangedept");
			return (Criteria) this;
		}

		public Criteria andFirstWorkoffChangedeptBetween(Integer value1, Integer value2) {
			addCriterion("FIRST_WORKOFF_CHANGEDEPT between", value1, value2, "firstWorkoffChangedept");
			return (Criteria) this;
		}

		public Criteria andFirstWorkoffChangedeptNotBetween(Integer value1, Integer value2) {
			addCriterion("FIRST_WORKOFF_CHANGEDEPT not between", value1, value2, "firstWorkoffChangedept");
			return (Criteria) this;
		}

		public Criteria andFirstWorkOfftimeIsNull() {
			addCriterion("FIRST_WORK_OFFTIME is null");
			return (Criteria) this;
		}

		public Criteria andFirstWorkOfftimeIsNotNull() {
			addCriterion("FIRST_WORK_OFFTIME is not null");
			return (Criteria) this;
		}

		public Criteria andFirstWorkOfftimeEqualTo(Date value) {
			addCriterion("FIRST_WORK_OFFTIME =", value, "firstWorkOfftime");
			return (Criteria) this;
		}

		public Criteria andFirstWorkOfftimeNotEqualTo(Date value) {
			addCriterion("FIRST_WORK_OFFTIME <>", value, "firstWorkOfftime");
			return (Criteria) this;
		}

		public Criteria andFirstWorkOfftimeGreaterThan(Date value) {
			addCriterion("FIRST_WORK_OFFTIME >", value, "firstWorkOfftime");
			return (Criteria) this;
		}

		public Criteria andFirstWorkOfftimeGreaterThanOrEqualTo(Date value) {
			addCriterion("FIRST_WORK_OFFTIME >=", value, "firstWorkOfftime");
			return (Criteria) this;
		}

		public Criteria andFirstWorkOfftimeLessThan(Date value) {
			addCriterion("FIRST_WORK_OFFTIME <", value, "firstWorkOfftime");
			return (Criteria) this;
		}

		public Criteria andFirstWorkOfftimeLessThanOrEqualTo(Date value) {
			addCriterion("FIRST_WORK_OFFTIME <=", value, "firstWorkOfftime");
			return (Criteria) this;
		}

		public Criteria andFirstWorkOfftimeIn(List<Date> values) {
			addCriterion("FIRST_WORK_OFFTIME in", values, "firstWorkOfftime");
			return (Criteria) this;
		}

		public Criteria andFirstWorkOfftimeNotIn(List<Date> values) {
			addCriterion("FIRST_WORK_OFFTIME not in", values, "firstWorkOfftime");
			return (Criteria) this;
		}

		public Criteria andFirstWorkOfftimeBetween(Date value1, Date value2) {
			addCriterion("FIRST_WORK_OFFTIME between", value1, value2, "firstWorkOfftime");
			return (Criteria) this;
		}

		public Criteria andFirstWorkOfftimeNotBetween(Date value1, Date value2) {
			addCriterion("FIRST_WORK_OFFTIME not between", value1, value2, "firstWorkOfftime");
			return (Criteria) this;
		}

		public Criteria andSecondWorkOffIsNull() {
			addCriterion("SECOND_WORK_OFF is null");
			return (Criteria) this;
		}

		public Criteria andSecondWorkOffIsNotNull() {
			addCriterion("SECOND_WORK_OFF is not null");
			return (Criteria) this;
		}

		public Criteria andSecondWorkOffEqualTo(Byte value) {
			addCriterion("SECOND_WORK_OFF =", value, "secondWorkOff");
			return (Criteria) this;
		}

		public Criteria andSecondWorkOffNotEqualTo(Byte value) {
			addCriterion("SECOND_WORK_OFF <>", value, "secondWorkOff");
			return (Criteria) this;
		}

		public Criteria andSecondWorkOffGreaterThan(Byte value) {
			addCriterion("SECOND_WORK_OFF >", value, "secondWorkOff");
			return (Criteria) this;
		}

		public Criteria andSecondWorkOffGreaterThanOrEqualTo(Byte value) {
			addCriterion("SECOND_WORK_OFF >=", value, "secondWorkOff");
			return (Criteria) this;
		}

		public Criteria andSecondWorkOffLessThan(Byte value) {
			addCriterion("SECOND_WORK_OFF <", value, "secondWorkOff");
			return (Criteria) this;
		}

		public Criteria andSecondWorkOffLessThanOrEqualTo(Byte value) {
			addCriterion("SECOND_WORK_OFF <=", value, "secondWorkOff");
			return (Criteria) this;
		}

		public Criteria andSecondWorkOffIn(List<Byte> values) {
			addCriterion("SECOND_WORK_OFF in", values, "secondWorkOff");
			return (Criteria) this;
		}

		public Criteria andSecondWorkOffNotIn(List<Byte> values) {
			addCriterion("SECOND_WORK_OFF not in", values, "secondWorkOff");
			return (Criteria) this;
		}

		public Criteria andSecondWorkOffBetween(Byte value1, Byte value2) {
			addCriterion("SECOND_WORK_OFF between", value1, value2, "secondWorkOff");
			return (Criteria) this;
		}

		public Criteria andSecondWorkOffNotBetween(Byte value1, Byte value2) {
			addCriterion("SECOND_WORK_OFF not between", value1, value2, "secondWorkOff");
			return (Criteria) this;
		}

		public Criteria andSecondWorkoffTypeIsNull() {
			addCriterion("SECOND_WORKOFF_TYPE is null");
			return (Criteria) this;
		}

		public Criteria andSecondWorkoffTypeIsNotNull() {
			addCriterion("SECOND_WORKOFF_TYPE is not null");
			return (Criteria) this;
		}

		public Criteria andSecondWorkoffTypeEqualTo(Byte value) {
			addCriterion("SECOND_WORKOFF_TYPE =", value, "secondWorkoffType");
			return (Criteria) this;
		}

		public Criteria andSecondWorkoffTypeNotEqualTo(Byte value) {
			addCriterion("SECOND_WORKOFF_TYPE <>", value, "secondWorkoffType");
			return (Criteria) this;
		}

		public Criteria andSecondWorkoffTypeGreaterThan(Byte value) {
			addCriterion("SECOND_WORKOFF_TYPE >", value, "secondWorkoffType");
			return (Criteria) this;
		}

		public Criteria andSecondWorkoffTypeGreaterThanOrEqualTo(Byte value) {
			addCriterion("SECOND_WORKOFF_TYPE >=", value, "secondWorkoffType");
			return (Criteria) this;
		}

		public Criteria andSecondWorkoffTypeLessThan(Byte value) {
			addCriterion("SECOND_WORKOFF_TYPE <", value, "secondWorkoffType");
			return (Criteria) this;
		}

		public Criteria andSecondWorkoffTypeLessThanOrEqualTo(Byte value) {
			addCriterion("SECOND_WORKOFF_TYPE <=", value, "secondWorkoffType");
			return (Criteria) this;
		}

		public Criteria andSecondWorkoffTypeIn(List<Byte> values) {
			addCriterion("SECOND_WORKOFF_TYPE in", values, "secondWorkoffType");
			return (Criteria) this;
		}

		public Criteria andSecondWorkoffTypeNotIn(List<Byte> values) {
			addCriterion("SECOND_WORKOFF_TYPE not in", values, "secondWorkoffType");
			return (Criteria) this;
		}

		public Criteria andSecondWorkoffTypeBetween(Byte value1, Byte value2) {
			addCriterion("SECOND_WORKOFF_TYPE between", value1, value2, "secondWorkoffType");
			return (Criteria) this;
		}

		public Criteria andSecondWorkoffTypeNotBetween(Byte value1, Byte value2) {
			addCriterion("SECOND_WORKOFF_TYPE not between", value1, value2, "secondWorkoffType");
			return (Criteria) this;
		}

		public Criteria andSecondWorkoffChangeuserIsNull() {
			addCriterion("SECOND_WORKOFF_CHANGEUSER is null");
			return (Criteria) this;
		}

		public Criteria andSecondWorkoffChangeuserIsNotNull() {
			addCriterion("SECOND_WORKOFF_CHANGEUSER is not null");
			return (Criteria) this;
		}

		public Criteria andSecondWorkoffChangeuserEqualTo(Integer value) {
			addCriterion("SECOND_WORKOFF_CHANGEUSER =", value, "secondWorkoffChangeuser");
			return (Criteria) this;
		}

		public Criteria andSecondWorkoffChangeuserNotEqualTo(Integer value) {
			addCriterion("SECOND_WORKOFF_CHANGEUSER <>", value, "secondWorkoffChangeuser");
			return (Criteria) this;
		}

		public Criteria andSecondWorkoffChangeuserGreaterThan(Integer value) {
			addCriterion("SECOND_WORKOFF_CHANGEUSER >", value, "secondWorkoffChangeuser");
			return (Criteria) this;
		}

		public Criteria andSecondWorkoffChangeuserGreaterThanOrEqualTo(Integer value) {
			addCriterion("SECOND_WORKOFF_CHANGEUSER >=", value, "secondWorkoffChangeuser");
			return (Criteria) this;
		}

		public Criteria andSecondWorkoffChangeuserLessThan(Integer value) {
			addCriterion("SECOND_WORKOFF_CHANGEUSER <", value, "secondWorkoffChangeuser");
			return (Criteria) this;
		}

		public Criteria andSecondWorkoffChangeuserLessThanOrEqualTo(Integer value) {
			addCriterion("SECOND_WORKOFF_CHANGEUSER <=", value, "secondWorkoffChangeuser");
			return (Criteria) this;
		}

		public Criteria andSecondWorkoffChangeuserIn(List<Integer> values) {
			addCriterion("SECOND_WORKOFF_CHANGEUSER in", values, "secondWorkoffChangeuser");
			return (Criteria) this;
		}

		public Criteria andSecondWorkoffChangeuserNotIn(List<Integer> values) {
			addCriterion("SECOND_WORKOFF_CHANGEUSER not in", values, "secondWorkoffChangeuser");
			return (Criteria) this;
		}

		public Criteria andSecondWorkoffChangeuserBetween(Integer value1, Integer value2) {
			addCriterion("SECOND_WORKOFF_CHANGEUSER between", value1, value2, "secondWorkoffChangeuser");
			return (Criteria) this;
		}

		public Criteria andSecondWorkoffChangeuserNotBetween(Integer value1, Integer value2) {
			addCriterion("SECOND_WORKOFF_CHANGEUSER not between", value1, value2, "secondWorkoffChangeuser");
			return (Criteria) this;
		}

		public Criteria andSecondWorkoffChangedeptIsNull() {
			addCriterion("SECOND_WORKOFF_CHANGEDEPT is null");
			return (Criteria) this;
		}

		public Criteria andSecondWorkoffChangedeptIsNotNull() {
			addCriterion("SECOND_WORKOFF_CHANGEDEPT is not null");
			return (Criteria) this;
		}

		public Criteria andSecondWorkoffChangedeptEqualTo(Integer value) {
			addCriterion("SECOND_WORKOFF_CHANGEDEPT =", value, "secondWorkoffChangedept");
			return (Criteria) this;
		}

		public Criteria andSecondWorkoffChangedeptNotEqualTo(Integer value) {
			addCriterion("SECOND_WORKOFF_CHANGEDEPT <>", value, "secondWorkoffChangedept");
			return (Criteria) this;
		}

		public Criteria andSecondWorkoffChangedeptGreaterThan(Integer value) {
			addCriterion("SECOND_WORKOFF_CHANGEDEPT >", value, "secondWorkoffChangedept");
			return (Criteria) this;
		}

		public Criteria andSecondWorkoffChangedeptGreaterThanOrEqualTo(Integer value) {
			addCriterion("SECOND_WORKOFF_CHANGEDEPT >=", value, "secondWorkoffChangedept");
			return (Criteria) this;
		}

		public Criteria andSecondWorkoffChangedeptLessThan(Integer value) {
			addCriterion("SECOND_WORKOFF_CHANGEDEPT <", value, "secondWorkoffChangedept");
			return (Criteria) this;
		}

		public Criteria andSecondWorkoffChangedeptLessThanOrEqualTo(Integer value) {
			addCriterion("SECOND_WORKOFF_CHANGEDEPT <=", value, "secondWorkoffChangedept");
			return (Criteria) this;
		}

		public Criteria andSecondWorkoffChangedeptIn(List<Integer> values) {
			addCriterion("SECOND_WORKOFF_CHANGEDEPT in", values, "secondWorkoffChangedept");
			return (Criteria) this;
		}

		public Criteria andSecondWorkoffChangedeptNotIn(List<Integer> values) {
			addCriterion("SECOND_WORKOFF_CHANGEDEPT not in", values, "secondWorkoffChangedept");
			return (Criteria) this;
		}

		public Criteria andSecondWorkoffChangedeptBetween(Integer value1, Integer value2) {
			addCriterion("SECOND_WORKOFF_CHANGEDEPT between", value1, value2, "secondWorkoffChangedept");
			return (Criteria) this;
		}

		public Criteria andSecondWorkoffChangedeptNotBetween(Integer value1, Integer value2) {
			addCriterion("SECOND_WORKOFF_CHANGEDEPT not between", value1, value2, "secondWorkoffChangedept");
			return (Criteria) this;
		}

		public Criteria andSecondWorkOfftimeIsNull() {
			addCriterion("SECOND_WORK_OFFTIME is null");
			return (Criteria) this;
		}

		public Criteria andSecondWorkOfftimeIsNotNull() {
			addCriterion("SECOND_WORK_OFFTIME is not null");
			return (Criteria) this;
		}

		public Criteria andSecondWorkOfftimeEqualTo(Date value) {
			addCriterion("SECOND_WORK_OFFTIME =", value, "secondWorkOfftime");
			return (Criteria) this;
		}

		public Criteria andSecondWorkOfftimeNotEqualTo(Date value) {
			addCriterion("SECOND_WORK_OFFTIME <>", value, "secondWorkOfftime");
			return (Criteria) this;
		}

		public Criteria andSecondWorkOfftimeGreaterThan(Date value) {
			addCriterion("SECOND_WORK_OFFTIME >", value, "secondWorkOfftime");
			return (Criteria) this;
		}

		public Criteria andSecondWorkOfftimeGreaterThanOrEqualTo(Date value) {
			addCriterion("SECOND_WORK_OFFTIME >=", value, "secondWorkOfftime");
			return (Criteria) this;
		}

		public Criteria andSecondWorkOfftimeLessThan(Date value) {
			addCriterion("SECOND_WORK_OFFTIME <", value, "secondWorkOfftime");
			return (Criteria) this;
		}

		public Criteria andSecondWorkOfftimeLessThanOrEqualTo(Date value) {
			addCriterion("SECOND_WORK_OFFTIME <=", value, "secondWorkOfftime");
			return (Criteria) this;
		}

		public Criteria andSecondWorkOfftimeIn(List<Date> values) {
			addCriterion("SECOND_WORK_OFFTIME in", values, "secondWorkOfftime");
			return (Criteria) this;
		}

		public Criteria andSecondWorkOfftimeNotIn(List<Date> values) {
			addCriterion("SECOND_WORK_OFFTIME not in", values, "secondWorkOfftime");
			return (Criteria) this;
		}

		public Criteria andSecondWorkOfftimeBetween(Date value1, Date value2) {
			addCriterion("SECOND_WORK_OFFTIME between", value1, value2, "secondWorkOfftime");
			return (Criteria) this;
		}

		public Criteria andSecondWorkOfftimeNotBetween(Date value1, Date value2) {
			addCriterion("SECOND_WORK_OFFTIME not between", value1, value2, "secondWorkOfftime");
			return (Criteria) this;
		}

		public Criteria andThreeWorkOffIsNull() {
			addCriterion("THREE_WORK_OFF is null");
			return (Criteria) this;
		}

		public Criteria andThreeWorkOffIsNotNull() {
			addCriterion("THREE_WORK_OFF is not null");
			return (Criteria) this;
		}

		public Criteria andThreeWorkOffEqualTo(Byte value) {
			addCriterion("THREE_WORK_OFF =", value, "threeWorkOff");
			return (Criteria) this;
		}

		public Criteria andThreeWorkOffNotEqualTo(Byte value) {
			addCriterion("THREE_WORK_OFF <>", value, "threeWorkOff");
			return (Criteria) this;
		}

		public Criteria andThreeWorkOffGreaterThan(Byte value) {
			addCriterion("THREE_WORK_OFF >", value, "threeWorkOff");
			return (Criteria) this;
		}

		public Criteria andThreeWorkOffGreaterThanOrEqualTo(Byte value) {
			addCriterion("THREE_WORK_OFF >=", value, "threeWorkOff");
			return (Criteria) this;
		}

		public Criteria andThreeWorkOffLessThan(Byte value) {
			addCriterion("THREE_WORK_OFF <", value, "threeWorkOff");
			return (Criteria) this;
		}

		public Criteria andThreeWorkOffLessThanOrEqualTo(Byte value) {
			addCriterion("THREE_WORK_OFF <=", value, "threeWorkOff");
			return (Criteria) this;
		}

		public Criteria andThreeWorkOffIn(List<Byte> values) {
			addCriterion("THREE_WORK_OFF in", values, "threeWorkOff");
			return (Criteria) this;
		}

		public Criteria andThreeWorkOffNotIn(List<Byte> values) {
			addCriterion("THREE_WORK_OFF not in", values, "threeWorkOff");
			return (Criteria) this;
		}

		public Criteria andThreeWorkOffBetween(Byte value1, Byte value2) {
			addCriterion("THREE_WORK_OFF between", value1, value2, "threeWorkOff");
			return (Criteria) this;
		}

		public Criteria andThreeWorkOffNotBetween(Byte value1, Byte value2) {
			addCriterion("THREE_WORK_OFF not between", value1, value2, "threeWorkOff");
			return (Criteria) this;
		}

		public Criteria andThreeWorkoffTypeIsNull() {
			addCriterion("THREE_WORKOFF_TYPE is null");
			return (Criteria) this;
		}

		public Criteria andThreeWorkoffTypeIsNotNull() {
			addCriterion("THREE_WORKOFF_TYPE is not null");
			return (Criteria) this;
		}

		public Criteria andThreeWorkoffTypeEqualTo(Byte value) {
			addCriterion("THREE_WORKOFF_TYPE =", value, "threeWorkoffType");
			return (Criteria) this;
		}

		public Criteria andThreeWorkoffTypeNotEqualTo(Byte value) {
			addCriterion("THREE_WORKOFF_TYPE <>", value, "threeWorkoffType");
			return (Criteria) this;
		}

		public Criteria andThreeWorkoffTypeGreaterThan(Byte value) {
			addCriterion("THREE_WORKOFF_TYPE >", value, "threeWorkoffType");
			return (Criteria) this;
		}

		public Criteria andThreeWorkoffTypeGreaterThanOrEqualTo(Byte value) {
			addCriterion("THREE_WORKOFF_TYPE >=", value, "threeWorkoffType");
			return (Criteria) this;
		}

		public Criteria andThreeWorkoffTypeLessThan(Byte value) {
			addCriterion("THREE_WORKOFF_TYPE <", value, "threeWorkoffType");
			return (Criteria) this;
		}

		public Criteria andThreeWorkoffTypeLessThanOrEqualTo(Byte value) {
			addCriterion("THREE_WORKOFF_TYPE <=", value, "threeWorkoffType");
			return (Criteria) this;
		}

		public Criteria andThreeWorkoffTypeIn(List<Byte> values) {
			addCriterion("THREE_WORKOFF_TYPE in", values, "threeWorkoffType");
			return (Criteria) this;
		}

		public Criteria andThreeWorkoffTypeNotIn(List<Byte> values) {
			addCriterion("THREE_WORKOFF_TYPE not in", values, "threeWorkoffType");
			return (Criteria) this;
		}

		public Criteria andThreeWorkoffTypeBetween(Byte value1, Byte value2) {
			addCriterion("THREE_WORKOFF_TYPE between", value1, value2, "threeWorkoffType");
			return (Criteria) this;
		}

		public Criteria andThreeWorkoffTypeNotBetween(Byte value1, Byte value2) {
			addCriterion("THREE_WORKOFF_TYPE not between", value1, value2, "threeWorkoffType");
			return (Criteria) this;
		}

		public Criteria andThreeWorkoffChangeuserIsNull() {
			addCriterion("THREE_WORKOFF_CHANGEUSER is null");
			return (Criteria) this;
		}

		public Criteria andThreeWorkoffChangeuserIsNotNull() {
			addCriterion("THREE_WORKOFF_CHANGEUSER is not null");
			return (Criteria) this;
		}

		public Criteria andThreeWorkoffChangeuserEqualTo(Integer value) {
			addCriterion("THREE_WORKOFF_CHANGEUSER =", value, "threeWorkoffChangeuser");
			return (Criteria) this;
		}

		public Criteria andThreeWorkoffChangeuserNotEqualTo(Integer value) {
			addCriterion("THREE_WORKOFF_CHANGEUSER <>", value, "threeWorkoffChangeuser");
			return (Criteria) this;
		}

		public Criteria andThreeWorkoffChangeuserGreaterThan(Integer value) {
			addCriterion("THREE_WORKOFF_CHANGEUSER >", value, "threeWorkoffChangeuser");
			return (Criteria) this;
		}

		public Criteria andThreeWorkoffChangeuserGreaterThanOrEqualTo(Integer value) {
			addCriterion("THREE_WORKOFF_CHANGEUSER >=", value, "threeWorkoffChangeuser");
			return (Criteria) this;
		}

		public Criteria andThreeWorkoffChangeuserLessThan(Integer value) {
			addCriterion("THREE_WORKOFF_CHANGEUSER <", value, "threeWorkoffChangeuser");
			return (Criteria) this;
		}

		public Criteria andThreeWorkoffChangeuserLessThanOrEqualTo(Integer value) {
			addCriterion("THREE_WORKOFF_CHANGEUSER <=", value, "threeWorkoffChangeuser");
			return (Criteria) this;
		}

		public Criteria andThreeWorkoffChangeuserIn(List<Integer> values) {
			addCriterion("THREE_WORKOFF_CHANGEUSER in", values, "threeWorkoffChangeuser");
			return (Criteria) this;
		}

		public Criteria andThreeWorkoffChangeuserNotIn(List<Integer> values) {
			addCriterion("THREE_WORKOFF_CHANGEUSER not in", values, "threeWorkoffChangeuser");
			return (Criteria) this;
		}

		public Criteria andThreeWorkoffChangeuserBetween(Integer value1, Integer value2) {
			addCriterion("THREE_WORKOFF_CHANGEUSER between", value1, value2, "threeWorkoffChangeuser");
			return (Criteria) this;
		}

		public Criteria andThreeWorkoffChangeuserNotBetween(Integer value1, Integer value2) {
			addCriterion("THREE_WORKOFF_CHANGEUSER not between", value1, value2, "threeWorkoffChangeuser");
			return (Criteria) this;
		}

		public Criteria andThreeWorkoffChangedeptIsNull() {
			addCriterion("THREE_WORKOFF_CHANGEDEPT is null");
			return (Criteria) this;
		}

		public Criteria andThreeWorkoffChangedeptIsNotNull() {
			addCriterion("THREE_WORKOFF_CHANGEDEPT is not null");
			return (Criteria) this;
		}

		public Criteria andThreeWorkoffChangedeptEqualTo(Integer value) {
			addCriterion("THREE_WORKOFF_CHANGEDEPT =", value, "threeWorkoffChangedept");
			return (Criteria) this;
		}

		public Criteria andThreeWorkoffChangedeptNotEqualTo(Integer value) {
			addCriterion("THREE_WORKOFF_CHANGEDEPT <>", value, "threeWorkoffChangedept");
			return (Criteria) this;
		}

		public Criteria andThreeWorkoffChangedeptGreaterThan(Integer value) {
			addCriterion("THREE_WORKOFF_CHANGEDEPT >", value, "threeWorkoffChangedept");
			return (Criteria) this;
		}

		public Criteria andThreeWorkoffChangedeptGreaterThanOrEqualTo(Integer value) {
			addCriterion("THREE_WORKOFF_CHANGEDEPT >=", value, "threeWorkoffChangedept");
			return (Criteria) this;
		}

		public Criteria andThreeWorkoffChangedeptLessThan(Integer value) {
			addCriterion("THREE_WORKOFF_CHANGEDEPT <", value, "threeWorkoffChangedept");
			return (Criteria) this;
		}

		public Criteria andThreeWorkoffChangedeptLessThanOrEqualTo(Integer value) {
			addCriterion("THREE_WORKOFF_CHANGEDEPT <=", value, "threeWorkoffChangedept");
			return (Criteria) this;
		}

		public Criteria andThreeWorkoffChangedeptIn(List<Integer> values) {
			addCriterion("THREE_WORKOFF_CHANGEDEPT in", values, "threeWorkoffChangedept");
			return (Criteria) this;
		}

		public Criteria andThreeWorkoffChangedeptNotIn(List<Integer> values) {
			addCriterion("THREE_WORKOFF_CHANGEDEPT not in", values, "threeWorkoffChangedept");
			return (Criteria) this;
		}

		public Criteria andThreeWorkoffChangedeptBetween(Integer value1, Integer value2) {
			addCriterion("THREE_WORKOFF_CHANGEDEPT between", value1, value2, "threeWorkoffChangedept");
			return (Criteria) this;
		}

		public Criteria andThreeWorkoffChangedeptNotBetween(Integer value1, Integer value2) {
			addCriterion("THREE_WORKOFF_CHANGEDEPT not between", value1, value2, "threeWorkoffChangedept");
			return (Criteria) this;
		}

		public Criteria andThreeWorkOfftimeIsNull() {
			addCriterion("THREE_WORK_OFFTIME is null");
			return (Criteria) this;
		}

		public Criteria andThreeWorkOfftimeIsNotNull() {
			addCriterion("THREE_WORK_OFFTIME is not null");
			return (Criteria) this;
		}

		public Criteria andThreeWorkOfftimeEqualTo(Date value) {
			addCriterion("THREE_WORK_OFFTIME =", value, "threeWorkOfftime");
			return (Criteria) this;
		}

		public Criteria andThreeWorkOfftimeNotEqualTo(Date value) {
			addCriterion("THREE_WORK_OFFTIME <>", value, "threeWorkOfftime");
			return (Criteria) this;
		}

		public Criteria andThreeWorkOfftimeGreaterThan(Date value) {
			addCriterion("THREE_WORK_OFFTIME >", value, "threeWorkOfftime");
			return (Criteria) this;
		}

		public Criteria andThreeWorkOfftimeGreaterThanOrEqualTo(Date value) {
			addCriterion("THREE_WORK_OFFTIME >=", value, "threeWorkOfftime");
			return (Criteria) this;
		}

		public Criteria andThreeWorkOfftimeLessThan(Date value) {
			addCriterion("THREE_WORK_OFFTIME <", value, "threeWorkOfftime");
			return (Criteria) this;
		}

		public Criteria andThreeWorkOfftimeLessThanOrEqualTo(Date value) {
			addCriterion("THREE_WORK_OFFTIME <=", value, "threeWorkOfftime");
			return (Criteria) this;
		}

		public Criteria andThreeWorkOfftimeIn(List<Date> values) {
			addCriterion("THREE_WORK_OFFTIME in", values, "threeWorkOfftime");
			return (Criteria) this;
		}

		public Criteria andThreeWorkOfftimeNotIn(List<Date> values) {
			addCriterion("THREE_WORK_OFFTIME not in", values, "threeWorkOfftime");
			return (Criteria) this;
		}

		public Criteria andThreeWorkOfftimeBetween(Date value1, Date value2) {
			addCriterion("THREE_WORK_OFFTIME between", value1, value2, "threeWorkOfftime");
			return (Criteria) this;
		}

		public Criteria andThreeWorkOfftimeNotBetween(Date value1, Date value2) {
			addCriterion("THREE_WORK_OFFTIME not between", value1, value2, "threeWorkOfftime");
			return (Criteria) this;
		}

		public Criteria andAttSumCountIsNull() {
			addCriterion("ATT_SUM_COUNT is null");
			return (Criteria) this;
		}

		public Criteria andAttSumCountIsNotNull() {
			addCriterion("ATT_SUM_COUNT is not null");
			return (Criteria) this;
		}

		public Criteria andAttSumCountEqualTo(Byte value) {
			addCriterion("ATT_SUM_COUNT =", value, "attSumCount");
			return (Criteria) this;
		}

		public Criteria andAttSumCountNotEqualTo(Byte value) {
			addCriterion("ATT_SUM_COUNT <>", value, "attSumCount");
			return (Criteria) this;
		}

		public Criteria andAttSumCountGreaterThan(Byte value) {
			addCriterion("ATT_SUM_COUNT >", value, "attSumCount");
			return (Criteria) this;
		}

		public Criteria andAttSumCountGreaterThanOrEqualTo(Byte value) {
			addCriterion("ATT_SUM_COUNT >=", value, "attSumCount");
			return (Criteria) this;
		}

		public Criteria andAttSumCountLessThan(Byte value) {
			addCriterion("ATT_SUM_COUNT <", value, "attSumCount");
			return (Criteria) this;
		}

		public Criteria andAttSumCountLessThanOrEqualTo(Byte value) {
			addCriterion("ATT_SUM_COUNT <=", value, "attSumCount");
			return (Criteria) this;
		}

		public Criteria andAttSumCountIn(List<Byte> values) {
			addCriterion("ATT_SUM_COUNT in", values, "attSumCount");
			return (Criteria) this;
		}

		public Criteria andAttSumCountNotIn(List<Byte> values) {
			addCriterion("ATT_SUM_COUNT not in", values, "attSumCount");
			return (Criteria) this;
		}

		public Criteria andAttSumCountBetween(Byte value1, Byte value2) {
			addCriterion("ATT_SUM_COUNT between", value1, value2, "attSumCount");
			return (Criteria) this;
		}

		public Criteria andAttSumCountNotBetween(Byte value1, Byte value2) {
			addCriterion("ATT_SUM_COUNT not between", value1, value2, "attSumCount");
			return (Criteria) this;
		}

		public Criteria andFirstWorkonChangeremarkIsNull() {
			addCriterion("FIRST_WORKON_CHANGEREMARK is null");
			return (Criteria) this;
		}

		public Criteria andFirstWorkonChangeremarkIsNotNull() {
			addCriterion("FIRST_WORKON_CHANGEREMARK is not null");
			return (Criteria) this;
		}

		public Criteria andFirstWorkonChangeremarkEqualTo(String value) {
			addCriterion("FIRST_WORKON_CHANGEREMARK =", value, "firstWorkonChangeremark");
			return (Criteria) this;
		}

		public Criteria andFirstWorkonChangeremarkNotEqualTo(String value) {
			addCriterion("FIRST_WORKON_CHANGEREMARK <>", value, "firstWorkonChangeremark");
			return (Criteria) this;
		}

		public Criteria andFirstWorkonChangeremarkGreaterThan(String value) {
			addCriterion("FIRST_WORKON_CHANGEREMARK >", value, "firstWorkonChangeremark");
			return (Criteria) this;
		}

		public Criteria andFirstWorkonChangeremarkGreaterThanOrEqualTo(String value) {
			addCriterion("FIRST_WORKON_CHANGEREMARK >=", value, "firstWorkonChangeremark");
			return (Criteria) this;
		}

		public Criteria andFirstWorkonChangeremarkLessThan(String value) {
			addCriterion("FIRST_WORKON_CHANGEREMARK <", value, "firstWorkonChangeremark");
			return (Criteria) this;
		}

		public Criteria andFirstWorkonChangeremarkLessThanOrEqualTo(String value) {
			addCriterion("FIRST_WORKON_CHANGEREMARK <=", value, "firstWorkonChangeremark");
			return (Criteria) this;
		}

		public Criteria andFirstWorkonChangeremarkLike(String value) {
			addCriterion("FIRST_WORKON_CHANGEREMARK like", value, "firstWorkonChangeremark");
			return (Criteria) this;
		}

		public Criteria andFirstWorkonChangeremarkNotLike(String value) {
			addCriterion("FIRST_WORKON_CHANGEREMARK not like", value, "firstWorkonChangeremark");
			return (Criteria) this;
		}

		public Criteria andFirstWorkonChangeremarkIn(List<String> values) {
			addCriterion("FIRST_WORKON_CHANGEREMARK in", values, "firstWorkonChangeremark");
			return (Criteria) this;
		}

		public Criteria andFirstWorkonChangeremarkNotIn(List<String> values) {
			addCriterion("FIRST_WORKON_CHANGEREMARK not in", values, "firstWorkonChangeremark");
			return (Criteria) this;
		}

		public Criteria andFirstWorkonChangeremarkBetween(String value1, String value2) {
			addCriterion("FIRST_WORKON_CHANGEREMARK between", value1, value2, "firstWorkonChangeremark");
			return (Criteria) this;
		}

		public Criteria andFirstWorkonChangeremarkNotBetween(String value1, String value2) {
			addCriterion("FIRST_WORKON_CHANGEREMARK not between", value1, value2, "firstWorkonChangeremark");
			return (Criteria) this;
		}

		public Criteria andSecondWorkonChangeremarkIsNull() {
			addCriterion("SECOND_WORKON_CHANGEREMARK is null");
			return (Criteria) this;
		}

		public Criteria andSecondWorkonChangeremarkIsNotNull() {
			addCriterion("SECOND_WORKON_CHANGEREMARK is not null");
			return (Criteria) this;
		}

		public Criteria andSecondWorkonChangeremarkEqualTo(String value) {
			addCriterion("SECOND_WORKON_CHANGEREMARK =", value, "secondWorkonChangeremark");
			return (Criteria) this;
		}

		public Criteria andSecondWorkonChangeremarkNotEqualTo(String value) {
			addCriterion("SECOND_WORKON_CHANGEREMARK <>", value, "secondWorkonChangeremark");
			return (Criteria) this;
		}

		public Criteria andSecondWorkonChangeremarkGreaterThan(String value) {
			addCriterion("SECOND_WORKON_CHANGEREMARK >", value, "secondWorkonChangeremark");
			return (Criteria) this;
		}

		public Criteria andSecondWorkonChangeremarkGreaterThanOrEqualTo(String value) {
			addCriterion("SECOND_WORKON_CHANGEREMARK >=", value, "secondWorkonChangeremark");
			return (Criteria) this;
		}

		public Criteria andSecondWorkonChangeremarkLessThan(String value) {
			addCriterion("SECOND_WORKON_CHANGEREMARK <", value, "secondWorkonChangeremark");
			return (Criteria) this;
		}

		public Criteria andSecondWorkonChangeremarkLessThanOrEqualTo(String value) {
			addCriterion("SECOND_WORKON_CHANGEREMARK <=", value, "secondWorkonChangeremark");
			return (Criteria) this;
		}

		public Criteria andSecondWorkonChangeremarkLike(String value) {
			addCriterion("SECOND_WORKON_CHANGEREMARK like", value, "secondWorkonChangeremark");
			return (Criteria) this;
		}

		public Criteria andSecondWorkonChangeremarkNotLike(String value) {
			addCriterion("SECOND_WORKON_CHANGEREMARK not like", value, "secondWorkonChangeremark");
			return (Criteria) this;
		}

		public Criteria andSecondWorkonChangeremarkIn(List<String> values) {
			addCriterion("SECOND_WORKON_CHANGEREMARK in", values, "secondWorkonChangeremark");
			return (Criteria) this;
		}

		public Criteria andSecondWorkonChangeremarkNotIn(List<String> values) {
			addCriterion("SECOND_WORKON_CHANGEREMARK not in", values, "secondWorkonChangeremark");
			return (Criteria) this;
		}

		public Criteria andSecondWorkonChangeremarkBetween(String value1, String value2) {
			addCriterion("SECOND_WORKON_CHANGEREMARK between", value1, value2, "secondWorkonChangeremark");
			return (Criteria) this;
		}

		public Criteria andSecondWorkonChangeremarkNotBetween(String value1, String value2) {
			addCriterion("SECOND_WORKON_CHANGEREMARK not between", value1, value2, "secondWorkonChangeremark");
			return (Criteria) this;
		}

		public Criteria andThreeWorkonChangeremarkIsNull() {
			addCriterion("THREE_WORKON_CHANGEREMARK is null");
			return (Criteria) this;
		}

		public Criteria andThreeWorkonChangeremarkIsNotNull() {
			addCriterion("THREE_WORKON_CHANGEREMARK is not null");
			return (Criteria) this;
		}

		public Criteria andThreeWorkonChangeremarkEqualTo(String value) {
			addCriterion("THREE_WORKON_CHANGEREMARK =", value, "threeWorkonChangeremark");
			return (Criteria) this;
		}

		public Criteria andThreeWorkonChangeremarkNotEqualTo(String value) {
			addCriterion("THREE_WORKON_CHANGEREMARK <>", value, "threeWorkonChangeremark");
			return (Criteria) this;
		}

		public Criteria andThreeWorkonChangeremarkGreaterThan(String value) {
			addCriterion("THREE_WORKON_CHANGEREMARK >", value, "threeWorkonChangeremark");
			return (Criteria) this;
		}

		public Criteria andThreeWorkonChangeremarkGreaterThanOrEqualTo(String value) {
			addCriterion("THREE_WORKON_CHANGEREMARK >=", value, "threeWorkonChangeremark");
			return (Criteria) this;
		}

		public Criteria andThreeWorkonChangeremarkLessThan(String value) {
			addCriterion("THREE_WORKON_CHANGEREMARK <", value, "threeWorkonChangeremark");
			return (Criteria) this;
		}

		public Criteria andThreeWorkonChangeremarkLessThanOrEqualTo(String value) {
			addCriterion("THREE_WORKON_CHANGEREMARK <=", value, "threeWorkonChangeremark");
			return (Criteria) this;
		}

		public Criteria andThreeWorkonChangeremarkLike(String value) {
			addCriterion("THREE_WORKON_CHANGEREMARK like", value, "threeWorkonChangeremark");
			return (Criteria) this;
		}

		public Criteria andThreeWorkonChangeremarkNotLike(String value) {
			addCriterion("THREE_WORKON_CHANGEREMARK not like", value, "threeWorkonChangeremark");
			return (Criteria) this;
		}

		public Criteria andThreeWorkonChangeremarkIn(List<String> values) {
			addCriterion("THREE_WORKON_CHANGEREMARK in", values, "threeWorkonChangeremark");
			return (Criteria) this;
		}

		public Criteria andThreeWorkonChangeremarkNotIn(List<String> values) {
			addCriterion("THREE_WORKON_CHANGEREMARK not in", values, "threeWorkonChangeremark");
			return (Criteria) this;
		}

		public Criteria andThreeWorkonChangeremarkBetween(String value1, String value2) {
			addCriterion("THREE_WORKON_CHANGEREMARK between", value1, value2, "threeWorkonChangeremark");
			return (Criteria) this;
		}

		public Criteria andThreeWorkonChangeremarkNotBetween(String value1, String value2) {
			addCriterion("THREE_WORKON_CHANGEREMARK not between", value1, value2, "threeWorkonChangeremark");
			return (Criteria) this;
		}

		public Criteria andFirstWorkoffChangeremarkIsNull() {
			addCriterion("FIRST_WORKOFF_CHANGEREMARK is null");
			return (Criteria) this;
		}

		public Criteria andFirstWorkoffChangeremarkIsNotNull() {
			addCriterion("FIRST_WORKOFF_CHANGEREMARK is not null");
			return (Criteria) this;
		}

		public Criteria andFirstWorkoffChangeremarkEqualTo(String value) {
			addCriterion("FIRST_WORKOFF_CHANGEREMARK =", value, "firstWorkoffChangeremark");
			return (Criteria) this;
		}

		public Criteria andFirstWorkoffChangeremarkNotEqualTo(String value) {
			addCriterion("FIRST_WORKOFF_CHANGEREMARK <>", value, "firstWorkoffChangeremark");
			return (Criteria) this;
		}

		public Criteria andFirstWorkoffChangeremarkGreaterThan(String value) {
			addCriterion("FIRST_WORKOFF_CHANGEREMARK >", value, "firstWorkoffChangeremark");
			return (Criteria) this;
		}

		public Criteria andFirstWorkoffChangeremarkGreaterThanOrEqualTo(String value) {
			addCriterion("FIRST_WORKOFF_CHANGEREMARK >=", value, "firstWorkoffChangeremark");
			return (Criteria) this;
		}

		public Criteria andFirstWorkoffChangeremarkLessThan(String value) {
			addCriterion("FIRST_WORKOFF_CHANGEREMARK <", value, "firstWorkoffChangeremark");
			return (Criteria) this;
		}

		public Criteria andFirstWorkoffChangeremarkLessThanOrEqualTo(String value) {
			addCriterion("FIRST_WORKOFF_CHANGEREMARK <=", value, "firstWorkoffChangeremark");
			return (Criteria) this;
		}

		public Criteria andFirstWorkoffChangeremarkLike(String value) {
			addCriterion("FIRST_WORKOFF_CHANGEREMARK like", value, "firstWorkoffChangeremark");
			return (Criteria) this;
		}

		public Criteria andFirstWorkoffChangeremarkNotLike(String value) {
			addCriterion("FIRST_WORKOFF_CHANGEREMARK not like", value, "firstWorkoffChangeremark");
			return (Criteria) this;
		}

		public Criteria andFirstWorkoffChangeremarkIn(List<String> values) {
			addCriterion("FIRST_WORKOFF_CHANGEREMARK in", values, "firstWorkoffChangeremark");
			return (Criteria) this;
		}

		public Criteria andFirstWorkoffChangeremarkNotIn(List<String> values) {
			addCriterion("FIRST_WORKOFF_CHANGEREMARK not in", values, "firstWorkoffChangeremark");
			return (Criteria) this;
		}

		public Criteria andFirstWorkoffChangeremarkBetween(String value1, String value2) {
			addCriterion("FIRST_WORKOFF_CHANGEREMARK between", value1, value2, "firstWorkoffChangeremark");
			return (Criteria) this;
		}

		public Criteria andFirstWorkoffChangeremarkNotBetween(String value1, String value2) {
			addCriterion("FIRST_WORKOFF_CHANGEREMARK not between", value1, value2, "firstWorkoffChangeremark");
			return (Criteria) this;
		}

		public Criteria andSecondWorkoffChangeremarkIsNull() {
			addCriterion("SECOND_WORKOFF_CHANGEREMARK is null");
			return (Criteria) this;
		}

		public Criteria andSecondWorkoffChangeremarkIsNotNull() {
			addCriterion("SECOND_WORKOFF_CHANGEREMARK is not null");
			return (Criteria) this;
		}

		public Criteria andSecondWorkoffChangeremarkEqualTo(String value) {
			addCriterion("SECOND_WORKOFF_CHANGEREMARK =", value, "secondWorkoffChangeremark");
			return (Criteria) this;
		}

		public Criteria andSecondWorkoffChangeremarkNotEqualTo(String value) {
			addCriterion("SECOND_WORKOFF_CHANGEREMARK <>", value, "secondWorkoffChangeremark");
			return (Criteria) this;
		}

		public Criteria andSecondWorkoffChangeremarkGreaterThan(String value) {
			addCriterion("SECOND_WORKOFF_CHANGEREMARK >", value, "secondWorkoffChangeremark");
			return (Criteria) this;
		}

		public Criteria andSecondWorkoffChangeremarkGreaterThanOrEqualTo(String value) {
			addCriterion("SECOND_WORKOFF_CHANGEREMARK >=", value, "secondWorkoffChangeremark");
			return (Criteria) this;
		}

		public Criteria andSecondWorkoffChangeremarkLessThan(String value) {
			addCriterion("SECOND_WORKOFF_CHANGEREMARK <", value, "secondWorkoffChangeremark");
			return (Criteria) this;
		}

		public Criteria andSecondWorkoffChangeremarkLessThanOrEqualTo(String value) {
			addCriterion("SECOND_WORKOFF_CHANGEREMARK <=", value, "secondWorkoffChangeremark");
			return (Criteria) this;
		}

		public Criteria andSecondWorkoffChangeremarkLike(String value) {
			addCriterion("SECOND_WORKOFF_CHANGEREMARK like", value, "secondWorkoffChangeremark");
			return (Criteria) this;
		}

		public Criteria andSecondWorkoffChangeremarkNotLike(String value) {
			addCriterion("SECOND_WORKOFF_CHANGEREMARK not like", value, "secondWorkoffChangeremark");
			return (Criteria) this;
		}

		public Criteria andSecondWorkoffChangeremarkIn(List<String> values) {
			addCriterion("SECOND_WORKOFF_CHANGEREMARK in", values, "secondWorkoffChangeremark");
			return (Criteria) this;
		}

		public Criteria andSecondWorkoffChangeremarkNotIn(List<String> values) {
			addCriterion("SECOND_WORKOFF_CHANGEREMARK not in", values, "secondWorkoffChangeremark");
			return (Criteria) this;
		}

		public Criteria andSecondWorkoffChangeremarkBetween(String value1, String value2) {
			addCriterion("SECOND_WORKOFF_CHANGEREMARK between", value1, value2, "secondWorkoffChangeremark");
			return (Criteria) this;
		}

		public Criteria andSecondWorkoffChangeremarkNotBetween(String value1, String value2) {
			addCriterion("SECOND_WORKOFF_CHANGEREMARK not between", value1, value2, "secondWorkoffChangeremark");
			return (Criteria) this;
		}

		public Criteria andThreeWorkoffChangeremarkIsNull() {
			addCriterion("THREE_WORKOFF_CHANGEREMARK is null");
			return (Criteria) this;
		}

		public Criteria andThreeWorkoffChangeremarkIsNotNull() {
			addCriterion("THREE_WORKOFF_CHANGEREMARK is not null");
			return (Criteria) this;
		}

		public Criteria andThreeWorkoffChangeremarkEqualTo(String value) {
			addCriterion("THREE_WORKOFF_CHANGEREMARK =", value, "threeWorkoffChangeremark");
			return (Criteria) this;
		}

		public Criteria andThreeWorkoffChangeremarkNotEqualTo(String value) {
			addCriterion("THREE_WORKOFF_CHANGEREMARK <>", value, "threeWorkoffChangeremark");
			return (Criteria) this;
		}

		public Criteria andThreeWorkoffChangeremarkGreaterThan(String value) {
			addCriterion("THREE_WORKOFF_CHANGEREMARK >", value, "threeWorkoffChangeremark");
			return (Criteria) this;
		}

		public Criteria andThreeWorkoffChangeremarkGreaterThanOrEqualTo(String value) {
			addCriterion("THREE_WORKOFF_CHANGEREMARK >=", value, "threeWorkoffChangeremark");
			return (Criteria) this;
		}

		public Criteria andThreeWorkoffChangeremarkLessThan(String value) {
			addCriterion("THREE_WORKOFF_CHANGEREMARK <", value, "threeWorkoffChangeremark");
			return (Criteria) this;
		}

		public Criteria andThreeWorkoffChangeremarkLessThanOrEqualTo(String value) {
			addCriterion("THREE_WORKOFF_CHANGEREMARK <=", value, "threeWorkoffChangeremark");
			return (Criteria) this;
		}

		public Criteria andThreeWorkoffChangeremarkLike(String value) {
			addCriterion("THREE_WORKOFF_CHANGEREMARK like", value, "threeWorkoffChangeremark");
			return (Criteria) this;
		}

		public Criteria andThreeWorkoffChangeremarkNotLike(String value) {
			addCriterion("THREE_WORKOFF_CHANGEREMARK not like", value, "threeWorkoffChangeremark");
			return (Criteria) this;
		}

		public Criteria andThreeWorkoffChangeremarkIn(List<String> values) {
			addCriterion("THREE_WORKOFF_CHANGEREMARK in", values, "threeWorkoffChangeremark");
			return (Criteria) this;
		}

		public Criteria andThreeWorkoffChangeremarkNotIn(List<String> values) {
			addCriterion("THREE_WORKOFF_CHANGEREMARK not in", values, "threeWorkoffChangeremark");
			return (Criteria) this;
		}

		public Criteria andThreeWorkoffChangeremarkBetween(String value1, String value2) {
			addCriterion("THREE_WORKOFF_CHANGEREMARK between", value1, value2, "threeWorkoffChangeremark");
			return (Criteria) this;
		}

		public Criteria andThreeWorkoffChangeremarkNotBetween(String value1, String value2) {
			addCriterion("THREE_WORKOFF_CHANGEREMARK not between", value1, value2, "threeWorkoffChangeremark");
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

		public Criteria andFirstWorkOnconfigtimeIsNull() {
			addCriterion("FIRST_WORK_ONCONFIGTIME is null");
			return (Criteria) this;
		}

		public Criteria andFirstWorkOnconfigtimeIsNotNull() {
			addCriterion("FIRST_WORK_ONCONFIGTIME is not null");
			return (Criteria) this;
		}

		public Criteria andFirstWorkOnconfigtimeEqualTo(String value) {
			addCriterion("FIRST_WORK_ONCONFIGTIME =", value, "firstWorkOnconfigtime");
			return (Criteria) this;
		}

		public Criteria andFirstWorkOnconfigtimeNotEqualTo(String value) {
			addCriterion("FIRST_WORK_ONCONFIGTIME <>", value, "firstWorkOnconfigtime");
			return (Criteria) this;
		}

		public Criteria andFirstWorkOnconfigtimeGreaterThan(String value) {
			addCriterion("FIRST_WORK_ONCONFIGTIME >", value, "firstWorkOnconfigtime");
			return (Criteria) this;
		}

		public Criteria andFirstWorkOnconfigtimeGreaterThanOrEqualTo(String value) {
			addCriterion("FIRST_WORK_ONCONFIGTIME >=", value, "firstWorkOnconfigtime");
			return (Criteria) this;
		}

		public Criteria andFirstWorkOnconfigtimeLessThan(String value) {
			addCriterion("FIRST_WORK_ONCONFIGTIME <", value, "firstWorkOnconfigtime");
			return (Criteria) this;
		}

		public Criteria andFirstWorkOnconfigtimeLessThanOrEqualTo(String value) {
			addCriterion("FIRST_WORK_ONCONFIGTIME <=", value, "firstWorkOnconfigtime");
			return (Criteria) this;
		}

		public Criteria andFirstWorkOnconfigtimeLike(String value) {
			addCriterion("FIRST_WORK_ONCONFIGTIME like", value, "firstWorkOnconfigtime");
			return (Criteria) this;
		}

		public Criteria andFirstWorkOnconfigtimeNotLike(String value) {
			addCriterion("FIRST_WORK_ONCONFIGTIME not like", value, "firstWorkOnconfigtime");
			return (Criteria) this;
		}

		public Criteria andFirstWorkOnconfigtimeIn(List<String> values) {
			addCriterion("FIRST_WORK_ONCONFIGTIME in", values, "firstWorkOnconfigtime");
			return (Criteria) this;
		}

		public Criteria andFirstWorkOnconfigtimeNotIn(List<String> values) {
			addCriterion("FIRST_WORK_ONCONFIGTIME not in", values, "firstWorkOnconfigtime");
			return (Criteria) this;
		}

		public Criteria andFirstWorkOnconfigtimeBetween(String value1, String value2) {
			addCriterion("FIRST_WORK_ONCONFIGTIME between", value1, value2, "firstWorkOnconfigtime");
			return (Criteria) this;
		}

		public Criteria andFirstWorkOnconfigtimeNotBetween(String value1, String value2) {
			addCriterion("FIRST_WORK_ONCONFIGTIME not between", value1, value2, "firstWorkOnconfigtime");
			return (Criteria) this;
		}

		public Criteria andFirstWorkOffconfigtimeIsNull() {
			addCriterion("FIRST_WORK_OFFCONFIGTIME is null");
			return (Criteria) this;
		}

		public Criteria andFirstWorkOffconfigtimeIsNotNull() {
			addCriterion("FIRST_WORK_OFFCONFIGTIME is not null");
			return (Criteria) this;
		}

		public Criteria andFirstWorkOffconfigtimeEqualTo(String value) {
			addCriterion("FIRST_WORK_OFFCONFIGTIME =", value, "firstWorkOffconfigtime");
			return (Criteria) this;
		}

		public Criteria andFirstWorkOffconfigtimeNotEqualTo(String value) {
			addCriterion("FIRST_WORK_OFFCONFIGTIME <>", value, "firstWorkOffconfigtime");
			return (Criteria) this;
		}

		public Criteria andFirstWorkOffconfigtimeGreaterThan(String value) {
			addCriterion("FIRST_WORK_OFFCONFIGTIME >", value, "firstWorkOffconfigtime");
			return (Criteria) this;
		}

		public Criteria andFirstWorkOffconfigtimeGreaterThanOrEqualTo(String value) {
			addCriterion("FIRST_WORK_OFFCONFIGTIME >=", value, "firstWorkOffconfigtime");
			return (Criteria) this;
		}

		public Criteria andFirstWorkOffconfigtimeLessThan(String value) {
			addCriterion("FIRST_WORK_OFFCONFIGTIME <", value, "firstWorkOffconfigtime");
			return (Criteria) this;
		}

		public Criteria andFirstWorkOffconfigtimeLessThanOrEqualTo(String value) {
			addCriterion("FIRST_WORK_OFFCONFIGTIME <=", value, "firstWorkOffconfigtime");
			return (Criteria) this;
		}

		public Criteria andFirstWorkOffconfigtimeLike(String value) {
			addCriterion("FIRST_WORK_OFFCONFIGTIME like", value, "firstWorkOffconfigtime");
			return (Criteria) this;
		}

		public Criteria andFirstWorkOffconfigtimeNotLike(String value) {
			addCriterion("FIRST_WORK_OFFCONFIGTIME not like", value, "firstWorkOffconfigtime");
			return (Criteria) this;
		}

		public Criteria andFirstWorkOffconfigtimeIn(List<String> values) {
			addCriterion("FIRST_WORK_OFFCONFIGTIME in", values, "firstWorkOffconfigtime");
			return (Criteria) this;
		}

		public Criteria andFirstWorkOffconfigtimeNotIn(List<String> values) {
			addCriterion("FIRST_WORK_OFFCONFIGTIME not in", values, "firstWorkOffconfigtime");
			return (Criteria) this;
		}

		public Criteria andFirstWorkOffconfigtimeBetween(String value1, String value2) {
			addCriterion("FIRST_WORK_OFFCONFIGTIME between", value1, value2, "firstWorkOffconfigtime");
			return (Criteria) this;
		}

		public Criteria andFirstWorkOffconfigtimeNotBetween(String value1, String value2) {
			addCriterion("FIRST_WORK_OFFCONFIGTIME not between", value1, value2, "firstWorkOffconfigtime");
			return (Criteria) this;
		}

		public Criteria andSecondWorkOnconfigtimeIsNull() {
			addCriterion("SECOND_WORK_ONCONFIGTIME is null");
			return (Criteria) this;
		}

		public Criteria andSecondWorkOnconfigtimeIsNotNull() {
			addCriterion("SECOND_WORK_ONCONFIGTIME is not null");
			return (Criteria) this;
		}

		public Criteria andSecondWorkOnconfigtimeEqualTo(String value) {
			addCriterion("SECOND_WORK_ONCONFIGTIME =", value, "secondWorkOnconfigtime");
			return (Criteria) this;
		}

		public Criteria andSecondWorkOnconfigtimeNotEqualTo(String value) {
			addCriterion("SECOND_WORK_ONCONFIGTIME <>", value, "secondWorkOnconfigtime");
			return (Criteria) this;
		}

		public Criteria andSecondWorkOnconfigtimeGreaterThan(String value) {
			addCriterion("SECOND_WORK_ONCONFIGTIME >", value, "secondWorkOnconfigtime");
			return (Criteria) this;
		}

		public Criteria andSecondWorkOnconfigtimeGreaterThanOrEqualTo(String value) {
			addCriterion("SECOND_WORK_ONCONFIGTIME >=", value, "secondWorkOnconfigtime");
			return (Criteria) this;
		}

		public Criteria andSecondWorkOnconfigtimeLessThan(String value) {
			addCriterion("SECOND_WORK_ONCONFIGTIME <", value, "secondWorkOnconfigtime");
			return (Criteria) this;
		}

		public Criteria andSecondWorkOnconfigtimeLessThanOrEqualTo(String value) {
			addCriterion("SECOND_WORK_ONCONFIGTIME <=", value, "secondWorkOnconfigtime");
			return (Criteria) this;
		}

		public Criteria andSecondWorkOnconfigtimeLike(String value) {
			addCriterion("SECOND_WORK_ONCONFIGTIME like", value, "secondWorkOnconfigtime");
			return (Criteria) this;
		}

		public Criteria andSecondWorkOnconfigtimeNotLike(String value) {
			addCriterion("SECOND_WORK_ONCONFIGTIME not like", value, "secondWorkOnconfigtime");
			return (Criteria) this;
		}

		public Criteria andSecondWorkOnconfigtimeIn(List<String> values) {
			addCriterion("SECOND_WORK_ONCONFIGTIME in", values, "secondWorkOnconfigtime");
			return (Criteria) this;
		}

		public Criteria andSecondWorkOnconfigtimeNotIn(List<String> values) {
			addCriterion("SECOND_WORK_ONCONFIGTIME not in", values, "secondWorkOnconfigtime");
			return (Criteria) this;
		}

		public Criteria andSecondWorkOnconfigtimeBetween(String value1, String value2) {
			addCriterion("SECOND_WORK_ONCONFIGTIME between", value1, value2, "secondWorkOnconfigtime");
			return (Criteria) this;
		}

		public Criteria andSecondWorkOnconfigtimeNotBetween(String value1, String value2) {
			addCriterion("SECOND_WORK_ONCONFIGTIME not between", value1, value2, "secondWorkOnconfigtime");
			return (Criteria) this;
		}

		public Criteria andSecondWorkOffconfigtimeIsNull() {
			addCriterion("SECOND_WORK_OFFCONFIGTIME is null");
			return (Criteria) this;
		}

		public Criteria andSecondWorkOffconfigtimeIsNotNull() {
			addCriterion("SECOND_WORK_OFFCONFIGTIME is not null");
			return (Criteria) this;
		}

		public Criteria andSecondWorkOffconfigtimeEqualTo(String value) {
			addCriterion("SECOND_WORK_OFFCONFIGTIME =", value, "secondWorkOffconfigtime");
			return (Criteria) this;
		}

		public Criteria andSecondWorkOffconfigtimeNotEqualTo(String value) {
			addCriterion("SECOND_WORK_OFFCONFIGTIME <>", value, "secondWorkOffconfigtime");
			return (Criteria) this;
		}

		public Criteria andSecondWorkOffconfigtimeGreaterThan(String value) {
			addCriterion("SECOND_WORK_OFFCONFIGTIME >", value, "secondWorkOffconfigtime");
			return (Criteria) this;
		}

		public Criteria andSecondWorkOffconfigtimeGreaterThanOrEqualTo(String value) {
			addCriterion("SECOND_WORK_OFFCONFIGTIME >=", value, "secondWorkOffconfigtime");
			return (Criteria) this;
		}

		public Criteria andSecondWorkOffconfigtimeLessThan(String value) {
			addCriterion("SECOND_WORK_OFFCONFIGTIME <", value, "secondWorkOffconfigtime");
			return (Criteria) this;
		}

		public Criteria andSecondWorkOffconfigtimeLessThanOrEqualTo(String value) {
			addCriterion("SECOND_WORK_OFFCONFIGTIME <=", value, "secondWorkOffconfigtime");
			return (Criteria) this;
		}

		public Criteria andSecondWorkOffconfigtimeLike(String value) {
			addCriterion("SECOND_WORK_OFFCONFIGTIME like", value, "secondWorkOffconfigtime");
			return (Criteria) this;
		}

		public Criteria andSecondWorkOffconfigtimeNotLike(String value) {
			addCriterion("SECOND_WORK_OFFCONFIGTIME not like", value, "secondWorkOffconfigtime");
			return (Criteria) this;
		}

		public Criteria andSecondWorkOffconfigtimeIn(List<String> values) {
			addCriterion("SECOND_WORK_OFFCONFIGTIME in", values, "secondWorkOffconfigtime");
			return (Criteria) this;
		}

		public Criteria andSecondWorkOffconfigtimeNotIn(List<String> values) {
			addCriterion("SECOND_WORK_OFFCONFIGTIME not in", values, "secondWorkOffconfigtime");
			return (Criteria) this;
		}

		public Criteria andSecondWorkOffconfigtimeBetween(String value1, String value2) {
			addCriterion("SECOND_WORK_OFFCONFIGTIME between", value1, value2, "secondWorkOffconfigtime");
			return (Criteria) this;
		}

		public Criteria andSecondWorkOffconfigtimeNotBetween(String value1, String value2) {
			addCriterion("SECOND_WORK_OFFCONFIGTIME not between", value1, value2, "secondWorkOffconfigtime");
			return (Criteria) this;
		}

		public Criteria andThreeWorkOnconfigtimeIsNull() {
			addCriterion("THREE_WORK_ONCONFIGTIME is null");
			return (Criteria) this;
		}

		public Criteria andThreeWorkOnconfigtimeIsNotNull() {
			addCriterion("THREE_WORK_ONCONFIGTIME is not null");
			return (Criteria) this;
		}

		public Criteria andThreeWorkOnconfigtimeEqualTo(String value) {
			addCriterion("THREE_WORK_ONCONFIGTIME =", value, "threeWorkOnconfigtime");
			return (Criteria) this;
		}

		public Criteria andThreeWorkOnconfigtimeNotEqualTo(String value) {
			addCriterion("THREE_WORK_ONCONFIGTIME <>", value, "threeWorkOnconfigtime");
			return (Criteria) this;
		}

		public Criteria andThreeWorkOnconfigtimeGreaterThan(String value) {
			addCriterion("THREE_WORK_ONCONFIGTIME >", value, "threeWorkOnconfigtime");
			return (Criteria) this;
		}

		public Criteria andThreeWorkOnconfigtimeGreaterThanOrEqualTo(String value) {
			addCriterion("THREE_WORK_ONCONFIGTIME >=", value, "threeWorkOnconfigtime");
			return (Criteria) this;
		}

		public Criteria andThreeWorkOnconfigtimeLessThan(String value) {
			addCriterion("THREE_WORK_ONCONFIGTIME <", value, "threeWorkOnconfigtime");
			return (Criteria) this;
		}

		public Criteria andThreeWorkOnconfigtimeLessThanOrEqualTo(String value) {
			addCriterion("THREE_WORK_ONCONFIGTIME <=", value, "threeWorkOnconfigtime");
			return (Criteria) this;
		}

		public Criteria andThreeWorkOnconfigtimeLike(String value) {
			addCriterion("THREE_WORK_ONCONFIGTIME like", value, "threeWorkOnconfigtime");
			return (Criteria) this;
		}

		public Criteria andThreeWorkOnconfigtimeNotLike(String value) {
			addCriterion("THREE_WORK_ONCONFIGTIME not like", value, "threeWorkOnconfigtime");
			return (Criteria) this;
		}

		public Criteria andThreeWorkOnconfigtimeIn(List<String> values) {
			addCriterion("THREE_WORK_ONCONFIGTIME in", values, "threeWorkOnconfigtime");
			return (Criteria) this;
		}

		public Criteria andThreeWorkOnconfigtimeNotIn(List<String> values) {
			addCriterion("THREE_WORK_ONCONFIGTIME not in", values, "threeWorkOnconfigtime");
			return (Criteria) this;
		}

		public Criteria andThreeWorkOnconfigtimeBetween(String value1, String value2) {
			addCriterion("THREE_WORK_ONCONFIGTIME between", value1, value2, "threeWorkOnconfigtime");
			return (Criteria) this;
		}

		public Criteria andThreeWorkOnconfigtimeNotBetween(String value1, String value2) {
			addCriterion("THREE_WORK_ONCONFIGTIME not between", value1, value2, "threeWorkOnconfigtime");
			return (Criteria) this;
		}

		public Criteria andThreeWorkOffconfigtimeIsNull() {
			addCriterion("THREE_WORK_OFFCONFIGTIME is null");
			return (Criteria) this;
		}

		public Criteria andThreeWorkOffconfigtimeIsNotNull() {
			addCriterion("THREE_WORK_OFFCONFIGTIME is not null");
			return (Criteria) this;
		}

		public Criteria andThreeWorkOffconfigtimeEqualTo(String value) {
			addCriterion("THREE_WORK_OFFCONFIGTIME =", value, "threeWorkOffconfigtime");
			return (Criteria) this;
		}

		public Criteria andThreeWorkOffconfigtimeNotEqualTo(String value) {
			addCriterion("THREE_WORK_OFFCONFIGTIME <>", value, "threeWorkOffconfigtime");
			return (Criteria) this;
		}

		public Criteria andThreeWorkOffconfigtimeGreaterThan(String value) {
			addCriterion("THREE_WORK_OFFCONFIGTIME >", value, "threeWorkOffconfigtime");
			return (Criteria) this;
		}

		public Criteria andThreeWorkOffconfigtimeGreaterThanOrEqualTo(String value) {
			addCriterion("THREE_WORK_OFFCONFIGTIME >=", value, "threeWorkOffconfigtime");
			return (Criteria) this;
		}

		public Criteria andThreeWorkOffconfigtimeLessThan(String value) {
			addCriterion("THREE_WORK_OFFCONFIGTIME <", value, "threeWorkOffconfigtime");
			return (Criteria) this;
		}

		public Criteria andThreeWorkOffconfigtimeLessThanOrEqualTo(String value) {
			addCriterion("THREE_WORK_OFFCONFIGTIME <=", value, "threeWorkOffconfigtime");
			return (Criteria) this;
		}

		public Criteria andThreeWorkOffconfigtimeLike(String value) {
			addCriterion("THREE_WORK_OFFCONFIGTIME like", value, "threeWorkOffconfigtime");
			return (Criteria) this;
		}

		public Criteria andThreeWorkOffconfigtimeNotLike(String value) {
			addCriterion("THREE_WORK_OFFCONFIGTIME not like", value, "threeWorkOffconfigtime");
			return (Criteria) this;
		}

		public Criteria andThreeWorkOffconfigtimeIn(List<String> values) {
			addCriterion("THREE_WORK_OFFCONFIGTIME in", values, "threeWorkOffconfigtime");
			return (Criteria) this;
		}

		public Criteria andThreeWorkOffconfigtimeNotIn(List<String> values) {
			addCriterion("THREE_WORK_OFFCONFIGTIME not in", values, "threeWorkOffconfigtime");
			return (Criteria) this;
		}

		public Criteria andThreeWorkOffconfigtimeBetween(String value1, String value2) {
			addCriterion("THREE_WORK_OFFCONFIGTIME between", value1, value2, "threeWorkOffconfigtime");
			return (Criteria) this;
		}

		public Criteria andThreeWorkOffconfigtimeNotBetween(String value1, String value2) {
			addCriterion("THREE_WORK_OFFCONFIGTIME not between", value1, value2, "threeWorkOffconfigtime");
			return (Criteria) this;
		}

		public Criteria andAttClassTypeIsNull() {
			addCriterion("ATT_CLASS_TYPE is null");
			return (Criteria) this;
		}

		public Criteria andAttClassTypeIsNotNull() {
			addCriterion("ATT_CLASS_TYPE is not null");
			return (Criteria) this;
		}

		public Criteria andAttClassTypeEqualTo(Byte value) {
			addCriterion("ATT_CLASS_TYPE =", value, "attClassType");
			return (Criteria) this;
		}

		public Criteria andAttClassTypeNotEqualTo(Byte value) {
			addCriterion("ATT_CLASS_TYPE <>", value, "attClassType");
			return (Criteria) this;
		}

		public Criteria andAttClassTypeGreaterThan(Byte value) {
			addCriterion("ATT_CLASS_TYPE >", value, "attClassType");
			return (Criteria) this;
		}

		public Criteria andAttClassTypeGreaterThanOrEqualTo(Byte value) {
			addCriterion("ATT_CLASS_TYPE >=", value, "attClassType");
			return (Criteria) this;
		}

		public Criteria andAttClassTypeLessThan(Byte value) {
			addCriterion("ATT_CLASS_TYPE <", value, "attClassType");
			return (Criteria) this;
		}

		public Criteria andAttClassTypeLessThanOrEqualTo(Byte value) {
			addCriterion("ATT_CLASS_TYPE <=", value, "attClassType");
			return (Criteria) this;
		}

		public Criteria andAttClassTypeIn(List<Byte> values) {
			addCriterion("ATT_CLASS_TYPE in", values, "attClassType");
			return (Criteria) this;
		}

		public Criteria andAttClassTypeNotIn(List<Byte> values) {
			addCriterion("ATT_CLASS_TYPE not in", values, "attClassType");
			return (Criteria) this;
		}

		public Criteria andAttClassTypeBetween(Byte value1, Byte value2) {
			addCriterion("ATT_CLASS_TYPE between", value1, value2, "attClassType");
			return (Criteria) this;
		}

		public Criteria andAttClassTypeNotBetween(Byte value1, Byte value2) {
			addCriterion("ATT_CLASS_TYPE not between", value1, value2, "attClassType");
			return (Criteria) this;
		}

		public Criteria andAttGrNameIsNull() {
			addCriterion("ATT_GR_NAME is null");
			return (Criteria) this;
		}

		public Criteria andAttGrNameIsNotNull() {
			addCriterion("ATT_GR_NAME is not null");
			return (Criteria) this;
		}

		public Criteria andAttGrNameEqualTo(String value) {
			addCriterion("ATT_GR_NAME =", value, "attGrName");
			return (Criteria) this;
		}

		public Criteria andAttGrNameNotEqualTo(String value) {
			addCriterion("ATT_GR_NAME <>", value, "attGrName");
			return (Criteria) this;
		}

		public Criteria andAttGrNameGreaterThan(String value) {
			addCriterion("ATT_GR_NAME >", value, "attGrName");
			return (Criteria) this;
		}

		public Criteria andAttGrNameGreaterThanOrEqualTo(String value) {
			addCriterion("ATT_GR_NAME >=", value, "attGrName");
			return (Criteria) this;
		}

		public Criteria andAttGrNameLessThan(String value) {
			addCriterion("ATT_GR_NAME <", value, "attGrName");
			return (Criteria) this;
		}

		public Criteria andAttGrNameLessThanOrEqualTo(String value) {
			addCriterion("ATT_GR_NAME <=", value, "attGrName");
			return (Criteria) this;
		}

		public Criteria andAttGrNameLike(String value) {
			addCriterion("ATT_GR_NAME like", value, "attGrName");
			return (Criteria) this;
		}

		public Criteria andAttGrNameNotLike(String value) {
			addCriterion("ATT_GR_NAME not like", value, "attGrName");
			return (Criteria) this;
		}

		public Criteria andAttGrNameIn(List<String> values) {
			addCriterion("ATT_GR_NAME in", values, "attGrName");
			return (Criteria) this;
		}

		public Criteria andAttGrNameNotIn(List<String> values) {
			addCriterion("ATT_GR_NAME not in", values, "attGrName");
			return (Criteria) this;
		}

		public Criteria andAttGrNameBetween(String value1, String value2) {
			addCriterion("ATT_GR_NAME between", value1, value2, "attGrName");
			return (Criteria) this;
		}

		public Criteria andAttGrNameNotBetween(String value1, String value2) {
			addCriterion("ATT_GR_NAME not between", value1, value2, "attGrName");
			return (Criteria) this;
		}

		public Criteria andFirstWorkonAttWayIsNull() {
			addCriterion("FIRST_WORKON_ATT_WAY is null");
			return (Criteria) this;
		}

		public Criteria andFirstWorkonAttWayIsNotNull() {
			addCriterion("FIRST_WORKON_ATT_WAY is not null");
			return (Criteria) this;
		}

		public Criteria andFirstWorkonAttWayEqualTo(Byte value) {
			addCriterion("FIRST_WORKON_ATT_WAY =", value, "firstWorkonAttWay");
			return (Criteria) this;
		}

		public Criteria andFirstWorkonAttWayNotEqualTo(Byte value) {
			addCriterion("FIRST_WORKON_ATT_WAY <>", value, "firstWorkonAttWay");
			return (Criteria) this;
		}

		public Criteria andFirstWorkonAttWayGreaterThan(Byte value) {
			addCriterion("FIRST_WORKON_ATT_WAY >", value, "firstWorkonAttWay");
			return (Criteria) this;
		}

		public Criteria andFirstWorkonAttWayGreaterThanOrEqualTo(Byte value) {
			addCriterion("FIRST_WORKON_ATT_WAY >=", value, "firstWorkonAttWay");
			return (Criteria) this;
		}

		public Criteria andFirstWorkonAttWayLessThan(Byte value) {
			addCriterion("FIRST_WORKON_ATT_WAY <", value, "firstWorkonAttWay");
			return (Criteria) this;
		}

		public Criteria andFirstWorkonAttWayLessThanOrEqualTo(Byte value) {
			addCriterion("FIRST_WORKON_ATT_WAY <=", value, "firstWorkonAttWay");
			return (Criteria) this;
		}

		public Criteria andFirstWorkonAttWayIn(List<Byte> values) {
			addCriterion("FIRST_WORKON_ATT_WAY in", values, "firstWorkonAttWay");
			return (Criteria) this;
		}

		public Criteria andFirstWorkonAttWayNotIn(List<Byte> values) {
			addCriterion("FIRST_WORKON_ATT_WAY not in", values, "firstWorkonAttWay");
			return (Criteria) this;
		}

		public Criteria andFirstWorkonAttWayBetween(Byte value1, Byte value2) {
			addCriterion("FIRST_WORKON_ATT_WAY between", value1, value2, "firstWorkonAttWay");
			return (Criteria) this;
		}

		public Criteria andFirstWorkonAttWayNotBetween(Byte value1, Byte value2) {
			addCriterion("FIRST_WORKON_ATT_WAY not between", value1, value2, "firstWorkonAttWay");
			return (Criteria) this;
		}

		public Criteria andFirstWorkonWifiIdIsNull() {
			addCriterion("FIRST_WORKON_WIFI_ID is null");
			return (Criteria) this;
		}

		public Criteria andFirstWorkonWifiIdIsNotNull() {
			addCriterion("FIRST_WORKON_WIFI_ID is not null");
			return (Criteria) this;
		}

		public Criteria andFirstWorkonWifiIdEqualTo(Integer value) {
			addCriterion("FIRST_WORKON_WIFI_ID =", value, "firstWorkonWifiId");
			return (Criteria) this;
		}

		public Criteria andFirstWorkonWifiIdNotEqualTo(Integer value) {
			addCriterion("FIRST_WORKON_WIFI_ID <>", value, "firstWorkonWifiId");
			return (Criteria) this;
		}

		public Criteria andFirstWorkonWifiIdGreaterThan(Integer value) {
			addCriterion("FIRST_WORKON_WIFI_ID >", value, "firstWorkonWifiId");
			return (Criteria) this;
		}

		public Criteria andFirstWorkonWifiIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("FIRST_WORKON_WIFI_ID >=", value, "firstWorkonWifiId");
			return (Criteria) this;
		}

		public Criteria andFirstWorkonWifiIdLessThan(Integer value) {
			addCriterion("FIRST_WORKON_WIFI_ID <", value, "firstWorkonWifiId");
			return (Criteria) this;
		}

		public Criteria andFirstWorkonWifiIdLessThanOrEqualTo(Integer value) {
			addCriterion("FIRST_WORKON_WIFI_ID <=", value, "firstWorkonWifiId");
			return (Criteria) this;
		}

		public Criteria andFirstWorkonWifiIdIn(List<Integer> values) {
			addCriterion("FIRST_WORKON_WIFI_ID in", values, "firstWorkonWifiId");
			return (Criteria) this;
		}

		public Criteria andFirstWorkonWifiIdNotIn(List<Integer> values) {
			addCriterion("FIRST_WORKON_WIFI_ID not in", values, "firstWorkonWifiId");
			return (Criteria) this;
		}

		public Criteria andFirstWorkonWifiIdBetween(Integer value1, Integer value2) {
			addCriterion("FIRST_WORKON_WIFI_ID between", value1, value2, "firstWorkonWifiId");
			return (Criteria) this;
		}

		public Criteria andFirstWorkonWifiIdNotBetween(Integer value1, Integer value2) {
			addCriterion("FIRST_WORKON_WIFI_ID not between", value1, value2, "firstWorkonWifiId");
			return (Criteria) this;
		}

		public Criteria andFirstWorkonAttWifiSsidIsNull() {
			addCriterion("FIRST_WORKON_ATT_WIFI_SSID is null");
			return (Criteria) this;
		}

		public Criteria andFirstWorkonAttWifiSsidIsNotNull() {
			addCriterion("FIRST_WORKON_ATT_WIFI_SSID is not null");
			return (Criteria) this;
		}

		public Criteria andFirstWorkonAttWifiSsidEqualTo(String value) {
			addCriterion("FIRST_WORKON_ATT_WIFI_SSID =", value, "firstWorkonAttWifiSsid");
			return (Criteria) this;
		}

		public Criteria andFirstWorkonAttWifiSsidNotEqualTo(String value) {
			addCriterion("FIRST_WORKON_ATT_WIFI_SSID <>", value, "firstWorkonAttWifiSsid");
			return (Criteria) this;
		}

		public Criteria andFirstWorkonAttWifiSsidGreaterThan(String value) {
			addCriterion("FIRST_WORKON_ATT_WIFI_SSID >", value, "firstWorkonAttWifiSsid");
			return (Criteria) this;
		}

		public Criteria andFirstWorkonAttWifiSsidGreaterThanOrEqualTo(String value) {
			addCriterion("FIRST_WORKON_ATT_WIFI_SSID >=", value, "firstWorkonAttWifiSsid");
			return (Criteria) this;
		}

		public Criteria andFirstWorkonAttWifiSsidLessThan(String value) {
			addCriterion("FIRST_WORKON_ATT_WIFI_SSID <", value, "firstWorkonAttWifiSsid");
			return (Criteria) this;
		}

		public Criteria andFirstWorkonAttWifiSsidLessThanOrEqualTo(String value) {
			addCriterion("FIRST_WORKON_ATT_WIFI_SSID <=", value, "firstWorkonAttWifiSsid");
			return (Criteria) this;
		}

		public Criteria andFirstWorkonAttWifiSsidLike(String value) {
			addCriterion("FIRST_WORKON_ATT_WIFI_SSID like", value, "firstWorkonAttWifiSsid");
			return (Criteria) this;
		}

		public Criteria andFirstWorkonAttWifiSsidNotLike(String value) {
			addCriterion("FIRST_WORKON_ATT_WIFI_SSID not like", value, "firstWorkonAttWifiSsid");
			return (Criteria) this;
		}

		public Criteria andFirstWorkonAttWifiSsidIn(List<String> values) {
			addCriterion("FIRST_WORKON_ATT_WIFI_SSID in", values, "firstWorkonAttWifiSsid");
			return (Criteria) this;
		}

		public Criteria andFirstWorkonAttWifiSsidNotIn(List<String> values) {
			addCriterion("FIRST_WORKON_ATT_WIFI_SSID not in", values, "firstWorkonAttWifiSsid");
			return (Criteria) this;
		}

		public Criteria andFirstWorkonAttWifiSsidBetween(String value1, String value2) {
			addCriterion("FIRST_WORKON_ATT_WIFI_SSID between", value1, value2, "firstWorkonAttWifiSsid");
			return (Criteria) this;
		}

		public Criteria andFirstWorkonAttWifiSsidNotBetween(String value1, String value2) {
			addCriterion("FIRST_WORKON_ATT_WIFI_SSID not between", value1, value2, "firstWorkonAttWifiSsid");
			return (Criteria) this;
		}

		public Criteria andFirstWorkonAttWifiMacIsNull() {
			addCriterion("FIRST_WORKON_ATT_WIFI_MAC is null");
			return (Criteria) this;
		}

		public Criteria andFirstWorkonAttWifiMacIsNotNull() {
			addCriterion("FIRST_WORKON_ATT_WIFI_MAC is not null");
			return (Criteria) this;
		}

		public Criteria andFirstWorkonAttWifiMacEqualTo(String value) {
			addCriterion("FIRST_WORKON_ATT_WIFI_MAC =", value, "firstWorkonAttWifiMac");
			return (Criteria) this;
		}

		public Criteria andFirstWorkonAttWifiMacNotEqualTo(String value) {
			addCriterion("FIRST_WORKON_ATT_WIFI_MAC <>", value, "firstWorkonAttWifiMac");
			return (Criteria) this;
		}

		public Criteria andFirstWorkonAttWifiMacGreaterThan(String value) {
			addCriterion("FIRST_WORKON_ATT_WIFI_MAC >", value, "firstWorkonAttWifiMac");
			return (Criteria) this;
		}

		public Criteria andFirstWorkonAttWifiMacGreaterThanOrEqualTo(String value) {
			addCriterion("FIRST_WORKON_ATT_WIFI_MAC >=", value, "firstWorkonAttWifiMac");
			return (Criteria) this;
		}

		public Criteria andFirstWorkonAttWifiMacLessThan(String value) {
			addCriterion("FIRST_WORKON_ATT_WIFI_MAC <", value, "firstWorkonAttWifiMac");
			return (Criteria) this;
		}

		public Criteria andFirstWorkonAttWifiMacLessThanOrEqualTo(String value) {
			addCriterion("FIRST_WORKON_ATT_WIFI_MAC <=", value, "firstWorkonAttWifiMac");
			return (Criteria) this;
		}

		public Criteria andFirstWorkonAttWifiMacLike(String value) {
			addCriterion("FIRST_WORKON_ATT_WIFI_MAC like", value, "firstWorkonAttWifiMac");
			return (Criteria) this;
		}

		public Criteria andFirstWorkonAttWifiMacNotLike(String value) {
			addCriterion("FIRST_WORKON_ATT_WIFI_MAC not like", value, "firstWorkonAttWifiMac");
			return (Criteria) this;
		}

		public Criteria andFirstWorkonAttWifiMacIn(List<String> values) {
			addCriterion("FIRST_WORKON_ATT_WIFI_MAC in", values, "firstWorkonAttWifiMac");
			return (Criteria) this;
		}

		public Criteria andFirstWorkonAttWifiMacNotIn(List<String> values) {
			addCriterion("FIRST_WORKON_ATT_WIFI_MAC not in", values, "firstWorkonAttWifiMac");
			return (Criteria) this;
		}

		public Criteria andFirstWorkonAttWifiMacBetween(String value1, String value2) {
			addCriterion("FIRST_WORKON_ATT_WIFI_MAC between", value1, value2, "firstWorkonAttWifiMac");
			return (Criteria) this;
		}

		public Criteria andFirstWorkonAttWifiMacNotBetween(String value1, String value2) {
			addCriterion("FIRST_WORKON_ATT_WIFI_MAC not between", value1, value2, "firstWorkonAttWifiMac");
			return (Criteria) this;
		}

		public Criteria andFirstWorkoffAttWayIsNull() {
			addCriterion("FIRST_WORKOFF_ATT_WAY is null");
			return (Criteria) this;
		}

		public Criteria andFirstWorkoffAttWayIsNotNull() {
			addCriterion("FIRST_WORKOFF_ATT_WAY is not null");
			return (Criteria) this;
		}

		public Criteria andFirstWorkoffAttWayEqualTo(Byte value) {
			addCriterion("FIRST_WORKOFF_ATT_WAY =", value, "firstWorkoffAttWay");
			return (Criteria) this;
		}

		public Criteria andFirstWorkoffAttWayNotEqualTo(Byte value) {
			addCriterion("FIRST_WORKOFF_ATT_WAY <>", value, "firstWorkoffAttWay");
			return (Criteria) this;
		}

		public Criteria andFirstWorkoffAttWayGreaterThan(Byte value) {
			addCriterion("FIRST_WORKOFF_ATT_WAY >", value, "firstWorkoffAttWay");
			return (Criteria) this;
		}

		public Criteria andFirstWorkoffAttWayGreaterThanOrEqualTo(Byte value) {
			addCriterion("FIRST_WORKOFF_ATT_WAY >=", value, "firstWorkoffAttWay");
			return (Criteria) this;
		}

		public Criteria andFirstWorkoffAttWayLessThan(Byte value) {
			addCriterion("FIRST_WORKOFF_ATT_WAY <", value, "firstWorkoffAttWay");
			return (Criteria) this;
		}

		public Criteria andFirstWorkoffAttWayLessThanOrEqualTo(Byte value) {
			addCriterion("FIRST_WORKOFF_ATT_WAY <=", value, "firstWorkoffAttWay");
			return (Criteria) this;
		}

		public Criteria andFirstWorkoffAttWayIn(List<Byte> values) {
			addCriterion("FIRST_WORKOFF_ATT_WAY in", values, "firstWorkoffAttWay");
			return (Criteria) this;
		}

		public Criteria andFirstWorkoffAttWayNotIn(List<Byte> values) {
			addCriterion("FIRST_WORKOFF_ATT_WAY not in", values, "firstWorkoffAttWay");
			return (Criteria) this;
		}

		public Criteria andFirstWorkoffAttWayBetween(Byte value1, Byte value2) {
			addCriterion("FIRST_WORKOFF_ATT_WAY between", value1, value2, "firstWorkoffAttWay");
			return (Criteria) this;
		}

		public Criteria andFirstWorkoffAttWayNotBetween(Byte value1, Byte value2) {
			addCriterion("FIRST_WORKOFF_ATT_WAY not between", value1, value2, "firstWorkoffAttWay");
			return (Criteria) this;
		}

		public Criteria andFirstWorkoffWifiIdIsNull() {
			addCriterion("FIRST_WORKOFF_WIFI_ID is null");
			return (Criteria) this;
		}

		public Criteria andFirstWorkoffWifiIdIsNotNull() {
			addCriterion("FIRST_WORKOFF_WIFI_ID is not null");
			return (Criteria) this;
		}

		public Criteria andFirstWorkoffWifiIdEqualTo(Integer value) {
			addCriterion("FIRST_WORKOFF_WIFI_ID =", value, "firstWorkoffWifiId");
			return (Criteria) this;
		}

		public Criteria andFirstWorkoffWifiIdNotEqualTo(Integer value) {
			addCriterion("FIRST_WORKOFF_WIFI_ID <>", value, "firstWorkoffWifiId");
			return (Criteria) this;
		}

		public Criteria andFirstWorkoffWifiIdGreaterThan(Integer value) {
			addCriterion("FIRST_WORKOFF_WIFI_ID >", value, "firstWorkoffWifiId");
			return (Criteria) this;
		}

		public Criteria andFirstWorkoffWifiIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("FIRST_WORKOFF_WIFI_ID >=", value, "firstWorkoffWifiId");
			return (Criteria) this;
		}

		public Criteria andFirstWorkoffWifiIdLessThan(Integer value) {
			addCriterion("FIRST_WORKOFF_WIFI_ID <", value, "firstWorkoffWifiId");
			return (Criteria) this;
		}

		public Criteria andFirstWorkoffWifiIdLessThanOrEqualTo(Integer value) {
			addCriterion("FIRST_WORKOFF_WIFI_ID <=", value, "firstWorkoffWifiId");
			return (Criteria) this;
		}

		public Criteria andFirstWorkoffWifiIdIn(List<Integer> values) {
			addCriterion("FIRST_WORKOFF_WIFI_ID in", values, "firstWorkoffWifiId");
			return (Criteria) this;
		}

		public Criteria andFirstWorkoffWifiIdNotIn(List<Integer> values) {
			addCriterion("FIRST_WORKOFF_WIFI_ID not in", values, "firstWorkoffWifiId");
			return (Criteria) this;
		}

		public Criteria andFirstWorkoffWifiIdBetween(Integer value1, Integer value2) {
			addCriterion("FIRST_WORKOFF_WIFI_ID between", value1, value2, "firstWorkoffWifiId");
			return (Criteria) this;
		}

		public Criteria andFirstWorkoffWifiIdNotBetween(Integer value1, Integer value2) {
			addCriterion("FIRST_WORKOFF_WIFI_ID not between", value1, value2, "firstWorkoffWifiId");
			return (Criteria) this;
		}

		public Criteria andFirstWorkoffAttWifiSsidIsNull() {
			addCriterion("FIRST_WORKOFF_ATT_WIFI_SSID is null");
			return (Criteria) this;
		}

		public Criteria andFirstWorkoffAttWifiSsidIsNotNull() {
			addCriterion("FIRST_WORKOFF_ATT_WIFI_SSID is not null");
			return (Criteria) this;
		}

		public Criteria andFirstWorkoffAttWifiSsidEqualTo(String value) {
			addCriterion("FIRST_WORKOFF_ATT_WIFI_SSID =", value, "firstWorkoffAttWifiSsid");
			return (Criteria) this;
		}

		public Criteria andFirstWorkoffAttWifiSsidNotEqualTo(String value) {
			addCriterion("FIRST_WORKOFF_ATT_WIFI_SSID <>", value, "firstWorkoffAttWifiSsid");
			return (Criteria) this;
		}

		public Criteria andFirstWorkoffAttWifiSsidGreaterThan(String value) {
			addCriterion("FIRST_WORKOFF_ATT_WIFI_SSID >", value, "firstWorkoffAttWifiSsid");
			return (Criteria) this;
		}

		public Criteria andFirstWorkoffAttWifiSsidGreaterThanOrEqualTo(String value) {
			addCriterion("FIRST_WORKOFF_ATT_WIFI_SSID >=", value, "firstWorkoffAttWifiSsid");
			return (Criteria) this;
		}

		public Criteria andFirstWorkoffAttWifiSsidLessThan(String value) {
			addCriterion("FIRST_WORKOFF_ATT_WIFI_SSID <", value, "firstWorkoffAttWifiSsid");
			return (Criteria) this;
		}

		public Criteria andFirstWorkoffAttWifiSsidLessThanOrEqualTo(String value) {
			addCriterion("FIRST_WORKOFF_ATT_WIFI_SSID <=", value, "firstWorkoffAttWifiSsid");
			return (Criteria) this;
		}

		public Criteria andFirstWorkoffAttWifiSsidLike(String value) {
			addCriterion("FIRST_WORKOFF_ATT_WIFI_SSID like", value, "firstWorkoffAttWifiSsid");
			return (Criteria) this;
		}

		public Criteria andFirstWorkoffAttWifiSsidNotLike(String value) {
			addCriterion("FIRST_WORKOFF_ATT_WIFI_SSID not like", value, "firstWorkoffAttWifiSsid");
			return (Criteria) this;
		}

		public Criteria andFirstWorkoffAttWifiSsidIn(List<String> values) {
			addCriterion("FIRST_WORKOFF_ATT_WIFI_SSID in", values, "firstWorkoffAttWifiSsid");
			return (Criteria) this;
		}

		public Criteria andFirstWorkoffAttWifiSsidNotIn(List<String> values) {
			addCriterion("FIRST_WORKOFF_ATT_WIFI_SSID not in", values, "firstWorkoffAttWifiSsid");
			return (Criteria) this;
		}

		public Criteria andFirstWorkoffAttWifiSsidBetween(String value1, String value2) {
			addCriterion("FIRST_WORKOFF_ATT_WIFI_SSID between", value1, value2, "firstWorkoffAttWifiSsid");
			return (Criteria) this;
		}

		public Criteria andFirstWorkoffAttWifiSsidNotBetween(String value1, String value2) {
			addCriterion("FIRST_WORKOFF_ATT_WIFI_SSID not between", value1, value2, "firstWorkoffAttWifiSsid");
			return (Criteria) this;
		}

		public Criteria andFirstWorkoffAttWifiMacIsNull() {
			addCriterion("FIRST_WORKOFF_ATT_WIFI_MAC is null");
			return (Criteria) this;
		}

		public Criteria andFirstWorkoffAttWifiMacIsNotNull() {
			addCriterion("FIRST_WORKOFF_ATT_WIFI_MAC is not null");
			return (Criteria) this;
		}

		public Criteria andFirstWorkoffAttWifiMacEqualTo(String value) {
			addCriterion("FIRST_WORKOFF_ATT_WIFI_MAC =", value, "firstWorkoffAttWifiMac");
			return (Criteria) this;
		}

		public Criteria andFirstWorkoffAttWifiMacNotEqualTo(String value) {
			addCriterion("FIRST_WORKOFF_ATT_WIFI_MAC <>", value, "firstWorkoffAttWifiMac");
			return (Criteria) this;
		}

		public Criteria andFirstWorkoffAttWifiMacGreaterThan(String value) {
			addCriterion("FIRST_WORKOFF_ATT_WIFI_MAC >", value, "firstWorkoffAttWifiMac");
			return (Criteria) this;
		}

		public Criteria andFirstWorkoffAttWifiMacGreaterThanOrEqualTo(String value) {
			addCriterion("FIRST_WORKOFF_ATT_WIFI_MAC >=", value, "firstWorkoffAttWifiMac");
			return (Criteria) this;
		}

		public Criteria andFirstWorkoffAttWifiMacLessThan(String value) {
			addCriterion("FIRST_WORKOFF_ATT_WIFI_MAC <", value, "firstWorkoffAttWifiMac");
			return (Criteria) this;
		}

		public Criteria andFirstWorkoffAttWifiMacLessThanOrEqualTo(String value) {
			addCriterion("FIRST_WORKOFF_ATT_WIFI_MAC <=", value, "firstWorkoffAttWifiMac");
			return (Criteria) this;
		}

		public Criteria andFirstWorkoffAttWifiMacLike(String value) {
			addCriterion("FIRST_WORKOFF_ATT_WIFI_MAC like", value, "firstWorkoffAttWifiMac");
			return (Criteria) this;
		}

		public Criteria andFirstWorkoffAttWifiMacNotLike(String value) {
			addCriterion("FIRST_WORKOFF_ATT_WIFI_MAC not like", value, "firstWorkoffAttWifiMac");
			return (Criteria) this;
		}

		public Criteria andFirstWorkoffAttWifiMacIn(List<String> values) {
			addCriterion("FIRST_WORKOFF_ATT_WIFI_MAC in", values, "firstWorkoffAttWifiMac");
			return (Criteria) this;
		}

		public Criteria andFirstWorkoffAttWifiMacNotIn(List<String> values) {
			addCriterion("FIRST_WORKOFF_ATT_WIFI_MAC not in", values, "firstWorkoffAttWifiMac");
			return (Criteria) this;
		}

		public Criteria andFirstWorkoffAttWifiMacBetween(String value1, String value2) {
			addCriterion("FIRST_WORKOFF_ATT_WIFI_MAC between", value1, value2, "firstWorkoffAttWifiMac");
			return (Criteria) this;
		}

		public Criteria andFirstWorkoffAttWifiMacNotBetween(String value1, String value2) {
			addCriterion("FIRST_WORKOFF_ATT_WIFI_MAC not between", value1, value2, "firstWorkoffAttWifiMac");
			return (Criteria) this;
		}

		public Criteria andSecondWorkonAttWayIsNull() {
			addCriterion("SECOND_WORKON_ATT_WAY is null");
			return (Criteria) this;
		}

		public Criteria andSecondWorkonAttWayIsNotNull() {
			addCriterion("SECOND_WORKON_ATT_WAY is not null");
			return (Criteria) this;
		}

		public Criteria andSecondWorkonAttWayEqualTo(Byte value) {
			addCriterion("SECOND_WORKON_ATT_WAY =", value, "secondWorkonAttWay");
			return (Criteria) this;
		}

		public Criteria andSecondWorkonAttWayNotEqualTo(Byte value) {
			addCriterion("SECOND_WORKON_ATT_WAY <>", value, "secondWorkonAttWay");
			return (Criteria) this;
		}

		public Criteria andSecondWorkonAttWayGreaterThan(Byte value) {
			addCriterion("SECOND_WORKON_ATT_WAY >", value, "secondWorkonAttWay");
			return (Criteria) this;
		}

		public Criteria andSecondWorkonAttWayGreaterThanOrEqualTo(Byte value) {
			addCriterion("SECOND_WORKON_ATT_WAY >=", value, "secondWorkonAttWay");
			return (Criteria) this;
		}

		public Criteria andSecondWorkonAttWayLessThan(Byte value) {
			addCriterion("SECOND_WORKON_ATT_WAY <", value, "secondWorkonAttWay");
			return (Criteria) this;
		}

		public Criteria andSecondWorkonAttWayLessThanOrEqualTo(Byte value) {
			addCriterion("SECOND_WORKON_ATT_WAY <=", value, "secondWorkonAttWay");
			return (Criteria) this;
		}

		public Criteria andSecondWorkonAttWayIn(List<Byte> values) {
			addCriterion("SECOND_WORKON_ATT_WAY in", values, "secondWorkonAttWay");
			return (Criteria) this;
		}

		public Criteria andSecondWorkonAttWayNotIn(List<Byte> values) {
			addCriterion("SECOND_WORKON_ATT_WAY not in", values, "secondWorkonAttWay");
			return (Criteria) this;
		}

		public Criteria andSecondWorkonAttWayBetween(Byte value1, Byte value2) {
			addCriterion("SECOND_WORKON_ATT_WAY between", value1, value2, "secondWorkonAttWay");
			return (Criteria) this;
		}

		public Criteria andSecondWorkonAttWayNotBetween(Byte value1, Byte value2) {
			addCriterion("SECOND_WORKON_ATT_WAY not between", value1, value2, "secondWorkonAttWay");
			return (Criteria) this;
		}

		public Criteria andSecondWorkonWifiIdIsNull() {
			addCriterion("SECOND_WORKON_WIFI_ID is null");
			return (Criteria) this;
		}

		public Criteria andSecondWorkonWifiIdIsNotNull() {
			addCriterion("SECOND_WORKON_WIFI_ID is not null");
			return (Criteria) this;
		}

		public Criteria andSecondWorkonWifiIdEqualTo(Integer value) {
			addCriterion("SECOND_WORKON_WIFI_ID =", value, "secondWorkonWifiId");
			return (Criteria) this;
		}

		public Criteria andSecondWorkonWifiIdNotEqualTo(Integer value) {
			addCriterion("SECOND_WORKON_WIFI_ID <>", value, "secondWorkonWifiId");
			return (Criteria) this;
		}

		public Criteria andSecondWorkonWifiIdGreaterThan(Integer value) {
			addCriterion("SECOND_WORKON_WIFI_ID >", value, "secondWorkonWifiId");
			return (Criteria) this;
		}

		public Criteria andSecondWorkonWifiIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("SECOND_WORKON_WIFI_ID >=", value, "secondWorkonWifiId");
			return (Criteria) this;
		}

		public Criteria andSecondWorkonWifiIdLessThan(Integer value) {
			addCriterion("SECOND_WORKON_WIFI_ID <", value, "secondWorkonWifiId");
			return (Criteria) this;
		}

		public Criteria andSecondWorkonWifiIdLessThanOrEqualTo(Integer value) {
			addCriterion("SECOND_WORKON_WIFI_ID <=", value, "secondWorkonWifiId");
			return (Criteria) this;
		}

		public Criteria andSecondWorkonWifiIdIn(List<Integer> values) {
			addCriterion("SECOND_WORKON_WIFI_ID in", values, "secondWorkonWifiId");
			return (Criteria) this;
		}

		public Criteria andSecondWorkonWifiIdNotIn(List<Integer> values) {
			addCriterion("SECOND_WORKON_WIFI_ID not in", values, "secondWorkonWifiId");
			return (Criteria) this;
		}

		public Criteria andSecondWorkonWifiIdBetween(Integer value1, Integer value2) {
			addCriterion("SECOND_WORKON_WIFI_ID between", value1, value2, "secondWorkonWifiId");
			return (Criteria) this;
		}

		public Criteria andSecondWorkonWifiIdNotBetween(Integer value1, Integer value2) {
			addCriterion("SECOND_WORKON_WIFI_ID not between", value1, value2, "secondWorkonWifiId");
			return (Criteria) this;
		}

		public Criteria andSecondWorkonAttWifiSsidIsNull() {
			addCriterion("SECOND_WORKON_ATT_WIFI_SSID is null");
			return (Criteria) this;
		}

		public Criteria andSecondWorkonAttWifiSsidIsNotNull() {
			addCriterion("SECOND_WORKON_ATT_WIFI_SSID is not null");
			return (Criteria) this;
		}

		public Criteria andSecondWorkonAttWifiSsidEqualTo(String value) {
			addCriterion("SECOND_WORKON_ATT_WIFI_SSID =", value, "secondWorkonAttWifiSsid");
			return (Criteria) this;
		}

		public Criteria andSecondWorkonAttWifiSsidNotEqualTo(String value) {
			addCriterion("SECOND_WORKON_ATT_WIFI_SSID <>", value, "secondWorkonAttWifiSsid");
			return (Criteria) this;
		}

		public Criteria andSecondWorkonAttWifiSsidGreaterThan(String value) {
			addCriterion("SECOND_WORKON_ATT_WIFI_SSID >", value, "secondWorkonAttWifiSsid");
			return (Criteria) this;
		}

		public Criteria andSecondWorkonAttWifiSsidGreaterThanOrEqualTo(String value) {
			addCriterion("SECOND_WORKON_ATT_WIFI_SSID >=", value, "secondWorkonAttWifiSsid");
			return (Criteria) this;
		}

		public Criteria andSecondWorkonAttWifiSsidLessThan(String value) {
			addCriterion("SECOND_WORKON_ATT_WIFI_SSID <", value, "secondWorkonAttWifiSsid");
			return (Criteria) this;
		}

		public Criteria andSecondWorkonAttWifiSsidLessThanOrEqualTo(String value) {
			addCriterion("SECOND_WORKON_ATT_WIFI_SSID <=", value, "secondWorkonAttWifiSsid");
			return (Criteria) this;
		}

		public Criteria andSecondWorkonAttWifiSsidLike(String value) {
			addCriterion("SECOND_WORKON_ATT_WIFI_SSID like", value, "secondWorkonAttWifiSsid");
			return (Criteria) this;
		}

		public Criteria andSecondWorkonAttWifiSsidNotLike(String value) {
			addCriterion("SECOND_WORKON_ATT_WIFI_SSID not like", value, "secondWorkonAttWifiSsid");
			return (Criteria) this;
		}

		public Criteria andSecondWorkonAttWifiSsidIn(List<String> values) {
			addCriterion("SECOND_WORKON_ATT_WIFI_SSID in", values, "secondWorkonAttWifiSsid");
			return (Criteria) this;
		}

		public Criteria andSecondWorkonAttWifiSsidNotIn(List<String> values) {
			addCriterion("SECOND_WORKON_ATT_WIFI_SSID not in", values, "secondWorkonAttWifiSsid");
			return (Criteria) this;
		}

		public Criteria andSecondWorkonAttWifiSsidBetween(String value1, String value2) {
			addCriterion("SECOND_WORKON_ATT_WIFI_SSID between", value1, value2, "secondWorkonAttWifiSsid");
			return (Criteria) this;
		}

		public Criteria andSecondWorkonAttWifiSsidNotBetween(String value1, String value2) {
			addCriterion("SECOND_WORKON_ATT_WIFI_SSID not between", value1, value2, "secondWorkonAttWifiSsid");
			return (Criteria) this;
		}

		public Criteria andSecondWorkonAttWifiMacIsNull() {
			addCriterion("SECOND_WORKON_ATT_WIFI_MAC is null");
			return (Criteria) this;
		}

		public Criteria andSecondWorkonAttWifiMacIsNotNull() {
			addCriterion("SECOND_WORKON_ATT_WIFI_MAC is not null");
			return (Criteria) this;
		}

		public Criteria andSecondWorkonAttWifiMacEqualTo(String value) {
			addCriterion("SECOND_WORKON_ATT_WIFI_MAC =", value, "secondWorkonAttWifiMac");
			return (Criteria) this;
		}

		public Criteria andSecondWorkonAttWifiMacNotEqualTo(String value) {
			addCriterion("SECOND_WORKON_ATT_WIFI_MAC <>", value, "secondWorkonAttWifiMac");
			return (Criteria) this;
		}

		public Criteria andSecondWorkonAttWifiMacGreaterThan(String value) {
			addCriterion("SECOND_WORKON_ATT_WIFI_MAC >", value, "secondWorkonAttWifiMac");
			return (Criteria) this;
		}

		public Criteria andSecondWorkonAttWifiMacGreaterThanOrEqualTo(String value) {
			addCriterion("SECOND_WORKON_ATT_WIFI_MAC >=", value, "secondWorkonAttWifiMac");
			return (Criteria) this;
		}

		public Criteria andSecondWorkonAttWifiMacLessThan(String value) {
			addCriterion("SECOND_WORKON_ATT_WIFI_MAC <", value, "secondWorkonAttWifiMac");
			return (Criteria) this;
		}

		public Criteria andSecondWorkonAttWifiMacLessThanOrEqualTo(String value) {
			addCriterion("SECOND_WORKON_ATT_WIFI_MAC <=", value, "secondWorkonAttWifiMac");
			return (Criteria) this;
		}

		public Criteria andSecondWorkonAttWifiMacLike(String value) {
			addCriterion("SECOND_WORKON_ATT_WIFI_MAC like", value, "secondWorkonAttWifiMac");
			return (Criteria) this;
		}

		public Criteria andSecondWorkonAttWifiMacNotLike(String value) {
			addCriterion("SECOND_WORKON_ATT_WIFI_MAC not like", value, "secondWorkonAttWifiMac");
			return (Criteria) this;
		}

		public Criteria andSecondWorkonAttWifiMacIn(List<String> values) {
			addCriterion("SECOND_WORKON_ATT_WIFI_MAC in", values, "secondWorkonAttWifiMac");
			return (Criteria) this;
		}

		public Criteria andSecondWorkonAttWifiMacNotIn(List<String> values) {
			addCriterion("SECOND_WORKON_ATT_WIFI_MAC not in", values, "secondWorkonAttWifiMac");
			return (Criteria) this;
		}

		public Criteria andSecondWorkonAttWifiMacBetween(String value1, String value2) {
			addCriterion("SECOND_WORKON_ATT_WIFI_MAC between", value1, value2, "secondWorkonAttWifiMac");
			return (Criteria) this;
		}

		public Criteria andSecondWorkonAttWifiMacNotBetween(String value1, String value2) {
			addCriterion("SECOND_WORKON_ATT_WIFI_MAC not between", value1, value2, "secondWorkonAttWifiMac");
			return (Criteria) this;
		}

		public Criteria andSecondWorkoffAttWayIsNull() {
			addCriterion("SECOND_WORKOFF_ATT_WAY is null");
			return (Criteria) this;
		}

		public Criteria andSecondWorkoffAttWayIsNotNull() {
			addCriterion("SECOND_WORKOFF_ATT_WAY is not null");
			return (Criteria) this;
		}

		public Criteria andSecondWorkoffAttWayEqualTo(Byte value) {
			addCriterion("SECOND_WORKOFF_ATT_WAY =", value, "secondWorkoffAttWay");
			return (Criteria) this;
		}

		public Criteria andSecondWorkoffAttWayNotEqualTo(Byte value) {
			addCriterion("SECOND_WORKOFF_ATT_WAY <>", value, "secondWorkoffAttWay");
			return (Criteria) this;
		}

		public Criteria andSecondWorkoffAttWayGreaterThan(Byte value) {
			addCriterion("SECOND_WORKOFF_ATT_WAY >", value, "secondWorkoffAttWay");
			return (Criteria) this;
		}

		public Criteria andSecondWorkoffAttWayGreaterThanOrEqualTo(Byte value) {
			addCriterion("SECOND_WORKOFF_ATT_WAY >=", value, "secondWorkoffAttWay");
			return (Criteria) this;
		}

		public Criteria andSecondWorkoffAttWayLessThan(Byte value) {
			addCriterion("SECOND_WORKOFF_ATT_WAY <", value, "secondWorkoffAttWay");
			return (Criteria) this;
		}

		public Criteria andSecondWorkoffAttWayLessThanOrEqualTo(Byte value) {
			addCriterion("SECOND_WORKOFF_ATT_WAY <=", value, "secondWorkoffAttWay");
			return (Criteria) this;
		}

		public Criteria andSecondWorkoffAttWayIn(List<Byte> values) {
			addCriterion("SECOND_WORKOFF_ATT_WAY in", values, "secondWorkoffAttWay");
			return (Criteria) this;
		}

		public Criteria andSecondWorkoffAttWayNotIn(List<Byte> values) {
			addCriterion("SECOND_WORKOFF_ATT_WAY not in", values, "secondWorkoffAttWay");
			return (Criteria) this;
		}

		public Criteria andSecondWorkoffAttWayBetween(Byte value1, Byte value2) {
			addCriterion("SECOND_WORKOFF_ATT_WAY between", value1, value2, "secondWorkoffAttWay");
			return (Criteria) this;
		}

		public Criteria andSecondWorkoffAttWayNotBetween(Byte value1, Byte value2) {
			addCriterion("SECOND_WORKOFF_ATT_WAY not between", value1, value2, "secondWorkoffAttWay");
			return (Criteria) this;
		}

		public Criteria andSecondWorkoffWifiIdIsNull() {
			addCriterion("SECOND_WORKOFF_WIFI_ID is null");
			return (Criteria) this;
		}

		public Criteria andSecondWorkoffWifiIdIsNotNull() {
			addCriterion("SECOND_WORKOFF_WIFI_ID is not null");
			return (Criteria) this;
		}

		public Criteria andSecondWorkoffWifiIdEqualTo(Integer value) {
			addCriterion("SECOND_WORKOFF_WIFI_ID =", value, "secondWorkoffWifiId");
			return (Criteria) this;
		}

		public Criteria andSecondWorkoffWifiIdNotEqualTo(Integer value) {
			addCriterion("SECOND_WORKOFF_WIFI_ID <>", value, "secondWorkoffWifiId");
			return (Criteria) this;
		}

		public Criteria andSecondWorkoffWifiIdGreaterThan(Integer value) {
			addCriterion("SECOND_WORKOFF_WIFI_ID >", value, "secondWorkoffWifiId");
			return (Criteria) this;
		}

		public Criteria andSecondWorkoffWifiIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("SECOND_WORKOFF_WIFI_ID >=", value, "secondWorkoffWifiId");
			return (Criteria) this;
		}

		public Criteria andSecondWorkoffWifiIdLessThan(Integer value) {
			addCriterion("SECOND_WORKOFF_WIFI_ID <", value, "secondWorkoffWifiId");
			return (Criteria) this;
		}

		public Criteria andSecondWorkoffWifiIdLessThanOrEqualTo(Integer value) {
			addCriterion("SECOND_WORKOFF_WIFI_ID <=", value, "secondWorkoffWifiId");
			return (Criteria) this;
		}

		public Criteria andSecondWorkoffWifiIdIn(List<Integer> values) {
			addCriterion("SECOND_WORKOFF_WIFI_ID in", values, "secondWorkoffWifiId");
			return (Criteria) this;
		}

		public Criteria andSecondWorkoffWifiIdNotIn(List<Integer> values) {
			addCriterion("SECOND_WORKOFF_WIFI_ID not in", values, "secondWorkoffWifiId");
			return (Criteria) this;
		}

		public Criteria andSecondWorkoffWifiIdBetween(Integer value1, Integer value2) {
			addCriterion("SECOND_WORKOFF_WIFI_ID between", value1, value2, "secondWorkoffWifiId");
			return (Criteria) this;
		}

		public Criteria andSecondWorkoffWifiIdNotBetween(Integer value1, Integer value2) {
			addCriterion("SECOND_WORKOFF_WIFI_ID not between", value1, value2, "secondWorkoffWifiId");
			return (Criteria) this;
		}

		public Criteria andSecondWorkoffAttWifiSsidIsNull() {
			addCriterion("SECOND_WORKOFF_ATT_WIFI_SSID is null");
			return (Criteria) this;
		}

		public Criteria andSecondWorkoffAttWifiSsidIsNotNull() {
			addCriterion("SECOND_WORKOFF_ATT_WIFI_SSID is not null");
			return (Criteria) this;
		}

		public Criteria andSecondWorkoffAttWifiSsidEqualTo(String value) {
			addCriterion("SECOND_WORKOFF_ATT_WIFI_SSID =", value, "secondWorkoffAttWifiSsid");
			return (Criteria) this;
		}

		public Criteria andSecondWorkoffAttWifiSsidNotEqualTo(String value) {
			addCriterion("SECOND_WORKOFF_ATT_WIFI_SSID <>", value, "secondWorkoffAttWifiSsid");
			return (Criteria) this;
		}

		public Criteria andSecondWorkoffAttWifiSsidGreaterThan(String value) {
			addCriterion("SECOND_WORKOFF_ATT_WIFI_SSID >", value, "secondWorkoffAttWifiSsid");
			return (Criteria) this;
		}

		public Criteria andSecondWorkoffAttWifiSsidGreaterThanOrEqualTo(String value) {
			addCriterion("SECOND_WORKOFF_ATT_WIFI_SSID >=", value, "secondWorkoffAttWifiSsid");
			return (Criteria) this;
		}

		public Criteria andSecondWorkoffAttWifiSsidLessThan(String value) {
			addCriterion("SECOND_WORKOFF_ATT_WIFI_SSID <", value, "secondWorkoffAttWifiSsid");
			return (Criteria) this;
		}

		public Criteria andSecondWorkoffAttWifiSsidLessThanOrEqualTo(String value) {
			addCriterion("SECOND_WORKOFF_ATT_WIFI_SSID <=", value, "secondWorkoffAttWifiSsid");
			return (Criteria) this;
		}

		public Criteria andSecondWorkoffAttWifiSsidLike(String value) {
			addCriterion("SECOND_WORKOFF_ATT_WIFI_SSID like", value, "secondWorkoffAttWifiSsid");
			return (Criteria) this;
		}

		public Criteria andSecondWorkoffAttWifiSsidNotLike(String value) {
			addCriterion("SECOND_WORKOFF_ATT_WIFI_SSID not like", value, "secondWorkoffAttWifiSsid");
			return (Criteria) this;
		}

		public Criteria andSecondWorkoffAttWifiSsidIn(List<String> values) {
			addCriterion("SECOND_WORKOFF_ATT_WIFI_SSID in", values, "secondWorkoffAttWifiSsid");
			return (Criteria) this;
		}

		public Criteria andSecondWorkoffAttWifiSsidNotIn(List<String> values) {
			addCriterion("SECOND_WORKOFF_ATT_WIFI_SSID not in", values, "secondWorkoffAttWifiSsid");
			return (Criteria) this;
		}

		public Criteria andSecondWorkoffAttWifiSsidBetween(String value1, String value2) {
			addCriterion("SECOND_WORKOFF_ATT_WIFI_SSID between", value1, value2, "secondWorkoffAttWifiSsid");
			return (Criteria) this;
		}

		public Criteria andSecondWorkoffAttWifiSsidNotBetween(String value1, String value2) {
			addCriterion("SECOND_WORKOFF_ATT_WIFI_SSID not between", value1, value2, "secondWorkoffAttWifiSsid");
			return (Criteria) this;
		}

		public Criteria andSecondWorkoffAttWifiMacIsNull() {
			addCriterion("SECOND_WORKOFF_ATT_WIFI_MAC is null");
			return (Criteria) this;
		}

		public Criteria andSecondWorkoffAttWifiMacIsNotNull() {
			addCriterion("SECOND_WORKOFF_ATT_WIFI_MAC is not null");
			return (Criteria) this;
		}

		public Criteria andSecondWorkoffAttWifiMacEqualTo(String value) {
			addCriterion("SECOND_WORKOFF_ATT_WIFI_MAC =", value, "secondWorkoffAttWifiMac");
			return (Criteria) this;
		}

		public Criteria andSecondWorkoffAttWifiMacNotEqualTo(String value) {
			addCriterion("SECOND_WORKOFF_ATT_WIFI_MAC <>", value, "secondWorkoffAttWifiMac");
			return (Criteria) this;
		}

		public Criteria andSecondWorkoffAttWifiMacGreaterThan(String value) {
			addCriterion("SECOND_WORKOFF_ATT_WIFI_MAC >", value, "secondWorkoffAttWifiMac");
			return (Criteria) this;
		}

		public Criteria andSecondWorkoffAttWifiMacGreaterThanOrEqualTo(String value) {
			addCriterion("SECOND_WORKOFF_ATT_WIFI_MAC >=", value, "secondWorkoffAttWifiMac");
			return (Criteria) this;
		}

		public Criteria andSecondWorkoffAttWifiMacLessThan(String value) {
			addCriterion("SECOND_WORKOFF_ATT_WIFI_MAC <", value, "secondWorkoffAttWifiMac");
			return (Criteria) this;
		}

		public Criteria andSecondWorkoffAttWifiMacLessThanOrEqualTo(String value) {
			addCriterion("SECOND_WORKOFF_ATT_WIFI_MAC <=", value, "secondWorkoffAttWifiMac");
			return (Criteria) this;
		}

		public Criteria andSecondWorkoffAttWifiMacLike(String value) {
			addCriterion("SECOND_WORKOFF_ATT_WIFI_MAC like", value, "secondWorkoffAttWifiMac");
			return (Criteria) this;
		}

		public Criteria andSecondWorkoffAttWifiMacNotLike(String value) {
			addCriterion("SECOND_WORKOFF_ATT_WIFI_MAC not like", value, "secondWorkoffAttWifiMac");
			return (Criteria) this;
		}

		public Criteria andSecondWorkoffAttWifiMacIn(List<String> values) {
			addCriterion("SECOND_WORKOFF_ATT_WIFI_MAC in", values, "secondWorkoffAttWifiMac");
			return (Criteria) this;
		}

		public Criteria andSecondWorkoffAttWifiMacNotIn(List<String> values) {
			addCriterion("SECOND_WORKOFF_ATT_WIFI_MAC not in", values, "secondWorkoffAttWifiMac");
			return (Criteria) this;
		}

		public Criteria andSecondWorkoffAttWifiMacBetween(String value1, String value2) {
			addCriterion("SECOND_WORKOFF_ATT_WIFI_MAC between", value1, value2, "secondWorkoffAttWifiMac");
			return (Criteria) this;
		}

		public Criteria andSecondWorkoffAttWifiMacNotBetween(String value1, String value2) {
			addCriterion("SECOND_WORKOFF_ATT_WIFI_MAC not between", value1, value2, "secondWorkoffAttWifiMac");
			return (Criteria) this;
		}

		public Criteria andThreeWorkonAttWayIsNull() {
			addCriterion("THREE_WORKON_ATT_WAY is null");
			return (Criteria) this;
		}

		public Criteria andThreeWorkonAttWayIsNotNull() {
			addCriterion("THREE_WORKON_ATT_WAY is not null");
			return (Criteria) this;
		}

		public Criteria andThreeWorkonAttWayEqualTo(Byte value) {
			addCriterion("THREE_WORKON_ATT_WAY =", value, "threeWorkonAttWay");
			return (Criteria) this;
		}

		public Criteria andThreeWorkonAttWayNotEqualTo(Byte value) {
			addCriterion("THREE_WORKON_ATT_WAY <>", value, "threeWorkonAttWay");
			return (Criteria) this;
		}

		public Criteria andThreeWorkonAttWayGreaterThan(Byte value) {
			addCriterion("THREE_WORKON_ATT_WAY >", value, "threeWorkonAttWay");
			return (Criteria) this;
		}

		public Criteria andThreeWorkonAttWayGreaterThanOrEqualTo(Byte value) {
			addCriterion("THREE_WORKON_ATT_WAY >=", value, "threeWorkonAttWay");
			return (Criteria) this;
		}

		public Criteria andThreeWorkonAttWayLessThan(Byte value) {
			addCriterion("THREE_WORKON_ATT_WAY <", value, "threeWorkonAttWay");
			return (Criteria) this;
		}

		public Criteria andThreeWorkonAttWayLessThanOrEqualTo(Byte value) {
			addCriterion("THREE_WORKON_ATT_WAY <=", value, "threeWorkonAttWay");
			return (Criteria) this;
		}

		public Criteria andThreeWorkonAttWayIn(List<Byte> values) {
			addCriterion("THREE_WORKON_ATT_WAY in", values, "threeWorkonAttWay");
			return (Criteria) this;
		}

		public Criteria andThreeWorkonAttWayNotIn(List<Byte> values) {
			addCriterion("THREE_WORKON_ATT_WAY not in", values, "threeWorkonAttWay");
			return (Criteria) this;
		}

		public Criteria andThreeWorkonAttWayBetween(Byte value1, Byte value2) {
			addCriterion("THREE_WORKON_ATT_WAY between", value1, value2, "threeWorkonAttWay");
			return (Criteria) this;
		}

		public Criteria andThreeWorkonAttWayNotBetween(Byte value1, Byte value2) {
			addCriterion("THREE_WORKON_ATT_WAY not between", value1, value2, "threeWorkonAttWay");
			return (Criteria) this;
		}

		public Criteria andThreeWorkonWifiIdIsNull() {
			addCriterion("THREE_WORKON_WIFI_ID is null");
			return (Criteria) this;
		}

		public Criteria andThreeWorkonWifiIdIsNotNull() {
			addCriterion("THREE_WORKON_WIFI_ID is not null");
			return (Criteria) this;
		}

		public Criteria andThreeWorkonWifiIdEqualTo(Integer value) {
			addCriterion("THREE_WORKON_WIFI_ID =", value, "threeWorkonWifiId");
			return (Criteria) this;
		}

		public Criteria andThreeWorkonWifiIdNotEqualTo(Integer value) {
			addCriterion("THREE_WORKON_WIFI_ID <>", value, "threeWorkonWifiId");
			return (Criteria) this;
		}

		public Criteria andThreeWorkonWifiIdGreaterThan(Integer value) {
			addCriterion("THREE_WORKON_WIFI_ID >", value, "threeWorkonWifiId");
			return (Criteria) this;
		}

		public Criteria andThreeWorkonWifiIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("THREE_WORKON_WIFI_ID >=", value, "threeWorkonWifiId");
			return (Criteria) this;
		}

		public Criteria andThreeWorkonWifiIdLessThan(Integer value) {
			addCriterion("THREE_WORKON_WIFI_ID <", value, "threeWorkonWifiId");
			return (Criteria) this;
		}

		public Criteria andThreeWorkonWifiIdLessThanOrEqualTo(Integer value) {
			addCriterion("THREE_WORKON_WIFI_ID <=", value, "threeWorkonWifiId");
			return (Criteria) this;
		}

		public Criteria andThreeWorkonWifiIdIn(List<Integer> values) {
			addCriterion("THREE_WORKON_WIFI_ID in", values, "threeWorkonWifiId");
			return (Criteria) this;
		}

		public Criteria andThreeWorkonWifiIdNotIn(List<Integer> values) {
			addCriterion("THREE_WORKON_WIFI_ID not in", values, "threeWorkonWifiId");
			return (Criteria) this;
		}

		public Criteria andThreeWorkonWifiIdBetween(Integer value1, Integer value2) {
			addCriterion("THREE_WORKON_WIFI_ID between", value1, value2, "threeWorkonWifiId");
			return (Criteria) this;
		}

		public Criteria andThreeWorkonWifiIdNotBetween(Integer value1, Integer value2) {
			addCriterion("THREE_WORKON_WIFI_ID not between", value1, value2, "threeWorkonWifiId");
			return (Criteria) this;
		}

		public Criteria andThreeWorkonAttWifiSsidIsNull() {
			addCriterion("THREE_WORKON_ATT_WIFI_SSID is null");
			return (Criteria) this;
		}

		public Criteria andThreeWorkonAttWifiSsidIsNotNull() {
			addCriterion("THREE_WORKON_ATT_WIFI_SSID is not null");
			return (Criteria) this;
		}

		public Criteria andThreeWorkonAttWifiSsidEqualTo(String value) {
			addCriterion("THREE_WORKON_ATT_WIFI_SSID =", value, "threeWorkonAttWifiSsid");
			return (Criteria) this;
		}

		public Criteria andThreeWorkonAttWifiSsidNotEqualTo(String value) {
			addCriterion("THREE_WORKON_ATT_WIFI_SSID <>", value, "threeWorkonAttWifiSsid");
			return (Criteria) this;
		}

		public Criteria andThreeWorkonAttWifiSsidGreaterThan(String value) {
			addCriterion("THREE_WORKON_ATT_WIFI_SSID >", value, "threeWorkonAttWifiSsid");
			return (Criteria) this;
		}

		public Criteria andThreeWorkonAttWifiSsidGreaterThanOrEqualTo(String value) {
			addCriterion("THREE_WORKON_ATT_WIFI_SSID >=", value, "threeWorkonAttWifiSsid");
			return (Criteria) this;
		}

		public Criteria andThreeWorkonAttWifiSsidLessThan(String value) {
			addCriterion("THREE_WORKON_ATT_WIFI_SSID <", value, "threeWorkonAttWifiSsid");
			return (Criteria) this;
		}

		public Criteria andThreeWorkonAttWifiSsidLessThanOrEqualTo(String value) {
			addCriterion("THREE_WORKON_ATT_WIFI_SSID <=", value, "threeWorkonAttWifiSsid");
			return (Criteria) this;
		}

		public Criteria andThreeWorkonAttWifiSsidLike(String value) {
			addCriterion("THREE_WORKON_ATT_WIFI_SSID like", value, "threeWorkonAttWifiSsid");
			return (Criteria) this;
		}

		public Criteria andThreeWorkonAttWifiSsidNotLike(String value) {
			addCriterion("THREE_WORKON_ATT_WIFI_SSID not like", value, "threeWorkonAttWifiSsid");
			return (Criteria) this;
		}

		public Criteria andThreeWorkonAttWifiSsidIn(List<String> values) {
			addCriterion("THREE_WORKON_ATT_WIFI_SSID in", values, "threeWorkonAttWifiSsid");
			return (Criteria) this;
		}

		public Criteria andThreeWorkonAttWifiSsidNotIn(List<String> values) {
			addCriterion("THREE_WORKON_ATT_WIFI_SSID not in", values, "threeWorkonAttWifiSsid");
			return (Criteria) this;
		}

		public Criteria andThreeWorkonAttWifiSsidBetween(String value1, String value2) {
			addCriterion("THREE_WORKON_ATT_WIFI_SSID between", value1, value2, "threeWorkonAttWifiSsid");
			return (Criteria) this;
		}

		public Criteria andThreeWorkonAttWifiSsidNotBetween(String value1, String value2) {
			addCriterion("THREE_WORKON_ATT_WIFI_SSID not between", value1, value2, "threeWorkonAttWifiSsid");
			return (Criteria) this;
		}

		public Criteria andThreeWorkonAttWifiMacIsNull() {
			addCriterion("THREE_WORKON_ATT_WIFI_MAC is null");
			return (Criteria) this;
		}

		public Criteria andThreeWorkonAttWifiMacIsNotNull() {
			addCriterion("THREE_WORKON_ATT_WIFI_MAC is not null");
			return (Criteria) this;
		}

		public Criteria andThreeWorkonAttWifiMacEqualTo(String value) {
			addCriterion("THREE_WORKON_ATT_WIFI_MAC =", value, "threeWorkonAttWifiMac");
			return (Criteria) this;
		}

		public Criteria andThreeWorkonAttWifiMacNotEqualTo(String value) {
			addCriterion("THREE_WORKON_ATT_WIFI_MAC <>", value, "threeWorkonAttWifiMac");
			return (Criteria) this;
		}

		public Criteria andThreeWorkonAttWifiMacGreaterThan(String value) {
			addCriterion("THREE_WORKON_ATT_WIFI_MAC >", value, "threeWorkonAttWifiMac");
			return (Criteria) this;
		}

		public Criteria andThreeWorkonAttWifiMacGreaterThanOrEqualTo(String value) {
			addCriterion("THREE_WORKON_ATT_WIFI_MAC >=", value, "threeWorkonAttWifiMac");
			return (Criteria) this;
		}

		public Criteria andThreeWorkonAttWifiMacLessThan(String value) {
			addCriterion("THREE_WORKON_ATT_WIFI_MAC <", value, "threeWorkonAttWifiMac");
			return (Criteria) this;
		}

		public Criteria andThreeWorkonAttWifiMacLessThanOrEqualTo(String value) {
			addCriterion("THREE_WORKON_ATT_WIFI_MAC <=", value, "threeWorkonAttWifiMac");
			return (Criteria) this;
		}

		public Criteria andThreeWorkonAttWifiMacLike(String value) {
			addCriterion("THREE_WORKON_ATT_WIFI_MAC like", value, "threeWorkonAttWifiMac");
			return (Criteria) this;
		}

		public Criteria andThreeWorkonAttWifiMacNotLike(String value) {
			addCriterion("THREE_WORKON_ATT_WIFI_MAC not like", value, "threeWorkonAttWifiMac");
			return (Criteria) this;
		}

		public Criteria andThreeWorkonAttWifiMacIn(List<String> values) {
			addCriterion("THREE_WORKON_ATT_WIFI_MAC in", values, "threeWorkonAttWifiMac");
			return (Criteria) this;
		}

		public Criteria andThreeWorkonAttWifiMacNotIn(List<String> values) {
			addCriterion("THREE_WORKON_ATT_WIFI_MAC not in", values, "threeWorkonAttWifiMac");
			return (Criteria) this;
		}

		public Criteria andThreeWorkonAttWifiMacBetween(String value1, String value2) {
			addCriterion("THREE_WORKON_ATT_WIFI_MAC between", value1, value2, "threeWorkonAttWifiMac");
			return (Criteria) this;
		}

		public Criteria andThreeWorkonAttWifiMacNotBetween(String value1, String value2) {
			addCriterion("THREE_WORKON_ATT_WIFI_MAC not between", value1, value2, "threeWorkonAttWifiMac");
			return (Criteria) this;
		}

		public Criteria andThreeWorkoffAttWayIsNull() {
			addCriterion("THREE_WORKOFF_ATT_WAY is null");
			return (Criteria) this;
		}

		public Criteria andThreeWorkoffAttWayIsNotNull() {
			addCriterion("THREE_WORKOFF_ATT_WAY is not null");
			return (Criteria) this;
		}

		public Criteria andThreeWorkoffAttWayEqualTo(Byte value) {
			addCriterion("THREE_WORKOFF_ATT_WAY =", value, "threeWorkoffAttWay");
			return (Criteria) this;
		}

		public Criteria andThreeWorkoffAttWayNotEqualTo(Byte value) {
			addCriterion("THREE_WORKOFF_ATT_WAY <>", value, "threeWorkoffAttWay");
			return (Criteria) this;
		}

		public Criteria andThreeWorkoffAttWayGreaterThan(Byte value) {
			addCriterion("THREE_WORKOFF_ATT_WAY >", value, "threeWorkoffAttWay");
			return (Criteria) this;
		}

		public Criteria andThreeWorkoffAttWayGreaterThanOrEqualTo(Byte value) {
			addCriterion("THREE_WORKOFF_ATT_WAY >=", value, "threeWorkoffAttWay");
			return (Criteria) this;
		}

		public Criteria andThreeWorkoffAttWayLessThan(Byte value) {
			addCriterion("THREE_WORKOFF_ATT_WAY <", value, "threeWorkoffAttWay");
			return (Criteria) this;
		}

		public Criteria andThreeWorkoffAttWayLessThanOrEqualTo(Byte value) {
			addCriterion("THREE_WORKOFF_ATT_WAY <=", value, "threeWorkoffAttWay");
			return (Criteria) this;
		}

		public Criteria andThreeWorkoffAttWayIn(List<Byte> values) {
			addCriterion("THREE_WORKOFF_ATT_WAY in", values, "threeWorkoffAttWay");
			return (Criteria) this;
		}

		public Criteria andThreeWorkoffAttWayNotIn(List<Byte> values) {
			addCriterion("THREE_WORKOFF_ATT_WAY not in", values, "threeWorkoffAttWay");
			return (Criteria) this;
		}

		public Criteria andThreeWorkoffAttWayBetween(Byte value1, Byte value2) {
			addCriterion("THREE_WORKOFF_ATT_WAY between", value1, value2, "threeWorkoffAttWay");
			return (Criteria) this;
		}

		public Criteria andThreeWorkoffAttWayNotBetween(Byte value1, Byte value2) {
			addCriterion("THREE_WORKOFF_ATT_WAY not between", value1, value2, "threeWorkoffAttWay");
			return (Criteria) this;
		}

		public Criteria andThreeWorkoffWifiIdIsNull() {
			addCriterion("THREE_WORKOFF_WIFI_ID is null");
			return (Criteria) this;
		}

		public Criteria andThreeWorkoffWifiIdIsNotNull() {
			addCriterion("THREE_WORKOFF_WIFI_ID is not null");
			return (Criteria) this;
		}

		public Criteria andThreeWorkoffWifiIdEqualTo(Integer value) {
			addCriterion("THREE_WORKOFF_WIFI_ID =", value, "threeWorkoffWifiId");
			return (Criteria) this;
		}

		public Criteria andThreeWorkoffWifiIdNotEqualTo(Integer value) {
			addCriterion("THREE_WORKOFF_WIFI_ID <>", value, "threeWorkoffWifiId");
			return (Criteria) this;
		}

		public Criteria andThreeWorkoffWifiIdGreaterThan(Integer value) {
			addCriterion("THREE_WORKOFF_WIFI_ID >", value, "threeWorkoffWifiId");
			return (Criteria) this;
		}

		public Criteria andThreeWorkoffWifiIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("THREE_WORKOFF_WIFI_ID >=", value, "threeWorkoffWifiId");
			return (Criteria) this;
		}

		public Criteria andThreeWorkoffWifiIdLessThan(Integer value) {
			addCriterion("THREE_WORKOFF_WIFI_ID <", value, "threeWorkoffWifiId");
			return (Criteria) this;
		}

		public Criteria andThreeWorkoffWifiIdLessThanOrEqualTo(Integer value) {
			addCriterion("THREE_WORKOFF_WIFI_ID <=", value, "threeWorkoffWifiId");
			return (Criteria) this;
		}

		public Criteria andThreeWorkoffWifiIdIn(List<Integer> values) {
			addCriterion("THREE_WORKOFF_WIFI_ID in", values, "threeWorkoffWifiId");
			return (Criteria) this;
		}

		public Criteria andThreeWorkoffWifiIdNotIn(List<Integer> values) {
			addCriterion("THREE_WORKOFF_WIFI_ID not in", values, "threeWorkoffWifiId");
			return (Criteria) this;
		}

		public Criteria andThreeWorkoffWifiIdBetween(Integer value1, Integer value2) {
			addCriterion("THREE_WORKOFF_WIFI_ID between", value1, value2, "threeWorkoffWifiId");
			return (Criteria) this;
		}

		public Criteria andThreeWorkoffWifiIdNotBetween(Integer value1, Integer value2) {
			addCriterion("THREE_WORKOFF_WIFI_ID not between", value1, value2, "threeWorkoffWifiId");
			return (Criteria) this;
		}

		public Criteria andThreeWorkoffAttWifiSsidIsNull() {
			addCriterion("THREE_WORKOFF_ATT_WIFI_SSID is null");
			return (Criteria) this;
		}

		public Criteria andThreeWorkoffAttWifiSsidIsNotNull() {
			addCriterion("THREE_WORKOFF_ATT_WIFI_SSID is not null");
			return (Criteria) this;
		}

		public Criteria andThreeWorkoffAttWifiSsidEqualTo(String value) {
			addCriterion("THREE_WORKOFF_ATT_WIFI_SSID =", value, "threeWorkoffAttWifiSsid");
			return (Criteria) this;
		}

		public Criteria andThreeWorkoffAttWifiSsidNotEqualTo(String value) {
			addCriterion("THREE_WORKOFF_ATT_WIFI_SSID <>", value, "threeWorkoffAttWifiSsid");
			return (Criteria) this;
		}

		public Criteria andThreeWorkoffAttWifiSsidGreaterThan(String value) {
			addCriterion("THREE_WORKOFF_ATT_WIFI_SSID >", value, "threeWorkoffAttWifiSsid");
			return (Criteria) this;
		}

		public Criteria andThreeWorkoffAttWifiSsidGreaterThanOrEqualTo(String value) {
			addCriterion("THREE_WORKOFF_ATT_WIFI_SSID >=", value, "threeWorkoffAttWifiSsid");
			return (Criteria) this;
		}

		public Criteria andThreeWorkoffAttWifiSsidLessThan(String value) {
			addCriterion("THREE_WORKOFF_ATT_WIFI_SSID <", value, "threeWorkoffAttWifiSsid");
			return (Criteria) this;
		}

		public Criteria andThreeWorkoffAttWifiSsidLessThanOrEqualTo(String value) {
			addCriterion("THREE_WORKOFF_ATT_WIFI_SSID <=", value, "threeWorkoffAttWifiSsid");
			return (Criteria) this;
		}

		public Criteria andThreeWorkoffAttWifiSsidLike(String value) {
			addCriterion("THREE_WORKOFF_ATT_WIFI_SSID like", value, "threeWorkoffAttWifiSsid");
			return (Criteria) this;
		}

		public Criteria andThreeWorkoffAttWifiSsidNotLike(String value) {
			addCriterion("THREE_WORKOFF_ATT_WIFI_SSID not like", value, "threeWorkoffAttWifiSsid");
			return (Criteria) this;
		}

		public Criteria andThreeWorkoffAttWifiSsidIn(List<String> values) {
			addCriterion("THREE_WORKOFF_ATT_WIFI_SSID in", values, "threeWorkoffAttWifiSsid");
			return (Criteria) this;
		}

		public Criteria andThreeWorkoffAttWifiSsidNotIn(List<String> values) {
			addCriterion("THREE_WORKOFF_ATT_WIFI_SSID not in", values, "threeWorkoffAttWifiSsid");
			return (Criteria) this;
		}

		public Criteria andThreeWorkoffAttWifiSsidBetween(String value1, String value2) {
			addCriterion("THREE_WORKOFF_ATT_WIFI_SSID between", value1, value2, "threeWorkoffAttWifiSsid");
			return (Criteria) this;
		}

		public Criteria andThreeWorkoffAttWifiSsidNotBetween(String value1, String value2) {
			addCriterion("THREE_WORKOFF_ATT_WIFI_SSID not between", value1, value2, "threeWorkoffAttWifiSsid");
			return (Criteria) this;
		}

		public Criteria andThreeWorkoffAttWifiMacIsNull() {
			addCriterion("THREE_WORKOFF_ATT_WIFI_MAC is null");
			return (Criteria) this;
		}

		public Criteria andThreeWorkoffAttWifiMacIsNotNull() {
			addCriterion("THREE_WORKOFF_ATT_WIFI_MAC is not null");
			return (Criteria) this;
		}

		public Criteria andThreeWorkoffAttWifiMacEqualTo(String value) {
			addCriterion("THREE_WORKOFF_ATT_WIFI_MAC =", value, "threeWorkoffAttWifiMac");
			return (Criteria) this;
		}

		public Criteria andThreeWorkoffAttWifiMacNotEqualTo(String value) {
			addCriterion("THREE_WORKOFF_ATT_WIFI_MAC <>", value, "threeWorkoffAttWifiMac");
			return (Criteria) this;
		}

		public Criteria andThreeWorkoffAttWifiMacGreaterThan(String value) {
			addCriterion("THREE_WORKOFF_ATT_WIFI_MAC >", value, "threeWorkoffAttWifiMac");
			return (Criteria) this;
		}

		public Criteria andThreeWorkoffAttWifiMacGreaterThanOrEqualTo(String value) {
			addCriterion("THREE_WORKOFF_ATT_WIFI_MAC >=", value, "threeWorkoffAttWifiMac");
			return (Criteria) this;
		}

		public Criteria andThreeWorkoffAttWifiMacLessThan(String value) {
			addCriterion("THREE_WORKOFF_ATT_WIFI_MAC <", value, "threeWorkoffAttWifiMac");
			return (Criteria) this;
		}

		public Criteria andThreeWorkoffAttWifiMacLessThanOrEqualTo(String value) {
			addCriterion("THREE_WORKOFF_ATT_WIFI_MAC <=", value, "threeWorkoffAttWifiMac");
			return (Criteria) this;
		}

		public Criteria andThreeWorkoffAttWifiMacLike(String value) {
			addCriterion("THREE_WORKOFF_ATT_WIFI_MAC like", value, "threeWorkoffAttWifiMac");
			return (Criteria) this;
		}

		public Criteria andThreeWorkoffAttWifiMacNotLike(String value) {
			addCriterion("THREE_WORKOFF_ATT_WIFI_MAC not like", value, "threeWorkoffAttWifiMac");
			return (Criteria) this;
		}

		public Criteria andThreeWorkoffAttWifiMacIn(List<String> values) {
			addCriterion("THREE_WORKOFF_ATT_WIFI_MAC in", values, "threeWorkoffAttWifiMac");
			return (Criteria) this;
		}

		public Criteria andThreeWorkoffAttWifiMacNotIn(List<String> values) {
			addCriterion("THREE_WORKOFF_ATT_WIFI_MAC not in", values, "threeWorkoffAttWifiMac");
			return (Criteria) this;
		}

		public Criteria andThreeWorkoffAttWifiMacBetween(String value1, String value2) {
			addCriterion("THREE_WORKOFF_ATT_WIFI_MAC between", value1, value2, "threeWorkoffAttWifiMac");
			return (Criteria) this;
		}

		public Criteria andThreeWorkoffAttWifiMacNotBetween(String value1, String value2) {
			addCriterion("THREE_WORKOFF_ATT_WIFI_MAC not between", value1, value2, "threeWorkoffAttWifiMac");
			return (Criteria) this;
		}

		public Criteria andFirstWorkonChangedateIsNull() {
			addCriterion("FIRST_WORKON_CHANGEDATE is null");
			return (Criteria) this;
		}

		public Criteria andFirstWorkonChangedateIsNotNull() {
			addCriterion("FIRST_WORKON_CHANGEDATE is not null");
			return (Criteria) this;
		}

		public Criteria andFirstWorkonChangedateEqualTo(Date value) {
			addCriterion("FIRST_WORKON_CHANGEDATE =", value, "firstWorkonChangedate");
			return (Criteria) this;
		}

		public Criteria andFirstWorkonChangedateNotEqualTo(Date value) {
			addCriterion("FIRST_WORKON_CHANGEDATE <>", value, "firstWorkonChangedate");
			return (Criteria) this;
		}

		public Criteria andFirstWorkonChangedateGreaterThan(Date value) {
			addCriterion("FIRST_WORKON_CHANGEDATE >", value, "firstWorkonChangedate");
			return (Criteria) this;
		}

		public Criteria andFirstWorkonChangedateGreaterThanOrEqualTo(Date value) {
			addCriterion("FIRST_WORKON_CHANGEDATE >=", value, "firstWorkonChangedate");
			return (Criteria) this;
		}

		public Criteria andFirstWorkonChangedateLessThan(Date value) {
			addCriterion("FIRST_WORKON_CHANGEDATE <", value, "firstWorkonChangedate");
			return (Criteria) this;
		}

		public Criteria andFirstWorkonChangedateLessThanOrEqualTo(Date value) {
			addCriterion("FIRST_WORKON_CHANGEDATE <=", value, "firstWorkonChangedate");
			return (Criteria) this;
		}

		public Criteria andFirstWorkonChangedateIn(List<Date> values) {
			addCriterion("FIRST_WORKON_CHANGEDATE in", values, "firstWorkonChangedate");
			return (Criteria) this;
		}

		public Criteria andFirstWorkonChangedateNotIn(List<Date> values) {
			addCriterion("FIRST_WORKON_CHANGEDATE not in", values, "firstWorkonChangedate");
			return (Criteria) this;
		}

		public Criteria andFirstWorkonChangedateBetween(Date value1, Date value2) {
			addCriterion("FIRST_WORKON_CHANGEDATE between", value1, value2, "firstWorkonChangedate");
			return (Criteria) this;
		}

		public Criteria andFirstWorkonChangedateNotBetween(Date value1, Date value2) {
			addCriterion("FIRST_WORKON_CHANGEDATE not between", value1, value2, "firstWorkonChangedate");
			return (Criteria) this;
		}

		public Criteria andSecondWorkonChangedateIsNull() {
			addCriterion("SECOND_WORKON_CHANGEDATE is null");
			return (Criteria) this;
		}

		public Criteria andSecondWorkonChangedateIsNotNull() {
			addCriterion("SECOND_WORKON_CHANGEDATE is not null");
			return (Criteria) this;
		}

		public Criteria andSecondWorkonChangedateEqualTo(Date value) {
			addCriterion("SECOND_WORKON_CHANGEDATE =", value, "secondWorkonChangedate");
			return (Criteria) this;
		}

		public Criteria andSecondWorkonChangedateNotEqualTo(Date value) {
			addCriterion("SECOND_WORKON_CHANGEDATE <>", value, "secondWorkonChangedate");
			return (Criteria) this;
		}

		public Criteria andSecondWorkonChangedateGreaterThan(Date value) {
			addCriterion("SECOND_WORKON_CHANGEDATE >", value, "secondWorkonChangedate");
			return (Criteria) this;
		}

		public Criteria andSecondWorkonChangedateGreaterThanOrEqualTo(Date value) {
			addCriterion("SECOND_WORKON_CHANGEDATE >=", value, "secondWorkonChangedate");
			return (Criteria) this;
		}

		public Criteria andSecondWorkonChangedateLessThan(Date value) {
			addCriterion("SECOND_WORKON_CHANGEDATE <", value, "secondWorkonChangedate");
			return (Criteria) this;
		}

		public Criteria andSecondWorkonChangedateLessThanOrEqualTo(Date value) {
			addCriterion("SECOND_WORKON_CHANGEDATE <=", value, "secondWorkonChangedate");
			return (Criteria) this;
		}

		public Criteria andSecondWorkonChangedateIn(List<Date> values) {
			addCriterion("SECOND_WORKON_CHANGEDATE in", values, "secondWorkonChangedate");
			return (Criteria) this;
		}

		public Criteria andSecondWorkonChangedateNotIn(List<Date> values) {
			addCriterion("SECOND_WORKON_CHANGEDATE not in", values, "secondWorkonChangedate");
			return (Criteria) this;
		}

		public Criteria andSecondWorkonChangedateBetween(Date value1, Date value2) {
			addCriterion("SECOND_WORKON_CHANGEDATE between", value1, value2, "secondWorkonChangedate");
			return (Criteria) this;
		}

		public Criteria andSecondWorkonChangedateNotBetween(Date value1, Date value2) {
			addCriterion("SECOND_WORKON_CHANGEDATE not between", value1, value2, "secondWorkonChangedate");
			return (Criteria) this;
		}

		public Criteria andThreeWorkonChangedateIsNull() {
			addCriterion("THREE_WORKON_CHANGEDATE is null");
			return (Criteria) this;
		}

		public Criteria andThreeWorkonChangedateIsNotNull() {
			addCriterion("THREE_WORKON_CHANGEDATE is not null");
			return (Criteria) this;
		}

		public Criteria andThreeWorkonChangedateEqualTo(Date value) {
			addCriterion("THREE_WORKON_CHANGEDATE =", value, "threeWorkonChangedate");
			return (Criteria) this;
		}

		public Criteria andThreeWorkonChangedateNotEqualTo(Date value) {
			addCriterion("THREE_WORKON_CHANGEDATE <>", value, "threeWorkonChangedate");
			return (Criteria) this;
		}

		public Criteria andThreeWorkonChangedateGreaterThan(Date value) {
			addCriterion("THREE_WORKON_CHANGEDATE >", value, "threeWorkonChangedate");
			return (Criteria) this;
		}

		public Criteria andThreeWorkonChangedateGreaterThanOrEqualTo(Date value) {
			addCriterion("THREE_WORKON_CHANGEDATE >=", value, "threeWorkonChangedate");
			return (Criteria) this;
		}

		public Criteria andThreeWorkonChangedateLessThan(Date value) {
			addCriterion("THREE_WORKON_CHANGEDATE <", value, "threeWorkonChangedate");
			return (Criteria) this;
		}

		public Criteria andThreeWorkonChangedateLessThanOrEqualTo(Date value) {
			addCriterion("THREE_WORKON_CHANGEDATE <=", value, "threeWorkonChangedate");
			return (Criteria) this;
		}

		public Criteria andThreeWorkonChangedateIn(List<Date> values) {
			addCriterion("THREE_WORKON_CHANGEDATE in", values, "threeWorkonChangedate");
			return (Criteria) this;
		}

		public Criteria andThreeWorkonChangedateNotIn(List<Date> values) {
			addCriterion("THREE_WORKON_CHANGEDATE not in", values, "threeWorkonChangedate");
			return (Criteria) this;
		}

		public Criteria andThreeWorkonChangedateBetween(Date value1, Date value2) {
			addCriterion("THREE_WORKON_CHANGEDATE between", value1, value2, "threeWorkonChangedate");
			return (Criteria) this;
		}

		public Criteria andThreeWorkonChangedateNotBetween(Date value1, Date value2) {
			addCriterion("THREE_WORKON_CHANGEDATE not between", value1, value2, "threeWorkonChangedate");
			return (Criteria) this;
		}

		public Criteria andFirstWorkoffChangedateIsNull() {
			addCriterion("FIRST_WORKOFF_CHANGEDATE is null");
			return (Criteria) this;
		}

		public Criteria andFirstWorkoffChangedateIsNotNull() {
			addCriterion("FIRST_WORKOFF_CHANGEDATE is not null");
			return (Criteria) this;
		}

		public Criteria andFirstWorkoffChangedateEqualTo(Date value) {
			addCriterion("FIRST_WORKOFF_CHANGEDATE =", value, "firstWorkoffChangedate");
			return (Criteria) this;
		}

		public Criteria andFirstWorkoffChangedateNotEqualTo(Date value) {
			addCriterion("FIRST_WORKOFF_CHANGEDATE <>", value, "firstWorkoffChangedate");
			return (Criteria) this;
		}

		public Criteria andFirstWorkoffChangedateGreaterThan(Date value) {
			addCriterion("FIRST_WORKOFF_CHANGEDATE >", value, "firstWorkoffChangedate");
			return (Criteria) this;
		}

		public Criteria andFirstWorkoffChangedateGreaterThanOrEqualTo(Date value) {
			addCriterion("FIRST_WORKOFF_CHANGEDATE >=", value, "firstWorkoffChangedate");
			return (Criteria) this;
		}

		public Criteria andFirstWorkoffChangedateLessThan(Date value) {
			addCriterion("FIRST_WORKOFF_CHANGEDATE <", value, "firstWorkoffChangedate");
			return (Criteria) this;
		}

		public Criteria andFirstWorkoffChangedateLessThanOrEqualTo(Date value) {
			addCriterion("FIRST_WORKOFF_CHANGEDATE <=", value, "firstWorkoffChangedate");
			return (Criteria) this;
		}

		public Criteria andFirstWorkoffChangedateIn(List<Date> values) {
			addCriterion("FIRST_WORKOFF_CHANGEDATE in", values, "firstWorkoffChangedate");
			return (Criteria) this;
		}

		public Criteria andFirstWorkoffChangedateNotIn(List<Date> values) {
			addCriterion("FIRST_WORKOFF_CHANGEDATE not in", values, "firstWorkoffChangedate");
			return (Criteria) this;
		}

		public Criteria andFirstWorkoffChangedateBetween(Date value1, Date value2) {
			addCriterion("FIRST_WORKOFF_CHANGEDATE between", value1, value2, "firstWorkoffChangedate");
			return (Criteria) this;
		}

		public Criteria andFirstWorkoffChangedateNotBetween(Date value1, Date value2) {
			addCriterion("FIRST_WORKOFF_CHANGEDATE not between", value1, value2, "firstWorkoffChangedate");
			return (Criteria) this;
		}

		public Criteria andSecondWorkoffChangedateIsNull() {
			addCriterion("SECOND_WORKOFF_CHANGEDATE is null");
			return (Criteria) this;
		}

		public Criteria andSecondWorkoffChangedateIsNotNull() {
			addCriterion("SECOND_WORKOFF_CHANGEDATE is not null");
			return (Criteria) this;
		}

		public Criteria andSecondWorkoffChangedateEqualTo(Date value) {
			addCriterion("SECOND_WORKOFF_CHANGEDATE =", value, "secondWorkoffChangedate");
			return (Criteria) this;
		}

		public Criteria andSecondWorkoffChangedateNotEqualTo(Date value) {
			addCriterion("SECOND_WORKOFF_CHANGEDATE <>", value, "secondWorkoffChangedate");
			return (Criteria) this;
		}

		public Criteria andSecondWorkoffChangedateGreaterThan(Date value) {
			addCriterion("SECOND_WORKOFF_CHANGEDATE >", value, "secondWorkoffChangedate");
			return (Criteria) this;
		}

		public Criteria andSecondWorkoffChangedateGreaterThanOrEqualTo(Date value) {
			addCriterion("SECOND_WORKOFF_CHANGEDATE >=", value, "secondWorkoffChangedate");
			return (Criteria) this;
		}

		public Criteria andSecondWorkoffChangedateLessThan(Date value) {
			addCriterion("SECOND_WORKOFF_CHANGEDATE <", value, "secondWorkoffChangedate");
			return (Criteria) this;
		}

		public Criteria andSecondWorkoffChangedateLessThanOrEqualTo(Date value) {
			addCriterion("SECOND_WORKOFF_CHANGEDATE <=", value, "secondWorkoffChangedate");
			return (Criteria) this;
		}

		public Criteria andSecondWorkoffChangedateIn(List<Date> values) {
			addCriterion("SECOND_WORKOFF_CHANGEDATE in", values, "secondWorkoffChangedate");
			return (Criteria) this;
		}

		public Criteria andSecondWorkoffChangedateNotIn(List<Date> values) {
			addCriterion("SECOND_WORKOFF_CHANGEDATE not in", values, "secondWorkoffChangedate");
			return (Criteria) this;
		}

		public Criteria andSecondWorkoffChangedateBetween(Date value1, Date value2) {
			addCriterion("SECOND_WORKOFF_CHANGEDATE between", value1, value2, "secondWorkoffChangedate");
			return (Criteria) this;
		}

		public Criteria andSecondWorkoffChangedateNotBetween(Date value1, Date value2) {
			addCriterion("SECOND_WORKOFF_CHANGEDATE not between", value1, value2, "secondWorkoffChangedate");
			return (Criteria) this;
		}

		public Criteria andThreeWorkoffChangedateIsNull() {
			addCriterion("THREE_WORKOFF_CHANGEDATE is null");
			return (Criteria) this;
		}

		public Criteria andThreeWorkoffChangedateIsNotNull() {
			addCriterion("THREE_WORKOFF_CHANGEDATE is not null");
			return (Criteria) this;
		}

		public Criteria andThreeWorkoffChangedateEqualTo(Date value) {
			addCriterion("THREE_WORKOFF_CHANGEDATE =", value, "threeWorkoffChangedate");
			return (Criteria) this;
		}

		public Criteria andThreeWorkoffChangedateNotEqualTo(Date value) {
			addCriterion("THREE_WORKOFF_CHANGEDATE <>", value, "threeWorkoffChangedate");
			return (Criteria) this;
		}

		public Criteria andThreeWorkoffChangedateGreaterThan(Date value) {
			addCriterion("THREE_WORKOFF_CHANGEDATE >", value, "threeWorkoffChangedate");
			return (Criteria) this;
		}

		public Criteria andThreeWorkoffChangedateGreaterThanOrEqualTo(Date value) {
			addCriterion("THREE_WORKOFF_CHANGEDATE >=", value, "threeWorkoffChangedate");
			return (Criteria) this;
		}

		public Criteria andThreeWorkoffChangedateLessThan(Date value) {
			addCriterion("THREE_WORKOFF_CHANGEDATE <", value, "threeWorkoffChangedate");
			return (Criteria) this;
		}

		public Criteria andThreeWorkoffChangedateLessThanOrEqualTo(Date value) {
			addCriterion("THREE_WORKOFF_CHANGEDATE <=", value, "threeWorkoffChangedate");
			return (Criteria) this;
		}

		public Criteria andThreeWorkoffChangedateIn(List<Date> values) {
			addCriterion("THREE_WORKOFF_CHANGEDATE in", values, "threeWorkoffChangedate");
			return (Criteria) this;
		}

		public Criteria andThreeWorkoffChangedateNotIn(List<Date> values) {
			addCriterion("THREE_WORKOFF_CHANGEDATE not in", values, "threeWorkoffChangedate");
			return (Criteria) this;
		}

		public Criteria andThreeWorkoffChangedateBetween(Date value1, Date value2) {
			addCriterion("THREE_WORKOFF_CHANGEDATE between", value1, value2, "threeWorkoffChangedate");
			return (Criteria) this;
		}

		public Criteria andThreeWorkoffChangedateNotBetween(Date value1, Date value2) {
			addCriterion("THREE_WORKOFF_CHANGEDATE not between", value1, value2, "threeWorkoffChangedate");
			return (Criteria) this;
		}

		public Criteria andFirstWorkonAuditIdIsNull() {
			addCriterion("FIRST_WORKON_AUDIT_ID is null");
			return (Criteria) this;
		}

		public Criteria andFirstWorkonAuditIdIsNotNull() {
			addCriterion("FIRST_WORKON_AUDIT_ID is not null");
			return (Criteria) this;
		}

		public Criteria andFirstWorkonAuditIdEqualTo(Integer value) {
			addCriterion("FIRST_WORKON_AUDIT_ID =", value, "firstWorkonAuditId");
			return (Criteria) this;
		}

		public Criteria andFirstWorkonAuditIdNotEqualTo(Integer value) {
			addCriterion("FIRST_WORKON_AUDIT_ID <>", value, "firstWorkonAuditId");
			return (Criteria) this;
		}

		public Criteria andFirstWorkonAuditIdGreaterThan(Integer value) {
			addCriterion("FIRST_WORKON_AUDIT_ID >", value, "firstWorkonAuditId");
			return (Criteria) this;
		}

		public Criteria andFirstWorkonAuditIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("FIRST_WORKON_AUDIT_ID >=", value, "firstWorkonAuditId");
			return (Criteria) this;
		}

		public Criteria andFirstWorkonAuditIdLessThan(Integer value) {
			addCriterion("FIRST_WORKON_AUDIT_ID <", value, "firstWorkonAuditId");
			return (Criteria) this;
		}

		public Criteria andFirstWorkonAuditIdLessThanOrEqualTo(Integer value) {
			addCriterion("FIRST_WORKON_AUDIT_ID <=", value, "firstWorkonAuditId");
			return (Criteria) this;
		}

		public Criteria andFirstWorkonAuditIdIn(List<Integer> values) {
			addCriterion("FIRST_WORKON_AUDIT_ID in", values, "firstWorkonAuditId");
			return (Criteria) this;
		}

		public Criteria andFirstWorkonAuditIdNotIn(List<Integer> values) {
			addCriterion("FIRST_WORKON_AUDIT_ID not in", values, "firstWorkonAuditId");
			return (Criteria) this;
		}

		public Criteria andFirstWorkonAuditIdBetween(Integer value1, Integer value2) {
			addCriterion("FIRST_WORKON_AUDIT_ID between", value1, value2, "firstWorkonAuditId");
			return (Criteria) this;
		}

		public Criteria andFirstWorkonAuditIdNotBetween(Integer value1, Integer value2) {
			addCriterion("FIRST_WORKON_AUDIT_ID not between", value1, value2, "firstWorkonAuditId");
			return (Criteria) this;
		}

		public Criteria andSecondWorkonAuditIdIsNull() {
			addCriterion("SECOND_WORKON_AUDIT_ID is null");
			return (Criteria) this;
		}

		public Criteria andSecondWorkonAuditIdIsNotNull() {
			addCriterion("SECOND_WORKON_AUDIT_ID is not null");
			return (Criteria) this;
		}

		public Criteria andSecondWorkonAuditIdEqualTo(Integer value) {
			addCriterion("SECOND_WORKON_AUDIT_ID =", value, "secondWorkonAuditId");
			return (Criteria) this;
		}

		public Criteria andSecondWorkonAuditIdNotEqualTo(Integer value) {
			addCriterion("SECOND_WORKON_AUDIT_ID <>", value, "secondWorkonAuditId");
			return (Criteria) this;
		}

		public Criteria andSecondWorkonAuditIdGreaterThan(Integer value) {
			addCriterion("SECOND_WORKON_AUDIT_ID >", value, "secondWorkonAuditId");
			return (Criteria) this;
		}

		public Criteria andSecondWorkonAuditIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("SECOND_WORKON_AUDIT_ID >=", value, "secondWorkonAuditId");
			return (Criteria) this;
		}

		public Criteria andSecondWorkonAuditIdLessThan(Integer value) {
			addCriterion("SECOND_WORKON_AUDIT_ID <", value, "secondWorkonAuditId");
			return (Criteria) this;
		}

		public Criteria andSecondWorkonAuditIdLessThanOrEqualTo(Integer value) {
			addCriterion("SECOND_WORKON_AUDIT_ID <=", value, "secondWorkonAuditId");
			return (Criteria) this;
		}

		public Criteria andSecondWorkonAuditIdIn(List<Integer> values) {
			addCriterion("SECOND_WORKON_AUDIT_ID in", values, "secondWorkonAuditId");
			return (Criteria) this;
		}

		public Criteria andSecondWorkonAuditIdNotIn(List<Integer> values) {
			addCriterion("SECOND_WORKON_AUDIT_ID not in", values, "secondWorkonAuditId");
			return (Criteria) this;
		}

		public Criteria andSecondWorkonAuditIdBetween(Integer value1, Integer value2) {
			addCriterion("SECOND_WORKON_AUDIT_ID between", value1, value2, "secondWorkonAuditId");
			return (Criteria) this;
		}

		public Criteria andSecondWorkonAuditIdNotBetween(Integer value1, Integer value2) {
			addCriterion("SECOND_WORKON_AUDIT_ID not between", value1, value2, "secondWorkonAuditId");
			return (Criteria) this;
		}

		public Criteria andThreeWorkonAuditIdIsNull() {
			addCriterion("THREE_WORKON_AUDIT_ID is null");
			return (Criteria) this;
		}

		public Criteria andThreeWorkonAuditIdIsNotNull() {
			addCriterion("THREE_WORKON_AUDIT_ID is not null");
			return (Criteria) this;
		}

		public Criteria andThreeWorkonAuditIdEqualTo(Integer value) {
			addCriterion("THREE_WORKON_AUDIT_ID =", value, "threeWorkonAuditId");
			return (Criteria) this;
		}

		public Criteria andThreeWorkonAuditIdNotEqualTo(Integer value) {
			addCriterion("THREE_WORKON_AUDIT_ID <>", value, "threeWorkonAuditId");
			return (Criteria) this;
		}

		public Criteria andThreeWorkonAuditIdGreaterThan(Integer value) {
			addCriterion("THREE_WORKON_AUDIT_ID >", value, "threeWorkonAuditId");
			return (Criteria) this;
		}

		public Criteria andThreeWorkonAuditIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("THREE_WORKON_AUDIT_ID >=", value, "threeWorkonAuditId");
			return (Criteria) this;
		}

		public Criteria andThreeWorkonAuditIdLessThan(Integer value) {
			addCriterion("THREE_WORKON_AUDIT_ID <", value, "threeWorkonAuditId");
			return (Criteria) this;
		}

		public Criteria andThreeWorkonAuditIdLessThanOrEqualTo(Integer value) {
			addCriterion("THREE_WORKON_AUDIT_ID <=", value, "threeWorkonAuditId");
			return (Criteria) this;
		}

		public Criteria andThreeWorkonAuditIdIn(List<Integer> values) {
			addCriterion("THREE_WORKON_AUDIT_ID in", values, "threeWorkonAuditId");
			return (Criteria) this;
		}

		public Criteria andThreeWorkonAuditIdNotIn(List<Integer> values) {
			addCriterion("THREE_WORKON_AUDIT_ID not in", values, "threeWorkonAuditId");
			return (Criteria) this;
		}

		public Criteria andThreeWorkonAuditIdBetween(Integer value1, Integer value2) {
			addCriterion("THREE_WORKON_AUDIT_ID between", value1, value2, "threeWorkonAuditId");
			return (Criteria) this;
		}

		public Criteria andThreeWorkonAuditIdNotBetween(Integer value1, Integer value2) {
			addCriterion("THREE_WORKON_AUDIT_ID not between", value1, value2, "threeWorkonAuditId");
			return (Criteria) this;
		}

		public Criteria andFirstWorkoffAuditIdIsNull() {
			addCriterion("FIRST_WORKOFF_AUDIT_ID is null");
			return (Criteria) this;
		}

		public Criteria andFirstWorkoffAuditIdIsNotNull() {
			addCriterion("FIRST_WORKOFF_AUDIT_ID is not null");
			return (Criteria) this;
		}

		public Criteria andFirstWorkoffAuditIdEqualTo(Integer value) {
			addCriterion("FIRST_WORKOFF_AUDIT_ID =", value, "firstWorkoffAuditId");
			return (Criteria) this;
		}

		public Criteria andFirstWorkoffAuditIdNotEqualTo(Integer value) {
			addCriterion("FIRST_WORKOFF_AUDIT_ID <>", value, "firstWorkoffAuditId");
			return (Criteria) this;
		}

		public Criteria andFirstWorkoffAuditIdGreaterThan(Integer value) {
			addCriterion("FIRST_WORKOFF_AUDIT_ID >", value, "firstWorkoffAuditId");
			return (Criteria) this;
		}

		public Criteria andFirstWorkoffAuditIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("FIRST_WORKOFF_AUDIT_ID >=", value, "firstWorkoffAuditId");
			return (Criteria) this;
		}

		public Criteria andFirstWorkoffAuditIdLessThan(Integer value) {
			addCriterion("FIRST_WORKOFF_AUDIT_ID <", value, "firstWorkoffAuditId");
			return (Criteria) this;
		}

		public Criteria andFirstWorkoffAuditIdLessThanOrEqualTo(Integer value) {
			addCriterion("FIRST_WORKOFF_AUDIT_ID <=", value, "firstWorkoffAuditId");
			return (Criteria) this;
		}

		public Criteria andFirstWorkoffAuditIdIn(List<Integer> values) {
			addCriterion("FIRST_WORKOFF_AUDIT_ID in", values, "firstWorkoffAuditId");
			return (Criteria) this;
		}

		public Criteria andFirstWorkoffAuditIdNotIn(List<Integer> values) {
			addCriterion("FIRST_WORKOFF_AUDIT_ID not in", values, "firstWorkoffAuditId");
			return (Criteria) this;
		}

		public Criteria andFirstWorkoffAuditIdBetween(Integer value1, Integer value2) {
			addCriterion("FIRST_WORKOFF_AUDIT_ID between", value1, value2, "firstWorkoffAuditId");
			return (Criteria) this;
		}

		public Criteria andFirstWorkoffAuditIdNotBetween(Integer value1, Integer value2) {
			addCriterion("FIRST_WORKOFF_AUDIT_ID not between", value1, value2, "firstWorkoffAuditId");
			return (Criteria) this;
		}

		public Criteria andSecondWorkoffAuditIdIsNull() {
			addCriterion("SECOND_WORKOFF_AUDIT_ID is null");
			return (Criteria) this;
		}

		public Criteria andSecondWorkoffAuditIdIsNotNull() {
			addCriterion("SECOND_WORKOFF_AUDIT_ID is not null");
			return (Criteria) this;
		}

		public Criteria andSecondWorkoffAuditIdEqualTo(Integer value) {
			addCriterion("SECOND_WORKOFF_AUDIT_ID =", value, "secondWorkoffAuditId");
			return (Criteria) this;
		}

		public Criteria andSecondWorkoffAuditIdNotEqualTo(Integer value) {
			addCriterion("SECOND_WORKOFF_AUDIT_ID <>", value, "secondWorkoffAuditId");
			return (Criteria) this;
		}

		public Criteria andSecondWorkoffAuditIdGreaterThan(Integer value) {
			addCriterion("SECOND_WORKOFF_AUDIT_ID >", value, "secondWorkoffAuditId");
			return (Criteria) this;
		}

		public Criteria andSecondWorkoffAuditIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("SECOND_WORKOFF_AUDIT_ID >=", value, "secondWorkoffAuditId");
			return (Criteria) this;
		}

		public Criteria andSecondWorkoffAuditIdLessThan(Integer value) {
			addCriterion("SECOND_WORKOFF_AUDIT_ID <", value, "secondWorkoffAuditId");
			return (Criteria) this;
		}

		public Criteria andSecondWorkoffAuditIdLessThanOrEqualTo(Integer value) {
			addCriterion("SECOND_WORKOFF_AUDIT_ID <=", value, "secondWorkoffAuditId");
			return (Criteria) this;
		}

		public Criteria andSecondWorkoffAuditIdIn(List<Integer> values) {
			addCriterion("SECOND_WORKOFF_AUDIT_ID in", values, "secondWorkoffAuditId");
			return (Criteria) this;
		}

		public Criteria andSecondWorkoffAuditIdNotIn(List<Integer> values) {
			addCriterion("SECOND_WORKOFF_AUDIT_ID not in", values, "secondWorkoffAuditId");
			return (Criteria) this;
		}

		public Criteria andSecondWorkoffAuditIdBetween(Integer value1, Integer value2) {
			addCriterion("SECOND_WORKOFF_AUDIT_ID between", value1, value2, "secondWorkoffAuditId");
			return (Criteria) this;
		}

		public Criteria andSecondWorkoffAuditIdNotBetween(Integer value1, Integer value2) {
			addCriterion("SECOND_WORKOFF_AUDIT_ID not between", value1, value2, "secondWorkoffAuditId");
			return (Criteria) this;
		}

		public Criteria andThreeWorkoffAuditIdIsNull() {
			addCriterion("THREE_WORKOFF_AUDIT_ID is null");
			return (Criteria) this;
		}

		public Criteria andThreeWorkoffAuditIdIsNotNull() {
			addCriterion("THREE_WORKOFF_AUDIT_ID is not null");
			return (Criteria) this;
		}

		public Criteria andThreeWorkoffAuditIdEqualTo(Integer value) {
			addCriterion("THREE_WORKOFF_AUDIT_ID =", value, "threeWorkoffAuditId");
			return (Criteria) this;
		}

		public Criteria andThreeWorkoffAuditIdNotEqualTo(Integer value) {
			addCriterion("THREE_WORKOFF_AUDIT_ID <>", value, "threeWorkoffAuditId");
			return (Criteria) this;
		}

		public Criteria andThreeWorkoffAuditIdGreaterThan(Integer value) {
			addCriterion("THREE_WORKOFF_AUDIT_ID >", value, "threeWorkoffAuditId");
			return (Criteria) this;
		}

		public Criteria andThreeWorkoffAuditIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("THREE_WORKOFF_AUDIT_ID >=", value, "threeWorkoffAuditId");
			return (Criteria) this;
		}

		public Criteria andThreeWorkoffAuditIdLessThan(Integer value) {
			addCriterion("THREE_WORKOFF_AUDIT_ID <", value, "threeWorkoffAuditId");
			return (Criteria) this;
		}

		public Criteria andThreeWorkoffAuditIdLessThanOrEqualTo(Integer value) {
			addCriterion("THREE_WORKOFF_AUDIT_ID <=", value, "threeWorkoffAuditId");
			return (Criteria) this;
		}

		public Criteria andThreeWorkoffAuditIdIn(List<Integer> values) {
			addCriterion("THREE_WORKOFF_AUDIT_ID in", values, "threeWorkoffAuditId");
			return (Criteria) this;
		}

		public Criteria andThreeWorkoffAuditIdNotIn(List<Integer> values) {
			addCriterion("THREE_WORKOFF_AUDIT_ID not in", values, "threeWorkoffAuditId");
			return (Criteria) this;
		}

		public Criteria andThreeWorkoffAuditIdBetween(Integer value1, Integer value2) {
			addCriterion("THREE_WORKOFF_AUDIT_ID between", value1, value2, "threeWorkoffAuditId");
			return (Criteria) this;
		}

		public Criteria andThreeWorkoffAuditIdNotBetween(Integer value1, Integer value2) {
			addCriterion("THREE_WORKOFF_AUDIT_ID not between", value1, value2, "threeWorkoffAuditId");
			return (Criteria) this;
		}

		public Criteria andFirstWorkonLeaveNameIsNull() {
			addCriterion("FIRST_WORKON_LEAVE_NAME is null");
			return (Criteria) this;
		}

		public Criteria andFirstWorkonLeaveNameIsNotNull() {
			addCriterion("FIRST_WORKON_LEAVE_NAME is not null");
			return (Criteria) this;
		}

		public Criteria andFirstWorkonLeaveNameEqualTo(String value) {
			addCriterion("FIRST_WORKON_LEAVE_NAME =", value, "firstWorkonLeaveName");
			return (Criteria) this;
		}

		public Criteria andFirstWorkonLeaveNameNotEqualTo(String value) {
			addCriterion("FIRST_WORKON_LEAVE_NAME <>", value, "firstWorkonLeaveName");
			return (Criteria) this;
		}

		public Criteria andFirstWorkonLeaveNameGreaterThan(String value) {
			addCriterion("FIRST_WORKON_LEAVE_NAME >", value, "firstWorkonLeaveName");
			return (Criteria) this;
		}

		public Criteria andFirstWorkonLeaveNameGreaterThanOrEqualTo(String value) {
			addCriterion("FIRST_WORKON_LEAVE_NAME >=", value, "firstWorkonLeaveName");
			return (Criteria) this;
		}

		public Criteria andFirstWorkonLeaveNameLessThan(String value) {
			addCriterion("FIRST_WORKON_LEAVE_NAME <", value, "firstWorkonLeaveName");
			return (Criteria) this;
		}

		public Criteria andFirstWorkonLeaveNameLessThanOrEqualTo(String value) {
			addCriterion("FIRST_WORKON_LEAVE_NAME <=", value, "firstWorkonLeaveName");
			return (Criteria) this;
		}

		public Criteria andFirstWorkonLeaveNameLike(String value) {
			addCriterion("FIRST_WORKON_LEAVE_NAME like", value, "firstWorkonLeaveName");
			return (Criteria) this;
		}

		public Criteria andFirstWorkonLeaveNameNotLike(String value) {
			addCriterion("FIRST_WORKON_LEAVE_NAME not like", value, "firstWorkonLeaveName");
			return (Criteria) this;
		}

		public Criteria andFirstWorkonLeaveNameIn(List<String> values) {
			addCriterion("FIRST_WORKON_LEAVE_NAME in", values, "firstWorkonLeaveName");
			return (Criteria) this;
		}

		public Criteria andFirstWorkonLeaveNameNotIn(List<String> values) {
			addCriterion("FIRST_WORKON_LEAVE_NAME not in", values, "firstWorkonLeaveName");
			return (Criteria) this;
		}

		public Criteria andFirstWorkonLeaveNameBetween(String value1, String value2) {
			addCriterion("FIRST_WORKON_LEAVE_NAME between", value1, value2, "firstWorkonLeaveName");
			return (Criteria) this;
		}

		public Criteria andFirstWorkonLeaveNameNotBetween(String value1, String value2) {
			addCriterion("FIRST_WORKON_LEAVE_NAME not between", value1, value2, "firstWorkonLeaveName");
			return (Criteria) this;
		}

		public Criteria andSecondWorkonLeaveNameIsNull() {
			addCriterion("SECOND_WORKON_LEAVE_NAME is null");
			return (Criteria) this;
		}

		public Criteria andSecondWorkonLeaveNameIsNotNull() {
			addCriterion("SECOND_WORKON_LEAVE_NAME is not null");
			return (Criteria) this;
		}

		public Criteria andSecondWorkonLeaveNameEqualTo(String value) {
			addCriterion("SECOND_WORKON_LEAVE_NAME =", value, "secondWorkonLeaveName");
			return (Criteria) this;
		}

		public Criteria andSecondWorkonLeaveNameNotEqualTo(String value) {
			addCriterion("SECOND_WORKON_LEAVE_NAME <>", value, "secondWorkonLeaveName");
			return (Criteria) this;
		}

		public Criteria andSecondWorkonLeaveNameGreaterThan(String value) {
			addCriterion("SECOND_WORKON_LEAVE_NAME >", value, "secondWorkonLeaveName");
			return (Criteria) this;
		}

		public Criteria andSecondWorkonLeaveNameGreaterThanOrEqualTo(String value) {
			addCriterion("SECOND_WORKON_LEAVE_NAME >=", value, "secondWorkonLeaveName");
			return (Criteria) this;
		}

		public Criteria andSecondWorkonLeaveNameLessThan(String value) {
			addCriterion("SECOND_WORKON_LEAVE_NAME <", value, "secondWorkonLeaveName");
			return (Criteria) this;
		}

		public Criteria andSecondWorkonLeaveNameLessThanOrEqualTo(String value) {
			addCriterion("SECOND_WORKON_LEAVE_NAME <=", value, "secondWorkonLeaveName");
			return (Criteria) this;
		}

		public Criteria andSecondWorkonLeaveNameLike(String value) {
			addCriterion("SECOND_WORKON_LEAVE_NAME like", value, "secondWorkonLeaveName");
			return (Criteria) this;
		}

		public Criteria andSecondWorkonLeaveNameNotLike(String value) {
			addCriterion("SECOND_WORKON_LEAVE_NAME not like", value, "secondWorkonLeaveName");
			return (Criteria) this;
		}

		public Criteria andSecondWorkonLeaveNameIn(List<String> values) {
			addCriterion("SECOND_WORKON_LEAVE_NAME in", values, "secondWorkonLeaveName");
			return (Criteria) this;
		}

		public Criteria andSecondWorkonLeaveNameNotIn(List<String> values) {
			addCriterion("SECOND_WORKON_LEAVE_NAME not in", values, "secondWorkonLeaveName");
			return (Criteria) this;
		}

		public Criteria andSecondWorkonLeaveNameBetween(String value1, String value2) {
			addCriterion("SECOND_WORKON_LEAVE_NAME between", value1, value2, "secondWorkonLeaveName");
			return (Criteria) this;
		}

		public Criteria andSecondWorkonLeaveNameNotBetween(String value1, String value2) {
			addCriterion("SECOND_WORKON_LEAVE_NAME not between", value1, value2, "secondWorkonLeaveName");
			return (Criteria) this;
		}

		public Criteria andThreeWorkonLeaveNameIsNull() {
			addCriterion("THREE_WORKON_LEAVE_NAME is null");
			return (Criteria) this;
		}

		public Criteria andThreeWorkonLeaveNameIsNotNull() {
			addCriterion("THREE_WORKON_LEAVE_NAME is not null");
			return (Criteria) this;
		}

		public Criteria andThreeWorkonLeaveNameEqualTo(String value) {
			addCriterion("THREE_WORKON_LEAVE_NAME =", value, "threeWorkonLeaveName");
			return (Criteria) this;
		}

		public Criteria andThreeWorkonLeaveNameNotEqualTo(String value) {
			addCriterion("THREE_WORKON_LEAVE_NAME <>", value, "threeWorkonLeaveName");
			return (Criteria) this;
		}

		public Criteria andThreeWorkonLeaveNameGreaterThan(String value) {
			addCriterion("THREE_WORKON_LEAVE_NAME >", value, "threeWorkonLeaveName");
			return (Criteria) this;
		}

		public Criteria andThreeWorkonLeaveNameGreaterThanOrEqualTo(String value) {
			addCriterion("THREE_WORKON_LEAVE_NAME >=", value, "threeWorkonLeaveName");
			return (Criteria) this;
		}

		public Criteria andThreeWorkonLeaveNameLessThan(String value) {
			addCriterion("THREE_WORKON_LEAVE_NAME <", value, "threeWorkonLeaveName");
			return (Criteria) this;
		}

		public Criteria andThreeWorkonLeaveNameLessThanOrEqualTo(String value) {
			addCriterion("THREE_WORKON_LEAVE_NAME <=", value, "threeWorkonLeaveName");
			return (Criteria) this;
		}

		public Criteria andThreeWorkonLeaveNameLike(String value) {
			addCriterion("THREE_WORKON_LEAVE_NAME like", value, "threeWorkonLeaveName");
			return (Criteria) this;
		}

		public Criteria andThreeWorkonLeaveNameNotLike(String value) {
			addCriterion("THREE_WORKON_LEAVE_NAME not like", value, "threeWorkonLeaveName");
			return (Criteria) this;
		}

		public Criteria andThreeWorkonLeaveNameIn(List<String> values) {
			addCriterion("THREE_WORKON_LEAVE_NAME in", values, "threeWorkonLeaveName");
			return (Criteria) this;
		}

		public Criteria andThreeWorkonLeaveNameNotIn(List<String> values) {
			addCriterion("THREE_WORKON_LEAVE_NAME not in", values, "threeWorkonLeaveName");
			return (Criteria) this;
		}

		public Criteria andThreeWorkonLeaveNameBetween(String value1, String value2) {
			addCriterion("THREE_WORKON_LEAVE_NAME between", value1, value2, "threeWorkonLeaveName");
			return (Criteria) this;
		}

		public Criteria andThreeWorkonLeaveNameNotBetween(String value1, String value2) {
			addCriterion("THREE_WORKON_LEAVE_NAME not between", value1, value2, "threeWorkonLeaveName");
			return (Criteria) this;
		}

		public Criteria andFirstWorkoffLeaveNameIsNull() {
			addCriterion("FIRST_WORKOFF_LEAVE_NAME is null");
			return (Criteria) this;
		}

		public Criteria andFirstWorkoffLeaveNameIsNotNull() {
			addCriterion("FIRST_WORKOFF_LEAVE_NAME is not null");
			return (Criteria) this;
		}

		public Criteria andFirstWorkoffLeaveNameEqualTo(String value) {
			addCriterion("FIRST_WORKOFF_LEAVE_NAME =", value, "firstWorkoffLeaveName");
			return (Criteria) this;
		}

		public Criteria andFirstWorkoffLeaveNameNotEqualTo(String value) {
			addCriterion("FIRST_WORKOFF_LEAVE_NAME <>", value, "firstWorkoffLeaveName");
			return (Criteria) this;
		}

		public Criteria andFirstWorkoffLeaveNameGreaterThan(String value) {
			addCriterion("FIRST_WORKOFF_LEAVE_NAME >", value, "firstWorkoffLeaveName");
			return (Criteria) this;
		}

		public Criteria andFirstWorkoffLeaveNameGreaterThanOrEqualTo(String value) {
			addCriterion("FIRST_WORKOFF_LEAVE_NAME >=", value, "firstWorkoffLeaveName");
			return (Criteria) this;
		}

		public Criteria andFirstWorkoffLeaveNameLessThan(String value) {
			addCriterion("FIRST_WORKOFF_LEAVE_NAME <", value, "firstWorkoffLeaveName");
			return (Criteria) this;
		}

		public Criteria andFirstWorkoffLeaveNameLessThanOrEqualTo(String value) {
			addCriterion("FIRST_WORKOFF_LEAVE_NAME <=", value, "firstWorkoffLeaveName");
			return (Criteria) this;
		}

		public Criteria andFirstWorkoffLeaveNameLike(String value) {
			addCriterion("FIRST_WORKOFF_LEAVE_NAME like", value, "firstWorkoffLeaveName");
			return (Criteria) this;
		}

		public Criteria andFirstWorkoffLeaveNameNotLike(String value) {
			addCriterion("FIRST_WORKOFF_LEAVE_NAME not like", value, "firstWorkoffLeaveName");
			return (Criteria) this;
		}

		public Criteria andFirstWorkoffLeaveNameIn(List<String> values) {
			addCriterion("FIRST_WORKOFF_LEAVE_NAME in", values, "firstWorkoffLeaveName");
			return (Criteria) this;
		}

		public Criteria andFirstWorkoffLeaveNameNotIn(List<String> values) {
			addCriterion("FIRST_WORKOFF_LEAVE_NAME not in", values, "firstWorkoffLeaveName");
			return (Criteria) this;
		}

		public Criteria andFirstWorkoffLeaveNameBetween(String value1, String value2) {
			addCriterion("FIRST_WORKOFF_LEAVE_NAME between", value1, value2, "firstWorkoffLeaveName");
			return (Criteria) this;
		}

		public Criteria andFirstWorkoffLeaveNameNotBetween(String value1, String value2) {
			addCriterion("FIRST_WORKOFF_LEAVE_NAME not between", value1, value2, "firstWorkoffLeaveName");
			return (Criteria) this;
		}

		public Criteria andSecondWorkoffLeaveNameIsNull() {
			addCriterion("SECOND_WORKOFF_LEAVE_NAME is null");
			return (Criteria) this;
		}

		public Criteria andSecondWorkoffLeaveNameIsNotNull() {
			addCriterion("SECOND_WORKOFF_LEAVE_NAME is not null");
			return (Criteria) this;
		}

		public Criteria andSecondWorkoffLeaveNameEqualTo(String value) {
			addCriterion("SECOND_WORKOFF_LEAVE_NAME =", value, "secondWorkoffLeaveName");
			return (Criteria) this;
		}

		public Criteria andSecondWorkoffLeaveNameNotEqualTo(String value) {
			addCriterion("SECOND_WORKOFF_LEAVE_NAME <>", value, "secondWorkoffLeaveName");
			return (Criteria) this;
		}

		public Criteria andSecondWorkoffLeaveNameGreaterThan(String value) {
			addCriterion("SECOND_WORKOFF_LEAVE_NAME >", value, "secondWorkoffLeaveName");
			return (Criteria) this;
		}

		public Criteria andSecondWorkoffLeaveNameGreaterThanOrEqualTo(String value) {
			addCriterion("SECOND_WORKOFF_LEAVE_NAME >=", value, "secondWorkoffLeaveName");
			return (Criteria) this;
		}

		public Criteria andSecondWorkoffLeaveNameLessThan(String value) {
			addCriterion("SECOND_WORKOFF_LEAVE_NAME <", value, "secondWorkoffLeaveName");
			return (Criteria) this;
		}

		public Criteria andSecondWorkoffLeaveNameLessThanOrEqualTo(String value) {
			addCriterion("SECOND_WORKOFF_LEAVE_NAME <=", value, "secondWorkoffLeaveName");
			return (Criteria) this;
		}

		public Criteria andSecondWorkoffLeaveNameLike(String value) {
			addCriterion("SECOND_WORKOFF_LEAVE_NAME like", value, "secondWorkoffLeaveName");
			return (Criteria) this;
		}

		public Criteria andSecondWorkoffLeaveNameNotLike(String value) {
			addCriterion("SECOND_WORKOFF_LEAVE_NAME not like", value, "secondWorkoffLeaveName");
			return (Criteria) this;
		}

		public Criteria andSecondWorkoffLeaveNameIn(List<String> values) {
			addCriterion("SECOND_WORKOFF_LEAVE_NAME in", values, "secondWorkoffLeaveName");
			return (Criteria) this;
		}

		public Criteria andSecondWorkoffLeaveNameNotIn(List<String> values) {
			addCriterion("SECOND_WORKOFF_LEAVE_NAME not in", values, "secondWorkoffLeaveName");
			return (Criteria) this;
		}

		public Criteria andSecondWorkoffLeaveNameBetween(String value1, String value2) {
			addCriterion("SECOND_WORKOFF_LEAVE_NAME between", value1, value2, "secondWorkoffLeaveName");
			return (Criteria) this;
		}

		public Criteria andSecondWorkoffLeaveNameNotBetween(String value1, String value2) {
			addCriterion("SECOND_WORKOFF_LEAVE_NAME not between", value1, value2, "secondWorkoffLeaveName");
			return (Criteria) this;
		}

		public Criteria andThreeWorkoffLeaveNameIsNull() {
			addCriterion("THREE_WORKOFF_LEAVE_NAME is null");
			return (Criteria) this;
		}

		public Criteria andThreeWorkoffLeaveNameIsNotNull() {
			addCriterion("THREE_WORKOFF_LEAVE_NAME is not null");
			return (Criteria) this;
		}

		public Criteria andThreeWorkoffLeaveNameEqualTo(String value) {
			addCriterion("THREE_WORKOFF_LEAVE_NAME =", value, "threeWorkoffLeaveName");
			return (Criteria) this;
		}

		public Criteria andThreeWorkoffLeaveNameNotEqualTo(String value) {
			addCriterion("THREE_WORKOFF_LEAVE_NAME <>", value, "threeWorkoffLeaveName");
			return (Criteria) this;
		}

		public Criteria andThreeWorkoffLeaveNameGreaterThan(String value) {
			addCriterion("THREE_WORKOFF_LEAVE_NAME >", value, "threeWorkoffLeaveName");
			return (Criteria) this;
		}

		public Criteria andThreeWorkoffLeaveNameGreaterThanOrEqualTo(String value) {
			addCriterion("THREE_WORKOFF_LEAVE_NAME >=", value, "threeWorkoffLeaveName");
			return (Criteria) this;
		}

		public Criteria andThreeWorkoffLeaveNameLessThan(String value) {
			addCriterion("THREE_WORKOFF_LEAVE_NAME <", value, "threeWorkoffLeaveName");
			return (Criteria) this;
		}

		public Criteria andThreeWorkoffLeaveNameLessThanOrEqualTo(String value) {
			addCriterion("THREE_WORKOFF_LEAVE_NAME <=", value, "threeWorkoffLeaveName");
			return (Criteria) this;
		}

		public Criteria andThreeWorkoffLeaveNameLike(String value) {
			addCriterion("THREE_WORKOFF_LEAVE_NAME like", value, "threeWorkoffLeaveName");
			return (Criteria) this;
		}

		public Criteria andThreeWorkoffLeaveNameNotLike(String value) {
			addCriterion("THREE_WORKOFF_LEAVE_NAME not like", value, "threeWorkoffLeaveName");
			return (Criteria) this;
		}

		public Criteria andThreeWorkoffLeaveNameIn(List<String> values) {
			addCriterion("THREE_WORKOFF_LEAVE_NAME in", values, "threeWorkoffLeaveName");
			return (Criteria) this;
		}

		public Criteria andThreeWorkoffLeaveNameNotIn(List<String> values) {
			addCriterion("THREE_WORKOFF_LEAVE_NAME not in", values, "threeWorkoffLeaveName");
			return (Criteria) this;
		}

		public Criteria andThreeWorkoffLeaveNameBetween(String value1, String value2) {
			addCriterion("THREE_WORKOFF_LEAVE_NAME between", value1, value2, "threeWorkoffLeaveName");
			return (Criteria) this;
		}

		public Criteria andThreeWorkoffLeaveNameNotBetween(String value1, String value2) {
			addCriterion("THREE_WORKOFF_LEAVE_NAME not between", value1, value2, "threeWorkoffLeaveName");
			return (Criteria) this;
		}

		public Criteria andFirstWorkonClassIdIsNull() {
			addCriterion("FIRST_WORKON_CLASS_ID is null");
			return (Criteria) this;
		}

		public Criteria andFirstWorkonClassIdIsNotNull() {
			addCriterion("FIRST_WORKON_CLASS_ID is not null");
			return (Criteria) this;
		}

		public Criteria andFirstWorkonClassIdEqualTo(Integer value) {
			addCriterion("FIRST_WORKON_CLASS_ID =", value, "firstWorkonClassId");
			return (Criteria) this;
		}

		public Criteria andFirstWorkonClassIdNotEqualTo(Integer value) {
			addCriterion("FIRST_WORKON_CLASS_ID <>", value, "firstWorkonClassId");
			return (Criteria) this;
		}

		public Criteria andFirstWorkonClassIdGreaterThan(Integer value) {
			addCriterion("FIRST_WORKON_CLASS_ID >", value, "firstWorkonClassId");
			return (Criteria) this;
		}

		public Criteria andFirstWorkonClassIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("FIRST_WORKON_CLASS_ID >=", value, "firstWorkonClassId");
			return (Criteria) this;
		}

		public Criteria andFirstWorkonClassIdLessThan(Integer value) {
			addCriterion("FIRST_WORKON_CLASS_ID <", value, "firstWorkonClassId");
			return (Criteria) this;
		}

		public Criteria andFirstWorkonClassIdLessThanOrEqualTo(Integer value) {
			addCriterion("FIRST_WORKON_CLASS_ID <=", value, "firstWorkonClassId");
			return (Criteria) this;
		}

		public Criteria andFirstWorkonClassIdIn(List<Integer> values) {
			addCriterion("FIRST_WORKON_CLASS_ID in", values, "firstWorkonClassId");
			return (Criteria) this;
		}

		public Criteria andFirstWorkonClassIdNotIn(List<Integer> values) {
			addCriterion("FIRST_WORKON_CLASS_ID not in", values, "firstWorkonClassId");
			return (Criteria) this;
		}

		public Criteria andFirstWorkonClassIdBetween(Integer value1, Integer value2) {
			addCriterion("FIRST_WORKON_CLASS_ID between", value1, value2, "firstWorkonClassId");
			return (Criteria) this;
		}

		public Criteria andFirstWorkonClassIdNotBetween(Integer value1, Integer value2) {
			addCriterion("FIRST_WORKON_CLASS_ID not between", value1, value2, "firstWorkonClassId");
			return (Criteria) this;
		}

		public Criteria andSecondWorkonClassIdIsNull() {
			addCriterion("SECOND_WORKON_CLASS_ID is null");
			return (Criteria) this;
		}

		public Criteria andSecondWorkonClassIdIsNotNull() {
			addCriterion("SECOND_WORKON_CLASS_ID is not null");
			return (Criteria) this;
		}

		public Criteria andSecondWorkonClassIdEqualTo(Integer value) {
			addCriterion("SECOND_WORKON_CLASS_ID =", value, "secondWorkonClassId");
			return (Criteria) this;
		}

		public Criteria andSecondWorkonClassIdNotEqualTo(Integer value) {
			addCriterion("SECOND_WORKON_CLASS_ID <>", value, "secondWorkonClassId");
			return (Criteria) this;
		}

		public Criteria andSecondWorkonClassIdGreaterThan(Integer value) {
			addCriterion("SECOND_WORKON_CLASS_ID >", value, "secondWorkonClassId");
			return (Criteria) this;
		}

		public Criteria andSecondWorkonClassIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("SECOND_WORKON_CLASS_ID >=", value, "secondWorkonClassId");
			return (Criteria) this;
		}

		public Criteria andSecondWorkonClassIdLessThan(Integer value) {
			addCriterion("SECOND_WORKON_CLASS_ID <", value, "secondWorkonClassId");
			return (Criteria) this;
		}

		public Criteria andSecondWorkonClassIdLessThanOrEqualTo(Integer value) {
			addCriterion("SECOND_WORKON_CLASS_ID <=", value, "secondWorkonClassId");
			return (Criteria) this;
		}

		public Criteria andSecondWorkonClassIdIn(List<Integer> values) {
			addCriterion("SECOND_WORKON_CLASS_ID in", values, "secondWorkonClassId");
			return (Criteria) this;
		}

		public Criteria andSecondWorkonClassIdNotIn(List<Integer> values) {
			addCriterion("SECOND_WORKON_CLASS_ID not in", values, "secondWorkonClassId");
			return (Criteria) this;
		}

		public Criteria andSecondWorkonClassIdBetween(Integer value1, Integer value2) {
			addCriterion("SECOND_WORKON_CLASS_ID between", value1, value2, "secondWorkonClassId");
			return (Criteria) this;
		}

		public Criteria andSecondWorkonClassIdNotBetween(Integer value1, Integer value2) {
			addCriterion("SECOND_WORKON_CLASS_ID not between", value1, value2, "secondWorkonClassId");
			return (Criteria) this;
		}

		public Criteria andThreeWorkonClassIdIsNull() {
			addCriterion("THREE_WORKON_CLASS_ID is null");
			return (Criteria) this;
		}

		public Criteria andThreeWorkonClassIdIsNotNull() {
			addCriterion("THREE_WORKON_CLASS_ID is not null");
			return (Criteria) this;
		}

		public Criteria andThreeWorkonClassIdEqualTo(Integer value) {
			addCriterion("THREE_WORKON_CLASS_ID =", value, "threeWorkonClassId");
			return (Criteria) this;
		}

		public Criteria andThreeWorkonClassIdNotEqualTo(Integer value) {
			addCriterion("THREE_WORKON_CLASS_ID <>", value, "threeWorkonClassId");
			return (Criteria) this;
		}

		public Criteria andThreeWorkonClassIdGreaterThan(Integer value) {
			addCriterion("THREE_WORKON_CLASS_ID >", value, "threeWorkonClassId");
			return (Criteria) this;
		}

		public Criteria andThreeWorkonClassIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("THREE_WORKON_CLASS_ID >=", value, "threeWorkonClassId");
			return (Criteria) this;
		}

		public Criteria andThreeWorkonClassIdLessThan(Integer value) {
			addCriterion("THREE_WORKON_CLASS_ID <", value, "threeWorkonClassId");
			return (Criteria) this;
		}

		public Criteria andThreeWorkonClassIdLessThanOrEqualTo(Integer value) {
			addCriterion("THREE_WORKON_CLASS_ID <=", value, "threeWorkonClassId");
			return (Criteria) this;
		}

		public Criteria andThreeWorkonClassIdIn(List<Integer> values) {
			addCriterion("THREE_WORKON_CLASS_ID in", values, "threeWorkonClassId");
			return (Criteria) this;
		}

		public Criteria andThreeWorkonClassIdNotIn(List<Integer> values) {
			addCriterion("THREE_WORKON_CLASS_ID not in", values, "threeWorkonClassId");
			return (Criteria) this;
		}

		public Criteria andThreeWorkonClassIdBetween(Integer value1, Integer value2) {
			addCriterion("THREE_WORKON_CLASS_ID between", value1, value2, "threeWorkonClassId");
			return (Criteria) this;
		}

		public Criteria andThreeWorkonClassIdNotBetween(Integer value1, Integer value2) {
			addCriterion("THREE_WORKON_CLASS_ID not between", value1, value2, "threeWorkonClassId");
			return (Criteria) this;
		}

		public Criteria andFirstWorkoffClassIdIsNull() {
			addCriterion("FIRST_WORKOFF_CLASS_ID is null");
			return (Criteria) this;
		}

		public Criteria andFirstWorkoffClassIdIsNotNull() {
			addCriterion("FIRST_WORKOFF_CLASS_ID is not null");
			return (Criteria) this;
		}

		public Criteria andFirstWorkoffClassIdEqualTo(Integer value) {
			addCriterion("FIRST_WORKOFF_CLASS_ID =", value, "firstWorkoffClassId");
			return (Criteria) this;
		}

		public Criteria andFirstWorkoffClassIdNotEqualTo(Integer value) {
			addCriterion("FIRST_WORKOFF_CLASS_ID <>", value, "firstWorkoffClassId");
			return (Criteria) this;
		}

		public Criteria andFirstWorkoffClassIdGreaterThan(Integer value) {
			addCriterion("FIRST_WORKOFF_CLASS_ID >", value, "firstWorkoffClassId");
			return (Criteria) this;
		}

		public Criteria andFirstWorkoffClassIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("FIRST_WORKOFF_CLASS_ID >=", value, "firstWorkoffClassId");
			return (Criteria) this;
		}

		public Criteria andFirstWorkoffClassIdLessThan(Integer value) {
			addCriterion("FIRST_WORKOFF_CLASS_ID <", value, "firstWorkoffClassId");
			return (Criteria) this;
		}

		public Criteria andFirstWorkoffClassIdLessThanOrEqualTo(Integer value) {
			addCriterion("FIRST_WORKOFF_CLASS_ID <=", value, "firstWorkoffClassId");
			return (Criteria) this;
		}

		public Criteria andFirstWorkoffClassIdIn(List<Integer> values) {
			addCriterion("FIRST_WORKOFF_CLASS_ID in", values, "firstWorkoffClassId");
			return (Criteria) this;
		}

		public Criteria andFirstWorkoffClassIdNotIn(List<Integer> values) {
			addCriterion("FIRST_WORKOFF_CLASS_ID not in", values, "firstWorkoffClassId");
			return (Criteria) this;
		}

		public Criteria andFirstWorkoffClassIdBetween(Integer value1, Integer value2) {
			addCriterion("FIRST_WORKOFF_CLASS_ID between", value1, value2, "firstWorkoffClassId");
			return (Criteria) this;
		}

		public Criteria andFirstWorkoffClassIdNotBetween(Integer value1, Integer value2) {
			addCriterion("FIRST_WORKOFF_CLASS_ID not between", value1, value2, "firstWorkoffClassId");
			return (Criteria) this;
		}

		public Criteria andSecondWorkoffClassIdIsNull() {
			addCriterion("SECOND_WORKOFF_CLASS_ID is null");
			return (Criteria) this;
		}

		public Criteria andSecondWorkoffClassIdIsNotNull() {
			addCriterion("SECOND_WORKOFF_CLASS_ID is not null");
			return (Criteria) this;
		}

		public Criteria andSecondWorkoffClassIdEqualTo(Integer value) {
			addCriterion("SECOND_WORKOFF_CLASS_ID =", value, "secondWorkoffClassId");
			return (Criteria) this;
		}

		public Criteria andSecondWorkoffClassIdNotEqualTo(Integer value) {
			addCriterion("SECOND_WORKOFF_CLASS_ID <>", value, "secondWorkoffClassId");
			return (Criteria) this;
		}

		public Criteria andSecondWorkoffClassIdGreaterThan(Integer value) {
			addCriterion("SECOND_WORKOFF_CLASS_ID >", value, "secondWorkoffClassId");
			return (Criteria) this;
		}

		public Criteria andSecondWorkoffClassIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("SECOND_WORKOFF_CLASS_ID >=", value, "secondWorkoffClassId");
			return (Criteria) this;
		}

		public Criteria andSecondWorkoffClassIdLessThan(Integer value) {
			addCriterion("SECOND_WORKOFF_CLASS_ID <", value, "secondWorkoffClassId");
			return (Criteria) this;
		}

		public Criteria andSecondWorkoffClassIdLessThanOrEqualTo(Integer value) {
			addCriterion("SECOND_WORKOFF_CLASS_ID <=", value, "secondWorkoffClassId");
			return (Criteria) this;
		}

		public Criteria andSecondWorkoffClassIdIn(List<Integer> values) {
			addCriterion("SECOND_WORKOFF_CLASS_ID in", values, "secondWorkoffClassId");
			return (Criteria) this;
		}

		public Criteria andSecondWorkoffClassIdNotIn(List<Integer> values) {
			addCriterion("SECOND_WORKOFF_CLASS_ID not in", values, "secondWorkoffClassId");
			return (Criteria) this;
		}

		public Criteria andSecondWorkoffClassIdBetween(Integer value1, Integer value2) {
			addCriterion("SECOND_WORKOFF_CLASS_ID between", value1, value2, "secondWorkoffClassId");
			return (Criteria) this;
		}

		public Criteria andSecondWorkoffClassIdNotBetween(Integer value1, Integer value2) {
			addCriterion("SECOND_WORKOFF_CLASS_ID not between", value1, value2, "secondWorkoffClassId");
			return (Criteria) this;
		}

		public Criteria andThreeWorkoffClassIdIsNull() {
			addCriterion("THREE_WORKOFF_CLASS_ID is null");
			return (Criteria) this;
		}

		public Criteria andThreeWorkoffClassIdIsNotNull() {
			addCriterion("THREE_WORKOFF_CLASS_ID is not null");
			return (Criteria) this;
		}

		public Criteria andThreeWorkoffClassIdEqualTo(Integer value) {
			addCriterion("THREE_WORKOFF_CLASS_ID =", value, "threeWorkoffClassId");
			return (Criteria) this;
		}

		public Criteria andThreeWorkoffClassIdNotEqualTo(Integer value) {
			addCriterion("THREE_WORKOFF_CLASS_ID <>", value, "threeWorkoffClassId");
			return (Criteria) this;
		}

		public Criteria andThreeWorkoffClassIdGreaterThan(Integer value) {
			addCriterion("THREE_WORKOFF_CLASS_ID >", value, "threeWorkoffClassId");
			return (Criteria) this;
		}

		public Criteria andThreeWorkoffClassIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("THREE_WORKOFF_CLASS_ID >=", value, "threeWorkoffClassId");
			return (Criteria) this;
		}

		public Criteria andThreeWorkoffClassIdLessThan(Integer value) {
			addCriterion("THREE_WORKOFF_CLASS_ID <", value, "threeWorkoffClassId");
			return (Criteria) this;
		}

		public Criteria andThreeWorkoffClassIdLessThanOrEqualTo(Integer value) {
			addCriterion("THREE_WORKOFF_CLASS_ID <=", value, "threeWorkoffClassId");
			return (Criteria) this;
		}

		public Criteria andThreeWorkoffClassIdIn(List<Integer> values) {
			addCriterion("THREE_WORKOFF_CLASS_ID in", values, "threeWorkoffClassId");
			return (Criteria) this;
		}

		public Criteria andThreeWorkoffClassIdNotIn(List<Integer> values) {
			addCriterion("THREE_WORKOFF_CLASS_ID not in", values, "threeWorkoffClassId");
			return (Criteria) this;
		}

		public Criteria andThreeWorkoffClassIdBetween(Integer value1, Integer value2) {
			addCriterion("THREE_WORKOFF_CLASS_ID between", value1, value2, "threeWorkoffClassId");
			return (Criteria) this;
		}

		public Criteria andThreeWorkoffClassIdNotBetween(Integer value1, Integer value2) {
			addCriterion("THREE_WORKOFF_CLASS_ID not between", value1, value2, "threeWorkoffClassId");
			return (Criteria) this;
		}

		public Criteria andAttendanceClassTimeSegmentIsNull() {
			addCriterion("ATTENDANCE_CLASS_TIME_SEGMENT is null");
			return (Criteria) this;
		}

		public Criteria andAttendanceClassTimeSegmentIsNotNull() {
			addCriterion("ATTENDANCE_CLASS_TIME_SEGMENT is not null");
			return (Criteria) this;
		}

		public Criteria andAttendanceClassTimeSegmentEqualTo(String value) {
			addCriterion("ATTENDANCE_CLASS_TIME_SEGMENT =", value, "attendanceClassTimeSegment");
			return (Criteria) this;
		}

		public Criteria andAttendanceClassTimeSegmentNotEqualTo(String value) {
			addCriterion("ATTENDANCE_CLASS_TIME_SEGMENT <>", value, "attendanceClassTimeSegment");
			return (Criteria) this;
		}

		public Criteria andAttendanceClassTimeSegmentGreaterThan(String value) {
			addCriterion("ATTENDANCE_CLASS_TIME_SEGMENT >", value, "attendanceClassTimeSegment");
			return (Criteria) this;
		}

		public Criteria andAttendanceClassTimeSegmentGreaterThanOrEqualTo(String value) {
			addCriterion("ATTENDANCE_CLASS_TIME_SEGMENT >=", value, "attendanceClassTimeSegment");
			return (Criteria) this;
		}

		public Criteria andAttendanceClassTimeSegmentLessThan(String value) {
			addCriterion("ATTENDANCE_CLASS_TIME_SEGMENT <", value, "attendanceClassTimeSegment");
			return (Criteria) this;
		}

		public Criteria andAttendanceClassTimeSegmentLessThanOrEqualTo(String value) {
			addCriterion("ATTENDANCE_CLASS_TIME_SEGMENT <=", value, "attendanceClassTimeSegment");
			return (Criteria) this;
		}

		public Criteria andAttendanceClassTimeSegmentLike(String value) {
			addCriterion("ATTENDANCE_CLASS_TIME_SEGMENT like", value, "attendanceClassTimeSegment");
			return (Criteria) this;
		}

		public Criteria andAttendanceClassTimeSegmentNotLike(String value) {
			addCriterion("ATTENDANCE_CLASS_TIME_SEGMENT not like", value, "attendanceClassTimeSegment");
			return (Criteria) this;
		}

		public Criteria andAttendanceClassTimeSegmentIn(List<String> values) {
			addCriterion("ATTENDANCE_CLASS_TIME_SEGMENT in", values, "attendanceClassTimeSegment");
			return (Criteria) this;
		}

		public Criteria andAttendanceClassTimeSegmentNotIn(List<String> values) {
			addCriterion("ATTENDANCE_CLASS_TIME_SEGMENT not in", values, "attendanceClassTimeSegment");
			return (Criteria) this;
		}

		public Criteria andAttendanceClassTimeSegmentBetween(String value1, String value2) {
			addCriterion("ATTENDANCE_CLASS_TIME_SEGMENT between", value1, value2, "attendanceClassTimeSegment");
			return (Criteria) this;
		}

		public Criteria andAttendanceClassTimeSegmentNotBetween(String value1, String value2) {
			addCriterion("ATTENDANCE_CLASS_TIME_SEGMENT not between", value1, value2, "attendanceClassTimeSegment");
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