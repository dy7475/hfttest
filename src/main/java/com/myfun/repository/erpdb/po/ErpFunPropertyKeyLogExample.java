package com.myfun.repository.erpdb.po;

import com.myfun.repository.support.generator.shard.ShardDb;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ErpFunPropertyKeyLogExample extends ShardDb {
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
	public ErpFunPropertyKeyLogExample() {
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

		public Criteria andFunPropertyKeyLogIdIsNull() {
			addCriterion("FUN_PROPERTY_KEY_LOG_ID is null");
			return (Criteria) this;
		}

		public Criteria andFunPropertyKeyLogIdIsNotNull() {
			addCriterion("FUN_PROPERTY_KEY_LOG_ID is not null");
			return (Criteria) this;
		}

		public Criteria andFunPropertyKeyLogIdEqualTo(Integer value) {
			addCriterion("FUN_PROPERTY_KEY_LOG_ID =", value, "funPropertyKeyLogId");
			return (Criteria) this;
		}

		public Criteria andFunPropertyKeyLogIdNotEqualTo(Integer value) {
			addCriterion("FUN_PROPERTY_KEY_LOG_ID <>", value, "funPropertyKeyLogId");
			return (Criteria) this;
		}

		public Criteria andFunPropertyKeyLogIdGreaterThan(Integer value) {
			addCriterion("FUN_PROPERTY_KEY_LOG_ID >", value, "funPropertyKeyLogId");
			return (Criteria) this;
		}

		public Criteria andFunPropertyKeyLogIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("FUN_PROPERTY_KEY_LOG_ID >=", value, "funPropertyKeyLogId");
			return (Criteria) this;
		}

		public Criteria andFunPropertyKeyLogIdLessThan(Integer value) {
			addCriterion("FUN_PROPERTY_KEY_LOG_ID <", value, "funPropertyKeyLogId");
			return (Criteria) this;
		}

		public Criteria andFunPropertyKeyLogIdLessThanOrEqualTo(Integer value) {
			addCriterion("FUN_PROPERTY_KEY_LOG_ID <=", value, "funPropertyKeyLogId");
			return (Criteria) this;
		}

		public Criteria andFunPropertyKeyLogIdIn(List<Integer> values) {
			addCriterion("FUN_PROPERTY_KEY_LOG_ID in", values, "funPropertyKeyLogId");
			return (Criteria) this;
		}

		public Criteria andFunPropertyKeyLogIdNotIn(List<Integer> values) {
			addCriterion("FUN_PROPERTY_KEY_LOG_ID not in", values, "funPropertyKeyLogId");
			return (Criteria) this;
		}

		public Criteria andFunPropertyKeyLogIdBetween(Integer value1, Integer value2) {
			addCriterion("FUN_PROPERTY_KEY_LOG_ID between", value1, value2, "funPropertyKeyLogId");
			return (Criteria) this;
		}

		public Criteria andFunPropertyKeyLogIdNotBetween(Integer value1, Integer value2) {
			addCriterion("FUN_PROPERTY_KEY_LOG_ID not between", value1, value2, "funPropertyKeyLogId");
			return (Criteria) this;
		}

		public Criteria andBorrowPhoneIsNull() {
			addCriterion("BORROW_PHONE is null");
			return (Criteria) this;
		}

		public Criteria andBorrowPhoneIsNotNull() {
			addCriterion("BORROW_PHONE is not null");
			return (Criteria) this;
		}

		public Criteria andBorrowPhoneEqualTo(String value) {
			addCriterion("BORROW_PHONE =", value, "borrowPhone");
			return (Criteria) this;
		}

		public Criteria andBorrowPhoneNotEqualTo(String value) {
			addCriterion("BORROW_PHONE <>", value, "borrowPhone");
			return (Criteria) this;
		}

		public Criteria andBorrowPhoneGreaterThan(String value) {
			addCriterion("BORROW_PHONE >", value, "borrowPhone");
			return (Criteria) this;
		}

		public Criteria andBorrowPhoneGreaterThanOrEqualTo(String value) {
			addCriterion("BORROW_PHONE >=", value, "borrowPhone");
			return (Criteria) this;
		}

		public Criteria andBorrowPhoneLessThan(String value) {
			addCriterion("BORROW_PHONE <", value, "borrowPhone");
			return (Criteria) this;
		}

		public Criteria andBorrowPhoneLessThanOrEqualTo(String value) {
			addCriterion("BORROW_PHONE <=", value, "borrowPhone");
			return (Criteria) this;
		}

		public Criteria andBorrowPhoneLike(String value) {
			addCriterion("BORROW_PHONE like", value, "borrowPhone");
			return (Criteria) this;
		}

		public Criteria andBorrowPhoneNotLike(String value) {
			addCriterion("BORROW_PHONE not like", value, "borrowPhone");
			return (Criteria) this;
		}

		public Criteria andBorrowPhoneIn(List<String> values) {
			addCriterion("BORROW_PHONE in", values, "borrowPhone");
			return (Criteria) this;
		}

		public Criteria andBorrowPhoneNotIn(List<String> values) {
			addCriterion("BORROW_PHONE not in", values, "borrowPhone");
			return (Criteria) this;
		}

		public Criteria andBorrowPhoneBetween(String value1, String value2) {
			addCriterion("BORROW_PHONE between", value1, value2, "borrowPhone");
			return (Criteria) this;
		}

		public Criteria andBorrowPhoneNotBetween(String value1, String value2) {
			addCriterion("BORROW_PHONE not between", value1, value2, "borrowPhone");
			return (Criteria) this;
		}

		public Criteria andBorrowNameIsNull() {
			addCriterion("BORROW_NAME is null");
			return (Criteria) this;
		}

		public Criteria andBorrowNameIsNotNull() {
			addCriterion("BORROW_NAME is not null");
			return (Criteria) this;
		}

		public Criteria andBorrowNameEqualTo(String value) {
			addCriterion("BORROW_NAME =", value, "borrowName");
			return (Criteria) this;
		}

		public Criteria andBorrowNameNotEqualTo(String value) {
			addCriterion("BORROW_NAME <>", value, "borrowName");
			return (Criteria) this;
		}

		public Criteria andBorrowNameGreaterThan(String value) {
			addCriterion("BORROW_NAME >", value, "borrowName");
			return (Criteria) this;
		}

		public Criteria andBorrowNameGreaterThanOrEqualTo(String value) {
			addCriterion("BORROW_NAME >=", value, "borrowName");
			return (Criteria) this;
		}

		public Criteria andBorrowNameLessThan(String value) {
			addCriterion("BORROW_NAME <", value, "borrowName");
			return (Criteria) this;
		}

		public Criteria andBorrowNameLessThanOrEqualTo(String value) {
			addCriterion("BORROW_NAME <=", value, "borrowName");
			return (Criteria) this;
		}

		public Criteria andBorrowNameLike(String value) {
			addCriterion("BORROW_NAME like", value, "borrowName");
			return (Criteria) this;
		}

		public Criteria andBorrowNameNotLike(String value) {
			addCriterion("BORROW_NAME not like", value, "borrowName");
			return (Criteria) this;
		}

		public Criteria andBorrowNameIn(List<String> values) {
			addCriterion("BORROW_NAME in", values, "borrowName");
			return (Criteria) this;
		}

		public Criteria andBorrowNameNotIn(List<String> values) {
			addCriterion("BORROW_NAME not in", values, "borrowName");
			return (Criteria) this;
		}

		public Criteria andBorrowNameBetween(String value1, String value2) {
			addCriterion("BORROW_NAME between", value1, value2, "borrowName");
			return (Criteria) this;
		}

		public Criteria andBorrowNameNotBetween(String value1, String value2) {
			addCriterion("BORROW_NAME not between", value1, value2, "borrowName");
			return (Criteria) this;
		}

		public Criteria andCurrentDepositIsNull() {
			addCriterion("CURRENT_DEPOSIT is null");
			return (Criteria) this;
		}

		public Criteria andCurrentDepositIsNotNull() {
			addCriterion("CURRENT_DEPOSIT is not null");
			return (Criteria) this;
		}

		public Criteria andCurrentDepositEqualTo(BigDecimal value) {
			addCriterion("CURRENT_DEPOSIT =", value, "currentDeposit");
			return (Criteria) this;
		}

		public Criteria andCurrentDepositNotEqualTo(BigDecimal value) {
			addCriterion("CURRENT_DEPOSIT <>", value, "currentDeposit");
			return (Criteria) this;
		}

		public Criteria andCurrentDepositGreaterThan(BigDecimal value) {
			addCriterion("CURRENT_DEPOSIT >", value, "currentDeposit");
			return (Criteria) this;
		}

		public Criteria andCurrentDepositGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("CURRENT_DEPOSIT >=", value, "currentDeposit");
			return (Criteria) this;
		}

		public Criteria andCurrentDepositLessThan(BigDecimal value) {
			addCriterion("CURRENT_DEPOSIT <", value, "currentDeposit");
			return (Criteria) this;
		}

		public Criteria andCurrentDepositLessThanOrEqualTo(BigDecimal value) {
			addCriterion("CURRENT_DEPOSIT <=", value, "currentDeposit");
			return (Criteria) this;
		}

		public Criteria andCurrentDepositIn(List<BigDecimal> values) {
			addCriterion("CURRENT_DEPOSIT in", values, "currentDeposit");
			return (Criteria) this;
		}

		public Criteria andCurrentDepositNotIn(List<BigDecimal> values) {
			addCriterion("CURRENT_DEPOSIT not in", values, "currentDeposit");
			return (Criteria) this;
		}

		public Criteria andCurrentDepositBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("CURRENT_DEPOSIT between", value1, value2, "currentDeposit");
			return (Criteria) this;
		}

		public Criteria andCurrentDepositNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("CURRENT_DEPOSIT not between", value1, value2, "currentDeposit");
			return (Criteria) this;
		}

		public Criteria andPayIdIsNull() {
			addCriterion("PAY_ID is null");
			return (Criteria) this;
		}

		public Criteria andPayIdIsNotNull() {
			addCriterion("PAY_ID is not null");
			return (Criteria) this;
		}

		public Criteria andPayIdEqualTo(String value) {
			addCriterion("PAY_ID =", value, "payId");
			return (Criteria) this;
		}

		public Criteria andPayIdNotEqualTo(String value) {
			addCriterion("PAY_ID <>", value, "payId");
			return (Criteria) this;
		}

		public Criteria andPayIdGreaterThan(String value) {
			addCriterion("PAY_ID >", value, "payId");
			return (Criteria) this;
		}

		public Criteria andPayIdGreaterThanOrEqualTo(String value) {
			addCriterion("PAY_ID >=", value, "payId");
			return (Criteria) this;
		}

		public Criteria andPayIdLessThan(String value) {
			addCriterion("PAY_ID <", value, "payId");
			return (Criteria) this;
		}

		public Criteria andPayIdLessThanOrEqualTo(String value) {
			addCriterion("PAY_ID <=", value, "payId");
			return (Criteria) this;
		}

		public Criteria andPayIdLike(String value) {
			addCriterion("PAY_ID like", value, "payId");
			return (Criteria) this;
		}

		public Criteria andPayIdNotLike(String value) {
			addCriterion("PAY_ID not like", value, "payId");
			return (Criteria) this;
		}

		public Criteria andPayIdIn(List<String> values) {
			addCriterion("PAY_ID in", values, "payId");
			return (Criteria) this;
		}

		public Criteria andPayIdNotIn(List<String> values) {
			addCriterion("PAY_ID not in", values, "payId");
			return (Criteria) this;
		}

		public Criteria andPayIdBetween(String value1, String value2) {
			addCriterion("PAY_ID between", value1, value2, "payId");
			return (Criteria) this;
		}

		public Criteria andPayIdNotBetween(String value1, String value2) {
			addCriterion("PAY_ID not between", value1, value2, "payId");
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

		public Criteria andMaxBorrowHourIsNull() {
			addCriterion("MAX_BORROW_HOUR is null");
			return (Criteria) this;
		}

		public Criteria andMaxBorrowHourIsNotNull() {
			addCriterion("MAX_BORROW_HOUR is not null");
			return (Criteria) this;
		}

		public Criteria andMaxBorrowHourEqualTo(Integer value) {
			addCriterion("MAX_BORROW_HOUR =", value, "maxBorrowHour");
			return (Criteria) this;
		}

		public Criteria andMaxBorrowHourNotEqualTo(Integer value) {
			addCriterion("MAX_BORROW_HOUR <>", value, "maxBorrowHour");
			return (Criteria) this;
		}

		public Criteria andMaxBorrowHourGreaterThan(Integer value) {
			addCriterion("MAX_BORROW_HOUR >", value, "maxBorrowHour");
			return (Criteria) this;
		}

		public Criteria andMaxBorrowHourGreaterThanOrEqualTo(Integer value) {
			addCriterion("MAX_BORROW_HOUR >=", value, "maxBorrowHour");
			return (Criteria) this;
		}

		public Criteria andMaxBorrowHourLessThan(Integer value) {
			addCriterion("MAX_BORROW_HOUR <", value, "maxBorrowHour");
			return (Criteria) this;
		}

		public Criteria andMaxBorrowHourLessThanOrEqualTo(Integer value) {
			addCriterion("MAX_BORROW_HOUR <=", value, "maxBorrowHour");
			return (Criteria) this;
		}

		public Criteria andMaxBorrowHourIn(List<Integer> values) {
			addCriterion("MAX_BORROW_HOUR in", values, "maxBorrowHour");
			return (Criteria) this;
		}

		public Criteria andMaxBorrowHourNotIn(List<Integer> values) {
			addCriterion("MAX_BORROW_HOUR not in", values, "maxBorrowHour");
			return (Criteria) this;
		}

		public Criteria andMaxBorrowHourBetween(Integer value1, Integer value2) {
			addCriterion("MAX_BORROW_HOUR between", value1, value2, "maxBorrowHour");
			return (Criteria) this;
		}

		public Criteria andMaxBorrowHourNotBetween(Integer value1, Integer value2) {
			addCriterion("MAX_BORROW_HOUR not between", value1, value2, "maxBorrowHour");
			return (Criteria) this;
		}

		public Criteria andKeyStatusIsNull() {
			addCriterion("KEY_STATUS is null");
			return (Criteria) this;
		}

		public Criteria andKeyStatusIsNotNull() {
			addCriterion("KEY_STATUS is not null");
			return (Criteria) this;
		}

		public Criteria andKeyStatusEqualTo(Integer value) {
			addCriterion("KEY_STATUS =", value, "keyStatus");
			return (Criteria) this;
		}

		public Criteria andKeyStatusNotEqualTo(Integer value) {
			addCriterion("KEY_STATUS <>", value, "keyStatus");
			return (Criteria) this;
		}

		public Criteria andKeyStatusGreaterThan(Integer value) {
			addCriterion("KEY_STATUS >", value, "keyStatus");
			return (Criteria) this;
		}

		public Criteria andKeyStatusGreaterThanOrEqualTo(Integer value) {
			addCriterion("KEY_STATUS >=", value, "keyStatus");
			return (Criteria) this;
		}

		public Criteria andKeyStatusLessThan(Integer value) {
			addCriterion("KEY_STATUS <", value, "keyStatus");
			return (Criteria) this;
		}

		public Criteria andKeyStatusLessThanOrEqualTo(Integer value) {
			addCriterion("KEY_STATUS <=", value, "keyStatus");
			return (Criteria) this;
		}

		public Criteria andKeyStatusIn(List<Integer> values) {
			addCriterion("KEY_STATUS in", values, "keyStatus");
			return (Criteria) this;
		}

		public Criteria andKeyStatusNotIn(List<Integer> values) {
			addCriterion("KEY_STATUS not in", values, "keyStatus");
			return (Criteria) this;
		}

		public Criteria andKeyStatusBetween(Integer value1, Integer value2) {
			addCriterion("KEY_STATUS between", value1, value2, "keyStatus");
			return (Criteria) this;
		}

		public Criteria andKeyStatusNotBetween(Integer value1, Integer value2) {
			addCriterion("KEY_STATUS not between", value1, value2, "keyStatus");
			return (Criteria) this;
		}

		public Criteria andDepositStatusIsNull() {
			addCriterion("DEPOSIT_STATUS is null");
			return (Criteria) this;
		}

		public Criteria andDepositStatusIsNotNull() {
			addCriterion("DEPOSIT_STATUS is not null");
			return (Criteria) this;
		}

		public Criteria andDepositStatusEqualTo(Integer value) {
			addCriterion("DEPOSIT_STATUS =", value, "depositStatus");
			return (Criteria) this;
		}

		public Criteria andDepositStatusNotEqualTo(Integer value) {
			addCriterion("DEPOSIT_STATUS <>", value, "depositStatus");
			return (Criteria) this;
		}

		public Criteria andDepositStatusGreaterThan(Integer value) {
			addCriterion("DEPOSIT_STATUS >", value, "depositStatus");
			return (Criteria) this;
		}

		public Criteria andDepositStatusGreaterThanOrEqualTo(Integer value) {
			addCriterion("DEPOSIT_STATUS >=", value, "depositStatus");
			return (Criteria) this;
		}

		public Criteria andDepositStatusLessThan(Integer value) {
			addCriterion("DEPOSIT_STATUS <", value, "depositStatus");
			return (Criteria) this;
		}

		public Criteria andDepositStatusLessThanOrEqualTo(Integer value) {
			addCriterion("DEPOSIT_STATUS <=", value, "depositStatus");
			return (Criteria) this;
		}

		public Criteria andDepositStatusIn(List<Integer> values) {
			addCriterion("DEPOSIT_STATUS in", values, "depositStatus");
			return (Criteria) this;
		}

		public Criteria andDepositStatusNotIn(List<Integer> values) {
			addCriterion("DEPOSIT_STATUS not in", values, "depositStatus");
			return (Criteria) this;
		}

		public Criteria andDepositStatusBetween(Integer value1, Integer value2) {
			addCriterion("DEPOSIT_STATUS between", value1, value2, "depositStatus");
			return (Criteria) this;
		}

		public Criteria andDepositStatusNotBetween(Integer value1, Integer value2) {
			addCriterion("DEPOSIT_STATUS not between", value1, value2, "depositStatus");
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

		public Criteria andFunKeyIdIsNull() {
			addCriterion("FUN_KEY_ID is null");
			return (Criteria) this;
		}

		public Criteria andFunKeyIdIsNotNull() {
			addCriterion("FUN_KEY_ID is not null");
			return (Criteria) this;
		}

		public Criteria andFunKeyIdEqualTo(Integer value) {
			addCriterion("FUN_KEY_ID =", value, "funKeyId");
			return (Criteria) this;
		}

		public Criteria andFunKeyIdNotEqualTo(Integer value) {
			addCriterion("FUN_KEY_ID <>", value, "funKeyId");
			return (Criteria) this;
		}

		public Criteria andFunKeyIdGreaterThan(Integer value) {
			addCriterion("FUN_KEY_ID >", value, "funKeyId");
			return (Criteria) this;
		}

		public Criteria andFunKeyIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("FUN_KEY_ID >=", value, "funKeyId");
			return (Criteria) this;
		}

		public Criteria andFunKeyIdLessThan(Integer value) {
			addCriterion("FUN_KEY_ID <", value, "funKeyId");
			return (Criteria) this;
		}

		public Criteria andFunKeyIdLessThanOrEqualTo(Integer value) {
			addCriterion("FUN_KEY_ID <=", value, "funKeyId");
			return (Criteria) this;
		}

		public Criteria andFunKeyIdIn(List<Integer> values) {
			addCriterion("FUN_KEY_ID in", values, "funKeyId");
			return (Criteria) this;
		}

		public Criteria andFunKeyIdNotIn(List<Integer> values) {
			addCriterion("FUN_KEY_ID not in", values, "funKeyId");
			return (Criteria) this;
		}

		public Criteria andFunKeyIdBetween(Integer value1, Integer value2) {
			addCriterion("FUN_KEY_ID between", value1, value2, "funKeyId");
			return (Criteria) this;
		}

		public Criteria andFunKeyIdNotBetween(Integer value1, Integer value2) {
			addCriterion("FUN_KEY_ID not between", value1, value2, "funKeyId");
			return (Criteria) this;
		}

		public Criteria andCaseTypeIsNull() {
			addCriterion("CASE_TYPE is null");
			return (Criteria) this;
		}

		public Criteria andCaseTypeIsNotNull() {
			addCriterion("CASE_TYPE is not null");
			return (Criteria) this;
		}

		public Criteria andCaseTypeEqualTo(Integer value) {
			addCriterion("CASE_TYPE =", value, "caseType");
			return (Criteria) this;
		}

		public Criteria andCaseTypeNotEqualTo(Integer value) {
			addCriterion("CASE_TYPE <>", value, "caseType");
			return (Criteria) this;
		}

		public Criteria andCaseTypeGreaterThan(Integer value) {
			addCriterion("CASE_TYPE >", value, "caseType");
			return (Criteria) this;
		}

		public Criteria andCaseTypeGreaterThanOrEqualTo(Integer value) {
			addCriterion("CASE_TYPE >=", value, "caseType");
			return (Criteria) this;
		}

		public Criteria andCaseTypeLessThan(Integer value) {
			addCriterion("CASE_TYPE <", value, "caseType");
			return (Criteria) this;
		}

		public Criteria andCaseTypeLessThanOrEqualTo(Integer value) {
			addCriterion("CASE_TYPE <=", value, "caseType");
			return (Criteria) this;
		}

		public Criteria andCaseTypeIn(List<Integer> values) {
			addCriterion("CASE_TYPE in", values, "caseType");
			return (Criteria) this;
		}

		public Criteria andCaseTypeNotIn(List<Integer> values) {
			addCriterion("CASE_TYPE not in", values, "caseType");
			return (Criteria) this;
		}

		public Criteria andCaseTypeBetween(Integer value1, Integer value2) {
			addCriterion("CASE_TYPE between", value1, value2, "caseType");
			return (Criteria) this;
		}

		public Criteria andCaseTypeNotBetween(Integer value1, Integer value2) {
			addCriterion("CASE_TYPE not between", value1, value2, "caseType");
			return (Criteria) this;
		}

		public Criteria andMaxBorrowTimeIsNull() {
			addCriterion("MAX_BORROW_TIME is null");
			return (Criteria) this;
		}

		public Criteria andMaxBorrowTimeIsNotNull() {
			addCriterion("MAX_BORROW_TIME is not null");
			return (Criteria) this;
		}

		public Criteria andMaxBorrowTimeEqualTo(Date value) {
			addCriterion("MAX_BORROW_TIME =", value, "maxBorrowTime");
			return (Criteria) this;
		}

		public Criteria andMaxBorrowTimeNotEqualTo(Date value) {
			addCriterion("MAX_BORROW_TIME <>", value, "maxBorrowTime");
			return (Criteria) this;
		}

		public Criteria andMaxBorrowTimeGreaterThan(Date value) {
			addCriterion("MAX_BORROW_TIME >", value, "maxBorrowTime");
			return (Criteria) this;
		}

		public Criteria andMaxBorrowTimeGreaterThanOrEqualTo(Date value) {
			addCriterion("MAX_BORROW_TIME >=", value, "maxBorrowTime");
			return (Criteria) this;
		}

		public Criteria andMaxBorrowTimeLessThan(Date value) {
			addCriterion("MAX_BORROW_TIME <", value, "maxBorrowTime");
			return (Criteria) this;
		}

		public Criteria andMaxBorrowTimeLessThanOrEqualTo(Date value) {
			addCriterion("MAX_BORROW_TIME <=", value, "maxBorrowTime");
			return (Criteria) this;
		}

		public Criteria andMaxBorrowTimeIn(List<Date> values) {
			addCriterion("MAX_BORROW_TIME in", values, "maxBorrowTime");
			return (Criteria) this;
		}

		public Criteria andMaxBorrowTimeNotIn(List<Date> values) {
			addCriterion("MAX_BORROW_TIME not in", values, "maxBorrowTime");
			return (Criteria) this;
		}

		public Criteria andMaxBorrowTimeBetween(Date value1, Date value2) {
			addCriterion("MAX_BORROW_TIME between", value1, value2, "maxBorrowTime");
			return (Criteria) this;
		}

		public Criteria andMaxBorrowTimeNotBetween(Date value1, Date value2) {
			addCriterion("MAX_BORROW_TIME not between", value1, value2, "maxBorrowTime");
			return (Criteria) this;
		}

		public Criteria andBuildFloorIsNull() {
			addCriterion("BUILD_FLOOR is null");
			return (Criteria) this;
		}

		public Criteria andBuildFloorIsNotNull() {
			addCriterion("BUILD_FLOOR is not null");
			return (Criteria) this;
		}

		public Criteria andBuildFloorEqualTo(String value) {
			addCriterion("BUILD_FLOOR =", value, "buildFloor");
			return (Criteria) this;
		}

		public Criteria andBuildFloorNotEqualTo(String value) {
			addCriterion("BUILD_FLOOR <>", value, "buildFloor");
			return (Criteria) this;
		}

		public Criteria andBuildFloorGreaterThan(String value) {
			addCriterion("BUILD_FLOOR >", value, "buildFloor");
			return (Criteria) this;
		}

		public Criteria andBuildFloorGreaterThanOrEqualTo(String value) {
			addCriterion("BUILD_FLOOR >=", value, "buildFloor");
			return (Criteria) this;
		}

		public Criteria andBuildFloorLessThan(String value) {
			addCriterion("BUILD_FLOOR <", value, "buildFloor");
			return (Criteria) this;
		}

		public Criteria andBuildFloorLessThanOrEqualTo(String value) {
			addCriterion("BUILD_FLOOR <=", value, "buildFloor");
			return (Criteria) this;
		}

		public Criteria andBuildFloorLike(String value) {
			addCriterion("BUILD_FLOOR like", value, "buildFloor");
			return (Criteria) this;
		}

		public Criteria andBuildFloorNotLike(String value) {
			addCriterion("BUILD_FLOOR not like", value, "buildFloor");
			return (Criteria) this;
		}

		public Criteria andBuildFloorIn(List<String> values) {
			addCriterion("BUILD_FLOOR in", values, "buildFloor");
			return (Criteria) this;
		}

		public Criteria andBuildFloorNotIn(List<String> values) {
			addCriterion("BUILD_FLOOR not in", values, "buildFloor");
			return (Criteria) this;
		}

		public Criteria andBuildFloorBetween(String value1, String value2) {
			addCriterion("BUILD_FLOOR between", value1, value2, "buildFloor");
			return (Criteria) this;
		}

		public Criteria andBuildFloorNotBetween(String value1, String value2) {
			addCriterion("BUILD_FLOOR not between", value1, value2, "buildFloor");
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

		public Criteria andBuildRoofIsNull() {
			addCriterion("BUILD_ROOF is null");
			return (Criteria) this;
		}

		public Criteria andBuildRoofIsNotNull() {
			addCriterion("BUILD_ROOF is not null");
			return (Criteria) this;
		}

		public Criteria andBuildRoofEqualTo(String value) {
			addCriterion("BUILD_ROOF =", value, "buildRoof");
			return (Criteria) this;
		}

		public Criteria andBuildRoofNotEqualTo(String value) {
			addCriterion("BUILD_ROOF <>", value, "buildRoof");
			return (Criteria) this;
		}

		public Criteria andBuildRoofGreaterThan(String value) {
			addCriterion("BUILD_ROOF >", value, "buildRoof");
			return (Criteria) this;
		}

		public Criteria andBuildRoofGreaterThanOrEqualTo(String value) {
			addCriterion("BUILD_ROOF >=", value, "buildRoof");
			return (Criteria) this;
		}

		public Criteria andBuildRoofLessThan(String value) {
			addCriterion("BUILD_ROOF <", value, "buildRoof");
			return (Criteria) this;
		}

		public Criteria andBuildRoofLessThanOrEqualTo(String value) {
			addCriterion("BUILD_ROOF <=", value, "buildRoof");
			return (Criteria) this;
		}

		public Criteria andBuildRoofLike(String value) {
			addCriterion("BUILD_ROOF like", value, "buildRoof");
			return (Criteria) this;
		}

		public Criteria andBuildRoofNotLike(String value) {
			addCriterion("BUILD_ROOF not like", value, "buildRoof");
			return (Criteria) this;
		}

		public Criteria andBuildRoofIn(List<String> values) {
			addCriterion("BUILD_ROOF in", values, "buildRoof");
			return (Criteria) this;
		}

		public Criteria andBuildRoofNotIn(List<String> values) {
			addCriterion("BUILD_ROOF not in", values, "buildRoof");
			return (Criteria) this;
		}

		public Criteria andBuildRoofBetween(String value1, String value2) {
			addCriterion("BUILD_ROOF between", value1, value2, "buildRoof");
			return (Criteria) this;
		}

		public Criteria andBuildRoofNotBetween(String value1, String value2) {
			addCriterion("BUILD_ROOF not between", value1, value2, "buildRoof");
			return (Criteria) this;
		}

		public Criteria andBuildUnitIsNull() {
			addCriterion("BUILD_UNIT is null");
			return (Criteria) this;
		}

		public Criteria andBuildUnitIsNotNull() {
			addCriterion("BUILD_UNIT is not null");
			return (Criteria) this;
		}

		public Criteria andBuildUnitEqualTo(String value) {
			addCriterion("BUILD_UNIT =", value, "buildUnit");
			return (Criteria) this;
		}

		public Criteria andBuildUnitNotEqualTo(String value) {
			addCriterion("BUILD_UNIT <>", value, "buildUnit");
			return (Criteria) this;
		}

		public Criteria andBuildUnitGreaterThan(String value) {
			addCriterion("BUILD_UNIT >", value, "buildUnit");
			return (Criteria) this;
		}

		public Criteria andBuildUnitGreaterThanOrEqualTo(String value) {
			addCriterion("BUILD_UNIT >=", value, "buildUnit");
			return (Criteria) this;
		}

		public Criteria andBuildUnitLessThan(String value) {
			addCriterion("BUILD_UNIT <", value, "buildUnit");
			return (Criteria) this;
		}

		public Criteria andBuildUnitLessThanOrEqualTo(String value) {
			addCriterion("BUILD_UNIT <=", value, "buildUnit");
			return (Criteria) this;
		}

		public Criteria andBuildUnitLike(String value) {
			addCriterion("BUILD_UNIT like", value, "buildUnit");
			return (Criteria) this;
		}

		public Criteria andBuildUnitNotLike(String value) {
			addCriterion("BUILD_UNIT not like", value, "buildUnit");
			return (Criteria) this;
		}

		public Criteria andBuildUnitIn(List<String> values) {
			addCriterion("BUILD_UNIT in", values, "buildUnit");
			return (Criteria) this;
		}

		public Criteria andBuildUnitNotIn(List<String> values) {
			addCriterion("BUILD_UNIT not in", values, "buildUnit");
			return (Criteria) this;
		}

		public Criteria andBuildUnitBetween(String value1, String value2) {
			addCriterion("BUILD_UNIT between", value1, value2, "buildUnit");
			return (Criteria) this;
		}

		public Criteria andBuildUnitNotBetween(String value1, String value2) {
			addCriterion("BUILD_UNIT not between", value1, value2, "buildUnit");
			return (Criteria) this;
		}

		public Criteria andBuildNumIsNull() {
			addCriterion("BUILD_NUM is null");
			return (Criteria) this;
		}

		public Criteria andBuildNumIsNotNull() {
			addCriterion("BUILD_NUM is not null");
			return (Criteria) this;
		}

		public Criteria andBuildNumEqualTo(String value) {
			addCriterion("BUILD_NUM =", value, "buildNum");
			return (Criteria) this;
		}

		public Criteria andBuildNumNotEqualTo(String value) {
			addCriterion("BUILD_NUM <>", value, "buildNum");
			return (Criteria) this;
		}

		public Criteria andBuildNumGreaterThan(String value) {
			addCriterion("BUILD_NUM >", value, "buildNum");
			return (Criteria) this;
		}

		public Criteria andBuildNumGreaterThanOrEqualTo(String value) {
			addCriterion("BUILD_NUM >=", value, "buildNum");
			return (Criteria) this;
		}

		public Criteria andBuildNumLessThan(String value) {
			addCriterion("BUILD_NUM <", value, "buildNum");
			return (Criteria) this;
		}

		public Criteria andBuildNumLessThanOrEqualTo(String value) {
			addCriterion("BUILD_NUM <=", value, "buildNum");
			return (Criteria) this;
		}

		public Criteria andBuildNumLike(String value) {
			addCriterion("BUILD_NUM like", value, "buildNum");
			return (Criteria) this;
		}

		public Criteria andBuildNumNotLike(String value) {
			addCriterion("BUILD_NUM not like", value, "buildNum");
			return (Criteria) this;
		}

		public Criteria andBuildNumIn(List<String> values) {
			addCriterion("BUILD_NUM in", values, "buildNum");
			return (Criteria) this;
		}

		public Criteria andBuildNumNotIn(List<String> values) {
			addCriterion("BUILD_NUM not in", values, "buildNum");
			return (Criteria) this;
		}

		public Criteria andBuildNumBetween(String value1, String value2) {
			addCriterion("BUILD_NUM between", value1, value2, "buildNum");
			return (Criteria) this;
		}

		public Criteria andBuildNumNotBetween(String value1, String value2) {
			addCriterion("BUILD_NUM not between", value1, value2, "buildNum");
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

		public Criteria andIdCardNumIsNull() {
			addCriterion("ID_CARD_NUM is null");
			return (Criteria) this;
		}

		public Criteria andIdCardNumIsNotNull() {
			addCriterion("ID_CARD_NUM is not null");
			return (Criteria) this;
		}

		public Criteria andIdCardNumEqualTo(String value) {
			addCriterion("ID_CARD_NUM =", value, "idCardNum");
			return (Criteria) this;
		}

		public Criteria andIdCardNumNotEqualTo(String value) {
			addCriterion("ID_CARD_NUM <>", value, "idCardNum");
			return (Criteria) this;
		}

		public Criteria andIdCardNumGreaterThan(String value) {
			addCriterion("ID_CARD_NUM >", value, "idCardNum");
			return (Criteria) this;
		}

		public Criteria andIdCardNumGreaterThanOrEqualTo(String value) {
			addCriterion("ID_CARD_NUM >=", value, "idCardNum");
			return (Criteria) this;
		}

		public Criteria andIdCardNumLessThan(String value) {
			addCriterion("ID_CARD_NUM <", value, "idCardNum");
			return (Criteria) this;
		}

		public Criteria andIdCardNumLessThanOrEqualTo(String value) {
			addCriterion("ID_CARD_NUM <=", value, "idCardNum");
			return (Criteria) this;
		}

		public Criteria andIdCardNumLike(String value) {
			addCriterion("ID_CARD_NUM like", value, "idCardNum");
			return (Criteria) this;
		}

		public Criteria andIdCardNumNotLike(String value) {
			addCriterion("ID_CARD_NUM not like", value, "idCardNum");
			return (Criteria) this;
		}

		public Criteria andIdCardNumIn(List<String> values) {
			addCriterion("ID_CARD_NUM in", values, "idCardNum");
			return (Criteria) this;
		}

		public Criteria andIdCardNumNotIn(List<String> values) {
			addCriterion("ID_CARD_NUM not in", values, "idCardNum");
			return (Criteria) this;
		}

		public Criteria andIdCardNumBetween(String value1, String value2) {
			addCriterion("ID_CARD_NUM between", value1, value2, "idCardNum");
			return (Criteria) this;
		}

		public Criteria andIdCardNumNotBetween(String value1, String value2) {
			addCriterion("ID_CARD_NUM not between", value1, value2, "idCardNum");
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

		public Criteria andCaseIdIsNull() {
			addCriterion("CASE_ID is null");
			return (Criteria) this;
		}

		public Criteria andCaseIdIsNotNull() {
			addCriterion("CASE_ID is not null");
			return (Criteria) this;
		}

		public Criteria andCaseIdEqualTo(Integer value) {
			addCriterion("CASE_ID =", value, "caseId");
			return (Criteria) this;
		}

		public Criteria andCaseIdNotEqualTo(Integer value) {
			addCriterion("CASE_ID <>", value, "caseId");
			return (Criteria) this;
		}

		public Criteria andCaseIdGreaterThan(Integer value) {
			addCriterion("CASE_ID >", value, "caseId");
			return (Criteria) this;
		}

		public Criteria andCaseIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("CASE_ID >=", value, "caseId");
			return (Criteria) this;
		}

		public Criteria andCaseIdLessThan(Integer value) {
			addCriterion("CASE_ID <", value, "caseId");
			return (Criteria) this;
		}

		public Criteria andCaseIdLessThanOrEqualTo(Integer value) {
			addCriterion("CASE_ID <=", value, "caseId");
			return (Criteria) this;
		}

		public Criteria andCaseIdIn(List<Integer> values) {
			addCriterion("CASE_ID in", values, "caseId");
			return (Criteria) this;
		}

		public Criteria andCaseIdNotIn(List<Integer> values) {
			addCriterion("CASE_ID not in", values, "caseId");
			return (Criteria) this;
		}

		public Criteria andCaseIdBetween(Integer value1, Integer value2) {
			addCriterion("CASE_ID between", value1, value2, "caseId");
			return (Criteria) this;
		}

		public Criteria andCaseIdNotBetween(Integer value1, Integer value2) {
			addCriterion("CASE_ID not between", value1, value2, "caseId");
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