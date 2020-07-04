package com.myfun.repository.erpdb.po;

import com.myfun.repository.support.generator.shard.ShardDb;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ErpFunAttendanceGroupBizPersonExample extends ShardDb {
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
	public ErpFunAttendanceGroupBizPersonExample() {
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

		public Criteria andUserNameIsNull() {
			addCriterion("USER_NAME is null");
			return (Criteria) this;
		}

		public Criteria andUserNameIsNotNull() {
			addCriterion("USER_NAME is not null");
			return (Criteria) this;
		}

		public Criteria andUserNameEqualTo(String value) {
			addCriterion("USER_NAME =", value, "userName");
			return (Criteria) this;
		}

		public Criteria andUserNameNotEqualTo(String value) {
			addCriterion("USER_NAME <>", value, "userName");
			return (Criteria) this;
		}

		public Criteria andUserNameGreaterThan(String value) {
			addCriterion("USER_NAME >", value, "userName");
			return (Criteria) this;
		}

		public Criteria andUserNameGreaterThanOrEqualTo(String value) {
			addCriterion("USER_NAME >=", value, "userName");
			return (Criteria) this;
		}

		public Criteria andUserNameLessThan(String value) {
			addCriterion("USER_NAME <", value, "userName");
			return (Criteria) this;
		}

		public Criteria andUserNameLessThanOrEqualTo(String value) {
			addCriterion("USER_NAME <=", value, "userName");
			return (Criteria) this;
		}

		public Criteria andUserNameLike(String value) {
			addCriterion("USER_NAME like", value, "userName");
			return (Criteria) this;
		}

		public Criteria andUserNameNotLike(String value) {
			addCriterion("USER_NAME not like", value, "userName");
			return (Criteria) this;
		}

		public Criteria andUserNameIn(List<String> values) {
			addCriterion("USER_NAME in", values, "userName");
			return (Criteria) this;
		}

		public Criteria andUserNameNotIn(List<String> values) {
			addCriterion("USER_NAME not in", values, "userName");
			return (Criteria) this;
		}

		public Criteria andUserNameBetween(String value1, String value2) {
			addCriterion("USER_NAME between", value1, value2, "userName");
			return (Criteria) this;
		}

		public Criteria andUserNameNotBetween(String value1, String value2) {
			addCriterion("USER_NAME not between", value1, value2, "userName");
			return (Criteria) this;
		}

		public Criteria andGroupBizIdIsNull() {
			addCriterion("GROUP_BIZ_ID is null");
			return (Criteria) this;
		}

		public Criteria andGroupBizIdIsNotNull() {
			addCriterion("GROUP_BIZ_ID is not null");
			return (Criteria) this;
		}

		public Criteria andGroupBizIdEqualTo(Integer value) {
			addCriterion("GROUP_BIZ_ID =", value, "groupBizId");
			return (Criteria) this;
		}

		public Criteria andGroupBizIdNotEqualTo(Integer value) {
			addCriterion("GROUP_BIZ_ID <>", value, "groupBizId");
			return (Criteria) this;
		}

		public Criteria andGroupBizIdGreaterThan(Integer value) {
			addCriterion("GROUP_BIZ_ID >", value, "groupBizId");
			return (Criteria) this;
		}

		public Criteria andGroupBizIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("GROUP_BIZ_ID >=", value, "groupBizId");
			return (Criteria) this;
		}

		public Criteria andGroupBizIdLessThan(Integer value) {
			addCriterion("GROUP_BIZ_ID <", value, "groupBizId");
			return (Criteria) this;
		}

		public Criteria andGroupBizIdLessThanOrEqualTo(Integer value) {
			addCriterion("GROUP_BIZ_ID <=", value, "groupBizId");
			return (Criteria) this;
		}

		public Criteria andGroupBizIdIn(List<Integer> values) {
			addCriterion("GROUP_BIZ_ID in", values, "groupBizId");
			return (Criteria) this;
		}

		public Criteria andGroupBizIdNotIn(List<Integer> values) {
			addCriterion("GROUP_BIZ_ID not in", values, "groupBizId");
			return (Criteria) this;
		}

		public Criteria andGroupBizIdBetween(Integer value1, Integer value2) {
			addCriterion("GROUP_BIZ_ID between", value1, value2, "groupBizId");
			return (Criteria) this;
		}

		public Criteria andGroupBizIdNotBetween(Integer value1, Integer value2) {
			addCriterion("GROUP_BIZ_ID not between", value1, value2, "groupBizId");
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