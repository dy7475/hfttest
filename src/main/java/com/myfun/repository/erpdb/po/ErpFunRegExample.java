package com.myfun.repository.erpdb.po;

import com.myfun.repository.support.generator.shard.ShardDb;
import java.util.ArrayList;
import java.util.List;

public class ErpFunRegExample extends ShardDb {
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
	public ErpFunRegExample() {
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

		public Criteria andRegIdIsNull() {
			addCriterion("REG_ID is null");
			return (Criteria) this;
		}

		public Criteria andRegIdIsNotNull() {
			addCriterion("REG_ID is not null");
			return (Criteria) this;
		}

		public Criteria andRegIdEqualTo(Integer value) {
			addCriterion("REG_ID =", value, "regId");
			return (Criteria) this;
		}

		public Criteria andRegIdNotEqualTo(Integer value) {
			addCriterion("REG_ID <>", value, "regId");
			return (Criteria) this;
		}

		public Criteria andRegIdGreaterThan(Integer value) {
			addCriterion("REG_ID >", value, "regId");
			return (Criteria) this;
		}

		public Criteria andRegIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("REG_ID >=", value, "regId");
			return (Criteria) this;
		}

		public Criteria andRegIdLessThan(Integer value) {
			addCriterion("REG_ID <", value, "regId");
			return (Criteria) this;
		}

		public Criteria andRegIdLessThanOrEqualTo(Integer value) {
			addCriterion("REG_ID <=", value, "regId");
			return (Criteria) this;
		}

		public Criteria andRegIdIn(List<Integer> values) {
			addCriterion("REG_ID in", values, "regId");
			return (Criteria) this;
		}

		public Criteria andRegIdNotIn(List<Integer> values) {
			addCriterion("REG_ID not in", values, "regId");
			return (Criteria) this;
		}

		public Criteria andRegIdBetween(Integer value1, Integer value2) {
			addCriterion("REG_ID between", value1, value2, "regId");
			return (Criteria) this;
		}

