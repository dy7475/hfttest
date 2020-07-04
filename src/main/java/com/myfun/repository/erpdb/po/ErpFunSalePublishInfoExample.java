package com.myfun.repository.erpdb.po;

import com.myfun.repository.support.generator.shard.ShardDb;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;

public class ErpFunSalePublishInfoExample extends ShardDb {
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
	public ErpFunSalePublishInfoExample() {
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

		public Criteria andSaleIdIsNull() {
			addCriterion("SALE_ID is null");
			return (Criteria) this;
		}

		public Criteria andSaleIdIsNotNull() {
			addCriterion("SALE_ID is not null");
			return (Criteria) this;
		}

		public Criteria andSaleIdEqualTo(String value) {
			addCriterion("SALE_ID =", value, "saleId");
			return (Criteria) this;
		}

		public Criteria andSaleIdNotEqualTo(String value) {
			addCriterion("SALE_ID <>", value, "saleId");
			return (Criteria) this;
		}

		public Criteria andSaleIdGreaterThan(String value) {
			addCriterion("SALE_ID >", value, "saleId");
			return (Criteria) this;
		}

		public Criteria andSaleIdGreaterThanOrEqualTo(String value) {
			addCriterion("SALE_ID >=", value, "saleId");
			return (Criteria) this;
		}

		public Criteria andSaleIdLessThan(String value) {
			addCriterion("SALE_ID <", value, "saleId");
			return (Criteria) this;
		}

		public Criteria andSaleIdLessThanOrEqualTo(String value) {
			addCriterion("SALE_ID <=", value, "saleId");
			return (Criteria) this;
		}

		public Criteria andSaleIdLike(String value) {
			addCriterion("SALE_ID like", value, "saleId");
			return (Criteria) this;
		}

		public Criteria andSaleIdNotLike(String value) {
			addCriterion("SALE_ID not like", value, "saleId");
			return (Criteria) this;
		}

		public Criteria andSaleIdIn(List<String> values) {
			addCriterion("SALE_ID in", values, "saleId");
			return (Criteria) this;
		}

		public Criteria andSaleIdNotIn(List<String> values) {
			addCriterion("SALE_ID not in", values, "saleId");
			return (Criteria) this;
		}

		public Criteria andSaleIdBetween(String value1, String value2) {
			addCriterion("SALE_ID between", value1, value2, "saleId");
			return (Criteria) this;
		}

		public Criteria andSaleIdNotBetween(String value1, String value2) {
			addCriterion("SALE_ID not between", value1, value2, "saleId");
			return (Criteria) this;
		}

		public Criteria andWebsiteStateIsNull() {
			addCriterion("WEBSITE_STATE is null");
			return (Criteria) this;
		}

		public Criteria andWebsiteStateIsNotNull() {
			addCriterion("WEBSITE_STATE is not null");
			return (Criteria) this;
		}

		public Criteria andWebsiteStateEqualTo(String value) {
			addCriterion("WEBSITE_STATE =", value, "websiteState");
			return (Criteria) this;
		}

		public Criteria andWebsiteStateNotEqualTo(String value) {
			addCriterion("WEBSITE_STATE <>", value, "websiteState");
			return (Criteria) this;
		}

		public Criteria andWebsiteStateGreaterThan(String value) {
			addCriterion("WEBSITE_STATE >", value, "websiteState");
			return (Criteria) this;
		}

		public Criteria andWebsiteStateGreaterThanOrEqualTo(String value) {
			addCriterion("WEBSITE_STATE >=", value, "websiteState");
			return (Criteria) this;
		}

		public Criteria andWebsiteStateLessThan(String value) {
			addCriterion("WEBSITE_STATE <", value, "websiteState");
			return (Criteria) this;
		}

		public Criteria andWebsiteStateLessThanOrEqualTo(String value) {
			addCriterion("WEBSITE_STATE <=", value, "websiteState");
			return (Criteria) this;
		}

		public Criteria andWebsiteStateLike(String value) {
			addCriterion("WEBSITE_STATE like", value, "websiteState");
			return (Criteria) this;
		}

		public Criteria andWebsiteStateNotLike(String value) {
			addCriterion("WEBSITE_STATE not like", value, "websiteState");
			return (Criteria) this;
		}

		public Criteria andWebsiteStateIn(List<String> values) {
			addCriterion("WEBSITE_STATE in", values, "websiteState");
			return (Criteria) this;
		}

		public Criteria andWebsiteStateNotIn(List<String> values) {
			addCriterion("WEBSITE_STATE not in", values, "websiteState");
			return (Criteria) this;
		}

		public Criteria andWebsiteStateBetween(String value1, String value2) {
			addCriterion("WEBSITE_STATE between", value1, value2, "websiteState");
			return (Criteria) this;
		}

		public Criteria andWebsiteStateNotBetween(String value1, String value2) {
			addCriterion("WEBSITE_STATE not between", value1, value2, "websiteState");
			return (Criteria) this;
		}

		public Criteria andWebsiteLastUpTimeIsNull() {
			addCriterion("WEBSITE_LAST_UP_TIME is null");
			return (Criteria) this;
		}

		public Criteria andWebsiteLastUpTimeIsNotNull() {
			addCriterion("WEBSITE_LAST_UP_TIME is not null");
			return (Criteria) this;
		}

		public Criteria andWebsiteLastUpTimeEqualTo(String value) {
			addCriterion("WEBSITE_LAST_UP_TIME =", value, "websiteLastUpTime");
			return (Criteria) this;
		}

		public Criteria andWebsiteLastUpTimeNotEqualTo(String value) {
			addCriterion("WEBSITE_LAST_UP_TIME <>", value, "websiteLastUpTime");
			return (Criteria) this;
		}

		public Criteria andWebsiteLastUpTimeGreaterThan(String value) {
			addCriterion("WEBSITE_LAST_UP_TIME >", value, "websiteLastUpTime");
			return (Criteria) this;
		}

		public Criteria andWebsiteLastUpTimeGreaterThanOrEqualTo(String value) {
			addCriterion("WEBSITE_LAST_UP_TIME >=", value, "websiteLastUpTime");
			return (Criteria) this;
		}

		public Criteria andWebsiteLastUpTimeLessThan(String value) {
			addCriterion("WEBSITE_LAST_UP_TIME <", value, "websiteLastUpTime");
			return (Criteria) this;
		}

		public Criteria andWebsiteLastUpTimeLessThanOrEqualTo(String value) {
			addCriterion("WEBSITE_LAST_UP_TIME <=", value, "websiteLastUpTime");
			return (Criteria) this;
		}

		public Criteria andWebsiteLastUpTimeLike(String value) {
			addCriterion("WEBSITE_LAST_UP_TIME like", value, "websiteLastUpTime");
			return (Criteria) this;
		}

		public Criteria andWebsiteLastUpTimeNotLike(String value) {
			addCriterion("WEBSITE_LAST_UP_TIME not like", value, "websiteLastUpTime");
			return (Criteria) this;
		}

		public Criteria andWebsiteLastUpTimeIn(List<String> values) {
			addCriterion("WEBSITE_LAST_UP_TIME in", values, "websiteLastUpTime");
			return (Criteria) this;
		}

		public Criteria andWebsiteLastUpTimeNotIn(List<String> values) {
			addCriterion("WEBSITE_LAST_UP_TIME not in", values, "websiteLastUpTime");
			return (Criteria) this;
		}

		public Criteria andWebsiteLastUpTimeBetween(String value1, String value2) {
			addCriterion("WEBSITE_LAST_UP_TIME between", value1, value2, "websiteLastUpTime");
			return (Criteria) this;
		}

		public Criteria andWebsiteLastUpTimeNotBetween(String value1, String value2) {
			addCriterion("WEBSITE_LAST_UP_TIME not between", value1, value2, "websiteLastUpTime");
			return (Criteria) this;
		}

		public Criteria andWebsiteLastDownTimeIsNull() {
			addCriterion("WEBSITE_LAST_DOWN_TIME is null");
			return (Criteria) this;
		}

		public Criteria andWebsiteLastDownTimeIsNotNull() {
			addCriterion("WEBSITE_LAST_DOWN_TIME is not null");
			return (Criteria) this;
		}

		public Criteria andWebsiteLastDownTimeEqualTo(String value) {
			addCriterion("WEBSITE_LAST_DOWN_TIME =", value, "websiteLastDownTime");
			return (Criteria) this;
		}

		public Criteria andWebsiteLastDownTimeNotEqualTo(String value) {
			addCriterion("WEBSITE_LAST_DOWN_TIME <>", value, "websiteLastDownTime");
			return (Criteria) this;
		}

		public Criteria andWebsiteLastDownTimeGreaterThan(String value) {
			addCriterion("WEBSITE_LAST_DOWN_TIME >", value, "websiteLastDownTime");
			return (Criteria) this;
		}

		public Criteria andWebsiteLastDownTimeGreaterThanOrEqualTo(String value) {
			addCriterion("WEBSITE_LAST_DOWN_TIME >=", value, "websiteLastDownTime");
			return (Criteria) this;
		}

		public Criteria andWebsiteLastDownTimeLessThan(String value) {
			addCriterion("WEBSITE_LAST_DOWN_TIME <", value, "websiteLastDownTime");
			return (Criteria) this;
		}

		public Criteria andWebsiteLastDownTimeLessThanOrEqualTo(String value) {
			addCriterion("WEBSITE_LAST_DOWN_TIME <=", value, "websiteLastDownTime");
			return (Criteria) this;
		}

		public Criteria andWebsiteLastDownTimeLike(String value) {
			addCriterion("WEBSITE_LAST_DOWN_TIME like", value, "websiteLastDownTime");
			return (Criteria) this;
		}

		public Criteria andWebsiteLastDownTimeNotLike(String value) {
			addCriterion("WEBSITE_LAST_DOWN_TIME not like", value, "websiteLastDownTime");
			return (Criteria) this;
		}

		public Criteria andWebsiteLastDownTimeIn(List<String> values) {
			addCriterion("WEBSITE_LAST_DOWN_TIME in", values, "websiteLastDownTime");
			return (Criteria) this;
		}

		public Criteria andWebsiteLastDownTimeNotIn(List<String> values) {
			addCriterion("WEBSITE_LAST_DOWN_TIME not in", values, "websiteLastDownTime");
			return (Criteria) this;
		}

		public Criteria andWebsiteLastDownTimeBetween(String value1, String value2) {
			addCriterion("WEBSITE_LAST_DOWN_TIME between", value1, value2, "websiteLastDownTime");
			return (Criteria) this;
		}

		public Criteria andWebsiteLastDownTimeNotBetween(String value1, String value2) {
			addCriterion("WEBSITE_LAST_DOWN_TIME not between", value1, value2, "websiteLastDownTime");
			return (Criteria) this;
		}

		public Criteria andMlhfStateIsNull() {
			addCriterion("MLHF_STATE is null");
			return (Criteria) this;
		}

		public Criteria andMlhfStateIsNotNull() {
			addCriterion("MLHF_STATE is not null");
			return (Criteria) this;
		}

		public Criteria andMlhfStateEqualTo(String value) {
			addCriterion("MLHF_STATE =", value, "mlhfState");
			return (Criteria) this;
		}

		public Criteria andMlhfStateNotEqualTo(String value) {
			addCriterion("MLHF_STATE <>", value, "mlhfState");
			return (Criteria) this;
		}

		public Criteria andMlhfStateGreaterThan(String value) {
			addCriterion("MLHF_STATE >", value, "mlhfState");
			return (Criteria) this;
		}

		public Criteria andMlhfStateGreaterThanOrEqualTo(String value) {
			addCriterion("MLHF_STATE >=", value, "mlhfState");
			return (Criteria) this;
		}

		public Criteria andMlhfStateLessThan(String value) {
			addCriterion("MLHF_STATE <", value, "mlhfState");
			return (Criteria) this;
		}

		public Criteria andMlhfStateLessThanOrEqualTo(String value) {
			addCriterion("MLHF_STATE <=", value, "mlhfState");
			return (Criteria) this;
		}

		public Criteria andMlhfStateLike(String value) {
			addCriterion("MLHF_STATE like", value, "mlhfState");
			return (Criteria) this;
		}

		public Criteria andMlhfStateNotLike(String value) {
			addCriterion("MLHF_STATE not like", value, "mlhfState");
			return (Criteria) this;
		}

		public Criteria andMlhfStateIn(List<String> values) {
			addCriterion("MLHF_STATE in", values, "mlhfState");
			return (Criteria) this;
		}

		public Criteria andMlhfStateNotIn(List<String> values) {
			addCriterion("MLHF_STATE not in", values, "mlhfState");
			return (Criteria) this;
		}

		public Criteria andMlhfStateBetween(String value1, String value2) {
			addCriterion("MLHF_STATE between", value1, value2, "mlhfState");
			return (Criteria) this;
		}

		public Criteria andMlhfStateNotBetween(String value1, String value2) {
			addCriterion("MLHF_STATE not between", value1, value2, "mlhfState");
			return (Criteria) this;
		}

		public Criteria andMlhfLastUpTimeIsNull() {
			addCriterion("MLHF_LAST_UP_TIME is null");
			return (Criteria) this;
		}

		public Criteria andMlhfLastUpTimeIsNotNull() {
			addCriterion("MLHF_LAST_UP_TIME is not null");
			return (Criteria) this;
		}

		public Criteria andMlhfLastUpTimeEqualTo(String value) {
			addCriterion("MLHF_LAST_UP_TIME =", value, "mlhfLastUpTime");
			return (Criteria) this;
		}

		public Criteria andMlhfLastUpTimeNotEqualTo(String value) {
			addCriterion("MLHF_LAST_UP_TIME <>", value, "mlhfLastUpTime");
			return (Criteria) this;
		}

		public Criteria andMlhfLastUpTimeGreaterThan(String value) {
			addCriterion("MLHF_LAST_UP_TIME >", value, "mlhfLastUpTime");
			return (Criteria) this;
		}

		public Criteria andMlhfLastUpTimeGreaterThanOrEqualTo(String value) {
			addCriterion("MLHF_LAST_UP_TIME >=", value, "mlhfLastUpTime");
			return (Criteria) this;
		}

		public Criteria andMlhfLastUpTimeLessThan(String value) {
			addCriterion("MLHF_LAST_UP_TIME <", value, "mlhfLastUpTime");
			return (Criteria) this;
		}

		public Criteria andMlhfLastUpTimeLessThanOrEqualTo(String value) {
			addCriterion("MLHF_LAST_UP_TIME <=", value, "mlhfLastUpTime");
			return (Criteria) this;
		}

		public Criteria andMlhfLastUpTimeLike(String value) {
			addCriterion("MLHF_LAST_UP_TIME like", value, "mlhfLastUpTime");
			return (Criteria) this;
		}

		public Criteria andMlhfLastUpTimeNotLike(String value) {
			addCriterion("MLHF_LAST_UP_TIME not like", value, "mlhfLastUpTime");
			return (Criteria) this;
		}

		public Criteria andMlhfLastUpTimeIn(List<String> values) {
			addCriterion("MLHF_LAST_UP_TIME in", values, "mlhfLastUpTime");
			return (Criteria) this;
		}

		public Criteria andMlhfLastUpTimeNotIn(List<String> values) {
			addCriterion("MLHF_LAST_UP_TIME not in", values, "mlhfLastUpTime");
			return (Criteria) this;
		}

		public Criteria andMlhfLastUpTimeBetween(String value1, String value2) {
			addCriterion("MLHF_LAST_UP_TIME between", value1, value2, "mlhfLastUpTime");
			return (Criteria) this;
		}

		public Criteria andMlhfLastUpTimeNotBetween(String value1, String value2) {
			addCriterion("MLHF_LAST_UP_TIME not between", value1, value2, "mlhfLastUpTime");
			return (Criteria) this;
		}

		public Criteria andMlhfLastDownTimeIsNull() {
			addCriterion("MLHF_LAST_DOWN_TIME is null");
			return (Criteria) this;
		}

		public Criteria andMlhfLastDownTimeIsNotNull() {
			addCriterion("MLHF_LAST_DOWN_TIME is not null");
			return (Criteria) this;
		}

		public Criteria andMlhfLastDownTimeEqualTo(String value) {
			addCriterion("MLHF_LAST_DOWN_TIME =", value, "mlhfLastDownTime");
			return (Criteria) this;
		}

		public Criteria andMlhfLastDownTimeNotEqualTo(String value) {
			addCriterion("MLHF_LAST_DOWN_TIME <>", value, "mlhfLastDownTime");
			return (Criteria) this;
		}

		public Criteria andMlhfLastDownTimeGreaterThan(String value) {
			addCriterion("MLHF_LAST_DOWN_TIME >", value, "mlhfLastDownTime");
			return (Criteria) this;
		}

		public Criteria andMlhfLastDownTimeGreaterThanOrEqualTo(String value) {
			addCriterion("MLHF_LAST_DOWN_TIME >=", value, "mlhfLastDownTime");
			return (Criteria) this;
		}

		public Criteria andMlhfLastDownTimeLessThan(String value) {
			addCriterion("MLHF_LAST_DOWN_TIME <", value, "mlhfLastDownTime");
			return (Criteria) this;
		}

		public Criteria andMlhfLastDownTimeLessThanOrEqualTo(String value) {
			addCriterion("MLHF_LAST_DOWN_TIME <=", value, "mlhfLastDownTime");
			return (Criteria) this;
		}

		public Criteria andMlhfLastDownTimeLike(String value) {
			addCriterion("MLHF_LAST_DOWN_TIME like", value, "mlhfLastDownTime");
			return (Criteria) this;
		}

		public Criteria andMlhfLastDownTimeNotLike(String value) {
			addCriterion("MLHF_LAST_DOWN_TIME not like", value, "mlhfLastDownTime");
			return (Criteria) this;
		}

		public Criteria andMlhfLastDownTimeIn(List<String> values) {
			addCriterion("MLHF_LAST_DOWN_TIME in", values, "mlhfLastDownTime");
			return (Criteria) this;
		}

		public Criteria andMlhfLastDownTimeNotIn(List<String> values) {
			addCriterion("MLHF_LAST_DOWN_TIME not in", values, "mlhfLastDownTime");
			return (Criteria) this;
		}

		public Criteria andMlhfLastDownTimeBetween(String value1, String value2) {
			addCriterion("MLHF_LAST_DOWN_TIME between", value1, value2, "mlhfLastDownTime");
			return (Criteria) this;
		}

		public Criteria andMlhfLastDownTimeNotBetween(String value1, String value2) {
			addCriterion("MLHF_LAST_DOWN_TIME not between", value1, value2, "mlhfLastDownTime");
			return (Criteria) this;
		}

		public Criteria andLastActionUserIdIsNull() {
			addCriterion("LAST_ACTION_USER_ID is null");
			return (Criteria) this;
		}

		public Criteria andLastActionUserIdIsNotNull() {
			addCriterion("LAST_ACTION_USER_ID is not null");
			return (Criteria) this;
		}

		public Criteria andLastActionUserIdEqualTo(Integer value) {
			addCriterion("LAST_ACTION_USER_ID =", value, "lastActionUserId");
			return (Criteria) this;
		}

		public Criteria andLastActionUserIdNotEqualTo(Integer value) {
			addCriterion("LAST_ACTION_USER_ID <>", value, "lastActionUserId");
			return (Criteria) this;
		}

		public Criteria andLastActionUserIdGreaterThan(Integer value) {
			addCriterion("LAST_ACTION_USER_ID >", value, "lastActionUserId");
			return (Criteria) this;
		}

		public Criteria andLastActionUserIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("LAST_ACTION_USER_ID >=", value, "lastActionUserId");
			return (Criteria) this;
		}

