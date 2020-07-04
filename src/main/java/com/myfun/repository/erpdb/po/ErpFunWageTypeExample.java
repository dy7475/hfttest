package com.myfun.repository.erpdb.po;

import com.myfun.repository.support.generator.shard.ShardDb;
import java.util.ArrayList;
import java.util.List;

public class ErpFunWageTypeExample extends ShardDb {
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
	public ErpFunWageTypeExample() {
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

		public Criteria andWagetypeIdIsNull() {
			addCriterion("WAGETYPE_ID is null");
			return (Criteria) this;
		}

		public Criteria andWagetypeIdIsNotNull() {
			addCriterion("WAGETYPE_ID is not null");
			return (Criteria) this;
		}

		public Criteria andWagetypeIdEqualTo(Integer value) {
			addCriterion("WAGETYPE_ID =", value, "wagetypeId");
			return (Criteria) this;
		}

		public Criteria andWagetypeIdNotEqualTo(Integer value) {
			addCriterion("WAGETYPE_ID <>", value, "wagetypeId");
			return (Criteria) this;
		}

		public Criteria andWagetypeIdGreaterThan(Integer value) {
			addCriterion("WAGETYPE_ID >", value, "wagetypeId");
			return (Criteria) this;
		}

		public Criteria andWagetypeIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("WAGETYPE_ID >=", value, "wagetypeId");
			return (Criteria) this;
		}

		public Criteria andWagetypeIdLessThan(Integer value) {
			addCriterion("WAGETYPE_ID <", value, "wagetypeId");
			return (Criteria) this;
		}

		public Criteria andWagetypeIdLessThanOrEqualTo(Integer value) {
			addCriterion("WAGETYPE_ID <=", value, "wagetypeId");
			return (Criteria) this;
		}

		public Criteria andWagetypeIdIn(List<Integer> values) {
			addCriterion("WAGETYPE_ID in", values, "wagetypeId");
			return (Criteria) this;
		}

		public Criteria andWagetypeIdNotIn(List<Integer> values) {
			addCriterion("WAGETYPE_ID not in", values, "wagetypeId");
			return (Criteria) this;
		}

		public Criteria andWagetypeIdBetween(Integer value1, Integer value2) {
			addCriterion("WAGETYPE_ID between", value1, value2, "wagetypeId");
			return (Criteria) this;
		}

