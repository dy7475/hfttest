package com.myfun.repository.admindb.po;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AdminXwBankAccountExample {
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
	public AdminXwBankAccountExample() {
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

		public Criteria andAccountTypeIsNull() {
			addCriterion("ACCOUNT_TYPE is null");
			return (Criteria) this;
		}

		public Criteria andAccountTypeIsNotNull() {
			addCriterion("ACCOUNT_TYPE is not null");
			return (Criteria) this;
		}

		public Criteria andAccountTypeEqualTo(Byte value) {
			addCriterion("ACCOUNT_TYPE =", value, "accountType");
			return (Criteria) this;
		}

		public Criteria andAccountTypeNotEqualTo(Byte value) {
			addCriterion("ACCOUNT_TYPE <>", value, "accountType");
			return (Criteria) this;
		}

		public Criteria andAccountTypeGreaterThan(Byte value) {
			addCriterion("ACCOUNT_TYPE >", value, "accountType");
			return (Criteria) this;
		}

		public Criteria andAccountTypeGreaterThanOrEqualTo(Byte value) {
			addCriterion("ACCOUNT_TYPE >=", value, "accountType");
			return (Criteria) this;
		}

		public Criteria andAccountTypeLessThan(Byte value) {
			addCriterion("ACCOUNT_TYPE <", value, "accountType");
			return (Criteria) this;
		}

		public Criteria andAccountTypeLessThanOrEqualTo(Byte value) {
			addCriterion("ACCOUNT_TYPE <=", value, "accountType");
			return (Criteria) this;
		}

		public Criteria andAccountTypeIn(List<Byte> values) {
			addCriterion("ACCOUNT_TYPE in", values, "accountType");
			return (Criteria) this;
		}

		public Criteria andAccountTypeNotIn(List<Byte> values) {
			addCriterion("ACCOUNT_TYPE not in", values, "accountType");
			return (Criteria) this;
		}

		public Criteria andAccountTypeBetween(Byte value1, Byte value2) {
			addCriterion("ACCOUNT_TYPE between", value1, value2, "accountType");
			return (Criteria) this;
		}

		public Criteria andAccountTypeNotBetween(Byte value1, Byte value2) {
			addCriterion("ACCOUNT_TYPE not between", value1, value2, "accountType");
			return (Criteria) this;
		}

		public Criteria andOpenAccountNoIsNull() {
			addCriterion("OPEN_ACCOUNT_NO is null");
			return (Criteria) this;
		}

		public Criteria andOpenAccountNoIsNotNull() {
			addCriterion("OPEN_ACCOUNT_NO is not null");
			return (Criteria) this;
		}

		public Criteria andOpenAccountNoEqualTo(String value) {
			addCriterion("OPEN_ACCOUNT_NO =", value, "openAccountNo");
			return (Criteria) this;
		}

		public Criteria andOpenAccountNoNotEqualTo(String value) {
			addCriterion("OPEN_ACCOUNT_NO <>", value, "openAccountNo");
			return (Criteria) this;
		}

		public Criteria andOpenAccountNoGreaterThan(String value) {
			addCriterion("OPEN_ACCOUNT_NO >", value, "openAccountNo");
			return (Criteria) this;
		}

		public Criteria andOpenAccountNoGreaterThanOrEqualTo(String value) {
			addCriterion("OPEN_ACCOUNT_NO >=", value, "openAccountNo");
			return (Criteria) this;
		}

		public Criteria andOpenAccountNoLessThan(String value) {
			addCriterion("OPEN_ACCOUNT_NO <", value, "openAccountNo");
			return (Criteria) this;
		}

		public Criteria andOpenAccountNoLessThanOrEqualTo(String value) {
			addCriterion("OPEN_ACCOUNT_NO <=", value, "openAccountNo");
			return (Criteria) this;
		}

		public Criteria andOpenAccountNoLike(String value) {
			addCriterion("OPEN_ACCOUNT_NO like", value, "openAccountNo");
			return (Criteria) this;
		}

		public Criteria andOpenAccountNoNotLike(String value) {
			addCriterion("OPEN_ACCOUNT_NO not like", value, "openAccountNo");
			return (Criteria) this;
		}

		public Criteria andOpenAccountNoIn(List<String> values) {
			addCriterion("OPEN_ACCOUNT_NO in", values, "openAccountNo");
			return (Criteria) this;
		}

		public Criteria andOpenAccountNoNotIn(List<String> values) {
			addCriterion("OPEN_ACCOUNT_NO not in", values, "openAccountNo");
			return (Criteria) this;
		}

		public Criteria andOpenAccountNoBetween(String value1, String value2) {
			addCriterion("OPEN_ACCOUNT_NO between", value1, value2, "openAccountNo");
			return (Criteria) this;
		}

		public Criteria andOpenAccountNoNotBetween(String value1, String value2) {
			addCriterion("OPEN_ACCOUNT_NO not between", value1, value2, "openAccountNo");
			return (Criteria) this;
		}

		public Criteria andOpenAccountStatusIsNull() {
			addCriterion("OPEN_ACCOUNT_STATUS is null");
			return (Criteria) this;
		}

		public Criteria andOpenAccountStatusIsNotNull() {
			addCriterion("OPEN_ACCOUNT_STATUS is not null");
			return (Criteria) this;
		}

		public Criteria andOpenAccountStatusEqualTo(Byte value) {
			addCriterion("OPEN_ACCOUNT_STATUS =", value, "openAccountStatus");
			return (Criteria) this;
		}

		public Criteria andOpenAccountStatusNotEqualTo(Byte value) {
			addCriterion("OPEN_ACCOUNT_STATUS <>", value, "openAccountStatus");
			return (Criteria) this;
		}

		public Criteria andOpenAccountStatusGreaterThan(Byte value) {
			addCriterion("OPEN_ACCOUNT_STATUS >", value, "openAccountStatus");
			return (Criteria) this;
		}

		public Criteria andOpenAccountStatusGreaterThanOrEqualTo(Byte value) {
			addCriterion("OPEN_ACCOUNT_STATUS >=", value, "openAccountStatus");
			return (Criteria) this;
		}

		public Criteria andOpenAccountStatusLessThan(Byte value) {
			addCriterion("OPEN_ACCOUNT_STATUS <", value, "openAccountStatus");
			return (Criteria) this;
		}

		public Criteria andOpenAccountStatusLessThanOrEqualTo(Byte value) {
			addCriterion("OPEN_ACCOUNT_STATUS <=", value, "openAccountStatus");
			return (Criteria) this;
		}

		public Criteria andOpenAccountStatusIn(List<Byte> values) {
			addCriterion("OPEN_ACCOUNT_STATUS in", values, "openAccountStatus");
			return (Criteria) this;
		}

		public Criteria andOpenAccountStatusNotIn(List<Byte> values) {
			addCriterion("OPEN_ACCOUNT_STATUS not in", values, "openAccountStatus");
			return (Criteria) this;
		}

		public Criteria andOpenAccountStatusBetween(Byte value1, Byte value2) {
			addCriterion("OPEN_ACCOUNT_STATUS between", value1, value2, "openAccountStatus");
			return (Criteria) this;
		}

		public Criteria andOpenAccountStatusNotBetween(Byte value1, Byte value2) {
			addCriterion("OPEN_ACCOUNT_STATUS not between", value1, value2, "openAccountStatus");
			return (Criteria) this;
		}

		public Criteria andAccountHftIdentificationIsNull() {
			addCriterion("ACCOUNT_HFT_IDENTIFICATION is null");
			return (Criteria) this;
		}

		public Criteria andAccountHftIdentificationIsNotNull() {
			addCriterion("ACCOUNT_HFT_IDENTIFICATION is not null");
			return (Criteria) this;
		}

		public Criteria andAccountHftIdentificationEqualTo(Integer value) {
			addCriterion("ACCOUNT_HFT_IDENTIFICATION =", value, "accountHftIdentification");
			return (Criteria) this;
		}

		public Criteria andAccountHftIdentificationNotEqualTo(Integer value) {
			addCriterion("ACCOUNT_HFT_IDENTIFICATION <>", value, "accountHftIdentification");
			return (Criteria) this;
		}

		public Criteria andAccountHftIdentificationGreaterThan(Integer value) {
			addCriterion("ACCOUNT_HFT_IDENTIFICATION >", value, "accountHftIdentification");
			return (Criteria) this;
		}

		public Criteria andAccountHftIdentificationGreaterThanOrEqualTo(Integer value) {
			addCriterion("ACCOUNT_HFT_IDENTIFICATION >=", value, "accountHftIdentification");
			return (Criteria) this;
		}

		public Criteria andAccountHftIdentificationLessThan(Integer value) {
			addCriterion("ACCOUNT_HFT_IDENTIFICATION <", value, "accountHftIdentification");
			return (Criteria) this;
		}

		public Criteria andAccountHftIdentificationLessThanOrEqualTo(Integer value) {
			addCriterion("ACCOUNT_HFT_IDENTIFICATION <=", value, "accountHftIdentification");
			return (Criteria) this;
		}

		public Criteria andAccountHftIdentificationIn(List<Integer> values) {
			addCriterion("ACCOUNT_HFT_IDENTIFICATION in", values, "accountHftIdentification");
			return (Criteria) this;
		}

		public Criteria andAccountHftIdentificationNotIn(List<Integer> values) {
			addCriterion("ACCOUNT_HFT_IDENTIFICATION not in", values, "accountHftIdentification");
			return (Criteria) this;
		}

		public Criteria andAccountHftIdentificationBetween(Integer value1, Integer value2) {
			addCriterion("ACCOUNT_HFT_IDENTIFICATION between", value1, value2, "accountHftIdentification");
			return (Criteria) this;
		}

		public Criteria andAccountHftIdentificationNotBetween(Integer value1, Integer value2) {
			addCriterion("ACCOUNT_HFT_IDENTIFICATION not between", value1, value2, "accountHftIdentification");
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