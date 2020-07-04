package com.myfun.repository.erpdb.po;

import com.myfun.repository.support.generator.shard.ShardDb;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ErpFunAttendanceRecordDetailExample extends ShardDb {
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
	public ErpFunAttendanceRecordDetailExample() {
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

		public Criteria andAttIdIsNull() {
			addCriterion("ATT_ID is null");
			return (Criteria) this;
		}

		public Criteria andAttIdIsNotNull() {
			addCriterion("ATT_ID is not null");
			return (Criteria) this;
		}

		public Criteria andAttIdEqualTo(Integer value) {
			addCriterion("ATT_ID =", value, "attId");
			return (Criteria) this;
		}

		public Criteria andAttIdNotEqualTo(Integer value) {
			addCriterion("ATT_ID <>", value, "attId");
			return (Criteria) this;
		}

		public Criteria andAttIdGreaterThan(Integer value) {
			addCriterion("ATT_ID >", value, "attId");
			return (Criteria) this;
		}

		public Criteria andAttIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("ATT_ID >=", value, "attId");
			return (Criteria) this;
		}

		public Criteria andAttIdLessThan(Integer value) {
			addCriterion("ATT_ID <", value, "attId");
			return (Criteria) this;
		}

		public Criteria andAttIdLessThanOrEqualTo(Integer value) {
			addCriterion("ATT_ID <=", value, "attId");
			return (Criteria) this;
		}

		public Criteria andAttIdIn(List<Integer> values) {
			addCriterion("ATT_ID in", values, "attId");
			return (Criteria) this;
		}

		public Criteria andAttIdNotIn(List<Integer> values) {
			addCriterion("ATT_ID not in", values, "attId");
			return (Criteria) this;
		}

		public Criteria andAttIdBetween(Integer value1, Integer value2) {
			addCriterion("ATT_ID between", value1, value2, "attId");
			return (Criteria) this;
		}

		public Criteria andAttIdNotBetween(Integer value1, Integer value2) {
			addCriterion("ATT_ID not between", value1, value2, "attId");
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

		public Criteria andAttXIsNull() {
			addCriterion("ATT_X is null");
			return (Criteria) this;
		}

		public Criteria andAttXIsNotNull() {
			addCriterion("ATT_X is not null");
			return (Criteria) this;
		}

		public Criteria andAttXEqualTo(String value) {
			addCriterion("ATT_X =", value, "attX");
			return (Criteria) this;
		}

		public Criteria andAttXNotEqualTo(String value) {
			addCriterion("ATT_X <>", value, "attX");
			return (Criteria) this;
		}

		public Criteria andAttXGreaterThan(String value) {
			addCriterion("ATT_X >", value, "attX");
			return (Criteria) this;
		}

		public Criteria andAttXGreaterThanOrEqualTo(String value) {
			addCriterion("ATT_X >=", value, "attX");
			return (Criteria) this;
		}

		public Criteria andAttXLessThan(String value) {
			addCriterion("ATT_X <", value, "attX");
			return (Criteria) this;
		}

		public Criteria andAttXLessThanOrEqualTo(String value) {
			addCriterion("ATT_X <=", value, "attX");
			return (Criteria) this;
		}

		public Criteria andAttXLike(String value) {
			addCriterion("ATT_X like", value, "attX");
			return (Criteria) this;
		}

		public Criteria andAttXNotLike(String value) {
			addCriterion("ATT_X not like", value, "attX");
			return (Criteria) this;
		}

		public Criteria andAttXIn(List<String> values) {
			addCriterion("ATT_X in", values, "attX");
			return (Criteria) this;
		}

		public Criteria andAttXNotIn(List<String> values) {
			addCriterion("ATT_X not in", values, "attX");
			return (Criteria) this;
		}

		public Criteria andAttXBetween(String value1, String value2) {
			addCriterion("ATT_X between", value1, value2, "attX");
			return (Criteria) this;
		}

		public Criteria andAttXNotBetween(String value1, String value2) {
			addCriterion("ATT_X not between", value1, value2, "attX");
			return (Criteria) this;
		}

		public Criteria andAttYIsNull() {
			addCriterion("ATT_Y is null");
			return (Criteria) this;
		}

		public Criteria andAttYIsNotNull() {
			addCriterion("ATT_Y is not null");
			return (Criteria) this;
		}

		public Criteria andAttYEqualTo(String value) {
			addCriterion("ATT_Y =", value, "attY");
			return (Criteria) this;
		}

		public Criteria andAttYNotEqualTo(String value) {
			addCriterion("ATT_Y <>", value, "attY");
			return (Criteria) this;
		}

		public Criteria andAttYGreaterThan(String value) {
			addCriterion("ATT_Y >", value, "attY");
			return (Criteria) this;
		}

		public Criteria andAttYGreaterThanOrEqualTo(String value) {
			addCriterion("ATT_Y >=", value, "attY");
			return (Criteria) this;
		}

		public Criteria andAttYLessThan(String value) {
			addCriterion("ATT_Y <", value, "attY");
			return (Criteria) this;
		}

		public Criteria andAttYLessThanOrEqualTo(String value) {
			addCriterion("ATT_Y <=", value, "attY");
			return (Criteria) this;
		}

		public Criteria andAttYLike(String value) {
			addCriterion("ATT_Y like", value, "attY");
			return (Criteria) this;
		}

		public Criteria andAttYNotLike(String value) {
			addCriterion("ATT_Y not like", value, "attY");
			return (Criteria) this;
		}

		public Criteria andAttYIn(List<String> values) {
			addCriterion("ATT_Y in", values, "attY");
			return (Criteria) this;
		}

		public Criteria andAttYNotIn(List<String> values) {
			addCriterion("ATT_Y not in", values, "attY");
			return (Criteria) this;
		}

		public Criteria andAttYBetween(String value1, String value2) {
			addCriterion("ATT_Y between", value1, value2, "attY");
			return (Criteria) this;
		}

		public Criteria andAttYNotBetween(String value1, String value2) {
			addCriterion("ATT_Y not between", value1, value2, "attY");
			return (Criteria) this;
		}

		public Criteria andLocationDescIsNull() {
			addCriterion("LOCATION_DESC is null");
			return (Criteria) this;
		}

		public Criteria andLocationDescIsNotNull() {
			addCriterion("LOCATION_DESC is not null");
			return (Criteria) this;
		}

		public Criteria andLocationDescEqualTo(String value) {
			addCriterion("LOCATION_DESC =", value, "locationDesc");
			return (Criteria) this;
		}

		public Criteria andLocationDescNotEqualTo(String value) {
			addCriterion("LOCATION_DESC <>", value, "locationDesc");
			return (Criteria) this;
		}

		public Criteria andLocationDescGreaterThan(String value) {
			addCriterion("LOCATION_DESC >", value, "locationDesc");
			return (Criteria) this;
		}

		public Criteria andLocationDescGreaterThanOrEqualTo(String value) {
			addCriterion("LOCATION_DESC >=", value, "locationDesc");
			return (Criteria) this;
		}

		public Criteria andLocationDescLessThan(String value) {
			addCriterion("LOCATION_DESC <", value, "locationDesc");
			return (Criteria) this;
		}

		public Criteria andLocationDescLessThanOrEqualTo(String value) {
			addCriterion("LOCATION_DESC <=", value, "locationDesc");
			return (Criteria) this;
		}

		public Criteria andLocationDescLike(String value) {
			addCriterion("LOCATION_DESC like", value, "locationDesc");
			return (Criteria) this;
		}

		public Criteria andLocationDescNotLike(String value) {
			addCriterion("LOCATION_DESC not like", value, "locationDesc");
			return (Criteria) this;
		}

		public Criteria andLocationDescIn(List<String> values) {
			addCriterion("LOCATION_DESC in", values, "locationDesc");
			return (Criteria) this;
		}

		public Criteria andLocationDescNotIn(List<String> values) {
			addCriterion("LOCATION_DESC not in", values, "locationDesc");
			return (Criteria) this;
		}

		public Criteria andLocationDescBetween(String value1, String value2) {
			addCriterion("LOCATION_DESC between", value1, value2, "locationDesc");
			return (Criteria) this;
		}

		public Criteria andLocationDescNotBetween(String value1, String value2) {
			addCriterion("LOCATION_DESC not between", value1, value2, "locationDesc");
			return (Criteria) this;
		}

		public Criteria andConfigAttTimeIsNull() {
			addCriterion("CONFIG_ATT_TIME is null");
			return (Criteria) this;
		}

		public Criteria andConfigAttTimeIsNotNull() {
			addCriterion("CONFIG_ATT_TIME is not null");
			return (Criteria) this;
		}

		public Criteria andConfigAttTimeEqualTo(Date value) {
			addCriterion("CONFIG_ATT_TIME =", value, "configAttTime");
			return (Criteria) this;
		}

		public Criteria andConfigAttTimeNotEqualTo(Date value) {
			addCriterion("CONFIG_ATT_TIME <>", value, "configAttTime");
			return (Criteria) this;
		}

		public Criteria andConfigAttTimeGreaterThan(Date value) {
			addCriterion("CONFIG_ATT_TIME >", value, "configAttTime");
			return (Criteria) this;
		}

		public Criteria andConfigAttTimeGreaterThanOrEqualTo(Date value) {
			addCriterion("CONFIG_ATT_TIME >=", value, "configAttTime");
			return (Criteria) this;
		}

		public Criteria andConfigAttTimeLessThan(Date value) {
			addCriterion("CONFIG_ATT_TIME <", value, "configAttTime");
			return (Criteria) this;
		}

		public Criteria andConfigAttTimeLessThanOrEqualTo(Date value) {
			addCriterion("CONFIG_ATT_TIME <=", value, "configAttTime");
			return (Criteria) this;
		}

		public Criteria andConfigAttTimeIn(List<Date> values) {
			addCriterion("CONFIG_ATT_TIME in", values, "configAttTime");
			return (Criteria) this;
		}

		public Criteria andConfigAttTimeNotIn(List<Date> values) {
			addCriterion("CONFIG_ATT_TIME not in", values, "configAttTime");
			return (Criteria) this;
		}

		public Criteria andConfigAttTimeBetween(Date value1, Date value2) {
			addCriterion("CONFIG_ATT_TIME between", value1, value2, "configAttTime");
			return (Criteria) this;
		}

		public Criteria andConfigAttTimeNotBetween(Date value1, Date value2) {
			addCriterion("CONFIG_ATT_TIME not between", value1, value2, "configAttTime");
			return (Criteria) this;
		}

		public Criteria andLocalAttTimeIsNull() {
			addCriterion("LOCAL_ATT_TIME is null");
			return (Criteria) this;
		}

		public Criteria andLocalAttTimeIsNotNull() {
			addCriterion("LOCAL_ATT_TIME is not null");
			return (Criteria) this;
		}

		public Criteria andLocalAttTimeEqualTo(Date value) {
			addCriterion("LOCAL_ATT_TIME =", value, "localAttTime");
			return (Criteria) this;
		}

		public Criteria andLocalAttTimeNotEqualTo(Date value) {
			addCriterion("LOCAL_ATT_TIME <>", value, "localAttTime");
			return (Criteria) this;
		}

		public Criteria andLocalAttTimeGreaterThan(Date value) {
			addCriterion("LOCAL_ATT_TIME >", value, "localAttTime");
			return (Criteria) this;
		}

		public Criteria andLocalAttTimeGreaterThanOrEqualTo(Date value) {
			addCriterion("LOCAL_ATT_TIME >=", value, "localAttTime");
			return (Criteria) this;
		}

		public Criteria andLocalAttTimeLessThan(Date value) {
			addCriterion("LOCAL_ATT_TIME <", value, "localAttTime");
			return (Criteria) this;
		}

		public Criteria andLocalAttTimeLessThanOrEqualTo(Date value) {
			addCriterion("LOCAL_ATT_TIME <=", value, "localAttTime");
			return (Criteria) this;
		}

		public Criteria andLocalAttTimeIn(List<Date> values) {
			addCriterion("LOCAL_ATT_TIME in", values, "localAttTime");
			return (Criteria) this;
		}

		public Criteria andLocalAttTimeNotIn(List<Date> values) {
			addCriterion("LOCAL_ATT_TIME not in", values, "localAttTime");
			return (Criteria) this;
		}

		public Criteria andLocalAttTimeBetween(Date value1, Date value2) {
			addCriterion("LOCAL_ATT_TIME between", value1, value2, "localAttTime");
			return (Criteria) this;
		}

		public Criteria andLocalAttTimeNotBetween(Date value1, Date value2) {
			addCriterion("LOCAL_ATT_TIME not between", value1, value2, "localAttTime");
			return (Criteria) this;
		}

		public Criteria andServerAttTimeIsNull() {
			addCriterion("SERVER_ATT_TIME is null");
			return (Criteria) this;
		}

		public Criteria andServerAttTimeIsNotNull() {
			addCriterion("SERVER_ATT_TIME is not null");
			return (Criteria) this;
		}

		public Criteria andServerAttTimeEqualTo(Date value) {
			addCriterion("SERVER_ATT_TIME =", value, "serverAttTime");
			return (Criteria) this;
		}

		public Criteria andServerAttTimeNotEqualTo(Date value) {
			addCriterion("SERVER_ATT_TIME <>", value, "serverAttTime");
			return (Criteria) this;
		}

		public Criteria andServerAttTimeGreaterThan(Date value) {
			addCriterion("SERVER_ATT_TIME >", value, "serverAttTime");
			return (Criteria) this;
		}

		public Criteria andServerAttTimeGreaterThanOrEqualTo(Date value) {
			addCriterion("SERVER_ATT_TIME >=", value, "serverAttTime");
			return (Criteria) this;
		}

		public Criteria andServerAttTimeLessThan(Date value) {
			addCriterion("SERVER_ATT_TIME <", value, "serverAttTime");
			return (Criteria) this;
		}

		public Criteria andServerAttTimeLessThanOrEqualTo(Date value) {
			addCriterion("SERVER_ATT_TIME <=", value, "serverAttTime");
			return (Criteria) this;
		}

		public Criteria andServerAttTimeIn(List<Date> values) {
			addCriterion("SERVER_ATT_TIME in", values, "serverAttTime");
			return (Criteria) this;
		}

		public Criteria andServerAttTimeNotIn(List<Date> values) {
			addCriterion("SERVER_ATT_TIME not in", values, "serverAttTime");
			return (Criteria) this;
		}

		public Criteria andServerAttTimeBetween(Date value1, Date value2) {
			addCriterion("SERVER_ATT_TIME between", value1, value2, "serverAttTime");
			return (Criteria) this;
		}

		public Criteria andServerAttTimeNotBetween(Date value1, Date value2) {
			addCriterion("SERVER_ATT_TIME not between", value1, value2, "serverAttTime");
			return (Criteria) this;
		}

		public Criteria andAttAttributeIsNull() {
			addCriterion("ATT_ATTRIBUTE is null");
			return (Criteria) this;
		}

		public Criteria andAttAttributeIsNotNull() {
			addCriterion("ATT_ATTRIBUTE is not null");
			return (Criteria) this;
		}

		public Criteria andAttAttributeEqualTo(Byte value) {
			addCriterion("ATT_ATTRIBUTE =", value, "attAttribute");
			return (Criteria) this;
		}

		public Criteria andAttAttributeNotEqualTo(Byte value) {
			addCriterion("ATT_ATTRIBUTE <>", value, "attAttribute");
			return (Criteria) this;
		}

		public Criteria andAttAttributeGreaterThan(Byte value) {
			addCriterion("ATT_ATTRIBUTE >", value, "attAttribute");
			return (Criteria) this;
		}

		public Criteria andAttAttributeGreaterThanOrEqualTo(Byte value) {
			addCriterion("ATT_ATTRIBUTE >=", value, "attAttribute");
			return (Criteria) this;
		}

		public Criteria andAttAttributeLessThan(Byte value) {
			addCriterion("ATT_ATTRIBUTE <", value, "attAttribute");
			return (Criteria) this;
		}

		public Criteria andAttAttributeLessThanOrEqualTo(Byte value) {
			addCriterion("ATT_ATTRIBUTE <=", value, "attAttribute");
			return (Criteria) this;
		}

		public Criteria andAttAttributeIn(List<Byte> values) {
			addCriterion("ATT_ATTRIBUTE in", values, "attAttribute");
			return (Criteria) this;
		}

		public Criteria andAttAttributeNotIn(List<Byte> values) {
			addCriterion("ATT_ATTRIBUTE not in", values, "attAttribute");
			return (Criteria) this;
		}

		public Criteria andAttAttributeBetween(Byte value1, Byte value2) {
			addCriterion("ATT_ATTRIBUTE between", value1, value2, "attAttribute");
			return (Criteria) this;
		}

		public Criteria andAttAttributeNotBetween(Byte value1, Byte value2) {
			addCriterion("ATT_ATTRIBUTE not between", value1, value2, "attAttribute");
			return (Criteria) this;
		}

		public Criteria andAttRestIsNull() {
			addCriterion("ATT_REST is null");
			return (Criteria) this;
		}

		public Criteria andAttRestIsNotNull() {
			addCriterion("ATT_REST is not null");
			return (Criteria) this;
		}

		public Criteria andAttRestEqualTo(Byte value) {
			addCriterion("ATT_REST =", value, "attRest");
			return (Criteria) this;
		}

		public Criteria andAttRestNotEqualTo(Byte value) {
			addCriterion("ATT_REST <>", value, "attRest");
			return (Criteria) this;
		}

		public Criteria andAttRestGreaterThan(Byte value) {
			addCriterion("ATT_REST >", value, "attRest");
			return (Criteria) this;
		}

		public Criteria andAttRestGreaterThanOrEqualTo(Byte value) {
			addCriterion("ATT_REST >=", value, "attRest");
			return (Criteria) this;
		}

		public Criteria andAttRestLessThan(Byte value) {
			addCriterion("ATT_REST <", value, "attRest");
			return (Criteria) this;
		}

		public Criteria andAttRestLessThanOrEqualTo(Byte value) {
			addCriterion("ATT_REST <=", value, "attRest");
			return (Criteria) this;
		}

		public Criteria andAttRestIn(List<Byte> values) {
			addCriterion("ATT_REST in", values, "attRest");
			return (Criteria) this;
		}

		public Criteria andAttRestNotIn(List<Byte> values) {
			addCriterion("ATT_REST not in", values, "attRest");
			return (Criteria) this;
		}

		public Criteria andAttRestBetween(Byte value1, Byte value2) {
			addCriterion("ATT_REST between", value1, value2, "attRest");
			return (Criteria) this;
		}

		public Criteria andAttRestNotBetween(Byte value1, Byte value2) {
			addCriterion("ATT_REST not between", value1, value2, "attRest");
			return (Criteria) this;
		}

		public Criteria andAttTypeIsNull() {
			addCriterion("ATT_TYPE is null");
			return (Criteria) this;
		}

		public Criteria andAttTypeIsNotNull() {
			addCriterion("ATT_TYPE is not null");
			return (Criteria) this;
		}

		public Criteria andAttTypeEqualTo(Byte value) {
			addCriterion("ATT_TYPE =", value, "attType");
			return (Criteria) this;
		}

		public Criteria andAttTypeNotEqualTo(Byte value) {
			addCriterion("ATT_TYPE <>", value, "attType");
			return (Criteria) this;
		}

		public Criteria andAttTypeGreaterThan(Byte value) {
			addCriterion("ATT_TYPE >", value, "attType");
			return (Criteria) this;
		}

		public Criteria andAttTypeGreaterThanOrEqualTo(Byte value) {
			addCriterion("ATT_TYPE >=", value, "attType");
			return (Criteria) this;
		}

		public Criteria andAttTypeLessThan(Byte value) {
			addCriterion("ATT_TYPE <", value, "attType");
			return (Criteria) this;
		}

		public Criteria andAttTypeLessThanOrEqualTo(Byte value) {
			addCriterion("ATT_TYPE <=", value, "attType");
			return (Criteria) this;
		}

		public Criteria andAttTypeIn(List<Byte> values) {
			addCriterion("ATT_TYPE in", values, "attType");
			return (Criteria) this;
		}

		public Criteria andAttTypeNotIn(List<Byte> values) {
			addCriterion("ATT_TYPE not in", values, "attType");
			return (Criteria) this;
		}

		public Criteria andAttTypeBetween(Byte value1, Byte value2) {
			addCriterion("ATT_TYPE between", value1, value2, "attType");
			return (Criteria) this;
		}

		public Criteria andAttTypeNotBetween(Byte value1, Byte value2) {
			addCriterion("ATT_TYPE not between", value1, value2, "attType");
			return (Criteria) this;
		}

		public Criteria andOffLineUploadIsNull() {
			addCriterion("OFF_LINE_UPLOAD is null");
			return (Criteria) this;
		}

		public Criteria andOffLineUploadIsNotNull() {
			addCriterion("OFF_LINE_UPLOAD is not null");
			return (Criteria) this;
		}

		public Criteria andOffLineUploadEqualTo(Byte value) {
			addCriterion("OFF_LINE_UPLOAD =", value, "offLineUpload");
			return (Criteria) this;
		}

		public Criteria andOffLineUploadNotEqualTo(Byte value) {
			addCriterion("OFF_LINE_UPLOAD <>", value, "offLineUpload");
			return (Criteria) this;
		}

		public Criteria andOffLineUploadGreaterThan(Byte value) {
			addCriterion("OFF_LINE_UPLOAD >", value, "offLineUpload");
			return (Criteria) this;
		}

		public Criteria andOffLineUploadGreaterThanOrEqualTo(Byte value) {
			addCriterion("OFF_LINE_UPLOAD >=", value, "offLineUpload");
			return (Criteria) this;
		}

		public Criteria andOffLineUploadLessThan(Byte value) {
			addCriterion("OFF_LINE_UPLOAD <", value, "offLineUpload");
			return (Criteria) this;
		}

		public Criteria andOffLineUploadLessThanOrEqualTo(Byte value) {
			addCriterion("OFF_LINE_UPLOAD <=", value, "offLineUpload");
			return (Criteria) this;
		}

		public Criteria andOffLineUploadIn(List<Byte> values) {
			addCriterion("OFF_LINE_UPLOAD in", values, "offLineUpload");
			return (Criteria) this;
		}

		public Criteria andOffLineUploadNotIn(List<Byte> values) {
			addCriterion("OFF_LINE_UPLOAD not in", values, "offLineUpload");
			return (Criteria) this;
		}

		public Criteria andOffLineUploadBetween(Byte value1, Byte value2) {
			addCriterion("OFF_LINE_UPLOAD between", value1, value2, "offLineUpload");
			return (Criteria) this;
		}

		public Criteria andOffLineUploadNotBetween(Byte value1, Byte value2) {
			addCriterion("OFF_LINE_UPLOAD not between", value1, value2, "offLineUpload");
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

		public Criteria andAttNumIsNull() {
			addCriterion("ATT_NUM is null");
			return (Criteria) this;
		}

		public Criteria andAttNumIsNotNull() {
			addCriterion("ATT_NUM is not null");
			return (Criteria) this;
		}

		public Criteria andAttNumEqualTo(Byte value) {
			addCriterion("ATT_NUM =", value, "attNum");
			return (Criteria) this;
		}

		public Criteria andAttNumNotEqualTo(Byte value) {
			addCriterion("ATT_NUM <>", value, "attNum");
			return (Criteria) this;
		}

		public Criteria andAttNumGreaterThan(Byte value) {
			addCriterion("ATT_NUM >", value, "attNum");
			return (Criteria) this;
		}

		public Criteria andAttNumGreaterThanOrEqualTo(Byte value) {
			addCriterion("ATT_NUM >=", value, "attNum");
			return (Criteria) this;
		}

		public Criteria andAttNumLessThan(Byte value) {
			addCriterion("ATT_NUM <", value, "attNum");
			return (Criteria) this;
		}

		public Criteria andAttNumLessThanOrEqualTo(Byte value) {
			addCriterion("ATT_NUM <=", value, "attNum");
			return (Criteria) this;
		}

		public Criteria andAttNumIn(List<Byte> values) {
			addCriterion("ATT_NUM in", values, "attNum");
			return (Criteria) this;
		}

		public Criteria andAttNumNotIn(List<Byte> values) {
			addCriterion("ATT_NUM not in", values, "attNum");
			return (Criteria) this;
		}

		public Criteria andAttNumBetween(Byte value1, Byte value2) {
			addCriterion("ATT_NUM between", value1, value2, "attNum");
			return (Criteria) this;
		}

		public Criteria andAttNumNotBetween(Byte value1, Byte value2) {
			addCriterion("ATT_NUM not between", value1, value2, "attNum");
			return (Criteria) this;
		}

		public Criteria andExtraPathIsNull() {
			addCriterion("EXTRA_PATH is null");
			return (Criteria) this;
		}

		public Criteria andExtraPathIsNotNull() {
			addCriterion("EXTRA_PATH is not null");
			return (Criteria) this;
		}

		public Criteria andExtraPathEqualTo(String value) {
			addCriterion("EXTRA_PATH =", value, "extraPath");
			return (Criteria) this;
		}

		public Criteria andExtraPathNotEqualTo(String value) {
			addCriterion("EXTRA_PATH <>", value, "extraPath");
			return (Criteria) this;
		}

		public Criteria andExtraPathGreaterThan(String value) {
			addCriterion("EXTRA_PATH >", value, "extraPath");
			return (Criteria) this;
		}

		public Criteria andExtraPathGreaterThanOrEqualTo(String value) {
			addCriterion("EXTRA_PATH >=", value, "extraPath");
			return (Criteria) this;
		}

		public Criteria andExtraPathLessThan(String value) {
			addCriterion("EXTRA_PATH <", value, "extraPath");
			return (Criteria) this;
		}

		public Criteria andExtraPathLessThanOrEqualTo(String value) {
			addCriterion("EXTRA_PATH <=", value, "extraPath");
			return (Criteria) this;
		}

		public Criteria andExtraPathLike(String value) {
			addCriterion("EXTRA_PATH like", value, "extraPath");
			return (Criteria) this;
		}

		public Criteria andExtraPathNotLike(String value) {
			addCriterion("EXTRA_PATH not like", value, "extraPath");
			return (Criteria) this;
		}

		public Criteria andExtraPathIn(List<String> values) {
			addCriterion("EXTRA_PATH in", values, "extraPath");
			return (Criteria) this;
		}

		public Criteria andExtraPathNotIn(List<String> values) {
			addCriterion("EXTRA_PATH not in", values, "extraPath");
			return (Criteria) this;
		}

		public Criteria andExtraPathBetween(String value1, String value2) {
			addCriterion("EXTRA_PATH between", value1, value2, "extraPath");
			return (Criteria) this;
		}

		public Criteria andExtraPathNotBetween(String value1, String value2) {
			addCriterion("EXTRA_PATH not between", value1, value2, "extraPath");
			return (Criteria) this;
		}

		public Criteria andExtraTypeIsNull() {
			addCriterion("EXTRA_TYPE is null");
			return (Criteria) this;
		}

		public Criteria andExtraTypeIsNotNull() {
			addCriterion("EXTRA_TYPE is not null");
			return (Criteria) this;
		}

		public Criteria andExtraTypeEqualTo(Byte value) {
			addCriterion("EXTRA_TYPE =", value, "extraType");
			return (Criteria) this;
		}

		public Criteria andExtraTypeNotEqualTo(Byte value) {
			addCriterion("EXTRA_TYPE <>", value, "extraType");
			return (Criteria) this;
		}

		public Criteria andExtraTypeGreaterThan(Byte value) {
			addCriterion("EXTRA_TYPE >", value, "extraType");
			return (Criteria) this;
		}

		public Criteria andExtraTypeGreaterThanOrEqualTo(Byte value) {
			addCriterion("EXTRA_TYPE >=", value, "extraType");
			return (Criteria) this;
		}

		public Criteria andExtraTypeLessThan(Byte value) {
			addCriterion("EXTRA_TYPE <", value, "extraType");
			return (Criteria) this;
		}

		public Criteria andExtraTypeLessThanOrEqualTo(Byte value) {
			addCriterion("EXTRA_TYPE <=", value, "extraType");
			return (Criteria) this;
		}

		public Criteria andExtraTypeIn(List<Byte> values) {
			addCriterion("EXTRA_TYPE in", values, "extraType");
			return (Criteria) this;
		}

		public Criteria andExtraTypeNotIn(List<Byte> values) {
			addCriterion("EXTRA_TYPE not in", values, "extraType");
			return (Criteria) this;
		}

		public Criteria andExtraTypeBetween(Byte value1, Byte value2) {
			addCriterion("EXTRA_TYPE between", value1, value2, "extraType");
			return (Criteria) this;
		}

		public Criteria andExtraTypeNotBetween(Byte value1, Byte value2) {
			addCriterion("EXTRA_TYPE not between", value1, value2, "extraType");
			return (Criteria) this;
		}

		public Criteria andExtraExistIsNull() {
			addCriterion("EXTRA_EXIST is null");
			return (Criteria) this;
		}

		public Criteria andExtraExistIsNotNull() {
			addCriterion("EXTRA_EXIST is not null");
			return (Criteria) this;
		}

		public Criteria andExtraExistEqualTo(Byte value) {
			addCriterion("EXTRA_EXIST =", value, "extraExist");
			return (Criteria) this;
		}

		public Criteria andExtraExistNotEqualTo(Byte value) {
			addCriterion("EXTRA_EXIST <>", value, "extraExist");
			return (Criteria) this;
		}

		public Criteria andExtraExistGreaterThan(Byte value) {
			addCriterion("EXTRA_EXIST >", value, "extraExist");
			return (Criteria) this;
		}

		public Criteria andExtraExistGreaterThanOrEqualTo(Byte value) {
			addCriterion("EXTRA_EXIST >=", value, "extraExist");
			return (Criteria) this;
		}

		public Criteria andExtraExistLessThan(Byte value) {
			addCriterion("EXTRA_EXIST <", value, "extraExist");
			return (Criteria) this;
		}

		public Criteria andExtraExistLessThanOrEqualTo(Byte value) {
			addCriterion("EXTRA_EXIST <=", value, "extraExist");
			return (Criteria) this;
		}

		public Criteria andExtraExistIn(List<Byte> values) {
			addCriterion("EXTRA_EXIST in", values, "extraExist");
			return (Criteria) this;
		}

		public Criteria andExtraExistNotIn(List<Byte> values) {
			addCriterion("EXTRA_EXIST not in", values, "extraExist");
			return (Criteria) this;
		}

		public Criteria andExtraExistBetween(Byte value1, Byte value2) {
			addCriterion("EXTRA_EXIST between", value1, value2, "extraExist");
			return (Criteria) this;
		}

		public Criteria andExtraExistNotBetween(Byte value1, Byte value2) {
			addCriterion("EXTRA_EXIST not between", value1, value2, "extraExist");
			return (Criteria) this;
		}

		public Criteria andAttRemarkIsNull() {
			addCriterion("ATT_REMARK is null");
			return (Criteria) this;
		}

		public Criteria andAttRemarkIsNotNull() {
			addCriterion("ATT_REMARK is not null");
			return (Criteria) this;
		}

		public Criteria andAttRemarkEqualTo(String value) {
			addCriterion("ATT_REMARK =", value, "attRemark");
			return (Criteria) this;
		}

		public Criteria andAttRemarkNotEqualTo(String value) {
			addCriterion("ATT_REMARK <>", value, "attRemark");
			return (Criteria) this;
		}

		public Criteria andAttRemarkGreaterThan(String value) {
			addCriterion("ATT_REMARK >", value, "attRemark");
			return (Criteria) this;
		}

		public Criteria andAttRemarkGreaterThanOrEqualTo(String value) {
			addCriterion("ATT_REMARK >=", value, "attRemark");
			return (Criteria) this;
		}

		public Criteria andAttRemarkLessThan(String value) {
			addCriterion("ATT_REMARK <", value, "attRemark");
			return (Criteria) this;
		}

		public Criteria andAttRemarkLessThanOrEqualTo(String value) {
			addCriterion("ATT_REMARK <=", value, "attRemark");
			return (Criteria) this;
		}

		public Criteria andAttRemarkLike(String value) {
			addCriterion("ATT_REMARK like", value, "attRemark");
			return (Criteria) this;
		}

		public Criteria andAttRemarkNotLike(String value) {
			addCriterion("ATT_REMARK not like", value, "attRemark");
			return (Criteria) this;
		}

		public Criteria andAttRemarkIn(List<String> values) {
			addCriterion("ATT_REMARK in", values, "attRemark");
			return (Criteria) this;
		}

		public Criteria andAttRemarkNotIn(List<String> values) {
			addCriterion("ATT_REMARK not in", values, "attRemark");
			return (Criteria) this;
		}

		public Criteria andAttRemarkBetween(String value1, String value2) {
			addCriterion("ATT_REMARK between", value1, value2, "attRemark");
			return (Criteria) this;
		}

		public Criteria andAttRemarkNotBetween(String value1, String value2) {
			addCriterion("ATT_REMARK not between", value1, value2, "attRemark");
			return (Criteria) this;
		}

		public Criteria andLocationAttResultIsNull() {
			addCriterion("LOCATION_ATT_RESULT is null");
			return (Criteria) this;
		}

		public Criteria andLocationAttResultIsNotNull() {
			addCriterion("LOCATION_ATT_RESULT is not null");
			return (Criteria) this;
		}

		public Criteria andLocationAttResultEqualTo(Byte value) {
			addCriterion("LOCATION_ATT_RESULT =", value, "locationAttResult");
			return (Criteria) this;
		}

		public Criteria andLocationAttResultNotEqualTo(Byte value) {
			addCriterion("LOCATION_ATT_RESULT <>", value, "locationAttResult");
			return (Criteria) this;
		}

		public Criteria andLocationAttResultGreaterThan(Byte value) {
			addCriterion("LOCATION_ATT_RESULT >", value, "locationAttResult");
			return (Criteria) this;
		}

		public Criteria andLocationAttResultGreaterThanOrEqualTo(Byte value) {
			addCriterion("LOCATION_ATT_RESULT >=", value, "locationAttResult");
			return (Criteria) this;
		}

		public Criteria andLocationAttResultLessThan(Byte value) {
			addCriterion("LOCATION_ATT_RESULT <", value, "locationAttResult");
			return (Criteria) this;
		}

		public Criteria andLocationAttResultLessThanOrEqualTo(Byte value) {
			addCriterion("LOCATION_ATT_RESULT <=", value, "locationAttResult");
			return (Criteria) this;
		}

		public Criteria andLocationAttResultIn(List<Byte> values) {
			addCriterion("LOCATION_ATT_RESULT in", values, "locationAttResult");
			return (Criteria) this;
		}

		public Criteria andLocationAttResultNotIn(List<Byte> values) {
			addCriterion("LOCATION_ATT_RESULT not in", values, "locationAttResult");
			return (Criteria) this;
		}

		public Criteria andLocationAttResultBetween(Byte value1, Byte value2) {
			addCriterion("LOCATION_ATT_RESULT between", value1, value2, "locationAttResult");
			return (Criteria) this;
		}

		public Criteria andLocationAttResultNotBetween(Byte value1, Byte value2) {
			addCriterion("LOCATION_ATT_RESULT not between", value1, value2, "locationAttResult");
			return (Criteria) this;
		}

		public Criteria andTimeAttResultIsNull() {
			addCriterion("TIME_ATT_RESULT is null");
			return (Criteria) this;
		}

		public Criteria andTimeAttResultIsNotNull() {
			addCriterion("TIME_ATT_RESULT is not null");
			return (Criteria) this;
		}

		public Criteria andTimeAttResultEqualTo(Byte value) {
			addCriterion("TIME_ATT_RESULT =", value, "timeAttResult");
			return (Criteria) this;
		}

		public Criteria andTimeAttResultNotEqualTo(Byte value) {
			addCriterion("TIME_ATT_RESULT <>", value, "timeAttResult");
			return (Criteria) this;
		}

		public Criteria andTimeAttResultGreaterThan(Byte value) {
			addCriterion("TIME_ATT_RESULT >", value, "timeAttResult");
			return (Criteria) this;
		}

		public Criteria andTimeAttResultGreaterThanOrEqualTo(Byte value) {
			addCriterion("TIME_ATT_RESULT >=", value, "timeAttResult");
			return (Criteria) this;
		}

		public Criteria andTimeAttResultLessThan(Byte value) {
			addCriterion("TIME_ATT_RESULT <", value, "timeAttResult");
			return (Criteria) this;
		}

		public Criteria andTimeAttResultLessThanOrEqualTo(Byte value) {
			addCriterion("TIME_ATT_RESULT <=", value, "timeAttResult");
			return (Criteria) this;
		}

		public Criteria andTimeAttResultIn(List<Byte> values) {
			addCriterion("TIME_ATT_RESULT in", values, "timeAttResult");
			return (Criteria) this;
		}

		public Criteria andTimeAttResultNotIn(List<Byte> values) {
			addCriterion("TIME_ATT_RESULT not in", values, "timeAttResult");
			return (Criteria) this;
		}

		public Criteria andTimeAttResultBetween(Byte value1, Byte value2) {
			addCriterion("TIME_ATT_RESULT between", value1, value2, "timeAttResult");
			return (Criteria) this;
		}

		public Criteria andTimeAttResultNotBetween(Byte value1, Byte value2) {
			addCriterion("TIME_ATT_RESULT not between", value1, value2, "timeAttResult");
			return (Criteria) this;
		}

		public Criteria andManageLocationAttResultIsNull() {
			addCriterion("MANAGE_LOCATION_ATT_RESULT is null");
			return (Criteria) this;
		}

		public Criteria andManageLocationAttResultIsNotNull() {
			addCriterion("MANAGE_LOCATION_ATT_RESULT is not null");
			return (Criteria) this;
		}

		public Criteria andManageLocationAttResultEqualTo(Byte value) {
			addCriterion("MANAGE_LOCATION_ATT_RESULT =", value, "manageLocationAttResult");
			return (Criteria) this;
		}

		public Criteria andManageLocationAttResultNotEqualTo(Byte value) {
			addCriterion("MANAGE_LOCATION_ATT_RESULT <>", value, "manageLocationAttResult");
			return (Criteria) this;
		}

		public Criteria andManageLocationAttResultGreaterThan(Byte value) {
			addCriterion("MANAGE_LOCATION_ATT_RESULT >", value, "manageLocationAttResult");
			return (Criteria) this;
		}

		public Criteria andManageLocationAttResultGreaterThanOrEqualTo(Byte value) {
			addCriterion("MANAGE_LOCATION_ATT_RESULT >=", value, "manageLocationAttResult");
			return (Criteria) this;
		}

		public Criteria andManageLocationAttResultLessThan(Byte value) {
			addCriterion("MANAGE_LOCATION_ATT_RESULT <", value, "manageLocationAttResult");
			return (Criteria) this;
		}

		public Criteria andManageLocationAttResultLessThanOrEqualTo(Byte value) {
			addCriterion("MANAGE_LOCATION_ATT_RESULT <=", value, "manageLocationAttResult");
			return (Criteria) this;
		}

		public Criteria andManageLocationAttResultIn(List<Byte> values) {
			addCriterion("MANAGE_LOCATION_ATT_RESULT in", values, "manageLocationAttResult");
			return (Criteria) this;
		}

		public Criteria andManageLocationAttResultNotIn(List<Byte> values) {
			addCriterion("MANAGE_LOCATION_ATT_RESULT not in", values, "manageLocationAttResult");
			return (Criteria) this;
		}

		public Criteria andManageLocationAttResultBetween(Byte value1, Byte value2) {
			addCriterion("MANAGE_LOCATION_ATT_RESULT between", value1, value2, "manageLocationAttResult");
			return (Criteria) this;
		}

		public Criteria andManageLocationAttResultNotBetween(Byte value1, Byte value2) {
			addCriterion("MANAGE_LOCATION_ATT_RESULT not between", value1, value2, "manageLocationAttResult");
			return (Criteria) this;
		}

		public Criteria andManageTimeAttResultIsNull() {
			addCriterion("MANAGE_TIME_ATT_RESULT is null");
			return (Criteria) this;
		}

		public Criteria andManageTimeAttResultIsNotNull() {
			addCriterion("MANAGE_TIME_ATT_RESULT is not null");
			return (Criteria) this;
		}

		public Criteria andManageTimeAttResultEqualTo(Byte value) {
			addCriterion("MANAGE_TIME_ATT_RESULT =", value, "manageTimeAttResult");
			return (Criteria) this;
		}

		public Criteria andManageTimeAttResultNotEqualTo(Byte value) {
			addCriterion("MANAGE_TIME_ATT_RESULT <>", value, "manageTimeAttResult");
			return (Criteria) this;
		}

		public Criteria andManageTimeAttResultGreaterThan(Byte value) {
			addCriterion("MANAGE_TIME_ATT_RESULT >", value, "manageTimeAttResult");
			return (Criteria) this;
		}

		public Criteria andManageTimeAttResultGreaterThanOrEqualTo(Byte value) {
			addCriterion("MANAGE_TIME_ATT_RESULT >=", value, "manageTimeAttResult");
			return (Criteria) this;
		}

		public Criteria andManageTimeAttResultLessThan(Byte value) {
			addCriterion("MANAGE_TIME_ATT_RESULT <", value, "manageTimeAttResult");
			return (Criteria) this;
		}

		public Criteria andManageTimeAttResultLessThanOrEqualTo(Byte value) {
			addCriterion("MANAGE_TIME_ATT_RESULT <=", value, "manageTimeAttResult");
			return (Criteria) this;
		}

		public Criteria andManageTimeAttResultIn(List<Byte> values) {
			addCriterion("MANAGE_TIME_ATT_RESULT in", values, "manageTimeAttResult");
			return (Criteria) this;
		}

		public Criteria andManageTimeAttResultNotIn(List<Byte> values) {
			addCriterion("MANAGE_TIME_ATT_RESULT not in", values, "manageTimeAttResult");
			return (Criteria) this;
		}

		public Criteria andManageTimeAttResultBetween(Byte value1, Byte value2) {
			addCriterion("MANAGE_TIME_ATT_RESULT between", value1, value2, "manageTimeAttResult");
			return (Criteria) this;
		}

		public Criteria andManageTimeAttResultNotBetween(Byte value1, Byte value2) {
			addCriterion("MANAGE_TIME_ATT_RESULT not between", value1, value2, "manageTimeAttResult");
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

		public Criteria andEditDeptIdIsNull() {
			addCriterion("EDIT_DEPT_ID is null");
			return (Criteria) this;
		}

		public Criteria andEditDeptIdIsNotNull() {
			addCriterion("EDIT_DEPT_ID is not null");
			return (Criteria) this;
		}

		public Criteria andEditDeptIdEqualTo(Integer value) {
			addCriterion("EDIT_DEPT_ID =", value, "editDeptId");
			return (Criteria) this;
		}

		public Criteria andEditDeptIdNotEqualTo(Integer value) {
			addCriterion("EDIT_DEPT_ID <>", value, "editDeptId");
			return (Criteria) this;
		}

		public Criteria andEditDeptIdGreaterThan(Integer value) {
			addCriterion("EDIT_DEPT_ID >", value, "editDeptId");
			return (Criteria) this;
		}

		public Criteria andEditDeptIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("EDIT_DEPT_ID >=", value, "editDeptId");
			return (Criteria) this;
		}

		public Criteria andEditDeptIdLessThan(Integer value) {
			addCriterion("EDIT_DEPT_ID <", value, "editDeptId");
			return (Criteria) this;
		}

		public Criteria andEditDeptIdLessThanOrEqualTo(Integer value) {
			addCriterion("EDIT_DEPT_ID <=", value, "editDeptId");
			return (Criteria) this;
		}

		public Criteria andEditDeptIdIn(List<Integer> values) {
			addCriterion("EDIT_DEPT_ID in", values, "editDeptId");
			return (Criteria) this;
		}

		public Criteria andEditDeptIdNotIn(List<Integer> values) {
			addCriterion("EDIT_DEPT_ID not in", values, "editDeptId");
			return (Criteria) this;
		}

		public Criteria andEditDeptIdBetween(Integer value1, Integer value2) {
			addCriterion("EDIT_DEPT_ID between", value1, value2, "editDeptId");
			return (Criteria) this;
		}

		public Criteria andEditDeptIdNotBetween(Integer value1, Integer value2) {
			addCriterion("EDIT_DEPT_ID not between", value1, value2, "editDeptId");
			return (Criteria) this;
		}

		public Criteria andEditUserIdIsNull() {
			addCriterion("EDIT_USER_ID is null");
			return (Criteria) this;
		}

		public Criteria andEditUserIdIsNotNull() {
			addCriterion("EDIT_USER_ID is not null");
			return (Criteria) this;
		}

		public Criteria andEditUserIdEqualTo(Integer value) {
			addCriterion("EDIT_USER_ID =", value, "editUserId");
			return (Criteria) this;
		}

		public Criteria andEditUserIdNotEqualTo(Integer value) {
			addCriterion("EDIT_USER_ID <>", value, "editUserId");
			return (Criteria) this;
		}

		public Criteria andEditUserIdGreaterThan(Integer value) {
			addCriterion("EDIT_USER_ID >", value, "editUserId");
			return (Criteria) this;
		}

		public Criteria andEditUserIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("EDIT_USER_ID >=", value, "editUserId");
			return (Criteria) this;
		}

		public Criteria andEditUserIdLessThan(Integer value) {
			addCriterion("EDIT_USER_ID <", value, "editUserId");
			return (Criteria) this;
		}

		public Criteria andEditUserIdLessThanOrEqualTo(Integer value) {
			addCriterion("EDIT_USER_ID <=", value, "editUserId");
			return (Criteria) this;
		}

		public Criteria andEditUserIdIn(List<Integer> values) {
			addCriterion("EDIT_USER_ID in", values, "editUserId");
			return (Criteria) this;
		}

		public Criteria andEditUserIdNotIn(List<Integer> values) {
			addCriterion("EDIT_USER_ID not in", values, "editUserId");
			return (Criteria) this;
		}

		public Criteria andEditUserIdBetween(Integer value1, Integer value2) {
			addCriterion("EDIT_USER_ID between", value1, value2, "editUserId");
			return (Criteria) this;
		}

		public Criteria andEditUserIdNotBetween(Integer value1, Integer value2) {
			addCriterion("EDIT_USER_ID not between", value1, value2, "editUserId");
			return (Criteria) this;
		}

		public Criteria andEditRemarkIsNull() {
			addCriterion("EDIT_REMARK is null");
			return (Criteria) this;
		}

		public Criteria andEditRemarkIsNotNull() {
			addCriterion("EDIT_REMARK is not null");
			return (Criteria) this;
		}

		public Criteria andEditRemarkEqualTo(String value) {
			addCriterion("EDIT_REMARK =", value, "editRemark");
			return (Criteria) this;
		}

		public Criteria andEditRemarkNotEqualTo(String value) {
			addCriterion("EDIT_REMARK <>", value, "editRemark");
			return (Criteria) this;
		}

		public Criteria andEditRemarkGreaterThan(String value) {
			addCriterion("EDIT_REMARK >", value, "editRemark");
			return (Criteria) this;
		}

		public Criteria andEditRemarkGreaterThanOrEqualTo(String value) {
			addCriterion("EDIT_REMARK >=", value, "editRemark");
			return (Criteria) this;
		}

		public Criteria andEditRemarkLessThan(String value) {
			addCriterion("EDIT_REMARK <", value, "editRemark");
			return (Criteria) this;
		}

		public Criteria andEditRemarkLessThanOrEqualTo(String value) {
			addCriterion("EDIT_REMARK <=", value, "editRemark");
			return (Criteria) this;
		}

		public Criteria andEditRemarkLike(String value) {
			addCriterion("EDIT_REMARK like", value, "editRemark");
			return (Criteria) this;
		}

		public Criteria andEditRemarkNotLike(String value) {
			addCriterion("EDIT_REMARK not like", value, "editRemark");
			return (Criteria) this;
		}

		public Criteria andEditRemarkIn(List<String> values) {
			addCriterion("EDIT_REMARK in", values, "editRemark");
			return (Criteria) this;
		}

		public Criteria andEditRemarkNotIn(List<String> values) {
			addCriterion("EDIT_REMARK not in", values, "editRemark");
			return (Criteria) this;
		}

		public Criteria andEditRemarkBetween(String value1, String value2) {
			addCriterion("EDIT_REMARK between", value1, value2, "editRemark");
			return (Criteria) this;
		}

		public Criteria andEditRemarkNotBetween(String value1, String value2) {
			addCriterion("EDIT_REMARK not between", value1, value2, "editRemark");
			return (Criteria) this;
		}

		public Criteria andAttOughtDateIsNull() {
			addCriterion("ATT_OUGHT_DATE is null");
			return (Criteria) this;
		}

		public Criteria andAttOughtDateIsNotNull() {
			addCriterion("ATT_OUGHT_DATE is not null");
			return (Criteria) this;
		}

		public Criteria andAttOughtDateEqualTo(Date value) {
			addCriterion("ATT_OUGHT_DATE =", value, "attOughtDate");
			return (Criteria) this;
		}

		public Criteria andAttOughtDateNotEqualTo(Date value) {
			addCriterion("ATT_OUGHT_DATE <>", value, "attOughtDate");
			return (Criteria) this;
		}

		public Criteria andAttOughtDateGreaterThan(Date value) {
			addCriterion("ATT_OUGHT_DATE >", value, "attOughtDate");
			return (Criteria) this;
		}

		public Criteria andAttOughtDateGreaterThanOrEqualTo(Date value) {
			addCriterion("ATT_OUGHT_DATE >=", value, "attOughtDate");
			return (Criteria) this;
		}

		public Criteria andAttOughtDateLessThan(Date value) {
			addCriterion("ATT_OUGHT_DATE <", value, "attOughtDate");
			return (Criteria) this;
		}

		public Criteria andAttOughtDateLessThanOrEqualTo(Date value) {
			addCriterion("ATT_OUGHT_DATE <=", value, "attOughtDate");
			return (Criteria) this;
		}

		public Criteria andAttOughtDateIn(List<Date> values) {
			addCriterion("ATT_OUGHT_DATE in", values, "attOughtDate");
			return (Criteria) this;
		}

		public Criteria andAttOughtDateNotIn(List<Date> values) {
			addCriterion("ATT_OUGHT_DATE not in", values, "attOughtDate");
			return (Criteria) this;
		}

		public Criteria andAttOughtDateBetween(Date value1, Date value2) {
			addCriterion("ATT_OUGHT_DATE between", value1, value2, "attOughtDate");
			return (Criteria) this;
		}

		public Criteria andAttOughtDateNotBetween(Date value1, Date value2) {
			addCriterion("ATT_OUGHT_DATE not between", value1, value2, "attOughtDate");
			return (Criteria) this;
		}

		public Criteria andAttScopeIdIsNull() {
			addCriterion("ATT_SCOPE_ID is null");
			return (Criteria) this;
		}

		public Criteria andAttScopeIdIsNotNull() {
			addCriterion("ATT_SCOPE_ID is not null");
			return (Criteria) this;
		}

		public Criteria andAttScopeIdEqualTo(Integer value) {
			addCriterion("ATT_SCOPE_ID =", value, "attScopeId");
			return (Criteria) this;
		}

		public Criteria andAttScopeIdNotEqualTo(Integer value) {
			addCriterion("ATT_SCOPE_ID <>", value, "attScopeId");
			return (Criteria) this;
		}

		public Criteria andAttScopeIdGreaterThan(Integer value) {
			addCriterion("ATT_SCOPE_ID >", value, "attScopeId");
			return (Criteria) this;
		}

		public Criteria andAttScopeIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("ATT_SCOPE_ID >=", value, "attScopeId");
			return (Criteria) this;
		}

		public Criteria andAttScopeIdLessThan(Integer value) {
			addCriterion("ATT_SCOPE_ID <", value, "attScopeId");
			return (Criteria) this;
		}

		public Criteria andAttScopeIdLessThanOrEqualTo(Integer value) {
			addCriterion("ATT_SCOPE_ID <=", value, "attScopeId");
			return (Criteria) this;
		}

		public Criteria andAttScopeIdIn(List<Integer> values) {
			addCriterion("ATT_SCOPE_ID in", values, "attScopeId");
			return (Criteria) this;
		}

		public Criteria andAttScopeIdNotIn(List<Integer> values) {
			addCriterion("ATT_SCOPE_ID not in", values, "attScopeId");
			return (Criteria) this;
		}

		public Criteria andAttScopeIdBetween(Integer value1, Integer value2) {
			addCriterion("ATT_SCOPE_ID between", value1, value2, "attScopeId");
			return (Criteria) this;
		}

		public Criteria andAttScopeIdNotBetween(Integer value1, Integer value2) {
			addCriterion("ATT_SCOPE_ID not between", value1, value2, "attScopeId");
			return (Criteria) this;
		}

		public Criteria andDeviceIdIsNull() {
			addCriterion("DEVICE_ID is null");
			return (Criteria) this;
		}

		public Criteria andDeviceIdIsNotNull() {
			addCriterion("DEVICE_ID is not null");
			return (Criteria) this;
		}

		public Criteria andDeviceIdEqualTo(String value) {
			addCriterion("DEVICE_ID =", value, "deviceId");
			return (Criteria) this;
		}

		public Criteria andDeviceIdNotEqualTo(String value) {
			addCriterion("DEVICE_ID <>", value, "deviceId");
			return (Criteria) this;
		}

		public Criteria andDeviceIdGreaterThan(String value) {
			addCriterion("DEVICE_ID >", value, "deviceId");
			return (Criteria) this;
		}

		public Criteria andDeviceIdGreaterThanOrEqualTo(String value) {
			addCriterion("DEVICE_ID >=", value, "deviceId");
			return (Criteria) this;
		}

		public Criteria andDeviceIdLessThan(String value) {
			addCriterion("DEVICE_ID <", value, "deviceId");
			return (Criteria) this;
		}

		public Criteria andDeviceIdLessThanOrEqualTo(String value) {
			addCriterion("DEVICE_ID <=", value, "deviceId");
			return (Criteria) this;
		}

		public Criteria andDeviceIdLike(String value) {
			addCriterion("DEVICE_ID like", value, "deviceId");
			return (Criteria) this;
		}

		public Criteria andDeviceIdNotLike(String value) {
			addCriterion("DEVICE_ID not like", value, "deviceId");
			return (Criteria) this;
		}

		public Criteria andDeviceIdIn(List<String> values) {
			addCriterion("DEVICE_ID in", values, "deviceId");
			return (Criteria) this;
		}

		public Criteria andDeviceIdNotIn(List<String> values) {
			addCriterion("DEVICE_ID not in", values, "deviceId");
			return (Criteria) this;
		}

		public Criteria andDeviceIdBetween(String value1, String value2) {
			addCriterion("DEVICE_ID between", value1, value2, "deviceId");
			return (Criteria) this;
		}

		public Criteria andDeviceIdNotBetween(String value1, String value2) {
			addCriterion("DEVICE_ID not between", value1, value2, "deviceId");
			return (Criteria) this;
		}

		public Criteria andDeviceTypeIsNull() {
			addCriterion("DEVICE_TYPE is null");
			return (Criteria) this;
		}

		public Criteria andDeviceTypeIsNotNull() {
			addCriterion("DEVICE_TYPE is not null");
			return (Criteria) this;
		}

		public Criteria andDeviceTypeEqualTo(Byte value) {
			addCriterion("DEVICE_TYPE =", value, "deviceType");
			return (Criteria) this;
		}

		public Criteria andDeviceTypeNotEqualTo(Byte value) {
			addCriterion("DEVICE_TYPE <>", value, "deviceType");
			return (Criteria) this;
		}

		public Criteria andDeviceTypeGreaterThan(Byte value) {
			addCriterion("DEVICE_TYPE >", value, "deviceType");
			return (Criteria) this;
		}

		public Criteria andDeviceTypeGreaterThanOrEqualTo(Byte value) {
			addCriterion("DEVICE_TYPE >=", value, "deviceType");
			return (Criteria) this;
		}

		public Criteria andDeviceTypeLessThan(Byte value) {
			addCriterion("DEVICE_TYPE <", value, "deviceType");
			return (Criteria) this;
		}

		public Criteria andDeviceTypeLessThanOrEqualTo(Byte value) {
			addCriterion("DEVICE_TYPE <=", value, "deviceType");
			return (Criteria) this;
		}

		public Criteria andDeviceTypeIn(List<Byte> values) {
			addCriterion("DEVICE_TYPE in", values, "deviceType");
			return (Criteria) this;
		}

		public Criteria andDeviceTypeNotIn(List<Byte> values) {
			addCriterion("DEVICE_TYPE not in", values, "deviceType");
			return (Criteria) this;
		}

		public Criteria andDeviceTypeBetween(Byte value1, Byte value2) {
			addCriterion("DEVICE_TYPE between", value1, value2, "deviceType");
			return (Criteria) this;
		}

		public Criteria andDeviceTypeNotBetween(Byte value1, Byte value2) {
			addCriterion("DEVICE_TYPE not between", value1, value2, "deviceType");
			return (Criteria) this;
		}

		public Criteria andDeviceNameIsNull() {
			addCriterion("DEVICE_NAME is null");
			return (Criteria) this;
		}

		public Criteria andDeviceNameIsNotNull() {
			addCriterion("DEVICE_NAME is not null");
			return (Criteria) this;
		}

		public Criteria andDeviceNameEqualTo(String value) {
			addCriterion("DEVICE_NAME =", value, "deviceName");
			return (Criteria) this;
		}

		public Criteria andDeviceNameNotEqualTo(String value) {
			addCriterion("DEVICE_NAME <>", value, "deviceName");
			return (Criteria) this;
		}

		public Criteria andDeviceNameGreaterThan(String value) {
			addCriterion("DEVICE_NAME >", value, "deviceName");
			return (Criteria) this;
		}

		public Criteria andDeviceNameGreaterThanOrEqualTo(String value) {
			addCriterion("DEVICE_NAME >=", value, "deviceName");
			return (Criteria) this;
		}

		public Criteria andDeviceNameLessThan(String value) {
			addCriterion("DEVICE_NAME <", value, "deviceName");
			return (Criteria) this;
		}

		public Criteria andDeviceNameLessThanOrEqualTo(String value) {
			addCriterion("DEVICE_NAME <=", value, "deviceName");
			return (Criteria) this;
		}

		public Criteria andDeviceNameLike(String value) {
			addCriterion("DEVICE_NAME like", value, "deviceName");
			return (Criteria) this;
		}

		public Criteria andDeviceNameNotLike(String value) {
			addCriterion("DEVICE_NAME not like", value, "deviceName");
			return (Criteria) this;
		}

		public Criteria andDeviceNameIn(List<String> values) {
			addCriterion("DEVICE_NAME in", values, "deviceName");
			return (Criteria) this;
		}

		public Criteria andDeviceNameNotIn(List<String> values) {
			addCriterion("DEVICE_NAME not in", values, "deviceName");
			return (Criteria) this;
		}

		public Criteria andDeviceNameBetween(String value1, String value2) {
			addCriterion("DEVICE_NAME between", value1, value2, "deviceName");
			return (Criteria) this;
		}

		public Criteria andDeviceNameNotBetween(String value1, String value2) {
			addCriterion("DEVICE_NAME not between", value1, value2, "deviceName");
			return (Criteria) this;
		}

		public Criteria andBelateMinuteIsNull() {
			addCriterion("BELATE_MINUTE is null");
			return (Criteria) this;
		}

		public Criteria andBelateMinuteIsNotNull() {
			addCriterion("BELATE_MINUTE is not null");
			return (Criteria) this;
		}

		public Criteria andBelateMinuteEqualTo(Integer value) {
			addCriterion("BELATE_MINUTE =", value, "belateMinute");
			return (Criteria) this;
		}

		public Criteria andBelateMinuteNotEqualTo(Integer value) {
			addCriterion("BELATE_MINUTE <>", value, "belateMinute");
			return (Criteria) this;
		}

		public Criteria andBelateMinuteGreaterThan(Integer value) {
			addCriterion("BELATE_MINUTE >", value, "belateMinute");
			return (Criteria) this;
		}

		public Criteria andBelateMinuteGreaterThanOrEqualTo(Integer value) {
			addCriterion("BELATE_MINUTE >=", value, "belateMinute");
			return (Criteria) this;
		}

		public Criteria andBelateMinuteLessThan(Integer value) {
			addCriterion("BELATE_MINUTE <", value, "belateMinute");
			return (Criteria) this;
		}

		public Criteria andBelateMinuteLessThanOrEqualTo(Integer value) {
			addCriterion("BELATE_MINUTE <=", value, "belateMinute");
			return (Criteria) this;
		}

		public Criteria andBelateMinuteIn(List<Integer> values) {
			addCriterion("BELATE_MINUTE in", values, "belateMinute");
			return (Criteria) this;
		}

		public Criteria andBelateMinuteNotIn(List<Integer> values) {
			addCriterion("BELATE_MINUTE not in", values, "belateMinute");
			return (Criteria) this;
		}

		public Criteria andBelateMinuteBetween(Integer value1, Integer value2) {
			addCriterion("BELATE_MINUTE between", value1, value2, "belateMinute");
			return (Criteria) this;
		}

		public Criteria andBelateMinuteNotBetween(Integer value1, Integer value2) {
			addCriterion("BELATE_MINUTE not between", value1, value2, "belateMinute");
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

		public Criteria andAttConfigLocationIsNull() {
			addCriterion("ATT_CONFIG_LOCATION is null");
			return (Criteria) this;
		}

		public Criteria andAttConfigLocationIsNotNull() {
			addCriterion("ATT_CONFIG_LOCATION is not null");
			return (Criteria) this;
		}

		public Criteria andAttConfigLocationEqualTo(String value) {
			addCriterion("ATT_CONFIG_LOCATION =", value, "attConfigLocation");
			return (Criteria) this;
		}

		public Criteria andAttConfigLocationNotEqualTo(String value) {
			addCriterion("ATT_CONFIG_LOCATION <>", value, "attConfigLocation");
			return (Criteria) this;
		}

		public Criteria andAttConfigLocationGreaterThan(String value) {
			addCriterion("ATT_CONFIG_LOCATION >", value, "attConfigLocation");
			return (Criteria) this;
		}

		public Criteria andAttConfigLocationGreaterThanOrEqualTo(String value) {
			addCriterion("ATT_CONFIG_LOCATION >=", value, "attConfigLocation");
			return (Criteria) this;
		}

		public Criteria andAttConfigLocationLessThan(String value) {
			addCriterion("ATT_CONFIG_LOCATION <", value, "attConfigLocation");
			return (Criteria) this;
		}

		public Criteria andAttConfigLocationLessThanOrEqualTo(String value) {
			addCriterion("ATT_CONFIG_LOCATION <=", value, "attConfigLocation");
			return (Criteria) this;
		}

		public Criteria andAttConfigLocationLike(String value) {
			addCriterion("ATT_CONFIG_LOCATION like", value, "attConfigLocation");
			return (Criteria) this;
		}

		public Criteria andAttConfigLocationNotLike(String value) {
			addCriterion("ATT_CONFIG_LOCATION not like", value, "attConfigLocation");
			return (Criteria) this;
		}

		public Criteria andAttConfigLocationIn(List<String> values) {
			addCriterion("ATT_CONFIG_LOCATION in", values, "attConfigLocation");
			return (Criteria) this;
		}

		public Criteria andAttConfigLocationNotIn(List<String> values) {
			addCriterion("ATT_CONFIG_LOCATION not in", values, "attConfigLocation");
			return (Criteria) this;
		}

		public Criteria andAttConfigLocationBetween(String value1, String value2) {
			addCriterion("ATT_CONFIG_LOCATION between", value1, value2, "attConfigLocation");
			return (Criteria) this;
		}

		public Criteria andAttConfigLocationNotBetween(String value1, String value2) {
			addCriterion("ATT_CONFIG_LOCATION not between", value1, value2, "attConfigLocation");
			return (Criteria) this;
		}

		public Criteria andAttConfigDistanceIsNull() {
			addCriterion("ATT_CONFIG_DISTANCE is null");
			return (Criteria) this;
		}

		public Criteria andAttConfigDistanceIsNotNull() {
			addCriterion("ATT_CONFIG_DISTANCE is not null");
			return (Criteria) this;
		}

		public Criteria andAttConfigDistanceEqualTo(Integer value) {
			addCriterion("ATT_CONFIG_DISTANCE =", value, "attConfigDistance");
			return (Criteria) this;
		}

		public Criteria andAttConfigDistanceNotEqualTo(Integer value) {
			addCriterion("ATT_CONFIG_DISTANCE <>", value, "attConfigDistance");
			return (Criteria) this;
		}

		public Criteria andAttConfigDistanceGreaterThan(Integer value) {
			addCriterion("ATT_CONFIG_DISTANCE >", value, "attConfigDistance");
			return (Criteria) this;
		}

		public Criteria andAttConfigDistanceGreaterThanOrEqualTo(Integer value) {
			addCriterion("ATT_CONFIG_DISTANCE >=", value, "attConfigDistance");
			return (Criteria) this;
		}

		public Criteria andAttConfigDistanceLessThan(Integer value) {
			addCriterion("ATT_CONFIG_DISTANCE <", value, "attConfigDistance");
			return (Criteria) this;
		}

		public Criteria andAttConfigDistanceLessThanOrEqualTo(Integer value) {
			addCriterion("ATT_CONFIG_DISTANCE <=", value, "attConfigDistance");
			return (Criteria) this;
		}

		public Criteria andAttConfigDistanceIn(List<Integer> values) {
			addCriterion("ATT_CONFIG_DISTANCE in", values, "attConfigDistance");
			return (Criteria) this;
		}

		public Criteria andAttConfigDistanceNotIn(List<Integer> values) {
			addCriterion("ATT_CONFIG_DISTANCE not in", values, "attConfigDistance");
			return (Criteria) this;
		}

		public Criteria andAttConfigDistanceBetween(Integer value1, Integer value2) {
			addCriterion("ATT_CONFIG_DISTANCE between", value1, value2, "attConfigDistance");
			return (Criteria) this;
		}

		public Criteria andAttConfigDistanceNotBetween(Integer value1, Integer value2) {
			addCriterion("ATT_CONFIG_DISTANCE not between", value1, value2, "attConfigDistance");
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

		public Criteria andAttResultWeightIsNull() {
			addCriterion("ATT_RESULT_WEIGHT is null");
			return (Criteria) this;
		}

		public Criteria andAttResultWeightIsNotNull() {
			addCriterion("ATT_RESULT_WEIGHT is not null");
			return (Criteria) this;
		}

		public Criteria andAttResultWeightEqualTo(Byte value) {
			addCriterion("ATT_RESULT_WEIGHT =", value, "attResultWeight");
			return (Criteria) this;
		}

		public Criteria andAttResultWeightNotEqualTo(Byte value) {
			addCriterion("ATT_RESULT_WEIGHT <>", value, "attResultWeight");
			return (Criteria) this;
		}

		public Criteria andAttResultWeightGreaterThan(Byte value) {
			addCriterion("ATT_RESULT_WEIGHT >", value, "attResultWeight");
			return (Criteria) this;
		}

		public Criteria andAttResultWeightGreaterThanOrEqualTo(Byte value) {
			addCriterion("ATT_RESULT_WEIGHT >=", value, "attResultWeight");
			return (Criteria) this;
		}

		public Criteria andAttResultWeightLessThan(Byte value) {
			addCriterion("ATT_RESULT_WEIGHT <", value, "attResultWeight");
			return (Criteria) this;
		}

		public Criteria andAttResultWeightLessThanOrEqualTo(Byte value) {
			addCriterion("ATT_RESULT_WEIGHT <=", value, "attResultWeight");
			return (Criteria) this;
		}

		public Criteria andAttResultWeightIn(List<Byte> values) {
			addCriterion("ATT_RESULT_WEIGHT in", values, "attResultWeight");
			return (Criteria) this;
		}

		public Criteria andAttResultWeightNotIn(List<Byte> values) {
			addCriterion("ATT_RESULT_WEIGHT not in", values, "attResultWeight");
			return (Criteria) this;
		}

		public Criteria andAttResultWeightBetween(Byte value1, Byte value2) {
			addCriterion("ATT_RESULT_WEIGHT between", value1, value2, "attResultWeight");
			return (Criteria) this;
		}

		public Criteria andAttResultWeightNotBetween(Byte value1, Byte value2) {
			addCriterion("ATT_RESULT_WEIGHT not between", value1, value2, "attResultWeight");
			return (Criteria) this;
		}

		public Criteria andAttGroupNameIsNull() {
			addCriterion("ATT_GROUP_NAME is null");
			return (Criteria) this;
		}

		public Criteria andAttGroupNameIsNotNull() {
			addCriterion("ATT_GROUP_NAME is not null");
			return (Criteria) this;
		}

		public Criteria andAttGroupNameEqualTo(String value) {
			addCriterion("ATT_GROUP_NAME =", value, "attGroupName");
			return (Criteria) this;
		}

		public Criteria andAttGroupNameNotEqualTo(String value) {
			addCriterion("ATT_GROUP_NAME <>", value, "attGroupName");
			return (Criteria) this;
		}

		public Criteria andAttGroupNameGreaterThan(String value) {
			addCriterion("ATT_GROUP_NAME >", value, "attGroupName");
			return (Criteria) this;
		}

		public Criteria andAttGroupNameGreaterThanOrEqualTo(String value) {
			addCriterion("ATT_GROUP_NAME >=", value, "attGroupName");
			return (Criteria) this;
		}

		public Criteria andAttGroupNameLessThan(String value) {
			addCriterion("ATT_GROUP_NAME <", value, "attGroupName");
			return (Criteria) this;
		}

		public Criteria andAttGroupNameLessThanOrEqualTo(String value) {
			addCriterion("ATT_GROUP_NAME <=", value, "attGroupName");
			return (Criteria) this;
		}

		public Criteria andAttGroupNameLike(String value) {
			addCriterion("ATT_GROUP_NAME like", value, "attGroupName");
			return (Criteria) this;
		}

		public Criteria andAttGroupNameNotLike(String value) {
			addCriterion("ATT_GROUP_NAME not like", value, "attGroupName");
			return (Criteria) this;
		}

		public Criteria andAttGroupNameIn(List<String> values) {
			addCriterion("ATT_GROUP_NAME in", values, "attGroupName");
			return (Criteria) this;
		}

		public Criteria andAttGroupNameNotIn(List<String> values) {
			addCriterion("ATT_GROUP_NAME not in", values, "attGroupName");
			return (Criteria) this;
		}

		public Criteria andAttGroupNameBetween(String value1, String value2) {
			addCriterion("ATT_GROUP_NAME between", value1, value2, "attGroupName");
			return (Criteria) this;
		}

		public Criteria andAttGroupNameNotBetween(String value1, String value2) {
			addCriterion("ATT_GROUP_NAME not between", value1, value2, "attGroupName");
			return (Criteria) this;
		}

		public Criteria andAttClassNameIsNull() {
			addCriterion("ATT_CLASS_NAME is null");
			return (Criteria) this;
		}

		public Criteria andAttClassNameIsNotNull() {
			addCriterion("ATT_CLASS_NAME is not null");
			return (Criteria) this;
		}

		public Criteria andAttClassNameEqualTo(String value) {
			addCriterion("ATT_CLASS_NAME =", value, "attClassName");
			return (Criteria) this;
		}

		public Criteria andAttClassNameNotEqualTo(String value) {
			addCriterion("ATT_CLASS_NAME <>", value, "attClassName");
			return (Criteria) this;
		}

		public Criteria andAttClassNameGreaterThan(String value) {
			addCriterion("ATT_CLASS_NAME >", value, "attClassName");
			return (Criteria) this;
		}

		public Criteria andAttClassNameGreaterThanOrEqualTo(String value) {
			addCriterion("ATT_CLASS_NAME >=", value, "attClassName");
			return (Criteria) this;
		}

		public Criteria andAttClassNameLessThan(String value) {
			addCriterion("ATT_CLASS_NAME <", value, "attClassName");
			return (Criteria) this;
		}

		public Criteria andAttClassNameLessThanOrEqualTo(String value) {
			addCriterion("ATT_CLASS_NAME <=", value, "attClassName");
			return (Criteria) this;
		}

		public Criteria andAttClassNameLike(String value) {
			addCriterion("ATT_CLASS_NAME like", value, "attClassName");
			return (Criteria) this;
		}

		public Criteria andAttClassNameNotLike(String value) {
			addCriterion("ATT_CLASS_NAME not like", value, "attClassName");
			return (Criteria) this;
		}

		public Criteria andAttClassNameIn(List<String> values) {
			addCriterion("ATT_CLASS_NAME in", values, "attClassName");
			return (Criteria) this;
		}

		public Criteria andAttClassNameNotIn(List<String> values) {
			addCriterion("ATT_CLASS_NAME not in", values, "attClassName");
			return (Criteria) this;
		}

		public Criteria andAttClassNameBetween(String value1, String value2) {
			addCriterion("ATT_CLASS_NAME between", value1, value2, "attClassName");
			return (Criteria) this;
		}

		public Criteria andAttClassNameNotBetween(String value1, String value2) {
			addCriterion("ATT_CLASS_NAME not between", value1, value2, "attClassName");
			return (Criteria) this;
		}

		public Criteria andAttWayIsNull() {
			addCriterion("ATT_WAY is null");
			return (Criteria) this;
		}

		public Criteria andAttWayIsNotNull() {
			addCriterion("ATT_WAY is not null");
			return (Criteria) this;
		}

		public Criteria andAttWayEqualTo(Byte value) {
			addCriterion("ATT_WAY =", value, "attWay");
			return (Criteria) this;
		}

		public Criteria andAttWayNotEqualTo(Byte value) {
			addCriterion("ATT_WAY <>", value, "attWay");
			return (Criteria) this;
		}

		public Criteria andAttWayGreaterThan(Byte value) {
			addCriterion("ATT_WAY >", value, "attWay");
			return (Criteria) this;
		}

		public Criteria andAttWayGreaterThanOrEqualTo(Byte value) {
			addCriterion("ATT_WAY >=", value, "attWay");
			return (Criteria) this;
		}

		public Criteria andAttWayLessThan(Byte value) {
			addCriterion("ATT_WAY <", value, "attWay");
			return (Criteria) this;
		}

		public Criteria andAttWayLessThanOrEqualTo(Byte value) {
			addCriterion("ATT_WAY <=", value, "attWay");
			return (Criteria) this;
		}

		public Criteria andAttWayIn(List<Byte> values) {
			addCriterion("ATT_WAY in", values, "attWay");
			return (Criteria) this;
		}

		public Criteria andAttWayNotIn(List<Byte> values) {
			addCriterion("ATT_WAY not in", values, "attWay");
			return (Criteria) this;
		}

		public Criteria andAttWayBetween(Byte value1, Byte value2) {
			addCriterion("ATT_WAY between", value1, value2, "attWay");
			return (Criteria) this;
		}

		public Criteria andAttWayNotBetween(Byte value1, Byte value2) {
			addCriterion("ATT_WAY not between", value1, value2, "attWay");
			return (Criteria) this;
		}

		public Criteria andWifiIdIsNull() {
			addCriterion("WIFI_ID is null");
			return (Criteria) this;
		}

		public Criteria andWifiIdIsNotNull() {
			addCriterion("WIFI_ID is not null");
			return (Criteria) this;
		}

		public Criteria andWifiIdEqualTo(Integer value) {
			addCriterion("WIFI_ID =", value, "wifiId");
			return (Criteria) this;
		}

		public Criteria andWifiIdNotEqualTo(Integer value) {
			addCriterion("WIFI_ID <>", value, "wifiId");
			return (Criteria) this;
		}

		public Criteria andWifiIdGreaterThan(Integer value) {
			addCriterion("WIFI_ID >", value, "wifiId");
			return (Criteria) this;
		}

		public Criteria andWifiIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("WIFI_ID >=", value, "wifiId");
			return (Criteria) this;
		}

		public Criteria andWifiIdLessThan(Integer value) {
			addCriterion("WIFI_ID <", value, "wifiId");
			return (Criteria) this;
		}

		public Criteria andWifiIdLessThanOrEqualTo(Integer value) {
			addCriterion("WIFI_ID <=", value, "wifiId");
			return (Criteria) this;
		}

		public Criteria andWifiIdIn(List<Integer> values) {
			addCriterion("WIFI_ID in", values, "wifiId");
			return (Criteria) this;
		}

		public Criteria andWifiIdNotIn(List<Integer> values) {
			addCriterion("WIFI_ID not in", values, "wifiId");
			return (Criteria) this;
		}

		public Criteria andWifiIdBetween(Integer value1, Integer value2) {
			addCriterion("WIFI_ID between", value1, value2, "wifiId");
			return (Criteria) this;
		}

		public Criteria andWifiIdNotBetween(Integer value1, Integer value2) {
			addCriterion("WIFI_ID not between", value1, value2, "wifiId");
			return (Criteria) this;
		}

		public Criteria andAttWifiSsidIsNull() {
			addCriterion("ATT_WIFI_SSID is null");
			return (Criteria) this;
		}

		public Criteria andAttWifiSsidIsNotNull() {
			addCriterion("ATT_WIFI_SSID is not null");
			return (Criteria) this;
		}

		public Criteria andAttWifiSsidEqualTo(String value) {
			addCriterion("ATT_WIFI_SSID =", value, "attWifiSsid");
			return (Criteria) this;
		}

		public Criteria andAttWifiSsidNotEqualTo(String value) {
			addCriterion("ATT_WIFI_SSID <>", value, "attWifiSsid");
			return (Criteria) this;
		}

		public Criteria andAttWifiSsidGreaterThan(String value) {
			addCriterion("ATT_WIFI_SSID >", value, "attWifiSsid");
			return (Criteria) this;
		}

		public Criteria andAttWifiSsidGreaterThanOrEqualTo(String value) {
			addCriterion("ATT_WIFI_SSID >=", value, "attWifiSsid");
			return (Criteria) this;
		}

		public Criteria andAttWifiSsidLessThan(String value) {
			addCriterion("ATT_WIFI_SSID <", value, "attWifiSsid");
			return (Criteria) this;
		}

		public Criteria andAttWifiSsidLessThanOrEqualTo(String value) {
			addCriterion("ATT_WIFI_SSID <=", value, "attWifiSsid");
			return (Criteria) this;
		}

		public Criteria andAttWifiSsidLike(String value) {
			addCriterion("ATT_WIFI_SSID like", value, "attWifiSsid");
			return (Criteria) this;
		}

		public Criteria andAttWifiSsidNotLike(String value) {
			addCriterion("ATT_WIFI_SSID not like", value, "attWifiSsid");
			return (Criteria) this;
		}

		public Criteria andAttWifiSsidIn(List<String> values) {
			addCriterion("ATT_WIFI_SSID in", values, "attWifiSsid");
			return (Criteria) this;
		}

		public Criteria andAttWifiSsidNotIn(List<String> values) {
			addCriterion("ATT_WIFI_SSID not in", values, "attWifiSsid");
			return (Criteria) this;
		}

		public Criteria andAttWifiSsidBetween(String value1, String value2) {
			addCriterion("ATT_WIFI_SSID between", value1, value2, "attWifiSsid");
			return (Criteria) this;
		}

		public Criteria andAttWifiSsidNotBetween(String value1, String value2) {
			addCriterion("ATT_WIFI_SSID not between", value1, value2, "attWifiSsid");
			return (Criteria) this;
		}

		public Criteria andAttWifiMacIsNull() {
			addCriterion("ATT_WIFI_MAC is null");
			return (Criteria) this;
		}

		public Criteria andAttWifiMacIsNotNull() {
			addCriterion("ATT_WIFI_MAC is not null");
			return (Criteria) this;
		}

		public Criteria andAttWifiMacEqualTo(String value) {
			addCriterion("ATT_WIFI_MAC =", value, "attWifiMac");
			return (Criteria) this;
		}

		public Criteria andAttWifiMacNotEqualTo(String value) {
			addCriterion("ATT_WIFI_MAC <>", value, "attWifiMac");
			return (Criteria) this;
		}

		public Criteria andAttWifiMacGreaterThan(String value) {
			addCriterion("ATT_WIFI_MAC >", value, "attWifiMac");
			return (Criteria) this;
		}

		public Criteria andAttWifiMacGreaterThanOrEqualTo(String value) {
			addCriterion("ATT_WIFI_MAC >=", value, "attWifiMac");
			return (Criteria) this;
		}

		public Criteria andAttWifiMacLessThan(String value) {
			addCriterion("ATT_WIFI_MAC <", value, "attWifiMac");
			return (Criteria) this;
		}

		public Criteria andAttWifiMacLessThanOrEqualTo(String value) {
			addCriterion("ATT_WIFI_MAC <=", value, "attWifiMac");
			return (Criteria) this;
		}

		public Criteria andAttWifiMacLike(String value) {
			addCriterion("ATT_WIFI_MAC like", value, "attWifiMac");
			return (Criteria) this;
		}

		public Criteria andAttWifiMacNotLike(String value) {
			addCriterion("ATT_WIFI_MAC not like", value, "attWifiMac");
			return (Criteria) this;
		}

		public Criteria andAttWifiMacIn(List<String> values) {
			addCriterion("ATT_WIFI_MAC in", values, "attWifiMac");
			return (Criteria) this;
		}

		public Criteria andAttWifiMacNotIn(List<String> values) {
			addCriterion("ATT_WIFI_MAC not in", values, "attWifiMac");
			return (Criteria) this;
		}

		public Criteria andAttWifiMacBetween(String value1, String value2) {
			addCriterion("ATT_WIFI_MAC between", value1, value2, "attWifiMac");
			return (Criteria) this;
		}

		public Criteria andAttWifiMacNotBetween(String value1, String value2) {
			addCriterion("ATT_WIFI_MAC not between", value1, value2, "attWifiMac");
			return (Criteria) this;
		}

		public Criteria andActualLocationDescIsNull() {
			addCriterion("ACTUAL_LOCATION_DESC is null");
			return (Criteria) this;
		}

		public Criteria andActualLocationDescIsNotNull() {
			addCriterion("ACTUAL_LOCATION_DESC is not null");
			return (Criteria) this;
		}

		public Criteria andActualLocationDescEqualTo(String value) {
			addCriterion("ACTUAL_LOCATION_DESC =", value, "actualLocationDesc");
			return (Criteria) this;
		}

		public Criteria andActualLocationDescNotEqualTo(String value) {
			addCriterion("ACTUAL_LOCATION_DESC <>", value, "actualLocationDesc");
			return (Criteria) this;
		}

		public Criteria andActualLocationDescGreaterThan(String value) {
			addCriterion("ACTUAL_LOCATION_DESC >", value, "actualLocationDesc");
			return (Criteria) this;
		}

		public Criteria andActualLocationDescGreaterThanOrEqualTo(String value) {
			addCriterion("ACTUAL_LOCATION_DESC >=", value, "actualLocationDesc");
			return (Criteria) this;
		}

		public Criteria andActualLocationDescLessThan(String value) {
			addCriterion("ACTUAL_LOCATION_DESC <", value, "actualLocationDesc");
			return (Criteria) this;
		}

		public Criteria andActualLocationDescLessThanOrEqualTo(String value) {
			addCriterion("ACTUAL_LOCATION_DESC <=", value, "actualLocationDesc");
			return (Criteria) this;
		}

		public Criteria andActualLocationDescLike(String value) {
			addCriterion("ACTUAL_LOCATION_DESC like", value, "actualLocationDesc");
			return (Criteria) this;
		}

		public Criteria andActualLocationDescNotLike(String value) {
			addCriterion("ACTUAL_LOCATION_DESC not like", value, "actualLocationDesc");
			return (Criteria) this;
		}

		public Criteria andActualLocationDescIn(List<String> values) {
			addCriterion("ACTUAL_LOCATION_DESC in", values, "actualLocationDesc");
			return (Criteria) this;
		}

		public Criteria andActualLocationDescNotIn(List<String> values) {
			addCriterion("ACTUAL_LOCATION_DESC not in", values, "actualLocationDesc");
			return (Criteria) this;
		}

		public Criteria andActualLocationDescBetween(String value1, String value2) {
			addCriterion("ACTUAL_LOCATION_DESC between", value1, value2, "actualLocationDesc");
			return (Criteria) this;
		}

		public Criteria andActualLocationDescNotBetween(String value1, String value2) {
			addCriterion("ACTUAL_LOCATION_DESC not between", value1, value2, "actualLocationDesc");
			return (Criteria) this;
		}

		public Criteria andEditDateIsNull() {
			addCriterion("EDIT_DATE is null");
			return (Criteria) this;
		}

		public Criteria andEditDateIsNotNull() {
			addCriterion("EDIT_DATE is not null");
			return (Criteria) this;
		}

		public Criteria andEditDateEqualTo(Date value) {
			addCriterion("EDIT_DATE =", value, "editDate");
			return (Criteria) this;
		}

		public Criteria andEditDateNotEqualTo(Date value) {
			addCriterion("EDIT_DATE <>", value, "editDate");
			return (Criteria) this;
		}

		public Criteria andEditDateGreaterThan(Date value) {
			addCriterion("EDIT_DATE >", value, "editDate");
			return (Criteria) this;
		}

		public Criteria andEditDateGreaterThanOrEqualTo(Date value) {
			addCriterion("EDIT_DATE >=", value, "editDate");
			return (Criteria) this;
		}

		public Criteria andEditDateLessThan(Date value) {
			addCriterion("EDIT_DATE <", value, "editDate");
			return (Criteria) this;
		}

		public Criteria andEditDateLessThanOrEqualTo(Date value) {
			addCriterion("EDIT_DATE <=", value, "editDate");
			return (Criteria) this;
		}

		public Criteria andEditDateIn(List<Date> values) {
			addCriterion("EDIT_DATE in", values, "editDate");
			return (Criteria) this;
		}

		public Criteria andEditDateNotIn(List<Date> values) {
			addCriterion("EDIT_DATE not in", values, "editDate");
			return (Criteria) this;
		}

		public Criteria andEditDateBetween(Date value1, Date value2) {
			addCriterion("EDIT_DATE between", value1, value2, "editDate");
			return (Criteria) this;
		}

		public Criteria andEditDateNotBetween(Date value1, Date value2) {
			addCriterion("EDIT_DATE not between", value1, value2, "editDate");
			return (Criteria) this;
		}

		public Criteria andAuditIdIsNull() {
			addCriterion("AUDIT_ID is null");
			return (Criteria) this;
		}

		public Criteria andAuditIdIsNotNull() {
			addCriterion("AUDIT_ID is not null");
			return (Criteria) this;
		}

		public Criteria andAuditIdEqualTo(Integer value) {
			addCriterion("AUDIT_ID =", value, "auditId");
			return (Criteria) this;
		}

		public Criteria andAuditIdNotEqualTo(Integer value) {
			addCriterion("AUDIT_ID <>", value, "auditId");
			return (Criteria) this;
		}

		public Criteria andAuditIdGreaterThan(Integer value) {
			addCriterion("AUDIT_ID >", value, "auditId");
			return (Criteria) this;
		}

		public Criteria andAuditIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("AUDIT_ID >=", value, "auditId");
			return (Criteria) this;
		}

		public Criteria andAuditIdLessThan(Integer value) {
			addCriterion("AUDIT_ID <", value, "auditId");
			return (Criteria) this;
		}

		public Criteria andAuditIdLessThanOrEqualTo(Integer value) {
			addCriterion("AUDIT_ID <=", value, "auditId");
			return (Criteria) this;
		}

		public Criteria andAuditIdIn(List<Integer> values) {
			addCriterion("AUDIT_ID in", values, "auditId");
			return (Criteria) this;
		}

		public Criteria andAuditIdNotIn(List<Integer> values) {
			addCriterion("AUDIT_ID not in", values, "auditId");
			return (Criteria) this;
		}

		public Criteria andAuditIdBetween(Integer value1, Integer value2) {
			addCriterion("AUDIT_ID between", value1, value2, "auditId");
			return (Criteria) this;
		}

		public Criteria andAuditIdNotBetween(Integer value1, Integer value2) {
			addCriterion("AUDIT_ID not between", value1, value2, "auditId");
			return (Criteria) this;
		}

		public Criteria andLeaveAuditNameIsNull() {
			addCriterion("LEAVE_AUDIT_NAME is null");
			return (Criteria) this;
		}

		public Criteria andLeaveAuditNameIsNotNull() {
			addCriterion("LEAVE_AUDIT_NAME is not null");
			return (Criteria) this;
		}

		public Criteria andLeaveAuditNameEqualTo(String value) {
			addCriterion("LEAVE_AUDIT_NAME =", value, "leaveAuditName");
			return (Criteria) this;
		}

		public Criteria andLeaveAuditNameNotEqualTo(String value) {
			addCriterion("LEAVE_AUDIT_NAME <>", value, "leaveAuditName");
			return (Criteria) this;
		}

		public Criteria andLeaveAuditNameGreaterThan(String value) {
			addCriterion("LEAVE_AUDIT_NAME >", value, "leaveAuditName");
			return (Criteria) this;
		}

		public Criteria andLeaveAuditNameGreaterThanOrEqualTo(String value) {
			addCriterion("LEAVE_AUDIT_NAME >=", value, "leaveAuditName");
			return (Criteria) this;
		}

		public Criteria andLeaveAuditNameLessThan(String value) {
			addCriterion("LEAVE_AUDIT_NAME <", value, "leaveAuditName");
			return (Criteria) this;
		}

		public Criteria andLeaveAuditNameLessThanOrEqualTo(String value) {
			addCriterion("LEAVE_AUDIT_NAME <=", value, "leaveAuditName");
			return (Criteria) this;
		}

		public Criteria andLeaveAuditNameLike(String value) {
			addCriterion("LEAVE_AUDIT_NAME like", value, "leaveAuditName");
			return (Criteria) this;
		}

		public Criteria andLeaveAuditNameNotLike(String value) {
			addCriterion("LEAVE_AUDIT_NAME not like", value, "leaveAuditName");
			return (Criteria) this;
		}

		public Criteria andLeaveAuditNameIn(List<String> values) {
			addCriterion("LEAVE_AUDIT_NAME in", values, "leaveAuditName");
			return (Criteria) this;
		}

		public Criteria andLeaveAuditNameNotIn(List<String> values) {
			addCriterion("LEAVE_AUDIT_NAME not in", values, "leaveAuditName");
			return (Criteria) this;
		}

		public Criteria andLeaveAuditNameBetween(String value1, String value2) {
			addCriterion("LEAVE_AUDIT_NAME between", value1, value2, "leaveAuditName");
			return (Criteria) this;
		}

		public Criteria andLeaveAuditNameNotBetween(String value1, String value2) {
			addCriterion("LEAVE_AUDIT_NAME not between", value1, value2, "leaveAuditName");
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