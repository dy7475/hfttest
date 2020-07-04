package com.myfun.repository.erpdb.po;

import com.myfun.repository.support.generator.shard.ShardDb;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ErpInviteUserLogExample extends ShardDb {
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
	public ErpInviteUserLogExample() {
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

		public Criteria andInviteUserIdIsNull() {
			addCriterion("INVITE_USER_ID is null");
			return (Criteria) this;
		}

		public Criteria andInviteUserIdIsNotNull() {
			addCriterion("INVITE_USER_ID is not null");
			return (Criteria) this;
		}

		public Criteria andInviteUserIdEqualTo(Integer value) {
			addCriterion("INVITE_USER_ID =", value, "inviteUserId");
			return (Criteria) this;
		}

		public Criteria andInviteUserIdNotEqualTo(Integer value) {
			addCriterion("INVITE_USER_ID <>", value, "inviteUserId");
			return (Criteria) this;
		}

		public Criteria andInviteUserIdGreaterThan(Integer value) {
			addCriterion("INVITE_USER_ID >", value, "inviteUserId");
			return (Criteria) this;
		}

		public Criteria andInviteUserIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("INVITE_USER_ID >=", value, "inviteUserId");
			return (Criteria) this;
		}

		public Criteria andInviteUserIdLessThan(Integer value) {
			addCriterion("INVITE_USER_ID <", value, "inviteUserId");
			return (Criteria) this;
		}

		public Criteria andInviteUserIdLessThanOrEqualTo(Integer value) {
			addCriterion("INVITE_USER_ID <=", value, "inviteUserId");
			return (Criteria) this;
		}

		public Criteria andInviteUserIdIn(List<Integer> values) {
			addCriterion("INVITE_USER_ID in", values, "inviteUserId");
			return (Criteria) this;
		}

		public Criteria andInviteUserIdNotIn(List<Integer> values) {
			addCriterion("INVITE_USER_ID not in", values, "inviteUserId");
			return (Criteria) this;
		}

		public Criteria andInviteUserIdBetween(Integer value1, Integer value2) {
			addCriterion("INVITE_USER_ID between", value1, value2, "inviteUserId");
			return (Criteria) this;
		}

		public Criteria andInviteUserIdNotBetween(Integer value1, Integer value2) {
			addCriterion("INVITE_USER_ID not between", value1, value2, "inviteUserId");
			return (Criteria) this;
		}

		public Criteria andInviteTimeIsNull() {
			addCriterion("INVITE_TIME is null");
			return (Criteria) this;
		}

		public Criteria andInviteTimeIsNotNull() {
			addCriterion("INVITE_TIME is not null");
			return (Criteria) this;
		}

		public Criteria andInviteTimeEqualTo(Date value) {
			addCriterion("INVITE_TIME =", value, "inviteTime");
			return (Criteria) this;
		}

		public Criteria andInviteTimeNotEqualTo(Date value) {
			addCriterion("INVITE_TIME <>", value, "inviteTime");
			return (Criteria) this;
		}

		public Criteria andInviteTimeGreaterThan(Date value) {
			addCriterion("INVITE_TIME >", value, "inviteTime");
			return (Criteria) this;
		}

		public Criteria andInviteTimeGreaterThanOrEqualTo(Date value) {
			addCriterion("INVITE_TIME >=", value, "inviteTime");
			return (Criteria) this;
		}

		public Criteria andInviteTimeLessThan(Date value) {
			addCriterion("INVITE_TIME <", value, "inviteTime");
			return (Criteria) this;
		}

		public Criteria andInviteTimeLessThanOrEqualTo(Date value) {
			addCriterion("INVITE_TIME <=", value, "inviteTime");
			return (Criteria) this;
		}

		public Criteria andInviteTimeIn(List<Date> values) {
			addCriterion("INVITE_TIME in", values, "inviteTime");
			return (Criteria) this;
		}

		public Criteria andInviteTimeNotIn(List<Date> values) {
			addCriterion("INVITE_TIME not in", values, "inviteTime");
			return (Criteria) this;
		}

		public Criteria andInviteTimeBetween(Date value1, Date value2) {
			addCriterion("INVITE_TIME between", value1, value2, "inviteTime");
			return (Criteria) this;
		}

		public Criteria andInviteTimeNotBetween(Date value1, Date value2) {
			addCriterion("INVITE_TIME not between", value1, value2, "inviteTime");
			return (Criteria) this;
		}

		public Criteria andInvitedUserIdIsNull() {
			addCriterion("INVITED_USER_ID is null");
			return (Criteria) this;
		}

		public Criteria andInvitedUserIdIsNotNull() {
			addCriterion("INVITED_USER_ID is not null");
			return (Criteria) this;
		}

		public Criteria andInvitedUserIdEqualTo(Integer value) {
			addCriterion("INVITED_USER_ID =", value, "invitedUserId");
			return (Criteria) this;
		}

		public Criteria andInvitedUserIdNotEqualTo(Integer value) {
			addCriterion("INVITED_USER_ID <>", value, "invitedUserId");
			return (Criteria) this;
		}

		public Criteria andInvitedUserIdGreaterThan(Integer value) {
			addCriterion("INVITED_USER_ID >", value, "invitedUserId");
			return (Criteria) this;
		}

		public Criteria andInvitedUserIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("INVITED_USER_ID >=", value, "invitedUserId");
			return (Criteria) this;
		}

		public Criteria andInvitedUserIdLessThan(Integer value) {
			addCriterion("INVITED_USER_ID <", value, "invitedUserId");
			return (Criteria) this;
		}

		public Criteria andInvitedUserIdLessThanOrEqualTo(Integer value) {
			addCriterion("INVITED_USER_ID <=", value, "invitedUserId");
			return (Criteria) this;
		}

		public Criteria andInvitedUserIdIn(List<Integer> values) {
			addCriterion("INVITED_USER_ID in", values, "invitedUserId");
			return (Criteria) this;
		}

		public Criteria andInvitedUserIdNotIn(List<Integer> values) {
			addCriterion("INVITED_USER_ID not in", values, "invitedUserId");
			return (Criteria) this;
		}

		public Criteria andInvitedUserIdBetween(Integer value1, Integer value2) {
			addCriterion("INVITED_USER_ID between", value1, value2, "invitedUserId");
			return (Criteria) this;
		}

		public Criteria andInvitedUserIdNotBetween(Integer value1, Integer value2) {
			addCriterion("INVITED_USER_ID not between", value1, value2, "invitedUserId");
			return (Criteria) this;
		}

		public Criteria andInvitedUserNameIsNull() {
			addCriterion("INVITED_USER_NAME is null");
			return (Criteria) this;
		}

		public Criteria andInvitedUserNameIsNotNull() {
			addCriterion("INVITED_USER_NAME is not null");
			return (Criteria) this;
		}

		public Criteria andInvitedUserNameEqualTo(String value) {
			addCriterion("INVITED_USER_NAME =", value, "invitedUserName");
			return (Criteria) this;
		}

		public Criteria andInvitedUserNameNotEqualTo(String value) {
			addCriterion("INVITED_USER_NAME <>", value, "invitedUserName");
			return (Criteria) this;
		}

		public Criteria andInvitedUserNameGreaterThan(String value) {
			addCriterion("INVITED_USER_NAME >", value, "invitedUserName");
			return (Criteria) this;
		}

		public Criteria andInvitedUserNameGreaterThanOrEqualTo(String value) {
			addCriterion("INVITED_USER_NAME >=", value, "invitedUserName");
			return (Criteria) this;
		}

		public Criteria andInvitedUserNameLessThan(String value) {
			addCriterion("INVITED_USER_NAME <", value, "invitedUserName");
			return (Criteria) this;
		}

		public Criteria andInvitedUserNameLessThanOrEqualTo(String value) {
			addCriterion("INVITED_USER_NAME <=", value, "invitedUserName");
			return (Criteria) this;
		}

		public Criteria andInvitedUserNameLike(String value) {
			addCriterion("INVITED_USER_NAME like", value, "invitedUserName");
			return (Criteria) this;
		}

		public Criteria andInvitedUserNameNotLike(String value) {
			addCriterion("INVITED_USER_NAME not like", value, "invitedUserName");
			return (Criteria) this;
		}

		public Criteria andInvitedUserNameIn(List<String> values) {
			addCriterion("INVITED_USER_NAME in", values, "invitedUserName");
			return (Criteria) this;
		}

		public Criteria andInvitedUserNameNotIn(List<String> values) {
			addCriterion("INVITED_USER_NAME not in", values, "invitedUserName");
			return (Criteria) this;
		}

		public Criteria andInvitedUserNameBetween(String value1, String value2) {
			addCriterion("INVITED_USER_NAME between", value1, value2, "invitedUserName");
			return (Criteria) this;
		}

		public Criteria andInvitedUserNameNotBetween(String value1, String value2) {
			addCriterion("INVITED_USER_NAME not between", value1, value2, "invitedUserName");
			return (Criteria) this;
		}

		public Criteria andInvitedUserMobileIsNull() {
			addCriterion("INVITED_USER_MOBILE is null");
			return (Criteria) this;
		}

		public Criteria andInvitedUserMobileIsNotNull() {
			addCriterion("INVITED_USER_MOBILE is not null");
			return (Criteria) this;
		}

		public Criteria andInvitedUserMobileEqualTo(String value) {
			addCriterion("INVITED_USER_MOBILE =", value, "invitedUserMobile");
			return (Criteria) this;
		}

		public Criteria andInvitedUserMobileNotEqualTo(String value) {
			addCriterion("INVITED_USER_MOBILE <>", value, "invitedUserMobile");
			return (Criteria) this;
		}

		public Criteria andInvitedUserMobileGreaterThan(String value) {
			addCriterion("INVITED_USER_MOBILE >", value, "invitedUserMobile");
			return (Criteria) this;
		}

		public Criteria andInvitedUserMobileGreaterThanOrEqualTo(String value) {
			addCriterion("INVITED_USER_MOBILE >=", value, "invitedUserMobile");
			return (Criteria) this;
		}

		public Criteria andInvitedUserMobileLessThan(String value) {
			addCriterion("INVITED_USER_MOBILE <", value, "invitedUserMobile");
			return (Criteria) this;
		}

		public Criteria andInvitedUserMobileLessThanOrEqualTo(String value) {
			addCriterion("INVITED_USER_MOBILE <=", value, "invitedUserMobile");
			return (Criteria) this;
		}

		public Criteria andInvitedUserMobileLike(String value) {
			addCriterion("INVITED_USER_MOBILE like", value, "invitedUserMobile");
			return (Criteria) this;
		}

		public Criteria andInvitedUserMobileNotLike(String value) {
			addCriterion("INVITED_USER_MOBILE not like", value, "invitedUserMobile");
			return (Criteria) this;
		}

		public Criteria andInvitedUserMobileIn(List<String> values) {
			addCriterion("INVITED_USER_MOBILE in", values, "invitedUserMobile");
			return (Criteria) this;
		}

		public Criteria andInvitedUserMobileNotIn(List<String> values) {
			addCriterion("INVITED_USER_MOBILE not in", values, "invitedUserMobile");
			return (Criteria) this;
		}

		public Criteria andInvitedUserMobileBetween(String value1, String value2) {
			addCriterion("INVITED_USER_MOBILE between", value1, value2, "invitedUserMobile");
			return (Criteria) this;
		}

		public Criteria andInvitedUserMobileNotBetween(String value1, String value2) {
			addCriterion("INVITED_USER_MOBILE not between", value1, value2, "invitedUserMobile");
			return (Criteria) this;
		}

		public Criteria andAuditFlagIsNull() {
			addCriterion("AUDIT_FLAG is null");
			return (Criteria) this;
		}

		public Criteria andAuditFlagIsNotNull() {
			addCriterion("AUDIT_FLAG is not null");
			return (Criteria) this;
		}

		public Criteria andAuditFlagEqualTo(Byte value) {
			addCriterion("AUDIT_FLAG =", value, "auditFlag");
			return (Criteria) this;
		}

		public Criteria andAuditFlagNotEqualTo(Byte value) {
			addCriterion("AUDIT_FLAG <>", value, "auditFlag");
			return (Criteria) this;
		}

		public Criteria andAuditFlagGreaterThan(Byte value) {
			addCriterion("AUDIT_FLAG >", value, "auditFlag");
			return (Criteria) this;
		}

		public Criteria andAuditFlagGreaterThanOrEqualTo(Byte value) {
			addCriterion("AUDIT_FLAG >=", value, "auditFlag");
			return (Criteria) this;
		}

		public Criteria andAuditFlagLessThan(Byte value) {
			addCriterion("AUDIT_FLAG <", value, "auditFlag");
			return (Criteria) this;
		}

		public Criteria andAuditFlagLessThanOrEqualTo(Byte value) {
			addCriterion("AUDIT_FLAG <=", value, "auditFlag");
			return (Criteria) this;
		}

		public Criteria andAuditFlagIn(List<Byte> values) {
			addCriterion("AUDIT_FLAG in", values, "auditFlag");
			return (Criteria) this;
		}

		public Criteria andAuditFlagNotIn(List<Byte> values) {
			addCriterion("AUDIT_FLAG not in", values, "auditFlag");
			return (Criteria) this;
		}

		public Criteria andAuditFlagBetween(Byte value1, Byte value2) {
			addCriterion("AUDIT_FLAG between", value1, value2, "auditFlag");
			return (Criteria) this;
		}

		public Criteria andAuditFlagNotBetween(Byte value1, Byte value2) {
			addCriterion("AUDIT_FLAG not between", value1, value2, "auditFlag");
			return (Criteria) this;
		}

		public Criteria andAuditTimeIsNull() {
			addCriterion("AUDIT_TIME is null");
			return (Criteria) this;
		}

		public Criteria andAuditTimeIsNotNull() {
			addCriterion("AUDIT_TIME is not null");
			return (Criteria) this;
		}

		public Criteria andAuditTimeEqualTo(Date value) {
			addCriterion("AUDIT_TIME =", value, "auditTime");
			return (Criteria) this;
		}

		public Criteria andAuditTimeNotEqualTo(Date value) {
			addCriterion("AUDIT_TIME <>", value, "auditTime");
			return (Criteria) this;
		}

		public Criteria andAuditTimeGreaterThan(Date value) {
			addCriterion("AUDIT_TIME >", value, "auditTime");
			return (Criteria) this;
		}

		public Criteria andAuditTimeGreaterThanOrEqualTo(Date value) {
			addCriterion("AUDIT_TIME >=", value, "auditTime");
			return (Criteria) this;
		}

		public Criteria andAuditTimeLessThan(Date value) {
			addCriterion("AUDIT_TIME <", value, "auditTime");
			return (Criteria) this;
		}

		public Criteria andAuditTimeLessThanOrEqualTo(Date value) {
			addCriterion("AUDIT_TIME <=", value, "auditTime");
			return (Criteria) this;
		}

		public Criteria andAuditTimeIn(List<Date> values) {
			addCriterion("AUDIT_TIME in", values, "auditTime");
			return (Criteria) this;
		}

		public Criteria andAuditTimeNotIn(List<Date> values) {
			addCriterion("AUDIT_TIME not in", values, "auditTime");
			return (Criteria) this;
		}

		public Criteria andAuditTimeBetween(Date value1, Date value2) {
			addCriterion("AUDIT_TIME between", value1, value2, "auditTime");
			return (Criteria) this;
		}

		public Criteria andAuditTimeNotBetween(Date value1, Date value2) {
			addCriterion("AUDIT_TIME not between", value1, value2, "auditTime");
			return (Criteria) this;
		}

		public Criteria andAuditUserIdIsNull() {
			addCriterion("AUDIT_USER_ID is null");
			return (Criteria) this;
		}

		public Criteria andAuditUserIdIsNotNull() {
			addCriterion("AUDIT_USER_ID is not null");
			return (Criteria) this;
		}

		public Criteria andAuditUserIdEqualTo(Integer value) {
			addCriterion("AUDIT_USER_ID =", value, "auditUserId");
			return (Criteria) this;
		}

		public Criteria andAuditUserIdNotEqualTo(Integer value) {
			addCriterion("AUDIT_USER_ID <>", value, "auditUserId");
			return (Criteria) this;
		}

		public Criteria andAuditUserIdGreaterThan(Integer value) {
			addCriterion("AUDIT_USER_ID >", value, "auditUserId");
			return (Criteria) this;
		}

		public Criteria andAuditUserIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("AUDIT_USER_ID >=", value, "auditUserId");
			return (Criteria) this;
		}

		public Criteria andAuditUserIdLessThan(Integer value) {
			addCriterion("AUDIT_USER_ID <", value, "auditUserId");
			return (Criteria) this;
		}

		public Criteria andAuditUserIdLessThanOrEqualTo(Integer value) {
			addCriterion("AUDIT_USER_ID <=", value, "auditUserId");
			return (Criteria) this;
		}

		public Criteria andAuditUserIdIn(List<Integer> values) {
			addCriterion("AUDIT_USER_ID in", values, "auditUserId");
			return (Criteria) this;
		}

		public Criteria andAuditUserIdNotIn(List<Integer> values) {
			addCriterion("AUDIT_USER_ID not in", values, "auditUserId");
			return (Criteria) this;
		}

		public Criteria andAuditUserIdBetween(Integer value1, Integer value2) {
			addCriterion("AUDIT_USER_ID between", value1, value2, "auditUserId");
			return (Criteria) this;
		}

		public Criteria andAuditUserIdNotBetween(Integer value1, Integer value2) {
			addCriterion("AUDIT_USER_ID not between", value1, value2, "auditUserId");
			return (Criteria) this;
		}

		public Criteria andAuditResultIsNull() {
			addCriterion("AUDIT_RESULT is null");
			return (Criteria) this;
		}

		public Criteria andAuditResultIsNotNull() {
			addCriterion("AUDIT_RESULT is not null");
			return (Criteria) this;
		}

		public Criteria andAuditResultEqualTo(Byte value) {
			addCriterion("AUDIT_RESULT =", value, "auditResult");
			return (Criteria) this;
		}

		public Criteria andAuditResultNotEqualTo(Byte value) {
			addCriterion("AUDIT_RESULT <>", value, "auditResult");
			return (Criteria) this;
		}

		public Criteria andAuditResultGreaterThan(Byte value) {
			addCriterion("AUDIT_RESULT >", value, "auditResult");
			return (Criteria) this;
		}

		public Criteria andAuditResultGreaterThanOrEqualTo(Byte value) {
			addCriterion("AUDIT_RESULT >=", value, "auditResult");
			return (Criteria) this;
		}

		public Criteria andAuditResultLessThan(Byte value) {
			addCriterion("AUDIT_RESULT <", value, "auditResult");
			return (Criteria) this;
		}

		public Criteria andAuditResultLessThanOrEqualTo(Byte value) {
			addCriterion("AUDIT_RESULT <=", value, "auditResult");
			return (Criteria) this;
		}

		public Criteria andAuditResultIn(List<Byte> values) {
			addCriterion("AUDIT_RESULT in", values, "auditResult");
			return (Criteria) this;
		}

		public Criteria andAuditResultNotIn(List<Byte> values) {
			addCriterion("AUDIT_RESULT not in", values, "auditResult");
			return (Criteria) this;
		}

		public Criteria andAuditResultBetween(Byte value1, Byte value2) {
			addCriterion("AUDIT_RESULT between", value1, value2, "auditResult");
			return (Criteria) this;
		}

		public Criteria andAuditResultNotBetween(Byte value1, Byte value2) {
			addCriterion("AUDIT_RESULT not between", value1, value2, "auditResult");
			return (Criteria) this;
		}

		public Criteria andAuditCurrentPIdIsNull() {
			addCriterion("AUDIT_CURRENT_P_ID is null");
			return (Criteria) this;
		}

		public Criteria andAuditCurrentPIdIsNotNull() {
			addCriterion("AUDIT_CURRENT_P_ID is not null");
			return (Criteria) this;
		}

		public Criteria andAuditCurrentPIdEqualTo(Integer value) {
			addCriterion("AUDIT_CURRENT_P_ID =", value, "auditCurrentPId");
			return (Criteria) this;
		}

		public Criteria andAuditCurrentPIdNotEqualTo(Integer value) {
			addCriterion("AUDIT_CURRENT_P_ID <>", value, "auditCurrentPId");
			return (Criteria) this;
		}

		public Criteria andAuditCurrentPIdGreaterThan(Integer value) {
			addCriterion("AUDIT_CURRENT_P_ID >", value, "auditCurrentPId");
			return (Criteria) this;
		}

		public Criteria andAuditCurrentPIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("AUDIT_CURRENT_P_ID >=", value, "auditCurrentPId");
			return (Criteria) this;
		}

		public Criteria andAuditCurrentPIdLessThan(Integer value) {
			addCriterion("AUDIT_CURRENT_P_ID <", value, "auditCurrentPId");
			return (Criteria) this;
		}

		public Criteria andAuditCurrentPIdLessThanOrEqualTo(Integer value) {
			addCriterion("AUDIT_CURRENT_P_ID <=", value, "auditCurrentPId");
			return (Criteria) this;
		}

		public Criteria andAuditCurrentPIdIn(List<Integer> values) {
			addCriterion("AUDIT_CURRENT_P_ID in", values, "auditCurrentPId");
			return (Criteria) this;
		}

		public Criteria andAuditCurrentPIdNotIn(List<Integer> values) {
			addCriterion("AUDIT_CURRENT_P_ID not in", values, "auditCurrentPId");
			return (Criteria) this;
		}

		public Criteria andAuditCurrentPIdBetween(Integer value1, Integer value2) {
			addCriterion("AUDIT_CURRENT_P_ID between", value1, value2, "auditCurrentPId");
			return (Criteria) this;
		}

		public Criteria andAuditCurrentPIdNotBetween(Integer value1, Integer value2) {
			addCriterion("AUDIT_CURRENT_P_ID not between", value1, value2, "auditCurrentPId");
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