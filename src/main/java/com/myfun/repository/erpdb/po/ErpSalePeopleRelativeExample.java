package com.myfun.repository.erpdb.po;

import com.myfun.repository.support.generator.shard.ShardDb;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ErpSalePeopleRelativeExample extends ShardDb {
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
	public ErpSalePeopleRelativeExample() {
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

		public Criteria andSaleIdIsNull() {
			addCriterion("SALE_ID is null");
			return (Criteria) this;
		}

		public Criteria andSaleIdIsNotNull() {
			addCriterion("SALE_ID is not null");
			return (Criteria) this;
		}

		public Criteria andSaleIdEqualTo(Integer value) {
			addCriterion("SALE_ID =", value, "saleId");
			return (Criteria) this;
		}

		public Criteria andSaleIdNotEqualTo(Integer value) {
			addCriterion("SALE_ID <>", value, "saleId");
			return (Criteria) this;
		}

		public Criteria andSaleIdGreaterThan(Integer value) {
			addCriterion("SALE_ID >", value, "saleId");
			return (Criteria) this;
		}

		public Criteria andSaleIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("SALE_ID >=", value, "saleId");
			return (Criteria) this;
		}

		public Criteria andSaleIdLessThan(Integer value) {
			addCriterion("SALE_ID <", value, "saleId");
			return (Criteria) this;
		}

		public Criteria andSaleIdLessThanOrEqualTo(Integer value) {
			addCriterion("SALE_ID <=", value, "saleId");
			return (Criteria) this;
		}

		public Criteria andSaleIdIn(List<Integer> values) {
			addCriterion("SALE_ID in", values, "saleId");
			return (Criteria) this;
		}

		public Criteria andSaleIdNotIn(List<Integer> values) {
			addCriterion("SALE_ID not in", values, "saleId");
			return (Criteria) this;
		}

		public Criteria andSaleIdBetween(Integer value1, Integer value2) {
			addCriterion("SALE_ID between", value1, value2, "saleId");
			return (Criteria) this;
		}

		public Criteria andSaleIdNotBetween(Integer value1, Integer value2) {
			addCriterion("SALE_ID not between", value1, value2, "saleId");
			return (Criteria) this;
		}

		public Criteria andPeopleTypeIsNull() {
			addCriterion("PEOPLE_TYPE is null");
			return (Criteria) this;
		}

		public Criteria andPeopleTypeIsNotNull() {
			addCriterion("PEOPLE_TYPE is not null");
			return (Criteria) this;
		}

		public Criteria andPeopleTypeEqualTo(Integer value) {
			addCriterion("PEOPLE_TYPE =", value, "peopleType");
			return (Criteria) this;
		}

		public Criteria andPeopleTypeNotEqualTo(Integer value) {
			addCriterion("PEOPLE_TYPE <>", value, "peopleType");
			return (Criteria) this;
		}

		public Criteria andPeopleTypeGreaterThan(Integer value) {
			addCriterion("PEOPLE_TYPE >", value, "peopleType");
			return (Criteria) this;
		}

		public Criteria andPeopleTypeGreaterThanOrEqualTo(Integer value) {
			addCriterion("PEOPLE_TYPE >=", value, "peopleType");
			return (Criteria) this;
		}

		public Criteria andPeopleTypeLessThan(Integer value) {
			addCriterion("PEOPLE_TYPE <", value, "peopleType");
			return (Criteria) this;
		}

		public Criteria andPeopleTypeLessThanOrEqualTo(Integer value) {
			addCriterion("PEOPLE_TYPE <=", value, "peopleType");
			return (Criteria) this;
		}

		public Criteria andPeopleTypeIn(List<Integer> values) {
			addCriterion("PEOPLE_TYPE in", values, "peopleType");
			return (Criteria) this;
		}

		public Criteria andPeopleTypeNotIn(List<Integer> values) {
			addCriterion("PEOPLE_TYPE not in", values, "peopleType");
			return (Criteria) this;
		}

		public Criteria andPeopleTypeBetween(Integer value1, Integer value2) {
			addCriterion("PEOPLE_TYPE between", value1, value2, "peopleType");
			return (Criteria) this;
		}

		public Criteria andPeopleTypeNotBetween(Integer value1, Integer value2) {
			addCriterion("PEOPLE_TYPE not between", value1, value2, "peopleType");
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

		public Criteria andDelFlagIsNull() {
			addCriterion("DEL_FLAG is null");
			return (Criteria) this;
		}

		public Criteria andDelFlagIsNotNull() {
			addCriterion("DEL_FLAG is not null");
			return (Criteria) this;
		}

		public Criteria andDelFlagEqualTo(Integer value) {
			addCriterion("DEL_FLAG =", value, "delFlag");
			return (Criteria) this;
		}

		public Criteria andDelFlagNotEqualTo(Integer value) {
			addCriterion("DEL_FLAG <>", value, "delFlag");
			return (Criteria) this;
		}

		public Criteria andDelFlagGreaterThan(Integer value) {
			addCriterion("DEL_FLAG >", value, "delFlag");
			return (Criteria) this;
		}

		public Criteria andDelFlagGreaterThanOrEqualTo(Integer value) {
			addCriterion("DEL_FLAG >=", value, "delFlag");
			return (Criteria) this;
		}

		public Criteria andDelFlagLessThan(Integer value) {
			addCriterion("DEL_FLAG <", value, "delFlag");
			return (Criteria) this;
		}

		public Criteria andDelFlagLessThanOrEqualTo(Integer value) {
			addCriterion("DEL_FLAG <=", value, "delFlag");
			return (Criteria) this;
		}

		public Criteria andDelFlagIn(List<Integer> values) {
			addCriterion("DEL_FLAG in", values, "delFlag");
			return (Criteria) this;
		}

		public Criteria andDelFlagNotIn(List<Integer> values) {
			addCriterion("DEL_FLAG not in", values, "delFlag");
			return (Criteria) this;
		}

		public Criteria andDelFlagBetween(Integer value1, Integer value2) {
			addCriterion("DEL_FLAG between", value1, value2, "delFlag");
			return (Criteria) this;
		}

		public Criteria andDelFlagNotBetween(Integer value1, Integer value2) {
			addCriterion("DEL_FLAG not between", value1, value2, "delFlag");
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

		public Criteria andEntrustTypeIsNull() {
			addCriterion("ENTRUST_TYPE is null");
			return (Criteria) this;
		}

		public Criteria andEntrustTypeIsNotNull() {
			addCriterion("ENTRUST_TYPE is not null");
			return (Criteria) this;
		}

		public Criteria andEntrustTypeEqualTo(Integer value) {
			addCriterion("ENTRUST_TYPE =", value, "entrustType");
			return (Criteria) this;
		}

		public Criteria andEntrustTypeNotEqualTo(Integer value) {
			addCriterion("ENTRUST_TYPE <>", value, "entrustType");
			return (Criteria) this;
		}

		public Criteria andEntrustTypeGreaterThan(Integer value) {
			addCriterion("ENTRUST_TYPE >", value, "entrustType");
			return (Criteria) this;
		}

		public Criteria andEntrustTypeGreaterThanOrEqualTo(Integer value) {
			addCriterion("ENTRUST_TYPE >=", value, "entrustType");
			return (Criteria) this;
		}

		public Criteria andEntrustTypeLessThan(Integer value) {
			addCriterion("ENTRUST_TYPE <", value, "entrustType");
			return (Criteria) this;
		}

		public Criteria andEntrustTypeLessThanOrEqualTo(Integer value) {
			addCriterion("ENTRUST_TYPE <=", value, "entrustType");
			return (Criteria) this;
		}

		public Criteria andEntrustTypeIn(List<Integer> values) {
			addCriterion("ENTRUST_TYPE in", values, "entrustType");
			return (Criteria) this;
		}

		public Criteria andEntrustTypeNotIn(List<Integer> values) {
			addCriterion("ENTRUST_TYPE not in", values, "entrustType");
			return (Criteria) this;
		}

		public Criteria andEntrustTypeBetween(Integer value1, Integer value2) {
			addCriterion("ENTRUST_TYPE between", value1, value2, "entrustType");
			return (Criteria) this;
		}

		public Criteria andEntrustTypeNotBetween(Integer value1, Integer value2) {
			addCriterion("ENTRUST_TYPE not between", value1, value2, "entrustType");
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

		public Criteria andDueTimeIsNull() {
			addCriterion("DUE_TIME is null");
			return (Criteria) this;
		}

		public Criteria andDueTimeIsNotNull() {
			addCriterion("DUE_TIME is not null");
			return (Criteria) this;
		}

		public Criteria andDueTimeEqualTo(Date value) {
			addCriterion("DUE_TIME =", value, "dueTime");
			return (Criteria) this;
		}

		public Criteria andDueTimeNotEqualTo(Date value) {
			addCriterion("DUE_TIME <>", value, "dueTime");
			return (Criteria) this;
		}

		public Criteria andDueTimeGreaterThan(Date value) {
			addCriterion("DUE_TIME >", value, "dueTime");
			return (Criteria) this;
		}

		public Criteria andDueTimeGreaterThanOrEqualTo(Date value) {
			addCriterion("DUE_TIME >=", value, "dueTime");
			return (Criteria) this;
		}

		public Criteria andDueTimeLessThan(Date value) {
			addCriterion("DUE_TIME <", value, "dueTime");
			return (Criteria) this;
		}

		public Criteria andDueTimeLessThanOrEqualTo(Date value) {
			addCriterion("DUE_TIME <=", value, "dueTime");
			return (Criteria) this;
		}

		public Criteria andDueTimeIn(List<Date> values) {
			addCriterion("DUE_TIME in", values, "dueTime");
			return (Criteria) this;
		}

		public Criteria andDueTimeNotIn(List<Date> values) {
			addCriterion("DUE_TIME not in", values, "dueTime");
			return (Criteria) this;
		}

		public Criteria andDueTimeBetween(Date value1, Date value2) {
			addCriterion("DUE_TIME between", value1, value2, "dueTime");
			return (Criteria) this;
		}

		public Criteria andDueTimeNotBetween(Date value1, Date value2) {
			addCriterion("DUE_TIME not between", value1, value2, "dueTime");
			return (Criteria) this;
		}

		public Criteria andTrackIdIsNull() {
			addCriterion("TRACK_ID is null");
			return (Criteria) this;
		}

		public Criteria andTrackIdIsNotNull() {
			addCriterion("TRACK_ID is not null");
			return (Criteria) this;
		}

		public Criteria andTrackIdEqualTo(Integer value) {
			addCriterion("TRACK_ID =", value, "trackId");
			return (Criteria) this;
		}

		public Criteria andTrackIdNotEqualTo(Integer value) {
			addCriterion("TRACK_ID <>", value, "trackId");
			return (Criteria) this;
		}

		public Criteria andTrackIdGreaterThan(Integer value) {
			addCriterion("TRACK_ID >", value, "trackId");
			return (Criteria) this;
		}

		public Criteria andTrackIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("TRACK_ID >=", value, "trackId");
			return (Criteria) this;
		}

		public Criteria andTrackIdLessThan(Integer value) {
			addCriterion("TRACK_ID <", value, "trackId");
			return (Criteria) this;
		}

		public Criteria andTrackIdLessThanOrEqualTo(Integer value) {
			addCriterion("TRACK_ID <=", value, "trackId");
			return (Criteria) this;
		}

		public Criteria andTrackIdIn(List<Integer> values) {
			addCriterion("TRACK_ID in", values, "trackId");
			return (Criteria) this;
		}

		public Criteria andTrackIdNotIn(List<Integer> values) {
			addCriterion("TRACK_ID not in", values, "trackId");
			return (Criteria) this;
		}

		public Criteria andTrackIdBetween(Integer value1, Integer value2) {
			addCriterion("TRACK_ID between", value1, value2, "trackId");
			return (Criteria) this;
		}

		public Criteria andTrackIdNotBetween(Integer value1, Integer value2) {
			addCriterion("TRACK_ID not between", value1, value2, "trackId");
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

		public Criteria andOrganizationNameIsNull() {
			addCriterion("ORGANIZATION_NAME is null");
			return (Criteria) this;
		}

		public Criteria andOrganizationNameIsNotNull() {
			addCriterion("ORGANIZATION_NAME is not null");
			return (Criteria) this;
		}

		public Criteria andOrganizationNameEqualTo(String value) {
			addCriterion("ORGANIZATION_NAME =", value, "organizationName");
			return (Criteria) this;
		}

		public Criteria andOrganizationNameNotEqualTo(String value) {
			addCriterion("ORGANIZATION_NAME <>", value, "organizationName");
			return (Criteria) this;
		}

		public Criteria andOrganizationNameGreaterThan(String value) {
			addCriterion("ORGANIZATION_NAME >", value, "organizationName");
			return (Criteria) this;
		}

		public Criteria andOrganizationNameGreaterThanOrEqualTo(String value) {
			addCriterion("ORGANIZATION_NAME >=", value, "organizationName");
			return (Criteria) this;
		}

		public Criteria andOrganizationNameLessThan(String value) {
			addCriterion("ORGANIZATION_NAME <", value, "organizationName");
			return (Criteria) this;
		}

		public Criteria andOrganizationNameLessThanOrEqualTo(String value) {
			addCriterion("ORGANIZATION_NAME <=", value, "organizationName");
			return (Criteria) this;
		}

		public Criteria andOrganizationNameLike(String value) {
			addCriterion("ORGANIZATION_NAME like", value, "organizationName");
			return (Criteria) this;
		}

		public Criteria andOrganizationNameNotLike(String value) {
			addCriterion("ORGANIZATION_NAME not like", value, "organizationName");
			return (Criteria) this;
		}

		public Criteria andOrganizationNameIn(List<String> values) {
			addCriterion("ORGANIZATION_NAME in", values, "organizationName");
			return (Criteria) this;
		}

		public Criteria andOrganizationNameNotIn(List<String> values) {
			addCriterion("ORGANIZATION_NAME not in", values, "organizationName");
			return (Criteria) this;
		}

		public Criteria andOrganizationNameBetween(String value1, String value2) {
			addCriterion("ORGANIZATION_NAME between", value1, value2, "organizationName");
			return (Criteria) this;
		}

		public Criteria andOrganizationNameNotBetween(String value1, String value2) {
			addCriterion("ORGANIZATION_NAME not between", value1, value2, "organizationName");
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