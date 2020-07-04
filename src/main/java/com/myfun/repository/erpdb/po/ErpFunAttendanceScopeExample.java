package com.myfun.repository.erpdb.po;

import com.myfun.repository.support.generator.shard.ShardDb;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ErpFunAttendanceScopeExample extends ShardDb {
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
	public ErpFunAttendanceScopeExample() {
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

		public Criteria andAttScopeXIsNull() {
			addCriterion("ATT_SCOPE_X is null");
			return (Criteria) this;
		}

		public Criteria andAttScopeXIsNotNull() {
			addCriterion("ATT_SCOPE_X is not null");
			return (Criteria) this;
		}

		public Criteria andAttScopeXEqualTo(String value) {
			addCriterion("ATT_SCOPE_X =", value, "attScopeX");
			return (Criteria) this;
		}

		public Criteria andAttScopeXNotEqualTo(String value) {
			addCriterion("ATT_SCOPE_X <>", value, "attScopeX");
			return (Criteria) this;
		}

		public Criteria andAttScopeXGreaterThan(String value) {
			addCriterion("ATT_SCOPE_X >", value, "attScopeX");
			return (Criteria) this;
		}

		public Criteria andAttScopeXGreaterThanOrEqualTo(String value) {
			addCriterion("ATT_SCOPE_X >=", value, "attScopeX");
			return (Criteria) this;
		}

		public Criteria andAttScopeXLessThan(String value) {
			addCriterion("ATT_SCOPE_X <", value, "attScopeX");
			return (Criteria) this;
		}

		public Criteria andAttScopeXLessThanOrEqualTo(String value) {
			addCriterion("ATT_SCOPE_X <=", value, "attScopeX");
			return (Criteria) this;
		}

		public Criteria andAttScopeXLike(String value) {
			addCriterion("ATT_SCOPE_X like", value, "attScopeX");
			return (Criteria) this;
		}

		public Criteria andAttScopeXNotLike(String value) {
			addCriterion("ATT_SCOPE_X not like", value, "attScopeX");
			return (Criteria) this;
		}

		public Criteria andAttScopeXIn(List<String> values) {
			addCriterion("ATT_SCOPE_X in", values, "attScopeX");
			return (Criteria) this;
		}

		public Criteria andAttScopeXNotIn(List<String> values) {
			addCriterion("ATT_SCOPE_X not in", values, "attScopeX");
			return (Criteria) this;
		}

		public Criteria andAttScopeXBetween(String value1, String value2) {
			addCriterion("ATT_SCOPE_X between", value1, value2, "attScopeX");
			return (Criteria) this;
		}

		public Criteria andAttScopeXNotBetween(String value1, String value2) {
			addCriterion("ATT_SCOPE_X not between", value1, value2, "attScopeX");
			return (Criteria) this;
		}

		public Criteria andAttScopeYIsNull() {
			addCriterion("ATT_SCOPE_Y is null");
			return (Criteria) this;
		}

		public Criteria andAttScopeYIsNotNull() {
			addCriterion("ATT_SCOPE_Y is not null");
			return (Criteria) this;
		}

		public Criteria andAttScopeYEqualTo(String value) {
			addCriterion("ATT_SCOPE_Y =", value, "attScopeY");
			return (Criteria) this;
		}

		public Criteria andAttScopeYNotEqualTo(String value) {
			addCriterion("ATT_SCOPE_Y <>", value, "attScopeY");
			return (Criteria) this;
		}

		public Criteria andAttScopeYGreaterThan(String value) {
			addCriterion("ATT_SCOPE_Y >", value, "attScopeY");
			return (Criteria) this;
		}

		public Criteria andAttScopeYGreaterThanOrEqualTo(String value) {
			addCriterion("ATT_SCOPE_Y >=", value, "attScopeY");
			return (Criteria) this;
		}

		public Criteria andAttScopeYLessThan(String value) {
			addCriterion("ATT_SCOPE_Y <", value, "attScopeY");
			return (Criteria) this;
		}

		public Criteria andAttScopeYLessThanOrEqualTo(String value) {
			addCriterion("ATT_SCOPE_Y <=", value, "attScopeY");
			return (Criteria) this;
		}

		public Criteria andAttScopeYLike(String value) {
			addCriterion("ATT_SCOPE_Y like", value, "attScopeY");
			return (Criteria) this;
		}

		public Criteria andAttScopeYNotLike(String value) {
			addCriterion("ATT_SCOPE_Y not like", value, "attScopeY");
			return (Criteria) this;
		}

		public Criteria andAttScopeYIn(List<String> values) {
			addCriterion("ATT_SCOPE_Y in", values, "attScopeY");
			return (Criteria) this;
		}

		public Criteria andAttScopeYNotIn(List<String> values) {
			addCriterion("ATT_SCOPE_Y not in", values, "attScopeY");
			return (Criteria) this;
		}

		public Criteria andAttScopeYBetween(String value1, String value2) {
			addCriterion("ATT_SCOPE_Y between", value1, value2, "attScopeY");
			return (Criteria) this;
		}

		public Criteria andAttScopeYNotBetween(String value1, String value2) {
			addCriterion("ATT_SCOPE_Y not between", value1, value2, "attScopeY");
			return (Criteria) this;
		}

		public Criteria andAttDistanceIsNull() {
			addCriterion("ATT_DISTANCE is null");
			return (Criteria) this;
		}

		public Criteria andAttDistanceIsNotNull() {
			addCriterion("ATT_DISTANCE is not null");
			return (Criteria) this;
		}

		public Criteria andAttDistanceEqualTo(Integer value) {
			addCriterion("ATT_DISTANCE =", value, "attDistance");
			return (Criteria) this;
		}

		public Criteria andAttDistanceNotEqualTo(Integer value) {
			addCriterion("ATT_DISTANCE <>", value, "attDistance");
			return (Criteria) this;
		}

		public Criteria andAttDistanceGreaterThan(Integer value) {
			addCriterion("ATT_DISTANCE >", value, "attDistance");
			return (Criteria) this;
		}

		public Criteria andAttDistanceGreaterThanOrEqualTo(Integer value) {
			addCriterion("ATT_DISTANCE >=", value, "attDistance");
			return (Criteria) this;
		}

		public Criteria andAttDistanceLessThan(Integer value) {
			addCriterion("ATT_DISTANCE <", value, "attDistance");
			return (Criteria) this;
		}

		public Criteria andAttDistanceLessThanOrEqualTo(Integer value) {
			addCriterion("ATT_DISTANCE <=", value, "attDistance");
			return (Criteria) this;
		}

		public Criteria andAttDistanceIn(List<Integer> values) {
			addCriterion("ATT_DISTANCE in", values, "attDistance");
			return (Criteria) this;
		}

		public Criteria andAttDistanceNotIn(List<Integer> values) {
			addCriterion("ATT_DISTANCE not in", values, "attDistance");
			return (Criteria) this;
		}

		public Criteria andAttDistanceBetween(Integer value1, Integer value2) {
			addCriterion("ATT_DISTANCE between", value1, value2, "attDistance");
			return (Criteria) this;
		}

		public Criteria andAttDistanceNotBetween(Integer value1, Integer value2) {
			addCriterion("ATT_DISTANCE not between", value1, value2, "attDistance");
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

		public Criteria andLocationDescAbbIsNull() {
			addCriterion("LOCATION_DESC_ABB is null");
			return (Criteria) this;
		}

		public Criteria andLocationDescAbbIsNotNull() {
			addCriterion("LOCATION_DESC_ABB is not null");
			return (Criteria) this;
		}

		public Criteria andLocationDescAbbEqualTo(String value) {
			addCriterion("LOCATION_DESC_ABB =", value, "locationDescAbb");
			return (Criteria) this;
		}

		public Criteria andLocationDescAbbNotEqualTo(String value) {
			addCriterion("LOCATION_DESC_ABB <>", value, "locationDescAbb");
			return (Criteria) this;
		}

		public Criteria andLocationDescAbbGreaterThan(String value) {
			addCriterion("LOCATION_DESC_ABB >", value, "locationDescAbb");
			return (Criteria) this;
		}

		public Criteria andLocationDescAbbGreaterThanOrEqualTo(String value) {
			addCriterion("LOCATION_DESC_ABB >=", value, "locationDescAbb");
			return (Criteria) this;
		}

		public Criteria andLocationDescAbbLessThan(String value) {
			addCriterion("LOCATION_DESC_ABB <", value, "locationDescAbb");
			return (Criteria) this;
		}

		public Criteria andLocationDescAbbLessThanOrEqualTo(String value) {
			addCriterion("LOCATION_DESC_ABB <=", value, "locationDescAbb");
			return (Criteria) this;
		}

		public Criteria andLocationDescAbbLike(String value) {
			addCriterion("LOCATION_DESC_ABB like", value, "locationDescAbb");
			return (Criteria) this;
		}

		public Criteria andLocationDescAbbNotLike(String value) {
			addCriterion("LOCATION_DESC_ABB not like", value, "locationDescAbb");
			return (Criteria) this;
		}

		public Criteria andLocationDescAbbIn(List<String> values) {
			addCriterion("LOCATION_DESC_ABB in", values, "locationDescAbb");
			return (Criteria) this;
		}

		public Criteria andLocationDescAbbNotIn(List<String> values) {
			addCriterion("LOCATION_DESC_ABB not in", values, "locationDescAbb");
			return (Criteria) this;
		}

		public Criteria andLocationDescAbbBetween(String value1, String value2) {
			addCriterion("LOCATION_DESC_ABB between", value1, value2, "locationDescAbb");
			return (Criteria) this;
		}

		public Criteria andLocationDescAbbNotBetween(String value1, String value2) {
			addCriterion("LOCATION_DESC_ABB not between", value1, value2, "locationDescAbb");
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

		public Criteria andCalDelIsNull() {
			addCriterion("CAL_DEL is null");
			return (Criteria) this;
		}

		public Criteria andCalDelIsNotNull() {
			addCriterion("CAL_DEL is not null");
			return (Criteria) this;
		}

		public Criteria andCalDelEqualTo(Byte value) {
			addCriterion("CAL_DEL =", value, "calDel");
			return (Criteria) this;
		}

		public Criteria andCalDelNotEqualTo(Byte value) {
			addCriterion("CAL_DEL <>", value, "calDel");
			return (Criteria) this;
		}

		public Criteria andCalDelGreaterThan(Byte value) {
			addCriterion("CAL_DEL >", value, "calDel");
			return (Criteria) this;
		}

		public Criteria andCalDelGreaterThanOrEqualTo(Byte value) {
			addCriterion("CAL_DEL >=", value, "calDel");
			return (Criteria) this;
		}

		public Criteria andCalDelLessThan(Byte value) {
			addCriterion("CAL_DEL <", value, "calDel");
			return (Criteria) this;
		}

		public Criteria andCalDelLessThanOrEqualTo(Byte value) {
			addCriterion("CAL_DEL <=", value, "calDel");
			return (Criteria) this;
		}

		public Criteria andCalDelIn(List<Byte> values) {
			addCriterion("CAL_DEL in", values, "calDel");
			return (Criteria) this;
		}

		public Criteria andCalDelNotIn(List<Byte> values) {
			addCriterion("CAL_DEL not in", values, "calDel");
			return (Criteria) this;
		}

		public Criteria andCalDelBetween(Byte value1, Byte value2) {
			addCriterion("CAL_DEL between", value1, value2, "calDel");
			return (Criteria) this;
		}

		public Criteria andCalDelNotBetween(Byte value1, Byte value2) {
			addCriterion("CAL_DEL not between", value1, value2, "calDel");
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