package com.myfun.repository.admindb.po;

import java.util.ArrayList;
import java.util.List;

public class AdminBankDetailInfoExample {
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
	public AdminBankDetailInfoExample() {
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

		public Criteria andBankCodeIsNull() {
			addCriterion("BANK_CODE is null");
			return (Criteria) this;
		}

		public Criteria andBankCodeIsNotNull() {
			addCriterion("BANK_CODE is not null");
			return (Criteria) this;
		}

		public Criteria andBankCodeEqualTo(String value) {
			addCriterion("BANK_CODE =", value, "bankCode");
			return (Criteria) this;
		}

		public Criteria andBankCodeNotEqualTo(String value) {
			addCriterion("BANK_CODE <>", value, "bankCode");
			return (Criteria) this;
		}

		public Criteria andBankCodeGreaterThan(String value) {
			addCriterion("BANK_CODE >", value, "bankCode");
			return (Criteria) this;
		}

		public Criteria andBankCodeGreaterThanOrEqualTo(String value) {
			addCriterion("BANK_CODE >=", value, "bankCode");
			return (Criteria) this;
		}

		public Criteria andBankCodeLessThan(String value) {
			addCriterion("BANK_CODE <", value, "bankCode");
			return (Criteria) this;
		}

		public Criteria andBankCodeLessThanOrEqualTo(String value) {
			addCriterion("BANK_CODE <=", value, "bankCode");
			return (Criteria) this;
		}

		public Criteria andBankCodeLike(String value) {
			addCriterion("BANK_CODE like", value, "bankCode");
			return (Criteria) this;
		}

		public Criteria andBankCodeNotLike(String value) {
			addCriterion("BANK_CODE not like", value, "bankCode");
			return (Criteria) this;
		}

		public Criteria andBankCodeIn(List<String> values) {
			addCriterion("BANK_CODE in", values, "bankCode");
			return (Criteria) this;
		}

		public Criteria andBankCodeNotIn(List<String> values) {
			addCriterion("BANK_CODE not in", values, "bankCode");
			return (Criteria) this;
		}

		public Criteria andBankCodeBetween(String value1, String value2) {
			addCriterion("BANK_CODE between", value1, value2, "bankCode");
			return (Criteria) this;
		}

		public Criteria andBankCodeNotBetween(String value1, String value2) {
			addCriterion("BANK_CODE not between", value1, value2, "bankCode");
			return (Criteria) this;
		}

		public Criteria andDrecCodeIsNull() {
			addCriterion("DREC_CODE is null");
			return (Criteria) this;
		}

		public Criteria andDrecCodeIsNotNull() {
			addCriterion("DREC_CODE is not null");
			return (Criteria) this;
		}

		public Criteria andDrecCodeEqualTo(String value) {
			addCriterion("DREC_CODE =", value, "drecCode");
			return (Criteria) this;
		}

		public Criteria andDrecCodeNotEqualTo(String value) {
			addCriterion("DREC_CODE <>", value, "drecCode");
			return (Criteria) this;
		}

		public Criteria andDrecCodeGreaterThan(String value) {
			addCriterion("DREC_CODE >", value, "drecCode");
			return (Criteria) this;
		}

		public Criteria andDrecCodeGreaterThanOrEqualTo(String value) {
			addCriterion("DREC_CODE >=", value, "drecCode");
			return (Criteria) this;
		}

		public Criteria andDrecCodeLessThan(String value) {
			addCriterion("DREC_CODE <", value, "drecCode");
			return (Criteria) this;
		}

		public Criteria andDrecCodeLessThanOrEqualTo(String value) {
			addCriterion("DREC_CODE <=", value, "drecCode");
			return (Criteria) this;
		}

		public Criteria andDrecCodeLike(String value) {
			addCriterion("DREC_CODE like", value, "drecCode");
			return (Criteria) this;
		}

		public Criteria andDrecCodeNotLike(String value) {
			addCriterion("DREC_CODE not like", value, "drecCode");
			return (Criteria) this;
		}

		public Criteria andDrecCodeIn(List<String> values) {
			addCriterion("DREC_CODE in", values, "drecCode");
			return (Criteria) this;
		}

		public Criteria andDrecCodeNotIn(List<String> values) {
			addCriterion("DREC_CODE not in", values, "drecCode");
			return (Criteria) this;
		}

		public Criteria andDrecCodeBetween(String value1, String value2) {
			addCriterion("DREC_CODE between", value1, value2, "drecCode");
			return (Criteria) this;
		}

		public Criteria andDrecCodeNotBetween(String value1, String value2) {
			addCriterion("DREC_CODE not between", value1, value2, "drecCode");
			return (Criteria) this;
		}

		public Criteria andBankDetailNameIsNull() {
			addCriterion("BANK_DETAIL_NAME is null");
			return (Criteria) this;
		}

		public Criteria andBankDetailNameIsNotNull() {
			addCriterion("BANK_DETAIL_NAME is not null");
			return (Criteria) this;
		}

		public Criteria andBankDetailNameEqualTo(String value) {
			addCriterion("BANK_DETAIL_NAME =", value, "bankDetailName");
			return (Criteria) this;
		}

		public Criteria andBankDetailNameNotEqualTo(String value) {
			addCriterion("BANK_DETAIL_NAME <>", value, "bankDetailName");
			return (Criteria) this;
		}

		public Criteria andBankDetailNameGreaterThan(String value) {
			addCriterion("BANK_DETAIL_NAME >", value, "bankDetailName");
			return (Criteria) this;
		}

		public Criteria andBankDetailNameGreaterThanOrEqualTo(String value) {
			addCriterion("BANK_DETAIL_NAME >=", value, "bankDetailName");
			return (Criteria) this;
		}

		public Criteria andBankDetailNameLessThan(String value) {
			addCriterion("BANK_DETAIL_NAME <", value, "bankDetailName");
			return (Criteria) this;
		}

		public Criteria andBankDetailNameLessThanOrEqualTo(String value) {
			addCriterion("BANK_DETAIL_NAME <=", value, "bankDetailName");
			return (Criteria) this;
		}

		public Criteria andBankDetailNameLike(String value) {
			addCriterion("BANK_DETAIL_NAME like", value, "bankDetailName");
			return (Criteria) this;
		}

		public Criteria andBankDetailNameNotLike(String value) {
			addCriterion("BANK_DETAIL_NAME not like", value, "bankDetailName");
			return (Criteria) this;
		}

		public Criteria andBankDetailNameIn(List<String> values) {
			addCriterion("BANK_DETAIL_NAME in", values, "bankDetailName");
			return (Criteria) this;
		}

		public Criteria andBankDetailNameNotIn(List<String> values) {
			addCriterion("BANK_DETAIL_NAME not in", values, "bankDetailName");
			return (Criteria) this;
		}

		public Criteria andBankDetailNameBetween(String value1, String value2) {
			addCriterion("BANK_DETAIL_NAME between", value1, value2, "bankDetailName");
			return (Criteria) this;
		}

		public Criteria andBankDetailNameNotBetween(String value1, String value2) {
			addCriterion("BANK_DETAIL_NAME not between", value1, value2, "bankDetailName");
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