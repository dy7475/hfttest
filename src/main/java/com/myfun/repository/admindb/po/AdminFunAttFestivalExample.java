package com.myfun.repository.admindb.po;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AdminFunAttFestivalExample {
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
	public AdminFunAttFestivalExample() {
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

		public Criteria andFestivalIdIsNull() {
			addCriterion("FESTIVAL_ID is null");
			return (Criteria) this;
		}

		public Criteria andFestivalIdIsNotNull() {
			addCriterion("FESTIVAL_ID is not null");
			return (Criteria) this;
		}

		public Criteria andFestivalIdEqualTo(Integer value) {
			addCriterion("FESTIVAL_ID =", value, "festivalId");
			return (Criteria) this;
		}

		public Criteria andFestivalIdNotEqualTo(Integer value) {
			addCriterion("FESTIVAL_ID <>", value, "festivalId");
			return (Criteria) this;
		}

		public Criteria andFestivalIdGreaterThan(Integer value) {
			addCriterion("FESTIVAL_ID >", value, "festivalId");
			return (Criteria) this;
		}

		public Criteria andFestivalIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("FESTIVAL_ID >=", value, "festivalId");
			return (Criteria) this;
		}

		public Criteria andFestivalIdLessThan(Integer value) {
			addCriterion("FESTIVAL_ID <", value, "festivalId");
			return (Criteria) this;
		}

		public Criteria andFestivalIdLessThanOrEqualTo(Integer value) {
			addCriterion("FESTIVAL_ID <=", value, "festivalId");
			return (Criteria) this;
		}

		public Criteria andFestivalIdIn(List<Integer> values) {
			addCriterion("FESTIVAL_ID in", values, "festivalId");
			return (Criteria) this;
		}

		public Criteria andFestivalIdNotIn(List<Integer> values) {
			addCriterion("FESTIVAL_ID not in", values, "festivalId");
			return (Criteria) this;
		}

		public Criteria andFestivalIdBetween(Integer value1, Integer value2) {
			addCriterion("FESTIVAL_ID between", value1, value2, "festivalId");
			return (Criteria) this;
		}

		public Criteria andFestivalIdNotBetween(Integer value1, Integer value2) {
			addCriterion("FESTIVAL_ID not between", value1, value2, "festivalId");
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

		public Criteria andFestivalStartTimeIsNull() {
			addCriterion("FESTIVAL_START_TIME is null");
			return (Criteria) this;
		}

		public Criteria andFestivalStartTimeIsNotNull() {
			addCriterion("FESTIVAL_START_TIME is not null");
			return (Criteria) this;
		}

		public Criteria andFestivalStartTimeEqualTo(Date value) {
			addCriterion("FESTIVAL_START_TIME =", value, "festivalStartTime");
			return (Criteria) this;
		}

		public Criteria andFestivalStartTimeNotEqualTo(Date value) {
			addCriterion("FESTIVAL_START_TIME <>", value, "festivalStartTime");
			return (Criteria) this;
		}

		public Criteria andFestivalStartTimeGreaterThan(Date value) {
			addCriterion("FESTIVAL_START_TIME >", value, "festivalStartTime");
			return (Criteria) this;
		}

		public Criteria andFestivalStartTimeGreaterThanOrEqualTo(Date value) {
			addCriterion("FESTIVAL_START_TIME >=", value, "festivalStartTime");
			return (Criteria) this;
		}

		public Criteria andFestivalStartTimeLessThan(Date value) {
			addCriterion("FESTIVAL_START_TIME <", value, "festivalStartTime");
			return (Criteria) this;
		}

		public Criteria andFestivalStartTimeLessThanOrEqualTo(Date value) {
			addCriterion("FESTIVAL_START_TIME <=", value, "festivalStartTime");
			return (Criteria) this;
		}

		public Criteria andFestivalStartTimeIn(List<Date> values) {
			addCriterion("FESTIVAL_START_TIME in", values, "festivalStartTime");
			return (Criteria) this;
		}

		public Criteria andFestivalStartTimeNotIn(List<Date> values) {
			addCriterion("FESTIVAL_START_TIME not in", values, "festivalStartTime");
			return (Criteria) this;
		}

		public Criteria andFestivalStartTimeBetween(Date value1, Date value2) {
			addCriterion("FESTIVAL_START_TIME between", value1, value2, "festivalStartTime");
			return (Criteria) this;
		}

		public Criteria andFestivalStartTimeNotBetween(Date value1, Date value2) {
			addCriterion("FESTIVAL_START_TIME not between", value1, value2, "festivalStartTime");
			return (Criteria) this;
		}

		public Criteria andFestivalEndTimeIsNull() {
			addCriterion("FESTIVAL_END_TIME is null");
			return (Criteria) this;
		}

		public Criteria andFestivalEndTimeIsNotNull() {
			addCriterion("FESTIVAL_END_TIME is not null");
			return (Criteria) this;
		}

		public Criteria andFestivalEndTimeEqualTo(Date value) {
			addCriterion("FESTIVAL_END_TIME =", value, "festivalEndTime");
			return (Criteria) this;
		}

		public Criteria andFestivalEndTimeNotEqualTo(Date value) {
			addCriterion("FESTIVAL_END_TIME <>", value, "festivalEndTime");
			return (Criteria) this;
		}

		public Criteria andFestivalEndTimeGreaterThan(Date value) {
			addCriterion("FESTIVAL_END_TIME >", value, "festivalEndTime");
			return (Criteria) this;
		}

		public Criteria andFestivalEndTimeGreaterThanOrEqualTo(Date value) {
			addCriterion("FESTIVAL_END_TIME >=", value, "festivalEndTime");
			return (Criteria) this;
		}

		public Criteria andFestivalEndTimeLessThan(Date value) {
			addCriterion("FESTIVAL_END_TIME <", value, "festivalEndTime");
			return (Criteria) this;
		}

		public Criteria andFestivalEndTimeLessThanOrEqualTo(Date value) {
			addCriterion("FESTIVAL_END_TIME <=", value, "festivalEndTime");
			return (Criteria) this;
		}

		public Criteria andFestivalEndTimeIn(List<Date> values) {
			addCriterion("FESTIVAL_END_TIME in", values, "festivalEndTime");
			return (Criteria) this;
		}

		public Criteria andFestivalEndTimeNotIn(List<Date> values) {
			addCriterion("FESTIVAL_END_TIME not in", values, "festivalEndTime");
			return (Criteria) this;
		}

		public Criteria andFestivalEndTimeBetween(Date value1, Date value2) {
			addCriterion("FESTIVAL_END_TIME between", value1, value2, "festivalEndTime");
			return (Criteria) this;
		}

		public Criteria andFestivalEndTimeNotBetween(Date value1, Date value2) {
			addCriterion("FESTIVAL_END_TIME not between", value1, value2, "festivalEndTime");
			return (Criteria) this;
		}

		public Criteria andCrmUserIdIsNull() {
			addCriterion("CRM_USER_ID is null");
			return (Criteria) this;
		}

		public Criteria andCrmUserIdIsNotNull() {
			addCriterion("CRM_USER_ID is not null");
			return (Criteria) this;
		}

		public Criteria andCrmUserIdEqualTo(Integer value) {
			addCriterion("CRM_USER_ID =", value, "crmUserId");
			return (Criteria) this;
		}

		public Criteria andCrmUserIdNotEqualTo(Integer value) {
			addCriterion("CRM_USER_ID <>", value, "crmUserId");
			return (Criteria) this;
		}

		public Criteria andCrmUserIdGreaterThan(Integer value) {
			addCriterion("CRM_USER_ID >", value, "crmUserId");
			return (Criteria) this;
		}

		public Criteria andCrmUserIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("CRM_USER_ID >=", value, "crmUserId");
			return (Criteria) this;
		}

		public Criteria andCrmUserIdLessThan(Integer value) {
			addCriterion("CRM_USER_ID <", value, "crmUserId");
			return (Criteria) this;
		}

		public Criteria andCrmUserIdLessThanOrEqualTo(Integer value) {
			addCriterion("CRM_USER_ID <=", value, "crmUserId");
			return (Criteria) this;
		}

		public Criteria andCrmUserIdIn(List<Integer> values) {
			addCriterion("CRM_USER_ID in", values, "crmUserId");
			return (Criteria) this;
		}

		public Criteria andCrmUserIdNotIn(List<Integer> values) {
			addCriterion("CRM_USER_ID not in", values, "crmUserId");
			return (Criteria) this;
		}

		public Criteria andCrmUserIdBetween(Integer value1, Integer value2) {
			addCriterion("CRM_USER_ID between", value1, value2, "crmUserId");
			return (Criteria) this;
		}

		public Criteria andCrmUserIdNotBetween(Integer value1, Integer value2) {
			addCriterion("CRM_USER_ID not between", value1, value2, "crmUserId");
			return (Criteria) this;
		}

		public Criteria andFestivalTypeIsNull() {
			addCriterion("FESTIVAL_TYPE is null");
			return (Criteria) this;
		}

		public Criteria andFestivalTypeIsNotNull() {
			addCriterion("FESTIVAL_TYPE is not null");
			return (Criteria) this;
		}

		public Criteria andFestivalTypeEqualTo(Byte value) {
			addCriterion("FESTIVAL_TYPE =", value, "festivalType");
			return (Criteria) this;
		}

		public Criteria andFestivalTypeNotEqualTo(Byte value) {
			addCriterion("FESTIVAL_TYPE <>", value, "festivalType");
			return (Criteria) this;
		}

		public Criteria andFestivalTypeGreaterThan(Byte value) {
			addCriterion("FESTIVAL_TYPE >", value, "festivalType");
			return (Criteria) this;
		}

		public Criteria andFestivalTypeGreaterThanOrEqualTo(Byte value) {
			addCriterion("FESTIVAL_TYPE >=", value, "festivalType");
			return (Criteria) this;
		}

		public Criteria andFestivalTypeLessThan(Byte value) {
			addCriterion("FESTIVAL_TYPE <", value, "festivalType");
			return (Criteria) this;
		}

		public Criteria andFestivalTypeLessThanOrEqualTo(Byte value) {
			addCriterion("FESTIVAL_TYPE <=", value, "festivalType");
			return (Criteria) this;
		}

		public Criteria andFestivalTypeIn(List<Byte> values) {
			addCriterion("FESTIVAL_TYPE in", values, "festivalType");
			return (Criteria) this;
		}

		public Criteria andFestivalTypeNotIn(List<Byte> values) {
			addCriterion("FESTIVAL_TYPE not in", values, "festivalType");
			return (Criteria) this;
		}

		public Criteria andFestivalTypeBetween(Byte value1, Byte value2) {
			addCriterion("FESTIVAL_TYPE between", value1, value2, "festivalType");
			return (Criteria) this;
		}

		public Criteria andFestivalTypeNotBetween(Byte value1, Byte value2) {
			addCriterion("FESTIVAL_TYPE not between", value1, value2, "festivalType");
			return (Criteria) this;
		}

		public Criteria andYearTimeIsNull() {
			addCriterion("YEAR_TIME is null");
			return (Criteria) this;
		}

		public Criteria andYearTimeIsNotNull() {
			addCriterion("YEAR_TIME is not null");
			return (Criteria) this;
		}

		public Criteria andYearTimeEqualTo(Date value) {
			addCriterion("YEAR_TIME =", value, "yearTime");
			return (Criteria) this;
		}

		public Criteria andYearTimeNotEqualTo(Date value) {
			addCriterion("YEAR_TIME <>", value, "yearTime");
			return (Criteria) this;
		}

		public Criteria andYearTimeGreaterThan(Date value) {
			addCriterion("YEAR_TIME >", value, "yearTime");
			return (Criteria) this;
		}

		public Criteria andYearTimeGreaterThanOrEqualTo(Date value) {
			addCriterion("YEAR_TIME >=", value, "yearTime");
			return (Criteria) this;
		}

		public Criteria andYearTimeLessThan(Date value) {
			addCriterion("YEAR_TIME <", value, "yearTime");
			return (Criteria) this;
		}

		public Criteria andYearTimeLessThanOrEqualTo(Date value) {
			addCriterion("YEAR_TIME <=", value, "yearTime");
			return (Criteria) this;
		}

		public Criteria andYearTimeIn(List<Date> values) {
			addCriterion("YEAR_TIME in", values, "yearTime");
			return (Criteria) this;
		}

		public Criteria andYearTimeNotIn(List<Date> values) {
			addCriterion("YEAR_TIME not in", values, "yearTime");
			return (Criteria) this;
		}

		public Criteria andYearTimeBetween(Date value1, Date value2) {
			addCriterion("YEAR_TIME between", value1, value2, "yearTime");
			return (Criteria) this;
		}

		public Criteria andYearTimeNotBetween(Date value1, Date value2) {
			addCriterion("YEAR_TIME not between", value1, value2, "yearTime");
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