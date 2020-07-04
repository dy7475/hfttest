package com.myfun.repository.erpdb.po;

import com.myfun.repository.support.generator.shard.ShardDb;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ErpFunWageExample extends ShardDb {
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
	public ErpFunWageExample() {
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

		public Criteria andWageIdIsNull() {
			addCriterion("WAGE_ID is null");
			return (Criteria) this;
		}

		public Criteria andWageIdIsNotNull() {
			addCriterion("WAGE_ID is not null");
			return (Criteria) this;
		}

		public Criteria andWageIdEqualTo(Integer value) {
			addCriterion("WAGE_ID =", value, "wageId");
			return (Criteria) this;
		}

		public Criteria andWageIdNotEqualTo(Integer value) {
			addCriterion("WAGE_ID <>", value, "wageId");
			return (Criteria) this;
		}

		public Criteria andWageIdGreaterThan(Integer value) {
			addCriterion("WAGE_ID >", value, "wageId");
			return (Criteria) this;
		}

		public Criteria andWageIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("WAGE_ID >=", value, "wageId");
			return (Criteria) this;
		}

		public Criteria andWageIdLessThan(Integer value) {
			addCriterion("WAGE_ID <", value, "wageId");
			return (Criteria) this;
		}

		public Criteria andWageIdLessThanOrEqualTo(Integer value) {
			addCriterion("WAGE_ID <=", value, "wageId");
			return (Criteria) this;
		}

		public Criteria andWageIdIn(List<Integer> values) {
			addCriterion("WAGE_ID in", values, "wageId");
			return (Criteria) this;
		}

		public Criteria andWageIdNotIn(List<Integer> values) {
			addCriterion("WAGE_ID not in", values, "wageId");
			return (Criteria) this;
		}

		public Criteria andWageIdBetween(Integer value1, Integer value2) {
			addCriterion("WAGE_ID between", value1, value2, "wageId");
			return (Criteria) this;
		}

		public Criteria andWageIdNotBetween(Integer value1, Integer value2) {
			addCriterion("WAGE_ID not between", value1, value2, "wageId");
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

		public Criteria andDeptIdIsNull() {
			addCriterion("DEPT_ID is null");
			return (Criteria) this;
		}

		public Criteria andDeptIdIsNotNull() {
			addCriterion("DEPT_ID is not null");
			return (Criteria) this;
		}

		public Criteria andDeptIdEqualTo(Integer value) {
			addCriterion("DEPT_ID =", value, "deptId");
			return (Criteria) this;
		}

		public Criteria andDeptIdNotEqualTo(Integer value) {
			addCriterion("DEPT_ID <>", value, "deptId");
			return (Criteria) this;
		}

		public Criteria andDeptIdGreaterThan(Integer value) {
			addCriterion("DEPT_ID >", value, "deptId");
			return (Criteria) this;
		}

		public Criteria andDeptIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("DEPT_ID >=", value, "deptId");
			return (Criteria) this;
		}

		public Criteria andDeptIdLessThan(Integer value) {
			addCriterion("DEPT_ID <", value, "deptId");
			return (Criteria) this;
		}

		public Criteria andDeptIdLessThanOrEqualTo(Integer value) {
			addCriterion("DEPT_ID <=", value, "deptId");
			return (Criteria) this;
		}

		public Criteria andDeptIdIn(List<Integer> values) {
			addCriterion("DEPT_ID in", values, "deptId");
			return (Criteria) this;
		}

		public Criteria andDeptIdNotIn(List<Integer> values) {
			addCriterion("DEPT_ID not in", values, "deptId");
			return (Criteria) this;
		}

		public Criteria andDeptIdBetween(Integer value1, Integer value2) {
			addCriterion("DEPT_ID between", value1, value2, "deptId");
			return (Criteria) this;
		}

		public Criteria andDeptIdNotBetween(Integer value1, Integer value2) {
			addCriterion("DEPT_ID not between", value1, value2, "deptId");
			return (Criteria) this;
		}

		public Criteria andProfitWageIsNull() {
			addCriterion("PROFIT_WAGE is null");
			return (Criteria) this;
		}

		public Criteria andProfitWageIsNotNull() {
			addCriterion("PROFIT_WAGE is not null");
			return (Criteria) this;
		}

		public Criteria andProfitWageEqualTo(BigDecimal value) {
			addCriterion("PROFIT_WAGE =", value, "profitWage");
			return (Criteria) this;
		}

		public Criteria andProfitWageNotEqualTo(BigDecimal value) {
			addCriterion("PROFIT_WAGE <>", value, "profitWage");
			return (Criteria) this;
		}

		public Criteria andProfitWageGreaterThan(BigDecimal value) {
			addCriterion("PROFIT_WAGE >", value, "profitWage");
			return (Criteria) this;
		}

		public Criteria andProfitWageGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("PROFIT_WAGE >=", value, "profitWage");
			return (Criteria) this;
		}

		public Criteria andProfitWageLessThan(BigDecimal value) {
			addCriterion("PROFIT_WAGE <", value, "profitWage");
			return (Criteria) this;
		}

		public Criteria andProfitWageLessThanOrEqualTo(BigDecimal value) {
			addCriterion("PROFIT_WAGE <=", value, "profitWage");
			return (Criteria) this;
		}

		public Criteria andProfitWageIn(List<BigDecimal> values) {
			addCriterion("PROFIT_WAGE in", values, "profitWage");
			return (Criteria) this;
		}

		public Criteria andProfitWageNotIn(List<BigDecimal> values) {
			addCriterion("PROFIT_WAGE not in", values, "profitWage");
			return (Criteria) this;
		}

		public Criteria andProfitWageBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("PROFIT_WAGE between", value1, value2, "profitWage");
			return (Criteria) this;
		}

		public Criteria andProfitWageNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("PROFIT_WAGE not between", value1, value2, "profitWage");
			return (Criteria) this;
		}

		public Criteria andWageMoneyIsNull() {
			addCriterion("WAGE_MONEY is null");
			return (Criteria) this;
		}

		public Criteria andWageMoneyIsNotNull() {
			addCriterion("WAGE_MONEY is not null");
			return (Criteria) this;
		}

		public Criteria andWageMoneyEqualTo(BigDecimal value) {
			addCriterion("WAGE_MONEY =", value, "wageMoney");
			return (Criteria) this;
		}

		public Criteria andWageMoneyNotEqualTo(BigDecimal value) {
			addCriterion("WAGE_MONEY <>", value, "wageMoney");
			return (Criteria) this;
		}

		public Criteria andWageMoneyGreaterThan(BigDecimal value) {
			addCriterion("WAGE_MONEY >", value, "wageMoney");
			return (Criteria) this;
		}

		public Criteria andWageMoneyGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("WAGE_MONEY >=", value, "wageMoney");
			return (Criteria) this;
		}

		public Criteria andWageMoneyLessThan(BigDecimal value) {
			addCriterion("WAGE_MONEY <", value, "wageMoney");
			return (Criteria) this;
		}

		public Criteria andWageMoneyLessThanOrEqualTo(BigDecimal value) {
			addCriterion("WAGE_MONEY <=", value, "wageMoney");
			return (Criteria) this;
		}

		public Criteria andWageMoneyIn(List<BigDecimal> values) {
			addCriterion("WAGE_MONEY in", values, "wageMoney");
			return (Criteria) this;
		}

		public Criteria andWageMoneyNotIn(List<BigDecimal> values) {
			addCriterion("WAGE_MONEY not in", values, "wageMoney");
			return (Criteria) this;
		}

		public Criteria andWageMoneyBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("WAGE_MONEY between", value1, value2, "wageMoney");
			return (Criteria) this;
		}

		public Criteria andWageMoneyNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("WAGE_MONEY not between", value1, value2, "wageMoney");
			return (Criteria) this;
		}

		public Criteria andOtherWageIsNull() {
			addCriterion("OTHER_WAGE is null");
			return (Criteria) this;
		}

		public Criteria andOtherWageIsNotNull() {
			addCriterion("OTHER_WAGE is not null");
			return (Criteria) this;
		}

		public Criteria andOtherWageEqualTo(BigDecimal value) {
			addCriterion("OTHER_WAGE =", value, "otherWage");
			return (Criteria) this;
		}

		public Criteria andOtherWageNotEqualTo(BigDecimal value) {
			addCriterion("OTHER_WAGE <>", value, "otherWage");
			return (Criteria) this;
		}

		public Criteria andOtherWageGreaterThan(BigDecimal value) {
			addCriterion("OTHER_WAGE >", value, "otherWage");
			return (Criteria) this;
		}

		public Criteria andOtherWageGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("OTHER_WAGE >=", value, "otherWage");
			return (Criteria) this;
		}

		public Criteria andOtherWageLessThan(BigDecimal value) {
			addCriterion("OTHER_WAGE <", value, "otherWage");
			return (Criteria) this;
		}

		public Criteria andOtherWageLessThanOrEqualTo(BigDecimal value) {
			addCriterion("OTHER_WAGE <=", value, "otherWage");
			return (Criteria) this;
		}

		public Criteria andOtherWageIn(List<BigDecimal> values) {
			addCriterion("OTHER_WAGE in", values, "otherWage");
			return (Criteria) this;
		}

		public Criteria andOtherWageNotIn(List<BigDecimal> values) {
			addCriterion("OTHER_WAGE not in", values, "otherWage");
			return (Criteria) this;
		}

		public Criteria andOtherWageBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("OTHER_WAGE between", value1, value2, "otherWage");
			return (Criteria) this;
		}

		public Criteria andOtherWageNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("OTHER_WAGE not between", value1, value2, "otherWage");
			return (Criteria) this;
		}

		public Criteria andDelWageIsNull() {
			addCriterion("DEL_WAGE is null");
			return (Criteria) this;
		}

		public Criteria andDelWageIsNotNull() {
			addCriterion("DEL_WAGE is not null");
			return (Criteria) this;
		}

		public Criteria andDelWageEqualTo(BigDecimal value) {
			addCriterion("DEL_WAGE =", value, "delWage");
			return (Criteria) this;
		}

		public Criteria andDelWageNotEqualTo(BigDecimal value) {
			addCriterion("DEL_WAGE <>", value, "delWage");
			return (Criteria) this;
		}

		public Criteria andDelWageGreaterThan(BigDecimal value) {
			addCriterion("DEL_WAGE >", value, "delWage");
			return (Criteria) this;
		}

		public Criteria andDelWageGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("DEL_WAGE >=", value, "delWage");
			return (Criteria) this;
		}

		public Criteria andDelWageLessThan(BigDecimal value) {
			addCriterion("DEL_WAGE <", value, "delWage");
			return (Criteria) this;
		}

		public Criteria andDelWageLessThanOrEqualTo(BigDecimal value) {
			addCriterion("DEL_WAGE <=", value, "delWage");
			return (Criteria) this;
		}

		public Criteria andDelWageIn(List<BigDecimal> values) {
			addCriterion("DEL_WAGE in", values, "delWage");
			return (Criteria) this;
		}

		public Criteria andDelWageNotIn(List<BigDecimal> values) {
			addCriterion("DEL_WAGE not in", values, "delWage");
			return (Criteria) this;
		}

		public Criteria andDelWageBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("DEL_WAGE between", value1, value2, "delWage");
			return (Criteria) this;
		}

		public Criteria andDelWageNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("DEL_WAGE not between", value1, value2, "delWage");
			return (Criteria) this;
		}

		public Criteria andRealWageIsNull() {
			addCriterion("REAL_WAGE is null");
			return (Criteria) this;
		}

		public Criteria andRealWageIsNotNull() {
			addCriterion("REAL_WAGE is not null");
			return (Criteria) this;
		}

		public Criteria andRealWageEqualTo(BigDecimal value) {
			addCriterion("REAL_WAGE =", value, "realWage");
			return (Criteria) this;
		}

		public Criteria andRealWageNotEqualTo(BigDecimal value) {
			addCriterion("REAL_WAGE <>", value, "realWage");
			return (Criteria) this;
		}

		public Criteria andRealWageGreaterThan(BigDecimal value) {
			addCriterion("REAL_WAGE >", value, "realWage");
			return (Criteria) this;
		}

		public Criteria andRealWageGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("REAL_WAGE >=", value, "realWage");
			return (Criteria) this;
		}

		public Criteria andRealWageLessThan(BigDecimal value) {
			addCriterion("REAL_WAGE <", value, "realWage");
			return (Criteria) this;
		}

		public Criteria andRealWageLessThanOrEqualTo(BigDecimal value) {
			addCriterion("REAL_WAGE <=", value, "realWage");
			return (Criteria) this;
		}

		public Criteria andRealWageIn(List<BigDecimal> values) {
			addCriterion("REAL_WAGE in", values, "realWage");
			return (Criteria) this;
		}

		public Criteria andRealWageNotIn(List<BigDecimal> values) {
			addCriterion("REAL_WAGE not in", values, "realWage");
			return (Criteria) this;
		}

		public Criteria andRealWageBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("REAL_WAGE between", value1, value2, "realWage");
			return (Criteria) this;
		}

		public Criteria andRealWageNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("REAL_WAGE not between", value1, value2, "realWage");
			return (Criteria) this;
		}

		public Criteria andCheckStatusIsNull() {
			addCriterion("CHECK_STATUS is null");
			return (Criteria) this;
		}

		public Criteria andCheckStatusIsNotNull() {
			addCriterion("CHECK_STATUS is not null");
			return (Criteria) this;
		}

		public Criteria andCheckStatusEqualTo(Byte value) {
			addCriterion("CHECK_STATUS =", value, "checkStatus");
			return (Criteria) this;
		}

		public Criteria andCheckStatusNotEqualTo(Byte value) {
			addCriterion("CHECK_STATUS <>", value, "checkStatus");
			return (Criteria) this;
		}

		public Criteria andCheckStatusGreaterThan(Byte value) {
			addCriterion("CHECK_STATUS >", value, "checkStatus");
			return (Criteria) this;
		}

		public Criteria andCheckStatusGreaterThanOrEqualTo(Byte value) {
			addCriterion("CHECK_STATUS >=", value, "checkStatus");
			return (Criteria) this;
		}

		public Criteria andCheckStatusLessThan(Byte value) {
			addCriterion("CHECK_STATUS <", value, "checkStatus");
			return (Criteria) this;
		}

		public Criteria andCheckStatusLessThanOrEqualTo(Byte value) {
			addCriterion("CHECK_STATUS <=", value, "checkStatus");
			return (Criteria) this;
		}

		public Criteria andCheckStatusIn(List<Byte> values) {
			addCriterion("CHECK_STATUS in", values, "checkStatus");
			return (Criteria) this;
		}

		public Criteria andCheckStatusNotIn(List<Byte> values) {
			addCriterion("CHECK_STATUS not in", values, "checkStatus");
			return (Criteria) this;
		}

		public Criteria andCheckStatusBetween(Byte value1, Byte value2) {
			addCriterion("CHECK_STATUS between", value1, value2, "checkStatus");
			return (Criteria) this;
		}

		public Criteria andCheckStatusNotBetween(Byte value1, Byte value2) {
			addCriterion("CHECK_STATUS not between", value1, value2, "checkStatus");
			return (Criteria) this;
		}

		public Criteria andCheckUserIsNull() {
			addCriterion("CHECK_USER is null");
			return (Criteria) this;
		}

		public Criteria andCheckUserIsNotNull() {
			addCriterion("CHECK_USER is not null");
			return (Criteria) this;
		}

		public Criteria andCheckUserEqualTo(Integer value) {
			addCriterion("CHECK_USER =", value, "checkUser");
			return (Criteria) this;
		}

		public Criteria andCheckUserNotEqualTo(Integer value) {
			addCriterion("CHECK_USER <>", value, "checkUser");
			return (Criteria) this;
		}

		public Criteria andCheckUserGreaterThan(Integer value) {
			addCriterion("CHECK_USER >", value, "checkUser");
			return (Criteria) this;
		}

		public Criteria andCheckUserGreaterThanOrEqualTo(Integer value) {
			addCriterion("CHECK_USER >=", value, "checkUser");
			return (Criteria) this;
		}

		public Criteria andCheckUserLessThan(Integer value) {
			addCriterion("CHECK_USER <", value, "checkUser");
			return (Criteria) this;
		}

		public Criteria andCheckUserLessThanOrEqualTo(Integer value) {
			addCriterion("CHECK_USER <=", value, "checkUser");
			return (Criteria) this;
		}

		public Criteria andCheckUserIn(List<Integer> values) {
			addCriterion("CHECK_USER in", values, "checkUser");
			return (Criteria) this;
		}

		public Criteria andCheckUserNotIn(List<Integer> values) {
			addCriterion("CHECK_USER not in", values, "checkUser");
			return (Criteria) this;
		}

		public Criteria andCheckUserBetween(Integer value1, Integer value2) {
			addCriterion("CHECK_USER between", value1, value2, "checkUser");
			return (Criteria) this;
		}

		public Criteria andCheckUserNotBetween(Integer value1, Integer value2) {
			addCriterion("CHECK_USER not between", value1, value2, "checkUser");
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

		public Criteria andCreateDateIsNull() {
			addCriterion("CREATE_DATE is null");
			return (Criteria) this;
		}

		public Criteria andCreateDateIsNotNull() {
			addCriterion("CREATE_DATE is not null");
			return (Criteria) this;
		}

		public Criteria andCreateDateEqualTo(String value) {
			addCriterion("CREATE_DATE =", value, "createDate");
			return (Criteria) this;
		}

		public Criteria andCreateDateNotEqualTo(String value) {
			addCriterion("CREATE_DATE <>", value, "createDate");
			return (Criteria) this;
		}

		public Criteria andCreateDateGreaterThan(String value) {
			addCriterion("CREATE_DATE >", value, "createDate");
			return (Criteria) this;
		}

		public Criteria andCreateDateGreaterThanOrEqualTo(String value) {
			addCriterion("CREATE_DATE >=", value, "createDate");
			return (Criteria) this;
		}

		public Criteria andCreateDateLessThan(String value) {
			addCriterion("CREATE_DATE <", value, "createDate");
			return (Criteria) this;
		}

		public Criteria andCreateDateLessThanOrEqualTo(String value) {
			addCriterion("CREATE_DATE <=", value, "createDate");
			return (Criteria) this;
		}

		public Criteria andCreateDateLike(String value) {
			addCriterion("CREATE_DATE like", value, "createDate");
			return (Criteria) this;
		}

		public Criteria andCreateDateNotLike(String value) {
			addCriterion("CREATE_DATE not like", value, "createDate");
			return (Criteria) this;
		}

		public Criteria andCreateDateIn(List<String> values) {
			addCriterion("CREATE_DATE in", values, "createDate");
			return (Criteria) this;
		}

		public Criteria andCreateDateNotIn(List<String> values) {
			addCriterion("CREATE_DATE not in", values, "createDate");
			return (Criteria) this;
		}

		public Criteria andCreateDateBetween(String value1, String value2) {
			addCriterion("CREATE_DATE between", value1, value2, "createDate");
			return (Criteria) this;
		}

		public Criteria andCreateDateNotBetween(String value1, String value2) {
			addCriterion("CREATE_DATE not between", value1, value2, "createDate");
			return (Criteria) this;
		}

		public Criteria andCheckTimeIsNull() {
			addCriterion("CHECK_TIME is null");
			return (Criteria) this;
		}

		public Criteria andCheckTimeIsNotNull() {
			addCriterion("CHECK_TIME is not null");
			return (Criteria) this;
		}

		public Criteria andCheckTimeEqualTo(Date value) {
			addCriterion("CHECK_TIME =", value, "checkTime");
			return (Criteria) this;
		}

		public Criteria andCheckTimeNotEqualTo(Date value) {
			addCriterion("CHECK_TIME <>", value, "checkTime");
			return (Criteria) this;
		}

		public Criteria andCheckTimeGreaterThan(Date value) {
			addCriterion("CHECK_TIME >", value, "checkTime");
			return (Criteria) this;
		}

		public Criteria andCheckTimeGreaterThanOrEqualTo(Date value) {
			addCriterion("CHECK_TIME >=", value, "checkTime");
			return (Criteria) this;
		}

		public Criteria andCheckTimeLessThan(Date value) {
			addCriterion("CHECK_TIME <", value, "checkTime");
			return (Criteria) this;
		}

		public Criteria andCheckTimeLessThanOrEqualTo(Date value) {
			addCriterion("CHECK_TIME <=", value, "checkTime");
			return (Criteria) this;
		}

		public Criteria andCheckTimeIn(List<Date> values) {
			addCriterion("CHECK_TIME in", values, "checkTime");
			return (Criteria) this;
		}

		public Criteria andCheckTimeNotIn(List<Date> values) {
			addCriterion("CHECK_TIME not in", values, "checkTime");
			return (Criteria) this;
		}

		public Criteria andCheckTimeBetween(Date value1, Date value2) {
			addCriterion("CHECK_TIME between", value1, value2, "checkTime");
			return (Criteria) this;
		}

		public Criteria andCheckTimeNotBetween(Date value1, Date value2) {
			addCriterion("CHECK_TIME not between", value1, value2, "checkTime");
			return (Criteria) this;
		}

		public Criteria andAssessmentMonthIsNull() {
			addCriterion("ASSESSMENT_MONTH is null");
			return (Criteria) this;
		}

		public Criteria andAssessmentMonthIsNotNull() {
			addCriterion("ASSESSMENT_MONTH is not null");
			return (Criteria) this;
		}

		public Criteria andAssessmentMonthEqualTo(String value) {
			addCriterion("ASSESSMENT_MONTH =", value, "assessmentMonth");
			return (Criteria) this;
		}

		public Criteria andAssessmentMonthNotEqualTo(String value) {
			addCriterion("ASSESSMENT_MONTH <>", value, "assessmentMonth");
			return (Criteria) this;
		}

		public Criteria andAssessmentMonthGreaterThan(String value) {
			addCriterion("ASSESSMENT_MONTH >", value, "assessmentMonth");
			return (Criteria) this;
		}

		public Criteria andAssessmentMonthGreaterThanOrEqualTo(String value) {
			addCriterion("ASSESSMENT_MONTH >=", value, "assessmentMonth");
			return (Criteria) this;
		}

		public Criteria andAssessmentMonthLessThan(String value) {
			addCriterion("ASSESSMENT_MONTH <", value, "assessmentMonth");
			return (Criteria) this;
		}

		public Criteria andAssessmentMonthLessThanOrEqualTo(String value) {
			addCriterion("ASSESSMENT_MONTH <=", value, "assessmentMonth");
			return (Criteria) this;
		}

		public Criteria andAssessmentMonthLike(String value) {
			addCriterion("ASSESSMENT_MONTH like", value, "assessmentMonth");
			return (Criteria) this;
		}

		public Criteria andAssessmentMonthNotLike(String value) {
			addCriterion("ASSESSMENT_MONTH not like", value, "assessmentMonth");
			return (Criteria) this;
		}

		public Criteria andAssessmentMonthIn(List<String> values) {
			addCriterion("ASSESSMENT_MONTH in", values, "assessmentMonth");
			return (Criteria) this;
		}

		public Criteria andAssessmentMonthNotIn(List<String> values) {
			addCriterion("ASSESSMENT_MONTH not in", values, "assessmentMonth");
			return (Criteria) this;
		}

		public Criteria andAssessmentMonthBetween(String value1, String value2) {
			addCriterion("ASSESSMENT_MONTH between", value1, value2, "assessmentMonth");
			return (Criteria) this;
		}

		public Criteria andAssessmentMonthNotBetween(String value1, String value2) {
			addCriterion("ASSESSMENT_MONTH not between", value1, value2, "assessmentMonth");
			return (Criteria) this;
		}

		public Criteria andBaseWageGrantStatusIsNull() {
			addCriterion("BASE_WAGE_GRANT_STATUS is null");
			return (Criteria) this;
		}

		public Criteria andBaseWageGrantStatusIsNotNull() {
			addCriterion("BASE_WAGE_GRANT_STATUS is not null");
			return (Criteria) this;
		}

		public Criteria andBaseWageGrantStatusEqualTo(Byte value) {
			addCriterion("BASE_WAGE_GRANT_STATUS =", value, "baseWageGrantStatus");
			return (Criteria) this;
		}

		public Criteria andBaseWageGrantStatusNotEqualTo(Byte value) {
			addCriterion("BASE_WAGE_GRANT_STATUS <>", value, "baseWageGrantStatus");
			return (Criteria) this;
		}

		public Criteria andBaseWageGrantStatusGreaterThan(Byte value) {
			addCriterion("BASE_WAGE_GRANT_STATUS >", value, "baseWageGrantStatus");
			return (Criteria) this;
		}

		public Criteria andBaseWageGrantStatusGreaterThanOrEqualTo(Byte value) {
			addCriterion("BASE_WAGE_GRANT_STATUS >=", value, "baseWageGrantStatus");
			return (Criteria) this;
		}

		public Criteria andBaseWageGrantStatusLessThan(Byte value) {
			addCriterion("BASE_WAGE_GRANT_STATUS <", value, "baseWageGrantStatus");
			return (Criteria) this;
		}

		public Criteria andBaseWageGrantStatusLessThanOrEqualTo(Byte value) {
			addCriterion("BASE_WAGE_GRANT_STATUS <=", value, "baseWageGrantStatus");
			return (Criteria) this;
		}

		public Criteria andBaseWageGrantStatusIn(List<Byte> values) {
			addCriterion("BASE_WAGE_GRANT_STATUS in", values, "baseWageGrantStatus");
			return (Criteria) this;
		}

		public Criteria andBaseWageGrantStatusNotIn(List<Byte> values) {
			addCriterion("BASE_WAGE_GRANT_STATUS not in", values, "baseWageGrantStatus");
			return (Criteria) this;
		}

		public Criteria andBaseWageGrantStatusBetween(Byte value1, Byte value2) {
			addCriterion("BASE_WAGE_GRANT_STATUS between", value1, value2, "baseWageGrantStatus");
			return (Criteria) this;
		}

		public Criteria andBaseWageGrantStatusNotBetween(Byte value1, Byte value2) {
			addCriterion("BASE_WAGE_GRANT_STATUS not between", value1, value2, "baseWageGrantStatus");
			return (Criteria) this;
		}

		public Criteria andCommissionGrantStatusIsNull() {
			addCriterion("COMMISSION_GRANT_STATUS is null");
			return (Criteria) this;
		}

		public Criteria andCommissionGrantStatusIsNotNull() {
			addCriterion("COMMISSION_GRANT_STATUS is not null");
			return (Criteria) this;
		}

		public Criteria andCommissionGrantStatusEqualTo(Byte value) {
			addCriterion("COMMISSION_GRANT_STATUS =", value, "commissionGrantStatus");
			return (Criteria) this;
		}

		public Criteria andCommissionGrantStatusNotEqualTo(Byte value) {
			addCriterion("COMMISSION_GRANT_STATUS <>", value, "commissionGrantStatus");
			return (Criteria) this;
		}

		public Criteria andCommissionGrantStatusGreaterThan(Byte value) {
			addCriterion("COMMISSION_GRANT_STATUS >", value, "commissionGrantStatus");
			return (Criteria) this;
		}

		public Criteria andCommissionGrantStatusGreaterThanOrEqualTo(Byte value) {
			addCriterion("COMMISSION_GRANT_STATUS >=", value, "commissionGrantStatus");
			return (Criteria) this;
		}

		public Criteria andCommissionGrantStatusLessThan(Byte value) {
			addCriterion("COMMISSION_GRANT_STATUS <", value, "commissionGrantStatus");
			return (Criteria) this;
		}

		public Criteria andCommissionGrantStatusLessThanOrEqualTo(Byte value) {
			addCriterion("COMMISSION_GRANT_STATUS <=", value, "commissionGrantStatus");
			return (Criteria) this;
		}

		public Criteria andCommissionGrantStatusIn(List<Byte> values) {
			addCriterion("COMMISSION_GRANT_STATUS in", values, "commissionGrantStatus");
			return (Criteria) this;
		}

		public Criteria andCommissionGrantStatusNotIn(List<Byte> values) {
			addCriterion("COMMISSION_GRANT_STATUS not in", values, "commissionGrantStatus");
			return (Criteria) this;
		}

		public Criteria andCommissionGrantStatusBetween(Byte value1, Byte value2) {
			addCriterion("COMMISSION_GRANT_STATUS between", value1, value2, "commissionGrantStatus");
			return (Criteria) this;
		}

		public Criteria andCommissionGrantStatusNotBetween(Byte value1, Byte value2) {
			addCriterion("COMMISSION_GRANT_STATUS not between", value1, value2, "commissionGrantStatus");
			return (Criteria) this;
		}

		public Criteria andPersonWorkcountAmountIsNull() {
			addCriterion("PERSON_WORKCOUNT_AMOUNT is null");
			return (Criteria) this;
		}

		public Criteria andPersonWorkcountAmountIsNotNull() {
			addCriterion("PERSON_WORKCOUNT_AMOUNT is not null");
			return (Criteria) this;
		}

		public Criteria andPersonWorkcountAmountEqualTo(BigDecimal value) {
			addCriterion("PERSON_WORKCOUNT_AMOUNT =", value, "personWorkcountAmount");
			return (Criteria) this;
		}

		public Criteria andPersonWorkcountAmountNotEqualTo(BigDecimal value) {
			addCriterion("PERSON_WORKCOUNT_AMOUNT <>", value, "personWorkcountAmount");
			return (Criteria) this;
		}

		public Criteria andPersonWorkcountAmountGreaterThan(BigDecimal value) {
			addCriterion("PERSON_WORKCOUNT_AMOUNT >", value, "personWorkcountAmount");
			return (Criteria) this;
		}

		public Criteria andPersonWorkcountAmountGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("PERSON_WORKCOUNT_AMOUNT >=", value, "personWorkcountAmount");
			return (Criteria) this;
		}

		public Criteria andPersonWorkcountAmountLessThan(BigDecimal value) {
			addCriterion("PERSON_WORKCOUNT_AMOUNT <", value, "personWorkcountAmount");
			return (Criteria) this;
		}

		public Criteria andPersonWorkcountAmountLessThanOrEqualTo(BigDecimal value) {
			addCriterion("PERSON_WORKCOUNT_AMOUNT <=", value, "personWorkcountAmount");
			return (Criteria) this;
		}

		public Criteria andPersonWorkcountAmountIn(List<BigDecimal> values) {
			addCriterion("PERSON_WORKCOUNT_AMOUNT in", values, "personWorkcountAmount");
			return (Criteria) this;
		}

		public Criteria andPersonWorkcountAmountNotIn(List<BigDecimal> values) {
			addCriterion("PERSON_WORKCOUNT_AMOUNT not in", values, "personWorkcountAmount");
			return (Criteria) this;
		}

		public Criteria andPersonWorkcountAmountBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("PERSON_WORKCOUNT_AMOUNT between", value1, value2, "personWorkcountAmount");
			return (Criteria) this;
		}

		public Criteria andPersonWorkcountAmountNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("PERSON_WORKCOUNT_AMOUNT not between", value1, value2, "personWorkcountAmount");
			return (Criteria) this;
		}

		public Criteria andManageWorkcountAmountIsNull() {
			addCriterion("MANAGE_WORKCOUNT_AMOUNT is null");
			return (Criteria) this;
		}

		public Criteria andManageWorkcountAmountIsNotNull() {
			addCriterion("MANAGE_WORKCOUNT_AMOUNT is not null");
			return (Criteria) this;
		}

		public Criteria andManageWorkcountAmountEqualTo(BigDecimal value) {
			addCriterion("MANAGE_WORKCOUNT_AMOUNT =", value, "manageWorkcountAmount");
			return (Criteria) this;
		}

		public Criteria andManageWorkcountAmountNotEqualTo(BigDecimal value) {
			addCriterion("MANAGE_WORKCOUNT_AMOUNT <>", value, "manageWorkcountAmount");
			return (Criteria) this;
		}

		public Criteria andManageWorkcountAmountGreaterThan(BigDecimal value) {
			addCriterion("MANAGE_WORKCOUNT_AMOUNT >", value, "manageWorkcountAmount");
			return (Criteria) this;
		}

		public Criteria andManageWorkcountAmountGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("MANAGE_WORKCOUNT_AMOUNT >=", value, "manageWorkcountAmount");
			return (Criteria) this;
		}

		public Criteria andManageWorkcountAmountLessThan(BigDecimal value) {
			addCriterion("MANAGE_WORKCOUNT_AMOUNT <", value, "manageWorkcountAmount");
			return (Criteria) this;
		}

		public Criteria andManageWorkcountAmountLessThanOrEqualTo(BigDecimal value) {
			addCriterion("MANAGE_WORKCOUNT_AMOUNT <=", value, "manageWorkcountAmount");
			return (Criteria) this;
		}

		public Criteria andManageWorkcountAmountIn(List<BigDecimal> values) {
			addCriterion("MANAGE_WORKCOUNT_AMOUNT in", values, "manageWorkcountAmount");
			return (Criteria) this;
		}

		public Criteria andManageWorkcountAmountNotIn(List<BigDecimal> values) {
			addCriterion("MANAGE_WORKCOUNT_AMOUNT not in", values, "manageWorkcountAmount");
			return (Criteria) this;
		}

		public Criteria andManageWorkcountAmountBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("MANAGE_WORKCOUNT_AMOUNT between", value1, value2, "manageWorkcountAmount");
			return (Criteria) this;
		}

		public Criteria andManageWorkcountAmountNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("MANAGE_WORKCOUNT_AMOUNT not between", value1, value2, "manageWorkcountAmount");
			return (Criteria) this;
		}

		public Criteria andManageProfitWageIsNull() {
			addCriterion("MANAGE_PROFIT_WAGE is null");
			return (Criteria) this;
		}

		public Criteria andManageProfitWageIsNotNull() {
			addCriterion("MANAGE_PROFIT_WAGE is not null");
			return (Criteria) this;
		}

		public Criteria andManageProfitWageEqualTo(BigDecimal value) {
			addCriterion("MANAGE_PROFIT_WAGE =", value, "manageProfitWage");
			return (Criteria) this;
		}

		public Criteria andManageProfitWageNotEqualTo(BigDecimal value) {
			addCriterion("MANAGE_PROFIT_WAGE <>", value, "manageProfitWage");
			return (Criteria) this;
		}

		public Criteria andManageProfitWageGreaterThan(BigDecimal value) {
			addCriterion("MANAGE_PROFIT_WAGE >", value, "manageProfitWage");
			return (Criteria) this;
		}

		public Criteria andManageProfitWageGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("MANAGE_PROFIT_WAGE >=", value, "manageProfitWage");
			return (Criteria) this;
		}

		public Criteria andManageProfitWageLessThan(BigDecimal value) {
			addCriterion("MANAGE_PROFIT_WAGE <", value, "manageProfitWage");
			return (Criteria) this;
		}

		public Criteria andManageProfitWageLessThanOrEqualTo(BigDecimal value) {
			addCriterion("MANAGE_PROFIT_WAGE <=", value, "manageProfitWage");
			return (Criteria) this;
		}

		public Criteria andManageProfitWageIn(List<BigDecimal> values) {
			addCriterion("MANAGE_PROFIT_WAGE in", values, "manageProfitWage");
			return (Criteria) this;
		}

		public Criteria andManageProfitWageNotIn(List<BigDecimal> values) {
			addCriterion("MANAGE_PROFIT_WAGE not in", values, "manageProfitWage");
			return (Criteria) this;
		}

		public Criteria andManageProfitWageBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("MANAGE_PROFIT_WAGE between", value1, value2, "manageProfitWage");
			return (Criteria) this;
		}

		public Criteria andManageProfitWageNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("MANAGE_PROFIT_WAGE not between", value1, value2, "manageProfitWage");
			return (Criteria) this;
		}

		public Criteria andPersonProfitWageIsNull() {
			addCriterion("PERSON_PROFIT_WAGE is null");
			return (Criteria) this;
		}

		public Criteria andPersonProfitWageIsNotNull() {
			addCriterion("PERSON_PROFIT_WAGE is not null");
			return (Criteria) this;
		}

		public Criteria andPersonProfitWageEqualTo(BigDecimal value) {
			addCriterion("PERSON_PROFIT_WAGE =", value, "personProfitWage");
			return (Criteria) this;
		}

		public Criteria andPersonProfitWageNotEqualTo(BigDecimal value) {
			addCriterion("PERSON_PROFIT_WAGE <>", value, "personProfitWage");
			return (Criteria) this;
		}

		public Criteria andPersonProfitWageGreaterThan(BigDecimal value) {
			addCriterion("PERSON_PROFIT_WAGE >", value, "personProfitWage");
			return (Criteria) this;
		}

		public Criteria andPersonProfitWageGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("PERSON_PROFIT_WAGE >=", value, "personProfitWage");
			return (Criteria) this;
		}

		public Criteria andPersonProfitWageLessThan(BigDecimal value) {
			addCriterion("PERSON_PROFIT_WAGE <", value, "personProfitWage");
			return (Criteria) this;
		}

		public Criteria andPersonProfitWageLessThanOrEqualTo(BigDecimal value) {
			addCriterion("PERSON_PROFIT_WAGE <=", value, "personProfitWage");
			return (Criteria) this;
		}

		public Criteria andPersonProfitWageIn(List<BigDecimal> values) {
			addCriterion("PERSON_PROFIT_WAGE in", values, "personProfitWage");
			return (Criteria) this;
		}

		public Criteria andPersonProfitWageNotIn(List<BigDecimal> values) {
			addCriterion("PERSON_PROFIT_WAGE not in", values, "personProfitWage");
			return (Criteria) this;
		}

		public Criteria andPersonProfitWageBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("PERSON_PROFIT_WAGE between", value1, value2, "personProfitWage");
			return (Criteria) this;
		}

		public Criteria andPersonProfitWageNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("PERSON_PROFIT_WAGE not between", value1, value2, "personProfitWage");
			return (Criteria) this;
		}

		public Criteria andPaidWageAmountIsNull() {
			addCriterion("PAID_WAGE_AMOUNT is null");
			return (Criteria) this;
		}

		public Criteria andPaidWageAmountIsNotNull() {
			addCriterion("PAID_WAGE_AMOUNT is not null");
			return (Criteria) this;
		}

		public Criteria andPaidWageAmountEqualTo(BigDecimal value) {
			addCriterion("PAID_WAGE_AMOUNT =", value, "paidWageAmount");
			return (Criteria) this;
		}

		public Criteria andPaidWageAmountNotEqualTo(BigDecimal value) {
			addCriterion("PAID_WAGE_AMOUNT <>", value, "paidWageAmount");
			return (Criteria) this;
		}

		public Criteria andPaidWageAmountGreaterThan(BigDecimal value) {
			addCriterion("PAID_WAGE_AMOUNT >", value, "paidWageAmount");
			return (Criteria) this;
		}

		public Criteria andPaidWageAmountGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("PAID_WAGE_AMOUNT >=", value, "paidWageAmount");
			return (Criteria) this;
		}

		public Criteria andPaidWageAmountLessThan(BigDecimal value) {
			addCriterion("PAID_WAGE_AMOUNT <", value, "paidWageAmount");
			return (Criteria) this;
		}

		public Criteria andPaidWageAmountLessThanOrEqualTo(BigDecimal value) {
			addCriterion("PAID_WAGE_AMOUNT <=", value, "paidWageAmount");
			return (Criteria) this;
		}

		public Criteria andPaidWageAmountIn(List<BigDecimal> values) {
			addCriterion("PAID_WAGE_AMOUNT in", values, "paidWageAmount");
			return (Criteria) this;
		}

		public Criteria andPaidWageAmountNotIn(List<BigDecimal> values) {
			addCriterion("PAID_WAGE_AMOUNT not in", values, "paidWageAmount");
			return (Criteria) this;
		}

		public Criteria andPaidWageAmountBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("PAID_WAGE_AMOUNT between", value1, value2, "paidWageAmount");
			return (Criteria) this;
		}

		public Criteria andPaidWageAmountNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("PAID_WAGE_AMOUNT not between", value1, value2, "paidWageAmount");
			return (Criteria) this;
		}

		public Criteria andPersonCommsionAmountIsNull() {
			addCriterion("PERSON_COMMSION_AMOUNT is null");
			return (Criteria) this;
		}

		public Criteria andPersonCommsionAmountIsNotNull() {
			addCriterion("PERSON_COMMSION_AMOUNT is not null");
			return (Criteria) this;
		}

		public Criteria andPersonCommsionAmountEqualTo(BigDecimal value) {
			addCriterion("PERSON_COMMSION_AMOUNT =", value, "personCommsionAmount");
			return (Criteria) this;
		}

		public Criteria andPersonCommsionAmountNotEqualTo(BigDecimal value) {
			addCriterion("PERSON_COMMSION_AMOUNT <>", value, "personCommsionAmount");
			return (Criteria) this;
		}

		public Criteria andPersonCommsionAmountGreaterThan(BigDecimal value) {
			addCriterion("PERSON_COMMSION_AMOUNT >", value, "personCommsionAmount");
			return (Criteria) this;
		}

		public Criteria andPersonCommsionAmountGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("PERSON_COMMSION_AMOUNT >=", value, "personCommsionAmount");
			return (Criteria) this;
		}

		public Criteria andPersonCommsionAmountLessThan(BigDecimal value) {
			addCriterion("PERSON_COMMSION_AMOUNT <", value, "personCommsionAmount");
			return (Criteria) this;
		}

		public Criteria andPersonCommsionAmountLessThanOrEqualTo(BigDecimal value) {
			addCriterion("PERSON_COMMSION_AMOUNT <=", value, "personCommsionAmount");
			return (Criteria) this;
		}

		public Criteria andPersonCommsionAmountIn(List<BigDecimal> values) {
			addCriterion("PERSON_COMMSION_AMOUNT in", values, "personCommsionAmount");
			return (Criteria) this;
		}

		public Criteria andPersonCommsionAmountNotIn(List<BigDecimal> values) {
			addCriterion("PERSON_COMMSION_AMOUNT not in", values, "personCommsionAmount");
			return (Criteria) this;
		}

		public Criteria andPersonCommsionAmountBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("PERSON_COMMSION_AMOUNT between", value1, value2, "personCommsionAmount");
			return (Criteria) this;
		}

		public Criteria andPersonCommsionAmountNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("PERSON_COMMSION_AMOUNT not between", value1, value2, "personCommsionAmount");
			return (Criteria) this;
		}

		public Criteria andManageCommsionAmountIsNull() {
			addCriterion("MANAGE_COMMSION_AMOUNT is null");
			return (Criteria) this;
		}

		public Criteria andManageCommsionAmountIsNotNull() {
			addCriterion("MANAGE_COMMSION_AMOUNT is not null");
			return (Criteria) this;
		}

		public Criteria andManageCommsionAmountEqualTo(BigDecimal value) {
			addCriterion("MANAGE_COMMSION_AMOUNT =", value, "manageCommsionAmount");
			return (Criteria) this;
		}

		public Criteria andManageCommsionAmountNotEqualTo(BigDecimal value) {
			addCriterion("MANAGE_COMMSION_AMOUNT <>", value, "manageCommsionAmount");
			return (Criteria) this;
		}

		public Criteria andManageCommsionAmountGreaterThan(BigDecimal value) {
			addCriterion("MANAGE_COMMSION_AMOUNT >", value, "manageCommsionAmount");
			return (Criteria) this;
		}

		public Criteria andManageCommsionAmountGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("MANAGE_COMMSION_AMOUNT >=", value, "manageCommsionAmount");
			return (Criteria) this;
		}

		public Criteria andManageCommsionAmountLessThan(BigDecimal value) {
			addCriterion("MANAGE_COMMSION_AMOUNT <", value, "manageCommsionAmount");
			return (Criteria) this;
		}

		public Criteria andManageCommsionAmountLessThanOrEqualTo(BigDecimal value) {
			addCriterion("MANAGE_COMMSION_AMOUNT <=", value, "manageCommsionAmount");
			return (Criteria) this;
		}

		public Criteria andManageCommsionAmountIn(List<BigDecimal> values) {
			addCriterion("MANAGE_COMMSION_AMOUNT in", values, "manageCommsionAmount");
			return (Criteria) this;
		}

		public Criteria andManageCommsionAmountNotIn(List<BigDecimal> values) {
			addCriterion("MANAGE_COMMSION_AMOUNT not in", values, "manageCommsionAmount");
			return (Criteria) this;
		}

		public Criteria andManageCommsionAmountBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("MANAGE_COMMSION_AMOUNT between", value1, value2, "manageCommsionAmount");
			return (Criteria) this;
		}

		public Criteria andManageCommsionAmountNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("MANAGE_COMMSION_AMOUNT not between", value1, value2, "manageCommsionAmount");
			return (Criteria) this;
		}

		public Criteria andRealWageCkIsNull() {
			addCriterion("REAL_WAGE_CK is null");
			return (Criteria) this;
		}

		public Criteria andRealWageCkIsNotNull() {
			addCriterion("REAL_WAGE_CK is not null");
			return (Criteria) this;
		}

		public Criteria andRealWageCkEqualTo(BigDecimal value) {
			addCriterion("REAL_WAGE_CK =", value, "realWageCk");
			return (Criteria) this;
		}

		public Criteria andRealWageCkNotEqualTo(BigDecimal value) {
			addCriterion("REAL_WAGE_CK <>", value, "realWageCk");
			return (Criteria) this;
		}

		public Criteria andRealWageCkGreaterThan(BigDecimal value) {
			addCriterion("REAL_WAGE_CK >", value, "realWageCk");
			return (Criteria) this;
		}

		public Criteria andRealWageCkGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("REAL_WAGE_CK >=", value, "realWageCk");
			return (Criteria) this;
		}

		public Criteria andRealWageCkLessThan(BigDecimal value) {
			addCriterion("REAL_WAGE_CK <", value, "realWageCk");
			return (Criteria) this;
		}

		public Criteria andRealWageCkLessThanOrEqualTo(BigDecimal value) {
			addCriterion("REAL_WAGE_CK <=", value, "realWageCk");
			return (Criteria) this;
		}

		public Criteria andRealWageCkIn(List<BigDecimal> values) {
			addCriterion("REAL_WAGE_CK in", values, "realWageCk");
			return (Criteria) this;
		}

		public Criteria andRealWageCkNotIn(List<BigDecimal> values) {
			addCriterion("REAL_WAGE_CK not in", values, "realWageCk");
			return (Criteria) this;
		}

		public Criteria andRealWageCkBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("REAL_WAGE_CK between", value1, value2, "realWageCk");
			return (Criteria) this;
		}

		public Criteria andRealWageCkNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("REAL_WAGE_CK not between", value1, value2, "realWageCk");
			return (Criteria) this;
		}

		public Criteria andExplainIsNull() {
			addCriterion("[EXPLAIN] is null");
			return (Criteria) this;
		}

		public Criteria andExplainIsNotNull() {
			addCriterion("[EXPLAIN] is not null");
			return (Criteria) this;
		}

		public Criteria andExplainEqualTo(String value) {
			addCriterion("[EXPLAIN] =", value, "explain");
			return (Criteria) this;
		}

		public Criteria andExplainNotEqualTo(String value) {
			addCriterion("[EXPLAIN] <>", value, "explain");
			return (Criteria) this;
		}

		public Criteria andExplainGreaterThan(String value) {
			addCriterion("[EXPLAIN] >", value, "explain");
			return (Criteria) this;
		}

		public Criteria andExplainGreaterThanOrEqualTo(String value) {
			addCriterion("[EXPLAIN] >=", value, "explain");
			return (Criteria) this;
		}

		public Criteria andExplainLessThan(String value) {
			addCriterion("[EXPLAIN] <", value, "explain");
			return (Criteria) this;
		}

		public Criteria andExplainLessThanOrEqualTo(String value) {
			addCriterion("[EXPLAIN] <=", value, "explain");
			return (Criteria) this;
		}

		public Criteria andExplainLike(String value) {
			addCriterion("[EXPLAIN] like", value, "explain");
			return (Criteria) this;
		}

		public Criteria andExplainNotLike(String value) {
			addCriterion("[EXPLAIN] not like", value, "explain");
			return (Criteria) this;
		}

		public Criteria andExplainIn(List<String> values) {
			addCriterion("[EXPLAIN] in", values, "explain");
			return (Criteria) this;
		}

		public Criteria andExplainNotIn(List<String> values) {
			addCriterion("[EXPLAIN] not in", values, "explain");
			return (Criteria) this;
		}

		public Criteria andExplainBetween(String value1, String value2) {
			addCriterion("[EXPLAIN] between", value1, value2, "explain");
			return (Criteria) this;
		}

		public Criteria andExplainNotBetween(String value1, String value2) {
			addCriterion("[EXPLAIN] not between", value1, value2, "explain");
			return (Criteria) this;
		}

		public Criteria andAdjustWageIsNull() {
			addCriterion("ADJUST_WAGE is null");
			return (Criteria) this;
		}

		public Criteria andAdjustWageIsNotNull() {
			addCriterion("ADJUST_WAGE is not null");
			return (Criteria) this;
		}

		public Criteria andAdjustWageEqualTo(BigDecimal value) {
			addCriterion("ADJUST_WAGE =", value, "adjustWage");
			return (Criteria) this;
		}

		public Criteria andAdjustWageNotEqualTo(BigDecimal value) {
			addCriterion("ADJUST_WAGE <>", value, "adjustWage");
			return (Criteria) this;
		}

		public Criteria andAdjustWageGreaterThan(BigDecimal value) {
			addCriterion("ADJUST_WAGE >", value, "adjustWage");
			return (Criteria) this;
		}

		public Criteria andAdjustWageGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("ADJUST_WAGE >=", value, "adjustWage");
			return (Criteria) this;
		}

		public Criteria andAdjustWageLessThan(BigDecimal value) {
			addCriterion("ADJUST_WAGE <", value, "adjustWage");
			return (Criteria) this;
		}

		public Criteria andAdjustWageLessThanOrEqualTo(BigDecimal value) {
			addCriterion("ADJUST_WAGE <=", value, "adjustWage");
			return (Criteria) this;
		}

		public Criteria andAdjustWageIn(List<BigDecimal> values) {
			addCriterion("ADJUST_WAGE in", values, "adjustWage");
			return (Criteria) this;
		}

		public Criteria andAdjustWageNotIn(List<BigDecimal> values) {
			addCriterion("ADJUST_WAGE not in", values, "adjustWage");
			return (Criteria) this;
		}

		public Criteria andAdjustWageBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("ADJUST_WAGE between", value1, value2, "adjustWage");
			return (Criteria) this;
		}

		public Criteria andAdjustWageNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("ADJUST_WAGE not between", value1, value2, "adjustWage");
			return (Criteria) this;
		}

		public Criteria andEffectiveStatusIsNull() {
			addCriterion("EFFECTIVE_STATUS is null");
			return (Criteria) this;
		}

		public Criteria andEffectiveStatusIsNotNull() {
			addCriterion("EFFECTIVE_STATUS is not null");
			return (Criteria) this;
		}

		public Criteria andEffectiveStatusEqualTo(Byte value) {
			addCriterion("EFFECTIVE_STATUS =", value, "effectiveStatus");
			return (Criteria) this;
		}

		public Criteria andEffectiveStatusNotEqualTo(Byte value) {
			addCriterion("EFFECTIVE_STATUS <>", value, "effectiveStatus");
			return (Criteria) this;
		}

		public Criteria andEffectiveStatusGreaterThan(Byte value) {
			addCriterion("EFFECTIVE_STATUS >", value, "effectiveStatus");
			return (Criteria) this;
		}

		public Criteria andEffectiveStatusGreaterThanOrEqualTo(Byte value) {
			addCriterion("EFFECTIVE_STATUS >=", value, "effectiveStatus");
			return (Criteria) this;
		}

		public Criteria andEffectiveStatusLessThan(Byte value) {
			addCriterion("EFFECTIVE_STATUS <", value, "effectiveStatus");
			return (Criteria) this;
		}

		public Criteria andEffectiveStatusLessThanOrEqualTo(Byte value) {
			addCriterion("EFFECTIVE_STATUS <=", value, "effectiveStatus");
			return (Criteria) this;
		}

		public Criteria andEffectiveStatusIn(List<Byte> values) {
			addCriterion("EFFECTIVE_STATUS in", values, "effectiveStatus");
			return (Criteria) this;
		}

		public Criteria andEffectiveStatusNotIn(List<Byte> values) {
			addCriterion("EFFECTIVE_STATUS not in", values, "effectiveStatus");
			return (Criteria) this;
		}

		public Criteria andEffectiveStatusBetween(Byte value1, Byte value2) {
			addCriterion("EFFECTIVE_STATUS between", value1, value2, "effectiveStatus");
			return (Criteria) this;
		}

		public Criteria andEffectiveStatusNotBetween(Byte value1, Byte value2) {
			addCriterion("EFFECTIVE_STATUS not between", value1, value2, "effectiveStatus");
			return (Criteria) this;
		}

		public Criteria andOrganizationPathIsNull() {
			addCriterion("ORGANIZATION_PATH is null");
			return (Criteria) this;
		}

		public Criteria andOrganizationPathIsNotNull() {
			addCriterion("ORGANIZATION_PATH is not null");
			return (Criteria) this;
		}

		public Criteria andOrganizationPathEqualTo(String value) {
			addCriterion("ORGANIZATION_PATH =", value, "organizationPath");
			return (Criteria) this;
		}

		public Criteria andOrganizationPathNotEqualTo(String value) {
			addCriterion("ORGANIZATION_PATH <>", value, "organizationPath");
			return (Criteria) this;
		}

		public Criteria andOrganizationPathGreaterThan(String value) {
			addCriterion("ORGANIZATION_PATH >", value, "organizationPath");
			return (Criteria) this;
		}

		public Criteria andOrganizationPathGreaterThanOrEqualTo(String value) {
			addCriterion("ORGANIZATION_PATH >=", value, "organizationPath");
			return (Criteria) this;
		}

		public Criteria andOrganizationPathLessThan(String value) {
			addCriterion("ORGANIZATION_PATH <", value, "organizationPath");
			return (Criteria) this;
		}

		public Criteria andOrganizationPathLessThanOrEqualTo(String value) {
			addCriterion("ORGANIZATION_PATH <=", value, "organizationPath");
			return (Criteria) this;
		}

		public Criteria andOrganizationPathLike(String value) {
			addCriterion("ORGANIZATION_PATH like", value, "organizationPath");
			return (Criteria) this;
		}

		public Criteria andOrganizationPathNotLike(String value) {
			addCriterion("ORGANIZATION_PATH not like", value, "organizationPath");
			return (Criteria) this;
		}

		public Criteria andOrganizationPathIn(List<String> values) {
			addCriterion("ORGANIZATION_PATH in", values, "organizationPath");
			return (Criteria) this;
		}

		public Criteria andOrganizationPathNotIn(List<String> values) {
			addCriterion("ORGANIZATION_PATH not in", values, "organizationPath");
			return (Criteria) this;
		}

		public Criteria andOrganizationPathBetween(String value1, String value2) {
			addCriterion("ORGANIZATION_PATH between", value1, value2, "organizationPath");
			return (Criteria) this;
		}

		public Criteria andOrganizationPathNotBetween(String value1, String value2) {
			addCriterion("ORGANIZATION_PATH not between", value1, value2, "organizationPath");
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