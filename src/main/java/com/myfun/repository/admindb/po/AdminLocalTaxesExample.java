package com.myfun.repository.admindb.po;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AdminLocalTaxesExample {
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
	public AdminLocalTaxesExample() {
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

		public Criteria andTaxesIdIsNull() {
			addCriterion("TAXES_ID is null");
			return (Criteria) this;
		}

		public Criteria andTaxesIdIsNotNull() {
			addCriterion("TAXES_ID is not null");
			return (Criteria) this;
		}

		public Criteria andTaxesIdEqualTo(Integer value) {
			addCriterion("TAXES_ID =", value, "taxesId");
			return (Criteria) this;
		}

		public Criteria andTaxesIdNotEqualTo(Integer value) {
			addCriterion("TAXES_ID <>", value, "taxesId");
			return (Criteria) this;
		}

		public Criteria andTaxesIdGreaterThan(Integer value) {
			addCriterion("TAXES_ID >", value, "taxesId");
			return (Criteria) this;
		}

		public Criteria andTaxesIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("TAXES_ID >=", value, "taxesId");
			return (Criteria) this;
		}

		public Criteria andTaxesIdLessThan(Integer value) {
			addCriterion("TAXES_ID <", value, "taxesId");
			return (Criteria) this;
		}

		public Criteria andTaxesIdLessThanOrEqualTo(Integer value) {
			addCriterion("TAXES_ID <=", value, "taxesId");
			return (Criteria) this;
		}

		public Criteria andTaxesIdIn(List<Integer> values) {
			addCriterion("TAXES_ID in", values, "taxesId");
			return (Criteria) this;
		}

		public Criteria andTaxesIdNotIn(List<Integer> values) {
			addCriterion("TAXES_ID not in", values, "taxesId");
			return (Criteria) this;
		}

		public Criteria andTaxesIdBetween(Integer value1, Integer value2) {
			addCriterion("TAXES_ID between", value1, value2, "taxesId");
			return (Criteria) this;
		}

		public Criteria andTaxesIdNotBetween(Integer value1, Integer value2) {
			addCriterion("TAXES_ID not between", value1, value2, "taxesId");
			return (Criteria) this;
		}

		public Criteria andTaxesTypeIsNull() {
			addCriterion("TAXES_TYPE is null");
			return (Criteria) this;
		}

		public Criteria andTaxesTypeIsNotNull() {
			addCriterion("TAXES_TYPE is not null");
			return (Criteria) this;
		}

		public Criteria andTaxesTypeEqualTo(String value) {
			addCriterion("TAXES_TYPE =", value, "taxesType");
			return (Criteria) this;
		}

		public Criteria andTaxesTypeNotEqualTo(String value) {
			addCriterion("TAXES_TYPE <>", value, "taxesType");
			return (Criteria) this;
		}

		public Criteria andTaxesTypeGreaterThan(String value) {
			addCriterion("TAXES_TYPE >", value, "taxesType");
			return (Criteria) this;
		}

		public Criteria andTaxesTypeGreaterThanOrEqualTo(String value) {
			addCriterion("TAXES_TYPE >=", value, "taxesType");
			return (Criteria) this;
		}

		public Criteria andTaxesTypeLessThan(String value) {
			addCriterion("TAXES_TYPE <", value, "taxesType");
			return (Criteria) this;
		}

		public Criteria andTaxesTypeLessThanOrEqualTo(String value) {
			addCriterion("TAXES_TYPE <=", value, "taxesType");
			return (Criteria) this;
		}

		public Criteria andTaxesTypeLike(String value) {
			addCriterion("TAXES_TYPE like", value, "taxesType");
			return (Criteria) this;
		}

		public Criteria andTaxesTypeNotLike(String value) {
			addCriterion("TAXES_TYPE not like", value, "taxesType");
			return (Criteria) this;
		}

		public Criteria andTaxesTypeIn(List<String> values) {
			addCriterion("TAXES_TYPE in", values, "taxesType");
			return (Criteria) this;
		}

		public Criteria andTaxesTypeNotIn(List<String> values) {
			addCriterion("TAXES_TYPE not in", values, "taxesType");
			return (Criteria) this;
		}

		public Criteria andTaxesTypeBetween(String value1, String value2) {
			addCriterion("TAXES_TYPE between", value1, value2, "taxesType");
			return (Criteria) this;
		}

		public Criteria andTaxesTypeNotBetween(String value1, String value2) {
			addCriterion("TAXES_TYPE not between", value1, value2, "taxesType");
			return (Criteria) this;
		}

		public Criteria andBuyProporIsNull() {
			addCriterion("BUY_PROPOR is null");
			return (Criteria) this;
		}

		public Criteria andBuyProporIsNotNull() {
			addCriterion("BUY_PROPOR is not null");
			return (Criteria) this;
		}

		public Criteria andBuyProporEqualTo(Double value) {
			addCriterion("BUY_PROPOR =", value, "buyPropor");
			return (Criteria) this;
		}

		public Criteria andBuyProporNotEqualTo(Double value) {
			addCriterion("BUY_PROPOR <>", value, "buyPropor");
			return (Criteria) this;
		}

		public Criteria andBuyProporGreaterThan(Double value) {
			addCriterion("BUY_PROPOR >", value, "buyPropor");
			return (Criteria) this;
		}

		public Criteria andBuyProporGreaterThanOrEqualTo(Double value) {
			addCriterion("BUY_PROPOR >=", value, "buyPropor");
			return (Criteria) this;
		}

		public Criteria andBuyProporLessThan(Double value) {
			addCriterion("BUY_PROPOR <", value, "buyPropor");
			return (Criteria) this;
		}

		public Criteria andBuyProporLessThanOrEqualTo(Double value) {
			addCriterion("BUY_PROPOR <=", value, "buyPropor");
			return (Criteria) this;
		}

		public Criteria andBuyProporIn(List<Double> values) {
			addCriterion("BUY_PROPOR in", values, "buyPropor");
			return (Criteria) this;
		}

		public Criteria andBuyProporNotIn(List<Double> values) {
			addCriterion("BUY_PROPOR not in", values, "buyPropor");
			return (Criteria) this;
		}

		public Criteria andBuyProporBetween(Double value1, Double value2) {
			addCriterion("BUY_PROPOR between", value1, value2, "buyPropor");
			return (Criteria) this;
		}

		public Criteria andBuyProporNotBetween(Double value1, Double value2) {
			addCriterion("BUY_PROPOR not between", value1, value2, "buyPropor");
			return (Criteria) this;
		}

		public Criteria andSaleProporIsNull() {
			addCriterion("SALE_PROPOR is null");
			return (Criteria) this;
		}

		public Criteria andSaleProporIsNotNull() {
			addCriterion("SALE_PROPOR is not null");
			return (Criteria) this;
		}

		public Criteria andSaleProporEqualTo(Double value) {
			addCriterion("SALE_PROPOR =", value, "salePropor");
			return (Criteria) this;
		}

		public Criteria andSaleProporNotEqualTo(Double value) {
			addCriterion("SALE_PROPOR <>", value, "salePropor");
			return (Criteria) this;
		}

		public Criteria andSaleProporGreaterThan(Double value) {
			addCriterion("SALE_PROPOR >", value, "salePropor");
			return (Criteria) this;
		}

		public Criteria andSaleProporGreaterThanOrEqualTo(Double value) {
			addCriterion("SALE_PROPOR >=", value, "salePropor");
			return (Criteria) this;
		}

		public Criteria andSaleProporLessThan(Double value) {
			addCriterion("SALE_PROPOR <", value, "salePropor");
			return (Criteria) this;
		}

		public Criteria andSaleProporLessThanOrEqualTo(Double value) {
			addCriterion("SALE_PROPOR <=", value, "salePropor");
			return (Criteria) this;
		}

		public Criteria andSaleProporIn(List<Double> values) {
			addCriterion("SALE_PROPOR in", values, "salePropor");
			return (Criteria) this;
		}

		public Criteria andSaleProporNotIn(List<Double> values) {
			addCriterion("SALE_PROPOR not in", values, "salePropor");
			return (Criteria) this;
		}

		public Criteria andSaleProporBetween(Double value1, Double value2) {
			addCriterion("SALE_PROPOR between", value1, value2, "salePropor");
			return (Criteria) this;
		}

		public Criteria andSaleProporNotBetween(Double value1, Double value2) {
			addCriterion("SALE_PROPOR not between", value1, value2, "salePropor");
			return (Criteria) this;
		}

		public Criteria andAreaIsNull() {
			addCriterion("AREA is null");
			return (Criteria) this;
		}

		public Criteria andAreaIsNotNull() {
			addCriterion("AREA is not null");
			return (Criteria) this;
		}

		public Criteria andAreaEqualTo(String value) {
			addCriterion("AREA =", value, "area");
			return (Criteria) this;
		}

		public Criteria andAreaNotEqualTo(String value) {
			addCriterion("AREA <>", value, "area");
			return (Criteria) this;
		}

		public Criteria andAreaGreaterThan(String value) {
			addCriterion("AREA >", value, "area");
			return (Criteria) this;
		}

		public Criteria andAreaGreaterThanOrEqualTo(String value) {
			addCriterion("AREA >=", value, "area");
			return (Criteria) this;
		}

		public Criteria andAreaLessThan(String value) {
			addCriterion("AREA <", value, "area");
			return (Criteria) this;
		}

		public Criteria andAreaLessThanOrEqualTo(String value) {
			addCriterion("AREA <=", value, "area");
			return (Criteria) this;
		}

		public Criteria andAreaLike(String value) {
			addCriterion("AREA like", value, "area");
			return (Criteria) this;
		}

		public Criteria andAreaNotLike(String value) {
			addCriterion("AREA not like", value, "area");
			return (Criteria) this;
		}

		public Criteria andAreaIn(List<String> values) {
			addCriterion("AREA in", values, "area");
			return (Criteria) this;
		}

		public Criteria andAreaNotIn(List<String> values) {
			addCriterion("AREA not in", values, "area");
			return (Criteria) this;
		}

		public Criteria andAreaBetween(String value1, String value2) {
			addCriterion("AREA between", value1, value2, "area");
			return (Criteria) this;
		}

		public Criteria andAreaNotBetween(String value1, String value2) {
			addCriterion("AREA not between", value1, value2, "area");
			return (Criteria) this;
		}

		public Criteria andFunNumIsNull() {
			addCriterion("FUN_NUM is null");
			return (Criteria) this;
		}

		public Criteria andFunNumIsNotNull() {
			addCriterion("FUN_NUM is not null");
			return (Criteria) this;
		}

		public Criteria andFunNumEqualTo(Integer value) {
			addCriterion("FUN_NUM =", value, "funNum");
			return (Criteria) this;
		}

		public Criteria andFunNumNotEqualTo(Integer value) {
			addCriterion("FUN_NUM <>", value, "funNum");
			return (Criteria) this;
		}

		public Criteria andFunNumGreaterThan(Integer value) {
			addCriterion("FUN_NUM >", value, "funNum");
			return (Criteria) this;
		}

		public Criteria andFunNumGreaterThanOrEqualTo(Integer value) {
			addCriterion("FUN_NUM >=", value, "funNum");
			return (Criteria) this;
		}

		public Criteria andFunNumLessThan(Integer value) {
			addCriterion("FUN_NUM <", value, "funNum");
			return (Criteria) this;
		}

		public Criteria andFunNumLessThanOrEqualTo(Integer value) {
			addCriterion("FUN_NUM <=", value, "funNum");
			return (Criteria) this;
		}

		public Criteria andFunNumIn(List<Integer> values) {
			addCriterion("FUN_NUM in", values, "funNum");
			return (Criteria) this;
		}

		public Criteria andFunNumNotIn(List<Integer> values) {
			addCriterion("FUN_NUM not in", values, "funNum");
			return (Criteria) this;
		}

		public Criteria andFunNumBetween(Integer value1, Integer value2) {
			addCriterion("FUN_NUM between", value1, value2, "funNum");
			return (Criteria) this;
		}

		public Criteria andFunNumNotBetween(Integer value1, Integer value2) {
			addCriterion("FUN_NUM not between", value1, value2, "funNum");
			return (Criteria) this;
		}

		public Criteria andBegeneralIsNull() {
			addCriterion("BEGENERAL is null");
			return (Criteria) this;
		}

		public Criteria andBegeneralIsNotNull() {
			addCriterion("BEGENERAL is not null");
			return (Criteria) this;
		}

		public Criteria andBegeneralEqualTo(Integer value) {
			addCriterion("BEGENERAL =", value, "begeneral");
			return (Criteria) this;
		}

		public Criteria andBegeneralNotEqualTo(Integer value) {
			addCriterion("BEGENERAL <>", value, "begeneral");
			return (Criteria) this;
		}

		public Criteria andBegeneralGreaterThan(Integer value) {
			addCriterion("BEGENERAL >", value, "begeneral");
			return (Criteria) this;
		}

		public Criteria andBegeneralGreaterThanOrEqualTo(Integer value) {
			addCriterion("BEGENERAL >=", value, "begeneral");
			return (Criteria) this;
		}

		public Criteria andBegeneralLessThan(Integer value) {
			addCriterion("BEGENERAL <", value, "begeneral");
			return (Criteria) this;
		}

		public Criteria andBegeneralLessThanOrEqualTo(Integer value) {
			addCriterion("BEGENERAL <=", value, "begeneral");
			return (Criteria) this;
		}

		public Criteria andBegeneralIn(List<Integer> values) {
			addCriterion("BEGENERAL in", values, "begeneral");
			return (Criteria) this;
		}

		public Criteria andBegeneralNotIn(List<Integer> values) {
			addCriterion("BEGENERAL not in", values, "begeneral");
			return (Criteria) this;
		}

		public Criteria andBegeneralBetween(Integer value1, Integer value2) {
			addCriterion("BEGENERAL between", value1, value2, "begeneral");
			return (Criteria) this;
		}

		public Criteria andBegeneralNotBetween(Integer value1, Integer value2) {
			addCriterion("BEGENERAL not between", value1, value2, "begeneral");
			return (Criteria) this;
		}

		public Criteria andBeelevatorIsNull() {
			addCriterion("BEELEVATOR is null");
			return (Criteria) this;
		}

		public Criteria andBeelevatorIsNotNull() {
			addCriterion("BEELEVATOR is not null");
			return (Criteria) this;
		}

		public Criteria andBeelevatorEqualTo(Integer value) {
			addCriterion("BEELEVATOR =", value, "beelevator");
			return (Criteria) this;
		}

		public Criteria andBeelevatorNotEqualTo(Integer value) {
			addCriterion("BEELEVATOR <>", value, "beelevator");
			return (Criteria) this;
		}

		public Criteria andBeelevatorGreaterThan(Integer value) {
			addCriterion("BEELEVATOR >", value, "beelevator");
			return (Criteria) this;
		}

		public Criteria andBeelevatorGreaterThanOrEqualTo(Integer value) {
			addCriterion("BEELEVATOR >=", value, "beelevator");
			return (Criteria) this;
		}

		public Criteria andBeelevatorLessThan(Integer value) {
			addCriterion("BEELEVATOR <", value, "beelevator");
			return (Criteria) this;
		}

		public Criteria andBeelevatorLessThanOrEqualTo(Integer value) {
			addCriterion("BEELEVATOR <=", value, "beelevator");
			return (Criteria) this;
		}

		public Criteria andBeelevatorIn(List<Integer> values) {
			addCriterion("BEELEVATOR in", values, "beelevator");
			return (Criteria) this;
		}

		public Criteria andBeelevatorNotIn(List<Integer> values) {
			addCriterion("BEELEVATOR not in", values, "beelevator");
			return (Criteria) this;
		}

		public Criteria andBeelevatorBetween(Integer value1, Integer value2) {
			addCriterion("BEELEVATOR between", value1, value2, "beelevator");
			return (Criteria) this;
		}

		public Criteria andBeelevatorNotBetween(Integer value1, Integer value2) {
			addCriterion("BEELEVATOR not between", value1, value2, "beelevator");
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