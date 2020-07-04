package com.myfun.repository.erpdb.po;

import com.myfun.repository.support.generator.shard.ShardDb;
import java.util.ArrayList;
import java.util.List;

public class ErpFunEntrustCertificateExample extends ShardDb {
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
	public ErpFunEntrustCertificateExample() {
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

		public Criteria andEntrustIdIsNull() {
			addCriterion("ENTRUST_ID is null");
			return (Criteria) this;
		}

		public Criteria andEntrustIdIsNotNull() {
			addCriterion("ENTRUST_ID is not null");
			return (Criteria) this;
		}

		public Criteria andEntrustIdEqualTo(Integer value) {
			addCriterion("ENTRUST_ID =", value, "entrustId");
			return (Criteria) this;
		}

		public Criteria andEntrustIdNotEqualTo(Integer value) {
			addCriterion("ENTRUST_ID <>", value, "entrustId");
			return (Criteria) this;
		}

		public Criteria andEntrustIdGreaterThan(Integer value) {
			addCriterion("ENTRUST_ID >", value, "entrustId");
			return (Criteria) this;
		}

		public Criteria andEntrustIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("ENTRUST_ID >=", value, "entrustId");
			return (Criteria) this;
		}

		public Criteria andEntrustIdLessThan(Integer value) {
			addCriterion("ENTRUST_ID <", value, "entrustId");
			return (Criteria) this;
		}

		public Criteria andEntrustIdLessThanOrEqualTo(Integer value) {
			addCriterion("ENTRUST_ID <=", value, "entrustId");
			return (Criteria) this;
		}

		public Criteria andEntrustIdIn(List<Integer> values) {
			addCriterion("ENTRUST_ID in", values, "entrustId");
			return (Criteria) this;
		}

		public Criteria andEntrustIdNotIn(List<Integer> values) {
			addCriterion("ENTRUST_ID not in", values, "entrustId");
			return (Criteria) this;
		}

		public Criteria andEntrustIdBetween(Integer value1, Integer value2) {
			addCriterion("ENTRUST_ID between", value1, value2, "entrustId");
			return (Criteria) this;
		}

		public Criteria andEntrustIdNotBetween(Integer value1, Integer value2) {
			addCriterion("ENTRUST_ID not between", value1, value2, "entrustId");
			return (Criteria) this;
		}

		public Criteria andCertificateTypeIsNull() {
			addCriterion("CERTIFICATE_TYPE is null");
			return (Criteria) this;
		}

		public Criteria andCertificateTypeIsNotNull() {
			addCriterion("CERTIFICATE_TYPE is not null");
			return (Criteria) this;
		}

		public Criteria andCertificateTypeEqualTo(Byte value) {
			addCriterion("CERTIFICATE_TYPE =", value, "certificateType");
			return (Criteria) this;
		}

		public Criteria andCertificateTypeNotEqualTo(Byte value) {
			addCriterion("CERTIFICATE_TYPE <>", value, "certificateType");
			return (Criteria) this;
		}

		public Criteria andCertificateTypeGreaterThan(Byte value) {
			addCriterion("CERTIFICATE_TYPE >", value, "certificateType");
			return (Criteria) this;
		}

		public Criteria andCertificateTypeGreaterThanOrEqualTo(Byte value) {
			addCriterion("CERTIFICATE_TYPE >=", value, "certificateType");
			return (Criteria) this;
		}

		public Criteria andCertificateTypeLessThan(Byte value) {
			addCriterion("CERTIFICATE_TYPE <", value, "certificateType");
			return (Criteria) this;
		}

		public Criteria andCertificateTypeLessThanOrEqualTo(Byte value) {
			addCriterion("CERTIFICATE_TYPE <=", value, "certificateType");
			return (Criteria) this;
		}

		public Criteria andCertificateTypeIn(List<Byte> values) {
			addCriterion("CERTIFICATE_TYPE in", values, "certificateType");
			return (Criteria) this;
		}

		public Criteria andCertificateTypeNotIn(List<Byte> values) {
			addCriterion("CERTIFICATE_TYPE not in", values, "certificateType");
			return (Criteria) this;
		}

		public Criteria andCertificateTypeBetween(Byte value1, Byte value2) {
			addCriterion("CERTIFICATE_TYPE between", value1, value2, "certificateType");
			return (Criteria) this;
		}

		public Criteria andCertificateTypeNotBetween(Byte value1, Byte value2) {
			addCriterion("CERTIFICATE_TYPE not between", value1, value2, "certificateType");
			return (Criteria) this;
		}

		public Criteria andCertificateNoIsNull() {
			addCriterion("CERTIFICATE_NO is null");
			return (Criteria) this;
		}

		public Criteria andCertificateNoIsNotNull() {
			addCriterion("CERTIFICATE_NO is not null");
			return (Criteria) this;
		}

		public Criteria andCertificateNoEqualTo(String value) {
			addCriterion("CERTIFICATE_NO =", value, "certificateNo");
			return (Criteria) this;
		}

		public Criteria andCertificateNoNotEqualTo(String value) {
			addCriterion("CERTIFICATE_NO <>", value, "certificateNo");
			return (Criteria) this;
		}

		public Criteria andCertificateNoGreaterThan(String value) {
			addCriterion("CERTIFICATE_NO >", value, "certificateNo");
			return (Criteria) this;
		}

		public Criteria andCertificateNoGreaterThanOrEqualTo(String value) {
			addCriterion("CERTIFICATE_NO >=", value, "certificateNo");
			return (Criteria) this;
		}

		public Criteria andCertificateNoLessThan(String value) {
			addCriterion("CERTIFICATE_NO <", value, "certificateNo");
			return (Criteria) this;
		}

		public Criteria andCertificateNoLessThanOrEqualTo(String value) {
			addCriterion("CERTIFICATE_NO <=", value, "certificateNo");
			return (Criteria) this;
		}

		public Criteria andCertificateNoLike(String value) {
			addCriterion("CERTIFICATE_NO like", value, "certificateNo");
			return (Criteria) this;
		}

		public Criteria andCertificateNoNotLike(String value) {
			addCriterion("CERTIFICATE_NO not like", value, "certificateNo");
			return (Criteria) this;
		}

		public Criteria andCertificateNoIn(List<String> values) {
			addCriterion("CERTIFICATE_NO in", values, "certificateNo");
			return (Criteria) this;
		}

		public Criteria andCertificateNoNotIn(List<String> values) {
			addCriterion("CERTIFICATE_NO not in", values, "certificateNo");
			return (Criteria) this;
		}

		public Criteria andCertificateNoBetween(String value1, String value2) {
			addCriterion("CERTIFICATE_NO between", value1, value2, "certificateNo");
			return (Criteria) this;
		}

		public Criteria andCertificateNoNotBetween(String value1, String value2) {
			addCriterion("CERTIFICATE_NO not between", value1, value2, "certificateNo");
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