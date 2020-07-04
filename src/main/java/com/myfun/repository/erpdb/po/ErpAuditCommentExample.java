package com.myfun.repository.erpdb.po;

import com.myfun.repository.support.generator.shard.ShardDb;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ErpAuditCommentExample extends ShardDb {
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
	public ErpAuditCommentExample() {
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

		public Criteria andDeptIdIsNull() {
			addCriterion("DEPT_ID is null");
			return (Criteria) this;
		}

		public Criteria andDeptIdIsNotNull() {
			addCriterion("DEPT_ID is not null");
			return (Criteria) this;
		}

		public Criteria andDeptIdEqualTo(Integer value) {
			addCriterion("DEPT_ID =", value, "deptId");
			return (Criteria) this;
		}

		public Criteria andDeptIdNotEqualTo(Integer value) {
			addCriterion("DEPT_ID <>", value, "deptId");
			return (Criteria) this;
		}

		public Criteria andDeptIdGreaterThan(Integer value) {
			addCriterion("DEPT_ID >", value, "deptId");
			return (Criteria) this;
		}

		public Criteria andDeptIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("DEPT_ID >=", value, "deptId");
			return (Criteria) this;
		}

		public Criteria andDeptIdLessThan(Integer value) {
			addCriterion("DEPT_ID <", value, "deptId");
			return (Criteria) this;
		}

		public Criteria andDeptIdLessThanOrEqualTo(Integer value) {
			addCriterion("DEPT_ID <=", value, "deptId");
			return (Criteria) this;
		}

		public Criteria andDeptIdIn(List<Integer> values) {
			addCriterion("DEPT_ID in", values, "deptId");
			return (Criteria) this;
		}

		public Criteria andDeptIdNotIn(List<Integer> values) {
			addCriterion("DEPT_ID not in", values, "deptId");
			return (Criteria) this;
		}

		public Criteria andDeptIdBetween(Integer value1, Integer value2) {
			addCriterion("DEPT_ID between", value1, value2, "deptId");
			return (Criteria) this;
		}

		public Criteria andDeptIdNotBetween(Integer value1, Integer value2) {
			addCriterion("DEPT_ID not between", value1, value2, "deptId");
			return (Criteria) this;
		}

		public Criteria andGrIdIsNull() {
			addCriterion("GR_ID is null");
			return (Criteria) this;
		}

		public Criteria andGrIdIsNotNull() {
			addCriterion("GR_ID is not null");
			return (Criteria) this;
		}

		public Criteria andGrIdEqualTo(Integer value) {
			addCriterion("GR_ID =", value, "grId");
			return (Criteria) this;
		}

		public Criteria andGrIdNotEqualTo(Integer value) {
			addCriterion("GR_ID <>", value, "grId");
			return (Criteria) this;
		}

		public Criteria andGrIdGreaterThan(Integer value) {
			addCriterion("GR_ID >", value, "grId");
			return (Criteria) this;
		}

		public Criteria andGrIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("GR_ID >=", value, "grId");
			return (Criteria) this;
		}

		public Criteria andGrIdLessThan(Integer value) {
			addCriterion("GR_ID <", value, "grId");
			return (Criteria) this;
		}

		public Criteria andGrIdLessThanOrEqualTo(Integer value) {
			addCriterion("GR_ID <=", value, "grId");
			return (Criteria) this;
		}

		public Criteria andGrIdIn(List<Integer> values) {
			addCriterion("GR_ID in", values, "grId");
			return (Criteria) this;
		}

		public Criteria andGrIdNotIn(List<Integer> values) {
			addCriterion("GR_ID not in", values, "grId");
			return (Criteria) this;
		}

		public Criteria andGrIdBetween(Integer value1, Integer value2) {
			addCriterion("GR_ID between", value1, value2, "grId");
			return (Criteria) this;
		}

		public Criteria andGrIdNotBetween(Integer value1, Integer value2) {
			addCriterion("GR_ID not between", value1, value2, "grId");
			return (Criteria) this;
		}

		public Criteria andDeptNameIsNull() {
			addCriterion("DEPT_NAME is null");
			return (Criteria) this;
		}

		public Criteria andDeptNameIsNotNull() {
			addCriterion("DEPT_NAME is not null");
			return (Criteria) this;
		}

		public Criteria andDeptNameEqualTo(String value) {
			addCriterion("DEPT_NAME =", value, "deptName");
			return (Criteria) this;
		}

		public Criteria andDeptNameNotEqualTo(String value) {
			addCriterion("DEPT_NAME <>", value, "deptName");
			return (Criteria) this;
		}

		public Criteria andDeptNameGreaterThan(String value) {
			addCriterion("DEPT_NAME >", value, "deptName");
			return (Criteria) this;
		}

		public Criteria andDeptNameGreaterThanOrEqualTo(String value) {
			addCriterion("DEPT_NAME >=", value, "deptName");
			return (Criteria) this;
		}

		public Criteria andDeptNameLessThan(String value) {
			addCriterion("DEPT_NAME <", value, "deptName");
			return (Criteria) this;
		}

		public Criteria andDeptNameLessThanOrEqualTo(String value) {
			addCriterion("DEPT_NAME <=", value, "deptName");
			return (Criteria) this;
		}

		public Criteria andDeptNameLike(String value) {
			addCriterion("DEPT_NAME like", value, "deptName");
			return (Criteria) this;
		}

		public Criteria andDeptNameNotLike(String value) {
			addCriterion("DEPT_NAME not like", value, "deptName");
			return (Criteria) this;
		}

		public Criteria andDeptNameIn(List<String> values) {
			addCriterion("DEPT_NAME in", values, "deptName");
			return (Criteria) this;
		}

		public Criteria andDeptNameNotIn(List<String> values) {
			addCriterion("DEPT_NAME not in", values, "deptName");
			return (Criteria) this;
		}

		public Criteria andDeptNameBetween(String value1, String value2) {
			addCriterion("DEPT_NAME between", value1, value2, "deptName");
			return (Criteria) this;
		}

		public Criteria andDeptNameNotBetween(String value1, String value2) {
			addCriterion("DEPT_NAME not between", value1, value2, "deptName");
			return (Criteria) this;
		}

		public Criteria andGrNameIsNull() {
			addCriterion("GR_NAME is null");
			return (Criteria) this;
		}

		public Criteria andGrNameIsNotNull() {
			addCriterion("GR_NAME is not null");
			return (Criteria) this;
		}

		public Criteria andGrNameEqualTo(String value) {
			addCriterion("GR_NAME =", value, "grName");
			return (Criteria) this;
		}

		public Criteria andGrNameNotEqualTo(String value) {
			addCriterion("GR_NAME <>", value, "grName");
			return (Criteria) this;
		}

		public Criteria andGrNameGreaterThan(String value) {
			addCriterion("GR_NAME >", value, "grName");
			return (Criteria) this;
		}

		public Criteria andGrNameGreaterThanOrEqualTo(String value) {
			addCriterion("GR_NAME >=", value, "grName");
			return (Criteria) this;
		}

		public Criteria andGrNameLessThan(String value) {
			addCriterion("GR_NAME <", value, "grName");
			return (Criteria) this;
		}

		public Criteria andGrNameLessThanOrEqualTo(String value) {
			addCriterion("GR_NAME <=", value, "grName");
			return (Criteria) this;
		}

		public Criteria andGrNameLike(String value) {
			addCriterion("GR_NAME like", value, "grName");
			return (Criteria) this;
		}

		public Criteria andGrNameNotLike(String value) {
			addCriterion("GR_NAME not like", value, "grName");
			return (Criteria) this;
		}

		public Criteria andGrNameIn(List<String> values) {
			addCriterion("GR_NAME in", values, "grName");
			return (Criteria) this;
		}

		public Criteria andGrNameNotIn(List<String> values) {
			addCriterion("GR_NAME not in", values, "grName");
			return (Criteria) this;
		}

		public Criteria andGrNameBetween(String value1, String value2) {
			addCriterion("GR_NAME between", value1, value2, "grName");
			return (Criteria) this;
		}

		public Criteria andGrNameNotBetween(String value1, String value2) {
			addCriterion("GR_NAME not between", value1, value2, "grName");
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

		public Criteria andCommentContentIsNull() {
			addCriterion("COMMENT_CONTENT is null");
			return (Criteria) this;
		}

		public Criteria andCommentContentIsNotNull() {
			addCriterion("COMMENT_CONTENT is not null");
			return (Criteria) this;
		}

		public Criteria andCommentContentEqualTo(String value) {
			addCriterion("COMMENT_CONTENT =", value, "commentContent");
			return (Criteria) this;
		}

		public Criteria andCommentContentNotEqualTo(String value) {
			addCriterion("COMMENT_CONTENT <>", value, "commentContent");
			return (Criteria) this;
		}

		public Criteria andCommentContentGreaterThan(String value) {
			addCriterion("COMMENT_CONTENT >", value, "commentContent");
			return (Criteria) this;
		}

		public Criteria andCommentContentGreaterThanOrEqualTo(String value) {
			addCriterion("COMMENT_CONTENT >=", value, "commentContent");
			return (Criteria) this;
		}

		public Criteria andCommentContentLessThan(String value) {
			addCriterion("COMMENT_CONTENT <", value, "commentContent");
			return (Criteria) this;
		}

		public Criteria andCommentContentLessThanOrEqualTo(String value) {
			addCriterion("COMMENT_CONTENT <=", value, "commentContent");
			return (Criteria) this;
		}

		public Criteria andCommentContentLike(String value) {
			addCriterion("COMMENT_CONTENT like", value, "commentContent");
			return (Criteria) this;
		}

		public Criteria andCommentContentNotLike(String value) {
			addCriterion("COMMENT_CONTENT not like", value, "commentContent");
			return (Criteria) this;
		}

		public Criteria andCommentContentIn(List<String> values) {
			addCriterion("COMMENT_CONTENT in", values, "commentContent");
			return (Criteria) this;
		}

		public Criteria andCommentContentNotIn(List<String> values) {
			addCriterion("COMMENT_CONTENT not in", values, "commentContent");
			return (Criteria) this;
		}

		public Criteria andCommentContentBetween(String value1, String value2) {
			addCriterion("COMMENT_CONTENT between", value1, value2, "commentContent");
			return (Criteria) this;
		}

		public Criteria andCommentContentNotBetween(String value1, String value2) {
			addCriterion("COMMENT_CONTENT not between", value1, value2, "commentContent");
			return (Criteria) this;
		}

		public Criteria andArchiveIdIsNull() {
			addCriterion("ARCHIVE_ID is null");
			return (Criteria) this;
		}

		public Criteria andArchiveIdIsNotNull() {
			addCriterion("ARCHIVE_ID is not null");
			return (Criteria) this;
		}

		public Criteria andArchiveIdEqualTo(Integer value) {
			addCriterion("ARCHIVE_ID =", value, "archiveId");
			return (Criteria) this;
		}

		public Criteria andArchiveIdNotEqualTo(Integer value) {
			addCriterion("ARCHIVE_ID <>", value, "archiveId");
			return (Criteria) this;
		}

		public Criteria andArchiveIdGreaterThan(Integer value) {
			addCriterion("ARCHIVE_ID >", value, "archiveId");
			return (Criteria) this;
		}

		public Criteria andArchiveIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("ARCHIVE_ID >=", value, "archiveId");
			return (Criteria) this;
		}

		public Criteria andArchiveIdLessThan(Integer value) {
			addCriterion("ARCHIVE_ID <", value, "archiveId");
			return (Criteria) this;
		}

		public Criteria andArchiveIdLessThanOrEqualTo(Integer value) {
			addCriterion("ARCHIVE_ID <=", value, "archiveId");
			return (Criteria) this;
		}

		public Criteria andArchiveIdIn(List<Integer> values) {
			addCriterion("ARCHIVE_ID in", values, "archiveId");
			return (Criteria) this;
		}

		public Criteria andArchiveIdNotIn(List<Integer> values) {
			addCriterion("ARCHIVE_ID not in", values, "archiveId");
			return (Criteria) this;
		}

		public Criteria andArchiveIdBetween(Integer value1, Integer value2) {
			addCriterion("ARCHIVE_ID between", value1, value2, "archiveId");
			return (Criteria) this;
		}

		public Criteria andArchiveIdNotBetween(Integer value1, Integer value2) {
			addCriterion("ARCHIVE_ID not between", value1, value2, "archiveId");
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