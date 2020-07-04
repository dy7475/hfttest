package com.myfun.repository.erpdb.po;

import com.myfun.repository.support.generator.shard.ShardDb;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.math.BigDecimal;

public class ErpPosPaymentOrderExample extends ShardDb {
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
	public ErpPosPaymentOrderExample() {
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

		public Criteria andFinanceTypeIsNull() {
			addCriterion("FINANCE_TYPE is null");
			return (Criteria) this;
		}

		public Criteria andFinanceTypeIsNotNull() {
			addCriterion("FINANCE_TYPE is not null");
			return (Criteria) this;
		}

		public Criteria andFinanceTypeEqualTo(Byte value) {
			addCriterion("FINANCE_TYPE =", value, "financeType");
			return (Criteria) this;
		}

		public Criteria andFinanceTypeNotEqualTo(Byte value) {
			addCriterion("FINANCE_TYPE <>", value, "financeType");
			return (Criteria) this;
		}

		public Criteria andFinanceTypeGreaterThan(Byte value) {
			addCriterion("FINANCE_TYPE >", value, "financeType");
			return (Criteria) this;
		}

		public Criteria andFinanceTypeGreaterThanOrEqualTo(Byte value) {
			addCriterion("FINANCE_TYPE >=", value, "financeType");
			return (Criteria) this;
		}

		public Criteria andFinanceTypeLessThan(Byte value) {
			addCriterion("FINANCE_TYPE <", value, "financeType");
			return (Criteria) this;
		}

		public Criteria andFinanceTypeLessThanOrEqualTo(Byte value) {
			addCriterion("FINANCE_TYPE <=", value, "financeType");
			return (Criteria) this;
		}

		public Criteria andFinanceTypeIn(List<Byte> values) {
			addCriterion("FINANCE_TYPE in", values, "financeType");
			return (Criteria) this;
		}

		public Criteria andFinanceTypeNotIn(List<Byte> values) {
			addCriterion("FINANCE_TYPE not in", values, "financeType");
			return (Criteria) this;
		}

		public Criteria andFinanceTypeBetween(Byte value1, Byte value2) {
			addCriterion("FINANCE_TYPE between", value1, value2, "financeType");
			return (Criteria) this;
		}

		public Criteria andFinanceTypeNotBetween(Byte value1, Byte value2) {
			addCriterion("FINANCE_TYPE not between", value1, value2, "financeType");
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

		public Criteria andFinanceIdIsNull() {
			addCriterion("FINANCE_ID is null");
			return (Criteria) this;
		}

		public Criteria andFinanceIdIsNotNull() {
			addCriterion("FINANCE_ID is not null");
			return (Criteria) this;
		}

		public Criteria andFinanceIdEqualTo(Integer value) {
			addCriterion("FINANCE_ID =", value, "financeId");
			return (Criteria) this;
		}

		public Criteria andFinanceIdNotEqualTo(Integer value) {
			addCriterion("FINANCE_ID <>", value, "financeId");
			return (Criteria) this;
		}

		public Criteria andFinanceIdGreaterThan(Integer value) {
			addCriterion("FINANCE_ID >", value, "financeId");
			return (Criteria) this;
		}

		public Criteria andFinanceIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("FINANCE_ID >=", value, "financeId");
			return (Criteria) this;
		}

		public Criteria andFinanceIdLessThan(Integer value) {
			addCriterion("FINANCE_ID <", value, "financeId");
			return (Criteria) this;
		}

		public Criteria andFinanceIdLessThanOrEqualTo(Integer value) {
			addCriterion("FINANCE_ID <=", value, "financeId");
			return (Criteria) this;
		}

		public Criteria andFinanceIdIn(List<Integer> values) {
			addCriterion("FINANCE_ID in", values, "financeId");
			return (Criteria) this;
		}

		public Criteria andFinanceIdNotIn(List<Integer> values) {
			addCriterion("FINANCE_ID not in", values, "financeId");
			return (Criteria) this;
		}

		public Criteria andFinanceIdBetween(Integer value1, Integer value2) {
			addCriterion("FINANCE_ID between", value1, value2, "financeId");
			return (Criteria) this;
		}

		public Criteria andFinanceIdNotBetween(Integer value1, Integer value2) {
			addCriterion("FINANCE_ID not between", value1, value2, "financeId");
			return (Criteria) this;
		}

		public Criteria andOrderNoIsNull() {
			addCriterion("ORDER_NO is null");
			return (Criteria) this;
		}

		public Criteria andOrderNoIsNotNull() {
			addCriterion("ORDER_NO is not null");
			return (Criteria) this;
		}

		public Criteria andOrderNoEqualTo(String value) {
			addCriterion("ORDER_NO =", value, "orderNo");
			return (Criteria) this;
		}

		public Criteria andOrderNoNotEqualTo(String value) {
			addCriterion("ORDER_NO <>", value, "orderNo");
			return (Criteria) this;
		}

		public Criteria andOrderNoGreaterThan(String value) {
			addCriterion("ORDER_NO >", value, "orderNo");
			return (Criteria) this;
		}

		public Criteria andOrderNoGreaterThanOrEqualTo(String value) {
			addCriterion("ORDER_NO >=", value, "orderNo");
			return (Criteria) this;
		}

		public Criteria andOrderNoLessThan(String value) {
			addCriterion("ORDER_NO <", value, "orderNo");
			return (Criteria) this;
		}

		public Criteria andOrderNoLessThanOrEqualTo(String value) {
			addCriterion("ORDER_NO <=", value, "orderNo");
			return (Criteria) this;
		}

		public Criteria andOrderNoLike(String value) {
			addCriterion("ORDER_NO like", value, "orderNo");
			return (Criteria) this;
		}

		public Criteria andOrderNoNotLike(String value) {
			addCriterion("ORDER_NO not like", value, "orderNo");
			return (Criteria) this;
		}

		public Criteria andOrderNoIn(List<String> values) {
			addCriterion("ORDER_NO in", values, "orderNo");
			return (Criteria) this;
		}

		public Criteria andOrderNoNotIn(List<String> values) {
			addCriterion("ORDER_NO not in", values, "orderNo");
			return (Criteria) this;
		}

		public Criteria andOrderNoBetween(String value1, String value2) {
			addCriterion("ORDER_NO between", value1, value2, "orderNo");
			return (Criteria) this;
		}

		public Criteria andOrderNoNotBetween(String value1, String value2) {
			addCriterion("ORDER_NO not between", value1, value2, "orderNo");
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

		public Criteria andPaymentTimeIsNull() {
			addCriterion("PAYMENT_TIME is null");
			return (Criteria) this;
		}

		public Criteria andPaymentTimeIsNotNull() {
			addCriterion("PAYMENT_TIME is not null");
			return (Criteria) this;
		}

		public Criteria andPaymentTimeEqualTo(Date value) {
			addCriterion("PAYMENT_TIME =", value, "paymentTime");
			return (Criteria) this;
		}

		public Criteria andPaymentTimeNotEqualTo(Date value) {
			addCriterion("PAYMENT_TIME <>", value, "paymentTime");
			return (Criteria) this;
		}

		public Criteria andPaymentTimeGreaterThan(Date value) {
			addCriterion("PAYMENT_TIME >", value, "paymentTime");
			return (Criteria) this;
		}

		public Criteria andPaymentTimeGreaterThanOrEqualTo(Date value) {
			addCriterion("PAYMENT_TIME >=", value, "paymentTime");
			return (Criteria) this;
		}

		public Criteria andPaymentTimeLessThan(Date value) {
			addCriterion("PAYMENT_TIME <", value, "paymentTime");
			return (Criteria) this;
		}

		public Criteria andPaymentTimeLessThanOrEqualTo(Date value) {
			addCriterion("PAYMENT_TIME <=", value, "paymentTime");
			return (Criteria) this;
		}

		public Criteria andPaymentTimeIn(List<Date> values) {
			addCriterion("PAYMENT_TIME in", values, "paymentTime");
			return (Criteria) this;
		}

		public Criteria andPaymentTimeNotIn(List<Date> values) {
			addCriterion("PAYMENT_TIME not in", values, "paymentTime");
			return (Criteria) this;
		}

		public Criteria andPaymentTimeBetween(Date value1, Date value2) {
			addCriterion("PAYMENT_TIME between", value1, value2, "paymentTime");
			return (Criteria) this;
		}

		public Criteria andPaymentTimeNotBetween(Date value1, Date value2) {
			addCriterion("PAYMENT_TIME not between", value1, value2, "paymentTime");
			return (Criteria) this;
		}

		public Criteria andPayStatusIsNull() {
			addCriterion("PAY_STATUS is null");
			return (Criteria) this;
		}

		public Criteria andPayStatusIsNotNull() {
			addCriterion("PAY_STATUS is not null");
			return (Criteria) this;
		}

		public Criteria andPayStatusEqualTo(Byte value) {
			addCriterion("PAY_STATUS =", value, "payStatus");
			return (Criteria) this;
		}

		public Criteria andPayStatusNotEqualTo(Byte value) {
			addCriterion("PAY_STATUS <>", value, "payStatus");
			return (Criteria) this;
		}

		public Criteria andPayStatusGreaterThan(Byte value) {
			addCriterion("PAY_STATUS >", value, "payStatus");
			return (Criteria) this;
		}

		public Criteria andPayStatusGreaterThanOrEqualTo(Byte value) {
			addCriterion("PAY_STATUS >=", value, "payStatus");
			return (Criteria) this;
		}

		public Criteria andPayStatusLessThan(Byte value) {
			addCriterion("PAY_STATUS <", value, "payStatus");
			return (Criteria) this;
		}

		public Criteria andPayStatusLessThanOrEqualTo(Byte value) {
			addCriterion("PAY_STATUS <=", value, "payStatus");
			return (Criteria) this;
		}

		public Criteria andPayStatusIn(List<Byte> values) {
			addCriterion("PAY_STATUS in", values, "payStatus");
			return (Criteria) this;
		}

		public Criteria andPayStatusNotIn(List<Byte> values) {
			addCriterion("PAY_STATUS not in", values, "payStatus");
			return (Criteria) this;
		}

		public Criteria andPayStatusBetween(Byte value1, Byte value2) {
			addCriterion("PAY_STATUS between", value1, value2, "payStatus");
			return (Criteria) this;
		}

		public Criteria andPayStatusNotBetween(Byte value1, Byte value2) {
			addCriterion("PAY_STATUS not between", value1, value2, "payStatus");
			return (Criteria) this;
		}

		public Criteria andCaseTypeIsNull() {
			addCriterion("CASE_TYPE is null");
			return (Criteria) this;
		}

		public Criteria andCaseTypeIsNotNull() {
			addCriterion("CASE_TYPE is not null");
			return (Criteria) this;
		}

		public Criteria andCaseTypeEqualTo(Integer value) {
			addCriterion("CASE_TYPE =", value, "caseType");
			return (Criteria) this;
		}

		public Criteria andCaseTypeNotEqualTo(Integer value) {
			addCriterion("CASE_TYPE <>", value, "caseType");
			return (Criteria) this;
		}

		public Criteria andCaseTypeGreaterThan(Integer value) {
			addCriterion("CASE_TYPE >", value, "caseType");
			return (Criteria) this;
		}

		public Criteria andCaseTypeGreaterThanOrEqualTo(Integer value) {
			addCriterion("CASE_TYPE >=", value, "caseType");
			return (Criteria) this;
		}

		public Criteria andCaseTypeLessThan(Integer value) {
			addCriterion("CASE_TYPE <", value, "caseType");
			return (Criteria) this;
		}

		public Criteria andCaseTypeLessThanOrEqualTo(Integer value) {
			addCriterion("CASE_TYPE <=", value, "caseType");
			return (Criteria) this;
		}

		public Criteria andCaseTypeIn(List<Integer> values) {
			addCriterion("CASE_TYPE in", values, "caseType");
			return (Criteria) this;
		}

		public Criteria andCaseTypeNotIn(List<Integer> values) {
			addCriterion("CASE_TYPE not in", values, "caseType");
			return (Criteria) this;
		}

		public Criteria andCaseTypeBetween(Integer value1, Integer value2) {
			addCriterion("CASE_TYPE between", value1, value2, "caseType");
			return (Criteria) this;
		}

		public Criteria andCaseTypeNotBetween(Integer value1, Integer value2) {
			addCriterion("CASE_TYPE not between", value1, value2, "caseType");
			return (Criteria) this;
		}

		public Criteria andDealIdIsNull() {
			addCriterion("DEAL_ID is null");
			return (Criteria) this;
		}

		public Criteria andDealIdIsNotNull() {
			addCriterion("DEAL_ID is not null");
			return (Criteria) this;
		}

		public Criteria andDealIdEqualTo(Integer value) {
			addCriterion("DEAL_ID =", value, "dealId");
			return (Criteria) this;
		}

		public Criteria andDealIdNotEqualTo(Integer value) {
			addCriterion("DEAL_ID <>", value, "dealId");
			return (Criteria) this;
		}

		public Criteria andDealIdGreaterThan(Integer value) {
			addCriterion("DEAL_ID >", value, "dealId");
			return (Criteria) this;
		}

		public Criteria andDealIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("DEAL_ID >=", value, "dealId");
			return (Criteria) this;
		}

		public Criteria andDealIdLessThan(Integer value) {
			addCriterion("DEAL_ID <", value, "dealId");
			return (Criteria) this;
		}

		public Criteria andDealIdLessThanOrEqualTo(Integer value) {
			addCriterion("DEAL_ID <=", value, "dealId");
			return (Criteria) this;
		}

		public Criteria andDealIdIn(List<Integer> values) {
			addCriterion("DEAL_ID in", values, "dealId");
			return (Criteria) this;
		}

		public Criteria andDealIdNotIn(List<Integer> values) {
			addCriterion("DEAL_ID not in", values, "dealId");
			return (Criteria) this;
		}

		public Criteria andDealIdBetween(Integer value1, Integer value2) {
			addCriterion("DEAL_ID between", value1, value2, "dealId");
			return (Criteria) this;
		}

		public Criteria andDealIdNotBetween(Integer value1, Integer value2) {
			addCriterion("DEAL_ID not between", value1, value2, "dealId");
			return (Criteria) this;
		}

		public Criteria andFinanceMoneyIsNull() {
			addCriterion("FINANCE_MONEY is null");
			return (Criteria) this;
		}

		public Criteria andFinanceMoneyIsNotNull() {
			addCriterion("FINANCE_MONEY is not null");
			return (Criteria) this;
		}

		public Criteria andFinanceMoneyEqualTo(BigDecimal value) {
			addCriterion("FINANCE_MONEY =", value, "financeMoney");
			return (Criteria) this;
		}

		public Criteria andFinanceMoneyNotEqualTo(BigDecimal value) {
			addCriterion("FINANCE_MONEY <>", value, "financeMoney");
			return (Criteria) this;
		}

		public Criteria andFinanceMoneyGreaterThan(BigDecimal value) {
			addCriterion("FINANCE_MONEY >", value, "financeMoney");
			return (Criteria) this;
		}

		public Criteria andFinanceMoneyGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("FINANCE_MONEY >=", value, "financeMoney");
			return (Criteria) this;
		}

