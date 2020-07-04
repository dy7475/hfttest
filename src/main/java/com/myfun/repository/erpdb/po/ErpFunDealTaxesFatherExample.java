package com.myfun.repository.erpdb.po;

import com.myfun.repository.support.generator.shard.ShardDb;
import java.util.ArrayList;
import java.util.List;

public class ErpFunDealTaxesFatherExample extends ShardDb {
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
	public ErpFunDealTaxesFatherExample() {
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

		public Criteria andNameIsNull() {
			addCriterion("[NAME] is null");
			return (Criteria) this;
		}

		public Criteria andNameIsNotNull() {
			addCriterion("[NAME] is not null");
			return (Criteria) this;
		}

		public Criteria andNameEqualTo(String value) {
			addCriterion("[NAME] =", value, "name");
			return (Criteria) this;
		}

		public Criteria andNameNotEqualTo(String value) {
			addCriterion("[NAME] <>", value, "name");
			return (Criteria) this;
		}

		public Criteria andNameGreaterThan(String value) {
			addCriterion("[NAME] >", value, "name");
			return (Criteria) this;
		}

		public Criteria andNameGreaterThanOrEqualTo(String value) {
			addCriterion("[NAME] >=", value, "name");
			return (Criteria) this;
		}

		public Criteria andNameLessThan(String value) {
			addCriterion("[NAME] <", value, "name");
			return (Criteria) this;
		}

		public Criteria andNameLessThanOrEqualTo(String value) {
			addCriterion("[NAME] <=", value, "name");
			return (Criteria) this;
		}

		public Criteria andNameLike(String value) {
			addCriterion("[NAME] like", value, "name");
			return (Criteria) this;
		}

		public Criteria andNameNotLike(String value) {
			addCriterion("[NAME] not like", value, "name");
			return (Criteria) this;
		}

		public Criteria andNameIn(List<String> values) {
			addCriterion("[NAME] in", values, "name");
			return (Criteria) this;
		}

		public Criteria andNameNotIn(List<String> values) {
			addCriterion("[NAME] not in", values, "name");
			return (Criteria) this;
		}

		public Criteria andNameBetween(String value1, String value2) {
			addCriterion("[NAME] between", value1, value2, "name");
			return (Criteria) this;
		}

		public Criteria andNameNotBetween(String value1, String value2) {
			addCriterion("[NAME] not between", value1, value2, "name");
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

		public Criteria andSeqNoIsNull() {
			addCriterion("SEQ_NO is null");
			return (Criteria) this;
		}

		public Criteria andSeqNoIsNotNull() {
			addCriterion("SEQ_NO is not null");
			return (Criteria) this;
		}

		public Criteria andSeqNoEqualTo(Integer value) {
			addCriterion("SEQ_NO =", value, "seqNo");
			return (Criteria) this;
		}

		public Criteria andSeqNoNotEqualTo(Integer value) {
			addCriterion("SEQ_NO <>", value, "seqNo");
			return (Criteria) this;
		}

		public Criteria andSeqNoGreaterThan(Integer value) {
			addCriterion("SEQ_NO >", value, "seqNo");
			return (Criteria) this;
		}

		public Criteria andSeqNoGreaterThanOrEqualTo(Integer value) {
			addCriterion("SEQ_NO >=", value, "seqNo");
			return (Criteria) this;
		}

		public Criteria andSeqNoLessThan(Integer value) {
			addCriterion("SEQ_NO <", value, "seqNo");
			return (Criteria) this;
		}

		public Criteria andSeqNoLessThanOrEqualTo(Integer value) {
			addCriterion("SEQ_NO <=", value, "seqNo");
			return (Criteria) this;
		}

		public Criteria andSeqNoIn(List<Integer> values) {
			addCriterion("SEQ_NO in", values, "seqNo");
			return (Criteria) this;
		}

		public Criteria andSeqNoNotIn(List<Integer> values) {
			addCriterion("SEQ_NO not in", values, "seqNo");
			return (Criteria) this;
		}

		public Criteria andSeqNoBetween(Integer value1, Integer value2) {
			addCriterion("SEQ_NO between", value1, value2, "seqNo");
			return (Criteria) this;
		}

		public Criteria andSeqNoNotBetween(Integer value1, Integer value2) {
			addCriterion("SEQ_NO not between", value1, value2, "seqNo");
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

		public Criteria andPayTypeIsNull() {
			addCriterion("PAY_TYPE is null");
			return (Criteria) this;
		}

		public Criteria andPayTypeIsNotNull() {
			addCriterion("PAY_TYPE is not null");
			return (Criteria) this;
		}

		public Criteria andPayTypeEqualTo(Byte value) {
			addCriterion("PAY_TYPE =", value, "payType");
			return (Criteria) this;
		}

		public Criteria andPayTypeNotEqualTo(Byte value) {
			addCriterion("PAY_TYPE <>", value, "payType");
			return (Criteria) this;
		}

		public Criteria andPayTypeGreaterThan(Byte value) {
			addCriterion("PAY_TYPE >", value, "payType");
			return (Criteria) this;
		}

		public Criteria andPayTypeGreaterThanOrEqualTo(Byte value) {
			addCriterion("PAY_TYPE >=", value, "payType");
			return (Criteria) this;
		}

		public Criteria andPayTypeLessThan(Byte value) {
			addCriterion("PAY_TYPE <", value, "payType");
			return (Criteria) this;
		}

		public Criteria andPayTypeLessThanOrEqualTo(Byte value) {
			addCriterion("PAY_TYPE <=", value, "payType");
			return (Criteria) this;
		}

		public Criteria andPayTypeIn(List<Byte> values) {
			addCriterion("PAY_TYPE in", values, "payType");
			return (Criteria) this;
		}

		public Criteria andPayTypeNotIn(List<Byte> values) {
			addCriterion("PAY_TYPE not in", values, "payType");
			return (Criteria) this;
		}

		public Criteria andPayTypeBetween(Byte value1, Byte value2) {
			addCriterion("PAY_TYPE between", value1, value2, "payType");
			return (Criteria) this;
		}

		public Criteria andPayTypeNotBetween(Byte value1, Byte value2) {
			addCriterion("PAY_TYPE not between", value1, value2, "payType");
			return (Criteria) this;
		}

		public Criteria andCanDelIsNull() {
			addCriterion("CAN_DEL is null");
			return (Criteria) this;
		}

		public Criteria andCanDelIsNotNull() {
			addCriterion("CAN_DEL is not null");
			return (Criteria) this;
		}

		public Criteria andCanDelEqualTo(Byte value) {
			addCriterion("CAN_DEL =", value, "canDel");
			return (Criteria) this;
		}

		public Criteria andCanDelNotEqualTo(Byte value) {
			addCriterion("CAN_DEL <>", value, "canDel");
			return (Criteria) this;
		}

		public Criteria andCanDelGreaterThan(Byte value) {
			addCriterion("CAN_DEL >", value, "canDel");
			return (Criteria) this;
		}

		public Criteria andCanDelGreaterThanOrEqualTo(Byte value) {
			addCriterion("CAN_DEL >=", value, "canDel");
			return (Criteria) this;
		}

		public Criteria andCanDelLessThan(Byte value) {
			addCriterion("CAN_DEL <", value, "canDel");
			return (Criteria) this;
		}

		public Criteria andCanDelLessThanOrEqualTo(Byte value) {
			addCriterion("CAN_DEL <=", value, "canDel");
			return (Criteria) this;
		}

		public Criteria andCanDelIn(List<Byte> values) {
			addCriterion("CAN_DEL in", values, "canDel");
			return (Criteria) this;
		}

		public Criteria andCanDelNotIn(List<Byte> values) {
			addCriterion("CAN_DEL not in", values, "canDel");
			return (Criteria) this;
		}

		public Criteria andCanDelBetween(Byte value1, Byte value2) {
			addCriterion("CAN_DEL between", value1, value2, "canDel");
			return (Criteria) this;
		}

		public Criteria andCanDelNotBetween(Byte value1, Byte value2) {
			addCriterion("CAN_DEL not between", value1, value2, "canDel");
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