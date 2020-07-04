package com.myfun.repository.admindb.po;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;

public class AdminYoujiaReserveExample {
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
	public AdminYoujiaReserveExample() {
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

		public Criteria andYoujiaUserIdIsNull() {
			addCriterion("YOUJIA_USER_ID is null");
			return (Criteria) this;
		}

		public Criteria andYoujiaUserIdIsNotNull() {
			addCriterion("YOUJIA_USER_ID is not null");
			return (Criteria) this;
		}

		public Criteria andYoujiaUserIdEqualTo(Integer value) {
			addCriterion("YOUJIA_USER_ID =", value, "youjiaUserId");
			return (Criteria) this;
		}

		public Criteria andYoujiaUserIdNotEqualTo(Integer value) {
			addCriterion("YOUJIA_USER_ID <>", value, "youjiaUserId");
			return (Criteria) this;
		}

		public Criteria andYoujiaUserIdGreaterThan(Integer value) {
			addCriterion("YOUJIA_USER_ID >", value, "youjiaUserId");
			return (Criteria) this;
		}

		public Criteria andYoujiaUserIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("YOUJIA_USER_ID >=", value, "youjiaUserId");
			return (Criteria) this;
		}

		public Criteria andYoujiaUserIdLessThan(Integer value) {
			addCriterion("YOUJIA_USER_ID <", value, "youjiaUserId");
			return (Criteria) this;
		}

		public Criteria andYoujiaUserIdLessThanOrEqualTo(Integer value) {
			addCriterion("YOUJIA_USER_ID <=", value, "youjiaUserId");
			return (Criteria) this;
		}

		public Criteria andYoujiaUserIdIn(List<Integer> values) {
			addCriterion("YOUJIA_USER_ID in", values, "youjiaUserId");
			return (Criteria) this;
		}

		public Criteria andYoujiaUserIdNotIn(List<Integer> values) {
			addCriterion("YOUJIA_USER_ID not in", values, "youjiaUserId");
			return (Criteria) this;
		}

		public Criteria andYoujiaUserIdBetween(Integer value1, Integer value2) {
			addCriterion("YOUJIA_USER_ID between", value1, value2, "youjiaUserId");
			return (Criteria) this;
		}