		public Criteria andWagetypeIdNotBetween(Integer value1, Integer value2) {
			addCriterion("WAGETYPE_ID not between", value1, value2, "wagetypeId");
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

		public Criteria andWageTypeCnIsNull() {
			addCriterion("WAGE_TYPE_CN is null");
			return (Criteria) this;
		}

		public Criteria andWageTypeCnIsNotNull() {
			addCriterion("WAGE_TYPE_CN is not null");
			return (Criteria) this;
		}

		public Criteria andWageTypeCnEqualTo(String value) {
			addCriterion("WAGE_TYPE_CN =", value, "wageTypeCn");
			return (Criteria) this;
		}

		public Criteria andWageTypeCnNotEqualTo(String value) {
			addCriterion("WAGE_TYPE_CN <>", value, "wageTypeCn");
			return (Criteria) this;
		}

		public Criteria andWageTypeCnGreaterThan(String value) {
			addCriterion("WAGE_TYPE_CN >", value, "wageTypeCn");
			return (Criteria) this;
		}

		public Criteria andWageTypeCnGreaterThanOrEqualTo(String value) {
			addCriterion("WAGE_TYPE_CN >=", value, "wageTypeCn");
			return (Criteria) this;
		}

		public Criteria andWageTypeCnLessThan(String value) {
			addCriterion("WAGE_TYPE_CN <", value, "wageTypeCn");
			return (Criteria) this;
		}

		public Criteria andWageTypeCnLessThanOrEqualTo(String value) {
			addCriterion("WAGE_TYPE_CN <=", value, "wageTypeCn");
			return (Criteria) this;
		}

		public Criteria andWageTypeCnLike(String value) {
			addCriterion("WAGE_TYPE_CN like", value, "wageTypeCn");
			return (Criteria) this;
		}

		public Criteria andWageTypeCnNotLike(String value) {
			addCriterion("WAGE_TYPE_CN not like", value, "wageTypeCn");
			return (Criteria) this;
		}

		public Criteria andWageTypeCnIn(List<String> values) {
			addCriterion("WAGE_TYPE_CN in", values, "wageTypeCn");
			return (Criteria) this;
		}

		public Criteria andWageTypeCnNotIn(List<String> values) {
			addCriterion("WAGE_TYPE_CN not in", values, "wageTypeCn");
			return (Criteria) this;
		}

		public Criteria andWageTypeCnBetween(String value1, String value2) {
			addCriterion("WAGE_TYPE_CN between", value1, value2, "wageTypeCn");
			return (Criteria) this;
		}

		public Criteria andWageTypeCnNotBetween(String value1, String value2) {
			addCriterion("WAGE_TYPE_CN not between", value1, value2, "wageTypeCn");
			return (Criteria) this;
		}

		public Criteria andWageTypeEnIsNull() {
			addCriterion("WAGE_TYPE_EN is null");
			return (Criteria) this;
		}

		public Criteria andWageTypeEnIsNotNull() {
			addCriterion("WAGE_TYPE_EN is not null");
			return (Criteria) this;
		}

		public Criteria andWageTypeEnEqualTo(String value) {
			addCriterion("WAGE_TYPE_EN =", value, "wageTypeEn");
			return (Criteria) this;
		}

		public Criteria andWageTypeEnNotEqualTo(String value) {
			addCriterion("WAGE_TYPE_EN <>", value, "wageTypeEn");
			return (Criteria) this;
		}

		public Criteria andWageTypeEnGreaterThan(String value) {
			addCriterion("WAGE_TYPE_EN >", value, "wageTypeEn");
			return (Criteria) this;
		}

		public Criteria andWageTypeEnGreaterThanOrEqualTo(String value) {
			addCriterion("WAGE_TYPE_EN >=", value, "wageTypeEn");
			return (Criteria) this;
		}

		public Criteria andWageTypeEnLessThan(String value) {
			addCriterion("WAGE_TYPE_EN <", value, "wageTypeEn");
			return (Criteria) this;
		}

		public Criteria andWageTypeEnLessThanOrEqualTo(String value) {
			addCriterion("WAGE_TYPE_EN <=", value, "wageTypeEn");
			return (Criteria) this;
		}

		public Criteria andWageTypeEnLike(String value) {
			addCriterion("WAGE_TYPE_EN like", value, "wageTypeEn");
			return (Criteria) this;
		}

		public Criteria andWageTypeEnNotLike(String value) {
			addCriterion("WAGE_TYPE_EN not like", value, "wageTypeEn");
			return (Criteria) this;
		}

		public Criteria andWageTypeEnIn(List<String> values) {
			addCriterion("WAGE_TYPE_EN in", values, "wageTypeEn");
			return (Criteria) this;
		}

		public Criteria andWageTypeEnNotIn(List<String> values) {
			addCriterion("WAGE_TYPE_EN not in", values, "wageTypeEn");
			return (Criteria) this;
		}

		public Criteria andWageTypeEnBetween(String value1, String value2) {
			addCriterion("WAGE_TYPE_EN between", value1, value2, "wageTypeEn");
			return (Criteria) this;
		}

		public Criteria andWageTypeEnNotBetween(String value1, String value2) {
			addCriterion("WAGE_TYPE_EN not between", value1, value2, "wageTypeEn");
			return (Criteria) this;
		}

		public Criteria andSeqIsNull() {
			addCriterion("SEQ is null");
			return (Criteria) this;
		}

		public Criteria andSeqIsNotNull() {
			addCriterion("SEQ is not null");
			return (Criteria) this;
		}

		public Criteria andSeqEqualTo(Byte value) {
			addCriterion("SEQ =", value, "seq");
			return (Criteria) this;
		}

		public Criteria andSeqNotEqualTo(Byte value) {
			addCriterion("SEQ <>", value, "seq");
			return (Criteria) this;
		}

		public Criteria andSeqGreaterThan(Byte value) {
			addCriterion("SEQ >", value, "seq");
			return (Criteria) this;
		}

		public Criteria andSeqGreaterThanOrEqualTo(Byte value) {
			addCriterion("SEQ >=", value, "seq");
			return (Criteria) this;
		}

		public Criteria andSeqLessThan(Byte value) {
			addCriterion("SEQ <", value, "seq");
			return (Criteria) this;
		}

		public Criteria andSeqLessThanOrEqualTo(Byte value) {
			addCriterion("SEQ <=", value, "seq");
			return (Criteria) this;
		}

		public Criteria andSeqIn(List<Byte> values) {
			addCriterion("SEQ in", values, "seq");
			return (Criteria) this;
		}

		public Criteria andSeqNotIn(List<Byte> values) {
			addCriterion("SEQ not in", values, "seq");
			return (Criteria) this;
		}

		public Criteria andSeqBetween(Byte value1, Byte value2) {
			addCriterion("SEQ between", value1, value2, "seq");
			return (Criteria) this;
		}

		public Criteria andSeqNotBetween(Byte value1, Byte value2) {
			addCriterion("SEQ not between", value1, value2, "seq");
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

		public Criteria andWageCountTypeIsNull() {
			addCriterion("WAGE_COUNT_TYPE is null");
			return (Criteria) this;
		}

		public Criteria andWageCountTypeIsNotNull() {
			addCriterion("WAGE_COUNT_TYPE is not null");
			return (Criteria) this;
		}

		public Criteria andWageCountTypeEqualTo(Byte value) {
			addCriterion("WAGE_COUNT_TYPE =", value, "wageCountType");
			return (Criteria) this;
		}

		public Criteria andWageCountTypeNotEqualTo(Byte value) {
			addCriterion("WAGE_COUNT_TYPE <>", value, "wageCountType");
			return (Criteria) this;
		}

		public Criteria andWageCountTypeGreaterThan(Byte value) {
			addCriterion("WAGE_COUNT_TYPE >", value, "wageCountType");
			return (Criteria) this;
		}

		public Criteria andWageCountTypeGreaterThanOrEqualTo(Byte value) {
			addCriterion("WAGE_COUNT_TYPE >=", value, "wageCountType");
			return (Criteria) this;
		}

		public Criteria andWageCountTypeLessThan(Byte value) {
			addCriterion("WAGE_COUNT_TYPE <", value, "wageCountType");
			return (Criteria) this;
		}

		public Criteria andWageCountTypeLessThanOrEqualTo(Byte value) {
			addCriterion("WAGE_COUNT_TYPE <=", value, "wageCountType");
			return (Criteria) this;
		}

		public Criteria andWageCountTypeIn(List<Byte> values) {
			addCriterion("WAGE_COUNT_TYPE in", values, "wageCountType");
			return (Criteria) this;
		}

		public Criteria andWageCountTypeNotIn(List<Byte> values) {
			addCriterion("WAGE_COUNT_TYPE not in", values, "wageCountType");
			return (Criteria) this;
		}

		public Criteria andWageCountTypeBetween(Byte value1, Byte value2) {
			addCriterion("WAGE_COUNT_TYPE between", value1, value2, "wageCountType");
			return (Criteria) this;
		}

		public Criteria andWageCountTypeNotBetween(Byte value1, Byte value2) {
			addCriterion("WAGE_COUNT_TYPE not between", value1, value2, "wageCountType");
			return (Criteria) this;
		}

		public Criteria andPerformanceTypeIsNull() {
			addCriterion("PERFORMANCE_TYPE is null");
			return (Criteria) this;
		}

		public Criteria andPerformanceTypeIsNotNull() {
			addCriterion("PERFORMANCE_TYPE is not null");
			return (Criteria) this;
		}

		public Criteria andPerformanceTypeEqualTo(Byte value) {
			addCriterion("PERFORMANCE_TYPE =", value, "performanceType");
			return (Criteria) this;
		}

		public Criteria andPerformanceTypeNotEqualTo(Byte value) {
			addCriterion("PERFORMANCE_TYPE <>", value, "performanceType");
			return (Criteria) this;
		}

		public Criteria andPerformanceTypeGreaterThan(Byte value) {
			addCriterion("PERFORMANCE_TYPE >", value, "performanceType");
			return (Criteria) this;
		}

		public Criteria andPerformanceTypeGreaterThanOrEqualTo(Byte value) {
			addCriterion("PERFORMANCE_TYPE >=", value, "performanceType");
			return (Criteria) this;
		}

		public Criteria andPerformanceTypeLessThan(Byte value) {
			addCriterion("PERFORMANCE_TYPE <", value, "performanceType");
			return (Criteria) this;
		}

		public Criteria andPerformanceTypeLessThanOrEqualTo(Byte value) {
			addCriterion("PERFORMANCE_TYPE <=", value, "performanceType");
			return (Criteria) this;
		}

		public Criteria andPerformanceTypeIn(List<Byte> values) {
			addCriterion("PERFORMANCE_TYPE in", values, "performanceType");
			return (Criteria) this;
		}

		public Criteria andPerformanceTypeNotIn(List<Byte> values) {
			addCriterion("PERFORMANCE_TYPE not in", values, "performanceType");
			return (Criteria) this;
		}

		public Criteria andPerformanceTypeBetween(Byte value1, Byte value2) {
			addCriterion("PERFORMANCE_TYPE between", value1, value2, "performanceType");
			return (Criteria) this;
		}

		public Criteria andPerformanceTypeNotBetween(Byte value1, Byte value2) {
			addCriterion("PERFORMANCE_TYPE not between", value1, value2, "performanceType");
			return (Criteria) this;
		}

		public Criteria andRoyaltyRangeIsNull() {
			addCriterion("ROYALTY_RANGE is null");
			return (Criteria) this;
		}

		public Criteria andRoyaltyRangeIsNotNull() {
			addCriterion("ROYALTY_RANGE is not null");
			return (Criteria) this;
		}

		public Criteria andRoyaltyRangeEqualTo(Byte value) {
			addCriterion("ROYALTY_RANGE =", value, "royaltyRange");
			return (Criteria) this;
		}

		public Criteria andRoyaltyRangeNotEqualTo(Byte value) {
			addCriterion("ROYALTY_RANGE <>", value, "royaltyRange");
			return (Criteria) this;
		}

		public Criteria andRoyaltyRangeGreaterThan(Byte value) {
			addCriterion("ROYALTY_RANGE >", value, "royaltyRange");
			return (Criteria) this;
		}

		public Criteria andRoyaltyRangeGreaterThanOrEqualTo(Byte value) {
			addCriterion("ROYALTY_RANGE >=", value, "royaltyRange");
			return (Criteria) this;
		}

		public Criteria andRoyaltyRangeLessThan(Byte value) {
			addCriterion("ROYALTY_RANGE <", value, "royaltyRange");
			return (Criteria) this;
		}

		public Criteria andRoyaltyRangeLessThanOrEqualTo(Byte value) {
			addCriterion("ROYALTY_RANGE <=", value, "royaltyRange");
			return (Criteria) this;
		}

		public Criteria andRoyaltyRangeIn(List<Byte> values) {
			addCriterion("ROYALTY_RANGE in", values, "royaltyRange");
			return (Criteria) this;
		}

		public Criteria andRoyaltyRangeNotIn(List<Byte> values) {
			addCriterion("ROYALTY_RANGE not in", values, "royaltyRange");
			return (Criteria) this;
		}

		public Criteria andRoyaltyRangeBetween(Byte value1, Byte value2) {
			addCriterion("ROYALTY_RANGE between", value1, value2, "royaltyRange");
			return (Criteria) this;
		}

		public Criteria andRoyaltyRangeNotBetween(Byte value1, Byte value2) {
			addCriterion("ROYALTY_RANGE not between", value1, value2, "royaltyRange");
			return (Criteria) this;
		}

		public Criteria andProfitRangeIsNull() {
			addCriterion("PROFIT_RANGE is null");
			return (Criteria) this;
		}

		public Criteria andProfitRangeIsNotNull() {
			addCriterion("PROFIT_RANGE is not null");
			return (Criteria) this;
		}

		public Criteria andProfitRangeEqualTo(Byte value) {
			addCriterion("PROFIT_RANGE =", value, "profitRange");
			return (Criteria) this;
		}

		public Criteria andProfitRangeNotEqualTo(Byte value) {
			addCriterion("PROFIT_RANGE <>", value, "profitRange");
			return (Criteria) this;
		}

		public Criteria andProfitRangeGreaterThan(Byte value) {
			addCriterion("PROFIT_RANGE >", value, "profitRange");
			return (Criteria) this;
		}

		public Criteria andProfitRangeGreaterThanOrEqualTo(Byte value) {
			addCriterion("PROFIT_RANGE >=", value, "profitRange");
			return (Criteria) this;
		}

		public Criteria andProfitRangeLessThan(Byte value) {
			addCriterion("PROFIT_RANGE <", value, "profitRange");
			return (Criteria) this;
		}

		public Criteria andProfitRangeLessThanOrEqualTo(Byte value) {
			addCriterion("PROFIT_RANGE <=", value, "profitRange");
			return (Criteria) this;
		}

		public Criteria andProfitRangeIn(List<Byte> values) {
			addCriterion("PROFIT_RANGE in", values, "profitRange");
			return (Criteria) this;
		}

		public Criteria andProfitRangeNotIn(List<Byte> values) {
			addCriterion("PROFIT_RANGE not in", values, "profitRange");
			return (Criteria) this;
		}

		public Criteria andProfitRangeBetween(Byte value1, Byte value2) {
			addCriterion("PROFIT_RANGE between", value1, value2, "profitRange");
			return (Criteria) this;
		}

		public Criteria andProfitRangeNotBetween(Byte value1, Byte value2) {
			addCriterion("PROFIT_RANGE not between", value1, value2, "profitRange");
			return (Criteria) this;
		}

		public Criteria andBaseProportionIsNull() {
			addCriterion("BASE_PROPORTION is null");
			return (Criteria) this;
		}

		public Criteria andBaseProportionIsNotNull() {
			addCriterion("BASE_PROPORTION is not null");
			return (Criteria) this;
		}

		public Criteria andBaseProportionEqualTo(Integer value) {
			addCriterion("BASE_PROPORTION =", value, "baseProportion");
			return (Criteria) this;
		}

		public Criteria andBaseProportionNotEqualTo(Integer value) {
			addCriterion("BASE_PROPORTION <>", value, "baseProportion");
			return (Criteria) this;
		}

		public Criteria andBaseProportionGreaterThan(Integer value) {
			addCriterion("BASE_PROPORTION >", value, "baseProportion");
			return (Criteria) this;
		}

		public Criteria andBaseProportionGreaterThanOrEqualTo(Integer value) {
			addCriterion("BASE_PROPORTION >=", value, "baseProportion");
			return (Criteria) this;
		}

		public Criteria andBaseProportionLessThan(Integer value) {
			addCriterion("BASE_PROPORTION <", value, "baseProportion");
			return (Criteria) this;
		}

		public Criteria andBaseProportionLessThanOrEqualTo(Integer value) {
			addCriterion("BASE_PROPORTION <=", value, "baseProportion");
			return (Criteria) this;
		}

		public Criteria andBaseProportionIn(List<Integer> values) {
			addCriterion("BASE_PROPORTION in", values, "baseProportion");
			return (Criteria) this;
		}

		public Criteria andBaseProportionNotIn(List<Integer> values) {
			addCriterion("BASE_PROPORTION not in", values, "baseProportion");
			return (Criteria) this;
		}

		public Criteria andBaseProportionBetween(Integer value1, Integer value2) {
			addCriterion("BASE_PROPORTION between", value1, value2, "baseProportion");
			return (Criteria) this;
		}

		public Criteria andBaseProportionNotBetween(Integer value1, Integer value2) {
			addCriterion("BASE_PROPORTION not between", value1, value2, "baseProportion");
			return (Criteria) this;
		}

		public Criteria andWageTypeDescIsNull() {
			addCriterion("WAGE_TYPE_DESC is null");
			return (Criteria) this;
		}

		public Criteria andWageTypeDescIsNotNull() {
			addCriterion("WAGE_TYPE_DESC is not null");
			return (Criteria) this;
		}

		public Criteria andWageTypeDescEqualTo(String value) {
			addCriterion("WAGE_TYPE_DESC =", value, "wageTypeDesc");
			return (Criteria) this;
		}

		public Criteria andWageTypeDescNotEqualTo(String value) {
			addCriterion("WAGE_TYPE_DESC <>", value, "wageTypeDesc");
			return (Criteria) this;
		}

		public Criteria andWageTypeDescGreaterThan(String value) {
			addCriterion("WAGE_TYPE_DESC >", value, "wageTypeDesc");
			return (Criteria) this;
		}

		public Criteria andWageTypeDescGreaterThanOrEqualTo(String value) {
			addCriterion("WAGE_TYPE_DESC >=", value, "wageTypeDesc");
			return (Criteria) this;
		}

		public Criteria andWageTypeDescLessThan(String value) {
			addCriterion("WAGE_TYPE_DESC <", value, "wageTypeDesc");
			return (Criteria) this;
		}

		public Criteria andWageTypeDescLessThanOrEqualTo(String value) {
			addCriterion("WAGE_TYPE_DESC <=", value, "wageTypeDesc");
			return (Criteria) this;
		}

		public Criteria andWageTypeDescLike(String value) {
			addCriterion("WAGE_TYPE_DESC like", value, "wageTypeDesc");
			return (Criteria) this;
		}

		public Criteria andWageTypeDescNotLike(String value) {
			addCriterion("WAGE_TYPE_DESC not like", value, "wageTypeDesc");
			return (Criteria) this;
		}

		public Criteria andWageTypeDescIn(List<String> values) {
			addCriterion("WAGE_TYPE_DESC in", values, "wageTypeDesc");
			return (Criteria) this;
		}

		public Criteria andWageTypeDescNotIn(List<String> values) {
			addCriterion("WAGE_TYPE_DESC not in", values, "wageTypeDesc");
			return (Criteria) this;
		}

		public Criteria andWageTypeDescBetween(String value1, String value2) {
			addCriterion("WAGE_TYPE_DESC between", value1, value2, "wageTypeDesc");
			return (Criteria) this;
		}

		public Criteria andWageTypeDescNotBetween(String value1, String value2) {
			addCriterion("WAGE_TYPE_DESC not between", value1, value2, "wageTypeDesc");
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