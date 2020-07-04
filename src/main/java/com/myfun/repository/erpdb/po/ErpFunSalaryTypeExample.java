package com.myfun.repository.erpdb.po;

import com.myfun.repository.support.generator.shard.ShardDb;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ErpFunSalaryTypeExample extends ShardDb {
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
	public ErpFunSalaryTypeExample() {
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

		public Criteria andSalaryTypeNameIsNull() {
			addCriterion("SALARY_TYPE_NAME is null");
			return (Criteria) this;
		}

		public Criteria andSalaryTypeNameIsNotNull() {
			addCriterion("SALARY_TYPE_NAME is not null");
			return (Criteria) this;
		}

		public Criteria andSalaryTypeNameEqualTo(String value) {
			addCriterion("SALARY_TYPE_NAME =", value, "salaryTypeName");
			return (Criteria) this;
		}

		public Criteria andSalaryTypeNameNotEqualTo(String value) {
			addCriterion("SALARY_TYPE_NAME <>", value, "salaryTypeName");
			return (Criteria) this;
		}

		public Criteria andSalaryTypeNameGreaterThan(String value) {
			addCriterion("SALARY_TYPE_NAME >", value, "salaryTypeName");
			return (Criteria) this;
		}

		public Criteria andSalaryTypeNameGreaterThanOrEqualTo(String value) {
			addCriterion("SALARY_TYPE_NAME >=", value, "salaryTypeName");
			return (Criteria) this;
		}

		public Criteria andSalaryTypeNameLessThan(String value) {
			addCriterion("SALARY_TYPE_NAME <", value, "salaryTypeName");
			return (Criteria) this;
		}

		public Criteria andSalaryTypeNameLessThanOrEqualTo(String value) {
			addCriterion("SALARY_TYPE_NAME <=", value, "salaryTypeName");
			return (Criteria) this;
		}

		public Criteria andSalaryTypeNameLike(String value) {
			addCriterion("SALARY_TYPE_NAME like", value, "salaryTypeName");
			return (Criteria) this;
		}

		public Criteria andSalaryTypeNameNotLike(String value) {
			addCriterion("SALARY_TYPE_NAME not like", value, "salaryTypeName");
			return (Criteria) this;
		}

		public Criteria andSalaryTypeNameIn(List<String> values) {
			addCriterion("SALARY_TYPE_NAME in", values, "salaryTypeName");
			return (Criteria) this;
		}

		public Criteria andSalaryTypeNameNotIn(List<String> values) {
			addCriterion("SALARY_TYPE_NAME not in", values, "salaryTypeName");
			return (Criteria) this;
		}

		public Criteria andSalaryTypeNameBetween(String value1, String value2) {
			addCriterion("SALARY_TYPE_NAME between", value1, value2, "salaryTypeName");
			return (Criteria) this;
		}

		public Criteria andSalaryTypeNameNotBetween(String value1, String value2) {
			addCriterion("SALARY_TYPE_NAME not between", value1, value2, "salaryTypeName");
			return (Criteria) this;
		}

		public Criteria andSalaryMoneyIsNull() {
			addCriterion("SALARY_MONEY is null");
			return (Criteria) this;
		}

		public Criteria andSalaryMoneyIsNotNull() {
			addCriterion("SALARY_MONEY is not null");
			return (Criteria) this;
		}

		public Criteria andSalaryMoneyEqualTo(BigDecimal value) {
			addCriterion("SALARY_MONEY =", value, "salaryMoney");
			return (Criteria) this;
		}

		public Criteria andSalaryMoneyNotEqualTo(BigDecimal value) {
			addCriterion("SALARY_MONEY <>", value, "salaryMoney");
			return (Criteria) this;
		}

		public Criteria andSalaryMoneyGreaterThan(BigDecimal value) {
			addCriterion("SALARY_MONEY >", value, "salaryMoney");
			return (Criteria) this;
		}

		public Criteria andSalaryMoneyGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("SALARY_MONEY >=", value, "salaryMoney");
			return (Criteria) this;
		}

		public Criteria andSalaryMoneyLessThan(BigDecimal value) {
			addCriterion("SALARY_MONEY <", value, "salaryMoney");
			return (Criteria) this;
		}

		public Criteria andSalaryMoneyLessThanOrEqualTo(BigDecimal value) {
			addCriterion("SALARY_MONEY <=", value, "salaryMoney");
			return (Criteria) this;
		}

		public Criteria andSalaryMoneyIn(List<BigDecimal> values) {
			addCriterion("SALARY_MONEY in", values, "salaryMoney");
			return (Criteria) this;
		}

		public Criteria andSalaryMoneyNotIn(List<BigDecimal> values) {
			addCriterion("SALARY_MONEY not in", values, "salaryMoney");
			return (Criteria) this;
		}

		public Criteria andSalaryMoneyBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("SALARY_MONEY between", value1, value2, "salaryMoney");
			return (Criteria) this;
		}

		public Criteria andSalaryMoneyNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("SALARY_MONEY not between", value1, value2, "salaryMoney");
			return (Criteria) this;
		}

		public Criteria andTaskPercentIsNull() {
			addCriterion("TASK_PERCENT is null");
			return (Criteria) this;
		}

		public Criteria andTaskPercentIsNotNull() {
			addCriterion("TASK_PERCENT is not null");
			return (Criteria) this;
		}

		public Criteria andTaskPercentEqualTo(BigDecimal value) {
			addCriterion("TASK_PERCENT =", value, "taskPercent");
			return (Criteria) this;
		}

		public Criteria andTaskPercentNotEqualTo(BigDecimal value) {
			addCriterion("TASK_PERCENT <>", value, "taskPercent");
			return (Criteria) this;
		}

		public Criteria andTaskPercentGreaterThan(BigDecimal value) {
			addCriterion("TASK_PERCENT >", value, "taskPercent");
			return (Criteria) this;
		}

		public Criteria andTaskPercentGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("TASK_PERCENT >=", value, "taskPercent");
			return (Criteria) this;
		}

		public Criteria andTaskPercentLessThan(BigDecimal value) {
			addCriterion("TASK_PERCENT <", value, "taskPercent");
			return (Criteria) this;
		}

		public Criteria andTaskPercentLessThanOrEqualTo(BigDecimal value) {
			addCriterion("TASK_PERCENT <=", value, "taskPercent");
			return (Criteria) this;
		}

		public Criteria andTaskPercentIn(List<BigDecimal> values) {
			addCriterion("TASK_PERCENT in", values, "taskPercent");
			return (Criteria) this;
		}

		public Criteria andTaskPercentNotIn(List<BigDecimal> values) {
			addCriterion("TASK_PERCENT not in", values, "taskPercent");
			return (Criteria) this;
		}

		public Criteria andTaskPercentBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("TASK_PERCENT between", value1, value2, "taskPercent");
			return (Criteria) this;
		}

		public Criteria andTaskPercentNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("TASK_PERCENT not between", value1, value2, "taskPercent");
			return (Criteria) this;
		}

		public Criteria andTragetProfitIsNull() {
			addCriterion("TRAGET_PROFIT is null");
			return (Criteria) this;
		}

		public Criteria andTragetProfitIsNotNull() {
			addCriterion("TRAGET_PROFIT is not null");
			return (Criteria) this;
		}

		public Criteria andTragetProfitEqualTo(BigDecimal value) {
			addCriterion("TRAGET_PROFIT =", value, "tragetProfit");
			return (Criteria) this;
		}

		public Criteria andTragetProfitNotEqualTo(BigDecimal value) {
			addCriterion("TRAGET_PROFIT <>", value, "tragetProfit");
			return (Criteria) this;
		}

		public Criteria andTragetProfitGreaterThan(BigDecimal value) {
			addCriterion("TRAGET_PROFIT >", value, "tragetProfit");
			return (Criteria) this;
		}

		public Criteria andTragetProfitGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("TRAGET_PROFIT >=", value, "tragetProfit");
			return (Criteria) this;
		}

		public Criteria andTragetProfitLessThan(BigDecimal value) {
			addCriterion("TRAGET_PROFIT <", value, "tragetProfit");
			return (Criteria) this;
		}

		public Criteria andTragetProfitLessThanOrEqualTo(BigDecimal value) {
			addCriterion("TRAGET_PROFIT <=", value, "tragetProfit");
			return (Criteria) this;
		}

		public Criteria andTragetProfitIn(List<BigDecimal> values) {
			addCriterion("TRAGET_PROFIT in", values, "tragetProfit");
			return (Criteria) this;
		}

		public Criteria andTragetProfitNotIn(List<BigDecimal> values) {
			addCriterion("TRAGET_PROFIT not in", values, "tragetProfit");
			return (Criteria) this;
		}

		public Criteria andTragetProfitBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("TRAGET_PROFIT between", value1, value2, "tragetProfit");
			return (Criteria) this;
		}

		public Criteria andTragetProfitNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("TRAGET_PROFIT not between", value1, value2, "tragetProfit");
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

		public Criteria andCreateUserIdIsNull() {
			addCriterion("CREATE_USER_ID is null");
			return (Criteria) this;
		}

		public Criteria andCreateUserIdIsNotNull() {
			addCriterion("CREATE_USER_ID is not null");
			return (Criteria) this;
		}

		public Criteria andCreateUserIdEqualTo(Integer value) {
			addCriterion("CREATE_USER_ID =", value, "createUserId");
			return (Criteria) this;
		}

		public Criteria andCreateUserIdNotEqualTo(Integer value) {
			addCriterion("CREATE_USER_ID <>", value, "createUserId");
			return (Criteria) this;
		}

		public Criteria andCreateUserIdGreaterThan(Integer value) {
			addCriterion("CREATE_USER_ID >", value, "createUserId");
			return (Criteria) this;
		}

		public Criteria andCreateUserIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("CREATE_USER_ID >=", value, "createUserId");
			return (Criteria) this;
		}

		public Criteria andCreateUserIdLessThan(Integer value) {
			addCriterion("CREATE_USER_ID <", value, "createUserId");
			return (Criteria) this;
		}

		public Criteria andCreateUserIdLessThanOrEqualTo(Integer value) {
			addCriterion("CREATE_USER_ID <=", value, "createUserId");
			return (Criteria) this;
		}

		public Criteria andCreateUserIdIn(List<Integer> values) {
			addCriterion("CREATE_USER_ID in", values, "createUserId");
			return (Criteria) this;
		}

		public Criteria andCreateUserIdNotIn(List<Integer> values) {
			addCriterion("CREATE_USER_ID not in", values, "createUserId");
			return (Criteria) this;
		}

		public Criteria andCreateUserIdBetween(Integer value1, Integer value2) {
			addCriterion("CREATE_USER_ID between", value1, value2, "createUserId");
			return (Criteria) this;
		}

		public Criteria andCreateUserIdNotBetween(Integer value1, Integer value2) {
			addCriterion("CREATE_USER_ID not between", value1, value2, "createUserId");
			return (Criteria) this;
		}

		public Criteria andDelFlagIsNull() {
			addCriterion("DEL_FLAG is null");
			return (Criteria) this;
		}

		public Criteria andDelFlagIsNotNull() {
			addCriterion("DEL_FLAG is not null");
			return (Criteria) this;
		}

		public Criteria andDelFlagEqualTo(Integer value) {
			addCriterion("DEL_FLAG =", value, "delFlag");
			return (Criteria) this;
		}

		public Criteria andDelFlagNotEqualTo(Integer value) {
			addCriterion("DEL_FLAG <>", value, "delFlag");
			return (Criteria) this;
		}

		public Criteria andDelFlagGreaterThan(Integer value) {
			addCriterion("DEL_FLAG >", value, "delFlag");
			return (Criteria) this;
		}

		public Criteria andDelFlagGreaterThanOrEqualTo(Integer value) {
			addCriterion("DEL_FLAG >=", value, "delFlag");
			return (Criteria) this;
		}

		public Criteria andDelFlagLessThan(Integer value) {
			addCriterion("DEL_FLAG <", value, "delFlag");
			return (Criteria) this;
		}

		public Criteria andDelFlagLessThanOrEqualTo(Integer value) {
			addCriterion("DEL_FLAG <=", value, "delFlag");
			return (Criteria) this;
		}

		public Criteria andDelFlagIn(List<Integer> values) {
			addCriterion("DEL_FLAG in", values, "delFlag");
			return (Criteria) this;
		}

		public Criteria andDelFlagNotIn(List<Integer> values) {
			addCriterion("DEL_FLAG not in", values, "delFlag");
			return (Criteria) this;
		}

		public Criteria andDelFlagBetween(Integer value1, Integer value2) {
			addCriterion("DEL_FLAG between", value1, value2, "delFlag");
			return (Criteria) this;
		}

		public Criteria andDelFlagNotBetween(Integer value1, Integer value2) {
			addCriterion("DEL_FLAG not between", value1, value2, "delFlag");
			return (Criteria) this;
		}

		public Criteria andHouseAddCountIsNull() {
			addCriterion("HOUSE_ADD_COUNT is null");
			return (Criteria) this;
		}

		public Criteria andHouseAddCountIsNotNull() {
			addCriterion("HOUSE_ADD_COUNT is not null");
			return (Criteria) this;
		}

		public Criteria andHouseAddCountEqualTo(Integer value) {
			addCriterion("HOUSE_ADD_COUNT =", value, "houseAddCount");
			return (Criteria) this;
		}

		public Criteria andHouseAddCountNotEqualTo(Integer value) {
			addCriterion("HOUSE_ADD_COUNT <>", value, "houseAddCount");
			return (Criteria) this;
		}

		public Criteria andHouseAddCountGreaterThan(Integer value) {
			addCriterion("HOUSE_ADD_COUNT >", value, "houseAddCount");
			return (Criteria) this;
		}

		public Criteria andHouseAddCountGreaterThanOrEqualTo(Integer value) {
			addCriterion("HOUSE_ADD_COUNT >=", value, "houseAddCount");
			return (Criteria) this;
		}

		public Criteria andHouseAddCountLessThan(Integer value) {
			addCriterion("HOUSE_ADD_COUNT <", value, "houseAddCount");
			return (Criteria) this;
		}

		public Criteria andHouseAddCountLessThanOrEqualTo(Integer value) {
			addCriterion("HOUSE_ADD_COUNT <=", value, "houseAddCount");
			return (Criteria) this;
		}

		public Criteria andHouseAddCountIn(List<Integer> values) {
			addCriterion("HOUSE_ADD_COUNT in", values, "houseAddCount");
			return (Criteria) this;
		}

		public Criteria andHouseAddCountNotIn(List<Integer> values) {
			addCriterion("HOUSE_ADD_COUNT not in", values, "houseAddCount");
			return (Criteria) this;
		}

		public Criteria andHouseAddCountBetween(Integer value1, Integer value2) {
			addCriterion("HOUSE_ADD_COUNT between", value1, value2, "houseAddCount");
			return (Criteria) this;
		}

		public Criteria andHouseAddCountNotBetween(Integer value1, Integer value2) {
			addCriterion("HOUSE_ADD_COUNT not between", value1, value2, "houseAddCount");
			return (Criteria) this;
		}

		public Criteria andPerHouseMoneyIsNull() {
			addCriterion("PER_HOUSE_MONEY is null");
			return (Criteria) this;
		}

		public Criteria andPerHouseMoneyIsNotNull() {
			addCriterion("PER_HOUSE_MONEY is not null");
			return (Criteria) this;
		}

		public Criteria andPerHouseMoneyEqualTo(BigDecimal value) {
			addCriterion("PER_HOUSE_MONEY =", value, "perHouseMoney");
			return (Criteria) this;
		}

		public Criteria andPerHouseMoneyNotEqualTo(BigDecimal value) {
			addCriterion("PER_HOUSE_MONEY <>", value, "perHouseMoney");
			return (Criteria) this;
		}

		public Criteria andPerHouseMoneyGreaterThan(BigDecimal value) {
			addCriterion("PER_HOUSE_MONEY >", value, "perHouseMoney");
			return (Criteria) this;
		}

		public Criteria andPerHouseMoneyGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("PER_HOUSE_MONEY >=", value, "perHouseMoney");
			return (Criteria) this;
		}

		public Criteria andPerHouseMoneyLessThan(BigDecimal value) {
			addCriterion("PER_HOUSE_MONEY <", value, "perHouseMoney");
			return (Criteria) this;
		}

		public Criteria andPerHouseMoneyLessThanOrEqualTo(BigDecimal value) {
			addCriterion("PER_HOUSE_MONEY <=", value, "perHouseMoney");
			return (Criteria) this;
		}

		public Criteria andPerHouseMoneyIn(List<BigDecimal> values) {
			addCriterion("PER_HOUSE_MONEY in", values, "perHouseMoney");
			return (Criteria) this;
		}

		public Criteria andPerHouseMoneyNotIn(List<BigDecimal> values) {
			addCriterion("PER_HOUSE_MONEY not in", values, "perHouseMoney");
			return (Criteria) this;
		}

		public Criteria andPerHouseMoneyBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("PER_HOUSE_MONEY between", value1, value2, "perHouseMoney");
			return (Criteria) this;
		}

		public Criteria andPerHouseMoneyNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("PER_HOUSE_MONEY not between", value1, value2, "perHouseMoney");
			return (Criteria) this;
		}

		public Criteria andCustAddCountIsNull() {
			addCriterion("CUST_ADD_COUNT is null");
			return (Criteria) this;
		}

		public Criteria andCustAddCountIsNotNull() {
			addCriterion("CUST_ADD_COUNT is not null");
			return (Criteria) this;
		}

		public Criteria andCustAddCountEqualTo(Integer value) {
			addCriterion("CUST_ADD_COUNT =", value, "custAddCount");
			return (Criteria) this;
		}

		public Criteria andCustAddCountNotEqualTo(Integer value) {
			addCriterion("CUST_ADD_COUNT <>", value, "custAddCount");
			return (Criteria) this;
		}

		public Criteria andCustAddCountGreaterThan(Integer value) {
			addCriterion("CUST_ADD_COUNT >", value, "custAddCount");
			return (Criteria) this;
		}

		public Criteria andCustAddCountGreaterThanOrEqualTo(Integer value) {
			addCriterion("CUST_ADD_COUNT >=", value, "custAddCount");
			return (Criteria) this;
		}

		public Criteria andCustAddCountLessThan(Integer value) {
			addCriterion("CUST_ADD_COUNT <", value, "custAddCount");
			return (Criteria) this;
		}

		public Criteria andCustAddCountLessThanOrEqualTo(Integer value) {
			addCriterion("CUST_ADD_COUNT <=", value, "custAddCount");
			return (Criteria) this;
		}

		public Criteria andCustAddCountIn(List<Integer> values) {
			addCriterion("CUST_ADD_COUNT in", values, "custAddCount");
			return (Criteria) this;
		}

		public Criteria andCustAddCountNotIn(List<Integer> values) {
			addCriterion("CUST_ADD_COUNT not in", values, "custAddCount");
			return (Criteria) this;
		}

		public Criteria andCustAddCountBetween(Integer value1, Integer value2) {
			addCriterion("CUST_ADD_COUNT between", value1, value2, "custAddCount");
			return (Criteria) this;
		}

		public Criteria andCustAddCountNotBetween(Integer value1, Integer value2) {
			addCriterion("CUST_ADD_COUNT not between", value1, value2, "custAddCount");
			return (Criteria) this;
		}

		public Criteria andPerCustMoneyIsNull() {
			addCriterion("PER_CUST_MONEY is null");
			return (Criteria) this;
		}

		public Criteria andPerCustMoneyIsNotNull() {
			addCriterion("PER_CUST_MONEY is not null");
			return (Criteria) this;
		}

		public Criteria andPerCustMoneyEqualTo(BigDecimal value) {
			addCriterion("PER_CUST_MONEY =", value, "perCustMoney");
			return (Criteria) this;
		}

		public Criteria andPerCustMoneyNotEqualTo(BigDecimal value) {
			addCriterion("PER_CUST_MONEY <>", value, "perCustMoney");
			return (Criteria) this;
		}

		public Criteria andPerCustMoneyGreaterThan(BigDecimal value) {
			addCriterion("PER_CUST_MONEY >", value, "perCustMoney");
			return (Criteria) this;
		}

		public Criteria andPerCustMoneyGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("PER_CUST_MONEY >=", value, "perCustMoney");
			return (Criteria) this;
		}

		public Criteria andPerCustMoneyLessThan(BigDecimal value) {
			addCriterion("PER_CUST_MONEY <", value, "perCustMoney");
			return (Criteria) this;
		}

		public Criteria andPerCustMoneyLessThanOrEqualTo(BigDecimal value) {
			addCriterion("PER_CUST_MONEY <=", value, "perCustMoney");
			return (Criteria) this;
		}

		public Criteria andPerCustMoneyIn(List<BigDecimal> values) {
			addCriterion("PER_CUST_MONEY in", values, "perCustMoney");
			return (Criteria) this;
		}

		public Criteria andPerCustMoneyNotIn(List<BigDecimal> values) {
			addCriterion("PER_CUST_MONEY not in", values, "perCustMoney");
			return (Criteria) this;
		}

		public Criteria andPerCustMoneyBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("PER_CUST_MONEY between", value1, value2, "perCustMoney");
			return (Criteria) this;
		}

		public Criteria andPerCustMoneyNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("PER_CUST_MONEY not between", value1, value2, "perCustMoney");
			return (Criteria) this;
		}

		public Criteria andFankanCountIsNull() {
			addCriterion("FANKAN_COUNT is null");
			return (Criteria) this;
		}

		public Criteria andFankanCountIsNotNull() {
			addCriterion("FANKAN_COUNT is not null");
			return (Criteria) this;
		}

		public Criteria andFankanCountEqualTo(Integer value) {
			addCriterion("FANKAN_COUNT =", value, "fankanCount");
			return (Criteria) this;
		}

		public Criteria andFankanCountNotEqualTo(Integer value) {
			addCriterion("FANKAN_COUNT <>", value, "fankanCount");
			return (Criteria) this;
		}

		public Criteria andFankanCountGreaterThan(Integer value) {
			addCriterion("FANKAN_COUNT >", value, "fankanCount");
			return (Criteria) this;
		}

		public Criteria andFankanCountGreaterThanOrEqualTo(Integer value) {
			addCriterion("FANKAN_COUNT >=", value, "fankanCount");
			return (Criteria) this;
		}

		public Criteria andFankanCountLessThan(Integer value) {
			addCriterion("FANKAN_COUNT <", value, "fankanCount");
			return (Criteria) this;
		}

		public Criteria andFankanCountLessThanOrEqualTo(Integer value) {
			addCriterion("FANKAN_COUNT <=", value, "fankanCount");
			return (Criteria) this;
		}

		public Criteria andFankanCountIn(List<Integer> values) {
			addCriterion("FANKAN_COUNT in", values, "fankanCount");
			return (Criteria) this;
		}

		public Criteria andFankanCountNotIn(List<Integer> values) {
			addCriterion("FANKAN_COUNT not in", values, "fankanCount");
			return (Criteria) this;
		}

		public Criteria andFankanCountBetween(Integer value1, Integer value2) {
			addCriterion("FANKAN_COUNT between", value1, value2, "fankanCount");
			return (Criteria) this;
		}

		public Criteria andFankanCountNotBetween(Integer value1, Integer value2) {
			addCriterion("FANKAN_COUNT not between", value1, value2, "fankanCount");
			return (Criteria) this;
		}

		public Criteria andPerFankanMoneyIsNull() {
			addCriterion("PER_FANKAN_MONEY is null");
			return (Criteria) this;
		}

		public Criteria andPerFankanMoneyIsNotNull() {
			addCriterion("PER_FANKAN_MONEY is not null");
			return (Criteria) this;
		}

		public Criteria andPerFankanMoneyEqualTo(BigDecimal value) {
			addCriterion("PER_FANKAN_MONEY =", value, "perFankanMoney");
			return (Criteria) this;
		}

		public Criteria andPerFankanMoneyNotEqualTo(BigDecimal value) {
			addCriterion("PER_FANKAN_MONEY <>", value, "perFankanMoney");
			return (Criteria) this;
		}

		public Criteria andPerFankanMoneyGreaterThan(BigDecimal value) {
			addCriterion("PER_FANKAN_MONEY >", value, "perFankanMoney");
			return (Criteria) this;
		}

		public Criteria andPerFankanMoneyGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("PER_FANKAN_MONEY >=", value, "perFankanMoney");
			return (Criteria) this;
		}

		public Criteria andPerFankanMoneyLessThan(BigDecimal value) {
			addCriterion("PER_FANKAN_MONEY <", value, "perFankanMoney");
			return (Criteria) this;
		}

		public Criteria andPerFankanMoneyLessThanOrEqualTo(BigDecimal value) {
			addCriterion("PER_FANKAN_MONEY <=", value, "perFankanMoney");
			return (Criteria) this;
		}

		public Criteria andPerFankanMoneyIn(List<BigDecimal> values) {
			addCriterion("PER_FANKAN_MONEY in", values, "perFankanMoney");
			return (Criteria) this;
		}

		public Criteria andPerFankanMoneyNotIn(List<BigDecimal> values) {
			addCriterion("PER_FANKAN_MONEY not in", values, "perFankanMoney");
			return (Criteria) this;
		}

		public Criteria andPerFankanMoneyBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("PER_FANKAN_MONEY between", value1, value2, "perFankanMoney");
			return (Criteria) this;
		}

		public Criteria andPerFankanMoneyNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("PER_FANKAN_MONEY not between", value1, value2, "perFankanMoney");
			return (Criteria) this;
		}

		public Criteria andDaikanCountIsNull() {
			addCriterion("DAIKAN_COUNT is null");
			return (Criteria) this;
		}

		public Criteria andDaikanCountIsNotNull() {
			addCriterion("DAIKAN_COUNT is not null");
			return (Criteria) this;
		}

		public Criteria andDaikanCountEqualTo(Integer value) {
			addCriterion("DAIKAN_COUNT =", value, "daikanCount");
			return (Criteria) this;
		}

		public Criteria andDaikanCountNotEqualTo(Integer value) {
			addCriterion("DAIKAN_COUNT <>", value, "daikanCount");
			return (Criteria) this;
		}

		public Criteria andDaikanCountGreaterThan(Integer value) {
			addCriterion("DAIKAN_COUNT >", value, "daikanCount");
			return (Criteria) this;
		}

		public Criteria andDaikanCountGreaterThanOrEqualTo(Integer value) {
			addCriterion("DAIKAN_COUNT >=", value, "daikanCount");
			return (Criteria) this;
		}

		public Criteria andDaikanCountLessThan(Integer value) {
			addCriterion("DAIKAN_COUNT <", value, "daikanCount");
			return (Criteria) this;
		}

		public Criteria andDaikanCountLessThanOrEqualTo(Integer value) {
			addCriterion("DAIKAN_COUNT <=", value, "daikanCount");
			return (Criteria) this;
		}

		public Criteria andDaikanCountIn(List<Integer> values) {
			addCriterion("DAIKAN_COUNT in", values, "daikanCount");
			return (Criteria) this;
		}

		public Criteria andDaikanCountNotIn(List<Integer> values) {
			addCriterion("DAIKAN_COUNT not in", values, "daikanCount");
			return (Criteria) this;
		}

		public Criteria andDaikanCountBetween(Integer value1, Integer value2) {
			addCriterion("DAIKAN_COUNT between", value1, value2, "daikanCount");
			return (Criteria) this;
		}

		public Criteria andDaikanCountNotBetween(Integer value1, Integer value2) {
			addCriterion("DAIKAN_COUNT not between", value1, value2, "daikanCount");
			return (Criteria) this;
		}

		public Criteria andPerDaikanMoneyIsNull() {
			addCriterion("PER_DAIKAN_MONEY is null");
			return (Criteria) this;
		}

		public Criteria andPerDaikanMoneyIsNotNull() {
			addCriterion("PER_DAIKAN_MONEY is not null");
			return (Criteria) this;
		}

		public Criteria andPerDaikanMoneyEqualTo(BigDecimal value) {
			addCriterion("PER_DAIKAN_MONEY =", value, "perDaikanMoney");
			return (Criteria) this;
		}

		public Criteria andPerDaikanMoneyNotEqualTo(BigDecimal value) {
			addCriterion("PER_DAIKAN_MONEY <>", value, "perDaikanMoney");
			return (Criteria) this;
		}

		public Criteria andPerDaikanMoneyGreaterThan(BigDecimal value) {
			addCriterion("PER_DAIKAN_MONEY >", value, "perDaikanMoney");
			return (Criteria) this;
		}

		public Criteria andPerDaikanMoneyGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("PER_DAIKAN_MONEY >=", value, "perDaikanMoney");
			return (Criteria) this;
		}

		public Criteria andPerDaikanMoneyLessThan(BigDecimal value) {
			addCriterion("PER_DAIKAN_MONEY <", value, "perDaikanMoney");
			return (Criteria) this;
		}

		public Criteria andPerDaikanMoneyLessThanOrEqualTo(BigDecimal value) {
			addCriterion("PER_DAIKAN_MONEY <=", value, "perDaikanMoney");
			return (Criteria) this;
		}

		public Criteria andPerDaikanMoneyIn(List<BigDecimal> values) {
			addCriterion("PER_DAIKAN_MONEY in", values, "perDaikanMoney");
			return (Criteria) this;
		}

		public Criteria andPerDaikanMoneyNotIn(List<BigDecimal> values) {
			addCriterion("PER_DAIKAN_MONEY not in", values, "perDaikanMoney");
			return (Criteria) this;
		}

		public Criteria andPerDaikanMoneyBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("PER_DAIKAN_MONEY between", value1, value2, "perDaikanMoney");
			return (Criteria) this;
		}

		public Criteria andPerDaikanMoneyNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("PER_DAIKAN_MONEY not between", value1, value2, "perDaikanMoney");
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

		public Criteria andUpdateTimeEqualTo(String value) {
			addCriterion("UPDATE_TIME =", value, "updateTime");
			return (Criteria) this;
		}

		public Criteria andUpdateTimeNotEqualTo(String value) {
			addCriterion("UPDATE_TIME <>", value, "updateTime");
			return (Criteria) this;
		}

		public Criteria andUpdateTimeGreaterThan(String value) {
			addCriterion("UPDATE_TIME >", value, "updateTime");
			return (Criteria) this;
		}

		public Criteria andUpdateTimeGreaterThanOrEqualTo(String value) {
			addCriterion("UPDATE_TIME >=", value, "updateTime");
			return (Criteria) this;
		}

		public Criteria andUpdateTimeLessThan(String value) {
			addCriterion("UPDATE_TIME <", value, "updateTime");
			return (Criteria) this;
		}

		public Criteria andUpdateTimeLessThanOrEqualTo(String value) {
			addCriterion("UPDATE_TIME <=", value, "updateTime");
			return (Criteria) this;
		}

		public Criteria andUpdateTimeLike(String value) {
			addCriterion("UPDATE_TIME like", value, "updateTime");
			return (Criteria) this;
		}

		public Criteria andUpdateTimeNotLike(String value) {
			addCriterion("UPDATE_TIME not like", value, "updateTime");
			return (Criteria) this;
		}

		public Criteria andUpdateTimeIn(List<String> values) {
			addCriterion("UPDATE_TIME in", values, "updateTime");
			return (Criteria) this;
		}

		public Criteria andUpdateTimeNotIn(List<String> values) {
			addCriterion("UPDATE_TIME not in", values, "updateTime");
			return (Criteria) this;
		}

		public Criteria andUpdateTimeBetween(String value1, String value2) {
			addCriterion("UPDATE_TIME between", value1, value2, "updateTime");
			return (Criteria) this;
		}

		public Criteria andUpdateTimeNotBetween(String value1, String value2) {
			addCriterion("UPDATE_TIME not between", value1, value2, "updateTime");
			return (Criteria) this;
		}

		public Criteria andRoleIdIsNull() {
			addCriterion("ROLE_ID is null");
			return (Criteria) this;
		}

		public Criteria andRoleIdIsNotNull() {
			addCriterion("ROLE_ID is not null");
			return (Criteria) this;
		}

		public Criteria andRoleIdEqualTo(String value) {
			addCriterion("ROLE_ID =", value, "roleId");
			return (Criteria) this;
		}

		public Criteria andRoleIdNotEqualTo(String value) {
			addCriterion("ROLE_ID <>", value, "roleId");
			return (Criteria) this;
		}

		public Criteria andRoleIdGreaterThan(String value) {
			addCriterion("ROLE_ID >", value, "roleId");
			return (Criteria) this;
		}

		public Criteria andRoleIdGreaterThanOrEqualTo(String value) {
			addCriterion("ROLE_ID >=", value, "roleId");
			return (Criteria) this;
		}

		public Criteria andRoleIdLessThan(String value) {
			addCriterion("ROLE_ID <", value, "roleId");
			return (Criteria) this;
		}

		public Criteria andRoleIdLessThanOrEqualTo(String value) {
			addCriterion("ROLE_ID <=", value, "roleId");
			return (Criteria) this;
		}

		public Criteria andRoleIdLike(String value) {
			addCriterion("ROLE_ID like", value, "roleId");
			return (Criteria) this;
		}

		public Criteria andRoleIdNotLike(String value) {
			addCriterion("ROLE_ID not like", value, "roleId");
			return (Criteria) this;
		}

		public Criteria andRoleIdIn(List<String> values) {
			addCriterion("ROLE_ID in", values, "roleId");
			return (Criteria) this;
		}

		public Criteria andRoleIdNotIn(List<String> values) {
			addCriterion("ROLE_ID not in", values, "roleId");
			return (Criteria) this;
		}

		public Criteria andRoleIdBetween(String value1, String value2) {
			addCriterion("ROLE_ID between", value1, value2, "roleId");
			return (Criteria) this;
		}

		public Criteria andRoleIdNotBetween(String value1, String value2) {
			addCriterion("ROLE_ID not between", value1, value2, "roleId");
			return (Criteria) this;
		}

		public Criteria andManageLevelIsNull() {
			addCriterion("MANAGE_LEVEL is null");
			return (Criteria) this;
		}

		public Criteria andManageLevelIsNotNull() {
			addCriterion("MANAGE_LEVEL is not null");
			return (Criteria) this;
		}

		public Criteria andManageLevelEqualTo(Byte value) {
			addCriterion("MANAGE_LEVEL =", value, "manageLevel");
			return (Criteria) this;
		}

		public Criteria andManageLevelNotEqualTo(Byte value) {
			addCriterion("MANAGE_LEVEL <>", value, "manageLevel");
			return (Criteria) this;
		}

		public Criteria andManageLevelGreaterThan(Byte value) {
			addCriterion("MANAGE_LEVEL >", value, "manageLevel");
			return (Criteria) this;
		}

		public Criteria andManageLevelGreaterThanOrEqualTo(Byte value) {
			addCriterion("MANAGE_LEVEL >=", value, "manageLevel");
			return (Criteria) this;
		}

		public Criteria andManageLevelLessThan(Byte value) {
			addCriterion("MANAGE_LEVEL <", value, "manageLevel");
			return (Criteria) this;
		}

		public Criteria andManageLevelLessThanOrEqualTo(Byte value) {
			addCriterion("MANAGE_LEVEL <=", value, "manageLevel");
			return (Criteria) this;
		}

		public Criteria andManageLevelIn(List<Byte> values) {
			addCriterion("MANAGE_LEVEL in", values, "manageLevel");
			return (Criteria) this;
		}

		public Criteria andManageLevelNotIn(List<Byte> values) {
			addCriterion("MANAGE_LEVEL not in", values, "manageLevel");
			return (Criteria) this;
		}

		public Criteria andManageLevelBetween(Byte value1, Byte value2) {
			addCriterion("MANAGE_LEVEL between", value1, value2, "manageLevel");
			return (Criteria) this;
		}

		public Criteria andManageLevelNotBetween(Byte value1, Byte value2) {
			addCriterion("MANAGE_LEVEL not between", value1, value2, "manageLevel");
			return (Criteria) this;
		}

		public Criteria andCountTypeIsNull() {
			addCriterion("COUNT_TYPE is null");
			return (Criteria) this;
		}

		public Criteria andCountTypeIsNotNull() {
			addCriterion("COUNT_TYPE is not null");
			return (Criteria) this;
		}

		public Criteria andCountTypeEqualTo(Byte value) {
			addCriterion("COUNT_TYPE =", value, "countType");
			return (Criteria) this;
		}

		public Criteria andCountTypeNotEqualTo(Byte value) {
			addCriterion("COUNT_TYPE <>", value, "countType");
			return (Criteria) this;
		}

		public Criteria andCountTypeGreaterThan(Byte value) {
			addCriterion("COUNT_TYPE >", value, "countType");
			return (Criteria) this;
		}

		public Criteria andCountTypeGreaterThanOrEqualTo(Byte value) {
			addCriterion("COUNT_TYPE >=", value, "countType");
			return (Criteria) this;
		}

		public Criteria andCountTypeLessThan(Byte value) {
			addCriterion("COUNT_TYPE <", value, "countType");
			return (Criteria) this;
		}

		public Criteria andCountTypeLessThanOrEqualTo(Byte value) {
			addCriterion("COUNT_TYPE <=", value, "countType");
			return (Criteria) this;
		}

		public Criteria andCountTypeIn(List<Byte> values) {
			addCriterion("COUNT_TYPE in", values, "countType");
			return (Criteria) this;
		}

		public Criteria andCountTypeNotIn(List<Byte> values) {
			addCriterion("COUNT_TYPE not in", values, "countType");
			return (Criteria) this;
		}

		public Criteria andCountTypeBetween(Byte value1, Byte value2) {
			addCriterion("COUNT_TYPE between", value1, value2, "countType");
			return (Criteria) this;
		}

		public Criteria andCountTypeNotBetween(Byte value1, Byte value2) {
			addCriterion("COUNT_TYPE not between", value1, value2, "countType");
			return (Criteria) this;
		}

		public Criteria andProfitCountTypeIsNull() {
			addCriterion("PROFIT_COUNT_TYPE is null");
			return (Criteria) this;
		}

		public Criteria andProfitCountTypeIsNotNull() {
			addCriterion("PROFIT_COUNT_TYPE is not null");
			return (Criteria) this;
		}

		public Criteria andProfitCountTypeEqualTo(Byte value) {
			addCriterion("PROFIT_COUNT_TYPE =", value, "profitCountType");
			return (Criteria) this;
		}

		public Criteria andProfitCountTypeNotEqualTo(Byte value) {
			addCriterion("PROFIT_COUNT_TYPE <>", value, "profitCountType");
			return (Criteria) this;
		}

		public Criteria andProfitCountTypeGreaterThan(Byte value) {
			addCriterion("PROFIT_COUNT_TYPE >", value, "profitCountType");
			return (Criteria) this;
		}

		public Criteria andProfitCountTypeGreaterThanOrEqualTo(Byte value) {
			addCriterion("PROFIT_COUNT_TYPE >=", value, "profitCountType");
			return (Criteria) this;
		}

		public Criteria andProfitCountTypeLessThan(Byte value) {
			addCriterion("PROFIT_COUNT_TYPE <", value, "profitCountType");
			return (Criteria) this;
		}

		public Criteria andProfitCountTypeLessThanOrEqualTo(Byte value) {
			addCriterion("PROFIT_COUNT_TYPE <=", value, "profitCountType");
			return (Criteria) this;
		}

		public Criteria andProfitCountTypeIn(List<Byte> values) {
			addCriterion("PROFIT_COUNT_TYPE in", values, "profitCountType");
			return (Criteria) this;
		}

		public Criteria andProfitCountTypeNotIn(List<Byte> values) {
			addCriterion("PROFIT_COUNT_TYPE not in", values, "profitCountType");
			return (Criteria) this;
		}

		public Criteria andProfitCountTypeBetween(Byte value1, Byte value2) {
			addCriterion("PROFIT_COUNT_TYPE between", value1, value2, "profitCountType");
			return (Criteria) this;
		}

		public Criteria andProfitCountTypeNotBetween(Byte value1, Byte value2) {
			addCriterion("PROFIT_COUNT_TYPE not between", value1, value2, "profitCountType");
			return (Criteria) this;
		}

		public Criteria andTaskMoneyIsNull() {
			addCriterion("TASK_MONEY is null");
			return (Criteria) this;
		}

		public Criteria andTaskMoneyIsNotNull() {
			addCriterion("TASK_MONEY is not null");
			return (Criteria) this;
		}

		public Criteria andTaskMoneyEqualTo(BigDecimal value) {
			addCriterion("TASK_MONEY =", value, "taskMoney");
			return (Criteria) this;
		}

		public Criteria andTaskMoneyNotEqualTo(BigDecimal value) {
			addCriterion("TASK_MONEY <>", value, "taskMoney");
			return (Criteria) this;
		}

		public Criteria andTaskMoneyGreaterThan(BigDecimal value) {
			addCriterion("TASK_MONEY >", value, "taskMoney");
			return (Criteria) this;
		}

		public Criteria andTaskMoneyGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("TASK_MONEY >=", value, "taskMoney");
			return (Criteria) this;
		}

		public Criteria andTaskMoneyLessThan(BigDecimal value) {
			addCriterion("TASK_MONEY <", value, "taskMoney");
			return (Criteria) this;
		}

		public Criteria andTaskMoneyLessThanOrEqualTo(BigDecimal value) {
			addCriterion("TASK_MONEY <=", value, "taskMoney");
			return (Criteria) this;
		}

		public Criteria andTaskMoneyIn(List<BigDecimal> values) {
			addCriterion("TASK_MONEY in", values, "taskMoney");
			return (Criteria) this;
		}

		public Criteria andTaskMoneyNotIn(List<BigDecimal> values) {
			addCriterion("TASK_MONEY not in", values, "taskMoney");
			return (Criteria) this;
		}

		public Criteria andTaskMoneyBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("TASK_MONEY between", value1, value2, "taskMoney");
			return (Criteria) this;
		}

		public Criteria andTaskMoneyNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("TASK_MONEY not between", value1, value2, "taskMoney");
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