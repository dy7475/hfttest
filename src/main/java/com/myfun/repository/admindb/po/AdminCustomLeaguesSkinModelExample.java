package com.myfun.repository.admindb.po;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AdminCustomLeaguesSkinModelExample {
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
	public AdminCustomLeaguesSkinModelExample() {
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

		public Criteria andLeaguesTypeIsNull() {
			addCriterion("LEAGUES_TYPE is null");
			return (Criteria) this;
		}

		public Criteria andLeaguesTypeIsNotNull() {
			addCriterion("LEAGUES_TYPE is not null");
			return (Criteria) this;
		}

		public Criteria andLeaguesTypeEqualTo(Integer value) {
			addCriterion("LEAGUES_TYPE =", value, "leaguesType");
			return (Criteria) this;
		}

		public Criteria andLeaguesTypeNotEqualTo(Integer value) {
			addCriterion("LEAGUES_TYPE <>", value, "leaguesType");
			return (Criteria) this;
		}

		public Criteria andLeaguesTypeGreaterThan(Integer value) {
			addCriterion("LEAGUES_TYPE >", value, "leaguesType");
			return (Criteria) this;
		}

		public Criteria andLeaguesTypeGreaterThanOrEqualTo(Integer value) {
			addCriterion("LEAGUES_TYPE >=", value, "leaguesType");
			return (Criteria) this;
		}

		public Criteria andLeaguesTypeLessThan(Integer value) {
			addCriterion("LEAGUES_TYPE <", value, "leaguesType");
			return (Criteria) this;
		}

		public Criteria andLeaguesTypeLessThanOrEqualTo(Integer value) {
			addCriterion("LEAGUES_TYPE <=", value, "leaguesType");
			return (Criteria) this;
		}

		public Criteria andLeaguesTypeIn(List<Integer> values) {
			addCriterion("LEAGUES_TYPE in", values, "leaguesType");
			return (Criteria) this;
		}

		public Criteria andLeaguesTypeNotIn(List<Integer> values) {
			addCriterion("LEAGUES_TYPE not in", values, "leaguesType");
			return (Criteria) this;
		}

		public Criteria andLeaguesTypeBetween(Integer value1, Integer value2) {
			addCriterion("LEAGUES_TYPE between", value1, value2, "leaguesType");
			return (Criteria) this;
		}

		public Criteria andLeaguesTypeNotBetween(Integer value1, Integer value2) {
			addCriterion("LEAGUES_TYPE not between", value1, value2, "leaguesType");
			return (Criteria) this;
		}

		public Criteria andSkinTypeIsNull() {
			addCriterion("SKIN_TYPE is null");
			return (Criteria) this;
		}

		public Criteria andSkinTypeIsNotNull() {
			addCriterion("SKIN_TYPE is not null");
			return (Criteria) this;
		}

		public Criteria andSkinTypeEqualTo(String value) {
			addCriterion("SKIN_TYPE =", value, "skinType");
			return (Criteria) this;
		}

		public Criteria andSkinTypeNotEqualTo(String value) {
			addCriterion("SKIN_TYPE <>", value, "skinType");
			return (Criteria) this;
		}

		public Criteria andSkinTypeGreaterThan(String value) {
			addCriterion("SKIN_TYPE >", value, "skinType");
			return (Criteria) this;
		}

		public Criteria andSkinTypeGreaterThanOrEqualTo(String value) {
			addCriterion("SKIN_TYPE >=", value, "skinType");
			return (Criteria) this;
		}

		public Criteria andSkinTypeLessThan(String value) {
			addCriterion("SKIN_TYPE <", value, "skinType");
			return (Criteria) this;
		}

		public Criteria andSkinTypeLessThanOrEqualTo(String value) {
			addCriterion("SKIN_TYPE <=", value, "skinType");
			return (Criteria) this;
		}

		public Criteria andSkinTypeLike(String value) {
			addCriterion("SKIN_TYPE like", value, "skinType");
			return (Criteria) this;
		}

		public Criteria andSkinTypeNotLike(String value) {
			addCriterion("SKIN_TYPE not like", value, "skinType");
			return (Criteria) this;
		}

		public Criteria andSkinTypeIn(List<String> values) {
			addCriterion("SKIN_TYPE in", values, "skinType");
			return (Criteria) this;
		}

		public Criteria andSkinTypeNotIn(List<String> values) {
			addCriterion("SKIN_TYPE not in", values, "skinType");
			return (Criteria) this;
		}

		public Criteria andSkinTypeBetween(String value1, String value2) {
			addCriterion("SKIN_TYPE between", value1, value2, "skinType");
			return (Criteria) this;
		}

		public Criteria andSkinTypeNotBetween(String value1, String value2) {
			addCriterion("SKIN_TYPE not between", value1, value2, "skinType");
			return (Criteria) this;
		}

		public Criteria andSkinPicUrlIsNull() {
			addCriterion("SKIN_PIC_URL is null");
			return (Criteria) this;
		}

		public Criteria andSkinPicUrlIsNotNull() {
			addCriterion("SKIN_PIC_URL is not null");
			return (Criteria) this;
		}

		public Criteria andSkinPicUrlEqualTo(String value) {
			addCriterion("SKIN_PIC_URL =", value, "skinPicUrl");
			return (Criteria) this;
		}

		public Criteria andSkinPicUrlNotEqualTo(String value) {
			addCriterion("SKIN_PIC_URL <>", value, "skinPicUrl");
			return (Criteria) this;
		}

		public Criteria andSkinPicUrlGreaterThan(String value) {
			addCriterion("SKIN_PIC_URL >", value, "skinPicUrl");
			return (Criteria) this;
		}

		public Criteria andSkinPicUrlGreaterThanOrEqualTo(String value) {
			addCriterion("SKIN_PIC_URL >=", value, "skinPicUrl");
			return (Criteria) this;
		}

		public Criteria andSkinPicUrlLessThan(String value) {
			addCriterion("SKIN_PIC_URL <", value, "skinPicUrl");
			return (Criteria) this;
		}

		public Criteria andSkinPicUrlLessThanOrEqualTo(String value) {
			addCriterion("SKIN_PIC_URL <=", value, "skinPicUrl");
			return (Criteria) this;
		}

		public Criteria andSkinPicUrlLike(String value) {
			addCriterion("SKIN_PIC_URL like", value, "skinPicUrl");
			return (Criteria) this;
		}

		public Criteria andSkinPicUrlNotLike(String value) {
			addCriterion("SKIN_PIC_URL not like", value, "skinPicUrl");
			return (Criteria) this;
		}

		public Criteria andSkinPicUrlIn(List<String> values) {
			addCriterion("SKIN_PIC_URL in", values, "skinPicUrl");
			return (Criteria) this;
		}

		public Criteria andSkinPicUrlNotIn(List<String> values) {
			addCriterion("SKIN_PIC_URL not in", values, "skinPicUrl");
			return (Criteria) this;
		}

		public Criteria andSkinPicUrlBetween(String value1, String value2) {
			addCriterion("SKIN_PIC_URL between", value1, value2, "skinPicUrl");
			return (Criteria) this;
		}

		public Criteria andSkinPicUrlNotBetween(String value1, String value2) {
			addCriterion("SKIN_PIC_URL not between", value1, value2, "skinPicUrl");
			return (Criteria) this;
		}

		public Criteria andClientTypeIsNull() {
			addCriterion("CLIENT_TYPE is null");
			return (Criteria) this;
		}

		public Criteria andClientTypeIsNotNull() {
			addCriterion("CLIENT_TYPE is not null");
			return (Criteria) this;
		}

		public Criteria andClientTypeEqualTo(Integer value) {
			addCriterion("CLIENT_TYPE =", value, "clientType");
			return (Criteria) this;
		}

		public Criteria andClientTypeNotEqualTo(Integer value) {
			addCriterion("CLIENT_TYPE <>", value, "clientType");
			return (Criteria) this;
		}

		public Criteria andClientTypeGreaterThan(Integer value) {
			addCriterion("CLIENT_TYPE >", value, "clientType");
			return (Criteria) this;
		}

		public Criteria andClientTypeGreaterThanOrEqualTo(Integer value) {
			addCriterion("CLIENT_TYPE >=", value, "clientType");
			return (Criteria) this;
		}

		public Criteria andClientTypeLessThan(Integer value) {
			addCriterion("CLIENT_TYPE <", value, "clientType");
			return (Criteria) this;
		}

		public Criteria andClientTypeLessThanOrEqualTo(Integer value) {
			addCriterion("CLIENT_TYPE <=", value, "clientType");
			return (Criteria) this;
		}

		public Criteria andClientTypeIn(List<Integer> values) {
			addCriterion("CLIENT_TYPE in", values, "clientType");
			return (Criteria) this;
		}

		public Criteria andClientTypeNotIn(List<Integer> values) {
			addCriterion("CLIENT_TYPE not in", values, "clientType");
			return (Criteria) this;
		}

		public Criteria andClientTypeBetween(Integer value1, Integer value2) {
			addCriterion("CLIENT_TYPE between", value1, value2, "clientType");
			return (Criteria) this;
		}

		public Criteria andClientTypeNotBetween(Integer value1, Integer value2) {
			addCriterion("CLIENT_TYPE not between", value1, value2, "clientType");
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

		public Criteria andSkinPicUrlTypeIsNull() {
			addCriterion("SKIN_PIC_URL_TYPE is null");
			return (Criteria) this;
		}

		public Criteria andSkinPicUrlTypeIsNotNull() {
			addCriterion("SKIN_PIC_URL_TYPE is not null");
			return (Criteria) this;
		}

		public Criteria andSkinPicUrlTypeEqualTo(Integer value) {
			addCriterion("SKIN_PIC_URL_TYPE =", value, "skinPicUrlType");
			return (Criteria) this;
		}

		public Criteria andSkinPicUrlTypeNotEqualTo(Integer value) {
			addCriterion("SKIN_PIC_URL_TYPE <>", value, "skinPicUrlType");
			return (Criteria) this;
		}

		public Criteria andSkinPicUrlTypeGreaterThan(Integer value) {
			addCriterion("SKIN_PIC_URL_TYPE >", value, "skinPicUrlType");
			return (Criteria) this;
		}

		public Criteria andSkinPicUrlTypeGreaterThanOrEqualTo(Integer value) {
			addCriterion("SKIN_PIC_URL_TYPE >=", value, "skinPicUrlType");
			return (Criteria) this;
		}

		public Criteria andSkinPicUrlTypeLessThan(Integer value) {
			addCriterion("SKIN_PIC_URL_TYPE <", value, "skinPicUrlType");
			return (Criteria) this;
		}

		public Criteria andSkinPicUrlTypeLessThanOrEqualTo(Integer value) {
			addCriterion("SKIN_PIC_URL_TYPE <=", value, "skinPicUrlType");
			return (Criteria) this;
		}

		public Criteria andSkinPicUrlTypeIn(List<Integer> values) {
			addCriterion("SKIN_PIC_URL_TYPE in", values, "skinPicUrlType");
			return (Criteria) this;
		}

		public Criteria andSkinPicUrlTypeNotIn(List<Integer> values) {
			addCriterion("SKIN_PIC_URL_TYPE not in", values, "skinPicUrlType");
			return (Criteria) this;
		}

		public Criteria andSkinPicUrlTypeBetween(Integer value1, Integer value2) {
			addCriterion("SKIN_PIC_URL_TYPE between", value1, value2, "skinPicUrlType");
			return (Criteria) this;
		}

		public Criteria andSkinPicUrlTypeNotBetween(Integer value1, Integer value2) {
			addCriterion("SKIN_PIC_URL_TYPE not between", value1, value2, "skinPicUrlType");
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