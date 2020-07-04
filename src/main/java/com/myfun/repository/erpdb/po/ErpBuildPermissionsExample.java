package com.myfun.repository.erpdb.po;

import com.myfun.repository.support.generator.shard.ShardDb;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ErpBuildPermissionsExample extends ShardDb {
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
	public ErpBuildPermissionsExample() {
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

		public Criteria andBpIdIsNull() {
			addCriterion("BP_ID is null");
			return (Criteria) this;
		}

		public Criteria andBpIdIsNotNull() {
			addCriterion("BP_ID is not null");
			return (Criteria) this;
		}

		public Criteria andBpIdEqualTo(Integer value) {
			addCriterion("BP_ID =", value, "bpId");
			return (Criteria) this;
		}

		public Criteria andBpIdNotEqualTo(Integer value) {
			addCriterion("BP_ID <>", value, "bpId");
			return (Criteria) this;
		}

		public Criteria andBpIdGreaterThan(Integer value) {
			addCriterion("BP_ID >", value, "bpId");
			return (Criteria) this;
		}

		public Criteria andBpIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("BP_ID >=", value, "bpId");
			return (Criteria) this;
		}

		public Criteria andBpIdLessThan(Integer value) {
			addCriterion("BP_ID <", value, "bpId");
			return (Criteria) this;
		}

		public Criteria andBpIdLessThanOrEqualTo(Integer value) {
			addCriterion("BP_ID <=", value, "bpId");
			return (Criteria) this;
		}

		public Criteria andBpIdIn(List<Integer> values) {
			addCriterion("BP_ID in", values, "bpId");
			return (Criteria) this;
		}

		public Criteria andBpIdNotIn(List<Integer> values) {
			addCriterion("BP_ID not in", values, "bpId");
			return (Criteria) this;
		}

		public Criteria andBpIdBetween(Integer value1, Integer value2) {
			addCriterion("BP_ID between", value1, value2, "bpId");
			return (Criteria) this;
		}

		public Criteria andBpIdNotBetween(Integer value1, Integer value2) {
			addCriterion("BP_ID not between", value1, value2, "bpId");
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

		public Criteria andBuildIdIsNull() {
			addCriterion("BUILD_ID is null");
			return (Criteria) this;
		}

		public Criteria andBuildIdIsNotNull() {
			addCriterion("BUILD_ID is not null");
			return (Criteria) this;
		}

		public Criteria andBuildIdEqualTo(Integer value) {
			addCriterion("BUILD_ID =", value, "buildId");
			return (Criteria) this;
		}

		public Criteria andBuildIdNotEqualTo(Integer value) {
			addCriterion("BUILD_ID <>", value, "buildId");
			return (Criteria) this;
		}

		public Criteria andBuildIdGreaterThan(Integer value) {
			addCriterion("BUILD_ID >", value, "buildId");
			return (Criteria) this;
		}

		public Criteria andBuildIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("BUILD_ID >=", value, "buildId");
			return (Criteria) this;
		}

		public Criteria andBuildIdLessThan(Integer value) {
			addCriterion("BUILD_ID <", value, "buildId");
			return (Criteria) this;
		}

		public Criteria andBuildIdLessThanOrEqualTo(Integer value) {
			addCriterion("BUILD_ID <=", value, "buildId");
			return (Criteria) this;
		}

		public Criteria andBuildIdIn(List<Integer> values) {
			addCriterion("BUILD_ID in", values, "buildId");
			return (Criteria) this;
		}

		public Criteria andBuildIdNotIn(List<Integer> values) {
			addCriterion("BUILD_ID not in", values, "buildId");
			return (Criteria) this;
		}

		public Criteria andBuildIdBetween(Integer value1, Integer value2) {
			addCriterion("BUILD_ID between", value1, value2, "buildId");
			return (Criteria) this;
		}

		public Criteria andBuildIdNotBetween(Integer value1, Integer value2) {
			addCriterion("BUILD_ID not between", value1, value2, "buildId");
			return (Criteria) this;
		}

		public Criteria andAddPermissionIsNull() {
			addCriterion("ADD_PERMISSION is null");
			return (Criteria) this;
		}

		public Criteria andAddPermissionIsNotNull() {
			addCriterion("ADD_PERMISSION is not null");
			return (Criteria) this;
		}

		public Criteria andAddPermissionEqualTo(Byte value) {
			addCriterion("ADD_PERMISSION =", value, "addPermission");
			return (Criteria) this;
		}

		public Criteria andAddPermissionNotEqualTo(Byte value) {
			addCriterion("ADD_PERMISSION <>", value, "addPermission");
			return (Criteria) this;
		}

		public Criteria andAddPermissionGreaterThan(Byte value) {
			addCriterion("ADD_PERMISSION >", value, "addPermission");
			return (Criteria) this;
		}

		public Criteria andAddPermissionGreaterThanOrEqualTo(Byte value) {
			addCriterion("ADD_PERMISSION >=", value, "addPermission");
			return (Criteria) this;
		}

		public Criteria andAddPermissionLessThan(Byte value) {
			addCriterion("ADD_PERMISSION <", value, "addPermission");
			return (Criteria) this;
		}

		public Criteria andAddPermissionLessThanOrEqualTo(Byte value) {
			addCriterion("ADD_PERMISSION <=", value, "addPermission");
			return (Criteria) this;
		}

		public Criteria andAddPermissionIn(List<Byte> values) {
			addCriterion("ADD_PERMISSION in", values, "addPermission");
			return (Criteria) this;
		}

		public Criteria andAddPermissionNotIn(List<Byte> values) {
			addCriterion("ADD_PERMISSION not in", values, "addPermission");
			return (Criteria) this;
		}

		public Criteria andAddPermissionBetween(Byte value1, Byte value2) {
			addCriterion("ADD_PERMISSION between", value1, value2, "addPermission");
			return (Criteria) this;
		}

		public Criteria andAddPermissionNotBetween(Byte value1, Byte value2) {
			addCriterion("ADD_PERMISSION not between", value1, value2, "addPermission");
			return (Criteria) this;
		}

		public Criteria andEditPermissionIsNull() {
			addCriterion("EDIT_PERMISSION is null");
			return (Criteria) this;
		}

		public Criteria andEditPermissionIsNotNull() {
			addCriterion("EDIT_PERMISSION is not null");
			return (Criteria) this;
		}

		public Criteria andEditPermissionEqualTo(Byte value) {
			addCriterion("EDIT_PERMISSION =", value, "editPermission");
			return (Criteria) this;
		}

		public Criteria andEditPermissionNotEqualTo(Byte value) {
			addCriterion("EDIT_PERMISSION <>", value, "editPermission");
			return (Criteria) this;
		}

		public Criteria andEditPermissionGreaterThan(Byte value) {
			addCriterion("EDIT_PERMISSION >", value, "editPermission");
			return (Criteria) this;
		}

		public Criteria andEditPermissionGreaterThanOrEqualTo(Byte value) {
			addCriterion("EDIT_PERMISSION >=", value, "editPermission");
			return (Criteria) this;
		}

		public Criteria andEditPermissionLessThan(Byte value) {
			addCriterion("EDIT_PERMISSION <", value, "editPermission");
			return (Criteria) this;
		}

		public Criteria andEditPermissionLessThanOrEqualTo(Byte value) {
			addCriterion("EDIT_PERMISSION <=", value, "editPermission");
			return (Criteria) this;
		}

		public Criteria andEditPermissionIn(List<Byte> values) {
			addCriterion("EDIT_PERMISSION in", values, "editPermission");
			return (Criteria) this;
		}

		public Criteria andEditPermissionNotIn(List<Byte> values) {
			addCriterion("EDIT_PERMISSION not in", values, "editPermission");
			return (Criteria) this;
		}

		public Criteria andEditPermissionBetween(Byte value1, Byte value2) {
			addCriterion("EDIT_PERMISSION between", value1, value2, "editPermission");
			return (Criteria) this;
		}

		public Criteria andEditPermissionNotBetween(Byte value1, Byte value2) {
			addCriterion("EDIT_PERMISSION not between", value1, value2, "editPermission");
			return (Criteria) this;
		}

		public Criteria andViewPermissionIsNull() {
			addCriterion("VIEW_PERMISSION is null");
			return (Criteria) this;
		}

		public Criteria andViewPermissionIsNotNull() {
			addCriterion("VIEW_PERMISSION is not null");
			return (Criteria) this;
		}

		public Criteria andViewPermissionEqualTo(Byte value) {
			addCriterion("VIEW_PERMISSION =", value, "viewPermission");
			return (Criteria) this;
		}

		public Criteria andViewPermissionNotEqualTo(Byte value) {
			addCriterion("VIEW_PERMISSION <>", value, "viewPermission");
			return (Criteria) this;
		}

		public Criteria andViewPermissionGreaterThan(Byte value) {
			addCriterion("VIEW_PERMISSION >", value, "viewPermission");
			return (Criteria) this;
		}

		public Criteria andViewPermissionGreaterThanOrEqualTo(Byte value) {
			addCriterion("VIEW_PERMISSION >=", value, "viewPermission");
			return (Criteria) this;
		}

		public Criteria andViewPermissionLessThan(Byte value) {
			addCriterion("VIEW_PERMISSION <", value, "viewPermission");
			return (Criteria) this;
		}

		public Criteria andViewPermissionLessThanOrEqualTo(Byte value) {
			addCriterion("VIEW_PERMISSION <=", value, "viewPermission");
			return (Criteria) this;
		}

		public Criteria andViewPermissionIn(List<Byte> values) {
			addCriterion("VIEW_PERMISSION in", values, "viewPermission");
			return (Criteria) this;
		}

		public Criteria andViewPermissionNotIn(List<Byte> values) {
			addCriterion("VIEW_PERMISSION not in", values, "viewPermission");
			return (Criteria) this;
		}

		public Criteria andViewPermissionBetween(Byte value1, Byte value2) {
			addCriterion("VIEW_PERMISSION between", value1, value2, "viewPermission");
			return (Criteria) this;
		}

		public Criteria andViewPermissionNotBetween(Byte value1, Byte value2) {
			addCriterion("VIEW_PERMISSION not between", value1, value2, "viewPermission");
			return (Criteria) this;
		}

		public Criteria andHouseUseageIsNull() {
			addCriterion("HOUSE_USEAGE is null");
			return (Criteria) this;
		}

		public Criteria andHouseUseageIsNotNull() {
			addCriterion("HOUSE_USEAGE is not null");
			return (Criteria) this;
		}

		public Criteria andHouseUseageEqualTo(String value) {
			addCriterion("HOUSE_USEAGE =", value, "houseUseage");
			return (Criteria) this;
		}

		public Criteria andHouseUseageNotEqualTo(String value) {
			addCriterion("HOUSE_USEAGE <>", value, "houseUseage");
			return (Criteria) this;
		}

		public Criteria andHouseUseageGreaterThan(String value) {
			addCriterion("HOUSE_USEAGE >", value, "houseUseage");
			return (Criteria) this;
		}

		public Criteria andHouseUseageGreaterThanOrEqualTo(String value) {
			addCriterion("HOUSE_USEAGE >=", value, "houseUseage");
			return (Criteria) this;
		}

		public Criteria andHouseUseageLessThan(String value) {
			addCriterion("HOUSE_USEAGE <", value, "houseUseage");
			return (Criteria) this;
		}

		public Criteria andHouseUseageLessThanOrEqualTo(String value) {
			addCriterion("HOUSE_USEAGE <=", value, "houseUseage");
			return (Criteria) this;
		}

		public Criteria andHouseUseageLike(String value) {
			addCriterion("HOUSE_USEAGE like", value, "houseUseage");
			return (Criteria) this;
		}

		public Criteria andHouseUseageNotLike(String value) {
			addCriterion("HOUSE_USEAGE not like", value, "houseUseage");
			return (Criteria) this;
		}

		public Criteria andHouseUseageIn(List<String> values) {
			addCriterion("HOUSE_USEAGE in", values, "houseUseage");
			return (Criteria) this;
		}

		public Criteria andHouseUseageNotIn(List<String> values) {
			addCriterion("HOUSE_USEAGE not in", values, "houseUseage");
			return (Criteria) this;
		}

		public Criteria andHouseUseageBetween(String value1, String value2) {
			addCriterion("HOUSE_USEAGE between", value1, value2, "houseUseage");
			return (Criteria) this;
		}

		public Criteria andHouseUseageNotBetween(String value1, String value2) {
			addCriterion("HOUSE_USEAGE not between", value1, value2, "houseUseage");
			return (Criteria) this;
		}

		public Criteria andCreateUserIdIsNull() {
			addCriterion("CREATE_USER_ID is null");
			return (Criteria) this;
		}

		public Criteria andCreateUserIdIsNotNull() {
			addCriterion("CREATE_USER_ID is not null");
			return (Criteria) this;
		}

		public Criteria andCreateUserIdEqualTo(Integer value) {
			addCriterion("CREATE_USER_ID =", value, "createUserId");
			return (Criteria) this;
		}

		public Criteria andCreateUserIdNotEqualTo(Integer value) {
			addCriterion("CREATE_USER_ID <>", value, "createUserId");
			return (Criteria) this;
		}

		public Criteria andCreateUserIdGreaterThan(Integer value) {
			addCriterion("CREATE_USER_ID >", value, "createUserId");
			return (Criteria) this;
		}

		public Criteria andCreateUserIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("CREATE_USER_ID >=", value, "createUserId");
			return (Criteria) this;
		}

		public Criteria andCreateUserIdLessThan(Integer value) {
			addCriterion("CREATE_USER_ID <", value, "createUserId");
			return (Criteria) this;
		}

		public Criteria andCreateUserIdLessThanOrEqualTo(Integer value) {
			addCriterion("CREATE_USER_ID <=", value, "createUserId");
			return (Criteria) this;
		}

		public Criteria andCreateUserIdIn(List<Integer> values) {
			addCriterion("CREATE_USER_ID in", values, "createUserId");
			return (Criteria) this;
		}

		public Criteria andCreateUserIdNotIn(List<Integer> values) {
			addCriterion("CREATE_USER_ID not in", values, "createUserId");
			return (Criteria) this;
		}

		public Criteria andCreateUserIdBetween(Integer value1, Integer value2) {
			addCriterion("CREATE_USER_ID between", value1, value2, "createUserId");
			return (Criteria) this;
		}

		public Criteria andCreateUserIdNotBetween(Integer value1, Integer value2) {
			addCriterion("CREATE_USER_ID not between", value1, value2, "createUserId");
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

		public Criteria andUpdateUserIdIsNull() {
			addCriterion("UPDATE_USER_ID is null");
			return (Criteria) this;
		}

		public Criteria andUpdateUserIdIsNotNull() {
			addCriterion("UPDATE_USER_ID is not null");
			return (Criteria) this;
		}

		public Criteria andUpdateUserIdEqualTo(Integer value) {
			addCriterion("UPDATE_USER_ID =", value, "updateUserId");
			return (Criteria) this;
		}

		public Criteria andUpdateUserIdNotEqualTo(Integer value) {
			addCriterion("UPDATE_USER_ID <>", value, "updateUserId");
			return (Criteria) this;
		}

		public Criteria andUpdateUserIdGreaterThan(Integer value) {
			addCriterion("UPDATE_USER_ID >", value, "updateUserId");
			return (Criteria) this;
		}

		public Criteria andUpdateUserIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("UPDATE_USER_ID >=", value, "updateUserId");
			return (Criteria) this;
		}

		public Criteria andUpdateUserIdLessThan(Integer value) {
			addCriterion("UPDATE_USER_ID <", value, "updateUserId");
			return (Criteria) this;
		}

		public Criteria andUpdateUserIdLessThanOrEqualTo(Integer value) {
			addCriterion("UPDATE_USER_ID <=", value, "updateUserId");
			return (Criteria) this;
		}

		public Criteria andUpdateUserIdIn(List<Integer> values) {
			addCriterion("UPDATE_USER_ID in", values, "updateUserId");
			return (Criteria) this;
		}

		public Criteria andUpdateUserIdNotIn(List<Integer> values) {
			addCriterion("UPDATE_USER_ID not in", values, "updateUserId");
			return (Criteria) this;
		}

		public Criteria andUpdateUserIdBetween(Integer value1, Integer value2) {
			addCriterion("UPDATE_USER_ID between", value1, value2, "updateUserId");
			return (Criteria) this;
		}

		public Criteria andUpdateUserIdNotBetween(Integer value1, Integer value2) {
			addCriterion("UPDATE_USER_ID not between", value1, value2, "updateUserId");
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

		public Criteria andIsUseageSameIsNull() {
			addCriterion("IS_USEAGE_SAME is null");
			return (Criteria) this;
		}

		public Criteria andIsUseageSameIsNotNull() {
			addCriterion("IS_USEAGE_SAME is not null");
			return (Criteria) this;
		}

		public Criteria andIsUseageSameEqualTo(Byte value) {
			addCriterion("IS_USEAGE_SAME =", value, "isUseageSame");
			return (Criteria) this;
		}

		public Criteria andIsUseageSameNotEqualTo(Byte value) {
			addCriterion("IS_USEAGE_SAME <>", value, "isUseageSame");
			return (Criteria) this;
		}

		public Criteria andIsUseageSameGreaterThan(Byte value) {
			addCriterion("IS_USEAGE_SAME >", value, "isUseageSame");
			return (Criteria) this;
		}

		public Criteria andIsUseageSameGreaterThanOrEqualTo(Byte value) {
			addCriterion("IS_USEAGE_SAME >=", value, "isUseageSame");
			return (Criteria) this;
		}

		public Criteria andIsUseageSameLessThan(Byte value) {
			addCriterion("IS_USEAGE_SAME <", value, "isUseageSame");
			return (Criteria) this;
		}

		public Criteria andIsUseageSameLessThanOrEqualTo(Byte value) {
			addCriterion("IS_USEAGE_SAME <=", value, "isUseageSame");
			return (Criteria) this;
		}

		public Criteria andIsUseageSameIn(List<Byte> values) {
			addCriterion("IS_USEAGE_SAME in", values, "isUseageSame");
			return (Criteria) this;
		}

		public Criteria andIsUseageSameNotIn(List<Byte> values) {
			addCriterion("IS_USEAGE_SAME not in", values, "isUseageSame");
			return (Criteria) this;
		}

		public Criteria andIsUseageSameBetween(Byte value1, Byte value2) {
			addCriterion("IS_USEAGE_SAME between", value1, value2, "isUseageSame");
			return (Criteria) this;
		}

		public Criteria andIsUseageSameNotBetween(Byte value1, Byte value2) {
			addCriterion("IS_USEAGE_SAME not between", value1, value2, "isUseageSame");
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