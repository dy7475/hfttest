package com.myfun.repository.erpdb.po;

import com.myfun.repository.support.generator.shard.ShardDb;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ErpFunRoleWageWorkcountExample extends ShardDb {
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
	public ErpFunRoleWageWorkcountExample() {
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

		public Criteria andRoleWageConfigIdIsNull() {
			addCriterion("ROLE_WAGE_CONFIG_ID is null");
			return (Criteria) this;
		}

		public Criteria andRoleWageConfigIdIsNotNull() {
			addCriterion("ROLE_WAGE_CONFIG_ID is not null");
			return (Criteria) this;
		}

		public Criteria andRoleWageConfigIdEqualTo(Integer value) {
			addCriterion("ROLE_WAGE_CONFIG_ID =", value, "roleWageConfigId");
			return (Criteria) this;
		}

		public Criteria andRoleWageConfigIdNotEqualTo(Integer value) {
			addCriterion("ROLE_WAGE_CONFIG_ID <>", value, "roleWageConfigId");
			return (Criteria) this;
		}

		public Criteria andRoleWageConfigIdGreaterThan(Integer value) {
			addCriterion("ROLE_WAGE_CONFIG_ID >", value, "roleWageConfigId");
			return (Criteria) this;
		}

		public Criteria andRoleWageConfigIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("ROLE_WAGE_CONFIG_ID >=", value, "roleWageConfigId");
			return (Criteria) this;
		}

		public Criteria andRoleWageConfigIdLessThan(Integer value) {
			addCriterion("ROLE_WAGE_CONFIG_ID <", value, "roleWageConfigId");
			return (Criteria) this;
		}

		public Criteria andRoleWageConfigIdLessThanOrEqualTo(Integer value) {
			addCriterion("ROLE_WAGE_CONFIG_ID <=", value, "roleWageConfigId");
			return (Criteria) this;
		}

		public Criteria andRoleWageConfigIdIn(List<Integer> values) {
			addCriterion("ROLE_WAGE_CONFIG_ID in", values, "roleWageConfigId");
			return (Criteria) this;
		}

		public Criteria andRoleWageConfigIdNotIn(List<Integer> values) {
			addCriterion("ROLE_WAGE_CONFIG_ID not in", values, "roleWageConfigId");
			return (Criteria) this;
		}

		public Criteria andRoleWageConfigIdBetween(Integer value1, Integer value2) {
			addCriterion("ROLE_WAGE_CONFIG_ID between", value1, value2, "roleWageConfigId");
			return (Criteria) this;
		}

		public Criteria andRoleWageConfigIdNotBetween(Integer value1, Integer value2) {
			addCriterion("ROLE_WAGE_CONFIG_ID not between", value1, value2, "roleWageConfigId");
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

		public Criteria andWorkcountDicNameIsNull() {
			addCriterion("WORKCOUNT_DIC_NAME is null");
			return (Criteria) this;
		}

		public Criteria andWorkcountDicNameIsNotNull() {
			addCriterion("WORKCOUNT_DIC_NAME is not null");
			return (Criteria) this;
		}

		public Criteria andWorkcountDicNameEqualTo(String value) {
			addCriterion("WORKCOUNT_DIC_NAME =", value, "workcountDicName");
			return (Criteria) this;
		}

		public Criteria andWorkcountDicNameNotEqualTo(String value) {
			addCriterion("WORKCOUNT_DIC_NAME <>", value, "workcountDicName");
			return (Criteria) this;
		}

		public Criteria andWorkcountDicNameGreaterThan(String value) {
			addCriterion("WORKCOUNT_DIC_NAME >", value, "workcountDicName");
			return (Criteria) this;
		}

		public Criteria andWorkcountDicNameGreaterThanOrEqualTo(String value) {
			addCriterion("WORKCOUNT_DIC_NAME >=", value, "workcountDicName");
			return (Criteria) this;
		}

		public Criteria andWorkcountDicNameLessThan(String value) {
			addCriterion("WORKCOUNT_DIC_NAME <", value, "workcountDicName");
			return (Criteria) this;
		}

		public Criteria andWorkcountDicNameLessThanOrEqualTo(String value) {
			addCriterion("WORKCOUNT_DIC_NAME <=", value, "workcountDicName");
			return (Criteria) this;
		}

		public Criteria andWorkcountDicNameLike(String value) {
			addCriterion("WORKCOUNT_DIC_NAME like", value, "workcountDicName");
			return (Criteria) this;
		}

		public Criteria andWorkcountDicNameNotLike(String value) {
			addCriterion("WORKCOUNT_DIC_NAME not like", value, "workcountDicName");
			return (Criteria) this;
		}

		public Criteria andWorkcountDicNameIn(List<String> values) {
			addCriterion("WORKCOUNT_DIC_NAME in", values, "workcountDicName");
			return (Criteria) this;
		}

		public Criteria andWorkcountDicNameNotIn(List<String> values) {
			addCriterion("WORKCOUNT_DIC_NAME not in", values, "workcountDicName");
			return (Criteria) this;
		}

		public Criteria andWorkcountDicNameBetween(String value1, String value2) {
			addCriterion("WORKCOUNT_DIC_NAME between", value1, value2, "workcountDicName");
			return (Criteria) this;
		}

		public Criteria andWorkcountDicNameNotBetween(String value1, String value2) {
			addCriterion("WORKCOUNT_DIC_NAME not between", value1, value2, "workcountDicName");
			return (Criteria) this;
		}

		public Criteria andWorkcountDicValueIsNull() {
			addCriterion("WORKCOUNT_DIC_VALUE is null");
			return (Criteria) this;
		}

		public Criteria andWorkcountDicValueIsNotNull() {
			addCriterion("WORKCOUNT_DIC_VALUE is not null");
			return (Criteria) this;
		}

		public Criteria andWorkcountDicValueEqualTo(String value) {
			addCriterion("WORKCOUNT_DIC_VALUE =", value, "workcountDicValue");
			return (Criteria) this;
		}

		public Criteria andWorkcountDicValueNotEqualTo(String value) {
			addCriterion("WORKCOUNT_DIC_VALUE <>", value, "workcountDicValue");
			return (Criteria) this;
		}

		public Criteria andWorkcountDicValueGreaterThan(String value) {
			addCriterion("WORKCOUNT_DIC_VALUE >", value, "workcountDicValue");
			return (Criteria) this;
		}

		public Criteria andWorkcountDicValueGreaterThanOrEqualTo(String value) {
			addCriterion("WORKCOUNT_DIC_VALUE >=", value, "workcountDicValue");
			return (Criteria) this;
		}

		public Criteria andWorkcountDicValueLessThan(String value) {
			addCriterion("WORKCOUNT_DIC_VALUE <", value, "workcountDicValue");
			return (Criteria) this;
		}

		public Criteria andWorkcountDicValueLessThanOrEqualTo(String value) {
			addCriterion("WORKCOUNT_DIC_VALUE <=", value, "workcountDicValue");
			return (Criteria) this;
		}

		public Criteria andWorkcountDicValueLike(String value) {
			addCriterion("WORKCOUNT_DIC_VALUE like", value, "workcountDicValue");
			return (Criteria) this;
		}

		public Criteria andWorkcountDicValueNotLike(String value) {
			addCriterion("WORKCOUNT_DIC_VALUE not like", value, "workcountDicValue");
			return (Criteria) this;
		}

		public Criteria andWorkcountDicValueIn(List<String> values) {
			addCriterion("WORKCOUNT_DIC_VALUE in", values, "workcountDicValue");
			return (Criteria) this;
		}

		public Criteria andWorkcountDicValueNotIn(List<String> values) {
			addCriterion("WORKCOUNT_DIC_VALUE not in", values, "workcountDicValue");
			return (Criteria) this;
		}

		public Criteria andWorkcountDicValueBetween(String value1, String value2) {
			addCriterion("WORKCOUNT_DIC_VALUE between", value1, value2, "workcountDicValue");
			return (Criteria) this;
		}

		public Criteria andWorkcountDicValueNotBetween(String value1, String value2) {
			addCriterion("WORKCOUNT_DIC_VALUE not between", value1, value2, "workcountDicValue");
			return (Criteria) this;
		}

		public Criteria andCreateTimeIsNull() {
			addCriterion("CREATE_TIME is null");
			return (Criteria) this;
		}

		public Criteria andCreateTimeIsNotNull() {
			addCriterion("CREATE_TIME is not null");
			return (Criteria) this;
		}

		public Criteria andCreateTimeEqualTo(Date value) {
			addCriterion("CREATE_TIME =", value, "createTime");
			return (Criteria) this;
		}

		public Criteria andCreateTimeNotEqualTo(Date value) {
			addCriterion("CREATE_TIME <>", value, "createTime");
			return (Criteria) this;
		}

		public Criteria andCreateTimeGreaterThan(Date value) {
			addCriterion("CREATE_TIME >", value, "createTime");
			return (Criteria) this;
		}

		public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
			addCriterion("CREATE_TIME >=", value, "createTime");
			return (Criteria) this;
		}

		public Criteria andCreateTimeLessThan(Date value) {
			addCriterion("CREATE_TIME <", value, "createTime");
			return (Criteria) this;
		}

		public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
			addCriterion("CREATE_TIME <=", value, "createTime");
			return (Criteria) this;
		}

		public Criteria andCreateTimeIn(List<Date> values) {
			addCriterion("CREATE_TIME in", values, "createTime");
			return (Criteria) this;
		}

		public Criteria andCreateTimeNotIn(List<Date> values) {
			addCriterion("CREATE_TIME not in", values, "createTime");
			return (Criteria) this;
		}

		public Criteria andCreateTimeBetween(Date value1, Date value2) {
			addCriterion("CREATE_TIME between", value1, value2, "createTime");
			return (Criteria) this;
		}

		public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
			addCriterion("CREATE_TIME not between", value1, value2, "createTime");
			return (Criteria) this;
		}

		public Criteria andTargetCountIsNull() {
			addCriterion("TARGET_COUNT is null");
			return (Criteria) this;
		}

		public Criteria andTargetCountIsNotNull() {
			addCriterion("TARGET_COUNT is not null");
			return (Criteria) this;
		}

		public Criteria andTargetCountEqualTo(Integer value) {
			addCriterion("TARGET_COUNT =", value, "targetCount");
			return (Criteria) this;
		}

		public Criteria andTargetCountNotEqualTo(Integer value) {
			addCriterion("TARGET_COUNT <>", value, "targetCount");
			return (Criteria) this;
		}

		public Criteria andTargetCountGreaterThan(Integer value) {
			addCriterion("TARGET_COUNT >", value, "targetCount");
			return (Criteria) this;
		}

		public Criteria andTargetCountGreaterThanOrEqualTo(Integer value) {
			addCriterion("TARGET_COUNT >=", value, "targetCount");
			return (Criteria) this;
		}

		public Criteria andTargetCountLessThan(Integer value) {
			addCriterion("TARGET_COUNT <", value, "targetCount");
			return (Criteria) this;
		}

		public Criteria andTargetCountLessThanOrEqualTo(Integer value) {
			addCriterion("TARGET_COUNT <=", value, "targetCount");
			return (Criteria) this;
		}

		public Criteria andTargetCountIn(List<Integer> values) {
			addCriterion("TARGET_COUNT in", values, "targetCount");
			return (Criteria) this;
		}

		public Criteria andTargetCountNotIn(List<Integer> values) {
			addCriterion("TARGET_COUNT not in", values, "targetCount");
			return (Criteria) this;
		}

		public Criteria andTargetCountBetween(Integer value1, Integer value2) {
			addCriterion("TARGET_COUNT between", value1, value2, "targetCount");
			return (Criteria) this;
		}

		public Criteria andTargetCountNotBetween(Integer value1, Integer value2) {
			addCriterion("TARGET_COUNT not between", value1, value2, "targetCount");
			return (Criteria) this;
		}

		public Criteria andSingleAmountIsNull() {
			addCriterion("SINGLE_AMOUNT is null");
			return (Criteria) this;
		}

		public Criteria andSingleAmountIsNotNull() {
			addCriterion("SINGLE_AMOUNT is not null");
			return (Criteria) this;
		}

		public Criteria andSingleAmountEqualTo(BigDecimal value) {
			addCriterion("SINGLE_AMOUNT =", value, "singleAmount");
			return (Criteria) this;
		}

		public Criteria andSingleAmountNotEqualTo(BigDecimal value) {
			addCriterion("SINGLE_AMOUNT <>", value, "singleAmount");
			return (Criteria) this;
		}

		public Criteria andSingleAmountGreaterThan(BigDecimal value) {
			addCriterion("SINGLE_AMOUNT >", value, "singleAmount");
			return (Criteria) this;
		}

		public Criteria andSingleAmountGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("SINGLE_AMOUNT >=", value, "singleAmount");
			return (Criteria) this;
		}

		public Criteria andSingleAmountLessThan(BigDecimal value) {
			addCriterion("SINGLE_AMOUNT <", value, "singleAmount");
			return (Criteria) this;
		}

		public Criteria andSingleAmountLessThanOrEqualTo(BigDecimal value) {
			addCriterion("SINGLE_AMOUNT <=", value, "singleAmount");
			return (Criteria) this;
		}

		public Criteria andSingleAmountIn(List<BigDecimal> values) {
			addCriterion("SINGLE_AMOUNT in", values, "singleAmount");
			return (Criteria) this;
		}

		public Criteria andSingleAmountNotIn(List<BigDecimal> values) {
			addCriterion("SINGLE_AMOUNT not in", values, "singleAmount");
			return (Criteria) this;
		}

		public Criteria andSingleAmountBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("SINGLE_AMOUNT between", value1, value2, "singleAmount");
			return (Criteria) this;
		}

		public Criteria andSingleAmountNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("SINGLE_AMOUNT not between", value1, value2, "singleAmount");
			return (Criteria) this;
		}

		public Criteria andAmountLimitIsNull() {
			addCriterion("AMOUNT_LIMIT is null");
			return (Criteria) this;
		}

		public Criteria andAmountLimitIsNotNull() {
			addCriterion("AMOUNT_LIMIT is not null");
			return (Criteria) this;
		}

		public Criteria andAmountLimitEqualTo(BigDecimal value) {
			addCriterion("AMOUNT_LIMIT =", value, "amountLimit");
			return (Criteria) this;
		}

		public Criteria andAmountLimitNotEqualTo(BigDecimal value) {
			addCriterion("AMOUNT_LIMIT <>", value, "amountLimit");
			return (Criteria) this;
		}

		public Criteria andAmountLimitGreaterThan(BigDecimal value) {
			addCriterion("AMOUNT_LIMIT >", value, "amountLimit");
			return (Criteria) this;
		}

		public Criteria andAmountLimitGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("AMOUNT_LIMIT >=", value, "amountLimit");
			return (Criteria) this;
		}

		public Criteria andAmountLimitLessThan(BigDecimal value) {
			addCriterion("AMOUNT_LIMIT <", value, "amountLimit");
			return (Criteria) this;
		}

		public Criteria andAmountLimitLessThanOrEqualTo(BigDecimal value) {
			addCriterion("AMOUNT_LIMIT <=", value, "amountLimit");
			return (Criteria) this;
		}

		public Criteria andAmountLimitIn(List<BigDecimal> values) {
			addCriterion("AMOUNT_LIMIT in", values, "amountLimit");
			return (Criteria) this;
		}

		public Criteria andAmountLimitNotIn(List<BigDecimal> values) {
			addCriterion("AMOUNT_LIMIT not in", values, "amountLimit");
			return (Criteria) this;
		}

		public Criteria andAmountLimitBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("AMOUNT_LIMIT between", value1, value2, "amountLimit");
			return (Criteria) this;
		}

		public Criteria andAmountLimitNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("AMOUNT_LIMIT not between", value1, value2, "amountLimit");
			return (Criteria) this;
		}

		public Criteria andCheckTypeIsNull() {
			addCriterion("CHECK_TYPE is null");
			return (Criteria) this;
		}

		public Criteria andCheckTypeIsNotNull() {
			addCriterion("CHECK_TYPE is not null");
			return (Criteria) this;
		}

		public Criteria andCheckTypeEqualTo(Byte value) {
			addCriterion("CHECK_TYPE =", value, "checkType");
			return (Criteria) this;
		}

		public Criteria andCheckTypeNotEqualTo(Byte value) {
			addCriterion("CHECK_TYPE <>", value, "checkType");
			return (Criteria) this;
		}

		public Criteria andCheckTypeGreaterThan(Byte value) {
			addCriterion("CHECK_TYPE >", value, "checkType");
			return (Criteria) this;
		}

		public Criteria andCheckTypeGreaterThanOrEqualTo(Byte value) {
			addCriterion("CHECK_TYPE >=", value, "checkType");
			return (Criteria) this;
		}

		public Criteria andCheckTypeLessThan(Byte value) {
			addCriterion("CHECK_TYPE <", value, "checkType");
			return (Criteria) this;
		}

		public Criteria andCheckTypeLessThanOrEqualTo(Byte value) {
			addCriterion("CHECK_TYPE <=", value, "checkType");
			return (Criteria) this;
		}

		public Criteria andCheckTypeIn(List<Byte> values) {
			addCriterion("CHECK_TYPE in", values, "checkType");
			return (Criteria) this;
		}

		public Criteria andCheckTypeNotIn(List<Byte> values) {
			addCriterion("CHECK_TYPE not in", values, "checkType");
			return (Criteria) this;
		}

		public Criteria andCheckTypeBetween(Byte value1, Byte value2) {
			addCriterion("CHECK_TYPE between", value1, value2, "checkType");
			return (Criteria) this;
		}

		public Criteria andCheckTypeNotBetween(Byte value1, Byte value2) {
			addCriterion("CHECK_TYPE not between", value1, value2, "checkType");
			return (Criteria) this;
		}

		public Criteria andCheckRangeIsNull() {
			addCriterion("CHECK_RANGE is null");
			return (Criteria) this;
		}

		public Criteria andCheckRangeIsNotNull() {
			addCriterion("CHECK_RANGE is not null");
			return (Criteria) this;
		}

		public Criteria andCheckRangeEqualTo(Byte value) {
			addCriterion("CHECK_RANGE =", value, "checkRange");
			return (Criteria) this;
		}

		public Criteria andCheckRangeNotEqualTo(Byte value) {
			addCriterion("CHECK_RANGE <>", value, "checkRange");
			return (Criteria) this;
		}

		public Criteria andCheckRangeGreaterThan(Byte value) {
			addCriterion("CHECK_RANGE >", value, "checkRange");
			return (Criteria) this;
		}

		public Criteria andCheckRangeGreaterThanOrEqualTo(Byte value) {
			addCriterion("CHECK_RANGE >=", value, "checkRange");
			return (Criteria) this;
		}

		public Criteria andCheckRangeLessThan(Byte value) {
			addCriterion("CHECK_RANGE <", value, "checkRange");
			return (Criteria) this;
		}

		public Criteria andCheckRangeLessThanOrEqualTo(Byte value) {
			addCriterion("CHECK_RANGE <=", value, "checkRange");
			return (Criteria) this;
		}

		public Criteria andCheckRangeIn(List<Byte> values) {
			addCriterion("CHECK_RANGE in", values, "checkRange");
			return (Criteria) this;
		}

		public Criteria andCheckRangeNotIn(List<Byte> values) {
			addCriterion("CHECK_RANGE not in", values, "checkRange");
			return (Criteria) this;
		}

		public Criteria andCheckRangeBetween(Byte value1, Byte value2) {
			addCriterion("CHECK_RANGE between", value1, value2, "checkRange");
			return (Criteria) this;
		}

		public Criteria andCheckRangeNotBetween(Byte value1, Byte value2) {
			addCriterion("CHECK_RANGE not between", value1, value2, "checkRange");
			return (Criteria) this;
		}

		public Criteria andCheckBusinessIsNull() {
			addCriterion("CHECK_BUSINESS is null");
			return (Criteria) this;
		}

		public Criteria andCheckBusinessIsNotNull() {
			addCriterion("CHECK_BUSINESS is not null");
			return (Criteria) this;
		}

		public Criteria andCheckBusinessEqualTo(Byte value) {
			addCriterion("CHECK_BUSINESS =", value, "checkBusiness");
			return (Criteria) this;
		}

		public Criteria andCheckBusinessNotEqualTo(Byte value) {
			addCriterion("CHECK_BUSINESS <>", value, "checkBusiness");
			return (Criteria) this;
		}

		public Criteria andCheckBusinessGreaterThan(Byte value) {
			addCriterion("CHECK_BUSINESS >", value, "checkBusiness");
			return (Criteria) this;
		}

		public Criteria andCheckBusinessGreaterThanOrEqualTo(Byte value) {
			addCriterion("CHECK_BUSINESS >=", value, "checkBusiness");
			return (Criteria) this;
		}

		public Criteria andCheckBusinessLessThan(Byte value) {
			addCriterion("CHECK_BUSINESS <", value, "checkBusiness");
			return (Criteria) this;
		}

		public Criteria andCheckBusinessLessThanOrEqualTo(Byte value) {
			addCriterion("CHECK_BUSINESS <=", value, "checkBusiness");
			return (Criteria) this;
		}

		public Criteria andCheckBusinessIn(List<Byte> values) {
			addCriterion("CHECK_BUSINESS in", values, "checkBusiness");
			return (Criteria) this;
		}

		public Criteria andCheckBusinessNotIn(List<Byte> values) {
			addCriterion("CHECK_BUSINESS not in", values, "checkBusiness");
			return (Criteria) this;
		}

		public Criteria andCheckBusinessBetween(Byte value1, Byte value2) {
			addCriterion("CHECK_BUSINESS between", value1, value2, "checkBusiness");
			return (Criteria) this;
		}

		public Criteria andCheckBusinessNotBetween(Byte value1, Byte value2) {
			addCriterion("CHECK_BUSINESS not between", value1, value2, "checkBusiness");
			return (Criteria) this;
		}

		public Criteria andIsCheckIsNull() {
			addCriterion("IS_CHECK is null");
			return (Criteria) this;
		}

		public Criteria andIsCheckIsNotNull() {
			addCriterion("IS_CHECK is not null");
			return (Criteria) this;
		}

		public Criteria andIsCheckEqualTo(Byte value) {
			addCriterion("IS_CHECK =", value, "isCheck");
			return (Criteria) this;
		}

		public Criteria andIsCheckNotEqualTo(Byte value) {
			addCriterion("IS_CHECK <>", value, "isCheck");
			return (Criteria) this;
		}

		public Criteria andIsCheckGreaterThan(Byte value) {
			addCriterion("IS_CHECK >", value, "isCheck");
			return (Criteria) this;
		}

		public Criteria andIsCheckGreaterThanOrEqualTo(Byte value) {
			addCriterion("IS_CHECK >=", value, "isCheck");
			return (Criteria) this;
		}

		public Criteria andIsCheckLessThan(Byte value) {
			addCriterion("IS_CHECK <", value, "isCheck");
			return (Criteria) this;
		}

		public Criteria andIsCheckLessThanOrEqualTo(Byte value) {
			addCriterion("IS_CHECK <=", value, "isCheck");
			return (Criteria) this;
		}

		public Criteria andIsCheckIn(List<Byte> values) {
			addCriterion("IS_CHECK in", values, "isCheck");
			return (Criteria) this;
		}

		public Criteria andIsCheckNotIn(List<Byte> values) {
			addCriterion("IS_CHECK not in", values, "isCheck");
			return (Criteria) this;
		}

		public Criteria andIsCheckBetween(Byte value1, Byte value2) {
			addCriterion("IS_CHECK between", value1, value2, "isCheck");
			return (Criteria) this;
		}

		public Criteria andIsCheckNotBetween(Byte value1, Byte value2) {
			addCriterion("IS_CHECK not between", value1, value2, "isCheck");
			return (Criteria) this;
		}

		public Criteria andWorkcountSeqIsNull() {
			addCriterion("WORKCOUNT_SEQ is null");
			return (Criteria) this;
		}

		public Criteria andWorkcountSeqIsNotNull() {
			addCriterion("WORKCOUNT_SEQ is not null");
			return (Criteria) this;
		}

		public Criteria andWorkcountSeqEqualTo(Integer value) {
			addCriterion("WORKCOUNT_SEQ =", value, "workcountSeq");
			return (Criteria) this;
		}

		public Criteria andWorkcountSeqNotEqualTo(Integer value) {
			addCriterion("WORKCOUNT_SEQ <>", value, "workcountSeq");
			return (Criteria) this;
		}

		public Criteria andWorkcountSeqGreaterThan(Integer value) {
			addCriterion("WORKCOUNT_SEQ >", value, "workcountSeq");
			return (Criteria) this;
		}

		public Criteria andWorkcountSeqGreaterThanOrEqualTo(Integer value) {
			addCriterion("WORKCOUNT_SEQ >=", value, "workcountSeq");
			return (Criteria) this;
		}

		public Criteria andWorkcountSeqLessThan(Integer value) {
			addCriterion("WORKCOUNT_SEQ <", value, "workcountSeq");
			return (Criteria) this;
		}

		public Criteria andWorkcountSeqLessThanOrEqualTo(Integer value) {
			addCriterion("WORKCOUNT_SEQ <=", value, "workcountSeq");
			return (Criteria) this;
		}

		public Criteria andWorkcountSeqIn(List<Integer> values) {
			addCriterion("WORKCOUNT_SEQ in", values, "workcountSeq");
			return (Criteria) this;
		}

		public Criteria andWorkcountSeqNotIn(List<Integer> values) {
			addCriterion("WORKCOUNT_SEQ not in", values, "workcountSeq");
			return (Criteria) this;
		}

		public Criteria andWorkcountSeqBetween(Integer value1, Integer value2) {
			addCriterion("WORKCOUNT_SEQ between", value1, value2, "workcountSeq");
			return (Criteria) this;
		}

		public Criteria andWorkcountSeqNotBetween(Integer value1, Integer value2) {
			addCriterion("WORKCOUNT_SEQ not between", value1, value2, "workcountSeq");
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