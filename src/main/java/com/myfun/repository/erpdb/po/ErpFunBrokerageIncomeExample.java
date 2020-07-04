package com.myfun.repository.erpdb.po;

import com.myfun.repository.support.generator.shard.ShardDb;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.math.BigDecimal;

public class ErpFunBrokerageIncomeExample extends ShardDb {
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
	public ErpFunBrokerageIncomeExample() {
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

		public Criteria andCommionTypeIsNull() {
			addCriterion("COMMION_TYPE is null");
			return (Criteria) this;
		}

		public Criteria andCommionTypeIsNotNull() {
			addCriterion("COMMION_TYPE is not null");
			return (Criteria) this;
		}

		public Criteria andCommionTypeEqualTo(Byte value) {
			addCriterion("COMMION_TYPE =", value, "commionType");
			return (Criteria) this;
		}

		public Criteria andCommionTypeNotEqualTo(Byte value) {
			addCriterion("COMMION_TYPE <>", value, "commionType");
			return (Criteria) this;
		}

		public Criteria andCommionTypeGreaterThan(Byte value) {
			addCriterion("COMMION_TYPE >", value, "commionType");
			return (Criteria) this;
		}

		public Criteria andCommionTypeGreaterThanOrEqualTo(Byte value) {
			addCriterion("COMMION_TYPE >=", value, "commionType");
			return (Criteria) this;
		}

		public Criteria andCommionTypeLessThan(Byte value) {
			addCriterion("COMMION_TYPE <", value, "commionType");
			return (Criteria) this;
		}

		public Criteria andCommionTypeLessThanOrEqualTo(Byte value) {
			addCriterion("COMMION_TYPE <=", value, "commionType");
			return (Criteria) this;
		}

		public Criteria andCommionTypeIn(List<Byte> values) {
			addCriterion("COMMION_TYPE in", values, "commionType");
			return (Criteria) this;
		}

		public Criteria andCommionTypeNotIn(List<Byte> values) {
			addCriterion("COMMION_TYPE not in", values, "commionType");
			return (Criteria) this;
		}

		public Criteria andCommionTypeBetween(Byte value1, Byte value2) {
			addCriterion("COMMION_TYPE between", value1, value2, "commionType");
			return (Criteria) this;
		}

		public Criteria andCommionTypeNotBetween(Byte value1, Byte value2) {
			addCriterion("COMMION_TYPE not between", value1, value2, "commionType");
			return (Criteria) this;
		}

		public Criteria andHouseRateIsNull() {
			addCriterion("HOUSE_RATE is null");
			return (Criteria) this;
		}

		public Criteria andHouseRateIsNotNull() {
			addCriterion("HOUSE_RATE is not null");
			return (Criteria) this;
		}

		public Criteria andHouseRateEqualTo(BigDecimal value) {
			addCriterion("HOUSE_RATE =", value, "houseRate");
			return (Criteria) this;
		}

		public Criteria andHouseRateNotEqualTo(BigDecimal value) {
			addCriterion("HOUSE_RATE <>", value, "houseRate");
			return (Criteria) this;
		}

		public Criteria andHouseRateGreaterThan(BigDecimal value) {
			addCriterion("HOUSE_RATE >", value, "houseRate");
			return (Criteria) this;
		}

		public Criteria andHouseRateGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("HOUSE_RATE >=", value, "houseRate");
			return (Criteria) this;
		}

		public Criteria andHouseRateLessThan(BigDecimal value) {
			addCriterion("HOUSE_RATE <", value, "houseRate");
			return (Criteria) this;
		}

		public Criteria andHouseRateLessThanOrEqualTo(BigDecimal value) {
			addCriterion("HOUSE_RATE <=", value, "houseRate");
			return (Criteria) this;
		}

		public Criteria andHouseRateIn(List<BigDecimal> values) {
			addCriterion("HOUSE_RATE in", values, "houseRate");
			return (Criteria) this;
		}

		public Criteria andHouseRateNotIn(List<BigDecimal> values) {
			addCriterion("HOUSE_RATE not in", values, "houseRate");
			return (Criteria) this;
		}

		public Criteria andHouseRateBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("HOUSE_RATE between", value1, value2, "houseRate");
			return (Criteria) this;
		}

		public Criteria andHouseRateNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("HOUSE_RATE not between", value1, value2, "houseRate");
			return (Criteria) this;
		}

		public Criteria andCustomerRateIsNull() {
			addCriterion("CUSTOMER_RATE is null");
			return (Criteria) this;
		}

		public Criteria andCustomerRateIsNotNull() {
			addCriterion("CUSTOMER_RATE is not null");
			return (Criteria) this;
		}

		public Criteria andCustomerRateEqualTo(BigDecimal value) {
			addCriterion("CUSTOMER_RATE =", value, "customerRate");
			return (Criteria) this;
		}

		public Criteria andCustomerRateNotEqualTo(BigDecimal value) {
			addCriterion("CUSTOMER_RATE <>", value, "customerRate");
			return (Criteria) this;
		}

		public Criteria andCustomerRateGreaterThan(BigDecimal value) {
			addCriterion("CUSTOMER_RATE >", value, "customerRate");
			return (Criteria) this;
		}

		public Criteria andCustomerRateGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("CUSTOMER_RATE >=", value, "customerRate");
			return (Criteria) this;
		}

		public Criteria andCustomerRateLessThan(BigDecimal value) {
			addCriterion("CUSTOMER_RATE <", value, "customerRate");
			return (Criteria) this;
		}

		public Criteria andCustomerRateLessThanOrEqualTo(BigDecimal value) {
			addCriterion("CUSTOMER_RATE <=", value, "customerRate");
			return (Criteria) this;
		}

		public Criteria andCustomerRateIn(List<BigDecimal> values) {
			addCriterion("CUSTOMER_RATE in", values, "customerRate");
			return (Criteria) this;
		}

		public Criteria andCustomerRateNotIn(List<BigDecimal> values) {
			addCriterion("CUSTOMER_RATE not in", values, "customerRate");
			return (Criteria) this;
		}

		public Criteria andCustomerRateBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("CUSTOMER_RATE between", value1, value2, "customerRate");
			return (Criteria) this;
		}

		public Criteria andCustomerRateNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("CUSTOMER_RATE not between", value1, value2, "customerRate");
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