package com.myfun.repository.erpdb.po;

import com.myfun.repository.support.generator.shard.ShardDb;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;

public class ErpAuditCommentFileExample extends ShardDb {
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
	public ErpAuditCommentFileExample() {
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

		public Criteria andFileIdIsNull() {
			addCriterion("FILE_ID is null");
			return (Criteria) this;
		}

		public Criteria andFileIdIsNotNull() {
			addCriterion("FILE_ID is not null");
			return (Criteria) this;
		}

		public Criteria andFileIdEqualTo(Integer value) {
			addCriterion("FILE_ID =", value, "fileId");
			return (Criteria) this;
		}

		public Criteria andFileIdNotEqualTo(Integer value) {
			addCriterion("FILE_ID <>", value, "fileId");
			return (Criteria) this;
		}

		public Criteria andFileIdGreaterThan(Integer value) {
			addCriterion("FILE_ID >", value, "fileId");
			return (Criteria) this;
		}

		public Criteria andFileIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("FILE_ID >=", value, "fileId");
			return (Criteria) this;
		}

		public Criteria andFileIdLessThan(Integer value) {
			addCriterion("FILE_ID <", value, "fileId");
			return (Criteria) this;
		}

		public Criteria andFileIdLessThanOrEqualTo(Integer value) {
			addCriterion("FILE_ID <=", value, "fileId");
			return (Criteria) this;
		}

		public Criteria andFileIdIn(List<Integer> values) {
			addCriterion("FILE_ID in", values, "fileId");
			return (Criteria) this;
		}

		public Criteria andFileIdNotIn(List<Integer> values) {
			addCriterion("FILE_ID not in", values, "fileId");
			return (Criteria) this;
		}

		public Criteria andFileIdBetween(Integer value1, Integer value2) {
			addCriterion("FILE_ID between", value1, value2, "fileId");
			return (Criteria) this;
		}

		public Criteria andFileIdNotBetween(Integer value1, Integer value2) {
			addCriterion("FILE_ID not between", value1, value2, "fileId");
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

		public Criteria andCommentIdIsNull() {
			addCriterion("COMMENT_ID is null");
			return (Criteria) this;
		}

		public Criteria andCommentIdIsNotNull() {
			addCriterion("COMMENT_ID is not null");
			return (Criteria) this;
		}

		public Criteria andCommentIdEqualTo(Integer value) {
			addCriterion("COMMENT_ID =", value, "commentId");
			return (Criteria) this;
		}

		public Criteria andCommentIdNotEqualTo(Integer value) {
			addCriterion("COMMENT_ID <>", value, "commentId");
			return (Criteria) this;
		}

		public Criteria andCommentIdGreaterThan(Integer value) {
			addCriterion("COMMENT_ID >", value, "commentId");
			return (Criteria) this;
		}

		public Criteria andCommentIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("COMMENT_ID >=", value, "commentId");
			return (Criteria) this;
		}

		public Criteria andCommentIdLessThan(Integer value) {
			addCriterion("COMMENT_ID <", value, "commentId");
			return (Criteria) this;
		}

		public Criteria andCommentIdLessThanOrEqualTo(Integer value) {
			addCriterion("COMMENT_ID <=", value, "commentId");
			return (Criteria) this;
		}

		public Criteria andCommentIdIn(List<Integer> values) {
			addCriterion("COMMENT_ID in", values, "commentId");
			return (Criteria) this;
		}

		public Criteria andCommentIdNotIn(List<Integer> values) {
			addCriterion("COMMENT_ID not in", values, "commentId");
			return (Criteria) this;
		}

		public Criteria andCommentIdBetween(Integer value1, Integer value2) {
			addCriterion("COMMENT_ID between", value1, value2, "commentId");
			return (Criteria) this;
		}

