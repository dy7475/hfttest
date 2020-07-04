package com.myfun.repository.erpdb.po;

import com.myfun.repository.support.generator.shard.ShardDb;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ErpRenovationCustomerExample extends ShardDb {
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
	public ErpRenovationCustomerExample() {
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

		public Criteria andLastTrackUidIsNull() {
			addCriterion("LAST_TRACK_UID is null");
			return (Criteria) this;
		}

		public Criteria andLastTrackUidIsNotNull() {
			addCriterion("LAST_TRACK_UID is not null");
			return (Criteria) this;
		}

		public Criteria andLastTrackUidEqualTo(Integer value) {
			addCriterion("LAST_TRACK_UID =", value, "lastTrackUid");
			return (Criteria) this;
		}

		public Criteria andLastTrackUidNotEqualTo(Integer value) {
			addCriterion("LAST_TRACK_UID <>", value, "lastTrackUid");
			return (Criteria) this;
		}

		public Criteria andLastTrackUidGreaterThan(Integer value) {
			addCriterion("LAST_TRACK_UID >", value, "lastTrackUid");
			return (Criteria) this;
		}

		public Criteria andLastTrackUidGreaterThanOrEqualTo(Integer value) {
			addCriterion("LAST_TRACK_UID >=", value, "lastTrackUid");
			return (Criteria) this;
		}

		public Criteria andLastTrackUidLessThan(Integer value) {
			addCriterion("LAST_TRACK_UID <", value, "lastTrackUid");
			return (Criteria) this;
		}

		public Criteria andLastTrackUidLessThanOrEqualTo(Integer value) {
			addCriterion("LAST_TRACK_UID <=", value, "lastTrackUid");
			return (Criteria) this;
		}

		public Criteria andLastTrackUidIn(List<Integer> values) {
			addCriterion("LAST_TRACK_UID in", values, "lastTrackUid");
			return (Criteria) this;
		}

		public Criteria andLastTrackUidNotIn(List<Integer> values) {
			addCriterion("LAST_TRACK_UID not in", values, "lastTrackUid");
			return (Criteria) this;
		}

		public Criteria andLastTrackUidBetween(Integer value1, Integer value2) {
			addCriterion("LAST_TRACK_UID between", value1, value2, "lastTrackUid");
			return (Criteria) this;
		}

		public Criteria andLastTrackUidNotBetween(Integer value1, Integer value2) {
			addCriterion("LAST_TRACK_UID not between", value1, value2, "lastTrackUid");
			return (Criteria) this;
		}

		public Criteria andLastTrackContentIsNull() {
			addCriterion("LAST_TRACK_CONTENT is null");
			return (Criteria) this;
		}

		public Criteria andLastTrackContentIsNotNull() {
			addCriterion("LAST_TRACK_CONTENT is not null");
			return (Criteria) this;
		}

		public Criteria andLastTrackContentEqualTo(String value) {
			addCriterion("LAST_TRACK_CONTENT =", value, "lastTrackContent");
			return (Criteria) this;
		}

		public Criteria andLastTrackContentNotEqualTo(String value) {
			addCriterion("LAST_TRACK_CONTENT <>", value, "lastTrackContent");
			return (Criteria) this;
		}

		public Criteria andLastTrackContentGreaterThan(String value) {
			addCriterion("LAST_TRACK_CONTENT >", value, "lastTrackContent");
			return (Criteria) this;
		}

		public Criteria andLastTrackContentGreaterThanOrEqualTo(String value) {
			addCriterion("LAST_TRACK_CONTENT >=", value, "lastTrackContent");
			return (Criteria) this;
		}

		public Criteria andLastTrackContentLessThan(String value) {
			addCriterion("LAST_TRACK_CONTENT <", value, "lastTrackContent");
			return (Criteria) this;
		}

		public Criteria andLastTrackContentLessThanOrEqualTo(String value) {
			addCriterion("LAST_TRACK_CONTENT <=", value, "lastTrackContent");
			return (Criteria) this;
		}

		public Criteria andLastTrackContentLike(String value) {
			addCriterion("LAST_TRACK_CONTENT like", value, "lastTrackContent");
			return (Criteria) this;
		}

		public Criteria andLastTrackContentNotLike(String value) {
			addCriterion("LAST_TRACK_CONTENT not like", value, "lastTrackContent");
			return (Criteria) this;
		}

		public Criteria andLastTrackContentIn(List<String> values) {
			addCriterion("LAST_TRACK_CONTENT in", values, "lastTrackContent");
			return (Criteria) this;
		}

		public Criteria andLastTrackContentNotIn(List<String> values) {
			addCriterion("LAST_TRACK_CONTENT not in", values, "lastTrackContent");
			return (Criteria) this;
		}

		public Criteria andLastTrackContentBetween(String value1, String value2) {
			addCriterion("LAST_TRACK_CONTENT between", value1, value2, "lastTrackContent");
			return (Criteria) this;
		}

		public Criteria andLastTrackContentNotBetween(String value1, String value2) {
			addCriterion("LAST_TRACK_CONTENT not between", value1, value2, "lastTrackContent");
			return (Criteria) this;
		}

		public Criteria andLastTrackTimeIsNull() {
			addCriterion("LAST_TRACK_TIME is null");
			return (Criteria) this;
		}

		public Criteria andLastTrackTimeIsNotNull() {
			addCriterion("LAST_TRACK_TIME is not null");
			return (Criteria) this;
		}

		public Criteria andLastTrackTimeEqualTo(Date value) {
			addCriterion("LAST_TRACK_TIME =", value, "lastTrackTime");
			return (Criteria) this;
		}

		public Criteria andLastTrackTimeNotEqualTo(Date value) {
			addCriterion("LAST_TRACK_TIME <>", value, "lastTrackTime");
			return (Criteria) this;
		}

		public Criteria andLastTrackTimeGreaterThan(Date value) {
			addCriterion("LAST_TRACK_TIME >", value, "lastTrackTime");
			return (Criteria) this;
		}

		public Criteria andLastTrackTimeGreaterThanOrEqualTo(Date value) {
			addCriterion("LAST_TRACK_TIME >=", value, "lastTrackTime");
			return (Criteria) this;
		}

		public Criteria andLastTrackTimeLessThan(Date value) {
			addCriterion("LAST_TRACK_TIME <", value, "lastTrackTime");
			return (Criteria) this;
		}

		public Criteria andLastTrackTimeLessThanOrEqualTo(Date value) {
			addCriterion("LAST_TRACK_TIME <=", value, "lastTrackTime");
			return (Criteria) this;
		}

		public Criteria andLastTrackTimeIn(List<Date> values) {
			addCriterion("LAST_TRACK_TIME in", values, "lastTrackTime");
			return (Criteria) this;
		}

		public Criteria andLastTrackTimeNotIn(List<Date> values) {
			addCriterion("LAST_TRACK_TIME not in", values, "lastTrackTime");
			return (Criteria) this;
		}

		public Criteria andLastTrackTimeBetween(Date value1, Date value2) {
			addCriterion("LAST_TRACK_TIME between", value1, value2, "lastTrackTime");
			return (Criteria) this;
		}

		public Criteria andLastTrackTimeNotBetween(Date value1, Date value2) {
			addCriterion("LAST_TRACK_TIME not between", value1, value2, "lastTrackTime");
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

		public Criteria andCustStatusIsNull() {
			addCriterion("CUST_STATUS is null");
			return (Criteria) this;
		}

		public Criteria andCustStatusIsNotNull() {
			addCriterion("CUST_STATUS is not null");
			return (Criteria) this;
		}

		public Criteria andCustStatusEqualTo(Byte value) {
			addCriterion("CUST_STATUS =", value, "custStatus");
			return (Criteria) this;
		}

		public Criteria andCustStatusNotEqualTo(Byte value) {
			addCriterion("CUST_STATUS <>", value, "custStatus");
			return (Criteria) this;
		}

		public Criteria andCustStatusGreaterThan(Byte value) {
			addCriterion("CUST_STATUS >", value, "custStatus");
			return (Criteria) this;
		}

		public Criteria andCustStatusGreaterThanOrEqualTo(Byte value) {
			addCriterion("CUST_STATUS >=", value, "custStatus");
			return (Criteria) this;
		}

		public Criteria andCustStatusLessThan(Byte value) {
			addCriterion("CUST_STATUS <", value, "custStatus");
			return (Criteria) this;
		}

		public Criteria andCustStatusLessThanOrEqualTo(Byte value) {
			addCriterion("CUST_STATUS <=", value, "custStatus");
			return (Criteria) this;
		}

		public Criteria andCustStatusIn(List<Byte> values) {
			addCriterion("CUST_STATUS in", values, "custStatus");
			return (Criteria) this;
		}

		public Criteria andCustStatusNotIn(List<Byte> values) {
			addCriterion("CUST_STATUS not in", values, "custStatus");
			return (Criteria) this;
		}

		public Criteria andCustStatusBetween(Byte value1, Byte value2) {
			addCriterion("CUST_STATUS between", value1, value2, "custStatus");
			return (Criteria) this;
		}

		public Criteria andCustStatusNotBetween(Byte value1, Byte value2) {
			addCriterion("CUST_STATUS not between", value1, value2, "custStatus");
			return (Criteria) this;
		}

		public Criteria andCustVisitIsNull() {
			addCriterion("CUST_VISIT is null");
			return (Criteria) this;
		}

		public Criteria andCustVisitIsNotNull() {
			addCriterion("CUST_VISIT is not null");
			return (Criteria) this;
		}

		public Criteria andCustVisitEqualTo(Byte value) {
			addCriterion("CUST_VISIT =", value, "custVisit");
			return (Criteria) this;
		}

		public Criteria andCustVisitNotEqualTo(Byte value) {
			addCriterion("CUST_VISIT <>", value, "custVisit");
			return (Criteria) this;
		}

		public Criteria andCustVisitGreaterThan(Byte value) {
			addCriterion("CUST_VISIT >", value, "custVisit");
			return (Criteria) this;
		}

		public Criteria andCustVisitGreaterThanOrEqualTo(Byte value) {
			addCriterion("CUST_VISIT >=", value, "custVisit");
			return (Criteria) this;
		}

		public Criteria andCustVisitLessThan(Byte value) {
			addCriterion("CUST_VISIT <", value, "custVisit");
			return (Criteria) this;
		}

		public Criteria andCustVisitLessThanOrEqualTo(Byte value) {
			addCriterion("CUST_VISIT <=", value, "custVisit");
			return (Criteria) this;
		}

		public Criteria andCustVisitIn(List<Byte> values) {
			addCriterion("CUST_VISIT in", values, "custVisit");
			return (Criteria) this;
		}

		public Criteria andCustVisitNotIn(List<Byte> values) {
			addCriterion("CUST_VISIT not in", values, "custVisit");
			return (Criteria) this;
		}

		public Criteria andCustVisitBetween(Byte value1, Byte value2) {
			addCriterion("CUST_VISIT between", value1, value2, "custVisit");
			return (Criteria) this;
		}

		public Criteria andCustVisitNotBetween(Byte value1, Byte value2) {
			addCriterion("CUST_VISIT not between", value1, value2, "custVisit");
			return (Criteria) this;
		}

		public Criteria andCustNameIsNull() {
			addCriterion("CUST_NAME is null");
			return (Criteria) this;
		}

		public Criteria andCustNameIsNotNull() {
			addCriterion("CUST_NAME is not null");
			return (Criteria) this;
		}

		public Criteria andCustNameEqualTo(String value) {
			addCriterion("CUST_NAME =", value, "custName");
			return (Criteria) this;
		}

		public Criteria andCustNameNotEqualTo(String value) {
			addCriterion("CUST_NAME <>", value, "custName");
			return (Criteria) this;
		}

		public Criteria andCustNameGreaterThan(String value) {
			addCriterion("CUST_NAME >", value, "custName");
			return (Criteria) this;
		}

		public Criteria andCustNameGreaterThanOrEqualTo(String value) {
			addCriterion("CUST_NAME >=", value, "custName");
			return (Criteria) this;
		}

		public Criteria andCustNameLessThan(String value) {
			addCriterion("CUST_NAME <", value, "custName");
			return (Criteria) this;
		}

		public Criteria andCustNameLessThanOrEqualTo(String value) {
			addCriterion("CUST_NAME <=", value, "custName");
			return (Criteria) this;
		}

		public Criteria andCustNameLike(String value) {
			addCriterion("CUST_NAME like", value, "custName");
			return (Criteria) this;
		}

		public Criteria andCustNameNotLike(String value) {
			addCriterion("CUST_NAME not like", value, "custName");
			return (Criteria) this;
		}

		public Criteria andCustNameIn(List<String> values) {
			addCriterion("CUST_NAME in", values, "custName");
			return (Criteria) this;
		}

		public Criteria andCustNameNotIn(List<String> values) {
			addCriterion("CUST_NAME not in", values, "custName");
			return (Criteria) this;
		}

		public Criteria andCustNameBetween(String value1, String value2) {
			addCriterion("CUST_NAME between", value1, value2, "custName");
			return (Criteria) this;
		}

		public Criteria andCustNameNotBetween(String value1, String value2) {
			addCriterion("CUST_NAME not between", value1, value2, "custName");
			return (Criteria) this;
		}

		public Criteria andCustSexIsNull() {
			addCriterion("CUST_SEX is null");
			return (Criteria) this;
		}

		public Criteria andCustSexIsNotNull() {
			addCriterion("CUST_SEX is not null");
			return (Criteria) this;
		}

		public Criteria andCustSexEqualTo(Byte value) {
			addCriterion("CUST_SEX =", value, "custSex");
			return (Criteria) this;
		}

		public Criteria andCustSexNotEqualTo(Byte value) {
			addCriterion("CUST_SEX <>", value, "custSex");
			return (Criteria) this;
		}

		public Criteria andCustSexGreaterThan(Byte value) {
			addCriterion("CUST_SEX >", value, "custSex");
			return (Criteria) this;
		}

		public Criteria andCustSexGreaterThanOrEqualTo(Byte value) {
			addCriterion("CUST_SEX >=", value, "custSex");
			return (Criteria) this;
		}

		public Criteria andCustSexLessThan(Byte value) {
			addCriterion("CUST_SEX <", value, "custSex");
			return (Criteria) this;
		}

		public Criteria andCustSexLessThanOrEqualTo(Byte value) {
			addCriterion("CUST_SEX <=", value, "custSex");
			return (Criteria) this;
		}

		public Criteria andCustSexIn(List<Byte> values) {
			addCriterion("CUST_SEX in", values, "custSex");
			return (Criteria) this;
		}

		public Criteria andCustSexNotIn(List<Byte> values) {
			addCriterion("CUST_SEX not in", values, "custSex");
			return (Criteria) this;
		}

		public Criteria andCustSexBetween(Byte value1, Byte value2) {
			addCriterion("CUST_SEX between", value1, value2, "custSex");
			return (Criteria) this;
		}

		public Criteria andCustSexNotBetween(Byte value1, Byte value2) {
			addCriterion("CUST_SEX not between", value1, value2, "custSex");
			return (Criteria) this;
		}

		public Criteria andCustIdCardIsNull() {
			addCriterion("CUST_ID_CARD is null");
			return (Criteria) this;
		}

		public Criteria andCustIdCardIsNotNull() {
			addCriterion("CUST_ID_CARD is not null");
			return (Criteria) this;
		}

		public Criteria andCustIdCardEqualTo(String value) {
			addCriterion("CUST_ID_CARD =", value, "custIdCard");
			return (Criteria) this;
		}

		public Criteria andCustIdCardNotEqualTo(String value) {
			addCriterion("CUST_ID_CARD <>", value, "custIdCard");
			return (Criteria) this;
		}

		public Criteria andCustIdCardGreaterThan(String value) {
			addCriterion("CUST_ID_CARD >", value, "custIdCard");
			return (Criteria) this;
		}

		public Criteria andCustIdCardGreaterThanOrEqualTo(String value) {
			addCriterion("CUST_ID_CARD >=", value, "custIdCard");
			return (Criteria) this;
		}

		public Criteria andCustIdCardLessThan(String value) {
			addCriterion("CUST_ID_CARD <", value, "custIdCard");
			return (Criteria) this;
		}

		public Criteria andCustIdCardLessThanOrEqualTo(String value) {
			addCriterion("CUST_ID_CARD <=", value, "custIdCard");
			return (Criteria) this;
		}

		public Criteria andCustIdCardLike(String value) {
			addCriterion("CUST_ID_CARD like", value, "custIdCard");
			return (Criteria) this;
		}

		public Criteria andCustIdCardNotLike(String value) {
			addCriterion("CUST_ID_CARD not like", value, "custIdCard");
			return (Criteria) this;
		}

		public Criteria andCustIdCardIn(List<String> values) {
			addCriterion("CUST_ID_CARD in", values, "custIdCard");
			return (Criteria) this;
		}

		public Criteria andCustIdCardNotIn(List<String> values) {
			addCriterion("CUST_ID_CARD not in", values, "custIdCard");
			return (Criteria) this;
		}

		public Criteria andCustIdCardBetween(String value1, String value2) {
			addCriterion("CUST_ID_CARD between", value1, value2, "custIdCard");
			return (Criteria) this;
		}

		public Criteria andCustIdCardNotBetween(String value1, String value2) {
			addCriterion("CUST_ID_CARD not between", value1, value2, "custIdCard");
			return (Criteria) this;
		}

		public Criteria andCustMobileIsNull() {
			addCriterion("CUST_MOBILE is null");
			return (Criteria) this;
		}

		public Criteria andCustMobileIsNotNull() {
			addCriterion("CUST_MOBILE is not null");
			return (Criteria) this;
		}

		public Criteria andCustMobileEqualTo(String value) {
			addCriterion("CUST_MOBILE =", value, "custMobile");
			return (Criteria) this;
		}

		public Criteria andCustMobileNotEqualTo(String value) {
			addCriterion("CUST_MOBILE <>", value, "custMobile");
			return (Criteria) this;
		}

		public Criteria andCustMobileGreaterThan(String value) {
			addCriterion("CUST_MOBILE >", value, "custMobile");
			return (Criteria) this;
		}

		public Criteria andCustMobileGreaterThanOrEqualTo(String value) {
			addCriterion("CUST_MOBILE >=", value, "custMobile");
			return (Criteria) this;
		}

		public Criteria andCustMobileLessThan(String value) {
			addCriterion("CUST_MOBILE <", value, "custMobile");
			return (Criteria) this;
		}

		public Criteria andCustMobileLessThanOrEqualTo(String value) {
			addCriterion("CUST_MOBILE <=", value, "custMobile");
			return (Criteria) this;
		}

		public Criteria andCustMobileLike(String value) {
			addCriterion("CUST_MOBILE like", value, "custMobile");
			return (Criteria) this;
		}

		public Criteria andCustMobileNotLike(String value) {
			addCriterion("CUST_MOBILE not like", value, "custMobile");
			return (Criteria) this;
		}

		public Criteria andCustMobileIn(List<String> values) {
			addCriterion("CUST_MOBILE in", values, "custMobile");
			return (Criteria) this;
		}

		public Criteria andCustMobileNotIn(List<String> values) {
			addCriterion("CUST_MOBILE not in", values, "custMobile");
			return (Criteria) this;
		}

		public Criteria andCustMobileBetween(String value1, String value2) {
			addCriterion("CUST_MOBILE between", value1, value2, "custMobile");
			return (Criteria) this;
		}

		public Criteria andCustMobileNotBetween(String value1, String value2) {
			addCriterion("CUST_MOBILE not between", value1, value2, "custMobile");
			return (Criteria) this;
		}

		public Criteria andCustLevelIsNull() {
			addCriterion("CUST_LEVEL is null");
			return (Criteria) this;
		}

		public Criteria andCustLevelIsNotNull() {
			addCriterion("CUST_LEVEL is not null");
			return (Criteria) this;
		}

		public Criteria andCustLevelEqualTo(Byte value) {
			addCriterion("CUST_LEVEL =", value, "custLevel");
			return (Criteria) this;
		}

		public Criteria andCustLevelNotEqualTo(Byte value) {
			addCriterion("CUST_LEVEL <>", value, "custLevel");
			return (Criteria) this;
		}

		public Criteria andCustLevelGreaterThan(Byte value) {
			addCriterion("CUST_LEVEL >", value, "custLevel");
			return (Criteria) this;
		}

		public Criteria andCustLevelGreaterThanOrEqualTo(Byte value) {
			addCriterion("CUST_LEVEL >=", value, "custLevel");
			return (Criteria) this;
		}

		public Criteria andCustLevelLessThan(Byte value) {
			addCriterion("CUST_LEVEL <", value, "custLevel");
			return (Criteria) this;
		}

		public Criteria andCustLevelLessThanOrEqualTo(Byte value) {
			addCriterion("CUST_LEVEL <=", value, "custLevel");
			return (Criteria) this;
		}

		public Criteria andCustLevelIn(List<Byte> values) {
			addCriterion("CUST_LEVEL in", values, "custLevel");
			return (Criteria) this;
		}

		public Criteria andCustLevelNotIn(List<Byte> values) {
			addCriterion("CUST_LEVEL not in", values, "custLevel");
			return (Criteria) this;
		}

		public Criteria andCustLevelBetween(Byte value1, Byte value2) {
			addCriterion("CUST_LEVEL between", value1, value2, "custLevel");
			return (Criteria) this;
		}

		public Criteria andCustLevelNotBetween(Byte value1, Byte value2) {
			addCriterion("CUST_LEVEL not between", value1, value2, "custLevel");
			return (Criteria) this;
		}

		public Criteria andCustEmailIsNull() {
			addCriterion("CUST_EMAIL is null");
			return (Criteria) this;
		}

		public Criteria andCustEmailIsNotNull() {
			addCriterion("CUST_EMAIL is not null");
			return (Criteria) this;
		}

		public Criteria andCustEmailEqualTo(String value) {
			addCriterion("CUST_EMAIL =", value, "custEmail");
			return (Criteria) this;
		}

		public Criteria andCustEmailNotEqualTo(String value) {
			addCriterion("CUST_EMAIL <>", value, "custEmail");
			return (Criteria) this;
		}

		public Criteria andCustEmailGreaterThan(String value) {
			addCriterion("CUST_EMAIL >", value, "custEmail");
			return (Criteria) this;
		}

		public Criteria andCustEmailGreaterThanOrEqualTo(String value) {
			addCriterion("CUST_EMAIL >=", value, "custEmail");
			return (Criteria) this;
		}

		public Criteria andCustEmailLessThan(String value) {
			addCriterion("CUST_EMAIL <", value, "custEmail");
			return (Criteria) this;
		}

		public Criteria andCustEmailLessThanOrEqualTo(String value) {
			addCriterion("CUST_EMAIL <=", value, "custEmail");
			return (Criteria) this;
		}

		public Criteria andCustEmailLike(String value) {
			addCriterion("CUST_EMAIL like", value, "custEmail");
			return (Criteria) this;
		}

		public Criteria andCustEmailNotLike(String value) {
			addCriterion("CUST_EMAIL not like", value, "custEmail");
			return (Criteria) this;
		}

		public Criteria andCustEmailIn(List<String> values) {
			addCriterion("CUST_EMAIL in", values, "custEmail");
			return (Criteria) this;
		}

		public Criteria andCustEmailNotIn(List<String> values) {
			addCriterion("CUST_EMAIL not in", values, "custEmail");
			return (Criteria) this;
		}

		public Criteria andCustEmailBetween(String value1, String value2) {
			addCriterion("CUST_EMAIL between", value1, value2, "custEmail");
			return (Criteria) this;
		}

		public Criteria andCustEmailNotBetween(String value1, String value2) {
			addCriterion("CUST_EMAIL not between", value1, value2, "custEmail");
			return (Criteria) this;
		}

		public Criteria andCustQqIsNull() {
			addCriterion("CUST_QQ is null");
			return (Criteria) this;
		}

		public Criteria andCustQqIsNotNull() {
			addCriterion("CUST_QQ is not null");
			return (Criteria) this;
		}

		public Criteria andCustQqEqualTo(String value) {
			addCriterion("CUST_QQ =", value, "custQq");
			return (Criteria) this;
		}

		public Criteria andCustQqNotEqualTo(String value) {
			addCriterion("CUST_QQ <>", value, "custQq");
			return (Criteria) this;
		}

		public Criteria andCustQqGreaterThan(String value) {
			addCriterion("CUST_QQ >", value, "custQq");
			return (Criteria) this;
		}

		public Criteria andCustQqGreaterThanOrEqualTo(String value) {
			addCriterion("CUST_QQ >=", value, "custQq");
			return (Criteria) this;
		}

		public Criteria andCustQqLessThan(String value) {
			addCriterion("CUST_QQ <", value, "custQq");
			return (Criteria) this;
		}

		public Criteria andCustQqLessThanOrEqualTo(String value) {
			addCriterion("CUST_QQ <=", value, "custQq");
			return (Criteria) this;
		}

		public Criteria andCustQqLike(String value) {
			addCriterion("CUST_QQ like", value, "custQq");
			return (Criteria) this;
		}

		public Criteria andCustQqNotLike(String value) {
			addCriterion("CUST_QQ not like", value, "custQq");
			return (Criteria) this;
		}

		public Criteria andCustQqIn(List<String> values) {
			addCriterion("CUST_QQ in", values, "custQq");
			return (Criteria) this;
		}

		public Criteria andCustQqNotIn(List<String> values) {
			addCriterion("CUST_QQ not in", values, "custQq");
			return (Criteria) this;
		}

		public Criteria andCustQqBetween(String value1, String value2) {
			addCriterion("CUST_QQ between", value1, value2, "custQq");
			return (Criteria) this;
		}

		public Criteria andCustQqNotBetween(String value1, String value2) {
			addCriterion("CUST_QQ not between", value1, value2, "custQq");
			return (Criteria) this;
		}

		public Criteria andCustVehicleIsNull() {
			addCriterion("CUST_VEHICLE is null");
			return (Criteria) this;
		}

		public Criteria andCustVehicleIsNotNull() {
			addCriterion("CUST_VEHICLE is not null");
			return (Criteria) this;
		}

		public Criteria andCustVehicleEqualTo(String value) {
			addCriterion("CUST_VEHICLE =", value, "custVehicle");
			return (Criteria) this;
		}

		public Criteria andCustVehicleNotEqualTo(String value) {
			addCriterion("CUST_VEHICLE <>", value, "custVehicle");
			return (Criteria) this;
		}

		public Criteria andCustVehicleGreaterThan(String value) {
			addCriterion("CUST_VEHICLE >", value, "custVehicle");
			return (Criteria) this;
		}

		public Criteria andCustVehicleGreaterThanOrEqualTo(String value) {
			addCriterion("CUST_VEHICLE >=", value, "custVehicle");
			return (Criteria) this;
		}

		public Criteria andCustVehicleLessThan(String value) {
			addCriterion("CUST_VEHICLE <", value, "custVehicle");
			return (Criteria) this;
		}

		public Criteria andCustVehicleLessThanOrEqualTo(String value) {
			addCriterion("CUST_VEHICLE <=", value, "custVehicle");
			return (Criteria) this;
		}

		public Criteria andCustVehicleLike(String value) {
			addCriterion("CUST_VEHICLE like", value, "custVehicle");
			return (Criteria) this;
		}

		public Criteria andCustVehicleNotLike(String value) {
			addCriterion("CUST_VEHICLE not like", value, "custVehicle");
			return (Criteria) this;
		}

		public Criteria andCustVehicleIn(List<String> values) {
			addCriterion("CUST_VEHICLE in", values, "custVehicle");
			return (Criteria) this;
		}

		public Criteria andCustVehicleNotIn(List<String> values) {
			addCriterion("CUST_VEHICLE not in", values, "custVehicle");
			return (Criteria) this;
		}

		public Criteria andCustVehicleBetween(String value1, String value2) {
			addCriterion("CUST_VEHICLE between", value1, value2, "custVehicle");
			return (Criteria) this;
		}

		public Criteria andCustVehicleNotBetween(String value1, String value2) {
			addCriterion("CUST_VEHICLE not between", value1, value2, "custVehicle");
			return (Criteria) this;
		}

		public Criteria andCustCarTypeIsNull() {
			addCriterion("CUST_CAR_TYPE is null");
			return (Criteria) this;
		}

		public Criteria andCustCarTypeIsNotNull() {
			addCriterion("CUST_CAR_TYPE is not null");
			return (Criteria) this;
		}

		public Criteria andCustCarTypeEqualTo(String value) {
			addCriterion("CUST_CAR_TYPE =", value, "custCarType");
			return (Criteria) this;
		}

		public Criteria andCustCarTypeNotEqualTo(String value) {
			addCriterion("CUST_CAR_TYPE <>", value, "custCarType");
			return (Criteria) this;
		}

		public Criteria andCustCarTypeGreaterThan(String value) {
			addCriterion("CUST_CAR_TYPE >", value, "custCarType");
			return (Criteria) this;
		}

		public Criteria andCustCarTypeGreaterThanOrEqualTo(String value) {
			addCriterion("CUST_CAR_TYPE >=", value, "custCarType");
			return (Criteria) this;
		}

		public Criteria andCustCarTypeLessThan(String value) {
			addCriterion("CUST_CAR_TYPE <", value, "custCarType");
			return (Criteria) this;
		}

		public Criteria andCustCarTypeLessThanOrEqualTo(String value) {
			addCriterion("CUST_CAR_TYPE <=", value, "custCarType");
			return (Criteria) this;
		}

		public Criteria andCustCarTypeLike(String value) {
			addCriterion("CUST_CAR_TYPE like", value, "custCarType");
			return (Criteria) this;
		}

		public Criteria andCustCarTypeNotLike(String value) {
			addCriterion("CUST_CAR_TYPE not like", value, "custCarType");
			return (Criteria) this;
		}

		public Criteria andCustCarTypeIn(List<String> values) {
			addCriterion("CUST_CAR_TYPE in", values, "custCarType");
			return (Criteria) this;
		}

		public Criteria andCustCarTypeNotIn(List<String> values) {
			addCriterion("CUST_CAR_TYPE not in", values, "custCarType");
			return (Criteria) this;
		}

		public Criteria andCustCarTypeBetween(String value1, String value2) {
			addCriterion("CUST_CAR_TYPE between", value1, value2, "custCarType");
			return (Criteria) this;
		}

		public Criteria andCustCarTypeNotBetween(String value1, String value2) {
			addCriterion("CUST_CAR_TYPE not between", value1, value2, "custCarType");
			return (Criteria) this;
		}

		public Criteria andCustSourceIsNull() {
			addCriterion("CUST_SOURCE is null");
			return (Criteria) this;
		}

		public Criteria andCustSourceIsNotNull() {
			addCriterion("CUST_SOURCE is not null");
			return (Criteria) this;
		}

		public Criteria andCustSourceEqualTo(Byte value) {
			addCriterion("CUST_SOURCE =", value, "custSource");
			return (Criteria) this;
		}

		public Criteria andCustSourceNotEqualTo(Byte value) {
			addCriterion("CUST_SOURCE <>", value, "custSource");
			return (Criteria) this;
		}

		public Criteria andCustSourceGreaterThan(Byte value) {
			addCriterion("CUST_SOURCE >", value, "custSource");
			return (Criteria) this;
		}

		public Criteria andCustSourceGreaterThanOrEqualTo(Byte value) {
			addCriterion("CUST_SOURCE >=", value, "custSource");
			return (Criteria) this;
		}

		public Criteria andCustSourceLessThan(Byte value) {
			addCriterion("CUST_SOURCE <", value, "custSource");
			return (Criteria) this;
		}

		public Criteria andCustSourceLessThanOrEqualTo(Byte value) {
			addCriterion("CUST_SOURCE <=", value, "custSource");
			return (Criteria) this;
		}

		public Criteria andCustSourceIn(List<Byte> values) {
			addCriterion("CUST_SOURCE in", values, "custSource");
			return (Criteria) this;
		}

		public Criteria andCustSourceNotIn(List<Byte> values) {
			addCriterion("CUST_SOURCE not in", values, "custSource");
			return (Criteria) this;
		}

		public Criteria andCustSourceBetween(Byte value1, Byte value2) {
			addCriterion("CUST_SOURCE between", value1, value2, "custSource");
			return (Criteria) this;
		}

		public Criteria andCustSourceNotBetween(Byte value1, Byte value2) {
			addCriterion("CUST_SOURCE not between", value1, value2, "custSource");
			return (Criteria) this;
		}

		public Criteria andIntentProductIsNull() {
			addCriterion("INTENT_PRODUCT is null");
			return (Criteria) this;
		}

		public Criteria andIntentProductIsNotNull() {
			addCriterion("INTENT_PRODUCT is not null");
			return (Criteria) this;
		}

		public Criteria andIntentProductEqualTo(String value) {
			addCriterion("INTENT_PRODUCT =", value, "intentProduct");
			return (Criteria) this;
		}

		public Criteria andIntentProductNotEqualTo(String value) {
			addCriterion("INTENT_PRODUCT <>", value, "intentProduct");
			return (Criteria) this;
		}

		public Criteria andIntentProductGreaterThan(String value) {
			addCriterion("INTENT_PRODUCT >", value, "intentProduct");
			return (Criteria) this;
		}

		public Criteria andIntentProductGreaterThanOrEqualTo(String value) {
			addCriterion("INTENT_PRODUCT >=", value, "intentProduct");
			return (Criteria) this;
		}

		public Criteria andIntentProductLessThan(String value) {
			addCriterion("INTENT_PRODUCT <", value, "intentProduct");
			return (Criteria) this;
		}

		public Criteria andIntentProductLessThanOrEqualTo(String value) {
			addCriterion("INTENT_PRODUCT <=", value, "intentProduct");
			return (Criteria) this;
		}

		public Criteria andIntentProductLike(String value) {
			addCriterion("INTENT_PRODUCT like", value, "intentProduct");
			return (Criteria) this;
		}

		public Criteria andIntentProductNotLike(String value) {
			addCriterion("INTENT_PRODUCT not like", value, "intentProduct");
			return (Criteria) this;
		}

		public Criteria andIntentProductIn(List<String> values) {
			addCriterion("INTENT_PRODUCT in", values, "intentProduct");
			return (Criteria) this;
		}

		public Criteria andIntentProductNotIn(List<String> values) {
			addCriterion("INTENT_PRODUCT not in", values, "intentProduct");
			return (Criteria) this;
		}

		public Criteria andIntentProductBetween(String value1, String value2) {
			addCriterion("INTENT_PRODUCT between", value1, value2, "intentProduct");
			return (Criteria) this;
		}

		public Criteria andIntentProductNotBetween(String value1, String value2) {
			addCriterion("INTENT_PRODUCT not between", value1, value2, "intentProduct");
			return (Criteria) this;
		}

		public Criteria andIntentPriceLowIsNull() {
			addCriterion("INTENT_PRICE_LOW is null");
			return (Criteria) this;
		}

		public Criteria andIntentPriceLowIsNotNull() {
			addCriterion("INTENT_PRICE_LOW is not null");
			return (Criteria) this;
		}

		public Criteria andIntentPriceLowEqualTo(BigDecimal value) {
			addCriterion("INTENT_PRICE_LOW =", value, "intentPriceLow");
			return (Criteria) this;
		}

		public Criteria andIntentPriceLowNotEqualTo(BigDecimal value) {
			addCriterion("INTENT_PRICE_LOW <>", value, "intentPriceLow");
			return (Criteria) this;
		}

		public Criteria andIntentPriceLowGreaterThan(BigDecimal value) {
			addCriterion("INTENT_PRICE_LOW >", value, "intentPriceLow");
			return (Criteria) this;
		}

		public Criteria andIntentPriceLowGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("INTENT_PRICE_LOW >=", value, "intentPriceLow");
			return (Criteria) this;
		}

		public Criteria andIntentPriceLowLessThan(BigDecimal value) {
			addCriterion("INTENT_PRICE_LOW <", value, "intentPriceLow");
			return (Criteria) this;
		}

		public Criteria andIntentPriceLowLessThanOrEqualTo(BigDecimal value) {
			addCriterion("INTENT_PRICE_LOW <=", value, "intentPriceLow");
			return (Criteria) this;
		}

		public Criteria andIntentPriceLowIn(List<BigDecimal> values) {
			addCriterion("INTENT_PRICE_LOW in", values, "intentPriceLow");
			return (Criteria) this;
		}

		public Criteria andIntentPriceLowNotIn(List<BigDecimal> values) {
			addCriterion("INTENT_PRICE_LOW not in", values, "intentPriceLow");
			return (Criteria) this;
		}

		public Criteria andIntentPriceLowBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("INTENT_PRICE_LOW between", value1, value2, "intentPriceLow");
			return (Criteria) this;
		}

		public Criteria andIntentPriceLowNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("INTENT_PRICE_LOW not between", value1, value2, "intentPriceLow");
			return (Criteria) this;
		}

		public Criteria andIntentPriceHighIsNull() {
			addCriterion("INTENT_PRICE_HIGH is null");
			return (Criteria) this;
		}

		public Criteria andIntentPriceHighIsNotNull() {
			addCriterion("INTENT_PRICE_HIGH is not null");
			return (Criteria) this;
		}

		public Criteria andIntentPriceHighEqualTo(BigDecimal value) {
			addCriterion("INTENT_PRICE_HIGH =", value, "intentPriceHigh");
			return (Criteria) this;
		}

		public Criteria andIntentPriceHighNotEqualTo(BigDecimal value) {
			addCriterion("INTENT_PRICE_HIGH <>", value, "intentPriceHigh");
			return (Criteria) this;
		}

		public Criteria andIntentPriceHighGreaterThan(BigDecimal value) {
			addCriterion("INTENT_PRICE_HIGH >", value, "intentPriceHigh");
			return (Criteria) this;
		}

		public Criteria andIntentPriceHighGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("INTENT_PRICE_HIGH >=", value, "intentPriceHigh");
			return (Criteria) this;
		}

		public Criteria andIntentPriceHighLessThan(BigDecimal value) {
			addCriterion("INTENT_PRICE_HIGH <", value, "intentPriceHigh");
			return (Criteria) this;
		}

		public Criteria andIntentPriceHighLessThanOrEqualTo(BigDecimal value) {
			addCriterion("INTENT_PRICE_HIGH <=", value, "intentPriceHigh");
			return (Criteria) this;
		}

		public Criteria andIntentPriceHighIn(List<BigDecimal> values) {
			addCriterion("INTENT_PRICE_HIGH in", values, "intentPriceHigh");
			return (Criteria) this;
		}

		public Criteria andIntentPriceHighNotIn(List<BigDecimal> values) {
			addCriterion("INTENT_PRICE_HIGH not in", values, "intentPriceHigh");
			return (Criteria) this;
		}

		public Criteria andIntentPriceHighBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("INTENT_PRICE_HIGH between", value1, value2, "intentPriceHigh");
			return (Criteria) this;
		}

		public Criteria andIntentPriceHighNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("INTENT_PRICE_HIGH not between", value1, value2, "intentPriceHigh");
			return (Criteria) this;
		}

		public Criteria andCustRemarksIsNull() {
			addCriterion("CUST_REMARKS is null");
			return (Criteria) this;
		}

		public Criteria andCustRemarksIsNotNull() {
			addCriterion("CUST_REMARKS is not null");
			return (Criteria) this;
		}

		public Criteria andCustRemarksEqualTo(String value) {
			addCriterion("CUST_REMARKS =", value, "custRemarks");
			return (Criteria) this;
		}

		public Criteria andCustRemarksNotEqualTo(String value) {
			addCriterion("CUST_REMARKS <>", value, "custRemarks");
			return (Criteria) this;
		}

		public Criteria andCustRemarksGreaterThan(String value) {
			addCriterion("CUST_REMARKS >", value, "custRemarks");
			return (Criteria) this;
		}

		public Criteria andCustRemarksGreaterThanOrEqualTo(String value) {
			addCriterion("CUST_REMARKS >=", value, "custRemarks");
			return (Criteria) this;
		}

		public Criteria andCustRemarksLessThan(String value) {
			addCriterion("CUST_REMARKS <", value, "custRemarks");
			return (Criteria) this;
		}

		public Criteria andCustRemarksLessThanOrEqualTo(String value) {
			addCriterion("CUST_REMARKS <=", value, "custRemarks");
			return (Criteria) this;
		}

		public Criteria andCustRemarksLike(String value) {
			addCriterion("CUST_REMARKS like", value, "custRemarks");
			return (Criteria) this;
		}

		public Criteria andCustRemarksNotLike(String value) {
			addCriterion("CUST_REMARKS not like", value, "custRemarks");
			return (Criteria) this;
		}

		public Criteria andCustRemarksIn(List<String> values) {
			addCriterion("CUST_REMARKS in", values, "custRemarks");
			return (Criteria) this;
		}

		public Criteria andCustRemarksNotIn(List<String> values) {
			addCriterion("CUST_REMARKS not in", values, "custRemarks");
			return (Criteria) this;
		}

		public Criteria andCustRemarksBetween(String value1, String value2) {
			addCriterion("CUST_REMARKS between", value1, value2, "custRemarks");
			return (Criteria) this;
		}

		public Criteria andCustRemarksNotBetween(String value1, String value2) {
			addCriterion("CUST_REMARKS not between", value1, value2, "custRemarks");
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

		public Criteria andBuildNameIsNull() {
			addCriterion("BUILD_NAME is null");
			return (Criteria) this;
		}

		public Criteria andBuildNameIsNotNull() {
			addCriterion("BUILD_NAME is not null");
			return (Criteria) this;
		}

		public Criteria andBuildNameEqualTo(String value) {
			addCriterion("BUILD_NAME =", value, "buildName");
			return (Criteria) this;
		}

		public Criteria andBuildNameNotEqualTo(String value) {
			addCriterion("BUILD_NAME <>", value, "buildName");
			return (Criteria) this;
		}

		public Criteria andBuildNameGreaterThan(String value) {
			addCriterion("BUILD_NAME >", value, "buildName");
			return (Criteria) this;
		}

		public Criteria andBuildNameGreaterThanOrEqualTo(String value) {
			addCriterion("BUILD_NAME >=", value, "buildName");
			return (Criteria) this;
		}

		public Criteria andBuildNameLessThan(String value) {
			addCriterion("BUILD_NAME <", value, "buildName");
			return (Criteria) this;
		}

		public Criteria andBuildNameLessThanOrEqualTo(String value) {
			addCriterion("BUILD_NAME <=", value, "buildName");
			return (Criteria) this;
		}

		public Criteria andBuildNameLike(String value) {
			addCriterion("BUILD_NAME like", value, "buildName");
			return (Criteria) this;
		}

		public Criteria andBuildNameNotLike(String value) {
			addCriterion("BUILD_NAME not like", value, "buildName");
			return (Criteria) this;
		}

		public Criteria andBuildNameIn(List<String> values) {
			addCriterion("BUILD_NAME in", values, "buildName");
			return (Criteria) this;
		}

		public Criteria andBuildNameNotIn(List<String> values) {
			addCriterion("BUILD_NAME not in", values, "buildName");
			return (Criteria) this;
		}

		public Criteria andBuildNameBetween(String value1, String value2) {
			addCriterion("BUILD_NAME between", value1, value2, "buildName");
			return (Criteria) this;
		}

		public Criteria andBuildNameNotBetween(String value1, String value2) {
			addCriterion("BUILD_NAME not between", value1, value2, "buildName");
			return (Criteria) this;
		}

		public Criteria andHouseRegIsNull() {
			addCriterion("HOUSE_REG is null");
			return (Criteria) this;
		}

		public Criteria andHouseRegIsNotNull() {
			addCriterion("HOUSE_REG is not null");
			return (Criteria) this;
		}

		public Criteria andHouseRegEqualTo(Integer value) {
			addCriterion("HOUSE_REG =", value, "houseReg");
			return (Criteria) this;
		}

		public Criteria andHouseRegNotEqualTo(Integer value) {
			addCriterion("HOUSE_REG <>", value, "houseReg");
			return (Criteria) this;
		}

		public Criteria andHouseRegGreaterThan(Integer value) {
			addCriterion("HOUSE_REG >", value, "houseReg");
			return (Criteria) this;
		}

		public Criteria andHouseRegGreaterThanOrEqualTo(Integer value) {
			addCriterion("HOUSE_REG >=", value, "houseReg");
			return (Criteria) this;
		}

		public Criteria andHouseRegLessThan(Integer value) {
			addCriterion("HOUSE_REG <", value, "houseReg");
			return (Criteria) this;
		}

		public Criteria andHouseRegLessThanOrEqualTo(Integer value) {
			addCriterion("HOUSE_REG <=", value, "houseReg");
			return (Criteria) this;
		}

		public Criteria andHouseRegIn(List<Integer> values) {
			addCriterion("HOUSE_REG in", values, "houseReg");
			return (Criteria) this;
		}

		public Criteria andHouseRegNotIn(List<Integer> values) {
			addCriterion("HOUSE_REG not in", values, "houseReg");
			return (Criteria) this;
		}

		public Criteria andHouseRegBetween(Integer value1, Integer value2) {
			addCriterion("HOUSE_REG between", value1, value2, "houseReg");
			return (Criteria) this;
		}

		public Criteria andHouseRegNotBetween(Integer value1, Integer value2) {
			addCriterion("HOUSE_REG not between", value1, value2, "houseReg");
			return (Criteria) this;
		}

		public Criteria andRegionNameIsNull() {
			addCriterion("REGION_NAME is null");
			return (Criteria) this;
		}

		public Criteria andRegionNameIsNotNull() {
			addCriterion("REGION_NAME is not null");
			return (Criteria) this;
		}

		public Criteria andRegionNameEqualTo(String value) {
			addCriterion("REGION_NAME =", value, "regionName");
			return (Criteria) this;
		}

		public Criteria andRegionNameNotEqualTo(String value) {
			addCriterion("REGION_NAME <>", value, "regionName");
			return (Criteria) this;
		}

		public Criteria andRegionNameGreaterThan(String value) {
			addCriterion("REGION_NAME >", value, "regionName");
			return (Criteria) this;
		}

		public Criteria andRegionNameGreaterThanOrEqualTo(String value) {
			addCriterion("REGION_NAME >=", value, "regionName");
			return (Criteria) this;
		}

		public Criteria andRegionNameLessThan(String value) {
			addCriterion("REGION_NAME <", value, "regionName");
			return (Criteria) this;
		}

		public Criteria andRegionNameLessThanOrEqualTo(String value) {
			addCriterion("REGION_NAME <=", value, "regionName");
			return (Criteria) this;
		}

		public Criteria andRegionNameLike(String value) {
			addCriterion("REGION_NAME like", value, "regionName");
			return (Criteria) this;
		}

		public Criteria andRegionNameNotLike(String value) {
			addCriterion("REGION_NAME not like", value, "regionName");
			return (Criteria) this;
		}

		public Criteria andRegionNameIn(List<String> values) {
			addCriterion("REGION_NAME in", values, "regionName");
			return (Criteria) this;
		}

		public Criteria andRegionNameNotIn(List<String> values) {
			addCriterion("REGION_NAME not in", values, "regionName");
			return (Criteria) this;
		}

		public Criteria andRegionNameBetween(String value1, String value2) {
			addCriterion("REGION_NAME between", value1, value2, "regionName");
			return (Criteria) this;
		}

		public Criteria andRegionNameNotBetween(String value1, String value2) {
			addCriterion("REGION_NAME not between", value1, value2, "regionName");
			return (Criteria) this;
		}

		public Criteria andSectionIdIsNull() {
			addCriterion("SECTION_ID is null");
			return (Criteria) this;
		}

		public Criteria andSectionIdIsNotNull() {
			addCriterion("SECTION_ID is not null");
			return (Criteria) this;
		}

		public Criteria andSectionIdEqualTo(Integer value) {
			addCriterion("SECTION_ID =", value, "sectionId");
			return (Criteria) this;
		}

		public Criteria andSectionIdNotEqualTo(Integer value) {
			addCriterion("SECTION_ID <>", value, "sectionId");
			return (Criteria) this;
		}

		public Criteria andSectionIdGreaterThan(Integer value) {
			addCriterion("SECTION_ID >", value, "sectionId");
			return (Criteria) this;
		}

		public Criteria andSectionIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("SECTION_ID >=", value, "sectionId");
			return (Criteria) this;
		}

		public Criteria andSectionIdLessThan(Integer value) {
			addCriterion("SECTION_ID <", value, "sectionId");
			return (Criteria) this;
		}

		public Criteria andSectionIdLessThanOrEqualTo(Integer value) {
			addCriterion("SECTION_ID <=", value, "sectionId");
			return (Criteria) this;
		}

		public Criteria andSectionIdIn(List<Integer> values) {
			addCriterion("SECTION_ID in", values, "sectionId");
			return (Criteria) this;
		}

		public Criteria andSectionIdNotIn(List<Integer> values) {
			addCriterion("SECTION_ID not in", values, "sectionId");
			return (Criteria) this;
		}

		public Criteria andSectionIdBetween(Integer value1, Integer value2) {
			addCriterion("SECTION_ID between", value1, value2, "sectionId");
			return (Criteria) this;
		}

		public Criteria andSectionIdNotBetween(Integer value1, Integer value2) {
			addCriterion("SECTION_ID not between", value1, value2, "sectionId");
			return (Criteria) this;
		}

		public Criteria andSectionNameIsNull() {
			addCriterion("SECTION_NAME is null");
			return (Criteria) this;
		}

		public Criteria andSectionNameIsNotNull() {
			addCriterion("SECTION_NAME is not null");
			return (Criteria) this;
		}

		public Criteria andSectionNameEqualTo(String value) {
			addCriterion("SECTION_NAME =", value, "sectionName");
			return (Criteria) this;
		}

		public Criteria andSectionNameNotEqualTo(String value) {
			addCriterion("SECTION_NAME <>", value, "sectionName");
			return (Criteria) this;
		}

		public Criteria andSectionNameGreaterThan(String value) {
			addCriterion("SECTION_NAME >", value, "sectionName");
			return (Criteria) this;
		}

		public Criteria andSectionNameGreaterThanOrEqualTo(String value) {
			addCriterion("SECTION_NAME >=", value, "sectionName");
			return (Criteria) this;
		}

		public Criteria andSectionNameLessThan(String value) {
			addCriterion("SECTION_NAME <", value, "sectionName");
			return (Criteria) this;
		}

		public Criteria andSectionNameLessThanOrEqualTo(String value) {
			addCriterion("SECTION_NAME <=", value, "sectionName");
			return (Criteria) this;
		}

		public Criteria andSectionNameLike(String value) {
			addCriterion("SECTION_NAME like", value, "sectionName");
			return (Criteria) this;
		}

		public Criteria andSectionNameNotLike(String value) {
			addCriterion("SECTION_NAME not like", value, "sectionName");
			return (Criteria) this;
		}

		public Criteria andSectionNameIn(List<String> values) {
			addCriterion("SECTION_NAME in", values, "sectionName");
			return (Criteria) this;
		}

		public Criteria andSectionNameNotIn(List<String> values) {
			addCriterion("SECTION_NAME not in", values, "sectionName");
			return (Criteria) this;
		}

		public Criteria andSectionNameBetween(String value1, String value2) {
			addCriterion("SECTION_NAME between", value1, value2, "sectionName");
			return (Criteria) this;
		}

		public Criteria andSectionNameNotBetween(String value1, String value2) {
			addCriterion("SECTION_NAME not between", value1, value2, "sectionName");
			return (Criteria) this;
		}

		public Criteria andHouseRoundIsNull() {
			addCriterion("HOUSE_ROUND is null");
			return (Criteria) this;
		}

		public Criteria andHouseRoundIsNotNull() {
			addCriterion("HOUSE_ROUND is not null");
			return (Criteria) this;
		}

		public Criteria andHouseRoundEqualTo(Byte value) {
			addCriterion("HOUSE_ROUND =", value, "houseRound");
			return (Criteria) this;
		}

		public Criteria andHouseRoundNotEqualTo(Byte value) {
			addCriterion("HOUSE_ROUND <>", value, "houseRound");
			return (Criteria) this;
		}

		public Criteria andHouseRoundGreaterThan(Byte value) {
			addCriterion("HOUSE_ROUND >", value, "houseRound");
			return (Criteria) this;
		}

		public Criteria andHouseRoundGreaterThanOrEqualTo(Byte value) {
			addCriterion("HOUSE_ROUND >=", value, "houseRound");
			return (Criteria) this;
		}

		public Criteria andHouseRoundLessThan(Byte value) {
			addCriterion("HOUSE_ROUND <", value, "houseRound");
			return (Criteria) this;
		}

		public Criteria andHouseRoundLessThanOrEqualTo(Byte value) {
			addCriterion("HOUSE_ROUND <=", value, "houseRound");
			return (Criteria) this;
		}

		public Criteria andHouseRoundIn(List<Byte> values) {
			addCriterion("HOUSE_ROUND in", values, "houseRound");
			return (Criteria) this;
		}

		public Criteria andHouseRoundNotIn(List<Byte> values) {
			addCriterion("HOUSE_ROUND not in", values, "houseRound");
			return (Criteria) this;
		}

		public Criteria andHouseRoundBetween(Byte value1, Byte value2) {
			addCriterion("HOUSE_ROUND between", value1, value2, "houseRound");
			return (Criteria) this;
		}

		public Criteria andHouseRoundNotBetween(Byte value1, Byte value2) {
			addCriterion("HOUSE_ROUND not between", value1, value2, "houseRound");
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

		public Criteria andHouseUseageEqualTo(Byte value) {
			addCriterion("HOUSE_USEAGE =", value, "houseUseage");
			return (Criteria) this;
		}

		public Criteria andHouseUseageNotEqualTo(Byte value) {
			addCriterion("HOUSE_USEAGE <>", value, "houseUseage");
			return (Criteria) this;
		}

		public Criteria andHouseUseageGreaterThan(Byte value) {
			addCriterion("HOUSE_USEAGE >", value, "houseUseage");
			return (Criteria) this;
		}

		public Criteria andHouseUseageGreaterThanOrEqualTo(Byte value) {
			addCriterion("HOUSE_USEAGE >=", value, "houseUseage");
			return (Criteria) this;
		}

		public Criteria andHouseUseageLessThan(Byte value) {
			addCriterion("HOUSE_USEAGE <", value, "houseUseage");
			return (Criteria) this;
		}

		public Criteria andHouseUseageLessThanOrEqualTo(Byte value) {
			addCriterion("HOUSE_USEAGE <=", value, "houseUseage");
			return (Criteria) this;
		}

		public Criteria andHouseUseageIn(List<Byte> values) {
			addCriterion("HOUSE_USEAGE in", values, "houseUseage");
			return (Criteria) this;
		}

		public Criteria andHouseUseageNotIn(List<Byte> values) {
			addCriterion("HOUSE_USEAGE not in", values, "houseUseage");
			return (Criteria) this;
		}

		public Criteria andHouseUseageBetween(Byte value1, Byte value2) {
			addCriterion("HOUSE_USEAGE between", value1, value2, "houseUseage");
			return (Criteria) this;
		}

		public Criteria andHouseUseageNotBetween(Byte value1, Byte value2) {
			addCriterion("HOUSE_USEAGE not between", value1, value2, "houseUseage");
			return (Criteria) this;
		}

		public Criteria andHouseRoofIsNull() {
			addCriterion("HOUSE_ROOF is null");
			return (Criteria) this;
		}

		public Criteria andHouseRoofIsNotNull() {
			addCriterion("HOUSE_ROOF is not null");
			return (Criteria) this;
		}

		public Criteria andHouseRoofEqualTo(String value) {
			addCriterion("HOUSE_ROOF =", value, "houseRoof");
			return (Criteria) this;
		}

		public Criteria andHouseRoofNotEqualTo(String value) {
			addCriterion("HOUSE_ROOF <>", value, "houseRoof");
			return (Criteria) this;
		}

		public Criteria andHouseRoofGreaterThan(String value) {
			addCriterion("HOUSE_ROOF >", value, "houseRoof");
			return (Criteria) this;
		}

		public Criteria andHouseRoofGreaterThanOrEqualTo(String value) {
			addCriterion("HOUSE_ROOF >=", value, "houseRoof");
			return (Criteria) this;
		}

		public Criteria andHouseRoofLessThan(String value) {
			addCriterion("HOUSE_ROOF <", value, "houseRoof");
			return (Criteria) this;
		}

		public Criteria andHouseRoofLessThanOrEqualTo(String value) {
			addCriterion("HOUSE_ROOF <=", value, "houseRoof");
			return (Criteria) this;
		}

		public Criteria andHouseRoofLike(String value) {
			addCriterion("HOUSE_ROOF like", value, "houseRoof");
			return (Criteria) this;
		}

		public Criteria andHouseRoofNotLike(String value) {
			addCriterion("HOUSE_ROOF not like", value, "houseRoof");
			return (Criteria) this;
		}

		public Criteria andHouseRoofIn(List<String> values) {
			addCriterion("HOUSE_ROOF in", values, "houseRoof");
			return (Criteria) this;
		}

		public Criteria andHouseRoofNotIn(List<String> values) {
			addCriterion("HOUSE_ROOF not in", values, "houseRoof");
			return (Criteria) this;
		}

		public Criteria andHouseRoofBetween(String value1, String value2) {
			addCriterion("HOUSE_ROOF between", value1, value2, "houseRoof");
			return (Criteria) this;
		}

		public Criteria andHouseRoofNotBetween(String value1, String value2) {
			addCriterion("HOUSE_ROOF not between", value1, value2, "houseRoof");
			return (Criteria) this;
		}

		public Criteria andHouseUnitIsNull() {
			addCriterion("HOUSE_UNIT is null");
			return (Criteria) this;
		}

		public Criteria andHouseUnitIsNotNull() {
			addCriterion("HOUSE_UNIT is not null");
			return (Criteria) this;
		}

		public Criteria andHouseUnitEqualTo(String value) {
			addCriterion("HOUSE_UNIT =", value, "houseUnit");
			return (Criteria) this;
		}

		public Criteria andHouseUnitNotEqualTo(String value) {
			addCriterion("HOUSE_UNIT <>", value, "houseUnit");
			return (Criteria) this;
		}

		public Criteria andHouseUnitGreaterThan(String value) {
			addCriterion("HOUSE_UNIT >", value, "houseUnit");
			return (Criteria) this;
		}

		public Criteria andHouseUnitGreaterThanOrEqualTo(String value) {
			addCriterion("HOUSE_UNIT >=", value, "houseUnit");
			return (Criteria) this;
		}

		public Criteria andHouseUnitLessThan(String value) {
			addCriterion("HOUSE_UNIT <", value, "houseUnit");
			return (Criteria) this;
		}

		public Criteria andHouseUnitLessThanOrEqualTo(String value) {
			addCriterion("HOUSE_UNIT <=", value, "houseUnit");
			return (Criteria) this;
		}

		public Criteria andHouseUnitLike(String value) {
			addCriterion("HOUSE_UNIT like", value, "houseUnit");
			return (Criteria) this;
		}

		public Criteria andHouseUnitNotLike(String value) {
			addCriterion("HOUSE_UNIT not like", value, "houseUnit");
			return (Criteria) this;
		}

		public Criteria andHouseUnitIn(List<String> values) {
			addCriterion("HOUSE_UNIT in", values, "houseUnit");
			return (Criteria) this;
		}

		public Criteria andHouseUnitNotIn(List<String> values) {
			addCriterion("HOUSE_UNIT not in", values, "houseUnit");
			return (Criteria) this;
		}

		public Criteria andHouseUnitBetween(String value1, String value2) {
			addCriterion("HOUSE_UNIT between", value1, value2, "houseUnit");
			return (Criteria) this;
		}

		public Criteria andHouseUnitNotBetween(String value1, String value2) {
			addCriterion("HOUSE_UNIT not between", value1, value2, "houseUnit");
			return (Criteria) this;
		}

		public Criteria andHouseFloorIsNull() {
			addCriterion("HOUSE_FLOOR is null");
			return (Criteria) this;
		}

		public Criteria andHouseFloorIsNotNull() {
			addCriterion("HOUSE_FLOOR is not null");
			return (Criteria) this;
		}

		public Criteria andHouseFloorEqualTo(String value) {
			addCriterion("HOUSE_FLOOR =", value, "houseFloor");
			return (Criteria) this;
		}

		public Criteria andHouseFloorNotEqualTo(String value) {
			addCriterion("HOUSE_FLOOR <>", value, "houseFloor");
			return (Criteria) this;
		}

		public Criteria andHouseFloorGreaterThan(String value) {
			addCriterion("HOUSE_FLOOR >", value, "houseFloor");
			return (Criteria) this;
		}

		public Criteria andHouseFloorGreaterThanOrEqualTo(String value) {
			addCriterion("HOUSE_FLOOR >=", value, "houseFloor");
			return (Criteria) this;
		}

		public Criteria andHouseFloorLessThan(String value) {
			addCriterion("HOUSE_FLOOR <", value, "houseFloor");
			return (Criteria) this;
		}

		public Criteria andHouseFloorLessThanOrEqualTo(String value) {
			addCriterion("HOUSE_FLOOR <=", value, "houseFloor");
			return (Criteria) this;
		}

		public Criteria andHouseFloorLike(String value) {
			addCriterion("HOUSE_FLOOR like", value, "houseFloor");
			return (Criteria) this;
		}

		public Criteria andHouseFloorNotLike(String value) {
			addCriterion("HOUSE_FLOOR not like", value, "houseFloor");
			return (Criteria) this;
		}

		public Criteria andHouseFloorIn(List<String> values) {
			addCriterion("HOUSE_FLOOR in", values, "houseFloor");
			return (Criteria) this;
		}

		public Criteria andHouseFloorNotIn(List<String> values) {
			addCriterion("HOUSE_FLOOR not in", values, "houseFloor");
			return (Criteria) this;
		}

		public Criteria andHouseFloorBetween(String value1, String value2) {
			addCriterion("HOUSE_FLOOR between", value1, value2, "houseFloor");
			return (Criteria) this;
		}

		public Criteria andHouseFloorNotBetween(String value1, String value2) {
			addCriterion("HOUSE_FLOOR not between", value1, value2, "houseFloor");
			return (Criteria) this;
		}

		public Criteria andHouseNumIsNull() {
			addCriterion("HOUSE_NUM is null");
			return (Criteria) this;
		}

		public Criteria andHouseNumIsNotNull() {
			addCriterion("HOUSE_NUM is not null");
			return (Criteria) this;
		}

		public Criteria andHouseNumEqualTo(String value) {
			addCriterion("HOUSE_NUM =", value, "houseNum");
			return (Criteria) this;
		}

		public Criteria andHouseNumNotEqualTo(String value) {
			addCriterion("HOUSE_NUM <>", value, "houseNum");
			return (Criteria) this;
		}

		public Criteria andHouseNumGreaterThan(String value) {
			addCriterion("HOUSE_NUM >", value, "houseNum");
			return (Criteria) this;
		}

		public Criteria andHouseNumGreaterThanOrEqualTo(String value) {
			addCriterion("HOUSE_NUM >=", value, "houseNum");
			return (Criteria) this;
		}

		public Criteria andHouseNumLessThan(String value) {
			addCriterion("HOUSE_NUM <", value, "houseNum");
			return (Criteria) this;
		}

		public Criteria andHouseNumLessThanOrEqualTo(String value) {
			addCriterion("HOUSE_NUM <=", value, "houseNum");
			return (Criteria) this;
		}

		public Criteria andHouseNumLike(String value) {
			addCriterion("HOUSE_NUM like", value, "houseNum");
			return (Criteria) this;
		}

		public Criteria andHouseNumNotLike(String value) {
			addCriterion("HOUSE_NUM not like", value, "houseNum");
			return (Criteria) this;
		}

		public Criteria andHouseNumIn(List<String> values) {
			addCriterion("HOUSE_NUM in", values, "houseNum");
			return (Criteria) this;
		}

		public Criteria andHouseNumNotIn(List<String> values) {
			addCriterion("HOUSE_NUM not in", values, "houseNum");
			return (Criteria) this;
		}

		public Criteria andHouseNumBetween(String value1, String value2) {
			addCriterion("HOUSE_NUM between", value1, value2, "houseNum");
			return (Criteria) this;
		}

		public Criteria andHouseNumNotBetween(String value1, String value2) {
			addCriterion("HOUSE_NUM not between", value1, value2, "houseNum");
			return (Criteria) this;
		}

		public Criteria andHouseTypeIsNull() {
			addCriterion("HOUSE_TYPE is null");
			return (Criteria) this;
		}

		public Criteria andHouseTypeIsNotNull() {
			addCriterion("HOUSE_TYPE is not null");
			return (Criteria) this;
		}

		public Criteria andHouseTypeEqualTo(Byte value) {
			addCriterion("HOUSE_TYPE =", value, "houseType");
			return (Criteria) this;
		}

		public Criteria andHouseTypeNotEqualTo(Byte value) {
			addCriterion("HOUSE_TYPE <>", value, "houseType");
			return (Criteria) this;
		}

		public Criteria andHouseTypeGreaterThan(Byte value) {
			addCriterion("HOUSE_TYPE >", value, "houseType");
			return (Criteria) this;
		}

		public Criteria andHouseTypeGreaterThanOrEqualTo(Byte value) {
			addCriterion("HOUSE_TYPE >=", value, "houseType");
			return (Criteria) this;
		}

		public Criteria andHouseTypeLessThan(Byte value) {
			addCriterion("HOUSE_TYPE <", value, "houseType");
			return (Criteria) this;
		}

		public Criteria andHouseTypeLessThanOrEqualTo(Byte value) {
			addCriterion("HOUSE_TYPE <=", value, "houseType");
			return (Criteria) this;
		}

		public Criteria andHouseTypeIn(List<Byte> values) {
			addCriterion("HOUSE_TYPE in", values, "houseType");
			return (Criteria) this;
		}

		public Criteria andHouseTypeNotIn(List<Byte> values) {
			addCriterion("HOUSE_TYPE not in", values, "houseType");
			return (Criteria) this;
		}

		public Criteria andHouseTypeBetween(Byte value1, Byte value2) {
			addCriterion("HOUSE_TYPE between", value1, value2, "houseType");
			return (Criteria) this;
		}

		public Criteria andHouseTypeNotBetween(Byte value1, Byte value2) {
			addCriterion("HOUSE_TYPE not between", value1, value2, "houseType");
			return (Criteria) this;
		}

		public Criteria andHouseRoomIsNull() {
			addCriterion("HOUSE_ROOM is null");
			return (Criteria) this;
		}

		public Criteria andHouseRoomIsNotNull() {
			addCriterion("HOUSE_ROOM is not null");
			return (Criteria) this;
		}

		public Criteria andHouseRoomEqualTo(Byte value) {
			addCriterion("HOUSE_ROOM =", value, "houseRoom");
			return (Criteria) this;
		}

		public Criteria andHouseRoomNotEqualTo(Byte value) {
			addCriterion("HOUSE_ROOM <>", value, "houseRoom");
			return (Criteria) this;
		}

		public Criteria andHouseRoomGreaterThan(Byte value) {
			addCriterion("HOUSE_ROOM >", value, "houseRoom");
			return (Criteria) this;
		}

		public Criteria andHouseRoomGreaterThanOrEqualTo(Byte value) {
			addCriterion("HOUSE_ROOM >=", value, "houseRoom");
			return (Criteria) this;
		}

		public Criteria andHouseRoomLessThan(Byte value) {
			addCriterion("HOUSE_ROOM <", value, "houseRoom");
			return (Criteria) this;
		}

		public Criteria andHouseRoomLessThanOrEqualTo(Byte value) {
			addCriterion("HOUSE_ROOM <=", value, "houseRoom");
			return (Criteria) this;
		}

		public Criteria andHouseRoomIn(List<Byte> values) {
			addCriterion("HOUSE_ROOM in", values, "houseRoom");
			return (Criteria) this;
		}

		public Criteria andHouseRoomNotIn(List<Byte> values) {
			addCriterion("HOUSE_ROOM not in", values, "houseRoom");
			return (Criteria) this;
		}

		public Criteria andHouseRoomBetween(Byte value1, Byte value2) {
			addCriterion("HOUSE_ROOM between", value1, value2, "houseRoom");
			return (Criteria) this;
		}

		public Criteria andHouseRoomNotBetween(Byte value1, Byte value2) {
			addCriterion("HOUSE_ROOM not between", value1, value2, "houseRoom");
			return (Criteria) this;
		}

		public Criteria andHouseHallIsNull() {
			addCriterion("HOUSE_HALL is null");
			return (Criteria) this;
		}

		public Criteria andHouseHallIsNotNull() {
			addCriterion("HOUSE_HALL is not null");
			return (Criteria) this;
		}

		public Criteria andHouseHallEqualTo(Byte value) {
			addCriterion("HOUSE_HALL =", value, "houseHall");
			return (Criteria) this;
		}

		public Criteria andHouseHallNotEqualTo(Byte value) {
			addCriterion("HOUSE_HALL <>", value, "houseHall");
			return (Criteria) this;
		}

		public Criteria andHouseHallGreaterThan(Byte value) {
			addCriterion("HOUSE_HALL >", value, "houseHall");
			return (Criteria) this;
		}

		public Criteria andHouseHallGreaterThanOrEqualTo(Byte value) {
			addCriterion("HOUSE_HALL >=", value, "houseHall");
			return (Criteria) this;
		}

		public Criteria andHouseHallLessThan(Byte value) {
			addCriterion("HOUSE_HALL <", value, "houseHall");
			return (Criteria) this;
		}

		public Criteria andHouseHallLessThanOrEqualTo(Byte value) {
			addCriterion("HOUSE_HALL <=", value, "houseHall");
			return (Criteria) this;
		}

		public Criteria andHouseHallIn(List<Byte> values) {
			addCriterion("HOUSE_HALL in", values, "houseHall");
			return (Criteria) this;
		}

		public Criteria andHouseHallNotIn(List<Byte> values) {
			addCriterion("HOUSE_HALL not in", values, "houseHall");
			return (Criteria) this;
		}

		public Criteria andHouseHallBetween(Byte value1, Byte value2) {
			addCriterion("HOUSE_HALL between", value1, value2, "houseHall");
			return (Criteria) this;
		}

		public Criteria andHouseHallNotBetween(Byte value1, Byte value2) {
			addCriterion("HOUSE_HALL not between", value1, value2, "houseHall");
			return (Criteria) this;
		}

		public Criteria andHouseWeiIsNull() {
			addCriterion("HOUSE_WEI is null");
			return (Criteria) this;
		}

		public Criteria andHouseWeiIsNotNull() {
			addCriterion("HOUSE_WEI is not null");
			return (Criteria) this;
		}

		public Criteria andHouseWeiEqualTo(Byte value) {
			addCriterion("HOUSE_WEI =", value, "houseWei");
			return (Criteria) this;
		}

		public Criteria andHouseWeiNotEqualTo(Byte value) {
			addCriterion("HOUSE_WEI <>", value, "houseWei");
			return (Criteria) this;
		}

		public Criteria andHouseWeiGreaterThan(Byte value) {
			addCriterion("HOUSE_WEI >", value, "houseWei");
			return (Criteria) this;
		}

		public Criteria andHouseWeiGreaterThanOrEqualTo(Byte value) {
			addCriterion("HOUSE_WEI >=", value, "houseWei");
			return (Criteria) this;
		}

		public Criteria andHouseWeiLessThan(Byte value) {
			addCriterion("HOUSE_WEI <", value, "houseWei");
			return (Criteria) this;
		}

		public Criteria andHouseWeiLessThanOrEqualTo(Byte value) {
			addCriterion("HOUSE_WEI <=", value, "houseWei");
			return (Criteria) this;
		}

		public Criteria andHouseWeiIn(List<Byte> values) {
			addCriterion("HOUSE_WEI in", values, "houseWei");
			return (Criteria) this;
		}

		public Criteria andHouseWeiNotIn(List<Byte> values) {
			addCriterion("HOUSE_WEI not in", values, "houseWei");
			return (Criteria) this;
		}

		public Criteria andHouseWeiBetween(Byte value1, Byte value2) {
			addCriterion("HOUSE_WEI between", value1, value2, "houseWei");
			return (Criteria) this;
		}

		public Criteria andHouseWeiNotBetween(Byte value1, Byte value2) {
			addCriterion("HOUSE_WEI not between", value1, value2, "houseWei");
			return (Criteria) this;
		}

		public Criteria andHouseYangIsNull() {
			addCriterion("HOUSE_YANG is null");
			return (Criteria) this;
		}

		public Criteria andHouseYangIsNotNull() {
			addCriterion("HOUSE_YANG is not null");
			return (Criteria) this;
		}

		public Criteria andHouseYangEqualTo(Byte value) {
			addCriterion("HOUSE_YANG =", value, "houseYang");
			return (Criteria) this;
		}

		public Criteria andHouseYangNotEqualTo(Byte value) {
			addCriterion("HOUSE_YANG <>", value, "houseYang");
			return (Criteria) this;
		}

		public Criteria andHouseYangGreaterThan(Byte value) {
			addCriterion("HOUSE_YANG >", value, "houseYang");
			return (Criteria) this;
		}

		public Criteria andHouseYangGreaterThanOrEqualTo(Byte value) {
			addCriterion("HOUSE_YANG >=", value, "houseYang");
			return (Criteria) this;
		}

		public Criteria andHouseYangLessThan(Byte value) {
			addCriterion("HOUSE_YANG <", value, "houseYang");
			return (Criteria) this;
		}

		public Criteria andHouseYangLessThanOrEqualTo(Byte value) {
			addCriterion("HOUSE_YANG <=", value, "houseYang");
			return (Criteria) this;
		}

		public Criteria andHouseYangIn(List<Byte> values) {
			addCriterion("HOUSE_YANG in", values, "houseYang");
			return (Criteria) this;
		}

		public Criteria andHouseYangNotIn(List<Byte> values) {
			addCriterion("HOUSE_YANG not in", values, "houseYang");
			return (Criteria) this;
		}

		public Criteria andHouseYangBetween(Byte value1, Byte value2) {
			addCriterion("HOUSE_YANG between", value1, value2, "houseYang");
			return (Criteria) this;
		}

		public Criteria andHouseYangNotBetween(Byte value1, Byte value2) {
			addCriterion("HOUSE_YANG not between", value1, value2, "houseYang");
			return (Criteria) this;
		}

		public Criteria andHouseAreaIsNull() {
			addCriterion("HOUSE_AREA is null");
			return (Criteria) this;
		}

		public Criteria andHouseAreaIsNotNull() {
			addCriterion("HOUSE_AREA is not null");
			return (Criteria) this;
		}

		public Criteria andHouseAreaEqualTo(BigDecimal value) {
			addCriterion("HOUSE_AREA =", value, "houseArea");
			return (Criteria) this;
		}

		public Criteria andHouseAreaNotEqualTo(BigDecimal value) {
			addCriterion("HOUSE_AREA <>", value, "houseArea");
			return (Criteria) this;
		}

		public Criteria andHouseAreaGreaterThan(BigDecimal value) {
			addCriterion("HOUSE_AREA >", value, "houseArea");
			return (Criteria) this;
		}

		public Criteria andHouseAreaGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("HOUSE_AREA >=", value, "houseArea");
			return (Criteria) this;
		}

		public Criteria andHouseAreaLessThan(BigDecimal value) {
			addCriterion("HOUSE_AREA <", value, "houseArea");
			return (Criteria) this;
		}

		public Criteria andHouseAreaLessThanOrEqualTo(BigDecimal value) {
			addCriterion("HOUSE_AREA <=", value, "houseArea");
			return (Criteria) this;
		}

		public Criteria andHouseAreaIn(List<BigDecimal> values) {
			addCriterion("HOUSE_AREA in", values, "houseArea");
			return (Criteria) this;
		}

		public Criteria andHouseAreaNotIn(List<BigDecimal> values) {
			addCriterion("HOUSE_AREA not in", values, "houseArea");
			return (Criteria) this;
		}

		public Criteria andHouseAreaBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("HOUSE_AREA between", value1, value2, "houseArea");
			return (Criteria) this;
		}

		public Criteria andHouseAreaNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("HOUSE_AREA not between", value1, value2, "houseArea");
			return (Criteria) this;
		}

		public Criteria andHouseInnerareaIsNull() {
			addCriterion("HOUSE_INNERAREA is null");
			return (Criteria) this;
		}

		public Criteria andHouseInnerareaIsNotNull() {
			addCriterion("HOUSE_INNERAREA is not null");
			return (Criteria) this;
		}

		public Criteria andHouseInnerareaEqualTo(BigDecimal value) {
			addCriterion("HOUSE_INNERAREA =", value, "houseInnerarea");
			return (Criteria) this;
		}

		public Criteria andHouseInnerareaNotEqualTo(BigDecimal value) {
			addCriterion("HOUSE_INNERAREA <>", value, "houseInnerarea");
			return (Criteria) this;
		}

		public Criteria andHouseInnerareaGreaterThan(BigDecimal value) {
			addCriterion("HOUSE_INNERAREA >", value, "houseInnerarea");
			return (Criteria) this;
		}

		public Criteria andHouseInnerareaGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("HOUSE_INNERAREA >=", value, "houseInnerarea");
			return (Criteria) this;
		}

		public Criteria andHouseInnerareaLessThan(BigDecimal value) {
			addCriterion("HOUSE_INNERAREA <", value, "houseInnerarea");
			return (Criteria) this;
		}

		public Criteria andHouseInnerareaLessThanOrEqualTo(BigDecimal value) {
			addCriterion("HOUSE_INNERAREA <=", value, "houseInnerarea");
			return (Criteria) this;
		}

		public Criteria andHouseInnerareaIn(List<BigDecimal> values) {
			addCriterion("HOUSE_INNERAREA in", values, "houseInnerarea");
			return (Criteria) this;
		}

		public Criteria andHouseInnerareaNotIn(List<BigDecimal> values) {
			addCriterion("HOUSE_INNERAREA not in", values, "houseInnerarea");
			return (Criteria) this;
		}

		public Criteria andHouseInnerareaBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("HOUSE_INNERAREA between", value1, value2, "houseInnerarea");
			return (Criteria) this;
		}

		public Criteria andHouseInnerareaNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("HOUSE_INNERAREA not between", value1, value2, "houseInnerarea");
			return (Criteria) this;
		}

		public Criteria andHouseFitmentIsNull() {
			addCriterion("HOUSE_FITMENT is null");
			return (Criteria) this;
		}

		public Criteria andHouseFitmentIsNotNull() {
			addCriterion("HOUSE_FITMENT is not null");
			return (Criteria) this;
		}

		public Criteria andHouseFitmentEqualTo(Byte value) {
			addCriterion("HOUSE_FITMENT =", value, "houseFitment");
			return (Criteria) this;
		}

		public Criteria andHouseFitmentNotEqualTo(Byte value) {
			addCriterion("HOUSE_FITMENT <>", value, "houseFitment");
			return (Criteria) this;
		}

		public Criteria andHouseFitmentGreaterThan(Byte value) {
			addCriterion("HOUSE_FITMENT >", value, "houseFitment");
			return (Criteria) this;
		}

		public Criteria andHouseFitmentGreaterThanOrEqualTo(Byte value) {
			addCriterion("HOUSE_FITMENT >=", value, "houseFitment");
			return (Criteria) this;
		}

		public Criteria andHouseFitmentLessThan(Byte value) {
			addCriterion("HOUSE_FITMENT <", value, "houseFitment");
			return (Criteria) this;
		}

		public Criteria andHouseFitmentLessThanOrEqualTo(Byte value) {
			addCriterion("HOUSE_FITMENT <=", value, "houseFitment");
			return (Criteria) this;
		}

		public Criteria andHouseFitmentIn(List<Byte> values) {
			addCriterion("HOUSE_FITMENT in", values, "houseFitment");
			return (Criteria) this;
		}

		public Criteria andHouseFitmentNotIn(List<Byte> values) {
			addCriterion("HOUSE_FITMENT not in", values, "houseFitment");
			return (Criteria) this;
		}

		public Criteria andHouseFitmentBetween(Byte value1, Byte value2) {
			addCriterion("HOUSE_FITMENT between", value1, value2, "houseFitment");
			return (Criteria) this;
		}

		public Criteria andHouseFitmentNotBetween(Byte value1, Byte value2) {
			addCriterion("HOUSE_FITMENT not between", value1, value2, "houseFitment");
			return (Criteria) this;
		}

		public Criteria andHouseLadderIsNull() {
			addCriterion("HOUSE_LADDER is null");
			return (Criteria) this;
		}

		public Criteria andHouseLadderIsNotNull() {
			addCriterion("HOUSE_LADDER is not null");
			return (Criteria) this;
		}

		public Criteria andHouseLadderEqualTo(Integer value) {
			addCriterion("HOUSE_LADDER =", value, "houseLadder");
			return (Criteria) this;
		}

		public Criteria andHouseLadderNotEqualTo(Integer value) {
			addCriterion("HOUSE_LADDER <>", value, "houseLadder");
			return (Criteria) this;
		}

		public Criteria andHouseLadderGreaterThan(Integer value) {
			addCriterion("HOUSE_LADDER >", value, "houseLadder");
			return (Criteria) this;
		}

		public Criteria andHouseLadderGreaterThanOrEqualTo(Integer value) {
			addCriterion("HOUSE_LADDER >=", value, "houseLadder");
			return (Criteria) this;
		}

		public Criteria andHouseLadderLessThan(Integer value) {
			addCriterion("HOUSE_LADDER <", value, "houseLadder");
			return (Criteria) this;
		}

		public Criteria andHouseLadderLessThanOrEqualTo(Integer value) {
			addCriterion("HOUSE_LADDER <=", value, "houseLadder");
			return (Criteria) this;
		}

		public Criteria andHouseLadderIn(List<Integer> values) {
			addCriterion("HOUSE_LADDER in", values, "houseLadder");
			return (Criteria) this;
		}

		public Criteria andHouseLadderNotIn(List<Integer> values) {
			addCriterion("HOUSE_LADDER not in", values, "houseLadder");
			return (Criteria) this;
		}

		public Criteria andHouseLadderBetween(Integer value1, Integer value2) {
			addCriterion("HOUSE_LADDER between", value1, value2, "houseLadder");
			return (Criteria) this;
		}

		public Criteria andHouseLadderNotBetween(Integer value1, Integer value2) {
			addCriterion("HOUSE_LADDER not between", value1, value2, "houseLadder");
			return (Criteria) this;
		}

		public Criteria andHouseDoorsIsNull() {
			addCriterion("HOUSE_DOORS is null");
			return (Criteria) this;
		}

		public Criteria andHouseDoorsIsNotNull() {
			addCriterion("HOUSE_DOORS is not null");
			return (Criteria) this;
		}

		public Criteria andHouseDoorsEqualTo(Byte value) {
			addCriterion("HOUSE_DOORS =", value, "houseDoors");
			return (Criteria) this;
		}

		public Criteria andHouseDoorsNotEqualTo(Byte value) {
			addCriterion("HOUSE_DOORS <>", value, "houseDoors");
			return (Criteria) this;
		}

		public Criteria andHouseDoorsGreaterThan(Byte value) {
			addCriterion("HOUSE_DOORS >", value, "houseDoors");
			return (Criteria) this;
		}

		public Criteria andHouseDoorsGreaterThanOrEqualTo(Byte value) {
			addCriterion("HOUSE_DOORS >=", value, "houseDoors");
			return (Criteria) this;
		}

		public Criteria andHouseDoorsLessThan(Byte value) {
			addCriterion("HOUSE_DOORS <", value, "houseDoors");
			return (Criteria) this;
		}

		public Criteria andHouseDoorsLessThanOrEqualTo(Byte value) {
			addCriterion("HOUSE_DOORS <=", value, "houseDoors");
			return (Criteria) this;
		}

		public Criteria andHouseDoorsIn(List<Byte> values) {
			addCriterion("HOUSE_DOORS in", values, "houseDoors");
			return (Criteria) this;
		}

		public Criteria andHouseDoorsNotIn(List<Byte> values) {
			addCriterion("HOUSE_DOORS not in", values, "houseDoors");
			return (Criteria) this;
		}

		public Criteria andHouseDoorsBetween(Byte value1, Byte value2) {
			addCriterion("HOUSE_DOORS between", value1, value2, "houseDoors");
			return (Criteria) this;
		}

		public Criteria andHouseDoorsNotBetween(Byte value1, Byte value2) {
			addCriterion("HOUSE_DOORS not between", value1, value2, "houseDoors");
			return (Criteria) this;
		}

		public Criteria andHouseRightIsNull() {
			addCriterion("HOUSE_RIGHT is null");
			return (Criteria) this;
		}

		public Criteria andHouseRightIsNotNull() {
			addCriterion("HOUSE_RIGHT is not null");
			return (Criteria) this;
		}

		public Criteria andHouseRightEqualTo(Byte value) {
			addCriterion("HOUSE_RIGHT =", value, "houseRight");
			return (Criteria) this;
		}

		public Criteria andHouseRightNotEqualTo(Byte value) {
			addCriterion("HOUSE_RIGHT <>", value, "houseRight");
			return (Criteria) this;
		}

		public Criteria andHouseRightGreaterThan(Byte value) {
			addCriterion("HOUSE_RIGHT >", value, "houseRight");
			return (Criteria) this;
		}

		public Criteria andHouseRightGreaterThanOrEqualTo(Byte value) {
			addCriterion("HOUSE_RIGHT >=", value, "houseRight");
			return (Criteria) this;
		}

		public Criteria andHouseRightLessThan(Byte value) {
			addCriterion("HOUSE_RIGHT <", value, "houseRight");
			return (Criteria) this;
		}

		public Criteria andHouseRightLessThanOrEqualTo(Byte value) {
			addCriterion("HOUSE_RIGHT <=", value, "houseRight");
			return (Criteria) this;
		}

		public Criteria andHouseRightIn(List<Byte> values) {
			addCriterion("HOUSE_RIGHT in", values, "houseRight");
			return (Criteria) this;
		}

		public Criteria andHouseRightNotIn(List<Byte> values) {
			addCriterion("HOUSE_RIGHT not in", values, "houseRight");
			return (Criteria) this;
		}

		public Criteria andHouseRightBetween(Byte value1, Byte value2) {
			addCriterion("HOUSE_RIGHT between", value1, value2, "houseRight");
			return (Criteria) this;
		}

		public Criteria andHouseRightNotBetween(Byte value1, Byte value2) {
			addCriterion("HOUSE_RIGHT not between", value1, value2, "houseRight");
			return (Criteria) this;
		}

		public Criteria andHouseRightYearIsNull() {
			addCriterion("HOUSE_RIGHT_YEAR is null");
			return (Criteria) this;
		}

		public Criteria andHouseRightYearIsNotNull() {
			addCriterion("HOUSE_RIGHT_YEAR is not null");
			return (Criteria) this;
		}

		public Criteria andHouseRightYearEqualTo(Integer value) {
			addCriterion("HOUSE_RIGHT_YEAR =", value, "houseRightYear");
			return (Criteria) this;
		}

		public Criteria andHouseRightYearNotEqualTo(Integer value) {
			addCriterion("HOUSE_RIGHT_YEAR <>", value, "houseRightYear");
			return (Criteria) this;
		}

		public Criteria andHouseRightYearGreaterThan(Integer value) {
			addCriterion("HOUSE_RIGHT_YEAR >", value, "houseRightYear");
			return (Criteria) this;
		}

		public Criteria andHouseRightYearGreaterThanOrEqualTo(Integer value) {
			addCriterion("HOUSE_RIGHT_YEAR >=", value, "houseRightYear");
			return (Criteria) this;
		}

		public Criteria andHouseRightYearLessThan(Integer value) {
			addCriterion("HOUSE_RIGHT_YEAR <", value, "houseRightYear");
			return (Criteria) this;
		}

		public Criteria andHouseRightYearLessThanOrEqualTo(Integer value) {
			addCriterion("HOUSE_RIGHT_YEAR <=", value, "houseRightYear");
			return (Criteria) this;
		}

		public Criteria andHouseRightYearIn(List<Integer> values) {
			addCriterion("HOUSE_RIGHT_YEAR in", values, "houseRightYear");
			return (Criteria) this;
		}

		public Criteria andHouseRightYearNotIn(List<Integer> values) {
			addCriterion("HOUSE_RIGHT_YEAR not in", values, "houseRightYear");
			return (Criteria) this;
		}

		public Criteria andHouseRightYearBetween(Integer value1, Integer value2) {
			addCriterion("HOUSE_RIGHT_YEAR between", value1, value2, "houseRightYear");
			return (Criteria) this;
		}

		public Criteria andHouseRightYearNotBetween(Integer value1, Integer value2) {
			addCriterion("HOUSE_RIGHT_YEAR not between", value1, value2, "houseRightYear");
			return (Criteria) this;
		}

		public Criteria andHouseRightTypeIsNull() {
			addCriterion("HOUSE_RIGHT_TYPE is null");
			return (Criteria) this;
		}

		public Criteria andHouseRightTypeIsNotNull() {
			addCriterion("HOUSE_RIGHT_TYPE is not null");
			return (Criteria) this;
		}

		public Criteria andHouseRightTypeEqualTo(Byte value) {
			addCriterion("HOUSE_RIGHT_TYPE =", value, "houseRightType");
			return (Criteria) this;
		}

		public Criteria andHouseRightTypeNotEqualTo(Byte value) {
			addCriterion("HOUSE_RIGHT_TYPE <>", value, "houseRightType");
			return (Criteria) this;
		}

		public Criteria andHouseRightTypeGreaterThan(Byte value) {
			addCriterion("HOUSE_RIGHT_TYPE >", value, "houseRightType");
			return (Criteria) this;
		}

		public Criteria andHouseRightTypeGreaterThanOrEqualTo(Byte value) {
			addCriterion("HOUSE_RIGHT_TYPE >=", value, "houseRightType");
			return (Criteria) this;
		}

		public Criteria andHouseRightTypeLessThan(Byte value) {
			addCriterion("HOUSE_RIGHT_TYPE <", value, "houseRightType");
			return (Criteria) this;
		}

		public Criteria andHouseRightTypeLessThanOrEqualTo(Byte value) {
			addCriterion("HOUSE_RIGHT_TYPE <=", value, "houseRightType");
			return (Criteria) this;
		}

		public Criteria andHouseRightTypeIn(List<Byte> values) {
			addCriterion("HOUSE_RIGHT_TYPE in", values, "houseRightType");
			return (Criteria) this;
		}

		public Criteria andHouseRightTypeNotIn(List<Byte> values) {
			addCriterion("HOUSE_RIGHT_TYPE not in", values, "houseRightType");
			return (Criteria) this;
		}

		public Criteria andHouseRightTypeBetween(Byte value1, Byte value2) {
			addCriterion("HOUSE_RIGHT_TYPE between", value1, value2, "houseRightType");
			return (Criteria) this;
		}

		public Criteria andHouseRightTypeNotBetween(Byte value1, Byte value2) {
			addCriterion("HOUSE_RIGHT_TYPE not between", value1, value2, "houseRightType");
			return (Criteria) this;
		}

		public Criteria andHouseRightDateIsNull() {
			addCriterion("HOUSE_RIGHT_DATE is null");
			return (Criteria) this;
		}

		public Criteria andHouseRightDateIsNotNull() {
			addCriterion("HOUSE_RIGHT_DATE is not null");
			return (Criteria) this;
		}

		public Criteria andHouseRightDateEqualTo(Date value) {
			addCriterion("HOUSE_RIGHT_DATE =", value, "houseRightDate");
			return (Criteria) this;
		}

		public Criteria andHouseRightDateNotEqualTo(Date value) {
			addCriterion("HOUSE_RIGHT_DATE <>", value, "houseRightDate");
			return (Criteria) this;
		}

		public Criteria andHouseRightDateGreaterThan(Date value) {
			addCriterion("HOUSE_RIGHT_DATE >", value, "houseRightDate");
			return (Criteria) this;
		}

		public Criteria andHouseRightDateGreaterThanOrEqualTo(Date value) {
			addCriterion("HOUSE_RIGHT_DATE >=", value, "houseRightDate");
			return (Criteria) this;
		}

		public Criteria andHouseRightDateLessThan(Date value) {
			addCriterion("HOUSE_RIGHT_DATE <", value, "houseRightDate");
			return (Criteria) this;
		}

		public Criteria andHouseRightDateLessThanOrEqualTo(Date value) {
			addCriterion("HOUSE_RIGHT_DATE <=", value, "houseRightDate");
			return (Criteria) this;
		}

		public Criteria andHouseRightDateIn(List<Date> values) {
			addCriterion("HOUSE_RIGHT_DATE in", values, "houseRightDate");
			return (Criteria) this;
		}

		public Criteria andHouseRightDateNotIn(List<Date> values) {
			addCriterion("HOUSE_RIGHT_DATE not in", values, "houseRightDate");
			return (Criteria) this;
		}

		public Criteria andHouseRightDateBetween(Date value1, Date value2) {
			addCriterion("HOUSE_RIGHT_DATE between", value1, value2, "houseRightDate");
			return (Criteria) this;
		}

		public Criteria andHouseRightDateNotBetween(Date value1, Date value2) {
			addCriterion("HOUSE_RIGHT_DATE not between", value1, value2, "houseRightDate");
			return (Criteria) this;
		}

		public Criteria andHouseDirectIsNull() {
			addCriterion("HOUSE_DIRECT is null");
			return (Criteria) this;
		}

		public Criteria andHouseDirectIsNotNull() {
			addCriterion("HOUSE_DIRECT is not null");
			return (Criteria) this;
		}

		public Criteria andHouseDirectEqualTo(Byte value) {
			addCriterion("HOUSE_DIRECT =", value, "houseDirect");
			return (Criteria) this;
		}

		public Criteria andHouseDirectNotEqualTo(Byte value) {
			addCriterion("HOUSE_DIRECT <>", value, "houseDirect");
			return (Criteria) this;
		}

		public Criteria andHouseDirectGreaterThan(Byte value) {
			addCriterion("HOUSE_DIRECT >", value, "houseDirect");
			return (Criteria) this;
		}

		public Criteria andHouseDirectGreaterThanOrEqualTo(Byte value) {
			addCriterion("HOUSE_DIRECT >=", value, "houseDirect");
			return (Criteria) this;
		}

		public Criteria andHouseDirectLessThan(Byte value) {
			addCriterion("HOUSE_DIRECT <", value, "houseDirect");
			return (Criteria) this;
		}

		public Criteria andHouseDirectLessThanOrEqualTo(Byte value) {
			addCriterion("HOUSE_DIRECT <=", value, "houseDirect");
			return (Criteria) this;
		}

		public Criteria andHouseDirectIn(List<Byte> values) {
			addCriterion("HOUSE_DIRECT in", values, "houseDirect");
			return (Criteria) this;
		}

		public Criteria andHouseDirectNotIn(List<Byte> values) {
			addCriterion("HOUSE_DIRECT not in", values, "houseDirect");
			return (Criteria) this;
		}

		public Criteria andHouseDirectBetween(Byte value1, Byte value2) {
			addCriterion("HOUSE_DIRECT between", value1, value2, "houseDirect");
			return (Criteria) this;
		}

		public Criteria andHouseDirectNotBetween(Byte value1, Byte value2) {
			addCriterion("HOUSE_DIRECT not between", value1, value2, "houseDirect");
			return (Criteria) this;
		}

		public Criteria andHouseYearIsNull() {
			addCriterion("HOUSE_YEAR is null");
			return (Criteria) this;
		}

		public Criteria andHouseYearIsNotNull() {
			addCriterion("HOUSE_YEAR is not null");
			return (Criteria) this;
		}

		public Criteria andHouseYearEqualTo(Integer value) {
			addCriterion("HOUSE_YEAR =", value, "houseYear");
			return (Criteria) this;
		}

		public Criteria andHouseYearNotEqualTo(Integer value) {
			addCriterion("HOUSE_YEAR <>", value, "houseYear");
			return (Criteria) this;
		}

		public Criteria andHouseYearGreaterThan(Integer value) {
			addCriterion("HOUSE_YEAR >", value, "houseYear");
			return (Criteria) this;
		}

		public Criteria andHouseYearGreaterThanOrEqualTo(Integer value) {
			addCriterion("HOUSE_YEAR >=", value, "houseYear");
			return (Criteria) this;
		}

		public Criteria andHouseYearLessThan(Integer value) {
			addCriterion("HOUSE_YEAR <", value, "houseYear");
			return (Criteria) this;
		}

		public Criteria andHouseYearLessThanOrEqualTo(Integer value) {
			addCriterion("HOUSE_YEAR <=", value, "houseYear");
			return (Criteria) this;
		}

		public Criteria andHouseYearIn(List<Integer> values) {
			addCriterion("HOUSE_YEAR in", values, "houseYear");
			return (Criteria) this;
		}

		public Criteria andHouseYearNotIn(List<Integer> values) {
			addCriterion("HOUSE_YEAR not in", values, "houseYear");
			return (Criteria) this;
		}

		public Criteria andHouseYearBetween(Integer value1, Integer value2) {
			addCriterion("HOUSE_YEAR between", value1, value2, "houseYear");
			return (Criteria) this;
		}

		public Criteria andHouseYearNotBetween(Integer value1, Integer value2) {
			addCriterion("HOUSE_YEAR not between", value1, value2, "houseYear");
			return (Criteria) this;
		}

		public Criteria andRenovationNoIsNull() {
			addCriterion("RENOVATION_NO is null");
			return (Criteria) this;
		}

		public Criteria andRenovationNoIsNotNull() {
			addCriterion("RENOVATION_NO is not null");
			return (Criteria) this;
		}

		public Criteria andRenovationNoEqualTo(String value) {
			addCriterion("RENOVATION_NO =", value, "renovationNo");
			return (Criteria) this;
		}

		public Criteria andRenovationNoNotEqualTo(String value) {
			addCriterion("RENOVATION_NO <>", value, "renovationNo");
			return (Criteria) this;
		}

		public Criteria andRenovationNoGreaterThan(String value) {
			addCriterion("RENOVATION_NO >", value, "renovationNo");
			return (Criteria) this;
		}

		public Criteria andRenovationNoGreaterThanOrEqualTo(String value) {
			addCriterion("RENOVATION_NO >=", value, "renovationNo");
			return (Criteria) this;
		}

		public Criteria andRenovationNoLessThan(String value) {
			addCriterion("RENOVATION_NO <", value, "renovationNo");
			return (Criteria) this;
		}

		public Criteria andRenovationNoLessThanOrEqualTo(String value) {
			addCriterion("RENOVATION_NO <=", value, "renovationNo");
			return (Criteria) this;
		}

		public Criteria andRenovationNoLike(String value) {
			addCriterion("RENOVATION_NO like", value, "renovationNo");
			return (Criteria) this;
		}

		public Criteria andRenovationNoNotLike(String value) {
			addCriterion("RENOVATION_NO not like", value, "renovationNo");
			return (Criteria) this;
		}

		public Criteria andRenovationNoIn(List<String> values) {
			addCriterion("RENOVATION_NO in", values, "renovationNo");
			return (Criteria) this;
		}

		public Criteria andRenovationNoNotIn(List<String> values) {
			addCriterion("RENOVATION_NO not in", values, "renovationNo");
			return (Criteria) this;
		}

		public Criteria andRenovationNoBetween(String value1, String value2) {
			addCriterion("RENOVATION_NO between", value1, value2, "renovationNo");
			return (Criteria) this;
		}

		public Criteria andRenovationNoNotBetween(String value1, String value2) {
			addCriterion("RENOVATION_NO not between", value1, value2, "renovationNo");
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