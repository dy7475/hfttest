package com.myfun.repository.erpdb.po;

import com.myfun.repository.support.generator.shard.ShardDb;
import java.util.ArrayList;
import java.util.List;

public class ErpFunBuildrulequerylimittempExample extends ShardDb {
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
	public ErpFunBuildrulequerylimittempExample() {
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

		public Criteria andLimitIdIsNull() {
			addCriterion("LIMIT_ID is null");
			return (Criteria) this;
		}

		public Criteria andLimitIdIsNotNull() {
			addCriterion("LIMIT_ID is not null");
			return (Criteria) this;
		}

		public Criteria andLimitIdEqualTo(Integer value) {
			addCriterion("LIMIT_ID =", value, "limitId");
			return (Criteria) this;
		}

		public Criteria andLimitIdNotEqualTo(Integer value) {
			addCriterion("LIMIT_ID <>", value, "limitId");
			return (Criteria) this;
		}

		public Criteria andLimitIdGreaterThan(Integer value) {
			addCriterion("LIMIT_ID >", value, "limitId");
			return (Criteria) this;
		}

		public Criteria andLimitIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("LIMIT_ID >=", value, "limitId");
			return (Criteria) this;
		}

		public Criteria andLimitIdLessThan(Integer value) {
			addCriterion("LIMIT_ID <", value, "limitId");
			return (Criteria) this;
		}

		public Criteria andLimitIdLessThanOrEqualTo(Integer value) {
			addCriterion("LIMIT_ID <=", value, "limitId");
			return (Criteria) this;
		}

		public Criteria andLimitIdIn(List<Integer> values) {
			addCriterion("LIMIT_ID in", values, "limitId");
			return (Criteria) this;
		}

		public Criteria andLimitIdNotIn(List<Integer> values) {
			addCriterion("LIMIT_ID not in", values, "limitId");
			return (Criteria) this;
		}

		public Criteria andLimitIdBetween(Integer value1, Integer value2) {
			addCriterion("LIMIT_ID between", value1, value2, "limitId");
			return (Criteria) this;
		}

		public Criteria andLimitIdNotBetween(Integer value1, Integer value2) {
			addCriterion("LIMIT_ID not between", value1, value2, "limitId");
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

		public Criteria andOldLimitIdIsNull() {
			addCriterion("OLD_LIMIT_ID is null");
			return (Criteria) this;
		}

		public Criteria andOldLimitIdIsNotNull() {
			addCriterion("OLD_LIMIT_ID is not null");
			return (Criteria) this;
		}

		public Criteria andOldLimitIdEqualTo(Integer value) {
			addCriterion("OLD_LIMIT_ID =", value, "oldLimitId");
			return (Criteria) this;
		}

		public Criteria andOldLimitIdNotEqualTo(Integer value) {
			addCriterion("OLD_LIMIT_ID <>", value, "oldLimitId");
			return (Criteria) this;
		}

		public Criteria andOldLimitIdGreaterThan(Integer value) {
			addCriterion("OLD_LIMIT_ID >", value, "oldLimitId");
			return (Criteria) this;
		}

		public Criteria andOldLimitIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("OLD_LIMIT_ID >=", value, "oldLimitId");
			return (Criteria) this;
		}

		public Criteria andOldLimitIdLessThan(Integer value) {
			addCriterion("OLD_LIMIT_ID <", value, "oldLimitId");
			return (Criteria) this;
		}

		public Criteria andOldLimitIdLessThanOrEqualTo(Integer value) {
			addCriterion("OLD_LIMIT_ID <=", value, "oldLimitId");
			return (Criteria) this;
		}

		public Criteria andOldLimitIdIn(List<Integer> values) {
			addCriterion("OLD_LIMIT_ID in", values, "oldLimitId");
			return (Criteria) this;
		}

		public Criteria andOldLimitIdNotIn(List<Integer> values) {
			addCriterion("OLD_LIMIT_ID not in", values, "oldLimitId");
			return (Criteria) this;
		}

		public Criteria andOldLimitIdBetween(Integer value1, Integer value2) {
			addCriterion("OLD_LIMIT_ID between", value1, value2, "oldLimitId");
			return (Criteria) this;
		}

