package com.myfun.repository.admindb.po;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AdminYouViewFeeWithdrawalsExample {
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
	public AdminYouViewFeeWithdrawalsExample() {
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

		public Criteria andUserMobileIsNull() {
			addCriterion("USER_MOBILE is null");
			return (Criteria) this;
		}

		public Criteria andUserMobileIsNotNull() {
			addCriterion("USER_MOBILE is not null");
			return (Criteria) this;
		}

		public Criteria andUserMobileEqualTo(String value) {
			addCriterion("USER_MOBILE =", value, "userMobile");
			return (Criteria) this;
		}

		public Criteria andUserMobileNotEqualTo(String value) {
			addCriterion("USER_MOBILE <>", value, "userMobile");
			return (Criteria) this;
		}

		public Criteria andUserMobileGreaterThan(String value) {
			addCriterion("USER_MOBILE >", value, "userMobile");
			return (Criteria) this;
		}

		public Criteria andUserMobileGreaterThanOrEqualTo(String value) {
			addCriterion("USER_MOBILE >=", value, "userMobile");
			return (Criteria) this;
		}

		public Criteria andUserMobileLessThan(String value) {
			addCriterion("USER_MOBILE <", value, "userMobile");
			return (Criteria) this;
		}

		public Criteria andUserMobileLessThanOrEqualTo(String value) {
			addCriterion("USER_MOBILE <=", value, "userMobile");
			return (Criteria) this;
		}

		public Criteria andUserMobileLike(String value) {
			addCriterion("USER_MOBILE like", value, "userMobile");
			return (Criteria) this;
		}

		public Criteria andUserMobileNotLike(String value) {
			addCriterion("USER_MOBILE not like", value, "userMobile");
			return (Criteria) this;
		}

		public Criteria andUserMobileIn(List<String> values) {
			addCriterion("USER_MOBILE in", values, "userMobile");
			return (Criteria) this;
		}

		public Criteria andUserMobileNotIn(List<String> values) {
			addCriterion("USER_MOBILE not in", values, "userMobile");
			return (Criteria) this;
		}

		public Criteria andUserMobileBetween(String value1, String value2) {
			addCriterion("USER_MOBILE between", value1, value2, "userMobile");
			return (Criteria) this;
		}

		public Criteria andUserMobileNotBetween(String value1, String value2) {
			addCriterion("USER_MOBILE not between", value1, value2, "userMobile");
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

		public Criteria andUaIdIsNull() {
			addCriterion("UA_ID is null");
			return (Criteria) this;
		}

		public Criteria andUaIdIsNotNull() {
			addCriterion("UA_ID is not null");
			return (Criteria) this;
		}

		public Criteria andUaIdEqualTo(Integer value) {
			addCriterion("UA_ID =", value, "uaId");
			return (Criteria) this;
		}

		public Criteria andUaIdNotEqualTo(Integer value) {
			addCriterion("UA_ID <>", value, "uaId");
			return (Criteria) this;
		}

		public Criteria andUaIdGreaterThan(Integer value) {
			addCriterion("UA_ID >", value, "uaId");
			return (Criteria) this;
		}

		public Criteria andUaIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("UA_ID >=", value, "uaId");
			return (Criteria) this;
		}

		public Criteria andUaIdLessThan(Integer value) {
			addCriterion("UA_ID <", value, "uaId");
			return (Criteria) this;
		}

		public Criteria andUaIdLessThanOrEqualTo(Integer value) {
			addCriterion("UA_ID <=", value, "uaId");
			return (Criteria) this;
		}

		public Criteria andUaIdIn(List<Integer> values) {
			addCriterion("UA_ID in", values, "uaId");
			return (Criteria) this;
		}

		public Criteria andUaIdNotIn(List<Integer> values) {
			addCriterion("UA_ID not in", values, "uaId");
			return (Criteria) this;
		}

		public Criteria andUaIdBetween(Integer value1, Integer value2) {
			addCriterion("UA_ID between", value1, value2, "uaId");
			return (Criteria) this;
		}

		public Criteria andUaIdNotBetween(Integer value1, Integer value2) {
			addCriterion("UA_ID not between", value1, value2, "uaId");
			return (Criteria) this;
		}

		public Criteria andWithdrawalsAmountIsNull() {
			addCriterion("WITHDRAWALS_AMOUNT is null");
			return (Criteria) this;
		}

		public Criteria andWithdrawalsAmountIsNotNull() {
			addCriterion("WITHDRAWALS_AMOUNT is not null");
			return (Criteria) this;
		}

		public Criteria andWithdrawalsAmountEqualTo(BigDecimal value) {
			addCriterion("WITHDRAWALS_AMOUNT =", value, "withdrawalsAmount");
			return (Criteria) this;
		}

		public Criteria andWithdrawalsAmountNotEqualTo(BigDecimal value) {
			addCriterion("WITHDRAWALS_AMOUNT <>", value, "withdrawalsAmount");
			return (Criteria) this;
		}

		public Criteria andWithdrawalsAmountGreaterThan(BigDecimal value) {
			addCriterion("WITHDRAWALS_AMOUNT >", value, "withdrawalsAmount");
			return (Criteria) this;
		}

		public Criteria andWithdrawalsAmountGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("WITHDRAWALS_AMOUNT >=", value, "withdrawalsAmount");
			return (Criteria) this;
		}

		public Criteria andWithdrawalsAmountLessThan(BigDecimal value) {
			addCriterion("WITHDRAWALS_AMOUNT <", value, "withdrawalsAmount");
			return (Criteria) this;
		}

		public Criteria andWithdrawalsAmountLessThanOrEqualTo(BigDecimal value) {
			addCriterion("WITHDRAWALS_AMOUNT <=", value, "withdrawalsAmount");
			return (Criteria) this;
		}

		public Criteria andWithdrawalsAmountIn(List<BigDecimal> values) {
			addCriterion("WITHDRAWALS_AMOUNT in", values, "withdrawalsAmount");
			return (Criteria) this;
		}

		public Criteria andWithdrawalsAmountNotIn(List<BigDecimal> values) {
			addCriterion("WITHDRAWALS_AMOUNT not in", values, "withdrawalsAmount");
			return (Criteria) this;
		}

		public Criteria andWithdrawalsAmountBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("WITHDRAWALS_AMOUNT between", value1, value2, "withdrawalsAmount");
			return (Criteria) this;
		}

		public Criteria andWithdrawalsAmountNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("WITHDRAWALS_AMOUNT not between", value1, value2, "withdrawalsAmount");
			return (Criteria) this;
		}

		public Criteria andWithdrawalsTypeIsNull() {
			addCriterion("WITHDRAWALS_TYPE is null");
			return (Criteria) this;
		}

		public Criteria andWithdrawalsTypeIsNotNull() {
			addCriterion("WITHDRAWALS_TYPE is not null");
			return (Criteria) this;
		}

		public Criteria andWithdrawalsTypeEqualTo(Byte value) {
			addCriterion("WITHDRAWALS_TYPE =", value, "withdrawalsType");
			return (Criteria) this;
		}

		public Criteria andWithdrawalsTypeNotEqualTo(Byte value) {
			addCriterion("WITHDRAWALS_TYPE <>", value, "withdrawalsType");
			return (Criteria) this;
		}

		public Criteria andWithdrawalsTypeGreaterThan(Byte value) {
			addCriterion("WITHDRAWALS_TYPE >", value, "withdrawalsType");
			return (Criteria) this;
		}

		public Criteria andWithdrawalsTypeGreaterThanOrEqualTo(Byte value) {
			addCriterion("WITHDRAWALS_TYPE >=", value, "withdrawalsType");
			return (Criteria) this;
		}

		public Criteria andWithdrawalsTypeLessThan(Byte value) {
			addCriterion("WITHDRAWALS_TYPE <", value, "withdrawalsType");
			return (Criteria) this;
		}

		public Criteria andWithdrawalsTypeLessThanOrEqualTo(Byte value) {
			addCriterion("WITHDRAWALS_TYPE <=", value, "withdrawalsType");
			return (Criteria) this;
		}

		public Criteria andWithdrawalsTypeIn(List<Byte> values) {
			addCriterion("WITHDRAWALS_TYPE in", values, "withdrawalsType");
			return (Criteria) this;
		}

		public Criteria andWithdrawalsTypeNotIn(List<Byte> values) {
			addCriterion("WITHDRAWALS_TYPE not in", values, "withdrawalsType");
			return (Criteria) this;
		}

		public Criteria andWithdrawalsTypeBetween(Byte value1, Byte value2) {
			addCriterion("WITHDRAWALS_TYPE between", value1, value2, "withdrawalsType");
			return (Criteria) this;
		}

		public Criteria andWithdrawalsTypeNotBetween(Byte value1, Byte value2) {
			addCriterion("WITHDRAWALS_TYPE not between", value1, value2, "withdrawalsType");
			return (Criteria) this;
		}

		public Criteria andPayeeUserNameIsNull() {
			addCriterion("PAYEE_USER_NAME is null");
			return (Criteria) this;
		}

		public Criteria andPayeeUserNameIsNotNull() {
			addCriterion("PAYEE_USER_NAME is not null");
			return (Criteria) this;
		}

		public Criteria andPayeeUserNameEqualTo(String value) {
			addCriterion("PAYEE_USER_NAME =", value, "payeeUserName");
			return (Criteria) this;
		}

		public Criteria andPayeeUserNameNotEqualTo(String value) {
			addCriterion("PAYEE_USER_NAME <>", value, "payeeUserName");
			return (Criteria) this;
		}

		public Criteria andPayeeUserNameGreaterThan(String value) {
			addCriterion("PAYEE_USER_NAME >", value, "payeeUserName");
			return (Criteria) this;
		}

		public Criteria andPayeeUserNameGreaterThanOrEqualTo(String value) {
			addCriterion("PAYEE_USER_NAME >=", value, "payeeUserName");
			return (Criteria) this;
		}

		public Criteria andPayeeUserNameLessThan(String value) {
			addCriterion("PAYEE_USER_NAME <", value, "payeeUserName");
			return (Criteria) this;
		}

		public Criteria andPayeeUserNameLessThanOrEqualTo(String value) {
			addCriterion("PAYEE_USER_NAME <=", value, "payeeUserName");
			return (Criteria) this;
		}

		public Criteria andPayeeUserNameLike(String value) {
			addCriterion("PAYEE_USER_NAME like", value, "payeeUserName");
			return (Criteria) this;
		}

		public Criteria andPayeeUserNameNotLike(String value) {
			addCriterion("PAYEE_USER_NAME not like", value, "payeeUserName");
			return (Criteria) this;
		}

		public Criteria andPayeeUserNameIn(List<String> values) {
			addCriterion("PAYEE_USER_NAME in", values, "payeeUserName");
			return (Criteria) this;
		}

		public Criteria andPayeeUserNameNotIn(List<String> values) {
			addCriterion("PAYEE_USER_NAME not in", values, "payeeUserName");
			return (Criteria) this;
		}

		public Criteria andPayeeUserNameBetween(String value1, String value2) {
			addCriterion("PAYEE_USER_NAME between", value1, value2, "payeeUserName");
			return (Criteria) this;
		}

		public Criteria andPayeeUserNameNotBetween(String value1, String value2) {
			addCriterion("PAYEE_USER_NAME not between", value1, value2, "payeeUserName");
			return (Criteria) this;
		}

		public Criteria andPayeeWeixinNameIsNull() {
			addCriterion("PAYEE_WEIXIN_NAME is null");
			return (Criteria) this;
		}

		public Criteria andPayeeWeixinNameIsNotNull() {
			addCriterion("PAYEE_WEIXIN_NAME is not null");
			return (Criteria) this;
		}

		public Criteria andPayeeWeixinNameEqualTo(String value) {
			addCriterion("PAYEE_WEIXIN_NAME =", value, "payeeWeixinName");
			return (Criteria) this;
		}

		public Criteria andPayeeWeixinNameNotEqualTo(String value) {
			addCriterion("PAYEE_WEIXIN_NAME <>", value, "payeeWeixinName");
			return (Criteria) this;
		}

		public Criteria andPayeeWeixinNameGreaterThan(String value) {
			addCriterion("PAYEE_WEIXIN_NAME >", value, "payeeWeixinName");
			return (Criteria) this;
		}

		public Criteria andPayeeWeixinNameGreaterThanOrEqualTo(String value) {
			addCriterion("PAYEE_WEIXIN_NAME >=", value, "payeeWeixinName");
			return (Criteria) this;
		}

		public Criteria andPayeeWeixinNameLessThan(String value) {
			addCriterion("PAYEE_WEIXIN_NAME <", value, "payeeWeixinName");
			return (Criteria) this;
		}

		public Criteria andPayeeWeixinNameLessThanOrEqualTo(String value) {
			addCriterion("PAYEE_WEIXIN_NAME <=", value, "payeeWeixinName");
			return (Criteria) this;
		}

		public Criteria andPayeeWeixinNameLike(String value) {
			addCriterion("PAYEE_WEIXIN_NAME like", value, "payeeWeixinName");
			return (Criteria) this;
		}

		public Criteria andPayeeWeixinNameNotLike(String value) {
			addCriterion("PAYEE_WEIXIN_NAME not like", value, "payeeWeixinName");
			return (Criteria) this;
		}

		public Criteria andPayeeWeixinNameIn(List<String> values) {
			addCriterion("PAYEE_WEIXIN_NAME in", values, "payeeWeixinName");
			return (Criteria) this;
		}

		public Criteria andPayeeWeixinNameNotIn(List<String> values) {
			addCriterion("PAYEE_WEIXIN_NAME not in", values, "payeeWeixinName");
			return (Criteria) this;
		}

		public Criteria andPayeeWeixinNameBetween(String value1, String value2) {
			addCriterion("PAYEE_WEIXIN_NAME between", value1, value2, "payeeWeixinName");
			return (Criteria) this;
		}

		public Criteria andPayeeWeixinNameNotBetween(String value1, String value2) {
			addCriterion("PAYEE_WEIXIN_NAME not between", value1, value2, "payeeWeixinName");
			return (Criteria) this;
		}

		public Criteria andPayeeAccountIsNull() {
			addCriterion("PAYEE_ACCOUNT is null");
			return (Criteria) this;
		}

		public Criteria andPayeeAccountIsNotNull() {
			addCriterion("PAYEE_ACCOUNT is not null");
			return (Criteria) this;
		}

		public Criteria andPayeeAccountEqualTo(String value) {
			addCriterion("PAYEE_ACCOUNT =", value, "payeeAccount");
			return (Criteria) this;
		}

		public Criteria andPayeeAccountNotEqualTo(String value) {
			addCriterion("PAYEE_ACCOUNT <>", value, "payeeAccount");
			return (Criteria) this;
		}

		public Criteria andPayeeAccountGreaterThan(String value) {
			addCriterion("PAYEE_ACCOUNT >", value, "payeeAccount");
			return (Criteria) this;
		}

		public Criteria andPayeeAccountGreaterThanOrEqualTo(String value) {
			addCriterion("PAYEE_ACCOUNT >=", value, "payeeAccount");
			return (Criteria) this;
		}

		public Criteria andPayeeAccountLessThan(String value) {
			addCriterion("PAYEE_ACCOUNT <", value, "payeeAccount");
			return (Criteria) this;
		}

		public Criteria andPayeeAccountLessThanOrEqualTo(String value) {
			addCriterion("PAYEE_ACCOUNT <=", value, "payeeAccount");
			return (Criteria) this;
		}

		public Criteria andPayeeAccountLike(String value) {
			addCriterion("PAYEE_ACCOUNT like", value, "payeeAccount");
			return (Criteria) this;
		}

		public Criteria andPayeeAccountNotLike(String value) {
			addCriterion("PAYEE_ACCOUNT not like", value, "payeeAccount");
			return (Criteria) this;
		}

		public Criteria andPayeeAccountIn(List<String> values) {
			addCriterion("PAYEE_ACCOUNT in", values, "payeeAccount");
			return (Criteria) this;
		}

		public Criteria andPayeeAccountNotIn(List<String> values) {
			addCriterion("PAYEE_ACCOUNT not in", values, "payeeAccount");
			return (Criteria) this;
		}

		public Criteria andPayeeAccountBetween(String value1, String value2) {
			addCriterion("PAYEE_ACCOUNT between", value1, value2, "payeeAccount");
			return (Criteria) this;
		}

		public Criteria andPayeeAccountNotBetween(String value1, String value2) {
			addCriterion("PAYEE_ACCOUNT not between", value1, value2, "payeeAccount");
			return (Criteria) this;
		}

		public Criteria andAuditUserIsNull() {
			addCriterion("AUDIT_USER is null");
			return (Criteria) this;
		}

		public Criteria andAuditUserIsNotNull() {
			addCriterion("AUDIT_USER is not null");
			return (Criteria) this;
		}

		public Criteria andAuditUserEqualTo(Integer value) {
			addCriterion("AUDIT_USER =", value, "auditUser");
			return (Criteria) this;
		}

		public Criteria andAuditUserNotEqualTo(Integer value) {
			addCriterion("AUDIT_USER <>", value, "auditUser");
			return (Criteria) this;
		}

		public Criteria andAuditUserGreaterThan(Integer value) {
			addCriterion("AUDIT_USER >", value, "auditUser");
			return (Criteria) this;
		}

		public Criteria andAuditUserGreaterThanOrEqualTo(Integer value) {
			addCriterion("AUDIT_USER >=", value, "auditUser");
			return (Criteria) this;
		}

		public Criteria andAuditUserLessThan(Integer value) {
			addCriterion("AUDIT_USER <", value, "auditUser");
			return (Criteria) this;
		}

		public Criteria andAuditUserLessThanOrEqualTo(Integer value) {
			addCriterion("AUDIT_USER <=", value, "auditUser");
			return (Criteria) this;
		}

		public Criteria andAuditUserIn(List<Integer> values) {
			addCriterion("AUDIT_USER in", values, "auditUser");
			return (Criteria) this;
		}

		public Criteria andAuditUserNotIn(List<Integer> values) {
			addCriterion("AUDIT_USER not in", values, "auditUser");
			return (Criteria) this;
		}

		public Criteria andAuditUserBetween(Integer value1, Integer value2) {
			addCriterion("AUDIT_USER between", value1, value2, "auditUser");
			return (Criteria) this;
		}

		public Criteria andAuditUserNotBetween(Integer value1, Integer value2) {
			addCriterion("AUDIT_USER not between", value1, value2, "auditUser");
			return (Criteria) this;
		}

		public Criteria andAuditTimeIsNull() {
			addCriterion("AUDIT_TIME is null");
			return (Criteria) this;
		}

		public Criteria andAuditTimeIsNotNull() {
			addCriterion("AUDIT_TIME is not null");
			return (Criteria) this;
		}

		public Criteria andAuditTimeEqualTo(Date value) {
			addCriterion("AUDIT_TIME =", value, "auditTime");
			return (Criteria) this;
		}

		public Criteria andAuditTimeNotEqualTo(Date value) {
			addCriterion("AUDIT_TIME <>", value, "auditTime");
			return (Criteria) this;
		}

		public Criteria andAuditTimeGreaterThan(Date value) {
			addCriterion("AUDIT_TIME >", value, "auditTime");
			return (Criteria) this;
		}

		public Criteria andAuditTimeGreaterThanOrEqualTo(Date value) {
			addCriterion("AUDIT_TIME >=", value, "auditTime");
			return (Criteria) this;
		}

		public Criteria andAuditTimeLessThan(Date value) {
			addCriterion("AUDIT_TIME <", value, "auditTime");
			return (Criteria) this;
		}

		public Criteria andAuditTimeLessThanOrEqualTo(Date value) {
			addCriterion("AUDIT_TIME <=", value, "auditTime");
			return (Criteria) this;
		}

		public Criteria andAuditTimeIn(List<Date> values) {
			addCriterion("AUDIT_TIME in", values, "auditTime");
			return (Criteria) this;
		}

		public Criteria andAuditTimeNotIn(List<Date> values) {
			addCriterion("AUDIT_TIME not in", values, "auditTime");
			return (Criteria) this;
		}

		public Criteria andAuditTimeBetween(Date value1, Date value2) {
			addCriterion("AUDIT_TIME between", value1, value2, "auditTime");
			return (Criteria) this;
		}

		public Criteria andAuditTimeNotBetween(Date value1, Date value2) {
			addCriterion("AUDIT_TIME not between", value1, value2, "auditTime");
			return (Criteria) this;
		}

		public Criteria andAuditResultIsNull() {
			addCriterion("AUDIT_RESULT is null");
			return (Criteria) this;
		}

		public Criteria andAuditResultIsNotNull() {
			addCriterion("AUDIT_RESULT is not null");
			return (Criteria) this;
		}

		public Criteria andAuditResultEqualTo(Byte value) {
			addCriterion("AUDIT_RESULT =", value, "auditResult");
			return (Criteria) this;
		}

		public Criteria andAuditResultNotEqualTo(Byte value) {
			addCriterion("AUDIT_RESULT <>", value, "auditResult");
			return (Criteria) this;
		}

		public Criteria andAuditResultGreaterThan(Byte value) {
			addCriterion("AUDIT_RESULT >", value, "auditResult");
			return (Criteria) this;
		}

		public Criteria andAuditResultGreaterThanOrEqualTo(Byte value) {
			addCriterion("AUDIT_RESULT >=", value, "auditResult");
			return (Criteria) this;
		}

		public Criteria andAuditResultLessThan(Byte value) {
			addCriterion("AUDIT_RESULT <", value, "auditResult");
			return (Criteria) this;
		}

		public Criteria andAuditResultLessThanOrEqualTo(Byte value) {
			addCriterion("AUDIT_RESULT <=", value, "auditResult");
			return (Criteria) this;
		}

		public Criteria andAuditResultIn(List<Byte> values) {
			addCriterion("AUDIT_RESULT in", values, "auditResult");
			return (Criteria) this;
		}

		public Criteria andAuditResultNotIn(List<Byte> values) {
			addCriterion("AUDIT_RESULT not in", values, "auditResult");
			return (Criteria) this;
		}

		public Criteria andAuditResultBetween(Byte value1, Byte value2) {
			addCriterion("AUDIT_RESULT between", value1, value2, "auditResult");
			return (Criteria) this;
		}

		public Criteria andAuditResultNotBetween(Byte value1, Byte value2) {
			addCriterion("AUDIT_RESULT not between", value1, value2, "auditResult");
			return (Criteria) this;
		}

		public Criteria andAuditExplainIsNull() {
			addCriterion("AUDIT_EXPLAIN is null");
			return (Criteria) this;
		}

		public Criteria andAuditExplainIsNotNull() {
			addCriterion("AUDIT_EXPLAIN is not null");
			return (Criteria) this;
		}

		public Criteria andAuditExplainEqualTo(String value) {
			addCriterion("AUDIT_EXPLAIN =", value, "auditExplain");
			return (Criteria) this;
		}

		public Criteria andAuditExplainNotEqualTo(String value) {
			addCriterion("AUDIT_EXPLAIN <>", value, "auditExplain");
			return (Criteria) this;
		}

		public Criteria andAuditExplainGreaterThan(String value) {
			addCriterion("AUDIT_EXPLAIN >", value, "auditExplain");
			return (Criteria) this;
		}

		public Criteria andAuditExplainGreaterThanOrEqualTo(String value) {
			addCriterion("AUDIT_EXPLAIN >=", value, "auditExplain");
			return (Criteria) this;
		}

		public Criteria andAuditExplainLessThan(String value) {
			addCriterion("AUDIT_EXPLAIN <", value, "auditExplain");
			return (Criteria) this;
		}

		public Criteria andAuditExplainLessThanOrEqualTo(String value) {
			addCriterion("AUDIT_EXPLAIN <=", value, "auditExplain");
			return (Criteria) this;
		}

		public Criteria andAuditExplainLike(String value) {
			addCriterion("AUDIT_EXPLAIN like", value, "auditExplain");
			return (Criteria) this;
		}

		public Criteria andAuditExplainNotLike(String value) {
			addCriterion("AUDIT_EXPLAIN not like", value, "auditExplain");
			return (Criteria) this;
		}

		public Criteria andAuditExplainIn(List<String> values) {
			addCriterion("AUDIT_EXPLAIN in", values, "auditExplain");
			return (Criteria) this;
		}

		public Criteria andAuditExplainNotIn(List<String> values) {
			addCriterion("AUDIT_EXPLAIN not in", values, "auditExplain");
			return (Criteria) this;
		}

		public Criteria andAuditExplainBetween(String value1, String value2) {
			addCriterion("AUDIT_EXPLAIN between", value1, value2, "auditExplain");
			return (Criteria) this;
		}

		public Criteria andAuditExplainNotBetween(String value1, String value2) {
			addCriterion("AUDIT_EXPLAIN not between", value1, value2, "auditExplain");
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