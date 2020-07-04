package com.myfun.repository.erpdb.po;

import com.myfun.repository.support.generator.shard.ShardDb;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ErpAuditTrackExample extends ShardDb {
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
	public ErpAuditTrackExample() {
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

		public Criteria andAuditIdIsNull() {
			addCriterion("AUDIT_ID is null");
			return (Criteria) this;
		}

		public Criteria andAuditIdIsNotNull() {
			addCriterion("AUDIT_ID is not null");
			return (Criteria) this;
		}

		public Criteria andAuditIdEqualTo(Integer value) {
			addCriterion("AUDIT_ID =", value, "auditId");
			return (Criteria) this;
		}

		public Criteria andAuditIdNotEqualTo(Integer value) {
			addCriterion("AUDIT_ID <>", value, "auditId");
			return (Criteria) this;
		}

		public Criteria andAuditIdGreaterThan(Integer value) {
			addCriterion("AUDIT_ID >", value, "auditId");
			return (Criteria) this;
		}

		public Criteria andAuditIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("AUDIT_ID >=", value, "auditId");
			return (Criteria) this;
		}

		public Criteria andAuditIdLessThan(Integer value) {
			addCriterion("AUDIT_ID <", value, "auditId");
			return (Criteria) this;
		}

		public Criteria andAuditIdLessThanOrEqualTo(Integer value) {
			addCriterion("AUDIT_ID <=", value, "auditId");
			return (Criteria) this;
		}

		public Criteria andAuditIdIn(List<Integer> values) {
			addCriterion("AUDIT_ID in", values, "auditId");
			return (Criteria) this;
		}

		public Criteria andAuditIdNotIn(List<Integer> values) {
			addCriterion("AUDIT_ID not in", values, "auditId");
			return (Criteria) this;
		}

		public Criteria andAuditIdBetween(Integer value1, Integer value2) {
			addCriterion("AUDIT_ID between", value1, value2, "auditId");
			return (Criteria) this;
		}

		public Criteria andAuditIdNotBetween(Integer value1, Integer value2) {
			addCriterion("AUDIT_ID not between", value1, value2, "auditId");
			return (Criteria) this;
		}

		public Criteria andTrackUserIdIsNull() {
			addCriterion("TRACK_USER_ID is null");
			return (Criteria) this;
		}

		public Criteria andTrackUserIdIsNotNull() {
			addCriterion("TRACK_USER_ID is not null");
			return (Criteria) this;
		}

		public Criteria andTrackUserIdEqualTo(Integer value) {
			addCriterion("TRACK_USER_ID =", value, "trackUserId");
			return (Criteria) this;
		}

		public Criteria andTrackUserIdNotEqualTo(Integer value) {
			addCriterion("TRACK_USER_ID <>", value, "trackUserId");
			return (Criteria) this;
		}

		public Criteria andTrackUserIdGreaterThan(Integer value) {
			addCriterion("TRACK_USER_ID >", value, "trackUserId");
			return (Criteria) this;
		}

		public Criteria andTrackUserIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("TRACK_USER_ID >=", value, "trackUserId");
			return (Criteria) this;
		}

		public Criteria andTrackUserIdLessThan(Integer value) {
			addCriterion("TRACK_USER_ID <", value, "trackUserId");
			return (Criteria) this;
		}

		public Criteria andTrackUserIdLessThanOrEqualTo(Integer value) {
			addCriterion("TRACK_USER_ID <=", value, "trackUserId");
			return (Criteria) this;
		}

		public Criteria andTrackUserIdIn(List<Integer> values) {
			addCriterion("TRACK_USER_ID in", values, "trackUserId");
			return (Criteria) this;
		}

		public Criteria andTrackUserIdNotIn(List<Integer> values) {
			addCriterion("TRACK_USER_ID not in", values, "trackUserId");
			return (Criteria) this;
		}

		public Criteria andTrackUserIdBetween(Integer value1, Integer value2) {
			addCriterion("TRACK_USER_ID between", value1, value2, "trackUserId");
			return (Criteria) this;
		}

		public Criteria andTrackUserIdNotBetween(Integer value1, Integer value2) {
			addCriterion("TRACK_USER_ID not between", value1, value2, "trackUserId");
			return (Criteria) this;
		}

		public Criteria andTrackTypeIsNull() {
			addCriterion("TRACK_TYPE is null");
			return (Criteria) this;
		}

		public Criteria andTrackTypeIsNotNull() {
			addCriterion("TRACK_TYPE is not null");
			return (Criteria) this;
		}

		public Criteria andTrackTypeEqualTo(Byte value) {
			addCriterion("TRACK_TYPE =", value, "trackType");
			return (Criteria) this;
		}

		public Criteria andTrackTypeNotEqualTo(Byte value) {
			addCriterion("TRACK_TYPE <>", value, "trackType");
			return (Criteria) this;
		}

		public Criteria andTrackTypeGreaterThan(Byte value) {
			addCriterion("TRACK_TYPE >", value, "trackType");
			return (Criteria) this;
		}

		public Criteria andTrackTypeGreaterThanOrEqualTo(Byte value) {
			addCriterion("TRACK_TYPE >=", value, "trackType");
			return (Criteria) this;
		}

		public Criteria andTrackTypeLessThan(Byte value) {
			addCriterion("TRACK_TYPE <", value, "trackType");
			return (Criteria) this;
		}

		public Criteria andTrackTypeLessThanOrEqualTo(Byte value) {
			addCriterion("TRACK_TYPE <=", value, "trackType");
			return (Criteria) this;
		}

		public Criteria andTrackTypeIn(List<Byte> values) {
			addCriterion("TRACK_TYPE in", values, "trackType");
			return (Criteria) this;
		}

		public Criteria andTrackTypeNotIn(List<Byte> values) {
			addCriterion("TRACK_TYPE not in", values, "trackType");
			return (Criteria) this;
		}

		public Criteria andTrackTypeBetween(Byte value1, Byte value2) {
			addCriterion("TRACK_TYPE between", value1, value2, "trackType");
			return (Criteria) this;
		}

		public Criteria andTrackTypeNotBetween(Byte value1, Byte value2) {
			addCriterion("TRACK_TYPE not between", value1, value2, "trackType");
			return (Criteria) this;
		}

		public Criteria andTrackContentIsNull() {
			addCriterion("TRACK_CONTENT is null");
			return (Criteria) this;
		}

		public Criteria andTrackContentIsNotNull() {
			addCriterion("TRACK_CONTENT is not null");
			return (Criteria) this;
		}

		public Criteria andTrackContentEqualTo(String value) {
			addCriterion("TRACK_CONTENT =", value, "trackContent");
			return (Criteria) this;
		}

		public Criteria andTrackContentNotEqualTo(String value) {
			addCriterion("TRACK_CONTENT <>", value, "trackContent");
			return (Criteria) this;
		}

		public Criteria andTrackContentGreaterThan(String value) {
			addCriterion("TRACK_CONTENT >", value, "trackContent");
			return (Criteria) this;
		}

		public Criteria andTrackContentGreaterThanOrEqualTo(String value) {
			addCriterion("TRACK_CONTENT >=", value, "trackContent");
			return (Criteria) this;
		}

		public Criteria andTrackContentLessThan(String value) {
			addCriterion("TRACK_CONTENT <", value, "trackContent");
			return (Criteria) this;
		}

		public Criteria andTrackContentLessThanOrEqualTo(String value) {
			addCriterion("TRACK_CONTENT <=", value, "trackContent");
			return (Criteria) this;
		}

		public Criteria andTrackContentLike(String value) {
			addCriterion("TRACK_CONTENT like", value, "trackContent");
			return (Criteria) this;
		}

		public Criteria andTrackContentNotLike(String value) {
			addCriterion("TRACK_CONTENT not like", value, "trackContent");
			return (Criteria) this;
		}

		public Criteria andTrackContentIn(List<String> values) {
			addCriterion("TRACK_CONTENT in", values, "trackContent");
			return (Criteria) this;
		}

		public Criteria andTrackContentNotIn(List<String> values) {
			addCriterion("TRACK_CONTENT not in", values, "trackContent");
			return (Criteria) this;
		}

		public Criteria andTrackContentBetween(String value1, String value2) {
			addCriterion("TRACK_CONTENT between", value1, value2, "trackContent");
			return (Criteria) this;
		}

		public Criteria andTrackContentNotBetween(String value1, String value2) {
			addCriterion("TRACK_CONTENT not between", value1, value2, "trackContent");
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

		public Criteria andAuditSeqIsNull() {
			addCriterion("AUDIT_SEQ is null");
			return (Criteria) this;
		}

		public Criteria andAuditSeqIsNotNull() {
			addCriterion("AUDIT_SEQ is not null");
			return (Criteria) this;
		}

		public Criteria andAuditSeqEqualTo(Integer value) {
			addCriterion("AUDIT_SEQ =", value, "auditSeq");
			return (Criteria) this;
		}

		public Criteria andAuditSeqNotEqualTo(Integer value) {
			addCriterion("AUDIT_SEQ <>", value, "auditSeq");
			return (Criteria) this;
		}

		public Criteria andAuditSeqGreaterThan(Integer value) {
			addCriterion("AUDIT_SEQ >", value, "auditSeq");
			return (Criteria) this;
		}

		public Criteria andAuditSeqGreaterThanOrEqualTo(Integer value) {
			addCriterion("AUDIT_SEQ >=", value, "auditSeq");
			return (Criteria) this;
		}

		public Criteria andAuditSeqLessThan(Integer value) {
			addCriterion("AUDIT_SEQ <", value, "auditSeq");
			return (Criteria) this;
		}

		public Criteria andAuditSeqLessThanOrEqualTo(Integer value) {
			addCriterion("AUDIT_SEQ <=", value, "auditSeq");
			return (Criteria) this;
		}

		public Criteria andAuditSeqIn(List<Integer> values) {
			addCriterion("AUDIT_SEQ in", values, "auditSeq");
			return (Criteria) this;
		}

		public Criteria andAuditSeqNotIn(List<Integer> values) {
			addCriterion("AUDIT_SEQ not in", values, "auditSeq");
			return (Criteria) this;
		}

		public Criteria andAuditSeqBetween(Integer value1, Integer value2) {
			addCriterion("AUDIT_SEQ between", value1, value2, "auditSeq");
			return (Criteria) this;
		}

		public Criteria andAuditSeqNotBetween(Integer value1, Integer value2) {
			addCriterion("AUDIT_SEQ not between", value1, value2, "auditSeq");
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