		public Criteria andCommentIdNotBetween(Integer value1, Integer value2) {
			addCriterion("COMMENT_ID not between", value1, value2, "commentId");
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

		public Criteria andFileAddrIsNull() {
			addCriterion("FILE_ADDR is null");
			return (Criteria) this;
		}

		public Criteria andFileAddrIsNotNull() {
			addCriterion("FILE_ADDR is not null");
			return (Criteria) this;
		}

		public Criteria andFileAddrEqualTo(String value) {
			addCriterion("FILE_ADDR =", value, "fileAddr");
			return (Criteria) this;
		}

		public Criteria andFileAddrNotEqualTo(String value) {
			addCriterion("FILE_ADDR <>", value, "fileAddr");
			return (Criteria) this;
		}

		public Criteria andFileAddrGreaterThan(String value) {
			addCriterion("FILE_ADDR >", value, "fileAddr");
			return (Criteria) this;
		}

		public Criteria andFileAddrGreaterThanOrEqualTo(String value) {
			addCriterion("FILE_ADDR >=", value, "fileAddr");
			return (Criteria) this;
		}

		public Criteria andFileAddrLessThan(String value) {
			addCriterion("FILE_ADDR <", value, "fileAddr");
			return (Criteria) this;
		}

		public Criteria andFileAddrLessThanOrEqualTo(String value) {
			addCriterion("FILE_ADDR <=", value, "fileAddr");
			return (Criteria) this;
		}

		public Criteria andFileAddrLike(String value) {
			addCriterion("FILE_ADDR like", value, "fileAddr");
			return (Criteria) this;
		}

		public Criteria andFileAddrNotLike(String value) {
			addCriterion("FILE_ADDR not like", value, "fileAddr");
			return (Criteria) this;
		}

		public Criteria andFileAddrIn(List<String> values) {
			addCriterion("FILE_ADDR in", values, "fileAddr");
			return (Criteria) this;
		}

		public Criteria andFileAddrNotIn(List<String> values) {
			addCriterion("FILE_ADDR not in", values, "fileAddr");
			return (Criteria) this;
		}

		public Criteria andFileAddrBetween(String value1, String value2) {
			addCriterion("FILE_ADDR between", value1, value2, "fileAddr");
			return (Criteria) this;
		}

		public Criteria andFileAddrNotBetween(String value1, String value2) {
			addCriterion("FILE_ADDR not between", value1, value2, "fileAddr");
			return (Criteria) this;
		}

		public Criteria andFileSeqIsNull() {
			addCriterion("FILE_SEQ is null");
			return (Criteria) this;
		}

		public Criteria andFileSeqIsNotNull() {
			addCriterion("FILE_SEQ is not null");
			return (Criteria) this;
		}

		public Criteria andFileSeqEqualTo(Integer value) {
			addCriterion("FILE_SEQ =", value, "fileSeq");
			return (Criteria) this;
		}

		public Criteria andFileSeqNotEqualTo(Integer value) {
			addCriterion("FILE_SEQ <>", value, "fileSeq");
			return (Criteria) this;
		}

		public Criteria andFileSeqGreaterThan(Integer value) {
			addCriterion("FILE_SEQ >", value, "fileSeq");
			return (Criteria) this;
		}

		public Criteria andFileSeqGreaterThanOrEqualTo(Integer value) {
			addCriterion("FILE_SEQ >=", value, "fileSeq");
			return (Criteria) this;
		}

		public Criteria andFileSeqLessThan(Integer value) {
			addCriterion("FILE_SEQ <", value, "fileSeq");
			return (Criteria) this;
		}

		public Criteria andFileSeqLessThanOrEqualTo(Integer value) {
			addCriterion("FILE_SEQ <=", value, "fileSeq");
			return (Criteria) this;
		}

		public Criteria andFileSeqIn(List<Integer> values) {
			addCriterion("FILE_SEQ in", values, "fileSeq");
			return (Criteria) this;
		}

		public Criteria andFileSeqNotIn(List<Integer> values) {
			addCriterion("FILE_SEQ not in", values, "fileSeq");
			return (Criteria) this;
		}

		public Criteria andFileSeqBetween(Integer value1, Integer value2) {
			addCriterion("FILE_SEQ between", value1, value2, "fileSeq");
			return (Criteria) this;
		}

		public Criteria andFileSeqNotBetween(Integer value1, Integer value2) {
			addCriterion("FILE_SEQ not between", value1, value2, "fileSeq");
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