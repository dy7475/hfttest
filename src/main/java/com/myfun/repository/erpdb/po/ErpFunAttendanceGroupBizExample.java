package com.myfun.repository.erpdb.po;

import com.myfun.repository.support.generator.shard.ShardDb;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ErpFunAttendanceGroupBizExample extends ShardDb {
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
	public ErpFunAttendanceGroupBizExample() {
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

		public Criteria andAttGroupIdIsNull() {
			addCriterion("ATT_GROUP_ID is null");
			return (Criteria) this;
		}

		public Criteria andAttGroupIdIsNotNull() {
			addCriterion("ATT_GROUP_ID is not null");
			return (Criteria) this;
		}

		public Criteria andAttGroupIdEqualTo(Integer value) {
			addCriterion("ATT_GROUP_ID =", value, "attGroupId");
			return (Criteria) this;
		}

		public Criteria andAttGroupIdNotEqualTo(Integer value) {
			addCriterion("ATT_GROUP_ID <>", value, "attGroupId");
			return (Criteria) this;
		}

		public Criteria andAttGroupIdGreaterThan(Integer value) {
			addCriterion("ATT_GROUP_ID >", value, "attGroupId");
			return (Criteria) this;
		}

		public Criteria andAttGroupIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("ATT_GROUP_ID >=", value, "attGroupId");
			return (Criteria) this;
		}

		public Criteria andAttGroupIdLessThan(Integer value) {
			addCriterion("ATT_GROUP_ID <", value, "attGroupId");
			return (Criteria) this;
		}

		public Criteria andAttGroupIdLessThanOrEqualTo(Integer value) {
			addCriterion("ATT_GROUP_ID <=", value, "attGroupId");
			return (Criteria) this;
		}

		public Criteria andAttGroupIdIn(List<Integer> values) {
			addCriterion("ATT_GROUP_ID in", values, "attGroupId");
			return (Criteria) this;
		}

		public Criteria andAttGroupIdNotIn(List<Integer> values) {
			addCriterion("ATT_GROUP_ID not in", values, "attGroupId");
			return (Criteria) this;
		}

		public Criteria andAttGroupIdBetween(Integer value1, Integer value2) {
			addCriterion("ATT_GROUP_ID between", value1, value2, "attGroupId");
			return (Criteria) this;
		}

		public Criteria andAttGroupIdNotBetween(Integer value1, Integer value2) {
			addCriterion("ATT_GROUP_ID not between", value1, value2, "attGroupId");
			return (Criteria) this;
		}

		public Criteria andBizIdIsNull() {
			addCriterion("BIZ_ID is null");
			return (Criteria) this;
		}

		public Criteria andBizIdIsNotNull() {
			addCriterion("BIZ_ID is not null");
			return (Criteria) this;
		}

		public Criteria andBizIdEqualTo(Integer value) {
			addCriterion("BIZ_ID =", value, "bizId");
			return (Criteria) this;
		}

		public Criteria andBizIdNotEqualTo(Integer value) {
			addCriterion("BIZ_ID <>", value, "bizId");
			return (Criteria) this;
		}

		public Criteria andBizIdGreaterThan(Integer value) {
			addCriterion("BIZ_ID >", value, "bizId");
			return (Criteria) this;
		}

		public Criteria andBizIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("BIZ_ID >=", value, "bizId");
			return (Criteria) this;
		}

		public Criteria andBizIdLessThan(Integer value) {
			addCriterion("BIZ_ID <", value, "bizId");
			return (Criteria) this;
		}

		public Criteria andBizIdLessThanOrEqualTo(Integer value) {
			addCriterion("BIZ_ID <=", value, "bizId");
			return (Criteria) this;
		}

		public Criteria andBizIdIn(List<Integer> values) {
			addCriterion("BIZ_ID in", values, "bizId");
			return (Criteria) this;
		}

		public Criteria andBizIdNotIn(List<Integer> values) {
			addCriterion("BIZ_ID not in", values, "bizId");
			return (Criteria) this;
		}

		public Criteria andBizIdBetween(Integer value1, Integer value2) {
			addCriterion("BIZ_ID between", value1, value2, "bizId");
			return (Criteria) this;
		}

		public Criteria andBizIdNotBetween(Integer value1, Integer value2) {
			addCriterion("BIZ_ID not between", value1, value2, "bizId");
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

		public Criteria andChooseTypeIsNull() {
			addCriterion("CHOOSE_TYPE is null");
			return (Criteria) this;
		}

		public Criteria andChooseTypeIsNotNull() {
			addCriterion("CHOOSE_TYPE is not null");
			return (Criteria) this;
		}

		public Criteria andChooseTypeEqualTo(Integer value) {
			addCriterion("CHOOSE_TYPE =", value, "chooseType");
			return (Criteria) this;
		}

		public Criteria andChooseTypeNotEqualTo(Integer value) {
			addCriterion("CHOOSE_TYPE <>", value, "chooseType");
			return (Criteria) this;
		}

		public Criteria andChooseTypeGreaterThan(Integer value) {
			addCriterion("CHOOSE_TYPE >", value, "chooseType");
			return (Criteria) this;
		}

		public Criteria andChooseTypeGreaterThanOrEqualTo(Integer value) {
			addCriterion("CHOOSE_TYPE >=", value, "chooseType");
			return (Criteria) this;
		}

		public Criteria andChooseTypeLessThan(Integer value) {
			addCriterion("CHOOSE_TYPE <", value, "chooseType");
			return (Criteria) this;
		}

		public Criteria andChooseTypeLessThanOrEqualTo(Integer value) {
			addCriterion("CHOOSE_TYPE <=", value, "chooseType");
			return (Criteria) this;
		}

		public Criteria andChooseTypeIn(List<Integer> values) {
			addCriterion("CHOOSE_TYPE in", values, "chooseType");
			return (Criteria) this;
		}

		public Criteria andChooseTypeNotIn(List<Integer> values) {
			addCriterion("CHOOSE_TYPE not in", values, "chooseType");
			return (Criteria) this;
		}

		public Criteria andChooseTypeBetween(Integer value1, Integer value2) {
			addCriterion("CHOOSE_TYPE between", value1, value2, "chooseType");
			return (Criteria) this;
		}

		public Criteria andChooseTypeNotBetween(Integer value1, Integer value2) {
			addCriterion("CHOOSE_TYPE not between", value1, value2, "chooseType");
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

		public Criteria andDelTimeIsNull() {
			addCriterion("DEL_TIME is null");
			return (Criteria) this;
		}

		public Criteria andDelTimeIsNotNull() {
			addCriterion("DEL_TIME is not null");
			return (Criteria) this;
		}

		public Criteria andDelTimeEqualTo(Date value) {
			addCriterion("DEL_TIME =", value, "delTime");
			return (Criteria) this;
		}

		public Criteria andDelTimeNotEqualTo(Date value) {
			addCriterion("DEL_TIME <>", value, "delTime");
			return (Criteria) this;
		}

		public Criteria andDelTimeGreaterThan(Date value) {
			addCriterion("DEL_TIME >", value, "delTime");
			return (Criteria) this;
		}

		public Criteria andDelTimeGreaterThanOrEqualTo(Date value) {
			addCriterion("DEL_TIME >=", value, "delTime");
			return (Criteria) this;
		}

		public Criteria andDelTimeLessThan(Date value) {
			addCriterion("DEL_TIME <", value, "delTime");
			return (Criteria) this;
		}

		public Criteria andDelTimeLessThanOrEqualTo(Date value) {
			addCriterion("DEL_TIME <=", value, "delTime");
			return (Criteria) this;
		}

		public Criteria andDelTimeIn(List<Date> values) {
			addCriterion("DEL_TIME in", values, "delTime");
			return (Criteria) this;
		}

		public Criteria andDelTimeNotIn(List<Date> values) {
			addCriterion("DEL_TIME not in", values, "delTime");
			return (Criteria) this;
		}

		public Criteria andDelTimeBetween(Date value1, Date value2) {
			addCriterion("DEL_TIME between", value1, value2, "delTime");
			return (Criteria) this;
		}

		public Criteria andDelTimeNotBetween(Date value1, Date value2) {
			addCriterion("DEL_TIME not between", value1, value2, "delTime");
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