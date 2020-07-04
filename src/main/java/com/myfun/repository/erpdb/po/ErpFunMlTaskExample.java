package com.myfun.repository.erpdb.po;

import com.myfun.repository.support.generator.shard.ShardDb;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ErpFunMlTaskExample extends ShardDb {
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
	public ErpFunMlTaskExample() {
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

		public Criteria andTaskIdIsNull() {
			addCriterion("TASK_ID is null");
			return (Criteria) this;
		}

		public Criteria andTaskIdIsNotNull() {
			addCriterion("TASK_ID is not null");
			return (Criteria) this;
		}

		public Criteria andTaskIdEqualTo(Integer value) {
			addCriterion("TASK_ID =", value, "taskId");
			return (Criteria) this;
		}

		public Criteria andTaskIdNotEqualTo(Integer value) {
			addCriterion("TASK_ID <>", value, "taskId");
			return (Criteria) this;
		}

		public Criteria andTaskIdGreaterThan(Integer value) {
			addCriterion("TASK_ID >", value, "taskId");
			return (Criteria) this;
		}

		public Criteria andTaskIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("TASK_ID >=", value, "taskId");
			return (Criteria) this;
		}

		public Criteria andTaskIdLessThan(Integer value) {
			addCriterion("TASK_ID <", value, "taskId");
			return (Criteria) this;
		}

		public Criteria andTaskIdLessThanOrEqualTo(Integer value) {
			addCriterion("TASK_ID <=", value, "taskId");
			return (Criteria) this;
		}

		public Criteria andTaskIdIn(List<Integer> values) {
			addCriterion("TASK_ID in", values, "taskId");
			return (Criteria) this;
		}

		public Criteria andTaskIdNotIn(List<Integer> values) {
			addCriterion("TASK_ID not in", values, "taskId");
			return (Criteria) this;
		}

		public Criteria andTaskIdBetween(Integer value1, Integer value2) {
			addCriterion("TASK_ID between", value1, value2, "taskId");
			return (Criteria) this;
		}

		public Criteria andTaskIdNotBetween(Integer value1, Integer value2) {
			addCriterion("TASK_ID not between", value1, value2, "taskId");
			return (Criteria) this;
		}

		public Criteria andSendTaskIdIsNull() {
			addCriterion("SEND_TASK_ID is null");
			return (Criteria) this;
		}

		public Criteria andSendTaskIdIsNotNull() {
			addCriterion("SEND_TASK_ID is not null");
			return (Criteria) this;
		}

		public Criteria andSendTaskIdEqualTo(Integer value) {
			addCriterion("SEND_TASK_ID =", value, "sendTaskId");
			return (Criteria) this;
		}

		public Criteria andSendTaskIdNotEqualTo(Integer value) {
			addCriterion("SEND_TASK_ID <>", value, "sendTaskId");
			return (Criteria) this;
		}

		public Criteria andSendTaskIdGreaterThan(Integer value) {
			addCriterion("SEND_TASK_ID >", value, "sendTaskId");
			return (Criteria) this;
		}

		public Criteria andSendTaskIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("SEND_TASK_ID >=", value, "sendTaskId");
			return (Criteria) this;
		}

		public Criteria andSendTaskIdLessThan(Integer value) {
			addCriterion("SEND_TASK_ID <", value, "sendTaskId");
			return (Criteria) this;
		}

		public Criteria andSendTaskIdLessThanOrEqualTo(Integer value) {
			addCriterion("SEND_TASK_ID <=", value, "sendTaskId");
			return (Criteria) this;
		}

		public Criteria andSendTaskIdIn(List<Integer> values) {
			addCriterion("SEND_TASK_ID in", values, "sendTaskId");
			return (Criteria) this;
		}

		public Criteria andSendTaskIdNotIn(List<Integer> values) {
			addCriterion("SEND_TASK_ID not in", values, "sendTaskId");
			return (Criteria) this;
		}

		public Criteria andSendTaskIdBetween(Integer value1, Integer value2) {
			addCriterion("SEND_TASK_ID between", value1, value2, "sendTaskId");
			return (Criteria) this;
		}

		public Criteria andSendTaskIdNotBetween(Integer value1, Integer value2) {
			addCriterion("SEND_TASK_ID not between", value1, value2, "sendTaskId");
			return (Criteria) this;
		}

		public Criteria andSendUserIdIsNull() {
			addCriterion("SEND_USER_ID is null");
			return (Criteria) this;
		}

		public Criteria andSendUserIdIsNotNull() {
			addCriterion("SEND_USER_ID is not null");
			return (Criteria) this;
		}

		public Criteria andSendUserIdEqualTo(Integer value) {
			addCriterion("SEND_USER_ID =", value, "sendUserId");
			return (Criteria) this;
		}

		public Criteria andSendUserIdNotEqualTo(Integer value) {
			addCriterion("SEND_USER_ID <>", value, "sendUserId");
			return (Criteria) this;
		}

		public Criteria andSendUserIdGreaterThan(Integer value) {
			addCriterion("SEND_USER_ID >", value, "sendUserId");
			return (Criteria) this;
		}

		public Criteria andSendUserIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("SEND_USER_ID >=", value, "sendUserId");
			return (Criteria) this;
		}

		public Criteria andSendUserIdLessThan(Integer value) {
			addCriterion("SEND_USER_ID <", value, "sendUserId");
			return (Criteria) this;
		}

		public Criteria andSendUserIdLessThanOrEqualTo(Integer value) {
			addCriterion("SEND_USER_ID <=", value, "sendUserId");
			return (Criteria) this;
		}

		public Criteria andSendUserIdIn(List<Integer> values) {
			addCriterion("SEND_USER_ID in", values, "sendUserId");
			return (Criteria) this;
		}

		public Criteria andSendUserIdNotIn(List<Integer> values) {
			addCriterion("SEND_USER_ID not in", values, "sendUserId");
			return (Criteria) this;
		}

		public Criteria andSendUserIdBetween(Integer value1, Integer value2) {
			addCriterion("SEND_USER_ID between", value1, value2, "sendUserId");
			return (Criteria) this;
		}

		public Criteria andSendUserIdNotBetween(Integer value1, Integer value2) {
			addCriterion("SEND_USER_ID not between", value1, value2, "sendUserId");
			return (Criteria) this;
		}

		public Criteria andSendArchiveIdIsNull() {
			addCriterion("SEND_ARCHIVE_ID is null");
			return (Criteria) this;
		}

		public Criteria andSendArchiveIdIsNotNull() {
			addCriterion("SEND_ARCHIVE_ID is not null");
			return (Criteria) this;
		}

		public Criteria andSendArchiveIdEqualTo(Integer value) {
			addCriterion("SEND_ARCHIVE_ID =", value, "sendArchiveId");
			return (Criteria) this;
		}

		public Criteria andSendArchiveIdNotEqualTo(Integer value) {
			addCriterion("SEND_ARCHIVE_ID <>", value, "sendArchiveId");
			return (Criteria) this;
		}

		public Criteria andSendArchiveIdGreaterThan(Integer value) {
			addCriterion("SEND_ARCHIVE_ID >", value, "sendArchiveId");
			return (Criteria) this;
		}

		public Criteria andSendArchiveIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("SEND_ARCHIVE_ID >=", value, "sendArchiveId");
			return (Criteria) this;
		}

		public Criteria andSendArchiveIdLessThan(Integer value) {
			addCriterion("SEND_ARCHIVE_ID <", value, "sendArchiveId");
			return (Criteria) this;
		}

		public Criteria andSendArchiveIdLessThanOrEqualTo(Integer value) {
			addCriterion("SEND_ARCHIVE_ID <=", value, "sendArchiveId");
			return (Criteria) this;
		}

		public Criteria andSendArchiveIdIn(List<Integer> values) {
			addCriterion("SEND_ARCHIVE_ID in", values, "sendArchiveId");
			return (Criteria) this;
		}

		public Criteria andSendArchiveIdNotIn(List<Integer> values) {
			addCriterion("SEND_ARCHIVE_ID not in", values, "sendArchiveId");
			return (Criteria) this;
		}

		public Criteria andSendArchiveIdBetween(Integer value1, Integer value2) {
			addCriterion("SEND_ARCHIVE_ID between", value1, value2, "sendArchiveId");
			return (Criteria) this;
		}

		public Criteria andSendArchiveIdNotBetween(Integer value1, Integer value2) {
			addCriterion("SEND_ARCHIVE_ID not between", value1, value2, "sendArchiveId");
			return (Criteria) this;
		}

		public Criteria andSendUserNameIsNull() {
			addCriterion("SEND_USER_NAME is null");
			return (Criteria) this;
		}

		public Criteria andSendUserNameIsNotNull() {
			addCriterion("SEND_USER_NAME is not null");
			return (Criteria) this;
		}

		public Criteria andSendUserNameEqualTo(String value) {
			addCriterion("SEND_USER_NAME =", value, "sendUserName");
			return (Criteria) this;
		}

		public Criteria andSendUserNameNotEqualTo(String value) {
			addCriterion("SEND_USER_NAME <>", value, "sendUserName");
			return (Criteria) this;
		}

		public Criteria andSendUserNameGreaterThan(String value) {
			addCriterion("SEND_USER_NAME >", value, "sendUserName");
			return (Criteria) this;
		}

		public Criteria andSendUserNameGreaterThanOrEqualTo(String value) {
			addCriterion("SEND_USER_NAME >=", value, "sendUserName");
			return (Criteria) this;
		}

		public Criteria andSendUserNameLessThan(String value) {
			addCriterion("SEND_USER_NAME <", value, "sendUserName");
			return (Criteria) this;
		}

		public Criteria andSendUserNameLessThanOrEqualTo(String value) {
			addCriterion("SEND_USER_NAME <=", value, "sendUserName");
			return (Criteria) this;
		}

		public Criteria andSendUserNameLike(String value) {
			addCriterion("SEND_USER_NAME like", value, "sendUserName");
			return (Criteria) this;
		}

		public Criteria andSendUserNameNotLike(String value) {
			addCriterion("SEND_USER_NAME not like", value, "sendUserName");
			return (Criteria) this;
		}

		public Criteria andSendUserNameIn(List<String> values) {
			addCriterion("SEND_USER_NAME in", values, "sendUserName");
			return (Criteria) this;
		}

		public Criteria andSendUserNameNotIn(List<String> values) {
			addCriterion("SEND_USER_NAME not in", values, "sendUserName");
			return (Criteria) this;
		}

		public Criteria andSendUserNameBetween(String value1, String value2) {
			addCriterion("SEND_USER_NAME between", value1, value2, "sendUserName");
			return (Criteria) this;
		}

		public Criteria andSendUserNameNotBetween(String value1, String value2) {
			addCriterion("SEND_USER_NAME not between", value1, value2, "sendUserName");
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

		public Criteria andSendNowIsNull() {
			addCriterion("SEND_NOW is null");
			return (Criteria) this;
		}

		public Criteria andSendNowIsNotNull() {
			addCriterion("SEND_NOW is not null");
			return (Criteria) this;
		}

		public Criteria andSendNowEqualTo(Byte value) {
			addCriterion("SEND_NOW =", value, "sendNow");
			return (Criteria) this;
		}

		public Criteria andSendNowNotEqualTo(Byte value) {
			addCriterion("SEND_NOW <>", value, "sendNow");
			return (Criteria) this;
		}

		public Criteria andSendNowGreaterThan(Byte value) {
			addCriterion("SEND_NOW >", value, "sendNow");
			return (Criteria) this;
		}

		public Criteria andSendNowGreaterThanOrEqualTo(Byte value) {
			addCriterion("SEND_NOW >=", value, "sendNow");
			return (Criteria) this;
		}

		public Criteria andSendNowLessThan(Byte value) {
			addCriterion("SEND_NOW <", value, "sendNow");
			return (Criteria) this;
		}

		public Criteria andSendNowLessThanOrEqualTo(Byte value) {
			addCriterion("SEND_NOW <=", value, "sendNow");
			return (Criteria) this;
		}

		public Criteria andSendNowIn(List<Byte> values) {
			addCriterion("SEND_NOW in", values, "sendNow");
			return (Criteria) this;
		}

		public Criteria andSendNowNotIn(List<Byte> values) {
			addCriterion("SEND_NOW not in", values, "sendNow");
			return (Criteria) this;
		}

		public Criteria andSendNowBetween(Byte value1, Byte value2) {
			addCriterion("SEND_NOW between", value1, value2, "sendNow");
			return (Criteria) this;
		}

		public Criteria andSendNowNotBetween(Byte value1, Byte value2) {
			addCriterion("SEND_NOW not between", value1, value2, "sendNow");
			return (Criteria) this;
		}

		public Criteria andSendTimeIsNull() {
			addCriterion("SEND_TIME is null");
			return (Criteria) this;
		}

		public Criteria andSendTimeIsNotNull() {
			addCriterion("SEND_TIME is not null");
			return (Criteria) this;
		}

		public Criteria andSendTimeEqualTo(Date value) {
			addCriterion("SEND_TIME =", value, "sendTime");
			return (Criteria) this;
		}

		public Criteria andSendTimeNotEqualTo(Date value) {
			addCriterion("SEND_TIME <>", value, "sendTime");
			return (Criteria) this;
		}

		public Criteria andSendTimeGreaterThan(Date value) {
			addCriterion("SEND_TIME >", value, "sendTime");
			return (Criteria) this;
		}

		public Criteria andSendTimeGreaterThanOrEqualTo(Date value) {
			addCriterion("SEND_TIME >=", value, "sendTime");
			return (Criteria) this;
		}

		public Criteria andSendTimeLessThan(Date value) {
			addCriterion("SEND_TIME <", value, "sendTime");
			return (Criteria) this;
		}

		public Criteria andSendTimeLessThanOrEqualTo(Date value) {
			addCriterion("SEND_TIME <=", value, "sendTime");
			return (Criteria) this;
		}

		public Criteria andSendTimeIn(List<Date> values) {
			addCriterion("SEND_TIME in", values, "sendTime");
			return (Criteria) this;
		}

		public Criteria andSendTimeNotIn(List<Date> values) {
			addCriterion("SEND_TIME not in", values, "sendTime");
			return (Criteria) this;
		}

		public Criteria andSendTimeBetween(Date value1, Date value2) {
			addCriterion("SEND_TIME between", value1, value2, "sendTime");
			return (Criteria) this;
		}

		public Criteria andSendTimeNotBetween(Date value1, Date value2) {
			addCriterion("SEND_TIME not between", value1, value2, "sendTime");
			return (Criteria) this;
		}

		public Criteria andDelStatusIsNull() {
			addCriterion("DEL_STATUS is null");
			return (Criteria) this;
		}

		public Criteria andDelStatusIsNotNull() {
			addCriterion("DEL_STATUS is not null");
			return (Criteria) this;
		}

		public Criteria andDelStatusEqualTo(Byte value) {
			addCriterion("DEL_STATUS =", value, "delStatus");
			return (Criteria) this;
		}

		public Criteria andDelStatusNotEqualTo(Byte value) {
			addCriterion("DEL_STATUS <>", value, "delStatus");
			return (Criteria) this;
		}

		public Criteria andDelStatusGreaterThan(Byte value) {
			addCriterion("DEL_STATUS >", value, "delStatus");
			return (Criteria) this;
		}

		public Criteria andDelStatusGreaterThanOrEqualTo(Byte value) {
			addCriterion("DEL_STATUS >=", value, "delStatus");
			return (Criteria) this;
		}

		public Criteria andDelStatusLessThan(Byte value) {
			addCriterion("DEL_STATUS <", value, "delStatus");
			return (Criteria) this;
		}

		public Criteria andDelStatusLessThanOrEqualTo(Byte value) {
			addCriterion("DEL_STATUS <=", value, "delStatus");
			return (Criteria) this;
		}

		public Criteria andDelStatusIn(List<Byte> values) {
			addCriterion("DEL_STATUS in", values, "delStatus");
			return (Criteria) this;
		}

		public Criteria andDelStatusNotIn(List<Byte> values) {
			addCriterion("DEL_STATUS not in", values, "delStatus");
			return (Criteria) this;
		}

		public Criteria andDelStatusBetween(Byte value1, Byte value2) {
			addCriterion("DEL_STATUS between", value1, value2, "delStatus");
			return (Criteria) this;
		}

		public Criteria andDelStatusNotBetween(Byte value1, Byte value2) {
			addCriterion("DEL_STATUS not between", value1, value2, "delStatus");
			return (Criteria) this;
		}

		public Criteria andSendUserOrgIdIsNull() {
			addCriterion("SEND_USER_ORG_ID is null");
			return (Criteria) this;
		}

		public Criteria andSendUserOrgIdIsNotNull() {
			addCriterion("SEND_USER_ORG_ID is not null");
			return (Criteria) this;
		}

		public Criteria andSendUserOrgIdEqualTo(Integer value) {
			addCriterion("SEND_USER_ORG_ID =", value, "sendUserOrgId");
			return (Criteria) this;
		}

		public Criteria andSendUserOrgIdNotEqualTo(Integer value) {
			addCriterion("SEND_USER_ORG_ID <>", value, "sendUserOrgId");
			return (Criteria) this;
		}

		public Criteria andSendUserOrgIdGreaterThan(Integer value) {
			addCriterion("SEND_USER_ORG_ID >", value, "sendUserOrgId");
			return (Criteria) this;
		}

		public Criteria andSendUserOrgIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("SEND_USER_ORG_ID >=", value, "sendUserOrgId");
			return (Criteria) this;
		}

		public Criteria andSendUserOrgIdLessThan(Integer value) {
			addCriterion("SEND_USER_ORG_ID <", value, "sendUserOrgId");
			return (Criteria) this;
		}

		public Criteria andSendUserOrgIdLessThanOrEqualTo(Integer value) {
			addCriterion("SEND_USER_ORG_ID <=", value, "sendUserOrgId");
			return (Criteria) this;
		}

		public Criteria andSendUserOrgIdIn(List<Integer> values) {
			addCriterion("SEND_USER_ORG_ID in", values, "sendUserOrgId");
			return (Criteria) this;
		}

		public Criteria andSendUserOrgIdNotIn(List<Integer> values) {
			addCriterion("SEND_USER_ORG_ID not in", values, "sendUserOrgId");
			return (Criteria) this;
		}

		public Criteria andSendUserOrgIdBetween(Integer value1, Integer value2) {
			addCriterion("SEND_USER_ORG_ID between", value1, value2, "sendUserOrgId");
			return (Criteria) this;
		}

		public Criteria andSendUserOrgIdNotBetween(Integer value1, Integer value2) {
			addCriterion("SEND_USER_ORG_ID not between", value1, value2, "sendUserOrgId");
			return (Criteria) this;
		}

		public Criteria andSendUserOrgPathIsNull() {
			addCriterion("SEND_USER_ORG_PATH is null");
			return (Criteria) this;
		}

		public Criteria andSendUserOrgPathIsNotNull() {
			addCriterion("SEND_USER_ORG_PATH is not null");
			return (Criteria) this;
		}

		public Criteria andSendUserOrgPathEqualTo(String value) {
			addCriterion("SEND_USER_ORG_PATH =", value, "sendUserOrgPath");
			return (Criteria) this;
		}

		public Criteria andSendUserOrgPathNotEqualTo(String value) {
			addCriterion("SEND_USER_ORG_PATH <>", value, "sendUserOrgPath");
			return (Criteria) this;
		}

		public Criteria andSendUserOrgPathGreaterThan(String value) {
			addCriterion("SEND_USER_ORG_PATH >", value, "sendUserOrgPath");
			return (Criteria) this;
		}

		public Criteria andSendUserOrgPathGreaterThanOrEqualTo(String value) {
			addCriterion("SEND_USER_ORG_PATH >=", value, "sendUserOrgPath");
			return (Criteria) this;
		}

		public Criteria andSendUserOrgPathLessThan(String value) {
			addCriterion("SEND_USER_ORG_PATH <", value, "sendUserOrgPath");
			return (Criteria) this;
		}

		public Criteria andSendUserOrgPathLessThanOrEqualTo(String value) {
			addCriterion("SEND_USER_ORG_PATH <=", value, "sendUserOrgPath");
			return (Criteria) this;
		}

		public Criteria andSendUserOrgPathLike(String value) {
			addCriterion("SEND_USER_ORG_PATH like", value, "sendUserOrgPath");
			return (Criteria) this;
		}

		public Criteria andSendUserOrgPathNotLike(String value) {
			addCriterion("SEND_USER_ORG_PATH not like", value, "sendUserOrgPath");
			return (Criteria) this;
		}

		public Criteria andSendUserOrgPathIn(List<String> values) {
			addCriterion("SEND_USER_ORG_PATH in", values, "sendUserOrgPath");
			return (Criteria) this;
		}

		public Criteria andSendUserOrgPathNotIn(List<String> values) {
			addCriterion("SEND_USER_ORG_PATH not in", values, "sendUserOrgPath");
			return (Criteria) this;
		}

		public Criteria andSendUserOrgPathBetween(String value1, String value2) {
			addCriterion("SEND_USER_ORG_PATH between", value1, value2, "sendUserOrgPath");
			return (Criteria) this;
		}

		public Criteria andSendUserOrgPathNotBetween(String value1, String value2) {
			addCriterion("SEND_USER_ORG_PATH not between", value1, value2, "sendUserOrgPath");
			return (Criteria) this;
		}

		public Criteria andTaskNameIsNull() {
			addCriterion("TASK_NAME is null");
			return (Criteria) this;
		}

		public Criteria andTaskNameIsNotNull() {
			addCriterion("TASK_NAME is not null");
			return (Criteria) this;
		}

		public Criteria andTaskNameEqualTo(String value) {
			addCriterion("TASK_NAME =", value, "taskName");
			return (Criteria) this;
		}

		public Criteria andTaskNameNotEqualTo(String value) {
			addCriterion("TASK_NAME <>", value, "taskName");
			return (Criteria) this;
		}

		public Criteria andTaskNameGreaterThan(String value) {
			addCriterion("TASK_NAME >", value, "taskName");
			return (Criteria) this;
		}

		public Criteria andTaskNameGreaterThanOrEqualTo(String value) {
			addCriterion("TASK_NAME >=", value, "taskName");
			return (Criteria) this;
		}

		public Criteria andTaskNameLessThan(String value) {
			addCriterion("TASK_NAME <", value, "taskName");
			return (Criteria) this;
		}

		public Criteria andTaskNameLessThanOrEqualTo(String value) {
			addCriterion("TASK_NAME <=", value, "taskName");
			return (Criteria) this;
		}

		public Criteria andTaskNameLike(String value) {
			addCriterion("TASK_NAME like", value, "taskName");
			return (Criteria) this;
		}

		public Criteria andTaskNameNotLike(String value) {
			addCriterion("TASK_NAME not like", value, "taskName");
			return (Criteria) this;
		}

		public Criteria andTaskNameIn(List<String> values) {
			addCriterion("TASK_NAME in", values, "taskName");
			return (Criteria) this;
		}

		public Criteria andTaskNameNotIn(List<String> values) {
			addCriterion("TASK_NAME not in", values, "taskName");
			return (Criteria) this;
		}

		public Criteria andTaskNameBetween(String value1, String value2) {
			addCriterion("TASK_NAME between", value1, value2, "taskName");
			return (Criteria) this;
		}

		public Criteria andTaskNameNotBetween(String value1, String value2) {
			addCriterion("TASK_NAME not between", value1, value2, "taskName");
			return (Criteria) this;
		}

		public Criteria andTaskDescriptionIsNull() {
			addCriterion("TASK_DESCRIPTION is null");
			return (Criteria) this;
		}

		public Criteria andTaskDescriptionIsNotNull() {
			addCriterion("TASK_DESCRIPTION is not null");
			return (Criteria) this;
		}

		public Criteria andTaskDescriptionEqualTo(String value) {
			addCriterion("TASK_DESCRIPTION =", value, "taskDescription");
			return (Criteria) this;
		}

		public Criteria andTaskDescriptionNotEqualTo(String value) {
			addCriterion("TASK_DESCRIPTION <>", value, "taskDescription");
			return (Criteria) this;
		}

		public Criteria andTaskDescriptionGreaterThan(String value) {
			addCriterion("TASK_DESCRIPTION >", value, "taskDescription");
			return (Criteria) this;
		}

		public Criteria andTaskDescriptionGreaterThanOrEqualTo(String value) {
			addCriterion("TASK_DESCRIPTION >=", value, "taskDescription");
			return (Criteria) this;
		}

		public Criteria andTaskDescriptionLessThan(String value) {
			addCriterion("TASK_DESCRIPTION <", value, "taskDescription");
			return (Criteria) this;
		}

		public Criteria andTaskDescriptionLessThanOrEqualTo(String value) {
			addCriterion("TASK_DESCRIPTION <=", value, "taskDescription");
			return (Criteria) this;
		}

		public Criteria andTaskDescriptionLike(String value) {
			addCriterion("TASK_DESCRIPTION like", value, "taskDescription");
			return (Criteria) this;
		}

		public Criteria andTaskDescriptionNotLike(String value) {
			addCriterion("TASK_DESCRIPTION not like", value, "taskDescription");
			return (Criteria) this;
		}

		public Criteria andTaskDescriptionIn(List<String> values) {
			addCriterion("TASK_DESCRIPTION in", values, "taskDescription");
			return (Criteria) this;
		}

		public Criteria andTaskDescriptionNotIn(List<String> values) {
			addCriterion("TASK_DESCRIPTION not in", values, "taskDescription");
			return (Criteria) this;
		}

		public Criteria andTaskDescriptionBetween(String value1, String value2) {
			addCriterion("TASK_DESCRIPTION between", value1, value2, "taskDescription");
			return (Criteria) this;
		}

		public Criteria andTaskDescriptionNotBetween(String value1, String value2) {
			addCriterion("TASK_DESCRIPTION not between", value1, value2, "taskDescription");
			return (Criteria) this;
		}

		public Criteria andCaseIdIsNull() {
			addCriterion("CASE_ID is null");
			return (Criteria) this;
		}

		public Criteria andCaseIdIsNotNull() {
			addCriterion("CASE_ID is not null");
			return (Criteria) this;
		}

		public Criteria andCaseIdEqualTo(Integer value) {
			addCriterion("CASE_ID =", value, "caseId");
			return (Criteria) this;
		}

		public Criteria andCaseIdNotEqualTo(Integer value) {
			addCriterion("CASE_ID <>", value, "caseId");
			return (Criteria) this;
		}

		public Criteria andCaseIdGreaterThan(Integer value) {
			addCriterion("CASE_ID >", value, "caseId");
			return (Criteria) this;
		}

		public Criteria andCaseIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("CASE_ID >=", value, "caseId");
			return (Criteria) this;
		}

		public Criteria andCaseIdLessThan(Integer value) {
			addCriterion("CASE_ID <", value, "caseId");
			return (Criteria) this;
		}

		public Criteria andCaseIdLessThanOrEqualTo(Integer value) {
			addCriterion("CASE_ID <=", value, "caseId");
			return (Criteria) this;
		}

		public Criteria andCaseIdIn(List<Integer> values) {
			addCriterion("CASE_ID in", values, "caseId");
			return (Criteria) this;
		}

		public Criteria andCaseIdNotIn(List<Integer> values) {
			addCriterion("CASE_ID not in", values, "caseId");
			return (Criteria) this;
		}

		public Criteria andCaseIdBetween(Integer value1, Integer value2) {
			addCriterion("CASE_ID between", value1, value2, "caseId");
			return (Criteria) this;
		}

		public Criteria andCaseIdNotBetween(Integer value1, Integer value2) {
			addCriterion("CASE_ID not between", value1, value2, "caseId");
			return (Criteria) this;
		}

		public Criteria andCaseTypeIsNull() {
			addCriterion("CASE_TYPE is null");
			return (Criteria) this;
		}

		public Criteria andCaseTypeIsNotNull() {
			addCriterion("CASE_TYPE is not null");
			return (Criteria) this;
		}

		public Criteria andCaseTypeEqualTo(Byte value) {
			addCriterion("CASE_TYPE =", value, "caseType");
			return (Criteria) this;
		}

		public Criteria andCaseTypeNotEqualTo(Byte value) {
			addCriterion("CASE_TYPE <>", value, "caseType");
			return (Criteria) this;
		}

		public Criteria andCaseTypeGreaterThan(Byte value) {
			addCriterion("CASE_TYPE >", value, "caseType");
			return (Criteria) this;
		}

		public Criteria andCaseTypeGreaterThanOrEqualTo(Byte value) {
			addCriterion("CASE_TYPE >=", value, "caseType");
			return (Criteria) this;
		}

		public Criteria andCaseTypeLessThan(Byte value) {
			addCriterion("CASE_TYPE <", value, "caseType");
			return (Criteria) this;
		}

		public Criteria andCaseTypeLessThanOrEqualTo(Byte value) {
			addCriterion("CASE_TYPE <=", value, "caseType");
			return (Criteria) this;
		}

		public Criteria andCaseTypeIn(List<Byte> values) {
			addCriterion("CASE_TYPE in", values, "caseType");
			return (Criteria) this;
		}

		public Criteria andCaseTypeNotIn(List<Byte> values) {
			addCriterion("CASE_TYPE not in", values, "caseType");
			return (Criteria) this;
		}

		public Criteria andCaseTypeBetween(Byte value1, Byte value2) {
			addCriterion("CASE_TYPE between", value1, value2, "caseType");
			return (Criteria) this;
		}

		public Criteria andCaseTypeNotBetween(Byte value1, Byte value2) {
			addCriterion("CASE_TYPE not between", value1, value2, "caseType");
			return (Criteria) this;
		}

		public Criteria andCompleteStatusIsNull() {
			addCriterion("COMPLETE_STATUS is null");
			return (Criteria) this;
		}

		public Criteria andCompleteStatusIsNotNull() {
			addCriterion("COMPLETE_STATUS is not null");
			return (Criteria) this;
		}

		public Criteria andCompleteStatusEqualTo(Byte value) {
			addCriterion("COMPLETE_STATUS =", value, "completeStatus");
			return (Criteria) this;
		}

		public Criteria andCompleteStatusNotEqualTo(Byte value) {
			addCriterion("COMPLETE_STATUS <>", value, "completeStatus");
			return (Criteria) this;
		}

		public Criteria andCompleteStatusGreaterThan(Byte value) {
			addCriterion("COMPLETE_STATUS >", value, "completeStatus");
			return (Criteria) this;
		}

		public Criteria andCompleteStatusGreaterThanOrEqualTo(Byte value) {
			addCriterion("COMPLETE_STATUS >=", value, "completeStatus");
			return (Criteria) this;
		}

		public Criteria andCompleteStatusLessThan(Byte value) {
			addCriterion("COMPLETE_STATUS <", value, "completeStatus");
			return (Criteria) this;
		}

		public Criteria andCompleteStatusLessThanOrEqualTo(Byte value) {
			addCriterion("COMPLETE_STATUS <=", value, "completeStatus");
			return (Criteria) this;
		}

		public Criteria andCompleteStatusIn(List<Byte> values) {
			addCriterion("COMPLETE_STATUS in", values, "completeStatus");
			return (Criteria) this;
		}

		public Criteria andCompleteStatusNotIn(List<Byte> values) {
			addCriterion("COMPLETE_STATUS not in", values, "completeStatus");
			return (Criteria) this;
		}

		public Criteria andCompleteStatusBetween(Byte value1, Byte value2) {
			addCriterion("COMPLETE_STATUS between", value1, value2, "completeStatus");
			return (Criteria) this;
		}

		public Criteria andCompleteStatusNotBetween(Byte value1, Byte value2) {
			addCriterion("COMPLETE_STATUS not between", value1, value2, "completeStatus");
			return (Criteria) this;
		}

		public Criteria andTaskEndTimeIsNull() {
			addCriterion("TASK_END_TIME is null");
			return (Criteria) this;
		}

		public Criteria andTaskEndTimeIsNotNull() {
			addCriterion("TASK_END_TIME is not null");
			return (Criteria) this;
		}

		public Criteria andTaskEndTimeEqualTo(Date value) {
			addCriterion("TASK_END_TIME =", value, "taskEndTime");
			return (Criteria) this;
		}

		public Criteria andTaskEndTimeNotEqualTo(Date value) {
			addCriterion("TASK_END_TIME <>", value, "taskEndTime");
			return (Criteria) this;
		}

		public Criteria andTaskEndTimeGreaterThan(Date value) {
			addCriterion("TASK_END_TIME >", value, "taskEndTime");
			return (Criteria) this;
		}

		public Criteria andTaskEndTimeGreaterThanOrEqualTo(Date value) {
			addCriterion("TASK_END_TIME >=", value, "taskEndTime");
			return (Criteria) this;
		}

		public Criteria andTaskEndTimeLessThan(Date value) {
			addCriterion("TASK_END_TIME <", value, "taskEndTime");
			return (Criteria) this;
		}

		public Criteria andTaskEndTimeLessThanOrEqualTo(Date value) {
			addCriterion("TASK_END_TIME <=", value, "taskEndTime");
			return (Criteria) this;
		}

		public Criteria andTaskEndTimeIn(List<Date> values) {
			addCriterion("TASK_END_TIME in", values, "taskEndTime");
			return (Criteria) this;
		}

		public Criteria andTaskEndTimeNotIn(List<Date> values) {
			addCriterion("TASK_END_TIME not in", values, "taskEndTime");
			return (Criteria) this;
		}

		public Criteria andTaskEndTimeBetween(Date value1, Date value2) {
			addCriterion("TASK_END_TIME between", value1, value2, "taskEndTime");
			return (Criteria) this;
		}

		public Criteria andTaskEndTimeNotBetween(Date value1, Date value2) {
			addCriterion("TASK_END_TIME not between", value1, value2, "taskEndTime");
			return (Criteria) this;
		}

		public Criteria andTaskCompleteTimeIsNull() {
			addCriterion("TASK_COMPLETE_TIME is null");
			return (Criteria) this;
		}

		public Criteria andTaskCompleteTimeIsNotNull() {
			addCriterion("TASK_COMPLETE_TIME is not null");
			return (Criteria) this;
		}

		public Criteria andTaskCompleteTimeEqualTo(Date value) {
			addCriterion("TASK_COMPLETE_TIME =", value, "taskCompleteTime");
			return (Criteria) this;
		}

		public Criteria andTaskCompleteTimeNotEqualTo(Date value) {
			addCriterion("TASK_COMPLETE_TIME <>", value, "taskCompleteTime");
			return (Criteria) this;
		}

		public Criteria andTaskCompleteTimeGreaterThan(Date value) {
			addCriterion("TASK_COMPLETE_TIME >", value, "taskCompleteTime");
			return (Criteria) this;
		}

		public Criteria andTaskCompleteTimeGreaterThanOrEqualTo(Date value) {
			addCriterion("TASK_COMPLETE_TIME >=", value, "taskCompleteTime");
			return (Criteria) this;
		}

		public Criteria andTaskCompleteTimeLessThan(Date value) {
			addCriterion("TASK_COMPLETE_TIME <", value, "taskCompleteTime");
			return (Criteria) this;
		}

		public Criteria andTaskCompleteTimeLessThanOrEqualTo(Date value) {
			addCriterion("TASK_COMPLETE_TIME <=", value, "taskCompleteTime");
			return (Criteria) this;
		}

		public Criteria andTaskCompleteTimeIn(List<Date> values) {
			addCriterion("TASK_COMPLETE_TIME in", values, "taskCompleteTime");
			return (Criteria) this;
		}

		public Criteria andTaskCompleteTimeNotIn(List<Date> values) {
			addCriterion("TASK_COMPLETE_TIME not in", values, "taskCompleteTime");
			return (Criteria) this;
		}

		public Criteria andTaskCompleteTimeBetween(Date value1, Date value2) {
			addCriterion("TASK_COMPLETE_TIME between", value1, value2, "taskCompleteTime");
			return (Criteria) this;
		}

		public Criteria andTaskCompleteTimeNotBetween(Date value1, Date value2) {
			addCriterion("TASK_COMPLETE_TIME not between", value1, value2, "taskCompleteTime");
			return (Criteria) this;
		}

		public Criteria andTaskRemarkIsNull() {
			addCriterion("TASK_REMARK is null");
			return (Criteria) this;
		}

		public Criteria andTaskRemarkIsNotNull() {
			addCriterion("TASK_REMARK is not null");
			return (Criteria) this;
		}

		public Criteria andTaskRemarkEqualTo(String value) {
			addCriterion("TASK_REMARK =", value, "taskRemark");
			return (Criteria) this;
		}

		public Criteria andTaskRemarkNotEqualTo(String value) {
			addCriterion("TASK_REMARK <>", value, "taskRemark");
			return (Criteria) this;
		}

		public Criteria andTaskRemarkGreaterThan(String value) {
			addCriterion("TASK_REMARK >", value, "taskRemark");
			return (Criteria) this;
		}

		public Criteria andTaskRemarkGreaterThanOrEqualTo(String value) {
			addCriterion("TASK_REMARK >=", value, "taskRemark");
			return (Criteria) this;
		}

		public Criteria andTaskRemarkLessThan(String value) {
			addCriterion("TASK_REMARK <", value, "taskRemark");
			return (Criteria) this;
		}

		public Criteria andTaskRemarkLessThanOrEqualTo(String value) {
			addCriterion("TASK_REMARK <=", value, "taskRemark");
			return (Criteria) this;
		}

		public Criteria andTaskRemarkLike(String value) {
			addCriterion("TASK_REMARK like", value, "taskRemark");
			return (Criteria) this;
		}

		public Criteria andTaskRemarkNotLike(String value) {
			addCriterion("TASK_REMARK not like", value, "taskRemark");
			return (Criteria) this;
		}

		public Criteria andTaskRemarkIn(List<String> values) {
			addCriterion("TASK_REMARK in", values, "taskRemark");
			return (Criteria) this;
		}

		public Criteria andTaskRemarkNotIn(List<String> values) {
			addCriterion("TASK_REMARK not in", values, "taskRemark");
			return (Criteria) this;
		}

		public Criteria andTaskRemarkBetween(String value1, String value2) {
			addCriterion("TASK_REMARK between", value1, value2, "taskRemark");
			return (Criteria) this;
		}

		public Criteria andTaskRemarkNotBetween(String value1, String value2) {
			addCriterion("TASK_REMARK not between", value1, value2, "taskRemark");
			return (Criteria) this;
		}

		public Criteria andAccessoryAddrIsNull() {
			addCriterion("ACCESSORY_ADDR is null");
			return (Criteria) this;
		}

		public Criteria andAccessoryAddrIsNotNull() {
			addCriterion("ACCESSORY_ADDR is not null");
			return (Criteria) this;
		}

		public Criteria andAccessoryAddrEqualTo(String value) {
			addCriterion("ACCESSORY_ADDR =", value, "accessoryAddr");
			return (Criteria) this;
		}

		public Criteria andAccessoryAddrNotEqualTo(String value) {
			addCriterion("ACCESSORY_ADDR <>", value, "accessoryAddr");
			return (Criteria) this;
		}

		public Criteria andAccessoryAddrGreaterThan(String value) {
			addCriterion("ACCESSORY_ADDR >", value, "accessoryAddr");
			return (Criteria) this;
		}

		public Criteria andAccessoryAddrGreaterThanOrEqualTo(String value) {
			addCriterion("ACCESSORY_ADDR >=", value, "accessoryAddr");
			return (Criteria) this;
		}

		public Criteria andAccessoryAddrLessThan(String value) {
			addCriterion("ACCESSORY_ADDR <", value, "accessoryAddr");
			return (Criteria) this;
		}

		public Criteria andAccessoryAddrLessThanOrEqualTo(String value) {
			addCriterion("ACCESSORY_ADDR <=", value, "accessoryAddr");
			return (Criteria) this;
		}

		public Criteria andAccessoryAddrLike(String value) {
			addCriterion("ACCESSORY_ADDR like", value, "accessoryAddr");
			return (Criteria) this;
		}

		public Criteria andAccessoryAddrNotLike(String value) {
			addCriterion("ACCESSORY_ADDR not like", value, "accessoryAddr");
			return (Criteria) this;
		}

		public Criteria andAccessoryAddrIn(List<String> values) {
			addCriterion("ACCESSORY_ADDR in", values, "accessoryAddr");
			return (Criteria) this;
		}

		public Criteria andAccessoryAddrNotIn(List<String> values) {
			addCriterion("ACCESSORY_ADDR not in", values, "accessoryAddr");
			return (Criteria) this;
		}

		public Criteria andAccessoryAddrBetween(String value1, String value2) {
			addCriterion("ACCESSORY_ADDR between", value1, value2, "accessoryAddr");
			return (Criteria) this;
		}

		public Criteria andAccessoryAddrNotBetween(String value1, String value2) {
			addCriterion("ACCESSORY_ADDR not between", value1, value2, "accessoryAddr");
			return (Criteria) this;
		}

		public Criteria andSeeStatusIsNull() {
			addCriterion("SEE_STATUS is null");
			return (Criteria) this;
		}

		public Criteria andSeeStatusIsNotNull() {
			addCriterion("SEE_STATUS is not null");
			return (Criteria) this;
		}

		public Criteria andSeeStatusEqualTo(Byte value) {
			addCriterion("SEE_STATUS =", value, "seeStatus");
			return (Criteria) this;
		}

		public Criteria andSeeStatusNotEqualTo(Byte value) {
			addCriterion("SEE_STATUS <>", value, "seeStatus");
			return (Criteria) this;
		}

		public Criteria andSeeStatusGreaterThan(Byte value) {
			addCriterion("SEE_STATUS >", value, "seeStatus");
			return (Criteria) this;
		}

		public Criteria andSeeStatusGreaterThanOrEqualTo(Byte value) {
			addCriterion("SEE_STATUS >=", value, "seeStatus");
			return (Criteria) this;
		}

		public Criteria andSeeStatusLessThan(Byte value) {
			addCriterion("SEE_STATUS <", value, "seeStatus");
			return (Criteria) this;
		}

		public Criteria andSeeStatusLessThanOrEqualTo(Byte value) {
			addCriterion("SEE_STATUS <=", value, "seeStatus");
			return (Criteria) this;
		}

		public Criteria andSeeStatusIn(List<Byte> values) {
			addCriterion("SEE_STATUS in", values, "seeStatus");
			return (Criteria) this;
		}

		public Criteria andSeeStatusNotIn(List<Byte> values) {
			addCriterion("SEE_STATUS not in", values, "seeStatus");
			return (Criteria) this;
		}

		public Criteria andSeeStatusBetween(Byte value1, Byte value2) {
			addCriterion("SEE_STATUS between", value1, value2, "seeStatus");
			return (Criteria) this;
		}

		public Criteria andSeeStatusNotBetween(Byte value1, Byte value2) {
			addCriterion("SEE_STATUS not between", value1, value2, "seeStatus");
			return (Criteria) this;
		}

		public Criteria andTaskTypeIsNull() {
			addCriterion("TASK_TYPE is null");
			return (Criteria) this;
		}

		public Criteria andTaskTypeIsNotNull() {
			addCriterion("TASK_TYPE is not null");
			return (Criteria) this;
		}

		public Criteria andTaskTypeEqualTo(Byte value) {
			addCriterion("TASK_TYPE =", value, "taskType");
			return (Criteria) this;
		}

		public Criteria andTaskTypeNotEqualTo(Byte value) {
			addCriterion("TASK_TYPE <>", value, "taskType");
			return (Criteria) this;
		}

		public Criteria andTaskTypeGreaterThan(Byte value) {
			addCriterion("TASK_TYPE >", value, "taskType");
			return (Criteria) this;
		}

		public Criteria andTaskTypeGreaterThanOrEqualTo(Byte value) {
			addCriterion("TASK_TYPE >=", value, "taskType");
			return (Criteria) this;
		}

		public Criteria andTaskTypeLessThan(Byte value) {
			addCriterion("TASK_TYPE <", value, "taskType");
			return (Criteria) this;
		}

		public Criteria andTaskTypeLessThanOrEqualTo(Byte value) {
			addCriterion("TASK_TYPE <=", value, "taskType");
			return (Criteria) this;
		}

		public Criteria andTaskTypeIn(List<Byte> values) {
			addCriterion("TASK_TYPE in", values, "taskType");
			return (Criteria) this;
		}

		public Criteria andTaskTypeNotIn(List<Byte> values) {
			addCriterion("TASK_TYPE not in", values, "taskType");
			return (Criteria) this;
		}

		public Criteria andTaskTypeBetween(Byte value1, Byte value2) {
			addCriterion("TASK_TYPE between", value1, value2, "taskType");
			return (Criteria) this;
		}

		public Criteria andTaskTypeNotBetween(Byte value1, Byte value2) {
			addCriterion("TASK_TYPE not between", value1, value2, "taskType");
			return (Criteria) this;
		}

		public Criteria andRecieveUsersIdIsNull() {
			addCriterion("RECIEVE_USERS_ID is null");
			return (Criteria) this;
		}

		public Criteria andRecieveUsersIdIsNotNull() {
			addCriterion("RECIEVE_USERS_ID is not null");
			return (Criteria) this;
		}

		public Criteria andRecieveUsersIdEqualTo(Integer value) {
			addCriterion("RECIEVE_USERS_ID =", value, "recieveUsersId");
			return (Criteria) this;
		}

		public Criteria andRecieveUsersIdNotEqualTo(Integer value) {
			addCriterion("RECIEVE_USERS_ID <>", value, "recieveUsersId");
			return (Criteria) this;
		}

		public Criteria andRecieveUsersIdGreaterThan(Integer value) {
			addCriterion("RECIEVE_USERS_ID >", value, "recieveUsersId");
			return (Criteria) this;
		}

		public Criteria andRecieveUsersIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("RECIEVE_USERS_ID >=", value, "recieveUsersId");
			return (Criteria) this;
		}

		public Criteria andRecieveUsersIdLessThan(Integer value) {
			addCriterion("RECIEVE_USERS_ID <", value, "recieveUsersId");
			return (Criteria) this;
		}

		public Criteria andRecieveUsersIdLessThanOrEqualTo(Integer value) {
			addCriterion("RECIEVE_USERS_ID <=", value, "recieveUsersId");
			return (Criteria) this;
		}

		public Criteria andRecieveUsersIdIn(List<Integer> values) {
			addCriterion("RECIEVE_USERS_ID in", values, "recieveUsersId");
			return (Criteria) this;
		}

		public Criteria andRecieveUsersIdNotIn(List<Integer> values) {
			addCriterion("RECIEVE_USERS_ID not in", values, "recieveUsersId");
			return (Criteria) this;
		}

		public Criteria andRecieveUsersIdBetween(Integer value1, Integer value2) {
			addCriterion("RECIEVE_USERS_ID between", value1, value2, "recieveUsersId");
			return (Criteria) this;
		}

		public Criteria andRecieveUsersIdNotBetween(Integer value1, Integer value2) {
			addCriterion("RECIEVE_USERS_ID not between", value1, value2, "recieveUsersId");
			return (Criteria) this;
		}

		public Criteria andRecieveArchiveIdIsNull() {
			addCriterion("RECIEVE_ARCHIVE_ID is null");
			return (Criteria) this;
		}

		public Criteria andRecieveArchiveIdIsNotNull() {
			addCriterion("RECIEVE_ARCHIVE_ID is not null");
			return (Criteria) this;
		}

		public Criteria andRecieveArchiveIdEqualTo(Integer value) {
			addCriterion("RECIEVE_ARCHIVE_ID =", value, "recieveArchiveId");
			return (Criteria) this;
		}

		public Criteria andRecieveArchiveIdNotEqualTo(Integer value) {
			addCriterion("RECIEVE_ARCHIVE_ID <>", value, "recieveArchiveId");
			return (Criteria) this;
		}

		public Criteria andRecieveArchiveIdGreaterThan(Integer value) {
			addCriterion("RECIEVE_ARCHIVE_ID >", value, "recieveArchiveId");
			return (Criteria) this;
		}

		public Criteria andRecieveArchiveIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("RECIEVE_ARCHIVE_ID >=", value, "recieveArchiveId");
			return (Criteria) this;
		}

		public Criteria andRecieveArchiveIdLessThan(Integer value) {
			addCriterion("RECIEVE_ARCHIVE_ID <", value, "recieveArchiveId");
			return (Criteria) this;
		}

		public Criteria andRecieveArchiveIdLessThanOrEqualTo(Integer value) {
			addCriterion("RECIEVE_ARCHIVE_ID <=", value, "recieveArchiveId");
			return (Criteria) this;
		}

		public Criteria andRecieveArchiveIdIn(List<Integer> values) {
			addCriterion("RECIEVE_ARCHIVE_ID in", values, "recieveArchiveId");
			return (Criteria) this;
		}

		public Criteria andRecieveArchiveIdNotIn(List<Integer> values) {
			addCriterion("RECIEVE_ARCHIVE_ID not in", values, "recieveArchiveId");
			return (Criteria) this;
		}

		public Criteria andRecieveArchiveIdBetween(Integer value1, Integer value2) {
			addCriterion("RECIEVE_ARCHIVE_ID between", value1, value2, "recieveArchiveId");
			return (Criteria) this;
		}

		public Criteria andRecieveArchiveIdNotBetween(Integer value1, Integer value2) {
			addCriterion("RECIEVE_ARCHIVE_ID not between", value1, value2, "recieveArchiveId");
			return (Criteria) this;
		}

		public Criteria andRecieveUsersNameIsNull() {
			addCriterion("RECIEVE_USERS_NAME is null");
			return (Criteria) this;
		}

		public Criteria andRecieveUsersNameIsNotNull() {
			addCriterion("RECIEVE_USERS_NAME is not null");
			return (Criteria) this;
		}

		public Criteria andRecieveUsersNameEqualTo(String value) {
			addCriterion("RECIEVE_USERS_NAME =", value, "recieveUsersName");
			return (Criteria) this;
		}

		public Criteria andRecieveUsersNameNotEqualTo(String value) {
			addCriterion("RECIEVE_USERS_NAME <>", value, "recieveUsersName");
			return (Criteria) this;
		}

		public Criteria andRecieveUsersNameGreaterThan(String value) {
			addCriterion("RECIEVE_USERS_NAME >", value, "recieveUsersName");
			return (Criteria) this;
		}

		public Criteria andRecieveUsersNameGreaterThanOrEqualTo(String value) {
			addCriterion("RECIEVE_USERS_NAME >=", value, "recieveUsersName");
			return (Criteria) this;
		}

		public Criteria andRecieveUsersNameLessThan(String value) {
			addCriterion("RECIEVE_USERS_NAME <", value, "recieveUsersName");
			return (Criteria) this;
		}

		public Criteria andRecieveUsersNameLessThanOrEqualTo(String value) {
			addCriterion("RECIEVE_USERS_NAME <=", value, "recieveUsersName");
			return (Criteria) this;
		}

		public Criteria andRecieveUsersNameLike(String value) {
			addCriterion("RECIEVE_USERS_NAME like", value, "recieveUsersName");
			return (Criteria) this;
		}

		public Criteria andRecieveUsersNameNotLike(String value) {
			addCriterion("RECIEVE_USERS_NAME not like", value, "recieveUsersName");
			return (Criteria) this;
		}

		public Criteria andRecieveUsersNameIn(List<String> values) {
			addCriterion("RECIEVE_USERS_NAME in", values, "recieveUsersName");
			return (Criteria) this;
		}

		public Criteria andRecieveUsersNameNotIn(List<String> values) {
			addCriterion("RECIEVE_USERS_NAME not in", values, "recieveUsersName");
			return (Criteria) this;
		}

		public Criteria andRecieveUsersNameBetween(String value1, String value2) {
			addCriterion("RECIEVE_USERS_NAME between", value1, value2, "recieveUsersName");
			return (Criteria) this;
		}

		public Criteria andRecieveUsersNameNotBetween(String value1, String value2) {
			addCriterion("RECIEVE_USERS_NAME not between", value1, value2, "recieveUsersName");
			return (Criteria) this;
		}

		public Criteria andRecieveUserOrgIdIsNull() {
			addCriterion("RECIEVE_USER_ORG_ID is null");
			return (Criteria) this;
		}

		public Criteria andRecieveUserOrgIdIsNotNull() {
			addCriterion("RECIEVE_USER_ORG_ID is not null");
			return (Criteria) this;
		}

		public Criteria andRecieveUserOrgIdEqualTo(String value) {
			addCriterion("RECIEVE_USER_ORG_ID =", value, "recieveUserOrgId");
			return (Criteria) this;
		}

		public Criteria andRecieveUserOrgIdNotEqualTo(String value) {
			addCriterion("RECIEVE_USER_ORG_ID <>", value, "recieveUserOrgId");
			return (Criteria) this;
		}

		public Criteria andRecieveUserOrgIdGreaterThan(String value) {
			addCriterion("RECIEVE_USER_ORG_ID >", value, "recieveUserOrgId");
			return (Criteria) this;
		}

		public Criteria andRecieveUserOrgIdGreaterThanOrEqualTo(String value) {
			addCriterion("RECIEVE_USER_ORG_ID >=", value, "recieveUserOrgId");
			return (Criteria) this;
		}

		public Criteria andRecieveUserOrgIdLessThan(String value) {
			addCriterion("RECIEVE_USER_ORG_ID <", value, "recieveUserOrgId");
			return (Criteria) this;
		}

		public Criteria andRecieveUserOrgIdLessThanOrEqualTo(String value) {
			addCriterion("RECIEVE_USER_ORG_ID <=", value, "recieveUserOrgId");
			return (Criteria) this;
		}

		public Criteria andRecieveUserOrgIdLike(String value) {
			addCriterion("RECIEVE_USER_ORG_ID like", value, "recieveUserOrgId");
			return (Criteria) this;
		}

		public Criteria andRecieveUserOrgIdNotLike(String value) {
			addCriterion("RECIEVE_USER_ORG_ID not like", value, "recieveUserOrgId");
			return (Criteria) this;
		}

		public Criteria andRecieveUserOrgIdIn(List<String> values) {
			addCriterion("RECIEVE_USER_ORG_ID in", values, "recieveUserOrgId");
			return (Criteria) this;
		}

		public Criteria andRecieveUserOrgIdNotIn(List<String> values) {
			addCriterion("RECIEVE_USER_ORG_ID not in", values, "recieveUserOrgId");
			return (Criteria) this;
		}

		public Criteria andRecieveUserOrgIdBetween(String value1, String value2) {
			addCriterion("RECIEVE_USER_ORG_ID between", value1, value2, "recieveUserOrgId");
			return (Criteria) this;
		}

		public Criteria andRecieveUserOrgIdNotBetween(String value1, String value2) {
			addCriterion("RECIEVE_USER_ORG_ID not between", value1, value2, "recieveUserOrgId");
			return (Criteria) this;
		}

		public Criteria andRecieveUserOrgPathIsNull() {
			addCriterion("RECIEVE_USER_ORG_PATH is null");
			return (Criteria) this;
		}

		public Criteria andRecieveUserOrgPathIsNotNull() {
			addCriterion("RECIEVE_USER_ORG_PATH is not null");
			return (Criteria) this;
		}

		public Criteria andRecieveUserOrgPathEqualTo(String value) {
			addCriterion("RECIEVE_USER_ORG_PATH =", value, "recieveUserOrgPath");
			return (Criteria) this;
		}

		public Criteria andRecieveUserOrgPathNotEqualTo(String value) {
			addCriterion("RECIEVE_USER_ORG_PATH <>", value, "recieveUserOrgPath");
			return (Criteria) this;
		}

		public Criteria andRecieveUserOrgPathGreaterThan(String value) {
			addCriterion("RECIEVE_USER_ORG_PATH >", value, "recieveUserOrgPath");
			return (Criteria) this;
		}

		public Criteria andRecieveUserOrgPathGreaterThanOrEqualTo(String value) {
			addCriterion("RECIEVE_USER_ORG_PATH >=", value, "recieveUserOrgPath");
			return (Criteria) this;
		}

		public Criteria andRecieveUserOrgPathLessThan(String value) {
			addCriterion("RECIEVE_USER_ORG_PATH <", value, "recieveUserOrgPath");
			return (Criteria) this;
		}

		public Criteria andRecieveUserOrgPathLessThanOrEqualTo(String value) {
			addCriterion("RECIEVE_USER_ORG_PATH <=", value, "recieveUserOrgPath");
			return (Criteria) this;
		}

		public Criteria andRecieveUserOrgPathLike(String value) {
			addCriterion("RECIEVE_USER_ORG_PATH like", value, "recieveUserOrgPath");
			return (Criteria) this;
		}

		public Criteria andRecieveUserOrgPathNotLike(String value) {
			addCriterion("RECIEVE_USER_ORG_PATH not like", value, "recieveUserOrgPath");
			return (Criteria) this;
		}

		public Criteria andRecieveUserOrgPathIn(List<String> values) {
			addCriterion("RECIEVE_USER_ORG_PATH in", values, "recieveUserOrgPath");
			return (Criteria) this;
		}

		public Criteria andRecieveUserOrgPathNotIn(List<String> values) {
			addCriterion("RECIEVE_USER_ORG_PATH not in", values, "recieveUserOrgPath");
			return (Criteria) this;
		}

		public Criteria andRecieveUserOrgPathBetween(String value1, String value2) {
			addCriterion("RECIEVE_USER_ORG_PATH between", value1, value2, "recieveUserOrgPath");
			return (Criteria) this;
		}

		public Criteria andRecieveUserOrgPathNotBetween(String value1, String value2) {
			addCriterion("RECIEVE_USER_ORG_PATH not between", value1, value2, "recieveUserOrgPath");
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

		public Criteria andSendStatusIsNull() {
			addCriterion("SEND_STATUS is null");
			return (Criteria) this;
		}

		public Criteria andSendStatusIsNotNull() {
			addCriterion("SEND_STATUS is not null");
			return (Criteria) this;
		}

		public Criteria andSendStatusEqualTo(Integer value) {
			addCriterion("SEND_STATUS =", value, "sendStatus");
			return (Criteria) this;
		}

		public Criteria andSendStatusNotEqualTo(Integer value) {
			addCriterion("SEND_STATUS <>", value, "sendStatus");
			return (Criteria) this;
		}

		public Criteria andSendStatusGreaterThan(Integer value) {
			addCriterion("SEND_STATUS >", value, "sendStatus");
			return (Criteria) this;
		}

		public Criteria andSendStatusGreaterThanOrEqualTo(Integer value) {
			addCriterion("SEND_STATUS >=", value, "sendStatus");
			return (Criteria) this;
		}

		public Criteria andSendStatusLessThan(Integer value) {
			addCriterion("SEND_STATUS <", value, "sendStatus");
			return (Criteria) this;
		}

		public Criteria andSendStatusLessThanOrEqualTo(Integer value) {
			addCriterion("SEND_STATUS <=", value, "sendStatus");
			return (Criteria) this;
		}

		public Criteria andSendStatusIn(List<Integer> values) {
			addCriterion("SEND_STATUS in", values, "sendStatus");
			return (Criteria) this;
		}

		public Criteria andSendStatusNotIn(List<Integer> values) {
			addCriterion("SEND_STATUS not in", values, "sendStatus");
			return (Criteria) this;
		}

		public Criteria andSendStatusBetween(Integer value1, Integer value2) {
			addCriterion("SEND_STATUS between", value1, value2, "sendStatus");
			return (Criteria) this;
		}

		public Criteria andSendStatusNotBetween(Integer value1, Integer value2) {
			addCriterion("SEND_STATUS not between", value1, value2, "sendStatus");
			return (Criteria) this;
		}

		public Criteria andTaskSearchIsNull() {
			addCriterion("TASK_SEARCH is null");
			return (Criteria) this;
		}

		public Criteria andTaskSearchIsNotNull() {
			addCriterion("TASK_SEARCH is not null");
			return (Criteria) this;
		}

		public Criteria andTaskSearchEqualTo(String value) {
			addCriterion("TASK_SEARCH =", value, "taskSearch");
			return (Criteria) this;
		}

		public Criteria andTaskSearchNotEqualTo(String value) {
			addCriterion("TASK_SEARCH <>", value, "taskSearch");
			return (Criteria) this;
		}

		public Criteria andTaskSearchGreaterThan(String value) {
			addCriterion("TASK_SEARCH >", value, "taskSearch");
			return (Criteria) this;
		}

		public Criteria andTaskSearchGreaterThanOrEqualTo(String value) {
			addCriterion("TASK_SEARCH >=", value, "taskSearch");
			return (Criteria) this;
		}

		public Criteria andTaskSearchLessThan(String value) {
			addCriterion("TASK_SEARCH <", value, "taskSearch");
			return (Criteria) this;
		}

		public Criteria andTaskSearchLessThanOrEqualTo(String value) {
			addCriterion("TASK_SEARCH <=", value, "taskSearch");
			return (Criteria) this;
		}

		public Criteria andTaskSearchLike(String value) {
			addCriterion("TASK_SEARCH like", value, "taskSearch");
			return (Criteria) this;
		}

		public Criteria andTaskSearchNotLike(String value) {
			addCriterion("TASK_SEARCH not like", value, "taskSearch");
			return (Criteria) this;
		}

		public Criteria andTaskSearchIn(List<String> values) {
			addCriterion("TASK_SEARCH in", values, "taskSearch");
			return (Criteria) this;
		}

		public Criteria andTaskSearchNotIn(List<String> values) {
			addCriterion("TASK_SEARCH not in", values, "taskSearch");
			return (Criteria) this;
		}

		public Criteria andTaskSearchBetween(String value1, String value2) {
			addCriterion("TASK_SEARCH between", value1, value2, "taskSearch");
			return (Criteria) this;
		}

		public Criteria andTaskSearchNotBetween(String value1, String value2) {
			addCriterion("TASK_SEARCH not between", value1, value2, "taskSearch");
			return (Criteria) this;
		}

		public Criteria andRecieveCountIsNull() {
			addCriterion("RECIEVE_COUNT is null");
			return (Criteria) this;
		}

		public Criteria andRecieveCountIsNotNull() {
			addCriterion("RECIEVE_COUNT is not null");
			return (Criteria) this;
		}

		public Criteria andRecieveCountEqualTo(Integer value) {
			addCriterion("RECIEVE_COUNT =", value, "recieveCount");
			return (Criteria) this;
		}

		public Criteria andRecieveCountNotEqualTo(Integer value) {
			addCriterion("RECIEVE_COUNT <>", value, "recieveCount");
			return (Criteria) this;
		}

		public Criteria andRecieveCountGreaterThan(Integer value) {
			addCriterion("RECIEVE_COUNT >", value, "recieveCount");
			return (Criteria) this;
		}

		public Criteria andRecieveCountGreaterThanOrEqualTo(Integer value) {
			addCriterion("RECIEVE_COUNT >=", value, "recieveCount");
			return (Criteria) this;
		}

		public Criteria andRecieveCountLessThan(Integer value) {
			addCriterion("RECIEVE_COUNT <", value, "recieveCount");
			return (Criteria) this;
		}

		public Criteria andRecieveCountLessThanOrEqualTo(Integer value) {
			addCriterion("RECIEVE_COUNT <=", value, "recieveCount");
			return (Criteria) this;
		}

		public Criteria andRecieveCountIn(List<Integer> values) {
			addCriterion("RECIEVE_COUNT in", values, "recieveCount");
			return (Criteria) this;
		}

		public Criteria andRecieveCountNotIn(List<Integer> values) {
			addCriterion("RECIEVE_COUNT not in", values, "recieveCount");
			return (Criteria) this;
		}

		public Criteria andRecieveCountBetween(Integer value1, Integer value2) {
			addCriterion("RECIEVE_COUNT between", value1, value2, "recieveCount");
			return (Criteria) this;
		}

		public Criteria andRecieveCountNotBetween(Integer value1, Integer value2) {
			addCriterion("RECIEVE_COUNT not between", value1, value2, "recieveCount");
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