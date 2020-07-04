package com.myfun.repository.erpdb.po;

import com.myfun.repository.support.generator.shard.ShardDb;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ErpFunBillPrintExample extends ShardDb {
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
	public ErpFunBillPrintExample() {
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

		public Criteria andCreatorUidIsNull() {
			addCriterion("CREATOR_UID is null");
			return (Criteria) this;
		}

		public Criteria andCreatorUidIsNotNull() {
			addCriterion("CREATOR_UID is not null");
			return (Criteria) this;
		}

		public Criteria andCreatorUidEqualTo(Integer value) {
			addCriterion("CREATOR_UID =", value, "creatorUid");
			return (Criteria) this;
		}

		public Criteria andCreatorUidNotEqualTo(Integer value) {
			addCriterion("CREATOR_UID <>", value, "creatorUid");
			return (Criteria) this;
		}

		public Criteria andCreatorUidGreaterThan(Integer value) {
			addCriterion("CREATOR_UID >", value, "creatorUid");
			return (Criteria) this;
		}

		public Criteria andCreatorUidGreaterThanOrEqualTo(Integer value) {
			addCriterion("CREATOR_UID >=", value, "creatorUid");
			return (Criteria) this;
		}

		public Criteria andCreatorUidLessThan(Integer value) {
			addCriterion("CREATOR_UID <", value, "creatorUid");
			return (Criteria) this;
		}

		public Criteria andCreatorUidLessThanOrEqualTo(Integer value) {
			addCriterion("CREATOR_UID <=", value, "creatorUid");
			return (Criteria) this;
		}

		public Criteria andCreatorUidIn(List<Integer> values) {
			addCriterion("CREATOR_UID in", values, "creatorUid");
			return (Criteria) this;
		}

		public Criteria andCreatorUidNotIn(List<Integer> values) {
			addCriterion("CREATOR_UID not in", values, "creatorUid");
			return (Criteria) this;
		}

		public Criteria andCreatorUidBetween(Integer value1, Integer value2) {
			addCriterion("CREATOR_UID between", value1, value2, "creatorUid");
			return (Criteria) this;
		}

		public Criteria andCreatorUidNotBetween(Integer value1, Integer value2) {
			addCriterion("CREATOR_UID not between", value1, value2, "creatorUid");
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

		public Criteria andPrintCountIsNull() {
			addCriterion("PRINT_COUNT is null");
			return (Criteria) this;
		}

		public Criteria andPrintCountIsNotNull() {
			addCriterion("PRINT_COUNT is not null");
			return (Criteria) this;
		}

		public Criteria andPrintCountEqualTo(Integer value) {
			addCriterion("PRINT_COUNT =", value, "printCount");
			return (Criteria) this;
		}

		public Criteria andPrintCountNotEqualTo(Integer value) {
			addCriterion("PRINT_COUNT <>", value, "printCount");
			return (Criteria) this;
		}

		public Criteria andPrintCountGreaterThan(Integer value) {
			addCriterion("PRINT_COUNT >", value, "printCount");
			return (Criteria) this;
		}

		public Criteria andPrintCountGreaterThanOrEqualTo(Integer value) {
			addCriterion("PRINT_COUNT >=", value, "printCount");
			return (Criteria) this;
		}

		public Criteria andPrintCountLessThan(Integer value) {
			addCriterion("PRINT_COUNT <", value, "printCount");
			return (Criteria) this;
		}

		public Criteria andPrintCountLessThanOrEqualTo(Integer value) {
			addCriterion("PRINT_COUNT <=", value, "printCount");
			return (Criteria) this;
		}

		public Criteria andPrintCountIn(List<Integer> values) {
			addCriterion("PRINT_COUNT in", values, "printCount");
			return (Criteria) this;
		}

		public Criteria andPrintCountNotIn(List<Integer> values) {
			addCriterion("PRINT_COUNT not in", values, "printCount");
			return (Criteria) this;
		}

		public Criteria andPrintCountBetween(Integer value1, Integer value2) {
			addCriterion("PRINT_COUNT between", value1, value2, "printCount");
			return (Criteria) this;
		}

		public Criteria andPrintCountNotBetween(Integer value1, Integer value2) {
			addCriterion("PRINT_COUNT not between", value1, value2, "printCount");
			return (Criteria) this;
		}

		public Criteria andPrintCountUserIsNull() {
			addCriterion("PRINT_COUNT_USER is null");
			return (Criteria) this;
		}

		public Criteria andPrintCountUserIsNotNull() {
			addCriterion("PRINT_COUNT_USER is not null");
			return (Criteria) this;
		}

		public Criteria andPrintCountUserEqualTo(Integer value) {
			addCriterion("PRINT_COUNT_USER =", value, "printCountUser");
			return (Criteria) this;
		}

		public Criteria andPrintCountUserNotEqualTo(Integer value) {
			addCriterion("PRINT_COUNT_USER <>", value, "printCountUser");
			return (Criteria) this;
		}

		public Criteria andPrintCountUserGreaterThan(Integer value) {
			addCriterion("PRINT_COUNT_USER >", value, "printCountUser");
			return (Criteria) this;
		}

		public Criteria andPrintCountUserGreaterThanOrEqualTo(Integer value) {
			addCriterion("PRINT_COUNT_USER >=", value, "printCountUser");
			return (Criteria) this;
		}

		public Criteria andPrintCountUserLessThan(Integer value) {
			addCriterion("PRINT_COUNT_USER <", value, "printCountUser");
			return (Criteria) this;
		}

		public Criteria andPrintCountUserLessThanOrEqualTo(Integer value) {
			addCriterion("PRINT_COUNT_USER <=", value, "printCountUser");
			return (Criteria) this;
		}

		public Criteria andPrintCountUserIn(List<Integer> values) {
			addCriterion("PRINT_COUNT_USER in", values, "printCountUser");
			return (Criteria) this;
		}

		public Criteria andPrintCountUserNotIn(List<Integer> values) {
			addCriterion("PRINT_COUNT_USER not in", values, "printCountUser");
			return (Criteria) this;
		}

		public Criteria andPrintCountUserBetween(Integer value1, Integer value2) {
			addCriterion("PRINT_COUNT_USER between", value1, value2, "printCountUser");
			return (Criteria) this;
		}

		public Criteria andPrintCountUserNotBetween(Integer value1, Integer value2) {
			addCriterion("PRINT_COUNT_USER not between", value1, value2, "printCountUser");
			return (Criteria) this;
		}

		public Criteria andLastPrintTimeIsNull() {
			addCriterion("LAST_PRINT_TIME is null");
			return (Criteria) this;
		}

		public Criteria andLastPrintTimeIsNotNull() {
			addCriterion("LAST_PRINT_TIME is not null");
			return (Criteria) this;
		}

		public Criteria andLastPrintTimeEqualTo(Date value) {
			addCriterion("LAST_PRINT_TIME =", value, "lastPrintTime");
			return (Criteria) this;
		}

		public Criteria andLastPrintTimeNotEqualTo(Date value) {
			addCriterion("LAST_PRINT_TIME <>", value, "lastPrintTime");
			return (Criteria) this;
		}

		public Criteria andLastPrintTimeGreaterThan(Date value) {
			addCriterion("LAST_PRINT_TIME >", value, "lastPrintTime");
			return (Criteria) this;
		}

		public Criteria andLastPrintTimeGreaterThanOrEqualTo(Date value) {
			addCriterion("LAST_PRINT_TIME >=", value, "lastPrintTime");
			return (Criteria) this;
		}

		public Criteria andLastPrintTimeLessThan(Date value) {
			addCriterion("LAST_PRINT_TIME <", value, "lastPrintTime");
			return (Criteria) this;
		}

		public Criteria andLastPrintTimeLessThanOrEqualTo(Date value) {
			addCriterion("LAST_PRINT_TIME <=", value, "lastPrintTime");
			return (Criteria) this;
		}

		public Criteria andLastPrintTimeIn(List<Date> values) {
			addCriterion("LAST_PRINT_TIME in", values, "lastPrintTime");
			return (Criteria) this;
		}

		public Criteria andLastPrintTimeNotIn(List<Date> values) {
			addCriterion("LAST_PRINT_TIME not in", values, "lastPrintTime");
			return (Criteria) this;
		}

		public Criteria andLastPrintTimeBetween(Date value1, Date value2) {
			addCriterion("LAST_PRINT_TIME between", value1, value2, "lastPrintTime");
			return (Criteria) this;
		}

		public Criteria andLastPrintTimeNotBetween(Date value1, Date value2) {
			addCriterion("LAST_PRINT_TIME not between", value1, value2, "lastPrintTime");
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