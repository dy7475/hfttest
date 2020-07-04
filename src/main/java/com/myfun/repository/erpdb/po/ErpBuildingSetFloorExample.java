package com.myfun.repository.erpdb.po;

import com.myfun.repository.support.generator.shard.ShardDb;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ErpBuildingSetFloorExample extends ShardDb {
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
	public ErpBuildingSetFloorExample() {
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

		public Criteria andCityIdIsNull() {
			addCriterion("CITY_ID is null");
			return (Criteria) this;
		}

		public Criteria andCityIdIsNotNull() {
			addCriterion("CITY_ID is not null");
			return (Criteria) this;
		}

		public Criteria andCityIdEqualTo(Integer value) {
			addCriterion("CITY_ID =", value, "cityId");
			return (Criteria) this;
		}

		public Criteria andCityIdNotEqualTo(Integer value) {
			addCriterion("CITY_ID <>", value, "cityId");
			return (Criteria) this;
		}

		public Criteria andCityIdGreaterThan(Integer value) {
			addCriterion("CITY_ID >", value, "cityId");
			return (Criteria) this;
		}

		public Criteria andCityIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("CITY_ID >=", value, "cityId");
			return (Criteria) this;
		}

		public Criteria andCityIdLessThan(Integer value) {
			addCriterion("CITY_ID <", value, "cityId");
			return (Criteria) this;
		}

		public Criteria andCityIdLessThanOrEqualTo(Integer value) {
			addCriterion("CITY_ID <=", value, "cityId");
			return (Criteria) this;
		}

		public Criteria andCityIdIn(List<Integer> values) {
			addCriterion("CITY_ID in", values, "cityId");
			return (Criteria) this;
		}

		public Criteria andCityIdNotIn(List<Integer> values) {
			addCriterion("CITY_ID not in", values, "cityId");
			return (Criteria) this;
		}

		public Criteria andCityIdBetween(Integer value1, Integer value2) {
			addCriterion("CITY_ID between", value1, value2, "cityId");
			return (Criteria) this;
		}

		public Criteria andCityIdNotBetween(Integer value1, Integer value2) {
			addCriterion("CITY_ID not between", value1, value2, "cityId");
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

		public Criteria andBuildRoofIsNull() {
			addCriterion("BUILD_ROOF is null");
			return (Criteria) this;
		}

		public Criteria andBuildRoofIsNotNull() {
			addCriterion("BUILD_ROOF is not null");
			return (Criteria) this;
		}

		public Criteria andBuildRoofEqualTo(String value) {
			addCriterion("BUILD_ROOF =", value, "buildRoof");
			return (Criteria) this;
		}

		public Criteria andBuildRoofNotEqualTo(String value) {
			addCriterion("BUILD_ROOF <>", value, "buildRoof");
			return (Criteria) this;
		}

		public Criteria andBuildRoofGreaterThan(String value) {
			addCriterion("BUILD_ROOF >", value, "buildRoof");
			return (Criteria) this;
		}

		public Criteria andBuildRoofGreaterThanOrEqualTo(String value) {
			addCriterion("BUILD_ROOF >=", value, "buildRoof");
			return (Criteria) this;
		}

		public Criteria andBuildRoofLessThan(String value) {
			addCriterion("BUILD_ROOF <", value, "buildRoof");
			return (Criteria) this;
		}

		public Criteria andBuildRoofLessThanOrEqualTo(String value) {
			addCriterion("BUILD_ROOF <=", value, "buildRoof");
			return (Criteria) this;
		}

		public Criteria andBuildRoofLike(String value) {
			addCriterion("BUILD_ROOF like", value, "buildRoof");
			return (Criteria) this;
		}

		public Criteria andBuildRoofNotLike(String value) {
			addCriterion("BUILD_ROOF not like", value, "buildRoof");
			return (Criteria) this;
		}

		public Criteria andBuildRoofIn(List<String> values) {
			addCriterion("BUILD_ROOF in", values, "buildRoof");
			return (Criteria) this;
		}

		public Criteria andBuildRoofNotIn(List<String> values) {
			addCriterion("BUILD_ROOF not in", values, "buildRoof");
			return (Criteria) this;
		}

		public Criteria andBuildRoofBetween(String value1, String value2) {
			addCriterion("BUILD_ROOF between", value1, value2, "buildRoof");
			return (Criteria) this;
		}

		public Criteria andBuildRoofNotBetween(String value1, String value2) {
			addCriterion("BUILD_ROOF not between", value1, value2, "buildRoof");
			return (Criteria) this;
		}

		public Criteria andBuildUnitIsNull() {
			addCriterion("BUILD_UNIT is null");
			return (Criteria) this;
		}

		public Criteria andBuildUnitIsNotNull() {
			addCriterion("BUILD_UNIT is not null");
			return (Criteria) this;
		}

		public Criteria andBuildUnitEqualTo(String value) {
			addCriterion("BUILD_UNIT =", value, "buildUnit");
			return (Criteria) this;
		}

		public Criteria andBuildUnitNotEqualTo(String value) {
			addCriterion("BUILD_UNIT <>", value, "buildUnit");
			return (Criteria) this;
		}

		public Criteria andBuildUnitGreaterThan(String value) {
			addCriterion("BUILD_UNIT >", value, "buildUnit");
			return (Criteria) this;
		}

		public Criteria andBuildUnitGreaterThanOrEqualTo(String value) {
			addCriterion("BUILD_UNIT >=", value, "buildUnit");
			return (Criteria) this;
		}

		public Criteria andBuildUnitLessThan(String value) {
			addCriterion("BUILD_UNIT <", value, "buildUnit");
			return (Criteria) this;
		}

		public Criteria andBuildUnitLessThanOrEqualTo(String value) {
			addCriterion("BUILD_UNIT <=", value, "buildUnit");
			return (Criteria) this;
		}

		public Criteria andBuildUnitLike(String value) {
			addCriterion("BUILD_UNIT like", value, "buildUnit");
			return (Criteria) this;
		}

		public Criteria andBuildUnitNotLike(String value) {
			addCriterion("BUILD_UNIT not like", value, "buildUnit");
			return (Criteria) this;
		}

		public Criteria andBuildUnitIn(List<String> values) {
			addCriterion("BUILD_UNIT in", values, "buildUnit");
			return (Criteria) this;
		}

		public Criteria andBuildUnitNotIn(List<String> values) {
			addCriterion("BUILD_UNIT not in", values, "buildUnit");
			return (Criteria) this;
		}

		public Criteria andBuildUnitBetween(String value1, String value2) {
			addCriterion("BUILD_UNIT between", value1, value2, "buildUnit");
			return (Criteria) this;
		}

		public Criteria andBuildUnitNotBetween(String value1, String value2) {
			addCriterion("BUILD_UNIT not between", value1, value2, "buildUnit");
			return (Criteria) this;
		}

		public Criteria andBuildFloorIsNull() {
			addCriterion("BUILD_FLOOR is null");
			return (Criteria) this;
		}

		public Criteria andBuildFloorIsNotNull() {
			addCriterion("BUILD_FLOOR is not null");
			return (Criteria) this;
		}

		public Criteria andBuildFloorEqualTo(String value) {
			addCriterion("BUILD_FLOOR =", value, "buildFloor");
			return (Criteria) this;
		}

		public Criteria andBuildFloorNotEqualTo(String value) {
			addCriterion("BUILD_FLOOR <>", value, "buildFloor");
			return (Criteria) this;
		}

		public Criteria andBuildFloorGreaterThan(String value) {
			addCriterion("BUILD_FLOOR >", value, "buildFloor");
			return (Criteria) this;
		}

		public Criteria andBuildFloorGreaterThanOrEqualTo(String value) {
			addCriterion("BUILD_FLOOR >=", value, "buildFloor");
			return (Criteria) this;
		}

		public Criteria andBuildFloorLessThan(String value) {
			addCriterion("BUILD_FLOOR <", value, "buildFloor");
			return (Criteria) this;
		}

		public Criteria andBuildFloorLessThanOrEqualTo(String value) {
			addCriterion("BUILD_FLOOR <=", value, "buildFloor");
			return (Criteria) this;
		}

		public Criteria andBuildFloorLike(String value) {
			addCriterion("BUILD_FLOOR like", value, "buildFloor");
			return (Criteria) this;
		}

		public Criteria andBuildFloorNotLike(String value) {
			addCriterion("BUILD_FLOOR not like", value, "buildFloor");
			return (Criteria) this;
		}

		public Criteria andBuildFloorIn(List<String> values) {
			addCriterion("BUILD_FLOOR in", values, "buildFloor");
			return (Criteria) this;
		}

		public Criteria andBuildFloorNotIn(List<String> values) {
			addCriterion("BUILD_FLOOR not in", values, "buildFloor");
			return (Criteria) this;
		}

		public Criteria andBuildFloorBetween(String value1, String value2) {
			addCriterion("BUILD_FLOOR between", value1, value2, "buildFloor");
			return (Criteria) this;
		}

		public Criteria andBuildFloorNotBetween(String value1, String value2) {
			addCriterion("BUILD_FLOOR not between", value1, value2, "buildFloor");
			return (Criteria) this;
		}

		public Criteria andSysBuildFloorIsNull() {
			addCriterion("SYS_BUILD_FLOOR is null");
			return (Criteria) this;
		}

		public Criteria andSysBuildFloorIsNotNull() {
			addCriterion("SYS_BUILD_FLOOR is not null");
			return (Criteria) this;
		}

		public Criteria andSysBuildFloorEqualTo(String value) {
			addCriterion("SYS_BUILD_FLOOR =", value, "sysBuildFloor");
			return (Criteria) this;
		}

		public Criteria andSysBuildFloorNotEqualTo(String value) {
			addCriterion("SYS_BUILD_FLOOR <>", value, "sysBuildFloor");
			return (Criteria) this;
		}

		public Criteria andSysBuildFloorGreaterThan(String value) {
			addCriterion("SYS_BUILD_FLOOR >", value, "sysBuildFloor");
			return (Criteria) this;
		}

		public Criteria andSysBuildFloorGreaterThanOrEqualTo(String value) {
			addCriterion("SYS_BUILD_FLOOR >=", value, "sysBuildFloor");
			return (Criteria) this;
		}

		public Criteria andSysBuildFloorLessThan(String value) {
			addCriterion("SYS_BUILD_FLOOR <", value, "sysBuildFloor");
			return (Criteria) this;
		}

		public Criteria andSysBuildFloorLessThanOrEqualTo(String value) {
			addCriterion("SYS_BUILD_FLOOR <=", value, "sysBuildFloor");
			return (Criteria) this;
		}

		public Criteria andSysBuildFloorLike(String value) {
			addCriterion("SYS_BUILD_FLOOR like", value, "sysBuildFloor");
			return (Criteria) this;
		}

		public Criteria andSysBuildFloorNotLike(String value) {
			addCriterion("SYS_BUILD_FLOOR not like", value, "sysBuildFloor");
			return (Criteria) this;
		}

		public Criteria andSysBuildFloorIn(List<String> values) {
			addCriterion("SYS_BUILD_FLOOR in", values, "sysBuildFloor");
			return (Criteria) this;
		}

		public Criteria andSysBuildFloorNotIn(List<String> values) {
			addCriterion("SYS_BUILD_FLOOR not in", values, "sysBuildFloor");
			return (Criteria) this;
		}

		public Criteria andSysBuildFloorBetween(String value1, String value2) {
			addCriterion("SYS_BUILD_FLOOR between", value1, value2, "sysBuildFloor");
			return (Criteria) this;
		}

		public Criteria andSysBuildFloorNotBetween(String value1, String value2) {
			addCriterion("SYS_BUILD_FLOOR not between", value1, value2, "sysBuildFloor");
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

		public Criteria andBuildingSetRoofIdIsNull() {
			addCriterion("BUILDING_SET_ROOF_ID is null");
			return (Criteria) this;
		}

		public Criteria andBuildingSetRoofIdIsNotNull() {
			addCriterion("BUILDING_SET_ROOF_ID is not null");
			return (Criteria) this;
		}

		public Criteria andBuildingSetRoofIdEqualTo(Integer value) {
			addCriterion("BUILDING_SET_ROOF_ID =", value, "buildingSetRoofId");
			return (Criteria) this;
		}

		public Criteria andBuildingSetRoofIdNotEqualTo(Integer value) {
			addCriterion("BUILDING_SET_ROOF_ID <>", value, "buildingSetRoofId");
			return (Criteria) this;
		}

		public Criteria andBuildingSetRoofIdGreaterThan(Integer value) {
			addCriterion("BUILDING_SET_ROOF_ID >", value, "buildingSetRoofId");
			return (Criteria) this;
		}

		public Criteria andBuildingSetRoofIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("BUILDING_SET_ROOF_ID >=", value, "buildingSetRoofId");
			return (Criteria) this;
		}

		public Criteria andBuildingSetRoofIdLessThan(Integer value) {
			addCriterion("BUILDING_SET_ROOF_ID <", value, "buildingSetRoofId");
			return (Criteria) this;
		}

		public Criteria andBuildingSetRoofIdLessThanOrEqualTo(Integer value) {
			addCriterion("BUILDING_SET_ROOF_ID <=", value, "buildingSetRoofId");
			return (Criteria) this;
		}

		public Criteria andBuildingSetRoofIdIn(List<Integer> values) {
			addCriterion("BUILDING_SET_ROOF_ID in", values, "buildingSetRoofId");
			return (Criteria) this;
		}

		public Criteria andBuildingSetRoofIdNotIn(List<Integer> values) {
			addCriterion("BUILDING_SET_ROOF_ID not in", values, "buildingSetRoofId");
			return (Criteria) this;
		}

		public Criteria andBuildingSetRoofIdBetween(Integer value1, Integer value2) {
			addCriterion("BUILDING_SET_ROOF_ID between", value1, value2, "buildingSetRoofId");
			return (Criteria) this;
		}

		public Criteria andBuildingSetRoofIdNotBetween(Integer value1, Integer value2) {
			addCriterion("BUILDING_SET_ROOF_ID not between", value1, value2, "buildingSetRoofId");
			return (Criteria) this;
		}

		public Criteria andBuildingSetUnitIdIsNull() {
			addCriterion("BUILDING_SET_UNIT_ID is null");
			return (Criteria) this;
		}

		public Criteria andBuildingSetUnitIdIsNotNull() {
			addCriterion("BUILDING_SET_UNIT_ID is not null");
			return (Criteria) this;
		}

		public Criteria andBuildingSetUnitIdEqualTo(Integer value) {
			addCriterion("BUILDING_SET_UNIT_ID =", value, "buildingSetUnitId");
			return (Criteria) this;
		}

		public Criteria andBuildingSetUnitIdNotEqualTo(Integer value) {
			addCriterion("BUILDING_SET_UNIT_ID <>", value, "buildingSetUnitId");
			return (Criteria) this;
		}

		public Criteria andBuildingSetUnitIdGreaterThan(Integer value) {
			addCriterion("BUILDING_SET_UNIT_ID >", value, "buildingSetUnitId");
			return (Criteria) this;
		}

		public Criteria andBuildingSetUnitIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("BUILDING_SET_UNIT_ID >=", value, "buildingSetUnitId");
			return (Criteria) this;
		}

		public Criteria andBuildingSetUnitIdLessThan(Integer value) {
			addCriterion("BUILDING_SET_UNIT_ID <", value, "buildingSetUnitId");
			return (Criteria) this;
		}

		public Criteria andBuildingSetUnitIdLessThanOrEqualTo(Integer value) {
			addCriterion("BUILDING_SET_UNIT_ID <=", value, "buildingSetUnitId");
			return (Criteria) this;
		}

		public Criteria andBuildingSetUnitIdIn(List<Integer> values) {
			addCriterion("BUILDING_SET_UNIT_ID in", values, "buildingSetUnitId");
			return (Criteria) this;
		}

		public Criteria andBuildingSetUnitIdNotIn(List<Integer> values) {
			addCriterion("BUILDING_SET_UNIT_ID not in", values, "buildingSetUnitId");
			return (Criteria) this;
		}

		public Criteria andBuildingSetUnitIdBetween(Integer value1, Integer value2) {
			addCriterion("BUILDING_SET_UNIT_ID between", value1, value2, "buildingSetUnitId");
			return (Criteria) this;
		}

		public Criteria andBuildingSetUnitIdNotBetween(Integer value1, Integer value2) {
			addCriterion("BUILDING_SET_UNIT_ID not between", value1, value2, "buildingSetUnitId");
			return (Criteria) this;
		}

		public Criteria andFloorUseageIsNull() {
			addCriterion("FLOOR_USEAGE is null");
			return (Criteria) this;
		}

		public Criteria andFloorUseageIsNotNull() {
			addCriterion("FLOOR_USEAGE is not null");
			return (Criteria) this;
		}

		public Criteria andFloorUseageEqualTo(Integer value) {
			addCriterion("FLOOR_USEAGE =", value, "floorUseage");
			return (Criteria) this;
		}

		public Criteria andFloorUseageNotEqualTo(Integer value) {
			addCriterion("FLOOR_USEAGE <>", value, "floorUseage");
			return (Criteria) this;
		}

		public Criteria andFloorUseageGreaterThan(Integer value) {
			addCriterion("FLOOR_USEAGE >", value, "floorUseage");
			return (Criteria) this;
		}

		public Criteria andFloorUseageGreaterThanOrEqualTo(Integer value) {
			addCriterion("FLOOR_USEAGE >=", value, "floorUseage");
			return (Criteria) this;
		}

		public Criteria andFloorUseageLessThan(Integer value) {
			addCriterion("FLOOR_USEAGE <", value, "floorUseage");
			return (Criteria) this;
		}

		public Criteria andFloorUseageLessThanOrEqualTo(Integer value) {
			addCriterion("FLOOR_USEAGE <=", value, "floorUseage");
			return (Criteria) this;
		}

		public Criteria andFloorUseageIn(List<Integer> values) {
			addCriterion("FLOOR_USEAGE in", values, "floorUseage");
			return (Criteria) this;
		}

		public Criteria andFloorUseageNotIn(List<Integer> values) {
			addCriterion("FLOOR_USEAGE not in", values, "floorUseage");
			return (Criteria) this;
		}

		public Criteria andFloorUseageBetween(Integer value1, Integer value2) {
			addCriterion("FLOOR_USEAGE between", value1, value2, "floorUseage");
			return (Criteria) this;
		}

		public Criteria andFloorUseageNotBetween(Integer value1, Integer value2) {
			addCriterion("FLOOR_USEAGE not between", value1, value2, "floorUseage");
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

		public Criteria andDelFlagEqualTo(Byte value) {
			addCriterion("DEL_FLAG =", value, "delFlag");
			return (Criteria) this;
		}

		public Criteria andDelFlagNotEqualTo(Byte value) {
			addCriterion("DEL_FLAG <>", value, "delFlag");
			return (Criteria) this;
		}

		public Criteria andDelFlagGreaterThan(Byte value) {
			addCriterion("DEL_FLAG >", value, "delFlag");
			return (Criteria) this;
		}

		public Criteria andDelFlagGreaterThanOrEqualTo(Byte value) {
			addCriterion("DEL_FLAG >=", value, "delFlag");
			return (Criteria) this;
		}

		public Criteria andDelFlagLessThan(Byte value) {
			addCriterion("DEL_FLAG <", value, "delFlag");
			return (Criteria) this;
		}

		public Criteria andDelFlagLessThanOrEqualTo(Byte value) {
			addCriterion("DEL_FLAG <=", value, "delFlag");
			return (Criteria) this;
		}

		public Criteria andDelFlagIn(List<Byte> values) {
			addCriterion("DEL_FLAG in", values, "delFlag");
			return (Criteria) this;
		}

		public Criteria andDelFlagNotIn(List<Byte> values) {
			addCriterion("DEL_FLAG not in", values, "delFlag");
			return (Criteria) this;
		}

		public Criteria andDelFlagBetween(Byte value1, Byte value2) {
			addCriterion("DEL_FLAG between", value1, value2, "delFlag");
			return (Criteria) this;
		}

		public Criteria andDelFlagNotBetween(Byte value1, Byte value2) {
			addCriterion("DEL_FLAG not between", value1, value2, "delFlag");
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