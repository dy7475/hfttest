package com.myfun.repository.erpdb.po;

import com.myfun.repository.support.generator.shard.ShardDb;
import java.util.ArrayList;
import java.util.List;

public class ErpFunRegionExample extends ShardDb {
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
	public ErpFunRegionExample() {
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

		public Criteria andRegIdIsNull() {
			addCriterion("REG_ID is null");
			return (Criteria) this;
		}

		public Criteria andRegIdIsNotNull() {
			addCriterion("REG_ID is not null");
			return (Criteria) this;
		}

		public Criteria andRegIdEqualTo(Integer value) {
			addCriterion("REG_ID =", value, "regId");
			return (Criteria) this;
		}

		public Criteria andRegIdNotEqualTo(Integer value) {
			addCriterion("REG_ID <>", value, "regId");
			return (Criteria) this;
		}

		public Criteria andRegIdGreaterThan(Integer value) {
			addCriterion("REG_ID >", value, "regId");
			return (Criteria) this;
		}

		public Criteria andRegIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("REG_ID >=", value, "regId");
			return (Criteria) this;
		}

		public Criteria andRegIdLessThan(Integer value) {
			addCriterion("REG_ID <", value, "regId");
			return (Criteria) this;
		}

		public Criteria andRegIdLessThanOrEqualTo(Integer value) {
			addCriterion("REG_ID <=", value, "regId");
			return (Criteria) this;
		}

		public Criteria andRegIdIn(List<Integer> values) {
			addCriterion("REG_ID in", values, "regId");
			return (Criteria) this;
		}

		public Criteria andRegIdNotIn(List<Integer> values) {
			addCriterion("REG_ID not in", values, "regId");
			return (Criteria) this;
		}

		public Criteria andRegIdBetween(Integer value1, Integer value2) {
			addCriterion("REG_ID between", value1, value2, "regId");
			return (Criteria) this;
		}

