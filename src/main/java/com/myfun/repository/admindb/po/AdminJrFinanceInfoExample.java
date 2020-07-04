package com.myfun.repository.admindb.po;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AdminJrFinanceInfoExample {
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
	public AdminJrFinanceInfoExample() {
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

		public Criteria andRightAddrIsNull() {
			addCriterion("RIGHT_ADDR is null");
			return (Criteria) this;
		}

		public Criteria andRightAddrIsNotNull() {
			addCriterion("RIGHT_ADDR is not null");
			return (Criteria) this;
		}

		public Criteria andRightAddrEqualTo(String value) {
			addCriterion("RIGHT_ADDR =", value, "rightAddr");
			return (Criteria) this;
		}

		public Criteria andRightAddrNotEqualTo(String value) {
			addCriterion("RIGHT_ADDR <>", value, "rightAddr");
			return (Criteria) this;
		}

		public Criteria andRightAddrGreaterThan(String value) {
			addCriterion("RIGHT_ADDR >", value, "rightAddr");
			return (Criteria) this;
		}

		public Criteria andRightAddrGreaterThanOrEqualTo(String value) {
			addCriterion("RIGHT_ADDR >=", value, "rightAddr");
			return (Criteria) this;
		}

		public Criteria andRightAddrLessThan(String value) {
			addCriterion("RIGHT_ADDR <", value, "rightAddr");
			return (Criteria) this;
		}

		public Criteria andRightAddrLessThanOrEqualTo(String value) {
			addCriterion("RIGHT_ADDR <=", value, "rightAddr");
			return (Criteria) this;
		}

		public Criteria andRightAddrLike(String value) {
			addCriterion("RIGHT_ADDR like", value, "rightAddr");
			return (Criteria) this;
		}

		public Criteria andRightAddrNotLike(String value) {
			addCriterion("RIGHT_ADDR not like", value, "rightAddr");
			return (Criteria) this;
		}

		public Criteria andRightAddrIn(List<String> values) {
			addCriterion("RIGHT_ADDR in", values, "rightAddr");
			return (Criteria) this;
		}

		public Criteria andRightAddrNotIn(List<String> values) {
			addCriterion("RIGHT_ADDR not in", values, "rightAddr");
			return (Criteria) this;
		}

		public Criteria andRightAddrBetween(String value1, String value2) {
			addCriterion("RIGHT_ADDR between", value1, value2, "rightAddr");
			return (Criteria) this;
		}

		public Criteria andRightAddrNotBetween(String value1, String value2) {
			addCriterion("RIGHT_ADDR not between", value1, value2, "rightAddr");
			return (Criteria) this;
		}

		public Criteria andRightNumIsNull() {
			addCriterion("RIGHT_NUM is null");
			return (Criteria) this;
		}

		public Criteria andRightNumIsNotNull() {
			addCriterion("RIGHT_NUM is not null");
			return (Criteria) this;
		}

		public Criteria andRightNumEqualTo(String value) {
			addCriterion("RIGHT_NUM =", value, "rightNum");
			return (Criteria) this;
		}

		public Criteria andRightNumNotEqualTo(String value) {
			addCriterion("RIGHT_NUM <>", value, "rightNum");
			return (Criteria) this;
		}

		public Criteria andRightNumGreaterThan(String value) {
			addCriterion("RIGHT_NUM >", value, "rightNum");
			return (Criteria) this;
		}

		public Criteria andRightNumGreaterThanOrEqualTo(String value) {
			addCriterion("RIGHT_NUM >=", value, "rightNum");
			return (Criteria) this;
		}

		public Criteria andRightNumLessThan(String value) {
			addCriterion("RIGHT_NUM <", value, "rightNum");
			return (Criteria) this;
		}

		public Criteria andRightNumLessThanOrEqualTo(String value) {
			addCriterion("RIGHT_NUM <=", value, "rightNum");
			return (Criteria) this;
		}

		public Criteria andRightNumLike(String value) {
			addCriterion("RIGHT_NUM like", value, "rightNum");
			return (Criteria) this;
		}

		public Criteria andRightNumNotLike(String value) {
			addCriterion("RIGHT_NUM not like", value, "rightNum");
			return (Criteria) this;
		}

		public Criteria andRightNumIn(List<String> values) {
			addCriterion("RIGHT_NUM in", values, "rightNum");
			return (Criteria) this;
		}

		public Criteria andRightNumNotIn(List<String> values) {
			addCriterion("RIGHT_NUM not in", values, "rightNum");
			return (Criteria) this;
		}

		public Criteria andRightNumBetween(String value1, String value2) {
			addCriterion("RIGHT_NUM between", value1, value2, "rightNum");
			return (Criteria) this;
		}

		public Criteria andRightNumNotBetween(String value1, String value2) {
			addCriterion("RIGHT_NUM not between", value1, value2, "rightNum");
			return (Criteria) this;
		}

		public Criteria andAreaIsNull() {
			addCriterion("AREA is null");
			return (Criteria) this;
		}

		public Criteria andAreaIsNotNull() {
			addCriterion("AREA is not null");
			return (Criteria) this;
		}

		public Criteria andAreaEqualTo(BigDecimal value) {
			addCriterion("AREA =", value, "area");
			return (Criteria) this;
		}

		public Criteria andAreaNotEqualTo(BigDecimal value) {
			addCriterion("AREA <>", value, "area");
			return (Criteria) this;
		}

		public Criteria andAreaGreaterThan(BigDecimal value) {
			addCriterion("AREA >", value, "area");
			return (Criteria) this;
		}

		public Criteria andAreaGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("AREA >=", value, "area");
			return (Criteria) this;
		}

		public Criteria andAreaLessThan(BigDecimal value) {
			addCriterion("AREA <", value, "area");
			return (Criteria) this;
		}

		public Criteria andAreaLessThanOrEqualTo(BigDecimal value) {
			addCriterion("AREA <=", value, "area");
			return (Criteria) this;
		}

		public Criteria andAreaIn(List<BigDecimal> values) {
			addCriterion("AREA in", values, "area");
			return (Criteria) this;
		}

		public Criteria andAreaNotIn(List<BigDecimal> values) {
			addCriterion("AREA not in", values, "area");
			return (Criteria) this;
		}

		public Criteria andAreaBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("AREA between", value1, value2, "area");
			return (Criteria) this;
		}

		public Criteria andAreaNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("AREA not between", value1, value2, "area");
			return (Criteria) this;
		}

		public Criteria andUseageIsNull() {
			addCriterion("USEAGE is null");
			return (Criteria) this;
		}

		public Criteria andUseageIsNotNull() {
			addCriterion("USEAGE is not null");
			return (Criteria) this;
		}

		public Criteria andUseageEqualTo(Byte value) {
			addCriterion("USEAGE =", value, "useage");
			return (Criteria) this;
		}

		public Criteria andUseageNotEqualTo(Byte value) {
			addCriterion("USEAGE <>", value, "useage");
			return (Criteria) this;
		}

		public Criteria andUseageGreaterThan(Byte value) {
			addCriterion("USEAGE >", value, "useage");
			return (Criteria) this;
		}

		public Criteria andUseageGreaterThanOrEqualTo(Byte value) {
			addCriterion("USEAGE >=", value, "useage");
			return (Criteria) this;
		}

		public Criteria andUseageLessThan(Byte value) {
			addCriterion("USEAGE <", value, "useage");
			return (Criteria) this;
		}

		public Criteria andUseageLessThanOrEqualTo(Byte value) {
			addCriterion("USEAGE <=", value, "useage");
			return (Criteria) this;
		}

		public Criteria andUseageIn(List<Byte> values) {
			addCriterion("USEAGE in", values, "useage");
			return (Criteria) this;
		}

		public Criteria andUseageNotIn(List<Byte> values) {
			addCriterion("USEAGE not in", values, "useage");
			return (Criteria) this;
		}

		public Criteria andUseageBetween(Byte value1, Byte value2) {
			addCriterion("USEAGE between", value1, value2, "useage");
			return (Criteria) this;
		}

		public Criteria andUseageNotBetween(Byte value1, Byte value2) {
			addCriterion("USEAGE not between", value1, value2, "useage");
			return (Criteria) this;
		}

		public Criteria andHousePhoneIsNull() {
			addCriterion("HOUSE_PHONE is null");
			return (Criteria) this;
		}

		public Criteria andHousePhoneIsNotNull() {
			addCriterion("HOUSE_PHONE is not null");
			return (Criteria) this;
		}

		public Criteria andHousePhoneEqualTo(String value) {
			addCriterion("HOUSE_PHONE =", value, "housePhone");
			return (Criteria) this;
		}

		public Criteria andHousePhoneNotEqualTo(String value) {
			addCriterion("HOUSE_PHONE <>", value, "housePhone");
			return (Criteria) this;
		}

		public Criteria andHousePhoneGreaterThan(String value) {
			addCriterion("HOUSE_PHONE >", value, "housePhone");
			return (Criteria) this;
		}

		public Criteria andHousePhoneGreaterThanOrEqualTo(String value) {
			addCriterion("HOUSE_PHONE >=", value, "housePhone");
			return (Criteria) this;
		}

		public Criteria andHousePhoneLessThan(String value) {
			addCriterion("HOUSE_PHONE <", value, "housePhone");
			return (Criteria) this;
		}

		public Criteria andHousePhoneLessThanOrEqualTo(String value) {
			addCriterion("HOUSE_PHONE <=", value, "housePhone");
			return (Criteria) this;
		}

		public Criteria andHousePhoneLike(String value) {
			addCriterion("HOUSE_PHONE like", value, "housePhone");
			return (Criteria) this;
		}

		public Criteria andHousePhoneNotLike(String value) {
			addCriterion("HOUSE_PHONE not like", value, "housePhone");
			return (Criteria) this;
		}

		public Criteria andHousePhoneIn(List<String> values) {
			addCriterion("HOUSE_PHONE in", values, "housePhone");
			return (Criteria) this;
		}

		public Criteria andHousePhoneNotIn(List<String> values) {
			addCriterion("HOUSE_PHONE not in", values, "housePhone");
			return (Criteria) this;
		}

		public Criteria andHousePhoneBetween(String value1, String value2) {
			addCriterion("HOUSE_PHONE between", value1, value2, "housePhone");
			return (Criteria) this;
		}

		public Criteria andHousePhoneNotBetween(String value1, String value2) {
			addCriterion("HOUSE_PHONE not between", value1, value2, "housePhone");
			return (Criteria) this;
		}

		public Criteria andHouseDescIsNull() {
			addCriterion("HOUSE_DESC is null");
			return (Criteria) this;
		}

		public Criteria andHouseDescIsNotNull() {
			addCriterion("HOUSE_DESC is not null");
			return (Criteria) this;
		}

		public Criteria andHouseDescEqualTo(String value) {
			addCriterion("HOUSE_DESC =", value, "houseDesc");
			return (Criteria) this;
		}

		public Criteria andHouseDescNotEqualTo(String value) {
			addCriterion("HOUSE_DESC <>", value, "houseDesc");
			return (Criteria) this;
		}

		public Criteria andHouseDescGreaterThan(String value) {
			addCriterion("HOUSE_DESC >", value, "houseDesc");
			return (Criteria) this;
		}

		public Criteria andHouseDescGreaterThanOrEqualTo(String value) {
			addCriterion("HOUSE_DESC >=", value, "houseDesc");
			return (Criteria) this;
		}

		public Criteria andHouseDescLessThan(String value) {
			addCriterion("HOUSE_DESC <", value, "houseDesc");
			return (Criteria) this;
		}

		public Criteria andHouseDescLessThanOrEqualTo(String value) {
			addCriterion("HOUSE_DESC <=", value, "houseDesc");
			return (Criteria) this;
		}

		public Criteria andHouseDescLike(String value) {
			addCriterion("HOUSE_DESC like", value, "houseDesc");
			return (Criteria) this;
		}

		public Criteria andHouseDescNotLike(String value) {
			addCriterion("HOUSE_DESC not like", value, "houseDesc");
			return (Criteria) this;
		}

		public Criteria andHouseDescIn(List<String> values) {
			addCriterion("HOUSE_DESC in", values, "houseDesc");
			return (Criteria) this;
		}

		public Criteria andHouseDescNotIn(List<String> values) {
			addCriterion("HOUSE_DESC not in", values, "houseDesc");
			return (Criteria) this;
		}

		public Criteria andHouseDescBetween(String value1, String value2) {
			addCriterion("HOUSE_DESC between", value1, value2, "houseDesc");
			return (Criteria) this;
		}

		public Criteria andHouseDescNotBetween(String value1, String value2) {
			addCriterion("HOUSE_DESC not between", value1, value2, "houseDesc");
			return (Criteria) this;
		}

		public Criteria andMainApplyNameIsNull() {
			addCriterion("MAIN_APPLY_NAME is null");
			return (Criteria) this;
		}

		public Criteria andMainApplyNameIsNotNull() {
			addCriterion("MAIN_APPLY_NAME is not null");
			return (Criteria) this;
		}

		public Criteria andMainApplyNameEqualTo(String value) {
			addCriterion("MAIN_APPLY_NAME =", value, "mainApplyName");
			return (Criteria) this;
		}

		public Criteria andMainApplyNameNotEqualTo(String value) {
			addCriterion("MAIN_APPLY_NAME <>", value, "mainApplyName");
			return (Criteria) this;
		}

		public Criteria andMainApplyNameGreaterThan(String value) {
			addCriterion("MAIN_APPLY_NAME >", value, "mainApplyName");
			return (Criteria) this;
		}

		public Criteria andMainApplyNameGreaterThanOrEqualTo(String value) {
			addCriterion("MAIN_APPLY_NAME >=", value, "mainApplyName");
			return (Criteria) this;
		}

		public Criteria andMainApplyNameLessThan(String value) {
			addCriterion("MAIN_APPLY_NAME <", value, "mainApplyName");
			return (Criteria) this;
		}

		public Criteria andMainApplyNameLessThanOrEqualTo(String value) {
			addCriterion("MAIN_APPLY_NAME <=", value, "mainApplyName");
			return (Criteria) this;
		}

		public Criteria andMainApplyNameLike(String value) {
			addCriterion("MAIN_APPLY_NAME like", value, "mainApplyName");
			return (Criteria) this;
		}

		public Criteria andMainApplyNameNotLike(String value) {
			addCriterion("MAIN_APPLY_NAME not like", value, "mainApplyName");
			return (Criteria) this;
		}

		public Criteria andMainApplyNameIn(List<String> values) {
			addCriterion("MAIN_APPLY_NAME in", values, "mainApplyName");
			return (Criteria) this;
		}

		public Criteria andMainApplyNameNotIn(List<String> values) {
			addCriterion("MAIN_APPLY_NAME not in", values, "mainApplyName");
			return (Criteria) this;
		}

		public Criteria andMainApplyNameBetween(String value1, String value2) {
			addCriterion("MAIN_APPLY_NAME between", value1, value2, "mainApplyName");
			return (Criteria) this;
		}

		public Criteria andMainApplyNameNotBetween(String value1, String value2) {
			addCriterion("MAIN_APPLY_NAME not between", value1, value2, "mainApplyName");
			return (Criteria) this;
		}

		public Criteria andMainApplyIdcardIsNull() {
			addCriterion("MAIN_APPLY_IDCARD is null");
			return (Criteria) this;
		}

		public Criteria andMainApplyIdcardIsNotNull() {
			addCriterion("MAIN_APPLY_IDCARD is not null");
			return (Criteria) this;
		}

		public Criteria andMainApplyIdcardEqualTo(String value) {
			addCriterion("MAIN_APPLY_IDCARD =", value, "mainApplyIdcard");
			return (Criteria) this;
		}

		public Criteria andMainApplyIdcardNotEqualTo(String value) {
			addCriterion("MAIN_APPLY_IDCARD <>", value, "mainApplyIdcard");
			return (Criteria) this;
		}

		public Criteria andMainApplyIdcardGreaterThan(String value) {
			addCriterion("MAIN_APPLY_IDCARD >", value, "mainApplyIdcard");
			return (Criteria) this;
		}

		public Criteria andMainApplyIdcardGreaterThanOrEqualTo(String value) {
			addCriterion("MAIN_APPLY_IDCARD >=", value, "mainApplyIdcard");
			return (Criteria) this;
		}

		public Criteria andMainApplyIdcardLessThan(String value) {
			addCriterion("MAIN_APPLY_IDCARD <", value, "mainApplyIdcard");
			return (Criteria) this;
		}

		public Criteria andMainApplyIdcardLessThanOrEqualTo(String value) {
			addCriterion("MAIN_APPLY_IDCARD <=", value, "mainApplyIdcard");
			return (Criteria) this;
		}

		public Criteria andMainApplyIdcardLike(String value) {
			addCriterion("MAIN_APPLY_IDCARD like", value, "mainApplyIdcard");
			return (Criteria) this;
		}

		public Criteria andMainApplyIdcardNotLike(String value) {
			addCriterion("MAIN_APPLY_IDCARD not like", value, "mainApplyIdcard");
			return (Criteria) this;
		}

		public Criteria andMainApplyIdcardIn(List<String> values) {
			addCriterion("MAIN_APPLY_IDCARD in", values, "mainApplyIdcard");
			return (Criteria) this;
		}

		public Criteria andMainApplyIdcardNotIn(List<String> values) {
			addCriterion("MAIN_APPLY_IDCARD not in", values, "mainApplyIdcard");
			return (Criteria) this;
		}

		public Criteria andMainApplyIdcardBetween(String value1, String value2) {
			addCriterion("MAIN_APPLY_IDCARD between", value1, value2, "mainApplyIdcard");
			return (Criteria) this;
		}

		public Criteria andMainApplyIdcardNotBetween(String value1, String value2) {
			addCriterion("MAIN_APPLY_IDCARD not between", value1, value2, "mainApplyIdcard");
			return (Criteria) this;
		}

		public Criteria andMainApplyPhoneIsNull() {
			addCriterion("MAIN_APPLY_PHONE is null");
			return (Criteria) this;
		}

		public Criteria andMainApplyPhoneIsNotNull() {
			addCriterion("MAIN_APPLY_PHONE is not null");
			return (Criteria) this;
		}

		public Criteria andMainApplyPhoneEqualTo(String value) {
			addCriterion("MAIN_APPLY_PHONE =", value, "mainApplyPhone");
			return (Criteria) this;
		}

		public Criteria andMainApplyPhoneNotEqualTo(String value) {
			addCriterion("MAIN_APPLY_PHONE <>", value, "mainApplyPhone");
			return (Criteria) this;
		}

		public Criteria andMainApplyPhoneGreaterThan(String value) {
			addCriterion("MAIN_APPLY_PHONE >", value, "mainApplyPhone");
			return (Criteria) this;
		}

		public Criteria andMainApplyPhoneGreaterThanOrEqualTo(String value) {
			addCriterion("MAIN_APPLY_PHONE >=", value, "mainApplyPhone");
			return (Criteria) this;
		}

		public Criteria andMainApplyPhoneLessThan(String value) {
			addCriterion("MAIN_APPLY_PHONE <", value, "mainApplyPhone");
			return (Criteria) this;
		}

		public Criteria andMainApplyPhoneLessThanOrEqualTo(String value) {
			addCriterion("MAIN_APPLY_PHONE <=", value, "mainApplyPhone");
			return (Criteria) this;
		}

		public Criteria andMainApplyPhoneLike(String value) {
			addCriterion("MAIN_APPLY_PHONE like", value, "mainApplyPhone");
			return (Criteria) this;
		}

		public Criteria andMainApplyPhoneNotLike(String value) {
			addCriterion("MAIN_APPLY_PHONE not like", value, "mainApplyPhone");
			return (Criteria) this;
		}

		public Criteria andMainApplyPhoneIn(List<String> values) {
			addCriterion("MAIN_APPLY_PHONE in", values, "mainApplyPhone");
			return (Criteria) this;
		}

		public Criteria andMainApplyPhoneNotIn(List<String> values) {
			addCriterion("MAIN_APPLY_PHONE not in", values, "mainApplyPhone");
			return (Criteria) this;
		}

		public Criteria andMainApplyPhoneBetween(String value1, String value2) {
			addCriterion("MAIN_APPLY_PHONE between", value1, value2, "mainApplyPhone");
			return (Criteria) this;
		}

		public Criteria andMainApplyPhoneNotBetween(String value1, String value2) {
			addCriterion("MAIN_APPLY_PHONE not between", value1, value2, "mainApplyPhone");
			return (Criteria) this;
		}

		public Criteria andMainMarryStatusIsNull() {
			addCriterion("MAIN_MARRY_STATUS is null");
			return (Criteria) this;
		}

		public Criteria andMainMarryStatusIsNotNull() {
			addCriterion("MAIN_MARRY_STATUS is not null");
			return (Criteria) this;
		}

		public Criteria andMainMarryStatusEqualTo(Byte value) {
			addCriterion("MAIN_MARRY_STATUS =", value, "mainMarryStatus");
			return (Criteria) this;
		}

		public Criteria andMainMarryStatusNotEqualTo(Byte value) {
			addCriterion("MAIN_MARRY_STATUS <>", value, "mainMarryStatus");
			return (Criteria) this;
		}

		public Criteria andMainMarryStatusGreaterThan(Byte value) {
			addCriterion("MAIN_MARRY_STATUS >", value, "mainMarryStatus");
			return (Criteria) this;
		}

		public Criteria andMainMarryStatusGreaterThanOrEqualTo(Byte value) {
			addCriterion("MAIN_MARRY_STATUS >=", value, "mainMarryStatus");
			return (Criteria) this;
		}

		public Criteria andMainMarryStatusLessThan(Byte value) {
			addCriterion("MAIN_MARRY_STATUS <", value, "mainMarryStatus");
			return (Criteria) this;
		}

		public Criteria andMainMarryStatusLessThanOrEqualTo(Byte value) {
			addCriterion("MAIN_MARRY_STATUS <=", value, "mainMarryStatus");
			return (Criteria) this;
		}

		public Criteria andMainMarryStatusIn(List<Byte> values) {
			addCriterion("MAIN_MARRY_STATUS in", values, "mainMarryStatus");
			return (Criteria) this;
		}

		public Criteria andMainMarryStatusNotIn(List<Byte> values) {
			addCriterion("MAIN_MARRY_STATUS not in", values, "mainMarryStatus");
			return (Criteria) this;
		}

		public Criteria andMainMarryStatusBetween(Byte value1, Byte value2) {
			addCriterion("MAIN_MARRY_STATUS between", value1, value2, "mainMarryStatus");
			return (Criteria) this;
		}

		public Criteria andMainMarryStatusNotBetween(Byte value1, Byte value2) {
			addCriterion("MAIN_MARRY_STATUS not between", value1, value2, "mainMarryStatus");
			return (Criteria) this;
		}

		public Criteria andMainOwnerHouseIsNull() {
			addCriterion("MAIN_OWNER_HOUSE is null");
			return (Criteria) this;
		}

		public Criteria andMainOwnerHouseIsNotNull() {
			addCriterion("MAIN_OWNER_HOUSE is not null");
			return (Criteria) this;
		}

		public Criteria andMainOwnerHouseEqualTo(Byte value) {
			addCriterion("MAIN_OWNER_HOUSE =", value, "mainOwnerHouse");
			return (Criteria) this;
		}

		public Criteria andMainOwnerHouseNotEqualTo(Byte value) {
			addCriterion("MAIN_OWNER_HOUSE <>", value, "mainOwnerHouse");
			return (Criteria) this;
		}

		public Criteria andMainOwnerHouseGreaterThan(Byte value) {
			addCriterion("MAIN_OWNER_HOUSE >", value, "mainOwnerHouse");
			return (Criteria) this;
		}

		public Criteria andMainOwnerHouseGreaterThanOrEqualTo(Byte value) {
			addCriterion("MAIN_OWNER_HOUSE >=", value, "mainOwnerHouse");
			return (Criteria) this;
		}

		public Criteria andMainOwnerHouseLessThan(Byte value) {
			addCriterion("MAIN_OWNER_HOUSE <", value, "mainOwnerHouse");
			return (Criteria) this;
		}

		public Criteria andMainOwnerHouseLessThanOrEqualTo(Byte value) {
			addCriterion("MAIN_OWNER_HOUSE <=", value, "mainOwnerHouse");
			return (Criteria) this;
		}

		public Criteria andMainOwnerHouseIn(List<Byte> values) {
			addCriterion("MAIN_OWNER_HOUSE in", values, "mainOwnerHouse");
			return (Criteria) this;
		}

		public Criteria andMainOwnerHouseNotIn(List<Byte> values) {
			addCriterion("MAIN_OWNER_HOUSE not in", values, "mainOwnerHouse");
			return (Criteria) this;
		}

		public Criteria andMainOwnerHouseBetween(Byte value1, Byte value2) {
			addCriterion("MAIN_OWNER_HOUSE between", value1, value2, "mainOwnerHouse");
			return (Criteria) this;
		}

		public Criteria andMainOwnerHouseNotBetween(Byte value1, Byte value2) {
			addCriterion("MAIN_OWNER_HOUSE not between", value1, value2, "mainOwnerHouse");
			return (Criteria) this;
		}

		public Criteria andMainCreditStatusIsNull() {
			addCriterion("MAIN_CREDIT_STATUS is null");
			return (Criteria) this;
		}

		public Criteria andMainCreditStatusIsNotNull() {
			addCriterion("MAIN_CREDIT_STATUS is not null");
			return (Criteria) this;
		}

		public Criteria andMainCreditStatusEqualTo(Byte value) {
			addCriterion("MAIN_CREDIT_STATUS =", value, "mainCreditStatus");
			return (Criteria) this;
		}

		public Criteria andMainCreditStatusNotEqualTo(Byte value) {
			addCriterion("MAIN_CREDIT_STATUS <>", value, "mainCreditStatus");
			return (Criteria) this;
		}

		public Criteria andMainCreditStatusGreaterThan(Byte value) {
			addCriterion("MAIN_CREDIT_STATUS >", value, "mainCreditStatus");
			return (Criteria) this;
		}

		public Criteria andMainCreditStatusGreaterThanOrEqualTo(Byte value) {
			addCriterion("MAIN_CREDIT_STATUS >=", value, "mainCreditStatus");
			return (Criteria) this;
		}

		public Criteria andMainCreditStatusLessThan(Byte value) {
			addCriterion("MAIN_CREDIT_STATUS <", value, "mainCreditStatus");
			return (Criteria) this;
		}

		public Criteria andMainCreditStatusLessThanOrEqualTo(Byte value) {
			addCriterion("MAIN_CREDIT_STATUS <=", value, "mainCreditStatus");
			return (Criteria) this;
		}

		public Criteria andMainCreditStatusIn(List<Byte> values) {
			addCriterion("MAIN_CREDIT_STATUS in", values, "mainCreditStatus");
			return (Criteria) this;
		}

		public Criteria andMainCreditStatusNotIn(List<Byte> values) {
			addCriterion("MAIN_CREDIT_STATUS not in", values, "mainCreditStatus");
			return (Criteria) this;
		}

		public Criteria andMainCreditStatusBetween(Byte value1, Byte value2) {
			addCriterion("MAIN_CREDIT_STATUS between", value1, value2, "mainCreditStatus");
			return (Criteria) this;
		}

		public Criteria andMainCreditStatusNotBetween(Byte value1, Byte value2) {
			addCriterion("MAIN_CREDIT_STATUS not between", value1, value2, "mainCreditStatus");
			return (Criteria) this;
		}

		public Criteria andMainWorkUnitIsNull() {
			addCriterion("MAIN_WORK_UNIT is null");
			return (Criteria) this;
		}

		public Criteria andMainWorkUnitIsNotNull() {
			addCriterion("MAIN_WORK_UNIT is not null");
			return (Criteria) this;
		}

		public Criteria andMainWorkUnitEqualTo(String value) {
			addCriterion("MAIN_WORK_UNIT =", value, "mainWorkUnit");
			return (Criteria) this;
		}

		public Criteria andMainWorkUnitNotEqualTo(String value) {
			addCriterion("MAIN_WORK_UNIT <>", value, "mainWorkUnit");
			return (Criteria) this;
		}

		public Criteria andMainWorkUnitGreaterThan(String value) {
			addCriterion("MAIN_WORK_UNIT >", value, "mainWorkUnit");
			return (Criteria) this;
		}

		public Criteria andMainWorkUnitGreaterThanOrEqualTo(String value) {
			addCriterion("MAIN_WORK_UNIT >=", value, "mainWorkUnit");
			return (Criteria) this;
		}

		public Criteria andMainWorkUnitLessThan(String value) {
			addCriterion("MAIN_WORK_UNIT <", value, "mainWorkUnit");
			return (Criteria) this;
		}

		public Criteria andMainWorkUnitLessThanOrEqualTo(String value) {
			addCriterion("MAIN_WORK_UNIT <=", value, "mainWorkUnit");
			return (Criteria) this;
		}

		public Criteria andMainWorkUnitLike(String value) {
			addCriterion("MAIN_WORK_UNIT like", value, "mainWorkUnit");
			return (Criteria) this;
		}

		public Criteria andMainWorkUnitNotLike(String value) {
			addCriterion("MAIN_WORK_UNIT not like", value, "mainWorkUnit");
			return (Criteria) this;
		}

		public Criteria andMainWorkUnitIn(List<String> values) {
			addCriterion("MAIN_WORK_UNIT in", values, "mainWorkUnit");
			return (Criteria) this;
		}

		public Criteria andMainWorkUnitNotIn(List<String> values) {
			addCriterion("MAIN_WORK_UNIT not in", values, "mainWorkUnit");
			return (Criteria) this;
		}

		public Criteria andMainWorkUnitBetween(String value1, String value2) {
			addCriterion("MAIN_WORK_UNIT between", value1, value2, "mainWorkUnit");
			return (Criteria) this;
		}

		public Criteria andMainWorkUnitNotBetween(String value1, String value2) {
			addCriterion("MAIN_WORK_UNIT not between", value1, value2, "mainWorkUnit");
			return (Criteria) this;
		}

		public Criteria andSecondApplyNameIsNull() {
			addCriterion("SECOND_APPLY_NAME is null");
			return (Criteria) this;
		}

		public Criteria andSecondApplyNameIsNotNull() {
			addCriterion("SECOND_APPLY_NAME is not null");
			return (Criteria) this;
		}

		public Criteria andSecondApplyNameEqualTo(String value) {
			addCriterion("SECOND_APPLY_NAME =", value, "secondApplyName");
			return (Criteria) this;
		}

		public Criteria andSecondApplyNameNotEqualTo(String value) {
			addCriterion("SECOND_APPLY_NAME <>", value, "secondApplyName");
			return (Criteria) this;
		}

		public Criteria andSecondApplyNameGreaterThan(String value) {
			addCriterion("SECOND_APPLY_NAME >", value, "secondApplyName");
			return (Criteria) this;
		}

		public Criteria andSecondApplyNameGreaterThanOrEqualTo(String value) {
			addCriterion("SECOND_APPLY_NAME >=", value, "secondApplyName");
			return (Criteria) this;
		}

		public Criteria andSecondApplyNameLessThan(String value) {
			addCriterion("SECOND_APPLY_NAME <", value, "secondApplyName");
			return (Criteria) this;
		}

		public Criteria andSecondApplyNameLessThanOrEqualTo(String value) {
			addCriterion("SECOND_APPLY_NAME <=", value, "secondApplyName");
			return (Criteria) this;
		}

		public Criteria andSecondApplyNameLike(String value) {
			addCriterion("SECOND_APPLY_NAME like", value, "secondApplyName");
			return (Criteria) this;
		}

		public Criteria andSecondApplyNameNotLike(String value) {
			addCriterion("SECOND_APPLY_NAME not like", value, "secondApplyName");
			return (Criteria) this;
		}

		public Criteria andSecondApplyNameIn(List<String> values) {
			addCriterion("SECOND_APPLY_NAME in", values, "secondApplyName");
			return (Criteria) this;
		}

		public Criteria andSecondApplyNameNotIn(List<String> values) {
			addCriterion("SECOND_APPLY_NAME not in", values, "secondApplyName");
			return (Criteria) this;
		}

		public Criteria andSecondApplyNameBetween(String value1, String value2) {
			addCriterion("SECOND_APPLY_NAME between", value1, value2, "secondApplyName");
			return (Criteria) this;
		}

		public Criteria andSecondApplyNameNotBetween(String value1, String value2) {
			addCriterion("SECOND_APPLY_NAME not between", value1, value2, "secondApplyName");
			return (Criteria) this;
		}

		public Criteria andSecondApplyIdcardIsNull() {
			addCriterion("SECOND_APPLY_IDCARD is null");
			return (Criteria) this;
		}

		public Criteria andSecondApplyIdcardIsNotNull() {
			addCriterion("SECOND_APPLY_IDCARD is not null");
			return (Criteria) this;
		}

		public Criteria andSecondApplyIdcardEqualTo(String value) {
			addCriterion("SECOND_APPLY_IDCARD =", value, "secondApplyIdcard");
			return (Criteria) this;
		}

		public Criteria andSecondApplyIdcardNotEqualTo(String value) {
			addCriterion("SECOND_APPLY_IDCARD <>", value, "secondApplyIdcard");
			return (Criteria) this;
		}

		public Criteria andSecondApplyIdcardGreaterThan(String value) {
			addCriterion("SECOND_APPLY_IDCARD >", value, "secondApplyIdcard");
			return (Criteria) this;
		}

		public Criteria andSecondApplyIdcardGreaterThanOrEqualTo(String value) {
			addCriterion("SECOND_APPLY_IDCARD >=", value, "secondApplyIdcard");
			return (Criteria) this;
		}

		public Criteria andSecondApplyIdcardLessThan(String value) {
			addCriterion("SECOND_APPLY_IDCARD <", value, "secondApplyIdcard");
			return (Criteria) this;
		}

		public Criteria andSecondApplyIdcardLessThanOrEqualTo(String value) {
			addCriterion("SECOND_APPLY_IDCARD <=", value, "secondApplyIdcard");
			return (Criteria) this;
		}

		public Criteria andSecondApplyIdcardLike(String value) {
			addCriterion("SECOND_APPLY_IDCARD like", value, "secondApplyIdcard");
			return (Criteria) this;
		}

		public Criteria andSecondApplyIdcardNotLike(String value) {
			addCriterion("SECOND_APPLY_IDCARD not like", value, "secondApplyIdcard");
			return (Criteria) this;
		}

		public Criteria andSecondApplyIdcardIn(List<String> values) {
			addCriterion("SECOND_APPLY_IDCARD in", values, "secondApplyIdcard");
			return (Criteria) this;
		}

		public Criteria andSecondApplyIdcardNotIn(List<String> values) {
			addCriterion("SECOND_APPLY_IDCARD not in", values, "secondApplyIdcard");
			return (Criteria) this;
		}

		public Criteria andSecondApplyIdcardBetween(String value1, String value2) {
			addCriterion("SECOND_APPLY_IDCARD between", value1, value2, "secondApplyIdcard");
			return (Criteria) this;
		}

		public Criteria andSecondApplyIdcardNotBetween(String value1, String value2) {
			addCriterion("SECOND_APPLY_IDCARD not between", value1, value2, "secondApplyIdcard");
			return (Criteria) this;
		}

		public Criteria andSecondApplyPhoneIsNull() {
			addCriterion("SECOND_APPLY_PHONE is null");
			return (Criteria) this;
		}

		public Criteria andSecondApplyPhoneIsNotNull() {
			addCriterion("SECOND_APPLY_PHONE is not null");
			return (Criteria) this;
		}

		public Criteria andSecondApplyPhoneEqualTo(String value) {
			addCriterion("SECOND_APPLY_PHONE =", value, "secondApplyPhone");
			return (Criteria) this;
		}

		public Criteria andSecondApplyPhoneNotEqualTo(String value) {
			addCriterion("SECOND_APPLY_PHONE <>", value, "secondApplyPhone");
			return (Criteria) this;
		}

		public Criteria andSecondApplyPhoneGreaterThan(String value) {
			addCriterion("SECOND_APPLY_PHONE >", value, "secondApplyPhone");
			return (Criteria) this;
		}

		public Criteria andSecondApplyPhoneGreaterThanOrEqualTo(String value) {
			addCriterion("SECOND_APPLY_PHONE >=", value, "secondApplyPhone");
			return (Criteria) this;
		}

		public Criteria andSecondApplyPhoneLessThan(String value) {
			addCriterion("SECOND_APPLY_PHONE <", value, "secondApplyPhone");
			return (Criteria) this;
		}

		public Criteria andSecondApplyPhoneLessThanOrEqualTo(String value) {
			addCriterion("SECOND_APPLY_PHONE <=", value, "secondApplyPhone");
			return (Criteria) this;
		}

		public Criteria andSecondApplyPhoneLike(String value) {
			addCriterion("SECOND_APPLY_PHONE like", value, "secondApplyPhone");
			return (Criteria) this;
		}

		public Criteria andSecondApplyPhoneNotLike(String value) {
			addCriterion("SECOND_APPLY_PHONE not like", value, "secondApplyPhone");
			return (Criteria) this;
		}

		public Criteria andSecondApplyPhoneIn(List<String> values) {
			addCriterion("SECOND_APPLY_PHONE in", values, "secondApplyPhone");
			return (Criteria) this;
		}

		public Criteria andSecondApplyPhoneNotIn(List<String> values) {
			addCriterion("SECOND_APPLY_PHONE not in", values, "secondApplyPhone");
			return (Criteria) this;
		}

		public Criteria andSecondApplyPhoneBetween(String value1, String value2) {
			addCriterion("SECOND_APPLY_PHONE between", value1, value2, "secondApplyPhone");
			return (Criteria) this;
		}

		public Criteria andSecondApplyPhoneNotBetween(String value1, String value2) {
			addCriterion("SECOND_APPLY_PHONE not between", value1, value2, "secondApplyPhone");
			return (Criteria) this;
		}

		public Criteria andUnderwriterNameIsNull() {
			addCriterion("UNDERWRITER_NAME is null");
			return (Criteria) this;
		}

		public Criteria andUnderwriterNameIsNotNull() {
			addCriterion("UNDERWRITER_NAME is not null");
			return (Criteria) this;
		}

		public Criteria andUnderwriterNameEqualTo(String value) {
			addCriterion("UNDERWRITER_NAME =", value, "underwriterName");
			return (Criteria) this;
		}

		public Criteria andUnderwriterNameNotEqualTo(String value) {
			addCriterion("UNDERWRITER_NAME <>", value, "underwriterName");
			return (Criteria) this;
		}

		public Criteria andUnderwriterNameGreaterThan(String value) {
			addCriterion("UNDERWRITER_NAME >", value, "underwriterName");
			return (Criteria) this;
		}

		public Criteria andUnderwriterNameGreaterThanOrEqualTo(String value) {
			addCriterion("UNDERWRITER_NAME >=", value, "underwriterName");
			return (Criteria) this;
		}

		public Criteria andUnderwriterNameLessThan(String value) {
			addCriterion("UNDERWRITER_NAME <", value, "underwriterName");
			return (Criteria) this;
		}

		public Criteria andUnderwriterNameLessThanOrEqualTo(String value) {
			addCriterion("UNDERWRITER_NAME <=", value, "underwriterName");
			return (Criteria) this;
		}

		public Criteria andUnderwriterNameLike(String value) {
			addCriterion("UNDERWRITER_NAME like", value, "underwriterName");
			return (Criteria) this;
		}

		public Criteria andUnderwriterNameNotLike(String value) {
			addCriterion("UNDERWRITER_NAME not like", value, "underwriterName");
			return (Criteria) this;
		}

		public Criteria andUnderwriterNameIn(List<String> values) {
			addCriterion("UNDERWRITER_NAME in", values, "underwriterName");
			return (Criteria) this;
		}

		public Criteria andUnderwriterNameNotIn(List<String> values) {
			addCriterion("UNDERWRITER_NAME not in", values, "underwriterName");
			return (Criteria) this;
		}

		public Criteria andUnderwriterNameBetween(String value1, String value2) {
			addCriterion("UNDERWRITER_NAME between", value1, value2, "underwriterName");
			return (Criteria) this;
		}

		public Criteria andUnderwriterNameNotBetween(String value1, String value2) {
			addCriterion("UNDERWRITER_NAME not between", value1, value2, "underwriterName");
			return (Criteria) this;
		}

		public Criteria andUnderwriterPhoneIsNull() {
			addCriterion("UNDERWRITER_PHONE is null");
			return (Criteria) this;
		}

		public Criteria andUnderwriterPhoneIsNotNull() {
			addCriterion("UNDERWRITER_PHONE is not null");
			return (Criteria) this;
		}

		public Criteria andUnderwriterPhoneEqualTo(String value) {
			addCriterion("UNDERWRITER_PHONE =", value, "underwriterPhone");
			return (Criteria) this;
		}

		public Criteria andUnderwriterPhoneNotEqualTo(String value) {
			addCriterion("UNDERWRITER_PHONE <>", value, "underwriterPhone");
			return (Criteria) this;
		}

		public Criteria andUnderwriterPhoneGreaterThan(String value) {
			addCriterion("UNDERWRITER_PHONE >", value, "underwriterPhone");
			return (Criteria) this;
		}

		public Criteria andUnderwriterPhoneGreaterThanOrEqualTo(String value) {
			addCriterion("UNDERWRITER_PHONE >=", value, "underwriterPhone");
			return (Criteria) this;
		}

		public Criteria andUnderwriterPhoneLessThan(String value) {
			addCriterion("UNDERWRITER_PHONE <", value, "underwriterPhone");
			return (Criteria) this;
		}

		public Criteria andUnderwriterPhoneLessThanOrEqualTo(String value) {
			addCriterion("UNDERWRITER_PHONE <=", value, "underwriterPhone");
			return (Criteria) this;
		}

		public Criteria andUnderwriterPhoneLike(String value) {
			addCriterion("UNDERWRITER_PHONE like", value, "underwriterPhone");
			return (Criteria) this;
		}

		public Criteria andUnderwriterPhoneNotLike(String value) {
			addCriterion("UNDERWRITER_PHONE not like", value, "underwriterPhone");
			return (Criteria) this;
		}

		public Criteria andUnderwriterPhoneIn(List<String> values) {
			addCriterion("UNDERWRITER_PHONE in", values, "underwriterPhone");
			return (Criteria) this;
		}

		public Criteria andUnderwriterPhoneNotIn(List<String> values) {
			addCriterion("UNDERWRITER_PHONE not in", values, "underwriterPhone");
			return (Criteria) this;
		}

		public Criteria andUnderwriterPhoneBetween(String value1, String value2) {
			addCriterion("UNDERWRITER_PHONE between", value1, value2, "underwriterPhone");
			return (Criteria) this;
		}

		public Criteria andUnderwriterPhoneNotBetween(String value1, String value2) {
			addCriterion("UNDERWRITER_PHONE not between", value1, value2, "underwriterPhone");
			return (Criteria) this;
		}

		public Criteria andFinanceMethodIsNull() {
			addCriterion("FINANCE_METHOD is null");
			return (Criteria) this;
		}

		public Criteria andFinanceMethodIsNotNull() {
			addCriterion("FINANCE_METHOD is not null");
			return (Criteria) this;
		}

		public Criteria andFinanceMethodEqualTo(Byte value) {
			addCriterion("FINANCE_METHOD =", value, "financeMethod");
			return (Criteria) this;
		}

		public Criteria andFinanceMethodNotEqualTo(Byte value) {
			addCriterion("FINANCE_METHOD <>", value, "financeMethod");
			return (Criteria) this;
		}

		public Criteria andFinanceMethodGreaterThan(Byte value) {
			addCriterion("FINANCE_METHOD >", value, "financeMethod");
			return (Criteria) this;
		}

		public Criteria andFinanceMethodGreaterThanOrEqualTo(Byte value) {
			addCriterion("FINANCE_METHOD >=", value, "financeMethod");
			return (Criteria) this;
		}

		public Criteria andFinanceMethodLessThan(Byte value) {
			addCriterion("FINANCE_METHOD <", value, "financeMethod");
			return (Criteria) this;
		}

		public Criteria andFinanceMethodLessThanOrEqualTo(Byte value) {
			addCriterion("FINANCE_METHOD <=", value, "financeMethod");
			return (Criteria) this;
		}

		public Criteria andFinanceMethodIn(List<Byte> values) {
			addCriterion("FINANCE_METHOD in", values, "financeMethod");
			return (Criteria) this;
		}

		public Criteria andFinanceMethodNotIn(List<Byte> values) {
			addCriterion("FINANCE_METHOD not in", values, "financeMethod");
			return (Criteria) this;
		}

		public Criteria andFinanceMethodBetween(Byte value1, Byte value2) {
			addCriterion("FINANCE_METHOD between", value1, value2, "financeMethod");
			return (Criteria) this;
		}

		public Criteria andFinanceMethodNotBetween(Byte value1, Byte value2) {
			addCriterion("FINANCE_METHOD not between", value1, value2, "financeMethod");
			return (Criteria) this;
		}

		public Criteria andBankRecordIsNull() {
			addCriterion("BANK_RECORD is null");
			return (Criteria) this;
		}

		public Criteria andBankRecordIsNotNull() {
			addCriterion("BANK_RECORD is not null");
			return (Criteria) this;
		}

		public Criteria andBankRecordEqualTo(Byte value) {
			addCriterion("BANK_RECORD =", value, "bankRecord");
			return (Criteria) this;
		}

		public Criteria andBankRecordNotEqualTo(Byte value) {
			addCriterion("BANK_RECORD <>", value, "bankRecord");
			return (Criteria) this;
		}

		public Criteria andBankRecordGreaterThan(Byte value) {
			addCriterion("BANK_RECORD >", value, "bankRecord");
			return (Criteria) this;
		}

		public Criteria andBankRecordGreaterThanOrEqualTo(Byte value) {
			addCriterion("BANK_RECORD >=", value, "bankRecord");
			return (Criteria) this;
		}

		public Criteria andBankRecordLessThan(Byte value) {
			addCriterion("BANK_RECORD <", value, "bankRecord");
			return (Criteria) this;
		}

		public Criteria andBankRecordLessThanOrEqualTo(Byte value) {
			addCriterion("BANK_RECORD <=", value, "bankRecord");
			return (Criteria) this;
		}

		public Criteria andBankRecordIn(List<Byte> values) {
			addCriterion("BANK_RECORD in", values, "bankRecord");
			return (Criteria) this;
		}

		public Criteria andBankRecordNotIn(List<Byte> values) {
			addCriterion("BANK_RECORD not in", values, "bankRecord");
			return (Criteria) this;
		}

		public Criteria andBankRecordBetween(Byte value1, Byte value2) {
			addCriterion("BANK_RECORD between", value1, value2, "bankRecord");
			return (Criteria) this;
		}

		public Criteria andBankRecordNotBetween(Byte value1, Byte value2) {
			addCriterion("BANK_RECORD not between", value1, value2, "bankRecord");
			return (Criteria) this;
		}

		public Criteria andFinanceInfoDescIsNull() {
			addCriterion("FINANCE_INFO_DESC is null");
			return (Criteria) this;
		}

		public Criteria andFinanceInfoDescIsNotNull() {
			addCriterion("FINANCE_INFO_DESC is not null");
			return (Criteria) this;
		}

		public Criteria andFinanceInfoDescEqualTo(String value) {
			addCriterion("FINANCE_INFO_DESC =", value, "financeInfoDesc");
			return (Criteria) this;
		}

		public Criteria andFinanceInfoDescNotEqualTo(String value) {
			addCriterion("FINANCE_INFO_DESC <>", value, "financeInfoDesc");
			return (Criteria) this;
		}

		public Criteria andFinanceInfoDescGreaterThan(String value) {
			addCriterion("FINANCE_INFO_DESC >", value, "financeInfoDesc");
			return (Criteria) this;
		}

		public Criteria andFinanceInfoDescGreaterThanOrEqualTo(String value) {
			addCriterion("FINANCE_INFO_DESC >=", value, "financeInfoDesc");
			return (Criteria) this;
		}

		public Criteria andFinanceInfoDescLessThan(String value) {
			addCriterion("FINANCE_INFO_DESC <", value, "financeInfoDesc");
			return (Criteria) this;
		}

		public Criteria andFinanceInfoDescLessThanOrEqualTo(String value) {
			addCriterion("FINANCE_INFO_DESC <=", value, "financeInfoDesc");
			return (Criteria) this;
		}

		public Criteria andFinanceInfoDescLike(String value) {
			addCriterion("FINANCE_INFO_DESC like", value, "financeInfoDesc");
			return (Criteria) this;
		}

		public Criteria andFinanceInfoDescNotLike(String value) {
			addCriterion("FINANCE_INFO_DESC not like", value, "financeInfoDesc");
			return (Criteria) this;
		}

		public Criteria andFinanceInfoDescIn(List<String> values) {
			addCriterion("FINANCE_INFO_DESC in", values, "financeInfoDesc");
			return (Criteria) this;
		}

		public Criteria andFinanceInfoDescNotIn(List<String> values) {
			addCriterion("FINANCE_INFO_DESC not in", values, "financeInfoDesc");
			return (Criteria) this;
		}

		public Criteria andFinanceInfoDescBetween(String value1, String value2) {
			addCriterion("FINANCE_INFO_DESC between", value1, value2, "financeInfoDesc");
			return (Criteria) this;
		}

		public Criteria andFinanceInfoDescNotBetween(String value1, String value2) {
			addCriterion("FINANCE_INFO_DESC not between", value1, value2, "financeInfoDesc");
			return (Criteria) this;
		}

		public Criteria andContractSignTimeIsNull() {
			addCriterion("CONTRACT_SIGN_TIME is null");
			return (Criteria) this;
		}

		public Criteria andContractSignTimeIsNotNull() {
			addCriterion("CONTRACT_SIGN_TIME is not null");
			return (Criteria) this;
		}

		public Criteria andContractSignTimeEqualTo(Date value) {
			addCriterion("CONTRACT_SIGN_TIME =", value, "contractSignTime");
			return (Criteria) this;
		}

		public Criteria andContractSignTimeNotEqualTo(Date value) {
			addCriterion("CONTRACT_SIGN_TIME <>", value, "contractSignTime");
			return (Criteria) this;
		}

		public Criteria andContractSignTimeGreaterThan(Date value) {
			addCriterion("CONTRACT_SIGN_TIME >", value, "contractSignTime");
			return (Criteria) this;
		}

		public Criteria andContractSignTimeGreaterThanOrEqualTo(Date value) {
			addCriterion("CONTRACT_SIGN_TIME >=", value, "contractSignTime");
			return (Criteria) this;
		}

		public Criteria andContractSignTimeLessThan(Date value) {
			addCriterion("CONTRACT_SIGN_TIME <", value, "contractSignTime");
			return (Criteria) this;
		}

		public Criteria andContractSignTimeLessThanOrEqualTo(Date value) {
			addCriterion("CONTRACT_SIGN_TIME <=", value, "contractSignTime");
			return (Criteria) this;
		}

		public Criteria andContractSignTimeIn(List<Date> values) {
			addCriterion("CONTRACT_SIGN_TIME in", values, "contractSignTime");
			return (Criteria) this;
		}

		public Criteria andContractSignTimeNotIn(List<Date> values) {
			addCriterion("CONTRACT_SIGN_TIME not in", values, "contractSignTime");
			return (Criteria) this;
		}

		public Criteria andContractSignTimeBetween(Date value1, Date value2) {
			addCriterion("CONTRACT_SIGN_TIME between", value1, value2, "contractSignTime");
			return (Criteria) this;
		}

		public Criteria andContractSignTimeNotBetween(Date value1, Date value2) {
			addCriterion("CONTRACT_SIGN_TIME not between", value1, value2, "contractSignTime");
			return (Criteria) this;
		}

		public Criteria andDealPriceIsNull() {
			addCriterion("DEAL_PRICE is null");
			return (Criteria) this;
		}

		public Criteria andDealPriceIsNotNull() {
			addCriterion("DEAL_PRICE is not null");
			return (Criteria) this;
		}

		public Criteria andDealPriceEqualTo(BigDecimal value) {
			addCriterion("DEAL_PRICE =", value, "dealPrice");
			return (Criteria) this;
		}

		public Criteria andDealPriceNotEqualTo(BigDecimal value) {
			addCriterion("DEAL_PRICE <>", value, "dealPrice");
			return (Criteria) this;
		}

		public Criteria andDealPriceGreaterThan(BigDecimal value) {
			addCriterion("DEAL_PRICE >", value, "dealPrice");
			return (Criteria) this;
		}

		public Criteria andDealPriceGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("DEAL_PRICE >=", value, "dealPrice");
			return (Criteria) this;
		}

		public Criteria andDealPriceLessThan(BigDecimal value) {
			addCriterion("DEAL_PRICE <", value, "dealPrice");
			return (Criteria) this;
		}

		public Criteria andDealPriceLessThanOrEqualTo(BigDecimal value) {
			addCriterion("DEAL_PRICE <=", value, "dealPrice");
			return (Criteria) this;
		}

		public Criteria andDealPriceIn(List<BigDecimal> values) {
			addCriterion("DEAL_PRICE in", values, "dealPrice");
			return (Criteria) this;
		}

		public Criteria andDealPriceNotIn(List<BigDecimal> values) {
			addCriterion("DEAL_PRICE not in", values, "dealPrice");
			return (Criteria) this;
		}

		public Criteria andDealPriceBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("DEAL_PRICE between", value1, value2, "dealPrice");
			return (Criteria) this;
		}

		public Criteria andDealPriceNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("DEAL_PRICE not between", value1, value2, "dealPrice");
			return (Criteria) this;
		}

		public Criteria andApplyPriceIsNull() {
			addCriterion("APPLY_PRICE is null");
			return (Criteria) this;
		}

		public Criteria andApplyPriceIsNotNull() {
			addCriterion("APPLY_PRICE is not null");
			return (Criteria) this;
		}

		public Criteria andApplyPriceEqualTo(BigDecimal value) {
			addCriterion("APPLY_PRICE =", value, "applyPrice");
			return (Criteria) this;
		}

		public Criteria andApplyPriceNotEqualTo(BigDecimal value) {
			addCriterion("APPLY_PRICE <>", value, "applyPrice");
			return (Criteria) this;
		}

		public Criteria andApplyPriceGreaterThan(BigDecimal value) {
			addCriterion("APPLY_PRICE >", value, "applyPrice");
			return (Criteria) this;
		}

		public Criteria andApplyPriceGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("APPLY_PRICE >=", value, "applyPrice");
			return (Criteria) this;
		}

		public Criteria andApplyPriceLessThan(BigDecimal value) {
			addCriterion("APPLY_PRICE <", value, "applyPrice");
			return (Criteria) this;
		}

		public Criteria andApplyPriceLessThanOrEqualTo(BigDecimal value) {
			addCriterion("APPLY_PRICE <=", value, "applyPrice");
			return (Criteria) this;
		}

		public Criteria andApplyPriceIn(List<BigDecimal> values) {
			addCriterion("APPLY_PRICE in", values, "applyPrice");
			return (Criteria) this;
		}

		public Criteria andApplyPriceNotIn(List<BigDecimal> values) {
			addCriterion("APPLY_PRICE not in", values, "applyPrice");
			return (Criteria) this;
		}

		public Criteria andApplyPriceBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("APPLY_PRICE between", value1, value2, "applyPrice");
			return (Criteria) this;
		}

		public Criteria andApplyPriceNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("APPLY_PRICE not between", value1, value2, "applyPrice");
			return (Criteria) this;
		}

		public Criteria andFinanceYearIsNull() {
			addCriterion("FINANCE_YEAR is null");
			return (Criteria) this;
		}

		public Criteria andFinanceYearIsNotNull() {
			addCriterion("FINANCE_YEAR is not null");
			return (Criteria) this;
		}

		public Criteria andFinanceYearEqualTo(Byte value) {
			addCriterion("FINANCE_YEAR =", value, "financeYear");
			return (Criteria) this;
		}

		public Criteria andFinanceYearNotEqualTo(Byte value) {
			addCriterion("FINANCE_YEAR <>", value, "financeYear");
			return (Criteria) this;
		}

		public Criteria andFinanceYearGreaterThan(Byte value) {
			addCriterion("FINANCE_YEAR >", value, "financeYear");
			return (Criteria) this;
		}

		public Criteria andFinanceYearGreaterThanOrEqualTo(Byte value) {
			addCriterion("FINANCE_YEAR >=", value, "financeYear");
			return (Criteria) this;
		}

		public Criteria andFinanceYearLessThan(Byte value) {
			addCriterion("FINANCE_YEAR <", value, "financeYear");
			return (Criteria) this;
		}

		public Criteria andFinanceYearLessThanOrEqualTo(Byte value) {
			addCriterion("FINANCE_YEAR <=", value, "financeYear");
			return (Criteria) this;
		}

		public Criteria andFinanceYearIn(List<Byte> values) {
			addCriterion("FINANCE_YEAR in", values, "financeYear");
			return (Criteria) this;
		}

		public Criteria andFinanceYearNotIn(List<Byte> values) {
			addCriterion("FINANCE_YEAR not in", values, "financeYear");
			return (Criteria) this;
		}

		public Criteria andFinanceYearBetween(Byte value1, Byte value2) {
			addCriterion("FINANCE_YEAR between", value1, value2, "financeYear");
			return (Criteria) this;
		}

		public Criteria andFinanceYearNotBetween(Byte value1, Byte value2) {
			addCriterion("FINANCE_YEAR not between", value1, value2, "financeYear");
			return (Criteria) this;
		}

		public Criteria andFinanceRateIsNull() {
			addCriterion("FINANCE_RATE is null");
			return (Criteria) this;
		}

		public Criteria andFinanceRateIsNotNull() {
			addCriterion("FINANCE_RATE is not null");
			return (Criteria) this;
		}

		public Criteria andFinanceRateEqualTo(String value) {
			addCriterion("FINANCE_RATE =", value, "financeRate");
			return (Criteria) this;
		}

		public Criteria andFinanceRateNotEqualTo(String value) {
			addCriterion("FINANCE_RATE <>", value, "financeRate");
			return (Criteria) this;
		}

		public Criteria andFinanceRateGreaterThan(String value) {
			addCriterion("FINANCE_RATE >", value, "financeRate");
			return (Criteria) this;
		}

		public Criteria andFinanceRateGreaterThanOrEqualTo(String value) {
			addCriterion("FINANCE_RATE >=", value, "financeRate");
			return (Criteria) this;
		}

		public Criteria andFinanceRateLessThan(String value) {
			addCriterion("FINANCE_RATE <", value, "financeRate");
			return (Criteria) this;
		}

		public Criteria andFinanceRateLessThanOrEqualTo(String value) {
			addCriterion("FINANCE_RATE <=", value, "financeRate");
			return (Criteria) this;
		}

		public Criteria andFinanceRateLike(String value) {
			addCriterion("FINANCE_RATE like", value, "financeRate");
			return (Criteria) this;
		}

		public Criteria andFinanceRateNotLike(String value) {
			addCriterion("FINANCE_RATE not like", value, "financeRate");
			return (Criteria) this;
		}

		public Criteria andFinanceRateIn(List<String> values) {
			addCriterion("FINANCE_RATE in", values, "financeRate");
			return (Criteria) this;
		}

		public Criteria andFinanceRateNotIn(List<String> values) {
			addCriterion("FINANCE_RATE not in", values, "financeRate");
			return (Criteria) this;
		}

		public Criteria andFinanceRateBetween(String value1, String value2) {
			addCriterion("FINANCE_RATE between", value1, value2, "financeRate");
			return (Criteria) this;
		}

		public Criteria andFinanceRateNotBetween(String value1, String value2) {
			addCriterion("FINANCE_RATE not between", value1, value2, "financeRate");
			return (Criteria) this;
		}

		public Criteria andFundSupervisionFlagIsNull() {
			addCriterion("FUND_SUPERVISION_FLAG is null");
			return (Criteria) this;
		}

		public Criteria andFundSupervisionFlagIsNotNull() {
			addCriterion("FUND_SUPERVISION_FLAG is not null");
			return (Criteria) this;
		}

		public Criteria andFundSupervisionFlagEqualTo(Byte value) {
			addCriterion("FUND_SUPERVISION_FLAG =", value, "fundSupervisionFlag");
			return (Criteria) this;
		}

		public Criteria andFundSupervisionFlagNotEqualTo(Byte value) {
			addCriterion("FUND_SUPERVISION_FLAG <>", value, "fundSupervisionFlag");
			return (Criteria) this;
		}

		public Criteria andFundSupervisionFlagGreaterThan(Byte value) {
			addCriterion("FUND_SUPERVISION_FLAG >", value, "fundSupervisionFlag");
			return (Criteria) this;
		}

		public Criteria andFundSupervisionFlagGreaterThanOrEqualTo(Byte value) {
			addCriterion("FUND_SUPERVISION_FLAG >=", value, "fundSupervisionFlag");
			return (Criteria) this;
		}

		public Criteria andFundSupervisionFlagLessThan(Byte value) {
			addCriterion("FUND_SUPERVISION_FLAG <", value, "fundSupervisionFlag");
			return (Criteria) this;
		}

		public Criteria andFundSupervisionFlagLessThanOrEqualTo(Byte value) {
			addCriterion("FUND_SUPERVISION_FLAG <=", value, "fundSupervisionFlag");
			return (Criteria) this;
		}

		public Criteria andFundSupervisionFlagIn(List<Byte> values) {
			addCriterion("FUND_SUPERVISION_FLAG in", values, "fundSupervisionFlag");
			return (Criteria) this;
		}

		public Criteria andFundSupervisionFlagNotIn(List<Byte> values) {
			addCriterion("FUND_SUPERVISION_FLAG not in", values, "fundSupervisionFlag");
			return (Criteria) this;
		}

		public Criteria andFundSupervisionFlagBetween(Byte value1, Byte value2) {
			addCriterion("FUND_SUPERVISION_FLAG between", value1, value2, "fundSupervisionFlag");
			return (Criteria) this;
		}

		public Criteria andFundSupervisionFlagNotBetween(Byte value1, Byte value2) {
			addCriterion("FUND_SUPERVISION_FLAG not between", value1, value2, "fundSupervisionFlag");
			return (Criteria) this;
		}

		public Criteria andTrustServiceFlagIsNull() {
			addCriterion("TRUST_SERVICE_FLAG is null");
			return (Criteria) this;
		}

		public Criteria andTrustServiceFlagIsNotNull() {
			addCriterion("TRUST_SERVICE_FLAG is not null");
			return (Criteria) this;
		}

		public Criteria andTrustServiceFlagEqualTo(Byte value) {
			addCriterion("TRUST_SERVICE_FLAG =", value, "trustServiceFlag");
			return (Criteria) this;
		}

		public Criteria andTrustServiceFlagNotEqualTo(Byte value) {
			addCriterion("TRUST_SERVICE_FLAG <>", value, "trustServiceFlag");
			return (Criteria) this;
		}

		public Criteria andTrustServiceFlagGreaterThan(Byte value) {
			addCriterion("TRUST_SERVICE_FLAG >", value, "trustServiceFlag");
			return (Criteria) this;
		}

		public Criteria andTrustServiceFlagGreaterThanOrEqualTo(Byte value) {
			addCriterion("TRUST_SERVICE_FLAG >=", value, "trustServiceFlag");
			return (Criteria) this;
		}

		public Criteria andTrustServiceFlagLessThan(Byte value) {
			addCriterion("TRUST_SERVICE_FLAG <", value, "trustServiceFlag");
			return (Criteria) this;
		}

		public Criteria andTrustServiceFlagLessThanOrEqualTo(Byte value) {
			addCriterion("TRUST_SERVICE_FLAG <=", value, "trustServiceFlag");
			return (Criteria) this;
		}

		public Criteria andTrustServiceFlagIn(List<Byte> values) {
			addCriterion("TRUST_SERVICE_FLAG in", values, "trustServiceFlag");
			return (Criteria) this;
		}

		public Criteria andTrustServiceFlagNotIn(List<Byte> values) {
			addCriterion("TRUST_SERVICE_FLAG not in", values, "trustServiceFlag");
			return (Criteria) this;
		}

		public Criteria andTrustServiceFlagBetween(Byte value1, Byte value2) {
			addCriterion("TRUST_SERVICE_FLAG between", value1, value2, "trustServiceFlag");
			return (Criteria) this;
		}

		public Criteria andTrustServiceFlagNotBetween(Byte value1, Byte value2) {
			addCriterion("TRUST_SERVICE_FLAG not between", value1, value2, "trustServiceFlag");
			return (Criteria) this;
		}

		public Criteria andDoubleBankFlagIsNull() {
			addCriterion("DOUBLE_BANK_FLAG is null");
			return (Criteria) this;
		}

		public Criteria andDoubleBankFlagIsNotNull() {
			addCriterion("DOUBLE_BANK_FLAG is not null");
			return (Criteria) this;
		}

		public Criteria andDoubleBankFlagEqualTo(Byte value) {
			addCriterion("DOUBLE_BANK_FLAG =", value, "doubleBankFlag");
			return (Criteria) this;
		}

		public Criteria andDoubleBankFlagNotEqualTo(Byte value) {
			addCriterion("DOUBLE_BANK_FLAG <>", value, "doubleBankFlag");
			return (Criteria) this;
		}

		public Criteria andDoubleBankFlagGreaterThan(Byte value) {
			addCriterion("DOUBLE_BANK_FLAG >", value, "doubleBankFlag");
			return (Criteria) this;
		}

		public Criteria andDoubleBankFlagGreaterThanOrEqualTo(Byte value) {
			addCriterion("DOUBLE_BANK_FLAG >=", value, "doubleBankFlag");
			return (Criteria) this;
		}

		public Criteria andDoubleBankFlagLessThan(Byte value) {
			addCriterion("DOUBLE_BANK_FLAG <", value, "doubleBankFlag");
			return (Criteria) this;
		}

		public Criteria andDoubleBankFlagLessThanOrEqualTo(Byte value) {
			addCriterion("DOUBLE_BANK_FLAG <=", value, "doubleBankFlag");
			return (Criteria) this;
		}

		public Criteria andDoubleBankFlagIn(List<Byte> values) {
			addCriterion("DOUBLE_BANK_FLAG in", values, "doubleBankFlag");
			return (Criteria) this;
		}

		public Criteria andDoubleBankFlagNotIn(List<Byte> values) {
			addCriterion("DOUBLE_BANK_FLAG not in", values, "doubleBankFlag");
			return (Criteria) this;
		}

		public Criteria andDoubleBankFlagBetween(Byte value1, Byte value2) {
			addCriterion("DOUBLE_BANK_FLAG between", value1, value2, "doubleBankFlag");
			return (Criteria) this;
		}

		public Criteria andDoubleBankFlagNotBetween(Byte value1, Byte value2) {
			addCriterion("DOUBLE_BANK_FLAG not between", value1, value2, "doubleBankFlag");
			return (Criteria) this;
		}

		public Criteria andMainBankIdIsNull() {
			addCriterion("MAIN_BANK_ID is null");
			return (Criteria) this;
		}

		public Criteria andMainBankIdIsNotNull() {
			addCriterion("MAIN_BANK_ID is not null");
			return (Criteria) this;
		}

		public Criteria andMainBankIdEqualTo(Integer value) {
			addCriterion("MAIN_BANK_ID =", value, "mainBankId");
			return (Criteria) this;
		}

		public Criteria andMainBankIdNotEqualTo(Integer value) {
			addCriterion("MAIN_BANK_ID <>", value, "mainBankId");
			return (Criteria) this;
		}

		public Criteria andMainBankIdGreaterThan(Integer value) {
			addCriterion("MAIN_BANK_ID >", value, "mainBankId");
			return (Criteria) this;
		}

		public Criteria andMainBankIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("MAIN_BANK_ID >=", value, "mainBankId");
			return (Criteria) this;
		}

		public Criteria andMainBankIdLessThan(Integer value) {
			addCriterion("MAIN_BANK_ID <", value, "mainBankId");
			return (Criteria) this;
		}

		public Criteria andMainBankIdLessThanOrEqualTo(Integer value) {
			addCriterion("MAIN_BANK_ID <=", value, "mainBankId");
			return (Criteria) this;
		}

		public Criteria andMainBankIdIn(List<Integer> values) {
			addCriterion("MAIN_BANK_ID in", values, "mainBankId");
			return (Criteria) this;
		}

		public Criteria andMainBankIdNotIn(List<Integer> values) {
			addCriterion("MAIN_BANK_ID not in", values, "mainBankId");
			return (Criteria) this;
		}

		public Criteria andMainBankIdBetween(Integer value1, Integer value2) {
			addCriterion("MAIN_BANK_ID between", value1, value2, "mainBankId");
			return (Criteria) this;
		}

		public Criteria andMainBankIdNotBetween(Integer value1, Integer value2) {
			addCriterion("MAIN_BANK_ID not between", value1, value2, "mainBankId");
			return (Criteria) this;
		}

		public Criteria andSecondBankIdIsNull() {
			addCriterion("SECOND_BANK_ID is null");
			return (Criteria) this;
		}

		public Criteria andSecondBankIdIsNotNull() {
			addCriterion("SECOND_BANK_ID is not null");
			return (Criteria) this;
		}

		public Criteria andSecondBankIdEqualTo(Integer value) {
			addCriterion("SECOND_BANK_ID =", value, "secondBankId");
			return (Criteria) this;
		}

		public Criteria andSecondBankIdNotEqualTo(Integer value) {
			addCriterion("SECOND_BANK_ID <>", value, "secondBankId");
			return (Criteria) this;
		}

		public Criteria andSecondBankIdGreaterThan(Integer value) {
			addCriterion("SECOND_BANK_ID >", value, "secondBankId");
			return (Criteria) this;
		}

		public Criteria andSecondBankIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("SECOND_BANK_ID >=", value, "secondBankId");
			return (Criteria) this;
		}

		public Criteria andSecondBankIdLessThan(Integer value) {
			addCriterion("SECOND_BANK_ID <", value, "secondBankId");
			return (Criteria) this;
		}

		public Criteria andSecondBankIdLessThanOrEqualTo(Integer value) {
			addCriterion("SECOND_BANK_ID <=", value, "secondBankId");
			return (Criteria) this;
		}

		public Criteria andSecondBankIdIn(List<Integer> values) {
			addCriterion("SECOND_BANK_ID in", values, "secondBankId");
			return (Criteria) this;
		}

		public Criteria andSecondBankIdNotIn(List<Integer> values) {
			addCriterion("SECOND_BANK_ID not in", values, "secondBankId");
			return (Criteria) this;
		}

		public Criteria andSecondBankIdBetween(Integer value1, Integer value2) {
			addCriterion("SECOND_BANK_ID between", value1, value2, "secondBankId");
			return (Criteria) this;
		}

		public Criteria andSecondBankIdNotBetween(Integer value1, Integer value2) {
			addCriterion("SECOND_BANK_ID not between", value1, value2, "secondBankId");
			return (Criteria) this;
		}

		public Criteria andPreviewsTimeIsNull() {
			addCriterion("PREVIEWS_TIME is null");
			return (Criteria) this;
		}

		public Criteria andPreviewsTimeIsNotNull() {
			addCriterion("PREVIEWS_TIME is not null");
			return (Criteria) this;
		}

		public Criteria andPreviewsTimeEqualTo(Date value) {
			addCriterion("PREVIEWS_TIME =", value, "previewsTime");
			return (Criteria) this;
		}

		public Criteria andPreviewsTimeNotEqualTo(Date value) {
			addCriterion("PREVIEWS_TIME <>", value, "previewsTime");
			return (Criteria) this;
		}

		public Criteria andPreviewsTimeGreaterThan(Date value) {
			addCriterion("PREVIEWS_TIME >", value, "previewsTime");
			return (Criteria) this;
		}

		public Criteria andPreviewsTimeGreaterThanOrEqualTo(Date value) {
			addCriterion("PREVIEWS_TIME >=", value, "previewsTime");
			return (Criteria) this;
		}

		public Criteria andPreviewsTimeLessThan(Date value) {
			addCriterion("PREVIEWS_TIME <", value, "previewsTime");
			return (Criteria) this;
		}

		public Criteria andPreviewsTimeLessThanOrEqualTo(Date value) {
			addCriterion("PREVIEWS_TIME <=", value, "previewsTime");
			return (Criteria) this;
		}

		public Criteria andPreviewsTimeIn(List<Date> values) {
			addCriterion("PREVIEWS_TIME in", values, "previewsTime");
			return (Criteria) this;
		}

		public Criteria andPreviewsTimeNotIn(List<Date> values) {
			addCriterion("PREVIEWS_TIME not in", values, "previewsTime");
			return (Criteria) this;
		}

		public Criteria andPreviewsTimeBetween(Date value1, Date value2) {
			addCriterion("PREVIEWS_TIME between", value1, value2, "previewsTime");
			return (Criteria) this;
		}

		public Criteria andPreviewsTimeNotBetween(Date value1, Date value2) {
			addCriterion("PREVIEWS_TIME not between", value1, value2, "previewsTime");
			return (Criteria) this;
		}

		public Criteria andFinanceMethodDescIsNull() {
			addCriterion("FINANCE_METHOD_DESC is null");
			return (Criteria) this;
		}

		public Criteria andFinanceMethodDescIsNotNull() {
			addCriterion("FINANCE_METHOD_DESC is not null");
			return (Criteria) this;
		}

		public Criteria andFinanceMethodDescEqualTo(String value) {
			addCriterion("FINANCE_METHOD_DESC =", value, "financeMethodDesc");
			return (Criteria) this;
		}

		public Criteria andFinanceMethodDescNotEqualTo(String value) {
			addCriterion("FINANCE_METHOD_DESC <>", value, "financeMethodDesc");
			return (Criteria) this;
		}

		public Criteria andFinanceMethodDescGreaterThan(String value) {
			addCriterion("FINANCE_METHOD_DESC >", value, "financeMethodDesc");
			return (Criteria) this;
		}

		public Criteria andFinanceMethodDescGreaterThanOrEqualTo(String value) {
			addCriterion("FINANCE_METHOD_DESC >=", value, "financeMethodDesc");
			return (Criteria) this;
		}

		public Criteria andFinanceMethodDescLessThan(String value) {
			addCriterion("FINANCE_METHOD_DESC <", value, "financeMethodDesc");
			return (Criteria) this;
		}

		public Criteria andFinanceMethodDescLessThanOrEqualTo(String value) {
			addCriterion("FINANCE_METHOD_DESC <=", value, "financeMethodDesc");
			return (Criteria) this;
		}

		public Criteria andFinanceMethodDescLike(String value) {
			addCriterion("FINANCE_METHOD_DESC like", value, "financeMethodDesc");
			return (Criteria) this;
		}

		public Criteria andFinanceMethodDescNotLike(String value) {
			addCriterion("FINANCE_METHOD_DESC not like", value, "financeMethodDesc");
			return (Criteria) this;
		}

		public Criteria andFinanceMethodDescIn(List<String> values) {
			addCriterion("FINANCE_METHOD_DESC in", values, "financeMethodDesc");
			return (Criteria) this;
		}

		public Criteria andFinanceMethodDescNotIn(List<String> values) {
			addCriterion("FINANCE_METHOD_DESC not in", values, "financeMethodDesc");
			return (Criteria) this;
		}

		public Criteria andFinanceMethodDescBetween(String value1, String value2) {
			addCriterion("FINANCE_METHOD_DESC between", value1, value2, "financeMethodDesc");
			return (Criteria) this;
		}

		public Criteria andFinanceMethodDescNotBetween(String value1, String value2) {
			addCriterion("FINANCE_METHOD_DESC not between", value1, value2, "financeMethodDesc");
			return (Criteria) this;
		}

		public Criteria andChargeFlagIsNull() {
			addCriterion("CHARGE_FLAG is null");
			return (Criteria) this;
		}

		public Criteria andChargeFlagIsNotNull() {
			addCriterion("CHARGE_FLAG is not null");
			return (Criteria) this;
		}

		public Criteria andChargeFlagEqualTo(Byte value) {
			addCriterion("CHARGE_FLAG =", value, "chargeFlag");
			return (Criteria) this;
		}

		public Criteria andChargeFlagNotEqualTo(Byte value) {
			addCriterion("CHARGE_FLAG <>", value, "chargeFlag");
			return (Criteria) this;
		}

		public Criteria andChargeFlagGreaterThan(Byte value) {
			addCriterion("CHARGE_FLAG >", value, "chargeFlag");
			return (Criteria) this;
		}

		public Criteria andChargeFlagGreaterThanOrEqualTo(Byte value) {
			addCriterion("CHARGE_FLAG >=", value, "chargeFlag");
			return (Criteria) this;
		}

		public Criteria andChargeFlagLessThan(Byte value) {
			addCriterion("CHARGE_FLAG <", value, "chargeFlag");
			return (Criteria) this;
		}

		public Criteria andChargeFlagLessThanOrEqualTo(Byte value) {
			addCriterion("CHARGE_FLAG <=", value, "chargeFlag");
			return (Criteria) this;
		}

		public Criteria andChargeFlagIn(List<Byte> values) {
			addCriterion("CHARGE_FLAG in", values, "chargeFlag");
			return (Criteria) this;
		}

		public Criteria andChargeFlagNotIn(List<Byte> values) {
			addCriterion("CHARGE_FLAG not in", values, "chargeFlag");
			return (Criteria) this;
		}

		public Criteria andChargeFlagBetween(Byte value1, Byte value2) {
			addCriterion("CHARGE_FLAG between", value1, value2, "chargeFlag");
			return (Criteria) this;
		}

		public Criteria andChargeFlagNotBetween(Byte value1, Byte value2) {
			addCriterion("CHARGE_FLAG not between", value1, value2, "chargeFlag");
			return (Criteria) this;
		}

		public Criteria andChargeMethodIsNull() {
			addCriterion("CHARGE_METHOD is null");
			return (Criteria) this;
		}

		public Criteria andChargeMethodIsNotNull() {
			addCriterion("CHARGE_METHOD is not null");
			return (Criteria) this;
		}

		public Criteria andChargeMethodEqualTo(String value) {
			addCriterion("CHARGE_METHOD =", value, "chargeMethod");
			return (Criteria) this;
		}

		public Criteria andChargeMethodNotEqualTo(String value) {
			addCriterion("CHARGE_METHOD <>", value, "chargeMethod");
			return (Criteria) this;
		}

		public Criteria andChargeMethodGreaterThan(String value) {
			addCriterion("CHARGE_METHOD >", value, "chargeMethod");
			return (Criteria) this;
		}

		public Criteria andChargeMethodGreaterThanOrEqualTo(String value) {
			addCriterion("CHARGE_METHOD >=", value, "chargeMethod");
			return (Criteria) this;
		}

		public Criteria andChargeMethodLessThan(String value) {
			addCriterion("CHARGE_METHOD <", value, "chargeMethod");
			return (Criteria) this;
		}

		public Criteria andChargeMethodLessThanOrEqualTo(String value) {
			addCriterion("CHARGE_METHOD <=", value, "chargeMethod");
			return (Criteria) this;
		}

		public Criteria andChargeMethodLike(String value) {
			addCriterion("CHARGE_METHOD like", value, "chargeMethod");
			return (Criteria) this;
		}

		public Criteria andChargeMethodNotLike(String value) {
			addCriterion("CHARGE_METHOD not like", value, "chargeMethod");
			return (Criteria) this;
		}

		public Criteria andChargeMethodIn(List<String> values) {
			addCriterion("CHARGE_METHOD in", values, "chargeMethod");
			return (Criteria) this;
		}

		public Criteria andChargeMethodNotIn(List<String> values) {
			addCriterion("CHARGE_METHOD not in", values, "chargeMethod");
			return (Criteria) this;
		}

		public Criteria andChargeMethodBetween(String value1, String value2) {
			addCriterion("CHARGE_METHOD between", value1, value2, "chargeMethod");
			return (Criteria) this;
		}

		public Criteria andChargeMethodNotBetween(String value1, String value2) {
			addCriterion("CHARGE_METHOD not between", value1, value2, "chargeMethod");
			return (Criteria) this;
		}

		public Criteria andBaseChargeIsNull() {
			addCriterion("BASE_CHARGE is null");
			return (Criteria) this;
		}

		public Criteria andBaseChargeIsNotNull() {
			addCriterion("BASE_CHARGE is not null");
			return (Criteria) this;
		}

		public Criteria andBaseChargeEqualTo(BigDecimal value) {
			addCriterion("BASE_CHARGE =", value, "baseCharge");
			return (Criteria) this;
		}

		public Criteria andBaseChargeNotEqualTo(BigDecimal value) {
			addCriterion("BASE_CHARGE <>", value, "baseCharge");
			return (Criteria) this;
		}

		public Criteria andBaseChargeGreaterThan(BigDecimal value) {
			addCriterion("BASE_CHARGE >", value, "baseCharge");
			return (Criteria) this;
		}

		public Criteria andBaseChargeGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("BASE_CHARGE >=", value, "baseCharge");
			return (Criteria) this;
		}

		public Criteria andBaseChargeLessThan(BigDecimal value) {
			addCriterion("BASE_CHARGE <", value, "baseCharge");
			return (Criteria) this;
		}

		public Criteria andBaseChargeLessThanOrEqualTo(BigDecimal value) {
			addCriterion("BASE_CHARGE <=", value, "baseCharge");
			return (Criteria) this;
		}

		public Criteria andBaseChargeIn(List<BigDecimal> values) {
			addCriterion("BASE_CHARGE in", values, "baseCharge");
			return (Criteria) this;
		}

		public Criteria andBaseChargeNotIn(List<BigDecimal> values) {
			addCriterion("BASE_CHARGE not in", values, "baseCharge");
			return (Criteria) this;
		}

		public Criteria andBaseChargeBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("BASE_CHARGE between", value1, value2, "baseCharge");
			return (Criteria) this;
		}

		public Criteria andBaseChargeNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("BASE_CHARGE not between", value1, value2, "baseCharge");
			return (Criteria) this;
		}

		public Criteria andHftChargeIsNull() {
			addCriterion("HFT_CHARGE is null");
			return (Criteria) this;
		}

		public Criteria andHftChargeIsNotNull() {
			addCriterion("HFT_CHARGE is not null");
			return (Criteria) this;
		}

		public Criteria andHftChargeEqualTo(BigDecimal value) {
			addCriterion("HFT_CHARGE =", value, "hftCharge");
			return (Criteria) this;
		}

		public Criteria andHftChargeNotEqualTo(BigDecimal value) {
			addCriterion("HFT_CHARGE <>", value, "hftCharge");
			return (Criteria) this;
		}

		public Criteria andHftChargeGreaterThan(BigDecimal value) {
			addCriterion("HFT_CHARGE >", value, "hftCharge");
			return (Criteria) this;
		}

		public Criteria andHftChargeGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("HFT_CHARGE >=", value, "hftCharge");
			return (Criteria) this;
		}

		public Criteria andHftChargeLessThan(BigDecimal value) {
			addCriterion("HFT_CHARGE <", value, "hftCharge");
			return (Criteria) this;
		}

		public Criteria andHftChargeLessThanOrEqualTo(BigDecimal value) {
			addCriterion("HFT_CHARGE <=", value, "hftCharge");
			return (Criteria) this;
		}

		public Criteria andHftChargeIn(List<BigDecimal> values) {
			addCriterion("HFT_CHARGE in", values, "hftCharge");
			return (Criteria) this;
		}

		public Criteria andHftChargeNotIn(List<BigDecimal> values) {
			addCriterion("HFT_CHARGE not in", values, "hftCharge");
			return (Criteria) this;
		}

		public Criteria andHftChargeBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("HFT_CHARGE between", value1, value2, "hftCharge");
			return (Criteria) this;
		}

		public Criteria andHftChargeNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("HFT_CHARGE not between", value1, value2, "hftCharge");
			return (Criteria) this;
		}

		public Criteria andProxyChargeIsNull() {
			addCriterion("PROXY_CHARGE is null");
			return (Criteria) this;
		}

		public Criteria andProxyChargeIsNotNull() {
			addCriterion("PROXY_CHARGE is not null");
			return (Criteria) this;
		}

		public Criteria andProxyChargeEqualTo(BigDecimal value) {
			addCriterion("PROXY_CHARGE =", value, "proxyCharge");
			return (Criteria) this;
		}

		public Criteria andProxyChargeNotEqualTo(BigDecimal value) {
			addCriterion("PROXY_CHARGE <>", value, "proxyCharge");
			return (Criteria) this;
		}

		public Criteria andProxyChargeGreaterThan(BigDecimal value) {
			addCriterion("PROXY_CHARGE >", value, "proxyCharge");
			return (Criteria) this;
		}

		public Criteria andProxyChargeGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("PROXY_CHARGE >=", value, "proxyCharge");
			return (Criteria) this;
		}

		public Criteria andProxyChargeLessThan(BigDecimal value) {
			addCriterion("PROXY_CHARGE <", value, "proxyCharge");
			return (Criteria) this;
		}

		public Criteria andProxyChargeLessThanOrEqualTo(BigDecimal value) {
			addCriterion("PROXY_CHARGE <=", value, "proxyCharge");
			return (Criteria) this;
		}

		public Criteria andProxyChargeIn(List<BigDecimal> values) {
			addCriterion("PROXY_CHARGE in", values, "proxyCharge");
			return (Criteria) this;
		}

		public Criteria andProxyChargeNotIn(List<BigDecimal> values) {
			addCriterion("PROXY_CHARGE not in", values, "proxyCharge");
			return (Criteria) this;
		}

		public Criteria andProxyChargeBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("PROXY_CHARGE between", value1, value2, "proxyCharge");
			return (Criteria) this;
		}

		public Criteria andProxyChargeNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("PROXY_CHARGE not between", value1, value2, "proxyCharge");
			return (Criteria) this;
		}

		public Criteria andOtherChargeIsNull() {
			addCriterion("OTHER_CHARGE is null");
			return (Criteria) this;
		}

		public Criteria andOtherChargeIsNotNull() {
			addCriterion("OTHER_CHARGE is not null");
			return (Criteria) this;
		}

		public Criteria andOtherChargeEqualTo(BigDecimal value) {
			addCriterion("OTHER_CHARGE =", value, "otherCharge");
			return (Criteria) this;
		}

		public Criteria andOtherChargeNotEqualTo(BigDecimal value) {
			addCriterion("OTHER_CHARGE <>", value, "otherCharge");
			return (Criteria) this;
		}

		public Criteria andOtherChargeGreaterThan(BigDecimal value) {
			addCriterion("OTHER_CHARGE >", value, "otherCharge");
			return (Criteria) this;
		}

		public Criteria andOtherChargeGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("OTHER_CHARGE >=", value, "otherCharge");
			return (Criteria) this;
		}

		public Criteria andOtherChargeLessThan(BigDecimal value) {
			addCriterion("OTHER_CHARGE <", value, "otherCharge");
			return (Criteria) this;
		}

		public Criteria andOtherChargeLessThanOrEqualTo(BigDecimal value) {
			addCriterion("OTHER_CHARGE <=", value, "otherCharge");
			return (Criteria) this;
		}

		public Criteria andOtherChargeIn(List<BigDecimal> values) {
			addCriterion("OTHER_CHARGE in", values, "otherCharge");
			return (Criteria) this;
		}

		public Criteria andOtherChargeNotIn(List<BigDecimal> values) {
			addCriterion("OTHER_CHARGE not in", values, "otherCharge");
			return (Criteria) this;
		}

		public Criteria andOtherChargeBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("OTHER_CHARGE between", value1, value2, "otherCharge");
			return (Criteria) this;
		}

		public Criteria andOtherChargeNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("OTHER_CHARGE not between", value1, value2, "otherCharge");
			return (Criteria) this;
		}

		public Criteria andChargeDescIsNull() {
			addCriterion("CHARGE_DESC is null");
			return (Criteria) this;
		}

		public Criteria andChargeDescIsNotNull() {
			addCriterion("CHARGE_DESC is not null");
			return (Criteria) this;
		}

		public Criteria andChargeDescEqualTo(String value) {
			addCriterion("CHARGE_DESC =", value, "chargeDesc");
			return (Criteria) this;
		}

		public Criteria andChargeDescNotEqualTo(String value) {
			addCriterion("CHARGE_DESC <>", value, "chargeDesc");
			return (Criteria) this;
		}

		public Criteria andChargeDescGreaterThan(String value) {
			addCriterion("CHARGE_DESC >", value, "chargeDesc");
			return (Criteria) this;
		}

		public Criteria andChargeDescGreaterThanOrEqualTo(String value) {
			addCriterion("CHARGE_DESC >=", value, "chargeDesc");
			return (Criteria) this;
		}

		public Criteria andChargeDescLessThan(String value) {
			addCriterion("CHARGE_DESC <", value, "chargeDesc");
			return (Criteria) this;
		}

		public Criteria andChargeDescLessThanOrEqualTo(String value) {
			addCriterion("CHARGE_DESC <=", value, "chargeDesc");
			return (Criteria) this;
		}

		public Criteria andChargeDescLike(String value) {
			addCriterion("CHARGE_DESC like", value, "chargeDesc");
			return (Criteria) this;
		}

		public Criteria andChargeDescNotLike(String value) {
			addCriterion("CHARGE_DESC not like", value, "chargeDesc");
			return (Criteria) this;
		}

		public Criteria andChargeDescIn(List<String> values) {
			addCriterion("CHARGE_DESC in", values, "chargeDesc");
			return (Criteria) this;
		}

		public Criteria andChargeDescNotIn(List<String> values) {
			addCriterion("CHARGE_DESC not in", values, "chargeDesc");
			return (Criteria) this;
		}

		public Criteria andChargeDescBetween(String value1, String value2) {
			addCriterion("CHARGE_DESC between", value1, value2, "chargeDesc");
			return (Criteria) this;
		}

		public Criteria andChargeDescNotBetween(String value1, String value2) {
			addCriterion("CHARGE_DESC not between", value1, value2, "chargeDesc");
			return (Criteria) this;
		}

		public Criteria andBusinessUserIdIsNull() {
			addCriterion("BUSINESS_USER_ID is null");
			return (Criteria) this;
		}

		public Criteria andBusinessUserIdIsNotNull() {
			addCriterion("BUSINESS_USER_ID is not null");
			return (Criteria) this;
		}

		public Criteria andBusinessUserIdEqualTo(Integer value) {
			addCriterion("BUSINESS_USER_ID =", value, "businessUserId");
			return (Criteria) this;
		}

		public Criteria andBusinessUserIdNotEqualTo(Integer value) {
			addCriterion("BUSINESS_USER_ID <>", value, "businessUserId");
			return (Criteria) this;
		}

		public Criteria andBusinessUserIdGreaterThan(Integer value) {
			addCriterion("BUSINESS_USER_ID >", value, "businessUserId");
			return (Criteria) this;
		}

		public Criteria andBusinessUserIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("BUSINESS_USER_ID >=", value, "businessUserId");
			return (Criteria) this;
		}

		public Criteria andBusinessUserIdLessThan(Integer value) {
			addCriterion("BUSINESS_USER_ID <", value, "businessUserId");
			return (Criteria) this;
		}

		public Criteria andBusinessUserIdLessThanOrEqualTo(Integer value) {
			addCriterion("BUSINESS_USER_ID <=", value, "businessUserId");
			return (Criteria) this;
		}

		public Criteria andBusinessUserIdIn(List<Integer> values) {
			addCriterion("BUSINESS_USER_ID in", values, "businessUserId");
			return (Criteria) this;
		}

		public Criteria andBusinessUserIdNotIn(List<Integer> values) {
			addCriterion("BUSINESS_USER_ID not in", values, "businessUserId");
			return (Criteria) this;
		}

		public Criteria andBusinessUserIdBetween(Integer value1, Integer value2) {
			addCriterion("BUSINESS_USER_ID between", value1, value2, "businessUserId");
			return (Criteria) this;
		}

		public Criteria andBusinessUserIdNotBetween(Integer value1, Integer value2) {
			addCriterion("BUSINESS_USER_ID not between", value1, value2, "businessUserId");
			return (Criteria) this;
		}

		public Criteria andDealUserIdIsNull() {
			addCriterion("DEAL_USER_ID is null");
			return (Criteria) this;
		}

		public Criteria andDealUserIdIsNotNull() {
			addCriterion("DEAL_USER_ID is not null");
			return (Criteria) this;
		}

		public Criteria andDealUserIdEqualTo(Integer value) {
			addCriterion("DEAL_USER_ID =", value, "dealUserId");
			return (Criteria) this;
		}

		public Criteria andDealUserIdNotEqualTo(Integer value) {
			addCriterion("DEAL_USER_ID <>", value, "dealUserId");
			return (Criteria) this;
		}

		public Criteria andDealUserIdGreaterThan(Integer value) {
			addCriterion("DEAL_USER_ID >", value, "dealUserId");
			return (Criteria) this;
		}

		public Criteria andDealUserIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("DEAL_USER_ID >=", value, "dealUserId");
			return (Criteria) this;
		}

		public Criteria andDealUserIdLessThan(Integer value) {
			addCriterion("DEAL_USER_ID <", value, "dealUserId");
			return (Criteria) this;
		}

		public Criteria andDealUserIdLessThanOrEqualTo(Integer value) {
			addCriterion("DEAL_USER_ID <=", value, "dealUserId");
			return (Criteria) this;
		}

		public Criteria andDealUserIdIn(List<Integer> values) {
			addCriterion("DEAL_USER_ID in", values, "dealUserId");
			return (Criteria) this;
		}

		public Criteria andDealUserIdNotIn(List<Integer> values) {
			addCriterion("DEAL_USER_ID not in", values, "dealUserId");
			return (Criteria) this;
		}

		public Criteria andDealUserIdBetween(Integer value1, Integer value2) {
			addCriterion("DEAL_USER_ID between", value1, value2, "dealUserId");
			return (Criteria) this;
		}

		public Criteria andDealUserIdNotBetween(Integer value1, Integer value2) {
			addCriterion("DEAL_USER_ID not between", value1, value2, "dealUserId");
			return (Criteria) this;
		}

		public Criteria andAssessmentUserIdIsNull() {
			addCriterion("ASSESSMENT_USER_ID is null");
			return (Criteria) this;
		}

		public Criteria andAssessmentUserIdIsNotNull() {
			addCriterion("ASSESSMENT_USER_ID is not null");
			return (Criteria) this;
		}

		public Criteria andAssessmentUserIdEqualTo(Integer value) {
			addCriterion("ASSESSMENT_USER_ID =", value, "assessmentUserId");
			return (Criteria) this;
		}

		public Criteria andAssessmentUserIdNotEqualTo(Integer value) {
			addCriterion("ASSESSMENT_USER_ID <>", value, "assessmentUserId");
			return (Criteria) this;
		}

		public Criteria andAssessmentUserIdGreaterThan(Integer value) {
			addCriterion("ASSESSMENT_USER_ID >", value, "assessmentUserId");
			return (Criteria) this;
		}

		public Criteria andAssessmentUserIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("ASSESSMENT_USER_ID >=", value, "assessmentUserId");
			return (Criteria) this;
		}

		public Criteria andAssessmentUserIdLessThan(Integer value) {
			addCriterion("ASSESSMENT_USER_ID <", value, "assessmentUserId");
			return (Criteria) this;
		}

		public Criteria andAssessmentUserIdLessThanOrEqualTo(Integer value) {
			addCriterion("ASSESSMENT_USER_ID <=", value, "assessmentUserId");
			return (Criteria) this;
		}

		public Criteria andAssessmentUserIdIn(List<Integer> values) {
			addCriterion("ASSESSMENT_USER_ID in", values, "assessmentUserId");
			return (Criteria) this;
		}

		public Criteria andAssessmentUserIdNotIn(List<Integer> values) {
			addCriterion("ASSESSMENT_USER_ID not in", values, "assessmentUserId");
			return (Criteria) this;
		}

		public Criteria andAssessmentUserIdBetween(Integer value1, Integer value2) {
			addCriterion("ASSESSMENT_USER_ID between", value1, value2, "assessmentUserId");
			return (Criteria) this;
		}

		public Criteria andAssessmentUserIdNotBetween(Integer value1, Integer value2) {
			addCriterion("ASSESSMENT_USER_ID not between", value1, value2, "assessmentUserId");
			return (Criteria) this;
		}

		public Criteria andCompNoIsNull() {
			addCriterion("COMP_NO is null");
			return (Criteria) this;
		}

		public Criteria andCompNoIsNotNull() {
			addCriterion("COMP_NO is not null");
			return (Criteria) this;
		}

		public Criteria andCompNoEqualTo(String value) {
			addCriterion("COMP_NO =", value, "compNo");
			return (Criteria) this;
		}

		public Criteria andCompNoNotEqualTo(String value) {
			addCriterion("COMP_NO <>", value, "compNo");
			return (Criteria) this;
		}

		public Criteria andCompNoGreaterThan(String value) {
			addCriterion("COMP_NO >", value, "compNo");
			return (Criteria) this;
		}

		public Criteria andCompNoGreaterThanOrEqualTo(String value) {
			addCriterion("COMP_NO >=", value, "compNo");
			return (Criteria) this;
		}

		public Criteria andCompNoLessThan(String value) {
			addCriterion("COMP_NO <", value, "compNo");
			return (Criteria) this;
		}

		public Criteria andCompNoLessThanOrEqualTo(String value) {
			addCriterion("COMP_NO <=", value, "compNo");
			return (Criteria) this;
		}

		public Criteria andCompNoLike(String value) {
			addCriterion("COMP_NO like", value, "compNo");
			return (Criteria) this;
		}

		public Criteria andCompNoNotLike(String value) {
			addCriterion("COMP_NO not like", value, "compNo");
			return (Criteria) this;
		}

		public Criteria andCompNoIn(List<String> values) {
			addCriterion("COMP_NO in", values, "compNo");
			return (Criteria) this;
		}

		public Criteria andCompNoNotIn(List<String> values) {
			addCriterion("COMP_NO not in", values, "compNo");
			return (Criteria) this;
		}

		public Criteria andCompNoBetween(String value1, String value2) {
			addCriterion("COMP_NO between", value1, value2, "compNo");
			return (Criteria) this;
		}

		public Criteria andCompNoNotBetween(String value1, String value2) {
			addCriterion("COMP_NO not between", value1, value2, "compNo");
			return (Criteria) this;
		}

		public Criteria andDeptNoIsNull() {
			addCriterion("DEPT_NO is null");
			return (Criteria) this;
		}

		public Criteria andDeptNoIsNotNull() {
			addCriterion("DEPT_NO is not null");
			return (Criteria) this;
		}

		public Criteria andDeptNoEqualTo(String value) {
			addCriterion("DEPT_NO =", value, "deptNo");
			return (Criteria) this;
		}

		public Criteria andDeptNoNotEqualTo(String value) {
			addCriterion("DEPT_NO <>", value, "deptNo");
			return (Criteria) this;
		}

		public Criteria andDeptNoGreaterThan(String value) {
			addCriterion("DEPT_NO >", value, "deptNo");
			return (Criteria) this;
		}

		public Criteria andDeptNoGreaterThanOrEqualTo(String value) {
			addCriterion("DEPT_NO >=", value, "deptNo");
			return (Criteria) this;
		}

		public Criteria andDeptNoLessThan(String value) {
			addCriterion("DEPT_NO <", value, "deptNo");
			return (Criteria) this;
		}

		public Criteria andDeptNoLessThanOrEqualTo(String value) {
			addCriterion("DEPT_NO <=", value, "deptNo");
			return (Criteria) this;
		}

		public Criteria andDeptNoLike(String value) {
			addCriterion("DEPT_NO like", value, "deptNo");
			return (Criteria) this;
		}

		public Criteria andDeptNoNotLike(String value) {
			addCriterion("DEPT_NO not like", value, "deptNo");
			return (Criteria) this;
		}

		public Criteria andDeptNoIn(List<String> values) {
			addCriterion("DEPT_NO in", values, "deptNo");
			return (Criteria) this;
		}

		public Criteria andDeptNoNotIn(List<String> values) {
			addCriterion("DEPT_NO not in", values, "deptNo");
			return (Criteria) this;
		}

		public Criteria andDeptNoBetween(String value1, String value2) {
			addCriterion("DEPT_NO between", value1, value2, "deptNo");
			return (Criteria) this;
		}

		public Criteria andDeptNoNotBetween(String value1, String value2) {
			addCriterion("DEPT_NO not between", value1, value2, "deptNo");
			return (Criteria) this;
		}

		public Criteria andErpCompIdIsNull() {
			addCriterion("ERP_COMP_ID is null");
			return (Criteria) this;
		}

		public Criteria andErpCompIdIsNotNull() {
			addCriterion("ERP_COMP_ID is not null");
			return (Criteria) this;
		}

		public Criteria andErpCompIdEqualTo(Integer value) {
			addCriterion("ERP_COMP_ID =", value, "erpCompId");
			return (Criteria) this;
		}

		public Criteria andErpCompIdNotEqualTo(Integer value) {
			addCriterion("ERP_COMP_ID <>", value, "erpCompId");
			return (Criteria) this;
		}

		public Criteria andErpCompIdGreaterThan(Integer value) {
			addCriterion("ERP_COMP_ID >", value, "erpCompId");
			return (Criteria) this;
		}

		public Criteria andErpCompIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("ERP_COMP_ID >=", value, "erpCompId");
			return (Criteria) this;
		}

		public Criteria andErpCompIdLessThan(Integer value) {
			addCriterion("ERP_COMP_ID <", value, "erpCompId");
			return (Criteria) this;
		}

		public Criteria andErpCompIdLessThanOrEqualTo(Integer value) {
			addCriterion("ERP_COMP_ID <=", value, "erpCompId");
			return (Criteria) this;
		}

		public Criteria andErpCompIdIn(List<Integer> values) {
			addCriterion("ERP_COMP_ID in", values, "erpCompId");
			return (Criteria) this;
		}

		public Criteria andErpCompIdNotIn(List<Integer> values) {
			addCriterion("ERP_COMP_ID not in", values, "erpCompId");
			return (Criteria) this;
		}

		public Criteria andErpCompIdBetween(Integer value1, Integer value2) {
			addCriterion("ERP_COMP_ID between", value1, value2, "erpCompId");
			return (Criteria) this;
		}

		public Criteria andErpCompIdNotBetween(Integer value1, Integer value2) {
			addCriterion("ERP_COMP_ID not between", value1, value2, "erpCompId");
			return (Criteria) this;
		}

		public Criteria andErpDeptIdIsNull() {
			addCriterion("ERP_DEPT_ID is null");
			return (Criteria) this;
		}

		public Criteria andErpDeptIdIsNotNull() {
			addCriterion("ERP_DEPT_ID is not null");
			return (Criteria) this;
		}

		public Criteria andErpDeptIdEqualTo(Integer value) {
			addCriterion("ERP_DEPT_ID =", value, "erpDeptId");
			return (Criteria) this;
		}

		public Criteria andErpDeptIdNotEqualTo(Integer value) {
			addCriterion("ERP_DEPT_ID <>", value, "erpDeptId");
			return (Criteria) this;
		}

		public Criteria andErpDeptIdGreaterThan(Integer value) {
			addCriterion("ERP_DEPT_ID >", value, "erpDeptId");
			return (Criteria) this;
		}

		public Criteria andErpDeptIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("ERP_DEPT_ID >=", value, "erpDeptId");
			return (Criteria) this;
		}

		public Criteria andErpDeptIdLessThan(Integer value) {
			addCriterion("ERP_DEPT_ID <", value, "erpDeptId");
			return (Criteria) this;
		}

		public Criteria andErpDeptIdLessThanOrEqualTo(Integer value) {
			addCriterion("ERP_DEPT_ID <=", value, "erpDeptId");
			return (Criteria) this;
		}

		public Criteria andErpDeptIdIn(List<Integer> values) {
			addCriterion("ERP_DEPT_ID in", values, "erpDeptId");
			return (Criteria) this;
		}

		public Criteria andErpDeptIdNotIn(List<Integer> values) {
			addCriterion("ERP_DEPT_ID not in", values, "erpDeptId");
			return (Criteria) this;
		}

		public Criteria andErpDeptIdBetween(Integer value1, Integer value2) {
			addCriterion("ERP_DEPT_ID between", value1, value2, "erpDeptId");
			return (Criteria) this;
		}

		public Criteria andErpDeptIdNotBetween(Integer value1, Integer value2) {
			addCriterion("ERP_DEPT_ID not between", value1, value2, "erpDeptId");
			return (Criteria) this;
		}

		public Criteria andBrokerDeptNameIsNull() {
			addCriterion("BROKER_DEPT_NAME is null");
			return (Criteria) this;
		}

		public Criteria andBrokerDeptNameIsNotNull() {
			addCriterion("BROKER_DEPT_NAME is not null");
			return (Criteria) this;
		}

		public Criteria andBrokerDeptNameEqualTo(String value) {
			addCriterion("BROKER_DEPT_NAME =", value, "brokerDeptName");
			return (Criteria) this;
		}

		public Criteria andBrokerDeptNameNotEqualTo(String value) {
			addCriterion("BROKER_DEPT_NAME <>", value, "brokerDeptName");
			return (Criteria) this;
		}

		public Criteria andBrokerDeptNameGreaterThan(String value) {
			addCriterion("BROKER_DEPT_NAME >", value, "brokerDeptName");
			return (Criteria) this;
		}

		public Criteria andBrokerDeptNameGreaterThanOrEqualTo(String value) {
			addCriterion("BROKER_DEPT_NAME >=", value, "brokerDeptName");
			return (Criteria) this;
		}

		public Criteria andBrokerDeptNameLessThan(String value) {
			addCriterion("BROKER_DEPT_NAME <", value, "brokerDeptName");
			return (Criteria) this;
		}

		public Criteria andBrokerDeptNameLessThanOrEqualTo(String value) {
			addCriterion("BROKER_DEPT_NAME <=", value, "brokerDeptName");
			return (Criteria) this;
		}

		public Criteria andBrokerDeptNameLike(String value) {
			addCriterion("BROKER_DEPT_NAME like", value, "brokerDeptName");
			return (Criteria) this;
		}

		public Criteria andBrokerDeptNameNotLike(String value) {
			addCriterion("BROKER_DEPT_NAME not like", value, "brokerDeptName");
			return (Criteria) this;
		}

		public Criteria andBrokerDeptNameIn(List<String> values) {
			addCriterion("BROKER_DEPT_NAME in", values, "brokerDeptName");
			return (Criteria) this;
		}

		public Criteria andBrokerDeptNameNotIn(List<String> values) {
			addCriterion("BROKER_DEPT_NAME not in", values, "brokerDeptName");
			return (Criteria) this;
		}

		public Criteria andBrokerDeptNameBetween(String value1, String value2) {
			addCriterion("BROKER_DEPT_NAME between", value1, value2, "brokerDeptName");
			return (Criteria) this;
		}

		public Criteria andBrokerDeptNameNotBetween(String value1, String value2) {
			addCriterion("BROKER_DEPT_NAME not between", value1, value2, "brokerDeptName");
			return (Criteria) this;
		}

		public Criteria andBrokerRegNameIsNull() {
			addCriterion("BROKER_REG_NAME is null");
			return (Criteria) this;
		}

		public Criteria andBrokerRegNameIsNotNull() {
			addCriterion("BROKER_REG_NAME is not null");
			return (Criteria) this;
		}

		public Criteria andBrokerRegNameEqualTo(String value) {
			addCriterion("BROKER_REG_NAME =", value, "brokerRegName");
			return (Criteria) this;
		}

		public Criteria andBrokerRegNameNotEqualTo(String value) {
			addCriterion("BROKER_REG_NAME <>", value, "brokerRegName");
			return (Criteria) this;
		}

		public Criteria andBrokerRegNameGreaterThan(String value) {
			addCriterion("BROKER_REG_NAME >", value, "brokerRegName");
			return (Criteria) this;
		}

		public Criteria andBrokerRegNameGreaterThanOrEqualTo(String value) {
			addCriterion("BROKER_REG_NAME >=", value, "brokerRegName");
			return (Criteria) this;
		}

		public Criteria andBrokerRegNameLessThan(String value) {
			addCriterion("BROKER_REG_NAME <", value, "brokerRegName");
			return (Criteria) this;
		}

		public Criteria andBrokerRegNameLessThanOrEqualTo(String value) {
			addCriterion("BROKER_REG_NAME <=", value, "brokerRegName");
			return (Criteria) this;
		}

		public Criteria andBrokerRegNameLike(String value) {
			addCriterion("BROKER_REG_NAME like", value, "brokerRegName");
			return (Criteria) this;
		}

		public Criteria andBrokerRegNameNotLike(String value) {
			addCriterion("BROKER_REG_NAME not like", value, "brokerRegName");
			return (Criteria) this;
		}

		public Criteria andBrokerRegNameIn(List<String> values) {
			addCriterion("BROKER_REG_NAME in", values, "brokerRegName");
			return (Criteria) this;
		}

		public Criteria andBrokerRegNameNotIn(List<String> values) {
			addCriterion("BROKER_REG_NAME not in", values, "brokerRegName");
			return (Criteria) this;
		}

		public Criteria andBrokerRegNameBetween(String value1, String value2) {
			addCriterion("BROKER_REG_NAME between", value1, value2, "brokerRegName");
			return (Criteria) this;
		}

		public Criteria andBrokerRegNameNotBetween(String value1, String value2) {
			addCriterion("BROKER_REG_NAME not between", value1, value2, "brokerRegName");
			return (Criteria) this;
		}

		public Criteria andBrokerRegIdIsNull() {
			addCriterion("BROKER_REG_ID is null");
			return (Criteria) this;
		}

		public Criteria andBrokerRegIdIsNotNull() {
			addCriterion("BROKER_REG_ID is not null");
			return (Criteria) this;
		}

		public Criteria andBrokerRegIdEqualTo(Integer value) {
			addCriterion("BROKER_REG_ID =", value, "brokerRegId");
			return (Criteria) this;
		}

		public Criteria andBrokerRegIdNotEqualTo(Integer value) {
			addCriterion("BROKER_REG_ID <>", value, "brokerRegId");
			return (Criteria) this;
		}

		public Criteria andBrokerRegIdGreaterThan(Integer value) {
			addCriterion("BROKER_REG_ID >", value, "brokerRegId");
			return (Criteria) this;
		}

		public Criteria andBrokerRegIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("BROKER_REG_ID >=", value, "brokerRegId");
			return (Criteria) this;
		}

		public Criteria andBrokerRegIdLessThan(Integer value) {
			addCriterion("BROKER_REG_ID <", value, "brokerRegId");
			return (Criteria) this;
		}

		public Criteria andBrokerRegIdLessThanOrEqualTo(Integer value) {
			addCriterion("BROKER_REG_ID <=", value, "brokerRegId");
			return (Criteria) this;
		}

		public Criteria andBrokerRegIdIn(List<Integer> values) {
			addCriterion("BROKER_REG_ID in", values, "brokerRegId");
			return (Criteria) this;
		}

		public Criteria andBrokerRegIdNotIn(List<Integer> values) {
			addCriterion("BROKER_REG_ID not in", values, "brokerRegId");
			return (Criteria) this;
		}

		public Criteria andBrokerRegIdBetween(Integer value1, Integer value2) {
			addCriterion("BROKER_REG_ID between", value1, value2, "brokerRegId");
			return (Criteria) this;
		}

		public Criteria andBrokerRegIdNotBetween(Integer value1, Integer value2) {
			addCriterion("BROKER_REG_ID not between", value1, value2, "brokerRegId");
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

		public Criteria andBrokerUserNameIsNull() {
			addCriterion("BROKER_USER_NAME is null");
			return (Criteria) this;
		}

		public Criteria andBrokerUserNameIsNotNull() {
			addCriterion("BROKER_USER_NAME is not null");
			return (Criteria) this;
		}

		public Criteria andBrokerUserNameEqualTo(String value) {
			addCriterion("BROKER_USER_NAME =", value, "brokerUserName");
			return (Criteria) this;
		}

		public Criteria andBrokerUserNameNotEqualTo(String value) {
			addCriterion("BROKER_USER_NAME <>", value, "brokerUserName");
			return (Criteria) this;
		}

		public Criteria andBrokerUserNameGreaterThan(String value) {
			addCriterion("BROKER_USER_NAME >", value, "brokerUserName");
			return (Criteria) this;
		}

		public Criteria andBrokerUserNameGreaterThanOrEqualTo(String value) {
			addCriterion("BROKER_USER_NAME >=", value, "brokerUserName");
			return (Criteria) this;
		}

		public Criteria andBrokerUserNameLessThan(String value) {
			addCriterion("BROKER_USER_NAME <", value, "brokerUserName");
			return (Criteria) this;
		}

		public Criteria andBrokerUserNameLessThanOrEqualTo(String value) {
			addCriterion("BROKER_USER_NAME <=", value, "brokerUserName");
			return (Criteria) this;
		}

		public Criteria andBrokerUserNameLike(String value) {
			addCriterion("BROKER_USER_NAME like", value, "brokerUserName");
			return (Criteria) this;
		}

		public Criteria andBrokerUserNameNotLike(String value) {
			addCriterion("BROKER_USER_NAME not like", value, "brokerUserName");
			return (Criteria) this;
		}

		public Criteria andBrokerUserNameIn(List<String> values) {
			addCriterion("BROKER_USER_NAME in", values, "brokerUserName");
			return (Criteria) this;
		}

		public Criteria andBrokerUserNameNotIn(List<String> values) {
			addCriterion("BROKER_USER_NAME not in", values, "brokerUserName");
			return (Criteria) this;
		}

		public Criteria andBrokerUserNameBetween(String value1, String value2) {
			addCriterion("BROKER_USER_NAME between", value1, value2, "brokerUserName");
			return (Criteria) this;
		}

		public Criteria andBrokerUserNameNotBetween(String value1, String value2) {
			addCriterion("BROKER_USER_NAME not between", value1, value2, "brokerUserName");
			return (Criteria) this;
		}

		public Criteria andBrokerUserMobileIsNull() {
			addCriterion("BROKER_USER_MOBILE is null");
			return (Criteria) this;
		}

		public Criteria andBrokerUserMobileIsNotNull() {
			addCriterion("BROKER_USER_MOBILE is not null");
			return (Criteria) this;
		}

		public Criteria andBrokerUserMobileEqualTo(String value) {
			addCriterion("BROKER_USER_MOBILE =", value, "brokerUserMobile");
			return (Criteria) this;
		}

		public Criteria andBrokerUserMobileNotEqualTo(String value) {
			addCriterion("BROKER_USER_MOBILE <>", value, "brokerUserMobile");
			return (Criteria) this;
		}

		public Criteria andBrokerUserMobileGreaterThan(String value) {
			addCriterion("BROKER_USER_MOBILE >", value, "brokerUserMobile");
			return (Criteria) this;
		}

		public Criteria andBrokerUserMobileGreaterThanOrEqualTo(String value) {
			addCriterion("BROKER_USER_MOBILE >=", value, "brokerUserMobile");
			return (Criteria) this;
		}

		public Criteria andBrokerUserMobileLessThan(String value) {
			addCriterion("BROKER_USER_MOBILE <", value, "brokerUserMobile");
			return (Criteria) this;
		}

		public Criteria andBrokerUserMobileLessThanOrEqualTo(String value) {
			addCriterion("BROKER_USER_MOBILE <=", value, "brokerUserMobile");
			return (Criteria) this;
		}

		public Criteria andBrokerUserMobileLike(String value) {
			addCriterion("BROKER_USER_MOBILE like", value, "brokerUserMobile");
			return (Criteria) this;
		}

		public Criteria andBrokerUserMobileNotLike(String value) {
			addCriterion("BROKER_USER_MOBILE not like", value, "brokerUserMobile");
			return (Criteria) this;
		}

		public Criteria andBrokerUserMobileIn(List<String> values) {
			addCriterion("BROKER_USER_MOBILE in", values, "brokerUserMobile");
			return (Criteria) this;
		}

		public Criteria andBrokerUserMobileNotIn(List<String> values) {
			addCriterion("BROKER_USER_MOBILE not in", values, "brokerUserMobile");
			return (Criteria) this;
		}

		public Criteria andBrokerUserMobileBetween(String value1, String value2) {
			addCriterion("BROKER_USER_MOBILE between", value1, value2, "brokerUserMobile");
			return (Criteria) this;
		}

		public Criteria andBrokerUserMobileNotBetween(String value1, String value2) {
			addCriterion("BROKER_USER_MOBILE not between", value1, value2, "brokerUserMobile");
			return (Criteria) this;
		}

		public Criteria andFinanceNoIsNull() {
			addCriterion("FINANCE_NO is null");
			return (Criteria) this;
		}

		public Criteria andFinanceNoIsNotNull() {
			addCriterion("FINANCE_NO is not null");
			return (Criteria) this;
		}

		public Criteria andFinanceNoEqualTo(String value) {
			addCriterion("FINANCE_NO =", value, "financeNo");
			return (Criteria) this;
		}

		public Criteria andFinanceNoNotEqualTo(String value) {
			addCriterion("FINANCE_NO <>", value, "financeNo");
			return (Criteria) this;
		}

		public Criteria andFinanceNoGreaterThan(String value) {
			addCriterion("FINANCE_NO >", value, "financeNo");
			return (Criteria) this;
		}

		public Criteria andFinanceNoGreaterThanOrEqualTo(String value) {
			addCriterion("FINANCE_NO >=", value, "financeNo");
			return (Criteria) this;
		}

		public Criteria andFinanceNoLessThan(String value) {
			addCriterion("FINANCE_NO <", value, "financeNo");
			return (Criteria) this;
		}

		public Criteria andFinanceNoLessThanOrEqualTo(String value) {
			addCriterion("FINANCE_NO <=", value, "financeNo");
			return (Criteria) this;
		}

		public Criteria andFinanceNoLike(String value) {
			addCriterion("FINANCE_NO like", value, "financeNo");
			return (Criteria) this;
		}

		public Criteria andFinanceNoNotLike(String value) {
			addCriterion("FINANCE_NO not like", value, "financeNo");
			return (Criteria) this;
		}

		public Criteria andFinanceNoIn(List<String> values) {
			addCriterion("FINANCE_NO in", values, "financeNo");
			return (Criteria) this;
		}

		public Criteria andFinanceNoNotIn(List<String> values) {
			addCriterion("FINANCE_NO not in", values, "financeNo");
			return (Criteria) this;
		}

		public Criteria andFinanceNoBetween(String value1, String value2) {
			addCriterion("FINANCE_NO between", value1, value2, "financeNo");
			return (Criteria) this;
		}

		public Criteria andFinanceNoNotBetween(String value1, String value2) {
			addCriterion("FINANCE_NO not between", value1, value2, "financeNo");
			return (Criteria) this;
		}

		public Criteria andCrmAuditIsNull() {
			addCriterion("CRM_AUDIT is null");
			return (Criteria) this;
		}

		public Criteria andCrmAuditIsNotNull() {
			addCriterion("CRM_AUDIT is not null");
			return (Criteria) this;
		}

		public Criteria andCrmAuditEqualTo(Byte value) {
			addCriterion("CRM_AUDIT =", value, "crmAudit");
			return (Criteria) this;
		}

		public Criteria andCrmAuditNotEqualTo(Byte value) {
			addCriterion("CRM_AUDIT <>", value, "crmAudit");
			return (Criteria) this;
		}

		public Criteria andCrmAuditGreaterThan(Byte value) {
			addCriterion("CRM_AUDIT >", value, "crmAudit");
			return (Criteria) this;
		}

		public Criteria andCrmAuditGreaterThanOrEqualTo(Byte value) {
			addCriterion("CRM_AUDIT >=", value, "crmAudit");
			return (Criteria) this;
		}

		public Criteria andCrmAuditLessThan(Byte value) {
			addCriterion("CRM_AUDIT <", value, "crmAudit");
			return (Criteria) this;
		}

		public Criteria andCrmAuditLessThanOrEqualTo(Byte value) {
			addCriterion("CRM_AUDIT <=", value, "crmAudit");
			return (Criteria) this;
		}

		public Criteria andCrmAuditIn(List<Byte> values) {
			addCriterion("CRM_AUDIT in", values, "crmAudit");
			return (Criteria) this;
		}

		public Criteria andCrmAuditNotIn(List<Byte> values) {
			addCriterion("CRM_AUDIT not in", values, "crmAudit");
			return (Criteria) this;
		}

		public Criteria andCrmAuditBetween(Byte value1, Byte value2) {
			addCriterion("CRM_AUDIT between", value1, value2, "crmAudit");
			return (Criteria) this;
		}

		public Criteria andCrmAuditNotBetween(Byte value1, Byte value2) {
			addCriterion("CRM_AUDIT not between", value1, value2, "crmAudit");
			return (Criteria) this;
		}

		public Criteria andErpAuditIsNull() {
			addCriterion("ERP_AUDIT is null");
			return (Criteria) this;
		}

		public Criteria andErpAuditIsNotNull() {
			addCriterion("ERP_AUDIT is not null");
			return (Criteria) this;
		}

		public Criteria andErpAuditEqualTo(Byte value) {
			addCriterion("ERP_AUDIT =", value, "erpAudit");
			return (Criteria) this;
		}

		public Criteria andErpAuditNotEqualTo(Byte value) {
			addCriterion("ERP_AUDIT <>", value, "erpAudit");
			return (Criteria) this;
		}

		public Criteria andErpAuditGreaterThan(Byte value) {
			addCriterion("ERP_AUDIT >", value, "erpAudit");
			return (Criteria) this;
		}

		public Criteria andErpAuditGreaterThanOrEqualTo(Byte value) {
			addCriterion("ERP_AUDIT >=", value, "erpAudit");
			return (Criteria) this;
		}

		public Criteria andErpAuditLessThan(Byte value) {
			addCriterion("ERP_AUDIT <", value, "erpAudit");
			return (Criteria) this;
		}

		public Criteria andErpAuditLessThanOrEqualTo(Byte value) {
			addCriterion("ERP_AUDIT <=", value, "erpAudit");
			return (Criteria) this;
		}

		public Criteria andErpAuditIn(List<Byte> values) {
			addCriterion("ERP_AUDIT in", values, "erpAudit");
			return (Criteria) this;
		}

		public Criteria andErpAuditNotIn(List<Byte> values) {
			addCriterion("ERP_AUDIT not in", values, "erpAudit");
			return (Criteria) this;
		}

		public Criteria andErpAuditBetween(Byte value1, Byte value2) {
			addCriterion("ERP_AUDIT between", value1, value2, "erpAudit");
			return (Criteria) this;
		}

		public Criteria andErpAuditNotBetween(Byte value1, Byte value2) {
			addCriterion("ERP_AUDIT not between", value1, value2, "erpAudit");
			return (Criteria) this;
		}

		public Criteria andFinanceStatusIsNull() {
			addCriterion("FINANCE_STATUS is null");
			return (Criteria) this;
		}

		public Criteria andFinanceStatusIsNotNull() {
			addCriterion("FINANCE_STATUS is not null");
			return (Criteria) this;
		}

		public Criteria andFinanceStatusEqualTo(Integer value) {
			addCriterion("FINANCE_STATUS =", value, "financeStatus");
			return (Criteria) this;
		}

		public Criteria andFinanceStatusNotEqualTo(Integer value) {
			addCriterion("FINANCE_STATUS <>", value, "financeStatus");
			return (Criteria) this;
		}

		public Criteria andFinanceStatusGreaterThan(Integer value) {
			addCriterion("FINANCE_STATUS >", value, "financeStatus");
			return (Criteria) this;
		}

		public Criteria andFinanceStatusGreaterThanOrEqualTo(Integer value) {
			addCriterion("FINANCE_STATUS >=", value, "financeStatus");
			return (Criteria) this;
		}

		public Criteria andFinanceStatusLessThan(Integer value) {
			addCriterion("FINANCE_STATUS <", value, "financeStatus");
			return (Criteria) this;
		}

		public Criteria andFinanceStatusLessThanOrEqualTo(Integer value) {
			addCriterion("FINANCE_STATUS <=", value, "financeStatus");
			return (Criteria) this;
		}

		public Criteria andFinanceStatusIn(List<Integer> values) {
			addCriterion("FINANCE_STATUS in", values, "financeStatus");
			return (Criteria) this;
		}

		public Criteria andFinanceStatusNotIn(List<Integer> values) {
			addCriterion("FINANCE_STATUS not in", values, "financeStatus");
			return (Criteria) this;
		}

		public Criteria andFinanceStatusBetween(Integer value1, Integer value2) {
			addCriterion("FINANCE_STATUS between", value1, value2, "financeStatus");
			return (Criteria) this;
		}

		public Criteria andFinanceStatusNotBetween(Integer value1, Integer value2) {
			addCriterion("FINANCE_STATUS not between", value1, value2, "financeStatus");
			return (Criteria) this;
		}

		public Criteria andCustTypeIsNull() {
			addCriterion("CUST_TYPE is null");
			return (Criteria) this;
		}

		public Criteria andCustTypeIsNotNull() {
			addCriterion("CUST_TYPE is not null");
			return (Criteria) this;
		}

		public Criteria andCustTypeEqualTo(Byte value) {
			addCriterion("CUST_TYPE =", value, "custType");
			return (Criteria) this;
		}

		public Criteria andCustTypeNotEqualTo(Byte value) {
			addCriterion("CUST_TYPE <>", value, "custType");
			return (Criteria) this;
		}

		public Criteria andCustTypeGreaterThan(Byte value) {
			addCriterion("CUST_TYPE >", value, "custType");
			return (Criteria) this;
		}

		public Criteria andCustTypeGreaterThanOrEqualTo(Byte value) {
			addCriterion("CUST_TYPE >=", value, "custType");
			return (Criteria) this;
		}

		public Criteria andCustTypeLessThan(Byte value) {
			addCriterion("CUST_TYPE <", value, "custType");
			return (Criteria) this;
		}

		public Criteria andCustTypeLessThanOrEqualTo(Byte value) {
			addCriterion("CUST_TYPE <=", value, "custType");
			return (Criteria) this;
		}

		public Criteria andCustTypeIn(List<Byte> values) {
			addCriterion("CUST_TYPE in", values, "custType");
			return (Criteria) this;
		}

		public Criteria andCustTypeNotIn(List<Byte> values) {
			addCriterion("CUST_TYPE not in", values, "custType");
			return (Criteria) this;
		}

		public Criteria andCustTypeBetween(Byte value1, Byte value2) {
			addCriterion("CUST_TYPE between", value1, value2, "custType");
			return (Criteria) this;
		}

		public Criteria andCustTypeNotBetween(Byte value1, Byte value2) {
			addCriterion("CUST_TYPE not between", value1, value2, "custType");
			return (Criteria) this;
		}

		public Criteria andSourceIsNull() {
			addCriterion("[SOURCE] is null");
			return (Criteria) this;
		}

		public Criteria andSourceIsNotNull() {
			addCriterion("[SOURCE] is not null");
			return (Criteria) this;
		}

		public Criteria andSourceEqualTo(Byte value) {
			addCriterion("[SOURCE] =", value, "source");
			return (Criteria) this;
		}

		public Criteria andSourceNotEqualTo(Byte value) {
			addCriterion("[SOURCE] <>", value, "source");
			return (Criteria) this;
		}

		public Criteria andSourceGreaterThan(Byte value) {
			addCriterion("[SOURCE] >", value, "source");
			return (Criteria) this;
		}

		public Criteria andSourceGreaterThanOrEqualTo(Byte value) {
			addCriterion("[SOURCE] >=", value, "source");
			return (Criteria) this;
		}

		public Criteria andSourceLessThan(Byte value) {
			addCriterion("[SOURCE] <", value, "source");
			return (Criteria) this;
		}

		public Criteria andSourceLessThanOrEqualTo(Byte value) {
			addCriterion("[SOURCE] <=", value, "source");
			return (Criteria) this;
		}

		public Criteria andSourceIn(List<Byte> values) {
			addCriterion("[SOURCE] in", values, "source");
			return (Criteria) this;
		}

		public Criteria andSourceNotIn(List<Byte> values) {
			addCriterion("[SOURCE] not in", values, "source");
			return (Criteria) this;
		}

		public Criteria andSourceBetween(Byte value1, Byte value2) {
			addCriterion("[SOURCE] between", value1, value2, "source");
			return (Criteria) this;
		}

		public Criteria andSourceNotBetween(Byte value1, Byte value2) {
			addCriterion("[SOURCE] not between", value1, value2, "source");
			return (Criteria) this;
		}

		public Criteria andCreateUserIdIsNull() {
			addCriterion("CREATE_USER_ID is null");
			return (Criteria) this;
		}

		public Criteria andCreateUserIdIsNotNull() {
			addCriterion("CREATE_USER_ID is not null");
			return (Criteria) this;
		}

		public Criteria andCreateUserIdEqualTo(Integer value) {
			addCriterion("CREATE_USER_ID =", value, "createUserId");
			return (Criteria) this;
		}

		public Criteria andCreateUserIdNotEqualTo(Integer value) {
			addCriterion("CREATE_USER_ID <>", value, "createUserId");
			return (Criteria) this;
		}

		public Criteria andCreateUserIdGreaterThan(Integer value) {
			addCriterion("CREATE_USER_ID >", value, "createUserId");
			return (Criteria) this;
		}

		public Criteria andCreateUserIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("CREATE_USER_ID >=", value, "createUserId");
			return (Criteria) this;
		}

		public Criteria andCreateUserIdLessThan(Integer value) {
			addCriterion("CREATE_USER_ID <", value, "createUserId");
			return (Criteria) this;
		}

		public Criteria andCreateUserIdLessThanOrEqualTo(Integer value) {
			addCriterion("CREATE_USER_ID <=", value, "createUserId");
			return (Criteria) this;
		}

		public Criteria andCreateUserIdIn(List<Integer> values) {
			addCriterion("CREATE_USER_ID in", values, "createUserId");
			return (Criteria) this;
		}

		public Criteria andCreateUserIdNotIn(List<Integer> values) {
			addCriterion("CREATE_USER_ID not in", values, "createUserId");
			return (Criteria) this;
		}

		public Criteria andCreateUserIdBetween(Integer value1, Integer value2) {
			addCriterion("CREATE_USER_ID between", value1, value2, "createUserId");
			return (Criteria) this;
		}

		public Criteria andCreateUserIdNotBetween(Integer value1, Integer value2) {
			addCriterion("CREATE_USER_ID not between", value1, value2, "createUserId");
			return (Criteria) this;
		}

		public Criteria andCreateUserNameIsNull() {
			addCriterion("CREATE_USER_NAME is null");
			return (Criteria) this;
		}

		public Criteria andCreateUserNameIsNotNull() {
			addCriterion("CREATE_USER_NAME is not null");
			return (Criteria) this;
		}

		public Criteria andCreateUserNameEqualTo(String value) {
			addCriterion("CREATE_USER_NAME =", value, "createUserName");
			return (Criteria) this;
		}

		public Criteria andCreateUserNameNotEqualTo(String value) {
			addCriterion("CREATE_USER_NAME <>", value, "createUserName");
			return (Criteria) this;
		}

		public Criteria andCreateUserNameGreaterThan(String value) {
			addCriterion("CREATE_USER_NAME >", value, "createUserName");
			return (Criteria) this;
		}

		public Criteria andCreateUserNameGreaterThanOrEqualTo(String value) {
			addCriterion("CREATE_USER_NAME >=", value, "createUserName");
			return (Criteria) this;
		}

		public Criteria andCreateUserNameLessThan(String value) {
			addCriterion("CREATE_USER_NAME <", value, "createUserName");
			return (Criteria) this;
		}

		public Criteria andCreateUserNameLessThanOrEqualTo(String value) {
			addCriterion("CREATE_USER_NAME <=", value, "createUserName");
			return (Criteria) this;
		}

		public Criteria andCreateUserNameLike(String value) {
			addCriterion("CREATE_USER_NAME like", value, "createUserName");
			return (Criteria) this;
		}

		public Criteria andCreateUserNameNotLike(String value) {
			addCriterion("CREATE_USER_NAME not like", value, "createUserName");
			return (Criteria) this;
		}

		public Criteria andCreateUserNameIn(List<String> values) {
			addCriterion("CREATE_USER_NAME in", values, "createUserName");
			return (Criteria) this;
		}

		public Criteria andCreateUserNameNotIn(List<String> values) {
			addCriterion("CREATE_USER_NAME not in", values, "createUserName");
			return (Criteria) this;
		}

		public Criteria andCreateUserNameBetween(String value1, String value2) {
			addCriterion("CREATE_USER_NAME between", value1, value2, "createUserName");
			return (Criteria) this;
		}

		public Criteria andCreateUserNameNotBetween(String value1, String value2) {
			addCriterion("CREATE_USER_NAME not between", value1, value2, "createUserName");
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

		public Criteria andFitmentStatusIsNull() {
			addCriterion("FITMENT_STATUS is null");
			return (Criteria) this;
		}

		public Criteria andFitmentStatusIsNotNull() {
			addCriterion("FITMENT_STATUS is not null");
			return (Criteria) this;
		}

		public Criteria andFitmentStatusEqualTo(Byte value) {
			addCriterion("FITMENT_STATUS =", value, "fitmentStatus");
			return (Criteria) this;
		}

		public Criteria andFitmentStatusNotEqualTo(Byte value) {
			addCriterion("FITMENT_STATUS <>", value, "fitmentStatus");
			return (Criteria) this;
		}

		public Criteria andFitmentStatusGreaterThan(Byte value) {
			addCriterion("FITMENT_STATUS >", value, "fitmentStatus");
			return (Criteria) this;
		}

		public Criteria andFitmentStatusGreaterThanOrEqualTo(Byte value) {
			addCriterion("FITMENT_STATUS >=", value, "fitmentStatus");
			return (Criteria) this;
		}

		public Criteria andFitmentStatusLessThan(Byte value) {
			addCriterion("FITMENT_STATUS <", value, "fitmentStatus");
			return (Criteria) this;
		}

		public Criteria andFitmentStatusLessThanOrEqualTo(Byte value) {
			addCriterion("FITMENT_STATUS <=", value, "fitmentStatus");
			return (Criteria) this;
		}

		public Criteria andFitmentStatusIn(List<Byte> values) {
			addCriterion("FITMENT_STATUS in", values, "fitmentStatus");
			return (Criteria) this;
		}

		public Criteria andFitmentStatusNotIn(List<Byte> values) {
			addCriterion("FITMENT_STATUS not in", values, "fitmentStatus");
			return (Criteria) this;
		}

		public Criteria andFitmentStatusBetween(Byte value1, Byte value2) {
			addCriterion("FITMENT_STATUS between", value1, value2, "fitmentStatus");
			return (Criteria) this;
		}

		public Criteria andFitmentStatusNotBetween(Byte value1, Byte value2) {
			addCriterion("FITMENT_STATUS not between", value1, value2, "fitmentStatus");
			return (Criteria) this;
		}

		public Criteria andHouseYearsIsNull() {
			addCriterion("HOUSE_YEARS is null");
			return (Criteria) this;
		}

		public Criteria andHouseYearsIsNotNull() {
			addCriterion("HOUSE_YEARS is not null");
			return (Criteria) this;
		}

		public Criteria andHouseYearsEqualTo(String value) {
			addCriterion("HOUSE_YEARS =", value, "houseYears");
			return (Criteria) this;
		}

		public Criteria andHouseYearsNotEqualTo(String value) {
			addCriterion("HOUSE_YEARS <>", value, "houseYears");
			return (Criteria) this;
		}

		public Criteria andHouseYearsGreaterThan(String value) {
			addCriterion("HOUSE_YEARS >", value, "houseYears");
			return (Criteria) this;
		}

		public Criteria andHouseYearsGreaterThanOrEqualTo(String value) {
			addCriterion("HOUSE_YEARS >=", value, "houseYears");
			return (Criteria) this;
		}

		public Criteria andHouseYearsLessThan(String value) {
			addCriterion("HOUSE_YEARS <", value, "houseYears");
			return (Criteria) this;
		}

		public Criteria andHouseYearsLessThanOrEqualTo(String value) {
			addCriterion("HOUSE_YEARS <=", value, "houseYears");
			return (Criteria) this;
		}

		public Criteria andHouseYearsLike(String value) {
			addCriterion("HOUSE_YEARS like", value, "houseYears");
			return (Criteria) this;
		}

		public Criteria andHouseYearsNotLike(String value) {
			addCriterion("HOUSE_YEARS not like", value, "houseYears");
			return (Criteria) this;
		}

		public Criteria andHouseYearsIn(List<String> values) {
			addCriterion("HOUSE_YEARS in", values, "houseYears");
			return (Criteria) this;
		}

		public Criteria andHouseYearsNotIn(List<String> values) {
			addCriterion("HOUSE_YEARS not in", values, "houseYears");
			return (Criteria) this;
		}

		public Criteria andHouseYearsBetween(String value1, String value2) {
			addCriterion("HOUSE_YEARS between", value1, value2, "houseYears");
			return (Criteria) this;
		}

		public Criteria andHouseYearsNotBetween(String value1, String value2) {
			addCriterion("HOUSE_YEARS not between", value1, value2, "houseYears");
			return (Criteria) this;
		}

		public Criteria andAssessAmountIsNull() {
			addCriterion("ASSESS_AMOUNT is null");
			return (Criteria) this;
		}

		public Criteria andAssessAmountIsNotNull() {
			addCriterion("ASSESS_AMOUNT is not null");
			return (Criteria) this;
		}

		public Criteria andAssessAmountEqualTo(BigDecimal value) {
			addCriterion("ASSESS_AMOUNT =", value, "assessAmount");
			return (Criteria) this;
		}

		public Criteria andAssessAmountNotEqualTo(BigDecimal value) {
			addCriterion("ASSESS_AMOUNT <>", value, "assessAmount");
			return (Criteria) this;
		}

		public Criteria andAssessAmountGreaterThan(BigDecimal value) {
			addCriterion("ASSESS_AMOUNT >", value, "assessAmount");
			return (Criteria) this;
		}

		public Criteria andAssessAmountGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("ASSESS_AMOUNT >=", value, "assessAmount");
			return (Criteria) this;
		}

		public Criteria andAssessAmountLessThan(BigDecimal value) {
			addCriterion("ASSESS_AMOUNT <", value, "assessAmount");
			return (Criteria) this;
		}

		public Criteria andAssessAmountLessThanOrEqualTo(BigDecimal value) {
			addCriterion("ASSESS_AMOUNT <=", value, "assessAmount");
			return (Criteria) this;
		}

		public Criteria andAssessAmountIn(List<BigDecimal> values) {
			addCriterion("ASSESS_AMOUNT in", values, "assessAmount");
			return (Criteria) this;
		}

		public Criteria andAssessAmountNotIn(List<BigDecimal> values) {
			addCriterion("ASSESS_AMOUNT not in", values, "assessAmount");
			return (Criteria) this;
		}

		public Criteria andAssessAmountBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("ASSESS_AMOUNT between", value1, value2, "assessAmount");
			return (Criteria) this;
		}

		public Criteria andAssessAmountNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("ASSESS_AMOUNT not between", value1, value2, "assessAmount");
			return (Criteria) this;
		}

		public Criteria andAssessedDateIsNull() {
			addCriterion("ASSESSED_DATE is null");
			return (Criteria) this;
		}

		public Criteria andAssessedDateIsNotNull() {
			addCriterion("ASSESSED_DATE is not null");
			return (Criteria) this;
		}

		public Criteria andAssessedDateEqualTo(Date value) {
			addCriterion("ASSESSED_DATE =", value, "assessedDate");
			return (Criteria) this;
		}

		public Criteria andAssessedDateNotEqualTo(Date value) {
			addCriterion("ASSESSED_DATE <>", value, "assessedDate");
			return (Criteria) this;
		}

		public Criteria andAssessedDateGreaterThan(Date value) {
			addCriterion("ASSESSED_DATE >", value, "assessedDate");
			return (Criteria) this;
		}

		public Criteria andAssessedDateGreaterThanOrEqualTo(Date value) {
			addCriterion("ASSESSED_DATE >=", value, "assessedDate");
			return (Criteria) this;
		}

		public Criteria andAssessedDateLessThan(Date value) {
			addCriterion("ASSESSED_DATE <", value, "assessedDate");
			return (Criteria) this;
		}

		public Criteria andAssessedDateLessThanOrEqualTo(Date value) {
			addCriterion("ASSESSED_DATE <=", value, "assessedDate");
			return (Criteria) this;
		}

		public Criteria andAssessedDateIn(List<Date> values) {
			addCriterion("ASSESSED_DATE in", values, "assessedDate");
			return (Criteria) this;
		}

		public Criteria andAssessedDateNotIn(List<Date> values) {
			addCriterion("ASSESSED_DATE not in", values, "assessedDate");
			return (Criteria) this;
		}

		public Criteria andAssessedDateBetween(Date value1, Date value2) {
			addCriterion("ASSESSED_DATE between", value1, value2, "assessedDate");
			return (Criteria) this;
		}

		public Criteria andAssessedDateNotBetween(Date value1, Date value2) {
			addCriterion("ASSESSED_DATE not between", value1, value2, "assessedDate");
			return (Criteria) this;
		}

		public Criteria andIfAdjustIsNull() {
			addCriterion("IF_ADJUST is null");
			return (Criteria) this;
		}

		public Criteria andIfAdjustIsNotNull() {
			addCriterion("IF_ADJUST is not null");
			return (Criteria) this;
		}

		public Criteria andIfAdjustEqualTo(Byte value) {
			addCriterion("IF_ADJUST =", value, "ifAdjust");
			return (Criteria) this;
		}

		public Criteria andIfAdjustNotEqualTo(Byte value) {
			addCriterion("IF_ADJUST <>", value, "ifAdjust");
			return (Criteria) this;
		}

		public Criteria andIfAdjustGreaterThan(Byte value) {
			addCriterion("IF_ADJUST >", value, "ifAdjust");
			return (Criteria) this;
		}

		public Criteria andIfAdjustGreaterThanOrEqualTo(Byte value) {
			addCriterion("IF_ADJUST >=", value, "ifAdjust");
			return (Criteria) this;
		}

		public Criteria andIfAdjustLessThan(Byte value) {
			addCriterion("IF_ADJUST <", value, "ifAdjust");
			return (Criteria) this;
		}

		public Criteria andIfAdjustLessThanOrEqualTo(Byte value) {
			addCriterion("IF_ADJUST <=", value, "ifAdjust");
			return (Criteria) this;
		}

		public Criteria andIfAdjustIn(List<Byte> values) {
			addCriterion("IF_ADJUST in", values, "ifAdjust");
			return (Criteria) this;
		}

		public Criteria andIfAdjustNotIn(List<Byte> values) {
			addCriterion("IF_ADJUST not in", values, "ifAdjust");
			return (Criteria) this;
		}

		public Criteria andIfAdjustBetween(Byte value1, Byte value2) {
			addCriterion("IF_ADJUST between", value1, value2, "ifAdjust");
			return (Criteria) this;
		}

		public Criteria andIfAdjustNotBetween(Byte value1, Byte value2) {
			addCriterion("IF_ADJUST not between", value1, value2, "ifAdjust");
			return (Criteria) this;
		}

		public Criteria andAdjustedPriceIsNull() {
			addCriterion("ADJUSTED_PRICE is null");
			return (Criteria) this;
		}

		public Criteria andAdjustedPriceIsNotNull() {
			addCriterion("ADJUSTED_PRICE is not null");
			return (Criteria) this;
		}

		public Criteria andAdjustedPriceEqualTo(BigDecimal value) {
			addCriterion("ADJUSTED_PRICE =", value, "adjustedPrice");
			return (Criteria) this;
		}

		public Criteria andAdjustedPriceNotEqualTo(BigDecimal value) {
			addCriterion("ADJUSTED_PRICE <>", value, "adjustedPrice");
			return (Criteria) this;
		}

		public Criteria andAdjustedPriceGreaterThan(BigDecimal value) {
			addCriterion("ADJUSTED_PRICE >", value, "adjustedPrice");
			return (Criteria) this;
		}

		public Criteria andAdjustedPriceGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("ADJUSTED_PRICE >=", value, "adjustedPrice");
			return (Criteria) this;
		}

		public Criteria andAdjustedPriceLessThan(BigDecimal value) {
			addCriterion("ADJUSTED_PRICE <", value, "adjustedPrice");
			return (Criteria) this;
		}

		public Criteria andAdjustedPriceLessThanOrEqualTo(BigDecimal value) {
			addCriterion("ADJUSTED_PRICE <=", value, "adjustedPrice");
			return (Criteria) this;
		}

		public Criteria andAdjustedPriceIn(List<BigDecimal> values) {
			addCriterion("ADJUSTED_PRICE in", values, "adjustedPrice");
			return (Criteria) this;
		}

		public Criteria andAdjustedPriceNotIn(List<BigDecimal> values) {
			addCriterion("ADJUSTED_PRICE not in", values, "adjustedPrice");
			return (Criteria) this;
		}

		public Criteria andAdjustedPriceBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("ADJUSTED_PRICE between", value1, value2, "adjustedPrice");
			return (Criteria) this;
		}

		public Criteria andAdjustedPriceNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("ADJUSTED_PRICE not between", value1, value2, "adjustedPrice");
			return (Criteria) this;
		}

		public Criteria andAdjustChargeIsNull() {
			addCriterion("ADJUST_CHARGE is null");
			return (Criteria) this;
		}

		public Criteria andAdjustChargeIsNotNull() {
			addCriterion("ADJUST_CHARGE is not null");
			return (Criteria) this;
		}

		public Criteria andAdjustChargeEqualTo(Integer value) {
			addCriterion("ADJUST_CHARGE =", value, "adjustCharge");
			return (Criteria) this;
		}

		public Criteria andAdjustChargeNotEqualTo(Integer value) {
			addCriterion("ADJUST_CHARGE <>", value, "adjustCharge");
			return (Criteria) this;
		}

		public Criteria andAdjustChargeGreaterThan(Integer value) {
			addCriterion("ADJUST_CHARGE >", value, "adjustCharge");
			return (Criteria) this;
		}

		public Criteria andAdjustChargeGreaterThanOrEqualTo(Integer value) {
			addCriterion("ADJUST_CHARGE >=", value, "adjustCharge");
			return (Criteria) this;
		}

		public Criteria andAdjustChargeLessThan(Integer value) {
			addCriterion("ADJUST_CHARGE <", value, "adjustCharge");
			return (Criteria) this;
		}

		public Criteria andAdjustChargeLessThanOrEqualTo(Integer value) {
			addCriterion("ADJUST_CHARGE <=", value, "adjustCharge");
			return (Criteria) this;
		}

		public Criteria andAdjustChargeIn(List<Integer> values) {
			addCriterion("ADJUST_CHARGE in", values, "adjustCharge");
			return (Criteria) this;
		}

		public Criteria andAdjustChargeNotIn(List<Integer> values) {
			addCriterion("ADJUST_CHARGE not in", values, "adjustCharge");
			return (Criteria) this;
		}

		public Criteria andAdjustChargeBetween(Integer value1, Integer value2) {
			addCriterion("ADJUST_CHARGE between", value1, value2, "adjustCharge");
			return (Criteria) this;
		}

		public Criteria andAdjustChargeNotBetween(Integer value1, Integer value2) {
			addCriterion("ADJUST_CHARGE not between", value1, value2, "adjustCharge");
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

		public Criteria andIfNetSignIsNull() {
			addCriterion("IF_NET_SIGN is null");
			return (Criteria) this;
		}

		public Criteria andIfNetSignIsNotNull() {
			addCriterion("IF_NET_SIGN is not null");
			return (Criteria) this;
		}

		public Criteria andIfNetSignEqualTo(Byte value) {
			addCriterion("IF_NET_SIGN =", value, "ifNetSign");
			return (Criteria) this;
		}

		public Criteria andIfNetSignNotEqualTo(Byte value) {
			addCriterion("IF_NET_SIGN <>", value, "ifNetSign");
			return (Criteria) this;
		}

		public Criteria andIfNetSignGreaterThan(Byte value) {
			addCriterion("IF_NET_SIGN >", value, "ifNetSign");
			return (Criteria) this;
		}

		public Criteria andIfNetSignGreaterThanOrEqualTo(Byte value) {
			addCriterion("IF_NET_SIGN >=", value, "ifNetSign");
			return (Criteria) this;
		}

		public Criteria andIfNetSignLessThan(Byte value) {
			addCriterion("IF_NET_SIGN <", value, "ifNetSign");
			return (Criteria) this;
		}

		public Criteria andIfNetSignLessThanOrEqualTo(Byte value) {
			addCriterion("IF_NET_SIGN <=", value, "ifNetSign");
			return (Criteria) this;
		}

		public Criteria andIfNetSignIn(List<Byte> values) {
			addCriterion("IF_NET_SIGN in", values, "ifNetSign");
			return (Criteria) this;
		}

		public Criteria andIfNetSignNotIn(List<Byte> values) {
			addCriterion("IF_NET_SIGN not in", values, "ifNetSign");
			return (Criteria) this;
		}

		public Criteria andIfNetSignBetween(Byte value1, Byte value2) {
			addCriterion("IF_NET_SIGN between", value1, value2, "ifNetSign");
			return (Criteria) this;
		}

		public Criteria andIfNetSignNotBetween(Byte value1, Byte value2) {
			addCriterion("IF_NET_SIGN not between", value1, value2, "ifNetSign");
			return (Criteria) this;
		}

		public Criteria andIfSubmitPledgeIsNull() {
			addCriterion("IF_SUBMIT_PLEDGE is null");
			return (Criteria) this;
		}

		public Criteria andIfSubmitPledgeIsNotNull() {
			addCriterion("IF_SUBMIT_PLEDGE is not null");
			return (Criteria) this;
		}

		public Criteria andIfSubmitPledgeEqualTo(Byte value) {
			addCriterion("IF_SUBMIT_PLEDGE =", value, "ifSubmitPledge");
			return (Criteria) this;
		}

		public Criteria andIfSubmitPledgeNotEqualTo(Byte value) {
			addCriterion("IF_SUBMIT_PLEDGE <>", value, "ifSubmitPledge");
			return (Criteria) this;
		}

		public Criteria andIfSubmitPledgeGreaterThan(Byte value) {
			addCriterion("IF_SUBMIT_PLEDGE >", value, "ifSubmitPledge");
			return (Criteria) this;
		}

		public Criteria andIfSubmitPledgeGreaterThanOrEqualTo(Byte value) {
			addCriterion("IF_SUBMIT_PLEDGE >=", value, "ifSubmitPledge");
			return (Criteria) this;
		}

		public Criteria andIfSubmitPledgeLessThan(Byte value) {
			addCriterion("IF_SUBMIT_PLEDGE <", value, "ifSubmitPledge");
			return (Criteria) this;
		}

		public Criteria andIfSubmitPledgeLessThanOrEqualTo(Byte value) {
			addCriterion("IF_SUBMIT_PLEDGE <=", value, "ifSubmitPledge");
			return (Criteria) this;
		}

		public Criteria andIfSubmitPledgeIn(List<Byte> values) {
			addCriterion("IF_SUBMIT_PLEDGE in", values, "ifSubmitPledge");
			return (Criteria) this;
		}

		public Criteria andIfSubmitPledgeNotIn(List<Byte> values) {
			addCriterion("IF_SUBMIT_PLEDGE not in", values, "ifSubmitPledge");
			return (Criteria) this;
		}

		public Criteria andIfSubmitPledgeBetween(Byte value1, Byte value2) {
			addCriterion("IF_SUBMIT_PLEDGE between", value1, value2, "ifSubmitPledge");
			return (Criteria) this;
		}

		public Criteria andIfSubmitPledgeNotBetween(Byte value1, Byte value2) {
			addCriterion("IF_SUBMIT_PLEDGE not between", value1, value2, "ifSubmitPledge");
			return (Criteria) this;
		}

		public Criteria andPledgeDateIsNull() {
			addCriterion("PLEDGE_DATE is null");
			return (Criteria) this;
		}

		public Criteria andPledgeDateIsNotNull() {
			addCriterion("PLEDGE_DATE is not null");
			return (Criteria) this;
		}

		public Criteria andPledgeDateEqualTo(Date value) {
			addCriterion("PLEDGE_DATE =", value, "pledgeDate");
			return (Criteria) this;
		}

		public Criteria andPledgeDateNotEqualTo(Date value) {
			addCriterion("PLEDGE_DATE <>", value, "pledgeDate");
			return (Criteria) this;
		}

		public Criteria andPledgeDateGreaterThan(Date value) {
			addCriterion("PLEDGE_DATE >", value, "pledgeDate");
			return (Criteria) this;
		}

		public Criteria andPledgeDateGreaterThanOrEqualTo(Date value) {
			addCriterion("PLEDGE_DATE >=", value, "pledgeDate");
			return (Criteria) this;
		}

		public Criteria andPledgeDateLessThan(Date value) {
			addCriterion("PLEDGE_DATE <", value, "pledgeDate");
			return (Criteria) this;
		}

		public Criteria andPledgeDateLessThanOrEqualTo(Date value) {
			addCriterion("PLEDGE_DATE <=", value, "pledgeDate");
			return (Criteria) this;
		}

		public Criteria andPledgeDateIn(List<Date> values) {
			addCriterion("PLEDGE_DATE in", values, "pledgeDate");
			return (Criteria) this;
		}

		public Criteria andPledgeDateNotIn(List<Date> values) {
			addCriterion("PLEDGE_DATE not in", values, "pledgeDate");
			return (Criteria) this;
		}

		public Criteria andPledgeDateBetween(Date value1, Date value2) {
			addCriterion("PLEDGE_DATE between", value1, value2, "pledgeDate");
			return (Criteria) this;
		}

		public Criteria andPledgeDateNotBetween(Date value1, Date value2) {
			addCriterion("PLEDGE_DATE not between", value1, value2, "pledgeDate");
			return (Criteria) this;
		}

		public Criteria andDownPaymentIsNull() {
			addCriterion("DOWN_PAYMENT is null");
			return (Criteria) this;
		}

		public Criteria andDownPaymentIsNotNull() {
			addCriterion("DOWN_PAYMENT is not null");
			return (Criteria) this;
		}

		public Criteria andDownPaymentEqualTo(BigDecimal value) {
			addCriterion("DOWN_PAYMENT =", value, "downPayment");
			return (Criteria) this;
		}

		public Criteria andDownPaymentNotEqualTo(BigDecimal value) {
			addCriterion("DOWN_PAYMENT <>", value, "downPayment");
			return (Criteria) this;
		}

		public Criteria andDownPaymentGreaterThan(BigDecimal value) {
			addCriterion("DOWN_PAYMENT >", value, "downPayment");
			return (Criteria) this;
		}

		public Criteria andDownPaymentGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("DOWN_PAYMENT >=", value, "downPayment");
			return (Criteria) this;
		}

		public Criteria andDownPaymentLessThan(BigDecimal value) {
			addCriterion("DOWN_PAYMENT <", value, "downPayment");
			return (Criteria) this;
		}

		public Criteria andDownPaymentLessThanOrEqualTo(BigDecimal value) {
			addCriterion("DOWN_PAYMENT <=", value, "downPayment");
			return (Criteria) this;
		}

		public Criteria andDownPaymentIn(List<BigDecimal> values) {
			addCriterion("DOWN_PAYMENT in", values, "downPayment");
			return (Criteria) this;
		}

		public Criteria andDownPaymentNotIn(List<BigDecimal> values) {
			addCriterion("DOWN_PAYMENT not in", values, "downPayment");
			return (Criteria) this;
		}

		public Criteria andDownPaymentBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("DOWN_PAYMENT between", value1, value2, "downPayment");
			return (Criteria) this;
		}

		public Criteria andDownPaymentNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("DOWN_PAYMENT not between", value1, value2, "downPayment");
			return (Criteria) this;
		}

		public Criteria andRepaymentTypeIsNull() {
			addCriterion("REPAYMENT_TYPE is null");
			return (Criteria) this;
		}

		public Criteria andRepaymentTypeIsNotNull() {
			addCriterion("REPAYMENT_TYPE is not null");
			return (Criteria) this;
		}

		public Criteria andRepaymentTypeEqualTo(Byte value) {
			addCriterion("REPAYMENT_TYPE =", value, "repaymentType");
			return (Criteria) this;
		}

		public Criteria andRepaymentTypeNotEqualTo(Byte value) {
			addCriterion("REPAYMENT_TYPE <>", value, "repaymentType");
			return (Criteria) this;
		}

		public Criteria andRepaymentTypeGreaterThan(Byte value) {
			addCriterion("REPAYMENT_TYPE >", value, "repaymentType");
			return (Criteria) this;
		}

		public Criteria andRepaymentTypeGreaterThanOrEqualTo(Byte value) {
			addCriterion("REPAYMENT_TYPE >=", value, "repaymentType");
			return (Criteria) this;
		}

		public Criteria andRepaymentTypeLessThan(Byte value) {
			addCriterion("REPAYMENT_TYPE <", value, "repaymentType");
			return (Criteria) this;
		}

		public Criteria andRepaymentTypeLessThanOrEqualTo(Byte value) {
			addCriterion("REPAYMENT_TYPE <=", value, "repaymentType");
			return (Criteria) this;
		}

		public Criteria andRepaymentTypeIn(List<Byte> values) {
			addCriterion("REPAYMENT_TYPE in", values, "repaymentType");
			return (Criteria) this;
		}

		public Criteria andRepaymentTypeNotIn(List<Byte> values) {
			addCriterion("REPAYMENT_TYPE not in", values, "repaymentType");
			return (Criteria) this;
		}

		public Criteria andRepaymentTypeBetween(Byte value1, Byte value2) {
			addCriterion("REPAYMENT_TYPE between", value1, value2, "repaymentType");
			return (Criteria) this;
		}

		public Criteria andRepaymentTypeNotBetween(Byte value1, Byte value2) {
			addCriterion("REPAYMENT_TYPE not between", value1, value2, "repaymentType");
			return (Criteria) this;
		}

		public Criteria andMonthlyPaymentIsNull() {
			addCriterion("MONTHLY_PAYMENT is null");
			return (Criteria) this;
		}

		public Criteria andMonthlyPaymentIsNotNull() {
			addCriterion("MONTHLY_PAYMENT is not null");
			return (Criteria) this;
		}

		public Criteria andMonthlyPaymentEqualTo(Integer value) {
			addCriterion("MONTHLY_PAYMENT =", value, "monthlyPayment");
			return (Criteria) this;
		}

		public Criteria andMonthlyPaymentNotEqualTo(Integer value) {
			addCriterion("MONTHLY_PAYMENT <>", value, "monthlyPayment");
			return (Criteria) this;
		}

		public Criteria andMonthlyPaymentGreaterThan(Integer value) {
			addCriterion("MONTHLY_PAYMENT >", value, "monthlyPayment");
			return (Criteria) this;
		}

		public Criteria andMonthlyPaymentGreaterThanOrEqualTo(Integer value) {
			addCriterion("MONTHLY_PAYMENT >=", value, "monthlyPayment");
			return (Criteria) this;
		}

		public Criteria andMonthlyPaymentLessThan(Integer value) {
			addCriterion("MONTHLY_PAYMENT <", value, "monthlyPayment");
			return (Criteria) this;
		}

		public Criteria andMonthlyPaymentLessThanOrEqualTo(Integer value) {
			addCriterion("MONTHLY_PAYMENT <=", value, "monthlyPayment");
			return (Criteria) this;
		}

		public Criteria andMonthlyPaymentIn(List<Integer> values) {
			addCriterion("MONTHLY_PAYMENT in", values, "monthlyPayment");
			return (Criteria) this;
		}

		public Criteria andMonthlyPaymentNotIn(List<Integer> values) {
			addCriterion("MONTHLY_PAYMENT not in", values, "monthlyPayment");
			return (Criteria) this;
		}

		public Criteria andMonthlyPaymentBetween(Integer value1, Integer value2) {
			addCriterion("MONTHLY_PAYMENT between", value1, value2, "monthlyPayment");
			return (Criteria) this;
		}

		public Criteria andMonthlyPaymentNotBetween(Integer value1, Integer value2) {
			addCriterion("MONTHLY_PAYMENT not between", value1, value2, "monthlyPayment");
			return (Criteria) this;
		}

		public Criteria andIfSubmitZpreportIsNull() {
			addCriterion("IF_SUBMIT_ZPREPORT is null");
			return (Criteria) this;
		}

		public Criteria andIfSubmitZpreportIsNotNull() {
			addCriterion("IF_SUBMIT_ZPREPORT is not null");
			return (Criteria) this;
		}

		public Criteria andIfSubmitZpreportEqualTo(Byte value) {
			addCriterion("IF_SUBMIT_ZPREPORT =", value, "ifSubmitZpreport");
			return (Criteria) this;
		}

		public Criteria andIfSubmitZpreportNotEqualTo(Byte value) {
			addCriterion("IF_SUBMIT_ZPREPORT <>", value, "ifSubmitZpreport");
			return (Criteria) this;
		}

		public Criteria andIfSubmitZpreportGreaterThan(Byte value) {
			addCriterion("IF_SUBMIT_ZPREPORT >", value, "ifSubmitZpreport");
			return (Criteria) this;
		}

		public Criteria andIfSubmitZpreportGreaterThanOrEqualTo(Byte value) {
			addCriterion("IF_SUBMIT_ZPREPORT >=", value, "ifSubmitZpreport");
			return (Criteria) this;
		}

		public Criteria andIfSubmitZpreportLessThan(Byte value) {
			addCriterion("IF_SUBMIT_ZPREPORT <", value, "ifSubmitZpreport");
			return (Criteria) this;
		}

		public Criteria andIfSubmitZpreportLessThanOrEqualTo(Byte value) {
			addCriterion("IF_SUBMIT_ZPREPORT <=", value, "ifSubmitZpreport");
			return (Criteria) this;
		}

		public Criteria andIfSubmitZpreportIn(List<Byte> values) {
			addCriterion("IF_SUBMIT_ZPREPORT in", values, "ifSubmitZpreport");
			return (Criteria) this;
		}

		public Criteria andIfSubmitZpreportNotIn(List<Byte> values) {
			addCriterion("IF_SUBMIT_ZPREPORT not in", values, "ifSubmitZpreport");
			return (Criteria) this;
		}

		public Criteria andIfSubmitZpreportBetween(Byte value1, Byte value2) {
			addCriterion("IF_SUBMIT_ZPREPORT between", value1, value2, "ifSubmitZpreport");
			return (Criteria) this;
		}

		public Criteria andIfSubmitZpreportNotBetween(Byte value1, Byte value2) {
			addCriterion("IF_SUBMIT_ZPREPORT not between", value1, value2, "ifSubmitZpreport");
			return (Criteria) this;
		}

		public Criteria andIfLendedIsNull() {
			addCriterion("IF_LENDED is null");
			return (Criteria) this;
		}

		public Criteria andIfLendedIsNotNull() {
			addCriterion("IF_LENDED is not null");
			return (Criteria) this;
		}

		public Criteria andIfLendedEqualTo(Byte value) {
			addCriterion("IF_LENDED =", value, "ifLended");
			return (Criteria) this;
		}

		public Criteria andIfLendedNotEqualTo(Byte value) {
			addCriterion("IF_LENDED <>", value, "ifLended");
			return (Criteria) this;
		}

		public Criteria andIfLendedGreaterThan(Byte value) {
			addCriterion("IF_LENDED >", value, "ifLended");
			return (Criteria) this;
		}

		public Criteria andIfLendedGreaterThanOrEqualTo(Byte value) {
			addCriterion("IF_LENDED >=", value, "ifLended");
			return (Criteria) this;
		}

		public Criteria andIfLendedLessThan(Byte value) {
			addCriterion("IF_LENDED <", value, "ifLended");
			return (Criteria) this;
		}

		public Criteria andIfLendedLessThanOrEqualTo(Byte value) {
			addCriterion("IF_LENDED <=", value, "ifLended");
			return (Criteria) this;
		}

		public Criteria andIfLendedIn(List<Byte> values) {
			addCriterion("IF_LENDED in", values, "ifLended");
			return (Criteria) this;
		}

		public Criteria andIfLendedNotIn(List<Byte> values) {
			addCriterion("IF_LENDED not in", values, "ifLended");
			return (Criteria) this;
		}

		public Criteria andIfLendedBetween(Byte value1, Byte value2) {
			addCriterion("IF_LENDED between", value1, value2, "ifLended");
			return (Criteria) this;
		}

		public Criteria andIfLendedNotBetween(Byte value1, Byte value2) {
			addCriterion("IF_LENDED not between", value1, value2, "ifLended");
			return (Criteria) this;
		}

		public Criteria andPledgeRemarkIsNull() {
			addCriterion("PLEDGE_REMARK is null");
			return (Criteria) this;
		}

		public Criteria andPledgeRemarkIsNotNull() {
			addCriterion("PLEDGE_REMARK is not null");
			return (Criteria) this;
		}

		public Criteria andPledgeRemarkEqualTo(String value) {
			addCriterion("PLEDGE_REMARK =", value, "pledgeRemark");
			return (Criteria) this;
		}

		public Criteria andPledgeRemarkNotEqualTo(String value) {
			addCriterion("PLEDGE_REMARK <>", value, "pledgeRemark");
			return (Criteria) this;
		}

		public Criteria andPledgeRemarkGreaterThan(String value) {
			addCriterion("PLEDGE_REMARK >", value, "pledgeRemark");
			return (Criteria) this;
		}

		public Criteria andPledgeRemarkGreaterThanOrEqualTo(String value) {
			addCriterion("PLEDGE_REMARK >=", value, "pledgeRemark");
			return (Criteria) this;
		}

		public Criteria andPledgeRemarkLessThan(String value) {
			addCriterion("PLEDGE_REMARK <", value, "pledgeRemark");
			return (Criteria) this;
		}

		public Criteria andPledgeRemarkLessThanOrEqualTo(String value) {
			addCriterion("PLEDGE_REMARK <=", value, "pledgeRemark");
			return (Criteria) this;
		}

		public Criteria andPledgeRemarkLike(String value) {
			addCriterion("PLEDGE_REMARK like", value, "pledgeRemark");
			return (Criteria) this;
		}

		public Criteria andPledgeRemarkNotLike(String value) {
			addCriterion("PLEDGE_REMARK not like", value, "pledgeRemark");
			return (Criteria) this;
		}

		public Criteria andPledgeRemarkIn(List<String> values) {
			addCriterion("PLEDGE_REMARK in", values, "pledgeRemark");
			return (Criteria) this;
		}

		public Criteria andPledgeRemarkNotIn(List<String> values) {
			addCriterion("PLEDGE_REMARK not in", values, "pledgeRemark");
			return (Criteria) this;
		}

		public Criteria andPledgeRemarkBetween(String value1, String value2) {
			addCriterion("PLEDGE_REMARK between", value1, value2, "pledgeRemark");
			return (Criteria) this;
		}

		public Criteria andPledgeRemarkNotBetween(String value1, String value2) {
			addCriterion("PLEDGE_REMARK not between", value1, value2, "pledgeRemark");
			return (Criteria) this;
		}

		public Criteria andErpAreaIdIsNull() {
			addCriterion("ERP_AREA_ID is null");
			return (Criteria) this;
		}

		public Criteria andErpAreaIdIsNotNull() {
			addCriterion("ERP_AREA_ID is not null");
			return (Criteria) this;
		}

		public Criteria andErpAreaIdEqualTo(Integer value) {
			addCriterion("ERP_AREA_ID =", value, "erpAreaId");
			return (Criteria) this;
		}

		public Criteria andErpAreaIdNotEqualTo(Integer value) {
			addCriterion("ERP_AREA_ID <>", value, "erpAreaId");
			return (Criteria) this;
		}

		public Criteria andErpAreaIdGreaterThan(Integer value) {
			addCriterion("ERP_AREA_ID >", value, "erpAreaId");
			return (Criteria) this;
		}

		public Criteria andErpAreaIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("ERP_AREA_ID >=", value, "erpAreaId");
			return (Criteria) this;
		}

		public Criteria andErpAreaIdLessThan(Integer value) {
			addCriterion("ERP_AREA_ID <", value, "erpAreaId");
			return (Criteria) this;
		}

		public Criteria andErpAreaIdLessThanOrEqualTo(Integer value) {
			addCriterion("ERP_AREA_ID <=", value, "erpAreaId");
			return (Criteria) this;
		}

		public Criteria andErpAreaIdIn(List<Integer> values) {
			addCriterion("ERP_AREA_ID in", values, "erpAreaId");
			return (Criteria) this;
		}

		public Criteria andErpAreaIdNotIn(List<Integer> values) {
			addCriterion("ERP_AREA_ID not in", values, "erpAreaId");
			return (Criteria) this;
		}

		public Criteria andErpAreaIdBetween(Integer value1, Integer value2) {
			addCriterion("ERP_AREA_ID between", value1, value2, "erpAreaId");
			return (Criteria) this;
		}

		public Criteria andErpAreaIdNotBetween(Integer value1, Integer value2) {
			addCriterion("ERP_AREA_ID not between", value1, value2, "erpAreaId");
			return (Criteria) this;
		}

		public Criteria andErpRegIdIsNull() {
			addCriterion("ERP_REG_ID is null");
			return (Criteria) this;
		}

		public Criteria andErpRegIdIsNotNull() {
			addCriterion("ERP_REG_ID is not null");
			return (Criteria) this;
		}

		public Criteria andErpRegIdEqualTo(Integer value) {
			addCriterion("ERP_REG_ID =", value, "erpRegId");
			return (Criteria) this;
		}

		public Criteria andErpRegIdNotEqualTo(Integer value) {
			addCriterion("ERP_REG_ID <>", value, "erpRegId");
			return (Criteria) this;
		}

		public Criteria andErpRegIdGreaterThan(Integer value) {
			addCriterion("ERP_REG_ID >", value, "erpRegId");
			return (Criteria) this;
		}

		public Criteria andErpRegIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("ERP_REG_ID >=", value, "erpRegId");
			return (Criteria) this;
		}

		public Criteria andErpRegIdLessThan(Integer value) {
			addCriterion("ERP_REG_ID <", value, "erpRegId");
			return (Criteria) this;
		}

		public Criteria andErpRegIdLessThanOrEqualTo(Integer value) {
			addCriterion("ERP_REG_ID <=", value, "erpRegId");
			return (Criteria) this;
		}

		public Criteria andErpRegIdIn(List<Integer> values) {
			addCriterion("ERP_REG_ID in", values, "erpRegId");
			return (Criteria) this;
		}

		public Criteria andErpRegIdNotIn(List<Integer> values) {
			addCriterion("ERP_REG_ID not in", values, "erpRegId");
			return (Criteria) this;
		}

		public Criteria andErpRegIdBetween(Integer value1, Integer value2) {
			addCriterion("ERP_REG_ID between", value1, value2, "erpRegId");
			return (Criteria) this;
		}

		public Criteria andErpRegIdNotBetween(Integer value1, Integer value2) {
			addCriterion("ERP_REG_ID not between", value1, value2, "erpRegId");
			return (Criteria) this;
		}

		public Criteria andRealLoanPriceIsNull() {
			addCriterion("REAL_LOAN_PRICE is null");
			return (Criteria) this;
		}

		public Criteria andRealLoanPriceIsNotNull() {
			addCriterion("REAL_LOAN_PRICE is not null");
			return (Criteria) this;
		}

		public Criteria andRealLoanPriceEqualTo(BigDecimal value) {
			addCriterion("REAL_LOAN_PRICE =", value, "realLoanPrice");
			return (Criteria) this;
		}

		public Criteria andRealLoanPriceNotEqualTo(BigDecimal value) {
			addCriterion("REAL_LOAN_PRICE <>", value, "realLoanPrice");
			return (Criteria) this;
		}

		public Criteria andRealLoanPriceGreaterThan(BigDecimal value) {
			addCriterion("REAL_LOAN_PRICE >", value, "realLoanPrice");
			return (Criteria) this;
		}

		public Criteria andRealLoanPriceGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("REAL_LOAN_PRICE >=", value, "realLoanPrice");
			return (Criteria) this;
		}

		public Criteria andRealLoanPriceLessThan(BigDecimal value) {
			addCriterion("REAL_LOAN_PRICE <", value, "realLoanPrice");
			return (Criteria) this;
		}

		public Criteria andRealLoanPriceLessThanOrEqualTo(BigDecimal value) {
			addCriterion("REAL_LOAN_PRICE <=", value, "realLoanPrice");
			return (Criteria) this;
		}

		public Criteria andRealLoanPriceIn(List<BigDecimal> values) {
			addCriterion("REAL_LOAN_PRICE in", values, "realLoanPrice");
			return (Criteria) this;
		}

		public Criteria andRealLoanPriceNotIn(List<BigDecimal> values) {
			addCriterion("REAL_LOAN_PRICE not in", values, "realLoanPrice");
			return (Criteria) this;
		}

		public Criteria andRealLoanPriceBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("REAL_LOAN_PRICE between", value1, value2, "realLoanPrice");
			return (Criteria) this;
		}

		public Criteria andRealLoanPriceNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("REAL_LOAN_PRICE not between", value1, value2, "realLoanPrice");
			return (Criteria) this;
		}

		public Criteria andHouseSourceIsNull() {
			addCriterion("HOUSE_SOURCE is null");
			return (Criteria) this;
		}

		public Criteria andHouseSourceIsNotNull() {
			addCriterion("HOUSE_SOURCE is not null");
			return (Criteria) this;
		}

		public Criteria andHouseSourceEqualTo(Byte value) {
			addCriterion("HOUSE_SOURCE =", value, "houseSource");
			return (Criteria) this;
		}

		public Criteria andHouseSourceNotEqualTo(Byte value) {
			addCriterion("HOUSE_SOURCE <>", value, "houseSource");
			return (Criteria) this;
		}

		public Criteria andHouseSourceGreaterThan(Byte value) {
			addCriterion("HOUSE_SOURCE >", value, "houseSource");
			return (Criteria) this;
		}

		public Criteria andHouseSourceGreaterThanOrEqualTo(Byte value) {
			addCriterion("HOUSE_SOURCE >=", value, "houseSource");
			return (Criteria) this;
		}

		public Criteria andHouseSourceLessThan(Byte value) {
			addCriterion("HOUSE_SOURCE <", value, "houseSource");
			return (Criteria) this;
		}

		public Criteria andHouseSourceLessThanOrEqualTo(Byte value) {
			addCriterion("HOUSE_SOURCE <=", value, "houseSource");
			return (Criteria) this;
		}

		public Criteria andHouseSourceIn(List<Byte> values) {
			addCriterion("HOUSE_SOURCE in", values, "houseSource");
			return (Criteria) this;
		}

		public Criteria andHouseSourceNotIn(List<Byte> values) {
			addCriterion("HOUSE_SOURCE not in", values, "houseSource");
			return (Criteria) this;
		}

		public Criteria andHouseSourceBetween(Byte value1, Byte value2) {
			addCriterion("HOUSE_SOURCE between", value1, value2, "houseSource");
			return (Criteria) this;
		}

		public Criteria andHouseSourceNotBetween(Byte value1, Byte value2) {
			addCriterion("HOUSE_SOURCE not between", value1, value2, "houseSource");
			return (Criteria) this;
		}

		public Criteria andMainAssessmentIsNull() {
			addCriterion("MAIN_ASSESSMENT is null");
			return (Criteria) this;
		}

		public Criteria andMainAssessmentIsNotNull() {
			addCriterion("MAIN_ASSESSMENT is not null");
			return (Criteria) this;
		}

		public Criteria andMainAssessmentEqualTo(Integer value) {
			addCriterion("MAIN_ASSESSMENT =", value, "mainAssessment");
			return (Criteria) this;
		}

		public Criteria andMainAssessmentNotEqualTo(Integer value) {
			addCriterion("MAIN_ASSESSMENT <>", value, "mainAssessment");
			return (Criteria) this;
		}

		public Criteria andMainAssessmentGreaterThan(Integer value) {
			addCriterion("MAIN_ASSESSMENT >", value, "mainAssessment");
			return (Criteria) this;
		}

		public Criteria andMainAssessmentGreaterThanOrEqualTo(Integer value) {
			addCriterion("MAIN_ASSESSMENT >=", value, "mainAssessment");
			return (Criteria) this;
		}

		public Criteria andMainAssessmentLessThan(Integer value) {
			addCriterion("MAIN_ASSESSMENT <", value, "mainAssessment");
			return (Criteria) this;
		}

		public Criteria andMainAssessmentLessThanOrEqualTo(Integer value) {
			addCriterion("MAIN_ASSESSMENT <=", value, "mainAssessment");
			return (Criteria) this;
		}

		public Criteria andMainAssessmentIn(List<Integer> values) {
			addCriterion("MAIN_ASSESSMENT in", values, "mainAssessment");
			return (Criteria) this;
		}

		public Criteria andMainAssessmentNotIn(List<Integer> values) {
			addCriterion("MAIN_ASSESSMENT not in", values, "mainAssessment");
			return (Criteria) this;
		}

		public Criteria andMainAssessmentBetween(Integer value1, Integer value2) {
			addCriterion("MAIN_ASSESSMENT between", value1, value2, "mainAssessment");
			return (Criteria) this;
		}

		public Criteria andMainAssessmentNotBetween(Integer value1, Integer value2) {
			addCriterion("MAIN_ASSESSMENT not between", value1, value2, "mainAssessment");
			return (Criteria) this;
		}

		public Criteria andSecondAssessmentIsNull() {
			addCriterion("SECOND_ASSESSMENT is null");
			return (Criteria) this;
		}

		public Criteria andSecondAssessmentIsNotNull() {
			addCriterion("SECOND_ASSESSMENT is not null");
			return (Criteria) this;
		}

		public Criteria andSecondAssessmentEqualTo(Integer value) {
			addCriterion("SECOND_ASSESSMENT =", value, "secondAssessment");
			return (Criteria) this;
		}

		public Criteria andSecondAssessmentNotEqualTo(Integer value) {
			addCriterion("SECOND_ASSESSMENT <>", value, "secondAssessment");
			return (Criteria) this;
		}

		public Criteria andSecondAssessmentGreaterThan(Integer value) {
			addCriterion("SECOND_ASSESSMENT >", value, "secondAssessment");
			return (Criteria) this;
		}

		public Criteria andSecondAssessmentGreaterThanOrEqualTo(Integer value) {
			addCriterion("SECOND_ASSESSMENT >=", value, "secondAssessment");
			return (Criteria) this;
		}

		public Criteria andSecondAssessmentLessThan(Integer value) {
			addCriterion("SECOND_ASSESSMENT <", value, "secondAssessment");
			return (Criteria) this;
		}

		public Criteria andSecondAssessmentLessThanOrEqualTo(Integer value) {
			addCriterion("SECOND_ASSESSMENT <=", value, "secondAssessment");
			return (Criteria) this;
		}

		public Criteria andSecondAssessmentIn(List<Integer> values) {
			addCriterion("SECOND_ASSESSMENT in", values, "secondAssessment");
			return (Criteria) this;
		}

		public Criteria andSecondAssessmentNotIn(List<Integer> values) {
			addCriterion("SECOND_ASSESSMENT not in", values, "secondAssessment");
			return (Criteria) this;
		}

		public Criteria andSecondAssessmentBetween(Integer value1, Integer value2) {
			addCriterion("SECOND_ASSESSMENT between", value1, value2, "secondAssessment");
			return (Criteria) this;
		}

		public Criteria andSecondAssessmentNotBetween(Integer value1, Integer value2) {
			addCriterion("SECOND_ASSESSMENT not between", value1, value2, "secondAssessment");
			return (Criteria) this;
		}

		public Criteria andDataResourceIsNull() {
			addCriterion("DATA_RESOURCE is null");
			return (Criteria) this;
		}

		public Criteria andDataResourceIsNotNull() {
			addCriterion("DATA_RESOURCE is not null");
			return (Criteria) this;
		}

		public Criteria andDataResourceEqualTo(Byte value) {
			addCriterion("DATA_RESOURCE =", value, "dataResource");
			return (Criteria) this;
		}

		public Criteria andDataResourceNotEqualTo(Byte value) {
			addCriterion("DATA_RESOURCE <>", value, "dataResource");
			return (Criteria) this;
		}

		public Criteria andDataResourceGreaterThan(Byte value) {
			addCriterion("DATA_RESOURCE >", value, "dataResource");
			return (Criteria) this;
		}

		public Criteria andDataResourceGreaterThanOrEqualTo(Byte value) {
			addCriterion("DATA_RESOURCE >=", value, "dataResource");
			return (Criteria) this;
		}

		public Criteria andDataResourceLessThan(Byte value) {
			addCriterion("DATA_RESOURCE <", value, "dataResource");
			return (Criteria) this;
		}

		public Criteria andDataResourceLessThanOrEqualTo(Byte value) {
			addCriterion("DATA_RESOURCE <=", value, "dataResource");
			return (Criteria) this;
		}

		public Criteria andDataResourceIn(List<Byte> values) {
			addCriterion("DATA_RESOURCE in", values, "dataResource");
			return (Criteria) this;
		}

		public Criteria andDataResourceNotIn(List<Byte> values) {
			addCriterion("DATA_RESOURCE not in", values, "dataResource");
			return (Criteria) this;
		}

		public Criteria andDataResourceBetween(Byte value1, Byte value2) {
			addCriterion("DATA_RESOURCE between", value1, value2, "dataResource");
			return (Criteria) this;
		}

		public Criteria andDataResourceNotBetween(Byte value1, Byte value2) {
			addCriterion("DATA_RESOURCE not between", value1, value2, "dataResource");
			return (Criteria) this;
		}

		public Criteria andCreatorTypeIsNull() {
			addCriterion("CREATOR_TYPE is null");
			return (Criteria) this;
		}

		public Criteria andCreatorTypeIsNotNull() {
			addCriterion("CREATOR_TYPE is not null");
			return (Criteria) this;
		}

		public Criteria andCreatorTypeEqualTo(Byte value) {
			addCriterion("CREATOR_TYPE =", value, "creatorType");
			return (Criteria) this;
		}

		public Criteria andCreatorTypeNotEqualTo(Byte value) {
			addCriterion("CREATOR_TYPE <>", value, "creatorType");
			return (Criteria) this;
		}

		public Criteria andCreatorTypeGreaterThan(Byte value) {
			addCriterion("CREATOR_TYPE >", value, "creatorType");
			return (Criteria) this;
		}

		public Criteria andCreatorTypeGreaterThanOrEqualTo(Byte value) {
			addCriterion("CREATOR_TYPE >=", value, "creatorType");
			return (Criteria) this;
		}

		public Criteria andCreatorTypeLessThan(Byte value) {
			addCriterion("CREATOR_TYPE <", value, "creatorType");
			return (Criteria) this;
		}

		public Criteria andCreatorTypeLessThanOrEqualTo(Byte value) {
			addCriterion("CREATOR_TYPE <=", value, "creatorType");
			return (Criteria) this;
		}

		public Criteria andCreatorTypeIn(List<Byte> values) {
			addCriterion("CREATOR_TYPE in", values, "creatorType");
			return (Criteria) this;
		}

		public Criteria andCreatorTypeNotIn(List<Byte> values) {
			addCriterion("CREATOR_TYPE not in", values, "creatorType");
			return (Criteria) this;
		}

		public Criteria andCreatorTypeBetween(Byte value1, Byte value2) {
			addCriterion("CREATOR_TYPE between", value1, value2, "creatorType");
			return (Criteria) this;
		}

		public Criteria andCreatorTypeNotBetween(Byte value1, Byte value2) {
			addCriterion("CREATOR_TYPE not between", value1, value2, "creatorType");
			return (Criteria) this;
		}

		public Criteria andIncomeProofIsNull() {
			addCriterion("INCOME_PROOF is null");
			return (Criteria) this;
		}

		public Criteria andIncomeProofIsNotNull() {
			addCriterion("INCOME_PROOF is not null");
			return (Criteria) this;
		}

		public Criteria andIncomeProofEqualTo(Byte value) {
			addCriterion("INCOME_PROOF =", value, "incomeProof");
			return (Criteria) this;
		}

		public Criteria andIncomeProofNotEqualTo(Byte value) {
			addCriterion("INCOME_PROOF <>", value, "incomeProof");
			return (Criteria) this;
		}

		public Criteria andIncomeProofGreaterThan(Byte value) {
			addCriterion("INCOME_PROOF >", value, "incomeProof");
			return (Criteria) this;
		}

		public Criteria andIncomeProofGreaterThanOrEqualTo(Byte value) {
			addCriterion("INCOME_PROOF >=", value, "incomeProof");
			return (Criteria) this;
		}

		public Criteria andIncomeProofLessThan(Byte value) {
			addCriterion("INCOME_PROOF <", value, "incomeProof");
			return (Criteria) this;
		}

		public Criteria andIncomeProofLessThanOrEqualTo(Byte value) {
			addCriterion("INCOME_PROOF <=", value, "incomeProof");
			return (Criteria) this;
		}

		public Criteria andIncomeProofIn(List<Byte> values) {
			addCriterion("INCOME_PROOF in", values, "incomeProof");
			return (Criteria) this;
		}

		public Criteria andIncomeProofNotIn(List<Byte> values) {
			addCriterion("INCOME_PROOF not in", values, "incomeProof");
			return (Criteria) this;
		}

		public Criteria andIncomeProofBetween(Byte value1, Byte value2) {
			addCriterion("INCOME_PROOF between", value1, value2, "incomeProof");
			return (Criteria) this;
		}

		public Criteria andIncomeProofNotBetween(Byte value1, Byte value2) {
			addCriterion("INCOME_PROOF not between", value1, value2, "incomeProof");
			return (Criteria) this;
		}

		public Criteria andErpGrIdIsNull() {
			addCriterion("ERP_GR_ID is null");
			return (Criteria) this;
		}

		public Criteria andErpGrIdIsNotNull() {
			addCriterion("ERP_GR_ID is not null");
			return (Criteria) this;
		}

		public Criteria andErpGrIdEqualTo(Integer value) {
			addCriterion("ERP_GR_ID =", value, "erpGrId");
			return (Criteria) this;
		}

		public Criteria andErpGrIdNotEqualTo(Integer value) {
			addCriterion("ERP_GR_ID <>", value, "erpGrId");
			return (Criteria) this;
		}

		public Criteria andErpGrIdGreaterThan(Integer value) {
			addCriterion("ERP_GR_ID >", value, "erpGrId");
			return (Criteria) this;
		}

		public Criteria andErpGrIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("ERP_GR_ID >=", value, "erpGrId");
			return (Criteria) this;
		}

		public Criteria andErpGrIdLessThan(Integer value) {
			addCriterion("ERP_GR_ID <", value, "erpGrId");
			return (Criteria) this;
		}

		public Criteria andErpGrIdLessThanOrEqualTo(Integer value) {
			addCriterion("ERP_GR_ID <=", value, "erpGrId");
			return (Criteria) this;
		}

		public Criteria andErpGrIdIn(List<Integer> values) {
			addCriterion("ERP_GR_ID in", values, "erpGrId");
			return (Criteria) this;
		}

		public Criteria andErpGrIdNotIn(List<Integer> values) {
			addCriterion("ERP_GR_ID not in", values, "erpGrId");
			return (Criteria) this;
		}

		public Criteria andErpGrIdBetween(Integer value1, Integer value2) {
			addCriterion("ERP_GR_ID between", value1, value2, "erpGrId");
			return (Criteria) this;
		}

		public Criteria andErpGrIdNotBetween(Integer value1, Integer value2) {
			addCriterion("ERP_GR_ID not between", value1, value2, "erpGrId");
			return (Criteria) this;
		}

		public Criteria andMainBankNameIsNull() {
			addCriterion("MAIN_BANK_NAME is null");
			return (Criteria) this;
		}

		public Criteria andMainBankNameIsNotNull() {
			addCriterion("MAIN_BANK_NAME is not null");
			return (Criteria) this;
		}

		public Criteria andMainBankNameEqualTo(String value) {
			addCriterion("MAIN_BANK_NAME =", value, "mainBankName");
			return (Criteria) this;
		}

		public Criteria andMainBankNameNotEqualTo(String value) {
			addCriterion("MAIN_BANK_NAME <>", value, "mainBankName");
			return (Criteria) this;
		}

		public Criteria andMainBankNameGreaterThan(String value) {
			addCriterion("MAIN_BANK_NAME >", value, "mainBankName");
			return (Criteria) this;
		}

		public Criteria andMainBankNameGreaterThanOrEqualTo(String value) {
			addCriterion("MAIN_BANK_NAME >=", value, "mainBankName");
			return (Criteria) this;
		}

		public Criteria andMainBankNameLessThan(String value) {
			addCriterion("MAIN_BANK_NAME <", value, "mainBankName");
			return (Criteria) this;
		}

		public Criteria andMainBankNameLessThanOrEqualTo(String value) {
			addCriterion("MAIN_BANK_NAME <=", value, "mainBankName");
			return (Criteria) this;
		}

		public Criteria andMainBankNameLike(String value) {
			addCriterion("MAIN_BANK_NAME like", value, "mainBankName");
			return (Criteria) this;
		}

		public Criteria andMainBankNameNotLike(String value) {
			addCriterion("MAIN_BANK_NAME not like", value, "mainBankName");
			return (Criteria) this;
		}

		public Criteria andMainBankNameIn(List<String> values) {
			addCriterion("MAIN_BANK_NAME in", values, "mainBankName");
			return (Criteria) this;
		}

		public Criteria andMainBankNameNotIn(List<String> values) {
			addCriterion("MAIN_BANK_NAME not in", values, "mainBankName");
			return (Criteria) this;
		}

		public Criteria andMainBankNameBetween(String value1, String value2) {
			addCriterion("MAIN_BANK_NAME between", value1, value2, "mainBankName");
			return (Criteria) this;
		}

		public Criteria andMainBankNameNotBetween(String value1, String value2) {
			addCriterion("MAIN_BANK_NAME not between", value1, value2, "mainBankName");
			return (Criteria) this;
		}

		public Criteria andSecondBankNameIsNull() {
			addCriterion("SECOND_BANK_NAME is null");
			return (Criteria) this;
		}

		public Criteria andSecondBankNameIsNotNull() {
			addCriterion("SECOND_BANK_NAME is not null");
			return (Criteria) this;
		}

		public Criteria andSecondBankNameEqualTo(String value) {
			addCriterion("SECOND_BANK_NAME =", value, "secondBankName");
			return (Criteria) this;
		}

		public Criteria andSecondBankNameNotEqualTo(String value) {
			addCriterion("SECOND_BANK_NAME <>", value, "secondBankName");
			return (Criteria) this;
		}

		public Criteria andSecondBankNameGreaterThan(String value) {
			addCriterion("SECOND_BANK_NAME >", value, "secondBankName");
			return (Criteria) this;
		}

		public Criteria andSecondBankNameGreaterThanOrEqualTo(String value) {
			addCriterion("SECOND_BANK_NAME >=", value, "secondBankName");
			return (Criteria) this;
		}

		public Criteria andSecondBankNameLessThan(String value) {
			addCriterion("SECOND_BANK_NAME <", value, "secondBankName");
			return (Criteria) this;
		}

		public Criteria andSecondBankNameLessThanOrEqualTo(String value) {
			addCriterion("SECOND_BANK_NAME <=", value, "secondBankName");
			return (Criteria) this;
		}

		public Criteria andSecondBankNameLike(String value) {
			addCriterion("SECOND_BANK_NAME like", value, "secondBankName");
			return (Criteria) this;
		}

		public Criteria andSecondBankNameNotLike(String value) {
			addCriterion("SECOND_BANK_NAME not like", value, "secondBankName");
			return (Criteria) this;
		}

		public Criteria andSecondBankNameIn(List<String> values) {
			addCriterion("SECOND_BANK_NAME in", values, "secondBankName");
			return (Criteria) this;
		}

		public Criteria andSecondBankNameNotIn(List<String> values) {
			addCriterion("SECOND_BANK_NAME not in", values, "secondBankName");
			return (Criteria) this;
		}

		public Criteria andSecondBankNameBetween(String value1, String value2) {
			addCriterion("SECOND_BANK_NAME between", value1, value2, "secondBankName");
			return (Criteria) this;
		}

		public Criteria andSecondBankNameNotBetween(String value1, String value2) {
			addCriterion("SECOND_BANK_NAME not between", value1, value2, "secondBankName");
			return (Criteria) this;
		}

		public Criteria andMainAssessNameIsNull() {
			addCriterion("MAIN_ASSESS_NAME is null");
			return (Criteria) this;
		}

		public Criteria andMainAssessNameIsNotNull() {
			addCriterion("MAIN_ASSESS_NAME is not null");
			return (Criteria) this;
		}

		public Criteria andMainAssessNameEqualTo(String value) {
			addCriterion("MAIN_ASSESS_NAME =", value, "mainAssessName");
			return (Criteria) this;
		}

		public Criteria andMainAssessNameNotEqualTo(String value) {
			addCriterion("MAIN_ASSESS_NAME <>", value, "mainAssessName");
			return (Criteria) this;
		}

		public Criteria andMainAssessNameGreaterThan(String value) {
			addCriterion("MAIN_ASSESS_NAME >", value, "mainAssessName");
			return (Criteria) this;
		}

		public Criteria andMainAssessNameGreaterThanOrEqualTo(String value) {
			addCriterion("MAIN_ASSESS_NAME >=", value, "mainAssessName");
			return (Criteria) this;
		}

		public Criteria andMainAssessNameLessThan(String value) {
			addCriterion("MAIN_ASSESS_NAME <", value, "mainAssessName");
			return (Criteria) this;
		}

		public Criteria andMainAssessNameLessThanOrEqualTo(String value) {
			addCriterion("MAIN_ASSESS_NAME <=", value, "mainAssessName");
			return (Criteria) this;
		}

		public Criteria andMainAssessNameLike(String value) {
			addCriterion("MAIN_ASSESS_NAME like", value, "mainAssessName");
			return (Criteria) this;
		}

		public Criteria andMainAssessNameNotLike(String value) {
			addCriterion("MAIN_ASSESS_NAME not like", value, "mainAssessName");
			return (Criteria) this;
		}

		public Criteria andMainAssessNameIn(List<String> values) {
			addCriterion("MAIN_ASSESS_NAME in", values, "mainAssessName");
			return (Criteria) this;
		}

		public Criteria andMainAssessNameNotIn(List<String> values) {
			addCriterion("MAIN_ASSESS_NAME not in", values, "mainAssessName");
			return (Criteria) this;
		}

		public Criteria andMainAssessNameBetween(String value1, String value2) {
			addCriterion("MAIN_ASSESS_NAME between", value1, value2, "mainAssessName");
			return (Criteria) this;
		}

		public Criteria andMainAssessNameNotBetween(String value1, String value2) {
			addCriterion("MAIN_ASSESS_NAME not between", value1, value2, "mainAssessName");
			return (Criteria) this;
		}

		public Criteria andSecondAssessNameIsNull() {
			addCriterion("SECOND_ASSESS_NAME is null");
			return (Criteria) this;
		}

		public Criteria andSecondAssessNameIsNotNull() {
			addCriterion("SECOND_ASSESS_NAME is not null");
			return (Criteria) this;
		}

		public Criteria andSecondAssessNameEqualTo(String value) {
			addCriterion("SECOND_ASSESS_NAME =", value, "secondAssessName");
			return (Criteria) this;
		}

		public Criteria andSecondAssessNameNotEqualTo(String value) {
			addCriterion("SECOND_ASSESS_NAME <>", value, "secondAssessName");
			return (Criteria) this;
		}

		public Criteria andSecondAssessNameGreaterThan(String value) {
			addCriterion("SECOND_ASSESS_NAME >", value, "secondAssessName");
			return (Criteria) this;
		}

		public Criteria andSecondAssessNameGreaterThanOrEqualTo(String value) {
			addCriterion("SECOND_ASSESS_NAME >=", value, "secondAssessName");
			return (Criteria) this;
		}

		public Criteria andSecondAssessNameLessThan(String value) {
			addCriterion("SECOND_ASSESS_NAME <", value, "secondAssessName");
			return (Criteria) this;
		}

		public Criteria andSecondAssessNameLessThanOrEqualTo(String value) {
			addCriterion("SECOND_ASSESS_NAME <=", value, "secondAssessName");
			return (Criteria) this;
		}

		public Criteria andSecondAssessNameLike(String value) {
			addCriterion("SECOND_ASSESS_NAME like", value, "secondAssessName");
			return (Criteria) this;
		}

		public Criteria andSecondAssessNameNotLike(String value) {
			addCriterion("SECOND_ASSESS_NAME not like", value, "secondAssessName");
			return (Criteria) this;
		}

		public Criteria andSecondAssessNameIn(List<String> values) {
			addCriterion("SECOND_ASSESS_NAME in", values, "secondAssessName");
			return (Criteria) this;
		}

		public Criteria andSecondAssessNameNotIn(List<String> values) {
			addCriterion("SECOND_ASSESS_NAME not in", values, "secondAssessName");
			return (Criteria) this;
		}

		public Criteria andSecondAssessNameBetween(String value1, String value2) {
			addCriterion("SECOND_ASSESS_NAME between", value1, value2, "secondAssessName");
			return (Criteria) this;
		}

		public Criteria andSecondAssessNameNotBetween(String value1, String value2) {
			addCriterion("SECOND_ASSESS_NAME not between", value1, value2, "secondAssessName");
			return (Criteria) this;
		}

		public Criteria andTranceferPledgeDescIsNull() {
			addCriterion("TRANCEFER_PLEDGE_DESC is null");
			return (Criteria) this;
		}

		public Criteria andTranceferPledgeDescIsNotNull() {
			addCriterion("TRANCEFER_PLEDGE_DESC is not null");
			return (Criteria) this;
		}

		public Criteria andTranceferPledgeDescEqualTo(String value) {
			addCriterion("TRANCEFER_PLEDGE_DESC =", value, "tranceferPledgeDesc");
			return (Criteria) this;
		}

		public Criteria andTranceferPledgeDescNotEqualTo(String value) {
			addCriterion("TRANCEFER_PLEDGE_DESC <>", value, "tranceferPledgeDesc");
			return (Criteria) this;
		}

		public Criteria andTranceferPledgeDescGreaterThan(String value) {
			addCriterion("TRANCEFER_PLEDGE_DESC >", value, "tranceferPledgeDesc");
			return (Criteria) this;
		}

		public Criteria andTranceferPledgeDescGreaterThanOrEqualTo(String value) {
			addCriterion("TRANCEFER_PLEDGE_DESC >=", value, "tranceferPledgeDesc");
			return (Criteria) this;
		}

		public Criteria andTranceferPledgeDescLessThan(String value) {
			addCriterion("TRANCEFER_PLEDGE_DESC <", value, "tranceferPledgeDesc");
			return (Criteria) this;
		}

		public Criteria andTranceferPledgeDescLessThanOrEqualTo(String value) {
			addCriterion("TRANCEFER_PLEDGE_DESC <=", value, "tranceferPledgeDesc");
			return (Criteria) this;
		}

		public Criteria andTranceferPledgeDescLike(String value) {
			addCriterion("TRANCEFER_PLEDGE_DESC like", value, "tranceferPledgeDesc");
			return (Criteria) this;
		}

		public Criteria andTranceferPledgeDescNotLike(String value) {
			addCriterion("TRANCEFER_PLEDGE_DESC not like", value, "tranceferPledgeDesc");
			return (Criteria) this;
		}

		public Criteria andTranceferPledgeDescIn(List<String> values) {
			addCriterion("TRANCEFER_PLEDGE_DESC in", values, "tranceferPledgeDesc");
			return (Criteria) this;
		}

		public Criteria andTranceferPledgeDescNotIn(List<String> values) {
			addCriterion("TRANCEFER_PLEDGE_DESC not in", values, "tranceferPledgeDesc");
			return (Criteria) this;
		}

		public Criteria andTranceferPledgeDescBetween(String value1, String value2) {
			addCriterion("TRANCEFER_PLEDGE_DESC between", value1, value2, "tranceferPledgeDesc");
			return (Criteria) this;
		}

		public Criteria andTranceferPledgeDescNotBetween(String value1, String value2) {
			addCriterion("TRANCEFER_PLEDGE_DESC not between", value1, value2, "tranceferPledgeDesc");
			return (Criteria) this;
		}

		public Criteria andIfAddressChangeIsNull() {
			addCriterion("IF_ADDRESS_CHANGE is null");
			return (Criteria) this;
		}

		public Criteria andIfAddressChangeIsNotNull() {
			addCriterion("IF_ADDRESS_CHANGE is not null");
			return (Criteria) this;
		}

		public Criteria andIfAddressChangeEqualTo(Byte value) {
			addCriterion("IF_ADDRESS_CHANGE =", value, "ifAddressChange");
			return (Criteria) this;
		}

		public Criteria andIfAddressChangeNotEqualTo(Byte value) {
			addCriterion("IF_ADDRESS_CHANGE <>", value, "ifAddressChange");
			return (Criteria) this;
		}

		public Criteria andIfAddressChangeGreaterThan(Byte value) {
			addCriterion("IF_ADDRESS_CHANGE >", value, "ifAddressChange");
			return (Criteria) this;
		}

		public Criteria andIfAddressChangeGreaterThanOrEqualTo(Byte value) {
			addCriterion("IF_ADDRESS_CHANGE >=", value, "ifAddressChange");
			return (Criteria) this;
		}

		public Criteria andIfAddressChangeLessThan(Byte value) {
			addCriterion("IF_ADDRESS_CHANGE <", value, "ifAddressChange");
			return (Criteria) this;
		}

		public Criteria andIfAddressChangeLessThanOrEqualTo(Byte value) {
			addCriterion("IF_ADDRESS_CHANGE <=", value, "ifAddressChange");
			return (Criteria) this;
		}

		public Criteria andIfAddressChangeIn(List<Byte> values) {
			addCriterion("IF_ADDRESS_CHANGE in", values, "ifAddressChange");
			return (Criteria) this;
		}

		public Criteria andIfAddressChangeNotIn(List<Byte> values) {
			addCriterion("IF_ADDRESS_CHANGE not in", values, "ifAddressChange");
			return (Criteria) this;
		}

		public Criteria andIfAddressChangeBetween(Byte value1, Byte value2) {
			addCriterion("IF_ADDRESS_CHANGE between", value1, value2, "ifAddressChange");
			return (Criteria) this;
		}

		public Criteria andIfAddressChangeNotBetween(Byte value1, Byte value2) {
			addCriterion("IF_ADDRESS_CHANGE not between", value1, value2, "ifAddressChange");
			return (Criteria) this;
		}

		public Criteria andAssessUnitPriceIsNull() {
			addCriterion("ASSESS_UNIT_PRICE is null");
			return (Criteria) this;
		}

		public Criteria andAssessUnitPriceIsNotNull() {
			addCriterion("ASSESS_UNIT_PRICE is not null");
			return (Criteria) this;
		}

		public Criteria andAssessUnitPriceEqualTo(BigDecimal value) {
			addCriterion("ASSESS_UNIT_PRICE =", value, "assessUnitPrice");
			return (Criteria) this;
		}

		public Criteria andAssessUnitPriceNotEqualTo(BigDecimal value) {
			addCriterion("ASSESS_UNIT_PRICE <>", value, "assessUnitPrice");
			return (Criteria) this;
		}

		public Criteria andAssessUnitPriceGreaterThan(BigDecimal value) {
			addCriterion("ASSESS_UNIT_PRICE >", value, "assessUnitPrice");
			return (Criteria) this;
		}

		public Criteria andAssessUnitPriceGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("ASSESS_UNIT_PRICE >=", value, "assessUnitPrice");
			return (Criteria) this;
		}

		public Criteria andAssessUnitPriceLessThan(BigDecimal value) {
			addCriterion("ASSESS_UNIT_PRICE <", value, "assessUnitPrice");
			return (Criteria) this;
		}

		public Criteria andAssessUnitPriceLessThanOrEqualTo(BigDecimal value) {
			addCriterion("ASSESS_UNIT_PRICE <=", value, "assessUnitPrice");
			return (Criteria) this;
		}

		public Criteria andAssessUnitPriceIn(List<BigDecimal> values) {
			addCriterion("ASSESS_UNIT_PRICE in", values, "assessUnitPrice");
			return (Criteria) this;
		}

		public Criteria andAssessUnitPriceNotIn(List<BigDecimal> values) {
			addCriterion("ASSESS_UNIT_PRICE not in", values, "assessUnitPrice");
			return (Criteria) this;
		}

		public Criteria andAssessUnitPriceBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("ASSESS_UNIT_PRICE between", value1, value2, "assessUnitPrice");
			return (Criteria) this;
		}

		public Criteria andAssessUnitPriceNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("ASSESS_UNIT_PRICE not between", value1, value2, "assessUnitPrice");
			return (Criteria) this;
		}

		public Criteria andIfRedeemHouseIsNull() {
			addCriterion("IF_REDEEM_HOUSE is null");
			return (Criteria) this;
		}

		public Criteria andIfRedeemHouseIsNotNull() {
			addCriterion("IF_REDEEM_HOUSE is not null");
			return (Criteria) this;
		}

		public Criteria andIfRedeemHouseEqualTo(Byte value) {
			addCriterion("IF_REDEEM_HOUSE =", value, "ifRedeemHouse");
			return (Criteria) this;
		}

		public Criteria andIfRedeemHouseNotEqualTo(Byte value) {
			addCriterion("IF_REDEEM_HOUSE <>", value, "ifRedeemHouse");
			return (Criteria) this;
		}

		public Criteria andIfRedeemHouseGreaterThan(Byte value) {
			addCriterion("IF_REDEEM_HOUSE >", value, "ifRedeemHouse");
			return (Criteria) this;
		}

		public Criteria andIfRedeemHouseGreaterThanOrEqualTo(Byte value) {
			addCriterion("IF_REDEEM_HOUSE >=", value, "ifRedeemHouse");
			return (Criteria) this;
		}

		public Criteria andIfRedeemHouseLessThan(Byte value) {
			addCriterion("IF_REDEEM_HOUSE <", value, "ifRedeemHouse");
			return (Criteria) this;
		}

		public Criteria andIfRedeemHouseLessThanOrEqualTo(Byte value) {
			addCriterion("IF_REDEEM_HOUSE <=", value, "ifRedeemHouse");
			return (Criteria) this;
		}

		public Criteria andIfRedeemHouseIn(List<Byte> values) {
			addCriterion("IF_REDEEM_HOUSE in", values, "ifRedeemHouse");
			return (Criteria) this;
		}

		public Criteria andIfRedeemHouseNotIn(List<Byte> values) {
			addCriterion("IF_REDEEM_HOUSE not in", values, "ifRedeemHouse");
			return (Criteria) this;
		}

		public Criteria andIfRedeemHouseBetween(Byte value1, Byte value2) {
			addCriterion("IF_REDEEM_HOUSE between", value1, value2, "ifRedeemHouse");
			return (Criteria) this;
		}

		public Criteria andIfRedeemHouseNotBetween(Byte value1, Byte value2) {
			addCriterion("IF_REDEEM_HOUSE not between", value1, value2, "ifRedeemHouse");
			return (Criteria) this;
		}

		public Criteria andSentApprovalTimeIsNull() {
			addCriterion("SENT_APPROVAL_TIME is null");
			return (Criteria) this;
		}

		public Criteria andSentApprovalTimeIsNotNull() {
			addCriterion("SENT_APPROVAL_TIME is not null");
			return (Criteria) this;
		}

		public Criteria andSentApprovalTimeEqualTo(Date value) {
			addCriterion("SENT_APPROVAL_TIME =", value, "sentApprovalTime");
			return (Criteria) this;
		}

		public Criteria andSentApprovalTimeNotEqualTo(Date value) {
			addCriterion("SENT_APPROVAL_TIME <>", value, "sentApprovalTime");
			return (Criteria) this;
		}

		public Criteria andSentApprovalTimeGreaterThan(Date value) {
			addCriterion("SENT_APPROVAL_TIME >", value, "sentApprovalTime");
			return (Criteria) this;
		}

		public Criteria andSentApprovalTimeGreaterThanOrEqualTo(Date value) {
			addCriterion("SENT_APPROVAL_TIME >=", value, "sentApprovalTime");
			return (Criteria) this;
		}

		public Criteria andSentApprovalTimeLessThan(Date value) {
			addCriterion("SENT_APPROVAL_TIME <", value, "sentApprovalTime");
			return (Criteria) this;
		}

		public Criteria andSentApprovalTimeLessThanOrEqualTo(Date value) {
			addCriterion("SENT_APPROVAL_TIME <=", value, "sentApprovalTime");
			return (Criteria) this;
		}

		public Criteria andSentApprovalTimeIn(List<Date> values) {
			addCriterion("SENT_APPROVAL_TIME in", values, "sentApprovalTime");
			return (Criteria) this;
		}

		public Criteria andSentApprovalTimeNotIn(List<Date> values) {
			addCriterion("SENT_APPROVAL_TIME not in", values, "sentApprovalTime");
			return (Criteria) this;
		}

		public Criteria andSentApprovalTimeBetween(Date value1, Date value2) {
			addCriterion("SENT_APPROVAL_TIME between", value1, value2, "sentApprovalTime");
			return (Criteria) this;
		}

		public Criteria andSentApprovalTimeNotBetween(Date value1, Date value2) {
			addCriterion("SENT_APPROVAL_TIME not between", value1, value2, "sentApprovalTime");
			return (Criteria) this;
		}

		public Criteria andBankAttentionMattersIsNull() {
			addCriterion("BANK_ATTENTION_MATTERS is null");
			return (Criteria) this;
		}

		public Criteria andBankAttentionMattersIsNotNull() {
			addCriterion("BANK_ATTENTION_MATTERS is not null");
			return (Criteria) this;
		}

		public Criteria andBankAttentionMattersEqualTo(String value) {
			addCriterion("BANK_ATTENTION_MATTERS =", value, "bankAttentionMatters");
			return (Criteria) this;
		}

		public Criteria andBankAttentionMattersNotEqualTo(String value) {
			addCriterion("BANK_ATTENTION_MATTERS <>", value, "bankAttentionMatters");
			return (Criteria) this;
		}

		public Criteria andBankAttentionMattersGreaterThan(String value) {
			addCriterion("BANK_ATTENTION_MATTERS >", value, "bankAttentionMatters");
			return (Criteria) this;
		}

		public Criteria andBankAttentionMattersGreaterThanOrEqualTo(String value) {
			addCriterion("BANK_ATTENTION_MATTERS >=", value, "bankAttentionMatters");
			return (Criteria) this;
		}

		public Criteria andBankAttentionMattersLessThan(String value) {
			addCriterion("BANK_ATTENTION_MATTERS <", value, "bankAttentionMatters");
			return (Criteria) this;
		}

		public Criteria andBankAttentionMattersLessThanOrEqualTo(String value) {
			addCriterion("BANK_ATTENTION_MATTERS <=", value, "bankAttentionMatters");
			return (Criteria) this;
		}

		public Criteria andBankAttentionMattersLike(String value) {
			addCriterion("BANK_ATTENTION_MATTERS like", value, "bankAttentionMatters");
			return (Criteria) this;
		}

		public Criteria andBankAttentionMattersNotLike(String value) {
			addCriterion("BANK_ATTENTION_MATTERS not like", value, "bankAttentionMatters");
			return (Criteria) this;
		}

		public Criteria andBankAttentionMattersIn(List<String> values) {
			addCriterion("BANK_ATTENTION_MATTERS in", values, "bankAttentionMatters");
			return (Criteria) this;
		}

		public Criteria andBankAttentionMattersNotIn(List<String> values) {
			addCriterion("BANK_ATTENTION_MATTERS not in", values, "bankAttentionMatters");
			return (Criteria) this;
		}

		public Criteria andBankAttentionMattersBetween(String value1, String value2) {
			addCriterion("BANK_ATTENTION_MATTERS between", value1, value2, "bankAttentionMatters");
			return (Criteria) this;
		}

		public Criteria andBankAttentionMattersNotBetween(String value1, String value2) {
			addCriterion("BANK_ATTENTION_MATTERS not between", value1, value2, "bankAttentionMatters");
			return (Criteria) this;
		}

		public Criteria andTransferEmployeeIsNull() {
			addCriterion("TRANSFER_EMPLOYEE is null");
			return (Criteria) this;
		}

		public Criteria andTransferEmployeeIsNotNull() {
			addCriterion("TRANSFER_EMPLOYEE is not null");
			return (Criteria) this;
		}

		public Criteria andTransferEmployeeEqualTo(Integer value) {
			addCriterion("TRANSFER_EMPLOYEE =", value, "transferEmployee");
			return (Criteria) this;
		}

		public Criteria andTransferEmployeeNotEqualTo(Integer value) {
			addCriterion("TRANSFER_EMPLOYEE <>", value, "transferEmployee");
			return (Criteria) this;
		}

		public Criteria andTransferEmployeeGreaterThan(Integer value) {
			addCriterion("TRANSFER_EMPLOYEE >", value, "transferEmployee");
			return (Criteria) this;
		}

		public Criteria andTransferEmployeeGreaterThanOrEqualTo(Integer value) {
			addCriterion("TRANSFER_EMPLOYEE >=", value, "transferEmployee");
			return (Criteria) this;
		}

		public Criteria andTransferEmployeeLessThan(Integer value) {
			addCriterion("TRANSFER_EMPLOYEE <", value, "transferEmployee");
			return (Criteria) this;
		}

		public Criteria andTransferEmployeeLessThanOrEqualTo(Integer value) {
			addCriterion("TRANSFER_EMPLOYEE <=", value, "transferEmployee");
			return (Criteria) this;
		}

		public Criteria andTransferEmployeeIn(List<Integer> values) {
			addCriterion("TRANSFER_EMPLOYEE in", values, "transferEmployee");
			return (Criteria) this;
		}

		public Criteria andTransferEmployeeNotIn(List<Integer> values) {
			addCriterion("TRANSFER_EMPLOYEE not in", values, "transferEmployee");
			return (Criteria) this;
		}

		public Criteria andTransferEmployeeBetween(Integer value1, Integer value2) {
			addCriterion("TRANSFER_EMPLOYEE between", value1, value2, "transferEmployee");
			return (Criteria) this;
		}

		public Criteria andTransferEmployeeNotBetween(Integer value1, Integer value2) {
			addCriterion("TRANSFER_EMPLOYEE not between", value1, value2, "transferEmployee");
			return (Criteria) this;
		}

		public Criteria andPledgeEmployeeIsNull() {
			addCriterion("PLEDGE_EMPLOYEE is null");
			return (Criteria) this;
		}

		public Criteria andPledgeEmployeeIsNotNull() {
			addCriterion("PLEDGE_EMPLOYEE is not null");
			return (Criteria) this;
		}

		public Criteria andPledgeEmployeeEqualTo(Integer value) {
			addCriterion("PLEDGE_EMPLOYEE =", value, "pledgeEmployee");
			return (Criteria) this;
		}

		public Criteria andPledgeEmployeeNotEqualTo(Integer value) {
			addCriterion("PLEDGE_EMPLOYEE <>", value, "pledgeEmployee");
			return (Criteria) this;
		}

		public Criteria andPledgeEmployeeGreaterThan(Integer value) {
			addCriterion("PLEDGE_EMPLOYEE >", value, "pledgeEmployee");
			return (Criteria) this;
		}

		public Criteria andPledgeEmployeeGreaterThanOrEqualTo(Integer value) {
			addCriterion("PLEDGE_EMPLOYEE >=", value, "pledgeEmployee");
			return (Criteria) this;
		}

		public Criteria andPledgeEmployeeLessThan(Integer value) {
			addCriterion("PLEDGE_EMPLOYEE <", value, "pledgeEmployee");
			return (Criteria) this;
		}

		public Criteria andPledgeEmployeeLessThanOrEqualTo(Integer value) {
			addCriterion("PLEDGE_EMPLOYEE <=", value, "pledgeEmployee");
			return (Criteria) this;
		}

		public Criteria andPledgeEmployeeIn(List<Integer> values) {
			addCriterion("PLEDGE_EMPLOYEE in", values, "pledgeEmployee");
			return (Criteria) this;
		}

		public Criteria andPledgeEmployeeNotIn(List<Integer> values) {
			addCriterion("PLEDGE_EMPLOYEE not in", values, "pledgeEmployee");
			return (Criteria) this;
		}

		public Criteria andPledgeEmployeeBetween(Integer value1, Integer value2) {
			addCriterion("PLEDGE_EMPLOYEE between", value1, value2, "pledgeEmployee");
			return (Criteria) this;
		}

		public Criteria andPledgeEmployeeNotBetween(Integer value1, Integer value2) {
			addCriterion("PLEDGE_EMPLOYEE not between", value1, value2, "pledgeEmployee");
			return (Criteria) this;
		}

		public Criteria andIfRelevanceIsNull() {
			addCriterion("IF_RELEVANCE is null");
			return (Criteria) this;
		}

		public Criteria andIfRelevanceIsNotNull() {
			addCriterion("IF_RELEVANCE is not null");
			return (Criteria) this;
		}

		public Criteria andIfRelevanceEqualTo(Byte value) {
			addCriterion("IF_RELEVANCE =", value, "ifRelevance");
			return (Criteria) this;
		}

		public Criteria andIfRelevanceNotEqualTo(Byte value) {
			addCriterion("IF_RELEVANCE <>", value, "ifRelevance");
			return (Criteria) this;
		}

		public Criteria andIfRelevanceGreaterThan(Byte value) {
			addCriterion("IF_RELEVANCE >", value, "ifRelevance");
			return (Criteria) this;
		}

		public Criteria andIfRelevanceGreaterThanOrEqualTo(Byte value) {
			addCriterion("IF_RELEVANCE >=", value, "ifRelevance");
			return (Criteria) this;
		}

		public Criteria andIfRelevanceLessThan(Byte value) {
			addCriterion("IF_RELEVANCE <", value, "ifRelevance");
			return (Criteria) this;
		}

		public Criteria andIfRelevanceLessThanOrEqualTo(Byte value) {
			addCriterion("IF_RELEVANCE <=", value, "ifRelevance");
			return (Criteria) this;
		}

		public Criteria andIfRelevanceIn(List<Byte> values) {
			addCriterion("IF_RELEVANCE in", values, "ifRelevance");
			return (Criteria) this;
		}

		public Criteria andIfRelevanceNotIn(List<Byte> values) {
			addCriterion("IF_RELEVANCE not in", values, "ifRelevance");
			return (Criteria) this;
		}

		public Criteria andIfRelevanceBetween(Byte value1, Byte value2) {
			addCriterion("IF_RELEVANCE between", value1, value2, "ifRelevance");
			return (Criteria) this;
		}

		public Criteria andIfRelevanceNotBetween(Byte value1, Byte value2) {
			addCriterion("IF_RELEVANCE not between", value1, value2, "ifRelevance");
			return (Criteria) this;
		}

		public Criteria andRelevanceTimeIsNull() {
			addCriterion("RELEVANCE_TIME is null");
			return (Criteria) this;
		}

		public Criteria andRelevanceTimeIsNotNull() {
			addCriterion("RELEVANCE_TIME is not null");
			return (Criteria) this;
		}

		public Criteria andRelevanceTimeEqualTo(Date value) {
			addCriterion("RELEVANCE_TIME =", value, "relevanceTime");
			return (Criteria) this;
		}

		public Criteria andRelevanceTimeNotEqualTo(Date value) {
			addCriterion("RELEVANCE_TIME <>", value, "relevanceTime");
			return (Criteria) this;
		}

		public Criteria andRelevanceTimeGreaterThan(Date value) {
			addCriterion("RELEVANCE_TIME >", value, "relevanceTime");
			return (Criteria) this;
		}

		public Criteria andRelevanceTimeGreaterThanOrEqualTo(Date value) {
			addCriterion("RELEVANCE_TIME >=", value, "relevanceTime");
			return (Criteria) this;
		}

		public Criteria andRelevanceTimeLessThan(Date value) {
			addCriterion("RELEVANCE_TIME <", value, "relevanceTime");
			return (Criteria) this;
		}

		public Criteria andRelevanceTimeLessThanOrEqualTo(Date value) {
			addCriterion("RELEVANCE_TIME <=", value, "relevanceTime");
			return (Criteria) this;
		}

		public Criteria andRelevanceTimeIn(List<Date> values) {
			addCriterion("RELEVANCE_TIME in", values, "relevanceTime");
			return (Criteria) this;
		}

		public Criteria andRelevanceTimeNotIn(List<Date> values) {
			addCriterion("RELEVANCE_TIME not in", values, "relevanceTime");
			return (Criteria) this;
		}

		public Criteria andRelevanceTimeBetween(Date value1, Date value2) {
			addCriterion("RELEVANCE_TIME between", value1, value2, "relevanceTime");
			return (Criteria) this;
		}

		public Criteria andRelevanceTimeNotBetween(Date value1, Date value2) {
			addCriterion("RELEVANCE_TIME not between", value1, value2, "relevanceTime");
			return (Criteria) this;
		}

		public Criteria andTransactionTransferTimeIsNull() {
			addCriterion("TRANSACTION_TRANSFER_TIME is null");
			return (Criteria) this;
		}

		public Criteria andTransactionTransferTimeIsNotNull() {
			addCriterion("TRANSACTION_TRANSFER_TIME is not null");
			return (Criteria) this;
		}

		public Criteria andTransactionTransferTimeEqualTo(Date value) {
			addCriterion("TRANSACTION_TRANSFER_TIME =", value, "transactionTransferTime");
			return (Criteria) this;
		}

		public Criteria andTransactionTransferTimeNotEqualTo(Date value) {
			addCriterion("TRANSACTION_TRANSFER_TIME <>", value, "transactionTransferTime");
			return (Criteria) this;
		}

		public Criteria andTransactionTransferTimeGreaterThan(Date value) {
			addCriterion("TRANSACTION_TRANSFER_TIME >", value, "transactionTransferTime");
			return (Criteria) this;
		}

		public Criteria andTransactionTransferTimeGreaterThanOrEqualTo(Date value) {
			addCriterion("TRANSACTION_TRANSFER_TIME >=", value, "transactionTransferTime");
			return (Criteria) this;
		}

		public Criteria andTransactionTransferTimeLessThan(Date value) {
			addCriterion("TRANSACTION_TRANSFER_TIME <", value, "transactionTransferTime");
			return (Criteria) this;
		}

		public Criteria andTransactionTransferTimeLessThanOrEqualTo(Date value) {
			addCriterion("TRANSACTION_TRANSFER_TIME <=", value, "transactionTransferTime");
			return (Criteria) this;
		}

		public Criteria andTransactionTransferTimeIn(List<Date> values) {
			addCriterion("TRANSACTION_TRANSFER_TIME in", values, "transactionTransferTime");
			return (Criteria) this;
		}

		public Criteria andTransactionTransferTimeNotIn(List<Date> values) {
			addCriterion("TRANSACTION_TRANSFER_TIME not in", values, "transactionTransferTime");
			return (Criteria) this;
		}

		public Criteria andTransactionTransferTimeBetween(Date value1, Date value2) {
			addCriterion("TRANSACTION_TRANSFER_TIME between", value1, value2, "transactionTransferTime");
			return (Criteria) this;
		}

		public Criteria andTransactionTransferTimeNotBetween(Date value1, Date value2) {
			addCriterion("TRANSACTION_TRANSFER_TIME not between", value1, value2, "transactionTransferTime");
			return (Criteria) this;
		}

		public Criteria andIfVendorEntrustIsNull() {
			addCriterion("IF_VENDOR_ENTRUST is null");
			return (Criteria) this;
		}

		public Criteria andIfVendorEntrustIsNotNull() {
			addCriterion("IF_VENDOR_ENTRUST is not null");
			return (Criteria) this;
		}

		public Criteria andIfVendorEntrustEqualTo(Byte value) {
			addCriterion("IF_VENDOR_ENTRUST =", value, "ifVendorEntrust");
			return (Criteria) this;
		}

		public Criteria andIfVendorEntrustNotEqualTo(Byte value) {
			addCriterion("IF_VENDOR_ENTRUST <>", value, "ifVendorEntrust");
			return (Criteria) this;
		}

		public Criteria andIfVendorEntrustGreaterThan(Byte value) {
			addCriterion("IF_VENDOR_ENTRUST >", value, "ifVendorEntrust");
			return (Criteria) this;
		}

		public Criteria andIfVendorEntrustGreaterThanOrEqualTo(Byte value) {
			addCriterion("IF_VENDOR_ENTRUST >=", value, "ifVendorEntrust");
			return (Criteria) this;
		}

		public Criteria andIfVendorEntrustLessThan(Byte value) {
			addCriterion("IF_VENDOR_ENTRUST <", value, "ifVendorEntrust");
			return (Criteria) this;
		}

		public Criteria andIfVendorEntrustLessThanOrEqualTo(Byte value) {
			addCriterion("IF_VENDOR_ENTRUST <=", value, "ifVendorEntrust");
			return (Criteria) this;
		}

		public Criteria andIfVendorEntrustIn(List<Byte> values) {
			addCriterion("IF_VENDOR_ENTRUST in", values, "ifVendorEntrust");
			return (Criteria) this;
		}

		public Criteria andIfVendorEntrustNotIn(List<Byte> values) {
			addCriterion("IF_VENDOR_ENTRUST not in", values, "ifVendorEntrust");
			return (Criteria) this;
		}

		public Criteria andIfVendorEntrustBetween(Byte value1, Byte value2) {
			addCriterion("IF_VENDOR_ENTRUST between", value1, value2, "ifVendorEntrust");
			return (Criteria) this;
		}

		public Criteria andIfVendorEntrustNotBetween(Byte value1, Byte value2) {
			addCriterion("IF_VENDOR_ENTRUST not between", value1, value2, "ifVendorEntrust");
			return (Criteria) this;
		}

		public Criteria andIfVendeeEntrustIsNull() {
			addCriterion("IF_VENDEE_ENTRUST is null");
			return (Criteria) this;
		}

		public Criteria andIfVendeeEntrustIsNotNull() {
			addCriterion("IF_VENDEE_ENTRUST is not null");
			return (Criteria) this;
		}

		public Criteria andIfVendeeEntrustEqualTo(Byte value) {
			addCriterion("IF_VENDEE_ENTRUST =", value, "ifVendeeEntrust");
			return (Criteria) this;
		}

		public Criteria andIfVendeeEntrustNotEqualTo(Byte value) {
			addCriterion("IF_VENDEE_ENTRUST <>", value, "ifVendeeEntrust");
			return (Criteria) this;
		}

		public Criteria andIfVendeeEntrustGreaterThan(Byte value) {
			addCriterion("IF_VENDEE_ENTRUST >", value, "ifVendeeEntrust");
			return (Criteria) this;
		}

		public Criteria andIfVendeeEntrustGreaterThanOrEqualTo(Byte value) {
			addCriterion("IF_VENDEE_ENTRUST >=", value, "ifVendeeEntrust");
			return (Criteria) this;
		}

		public Criteria andIfVendeeEntrustLessThan(Byte value) {
			addCriterion("IF_VENDEE_ENTRUST <", value, "ifVendeeEntrust");
			return (Criteria) this;
		}

		public Criteria andIfVendeeEntrustLessThanOrEqualTo(Byte value) {
			addCriterion("IF_VENDEE_ENTRUST <=", value, "ifVendeeEntrust");
			return (Criteria) this;
		}

		public Criteria andIfVendeeEntrustIn(List<Byte> values) {
			addCriterion("IF_VENDEE_ENTRUST in", values, "ifVendeeEntrust");
			return (Criteria) this;
		}

		public Criteria andIfVendeeEntrustNotIn(List<Byte> values) {
			addCriterion("IF_VENDEE_ENTRUST not in", values, "ifVendeeEntrust");
			return (Criteria) this;
		}

		public Criteria andIfVendeeEntrustBetween(Byte value1, Byte value2) {
			addCriterion("IF_VENDEE_ENTRUST between", value1, value2, "ifVendeeEntrust");
			return (Criteria) this;
		}

		public Criteria andIfVendeeEntrustNotBetween(Byte value1, Byte value2) {
			addCriterion("IF_VENDEE_ENTRUST not between", value1, value2, "ifVendeeEntrust");
			return (Criteria) this;
		}

		public Criteria andReveicerIsNull() {
			addCriterion("REVEICER is null");
			return (Criteria) this;
		}

		public Criteria andReveicerIsNotNull() {
			addCriterion("REVEICER is not null");
			return (Criteria) this;
		}

		public Criteria andReveicerEqualTo(Integer value) {
			addCriterion("REVEICER =", value, "reveicer");
			return (Criteria) this;
		}

		public Criteria andReveicerNotEqualTo(Integer value) {
			addCriterion("REVEICER <>", value, "reveicer");
			return (Criteria) this;
		}

		public Criteria andReveicerGreaterThan(Integer value) {
			addCriterion("REVEICER >", value, "reveicer");
			return (Criteria) this;
		}

		public Criteria andReveicerGreaterThanOrEqualTo(Integer value) {
			addCriterion("REVEICER >=", value, "reveicer");
			return (Criteria) this;
		}

		public Criteria andReveicerLessThan(Integer value) {
			addCriterion("REVEICER <", value, "reveicer");
			return (Criteria) this;
		}

		public Criteria andReveicerLessThanOrEqualTo(Integer value) {
			addCriterion("REVEICER <=", value, "reveicer");
			return (Criteria) this;
		}

		public Criteria andReveicerIn(List<Integer> values) {
			addCriterion("REVEICER in", values, "reveicer");
			return (Criteria) this;
		}

		public Criteria andReveicerNotIn(List<Integer> values) {
			addCriterion("REVEICER not in", values, "reveicer");
			return (Criteria) this;
		}

		public Criteria andReveicerBetween(Integer value1, Integer value2) {
			addCriterion("REVEICER between", value1, value2, "reveicer");
			return (Criteria) this;
		}

		public Criteria andReveicerNotBetween(Integer value1, Integer value2) {
			addCriterion("REVEICER not between", value1, value2, "reveicer");
			return (Criteria) this;
		}

		public Criteria andZhengpingTimeIsNull() {
			addCriterion("ZHENGPING_TIME is null");
			return (Criteria) this;
		}

		public Criteria andZhengpingTimeIsNotNull() {
			addCriterion("ZHENGPING_TIME is not null");
			return (Criteria) this;
		}

		public Criteria andZhengpingTimeEqualTo(Date value) {
			addCriterion("ZHENGPING_TIME =", value, "zhengpingTime");
			return (Criteria) this;
		}

		public Criteria andZhengpingTimeNotEqualTo(Date value) {
			addCriterion("ZHENGPING_TIME <>", value, "zhengpingTime");
			return (Criteria) this;
		}

		public Criteria andZhengpingTimeGreaterThan(Date value) {
			addCriterion("ZHENGPING_TIME >", value, "zhengpingTime");
			return (Criteria) this;
		}

		public Criteria andZhengpingTimeGreaterThanOrEqualTo(Date value) {
			addCriterion("ZHENGPING_TIME >=", value, "zhengpingTime");
			return (Criteria) this;
		}

		public Criteria andZhengpingTimeLessThan(Date value) {
			addCriterion("ZHENGPING_TIME <", value, "zhengpingTime");
			return (Criteria) this;
		}

		public Criteria andZhengpingTimeLessThanOrEqualTo(Date value) {
			addCriterion("ZHENGPING_TIME <=", value, "zhengpingTime");
			return (Criteria) this;
		}

		public Criteria andZhengpingTimeIn(List<Date> values) {
			addCriterion("ZHENGPING_TIME in", values, "zhengpingTime");
			return (Criteria) this;
		}

		public Criteria andZhengpingTimeNotIn(List<Date> values) {
			addCriterion("ZHENGPING_TIME not in", values, "zhengpingTime");
			return (Criteria) this;
		}

		public Criteria andZhengpingTimeBetween(Date value1, Date value2) {
			addCriterion("ZHENGPING_TIME between", value1, value2, "zhengpingTime");
			return (Criteria) this;
		}

		public Criteria andZhengpingTimeNotBetween(Date value1, Date value2) {
			addCriterion("ZHENGPING_TIME not between", value1, value2, "zhengpingTime");
			return (Criteria) this;
		}

		public Criteria andTransferTaxPriceIsNull() {
			addCriterion("TRANSFER_TAX_PRICE is null");
			return (Criteria) this;
		}

		public Criteria andTransferTaxPriceIsNotNull() {
			addCriterion("TRANSFER_TAX_PRICE is not null");
			return (Criteria) this;
		}

		public Criteria andTransferTaxPriceEqualTo(String value) {
			addCriterion("TRANSFER_TAX_PRICE =", value, "transferTaxPrice");
			return (Criteria) this;
		}

		public Criteria andTransferTaxPriceNotEqualTo(String value) {
			addCriterion("TRANSFER_TAX_PRICE <>", value, "transferTaxPrice");
			return (Criteria) this;
		}

		public Criteria andTransferTaxPriceGreaterThan(String value) {
			addCriterion("TRANSFER_TAX_PRICE >", value, "transferTaxPrice");
			return (Criteria) this;
		}

		public Criteria andTransferTaxPriceGreaterThanOrEqualTo(String value) {
			addCriterion("TRANSFER_TAX_PRICE >=", value, "transferTaxPrice");
			return (Criteria) this;
		}

		public Criteria andTransferTaxPriceLessThan(String value) {
			addCriterion("TRANSFER_TAX_PRICE <", value, "transferTaxPrice");
			return (Criteria) this;
		}

		public Criteria andTransferTaxPriceLessThanOrEqualTo(String value) {
			addCriterion("TRANSFER_TAX_PRICE <=", value, "transferTaxPrice");
			return (Criteria) this;
		}

		public Criteria andTransferTaxPriceLike(String value) {
			addCriterion("TRANSFER_TAX_PRICE like", value, "transferTaxPrice");
			return (Criteria) this;
		}

		public Criteria andTransferTaxPriceNotLike(String value) {
			addCriterion("TRANSFER_TAX_PRICE not like", value, "transferTaxPrice");
			return (Criteria) this;
		}

		public Criteria andTransferTaxPriceIn(List<String> values) {
			addCriterion("TRANSFER_TAX_PRICE in", values, "transferTaxPrice");
			return (Criteria) this;
		}

		public Criteria andTransferTaxPriceNotIn(List<String> values) {
			addCriterion("TRANSFER_TAX_PRICE not in", values, "transferTaxPrice");
			return (Criteria) this;
		}

		public Criteria andTransferTaxPriceBetween(String value1, String value2) {
			addCriterion("TRANSFER_TAX_PRICE between", value1, value2, "transferTaxPrice");
			return (Criteria) this;
		}

		public Criteria andTransferTaxPriceNotBetween(String value1, String value2) {
			addCriterion("TRANSFER_TAX_PRICE not between", value1, value2, "transferTaxPrice");
			return (Criteria) this;
		}

		public Criteria andPapersTypeIsNull() {
			addCriterion("PAPERS_TYPE is null");
			return (Criteria) this;
		}

		public Criteria andPapersTypeIsNotNull() {
			addCriterion("PAPERS_TYPE is not null");
			return (Criteria) this;
		}

		public Criteria andPapersTypeEqualTo(Byte value) {
			addCriterion("PAPERS_TYPE =", value, "papersType");
			return (Criteria) this;
		}

		public Criteria andPapersTypeNotEqualTo(Byte value) {
			addCriterion("PAPERS_TYPE <>", value, "papersType");
			return (Criteria) this;
		}

		public Criteria andPapersTypeGreaterThan(Byte value) {
			addCriterion("PAPERS_TYPE >", value, "papersType");
			return (Criteria) this;
		}

		public Criteria andPapersTypeGreaterThanOrEqualTo(Byte value) {
			addCriterion("PAPERS_TYPE >=", value, "papersType");
			return (Criteria) this;
		}

		public Criteria andPapersTypeLessThan(Byte value) {
			addCriterion("PAPERS_TYPE <", value, "papersType");
			return (Criteria) this;
		}

		public Criteria andPapersTypeLessThanOrEqualTo(Byte value) {
			addCriterion("PAPERS_TYPE <=", value, "papersType");
			return (Criteria) this;
		}

		public Criteria andPapersTypeIn(List<Byte> values) {
			addCriterion("PAPERS_TYPE in", values, "papersType");
			return (Criteria) this;
		}

		public Criteria andPapersTypeNotIn(List<Byte> values) {
			addCriterion("PAPERS_TYPE not in", values, "papersType");
			return (Criteria) this;
		}

		public Criteria andPapersTypeBetween(Byte value1, Byte value2) {
			addCriterion("PAPERS_TYPE between", value1, value2, "papersType");
			return (Criteria) this;
		}

		public Criteria andPapersTypeNotBetween(Byte value1, Byte value2) {
			addCriterion("PAPERS_TYPE not between", value1, value2, "papersType");
			return (Criteria) this;
		}

		public Criteria andIfHandOverInformationIsNull() {
			addCriterion("IF_HAND_OVER_INFORMATION is null");
			return (Criteria) this;
		}

		public Criteria andIfHandOverInformationIsNotNull() {
			addCriterion("IF_HAND_OVER_INFORMATION is not null");
			return (Criteria) this;
		}

		public Criteria andIfHandOverInformationEqualTo(Byte value) {
			addCriterion("IF_HAND_OVER_INFORMATION =", value, "ifHandOverInformation");
			return (Criteria) this;
		}

		public Criteria andIfHandOverInformationNotEqualTo(Byte value) {
			addCriterion("IF_HAND_OVER_INFORMATION <>", value, "ifHandOverInformation");
			return (Criteria) this;
		}

		public Criteria andIfHandOverInformationGreaterThan(Byte value) {
			addCriterion("IF_HAND_OVER_INFORMATION >", value, "ifHandOverInformation");
			return (Criteria) this;
		}

		public Criteria andIfHandOverInformationGreaterThanOrEqualTo(Byte value) {
			addCriterion("IF_HAND_OVER_INFORMATION >=", value, "ifHandOverInformation");
			return (Criteria) this;
		}

		public Criteria andIfHandOverInformationLessThan(Byte value) {
			addCriterion("IF_HAND_OVER_INFORMATION <", value, "ifHandOverInformation");
			return (Criteria) this;
		}

		public Criteria andIfHandOverInformationLessThanOrEqualTo(Byte value) {
			addCriterion("IF_HAND_OVER_INFORMATION <=", value, "ifHandOverInformation");
			return (Criteria) this;
		}

		public Criteria andIfHandOverInformationIn(List<Byte> values) {
			addCriterion("IF_HAND_OVER_INFORMATION in", values, "ifHandOverInformation");
			return (Criteria) this;
		}

		public Criteria andIfHandOverInformationNotIn(List<Byte> values) {
			addCriterion("IF_HAND_OVER_INFORMATION not in", values, "ifHandOverInformation");
			return (Criteria) this;
		}

		public Criteria andIfHandOverInformationBetween(Byte value1, Byte value2) {
			addCriterion("IF_HAND_OVER_INFORMATION between", value1, value2, "ifHandOverInformation");
			return (Criteria) this;
		}

		public Criteria andIfHandOverInformationNotBetween(Byte value1, Byte value2) {
			addCriterion("IF_HAND_OVER_INFORMATION not between", value1, value2, "ifHandOverInformation");
			return (Criteria) this;
		}

		public Criteria andIfGatherOriginalChanquanIsNull() {
			addCriterion("IF_GATHER_ORIGINAL_CHANQUAN is null");
			return (Criteria) this;
		}

		public Criteria andIfGatherOriginalChanquanIsNotNull() {
			addCriterion("IF_GATHER_ORIGINAL_CHANQUAN is not null");
			return (Criteria) this;
		}

		public Criteria andIfGatherOriginalChanquanEqualTo(Byte value) {
			addCriterion("IF_GATHER_ORIGINAL_CHANQUAN =", value, "ifGatherOriginalChanquan");
			return (Criteria) this;
		}

		public Criteria andIfGatherOriginalChanquanNotEqualTo(Byte value) {
			addCriterion("IF_GATHER_ORIGINAL_CHANQUAN <>", value, "ifGatherOriginalChanquan");
			return (Criteria) this;
		}

		public Criteria andIfGatherOriginalChanquanGreaterThan(Byte value) {
			addCriterion("IF_GATHER_ORIGINAL_CHANQUAN >", value, "ifGatherOriginalChanquan");
			return (Criteria) this;
		}

		public Criteria andIfGatherOriginalChanquanGreaterThanOrEqualTo(Byte value) {
			addCriterion("IF_GATHER_ORIGINAL_CHANQUAN >=", value, "ifGatherOriginalChanquan");
			return (Criteria) this;
		}

		public Criteria andIfGatherOriginalChanquanLessThan(Byte value) {
			addCriterion("IF_GATHER_ORIGINAL_CHANQUAN <", value, "ifGatherOriginalChanquan");
			return (Criteria) this;
		}

		public Criteria andIfGatherOriginalChanquanLessThanOrEqualTo(Byte value) {
			addCriterion("IF_GATHER_ORIGINAL_CHANQUAN <=", value, "ifGatherOriginalChanquan");
			return (Criteria) this;
		}

		public Criteria andIfGatherOriginalChanquanIn(List<Byte> values) {
			addCriterion("IF_GATHER_ORIGINAL_CHANQUAN in", values, "ifGatherOriginalChanquan");
			return (Criteria) this;
		}

		public Criteria andIfGatherOriginalChanquanNotIn(List<Byte> values) {
			addCriterion("IF_GATHER_ORIGINAL_CHANQUAN not in", values, "ifGatherOriginalChanquan");
			return (Criteria) this;
		}

		public Criteria andIfGatherOriginalChanquanBetween(Byte value1, Byte value2) {
			addCriterion("IF_GATHER_ORIGINAL_CHANQUAN between", value1, value2, "ifGatherOriginalChanquan");
			return (Criteria) this;
		}

		public Criteria andIfGatherOriginalChanquanNotBetween(Byte value1, Byte value2) {
			addCriterion("IF_GATHER_ORIGINAL_CHANQUAN not between", value1, value2, "ifGatherOriginalChanquan");
			return (Criteria) this;
		}

		public Criteria andIfGatherOriginalGuotuIsNull() {
			addCriterion("IF_GATHER_ORIGINAL_GUOTU is null");
			return (Criteria) this;
		}

		public Criteria andIfGatherOriginalGuotuIsNotNull() {
			addCriterion("IF_GATHER_ORIGINAL_GUOTU is not null");
			return (Criteria) this;
		}

		public Criteria andIfGatherOriginalGuotuEqualTo(Byte value) {
			addCriterion("IF_GATHER_ORIGINAL_GUOTU =", value, "ifGatherOriginalGuotu");
			return (Criteria) this;
		}

		public Criteria andIfGatherOriginalGuotuNotEqualTo(Byte value) {
			addCriterion("IF_GATHER_ORIGINAL_GUOTU <>", value, "ifGatherOriginalGuotu");
			return (Criteria) this;
		}

		public Criteria andIfGatherOriginalGuotuGreaterThan(Byte value) {
			addCriterion("IF_GATHER_ORIGINAL_GUOTU >", value, "ifGatherOriginalGuotu");
			return (Criteria) this;
		}

		public Criteria andIfGatherOriginalGuotuGreaterThanOrEqualTo(Byte value) {
			addCriterion("IF_GATHER_ORIGINAL_GUOTU >=", value, "ifGatherOriginalGuotu");
			return (Criteria) this;
		}

		public Criteria andIfGatherOriginalGuotuLessThan(Byte value) {
			addCriterion("IF_GATHER_ORIGINAL_GUOTU <", value, "ifGatherOriginalGuotu");
			return (Criteria) this;
		}

		public Criteria andIfGatherOriginalGuotuLessThanOrEqualTo(Byte value) {
			addCriterion("IF_GATHER_ORIGINAL_GUOTU <=", value, "ifGatherOriginalGuotu");
			return (Criteria) this;
		}

		public Criteria andIfGatherOriginalGuotuIn(List<Byte> values) {
			addCriterion("IF_GATHER_ORIGINAL_GUOTU in", values, "ifGatherOriginalGuotu");
			return (Criteria) this;
		}

		public Criteria andIfGatherOriginalGuotuNotIn(List<Byte> values) {
			addCriterion("IF_GATHER_ORIGINAL_GUOTU not in", values, "ifGatherOriginalGuotu");
			return (Criteria) this;
		}

		public Criteria andIfGatherOriginalGuotuBetween(Byte value1, Byte value2) {
			addCriterion("IF_GATHER_ORIGINAL_GUOTU between", value1, value2, "ifGatherOriginalGuotu");
			return (Criteria) this;
		}

		public Criteria andIfGatherOriginalGuotuNotBetween(Byte value1, Byte value2) {
			addCriterion("IF_GATHER_ORIGINAL_GUOTU not between", value1, value2, "ifGatherOriginalGuotu");
			return (Criteria) this;
		}

		public Criteria andIfPublishHouseIsNull() {
			addCriterion("IF_PUBLISH_HOUSE is null");
			return (Criteria) this;
		}

		public Criteria andIfPublishHouseIsNotNull() {
			addCriterion("IF_PUBLISH_HOUSE is not null");
			return (Criteria) this;
		}

		public Criteria andIfPublishHouseEqualTo(Byte value) {
			addCriterion("IF_PUBLISH_HOUSE =", value, "ifPublishHouse");
			return (Criteria) this;
		}

		public Criteria andIfPublishHouseNotEqualTo(Byte value) {
			addCriterion("IF_PUBLISH_HOUSE <>", value, "ifPublishHouse");
			return (Criteria) this;
		}

		public Criteria andIfPublishHouseGreaterThan(Byte value) {
			addCriterion("IF_PUBLISH_HOUSE >", value, "ifPublishHouse");
			return (Criteria) this;
		}

		public Criteria andIfPublishHouseGreaterThanOrEqualTo(Byte value) {
			addCriterion("IF_PUBLISH_HOUSE >=", value, "ifPublishHouse");
			return (Criteria) this;
		}

		public Criteria andIfPublishHouseLessThan(Byte value) {
			addCriterion("IF_PUBLISH_HOUSE <", value, "ifPublishHouse");
			return (Criteria) this;
		}

		public Criteria andIfPublishHouseLessThanOrEqualTo(Byte value) {
			addCriterion("IF_PUBLISH_HOUSE <=", value, "ifPublishHouse");
			return (Criteria) this;
		}

		public Criteria andIfPublishHouseIn(List<Byte> values) {
			addCriterion("IF_PUBLISH_HOUSE in", values, "ifPublishHouse");
			return (Criteria) this;
		}

		public Criteria andIfPublishHouseNotIn(List<Byte> values) {
			addCriterion("IF_PUBLISH_HOUSE not in", values, "ifPublishHouse");
			return (Criteria) this;
		}

		public Criteria andIfPublishHouseBetween(Byte value1, Byte value2) {
			addCriterion("IF_PUBLISH_HOUSE between", value1, value2, "ifPublishHouse");
			return (Criteria) this;
		}

		public Criteria andIfPublishHouseNotBetween(Byte value1, Byte value2) {
			addCriterion("IF_PUBLISH_HOUSE not between", value1, value2, "ifPublishHouse");
			return (Criteria) this;
		}

		public Criteria andNetSignTransactorIsNull() {
			addCriterion("NET_SIGN_TRANSACTOR is null");
			return (Criteria) this;
		}

		public Criteria andNetSignTransactorIsNotNull() {
			addCriterion("NET_SIGN_TRANSACTOR is not null");
			return (Criteria) this;
		}

		public Criteria andNetSignTransactorEqualTo(Integer value) {
			addCriterion("NET_SIGN_TRANSACTOR =", value, "netSignTransactor");
			return (Criteria) this;
		}

		public Criteria andNetSignTransactorNotEqualTo(Integer value) {
			addCriterion("NET_SIGN_TRANSACTOR <>", value, "netSignTransactor");
			return (Criteria) this;
		}

		public Criteria andNetSignTransactorGreaterThan(Integer value) {
			addCriterion("NET_SIGN_TRANSACTOR >", value, "netSignTransactor");
			return (Criteria) this;
		}

		public Criteria andNetSignTransactorGreaterThanOrEqualTo(Integer value) {
			addCriterion("NET_SIGN_TRANSACTOR >=", value, "netSignTransactor");
			return (Criteria) this;
		}

		public Criteria andNetSignTransactorLessThan(Integer value) {
			addCriterion("NET_SIGN_TRANSACTOR <", value, "netSignTransactor");
			return (Criteria) this;
		}

		public Criteria andNetSignTransactorLessThanOrEqualTo(Integer value) {
			addCriterion("NET_SIGN_TRANSACTOR <=", value, "netSignTransactor");
			return (Criteria) this;
		}

		public Criteria andNetSignTransactorIn(List<Integer> values) {
			addCriterion("NET_SIGN_TRANSACTOR in", values, "netSignTransactor");
			return (Criteria) this;
		}

		public Criteria andNetSignTransactorNotIn(List<Integer> values) {
			addCriterion("NET_SIGN_TRANSACTOR not in", values, "netSignTransactor");
			return (Criteria) this;
		}

		public Criteria andNetSignTransactorBetween(Integer value1, Integer value2) {
			addCriterion("NET_SIGN_TRANSACTOR between", value1, value2, "netSignTransactor");
			return (Criteria) this;
		}

		public Criteria andNetSignTransactorNotBetween(Integer value1, Integer value2) {
			addCriterion("NET_SIGN_TRANSACTOR not between", value1, value2, "netSignTransactor");
			return (Criteria) this;
		}

		public Criteria andOwnshipTypeIsNull() {
			addCriterion("OWNSHIP_TYPE is null");
			return (Criteria) this;
		}

		public Criteria andOwnshipTypeIsNotNull() {
			addCriterion("OWNSHIP_TYPE is not null");
			return (Criteria) this;
		}

		public Criteria andOwnshipTypeEqualTo(Byte value) {
			addCriterion("OWNSHIP_TYPE =", value, "ownshipType");
			return (Criteria) this;
		}

		public Criteria andOwnshipTypeNotEqualTo(Byte value) {
			addCriterion("OWNSHIP_TYPE <>", value, "ownshipType");
			return (Criteria) this;
		}

		public Criteria andOwnshipTypeGreaterThan(Byte value) {
			addCriterion("OWNSHIP_TYPE >", value, "ownshipType");
			return (Criteria) this;
		}

		public Criteria andOwnshipTypeGreaterThanOrEqualTo(Byte value) {
			addCriterion("OWNSHIP_TYPE >=", value, "ownshipType");
			return (Criteria) this;
		}

		public Criteria andOwnshipTypeLessThan(Byte value) {
			addCriterion("OWNSHIP_TYPE <", value, "ownshipType");
			return (Criteria) this;
		}

		public Criteria andOwnshipTypeLessThanOrEqualTo(Byte value) {
			addCriterion("OWNSHIP_TYPE <=", value, "ownshipType");
			return (Criteria) this;
		}

		public Criteria andOwnshipTypeIn(List<Byte> values) {
			addCriterion("OWNSHIP_TYPE in", values, "ownshipType");
			return (Criteria) this;
		}

		public Criteria andOwnshipTypeNotIn(List<Byte> values) {
			addCriterion("OWNSHIP_TYPE not in", values, "ownshipType");
			return (Criteria) this;
		}

		public Criteria andOwnshipTypeBetween(Byte value1, Byte value2) {
			addCriterion("OWNSHIP_TYPE between", value1, value2, "ownshipType");
			return (Criteria) this;
		}

		public Criteria andOwnshipTypeNotBetween(Byte value1, Byte value2) {
			addCriterion("OWNSHIP_TYPE not between", value1, value2, "ownshipType");
			return (Criteria) this;
		}

		public Criteria andTransferAttentionMattersIsNull() {
			addCriterion("TRANSFER_ATTENTION_MATTERS is null");
			return (Criteria) this;
		}

		public Criteria andTransferAttentionMattersIsNotNull() {
			addCriterion("TRANSFER_ATTENTION_MATTERS is not null");
			return (Criteria) this;
		}

		public Criteria andTransferAttentionMattersEqualTo(String value) {
			addCriterion("TRANSFER_ATTENTION_MATTERS =", value, "transferAttentionMatters");
			return (Criteria) this;
		}

		public Criteria andTransferAttentionMattersNotEqualTo(String value) {
			addCriterion("TRANSFER_ATTENTION_MATTERS <>", value, "transferAttentionMatters");
			return (Criteria) this;
		}

		public Criteria andTransferAttentionMattersGreaterThan(String value) {
			addCriterion("TRANSFER_ATTENTION_MATTERS >", value, "transferAttentionMatters");
			return (Criteria) this;
		}

		public Criteria andTransferAttentionMattersGreaterThanOrEqualTo(String value) {
			addCriterion("TRANSFER_ATTENTION_MATTERS >=", value, "transferAttentionMatters");
			return (Criteria) this;
		}

		public Criteria andTransferAttentionMattersLessThan(String value) {
			addCriterion("TRANSFER_ATTENTION_MATTERS <", value, "transferAttentionMatters");
			return (Criteria) this;
		}

		public Criteria andTransferAttentionMattersLessThanOrEqualTo(String value) {
			addCriterion("TRANSFER_ATTENTION_MATTERS <=", value, "transferAttentionMatters");
			return (Criteria) this;
		}

		public Criteria andTransferAttentionMattersLike(String value) {
			addCriterion("TRANSFER_ATTENTION_MATTERS like", value, "transferAttentionMatters");
			return (Criteria) this;
		}

		public Criteria andTransferAttentionMattersNotLike(String value) {
			addCriterion("TRANSFER_ATTENTION_MATTERS not like", value, "transferAttentionMatters");
			return (Criteria) this;
		}

		public Criteria andTransferAttentionMattersIn(List<String> values) {
			addCriterion("TRANSFER_ATTENTION_MATTERS in", values, "transferAttentionMatters");
			return (Criteria) this;
		}

		public Criteria andTransferAttentionMattersNotIn(List<String> values) {
			addCriterion("TRANSFER_ATTENTION_MATTERS not in", values, "transferAttentionMatters");
			return (Criteria) this;
		}

		public Criteria andTransferAttentionMattersBetween(String value1, String value2) {
			addCriterion("TRANSFER_ATTENTION_MATTERS between", value1, value2, "transferAttentionMatters");
			return (Criteria) this;
		}

		public Criteria andTransferAttentionMattersNotBetween(String value1, String value2) {
			addCriterion("TRANSFER_ATTENTION_MATTERS not between", value1, value2, "transferAttentionMatters");
			return (Criteria) this;
		}

		public Criteria andPayForAnotherTypeIsNull() {
			addCriterion("PAY_FOR_ANOTHER_TYPE is null");
			return (Criteria) this;
		}

		public Criteria andPayForAnotherTypeIsNotNull() {
			addCriterion("PAY_FOR_ANOTHER_TYPE is not null");
			return (Criteria) this;
		}

		public Criteria andPayForAnotherTypeEqualTo(Byte value) {
			addCriterion("PAY_FOR_ANOTHER_TYPE =", value, "payForAnotherType");
			return (Criteria) this;
		}

		public Criteria andPayForAnotherTypeNotEqualTo(Byte value) {
			addCriterion("PAY_FOR_ANOTHER_TYPE <>", value, "payForAnotherType");
			return (Criteria) this;
		}

		public Criteria andPayForAnotherTypeGreaterThan(Byte value) {
			addCriterion("PAY_FOR_ANOTHER_TYPE >", value, "payForAnotherType");
			return (Criteria) this;
		}

		public Criteria andPayForAnotherTypeGreaterThanOrEqualTo(Byte value) {
			addCriterion("PAY_FOR_ANOTHER_TYPE >=", value, "payForAnotherType");
			return (Criteria) this;
		}

		public Criteria andPayForAnotherTypeLessThan(Byte value) {
			addCriterion("PAY_FOR_ANOTHER_TYPE <", value, "payForAnotherType");
			return (Criteria) this;
		}

		public Criteria andPayForAnotherTypeLessThanOrEqualTo(Byte value) {
			addCriterion("PAY_FOR_ANOTHER_TYPE <=", value, "payForAnotherType");
			return (Criteria) this;
		}

		public Criteria andPayForAnotherTypeIn(List<Byte> values) {
			addCriterion("PAY_FOR_ANOTHER_TYPE in", values, "payForAnotherType");
			return (Criteria) this;
		}

		public Criteria andPayForAnotherTypeNotIn(List<Byte> values) {
			addCriterion("PAY_FOR_ANOTHER_TYPE not in", values, "payForAnotherType");
			return (Criteria) this;
		}

		public Criteria andPayForAnotherTypeBetween(Byte value1, Byte value2) {
			addCriterion("PAY_FOR_ANOTHER_TYPE between", value1, value2, "payForAnotherType");
			return (Criteria) this;
		}

		public Criteria andPayForAnotherTypeNotBetween(Byte value1, Byte value2) {
			addCriterion("PAY_FOR_ANOTHER_TYPE not between", value1, value2, "payForAnotherType");
			return (Criteria) this;
		}

		public Criteria andHavePaidYearsIsNull() {
			addCriterion("HAVE_PAID_YEARS is null");
			return (Criteria) this;
		}

		public Criteria andHavePaidYearsIsNotNull() {
			addCriterion("HAVE_PAID_YEARS is not null");
			return (Criteria) this;
		}

		public Criteria andHavePaidYearsEqualTo(Integer value) {
			addCriterion("HAVE_PAID_YEARS =", value, "havePaidYears");
			return (Criteria) this;
		}

		public Criteria andHavePaidYearsNotEqualTo(Integer value) {
			addCriterion("HAVE_PAID_YEARS <>", value, "havePaidYears");
			return (Criteria) this;
		}

		public Criteria andHavePaidYearsGreaterThan(Integer value) {
			addCriterion("HAVE_PAID_YEARS >", value, "havePaidYears");
			return (Criteria) this;
		}

		public Criteria andHavePaidYearsGreaterThanOrEqualTo(Integer value) {
			addCriterion("HAVE_PAID_YEARS >=", value, "havePaidYears");
			return (Criteria) this;
		}

		public Criteria andHavePaidYearsLessThan(Integer value) {
			addCriterion("HAVE_PAID_YEARS <", value, "havePaidYears");
			return (Criteria) this;
		}

		public Criteria andHavePaidYearsLessThanOrEqualTo(Integer value) {
			addCriterion("HAVE_PAID_YEARS <=", value, "havePaidYears");
			return (Criteria) this;
		}

		public Criteria andHavePaidYearsIn(List<Integer> values) {
			addCriterion("HAVE_PAID_YEARS in", values, "havePaidYears");
			return (Criteria) this;
		}

		public Criteria andHavePaidYearsNotIn(List<Integer> values) {
			addCriterion("HAVE_PAID_YEARS not in", values, "havePaidYears");
			return (Criteria) this;
		}

		public Criteria andHavePaidYearsBetween(Integer value1, Integer value2) {
			addCriterion("HAVE_PAID_YEARS between", value1, value2, "havePaidYears");
			return (Criteria) this;
		}

		public Criteria andHavePaidYearsNotBetween(Integer value1, Integer value2) {
			addCriterion("HAVE_PAID_YEARS not between", value1, value2, "havePaidYears");
			return (Criteria) this;
		}

		public Criteria andPledgeConditionIsNull() {
			addCriterion("PLEDGE_CONDITION is null");
			return (Criteria) this;
		}

		public Criteria andPledgeConditionIsNotNull() {
			addCriterion("PLEDGE_CONDITION is not null");
			return (Criteria) this;
		}

		public Criteria andPledgeConditionEqualTo(Byte value) {
			addCriterion("PLEDGE_CONDITION =", value, "pledgeCondition");
			return (Criteria) this;
		}

		public Criteria andPledgeConditionNotEqualTo(Byte value) {
			addCriterion("PLEDGE_CONDITION <>", value, "pledgeCondition");
			return (Criteria) this;
		}

		public Criteria andPledgeConditionGreaterThan(Byte value) {
			addCriterion("PLEDGE_CONDITION >", value, "pledgeCondition");
			return (Criteria) this;
		}

		public Criteria andPledgeConditionGreaterThanOrEqualTo(Byte value) {
			addCriterion("PLEDGE_CONDITION >=", value, "pledgeCondition");
			return (Criteria) this;
		}

		public Criteria andPledgeConditionLessThan(Byte value) {
			addCriterion("PLEDGE_CONDITION <", value, "pledgeCondition");
			return (Criteria) this;
		}

		public Criteria andPledgeConditionLessThanOrEqualTo(Byte value) {
			addCriterion("PLEDGE_CONDITION <=", value, "pledgeCondition");
			return (Criteria) this;
		}

		public Criteria andPledgeConditionIn(List<Byte> values) {
			addCriterion("PLEDGE_CONDITION in", values, "pledgeCondition");
			return (Criteria) this;
		}

		public Criteria andPledgeConditionNotIn(List<Byte> values) {
			addCriterion("PLEDGE_CONDITION not in", values, "pledgeCondition");
			return (Criteria) this;
		}

		public Criteria andPledgeConditionBetween(Byte value1, Byte value2) {
			addCriterion("PLEDGE_CONDITION between", value1, value2, "pledgeCondition");
			return (Criteria) this;
		}

		public Criteria andPledgeConditionNotBetween(Byte value1, Byte value2) {
			addCriterion("PLEDGE_CONDITION not between", value1, value2, "pledgeCondition");
			return (Criteria) this;
		}

		public Criteria andFirstPayOrganizationIsNull() {
			addCriterion("FIRST_PAY_ORGANIZATION is null");
			return (Criteria) this;
		}

		public Criteria andFirstPayOrganizationIsNotNull() {
			addCriterion("FIRST_PAY_ORGANIZATION is not null");
			return (Criteria) this;
		}

		public Criteria andFirstPayOrganizationEqualTo(String value) {
			addCriterion("FIRST_PAY_ORGANIZATION =", value, "firstPayOrganization");
			return (Criteria) this;
		}

		public Criteria andFirstPayOrganizationNotEqualTo(String value) {
			addCriterion("FIRST_PAY_ORGANIZATION <>", value, "firstPayOrganization");
			return (Criteria) this;
		}

		public Criteria andFirstPayOrganizationGreaterThan(String value) {
			addCriterion("FIRST_PAY_ORGANIZATION >", value, "firstPayOrganization");
			return (Criteria) this;
		}

		public Criteria andFirstPayOrganizationGreaterThanOrEqualTo(String value) {
			addCriterion("FIRST_PAY_ORGANIZATION >=", value, "firstPayOrganization");
			return (Criteria) this;
		}

		public Criteria andFirstPayOrganizationLessThan(String value) {
			addCriterion("FIRST_PAY_ORGANIZATION <", value, "firstPayOrganization");
			return (Criteria) this;
		}

		public Criteria andFirstPayOrganizationLessThanOrEqualTo(String value) {
			addCriterion("FIRST_PAY_ORGANIZATION <=", value, "firstPayOrganization");
			return (Criteria) this;
		}

		public Criteria andFirstPayOrganizationLike(String value) {
			addCriterion("FIRST_PAY_ORGANIZATION like", value, "firstPayOrganization");
			return (Criteria) this;
		}

		public Criteria andFirstPayOrganizationNotLike(String value) {
			addCriterion("FIRST_PAY_ORGANIZATION not like", value, "firstPayOrganization");
			return (Criteria) this;
		}

		public Criteria andFirstPayOrganizationIn(List<String> values) {
			addCriterion("FIRST_PAY_ORGANIZATION in", values, "firstPayOrganization");
			return (Criteria) this;
		}

		public Criteria andFirstPayOrganizationNotIn(List<String> values) {
			addCriterion("FIRST_PAY_ORGANIZATION not in", values, "firstPayOrganization");
			return (Criteria) this;
		}

		public Criteria andFirstPayOrganizationBetween(String value1, String value2) {
			addCriterion("FIRST_PAY_ORGANIZATION between", value1, value2, "firstPayOrganization");
			return (Criteria) this;
		}

		public Criteria andFirstPayOrganizationNotBetween(String value1, String value2) {
			addCriterion("FIRST_PAY_ORGANIZATION not between", value1, value2, "firstPayOrganization");
			return (Criteria) this;
		}

		public Criteria andFirstAnotherPayPriceIsNull() {
			addCriterion("FIRST_ANOTHER_PAY_PRICE is null");
			return (Criteria) this;
		}

		public Criteria andFirstAnotherPayPriceIsNotNull() {
			addCriterion("FIRST_ANOTHER_PAY_PRICE is not null");
			return (Criteria) this;
		}

		public Criteria andFirstAnotherPayPriceEqualTo(BigDecimal value) {
			addCriterion("FIRST_ANOTHER_PAY_PRICE =", value, "firstAnotherPayPrice");
			return (Criteria) this;
		}

		public Criteria andFirstAnotherPayPriceNotEqualTo(BigDecimal value) {
			addCriterion("FIRST_ANOTHER_PAY_PRICE <>", value, "firstAnotherPayPrice");
			return (Criteria) this;
		}

		public Criteria andFirstAnotherPayPriceGreaterThan(BigDecimal value) {
			addCriterion("FIRST_ANOTHER_PAY_PRICE >", value, "firstAnotherPayPrice");
			return (Criteria) this;
		}

		public Criteria andFirstAnotherPayPriceGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("FIRST_ANOTHER_PAY_PRICE >=", value, "firstAnotherPayPrice");
			return (Criteria) this;
		}

		public Criteria andFirstAnotherPayPriceLessThan(BigDecimal value) {
			addCriterion("FIRST_ANOTHER_PAY_PRICE <", value, "firstAnotherPayPrice");
			return (Criteria) this;
		}

		public Criteria andFirstAnotherPayPriceLessThanOrEqualTo(BigDecimal value) {
			addCriterion("FIRST_ANOTHER_PAY_PRICE <=", value, "firstAnotherPayPrice");
			return (Criteria) this;
		}

		public Criteria andFirstAnotherPayPriceIn(List<BigDecimal> values) {
			addCriterion("FIRST_ANOTHER_PAY_PRICE in", values, "firstAnotherPayPrice");
			return (Criteria) this;
		}

		public Criteria andFirstAnotherPayPriceNotIn(List<BigDecimal> values) {
			addCriterion("FIRST_ANOTHER_PAY_PRICE not in", values, "firstAnotherPayPrice");
			return (Criteria) this;
		}

		public Criteria andFirstAnotherPayPriceBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("FIRST_ANOTHER_PAY_PRICE between", value1, value2, "firstAnotherPayPrice");
			return (Criteria) this;
		}

		public Criteria andFirstAnotherPayPriceNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("FIRST_ANOTHER_PAY_PRICE not between", value1, value2, "firstAnotherPayPrice");
			return (Criteria) this;
		}

		public Criteria andFirstTransactionTimePredictIsNull() {
			addCriterion("FIRST_TRANSACTION_TIME_PREDICT is null");
			return (Criteria) this;
		}

		public Criteria andFirstTransactionTimePredictIsNotNull() {
			addCriterion("FIRST_TRANSACTION_TIME_PREDICT is not null");
			return (Criteria) this;
		}

		public Criteria andFirstTransactionTimePredictEqualTo(Date value) {
			addCriterion("FIRST_TRANSACTION_TIME_PREDICT =", value, "firstTransactionTimePredict");
			return (Criteria) this;
		}

		public Criteria andFirstTransactionTimePredictNotEqualTo(Date value) {
			addCriterion("FIRST_TRANSACTION_TIME_PREDICT <>", value, "firstTransactionTimePredict");
			return (Criteria) this;
		}

		public Criteria andFirstTransactionTimePredictGreaterThan(Date value) {
			addCriterion("FIRST_TRANSACTION_TIME_PREDICT >", value, "firstTransactionTimePredict");
			return (Criteria) this;
		}

		public Criteria andFirstTransactionTimePredictGreaterThanOrEqualTo(Date value) {
			addCriterion("FIRST_TRANSACTION_TIME_PREDICT >=", value, "firstTransactionTimePredict");
			return (Criteria) this;
		}

		public Criteria andFirstTransactionTimePredictLessThan(Date value) {
			addCriterion("FIRST_TRANSACTION_TIME_PREDICT <", value, "firstTransactionTimePredict");
			return (Criteria) this;
		}

		public Criteria andFirstTransactionTimePredictLessThanOrEqualTo(Date value) {
			addCriterion("FIRST_TRANSACTION_TIME_PREDICT <=", value, "firstTransactionTimePredict");
			return (Criteria) this;
		}

		public Criteria andFirstTransactionTimePredictIn(List<Date> values) {
			addCriterion("FIRST_TRANSACTION_TIME_PREDICT in", values, "firstTransactionTimePredict");
			return (Criteria) this;
		}

		public Criteria andFirstTransactionTimePredictNotIn(List<Date> values) {
			addCriterion("FIRST_TRANSACTION_TIME_PREDICT not in", values, "firstTransactionTimePredict");
			return (Criteria) this;
		}

		public Criteria andFirstTransactionTimePredictBetween(Date value1, Date value2) {
			addCriterion("FIRST_TRANSACTION_TIME_PREDICT between", value1, value2, "firstTransactionTimePredict");
			return (Criteria) this;
		}

		public Criteria andFirstTransactionTimePredictNotBetween(Date value1, Date value2) {
			addCriterion("FIRST_TRANSACTION_TIME_PREDICT not between", value1, value2, "firstTransactionTimePredict");
			return (Criteria) this;
		}

		public Criteria andFirstTransactionTimeRealIsNull() {
			addCriterion("FIRST_TRANSACTION_TIME_REAL is null");
			return (Criteria) this;
		}

		public Criteria andFirstTransactionTimeRealIsNotNull() {
			addCriterion("FIRST_TRANSACTION_TIME_REAL is not null");
			return (Criteria) this;
		}

		public Criteria andFirstTransactionTimeRealEqualTo(Date value) {
			addCriterion("FIRST_TRANSACTION_TIME_REAL =", value, "firstTransactionTimeReal");
			return (Criteria) this;
		}

		public Criteria andFirstTransactionTimeRealNotEqualTo(Date value) {
			addCriterion("FIRST_TRANSACTION_TIME_REAL <>", value, "firstTransactionTimeReal");
			return (Criteria) this;
		}

		public Criteria andFirstTransactionTimeRealGreaterThan(Date value) {
			addCriterion("FIRST_TRANSACTION_TIME_REAL >", value, "firstTransactionTimeReal");
			return (Criteria) this;
		}

		public Criteria andFirstTransactionTimeRealGreaterThanOrEqualTo(Date value) {
			addCriterion("FIRST_TRANSACTION_TIME_REAL >=", value, "firstTransactionTimeReal");
			return (Criteria) this;
		}

		public Criteria andFirstTransactionTimeRealLessThan(Date value) {
			addCriterion("FIRST_TRANSACTION_TIME_REAL <", value, "firstTransactionTimeReal");
			return (Criteria) this;
		}

		public Criteria andFirstTransactionTimeRealLessThanOrEqualTo(Date value) {
			addCriterion("FIRST_TRANSACTION_TIME_REAL <=", value, "firstTransactionTimeReal");
			return (Criteria) this;
		}

		public Criteria andFirstTransactionTimeRealIn(List<Date> values) {
			addCriterion("FIRST_TRANSACTION_TIME_REAL in", values, "firstTransactionTimeReal");
			return (Criteria) this;
		}

		public Criteria andFirstTransactionTimeRealNotIn(List<Date> values) {
			addCriterion("FIRST_TRANSACTION_TIME_REAL not in", values, "firstTransactionTimeReal");
			return (Criteria) this;
		}

		public Criteria andFirstTransactionTimeRealBetween(Date value1, Date value2) {
			addCriterion("FIRST_TRANSACTION_TIME_REAL between", value1, value2, "firstTransactionTimeReal");
			return (Criteria) this;
		}

		public Criteria andFirstTransactionTimeRealNotBetween(Date value1, Date value2) {
			addCriterion("FIRST_TRANSACTION_TIME_REAL not between", value1, value2, "firstTransactionTimeReal");
			return (Criteria) this;
		}

		public Criteria andFirstPayTimePredictIsNull() {
			addCriterion("FIRST_PAY_TIME_PREDICT is null");
			return (Criteria) this;
		}

		public Criteria andFirstPayTimePredictIsNotNull() {
			addCriterion("FIRST_PAY_TIME_PREDICT is not null");
			return (Criteria) this;
		}

		public Criteria andFirstPayTimePredictEqualTo(Date value) {
			addCriterion("FIRST_PAY_TIME_PREDICT =", value, "firstPayTimePredict");
			return (Criteria) this;
		}

		public Criteria andFirstPayTimePredictNotEqualTo(Date value) {
			addCriterion("FIRST_PAY_TIME_PREDICT <>", value, "firstPayTimePredict");
			return (Criteria) this;
		}

		public Criteria andFirstPayTimePredictGreaterThan(Date value) {
			addCriterion("FIRST_PAY_TIME_PREDICT >", value, "firstPayTimePredict");
			return (Criteria) this;
		}

		public Criteria andFirstPayTimePredictGreaterThanOrEqualTo(Date value) {
			addCriterion("FIRST_PAY_TIME_PREDICT >=", value, "firstPayTimePredict");
			return (Criteria) this;
		}

		public Criteria andFirstPayTimePredictLessThan(Date value) {
			addCriterion("FIRST_PAY_TIME_PREDICT <", value, "firstPayTimePredict");
			return (Criteria) this;
		}

		public Criteria andFirstPayTimePredictLessThanOrEqualTo(Date value) {
			addCriterion("FIRST_PAY_TIME_PREDICT <=", value, "firstPayTimePredict");
			return (Criteria) this;
		}

		public Criteria andFirstPayTimePredictIn(List<Date> values) {
			addCriterion("FIRST_PAY_TIME_PREDICT in", values, "firstPayTimePredict");
			return (Criteria) this;
		}

		public Criteria andFirstPayTimePredictNotIn(List<Date> values) {
			addCriterion("FIRST_PAY_TIME_PREDICT not in", values, "firstPayTimePredict");
			return (Criteria) this;
		}

		public Criteria andFirstPayTimePredictBetween(Date value1, Date value2) {
			addCriterion("FIRST_PAY_TIME_PREDICT between", value1, value2, "firstPayTimePredict");
			return (Criteria) this;
		}

		public Criteria andFirstPayTimePredictNotBetween(Date value1, Date value2) {
			addCriterion("FIRST_PAY_TIME_PREDICT not between", value1, value2, "firstPayTimePredict");
			return (Criteria) this;
		}

		public Criteria andFirstPayTimeRealIsNull() {
			addCriterion("FIRST_PAY_TIME_REAL is null");
			return (Criteria) this;
		}

		public Criteria andFirstPayTimeRealIsNotNull() {
			addCriterion("FIRST_PAY_TIME_REAL is not null");
			return (Criteria) this;
		}

		public Criteria andFirstPayTimeRealEqualTo(Date value) {
			addCriterion("FIRST_PAY_TIME_REAL =", value, "firstPayTimeReal");
			return (Criteria) this;
		}

		public Criteria andFirstPayTimeRealNotEqualTo(Date value) {
			addCriterion("FIRST_PAY_TIME_REAL <>", value, "firstPayTimeReal");
			return (Criteria) this;
		}

		public Criteria andFirstPayTimeRealGreaterThan(Date value) {
			addCriterion("FIRST_PAY_TIME_REAL >", value, "firstPayTimeReal");
			return (Criteria) this;
		}

		public Criteria andFirstPayTimeRealGreaterThanOrEqualTo(Date value) {
			addCriterion("FIRST_PAY_TIME_REAL >=", value, "firstPayTimeReal");
			return (Criteria) this;
		}

		public Criteria andFirstPayTimeRealLessThan(Date value) {
			addCriterion("FIRST_PAY_TIME_REAL <", value, "firstPayTimeReal");
			return (Criteria) this;
		}

		public Criteria andFirstPayTimeRealLessThanOrEqualTo(Date value) {
			addCriterion("FIRST_PAY_TIME_REAL <=", value, "firstPayTimeReal");
			return (Criteria) this;
		}

		public Criteria andFirstPayTimeRealIn(List<Date> values) {
			addCriterion("FIRST_PAY_TIME_REAL in", values, "firstPayTimeReal");
			return (Criteria) this;
		}

		public Criteria andFirstPayTimeRealNotIn(List<Date> values) {
			addCriterion("FIRST_PAY_TIME_REAL not in", values, "firstPayTimeReal");
			return (Criteria) this;
		}

		public Criteria andFirstPayTimeRealBetween(Date value1, Date value2) {
			addCriterion("FIRST_PAY_TIME_REAL between", value1, value2, "firstPayTimeReal");
			return (Criteria) this;
		}

		public Criteria andFirstPayTimeRealNotBetween(Date value1, Date value2) {
			addCriterion("FIRST_PAY_TIME_REAL not between", value1, value2, "firstPayTimeReal");
			return (Criteria) this;
		}

		public Criteria andSecondPayOrganizationIsNull() {
			addCriterion("SECOND_PAY_ORGANIZATION is null");
			return (Criteria) this;
		}

		public Criteria andSecondPayOrganizationIsNotNull() {
			addCriterion("SECOND_PAY_ORGANIZATION is not null");
			return (Criteria) this;
		}

		public Criteria andSecondPayOrganizationEqualTo(String value) {
			addCriterion("SECOND_PAY_ORGANIZATION =", value, "secondPayOrganization");
			return (Criteria) this;
		}

		public Criteria andSecondPayOrganizationNotEqualTo(String value) {
			addCriterion("SECOND_PAY_ORGANIZATION <>", value, "secondPayOrganization");
			return (Criteria) this;
		}

		public Criteria andSecondPayOrganizationGreaterThan(String value) {
			addCriterion("SECOND_PAY_ORGANIZATION >", value, "secondPayOrganization");
			return (Criteria) this;
		}

		public Criteria andSecondPayOrganizationGreaterThanOrEqualTo(String value) {
			addCriterion("SECOND_PAY_ORGANIZATION >=", value, "secondPayOrganization");
			return (Criteria) this;
		}

		public Criteria andSecondPayOrganizationLessThan(String value) {
			addCriterion("SECOND_PAY_ORGANIZATION <", value, "secondPayOrganization");
			return (Criteria) this;
		}

		public Criteria andSecondPayOrganizationLessThanOrEqualTo(String value) {
			addCriterion("SECOND_PAY_ORGANIZATION <=", value, "secondPayOrganization");
			return (Criteria) this;
		}

		public Criteria andSecondPayOrganizationLike(String value) {
			addCriterion("SECOND_PAY_ORGANIZATION like", value, "secondPayOrganization");
			return (Criteria) this;
		}

		public Criteria andSecondPayOrganizationNotLike(String value) {
			addCriterion("SECOND_PAY_ORGANIZATION not like", value, "secondPayOrganization");
			return (Criteria) this;
		}

		public Criteria andSecondPayOrganizationIn(List<String> values) {
			addCriterion("SECOND_PAY_ORGANIZATION in", values, "secondPayOrganization");
			return (Criteria) this;
		}

		public Criteria andSecondPayOrganizationNotIn(List<String> values) {
			addCriterion("SECOND_PAY_ORGANIZATION not in", values, "secondPayOrganization");
			return (Criteria) this;
		}

		public Criteria andSecondPayOrganizationBetween(String value1, String value2) {
			addCriterion("SECOND_PAY_ORGANIZATION between", value1, value2, "secondPayOrganization");
			return (Criteria) this;
		}

		public Criteria andSecondPayOrganizationNotBetween(String value1, String value2) {
			addCriterion("SECOND_PAY_ORGANIZATION not between", value1, value2, "secondPayOrganization");
			return (Criteria) this;
		}

		public Criteria andSecondAnotherPayPriceIsNull() {
			addCriterion("SECOND_ANOTHER_PAY_PRICE is null");
			return (Criteria) this;
		}

		public Criteria andSecondAnotherPayPriceIsNotNull() {
			addCriterion("SECOND_ANOTHER_PAY_PRICE is not null");
			return (Criteria) this;
		}

		public Criteria andSecondAnotherPayPriceEqualTo(BigDecimal value) {
			addCriterion("SECOND_ANOTHER_PAY_PRICE =", value, "secondAnotherPayPrice");
			return (Criteria) this;
		}

		public Criteria andSecondAnotherPayPriceNotEqualTo(BigDecimal value) {
			addCriterion("SECOND_ANOTHER_PAY_PRICE <>", value, "secondAnotherPayPrice");
			return (Criteria) this;
		}

		public Criteria andSecondAnotherPayPriceGreaterThan(BigDecimal value) {
			addCriterion("SECOND_ANOTHER_PAY_PRICE >", value, "secondAnotherPayPrice");
			return (Criteria) this;
		}

		public Criteria andSecondAnotherPayPriceGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("SECOND_ANOTHER_PAY_PRICE >=", value, "secondAnotherPayPrice");
			return (Criteria) this;
		}

		public Criteria andSecondAnotherPayPriceLessThan(BigDecimal value) {
			addCriterion("SECOND_ANOTHER_PAY_PRICE <", value, "secondAnotherPayPrice");
			return (Criteria) this;
		}

		public Criteria andSecondAnotherPayPriceLessThanOrEqualTo(BigDecimal value) {
			addCriterion("SECOND_ANOTHER_PAY_PRICE <=", value, "secondAnotherPayPrice");
			return (Criteria) this;
		}

		public Criteria andSecondAnotherPayPriceIn(List<BigDecimal> values) {
			addCriterion("SECOND_ANOTHER_PAY_PRICE in", values, "secondAnotherPayPrice");
			return (Criteria) this;
		}

		public Criteria andSecondAnotherPayPriceNotIn(List<BigDecimal> values) {
			addCriterion("SECOND_ANOTHER_PAY_PRICE not in", values, "secondAnotherPayPrice");
			return (Criteria) this;
		}

		public Criteria andSecondAnotherPayPriceBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("SECOND_ANOTHER_PAY_PRICE between", value1, value2, "secondAnotherPayPrice");
			return (Criteria) this;
		}

		public Criteria andSecondAnotherPayPriceNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("SECOND_ANOTHER_PAY_PRICE not between", value1, value2, "secondAnotherPayPrice");
			return (Criteria) this;
		}

		public Criteria andSecondTransactionTimePredictIsNull() {
			addCriterion("SECOND_TRANSACTION_TIME_PREDICT is null");
			return (Criteria) this;
		}

		public Criteria andSecondTransactionTimePredictIsNotNull() {
			addCriterion("SECOND_TRANSACTION_TIME_PREDICT is not null");
			return (Criteria) this;
		}

		public Criteria andSecondTransactionTimePredictEqualTo(Date value) {
			addCriterion("SECOND_TRANSACTION_TIME_PREDICT =", value, "secondTransactionTimePredict");
			return (Criteria) this;
		}

		public Criteria andSecondTransactionTimePredictNotEqualTo(Date value) {
			addCriterion("SECOND_TRANSACTION_TIME_PREDICT <>", value, "secondTransactionTimePredict");
			return (Criteria) this;
		}

		public Criteria andSecondTransactionTimePredictGreaterThan(Date value) {
			addCriterion("SECOND_TRANSACTION_TIME_PREDICT >", value, "secondTransactionTimePredict");
			return (Criteria) this;
		}

		public Criteria andSecondTransactionTimePredictGreaterThanOrEqualTo(Date value) {
			addCriterion("SECOND_TRANSACTION_TIME_PREDICT >=", value, "secondTransactionTimePredict");
			return (Criteria) this;
		}

		public Criteria andSecondTransactionTimePredictLessThan(Date value) {
			addCriterion("SECOND_TRANSACTION_TIME_PREDICT <", value, "secondTransactionTimePredict");
			return (Criteria) this;
		}

		public Criteria andSecondTransactionTimePredictLessThanOrEqualTo(Date value) {
			addCriterion("SECOND_TRANSACTION_TIME_PREDICT <=", value, "secondTransactionTimePredict");
			return (Criteria) this;
		}

		public Criteria andSecondTransactionTimePredictIn(List<Date> values) {
			addCriterion("SECOND_TRANSACTION_TIME_PREDICT in", values, "secondTransactionTimePredict");
			return (Criteria) this;
		}

		public Criteria andSecondTransactionTimePredictNotIn(List<Date> values) {
			addCriterion("SECOND_TRANSACTION_TIME_PREDICT not in", values, "secondTransactionTimePredict");
			return (Criteria) this;
		}

		public Criteria andSecondTransactionTimePredictBetween(Date value1, Date value2) {
			addCriterion("SECOND_TRANSACTION_TIME_PREDICT between", value1, value2, "secondTransactionTimePredict");
			return (Criteria) this;
		}

		public Criteria andSecondTransactionTimePredictNotBetween(Date value1, Date value2) {
			addCriterion("SECOND_TRANSACTION_TIME_PREDICT not between", value1, value2, "secondTransactionTimePredict");
			return (Criteria) this;
		}

		public Criteria andSecondTransactionTimeRealIsNull() {
			addCriterion("SECOND_TRANSACTION_TIME_REAL is null");
			return (Criteria) this;
		}

		public Criteria andSecondTransactionTimeRealIsNotNull() {
			addCriterion("SECOND_TRANSACTION_TIME_REAL is not null");
			return (Criteria) this;
		}

		public Criteria andSecondTransactionTimeRealEqualTo(Date value) {
			addCriterion("SECOND_TRANSACTION_TIME_REAL =", value, "secondTransactionTimeReal");
			return (Criteria) this;
		}

		public Criteria andSecondTransactionTimeRealNotEqualTo(Date value) {
			addCriterion("SECOND_TRANSACTION_TIME_REAL <>", value, "secondTransactionTimeReal");
			return (Criteria) this;
		}

		public Criteria andSecondTransactionTimeRealGreaterThan(Date value) {
			addCriterion("SECOND_TRANSACTION_TIME_REAL >", value, "secondTransactionTimeReal");
			return (Criteria) this;
		}

		public Criteria andSecondTransactionTimeRealGreaterThanOrEqualTo(Date value) {
			addCriterion("SECOND_TRANSACTION_TIME_REAL >=", value, "secondTransactionTimeReal");
			return (Criteria) this;
		}

		public Criteria andSecondTransactionTimeRealLessThan(Date value) {
			addCriterion("SECOND_TRANSACTION_TIME_REAL <", value, "secondTransactionTimeReal");
			return (Criteria) this;
		}

		public Criteria andSecondTransactionTimeRealLessThanOrEqualTo(Date value) {
			addCriterion("SECOND_TRANSACTION_TIME_REAL <=", value, "secondTransactionTimeReal");
			return (Criteria) this;
		}

		public Criteria andSecondTransactionTimeRealIn(List<Date> values) {
			addCriterion("SECOND_TRANSACTION_TIME_REAL in", values, "secondTransactionTimeReal");
			return (Criteria) this;
		}

		public Criteria andSecondTransactionTimeRealNotIn(List<Date> values) {
			addCriterion("SECOND_TRANSACTION_TIME_REAL not in", values, "secondTransactionTimeReal");
			return (Criteria) this;
		}

		public Criteria andSecondTransactionTimeRealBetween(Date value1, Date value2) {
			addCriterion("SECOND_TRANSACTION_TIME_REAL between", value1, value2, "secondTransactionTimeReal");
			return (Criteria) this;
		}

		public Criteria andSecondTransactionTimeRealNotBetween(Date value1, Date value2) {
			addCriterion("SECOND_TRANSACTION_TIME_REAL not between", value1, value2, "secondTransactionTimeReal");
			return (Criteria) this;
		}

		public Criteria andSecondPayTimePredictIsNull() {
			addCriterion("SECOND_PAY_TIME_PREDICT is null");
			return (Criteria) this;
		}

		public Criteria andSecondPayTimePredictIsNotNull() {
			addCriterion("SECOND_PAY_TIME_PREDICT is not null");
			return (Criteria) this;
		}

		public Criteria andSecondPayTimePredictEqualTo(Date value) {
			addCriterion("SECOND_PAY_TIME_PREDICT =", value, "secondPayTimePredict");
			return (Criteria) this;
		}

		public Criteria andSecondPayTimePredictNotEqualTo(Date value) {
			addCriterion("SECOND_PAY_TIME_PREDICT <>", value, "secondPayTimePredict");
			return (Criteria) this;
		}

		public Criteria andSecondPayTimePredictGreaterThan(Date value) {
			addCriterion("SECOND_PAY_TIME_PREDICT >", value, "secondPayTimePredict");
			return (Criteria) this;
		}

		public Criteria andSecondPayTimePredictGreaterThanOrEqualTo(Date value) {
			addCriterion("SECOND_PAY_TIME_PREDICT >=", value, "secondPayTimePredict");
			return (Criteria) this;
		}

		public Criteria andSecondPayTimePredictLessThan(Date value) {
			addCriterion("SECOND_PAY_TIME_PREDICT <", value, "secondPayTimePredict");
			return (Criteria) this;
		}

		public Criteria andSecondPayTimePredictLessThanOrEqualTo(Date value) {
			addCriterion("SECOND_PAY_TIME_PREDICT <=", value, "secondPayTimePredict");
			return (Criteria) this;
		}

		public Criteria andSecondPayTimePredictIn(List<Date> values) {
			addCriterion("SECOND_PAY_TIME_PREDICT in", values, "secondPayTimePredict");
			return (Criteria) this;
		}

		public Criteria andSecondPayTimePredictNotIn(List<Date> values) {
			addCriterion("SECOND_PAY_TIME_PREDICT not in", values, "secondPayTimePredict");
			return (Criteria) this;
		}

		public Criteria andSecondPayTimePredictBetween(Date value1, Date value2) {
			addCriterion("SECOND_PAY_TIME_PREDICT between", value1, value2, "secondPayTimePredict");
			return (Criteria) this;
		}

		public Criteria andSecondPayTimePredictNotBetween(Date value1, Date value2) {
			addCriterion("SECOND_PAY_TIME_PREDICT not between", value1, value2, "secondPayTimePredict");
			return (Criteria) this;
		}

		public Criteria andSecondPayTimeRealIsNull() {
			addCriterion("SECOND_PAY_TIME_REAL is null");
			return (Criteria) this;
		}

		public Criteria andSecondPayTimeRealIsNotNull() {
			addCriterion("SECOND_PAY_TIME_REAL is not null");
			return (Criteria) this;
		}

		public Criteria andSecondPayTimeRealEqualTo(Date value) {
			addCriterion("SECOND_PAY_TIME_REAL =", value, "secondPayTimeReal");
			return (Criteria) this;
		}

		public Criteria andSecondPayTimeRealNotEqualTo(Date value) {
			addCriterion("SECOND_PAY_TIME_REAL <>", value, "secondPayTimeReal");
			return (Criteria) this;
		}

		public Criteria andSecondPayTimeRealGreaterThan(Date value) {
			addCriterion("SECOND_PAY_TIME_REAL >", value, "secondPayTimeReal");
			return (Criteria) this;
		}

		public Criteria andSecondPayTimeRealGreaterThanOrEqualTo(Date value) {
			addCriterion("SECOND_PAY_TIME_REAL >=", value, "secondPayTimeReal");
			return (Criteria) this;
		}

		public Criteria andSecondPayTimeRealLessThan(Date value) {
			addCriterion("SECOND_PAY_TIME_REAL <", value, "secondPayTimeReal");
			return (Criteria) this;
		}

		public Criteria andSecondPayTimeRealLessThanOrEqualTo(Date value) {
			addCriterion("SECOND_PAY_TIME_REAL <=", value, "secondPayTimeReal");
			return (Criteria) this;
		}

		public Criteria andSecondPayTimeRealIn(List<Date> values) {
			addCriterion("SECOND_PAY_TIME_REAL in", values, "secondPayTimeReal");
			return (Criteria) this;
		}

		public Criteria andSecondPayTimeRealNotIn(List<Date> values) {
			addCriterion("SECOND_PAY_TIME_REAL not in", values, "secondPayTimeReal");
			return (Criteria) this;
		}

		public Criteria andSecondPayTimeRealBetween(Date value1, Date value2) {
			addCriterion("SECOND_PAY_TIME_REAL between", value1, value2, "secondPayTimeReal");
			return (Criteria) this;
		}

		public Criteria andSecondPayTimeRealNotBetween(Date value1, Date value2) {
			addCriterion("SECOND_PAY_TIME_REAL not between", value1, value2, "secondPayTimeReal");
			return (Criteria) this;
		}

		public Criteria andSequencePositonTimePredictIsNull() {
			addCriterion("SEQUENCE_POSITON_TIME_PREDICT is null");
			return (Criteria) this;
		}

		public Criteria andSequencePositonTimePredictIsNotNull() {
			addCriterion("SEQUENCE_POSITON_TIME_PREDICT is not null");
			return (Criteria) this;
		}

		public Criteria andSequencePositonTimePredictEqualTo(Date value) {
			addCriterion("SEQUENCE_POSITON_TIME_PREDICT =", value, "sequencePositonTimePredict");
			return (Criteria) this;
		}

		public Criteria andSequencePositonTimePredictNotEqualTo(Date value) {
			addCriterion("SEQUENCE_POSITON_TIME_PREDICT <>", value, "sequencePositonTimePredict");
			return (Criteria) this;
		}

		public Criteria andSequencePositonTimePredictGreaterThan(Date value) {
			addCriterion("SEQUENCE_POSITON_TIME_PREDICT >", value, "sequencePositonTimePredict");
			return (Criteria) this;
		}

		public Criteria andSequencePositonTimePredictGreaterThanOrEqualTo(Date value) {
			addCriterion("SEQUENCE_POSITON_TIME_PREDICT >=", value, "sequencePositonTimePredict");
			return (Criteria) this;
		}

		public Criteria andSequencePositonTimePredictLessThan(Date value) {
			addCriterion("SEQUENCE_POSITON_TIME_PREDICT <", value, "sequencePositonTimePredict");
			return (Criteria) this;
		}

		public Criteria andSequencePositonTimePredictLessThanOrEqualTo(Date value) {
			addCriterion("SEQUENCE_POSITON_TIME_PREDICT <=", value, "sequencePositonTimePredict");
			return (Criteria) this;
		}

		public Criteria andSequencePositonTimePredictIn(List<Date> values) {
			addCriterion("SEQUENCE_POSITON_TIME_PREDICT in", values, "sequencePositonTimePredict");
			return (Criteria) this;
		}

		public Criteria andSequencePositonTimePredictNotIn(List<Date> values) {
			addCriterion("SEQUENCE_POSITON_TIME_PREDICT not in", values, "sequencePositonTimePredict");
			return (Criteria) this;
		}

		public Criteria andSequencePositonTimePredictBetween(Date value1, Date value2) {
			addCriterion("SEQUENCE_POSITON_TIME_PREDICT between", value1, value2, "sequencePositonTimePredict");
			return (Criteria) this;
		}

		public Criteria andSequencePositonTimePredictNotBetween(Date value1, Date value2) {
			addCriterion("SEQUENCE_POSITON_TIME_PREDICT not between", value1, value2, "sequencePositonTimePredict");
			return (Criteria) this;
		}

		public Criteria andSequencePositonTimeRealIsNull() {
			addCriterion("SEQUENCE_POSITON_TIME_REAL is null");
			return (Criteria) this;
		}

		public Criteria andSequencePositonTimeRealIsNotNull() {
			addCriterion("SEQUENCE_POSITON_TIME_REAL is not null");
			return (Criteria) this;
		}

		public Criteria andSequencePositonTimeRealEqualTo(Date value) {
			addCriterion("SEQUENCE_POSITON_TIME_REAL =", value, "sequencePositonTimeReal");
			return (Criteria) this;
		}

		public Criteria andSequencePositonTimeRealNotEqualTo(Date value) {
			addCriterion("SEQUENCE_POSITON_TIME_REAL <>", value, "sequencePositonTimeReal");
			return (Criteria) this;
		}

		public Criteria andSequencePositonTimeRealGreaterThan(Date value) {
			addCriterion("SEQUENCE_POSITON_TIME_REAL >", value, "sequencePositonTimeReal");
			return (Criteria) this;
		}

		public Criteria andSequencePositonTimeRealGreaterThanOrEqualTo(Date value) {
			addCriterion("SEQUENCE_POSITON_TIME_REAL >=", value, "sequencePositonTimeReal");
			return (Criteria) this;
		}

		public Criteria andSequencePositonTimeRealLessThan(Date value) {
			addCriterion("SEQUENCE_POSITON_TIME_REAL <", value, "sequencePositonTimeReal");
			return (Criteria) this;
		}

		public Criteria andSequencePositonTimeRealLessThanOrEqualTo(Date value) {
			addCriterion("SEQUENCE_POSITON_TIME_REAL <=", value, "sequencePositonTimeReal");
			return (Criteria) this;
		}

		public Criteria andSequencePositonTimeRealIn(List<Date> values) {
			addCriterion("SEQUENCE_POSITON_TIME_REAL in", values, "sequencePositonTimeReal");
			return (Criteria) this;
		}

		public Criteria andSequencePositonTimeRealNotIn(List<Date> values) {
			addCriterion("SEQUENCE_POSITON_TIME_REAL not in", values, "sequencePositonTimeReal");
			return (Criteria) this;
		}

		public Criteria andSequencePositonTimeRealBetween(Date value1, Date value2) {
			addCriterion("SEQUENCE_POSITON_TIME_REAL between", value1, value2, "sequencePositonTimeReal");
			return (Criteria) this;
		}

		public Criteria andSequencePositonTimeRealNotBetween(Date value1, Date value2) {
			addCriterion("SEQUENCE_POSITON_TIME_REAL not between", value1, value2, "sequencePositonTimeReal");
			return (Criteria) this;
		}

		public Criteria andSignoutTimePredictIsNull() {
			addCriterion("SIGNOUT_TIME_PREDICT is null");
			return (Criteria) this;
		}

		public Criteria andSignoutTimePredictIsNotNull() {
			addCriterion("SIGNOUT_TIME_PREDICT is not null");
			return (Criteria) this;
		}

		public Criteria andSignoutTimePredictEqualTo(Date value) {
			addCriterion("SIGNOUT_TIME_PREDICT =", value, "signoutTimePredict");
			return (Criteria) this;
		}

		public Criteria andSignoutTimePredictNotEqualTo(Date value) {
			addCriterion("SIGNOUT_TIME_PREDICT <>", value, "signoutTimePredict");
			return (Criteria) this;
		}

		public Criteria andSignoutTimePredictGreaterThan(Date value) {
			addCriterion("SIGNOUT_TIME_PREDICT >", value, "signoutTimePredict");
			return (Criteria) this;
		}

		public Criteria andSignoutTimePredictGreaterThanOrEqualTo(Date value) {
			addCriterion("SIGNOUT_TIME_PREDICT >=", value, "signoutTimePredict");
			return (Criteria) this;
		}

		public Criteria andSignoutTimePredictLessThan(Date value) {
			addCriterion("SIGNOUT_TIME_PREDICT <", value, "signoutTimePredict");
			return (Criteria) this;
		}

		public Criteria andSignoutTimePredictLessThanOrEqualTo(Date value) {
			addCriterion("SIGNOUT_TIME_PREDICT <=", value, "signoutTimePredict");
			return (Criteria) this;
		}

		public Criteria andSignoutTimePredictIn(List<Date> values) {
			addCriterion("SIGNOUT_TIME_PREDICT in", values, "signoutTimePredict");
			return (Criteria) this;
		}

		public Criteria andSignoutTimePredictNotIn(List<Date> values) {
			addCriterion("SIGNOUT_TIME_PREDICT not in", values, "signoutTimePredict");
			return (Criteria) this;
		}

		public Criteria andSignoutTimePredictBetween(Date value1, Date value2) {
			addCriterion("SIGNOUT_TIME_PREDICT between", value1, value2, "signoutTimePredict");
			return (Criteria) this;
		}

		public Criteria andSignoutTimePredictNotBetween(Date value1, Date value2) {
			addCriterion("SIGNOUT_TIME_PREDICT not between", value1, value2, "signoutTimePredict");
			return (Criteria) this;
		}

		public Criteria andSignoutTimeRealIsNull() {
			addCriterion("SIGNOUT_TIME_REAL is null");
			return (Criteria) this;
		}

		public Criteria andSignoutTimeRealIsNotNull() {
			addCriterion("SIGNOUT_TIME_REAL is not null");
			return (Criteria) this;
		}

		public Criteria andSignoutTimeRealEqualTo(Date value) {
			addCriterion("SIGNOUT_TIME_REAL =", value, "signoutTimeReal");
			return (Criteria) this;
		}

		public Criteria andSignoutTimeRealNotEqualTo(Date value) {
			addCriterion("SIGNOUT_TIME_REAL <>", value, "signoutTimeReal");
			return (Criteria) this;
		}

		public Criteria andSignoutTimeRealGreaterThan(Date value) {
			addCriterion("SIGNOUT_TIME_REAL >", value, "signoutTimeReal");
			return (Criteria) this;
		}

		public Criteria andSignoutTimeRealGreaterThanOrEqualTo(Date value) {
			addCriterion("SIGNOUT_TIME_REAL >=", value, "signoutTimeReal");
			return (Criteria) this;
		}

		public Criteria andSignoutTimeRealLessThan(Date value) {
			addCriterion("SIGNOUT_TIME_REAL <", value, "signoutTimeReal");
			return (Criteria) this;
		}

		public Criteria andSignoutTimeRealLessThanOrEqualTo(Date value) {
			addCriterion("SIGNOUT_TIME_REAL <=", value, "signoutTimeReal");
			return (Criteria) this;
		}

		public Criteria andSignoutTimeRealIn(List<Date> values) {
			addCriterion("SIGNOUT_TIME_REAL in", values, "signoutTimeReal");
			return (Criteria) this;
		}

		public Criteria andSignoutTimeRealNotIn(List<Date> values) {
			addCriterion("SIGNOUT_TIME_REAL not in", values, "signoutTimeReal");
			return (Criteria) this;
		}

		public Criteria andSignoutTimeRealBetween(Date value1, Date value2) {
			addCriterion("SIGNOUT_TIME_REAL between", value1, value2, "signoutTimeReal");
			return (Criteria) this;
		}

		public Criteria andSignoutTimeRealNotBetween(Date value1, Date value2) {
			addCriterion("SIGNOUT_TIME_REAL not between", value1, value2, "signoutTimeReal");
			return (Criteria) this;
		}

		public Criteria andAnotherPayTimePredictIsNull() {
			addCriterion("ANOTHER_PAY_TIME_PREDICT is null");
			return (Criteria) this;
		}

		public Criteria andAnotherPayTimePredictIsNotNull() {
			addCriterion("ANOTHER_PAY_TIME_PREDICT is not null");
			return (Criteria) this;
		}

		public Criteria andAnotherPayTimePredictEqualTo(Date value) {
			addCriterion("ANOTHER_PAY_TIME_PREDICT =", value, "anotherPayTimePredict");
			return (Criteria) this;
		}

		public Criteria andAnotherPayTimePredictNotEqualTo(Date value) {
			addCriterion("ANOTHER_PAY_TIME_PREDICT <>", value, "anotherPayTimePredict");
			return (Criteria) this;
		}

		public Criteria andAnotherPayTimePredictGreaterThan(Date value) {
			addCriterion("ANOTHER_PAY_TIME_PREDICT >", value, "anotherPayTimePredict");
			return (Criteria) this;
		}

		public Criteria andAnotherPayTimePredictGreaterThanOrEqualTo(Date value) {
			addCriterion("ANOTHER_PAY_TIME_PREDICT >=", value, "anotherPayTimePredict");
			return (Criteria) this;
		}

		public Criteria andAnotherPayTimePredictLessThan(Date value) {
			addCriterion("ANOTHER_PAY_TIME_PREDICT <", value, "anotherPayTimePredict");
			return (Criteria) this;
		}

		public Criteria andAnotherPayTimePredictLessThanOrEqualTo(Date value) {
			addCriterion("ANOTHER_PAY_TIME_PREDICT <=", value, "anotherPayTimePredict");
			return (Criteria) this;
		}

		public Criteria andAnotherPayTimePredictIn(List<Date> values) {
			addCriterion("ANOTHER_PAY_TIME_PREDICT in", values, "anotherPayTimePredict");
			return (Criteria) this;
		}

		public Criteria andAnotherPayTimePredictNotIn(List<Date> values) {
			addCriterion("ANOTHER_PAY_TIME_PREDICT not in", values, "anotherPayTimePredict");
			return (Criteria) this;
		}

		public Criteria andAnotherPayTimePredictBetween(Date value1, Date value2) {
			addCriterion("ANOTHER_PAY_TIME_PREDICT between", value1, value2, "anotherPayTimePredict");
			return (Criteria) this;
		}

		public Criteria andAnotherPayTimePredictNotBetween(Date value1, Date value2) {
			addCriterion("ANOTHER_PAY_TIME_PREDICT not between", value1, value2, "anotherPayTimePredict");
			return (Criteria) this;
		}

		public Criteria andAnotherPayTimeRealIsNull() {
			addCriterion("ANOTHER_PAY_TIME_REAL is null");
			return (Criteria) this;
		}

		public Criteria andAnotherPayTimeRealIsNotNull() {
			addCriterion("ANOTHER_PAY_TIME_REAL is not null");
			return (Criteria) this;
		}

		public Criteria andAnotherPayTimeRealEqualTo(Date value) {
			addCriterion("ANOTHER_PAY_TIME_REAL =", value, "anotherPayTimeReal");
			return (Criteria) this;
		}

		public Criteria andAnotherPayTimeRealNotEqualTo(Date value) {
			addCriterion("ANOTHER_PAY_TIME_REAL <>", value, "anotherPayTimeReal");
			return (Criteria) this;
		}

		public Criteria andAnotherPayTimeRealGreaterThan(Date value) {
			addCriterion("ANOTHER_PAY_TIME_REAL >", value, "anotherPayTimeReal");
			return (Criteria) this;
		}

		public Criteria andAnotherPayTimeRealGreaterThanOrEqualTo(Date value) {
			addCriterion("ANOTHER_PAY_TIME_REAL >=", value, "anotherPayTimeReal");
			return (Criteria) this;
		}

		public Criteria andAnotherPayTimeRealLessThan(Date value) {
			addCriterion("ANOTHER_PAY_TIME_REAL <", value, "anotherPayTimeReal");
			return (Criteria) this;
		}

		public Criteria andAnotherPayTimeRealLessThanOrEqualTo(Date value) {
			addCriterion("ANOTHER_PAY_TIME_REAL <=", value, "anotherPayTimeReal");
			return (Criteria) this;
		}

		public Criteria andAnotherPayTimeRealIn(List<Date> values) {
			addCriterion("ANOTHER_PAY_TIME_REAL in", values, "anotherPayTimeReal");
			return (Criteria) this;
		}

		public Criteria andAnotherPayTimeRealNotIn(List<Date> values) {
			addCriterion("ANOTHER_PAY_TIME_REAL not in", values, "anotherPayTimeReal");
			return (Criteria) this;
		}

		public Criteria andAnotherPayTimeRealBetween(Date value1, Date value2) {
			addCriterion("ANOTHER_PAY_TIME_REAL between", value1, value2, "anotherPayTimeReal");
			return (Criteria) this;
		}

		public Criteria andAnotherPayTimeRealNotBetween(Date value1, Date value2) {
			addCriterion("ANOTHER_PAY_TIME_REAL not between", value1, value2, "anotherPayTimeReal");
			return (Criteria) this;
		}

		public Criteria andAnotherPayBalanceIsNull() {
			addCriterion("ANOTHER_PAY_BALANCE is null");
			return (Criteria) this;
		}

		public Criteria andAnotherPayBalanceIsNotNull() {
			addCriterion("ANOTHER_PAY_BALANCE is not null");
			return (Criteria) this;
		}

		public Criteria andAnotherPayBalanceEqualTo(BigDecimal value) {
			addCriterion("ANOTHER_PAY_BALANCE =", value, "anotherPayBalance");
			return (Criteria) this;
		}

		public Criteria andAnotherPayBalanceNotEqualTo(BigDecimal value) {
			addCriterion("ANOTHER_PAY_BALANCE <>", value, "anotherPayBalance");
			return (Criteria) this;
		}

		public Criteria andAnotherPayBalanceGreaterThan(BigDecimal value) {
			addCriterion("ANOTHER_PAY_BALANCE >", value, "anotherPayBalance");
			return (Criteria) this;
		}

		public Criteria andAnotherPayBalanceGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("ANOTHER_PAY_BALANCE >=", value, "anotherPayBalance");
			return (Criteria) this;
		}

		public Criteria andAnotherPayBalanceLessThan(BigDecimal value) {
			addCriterion("ANOTHER_PAY_BALANCE <", value, "anotherPayBalance");
			return (Criteria) this;
		}

		public Criteria andAnotherPayBalanceLessThanOrEqualTo(BigDecimal value) {
			addCriterion("ANOTHER_PAY_BALANCE <=", value, "anotherPayBalance");
			return (Criteria) this;
		}

		public Criteria andAnotherPayBalanceIn(List<BigDecimal> values) {
			addCriterion("ANOTHER_PAY_BALANCE in", values, "anotherPayBalance");
			return (Criteria) this;
		}

		public Criteria andAnotherPayBalanceNotIn(List<BigDecimal> values) {
			addCriterion("ANOTHER_PAY_BALANCE not in", values, "anotherPayBalance");
			return (Criteria) this;
		}

		public Criteria andAnotherPayBalanceBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("ANOTHER_PAY_BALANCE between", value1, value2, "anotherPayBalance");
			return (Criteria) this;
		}

		public Criteria andAnotherPayBalanceNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("ANOTHER_PAY_BALANCE not between", value1, value2, "anotherPayBalance");
			return (Criteria) this;
		}

		public Criteria andSuperviseDrawRestrictIsNull() {
			addCriterion("SUPERVISE_DRAW_RESTRICT is null");
			return (Criteria) this;
		}

		public Criteria andSuperviseDrawRestrictIsNotNull() {
			addCriterion("SUPERVISE_DRAW_RESTRICT is not null");
			return (Criteria) this;
		}

		public Criteria andSuperviseDrawRestrictEqualTo(String value) {
			addCriterion("SUPERVISE_DRAW_RESTRICT =", value, "superviseDrawRestrict");
			return (Criteria) this;
		}

		public Criteria andSuperviseDrawRestrictNotEqualTo(String value) {
			addCriterion("SUPERVISE_DRAW_RESTRICT <>", value, "superviseDrawRestrict");
			return (Criteria) this;
		}

		public Criteria andSuperviseDrawRestrictGreaterThan(String value) {
			addCriterion("SUPERVISE_DRAW_RESTRICT >", value, "superviseDrawRestrict");
			return (Criteria) this;
		}

		public Criteria andSuperviseDrawRestrictGreaterThanOrEqualTo(String value) {
			addCriterion("SUPERVISE_DRAW_RESTRICT >=", value, "superviseDrawRestrict");
			return (Criteria) this;
		}

		public Criteria andSuperviseDrawRestrictLessThan(String value) {
			addCriterion("SUPERVISE_DRAW_RESTRICT <", value, "superviseDrawRestrict");
			return (Criteria) this;
		}

		public Criteria andSuperviseDrawRestrictLessThanOrEqualTo(String value) {
			addCriterion("SUPERVISE_DRAW_RESTRICT <=", value, "superviseDrawRestrict");
			return (Criteria) this;
		}

		public Criteria andSuperviseDrawRestrictLike(String value) {
			addCriterion("SUPERVISE_DRAW_RESTRICT like", value, "superviseDrawRestrict");
			return (Criteria) this;
		}

		public Criteria andSuperviseDrawRestrictNotLike(String value) {
			addCriterion("SUPERVISE_DRAW_RESTRICT not like", value, "superviseDrawRestrict");
			return (Criteria) this;
		}

		public Criteria andSuperviseDrawRestrictIn(List<String> values) {
			addCriterion("SUPERVISE_DRAW_RESTRICT in", values, "superviseDrawRestrict");
			return (Criteria) this;
		}

		public Criteria andSuperviseDrawRestrictNotIn(List<String> values) {
			addCriterion("SUPERVISE_DRAW_RESTRICT not in", values, "superviseDrawRestrict");
			return (Criteria) this;
		}

		public Criteria andSuperviseDrawRestrictBetween(String value1, String value2) {
			addCriterion("SUPERVISE_DRAW_RESTRICT between", value1, value2, "superviseDrawRestrict");
			return (Criteria) this;
		}

		public Criteria andSuperviseDrawRestrictNotBetween(String value1, String value2) {
			addCriterion("SUPERVISE_DRAW_RESTRICT not between", value1, value2, "superviseDrawRestrict");
			return (Criteria) this;
		}

		public Criteria andIfQutaRightIsNull() {
			addCriterion("IF_QUTA_RIGHT is null");
			return (Criteria) this;
		}

		public Criteria andIfQutaRightIsNotNull() {
			addCriterion("IF_QUTA_RIGHT is not null");
			return (Criteria) this;
		}

		public Criteria andIfQutaRightEqualTo(Byte value) {
			addCriterion("IF_QUTA_RIGHT =", value, "ifQutaRight");
			return (Criteria) this;
		}

		public Criteria andIfQutaRightNotEqualTo(Byte value) {
			addCriterion("IF_QUTA_RIGHT <>", value, "ifQutaRight");
			return (Criteria) this;
		}

		public Criteria andIfQutaRightGreaterThan(Byte value) {
			addCriterion("IF_QUTA_RIGHT >", value, "ifQutaRight");
			return (Criteria) this;
		}

		public Criteria andIfQutaRightGreaterThanOrEqualTo(Byte value) {
			addCriterion("IF_QUTA_RIGHT >=", value, "ifQutaRight");
			return (Criteria) this;
		}

		public Criteria andIfQutaRightLessThan(Byte value) {
			addCriterion("IF_QUTA_RIGHT <", value, "ifQutaRight");
			return (Criteria) this;
		}

		public Criteria andIfQutaRightLessThanOrEqualTo(Byte value) {
			addCriterion("IF_QUTA_RIGHT <=", value, "ifQutaRight");
			return (Criteria) this;
		}

		public Criteria andIfQutaRightIn(List<Byte> values) {
			addCriterion("IF_QUTA_RIGHT in", values, "ifQutaRight");
			return (Criteria) this;
		}

		public Criteria andIfQutaRightNotIn(List<Byte> values) {
			addCriterion("IF_QUTA_RIGHT not in", values, "ifQutaRight");
			return (Criteria) this;
		}

		public Criteria andIfQutaRightBetween(Byte value1, Byte value2) {
			addCriterion("IF_QUTA_RIGHT between", value1, value2, "ifQutaRight");
			return (Criteria) this;
		}

		public Criteria andIfQutaRightNotBetween(Byte value1, Byte value2) {
			addCriterion("IF_QUTA_RIGHT not between", value1, value2, "ifQutaRight");
			return (Criteria) this;
		}

		public Criteria andIfHandOverBankIsNull() {
			addCriterion("IF_HAND_OVER_BANK is null");
			return (Criteria) this;
		}

		public Criteria andIfHandOverBankIsNotNull() {
			addCriterion("IF_HAND_OVER_BANK is not null");
			return (Criteria) this;
		}

		public Criteria andIfHandOverBankEqualTo(Byte value) {
			addCriterion("IF_HAND_OVER_BANK =", value, "ifHandOverBank");
			return (Criteria) this;
		}

		public Criteria andIfHandOverBankNotEqualTo(Byte value) {
			addCriterion("IF_HAND_OVER_BANK <>", value, "ifHandOverBank");
			return (Criteria) this;
		}

		public Criteria andIfHandOverBankGreaterThan(Byte value) {
			addCriterion("IF_HAND_OVER_BANK >", value, "ifHandOverBank");
			return (Criteria) this;
		}

		public Criteria andIfHandOverBankGreaterThanOrEqualTo(Byte value) {
			addCriterion("IF_HAND_OVER_BANK >=", value, "ifHandOverBank");
			return (Criteria) this;
		}

		public Criteria andIfHandOverBankLessThan(Byte value) {
			addCriterion("IF_HAND_OVER_BANK <", value, "ifHandOverBank");
			return (Criteria) this;
		}

		public Criteria andIfHandOverBankLessThanOrEqualTo(Byte value) {
			addCriterion("IF_HAND_OVER_BANK <=", value, "ifHandOverBank");
			return (Criteria) this;
		}

		public Criteria andIfHandOverBankIn(List<Byte> values) {
			addCriterion("IF_HAND_OVER_BANK in", values, "ifHandOverBank");
			return (Criteria) this;
		}

		public Criteria andIfHandOverBankNotIn(List<Byte> values) {
			addCriterion("IF_HAND_OVER_BANK not in", values, "ifHandOverBank");
			return (Criteria) this;
		}

		public Criteria andIfHandOverBankBetween(Byte value1, Byte value2) {
			addCriterion("IF_HAND_OVER_BANK between", value1, value2, "ifHandOverBank");
			return (Criteria) this;
		}

		public Criteria andIfHandOverBankNotBetween(Byte value1, Byte value2) {
			addCriterion("IF_HAND_OVER_BANK not between", value1, value2, "ifHandOverBank");
			return (Criteria) this;
		}

		public Criteria andHandOverEmployeeIsNull() {
			addCriterion("HAND_OVER_EMPLOYEE is null");
			return (Criteria) this;
		}

		public Criteria andHandOverEmployeeIsNotNull() {
			addCriterion("HAND_OVER_EMPLOYEE is not null");
			return (Criteria) this;
		}

		public Criteria andHandOverEmployeeEqualTo(Integer value) {
			addCriterion("HAND_OVER_EMPLOYEE =", value, "handOverEmployee");
			return (Criteria) this;
		}

		public Criteria andHandOverEmployeeNotEqualTo(Integer value) {
			addCriterion("HAND_OVER_EMPLOYEE <>", value, "handOverEmployee");
			return (Criteria) this;
		}

		public Criteria andHandOverEmployeeGreaterThan(Integer value) {
			addCriterion("HAND_OVER_EMPLOYEE >", value, "handOverEmployee");
			return (Criteria) this;
		}

		public Criteria andHandOverEmployeeGreaterThanOrEqualTo(Integer value) {
			addCriterion("HAND_OVER_EMPLOYEE >=", value, "handOverEmployee");
			return (Criteria) this;
		}

		public Criteria andHandOverEmployeeLessThan(Integer value) {
			addCriterion("HAND_OVER_EMPLOYEE <", value, "handOverEmployee");
			return (Criteria) this;
		}

		public Criteria andHandOverEmployeeLessThanOrEqualTo(Integer value) {
			addCriterion("HAND_OVER_EMPLOYEE <=", value, "handOverEmployee");
			return (Criteria) this;
		}

		public Criteria andHandOverEmployeeIn(List<Integer> values) {
			addCriterion("HAND_OVER_EMPLOYEE in", values, "handOverEmployee");
			return (Criteria) this;
		}

		public Criteria andHandOverEmployeeNotIn(List<Integer> values) {
			addCriterion("HAND_OVER_EMPLOYEE not in", values, "handOverEmployee");
			return (Criteria) this;
		}

		public Criteria andHandOverEmployeeBetween(Integer value1, Integer value2) {
			addCriterion("HAND_OVER_EMPLOYEE between", value1, value2, "handOverEmployee");
			return (Criteria) this;
		}

		public Criteria andHandOverEmployeeNotBetween(Integer value1, Integer value2) {
			addCriterion("HAND_OVER_EMPLOYEE not between", value1, value2, "handOverEmployee");
			return (Criteria) this;
		}

		public Criteria andLoanTimeIsNull() {
			addCriterion("LOAN_TIME is null");
			return (Criteria) this;
		}

		public Criteria andLoanTimeIsNotNull() {
			addCriterion("LOAN_TIME is not null");
			return (Criteria) this;
		}

		public Criteria andLoanTimeEqualTo(Date value) {
			addCriterion("LOAN_TIME =", value, "loanTime");
			return (Criteria) this;
		}

		public Criteria andLoanTimeNotEqualTo(Date value) {
			addCriterion("LOAN_TIME <>", value, "loanTime");
			return (Criteria) this;
		}

		public Criteria andLoanTimeGreaterThan(Date value) {
			addCriterion("LOAN_TIME >", value, "loanTime");
			return (Criteria) this;
		}

		public Criteria andLoanTimeGreaterThanOrEqualTo(Date value) {
			addCriterion("LOAN_TIME >=", value, "loanTime");
			return (Criteria) this;
		}

		public Criteria andLoanTimeLessThan(Date value) {
			addCriterion("LOAN_TIME <", value, "loanTime");
			return (Criteria) this;
		}

		public Criteria andLoanTimeLessThanOrEqualTo(Date value) {
			addCriterion("LOAN_TIME <=", value, "loanTime");
			return (Criteria) this;
		}

		public Criteria andLoanTimeIn(List<Date> values) {
			addCriterion("LOAN_TIME in", values, "loanTime");
			return (Criteria) this;
		}

		public Criteria andLoanTimeNotIn(List<Date> values) {
			addCriterion("LOAN_TIME not in", values, "loanTime");
			return (Criteria) this;
		}

		public Criteria andLoanTimeBetween(Date value1, Date value2) {
			addCriterion("LOAN_TIME between", value1, value2, "loanTime");
			return (Criteria) this;
		}

		public Criteria andLoanTimeNotBetween(Date value1, Date value2) {
			addCriterion("LOAN_TIME not between", value1, value2, "loanTime");
			return (Criteria) this;
		}

		public Criteria andVendorNameIsNull() {
			addCriterion("VENDOR_NAME is null");
			return (Criteria) this;
		}

		public Criteria andVendorNameIsNotNull() {
			addCriterion("VENDOR_NAME is not null");
			return (Criteria) this;
		}

		public Criteria andVendorNameEqualTo(String value) {
			addCriterion("VENDOR_NAME =", value, "vendorName");
			return (Criteria) this;
		}

		public Criteria andVendorNameNotEqualTo(String value) {
			addCriterion("VENDOR_NAME <>", value, "vendorName");
			return (Criteria) this;
		}

		public Criteria andVendorNameGreaterThan(String value) {
			addCriterion("VENDOR_NAME >", value, "vendorName");
			return (Criteria) this;
		}

		public Criteria andVendorNameGreaterThanOrEqualTo(String value) {
			addCriterion("VENDOR_NAME >=", value, "vendorName");
			return (Criteria) this;
		}

		public Criteria andVendorNameLessThan(String value) {
			addCriterion("VENDOR_NAME <", value, "vendorName");
			return (Criteria) this;
		}

		public Criteria andVendorNameLessThanOrEqualTo(String value) {
			addCriterion("VENDOR_NAME <=", value, "vendorName");
			return (Criteria) this;
		}

		public Criteria andVendorNameLike(String value) {
			addCriterion("VENDOR_NAME like", value, "vendorName");
			return (Criteria) this;
		}

		public Criteria andVendorNameNotLike(String value) {
			addCriterion("VENDOR_NAME not like", value, "vendorName");
			return (Criteria) this;
		}

		public Criteria andVendorNameIn(List<String> values) {
			addCriterion("VENDOR_NAME in", values, "vendorName");
			return (Criteria) this;
		}

		public Criteria andVendorNameNotIn(List<String> values) {
			addCriterion("VENDOR_NAME not in", values, "vendorName");
			return (Criteria) this;
		}

		public Criteria andVendorNameBetween(String value1, String value2) {
			addCriterion("VENDOR_NAME between", value1, value2, "vendorName");
			return (Criteria) this;
		}

		public Criteria andVendorNameNotBetween(String value1, String value2) {
			addCriterion("VENDOR_NAME not between", value1, value2, "vendorName");
			return (Criteria) this;
		}

		public Criteria andVendorIdNumberIsNull() {
			addCriterion("VENDOR_ID_NUMBER is null");
			return (Criteria) this;
		}

		public Criteria andVendorIdNumberIsNotNull() {
			addCriterion("VENDOR_ID_NUMBER is not null");
			return (Criteria) this;
		}

		public Criteria andVendorIdNumberEqualTo(String value) {
			addCriterion("VENDOR_ID_NUMBER =", value, "vendorIdNumber");
			return (Criteria) this;
		}

		public Criteria andVendorIdNumberNotEqualTo(String value) {
			addCriterion("VENDOR_ID_NUMBER <>", value, "vendorIdNumber");
			return (Criteria) this;
		}

		public Criteria andVendorIdNumberGreaterThan(String value) {
			addCriterion("VENDOR_ID_NUMBER >", value, "vendorIdNumber");
			return (Criteria) this;
		}

		public Criteria andVendorIdNumberGreaterThanOrEqualTo(String value) {
			addCriterion("VENDOR_ID_NUMBER >=", value, "vendorIdNumber");
			return (Criteria) this;
		}

		public Criteria andVendorIdNumberLessThan(String value) {
			addCriterion("VENDOR_ID_NUMBER <", value, "vendorIdNumber");
			return (Criteria) this;
		}

		public Criteria andVendorIdNumberLessThanOrEqualTo(String value) {
			addCriterion("VENDOR_ID_NUMBER <=", value, "vendorIdNumber");
			return (Criteria) this;
		}

		public Criteria andVendorIdNumberLike(String value) {
			addCriterion("VENDOR_ID_NUMBER like", value, "vendorIdNumber");
			return (Criteria) this;
		}

		public Criteria andVendorIdNumberNotLike(String value) {
			addCriterion("VENDOR_ID_NUMBER not like", value, "vendorIdNumber");
			return (Criteria) this;
		}

		public Criteria andVendorIdNumberIn(List<String> values) {
			addCriterion("VENDOR_ID_NUMBER in", values, "vendorIdNumber");
			return (Criteria) this;
		}

		public Criteria andVendorIdNumberNotIn(List<String> values) {
			addCriterion("VENDOR_ID_NUMBER not in", values, "vendorIdNumber");
			return (Criteria) this;
		}

		public Criteria andVendorIdNumberBetween(String value1, String value2) {
			addCriterion("VENDOR_ID_NUMBER between", value1, value2, "vendorIdNumber");
			return (Criteria) this;
		}

		public Criteria andVendorIdNumberNotBetween(String value1, String value2) {
			addCriterion("VENDOR_ID_NUMBER not between", value1, value2, "vendorIdNumber");
			return (Criteria) this;
		}

		public Criteria andVendorPhoneIsNull() {
			addCriterion("VENDOR_PHONE is null");
			return (Criteria) this;
		}

		public Criteria andVendorPhoneIsNotNull() {
			addCriterion("VENDOR_PHONE is not null");
			return (Criteria) this;
		}

		public Criteria andVendorPhoneEqualTo(String value) {
			addCriterion("VENDOR_PHONE =", value, "vendorPhone");
			return (Criteria) this;
		}

		public Criteria andVendorPhoneNotEqualTo(String value) {
			addCriterion("VENDOR_PHONE <>", value, "vendorPhone");
			return (Criteria) this;
		}

		public Criteria andVendorPhoneGreaterThan(String value) {
			addCriterion("VENDOR_PHONE >", value, "vendorPhone");
			return (Criteria) this;
		}

		public Criteria andVendorPhoneGreaterThanOrEqualTo(String value) {
			addCriterion("VENDOR_PHONE >=", value, "vendorPhone");
			return (Criteria) this;
		}

		public Criteria andVendorPhoneLessThan(String value) {
			addCriterion("VENDOR_PHONE <", value, "vendorPhone");
			return (Criteria) this;
		}

		public Criteria andVendorPhoneLessThanOrEqualTo(String value) {
			addCriterion("VENDOR_PHONE <=", value, "vendorPhone");
			return (Criteria) this;
		}

		public Criteria andVendorPhoneLike(String value) {
			addCriterion("VENDOR_PHONE like", value, "vendorPhone");
			return (Criteria) this;
		}

		public Criteria andVendorPhoneNotLike(String value) {
			addCriterion("VENDOR_PHONE not like", value, "vendorPhone");
			return (Criteria) this;
		}

		public Criteria andVendorPhoneIn(List<String> values) {
			addCriterion("VENDOR_PHONE in", values, "vendorPhone");
			return (Criteria) this;
		}

		public Criteria andVendorPhoneNotIn(List<String> values) {
			addCriterion("VENDOR_PHONE not in", values, "vendorPhone");
			return (Criteria) this;
		}

		public Criteria andVendorPhoneBetween(String value1, String value2) {
			addCriterion("VENDOR_PHONE between", value1, value2, "vendorPhone");
			return (Criteria) this;
		}

		public Criteria andVendorPhoneNotBetween(String value1, String value2) {
			addCriterion("VENDOR_PHONE not between", value1, value2, "vendorPhone");
			return (Criteria) this;
		}

		public Criteria andVendorCommonOwnerNameIsNull() {
			addCriterion("VENDOR_COMMON_OWNER_NAME is null");
			return (Criteria) this;
		}

		public Criteria andVendorCommonOwnerNameIsNotNull() {
			addCriterion("VENDOR_COMMON_OWNER_NAME is not null");
			return (Criteria) this;
		}

		public Criteria andVendorCommonOwnerNameEqualTo(String value) {
			addCriterion("VENDOR_COMMON_OWNER_NAME =", value, "vendorCommonOwnerName");
			return (Criteria) this;
		}

		public Criteria andVendorCommonOwnerNameNotEqualTo(String value) {
			addCriterion("VENDOR_COMMON_OWNER_NAME <>", value, "vendorCommonOwnerName");
			return (Criteria) this;
		}

		public Criteria andVendorCommonOwnerNameGreaterThan(String value) {
			addCriterion("VENDOR_COMMON_OWNER_NAME >", value, "vendorCommonOwnerName");
			return (Criteria) this;
		}

		public Criteria andVendorCommonOwnerNameGreaterThanOrEqualTo(String value) {
			addCriterion("VENDOR_COMMON_OWNER_NAME >=", value, "vendorCommonOwnerName");
			return (Criteria) this;
		}

		public Criteria andVendorCommonOwnerNameLessThan(String value) {
			addCriterion("VENDOR_COMMON_OWNER_NAME <", value, "vendorCommonOwnerName");
			return (Criteria) this;
		}

		public Criteria andVendorCommonOwnerNameLessThanOrEqualTo(String value) {
			addCriterion("VENDOR_COMMON_OWNER_NAME <=", value, "vendorCommonOwnerName");
			return (Criteria) this;
		}

		public Criteria andVendorCommonOwnerNameLike(String value) {
			addCriterion("VENDOR_COMMON_OWNER_NAME like", value, "vendorCommonOwnerName");
			return (Criteria) this;
		}

		public Criteria andVendorCommonOwnerNameNotLike(String value) {
			addCriterion("VENDOR_COMMON_OWNER_NAME not like", value, "vendorCommonOwnerName");
			return (Criteria) this;
		}

		public Criteria andVendorCommonOwnerNameIn(List<String> values) {
			addCriterion("VENDOR_COMMON_OWNER_NAME in", values, "vendorCommonOwnerName");
			return (Criteria) this;
		}

		public Criteria andVendorCommonOwnerNameNotIn(List<String> values) {
			addCriterion("VENDOR_COMMON_OWNER_NAME not in", values, "vendorCommonOwnerName");
			return (Criteria) this;
		}

		public Criteria andVendorCommonOwnerNameBetween(String value1, String value2) {
			addCriterion("VENDOR_COMMON_OWNER_NAME between", value1, value2, "vendorCommonOwnerName");
			return (Criteria) this;
		}

		public Criteria andVendorCommonOwnerNameNotBetween(String value1, String value2) {
			addCriterion("VENDOR_COMMON_OWNER_NAME not between", value1, value2, "vendorCommonOwnerName");
			return (Criteria) this;
		}

		public Criteria andVendorCommonOwnerIdNumberIsNull() {
			addCriterion("VENDOR_COMMON_OWNER_ID_NUMBER is null");
			return (Criteria) this;
		}

		public Criteria andVendorCommonOwnerIdNumberIsNotNull() {
			addCriterion("VENDOR_COMMON_OWNER_ID_NUMBER is not null");
			return (Criteria) this;
		}

		public Criteria andVendorCommonOwnerIdNumberEqualTo(String value) {
			addCriterion("VENDOR_COMMON_OWNER_ID_NUMBER =", value, "vendorCommonOwnerIdNumber");
			return (Criteria) this;
		}

		public Criteria andVendorCommonOwnerIdNumberNotEqualTo(String value) {
			addCriterion("VENDOR_COMMON_OWNER_ID_NUMBER <>", value, "vendorCommonOwnerIdNumber");
			return (Criteria) this;
		}

		public Criteria andVendorCommonOwnerIdNumberGreaterThan(String value) {
			addCriterion("VENDOR_COMMON_OWNER_ID_NUMBER >", value, "vendorCommonOwnerIdNumber");
			return (Criteria) this;
		}

		public Criteria andVendorCommonOwnerIdNumberGreaterThanOrEqualTo(String value) {
			addCriterion("VENDOR_COMMON_OWNER_ID_NUMBER >=", value, "vendorCommonOwnerIdNumber");
			return (Criteria) this;
		}

		public Criteria andVendorCommonOwnerIdNumberLessThan(String value) {
			addCriterion("VENDOR_COMMON_OWNER_ID_NUMBER <", value, "vendorCommonOwnerIdNumber");
			return (Criteria) this;
		}

		public Criteria andVendorCommonOwnerIdNumberLessThanOrEqualTo(String value) {
			addCriterion("VENDOR_COMMON_OWNER_ID_NUMBER <=", value, "vendorCommonOwnerIdNumber");
			return (Criteria) this;
		}

		public Criteria andVendorCommonOwnerIdNumberLike(String value) {
			addCriterion("VENDOR_COMMON_OWNER_ID_NUMBER like", value, "vendorCommonOwnerIdNumber");
			return (Criteria) this;
		}

		public Criteria andVendorCommonOwnerIdNumberNotLike(String value) {
			addCriterion("VENDOR_COMMON_OWNER_ID_NUMBER not like", value, "vendorCommonOwnerIdNumber");
			return (Criteria) this;
		}

		public Criteria andVendorCommonOwnerIdNumberIn(List<String> values) {
			addCriterion("VENDOR_COMMON_OWNER_ID_NUMBER in", values, "vendorCommonOwnerIdNumber");
			return (Criteria) this;
		}

		public Criteria andVendorCommonOwnerIdNumberNotIn(List<String> values) {
			addCriterion("VENDOR_COMMON_OWNER_ID_NUMBER not in", values, "vendorCommonOwnerIdNumber");
			return (Criteria) this;
		}

		public Criteria andVendorCommonOwnerIdNumberBetween(String value1, String value2) {
			addCriterion("VENDOR_COMMON_OWNER_ID_NUMBER between", value1, value2, "vendorCommonOwnerIdNumber");
			return (Criteria) this;
		}

		public Criteria andVendorCommonOwnerIdNumberNotBetween(String value1, String value2) {
			addCriterion("VENDOR_COMMON_OWNER_ID_NUMBER not between", value1, value2, "vendorCommonOwnerIdNumber");
			return (Criteria) this;
		}

		public Criteria andVendorCommonOwnerPhoneIsNull() {
			addCriterion("VENDOR_COMMON_OWNER_PHONE is null");
			return (Criteria) this;
		}

		public Criteria andVendorCommonOwnerPhoneIsNotNull() {
			addCriterion("VENDOR_COMMON_OWNER_PHONE is not null");
			return (Criteria) this;
		}

		public Criteria andVendorCommonOwnerPhoneEqualTo(String value) {
			addCriterion("VENDOR_COMMON_OWNER_PHONE =", value, "vendorCommonOwnerPhone");
			return (Criteria) this;
		}

		public Criteria andVendorCommonOwnerPhoneNotEqualTo(String value) {
			addCriterion("VENDOR_COMMON_OWNER_PHONE <>", value, "vendorCommonOwnerPhone");
			return (Criteria) this;
		}

		public Criteria andVendorCommonOwnerPhoneGreaterThan(String value) {
			addCriterion("VENDOR_COMMON_OWNER_PHONE >", value, "vendorCommonOwnerPhone");
			return (Criteria) this;
		}

		public Criteria andVendorCommonOwnerPhoneGreaterThanOrEqualTo(String value) {
			addCriterion("VENDOR_COMMON_OWNER_PHONE >=", value, "vendorCommonOwnerPhone");
			return (Criteria) this;
		}

		public Criteria andVendorCommonOwnerPhoneLessThan(String value) {
			addCriterion("VENDOR_COMMON_OWNER_PHONE <", value, "vendorCommonOwnerPhone");
			return (Criteria) this;
		}

		public Criteria andVendorCommonOwnerPhoneLessThanOrEqualTo(String value) {
			addCriterion("VENDOR_COMMON_OWNER_PHONE <=", value, "vendorCommonOwnerPhone");
			return (Criteria) this;
		}

		public Criteria andVendorCommonOwnerPhoneLike(String value) {
			addCriterion("VENDOR_COMMON_OWNER_PHONE like", value, "vendorCommonOwnerPhone");
			return (Criteria) this;
		}

		public Criteria andVendorCommonOwnerPhoneNotLike(String value) {
			addCriterion("VENDOR_COMMON_OWNER_PHONE not like", value, "vendorCommonOwnerPhone");
			return (Criteria) this;
		}

		public Criteria andVendorCommonOwnerPhoneIn(List<String> values) {
			addCriterion("VENDOR_COMMON_OWNER_PHONE in", values, "vendorCommonOwnerPhone");
			return (Criteria) this;
		}

		public Criteria andVendorCommonOwnerPhoneNotIn(List<String> values) {
			addCriterion("VENDOR_COMMON_OWNER_PHONE not in", values, "vendorCommonOwnerPhone");
			return (Criteria) this;
		}

		public Criteria andVendorCommonOwnerPhoneBetween(String value1, String value2) {
			addCriterion("VENDOR_COMMON_OWNER_PHONE between", value1, value2, "vendorCommonOwnerPhone");
			return (Criteria) this;
		}

		public Criteria andVendorCommonOwnerPhoneNotBetween(String value1, String value2) {
			addCriterion("VENDOR_COMMON_OWNER_PHONE not between", value1, value2, "vendorCommonOwnerPhone");
			return (Criteria) this;
		}

		public Criteria andVendorSuretyNameIsNull() {
			addCriterion("VENDOR_SURETY_NAME is null");
			return (Criteria) this;
		}

		public Criteria andVendorSuretyNameIsNotNull() {
			addCriterion("VENDOR_SURETY_NAME is not null");
			return (Criteria) this;
		}

		public Criteria andVendorSuretyNameEqualTo(String value) {
			addCriterion("VENDOR_SURETY_NAME =", value, "vendorSuretyName");
			return (Criteria) this;
		}

		public Criteria andVendorSuretyNameNotEqualTo(String value) {
			addCriterion("VENDOR_SURETY_NAME <>", value, "vendorSuretyName");
			return (Criteria) this;
		}

		public Criteria andVendorSuretyNameGreaterThan(String value) {
			addCriterion("VENDOR_SURETY_NAME >", value, "vendorSuretyName");
			return (Criteria) this;
		}

		public Criteria andVendorSuretyNameGreaterThanOrEqualTo(String value) {
			addCriterion("VENDOR_SURETY_NAME >=", value, "vendorSuretyName");
			return (Criteria) this;
		}

		public Criteria andVendorSuretyNameLessThan(String value) {
			addCriterion("VENDOR_SURETY_NAME <", value, "vendorSuretyName");
			return (Criteria) this;
		}

		public Criteria andVendorSuretyNameLessThanOrEqualTo(String value) {
			addCriterion("VENDOR_SURETY_NAME <=", value, "vendorSuretyName");
			return (Criteria) this;
		}

		public Criteria andVendorSuretyNameLike(String value) {
			addCriterion("VENDOR_SURETY_NAME like", value, "vendorSuretyName");
			return (Criteria) this;
		}

		public Criteria andVendorSuretyNameNotLike(String value) {
			addCriterion("VENDOR_SURETY_NAME not like", value, "vendorSuretyName");
			return (Criteria) this;
		}

		public Criteria andVendorSuretyNameIn(List<String> values) {
			addCriterion("VENDOR_SURETY_NAME in", values, "vendorSuretyName");
			return (Criteria) this;
		}

		public Criteria andVendorSuretyNameNotIn(List<String> values) {
			addCriterion("VENDOR_SURETY_NAME not in", values, "vendorSuretyName");
			return (Criteria) this;
		}

		public Criteria andVendorSuretyNameBetween(String value1, String value2) {
			addCriterion("VENDOR_SURETY_NAME between", value1, value2, "vendorSuretyName");
			return (Criteria) this;
		}

		public Criteria andVendorSuretyNameNotBetween(String value1, String value2) {
			addCriterion("VENDOR_SURETY_NAME not between", value1, value2, "vendorSuretyName");
			return (Criteria) this;
		}

		public Criteria andVendorSuretyIdNumberIsNull() {
			addCriterion("VENDOR_SURETY_ID_NUMBER is null");
			return (Criteria) this;
		}

		public Criteria andVendorSuretyIdNumberIsNotNull() {
			addCriterion("VENDOR_SURETY_ID_NUMBER is not null");
			return (Criteria) this;
		}

		public Criteria andVendorSuretyIdNumberEqualTo(String value) {
			addCriterion("VENDOR_SURETY_ID_NUMBER =", value, "vendorSuretyIdNumber");
			return (Criteria) this;
		}

		public Criteria andVendorSuretyIdNumberNotEqualTo(String value) {
			addCriterion("VENDOR_SURETY_ID_NUMBER <>", value, "vendorSuretyIdNumber");
			return (Criteria) this;
		}

		public Criteria andVendorSuretyIdNumberGreaterThan(String value) {
			addCriterion("VENDOR_SURETY_ID_NUMBER >", value, "vendorSuretyIdNumber");
			return (Criteria) this;
		}

		public Criteria andVendorSuretyIdNumberGreaterThanOrEqualTo(String value) {
			addCriterion("VENDOR_SURETY_ID_NUMBER >=", value, "vendorSuretyIdNumber");
			return (Criteria) this;
		}

		public Criteria andVendorSuretyIdNumberLessThan(String value) {
			addCriterion("VENDOR_SURETY_ID_NUMBER <", value, "vendorSuretyIdNumber");
			return (Criteria) this;
		}

		public Criteria andVendorSuretyIdNumberLessThanOrEqualTo(String value) {
			addCriterion("VENDOR_SURETY_ID_NUMBER <=", value, "vendorSuretyIdNumber");
			return (Criteria) this;
		}

		public Criteria andVendorSuretyIdNumberLike(String value) {
			addCriterion("VENDOR_SURETY_ID_NUMBER like", value, "vendorSuretyIdNumber");
			return (Criteria) this;
		}

		public Criteria andVendorSuretyIdNumberNotLike(String value) {
			addCriterion("VENDOR_SURETY_ID_NUMBER not like", value, "vendorSuretyIdNumber");
			return (Criteria) this;
		}

		public Criteria andVendorSuretyIdNumberIn(List<String> values) {
			addCriterion("VENDOR_SURETY_ID_NUMBER in", values, "vendorSuretyIdNumber");
			return (Criteria) this;
		}

		public Criteria andVendorSuretyIdNumberNotIn(List<String> values) {
			addCriterion("VENDOR_SURETY_ID_NUMBER not in", values, "vendorSuretyIdNumber");
			return (Criteria) this;
		}

		public Criteria andVendorSuretyIdNumberBetween(String value1, String value2) {
			addCriterion("VENDOR_SURETY_ID_NUMBER between", value1, value2, "vendorSuretyIdNumber");
			return (Criteria) this;
		}

		public Criteria andVendorSuretyIdNumberNotBetween(String value1, String value2) {
			addCriterion("VENDOR_SURETY_ID_NUMBER not between", value1, value2, "vendorSuretyIdNumber");
			return (Criteria) this;
		}

		public Criteria andVendorSuretyPhoneIsNull() {
			addCriterion("VENDOR_SURETY_PHONE is null");
			return (Criteria) this;
		}

		public Criteria andVendorSuretyPhoneIsNotNull() {
			addCriterion("VENDOR_SURETY_PHONE is not null");
			return (Criteria) this;
		}

		public Criteria andVendorSuretyPhoneEqualTo(String value) {
			addCriterion("VENDOR_SURETY_PHONE =", value, "vendorSuretyPhone");
			return (Criteria) this;
		}

		public Criteria andVendorSuretyPhoneNotEqualTo(String value) {
			addCriterion("VENDOR_SURETY_PHONE <>", value, "vendorSuretyPhone");
			return (Criteria) this;
		}

		public Criteria andVendorSuretyPhoneGreaterThan(String value) {
			addCriterion("VENDOR_SURETY_PHONE >", value, "vendorSuretyPhone");
			return (Criteria) this;
		}

		public Criteria andVendorSuretyPhoneGreaterThanOrEqualTo(String value) {
			addCriterion("VENDOR_SURETY_PHONE >=", value, "vendorSuretyPhone");
			return (Criteria) this;
		}

		public Criteria andVendorSuretyPhoneLessThan(String value) {
			addCriterion("VENDOR_SURETY_PHONE <", value, "vendorSuretyPhone");
			return (Criteria) this;
		}

		public Criteria andVendorSuretyPhoneLessThanOrEqualTo(String value) {
			addCriterion("VENDOR_SURETY_PHONE <=", value, "vendorSuretyPhone");
			return (Criteria) this;
		}

		public Criteria andVendorSuretyPhoneLike(String value) {
			addCriterion("VENDOR_SURETY_PHONE like", value, "vendorSuretyPhone");
			return (Criteria) this;
		}

		public Criteria andVendorSuretyPhoneNotLike(String value) {
			addCriterion("VENDOR_SURETY_PHONE not like", value, "vendorSuretyPhone");
			return (Criteria) this;
		}

		public Criteria andVendorSuretyPhoneIn(List<String> values) {
			addCriterion("VENDOR_SURETY_PHONE in", values, "vendorSuretyPhone");
			return (Criteria) this;
		}

		public Criteria andVendorSuretyPhoneNotIn(List<String> values) {
			addCriterion("VENDOR_SURETY_PHONE not in", values, "vendorSuretyPhone");
			return (Criteria) this;
		}

		public Criteria andVendorSuretyPhoneBetween(String value1, String value2) {
			addCriterion("VENDOR_SURETY_PHONE between", value1, value2, "vendorSuretyPhone");
			return (Criteria) this;
		}

		public Criteria andVendorSuretyPhoneNotBetween(String value1, String value2) {
			addCriterion("VENDOR_SURETY_PHONE not between", value1, value2, "vendorSuretyPhone");
			return (Criteria) this;
		}

		public Criteria andApprovalPassTimeIsNull() {
			addCriterion("APPROVAL_PASS_TIME is null");
			return (Criteria) this;
		}

		public Criteria andApprovalPassTimeIsNotNull() {
			addCriterion("APPROVAL_PASS_TIME is not null");
			return (Criteria) this;
		}

		public Criteria andApprovalPassTimeEqualTo(Date value) {
			addCriterion("APPROVAL_PASS_TIME =", value, "approvalPassTime");
			return (Criteria) this;
		}

		public Criteria andApprovalPassTimeNotEqualTo(Date value) {
			addCriterion("APPROVAL_PASS_TIME <>", value, "approvalPassTime");
			return (Criteria) this;
		}

		public Criteria andApprovalPassTimeGreaterThan(Date value) {
			addCriterion("APPROVAL_PASS_TIME >", value, "approvalPassTime");
			return (Criteria) this;
		}

		public Criteria andApprovalPassTimeGreaterThanOrEqualTo(Date value) {
			addCriterion("APPROVAL_PASS_TIME >=", value, "approvalPassTime");
			return (Criteria) this;
		}

		public Criteria andApprovalPassTimeLessThan(Date value) {
			addCriterion("APPROVAL_PASS_TIME <", value, "approvalPassTime");
			return (Criteria) this;
		}

		public Criteria andApprovalPassTimeLessThanOrEqualTo(Date value) {
			addCriterion("APPROVAL_PASS_TIME <=", value, "approvalPassTime");
			return (Criteria) this;
		}

		public Criteria andApprovalPassTimeIn(List<Date> values) {
			addCriterion("APPROVAL_PASS_TIME in", values, "approvalPassTime");
			return (Criteria) this;
		}

		public Criteria andApprovalPassTimeNotIn(List<Date> values) {
			addCriterion("APPROVAL_PASS_TIME not in", values, "approvalPassTime");
			return (Criteria) this;
		}

		public Criteria andApprovalPassTimeBetween(Date value1, Date value2) {
			addCriterion("APPROVAL_PASS_TIME between", value1, value2, "approvalPassTime");
			return (Criteria) this;
		}

		public Criteria andApprovalPassTimeNotBetween(Date value1, Date value2) {
			addCriterion("APPROVAL_PASS_TIME not between", value1, value2, "approvalPassTime");
			return (Criteria) this;
		}

		public Criteria andVendorConditionDescriptionIsNull() {
			addCriterion("VENDOR_CONDITION_DESCRIPTION is null");
			return (Criteria) this;
		}

		public Criteria andVendorConditionDescriptionIsNotNull() {
			addCriterion("VENDOR_CONDITION_DESCRIPTION is not null");
			return (Criteria) this;
		}

		public Criteria andVendorConditionDescriptionEqualTo(String value) {
			addCriterion("VENDOR_CONDITION_DESCRIPTION =", value, "vendorConditionDescription");
			return (Criteria) this;
		}

		public Criteria andVendorConditionDescriptionNotEqualTo(String value) {
			addCriterion("VENDOR_CONDITION_DESCRIPTION <>", value, "vendorConditionDescription");
			return (Criteria) this;
		}

		public Criteria andVendorConditionDescriptionGreaterThan(String value) {
			addCriterion("VENDOR_CONDITION_DESCRIPTION >", value, "vendorConditionDescription");
			return (Criteria) this;
		}

		public Criteria andVendorConditionDescriptionGreaterThanOrEqualTo(String value) {
			addCriterion("VENDOR_CONDITION_DESCRIPTION >=", value, "vendorConditionDescription");
			return (Criteria) this;
		}

		public Criteria andVendorConditionDescriptionLessThan(String value) {
			addCriterion("VENDOR_CONDITION_DESCRIPTION <", value, "vendorConditionDescription");
			return (Criteria) this;
		}

		public Criteria andVendorConditionDescriptionLessThanOrEqualTo(String value) {
			addCriterion("VENDOR_CONDITION_DESCRIPTION <=", value, "vendorConditionDescription");
			return (Criteria) this;
		}

		public Criteria andVendorConditionDescriptionLike(String value) {
			addCriterion("VENDOR_CONDITION_DESCRIPTION like", value, "vendorConditionDescription");
			return (Criteria) this;
		}

		public Criteria andVendorConditionDescriptionNotLike(String value) {
			addCriterion("VENDOR_CONDITION_DESCRIPTION not like", value, "vendorConditionDescription");
			return (Criteria) this;
		}

		public Criteria andVendorConditionDescriptionIn(List<String> values) {
			addCriterion("VENDOR_CONDITION_DESCRIPTION in", values, "vendorConditionDescription");
			return (Criteria) this;
		}

		public Criteria andVendorConditionDescriptionNotIn(List<String> values) {
			addCriterion("VENDOR_CONDITION_DESCRIPTION not in", values, "vendorConditionDescription");
			return (Criteria) this;
		}

		public Criteria andVendorConditionDescriptionBetween(String value1, String value2) {
			addCriterion("VENDOR_CONDITION_DESCRIPTION between", value1, value2, "vendorConditionDescription");
			return (Criteria) this;
		}

		public Criteria andVendorConditionDescriptionNotBetween(String value1, String value2) {
			addCriterion("VENDOR_CONDITION_DESCRIPTION not between", value1, value2, "vendorConditionDescription");
			return (Criteria) this;
		}

		public Criteria andVendeeConditionDescriptionIsNull() {
			addCriterion("VENDEE_CONDITION_DESCRIPTION is null");
			return (Criteria) this;
		}

		public Criteria andVendeeConditionDescriptionIsNotNull() {
			addCriterion("VENDEE_CONDITION_DESCRIPTION is not null");
			return (Criteria) this;
		}

		public Criteria andVendeeConditionDescriptionEqualTo(String value) {
			addCriterion("VENDEE_CONDITION_DESCRIPTION =", value, "vendeeConditionDescription");
			return (Criteria) this;
		}

		public Criteria andVendeeConditionDescriptionNotEqualTo(String value) {
			addCriterion("VENDEE_CONDITION_DESCRIPTION <>", value, "vendeeConditionDescription");
			return (Criteria) this;
		}

		public Criteria andVendeeConditionDescriptionGreaterThan(String value) {
			addCriterion("VENDEE_CONDITION_DESCRIPTION >", value, "vendeeConditionDescription");
			return (Criteria) this;
		}

		public Criteria andVendeeConditionDescriptionGreaterThanOrEqualTo(String value) {
			addCriterion("VENDEE_CONDITION_DESCRIPTION >=", value, "vendeeConditionDescription");
			return (Criteria) this;
		}

		public Criteria andVendeeConditionDescriptionLessThan(String value) {
			addCriterion("VENDEE_CONDITION_DESCRIPTION <", value, "vendeeConditionDescription");
			return (Criteria) this;
		}

		public Criteria andVendeeConditionDescriptionLessThanOrEqualTo(String value) {
			addCriterion("VENDEE_CONDITION_DESCRIPTION <=", value, "vendeeConditionDescription");
			return (Criteria) this;
		}

		public Criteria andVendeeConditionDescriptionLike(String value) {
			addCriterion("VENDEE_CONDITION_DESCRIPTION like", value, "vendeeConditionDescription");
			return (Criteria) this;
		}

		public Criteria andVendeeConditionDescriptionNotLike(String value) {
			addCriterion("VENDEE_CONDITION_DESCRIPTION not like", value, "vendeeConditionDescription");
			return (Criteria) this;
		}

		public Criteria andVendeeConditionDescriptionIn(List<String> values) {
			addCriterion("VENDEE_CONDITION_DESCRIPTION in", values, "vendeeConditionDescription");
			return (Criteria) this;
		}

		public Criteria andVendeeConditionDescriptionNotIn(List<String> values) {
			addCriterion("VENDEE_CONDITION_DESCRIPTION not in", values, "vendeeConditionDescription");
			return (Criteria) this;
		}

		public Criteria andVendeeConditionDescriptionBetween(String value1, String value2) {
			addCriterion("VENDEE_CONDITION_DESCRIPTION between", value1, value2, "vendeeConditionDescription");
			return (Criteria) this;
		}

		public Criteria andVendeeConditionDescriptionNotBetween(String value1, String value2) {
			addCriterion("VENDEE_CONDITION_DESCRIPTION not between", value1, value2, "vendeeConditionDescription");
			return (Criteria) this;
		}

		public Criteria andVendeeSuretyIdcardIsNull() {
			addCriterion("VENDEE_SURETY_IDCARD is null");
			return (Criteria) this;
		}

		public Criteria andVendeeSuretyIdcardIsNotNull() {
			addCriterion("VENDEE_SURETY_IDCARD is not null");
			return (Criteria) this;
		}

		public Criteria andVendeeSuretyIdcardEqualTo(String value) {
			addCriterion("VENDEE_SURETY_IDCARD =", value, "vendeeSuretyIdcard");
			return (Criteria) this;
		}

		public Criteria andVendeeSuretyIdcardNotEqualTo(String value) {
			addCriterion("VENDEE_SURETY_IDCARD <>", value, "vendeeSuretyIdcard");
			return (Criteria) this;
		}

		public Criteria andVendeeSuretyIdcardGreaterThan(String value) {
			addCriterion("VENDEE_SURETY_IDCARD >", value, "vendeeSuretyIdcard");
			return (Criteria) this;
		}

		public Criteria andVendeeSuretyIdcardGreaterThanOrEqualTo(String value) {
			addCriterion("VENDEE_SURETY_IDCARD >=", value, "vendeeSuretyIdcard");
			return (Criteria) this;
		}

		public Criteria andVendeeSuretyIdcardLessThan(String value) {
			addCriterion("VENDEE_SURETY_IDCARD <", value, "vendeeSuretyIdcard");
			return (Criteria) this;
		}

		public Criteria andVendeeSuretyIdcardLessThanOrEqualTo(String value) {
			addCriterion("VENDEE_SURETY_IDCARD <=", value, "vendeeSuretyIdcard");
			return (Criteria) this;
		}

		public Criteria andVendeeSuretyIdcardLike(String value) {
			addCriterion("VENDEE_SURETY_IDCARD like", value, "vendeeSuretyIdcard");
			return (Criteria) this;
		}

		public Criteria andVendeeSuretyIdcardNotLike(String value) {
			addCriterion("VENDEE_SURETY_IDCARD not like", value, "vendeeSuretyIdcard");
			return (Criteria) this;
		}

		public Criteria andVendeeSuretyIdcardIn(List<String> values) {
			addCriterion("VENDEE_SURETY_IDCARD in", values, "vendeeSuretyIdcard");
			return (Criteria) this;
		}

		public Criteria andVendeeSuretyIdcardNotIn(List<String> values) {
			addCriterion("VENDEE_SURETY_IDCARD not in", values, "vendeeSuretyIdcard");
			return (Criteria) this;
		}

		public Criteria andVendeeSuretyIdcardBetween(String value1, String value2) {
			addCriterion("VENDEE_SURETY_IDCARD between", value1, value2, "vendeeSuretyIdcard");
			return (Criteria) this;
		}

		public Criteria andVendeeSuretyIdcardNotBetween(String value1, String value2) {
			addCriterion("VENDEE_SURETY_IDCARD not between", value1, value2, "vendeeSuretyIdcard");
			return (Criteria) this;
		}

		public Criteria andTfTransactionTimePredictIsNull() {
			addCriterion("TF_TRANSACTION_TIME_PREDICT is null");
			return (Criteria) this;
		}

		public Criteria andTfTransactionTimePredictIsNotNull() {
			addCriterion("TF_TRANSACTION_TIME_PREDICT is not null");
			return (Criteria) this;
		}

		public Criteria andTfTransactionTimePredictEqualTo(Date value) {
			addCriterion("TF_TRANSACTION_TIME_PREDICT =", value, "tfTransactionTimePredict");
			return (Criteria) this;
		}

		public Criteria andTfTransactionTimePredictNotEqualTo(Date value) {
			addCriterion("TF_TRANSACTION_TIME_PREDICT <>", value, "tfTransactionTimePredict");
			return (Criteria) this;
		}

		public Criteria andTfTransactionTimePredictGreaterThan(Date value) {
			addCriterion("TF_TRANSACTION_TIME_PREDICT >", value, "tfTransactionTimePredict");
			return (Criteria) this;
		}

		public Criteria andTfTransactionTimePredictGreaterThanOrEqualTo(Date value) {
			addCriterion("TF_TRANSACTION_TIME_PREDICT >=", value, "tfTransactionTimePredict");
			return (Criteria) this;
		}

		public Criteria andTfTransactionTimePredictLessThan(Date value) {
			addCriterion("TF_TRANSACTION_TIME_PREDICT <", value, "tfTransactionTimePredict");
			return (Criteria) this;
		}

		public Criteria andTfTransactionTimePredictLessThanOrEqualTo(Date value) {
			addCriterion("TF_TRANSACTION_TIME_PREDICT <=", value, "tfTransactionTimePredict");
			return (Criteria) this;
		}

		public Criteria andTfTransactionTimePredictIn(List<Date> values) {
			addCriterion("TF_TRANSACTION_TIME_PREDICT in", values, "tfTransactionTimePredict");
			return (Criteria) this;
		}

		public Criteria andTfTransactionTimePredictNotIn(List<Date> values) {
			addCriterion("TF_TRANSACTION_TIME_PREDICT not in", values, "tfTransactionTimePredict");
			return (Criteria) this;
		}

		public Criteria andTfTransactionTimePredictBetween(Date value1, Date value2) {
			addCriterion("TF_TRANSACTION_TIME_PREDICT between", value1, value2, "tfTransactionTimePredict");
			return (Criteria) this;
		}

		public Criteria andTfTransactionTimePredictNotBetween(Date value1, Date value2) {
			addCriterion("TF_TRANSACTION_TIME_PREDICT not between", value1, value2, "tfTransactionTimePredict");
			return (Criteria) this;
		}

		public Criteria andTfTransactionTimeRealIsNull() {
			addCriterion("TF_TRANSACTION_TIME_REAL is null");
			return (Criteria) this;
		}

		public Criteria andTfTransactionTimeRealIsNotNull() {
			addCriterion("TF_TRANSACTION_TIME_REAL is not null");
			return (Criteria) this;
		}

		public Criteria andTfTransactionTimeRealEqualTo(Date value) {
			addCriterion("TF_TRANSACTION_TIME_REAL =", value, "tfTransactionTimeReal");
			return (Criteria) this;
		}

		public Criteria andTfTransactionTimeRealNotEqualTo(Date value) {
			addCriterion("TF_TRANSACTION_TIME_REAL <>", value, "tfTransactionTimeReal");
			return (Criteria) this;
		}

		public Criteria andTfTransactionTimeRealGreaterThan(Date value) {
			addCriterion("TF_TRANSACTION_TIME_REAL >", value, "tfTransactionTimeReal");
			return (Criteria) this;
		}

		public Criteria andTfTransactionTimeRealGreaterThanOrEqualTo(Date value) {
			addCriterion("TF_TRANSACTION_TIME_REAL >=", value, "tfTransactionTimeReal");
			return (Criteria) this;
		}

		public Criteria andTfTransactionTimeRealLessThan(Date value) {
			addCriterion("TF_TRANSACTION_TIME_REAL <", value, "tfTransactionTimeReal");
			return (Criteria) this;
		}

		public Criteria andTfTransactionTimeRealLessThanOrEqualTo(Date value) {
			addCriterion("TF_TRANSACTION_TIME_REAL <=", value, "tfTransactionTimeReal");
			return (Criteria) this;
		}

		public Criteria andTfTransactionTimeRealIn(List<Date> values) {
			addCriterion("TF_TRANSACTION_TIME_REAL in", values, "tfTransactionTimeReal");
			return (Criteria) this;
		}

		public Criteria andTfTransactionTimeRealNotIn(List<Date> values) {
			addCriterion("TF_TRANSACTION_TIME_REAL not in", values, "tfTransactionTimeReal");
			return (Criteria) this;
		}

		public Criteria andTfTransactionTimeRealBetween(Date value1, Date value2) {
			addCriterion("TF_TRANSACTION_TIME_REAL between", value1, value2, "tfTransactionTimeReal");
			return (Criteria) this;
		}

		public Criteria andTfTransactionTimeRealNotBetween(Date value1, Date value2) {
			addCriterion("TF_TRANSACTION_TIME_REAL not between", value1, value2, "tfTransactionTimeReal");
			return (Criteria) this;
		}

		public Criteria andSignOutClientIsNull() {
			addCriterion("SIGN_OUT_CLIENT is null");
			return (Criteria) this;
		}

		public Criteria andSignOutClientIsNotNull() {
			addCriterion("SIGN_OUT_CLIENT is not null");
			return (Criteria) this;
		}

		public Criteria andSignOutClientEqualTo(Byte value) {
			addCriterion("SIGN_OUT_CLIENT =", value, "signOutClient");
			return (Criteria) this;
		}

		public Criteria andSignOutClientNotEqualTo(Byte value) {
			addCriterion("SIGN_OUT_CLIENT <>", value, "signOutClient");
			return (Criteria) this;
		}

		public Criteria andSignOutClientGreaterThan(Byte value) {
			addCriterion("SIGN_OUT_CLIENT >", value, "signOutClient");
			return (Criteria) this;
		}

		public Criteria andSignOutClientGreaterThanOrEqualTo(Byte value) {
			addCriterion("SIGN_OUT_CLIENT >=", value, "signOutClient");
			return (Criteria) this;
		}

		public Criteria andSignOutClientLessThan(Byte value) {
			addCriterion("SIGN_OUT_CLIENT <", value, "signOutClient");
			return (Criteria) this;
		}

		public Criteria andSignOutClientLessThanOrEqualTo(Byte value) {
			addCriterion("SIGN_OUT_CLIENT <=", value, "signOutClient");
			return (Criteria) this;
		}

		public Criteria andSignOutClientIn(List<Byte> values) {
			addCriterion("SIGN_OUT_CLIENT in", values, "signOutClient");
			return (Criteria) this;
		}

		public Criteria andSignOutClientNotIn(List<Byte> values) {
			addCriterion("SIGN_OUT_CLIENT not in", values, "signOutClient");
			return (Criteria) this;
		}

		public Criteria andSignOutClientBetween(Byte value1, Byte value2) {
			addCriterion("SIGN_OUT_CLIENT between", value1, value2, "signOutClient");
			return (Criteria) this;
		}

		public Criteria andSignOutClientNotBetween(Byte value1, Byte value2) {
			addCriterion("SIGN_OUT_CLIENT not between", value1, value2, "signOutClient");
			return (Criteria) this;
		}

		public Criteria andDelStatusIsNull() {
			addCriterion("DEL_STATUS is null");
			return (Criteria) this;
		}

		public Criteria andDelStatusIsNotNull() {
			addCriterion("DEL_STATUS is not null");
			return (Criteria) this;
		}

		public Criteria andDelStatusEqualTo(Byte value) {
			addCriterion("DEL_STATUS =", value, "delStatus");
			return (Criteria) this;
		}

		public Criteria andDelStatusNotEqualTo(Byte value) {
			addCriterion("DEL_STATUS <>", value, "delStatus");
			return (Criteria) this;
		}

		public Criteria andDelStatusGreaterThan(Byte value) {
			addCriterion("DEL_STATUS >", value, "delStatus");
			return (Criteria) this;
		}

		public Criteria andDelStatusGreaterThanOrEqualTo(Byte value) {
			addCriterion("DEL_STATUS >=", value, "delStatus");
			return (Criteria) this;
		}

		public Criteria andDelStatusLessThan(Byte value) {
			addCriterion("DEL_STATUS <", value, "delStatus");
			return (Criteria) this;
		}

		public Criteria andDelStatusLessThanOrEqualTo(Byte value) {
			addCriterion("DEL_STATUS <=", value, "delStatus");
			return (Criteria) this;
		}

		public Criteria andDelStatusIn(List<Byte> values) {
			addCriterion("DEL_STATUS in", values, "delStatus");
			return (Criteria) this;
		}

		public Criteria andDelStatusNotIn(List<Byte> values) {
			addCriterion("DEL_STATUS not in", values, "delStatus");
			return (Criteria) this;
		}

		public Criteria andDelStatusBetween(Byte value1, Byte value2) {
			addCriterion("DEL_STATUS between", value1, value2, "delStatus");
			return (Criteria) this;
		}

		public Criteria andDelStatusNotBetween(Byte value1, Byte value2) {
			addCriterion("DEL_STATUS not between", value1, value2, "delStatus");
			return (Criteria) this;
		}

		public Criteria andFinanceModelIsNull() {
			addCriterion("FINANCE_MODEL is null");
			return (Criteria) this;
		}

		public Criteria andFinanceModelIsNotNull() {
			addCriterion("FINANCE_MODEL is not null");
			return (Criteria) this;
		}

		public Criteria andFinanceModelEqualTo(Byte value) {
			addCriterion("FINANCE_MODEL =", value, "financeModel");
			return (Criteria) this;
		}

		public Criteria andFinanceModelNotEqualTo(Byte value) {
			addCriterion("FINANCE_MODEL <>", value, "financeModel");
			return (Criteria) this;
		}

		public Criteria andFinanceModelGreaterThan(Byte value) {
			addCriterion("FINANCE_MODEL >", value, "financeModel");
			return (Criteria) this;
		}

		public Criteria andFinanceModelGreaterThanOrEqualTo(Byte value) {
			addCriterion("FINANCE_MODEL >=", value, "financeModel");
			return (Criteria) this;
		}

		public Criteria andFinanceModelLessThan(Byte value) {
			addCriterion("FINANCE_MODEL <", value, "financeModel");
			return (Criteria) this;
		}

		public Criteria andFinanceModelLessThanOrEqualTo(Byte value) {
			addCriterion("FINANCE_MODEL <=", value, "financeModel");
			return (Criteria) this;
		}

		public Criteria andFinanceModelIn(List<Byte> values) {
			addCriterion("FINANCE_MODEL in", values, "financeModel");
			return (Criteria) this;
		}

		public Criteria andFinanceModelNotIn(List<Byte> values) {
			addCriterion("FINANCE_MODEL not in", values, "financeModel");
			return (Criteria) this;
		}

		public Criteria andFinanceModelBetween(Byte value1, Byte value2) {
			addCriterion("FINANCE_MODEL between", value1, value2, "financeModel");
			return (Criteria) this;
		}

		public Criteria andFinanceModelNotBetween(Byte value1, Byte value2) {
			addCriterion("FINANCE_MODEL not between", value1, value2, "financeModel");
			return (Criteria) this;
		}

		public Criteria andDownPaymentPriceIsNull() {
			addCriterion("DOWN_PAYMENT_PRICE is null");
			return (Criteria) this;
		}

		public Criteria andDownPaymentPriceIsNotNull() {
			addCriterion("DOWN_PAYMENT_PRICE is not null");
			return (Criteria) this;
		}

		public Criteria andDownPaymentPriceEqualTo(BigDecimal value) {
			addCriterion("DOWN_PAYMENT_PRICE =", value, "downPaymentPrice");
			return (Criteria) this;
		}

		public Criteria andDownPaymentPriceNotEqualTo(BigDecimal value) {
			addCriterion("DOWN_PAYMENT_PRICE <>", value, "downPaymentPrice");
			return (Criteria) this;
		}

		public Criteria andDownPaymentPriceGreaterThan(BigDecimal value) {
			addCriterion("DOWN_PAYMENT_PRICE >", value, "downPaymentPrice");
			return (Criteria) this;
		}

		public Criteria andDownPaymentPriceGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("DOWN_PAYMENT_PRICE >=", value, "downPaymentPrice");
			return (Criteria) this;
		}

		public Criteria andDownPaymentPriceLessThan(BigDecimal value) {
			addCriterion("DOWN_PAYMENT_PRICE <", value, "downPaymentPrice");
			return (Criteria) this;
		}

		public Criteria andDownPaymentPriceLessThanOrEqualTo(BigDecimal value) {
			addCriterion("DOWN_PAYMENT_PRICE <=", value, "downPaymentPrice");
			return (Criteria) this;
		}

		public Criteria andDownPaymentPriceIn(List<BigDecimal> values) {
			addCriterion("DOWN_PAYMENT_PRICE in", values, "downPaymentPrice");
			return (Criteria) this;
		}

		public Criteria andDownPaymentPriceNotIn(List<BigDecimal> values) {
			addCriterion("DOWN_PAYMENT_PRICE not in", values, "downPaymentPrice");
			return (Criteria) this;
		}

		public Criteria andDownPaymentPriceBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("DOWN_PAYMENT_PRICE between", value1, value2, "downPaymentPrice");
			return (Criteria) this;
		}

		public Criteria andDownPaymentPriceNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("DOWN_PAYMENT_PRICE not between", value1, value2, "downPaymentPrice");
			return (Criteria) this;
		}

		public Criteria andDepositPriceIsNull() {
			addCriterion("DEPOSIT_PRICE is null");
			return (Criteria) this;
		}

		public Criteria andDepositPriceIsNotNull() {
			addCriterion("DEPOSIT_PRICE is not null");
			return (Criteria) this;
		}

		public Criteria andDepositPriceEqualTo(BigDecimal value) {
			addCriterion("DEPOSIT_PRICE =", value, "depositPrice");
			return (Criteria) this;
		}

		public Criteria andDepositPriceNotEqualTo(BigDecimal value) {
			addCriterion("DEPOSIT_PRICE <>", value, "depositPrice");
			return (Criteria) this;
		}

		public Criteria andDepositPriceGreaterThan(BigDecimal value) {
			addCriterion("DEPOSIT_PRICE >", value, "depositPrice");
			return (Criteria) this;
		}

		public Criteria andDepositPriceGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("DEPOSIT_PRICE >=", value, "depositPrice");
			return (Criteria) this;
		}

		public Criteria andDepositPriceLessThan(BigDecimal value) {
			addCriterion("DEPOSIT_PRICE <", value, "depositPrice");
			return (Criteria) this;
		}

		public Criteria andDepositPriceLessThanOrEqualTo(BigDecimal value) {
			addCriterion("DEPOSIT_PRICE <=", value, "depositPrice");
			return (Criteria) this;
		}

		public Criteria andDepositPriceIn(List<BigDecimal> values) {
			addCriterion("DEPOSIT_PRICE in", values, "depositPrice");
			return (Criteria) this;
		}

		public Criteria andDepositPriceNotIn(List<BigDecimal> values) {
			addCriterion("DEPOSIT_PRICE not in", values, "depositPrice");
			return (Criteria) this;
		}

		public Criteria andDepositPriceBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("DEPOSIT_PRICE between", value1, value2, "depositPrice");
			return (Criteria) this;
		}

		public Criteria andDepositPriceNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("DEPOSIT_PRICE not between", value1, value2, "depositPrice");
			return (Criteria) this;
		}

		public Criteria andFundSupervisionPriceIsNull() {
			addCriterion("FUND_SUPERVISION_PRICE is null");
			return (Criteria) this;
		}

		public Criteria andFundSupervisionPriceIsNotNull() {
			addCriterion("FUND_SUPERVISION_PRICE is not null");
			return (Criteria) this;
		}

		public Criteria andFundSupervisionPriceEqualTo(BigDecimal value) {
			addCriterion("FUND_SUPERVISION_PRICE =", value, "fundSupervisionPrice");
			return (Criteria) this;
		}

		public Criteria andFundSupervisionPriceNotEqualTo(BigDecimal value) {
			addCriterion("FUND_SUPERVISION_PRICE <>", value, "fundSupervisionPrice");
			return (Criteria) this;
		}

		public Criteria andFundSupervisionPriceGreaterThan(BigDecimal value) {
			addCriterion("FUND_SUPERVISION_PRICE >", value, "fundSupervisionPrice");
			return (Criteria) this;
		}

		public Criteria andFundSupervisionPriceGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("FUND_SUPERVISION_PRICE >=", value, "fundSupervisionPrice");
			return (Criteria) this;
		}

		public Criteria andFundSupervisionPriceLessThan(BigDecimal value) {
			addCriterion("FUND_SUPERVISION_PRICE <", value, "fundSupervisionPrice");
			return (Criteria) this;
		}

		public Criteria andFundSupervisionPriceLessThanOrEqualTo(BigDecimal value) {
			addCriterion("FUND_SUPERVISION_PRICE <=", value, "fundSupervisionPrice");
			return (Criteria) this;
		}

		public Criteria andFundSupervisionPriceIn(List<BigDecimal> values) {
			addCriterion("FUND_SUPERVISION_PRICE in", values, "fundSupervisionPrice");
			return (Criteria) this;
		}

		public Criteria andFundSupervisionPriceNotIn(List<BigDecimal> values) {
			addCriterion("FUND_SUPERVISION_PRICE not in", values, "fundSupervisionPrice");
			return (Criteria) this;
		}

		public Criteria andFundSupervisionPriceBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("FUND_SUPERVISION_PRICE between", value1, value2, "fundSupervisionPrice");
			return (Criteria) this;
		}

		public Criteria andFundSupervisionPriceNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("FUND_SUPERVISION_PRICE not between", value1, value2, "fundSupervisionPrice");
			return (Criteria) this;
		}

		public Criteria andRiskLevelIsNull() {
			addCriterion("RISK_LEVEL is null");
			return (Criteria) this;
		}

		public Criteria andRiskLevelIsNotNull() {
			addCriterion("RISK_LEVEL is not null");
			return (Criteria) this;
		}

		public Criteria andRiskLevelEqualTo(String value) {
			addCriterion("RISK_LEVEL =", value, "riskLevel");
			return (Criteria) this;
		}

		public Criteria andRiskLevelNotEqualTo(String value) {
			addCriterion("RISK_LEVEL <>", value, "riskLevel");
			return (Criteria) this;
		}

		public Criteria andRiskLevelGreaterThan(String value) {
			addCriterion("RISK_LEVEL >", value, "riskLevel");
			return (Criteria) this;
		}

		public Criteria andRiskLevelGreaterThanOrEqualTo(String value) {
			addCriterion("RISK_LEVEL >=", value, "riskLevel");
			return (Criteria) this;
		}

		public Criteria andRiskLevelLessThan(String value) {
			addCriterion("RISK_LEVEL <", value, "riskLevel");
			return (Criteria) this;
		}

		public Criteria andRiskLevelLessThanOrEqualTo(String value) {
			addCriterion("RISK_LEVEL <=", value, "riskLevel");
			return (Criteria) this;
		}

		public Criteria andRiskLevelLike(String value) {
			addCriterion("RISK_LEVEL like", value, "riskLevel");
			return (Criteria) this;
		}

		public Criteria andRiskLevelNotLike(String value) {
			addCriterion("RISK_LEVEL not like", value, "riskLevel");
			return (Criteria) this;
		}

		public Criteria andRiskLevelIn(List<String> values) {
			addCriterion("RISK_LEVEL in", values, "riskLevel");
			return (Criteria) this;
		}

		public Criteria andRiskLevelNotIn(List<String> values) {
			addCriterion("RISK_LEVEL not in", values, "riskLevel");
			return (Criteria) this;
		}

		public Criteria andRiskLevelBetween(String value1, String value2) {
			addCriterion("RISK_LEVEL between", value1, value2, "riskLevel");
			return (Criteria) this;
		}

		public Criteria andRiskLevelNotBetween(String value1, String value2) {
			addCriterion("RISK_LEVEL not between", value1, value2, "riskLevel");
			return (Criteria) this;
		}

		public Criteria andPaymentSourceIsNull() {
			addCriterion("PAYMENT_SOURCE is null");
			return (Criteria) this;
		}

		public Criteria andPaymentSourceIsNotNull() {
			addCriterion("PAYMENT_SOURCE is not null");
			return (Criteria) this;
		}

		public Criteria andPaymentSourceEqualTo(String value) {
			addCriterion("PAYMENT_SOURCE =", value, "paymentSource");
			return (Criteria) this;
		}

		public Criteria andPaymentSourceNotEqualTo(String value) {
			addCriterion("PAYMENT_SOURCE <>", value, "paymentSource");
			return (Criteria) this;
		}

		public Criteria andPaymentSourceGreaterThan(String value) {
			addCriterion("PAYMENT_SOURCE >", value, "paymentSource");
			return (Criteria) this;
		}

		public Criteria andPaymentSourceGreaterThanOrEqualTo(String value) {
			addCriterion("PAYMENT_SOURCE >=", value, "paymentSource");
			return (Criteria) this;
		}

		public Criteria andPaymentSourceLessThan(String value) {
			addCriterion("PAYMENT_SOURCE <", value, "paymentSource");
			return (Criteria) this;
		}

		public Criteria andPaymentSourceLessThanOrEqualTo(String value) {
			addCriterion("PAYMENT_SOURCE <=", value, "paymentSource");
			return (Criteria) this;
		}

		public Criteria andPaymentSourceLike(String value) {
			addCriterion("PAYMENT_SOURCE like", value, "paymentSource");
			return (Criteria) this;
		}

		public Criteria andPaymentSourceNotLike(String value) {
			addCriterion("PAYMENT_SOURCE not like", value, "paymentSource");
			return (Criteria) this;
		}

		public Criteria andPaymentSourceIn(List<String> values) {
			addCriterion("PAYMENT_SOURCE in", values, "paymentSource");
			return (Criteria) this;
		}

		public Criteria andPaymentSourceNotIn(List<String> values) {
			addCriterion("PAYMENT_SOURCE not in", values, "paymentSource");
			return (Criteria) this;
		}

		public Criteria andPaymentSourceBetween(String value1, String value2) {
			addCriterion("PAYMENT_SOURCE between", value1, value2, "paymentSource");
			return (Criteria) this;
		}

		public Criteria andPaymentSourceNotBetween(String value1, String value2) {
			addCriterion("PAYMENT_SOURCE not between", value1, value2, "paymentSource");
			return (Criteria) this;
		}

		public Criteria andEntrustedNameIsNull() {
			addCriterion("ENTRUSTED_NAME is null");
			return (Criteria) this;
		}

		public Criteria andEntrustedNameIsNotNull() {
			addCriterion("ENTRUSTED_NAME is not null");
			return (Criteria) this;
		}

		public Criteria andEntrustedNameEqualTo(String value) {
			addCriterion("ENTRUSTED_NAME =", value, "entrustedName");
			return (Criteria) this;
		}

		public Criteria andEntrustedNameNotEqualTo(String value) {
			addCriterion("ENTRUSTED_NAME <>", value, "entrustedName");
			return (Criteria) this;
		}

		public Criteria andEntrustedNameGreaterThan(String value) {
			addCriterion("ENTRUSTED_NAME >", value, "entrustedName");
			return (Criteria) this;
		}

		public Criteria andEntrustedNameGreaterThanOrEqualTo(String value) {
			addCriterion("ENTRUSTED_NAME >=", value, "entrustedName");
			return (Criteria) this;
		}

		public Criteria andEntrustedNameLessThan(String value) {
			addCriterion("ENTRUSTED_NAME <", value, "entrustedName");
			return (Criteria) this;
		}

		public Criteria andEntrustedNameLessThanOrEqualTo(String value) {
			addCriterion("ENTRUSTED_NAME <=", value, "entrustedName");
			return (Criteria) this;
		}

		public Criteria andEntrustedNameLike(String value) {
			addCriterion("ENTRUSTED_NAME like", value, "entrustedName");
			return (Criteria) this;
		}

		public Criteria andEntrustedNameNotLike(String value) {
			addCriterion("ENTRUSTED_NAME not like", value, "entrustedName");
			return (Criteria) this;
		}

		public Criteria andEntrustedNameIn(List<String> values) {
			addCriterion("ENTRUSTED_NAME in", values, "entrustedName");
			return (Criteria) this;
		}

		public Criteria andEntrustedNameNotIn(List<String> values) {
			addCriterion("ENTRUSTED_NAME not in", values, "entrustedName");
			return (Criteria) this;
		}

		public Criteria andEntrustedNameBetween(String value1, String value2) {
			addCriterion("ENTRUSTED_NAME between", value1, value2, "entrustedName");
			return (Criteria) this;
		}

		public Criteria andEntrustedNameNotBetween(String value1, String value2) {
			addCriterion("ENTRUSTED_NAME not between", value1, value2, "entrustedName");
			return (Criteria) this;
		}

		public Criteria andEntrustedIccardIsNull() {
			addCriterion("ENTRUSTED_ICCARD is null");
			return (Criteria) this;
		}

		public Criteria andEntrustedIccardIsNotNull() {
			addCriterion("ENTRUSTED_ICCARD is not null");
			return (Criteria) this;
		}

		public Criteria andEntrustedIccardEqualTo(String value) {
			addCriterion("ENTRUSTED_ICCARD =", value, "entrustedIccard");
			return (Criteria) this;
		}

		public Criteria andEntrustedIccardNotEqualTo(String value) {
			addCriterion("ENTRUSTED_ICCARD <>", value, "entrustedIccard");
			return (Criteria) this;
		}

		public Criteria andEntrustedIccardGreaterThan(String value) {
			addCriterion("ENTRUSTED_ICCARD >", value, "entrustedIccard");
			return (Criteria) this;
		}

		public Criteria andEntrustedIccardGreaterThanOrEqualTo(String value) {
			addCriterion("ENTRUSTED_ICCARD >=", value, "entrustedIccard");
			return (Criteria) this;
		}

		public Criteria andEntrustedIccardLessThan(String value) {
			addCriterion("ENTRUSTED_ICCARD <", value, "entrustedIccard");
			return (Criteria) this;
		}

		public Criteria andEntrustedIccardLessThanOrEqualTo(String value) {
			addCriterion("ENTRUSTED_ICCARD <=", value, "entrustedIccard");
			return (Criteria) this;
		}

		public Criteria andEntrustedIccardLike(String value) {
			addCriterion("ENTRUSTED_ICCARD like", value, "entrustedIccard");
			return (Criteria) this;
		}

		public Criteria andEntrustedIccardNotLike(String value) {
			addCriterion("ENTRUSTED_ICCARD not like", value, "entrustedIccard");
			return (Criteria) this;
		}

		public Criteria andEntrustedIccardIn(List<String> values) {
			addCriterion("ENTRUSTED_ICCARD in", values, "entrustedIccard");
			return (Criteria) this;
		}

		public Criteria andEntrustedIccardNotIn(List<String> values) {
			addCriterion("ENTRUSTED_ICCARD not in", values, "entrustedIccard");
			return (Criteria) this;
		}

		public Criteria andEntrustedIccardBetween(String value1, String value2) {
			addCriterion("ENTRUSTED_ICCARD between", value1, value2, "entrustedIccard");
			return (Criteria) this;
		}

		public Criteria andEntrustedIccardNotBetween(String value1, String value2) {
			addCriterion("ENTRUSTED_ICCARD not between", value1, value2, "entrustedIccard");
			return (Criteria) this;
		}

		public Criteria andRepaymentBankNameIsNull() {
			addCriterion("REPAYMENT_BANK_NAME is null");
			return (Criteria) this;
		}

		public Criteria andRepaymentBankNameIsNotNull() {
			addCriterion("REPAYMENT_BANK_NAME is not null");
			return (Criteria) this;
		}

		public Criteria andRepaymentBankNameEqualTo(String value) {
			addCriterion("REPAYMENT_BANK_NAME =", value, "repaymentBankName");
			return (Criteria) this;
		}

		public Criteria andRepaymentBankNameNotEqualTo(String value) {
			addCriterion("REPAYMENT_BANK_NAME <>", value, "repaymentBankName");
			return (Criteria) this;
		}

		public Criteria andRepaymentBankNameGreaterThan(String value) {
			addCriterion("REPAYMENT_BANK_NAME >", value, "repaymentBankName");
			return (Criteria) this;
		}

		public Criteria andRepaymentBankNameGreaterThanOrEqualTo(String value) {
			addCriterion("REPAYMENT_BANK_NAME >=", value, "repaymentBankName");
			return (Criteria) this;
		}

		public Criteria andRepaymentBankNameLessThan(String value) {
			addCriterion("REPAYMENT_BANK_NAME <", value, "repaymentBankName");
			return (Criteria) this;
		}

		public Criteria andRepaymentBankNameLessThanOrEqualTo(String value) {
			addCriterion("REPAYMENT_BANK_NAME <=", value, "repaymentBankName");
			return (Criteria) this;
		}

		public Criteria andRepaymentBankNameLike(String value) {
			addCriterion("REPAYMENT_BANK_NAME like", value, "repaymentBankName");
			return (Criteria) this;
		}

		public Criteria andRepaymentBankNameNotLike(String value) {
			addCriterion("REPAYMENT_BANK_NAME not like", value, "repaymentBankName");
			return (Criteria) this;
		}

		public Criteria andRepaymentBankNameIn(List<String> values) {
			addCriterion("REPAYMENT_BANK_NAME in", values, "repaymentBankName");
			return (Criteria) this;
		}

		public Criteria andRepaymentBankNameNotIn(List<String> values) {
			addCriterion("REPAYMENT_BANK_NAME not in", values, "repaymentBankName");
			return (Criteria) this;
		}

		public Criteria andRepaymentBankNameBetween(String value1, String value2) {
			addCriterion("REPAYMENT_BANK_NAME between", value1, value2, "repaymentBankName");
			return (Criteria) this;
		}

		public Criteria andRepaymentBankNameNotBetween(String value1, String value2) {
			addCriterion("REPAYMENT_BANK_NAME not between", value1, value2, "repaymentBankName");
			return (Criteria) this;
		}

		public Criteria andHasPaidYearsIsNull() {
			addCriterion("HAS_PAID_YEARS is null");
			return (Criteria) this;
		}

		public Criteria andHasPaidYearsIsNotNull() {
			addCriterion("HAS_PAID_YEARS is not null");
			return (Criteria) this;
		}

		public Criteria andHasPaidYearsEqualTo(Integer value) {
			addCriterion("HAS_PAID_YEARS =", value, "hasPaidYears");
			return (Criteria) this;
		}

		public Criteria andHasPaidYearsNotEqualTo(Integer value) {
			addCriterion("HAS_PAID_YEARS <>", value, "hasPaidYears");
			return (Criteria) this;
		}

		public Criteria andHasPaidYearsGreaterThan(Integer value) {
			addCriterion("HAS_PAID_YEARS >", value, "hasPaidYears");
			return (Criteria) this;
		}

		public Criteria andHasPaidYearsGreaterThanOrEqualTo(Integer value) {
			addCriterion("HAS_PAID_YEARS >=", value, "hasPaidYears");
			return (Criteria) this;
		}

		public Criteria andHasPaidYearsLessThan(Integer value) {
			addCriterion("HAS_PAID_YEARS <", value, "hasPaidYears");
			return (Criteria) this;
		}

		public Criteria andHasPaidYearsLessThanOrEqualTo(Integer value) {
			addCriterion("HAS_PAID_YEARS <=", value, "hasPaidYears");
			return (Criteria) this;
		}

		public Criteria andHasPaidYearsIn(List<Integer> values) {
			addCriterion("HAS_PAID_YEARS in", values, "hasPaidYears");
			return (Criteria) this;
		}

		public Criteria andHasPaidYearsNotIn(List<Integer> values) {
			addCriterion("HAS_PAID_YEARS not in", values, "hasPaidYears");
			return (Criteria) this;
		}

		public Criteria andHasPaidYearsBetween(Integer value1, Integer value2) {
			addCriterion("HAS_PAID_YEARS between", value1, value2, "hasPaidYears");
			return (Criteria) this;
		}

		public Criteria andHasPaidYearsNotBetween(Integer value1, Integer value2) {
			addCriterion("HAS_PAID_YEARS not between", value1, value2, "hasPaidYears");
			return (Criteria) this;
		}

		public Criteria andIsAppointmentIsNull() {
			addCriterion("IS_APPOINTMENT is null");
			return (Criteria) this;
		}

		public Criteria andIsAppointmentIsNotNull() {
			addCriterion("IS_APPOINTMENT is not null");
			return (Criteria) this;
		}

		public Criteria andIsAppointmentEqualTo(Boolean value) {
			addCriterion("IS_APPOINTMENT =", value, "isAppointment");
			return (Criteria) this;
		}

		public Criteria andIsAppointmentNotEqualTo(Boolean value) {
			addCriterion("IS_APPOINTMENT <>", value, "isAppointment");
			return (Criteria) this;
		}

		public Criteria andIsAppointmentGreaterThan(Boolean value) {
			addCriterion("IS_APPOINTMENT >", value, "isAppointment");
			return (Criteria) this;
		}

		public Criteria andIsAppointmentGreaterThanOrEqualTo(Boolean value) {
			addCriterion("IS_APPOINTMENT >=", value, "isAppointment");
			return (Criteria) this;
		}

		public Criteria andIsAppointmentLessThan(Boolean value) {
			addCriterion("IS_APPOINTMENT <", value, "isAppointment");
			return (Criteria) this;
		}

		public Criteria andIsAppointmentLessThanOrEqualTo(Boolean value) {
			addCriterion("IS_APPOINTMENT <=", value, "isAppointment");
			return (Criteria) this;
		}

		public Criteria andIsAppointmentIn(List<Boolean> values) {
			addCriterion("IS_APPOINTMENT in", values, "isAppointment");
			return (Criteria) this;
		}

		public Criteria andIsAppointmentNotIn(List<Boolean> values) {
			addCriterion("IS_APPOINTMENT not in", values, "isAppointment");
			return (Criteria) this;
		}

		public Criteria andIsAppointmentBetween(Boolean value1, Boolean value2) {
			addCriterion("IS_APPOINTMENT between", value1, value2, "isAppointment");
			return (Criteria) this;
		}

		public Criteria andIsAppointmentNotBetween(Boolean value1, Boolean value2) {
			addCriterion("IS_APPOINTMENT not between", value1, value2, "isAppointment");
			return (Criteria) this;
		}

		public Criteria andIsRepaymentAnytimeIsNull() {
			addCriterion("IS_REPAYMENT_ANYTIME is null");
			return (Criteria) this;
		}

		public Criteria andIsRepaymentAnytimeIsNotNull() {
			addCriterion("IS_REPAYMENT_ANYTIME is not null");
			return (Criteria) this;
		}

		public Criteria andIsRepaymentAnytimeEqualTo(Boolean value) {
			addCriterion("IS_REPAYMENT_ANYTIME =", value, "isRepaymentAnytime");
			return (Criteria) this;
		}

		public Criteria andIsRepaymentAnytimeNotEqualTo(Boolean value) {
			addCriterion("IS_REPAYMENT_ANYTIME <>", value, "isRepaymentAnytime");
			return (Criteria) this;
		}

		public Criteria andIsRepaymentAnytimeGreaterThan(Boolean value) {
			addCriterion("IS_REPAYMENT_ANYTIME >", value, "isRepaymentAnytime");
			return (Criteria) this;
		}

		public Criteria andIsRepaymentAnytimeGreaterThanOrEqualTo(Boolean value) {
			addCriterion("IS_REPAYMENT_ANYTIME >=", value, "isRepaymentAnytime");
			return (Criteria) this;
		}

		public Criteria andIsRepaymentAnytimeLessThan(Boolean value) {
			addCriterion("IS_REPAYMENT_ANYTIME <", value, "isRepaymentAnytime");
			return (Criteria) this;
		}

		public Criteria andIsRepaymentAnytimeLessThanOrEqualTo(Boolean value) {
			addCriterion("IS_REPAYMENT_ANYTIME <=", value, "isRepaymentAnytime");
			return (Criteria) this;
		}

		public Criteria andIsRepaymentAnytimeIn(List<Boolean> values) {
			addCriterion("IS_REPAYMENT_ANYTIME in", values, "isRepaymentAnytime");
			return (Criteria) this;
		}

		public Criteria andIsRepaymentAnytimeNotIn(List<Boolean> values) {
			addCriterion("IS_REPAYMENT_ANYTIME not in", values, "isRepaymentAnytime");
			return (Criteria) this;
		}

		public Criteria andIsRepaymentAnytimeBetween(Boolean value1, Boolean value2) {
			addCriterion("IS_REPAYMENT_ANYTIME between", value1, value2, "isRepaymentAnytime");
			return (Criteria) this;
		}

		public Criteria andIsRepaymentAnytimeNotBetween(Boolean value1, Boolean value2) {
			addCriterion("IS_REPAYMENT_ANYTIME not between", value1, value2, "isRepaymentAnytime");
			return (Criteria) this;
		}

		public Criteria andAcceptChannelRepaymentTimeIsNull() {
			addCriterion("ACCEPT_CHANNEL_REPAYMENT_TIME is null");
			return (Criteria) this;
		}

		public Criteria andAcceptChannelRepaymentTimeIsNotNull() {
			addCriterion("ACCEPT_CHANNEL_REPAYMENT_TIME is not null");
			return (Criteria) this;
		}

		public Criteria andAcceptChannelRepaymentTimeEqualTo(Boolean value) {
			addCriterion("ACCEPT_CHANNEL_REPAYMENT_TIME =", value, "acceptChannelRepaymentTime");
			return (Criteria) this;
		}

		public Criteria andAcceptChannelRepaymentTimeNotEqualTo(Boolean value) {
			addCriterion("ACCEPT_CHANNEL_REPAYMENT_TIME <>", value, "acceptChannelRepaymentTime");
			return (Criteria) this;
		}

		public Criteria andAcceptChannelRepaymentTimeGreaterThan(Boolean value) {
			addCriterion("ACCEPT_CHANNEL_REPAYMENT_TIME >", value, "acceptChannelRepaymentTime");
			return (Criteria) this;
		}

		public Criteria andAcceptChannelRepaymentTimeGreaterThanOrEqualTo(Boolean value) {
			addCriterion("ACCEPT_CHANNEL_REPAYMENT_TIME >=", value, "acceptChannelRepaymentTime");
			return (Criteria) this;
		}

		public Criteria andAcceptChannelRepaymentTimeLessThan(Boolean value) {
			addCriterion("ACCEPT_CHANNEL_REPAYMENT_TIME <", value, "acceptChannelRepaymentTime");
			return (Criteria) this;
		}

		public Criteria andAcceptChannelRepaymentTimeLessThanOrEqualTo(Boolean value) {
			addCriterion("ACCEPT_CHANNEL_REPAYMENT_TIME <=", value, "acceptChannelRepaymentTime");
			return (Criteria) this;
		}

		public Criteria andAcceptChannelRepaymentTimeIn(List<Boolean> values) {
			addCriterion("ACCEPT_CHANNEL_REPAYMENT_TIME in", values, "acceptChannelRepaymentTime");
			return (Criteria) this;
		}

		public Criteria andAcceptChannelRepaymentTimeNotIn(List<Boolean> values) {
			addCriterion("ACCEPT_CHANNEL_REPAYMENT_TIME not in", values, "acceptChannelRepaymentTime");
			return (Criteria) this;
		}

		public Criteria andAcceptChannelRepaymentTimeBetween(Boolean value1, Boolean value2) {
			addCriterion("ACCEPT_CHANNEL_REPAYMENT_TIME between", value1, value2, "acceptChannelRepaymentTime");
			return (Criteria) this;
		}

		public Criteria andAcceptChannelRepaymentTimeNotBetween(Boolean value1, Boolean value2) {
			addCriterion("ACCEPT_CHANNEL_REPAYMENT_TIME not between", value1, value2, "acceptChannelRepaymentTime");
			return (Criteria) this;
		}

		public Criteria andIfTransferParkingIsNull() {
			addCriterion("IF_TRANSFER_PARKING is null");
			return (Criteria) this;
		}

		public Criteria andIfTransferParkingIsNotNull() {
			addCriterion("IF_TRANSFER_PARKING is not null");
			return (Criteria) this;
		}

		public Criteria andIfTransferParkingEqualTo(Boolean value) {
			addCriterion("IF_TRANSFER_PARKING =", value, "ifTransferParking");
			return (Criteria) this;
		}

		public Criteria andIfTransferParkingNotEqualTo(Boolean value) {
			addCriterion("IF_TRANSFER_PARKING <>", value, "ifTransferParking");
			return (Criteria) this;
		}

		public Criteria andIfTransferParkingGreaterThan(Boolean value) {
			addCriterion("IF_TRANSFER_PARKING >", value, "ifTransferParking");
			return (Criteria) this;
		}

		public Criteria andIfTransferParkingGreaterThanOrEqualTo(Boolean value) {
			addCriterion("IF_TRANSFER_PARKING >=", value, "ifTransferParking");
			return (Criteria) this;
		}

		public Criteria andIfTransferParkingLessThan(Boolean value) {
			addCriterion("IF_TRANSFER_PARKING <", value, "ifTransferParking");
			return (Criteria) this;
		}

		public Criteria andIfTransferParkingLessThanOrEqualTo(Boolean value) {
			addCriterion("IF_TRANSFER_PARKING <=", value, "ifTransferParking");
			return (Criteria) this;
		}

		public Criteria andIfTransferParkingIn(List<Boolean> values) {
			addCriterion("IF_TRANSFER_PARKING in", values, "ifTransferParking");
			return (Criteria) this;
		}

		public Criteria andIfTransferParkingNotIn(List<Boolean> values) {
			addCriterion("IF_TRANSFER_PARKING not in", values, "ifTransferParking");
			return (Criteria) this;
		}

		public Criteria andIfTransferParkingBetween(Boolean value1, Boolean value2) {
			addCriterion("IF_TRANSFER_PARKING between", value1, value2, "ifTransferParking");
			return (Criteria) this;
		}

		public Criteria andIfTransferParkingNotBetween(Boolean value1, Boolean value2) {
			addCriterion("IF_TRANSFER_PARKING not between", value1, value2, "ifTransferParking");
			return (Criteria) this;
		}

		public Criteria andIfReplaceCredentialsIsNull() {
			addCriterion("IF_REPLACE_CREDENTIALS is null");
			return (Criteria) this;
		}

		public Criteria andIfReplaceCredentialsIsNotNull() {
			addCriterion("IF_REPLACE_CREDENTIALS is not null");
			return (Criteria) this;
		}

		public Criteria andIfReplaceCredentialsEqualTo(Boolean value) {
			addCriterion("IF_REPLACE_CREDENTIALS =", value, "ifReplaceCredentials");
			return (Criteria) this;
		}

		public Criteria andIfReplaceCredentialsNotEqualTo(Boolean value) {
			addCriterion("IF_REPLACE_CREDENTIALS <>", value, "ifReplaceCredentials");
			return (Criteria) this;
		}

		public Criteria andIfReplaceCredentialsGreaterThan(Boolean value) {
			addCriterion("IF_REPLACE_CREDENTIALS >", value, "ifReplaceCredentials");
			return (Criteria) this;
		}

		public Criteria andIfReplaceCredentialsGreaterThanOrEqualTo(Boolean value) {
			addCriterion("IF_REPLACE_CREDENTIALS >=", value, "ifReplaceCredentials");
			return (Criteria) this;
		}

		public Criteria andIfReplaceCredentialsLessThan(Boolean value) {
			addCriterion("IF_REPLACE_CREDENTIALS <", value, "ifReplaceCredentials");
			return (Criteria) this;
		}

		public Criteria andIfReplaceCredentialsLessThanOrEqualTo(Boolean value) {
			addCriterion("IF_REPLACE_CREDENTIALS <=", value, "ifReplaceCredentials");
			return (Criteria) this;
		}

		public Criteria andIfReplaceCredentialsIn(List<Boolean> values) {
			addCriterion("IF_REPLACE_CREDENTIALS in", values, "ifReplaceCredentials");
			return (Criteria) this;
		}

		public Criteria andIfReplaceCredentialsNotIn(List<Boolean> values) {
			addCriterion("IF_REPLACE_CREDENTIALS not in", values, "ifReplaceCredentials");
			return (Criteria) this;
		}

		public Criteria andIfReplaceCredentialsBetween(Boolean value1, Boolean value2) {
			addCriterion("IF_REPLACE_CREDENTIALS between", value1, value2, "ifReplaceCredentials");
			return (Criteria) this;
		}

		public Criteria andIfReplaceCredentialsNotBetween(Boolean value1, Boolean value2) {
			addCriterion("IF_REPLACE_CREDENTIALS not between", value1, value2, "ifReplaceCredentials");
			return (Criteria) this;
		}

		public Criteria andRepaymentPriceIsNull() {
			addCriterion("REPAYMENT_PRICE is null");
			return (Criteria) this;
		}

		public Criteria andRepaymentPriceIsNotNull() {
			addCriterion("REPAYMENT_PRICE is not null");
			return (Criteria) this;
		}

		public Criteria andRepaymentPriceEqualTo(Integer value) {
			addCriterion("REPAYMENT_PRICE =", value, "repaymentPrice");
			return (Criteria) this;
		}

		public Criteria andRepaymentPriceNotEqualTo(Integer value) {
			addCriterion("REPAYMENT_PRICE <>", value, "repaymentPrice");
			return (Criteria) this;
		}

		public Criteria andRepaymentPriceGreaterThan(Integer value) {
			addCriterion("REPAYMENT_PRICE >", value, "repaymentPrice");
			return (Criteria) this;
		}

		public Criteria andRepaymentPriceGreaterThanOrEqualTo(Integer value) {
			addCriterion("REPAYMENT_PRICE >=", value, "repaymentPrice");
			return (Criteria) this;
		}

		public Criteria andRepaymentPriceLessThan(Integer value) {
			addCriterion("REPAYMENT_PRICE <", value, "repaymentPrice");
			return (Criteria) this;
		}

		public Criteria andRepaymentPriceLessThanOrEqualTo(Integer value) {
			addCriterion("REPAYMENT_PRICE <=", value, "repaymentPrice");
			return (Criteria) this;
		}

		public Criteria andRepaymentPriceIn(List<Integer> values) {
			addCriterion("REPAYMENT_PRICE in", values, "repaymentPrice");
			return (Criteria) this;
		}

		public Criteria andRepaymentPriceNotIn(List<Integer> values) {
			addCriterion("REPAYMENT_PRICE not in", values, "repaymentPrice");
			return (Criteria) this;
		}

		public Criteria andRepaymentPriceBetween(Integer value1, Integer value2) {
			addCriterion("REPAYMENT_PRICE between", value1, value2, "repaymentPrice");
			return (Criteria) this;
		}

		public Criteria andRepaymentPriceNotBetween(Integer value1, Integer value2) {
			addCriterion("REPAYMENT_PRICE not between", value1, value2, "repaymentPrice");
			return (Criteria) this;
		}

		public Criteria andRepaymentTimeIsNull() {
			addCriterion("REPAYMENT_TIME is null");
			return (Criteria) this;
		}

		public Criteria andRepaymentTimeIsNotNull() {
			addCriterion("REPAYMENT_TIME is not null");
			return (Criteria) this;
		}

		public Criteria andRepaymentTimeEqualTo(Date value) {
			addCriterion("REPAYMENT_TIME =", value, "repaymentTime");
			return (Criteria) this;
		}

		public Criteria andRepaymentTimeNotEqualTo(Date value) {
			addCriterion("REPAYMENT_TIME <>", value, "repaymentTime");
			return (Criteria) this;
		}

		public Criteria andRepaymentTimeGreaterThan(Date value) {
			addCriterion("REPAYMENT_TIME >", value, "repaymentTime");
			return (Criteria) this;
		}

		public Criteria andRepaymentTimeGreaterThanOrEqualTo(Date value) {
			addCriterion("REPAYMENT_TIME >=", value, "repaymentTime");
			return (Criteria) this;
		}

		public Criteria andRepaymentTimeLessThan(Date value) {
			addCriterion("REPAYMENT_TIME <", value, "repaymentTime");
			return (Criteria) this;
		}

		public Criteria andRepaymentTimeLessThanOrEqualTo(Date value) {
			addCriterion("REPAYMENT_TIME <=", value, "repaymentTime");
			return (Criteria) this;
		}

		public Criteria andRepaymentTimeIn(List<Date> values) {
			addCriterion("REPAYMENT_TIME in", values, "repaymentTime");
			return (Criteria) this;
		}

		public Criteria andRepaymentTimeNotIn(List<Date> values) {
			addCriterion("REPAYMENT_TIME not in", values, "repaymentTime");
			return (Criteria) this;
		}

		public Criteria andRepaymentTimeBetween(Date value1, Date value2) {
			addCriterion("REPAYMENT_TIME between", value1, value2, "repaymentTime");
			return (Criteria) this;
		}

		public Criteria andRepaymentTimeNotBetween(Date value1, Date value2) {
			addCriterion("REPAYMENT_TIME not between", value1, value2, "repaymentTime");
			return (Criteria) this;
		}

		public Criteria andRepaymentChannelIsNull() {
			addCriterion("REPAYMENT_CHANNEL is null");
			return (Criteria) this;
		}

		public Criteria andRepaymentChannelIsNotNull() {
			addCriterion("REPAYMENT_CHANNEL is not null");
			return (Criteria) this;
		}

		public Criteria andRepaymentChannelEqualTo(String value) {
			addCriterion("REPAYMENT_CHANNEL =", value, "repaymentChannel");
			return (Criteria) this;
		}

		public Criteria andRepaymentChannelNotEqualTo(String value) {
			addCriterion("REPAYMENT_CHANNEL <>", value, "repaymentChannel");
			return (Criteria) this;
		}

		public Criteria andRepaymentChannelGreaterThan(String value) {
			addCriterion("REPAYMENT_CHANNEL >", value, "repaymentChannel");
			return (Criteria) this;
		}

		public Criteria andRepaymentChannelGreaterThanOrEqualTo(String value) {
			addCriterion("REPAYMENT_CHANNEL >=", value, "repaymentChannel");
			return (Criteria) this;
		}

		public Criteria andRepaymentChannelLessThan(String value) {
			addCriterion("REPAYMENT_CHANNEL <", value, "repaymentChannel");
			return (Criteria) this;
		}

		public Criteria andRepaymentChannelLessThanOrEqualTo(String value) {
			addCriterion("REPAYMENT_CHANNEL <=", value, "repaymentChannel");
			return (Criteria) this;
		}

		public Criteria andRepaymentChannelLike(String value) {
			addCriterion("REPAYMENT_CHANNEL like", value, "repaymentChannel");
			return (Criteria) this;
		}

		public Criteria andRepaymentChannelNotLike(String value) {
			addCriterion("REPAYMENT_CHANNEL not like", value, "repaymentChannel");
			return (Criteria) this;
		}

		public Criteria andRepaymentChannelIn(List<String> values) {
			addCriterion("REPAYMENT_CHANNEL in", values, "repaymentChannel");
			return (Criteria) this;
		}

		public Criteria andRepaymentChannelNotIn(List<String> values) {
			addCriterion("REPAYMENT_CHANNEL not in", values, "repaymentChannel");
			return (Criteria) this;
		}

		public Criteria andRepaymentChannelBetween(String value1, String value2) {
			addCriterion("REPAYMENT_CHANNEL between", value1, value2, "repaymentChannel");
			return (Criteria) this;
		}

		public Criteria andRepaymentChannelNotBetween(String value1, String value2) {
			addCriterion("REPAYMENT_CHANNEL not between", value1, value2, "repaymentChannel");
			return (Criteria) this;
		}

		public Criteria andRepaymentDescIsNull() {
			addCriterion("REPAYMENT_DESC is null");
			return (Criteria) this;
		}

		public Criteria andRepaymentDescIsNotNull() {
			addCriterion("REPAYMENT_DESC is not null");
			return (Criteria) this;
		}

		public Criteria andRepaymentDescEqualTo(String value) {
			addCriterion("REPAYMENT_DESC =", value, "repaymentDesc");
			return (Criteria) this;
		}

		public Criteria andRepaymentDescNotEqualTo(String value) {
			addCriterion("REPAYMENT_DESC <>", value, "repaymentDesc");
			return (Criteria) this;
		}

		public Criteria andRepaymentDescGreaterThan(String value) {
			addCriterion("REPAYMENT_DESC >", value, "repaymentDesc");
			return (Criteria) this;
		}

		public Criteria andRepaymentDescGreaterThanOrEqualTo(String value) {
			addCriterion("REPAYMENT_DESC >=", value, "repaymentDesc");
			return (Criteria) this;
		}

		public Criteria andRepaymentDescLessThan(String value) {
			addCriterion("REPAYMENT_DESC <", value, "repaymentDesc");
			return (Criteria) this;
		}

		public Criteria andRepaymentDescLessThanOrEqualTo(String value) {
			addCriterion("REPAYMENT_DESC <=", value, "repaymentDesc");
			return (Criteria) this;
		}

		public Criteria andRepaymentDescLike(String value) {
			addCriterion("REPAYMENT_DESC like", value, "repaymentDesc");
			return (Criteria) this;
		}

		public Criteria andRepaymentDescNotLike(String value) {
			addCriterion("REPAYMENT_DESC not like", value, "repaymentDesc");
			return (Criteria) this;
		}

		public Criteria andRepaymentDescIn(List<String> values) {
			addCriterion("REPAYMENT_DESC in", values, "repaymentDesc");
			return (Criteria) this;
		}

		public Criteria andRepaymentDescNotIn(List<String> values) {
			addCriterion("REPAYMENT_DESC not in", values, "repaymentDesc");
			return (Criteria) this;
		}

		public Criteria andRepaymentDescBetween(String value1, String value2) {
			addCriterion("REPAYMENT_DESC between", value1, value2, "repaymentDesc");
			return (Criteria) this;
		}

		public Criteria andRepaymentDescNotBetween(String value1, String value2) {
			addCriterion("REPAYMENT_DESC not between", value1, value2, "repaymentDesc");
			return (Criteria) this;
		}

		public Criteria andCopySourceIdIsNull() {
			addCriterion("COPY_SOURCE_ID is null");
			return (Criteria) this;
		}

		public Criteria andCopySourceIdIsNotNull() {
			addCriterion("COPY_SOURCE_ID is not null");
			return (Criteria) this;
		}

		public Criteria andCopySourceIdEqualTo(Integer value) {
			addCriterion("COPY_SOURCE_ID =", value, "copySourceId");
			return (Criteria) this;
		}

		public Criteria andCopySourceIdNotEqualTo(Integer value) {
			addCriterion("COPY_SOURCE_ID <>", value, "copySourceId");
			return (Criteria) this;
		}

		public Criteria andCopySourceIdGreaterThan(Integer value) {
			addCriterion("COPY_SOURCE_ID >", value, "copySourceId");
			return (Criteria) this;
		}

		public Criteria andCopySourceIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("COPY_SOURCE_ID >=", value, "copySourceId");
			return (Criteria) this;
		}

		public Criteria andCopySourceIdLessThan(Integer value) {
			addCriterion("COPY_SOURCE_ID <", value, "copySourceId");
			return (Criteria) this;
		}

		public Criteria andCopySourceIdLessThanOrEqualTo(Integer value) {
			addCriterion("COPY_SOURCE_ID <=", value, "copySourceId");
			return (Criteria) this;
		}

		public Criteria andCopySourceIdIn(List<Integer> values) {
			addCriterion("COPY_SOURCE_ID in", values, "copySourceId");
			return (Criteria) this;
		}

		public Criteria andCopySourceIdNotIn(List<Integer> values) {
			addCriterion("COPY_SOURCE_ID not in", values, "copySourceId");
			return (Criteria) this;
		}

		public Criteria andCopySourceIdBetween(Integer value1, Integer value2) {
			addCriterion("COPY_SOURCE_ID between", value1, value2, "copySourceId");
			return (Criteria) this;
		}

		public Criteria andCopySourceIdNotBetween(Integer value1, Integer value2) {
			addCriterion("COPY_SOURCE_ID not between", value1, value2, "copySourceId");
			return (Criteria) this;
		}

		public Criteria andDeliveryTimeIsNull() {
			addCriterion("DELIVERY_TIME is null");
			return (Criteria) this;
		}

		public Criteria andDeliveryTimeIsNotNull() {
			addCriterion("DELIVERY_TIME is not null");
			return (Criteria) this;
		}

		public Criteria andDeliveryTimeEqualTo(Date value) {
			addCriterion("DELIVERY_TIME =", value, "deliveryTime");
			return (Criteria) this;
		}

		public Criteria andDeliveryTimeNotEqualTo(Date value) {
			addCriterion("DELIVERY_TIME <>", value, "deliveryTime");
			return (Criteria) this;
		}

		public Criteria andDeliveryTimeGreaterThan(Date value) {
			addCriterion("DELIVERY_TIME >", value, "deliveryTime");
			return (Criteria) this;
		}

		public Criteria andDeliveryTimeGreaterThanOrEqualTo(Date value) {
			addCriterion("DELIVERY_TIME >=", value, "deliveryTime");
			return (Criteria) this;
		}

		public Criteria andDeliveryTimeLessThan(Date value) {
			addCriterion("DELIVERY_TIME <", value, "deliveryTime");
			return (Criteria) this;
		}

		public Criteria andDeliveryTimeLessThanOrEqualTo(Date value) {
			addCriterion("DELIVERY_TIME <=", value, "deliveryTime");
			return (Criteria) this;
		}

		public Criteria andDeliveryTimeIn(List<Date> values) {
			addCriterion("DELIVERY_TIME in", values, "deliveryTime");
			return (Criteria) this;
		}

		public Criteria andDeliveryTimeNotIn(List<Date> values) {
			addCriterion("DELIVERY_TIME not in", values, "deliveryTime");
			return (Criteria) this;
		}

		public Criteria andDeliveryTimeBetween(Date value1, Date value2) {
			addCriterion("DELIVERY_TIME between", value1, value2, "deliveryTime");
			return (Criteria) this;
		}

		public Criteria andDeliveryTimeNotBetween(Date value1, Date value2) {
			addCriterion("DELIVERY_TIME not between", value1, value2, "deliveryTime");
			return (Criteria) this;
		}

		public Criteria andRedeliveryTimeIsNull() {
			addCriterion("REDELIVERY_TIME is null");
			return (Criteria) this;
		}

		public Criteria andRedeliveryTimeIsNotNull() {
			addCriterion("REDELIVERY_TIME is not null");
			return (Criteria) this;
		}

		public Criteria andRedeliveryTimeEqualTo(Date value) {
			addCriterion("REDELIVERY_TIME =", value, "redeliveryTime");
			return (Criteria) this;
		}

		public Criteria andRedeliveryTimeNotEqualTo(Date value) {
			addCriterion("REDELIVERY_TIME <>", value, "redeliveryTime");
			return (Criteria) this;
		}

		public Criteria andRedeliveryTimeGreaterThan(Date value) {
			addCriterion("REDELIVERY_TIME >", value, "redeliveryTime");
			return (Criteria) this;
		}

		public Criteria andRedeliveryTimeGreaterThanOrEqualTo(Date value) {
			addCriterion("REDELIVERY_TIME >=", value, "redeliveryTime");
			return (Criteria) this;
		}

		public Criteria andRedeliveryTimeLessThan(Date value) {
			addCriterion("REDELIVERY_TIME <", value, "redeliveryTime");
			return (Criteria) this;
		}

		public Criteria andRedeliveryTimeLessThanOrEqualTo(Date value) {
			addCriterion("REDELIVERY_TIME <=", value, "redeliveryTime");
			return (Criteria) this;
		}

		public Criteria andRedeliveryTimeIn(List<Date> values) {
			addCriterion("REDELIVERY_TIME in", values, "redeliveryTime");
			return (Criteria) this;
		}

		public Criteria andRedeliveryTimeNotIn(List<Date> values) {
			addCriterion("REDELIVERY_TIME not in", values, "redeliveryTime");
			return (Criteria) this;
		}

		public Criteria andRedeliveryTimeBetween(Date value1, Date value2) {
			addCriterion("REDELIVERY_TIME between", value1, value2, "redeliveryTime");
			return (Criteria) this;
		}

		public Criteria andRedeliveryTimeNotBetween(Date value1, Date value2) {
			addCriterion("REDELIVERY_TIME not between", value1, value2, "redeliveryTime");
			return (Criteria) this;
		}

		public Criteria andReceivablesNoIsNull() {
			addCriterion("RECEIVABLES_NO is null");
			return (Criteria) this;
		}

		public Criteria andReceivablesNoIsNotNull() {
			addCriterion("RECEIVABLES_NO is not null");
			return (Criteria) this;
		}

		public Criteria andReceivablesNoEqualTo(String value) {
			addCriterion("RECEIVABLES_NO =", value, "receivablesNo");
			return (Criteria) this;
		}

		public Criteria andReceivablesNoNotEqualTo(String value) {
			addCriterion("RECEIVABLES_NO <>", value, "receivablesNo");
			return (Criteria) this;
		}

		public Criteria andReceivablesNoGreaterThan(String value) {
			addCriterion("RECEIVABLES_NO >", value, "receivablesNo");
			return (Criteria) this;
		}

		public Criteria andReceivablesNoGreaterThanOrEqualTo(String value) {
			addCriterion("RECEIVABLES_NO >=", value, "receivablesNo");
			return (Criteria) this;
		}

		public Criteria andReceivablesNoLessThan(String value) {
			addCriterion("RECEIVABLES_NO <", value, "receivablesNo");
			return (Criteria) this;
		}

		public Criteria andReceivablesNoLessThanOrEqualTo(String value) {
			addCriterion("RECEIVABLES_NO <=", value, "receivablesNo");
			return (Criteria) this;
		}

		public Criteria andReceivablesNoLike(String value) {
			addCriterion("RECEIVABLES_NO like", value, "receivablesNo");
			return (Criteria) this;
		}

		public Criteria andReceivablesNoNotLike(String value) {
			addCriterion("RECEIVABLES_NO not like", value, "receivablesNo");
			return (Criteria) this;
		}

		public Criteria andReceivablesNoIn(List<String> values) {
			addCriterion("RECEIVABLES_NO in", values, "receivablesNo");
			return (Criteria) this;
		}

		public Criteria andReceivablesNoNotIn(List<String> values) {
			addCriterion("RECEIVABLES_NO not in", values, "receivablesNo");
			return (Criteria) this;
		}

		public Criteria andReceivablesNoBetween(String value1, String value2) {
			addCriterion("RECEIVABLES_NO between", value1, value2, "receivablesNo");
			return (Criteria) this;
		}

		public Criteria andReceivablesNoNotBetween(String value1, String value2) {
			addCriterion("RECEIVABLES_NO not between", value1, value2, "receivablesNo");
			return (Criteria) this;
		}

		public Criteria andDoubleDeptFlagIsNull() {
			addCriterion("DOUBLE_DEPT_FLAG is null");
			return (Criteria) this;
		}

		public Criteria andDoubleDeptFlagIsNotNull() {
			addCriterion("DOUBLE_DEPT_FLAG is not null");
			return (Criteria) this;
		}

		public Criteria andDoubleDeptFlagEqualTo(Boolean value) {
			addCriterion("DOUBLE_DEPT_FLAG =", value, "doubleDeptFlag");
			return (Criteria) this;
		}

		public Criteria andDoubleDeptFlagNotEqualTo(Boolean value) {
			addCriterion("DOUBLE_DEPT_FLAG <>", value, "doubleDeptFlag");
			return (Criteria) this;
		}

		public Criteria andDoubleDeptFlagGreaterThan(Boolean value) {
			addCriterion("DOUBLE_DEPT_FLAG >", value, "doubleDeptFlag");
			return (Criteria) this;
		}

		public Criteria andDoubleDeptFlagGreaterThanOrEqualTo(Boolean value) {
			addCriterion("DOUBLE_DEPT_FLAG >=", value, "doubleDeptFlag");
			return (Criteria) this;
		}

		public Criteria andDoubleDeptFlagLessThan(Boolean value) {
			addCriterion("DOUBLE_DEPT_FLAG <", value, "doubleDeptFlag");
			return (Criteria) this;
		}

		public Criteria andDoubleDeptFlagLessThanOrEqualTo(Boolean value) {
			addCriterion("DOUBLE_DEPT_FLAG <=", value, "doubleDeptFlag");
			return (Criteria) this;
		}

		public Criteria andDoubleDeptFlagIn(List<Boolean> values) {
			addCriterion("DOUBLE_DEPT_FLAG in", values, "doubleDeptFlag");
			return (Criteria) this;
		}

		public Criteria andDoubleDeptFlagNotIn(List<Boolean> values) {
			addCriterion("DOUBLE_DEPT_FLAG not in", values, "doubleDeptFlag");
			return (Criteria) this;
		}

		public Criteria andDoubleDeptFlagBetween(Boolean value1, Boolean value2) {
			addCriterion("DOUBLE_DEPT_FLAG between", value1, value2, "doubleDeptFlag");
			return (Criteria) this;
		}

		public Criteria andDoubleDeptFlagNotBetween(Boolean value1, Boolean value2) {
			addCriterion("DOUBLE_DEPT_FLAG not between", value1, value2, "doubleDeptFlag");
			return (Criteria) this;
		}

		public Criteria andSecondDeptCustTypeIsNull() {
			addCriterion("SECOND_DEPT_CUST_TYPE is null");
			return (Criteria) this;
		}

		public Criteria andSecondDeptCustTypeIsNotNull() {
			addCriterion("SECOND_DEPT_CUST_TYPE is not null");
			return (Criteria) this;
		}

		public Criteria andSecondDeptCustTypeEqualTo(Byte value) {
			addCriterion("SECOND_DEPT_CUST_TYPE =", value, "secondDeptCustType");
			return (Criteria) this;
		}

		public Criteria andSecondDeptCustTypeNotEqualTo(Byte value) {
			addCriterion("SECOND_DEPT_CUST_TYPE <>", value, "secondDeptCustType");
			return (Criteria) this;
		}

		public Criteria andSecondDeptCustTypeGreaterThan(Byte value) {
			addCriterion("SECOND_DEPT_CUST_TYPE >", value, "secondDeptCustType");
			return (Criteria) this;
		}

		public Criteria andSecondDeptCustTypeGreaterThanOrEqualTo(Byte value) {
			addCriterion("SECOND_DEPT_CUST_TYPE >=", value, "secondDeptCustType");
			return (Criteria) this;
		}

		public Criteria andSecondDeptCustTypeLessThan(Byte value) {
			addCriterion("SECOND_DEPT_CUST_TYPE <", value, "secondDeptCustType");
			return (Criteria) this;
		}

		public Criteria andSecondDeptCustTypeLessThanOrEqualTo(Byte value) {
			addCriterion("SECOND_DEPT_CUST_TYPE <=", value, "secondDeptCustType");
			return (Criteria) this;
		}

		public Criteria andSecondDeptCustTypeIn(List<Byte> values) {
			addCriterion("SECOND_DEPT_CUST_TYPE in", values, "secondDeptCustType");
			return (Criteria) this;
		}

		public Criteria andSecondDeptCustTypeNotIn(List<Byte> values) {
			addCriterion("SECOND_DEPT_CUST_TYPE not in", values, "secondDeptCustType");
			return (Criteria) this;
		}

		public Criteria andSecondDeptCustTypeBetween(Byte value1, Byte value2) {
			addCriterion("SECOND_DEPT_CUST_TYPE between", value1, value2, "secondDeptCustType");
			return (Criteria) this;
		}

		public Criteria andSecondDeptCustTypeNotBetween(Byte value1, Byte value2) {
			addCriterion("SECOND_DEPT_CUST_TYPE not between", value1, value2, "secondDeptCustType");
			return (Criteria) this;
		}

		public Criteria andSecondDeptCityIdIsNull() {
			addCriterion("SECOND_DEPT_CITY_ID is null");
			return (Criteria) this;
		}

		public Criteria andSecondDeptCityIdIsNotNull() {
			addCriterion("SECOND_DEPT_CITY_ID is not null");
			return (Criteria) this;
		}

		public Criteria andSecondDeptCityIdEqualTo(Integer value) {
			addCriterion("SECOND_DEPT_CITY_ID =", value, "secondDeptCityId");
			return (Criteria) this;
		}

		public Criteria andSecondDeptCityIdNotEqualTo(Integer value) {
			addCriterion("SECOND_DEPT_CITY_ID <>", value, "secondDeptCityId");
			return (Criteria) this;
		}

		public Criteria andSecondDeptCityIdGreaterThan(Integer value) {
			addCriterion("SECOND_DEPT_CITY_ID >", value, "secondDeptCityId");
			return (Criteria) this;
		}

		public Criteria andSecondDeptCityIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("SECOND_DEPT_CITY_ID >=", value, "secondDeptCityId");
			return (Criteria) this;
		}

		public Criteria andSecondDeptCityIdLessThan(Integer value) {
			addCriterion("SECOND_DEPT_CITY_ID <", value, "secondDeptCityId");
			return (Criteria) this;
		}

		public Criteria andSecondDeptCityIdLessThanOrEqualTo(Integer value) {
			addCriterion("SECOND_DEPT_CITY_ID <=", value, "secondDeptCityId");
			return (Criteria) this;
		}

		public Criteria andSecondDeptCityIdIn(List<Integer> values) {
			addCriterion("SECOND_DEPT_CITY_ID in", values, "secondDeptCityId");
			return (Criteria) this;
		}

		public Criteria andSecondDeptCityIdNotIn(List<Integer> values) {
			addCriterion("SECOND_DEPT_CITY_ID not in", values, "secondDeptCityId");
			return (Criteria) this;
		}

		public Criteria andSecondDeptCityIdBetween(Integer value1, Integer value2) {
			addCriterion("SECOND_DEPT_CITY_ID between", value1, value2, "secondDeptCityId");
			return (Criteria) this;
		}

		public Criteria andSecondDeptCityIdNotBetween(Integer value1, Integer value2) {
			addCriterion("SECOND_DEPT_CITY_ID not between", value1, value2, "secondDeptCityId");
			return (Criteria) this;
		}

		public Criteria andSecondDeptRegIdIsNull() {
			addCriterion("SECOND_DEPT_REG_ID is null");
			return (Criteria) this;
		}

		public Criteria andSecondDeptRegIdIsNotNull() {
			addCriterion("SECOND_DEPT_REG_ID is not null");
			return (Criteria) this;
		}

		public Criteria andSecondDeptRegIdEqualTo(Integer value) {
			addCriterion("SECOND_DEPT_REG_ID =", value, "secondDeptRegId");
			return (Criteria) this;
		}

		public Criteria andSecondDeptRegIdNotEqualTo(Integer value) {
			addCriterion("SECOND_DEPT_REG_ID <>", value, "secondDeptRegId");
			return (Criteria) this;
		}

		public Criteria andSecondDeptRegIdGreaterThan(Integer value) {
			addCriterion("SECOND_DEPT_REG_ID >", value, "secondDeptRegId");
			return (Criteria) this;
		}

		public Criteria andSecondDeptRegIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("SECOND_DEPT_REG_ID >=", value, "secondDeptRegId");
			return (Criteria) this;
		}

		public Criteria andSecondDeptRegIdLessThan(Integer value) {
			addCriterion("SECOND_DEPT_REG_ID <", value, "secondDeptRegId");
			return (Criteria) this;
		}

		public Criteria andSecondDeptRegIdLessThanOrEqualTo(Integer value) {
			addCriterion("SECOND_DEPT_REG_ID <=", value, "secondDeptRegId");
			return (Criteria) this;
		}

		public Criteria andSecondDeptRegIdIn(List<Integer> values) {
			addCriterion("SECOND_DEPT_REG_ID in", values, "secondDeptRegId");
			return (Criteria) this;
		}

		public Criteria andSecondDeptRegIdNotIn(List<Integer> values) {
			addCriterion("SECOND_DEPT_REG_ID not in", values, "secondDeptRegId");
			return (Criteria) this;
		}

		public Criteria andSecondDeptRegIdBetween(Integer value1, Integer value2) {
			addCriterion("SECOND_DEPT_REG_ID between", value1, value2, "secondDeptRegId");
			return (Criteria) this;
		}

		public Criteria andSecondDeptRegIdNotBetween(Integer value1, Integer value2) {
			addCriterion("SECOND_DEPT_REG_ID not between", value1, value2, "secondDeptRegId");
			return (Criteria) this;
		}

		public Criteria andSecondCompNoIsNull() {
			addCriterion("SECOND_COMP_NO is null");
			return (Criteria) this;
		}

		public Criteria andSecondCompNoIsNotNull() {
			addCriterion("SECOND_COMP_NO is not null");
			return (Criteria) this;
		}

		public Criteria andSecondCompNoEqualTo(String value) {
			addCriterion("SECOND_COMP_NO =", value, "secondCompNo");
			return (Criteria) this;
		}

		public Criteria andSecondCompNoNotEqualTo(String value) {
			addCriterion("SECOND_COMP_NO <>", value, "secondCompNo");
			return (Criteria) this;
		}

		public Criteria andSecondCompNoGreaterThan(String value) {
			addCriterion("SECOND_COMP_NO >", value, "secondCompNo");
			return (Criteria) this;
		}

		public Criteria andSecondCompNoGreaterThanOrEqualTo(String value) {
			addCriterion("SECOND_COMP_NO >=", value, "secondCompNo");
			return (Criteria) this;
		}

		public Criteria andSecondCompNoLessThan(String value) {
			addCriterion("SECOND_COMP_NO <", value, "secondCompNo");
			return (Criteria) this;
		}

		public Criteria andSecondCompNoLessThanOrEqualTo(String value) {
			addCriterion("SECOND_COMP_NO <=", value, "secondCompNo");
			return (Criteria) this;
		}

		public Criteria andSecondCompNoLike(String value) {
			addCriterion("SECOND_COMP_NO like", value, "secondCompNo");
			return (Criteria) this;
		}

		public Criteria andSecondCompNoNotLike(String value) {
			addCriterion("SECOND_COMP_NO not like", value, "secondCompNo");
			return (Criteria) this;
		}

		public Criteria andSecondCompNoIn(List<String> values) {
			addCriterion("SECOND_COMP_NO in", values, "secondCompNo");
			return (Criteria) this;
		}

		public Criteria andSecondCompNoNotIn(List<String> values) {
			addCriterion("SECOND_COMP_NO not in", values, "secondCompNo");
			return (Criteria) this;
		}

		public Criteria andSecondCompNoBetween(String value1, String value2) {
			addCriterion("SECOND_COMP_NO between", value1, value2, "secondCompNo");
			return (Criteria) this;
		}

		public Criteria andSecondCompNoNotBetween(String value1, String value2) {
			addCriterion("SECOND_COMP_NO not between", value1, value2, "secondCompNo");
			return (Criteria) this;
		}

		public Criteria andSecondDeptNoIsNull() {
			addCriterion("SECOND_DEPT_NO is null");
			return (Criteria) this;
		}

		public Criteria andSecondDeptNoIsNotNull() {
			addCriterion("SECOND_DEPT_NO is not null");
			return (Criteria) this;
		}

		public Criteria andSecondDeptNoEqualTo(String value) {
			addCriterion("SECOND_DEPT_NO =", value, "secondDeptNo");
			return (Criteria) this;
		}

		public Criteria andSecondDeptNoNotEqualTo(String value) {
			addCriterion("SECOND_DEPT_NO <>", value, "secondDeptNo");
			return (Criteria) this;
		}

		public Criteria andSecondDeptNoGreaterThan(String value) {
			addCriterion("SECOND_DEPT_NO >", value, "secondDeptNo");
			return (Criteria) this;
		}

		public Criteria andSecondDeptNoGreaterThanOrEqualTo(String value) {
			addCriterion("SECOND_DEPT_NO >=", value, "secondDeptNo");
			return (Criteria) this;
		}

		public Criteria andSecondDeptNoLessThan(String value) {
			addCriterion("SECOND_DEPT_NO <", value, "secondDeptNo");
			return (Criteria) this;
		}

		public Criteria andSecondDeptNoLessThanOrEqualTo(String value) {
			addCriterion("SECOND_DEPT_NO <=", value, "secondDeptNo");
			return (Criteria) this;
		}

		public Criteria andSecondDeptNoLike(String value) {
			addCriterion("SECOND_DEPT_NO like", value, "secondDeptNo");
			return (Criteria) this;
		}

		public Criteria andSecondDeptNoNotLike(String value) {
			addCriterion("SECOND_DEPT_NO not like", value, "secondDeptNo");
			return (Criteria) this;
		}

		public Criteria andSecondDeptNoIn(List<String> values) {
			addCriterion("SECOND_DEPT_NO in", values, "secondDeptNo");
			return (Criteria) this;
		}

		public Criteria andSecondDeptNoNotIn(List<String> values) {
			addCriterion("SECOND_DEPT_NO not in", values, "secondDeptNo");
			return (Criteria) this;
		}

		public Criteria andSecondDeptNoBetween(String value1, String value2) {
			addCriterion("SECOND_DEPT_NO between", value1, value2, "secondDeptNo");
			return (Criteria) this;
		}

		public Criteria andSecondDeptNoNotBetween(String value1, String value2) {
			addCriterion("SECOND_DEPT_NO not between", value1, value2, "secondDeptNo");
			return (Criteria) this;
		}

		public Criteria andSecondErpCompIdIsNull() {
			addCriterion("SECOND_ERP_COMP_ID is null");
			return (Criteria) this;
		}

		public Criteria andSecondErpCompIdIsNotNull() {
			addCriterion("SECOND_ERP_COMP_ID is not null");
			return (Criteria) this;
		}

		public Criteria andSecondErpCompIdEqualTo(Integer value) {
			addCriterion("SECOND_ERP_COMP_ID =", value, "secondErpCompId");
			return (Criteria) this;
		}

		public Criteria andSecondErpCompIdNotEqualTo(Integer value) {
			addCriterion("SECOND_ERP_COMP_ID <>", value, "secondErpCompId");
			return (Criteria) this;
		}

		public Criteria andSecondErpCompIdGreaterThan(Integer value) {
			addCriterion("SECOND_ERP_COMP_ID >", value, "secondErpCompId");
			return (Criteria) this;
		}

		public Criteria andSecondErpCompIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("SECOND_ERP_COMP_ID >=", value, "secondErpCompId");
			return (Criteria) this;
		}

		public Criteria andSecondErpCompIdLessThan(Integer value) {
			addCriterion("SECOND_ERP_COMP_ID <", value, "secondErpCompId");
			return (Criteria) this;
		}

		public Criteria andSecondErpCompIdLessThanOrEqualTo(Integer value) {
			addCriterion("SECOND_ERP_COMP_ID <=", value, "secondErpCompId");
			return (Criteria) this;
		}

		public Criteria andSecondErpCompIdIn(List<Integer> values) {
			addCriterion("SECOND_ERP_COMP_ID in", values, "secondErpCompId");
			return (Criteria) this;
		}

		public Criteria andSecondErpCompIdNotIn(List<Integer> values) {
			addCriterion("SECOND_ERP_COMP_ID not in", values, "secondErpCompId");
			return (Criteria) this;
		}

		public Criteria andSecondErpCompIdBetween(Integer value1, Integer value2) {
			addCriterion("SECOND_ERP_COMP_ID between", value1, value2, "secondErpCompId");
			return (Criteria) this;
		}

		public Criteria andSecondErpCompIdNotBetween(Integer value1, Integer value2) {
			addCriterion("SECOND_ERP_COMP_ID not between", value1, value2, "secondErpCompId");
			return (Criteria) this;
		}

		public Criteria andSecondErpDeptIdIsNull() {
			addCriterion("SECOND_ERP_DEPT_ID is null");
			return (Criteria) this;
		}

		public Criteria andSecondErpDeptIdIsNotNull() {
			addCriterion("SECOND_ERP_DEPT_ID is not null");
			return (Criteria) this;
		}

		public Criteria andSecondErpDeptIdEqualTo(Integer value) {
			addCriterion("SECOND_ERP_DEPT_ID =", value, "secondErpDeptId");
			return (Criteria) this;
		}

		public Criteria andSecondErpDeptIdNotEqualTo(Integer value) {
			addCriterion("SECOND_ERP_DEPT_ID <>", value, "secondErpDeptId");
			return (Criteria) this;
		}

		public Criteria andSecondErpDeptIdGreaterThan(Integer value) {
			addCriterion("SECOND_ERP_DEPT_ID >", value, "secondErpDeptId");
			return (Criteria) this;
		}

		public Criteria andSecondErpDeptIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("SECOND_ERP_DEPT_ID >=", value, "secondErpDeptId");
			return (Criteria) this;
		}

		public Criteria andSecondErpDeptIdLessThan(Integer value) {
			addCriterion("SECOND_ERP_DEPT_ID <", value, "secondErpDeptId");
			return (Criteria) this;
		}

		public Criteria andSecondErpDeptIdLessThanOrEqualTo(Integer value) {
			addCriterion("SECOND_ERP_DEPT_ID <=", value, "secondErpDeptId");
			return (Criteria) this;
		}

		public Criteria andSecondErpDeptIdIn(List<Integer> values) {
			addCriterion("SECOND_ERP_DEPT_ID in", values, "secondErpDeptId");
			return (Criteria) this;
		}

		public Criteria andSecondErpDeptIdNotIn(List<Integer> values) {
			addCriterion("SECOND_ERP_DEPT_ID not in", values, "secondErpDeptId");
			return (Criteria) this;
		}

		public Criteria andSecondErpDeptIdBetween(Integer value1, Integer value2) {
			addCriterion("SECOND_ERP_DEPT_ID between", value1, value2, "secondErpDeptId");
			return (Criteria) this;
		}

		public Criteria andSecondErpDeptIdNotBetween(Integer value1, Integer value2) {
			addCriterion("SECOND_ERP_DEPT_ID not between", value1, value2, "secondErpDeptId");
			return (Criteria) this;
		}

		public Criteria andSecondBrokerDeptNameIsNull() {
			addCriterion("SECOND_BROKER_DEPT_NAME is null");
			return (Criteria) this;
		}

		public Criteria andSecondBrokerDeptNameIsNotNull() {
			addCriterion("SECOND_BROKER_DEPT_NAME is not null");
			return (Criteria) this;
		}

		public Criteria andSecondBrokerDeptNameEqualTo(String value) {
			addCriterion("SECOND_BROKER_DEPT_NAME =", value, "secondBrokerDeptName");
			return (Criteria) this;
		}

		public Criteria andSecondBrokerDeptNameNotEqualTo(String value) {
			addCriterion("SECOND_BROKER_DEPT_NAME <>", value, "secondBrokerDeptName");
			return (Criteria) this;
		}

		public Criteria andSecondBrokerDeptNameGreaterThan(String value) {
			addCriterion("SECOND_BROKER_DEPT_NAME >", value, "secondBrokerDeptName");
			return (Criteria) this;
		}

		public Criteria andSecondBrokerDeptNameGreaterThanOrEqualTo(String value) {
			addCriterion("SECOND_BROKER_DEPT_NAME >=", value, "secondBrokerDeptName");
			return (Criteria) this;
		}

		public Criteria andSecondBrokerDeptNameLessThan(String value) {
			addCriterion("SECOND_BROKER_DEPT_NAME <", value, "secondBrokerDeptName");
			return (Criteria) this;
		}

		public Criteria andSecondBrokerDeptNameLessThanOrEqualTo(String value) {
			addCriterion("SECOND_BROKER_DEPT_NAME <=", value, "secondBrokerDeptName");
			return (Criteria) this;
		}

		public Criteria andSecondBrokerDeptNameLike(String value) {
			addCriterion("SECOND_BROKER_DEPT_NAME like", value, "secondBrokerDeptName");
			return (Criteria) this;
		}

		public Criteria andSecondBrokerDeptNameNotLike(String value) {
			addCriterion("SECOND_BROKER_DEPT_NAME not like", value, "secondBrokerDeptName");
			return (Criteria) this;
		}

		public Criteria andSecondBrokerDeptNameIn(List<String> values) {
			addCriterion("SECOND_BROKER_DEPT_NAME in", values, "secondBrokerDeptName");
			return (Criteria) this;
		}

		public Criteria andSecondBrokerDeptNameNotIn(List<String> values) {
			addCriterion("SECOND_BROKER_DEPT_NAME not in", values, "secondBrokerDeptName");
			return (Criteria) this;
		}

		public Criteria andSecondBrokerDeptNameBetween(String value1, String value2) {
			addCriterion("SECOND_BROKER_DEPT_NAME between", value1, value2, "secondBrokerDeptName");
			return (Criteria) this;
		}

		public Criteria andSecondBrokerDeptNameNotBetween(String value1, String value2) {
			addCriterion("SECOND_BROKER_DEPT_NAME not between", value1, value2, "secondBrokerDeptName");
			return (Criteria) this;
		}

		public Criteria andSecondBrokerRegNameIsNull() {
			addCriterion("SECOND_BROKER_REG_NAME is null");
			return (Criteria) this;
		}

		public Criteria andSecondBrokerRegNameIsNotNull() {
			addCriterion("SECOND_BROKER_REG_NAME is not null");
			return (Criteria) this;
		}

		public Criteria andSecondBrokerRegNameEqualTo(String value) {
			addCriterion("SECOND_BROKER_REG_NAME =", value, "secondBrokerRegName");
			return (Criteria) this;
		}

		public Criteria andSecondBrokerRegNameNotEqualTo(String value) {
			addCriterion("SECOND_BROKER_REG_NAME <>", value, "secondBrokerRegName");
			return (Criteria) this;
		}

		public Criteria andSecondBrokerRegNameGreaterThan(String value) {
			addCriterion("SECOND_BROKER_REG_NAME >", value, "secondBrokerRegName");
			return (Criteria) this;
		}

		public Criteria andSecondBrokerRegNameGreaterThanOrEqualTo(String value) {
			addCriterion("SECOND_BROKER_REG_NAME >=", value, "secondBrokerRegName");
			return (Criteria) this;
		}

		public Criteria andSecondBrokerRegNameLessThan(String value) {
			addCriterion("SECOND_BROKER_REG_NAME <", value, "secondBrokerRegName");
			return (Criteria) this;
		}

		public Criteria andSecondBrokerRegNameLessThanOrEqualTo(String value) {
			addCriterion("SECOND_BROKER_REG_NAME <=", value, "secondBrokerRegName");
			return (Criteria) this;
		}

		public Criteria andSecondBrokerRegNameLike(String value) {
			addCriterion("SECOND_BROKER_REG_NAME like", value, "secondBrokerRegName");
			return (Criteria) this;
		}

		public Criteria andSecondBrokerRegNameNotLike(String value) {
			addCriterion("SECOND_BROKER_REG_NAME not like", value, "secondBrokerRegName");
			return (Criteria) this;
		}

		public Criteria andSecondBrokerRegNameIn(List<String> values) {
			addCriterion("SECOND_BROKER_REG_NAME in", values, "secondBrokerRegName");
			return (Criteria) this;
		}

		public Criteria andSecondBrokerRegNameNotIn(List<String> values) {
			addCriterion("SECOND_BROKER_REG_NAME not in", values, "secondBrokerRegName");
			return (Criteria) this;
		}

		public Criteria andSecondBrokerRegNameBetween(String value1, String value2) {
			addCriterion("SECOND_BROKER_REG_NAME between", value1, value2, "secondBrokerRegName");
			return (Criteria) this;
		}

		public Criteria andSecondBrokerRegNameNotBetween(String value1, String value2) {
			addCriterion("SECOND_BROKER_REG_NAME not between", value1, value2, "secondBrokerRegName");
			return (Criteria) this;
		}

		public Criteria andSecondBrokerRegIdIsNull() {
			addCriterion("SECOND_BROKER_REG_ID is null");
			return (Criteria) this;
		}

		public Criteria andSecondBrokerRegIdIsNotNull() {
			addCriterion("SECOND_BROKER_REG_ID is not null");
			return (Criteria) this;
		}

		public Criteria andSecondBrokerRegIdEqualTo(Integer value) {
			addCriterion("SECOND_BROKER_REG_ID =", value, "secondBrokerRegId");
			return (Criteria) this;
		}

		public Criteria andSecondBrokerRegIdNotEqualTo(Integer value) {
			addCriterion("SECOND_BROKER_REG_ID <>", value, "secondBrokerRegId");
			return (Criteria) this;
		}

		public Criteria andSecondBrokerRegIdGreaterThan(Integer value) {
			addCriterion("SECOND_BROKER_REG_ID >", value, "secondBrokerRegId");
			return (Criteria) this;
		}

		public Criteria andSecondBrokerRegIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("SECOND_BROKER_REG_ID >=", value, "secondBrokerRegId");
			return (Criteria) this;
		}

		public Criteria andSecondBrokerRegIdLessThan(Integer value) {
			addCriterion("SECOND_BROKER_REG_ID <", value, "secondBrokerRegId");
			return (Criteria) this;
		}

		public Criteria andSecondBrokerRegIdLessThanOrEqualTo(Integer value) {
			addCriterion("SECOND_BROKER_REG_ID <=", value, "secondBrokerRegId");
			return (Criteria) this;
		}

		public Criteria andSecondBrokerRegIdIn(List<Integer> values) {
			addCriterion("SECOND_BROKER_REG_ID in", values, "secondBrokerRegId");
			return (Criteria) this;
		}

		public Criteria andSecondBrokerRegIdNotIn(List<Integer> values) {
			addCriterion("SECOND_BROKER_REG_ID not in", values, "secondBrokerRegId");
			return (Criteria) this;
		}

		public Criteria andSecondBrokerRegIdBetween(Integer value1, Integer value2) {
			addCriterion("SECOND_BROKER_REG_ID between", value1, value2, "secondBrokerRegId");
			return (Criteria) this;
		}

		public Criteria andSecondBrokerRegIdNotBetween(Integer value1, Integer value2) {
			addCriterion("SECOND_BROKER_REG_ID not between", value1, value2, "secondBrokerRegId");
			return (Criteria) this;
		}

		public Criteria andSecondArchiveIdIsNull() {
			addCriterion("SECOND_ARCHIVE_ID is null");
			return (Criteria) this;
		}

		public Criteria andSecondArchiveIdIsNotNull() {
			addCriterion("SECOND_ARCHIVE_ID is not null");
			return (Criteria) this;
		}

		public Criteria andSecondArchiveIdEqualTo(Integer value) {
			addCriterion("SECOND_ARCHIVE_ID =", value, "secondArchiveId");
			return (Criteria) this;
		}

		public Criteria andSecondArchiveIdNotEqualTo(Integer value) {
			addCriterion("SECOND_ARCHIVE_ID <>", value, "secondArchiveId");
			return (Criteria) this;
		}

		public Criteria andSecondArchiveIdGreaterThan(Integer value) {
			addCriterion("SECOND_ARCHIVE_ID >", value, "secondArchiveId");
			return (Criteria) this;
		}

		public Criteria andSecondArchiveIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("SECOND_ARCHIVE_ID >=", value, "secondArchiveId");
			return (Criteria) this;
		}

		public Criteria andSecondArchiveIdLessThan(Integer value) {
			addCriterion("SECOND_ARCHIVE_ID <", value, "secondArchiveId");
			return (Criteria) this;
		}

		public Criteria andSecondArchiveIdLessThanOrEqualTo(Integer value) {
			addCriterion("SECOND_ARCHIVE_ID <=", value, "secondArchiveId");
			return (Criteria) this;
		}

		public Criteria andSecondArchiveIdIn(List<Integer> values) {
			addCriterion("SECOND_ARCHIVE_ID in", values, "secondArchiveId");
			return (Criteria) this;
		}

		public Criteria andSecondArchiveIdNotIn(List<Integer> values) {
			addCriterion("SECOND_ARCHIVE_ID not in", values, "secondArchiveId");
			return (Criteria) this;
		}

		public Criteria andSecondArchiveIdBetween(Integer value1, Integer value2) {
			addCriterion("SECOND_ARCHIVE_ID between", value1, value2, "secondArchiveId");
			return (Criteria) this;
		}

		public Criteria andSecondArchiveIdNotBetween(Integer value1, Integer value2) {
			addCriterion("SECOND_ARCHIVE_ID not between", value1, value2, "secondArchiveId");
			return (Criteria) this;
		}

		public Criteria andSecondBrokerUserNameIsNull() {
			addCriterion("SECOND_BROKER_USER_NAME is null");
			return (Criteria) this;
		}

		public Criteria andSecondBrokerUserNameIsNotNull() {
			addCriterion("SECOND_BROKER_USER_NAME is not null");
			return (Criteria) this;
		}

		public Criteria andSecondBrokerUserNameEqualTo(String value) {
			addCriterion("SECOND_BROKER_USER_NAME =", value, "secondBrokerUserName");
			return (Criteria) this;
		}

		public Criteria andSecondBrokerUserNameNotEqualTo(String value) {
			addCriterion("SECOND_BROKER_USER_NAME <>", value, "secondBrokerUserName");
			return (Criteria) this;
		}

		public Criteria andSecondBrokerUserNameGreaterThan(String value) {
			addCriterion("SECOND_BROKER_USER_NAME >", value, "secondBrokerUserName");
			return (Criteria) this;
		}

		public Criteria andSecondBrokerUserNameGreaterThanOrEqualTo(String value) {
			addCriterion("SECOND_BROKER_USER_NAME >=", value, "secondBrokerUserName");
			return (Criteria) this;
		}

		public Criteria andSecondBrokerUserNameLessThan(String value) {
			addCriterion("SECOND_BROKER_USER_NAME <", value, "secondBrokerUserName");
			return (Criteria) this;
		}

		public Criteria andSecondBrokerUserNameLessThanOrEqualTo(String value) {
			addCriterion("SECOND_BROKER_USER_NAME <=", value, "secondBrokerUserName");
			return (Criteria) this;
		}

		public Criteria andSecondBrokerUserNameLike(String value) {
			addCriterion("SECOND_BROKER_USER_NAME like", value, "secondBrokerUserName");
			return (Criteria) this;
		}

		public Criteria andSecondBrokerUserNameNotLike(String value) {
			addCriterion("SECOND_BROKER_USER_NAME not like", value, "secondBrokerUserName");
			return (Criteria) this;
		}

		public Criteria andSecondBrokerUserNameIn(List<String> values) {
			addCriterion("SECOND_BROKER_USER_NAME in", values, "secondBrokerUserName");
			return (Criteria) this;
		}

		public Criteria andSecondBrokerUserNameNotIn(List<String> values) {
			addCriterion("SECOND_BROKER_USER_NAME not in", values, "secondBrokerUserName");
			return (Criteria) this;
		}

		public Criteria andSecondBrokerUserNameBetween(String value1, String value2) {
			addCriterion("SECOND_BROKER_USER_NAME between", value1, value2, "secondBrokerUserName");
			return (Criteria) this;
		}

		public Criteria andSecondBrokerUserNameNotBetween(String value1, String value2) {
			addCriterion("SECOND_BROKER_USER_NAME not between", value1, value2, "secondBrokerUserName");
			return (Criteria) this;
		}

		public Criteria andSecondBrokerUserMobileIsNull() {
			addCriterion("SECOND_BROKER_USER_MOBILE is null");
			return (Criteria) this;
		}

		public Criteria andSecondBrokerUserMobileIsNotNull() {
			addCriterion("SECOND_BROKER_USER_MOBILE is not null");
			return (Criteria) this;
		}

		public Criteria andSecondBrokerUserMobileEqualTo(String value) {
			addCriterion("SECOND_BROKER_USER_MOBILE =", value, "secondBrokerUserMobile");
			return (Criteria) this;
		}

		public Criteria andSecondBrokerUserMobileNotEqualTo(String value) {
			addCriterion("SECOND_BROKER_USER_MOBILE <>", value, "secondBrokerUserMobile");
			return (Criteria) this;
		}

		public Criteria andSecondBrokerUserMobileGreaterThan(String value) {
			addCriterion("SECOND_BROKER_USER_MOBILE >", value, "secondBrokerUserMobile");
			return (Criteria) this;
		}

		public Criteria andSecondBrokerUserMobileGreaterThanOrEqualTo(String value) {
			addCriterion("SECOND_BROKER_USER_MOBILE >=", value, "secondBrokerUserMobile");
			return (Criteria) this;
		}

		public Criteria andSecondBrokerUserMobileLessThan(String value) {
			addCriterion("SECOND_BROKER_USER_MOBILE <", value, "secondBrokerUserMobile");
			return (Criteria) this;
		}

		public Criteria andSecondBrokerUserMobileLessThanOrEqualTo(String value) {
			addCriterion("SECOND_BROKER_USER_MOBILE <=", value, "secondBrokerUserMobile");
			return (Criteria) this;
		}

		public Criteria andSecondBrokerUserMobileLike(String value) {
			addCriterion("SECOND_BROKER_USER_MOBILE like", value, "secondBrokerUserMobile");
			return (Criteria) this;
		}

		public Criteria andSecondBrokerUserMobileNotLike(String value) {
			addCriterion("SECOND_BROKER_USER_MOBILE not like", value, "secondBrokerUserMobile");
			return (Criteria) this;
		}

		public Criteria andSecondBrokerUserMobileIn(List<String> values) {
			addCriterion("SECOND_BROKER_USER_MOBILE in", values, "secondBrokerUserMobile");
			return (Criteria) this;
		}

		public Criteria andSecondBrokerUserMobileNotIn(List<String> values) {
			addCriterion("SECOND_BROKER_USER_MOBILE not in", values, "secondBrokerUserMobile");
			return (Criteria) this;
		}

		public Criteria andSecondBrokerUserMobileBetween(String value1, String value2) {
			addCriterion("SECOND_BROKER_USER_MOBILE between", value1, value2, "secondBrokerUserMobile");
			return (Criteria) this;
		}

		public Criteria andSecondBrokerUserMobileNotBetween(String value1, String value2) {
			addCriterion("SECOND_BROKER_USER_MOBILE not between", value1, value2, "secondBrokerUserMobile");
			return (Criteria) this;
		}

		public Criteria andIsPrintBrokerServiceContractIsNull() {
			addCriterion("IS_PRINT_BROKER_SERVICE_CONTRACT is null");
			return (Criteria) this;
		}

		public Criteria andIsPrintBrokerServiceContractIsNotNull() {
			addCriterion("IS_PRINT_BROKER_SERVICE_CONTRACT is not null");
			return (Criteria) this;
		}

		public Criteria andIsPrintBrokerServiceContractEqualTo(Boolean value) {
			addCriterion("IS_PRINT_BROKER_SERVICE_CONTRACT =", value, "isPrintBrokerServiceContract");
			return (Criteria) this;
		}

		public Criteria andIsPrintBrokerServiceContractNotEqualTo(Boolean value) {
			addCriterion("IS_PRINT_BROKER_SERVICE_CONTRACT <>", value, "isPrintBrokerServiceContract");
			return (Criteria) this;
		}

		public Criteria andIsPrintBrokerServiceContractGreaterThan(Boolean value) {
			addCriterion("IS_PRINT_BROKER_SERVICE_CONTRACT >", value, "isPrintBrokerServiceContract");
			return (Criteria) this;
		}

		public Criteria andIsPrintBrokerServiceContractGreaterThanOrEqualTo(Boolean value) {
			addCriterion("IS_PRINT_BROKER_SERVICE_CONTRACT >=", value, "isPrintBrokerServiceContract");
			return (Criteria) this;
		}

		public Criteria andIsPrintBrokerServiceContractLessThan(Boolean value) {
			addCriterion("IS_PRINT_BROKER_SERVICE_CONTRACT <", value, "isPrintBrokerServiceContract");
			return (Criteria) this;
		}

		public Criteria andIsPrintBrokerServiceContractLessThanOrEqualTo(Boolean value) {
			addCriterion("IS_PRINT_BROKER_SERVICE_CONTRACT <=", value, "isPrintBrokerServiceContract");
			return (Criteria) this;
		}

		public Criteria andIsPrintBrokerServiceContractIn(List<Boolean> values) {
			addCriterion("IS_PRINT_BROKER_SERVICE_CONTRACT in", values, "isPrintBrokerServiceContract");
			return (Criteria) this;
		}

		public Criteria andIsPrintBrokerServiceContractNotIn(List<Boolean> values) {
			addCriterion("IS_PRINT_BROKER_SERVICE_CONTRACT not in", values, "isPrintBrokerServiceContract");
			return (Criteria) this;
		}

		public Criteria andIsPrintBrokerServiceContractBetween(Boolean value1, Boolean value2) {
			addCriterion("IS_PRINT_BROKER_SERVICE_CONTRACT between", value1, value2, "isPrintBrokerServiceContract");
			return (Criteria) this;
		}

		public Criteria andIsPrintBrokerServiceContractNotBetween(Boolean value1, Boolean value2) {
			addCriterion("IS_PRINT_BROKER_SERVICE_CONTRACT not between", value1, value2,
					"isPrintBrokerServiceContract");
			return (Criteria) this;
		}

		public Criteria andPropertyRightTypeIsNull() {
			addCriterion("PROPERTY_RIGHT_TYPE is null");
			return (Criteria) this;
		}

		public Criteria andPropertyRightTypeIsNotNull() {
			addCriterion("PROPERTY_RIGHT_TYPE is not null");
			return (Criteria) this;
		}

		public Criteria andPropertyRightTypeEqualTo(Byte value) {
			addCriterion("PROPERTY_RIGHT_TYPE =", value, "propertyRightType");
			return (Criteria) this;
		}

		public Criteria andPropertyRightTypeNotEqualTo(Byte value) {
			addCriterion("PROPERTY_RIGHT_TYPE <>", value, "propertyRightType");
			return (Criteria) this;
		}

		public Criteria andPropertyRightTypeGreaterThan(Byte value) {
			addCriterion("PROPERTY_RIGHT_TYPE >", value, "propertyRightType");
			return (Criteria) this;
		}

		public Criteria andPropertyRightTypeGreaterThanOrEqualTo(Byte value) {
			addCriterion("PROPERTY_RIGHT_TYPE >=", value, "propertyRightType");
			return (Criteria) this;
		}

		public Criteria andPropertyRightTypeLessThan(Byte value) {
			addCriterion("PROPERTY_RIGHT_TYPE <", value, "propertyRightType");
			return (Criteria) this;
		}

		public Criteria andPropertyRightTypeLessThanOrEqualTo(Byte value) {
			addCriterion("PROPERTY_RIGHT_TYPE <=", value, "propertyRightType");
			return (Criteria) this;
		}

		public Criteria andPropertyRightTypeIn(List<Byte> values) {
			addCriterion("PROPERTY_RIGHT_TYPE in", values, "propertyRightType");
			return (Criteria) this;
		}

		public Criteria andPropertyRightTypeNotIn(List<Byte> values) {
			addCriterion("PROPERTY_RIGHT_TYPE not in", values, "propertyRightType");
			return (Criteria) this;
		}

		public Criteria andPropertyRightTypeBetween(Byte value1, Byte value2) {
			addCriterion("PROPERTY_RIGHT_TYPE between", value1, value2, "propertyRightType");
			return (Criteria) this;
		}

		public Criteria andPropertyRightTypeNotBetween(Byte value1, Byte value2) {
			addCriterion("PROPERTY_RIGHT_TYPE not between", value1, value2, "propertyRightType");
			return (Criteria) this;
		}

		public Criteria andCompPropertyRightAgentIsNull() {
			addCriterion("COMP_PROPERTY_RIGHT_AGENT is null");
			return (Criteria) this;
		}

		public Criteria andCompPropertyRightAgentIsNotNull() {
			addCriterion("COMP_PROPERTY_RIGHT_AGENT is not null");
			return (Criteria) this;
		}

		public Criteria andCompPropertyRightAgentEqualTo(String value) {
			addCriterion("COMP_PROPERTY_RIGHT_AGENT =", value, "compPropertyRightAgent");
			return (Criteria) this;
		}

		public Criteria andCompPropertyRightAgentNotEqualTo(String value) {
			addCriterion("COMP_PROPERTY_RIGHT_AGENT <>", value, "compPropertyRightAgent");
			return (Criteria) this;
		}

		public Criteria andCompPropertyRightAgentGreaterThan(String value) {
			addCriterion("COMP_PROPERTY_RIGHT_AGENT >", value, "compPropertyRightAgent");
			return (Criteria) this;
		}

		public Criteria andCompPropertyRightAgentGreaterThanOrEqualTo(String value) {
			addCriterion("COMP_PROPERTY_RIGHT_AGENT >=", value, "compPropertyRightAgent");
			return (Criteria) this;
		}

		public Criteria andCompPropertyRightAgentLessThan(String value) {
			addCriterion("COMP_PROPERTY_RIGHT_AGENT <", value, "compPropertyRightAgent");
			return (Criteria) this;
		}

		public Criteria andCompPropertyRightAgentLessThanOrEqualTo(String value) {
			addCriterion("COMP_PROPERTY_RIGHT_AGENT <=", value, "compPropertyRightAgent");
			return (Criteria) this;
		}

		public Criteria andCompPropertyRightAgentLike(String value) {
			addCriterion("COMP_PROPERTY_RIGHT_AGENT like", value, "compPropertyRightAgent");
			return (Criteria) this;
		}

		public Criteria andCompPropertyRightAgentNotLike(String value) {
			addCriterion("COMP_PROPERTY_RIGHT_AGENT not like", value, "compPropertyRightAgent");
			return (Criteria) this;
		}

		public Criteria andCompPropertyRightAgentIn(List<String> values) {
			addCriterion("COMP_PROPERTY_RIGHT_AGENT in", values, "compPropertyRightAgent");
			return (Criteria) this;
		}

		public Criteria andCompPropertyRightAgentNotIn(List<String> values) {
			addCriterion("COMP_PROPERTY_RIGHT_AGENT not in", values, "compPropertyRightAgent");
			return (Criteria) this;
		}

		public Criteria andCompPropertyRightAgentBetween(String value1, String value2) {
			addCriterion("COMP_PROPERTY_RIGHT_AGENT between", value1, value2, "compPropertyRightAgent");
			return (Criteria) this;
		}

		public Criteria andCompPropertyRightAgentNotBetween(String value1, String value2) {
			addCriterion("COMP_PROPERTY_RIGHT_AGENT not between", value1, value2, "compPropertyRightAgent");
			return (Criteria) this;
		}

		public Criteria andTransferTimePredictIsNull() {
			addCriterion("TRANSFER_TIME_PREDICT is null");
			return (Criteria) this;
		}

		public Criteria andTransferTimePredictIsNotNull() {
			addCriterion("TRANSFER_TIME_PREDICT is not null");
			return (Criteria) this;
		}

		public Criteria andTransferTimePredictEqualTo(Date value) {
			addCriterion("TRANSFER_TIME_PREDICT =", value, "transferTimePredict");
			return (Criteria) this;
		}

		public Criteria andTransferTimePredictNotEqualTo(Date value) {
			addCriterion("TRANSFER_TIME_PREDICT <>", value, "transferTimePredict");
			return (Criteria) this;
		}

		public Criteria andTransferTimePredictGreaterThan(Date value) {
			addCriterion("TRANSFER_TIME_PREDICT >", value, "transferTimePredict");
			return (Criteria) this;
		}

		public Criteria andTransferTimePredictGreaterThanOrEqualTo(Date value) {
			addCriterion("TRANSFER_TIME_PREDICT >=", value, "transferTimePredict");
			return (Criteria) this;
		}

		public Criteria andTransferTimePredictLessThan(Date value) {
			addCriterion("TRANSFER_TIME_PREDICT <", value, "transferTimePredict");
			return (Criteria) this;
		}

		public Criteria andTransferTimePredictLessThanOrEqualTo(Date value) {
			addCriterion("TRANSFER_TIME_PREDICT <=", value, "transferTimePredict");
			return (Criteria) this;
		}

		public Criteria andTransferTimePredictIn(List<Date> values) {
			addCriterion("TRANSFER_TIME_PREDICT in", values, "transferTimePredict");
			return (Criteria) this;
		}

		public Criteria andTransferTimePredictNotIn(List<Date> values) {
			addCriterion("TRANSFER_TIME_PREDICT not in", values, "transferTimePredict");
			return (Criteria) this;
		}

		public Criteria andTransferTimePredictBetween(Date value1, Date value2) {
			addCriterion("TRANSFER_TIME_PREDICT between", value1, value2, "transferTimePredict");
			return (Criteria) this;
		}

		public Criteria andTransferTimePredictNotBetween(Date value1, Date value2) {
			addCriterion("TRANSFER_TIME_PREDICT not between", value1, value2, "transferTimePredict");
			return (Criteria) this;
		}

		public Criteria andHqPigeonholeFlagIsNull() {
			addCriterion("HQ_PIGEONHOLE_FLAG is null");
			return (Criteria) this;
		}

		public Criteria andHqPigeonholeFlagIsNotNull() {
			addCriterion("HQ_PIGEONHOLE_FLAG is not null");
			return (Criteria) this;
		}

		public Criteria andHqPigeonholeFlagEqualTo(Boolean value) {
			addCriterion("HQ_PIGEONHOLE_FLAG =", value, "hqPigeonholeFlag");
			return (Criteria) this;
		}

		public Criteria andHqPigeonholeFlagNotEqualTo(Boolean value) {
			addCriterion("HQ_PIGEONHOLE_FLAG <>", value, "hqPigeonholeFlag");
			return (Criteria) this;
		}

		public Criteria andHqPigeonholeFlagGreaterThan(Boolean value) {
			addCriterion("HQ_PIGEONHOLE_FLAG >", value, "hqPigeonholeFlag");
			return (Criteria) this;
		}

		public Criteria andHqPigeonholeFlagGreaterThanOrEqualTo(Boolean value) {
			addCriterion("HQ_PIGEONHOLE_FLAG >=", value, "hqPigeonholeFlag");
			return (Criteria) this;
		}

		public Criteria andHqPigeonholeFlagLessThan(Boolean value) {
			addCriterion("HQ_PIGEONHOLE_FLAG <", value, "hqPigeonholeFlag");
			return (Criteria) this;
		}

		public Criteria andHqPigeonholeFlagLessThanOrEqualTo(Boolean value) {
			addCriterion("HQ_PIGEONHOLE_FLAG <=", value, "hqPigeonholeFlag");
			return (Criteria) this;
		}

		public Criteria andHqPigeonholeFlagIn(List<Boolean> values) {
			addCriterion("HQ_PIGEONHOLE_FLAG in", values, "hqPigeonholeFlag");
			return (Criteria) this;
		}

		public Criteria andHqPigeonholeFlagNotIn(List<Boolean> values) {
			addCriterion("HQ_PIGEONHOLE_FLAG not in", values, "hqPigeonholeFlag");
			return (Criteria) this;
		}

		public Criteria andHqPigeonholeFlagBetween(Boolean value1, Boolean value2) {
			addCriterion("HQ_PIGEONHOLE_FLAG between", value1, value2, "hqPigeonholeFlag");
			return (Criteria) this;
		}

		public Criteria andHqPigeonholeFlagNotBetween(Boolean value1, Boolean value2) {
			addCriterion("HQ_PIGEONHOLE_FLAG not between", value1, value2, "hqPigeonholeFlag");
			return (Criteria) this;
		}

		public Criteria andBuildCityIdIsNull() {
			addCriterion("BUILD_CITY_ID is null");
			return (Criteria) this;
		}

		public Criteria andBuildCityIdIsNotNull() {
			addCriterion("BUILD_CITY_ID is not null");
			return (Criteria) this;
		}

		public Criteria andBuildCityIdEqualTo(Integer value) {
			addCriterion("BUILD_CITY_ID =", value, "buildCityId");
			return (Criteria) this;
		}

		public Criteria andBuildCityIdNotEqualTo(Integer value) {
			addCriterion("BUILD_CITY_ID <>", value, "buildCityId");
			return (Criteria) this;
		}

		public Criteria andBuildCityIdGreaterThan(Integer value) {
			addCriterion("BUILD_CITY_ID >", value, "buildCityId");
			return (Criteria) this;
		}

		public Criteria andBuildCityIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("BUILD_CITY_ID >=", value, "buildCityId");
			return (Criteria) this;
		}

		public Criteria andBuildCityIdLessThan(Integer value) {
			addCriterion("BUILD_CITY_ID <", value, "buildCityId");
			return (Criteria) this;
		}

		public Criteria andBuildCityIdLessThanOrEqualTo(Integer value) {
			addCriterion("BUILD_CITY_ID <=", value, "buildCityId");
			return (Criteria) this;
		}

		public Criteria andBuildCityIdIn(List<Integer> values) {
			addCriterion("BUILD_CITY_ID in", values, "buildCityId");
			return (Criteria) this;
		}

		public Criteria andBuildCityIdNotIn(List<Integer> values) {
			addCriterion("BUILD_CITY_ID not in", values, "buildCityId");
			return (Criteria) this;
		}

		public Criteria andBuildCityIdBetween(Integer value1, Integer value2) {
			addCriterion("BUILD_CITY_ID between", value1, value2, "buildCityId");
			return (Criteria) this;
		}

		public Criteria andBuildCityIdNotBetween(Integer value1, Integer value2) {
			addCriterion("BUILD_CITY_ID not between", value1, value2, "buildCityId");
			return (Criteria) this;
		}

		public Criteria andHouseInvoiceIsNull() {
			addCriterion("HOUSE_INVOICE is null");
			return (Criteria) this;
		}

		public Criteria andHouseInvoiceIsNotNull() {
			addCriterion("HOUSE_INVOICE is not null");
			return (Criteria) this;
		}

		public Criteria andHouseInvoiceEqualTo(Boolean value) {
			addCriterion("HOUSE_INVOICE =", value, "houseInvoice");
			return (Criteria) this;
		}

		public Criteria andHouseInvoiceNotEqualTo(Boolean value) {
			addCriterion("HOUSE_INVOICE <>", value, "houseInvoice");
			return (Criteria) this;
		}

		public Criteria andHouseInvoiceGreaterThan(Boolean value) {
			addCriterion("HOUSE_INVOICE >", value, "houseInvoice");
			return (Criteria) this;
		}

		public Criteria andHouseInvoiceGreaterThanOrEqualTo(Boolean value) {
			addCriterion("HOUSE_INVOICE >=", value, "houseInvoice");
			return (Criteria) this;
		}

		public Criteria andHouseInvoiceLessThan(Boolean value) {
			addCriterion("HOUSE_INVOICE <", value, "houseInvoice");
			return (Criteria) this;
		}

		public Criteria andHouseInvoiceLessThanOrEqualTo(Boolean value) {
			addCriterion("HOUSE_INVOICE <=", value, "houseInvoice");
			return (Criteria) this;
		}

		public Criteria andHouseInvoiceIn(List<Boolean> values) {
			addCriterion("HOUSE_INVOICE in", values, "houseInvoice");
			return (Criteria) this;
		}

		public Criteria andHouseInvoiceNotIn(List<Boolean> values) {
			addCriterion("HOUSE_INVOICE not in", values, "houseInvoice");
			return (Criteria) this;
		}

		public Criteria andHouseInvoiceBetween(Boolean value1, Boolean value2) {
			addCriterion("HOUSE_INVOICE between", value1, value2, "houseInvoice");
			return (Criteria) this;
		}

		public Criteria andHouseInvoiceNotBetween(Boolean value1, Boolean value2) {
			addCriterion("HOUSE_INVOICE not between", value1, value2, "houseInvoice");
			return (Criteria) this;
		}

		public Criteria andPigeonholeTimeIsNull() {
			addCriterion("PIGEONHOLE_TIME is null");
			return (Criteria) this;
		}

		public Criteria andPigeonholeTimeIsNotNull() {
			addCriterion("PIGEONHOLE_TIME is not null");
			return (Criteria) this;
		}

		public Criteria andPigeonholeTimeEqualTo(Date value) {
			addCriterion("PIGEONHOLE_TIME =", value, "pigeonholeTime");
			return (Criteria) this;
		}

		public Criteria andPigeonholeTimeNotEqualTo(Date value) {
			addCriterion("PIGEONHOLE_TIME <>", value, "pigeonholeTime");
			return (Criteria) this;
		}

		public Criteria andPigeonholeTimeGreaterThan(Date value) {
			addCriterion("PIGEONHOLE_TIME >", value, "pigeonholeTime");
			return (Criteria) this;
		}

		public Criteria andPigeonholeTimeGreaterThanOrEqualTo(Date value) {
			addCriterion("PIGEONHOLE_TIME >=", value, "pigeonholeTime");
			return (Criteria) this;
		}

		public Criteria andPigeonholeTimeLessThan(Date value) {
			addCriterion("PIGEONHOLE_TIME <", value, "pigeonholeTime");
			return (Criteria) this;
		}

		public Criteria andPigeonholeTimeLessThanOrEqualTo(Date value) {
			addCriterion("PIGEONHOLE_TIME <=", value, "pigeonholeTime");
			return (Criteria) this;
		}

		public Criteria andPigeonholeTimeIn(List<Date> values) {
			addCriterion("PIGEONHOLE_TIME in", values, "pigeonholeTime");
			return (Criteria) this;
		}

		public Criteria andPigeonholeTimeNotIn(List<Date> values) {
			addCriterion("PIGEONHOLE_TIME not in", values, "pigeonholeTime");
			return (Criteria) this;
		}

		public Criteria andPigeonholeTimeBetween(Date value1, Date value2) {
			addCriterion("PIGEONHOLE_TIME between", value1, value2, "pigeonholeTime");
			return (Criteria) this;
		}

		public Criteria andPigeonholeTimeNotBetween(Date value1, Date value2) {
			addCriterion("PIGEONHOLE_TIME not between", value1, value2, "pigeonholeTime");
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

		public Criteria andCrmCompIdIsNull() {
			addCriterion("CRM_COMP_ID is null");
			return (Criteria) this;
		}

		public Criteria andCrmCompIdIsNotNull() {
			addCriterion("CRM_COMP_ID is not null");
			return (Criteria) this;
		}

		public Criteria andCrmCompIdEqualTo(Integer value) {
			addCriterion("CRM_COMP_ID =", value, "crmCompId");
			return (Criteria) this;
		}

		public Criteria andCrmCompIdNotEqualTo(Integer value) {
			addCriterion("CRM_COMP_ID <>", value, "crmCompId");
			return (Criteria) this;
		}

		public Criteria andCrmCompIdGreaterThan(Integer value) {
			addCriterion("CRM_COMP_ID >", value, "crmCompId");
			return (Criteria) this;
		}

		public Criteria andCrmCompIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("CRM_COMP_ID >=", value, "crmCompId");
			return (Criteria) this;
		}

		public Criteria andCrmCompIdLessThan(Integer value) {
			addCriterion("CRM_COMP_ID <", value, "crmCompId");
			return (Criteria) this;
		}

		public Criteria andCrmCompIdLessThanOrEqualTo(Integer value) {
			addCriterion("CRM_COMP_ID <=", value, "crmCompId");
			return (Criteria) this;
		}

		public Criteria andCrmCompIdIn(List<Integer> values) {
			addCriterion("CRM_COMP_ID in", values, "crmCompId");
			return (Criteria) this;
		}

		public Criteria andCrmCompIdNotIn(List<Integer> values) {
			addCriterion("CRM_COMP_ID not in", values, "crmCompId");
			return (Criteria) this;
		}

		public Criteria andCrmCompIdBetween(Integer value1, Integer value2) {
			addCriterion("CRM_COMP_ID between", value1, value2, "crmCompId");
			return (Criteria) this;
		}

		public Criteria andCrmCompIdNotBetween(Integer value1, Integer value2) {
			addCriterion("CRM_COMP_ID not between", value1, value2, "crmCompId");
			return (Criteria) this;
		}

		public Criteria andVendorBankNameIsNull() {
			addCriterion("VENDOR_BANK_NAME is null");
			return (Criteria) this;
		}

		public Criteria andVendorBankNameIsNotNull() {
			addCriterion("VENDOR_BANK_NAME is not null");
			return (Criteria) this;
		}

		public Criteria andVendorBankNameEqualTo(String value) {
			addCriterion("VENDOR_BANK_NAME =", value, "vendorBankName");
			return (Criteria) this;
		}

		public Criteria andVendorBankNameNotEqualTo(String value) {
			addCriterion("VENDOR_BANK_NAME <>", value, "vendorBankName");
			return (Criteria) this;
		}

		public Criteria andVendorBankNameGreaterThan(String value) {
			addCriterion("VENDOR_BANK_NAME >", value, "vendorBankName");
			return (Criteria) this;
		}

		public Criteria andVendorBankNameGreaterThanOrEqualTo(String value) {
			addCriterion("VENDOR_BANK_NAME >=", value, "vendorBankName");
			return (Criteria) this;
		}

		public Criteria andVendorBankNameLessThan(String value) {
			addCriterion("VENDOR_BANK_NAME <", value, "vendorBankName");
			return (Criteria) this;
		}

		public Criteria andVendorBankNameLessThanOrEqualTo(String value) {
			addCriterion("VENDOR_BANK_NAME <=", value, "vendorBankName");
			return (Criteria) this;
		}

		public Criteria andVendorBankNameLike(String value) {
			addCriterion("VENDOR_BANK_NAME like", value, "vendorBankName");
			return (Criteria) this;
		}

		public Criteria andVendorBankNameNotLike(String value) {
			addCriterion("VENDOR_BANK_NAME not like", value, "vendorBankName");
			return (Criteria) this;
		}

		public Criteria andVendorBankNameIn(List<String> values) {
			addCriterion("VENDOR_BANK_NAME in", values, "vendorBankName");
			return (Criteria) this;
		}

		public Criteria andVendorBankNameNotIn(List<String> values) {
			addCriterion("VENDOR_BANK_NAME not in", values, "vendorBankName");
			return (Criteria) this;
		}

		public Criteria andVendorBankNameBetween(String value1, String value2) {
			addCriterion("VENDOR_BANK_NAME between", value1, value2, "vendorBankName");
			return (Criteria) this;
		}

		public Criteria andVendorBankNameNotBetween(String value1, String value2) {
			addCriterion("VENDOR_BANK_NAME not between", value1, value2, "vendorBankName");
			return (Criteria) this;
		}

		public Criteria andVendorBankCardNumberIsNull() {
			addCriterion("VENDOR_BANK_CARD_NUMBER is null");
			return (Criteria) this;
		}

		public Criteria andVendorBankCardNumberIsNotNull() {
			addCriterion("VENDOR_BANK_CARD_NUMBER is not null");
			return (Criteria) this;
		}

		public Criteria andVendorBankCardNumberEqualTo(String value) {
			addCriterion("VENDOR_BANK_CARD_NUMBER =", value, "vendorBankCardNumber");
			return (Criteria) this;
		}

		public Criteria andVendorBankCardNumberNotEqualTo(String value) {
			addCriterion("VENDOR_BANK_CARD_NUMBER <>", value, "vendorBankCardNumber");
			return (Criteria) this;
		}

		public Criteria andVendorBankCardNumberGreaterThan(String value) {
			addCriterion("VENDOR_BANK_CARD_NUMBER >", value, "vendorBankCardNumber");
			return (Criteria) this;
		}

		public Criteria andVendorBankCardNumberGreaterThanOrEqualTo(String value) {
			addCriterion("VENDOR_BANK_CARD_NUMBER >=", value, "vendorBankCardNumber");
			return (Criteria) this;
		}

		public Criteria andVendorBankCardNumberLessThan(String value) {
			addCriterion("VENDOR_BANK_CARD_NUMBER <", value, "vendorBankCardNumber");
			return (Criteria) this;
		}

		public Criteria andVendorBankCardNumberLessThanOrEqualTo(String value) {
			addCriterion("VENDOR_BANK_CARD_NUMBER <=", value, "vendorBankCardNumber");
			return (Criteria) this;
		}

		public Criteria andVendorBankCardNumberLike(String value) {
			addCriterion("VENDOR_BANK_CARD_NUMBER like", value, "vendorBankCardNumber");
			return (Criteria) this;
		}

		public Criteria andVendorBankCardNumberNotLike(String value) {
			addCriterion("VENDOR_BANK_CARD_NUMBER not like", value, "vendorBankCardNumber");
			return (Criteria) this;
		}

		public Criteria andVendorBankCardNumberIn(List<String> values) {
			addCriterion("VENDOR_BANK_CARD_NUMBER in", values, "vendorBankCardNumber");
			return (Criteria) this;
		}

		public Criteria andVendorBankCardNumberNotIn(List<String> values) {
			addCriterion("VENDOR_BANK_CARD_NUMBER not in", values, "vendorBankCardNumber");
			return (Criteria) this;
		}

		public Criteria andVendorBankCardNumberBetween(String value1, String value2) {
			addCriterion("VENDOR_BANK_CARD_NUMBER between", value1, value2, "vendorBankCardNumber");
			return (Criteria) this;
		}

		public Criteria andVendorBankCardNumberNotBetween(String value1, String value2) {
			addCriterion("VENDOR_BANK_CARD_NUMBER not between", value1, value2, "vendorBankCardNumber");
			return (Criteria) this;
		}

		public Criteria andTerritorialNatureIsNull() {
			addCriterion("TERRITORIAL_NATURE is null");
			return (Criteria) this;
		}

		public Criteria andTerritorialNatureIsNotNull() {
			addCriterion("TERRITORIAL_NATURE is not null");
			return (Criteria) this;
		}

		public Criteria andTerritorialNatureEqualTo(Byte value) {
			addCriterion("TERRITORIAL_NATURE =", value, "territorialNature");
			return (Criteria) this;
		}

		public Criteria andTerritorialNatureNotEqualTo(Byte value) {
			addCriterion("TERRITORIAL_NATURE <>", value, "territorialNature");
			return (Criteria) this;
		}

		public Criteria andTerritorialNatureGreaterThan(Byte value) {
			addCriterion("TERRITORIAL_NATURE >", value, "territorialNature");
			return (Criteria) this;
		}

		public Criteria andTerritorialNatureGreaterThanOrEqualTo(Byte value) {
			addCriterion("TERRITORIAL_NATURE >=", value, "territorialNature");
			return (Criteria) this;
		}

		public Criteria andTerritorialNatureLessThan(Byte value) {
			addCriterion("TERRITORIAL_NATURE <", value, "territorialNature");
			return (Criteria) this;
		}

		public Criteria andTerritorialNatureLessThanOrEqualTo(Byte value) {
			addCriterion("TERRITORIAL_NATURE <=", value, "territorialNature");
			return (Criteria) this;
		}

		public Criteria andTerritorialNatureIn(List<Byte> values) {
			addCriterion("TERRITORIAL_NATURE in", values, "territorialNature");
			return (Criteria) this;
		}

		public Criteria andTerritorialNatureNotIn(List<Byte> values) {
			addCriterion("TERRITORIAL_NATURE not in", values, "territorialNature");
			return (Criteria) this;
		}

		public Criteria andTerritorialNatureBetween(Byte value1, Byte value2) {
			addCriterion("TERRITORIAL_NATURE between", value1, value2, "territorialNature");
			return (Criteria) this;
		}

		public Criteria andTerritorialNatureNotBetween(Byte value1, Byte value2) {
			addCriterion("TERRITORIAL_NATURE not between", value1, value2, "territorialNature");
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

		public Criteria andMortgageBankEqualTo(Integer value) {
			addCriterion("MORTGAGE_BANK =", value, "mortgageBank");
			return (Criteria) this;
		}

		public Criteria andMortgageBankNotEqualTo(Integer value) {
			addCriterion("MORTGAGE_BANK <>", value, "mortgageBank");
			return (Criteria) this;
		}

		public Criteria andMortgageBankGreaterThan(Integer value) {
			addCriterion("MORTGAGE_BANK >", value, "mortgageBank");
			return (Criteria) this;
		}

		public Criteria andMortgageBankGreaterThanOrEqualTo(Integer value) {
			addCriterion("MORTGAGE_BANK >=", value, "mortgageBank");
			return (Criteria) this;
		}

		public Criteria andMortgageBankLessThan(Integer value) {
			addCriterion("MORTGAGE_BANK <", value, "mortgageBank");
			return (Criteria) this;
		}

		public Criteria andMortgageBankLessThanOrEqualTo(Integer value) {
			addCriterion("MORTGAGE_BANK <=", value, "mortgageBank");
			return (Criteria) this;
		}

		public Criteria andMortgageBankIn(List<Integer> values) {
			addCriterion("MORTGAGE_BANK in", values, "mortgageBank");
			return (Criteria) this;
		}

		public Criteria andMortgageBankNotIn(List<Integer> values) {
			addCriterion("MORTGAGE_BANK not in", values, "mortgageBank");
			return (Criteria) this;
		}

		public Criteria andMortgageBankBetween(Integer value1, Integer value2) {
			addCriterion("MORTGAGE_BANK between", value1, value2, "mortgageBank");
			return (Criteria) this;
		}

		public Criteria andMortgageBankNotBetween(Integer value1, Integer value2) {
			addCriterion("MORTGAGE_BANK not between", value1, value2, "mortgageBank");
			return (Criteria) this;
		}

		public Criteria andMortgageAmountIsNull() {
			addCriterion("MORTGAGE_AMOUNT is null");
			return (Criteria) this;
		}

		public Criteria andMortgageAmountIsNotNull() {
			addCriterion("MORTGAGE_AMOUNT is not null");
			return (Criteria) this;
		}

		public Criteria andMortgageAmountEqualTo(BigDecimal value) {
			addCriterion("MORTGAGE_AMOUNT =", value, "mortgageAmount");
			return (Criteria) this;
		}

		public Criteria andMortgageAmountNotEqualTo(BigDecimal value) {
			addCriterion("MORTGAGE_AMOUNT <>", value, "mortgageAmount");
			return (Criteria) this;
		}

		public Criteria andMortgageAmountGreaterThan(BigDecimal value) {
			addCriterion("MORTGAGE_AMOUNT >", value, "mortgageAmount");
			return (Criteria) this;
		}

		public Criteria andMortgageAmountGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("MORTGAGE_AMOUNT >=", value, "mortgageAmount");
			return (Criteria) this;
		}

		public Criteria andMortgageAmountLessThan(BigDecimal value) {
			addCriterion("MORTGAGE_AMOUNT <", value, "mortgageAmount");
			return (Criteria) this;
		}

		public Criteria andMortgageAmountLessThanOrEqualTo(BigDecimal value) {
			addCriterion("MORTGAGE_AMOUNT <=", value, "mortgageAmount");
			return (Criteria) this;
		}

		public Criteria andMortgageAmountIn(List<BigDecimal> values) {
			addCriterion("MORTGAGE_AMOUNT in", values, "mortgageAmount");
			return (Criteria) this;
		}

		public Criteria andMortgageAmountNotIn(List<BigDecimal> values) {
			addCriterion("MORTGAGE_AMOUNT not in", values, "mortgageAmount");
			return (Criteria) this;
		}

		public Criteria andMortgageAmountBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("MORTGAGE_AMOUNT between", value1, value2, "mortgageAmount");
			return (Criteria) this;
		}

		public Criteria andMortgageAmountNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("MORTGAGE_AMOUNT not between", value1, value2, "mortgageAmount");
			return (Criteria) this;
		}

		public Criteria andMortgageBankNameIsNull() {
			addCriterion("MORTGAGE_BANK_NAME is null");
			return (Criteria) this;
		}

		public Criteria andMortgageBankNameIsNotNull() {
			addCriterion("MORTGAGE_BANK_NAME is not null");
			return (Criteria) this;
		}

		public Criteria andMortgageBankNameEqualTo(String value) {
			addCriterion("MORTGAGE_BANK_NAME =", value, "mortgageBankName");
			return (Criteria) this;
		}

		public Criteria andMortgageBankNameNotEqualTo(String value) {
			addCriterion("MORTGAGE_BANK_NAME <>", value, "mortgageBankName");
			return (Criteria) this;
		}

		public Criteria andMortgageBankNameGreaterThan(String value) {
			addCriterion("MORTGAGE_BANK_NAME >", value, "mortgageBankName");
			return (Criteria) this;
		}

		public Criteria andMortgageBankNameGreaterThanOrEqualTo(String value) {
			addCriterion("MORTGAGE_BANK_NAME >=", value, "mortgageBankName");
			return (Criteria) this;
		}

		public Criteria andMortgageBankNameLessThan(String value) {
			addCriterion("MORTGAGE_BANK_NAME <", value, "mortgageBankName");
			return (Criteria) this;
		}

		public Criteria andMortgageBankNameLessThanOrEqualTo(String value) {
			addCriterion("MORTGAGE_BANK_NAME <=", value, "mortgageBankName");
			return (Criteria) this;
		}

		public Criteria andMortgageBankNameLike(String value) {
			addCriterion("MORTGAGE_BANK_NAME like", value, "mortgageBankName");
			return (Criteria) this;
		}

		public Criteria andMortgageBankNameNotLike(String value) {
			addCriterion("MORTGAGE_BANK_NAME not like", value, "mortgageBankName");
			return (Criteria) this;
		}

		public Criteria andMortgageBankNameIn(List<String> values) {
			addCriterion("MORTGAGE_BANK_NAME in", values, "mortgageBankName");
			return (Criteria) this;
		}

		public Criteria andMortgageBankNameNotIn(List<String> values) {
			addCriterion("MORTGAGE_BANK_NAME not in", values, "mortgageBankName");
			return (Criteria) this;
		}

		public Criteria andMortgageBankNameBetween(String value1, String value2) {
			addCriterion("MORTGAGE_BANK_NAME between", value1, value2, "mortgageBankName");
			return (Criteria) this;
		}

		public Criteria andMortgageBankNameNotBetween(String value1, String value2) {
			addCriterion("MORTGAGE_BANK_NAME not between", value1, value2, "mortgageBankName");
			return (Criteria) this;
		}

		public Criteria andMortgageAssessmentNameIsNull() {
			addCriterion("MORTGAGE_ASSESSMENT_NAME is null");
			return (Criteria) this;
		}

		public Criteria andMortgageAssessmentNameIsNotNull() {
			addCriterion("MORTGAGE_ASSESSMENT_NAME is not null");
			return (Criteria) this;
		}

		public Criteria andMortgageAssessmentNameEqualTo(String value) {
			addCriterion("MORTGAGE_ASSESSMENT_NAME =", value, "mortgageAssessmentName");
			return (Criteria) this;
		}

		public Criteria andMortgageAssessmentNameNotEqualTo(String value) {
			addCriterion("MORTGAGE_ASSESSMENT_NAME <>", value, "mortgageAssessmentName");
			return (Criteria) this;
		}

		public Criteria andMortgageAssessmentNameGreaterThan(String value) {
			addCriterion("MORTGAGE_ASSESSMENT_NAME >", value, "mortgageAssessmentName");
			return (Criteria) this;
		}

		public Criteria andMortgageAssessmentNameGreaterThanOrEqualTo(String value) {
			addCriterion("MORTGAGE_ASSESSMENT_NAME >=", value, "mortgageAssessmentName");
			return (Criteria) this;
		}

		public Criteria andMortgageAssessmentNameLessThan(String value) {
			addCriterion("MORTGAGE_ASSESSMENT_NAME <", value, "mortgageAssessmentName");
			return (Criteria) this;
		}

		public Criteria andMortgageAssessmentNameLessThanOrEqualTo(String value) {
			addCriterion("MORTGAGE_ASSESSMENT_NAME <=", value, "mortgageAssessmentName");
			return (Criteria) this;
		}

		public Criteria andMortgageAssessmentNameLike(String value) {
			addCriterion("MORTGAGE_ASSESSMENT_NAME like", value, "mortgageAssessmentName");
			return (Criteria) this;
		}

		public Criteria andMortgageAssessmentNameNotLike(String value) {
			addCriterion("MORTGAGE_ASSESSMENT_NAME not like", value, "mortgageAssessmentName");
			return (Criteria) this;
		}

		public Criteria andMortgageAssessmentNameIn(List<String> values) {
			addCriterion("MORTGAGE_ASSESSMENT_NAME in", values, "mortgageAssessmentName");
			return (Criteria) this;
		}

		public Criteria andMortgageAssessmentNameNotIn(List<String> values) {
			addCriterion("MORTGAGE_ASSESSMENT_NAME not in", values, "mortgageAssessmentName");
			return (Criteria) this;
		}

		public Criteria andMortgageAssessmentNameBetween(String value1, String value2) {
			addCriterion("MORTGAGE_ASSESSMENT_NAME between", value1, value2, "mortgageAssessmentName");
			return (Criteria) this;
		}

		public Criteria andMortgageAssessmentNameNotBetween(String value1, String value2) {
			addCriterion("MORTGAGE_ASSESSMENT_NAME not between", value1, value2, "mortgageAssessmentName");
			return (Criteria) this;
		}

		public Criteria andMortgageAssessmentIsNull() {
			addCriterion("MORTGAGE_ASSESSMENT is null");
			return (Criteria) this;
		}

		public Criteria andMortgageAssessmentIsNotNull() {
			addCriterion("MORTGAGE_ASSESSMENT is not null");
			return (Criteria) this;
		}

		public Criteria andMortgageAssessmentEqualTo(Integer value) {
			addCriterion("MORTGAGE_ASSESSMENT =", value, "mortgageAssessment");
			return (Criteria) this;
		}

		public Criteria andMortgageAssessmentNotEqualTo(Integer value) {
			addCriterion("MORTGAGE_ASSESSMENT <>", value, "mortgageAssessment");
			return (Criteria) this;
		}

		public Criteria andMortgageAssessmentGreaterThan(Integer value) {
			addCriterion("MORTGAGE_ASSESSMENT >", value, "mortgageAssessment");
			return (Criteria) this;
		}

		public Criteria andMortgageAssessmentGreaterThanOrEqualTo(Integer value) {
			addCriterion("MORTGAGE_ASSESSMENT >=", value, "mortgageAssessment");
			return (Criteria) this;
		}

		public Criteria andMortgageAssessmentLessThan(Integer value) {
			addCriterion("MORTGAGE_ASSESSMENT <", value, "mortgageAssessment");
			return (Criteria) this;
		}

		public Criteria andMortgageAssessmentLessThanOrEqualTo(Integer value) {
			addCriterion("MORTGAGE_ASSESSMENT <=", value, "mortgageAssessment");
			return (Criteria) this;
		}

		public Criteria andMortgageAssessmentIn(List<Integer> values) {
			addCriterion("MORTGAGE_ASSESSMENT in", values, "mortgageAssessment");
			return (Criteria) this;
		}

		public Criteria andMortgageAssessmentNotIn(List<Integer> values) {
			addCriterion("MORTGAGE_ASSESSMENT not in", values, "mortgageAssessment");
			return (Criteria) this;
		}

		public Criteria andMortgageAssessmentBetween(Integer value1, Integer value2) {
			addCriterion("MORTGAGE_ASSESSMENT between", value1, value2, "mortgageAssessment");
			return (Criteria) this;
		}

		public Criteria andMortgageAssessmentNotBetween(Integer value1, Integer value2) {
			addCriterion("MORTGAGE_ASSESSMENT not between", value1, value2, "mortgageAssessment");
			return (Criteria) this;
		}

		public Criteria andReceivableTimeIsNull() {
			addCriterion("RECEIVABLE_TIME is null");
			return (Criteria) this;
		}

		public Criteria andReceivableTimeIsNotNull() {
			addCriterion("RECEIVABLE_TIME is not null");
			return (Criteria) this;
		}

		public Criteria andReceivableTimeEqualTo(Date value) {
			addCriterion("RECEIVABLE_TIME =", value, "receivableTime");
			return (Criteria) this;
		}

		public Criteria andReceivableTimeNotEqualTo(Date value) {
			addCriterion("RECEIVABLE_TIME <>", value, "receivableTime");
			return (Criteria) this;
		}

		public Criteria andReceivableTimeGreaterThan(Date value) {
			addCriterion("RECEIVABLE_TIME >", value, "receivableTime");
			return (Criteria) this;
		}

		public Criteria andReceivableTimeGreaterThanOrEqualTo(Date value) {
			addCriterion("RECEIVABLE_TIME >=", value, "receivableTime");
			return (Criteria) this;
		}

		public Criteria andReceivableTimeLessThan(Date value) {
			addCriterion("RECEIVABLE_TIME <", value, "receivableTime");
			return (Criteria) this;
		}

		public Criteria andReceivableTimeLessThanOrEqualTo(Date value) {
			addCriterion("RECEIVABLE_TIME <=", value, "receivableTime");
			return (Criteria) this;
		}

		public Criteria andReceivableTimeIn(List<Date> values) {
			addCriterion("RECEIVABLE_TIME in", values, "receivableTime");
			return (Criteria) this;
		}

		public Criteria andReceivableTimeNotIn(List<Date> values) {
			addCriterion("RECEIVABLE_TIME not in", values, "receivableTime");
			return (Criteria) this;
		}

		public Criteria andReceivableTimeBetween(Date value1, Date value2) {
			addCriterion("RECEIVABLE_TIME between", value1, value2, "receivableTime");
			return (Criteria) this;
		}

		public Criteria andReceivableTimeNotBetween(Date value1, Date value2) {
			addCriterion("RECEIVABLE_TIME not between", value1, value2, "receivableTime");
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