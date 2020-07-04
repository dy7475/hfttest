package com.myfun.repository.erpdb.po;

import com.myfun.repository.support.generator.shard.ShardDb;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ErpFunWageConfigExample extends ShardDb {
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
	public ErpFunWageConfigExample() {
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

		public Criteria andExchangeAmountIsNull() {
			addCriterion("EXCHANGE_AMOUNT is null");
			return (Criteria) this;
		}

		public Criteria andExchangeAmountIsNotNull() {
			addCriterion("EXCHANGE_AMOUNT is not null");
			return (Criteria) this;
		}

		public Criteria andExchangeAmountEqualTo(BigDecimal value) {
			addCriterion("EXCHANGE_AMOUNT =", value, "exchangeAmount");
			return (Criteria) this;
		}

		public Criteria andExchangeAmountNotEqualTo(BigDecimal value) {
			addCriterion("EXCHANGE_AMOUNT <>", value, "exchangeAmount");
			return (Criteria) this;
		}

		public Criteria andExchangeAmountGreaterThan(BigDecimal value) {
			addCriterion("EXCHANGE_AMOUNT >", value, "exchangeAmount");
			return (Criteria) this;
		}

		public Criteria andExchangeAmountGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("EXCHANGE_AMOUNT >=", value, "exchangeAmount");
			return (Criteria) this;
		}

		public Criteria andExchangeAmountLessThan(BigDecimal value) {
			addCriterion("EXCHANGE_AMOUNT <", value, "exchangeAmount");
			return (Criteria) this;
		}

		public Criteria andExchangeAmountLessThanOrEqualTo(BigDecimal value) {
			addCriterion("EXCHANGE_AMOUNT <=", value, "exchangeAmount");
			return (Criteria) this;
		}

		public Criteria andExchangeAmountIn(List<BigDecimal> values) {
			addCriterion("EXCHANGE_AMOUNT in", values, "exchangeAmount");
			return (Criteria) this;
		}

		public Criteria andExchangeAmountNotIn(List<BigDecimal> values) {
			addCriterion("EXCHANGE_AMOUNT not in", values, "exchangeAmount");
			return (Criteria) this;
		}

		public Criteria andExchangeAmountBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("EXCHANGE_AMOUNT between", value1, value2, "exchangeAmount");
			return (Criteria) this;
		}

		public Criteria andExchangeAmountNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("EXCHANGE_AMOUNT not between", value1, value2, "exchangeAmount");
			return (Criteria) this;
		}

		public Criteria andShowTypeIsNull() {
			addCriterion("SHOW_TYPE is null");
			return (Criteria) this;
		}

		public Criteria andShowTypeIsNotNull() {
			addCriterion("SHOW_TYPE is not null");
			return (Criteria) this;
		}

		public Criteria andShowTypeEqualTo(Byte value) {
			addCriterion("SHOW_TYPE =", value, "showType");
			return (Criteria) this;
		}

		public Criteria andShowTypeNotEqualTo(Byte value) {
			addCriterion("SHOW_TYPE <>", value, "showType");
			return (Criteria) this;
		}

		public Criteria andShowTypeGreaterThan(Byte value) {
			addCriterion("SHOW_TYPE >", value, "showType");
			return (Criteria) this;
		}

		public Criteria andShowTypeGreaterThanOrEqualTo(Byte value) {
			addCriterion("SHOW_TYPE >=", value, "showType");
			return (Criteria) this;
		}

		public Criteria andShowTypeLessThan(Byte value) {
			addCriterion("SHOW_TYPE <", value, "showType");
			return (Criteria) this;
		}

		public Criteria andShowTypeLessThanOrEqualTo(Byte value) {
			addCriterion("SHOW_TYPE <=", value, "showType");
			return (Criteria) this;
		}

		public Criteria andShowTypeIn(List<Byte> values) {
			addCriterion("SHOW_TYPE in", values, "showType");
			return (Criteria) this;
		}

		public Criteria andShowTypeNotIn(List<Byte> values) {
			addCriterion("SHOW_TYPE not in", values, "showType");
			return (Criteria) this;
		}

		public Criteria andShowTypeBetween(Byte value1, Byte value2) {
			addCriterion("SHOW_TYPE between", value1, value2, "showType");
			return (Criteria) this;
		}

		public Criteria andShowTypeNotBetween(Byte value1, Byte value2) {
			addCriterion("SHOW_TYPE not between", value1, value2, "showType");
			return (Criteria) this;
		}

		public Criteria andPerformanceCalculateTypeIsNull() {
			addCriterion("PERFORMANCE_CALCULATE_TYPE is null");
			return (Criteria) this;
		}

		public Criteria andPerformanceCalculateTypeIsNotNull() {
			addCriterion("PERFORMANCE_CALCULATE_TYPE is not null");
			return (Criteria) this;
		}

		public Criteria andPerformanceCalculateTypeEqualTo(Byte value) {
			addCriterion("PERFORMANCE_CALCULATE_TYPE =", value, "performanceCalculateType");
			return (Criteria) this;
		}

		public Criteria andPerformanceCalculateTypeNotEqualTo(Byte value) {
			addCriterion("PERFORMANCE_CALCULATE_TYPE <>", value, "performanceCalculateType");
			return (Criteria) this;
		}

		public Criteria andPerformanceCalculateTypeGreaterThan(Byte value) {
			addCriterion("PERFORMANCE_CALCULATE_TYPE >", value, "performanceCalculateType");
			return (Criteria) this;
		}

		public Criteria andPerformanceCalculateTypeGreaterThanOrEqualTo(Byte value) {
			addCriterion("PERFORMANCE_CALCULATE_TYPE >=", value, "performanceCalculateType");
			return (Criteria) this;
		}

		public Criteria andPerformanceCalculateTypeLessThan(Byte value) {
			addCriterion("PERFORMANCE_CALCULATE_TYPE <", value, "performanceCalculateType");
			return (Criteria) this;
		}

		public Criteria andPerformanceCalculateTypeLessThanOrEqualTo(Byte value) {
			addCriterion("PERFORMANCE_CALCULATE_TYPE <=", value, "performanceCalculateType");
			return (Criteria) this;
		}

		public Criteria andPerformanceCalculateTypeIn(List<Byte> values) {
			addCriterion("PERFORMANCE_CALCULATE_TYPE in", values, "performanceCalculateType");
			return (Criteria) this;
		}

		public Criteria andPerformanceCalculateTypeNotIn(List<Byte> values) {
			addCriterion("PERFORMANCE_CALCULATE_TYPE not in", values, "performanceCalculateType");
			return (Criteria) this;
		}

		public Criteria andPerformanceCalculateTypeBetween(Byte value1, Byte value2) {
			addCriterion("PERFORMANCE_CALCULATE_TYPE between", value1, value2, "performanceCalculateType");
			return (Criteria) this;
		}

		public Criteria andPerformanceCalculateTypeNotBetween(Byte value1, Byte value2) {
			addCriterion("PERFORMANCE_CALCULATE_TYPE not between", value1, value2, "performanceCalculateType");
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

		public Criteria andCustomerPubPriTypeIsNull() {
			addCriterion("CUSTOMER_PUB_PRI_TYPE is null");
			return (Criteria) this;
		}

		public Criteria andCustomerPubPriTypeIsNotNull() {
			addCriterion("CUSTOMER_PUB_PRI_TYPE is not null");
			return (Criteria) this;
		}

		public Criteria andCustomerPubPriTypeEqualTo(Byte value) {
			addCriterion("CUSTOMER_PUB_PRI_TYPE =", value, "customerPubPriType");
			return (Criteria) this;
		}

		public Criteria andCustomerPubPriTypeNotEqualTo(Byte value) {
			addCriterion("CUSTOMER_PUB_PRI_TYPE <>", value, "customerPubPriType");
			return (Criteria) this;
		}

		public Criteria andCustomerPubPriTypeGreaterThan(Byte value) {
			addCriterion("CUSTOMER_PUB_PRI_TYPE >", value, "customerPubPriType");
			return (Criteria) this;
		}

		public Criteria andCustomerPubPriTypeGreaterThanOrEqualTo(Byte value) {
			addCriterion("CUSTOMER_PUB_PRI_TYPE >=", value, "customerPubPriType");
			return (Criteria) this;
		}

		public Criteria andCustomerPubPriTypeLessThan(Byte value) {
			addCriterion("CUSTOMER_PUB_PRI_TYPE <", value, "customerPubPriType");
			return (Criteria) this;
		}

		public Criteria andCustomerPubPriTypeLessThanOrEqualTo(Byte value) {
			addCriterion("CUSTOMER_PUB_PRI_TYPE <=", value, "customerPubPriType");
			return (Criteria) this;
		}

		public Criteria andCustomerPubPriTypeIn(List<Byte> values) {
			addCriterion("CUSTOMER_PUB_PRI_TYPE in", values, "customerPubPriType");
			return (Criteria) this;
		}

		public Criteria andCustomerPubPriTypeNotIn(List<Byte> values) {
			addCriterion("CUSTOMER_PUB_PRI_TYPE not in", values, "customerPubPriType");
			return (Criteria) this;
		}

		public Criteria andCustomerPubPriTypeBetween(Byte value1, Byte value2) {
			addCriterion("CUSTOMER_PUB_PRI_TYPE between", value1, value2, "customerPubPriType");
			return (Criteria) this;
		}

		public Criteria andCustomerPubPriTypeNotBetween(Byte value1, Byte value2) {
			addCriterion("CUSTOMER_PUB_PRI_TYPE not between", value1, value2, "customerPubPriType");
			return (Criteria) this;
		}

		public Criteria andHouseAddIsNull() {
			addCriterion("HOUSE_ADD is null");
			return (Criteria) this;
		}

		public Criteria andHouseAddIsNotNull() {
			addCriterion("HOUSE_ADD is not null");
			return (Criteria) this;
		}

		public Criteria andHouseAddEqualTo(Byte value) {
			addCriterion("HOUSE_ADD =", value, "houseAdd");
			return (Criteria) this;
		}

		public Criteria andHouseAddNotEqualTo(Byte value) {
			addCriterion("HOUSE_ADD <>", value, "houseAdd");
			return (Criteria) this;
		}

		public Criteria andHouseAddGreaterThan(Byte value) {
			addCriterion("HOUSE_ADD >", value, "houseAdd");
			return (Criteria) this;
		}

		public Criteria andHouseAddGreaterThanOrEqualTo(Byte value) {
			addCriterion("HOUSE_ADD >=", value, "houseAdd");
			return (Criteria) this;
		}

		public Criteria andHouseAddLessThan(Byte value) {
			addCriterion("HOUSE_ADD <", value, "houseAdd");
			return (Criteria) this;
		}

		public Criteria andHouseAddLessThanOrEqualTo(Byte value) {
			addCriterion("HOUSE_ADD <=", value, "houseAdd");
			return (Criteria) this;
		}

		public Criteria andHouseAddIn(List<Byte> values) {
			addCriterion("HOUSE_ADD in", values, "houseAdd");
			return (Criteria) this;
		}

		public Criteria andHouseAddNotIn(List<Byte> values) {
			addCriterion("HOUSE_ADD not in", values, "houseAdd");
			return (Criteria) this;
		}

		public Criteria andHouseAddBetween(Byte value1, Byte value2) {
			addCriterion("HOUSE_ADD between", value1, value2, "houseAdd");
			return (Criteria) this;
		}

		public Criteria andHouseAddNotBetween(Byte value1, Byte value2) {
			addCriterion("HOUSE_ADD not between", value1, value2, "houseAdd");
			return (Criteria) this;
		}

		public Criteria andHouseBuildInfoIsNull() {
			addCriterion("HOUSE_BUILD_INFO is null");
			return (Criteria) this;
		}

		public Criteria andHouseBuildInfoIsNotNull() {
			addCriterion("HOUSE_BUILD_INFO is not null");
			return (Criteria) this;
		}

		public Criteria andHouseBuildInfoEqualTo(Byte value) {
			addCriterion("HOUSE_BUILD_INFO =", value, "houseBuildInfo");
			return (Criteria) this;
		}

		public Criteria andHouseBuildInfoNotEqualTo(Byte value) {
			addCriterion("HOUSE_BUILD_INFO <>", value, "houseBuildInfo");
			return (Criteria) this;
		}

		public Criteria andHouseBuildInfoGreaterThan(Byte value) {
			addCriterion("HOUSE_BUILD_INFO >", value, "houseBuildInfo");
			return (Criteria) this;
		}

		public Criteria andHouseBuildInfoGreaterThanOrEqualTo(Byte value) {
			addCriterion("HOUSE_BUILD_INFO >=", value, "houseBuildInfo");
			return (Criteria) this;
		}

		public Criteria andHouseBuildInfoLessThan(Byte value) {
			addCriterion("HOUSE_BUILD_INFO <", value, "houseBuildInfo");
			return (Criteria) this;
		}

		public Criteria andHouseBuildInfoLessThanOrEqualTo(Byte value) {
			addCriterion("HOUSE_BUILD_INFO <=", value, "houseBuildInfo");
			return (Criteria) this;
		}

		public Criteria andHouseBuildInfoIn(List<Byte> values) {
			addCriterion("HOUSE_BUILD_INFO in", values, "houseBuildInfo");
			return (Criteria) this;
		}

		public Criteria andHouseBuildInfoNotIn(List<Byte> values) {
			addCriterion("HOUSE_BUILD_INFO not in", values, "houseBuildInfo");
			return (Criteria) this;
		}

		public Criteria andHouseBuildInfoBetween(Byte value1, Byte value2) {
			addCriterion("HOUSE_BUILD_INFO between", value1, value2, "houseBuildInfo");
			return (Criteria) this;
		}

		public Criteria andHouseBuildInfoNotBetween(Byte value1, Byte value2) {
			addCriterion("HOUSE_BUILD_INFO not between", value1, value2, "houseBuildInfo");
			return (Criteria) this;
		}

		public Criteria andHouseSosoIsNull() {
			addCriterion("HOUSE_SOSO is null");
			return (Criteria) this;
		}

		public Criteria andHouseSosoIsNotNull() {
			addCriterion("HOUSE_SOSO is not null");
			return (Criteria) this;
		}

		public Criteria andHouseSosoEqualTo(Byte value) {
			addCriterion("HOUSE_SOSO =", value, "houseSoso");
			return (Criteria) this;
		}

		public Criteria andHouseSosoNotEqualTo(Byte value) {
			addCriterion("HOUSE_SOSO <>", value, "houseSoso");
			return (Criteria) this;
		}

		public Criteria andHouseSosoGreaterThan(Byte value) {
			addCriterion("HOUSE_SOSO >", value, "houseSoso");
			return (Criteria) this;
		}

		public Criteria andHouseSosoGreaterThanOrEqualTo(Byte value) {
			addCriterion("HOUSE_SOSO >=", value, "houseSoso");
			return (Criteria) this;
		}

		public Criteria andHouseSosoLessThan(Byte value) {
			addCriterion("HOUSE_SOSO <", value, "houseSoso");
			return (Criteria) this;
		}

		public Criteria andHouseSosoLessThanOrEqualTo(Byte value) {
			addCriterion("HOUSE_SOSO <=", value, "houseSoso");
			return (Criteria) this;
		}

		public Criteria andHouseSosoIn(List<Byte> values) {
			addCriterion("HOUSE_SOSO in", values, "houseSoso");
			return (Criteria) this;
		}

		public Criteria andHouseSosoNotIn(List<Byte> values) {
			addCriterion("HOUSE_SOSO not in", values, "houseSoso");
			return (Criteria) this;
		}

		public Criteria andHouseSosoBetween(Byte value1, Byte value2) {
			addCriterion("HOUSE_SOSO between", value1, value2, "houseSoso");
			return (Criteria) this;
		}

		public Criteria andHouseSosoNotBetween(Byte value1, Byte value2) {
			addCriterion("HOUSE_SOSO not between", value1, value2, "houseSoso");
			return (Criteria) this;
		}

		public Criteria andHousePubPriIsNull() {
			addCriterion("HOUSE_PUB_PRI is null");
			return (Criteria) this;
		}

		public Criteria andHousePubPriIsNotNull() {
			addCriterion("HOUSE_PUB_PRI is not null");
			return (Criteria) this;
		}

		public Criteria andHousePubPriEqualTo(Byte value) {
			addCriterion("HOUSE_PUB_PRI =", value, "housePubPri");
			return (Criteria) this;
		}

		public Criteria andHousePubPriNotEqualTo(Byte value) {
			addCriterion("HOUSE_PUB_PRI <>", value, "housePubPri");
			return (Criteria) this;
		}

		public Criteria andHousePubPriGreaterThan(Byte value) {
			addCriterion("HOUSE_PUB_PRI >", value, "housePubPri");
			return (Criteria) this;
		}

		public Criteria andHousePubPriGreaterThanOrEqualTo(Byte value) {
			addCriterion("HOUSE_PUB_PRI >=", value, "housePubPri");
			return (Criteria) this;
		}

		public Criteria andHousePubPriLessThan(Byte value) {
			addCriterion("HOUSE_PUB_PRI <", value, "housePubPri");
			return (Criteria) this;
		}

		public Criteria andHousePubPriLessThanOrEqualTo(Byte value) {
			addCriterion("HOUSE_PUB_PRI <=", value, "housePubPri");
			return (Criteria) this;
		}

		public Criteria andHousePubPriIn(List<Byte> values) {
			addCriterion("HOUSE_PUB_PRI in", values, "housePubPri");
			return (Criteria) this;
		}

		public Criteria andHousePubPriNotIn(List<Byte> values) {
			addCriterion("HOUSE_PUB_PRI not in", values, "housePubPri");
			return (Criteria) this;
		}

		public Criteria andHousePubPriBetween(Byte value1, Byte value2) {
			addCriterion("HOUSE_PUB_PRI between", value1, value2, "housePubPri");
			return (Criteria) this;
		}

		public Criteria andHousePubPriNotBetween(Byte value1, Byte value2) {
			addCriterion("HOUSE_PUB_PRI not between", value1, value2, "housePubPri");
			return (Criteria) this;
		}

		public Criteria andHouseSharePriIsNull() {
			addCriterion("HOUSE_SHARE_PRI is null");
			return (Criteria) this;
		}

		public Criteria andHouseSharePriIsNotNull() {
			addCriterion("HOUSE_SHARE_PRI is not null");
			return (Criteria) this;
		}

		public Criteria andHouseSharePriEqualTo(Byte value) {
			addCriterion("HOUSE_SHARE_PRI =", value, "houseSharePri");
			return (Criteria) this;
		}

		public Criteria andHouseSharePriNotEqualTo(Byte value) {
			addCriterion("HOUSE_SHARE_PRI <>", value, "houseSharePri");
			return (Criteria) this;
		}

		public Criteria andHouseSharePriGreaterThan(Byte value) {
			addCriterion("HOUSE_SHARE_PRI >", value, "houseSharePri");
			return (Criteria) this;
		}

		public Criteria andHouseSharePriGreaterThanOrEqualTo(Byte value) {
			addCriterion("HOUSE_SHARE_PRI >=", value, "houseSharePri");
			return (Criteria) this;
		}

		public Criteria andHouseSharePriLessThan(Byte value) {
			addCriterion("HOUSE_SHARE_PRI <", value, "houseSharePri");
			return (Criteria) this;
		}

		public Criteria andHouseSharePriLessThanOrEqualTo(Byte value) {
			addCriterion("HOUSE_SHARE_PRI <=", value, "houseSharePri");
			return (Criteria) this;
		}

		public Criteria andHouseSharePriIn(List<Byte> values) {
			addCriterion("HOUSE_SHARE_PRI in", values, "houseSharePri");
			return (Criteria) this;
		}

		public Criteria andHouseSharePriNotIn(List<Byte> values) {
			addCriterion("HOUSE_SHARE_PRI not in", values, "houseSharePri");
			return (Criteria) this;
		}

		public Criteria andHouseSharePriBetween(Byte value1, Byte value2) {
			addCriterion("HOUSE_SHARE_PRI between", value1, value2, "houseSharePri");
			return (Criteria) this;
		}

		public Criteria andHouseSharePriNotBetween(Byte value1, Byte value2) {
			addCriterion("HOUSE_SHARE_PRI not between", value1, value2, "houseSharePri");
			return (Criteria) this;
		}

		public Criteria andHouseToEffectiveIsNull() {
			addCriterion("HOUSE_TO_EFFECTIVE is null");
			return (Criteria) this;
		}

		public Criteria andHouseToEffectiveIsNotNull() {
			addCriterion("HOUSE_TO_EFFECTIVE is not null");
			return (Criteria) this;
		}

		public Criteria andHouseToEffectiveEqualTo(Byte value) {
			addCriterion("HOUSE_TO_EFFECTIVE =", value, "houseToEffective");
			return (Criteria) this;
		}

		public Criteria andHouseToEffectiveNotEqualTo(Byte value) {
			addCriterion("HOUSE_TO_EFFECTIVE <>", value, "houseToEffective");
			return (Criteria) this;
		}

		public Criteria andHouseToEffectiveGreaterThan(Byte value) {
			addCriterion("HOUSE_TO_EFFECTIVE >", value, "houseToEffective");
			return (Criteria) this;
		}

		public Criteria andHouseToEffectiveGreaterThanOrEqualTo(Byte value) {
			addCriterion("HOUSE_TO_EFFECTIVE >=", value, "houseToEffective");
			return (Criteria) this;
		}

		public Criteria andHouseToEffectiveLessThan(Byte value) {
			addCriterion("HOUSE_TO_EFFECTIVE <", value, "houseToEffective");
			return (Criteria) this;
		}

		public Criteria andHouseToEffectiveLessThanOrEqualTo(Byte value) {
			addCriterion("HOUSE_TO_EFFECTIVE <=", value, "houseToEffective");
			return (Criteria) this;
		}

		public Criteria andHouseToEffectiveIn(List<Byte> values) {
			addCriterion("HOUSE_TO_EFFECTIVE in", values, "houseToEffective");
			return (Criteria) this;
		}

		public Criteria andHouseToEffectiveNotIn(List<Byte> values) {
			addCriterion("HOUSE_TO_EFFECTIVE not in", values, "houseToEffective");
			return (Criteria) this;
		}

		public Criteria andHouseToEffectiveBetween(Byte value1, Byte value2) {
			addCriterion("HOUSE_TO_EFFECTIVE between", value1, value2, "houseToEffective");
			return (Criteria) this;
		}

		public Criteria andHouseToEffectiveNotBetween(Byte value1, Byte value2) {
			addCriterion("HOUSE_TO_EFFECTIVE not between", value1, value2, "houseToEffective");
			return (Criteria) this;
		}

		public Criteria andCustomerAddIsNull() {
			addCriterion("CUSTOMER_ADD is null");
			return (Criteria) this;
		}

		public Criteria andCustomerAddIsNotNull() {
			addCriterion("CUSTOMER_ADD is not null");
			return (Criteria) this;
		}

		public Criteria andCustomerAddEqualTo(Byte value) {
			addCriterion("CUSTOMER_ADD =", value, "customerAdd");
			return (Criteria) this;
		}

		public Criteria andCustomerAddNotEqualTo(Byte value) {
			addCriterion("CUSTOMER_ADD <>", value, "customerAdd");
			return (Criteria) this;
		}

		public Criteria andCustomerAddGreaterThan(Byte value) {
			addCriterion("CUSTOMER_ADD >", value, "customerAdd");
			return (Criteria) this;
		}

		public Criteria andCustomerAddGreaterThanOrEqualTo(Byte value) {
			addCriterion("CUSTOMER_ADD >=", value, "customerAdd");
			return (Criteria) this;
		}

		public Criteria andCustomerAddLessThan(Byte value) {
			addCriterion("CUSTOMER_ADD <", value, "customerAdd");
			return (Criteria) this;
		}

		public Criteria andCustomerAddLessThanOrEqualTo(Byte value) {
			addCriterion("CUSTOMER_ADD <=", value, "customerAdd");
			return (Criteria) this;
		}

		public Criteria andCustomerAddIn(List<Byte> values) {
			addCriterion("CUSTOMER_ADD in", values, "customerAdd");
			return (Criteria) this;
		}

		public Criteria andCustomerAddNotIn(List<Byte> values) {
			addCriterion("CUSTOMER_ADD not in", values, "customerAdd");
			return (Criteria) this;
		}

		public Criteria andCustomerAddBetween(Byte value1, Byte value2) {
			addCriterion("CUSTOMER_ADD between", value1, value2, "customerAdd");
			return (Criteria) this;
		}

		public Criteria andCustomerAddNotBetween(Byte value1, Byte value2) {
			addCriterion("CUSTOMER_ADD not between", value1, value2, "customerAdd");
			return (Criteria) this;
		}

		public Criteria andCustomerPubPriIsNull() {
			addCriterion("CUSTOMER_PUB_PRI is null");
			return (Criteria) this;
		}

		public Criteria andCustomerPubPriIsNotNull() {
			addCriterion("CUSTOMER_PUB_PRI is not null");
			return (Criteria) this;
		}

		public Criteria andCustomerPubPriEqualTo(Byte value) {
			addCriterion("CUSTOMER_PUB_PRI =", value, "customerPubPri");
			return (Criteria) this;
		}

		public Criteria andCustomerPubPriNotEqualTo(Byte value) {
			addCriterion("CUSTOMER_PUB_PRI <>", value, "customerPubPri");
			return (Criteria) this;
		}

		public Criteria andCustomerPubPriGreaterThan(Byte value) {
			addCriterion("CUSTOMER_PUB_PRI >", value, "customerPubPri");
			return (Criteria) this;
		}

		public Criteria andCustomerPubPriGreaterThanOrEqualTo(Byte value) {
			addCriterion("CUSTOMER_PUB_PRI >=", value, "customerPubPri");
			return (Criteria) this;
		}

		public Criteria andCustomerPubPriLessThan(Byte value) {
			addCriterion("CUSTOMER_PUB_PRI <", value, "customerPubPri");
			return (Criteria) this;
		}

		public Criteria andCustomerPubPriLessThanOrEqualTo(Byte value) {
			addCriterion("CUSTOMER_PUB_PRI <=", value, "customerPubPri");
			return (Criteria) this;
		}

		public Criteria andCustomerPubPriIn(List<Byte> values) {
			addCriterion("CUSTOMER_PUB_PRI in", values, "customerPubPri");
			return (Criteria) this;
		}

		public Criteria andCustomerPubPriNotIn(List<Byte> values) {
			addCriterion("CUSTOMER_PUB_PRI not in", values, "customerPubPri");
			return (Criteria) this;
		}

		public Criteria andCustomerPubPriBetween(Byte value1, Byte value2) {
			addCriterion("CUSTOMER_PUB_PRI between", value1, value2, "customerPubPri");
			return (Criteria) this;
		}

		public Criteria andCustomerPubPriNotBetween(Byte value1, Byte value2) {
			addCriterion("CUSTOMER_PUB_PRI not between", value1, value2, "customerPubPri");
			return (Criteria) this;
		}

		public Criteria andCustomerSharePriIsNull() {
			addCriterion("CUSTOMER_SHARE_PRI is null");
			return (Criteria) this;
		}

		public Criteria andCustomerSharePriIsNotNull() {
			addCriterion("CUSTOMER_SHARE_PRI is not null");
			return (Criteria) this;
		}

		public Criteria andCustomerSharePriEqualTo(Byte value) {
			addCriterion("CUSTOMER_SHARE_PRI =", value, "customerSharePri");
			return (Criteria) this;
		}

		public Criteria andCustomerSharePriNotEqualTo(Byte value) {
			addCriterion("CUSTOMER_SHARE_PRI <>", value, "customerSharePri");
			return (Criteria) this;
		}

		public Criteria andCustomerSharePriGreaterThan(Byte value) {
			addCriterion("CUSTOMER_SHARE_PRI >", value, "customerSharePri");
			return (Criteria) this;
		}

		public Criteria andCustomerSharePriGreaterThanOrEqualTo(Byte value) {
			addCriterion("CUSTOMER_SHARE_PRI >=", value, "customerSharePri");
			return (Criteria) this;
		}

		public Criteria andCustomerSharePriLessThan(Byte value) {
			addCriterion("CUSTOMER_SHARE_PRI <", value, "customerSharePri");
			return (Criteria) this;
		}

		public Criteria andCustomerSharePriLessThanOrEqualTo(Byte value) {
			addCriterion("CUSTOMER_SHARE_PRI <=", value, "customerSharePri");
			return (Criteria) this;
		}

		public Criteria andCustomerSharePriIn(List<Byte> values) {
			addCriterion("CUSTOMER_SHARE_PRI in", values, "customerSharePri");
			return (Criteria) this;
		}

		public Criteria andCustomerSharePriNotIn(List<Byte> values) {
			addCriterion("CUSTOMER_SHARE_PRI not in", values, "customerSharePri");
			return (Criteria) this;
		}

		public Criteria andCustomerSharePriBetween(Byte value1, Byte value2) {
			addCriterion("CUSTOMER_SHARE_PRI between", value1, value2, "customerSharePri");
			return (Criteria) this;
		}

		public Criteria andCustomerSharePriNotBetween(Byte value1, Byte value2) {
			addCriterion("CUSTOMER_SHARE_PRI not between", value1, value2, "customerSharePri");
			return (Criteria) this;
		}

		public Criteria andCustomerToEffectiveIsNull() {
			addCriterion("CUSTOMER_TO_EFFECTIVE is null");
			return (Criteria) this;
		}

		public Criteria andCustomerToEffectiveIsNotNull() {
			addCriterion("CUSTOMER_TO_EFFECTIVE is not null");
			return (Criteria) this;
		}

		public Criteria andCustomerToEffectiveEqualTo(Byte value) {
			addCriterion("CUSTOMER_TO_EFFECTIVE =", value, "customerToEffective");
			return (Criteria) this;
		}

		public Criteria andCustomerToEffectiveNotEqualTo(Byte value) {
			addCriterion("CUSTOMER_TO_EFFECTIVE <>", value, "customerToEffective");
			return (Criteria) this;
		}

		public Criteria andCustomerToEffectiveGreaterThan(Byte value) {
			addCriterion("CUSTOMER_TO_EFFECTIVE >", value, "customerToEffective");
			return (Criteria) this;
		}

		public Criteria andCustomerToEffectiveGreaterThanOrEqualTo(Byte value) {
			addCriterion("CUSTOMER_TO_EFFECTIVE >=", value, "customerToEffective");
			return (Criteria) this;
		}

		public Criteria andCustomerToEffectiveLessThan(Byte value) {
			addCriterion("CUSTOMER_TO_EFFECTIVE <", value, "customerToEffective");
			return (Criteria) this;
		}

		public Criteria andCustomerToEffectiveLessThanOrEqualTo(Byte value) {
			addCriterion("CUSTOMER_TO_EFFECTIVE <=", value, "customerToEffective");
			return (Criteria) this;
		}

		public Criteria andCustomerToEffectiveIn(List<Byte> values) {
			addCriterion("CUSTOMER_TO_EFFECTIVE in", values, "customerToEffective");
			return (Criteria) this;
		}

		public Criteria andCustomerToEffectiveNotIn(List<Byte> values) {
			addCriterion("CUSTOMER_TO_EFFECTIVE not in", values, "customerToEffective");
			return (Criteria) this;
		}

		public Criteria andCustomerToEffectiveBetween(Byte value1, Byte value2) {
			addCriterion("CUSTOMER_TO_EFFECTIVE between", value1, value2, "customerToEffective");
			return (Criteria) this;
		}

		public Criteria andCustomerToEffectiveNotBetween(Byte value1, Byte value2) {
			addCriterion("CUSTOMER_TO_EFFECTIVE not between", value1, value2, "customerToEffective");
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

		public Criteria andUpdateTimeIsNull() {
			addCriterion("UPDATE_TIME is null");
			return (Criteria) this;
		}

		public Criteria andUpdateTimeIsNotNull() {
			addCriterion("UPDATE_TIME is not null");
			return (Criteria) this;
		}

		public Criteria andUpdateTimeEqualTo(Date value) {
			addCriterion("UPDATE_TIME =", value, "updateTime");
			return (Criteria) this;
		}

		public Criteria andUpdateTimeNotEqualTo(Date value) {
			addCriterion("UPDATE_TIME <>", value, "updateTime");
			return (Criteria) this;
		}

		public Criteria andUpdateTimeGreaterThan(Date value) {
			addCriterion("UPDATE_TIME >", value, "updateTime");
			return (Criteria) this;
		}

		public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
			addCriterion("UPDATE_TIME >=", value, "updateTime");
			return (Criteria) this;
		}

		public Criteria andUpdateTimeLessThan(Date value) {
			addCriterion("UPDATE_TIME <", value, "updateTime");
			return (Criteria) this;
		}

		public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
			addCriterion("UPDATE_TIME <=", value, "updateTime");
			return (Criteria) this;
		}

		public Criteria andUpdateTimeIn(List<Date> values) {
			addCriterion("UPDATE_TIME in", values, "updateTime");
			return (Criteria) this;
		}

		public Criteria andUpdateTimeNotIn(List<Date> values) {
			addCriterion("UPDATE_TIME not in", values, "updateTime");
			return (Criteria) this;
		}

		public Criteria andUpdateTimeBetween(Date value1, Date value2) {
			addCriterion("UPDATE_TIME between", value1, value2, "updateTime");
			return (Criteria) this;
		}

		public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
			addCriterion("UPDATE_TIME not between", value1, value2, "updateTime");
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

		public Criteria andHouseCancelRespiteIsNull() {
			addCriterion("HOUSE_CANCEL_RESPITE is null");
			return (Criteria) this;
		}

		public Criteria andHouseCancelRespiteIsNotNull() {
			addCriterion("HOUSE_CANCEL_RESPITE is not null");
			return (Criteria) this;
		}

		public Criteria andHouseCancelRespiteEqualTo(Byte value) {
			addCriterion("HOUSE_CANCEL_RESPITE =", value, "houseCancelRespite");
			return (Criteria) this;
		}

		public Criteria andHouseCancelRespiteNotEqualTo(Byte value) {
			addCriterion("HOUSE_CANCEL_RESPITE <>", value, "houseCancelRespite");
			return (Criteria) this;
		}

		public Criteria andHouseCancelRespiteGreaterThan(Byte value) {
			addCriterion("HOUSE_CANCEL_RESPITE >", value, "houseCancelRespite");
			return (Criteria) this;
		}

		public Criteria andHouseCancelRespiteGreaterThanOrEqualTo(Byte value) {
			addCriterion("HOUSE_CANCEL_RESPITE >=", value, "houseCancelRespite");
			return (Criteria) this;
		}

		public Criteria andHouseCancelRespiteLessThan(Byte value) {
			addCriterion("HOUSE_CANCEL_RESPITE <", value, "houseCancelRespite");
			return (Criteria) this;
		}

		public Criteria andHouseCancelRespiteLessThanOrEqualTo(Byte value) {
			addCriterion("HOUSE_CANCEL_RESPITE <=", value, "houseCancelRespite");
			return (Criteria) this;
		}

		public Criteria andHouseCancelRespiteIn(List<Byte> values) {
			addCriterion("HOUSE_CANCEL_RESPITE in", values, "houseCancelRespite");
			return (Criteria) this;
		}

		public Criteria andHouseCancelRespiteNotIn(List<Byte> values) {
			addCriterion("HOUSE_CANCEL_RESPITE not in", values, "houseCancelRespite");
			return (Criteria) this;
		}

		public Criteria andHouseCancelRespiteBetween(Byte value1, Byte value2) {
			addCriterion("HOUSE_CANCEL_RESPITE between", value1, value2, "houseCancelRespite");
			return (Criteria) this;
		}

		public Criteria andHouseCancelRespiteNotBetween(Byte value1, Byte value2) {
			addCriterion("HOUSE_CANCEL_RESPITE not between", value1, value2, "houseCancelRespite");
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