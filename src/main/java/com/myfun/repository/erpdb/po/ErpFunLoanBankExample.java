package com.myfun.repository.erpdb.po;

import com.myfun.repository.support.generator.shard.ShardDb;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ErpFunLoanBankExample extends ShardDb {
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
	public ErpFunLoanBankExample() {
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

		public Criteria andBankNameIsNull() {
			addCriterion("BANK_NAME is null");
			return (Criteria) this;
		}

		public Criteria andBankNameIsNotNull() {
			addCriterion("BANK_NAME is not null");
			return (Criteria) this;
		}

		public Criteria andBankNameEqualTo(String value) {
			addCriterion("BANK_NAME =", value, "bankName");
			return (Criteria) this;
		}

		public Criteria andBankNameNotEqualTo(String value) {
			addCriterion("BANK_NAME <>", value, "bankName");
			return (Criteria) this;
		}

		public Criteria andBankNameGreaterThan(String value) {
			addCriterion("BANK_NAME >", value, "bankName");
			return (Criteria) this;
		}

		public Criteria andBankNameGreaterThanOrEqualTo(String value) {
			addCriterion("BANK_NAME >=", value, "bankName");
			return (Criteria) this;
		}

		public Criteria andBankNameLessThan(String value) {
			addCriterion("BANK_NAME <", value, "bankName");
			return (Criteria) this;
		}

		public Criteria andBankNameLessThanOrEqualTo(String value) {
			addCriterion("BANK_NAME <=", value, "bankName");
			return (Criteria) this;
		}

		public Criteria andBankNameLike(String value) {
			addCriterion("BANK_NAME like", value, "bankName");
			return (Criteria) this;
		}

		public Criteria andBankNameNotLike(String value) {
			addCriterion("BANK_NAME not like", value, "bankName");
			return (Criteria) this;
		}

		public Criteria andBankNameIn(List<String> values) {
			addCriterion("BANK_NAME in", values, "bankName");
			return (Criteria) this;
		}

		public Criteria andBankNameNotIn(List<String> values) {
			addCriterion("BANK_NAME not in", values, "bankName");
			return (Criteria) this;
		}

		public Criteria andBankNameBetween(String value1, String value2) {
			addCriterion("BANK_NAME between", value1, value2, "bankName");
			return (Criteria) this;
		}

		public Criteria andBankNameNotBetween(String value1, String value2) {
			addCriterion("BANK_NAME not between", value1, value2, "bankName");
			return (Criteria) this;
		}

		public Criteria andBankStatusIsNull() {
			addCriterion("BANK_STATUS is null");
			return (Criteria) this;
		}

		public Criteria andBankStatusIsNotNull() {
			addCriterion("BANK_STATUS is not null");
			return (Criteria) this;
		}

		public Criteria andBankStatusEqualTo(Byte value) {
			addCriterion("BANK_STATUS =", value, "bankStatus");
			return (Criteria) this;
		}

		public Criteria andBankStatusNotEqualTo(Byte value) {
			addCriterion("BANK_STATUS <>", value, "bankStatus");
			return (Criteria) this;
		}

		public Criteria andBankStatusGreaterThan(Byte value) {
			addCriterion("BANK_STATUS >", value, "bankStatus");
			return (Criteria) this;
		}

		public Criteria andBankStatusGreaterThanOrEqualTo(Byte value) {
			addCriterion("BANK_STATUS >=", value, "bankStatus");
			return (Criteria) this;
		}

		public Criteria andBankStatusLessThan(Byte value) {
			addCriterion("BANK_STATUS <", value, "bankStatus");
			return (Criteria) this;
		}

		public Criteria andBankStatusLessThanOrEqualTo(Byte value) {
			addCriterion("BANK_STATUS <=", value, "bankStatus");
			return (Criteria) this;
		}

		public Criteria andBankStatusIn(List<Byte> values) {
			addCriterion("BANK_STATUS in", values, "bankStatus");
			return (Criteria) this;
		}

		public Criteria andBankStatusNotIn(List<Byte> values) {
			addCriterion("BANK_STATUS not in", values, "bankStatus");
			return (Criteria) this;
		}

		public Criteria andBankStatusBetween(Byte value1, Byte value2) {
			addCriterion("BANK_STATUS between", value1, value2, "bankStatus");
			return (Criteria) this;
		}

		public Criteria andBankStatusNotBetween(Byte value1, Byte value2) {
			addCriterion("BANK_STATUS not between", value1, value2, "bankStatus");
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

		public Criteria andSystemSetIsNull() {
			addCriterion("SYSTEM_SET is null");
			return (Criteria) this;
		}

		public Criteria andSystemSetIsNotNull() {
			addCriterion("SYSTEM_SET is not null");
			return (Criteria) this;
		}

		public Criteria andSystemSetEqualTo(Byte value) {
			addCriterion("SYSTEM_SET =", value, "systemSet");
			return (Criteria) this;
		}

		public Criteria andSystemSetNotEqualTo(Byte value) {
			addCriterion("SYSTEM_SET <>", value, "systemSet");
			return (Criteria) this;
		}

		public Criteria andSystemSetGreaterThan(Byte value) {
			addCriterion("SYSTEM_SET >", value, "systemSet");
			return (Criteria) this;
		}

		public Criteria andSystemSetGreaterThanOrEqualTo(Byte value) {
			addCriterion("SYSTEM_SET >=", value, "systemSet");
			return (Criteria) this;
		}

		public Criteria andSystemSetLessThan(Byte value) {
			addCriterion("SYSTEM_SET <", value, "systemSet");
			return (Criteria) this;
		}

		public Criteria andSystemSetLessThanOrEqualTo(Byte value) {
			addCriterion("SYSTEM_SET <=", value, "systemSet");
			return (Criteria) this;
		}

		public Criteria andSystemSetIn(List<Byte> values) {
			addCriterion("SYSTEM_SET in", values, "systemSet");
			return (Criteria) this;
		}

		public Criteria andSystemSetNotIn(List<Byte> values) {
			addCriterion("SYSTEM_SET not in", values, "systemSet");
			return (Criteria) this;
		}

		public Criteria andSystemSetBetween(Byte value1, Byte value2) {
			addCriterion("SYSTEM_SET between", value1, value2, "systemSet");
			return (Criteria) this;
		}

		public Criteria andSystemSetNotBetween(Byte value1, Byte value2) {
			addCriterion("SYSTEM_SET not between", value1, value2, "systemSet");
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