		public Criteria andRegIdNotBetween(Integer value1, Integer value2) {
			addCriterion("REG_ID not between", value1, value2, "regId");
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

		public Criteria andRegNameIsNull() {
			addCriterion("REG_NAME is null");
			return (Criteria) this;
		}

		public Criteria andRegNameIsNotNull() {
			addCriterion("REG_NAME is not null");
			return (Criteria) this;
		}

		public Criteria andRegNameEqualTo(String value) {
			addCriterion("REG_NAME =", value, "regName");
			return (Criteria) this;
		}

		public Criteria andRegNameNotEqualTo(String value) {
			addCriterion("REG_NAME <>", value, "regName");
			return (Criteria) this;
		}

		public Criteria andRegNameGreaterThan(String value) {
			addCriterion("REG_NAME >", value, "regName");
			return (Criteria) this;
		}

		public Criteria andRegNameGreaterThanOrEqualTo(String value) {
			addCriterion("REG_NAME >=", value, "regName");
			return (Criteria) this;
		}

		public Criteria andRegNameLessThan(String value) {
			addCriterion("REG_NAME <", value, "regName");
			return (Criteria) this;
		}

		public Criteria andRegNameLessThanOrEqualTo(String value) {
			addCriterion("REG_NAME <=", value, "regName");
			return (Criteria) this;
		}

		public Criteria andRegNameLike(String value) {
			addCriterion("REG_NAME like", value, "regName");
			return (Criteria) this;
		}

		public Criteria andRegNameNotLike(String value) {
			addCriterion("REG_NAME not like", value, "regName");
			return (Criteria) this;
		}

		public Criteria andRegNameIn(List<String> values) {
			addCriterion("REG_NAME in", values, "regName");
			return (Criteria) this;
		}

		public Criteria andRegNameNotIn(List<String> values) {
			addCriterion("REG_NAME not in", values, "regName");
			return (Criteria) this;
		}

		public Criteria andRegNameBetween(String value1, String value2) {
			addCriterion("REG_NAME between", value1, value2, "regName");
			return (Criteria) this;
		}

		public Criteria andRegNameNotBetween(String value1, String value2) {
			addCriterion("REG_NAME not between", value1, value2, "regName");
			return (Criteria) this;
		}

		public Criteria andSeqNoIsNull() {
			addCriterion("SEQ_NO is null");
			return (Criteria) this;
		}

		public Criteria andSeqNoIsNotNull() {
			addCriterion("SEQ_NO is not null");
			return (Criteria) this;
		}

		public Criteria andSeqNoEqualTo(Integer value) {
			addCriterion("SEQ_NO =", value, "seqNo");
			return (Criteria) this;
		}

		public Criteria andSeqNoNotEqualTo(Integer value) {
			addCriterion("SEQ_NO <>", value, "seqNo");
			return (Criteria) this;
		}

		public Criteria andSeqNoGreaterThan(Integer value) {
			addCriterion("SEQ_NO >", value, "seqNo");
			return (Criteria) this;
		}

		public Criteria andSeqNoGreaterThanOrEqualTo(Integer value) {
			addCriterion("SEQ_NO >=", value, "seqNo");
			return (Criteria) this;
		}

		public Criteria andSeqNoLessThan(Integer value) {
			addCriterion("SEQ_NO <", value, "seqNo");
			return (Criteria) this;
		}

		public Criteria andSeqNoLessThanOrEqualTo(Integer value) {
			addCriterion("SEQ_NO <=", value, "seqNo");
			return (Criteria) this;
		}

		public Criteria andSeqNoIn(List<Integer> values) {
			addCriterion("SEQ_NO in", values, "seqNo");
			return (Criteria) this;
		}

		public Criteria andSeqNoNotIn(List<Integer> values) {
			addCriterion("SEQ_NO not in", values, "seqNo");
			return (Criteria) this;
		}

		public Criteria andSeqNoBetween(Integer value1, Integer value2) {
			addCriterion("SEQ_NO between", value1, value2, "seqNo");
			return (Criteria) this;
		}

		public Criteria andSeqNoNotBetween(Integer value1, Integer value2) {
			addCriterion("SEQ_NO not between", value1, value2, "seqNo");
			return (Criteria) this;
		}

		public Criteria andAdminUserIsNull() {
			addCriterion("ADMIN_USER is null");
			return (Criteria) this;
		}

		public Criteria andAdminUserIsNotNull() {
			addCriterion("ADMIN_USER is not null");
			return (Criteria) this;
		}

		public Criteria andAdminUserEqualTo(Integer value) {
			addCriterion("ADMIN_USER =", value, "adminUser");
			return (Criteria) this;
		}

		public Criteria andAdminUserNotEqualTo(Integer value) {
			addCriterion("ADMIN_USER <>", value, "adminUser");
			return (Criteria) this;
		}

		public Criteria andAdminUserGreaterThan(Integer value) {
			addCriterion("ADMIN_USER >", value, "adminUser");
			return (Criteria) this;
		}

		public Criteria andAdminUserGreaterThanOrEqualTo(Integer value) {
			addCriterion("ADMIN_USER >=", value, "adminUser");
			return (Criteria) this;
		}

		public Criteria andAdminUserLessThan(Integer value) {
			addCriterion("ADMIN_USER <", value, "adminUser");
			return (Criteria) this;
		}

		public Criteria andAdminUserLessThanOrEqualTo(Integer value) {
			addCriterion("ADMIN_USER <=", value, "adminUser");
			return (Criteria) this;
		}

		public Criteria andAdminUserIn(List<Integer> values) {
			addCriterion("ADMIN_USER in", values, "adminUser");
			return (Criteria) this;
		}

		public Criteria andAdminUserNotIn(List<Integer> values) {
			addCriterion("ADMIN_USER not in", values, "adminUser");
			return (Criteria) this;
		}

		public Criteria andAdminUserBetween(Integer value1, Integer value2) {
			addCriterion("ADMIN_USER between", value1, value2, "adminUser");
			return (Criteria) this;
		}

		public Criteria andAdminUserNotBetween(Integer value1, Integer value2) {
			addCriterion("ADMIN_USER not between", value1, value2, "adminUser");
			return (Criteria) this;
		}

		public Criteria andRegAdminIsNull() {
			addCriterion("REG_ADMIN is null");
			return (Criteria) this;
		}

		public Criteria andRegAdminIsNotNull() {
			addCriterion("REG_ADMIN is not null");
			return (Criteria) this;
		}

		public Criteria andRegAdminEqualTo(String value) {
			addCriterion("REG_ADMIN =", value, "regAdmin");
			return (Criteria) this;
		}

		public Criteria andRegAdminNotEqualTo(String value) {
			addCriterion("REG_ADMIN <>", value, "regAdmin");
			return (Criteria) this;
		}

		public Criteria andRegAdminGreaterThan(String value) {
			addCriterion("REG_ADMIN >", value, "regAdmin");
			return (Criteria) this;
		}

		public Criteria andRegAdminGreaterThanOrEqualTo(String value) {
			addCriterion("REG_ADMIN >=", value, "regAdmin");
			return (Criteria) this;
		}

		public Criteria andRegAdminLessThan(String value) {
			addCriterion("REG_ADMIN <", value, "regAdmin");
			return (Criteria) this;
		}

		public Criteria andRegAdminLessThanOrEqualTo(String value) {
			addCriterion("REG_ADMIN <=", value, "regAdmin");
			return (Criteria) this;
		}

		public Criteria andRegAdminLike(String value) {
			addCriterion("REG_ADMIN like", value, "regAdmin");
			return (Criteria) this;
		}

		public Criteria andRegAdminNotLike(String value) {
			addCriterion("REG_ADMIN not like", value, "regAdmin");
			return (Criteria) this;
		}

		public Criteria andRegAdminIn(List<String> values) {
			addCriterion("REG_ADMIN in", values, "regAdmin");
			return (Criteria) this;
		}

		public Criteria andRegAdminNotIn(List<String> values) {
			addCriterion("REG_ADMIN not in", values, "regAdmin");
			return (Criteria) this;
		}

		public Criteria andRegAdminBetween(String value1, String value2) {
			addCriterion("REG_ADMIN between", value1, value2, "regAdmin");
			return (Criteria) this;
		}

		public Criteria andRegAdminNotBetween(String value1, String value2) {
			addCriterion("REG_ADMIN not between", value1, value2, "regAdmin");
			return (Criteria) this;
		}

		public Criteria andRegTeleIsNull() {
			addCriterion("REG_TELE is null");
			return (Criteria) this;
		}

		public Criteria andRegTeleIsNotNull() {
			addCriterion("REG_TELE is not null");
			return (Criteria) this;
		}

		public Criteria andRegTeleEqualTo(String value) {
			addCriterion("REG_TELE =", value, "regTele");
			return (Criteria) this;
		}

		public Criteria andRegTeleNotEqualTo(String value) {
			addCriterion("REG_TELE <>", value, "regTele");
			return (Criteria) this;
		}

		public Criteria andRegTeleGreaterThan(String value) {
			addCriterion("REG_TELE >", value, "regTele");
			return (Criteria) this;
		}

		public Criteria andRegTeleGreaterThanOrEqualTo(String value) {
			addCriterion("REG_TELE >=", value, "regTele");
			return (Criteria) this;
		}

		public Criteria andRegTeleLessThan(String value) {
			addCriterion("REG_TELE <", value, "regTele");
			return (Criteria) this;
		}

		public Criteria andRegTeleLessThanOrEqualTo(String value) {
			addCriterion("REG_TELE <=", value, "regTele");
			return (Criteria) this;
		}

		public Criteria andRegTeleLike(String value) {
			addCriterion("REG_TELE like", value, "regTele");
			return (Criteria) this;
		}

		public Criteria andRegTeleNotLike(String value) {
			addCriterion("REG_TELE not like", value, "regTele");
			return (Criteria) this;
		}

		public Criteria andRegTeleIn(List<String> values) {
			addCriterion("REG_TELE in", values, "regTele");
			return (Criteria) this;
		}

		public Criteria andRegTeleNotIn(List<String> values) {
			addCriterion("REG_TELE not in", values, "regTele");
			return (Criteria) this;
		}

		public Criteria andRegTeleBetween(String value1, String value2) {
			addCriterion("REG_TELE between", value1, value2, "regTele");
			return (Criteria) this;
		}

		public Criteria andRegTeleNotBetween(String value1, String value2) {
			addCriterion("REG_TELE not between", value1, value2, "regTele");
			return (Criteria) this;
		}

		public Criteria andRegDescIsNull() {
			addCriterion("REG_DESC is null");
			return (Criteria) this;
		}

		public Criteria andRegDescIsNotNull() {
			addCriterion("REG_DESC is not null");
			return (Criteria) this;
		}

		public Criteria andRegDescEqualTo(String value) {
			addCriterion("REG_DESC =", value, "regDesc");
			return (Criteria) this;
		}

		public Criteria andRegDescNotEqualTo(String value) {
			addCriterion("REG_DESC <>", value, "regDesc");
			return (Criteria) this;
		}

		public Criteria andRegDescGreaterThan(String value) {
			addCriterion("REG_DESC >", value, "regDesc");
			return (Criteria) this;
		}

		public Criteria andRegDescGreaterThanOrEqualTo(String value) {
			addCriterion("REG_DESC >=", value, "regDesc");
			return (Criteria) this;
		}

		public Criteria andRegDescLessThan(String value) {
			addCriterion("REG_DESC <", value, "regDesc");
			return (Criteria) this;
		}

		public Criteria andRegDescLessThanOrEqualTo(String value) {
			addCriterion("REG_DESC <=", value, "regDesc");
			return (Criteria) this;
		}

		public Criteria andRegDescLike(String value) {
			addCriterion("REG_DESC like", value, "regDesc");
			return (Criteria) this;
		}

		public Criteria andRegDescNotLike(String value) {
			addCriterion("REG_DESC not like", value, "regDesc");
			return (Criteria) this;
		}

		public Criteria andRegDescIn(List<String> values) {
			addCriterion("REG_DESC in", values, "regDesc");
			return (Criteria) this;
		}

		public Criteria andRegDescNotIn(List<String> values) {
			addCriterion("REG_DESC not in", values, "regDesc");
			return (Criteria) this;
		}

		public Criteria andRegDescBetween(String value1, String value2) {
			addCriterion("REG_DESC between", value1, value2, "regDesc");
			return (Criteria) this;
		}

		public Criteria andRegDescNotBetween(String value1, String value2) {
			addCriterion("REG_DESC not between", value1, value2, "regDesc");
			return (Criteria) this;
		}

		public Criteria andUpdateUidIsNull() {
			addCriterion("UPDATE_UID is null");
			return (Criteria) this;
		}

		public Criteria andUpdateUidIsNotNull() {
			addCriterion("UPDATE_UID is not null");
			return (Criteria) this;
		}

		public Criteria andUpdateUidEqualTo(Integer value) {
			addCriterion("UPDATE_UID =", value, "updateUid");
			return (Criteria) this;
		}

		public Criteria andUpdateUidNotEqualTo(Integer value) {
			addCriterion("UPDATE_UID <>", value, "updateUid");
			return (Criteria) this;
		}

		public Criteria andUpdateUidGreaterThan(Integer value) {
			addCriterion("UPDATE_UID >", value, "updateUid");
			return (Criteria) this;
		}

		public Criteria andUpdateUidGreaterThanOrEqualTo(Integer value) {
			addCriterion("UPDATE_UID >=", value, "updateUid");
			return (Criteria) this;
		}

		public Criteria andUpdateUidLessThan(Integer value) {
			addCriterion("UPDATE_UID <", value, "updateUid");
			return (Criteria) this;
		}

		public Criteria andUpdateUidLessThanOrEqualTo(Integer value) {
			addCriterion("UPDATE_UID <=", value, "updateUid");
			return (Criteria) this;
		}

		public Criteria andUpdateUidIn(List<Integer> values) {
			addCriterion("UPDATE_UID in", values, "updateUid");
			return (Criteria) this;
		}

		public Criteria andUpdateUidNotIn(List<Integer> values) {
			addCriterion("UPDATE_UID not in", values, "updateUid");
			return (Criteria) this;
		}

		public Criteria andUpdateUidBetween(Integer value1, Integer value2) {
			addCriterion("UPDATE_UID between", value1, value2, "updateUid");
			return (Criteria) this;
		}

		public Criteria andUpdateUidNotBetween(Integer value1, Integer value2) {
			addCriterion("UPDATE_UID not between", value1, value2, "updateUid");
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

		public Criteria andUpdateTimeEqualTo(String value) {
			addCriterion("UPDATE_TIME =", value, "updateTime");
			return (Criteria) this;
		}

		public Criteria andUpdateTimeNotEqualTo(String value) {
			addCriterion("UPDATE_TIME <>", value, "updateTime");
			return (Criteria) this;
		}

		public Criteria andUpdateTimeGreaterThan(String value) {
			addCriterion("UPDATE_TIME >", value, "updateTime");
			return (Criteria) this;
		}

		public Criteria andUpdateTimeGreaterThanOrEqualTo(String value) {
			addCriterion("UPDATE_TIME >=", value, "updateTime");
			return (Criteria) this;
		}

		public Criteria andUpdateTimeLessThan(String value) {
			addCriterion("UPDATE_TIME <", value, "updateTime");
			return (Criteria) this;
		}

		public Criteria andUpdateTimeLessThanOrEqualTo(String value) {
			addCriterion("UPDATE_TIME <=", value, "updateTime");
			return (Criteria) this;
		}

		public Criteria andUpdateTimeLike(String value) {
			addCriterion("UPDATE_TIME like", value, "updateTime");
			return (Criteria) this;
		}

		public Criteria andUpdateTimeNotLike(String value) {
			addCriterion("UPDATE_TIME not like", value, "updateTime");
			return (Criteria) this;
		}

		public Criteria andUpdateTimeIn(List<String> values) {
			addCriterion("UPDATE_TIME in", values, "updateTime");
			return (Criteria) this;
		}

		public Criteria andUpdateTimeNotIn(List<String> values) {
			addCriterion("UPDATE_TIME not in", values, "updateTime");
			return (Criteria) this;
		}

		public Criteria andUpdateTimeBetween(String value1, String value2) {
			addCriterion("UPDATE_TIME between", value1, value2, "updateTime");
			return (Criteria) this;
		}

		public Criteria andUpdateTimeNotBetween(String value1, String value2) {
			addCriterion("UPDATE_TIME not between", value1, value2, "updateTime");
			return (Criteria) this;
		}

		public Criteria andAreaIdIsNull() {
			addCriterion("AREA_ID is null");
			return (Criteria) this;
		}

		public Criteria andAreaIdIsNotNull() {
			addCriterion("AREA_ID is not null");
			return (Criteria) this;
		}

		public Criteria andAreaIdEqualTo(Integer value) {
			addCriterion("AREA_ID =", value, "areaId");
			return (Criteria) this;
		}

		public Criteria andAreaIdNotEqualTo(Integer value) {
			addCriterion("AREA_ID <>", value, "areaId");
			return (Criteria) this;
		}

		public Criteria andAreaIdGreaterThan(Integer value) {
			addCriterion("AREA_ID >", value, "areaId");
			return (Criteria) this;
		}

		public Criteria andAreaIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("AREA_ID >=", value, "areaId");
			return (Criteria) this;
		}

		public Criteria andAreaIdLessThan(Integer value) {
			addCriterion("AREA_ID <", value, "areaId");
			return (Criteria) this;
		}

		public Criteria andAreaIdLessThanOrEqualTo(Integer value) {
			addCriterion("AREA_ID <=", value, "areaId");
			return (Criteria) this;
		}

		public Criteria andAreaIdIn(List<Integer> values) {
			addCriterion("AREA_ID in", values, "areaId");
			return (Criteria) this;
		}

		public Criteria andAreaIdNotIn(List<Integer> values) {
			addCriterion("AREA_ID not in", values, "areaId");
			return (Criteria) this;
		}

		public Criteria andAreaIdBetween(Integer value1, Integer value2) {
			addCriterion("AREA_ID between", value1, value2, "areaId");
			return (Criteria) this;
		}

		public Criteria andAreaIdNotBetween(Integer value1, Integer value2) {
			addCriterion("AREA_ID not between", value1, value2, "areaId");
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