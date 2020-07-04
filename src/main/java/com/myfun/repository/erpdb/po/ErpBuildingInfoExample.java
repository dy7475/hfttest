package com.myfun.repository.erpdb.po;

import com.myfun.repository.support.generator.shard.ShardDb;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.math.BigDecimal;

public class ErpBuildingInfoExample extends ShardDb {
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
	public ErpBuildingInfoExample() {
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

		public Criteria andCityIdIsNull() {
			addCriterion("CITY_ID is null");
			return (Criteria) this;
		}

		public Criteria andCityIdIsNotNull() {
			addCriterion("CITY_ID is not null");
			return (Criteria) this;
		}

		public Criteria andCityIdEqualTo(Short value) {
			addCriterion("CITY_ID =", value, "cityId");
			return (Criteria) this;
		}

		public Criteria andCityIdNotEqualTo(Short value) {
			addCriterion("CITY_ID <>", value, "cityId");
			return (Criteria) this;
		}

		public Criteria andCityIdGreaterThan(Short value) {
			addCriterion("CITY_ID >", value, "cityId");
			return (Criteria) this;
		}

		public Criteria andCityIdGreaterThanOrEqualTo(Short value) {
			addCriterion("CITY_ID >=", value, "cityId");
			return (Criteria) this;
		}

		public Criteria andCityIdLessThan(Short value) {
			addCriterion("CITY_ID <", value, "cityId");
			return (Criteria) this;
		}

		public Criteria andCityIdLessThanOrEqualTo(Short value) {
			addCriterion("CITY_ID <=", value, "cityId");
			return (Criteria) this;
		}

		public Criteria andCityIdIn(List<Short> values) {
			addCriterion("CITY_ID in", values, "cityId");
			return (Criteria) this;
		}

		public Criteria andCityIdNotIn(List<Short> values) {
			addCriterion("CITY_ID not in", values, "cityId");
			return (Criteria) this;
		}

		public Criteria andCityIdBetween(Short value1, Short value2) {
			addCriterion("CITY_ID between", value1, value2, "cityId");
			return (Criteria) this;
		}

		public Criteria andCityIdNotBetween(Short value1, Short value2) {
			addCriterion("CITY_ID not between", value1, value2, "cityId");
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

		public Criteria andBuildCodeIsNull() {
			addCriterion("BUILD_CODE is null");
			return (Criteria) this;
		}

		public Criteria andBuildCodeIsNotNull() {
			addCriterion("BUILD_CODE is not null");
			return (Criteria) this;
		}

		public Criteria andBuildCodeEqualTo(String value) {
			addCriterion("BUILD_CODE =", value, "buildCode");
			return (Criteria) this;
		}

		public Criteria andBuildCodeNotEqualTo(String value) {
			addCriterion("BUILD_CODE <>", value, "buildCode");
			return (Criteria) this;
		}

		public Criteria andBuildCodeGreaterThan(String value) {
			addCriterion("BUILD_CODE >", value, "buildCode");
			return (Criteria) this;
		}

		public Criteria andBuildCodeGreaterThanOrEqualTo(String value) {
			addCriterion("BUILD_CODE >=", value, "buildCode");
			return (Criteria) this;
		}

		public Criteria andBuildCodeLessThan(String value) {
			addCriterion("BUILD_CODE <", value, "buildCode");
			return (Criteria) this;
		}

		public Criteria andBuildCodeLessThanOrEqualTo(String value) {
			addCriterion("BUILD_CODE <=", value, "buildCode");
			return (Criteria) this;
		}

		public Criteria andBuildCodeLike(String value) {
			addCriterion("BUILD_CODE like", value, "buildCode");
			return (Criteria) this;
		}

		public Criteria andBuildCodeNotLike(String value) {
			addCriterion("BUILD_CODE not like", value, "buildCode");
			return (Criteria) this;
		}

		public Criteria andBuildCodeIn(List<String> values) {
			addCriterion("BUILD_CODE in", values, "buildCode");
			return (Criteria) this;
		}

		public Criteria andBuildCodeNotIn(List<String> values) {
			addCriterion("BUILD_CODE not in", values, "buildCode");
			return (Criteria) this;
		}

		public Criteria andBuildCodeBetween(String value1, String value2) {
			addCriterion("BUILD_CODE between", value1, value2, "buildCode");
			return (Criteria) this;
		}

		public Criteria andBuildCodeNotBetween(String value1, String value2) {
			addCriterion("BUILD_CODE not between", value1, value2, "buildCode");
			return (Criteria) this;
		}

		public Criteria andBuildDevloperIsNull() {
			addCriterion("BUILD_DEVLOPER is null");
			return (Criteria) this;
		}

		public Criteria andBuildDevloperIsNotNull() {
			addCriterion("BUILD_DEVLOPER is not null");
			return (Criteria) this;
		}

		public Criteria andBuildDevloperEqualTo(String value) {
			addCriterion("BUILD_DEVLOPER =", value, "buildDevloper");
			return (Criteria) this;
		}

		public Criteria andBuildDevloperNotEqualTo(String value) {
			addCriterion("BUILD_DEVLOPER <>", value, "buildDevloper");
			return (Criteria) this;
		}

		public Criteria andBuildDevloperGreaterThan(String value) {
			addCriterion("BUILD_DEVLOPER >", value, "buildDevloper");
			return (Criteria) this;
		}

		public Criteria andBuildDevloperGreaterThanOrEqualTo(String value) {
			addCriterion("BUILD_DEVLOPER >=", value, "buildDevloper");
			return (Criteria) this;
		}

		public Criteria andBuildDevloperLessThan(String value) {
			addCriterion("BUILD_DEVLOPER <", value, "buildDevloper");
			return (Criteria) this;
		}

		public Criteria andBuildDevloperLessThanOrEqualTo(String value) {
			addCriterion("BUILD_DEVLOPER <=", value, "buildDevloper");
			return (Criteria) this;
		}

		public Criteria andBuildDevloperLike(String value) {
			addCriterion("BUILD_DEVLOPER like", value, "buildDevloper");
			return (Criteria) this;
		}

		public Criteria andBuildDevloperNotLike(String value) {
			addCriterion("BUILD_DEVLOPER not like", value, "buildDevloper");
			return (Criteria) this;
		}

		public Criteria andBuildDevloperIn(List<String> values) {
			addCriterion("BUILD_DEVLOPER in", values, "buildDevloper");
			return (Criteria) this;
		}

		public Criteria andBuildDevloperNotIn(List<String> values) {
			addCriterion("BUILD_DEVLOPER not in", values, "buildDevloper");
			return (Criteria) this;
		}

		public Criteria andBuildDevloperBetween(String value1, String value2) {
			addCriterion("BUILD_DEVLOPER between", value1, value2, "buildDevloper");
			return (Criteria) this;
		}

		public Criteria andBuildDevloperNotBetween(String value1, String value2) {
			addCriterion("BUILD_DEVLOPER not between", value1, value2, "buildDevloper");
			return (Criteria) this;
		}

		public Criteria andBuildAddrIsNull() {
			addCriterion("BUILD_ADDR is null");
			return (Criteria) this;
		}

		public Criteria andBuildAddrIsNotNull() {
			addCriterion("BUILD_ADDR is not null");
			return (Criteria) this;
		}

		public Criteria andBuildAddrEqualTo(String value) {
			addCriterion("BUILD_ADDR =", value, "buildAddr");
			return (Criteria) this;
		}

		public Criteria andBuildAddrNotEqualTo(String value) {
			addCriterion("BUILD_ADDR <>", value, "buildAddr");
			return (Criteria) this;
		}

		public Criteria andBuildAddrGreaterThan(String value) {
			addCriterion("BUILD_ADDR >", value, "buildAddr");
			return (Criteria) this;
		}

		public Criteria andBuildAddrGreaterThanOrEqualTo(String value) {
			addCriterion("BUILD_ADDR >=", value, "buildAddr");
			return (Criteria) this;
		}

		public Criteria andBuildAddrLessThan(String value) {
			addCriterion("BUILD_ADDR <", value, "buildAddr");
			return (Criteria) this;
		}

		public Criteria andBuildAddrLessThanOrEqualTo(String value) {
			addCriterion("BUILD_ADDR <=", value, "buildAddr");
			return (Criteria) this;
		}

		public Criteria andBuildAddrLike(String value) {
			addCriterion("BUILD_ADDR like", value, "buildAddr");
			return (Criteria) this;
		}

		public Criteria andBuildAddrNotLike(String value) {
			addCriterion("BUILD_ADDR not like", value, "buildAddr");
			return (Criteria) this;
		}

		public Criteria andBuildAddrIn(List<String> values) {
			addCriterion("BUILD_ADDR in", values, "buildAddr");
			return (Criteria) this;
		}

		public Criteria andBuildAddrNotIn(List<String> values) {
			addCriterion("BUILD_ADDR not in", values, "buildAddr");
			return (Criteria) this;
		}

		public Criteria andBuildAddrBetween(String value1, String value2) {
			addCriterion("BUILD_ADDR between", value1, value2, "buildAddr");
			return (Criteria) this;
		}

		public Criteria andBuildAddrNotBetween(String value1, String value2) {
			addCriterion("BUILD_ADDR not between", value1, value2, "buildAddr");
			return (Criteria) this;
		}

		public Criteria andBuildRegionIsNull() {
			addCriterion("BUILD_REGION is null");
			return (Criteria) this;
		}

		public Criteria andBuildRegionIsNotNull() {
			addCriterion("BUILD_REGION is not null");
			return (Criteria) this;
		}

		public Criteria andBuildRegionEqualTo(Integer value) {
			addCriterion("BUILD_REGION =", value, "buildRegion");
			return (Criteria) this;
		}

		public Criteria andBuildRegionNotEqualTo(Integer value) {
			addCriterion("BUILD_REGION <>", value, "buildRegion");
			return (Criteria) this;
		}

		public Criteria andBuildRegionGreaterThan(Integer value) {
			addCriterion("BUILD_REGION >", value, "buildRegion");
			return (Criteria) this;
		}

		public Criteria andBuildRegionGreaterThanOrEqualTo(Integer value) {
			addCriterion("BUILD_REGION >=", value, "buildRegion");
			return (Criteria) this;
		}

		public Criteria andBuildRegionLessThan(Integer value) {
			addCriterion("BUILD_REGION <", value, "buildRegion");
			return (Criteria) this;
		}

		public Criteria andBuildRegionLessThanOrEqualTo(Integer value) {
			addCriterion("BUILD_REGION <=", value, "buildRegion");
			return (Criteria) this;
		}

		public Criteria andBuildRegionIn(List<Integer> values) {
			addCriterion("BUILD_REGION in", values, "buildRegion");
			return (Criteria) this;
		}

		public Criteria andBuildRegionNotIn(List<Integer> values) {
			addCriterion("BUILD_REGION not in", values, "buildRegion");
			return (Criteria) this;
		}

		public Criteria andBuildRegionBetween(Integer value1, Integer value2) {
			addCriterion("BUILD_REGION between", value1, value2, "buildRegion");
			return (Criteria) this;
		}

		public Criteria andBuildRegionNotBetween(Integer value1, Integer value2) {
			addCriterion("BUILD_REGION not between", value1, value2, "buildRegion");
			return (Criteria) this;
		}

		public Criteria andSectionIdIsNull() {
			addCriterion("SECTION_ID is null");
			return (Criteria) this;
		}

		public Criteria andSectionIdIsNotNull() {
			addCriterion("SECTION_ID is not null");
			return (Criteria) this;
		}

		public Criteria andSectionIdEqualTo(Integer value) {
			addCriterion("SECTION_ID =", value, "sectionId");
			return (Criteria) this;
		}

		public Criteria andSectionIdNotEqualTo(Integer value) {
			addCriterion("SECTION_ID <>", value, "sectionId");
			return (Criteria) this;
		}

		public Criteria andSectionIdGreaterThan(Integer value) {
			addCriterion("SECTION_ID >", value, "sectionId");
			return (Criteria) this;
		}

		public Criteria andSectionIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("SECTION_ID >=", value, "sectionId");
			return (Criteria) this;
		}

		public Criteria andSectionIdLessThan(Integer value) {
			addCriterion("SECTION_ID <", value, "sectionId");
			return (Criteria) this;
		}

		public Criteria andSectionIdLessThanOrEqualTo(Integer value) {
			addCriterion("SECTION_ID <=", value, "sectionId");
			return (Criteria) this;
		}

		public Criteria andSectionIdIn(List<Integer> values) {
			addCriterion("SECTION_ID in", values, "sectionId");
			return (Criteria) this;
		}

		public Criteria andSectionIdNotIn(List<Integer> values) {
			addCriterion("SECTION_ID not in", values, "sectionId");
			return (Criteria) this;
		}

		public Criteria andSectionIdBetween(Integer value1, Integer value2) {
			addCriterion("SECTION_ID between", value1, value2, "sectionId");
			return (Criteria) this;
		}

		public Criteria andSectionIdNotBetween(Integer value1, Integer value2) {
			addCriterion("SECTION_ID not between", value1, value2, "sectionId");
			return (Criteria) this;
		}

		public Criteria andBuildRoundIsNull() {
			addCriterion("BUILD_ROUND is null");
			return (Criteria) this;
		}

		public Criteria andBuildRoundIsNotNull() {
			addCriterion("BUILD_ROUND is not null");
			return (Criteria) this;
		}

		public Criteria andBuildRoundEqualTo(Byte value) {
			addCriterion("BUILD_ROUND =", value, "buildRound");
			return (Criteria) this;
		}

		public Criteria andBuildRoundNotEqualTo(Byte value) {
			addCriterion("BUILD_ROUND <>", value, "buildRound");
			return (Criteria) this;
		}

		public Criteria andBuildRoundGreaterThan(Byte value) {
			addCriterion("BUILD_ROUND >", value, "buildRound");
			return (Criteria) this;
		}

		public Criteria andBuildRoundGreaterThanOrEqualTo(Byte value) {
			addCriterion("BUILD_ROUND >=", value, "buildRound");
			return (Criteria) this;
		}

		public Criteria andBuildRoundLessThan(Byte value) {
			addCriterion("BUILD_ROUND <", value, "buildRound");
			return (Criteria) this;
		}

		public Criteria andBuildRoundLessThanOrEqualTo(Byte value) {
			addCriterion("BUILD_ROUND <=", value, "buildRound");
			return (Criteria) this;
		}

		public Criteria andBuildRoundIn(List<Byte> values) {
			addCriterion("BUILD_ROUND in", values, "buildRound");
			return (Criteria) this;
		}

		public Criteria andBuildRoundNotIn(List<Byte> values) {
			addCriterion("BUILD_ROUND not in", values, "buildRound");
			return (Criteria) this;
		}

		public Criteria andBuildRoundBetween(Byte value1, Byte value2) {
			addCriterion("BUILD_ROUND between", value1, value2, "buildRound");
			return (Criteria) this;
		}

		public Criteria andBuildRoundNotBetween(Byte value1, Byte value2) {
			addCriterion("BUILD_ROUND not between", value1, value2, "buildRound");
			return (Criteria) this;
		}

		public Criteria andSubwayIdsIsNull() {
			addCriterion("SUBWAY_IDS is null");
			return (Criteria) this;
		}

		public Criteria andSubwayIdsIsNotNull() {
			addCriterion("SUBWAY_IDS is not null");
			return (Criteria) this;
		}

		public Criteria andSubwayIdsEqualTo(String value) {
			addCriterion("SUBWAY_IDS =", value, "subwayIds");
			return (Criteria) this;
		}

		public Criteria andSubwayIdsNotEqualTo(String value) {
			addCriterion("SUBWAY_IDS <>", value, "subwayIds");
			return (Criteria) this;
		}

		public Criteria andSubwayIdsGreaterThan(String value) {
			addCriterion("SUBWAY_IDS >", value, "subwayIds");
			return (Criteria) this;
		}

		public Criteria andSubwayIdsGreaterThanOrEqualTo(String value) {
			addCriterion("SUBWAY_IDS >=", value, "subwayIds");
			return (Criteria) this;
		}

		public Criteria andSubwayIdsLessThan(String value) {
			addCriterion("SUBWAY_IDS <", value, "subwayIds");
			return (Criteria) this;
		}

		public Criteria andSubwayIdsLessThanOrEqualTo(String value) {
			addCriterion("SUBWAY_IDS <=", value, "subwayIds");
			return (Criteria) this;
		}

		public Criteria andSubwayIdsLike(String value) {
			addCriterion("SUBWAY_IDS like", value, "subwayIds");
			return (Criteria) this;
		}

		public Criteria andSubwayIdsNotLike(String value) {
			addCriterion("SUBWAY_IDS not like", value, "subwayIds");
			return (Criteria) this;
		}

		public Criteria andSubwayIdsIn(List<String> values) {
			addCriterion("SUBWAY_IDS in", values, "subwayIds");
			return (Criteria) this;
		}

		public Criteria andSubwayIdsNotIn(List<String> values) {
			addCriterion("SUBWAY_IDS not in", values, "subwayIds");
			return (Criteria) this;
		}

		public Criteria andSubwayIdsBetween(String value1, String value2) {
			addCriterion("SUBWAY_IDS between", value1, value2, "subwayIds");
			return (Criteria) this;
		}

		public Criteria andSubwayIdsNotBetween(String value1, String value2) {
			addCriterion("SUBWAY_IDS not between", value1, value2, "subwayIds");
			return (Criteria) this;
		}

		public Criteria andStationIdsIsNull() {
			addCriterion("STATION_IDS is null");
			return (Criteria) this;
		}

		public Criteria andStationIdsIsNotNull() {
			addCriterion("STATION_IDS is not null");
			return (Criteria) this;
		}

		public Criteria andStationIdsEqualTo(String value) {
			addCriterion("STATION_IDS =", value, "stationIds");
			return (Criteria) this;
		}

		public Criteria andStationIdsNotEqualTo(String value) {
			addCriterion("STATION_IDS <>", value, "stationIds");
			return (Criteria) this;
		}

		public Criteria andStationIdsGreaterThan(String value) {
			addCriterion("STATION_IDS >", value, "stationIds");
			return (Criteria) this;
		}

		public Criteria andStationIdsGreaterThanOrEqualTo(String value) {
			addCriterion("STATION_IDS >=", value, "stationIds");
			return (Criteria) this;
		}

		public Criteria andStationIdsLessThan(String value) {
			addCriterion("STATION_IDS <", value, "stationIds");
			return (Criteria) this;
		}

		public Criteria andStationIdsLessThanOrEqualTo(String value) {
			addCriterion("STATION_IDS <=", value, "stationIds");
			return (Criteria) this;
		}

		public Criteria andStationIdsLike(String value) {
			addCriterion("STATION_IDS like", value, "stationIds");
			return (Criteria) this;
		}

		public Criteria andStationIdsNotLike(String value) {
			addCriterion("STATION_IDS not like", value, "stationIds");
			return (Criteria) this;
		}

		public Criteria andStationIdsIn(List<String> values) {
			addCriterion("STATION_IDS in", values, "stationIds");
			return (Criteria) this;
		}

		public Criteria andStationIdsNotIn(List<String> values) {
			addCriterion("STATION_IDS not in", values, "stationIds");
			return (Criteria) this;
		}

		public Criteria andStationIdsBetween(String value1, String value2) {
			addCriterion("STATION_IDS between", value1, value2, "stationIds");
			return (Criteria) this;
		}

		public Criteria andStationIdsNotBetween(String value1, String value2) {
			addCriterion("STATION_IDS not between", value1, value2, "stationIds");
			return (Criteria) this;
		}

		public Criteria andAddCaseIsNull() {
			addCriterion("ADD_CASE is null");
			return (Criteria) this;
		}

		public Criteria andAddCaseIsNotNull() {
			addCriterion("ADD_CASE is not null");
			return (Criteria) this;
		}

		public Criteria andAddCaseEqualTo(String value) {
			addCriterion("ADD_CASE =", value, "addCase");
			return (Criteria) this;
		}

		public Criteria andAddCaseNotEqualTo(String value) {
			addCriterion("ADD_CASE <>", value, "addCase");
			return (Criteria) this;
		}

		public Criteria andAddCaseGreaterThan(String value) {
			addCriterion("ADD_CASE >", value, "addCase");
			return (Criteria) this;
		}

		public Criteria andAddCaseGreaterThanOrEqualTo(String value) {
			addCriterion("ADD_CASE >=", value, "addCase");
			return (Criteria) this;
		}

		public Criteria andAddCaseLessThan(String value) {
			addCriterion("ADD_CASE <", value, "addCase");
			return (Criteria) this;
		}

		public Criteria andAddCaseLessThanOrEqualTo(String value) {
			addCriterion("ADD_CASE <=", value, "addCase");
			return (Criteria) this;
		}

		public Criteria andAddCaseLike(String value) {
			addCriterion("ADD_CASE like", value, "addCase");
			return (Criteria) this;
		}

		public Criteria andAddCaseNotLike(String value) {
			addCriterion("ADD_CASE not like", value, "addCase");
			return (Criteria) this;
		}

		public Criteria andAddCaseIn(List<String> values) {
			addCriterion("ADD_CASE in", values, "addCase");
			return (Criteria) this;
		}

		public Criteria andAddCaseNotIn(List<String> values) {
			addCriterion("ADD_CASE not in", values, "addCase");
			return (Criteria) this;
		}

		public Criteria andAddCaseBetween(String value1, String value2) {
			addCriterion("ADD_CASE between", value1, value2, "addCase");
			return (Criteria) this;
		}

		public Criteria andAddCaseNotBetween(String value1, String value2) {
			addCriterion("ADD_CASE not between", value1, value2, "addCase");
			return (Criteria) this;
		}

		public Criteria andRightConductIsNull() {
			addCriterion("RIGHT_CONDUCT is null");
			return (Criteria) this;
		}

		public Criteria andRightConductIsNotNull() {
			addCriterion("RIGHT_CONDUCT is not null");
			return (Criteria) this;
		}

		public Criteria andRightConductEqualTo(String value) {
			addCriterion("RIGHT_CONDUCT =", value, "rightConduct");
			return (Criteria) this;
		}

		public Criteria andRightConductNotEqualTo(String value) {
			addCriterion("RIGHT_CONDUCT <>", value, "rightConduct");
			return (Criteria) this;
		}

		public Criteria andRightConductGreaterThan(String value) {
			addCriterion("RIGHT_CONDUCT >", value, "rightConduct");
			return (Criteria) this;
		}

		public Criteria andRightConductGreaterThanOrEqualTo(String value) {
			addCriterion("RIGHT_CONDUCT >=", value, "rightConduct");
			return (Criteria) this;
		}

		public Criteria andRightConductLessThan(String value) {
			addCriterion("RIGHT_CONDUCT <", value, "rightConduct");
			return (Criteria) this;
		}

		public Criteria andRightConductLessThanOrEqualTo(String value) {
			addCriterion("RIGHT_CONDUCT <=", value, "rightConduct");
			return (Criteria) this;
		}

		public Criteria andRightConductLike(String value) {
			addCriterion("RIGHT_CONDUCT like", value, "rightConduct");
			return (Criteria) this;
		}

		public Criteria andRightConductNotLike(String value) {
			addCriterion("RIGHT_CONDUCT not like", value, "rightConduct");
			return (Criteria) this;
		}

		public Criteria andRightConductIn(List<String> values) {
			addCriterion("RIGHT_CONDUCT in", values, "rightConduct");
			return (Criteria) this;
		}

		public Criteria andRightConductNotIn(List<String> values) {
			addCriterion("RIGHT_CONDUCT not in", values, "rightConduct");
			return (Criteria) this;
		}

		public Criteria andRightConductBetween(String value1, String value2) {
			addCriterion("RIGHT_CONDUCT between", value1, value2, "rightConduct");
			return (Criteria) this;
		}

		public Criteria andRightConductNotBetween(String value1, String value2) {
			addCriterion("RIGHT_CONDUCT not between", value1, value2, "rightConduct");
			return (Criteria) this;
		}

		public Criteria andBuildTypeIsNull() {
			addCriterion("BUILD_TYPE is null");
			return (Criteria) this;
		}

		public Criteria andBuildTypeIsNotNull() {
			addCriterion("BUILD_TYPE is not null");
			return (Criteria) this;
		}

		public Criteria andBuildTypeEqualTo(String value) {
			addCriterion("BUILD_TYPE =", value, "buildType");
			return (Criteria) this;
		}

		public Criteria andBuildTypeNotEqualTo(String value) {
			addCriterion("BUILD_TYPE <>", value, "buildType");
			return (Criteria) this;
		}

		public Criteria andBuildTypeGreaterThan(String value) {
			addCriterion("BUILD_TYPE >", value, "buildType");
			return (Criteria) this;
		}

		public Criteria andBuildTypeGreaterThanOrEqualTo(String value) {
			addCriterion("BUILD_TYPE >=", value, "buildType");
			return (Criteria) this;
		}

		public Criteria andBuildTypeLessThan(String value) {
			addCriterion("BUILD_TYPE <", value, "buildType");
			return (Criteria) this;
		}

		public Criteria andBuildTypeLessThanOrEqualTo(String value) {
			addCriterion("BUILD_TYPE <=", value, "buildType");
			return (Criteria) this;
		}

		public Criteria andBuildTypeLike(String value) {
			addCriterion("BUILD_TYPE like", value, "buildType");
			return (Criteria) this;
		}

		public Criteria andBuildTypeNotLike(String value) {
			addCriterion("BUILD_TYPE not like", value, "buildType");
			return (Criteria) this;
		}

		public Criteria andBuildTypeIn(List<String> values) {
			addCriterion("BUILD_TYPE in", values, "buildType");
			return (Criteria) this;
		}

		public Criteria andBuildTypeNotIn(List<String> values) {
			addCriterion("BUILD_TYPE not in", values, "buildType");
			return (Criteria) this;
		}

		public Criteria andBuildTypeBetween(String value1, String value2) {
			addCriterion("BUILD_TYPE between", value1, value2, "buildType");
			return (Criteria) this;
		}

		public Criteria andBuildTypeNotBetween(String value1, String value2) {
			addCriterion("BUILD_TYPE not between", value1, value2, "buildType");
			return (Criteria) this;
		}

		public Criteria andBuildDateIsNull() {
			addCriterion("BUILD_DATE is null");
			return (Criteria) this;
		}

		public Criteria andBuildDateIsNotNull() {
			addCriterion("BUILD_DATE is not null");
			return (Criteria) this;
		}

		public Criteria andBuildDateEqualTo(String value) {
			addCriterion("BUILD_DATE =", value, "buildDate");
			return (Criteria) this;
		}

		public Criteria andBuildDateNotEqualTo(String value) {
			addCriterion("BUILD_DATE <>", value, "buildDate");
			return (Criteria) this;
		}

		public Criteria andBuildDateGreaterThan(String value) {
			addCriterion("BUILD_DATE >", value, "buildDate");
			return (Criteria) this;
		}

		public Criteria andBuildDateGreaterThanOrEqualTo(String value) {
			addCriterion("BUILD_DATE >=", value, "buildDate");
			return (Criteria) this;
		}

		public Criteria andBuildDateLessThan(String value) {
			addCriterion("BUILD_DATE <", value, "buildDate");
			return (Criteria) this;
		}

		public Criteria andBuildDateLessThanOrEqualTo(String value) {
			addCriterion("BUILD_DATE <=", value, "buildDate");
			return (Criteria) this;
		}

		public Criteria andBuildDateLike(String value) {
			addCriterion("BUILD_DATE like", value, "buildDate");
			return (Criteria) this;
		}

		public Criteria andBuildDateNotLike(String value) {
			addCriterion("BUILD_DATE not like", value, "buildDate");
			return (Criteria) this;
		}

		public Criteria andBuildDateIn(List<String> values) {
			addCriterion("BUILD_DATE in", values, "buildDate");
			return (Criteria) this;
		}

		public Criteria andBuildDateNotIn(List<String> values) {
			addCriterion("BUILD_DATE not in", values, "buildDate");
			return (Criteria) this;
		}

		public Criteria andBuildDateBetween(String value1, String value2) {
			addCriterion("BUILD_DATE between", value1, value2, "buildDate");
			return (Criteria) this;
		}

		public Criteria andBuildDateNotBetween(String value1, String value2) {
			addCriterion("BUILD_DATE not between", value1, value2, "buildDate");
			return (Criteria) this;
		}

		public Criteria andSubmitDateIsNull() {
			addCriterion("SUBMIT_DATE is null");
			return (Criteria) this;
		}

		public Criteria andSubmitDateIsNotNull() {
			addCriterion("SUBMIT_DATE is not null");
			return (Criteria) this;
		}

		public Criteria andSubmitDateEqualTo(String value) {
			addCriterion("SUBMIT_DATE =", value, "submitDate");
			return (Criteria) this;
		}

		public Criteria andSubmitDateNotEqualTo(String value) {
			addCriterion("SUBMIT_DATE <>", value, "submitDate");
			return (Criteria) this;
		}

		public Criteria andSubmitDateGreaterThan(String value) {
			addCriterion("SUBMIT_DATE >", value, "submitDate");
			return (Criteria) this;
		}

		public Criteria andSubmitDateGreaterThanOrEqualTo(String value) {
			addCriterion("SUBMIT_DATE >=", value, "submitDate");
			return (Criteria) this;
		}

		public Criteria andSubmitDateLessThan(String value) {
			addCriterion("SUBMIT_DATE <", value, "submitDate");
			return (Criteria) this;
		}

		public Criteria andSubmitDateLessThanOrEqualTo(String value) {
			addCriterion("SUBMIT_DATE <=", value, "submitDate");
			return (Criteria) this;
		}

		public Criteria andSubmitDateLike(String value) {
			addCriterion("SUBMIT_DATE like", value, "submitDate");
			return (Criteria) this;
		}

		public Criteria andSubmitDateNotLike(String value) {
			addCriterion("SUBMIT_DATE not like", value, "submitDate");
			return (Criteria) this;
		}

		public Criteria andSubmitDateIn(List<String> values) {
			addCriterion("SUBMIT_DATE in", values, "submitDate");
			return (Criteria) this;
		}

		public Criteria andSubmitDateNotIn(List<String> values) {
			addCriterion("SUBMIT_DATE not in", values, "submitDate");
			return (Criteria) this;
		}

		public Criteria andSubmitDateBetween(String value1, String value2) {
			addCriterion("SUBMIT_DATE between", value1, value2, "submitDate");
			return (Criteria) this;
		}

		public Criteria andSubmitDateNotBetween(String value1, String value2) {
			addCriterion("SUBMIT_DATE not between", value1, value2, "submitDate");
			return (Criteria) this;
		}

		public Criteria andBuildAreaIsNull() {
			addCriterion("BUILD_AREA is null");
			return (Criteria) this;
		}

		public Criteria andBuildAreaIsNotNull() {
			addCriterion("BUILD_AREA is not null");
			return (Criteria) this;
		}

		public Criteria andBuildAreaEqualTo(String value) {
			addCriterion("BUILD_AREA =", value, "buildArea");
			return (Criteria) this;
		}

		public Criteria andBuildAreaNotEqualTo(String value) {
			addCriterion("BUILD_AREA <>", value, "buildArea");
			return (Criteria) this;
		}

		public Criteria andBuildAreaGreaterThan(String value) {
			addCriterion("BUILD_AREA >", value, "buildArea");
			return (Criteria) this;
		}

		public Criteria andBuildAreaGreaterThanOrEqualTo(String value) {
			addCriterion("BUILD_AREA >=", value, "buildArea");
			return (Criteria) this;
		}

		public Criteria andBuildAreaLessThan(String value) {
			addCriterion("BUILD_AREA <", value, "buildArea");
			return (Criteria) this;
		}

		public Criteria andBuildAreaLessThanOrEqualTo(String value) {
			addCriterion("BUILD_AREA <=", value, "buildArea");
			return (Criteria) this;
		}

		public Criteria andBuildAreaLike(String value) {
			addCriterion("BUILD_AREA like", value, "buildArea");
			return (Criteria) this;
		}

		public Criteria andBuildAreaNotLike(String value) {
			addCriterion("BUILD_AREA not like", value, "buildArea");
			return (Criteria) this;
		}

		public Criteria andBuildAreaIn(List<String> values) {
			addCriterion("BUILD_AREA in", values, "buildArea");
			return (Criteria) this;
		}

		public Criteria andBuildAreaNotIn(List<String> values) {
			addCriterion("BUILD_AREA not in", values, "buildArea");
			return (Criteria) this;
		}

		public Criteria andBuildAreaBetween(String value1, String value2) {
			addCriterion("BUILD_AREA between", value1, value2, "buildArea");
			return (Criteria) this;
		}

		public Criteria andBuildAreaNotBetween(String value1, String value2) {
			addCriterion("BUILD_AREA not between", value1, value2, "buildArea");
			return (Criteria) this;
		}

		public Criteria andProjectCoverIsNull() {
			addCriterion("PROJECT_COVER is null");
			return (Criteria) this;
		}

		public Criteria andProjectCoverIsNotNull() {
			addCriterion("PROJECT_COVER is not null");
			return (Criteria) this;
		}

		public Criteria andProjectCoverEqualTo(String value) {
			addCriterion("PROJECT_COVER =", value, "projectCover");
			return (Criteria) this;
		}

		public Criteria andProjectCoverNotEqualTo(String value) {
			addCriterion("PROJECT_COVER <>", value, "projectCover");
			return (Criteria) this;
		}

		public Criteria andProjectCoverGreaterThan(String value) {
			addCriterion("PROJECT_COVER >", value, "projectCover");
			return (Criteria) this;
		}

		public Criteria andProjectCoverGreaterThanOrEqualTo(String value) {
			addCriterion("PROJECT_COVER >=", value, "projectCover");
			return (Criteria) this;
		}

		public Criteria andProjectCoverLessThan(String value) {
			addCriterion("PROJECT_COVER <", value, "projectCover");
			return (Criteria) this;
		}

		public Criteria andProjectCoverLessThanOrEqualTo(String value) {
			addCriterion("PROJECT_COVER <=", value, "projectCover");
			return (Criteria) this;
		}

		public Criteria andProjectCoverLike(String value) {
			addCriterion("PROJECT_COVER like", value, "projectCover");
			return (Criteria) this;
		}

		public Criteria andProjectCoverNotLike(String value) {
			addCriterion("PROJECT_COVER not like", value, "projectCover");
			return (Criteria) this;
		}

		public Criteria andProjectCoverIn(List<String> values) {
			addCriterion("PROJECT_COVER in", values, "projectCover");
			return (Criteria) this;
		}

		public Criteria andProjectCoverNotIn(List<String> values) {
			addCriterion("PROJECT_COVER not in", values, "projectCover");
			return (Criteria) this;
		}

		public Criteria andProjectCoverBetween(String value1, String value2) {
			addCriterion("PROJECT_COVER between", value1, value2, "projectCover");
			return (Criteria) this;
		}

		public Criteria andProjectCoverNotBetween(String value1, String value2) {
			addCriterion("PROJECT_COVER not between", value1, value2, "projectCover");
			return (Criteria) this;
		}

		public Criteria andProjectSpaceIsNull() {
			addCriterion("PROJECT_SPACE is null");
			return (Criteria) this;
		}

		public Criteria andProjectSpaceIsNotNull() {
			addCriterion("PROJECT_SPACE is not null");
			return (Criteria) this;
		}

		public Criteria andProjectSpaceEqualTo(String value) {
			addCriterion("PROJECT_SPACE =", value, "projectSpace");
			return (Criteria) this;
		}

		public Criteria andProjectSpaceNotEqualTo(String value) {
			addCriterion("PROJECT_SPACE <>", value, "projectSpace");
			return (Criteria) this;
		}

		public Criteria andProjectSpaceGreaterThan(String value) {
			addCriterion("PROJECT_SPACE >", value, "projectSpace");
			return (Criteria) this;
		}

		public Criteria andProjectSpaceGreaterThanOrEqualTo(String value) {
			addCriterion("PROJECT_SPACE >=", value, "projectSpace");
			return (Criteria) this;
		}

		public Criteria andProjectSpaceLessThan(String value) {
			addCriterion("PROJECT_SPACE <", value, "projectSpace");
			return (Criteria) this;
		}

		public Criteria andProjectSpaceLessThanOrEqualTo(String value) {
			addCriterion("PROJECT_SPACE <=", value, "projectSpace");
			return (Criteria) this;
		}

		public Criteria andProjectSpaceLike(String value) {
			addCriterion("PROJECT_SPACE like", value, "projectSpace");
			return (Criteria) this;
		}

		public Criteria andProjectSpaceNotLike(String value) {
			addCriterion("PROJECT_SPACE not like", value, "projectSpace");
			return (Criteria) this;
		}

		public Criteria andProjectSpaceIn(List<String> values) {
			addCriterion("PROJECT_SPACE in", values, "projectSpace");
			return (Criteria) this;
		}

		public Criteria andProjectSpaceNotIn(List<String> values) {
			addCriterion("PROJECT_SPACE not in", values, "projectSpace");
			return (Criteria) this;
		}

		public Criteria andProjectSpaceBetween(String value1, String value2) {
			addCriterion("PROJECT_SPACE between", value1, value2, "projectSpace");
			return (Criteria) this;
		}

		public Criteria andProjectSpaceNotBetween(String value1, String value2) {
			addCriterion("PROJECT_SPACE not between", value1, value2, "projectSpace");
			return (Criteria) this;
		}

		public Criteria andProjectGreenIsNull() {
			addCriterion("PROJECT_GREEN is null");
			return (Criteria) this;
		}

		public Criteria andProjectGreenIsNotNull() {
			addCriterion("PROJECT_GREEN is not null");
			return (Criteria) this;
		}

		public Criteria andProjectGreenEqualTo(String value) {
			addCriterion("PROJECT_GREEN =", value, "projectGreen");
			return (Criteria) this;
		}

		public Criteria andProjectGreenNotEqualTo(String value) {
			addCriterion("PROJECT_GREEN <>", value, "projectGreen");
			return (Criteria) this;
		}

		public Criteria andProjectGreenGreaterThan(String value) {
			addCriterion("PROJECT_GREEN >", value, "projectGreen");
			return (Criteria) this;
		}

		public Criteria andProjectGreenGreaterThanOrEqualTo(String value) {
			addCriterion("PROJECT_GREEN >=", value, "projectGreen");
			return (Criteria) this;
		}

		public Criteria andProjectGreenLessThan(String value) {
			addCriterion("PROJECT_GREEN <", value, "projectGreen");
			return (Criteria) this;
		}

		public Criteria andProjectGreenLessThanOrEqualTo(String value) {
			addCriterion("PROJECT_GREEN <=", value, "projectGreen");
			return (Criteria) this;
		}

		public Criteria andProjectGreenLike(String value) {
			addCriterion("PROJECT_GREEN like", value, "projectGreen");
			return (Criteria) this;
		}

		public Criteria andProjectGreenNotLike(String value) {
			addCriterion("PROJECT_GREEN not like", value, "projectGreen");
			return (Criteria) this;
		}

		public Criteria andProjectGreenIn(List<String> values) {
			addCriterion("PROJECT_GREEN in", values, "projectGreen");
			return (Criteria) this;
		}

		public Criteria andProjectGreenNotIn(List<String> values) {
			addCriterion("PROJECT_GREEN not in", values, "projectGreen");
			return (Criteria) this;
		}

		public Criteria andProjectGreenBetween(String value1, String value2) {
			addCriterion("PROJECT_GREEN between", value1, value2, "projectGreen");
			return (Criteria) this;
		}

		public Criteria andProjectGreenNotBetween(String value1, String value2) {
			addCriterion("PROJECT_GREEN not between", value1, value2, "projectGreen");
			return (Criteria) this;
		}

		public Criteria andCarsCaseIsNull() {
			addCriterion("CARS_CASE is null");
			return (Criteria) this;
		}

		public Criteria andCarsCaseIsNotNull() {
			addCriterion("CARS_CASE is not null");
			return (Criteria) this;
		}

		public Criteria andCarsCaseEqualTo(String value) {
			addCriterion("CARS_CASE =", value, "carsCase");
			return (Criteria) this;
		}

		public Criteria andCarsCaseNotEqualTo(String value) {
			addCriterion("CARS_CASE <>", value, "carsCase");
			return (Criteria) this;
		}

		public Criteria andCarsCaseGreaterThan(String value) {
			addCriterion("CARS_CASE >", value, "carsCase");
			return (Criteria) this;
		}

		public Criteria andCarsCaseGreaterThanOrEqualTo(String value) {
			addCriterion("CARS_CASE >=", value, "carsCase");
			return (Criteria) this;
		}

		public Criteria andCarsCaseLessThan(String value) {
			addCriterion("CARS_CASE <", value, "carsCase");
			return (Criteria) this;
		}

		public Criteria andCarsCaseLessThanOrEqualTo(String value) {
			addCriterion("CARS_CASE <=", value, "carsCase");
			return (Criteria) this;
		}

		public Criteria andCarsCaseLike(String value) {
			addCriterion("CARS_CASE like", value, "carsCase");
			return (Criteria) this;
		}

		public Criteria andCarsCaseNotLike(String value) {
			addCriterion("CARS_CASE not like", value, "carsCase");
			return (Criteria) this;
		}

		public Criteria andCarsCaseIn(List<String> values) {
			addCriterion("CARS_CASE in", values, "carsCase");
			return (Criteria) this;
		}

		public Criteria andCarsCaseNotIn(List<String> values) {
			addCriterion("CARS_CASE not in", values, "carsCase");
			return (Criteria) this;
		}

		public Criteria andCarsCaseBetween(String value1, String value2) {
			addCriterion("CARS_CASE between", value1, value2, "carsCase");
			return (Criteria) this;
		}

		public Criteria andCarsCaseNotBetween(String value1, String value2) {
			addCriterion("CARS_CASE not between", value1, value2, "carsCase");
			return (Criteria) this;
		}

		public Criteria andBusLineIsNull() {
			addCriterion("BUS_LINE is null");
			return (Criteria) this;
		}

		public Criteria andBusLineIsNotNull() {
			addCriterion("BUS_LINE is not null");
			return (Criteria) this;
		}

		public Criteria andBusLineEqualTo(String value) {
			addCriterion("BUS_LINE =", value, "busLine");
			return (Criteria) this;
		}

		public Criteria andBusLineNotEqualTo(String value) {
			addCriterion("BUS_LINE <>", value, "busLine");
			return (Criteria) this;
		}

		public Criteria andBusLineGreaterThan(String value) {
			addCriterion("BUS_LINE >", value, "busLine");
			return (Criteria) this;
		}

		public Criteria andBusLineGreaterThanOrEqualTo(String value) {
			addCriterion("BUS_LINE >=", value, "busLine");
			return (Criteria) this;
		}

		public Criteria andBusLineLessThan(String value) {
			addCriterion("BUS_LINE <", value, "busLine");
			return (Criteria) this;
		}

		public Criteria andBusLineLessThanOrEqualTo(String value) {
			addCriterion("BUS_LINE <=", value, "busLine");
			return (Criteria) this;
		}

		public Criteria andBusLineLike(String value) {
			addCriterion("BUS_LINE like", value, "busLine");
			return (Criteria) this;
		}

		public Criteria andBusLineNotLike(String value) {
			addCriterion("BUS_LINE not like", value, "busLine");
			return (Criteria) this;
		}

		public Criteria andBusLineIn(List<String> values) {
			addCriterion("BUS_LINE in", values, "busLine");
			return (Criteria) this;
		}

		public Criteria andBusLineNotIn(List<String> values) {
			addCriterion("BUS_LINE not in", values, "busLine");
			return (Criteria) this;
		}

		public Criteria andBusLineBetween(String value1, String value2) {
			addCriterion("BUS_LINE between", value1, value2, "busLine");
			return (Criteria) this;
		}

		public Criteria andBusLineNotBetween(String value1, String value2) {
			addCriterion("BUS_LINE not between", value1, value2, "busLine");
			return (Criteria) this;
		}

		public Criteria andPropertyCompIsNull() {
			addCriterion("PROPERTY_COMP is null");
			return (Criteria) this;
		}

		public Criteria andPropertyCompIsNotNull() {
			addCriterion("PROPERTY_COMP is not null");
			return (Criteria) this;
		}

		public Criteria andPropertyCompEqualTo(String value) {
			addCriterion("PROPERTY_COMP =", value, "propertyComp");
			return (Criteria) this;
		}

		public Criteria andPropertyCompNotEqualTo(String value) {
			addCriterion("PROPERTY_COMP <>", value, "propertyComp");
			return (Criteria) this;
		}

		public Criteria andPropertyCompGreaterThan(String value) {
			addCriterion("PROPERTY_COMP >", value, "propertyComp");
			return (Criteria) this;
		}

		public Criteria andPropertyCompGreaterThanOrEqualTo(String value) {
			addCriterion("PROPERTY_COMP >=", value, "propertyComp");
			return (Criteria) this;
		}

		public Criteria andPropertyCompLessThan(String value) {
			addCriterion("PROPERTY_COMP <", value, "propertyComp");
			return (Criteria) this;
		}

		public Criteria andPropertyCompLessThanOrEqualTo(String value) {
			addCriterion("PROPERTY_COMP <=", value, "propertyComp");
			return (Criteria) this;
		}

		public Criteria andPropertyCompLike(String value) {
			addCriterion("PROPERTY_COMP like", value, "propertyComp");
			return (Criteria) this;
		}

		public Criteria andPropertyCompNotLike(String value) {
			addCriterion("PROPERTY_COMP not like", value, "propertyComp");
			return (Criteria) this;
		}

		public Criteria andPropertyCompIn(List<String> values) {
			addCriterion("PROPERTY_COMP in", values, "propertyComp");
			return (Criteria) this;
		}

		public Criteria andPropertyCompNotIn(List<String> values) {
			addCriterion("PROPERTY_COMP not in", values, "propertyComp");
			return (Criteria) this;
		}

		public Criteria andPropertyCompBetween(String value1, String value2) {
			addCriterion("PROPERTY_COMP between", value1, value2, "propertyComp");
			return (Criteria) this;
		}

		public Criteria andPropertyCompNotBetween(String value1, String value2) {
			addCriterion("PROPERTY_COMP not between", value1, value2, "propertyComp");
			return (Criteria) this;
		}

		public Criteria andPropertycompTeleIsNull() {
			addCriterion("PROPERTYCOMP_TELE is null");
			return (Criteria) this;
		}

		public Criteria andPropertycompTeleIsNotNull() {
			addCriterion("PROPERTYCOMP_TELE is not null");
			return (Criteria) this;
		}

		public Criteria andPropertycompTeleEqualTo(String value) {
			addCriterion("PROPERTYCOMP_TELE =", value, "propertycompTele");
			return (Criteria) this;
		}

		public Criteria andPropertycompTeleNotEqualTo(String value) {
			addCriterion("PROPERTYCOMP_TELE <>", value, "propertycompTele");
			return (Criteria) this;
		}

		public Criteria andPropertycompTeleGreaterThan(String value) {
			addCriterion("PROPERTYCOMP_TELE >", value, "propertycompTele");
			return (Criteria) this;
		}

		public Criteria andPropertycompTeleGreaterThanOrEqualTo(String value) {
			addCriterion("PROPERTYCOMP_TELE >=", value, "propertycompTele");
			return (Criteria) this;
		}

		public Criteria andPropertycompTeleLessThan(String value) {
			addCriterion("PROPERTYCOMP_TELE <", value, "propertycompTele");
			return (Criteria) this;
		}

		public Criteria andPropertycompTeleLessThanOrEqualTo(String value) {
			addCriterion("PROPERTYCOMP_TELE <=", value, "propertycompTele");
			return (Criteria) this;
		}

		public Criteria andPropertycompTeleLike(String value) {
			addCriterion("PROPERTYCOMP_TELE like", value, "propertycompTele");
			return (Criteria) this;
		}

		public Criteria andPropertycompTeleNotLike(String value) {
			addCriterion("PROPERTYCOMP_TELE not like", value, "propertycompTele");
			return (Criteria) this;
		}

		public Criteria andPropertycompTeleIn(List<String> values) {
			addCriterion("PROPERTYCOMP_TELE in", values, "propertycompTele");
			return (Criteria) this;
		}

		public Criteria andPropertycompTeleNotIn(List<String> values) {
			addCriterion("PROPERTYCOMP_TELE not in", values, "propertycompTele");
			return (Criteria) this;
		}

		public Criteria andPropertycompTeleBetween(String value1, String value2) {
			addCriterion("PROPERTYCOMP_TELE between", value1, value2, "propertycompTele");
			return (Criteria) this;
		}

		public Criteria andPropertycompTeleNotBetween(String value1, String value2) {
			addCriterion("PROPERTYCOMP_TELE not between", value1, value2, "propertycompTele");
			return (Criteria) this;
		}

		public Criteria andCostStandardIsNull() {
			addCriterion("COST_STANDARD is null");
			return (Criteria) this;
		}

		public Criteria andCostStandardIsNotNull() {
			addCriterion("COST_STANDARD is not null");
			return (Criteria) this;
		}

		public Criteria andCostStandardEqualTo(String value) {
			addCriterion("COST_STANDARD =", value, "costStandard");
			return (Criteria) this;
		}

		public Criteria andCostStandardNotEqualTo(String value) {
			addCriterion("COST_STANDARD <>", value, "costStandard");
			return (Criteria) this;
		}

		public Criteria andCostStandardGreaterThan(String value) {
			addCriterion("COST_STANDARD >", value, "costStandard");
			return (Criteria) this;
		}

		public Criteria andCostStandardGreaterThanOrEqualTo(String value) {
			addCriterion("COST_STANDARD >=", value, "costStandard");
			return (Criteria) this;
		}

		public Criteria andCostStandardLessThan(String value) {
			addCriterion("COST_STANDARD <", value, "costStandard");
			return (Criteria) this;
		}

		public Criteria andCostStandardLessThanOrEqualTo(String value) {
			addCriterion("COST_STANDARD <=", value, "costStandard");
			return (Criteria) this;
		}

		public Criteria andCostStandardLike(String value) {
			addCriterion("COST_STANDARD like", value, "costStandard");
			return (Criteria) this;
		}

		public Criteria andCostStandardNotLike(String value) {
			addCriterion("COST_STANDARD not like", value, "costStandard");
			return (Criteria) this;
		}

		public Criteria andCostStandardIn(List<String> values) {
			addCriterion("COST_STANDARD in", values, "costStandard");
			return (Criteria) this;
		}

		public Criteria andCostStandardNotIn(List<String> values) {
			addCriterion("COST_STANDARD not in", values, "costStandard");
			return (Criteria) this;
		}

		public Criteria andCostStandardBetween(String value1, String value2) {
			addCriterion("COST_STANDARD between", value1, value2, "costStandard");
			return (Criteria) this;
		}

		public Criteria andCostStandardNotBetween(String value1, String value2) {
			addCriterion("COST_STANDARD not between", value1, value2, "costStandard");
			return (Criteria) this;
		}

		public Criteria andBuildDescriptIsNull() {
			addCriterion("BUILD_DESCRIPT is null");
			return (Criteria) this;
		}

		public Criteria andBuildDescriptIsNotNull() {
			addCriterion("BUILD_DESCRIPT is not null");
			return (Criteria) this;
		}

		public Criteria andBuildDescriptEqualTo(String value) {
			addCriterion("BUILD_DESCRIPT =", value, "buildDescript");
			return (Criteria) this;
		}

		public Criteria andBuildDescriptNotEqualTo(String value) {
			addCriterion("BUILD_DESCRIPT <>", value, "buildDescript");
			return (Criteria) this;
		}

		public Criteria andBuildDescriptGreaterThan(String value) {
			addCriterion("BUILD_DESCRIPT >", value, "buildDescript");
			return (Criteria) this;
		}

		public Criteria andBuildDescriptGreaterThanOrEqualTo(String value) {
			addCriterion("BUILD_DESCRIPT >=", value, "buildDescript");
			return (Criteria) this;
		}

		public Criteria andBuildDescriptLessThan(String value) {
			addCriterion("BUILD_DESCRIPT <", value, "buildDescript");
			return (Criteria) this;
		}

		public Criteria andBuildDescriptLessThanOrEqualTo(String value) {
			addCriterion("BUILD_DESCRIPT <=", value, "buildDescript");
			return (Criteria) this;
		}

		public Criteria andBuildDescriptLike(String value) {
			addCriterion("BUILD_DESCRIPT like", value, "buildDescript");
			return (Criteria) this;
		}

		public Criteria andBuildDescriptNotLike(String value) {
			addCriterion("BUILD_DESCRIPT not like", value, "buildDescript");
			return (Criteria) this;
		}

		public Criteria andBuildDescriptIn(List<String> values) {
			addCriterion("BUILD_DESCRIPT in", values, "buildDescript");
			return (Criteria) this;
		}

		public Criteria andBuildDescriptNotIn(List<String> values) {
			addCriterion("BUILD_DESCRIPT not in", values, "buildDescript");
			return (Criteria) this;
		}

		public Criteria andBuildDescriptBetween(String value1, String value2) {
			addCriterion("BUILD_DESCRIPT between", value1, value2, "buildDescript");
			return (Criteria) this;
		}

		public Criteria andBuildDescriptNotBetween(String value1, String value2) {
			addCriterion("BUILD_DESCRIPT not between", value1, value2, "buildDescript");
			return (Criteria) this;
		}

		public Criteria andBuildPhotoIsNull() {
			addCriterion("BUILD_PHOTO is null");
			return (Criteria) this;
		}

		public Criteria andBuildPhotoIsNotNull() {
			addCriterion("BUILD_PHOTO is not null");
			return (Criteria) this;
		}

		public Criteria andBuildPhotoEqualTo(Integer value) {
			addCriterion("BUILD_PHOTO =", value, "buildPhoto");
			return (Criteria) this;
		}

		public Criteria andBuildPhotoNotEqualTo(Integer value) {
			addCriterion("BUILD_PHOTO <>", value, "buildPhoto");
			return (Criteria) this;
		}

		public Criteria andBuildPhotoGreaterThan(Integer value) {
			addCriterion("BUILD_PHOTO >", value, "buildPhoto");
			return (Criteria) this;
		}

		public Criteria andBuildPhotoGreaterThanOrEqualTo(Integer value) {
			addCriterion("BUILD_PHOTO >=", value, "buildPhoto");
			return (Criteria) this;
		}

		public Criteria andBuildPhotoLessThan(Integer value) {
			addCriterion("BUILD_PHOTO <", value, "buildPhoto");
			return (Criteria) this;
		}

		public Criteria andBuildPhotoLessThanOrEqualTo(Integer value) {
			addCriterion("BUILD_PHOTO <=", value, "buildPhoto");
			return (Criteria) this;
		}

		public Criteria andBuildPhotoIn(List<Integer> values) {
			addCriterion("BUILD_PHOTO in", values, "buildPhoto");
			return (Criteria) this;
		}

		public Criteria andBuildPhotoNotIn(List<Integer> values) {
			addCriterion("BUILD_PHOTO not in", values, "buildPhoto");
			return (Criteria) this;
		}

		public Criteria andBuildPhotoBetween(Integer value1, Integer value2) {
			addCriterion("BUILD_PHOTO between", value1, value2, "buildPhoto");
			return (Criteria) this;
		}

		public Criteria andBuildPhotoNotBetween(Integer value1, Integer value2) {
			addCriterion("BUILD_PHOTO not between", value1, value2, "buildPhoto");
			return (Criteria) this;
		}

		public Criteria andPositionXIsNull() {
			addCriterion("POSITION_X is null");
			return (Criteria) this;
		}

		public Criteria andPositionXIsNotNull() {
			addCriterion("POSITION_X is not null");
			return (Criteria) this;
		}

		public Criteria andPositionXEqualTo(String value) {
			addCriterion("POSITION_X =", value, "positionX");
			return (Criteria) this;
		}

		public Criteria andPositionXNotEqualTo(String value) {
			addCriterion("POSITION_X <>", value, "positionX");
			return (Criteria) this;
		}

		public Criteria andPositionXGreaterThan(String value) {
			addCriterion("POSITION_X >", value, "positionX");
			return (Criteria) this;
		}

		public Criteria andPositionXGreaterThanOrEqualTo(String value) {
			addCriterion("POSITION_X >=", value, "positionX");
			return (Criteria) this;
		}

		public Criteria andPositionXLessThan(String value) {
			addCriterion("POSITION_X <", value, "positionX");
			return (Criteria) this;
		}

		public Criteria andPositionXLessThanOrEqualTo(String value) {
			addCriterion("POSITION_X <=", value, "positionX");
			return (Criteria) this;
		}

		public Criteria andPositionXLike(String value) {
			addCriterion("POSITION_X like", value, "positionX");
			return (Criteria) this;
		}

		public Criteria andPositionXNotLike(String value) {
			addCriterion("POSITION_X not like", value, "positionX");
			return (Criteria) this;
		}

		public Criteria andPositionXIn(List<String> values) {
			addCriterion("POSITION_X in", values, "positionX");
			return (Criteria) this;
		}

		public Criteria andPositionXNotIn(List<String> values) {
			addCriterion("POSITION_X not in", values, "positionX");
			return (Criteria) this;
		}

		public Criteria andPositionXBetween(String value1, String value2) {
			addCriterion("POSITION_X between", value1, value2, "positionX");
			return (Criteria) this;
		}

		public Criteria andPositionXNotBetween(String value1, String value2) {
			addCriterion("POSITION_X not between", value1, value2, "positionX");
			return (Criteria) this;
		}

		public Criteria andPositionYIsNull() {
			addCriterion("POSITION_Y is null");
			return (Criteria) this;
		}

		public Criteria andPositionYIsNotNull() {
			addCriterion("POSITION_Y is not null");
			return (Criteria) this;
		}

		public Criteria andPositionYEqualTo(String value) {
			addCriterion("POSITION_Y =", value, "positionY");
			return (Criteria) this;
		}

		public Criteria andPositionYNotEqualTo(String value) {
			addCriterion("POSITION_Y <>", value, "positionY");
			return (Criteria) this;
		}

		public Criteria andPositionYGreaterThan(String value) {
			addCriterion("POSITION_Y >", value, "positionY");
			return (Criteria) this;
		}

		public Criteria andPositionYGreaterThanOrEqualTo(String value) {
			addCriterion("POSITION_Y >=", value, "positionY");
			return (Criteria) this;
		}

		public Criteria andPositionYLessThan(String value) {
			addCriterion("POSITION_Y <", value, "positionY");
			return (Criteria) this;
		}

		public Criteria andPositionYLessThanOrEqualTo(String value) {
			addCriterion("POSITION_Y <=", value, "positionY");
			return (Criteria) this;
		}

		public Criteria andPositionYLike(String value) {
			addCriterion("POSITION_Y like", value, "positionY");
			return (Criteria) this;
		}

		public Criteria andPositionYNotLike(String value) {
			addCriterion("POSITION_Y not like", value, "positionY");
			return (Criteria) this;
		}

		public Criteria andPositionYIn(List<String> values) {
			addCriterion("POSITION_Y in", values, "positionY");
			return (Criteria) this;
		}

		public Criteria andPositionYNotIn(List<String> values) {
			addCriterion("POSITION_Y not in", values, "positionY");
			return (Criteria) this;
		}

		public Criteria andPositionYBetween(String value1, String value2) {
			addCriterion("POSITION_Y between", value1, value2, "positionY");
			return (Criteria) this;
		}

		public Criteria andPositionYNotBetween(String value1, String value2) {
			addCriterion("POSITION_Y not between", value1, value2, "positionY");
			return (Criteria) this;
		}

		public Criteria andPositionFlagIsNull() {
			addCriterion("POSITION_FLAG is null");
			return (Criteria) this;
		}

		public Criteria andPositionFlagIsNotNull() {
			addCriterion("POSITION_FLAG is not null");
			return (Criteria) this;
		}

		public Criteria andPositionFlagEqualTo(Short value) {
			addCriterion("POSITION_FLAG =", value, "positionFlag");
			return (Criteria) this;
		}

		public Criteria andPositionFlagNotEqualTo(Short value) {
			addCriterion("POSITION_FLAG <>", value, "positionFlag");
			return (Criteria) this;
		}

		public Criteria andPositionFlagGreaterThan(Short value) {
			addCriterion("POSITION_FLAG >", value, "positionFlag");
			return (Criteria) this;
		}

		public Criteria andPositionFlagGreaterThanOrEqualTo(Short value) {
			addCriterion("POSITION_FLAG >=", value, "positionFlag");
			return (Criteria) this;
		}

		public Criteria andPositionFlagLessThan(Short value) {
			addCriterion("POSITION_FLAG <", value, "positionFlag");
			return (Criteria) this;
		}

		public Criteria andPositionFlagLessThanOrEqualTo(Short value) {
			addCriterion("POSITION_FLAG <=", value, "positionFlag");
			return (Criteria) this;
		}

		public Criteria andPositionFlagIn(List<Short> values) {
			addCriterion("POSITION_FLAG in", values, "positionFlag");
			return (Criteria) this;
		}

		public Criteria andPositionFlagNotIn(List<Short> values) {
			addCriterion("POSITION_FLAG not in", values, "positionFlag");
			return (Criteria) this;
		}

		public Criteria andPositionFlagBetween(Short value1, Short value2) {
			addCriterion("POSITION_FLAG between", value1, value2, "positionFlag");
			return (Criteria) this;
		}

		public Criteria andPositionFlagNotBetween(Short value1, Short value2) {
			addCriterion("POSITION_FLAG not between", value1, value2, "positionFlag");
			return (Criteria) this;
		}

		public Criteria andTypicFlagIsNull() {
			addCriterion("TYPIC_FLAG is null");
			return (Criteria) this;
		}

		public Criteria andTypicFlagIsNotNull() {
			addCriterion("TYPIC_FLAG is not null");
			return (Criteria) this;
		}

		public Criteria andTypicFlagEqualTo(Short value) {
			addCriterion("TYPIC_FLAG =", value, "typicFlag");
			return (Criteria) this;
		}

		public Criteria andTypicFlagNotEqualTo(Short value) {
			addCriterion("TYPIC_FLAG <>", value, "typicFlag");
			return (Criteria) this;
		}

		public Criteria andTypicFlagGreaterThan(Short value) {
			addCriterion("TYPIC_FLAG >", value, "typicFlag");
			return (Criteria) this;
		}

		public Criteria andTypicFlagGreaterThanOrEqualTo(Short value) {
			addCriterion("TYPIC_FLAG >=", value, "typicFlag");
			return (Criteria) this;
		}

		public Criteria andTypicFlagLessThan(Short value) {
			addCriterion("TYPIC_FLAG <", value, "typicFlag");
			return (Criteria) this;
		}

		public Criteria andTypicFlagLessThanOrEqualTo(Short value) {
			addCriterion("TYPIC_FLAG <=", value, "typicFlag");
			return (Criteria) this;
		}

		public Criteria andTypicFlagIn(List<Short> values) {
			addCriterion("TYPIC_FLAG in", values, "typicFlag");
			return (Criteria) this;
		}

		public Criteria andTypicFlagNotIn(List<Short> values) {
			addCriterion("TYPIC_FLAG not in", values, "typicFlag");
			return (Criteria) this;
		}

		public Criteria andTypicFlagBetween(Short value1, Short value2) {
			addCriterion("TYPIC_FLAG between", value1, value2, "typicFlag");
			return (Criteria) this;
		}

		public Criteria andTypicFlagNotBetween(Short value1, Short value2) {
			addCriterion("TYPIC_FLAG not between", value1, value2, "typicFlag");
			return (Criteria) this;
		}

		public Criteria andVertifyFlagIsNull() {
			addCriterion("VERTIFY_FLAG is null");
			return (Criteria) this;
		}

		public Criteria andVertifyFlagIsNotNull() {
			addCriterion("VERTIFY_FLAG is not null");
			return (Criteria) this;
		}

		public Criteria andVertifyFlagEqualTo(Short value) {
			addCriterion("VERTIFY_FLAG =", value, "vertifyFlag");
			return (Criteria) this;
		}

		public Criteria andVertifyFlagNotEqualTo(Short value) {
			addCriterion("VERTIFY_FLAG <>", value, "vertifyFlag");
			return (Criteria) this;
		}

		public Criteria andVertifyFlagGreaterThan(Short value) {
			addCriterion("VERTIFY_FLAG >", value, "vertifyFlag");
			return (Criteria) this;
		}

		public Criteria andVertifyFlagGreaterThanOrEqualTo(Short value) {
			addCriterion("VERTIFY_FLAG >=", value, "vertifyFlag");
			return (Criteria) this;
		}

		public Criteria andVertifyFlagLessThan(Short value) {
			addCriterion("VERTIFY_FLAG <", value, "vertifyFlag");
			return (Criteria) this;
		}

		public Criteria andVertifyFlagLessThanOrEqualTo(Short value) {
			addCriterion("VERTIFY_FLAG <=", value, "vertifyFlag");
			return (Criteria) this;
		}

		public Criteria andVertifyFlagIn(List<Short> values) {
			addCriterion("VERTIFY_FLAG in", values, "vertifyFlag");
			return (Criteria) this;
		}

		public Criteria andVertifyFlagNotIn(List<Short> values) {
			addCriterion("VERTIFY_FLAG not in", values, "vertifyFlag");
			return (Criteria) this;
		}

		public Criteria andVertifyFlagBetween(Short value1, Short value2) {
			addCriterion("VERTIFY_FLAG between", value1, value2, "vertifyFlag");
			return (Criteria) this;
		}

		public Criteria andVertifyFlagNotBetween(Short value1, Short value2) {
			addCriterion("VERTIFY_FLAG not between", value1, value2, "vertifyFlag");
			return (Criteria) this;
		}

		public Criteria andArchiveIdIsNull() {
			addCriterion("ARCHIVE_ID is null");
			return (Criteria) this;
		}

		public Criteria andArchiveIdIsNotNull() {
			addCriterion("ARCHIVE_ID is not null");
			return (Criteria) this;
		}

		public Criteria andArchiveIdEqualTo(Integer value) {
			addCriterion("ARCHIVE_ID =", value, "archiveId");
			return (Criteria) this;
		}

		public Criteria andArchiveIdNotEqualTo(Integer value) {
			addCriterion("ARCHIVE_ID <>", value, "archiveId");
			return (Criteria) this;
		}

		public Criteria andArchiveIdGreaterThan(Integer value) {
			addCriterion("ARCHIVE_ID >", value, "archiveId");
			return (Criteria) this;
		}

		public Criteria andArchiveIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("ARCHIVE_ID >=", value, "archiveId");
			return (Criteria) this;
		}

		public Criteria andArchiveIdLessThan(Integer value) {
			addCriterion("ARCHIVE_ID <", value, "archiveId");
			return (Criteria) this;
		}

		public Criteria andArchiveIdLessThanOrEqualTo(Integer value) {
			addCriterion("ARCHIVE_ID <=", value, "archiveId");
			return (Criteria) this;
		}

		public Criteria andArchiveIdIn(List<Integer> values) {
			addCriterion("ARCHIVE_ID in", values, "archiveId");
			return (Criteria) this;
		}

		public Criteria andArchiveIdNotIn(List<Integer> values) {
			addCriterion("ARCHIVE_ID not in", values, "archiveId");
			return (Criteria) this;
		}

		public Criteria andArchiveIdBetween(Integer value1, Integer value2) {
			addCriterion("ARCHIVE_ID between", value1, value2, "archiveId");
			return (Criteria) this;
		}

		public Criteria andArchiveIdNotBetween(Integer value1, Integer value2) {
			addCriterion("ARCHIVE_ID not between", value1, value2, "archiveId");
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

		public Criteria andCreateTimeEqualTo(String value) {
			addCriterion("CREATE_TIME =", value, "createTime");
			return (Criteria) this;
		}

		public Criteria andCreateTimeNotEqualTo(String value) {
			addCriterion("CREATE_TIME <>", value, "createTime");
			return (Criteria) this;
		}

		public Criteria andCreateTimeGreaterThan(String value) {
			addCriterion("CREATE_TIME >", value, "createTime");
			return (Criteria) this;
		}

		public Criteria andCreateTimeGreaterThanOrEqualTo(String value) {
			addCriterion("CREATE_TIME >=", value, "createTime");
			return (Criteria) this;
		}

		public Criteria andCreateTimeLessThan(String value) {
			addCriterion("CREATE_TIME <", value, "createTime");
			return (Criteria) this;
		}

		public Criteria andCreateTimeLessThanOrEqualTo(String value) {
			addCriterion("CREATE_TIME <=", value, "createTime");
			return (Criteria) this;
		}

		public Criteria andCreateTimeLike(String value) {
			addCriterion("CREATE_TIME like", value, "createTime");
			return (Criteria) this;
		}

		public Criteria andCreateTimeNotLike(String value) {
			addCriterion("CREATE_TIME not like", value, "createTime");
			return (Criteria) this;
		}

		public Criteria andCreateTimeIn(List<String> values) {
			addCriterion("CREATE_TIME in", values, "createTime");
			return (Criteria) this;
		}

		public Criteria andCreateTimeNotIn(List<String> values) {
			addCriterion("CREATE_TIME not in", values, "createTime");
			return (Criteria) this;
		}

		public Criteria andCreateTimeBetween(String value1, String value2) {
			addCriterion("CREATE_TIME between", value1, value2, "createTime");
			return (Criteria) this;
		}

		public Criteria andCreateTimeNotBetween(String value1, String value2) {
			addCriterion("CREATE_TIME not between", value1, value2, "createTime");
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

		public Criteria andExamFlagIsNull() {
			addCriterion("EXAM_FLAG is null");
			return (Criteria) this;
		}

		public Criteria andExamFlagIsNotNull() {
			addCriterion("EXAM_FLAG is not null");
			return (Criteria) this;
		}

		public Criteria andExamFlagEqualTo(Short value) {
			addCriterion("EXAM_FLAG =", value, "examFlag");
			return (Criteria) this;
		}

		public Criteria andExamFlagNotEqualTo(Short value) {
			addCriterion("EXAM_FLAG <>", value, "examFlag");
			return (Criteria) this;
		}

		public Criteria andExamFlagGreaterThan(Short value) {
			addCriterion("EXAM_FLAG >", value, "examFlag");
			return (Criteria) this;
		}

		public Criteria andExamFlagGreaterThanOrEqualTo(Short value) {
			addCriterion("EXAM_FLAG >=", value, "examFlag");
			return (Criteria) this;
		}

		public Criteria andExamFlagLessThan(Short value) {
			addCriterion("EXAM_FLAG <", value, "examFlag");
			return (Criteria) this;
		}

		public Criteria andExamFlagLessThanOrEqualTo(Short value) {
			addCriterion("EXAM_FLAG <=", value, "examFlag");
			return (Criteria) this;
		}

		public Criteria andExamFlagIn(List<Short> values) {
			addCriterion("EXAM_FLAG in", values, "examFlag");
			return (Criteria) this;
		}

		public Criteria andExamFlagNotIn(List<Short> values) {
			addCriterion("EXAM_FLAG not in", values, "examFlag");
			return (Criteria) this;
		}

		public Criteria andExamFlagBetween(Short value1, Short value2) {
			addCriterion("EXAM_FLAG between", value1, value2, "examFlag");
			return (Criteria) this;
		}

		public Criteria andExamFlagNotBetween(Short value1, Short value2) {
			addCriterion("EXAM_FLAG not between", value1, value2, "examFlag");
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

		public Criteria andCheckTimeEqualTo(String value) {
			addCriterion("CHECK_TIME =", value, "checkTime");
			return (Criteria) this;
		}

		public Criteria andCheckTimeNotEqualTo(String value) {
			addCriterion("CHECK_TIME <>", value, "checkTime");
			return (Criteria) this;
		}

		public Criteria andCheckTimeGreaterThan(String value) {
			addCriterion("CHECK_TIME >", value, "checkTime");
			return (Criteria) this;
		}

		public Criteria andCheckTimeGreaterThanOrEqualTo(String value) {
			addCriterion("CHECK_TIME >=", value, "checkTime");
			return (Criteria) this;
		}

		public Criteria andCheckTimeLessThan(String value) {
			addCriterion("CHECK_TIME <", value, "checkTime");
			return (Criteria) this;
		}

		public Criteria andCheckTimeLessThanOrEqualTo(String value) {
			addCriterion("CHECK_TIME <=", value, "checkTime");
			return (Criteria) this;
		}

		public Criteria andCheckTimeLike(String value) {
			addCriterion("CHECK_TIME like", value, "checkTime");
			return (Criteria) this;
		}

		public Criteria andCheckTimeNotLike(String value) {
			addCriterion("CHECK_TIME not like", value, "checkTime");
			return (Criteria) this;
		}

		public Criteria andCheckTimeIn(List<String> values) {
			addCriterion("CHECK_TIME in", values, "checkTime");
			return (Criteria) this;
		}

		public Criteria andCheckTimeNotIn(List<String> values) {
			addCriterion("CHECK_TIME not in", values, "checkTime");
			return (Criteria) this;
		}

		public Criteria andCheckTimeBetween(String value1, String value2) {
			addCriterion("CHECK_TIME between", value1, value2, "checkTime");
			return (Criteria) this;
		}

		public Criteria andCheckTimeNotBetween(String value1, String value2) {
			addCriterion("CHECK_TIME not between", value1, value2, "checkTime");
			return (Criteria) this;
		}

		public Criteria andAddrCountIsNull() {
			addCriterion("ADDR_COUNT is null");
			return (Criteria) this;
		}

		public Criteria andAddrCountIsNotNull() {
			addCriterion("ADDR_COUNT is not null");
			return (Criteria) this;
		}

		public Criteria andAddrCountEqualTo(Byte value) {
			addCriterion("ADDR_COUNT =", value, "addrCount");
			return (Criteria) this;
		}

		public Criteria andAddrCountNotEqualTo(Byte value) {
			addCriterion("ADDR_COUNT <>", value, "addrCount");
			return (Criteria) this;
		}

		public Criteria andAddrCountGreaterThan(Byte value) {
			addCriterion("ADDR_COUNT >", value, "addrCount");
			return (Criteria) this;
		}

		public Criteria andAddrCountGreaterThanOrEqualTo(Byte value) {
			addCriterion("ADDR_COUNT >=", value, "addrCount");
			return (Criteria) this;
		}

		public Criteria andAddrCountLessThan(Byte value) {
			addCriterion("ADDR_COUNT <", value, "addrCount");
			return (Criteria) this;
		}

		public Criteria andAddrCountLessThanOrEqualTo(Byte value) {
			addCriterion("ADDR_COUNT <=", value, "addrCount");
			return (Criteria) this;
		}

		public Criteria andAddrCountIn(List<Byte> values) {
			addCriterion("ADDR_COUNT in", values, "addrCount");
			return (Criteria) this;
		}

		public Criteria andAddrCountNotIn(List<Byte> values) {
			addCriterion("ADDR_COUNT not in", values, "addrCount");
			return (Criteria) this;
		}

		public Criteria andAddrCountBetween(Byte value1, Byte value2) {
			addCriterion("ADDR_COUNT between", value1, value2, "addrCount");
			return (Criteria) this;
		}

		public Criteria andAddrCountNotBetween(Byte value1, Byte value2) {
			addCriterion("ADDR_COUNT not between", value1, value2, "addrCount");
			return (Criteria) this;
		}

		public Criteria andBuildStatusIsNull() {
			addCriterion("BUILD_STATUS is null");
			return (Criteria) this;
		}

		public Criteria andBuildStatusIsNotNull() {
			addCriterion("BUILD_STATUS is not null");
			return (Criteria) this;
		}

		public Criteria andBuildStatusEqualTo(Byte value) {
			addCriterion("BUILD_STATUS =", value, "buildStatus");
			return (Criteria) this;
		}

		public Criteria andBuildStatusNotEqualTo(Byte value) {
			addCriterion("BUILD_STATUS <>", value, "buildStatus");
			return (Criteria) this;
		}

		public Criteria andBuildStatusGreaterThan(Byte value) {
			addCriterion("BUILD_STATUS >", value, "buildStatus");
			return (Criteria) this;
		}

		public Criteria andBuildStatusGreaterThanOrEqualTo(Byte value) {
			addCriterion("BUILD_STATUS >=", value, "buildStatus");
			return (Criteria) this;
		}

		public Criteria andBuildStatusLessThan(Byte value) {
			addCriterion("BUILD_STATUS <", value, "buildStatus");
			return (Criteria) this;
		}

		public Criteria andBuildStatusLessThanOrEqualTo(Byte value) {
			addCriterion("BUILD_STATUS <=", value, "buildStatus");
			return (Criteria) this;
		}

		public Criteria andBuildStatusIn(List<Byte> values) {
			addCriterion("BUILD_STATUS in", values, "buildStatus");
			return (Criteria) this;
		}

		public Criteria andBuildStatusNotIn(List<Byte> values) {
			addCriterion("BUILD_STATUS not in", values, "buildStatus");
			return (Criteria) this;
		}

		public Criteria andBuildStatusBetween(Byte value1, Byte value2) {
			addCriterion("BUILD_STATUS between", value1, value2, "buildStatus");
			return (Criteria) this;
		}

		public Criteria andBuildStatusNotBetween(Byte value1, Byte value2) {
			addCriterion("BUILD_STATUS not between", value1, value2, "buildStatus");
			return (Criteria) this;
		}

		public Criteria andBuildUsageIsNull() {
			addCriterion("BUILD_USAGE is null");
			return (Criteria) this;
		}

		public Criteria andBuildUsageIsNotNull() {
			addCriterion("BUILD_USAGE is not null");
			return (Criteria) this;
		}

		public Criteria andBuildUsageEqualTo(String value) {
			addCriterion("BUILD_USAGE =", value, "buildUsage");
			return (Criteria) this;
		}

		public Criteria andBuildUsageNotEqualTo(String value) {
			addCriterion("BUILD_USAGE <>", value, "buildUsage");
			return (Criteria) this;
		}

		public Criteria andBuildUsageGreaterThan(String value) {
			addCriterion("BUILD_USAGE >", value, "buildUsage");
			return (Criteria) this;
		}

		public Criteria andBuildUsageGreaterThanOrEqualTo(String value) {
			addCriterion("BUILD_USAGE >=", value, "buildUsage");
			return (Criteria) this;
		}

		public Criteria andBuildUsageLessThan(String value) {
			addCriterion("BUILD_USAGE <", value, "buildUsage");
			return (Criteria) this;
		}

		public Criteria andBuildUsageLessThanOrEqualTo(String value) {
			addCriterion("BUILD_USAGE <=", value, "buildUsage");
			return (Criteria) this;
		}

		public Criteria andBuildUsageLike(String value) {
			addCriterion("BUILD_USAGE like", value, "buildUsage");
			return (Criteria) this;
		}

		public Criteria andBuildUsageNotLike(String value) {
			addCriterion("BUILD_USAGE not like", value, "buildUsage");
			return (Criteria) this;
		}

		public Criteria andBuildUsageIn(List<String> values) {
			addCriterion("BUILD_USAGE in", values, "buildUsage");
			return (Criteria) this;
		}

		public Criteria andBuildUsageNotIn(List<String> values) {
			addCriterion("BUILD_USAGE not in", values, "buildUsage");
			return (Criteria) this;
		}

		public Criteria andBuildUsageBetween(String value1, String value2) {
			addCriterion("BUILD_USAGE between", value1, value2, "buildUsage");
			return (Criteria) this;
		}

		public Criteria andBuildUsageNotBetween(String value1, String value2) {
			addCriterion("BUILD_USAGE not between", value1, value2, "buildUsage");
			return (Criteria) this;
		}

		public Criteria andBuildProgressIsNull() {
			addCriterion("BUILD_PROGRESS is null");
			return (Criteria) this;
		}

		public Criteria andBuildProgressIsNotNull() {
			addCriterion("BUILD_PROGRESS is not null");
			return (Criteria) this;
		}

		public Criteria andBuildProgressEqualTo(String value) {
			addCriterion("BUILD_PROGRESS =", value, "buildProgress");
			return (Criteria) this;
		}

		public Criteria andBuildProgressNotEqualTo(String value) {
			addCriterion("BUILD_PROGRESS <>", value, "buildProgress");
			return (Criteria) this;
		}

		public Criteria andBuildProgressGreaterThan(String value) {
			addCriterion("BUILD_PROGRESS >", value, "buildProgress");
			return (Criteria) this;
		}

		public Criteria andBuildProgressGreaterThanOrEqualTo(String value) {
			addCriterion("BUILD_PROGRESS >=", value, "buildProgress");
			return (Criteria) this;
		}

		public Criteria andBuildProgressLessThan(String value) {
			addCriterion("BUILD_PROGRESS <", value, "buildProgress");
			return (Criteria) this;
		}

		public Criteria andBuildProgressLessThanOrEqualTo(String value) {
			addCriterion("BUILD_PROGRESS <=", value, "buildProgress");
			return (Criteria) this;
		}

		public Criteria andBuildProgressLike(String value) {
			addCriterion("BUILD_PROGRESS like", value, "buildProgress");
			return (Criteria) this;
		}

		public Criteria andBuildProgressNotLike(String value) {
			addCriterion("BUILD_PROGRESS not like", value, "buildProgress");
			return (Criteria) this;
		}

		public Criteria andBuildProgressIn(List<String> values) {
			addCriterion("BUILD_PROGRESS in", values, "buildProgress");
			return (Criteria) this;
		}

		public Criteria andBuildProgressNotIn(List<String> values) {
			addCriterion("BUILD_PROGRESS not in", values, "buildProgress");
			return (Criteria) this;
		}

		public Criteria andBuildProgressBetween(String value1, String value2) {
			addCriterion("BUILD_PROGRESS between", value1, value2, "buildProgress");
			return (Criteria) this;
		}

		public Criteria andBuildProgressNotBetween(String value1, String value2) {
			addCriterion("BUILD_PROGRESS not between", value1, value2, "buildProgress");
			return (Criteria) this;
		}

		public Criteria andProjectSpecIsNull() {
			addCriterion("PROJECT_SPEC is null");
			return (Criteria) this;
		}

		public Criteria andProjectSpecIsNotNull() {
			addCriterion("PROJECT_SPEC is not null");
			return (Criteria) this;
		}

		public Criteria andProjectSpecEqualTo(String value) {
			addCriterion("PROJECT_SPEC =", value, "projectSpec");
			return (Criteria) this;
		}

		public Criteria andProjectSpecNotEqualTo(String value) {
			addCriterion("PROJECT_SPEC <>", value, "projectSpec");
			return (Criteria) this;
		}

		public Criteria andProjectSpecGreaterThan(String value) {
			addCriterion("PROJECT_SPEC >", value, "projectSpec");
			return (Criteria) this;
		}

		public Criteria andProjectSpecGreaterThanOrEqualTo(String value) {
			addCriterion("PROJECT_SPEC >=", value, "projectSpec");
			return (Criteria) this;
		}

		public Criteria andProjectSpecLessThan(String value) {
			addCriterion("PROJECT_SPEC <", value, "projectSpec");
			return (Criteria) this;
		}

		public Criteria andProjectSpecLessThanOrEqualTo(String value) {
			addCriterion("PROJECT_SPEC <=", value, "projectSpec");
			return (Criteria) this;
		}

		public Criteria andProjectSpecLike(String value) {
			addCriterion("PROJECT_SPEC like", value, "projectSpec");
			return (Criteria) this;
		}

		public Criteria andProjectSpecNotLike(String value) {
			addCriterion("PROJECT_SPEC not like", value, "projectSpec");
			return (Criteria) this;
		}

		public Criteria andProjectSpecIn(List<String> values) {
			addCriterion("PROJECT_SPEC in", values, "projectSpec");
			return (Criteria) this;
		}

		public Criteria andProjectSpecNotIn(List<String> values) {
			addCriterion("PROJECT_SPEC not in", values, "projectSpec");
			return (Criteria) this;
		}

		public Criteria andProjectSpecBetween(String value1, String value2) {
			addCriterion("PROJECT_SPEC between", value1, value2, "projectSpec");
			return (Criteria) this;
		}

		public Criteria andProjectSpecNotBetween(String value1, String value2) {
			addCriterion("PROJECT_SPEC not between", value1, value2, "projectSpec");
			return (Criteria) this;
		}

		public Criteria andRightYearsIsNull() {
			addCriterion("RIGHT_YEARS is null");
			return (Criteria) this;
		}

		public Criteria andRightYearsIsNotNull() {
			addCriterion("RIGHT_YEARS is not null");
			return (Criteria) this;
		}

		public Criteria andRightYearsEqualTo(String value) {
			addCriterion("RIGHT_YEARS =", value, "rightYears");
			return (Criteria) this;
		}

		public Criteria andRightYearsNotEqualTo(String value) {
			addCriterion("RIGHT_YEARS <>", value, "rightYears");
			return (Criteria) this;
		}

		public Criteria andRightYearsGreaterThan(String value) {
			addCriterion("RIGHT_YEARS >", value, "rightYears");
			return (Criteria) this;
		}

		public Criteria andRightYearsGreaterThanOrEqualTo(String value) {
			addCriterion("RIGHT_YEARS >=", value, "rightYears");
			return (Criteria) this;
		}

		public Criteria andRightYearsLessThan(String value) {
			addCriterion("RIGHT_YEARS <", value, "rightYears");
			return (Criteria) this;
		}

		public Criteria andRightYearsLessThanOrEqualTo(String value) {
			addCriterion("RIGHT_YEARS <=", value, "rightYears");
			return (Criteria) this;
		}

		public Criteria andRightYearsLike(String value) {
			addCriterion("RIGHT_YEARS like", value, "rightYears");
			return (Criteria) this;
		}

		public Criteria andRightYearsNotLike(String value) {
			addCriterion("RIGHT_YEARS not like", value, "rightYears");
			return (Criteria) this;
		}

		public Criteria andRightYearsIn(List<String> values) {
			addCriterion("RIGHT_YEARS in", values, "rightYears");
			return (Criteria) this;
		}

		public Criteria andRightYearsNotIn(List<String> values) {
			addCriterion("RIGHT_YEARS not in", values, "rightYears");
			return (Criteria) this;
		}

		public Criteria andRightYearsBetween(String value1, String value2) {
			addCriterion("RIGHT_YEARS between", value1, value2, "rightYears");
			return (Criteria) this;
		}

		public Criteria andRightYearsNotBetween(String value1, String value2) {
			addCriterion("RIGHT_YEARS not between", value1, value2, "rightYears");
			return (Criteria) this;
		}

		public Criteria andBuildPermissionIsNull() {
			addCriterion("BUILD_PERMISSION is null");
			return (Criteria) this;
		}

		public Criteria andBuildPermissionIsNotNull() {
			addCriterion("BUILD_PERMISSION is not null");
			return (Criteria) this;
		}

		public Criteria andBuildPermissionEqualTo(String value) {
			addCriterion("BUILD_PERMISSION =", value, "buildPermission");
			return (Criteria) this;
		}

		public Criteria andBuildPermissionNotEqualTo(String value) {
			addCriterion("BUILD_PERMISSION <>", value, "buildPermission");
			return (Criteria) this;
		}

		public Criteria andBuildPermissionGreaterThan(String value) {
			addCriterion("BUILD_PERMISSION >", value, "buildPermission");
			return (Criteria) this;
		}

		public Criteria andBuildPermissionGreaterThanOrEqualTo(String value) {
			addCriterion("BUILD_PERMISSION >=", value, "buildPermission");
			return (Criteria) this;
		}

		public Criteria andBuildPermissionLessThan(String value) {
			addCriterion("BUILD_PERMISSION <", value, "buildPermission");
			return (Criteria) this;
		}

		public Criteria andBuildPermissionLessThanOrEqualTo(String value) {
			addCriterion("BUILD_PERMISSION <=", value, "buildPermission");
			return (Criteria) this;
		}

		public Criteria andBuildPermissionLike(String value) {
			addCriterion("BUILD_PERMISSION like", value, "buildPermission");
			return (Criteria) this;
		}

		public Criteria andBuildPermissionNotLike(String value) {
			addCriterion("BUILD_PERMISSION not like", value, "buildPermission");
			return (Criteria) this;
		}

		public Criteria andBuildPermissionIn(List<String> values) {
			addCriterion("BUILD_PERMISSION in", values, "buildPermission");
			return (Criteria) this;
		}

		public Criteria andBuildPermissionNotIn(List<String> values) {
			addCriterion("BUILD_PERMISSION not in", values, "buildPermission");
			return (Criteria) this;
		}

		public Criteria andBuildPermissionBetween(String value1, String value2) {
			addCriterion("BUILD_PERMISSION between", value1, value2, "buildPermission");
			return (Criteria) this;
		}

		public Criteria andBuildPermissionNotBetween(String value1, String value2) {
			addCriterion("BUILD_PERMISSION not between", value1, value2, "buildPermission");
			return (Criteria) this;
		}

		public Criteria andSellDateIsNull() {
			addCriterion("SELL_DATE is null");
			return (Criteria) this;
		}

		public Criteria andSellDateIsNotNull() {
			addCriterion("SELL_DATE is not null");
			return (Criteria) this;
		}

		public Criteria andSellDateEqualTo(String value) {
			addCriterion("SELL_DATE =", value, "sellDate");
			return (Criteria) this;
		}

		public Criteria andSellDateNotEqualTo(String value) {
			addCriterion("SELL_DATE <>", value, "sellDate");
			return (Criteria) this;
		}

		public Criteria andSellDateGreaterThan(String value) {
			addCriterion("SELL_DATE >", value, "sellDate");
			return (Criteria) this;
		}

		public Criteria andSellDateGreaterThanOrEqualTo(String value) {
			addCriterion("SELL_DATE >=", value, "sellDate");
			return (Criteria) this;
		}

		public Criteria andSellDateLessThan(String value) {
			addCriterion("SELL_DATE <", value, "sellDate");
			return (Criteria) this;
		}

		public Criteria andSellDateLessThanOrEqualTo(String value) {
			addCriterion("SELL_DATE <=", value, "sellDate");
			return (Criteria) this;
		}

		public Criteria andSellDateLike(String value) {
			addCriterion("SELL_DATE like", value, "sellDate");
			return (Criteria) this;
		}

		public Criteria andSellDateNotLike(String value) {
			addCriterion("SELL_DATE not like", value, "sellDate");
			return (Criteria) this;
		}

		public Criteria andSellDateIn(List<String> values) {
			addCriterion("SELL_DATE in", values, "sellDate");
			return (Criteria) this;
		}

		public Criteria andSellDateNotIn(List<String> values) {
			addCriterion("SELL_DATE not in", values, "sellDate");
			return (Criteria) this;
		}

		public Criteria andSellDateBetween(String value1, String value2) {
			addCriterion("SELL_DATE between", value1, value2, "sellDate");
			return (Criteria) this;
		}

		public Criteria andSellDateNotBetween(String value1, String value2) {
			addCriterion("SELL_DATE not between", value1, value2, "sellDate");
			return (Criteria) this;
		}

		public Criteria andFinishDateIsNull() {
			addCriterion("FINISH_DATE is null");
			return (Criteria) this;
		}

		public Criteria andFinishDateIsNotNull() {
			addCriterion("FINISH_DATE is not null");
			return (Criteria) this;
		}

		public Criteria andFinishDateEqualTo(String value) {
			addCriterion("FINISH_DATE =", value, "finishDate");
			return (Criteria) this;
		}

		public Criteria andFinishDateNotEqualTo(String value) {
			addCriterion("FINISH_DATE <>", value, "finishDate");
			return (Criteria) this;
		}

		public Criteria andFinishDateGreaterThan(String value) {
			addCriterion("FINISH_DATE >", value, "finishDate");
			return (Criteria) this;
		}

		public Criteria andFinishDateGreaterThanOrEqualTo(String value) {
			addCriterion("FINISH_DATE >=", value, "finishDate");
			return (Criteria) this;
		}

		public Criteria andFinishDateLessThan(String value) {
			addCriterion("FINISH_DATE <", value, "finishDate");
			return (Criteria) this;
		}

		public Criteria andFinishDateLessThanOrEqualTo(String value) {
			addCriterion("FINISH_DATE <=", value, "finishDate");
			return (Criteria) this;
		}

		public Criteria andFinishDateLike(String value) {
			addCriterion("FINISH_DATE like", value, "finishDate");
			return (Criteria) this;
		}

		public Criteria andFinishDateNotLike(String value) {
			addCriterion("FINISH_DATE not like", value, "finishDate");
			return (Criteria) this;
		}

		public Criteria andFinishDateIn(List<String> values) {
			addCriterion("FINISH_DATE in", values, "finishDate");
			return (Criteria) this;
		}

		public Criteria andFinishDateNotIn(List<String> values) {
			addCriterion("FINISH_DATE not in", values, "finishDate");
			return (Criteria) this;
		}

		public Criteria andFinishDateBetween(String value1, String value2) {
			addCriterion("FINISH_DATE between", value1, value2, "finishDate");
			return (Criteria) this;
		}

		public Criteria andFinishDateNotBetween(String value1, String value2) {
			addCriterion("FINISH_DATE not between", value1, value2, "finishDate");
			return (Criteria) this;
		}

		public Criteria andBuildFitmentIsNull() {
			addCriterion("BUILD_FITMENT is null");
			return (Criteria) this;
		}

		public Criteria andBuildFitmentIsNotNull() {
			addCriterion("BUILD_FITMENT is not null");
			return (Criteria) this;
		}

		public Criteria andBuildFitmentEqualTo(String value) {
			addCriterion("BUILD_FITMENT =", value, "buildFitment");
			return (Criteria) this;
		}

		public Criteria andBuildFitmentNotEqualTo(String value) {
			addCriterion("BUILD_FITMENT <>", value, "buildFitment");
			return (Criteria) this;
		}

		public Criteria andBuildFitmentGreaterThan(String value) {
			addCriterion("BUILD_FITMENT >", value, "buildFitment");
			return (Criteria) this;
		}

		public Criteria andBuildFitmentGreaterThanOrEqualTo(String value) {
			addCriterion("BUILD_FITMENT >=", value, "buildFitment");
			return (Criteria) this;
		}

		public Criteria andBuildFitmentLessThan(String value) {
			addCriterion("BUILD_FITMENT <", value, "buildFitment");
			return (Criteria) this;
		}

		public Criteria andBuildFitmentLessThanOrEqualTo(String value) {
			addCriterion("BUILD_FITMENT <=", value, "buildFitment");
			return (Criteria) this;
		}

		public Criteria andBuildFitmentLike(String value) {
			addCriterion("BUILD_FITMENT like", value, "buildFitment");
			return (Criteria) this;
		}

		public Criteria andBuildFitmentNotLike(String value) {
			addCriterion("BUILD_FITMENT not like", value, "buildFitment");
			return (Criteria) this;
		}

		public Criteria andBuildFitmentIn(List<String> values) {
			addCriterion("BUILD_FITMENT in", values, "buildFitment");
			return (Criteria) this;
		}

		public Criteria andBuildFitmentNotIn(List<String> values) {
			addCriterion("BUILD_FITMENT not in", values, "buildFitment");
			return (Criteria) this;
		}

		public Criteria andBuildFitmentBetween(String value1, String value2) {
			addCriterion("BUILD_FITMENT between", value1, value2, "buildFitment");
			return (Criteria) this;
		}

		public Criteria andBuildFitmentNotBetween(String value1, String value2) {
			addCriterion("BUILD_FITMENT not between", value1, value2, "buildFitment");
			return (Criteria) this;
		}

		public Criteria andConstractAreaIsNull() {
			addCriterion("CONSTRACT_AREA is null");
			return (Criteria) this;
		}

		public Criteria andConstractAreaIsNotNull() {
			addCriterion("CONSTRACT_AREA is not null");
			return (Criteria) this;
		}

		public Criteria andConstractAreaEqualTo(String value) {
			addCriterion("CONSTRACT_AREA =", value, "constractArea");
			return (Criteria) this;
		}

		public Criteria andConstractAreaNotEqualTo(String value) {
			addCriterion("CONSTRACT_AREA <>", value, "constractArea");
			return (Criteria) this;
		}

		public Criteria andConstractAreaGreaterThan(String value) {
			addCriterion("CONSTRACT_AREA >", value, "constractArea");
			return (Criteria) this;
		}

		public Criteria andConstractAreaGreaterThanOrEqualTo(String value) {
			addCriterion("CONSTRACT_AREA >=", value, "constractArea");
			return (Criteria) this;
		}

		public Criteria andConstractAreaLessThan(String value) {
			addCriterion("CONSTRACT_AREA <", value, "constractArea");
			return (Criteria) this;
		}

		public Criteria andConstractAreaLessThanOrEqualTo(String value) {
			addCriterion("CONSTRACT_AREA <=", value, "constractArea");
			return (Criteria) this;
		}

		public Criteria andConstractAreaLike(String value) {
			addCriterion("CONSTRACT_AREA like", value, "constractArea");
			return (Criteria) this;
		}

		public Criteria andConstractAreaNotLike(String value) {
			addCriterion("CONSTRACT_AREA not like", value, "constractArea");
			return (Criteria) this;
		}

		public Criteria andConstractAreaIn(List<String> values) {
			addCriterion("CONSTRACT_AREA in", values, "constractArea");
			return (Criteria) this;
		}

		public Criteria andConstractAreaNotIn(List<String> values) {
			addCriterion("CONSTRACT_AREA not in", values, "constractArea");
			return (Criteria) this;
		}

		public Criteria andConstractAreaBetween(String value1, String value2) {
			addCriterion("CONSTRACT_AREA between", value1, value2, "constractArea");
			return (Criteria) this;
		}

		public Criteria andConstractAreaNotBetween(String value1, String value2) {
			addCriterion("CONSTRACT_AREA not between", value1, value2, "constractArea");
			return (Criteria) this;
		}

		public Criteria andSellAddrIsNull() {
			addCriterion("SELL_ADDR is null");
			return (Criteria) this;
		}

		public Criteria andSellAddrIsNotNull() {
			addCriterion("SELL_ADDR is not null");
			return (Criteria) this;
		}

		public Criteria andSellAddrEqualTo(String value) {
			addCriterion("SELL_ADDR =", value, "sellAddr");
			return (Criteria) this;
		}

		public Criteria andSellAddrNotEqualTo(String value) {
			addCriterion("SELL_ADDR <>", value, "sellAddr");
			return (Criteria) this;
		}

		public Criteria andSellAddrGreaterThan(String value) {
			addCriterion("SELL_ADDR >", value, "sellAddr");
			return (Criteria) this;
		}

		public Criteria andSellAddrGreaterThanOrEqualTo(String value) {
			addCriterion("SELL_ADDR >=", value, "sellAddr");
			return (Criteria) this;
		}

		public Criteria andSellAddrLessThan(String value) {
			addCriterion("SELL_ADDR <", value, "sellAddr");
			return (Criteria) this;
		}

		public Criteria andSellAddrLessThanOrEqualTo(String value) {
			addCriterion("SELL_ADDR <=", value, "sellAddr");
			return (Criteria) this;
		}

		public Criteria andSellAddrLike(String value) {
			addCriterion("SELL_ADDR like", value, "sellAddr");
			return (Criteria) this;
		}

		public Criteria andSellAddrNotLike(String value) {
			addCriterion("SELL_ADDR not like", value, "sellAddr");
			return (Criteria) this;
		}

		public Criteria andSellAddrIn(List<String> values) {
			addCriterion("SELL_ADDR in", values, "sellAddr");
			return (Criteria) this;
		}

		public Criteria andSellAddrNotIn(List<String> values) {
			addCriterion("SELL_ADDR not in", values, "sellAddr");
			return (Criteria) this;
		}

		public Criteria andSellAddrBetween(String value1, String value2) {
			addCriterion("SELL_ADDR between", value1, value2, "sellAddr");
			return (Criteria) this;
		}

		public Criteria andSellAddrNotBetween(String value1, String value2) {
			addCriterion("SELL_ADDR not between", value1, value2, "sellAddr");
			return (Criteria) this;
		}

		public Criteria andSellTeleIsNull() {
			addCriterion("SELL_TELE is null");
			return (Criteria) this;
		}

		public Criteria andSellTeleIsNotNull() {
			addCriterion("SELL_TELE is not null");
			return (Criteria) this;
		}

		public Criteria andSellTeleEqualTo(String value) {
			addCriterion("SELL_TELE =", value, "sellTele");
			return (Criteria) this;
		}

		public Criteria andSellTeleNotEqualTo(String value) {
			addCriterion("SELL_TELE <>", value, "sellTele");
			return (Criteria) this;
		}

		public Criteria andSellTeleGreaterThan(String value) {
			addCriterion("SELL_TELE >", value, "sellTele");
			return (Criteria) this;
		}

		public Criteria andSellTeleGreaterThanOrEqualTo(String value) {
			addCriterion("SELL_TELE >=", value, "sellTele");
			return (Criteria) this;
		}

		public Criteria andSellTeleLessThan(String value) {
			addCriterion("SELL_TELE <", value, "sellTele");
			return (Criteria) this;
		}

		public Criteria andSellTeleLessThanOrEqualTo(String value) {
			addCriterion("SELL_TELE <=", value, "sellTele");
			return (Criteria) this;
		}

		public Criteria andSellTeleLike(String value) {
			addCriterion("SELL_TELE like", value, "sellTele");
			return (Criteria) this;
		}

		public Criteria andSellTeleNotLike(String value) {
			addCriterion("SELL_TELE not like", value, "sellTele");
			return (Criteria) this;
		}

		public Criteria andSellTeleIn(List<String> values) {
			addCriterion("SELL_TELE in", values, "sellTele");
			return (Criteria) this;
		}

		public Criteria andSellTeleNotIn(List<String> values) {
			addCriterion("SELL_TELE not in", values, "sellTele");
			return (Criteria) this;
		}

		public Criteria andSellTeleBetween(String value1, String value2) {
			addCriterion("SELL_TELE between", value1, value2, "sellTele");
			return (Criteria) this;
		}

		public Criteria andSellTeleNotBetween(String value1, String value2) {
			addCriterion("SELL_TELE not between", value1, value2, "sellTele");
			return (Criteria) this;
		}

		public Criteria andPriceIsNull() {
			addCriterion("PRICE is null");
			return (Criteria) this;
		}

		public Criteria andPriceIsNotNull() {
			addCriterion("PRICE is not null");
			return (Criteria) this;
		}

		public Criteria andPriceEqualTo(Integer value) {
			addCriterion("PRICE =", value, "price");
			return (Criteria) this;
		}

		public Criteria andPriceNotEqualTo(Integer value) {
			addCriterion("PRICE <>", value, "price");
			return (Criteria) this;
		}

		public Criteria andPriceGreaterThan(Integer value) {
			addCriterion("PRICE >", value, "price");
			return (Criteria) this;
		}

		public Criteria andPriceGreaterThanOrEqualTo(Integer value) {
			addCriterion("PRICE >=", value, "price");
			return (Criteria) this;
		}

		public Criteria andPriceLessThan(Integer value) {
			addCriterion("PRICE <", value, "price");
			return (Criteria) this;
		}

		public Criteria andPriceLessThanOrEqualTo(Integer value) {
			addCriterion("PRICE <=", value, "price");
			return (Criteria) this;
		}

		public Criteria andPriceIn(List<Integer> values) {
			addCriterion("PRICE in", values, "price");
			return (Criteria) this;
		}

		public Criteria andPriceNotIn(List<Integer> values) {
			addCriterion("PRICE not in", values, "price");
			return (Criteria) this;
		}

		public Criteria andPriceBetween(Integer value1, Integer value2) {
			addCriterion("PRICE between", value1, value2, "price");
			return (Criteria) this;
		}

		public Criteria andPriceNotBetween(Integer value1, Integer value2) {
			addCriterion("PRICE not between", value1, value2, "price");
			return (Criteria) this;
		}

		public Criteria andPriceTextIsNull() {
			addCriterion("PRICE_TEXT is null");
			return (Criteria) this;
		}

		public Criteria andPriceTextIsNotNull() {
			addCriterion("PRICE_TEXT is not null");
			return (Criteria) this;
		}

		public Criteria andPriceTextEqualTo(String value) {
			addCriterion("PRICE_TEXT =", value, "priceText");
			return (Criteria) this;
		}

		public Criteria andPriceTextNotEqualTo(String value) {
			addCriterion("PRICE_TEXT <>", value, "priceText");
			return (Criteria) this;
		}

		public Criteria andPriceTextGreaterThan(String value) {
			addCriterion("PRICE_TEXT >", value, "priceText");
			return (Criteria) this;
		}

		public Criteria andPriceTextGreaterThanOrEqualTo(String value) {
			addCriterion("PRICE_TEXT >=", value, "priceText");
			return (Criteria) this;
		}

		public Criteria andPriceTextLessThan(String value) {
			addCriterion("PRICE_TEXT <", value, "priceText");
			return (Criteria) this;
		}

		public Criteria andPriceTextLessThanOrEqualTo(String value) {
			addCriterion("PRICE_TEXT <=", value, "priceText");
			return (Criteria) this;
		}

		public Criteria andPriceTextLike(String value) {
			addCriterion("PRICE_TEXT like", value, "priceText");
			return (Criteria) this;
		}

		public Criteria andPriceTextNotLike(String value) {
			addCriterion("PRICE_TEXT not like", value, "priceText");
			return (Criteria) this;
		}

		public Criteria andPriceTextIn(List<String> values) {
			addCriterion("PRICE_TEXT in", values, "priceText");
			return (Criteria) this;
		}

		public Criteria andPriceTextNotIn(List<String> values) {
			addCriterion("PRICE_TEXT not in", values, "priceText");
			return (Criteria) this;
		}

		public Criteria andPriceTextBetween(String value1, String value2) {
			addCriterion("PRICE_TEXT between", value1, value2, "priceText");
			return (Criteria) this;
		}

		public Criteria andPriceTextNotBetween(String value1, String value2) {
			addCriterion("PRICE_TEXT not between", value1, value2, "priceText");
			return (Criteria) this;
		}

		public Criteria andPhotoExteriorIsNull() {
			addCriterion("PHOTO_EXTERIOR is null");
			return (Criteria) this;
		}

		public Criteria andPhotoExteriorIsNotNull() {
			addCriterion("PHOTO_EXTERIOR is not null");
			return (Criteria) this;
		}

		public Criteria andPhotoExteriorEqualTo(Integer value) {
			addCriterion("PHOTO_EXTERIOR =", value, "photoExterior");
			return (Criteria) this;
		}

		public Criteria andPhotoExteriorNotEqualTo(Integer value) {
			addCriterion("PHOTO_EXTERIOR <>", value, "photoExterior");
			return (Criteria) this;
		}

		public Criteria andPhotoExteriorGreaterThan(Integer value) {
			addCriterion("PHOTO_EXTERIOR >", value, "photoExterior");
			return (Criteria) this;
		}

		public Criteria andPhotoExteriorGreaterThanOrEqualTo(Integer value) {
			addCriterion("PHOTO_EXTERIOR >=", value, "photoExterior");
			return (Criteria) this;
		}

		public Criteria andPhotoExteriorLessThan(Integer value) {
			addCriterion("PHOTO_EXTERIOR <", value, "photoExterior");
			return (Criteria) this;
		}

		public Criteria andPhotoExteriorLessThanOrEqualTo(Integer value) {
			addCriterion("PHOTO_EXTERIOR <=", value, "photoExterior");
			return (Criteria) this;
		}

		public Criteria andPhotoExteriorIn(List<Integer> values) {
			addCriterion("PHOTO_EXTERIOR in", values, "photoExterior");
			return (Criteria) this;
		}

		public Criteria andPhotoExteriorNotIn(List<Integer> values) {
			addCriterion("PHOTO_EXTERIOR not in", values, "photoExterior");
			return (Criteria) this;
		}

		public Criteria andPhotoExteriorBetween(Integer value1, Integer value2) {
			addCriterion("PHOTO_EXTERIOR between", value1, value2, "photoExterior");
			return (Criteria) this;
		}

		public Criteria andPhotoExteriorNotBetween(Integer value1, Integer value2) {
			addCriterion("PHOTO_EXTERIOR not between", value1, value2, "photoExterior");
			return (Criteria) this;
		}

		public Criteria andPhotoEffectsIsNull() {
			addCriterion("PHOTO_EFFECTS is null");
			return (Criteria) this;
		}

		public Criteria andPhotoEffectsIsNotNull() {
			addCriterion("PHOTO_EFFECTS is not null");
			return (Criteria) this;
		}

		public Criteria andPhotoEffectsEqualTo(Integer value) {
			addCriterion("PHOTO_EFFECTS =", value, "photoEffects");
			return (Criteria) this;
		}

		public Criteria andPhotoEffectsNotEqualTo(Integer value) {
			addCriterion("PHOTO_EFFECTS <>", value, "photoEffects");
			return (Criteria) this;
		}

		public Criteria andPhotoEffectsGreaterThan(Integer value) {
			addCriterion("PHOTO_EFFECTS >", value, "photoEffects");
			return (Criteria) this;
		}

		public Criteria andPhotoEffectsGreaterThanOrEqualTo(Integer value) {
			addCriterion("PHOTO_EFFECTS >=", value, "photoEffects");
			return (Criteria) this;
		}

		public Criteria andPhotoEffectsLessThan(Integer value) {
			addCriterion("PHOTO_EFFECTS <", value, "photoEffects");
			return (Criteria) this;
		}

		public Criteria andPhotoEffectsLessThanOrEqualTo(Integer value) {
			addCriterion("PHOTO_EFFECTS <=", value, "photoEffects");
			return (Criteria) this;
		}

		public Criteria andPhotoEffectsIn(List<Integer> values) {
			addCriterion("PHOTO_EFFECTS in", values, "photoEffects");
			return (Criteria) this;
		}

		public Criteria andPhotoEffectsNotIn(List<Integer> values) {
			addCriterion("PHOTO_EFFECTS not in", values, "photoEffects");
			return (Criteria) this;
		}

		public Criteria andPhotoEffectsBetween(Integer value1, Integer value2) {
			addCriterion("PHOTO_EFFECTS between", value1, value2, "photoEffects");
			return (Criteria) this;
		}

		public Criteria andPhotoEffectsNotBetween(Integer value1, Integer value2) {
			addCriterion("PHOTO_EFFECTS not between", value1, value2, "photoEffects");
			return (Criteria) this;
		}

		public Criteria andPhotoModelIsNull() {
			addCriterion("PHOTO_MODEL is null");
			return (Criteria) this;
		}

		public Criteria andPhotoModelIsNotNull() {
			addCriterion("PHOTO_MODEL is not null");
			return (Criteria) this;
		}

		public Criteria andPhotoModelEqualTo(Integer value) {
			addCriterion("PHOTO_MODEL =", value, "photoModel");
			return (Criteria) this;
		}

		public Criteria andPhotoModelNotEqualTo(Integer value) {
			addCriterion("PHOTO_MODEL <>", value, "photoModel");
			return (Criteria) this;
		}

		public Criteria andPhotoModelGreaterThan(Integer value) {
			addCriterion("PHOTO_MODEL >", value, "photoModel");
			return (Criteria) this;
		}

		public Criteria andPhotoModelGreaterThanOrEqualTo(Integer value) {
			addCriterion("PHOTO_MODEL >=", value, "photoModel");
			return (Criteria) this;
		}

		public Criteria andPhotoModelLessThan(Integer value) {
			addCriterion("PHOTO_MODEL <", value, "photoModel");
			return (Criteria) this;
		}

		public Criteria andPhotoModelLessThanOrEqualTo(Integer value) {
			addCriterion("PHOTO_MODEL <=", value, "photoModel");
			return (Criteria) this;
		}

		public Criteria andPhotoModelIn(List<Integer> values) {
			addCriterion("PHOTO_MODEL in", values, "photoModel");
			return (Criteria) this;
		}

		public Criteria andPhotoModelNotIn(List<Integer> values) {
			addCriterion("PHOTO_MODEL not in", values, "photoModel");
			return (Criteria) this;
		}

		public Criteria andPhotoModelBetween(Integer value1, Integer value2) {
			addCriterion("PHOTO_MODEL between", value1, value2, "photoModel");
			return (Criteria) this;
		}

		public Criteria andPhotoModelNotBetween(Integer value1, Integer value2) {
			addCriterion("PHOTO_MODEL not between", value1, value2, "photoModel");
			return (Criteria) this;
		}

		public Criteria andPhotoTrafficIsNull() {
			addCriterion("PHOTO_TRAFFIC is null");
			return (Criteria) this;
		}

		public Criteria andPhotoTrafficIsNotNull() {
			addCriterion("PHOTO_TRAFFIC is not null");
			return (Criteria) this;
		}

		public Criteria andPhotoTrafficEqualTo(Integer value) {
			addCriterion("PHOTO_TRAFFIC =", value, "photoTraffic");
			return (Criteria) this;
		}

		public Criteria andPhotoTrafficNotEqualTo(Integer value) {
			addCriterion("PHOTO_TRAFFIC <>", value, "photoTraffic");
			return (Criteria) this;
		}

		public Criteria andPhotoTrafficGreaterThan(Integer value) {
			addCriterion("PHOTO_TRAFFIC >", value, "photoTraffic");
			return (Criteria) this;
		}

		public Criteria andPhotoTrafficGreaterThanOrEqualTo(Integer value) {
			addCriterion("PHOTO_TRAFFIC >=", value, "photoTraffic");
			return (Criteria) this;
		}

		public Criteria andPhotoTrafficLessThan(Integer value) {
			addCriterion("PHOTO_TRAFFIC <", value, "photoTraffic");
			return (Criteria) this;
		}

		public Criteria andPhotoTrafficLessThanOrEqualTo(Integer value) {
			addCriterion("PHOTO_TRAFFIC <=", value, "photoTraffic");
			return (Criteria) this;
		}

		public Criteria andPhotoTrafficIn(List<Integer> values) {
			addCriterion("PHOTO_TRAFFIC in", values, "photoTraffic");
			return (Criteria) this;
		}

		public Criteria andPhotoTrafficNotIn(List<Integer> values) {
			addCriterion("PHOTO_TRAFFIC not in", values, "photoTraffic");
			return (Criteria) this;
		}

		public Criteria andPhotoTrafficBetween(Integer value1, Integer value2) {
			addCriterion("PHOTO_TRAFFIC between", value1, value2, "photoTraffic");
			return (Criteria) this;
		}

		public Criteria andPhotoTrafficNotBetween(Integer value1, Integer value2) {
			addCriterion("PHOTO_TRAFFIC not between", value1, value2, "photoTraffic");
			return (Criteria) this;
		}

		public Criteria andPhotoPlanIsNull() {
			addCriterion("PHOTO_PLAN is null");
			return (Criteria) this;
		}

		public Criteria andPhotoPlanIsNotNull() {
			addCriterion("PHOTO_PLAN is not null");
			return (Criteria) this;
		}

		public Criteria andPhotoPlanEqualTo(Integer value) {
			addCriterion("PHOTO_PLAN =", value, "photoPlan");
			return (Criteria) this;
		}

		public Criteria andPhotoPlanNotEqualTo(Integer value) {
			addCriterion("PHOTO_PLAN <>", value, "photoPlan");
			return (Criteria) this;
		}

		public Criteria andPhotoPlanGreaterThan(Integer value) {
			addCriterion("PHOTO_PLAN >", value, "photoPlan");
			return (Criteria) this;
		}

		public Criteria andPhotoPlanGreaterThanOrEqualTo(Integer value) {
			addCriterion("PHOTO_PLAN >=", value, "photoPlan");
			return (Criteria) this;
		}

		public Criteria andPhotoPlanLessThan(Integer value) {
			addCriterion("PHOTO_PLAN <", value, "photoPlan");
			return (Criteria) this;
		}

		public Criteria andPhotoPlanLessThanOrEqualTo(Integer value) {
			addCriterion("PHOTO_PLAN <=", value, "photoPlan");
			return (Criteria) this;
		}

		public Criteria andPhotoPlanIn(List<Integer> values) {
			addCriterion("PHOTO_PLAN in", values, "photoPlan");
			return (Criteria) this;
		}

		public Criteria andPhotoPlanNotIn(List<Integer> values) {
			addCriterion("PHOTO_PLAN not in", values, "photoPlan");
			return (Criteria) this;
		}

		public Criteria andPhotoPlanBetween(Integer value1, Integer value2) {
			addCriterion("PHOTO_PLAN between", value1, value2, "photoPlan");
			return (Criteria) this;
		}

		public Criteria andPhotoPlanNotBetween(Integer value1, Integer value2) {
			addCriterion("PHOTO_PLAN not between", value1, value2, "photoPlan");
			return (Criteria) this;
		}

		public Criteria andPhotoSetIsNull() {
			addCriterion("PHOTO_SET is null");
			return (Criteria) this;
		}

		public Criteria andPhotoSetIsNotNull() {
			addCriterion("PHOTO_SET is not null");
			return (Criteria) this;
		}

		public Criteria andPhotoSetEqualTo(Integer value) {
			addCriterion("PHOTO_SET =", value, "photoSet");
			return (Criteria) this;
		}

		public Criteria andPhotoSetNotEqualTo(Integer value) {
			addCriterion("PHOTO_SET <>", value, "photoSet");
			return (Criteria) this;
		}

		public Criteria andPhotoSetGreaterThan(Integer value) {
			addCriterion("PHOTO_SET >", value, "photoSet");
			return (Criteria) this;
		}

		public Criteria andPhotoSetGreaterThanOrEqualTo(Integer value) {
			addCriterion("PHOTO_SET >=", value, "photoSet");
			return (Criteria) this;
		}

		public Criteria andPhotoSetLessThan(Integer value) {
			addCriterion("PHOTO_SET <", value, "photoSet");
			return (Criteria) this;
		}

		public Criteria andPhotoSetLessThanOrEqualTo(Integer value) {
			addCriterion("PHOTO_SET <=", value, "photoSet");
			return (Criteria) this;
		}

		public Criteria andPhotoSetIn(List<Integer> values) {
			addCriterion("PHOTO_SET in", values, "photoSet");
			return (Criteria) this;
		}

		public Criteria andPhotoSetNotIn(List<Integer> values) {
			addCriterion("PHOTO_SET not in", values, "photoSet");
			return (Criteria) this;
		}

		public Criteria andPhotoSetBetween(Integer value1, Integer value2) {
			addCriterion("PHOTO_SET between", value1, value2, "photoSet");
			return (Criteria) this;
		}

		public Criteria andPhotoSetNotBetween(Integer value1, Integer value2) {
			addCriterion("PHOTO_SET not between", value1, value2, "photoSet");
			return (Criteria) this;
		}

		public Criteria andPhotoTempletIsNull() {
			addCriterion("PHOTO_TEMPLET is null");
			return (Criteria) this;
		}

		public Criteria andPhotoTempletIsNotNull() {
			addCriterion("PHOTO_TEMPLET is not null");
			return (Criteria) this;
		}

		public Criteria andPhotoTempletEqualTo(Integer value) {
			addCriterion("PHOTO_TEMPLET =", value, "photoTemplet");
			return (Criteria) this;
		}

		public Criteria andPhotoTempletNotEqualTo(Integer value) {
			addCriterion("PHOTO_TEMPLET <>", value, "photoTemplet");
			return (Criteria) this;
		}

		public Criteria andPhotoTempletGreaterThan(Integer value) {
			addCriterion("PHOTO_TEMPLET >", value, "photoTemplet");
			return (Criteria) this;
		}

		public Criteria andPhotoTempletGreaterThanOrEqualTo(Integer value) {
			addCriterion("PHOTO_TEMPLET >=", value, "photoTemplet");
			return (Criteria) this;
		}

		public Criteria andPhotoTempletLessThan(Integer value) {
			addCriterion("PHOTO_TEMPLET <", value, "photoTemplet");
			return (Criteria) this;
		}

		public Criteria andPhotoTempletLessThanOrEqualTo(Integer value) {
			addCriterion("PHOTO_TEMPLET <=", value, "photoTemplet");
			return (Criteria) this;
		}

		public Criteria andPhotoTempletIn(List<Integer> values) {
			addCriterion("PHOTO_TEMPLET in", values, "photoTemplet");
			return (Criteria) this;
		}

		public Criteria andPhotoTempletNotIn(List<Integer> values) {
			addCriterion("PHOTO_TEMPLET not in", values, "photoTemplet");
			return (Criteria) this;
		}

		public Criteria andPhotoTempletBetween(Integer value1, Integer value2) {
			addCriterion("PHOTO_TEMPLET between", value1, value2, "photoTemplet");
			return (Criteria) this;
		}

		public Criteria andPhotoTempletNotBetween(Integer value1, Integer value2) {
			addCriterion("PHOTO_TEMPLET not between", value1, value2, "photoTemplet");
			return (Criteria) this;
		}

		public Criteria andNewFlagIsNull() {
			addCriterion("NEW_FLAG is null");
			return (Criteria) this;
		}

		public Criteria andNewFlagIsNotNull() {
			addCriterion("NEW_FLAG is not null");
			return (Criteria) this;
		}

		public Criteria andNewFlagEqualTo(Byte value) {
			addCriterion("NEW_FLAG =", value, "newFlag");
			return (Criteria) this;
		}

		public Criteria andNewFlagNotEqualTo(Byte value) {
			addCriterion("NEW_FLAG <>", value, "newFlag");
			return (Criteria) this;
		}

		public Criteria andNewFlagGreaterThan(Byte value) {
			addCriterion("NEW_FLAG >", value, "newFlag");
			return (Criteria) this;
		}

		public Criteria andNewFlagGreaterThanOrEqualTo(Byte value) {
			addCriterion("NEW_FLAG >=", value, "newFlag");
			return (Criteria) this;
		}

		public Criteria andNewFlagLessThan(Byte value) {
			addCriterion("NEW_FLAG <", value, "newFlag");
			return (Criteria) this;
		}

		public Criteria andNewFlagLessThanOrEqualTo(Byte value) {
			addCriterion("NEW_FLAG <=", value, "newFlag");
			return (Criteria) this;
		}

		public Criteria andNewFlagIn(List<Byte> values) {
			addCriterion("NEW_FLAG in", values, "newFlag");
			return (Criteria) this;
		}

		public Criteria andNewFlagNotIn(List<Byte> values) {
			addCriterion("NEW_FLAG not in", values, "newFlag");
			return (Criteria) this;
		}

		public Criteria andNewFlagBetween(Byte value1, Byte value2) {
			addCriterion("NEW_FLAG between", value1, value2, "newFlag");
			return (Criteria) this;
		}

		public Criteria andNewFlagNotBetween(Byte value1, Byte value2) {
			addCriterion("NEW_FLAG not between", value1, value2, "newFlag");
			return (Criteria) this;
		}

		public Criteria andExamPhotoIsNull() {
			addCriterion("EXAM_PHOTO is null");
			return (Criteria) this;
		}

		public Criteria andExamPhotoIsNotNull() {
			addCriterion("EXAM_PHOTO is not null");
			return (Criteria) this;
		}

		public Criteria andExamPhotoEqualTo(Byte value) {
			addCriterion("EXAM_PHOTO =", value, "examPhoto");
			return (Criteria) this;
		}

		public Criteria andExamPhotoNotEqualTo(Byte value) {
			addCriterion("EXAM_PHOTO <>", value, "examPhoto");
			return (Criteria) this;
		}

		public Criteria andExamPhotoGreaterThan(Byte value) {
			addCriterion("EXAM_PHOTO >", value, "examPhoto");
			return (Criteria) this;
		}

		public Criteria andExamPhotoGreaterThanOrEqualTo(Byte value) {
			addCriterion("EXAM_PHOTO >=", value, "examPhoto");
			return (Criteria) this;
		}

		public Criteria andExamPhotoLessThan(Byte value) {
			addCriterion("EXAM_PHOTO <", value, "examPhoto");
			return (Criteria) this;
		}

		public Criteria andExamPhotoLessThanOrEqualTo(Byte value) {
			addCriterion("EXAM_PHOTO <=", value, "examPhoto");
			return (Criteria) this;
		}

		public Criteria andExamPhotoIn(List<Byte> values) {
			addCriterion("EXAM_PHOTO in", values, "examPhoto");
			return (Criteria) this;
		}

		public Criteria andExamPhotoNotIn(List<Byte> values) {
			addCriterion("EXAM_PHOTO not in", values, "examPhoto");
			return (Criteria) this;
		}

		public Criteria andExamPhotoBetween(Byte value1, Byte value2) {
			addCriterion("EXAM_PHOTO between", value1, value2, "examPhoto");
			return (Criteria) this;
		}

		public Criteria andExamPhotoNotBetween(Byte value1, Byte value2) {
			addCriterion("EXAM_PHOTO not between", value1, value2, "examPhoto");
			return (Criteria) this;
		}

		public Criteria andSellTele1IsNull() {
			addCriterion("SELL_TELE1 is null");
			return (Criteria) this;
		}

		public Criteria andSellTele1IsNotNull() {
			addCriterion("SELL_TELE1 is not null");
			return (Criteria) this;
		}

		public Criteria andSellTele1EqualTo(String value) {
			addCriterion("SELL_TELE1 =", value, "sellTele1");
			return (Criteria) this;
		}

		public Criteria andSellTele1NotEqualTo(String value) {
			addCriterion("SELL_TELE1 <>", value, "sellTele1");
			return (Criteria) this;
		}

		public Criteria andSellTele1GreaterThan(String value) {
			addCriterion("SELL_TELE1 >", value, "sellTele1");
			return (Criteria) this;
		}

		public Criteria andSellTele1GreaterThanOrEqualTo(String value) {
			addCriterion("SELL_TELE1 >=", value, "sellTele1");
			return (Criteria) this;
		}

		public Criteria andSellTele1LessThan(String value) {
			addCriterion("SELL_TELE1 <", value, "sellTele1");
			return (Criteria) this;
		}

		public Criteria andSellTele1LessThanOrEqualTo(String value) {
			addCriterion("SELL_TELE1 <=", value, "sellTele1");
			return (Criteria) this;
		}

		public Criteria andSellTele1Like(String value) {
			addCriterion("SELL_TELE1 like", value, "sellTele1");
			return (Criteria) this;
		}

		public Criteria andSellTele1NotLike(String value) {
			addCriterion("SELL_TELE1 not like", value, "sellTele1");
			return (Criteria) this;
		}

		public Criteria andSellTele1In(List<String> values) {
			addCriterion("SELL_TELE1 in", values, "sellTele1");
			return (Criteria) this;
		}

		public Criteria andSellTele1NotIn(List<String> values) {
			addCriterion("SELL_TELE1 not in", values, "sellTele1");
			return (Criteria) this;
		}

		public Criteria andSellTele1Between(String value1, String value2) {
			addCriterion("SELL_TELE1 between", value1, value2, "sellTele1");
			return (Criteria) this;
		}

		public Criteria andSellTele1NotBetween(String value1, String value2) {
			addCriterion("SELL_TELE1 not between", value1, value2, "sellTele1");
			return (Criteria) this;
		}

		public Criteria andTele400IsNull() {
			addCriterion("TELE400 is null");
			return (Criteria) this;
		}

		public Criteria andTele400IsNotNull() {
			addCriterion("TELE400 is not null");
			return (Criteria) this;
		}

		public Criteria andTele400EqualTo(String value) {
			addCriterion("TELE400 =", value, "tele400");
			return (Criteria) this;
		}

		public Criteria andTele400NotEqualTo(String value) {
			addCriterion("TELE400 <>", value, "tele400");
			return (Criteria) this;
		}

		public Criteria andTele400GreaterThan(String value) {
			addCriterion("TELE400 >", value, "tele400");
			return (Criteria) this;
		}

		public Criteria andTele400GreaterThanOrEqualTo(String value) {
			addCriterion("TELE400 >=", value, "tele400");
			return (Criteria) this;
		}

		public Criteria andTele400LessThan(String value) {
			addCriterion("TELE400 <", value, "tele400");
			return (Criteria) this;
		}

		public Criteria andTele400LessThanOrEqualTo(String value) {
			addCriterion("TELE400 <=", value, "tele400");
			return (Criteria) this;
		}

		public Criteria andTele400Like(String value) {
			addCriterion("TELE400 like", value, "tele400");
			return (Criteria) this;
		}

		public Criteria andTele400NotLike(String value) {
			addCriterion("TELE400 not like", value, "tele400");
			return (Criteria) this;
		}

		public Criteria andTele400In(List<String> values) {
			addCriterion("TELE400 in", values, "tele400");
			return (Criteria) this;
		}

		public Criteria andTele400NotIn(List<String> values) {
			addCriterion("TELE400 not in", values, "tele400");
			return (Criteria) this;
		}

		public Criteria andTele400Between(String value1, String value2) {
			addCriterion("TELE400 between", value1, value2, "tele400");
			return (Criteria) this;
		}

		public Criteria andTele400NotBetween(String value1, String value2) {
			addCriterion("TELE400 not between", value1, value2, "tele400");
			return (Criteria) this;
		}

		public Criteria andExtcodeIsNull() {
			addCriterion("EXTCODE is null");
			return (Criteria) this;
		}

		public Criteria andExtcodeIsNotNull() {
			addCriterion("EXTCODE is not null");
			return (Criteria) this;
		}

		public Criteria andExtcodeEqualTo(String value) {
			addCriterion("EXTCODE =", value, "extcode");
			return (Criteria) this;
		}

		public Criteria andExtcodeNotEqualTo(String value) {
			addCriterion("EXTCODE <>", value, "extcode");
			return (Criteria) this;
		}

		public Criteria andExtcodeGreaterThan(String value) {
			addCriterion("EXTCODE >", value, "extcode");
			return (Criteria) this;
		}

		public Criteria andExtcodeGreaterThanOrEqualTo(String value) {
			addCriterion("EXTCODE >=", value, "extcode");
			return (Criteria) this;
		}

		public Criteria andExtcodeLessThan(String value) {
			addCriterion("EXTCODE <", value, "extcode");
			return (Criteria) this;
		}

		public Criteria andExtcodeLessThanOrEqualTo(String value) {
			addCriterion("EXTCODE <=", value, "extcode");
			return (Criteria) this;
		}

		public Criteria andExtcodeLike(String value) {
			addCriterion("EXTCODE like", value, "extcode");
			return (Criteria) this;
		}

		public Criteria andExtcodeNotLike(String value) {
			addCriterion("EXTCODE not like", value, "extcode");
			return (Criteria) this;
		}

		public Criteria andExtcodeIn(List<String> values) {
			addCriterion("EXTCODE in", values, "extcode");
			return (Criteria) this;
		}

		public Criteria andExtcodeNotIn(List<String> values) {
			addCriterion("EXTCODE not in", values, "extcode");
			return (Criteria) this;
		}

		public Criteria andExtcodeBetween(String value1, String value2) {
			addCriterion("EXTCODE between", value1, value2, "extcode");
			return (Criteria) this;
		}

		public Criteria andExtcodeNotBetween(String value1, String value2) {
			addCriterion("EXTCODE not between", value1, value2, "extcode");
			return (Criteria) this;
		}

		public Criteria andFpropertyunitIsNull() {
			addCriterion("FPropertyUnit is null");
			return (Criteria) this;
		}

		public Criteria andFpropertyunitIsNotNull() {
			addCriterion("FPropertyUnit is not null");
			return (Criteria) this;
		}

		public Criteria andFpropertyunitEqualTo(Integer value) {
			addCriterion("FPropertyUnit =", value, "fpropertyunit");
			return (Criteria) this;
		}

		public Criteria andFpropertyunitNotEqualTo(Integer value) {
			addCriterion("FPropertyUnit <>", value, "fpropertyunit");
			return (Criteria) this;
		}

		public Criteria andFpropertyunitGreaterThan(Integer value) {
			addCriterion("FPropertyUnit >", value, "fpropertyunit");
			return (Criteria) this;
		}

		public Criteria andFpropertyunitGreaterThanOrEqualTo(Integer value) {
			addCriterion("FPropertyUnit >=", value, "fpropertyunit");
			return (Criteria) this;
		}

		public Criteria andFpropertyunitLessThan(Integer value) {
			addCriterion("FPropertyUnit <", value, "fpropertyunit");
			return (Criteria) this;
		}

		public Criteria andFpropertyunitLessThanOrEqualTo(Integer value) {
			addCriterion("FPropertyUnit <=", value, "fpropertyunit");
			return (Criteria) this;
		}

		public Criteria andFpropertyunitIn(List<Integer> values) {
			addCriterion("FPropertyUnit in", values, "fpropertyunit");
			return (Criteria) this;
		}

		public Criteria andFpropertyunitNotIn(List<Integer> values) {
			addCriterion("FPropertyUnit not in", values, "fpropertyunit");
			return (Criteria) this;
		}

		public Criteria andFpropertyunitBetween(Integer value1, Integer value2) {
			addCriterion("FPropertyUnit between", value1, value2, "fpropertyunit");
			return (Criteria) this;
		}

		public Criteria andFpropertyunitNotBetween(Integer value1, Integer value2) {
			addCriterion("FPropertyUnit not between", value1, value2, "fpropertyunit");
			return (Criteria) this;
		}

		public Criteria andFbroadbandIsNull() {
			addCriterion("Fbroadband is null");
			return (Criteria) this;
		}

		public Criteria andFbroadbandIsNotNull() {
			addCriterion("Fbroadband is not null");
			return (Criteria) this;
		}

		public Criteria andFbroadbandEqualTo(String value) {
			addCriterion("Fbroadband =", value, "fbroadband");
			return (Criteria) this;
		}

		public Criteria andFbroadbandNotEqualTo(String value) {
			addCriterion("Fbroadband <>", value, "fbroadband");
			return (Criteria) this;
		}

		public Criteria andFbroadbandGreaterThan(String value) {
			addCriterion("Fbroadband >", value, "fbroadband");
			return (Criteria) this;
		}

		public Criteria andFbroadbandGreaterThanOrEqualTo(String value) {
			addCriterion("Fbroadband >=", value, "fbroadband");
			return (Criteria) this;
		}

		public Criteria andFbroadbandLessThan(String value) {
			addCriterion("Fbroadband <", value, "fbroadband");
			return (Criteria) this;
		}

		public Criteria andFbroadbandLessThanOrEqualTo(String value) {
			addCriterion("Fbroadband <=", value, "fbroadband");
			return (Criteria) this;
		}

		public Criteria andFbroadbandLike(String value) {
			addCriterion("Fbroadband like", value, "fbroadband");
			return (Criteria) this;
		}

		public Criteria andFbroadbandNotLike(String value) {
			addCriterion("Fbroadband not like", value, "fbroadband");
			return (Criteria) this;
		}

		public Criteria andFbroadbandIn(List<String> values) {
			addCriterion("Fbroadband in", values, "fbroadband");
			return (Criteria) this;
		}

		public Criteria andFbroadbandNotIn(List<String> values) {
			addCriterion("Fbroadband not in", values, "fbroadband");
			return (Criteria) this;
		}

		public Criteria andFbroadbandBetween(String value1, String value2) {
			addCriterion("Fbroadband between", value1, value2, "fbroadband");
			return (Criteria) this;
		}

		public Criteria andFbroadbandNotBetween(String value1, String value2) {
			addCriterion("Fbroadband not between", value1, value2, "fbroadband");
			return (Criteria) this;
		}

		public Criteria andFdrinkingwaterIsNull() {
			addCriterion("FDrinkingWater is null");
			return (Criteria) this;
		}

		public Criteria andFdrinkingwaterIsNotNull() {
			addCriterion("FDrinkingWater is not null");
			return (Criteria) this;
		}

		public Criteria andFdrinkingwaterEqualTo(String value) {
			addCriterion("FDrinkingWater =", value, "fdrinkingwater");
			return (Criteria) this;
		}

		public Criteria andFdrinkingwaterNotEqualTo(String value) {
			addCriterion("FDrinkingWater <>", value, "fdrinkingwater");
			return (Criteria) this;
		}

		public Criteria andFdrinkingwaterGreaterThan(String value) {
			addCriterion("FDrinkingWater >", value, "fdrinkingwater");
			return (Criteria) this;
		}

		public Criteria andFdrinkingwaterGreaterThanOrEqualTo(String value) {
			addCriterion("FDrinkingWater >=", value, "fdrinkingwater");
			return (Criteria) this;
		}

		public Criteria andFdrinkingwaterLessThan(String value) {
			addCriterion("FDrinkingWater <", value, "fdrinkingwater");
			return (Criteria) this;
		}

		public Criteria andFdrinkingwaterLessThanOrEqualTo(String value) {
			addCriterion("FDrinkingWater <=", value, "fdrinkingwater");
			return (Criteria) this;
		}

		public Criteria andFdrinkingwaterLike(String value) {
			addCriterion("FDrinkingWater like", value, "fdrinkingwater");
			return (Criteria) this;
		}

		public Criteria andFdrinkingwaterNotLike(String value) {
			addCriterion("FDrinkingWater not like", value, "fdrinkingwater");
			return (Criteria) this;
		}

		public Criteria andFdrinkingwaterIn(List<String> values) {
			addCriterion("FDrinkingWater in", values, "fdrinkingwater");
			return (Criteria) this;
		}

		public Criteria andFdrinkingwaterNotIn(List<String> values) {
			addCriterion("FDrinkingWater not in", values, "fdrinkingwater");
			return (Criteria) this;
		}

		public Criteria andFdrinkingwaterBetween(String value1, String value2) {
			addCriterion("FDrinkingWater between", value1, value2, "fdrinkingwater");
			return (Criteria) this;
		}

		public Criteria andFdrinkingwaterNotBetween(String value1, String value2) {
			addCriterion("FDrinkingWater not between", value1, value2, "fdrinkingwater");
			return (Criteria) this;
		}

		public Criteria andFgasIsNull() {
			addCriterion("FGas is null");
			return (Criteria) this;
		}

		public Criteria andFgasIsNotNull() {
			addCriterion("FGas is not null");
			return (Criteria) this;
		}

		public Criteria andFgasEqualTo(String value) {
			addCriterion("FGas =", value, "fgas");
			return (Criteria) this;
		}

		public Criteria andFgasNotEqualTo(String value) {
			addCriterion("FGas <>", value, "fgas");
			return (Criteria) this;
		}

		public Criteria andFgasGreaterThan(String value) {
			addCriterion("FGas >", value, "fgas");
			return (Criteria) this;
		}

		public Criteria andFgasGreaterThanOrEqualTo(String value) {
			addCriterion("FGas >=", value, "fgas");
			return (Criteria) this;
		}

		public Criteria andFgasLessThan(String value) {
			addCriterion("FGas <", value, "fgas");
			return (Criteria) this;
		}

		public Criteria andFgasLessThanOrEqualTo(String value) {
			addCriterion("FGas <=", value, "fgas");
			return (Criteria) this;
		}

		public Criteria andFgasLike(String value) {
			addCriterion("FGas like", value, "fgas");
			return (Criteria) this;
		}

		public Criteria andFgasNotLike(String value) {
			addCriterion("FGas not like", value, "fgas");
			return (Criteria) this;
		}

		public Criteria andFgasIn(List<String> values) {
			addCriterion("FGas in", values, "fgas");
			return (Criteria) this;
		}

		public Criteria andFgasNotIn(List<String> values) {
			addCriterion("FGas not in", values, "fgas");
			return (Criteria) this;
		}

		public Criteria andFgasBetween(String value1, String value2) {
			addCriterion("FGas between", value1, value2, "fgas");
			return (Criteria) this;
		}

		public Criteria andFgasNotBetween(String value1, String value2) {
			addCriterion("FGas not between", value1, value2, "fgas");
			return (Criteria) this;
		}

		public Criteria andFparkidsIsNull() {
			addCriterion("FParkIds is null");
			return (Criteria) this;
		}

		public Criteria andFparkidsIsNotNull() {
			addCriterion("FParkIds is not null");
			return (Criteria) this;
		}

		public Criteria andFparkidsEqualTo(String value) {
			addCriterion("FParkIds =", value, "fparkids");
			return (Criteria) this;
		}

		public Criteria andFparkidsNotEqualTo(String value) {
			addCriterion("FParkIds <>", value, "fparkids");
			return (Criteria) this;
		}

		public Criteria andFparkidsGreaterThan(String value) {
			addCriterion("FParkIds >", value, "fparkids");
			return (Criteria) this;
		}

		public Criteria andFparkidsGreaterThanOrEqualTo(String value) {
			addCriterion("FParkIds >=", value, "fparkids");
			return (Criteria) this;
		}

		public Criteria andFparkidsLessThan(String value) {
			addCriterion("FParkIds <", value, "fparkids");
			return (Criteria) this;
		}

		public Criteria andFparkidsLessThanOrEqualTo(String value) {
			addCriterion("FParkIds <=", value, "fparkids");
			return (Criteria) this;
		}

		public Criteria andFparkidsLike(String value) {
			addCriterion("FParkIds like", value, "fparkids");
			return (Criteria) this;
		}

		public Criteria andFparkidsNotLike(String value) {
			addCriterion("FParkIds not like", value, "fparkids");
			return (Criteria) this;
		}

		public Criteria andFparkidsIn(List<String> values) {
			addCriterion("FParkIds in", values, "fparkids");
			return (Criteria) this;
		}

		public Criteria andFparkidsNotIn(List<String> values) {
			addCriterion("FParkIds not in", values, "fparkids");
			return (Criteria) this;
		}

		public Criteria andFparkidsBetween(String value1, String value2) {
			addCriterion("FParkIds between", value1, value2, "fparkids");
			return (Criteria) this;
		}

		public Criteria andFparkidsNotBetween(String value1, String value2) {
			addCriterion("FParkIds not between", value1, value2, "fparkids");
			return (Criteria) this;
		}

		public Criteria andFinvestorIsNull() {
			addCriterion("FInvestor is null");
			return (Criteria) this;
		}

		public Criteria andFinvestorIsNotNull() {
			addCriterion("FInvestor is not null");
			return (Criteria) this;
		}

		public Criteria andFinvestorEqualTo(String value) {
			addCriterion("FInvestor =", value, "finvestor");
			return (Criteria) this;
		}

		public Criteria andFinvestorNotEqualTo(String value) {
			addCriterion("FInvestor <>", value, "finvestor");
			return (Criteria) this;
		}

		public Criteria andFinvestorGreaterThan(String value) {
			addCriterion("FInvestor >", value, "finvestor");
			return (Criteria) this;
		}

		public Criteria andFinvestorGreaterThanOrEqualTo(String value) {
			addCriterion("FInvestor >=", value, "finvestor");
			return (Criteria) this;
		}

		public Criteria andFinvestorLessThan(String value) {
			addCriterion("FInvestor <", value, "finvestor");
			return (Criteria) this;
		}

		public Criteria andFinvestorLessThanOrEqualTo(String value) {
			addCriterion("FInvestor <=", value, "finvestor");
			return (Criteria) this;
		}

		public Criteria andFinvestorLike(String value) {
			addCriterion("FInvestor like", value, "finvestor");
			return (Criteria) this;
		}

		public Criteria andFinvestorNotLike(String value) {
			addCriterion("FInvestor not like", value, "finvestor");
			return (Criteria) this;
		}

		public Criteria andFinvestorIn(List<String> values) {
			addCriterion("FInvestor in", values, "finvestor");
			return (Criteria) this;
		}

		public Criteria andFinvestorNotIn(List<String> values) {
			addCriterion("FInvestor not in", values, "finvestor");
			return (Criteria) this;
		}

		public Criteria andFinvestorBetween(String value1, String value2) {
			addCriterion("FInvestor between", value1, value2, "finvestor");
			return (Criteria) this;
		}

		public Criteria andFinvestorNotBetween(String value1, String value2) {
			addCriterion("FInvestor not between", value1, value2, "finvestor");
			return (Criteria) this;
		}

		public Criteria andFbuilderIsNull() {
			addCriterion("FBuilder is null");
			return (Criteria) this;
		}

		public Criteria andFbuilderIsNotNull() {
			addCriterion("FBuilder is not null");
			return (Criteria) this;
		}

		public Criteria andFbuilderEqualTo(String value) {
			addCriterion("FBuilder =", value, "fbuilder");
			return (Criteria) this;
		}

		public Criteria andFbuilderNotEqualTo(String value) {
			addCriterion("FBuilder <>", value, "fbuilder");
			return (Criteria) this;
		}

		public Criteria andFbuilderGreaterThan(String value) {
			addCriterion("FBuilder >", value, "fbuilder");
			return (Criteria) this;
		}

		public Criteria andFbuilderGreaterThanOrEqualTo(String value) {
			addCriterion("FBuilder >=", value, "fbuilder");
			return (Criteria) this;
		}

		public Criteria andFbuilderLessThan(String value) {
			addCriterion("FBuilder <", value, "fbuilder");
			return (Criteria) this;
		}

		public Criteria andFbuilderLessThanOrEqualTo(String value) {
			addCriterion("FBuilder <=", value, "fbuilder");
			return (Criteria) this;
		}

		public Criteria andFbuilderLike(String value) {
			addCriterion("FBuilder like", value, "fbuilder");
			return (Criteria) this;
		}

		public Criteria andFbuilderNotLike(String value) {
			addCriterion("FBuilder not like", value, "fbuilder");
			return (Criteria) this;
		}

		public Criteria andFbuilderIn(List<String> values) {
			addCriterion("FBuilder in", values, "fbuilder");
			return (Criteria) this;
		}

		public Criteria andFbuilderNotIn(List<String> values) {
			addCriterion("FBuilder not in", values, "fbuilder");
			return (Criteria) this;
		}

		public Criteria andFbuilderBetween(String value1, String value2) {
			addCriterion("FBuilder between", value1, value2, "fbuilder");
			return (Criteria) this;
		}

		public Criteria andFbuilderNotBetween(String value1, String value2) {
			addCriterion("FBuilder not between", value1, value2, "fbuilder");
			return (Criteria) this;
		}

		public Criteria andFlandscapeIsNull() {
			addCriterion("FLandscape is null");
			return (Criteria) this;
		}

		public Criteria andFlandscapeIsNotNull() {
			addCriterion("FLandscape is not null");
			return (Criteria) this;
		}

		public Criteria andFlandscapeEqualTo(String value) {
			addCriterion("FLandscape =", value, "flandscape");
			return (Criteria) this;
		}

		public Criteria andFlandscapeNotEqualTo(String value) {
			addCriterion("FLandscape <>", value, "flandscape");
			return (Criteria) this;
		}

		public Criteria andFlandscapeGreaterThan(String value) {
			addCriterion("FLandscape >", value, "flandscape");
			return (Criteria) this;
		}

		public Criteria andFlandscapeGreaterThanOrEqualTo(String value) {
			addCriterion("FLandscape >=", value, "flandscape");
			return (Criteria) this;
		}

		public Criteria andFlandscapeLessThan(String value) {
			addCriterion("FLandscape <", value, "flandscape");
			return (Criteria) this;
		}

		public Criteria andFlandscapeLessThanOrEqualTo(String value) {
			addCriterion("FLandscape <=", value, "flandscape");
			return (Criteria) this;
		}

		public Criteria andFlandscapeLike(String value) {
			addCriterion("FLandscape like", value, "flandscape");
			return (Criteria) this;
		}

		public Criteria andFlandscapeNotLike(String value) {
			addCriterion("FLandscape not like", value, "flandscape");
			return (Criteria) this;
		}

		public Criteria andFlandscapeIn(List<String> values) {
			addCriterion("FLandscape in", values, "flandscape");
			return (Criteria) this;
		}

		public Criteria andFlandscapeNotIn(List<String> values) {
			addCriterion("FLandscape not in", values, "flandscape");
			return (Criteria) this;
		}

		public Criteria andFlandscapeBetween(String value1, String value2) {
			addCriterion("FLandscape between", value1, value2, "flandscape");
			return (Criteria) this;
		}

		public Criteria andFlandscapeNotBetween(String value1, String value2) {
			addCriterion("FLandscape not between", value1, value2, "flandscape");
			return (Criteria) this;
		}

		public Criteria andFstatusIsNull() {
			addCriterion("Fstatus is null");
			return (Criteria) this;
		}

		public Criteria andFstatusIsNotNull() {
			addCriterion("Fstatus is not null");
			return (Criteria) this;
		}

		public Criteria andFstatusEqualTo(Byte value) {
			addCriterion("Fstatus =", value, "fstatus");
			return (Criteria) this;
		}

		public Criteria andFstatusNotEqualTo(Byte value) {
			addCriterion("Fstatus <>", value, "fstatus");
			return (Criteria) this;
		}

		public Criteria andFstatusGreaterThan(Byte value) {
			addCriterion("Fstatus >", value, "fstatus");
			return (Criteria) this;
		}

		public Criteria andFstatusGreaterThanOrEqualTo(Byte value) {
			addCriterion("Fstatus >=", value, "fstatus");
			return (Criteria) this;
		}

		public Criteria andFstatusLessThan(Byte value) {
			addCriterion("Fstatus <", value, "fstatus");
			return (Criteria) this;
		}

		public Criteria andFstatusLessThanOrEqualTo(Byte value) {
			addCriterion("Fstatus <=", value, "fstatus");
			return (Criteria) this;
		}

		public Criteria andFstatusIn(List<Byte> values) {
			addCriterion("Fstatus in", values, "fstatus");
			return (Criteria) this;
		}

		public Criteria andFstatusNotIn(List<Byte> values) {
			addCriterion("Fstatus not in", values, "fstatus");
			return (Criteria) this;
		}

		public Criteria andFstatusBetween(Byte value1, Byte value2) {
			addCriterion("Fstatus between", value1, value2, "fstatus");
			return (Criteria) this;
		}

		public Criteria andFstatusNotBetween(Byte value1, Byte value2) {
			addCriterion("Fstatus not between", value1, value2, "fstatus");
			return (Criteria) this;
		}

		public Criteria andFaliasIsNull() {
			addCriterion("FAlias is null");
			return (Criteria) this;
		}

		public Criteria andFaliasIsNotNull() {
			addCriterion("FAlias is not null");
			return (Criteria) this;
		}

		public Criteria andFaliasEqualTo(String value) {
			addCriterion("FAlias =", value, "falias");
			return (Criteria) this;
		}

		public Criteria andFaliasNotEqualTo(String value) {
			addCriterion("FAlias <>", value, "falias");
			return (Criteria) this;
		}

		public Criteria andFaliasGreaterThan(String value) {
			addCriterion("FAlias >", value, "falias");
			return (Criteria) this;
		}

		public Criteria andFaliasGreaterThanOrEqualTo(String value) {
			addCriterion("FAlias >=", value, "falias");
			return (Criteria) this;
		}

		public Criteria andFaliasLessThan(String value) {
			addCriterion("FAlias <", value, "falias");
			return (Criteria) this;
		}

		public Criteria andFaliasLessThanOrEqualTo(String value) {
			addCriterion("FAlias <=", value, "falias");
			return (Criteria) this;
		}

		public Criteria andFaliasLike(String value) {
			addCriterion("FAlias like", value, "falias");
			return (Criteria) this;
		}

		public Criteria andFaliasNotLike(String value) {
			addCriterion("FAlias not like", value, "falias");
			return (Criteria) this;
		}

		public Criteria andFaliasIn(List<String> values) {
			addCriterion("FAlias in", values, "falias");
			return (Criteria) this;
		}

		public Criteria andFaliasNotIn(List<String> values) {
			addCriterion("FAlias not in", values, "falias");
			return (Criteria) this;
		}

		public Criteria andFaliasBetween(String value1, String value2) {
			addCriterion("FAlias between", value1, value2, "falias");
			return (Criteria) this;
		}

		public Criteria andFaliasNotBetween(String value1, String value2) {
			addCriterion("FAlias not between", value1, value2, "falias");
			return (Criteria) this;
		}

		public Criteria andFhouseidIsNull() {
			addCriterion("FHouseId is null");
			return (Criteria) this;
		}

		public Criteria andFhouseidIsNotNull() {
			addCriterion("FHouseId is not null");
			return (Criteria) this;
		}

		public Criteria andFhouseidEqualTo(Integer value) {
			addCriterion("FHouseId =", value, "fhouseid");
			return (Criteria) this;
		}

		public Criteria andFhouseidNotEqualTo(Integer value) {
			addCriterion("FHouseId <>", value, "fhouseid");
			return (Criteria) this;
		}

		public Criteria andFhouseidGreaterThan(Integer value) {
			addCriterion("FHouseId >", value, "fhouseid");
			return (Criteria) this;
		}

		public Criteria andFhouseidGreaterThanOrEqualTo(Integer value) {
			addCriterion("FHouseId >=", value, "fhouseid");
			return (Criteria) this;
		}

		public Criteria andFhouseidLessThan(Integer value) {
			addCriterion("FHouseId <", value, "fhouseid");
			return (Criteria) this;
		}

		public Criteria andFhouseidLessThanOrEqualTo(Integer value) {
			addCriterion("FHouseId <=", value, "fhouseid");
			return (Criteria) this;
		}

		public Criteria andFhouseidIn(List<Integer> values) {
			addCriterion("FHouseId in", values, "fhouseid");
			return (Criteria) this;
		}

		public Criteria andFhouseidNotIn(List<Integer> values) {
			addCriterion("FHouseId not in", values, "fhouseid");
			return (Criteria) this;
		}

		public Criteria andFhouseidBetween(Integer value1, Integer value2) {
			addCriterion("FHouseId between", value1, value2, "fhouseid");
			return (Criteria) this;
		}

		public Criteria andFhouseidNotBetween(Integer value1, Integer value2) {
			addCriterion("FHouseId not between", value1, value2, "fhouseid");
			return (Criteria) this;
		}

		public Criteria andFunitidsIsNull() {
			addCriterion("FUnitIds is null");
			return (Criteria) this;
		}

		public Criteria andFunitidsIsNotNull() {
			addCriterion("FUnitIds is not null");
			return (Criteria) this;
		}

		public Criteria andFunitidsEqualTo(String value) {
			addCriterion("FUnitIds =", value, "funitids");
			return (Criteria) this;
		}

		public Criteria andFunitidsNotEqualTo(String value) {
			addCriterion("FUnitIds <>", value, "funitids");
			return (Criteria) this;
		}

		public Criteria andFunitidsGreaterThan(String value) {
			addCriterion("FUnitIds >", value, "funitids");
			return (Criteria) this;
		}

		public Criteria andFunitidsGreaterThanOrEqualTo(String value) {
			addCriterion("FUnitIds >=", value, "funitids");
			return (Criteria) this;
		}

		public Criteria andFunitidsLessThan(String value) {
			addCriterion("FUnitIds <", value, "funitids");
			return (Criteria) this;
		}

		public Criteria andFunitidsLessThanOrEqualTo(String value) {
			addCriterion("FUnitIds <=", value, "funitids");
			return (Criteria) this;
		}

		public Criteria andFunitidsLike(String value) {
			addCriterion("FUnitIds like", value, "funitids");
			return (Criteria) this;
		}

		public Criteria andFunitidsNotLike(String value) {
			addCriterion("FUnitIds not like", value, "funitids");
			return (Criteria) this;
		}

		public Criteria andFunitidsIn(List<String> values) {
			addCriterion("FUnitIds in", values, "funitids");
			return (Criteria) this;
		}

		public Criteria andFunitidsNotIn(List<String> values) {
			addCriterion("FUnitIds not in", values, "funitids");
			return (Criteria) this;
		}

		public Criteria andFunitidsBetween(String value1, String value2) {
			addCriterion("FUnitIds between", value1, value2, "funitids");
			return (Criteria) this;
		}

		public Criteria andFunitidsNotBetween(String value1, String value2) {
			addCriterion("FUnitIds not between", value1, value2, "funitids");
			return (Criteria) this;
		}

		public Criteria andFpropertyfeeIsNull() {
			addCriterion("FPropertyfee is null");
			return (Criteria) this;
		}

		public Criteria andFpropertyfeeIsNotNull() {
			addCriterion("FPropertyfee is not null");
			return (Criteria) this;
		}

		public Criteria andFpropertyfeeEqualTo(Double value) {
			addCriterion("FPropertyfee =", value, "fpropertyfee");
			return (Criteria) this;
		}

		public Criteria andFpropertyfeeNotEqualTo(Double value) {
			addCriterion("FPropertyfee <>", value, "fpropertyfee");
			return (Criteria) this;
		}

		public Criteria andFpropertyfeeGreaterThan(Double value) {
			addCriterion("FPropertyfee >", value, "fpropertyfee");
			return (Criteria) this;
		}

		public Criteria andFpropertyfeeGreaterThanOrEqualTo(Double value) {
			addCriterion("FPropertyfee >=", value, "fpropertyfee");
			return (Criteria) this;
		}

		public Criteria andFpropertyfeeLessThan(Double value) {
			addCriterion("FPropertyfee <", value, "fpropertyfee");
			return (Criteria) this;
		}

		public Criteria andFpropertyfeeLessThanOrEqualTo(Double value) {
			addCriterion("FPropertyfee <=", value, "fpropertyfee");
			return (Criteria) this;
		}

		public Criteria andFpropertyfeeIn(List<Double> values) {
			addCriterion("FPropertyfee in", values, "fpropertyfee");
			return (Criteria) this;
		}

		public Criteria andFpropertyfeeNotIn(List<Double> values) {
			addCriterion("FPropertyfee not in", values, "fpropertyfee");
			return (Criteria) this;
		}

		public Criteria andFpropertyfeeBetween(Double value1, Double value2) {
			addCriterion("FPropertyfee between", value1, value2, "fpropertyfee");
			return (Criteria) this;
		}

		public Criteria andFpropertyfeeNotBetween(Double value1, Double value2) {
			addCriterion("FPropertyfee not between", value1, value2, "fpropertyfee");
			return (Criteria) this;
		}

		public Criteria andFhousetypeidsIsNull() {
			addCriterion("FHouseTypeIds is null");
			return (Criteria) this;
		}

		public Criteria andFhousetypeidsIsNotNull() {
			addCriterion("FHouseTypeIds is not null");
			return (Criteria) this;
		}

		public Criteria andFhousetypeidsEqualTo(String value) {
			addCriterion("FHouseTypeIds =", value, "fhousetypeids");
			return (Criteria) this;
		}

		public Criteria andFhousetypeidsNotEqualTo(String value) {
			addCriterion("FHouseTypeIds <>", value, "fhousetypeids");
			return (Criteria) this;
		}

		public Criteria andFhousetypeidsGreaterThan(String value) {
			addCriterion("FHouseTypeIds >", value, "fhousetypeids");
			return (Criteria) this;
		}

		public Criteria andFhousetypeidsGreaterThanOrEqualTo(String value) {
			addCriterion("FHouseTypeIds >=", value, "fhousetypeids");
			return (Criteria) this;
		}

		public Criteria andFhousetypeidsLessThan(String value) {
			addCriterion("FHouseTypeIds <", value, "fhousetypeids");
			return (Criteria) this;
		}

		public Criteria andFhousetypeidsLessThanOrEqualTo(String value) {
			addCriterion("FHouseTypeIds <=", value, "fhousetypeids");
			return (Criteria) this;
		}

		public Criteria andFhousetypeidsLike(String value) {
			addCriterion("FHouseTypeIds like", value, "fhousetypeids");
			return (Criteria) this;
		}

		public Criteria andFhousetypeidsNotLike(String value) {
			addCriterion("FHouseTypeIds not like", value, "fhousetypeids");
			return (Criteria) this;
		}

		public Criteria andFhousetypeidsIn(List<String> values) {
			addCriterion("FHouseTypeIds in", values, "fhousetypeids");
			return (Criteria) this;
		}

		public Criteria andFhousetypeidsNotIn(List<String> values) {
			addCriterion("FHouseTypeIds not in", values, "fhousetypeids");
			return (Criteria) this;
		}

		public Criteria andFhousetypeidsBetween(String value1, String value2) {
			addCriterion("FHouseTypeIds between", value1, value2, "fhousetypeids");
			return (Criteria) this;
		}

		public Criteria andFhousetypeidsNotBetween(String value1, String value2) {
			addCriterion("FHouseTypeIds not between", value1, value2, "fhousetypeids");
			return (Criteria) this;
		}

		public Criteria andBuildWebidIsNull() {
			addCriterion("BUILD_WEBID is null");
			return (Criteria) this;
		}

		public Criteria andBuildWebidIsNotNull() {
			addCriterion("BUILD_WEBID is not null");
			return (Criteria) this;
		}

		public Criteria andBuildWebidEqualTo(Integer value) {
			addCriterion("BUILD_WEBID =", value, "buildWebid");
			return (Criteria) this;
		}

		public Criteria andBuildWebidNotEqualTo(Integer value) {
			addCriterion("BUILD_WEBID <>", value, "buildWebid");
			return (Criteria) this;
		}

		public Criteria andBuildWebidGreaterThan(Integer value) {
			addCriterion("BUILD_WEBID >", value, "buildWebid");
			return (Criteria) this;
		}

		public Criteria andBuildWebidGreaterThanOrEqualTo(Integer value) {
			addCriterion("BUILD_WEBID >=", value, "buildWebid");
			return (Criteria) this;
		}

		public Criteria andBuildWebidLessThan(Integer value) {
			addCriterion("BUILD_WEBID <", value, "buildWebid");
			return (Criteria) this;
		}

		public Criteria andBuildWebidLessThanOrEqualTo(Integer value) {
			addCriterion("BUILD_WEBID <=", value, "buildWebid");
			return (Criteria) this;
		}

		public Criteria andBuildWebidIn(List<Integer> values) {
			addCriterion("BUILD_WEBID in", values, "buildWebid");
			return (Criteria) this;
		}

		public Criteria andBuildWebidNotIn(List<Integer> values) {
			addCriterion("BUILD_WEBID not in", values, "buildWebid");
			return (Criteria) this;
		}

		public Criteria andBuildWebidBetween(Integer value1, Integer value2) {
			addCriterion("BUILD_WEBID between", value1, value2, "buildWebid");
			return (Criteria) this;
		}

		public Criteria andBuildWebidNotBetween(Integer value1, Integer value2) {
			addCriterion("BUILD_WEBID not between", value1, value2, "buildWebid");
			return (Criteria) this;
		}

		public Criteria andKjlBuildNameIsNull() {
			addCriterion("KJL_BUILD_NAME is null");
			return (Criteria) this;
		}

		public Criteria andKjlBuildNameIsNotNull() {
			addCriterion("KJL_BUILD_NAME is not null");
			return (Criteria) this;
		}

		public Criteria andKjlBuildNameEqualTo(String value) {
			addCriterion("KJL_BUILD_NAME =", value, "kjlBuildName");
			return (Criteria) this;
		}

		public Criteria andKjlBuildNameNotEqualTo(String value) {
			addCriterion("KJL_BUILD_NAME <>", value, "kjlBuildName");
			return (Criteria) this;
		}

		public Criteria andKjlBuildNameGreaterThan(String value) {
			addCriterion("KJL_BUILD_NAME >", value, "kjlBuildName");
			return (Criteria) this;
		}

		public Criteria andKjlBuildNameGreaterThanOrEqualTo(String value) {
			addCriterion("KJL_BUILD_NAME >=", value, "kjlBuildName");
			return (Criteria) this;
		}

		public Criteria andKjlBuildNameLessThan(String value) {
			addCriterion("KJL_BUILD_NAME <", value, "kjlBuildName");
			return (Criteria) this;
		}

		public Criteria andKjlBuildNameLessThanOrEqualTo(String value) {
			addCriterion("KJL_BUILD_NAME <=", value, "kjlBuildName");
			return (Criteria) this;
		}

		public Criteria andKjlBuildNameLike(String value) {
			addCriterion("KJL_BUILD_NAME like", value, "kjlBuildName");
			return (Criteria) this;
		}

		public Criteria andKjlBuildNameNotLike(String value) {
			addCriterion("KJL_BUILD_NAME not like", value, "kjlBuildName");
			return (Criteria) this;
		}

		public Criteria andKjlBuildNameIn(List<String> values) {
			addCriterion("KJL_BUILD_NAME in", values, "kjlBuildName");
			return (Criteria) this;
		}

		public Criteria andKjlBuildNameNotIn(List<String> values) {
			addCriterion("KJL_BUILD_NAME not in", values, "kjlBuildName");
			return (Criteria) this;
		}

		public Criteria andKjlBuildNameBetween(String value1, String value2) {
			addCriterion("KJL_BUILD_NAME between", value1, value2, "kjlBuildName");
			return (Criteria) this;
		}

		public Criteria andKjlBuildNameNotBetween(String value1, String value2) {
			addCriterion("KJL_BUILD_NAME not between", value1, value2, "kjlBuildName");
			return (Criteria) this;
		}

		public Criteria andPositionCheckIsNull() {
			addCriterion("position_check is null");
			return (Criteria) this;
		}

		public Criteria andPositionCheckIsNotNull() {
			addCriterion("position_check is not null");
			return (Criteria) this;
		}

		public Criteria andPositionCheckEqualTo(Integer value) {
			addCriterion("position_check =", value, "positionCheck");
			return (Criteria) this;
		}

		public Criteria andPositionCheckNotEqualTo(Integer value) {
			addCriterion("position_check <>", value, "positionCheck");
			return (Criteria) this;
		}

		public Criteria andPositionCheckGreaterThan(Integer value) {
			addCriterion("position_check >", value, "positionCheck");
			return (Criteria) this;
		}

		public Criteria andPositionCheckGreaterThanOrEqualTo(Integer value) {
			addCriterion("position_check >=", value, "positionCheck");
			return (Criteria) this;
		}

		public Criteria andPositionCheckLessThan(Integer value) {
			addCriterion("position_check <", value, "positionCheck");
			return (Criteria) this;
		}

		public Criteria andPositionCheckLessThanOrEqualTo(Integer value) {
			addCriterion("position_check <=", value, "positionCheck");
			return (Criteria) this;
		}

		public Criteria andPositionCheckIn(List<Integer> values) {
			addCriterion("position_check in", values, "positionCheck");
			return (Criteria) this;
		}

		public Criteria andPositionCheckNotIn(List<Integer> values) {
			addCriterion("position_check not in", values, "positionCheck");
			return (Criteria) this;
		}

		public Criteria andPositionCheckBetween(Integer value1, Integer value2) {
			addCriterion("position_check between", value1, value2, "positionCheck");
			return (Criteria) this;
		}

		public Criteria andPositionCheckNotBetween(Integer value1, Integer value2) {
			addCriterion("position_check not between", value1, value2, "positionCheck");
			return (Criteria) this;
		}

		public Criteria andSaleNumsIsNull() {
			addCriterion("SALE_NUMS is null");
			return (Criteria) this;
		}

		public Criteria andSaleNumsIsNotNull() {
			addCriterion("SALE_NUMS is not null");
			return (Criteria) this;
		}

		public Criteria andSaleNumsEqualTo(Integer value) {
			addCriterion("SALE_NUMS =", value, "saleNums");
			return (Criteria) this;
		}

		public Criteria andSaleNumsNotEqualTo(Integer value) {
			addCriterion("SALE_NUMS <>", value, "saleNums");
			return (Criteria) this;
		}

		public Criteria andSaleNumsGreaterThan(Integer value) {
			addCriterion("SALE_NUMS >", value, "saleNums");
			return (Criteria) this;
		}

		public Criteria andSaleNumsGreaterThanOrEqualTo(Integer value) {
			addCriterion("SALE_NUMS >=", value, "saleNums");
			return (Criteria) this;
		}

		public Criteria andSaleNumsLessThan(Integer value) {
			addCriterion("SALE_NUMS <", value, "saleNums");
			return (Criteria) this;
		}

		public Criteria andSaleNumsLessThanOrEqualTo(Integer value) {
			addCriterion("SALE_NUMS <=", value, "saleNums");
			return (Criteria) this;
		}

		public Criteria andSaleNumsIn(List<Integer> values) {
			addCriterion("SALE_NUMS in", values, "saleNums");
			return (Criteria) this;
		}

		public Criteria andSaleNumsNotIn(List<Integer> values) {
			addCriterion("SALE_NUMS not in", values, "saleNums");
			return (Criteria) this;
		}

		public Criteria andSaleNumsBetween(Integer value1, Integer value2) {
			addCriterion("SALE_NUMS between", value1, value2, "saleNums");
			return (Criteria) this;
		}

		public Criteria andSaleNumsNotBetween(Integer value1, Integer value2) {
			addCriterion("SALE_NUMS not between", value1, value2, "saleNums");
			return (Criteria) this;
		}

		public Criteria andLeaseNumsIsNull() {
			addCriterion("LEASE_NUMS is null");
			return (Criteria) this;
		}

		public Criteria andLeaseNumsIsNotNull() {
			addCriterion("LEASE_NUMS is not null");
			return (Criteria) this;
		}

		public Criteria andLeaseNumsEqualTo(Integer value) {
			addCriterion("LEASE_NUMS =", value, "leaseNums");
			return (Criteria) this;
		}

		public Criteria andLeaseNumsNotEqualTo(Integer value) {
			addCriterion("LEASE_NUMS <>", value, "leaseNums");
			return (Criteria) this;
		}

		public Criteria andLeaseNumsGreaterThan(Integer value) {
			addCriterion("LEASE_NUMS >", value, "leaseNums");
			return (Criteria) this;
		}

		public Criteria andLeaseNumsGreaterThanOrEqualTo(Integer value) {
			addCriterion("LEASE_NUMS >=", value, "leaseNums");
			return (Criteria) this;
		}

		public Criteria andLeaseNumsLessThan(Integer value) {
			addCriterion("LEASE_NUMS <", value, "leaseNums");
			return (Criteria) this;
		}

		public Criteria andLeaseNumsLessThanOrEqualTo(Integer value) {
			addCriterion("LEASE_NUMS <=", value, "leaseNums");
			return (Criteria) this;
		}

		public Criteria andLeaseNumsIn(List<Integer> values) {
			addCriterion("LEASE_NUMS in", values, "leaseNums");
			return (Criteria) this;
		}

		public Criteria andLeaseNumsNotIn(List<Integer> values) {
			addCriterion("LEASE_NUMS not in", values, "leaseNums");
			return (Criteria) this;
		}

		public Criteria andLeaseNumsBetween(Integer value1, Integer value2) {
			addCriterion("LEASE_NUMS between", value1, value2, "leaseNums");
			return (Criteria) this;
		}

		public Criteria andLeaseNumsNotBetween(Integer value1, Integer value2) {
			addCriterion("LEASE_NUMS not between", value1, value2, "leaseNums");
			return (Criteria) this;
		}

		public Criteria andSosoSaleNumsIsNull() {
			addCriterion("SOSO_SALE_NUMS is null");
			return (Criteria) this;
		}

		public Criteria andSosoSaleNumsIsNotNull() {
			addCriterion("SOSO_SALE_NUMS is not null");
			return (Criteria) this;
		}

		public Criteria andSosoSaleNumsEqualTo(Integer value) {
			addCriterion("SOSO_SALE_NUMS =", value, "sosoSaleNums");
			return (Criteria) this;
		}

		public Criteria andSosoSaleNumsNotEqualTo(Integer value) {
			addCriterion("SOSO_SALE_NUMS <>", value, "sosoSaleNums");
			return (Criteria) this;
		}

		public Criteria andSosoSaleNumsGreaterThan(Integer value) {
			addCriterion("SOSO_SALE_NUMS >", value, "sosoSaleNums");
			return (Criteria) this;
		}

		public Criteria andSosoSaleNumsGreaterThanOrEqualTo(Integer value) {
			addCriterion("SOSO_SALE_NUMS >=", value, "sosoSaleNums");
			return (Criteria) this;
		}

		public Criteria andSosoSaleNumsLessThan(Integer value) {
			addCriterion("SOSO_SALE_NUMS <", value, "sosoSaleNums");
			return (Criteria) this;
		}

		public Criteria andSosoSaleNumsLessThanOrEqualTo(Integer value) {
			addCriterion("SOSO_SALE_NUMS <=", value, "sosoSaleNums");
			return (Criteria) this;
		}

		public Criteria andSosoSaleNumsIn(List<Integer> values) {
			addCriterion("SOSO_SALE_NUMS in", values, "sosoSaleNums");
			return (Criteria) this;
		}

		public Criteria andSosoSaleNumsNotIn(List<Integer> values) {
			addCriterion("SOSO_SALE_NUMS not in", values, "sosoSaleNums");
			return (Criteria) this;
		}

		public Criteria andSosoSaleNumsBetween(Integer value1, Integer value2) {
			addCriterion("SOSO_SALE_NUMS between", value1, value2, "sosoSaleNums");
			return (Criteria) this;
		}

		public Criteria andSosoSaleNumsNotBetween(Integer value1, Integer value2) {
			addCriterion("SOSO_SALE_NUMS not between", value1, value2, "sosoSaleNums");
			return (Criteria) this;
		}

		public Criteria andSosoLeaseNumsIsNull() {
			addCriterion("SOSO_LEASE_NUMS is null");
			return (Criteria) this;
		}

		public Criteria andSosoLeaseNumsIsNotNull() {
			addCriterion("SOSO_LEASE_NUMS is not null");
			return (Criteria) this;
		}

		public Criteria andSosoLeaseNumsEqualTo(Integer value) {
			addCriterion("SOSO_LEASE_NUMS =", value, "sosoLeaseNums");
			return (Criteria) this;
		}

		public Criteria andSosoLeaseNumsNotEqualTo(Integer value) {
			addCriterion("SOSO_LEASE_NUMS <>", value, "sosoLeaseNums");
			return (Criteria) this;
		}

		public Criteria andSosoLeaseNumsGreaterThan(Integer value) {
			addCriterion("SOSO_LEASE_NUMS >", value, "sosoLeaseNums");
			return (Criteria) this;
		}

		public Criteria andSosoLeaseNumsGreaterThanOrEqualTo(Integer value) {
			addCriterion("SOSO_LEASE_NUMS >=", value, "sosoLeaseNums");
			return (Criteria) this;
		}

		public Criteria andSosoLeaseNumsLessThan(Integer value) {
			addCriterion("SOSO_LEASE_NUMS <", value, "sosoLeaseNums");
			return (Criteria) this;
		}

		public Criteria andSosoLeaseNumsLessThanOrEqualTo(Integer value) {
			addCriterion("SOSO_LEASE_NUMS <=", value, "sosoLeaseNums");
			return (Criteria) this;
		}

		public Criteria andSosoLeaseNumsIn(List<Integer> values) {
			addCriterion("SOSO_LEASE_NUMS in", values, "sosoLeaseNums");
			return (Criteria) this;
		}

		public Criteria andSosoLeaseNumsNotIn(List<Integer> values) {
			addCriterion("SOSO_LEASE_NUMS not in", values, "sosoLeaseNums");
			return (Criteria) this;
		}

		public Criteria andSosoLeaseNumsBetween(Integer value1, Integer value2) {
			addCriterion("SOSO_LEASE_NUMS between", value1, value2, "sosoLeaseNums");
			return (Criteria) this;
		}

		public Criteria andSosoLeaseNumsNotBetween(Integer value1, Integer value2) {
			addCriterion("SOSO_LEASE_NUMS not between", value1, value2, "sosoLeaseNums");
			return (Criteria) this;
		}

		public Criteria andAgencySaleNumsIsNull() {
			addCriterion("AGENCY_SALE_NUMS is null");
			return (Criteria) this;
		}

		public Criteria andAgencySaleNumsIsNotNull() {
			addCriterion("AGENCY_SALE_NUMS is not null");
			return (Criteria) this;
		}

		public Criteria andAgencySaleNumsEqualTo(Integer value) {
			addCriterion("AGENCY_SALE_NUMS =", value, "agencySaleNums");
			return (Criteria) this;
		}

		public Criteria andAgencySaleNumsNotEqualTo(Integer value) {
			addCriterion("AGENCY_SALE_NUMS <>", value, "agencySaleNums");
			return (Criteria) this;
		}

		public Criteria andAgencySaleNumsGreaterThan(Integer value) {
			addCriterion("AGENCY_SALE_NUMS >", value, "agencySaleNums");
			return (Criteria) this;
		}

		public Criteria andAgencySaleNumsGreaterThanOrEqualTo(Integer value) {
			addCriterion("AGENCY_SALE_NUMS >=", value, "agencySaleNums");
			return (Criteria) this;
		}

		public Criteria andAgencySaleNumsLessThan(Integer value) {
			addCriterion("AGENCY_SALE_NUMS <", value, "agencySaleNums");
			return (Criteria) this;
		}

		public Criteria andAgencySaleNumsLessThanOrEqualTo(Integer value) {
			addCriterion("AGENCY_SALE_NUMS <=", value, "agencySaleNums");
			return (Criteria) this;
		}

		public Criteria andAgencySaleNumsIn(List<Integer> values) {
			addCriterion("AGENCY_SALE_NUMS in", values, "agencySaleNums");
			return (Criteria) this;
		}

		public Criteria andAgencySaleNumsNotIn(List<Integer> values) {
			addCriterion("AGENCY_SALE_NUMS not in", values, "agencySaleNums");
			return (Criteria) this;
		}

		public Criteria andAgencySaleNumsBetween(Integer value1, Integer value2) {
			addCriterion("AGENCY_SALE_NUMS between", value1, value2, "agencySaleNums");
			return (Criteria) this;
		}

		public Criteria andAgencySaleNumsNotBetween(Integer value1, Integer value2) {
			addCriterion("AGENCY_SALE_NUMS not between", value1, value2, "agencySaleNums");
			return (Criteria) this;
		}

		public Criteria andAgencyLeaseNumsIsNull() {
			addCriterion("AGENCY_LEASE_NUMS is null");
			return (Criteria) this;
		}

		public Criteria andAgencyLeaseNumsIsNotNull() {
			addCriterion("AGENCY_LEASE_NUMS is not null");
			return (Criteria) this;
		}

		public Criteria andAgencyLeaseNumsEqualTo(Integer value) {
			addCriterion("AGENCY_LEASE_NUMS =", value, "agencyLeaseNums");
			return (Criteria) this;
		}

		public Criteria andAgencyLeaseNumsNotEqualTo(Integer value) {
			addCriterion("AGENCY_LEASE_NUMS <>", value, "agencyLeaseNums");
			return (Criteria) this;
		}

		public Criteria andAgencyLeaseNumsGreaterThan(Integer value) {
			addCriterion("AGENCY_LEASE_NUMS >", value, "agencyLeaseNums");
			return (Criteria) this;
		}

		public Criteria andAgencyLeaseNumsGreaterThanOrEqualTo(Integer value) {
			addCriterion("AGENCY_LEASE_NUMS >=", value, "agencyLeaseNums");
			return (Criteria) this;
		}

		public Criteria andAgencyLeaseNumsLessThan(Integer value) {
			addCriterion("AGENCY_LEASE_NUMS <", value, "agencyLeaseNums");
			return (Criteria) this;
		}

		public Criteria andAgencyLeaseNumsLessThanOrEqualTo(Integer value) {
			addCriterion("AGENCY_LEASE_NUMS <=", value, "agencyLeaseNums");
			return (Criteria) this;
		}

		public Criteria andAgencyLeaseNumsIn(List<Integer> values) {
			addCriterion("AGENCY_LEASE_NUMS in", values, "agencyLeaseNums");
			return (Criteria) this;
		}

		public Criteria andAgencyLeaseNumsNotIn(List<Integer> values) {
			addCriterion("AGENCY_LEASE_NUMS not in", values, "agencyLeaseNums");
			return (Criteria) this;
		}

		public Criteria andAgencyLeaseNumsBetween(Integer value1, Integer value2) {
			addCriterion("AGENCY_LEASE_NUMS between", value1, value2, "agencyLeaseNums");
			return (Criteria) this;
		}

		public Criteria andAgencyLeaseNumsNotBetween(Integer value1, Integer value2) {
			addCriterion("AGENCY_LEASE_NUMS not between", value1, value2, "agencyLeaseNums");
			return (Criteria) this;
		}

		public Criteria andHezuNumIsNull() {
			addCriterion("HEZU_NUM is null");
			return (Criteria) this;
		}

		public Criteria andHezuNumIsNotNull() {
			addCriterion("HEZU_NUM is not null");
			return (Criteria) this;
		}

		public Criteria andHezuNumEqualTo(Integer value) {
			addCriterion("HEZU_NUM =", value, "hezuNum");
			return (Criteria) this;
		}

		public Criteria andHezuNumNotEqualTo(Integer value) {
			addCriterion("HEZU_NUM <>", value, "hezuNum");
			return (Criteria) this;
		}

		public Criteria andHezuNumGreaterThan(Integer value) {
			addCriterion("HEZU_NUM >", value, "hezuNum");
			return (Criteria) this;
		}

		public Criteria andHezuNumGreaterThanOrEqualTo(Integer value) {
			addCriterion("HEZU_NUM >=", value, "hezuNum");
			return (Criteria) this;
		}

		public Criteria andHezuNumLessThan(Integer value) {
			addCriterion("HEZU_NUM <", value, "hezuNum");
			return (Criteria) this;
		}

		public Criteria andHezuNumLessThanOrEqualTo(Integer value) {
			addCriterion("HEZU_NUM <=", value, "hezuNum");
			return (Criteria) this;
		}

		public Criteria andHezuNumIn(List<Integer> values) {
			addCriterion("HEZU_NUM in", values, "hezuNum");
			return (Criteria) this;
		}

		public Criteria andHezuNumNotIn(List<Integer> values) {
			addCriterion("HEZU_NUM not in", values, "hezuNum");
			return (Criteria) this;
		}

		public Criteria andHezuNumBetween(Integer value1, Integer value2) {
			addCriterion("HEZU_NUM between", value1, value2, "hezuNum");
			return (Criteria) this;
		}

		public Criteria andHezuNumNotBetween(Integer value1, Integer value2) {
			addCriterion("HEZU_NUM not between", value1, value2, "hezuNum");
			return (Criteria) this;
		}

		public Criteria andErpUuSaleNumIsNull() {
			addCriterion("ERP_UU_SALE_NUM is null");
			return (Criteria) this;
		}

		public Criteria andErpUuSaleNumIsNotNull() {
			addCriterion("ERP_UU_SALE_NUM is not null");
			return (Criteria) this;
		}

		public Criteria andErpUuSaleNumEqualTo(Integer value) {
			addCriterion("ERP_UU_SALE_NUM =", value, "erpUuSaleNum");
			return (Criteria) this;
		}

		public Criteria andErpUuSaleNumNotEqualTo(Integer value) {
			addCriterion("ERP_UU_SALE_NUM <>", value, "erpUuSaleNum");
			return (Criteria) this;
		}

		public Criteria andErpUuSaleNumGreaterThan(Integer value) {
			addCriterion("ERP_UU_SALE_NUM >", value, "erpUuSaleNum");
			return (Criteria) this;
		}

		public Criteria andErpUuSaleNumGreaterThanOrEqualTo(Integer value) {
			addCriterion("ERP_UU_SALE_NUM >=", value, "erpUuSaleNum");
			return (Criteria) this;
		}

		public Criteria andErpUuSaleNumLessThan(Integer value) {
			addCriterion("ERP_UU_SALE_NUM <", value, "erpUuSaleNum");
			return (Criteria) this;
		}

		public Criteria andErpUuSaleNumLessThanOrEqualTo(Integer value) {
			addCriterion("ERP_UU_SALE_NUM <=", value, "erpUuSaleNum");
			return (Criteria) this;
		}

		public Criteria andErpUuSaleNumIn(List<Integer> values) {
			addCriterion("ERP_UU_SALE_NUM in", values, "erpUuSaleNum");
			return (Criteria) this;
		}

		public Criteria andErpUuSaleNumNotIn(List<Integer> values) {
			addCriterion("ERP_UU_SALE_NUM not in", values, "erpUuSaleNum");
			return (Criteria) this;
		}

		public Criteria andErpUuSaleNumBetween(Integer value1, Integer value2) {
			addCriterion("ERP_UU_SALE_NUM between", value1, value2, "erpUuSaleNum");
			return (Criteria) this;
		}

		public Criteria andErpUuSaleNumNotBetween(Integer value1, Integer value2) {
			addCriterion("ERP_UU_SALE_NUM not between", value1, value2, "erpUuSaleNum");
			return (Criteria) this;
		}

		public Criteria andErpUuLeaseNumIsNull() {
			addCriterion("ERP_UU_LEASE_NUM is null");
			return (Criteria) this;
		}

		public Criteria andErpUuLeaseNumIsNotNull() {
			addCriterion("ERP_UU_LEASE_NUM is not null");
			return (Criteria) this;
		}

		public Criteria andErpUuLeaseNumEqualTo(Integer value) {
			addCriterion("ERP_UU_LEASE_NUM =", value, "erpUuLeaseNum");
			return (Criteria) this;
		}

		public Criteria andErpUuLeaseNumNotEqualTo(Integer value) {
			addCriterion("ERP_UU_LEASE_NUM <>", value, "erpUuLeaseNum");
			return (Criteria) this;
		}

		public Criteria andErpUuLeaseNumGreaterThan(Integer value) {
			addCriterion("ERP_UU_LEASE_NUM >", value, "erpUuLeaseNum");
			return (Criteria) this;
		}

		public Criteria andErpUuLeaseNumGreaterThanOrEqualTo(Integer value) {
			addCriterion("ERP_UU_LEASE_NUM >=", value, "erpUuLeaseNum");
			return (Criteria) this;
		}

		public Criteria andErpUuLeaseNumLessThan(Integer value) {
			addCriterion("ERP_UU_LEASE_NUM <", value, "erpUuLeaseNum");
			return (Criteria) this;
		}

		public Criteria andErpUuLeaseNumLessThanOrEqualTo(Integer value) {
			addCriterion("ERP_UU_LEASE_NUM <=", value, "erpUuLeaseNum");
			return (Criteria) this;
		}

		public Criteria andErpUuLeaseNumIn(List<Integer> values) {
			addCriterion("ERP_UU_LEASE_NUM in", values, "erpUuLeaseNum");
			return (Criteria) this;
		}

		public Criteria andErpUuLeaseNumNotIn(List<Integer> values) {
			addCriterion("ERP_UU_LEASE_NUM not in", values, "erpUuLeaseNum");
			return (Criteria) this;
		}

		public Criteria andErpUuLeaseNumBetween(Integer value1, Integer value2) {
			addCriterion("ERP_UU_LEASE_NUM between", value1, value2, "erpUuLeaseNum");
			return (Criteria) this;
		}

		public Criteria andErpUuLeaseNumNotBetween(Integer value1, Integer value2) {
			addCriterion("ERP_UU_LEASE_NUM not between", value1, value2, "erpUuLeaseNum");
			return (Criteria) this;
		}

		public Criteria andErpWdSaleNumIsNull() {
			addCriterion("ERP_WD_SALE_NUM is null");
			return (Criteria) this;
		}

		public Criteria andErpWdSaleNumIsNotNull() {
			addCriterion("ERP_WD_SALE_NUM is not null");
			return (Criteria) this;
		}

		public Criteria andErpWdSaleNumEqualTo(Integer value) {
			addCriterion("ERP_WD_SALE_NUM =", value, "erpWdSaleNum");
			return (Criteria) this;
		}

		public Criteria andErpWdSaleNumNotEqualTo(Integer value) {
			addCriterion("ERP_WD_SALE_NUM <>", value, "erpWdSaleNum");
			return (Criteria) this;
		}

		public Criteria andErpWdSaleNumGreaterThan(Integer value) {
			addCriterion("ERP_WD_SALE_NUM >", value, "erpWdSaleNum");
			return (Criteria) this;
		}

		public Criteria andErpWdSaleNumGreaterThanOrEqualTo(Integer value) {
			addCriterion("ERP_WD_SALE_NUM >=", value, "erpWdSaleNum");
			return (Criteria) this;
		}

		public Criteria andErpWdSaleNumLessThan(Integer value) {
			addCriterion("ERP_WD_SALE_NUM <", value, "erpWdSaleNum");
			return (Criteria) this;
		}

		public Criteria andErpWdSaleNumLessThanOrEqualTo(Integer value) {
			addCriterion("ERP_WD_SALE_NUM <=", value, "erpWdSaleNum");
			return (Criteria) this;
		}

		public Criteria andErpWdSaleNumIn(List<Integer> values) {
			addCriterion("ERP_WD_SALE_NUM in", values, "erpWdSaleNum");
			return (Criteria) this;
		}

		public Criteria andErpWdSaleNumNotIn(List<Integer> values) {
			addCriterion("ERP_WD_SALE_NUM not in", values, "erpWdSaleNum");
			return (Criteria) this;
		}

		public Criteria andErpWdSaleNumBetween(Integer value1, Integer value2) {
			addCriterion("ERP_WD_SALE_NUM between", value1, value2, "erpWdSaleNum");
			return (Criteria) this;
		}

		public Criteria andErpWdSaleNumNotBetween(Integer value1, Integer value2) {
			addCriterion("ERP_WD_SALE_NUM not between", value1, value2, "erpWdSaleNum");
			return (Criteria) this;
		}

		public Criteria andErpWdLeaseNumIsNull() {
			addCriterion("ERP_WD_LEASE_NUM is null");
			return (Criteria) this;
		}

		public Criteria andErpWdLeaseNumIsNotNull() {
			addCriterion("ERP_WD_LEASE_NUM is not null");
			return (Criteria) this;
		}

		public Criteria andErpWdLeaseNumEqualTo(Integer value) {
			addCriterion("ERP_WD_LEASE_NUM =", value, "erpWdLeaseNum");
			return (Criteria) this;
		}

		public Criteria andErpWdLeaseNumNotEqualTo(Integer value) {
			addCriterion("ERP_WD_LEASE_NUM <>", value, "erpWdLeaseNum");
			return (Criteria) this;
		}

		public Criteria andErpWdLeaseNumGreaterThan(Integer value) {
			addCriterion("ERP_WD_LEASE_NUM >", value, "erpWdLeaseNum");
			return (Criteria) this;
		}

		public Criteria andErpWdLeaseNumGreaterThanOrEqualTo(Integer value) {
			addCriterion("ERP_WD_LEASE_NUM >=", value, "erpWdLeaseNum");
			return (Criteria) this;
		}

		public Criteria andErpWdLeaseNumLessThan(Integer value) {
			addCriterion("ERP_WD_LEASE_NUM <", value, "erpWdLeaseNum");
			return (Criteria) this;
		}

		public Criteria andErpWdLeaseNumLessThanOrEqualTo(Integer value) {
			addCriterion("ERP_WD_LEASE_NUM <=", value, "erpWdLeaseNum");
			return (Criteria) this;
		}

		public Criteria andErpWdLeaseNumIn(List<Integer> values) {
			addCriterion("ERP_WD_LEASE_NUM in", values, "erpWdLeaseNum");
			return (Criteria) this;
		}

		public Criteria andErpWdLeaseNumNotIn(List<Integer> values) {
			addCriterion("ERP_WD_LEASE_NUM not in", values, "erpWdLeaseNum");
			return (Criteria) this;
		}

		public Criteria andErpWdLeaseNumBetween(Integer value1, Integer value2) {
			addCriterion("ERP_WD_LEASE_NUM between", value1, value2, "erpWdLeaseNum");
			return (Criteria) this;
		}

		public Criteria andErpWdLeaseNumNotBetween(Integer value1, Integer value2) {
			addCriterion("ERP_WD_LEASE_NUM not between", value1, value2, "erpWdLeaseNum");
			return (Criteria) this;
		}

		public Criteria andErpSaleNumsMonthIsNull() {
			addCriterion("ERP_SALE_NUMS_MONTH is null");
			return (Criteria) this;
		}

		public Criteria andErpSaleNumsMonthIsNotNull() {
			addCriterion("ERP_SALE_NUMS_MONTH is not null");
			return (Criteria) this;
		}

		public Criteria andErpSaleNumsMonthEqualTo(Integer value) {
			addCriterion("ERP_SALE_NUMS_MONTH =", value, "erpSaleNumsMonth");
			return (Criteria) this;
		}

		public Criteria andErpSaleNumsMonthNotEqualTo(Integer value) {
			addCriterion("ERP_SALE_NUMS_MONTH <>", value, "erpSaleNumsMonth");
			return (Criteria) this;
		}

		public Criteria andErpSaleNumsMonthGreaterThan(Integer value) {
			addCriterion("ERP_SALE_NUMS_MONTH >", value, "erpSaleNumsMonth");
			return (Criteria) this;
		}

		public Criteria andErpSaleNumsMonthGreaterThanOrEqualTo(Integer value) {
			addCriterion("ERP_SALE_NUMS_MONTH >=", value, "erpSaleNumsMonth");
			return (Criteria) this;
		}

		public Criteria andErpSaleNumsMonthLessThan(Integer value) {
			addCriterion("ERP_SALE_NUMS_MONTH <", value, "erpSaleNumsMonth");
			return (Criteria) this;
		}

		public Criteria andErpSaleNumsMonthLessThanOrEqualTo(Integer value) {
			addCriterion("ERP_SALE_NUMS_MONTH <=", value, "erpSaleNumsMonth");
			return (Criteria) this;
		}

		public Criteria andErpSaleNumsMonthIn(List<Integer> values) {
			addCriterion("ERP_SALE_NUMS_MONTH in", values, "erpSaleNumsMonth");
			return (Criteria) this;
		}

		public Criteria andErpSaleNumsMonthNotIn(List<Integer> values) {
			addCriterion("ERP_SALE_NUMS_MONTH not in", values, "erpSaleNumsMonth");
			return (Criteria) this;
		}

		public Criteria andErpSaleNumsMonthBetween(Integer value1, Integer value2) {
			addCriterion("ERP_SALE_NUMS_MONTH between", value1, value2, "erpSaleNumsMonth");
			return (Criteria) this;
		}

		public Criteria andErpSaleNumsMonthNotBetween(Integer value1, Integer value2) {
			addCriterion("ERP_SALE_NUMS_MONTH not between", value1, value2, "erpSaleNumsMonth");
			return (Criteria) this;
		}

		public Criteria andErpLeaseNumsMonthIsNull() {
			addCriterion("ERP_LEASE_NUMS_MONTH is null");
			return (Criteria) this;
		}

		public Criteria andErpLeaseNumsMonthIsNotNull() {
			addCriterion("ERP_LEASE_NUMS_MONTH is not null");
			return (Criteria) this;
		}

		public Criteria andErpLeaseNumsMonthEqualTo(Integer value) {
			addCriterion("ERP_LEASE_NUMS_MONTH =", value, "erpLeaseNumsMonth");
			return (Criteria) this;
		}

		public Criteria andErpLeaseNumsMonthNotEqualTo(Integer value) {
			addCriterion("ERP_LEASE_NUMS_MONTH <>", value, "erpLeaseNumsMonth");
			return (Criteria) this;
		}

		public Criteria andErpLeaseNumsMonthGreaterThan(Integer value) {
			addCriterion("ERP_LEASE_NUMS_MONTH >", value, "erpLeaseNumsMonth");
			return (Criteria) this;
		}

		public Criteria andErpLeaseNumsMonthGreaterThanOrEqualTo(Integer value) {
			addCriterion("ERP_LEASE_NUMS_MONTH >=", value, "erpLeaseNumsMonth");
			return (Criteria) this;
		}

		public Criteria andErpLeaseNumsMonthLessThan(Integer value) {
			addCriterion("ERP_LEASE_NUMS_MONTH <", value, "erpLeaseNumsMonth");
			return (Criteria) this;
		}

		public Criteria andErpLeaseNumsMonthLessThanOrEqualTo(Integer value) {
			addCriterion("ERP_LEASE_NUMS_MONTH <=", value, "erpLeaseNumsMonth");
			return (Criteria) this;
		}

		public Criteria andErpLeaseNumsMonthIn(List<Integer> values) {
			addCriterion("ERP_LEASE_NUMS_MONTH in", values, "erpLeaseNumsMonth");
			return (Criteria) this;
		}

		public Criteria andErpLeaseNumsMonthNotIn(List<Integer> values) {
			addCriterion("ERP_LEASE_NUMS_MONTH not in", values, "erpLeaseNumsMonth");
			return (Criteria) this;
		}

		public Criteria andErpLeaseNumsMonthBetween(Integer value1, Integer value2) {
			addCriterion("ERP_LEASE_NUMS_MONTH between", value1, value2, "erpLeaseNumsMonth");
			return (Criteria) this;
		}

		public Criteria andErpLeaseNumsMonthNotBetween(Integer value1, Integer value2) {
			addCriterion("ERP_LEASE_NUMS_MONTH not between", value1, value2, "erpLeaseNumsMonth");
			return (Criteria) this;
		}

		public Criteria andYfBuildIdIsNull() {
			addCriterion("YF_BUILD_ID is null");
			return (Criteria) this;
		}

		public Criteria andYfBuildIdIsNotNull() {
			addCriterion("YF_BUILD_ID is not null");
			return (Criteria) this;
		}

		public Criteria andYfBuildIdEqualTo(Integer value) {
			addCriterion("YF_BUILD_ID =", value, "yfBuildId");
			return (Criteria) this;
		}

		public Criteria andYfBuildIdNotEqualTo(Integer value) {
			addCriterion("YF_BUILD_ID <>", value, "yfBuildId");
			return (Criteria) this;
		}

		public Criteria andYfBuildIdGreaterThan(Integer value) {
			addCriterion("YF_BUILD_ID >", value, "yfBuildId");
			return (Criteria) this;
		}

		public Criteria andYfBuildIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("YF_BUILD_ID >=", value, "yfBuildId");
			return (Criteria) this;
		}

		public Criteria andYfBuildIdLessThan(Integer value) {
			addCriterion("YF_BUILD_ID <", value, "yfBuildId");
			return (Criteria) this;
		}

		public Criteria andYfBuildIdLessThanOrEqualTo(Integer value) {
			addCriterion("YF_BUILD_ID <=", value, "yfBuildId");
			return (Criteria) this;
		}

		public Criteria andYfBuildIdIn(List<Integer> values) {
			addCriterion("YF_BUILD_ID in", values, "yfBuildId");
			return (Criteria) this;
		}

		public Criteria andYfBuildIdNotIn(List<Integer> values) {
			addCriterion("YF_BUILD_ID not in", values, "yfBuildId");
			return (Criteria) this;
		}

		public Criteria andYfBuildIdBetween(Integer value1, Integer value2) {
			addCriterion("YF_BUILD_ID between", value1, value2, "yfBuildId");
			return (Criteria) this;
		}

		public Criteria andYfBuildIdNotBetween(Integer value1, Integer value2) {
			addCriterion("YF_BUILD_ID not between", value1, value2, "yfBuildId");
			return (Criteria) this;
		}

		public Criteria andIsSubwayIsNull() {
			addCriterion("IS_SUBWAY is null");
			return (Criteria) this;
		}

		public Criteria andIsSubwayIsNotNull() {
			addCriterion("IS_SUBWAY is not null");
			return (Criteria) this;
		}

		public Criteria andIsSubwayEqualTo(Byte value) {
			addCriterion("IS_SUBWAY =", value, "isSubway");
			return (Criteria) this;
		}

		public Criteria andIsSubwayNotEqualTo(Byte value) {
			addCriterion("IS_SUBWAY <>", value, "isSubway");
			return (Criteria) this;
		}

		public Criteria andIsSubwayGreaterThan(Byte value) {
			addCriterion("IS_SUBWAY >", value, "isSubway");
			return (Criteria) this;
		}

		public Criteria andIsSubwayGreaterThanOrEqualTo(Byte value) {
			addCriterion("IS_SUBWAY >=", value, "isSubway");
			return (Criteria) this;
		}

		public Criteria andIsSubwayLessThan(Byte value) {
			addCriterion("IS_SUBWAY <", value, "isSubway");
			return (Criteria) this;
		}

		public Criteria andIsSubwayLessThanOrEqualTo(Byte value) {
			addCriterion("IS_SUBWAY <=", value, "isSubway");
			return (Criteria) this;
		}

		public Criteria andIsSubwayIn(List<Byte> values) {
			addCriterion("IS_SUBWAY in", values, "isSubway");
			return (Criteria) this;
		}

		public Criteria andIsSubwayNotIn(List<Byte> values) {
			addCriterion("IS_SUBWAY not in", values, "isSubway");
			return (Criteria) this;
		}

		public Criteria andIsSubwayBetween(Byte value1, Byte value2) {
			addCriterion("IS_SUBWAY between", value1, value2, "isSubway");
			return (Criteria) this;
		}

		public Criteria andIsSubwayNotBetween(Byte value1, Byte value2) {
			addCriterion("IS_SUBWAY not between", value1, value2, "isSubway");
			return (Criteria) this;
		}

		public Criteria andIsSchoolIsNull() {
			addCriterion("IS_SCHOOL is null");
			return (Criteria) this;
		}

		public Criteria andIsSchoolIsNotNull() {
			addCriterion("IS_SCHOOL is not null");
			return (Criteria) this;
		}

		public Criteria andIsSchoolEqualTo(Byte value) {
			addCriterion("IS_SCHOOL =", value, "isSchool");
			return (Criteria) this;
		}

		public Criteria andIsSchoolNotEqualTo(Byte value) {
			addCriterion("IS_SCHOOL <>", value, "isSchool");
			return (Criteria) this;
		}

		public Criteria andIsSchoolGreaterThan(Byte value) {
			addCriterion("IS_SCHOOL >", value, "isSchool");
			return (Criteria) this;
		}

		public Criteria andIsSchoolGreaterThanOrEqualTo(Byte value) {
			addCriterion("IS_SCHOOL >=", value, "isSchool");
			return (Criteria) this;
		}

		public Criteria andIsSchoolLessThan(Byte value) {
			addCriterion("IS_SCHOOL <", value, "isSchool");
			return (Criteria) this;
		}

		public Criteria andIsSchoolLessThanOrEqualTo(Byte value) {
			addCriterion("IS_SCHOOL <=", value, "isSchool");
			return (Criteria) this;
		}

		public Criteria andIsSchoolIn(List<Byte> values) {
			addCriterion("IS_SCHOOL in", values, "isSchool");
			return (Criteria) this;
		}

		public Criteria andIsSchoolNotIn(List<Byte> values) {
			addCriterion("IS_SCHOOL not in", values, "isSchool");
			return (Criteria) this;
		}

		public Criteria andIsSchoolBetween(Byte value1, Byte value2) {
			addCriterion("IS_SCHOOL between", value1, value2, "isSchool");
			return (Criteria) this;
		}

		public Criteria andIsSchoolNotBetween(Byte value1, Byte value2) {
			addCriterion("IS_SCHOOL not between", value1, value2, "isSchool");
			return (Criteria) this;
		}

		public Criteria andRatioLastMonthIsNull() {
			addCriterion("RATIO_LAST_MONTH is null");
			return (Criteria) this;
		}

		public Criteria andRatioLastMonthIsNotNull() {
			addCriterion("RATIO_LAST_MONTH is not null");
			return (Criteria) this;
		}

		public Criteria andRatioLastMonthEqualTo(Double value) {
			addCriterion("RATIO_LAST_MONTH =", value, "ratioLastMonth");
			return (Criteria) this;
		}

		public Criteria andRatioLastMonthNotEqualTo(Double value) {
			addCriterion("RATIO_LAST_MONTH <>", value, "ratioLastMonth");
			return (Criteria) this;
		}

		public Criteria andRatioLastMonthGreaterThan(Double value) {
			addCriterion("RATIO_LAST_MONTH >", value, "ratioLastMonth");
			return (Criteria) this;
		}

		public Criteria andRatioLastMonthGreaterThanOrEqualTo(Double value) {
			addCriterion("RATIO_LAST_MONTH >=", value, "ratioLastMonth");
			return (Criteria) this;
		}

		public Criteria andRatioLastMonthLessThan(Double value) {
			addCriterion("RATIO_LAST_MONTH <", value, "ratioLastMonth");
			return (Criteria) this;
		}

		public Criteria andRatioLastMonthLessThanOrEqualTo(Double value) {
			addCriterion("RATIO_LAST_MONTH <=", value, "ratioLastMonth");
			return (Criteria) this;
		}

		public Criteria andRatioLastMonthIn(List<Double> values) {
			addCriterion("RATIO_LAST_MONTH in", values, "ratioLastMonth");
			return (Criteria) this;
		}

		public Criteria andRatioLastMonthNotIn(List<Double> values) {
			addCriterion("RATIO_LAST_MONTH not in", values, "ratioLastMonth");
			return (Criteria) this;
		}

		public Criteria andRatioLastMonthBetween(Double value1, Double value2) {
			addCriterion("RATIO_LAST_MONTH between", value1, value2, "ratioLastMonth");
			return (Criteria) this;
		}

		public Criteria andRatioLastMonthNotBetween(Double value1, Double value2) {
			addCriterion("RATIO_LAST_MONTH not between", value1, value2, "ratioLastMonth");
			return (Criteria) this;
		}

		public Criteria andRatioLastYearIsNull() {
			addCriterion("RATIO_LAST_YEAR is null");
			return (Criteria) this;
		}

		public Criteria andRatioLastYearIsNotNull() {
			addCriterion("RATIO_LAST_YEAR is not null");
			return (Criteria) this;
		}

		public Criteria andRatioLastYearEqualTo(Double value) {
			addCriterion("RATIO_LAST_YEAR =", value, "ratioLastYear");
			return (Criteria) this;
		}

		public Criteria andRatioLastYearNotEqualTo(Double value) {
			addCriterion("RATIO_LAST_YEAR <>", value, "ratioLastYear");
			return (Criteria) this;
		}

		public Criteria andRatioLastYearGreaterThan(Double value) {
			addCriterion("RATIO_LAST_YEAR >", value, "ratioLastYear");
			return (Criteria) this;
		}

		public Criteria andRatioLastYearGreaterThanOrEqualTo(Double value) {
			addCriterion("RATIO_LAST_YEAR >=", value, "ratioLastYear");
			return (Criteria) this;
		}

		public Criteria andRatioLastYearLessThan(Double value) {
			addCriterion("RATIO_LAST_YEAR <", value, "ratioLastYear");
			return (Criteria) this;
		}

		public Criteria andRatioLastYearLessThanOrEqualTo(Double value) {
			addCriterion("RATIO_LAST_YEAR <=", value, "ratioLastYear");
			return (Criteria) this;
		}

		public Criteria andRatioLastYearIn(List<Double> values) {
			addCriterion("RATIO_LAST_YEAR in", values, "ratioLastYear");
			return (Criteria) this;
		}

		public Criteria andRatioLastYearNotIn(List<Double> values) {
			addCriterion("RATIO_LAST_YEAR not in", values, "ratioLastYear");
			return (Criteria) this;
		}

		public Criteria andRatioLastYearBetween(Double value1, Double value2) {
			addCriterion("RATIO_LAST_YEAR between", value1, value2, "ratioLastYear");
			return (Criteria) this;
		}

		public Criteria andRatioLastYearNotBetween(Double value1, Double value2) {
			addCriterion("RATIO_LAST_YEAR not between", value1, value2, "ratioLastYear");
			return (Criteria) this;
		}

		public Criteria andSchoolsIsNull() {
			addCriterion("SCHOOLS is null");
			return (Criteria) this;
		}

		public Criteria andSchoolsIsNotNull() {
			addCriterion("SCHOOLS is not null");
			return (Criteria) this;
		}

		public Criteria andSchoolsEqualTo(String value) {
			addCriterion("SCHOOLS =", value, "schools");
			return (Criteria) this;
		}

		public Criteria andSchoolsNotEqualTo(String value) {
			addCriterion("SCHOOLS <>", value, "schools");
			return (Criteria) this;
		}

		public Criteria andSchoolsGreaterThan(String value) {
			addCriterion("SCHOOLS >", value, "schools");
			return (Criteria) this;
		}

		public Criteria andSchoolsGreaterThanOrEqualTo(String value) {
			addCriterion("SCHOOLS >=", value, "schools");
			return (Criteria) this;
		}

		public Criteria andSchoolsLessThan(String value) {
			addCriterion("SCHOOLS <", value, "schools");
			return (Criteria) this;
		}

		public Criteria andSchoolsLessThanOrEqualTo(String value) {
			addCriterion("SCHOOLS <=", value, "schools");
			return (Criteria) this;
		}

		public Criteria andSchoolsLike(String value) {
			addCriterion("SCHOOLS like", value, "schools");
			return (Criteria) this;
		}

		public Criteria andSchoolsNotLike(String value) {
			addCriterion("SCHOOLS not like", value, "schools");
			return (Criteria) this;
		}

		public Criteria andSchoolsIn(List<String> values) {
			addCriterion("SCHOOLS in", values, "schools");
			return (Criteria) this;
		}

		public Criteria andSchoolsNotIn(List<String> values) {
			addCriterion("SCHOOLS not in", values, "schools");
			return (Criteria) this;
		}

		public Criteria andSchoolsBetween(String value1, String value2) {
			addCriterion("SCHOOLS between", value1, value2, "schools");
			return (Criteria) this;
		}

		public Criteria andSchoolsNotBetween(String value1, String value2) {
			addCriterion("SCHOOLS not between", value1, value2, "schools");
			return (Criteria) this;
		}

		public Criteria andInquiryNumIsNull() {
			addCriterion("INQUIRY_NUM is null");
			return (Criteria) this;
		}

		public Criteria andInquiryNumIsNotNull() {
			addCriterion("INQUIRY_NUM is not null");
			return (Criteria) this;
		}

		public Criteria andInquiryNumEqualTo(Integer value) {
			addCriterion("INQUIRY_NUM =", value, "inquiryNum");
			return (Criteria) this;
		}

		public Criteria andInquiryNumNotEqualTo(Integer value) {
			addCriterion("INQUIRY_NUM <>", value, "inquiryNum");
			return (Criteria) this;
		}

		public Criteria andInquiryNumGreaterThan(Integer value) {
			addCriterion("INQUIRY_NUM >", value, "inquiryNum");
			return (Criteria) this;
		}

		public Criteria andInquiryNumGreaterThanOrEqualTo(Integer value) {
			addCriterion("INQUIRY_NUM >=", value, "inquiryNum");
			return (Criteria) this;
		}

		public Criteria andInquiryNumLessThan(Integer value) {
			addCriterion("INQUIRY_NUM <", value, "inquiryNum");
			return (Criteria) this;
		}

		public Criteria andInquiryNumLessThanOrEqualTo(Integer value) {
			addCriterion("INQUIRY_NUM <=", value, "inquiryNum");
			return (Criteria) this;
		}

		public Criteria andInquiryNumIn(List<Integer> values) {
			addCriterion("INQUIRY_NUM in", values, "inquiryNum");
			return (Criteria) this;
		}

		public Criteria andInquiryNumNotIn(List<Integer> values) {
			addCriterion("INQUIRY_NUM not in", values, "inquiryNum");
			return (Criteria) this;
		}

		public Criteria andInquiryNumBetween(Integer value1, Integer value2) {
			addCriterion("INQUIRY_NUM between", value1, value2, "inquiryNum");
			return (Criteria) this;
		}

		public Criteria andInquiryNumNotBetween(Integer value1, Integer value2) {
			addCriterion("INQUIRY_NUM not between", value1, value2, "inquiryNum");
			return (Criteria) this;
		}

		public Criteria andBiddingEndTimeIsNull() {
			addCriterion("BIDDING_END_TIME is null");
			return (Criteria) this;
		}

		public Criteria andBiddingEndTimeIsNotNull() {
			addCriterion("BIDDING_END_TIME is not null");
			return (Criteria) this;
		}

		public Criteria andBiddingEndTimeEqualTo(Date value) {
			addCriterion("BIDDING_END_TIME =", value, "biddingEndTime");
			return (Criteria) this;
		}

		public Criteria andBiddingEndTimeNotEqualTo(Date value) {
			addCriterion("BIDDING_END_TIME <>", value, "biddingEndTime");
			return (Criteria) this;
		}

		public Criteria andBiddingEndTimeGreaterThan(Date value) {
			addCriterion("BIDDING_END_TIME >", value, "biddingEndTime");
			return (Criteria) this;
		}

		public Criteria andBiddingEndTimeGreaterThanOrEqualTo(Date value) {
			addCriterion("BIDDING_END_TIME >=", value, "biddingEndTime");
			return (Criteria) this;
		}

		public Criteria andBiddingEndTimeLessThan(Date value) {
			addCriterion("BIDDING_END_TIME <", value, "biddingEndTime");
			return (Criteria) this;
		}

		public Criteria andBiddingEndTimeLessThanOrEqualTo(Date value) {
			addCriterion("BIDDING_END_TIME <=", value, "biddingEndTime");
			return (Criteria) this;
		}

		public Criteria andBiddingEndTimeIn(List<Date> values) {
			addCriterion("BIDDING_END_TIME in", values, "biddingEndTime");
			return (Criteria) this;
		}

		public Criteria andBiddingEndTimeNotIn(List<Date> values) {
			addCriterion("BIDDING_END_TIME not in", values, "biddingEndTime");
			return (Criteria) this;
		}

		public Criteria andBiddingEndTimeBetween(Date value1, Date value2) {
			addCriterion("BIDDING_END_TIME between", value1, value2, "biddingEndTime");
			return (Criteria) this;
		}

		public Criteria andBiddingEndTimeNotBetween(Date value1, Date value2) {
			addCriterion("BIDDING_END_TIME not between", value1, value2, "biddingEndTime");
			return (Criteria) this;
		}

		public Criteria andBiddingArchiveIdIsNull() {
			addCriterion("BIDDING_ARCHIVE_ID is null");
			return (Criteria) this;
		}

		public Criteria andBiddingArchiveIdIsNotNull() {
			addCriterion("BIDDING_ARCHIVE_ID is not null");
			return (Criteria) this;
		}

		public Criteria andBiddingArchiveIdEqualTo(Integer value) {
			addCriterion("BIDDING_ARCHIVE_ID =", value, "biddingArchiveId");
			return (Criteria) this;
		}

		public Criteria andBiddingArchiveIdNotEqualTo(Integer value) {
			addCriterion("BIDDING_ARCHIVE_ID <>", value, "biddingArchiveId");
			return (Criteria) this;
		}

		public Criteria andBiddingArchiveIdGreaterThan(Integer value) {
			addCriterion("BIDDING_ARCHIVE_ID >", value, "biddingArchiveId");
			return (Criteria) this;
		}

		public Criteria andBiddingArchiveIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("BIDDING_ARCHIVE_ID >=", value, "biddingArchiveId");
			return (Criteria) this;
		}

		public Criteria andBiddingArchiveIdLessThan(Integer value) {
			addCriterion("BIDDING_ARCHIVE_ID <", value, "biddingArchiveId");
			return (Criteria) this;
		}

		public Criteria andBiddingArchiveIdLessThanOrEqualTo(Integer value) {
			addCriterion("BIDDING_ARCHIVE_ID <=", value, "biddingArchiveId");
			return (Criteria) this;
		}

		public Criteria andBiddingArchiveIdIn(List<Integer> values) {
			addCriterion("BIDDING_ARCHIVE_ID in", values, "biddingArchiveId");
			return (Criteria) this;
		}

		public Criteria andBiddingArchiveIdNotIn(List<Integer> values) {
			addCriterion("BIDDING_ARCHIVE_ID not in", values, "biddingArchiveId");
			return (Criteria) this;
		}

		public Criteria andBiddingArchiveIdBetween(Integer value1, Integer value2) {
			addCriterion("BIDDING_ARCHIVE_ID between", value1, value2, "biddingArchiveId");
			return (Criteria) this;
		}

		public Criteria andBiddingArchiveIdNotBetween(Integer value1, Integer value2) {
			addCriterion("BIDDING_ARCHIVE_ID not between", value1, value2, "biddingArchiveId");
			return (Criteria) this;
		}

		public Criteria andErpSaleTrueNumsIsNull() {
			addCriterion("ERP_SALE_TRUE_NUMS is null");
			return (Criteria) this;
		}

		public Criteria andErpSaleTrueNumsIsNotNull() {
			addCriterion("ERP_SALE_TRUE_NUMS is not null");
			return (Criteria) this;
		}

		public Criteria andErpSaleTrueNumsEqualTo(Integer value) {
			addCriterion("ERP_SALE_TRUE_NUMS =", value, "erpSaleTrueNums");
			return (Criteria) this;
		}

		public Criteria andErpSaleTrueNumsNotEqualTo(Integer value) {
			addCriterion("ERP_SALE_TRUE_NUMS <>", value, "erpSaleTrueNums");
			return (Criteria) this;
		}

		public Criteria andErpSaleTrueNumsGreaterThan(Integer value) {
			addCriterion("ERP_SALE_TRUE_NUMS >", value, "erpSaleTrueNums");
			return (Criteria) this;
		}

		public Criteria andErpSaleTrueNumsGreaterThanOrEqualTo(Integer value) {
			addCriterion("ERP_SALE_TRUE_NUMS >=", value, "erpSaleTrueNums");
			return (Criteria) this;
		}

		public Criteria andErpSaleTrueNumsLessThan(Integer value) {
			addCriterion("ERP_SALE_TRUE_NUMS <", value, "erpSaleTrueNums");
			return (Criteria) this;
		}

		public Criteria andErpSaleTrueNumsLessThanOrEqualTo(Integer value) {
			addCriterion("ERP_SALE_TRUE_NUMS <=", value, "erpSaleTrueNums");
			return (Criteria) this;
		}

		public Criteria andErpSaleTrueNumsIn(List<Integer> values) {
			addCriterion("ERP_SALE_TRUE_NUMS in", values, "erpSaleTrueNums");
			return (Criteria) this;
		}

		public Criteria andErpSaleTrueNumsNotIn(List<Integer> values) {
			addCriterion("ERP_SALE_TRUE_NUMS not in", values, "erpSaleTrueNums");
			return (Criteria) this;
		}

		public Criteria andErpSaleTrueNumsBetween(Integer value1, Integer value2) {
			addCriterion("ERP_SALE_TRUE_NUMS between", value1, value2, "erpSaleTrueNums");
			return (Criteria) this;
		}

		public Criteria andErpSaleTrueNumsNotBetween(Integer value1, Integer value2) {
			addCriterion("ERP_SALE_TRUE_NUMS not between", value1, value2, "erpSaleTrueNums");
			return (Criteria) this;
		}

		public Criteria andErpLeaseTrueNumsIsNull() {
			addCriterion("ERP_LEASE_TRUE_NUMS is null");
			return (Criteria) this;
		}

		public Criteria andErpLeaseTrueNumsIsNotNull() {
			addCriterion("ERP_LEASE_TRUE_NUMS is not null");
			return (Criteria) this;
		}

		public Criteria andErpLeaseTrueNumsEqualTo(Integer value) {
			addCriterion("ERP_LEASE_TRUE_NUMS =", value, "erpLeaseTrueNums");
			return (Criteria) this;
		}

		public Criteria andErpLeaseTrueNumsNotEqualTo(Integer value) {
			addCriterion("ERP_LEASE_TRUE_NUMS <>", value, "erpLeaseTrueNums");
			return (Criteria) this;
		}

		public Criteria andErpLeaseTrueNumsGreaterThan(Integer value) {
			addCriterion("ERP_LEASE_TRUE_NUMS >", value, "erpLeaseTrueNums");
			return (Criteria) this;
		}

		public Criteria andErpLeaseTrueNumsGreaterThanOrEqualTo(Integer value) {
			addCriterion("ERP_LEASE_TRUE_NUMS >=", value, "erpLeaseTrueNums");
			return (Criteria) this;
		}

		public Criteria andErpLeaseTrueNumsLessThan(Integer value) {
			addCriterion("ERP_LEASE_TRUE_NUMS <", value, "erpLeaseTrueNums");
			return (Criteria) this;
		}

		public Criteria andErpLeaseTrueNumsLessThanOrEqualTo(Integer value) {
			addCriterion("ERP_LEASE_TRUE_NUMS <=", value, "erpLeaseTrueNums");
			return (Criteria) this;
		}

		public Criteria andErpLeaseTrueNumsIn(List<Integer> values) {
			addCriterion("ERP_LEASE_TRUE_NUMS in", values, "erpLeaseTrueNums");
			return (Criteria) this;
		}

		public Criteria andErpLeaseTrueNumsNotIn(List<Integer> values) {
			addCriterion("ERP_LEASE_TRUE_NUMS not in", values, "erpLeaseTrueNums");
			return (Criteria) this;
		}

		public Criteria andErpLeaseTrueNumsBetween(Integer value1, Integer value2) {
			addCriterion("ERP_LEASE_TRUE_NUMS between", value1, value2, "erpLeaseTrueNums");
			return (Criteria) this;
		}

		public Criteria andErpLeaseTrueNumsNotBetween(Integer value1, Integer value2) {
			addCriterion("ERP_LEASE_TRUE_NUMS not between", value1, value2, "erpLeaseTrueNums");
			return (Criteria) this;
		}

		public Criteria andDefaultBiddArchiveIdIsNull() {
			addCriterion("DEFAULT_BIDD_ARCHIVE_ID is null");
			return (Criteria) this;
		}

		public Criteria andDefaultBiddArchiveIdIsNotNull() {
			addCriterion("DEFAULT_BIDD_ARCHIVE_ID is not null");
			return (Criteria) this;
		}

		public Criteria andDefaultBiddArchiveIdEqualTo(Integer value) {
			addCriterion("DEFAULT_BIDD_ARCHIVE_ID =", value, "defaultBiddArchiveId");
			return (Criteria) this;
		}

		public Criteria andDefaultBiddArchiveIdNotEqualTo(Integer value) {
			addCriterion("DEFAULT_BIDD_ARCHIVE_ID <>", value, "defaultBiddArchiveId");
			return (Criteria) this;
		}

		public Criteria andDefaultBiddArchiveIdGreaterThan(Integer value) {
			addCriterion("DEFAULT_BIDD_ARCHIVE_ID >", value, "defaultBiddArchiveId");
			return (Criteria) this;
		}

		public Criteria andDefaultBiddArchiveIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("DEFAULT_BIDD_ARCHIVE_ID >=", value, "defaultBiddArchiveId");
			return (Criteria) this;
		}

		public Criteria andDefaultBiddArchiveIdLessThan(Integer value) {
			addCriterion("DEFAULT_BIDD_ARCHIVE_ID <", value, "defaultBiddArchiveId");
			return (Criteria) this;
		}

		public Criteria andDefaultBiddArchiveIdLessThanOrEqualTo(Integer value) {
			addCriterion("DEFAULT_BIDD_ARCHIVE_ID <=", value, "defaultBiddArchiveId");
			return (Criteria) this;
		}

		public Criteria andDefaultBiddArchiveIdIn(List<Integer> values) {
			addCriterion("DEFAULT_BIDD_ARCHIVE_ID in", values, "defaultBiddArchiveId");
			return (Criteria) this;
		}

		public Criteria andDefaultBiddArchiveIdNotIn(List<Integer> values) {
			addCriterion("DEFAULT_BIDD_ARCHIVE_ID not in", values, "defaultBiddArchiveId");
			return (Criteria) this;
		}

		public Criteria andDefaultBiddArchiveIdBetween(Integer value1, Integer value2) {
			addCriterion("DEFAULT_BIDD_ARCHIVE_ID between", value1, value2, "defaultBiddArchiveId");
			return (Criteria) this;
		}

		public Criteria andDefaultBiddArchiveIdNotBetween(Integer value1, Integer value2) {
			addCriterion("DEFAULT_BIDD_ARCHIVE_ID not between", value1, value2, "defaultBiddArchiveId");
			return (Criteria) this;
		}

		public Criteria andAddCaseBkIsNull() {
			addCriterion("ADD_CASE_BK is null");
			return (Criteria) this;
		}

		public Criteria andAddCaseBkIsNotNull() {
			addCriterion("ADD_CASE_BK is not null");
			return (Criteria) this;
		}

		public Criteria andAddCaseBkEqualTo(String value) {
			addCriterion("ADD_CASE_BK =", value, "addCaseBk");
			return (Criteria) this;
		}

		public Criteria andAddCaseBkNotEqualTo(String value) {
			addCriterion("ADD_CASE_BK <>", value, "addCaseBk");
			return (Criteria) this;
		}

		public Criteria andAddCaseBkGreaterThan(String value) {
			addCriterion("ADD_CASE_BK >", value, "addCaseBk");
			return (Criteria) this;
		}

		public Criteria andAddCaseBkGreaterThanOrEqualTo(String value) {
			addCriterion("ADD_CASE_BK >=", value, "addCaseBk");
			return (Criteria) this;
		}

		public Criteria andAddCaseBkLessThan(String value) {
			addCriterion("ADD_CASE_BK <", value, "addCaseBk");
			return (Criteria) this;
		}

		public Criteria andAddCaseBkLessThanOrEqualTo(String value) {
			addCriterion("ADD_CASE_BK <=", value, "addCaseBk");
			return (Criteria) this;
		}

		public Criteria andAddCaseBkLike(String value) {
			addCriterion("ADD_CASE_BK like", value, "addCaseBk");
			return (Criteria) this;
		}

		public Criteria andAddCaseBkNotLike(String value) {
			addCriterion("ADD_CASE_BK not like", value, "addCaseBk");
			return (Criteria) this;
		}

		public Criteria andAddCaseBkIn(List<String> values) {
			addCriterion("ADD_CASE_BK in", values, "addCaseBk");
			return (Criteria) this;
		}

		public Criteria andAddCaseBkNotIn(List<String> values) {
			addCriterion("ADD_CASE_BK not in", values, "addCaseBk");
			return (Criteria) this;
		}

		public Criteria andAddCaseBkBetween(String value1, String value2) {
			addCriterion("ADD_CASE_BK between", value1, value2, "addCaseBk");
			return (Criteria) this;
		}

		public Criteria andAddCaseBkNotBetween(String value1, String value2) {
			addCriterion("ADD_CASE_BK not between", value1, value2, "addCaseBk");
			return (Criteria) this;
		}

		public Criteria andScanBuildAveragePriceStatusIsNull() {
			addCriterion("SCAN_BUILD_AVERAGE_PRICE_STATUS is null");
			return (Criteria) this;
		}

		public Criteria andScanBuildAveragePriceStatusIsNotNull() {
			addCriterion("SCAN_BUILD_AVERAGE_PRICE_STATUS is not null");
			return (Criteria) this;
		}

		public Criteria andScanBuildAveragePriceStatusEqualTo(Byte value) {
			addCriterion("SCAN_BUILD_AVERAGE_PRICE_STATUS =", value, "scanBuildAveragePriceStatus");
			return (Criteria) this;
		}

		public Criteria andScanBuildAveragePriceStatusNotEqualTo(Byte value) {
			addCriterion("SCAN_BUILD_AVERAGE_PRICE_STATUS <>", value, "scanBuildAveragePriceStatus");
			return (Criteria) this;
		}

		public Criteria andScanBuildAveragePriceStatusGreaterThan(Byte value) {
			addCriterion("SCAN_BUILD_AVERAGE_PRICE_STATUS >", value, "scanBuildAveragePriceStatus");
			return (Criteria) this;
		}

		public Criteria andScanBuildAveragePriceStatusGreaterThanOrEqualTo(Byte value) {
			addCriterion("SCAN_BUILD_AVERAGE_PRICE_STATUS >=", value, "scanBuildAveragePriceStatus");
			return (Criteria) this;
		}

		public Criteria andScanBuildAveragePriceStatusLessThan(Byte value) {
			addCriterion("SCAN_BUILD_AVERAGE_PRICE_STATUS <", value, "scanBuildAveragePriceStatus");
			return (Criteria) this;
		}

		public Criteria andScanBuildAveragePriceStatusLessThanOrEqualTo(Byte value) {
			addCriterion("SCAN_BUILD_AVERAGE_PRICE_STATUS <=", value, "scanBuildAveragePriceStatus");
			return (Criteria) this;
		}

		public Criteria andScanBuildAveragePriceStatusIn(List<Byte> values) {
			addCriterion("SCAN_BUILD_AVERAGE_PRICE_STATUS in", values, "scanBuildAveragePriceStatus");
			return (Criteria) this;
		}

		public Criteria andScanBuildAveragePriceStatusNotIn(List<Byte> values) {
			addCriterion("SCAN_BUILD_AVERAGE_PRICE_STATUS not in", values, "scanBuildAveragePriceStatus");
			return (Criteria) this;
		}

		public Criteria andScanBuildAveragePriceStatusBetween(Byte value1, Byte value2) {
			addCriterion("SCAN_BUILD_AVERAGE_PRICE_STATUS between", value1, value2, "scanBuildAveragePriceStatus");
			return (Criteria) this;
		}

		public Criteria andScanBuildAveragePriceStatusNotBetween(Byte value1, Byte value2) {
			addCriterion("SCAN_BUILD_AVERAGE_PRICE_STATUS not between", value1, value2, "scanBuildAveragePriceStatus");
			return (Criteria) this;
		}

		public Criteria andScanBuildAveragePriceTimeIsNull() {
			addCriterion("SCAN_BUILD_AVERAGE_PRICE_TIME is null");
			return (Criteria) this;
		}

		public Criteria andScanBuildAveragePriceTimeIsNotNull() {
			addCriterion("SCAN_BUILD_AVERAGE_PRICE_TIME is not null");
			return (Criteria) this;
		}

		public Criteria andScanBuildAveragePriceTimeEqualTo(Date value) {
			addCriterion("SCAN_BUILD_AVERAGE_PRICE_TIME =", value, "scanBuildAveragePriceTime");
			return (Criteria) this;
		}

		public Criteria andScanBuildAveragePriceTimeNotEqualTo(Date value) {
			addCriterion("SCAN_BUILD_AVERAGE_PRICE_TIME <>", value, "scanBuildAveragePriceTime");
			return (Criteria) this;
		}

		public Criteria andScanBuildAveragePriceTimeGreaterThan(Date value) {
			addCriterion("SCAN_BUILD_AVERAGE_PRICE_TIME >", value, "scanBuildAveragePriceTime");
			return (Criteria) this;
		}

		public Criteria andScanBuildAveragePriceTimeGreaterThanOrEqualTo(Date value) {
			addCriterion("SCAN_BUILD_AVERAGE_PRICE_TIME >=", value, "scanBuildAveragePriceTime");
			return (Criteria) this;
		}

		public Criteria andScanBuildAveragePriceTimeLessThan(Date value) {
			addCriterion("SCAN_BUILD_AVERAGE_PRICE_TIME <", value, "scanBuildAveragePriceTime");
			return (Criteria) this;
		}

		public Criteria andScanBuildAveragePriceTimeLessThanOrEqualTo(Date value) {
			addCriterion("SCAN_BUILD_AVERAGE_PRICE_TIME <=", value, "scanBuildAveragePriceTime");
			return (Criteria) this;
		}

		public Criteria andScanBuildAveragePriceTimeIn(List<Date> values) {
			addCriterion("SCAN_BUILD_AVERAGE_PRICE_TIME in", values, "scanBuildAveragePriceTime");
			return (Criteria) this;
		}

		public Criteria andScanBuildAveragePriceTimeNotIn(List<Date> values) {
			addCriterion("SCAN_BUILD_AVERAGE_PRICE_TIME not in", values, "scanBuildAveragePriceTime");
			return (Criteria) this;
		}

		public Criteria andScanBuildAveragePriceTimeBetween(Date value1, Date value2) {
			addCriterion("SCAN_BUILD_AVERAGE_PRICE_TIME between", value1, value2, "scanBuildAveragePriceTime");
			return (Criteria) this;
		}

		public Criteria andScanBuildAveragePriceTimeNotBetween(Date value1, Date value2) {
			addCriterion("SCAN_BUILD_AVERAGE_PRICE_TIME not between", value1, value2, "scanBuildAveragePriceTime");
			return (Criteria) this;
		}

		public Criteria andPutStorageUseridIsNull() {
			addCriterion("PUT_STORAGE_USERID is null");
			return (Criteria) this;
		}

		public Criteria andPutStorageUseridIsNotNull() {
			addCriterion("PUT_STORAGE_USERID is not null");
			return (Criteria) this;
		}

		public Criteria andPutStorageUseridEqualTo(Integer value) {
			addCriterion("PUT_STORAGE_USERID =", value, "putStorageUserid");
			return (Criteria) this;
		}

		public Criteria andPutStorageUseridNotEqualTo(Integer value) {
			addCriterion("PUT_STORAGE_USERID <>", value, "putStorageUserid");
			return (Criteria) this;
		}

		public Criteria andPutStorageUseridGreaterThan(Integer value) {
			addCriterion("PUT_STORAGE_USERID >", value, "putStorageUserid");
			return (Criteria) this;
		}

		public Criteria andPutStorageUseridGreaterThanOrEqualTo(Integer value) {
			addCriterion("PUT_STORAGE_USERID >=", value, "putStorageUserid");
			return (Criteria) this;
		}

		public Criteria andPutStorageUseridLessThan(Integer value) {
			addCriterion("PUT_STORAGE_USERID <", value, "putStorageUserid");
			return (Criteria) this;
		}

		public Criteria andPutStorageUseridLessThanOrEqualTo(Integer value) {
			addCriterion("PUT_STORAGE_USERID <=", value, "putStorageUserid");
			return (Criteria) this;
		}

		public Criteria andPutStorageUseridIn(List<Integer> values) {
			addCriterion("PUT_STORAGE_USERID in", values, "putStorageUserid");
			return (Criteria) this;
		}

		public Criteria andPutStorageUseridNotIn(List<Integer> values) {
			addCriterion("PUT_STORAGE_USERID not in", values, "putStorageUserid");
			return (Criteria) this;
		}

		public Criteria andPutStorageUseridBetween(Integer value1, Integer value2) {
			addCriterion("PUT_STORAGE_USERID between", value1, value2, "putStorageUserid");
			return (Criteria) this;
		}

		public Criteria andPutStorageUseridNotBetween(Integer value1, Integer value2) {
			addCriterion("PUT_STORAGE_USERID not between", value1, value2, "putStorageUserid");
			return (Criteria) this;
		}

		public Criteria andPutStorageTimeIsNull() {
			addCriterion("PUT_STORAGE_TIME is null");
			return (Criteria) this;
		}

		public Criteria andPutStorageTimeIsNotNull() {
			addCriterion("PUT_STORAGE_TIME is not null");
			return (Criteria) this;
		}

		public Criteria andPutStorageTimeEqualTo(Date value) {
			addCriterion("PUT_STORAGE_TIME =", value, "putStorageTime");
			return (Criteria) this;
		}

		public Criteria andPutStorageTimeNotEqualTo(Date value) {
			addCriterion("PUT_STORAGE_TIME <>", value, "putStorageTime");
			return (Criteria) this;
		}

		public Criteria andPutStorageTimeGreaterThan(Date value) {
			addCriterion("PUT_STORAGE_TIME >", value, "putStorageTime");
			return (Criteria) this;
		}

		public Criteria andPutStorageTimeGreaterThanOrEqualTo(Date value) {
			addCriterion("PUT_STORAGE_TIME >=", value, "putStorageTime");
			return (Criteria) this;
		}

		public Criteria andPutStorageTimeLessThan(Date value) {
			addCriterion("PUT_STORAGE_TIME <", value, "putStorageTime");
			return (Criteria) this;
		}

		public Criteria andPutStorageTimeLessThanOrEqualTo(Date value) {
			addCriterion("PUT_STORAGE_TIME <=", value, "putStorageTime");
			return (Criteria) this;
		}

		public Criteria andPutStorageTimeIn(List<Date> values) {
			addCriterion("PUT_STORAGE_TIME in", values, "putStorageTime");
			return (Criteria) this;
		}

		public Criteria andPutStorageTimeNotIn(List<Date> values) {
			addCriterion("PUT_STORAGE_TIME not in", values, "putStorageTime");
			return (Criteria) this;
		}

		public Criteria andPutStorageTimeBetween(Date value1, Date value2) {
			addCriterion("PUT_STORAGE_TIME between", value1, value2, "putStorageTime");
			return (Criteria) this;
		}

		public Criteria andPutStorageTimeNotBetween(Date value1, Date value2) {
			addCriterion("PUT_STORAGE_TIME not between", value1, value2, "putStorageTime");
			return (Criteria) this;
		}

		public Criteria andContentMaintainerUseridIsNull() {
			addCriterion("CONTENT_MAINTAINER_USERID is null");
			return (Criteria) this;
		}

		public Criteria andContentMaintainerUseridIsNotNull() {
			addCriterion("CONTENT_MAINTAINER_USERID is not null");
			return (Criteria) this;
		}

		public Criteria andContentMaintainerUseridEqualTo(Integer value) {
			addCriterion("CONTENT_MAINTAINER_USERID =", value, "contentMaintainerUserid");
			return (Criteria) this;
		}

		public Criteria andContentMaintainerUseridNotEqualTo(Integer value) {
			addCriterion("CONTENT_MAINTAINER_USERID <>", value, "contentMaintainerUserid");
			return (Criteria) this;
		}

		public Criteria andContentMaintainerUseridGreaterThan(Integer value) {
			addCriterion("CONTENT_MAINTAINER_USERID >", value, "contentMaintainerUserid");
			return (Criteria) this;
		}

		public Criteria andContentMaintainerUseridGreaterThanOrEqualTo(Integer value) {
			addCriterion("CONTENT_MAINTAINER_USERID >=", value, "contentMaintainerUserid");
			return (Criteria) this;
		}

		public Criteria andContentMaintainerUseridLessThan(Integer value) {
			addCriterion("CONTENT_MAINTAINER_USERID <", value, "contentMaintainerUserid");
			return (Criteria) this;
		}

		public Criteria andContentMaintainerUseridLessThanOrEqualTo(Integer value) {
			addCriterion("CONTENT_MAINTAINER_USERID <=", value, "contentMaintainerUserid");
			return (Criteria) this;
		}

		public Criteria andContentMaintainerUseridIn(List<Integer> values) {
			addCriterion("CONTENT_MAINTAINER_USERID in", values, "contentMaintainerUserid");
			return (Criteria) this;
		}

		public Criteria andContentMaintainerUseridNotIn(List<Integer> values) {
			addCriterion("CONTENT_MAINTAINER_USERID not in", values, "contentMaintainerUserid");
			return (Criteria) this;
		}

		public Criteria andContentMaintainerUseridBetween(Integer value1, Integer value2) {
			addCriterion("CONTENT_MAINTAINER_USERID between", value1, value2, "contentMaintainerUserid");
			return (Criteria) this;
		}

		public Criteria andContentMaintainerUseridNotBetween(Integer value1, Integer value2) {
			addCriterion("CONTENT_MAINTAINER_USERID not between", value1, value2, "contentMaintainerUserid");
			return (Criteria) this;
		}

		public Criteria andContentMaintainerTimeIsNull() {
			addCriterion("CONTENT_MAINTAINER_TIME is null");
			return (Criteria) this;
		}

		public Criteria andContentMaintainerTimeIsNotNull() {
			addCriterion("CONTENT_MAINTAINER_TIME is not null");
			return (Criteria) this;
		}

		public Criteria andContentMaintainerTimeEqualTo(Date value) {
			addCriterion("CONTENT_MAINTAINER_TIME =", value, "contentMaintainerTime");
			return (Criteria) this;
		}

		public Criteria andContentMaintainerTimeNotEqualTo(Date value) {
			addCriterion("CONTENT_MAINTAINER_TIME <>", value, "contentMaintainerTime");
			return (Criteria) this;
		}

		public Criteria andContentMaintainerTimeGreaterThan(Date value) {
			addCriterion("CONTENT_MAINTAINER_TIME >", value, "contentMaintainerTime");
			return (Criteria) this;
		}

		public Criteria andContentMaintainerTimeGreaterThanOrEqualTo(Date value) {
			addCriterion("CONTENT_MAINTAINER_TIME >=", value, "contentMaintainerTime");
			return (Criteria) this;
		}

		public Criteria andContentMaintainerTimeLessThan(Date value) {
			addCriterion("CONTENT_MAINTAINER_TIME <", value, "contentMaintainerTime");
			return (Criteria) this;
		}

		public Criteria andContentMaintainerTimeLessThanOrEqualTo(Date value) {
			addCriterion("CONTENT_MAINTAINER_TIME <=", value, "contentMaintainerTime");
			return (Criteria) this;
		}

		public Criteria andContentMaintainerTimeIn(List<Date> values) {
			addCriterion("CONTENT_MAINTAINER_TIME in", values, "contentMaintainerTime");
			return (Criteria) this;
		}

		public Criteria andContentMaintainerTimeNotIn(List<Date> values) {
			addCriterion("CONTENT_MAINTAINER_TIME not in", values, "contentMaintainerTime");
			return (Criteria) this;
		}

		public Criteria andContentMaintainerTimeBetween(Date value1, Date value2) {
			addCriterion("CONTENT_MAINTAINER_TIME between", value1, value2, "contentMaintainerTime");
			return (Criteria) this;
		}

		public Criteria andContentMaintainerTimeNotBetween(Date value1, Date value2) {
			addCriterion("CONTENT_MAINTAINER_TIME not between", value1, value2, "contentMaintainerTime");
			return (Criteria) this;
		}

		public Criteria andBuildIsUpdateIsNull() {
			addCriterion("BUILD_IS_UPDATE is null");
			return (Criteria) this;
		}

		public Criteria andBuildIsUpdateIsNotNull() {
			addCriterion("BUILD_IS_UPDATE is not null");
			return (Criteria) this;
		}

		public Criteria andBuildIsUpdateEqualTo(Byte value) {
			addCriterion("BUILD_IS_UPDATE =", value, "buildIsUpdate");
			return (Criteria) this;
		}

		public Criteria andBuildIsUpdateNotEqualTo(Byte value) {
			addCriterion("BUILD_IS_UPDATE <>", value, "buildIsUpdate");
			return (Criteria) this;
		}

		public Criteria andBuildIsUpdateGreaterThan(Byte value) {
			addCriterion("BUILD_IS_UPDATE >", value, "buildIsUpdate");
			return (Criteria) this;
		}

		public Criteria andBuildIsUpdateGreaterThanOrEqualTo(Byte value) {
			addCriterion("BUILD_IS_UPDATE >=", value, "buildIsUpdate");
			return (Criteria) this;
		}

		public Criteria andBuildIsUpdateLessThan(Byte value) {
			addCriterion("BUILD_IS_UPDATE <", value, "buildIsUpdate");
			return (Criteria) this;
		}

		public Criteria andBuildIsUpdateLessThanOrEqualTo(Byte value) {
			addCriterion("BUILD_IS_UPDATE <=", value, "buildIsUpdate");
			return (Criteria) this;
		}

		public Criteria andBuildIsUpdateIn(List<Byte> values) {
			addCriterion("BUILD_IS_UPDATE in", values, "buildIsUpdate");
			return (Criteria) this;
		}

		public Criteria andBuildIsUpdateNotIn(List<Byte> values) {
			addCriterion("BUILD_IS_UPDATE not in", values, "buildIsUpdate");
			return (Criteria) this;
		}

		public Criteria andBuildIsUpdateBetween(Byte value1, Byte value2) {
			addCriterion("BUILD_IS_UPDATE between", value1, value2, "buildIsUpdate");
			return (Criteria) this;
		}

		public Criteria andBuildIsUpdateNotBetween(Byte value1, Byte value2) {
			addCriterion("BUILD_IS_UPDATE not between", value1, value2, "buildIsUpdate");
			return (Criteria) this;
		}

		public Criteria andSearchFieldIsNull() {
			addCriterion("SEARCH_FIELD is null");
			return (Criteria) this;
		}

		public Criteria andSearchFieldIsNotNull() {
			addCriterion("SEARCH_FIELD is not null");
			return (Criteria) this;
		}

		public Criteria andSearchFieldEqualTo(String value) {
			addCriterion("SEARCH_FIELD =", value, "searchField");
			return (Criteria) this;
		}

		public Criteria andSearchFieldNotEqualTo(String value) {
			addCriterion("SEARCH_FIELD <>", value, "searchField");
			return (Criteria) this;
		}

		public Criteria andSearchFieldGreaterThan(String value) {
			addCriterion("SEARCH_FIELD >", value, "searchField");
			return (Criteria) this;
		}

		public Criteria andSearchFieldGreaterThanOrEqualTo(String value) {
			addCriterion("SEARCH_FIELD >=", value, "searchField");
			return (Criteria) this;
		}

		public Criteria andSearchFieldLessThan(String value) {
			addCriterion("SEARCH_FIELD <", value, "searchField");
			return (Criteria) this;
		}

		public Criteria andSearchFieldLessThanOrEqualTo(String value) {
			addCriterion("SEARCH_FIELD <=", value, "searchField");
			return (Criteria) this;
		}

		public Criteria andSearchFieldLike(String value) {
			addCriterion("SEARCH_FIELD like", value, "searchField");
			return (Criteria) this;
		}

		public Criteria andSearchFieldNotLike(String value) {
			addCriterion("SEARCH_FIELD not like", value, "searchField");
			return (Criteria) this;
		}

		public Criteria andSearchFieldIn(List<String> values) {
			addCriterion("SEARCH_FIELD in", values, "searchField");
			return (Criteria) this;
		}

		public Criteria andSearchFieldNotIn(List<String> values) {
			addCriterion("SEARCH_FIELD not in", values, "searchField");
			return (Criteria) this;
		}

		public Criteria andSearchFieldBetween(String value1, String value2) {
			addCriterion("SEARCH_FIELD between", value1, value2, "searchField");
			return (Criteria) this;
		}

		public Criteria andSearchFieldNotBetween(String value1, String value2) {
			addCriterion("SEARCH_FIELD not between", value1, value2, "searchField");
			return (Criteria) this;
		}

		public Criteria andContentAuditTimeIsNull() {
			addCriterion("CONTENT_AUDIT_TIME is null");
			return (Criteria) this;
		}

		public Criteria andContentAuditTimeIsNotNull() {
			addCriterion("CONTENT_AUDIT_TIME is not null");
			return (Criteria) this;
		}

		public Criteria andContentAuditTimeEqualTo(Date value) {
			addCriterion("CONTENT_AUDIT_TIME =", value, "contentAuditTime");
			return (Criteria) this;
		}

		public Criteria andContentAuditTimeNotEqualTo(Date value) {
			addCriterion("CONTENT_AUDIT_TIME <>", value, "contentAuditTime");
			return (Criteria) this;
		}

		public Criteria andContentAuditTimeGreaterThan(Date value) {
			addCriterion("CONTENT_AUDIT_TIME >", value, "contentAuditTime");
			return (Criteria) this;
		}

		public Criteria andContentAuditTimeGreaterThanOrEqualTo(Date value) {
			addCriterion("CONTENT_AUDIT_TIME >=", value, "contentAuditTime");
			return (Criteria) this;
		}

		public Criteria andContentAuditTimeLessThan(Date value) {
			addCriterion("CONTENT_AUDIT_TIME <", value, "contentAuditTime");
			return (Criteria) this;
		}

		public Criteria andContentAuditTimeLessThanOrEqualTo(Date value) {
			addCriterion("CONTENT_AUDIT_TIME <=", value, "contentAuditTime");
			return (Criteria) this;
		}

		public Criteria andContentAuditTimeIn(List<Date> values) {
			addCriterion("CONTENT_AUDIT_TIME in", values, "contentAuditTime");
			return (Criteria) this;
		}

		public Criteria andContentAuditTimeNotIn(List<Date> values) {
			addCriterion("CONTENT_AUDIT_TIME not in", values, "contentAuditTime");
			return (Criteria) this;
		}

		public Criteria andContentAuditTimeBetween(Date value1, Date value2) {
			addCriterion("CONTENT_AUDIT_TIME between", value1, value2, "contentAuditTime");
			return (Criteria) this;
		}

		public Criteria andContentAuditTimeNotBetween(Date value1, Date value2) {
			addCriterion("CONTENT_AUDIT_TIME not between", value1, value2, "contentAuditTime");
			return (Criteria) this;
		}

		public Criteria andContentAuditUserIdIsNull() {
			addCriterion("CONTENT_AUDIT_USER_ID is null");
			return (Criteria) this;
		}

		public Criteria andContentAuditUserIdIsNotNull() {
			addCriterion("CONTENT_AUDIT_USER_ID is not null");
			return (Criteria) this;
		}

		public Criteria andContentAuditUserIdEqualTo(Integer value) {
			addCriterion("CONTENT_AUDIT_USER_ID =", value, "contentAuditUserId");
			return (Criteria) this;
		}

		public Criteria andContentAuditUserIdNotEqualTo(Integer value) {
			addCriterion("CONTENT_AUDIT_USER_ID <>", value, "contentAuditUserId");
			return (Criteria) this;
		}

		public Criteria andContentAuditUserIdGreaterThan(Integer value) {
			addCriterion("CONTENT_AUDIT_USER_ID >", value, "contentAuditUserId");
			return (Criteria) this;
		}

		public Criteria andContentAuditUserIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("CONTENT_AUDIT_USER_ID >=", value, "contentAuditUserId");
			return (Criteria) this;
		}

		public Criteria andContentAuditUserIdLessThan(Integer value) {
			addCriterion("CONTENT_AUDIT_USER_ID <", value, "contentAuditUserId");
			return (Criteria) this;
		}

		public Criteria andContentAuditUserIdLessThanOrEqualTo(Integer value) {
			addCriterion("CONTENT_AUDIT_USER_ID <=", value, "contentAuditUserId");
			return (Criteria) this;
		}

		public Criteria andContentAuditUserIdIn(List<Integer> values) {
			addCriterion("CONTENT_AUDIT_USER_ID in", values, "contentAuditUserId");
			return (Criteria) this;
		}

		public Criteria andContentAuditUserIdNotIn(List<Integer> values) {
			addCriterion("CONTENT_AUDIT_USER_ID not in", values, "contentAuditUserId");
			return (Criteria) this;
		}

		public Criteria andContentAuditUserIdBetween(Integer value1, Integer value2) {
			addCriterion("CONTENT_AUDIT_USER_ID between", value1, value2, "contentAuditUserId");
			return (Criteria) this;
		}

		public Criteria andContentAuditUserIdNotBetween(Integer value1, Integer value2) {
			addCriterion("CONTENT_AUDIT_USER_ID not between", value1, value2, "contentAuditUserId");
			return (Criteria) this;
		}

		public Criteria andAuditTimeIsNull() {
			addCriterion("AUDIT_TIME is null");
			return (Criteria) this;
		}

		public Criteria andAuditTimeIsNotNull() {
			addCriterion("AUDIT_TIME is not null");
			return (Criteria) this;
		}

		public Criteria andAuditTimeEqualTo(Date value) {
			addCriterion("AUDIT_TIME =", value, "auditTime");
			return (Criteria) this;
		}

		public Criteria andAuditTimeNotEqualTo(Date value) {
			addCriterion("AUDIT_TIME <>", value, "auditTime");
			return (Criteria) this;
		}

		public Criteria andAuditTimeGreaterThan(Date value) {
			addCriterion("AUDIT_TIME >", value, "auditTime");
			return (Criteria) this;
		}

		public Criteria andAuditTimeGreaterThanOrEqualTo(Date value) {
			addCriterion("AUDIT_TIME >=", value, "auditTime");
			return (Criteria) this;
		}

		public Criteria andAuditTimeLessThan(Date value) {
			addCriterion("AUDIT_TIME <", value, "auditTime");
			return (Criteria) this;
		}

		public Criteria andAuditTimeLessThanOrEqualTo(Date value) {
			addCriterion("AUDIT_TIME <=", value, "auditTime");
			return (Criteria) this;
		}

		public Criteria andAuditTimeIn(List<Date> values) {
			addCriterion("AUDIT_TIME in", values, "auditTime");
			return (Criteria) this;
		}

		public Criteria andAuditTimeNotIn(List<Date> values) {
			addCriterion("AUDIT_TIME not in", values, "auditTime");
			return (Criteria) this;
		}

		public Criteria andAuditTimeBetween(Date value1, Date value2) {
			addCriterion("AUDIT_TIME between", value1, value2, "auditTime");
			return (Criteria) this;
		}

		public Criteria andAuditTimeNotBetween(Date value1, Date value2) {
			addCriterion("AUDIT_TIME not between", value1, value2, "auditTime");
			return (Criteria) this;
		}

		public Criteria andAuditUserIdIsNull() {
			addCriterion("AUDIT_USER_ID is null");
			return (Criteria) this;
		}

		public Criteria andAuditUserIdIsNotNull() {
			addCriterion("AUDIT_USER_ID is not null");
			return (Criteria) this;
		}

		public Criteria andAuditUserIdEqualTo(Integer value) {
			addCriterion("AUDIT_USER_ID =", value, "auditUserId");
			return (Criteria) this;
		}

		public Criteria andAuditUserIdNotEqualTo(Integer value) {
			addCriterion("AUDIT_USER_ID <>", value, "auditUserId");
			return (Criteria) this;
		}

		public Criteria andAuditUserIdGreaterThan(Integer value) {
			addCriterion("AUDIT_USER_ID >", value, "auditUserId");
			return (Criteria) this;
		}

		public Criteria andAuditUserIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("AUDIT_USER_ID >=", value, "auditUserId");
			return (Criteria) this;
		}

		public Criteria andAuditUserIdLessThan(Integer value) {
			addCriterion("AUDIT_USER_ID <", value, "auditUserId");
			return (Criteria) this;
		}

		public Criteria andAuditUserIdLessThanOrEqualTo(Integer value) {
			addCriterion("AUDIT_USER_ID <=", value, "auditUserId");
			return (Criteria) this;
		}

		public Criteria andAuditUserIdIn(List<Integer> values) {
			addCriterion("AUDIT_USER_ID in", values, "auditUserId");
			return (Criteria) this;
		}

		public Criteria andAuditUserIdNotIn(List<Integer> values) {
			addCriterion("AUDIT_USER_ID not in", values, "auditUserId");
			return (Criteria) this;
		}

		public Criteria andAuditUserIdBetween(Integer value1, Integer value2) {
			addCriterion("AUDIT_USER_ID between", value1, value2, "auditUserId");
			return (Criteria) this;
		}

		public Criteria andAuditUserIdNotBetween(Integer value1, Integer value2) {
			addCriterion("AUDIT_USER_ID not between", value1, value2, "auditUserId");
			return (Criteria) this;
		}

		public Criteria andBuildingMaintenanceIdIsNull() {
			addCriterion("BUILDING_MAINTENANCE_ID is null");
			return (Criteria) this;
		}

		public Criteria andBuildingMaintenanceIdIsNotNull() {
			addCriterion("BUILDING_MAINTENANCE_ID is not null");
			return (Criteria) this;
		}

		public Criteria andBuildingMaintenanceIdEqualTo(Integer value) {
			addCriterion("BUILDING_MAINTENANCE_ID =", value, "buildingMaintenanceId");
			return (Criteria) this;
		}

		public Criteria andBuildingMaintenanceIdNotEqualTo(Integer value) {
			addCriterion("BUILDING_MAINTENANCE_ID <>", value, "buildingMaintenanceId");
			return (Criteria) this;
		}

		public Criteria andBuildingMaintenanceIdGreaterThan(Integer value) {
			addCriterion("BUILDING_MAINTENANCE_ID >", value, "buildingMaintenanceId");
			return (Criteria) this;
		}

		public Criteria andBuildingMaintenanceIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("BUILDING_MAINTENANCE_ID >=", value, "buildingMaintenanceId");
			return (Criteria) this;
		}

		public Criteria andBuildingMaintenanceIdLessThan(Integer value) {
			addCriterion("BUILDING_MAINTENANCE_ID <", value, "buildingMaintenanceId");
			return (Criteria) this;
		}

		public Criteria andBuildingMaintenanceIdLessThanOrEqualTo(Integer value) {
			addCriterion("BUILDING_MAINTENANCE_ID <=", value, "buildingMaintenanceId");
			return (Criteria) this;
		}

		public Criteria andBuildingMaintenanceIdIn(List<Integer> values) {
			addCriterion("BUILDING_MAINTENANCE_ID in", values, "buildingMaintenanceId");
			return (Criteria) this;
		}

		public Criteria andBuildingMaintenanceIdNotIn(List<Integer> values) {
			addCriterion("BUILDING_MAINTENANCE_ID not in", values, "buildingMaintenanceId");
			return (Criteria) this;
		}

		public Criteria andBuildingMaintenanceIdBetween(Integer value1, Integer value2) {
			addCriterion("BUILDING_MAINTENANCE_ID between", value1, value2, "buildingMaintenanceId");
			return (Criteria) this;
		}

		public Criteria andBuildingMaintenanceIdNotBetween(Integer value1, Integer value2) {
			addCriterion("BUILDING_MAINTENANCE_ID not between", value1, value2, "buildingMaintenanceId");
			return (Criteria) this;
		}

		public Criteria andBuildingMaintenanceTimeIsNull() {
			addCriterion("BUILDING_MAINTENANCE_TIME is null");
			return (Criteria) this;
		}

		public Criteria andBuildingMaintenanceTimeIsNotNull() {
			addCriterion("BUILDING_MAINTENANCE_TIME is not null");
			return (Criteria) this;
		}

		public Criteria andBuildingMaintenanceTimeEqualTo(Date value) {
			addCriterion("BUILDING_MAINTENANCE_TIME =", value, "buildingMaintenanceTime");
			return (Criteria) this;
		}

		public Criteria andBuildingMaintenanceTimeNotEqualTo(Date value) {
			addCriterion("BUILDING_MAINTENANCE_TIME <>", value, "buildingMaintenanceTime");
			return (Criteria) this;
		}

		public Criteria andBuildingMaintenanceTimeGreaterThan(Date value) {
			addCriterion("BUILDING_MAINTENANCE_TIME >", value, "buildingMaintenanceTime");
			return (Criteria) this;
		}

		public Criteria andBuildingMaintenanceTimeGreaterThanOrEqualTo(Date value) {
			addCriterion("BUILDING_MAINTENANCE_TIME >=", value, "buildingMaintenanceTime");
			return (Criteria) this;
		}

		public Criteria andBuildingMaintenanceTimeLessThan(Date value) {
			addCriterion("BUILDING_MAINTENANCE_TIME <", value, "buildingMaintenanceTime");
			return (Criteria) this;
		}

		public Criteria andBuildingMaintenanceTimeLessThanOrEqualTo(Date value) {
			addCriterion("BUILDING_MAINTENANCE_TIME <=", value, "buildingMaintenanceTime");
			return (Criteria) this;
		}

		public Criteria andBuildingMaintenanceTimeIn(List<Date> values) {
			addCriterion("BUILDING_MAINTENANCE_TIME in", values, "buildingMaintenanceTime");
			return (Criteria) this;
		}

		public Criteria andBuildingMaintenanceTimeNotIn(List<Date> values) {
			addCriterion("BUILDING_MAINTENANCE_TIME not in", values, "buildingMaintenanceTime");
			return (Criteria) this;
		}

		public Criteria andBuildingMaintenanceTimeBetween(Date value1, Date value2) {
			addCriterion("BUILDING_MAINTENANCE_TIME between", value1, value2, "buildingMaintenanceTime");
			return (Criteria) this;
		}

		public Criteria andBuildingMaintenanceTimeNotBetween(Date value1, Date value2) {
			addCriterion("BUILDING_MAINTENANCE_TIME not between", value1, value2, "buildingMaintenanceTime");
			return (Criteria) this;
		}

		public Criteria andBuildingReviewIdIsNull() {
			addCriterion("BUILDING_REVIEW_ID is null");
			return (Criteria) this;
		}

		public Criteria andBuildingReviewIdIsNotNull() {
			addCriterion("BUILDING_REVIEW_ID is not null");
			return (Criteria) this;
		}

		public Criteria andBuildingReviewIdEqualTo(Integer value) {
			addCriterion("BUILDING_REVIEW_ID =", value, "buildingReviewId");
			return (Criteria) this;
		}

		public Criteria andBuildingReviewIdNotEqualTo(Integer value) {
			addCriterion("BUILDING_REVIEW_ID <>", value, "buildingReviewId");
			return (Criteria) this;
		}

		public Criteria andBuildingReviewIdGreaterThan(Integer value) {
			addCriterion("BUILDING_REVIEW_ID >", value, "buildingReviewId");
			return (Criteria) this;
		}

		public Criteria andBuildingReviewIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("BUILDING_REVIEW_ID >=", value, "buildingReviewId");
			return (Criteria) this;
		}

		public Criteria andBuildingReviewIdLessThan(Integer value) {
			addCriterion("BUILDING_REVIEW_ID <", value, "buildingReviewId");
			return (Criteria) this;
		}

		public Criteria andBuildingReviewIdLessThanOrEqualTo(Integer value) {
			addCriterion("BUILDING_REVIEW_ID <=", value, "buildingReviewId");
			return (Criteria) this;
		}

		public Criteria andBuildingReviewIdIn(List<Integer> values) {
			addCriterion("BUILDING_REVIEW_ID in", values, "buildingReviewId");
			return (Criteria) this;
		}

		public Criteria andBuildingReviewIdNotIn(List<Integer> values) {
			addCriterion("BUILDING_REVIEW_ID not in", values, "buildingReviewId");
			return (Criteria) this;
		}

		public Criteria andBuildingReviewIdBetween(Integer value1, Integer value2) {
			addCriterion("BUILDING_REVIEW_ID between", value1, value2, "buildingReviewId");
			return (Criteria) this;
		}

		public Criteria andBuildingReviewIdNotBetween(Integer value1, Integer value2) {
			addCriterion("BUILDING_REVIEW_ID not between", value1, value2, "buildingReviewId");
			return (Criteria) this;
		}

		public Criteria andBuildingReviewStatusIsNull() {
			addCriterion("BUILDING_REVIEW_STATUS is null");
			return (Criteria) this;
		}

		public Criteria andBuildingReviewStatusIsNotNull() {
			addCriterion("BUILDING_REVIEW_STATUS is not null");
			return (Criteria) this;
		}

		public Criteria andBuildingReviewStatusEqualTo(Byte value) {
			addCriterion("BUILDING_REVIEW_STATUS =", value, "buildingReviewStatus");
			return (Criteria) this;
		}

		public Criteria andBuildingReviewStatusNotEqualTo(Byte value) {
			addCriterion("BUILDING_REVIEW_STATUS <>", value, "buildingReviewStatus");
			return (Criteria) this;
		}

		public Criteria andBuildingReviewStatusGreaterThan(Byte value) {
			addCriterion("BUILDING_REVIEW_STATUS >", value, "buildingReviewStatus");
			return (Criteria) this;
		}

		public Criteria andBuildingReviewStatusGreaterThanOrEqualTo(Byte value) {
			addCriterion("BUILDING_REVIEW_STATUS >=", value, "buildingReviewStatus");
			return (Criteria) this;
		}

		public Criteria andBuildingReviewStatusLessThan(Byte value) {
			addCriterion("BUILDING_REVIEW_STATUS <", value, "buildingReviewStatus");
			return (Criteria) this;
		}

		public Criteria andBuildingReviewStatusLessThanOrEqualTo(Byte value) {
			addCriterion("BUILDING_REVIEW_STATUS <=", value, "buildingReviewStatus");
			return (Criteria) this;
		}

		public Criteria andBuildingReviewStatusIn(List<Byte> values) {
			addCriterion("BUILDING_REVIEW_STATUS in", values, "buildingReviewStatus");
			return (Criteria) this;
		}

		public Criteria andBuildingReviewStatusNotIn(List<Byte> values) {
			addCriterion("BUILDING_REVIEW_STATUS not in", values, "buildingReviewStatus");
			return (Criteria) this;
		}

		public Criteria andBuildingReviewStatusBetween(Byte value1, Byte value2) {
			addCriterion("BUILDING_REVIEW_STATUS between", value1, value2, "buildingReviewStatus");
			return (Criteria) this;
		}

		public Criteria andBuildingReviewStatusNotBetween(Byte value1, Byte value2) {
			addCriterion("BUILDING_REVIEW_STATUS not between", value1, value2, "buildingReviewStatus");
			return (Criteria) this;
		}

		public Criteria andBuildingReviewTimeIsNull() {
			addCriterion("BUILDING_REVIEW_TIME is null");
			return (Criteria) this;
		}

		public Criteria andBuildingReviewTimeIsNotNull() {
			addCriterion("BUILDING_REVIEW_TIME is not null");
			return (Criteria) this;
		}

		public Criteria andBuildingReviewTimeEqualTo(Date value) {
			addCriterion("BUILDING_REVIEW_TIME =", value, "buildingReviewTime");
			return (Criteria) this;
		}

		public Criteria andBuildingReviewTimeNotEqualTo(Date value) {
			addCriterion("BUILDING_REVIEW_TIME <>", value, "buildingReviewTime");
			return (Criteria) this;
		}

		public Criteria andBuildingReviewTimeGreaterThan(Date value) {
			addCriterion("BUILDING_REVIEW_TIME >", value, "buildingReviewTime");
			return (Criteria) this;
		}

		public Criteria andBuildingReviewTimeGreaterThanOrEqualTo(Date value) {
			addCriterion("BUILDING_REVIEW_TIME >=", value, "buildingReviewTime");
			return (Criteria) this;
		}

		public Criteria andBuildingReviewTimeLessThan(Date value) {
			addCriterion("BUILDING_REVIEW_TIME <", value, "buildingReviewTime");
			return (Criteria) this;
		}

		public Criteria andBuildingReviewTimeLessThanOrEqualTo(Date value) {
			addCriterion("BUILDING_REVIEW_TIME <=", value, "buildingReviewTime");
			return (Criteria) this;
		}

		public Criteria andBuildingReviewTimeIn(List<Date> values) {
			addCriterion("BUILDING_REVIEW_TIME in", values, "buildingReviewTime");
			return (Criteria) this;
		}

		public Criteria andBuildingReviewTimeNotIn(List<Date> values) {
			addCriterion("BUILDING_REVIEW_TIME not in", values, "buildingReviewTime");
			return (Criteria) this;
		}

		public Criteria andBuildingReviewTimeBetween(Date value1, Date value2) {
			addCriterion("BUILDING_REVIEW_TIME between", value1, value2, "buildingReviewTime");
			return (Criteria) this;
		}

		public Criteria andBuildingReviewTimeNotBetween(Date value1, Date value2) {
			addCriterion("BUILDING_REVIEW_TIME not between", value1, value2, "buildingReviewTime");
			return (Criteria) this;
		}

		public Criteria andFddBuildIdIsNull() {
			addCriterion("FDD_BUILD_ID is null");
			return (Criteria) this;
		}

		public Criteria andFddBuildIdIsNotNull() {
			addCriterion("FDD_BUILD_ID is not null");
			return (Criteria) this;
		}

		public Criteria andFddBuildIdEqualTo(Integer value) {
			addCriterion("FDD_BUILD_ID =", value, "fddBuildId");
			return (Criteria) this;
		}

		public Criteria andFddBuildIdNotEqualTo(Integer value) {
			addCriterion("FDD_BUILD_ID <>", value, "fddBuildId");
			return (Criteria) this;
		}

		public Criteria andFddBuildIdGreaterThan(Integer value) {
			addCriterion("FDD_BUILD_ID >", value, "fddBuildId");
			return (Criteria) this;
		}

		public Criteria andFddBuildIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("FDD_BUILD_ID >=", value, "fddBuildId");
			return (Criteria) this;
		}

		public Criteria andFddBuildIdLessThan(Integer value) {
			addCriterion("FDD_BUILD_ID <", value, "fddBuildId");
			return (Criteria) this;
		}

		public Criteria andFddBuildIdLessThanOrEqualTo(Integer value) {
			addCriterion("FDD_BUILD_ID <=", value, "fddBuildId");
			return (Criteria) this;
		}

		public Criteria andFddBuildIdIn(List<Integer> values) {
			addCriterion("FDD_BUILD_ID in", values, "fddBuildId");
			return (Criteria) this;
		}

		public Criteria andFddBuildIdNotIn(List<Integer> values) {
			addCriterion("FDD_BUILD_ID not in", values, "fddBuildId");
			return (Criteria) this;
		}

		public Criteria andFddBuildIdBetween(Integer value1, Integer value2) {
			addCriterion("FDD_BUILD_ID between", value1, value2, "fddBuildId");
			return (Criteria) this;
		}

		public Criteria andFddBuildIdNotBetween(Integer value1, Integer value2) {
			addCriterion("FDD_BUILD_ID not between", value1, value2, "fddBuildId");
			return (Criteria) this;
		}

		public Criteria andParkingModeIsNull() {
			addCriterion("PARKING_MODE is null");
			return (Criteria) this;
		}

		public Criteria andParkingModeIsNotNull() {
			addCriterion("PARKING_MODE is not null");
			return (Criteria) this;
		}

		public Criteria andParkingModeEqualTo(String value) {
			addCriterion("PARKING_MODE =", value, "parkingMode");
			return (Criteria) this;
		}

		public Criteria andParkingModeNotEqualTo(String value) {
			addCriterion("PARKING_MODE <>", value, "parkingMode");
			return (Criteria) this;
		}

		public Criteria andParkingModeGreaterThan(String value) {
			addCriterion("PARKING_MODE >", value, "parkingMode");
			return (Criteria) this;
		}

		public Criteria andParkingModeGreaterThanOrEqualTo(String value) {
			addCriterion("PARKING_MODE >=", value, "parkingMode");
			return (Criteria) this;
		}

		public Criteria andParkingModeLessThan(String value) {
			addCriterion("PARKING_MODE <", value, "parkingMode");
			return (Criteria) this;
		}

		public Criteria andParkingModeLessThanOrEqualTo(String value) {
			addCriterion("PARKING_MODE <=", value, "parkingMode");
			return (Criteria) this;
		}

		public Criteria andParkingModeLike(String value) {
			addCriterion("PARKING_MODE like", value, "parkingMode");
			return (Criteria) this;
		}

		public Criteria andParkingModeNotLike(String value) {
			addCriterion("PARKING_MODE not like", value, "parkingMode");
			return (Criteria) this;
		}

		public Criteria andParkingModeIn(List<String> values) {
			addCriterion("PARKING_MODE in", values, "parkingMode");
			return (Criteria) this;
		}

		public Criteria andParkingModeNotIn(List<String> values) {
			addCriterion("PARKING_MODE not in", values, "parkingMode");
			return (Criteria) this;
		}

		public Criteria andParkingModeBetween(String value1, String value2) {
			addCriterion("PARKING_MODE between", value1, value2, "parkingMode");
			return (Criteria) this;
		}

		public Criteria andParkingModeNotBetween(String value1, String value2) {
			addCriterion("PARKING_MODE not between", value1, value2, "parkingMode");
			return (Criteria) this;
		}

		public Criteria andParkingRateIsNull() {
			addCriterion("PARKING_RATE is null");
			return (Criteria) this;
		}

		public Criteria andParkingRateIsNotNull() {
			addCriterion("PARKING_RATE is not null");
			return (Criteria) this;
		}

		public Criteria andParkingRateEqualTo(String value) {
			addCriterion("PARKING_RATE =", value, "parkingRate");
			return (Criteria) this;
		}

		public Criteria andParkingRateNotEqualTo(String value) {
			addCriterion("PARKING_RATE <>", value, "parkingRate");
			return (Criteria) this;
		}

		public Criteria andParkingRateGreaterThan(String value) {
			addCriterion("PARKING_RATE >", value, "parkingRate");
			return (Criteria) this;
		}

		public Criteria andParkingRateGreaterThanOrEqualTo(String value) {
			addCriterion("PARKING_RATE >=", value, "parkingRate");
			return (Criteria) this;
		}

		public Criteria andParkingRateLessThan(String value) {
			addCriterion("PARKING_RATE <", value, "parkingRate");
			return (Criteria) this;
		}

		public Criteria andParkingRateLessThanOrEqualTo(String value) {
			addCriterion("PARKING_RATE <=", value, "parkingRate");
			return (Criteria) this;
		}

		public Criteria andParkingRateLike(String value) {
			addCriterion("PARKING_RATE like", value, "parkingRate");
			return (Criteria) this;
		}

		public Criteria andParkingRateNotLike(String value) {
			addCriterion("PARKING_RATE not like", value, "parkingRate");
			return (Criteria) this;
		}

		public Criteria andParkingRateIn(List<String> values) {
			addCriterion("PARKING_RATE in", values, "parkingRate");
			return (Criteria) this;
		}

		public Criteria andParkingRateNotIn(List<String> values) {
			addCriterion("PARKING_RATE not in", values, "parkingRate");
			return (Criteria) this;
		}

		public Criteria andParkingRateBetween(String value1, String value2) {
			addCriterion("PARKING_RATE between", value1, value2, "parkingRate");
			return (Criteria) this;
		}

		public Criteria andParkingRateNotBetween(String value1, String value2) {
			addCriterion("PARKING_RATE not between", value1, value2, "parkingRate");
			return (Criteria) this;
		}

		public Criteria andPowerSupplyModeIsNull() {
			addCriterion("POWER_SUPPLY_MODE is null");
			return (Criteria) this;
		}

		public Criteria andPowerSupplyModeIsNotNull() {
			addCriterion("POWER_SUPPLY_MODE is not null");
			return (Criteria) this;
		}

		public Criteria andPowerSupplyModeEqualTo(String value) {
			addCriterion("POWER_SUPPLY_MODE =", value, "powerSupplyMode");
			return (Criteria) this;
		}

		public Criteria andPowerSupplyModeNotEqualTo(String value) {
			addCriterion("POWER_SUPPLY_MODE <>", value, "powerSupplyMode");
			return (Criteria) this;
		}

		public Criteria andPowerSupplyModeGreaterThan(String value) {
			addCriterion("POWER_SUPPLY_MODE >", value, "powerSupplyMode");
			return (Criteria) this;
		}

		public Criteria andPowerSupplyModeGreaterThanOrEqualTo(String value) {
			addCriterion("POWER_SUPPLY_MODE >=", value, "powerSupplyMode");
			return (Criteria) this;
		}

		public Criteria andPowerSupplyModeLessThan(String value) {
			addCriterion("POWER_SUPPLY_MODE <", value, "powerSupplyMode");
			return (Criteria) this;
		}

		public Criteria andPowerSupplyModeLessThanOrEqualTo(String value) {
			addCriterion("POWER_SUPPLY_MODE <=", value, "powerSupplyMode");
			return (Criteria) this;
		}

		public Criteria andPowerSupplyModeLike(String value) {
			addCriterion("POWER_SUPPLY_MODE like", value, "powerSupplyMode");
			return (Criteria) this;
		}

		public Criteria andPowerSupplyModeNotLike(String value) {
			addCriterion("POWER_SUPPLY_MODE not like", value, "powerSupplyMode");
			return (Criteria) this;
		}

		public Criteria andPowerSupplyModeIn(List<String> values) {
			addCriterion("POWER_SUPPLY_MODE in", values, "powerSupplyMode");
			return (Criteria) this;
		}

		public Criteria andPowerSupplyModeNotIn(List<String> values) {
			addCriterion("POWER_SUPPLY_MODE not in", values, "powerSupplyMode");
			return (Criteria) this;
		}

		public Criteria andPowerSupplyModeBetween(String value1, String value2) {
			addCriterion("POWER_SUPPLY_MODE between", value1, value2, "powerSupplyMode");
			return (Criteria) this;
		}

		public Criteria andPowerSupplyModeNotBetween(String value1, String value2) {
			addCriterion("POWER_SUPPLY_MODE not between", value1, value2, "powerSupplyMode");
			return (Criteria) this;
		}

		public Criteria andWaterSupplyModeIsNull() {
			addCriterion("WATER_SUPPLY_MODE is null");
			return (Criteria) this;
		}

		public Criteria andWaterSupplyModeIsNotNull() {
			addCriterion("WATER_SUPPLY_MODE is not null");
			return (Criteria) this;
		}

		public Criteria andWaterSupplyModeEqualTo(String value) {
			addCriterion("WATER_SUPPLY_MODE =", value, "waterSupplyMode");
			return (Criteria) this;
		}

		public Criteria andWaterSupplyModeNotEqualTo(String value) {
			addCriterion("WATER_SUPPLY_MODE <>", value, "waterSupplyMode");
			return (Criteria) this;
		}

		public Criteria andWaterSupplyModeGreaterThan(String value) {
			addCriterion("WATER_SUPPLY_MODE >", value, "waterSupplyMode");
			return (Criteria) this;
		}

		public Criteria andWaterSupplyModeGreaterThanOrEqualTo(String value) {
			addCriterion("WATER_SUPPLY_MODE >=", value, "waterSupplyMode");
			return (Criteria) this;
		}

		public Criteria andWaterSupplyModeLessThan(String value) {
			addCriterion("WATER_SUPPLY_MODE <", value, "waterSupplyMode");
			return (Criteria) this;
		}

		public Criteria andWaterSupplyModeLessThanOrEqualTo(String value) {
			addCriterion("WATER_SUPPLY_MODE <=", value, "waterSupplyMode");
			return (Criteria) this;
		}

		public Criteria andWaterSupplyModeLike(String value) {
			addCriterion("WATER_SUPPLY_MODE like", value, "waterSupplyMode");
			return (Criteria) this;
		}

		public Criteria andWaterSupplyModeNotLike(String value) {
			addCriterion("WATER_SUPPLY_MODE not like", value, "waterSupplyMode");
			return (Criteria) this;
		}

		public Criteria andWaterSupplyModeIn(List<String> values) {
			addCriterion("WATER_SUPPLY_MODE in", values, "waterSupplyMode");
			return (Criteria) this;
		}

		public Criteria andWaterSupplyModeNotIn(List<String> values) {
			addCriterion("WATER_SUPPLY_MODE not in", values, "waterSupplyMode");
			return (Criteria) this;
		}

		public Criteria andWaterSupplyModeBetween(String value1, String value2) {
			addCriterion("WATER_SUPPLY_MODE between", value1, value2, "waterSupplyMode");
			return (Criteria) this;
		}

		public Criteria andWaterSupplyModeNotBetween(String value1, String value2) {
			addCriterion("WATER_SUPPLY_MODE not between", value1, value2, "waterSupplyMode");
			return (Criteria) this;
		}

		public Criteria andAirSupplyModeIsNull() {
			addCriterion("AIR_SUPPLY_MODE is null");
			return (Criteria) this;
		}

		public Criteria andAirSupplyModeIsNotNull() {
			addCriterion("AIR_SUPPLY_MODE is not null");
			return (Criteria) this;
		}

		public Criteria andAirSupplyModeEqualTo(String value) {
			addCriterion("AIR_SUPPLY_MODE =", value, "airSupplyMode");
			return (Criteria) this;
		}

		public Criteria andAirSupplyModeNotEqualTo(String value) {
			addCriterion("AIR_SUPPLY_MODE <>", value, "airSupplyMode");
			return (Criteria) this;
		}

		public Criteria andAirSupplyModeGreaterThan(String value) {
			addCriterion("AIR_SUPPLY_MODE >", value, "airSupplyMode");
			return (Criteria) this;
		}

		public Criteria andAirSupplyModeGreaterThanOrEqualTo(String value) {
			addCriterion("AIR_SUPPLY_MODE >=", value, "airSupplyMode");
			return (Criteria) this;
		}

		public Criteria andAirSupplyModeLessThan(String value) {
			addCriterion("AIR_SUPPLY_MODE <", value, "airSupplyMode");
			return (Criteria) this;
		}

		public Criteria andAirSupplyModeLessThanOrEqualTo(String value) {
			addCriterion("AIR_SUPPLY_MODE <=", value, "airSupplyMode");
			return (Criteria) this;
		}

		public Criteria andAirSupplyModeLike(String value) {
			addCriterion("AIR_SUPPLY_MODE like", value, "airSupplyMode");
			return (Criteria) this;
		}

		public Criteria andAirSupplyModeNotLike(String value) {
			addCriterion("AIR_SUPPLY_MODE not like", value, "airSupplyMode");
			return (Criteria) this;
		}

		public Criteria andAirSupplyModeIn(List<String> values) {
			addCriterion("AIR_SUPPLY_MODE in", values, "airSupplyMode");
			return (Criteria) this;
		}

		public Criteria andAirSupplyModeNotIn(List<String> values) {
			addCriterion("AIR_SUPPLY_MODE not in", values, "airSupplyMode");
			return (Criteria) this;
		}

		public Criteria andAirSupplyModeBetween(String value1, String value2) {
			addCriterion("AIR_SUPPLY_MODE between", value1, value2, "airSupplyMode");
			return (Criteria) this;
		}

		public Criteria andAirSupplyModeNotBetween(String value1, String value2) {
			addCriterion("AIR_SUPPLY_MODE not between", value1, value2, "airSupplyMode");
			return (Criteria) this;
		}

		public Criteria andHeatingModeIsNull() {
			addCriterion("HEATING_MODE is null");
			return (Criteria) this;
		}

		public Criteria andHeatingModeIsNotNull() {
			addCriterion("HEATING_MODE is not null");
			return (Criteria) this;
		}

		public Criteria andHeatingModeEqualTo(String value) {
			addCriterion("HEATING_MODE =", value, "heatingMode");
			return (Criteria) this;
		}

		public Criteria andHeatingModeNotEqualTo(String value) {
			addCriterion("HEATING_MODE <>", value, "heatingMode");
			return (Criteria) this;
		}

		public Criteria andHeatingModeGreaterThan(String value) {
			addCriterion("HEATING_MODE >", value, "heatingMode");
			return (Criteria) this;
		}

		public Criteria andHeatingModeGreaterThanOrEqualTo(String value) {
			addCriterion("HEATING_MODE >=", value, "heatingMode");
			return (Criteria) this;
		}

		public Criteria andHeatingModeLessThan(String value) {
			addCriterion("HEATING_MODE <", value, "heatingMode");
			return (Criteria) this;
		}

		public Criteria andHeatingModeLessThanOrEqualTo(String value) {
			addCriterion("HEATING_MODE <=", value, "heatingMode");
			return (Criteria) this;
		}

		public Criteria andHeatingModeLike(String value) {
			addCriterion("HEATING_MODE like", value, "heatingMode");
			return (Criteria) this;
		}

		public Criteria andHeatingModeNotLike(String value) {
			addCriterion("HEATING_MODE not like", value, "heatingMode");
			return (Criteria) this;
		}

		public Criteria andHeatingModeIn(List<String> values) {
			addCriterion("HEATING_MODE in", values, "heatingMode");
			return (Criteria) this;
		}

		public Criteria andHeatingModeNotIn(List<String> values) {
			addCriterion("HEATING_MODE not in", values, "heatingMode");
			return (Criteria) this;
		}

		public Criteria andHeatingModeBetween(String value1, String value2) {
			addCriterion("HEATING_MODE between", value1, value2, "heatingMode");
			return (Criteria) this;
		}

		public Criteria andHeatingModeNotBetween(String value1, String value2) {
			addCriterion("HEATING_MODE not between", value1, value2, "heatingMode");
			return (Criteria) this;
		}

		public Criteria andElectricityFeesIsNull() {
			addCriterion("ELECTRICITY_FEES is null");
			return (Criteria) this;
		}

		public Criteria andElectricityFeesIsNotNull() {
			addCriterion("ELECTRICITY_FEES is not null");
			return (Criteria) this;
		}

		public Criteria andElectricityFeesEqualTo(String value) {
			addCriterion("ELECTRICITY_FEES =", value, "electricityFees");
			return (Criteria) this;
		}

		public Criteria andElectricityFeesNotEqualTo(String value) {
			addCriterion("ELECTRICITY_FEES <>", value, "electricityFees");
			return (Criteria) this;
		}

		public Criteria andElectricityFeesGreaterThan(String value) {
			addCriterion("ELECTRICITY_FEES >", value, "electricityFees");
			return (Criteria) this;
		}

		public Criteria andElectricityFeesGreaterThanOrEqualTo(String value) {
			addCriterion("ELECTRICITY_FEES >=", value, "electricityFees");
			return (Criteria) this;
		}

		public Criteria andElectricityFeesLessThan(String value) {
			addCriterion("ELECTRICITY_FEES <", value, "electricityFees");
			return (Criteria) this;
		}

		public Criteria andElectricityFeesLessThanOrEqualTo(String value) {
			addCriterion("ELECTRICITY_FEES <=", value, "electricityFees");
			return (Criteria) this;
		}

		public Criteria andElectricityFeesLike(String value) {
			addCriterion("ELECTRICITY_FEES like", value, "electricityFees");
			return (Criteria) this;
		}

		public Criteria andElectricityFeesNotLike(String value) {
			addCriterion("ELECTRICITY_FEES not like", value, "electricityFees");
			return (Criteria) this;
		}

		public Criteria andElectricityFeesIn(List<String> values) {
			addCriterion("ELECTRICITY_FEES in", values, "electricityFees");
			return (Criteria) this;
		}

		public Criteria andElectricityFeesNotIn(List<String> values) {
			addCriterion("ELECTRICITY_FEES not in", values, "electricityFees");
			return (Criteria) this;
		}

		public Criteria andElectricityFeesBetween(String value1, String value2) {
			addCriterion("ELECTRICITY_FEES between", value1, value2, "electricityFees");
			return (Criteria) this;
		}

		public Criteria andElectricityFeesNotBetween(String value1, String value2) {
			addCriterion("ELECTRICITY_FEES not between", value1, value2, "electricityFees");
			return (Criteria) this;
		}

		public Criteria andWaterFeesIsNull() {
			addCriterion("WATER_FEES is null");
			return (Criteria) this;
		}

		public Criteria andWaterFeesIsNotNull() {
			addCriterion("WATER_FEES is not null");
			return (Criteria) this;
		}

		public Criteria andWaterFeesEqualTo(String value) {
			addCriterion("WATER_FEES =", value, "waterFees");
			return (Criteria) this;
		}

		public Criteria andWaterFeesNotEqualTo(String value) {
			addCriterion("WATER_FEES <>", value, "waterFees");
			return (Criteria) this;
		}

		public Criteria andWaterFeesGreaterThan(String value) {
			addCriterion("WATER_FEES >", value, "waterFees");
			return (Criteria) this;
		}

		public Criteria andWaterFeesGreaterThanOrEqualTo(String value) {
			addCriterion("WATER_FEES >=", value, "waterFees");
			return (Criteria) this;
		}

		public Criteria andWaterFeesLessThan(String value) {
			addCriterion("WATER_FEES <", value, "waterFees");
			return (Criteria) this;
		}

		public Criteria andWaterFeesLessThanOrEqualTo(String value) {
			addCriterion("WATER_FEES <=", value, "waterFees");
			return (Criteria) this;
		}

		public Criteria andWaterFeesLike(String value) {
			addCriterion("WATER_FEES like", value, "waterFees");
			return (Criteria) this;
		}

		public Criteria andWaterFeesNotLike(String value) {
			addCriterion("WATER_FEES not like", value, "waterFees");
			return (Criteria) this;
		}

		public Criteria andWaterFeesIn(List<String> values) {
			addCriterion("WATER_FEES in", values, "waterFees");
			return (Criteria) this;
		}

		public Criteria andWaterFeesNotIn(List<String> values) {
			addCriterion("WATER_FEES not in", values, "waterFees");
			return (Criteria) this;
		}

		public Criteria andWaterFeesBetween(String value1, String value2) {
			addCriterion("WATER_FEES between", value1, value2, "waterFees");
			return (Criteria) this;
		}

		public Criteria andWaterFeesNotBetween(String value1, String value2) {
			addCriterion("WATER_FEES not between", value1, value2, "waterFees");
			return (Criteria) this;
		}

		public Criteria andNaturalGasFeesIsNull() {
			addCriterion("NATURAL_GAS_FEES is null");
			return (Criteria) this;
		}

		public Criteria andNaturalGasFeesIsNotNull() {
			addCriterion("NATURAL_GAS_FEES is not null");
			return (Criteria) this;
		}

		public Criteria andNaturalGasFeesEqualTo(String value) {
			addCriterion("NATURAL_GAS_FEES =", value, "naturalGasFees");
			return (Criteria) this;
		}

		public Criteria andNaturalGasFeesNotEqualTo(String value) {
			addCriterion("NATURAL_GAS_FEES <>", value, "naturalGasFees");
			return (Criteria) this;
		}

		public Criteria andNaturalGasFeesGreaterThan(String value) {
			addCriterion("NATURAL_GAS_FEES >", value, "naturalGasFees");
			return (Criteria) this;
		}

		public Criteria andNaturalGasFeesGreaterThanOrEqualTo(String value) {
			addCriterion("NATURAL_GAS_FEES >=", value, "naturalGasFees");
			return (Criteria) this;
		}

		public Criteria andNaturalGasFeesLessThan(String value) {
			addCriterion("NATURAL_GAS_FEES <", value, "naturalGasFees");
			return (Criteria) this;
		}

		public Criteria andNaturalGasFeesLessThanOrEqualTo(String value) {
			addCriterion("NATURAL_GAS_FEES <=", value, "naturalGasFees");
			return (Criteria) this;
		}

		public Criteria andNaturalGasFeesLike(String value) {
			addCriterion("NATURAL_GAS_FEES like", value, "naturalGasFees");
			return (Criteria) this;
		}

		public Criteria andNaturalGasFeesNotLike(String value) {
			addCriterion("NATURAL_GAS_FEES not like", value, "naturalGasFees");
			return (Criteria) this;
		}

		public Criteria andNaturalGasFeesIn(List<String> values) {
			addCriterion("NATURAL_GAS_FEES in", values, "naturalGasFees");
			return (Criteria) this;
		}

		public Criteria andNaturalGasFeesNotIn(List<String> values) {
			addCriterion("NATURAL_GAS_FEES not in", values, "naturalGasFees");
			return (Criteria) this;
		}

		public Criteria andNaturalGasFeesBetween(String value1, String value2) {
			addCriterion("NATURAL_GAS_FEES between", value1, value2, "naturalGasFees");
			return (Criteria) this;
		}

		public Criteria andNaturalGasFeesNotBetween(String value1, String value2) {
			addCriterion("NATURAL_GAS_FEES not between", value1, value2, "naturalGasFees");
			return (Criteria) this;
		}

		public Criteria andHeatingFeesIsNull() {
			addCriterion("HEATING_FEES is null");
			return (Criteria) this;
		}

		public Criteria andHeatingFeesIsNotNull() {
			addCriterion("HEATING_FEES is not null");
			return (Criteria) this;
		}

		public Criteria andHeatingFeesEqualTo(String value) {
			addCriterion("HEATING_FEES =", value, "heatingFees");
			return (Criteria) this;
		}

		public Criteria andHeatingFeesNotEqualTo(String value) {
			addCriterion("HEATING_FEES <>", value, "heatingFees");
			return (Criteria) this;
		}

		public Criteria andHeatingFeesGreaterThan(String value) {
			addCriterion("HEATING_FEES >", value, "heatingFees");
			return (Criteria) this;
		}

		public Criteria andHeatingFeesGreaterThanOrEqualTo(String value) {
			addCriterion("HEATING_FEES >=", value, "heatingFees");
			return (Criteria) this;
		}

		public Criteria andHeatingFeesLessThan(String value) {
			addCriterion("HEATING_FEES <", value, "heatingFees");
			return (Criteria) this;
		}

		public Criteria andHeatingFeesLessThanOrEqualTo(String value) {
			addCriterion("HEATING_FEES <=", value, "heatingFees");
			return (Criteria) this;
		}

		public Criteria andHeatingFeesLike(String value) {
			addCriterion("HEATING_FEES like", value, "heatingFees");
			return (Criteria) this;
		}

		public Criteria andHeatingFeesNotLike(String value) {
			addCriterion("HEATING_FEES not like", value, "heatingFees");
			return (Criteria) this;
		}

		public Criteria andHeatingFeesIn(List<String> values) {
			addCriterion("HEATING_FEES in", values, "heatingFees");
			return (Criteria) this;
		}

		public Criteria andHeatingFeesNotIn(List<String> values) {
			addCriterion("HEATING_FEES not in", values, "heatingFees");
			return (Criteria) this;
		}

		public Criteria andHeatingFeesBetween(String value1, String value2) {
			addCriterion("HEATING_FEES between", value1, value2, "heatingFees");
			return (Criteria) this;
		}

		public Criteria andHeatingFeesNotBetween(String value1, String value2) {
			addCriterion("HEATING_FEES not between", value1, value2, "heatingFees");
			return (Criteria) this;
		}

		public Criteria andXiaoquPyIsNull() {
			addCriterion("XIAOQU_PY is null");
			return (Criteria) this;
		}

		public Criteria andXiaoquPyIsNotNull() {
			addCriterion("XIAOQU_PY is not null");
			return (Criteria) this;
		}

		public Criteria andXiaoquPyEqualTo(String value) {
			addCriterion("XIAOQU_PY =", value, "xiaoquPy");
			return (Criteria) this;
		}

		public Criteria andXiaoquPyNotEqualTo(String value) {
			addCriterion("XIAOQU_PY <>", value, "xiaoquPy");
			return (Criteria) this;
		}

		public Criteria andXiaoquPyGreaterThan(String value) {
			addCriterion("XIAOQU_PY >", value, "xiaoquPy");
			return (Criteria) this;
		}

		public Criteria andXiaoquPyGreaterThanOrEqualTo(String value) {
			addCriterion("XIAOQU_PY >=", value, "xiaoquPy");
			return (Criteria) this;
		}

		public Criteria andXiaoquPyLessThan(String value) {
			addCriterion("XIAOQU_PY <", value, "xiaoquPy");
			return (Criteria) this;
		}

		public Criteria andXiaoquPyLessThanOrEqualTo(String value) {
			addCriterion("XIAOQU_PY <=", value, "xiaoquPy");
			return (Criteria) this;
		}

		public Criteria andXiaoquPyLike(String value) {
			addCriterion("XIAOQU_PY like", value, "xiaoquPy");
			return (Criteria) this;
		}

		public Criteria andXiaoquPyNotLike(String value) {
			addCriterion("XIAOQU_PY not like", value, "xiaoquPy");
			return (Criteria) this;
		}

		public Criteria andXiaoquPyIn(List<String> values) {
			addCriterion("XIAOQU_PY in", values, "xiaoquPy");
			return (Criteria) this;
		}

		public Criteria andXiaoquPyNotIn(List<String> values) {
			addCriterion("XIAOQU_PY not in", values, "xiaoquPy");
			return (Criteria) this;
		}

		public Criteria andXiaoquPyBetween(String value1, String value2) {
			addCriterion("XIAOQU_PY between", value1, value2, "xiaoquPy");
			return (Criteria) this;
		}

		public Criteria andXiaoquPyNotBetween(String value1, String value2) {
			addCriterion("XIAOQU_PY not between", value1, value2, "xiaoquPy");
			return (Criteria) this;
		}

		public Criteria andOccupancyRateIsNull() {
			addCriterion("OCCUPANCY_RATE is null");
			return (Criteria) this;
		}

		public Criteria andOccupancyRateIsNotNull() {
			addCriterion("OCCUPANCY_RATE is not null");
			return (Criteria) this;
		}

		public Criteria andOccupancyRateEqualTo(String value) {
			addCriterion("OCCUPANCY_RATE =", value, "occupancyRate");
			return (Criteria) this;
		}

		public Criteria andOccupancyRateNotEqualTo(String value) {
			addCriterion("OCCUPANCY_RATE <>", value, "occupancyRate");
			return (Criteria) this;
		}

		public Criteria andOccupancyRateGreaterThan(String value) {
			addCriterion("OCCUPANCY_RATE >", value, "occupancyRate");
			return (Criteria) this;
		}

		public Criteria andOccupancyRateGreaterThanOrEqualTo(String value) {
			addCriterion("OCCUPANCY_RATE >=", value, "occupancyRate");
			return (Criteria) this;
		}

		public Criteria andOccupancyRateLessThan(String value) {
			addCriterion("OCCUPANCY_RATE <", value, "occupancyRate");
			return (Criteria) this;
		}

		public Criteria andOccupancyRateLessThanOrEqualTo(String value) {
			addCriterion("OCCUPANCY_RATE <=", value, "occupancyRate");
			return (Criteria) this;
		}

		public Criteria andOccupancyRateLike(String value) {
			addCriterion("OCCUPANCY_RATE like", value, "occupancyRate");
			return (Criteria) this;
		}

		public Criteria andOccupancyRateNotLike(String value) {
			addCriterion("OCCUPANCY_RATE not like", value, "occupancyRate");
			return (Criteria) this;
		}

		public Criteria andOccupancyRateIn(List<String> values) {
			addCriterion("OCCUPANCY_RATE in", values, "occupancyRate");
			return (Criteria) this;
		}

		public Criteria andOccupancyRateNotIn(List<String> values) {
			addCriterion("OCCUPANCY_RATE not in", values, "occupancyRate");
			return (Criteria) this;
		}

		public Criteria andOccupancyRateBetween(String value1, String value2) {
			addCriterion("OCCUPANCY_RATE between", value1, value2, "occupancyRate");
			return (Criteria) this;
		}

		public Criteria andOccupancyRateNotBetween(String value1, String value2) {
			addCriterion("OCCUPANCY_RATE not between", value1, value2, "occupancyRate");
			return (Criteria) this;
		}

		public Criteria andTrafficIsNull() {
			addCriterion("TRAFFIC is null");
			return (Criteria) this;
		}

		public Criteria andTrafficIsNotNull() {
			addCriterion("TRAFFIC is not null");
			return (Criteria) this;
		}

		public Criteria andTrafficEqualTo(String value) {
			addCriterion("TRAFFIC =", value, "traffic");
			return (Criteria) this;
		}

		public Criteria andTrafficNotEqualTo(String value) {
			addCriterion("TRAFFIC <>", value, "traffic");
			return (Criteria) this;
		}

		public Criteria andTrafficGreaterThan(String value) {
			addCriterion("TRAFFIC >", value, "traffic");
			return (Criteria) this;
		}

		public Criteria andTrafficGreaterThanOrEqualTo(String value) {
			addCriterion("TRAFFIC >=", value, "traffic");
			return (Criteria) this;
		}

		public Criteria andTrafficLessThan(String value) {
			addCriterion("TRAFFIC <", value, "traffic");
			return (Criteria) this;
		}

		public Criteria andTrafficLessThanOrEqualTo(String value) {
			addCriterion("TRAFFIC <=", value, "traffic");
			return (Criteria) this;
		}

		public Criteria andTrafficLike(String value) {
			addCriterion("TRAFFIC like", value, "traffic");
			return (Criteria) this;
		}

		public Criteria andTrafficNotLike(String value) {
			addCriterion("TRAFFIC not like", value, "traffic");
			return (Criteria) this;
		}

		public Criteria andTrafficIn(List<String> values) {
			addCriterion("TRAFFIC in", values, "traffic");
			return (Criteria) this;
		}

		public Criteria andTrafficNotIn(List<String> values) {
			addCriterion("TRAFFIC not in", values, "traffic");
			return (Criteria) this;
		}

		public Criteria andTrafficBetween(String value1, String value2) {
			addCriterion("TRAFFIC between", value1, value2, "traffic");
			return (Criteria) this;
		}

		public Criteria andTrafficNotBetween(String value1, String value2) {
			addCriterion("TRAFFIC not between", value1, value2, "traffic");
			return (Criteria) this;
		}

		public Criteria andRoofsIsNull() {
			addCriterion("ROOFS is null");
			return (Criteria) this;
		}

		public Criteria andRoofsIsNotNull() {
			addCriterion("ROOFS is not null");
			return (Criteria) this;
		}

		public Criteria andRoofsEqualTo(Integer value) {
			addCriterion("ROOFS =", value, "roofs");
			return (Criteria) this;
		}

		public Criteria andRoofsNotEqualTo(Integer value) {
			addCriterion("ROOFS <>", value, "roofs");
			return (Criteria) this;
		}

		public Criteria andRoofsGreaterThan(Integer value) {
			addCriterion("ROOFS >", value, "roofs");
			return (Criteria) this;
		}

		public Criteria andRoofsGreaterThanOrEqualTo(Integer value) {
			addCriterion("ROOFS >=", value, "roofs");
			return (Criteria) this;
		}

		public Criteria andRoofsLessThan(Integer value) {
			addCriterion("ROOFS <", value, "roofs");
			return (Criteria) this;
		}

		public Criteria andRoofsLessThanOrEqualTo(Integer value) {
			addCriterion("ROOFS <=", value, "roofs");
			return (Criteria) this;
		}

		public Criteria andRoofsIn(List<Integer> values) {
			addCriterion("ROOFS in", values, "roofs");
			return (Criteria) this;
		}

		public Criteria andRoofsNotIn(List<Integer> values) {
			addCriterion("ROOFS not in", values, "roofs");
			return (Criteria) this;
		}

		public Criteria andRoofsBetween(Integer value1, Integer value2) {
			addCriterion("ROOFS between", value1, value2, "roofs");
			return (Criteria) this;
		}

		public Criteria andRoofsNotBetween(Integer value1, Integer value2) {
			addCriterion("ROOFS not between", value1, value2, "roofs");
			return (Criteria) this;
		}

		public Criteria andTemplateCompIdIsNull() {
			addCriterion("TEMPLATE_COMP_ID is null");
			return (Criteria) this;
		}

		public Criteria andTemplateCompIdIsNotNull() {
			addCriterion("TEMPLATE_COMP_ID is not null");
			return (Criteria) this;
		}

		public Criteria andTemplateCompIdEqualTo(Integer value) {
			addCriterion("TEMPLATE_COMP_ID =", value, "templateCompId");
			return (Criteria) this;
		}

		public Criteria andTemplateCompIdNotEqualTo(Integer value) {
			addCriterion("TEMPLATE_COMP_ID <>", value, "templateCompId");
			return (Criteria) this;
		}

		public Criteria andTemplateCompIdGreaterThan(Integer value) {
			addCriterion("TEMPLATE_COMP_ID >", value, "templateCompId");
			return (Criteria) this;
		}

		public Criteria andTemplateCompIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("TEMPLATE_COMP_ID >=", value, "templateCompId");
			return (Criteria) this;
		}

		public Criteria andTemplateCompIdLessThan(Integer value) {
			addCriterion("TEMPLATE_COMP_ID <", value, "templateCompId");
			return (Criteria) this;
		}

		public Criteria andTemplateCompIdLessThanOrEqualTo(Integer value) {
			addCriterion("TEMPLATE_COMP_ID <=", value, "templateCompId");
			return (Criteria) this;
		}

		public Criteria andTemplateCompIdIn(List<Integer> values) {
			addCriterion("TEMPLATE_COMP_ID in", values, "templateCompId");
			return (Criteria) this;
		}

		public Criteria andTemplateCompIdNotIn(List<Integer> values) {
			addCriterion("TEMPLATE_COMP_ID not in", values, "templateCompId");
			return (Criteria) this;
		}

		public Criteria andTemplateCompIdBetween(Integer value1, Integer value2) {
			addCriterion("TEMPLATE_COMP_ID between", value1, value2, "templateCompId");
			return (Criteria) this;
		}

		public Criteria andTemplateCompIdNotBetween(Integer value1, Integer value2) {
			addCriterion("TEMPLATE_COMP_ID not between", value1, value2, "templateCompId");
			return (Criteria) this;
		}

		public Criteria andHeadPicUrlIsNull() {
			addCriterion("HEAD_PIC_URL is null");
			return (Criteria) this;
		}

		public Criteria andHeadPicUrlIsNotNull() {
			addCriterion("HEAD_PIC_URL is not null");
			return (Criteria) this;
		}

		public Criteria andHeadPicUrlEqualTo(String value) {
			addCriterion("HEAD_PIC_URL =", value, "headPicUrl");
			return (Criteria) this;
		}

		public Criteria andHeadPicUrlNotEqualTo(String value) {
			addCriterion("HEAD_PIC_URL <>", value, "headPicUrl");
			return (Criteria) this;
		}

		public Criteria andHeadPicUrlGreaterThan(String value) {
			addCriterion("HEAD_PIC_URL >", value, "headPicUrl");
			return (Criteria) this;
		}

		public Criteria andHeadPicUrlGreaterThanOrEqualTo(String value) {
			addCriterion("HEAD_PIC_URL >=", value, "headPicUrl");
			return (Criteria) this;
		}

		public Criteria andHeadPicUrlLessThan(String value) {
			addCriterion("HEAD_PIC_URL <", value, "headPicUrl");
			return (Criteria) this;
		}

		public Criteria andHeadPicUrlLessThanOrEqualTo(String value) {
			addCriterion("HEAD_PIC_URL <=", value, "headPicUrl");
			return (Criteria) this;
		}

		public Criteria andHeadPicUrlLike(String value) {
			addCriterion("HEAD_PIC_URL like", value, "headPicUrl");
			return (Criteria) this;
		}

		public Criteria andHeadPicUrlNotLike(String value) {
			addCriterion("HEAD_PIC_URL not like", value, "headPicUrl");
			return (Criteria) this;
		}

		public Criteria andHeadPicUrlIn(List<String> values) {
			addCriterion("HEAD_PIC_URL in", values, "headPicUrl");
			return (Criteria) this;
		}

		public Criteria andHeadPicUrlNotIn(List<String> values) {
			addCriterion("HEAD_PIC_URL not in", values, "headPicUrl");
			return (Criteria) this;
		}

		public Criteria andHeadPicUrlBetween(String value1, String value2) {
			addCriterion("HEAD_PIC_URL between", value1, value2, "headPicUrl");
			return (Criteria) this;
		}

		public Criteria andHeadPicUrlNotBetween(String value1, String value2) {
			addCriterion("HEAD_PIC_URL not between", value1, value2, "headPicUrl");
			return (Criteria) this;
		}

		public Criteria andPromotionNameIsNull() {
			addCriterion("PROMOTION_NAME is null");
			return (Criteria) this;
		}

		public Criteria andPromotionNameIsNotNull() {
			addCriterion("PROMOTION_NAME is not null");
			return (Criteria) this;
		}

		public Criteria andPromotionNameEqualTo(String value) {
			addCriterion("PROMOTION_NAME =", value, "promotionName");
			return (Criteria) this;
		}

		public Criteria andPromotionNameNotEqualTo(String value) {
			addCriterion("PROMOTION_NAME <>", value, "promotionName");
			return (Criteria) this;
		}

		public Criteria andPromotionNameGreaterThan(String value) {
			addCriterion("PROMOTION_NAME >", value, "promotionName");
			return (Criteria) this;
		}

		public Criteria andPromotionNameGreaterThanOrEqualTo(String value) {
			addCriterion("PROMOTION_NAME >=", value, "promotionName");
			return (Criteria) this;
		}

		public Criteria andPromotionNameLessThan(String value) {
			addCriterion("PROMOTION_NAME <", value, "promotionName");
			return (Criteria) this;
		}

		public Criteria andPromotionNameLessThanOrEqualTo(String value) {
			addCriterion("PROMOTION_NAME <=", value, "promotionName");
			return (Criteria) this;
		}

		public Criteria andPromotionNameLike(String value) {
			addCriterion("PROMOTION_NAME like", value, "promotionName");
			return (Criteria) this;
		}

		public Criteria andPromotionNameNotLike(String value) {
			addCriterion("PROMOTION_NAME not like", value, "promotionName");
			return (Criteria) this;
		}

		public Criteria andPromotionNameIn(List<String> values) {
			addCriterion("PROMOTION_NAME in", values, "promotionName");
			return (Criteria) this;
		}

		public Criteria andPromotionNameNotIn(List<String> values) {
			addCriterion("PROMOTION_NAME not in", values, "promotionName");
			return (Criteria) this;
		}

		public Criteria andPromotionNameBetween(String value1, String value2) {
			addCriterion("PROMOTION_NAME between", value1, value2, "promotionName");
			return (Criteria) this;
		}

		public Criteria andPromotionNameNotBetween(String value1, String value2) {
			addCriterion("PROMOTION_NAME not between", value1, value2, "promotionName");
			return (Criteria) this;
		}

		public Criteria andBuildingUseageIsNull() {
			addCriterion("BUILDING_USEAGE is null");
			return (Criteria) this;
		}

		public Criteria andBuildingUseageIsNotNull() {
			addCriterion("BUILDING_USEAGE is not null");
			return (Criteria) this;
		}

		public Criteria andBuildingUseageEqualTo(String value) {
			addCriterion("BUILDING_USEAGE =", value, "buildingUseage");
			return (Criteria) this;
		}

		public Criteria andBuildingUseageNotEqualTo(String value) {
			addCriterion("BUILDING_USEAGE <>", value, "buildingUseage");
			return (Criteria) this;
		}

		public Criteria andBuildingUseageGreaterThan(String value) {
			addCriterion("BUILDING_USEAGE >", value, "buildingUseage");
			return (Criteria) this;
		}

		public Criteria andBuildingUseageGreaterThanOrEqualTo(String value) {
			addCriterion("BUILDING_USEAGE >=", value, "buildingUseage");
			return (Criteria) this;
		}

		public Criteria andBuildingUseageLessThan(String value) {
			addCriterion("BUILDING_USEAGE <", value, "buildingUseage");
			return (Criteria) this;
		}

		public Criteria andBuildingUseageLessThanOrEqualTo(String value) {
			addCriterion("BUILDING_USEAGE <=", value, "buildingUseage");
			return (Criteria) this;
		}

		public Criteria andBuildingUseageLike(String value) {
			addCriterion("BUILDING_USEAGE like", value, "buildingUseage");
			return (Criteria) this;
		}

		public Criteria andBuildingUseageNotLike(String value) {
			addCriterion("BUILDING_USEAGE not like", value, "buildingUseage");
			return (Criteria) this;
		}

		public Criteria andBuildingUseageIn(List<String> values) {
			addCriterion("BUILDING_USEAGE in", values, "buildingUseage");
			return (Criteria) this;
		}

		public Criteria andBuildingUseageNotIn(List<String> values) {
			addCriterion("BUILDING_USEAGE not in", values, "buildingUseage");
			return (Criteria) this;
		}

		public Criteria andBuildingUseageBetween(String value1, String value2) {
			addCriterion("BUILDING_USEAGE between", value1, value2, "buildingUseage");
			return (Criteria) this;
		}

		public Criteria andBuildingUseageNotBetween(String value1, String value2) {
			addCriterion("BUILDING_USEAGE not between", value1, value2, "buildingUseage");
			return (Criteria) this;
		}

		public Criteria andMlOuterWallIsNull() {
			addCriterion("ML_OUTER_WALL is null");
			return (Criteria) this;
		}

		public Criteria andMlOuterWallIsNotNull() {
			addCriterion("ML_OUTER_WALL is not null");
			return (Criteria) this;
		}

		public Criteria andMlOuterWallEqualTo(Byte value) {
			addCriterion("ML_OUTER_WALL =", value, "mlOuterWall");
			return (Criteria) this;
		}

		public Criteria andMlOuterWallNotEqualTo(Byte value) {
			addCriterion("ML_OUTER_WALL <>", value, "mlOuterWall");
			return (Criteria) this;
		}

		public Criteria andMlOuterWallGreaterThan(Byte value) {
			addCriterion("ML_OUTER_WALL >", value, "mlOuterWall");
			return (Criteria) this;
		}

		public Criteria andMlOuterWallGreaterThanOrEqualTo(Byte value) {
			addCriterion("ML_OUTER_WALL >=", value, "mlOuterWall");
			return (Criteria) this;
		}

		public Criteria andMlOuterWallLessThan(Byte value) {
			addCriterion("ML_OUTER_WALL <", value, "mlOuterWall");
			return (Criteria) this;
		}

		public Criteria andMlOuterWallLessThanOrEqualTo(Byte value) {
			addCriterion("ML_OUTER_WALL <=", value, "mlOuterWall");
			return (Criteria) this;
		}

		public Criteria andMlOuterWallIn(List<Byte> values) {
			addCriterion("ML_OUTER_WALL in", values, "mlOuterWall");
			return (Criteria) this;
		}

		public Criteria andMlOuterWallNotIn(List<Byte> values) {
			addCriterion("ML_OUTER_WALL not in", values, "mlOuterWall");
			return (Criteria) this;
		}

		public Criteria andMlOuterWallBetween(Byte value1, Byte value2) {
			addCriterion("ML_OUTER_WALL between", value1, value2, "mlOuterWall");
			return (Criteria) this;
		}

		public Criteria andMlOuterWallNotBetween(Byte value1, Byte value2) {
			addCriterion("ML_OUTER_WALL not between", value1, value2, "mlOuterWall");
			return (Criteria) this;
		}

		public Criteria andMlHouseStructureIsNull() {
			addCriterion("ML_HOUSE_STRUCTURE is null");
			return (Criteria) this;
		}

		public Criteria andMlHouseStructureIsNotNull() {
			addCriterion("ML_HOUSE_STRUCTURE is not null");
			return (Criteria) this;
		}

		public Criteria andMlHouseStructureEqualTo(Byte value) {
			addCriterion("ML_HOUSE_STRUCTURE =", value, "mlHouseStructure");
			return (Criteria) this;
		}

		public Criteria andMlHouseStructureNotEqualTo(Byte value) {
			addCriterion("ML_HOUSE_STRUCTURE <>", value, "mlHouseStructure");
			return (Criteria) this;
		}

		public Criteria andMlHouseStructureGreaterThan(Byte value) {
			addCriterion("ML_HOUSE_STRUCTURE >", value, "mlHouseStructure");
			return (Criteria) this;
		}

		public Criteria andMlHouseStructureGreaterThanOrEqualTo(Byte value) {
			addCriterion("ML_HOUSE_STRUCTURE >=", value, "mlHouseStructure");
			return (Criteria) this;
		}

		public Criteria andMlHouseStructureLessThan(Byte value) {
			addCriterion("ML_HOUSE_STRUCTURE <", value, "mlHouseStructure");
			return (Criteria) this;
		}

		public Criteria andMlHouseStructureLessThanOrEqualTo(Byte value) {
			addCriterion("ML_HOUSE_STRUCTURE <=", value, "mlHouseStructure");
			return (Criteria) this;
		}

		public Criteria andMlHouseStructureIn(List<Byte> values) {
			addCriterion("ML_HOUSE_STRUCTURE in", values, "mlHouseStructure");
			return (Criteria) this;
		}

		public Criteria andMlHouseStructureNotIn(List<Byte> values) {
			addCriterion("ML_HOUSE_STRUCTURE not in", values, "mlHouseStructure");
			return (Criteria) this;
		}

		public Criteria andMlHouseStructureBetween(Byte value1, Byte value2) {
			addCriterion("ML_HOUSE_STRUCTURE between", value1, value2, "mlHouseStructure");
			return (Criteria) this;
		}

		public Criteria andMlHouseStructureNotBetween(Byte value1, Byte value2) {
			addCriterion("ML_HOUSE_STRUCTURE not between", value1, value2, "mlHouseStructure");
			return (Criteria) this;
		}

		public Criteria andMlSchooleNearbyHouseIsNull() {
			addCriterion("ML_SCHOOLE_NEARBY_HOUSE is null");
			return (Criteria) this;
		}

		public Criteria andMlSchooleNearbyHouseIsNotNull() {
			addCriterion("ML_SCHOOLE_NEARBY_HOUSE is not null");
			return (Criteria) this;
		}

		public Criteria andMlSchooleNearbyHouseEqualTo(Byte value) {
			addCriterion("ML_SCHOOLE_NEARBY_HOUSE =", value, "mlSchooleNearbyHouse");
			return (Criteria) this;
		}

		public Criteria andMlSchooleNearbyHouseNotEqualTo(Byte value) {
			addCriterion("ML_SCHOOLE_NEARBY_HOUSE <>", value, "mlSchooleNearbyHouse");
			return (Criteria) this;
		}

		public Criteria andMlSchooleNearbyHouseGreaterThan(Byte value) {
			addCriterion("ML_SCHOOLE_NEARBY_HOUSE >", value, "mlSchooleNearbyHouse");
			return (Criteria) this;
		}

		public Criteria andMlSchooleNearbyHouseGreaterThanOrEqualTo(Byte value) {
			addCriterion("ML_SCHOOLE_NEARBY_HOUSE >=", value, "mlSchooleNearbyHouse");
			return (Criteria) this;
		}

		public Criteria andMlSchooleNearbyHouseLessThan(Byte value) {
			addCriterion("ML_SCHOOLE_NEARBY_HOUSE <", value, "mlSchooleNearbyHouse");
			return (Criteria) this;
		}

		public Criteria andMlSchooleNearbyHouseLessThanOrEqualTo(Byte value) {
			addCriterion("ML_SCHOOLE_NEARBY_HOUSE <=", value, "mlSchooleNearbyHouse");
			return (Criteria) this;
		}

		public Criteria andMlSchooleNearbyHouseIn(List<Byte> values) {
			addCriterion("ML_SCHOOLE_NEARBY_HOUSE in", values, "mlSchooleNearbyHouse");
			return (Criteria) this;
		}

		public Criteria andMlSchooleNearbyHouseNotIn(List<Byte> values) {
			addCriterion("ML_SCHOOLE_NEARBY_HOUSE not in", values, "mlSchooleNearbyHouse");
			return (Criteria) this;
		}

		public Criteria andMlSchooleNearbyHouseBetween(Byte value1, Byte value2) {
			addCriterion("ML_SCHOOLE_NEARBY_HOUSE between", value1, value2, "mlSchooleNearbyHouse");
			return (Criteria) this;
		}

		public Criteria andMlSchooleNearbyHouseNotBetween(Byte value1, Byte value2) {
			addCriterion("ML_SCHOOLE_NEARBY_HOUSE not between", value1, value2, "mlSchooleNearbyHouse");
			return (Criteria) this;
		}

		public Criteria andMlIndoorParkingSpaceIsNull() {
			addCriterion("ML_INDOOR_PARKING_SPACE is null");
			return (Criteria) this;
		}

		public Criteria andMlIndoorParkingSpaceIsNotNull() {
			addCriterion("ML_INDOOR_PARKING_SPACE is not null");
			return (Criteria) this;
		}

		public Criteria andMlIndoorParkingSpaceEqualTo(String value) {
			addCriterion("ML_INDOOR_PARKING_SPACE =", value, "mlIndoorParkingSpace");
			return (Criteria) this;
		}

		public Criteria andMlIndoorParkingSpaceNotEqualTo(String value) {
			addCriterion("ML_INDOOR_PARKING_SPACE <>", value, "mlIndoorParkingSpace");
			return (Criteria) this;
		}

		public Criteria andMlIndoorParkingSpaceGreaterThan(String value) {
			addCriterion("ML_INDOOR_PARKING_SPACE >", value, "mlIndoorParkingSpace");
			return (Criteria) this;
		}

		public Criteria andMlIndoorParkingSpaceGreaterThanOrEqualTo(String value) {
			addCriterion("ML_INDOOR_PARKING_SPACE >=", value, "mlIndoorParkingSpace");
			return (Criteria) this;
		}

		public Criteria andMlIndoorParkingSpaceLessThan(String value) {
			addCriterion("ML_INDOOR_PARKING_SPACE <", value, "mlIndoorParkingSpace");
			return (Criteria) this;
		}

		public Criteria andMlIndoorParkingSpaceLessThanOrEqualTo(String value) {
			addCriterion("ML_INDOOR_PARKING_SPACE <=", value, "mlIndoorParkingSpace");
			return (Criteria) this;
		}

		public Criteria andMlIndoorParkingSpaceLike(String value) {
			addCriterion("ML_INDOOR_PARKING_SPACE like", value, "mlIndoorParkingSpace");
			return (Criteria) this;
		}

		public Criteria andMlIndoorParkingSpaceNotLike(String value) {
			addCriterion("ML_INDOOR_PARKING_SPACE not like", value, "mlIndoorParkingSpace");
			return (Criteria) this;
		}

		public Criteria andMlIndoorParkingSpaceIn(List<String> values) {
			addCriterion("ML_INDOOR_PARKING_SPACE in", values, "mlIndoorParkingSpace");
			return (Criteria) this;
		}

		public Criteria andMlIndoorParkingSpaceNotIn(List<String> values) {
			addCriterion("ML_INDOOR_PARKING_SPACE not in", values, "mlIndoorParkingSpace");
			return (Criteria) this;
		}

		public Criteria andMlIndoorParkingSpaceBetween(String value1, String value2) {
			addCriterion("ML_INDOOR_PARKING_SPACE between", value1, value2, "mlIndoorParkingSpace");
			return (Criteria) this;
		}

		public Criteria andMlIndoorParkingSpaceNotBetween(String value1, String value2) {
			addCriterion("ML_INDOOR_PARKING_SPACE not between", value1, value2, "mlIndoorParkingSpace");
			return (Criteria) this;
		}

		public Criteria andMlOutdoorParkingSpaceIsNull() {
			addCriterion("ML_OUTDOOR_PARKING_SPACE is null");
			return (Criteria) this;
		}

		public Criteria andMlOutdoorParkingSpaceIsNotNull() {
			addCriterion("ML_OUTDOOR_PARKING_SPACE is not null");
			return (Criteria) this;
		}

		public Criteria andMlOutdoorParkingSpaceEqualTo(String value) {
			addCriterion("ML_OUTDOOR_PARKING_SPACE =", value, "mlOutdoorParkingSpace");
			return (Criteria) this;
		}

		public Criteria andMlOutdoorParkingSpaceNotEqualTo(String value) {
			addCriterion("ML_OUTDOOR_PARKING_SPACE <>", value, "mlOutdoorParkingSpace");
			return (Criteria) this;
		}

		public Criteria andMlOutdoorParkingSpaceGreaterThan(String value) {
			addCriterion("ML_OUTDOOR_PARKING_SPACE >", value, "mlOutdoorParkingSpace");
			return (Criteria) this;
		}

		public Criteria andMlOutdoorParkingSpaceGreaterThanOrEqualTo(String value) {
			addCriterion("ML_OUTDOOR_PARKING_SPACE >=", value, "mlOutdoorParkingSpace");
			return (Criteria) this;
		}

		public Criteria andMlOutdoorParkingSpaceLessThan(String value) {
			addCriterion("ML_OUTDOOR_PARKING_SPACE <", value, "mlOutdoorParkingSpace");
			return (Criteria) this;
		}

		public Criteria andMlOutdoorParkingSpaceLessThanOrEqualTo(String value) {
			addCriterion("ML_OUTDOOR_PARKING_SPACE <=", value, "mlOutdoorParkingSpace");
			return (Criteria) this;
		}

		public Criteria andMlOutdoorParkingSpaceLike(String value) {
			addCriterion("ML_OUTDOOR_PARKING_SPACE like", value, "mlOutdoorParkingSpace");
			return (Criteria) this;
		}

		public Criteria andMlOutdoorParkingSpaceNotLike(String value) {
			addCriterion("ML_OUTDOOR_PARKING_SPACE not like", value, "mlOutdoorParkingSpace");
			return (Criteria) this;
		}

		public Criteria andMlOutdoorParkingSpaceIn(List<String> values) {
			addCriterion("ML_OUTDOOR_PARKING_SPACE in", values, "mlOutdoorParkingSpace");
			return (Criteria) this;
		}

		public Criteria andMlOutdoorParkingSpaceNotIn(List<String> values) {
			addCriterion("ML_OUTDOOR_PARKING_SPACE not in", values, "mlOutdoorParkingSpace");
			return (Criteria) this;
		}

		public Criteria andMlOutdoorParkingSpaceBetween(String value1, String value2) {
			addCriterion("ML_OUTDOOR_PARKING_SPACE between", value1, value2, "mlOutdoorParkingSpace");
			return (Criteria) this;
		}

		public Criteria andMlOutdoorParkingSpaceNotBetween(String value1, String value2) {
			addCriterion("ML_OUTDOOR_PARKING_SPACE not between", value1, value2, "mlOutdoorParkingSpace");
			return (Criteria) this;
		}

		public Criteria andMlIndoorParkingChargeIsNull() {
			addCriterion("ML_INDOOR_PARKING_CHARGE is null");
			return (Criteria) this;
		}

		public Criteria andMlIndoorParkingChargeIsNotNull() {
			addCriterion("ML_INDOOR_PARKING_CHARGE is not null");
			return (Criteria) this;
		}

		public Criteria andMlIndoorParkingChargeEqualTo(String value) {
			addCriterion("ML_INDOOR_PARKING_CHARGE =", value, "mlIndoorParkingCharge");
			return (Criteria) this;
		}

		public Criteria andMlIndoorParkingChargeNotEqualTo(String value) {
			addCriterion("ML_INDOOR_PARKING_CHARGE <>", value, "mlIndoorParkingCharge");
			return (Criteria) this;
		}

		public Criteria andMlIndoorParkingChargeGreaterThan(String value) {
			addCriterion("ML_INDOOR_PARKING_CHARGE >", value, "mlIndoorParkingCharge");
			return (Criteria) this;
		}

		public Criteria andMlIndoorParkingChargeGreaterThanOrEqualTo(String value) {
			addCriterion("ML_INDOOR_PARKING_CHARGE >=", value, "mlIndoorParkingCharge");
			return (Criteria) this;
		}

		public Criteria andMlIndoorParkingChargeLessThan(String value) {
			addCriterion("ML_INDOOR_PARKING_CHARGE <", value, "mlIndoorParkingCharge");
			return (Criteria) this;
		}

		public Criteria andMlIndoorParkingChargeLessThanOrEqualTo(String value) {
			addCriterion("ML_INDOOR_PARKING_CHARGE <=", value, "mlIndoorParkingCharge");
			return (Criteria) this;
		}

		public Criteria andMlIndoorParkingChargeLike(String value) {
			addCriterion("ML_INDOOR_PARKING_CHARGE like", value, "mlIndoorParkingCharge");
			return (Criteria) this;
		}

		public Criteria andMlIndoorParkingChargeNotLike(String value) {
			addCriterion("ML_INDOOR_PARKING_CHARGE not like", value, "mlIndoorParkingCharge");
			return (Criteria) this;
		}

		public Criteria andMlIndoorParkingChargeIn(List<String> values) {
			addCriterion("ML_INDOOR_PARKING_CHARGE in", values, "mlIndoorParkingCharge");
			return (Criteria) this;
		}

		public Criteria andMlIndoorParkingChargeNotIn(List<String> values) {
			addCriterion("ML_INDOOR_PARKING_CHARGE not in", values, "mlIndoorParkingCharge");
			return (Criteria) this;
		}

		public Criteria andMlIndoorParkingChargeBetween(String value1, String value2) {
			addCriterion("ML_INDOOR_PARKING_CHARGE between", value1, value2, "mlIndoorParkingCharge");
			return (Criteria) this;
		}

		public Criteria andMlIndoorParkingChargeNotBetween(String value1, String value2) {
			addCriterion("ML_INDOOR_PARKING_CHARGE not between", value1, value2, "mlIndoorParkingCharge");
			return (Criteria) this;
		}

		public Criteria andMlOutdoorParkingChargeIsNull() {
			addCriterion("ML_OUTDOOR_PARKING_CHARGE is null");
			return (Criteria) this;
		}

		public Criteria andMlOutdoorParkingChargeIsNotNull() {
			addCriterion("ML_OUTDOOR_PARKING_CHARGE is not null");
			return (Criteria) this;
		}

		public Criteria andMlOutdoorParkingChargeEqualTo(String value) {
			addCriterion("ML_OUTDOOR_PARKING_CHARGE =", value, "mlOutdoorParkingCharge");
			return (Criteria) this;
		}

		public Criteria andMlOutdoorParkingChargeNotEqualTo(String value) {
			addCriterion("ML_OUTDOOR_PARKING_CHARGE <>", value, "mlOutdoorParkingCharge");
			return (Criteria) this;
		}

		public Criteria andMlOutdoorParkingChargeGreaterThan(String value) {
			addCriterion("ML_OUTDOOR_PARKING_CHARGE >", value, "mlOutdoorParkingCharge");
			return (Criteria) this;
		}

		public Criteria andMlOutdoorParkingChargeGreaterThanOrEqualTo(String value) {
			addCriterion("ML_OUTDOOR_PARKING_CHARGE >=", value, "mlOutdoorParkingCharge");
			return (Criteria) this;
		}

		public Criteria andMlOutdoorParkingChargeLessThan(String value) {
			addCriterion("ML_OUTDOOR_PARKING_CHARGE <", value, "mlOutdoorParkingCharge");
			return (Criteria) this;
		}

		public Criteria andMlOutdoorParkingChargeLessThanOrEqualTo(String value) {
			addCriterion("ML_OUTDOOR_PARKING_CHARGE <=", value, "mlOutdoorParkingCharge");
			return (Criteria) this;
		}

		public Criteria andMlOutdoorParkingChargeLike(String value) {
			addCriterion("ML_OUTDOOR_PARKING_CHARGE like", value, "mlOutdoorParkingCharge");
			return (Criteria) this;
		}

		public Criteria andMlOutdoorParkingChargeNotLike(String value) {
			addCriterion("ML_OUTDOOR_PARKING_CHARGE not like", value, "mlOutdoorParkingCharge");
			return (Criteria) this;
		}

		public Criteria andMlOutdoorParkingChargeIn(List<String> values) {
			addCriterion("ML_OUTDOOR_PARKING_CHARGE in", values, "mlOutdoorParkingCharge");
			return (Criteria) this;
		}

		public Criteria andMlOutdoorParkingChargeNotIn(List<String> values) {
			addCriterion("ML_OUTDOOR_PARKING_CHARGE not in", values, "mlOutdoorParkingCharge");
			return (Criteria) this;
		}

		public Criteria andMlOutdoorParkingChargeBetween(String value1, String value2) {
			addCriterion("ML_OUTDOOR_PARKING_CHARGE between", value1, value2, "mlOutdoorParkingCharge");
			return (Criteria) this;
		}

		public Criteria andMlOutdoorParkingChargeNotBetween(String value1, String value2) {
			addCriterion("ML_OUTDOOR_PARKING_CHARGE not between", value1, value2, "mlOutdoorParkingCharge");
			return (Criteria) this;
		}

		public Criteria andMlBelongToStreetIsNull() {
			addCriterion("ML_BELONG_TO_STREET is null");
			return (Criteria) this;
		}

		public Criteria andMlBelongToStreetIsNotNull() {
			addCriterion("ML_BELONG_TO_STREET is not null");
			return (Criteria) this;
		}

		public Criteria andMlBelongToStreetEqualTo(String value) {
			addCriterion("ML_BELONG_TO_STREET =", value, "mlBelongToStreet");
			return (Criteria) this;
		}

		public Criteria andMlBelongToStreetNotEqualTo(String value) {
			addCriterion("ML_BELONG_TO_STREET <>", value, "mlBelongToStreet");
			return (Criteria) this;
		}

		public Criteria andMlBelongToStreetGreaterThan(String value) {
			addCriterion("ML_BELONG_TO_STREET >", value, "mlBelongToStreet");
			return (Criteria) this;
		}

		public Criteria andMlBelongToStreetGreaterThanOrEqualTo(String value) {
			addCriterion("ML_BELONG_TO_STREET >=", value, "mlBelongToStreet");
			return (Criteria) this;
		}

		public Criteria andMlBelongToStreetLessThan(String value) {
			addCriterion("ML_BELONG_TO_STREET <", value, "mlBelongToStreet");
			return (Criteria) this;
		}

		public Criteria andMlBelongToStreetLessThanOrEqualTo(String value) {
			addCriterion("ML_BELONG_TO_STREET <=", value, "mlBelongToStreet");
			return (Criteria) this;
		}

		public Criteria andMlBelongToStreetLike(String value) {
			addCriterion("ML_BELONG_TO_STREET like", value, "mlBelongToStreet");
			return (Criteria) this;
		}

		public Criteria andMlBelongToStreetNotLike(String value) {
			addCriterion("ML_BELONG_TO_STREET not like", value, "mlBelongToStreet");
			return (Criteria) this;
		}

		public Criteria andMlBelongToStreetIn(List<String> values) {
			addCriterion("ML_BELONG_TO_STREET in", values, "mlBelongToStreet");
			return (Criteria) this;
		}

		public Criteria andMlBelongToStreetNotIn(List<String> values) {
			addCriterion("ML_BELONG_TO_STREET not in", values, "mlBelongToStreet");
			return (Criteria) this;
		}

		public Criteria andMlBelongToStreetBetween(String value1, String value2) {
			addCriterion("ML_BELONG_TO_STREET between", value1, value2, "mlBelongToStreet");
			return (Criteria) this;
		}

		public Criteria andMlBelongToStreetNotBetween(String value1, String value2) {
			addCriterion("ML_BELONG_TO_STREET not between", value1, value2, "mlBelongToStreet");
			return (Criteria) this;
		}

		public Criteria andMlPropertyTypeIsNull() {
			addCriterion("ML_PROPERTY_TYPE is null");
			return (Criteria) this;
		}

		public Criteria andMlPropertyTypeIsNotNull() {
			addCriterion("ML_PROPERTY_TYPE is not null");
			return (Criteria) this;
		}

		public Criteria andMlPropertyTypeEqualTo(String value) {
			addCriterion("ML_PROPERTY_TYPE =", value, "mlPropertyType");
			return (Criteria) this;
		}

		public Criteria andMlPropertyTypeNotEqualTo(String value) {
			addCriterion("ML_PROPERTY_TYPE <>", value, "mlPropertyType");
			return (Criteria) this;
		}

		public Criteria andMlPropertyTypeGreaterThan(String value) {
			addCriterion("ML_PROPERTY_TYPE >", value, "mlPropertyType");
			return (Criteria) this;
		}

		public Criteria andMlPropertyTypeGreaterThanOrEqualTo(String value) {
			addCriterion("ML_PROPERTY_TYPE >=", value, "mlPropertyType");
			return (Criteria) this;
		}

		public Criteria andMlPropertyTypeLessThan(String value) {
			addCriterion("ML_PROPERTY_TYPE <", value, "mlPropertyType");
			return (Criteria) this;
		}

		public Criteria andMlPropertyTypeLessThanOrEqualTo(String value) {
			addCriterion("ML_PROPERTY_TYPE <=", value, "mlPropertyType");
			return (Criteria) this;
		}

		public Criteria andMlPropertyTypeLike(String value) {
			addCriterion("ML_PROPERTY_TYPE like", value, "mlPropertyType");
			return (Criteria) this;
		}

		public Criteria andMlPropertyTypeNotLike(String value) {
			addCriterion("ML_PROPERTY_TYPE not like", value, "mlPropertyType");
			return (Criteria) this;
		}

		public Criteria andMlPropertyTypeIn(List<String> values) {
			addCriterion("ML_PROPERTY_TYPE in", values, "mlPropertyType");
			return (Criteria) this;
		}

		public Criteria andMlPropertyTypeNotIn(List<String> values) {
			addCriterion("ML_PROPERTY_TYPE not in", values, "mlPropertyType");
			return (Criteria) this;
		}

		public Criteria andMlPropertyTypeBetween(String value1, String value2) {
			addCriterion("ML_PROPERTY_TYPE between", value1, value2, "mlPropertyType");
			return (Criteria) this;
		}

		public Criteria andMlPropertyTypeNotBetween(String value1, String value2) {
			addCriterion("ML_PROPERTY_TYPE not between", value1, value2, "mlPropertyType");
			return (Criteria) this;
		}

		public Criteria andMlTenementTypeIsNull() {
			addCriterion("ML_TENEMENT_TYPE is null");
			return (Criteria) this;
		}

		public Criteria andMlTenementTypeIsNotNull() {
			addCriterion("ML_TENEMENT_TYPE is not null");
			return (Criteria) this;
		}

		public Criteria andMlTenementTypeEqualTo(Byte value) {
			addCriterion("ML_TENEMENT_TYPE =", value, "mlTenementType");
			return (Criteria) this;
		}

		public Criteria andMlTenementTypeNotEqualTo(Byte value) {
			addCriterion("ML_TENEMENT_TYPE <>", value, "mlTenementType");
			return (Criteria) this;
		}

		public Criteria andMlTenementTypeGreaterThan(Byte value) {
			addCriterion("ML_TENEMENT_TYPE >", value, "mlTenementType");
			return (Criteria) this;
		}

		public Criteria andMlTenementTypeGreaterThanOrEqualTo(Byte value) {
			addCriterion("ML_TENEMENT_TYPE >=", value, "mlTenementType");
			return (Criteria) this;
		}

		public Criteria andMlTenementTypeLessThan(Byte value) {
			addCriterion("ML_TENEMENT_TYPE <", value, "mlTenementType");
			return (Criteria) this;
		}

		public Criteria andMlTenementTypeLessThanOrEqualTo(Byte value) {
			addCriterion("ML_TENEMENT_TYPE <=", value, "mlTenementType");
			return (Criteria) this;
		}

		public Criteria andMlTenementTypeIn(List<Byte> values) {
			addCriterion("ML_TENEMENT_TYPE in", values, "mlTenementType");
			return (Criteria) this;
		}

		public Criteria andMlTenementTypeNotIn(List<Byte> values) {
			addCriterion("ML_TENEMENT_TYPE not in", values, "mlTenementType");
			return (Criteria) this;
		}

		public Criteria andMlTenementTypeBetween(Byte value1, Byte value2) {
			addCriterion("ML_TENEMENT_TYPE between", value1, value2, "mlTenementType");
			return (Criteria) this;
		}

		public Criteria andMlTenementTypeNotBetween(Byte value1, Byte value2) {
			addCriterion("ML_TENEMENT_TYPE not between", value1, value2, "mlTenementType");
			return (Criteria) this;
		}

		public Criteria andMlRatifyLandDateIsNull() {
			addCriterion("ML_RATIFY_LAND_DATE is null");
			return (Criteria) this;
		}

		public Criteria andMlRatifyLandDateIsNotNull() {
			addCriterion("ML_RATIFY_LAND_DATE is not null");
			return (Criteria) this;
		}

		public Criteria andMlRatifyLandDateEqualTo(Date value) {
			addCriterion("ML_RATIFY_LAND_DATE =", value, "mlRatifyLandDate");
			return (Criteria) this;
		}

		public Criteria andMlRatifyLandDateNotEqualTo(Date value) {
			addCriterion("ML_RATIFY_LAND_DATE <>", value, "mlRatifyLandDate");
			return (Criteria) this;
		}

		public Criteria andMlRatifyLandDateGreaterThan(Date value) {
			addCriterion("ML_RATIFY_LAND_DATE >", value, "mlRatifyLandDate");
			return (Criteria) this;
		}

		public Criteria andMlRatifyLandDateGreaterThanOrEqualTo(Date value) {
			addCriterion("ML_RATIFY_LAND_DATE >=", value, "mlRatifyLandDate");
			return (Criteria) this;
		}

		public Criteria andMlRatifyLandDateLessThan(Date value) {
			addCriterion("ML_RATIFY_LAND_DATE <", value, "mlRatifyLandDate");
			return (Criteria) this;
		}

		public Criteria andMlRatifyLandDateLessThanOrEqualTo(Date value) {
			addCriterion("ML_RATIFY_LAND_DATE <=", value, "mlRatifyLandDate");
			return (Criteria) this;
		}

		public Criteria andMlRatifyLandDateIn(List<Date> values) {
			addCriterion("ML_RATIFY_LAND_DATE in", values, "mlRatifyLandDate");
			return (Criteria) this;
		}

		public Criteria andMlRatifyLandDateNotIn(List<Date> values) {
			addCriterion("ML_RATIFY_LAND_DATE not in", values, "mlRatifyLandDate");
			return (Criteria) this;
		}

		public Criteria andMlRatifyLandDateBetween(Date value1, Date value2) {
			addCriterion("ML_RATIFY_LAND_DATE between", value1, value2, "mlRatifyLandDate");
			return (Criteria) this;
		}

		public Criteria andMlRatifyLandDateNotBetween(Date value1, Date value2) {
			addCriterion("ML_RATIFY_LAND_DATE not between", value1, value2, "mlRatifyLandDate");
			return (Criteria) this;
		}

		public Criteria andMlJoinDateIsNull() {
			addCriterion("ML_JOIN_DATE is null");
			return (Criteria) this;
		}

		public Criteria andMlJoinDateIsNotNull() {
			addCriterion("ML_JOIN_DATE is not null");
			return (Criteria) this;
		}

		public Criteria andMlJoinDateEqualTo(Date value) {
			addCriterion("ML_JOIN_DATE =", value, "mlJoinDate");
			return (Criteria) this;
		}

		public Criteria andMlJoinDateNotEqualTo(Date value) {
			addCriterion("ML_JOIN_DATE <>", value, "mlJoinDate");
			return (Criteria) this;
		}

		public Criteria andMlJoinDateGreaterThan(Date value) {
			addCriterion("ML_JOIN_DATE >", value, "mlJoinDate");
			return (Criteria) this;
		}

		public Criteria andMlJoinDateGreaterThanOrEqualTo(Date value) {
			addCriterion("ML_JOIN_DATE >=", value, "mlJoinDate");
			return (Criteria) this;
		}

		public Criteria andMlJoinDateLessThan(Date value) {
			addCriterion("ML_JOIN_DATE <", value, "mlJoinDate");
			return (Criteria) this;
		}

		public Criteria andMlJoinDateLessThanOrEqualTo(Date value) {
			addCriterion("ML_JOIN_DATE <=", value, "mlJoinDate");
			return (Criteria) this;
		}

		public Criteria andMlJoinDateIn(List<Date> values) {
			addCriterion("ML_JOIN_DATE in", values, "mlJoinDate");
			return (Criteria) this;
		}

		public Criteria andMlJoinDateNotIn(List<Date> values) {
			addCriterion("ML_JOIN_DATE not in", values, "mlJoinDate");
			return (Criteria) this;
		}

		public Criteria andMlJoinDateBetween(Date value1, Date value2) {
			addCriterion("ML_JOIN_DATE between", value1, value2, "mlJoinDate");
			return (Criteria) this;
		}

		public Criteria andMlJoinDateNotBetween(Date value1, Date value2) {
			addCriterion("ML_JOIN_DATE not between", value1, value2, "mlJoinDate");
			return (Criteria) this;
		}

		public Criteria andMlUseStartDateIsNull() {
			addCriterion("ML_USE_START_DATE is null");
			return (Criteria) this;
		}

		public Criteria andMlUseStartDateIsNotNull() {
			addCriterion("ML_USE_START_DATE is not null");
			return (Criteria) this;
		}

		public Criteria andMlUseStartDateEqualTo(Date value) {
			addCriterion("ML_USE_START_DATE =", value, "mlUseStartDate");
			return (Criteria) this;
		}

		public Criteria andMlUseStartDateNotEqualTo(Date value) {
			addCriterion("ML_USE_START_DATE <>", value, "mlUseStartDate");
			return (Criteria) this;
		}

		public Criteria andMlUseStartDateGreaterThan(Date value) {
			addCriterion("ML_USE_START_DATE >", value, "mlUseStartDate");
			return (Criteria) this;
		}

		public Criteria andMlUseStartDateGreaterThanOrEqualTo(Date value) {
			addCriterion("ML_USE_START_DATE >=", value, "mlUseStartDate");
			return (Criteria) this;
		}

		public Criteria andMlUseStartDateLessThan(Date value) {
			addCriterion("ML_USE_START_DATE <", value, "mlUseStartDate");
			return (Criteria) this;
		}

		public Criteria andMlUseStartDateLessThanOrEqualTo(Date value) {
			addCriterion("ML_USE_START_DATE <=", value, "mlUseStartDate");
			return (Criteria) this;
		}

		public Criteria andMlUseStartDateIn(List<Date> values) {
			addCriterion("ML_USE_START_DATE in", values, "mlUseStartDate");
			return (Criteria) this;
		}

		public Criteria andMlUseStartDateNotIn(List<Date> values) {
			addCriterion("ML_USE_START_DATE not in", values, "mlUseStartDate");
			return (Criteria) this;
		}

		public Criteria andMlUseStartDateBetween(Date value1, Date value2) {
			addCriterion("ML_USE_START_DATE between", value1, value2, "mlUseStartDate");
			return (Criteria) this;
		}

		public Criteria andMlUseStartDateNotBetween(Date value1, Date value2) {
			addCriterion("ML_USE_START_DATE not between", value1, value2, "mlUseStartDate");
			return (Criteria) this;
		}

		public Criteria andMlUserEndDateIsNull() {
			addCriterion("ML_USER_END_DATE is null");
			return (Criteria) this;
		}

		public Criteria andMlUserEndDateIsNotNull() {
			addCriterion("ML_USER_END_DATE is not null");
			return (Criteria) this;
		}

		public Criteria andMlUserEndDateEqualTo(Date value) {
			addCriterion("ML_USER_END_DATE =", value, "mlUserEndDate");
			return (Criteria) this;
		}

		public Criteria andMlUserEndDateNotEqualTo(Date value) {
			addCriterion("ML_USER_END_DATE <>", value, "mlUserEndDate");
			return (Criteria) this;
		}

		public Criteria andMlUserEndDateGreaterThan(Date value) {
			addCriterion("ML_USER_END_DATE >", value, "mlUserEndDate");
			return (Criteria) this;
		}

		public Criteria andMlUserEndDateGreaterThanOrEqualTo(Date value) {
			addCriterion("ML_USER_END_DATE >=", value, "mlUserEndDate");
			return (Criteria) this;
		}

		public Criteria andMlUserEndDateLessThan(Date value) {
			addCriterion("ML_USER_END_DATE <", value, "mlUserEndDate");
			return (Criteria) this;
		}

		public Criteria andMlUserEndDateLessThanOrEqualTo(Date value) {
			addCriterion("ML_USER_END_DATE <=", value, "mlUserEndDate");
			return (Criteria) this;
		}

		public Criteria andMlUserEndDateIn(List<Date> values) {
			addCriterion("ML_USER_END_DATE in", values, "mlUserEndDate");
			return (Criteria) this;
		}

		public Criteria andMlUserEndDateNotIn(List<Date> values) {
			addCriterion("ML_USER_END_DATE not in", values, "mlUserEndDate");
			return (Criteria) this;
		}

		public Criteria andMlUserEndDateBetween(Date value1, Date value2) {
			addCriterion("ML_USER_END_DATE between", value1, value2, "mlUserEndDate");
			return (Criteria) this;
		}

		public Criteria andMlUserEndDateNotBetween(Date value1, Date value2) {
			addCriterion("ML_USER_END_DATE not between", value1, value2, "mlUserEndDate");
			return (Criteria) this;
		}

		public Criteria andMlzsParkingRateIsNull() {
			addCriterion("MLZS_PARKING_RATE is null");
			return (Criteria) this;
		}

		public Criteria andMlzsParkingRateIsNotNull() {
			addCriterion("MLZS_PARKING_RATE is not null");
			return (Criteria) this;
		}

		public Criteria andMlzsParkingRateEqualTo(String value) {
			addCriterion("MLZS_PARKING_RATE =", value, "mlzsParkingRate");
			return (Criteria) this;
		}

		public Criteria andMlzsParkingRateNotEqualTo(String value) {
			addCriterion("MLZS_PARKING_RATE <>", value, "mlzsParkingRate");
			return (Criteria) this;
		}

		public Criteria andMlzsParkingRateGreaterThan(String value) {
			addCriterion("MLZS_PARKING_RATE >", value, "mlzsParkingRate");
			return (Criteria) this;
		}

		public Criteria andMlzsParkingRateGreaterThanOrEqualTo(String value) {
			addCriterion("MLZS_PARKING_RATE >=", value, "mlzsParkingRate");
			return (Criteria) this;
		}

		public Criteria andMlzsParkingRateLessThan(String value) {
			addCriterion("MLZS_PARKING_RATE <", value, "mlzsParkingRate");
			return (Criteria) this;
		}

		public Criteria andMlzsParkingRateLessThanOrEqualTo(String value) {
			addCriterion("MLZS_PARKING_RATE <=", value, "mlzsParkingRate");
			return (Criteria) this;
		}

		public Criteria andMlzsParkingRateLike(String value) {
			addCriterion("MLZS_PARKING_RATE like", value, "mlzsParkingRate");
			return (Criteria) this;
		}

		public Criteria andMlzsParkingRateNotLike(String value) {
			addCriterion("MLZS_PARKING_RATE not like", value, "mlzsParkingRate");
			return (Criteria) this;
		}

		public Criteria andMlzsParkingRateIn(List<String> values) {
			addCriterion("MLZS_PARKING_RATE in", values, "mlzsParkingRate");
			return (Criteria) this;
		}

		public Criteria andMlzsParkingRateNotIn(List<String> values) {
			addCriterion("MLZS_PARKING_RATE not in", values, "mlzsParkingRate");
			return (Criteria) this;
		}

		public Criteria andMlzsParkingRateBetween(String value1, String value2) {
			addCriterion("MLZS_PARKING_RATE between", value1, value2, "mlzsParkingRate");
			return (Criteria) this;
		}

		public Criteria andMlzsParkingRateNotBetween(String value1, String value2) {
			addCriterion("MLZS_PARKING_RATE not between", value1, value2, "mlzsParkingRate");
			return (Criteria) this;
		}

		public Criteria andMlzsCompletionDateIsNull() {
			addCriterion("MLZS_COMPLETION_DATE is null");
			return (Criteria) this;
		}

		public Criteria andMlzsCompletionDateIsNotNull() {
			addCriterion("MLZS_COMPLETION_DATE is not null");
			return (Criteria) this;
		}

		public Criteria andMlzsCompletionDateEqualTo(Date value) {
			addCriterion("MLZS_COMPLETION_DATE =", value, "mlzsCompletionDate");
			return (Criteria) this;
		}

		public Criteria andMlzsCompletionDateNotEqualTo(Date value) {
			addCriterion("MLZS_COMPLETION_DATE <>", value, "mlzsCompletionDate");
			return (Criteria) this;
		}

		public Criteria andMlzsCompletionDateGreaterThan(Date value) {
			addCriterion("MLZS_COMPLETION_DATE >", value, "mlzsCompletionDate");
			return (Criteria) this;
		}

		public Criteria andMlzsCompletionDateGreaterThanOrEqualTo(Date value) {
			addCriterion("MLZS_COMPLETION_DATE >=", value, "mlzsCompletionDate");
			return (Criteria) this;
		}

		public Criteria andMlzsCompletionDateLessThan(Date value) {
			addCriterion("MLZS_COMPLETION_DATE <", value, "mlzsCompletionDate");
			return (Criteria) this;
		}

		public Criteria andMlzsCompletionDateLessThanOrEqualTo(Date value) {
			addCriterion("MLZS_COMPLETION_DATE <=", value, "mlzsCompletionDate");
			return (Criteria) this;
		}

		public Criteria andMlzsCompletionDateIn(List<Date> values) {
			addCriterion("MLZS_COMPLETION_DATE in", values, "mlzsCompletionDate");
			return (Criteria) this;
		}

		public Criteria andMlzsCompletionDateNotIn(List<Date> values) {
			addCriterion("MLZS_COMPLETION_DATE not in", values, "mlzsCompletionDate");
			return (Criteria) this;
		}

		public Criteria andMlzsCompletionDateBetween(Date value1, Date value2) {
			addCriterion("MLZS_COMPLETION_DATE between", value1, value2, "mlzsCompletionDate");
			return (Criteria) this;
		}

		public Criteria andMlzsCompletionDateNotBetween(Date value1, Date value2) {
			addCriterion("MLZS_COMPLETION_DATE not between", value1, value2, "mlzsCompletionDate");
			return (Criteria) this;
		}

		public Criteria andMlzsSubwabNumberIsNull() {
			addCriterion("MLZS_SUBWAB_NUMBER is null");
			return (Criteria) this;
		}

		public Criteria andMlzsSubwabNumberIsNotNull() {
			addCriterion("MLZS_SUBWAB_NUMBER is not null");
			return (Criteria) this;
		}

		public Criteria andMlzsSubwabNumberEqualTo(String value) {
			addCriterion("MLZS_SUBWAB_NUMBER =", value, "mlzsSubwabNumber");
			return (Criteria) this;
		}

		public Criteria andMlzsSubwabNumberNotEqualTo(String value) {
			addCriterion("MLZS_SUBWAB_NUMBER <>", value, "mlzsSubwabNumber");
			return (Criteria) this;
		}

		public Criteria andMlzsSubwabNumberGreaterThan(String value) {
			addCriterion("MLZS_SUBWAB_NUMBER >", value, "mlzsSubwabNumber");
			return (Criteria) this;
		}

		public Criteria andMlzsSubwabNumberGreaterThanOrEqualTo(String value) {
			addCriterion("MLZS_SUBWAB_NUMBER >=", value, "mlzsSubwabNumber");
			return (Criteria) this;
		}

		public Criteria andMlzsSubwabNumberLessThan(String value) {
			addCriterion("MLZS_SUBWAB_NUMBER <", value, "mlzsSubwabNumber");
			return (Criteria) this;
		}

		public Criteria andMlzsSubwabNumberLessThanOrEqualTo(String value) {
			addCriterion("MLZS_SUBWAB_NUMBER <=", value, "mlzsSubwabNumber");
			return (Criteria) this;
		}

		public Criteria andMlzsSubwabNumberLike(String value) {
			addCriterion("MLZS_SUBWAB_NUMBER like", value, "mlzsSubwabNumber");
			return (Criteria) this;
		}

		public Criteria andMlzsSubwabNumberNotLike(String value) {
			addCriterion("MLZS_SUBWAB_NUMBER not like", value, "mlzsSubwabNumber");
			return (Criteria) this;
		}

		public Criteria andMlzsSubwabNumberIn(List<String> values) {
			addCriterion("MLZS_SUBWAB_NUMBER in", values, "mlzsSubwabNumber");
			return (Criteria) this;
		}

		public Criteria andMlzsSubwabNumberNotIn(List<String> values) {
			addCriterion("MLZS_SUBWAB_NUMBER not in", values, "mlzsSubwabNumber");
			return (Criteria) this;
		}

		public Criteria andMlzsSubwabNumberBetween(String value1, String value2) {
			addCriterion("MLZS_SUBWAB_NUMBER between", value1, value2, "mlzsSubwabNumber");
			return (Criteria) this;
		}

		public Criteria andMlzsSubwabNumberNotBetween(String value1, String value2) {
			addCriterion("MLZS_SUBWAB_NUMBER not between", value1, value2, "mlzsSubwabNumber");
			return (Criteria) this;
		}

		public Criteria andMlzsNearbyMainStreetIsNull() {
			addCriterion("MLZS_NEARBY_MAIN_STREET is null");
			return (Criteria) this;
		}

		public Criteria andMlzsNearbyMainStreetIsNotNull() {
			addCriterion("MLZS_NEARBY_MAIN_STREET is not null");
			return (Criteria) this;
		}

		public Criteria andMlzsNearbyMainStreetEqualTo(String value) {
			addCriterion("MLZS_NEARBY_MAIN_STREET =", value, "mlzsNearbyMainStreet");
			return (Criteria) this;
		}

		public Criteria andMlzsNearbyMainStreetNotEqualTo(String value) {
			addCriterion("MLZS_NEARBY_MAIN_STREET <>", value, "mlzsNearbyMainStreet");
			return (Criteria) this;
		}

		public Criteria andMlzsNearbyMainStreetGreaterThan(String value) {
			addCriterion("MLZS_NEARBY_MAIN_STREET >", value, "mlzsNearbyMainStreet");
			return (Criteria) this;
		}

		public Criteria andMlzsNearbyMainStreetGreaterThanOrEqualTo(String value) {
			addCriterion("MLZS_NEARBY_MAIN_STREET >=", value, "mlzsNearbyMainStreet");
			return (Criteria) this;
		}

		public Criteria andMlzsNearbyMainStreetLessThan(String value) {
			addCriterion("MLZS_NEARBY_MAIN_STREET <", value, "mlzsNearbyMainStreet");
			return (Criteria) this;
		}

		public Criteria andMlzsNearbyMainStreetLessThanOrEqualTo(String value) {
			addCriterion("MLZS_NEARBY_MAIN_STREET <=", value, "mlzsNearbyMainStreet");
			return (Criteria) this;
		}

		public Criteria andMlzsNearbyMainStreetLike(String value) {
			addCriterion("MLZS_NEARBY_MAIN_STREET like", value, "mlzsNearbyMainStreet");
			return (Criteria) this;
		}

		public Criteria andMlzsNearbyMainStreetNotLike(String value) {
			addCriterion("MLZS_NEARBY_MAIN_STREET not like", value, "mlzsNearbyMainStreet");
			return (Criteria) this;
		}

		public Criteria andMlzsNearbyMainStreetIn(List<String> values) {
			addCriterion("MLZS_NEARBY_MAIN_STREET in", values, "mlzsNearbyMainStreet");
			return (Criteria) this;
		}

		public Criteria andMlzsNearbyMainStreetNotIn(List<String> values) {
			addCriterion("MLZS_NEARBY_MAIN_STREET not in", values, "mlzsNearbyMainStreet");
			return (Criteria) this;
		}

		public Criteria andMlzsNearbyMainStreetBetween(String value1, String value2) {
			addCriterion("MLZS_NEARBY_MAIN_STREET between", value1, value2, "mlzsNearbyMainStreet");
			return (Criteria) this;
		}

		public Criteria andMlzsNearbyMainStreetNotBetween(String value1, String value2) {
			addCriterion("MLZS_NEARBY_MAIN_STREET not between", value1, value2, "mlzsNearbyMainStreet");
			return (Criteria) this;
		}

		public Criteria andMlzsBusNumberIsNull() {
			addCriterion("MLZS_BUS_NUMBER is null");
			return (Criteria) this;
		}

		public Criteria andMlzsBusNumberIsNotNull() {
			addCriterion("MLZS_BUS_NUMBER is not null");
			return (Criteria) this;
		}

		public Criteria andMlzsBusNumberEqualTo(String value) {
			addCriterion("MLZS_BUS_NUMBER =", value, "mlzsBusNumber");
			return (Criteria) this;
		}

		public Criteria andMlzsBusNumberNotEqualTo(String value) {
			addCriterion("MLZS_BUS_NUMBER <>", value, "mlzsBusNumber");
			return (Criteria) this;
		}

		public Criteria andMlzsBusNumberGreaterThan(String value) {
			addCriterion("MLZS_BUS_NUMBER >", value, "mlzsBusNumber");
			return (Criteria) this;
		}

		public Criteria andMlzsBusNumberGreaterThanOrEqualTo(String value) {
			addCriterion("MLZS_BUS_NUMBER >=", value, "mlzsBusNumber");
			return (Criteria) this;
		}

		public Criteria andMlzsBusNumberLessThan(String value) {
			addCriterion("MLZS_BUS_NUMBER <", value, "mlzsBusNumber");
			return (Criteria) this;
		}

		public Criteria andMlzsBusNumberLessThanOrEqualTo(String value) {
			addCriterion("MLZS_BUS_NUMBER <=", value, "mlzsBusNumber");
			return (Criteria) this;
		}

		public Criteria andMlzsBusNumberLike(String value) {
			addCriterion("MLZS_BUS_NUMBER like", value, "mlzsBusNumber");
			return (Criteria) this;
		}

		public Criteria andMlzsBusNumberNotLike(String value) {
			addCriterion("MLZS_BUS_NUMBER not like", value, "mlzsBusNumber");
			return (Criteria) this;
		}

		public Criteria andMlzsBusNumberIn(List<String> values) {
			addCriterion("MLZS_BUS_NUMBER in", values, "mlzsBusNumber");
			return (Criteria) this;
		}

		public Criteria andMlzsBusNumberNotIn(List<String> values) {
			addCriterion("MLZS_BUS_NUMBER not in", values, "mlzsBusNumber");
			return (Criteria) this;
		}

		public Criteria andMlzsBusNumberBetween(String value1, String value2) {
			addCriterion("MLZS_BUS_NUMBER between", value1, value2, "mlzsBusNumber");
			return (Criteria) this;
		}

		public Criteria andMlzsBusNumberNotBetween(String value1, String value2) {
			addCriterion("MLZS_BUS_NUMBER not between", value1, value2, "mlzsBusNumber");
			return (Criteria) this;
		}

		public Criteria andMlzsNearbyMountainIsNull() {
			addCriterion("MLZS_NEARBY_MOUNTAIN is null");
			return (Criteria) this;
		}

		public Criteria andMlzsNearbyMountainIsNotNull() {
			addCriterion("MLZS_NEARBY_MOUNTAIN is not null");
			return (Criteria) this;
		}

		public Criteria andMlzsNearbyMountainEqualTo(String value) {
			addCriterion("MLZS_NEARBY_MOUNTAIN =", value, "mlzsNearbyMountain");
			return (Criteria) this;
		}

		public Criteria andMlzsNearbyMountainNotEqualTo(String value) {
			addCriterion("MLZS_NEARBY_MOUNTAIN <>", value, "mlzsNearbyMountain");
			return (Criteria) this;
		}

		public Criteria andMlzsNearbyMountainGreaterThan(String value) {
			addCriterion("MLZS_NEARBY_MOUNTAIN >", value, "mlzsNearbyMountain");
			return (Criteria) this;
		}

		public Criteria andMlzsNearbyMountainGreaterThanOrEqualTo(String value) {
			addCriterion("MLZS_NEARBY_MOUNTAIN >=", value, "mlzsNearbyMountain");
			return (Criteria) this;
		}

		public Criteria andMlzsNearbyMountainLessThan(String value) {
			addCriterion("MLZS_NEARBY_MOUNTAIN <", value, "mlzsNearbyMountain");
			return (Criteria) this;
		}

		public Criteria andMlzsNearbyMountainLessThanOrEqualTo(String value) {
			addCriterion("MLZS_NEARBY_MOUNTAIN <=", value, "mlzsNearbyMountain");
			return (Criteria) this;
		}

		public Criteria andMlzsNearbyMountainLike(String value) {
			addCriterion("MLZS_NEARBY_MOUNTAIN like", value, "mlzsNearbyMountain");
			return (Criteria) this;
		}

		public Criteria andMlzsNearbyMountainNotLike(String value) {
			addCriterion("MLZS_NEARBY_MOUNTAIN not like", value, "mlzsNearbyMountain");
			return (Criteria) this;
		}

		public Criteria andMlzsNearbyMountainIn(List<String> values) {
			addCriterion("MLZS_NEARBY_MOUNTAIN in", values, "mlzsNearbyMountain");
			return (Criteria) this;
		}

		public Criteria andMlzsNearbyMountainNotIn(List<String> values) {
			addCriterion("MLZS_NEARBY_MOUNTAIN not in", values, "mlzsNearbyMountain");
			return (Criteria) this;
		}

		public Criteria andMlzsNearbyMountainBetween(String value1, String value2) {
			addCriterion("MLZS_NEARBY_MOUNTAIN between", value1, value2, "mlzsNearbyMountain");
			return (Criteria) this;
		}

		public Criteria andMlzsNearbyMountainNotBetween(String value1, String value2) {
			addCriterion("MLZS_NEARBY_MOUNTAIN not between", value1, value2, "mlzsNearbyMountain");
			return (Criteria) this;
		}

		public Criteria andMlzsNearbyRiverOrSeaIsNull() {
			addCriterion("MLZS_NEARBY_RIVER_OR_SEA is null");
			return (Criteria) this;
		}

		public Criteria andMlzsNearbyRiverOrSeaIsNotNull() {
			addCriterion("MLZS_NEARBY_RIVER_OR_SEA is not null");
			return (Criteria) this;
		}

		public Criteria andMlzsNearbyRiverOrSeaEqualTo(String value) {
			addCriterion("MLZS_NEARBY_RIVER_OR_SEA =", value, "mlzsNearbyRiverOrSea");
			return (Criteria) this;
		}

		public Criteria andMlzsNearbyRiverOrSeaNotEqualTo(String value) {
			addCriterion("MLZS_NEARBY_RIVER_OR_SEA <>", value, "mlzsNearbyRiverOrSea");
			return (Criteria) this;
		}

		public Criteria andMlzsNearbyRiverOrSeaGreaterThan(String value) {
			addCriterion("MLZS_NEARBY_RIVER_OR_SEA >", value, "mlzsNearbyRiverOrSea");
			return (Criteria) this;
		}

		public Criteria andMlzsNearbyRiverOrSeaGreaterThanOrEqualTo(String value) {
			addCriterion("MLZS_NEARBY_RIVER_OR_SEA >=", value, "mlzsNearbyRiverOrSea");
			return (Criteria) this;
		}

		public Criteria andMlzsNearbyRiverOrSeaLessThan(String value) {
			addCriterion("MLZS_NEARBY_RIVER_OR_SEA <", value, "mlzsNearbyRiverOrSea");
			return (Criteria) this;
		}

		public Criteria andMlzsNearbyRiverOrSeaLessThanOrEqualTo(String value) {
			addCriterion("MLZS_NEARBY_RIVER_OR_SEA <=", value, "mlzsNearbyRiverOrSea");
			return (Criteria) this;
		}

		public Criteria andMlzsNearbyRiverOrSeaLike(String value) {
			addCriterion("MLZS_NEARBY_RIVER_OR_SEA like", value, "mlzsNearbyRiverOrSea");
			return (Criteria) this;
		}

		public Criteria andMlzsNearbyRiverOrSeaNotLike(String value) {
			addCriterion("MLZS_NEARBY_RIVER_OR_SEA not like", value, "mlzsNearbyRiverOrSea");
			return (Criteria) this;
		}

		public Criteria andMlzsNearbyRiverOrSeaIn(List<String> values) {
			addCriterion("MLZS_NEARBY_RIVER_OR_SEA in", values, "mlzsNearbyRiverOrSea");
			return (Criteria) this;
		}

		public Criteria andMlzsNearbyRiverOrSeaNotIn(List<String> values) {
			addCriterion("MLZS_NEARBY_RIVER_OR_SEA not in", values, "mlzsNearbyRiverOrSea");
			return (Criteria) this;
		}

		public Criteria andMlzsNearbyRiverOrSeaBetween(String value1, String value2) {
			addCriterion("MLZS_NEARBY_RIVER_OR_SEA between", value1, value2, "mlzsNearbyRiverOrSea");
			return (Criteria) this;
		}

		public Criteria andMlzsNearbyRiverOrSeaNotBetween(String value1, String value2) {
			addCriterion("MLZS_NEARBY_RIVER_OR_SEA not between", value1, value2, "mlzsNearbyRiverOrSea");
			return (Criteria) this;
		}

		public Criteria andMlzsRailTrafficIsNull() {
			addCriterion("MLZS_RAIL_TRAFFIC is null");
			return (Criteria) this;
		}

		public Criteria andMlzsRailTrafficIsNotNull() {
			addCriterion("MLZS_RAIL_TRAFFIC is not null");
			return (Criteria) this;
		}

		public Criteria andMlzsRailTrafficEqualTo(String value) {
			addCriterion("MLZS_RAIL_TRAFFIC =", value, "mlzsRailTraffic");
			return (Criteria) this;
		}

		public Criteria andMlzsRailTrafficNotEqualTo(String value) {
			addCriterion("MLZS_RAIL_TRAFFIC <>", value, "mlzsRailTraffic");
			return (Criteria) this;
		}

		public Criteria andMlzsRailTrafficGreaterThan(String value) {
			addCriterion("MLZS_RAIL_TRAFFIC >", value, "mlzsRailTraffic");
			return (Criteria) this;
		}

		public Criteria andMlzsRailTrafficGreaterThanOrEqualTo(String value) {
			addCriterion("MLZS_RAIL_TRAFFIC >=", value, "mlzsRailTraffic");
			return (Criteria) this;
		}

		public Criteria andMlzsRailTrafficLessThan(String value) {
			addCriterion("MLZS_RAIL_TRAFFIC <", value, "mlzsRailTraffic");
			return (Criteria) this;
		}

		public Criteria andMlzsRailTrafficLessThanOrEqualTo(String value) {
			addCriterion("MLZS_RAIL_TRAFFIC <=", value, "mlzsRailTraffic");
			return (Criteria) this;
		}

		public Criteria andMlzsRailTrafficLike(String value) {
			addCriterion("MLZS_RAIL_TRAFFIC like", value, "mlzsRailTraffic");
			return (Criteria) this;
		}

		public Criteria andMlzsRailTrafficNotLike(String value) {
			addCriterion("MLZS_RAIL_TRAFFIC not like", value, "mlzsRailTraffic");
			return (Criteria) this;
		}

		public Criteria andMlzsRailTrafficIn(List<String> values) {
			addCriterion("MLZS_RAIL_TRAFFIC in", values, "mlzsRailTraffic");
			return (Criteria) this;
		}

		public Criteria andMlzsRailTrafficNotIn(List<String> values) {
			addCriterion("MLZS_RAIL_TRAFFIC not in", values, "mlzsRailTraffic");
			return (Criteria) this;
		}

		public Criteria andMlzsRailTrafficBetween(String value1, String value2) {
			addCriterion("MLZS_RAIL_TRAFFIC between", value1, value2, "mlzsRailTraffic");
			return (Criteria) this;
		}

		public Criteria andMlzsRailTrafficNotBetween(String value1, String value2) {
			addCriterion("MLZS_RAIL_TRAFFIC not between", value1, value2, "mlzsRailTraffic");
			return (Criteria) this;
		}

		public Criteria andMlzsTopThreeHospitalNameIsNull() {
			addCriterion("MLZS_TOP_THREE_HOSPITAL_NAME is null");
			return (Criteria) this;
		}

		public Criteria andMlzsTopThreeHospitalNameIsNotNull() {
			addCriterion("MLZS_TOP_THREE_HOSPITAL_NAME is not null");
			return (Criteria) this;
		}

		public Criteria andMlzsTopThreeHospitalNameEqualTo(String value) {
			addCriterion("MLZS_TOP_THREE_HOSPITAL_NAME =", value, "mlzsTopThreeHospitalName");
			return (Criteria) this;
		}

		public Criteria andMlzsTopThreeHospitalNameNotEqualTo(String value) {
			addCriterion("MLZS_TOP_THREE_HOSPITAL_NAME <>", value, "mlzsTopThreeHospitalName");
			return (Criteria) this;
		}

		public Criteria andMlzsTopThreeHospitalNameGreaterThan(String value) {
			addCriterion("MLZS_TOP_THREE_HOSPITAL_NAME >", value, "mlzsTopThreeHospitalName");
			return (Criteria) this;
		}

		public Criteria andMlzsTopThreeHospitalNameGreaterThanOrEqualTo(String value) {
			addCriterion("MLZS_TOP_THREE_HOSPITAL_NAME >=", value, "mlzsTopThreeHospitalName");
			return (Criteria) this;
		}

		public Criteria andMlzsTopThreeHospitalNameLessThan(String value) {
			addCriterion("MLZS_TOP_THREE_HOSPITAL_NAME <", value, "mlzsTopThreeHospitalName");
			return (Criteria) this;
		}

		public Criteria andMlzsTopThreeHospitalNameLessThanOrEqualTo(String value) {
			addCriterion("MLZS_TOP_THREE_HOSPITAL_NAME <=", value, "mlzsTopThreeHospitalName");
			return (Criteria) this;
		}

		public Criteria andMlzsTopThreeHospitalNameLike(String value) {
			addCriterion("MLZS_TOP_THREE_HOSPITAL_NAME like", value, "mlzsTopThreeHospitalName");
			return (Criteria) this;
		}

		public Criteria andMlzsTopThreeHospitalNameNotLike(String value) {
			addCriterion("MLZS_TOP_THREE_HOSPITAL_NAME not like", value, "mlzsTopThreeHospitalName");
			return (Criteria) this;
		}

		public Criteria andMlzsTopThreeHospitalNameIn(List<String> values) {
			addCriterion("MLZS_TOP_THREE_HOSPITAL_NAME in", values, "mlzsTopThreeHospitalName");
			return (Criteria) this;
		}

		public Criteria andMlzsTopThreeHospitalNameNotIn(List<String> values) {
			addCriterion("MLZS_TOP_THREE_HOSPITAL_NAME not in", values, "mlzsTopThreeHospitalName");
			return (Criteria) this;
		}

		public Criteria andMlzsTopThreeHospitalNameBetween(String value1, String value2) {
			addCriterion("MLZS_TOP_THREE_HOSPITAL_NAME between", value1, value2, "mlzsTopThreeHospitalName");
			return (Criteria) this;
		}

		public Criteria andMlzsTopThreeHospitalNameNotBetween(String value1, String value2) {
			addCriterion("MLZS_TOP_THREE_HOSPITAL_NAME not between", value1, value2, "mlzsTopThreeHospitalName");
			return (Criteria) this;
		}

		public Criteria andMlzsGeneralHospitalNameIsNull() {
			addCriterion("MLZS_GENERAL_HOSPITAL_NAME is null");
			return (Criteria) this;
		}

		public Criteria andMlzsGeneralHospitalNameIsNotNull() {
			addCriterion("MLZS_GENERAL_HOSPITAL_NAME is not null");
			return (Criteria) this;
		}

		public Criteria andMlzsGeneralHospitalNameEqualTo(String value) {
			addCriterion("MLZS_GENERAL_HOSPITAL_NAME =", value, "mlzsGeneralHospitalName");
			return (Criteria) this;
		}

		public Criteria andMlzsGeneralHospitalNameNotEqualTo(String value) {
			addCriterion("MLZS_GENERAL_HOSPITAL_NAME <>", value, "mlzsGeneralHospitalName");
			return (Criteria) this;
		}

		public Criteria andMlzsGeneralHospitalNameGreaterThan(String value) {
			addCriterion("MLZS_GENERAL_HOSPITAL_NAME >", value, "mlzsGeneralHospitalName");
			return (Criteria) this;
		}

		public Criteria andMlzsGeneralHospitalNameGreaterThanOrEqualTo(String value) {
			addCriterion("MLZS_GENERAL_HOSPITAL_NAME >=", value, "mlzsGeneralHospitalName");
			return (Criteria) this;
		}

		public Criteria andMlzsGeneralHospitalNameLessThan(String value) {
			addCriterion("MLZS_GENERAL_HOSPITAL_NAME <", value, "mlzsGeneralHospitalName");
			return (Criteria) this;
		}

		public Criteria andMlzsGeneralHospitalNameLessThanOrEqualTo(String value) {
			addCriterion("MLZS_GENERAL_HOSPITAL_NAME <=", value, "mlzsGeneralHospitalName");
			return (Criteria) this;
		}

		public Criteria andMlzsGeneralHospitalNameLike(String value) {
			addCriterion("MLZS_GENERAL_HOSPITAL_NAME like", value, "mlzsGeneralHospitalName");
			return (Criteria) this;
		}

		public Criteria andMlzsGeneralHospitalNameNotLike(String value) {
			addCriterion("MLZS_GENERAL_HOSPITAL_NAME not like", value, "mlzsGeneralHospitalName");
			return (Criteria) this;
		}

		public Criteria andMlzsGeneralHospitalNameIn(List<String> values) {
			addCriterion("MLZS_GENERAL_HOSPITAL_NAME in", values, "mlzsGeneralHospitalName");
			return (Criteria) this;
		}

		public Criteria andMlzsGeneralHospitalNameNotIn(List<String> values) {
			addCriterion("MLZS_GENERAL_HOSPITAL_NAME not in", values, "mlzsGeneralHospitalName");
			return (Criteria) this;
		}

		public Criteria andMlzsGeneralHospitalNameBetween(String value1, String value2) {
			addCriterion("MLZS_GENERAL_HOSPITAL_NAME between", value1, value2, "mlzsGeneralHospitalName");
			return (Criteria) this;
		}

		public Criteria andMlzsGeneralHospitalNameNotBetween(String value1, String value2) {
			addCriterion("MLZS_GENERAL_HOSPITAL_NAME not between", value1, value2, "mlzsGeneralHospitalName");
			return (Criteria) this;
		}

		public Criteria andMlzsSocialHealthCenterIsNull() {
			addCriterion("MLZS_SOCIAL_HEALTH_CENTER is null");
			return (Criteria) this;
		}

		public Criteria andMlzsSocialHealthCenterIsNotNull() {
			addCriterion("MLZS_SOCIAL_HEALTH_CENTER is not null");
			return (Criteria) this;
		}

		public Criteria andMlzsSocialHealthCenterEqualTo(String value) {
			addCriterion("MLZS_SOCIAL_HEALTH_CENTER =", value, "mlzsSocialHealthCenter");
			return (Criteria) this;
		}

		public Criteria andMlzsSocialHealthCenterNotEqualTo(String value) {
			addCriterion("MLZS_SOCIAL_HEALTH_CENTER <>", value, "mlzsSocialHealthCenter");
			return (Criteria) this;
		}

		public Criteria andMlzsSocialHealthCenterGreaterThan(String value) {
			addCriterion("MLZS_SOCIAL_HEALTH_CENTER >", value, "mlzsSocialHealthCenter");
			return (Criteria) this;
		}

		public Criteria andMlzsSocialHealthCenterGreaterThanOrEqualTo(String value) {
			addCriterion("MLZS_SOCIAL_HEALTH_CENTER >=", value, "mlzsSocialHealthCenter");
			return (Criteria) this;
		}

		public Criteria andMlzsSocialHealthCenterLessThan(String value) {
			addCriterion("MLZS_SOCIAL_HEALTH_CENTER <", value, "mlzsSocialHealthCenter");
			return (Criteria) this;
		}

		public Criteria andMlzsSocialHealthCenterLessThanOrEqualTo(String value) {
			addCriterion("MLZS_SOCIAL_HEALTH_CENTER <=", value, "mlzsSocialHealthCenter");
			return (Criteria) this;
		}

		public Criteria andMlzsSocialHealthCenterLike(String value) {
			addCriterion("MLZS_SOCIAL_HEALTH_CENTER like", value, "mlzsSocialHealthCenter");
			return (Criteria) this;
		}

		public Criteria andMlzsSocialHealthCenterNotLike(String value) {
			addCriterion("MLZS_SOCIAL_HEALTH_CENTER not like", value, "mlzsSocialHealthCenter");
			return (Criteria) this;
		}

		public Criteria andMlzsSocialHealthCenterIn(List<String> values) {
			addCriterion("MLZS_SOCIAL_HEALTH_CENTER in", values, "mlzsSocialHealthCenter");
			return (Criteria) this;
		}

		public Criteria andMlzsSocialHealthCenterNotIn(List<String> values) {
			addCriterion("MLZS_SOCIAL_HEALTH_CENTER not in", values, "mlzsSocialHealthCenter");
			return (Criteria) this;
		}

		public Criteria andMlzsSocialHealthCenterBetween(String value1, String value2) {
			addCriterion("MLZS_SOCIAL_HEALTH_CENTER between", value1, value2, "mlzsSocialHealthCenter");
			return (Criteria) this;
		}

		public Criteria andMlzsSocialHealthCenterNotBetween(String value1, String value2) {
			addCriterion("MLZS_SOCIAL_HEALTH_CENTER not between", value1, value2, "mlzsSocialHealthCenter");
			return (Criteria) this;
		}

		public Criteria andMlzsNearbyParkIsNull() {
			addCriterion("MLZS_NEARBY_PARK is null");
			return (Criteria) this;
		}

		public Criteria andMlzsNearbyParkIsNotNull() {
			addCriterion("MLZS_NEARBY_PARK is not null");
			return (Criteria) this;
		}

		public Criteria andMlzsNearbyParkEqualTo(String value) {
			addCriterion("MLZS_NEARBY_PARK =", value, "mlzsNearbyPark");
			return (Criteria) this;
		}

		public Criteria andMlzsNearbyParkNotEqualTo(String value) {
			addCriterion("MLZS_NEARBY_PARK <>", value, "mlzsNearbyPark");
			return (Criteria) this;
		}

		public Criteria andMlzsNearbyParkGreaterThan(String value) {
			addCriterion("MLZS_NEARBY_PARK >", value, "mlzsNearbyPark");
			return (Criteria) this;
		}

		public Criteria andMlzsNearbyParkGreaterThanOrEqualTo(String value) {
			addCriterion("MLZS_NEARBY_PARK >=", value, "mlzsNearbyPark");
			return (Criteria) this;
		}

		public Criteria andMlzsNearbyParkLessThan(String value) {
			addCriterion("MLZS_NEARBY_PARK <", value, "mlzsNearbyPark");
			return (Criteria) this;
		}

		public Criteria andMlzsNearbyParkLessThanOrEqualTo(String value) {
			addCriterion("MLZS_NEARBY_PARK <=", value, "mlzsNearbyPark");
			return (Criteria) this;
		}

		public Criteria andMlzsNearbyParkLike(String value) {
			addCriterion("MLZS_NEARBY_PARK like", value, "mlzsNearbyPark");
			return (Criteria) this;
		}

		public Criteria andMlzsNearbyParkNotLike(String value) {
			addCriterion("MLZS_NEARBY_PARK not like", value, "mlzsNearbyPark");
			return (Criteria) this;
		}

		public Criteria andMlzsNearbyParkIn(List<String> values) {
			addCriterion("MLZS_NEARBY_PARK in", values, "mlzsNearbyPark");
			return (Criteria) this;
		}

		public Criteria andMlzsNearbyParkNotIn(List<String> values) {
			addCriterion("MLZS_NEARBY_PARK not in", values, "mlzsNearbyPark");
			return (Criteria) this;
		}

		public Criteria andMlzsNearbyParkBetween(String value1, String value2) {
			addCriterion("MLZS_NEARBY_PARK between", value1, value2, "mlzsNearbyPark");
			return (Criteria) this;
		}

		public Criteria andMlzsNearbyParkNotBetween(String value1, String value2) {
			addCriterion("MLZS_NEARBY_PARK not between", value1, value2, "mlzsNearbyPark");
			return (Criteria) this;
		}

		public Criteria andMlzsHealthRecreationNumberIsNull() {
			addCriterion("MLZS_HEALTH_RECREATION_NUMBER is null");
			return (Criteria) this;
		}

		public Criteria andMlzsHealthRecreationNumberIsNotNull() {
			addCriterion("MLZS_HEALTH_RECREATION_NUMBER is not null");
			return (Criteria) this;
		}

		public Criteria andMlzsHealthRecreationNumberEqualTo(String value) {
			addCriterion("MLZS_HEALTH_RECREATION_NUMBER =", value, "mlzsHealthRecreationNumber");
			return (Criteria) this;
		}

		public Criteria andMlzsHealthRecreationNumberNotEqualTo(String value) {
			addCriterion("MLZS_HEALTH_RECREATION_NUMBER <>", value, "mlzsHealthRecreationNumber");
			return (Criteria) this;
		}

		public Criteria andMlzsHealthRecreationNumberGreaterThan(String value) {
			addCriterion("MLZS_HEALTH_RECREATION_NUMBER >", value, "mlzsHealthRecreationNumber");
			return (Criteria) this;
		}

		public Criteria andMlzsHealthRecreationNumberGreaterThanOrEqualTo(String value) {
			addCriterion("MLZS_HEALTH_RECREATION_NUMBER >=", value, "mlzsHealthRecreationNumber");
			return (Criteria) this;
		}

		public Criteria andMlzsHealthRecreationNumberLessThan(String value) {
			addCriterion("MLZS_HEALTH_RECREATION_NUMBER <", value, "mlzsHealthRecreationNumber");
			return (Criteria) this;
		}

		public Criteria andMlzsHealthRecreationNumberLessThanOrEqualTo(String value) {
			addCriterion("MLZS_HEALTH_RECREATION_NUMBER <=", value, "mlzsHealthRecreationNumber");
			return (Criteria) this;
		}

		public Criteria andMlzsHealthRecreationNumberLike(String value) {
			addCriterion("MLZS_HEALTH_RECREATION_NUMBER like", value, "mlzsHealthRecreationNumber");
			return (Criteria) this;
		}

		public Criteria andMlzsHealthRecreationNumberNotLike(String value) {
			addCriterion("MLZS_HEALTH_RECREATION_NUMBER not like", value, "mlzsHealthRecreationNumber");
			return (Criteria) this;
		}

		public Criteria andMlzsHealthRecreationNumberIn(List<String> values) {
			addCriterion("MLZS_HEALTH_RECREATION_NUMBER in", values, "mlzsHealthRecreationNumber");
			return (Criteria) this;
		}

		public Criteria andMlzsHealthRecreationNumberNotIn(List<String> values) {
			addCriterion("MLZS_HEALTH_RECREATION_NUMBER not in", values, "mlzsHealthRecreationNumber");
			return (Criteria) this;
		}

		public Criteria andMlzsHealthRecreationNumberBetween(String value1, String value2) {
			addCriterion("MLZS_HEALTH_RECREATION_NUMBER between", value1, value2, "mlzsHealthRecreationNumber");
			return (Criteria) this;
		}

		public Criteria andMlzsHealthRecreationNumberNotBetween(String value1, String value2) {
			addCriterion("MLZS_HEALTH_RECREATION_NUMBER not between", value1, value2, "mlzsHealthRecreationNumber");
			return (Criteria) this;
		}

		public Criteria andMlzsNearbyUrbanComplexIsNull() {
			addCriterion("MLZS_NEARBY_URBAN_COMPLEX is null");
			return (Criteria) this;
		}

		public Criteria andMlzsNearbyUrbanComplexIsNotNull() {
			addCriterion("MLZS_NEARBY_URBAN_COMPLEX is not null");
			return (Criteria) this;
		}

		public Criteria andMlzsNearbyUrbanComplexEqualTo(String value) {
			addCriterion("MLZS_NEARBY_URBAN_COMPLEX =", value, "mlzsNearbyUrbanComplex");
			return (Criteria) this;
		}

		public Criteria andMlzsNearbyUrbanComplexNotEqualTo(String value) {
			addCriterion("MLZS_NEARBY_URBAN_COMPLEX <>", value, "mlzsNearbyUrbanComplex");
			return (Criteria) this;
		}

		public Criteria andMlzsNearbyUrbanComplexGreaterThan(String value) {
			addCriterion("MLZS_NEARBY_URBAN_COMPLEX >", value, "mlzsNearbyUrbanComplex");
			return (Criteria) this;
		}

		public Criteria andMlzsNearbyUrbanComplexGreaterThanOrEqualTo(String value) {
			addCriterion("MLZS_NEARBY_URBAN_COMPLEX >=", value, "mlzsNearbyUrbanComplex");
			return (Criteria) this;
		}

		public Criteria andMlzsNearbyUrbanComplexLessThan(String value) {
			addCriterion("MLZS_NEARBY_URBAN_COMPLEX <", value, "mlzsNearbyUrbanComplex");
			return (Criteria) this;
		}

		public Criteria andMlzsNearbyUrbanComplexLessThanOrEqualTo(String value) {
			addCriterion("MLZS_NEARBY_URBAN_COMPLEX <=", value, "mlzsNearbyUrbanComplex");
			return (Criteria) this;
		}

		public Criteria andMlzsNearbyUrbanComplexLike(String value) {
			addCriterion("MLZS_NEARBY_URBAN_COMPLEX like", value, "mlzsNearbyUrbanComplex");
			return (Criteria) this;
		}

		public Criteria andMlzsNearbyUrbanComplexNotLike(String value) {
			addCriterion("MLZS_NEARBY_URBAN_COMPLEX not like", value, "mlzsNearbyUrbanComplex");
			return (Criteria) this;
		}

		public Criteria andMlzsNearbyUrbanComplexIn(List<String> values) {
			addCriterion("MLZS_NEARBY_URBAN_COMPLEX in", values, "mlzsNearbyUrbanComplex");
			return (Criteria) this;
		}

		public Criteria andMlzsNearbyUrbanComplexNotIn(List<String> values) {
			addCriterion("MLZS_NEARBY_URBAN_COMPLEX not in", values, "mlzsNearbyUrbanComplex");
			return (Criteria) this;
		}

		public Criteria andMlzsNearbyUrbanComplexBetween(String value1, String value2) {
			addCriterion("MLZS_NEARBY_URBAN_COMPLEX between", value1, value2, "mlzsNearbyUrbanComplex");
			return (Criteria) this;
		}

		public Criteria andMlzsNearbyUrbanComplexNotBetween(String value1, String value2) {
			addCriterion("MLZS_NEARBY_URBAN_COMPLEX not between", value1, value2, "mlzsNearbyUrbanComplex");
			return (Criteria) this;
		}

		public Criteria andMlzsNearbyRegionalComplexIsNull() {
			addCriterion("MLZS_NEARBY_REGIONAL_COMPLEX is null");
			return (Criteria) this;
		}

		public Criteria andMlzsNearbyRegionalComplexIsNotNull() {
			addCriterion("MLZS_NEARBY_REGIONAL_COMPLEX is not null");
			return (Criteria) this;
		}

		public Criteria andMlzsNearbyRegionalComplexEqualTo(String value) {
			addCriterion("MLZS_NEARBY_REGIONAL_COMPLEX =", value, "mlzsNearbyRegionalComplex");
			return (Criteria) this;
		}

		public Criteria andMlzsNearbyRegionalComplexNotEqualTo(String value) {
			addCriterion("MLZS_NEARBY_REGIONAL_COMPLEX <>", value, "mlzsNearbyRegionalComplex");
			return (Criteria) this;
		}

		public Criteria andMlzsNearbyRegionalComplexGreaterThan(String value) {
			addCriterion("MLZS_NEARBY_REGIONAL_COMPLEX >", value, "mlzsNearbyRegionalComplex");
			return (Criteria) this;
		}

		public Criteria andMlzsNearbyRegionalComplexGreaterThanOrEqualTo(String value) {
			addCriterion("MLZS_NEARBY_REGIONAL_COMPLEX >=", value, "mlzsNearbyRegionalComplex");
			return (Criteria) this;
		}

		public Criteria andMlzsNearbyRegionalComplexLessThan(String value) {
			addCriterion("MLZS_NEARBY_REGIONAL_COMPLEX <", value, "mlzsNearbyRegionalComplex");
			return (Criteria) this;
		}

		public Criteria andMlzsNearbyRegionalComplexLessThanOrEqualTo(String value) {
			addCriterion("MLZS_NEARBY_REGIONAL_COMPLEX <=", value, "mlzsNearbyRegionalComplex");
			return (Criteria) this;
		}

		public Criteria andMlzsNearbyRegionalComplexLike(String value) {
			addCriterion("MLZS_NEARBY_REGIONAL_COMPLEX like", value, "mlzsNearbyRegionalComplex");
			return (Criteria) this;
		}

		public Criteria andMlzsNearbyRegionalComplexNotLike(String value) {
			addCriterion("MLZS_NEARBY_REGIONAL_COMPLEX not like", value, "mlzsNearbyRegionalComplex");
			return (Criteria) this;
		}

		public Criteria andMlzsNearbyRegionalComplexIn(List<String> values) {
			addCriterion("MLZS_NEARBY_REGIONAL_COMPLEX in", values, "mlzsNearbyRegionalComplex");
			return (Criteria) this;
		}

		public Criteria andMlzsNearbyRegionalComplexNotIn(List<String> values) {
			addCriterion("MLZS_NEARBY_REGIONAL_COMPLEX not in", values, "mlzsNearbyRegionalComplex");
			return (Criteria) this;
		}

		public Criteria andMlzsNearbyRegionalComplexBetween(String value1, String value2) {
			addCriterion("MLZS_NEARBY_REGIONAL_COMPLEX between", value1, value2, "mlzsNearbyRegionalComplex");
			return (Criteria) this;
		}

		public Criteria andMlzsNearbyRegionalComplexNotBetween(String value1, String value2) {
			addCriterion("MLZS_NEARBY_REGIONAL_COMPLEX not between", value1, value2, "mlzsNearbyRegionalComplex");
			return (Criteria) this;
		}

		public Criteria andMlzsNearbyCommunityComplexIsNull() {
			addCriterion("MLZS_NEARBY_COMMUNITY_COMPLEX is null");
			return (Criteria) this;
		}

		public Criteria andMlzsNearbyCommunityComplexIsNotNull() {
			addCriterion("MLZS_NEARBY_COMMUNITY_COMPLEX is not null");
			return (Criteria) this;
		}

		public Criteria andMlzsNearbyCommunityComplexEqualTo(String value) {
			addCriterion("MLZS_NEARBY_COMMUNITY_COMPLEX =", value, "mlzsNearbyCommunityComplex");
			return (Criteria) this;
		}

		public Criteria andMlzsNearbyCommunityComplexNotEqualTo(String value) {
			addCriterion("MLZS_NEARBY_COMMUNITY_COMPLEX <>", value, "mlzsNearbyCommunityComplex");
			return (Criteria) this;
		}

		public Criteria andMlzsNearbyCommunityComplexGreaterThan(String value) {
			addCriterion("MLZS_NEARBY_COMMUNITY_COMPLEX >", value, "mlzsNearbyCommunityComplex");
			return (Criteria) this;
		}

		public Criteria andMlzsNearbyCommunityComplexGreaterThanOrEqualTo(String value) {
			addCriterion("MLZS_NEARBY_COMMUNITY_COMPLEX >=", value, "mlzsNearbyCommunityComplex");
			return (Criteria) this;
		}

		public Criteria andMlzsNearbyCommunityComplexLessThan(String value) {
			addCriterion("MLZS_NEARBY_COMMUNITY_COMPLEX <", value, "mlzsNearbyCommunityComplex");
			return (Criteria) this;
		}

		public Criteria andMlzsNearbyCommunityComplexLessThanOrEqualTo(String value) {
			addCriterion("MLZS_NEARBY_COMMUNITY_COMPLEX <=", value, "mlzsNearbyCommunityComplex");
			return (Criteria) this;
		}

		public Criteria andMlzsNearbyCommunityComplexLike(String value) {
			addCriterion("MLZS_NEARBY_COMMUNITY_COMPLEX like", value, "mlzsNearbyCommunityComplex");
			return (Criteria) this;
		}

		public Criteria andMlzsNearbyCommunityComplexNotLike(String value) {
			addCriterion("MLZS_NEARBY_COMMUNITY_COMPLEX not like", value, "mlzsNearbyCommunityComplex");
			return (Criteria) this;
		}

		public Criteria andMlzsNearbyCommunityComplexIn(List<String> values) {
			addCriterion("MLZS_NEARBY_COMMUNITY_COMPLEX in", values, "mlzsNearbyCommunityComplex");
			return (Criteria) this;
		}

		public Criteria andMlzsNearbyCommunityComplexNotIn(List<String> values) {
			addCriterion("MLZS_NEARBY_COMMUNITY_COMPLEX not in", values, "mlzsNearbyCommunityComplex");
			return (Criteria) this;
		}

		public Criteria andMlzsNearbyCommunityComplexBetween(String value1, String value2) {
			addCriterion("MLZS_NEARBY_COMMUNITY_COMPLEX between", value1, value2, "mlzsNearbyCommunityComplex");
			return (Criteria) this;
		}

		public Criteria andMlzsNearbyCommunityComplexNotBetween(String value1, String value2) {
			addCriterion("MLZS_NEARBY_COMMUNITY_COMPLEX not between", value1, value2, "mlzsNearbyCommunityComplex");
			return (Criteria) this;
		}

		public Criteria andMlzsTopFiveElementarySchoolIsNull() {
			addCriterion("MLZS_TOP_FIVE_ELEMENTARY_SCHOOL is null");
			return (Criteria) this;
		}

		public Criteria andMlzsTopFiveElementarySchoolIsNotNull() {
			addCriterion("MLZS_TOP_FIVE_ELEMENTARY_SCHOOL is not null");
			return (Criteria) this;
		}

		public Criteria andMlzsTopFiveElementarySchoolEqualTo(String value) {
			addCriterion("MLZS_TOP_FIVE_ELEMENTARY_SCHOOL =", value, "mlzsTopFiveElementarySchool");
			return (Criteria) this;
		}

		public Criteria andMlzsTopFiveElementarySchoolNotEqualTo(String value) {
			addCriterion("MLZS_TOP_FIVE_ELEMENTARY_SCHOOL <>", value, "mlzsTopFiveElementarySchool");
			return (Criteria) this;
		}

		public Criteria andMlzsTopFiveElementarySchoolGreaterThan(String value) {
			addCriterion("MLZS_TOP_FIVE_ELEMENTARY_SCHOOL >", value, "mlzsTopFiveElementarySchool");
			return (Criteria) this;
		}

		public Criteria andMlzsTopFiveElementarySchoolGreaterThanOrEqualTo(String value) {
			addCriterion("MLZS_TOP_FIVE_ELEMENTARY_SCHOOL >=", value, "mlzsTopFiveElementarySchool");
			return (Criteria) this;
		}

		public Criteria andMlzsTopFiveElementarySchoolLessThan(String value) {
			addCriterion("MLZS_TOP_FIVE_ELEMENTARY_SCHOOL <", value, "mlzsTopFiveElementarySchool");
			return (Criteria) this;
		}

		public Criteria andMlzsTopFiveElementarySchoolLessThanOrEqualTo(String value) {
			addCriterion("MLZS_TOP_FIVE_ELEMENTARY_SCHOOL <=", value, "mlzsTopFiveElementarySchool");
			return (Criteria) this;
		}

		public Criteria andMlzsTopFiveElementarySchoolLike(String value) {
			addCriterion("MLZS_TOP_FIVE_ELEMENTARY_SCHOOL like", value, "mlzsTopFiveElementarySchool");
			return (Criteria) this;
		}

		public Criteria andMlzsTopFiveElementarySchoolNotLike(String value) {
			addCriterion("MLZS_TOP_FIVE_ELEMENTARY_SCHOOL not like", value, "mlzsTopFiveElementarySchool");
			return (Criteria) this;
		}

		public Criteria andMlzsTopFiveElementarySchoolIn(List<String> values) {
			addCriterion("MLZS_TOP_FIVE_ELEMENTARY_SCHOOL in", values, "mlzsTopFiveElementarySchool");
			return (Criteria) this;
		}

		public Criteria andMlzsTopFiveElementarySchoolNotIn(List<String> values) {
			addCriterion("MLZS_TOP_FIVE_ELEMENTARY_SCHOOL not in", values, "mlzsTopFiveElementarySchool");
			return (Criteria) this;
		}

		public Criteria andMlzsTopFiveElementarySchoolBetween(String value1, String value2) {
			addCriterion("MLZS_TOP_FIVE_ELEMENTARY_SCHOOL between", value1, value2, "mlzsTopFiveElementarySchool");
			return (Criteria) this;
		}

		public Criteria andMlzsTopFiveElementarySchoolNotBetween(String value1, String value2) {
			addCriterion("MLZS_TOP_FIVE_ELEMENTARY_SCHOOL not between", value1, value2, "mlzsTopFiveElementarySchool");
			return (Criteria) this;
		}

		public Criteria andMlzsTopFiveMiddleSchoolIsNull() {
			addCriterion("MLZS_TOP_FIVE_MIDDLE_SCHOOL is null");
			return (Criteria) this;
		}

		public Criteria andMlzsTopFiveMiddleSchoolIsNotNull() {
			addCriterion("MLZS_TOP_FIVE_MIDDLE_SCHOOL is not null");
			return (Criteria) this;
		}

		public Criteria andMlzsTopFiveMiddleSchoolEqualTo(String value) {
			addCriterion("MLZS_TOP_FIVE_MIDDLE_SCHOOL =", value, "mlzsTopFiveMiddleSchool");
			return (Criteria) this;
		}

		public Criteria andMlzsTopFiveMiddleSchoolNotEqualTo(String value) {
			addCriterion("MLZS_TOP_FIVE_MIDDLE_SCHOOL <>", value, "mlzsTopFiveMiddleSchool");
			return (Criteria) this;
		}

		public Criteria andMlzsTopFiveMiddleSchoolGreaterThan(String value) {
			addCriterion("MLZS_TOP_FIVE_MIDDLE_SCHOOL >", value, "mlzsTopFiveMiddleSchool");
			return (Criteria) this;
		}

		public Criteria andMlzsTopFiveMiddleSchoolGreaterThanOrEqualTo(String value) {
			addCriterion("MLZS_TOP_FIVE_MIDDLE_SCHOOL >=", value, "mlzsTopFiveMiddleSchool");
			return (Criteria) this;
		}

		public Criteria andMlzsTopFiveMiddleSchoolLessThan(String value) {
			addCriterion("MLZS_TOP_FIVE_MIDDLE_SCHOOL <", value, "mlzsTopFiveMiddleSchool");
			return (Criteria) this;
		}

		public Criteria andMlzsTopFiveMiddleSchoolLessThanOrEqualTo(String value) {
			addCriterion("MLZS_TOP_FIVE_MIDDLE_SCHOOL <=", value, "mlzsTopFiveMiddleSchool");
			return (Criteria) this;
		}

		public Criteria andMlzsTopFiveMiddleSchoolLike(String value) {
			addCriterion("MLZS_TOP_FIVE_MIDDLE_SCHOOL like", value, "mlzsTopFiveMiddleSchool");
			return (Criteria) this;
		}

		public Criteria andMlzsTopFiveMiddleSchoolNotLike(String value) {
			addCriterion("MLZS_TOP_FIVE_MIDDLE_SCHOOL not like", value, "mlzsTopFiveMiddleSchool");
			return (Criteria) this;
		}

		public Criteria andMlzsTopFiveMiddleSchoolIn(List<String> values) {
			addCriterion("MLZS_TOP_FIVE_MIDDLE_SCHOOL in", values, "mlzsTopFiveMiddleSchool");
			return (Criteria) this;
		}

		public Criteria andMlzsTopFiveMiddleSchoolNotIn(List<String> values) {
			addCriterion("MLZS_TOP_FIVE_MIDDLE_SCHOOL not in", values, "mlzsTopFiveMiddleSchool");
			return (Criteria) this;
		}

		public Criteria andMlzsTopFiveMiddleSchoolBetween(String value1, String value2) {
			addCriterion("MLZS_TOP_FIVE_MIDDLE_SCHOOL between", value1, value2, "mlzsTopFiveMiddleSchool");
			return (Criteria) this;
		}

		public Criteria andMlzsTopFiveMiddleSchoolNotBetween(String value1, String value2) {
			addCriterion("MLZS_TOP_FIVE_MIDDLE_SCHOOL not between", value1, value2, "mlzsTopFiveMiddleSchool");
			return (Criteria) this;
		}

		public Criteria andMlzsUpgradeIndexAssignmentIsNull() {
			addCriterion("MLZS_UPGRADE_INDEX_ASSIGNMENT is null");
			return (Criteria) this;
		}

		public Criteria andMlzsUpgradeIndexAssignmentIsNotNull() {
			addCriterion("MLZS_UPGRADE_INDEX_ASSIGNMENT is not null");
			return (Criteria) this;
		}

		public Criteria andMlzsUpgradeIndexAssignmentEqualTo(String value) {
			addCriterion("MLZS_UPGRADE_INDEX_ASSIGNMENT =", value, "mlzsUpgradeIndexAssignment");
			return (Criteria) this;
		}

		public Criteria andMlzsUpgradeIndexAssignmentNotEqualTo(String value) {
			addCriterion("MLZS_UPGRADE_INDEX_ASSIGNMENT <>", value, "mlzsUpgradeIndexAssignment");
			return (Criteria) this;
		}

		public Criteria andMlzsUpgradeIndexAssignmentGreaterThan(String value) {
			addCriterion("MLZS_UPGRADE_INDEX_ASSIGNMENT >", value, "mlzsUpgradeIndexAssignment");
			return (Criteria) this;
		}

		public Criteria andMlzsUpgradeIndexAssignmentGreaterThanOrEqualTo(String value) {
			addCriterion("MLZS_UPGRADE_INDEX_ASSIGNMENT >=", value, "mlzsUpgradeIndexAssignment");
			return (Criteria) this;
		}

		public Criteria andMlzsUpgradeIndexAssignmentLessThan(String value) {
			addCriterion("MLZS_UPGRADE_INDEX_ASSIGNMENT <", value, "mlzsUpgradeIndexAssignment");
			return (Criteria) this;
		}

		public Criteria andMlzsUpgradeIndexAssignmentLessThanOrEqualTo(String value) {
			addCriterion("MLZS_UPGRADE_INDEX_ASSIGNMENT <=", value, "mlzsUpgradeIndexAssignment");
			return (Criteria) this;
		}

		public Criteria andMlzsUpgradeIndexAssignmentLike(String value) {
			addCriterion("MLZS_UPGRADE_INDEX_ASSIGNMENT like", value, "mlzsUpgradeIndexAssignment");
			return (Criteria) this;
		}

		public Criteria andMlzsUpgradeIndexAssignmentNotLike(String value) {
			addCriterion("MLZS_UPGRADE_INDEX_ASSIGNMENT not like", value, "mlzsUpgradeIndexAssignment");
			return (Criteria) this;
		}

		public Criteria andMlzsUpgradeIndexAssignmentIn(List<String> values) {
			addCriterion("MLZS_UPGRADE_INDEX_ASSIGNMENT in", values, "mlzsUpgradeIndexAssignment");
			return (Criteria) this;
		}

		public Criteria andMlzsUpgradeIndexAssignmentNotIn(List<String> values) {
			addCriterion("MLZS_UPGRADE_INDEX_ASSIGNMENT not in", values, "mlzsUpgradeIndexAssignment");
			return (Criteria) this;
		}

		public Criteria andMlzsUpgradeIndexAssignmentBetween(String value1, String value2) {
			addCriterion("MLZS_UPGRADE_INDEX_ASSIGNMENT between", value1, value2, "mlzsUpgradeIndexAssignment");
			return (Criteria) this;
		}

		public Criteria andMlzsUpgradeIndexAssignmentNotBetween(String value1, String value2) {
			addCriterion("MLZS_UPGRADE_INDEX_ASSIGNMENT not between", value1, value2, "mlzsUpgradeIndexAssignment");
			return (Criteria) this;
		}

		public Criteria andMlLandNumberIsNull() {
			addCriterion("ML_LAND_NUMBER is null");
			return (Criteria) this;
		}

		public Criteria andMlLandNumberIsNotNull() {
			addCriterion("ML_LAND_NUMBER is not null");
			return (Criteria) this;
		}

		public Criteria andMlLandNumberEqualTo(String value) {
			addCriterion("ML_LAND_NUMBER =", value, "mlLandNumber");
			return (Criteria) this;
		}

		public Criteria andMlLandNumberNotEqualTo(String value) {
			addCriterion("ML_LAND_NUMBER <>", value, "mlLandNumber");
			return (Criteria) this;
		}

		public Criteria andMlLandNumberGreaterThan(String value) {
			addCriterion("ML_LAND_NUMBER >", value, "mlLandNumber");
			return (Criteria) this;
		}

		public Criteria andMlLandNumberGreaterThanOrEqualTo(String value) {
			addCriterion("ML_LAND_NUMBER >=", value, "mlLandNumber");
			return (Criteria) this;
		}

		public Criteria andMlLandNumberLessThan(String value) {
			addCriterion("ML_LAND_NUMBER <", value, "mlLandNumber");
			return (Criteria) this;
		}

		public Criteria andMlLandNumberLessThanOrEqualTo(String value) {
			addCriterion("ML_LAND_NUMBER <=", value, "mlLandNumber");
			return (Criteria) this;
		}

		public Criteria andMlLandNumberLike(String value) {
			addCriterion("ML_LAND_NUMBER like", value, "mlLandNumber");
			return (Criteria) this;
		}

		public Criteria andMlLandNumberNotLike(String value) {
			addCriterion("ML_LAND_NUMBER not like", value, "mlLandNumber");
			return (Criteria) this;
		}

		public Criteria andMlLandNumberIn(List<String> values) {
			addCriterion("ML_LAND_NUMBER in", values, "mlLandNumber");
			return (Criteria) this;
		}

		public Criteria andMlLandNumberNotIn(List<String> values) {
			addCriterion("ML_LAND_NUMBER not in", values, "mlLandNumber");
			return (Criteria) this;
		}

		public Criteria andMlLandNumberBetween(String value1, String value2) {
			addCriterion("ML_LAND_NUMBER between", value1, value2, "mlLandNumber");
			return (Criteria) this;
		}

		public Criteria andMlLandNumberNotBetween(String value1, String value2) {
			addCriterion("ML_LAND_NUMBER not between", value1, value2, "mlLandNumber");
			return (Criteria) this;
		}

		public Criteria andCostStandardAIsNull() {
			addCriterion("COST_STANDARD_A is null");
			return (Criteria) this;
		}

		public Criteria andCostStandardAIsNotNull() {
			addCriterion("COST_STANDARD_A is not null");
			return (Criteria) this;
		}

		public Criteria andCostStandardAEqualTo(String value) {
			addCriterion("COST_STANDARD_A =", value, "costStandardA");
			return (Criteria) this;
		}

		public Criteria andCostStandardANotEqualTo(String value) {
			addCriterion("COST_STANDARD_A <>", value, "costStandardA");
			return (Criteria) this;
		}

		public Criteria andCostStandardAGreaterThan(String value) {
			addCriterion("COST_STANDARD_A >", value, "costStandardA");
			return (Criteria) this;
		}

		public Criteria andCostStandardAGreaterThanOrEqualTo(String value) {
			addCriterion("COST_STANDARD_A >=", value, "costStandardA");
			return (Criteria) this;
		}

		public Criteria andCostStandardALessThan(String value) {
			addCriterion("COST_STANDARD_A <", value, "costStandardA");
			return (Criteria) this;
		}

		public Criteria andCostStandardALessThanOrEqualTo(String value) {
			addCriterion("COST_STANDARD_A <=", value, "costStandardA");
			return (Criteria) this;
		}

		public Criteria andCostStandardALike(String value) {
			addCriterion("COST_STANDARD_A like", value, "costStandardA");
			return (Criteria) this;
		}

		public Criteria andCostStandardANotLike(String value) {
			addCriterion("COST_STANDARD_A not like", value, "costStandardA");
			return (Criteria) this;
		}

		public Criteria andCostStandardAIn(List<String> values) {
			addCriterion("COST_STANDARD_A in", values, "costStandardA");
			return (Criteria) this;
		}

		public Criteria andCostStandardANotIn(List<String> values) {
			addCriterion("COST_STANDARD_A not in", values, "costStandardA");
			return (Criteria) this;
		}

		public Criteria andCostStandardABetween(String value1, String value2) {
			addCriterion("COST_STANDARD_A between", value1, value2, "costStandardA");
			return (Criteria) this;
		}

		public Criteria andCostStandardANotBetween(String value1, String value2) {
			addCriterion("COST_STANDARD_A not between", value1, value2, "costStandardA");
			return (Criteria) this;
		}

		public Criteria andMlBelongToStreetAIsNull() {
			addCriterion("ML_BELONG_TO_STREET_A is null");
			return (Criteria) this;
		}

		public Criteria andMlBelongToStreetAIsNotNull() {
			addCriterion("ML_BELONG_TO_STREET_A is not null");
			return (Criteria) this;
		}

		public Criteria andMlBelongToStreetAEqualTo(String value) {
			addCriterion("ML_BELONG_TO_STREET_A =", value, "mlBelongToStreetA");
			return (Criteria) this;
		}

		public Criteria andMlBelongToStreetANotEqualTo(String value) {
			addCriterion("ML_BELONG_TO_STREET_A <>", value, "mlBelongToStreetA");
			return (Criteria) this;
		}

		public Criteria andMlBelongToStreetAGreaterThan(String value) {
			addCriterion("ML_BELONG_TO_STREET_A >", value, "mlBelongToStreetA");
			return (Criteria) this;
		}

		public Criteria andMlBelongToStreetAGreaterThanOrEqualTo(String value) {
			addCriterion("ML_BELONG_TO_STREET_A >=", value, "mlBelongToStreetA");
			return (Criteria) this;
		}

		public Criteria andMlBelongToStreetALessThan(String value) {
			addCriterion("ML_BELONG_TO_STREET_A <", value, "mlBelongToStreetA");
			return (Criteria) this;
		}

		public Criteria andMlBelongToStreetALessThanOrEqualTo(String value) {
			addCriterion("ML_BELONG_TO_STREET_A <=", value, "mlBelongToStreetA");
			return (Criteria) this;
		}

		public Criteria andMlBelongToStreetALike(String value) {
			addCriterion("ML_BELONG_TO_STREET_A like", value, "mlBelongToStreetA");
			return (Criteria) this;
		}

		public Criteria andMlBelongToStreetANotLike(String value) {
			addCriterion("ML_BELONG_TO_STREET_A not like", value, "mlBelongToStreetA");
			return (Criteria) this;
		}

		public Criteria andMlBelongToStreetAIn(List<String> values) {
			addCriterion("ML_BELONG_TO_STREET_A in", values, "mlBelongToStreetA");
			return (Criteria) this;
		}

		public Criteria andMlBelongToStreetANotIn(List<String> values) {
			addCriterion("ML_BELONG_TO_STREET_A not in", values, "mlBelongToStreetA");
			return (Criteria) this;
		}

		public Criteria andMlBelongToStreetABetween(String value1, String value2) {
			addCriterion("ML_BELONG_TO_STREET_A between", value1, value2, "mlBelongToStreetA");
			return (Criteria) this;
		}

		public Criteria andMlBelongToStreetANotBetween(String value1, String value2) {
			addCriterion("ML_BELONG_TO_STREET_A not between", value1, value2, "mlBelongToStreetA");
			return (Criteria) this;
		}

		public Criteria andMetroDistanceIsNull() {
			addCriterion("METRO_DISTANCE is null");
			return (Criteria) this;
		}

		public Criteria andMetroDistanceIsNotNull() {
			addCriterion("METRO_DISTANCE is not null");
			return (Criteria) this;
		}

		public Criteria andMetroDistanceEqualTo(Double value) {
			addCriterion("METRO_DISTANCE =", value, "metroDistance");
			return (Criteria) this;
		}

		public Criteria andMetroDistanceNotEqualTo(Double value) {
			addCriterion("METRO_DISTANCE <>", value, "metroDistance");
			return (Criteria) this;
		}

		public Criteria andMetroDistanceGreaterThan(Double value) {
			addCriterion("METRO_DISTANCE >", value, "metroDistance");
			return (Criteria) this;
		}

		public Criteria andMetroDistanceGreaterThanOrEqualTo(Double value) {
			addCriterion("METRO_DISTANCE >=", value, "metroDistance");
			return (Criteria) this;
		}

		public Criteria andMetroDistanceLessThan(Double value) {
			addCriterion("METRO_DISTANCE <", value, "metroDistance");
			return (Criteria) this;
		}

		public Criteria andMetroDistanceLessThanOrEqualTo(Double value) {
			addCriterion("METRO_DISTANCE <=", value, "metroDistance");
			return (Criteria) this;
		}

		public Criteria andMetroDistanceIn(List<Double> values) {
			addCriterion("METRO_DISTANCE in", values, "metroDistance");
			return (Criteria) this;
		}

		public Criteria andMetroDistanceNotIn(List<Double> values) {
			addCriterion("METRO_DISTANCE not in", values, "metroDistance");
			return (Criteria) this;
		}

		public Criteria andMetroDistanceBetween(Double value1, Double value2) {
			addCriterion("METRO_DISTANCE between", value1, value2, "metroDistance");
			return (Criteria) this;
		}

		public Criteria andMetroDistanceNotBetween(Double value1, Double value2) {
			addCriterion("METRO_DISTANCE not between", value1, value2, "metroDistance");
			return (Criteria) this;
		}

		public Criteria andAveragePriceIsNull() {
			addCriterion("AVERAGE_PRICE is null");
			return (Criteria) this;
		}

		public Criteria andAveragePriceIsNotNull() {
			addCriterion("AVERAGE_PRICE is not null");
			return (Criteria) this;
		}

		public Criteria andAveragePriceEqualTo(BigDecimal value) {
			addCriterion("AVERAGE_PRICE =", value, "averagePrice");
			return (Criteria) this;
		}

		public Criteria andAveragePriceNotEqualTo(BigDecimal value) {
			addCriterion("AVERAGE_PRICE <>", value, "averagePrice");
			return (Criteria) this;
		}

		public Criteria andAveragePriceGreaterThan(BigDecimal value) {
			addCriterion("AVERAGE_PRICE >", value, "averagePrice");
			return (Criteria) this;
		}

		public Criteria andAveragePriceGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("AVERAGE_PRICE >=", value, "averagePrice");
			return (Criteria) this;
		}

		public Criteria andAveragePriceLessThan(BigDecimal value) {
			addCriterion("AVERAGE_PRICE <", value, "averagePrice");
			return (Criteria) this;
		}

		public Criteria andAveragePriceLessThanOrEqualTo(BigDecimal value) {
			addCriterion("AVERAGE_PRICE <=", value, "averagePrice");
			return (Criteria) this;
		}

		public Criteria andAveragePriceIn(List<BigDecimal> values) {
			addCriterion("AVERAGE_PRICE in", values, "averagePrice");
			return (Criteria) this;
		}

		public Criteria andAveragePriceNotIn(List<BigDecimal> values) {
			addCriterion("AVERAGE_PRICE not in", values, "averagePrice");
			return (Criteria) this;
		}

		public Criteria andAveragePriceBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("AVERAGE_PRICE between", value1, value2, "averagePrice");
			return (Criteria) this;
		}

		public Criteria andAveragePriceNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("AVERAGE_PRICE not between", value1, value2, "averagePrice");
			return (Criteria) this;
		}

		public Criteria andLastAveragePriceIsNull() {
			addCriterion("LAST_AVERAGE_PRICE is null");
			return (Criteria) this;
		}

		public Criteria andLastAveragePriceIsNotNull() {
			addCriterion("LAST_AVERAGE_PRICE is not null");
			return (Criteria) this;
		}

		public Criteria andLastAveragePriceEqualTo(BigDecimal value) {
			addCriterion("LAST_AVERAGE_PRICE =", value, "lastAveragePrice");
			return (Criteria) this;
		}

		public Criteria andLastAveragePriceNotEqualTo(BigDecimal value) {
			addCriterion("LAST_AVERAGE_PRICE <>", value, "lastAveragePrice");
			return (Criteria) this;
		}

		public Criteria andLastAveragePriceGreaterThan(BigDecimal value) {
			addCriterion("LAST_AVERAGE_PRICE >", value, "lastAveragePrice");
			return (Criteria) this;
		}

		public Criteria andLastAveragePriceGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("LAST_AVERAGE_PRICE >=", value, "lastAveragePrice");
			return (Criteria) this;
		}

		public Criteria andLastAveragePriceLessThan(BigDecimal value) {
			addCriterion("LAST_AVERAGE_PRICE <", value, "lastAveragePrice");
			return (Criteria) this;
		}

		public Criteria andLastAveragePriceLessThanOrEqualTo(BigDecimal value) {
			addCriterion("LAST_AVERAGE_PRICE <=", value, "lastAveragePrice");
			return (Criteria) this;
		}

		public Criteria andLastAveragePriceIn(List<BigDecimal> values) {
			addCriterion("LAST_AVERAGE_PRICE in", values, "lastAveragePrice");
			return (Criteria) this;
		}

		public Criteria andLastAveragePriceNotIn(List<BigDecimal> values) {
			addCriterion("LAST_AVERAGE_PRICE not in", values, "lastAveragePrice");
			return (Criteria) this;
		}

		public Criteria andLastAveragePriceBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("LAST_AVERAGE_PRICE between", value1, value2, "lastAveragePrice");
			return (Criteria) this;
		}

		public Criteria andLastAveragePriceNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("LAST_AVERAGE_PRICE not between", value1, value2, "lastAveragePrice");
			return (Criteria) this;
		}

		public Criteria andParkingSpaceIsNull() {
			addCriterion("PARKING_SPACE is null");
			return (Criteria) this;
		}

		public Criteria andParkingSpaceIsNotNull() {
			addCriterion("PARKING_SPACE is not null");
			return (Criteria) this;
		}

		public Criteria andParkingSpaceEqualTo(Integer value) {
			addCriterion("PARKING_SPACE =", value, "parkingSpace");
			return (Criteria) this;
		}

		public Criteria andParkingSpaceNotEqualTo(Integer value) {
			addCriterion("PARKING_SPACE <>", value, "parkingSpace");
			return (Criteria) this;
		}

		public Criteria andParkingSpaceGreaterThan(Integer value) {
			addCriterion("PARKING_SPACE >", value, "parkingSpace");
			return (Criteria) this;
		}

		public Criteria andParkingSpaceGreaterThanOrEqualTo(Integer value) {
			addCriterion("PARKING_SPACE >=", value, "parkingSpace");
			return (Criteria) this;
		}

		public Criteria andParkingSpaceLessThan(Integer value) {
			addCriterion("PARKING_SPACE <", value, "parkingSpace");
			return (Criteria) this;
		}

		public Criteria andParkingSpaceLessThanOrEqualTo(Integer value) {
			addCriterion("PARKING_SPACE <=", value, "parkingSpace");
			return (Criteria) this;
		}

		public Criteria andParkingSpaceIn(List<Integer> values) {
			addCriterion("PARKING_SPACE in", values, "parkingSpace");
			return (Criteria) this;
		}

		public Criteria andParkingSpaceNotIn(List<Integer> values) {
			addCriterion("PARKING_SPACE not in", values, "parkingSpace");
			return (Criteria) this;
		}

		public Criteria andParkingSpaceBetween(Integer value1, Integer value2) {
			addCriterion("PARKING_SPACE between", value1, value2, "parkingSpace");
			return (Criteria) this;
		}

		public Criteria andParkingSpaceNotBetween(Integer value1, Integer value2) {
			addCriterion("PARKING_SPACE not between", value1, value2, "parkingSpace");
			return (Criteria) this;
		}

		public Criteria andStreetIdsIsNull() {
			addCriterion("STREET_IDS is null");
			return (Criteria) this;
		}

		public Criteria andStreetIdsIsNotNull() {
			addCriterion("STREET_IDS is not null");
			return (Criteria) this;
		}

		public Criteria andStreetIdsEqualTo(String value) {
			addCriterion("STREET_IDS =", value, "streetIds");
			return (Criteria) this;
		}

		public Criteria andStreetIdsNotEqualTo(String value) {
			addCriterion("STREET_IDS <>", value, "streetIds");
			return (Criteria) this;
		}

		public Criteria andStreetIdsGreaterThan(String value) {
			addCriterion("STREET_IDS >", value, "streetIds");
			return (Criteria) this;
		}

		public Criteria andStreetIdsGreaterThanOrEqualTo(String value) {
			addCriterion("STREET_IDS >=", value, "streetIds");
			return (Criteria) this;
		}

		public Criteria andStreetIdsLessThan(String value) {
			addCriterion("STREET_IDS <", value, "streetIds");
			return (Criteria) this;
		}

		public Criteria andStreetIdsLessThanOrEqualTo(String value) {
			addCriterion("STREET_IDS <=", value, "streetIds");
			return (Criteria) this;
		}

		public Criteria andStreetIdsLike(String value) {
			addCriterion("STREET_IDS like", value, "streetIds");
			return (Criteria) this;
		}

		public Criteria andStreetIdsNotLike(String value) {
			addCriterion("STREET_IDS not like", value, "streetIds");
			return (Criteria) this;
		}

		public Criteria andStreetIdsIn(List<String> values) {
			addCriterion("STREET_IDS in", values, "streetIds");
			return (Criteria) this;
		}

		public Criteria andStreetIdsNotIn(List<String> values) {
			addCriterion("STREET_IDS not in", values, "streetIds");
			return (Criteria) this;
		}

		public Criteria andStreetIdsBetween(String value1, String value2) {
			addCriterion("STREET_IDS between", value1, value2, "streetIds");
			return (Criteria) this;
		}

		public Criteria andStreetIdsNotBetween(String value1, String value2) {
			addCriterion("STREET_IDS not between", value1, value2, "streetIds");
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