		public Criteria andFinanceMoneyLessThan(BigDecimal value) {
			addCriterion("FINANCE_MONEY <", value, "financeMoney");
			return (Criteria) this;
		}

		public Criteria andFinanceMoneyLessThanOrEqualTo(BigDecimal value) {
			addCriterion("FINANCE_MONEY <=", value, "financeMoney");
			return (Criteria) this;
		}

		public Criteria andFinanceMoneyIn(List<BigDecimal> values) {
			addCriterion("FINANCE_MONEY in", values, "financeMoney");
			return (Criteria) this;
		}

		public Criteria andFinanceMoneyNotIn(List<BigDecimal> values) {
			addCriterion("FINANCE_MONEY not in", values, "financeMoney");
			return (Criteria) this;
		}

		public Criteria andFinanceMoneyBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("FINANCE_MONEY between", value1, value2, "financeMoney");
			return (Criteria) this;
		}

		public Criteria andFinanceMoneyNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("FINANCE_MONEY not between", value1, value2, "financeMoney");
			return (Criteria) this;
		}

		public Criteria andFinanceNameIsNull() {
			addCriterion("FINANCE_NAME is null");
			return (Criteria) this;
		}

		public Criteria andFinanceNameIsNotNull() {
			addCriterion("FINANCE_NAME is not null");
			return (Criteria) this;
		}

		public Criteria andFinanceNameEqualTo(String value) {
			addCriterion("FINANCE_NAME =", value, "financeName");
			return (Criteria) this;
		}

		public Criteria andFinanceNameNotEqualTo(String value) {
			addCriterion("FINANCE_NAME <>", value, "financeName");
			return (Criteria) this;
		}

		public Criteria andFinanceNameGreaterThan(String value) {
			addCriterion("FINANCE_NAME >", value, "financeName");
			return (Criteria) this;
		}

		public Criteria andFinanceNameGreaterThanOrEqualTo(String value) {
			addCriterion("FINANCE_NAME >=", value, "financeName");
			return (Criteria) this;
		}

		public Criteria andFinanceNameLessThan(String value) {
			addCriterion("FINANCE_NAME <", value, "financeName");
			return (Criteria) this;
		}

		public Criteria andFinanceNameLessThanOrEqualTo(String value) {
			addCriterion("FINANCE_NAME <=", value, "financeName");
			return (Criteria) this;
		}

		public Criteria andFinanceNameLike(String value) {
			addCriterion("FINANCE_NAME like", value, "financeName");
			return (Criteria) this;
		}

		public Criteria andFinanceNameNotLike(String value) {
			addCriterion("FINANCE_NAME not like", value, "financeName");
			return (Criteria) this;
		}

		public Criteria andFinanceNameIn(List<String> values) {
			addCriterion("FINANCE_NAME in", values, "financeName");
			return (Criteria) this;
		}

		public Criteria andFinanceNameNotIn(List<String> values) {
			addCriterion("FINANCE_NAME not in", values, "financeName");
			return (Criteria) this;
		}

		public Criteria andFinanceNameBetween(String value1, String value2) {
			addCriterion("FINANCE_NAME between", value1, value2, "financeName");
			return (Criteria) this;
		}

		public Criteria andFinanceNameNotBetween(String value1, String value2) {
			addCriterion("FINANCE_NAME not between", value1, value2, "financeName");
			return (Criteria) this;
		}

		public Criteria andPayAccountIsNull() {
			addCriterion("PAY_ACCOUNT is null");
			return (Criteria) this;
		}

		public Criteria andPayAccountIsNotNull() {
			addCriterion("PAY_ACCOUNT is not null");
			return (Criteria) this;
		}

		public Criteria andPayAccountEqualTo(String value) {
			addCriterion("PAY_ACCOUNT =", value, "payAccount");
			return (Criteria) this;
		}

		public Criteria andPayAccountNotEqualTo(String value) {
			addCriterion("PAY_ACCOUNT <>", value, "payAccount");
			return (Criteria) this;
		}

		public Criteria andPayAccountGreaterThan(String value) {
			addCriterion("PAY_ACCOUNT >", value, "payAccount");
			return (Criteria) this;
		}

		public Criteria andPayAccountGreaterThanOrEqualTo(String value) {
			addCriterion("PAY_ACCOUNT >=", value, "payAccount");
			return (Criteria) this;
		}

		public Criteria andPayAccountLessThan(String value) {
			addCriterion("PAY_ACCOUNT <", value, "payAccount");
			return (Criteria) this;
		}

		public Criteria andPayAccountLessThanOrEqualTo(String value) {
			addCriterion("PAY_ACCOUNT <=", value, "payAccount");
			return (Criteria) this;
		}

		public Criteria andPayAccountLike(String value) {
			addCriterion("PAY_ACCOUNT like", value, "payAccount");
			return (Criteria) this;
		}

		public Criteria andPayAccountNotLike(String value) {
			addCriterion("PAY_ACCOUNT not like", value, "payAccount");
			return (Criteria) this;
		}

		public Criteria andPayAccountIn(List<String> values) {
			addCriterion("PAY_ACCOUNT in", values, "payAccount");
			return (Criteria) this;
		}

		public Criteria andPayAccountNotIn(List<String> values) {
			addCriterion("PAY_ACCOUNT not in", values, "payAccount");
			return (Criteria) this;
		}

		public Criteria andPayAccountBetween(String value1, String value2) {
			addCriterion("PAY_ACCOUNT between", value1, value2, "payAccount");
			return (Criteria) this;
		}

		public Criteria andPayAccountNotBetween(String value1, String value2) {
			addCriterion("PAY_ACCOUNT not between", value1, value2, "payAccount");
			return (Criteria) this;
		}

		public Criteria andPayUserNameIsNull() {
			addCriterion("PAY_USER_NAME is null");
			return (Criteria) this;
		}

		public Criteria andPayUserNameIsNotNull() {
			addCriterion("PAY_USER_NAME is not null");
			return (Criteria) this;
		}

		public Criteria andPayUserNameEqualTo(String value) {
			addCriterion("PAY_USER_NAME =", value, "payUserName");
			return (Criteria) this;
		}

		public Criteria andPayUserNameNotEqualTo(String value) {
			addCriterion("PAY_USER_NAME <>", value, "payUserName");
			return (Criteria) this;
		}

		public Criteria andPayUserNameGreaterThan(String value) {
			addCriterion("PAY_USER_NAME >", value, "payUserName");
			return (Criteria) this;
		}

		public Criteria andPayUserNameGreaterThanOrEqualTo(String value) {
			addCriterion("PAY_USER_NAME >=", value, "payUserName");
			return (Criteria) this;
		}

		public Criteria andPayUserNameLessThan(String value) {
			addCriterion("PAY_USER_NAME <", value, "payUserName");
			return (Criteria) this;
		}

		public Criteria andPayUserNameLessThanOrEqualTo(String value) {
			addCriterion("PAY_USER_NAME <=", value, "payUserName");
			return (Criteria) this;
		}

		public Criteria andPayUserNameLike(String value) {
			addCriterion("PAY_USER_NAME like", value, "payUserName");
			return (Criteria) this;
		}

		public Criteria andPayUserNameNotLike(String value) {
			addCriterion("PAY_USER_NAME not like", value, "payUserName");
			return (Criteria) this;
		}

		public Criteria andPayUserNameIn(List<String> values) {
			addCriterion("PAY_USER_NAME in", values, "payUserName");
			return (Criteria) this;
		}

		public Criteria andPayUserNameNotIn(List<String> values) {
			addCriterion("PAY_USER_NAME not in", values, "payUserName");
			return (Criteria) this;
		}

		public Criteria andPayUserNameBetween(String value1, String value2) {
			addCriterion("PAY_USER_NAME between", value1, value2, "payUserName");
			return (Criteria) this;
		}

		public Criteria andPayUserNameNotBetween(String value1, String value2) {
			addCriterion("PAY_USER_NAME not between", value1, value2, "payUserName");
			return (Criteria) this;
		}

		public Criteria andCaseNoIsNull() {
			addCriterion("CASE_NO is null");
			return (Criteria) this;
		}

		public Criteria andCaseNoIsNotNull() {
			addCriterion("CASE_NO is not null");
			return (Criteria) this;
		}

		public Criteria andCaseNoEqualTo(String value) {
			addCriterion("CASE_NO =", value, "caseNo");
			return (Criteria) this;
		}

		public Criteria andCaseNoNotEqualTo(String value) {
			addCriterion("CASE_NO <>", value, "caseNo");
			return (Criteria) this;
		}

		public Criteria andCaseNoGreaterThan(String value) {
			addCriterion("CASE_NO >", value, "caseNo");
			return (Criteria) this;
		}

		public Criteria andCaseNoGreaterThanOrEqualTo(String value) {
			addCriterion("CASE_NO >=", value, "caseNo");
			return (Criteria) this;
		}

		public Criteria andCaseNoLessThan(String value) {
			addCriterion("CASE_NO <", value, "caseNo");
			return (Criteria) this;
		}

		public Criteria andCaseNoLessThanOrEqualTo(String value) {
			addCriterion("CASE_NO <=", value, "caseNo");
			return (Criteria) this;
		}

		public Criteria andCaseNoLike(String value) {
			addCriterion("CASE_NO like", value, "caseNo");
			return (Criteria) this;
		}

		public Criteria andCaseNoNotLike(String value) {
			addCriterion("CASE_NO not like", value, "caseNo");
			return (Criteria) this;
		}

		public Criteria andCaseNoIn(List<String> values) {
			addCriterion("CASE_NO in", values, "caseNo");
			return (Criteria) this;
		}

		public Criteria andCaseNoNotIn(List<String> values) {
			addCriterion("CASE_NO not in", values, "caseNo");
			return (Criteria) this;
		}

		public Criteria andCaseNoBetween(String value1, String value2) {
			addCriterion("CASE_NO between", value1, value2, "caseNo");
			return (Criteria) this;
		}

		public Criteria andCaseNoNotBetween(String value1, String value2) {
			addCriterion("CASE_NO not between", value1, value2, "caseNo");
			return (Criteria) this;
		}

		public Criteria andPosMachineIdIsNull() {
			addCriterion("POS_MACHINE_ID is null");
			return (Criteria) this;
		}

		public Criteria andPosMachineIdIsNotNull() {
			addCriterion("POS_MACHINE_ID is not null");
			return (Criteria) this;
		}

		public Criteria andPosMachineIdEqualTo(String value) {
			addCriterion("POS_MACHINE_ID =", value, "posMachineId");
			return (Criteria) this;
		}

		public Criteria andPosMachineIdNotEqualTo(String value) {
			addCriterion("POS_MACHINE_ID <>", value, "posMachineId");
			return (Criteria) this;
		}

		public Criteria andPosMachineIdGreaterThan(String value) {
			addCriterion("POS_MACHINE_ID >", value, "posMachineId");
			return (Criteria) this;
		}

		public Criteria andPosMachineIdGreaterThanOrEqualTo(String value) {
			addCriterion("POS_MACHINE_ID >=", value, "posMachineId");
			return (Criteria) this;
		}

		public Criteria andPosMachineIdLessThan(String value) {
			addCriterion("POS_MACHINE_ID <", value, "posMachineId");
			return (Criteria) this;
		}

		public Criteria andPosMachineIdLessThanOrEqualTo(String value) {
			addCriterion("POS_MACHINE_ID <=", value, "posMachineId");
			return (Criteria) this;
		}

		public Criteria andPosMachineIdLike(String value) {
			addCriterion("POS_MACHINE_ID like", value, "posMachineId");
			return (Criteria) this;
		}

		public Criteria andPosMachineIdNotLike(String value) {
			addCriterion("POS_MACHINE_ID not like", value, "posMachineId");
			return (Criteria) this;
		}

		public Criteria andPosMachineIdIn(List<String> values) {
			addCriterion("POS_MACHINE_ID in", values, "posMachineId");
			return (Criteria) this;
		}

		public Criteria andPosMachineIdNotIn(List<String> values) {
			addCriterion("POS_MACHINE_ID not in", values, "posMachineId");
			return (Criteria) this;
		}

		public Criteria andPosMachineIdBetween(String value1, String value2) {
			addCriterion("POS_MACHINE_ID between", value1, value2, "posMachineId");
			return (Criteria) this;
		}

		public Criteria andPosMachineIdNotBetween(String value1, String value2) {
			addCriterion("POS_MACHINE_ID not between", value1, value2, "posMachineId");
			return (Criteria) this;
		}

		public Criteria andCreateUidIsNull() {
			addCriterion("CREATE_UID is null");
			return (Criteria) this;
		}

		public Criteria andCreateUidIsNotNull() {
			addCriterion("CREATE_UID is not null");
			return (Criteria) this;
		}

		public Criteria andCreateUidEqualTo(Integer value) {
			addCriterion("CREATE_UID =", value, "createUid");
			return (Criteria) this;
		}

		public Criteria andCreateUidNotEqualTo(Integer value) {
			addCriterion("CREATE_UID <>", value, "createUid");
			return (Criteria) this;
		}

		public Criteria andCreateUidGreaterThan(Integer value) {
			addCriterion("CREATE_UID >", value, "createUid");
			return (Criteria) this;
		}

		public Criteria andCreateUidGreaterThanOrEqualTo(Integer value) {
			addCriterion("CREATE_UID >=", value, "createUid");
			return (Criteria) this;
		}

		public Criteria andCreateUidLessThan(Integer value) {
			addCriterion("CREATE_UID <", value, "createUid");
			return (Criteria) this;
		}

		public Criteria andCreateUidLessThanOrEqualTo(Integer value) {
			addCriterion("CREATE_UID <=", value, "createUid");
			return (Criteria) this;
		}

		public Criteria andCreateUidIn(List<Integer> values) {
			addCriterion("CREATE_UID in", values, "createUid");
			return (Criteria) this;
		}

		public Criteria andCreateUidNotIn(List<Integer> values) {
			addCriterion("CREATE_UID not in", values, "createUid");
			return (Criteria) this;
		}

		public Criteria andCreateUidBetween(Integer value1, Integer value2) {
			addCriterion("CREATE_UID between", value1, value2, "createUid");
			return (Criteria) this;
		}

		public Criteria andCreateUidNotBetween(Integer value1, Integer value2) {
			addCriterion("CREATE_UID not between", value1, value2, "createUid");
			return (Criteria) this;
		}

		public Criteria andPaymentIdIsNull() {
			addCriterion("PAYMENT_ID is null");
			return (Criteria) this;
		}

		public Criteria andPaymentIdIsNotNull() {
			addCriterion("PAYMENT_ID is not null");
			return (Criteria) this;
		}

		public Criteria andPaymentIdEqualTo(Integer value) {
			addCriterion("PAYMENT_ID =", value, "paymentId");
			return (Criteria) this;
		}

		public Criteria andPaymentIdNotEqualTo(Integer value) {
			addCriterion("PAYMENT_ID <>", value, "paymentId");
			return (Criteria) this;
		}

		public Criteria andPaymentIdGreaterThan(Integer value) {
			addCriterion("PAYMENT_ID >", value, "paymentId");
			return (Criteria) this;
		}

		public Criteria andPaymentIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("PAYMENT_ID >=", value, "paymentId");
			return (Criteria) this;
		}

		public Criteria andPaymentIdLessThan(Integer value) {
			addCriterion("PAYMENT_ID <", value, "paymentId");
			return (Criteria) this;
		}

		public Criteria andPaymentIdLessThanOrEqualTo(Integer value) {
			addCriterion("PAYMENT_ID <=", value, "paymentId");
			return (Criteria) this;
		}

		public Criteria andPaymentIdIn(List<Integer> values) {
			addCriterion("PAYMENT_ID in", values, "paymentId");
			return (Criteria) this;
		}

		public Criteria andPaymentIdNotIn(List<Integer> values) {
			addCriterion("PAYMENT_ID not in", values, "paymentId");
			return (Criteria) this;
		}

		public Criteria andPaymentIdBetween(Integer value1, Integer value2) {
			addCriterion("PAYMENT_ID between", value1, value2, "paymentId");
			return (Criteria) this;
		}

		public Criteria andPaymentIdNotBetween(Integer value1, Integer value2) {
			addCriterion("PAYMENT_ID not between", value1, value2, "paymentId");
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