package com.myfun.repository.erpdb.po;

import com.myfun.repository.support.generator.shard.ShardDb;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ErpFunBlackListExample extends ShardDb {
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
	public ErpFunBlackListExample() {
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

		public Criteria andCreateUidIsNull() {
			addCriterion("CREATE_UID is null");
			return (Criteria) this;
		}

		public Criteria andCreateUidIsNotNull() {
			addCriterion("CREATE_UID is not null");
			return (Criteria) this;
		}

		public Criteria andCreateUidEqualTo(Integer value) {
			addCriterion("CREATE_UID =", value, "createUid");
			return (Criteria) this;
		}

		public Criteria andCreateUidNotEqualTo(Integer value) {
			addCriterion("CREATE_UID <>", value, "createUid");
			return (Criteria) this;
		}

		public Criteria andCreateUidGreaterThan(Integer value) {
			addCriterion("CREATE_UID >", value, "createUid");
			return (Criteria) this;
		}

		public Criteria andCreateUidGreaterThanOrEqualTo(Integer value) {
			addCriterion("CREATE_UID >=", value, "createUid");
			return (Criteria) this;
		}

		public Criteria andCreateUidLessThan(Integer value) {
			addCriterion("CREATE_UID <", value, "createUid");
			return (Criteria) this;
		}

		public Criteria andCreateUidLessThanOrEqualTo(Integer value) {
			addCriterion("CREATE_UID <=", value, "createUid");
			return (Criteria) this;
		}

		public Criteria andCreateUidIn(List<Integer> values) {
			addCriterion("CREATE_UID in", values, "createUid");
			return (Criteria) this;
		}

		public Criteria andCreateUidNotIn(List<Integer> values) {
			addCriterion("CREATE_UID not in", values, "createUid");
			return (Criteria) this;
		}

		public Criteria andCreateUidBetween(Integer value1, Integer value2) {
			addCriterion("CREATE_UID between", value1, value2, "createUid");
			return (Criteria) this;
		}

		public Criteria andCreateUidNotBetween(Integer value1, Integer value2) {
			addCriterion("CREATE_UID not between", value1, value2, "createUid");
			return (Criteria) this;
		}

		public Criteria andUserNameIsNull() {
			addCriterion("USER_NAME is null");
			return (Criteria) this;
		}

		public Criteria andUserNameIsNotNull() {
			addCriterion("USER_NAME is not null");
			return (Criteria) this;
		}

		public Criteria andUserNameEqualTo(String value) {
			addCriterion("USER_NAME =", value, "userName");
			return (Criteria) this;
		}

		public Criteria andUserNameNotEqualTo(String value) {
			addCriterion("USER_NAME <>", value, "userName");
			return (Criteria) this;
		}

		public Criteria andUserNameGreaterThan(String value) {
			addCriterion("USER_NAME >", value, "userName");
			return (Criteria) this;
		}

		public Criteria andUserNameGreaterThanOrEqualTo(String value) {
			addCriterion("USER_NAME >=", value, "userName");
			return (Criteria) this;
		}

		public Criteria andUserNameLessThan(String value) {
			addCriterion("USER_NAME <", value, "userName");
			return (Criteria) this;
		}

		public Criteria andUserNameLessThanOrEqualTo(String value) {
			addCriterion("USER_NAME <=", value, "userName");
			return (Criteria) this;
		}

		public Criteria andUserNameLike(String value) {
			addCriterion("USER_NAME like", value, "userName");
			return (Criteria) this;
		}

		public Criteria andUserNameNotLike(String value) {
			addCriterion("USER_NAME not like", value, "userName");
			return (Criteria) this;
		}

		public Criteria andUserNameIn(List<String> values) {
			addCriterion("USER_NAME in", values, "userName");
			return (Criteria) this;
		}

		public Criteria andUserNameNotIn(List<String> values) {
			addCriterion("USER_NAME not in", values, "userName");
			return (Criteria) this;
		}

		public Criteria andUserNameBetween(String value1, String value2) {
			addCriterion("USER_NAME between", value1, value2, "userName");
			return (Criteria) this;
		}

		public Criteria andUserNameNotBetween(String value1, String value2) {
			addCriterion("USER_NAME not between", value1, value2, "userName");
			return (Criteria) this;
		}

		public Criteria andUserSexIsNull() {
			addCriterion("USER_SEX is null");
			return (Criteria) this;
		}

		public Criteria andUserSexIsNotNull() {
			addCriterion("USER_SEX is not null");
			return (Criteria) this;
		}

		public Criteria andUserSexEqualTo(Byte value) {
			addCriterion("USER_SEX =", value, "userSex");
			return (Criteria) this;
		}

		public Criteria andUserSexNotEqualTo(Byte value) {
			addCriterion("USER_SEX <>", value, "userSex");
			return (Criteria) this;
		}

		public Criteria andUserSexGreaterThan(Byte value) {
			addCriterion("USER_SEX >", value, "userSex");
			return (Criteria) this;
		}

		public Criteria andUserSexGreaterThanOrEqualTo(Byte value) {
			addCriterion("USER_SEX >=", value, "userSex");
			return (Criteria) this;
		}

		public Criteria andUserSexLessThan(Byte value) {
			addCriterion("USER_SEX <", value, "userSex");
			return (Criteria) this;
		}

		public Criteria andUserSexLessThanOrEqualTo(Byte value) {
			addCriterion("USER_SEX <=", value, "userSex");
			return (Criteria) this;
		}

		public Criteria andUserSexIn(List<Byte> values) {
			addCriterion("USER_SEX in", values, "userSex");
			return (Criteria) this;
		}

		public Criteria andUserSexNotIn(List<Byte> values) {
			addCriterion("USER_SEX not in", values, "userSex");
			return (Criteria) this;
		}

		public Criteria andUserSexBetween(Byte value1, Byte value2) {
			addCriterion("USER_SEX between", value1, value2, "userSex");
			return (Criteria) this;
		}

		public Criteria andUserSexNotBetween(Byte value1, Byte value2) {
			addCriterion("USER_SEX not between", value1, value2, "userSex");
			return (Criteria) this;
		}

		public Criteria andPhone1IsNull() {
			addCriterion("PHONE1 is null");
			return (Criteria) this;
		}

		public Criteria andPhone1IsNotNull() {
			addCriterion("PHONE1 is not null");
			return (Criteria) this;
		}

		public Criteria andPhone1EqualTo(String value) {
			addCriterion("PHONE1 =", value, "phone1");
			return (Criteria) this;
		}

		public Criteria andPhone1NotEqualTo(String value) {
			addCriterion("PHONE1 <>", value, "phone1");
			return (Criteria) this;
		}

		public Criteria andPhone1GreaterThan(String value) {
			addCriterion("PHONE1 >", value, "phone1");
			return (Criteria) this;
		}

		public Criteria andPhone1GreaterThanOrEqualTo(String value) {
			addCriterion("PHONE1 >=", value, "phone1");
			return (Criteria) this;
		}

		public Criteria andPhone1LessThan(String value) {
			addCriterion("PHONE1 <", value, "phone1");
			return (Criteria) this;
		}

		public Criteria andPhone1LessThanOrEqualTo(String value) {
			addCriterion("PHONE1 <=", value, "phone1");
			return (Criteria) this;
		}

		public Criteria andPhone1Like(String value) {
			addCriterion("PHONE1 like", value, "phone1");
			return (Criteria) this;
		}

		public Criteria andPhone1NotLike(String value) {
			addCriterion("PHONE1 not like", value, "phone1");
			return (Criteria) this;
		}

		public Criteria andPhone1In(List<String> values) {
			addCriterion("PHONE1 in", values, "phone1");
			return (Criteria) this;
		}

		public Criteria andPhone1NotIn(List<String> values) {
			addCriterion("PHONE1 not in", values, "phone1");
			return (Criteria) this;
		}

		public Criteria andPhone1Between(String value1, String value2) {
			addCriterion("PHONE1 between", value1, value2, "phone1");
			return (Criteria) this;
		}

		public Criteria andPhone1NotBetween(String value1, String value2) {
			addCriterion("PHONE1 not between", value1, value2, "phone1");
			return (Criteria) this;
		}

		public Criteria andPhoneType1IsNull() {
			addCriterion("PHONE_TYPE1 is null");
			return (Criteria) this;
		}

		public Criteria andPhoneType1IsNotNull() {
			addCriterion("PHONE_TYPE1 is not null");
			return (Criteria) this;
		}

		public Criteria andPhoneType1EqualTo(Byte value) {
			addCriterion("PHONE_TYPE1 =", value, "phoneType1");
			return (Criteria) this;
		}

		public Criteria andPhoneType1NotEqualTo(Byte value) {
			addCriterion("PHONE_TYPE1 <>", value, "phoneType1");
			return (Criteria) this;
		}

		public Criteria andPhoneType1GreaterThan(Byte value) {
			addCriterion("PHONE_TYPE1 >", value, "phoneType1");
			return (Criteria) this;
		}

		public Criteria andPhoneType1GreaterThanOrEqualTo(Byte value) {
			addCriterion("PHONE_TYPE1 >=", value, "phoneType1");
			return (Criteria) this;
		}

		public Criteria andPhoneType1LessThan(Byte value) {
			addCriterion("PHONE_TYPE1 <", value, "phoneType1");
			return (Criteria) this;
		}

		public Criteria andPhoneType1LessThanOrEqualTo(Byte value) {
			addCriterion("PHONE_TYPE1 <=", value, "phoneType1");
			return (Criteria) this;
		}

		public Criteria andPhoneType1In(List<Byte> values) {
			addCriterion("PHONE_TYPE1 in", values, "phoneType1");
			return (Criteria) this;
		}

		public Criteria andPhoneType1NotIn(List<Byte> values) {
			addCriterion("PHONE_TYPE1 not in", values, "phoneType1");
			return (Criteria) this;
		}

		public Criteria andPhoneType1Between(Byte value1, Byte value2) {
			addCriterion("PHONE_TYPE1 between", value1, value2, "phoneType1");
			return (Criteria) this;
		}

		public Criteria andPhoneType1NotBetween(Byte value1, Byte value2) {
			addCriterion("PHONE_TYPE1 not between", value1, value2, "phoneType1");
			return (Criteria) this;
		}

		public Criteria andPhone2IsNull() {
			addCriterion("PHONE2 is null");
			return (Criteria) this;
		}

		public Criteria andPhone2IsNotNull() {
			addCriterion("PHONE2 is not null");
			return (Criteria) this;
		}

		public Criteria andPhone2EqualTo(String value) {
			addCriterion("PHONE2 =", value, "phone2");
			return (Criteria) this;
		}

		public Criteria andPhone2NotEqualTo(String value) {
			addCriterion("PHONE2 <>", value, "phone2");
			return (Criteria) this;
		}

		public Criteria andPhone2GreaterThan(String value) {
			addCriterion("PHONE2 >", value, "phone2");
			return (Criteria) this;
		}

		public Criteria andPhone2GreaterThanOrEqualTo(String value) {
			addCriterion("PHONE2 >=", value, "phone2");
			return (Criteria) this;
		}

		public Criteria andPhone2LessThan(String value) {
			addCriterion("PHONE2 <", value, "phone2");
			return (Criteria) this;
		}

		public Criteria andPhone2LessThanOrEqualTo(String value) {
			addCriterion("PHONE2 <=", value, "phone2");
			return (Criteria) this;
		}

		public Criteria andPhone2Like(String value) {
			addCriterion("PHONE2 like", value, "phone2");
			return (Criteria) this;
		}

		public Criteria andPhone2NotLike(String value) {
			addCriterion("PHONE2 not like", value, "phone2");
			return (Criteria) this;
		}

		public Criteria andPhone2In(List<String> values) {
			addCriterion("PHONE2 in", values, "phone2");
			return (Criteria) this;
		}

		public Criteria andPhone2NotIn(List<String> values) {
			addCriterion("PHONE2 not in", values, "phone2");
			return (Criteria) this;
		}

		public Criteria andPhone2Between(String value1, String value2) {
			addCriterion("PHONE2 between", value1, value2, "phone2");
			return (Criteria) this;
		}

		public Criteria andPhone2NotBetween(String value1, String value2) {
			addCriterion("PHONE2 not between", value1, value2, "phone2");
			return (Criteria) this;
		}

		public Criteria andPhoneType2IsNull() {
			addCriterion("PHONE_TYPE2 is null");
			return (Criteria) this;
		}

		public Criteria andPhoneType2IsNotNull() {
			addCriterion("PHONE_TYPE2 is not null");
			return (Criteria) this;
		}

		public Criteria andPhoneType2EqualTo(Byte value) {
			addCriterion("PHONE_TYPE2 =", value, "phoneType2");
			return (Criteria) this;
		}

		public Criteria andPhoneType2NotEqualTo(Byte value) {
			addCriterion("PHONE_TYPE2 <>", value, "phoneType2");
			return (Criteria) this;
		}

		public Criteria andPhoneType2GreaterThan(Byte value) {
			addCriterion("PHONE_TYPE2 >", value, "phoneType2");
			return (Criteria) this;
		}

		public Criteria andPhoneType2GreaterThanOrEqualTo(Byte value) {
			addCriterion("PHONE_TYPE2 >=", value, "phoneType2");
			return (Criteria) this;
		}

		public Criteria andPhoneType2LessThan(Byte value) {
			addCriterion("PHONE_TYPE2 <", value, "phoneType2");
			return (Criteria) this;
		}

		public Criteria andPhoneType2LessThanOrEqualTo(Byte value) {
			addCriterion("PHONE_TYPE2 <=", value, "phoneType2");
			return (Criteria) this;
		}

		public Criteria andPhoneType2In(List<Byte> values) {
			addCriterion("PHONE_TYPE2 in", values, "phoneType2");
			return (Criteria) this;
		}

		public Criteria andPhoneType2NotIn(List<Byte> values) {
			addCriterion("PHONE_TYPE2 not in", values, "phoneType2");
			return (Criteria) this;
		}

		public Criteria andPhoneType2Between(Byte value1, Byte value2) {
			addCriterion("PHONE_TYPE2 between", value1, value2, "phoneType2");
			return (Criteria) this;
		}

		public Criteria andPhoneType2NotBetween(Byte value1, Byte value2) {
			addCriterion("PHONE_TYPE2 not between", value1, value2, "phoneType2");
			return (Criteria) this;
		}

		public Criteria andBlackCompIsNull() {
			addCriterion("BLACK_COMP is null");
			return (Criteria) this;
		}

		public Criteria andBlackCompIsNotNull() {
			addCriterion("BLACK_COMP is not null");
			return (Criteria) this;
		}

		public Criteria andBlackCompEqualTo(String value) {
			addCriterion("BLACK_COMP =", value, "blackComp");
			return (Criteria) this;
		}

		public Criteria andBlackCompNotEqualTo(String value) {
			addCriterion("BLACK_COMP <>", value, "blackComp");
			return (Criteria) this;
		}

		public Criteria andBlackCompGreaterThan(String value) {
			addCriterion("BLACK_COMP >", value, "blackComp");
			return (Criteria) this;
		}

		public Criteria andBlackCompGreaterThanOrEqualTo(String value) {
			addCriterion("BLACK_COMP >=", value, "blackComp");
			return (Criteria) this;
		}

		public Criteria andBlackCompLessThan(String value) {
			addCriterion("BLACK_COMP <", value, "blackComp");
			return (Criteria) this;
		}

		public Criteria andBlackCompLessThanOrEqualTo(String value) {
			addCriterion("BLACK_COMP <=", value, "blackComp");
			return (Criteria) this;
		}

		public Criteria andBlackCompLike(String value) {
			addCriterion("BLACK_COMP like", value, "blackComp");
			return (Criteria) this;
		}

		public Criteria andBlackCompNotLike(String value) {
			addCriterion("BLACK_COMP not like", value, "blackComp");
			return (Criteria) this;
		}

		public Criteria andBlackCompIn(List<String> values) {
			addCriterion("BLACK_COMP in", values, "blackComp");
			return (Criteria) this;
		}

		public Criteria andBlackCompNotIn(List<String> values) {
			addCriterion("BLACK_COMP not in", values, "blackComp");
			return (Criteria) this;
		}

		public Criteria andBlackCompBetween(String value1, String value2) {
			addCriterion("BLACK_COMP between", value1, value2, "blackComp");
			return (Criteria) this;
		}

		public Criteria andBlackCompNotBetween(String value1, String value2) {
			addCriterion("BLACK_COMP not between", value1, value2, "blackComp");
			return (Criteria) this;
		}

		public Criteria andRemarksIsNull() {
			addCriterion("REMARKS is null");
			return (Criteria) this;
		}

		public Criteria andRemarksIsNotNull() {
			addCriterion("REMARKS is not null");
			return (Criteria) this;
		}

		public Criteria andRemarksEqualTo(String value) {
			addCriterion("REMARKS =", value, "remarks");
			return (Criteria) this;
		}

		public Criteria andRemarksNotEqualTo(String value) {
			addCriterion("REMARKS <>", value, "remarks");
			return (Criteria) this;
		}

		public Criteria andRemarksGreaterThan(String value) {
			addCriterion("REMARKS >", value, "remarks");
			return (Criteria) this;
		}

		public Criteria andRemarksGreaterThanOrEqualTo(String value) {
			addCriterion("REMARKS >=", value, "remarks");
			return (Criteria) this;
		}

		public Criteria andRemarksLessThan(String value) {
			addCriterion("REMARKS <", value, "remarks");
			return (Criteria) this;
		}

		public Criteria andRemarksLessThanOrEqualTo(String value) {
			addCriterion("REMARKS <=", value, "remarks");
			return (Criteria) this;
		}

		public Criteria andRemarksLike(String value) {
			addCriterion("REMARKS like", value, "remarks");
			return (Criteria) this;
		}

		public Criteria andRemarksNotLike(String value) {
			addCriterion("REMARKS not like", value, "remarks");
			return (Criteria) this;
		}

		public Criteria andRemarksIn(List<String> values) {
			addCriterion("REMARKS in", values, "remarks");
			return (Criteria) this;
		}

		public Criteria andRemarksNotIn(List<String> values) {
			addCriterion("REMARKS not in", values, "remarks");
			return (Criteria) this;
		}

		public Criteria andRemarksBetween(String value1, String value2) {
			addCriterion("REMARKS between", value1, value2, "remarks");
			return (Criteria) this;
		}

		public Criteria andRemarksNotBetween(String value1, String value2) {
			addCriterion("REMARKS not between", value1, value2, "remarks");
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

		public Criteria andKeywordQueryIsNull() {
			addCriterion("KEYWORD_QUERY is null");
			return (Criteria) this;
		}

		public Criteria andKeywordQueryIsNotNull() {
			addCriterion("KEYWORD_QUERY is not null");
			return (Criteria) this;
		}

		public Criteria andKeywordQueryEqualTo(String value) {
			addCriterion("KEYWORD_QUERY =", value, "keywordQuery");
			return (Criteria) this;
		}

		public Criteria andKeywordQueryNotEqualTo(String value) {
			addCriterion("KEYWORD_QUERY <>", value, "keywordQuery");
			return (Criteria) this;
		}

		public Criteria andKeywordQueryGreaterThan(String value) {
			addCriterion("KEYWORD_QUERY >", value, "keywordQuery");
			return (Criteria) this;
		}

		public Criteria andKeywordQueryGreaterThanOrEqualTo(String value) {
			addCriterion("KEYWORD_QUERY >=", value, "keywordQuery");
			return (Criteria) this;
		}

		public Criteria andKeywordQueryLessThan(String value) {
			addCriterion("KEYWORD_QUERY <", value, "keywordQuery");
			return (Criteria) this;
		}

		public Criteria andKeywordQueryLessThanOrEqualTo(String value) {
			addCriterion("KEYWORD_QUERY <=", value, "keywordQuery");
			return (Criteria) this;
		}

		public Criteria andKeywordQueryLike(String value) {
			addCriterion("KEYWORD_QUERY like", value, "keywordQuery");
			return (Criteria) this;
		}

		public Criteria andKeywordQueryNotLike(String value) {
			addCriterion("KEYWORD_QUERY not like", value, "keywordQuery");
			return (Criteria) this;
		}

		public Criteria andKeywordQueryIn(List<String> values) {
			addCriterion("KEYWORD_QUERY in", values, "keywordQuery");
			return (Criteria) this;
		}

		public Criteria andKeywordQueryNotIn(List<String> values) {
			addCriterion("KEYWORD_QUERY not in", values, "keywordQuery");
			return (Criteria) this;
		}

		public Criteria andKeywordQueryBetween(String value1, String value2) {
			addCriterion("KEYWORD_QUERY between", value1, value2, "keywordQuery");
			return (Criteria) this;
		}

		public Criteria andKeywordQueryNotBetween(String value1, String value2) {
			addCriterion("KEYWORD_QUERY not between", value1, value2, "keywordQuery");
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