		public Criteria andOldLimitIdNotBetween(Integer value1, Integer value2) {
			addCriterion("OLD_LIMIT_ID not between", value1, value2, "oldLimitId");
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

		public Criteria andRuleRegExIsNull() {
			addCriterion("RULE_REG_EX is null");
			return (Criteria) this;
		}

		public Criteria andRuleRegExIsNotNull() {
			addCriterion("RULE_REG_EX is not null");
			return (Criteria) this;
		}

		public Criteria andRuleRegExEqualTo(String value) {
			addCriterion("RULE_REG_EX =", value, "ruleRegEx");
			return (Criteria) this;
		}

		public Criteria andRuleRegExNotEqualTo(String value) {
			addCriterion("RULE_REG_EX <>", value, "ruleRegEx");
			return (Criteria) this;
		}

		public Criteria andRuleRegExGreaterThan(String value) {
			addCriterion("RULE_REG_EX >", value, "ruleRegEx");
			return (Criteria) this;
		}

		public Criteria andRuleRegExGreaterThanOrEqualTo(String value) {
			addCriterion("RULE_REG_EX >=", value, "ruleRegEx");
			return (Criteria) this;
		}

		public Criteria andRuleRegExLessThan(String value) {
			addCriterion("RULE_REG_EX <", value, "ruleRegEx");
			return (Criteria) this;
		}

		public Criteria andRuleRegExLessThanOrEqualTo(String value) {
			addCriterion("RULE_REG_EX <=", value, "ruleRegEx");
			return (Criteria) this;
		}

		public Criteria andRuleRegExLike(String value) {
			addCriterion("RULE_REG_EX like", value, "ruleRegEx");
			return (Criteria) this;
		}

		public Criteria andRuleRegExNotLike(String value) {
			addCriterion("RULE_REG_EX not like", value, "ruleRegEx");
			return (Criteria) this;
		}

		public Criteria andRuleRegExIn(List<String> values) {
			addCriterion("RULE_REG_EX in", values, "ruleRegEx");
			return (Criteria) this;
		}

		public Criteria andRuleRegExNotIn(List<String> values) {
			addCriterion("RULE_REG_EX not in", values, "ruleRegEx");
			return (Criteria) this;
		}

		public Criteria andRuleRegExBetween(String value1, String value2) {
			addCriterion("RULE_REG_EX between", value1, value2, "ruleRegEx");
			return (Criteria) this;
		}

		public Criteria andRuleRegExNotBetween(String value1, String value2) {
			addCriterion("RULE_REG_EX not between", value1, value2, "ruleRegEx");
			return (Criteria) this;
		}

		public Criteria andRuleStrIsNull() {
			addCriterion("RULE_STR is null");
			return (Criteria) this;
		}

		public Criteria andRuleStrIsNotNull() {
			addCriterion("RULE_STR is not null");
			return (Criteria) this;
		}

		public Criteria andRuleStrEqualTo(String value) {
			addCriterion("RULE_STR =", value, "ruleStr");
			return (Criteria) this;
		}

		public Criteria andRuleStrNotEqualTo(String value) {
			addCriterion("RULE_STR <>", value, "ruleStr");
			return (Criteria) this;
		}

		public Criteria andRuleStrGreaterThan(String value) {
			addCriterion("RULE_STR >", value, "ruleStr");
			return (Criteria) this;
		}

		public Criteria andRuleStrGreaterThanOrEqualTo(String value) {
			addCriterion("RULE_STR >=", value, "ruleStr");
			return (Criteria) this;
		}

		public Criteria andRuleStrLessThan(String value) {
			addCriterion("RULE_STR <", value, "ruleStr");
			return (Criteria) this;
		}

		public Criteria andRuleStrLessThanOrEqualTo(String value) {
			addCriterion("RULE_STR <=", value, "ruleStr");
			return (Criteria) this;
		}

		public Criteria andRuleStrLike(String value) {
			addCriterion("RULE_STR like", value, "ruleStr");
			return (Criteria) this;
		}

		public Criteria andRuleStrNotLike(String value) {
			addCriterion("RULE_STR not like", value, "ruleStr");
			return (Criteria) this;
		}

		public Criteria andRuleStrIn(List<String> values) {
			addCriterion("RULE_STR in", values, "ruleStr");
			return (Criteria) this;
		}

		public Criteria andRuleStrNotIn(List<String> values) {
			addCriterion("RULE_STR not in", values, "ruleStr");
			return (Criteria) this;
		}

		public Criteria andRuleStrBetween(String value1, String value2) {
			addCriterion("RULE_STR between", value1, value2, "ruleStr");
			return (Criteria) this;
		}

		public Criteria andRuleStrNotBetween(String value1, String value2) {
			addCriterion("RULE_STR not between", value1, value2, "ruleStr");
			return (Criteria) this;
		}

		public Criteria andStartTimeIsNull() {
			addCriterion("START_TIME is null");
			return (Criteria) this;
		}

		public Criteria andStartTimeIsNotNull() {
			addCriterion("START_TIME is not null");
			return (Criteria) this;
		}

		public Criteria andStartTimeEqualTo(String value) {
			addCriterion("START_TIME =", value, "startTime");
			return (Criteria) this;
		}

		public Criteria andStartTimeNotEqualTo(String value) {
			addCriterion("START_TIME <>", value, "startTime");
			return (Criteria) this;
		}

		public Criteria andStartTimeGreaterThan(String value) {
			addCriterion("START_TIME >", value, "startTime");
			return (Criteria) this;
		}

		public Criteria andStartTimeGreaterThanOrEqualTo(String value) {
			addCriterion("START_TIME >=", value, "startTime");
			return (Criteria) this;
		}

		public Criteria andStartTimeLessThan(String value) {
			addCriterion("START_TIME <", value, "startTime");
			return (Criteria) this;
		}

		public Criteria andStartTimeLessThanOrEqualTo(String value) {
			addCriterion("START_TIME <=", value, "startTime");
			return (Criteria) this;
		}

		public Criteria andStartTimeLike(String value) {
			addCriterion("START_TIME like", value, "startTime");
			return (Criteria) this;
		}

		public Criteria andStartTimeNotLike(String value) {
			addCriterion("START_TIME not like", value, "startTime");
			return (Criteria) this;
		}

		public Criteria andStartTimeIn(List<String> values) {
			addCriterion("START_TIME in", values, "startTime");
			return (Criteria) this;
		}

		public Criteria andStartTimeNotIn(List<String> values) {
			addCriterion("START_TIME not in", values, "startTime");
			return (Criteria) this;
		}

		public Criteria andStartTimeBetween(String value1, String value2) {
			addCriterion("START_TIME between", value1, value2, "startTime");
			return (Criteria) this;
		}

		public Criteria andStartTimeNotBetween(String value1, String value2) {
			addCriterion("START_TIME not between", value1, value2, "startTime");
			return (Criteria) this;
		}

		public Criteria andEndTimeIsNull() {
			addCriterion("END_TIME is null");
			return (Criteria) this;
		}

		public Criteria andEndTimeIsNotNull() {
			addCriterion("END_TIME is not null");
			return (Criteria) this;
		}

		public Criteria andEndTimeEqualTo(String value) {
			addCriterion("END_TIME =", value, "endTime");
			return (Criteria) this;
		}

		public Criteria andEndTimeNotEqualTo(String value) {
			addCriterion("END_TIME <>", value, "endTime");
			return (Criteria) this;
		}

		public Criteria andEndTimeGreaterThan(String value) {
			addCriterion("END_TIME >", value, "endTime");
			return (Criteria) this;
		}

		public Criteria andEndTimeGreaterThanOrEqualTo(String value) {
			addCriterion("END_TIME >=", value, "endTime");
			return (Criteria) this;
		}

		public Criteria andEndTimeLessThan(String value) {
			addCriterion("END_TIME <", value, "endTime");
			return (Criteria) this;
		}

		public Criteria andEndTimeLessThanOrEqualTo(String value) {
			addCriterion("END_TIME <=", value, "endTime");
			return (Criteria) this;
		}

		public Criteria andEndTimeLike(String value) {
			addCriterion("END_TIME like", value, "endTime");
			return (Criteria) this;
		}

		public Criteria andEndTimeNotLike(String value) {
			addCriterion("END_TIME not like", value, "endTime");
			return (Criteria) this;
		}

		public Criteria andEndTimeIn(List<String> values) {
			addCriterion("END_TIME in", values, "endTime");
			return (Criteria) this;
		}

		public Criteria andEndTimeNotIn(List<String> values) {
			addCriterion("END_TIME not in", values, "endTime");
			return (Criteria) this;
		}

		public Criteria andEndTimeBetween(String value1, String value2) {
			addCriterion("END_TIME between", value1, value2, "endTime");
			return (Criteria) this;
		}

		public Criteria andEndTimeNotBetween(String value1, String value2) {
			addCriterion("END_TIME not between", value1, value2, "endTime");
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