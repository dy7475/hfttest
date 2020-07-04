package com.myfun.repository.admindb.po;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AdminWeiUserInfoExample {
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
	public AdminWeiUserInfoExample() {
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

		public Criteria andWeiUserIdIsNull() {
			addCriterion("WEI_USER_ID is null");
			return (Criteria) this;
		}

		public Criteria andWeiUserIdIsNotNull() {
			addCriterion("WEI_USER_ID is not null");
			return (Criteria) this;
		}

		public Criteria andWeiUserIdEqualTo(Integer value) {
			addCriterion("WEI_USER_ID =", value, "weiUserId");
			return (Criteria) this;
		}

		public Criteria andWeiUserIdNotEqualTo(Integer value) {
			addCriterion("WEI_USER_ID <>", value, "weiUserId");
			return (Criteria) this;
		}

		public Criteria andWeiUserIdGreaterThan(Integer value) {
			addCriterion("WEI_USER_ID >", value, "weiUserId");
			return (Criteria) this;
		}

		public Criteria andWeiUserIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("WEI_USER_ID >=", value, "weiUserId");
			return (Criteria) this;
		}

		public Criteria andWeiUserIdLessThan(Integer value) {
			addCriterion("WEI_USER_ID <", value, "weiUserId");
			return (Criteria) this;
		}

		public Criteria andWeiUserIdLessThanOrEqualTo(Integer value) {
			addCriterion("WEI_USER_ID <=", value, "weiUserId");
			return (Criteria) this;
		}

		public Criteria andWeiUserIdIn(List<Integer> values) {
			addCriterion("WEI_USER_ID in", values, "weiUserId");
			return (Criteria) this;
		}

		public Criteria andWeiUserIdNotIn(List<Integer> values) {
			addCriterion("WEI_USER_ID not in", values, "weiUserId");
			return (Criteria) this;
		}

		public Criteria andWeiUserIdBetween(Integer value1, Integer value2) {
			addCriterion("WEI_USER_ID between", value1, value2, "weiUserId");
			return (Criteria) this;
		}

		public Criteria andWeiUserIdNotBetween(Integer value1, Integer value2) {
			addCriterion("WEI_USER_ID not between", value1, value2, "weiUserId");
			return (Criteria) this;
		}

		public Criteria andUserMobileIsNull() {
			addCriterion("USER_MOBILE is null");
			return (Criteria) this;
		}

		public Criteria andUserMobileIsNotNull() {
			addCriterion("USER_MOBILE is not null");
			return (Criteria) this;
		}

		public Criteria andUserMobileEqualTo(String value) {
			addCriterion("USER_MOBILE =", value, "userMobile");
			return (Criteria) this;
		}

		public Criteria andUserMobileNotEqualTo(String value) {
			addCriterion("USER_MOBILE <>", value, "userMobile");
			return (Criteria) this;
		}

		public Criteria andUserMobileGreaterThan(String value) {
			addCriterion("USER_MOBILE >", value, "userMobile");
			return (Criteria) this;
		}

		public Criteria andUserMobileGreaterThanOrEqualTo(String value) {
			addCriterion("USER_MOBILE >=", value, "userMobile");
			return (Criteria) this;
		}

		public Criteria andUserMobileLessThan(String value) {
			addCriterion("USER_MOBILE <", value, "userMobile");
			return (Criteria) this;
		}

		public Criteria andUserMobileLessThanOrEqualTo(String value) {
			addCriterion("USER_MOBILE <=", value, "userMobile");
			return (Criteria) this;
		}

		public Criteria andUserMobileLike(String value) {
			addCriterion("USER_MOBILE like", value, "userMobile");
			return (Criteria) this;
		}

		public Criteria andUserMobileNotLike(String value) {
			addCriterion("USER_MOBILE not like", value, "userMobile");
			return (Criteria) this;
		}

		public Criteria andUserMobileIn(List<String> values) {
			addCriterion("USER_MOBILE in", values, "userMobile");
			return (Criteria) this;
		}

		public Criteria andUserMobileNotIn(List<String> values) {
			addCriterion("USER_MOBILE not in", values, "userMobile");
			return (Criteria) this;
		}

		public Criteria andUserMobileBetween(String value1, String value2) {
			addCriterion("USER_MOBILE between", value1, value2, "userMobile");
			return (Criteria) this;
		}

		public Criteria andUserMobileNotBetween(String value1, String value2) {
			addCriterion("USER_MOBILE not between", value1, value2, "userMobile");
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

		public Criteria andUserQqIsNull() {
			addCriterion("USER_QQ is null");
			return (Criteria) this;
		}

		public Criteria andUserQqIsNotNull() {
			addCriterion("USER_QQ is not null");
			return (Criteria) this;
		}

		public Criteria andUserQqEqualTo(String value) {
			addCriterion("USER_QQ =", value, "userQq");
			return (Criteria) this;
		}

		public Criteria andUserQqNotEqualTo(String value) {
			addCriterion("USER_QQ <>", value, "userQq");
			return (Criteria) this;
		}

		public Criteria andUserQqGreaterThan(String value) {
			addCriterion("USER_QQ >", value, "userQq");
			return (Criteria) this;
		}

		public Criteria andUserQqGreaterThanOrEqualTo(String value) {
			addCriterion("USER_QQ >=", value, "userQq");
			return (Criteria) this;
		}

		public Criteria andUserQqLessThan(String value) {
			addCriterion("USER_QQ <", value, "userQq");
			return (Criteria) this;
		}

		public Criteria andUserQqLessThanOrEqualTo(String value) {
			addCriterion("USER_QQ <=", value, "userQq");
			return (Criteria) this;
		}

		public Criteria andUserQqLike(String value) {
			addCriterion("USER_QQ like", value, "userQq");
			return (Criteria) this;
		}

		public Criteria andUserQqNotLike(String value) {
			addCriterion("USER_QQ not like", value, "userQq");
			return (Criteria) this;
		}

		public Criteria andUserQqIn(List<String> values) {
			addCriterion("USER_QQ in", values, "userQq");
			return (Criteria) this;
		}

		public Criteria andUserQqNotIn(List<String> values) {
			addCriterion("USER_QQ not in", values, "userQq");
			return (Criteria) this;
		}

		public Criteria andUserQqBetween(String value1, String value2) {
			addCriterion("USER_QQ between", value1, value2, "userQq");
			return (Criteria) this;
		}

		public Criteria andUserQqNotBetween(String value1, String value2) {
			addCriterion("USER_QQ not between", value1, value2, "userQq");
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

		public Criteria andWeixinNickNameIsNull() {
			addCriterion("WEIXIN_NICK_NAME is null");
			return (Criteria) this;
		}

		public Criteria andWeixinNickNameIsNotNull() {
			addCriterion("WEIXIN_NICK_NAME is not null");
			return (Criteria) this;
		}

		public Criteria andWeixinNickNameEqualTo(String value) {
			addCriterion("WEIXIN_NICK_NAME =", value, "weixinNickName");
			return (Criteria) this;
		}

		public Criteria andWeixinNickNameNotEqualTo(String value) {
			addCriterion("WEIXIN_NICK_NAME <>", value, "weixinNickName");
			return (Criteria) this;
		}

		public Criteria andWeixinNickNameGreaterThan(String value) {
			addCriterion("WEIXIN_NICK_NAME >", value, "weixinNickName");
			return (Criteria) this;
		}

		public Criteria andWeixinNickNameGreaterThanOrEqualTo(String value) {
			addCriterion("WEIXIN_NICK_NAME >=", value, "weixinNickName");
			return (Criteria) this;
		}

		public Criteria andWeixinNickNameLessThan(String value) {
			addCriterion("WEIXIN_NICK_NAME <", value, "weixinNickName");
			return (Criteria) this;
		}

		public Criteria andWeixinNickNameLessThanOrEqualTo(String value) {
			addCriterion("WEIXIN_NICK_NAME <=", value, "weixinNickName");
			return (Criteria) this;
		}

		public Criteria andWeixinNickNameLike(String value) {
			addCriterion("WEIXIN_NICK_NAME like", value, "weixinNickName");
			return (Criteria) this;
		}

		public Criteria andWeixinNickNameNotLike(String value) {
			addCriterion("WEIXIN_NICK_NAME not like", value, "weixinNickName");
			return (Criteria) this;
		}

		public Criteria andWeixinNickNameIn(List<String> values) {
			addCriterion("WEIXIN_NICK_NAME in", values, "weixinNickName");
			return (Criteria) this;
		}

		public Criteria andWeixinNickNameNotIn(List<String> values) {
			addCriterion("WEIXIN_NICK_NAME not in", values, "weixinNickName");
			return (Criteria) this;
		}

		public Criteria andWeixinNickNameBetween(String value1, String value2) {
			addCriterion("WEIXIN_NICK_NAME between", value1, value2, "weixinNickName");
			return (Criteria) this;
		}

		public Criteria andWeixinNickNameNotBetween(String value1, String value2) {
			addCriterion("WEIXIN_NICK_NAME not between", value1, value2, "weixinNickName");
			return (Criteria) this;
		}

		public Criteria andWeixinOpenIdIsNull() {
			addCriterion("WEIXIN_OPEN_ID is null");
			return (Criteria) this;
		}

		public Criteria andWeixinOpenIdIsNotNull() {
			addCriterion("WEIXIN_OPEN_ID is not null");
			return (Criteria) this;
		}

		public Criteria andWeixinOpenIdEqualTo(String value) {
			addCriterion("WEIXIN_OPEN_ID =", value, "weixinOpenId");
			return (Criteria) this;
		}

		public Criteria andWeixinOpenIdNotEqualTo(String value) {
			addCriterion("WEIXIN_OPEN_ID <>", value, "weixinOpenId");
			return (Criteria) this;
		}

		public Criteria andWeixinOpenIdGreaterThan(String value) {
			addCriterion("WEIXIN_OPEN_ID >", value, "weixinOpenId");
			return (Criteria) this;
		}

		public Criteria andWeixinOpenIdGreaterThanOrEqualTo(String value) {
			addCriterion("WEIXIN_OPEN_ID >=", value, "weixinOpenId");
			return (Criteria) this;
		}

		public Criteria andWeixinOpenIdLessThan(String value) {
			addCriterion("WEIXIN_OPEN_ID <", value, "weixinOpenId");
			return (Criteria) this;
		}

		public Criteria andWeixinOpenIdLessThanOrEqualTo(String value) {
			addCriterion("WEIXIN_OPEN_ID <=", value, "weixinOpenId");
			return (Criteria) this;
		}

		public Criteria andWeixinOpenIdLike(String value) {
			addCriterion("WEIXIN_OPEN_ID like", value, "weixinOpenId");
			return (Criteria) this;
		}

		public Criteria andWeixinOpenIdNotLike(String value) {
			addCriterion("WEIXIN_OPEN_ID not like", value, "weixinOpenId");
			return (Criteria) this;
		}

		public Criteria andWeixinOpenIdIn(List<String> values) {
			addCriterion("WEIXIN_OPEN_ID in", values, "weixinOpenId");
			return (Criteria) this;
		}

		public Criteria andWeixinOpenIdNotIn(List<String> values) {
			addCriterion("WEIXIN_OPEN_ID not in", values, "weixinOpenId");
			return (Criteria) this;
		}

		public Criteria andWeixinOpenIdBetween(String value1, String value2) {
			addCriterion("WEIXIN_OPEN_ID between", value1, value2, "weixinOpenId");
			return (Criteria) this;
		}

		public Criteria andWeixinOpenIdNotBetween(String value1, String value2) {
			addCriterion("WEIXIN_OPEN_ID not between", value1, value2, "weixinOpenId");
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

		public Criteria andUserStatusIsNull() {
			addCriterion("USER_STATUS is null");
			return (Criteria) this;
		}

		public Criteria andUserStatusIsNotNull() {
			addCriterion("USER_STATUS is not null");
			return (Criteria) this;
		}

		public Criteria andUserStatusEqualTo(Integer value) {
			addCriterion("USER_STATUS =", value, "userStatus");
			return (Criteria) this;
		}

		public Criteria andUserStatusNotEqualTo(Integer value) {
			addCriterion("USER_STATUS <>", value, "userStatus");
			return (Criteria) this;
		}

		public Criteria andUserStatusGreaterThan(Integer value) {
			addCriterion("USER_STATUS >", value, "userStatus");
			return (Criteria) this;
		}

		public Criteria andUserStatusGreaterThanOrEqualTo(Integer value) {
			addCriterion("USER_STATUS >=", value, "userStatus");
			return (Criteria) this;
		}

		public Criteria andUserStatusLessThan(Integer value) {
			addCriterion("USER_STATUS <", value, "userStatus");
			return (Criteria) this;
		}

		public Criteria andUserStatusLessThanOrEqualTo(Integer value) {
			addCriterion("USER_STATUS <=", value, "userStatus");
			return (Criteria) this;
		}

		public Criteria andUserStatusIn(List<Integer> values) {
			addCriterion("USER_STATUS in", values, "userStatus");
			return (Criteria) this;
		}

		public Criteria andUserStatusNotIn(List<Integer> values) {
			addCriterion("USER_STATUS not in", values, "userStatus");
			return (Criteria) this;
		}

		public Criteria andUserStatusBetween(Integer value1, Integer value2) {
			addCriterion("USER_STATUS between", value1, value2, "userStatus");
			return (Criteria) this;
		}

		public Criteria andUserStatusNotBetween(Integer value1, Integer value2) {
			addCriterion("USER_STATUS not between", value1, value2, "userStatus");
			return (Criteria) this;
		}

		public Criteria andUserPhotoIsNull() {
			addCriterion("USER_PHOTO is null");
			return (Criteria) this;
		}

		public Criteria andUserPhotoIsNotNull() {
			addCriterion("USER_PHOTO is not null");
			return (Criteria) this;
		}

		public Criteria andUserPhotoEqualTo(String value) {
			addCriterion("USER_PHOTO =", value, "userPhoto");
			return (Criteria) this;
		}

		public Criteria andUserPhotoNotEqualTo(String value) {
			addCriterion("USER_PHOTO <>", value, "userPhoto");
			return (Criteria) this;
		}

		public Criteria andUserPhotoGreaterThan(String value) {
			addCriterion("USER_PHOTO >", value, "userPhoto");
			return (Criteria) this;
		}

		public Criteria andUserPhotoGreaterThanOrEqualTo(String value) {
			addCriterion("USER_PHOTO >=", value, "userPhoto");
			return (Criteria) this;
		}

		public Criteria andUserPhotoLessThan(String value) {
			addCriterion("USER_PHOTO <", value, "userPhoto");
			return (Criteria) this;
		}

		public Criteria andUserPhotoLessThanOrEqualTo(String value) {
			addCriterion("USER_PHOTO <=", value, "userPhoto");
			return (Criteria) this;
		}

		public Criteria andUserPhotoLike(String value) {
			addCriterion("USER_PHOTO like", value, "userPhoto");
			return (Criteria) this;
		}

		public Criteria andUserPhotoNotLike(String value) {
			addCriterion("USER_PHOTO not like", value, "userPhoto");
			return (Criteria) this;
		}

		public Criteria andUserPhotoIn(List<String> values) {
			addCriterion("USER_PHOTO in", values, "userPhoto");
			return (Criteria) this;
		}

		public Criteria andUserPhotoNotIn(List<String> values) {
			addCriterion("USER_PHOTO not in", values, "userPhoto");
			return (Criteria) this;
		}

		public Criteria andUserPhotoBetween(String value1, String value2) {
			addCriterion("USER_PHOTO between", value1, value2, "userPhoto");
			return (Criteria) this;
		}

		public Criteria andUserPhotoNotBetween(String value1, String value2) {
			addCriterion("USER_PHOTO not between", value1, value2, "userPhoto");
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

		public Criteria andWeixinNickName2IsNull() {
			addCriterion("WEIXIN_NICK_NAME_2 is null");
			return (Criteria) this;
		}

		public Criteria andWeixinNickName2IsNotNull() {
			addCriterion("WEIXIN_NICK_NAME_2 is not null");
			return (Criteria) this;
		}

		public Criteria andWeixinNickName2EqualTo(String value) {
			addCriterion("WEIXIN_NICK_NAME_2 =", value, "weixinNickName2");
			return (Criteria) this;
		}

		public Criteria andWeixinNickName2NotEqualTo(String value) {
			addCriterion("WEIXIN_NICK_NAME_2 <>", value, "weixinNickName2");
			return (Criteria) this;
		}

		public Criteria andWeixinNickName2GreaterThan(String value) {
			addCriterion("WEIXIN_NICK_NAME_2 >", value, "weixinNickName2");
			return (Criteria) this;
		}

		public Criteria andWeixinNickName2GreaterThanOrEqualTo(String value) {
			addCriterion("WEIXIN_NICK_NAME_2 >=", value, "weixinNickName2");
			return (Criteria) this;
		}

		public Criteria andWeixinNickName2LessThan(String value) {
			addCriterion("WEIXIN_NICK_NAME_2 <", value, "weixinNickName2");
			return (Criteria) this;
		}

		public Criteria andWeixinNickName2LessThanOrEqualTo(String value) {
			addCriterion("WEIXIN_NICK_NAME_2 <=", value, "weixinNickName2");
			return (Criteria) this;
		}

		public Criteria andWeixinNickName2Like(String value) {
			addCriterion("WEIXIN_NICK_NAME_2 like", value, "weixinNickName2");
			return (Criteria) this;
		}

		public Criteria andWeixinNickName2NotLike(String value) {
			addCriterion("WEIXIN_NICK_NAME_2 not like", value, "weixinNickName2");
			return (Criteria) this;
		}

		public Criteria andWeixinNickName2In(List<String> values) {
			addCriterion("WEIXIN_NICK_NAME_2 in", values, "weixinNickName2");
			return (Criteria) this;
		}

		public Criteria andWeixinNickName2NotIn(List<String> values) {
			addCriterion("WEIXIN_NICK_NAME_2 not in", values, "weixinNickName2");
			return (Criteria) this;
		}

		public Criteria andWeixinNickName2Between(String value1, String value2) {
			addCriterion("WEIXIN_NICK_NAME_2 between", value1, value2, "weixinNickName2");
			return (Criteria) this;
		}

		public Criteria andWeixinNickName2NotBetween(String value1, String value2) {
			addCriterion("WEIXIN_NICK_NAME_2 not between", value1, value2, "weixinNickName2");
			return (Criteria) this;
		}

		public Criteria andWeixinOpenId2IsNull() {
			addCriterion("WEIXIN_OPEN_ID_2 is null");
			return (Criteria) this;
		}

		public Criteria andWeixinOpenId2IsNotNull() {
			addCriterion("WEIXIN_OPEN_ID_2 is not null");
			return (Criteria) this;
		}

		public Criteria andWeixinOpenId2EqualTo(String value) {
			addCriterion("WEIXIN_OPEN_ID_2 =", value, "weixinOpenId2");
			return (Criteria) this;
		}

		public Criteria andWeixinOpenId2NotEqualTo(String value) {
			addCriterion("WEIXIN_OPEN_ID_2 <>", value, "weixinOpenId2");
			return (Criteria) this;
		}

		public Criteria andWeixinOpenId2GreaterThan(String value) {
			addCriterion("WEIXIN_OPEN_ID_2 >", value, "weixinOpenId2");
			return (Criteria) this;
		}

		public Criteria andWeixinOpenId2GreaterThanOrEqualTo(String value) {
			addCriterion("WEIXIN_OPEN_ID_2 >=", value, "weixinOpenId2");
			return (Criteria) this;
		}

		public Criteria andWeixinOpenId2LessThan(String value) {
			addCriterion("WEIXIN_OPEN_ID_2 <", value, "weixinOpenId2");
			return (Criteria) this;
		}

		public Criteria andWeixinOpenId2LessThanOrEqualTo(String value) {
			addCriterion("WEIXIN_OPEN_ID_2 <=", value, "weixinOpenId2");
			return (Criteria) this;
		}

		public Criteria andWeixinOpenId2Like(String value) {
			addCriterion("WEIXIN_OPEN_ID_2 like", value, "weixinOpenId2");
			return (Criteria) this;
		}

		public Criteria andWeixinOpenId2NotLike(String value) {
			addCriterion("WEIXIN_OPEN_ID_2 not like", value, "weixinOpenId2");
			return (Criteria) this;
		}

		public Criteria andWeixinOpenId2In(List<String> values) {
			addCriterion("WEIXIN_OPEN_ID_2 in", values, "weixinOpenId2");
			return (Criteria) this;
		}

		public Criteria andWeixinOpenId2NotIn(List<String> values) {
			addCriterion("WEIXIN_OPEN_ID_2 not in", values, "weixinOpenId2");
			return (Criteria) this;
		}

		public Criteria andWeixinOpenId2Between(String value1, String value2) {
			addCriterion("WEIXIN_OPEN_ID_2 between", value1, value2, "weixinOpenId2");
			return (Criteria) this;
		}

		public Criteria andWeixinOpenId2NotBetween(String value1, String value2) {
			addCriterion("WEIXIN_OPEN_ID_2 not between", value1, value2, "weixinOpenId2");
			return (Criteria) this;
		}

		public Criteria andUserPhoto2IsNull() {
			addCriterion("USER_PHOTO_2 is null");
			return (Criteria) this;
		}

		public Criteria andUserPhoto2IsNotNull() {
			addCriterion("USER_PHOTO_2 is not null");
			return (Criteria) this;
		}

		public Criteria andUserPhoto2EqualTo(String value) {
			addCriterion("USER_PHOTO_2 =", value, "userPhoto2");
			return (Criteria) this;
		}

		public Criteria andUserPhoto2NotEqualTo(String value) {
			addCriterion("USER_PHOTO_2 <>", value, "userPhoto2");
			return (Criteria) this;
		}

		public Criteria andUserPhoto2GreaterThan(String value) {
			addCriterion("USER_PHOTO_2 >", value, "userPhoto2");
			return (Criteria) this;
		}

		public Criteria andUserPhoto2GreaterThanOrEqualTo(String value) {
			addCriterion("USER_PHOTO_2 >=", value, "userPhoto2");
			return (Criteria) this;
		}

		public Criteria andUserPhoto2LessThan(String value) {
			addCriterion("USER_PHOTO_2 <", value, "userPhoto2");
			return (Criteria) this;
		}

		public Criteria andUserPhoto2LessThanOrEqualTo(String value) {
			addCriterion("USER_PHOTO_2 <=", value, "userPhoto2");
			return (Criteria) this;
		}

		public Criteria andUserPhoto2Like(String value) {
			addCriterion("USER_PHOTO_2 like", value, "userPhoto2");
			return (Criteria) this;
		}

		public Criteria andUserPhoto2NotLike(String value) {
			addCriterion("USER_PHOTO_2 not like", value, "userPhoto2");
			return (Criteria) this;
		}

		public Criteria andUserPhoto2In(List<String> values) {
			addCriterion("USER_PHOTO_2 in", values, "userPhoto2");
			return (Criteria) this;
		}

		public Criteria andUserPhoto2NotIn(List<String> values) {
			addCriterion("USER_PHOTO_2 not in", values, "userPhoto2");
			return (Criteria) this;
		}

		public Criteria andUserPhoto2Between(String value1, String value2) {
			addCriterion("USER_PHOTO_2 between", value1, value2, "userPhoto2");
			return (Criteria) this;
		}

		public Criteria andUserPhoto2NotBetween(String value1, String value2) {
			addCriterion("USER_PHOTO_2 not between", value1, value2, "userPhoto2");
			return (Criteria) this;
		}

		public Criteria andCrmCompIdIsNull() {
			addCriterion("CRM_COMP_ID is null");
			return (Criteria) this;
		}

		public Criteria andCrmCompIdIsNotNull() {
			addCriterion("CRM_COMP_ID is not null");
			return (Criteria) this;
		}

		public Criteria andCrmCompIdEqualTo(Integer value) {
			addCriterion("CRM_COMP_ID =", value, "crmCompId");
			return (Criteria) this;
		}

		public Criteria andCrmCompIdNotEqualTo(Integer value) {
			addCriterion("CRM_COMP_ID <>", value, "crmCompId");
			return (Criteria) this;
		}

		public Criteria andCrmCompIdGreaterThan(Integer value) {
			addCriterion("CRM_COMP_ID >", value, "crmCompId");
			return (Criteria) this;
		}

		public Criteria andCrmCompIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("CRM_COMP_ID >=", value, "crmCompId");
			return (Criteria) this;
		}

		public Criteria andCrmCompIdLessThan(Integer value) {
			addCriterion("CRM_COMP_ID <", value, "crmCompId");
			return (Criteria) this;
		}

		public Criteria andCrmCompIdLessThanOrEqualTo(Integer value) {
			addCriterion("CRM_COMP_ID <=", value, "crmCompId");
			return (Criteria) this;
		}

		public Criteria andCrmCompIdIn(List<Integer> values) {
			addCriterion("CRM_COMP_ID in", values, "crmCompId");
			return (Criteria) this;
		}

		public Criteria andCrmCompIdNotIn(List<Integer> values) {
			addCriterion("CRM_COMP_ID not in", values, "crmCompId");
			return (Criteria) this;
		}

		public Criteria andCrmCompIdBetween(Integer value1, Integer value2) {
			addCriterion("CRM_COMP_ID between", value1, value2, "crmCompId");
			return (Criteria) this;
		}

		public Criteria andCrmCompIdNotBetween(Integer value1, Integer value2) {
			addCriterion("CRM_COMP_ID not between", value1, value2, "crmCompId");
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