		public Criteria andRegIdNotBetween(Integer value1, Integer value2) {
			addCriterion("REG_ID not between", value1, value2, "regId");
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

		public Criteria andRegNameIsNull() {
			addCriterion("REG_NAME is null");
			return (Criteria) this;
		}

		public Criteria andRegNameIsNotNull() {
			addCriterion("REG_NAME is not null");
			return (Criteria) this;
		}

		public Criteria andRegNameEqualTo(String value) {
			addCriterion("REG_NAME =", value, "regName");
			return (Criteria) this;
		}

		public Criteria andRegNameNotEqualTo(String value) {
			addCriterion("REG_NAME <>", value, "regName");
			return (Criteria) this;
		}

		public Criteria andRegNameGreaterThan(String value) {
			addCriterion("REG_NAME >", value, "regName");
			return (Criteria) this;
		}

		public Criteria andRegNameGreaterThanOrEqualTo(String value) {
			addCriterion("REG_NAME >=", value, "regName");
			return (Criteria) this;
		}

		public Criteria andRegNameLessThan(String value) {
			addCriterion("REG_NAME <", value, "regName");
			return (Criteria) this;
		}

		public Criteria andRegNameLessThanOrEqualTo(String value) {
			addCriterion("REG_NAME <=", value, "regName");
			return (Criteria) this;
		}

		public Criteria andRegNameLike(String value) {
			addCriterion("REG_NAME like", value, "regName");
			return (Criteria) this;
		}

		public Criteria andRegNameNotLike(String value) {
			addCriterion("REG_NAME not like", value, "regName");
			return (Criteria) this;
		}

		public Criteria andRegNameIn(List<String> values) {
			addCriterion("REG_NAME in", values, "regName");
			return (Criteria) this;
		}

		public Criteria andRegNameNotIn(List<String> values) {
			addCriterion("REG_NAME not in", values, "regName");
			return (Criteria) this;
		}

		public Criteria andRegNameBetween(String value1, String value2) {
			addCriterion("REG_NAME between", value1, value2, "regName");
			return (Criteria) this;
		}

		public Criteria andRegNameNotBetween(String value1, String value2) {
			addCriterion("REG_NAME not between", value1, value2, "regName");
			return (Criteria) this;
		}

		public Criteria andSeqNoIsNull() {
			addCriterion("SEQ_NO is null");
			return (Criteria) this;
		}

		public Criteria andSeqNoIsNotNull() {
			addCriterion("SEQ_NO is not null");
			return (Criteria) this;
		}

		public Criteria andSeqNoEqualTo(Byte value) {
			addCriterion("SEQ_NO =", value, "seqNo");
			return (Criteria) this;
		}

		public Criteria andSeqNoNotEqualTo(Byte value) {
			addCriterion("SEQ_NO <>", value, "seqNo");
			return (Criteria) this;
		}

		public Criteria andSeqNoGreaterThan(Byte value) {
			addCriterion("SEQ_NO >", value, "seqNo");
			return (Criteria) this;
		}

		public Criteria andSeqNoGreaterThanOrEqualTo(Byte value) {
			addCriterion("SEQ_NO >=", value, "seqNo");
			return (Criteria) this;
		}

		public Criteria andSeqNoLessThan(Byte value) {
			addCriterion("SEQ_NO <", value, "seqNo");
			return (Criteria) this;
		}

		public Criteria andSeqNoLessThanOrEqualTo(Byte value) {
			addCriterion("SEQ_NO <=", value, "seqNo");
			return (Criteria) this;
		}

		public Criteria andSeqNoIn(List<Byte> values) {
			addCriterion("SEQ_NO in", values, "seqNo");
			return (Criteria) this;
		}

		public Criteria andSeqNoNotIn(List<Byte> values) {
			addCriterion("SEQ_NO not in", values, "seqNo");
			return (Criteria) this;
		}

		public Criteria andSeqNoBetween(Byte value1, Byte value2) {
			addCriterion("SEQ_NO between", value1, value2, "seqNo");
			return (Criteria) this;
		}

		public Criteria andSeqNoNotBetween(Byte value1, Byte value2) {
			addCriterion("SEQ_NO not between", value1, value2, "seqNo");
			return (Criteria) this;
		}

		public Criteria andMainRegIsNull() {
			addCriterion("MAIN_REG is null");
			return (Criteria) this;
		}

		public Criteria andMainRegIsNotNull() {
			addCriterion("MAIN_REG is not null");
			return (Criteria) this;
		}

		public Criteria andMainRegEqualTo(Byte value) {
			addCriterion("MAIN_REG =", value, "mainReg");
			return (Criteria) this;
		}

		public Criteria andMainRegNotEqualTo(Byte value) {
			addCriterion("MAIN_REG <>", value, "mainReg");
			return (Criteria) this;
		}

		public Criteria andMainRegGreaterThan(Byte value) {
			addCriterion("MAIN_REG >", value, "mainReg");
			return (Criteria) this;
		}

		public Criteria andMainRegGreaterThanOrEqualTo(Byte value) {
			addCriterion("MAIN_REG >=", value, "mainReg");
			return (Criteria) this;
		}

		public Criteria andMainRegLessThan(Byte value) {
			addCriterion("MAIN_REG <", value, "mainReg");
			return (Criteria) this;
		}

		public Criteria andMainRegLessThanOrEqualTo(Byte value) {
			addCriterion("MAIN_REG <=", value, "mainReg");
			return (Criteria) this;
		}

		public Criteria andMainRegIn(List<Byte> values) {
			addCriterion("MAIN_REG in", values, "mainReg");
			return (Criteria) this;
		}

		public Criteria andMainRegNotIn(List<Byte> values) {
			addCriterion("MAIN_REG not in", values, "mainReg");
			return (Criteria) this;
		}

		public Criteria andMainRegBetween(Byte value1, Byte value2) {
			addCriterion("MAIN_REG between", value1, value2, "mainReg");
			return (Criteria) this;
		}

		public Criteria andMainRegNotBetween(Byte value1, Byte value2) {
			addCriterion("MAIN_REG not between", value1, value2, "mainReg");
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

		public Criteria andVertifyFlagEqualTo(Byte value) {
			addCriterion("VERTIFY_FLAG =", value, "vertifyFlag");
			return (Criteria) this;
		}

		public Criteria andVertifyFlagNotEqualTo(Byte value) {
			addCriterion("VERTIFY_FLAG <>", value, "vertifyFlag");
			return (Criteria) this;
		}

		public Criteria andVertifyFlagGreaterThan(Byte value) {
			addCriterion("VERTIFY_FLAG >", value, "vertifyFlag");
			return (Criteria) this;
		}

		public Criteria andVertifyFlagGreaterThanOrEqualTo(Byte value) {
			addCriterion("VERTIFY_FLAG >=", value, "vertifyFlag");
			return (Criteria) this;
		}

		public Criteria andVertifyFlagLessThan(Byte value) {
			addCriterion("VERTIFY_FLAG <", value, "vertifyFlag");
			return (Criteria) this;
		}

		public Criteria andVertifyFlagLessThanOrEqualTo(Byte value) {
			addCriterion("VERTIFY_FLAG <=", value, "vertifyFlag");
			return (Criteria) this;
		}

		public Criteria andVertifyFlagIn(List<Byte> values) {
			addCriterion("VERTIFY_FLAG in", values, "vertifyFlag");
			return (Criteria) this;
		}

		public Criteria andVertifyFlagNotIn(List<Byte> values) {
			addCriterion("VERTIFY_FLAG not in", values, "vertifyFlag");
			return (Criteria) this;
		}

		public Criteria andVertifyFlagBetween(Byte value1, Byte value2) {
			addCriterion("VERTIFY_FLAG between", value1, value2, "vertifyFlag");
			return (Criteria) this;
		}

		public Criteria andVertifyFlagNotBetween(Byte value1, Byte value2) {
			addCriterion("VERTIFY_FLAG not between", value1, value2, "vertifyFlag");
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