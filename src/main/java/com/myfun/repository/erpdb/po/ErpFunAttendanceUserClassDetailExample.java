package com.myfun.repository.erpdb.po;

import com.myfun.repository.support.generator.shard.ShardDb;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ErpFunAttendanceUserClassDetailExample extends ShardDb {
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
	public ErpFunAttendanceUserClassDetailExample() {
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

		public Criteria andClassDetailIdIsNull() {
			addCriterion("CLASS_DETAIL_ID is null");
			return (Criteria) this;
		}

		public Criteria andClassDetailIdIsNotNull() {
			addCriterion("CLASS_DETAIL_ID is not null");
			return (Criteria) this;
		}

		public Criteria andClassDetailIdEqualTo(Integer value) {
			addCriterion("CLASS_DETAIL_ID =", value, "classDetailId");
			return (Criteria) this;
		}

		public Criteria andClassDetailIdNotEqualTo(Integer value) {
			addCriterion("CLASS_DETAIL_ID <>", value, "classDetailId");
			return (Criteria) this;
		}

		public Criteria andClassDetailIdGreaterThan(Integer value) {
			addCriterion("CLASS_DETAIL_ID >", value, "classDetailId");
			return (Criteria) this;
		}

		public Criteria andClassDetailIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("CLASS_DETAIL_ID >=", value, "classDetailId");
			return (Criteria) this;
		}

		public Criteria andClassDetailIdLessThan(Integer value) {
			addCriterion("CLASS_DETAIL_ID <", value, "classDetailId");
			return (Criteria) this;
		}

		public Criteria andClassDetailIdLessThanOrEqualTo(Integer value) {
			addCriterion("CLASS_DETAIL_ID <=", value, "classDetailId");
			return (Criteria) this;
		}

		public Criteria andClassDetailIdIn(List<Integer> values) {
			addCriterion("CLASS_DETAIL_ID in", values, "classDetailId");
			return (Criteria) this;
		}

		public Criteria andClassDetailIdNotIn(List<Integer> values) {
			addCriterion("CLASS_DETAIL_ID not in", values, "classDetailId");
			return (Criteria) this;
		}

		public Criteria andClassDetailIdBetween(Integer value1, Integer value2) {
			addCriterion("CLASS_DETAIL_ID between", value1, value2, "classDetailId");
			return (Criteria) this;
		}

		public Criteria andClassDetailIdNotBetween(Integer value1, Integer value2) {
			addCriterion("CLASS_DETAIL_ID not between", value1, value2, "classDetailId");
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

		public Criteria andAttTimeIsNull() {
			addCriterion("ATT_TIME is null");
			return (Criteria) this;
		}

		public Criteria andAttTimeIsNotNull() {
			addCriterion("ATT_TIME is not null");
			return (Criteria) this;
		}

		public Criteria andAttTimeEqualTo(Date value) {
			addCriterion("ATT_TIME =", value, "attTime");
			return (Criteria) this;
		}

		public Criteria andAttTimeNotEqualTo(Date value) {
			addCriterion("ATT_TIME <>", value, "attTime");
			return (Criteria) this;
		}

		public Criteria andAttTimeGreaterThan(Date value) {
			addCriterion("ATT_TIME >", value, "attTime");
			return (Criteria) this;
		}

		public Criteria andAttTimeGreaterThanOrEqualTo(Date value) {
			addCriterion("ATT_TIME >=", value, "attTime");
			return (Criteria) this;
		}

		public Criteria andAttTimeLessThan(Date value) {
			addCriterion("ATT_TIME <", value, "attTime");
			return (Criteria) this;
		}

		public Criteria andAttTimeLessThanOrEqualTo(Date value) {
			addCriterion("ATT_TIME <=", value, "attTime");
			return (Criteria) this;
		}

		public Criteria andAttTimeIn(List<Date> values) {
			addCriterion("ATT_TIME in", values, "attTime");
			return (Criteria) this;
		}

		public Criteria andAttTimeNotIn(List<Date> values) {
			addCriterion("ATT_TIME not in", values, "attTime");
			return (Criteria) this;
		}

		public Criteria andAttTimeBetween(Date value1, Date value2) {
			addCriterion("ATT_TIME between", value1, value2, "attTime");
			return (Criteria) this;
		}

		public Criteria andAttTimeNotBetween(Date value1, Date value2) {
			addCriterion("ATT_TIME not between", value1, value2, "attTime");
			return (Criteria) this;
		}

		public Criteria andCreateTimeIsNull() {
			addCriterion("CREATE_TIME is null");
			return (Criteria) this;
		}

		public Criteria andCreateTimeIsNotNull() {
			addCriterion("CREATE_TIME is not null");
			return (Criteria) this;
		}

		public Criteria andCreateTimeEqualTo(Date value) {
			addCriterion("CREATE_TIME =", value, "createTime");
			return (Criteria) this;
		}

		public Criteria andCreateTimeNotEqualTo(Date value) {
			addCriterion("CREATE_TIME <>", value, "createTime");
			return (Criteria) this;
		}

		public Criteria andCreateTimeGreaterThan(Date value) {
			addCriterion("CREATE_TIME >", value, "createTime");
			return (Criteria) this;
		}

		public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
			addCriterion("CREATE_TIME >=", value, "createTime");
			return (Criteria) this;
		}

		public Criteria andCreateTimeLessThan(Date value) {
			addCriterion("CREATE_TIME <", value, "createTime");
			return (Criteria) this;
		}

		public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
			addCriterion("CREATE_TIME <=", value, "createTime");
			return (Criteria) this;
		}

		public Criteria andCreateTimeIn(List<Date> values) {
			addCriterion("CREATE_TIME in", values, "createTime");
			return (Criteria) this;
		}

		public Criteria andCreateTimeNotIn(List<Date> values) {
			addCriterion("CREATE_TIME not in", values, "createTime");
			return (Criteria) this;
		}

		public Criteria andCreateTimeBetween(Date value1, Date value2) {
			addCriterion("CREATE_TIME between", value1, value2, "createTime");
			return (Criteria) this;
		}

		public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
			addCriterion("CREATE_TIME not between", value1, value2, "createTime");
			return (Criteria) this;
		}

		public Criteria andIsDelIsNull() {
			addCriterion("IS_DEL is null");
			return (Criteria) this;
		}

		public Criteria andIsDelIsNotNull() {
			addCriterion("IS_DEL is not null");
			return (Criteria) this;
		}

		public Criteria andIsDelEqualTo(Byte value) {
			addCriterion("IS_DEL =", value, "isDel");
			return (Criteria) this;
		}

		public Criteria andIsDelNotEqualTo(Byte value) {
			addCriterion("IS_DEL <>", value, "isDel");
			return (Criteria) this;
		}

		public Criteria andIsDelGreaterThan(Byte value) {
			addCriterion("IS_DEL >", value, "isDel");
			return (Criteria) this;
		}

		public Criteria andIsDelGreaterThanOrEqualTo(Byte value) {
			addCriterion("IS_DEL >=", value, "isDel");
			return (Criteria) this;
		}

		public Criteria andIsDelLessThan(Byte value) {
			addCriterion("IS_DEL <", value, "isDel");
			return (Criteria) this;
		}

		public Criteria andIsDelLessThanOrEqualTo(Byte value) {
			addCriterion("IS_DEL <=", value, "isDel");
			return (Criteria) this;
		}

		public Criteria andIsDelIn(List<Byte> values) {
			addCriterion("IS_DEL in", values, "isDel");
			return (Criteria) this;
		}

		public Criteria andIsDelNotIn(List<Byte> values) {
			addCriterion("IS_DEL not in", values, "isDel");
			return (Criteria) this;
		}

		public Criteria andIsDelBetween(Byte value1, Byte value2) {
			addCriterion("IS_DEL between", value1, value2, "isDel");
			return (Criteria) this;
		}

		public Criteria andIsDelNotBetween(Byte value1, Byte value2) {
			addCriterion("IS_DEL not between", value1, value2, "isDel");
			return (Criteria) this;
		}

		public Criteria andDelTimeIsNull() {
			addCriterion("DEL_TIME is null");
			return (Criteria) this;
		}

		public Criteria andDelTimeIsNotNull() {
			addCriterion("DEL_TIME is not null");
			return (Criteria) this;
		}

		public Criteria andDelTimeEqualTo(Date value) {
			addCriterion("DEL_TIME =", value, "delTime");
			return (Criteria) this;
		}

		public Criteria andDelTimeNotEqualTo(Date value) {
			addCriterion("DEL_TIME <>", value, "delTime");
			return (Criteria) this;
		}

		public Criteria andDelTimeGreaterThan(Date value) {
			addCriterion("DEL_TIME >", value, "delTime");
			return (Criteria) this;
		}

		public Criteria andDelTimeGreaterThanOrEqualTo(Date value) {
			addCriterion("DEL_TIME >=", value, "delTime");
			return (Criteria) this;
		}

		public Criteria andDelTimeLessThan(Date value) {
			addCriterion("DEL_TIME <", value, "delTime");
			return (Criteria) this;
		}

		public Criteria andDelTimeLessThanOrEqualTo(Date value) {
			addCriterion("DEL_TIME <=", value, "delTime");
			return (Criteria) this;
		}

		public Criteria andDelTimeIn(List<Date> values) {
			addCriterion("DEL_TIME in", values, "delTime");
			return (Criteria) this;
		}

		public Criteria andDelTimeNotIn(List<Date> values) {
			addCriterion("DEL_TIME not in", values, "delTime");
			return (Criteria) this;
		}

		public Criteria andDelTimeBetween(Date value1, Date value2) {
			addCriterion("DEL_TIME between", value1, value2, "delTime");
			return (Criteria) this;
		}

		public Criteria andDelTimeNotBetween(Date value1, Date value2) {
			addCriterion("DEL_TIME not between", value1, value2, "delTime");
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