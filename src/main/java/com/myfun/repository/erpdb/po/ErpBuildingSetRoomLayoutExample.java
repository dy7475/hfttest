package com.myfun.repository.erpdb.po;

import com.myfun.repository.support.generator.shard.ShardDb;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ErpBuildingSetRoomLayoutExample extends ShardDb {
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
	public ErpBuildingSetRoomLayoutExample() {
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

		public Criteria andBuildingSetRoomIdIsNull() {
			addCriterion("BUILDING_SET_ROOM_ID is null");
			return (Criteria) this;
		}

		public Criteria andBuildingSetRoomIdIsNotNull() {
			addCriterion("BUILDING_SET_ROOM_ID is not null");
			return (Criteria) this;
		}

		public Criteria andBuildingSetRoomIdEqualTo(Integer value) {
			addCriterion("BUILDING_SET_ROOM_ID =", value, "buildingSetRoomId");
			return (Criteria) this;
		}

		public Criteria andBuildingSetRoomIdNotEqualTo(Integer value) {
			addCriterion("BUILDING_SET_ROOM_ID <>", value, "buildingSetRoomId");
			return (Criteria) this;
		}

		public Criteria andBuildingSetRoomIdGreaterThan(Integer value) {
			addCriterion("BUILDING_SET_ROOM_ID >", value, "buildingSetRoomId");
			return (Criteria) this;
		}

		public Criteria andBuildingSetRoomIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("BUILDING_SET_ROOM_ID >=", value, "buildingSetRoomId");
			return (Criteria) this;
		}

		public Criteria andBuildingSetRoomIdLessThan(Integer value) {
			addCriterion("BUILDING_SET_ROOM_ID <", value, "buildingSetRoomId");
			return (Criteria) this;
		}

		public Criteria andBuildingSetRoomIdLessThanOrEqualTo(Integer value) {
			addCriterion("BUILDING_SET_ROOM_ID <=", value, "buildingSetRoomId");
			return (Criteria) this;
		}

		public Criteria andBuildingSetRoomIdIn(List<Integer> values) {
			addCriterion("BUILDING_SET_ROOM_ID in", values, "buildingSetRoomId");
			return (Criteria) this;
		}

		public Criteria andBuildingSetRoomIdNotIn(List<Integer> values) {
			addCriterion("BUILDING_SET_ROOM_ID not in", values, "buildingSetRoomId");
			return (Criteria) this;
		}

		public Criteria andBuildingSetRoomIdBetween(Integer value1, Integer value2) {
			addCriterion("BUILDING_SET_ROOM_ID between", value1, value2, "buildingSetRoomId");
			return (Criteria) this;
		}

		public Criteria andBuildingSetRoomIdNotBetween(Integer value1, Integer value2) {
			addCriterion("BUILDING_SET_ROOM_ID not between", value1, value2, "buildingSetRoomId");
			return (Criteria) this;
		}

		public Criteria andCreatedTimeIsNull() {
			addCriterion("CREATED_TIME is null");
			return (Criteria) this;
		}

		public Criteria andCreatedTimeIsNotNull() {
			addCriterion("CREATED_TIME is not null");
			return (Criteria) this;
		}

		public Criteria andCreatedTimeEqualTo(Date value) {
			addCriterion("CREATED_TIME =", value, "createdTime");
			return (Criteria) this;
		}

		public Criteria andCreatedTimeNotEqualTo(Date value) {
			addCriterion("CREATED_TIME <>", value, "createdTime");
			return (Criteria) this;
		}

		public Criteria andCreatedTimeGreaterThan(Date value) {
			addCriterion("CREATED_TIME >", value, "createdTime");
			return (Criteria) this;
		}

		public Criteria andCreatedTimeGreaterThanOrEqualTo(Date value) {
			addCriterion("CREATED_TIME >=", value, "createdTime");
			return (Criteria) this;
		}

		public Criteria andCreatedTimeLessThan(Date value) {
			addCriterion("CREATED_TIME <", value, "createdTime");
			return (Criteria) this;
		}

		public Criteria andCreatedTimeLessThanOrEqualTo(Date value) {
			addCriterion("CREATED_TIME <=", value, "createdTime");
			return (Criteria) this;
		}

		public Criteria andCreatedTimeIn(List<Date> values) {
			addCriterion("CREATED_TIME in", values, "createdTime");
			return (Criteria) this;
		}

		public Criteria andCreatedTimeNotIn(List<Date> values) {
			addCriterion("CREATED_TIME not in", values, "createdTime");
			return (Criteria) this;
		}

		public Criteria andCreatedTimeBetween(Date value1, Date value2) {
			addCriterion("CREATED_TIME between", value1, value2, "createdTime");
			return (Criteria) this;
		}

		public Criteria andCreatedTimeNotBetween(Date value1, Date value2) {
			addCriterion("CREATED_TIME not between", value1, value2, "createdTime");
			return (Criteria) this;
		}

		public Criteria andLayoutUrlIsNull() {
			addCriterion("LAYOUT_URL is null");
			return (Criteria) this;
		}

		public Criteria andLayoutUrlIsNotNull() {
			addCriterion("LAYOUT_URL is not null");
			return (Criteria) this;
		}

		public Criteria andLayoutUrlEqualTo(String value) {
			addCriterion("LAYOUT_URL =", value, "layoutUrl");
			return (Criteria) this;
		}

		public Criteria andLayoutUrlNotEqualTo(String value) {
			addCriterion("LAYOUT_URL <>", value, "layoutUrl");
			return (Criteria) this;
		}

		public Criteria andLayoutUrlGreaterThan(String value) {
			addCriterion("LAYOUT_URL >", value, "layoutUrl");
			return (Criteria) this;
		}

		public Criteria andLayoutUrlGreaterThanOrEqualTo(String value) {
			addCriterion("LAYOUT_URL >=", value, "layoutUrl");
			return (Criteria) this;
		}

		public Criteria andLayoutUrlLessThan(String value) {
			addCriterion("LAYOUT_URL <", value, "layoutUrl");
			return (Criteria) this;
		}

		public Criteria andLayoutUrlLessThanOrEqualTo(String value) {
			addCriterion("LAYOUT_URL <=", value, "layoutUrl");
			return (Criteria) this;
		}

		public Criteria andLayoutUrlLike(String value) {
			addCriterion("LAYOUT_URL like", value, "layoutUrl");
			return (Criteria) this;
		}

		public Criteria andLayoutUrlNotLike(String value) {
			addCriterion("LAYOUT_URL not like", value, "layoutUrl");
			return (Criteria) this;
		}

		public Criteria andLayoutUrlIn(List<String> values) {
			addCriterion("LAYOUT_URL in", values, "layoutUrl");
			return (Criteria) this;
		}

		public Criteria andLayoutUrlNotIn(List<String> values) {
			addCriterion("LAYOUT_URL not in", values, "layoutUrl");
			return (Criteria) this;
		}

		public Criteria andLayoutUrlBetween(String value1, String value2) {
			addCriterion("LAYOUT_URL between", value1, value2, "layoutUrl");
			return (Criteria) this;
		}

		public Criteria andLayoutUrlNotBetween(String value1, String value2) {
			addCriterion("LAYOUT_URL not between", value1, value2, "layoutUrl");
			return (Criteria) this;
		}

		public Criteria andUpdatedTimeIsNull() {
			addCriterion("UPDATED_TIME is null");
			return (Criteria) this;
		}

		public Criteria andUpdatedTimeIsNotNull() {
			addCriterion("UPDATED_TIME is not null");
			return (Criteria) this;
		}

		public Criteria andUpdatedTimeEqualTo(Date value) {
			addCriterion("UPDATED_TIME =", value, "updatedTime");
			return (Criteria) this;
		}

		public Criteria andUpdatedTimeNotEqualTo(Date value) {
			addCriterion("UPDATED_TIME <>", value, "updatedTime");
			return (Criteria) this;
		}

		public Criteria andUpdatedTimeGreaterThan(Date value) {
			addCriterion("UPDATED_TIME >", value, "updatedTime");
			return (Criteria) this;
		}

		public Criteria andUpdatedTimeGreaterThanOrEqualTo(Date value) {
			addCriterion("UPDATED_TIME >=", value, "updatedTime");
			return (Criteria) this;
		}

		public Criteria andUpdatedTimeLessThan(Date value) {
			addCriterion("UPDATED_TIME <", value, "updatedTime");
			return (Criteria) this;
		}

		public Criteria andUpdatedTimeLessThanOrEqualTo(Date value) {
			addCriterion("UPDATED_TIME <=", value, "updatedTime");
			return (Criteria) this;
		}

		public Criteria andUpdatedTimeIn(List<Date> values) {
			addCriterion("UPDATED_TIME in", values, "updatedTime");
			return (Criteria) this;
		}

		public Criteria andUpdatedTimeNotIn(List<Date> values) {
			addCriterion("UPDATED_TIME not in", values, "updatedTime");
			return (Criteria) this;
		}

		public Criteria andUpdatedTimeBetween(Date value1, Date value2) {
			addCriterion("UPDATED_TIME between", value1, value2, "updatedTime");
			return (Criteria) this;
		}

		public Criteria andUpdatedTimeNotBetween(Date value1, Date value2) {
			addCriterion("UPDATED_TIME not between", value1, value2, "updatedTime");
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