		public Criteria andLastActionUserIdLessThan(Integer value) {
			addCriterion("LAST_ACTION_USER_ID <", value, "lastActionUserId");
			return (Criteria) this;
		}

		public Criteria andLastActionUserIdLessThanOrEqualTo(Integer value) {
			addCriterion("LAST_ACTION_USER_ID <=", value, "lastActionUserId");
			return (Criteria) this;
		}

		public Criteria andLastActionUserIdIn(List<Integer> values) {
			addCriterion("LAST_ACTION_USER_ID in", values, "lastActionUserId");
			return (Criteria) this;
		}

		public Criteria andLastActionUserIdNotIn(List<Integer> values) {
			addCriterion("LAST_ACTION_USER_ID not in", values, "lastActionUserId");
			return (Criteria) this;
		}

		public Criteria andLastActionUserIdBetween(Integer value1, Integer value2) {
			addCriterion("LAST_ACTION_USER_ID between", value1, value2, "lastActionUserId");
			return (Criteria) this;
		}

		public Criteria andLastActionUserIdNotBetween(Integer value1, Integer value2) {
			addCriterion("LAST_ACTION_USER_ID not between", value1, value2, "lastActionUserId");
			return (Criteria) this;
		}

		public Criteria andMlhfArchiveIdIsNull() {
			addCriterion("MLHF_ARCHIVE_ID is null");
			return (Criteria) this;
		}

