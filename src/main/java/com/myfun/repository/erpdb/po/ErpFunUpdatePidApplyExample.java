package com.myfun.repository.erpdb.po;

import com.myfun.repository.support.generator.shard.ShardDb;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ErpFunUpdatePidApplyExample extends ShardDb {
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
	public ErpFunUpdatePidApplyExample() {
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

		public Criteria andApplyIdIsNull() {
			addCriterion("APPLY_ID is null");
			return (Criteria) this;
		}

		public Criteria andApplyIdIsNotNull() {
			addCriterion("APPLY_ID is not null");
			return (Criteria) this;
		}

		public Criteria andApplyIdEqualTo(Integer value) {
			addCriterion("APPLY_ID =", value, "applyId");
			return (Criteria) this;
		}

		public Criteria andApplyIdNotEqualTo(Integer value) {
			addCriterion("APPLY_ID <>", value, "applyId");
			return (Criteria) this;
		}

		public Criteria andApplyIdGreaterThan(Integer value) {
			addCriterion("APPLY_ID >", value, "applyId");
			return (Criteria) this;
		}

		public Criteria andApplyIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("APPLY_ID >=", value, "applyId");
			return (Criteria) this;
		}

		public Criteria andApplyIdLessThan(Integer value) {
			addCriterion("APPLY_ID <", value, "applyId");
			return (Criteria) this;
		}

		public Criteria andApplyIdLessThanOrEqualTo(Integer value) {
			addCriterion("APPLY_ID <=", value, "applyId");
			return (Criteria) this;
		}

		public Criteria andApplyIdIn(List<Integer> values) {
			addCriterion("APPLY_ID in", values, "applyId");
			return (Criteria) this;
		}

		public Criteria andApplyIdNotIn(List<Integer> values) {
			addCriterion("APPLY_ID not in", values, "applyId");
			return (Criteria) this;
		}

		public Criteria andApplyIdBetween(Integer value1, Integer value2) {
			addCriterion("APPLY_ID between", value1, value2, "applyId");
			return (Criteria) this;
		}

		public Criteria andApplyIdNotBetween(Integer value1, Integer value2) {
			addCriterion("APPLY_ID not between", value1, value2, "applyId");
			return (Criteria) this;
		}

		public Criteria andOrganizationIdIsNull() {
			addCriterion("ORGANIZATION_ID is null");
			return (Criteria) this;
		}

		public Criteria andOrganizationIdIsNotNull() {
			addCriterion("ORGANIZATION_ID is not null");
			return (Criteria) this;
		}

		public Criteria andOrganizationIdEqualTo(Integer value) {
			addCriterion("ORGANIZATION_ID =", value, "organizationId");
			return (Criteria) this;
		}

		public Criteria andOrganizationIdNotEqualTo(Integer value) {
			addCriterion("ORGANIZATION_ID <>", value, "organizationId");
			return (Criteria) this;
		}

		public Criteria andOrganizationIdGreaterThan(Integer value) {
			addCriterion("ORGANIZATION_ID >", value, "organizationId");
			return (Criteria) this;
		}

		public Criteria andOrganizationIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("ORGANIZATION_ID >=", value, "organizationId");
			return (Criteria) this;
		}

		public Criteria andOrganizationIdLessThan(Integer value) {
			addCriterion("ORGANIZATION_ID <", value, "organizationId");
			return (Criteria) this;
		}

		public Criteria andOrganizationIdLessThanOrEqualTo(Integer value) {
			addCriterion("ORGANIZATION_ID <=", value, "organizationId");
			return (Criteria) this;
		}

		public Criteria andOrganizationIdIn(List<Integer> values) {
			addCriterion("ORGANIZATION_ID in", values, "organizationId");
			return (Criteria) this;
		}

		public Criteria andOrganizationIdNotIn(List<Integer> values) {
			addCriterion("ORGANIZATION_ID not in", values, "organizationId");
			return (Criteria) this;
		}

		public Criteria andOrganizationIdBetween(Integer value1, Integer value2) {
			addCriterion("ORGANIZATION_ID between", value1, value2, "organizationId");
			return (Criteria) this;
		}

		public Criteria andOrganizationIdNotBetween(Integer value1, Integer value2) {
			addCriterion("ORGANIZATION_ID not between", value1, value2, "organizationId");
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

		public Criteria andOldPidIsNull() {
			addCriterion("OLD_PID is null");
			return (Criteria) this;
		}

		public Criteria andOldPidIsNotNull() {
			addCriterion("OLD_PID is not null");
			return (Criteria) this;
		}

		public Criteria andOldPidEqualTo(Integer value) {
			addCriterion("OLD_PID =", value, "oldPid");
			return (Criteria) this;
		}

		public Criteria andOldPidNotEqualTo(Integer value) {
			addCriterion("OLD_PID <>", value, "oldPid");
			return (Criteria) this;
		}

		public Criteria andOldPidGreaterThan(Integer value) {
			addCriterion("OLD_PID >", value, "oldPid");
			return (Criteria) this;
		}

		public Criteria andOldPidGreaterThanOrEqualTo(Integer value) {
			addCriterion("OLD_PID >=", value, "oldPid");
			return (Criteria) this;
		}

		public Criteria andOldPidLessThan(Integer value) {
			addCriterion("OLD_PID <", value, "oldPid");
			return (Criteria) this;
		}

		public Criteria andOldPidLessThanOrEqualTo(Integer value) {
			addCriterion("OLD_PID <=", value, "oldPid");
			return (Criteria) this;
		}

		public Criteria andOldPidIn(List<Integer> values) {
			addCriterion("OLD_PID in", values, "oldPid");
			return (Criteria) this;
		}

		public Criteria andOldPidNotIn(List<Integer> values) {
			addCriterion("OLD_PID not in", values, "oldPid");
			return (Criteria) this;
		}

		public Criteria andOldPidBetween(Integer value1, Integer value2) {
			addCriterion("OLD_PID between", value1, value2, "oldPid");
			return (Criteria) this;
		}

		public Criteria andOldPidNotBetween(Integer value1, Integer value2) {
			addCriterion("OLD_PID not between", value1, value2, "oldPid");
			return (Criteria) this;
		}

		public Criteria andNewPidIsNull() {
			addCriterion("NEW_PID is null");
			return (Criteria) this;
		}

		public Criteria andNewPidIsNotNull() {
			addCriterion("NEW_PID is not null");
			return (Criteria) this;
		}

		public Criteria andNewPidEqualTo(Integer value) {
			addCriterion("NEW_PID =", value, "newPid");
			return (Criteria) this;
		}

		public Criteria andNewPidNotEqualTo(Integer value) {
			addCriterion("NEW_PID <>", value, "newPid");
			return (Criteria) this;
		}

		public Criteria andNewPidGreaterThan(Integer value) {
			addCriterion("NEW_PID >", value, "newPid");
			return (Criteria) this;
		}

		public Criteria andNewPidGreaterThanOrEqualTo(Integer value) {
			addCriterion("NEW_PID >=", value, "newPid");
			return (Criteria) this;
		}

		public Criteria andNewPidLessThan(Integer value) {
			addCriterion("NEW_PID <", value, "newPid");
			return (Criteria) this;
		}

		public Criteria andNewPidLessThanOrEqualTo(Integer value) {
			addCriterion("NEW_PID <=", value, "newPid");
			return (Criteria) this;
		}

		public Criteria andNewPidIn(List<Integer> values) {
			addCriterion("NEW_PID in", values, "newPid");
			return (Criteria) this;
		}

		public Criteria andNewPidNotIn(List<Integer> values) {
			addCriterion("NEW_PID not in", values, "newPid");
			return (Criteria) this;
		}

		public Criteria andNewPidBetween(Integer value1, Integer value2) {
			addCriterion("NEW_PID between", value1, value2, "newPid");
			return (Criteria) this;
		}

		public Criteria andNewPidNotBetween(Integer value1, Integer value2) {
			addCriterion("NEW_PID not between", value1, value2, "newPid");
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

		public Criteria andUserIdIsNull() {
			addCriterion("USER_ID is null");
			return (Criteria) this;
		}

		public Criteria andUserIdIsNotNull() {
			addCriterion("USER_ID is not null");
			return (Criteria) this;
		}

		public Criteria andUserIdEqualTo(Integer value) {
			addCriterion("USER_ID =", value, "userId");
			return (Criteria) this;
		}

		public Criteria andUserIdNotEqualTo(Integer value) {
			addCriterion("USER_ID <>", value, "userId");
			return (Criteria) this;
		}

		public Criteria andUserIdGreaterThan(Integer value) {
			addCriterion("USER_ID >", value, "userId");
			return (Criteria) this;
		}

		public Criteria andUserIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("USER_ID >=", value, "userId");
			return (Criteria) this;
		}

		public Criteria andUserIdLessThan(Integer value) {
			addCriterion("USER_ID <", value, "userId");
			return (Criteria) this;
		}

		public Criteria andUserIdLessThanOrEqualTo(Integer value) {
			addCriterion("USER_ID <=", value, "userId");
			return (Criteria) this;
		}

		public Criteria andUserIdIn(List<Integer> values) {
			addCriterion("USER_ID in", values, "userId");
			return (Criteria) this;
		}

		public Criteria andUserIdNotIn(List<Integer> values) {
			addCriterion("USER_ID not in", values, "userId");
			return (Criteria) this;
		}

		public Criteria andUserIdBetween(Integer value1, Integer value2) {
			addCriterion("USER_ID between", value1, value2, "userId");
			return (Criteria) this;
		}

		public Criteria andUserIdNotBetween(Integer value1, Integer value2) {
			addCriterion("USER_ID not between", value1, value2, "userId");
			return (Criteria) this;
		}

		public Criteria andDealFlagIsNull() {
			addCriterion("DEAL_FLAG is null");
			return (Criteria) this;
		}

		public Criteria andDealFlagIsNotNull() {
			addCriterion("DEAL_FLAG is not null");
			return (Criteria) this;
		}

		public Criteria andDealFlagEqualTo(Byte value) {
			addCriterion("DEAL_FLAG =", value, "dealFlag");
			return (Criteria) this;
		}

		public Criteria andDealFlagNotEqualTo(Byte value) {
			addCriterion("DEAL_FLAG <>", value, "dealFlag");
			return (Criteria) this;
		}

		public Criteria andDealFlagGreaterThan(Byte value) {
			addCriterion("DEAL_FLAG >", value, "dealFlag");
			return (Criteria) this;
		}

		public Criteria andDealFlagGreaterThanOrEqualTo(Byte value) {
			addCriterion("DEAL_FLAG >=", value, "dealFlag");
			return (Criteria) this;
		}

		public Criteria andDealFlagLessThan(Byte value) {
			addCriterion("DEAL_FLAG <", value, "dealFlag");
			return (Criteria) this;
		}

		public Criteria andDealFlagLessThanOrEqualTo(Byte value) {
			addCriterion("DEAL_FLAG <=", value, "dealFlag");
			return (Criteria) this;
		}

		public Criteria andDealFlagIn(List<Byte> values) {
			addCriterion("DEAL_FLAG in", values, "dealFlag");
			return (Criteria) this;
		}

		public Criteria andDealFlagNotIn(List<Byte> values) {
			addCriterion("DEAL_FLAG not in", values, "dealFlag");
			return (Criteria) this;
		}

		public Criteria andDealFlagBetween(Byte value1, Byte value2) {
			addCriterion("DEAL_FLAG between", value1, value2, "dealFlag");
			return (Criteria) this;
		}

		public Criteria andDealFlagNotBetween(Byte value1, Byte value2) {
			addCriterion("DEAL_FLAG not between", value1, value2, "dealFlag");
			return (Criteria) this;
		}

		public Criteria andDealTimeIsNull() {
			addCriterion("DEAL_TIME is null");
			return (Criteria) this;
		}

		public Criteria andDealTimeIsNotNull() {
			addCriterion("DEAL_TIME is not null");
			return (Criteria) this;
		}

		public Criteria andDealTimeEqualTo(Date value) {
			addCriterion("DEAL_TIME =", value, "dealTime");
			return (Criteria) this;
		}

		public Criteria andDealTimeNotEqualTo(Date value) {
			addCriterion("DEAL_TIME <>", value, "dealTime");
			return (Criteria) this;
		}

		public Criteria andDealTimeGreaterThan(Date value) {
			addCriterion("DEAL_TIME >", value, "dealTime");
			return (Criteria) this;
		}

		public Criteria andDealTimeGreaterThanOrEqualTo(Date value) {
			addCriterion("DEAL_TIME >=", value, "dealTime");
			return (Criteria) this;
		}

		public Criteria andDealTimeLessThan(Date value) {
			addCriterion("DEAL_TIME <", value, "dealTime");
			return (Criteria) this;
		}

		public Criteria andDealTimeLessThanOrEqualTo(Date value) {
			addCriterion("DEAL_TIME <=", value, "dealTime");
			return (Criteria) this;
		}

		public Criteria andDealTimeIn(List<Date> values) {
			addCriterion("DEAL_TIME in", values, "dealTime");
			return (Criteria) this;
		}

		public Criteria andDealTimeNotIn(List<Date> values) {
			addCriterion("DEAL_TIME not in", values, "dealTime");
			return (Criteria) this;
		}

		public Criteria andDealTimeBetween(Date value1, Date value2) {
			addCriterion("DEAL_TIME between", value1, value2, "dealTime");
			return (Criteria) this;
		}

		public Criteria andDealTimeNotBetween(Date value1, Date value2) {
			addCriterion("DEAL_TIME not between", value1, value2, "dealTime");
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