		public Criteria andYoujiaUserIdNotBetween(Integer value1, Integer value2) {
			addCriterion("YOUJIA_USER_ID not between", value1, value2, "youjiaUserId");
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

		public Criteria andReserveNameIsNull() {
			addCriterion("RESERVE_NAME is null");
			return (Criteria) this;
		}

		public Criteria andReserveNameIsNotNull() {
			addCriterion("RESERVE_NAME is not null");
			return (Criteria) this;
		}

		public Criteria andReserveNameEqualTo(String value) {
			addCriterion("RESERVE_NAME =", value, "reserveName");
			return (Criteria) this;
		}

		public Criteria andReserveNameNotEqualTo(String value) {
			addCriterion("RESERVE_NAME <>", value, "reserveName");
			return (Criteria) this;
		}

		public Criteria andReserveNameGreaterThan(String value) {
			addCriterion("RESERVE_NAME >", value, "reserveName");
			return (Criteria) this;
		}

		public Criteria andReserveNameGreaterThanOrEqualTo(String value) {
			addCriterion("RESERVE_NAME >=", value, "reserveName");
			return (Criteria) this;
		}

		public Criteria andReserveNameLessThan(String value) {
			addCriterion("RESERVE_NAME <", value, "reserveName");
			return (Criteria) this;
		}

		public Criteria andReserveNameLessThanOrEqualTo(String value) {
			addCriterion("RESERVE_NAME <=", value, "reserveName");
			return (Criteria) this;
		}

		public Criteria andReserveNameLike(String value) {
			addCriterion("RESERVE_NAME like", value, "reserveName");
			return (Criteria) this;
		}

		public Criteria andReserveNameNotLike(String value) {
			addCriterion("RESERVE_NAME not like", value, "reserveName");
			return (Criteria) this;
		}

		public Criteria andReserveNameIn(List<String> values) {
			addCriterion("RESERVE_NAME in", values, "reserveName");
			return (Criteria) this;
		}

		public Criteria andReserveNameNotIn(List<String> values) {
			addCriterion("RESERVE_NAME not in", values, "reserveName");
			return (Criteria) this;
		}

		public Criteria andReserveNameBetween(String value1, String value2) {
			addCriterion("RESERVE_NAME between", value1, value2, "reserveName");
			return (Criteria) this;
		}

		public Criteria andReserveNameNotBetween(String value1, String value2) {
			addCriterion("RESERVE_NAME not between", value1, value2, "reserveName");
			return (Criteria) this;
		}

		public Criteria andReservePhoneIsNull() {
			addCriterion("RESERVE_PHONE is null");
			return (Criteria) this;
		}

		public Criteria andReservePhoneIsNotNull() {
			addCriterion("RESERVE_PHONE is not null");
			return (Criteria) this;
		}

		public Criteria andReservePhoneEqualTo(String value) {
			addCriterion("RESERVE_PHONE =", value, "reservePhone");
			return (Criteria) this;
		}

		public Criteria andReservePhoneNotEqualTo(String value) {
			addCriterion("RESERVE_PHONE <>", value, "reservePhone");
			return (Criteria) this;
		}

		public Criteria andReservePhoneGreaterThan(String value) {
			addCriterion("RESERVE_PHONE >", value, "reservePhone");
			return (Criteria) this;
		}

		public Criteria andReservePhoneGreaterThanOrEqualTo(String value) {
			addCriterion("RESERVE_PHONE >=", value, "reservePhone");
			return (Criteria) this;
		}

		public Criteria andReservePhoneLessThan(String value) {
			addCriterion("RESERVE_PHONE <", value, "reservePhone");
			return (Criteria) this;
		}

		public Criteria andReservePhoneLessThanOrEqualTo(String value) {
			addCriterion("RESERVE_PHONE <=", value, "reservePhone");
			return (Criteria) this;
		}

		public Criteria andReservePhoneLike(String value) {
			addCriterion("RESERVE_PHONE like", value, "reservePhone");
			return (Criteria) this;
		}

		public Criteria andReservePhoneNotLike(String value) {
			addCriterion("RESERVE_PHONE not like", value, "reservePhone");
			return (Criteria) this;
		}

		public Criteria andReservePhoneIn(List<String> values) {
			addCriterion("RESERVE_PHONE in", values, "reservePhone");
			return (Criteria) this;
		}

		public Criteria andReservePhoneNotIn(List<String> values) {
			addCriterion("RESERVE_PHONE not in", values, "reservePhone");
			return (Criteria) this;
		}

		public Criteria andReservePhoneBetween(String value1, String value2) {
			addCriterion("RESERVE_PHONE between", value1, value2, "reservePhone");
			return (Criteria) this;
		}

		public Criteria andReservePhoneNotBetween(String value1, String value2) {
			addCriterion("RESERVE_PHONE not between", value1, value2, "reservePhone");
			return (Criteria) this;
		}

		public Criteria andReserveTimeIsNull() {
			addCriterion("RESERVE_TIME is null");
			return (Criteria) this;
		}

		public Criteria andReserveTimeIsNotNull() {
			addCriterion("RESERVE_TIME is not null");
			return (Criteria) this;
		}

		public Criteria andReserveTimeEqualTo(Date value) {
			addCriterion("RESERVE_TIME =", value, "reserveTime");
			return (Criteria) this;
		}

		public Criteria andReserveTimeNotEqualTo(Date value) {
			addCriterion("RESERVE_TIME <>", value, "reserveTime");
			return (Criteria) this;
		}

		public Criteria andReserveTimeGreaterThan(Date value) {
			addCriterion("RESERVE_TIME >", value, "reserveTime");
			return (Criteria) this;
		}

		public Criteria andReserveTimeGreaterThanOrEqualTo(Date value) {
			addCriterion("RESERVE_TIME >=", value, "reserveTime");
			return (Criteria) this;
		}

		public Criteria andReserveTimeLessThan(Date value) {
			addCriterion("RESERVE_TIME <", value, "reserveTime");
			return (Criteria) this;
		}

		public Criteria andReserveTimeLessThanOrEqualTo(Date value) {
			addCriterion("RESERVE_TIME <=", value, "reserveTime");
			return (Criteria) this;
		}

		public Criteria andReserveTimeIn(List<Date> values) {
			addCriterion("RESERVE_TIME in", values, "reserveTime");
			return (Criteria) this;
		}

		public Criteria andReserveTimeNotIn(List<Date> values) {
			addCriterion("RESERVE_TIME not in", values, "reserveTime");
			return (Criteria) this;
		}

		public Criteria andReserveTimeBetween(Date value1, Date value2) {
			addCriterion("RESERVE_TIME between", value1, value2, "reserveTime");
			return (Criteria) this;
		}

		public Criteria andReserveTimeNotBetween(Date value1, Date value2) {
			addCriterion("RESERVE_TIME not between", value1, value2, "reserveTime");
			return (Criteria) this;
		}

		public Criteria andNoteIsNull() {
			addCriterion("NOTE is null");
			return (Criteria) this;
		}

		public Criteria andNoteIsNotNull() {
			addCriterion("NOTE is not null");
			return (Criteria) this;
		}

		public Criteria andNoteEqualTo(String value) {
			addCriterion("NOTE =", value, "note");
			return (Criteria) this;
		}

		public Criteria andNoteNotEqualTo(String value) {
			addCriterion("NOTE <>", value, "note");
			return (Criteria) this;
		}

		public Criteria andNoteGreaterThan(String value) {
			addCriterion("NOTE >", value, "note");
			return (Criteria) this;
		}

		public Criteria andNoteGreaterThanOrEqualTo(String value) {
			addCriterion("NOTE >=", value, "note");
			return (Criteria) this;
		}

		public Criteria andNoteLessThan(String value) {
			addCriterion("NOTE <", value, "note");
			return (Criteria) this;
		}

		public Criteria andNoteLessThanOrEqualTo(String value) {
			addCriterion("NOTE <=", value, "note");
			return (Criteria) this;
		}

		public Criteria andNoteLike(String value) {
			addCriterion("NOTE like", value, "note");
			return (Criteria) this;
		}

		public Criteria andNoteNotLike(String value) {
			addCriterion("NOTE not like", value, "note");
			return (Criteria) this;
		}

		public Criteria andNoteIn(List<String> values) {
			addCriterion("NOTE in", values, "note");
			return (Criteria) this;
		}

		public Criteria andNoteNotIn(List<String> values) {
			addCriterion("NOTE not in", values, "note");
			return (Criteria) this;
		}

		public Criteria andNoteBetween(String value1, String value2) {
			addCriterion("NOTE between", value1, value2, "note");
			return (Criteria) this;
		}

		public Criteria andNoteNotBetween(String value1, String value2) {
			addCriterion("NOTE not between", value1, value2, "note");
			return (Criteria) this;
		}

		public Criteria andReserveFromIsNull() {
			addCriterion("RESERVE_FROM is null");
			return (Criteria) this;
		}

		public Criteria andReserveFromIsNotNull() {
			addCriterion("RESERVE_FROM is not null");
			return (Criteria) this;
		}

		public Criteria andReserveFromEqualTo(Byte value) {
			addCriterion("RESERVE_FROM =", value, "reserveFrom");
			return (Criteria) this;
		}

		public Criteria andReserveFromNotEqualTo(Byte value) {
			addCriterion("RESERVE_FROM <>", value, "reserveFrom");
			return (Criteria) this;
		}

		public Criteria andReserveFromGreaterThan(Byte value) {
			addCriterion("RESERVE_FROM >", value, "reserveFrom");
			return (Criteria) this;
		}

		public Criteria andReserveFromGreaterThanOrEqualTo(Byte value) {
			addCriterion("RESERVE_FROM >=", value, "reserveFrom");
			return (Criteria) this;
		}

		public Criteria andReserveFromLessThan(Byte value) {
			addCriterion("RESERVE_FROM <", value, "reserveFrom");
			return (Criteria) this;
		}

		public Criteria andReserveFromLessThanOrEqualTo(Byte value) {
			addCriterion("RESERVE_FROM <=", value, "reserveFrom");
			return (Criteria) this;
		}

		public Criteria andReserveFromIn(List<Byte> values) {
			addCriterion("RESERVE_FROM in", values, "reserveFrom");
			return (Criteria) this;
		}

		public Criteria andReserveFromNotIn(List<Byte> values) {
			addCriterion("RESERVE_FROM not in", values, "reserveFrom");
			return (Criteria) this;
		}

		public Criteria andReserveFromBetween(Byte value1, Byte value2) {
			addCriterion("RESERVE_FROM between", value1, value2, "reserveFrom");
			return (Criteria) this;
		}

		public Criteria andReserveFromNotBetween(Byte value1, Byte value2) {
			addCriterion("RESERVE_FROM not between", value1, value2, "reserveFrom");
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

		public Criteria andIsDkIsNull() {
			addCriterion("IS_DK is null");
			return (Criteria) this;
		}

		public Criteria andIsDkIsNotNull() {
			addCriterion("IS_DK is not null");
			return (Criteria) this;
		}

		public Criteria andIsDkEqualTo(Byte value) {
			addCriterion("IS_DK =", value, "isDk");
			return (Criteria) this;
		}

		public Criteria andIsDkNotEqualTo(Byte value) {
			addCriterion("IS_DK <>", value, "isDk");
			return (Criteria) this;
		}

		public Criteria andIsDkGreaterThan(Byte value) {
			addCriterion("IS_DK >", value, "isDk");
			return (Criteria) this;
		}

		public Criteria andIsDkGreaterThanOrEqualTo(Byte value) {
			addCriterion("IS_DK >=", value, "isDk");
			return (Criteria) this;
		}

		public Criteria andIsDkLessThan(Byte value) {
			addCriterion("IS_DK <", value, "isDk");
			return (Criteria) this;
		}

		public Criteria andIsDkLessThanOrEqualTo(Byte value) {
			addCriterion("IS_DK <=", value, "isDk");
			return (Criteria) this;
		}

		public Criteria andIsDkIn(List<Byte> values) {
			addCriterion("IS_DK in", values, "isDk");
			return (Criteria) this;
		}

		public Criteria andIsDkNotIn(List<Byte> values) {
			addCriterion("IS_DK not in", values, "isDk");
			return (Criteria) this;
		}

		public Criteria andIsDkBetween(Byte value1, Byte value2) {
			addCriterion("IS_DK between", value1, value2, "isDk");
			return (Criteria) this;
		}

		public Criteria andIsDkNotBetween(Byte value1, Byte value2) {
			addCriterion("IS_DK not between", value1, value2, "isDk");
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