		public Criteria andMlhfArchiveIdIsNotNull() {
			addCriterion("MLHF_ARCHIVE_ID is not null");
			return (Criteria) this;
		}

		public Criteria andMlhfArchiveIdEqualTo(Integer value) {
			addCriterion("MLHF_ARCHIVE_ID =", value, "mlhfArchiveId");
			return (Criteria) this;
		}

		public Criteria andMlhfArchiveIdNotEqualTo(Integer value) {
			addCriterion("MLHF_ARCHIVE_ID <>", value, "mlhfArchiveId");
			return (Criteria) this;
		}

		public Criteria andMlhfArchiveIdGreaterThan(Integer value) {
			addCriterion("MLHF_ARCHIVE_ID >", value, "mlhfArchiveId");
			return (Criteria) this;
		}

		public Criteria andMlhfArchiveIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("MLHF_ARCHIVE_ID >=", value, "mlhfArchiveId");
			return (Criteria) this;
		}

		public Criteria andMlhfArchiveIdLessThan(Integer value) {
			addCriterion("MLHF_ARCHIVE_ID <", value, "mlhfArchiveId");
			return (Criteria) this;
		}

		public Criteria andMlhfArchiveIdLessThanOrEqualTo(Integer value) {
			addCriterion("MLHF_ARCHIVE_ID <=", value, "mlhfArchiveId");
			return (Criteria) this;
		}

		public Criteria andMlhfArchiveIdIn(List<Integer> values) {
			addCriterion("MLHF_ARCHIVE_ID in", values, "mlhfArchiveId");
			return (Criteria) this;
		}

		public Criteria andMlhfArchiveIdNotIn(List<Integer> values) {
			addCriterion("MLHF_ARCHIVE_ID not in", values, "mlhfArchiveId");
			return (Criteria) this;
		}

		public Criteria andMlhfArchiveIdBetween(Integer value1, Integer value2) {
			addCriterion("MLHF_ARCHIVE_ID between", value1, value2, "mlhfArchiveId");
			return (Criteria) this;
		}

		public Criteria andMlhfArchiveIdNotBetween(Integer value1, Integer value2) {
			addCriterion("MLHF_ARCHIVE_ID not between", value1, value2, "mlhfArchiveId");
			return (Criteria) this;
		}

		public Criteria andWebsiteArchiveIdIsNull() {
			addCriterion("WEBSITE_ARCHIVE_ID is null");
			return (Criteria) this;
		}

		public Criteria andWebsiteArchiveIdIsNotNull() {
			addCriterion("WEBSITE_ARCHIVE_ID is not null");
			return (Criteria) this;
		}

		public Criteria andWebsiteArchiveIdEqualTo(Integer value) {
			addCriterion("WEBSITE_ARCHIVE_ID =", value, "websiteArchiveId");
			return (Criteria) this;
		}

		public Criteria andWebsiteArchiveIdNotEqualTo(Integer value) {
			addCriterion("WEBSITE_ARCHIVE_ID <>", value, "websiteArchiveId");
			return (Criteria) this;
		}

		public Criteria andWebsiteArchiveIdGreaterThan(Integer value) {
			addCriterion("WEBSITE_ARCHIVE_ID >", value, "websiteArchiveId");
			return (Criteria) this;
		}

		public Criteria andWebsiteArchiveIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("WEBSITE_ARCHIVE_ID >=", value, "websiteArchiveId");
			return (Criteria) this;
		}

		public Criteria andWebsiteArchiveIdLessThan(Integer value) {
			addCriterion("WEBSITE_ARCHIVE_ID <", value, "websiteArchiveId");
			return (Criteria) this;
		}

		public Criteria andWebsiteArchiveIdLessThanOrEqualTo(Integer value) {
			addCriterion("WEBSITE_ARCHIVE_ID <=", value, "websiteArchiveId");
			return (Criteria) this;
		}

		public Criteria andWebsiteArchiveIdIn(List<Integer> values) {
			addCriterion("WEBSITE_ARCHIVE_ID in", values, "websiteArchiveId");
			return (Criteria) this;
		}

		public Criteria andWebsiteArchiveIdNotIn(List<Integer> values) {
			addCriterion("WEBSITE_ARCHIVE_ID not in", values, "websiteArchiveId");
			return (Criteria) this;
		}

		public Criteria andWebsiteArchiveIdBetween(Integer value1, Integer value2) {
			addCriterion("WEBSITE_ARCHIVE_ID between", value1, value2, "websiteArchiveId");
			return (Criteria) this;
		}

		public Criteria andWebsiteArchiveIdNotBetween(Integer value1, Integer value2) {
			addCriterion("WEBSITE_ARCHIVE_ID not between", value1, value2, "websiteArchiveId");
			return (Criteria) this;
		}

		public Criteria andDownControlIsNull() {
			addCriterion("DOWN_CONTROL is null");
			return (Criteria) this;
		}

		public Criteria andDownControlIsNotNull() {
			addCriterion("DOWN_CONTROL is not null");
			return (Criteria) this;
		}

		public Criteria andDownControlEqualTo(Byte value) {
			addCriterion("DOWN_CONTROL =", value, "downControl");
			return (Criteria) this;
		}

		public Criteria andDownControlNotEqualTo(Byte value) {
			addCriterion("DOWN_CONTROL <>", value, "downControl");
			return (Criteria) this;
		}

		public Criteria andDownControlGreaterThan(Byte value) {
			addCriterion("DOWN_CONTROL >", value, "downControl");
			return (Criteria) this;
		}

		public Criteria andDownControlGreaterThanOrEqualTo(Byte value) {
			addCriterion("DOWN_CONTROL >=", value, "downControl");
			return (Criteria) this;
		}

		public Criteria andDownControlLessThan(Byte value) {
			addCriterion("DOWN_CONTROL <", value, "downControl");
			return (Criteria) this;
		}

		public Criteria andDownControlLessThanOrEqualTo(Byte value) {
			addCriterion("DOWN_CONTROL <=", value, "downControl");
			return (Criteria) this;
		}

		public Criteria andDownControlIn(List<Byte> values) {
			addCriterion("DOWN_CONTROL in", values, "downControl");
			return (Criteria) this;
		}

		public Criteria andDownControlNotIn(List<Byte> values) {
			addCriterion("DOWN_CONTROL not in", values, "downControl");
			return (Criteria) this;
		}

		public Criteria andDownControlBetween(Byte value1, Byte value2) {
			addCriterion("DOWN_CONTROL between", value1, value2, "downControl");
			return (Criteria) this;
		}

		public Criteria andDownControlNotBetween(Byte value1, Byte value2) {
			addCriterion("DOWN_CONTROL not between", value1, value2, "downControl");
			return (Criteria) this;
		}

		public Criteria andEstimatedRelaunchTimeIsNull() {
			addCriterion("ESTIMATED_RELAUNCH_TIME is null");
			return (Criteria) this;
		}

		public Criteria andEstimatedRelaunchTimeIsNotNull() {
			addCriterion("ESTIMATED_RELAUNCH_TIME is not null");
			return (Criteria) this;
		}

		public Criteria andEstimatedRelaunchTimeEqualTo(Date value) {
			addCriterion("ESTIMATED_RELAUNCH_TIME =", value, "estimatedRelaunchTime");
			return (Criteria) this;
		}

		public Criteria andEstimatedRelaunchTimeNotEqualTo(Date value) {
			addCriterion("ESTIMATED_RELAUNCH_TIME <>", value, "estimatedRelaunchTime");
			return (Criteria) this;
		}

		public Criteria andEstimatedRelaunchTimeGreaterThan(Date value) {
			addCriterion("ESTIMATED_RELAUNCH_TIME >", value, "estimatedRelaunchTime");
			return (Criteria) this;
		}

		public Criteria andEstimatedRelaunchTimeGreaterThanOrEqualTo(Date value) {
			addCriterion("ESTIMATED_RELAUNCH_TIME >=", value, "estimatedRelaunchTime");
			return (Criteria) this;
		}

		public Criteria andEstimatedRelaunchTimeLessThan(Date value) {
			addCriterion("ESTIMATED_RELAUNCH_TIME <", value, "estimatedRelaunchTime");
			return (Criteria) this;
		}

		public Criteria andEstimatedRelaunchTimeLessThanOrEqualTo(Date value) {
			addCriterion("ESTIMATED_RELAUNCH_TIME <=", value, "estimatedRelaunchTime");
			return (Criteria) this;
		}

		public Criteria andEstimatedRelaunchTimeIn(List<Date> values) {
			addCriterion("ESTIMATED_RELAUNCH_TIME in", values, "estimatedRelaunchTime");
			return (Criteria) this;
		}

		public Criteria andEstimatedRelaunchTimeNotIn(List<Date> values) {
			addCriterion("ESTIMATED_RELAUNCH_TIME not in", values, "estimatedRelaunchTime");
			return (Criteria) this;
		}

		public Criteria andEstimatedRelaunchTimeBetween(Date value1, Date value2) {
			addCriterion("ESTIMATED_RELAUNCH_TIME between", value1, value2, "estimatedRelaunchTime");
			return (Criteria) this;
		}

		public Criteria andEstimatedRelaunchTimeNotBetween(Date value1, Date value2) {
			addCriterion("ESTIMATED_RELAUNCH_TIME not between", value1, value2, "estimatedRelaunchTime");
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
