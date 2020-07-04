package com.myfun.repository.erpdb.po;

import com.myfun.repository.support.generator.shard.ShardDb;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ErpFunDealExample extends ShardDb {
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
	public ErpFunDealExample() {
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

		public Criteria andDealIdIsNull() {
			addCriterion("DEAL_ID is null");
			return (Criteria) this;
		}

		public Criteria andDealIdIsNotNull() {
			addCriterion("DEAL_ID is not null");
			return (Criteria) this;
		}

		public Criteria andDealIdEqualTo(Integer value) {
			addCriterion("DEAL_ID =", value, "dealId");
			return (Criteria) this;
		}

		public Criteria andDealIdNotEqualTo(Integer value) {
			addCriterion("DEAL_ID <>", value, "dealId");
			return (Criteria) this;
		}

		public Criteria andDealIdGreaterThan(Integer value) {
			addCriterion("DEAL_ID >", value, "dealId");
			return (Criteria) this;
		}

		public Criteria andDealIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("DEAL_ID >=", value, "dealId");
			return (Criteria) this;
		}

		public Criteria andDealIdLessThan(Integer value) {
			addCriterion("DEAL_ID <", value, "dealId");
			return (Criteria) this;
		}

		public Criteria andDealIdLessThanOrEqualTo(Integer value) {
			addCriterion("DEAL_ID <=", value, "dealId");
			return (Criteria) this;
		}

		public Criteria andDealIdIn(List<Integer> values) {
			addCriterion("DEAL_ID in", values, "dealId");
			return (Criteria) this;
		}

		public Criteria andDealIdNotIn(List<Integer> values) {
			addCriterion("DEAL_ID not in", values, "dealId");
			return (Criteria) this;
		}

		public Criteria andDealIdBetween(Integer value1, Integer value2) {
			addCriterion("DEAL_ID between", value1, value2, "dealId");
			return (Criteria) this;
		}

		public Criteria andDealIdNotBetween(Integer value1, Integer value2) {
			addCriterion("DEAL_ID not between", value1, value2, "dealId");
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

		public Criteria andAgreementNoIsNull() {
			addCriterion("AGREEMENT_NO is null");
			return (Criteria) this;
		}

		public Criteria andAgreementNoIsNotNull() {
			addCriterion("AGREEMENT_NO is not null");
			return (Criteria) this;
		}

		public Criteria andAgreementNoEqualTo(String value) {
			addCriterion("AGREEMENT_NO =", value, "agreementNo");
			return (Criteria) this;
		}

		public Criteria andAgreementNoNotEqualTo(String value) {
			addCriterion("AGREEMENT_NO <>", value, "agreementNo");
			return (Criteria) this;
		}

		public Criteria andAgreementNoGreaterThan(String value) {
			addCriterion("AGREEMENT_NO >", value, "agreementNo");
			return (Criteria) this;
		}

		public Criteria andAgreementNoGreaterThanOrEqualTo(String value) {
			addCriterion("AGREEMENT_NO >=", value, "agreementNo");
			return (Criteria) this;
		}

		public Criteria andAgreementNoLessThan(String value) {
			addCriterion("AGREEMENT_NO <", value, "agreementNo");
			return (Criteria) this;
		}

		public Criteria andAgreementNoLessThanOrEqualTo(String value) {
			addCriterion("AGREEMENT_NO <=", value, "agreementNo");
			return (Criteria) this;
		}

		public Criteria andAgreementNoLike(String value) {
			addCriterion("AGREEMENT_NO like", value, "agreementNo");
			return (Criteria) this;
		}

		public Criteria andAgreementNoNotLike(String value) {
			addCriterion("AGREEMENT_NO not like", value, "agreementNo");
			return (Criteria) this;
		}

		public Criteria andAgreementNoIn(List<String> values) {
			addCriterion("AGREEMENT_NO in", values, "agreementNo");
			return (Criteria) this;
		}

		public Criteria andAgreementNoNotIn(List<String> values) {
			addCriterion("AGREEMENT_NO not in", values, "agreementNo");
			return (Criteria) this;
		}

		public Criteria andAgreementNoBetween(String value1, String value2) {
			addCriterion("AGREEMENT_NO between", value1, value2, "agreementNo");
			return (Criteria) this;
		}

		public Criteria andAgreementNoNotBetween(String value1, String value2) {
			addCriterion("AGREEMENT_NO not between", value1, value2, "agreementNo");
			return (Criteria) this;
		}

		public Criteria andCreatorDateIsNull() {
			addCriterion("CREATOR_DATE is null");
			return (Criteria) this;
		}

		public Criteria andCreatorDateIsNotNull() {
			addCriterion("CREATOR_DATE is not null");
			return (Criteria) this;
		}

		public Criteria andCreatorDateEqualTo(String value) {
			addCriterion("CREATOR_DATE =", value, "creatorDate");
			return (Criteria) this;
		}

		public Criteria andCreatorDateNotEqualTo(String value) {
			addCriterion("CREATOR_DATE <>", value, "creatorDate");
			return (Criteria) this;
		}

		public Criteria andCreatorDateGreaterThan(String value) {
			addCriterion("CREATOR_DATE >", value, "creatorDate");
			return (Criteria) this;
		}

		public Criteria andCreatorDateGreaterThanOrEqualTo(String value) {
			addCriterion("CREATOR_DATE >=", value, "creatorDate");
			return (Criteria) this;
		}

		public Criteria andCreatorDateLessThan(String value) {
			addCriterion("CREATOR_DATE <", value, "creatorDate");
			return (Criteria) this;
		}

		public Criteria andCreatorDateLessThanOrEqualTo(String value) {
			addCriterion("CREATOR_DATE <=", value, "creatorDate");
			return (Criteria) this;
		}

		public Criteria andCreatorDateLike(String value) {
			addCriterion("CREATOR_DATE like", value, "creatorDate");
			return (Criteria) this;
		}

		public Criteria andCreatorDateNotLike(String value) {
			addCriterion("CREATOR_DATE not like", value, "creatorDate");
			return (Criteria) this;
		}

		public Criteria andCreatorDateIn(List<String> values) {
			addCriterion("CREATOR_DATE in", values, "creatorDate");
			return (Criteria) this;
		}

		public Criteria andCreatorDateNotIn(List<String> values) {
			addCriterion("CREATOR_DATE not in", values, "creatorDate");
			return (Criteria) this;
		}

		public Criteria andCreatorDateBetween(String value1, String value2) {
			addCriterion("CREATOR_DATE between", value1, value2, "creatorDate");
			return (Criteria) this;
		}

		public Criteria andCreatorDateNotBetween(String value1, String value2) {
			addCriterion("CREATOR_DATE not between", value1, value2, "creatorDate");
			return (Criteria) this;
		}

		public Criteria andDealTypeIsNull() {
			addCriterion("DEAL_TYPE is null");
			return (Criteria) this;
		}

		public Criteria andDealTypeIsNotNull() {
			addCriterion("DEAL_TYPE is not null");
			return (Criteria) this;
		}

		public Criteria andDealTypeEqualTo(Byte value) {
			addCriterion("DEAL_TYPE =", value, "dealType");
			return (Criteria) this;
		}

		public Criteria andDealTypeNotEqualTo(Byte value) {
			addCriterion("DEAL_TYPE <>", value, "dealType");
			return (Criteria) this;
		}

		public Criteria andDealTypeGreaterThan(Byte value) {
			addCriterion("DEAL_TYPE >", value, "dealType");
			return (Criteria) this;
		}

		public Criteria andDealTypeGreaterThanOrEqualTo(Byte value) {
			addCriterion("DEAL_TYPE >=", value, "dealType");
			return (Criteria) this;
		}

		public Criteria andDealTypeLessThan(Byte value) {
			addCriterion("DEAL_TYPE <", value, "dealType");
			return (Criteria) this;
		}

		public Criteria andDealTypeLessThanOrEqualTo(Byte value) {
			addCriterion("DEAL_TYPE <=", value, "dealType");
			return (Criteria) this;
		}

		public Criteria andDealTypeIn(List<Byte> values) {
			addCriterion("DEAL_TYPE in", values, "dealType");
			return (Criteria) this;
		}

		public Criteria andDealTypeNotIn(List<Byte> values) {
			addCriterion("DEAL_TYPE not in", values, "dealType");
			return (Criteria) this;
		}

		public Criteria andDealTypeBetween(Byte value1, Byte value2) {
			addCriterion("DEAL_TYPE between", value1, value2, "dealType");
			return (Criteria) this;
		}

		public Criteria andDealTypeNotBetween(Byte value1, Byte value2) {
			addCriterion("DEAL_TYPE not between", value1, value2, "dealType");
			return (Criteria) this;
		}

		public Criteria andDealStatusIsNull() {
			addCriterion("DEAL_STATUS is null");
			return (Criteria) this;
		}

		public Criteria andDealStatusIsNotNull() {
			addCriterion("DEAL_STATUS is not null");
			return (Criteria) this;
		}

		public Criteria andDealStatusEqualTo(Byte value) {
			addCriterion("DEAL_STATUS =", value, "dealStatus");
			return (Criteria) this;
		}

		public Criteria andDealStatusNotEqualTo(Byte value) {
			addCriterion("DEAL_STATUS <>", value, "dealStatus");
			return (Criteria) this;
		}

		public Criteria andDealStatusGreaterThan(Byte value) {
			addCriterion("DEAL_STATUS >", value, "dealStatus");
			return (Criteria) this;
		}

		public Criteria andDealStatusGreaterThanOrEqualTo(Byte value) {
			addCriterion("DEAL_STATUS >=", value, "dealStatus");
			return (Criteria) this;
		}

		public Criteria andDealStatusLessThan(Byte value) {
			addCriterion("DEAL_STATUS <", value, "dealStatus");
			return (Criteria) this;
		}

		public Criteria andDealStatusLessThanOrEqualTo(Byte value) {
			addCriterion("DEAL_STATUS <=", value, "dealStatus");
			return (Criteria) this;
		}

		public Criteria andDealStatusIn(List<Byte> values) {
			addCriterion("DEAL_STATUS in", values, "dealStatus");
			return (Criteria) this;
		}

		public Criteria andDealStatusNotIn(List<Byte> values) {
			addCriterion("DEAL_STATUS not in", values, "dealStatus");
			return (Criteria) this;
		}

		public Criteria andDealStatusBetween(Byte value1, Byte value2) {
			addCriterion("DEAL_STATUS between", value1, value2, "dealStatus");
			return (Criteria) this;
		}

		public Criteria andDealStatusNotBetween(Byte value1, Byte value2) {
			addCriterion("DEAL_STATUS not between", value1, value2, "dealStatus");
			return (Criteria) this;
		}

		public Criteria andDealUserIdIsNull() {
			addCriterion("DEAL_USER_ID is null");
			return (Criteria) this;
		}

		public Criteria andDealUserIdIsNotNull() {
			addCriterion("DEAL_USER_ID is not null");
			return (Criteria) this;
		}

		public Criteria andDealUserIdEqualTo(Integer value) {
			addCriterion("DEAL_USER_ID =", value, "dealUserId");
			return (Criteria) this;
		}

		public Criteria andDealUserIdNotEqualTo(Integer value) {
			addCriterion("DEAL_USER_ID <>", value, "dealUserId");
			return (Criteria) this;
		}

		public Criteria andDealUserIdGreaterThan(Integer value) {
			addCriterion("DEAL_USER_ID >", value, "dealUserId");
			return (Criteria) this;
		}

		public Criteria andDealUserIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("DEAL_USER_ID >=", value, "dealUserId");
			return (Criteria) this;
		}

		public Criteria andDealUserIdLessThan(Integer value) {
			addCriterion("DEAL_USER_ID <", value, "dealUserId");
			return (Criteria) this;
		}

		public Criteria andDealUserIdLessThanOrEqualTo(Integer value) {
			addCriterion("DEAL_USER_ID <=", value, "dealUserId");
			return (Criteria) this;
		}

		public Criteria andDealUserIdIn(List<Integer> values) {
			addCriterion("DEAL_USER_ID in", values, "dealUserId");
			return (Criteria) this;
		}

		public Criteria andDealUserIdNotIn(List<Integer> values) {
			addCriterion("DEAL_USER_ID not in", values, "dealUserId");
			return (Criteria) this;
		}

		public Criteria andDealUserIdBetween(Integer value1, Integer value2) {
			addCriterion("DEAL_USER_ID between", value1, value2, "dealUserId");
			return (Criteria) this;
		}

		public Criteria andDealUserIdNotBetween(Integer value1, Integer value2) {
			addCriterion("DEAL_USER_ID not between", value1, value2, "dealUserId");
			return (Criteria) this;
		}

		public Criteria andDealCompleteIsNull() {
			addCriterion("DEAL_COMPLETE is null");
			return (Criteria) this;
		}

		public Criteria andDealCompleteIsNotNull() {
			addCriterion("DEAL_COMPLETE is not null");
			return (Criteria) this;
		}

		public Criteria andDealCompleteEqualTo(Byte value) {
			addCriterion("DEAL_COMPLETE =", value, "dealComplete");
			return (Criteria) this;
		}

		public Criteria andDealCompleteNotEqualTo(Byte value) {
			addCriterion("DEAL_COMPLETE <>", value, "dealComplete");
			return (Criteria) this;
		}

		public Criteria andDealCompleteGreaterThan(Byte value) {
			addCriterion("DEAL_COMPLETE >", value, "dealComplete");
			return (Criteria) this;
		}

		public Criteria andDealCompleteGreaterThanOrEqualTo(Byte value) {
			addCriterion("DEAL_COMPLETE >=", value, "dealComplete");
			return (Criteria) this;
		}

		public Criteria andDealCompleteLessThan(Byte value) {
			addCriterion("DEAL_COMPLETE <", value, "dealComplete");
			return (Criteria) this;
		}

		public Criteria andDealCompleteLessThanOrEqualTo(Byte value) {
			addCriterion("DEAL_COMPLETE <=", value, "dealComplete");
			return (Criteria) this;
		}

		public Criteria andDealCompleteIn(List<Byte> values) {
			addCriterion("DEAL_COMPLETE in", values, "dealComplete");
			return (Criteria) this;
		}

		public Criteria andDealCompleteNotIn(List<Byte> values) {
			addCriterion("DEAL_COMPLETE not in", values, "dealComplete");
			return (Criteria) this;
		}

		public Criteria andDealCompleteBetween(Byte value1, Byte value2) {
			addCriterion("DEAL_COMPLETE between", value1, value2, "dealComplete");
			return (Criteria) this;
		}

		public Criteria andDealCompleteNotBetween(Byte value1, Byte value2) {
			addCriterion("DEAL_COMPLETE not between", value1, value2, "dealComplete");
			return (Criteria) this;
		}

		public Criteria andDealVerifyTimeIsNull() {
			addCriterion("DEAL_VERIFY_TIME is null");
			return (Criteria) this;
		}

		public Criteria andDealVerifyTimeIsNotNull() {
			addCriterion("DEAL_VERIFY_TIME is not null");
			return (Criteria) this;
		}

		public Criteria andDealVerifyTimeEqualTo(String value) {
			addCriterion("DEAL_VERIFY_TIME =", value, "dealVerifyTime");
			return (Criteria) this;
		}

		public Criteria andDealVerifyTimeNotEqualTo(String value) {
			addCriterion("DEAL_VERIFY_TIME <>", value, "dealVerifyTime");
			return (Criteria) this;
		}

		public Criteria andDealVerifyTimeGreaterThan(String value) {
			addCriterion("DEAL_VERIFY_TIME >", value, "dealVerifyTime");
			return (Criteria) this;
		}

		public Criteria andDealVerifyTimeGreaterThanOrEqualTo(String value) {
			addCriterion("DEAL_VERIFY_TIME >=", value, "dealVerifyTime");
			return (Criteria) this;
		}

		public Criteria andDealVerifyTimeLessThan(String value) {
			addCriterion("DEAL_VERIFY_TIME <", value, "dealVerifyTime");
			return (Criteria) this;
		}

		public Criteria andDealVerifyTimeLessThanOrEqualTo(String value) {
			addCriterion("DEAL_VERIFY_TIME <=", value, "dealVerifyTime");
			return (Criteria) this;
		}

		public Criteria andDealVerifyTimeLike(String value) {
			addCriterion("DEAL_VERIFY_TIME like", value, "dealVerifyTime");
			return (Criteria) this;
		}

		public Criteria andDealVerifyTimeNotLike(String value) {
			addCriterion("DEAL_VERIFY_TIME not like", value, "dealVerifyTime");
			return (Criteria) this;
		}

		public Criteria andDealVerifyTimeIn(List<String> values) {
			addCriterion("DEAL_VERIFY_TIME in", values, "dealVerifyTime");
			return (Criteria) this;
		}

		public Criteria andDealVerifyTimeNotIn(List<String> values) {
			addCriterion("DEAL_VERIFY_TIME not in", values, "dealVerifyTime");
			return (Criteria) this;
		}

		public Criteria andDealVerifyTimeBetween(String value1, String value2) {
			addCriterion("DEAL_VERIFY_TIME between", value1, value2, "dealVerifyTime");
			return (Criteria) this;
		}

		public Criteria andDealVerifyTimeNotBetween(String value1, String value2) {
			addCriterion("DEAL_VERIFY_TIME not between", value1, value2, "dealVerifyTime");
			return (Criteria) this;
		}

		public Criteria andDealBuyStyleIsNull() {
			addCriterion("DEAL_BUY_STYLE is null");
			return (Criteria) this;
		}

		public Criteria andDealBuyStyleIsNotNull() {
			addCriterion("DEAL_BUY_STYLE is not null");
			return (Criteria) this;
		}

		public Criteria andDealBuyStyleEqualTo(Byte value) {
			addCriterion("DEAL_BUY_STYLE =", value, "dealBuyStyle");
			return (Criteria) this;
		}

		public Criteria andDealBuyStyleNotEqualTo(Byte value) {
			addCriterion("DEAL_BUY_STYLE <>", value, "dealBuyStyle");
			return (Criteria) this;
		}

		public Criteria andDealBuyStyleGreaterThan(Byte value) {
			addCriterion("DEAL_BUY_STYLE >", value, "dealBuyStyle");
			return (Criteria) this;
		}

		public Criteria andDealBuyStyleGreaterThanOrEqualTo(Byte value) {
			addCriterion("DEAL_BUY_STYLE >=", value, "dealBuyStyle");
			return (Criteria) this;
		}

		public Criteria andDealBuyStyleLessThan(Byte value) {
			addCriterion("DEAL_BUY_STYLE <", value, "dealBuyStyle");
			return (Criteria) this;
		}

		public Criteria andDealBuyStyleLessThanOrEqualTo(Byte value) {
			addCriterion("DEAL_BUY_STYLE <=", value, "dealBuyStyle");
			return (Criteria) this;
		}

		public Criteria andDealBuyStyleIn(List<Byte> values) {
			addCriterion("DEAL_BUY_STYLE in", values, "dealBuyStyle");
			return (Criteria) this;
		}

		public Criteria andDealBuyStyleNotIn(List<Byte> values) {
			addCriterion("DEAL_BUY_STYLE not in", values, "dealBuyStyle");
			return (Criteria) this;
		}

		public Criteria andDealBuyStyleBetween(Byte value1, Byte value2) {
			addCriterion("DEAL_BUY_STYLE between", value1, value2, "dealBuyStyle");
			return (Criteria) this;
		}

		public Criteria andDealBuyStyleNotBetween(Byte value1, Byte value2) {
			addCriterion("DEAL_BUY_STYLE not between", value1, value2, "dealBuyStyle");
			return (Criteria) this;
		}

		public Criteria andDealSellStyleIsNull() {
			addCriterion("DEAL_SELL_STYLE is null");
			return (Criteria) this;
		}

		public Criteria andDealSellStyleIsNotNull() {
			addCriterion("DEAL_SELL_STYLE is not null");
			return (Criteria) this;
		}

		public Criteria andDealSellStyleEqualTo(Byte value) {
			addCriterion("DEAL_SELL_STYLE =", value, "dealSellStyle");
			return (Criteria) this;
		}

		public Criteria andDealSellStyleNotEqualTo(Byte value) {
			addCriterion("DEAL_SELL_STYLE <>", value, "dealSellStyle");
			return (Criteria) this;
		}

		public Criteria andDealSellStyleGreaterThan(Byte value) {
			addCriterion("DEAL_SELL_STYLE >", value, "dealSellStyle");
			return (Criteria) this;
		}

		public Criteria andDealSellStyleGreaterThanOrEqualTo(Byte value) {
			addCriterion("DEAL_SELL_STYLE >=", value, "dealSellStyle");
			return (Criteria) this;
		}

		public Criteria andDealSellStyleLessThan(Byte value) {
			addCriterion("DEAL_SELL_STYLE <", value, "dealSellStyle");
			return (Criteria) this;
		}

		public Criteria andDealSellStyleLessThanOrEqualTo(Byte value) {
			addCriterion("DEAL_SELL_STYLE <=", value, "dealSellStyle");
			return (Criteria) this;
		}

		public Criteria andDealSellStyleIn(List<Byte> values) {
			addCriterion("DEAL_SELL_STYLE in", values, "dealSellStyle");
			return (Criteria) this;
		}

		public Criteria andDealSellStyleNotIn(List<Byte> values) {
			addCriterion("DEAL_SELL_STYLE not in", values, "dealSellStyle");
			return (Criteria) this;
		}

		public Criteria andDealSellStyleBetween(Byte value1, Byte value2) {
			addCriterion("DEAL_SELL_STYLE between", value1, value2, "dealSellStyle");
			return (Criteria) this;
		}

		public Criteria andDealSellStyleNotBetween(Byte value1, Byte value2) {
			addCriterion("DEAL_SELL_STYLE not between", value1, value2, "dealSellStyle");
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

		public Criteria andDealCustomerIdIsNull() {
			addCriterion("DEAL_CUSTOMER_ID is null");
			return (Criteria) this;
		}

		public Criteria andDealCustomerIdIsNotNull() {
			addCriterion("DEAL_CUSTOMER_ID is not null");
			return (Criteria) this;
		}

		public Criteria andDealCustomerIdEqualTo(Integer value) {
			addCriterion("DEAL_CUSTOMER_ID =", value, "dealCustomerId");
			return (Criteria) this;
		}

		public Criteria andDealCustomerIdNotEqualTo(Integer value) {
			addCriterion("DEAL_CUSTOMER_ID <>", value, "dealCustomerId");
			return (Criteria) this;
		}

		public Criteria andDealCustomerIdGreaterThan(Integer value) {
			addCriterion("DEAL_CUSTOMER_ID >", value, "dealCustomerId");
			return (Criteria) this;
		}

		public Criteria andDealCustomerIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("DEAL_CUSTOMER_ID >=", value, "dealCustomerId");
			return (Criteria) this;
		}

		public Criteria andDealCustomerIdLessThan(Integer value) {
			addCriterion("DEAL_CUSTOMER_ID <", value, "dealCustomerId");
			return (Criteria) this;
		}

		public Criteria andDealCustomerIdLessThanOrEqualTo(Integer value) {
			addCriterion("DEAL_CUSTOMER_ID <=", value, "dealCustomerId");
			return (Criteria) this;
		}

		public Criteria andDealCustomerIdIn(List<Integer> values) {
			addCriterion("DEAL_CUSTOMER_ID in", values, "dealCustomerId");
			return (Criteria) this;
		}

		public Criteria andDealCustomerIdNotIn(List<Integer> values) {
			addCriterion("DEAL_CUSTOMER_ID not in", values, "dealCustomerId");
			return (Criteria) this;
		}

		public Criteria andDealCustomerIdBetween(Integer value1, Integer value2) {
			addCriterion("DEAL_CUSTOMER_ID between", value1, value2, "dealCustomerId");
			return (Criteria) this;
		}

		public Criteria andDealCustomerIdNotBetween(Integer value1, Integer value2) {
			addCriterion("DEAL_CUSTOMER_ID not between", value1, value2, "dealCustomerId");
			return (Criteria) this;
		}

		public Criteria andDealCustomerNoIsNull() {
			addCriterion("DEAL_CUSTOMER_NO is null");
			return (Criteria) this;
		}

		public Criteria andDealCustomerNoIsNotNull() {
			addCriterion("DEAL_CUSTOMER_NO is not null");
			return (Criteria) this;
		}

		public Criteria andDealCustomerNoEqualTo(String value) {
			addCriterion("DEAL_CUSTOMER_NO =", value, "dealCustomerNo");
			return (Criteria) this;
		}

		public Criteria andDealCustomerNoNotEqualTo(String value) {
			addCriterion("DEAL_CUSTOMER_NO <>", value, "dealCustomerNo");
			return (Criteria) this;
		}

		public Criteria andDealCustomerNoGreaterThan(String value) {
			addCriterion("DEAL_CUSTOMER_NO >", value, "dealCustomerNo");
			return (Criteria) this;
		}

		public Criteria andDealCustomerNoGreaterThanOrEqualTo(String value) {
			addCriterion("DEAL_CUSTOMER_NO >=", value, "dealCustomerNo");
			return (Criteria) this;
		}

		public Criteria andDealCustomerNoLessThan(String value) {
			addCriterion("DEAL_CUSTOMER_NO <", value, "dealCustomerNo");
			return (Criteria) this;
		}

		public Criteria andDealCustomerNoLessThanOrEqualTo(String value) {
			addCriterion("DEAL_CUSTOMER_NO <=", value, "dealCustomerNo");
			return (Criteria) this;
		}

		public Criteria andDealCustomerNoLike(String value) {
			addCriterion("DEAL_CUSTOMER_NO like", value, "dealCustomerNo");
			return (Criteria) this;
		}

		public Criteria andDealCustomerNoNotLike(String value) {
			addCriterion("DEAL_CUSTOMER_NO not like", value, "dealCustomerNo");
			return (Criteria) this;
		}

		public Criteria andDealCustomerNoIn(List<String> values) {
			addCriterion("DEAL_CUSTOMER_NO in", values, "dealCustomerNo");
			return (Criteria) this;
		}

		public Criteria andDealCustomerNoNotIn(List<String> values) {
			addCriterion("DEAL_CUSTOMER_NO not in", values, "dealCustomerNo");
			return (Criteria) this;
		}

		public Criteria andDealCustomerNoBetween(String value1, String value2) {
			addCriterion("DEAL_CUSTOMER_NO between", value1, value2, "dealCustomerNo");
			return (Criteria) this;
		}

		public Criteria andDealCustomerNoNotBetween(String value1, String value2) {
			addCriterion("DEAL_CUSTOMER_NO not between", value1, value2, "dealCustomerNo");
			return (Criteria) this;
		}

		public Criteria andDealHouseIdIsNull() {
			addCriterion("DEAL_HOUSE_ID is null");
			return (Criteria) this;
		}

		public Criteria andDealHouseIdIsNotNull() {
			addCriterion("DEAL_HOUSE_ID is not null");
			return (Criteria) this;
		}

		public Criteria andDealHouseIdEqualTo(Integer value) {
			addCriterion("DEAL_HOUSE_ID =", value, "dealHouseId");
			return (Criteria) this;
		}

		public Criteria andDealHouseIdNotEqualTo(Integer value) {
			addCriterion("DEAL_HOUSE_ID <>", value, "dealHouseId");
			return (Criteria) this;
		}

		public Criteria andDealHouseIdGreaterThan(Integer value) {
			addCriterion("DEAL_HOUSE_ID >", value, "dealHouseId");
			return (Criteria) this;
		}

		public Criteria andDealHouseIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("DEAL_HOUSE_ID >=", value, "dealHouseId");
			return (Criteria) this;
		}

		public Criteria andDealHouseIdLessThan(Integer value) {
			addCriterion("DEAL_HOUSE_ID <", value, "dealHouseId");
			return (Criteria) this;
		}

		public Criteria andDealHouseIdLessThanOrEqualTo(Integer value) {
			addCriterion("DEAL_HOUSE_ID <=", value, "dealHouseId");
			return (Criteria) this;
		}

		public Criteria andDealHouseIdIn(List<Integer> values) {
			addCriterion("DEAL_HOUSE_ID in", values, "dealHouseId");
			return (Criteria) this;
		}

		public Criteria andDealHouseIdNotIn(List<Integer> values) {
			addCriterion("DEAL_HOUSE_ID not in", values, "dealHouseId");
			return (Criteria) this;
		}

		public Criteria andDealHouseIdBetween(Integer value1, Integer value2) {
			addCriterion("DEAL_HOUSE_ID between", value1, value2, "dealHouseId");
			return (Criteria) this;
		}

		public Criteria andDealHouseIdNotBetween(Integer value1, Integer value2) {
			addCriterion("DEAL_HOUSE_ID not between", value1, value2, "dealHouseId");
			return (Criteria) this;
		}

		public Criteria andDealHouseNoIsNull() {
			addCriterion("DEAL_HOUSE_NO is null");
			return (Criteria) this;
		}

		public Criteria andDealHouseNoIsNotNull() {
			addCriterion("DEAL_HOUSE_NO is not null");
			return (Criteria) this;
		}

		public Criteria andDealHouseNoEqualTo(String value) {
			addCriterion("DEAL_HOUSE_NO =", value, "dealHouseNo");
			return (Criteria) this;
		}

		public Criteria andDealHouseNoNotEqualTo(String value) {
			addCriterion("DEAL_HOUSE_NO <>", value, "dealHouseNo");
			return (Criteria) this;
		}

		public Criteria andDealHouseNoGreaterThan(String value) {
			addCriterion("DEAL_HOUSE_NO >", value, "dealHouseNo");
			return (Criteria) this;
		}

		public Criteria andDealHouseNoGreaterThanOrEqualTo(String value) {
			addCriterion("DEAL_HOUSE_NO >=", value, "dealHouseNo");
			return (Criteria) this;
		}

		public Criteria andDealHouseNoLessThan(String value) {
			addCriterion("DEAL_HOUSE_NO <", value, "dealHouseNo");
			return (Criteria) this;
		}

		public Criteria andDealHouseNoLessThanOrEqualTo(String value) {
			addCriterion("DEAL_HOUSE_NO <=", value, "dealHouseNo");
			return (Criteria) this;
		}

		public Criteria andDealHouseNoLike(String value) {
			addCriterion("DEAL_HOUSE_NO like", value, "dealHouseNo");
			return (Criteria) this;
		}

		public Criteria andDealHouseNoNotLike(String value) {
			addCriterion("DEAL_HOUSE_NO not like", value, "dealHouseNo");
			return (Criteria) this;
		}

		public Criteria andDealHouseNoIn(List<String> values) {
			addCriterion("DEAL_HOUSE_NO in", values, "dealHouseNo");
			return (Criteria) this;
		}

		public Criteria andDealHouseNoNotIn(List<String> values) {
			addCriterion("DEAL_HOUSE_NO not in", values, "dealHouseNo");
			return (Criteria) this;
		}

		public Criteria andDealHouseNoBetween(String value1, String value2) {
			addCriterion("DEAL_HOUSE_NO between", value1, value2, "dealHouseNo");
			return (Criteria) this;
		}

		public Criteria andDealHouseNoNotBetween(String value1, String value2) {
			addCriterion("DEAL_HOUSE_NO not between", value1, value2, "dealHouseNo");
			return (Criteria) this;
		}

		public Criteria andSellAddressIsNull() {
			addCriterion("SELL_ADDRESS is null");
			return (Criteria) this;
		}

		public Criteria andSellAddressIsNotNull() {
			addCriterion("SELL_ADDRESS is not null");
			return (Criteria) this;
		}

		public Criteria andSellAddressEqualTo(String value) {
			addCriterion("SELL_ADDRESS =", value, "sellAddress");
			return (Criteria) this;
		}

		public Criteria andSellAddressNotEqualTo(String value) {
			addCriterion("SELL_ADDRESS <>", value, "sellAddress");
			return (Criteria) this;
		}

		public Criteria andSellAddressGreaterThan(String value) {
			addCriterion("SELL_ADDRESS >", value, "sellAddress");
			return (Criteria) this;
		}

		public Criteria andSellAddressGreaterThanOrEqualTo(String value) {
			addCriterion("SELL_ADDRESS >=", value, "sellAddress");
			return (Criteria) this;
		}

		public Criteria andSellAddressLessThan(String value) {
			addCriterion("SELL_ADDRESS <", value, "sellAddress");
			return (Criteria) this;
		}

		public Criteria andSellAddressLessThanOrEqualTo(String value) {
			addCriterion("SELL_ADDRESS <=", value, "sellAddress");
			return (Criteria) this;
		}

		public Criteria andSellAddressLike(String value) {
			addCriterion("SELL_ADDRESS like", value, "sellAddress");
			return (Criteria) this;
		}

		public Criteria andSellAddressNotLike(String value) {
			addCriterion("SELL_ADDRESS not like", value, "sellAddress");
			return (Criteria) this;
		}

		public Criteria andSellAddressIn(List<String> values) {
			addCriterion("SELL_ADDRESS in", values, "sellAddress");
			return (Criteria) this;
		}

		public Criteria andSellAddressNotIn(List<String> values) {
			addCriterion("SELL_ADDRESS not in", values, "sellAddress");
			return (Criteria) this;
		}

		public Criteria andSellAddressBetween(String value1, String value2) {
			addCriterion("SELL_ADDRESS between", value1, value2, "sellAddress");
			return (Criteria) this;
		}

		public Criteria andSellAddressNotBetween(String value1, String value2) {
			addCriterion("SELL_ADDRESS not between", value1, value2, "sellAddress");
			return (Criteria) this;
		}

		public Criteria andBuyCustinfoIsNull() {
			addCriterion("BUY_CUSTINFO is null");
			return (Criteria) this;
		}

		public Criteria andBuyCustinfoIsNotNull() {
			addCriterion("BUY_CUSTINFO is not null");
			return (Criteria) this;
		}

		public Criteria andBuyCustinfoEqualTo(String value) {
			addCriterion("BUY_CUSTINFO =", value, "buyCustinfo");
			return (Criteria) this;
		}

		public Criteria andBuyCustinfoNotEqualTo(String value) {
			addCriterion("BUY_CUSTINFO <>", value, "buyCustinfo");
			return (Criteria) this;
		}

		public Criteria andBuyCustinfoGreaterThan(String value) {
			addCriterion("BUY_CUSTINFO >", value, "buyCustinfo");
			return (Criteria) this;
		}

		public Criteria andBuyCustinfoGreaterThanOrEqualTo(String value) {
			addCriterion("BUY_CUSTINFO >=", value, "buyCustinfo");
			return (Criteria) this;
		}

		public Criteria andBuyCustinfoLessThan(String value) {
			addCriterion("BUY_CUSTINFO <", value, "buyCustinfo");
			return (Criteria) this;
		}

		public Criteria andBuyCustinfoLessThanOrEqualTo(String value) {
			addCriterion("BUY_CUSTINFO <=", value, "buyCustinfo");
			return (Criteria) this;
		}

		public Criteria andBuyCustinfoLike(String value) {
			addCriterion("BUY_CUSTINFO like", value, "buyCustinfo");
			return (Criteria) this;
		}

		public Criteria andBuyCustinfoNotLike(String value) {
			addCriterion("BUY_CUSTINFO not like", value, "buyCustinfo");
			return (Criteria) this;
		}

		public Criteria andBuyCustinfoIn(List<String> values) {
			addCriterion("BUY_CUSTINFO in", values, "buyCustinfo");
			return (Criteria) this;
		}

		public Criteria andBuyCustinfoNotIn(List<String> values) {
			addCriterion("BUY_CUSTINFO not in", values, "buyCustinfo");
			return (Criteria) this;
		}

		public Criteria andBuyCustinfoBetween(String value1, String value2) {
			addCriterion("BUY_CUSTINFO between", value1, value2, "buyCustinfo");
			return (Criteria) this;
		}

		public Criteria andBuyCustinfoNotBetween(String value1, String value2) {
			addCriterion("BUY_CUSTINFO not between", value1, value2, "buyCustinfo");
			return (Criteria) this;
		}

		public Criteria andSellHezuoCompnameIsNull() {
			addCriterion("SELL_HEZUO_COMPNAME is null");
			return (Criteria) this;
		}

		public Criteria andSellHezuoCompnameIsNotNull() {
			addCriterion("SELL_HEZUO_COMPNAME is not null");
			return (Criteria) this;
		}

		public Criteria andSellHezuoCompnameEqualTo(String value) {
			addCriterion("SELL_HEZUO_COMPNAME =", value, "sellHezuoCompname");
			return (Criteria) this;
		}

		public Criteria andSellHezuoCompnameNotEqualTo(String value) {
			addCriterion("SELL_HEZUO_COMPNAME <>", value, "sellHezuoCompname");
			return (Criteria) this;
		}

		public Criteria andSellHezuoCompnameGreaterThan(String value) {
			addCriterion("SELL_HEZUO_COMPNAME >", value, "sellHezuoCompname");
			return (Criteria) this;
		}

		public Criteria andSellHezuoCompnameGreaterThanOrEqualTo(String value) {
			addCriterion("SELL_HEZUO_COMPNAME >=", value, "sellHezuoCompname");
			return (Criteria) this;
		}

		public Criteria andSellHezuoCompnameLessThan(String value) {
			addCriterion("SELL_HEZUO_COMPNAME <", value, "sellHezuoCompname");
			return (Criteria) this;
		}

		public Criteria andSellHezuoCompnameLessThanOrEqualTo(String value) {
			addCriterion("SELL_HEZUO_COMPNAME <=", value, "sellHezuoCompname");
			return (Criteria) this;
		}

		public Criteria andSellHezuoCompnameLike(String value) {
			addCriterion("SELL_HEZUO_COMPNAME like", value, "sellHezuoCompname");
			return (Criteria) this;
		}

		public Criteria andSellHezuoCompnameNotLike(String value) {
			addCriterion("SELL_HEZUO_COMPNAME not like", value, "sellHezuoCompname");
			return (Criteria) this;
		}

		public Criteria andSellHezuoCompnameIn(List<String> values) {
			addCriterion("SELL_HEZUO_COMPNAME in", values, "sellHezuoCompname");
			return (Criteria) this;
		}

		public Criteria andSellHezuoCompnameNotIn(List<String> values) {
			addCriterion("SELL_HEZUO_COMPNAME not in", values, "sellHezuoCompname");
			return (Criteria) this;
		}

		public Criteria andSellHezuoCompnameBetween(String value1, String value2) {
			addCriterion("SELL_HEZUO_COMPNAME between", value1, value2, "sellHezuoCompname");
			return (Criteria) this;
		}

		public Criteria andSellHezuoCompnameNotBetween(String value1, String value2) {
			addCriterion("SELL_HEZUO_COMPNAME not between", value1, value2, "sellHezuoCompname");
			return (Criteria) this;
		}

		public Criteria andBuyHezuoCompnameIsNull() {
			addCriterion("BUY_HEZUO_COMPNAME is null");
			return (Criteria) this;
		}

		public Criteria andBuyHezuoCompnameIsNotNull() {
			addCriterion("BUY_HEZUO_COMPNAME is not null");
			return (Criteria) this;
		}

		public Criteria andBuyHezuoCompnameEqualTo(String value) {
			addCriterion("BUY_HEZUO_COMPNAME =", value, "buyHezuoCompname");
			return (Criteria) this;
		}

		public Criteria andBuyHezuoCompnameNotEqualTo(String value) {
			addCriterion("BUY_HEZUO_COMPNAME <>", value, "buyHezuoCompname");
			return (Criteria) this;
		}

		public Criteria andBuyHezuoCompnameGreaterThan(String value) {
			addCriterion("BUY_HEZUO_COMPNAME >", value, "buyHezuoCompname");
			return (Criteria) this;
		}

		public Criteria andBuyHezuoCompnameGreaterThanOrEqualTo(String value) {
			addCriterion("BUY_HEZUO_COMPNAME >=", value, "buyHezuoCompname");
			return (Criteria) this;
		}

		public Criteria andBuyHezuoCompnameLessThan(String value) {
			addCriterion("BUY_HEZUO_COMPNAME <", value, "buyHezuoCompname");
			return (Criteria) this;
		}

		public Criteria andBuyHezuoCompnameLessThanOrEqualTo(String value) {
			addCriterion("BUY_HEZUO_COMPNAME <=", value, "buyHezuoCompname");
			return (Criteria) this;
		}

		public Criteria andBuyHezuoCompnameLike(String value) {
			addCriterion("BUY_HEZUO_COMPNAME like", value, "buyHezuoCompname");
			return (Criteria) this;
		}

		public Criteria andBuyHezuoCompnameNotLike(String value) {
			addCriterion("BUY_HEZUO_COMPNAME not like", value, "buyHezuoCompname");
			return (Criteria) this;
		}

		public Criteria andBuyHezuoCompnameIn(List<String> values) {
			addCriterion("BUY_HEZUO_COMPNAME in", values, "buyHezuoCompname");
			return (Criteria) this;
		}

		public Criteria andBuyHezuoCompnameNotIn(List<String> values) {
			addCriterion("BUY_HEZUO_COMPNAME not in", values, "buyHezuoCompname");
			return (Criteria) this;
		}

		public Criteria andBuyHezuoCompnameBetween(String value1, String value2) {
			addCriterion("BUY_HEZUO_COMPNAME between", value1, value2, "buyHezuoCompname");
			return (Criteria) this;
		}

		public Criteria andBuyHezuoCompnameNotBetween(String value1, String value2) {
			addCriterion("BUY_HEZUO_COMPNAME not between", value1, value2, "buyHezuoCompname");
			return (Criteria) this;
		}

		public Criteria andBuyContactuserIsNull() {
			addCriterion("BUY_CONTACTUSER is null");
			return (Criteria) this;
		}

		public Criteria andBuyContactuserIsNotNull() {
			addCriterion("BUY_CONTACTUSER is not null");
			return (Criteria) this;
		}

		public Criteria andBuyContactuserEqualTo(String value) {
			addCriterion("BUY_CONTACTUSER =", value, "buyContactuser");
			return (Criteria) this;
		}

		public Criteria andBuyContactuserNotEqualTo(String value) {
			addCriterion("BUY_CONTACTUSER <>", value, "buyContactuser");
			return (Criteria) this;
		}

		public Criteria andBuyContactuserGreaterThan(String value) {
			addCriterion("BUY_CONTACTUSER >", value, "buyContactuser");
			return (Criteria) this;
		}

		public Criteria andBuyContactuserGreaterThanOrEqualTo(String value) {
			addCriterion("BUY_CONTACTUSER >=", value, "buyContactuser");
			return (Criteria) this;
		}

		public Criteria andBuyContactuserLessThan(String value) {
			addCriterion("BUY_CONTACTUSER <", value, "buyContactuser");
			return (Criteria) this;
		}

		public Criteria andBuyContactuserLessThanOrEqualTo(String value) {
			addCriterion("BUY_CONTACTUSER <=", value, "buyContactuser");
			return (Criteria) this;
		}

		public Criteria andBuyContactuserLike(String value) {
			addCriterion("BUY_CONTACTUSER like", value, "buyContactuser");
			return (Criteria) this;
		}

		public Criteria andBuyContactuserNotLike(String value) {
			addCriterion("BUY_CONTACTUSER not like", value, "buyContactuser");
			return (Criteria) this;
		}

		public Criteria andBuyContactuserIn(List<String> values) {
			addCriterion("BUY_CONTACTUSER in", values, "buyContactuser");
			return (Criteria) this;
		}

		public Criteria andBuyContactuserNotIn(List<String> values) {
			addCriterion("BUY_CONTACTUSER not in", values, "buyContactuser");
			return (Criteria) this;
		}

		public Criteria andBuyContactuserBetween(String value1, String value2) {
			addCriterion("BUY_CONTACTUSER between", value1, value2, "buyContactuser");
			return (Criteria) this;
		}

		public Criteria andBuyContactuserNotBetween(String value1, String value2) {
			addCriterion("BUY_CONTACTUSER not between", value1, value2, "buyContactuser");
			return (Criteria) this;
		}

		public Criteria andSellContactuserIsNull() {
			addCriterion("SELL_CONTACTUSER is null");
			return (Criteria) this;
		}

		public Criteria andSellContactuserIsNotNull() {
			addCriterion("SELL_CONTACTUSER is not null");
			return (Criteria) this;
		}

		public Criteria andSellContactuserEqualTo(String value) {
			addCriterion("SELL_CONTACTUSER =", value, "sellContactuser");
			return (Criteria) this;
		}

		public Criteria andSellContactuserNotEqualTo(String value) {
			addCriterion("SELL_CONTACTUSER <>", value, "sellContactuser");
			return (Criteria) this;
		}

		public Criteria andSellContactuserGreaterThan(String value) {
			addCriterion("SELL_CONTACTUSER >", value, "sellContactuser");
			return (Criteria) this;
		}

		public Criteria andSellContactuserGreaterThanOrEqualTo(String value) {
			addCriterion("SELL_CONTACTUSER >=", value, "sellContactuser");
			return (Criteria) this;
		}

		public Criteria andSellContactuserLessThan(String value) {
			addCriterion("SELL_CONTACTUSER <", value, "sellContactuser");
			return (Criteria) this;
		}

		public Criteria andSellContactuserLessThanOrEqualTo(String value) {
			addCriterion("SELL_CONTACTUSER <=", value, "sellContactuser");
			return (Criteria) this;
		}

		public Criteria andSellContactuserLike(String value) {
			addCriterion("SELL_CONTACTUSER like", value, "sellContactuser");
			return (Criteria) this;
		}

		public Criteria andSellContactuserNotLike(String value) {
			addCriterion("SELL_CONTACTUSER not like", value, "sellContactuser");
			return (Criteria) this;
		}

		public Criteria andSellContactuserIn(List<String> values) {
			addCriterion("SELL_CONTACTUSER in", values, "sellContactuser");
			return (Criteria) this;
		}

		public Criteria andSellContactuserNotIn(List<String> values) {
			addCriterion("SELL_CONTACTUSER not in", values, "sellContactuser");
			return (Criteria) this;
		}

		public Criteria andSellContactuserBetween(String value1, String value2) {
			addCriterion("SELL_CONTACTUSER between", value1, value2, "sellContactuser");
			return (Criteria) this;
		}

		public Criteria andSellContactuserNotBetween(String value1, String value2) {
			addCriterion("SELL_CONTACTUSER not between", value1, value2, "sellContactuser");
			return (Criteria) this;
		}

		public Criteria andBuyOwnerNameIsNull() {
			addCriterion("BUY_OWNER_NAME is null");
			return (Criteria) this;
		}

		public Criteria andBuyOwnerNameIsNotNull() {
			addCriterion("BUY_OWNER_NAME is not null");
			return (Criteria) this;
		}

		public Criteria andBuyOwnerNameEqualTo(String value) {
			addCriterion("BUY_OWNER_NAME =", value, "buyOwnerName");
			return (Criteria) this;
		}

		public Criteria andBuyOwnerNameNotEqualTo(String value) {
			addCriterion("BUY_OWNER_NAME <>", value, "buyOwnerName");
			return (Criteria) this;
		}

		public Criteria andBuyOwnerNameGreaterThan(String value) {
			addCriterion("BUY_OWNER_NAME >", value, "buyOwnerName");
			return (Criteria) this;
		}

		public Criteria andBuyOwnerNameGreaterThanOrEqualTo(String value) {
			addCriterion("BUY_OWNER_NAME >=", value, "buyOwnerName");
			return (Criteria) this;
		}

		public Criteria andBuyOwnerNameLessThan(String value) {
			addCriterion("BUY_OWNER_NAME <", value, "buyOwnerName");
			return (Criteria) this;
		}

		public Criteria andBuyOwnerNameLessThanOrEqualTo(String value) {
			addCriterion("BUY_OWNER_NAME <=", value, "buyOwnerName");
			return (Criteria) this;
		}

		public Criteria andBuyOwnerNameLike(String value) {
			addCriterion("BUY_OWNER_NAME like", value, "buyOwnerName");
			return (Criteria) this;
		}

		public Criteria andBuyOwnerNameNotLike(String value) {
			addCriterion("BUY_OWNER_NAME not like", value, "buyOwnerName");
			return (Criteria) this;
		}

		public Criteria andBuyOwnerNameIn(List<String> values) {
			addCriterion("BUY_OWNER_NAME in", values, "buyOwnerName");
			return (Criteria) this;
		}

		public Criteria andBuyOwnerNameNotIn(List<String> values) {
			addCriterion("BUY_OWNER_NAME not in", values, "buyOwnerName");
			return (Criteria) this;
		}

		public Criteria andBuyOwnerNameBetween(String value1, String value2) {
			addCriterion("BUY_OWNER_NAME between", value1, value2, "buyOwnerName");
			return (Criteria) this;
		}

		public Criteria andBuyOwnerNameNotBetween(String value1, String value2) {
			addCriterion("BUY_OWNER_NAME not between", value1, value2, "buyOwnerName");
			return (Criteria) this;
		}

		public Criteria andSellOwnerNameIsNull() {
			addCriterion("SELL_OWNER_NAME is null");
			return (Criteria) this;
		}

		public Criteria andSellOwnerNameIsNotNull() {
			addCriterion("SELL_OWNER_NAME is not null");
			return (Criteria) this;
		}

		public Criteria andSellOwnerNameEqualTo(String value) {
			addCriterion("SELL_OWNER_NAME =", value, "sellOwnerName");
			return (Criteria) this;
		}

		public Criteria andSellOwnerNameNotEqualTo(String value) {
			addCriterion("SELL_OWNER_NAME <>", value, "sellOwnerName");
			return (Criteria) this;
		}

		public Criteria andSellOwnerNameGreaterThan(String value) {
			addCriterion("SELL_OWNER_NAME >", value, "sellOwnerName");
			return (Criteria) this;
		}

		public Criteria andSellOwnerNameGreaterThanOrEqualTo(String value) {
			addCriterion("SELL_OWNER_NAME >=", value, "sellOwnerName");
			return (Criteria) this;
		}

		public Criteria andSellOwnerNameLessThan(String value) {
			addCriterion("SELL_OWNER_NAME <", value, "sellOwnerName");
			return (Criteria) this;
		}

		public Criteria andSellOwnerNameLessThanOrEqualTo(String value) {
			addCriterion("SELL_OWNER_NAME <=", value, "sellOwnerName");
			return (Criteria) this;
		}

		public Criteria andSellOwnerNameLike(String value) {
			addCriterion("SELL_OWNER_NAME like", value, "sellOwnerName");
			return (Criteria) this;
		}

		public Criteria andSellOwnerNameNotLike(String value) {
			addCriterion("SELL_OWNER_NAME not like", value, "sellOwnerName");
			return (Criteria) this;
		}

		public Criteria andSellOwnerNameIn(List<String> values) {
			addCriterion("SELL_OWNER_NAME in", values, "sellOwnerName");
			return (Criteria) this;
		}

		public Criteria andSellOwnerNameNotIn(List<String> values) {
			addCriterion("SELL_OWNER_NAME not in", values, "sellOwnerName");
			return (Criteria) this;
		}

		public Criteria andSellOwnerNameBetween(String value1, String value2) {
			addCriterion("SELL_OWNER_NAME between", value1, value2, "sellOwnerName");
			return (Criteria) this;
		}

		public Criteria andSellOwnerNameNotBetween(String value1, String value2) {
			addCriterion("SELL_OWNER_NAME not between", value1, value2, "sellOwnerName");
			return (Criteria) this;
		}

		public Criteria andBuyCallPhoneIsNull() {
			addCriterion("BUY_CALL_PHONE is null");
			return (Criteria) this;
		}

		public Criteria andBuyCallPhoneIsNotNull() {
			addCriterion("BUY_CALL_PHONE is not null");
			return (Criteria) this;
		}

		public Criteria andBuyCallPhoneEqualTo(String value) {
			addCriterion("BUY_CALL_PHONE =", value, "buyCallPhone");
			return (Criteria) this;
		}

		public Criteria andBuyCallPhoneNotEqualTo(String value) {
			addCriterion("BUY_CALL_PHONE <>", value, "buyCallPhone");
			return (Criteria) this;
		}

		public Criteria andBuyCallPhoneGreaterThan(String value) {
			addCriterion("BUY_CALL_PHONE >", value, "buyCallPhone");
			return (Criteria) this;
		}

		public Criteria andBuyCallPhoneGreaterThanOrEqualTo(String value) {
			addCriterion("BUY_CALL_PHONE >=", value, "buyCallPhone");
			return (Criteria) this;
		}

		public Criteria andBuyCallPhoneLessThan(String value) {
			addCriterion("BUY_CALL_PHONE <", value, "buyCallPhone");
			return (Criteria) this;
		}

		public Criteria andBuyCallPhoneLessThanOrEqualTo(String value) {
			addCriterion("BUY_CALL_PHONE <=", value, "buyCallPhone");
			return (Criteria) this;
		}

		public Criteria andBuyCallPhoneLike(String value) {
			addCriterion("BUY_CALL_PHONE like", value, "buyCallPhone");
			return (Criteria) this;
		}

		public Criteria andBuyCallPhoneNotLike(String value) {
			addCriterion("BUY_CALL_PHONE not like", value, "buyCallPhone");
			return (Criteria) this;
		}

		public Criteria andBuyCallPhoneIn(List<String> values) {
			addCriterion("BUY_CALL_PHONE in", values, "buyCallPhone");
			return (Criteria) this;
		}

		public Criteria andBuyCallPhoneNotIn(List<String> values) {
			addCriterion("BUY_CALL_PHONE not in", values, "buyCallPhone");
			return (Criteria) this;
		}

		public Criteria andBuyCallPhoneBetween(String value1, String value2) {
			addCriterion("BUY_CALL_PHONE between", value1, value2, "buyCallPhone");
			return (Criteria) this;
		}

		public Criteria andBuyCallPhoneNotBetween(String value1, String value2) {
			addCriterion("BUY_CALL_PHONE not between", value1, value2, "buyCallPhone");
			return (Criteria) this;
		}

		public Criteria andSellCallPhoneIsNull() {
			addCriterion("SELL_CALL_PHONE is null");
			return (Criteria) this;
		}

		public Criteria andSellCallPhoneIsNotNull() {
			addCriterion("SELL_CALL_PHONE is not null");
			return (Criteria) this;
		}

		public Criteria andSellCallPhoneEqualTo(String value) {
			addCriterion("SELL_CALL_PHONE =", value, "sellCallPhone");
			return (Criteria) this;
		}

		public Criteria andSellCallPhoneNotEqualTo(String value) {
			addCriterion("SELL_CALL_PHONE <>", value, "sellCallPhone");
			return (Criteria) this;
		}

		public Criteria andSellCallPhoneGreaterThan(String value) {
			addCriterion("SELL_CALL_PHONE >", value, "sellCallPhone");
			return (Criteria) this;
		}

		public Criteria andSellCallPhoneGreaterThanOrEqualTo(String value) {
			addCriterion("SELL_CALL_PHONE >=", value, "sellCallPhone");
			return (Criteria) this;
		}

		public Criteria andSellCallPhoneLessThan(String value) {
			addCriterion("SELL_CALL_PHONE <", value, "sellCallPhone");
			return (Criteria) this;
		}

		public Criteria andSellCallPhoneLessThanOrEqualTo(String value) {
			addCriterion("SELL_CALL_PHONE <=", value, "sellCallPhone");
			return (Criteria) this;
		}

		public Criteria andSellCallPhoneLike(String value) {
			addCriterion("SELL_CALL_PHONE like", value, "sellCallPhone");
			return (Criteria) this;
		}

		public Criteria andSellCallPhoneNotLike(String value) {
			addCriterion("SELL_CALL_PHONE not like", value, "sellCallPhone");
			return (Criteria) this;
		}

		public Criteria andSellCallPhoneIn(List<String> values) {
			addCriterion("SELL_CALL_PHONE in", values, "sellCallPhone");
			return (Criteria) this;
		}

		public Criteria andSellCallPhoneNotIn(List<String> values) {
			addCriterion("SELL_CALL_PHONE not in", values, "sellCallPhone");
			return (Criteria) this;
		}

		public Criteria andSellCallPhoneBetween(String value1, String value2) {
			addCriterion("SELL_CALL_PHONE between", value1, value2, "sellCallPhone");
			return (Criteria) this;
		}

		public Criteria andSellCallPhoneNotBetween(String value1, String value2) {
			addCriterion("SELL_CALL_PHONE not between", value1, value2, "sellCallPhone");
			return (Criteria) this;
		}

		public Criteria andBuyIdCardIsNull() {
			addCriterion("BUY_ID_CARD is null");
			return (Criteria) this;
		}

		public Criteria andBuyIdCardIsNotNull() {
			addCriterion("BUY_ID_CARD is not null");
			return (Criteria) this;
		}

		public Criteria andBuyIdCardEqualTo(String value) {
			addCriterion("BUY_ID_CARD =", value, "buyIdCard");
			return (Criteria) this;
		}

		public Criteria andBuyIdCardNotEqualTo(String value) {
			addCriterion("BUY_ID_CARD <>", value, "buyIdCard");
			return (Criteria) this;
		}

		public Criteria andBuyIdCardGreaterThan(String value) {
			addCriterion("BUY_ID_CARD >", value, "buyIdCard");
			return (Criteria) this;
		}

		public Criteria andBuyIdCardGreaterThanOrEqualTo(String value) {
			addCriterion("BUY_ID_CARD >=", value, "buyIdCard");
			return (Criteria) this;
		}

		public Criteria andBuyIdCardLessThan(String value) {
			addCriterion("BUY_ID_CARD <", value, "buyIdCard");
			return (Criteria) this;
		}

		public Criteria andBuyIdCardLessThanOrEqualTo(String value) {
			addCriterion("BUY_ID_CARD <=", value, "buyIdCard");
			return (Criteria) this;
		}

		public Criteria andBuyIdCardLike(String value) {
			addCriterion("BUY_ID_CARD like", value, "buyIdCard");
			return (Criteria) this;
		}

		public Criteria andBuyIdCardNotLike(String value) {
			addCriterion("BUY_ID_CARD not like", value, "buyIdCard");
			return (Criteria) this;
		}

		public Criteria andBuyIdCardIn(List<String> values) {
			addCriterion("BUY_ID_CARD in", values, "buyIdCard");
			return (Criteria) this;
		}

		public Criteria andBuyIdCardNotIn(List<String> values) {
			addCriterion("BUY_ID_CARD not in", values, "buyIdCard");
			return (Criteria) this;
		}

		public Criteria andBuyIdCardBetween(String value1, String value2) {
			addCriterion("BUY_ID_CARD between", value1, value2, "buyIdCard");
			return (Criteria) this;
		}

		public Criteria andBuyIdCardNotBetween(String value1, String value2) {
			addCriterion("BUY_ID_CARD not between", value1, value2, "buyIdCard");
			return (Criteria) this;
		}

		public Criteria andSellIdCardIsNull() {
			addCriterion("SELL_ID_CARD is null");
			return (Criteria) this;
		}

		public Criteria andSellIdCardIsNotNull() {
			addCriterion("SELL_ID_CARD is not null");
			return (Criteria) this;
		}

		public Criteria andSellIdCardEqualTo(String value) {
			addCriterion("SELL_ID_CARD =", value, "sellIdCard");
			return (Criteria) this;
		}

		public Criteria andSellIdCardNotEqualTo(String value) {
			addCriterion("SELL_ID_CARD <>", value, "sellIdCard");
			return (Criteria) this;
		}

		public Criteria andSellIdCardGreaterThan(String value) {
			addCriterion("SELL_ID_CARD >", value, "sellIdCard");
			return (Criteria) this;
		}

		public Criteria andSellIdCardGreaterThanOrEqualTo(String value) {
			addCriterion("SELL_ID_CARD >=", value, "sellIdCard");
			return (Criteria) this;
		}

		public Criteria andSellIdCardLessThan(String value) {
			addCriterion("SELL_ID_CARD <", value, "sellIdCard");
			return (Criteria) this;
		}

		public Criteria andSellIdCardLessThanOrEqualTo(String value) {
			addCriterion("SELL_ID_CARD <=", value, "sellIdCard");
			return (Criteria) this;
		}

		public Criteria andSellIdCardLike(String value) {
			addCriterion("SELL_ID_CARD like", value, "sellIdCard");
			return (Criteria) this;
		}

		public Criteria andSellIdCardNotLike(String value) {
			addCriterion("SELL_ID_CARD not like", value, "sellIdCard");
			return (Criteria) this;
		}

		public Criteria andSellIdCardIn(List<String> values) {
			addCriterion("SELL_ID_CARD in", values, "sellIdCard");
			return (Criteria) this;
		}

		public Criteria andSellIdCardNotIn(List<String> values) {
			addCriterion("SELL_ID_CARD not in", values, "sellIdCard");
			return (Criteria) this;
		}

		public Criteria andSellIdCardBetween(String value1, String value2) {
			addCriterion("SELL_ID_CARD between", value1, value2, "sellIdCard");
			return (Criteria) this;
		}

		public Criteria andSellIdCardNotBetween(String value1, String value2) {
			addCriterion("SELL_ID_CARD not between", value1, value2, "sellIdCard");
			return (Criteria) this;
		}

		public Criteria andBuyPaymoneyIsNull() {
			addCriterion("BUY_PAYMONEY is null");
			return (Criteria) this;
		}

		public Criteria andBuyPaymoneyIsNotNull() {
			addCriterion("BUY_PAYMONEY is not null");
			return (Criteria) this;
		}

		public Criteria andBuyPaymoneyEqualTo(BigDecimal value) {
			addCriterion("BUY_PAYMONEY =", value, "buyPaymoney");
			return (Criteria) this;
		}

		public Criteria andBuyPaymoneyNotEqualTo(BigDecimal value) {
			addCriterion("BUY_PAYMONEY <>", value, "buyPaymoney");
			return (Criteria) this;
		}

		public Criteria andBuyPaymoneyGreaterThan(BigDecimal value) {
			addCriterion("BUY_PAYMONEY >", value, "buyPaymoney");
			return (Criteria) this;
		}

		public Criteria andBuyPaymoneyGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("BUY_PAYMONEY >=", value, "buyPaymoney");
			return (Criteria) this;
		}

		public Criteria andBuyPaymoneyLessThan(BigDecimal value) {
			addCriterion("BUY_PAYMONEY <", value, "buyPaymoney");
			return (Criteria) this;
		}

		public Criteria andBuyPaymoneyLessThanOrEqualTo(BigDecimal value) {
			addCriterion("BUY_PAYMONEY <=", value, "buyPaymoney");
			return (Criteria) this;
		}

		public Criteria andBuyPaymoneyIn(List<BigDecimal> values) {
			addCriterion("BUY_PAYMONEY in", values, "buyPaymoney");
			return (Criteria) this;
		}

		public Criteria andBuyPaymoneyNotIn(List<BigDecimal> values) {
			addCriterion("BUY_PAYMONEY not in", values, "buyPaymoney");
			return (Criteria) this;
		}

		public Criteria andBuyPaymoneyBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("BUY_PAYMONEY between", value1, value2, "buyPaymoney");
			return (Criteria) this;
		}

		public Criteria andBuyPaymoneyNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("BUY_PAYMONEY not between", value1, value2, "buyPaymoney");
			return (Criteria) this;
		}

		public Criteria andSellPaymoneyIsNull() {
			addCriterion("SELL_PAYMONEY is null");
			return (Criteria) this;
		}

		public Criteria andSellPaymoneyIsNotNull() {
			addCriterion("SELL_PAYMONEY is not null");
			return (Criteria) this;
		}

		public Criteria andSellPaymoneyEqualTo(BigDecimal value) {
			addCriterion("SELL_PAYMONEY =", value, "sellPaymoney");
			return (Criteria) this;
		}

		public Criteria andSellPaymoneyNotEqualTo(BigDecimal value) {
			addCriterion("SELL_PAYMONEY <>", value, "sellPaymoney");
			return (Criteria) this;
		}

		public Criteria andSellPaymoneyGreaterThan(BigDecimal value) {
			addCriterion("SELL_PAYMONEY >", value, "sellPaymoney");
			return (Criteria) this;
		}

		public Criteria andSellPaymoneyGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("SELL_PAYMONEY >=", value, "sellPaymoney");
			return (Criteria) this;
		}

		public Criteria andSellPaymoneyLessThan(BigDecimal value) {
			addCriterion("SELL_PAYMONEY <", value, "sellPaymoney");
			return (Criteria) this;
		}

		public Criteria andSellPaymoneyLessThanOrEqualTo(BigDecimal value) {
			addCriterion("SELL_PAYMONEY <=", value, "sellPaymoney");
			return (Criteria) this;
		}

		public Criteria andSellPaymoneyIn(List<BigDecimal> values) {
			addCriterion("SELL_PAYMONEY in", values, "sellPaymoney");
			return (Criteria) this;
		}

		public Criteria andSellPaymoneyNotIn(List<BigDecimal> values) {
			addCriterion("SELL_PAYMONEY not in", values, "sellPaymoney");
			return (Criteria) this;
		}

		public Criteria andSellPaymoneyBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("SELL_PAYMONEY between", value1, value2, "sellPaymoney");
			return (Criteria) this;
		}

		public Criteria andSellPaymoneyNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("SELL_PAYMONEY not between", value1, value2, "sellPaymoney");
			return (Criteria) this;
		}

		public Criteria andOtherPaymoneyIsNull() {
			addCriterion("OTHER_PAYMONEY is null");
			return (Criteria) this;
		}

		public Criteria andOtherPaymoneyIsNotNull() {
			addCriterion("OTHER_PAYMONEY is not null");
			return (Criteria) this;
		}

		public Criteria andOtherPaymoneyEqualTo(BigDecimal value) {
			addCriterion("OTHER_PAYMONEY =", value, "otherPaymoney");
			return (Criteria) this;
		}

		public Criteria andOtherPaymoneyNotEqualTo(BigDecimal value) {
			addCriterion("OTHER_PAYMONEY <>", value, "otherPaymoney");
			return (Criteria) this;
		}

		public Criteria andOtherPaymoneyGreaterThan(BigDecimal value) {
			addCriterion("OTHER_PAYMONEY >", value, "otherPaymoney");
			return (Criteria) this;
		}

		public Criteria andOtherPaymoneyGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("OTHER_PAYMONEY >=", value, "otherPaymoney");
			return (Criteria) this;
		}

		public Criteria andOtherPaymoneyLessThan(BigDecimal value) {
			addCriterion("OTHER_PAYMONEY <", value, "otherPaymoney");
			return (Criteria) this;
		}

		public Criteria andOtherPaymoneyLessThanOrEqualTo(BigDecimal value) {
			addCriterion("OTHER_PAYMONEY <=", value, "otherPaymoney");
			return (Criteria) this;
		}

		public Criteria andOtherPaymoneyIn(List<BigDecimal> values) {
			addCriterion("OTHER_PAYMONEY in", values, "otherPaymoney");
			return (Criteria) this;
		}

		public Criteria andOtherPaymoneyNotIn(List<BigDecimal> values) {
			addCriterion("OTHER_PAYMONEY not in", values, "otherPaymoney");
			return (Criteria) this;
		}

		public Criteria andOtherPaymoneyBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("OTHER_PAYMONEY between", value1, value2, "otherPaymoney");
			return (Criteria) this;
		}

		public Criteria andOtherPaymoneyNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("OTHER_PAYMONEY not between", value1, value2, "otherPaymoney");
			return (Criteria) this;
		}

		public Criteria andGainMoneyIsNull() {
			addCriterion("GAIN_MONEY is null");
			return (Criteria) this;
		}

		public Criteria andGainMoneyIsNotNull() {
			addCriterion("GAIN_MONEY is not null");
			return (Criteria) this;
		}

		public Criteria andGainMoneyEqualTo(BigDecimal value) {
			addCriterion("GAIN_MONEY =", value, "gainMoney");
			return (Criteria) this;
		}

		public Criteria andGainMoneyNotEqualTo(BigDecimal value) {
			addCriterion("GAIN_MONEY <>", value, "gainMoney");
			return (Criteria) this;
		}

		public Criteria andGainMoneyGreaterThan(BigDecimal value) {
			addCriterion("GAIN_MONEY >", value, "gainMoney");
			return (Criteria) this;
		}

		public Criteria andGainMoneyGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("GAIN_MONEY >=", value, "gainMoney");
			return (Criteria) this;
		}

		public Criteria andGainMoneyLessThan(BigDecimal value) {
			addCriterion("GAIN_MONEY <", value, "gainMoney");
			return (Criteria) this;
		}

		public Criteria andGainMoneyLessThanOrEqualTo(BigDecimal value) {
			addCriterion("GAIN_MONEY <=", value, "gainMoney");
			return (Criteria) this;
		}

		public Criteria andGainMoneyIn(List<BigDecimal> values) {
			addCriterion("GAIN_MONEY in", values, "gainMoney");
			return (Criteria) this;
		}

		public Criteria andGainMoneyNotIn(List<BigDecimal> values) {
			addCriterion("GAIN_MONEY not in", values, "gainMoney");
			return (Criteria) this;
		}

		public Criteria andGainMoneyBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("GAIN_MONEY between", value1, value2, "gainMoney");
			return (Criteria) this;
		}

		public Criteria andGainMoneyNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("GAIN_MONEY not between", value1, value2, "gainMoney");
			return (Criteria) this;
		}

		public Criteria andRealBuyPaymoneyIsNull() {
			addCriterion("REAL_BUY_PAYMONEY is null");
			return (Criteria) this;
		}

		public Criteria andRealBuyPaymoneyIsNotNull() {
			addCriterion("REAL_BUY_PAYMONEY is not null");
			return (Criteria) this;
		}

		public Criteria andRealBuyPaymoneyEqualTo(BigDecimal value) {
			addCriterion("REAL_BUY_PAYMONEY =", value, "realBuyPaymoney");
			return (Criteria) this;
		}

		public Criteria andRealBuyPaymoneyNotEqualTo(BigDecimal value) {
			addCriterion("REAL_BUY_PAYMONEY <>", value, "realBuyPaymoney");
			return (Criteria) this;
		}

		public Criteria andRealBuyPaymoneyGreaterThan(BigDecimal value) {
			addCriterion("REAL_BUY_PAYMONEY >", value, "realBuyPaymoney");
			return (Criteria) this;
		}

		public Criteria andRealBuyPaymoneyGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("REAL_BUY_PAYMONEY >=", value, "realBuyPaymoney");
			return (Criteria) this;
		}

		public Criteria andRealBuyPaymoneyLessThan(BigDecimal value) {
			addCriterion("REAL_BUY_PAYMONEY <", value, "realBuyPaymoney");
			return (Criteria) this;
		}

		public Criteria andRealBuyPaymoneyLessThanOrEqualTo(BigDecimal value) {
			addCriterion("REAL_BUY_PAYMONEY <=", value, "realBuyPaymoney");
			return (Criteria) this;
		}

		public Criteria andRealBuyPaymoneyIn(List<BigDecimal> values) {
			addCriterion("REAL_BUY_PAYMONEY in", values, "realBuyPaymoney");
			return (Criteria) this;
		}

		public Criteria andRealBuyPaymoneyNotIn(List<BigDecimal> values) {
			addCriterion("REAL_BUY_PAYMONEY not in", values, "realBuyPaymoney");
			return (Criteria) this;
		}

		public Criteria andRealBuyPaymoneyBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("REAL_BUY_PAYMONEY between", value1, value2, "realBuyPaymoney");
			return (Criteria) this;
		}

		public Criteria andRealBuyPaymoneyNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("REAL_BUY_PAYMONEY not between", value1, value2, "realBuyPaymoney");
			return (Criteria) this;
		}

		public Criteria andRealSellPaymoneyIsNull() {
			addCriterion("REAL_SELL_PAYMONEY is null");
			return (Criteria) this;
		}

		public Criteria andRealSellPaymoneyIsNotNull() {
			addCriterion("REAL_SELL_PAYMONEY is not null");
			return (Criteria) this;
		}

		public Criteria andRealSellPaymoneyEqualTo(BigDecimal value) {
			addCriterion("REAL_SELL_PAYMONEY =", value, "realSellPaymoney");
			return (Criteria) this;
		}

		public Criteria andRealSellPaymoneyNotEqualTo(BigDecimal value) {
			addCriterion("REAL_SELL_PAYMONEY <>", value, "realSellPaymoney");
			return (Criteria) this;
		}

		public Criteria andRealSellPaymoneyGreaterThan(BigDecimal value) {
			addCriterion("REAL_SELL_PAYMONEY >", value, "realSellPaymoney");
			return (Criteria) this;
		}

		public Criteria andRealSellPaymoneyGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("REAL_SELL_PAYMONEY >=", value, "realSellPaymoney");
			return (Criteria) this;
		}

		public Criteria andRealSellPaymoneyLessThan(BigDecimal value) {
			addCriterion("REAL_SELL_PAYMONEY <", value, "realSellPaymoney");
			return (Criteria) this;
		}

		public Criteria andRealSellPaymoneyLessThanOrEqualTo(BigDecimal value) {
			addCriterion("REAL_SELL_PAYMONEY <=", value, "realSellPaymoney");
			return (Criteria) this;
		}

		public Criteria andRealSellPaymoneyIn(List<BigDecimal> values) {
			addCriterion("REAL_SELL_PAYMONEY in", values, "realSellPaymoney");
			return (Criteria) this;
		}

		public Criteria andRealSellPaymoneyNotIn(List<BigDecimal> values) {
			addCriterion("REAL_SELL_PAYMONEY not in", values, "realSellPaymoney");
			return (Criteria) this;
		}

		public Criteria andRealSellPaymoneyBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("REAL_SELL_PAYMONEY between", value1, value2, "realSellPaymoney");
			return (Criteria) this;
		}

		public Criteria andRealSellPaymoneyNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("REAL_SELL_PAYMONEY not between", value1, value2, "realSellPaymoney");
			return (Criteria) this;
		}

		public Criteria andRealOtherPaymoneyIsNull() {
			addCriterion("REAL_OTHER_PAYMONEY is null");
			return (Criteria) this;
		}

		public Criteria andRealOtherPaymoneyIsNotNull() {
			addCriterion("REAL_OTHER_PAYMONEY is not null");
			return (Criteria) this;
		}

		public Criteria andRealOtherPaymoneyEqualTo(BigDecimal value) {
			addCriterion("REAL_OTHER_PAYMONEY =", value, "realOtherPaymoney");
			return (Criteria) this;
		}

		public Criteria andRealOtherPaymoneyNotEqualTo(BigDecimal value) {
			addCriterion("REAL_OTHER_PAYMONEY <>", value, "realOtherPaymoney");
			return (Criteria) this;
		}

		public Criteria andRealOtherPaymoneyGreaterThan(BigDecimal value) {
			addCriterion("REAL_OTHER_PAYMONEY >", value, "realOtherPaymoney");
			return (Criteria) this;
		}

		public Criteria andRealOtherPaymoneyGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("REAL_OTHER_PAYMONEY >=", value, "realOtherPaymoney");
			return (Criteria) this;
		}

		public Criteria andRealOtherPaymoneyLessThan(BigDecimal value) {
			addCriterion("REAL_OTHER_PAYMONEY <", value, "realOtherPaymoney");
			return (Criteria) this;
		}

		public Criteria andRealOtherPaymoneyLessThanOrEqualTo(BigDecimal value) {
			addCriterion("REAL_OTHER_PAYMONEY <=", value, "realOtherPaymoney");
			return (Criteria) this;
		}

		public Criteria andRealOtherPaymoneyIn(List<BigDecimal> values) {
			addCriterion("REAL_OTHER_PAYMONEY in", values, "realOtherPaymoney");
			return (Criteria) this;
		}

		public Criteria andRealOtherPaymoneyNotIn(List<BigDecimal> values) {
			addCriterion("REAL_OTHER_PAYMONEY not in", values, "realOtherPaymoney");
			return (Criteria) this;
		}

		public Criteria andRealOtherPaymoneyBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("REAL_OTHER_PAYMONEY between", value1, value2, "realOtherPaymoney");
			return (Criteria) this;
		}

		public Criteria andRealOtherPaymoneyNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("REAL_OTHER_PAYMONEY not between", value1, value2, "realOtherPaymoney");
			return (Criteria) this;
		}

		public Criteria andRealPaymoneyIsNull() {
			addCriterion("REAL_PAYMONEY is null");
			return (Criteria) this;
		}

		public Criteria andRealPaymoneyIsNotNull() {
			addCriterion("REAL_PAYMONEY is not null");
			return (Criteria) this;
		}

		public Criteria andRealPaymoneyEqualTo(BigDecimal value) {
			addCriterion("REAL_PAYMONEY =", value, "realPaymoney");
			return (Criteria) this;
		}

		public Criteria andRealPaymoneyNotEqualTo(BigDecimal value) {
			addCriterion("REAL_PAYMONEY <>", value, "realPaymoney");
			return (Criteria) this;
		}

		public Criteria andRealPaymoneyGreaterThan(BigDecimal value) {
			addCriterion("REAL_PAYMONEY >", value, "realPaymoney");
			return (Criteria) this;
		}

		public Criteria andRealPaymoneyGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("REAL_PAYMONEY >=", value, "realPaymoney");
			return (Criteria) this;
		}

		public Criteria andRealPaymoneyLessThan(BigDecimal value) {
			addCriterion("REAL_PAYMONEY <", value, "realPaymoney");
			return (Criteria) this;
		}

		public Criteria andRealPaymoneyLessThanOrEqualTo(BigDecimal value) {
			addCriterion("REAL_PAYMONEY <=", value, "realPaymoney");
			return (Criteria) this;
		}

		public Criteria andRealPaymoneyIn(List<BigDecimal> values) {
			addCriterion("REAL_PAYMONEY in", values, "realPaymoney");
			return (Criteria) this;
		}

		public Criteria andRealPaymoneyNotIn(List<BigDecimal> values) {
			addCriterion("REAL_PAYMONEY not in", values, "realPaymoney");
			return (Criteria) this;
		}

		public Criteria andRealPaymoneyBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("REAL_PAYMONEY between", value1, value2, "realPaymoney");
			return (Criteria) this;
		}

		public Criteria andRealPaymoneyNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("REAL_PAYMONEY not between", value1, value2, "realPaymoney");
			return (Criteria) this;
		}

		public Criteria andBuyPriceMoneyIsNull() {
			addCriterion("BUY_PRICE_MONEY is null");
			return (Criteria) this;
		}

		public Criteria andBuyPriceMoneyIsNotNull() {
			addCriterion("BUY_PRICE_MONEY is not null");
			return (Criteria) this;
		}

		public Criteria andBuyPriceMoneyEqualTo(String value) {
			addCriterion("BUY_PRICE_MONEY =", value, "buyPriceMoney");
			return (Criteria) this;
		}

		public Criteria andBuyPriceMoneyNotEqualTo(String value) {
			addCriterion("BUY_PRICE_MONEY <>", value, "buyPriceMoney");
			return (Criteria) this;
		}

		public Criteria andBuyPriceMoneyGreaterThan(String value) {
			addCriterion("BUY_PRICE_MONEY >", value, "buyPriceMoney");
			return (Criteria) this;
		}

		public Criteria andBuyPriceMoneyGreaterThanOrEqualTo(String value) {
			addCriterion("BUY_PRICE_MONEY >=", value, "buyPriceMoney");
			return (Criteria) this;
		}

		public Criteria andBuyPriceMoneyLessThan(String value) {
			addCriterion("BUY_PRICE_MONEY <", value, "buyPriceMoney");
			return (Criteria) this;
		}

		public Criteria andBuyPriceMoneyLessThanOrEqualTo(String value) {
			addCriterion("BUY_PRICE_MONEY <=", value, "buyPriceMoney");
			return (Criteria) this;
		}

		public Criteria andBuyPriceMoneyLike(String value) {
			addCriterion("BUY_PRICE_MONEY like", value, "buyPriceMoney");
			return (Criteria) this;
		}

		public Criteria andBuyPriceMoneyNotLike(String value) {
			addCriterion("BUY_PRICE_MONEY not like", value, "buyPriceMoney");
			return (Criteria) this;
		}

		public Criteria andBuyPriceMoneyIn(List<String> values) {
			addCriterion("BUY_PRICE_MONEY in", values, "buyPriceMoney");
			return (Criteria) this;
		}

		public Criteria andBuyPriceMoneyNotIn(List<String> values) {
			addCriterion("BUY_PRICE_MONEY not in", values, "buyPriceMoney");
			return (Criteria) this;
		}

		public Criteria andBuyPriceMoneyBetween(String value1, String value2) {
			addCriterion("BUY_PRICE_MONEY between", value1, value2, "buyPriceMoney");
			return (Criteria) this;
		}

		public Criteria andBuyPriceMoneyNotBetween(String value1, String value2) {
			addCriterion("BUY_PRICE_MONEY not between", value1, value2, "buyPriceMoney");
			return (Criteria) this;
		}

		public Criteria andBuyMortgageTypeIsNull() {
			addCriterion("BUY_MORTGAGE_TYPE is null");
			return (Criteria) this;
		}

		public Criteria andBuyMortgageTypeIsNotNull() {
			addCriterion("BUY_MORTGAGE_TYPE is not null");
			return (Criteria) this;
		}

		public Criteria andBuyMortgageTypeEqualTo(Byte value) {
			addCriterion("BUY_MORTGAGE_TYPE =", value, "buyMortgageType");
			return (Criteria) this;
		}

		public Criteria andBuyMortgageTypeNotEqualTo(Byte value) {
			addCriterion("BUY_MORTGAGE_TYPE <>", value, "buyMortgageType");
			return (Criteria) this;
		}

		public Criteria andBuyMortgageTypeGreaterThan(Byte value) {
			addCriterion("BUY_MORTGAGE_TYPE >", value, "buyMortgageType");
			return (Criteria) this;
		}

		public Criteria andBuyMortgageTypeGreaterThanOrEqualTo(Byte value) {
			addCriterion("BUY_MORTGAGE_TYPE >=", value, "buyMortgageType");
			return (Criteria) this;
		}

		public Criteria andBuyMortgageTypeLessThan(Byte value) {
			addCriterion("BUY_MORTGAGE_TYPE <", value, "buyMortgageType");
			return (Criteria) this;
		}

		public Criteria andBuyMortgageTypeLessThanOrEqualTo(Byte value) {
			addCriterion("BUY_MORTGAGE_TYPE <=", value, "buyMortgageType");
			return (Criteria) this;
		}

		public Criteria andBuyMortgageTypeIn(List<Byte> values) {
			addCriterion("BUY_MORTGAGE_TYPE in", values, "buyMortgageType");
			return (Criteria) this;
		}

		public Criteria andBuyMortgageTypeNotIn(List<Byte> values) {
			addCriterion("BUY_MORTGAGE_TYPE not in", values, "buyMortgageType");
			return (Criteria) this;
		}

		public Criteria andBuyMortgageTypeBetween(Byte value1, Byte value2) {
			addCriterion("BUY_MORTGAGE_TYPE between", value1, value2, "buyMortgageType");
			return (Criteria) this;
		}

		public Criteria andBuyMortgageTypeNotBetween(Byte value1, Byte value2) {
			addCriterion("BUY_MORTGAGE_TYPE not between", value1, value2, "buyMortgageType");
			return (Criteria) this;
		}

		public Criteria andSellDealMoneyIsNull() {
			addCriterion("SELL_DEAL_MONEY is null");
			return (Criteria) this;
		}

		public Criteria andSellDealMoneyIsNotNull() {
			addCriterion("SELL_DEAL_MONEY is not null");
			return (Criteria) this;
		}

		public Criteria andSellDealMoneyEqualTo(BigDecimal value) {
			addCriterion("SELL_DEAL_MONEY =", value, "sellDealMoney");
			return (Criteria) this;
		}

		public Criteria andSellDealMoneyNotEqualTo(BigDecimal value) {
			addCriterion("SELL_DEAL_MONEY <>", value, "sellDealMoney");
			return (Criteria) this;
		}

		public Criteria andSellDealMoneyGreaterThan(BigDecimal value) {
			addCriterion("SELL_DEAL_MONEY >", value, "sellDealMoney");
			return (Criteria) this;
		}

		public Criteria andSellDealMoneyGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("SELL_DEAL_MONEY >=", value, "sellDealMoney");
			return (Criteria) this;
		}

		public Criteria andSellDealMoneyLessThan(BigDecimal value) {
			addCriterion("SELL_DEAL_MONEY <", value, "sellDealMoney");
			return (Criteria) this;
		}

		public Criteria andSellDealMoneyLessThanOrEqualTo(BigDecimal value) {
			addCriterion("SELL_DEAL_MONEY <=", value, "sellDealMoney");
			return (Criteria) this;
		}

		public Criteria andSellDealMoneyIn(List<BigDecimal> values) {
			addCriterion("SELL_DEAL_MONEY in", values, "sellDealMoney");
			return (Criteria) this;
		}

		public Criteria andSellDealMoneyNotIn(List<BigDecimal> values) {
			addCriterion("SELL_DEAL_MONEY not in", values, "sellDealMoney");
			return (Criteria) this;
		}

		public Criteria andSellDealMoneyBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("SELL_DEAL_MONEY between", value1, value2, "sellDealMoney");
			return (Criteria) this;
		}

		public Criteria andSellDealMoneyNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("SELL_DEAL_MONEY not between", value1, value2, "sellDealMoney");
			return (Criteria) this;
		}

		public Criteria andSellIshaveLoanIsNull() {
			addCriterion("SELL_ISHAVE_LOAN is null");
			return (Criteria) this;
		}

		public Criteria andSellIshaveLoanIsNotNull() {
			addCriterion("SELL_ISHAVE_LOAN is not null");
			return (Criteria) this;
		}

		public Criteria andSellIshaveLoanEqualTo(Boolean value) {
			addCriterion("SELL_ISHAVE_LOAN =", value, "sellIshaveLoan");
			return (Criteria) this;
		}

		public Criteria andSellIshaveLoanNotEqualTo(Boolean value) {
			addCriterion("SELL_ISHAVE_LOAN <>", value, "sellIshaveLoan");
			return (Criteria) this;
		}

		public Criteria andSellIshaveLoanGreaterThan(Boolean value) {
			addCriterion("SELL_ISHAVE_LOAN >", value, "sellIshaveLoan");
			return (Criteria) this;
		}

		public Criteria andSellIshaveLoanGreaterThanOrEqualTo(Boolean value) {
			addCriterion("SELL_ISHAVE_LOAN >=", value, "sellIshaveLoan");
			return (Criteria) this;
		}

		public Criteria andSellIshaveLoanLessThan(Boolean value) {
			addCriterion("SELL_ISHAVE_LOAN <", value, "sellIshaveLoan");
			return (Criteria) this;
		}

		public Criteria andSellIshaveLoanLessThanOrEqualTo(Boolean value) {
			addCriterion("SELL_ISHAVE_LOAN <=", value, "sellIshaveLoan");
			return (Criteria) this;
		}

		public Criteria andSellIshaveLoanIn(List<Boolean> values) {
			addCriterion("SELL_ISHAVE_LOAN in", values, "sellIshaveLoan");
			return (Criteria) this;
		}

		public Criteria andSellIshaveLoanNotIn(List<Boolean> values) {
			addCriterion("SELL_ISHAVE_LOAN not in", values, "sellIshaveLoan");
			return (Criteria) this;
		}

		public Criteria andSellIshaveLoanBetween(Boolean value1, Boolean value2) {
			addCriterion("SELL_ISHAVE_LOAN between", value1, value2, "sellIshaveLoan");
			return (Criteria) this;
		}

		public Criteria andSellIshaveLoanNotBetween(Boolean value1, Boolean value2) {
			addCriterion("SELL_ISHAVE_LOAN not between", value1, value2, "sellIshaveLoan");
			return (Criteria) this;
		}

		public Criteria andSellLoanMoneyIsNull() {
			addCriterion("SELL_LOAN_MONEY is null");
			return (Criteria) this;
		}

		public Criteria andSellLoanMoneyIsNotNull() {
			addCriterion("SELL_LOAN_MONEY is not null");
			return (Criteria) this;
		}

		public Criteria andSellLoanMoneyEqualTo(BigDecimal value) {
			addCriterion("SELL_LOAN_MONEY =", value, "sellLoanMoney");
			return (Criteria) this;
		}

		public Criteria andSellLoanMoneyNotEqualTo(BigDecimal value) {
			addCriterion("SELL_LOAN_MONEY <>", value, "sellLoanMoney");
			return (Criteria) this;
		}

		public Criteria andSellLoanMoneyGreaterThan(BigDecimal value) {
			addCriterion("SELL_LOAN_MONEY >", value, "sellLoanMoney");
			return (Criteria) this;
		}

		public Criteria andSellLoanMoneyGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("SELL_LOAN_MONEY >=", value, "sellLoanMoney");
			return (Criteria) this;
		}

		public Criteria andSellLoanMoneyLessThan(BigDecimal value) {
			addCriterion("SELL_LOAN_MONEY <", value, "sellLoanMoney");
			return (Criteria) this;
		}

		public Criteria andSellLoanMoneyLessThanOrEqualTo(BigDecimal value) {
			addCriterion("SELL_LOAN_MONEY <=", value, "sellLoanMoney");
			return (Criteria) this;
		}

		public Criteria andSellLoanMoneyIn(List<BigDecimal> values) {
			addCriterion("SELL_LOAN_MONEY in", values, "sellLoanMoney");
			return (Criteria) this;
		}

		public Criteria andSellLoanMoneyNotIn(List<BigDecimal> values) {
			addCriterion("SELL_LOAN_MONEY not in", values, "sellLoanMoney");
			return (Criteria) this;
		}

		public Criteria andSellLoanMoneyBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("SELL_LOAN_MONEY between", value1, value2, "sellLoanMoney");
			return (Criteria) this;
		}

		public Criteria andSellLoanMoneyNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("SELL_LOAN_MONEY not between", value1, value2, "sellLoanMoney");
			return (Criteria) this;
		}

		public Criteria andSellReturnLoanIsNull() {
			addCriterion("SELL_RETURN_LOAN is null");
			return (Criteria) this;
		}

		public Criteria andSellReturnLoanIsNotNull() {
			addCriterion("SELL_RETURN_LOAN is not null");
			return (Criteria) this;
		}

		public Criteria andSellReturnLoanEqualTo(Boolean value) {
			addCriterion("SELL_RETURN_LOAN =", value, "sellReturnLoan");
			return (Criteria) this;
		}

		public Criteria andSellReturnLoanNotEqualTo(Boolean value) {
			addCriterion("SELL_RETURN_LOAN <>", value, "sellReturnLoan");
			return (Criteria) this;
		}

		public Criteria andSellReturnLoanGreaterThan(Boolean value) {
			addCriterion("SELL_RETURN_LOAN >", value, "sellReturnLoan");
			return (Criteria) this;
		}

		public Criteria andSellReturnLoanGreaterThanOrEqualTo(Boolean value) {
			addCriterion("SELL_RETURN_LOAN >=", value, "sellReturnLoan");
			return (Criteria) this;
		}

		public Criteria andSellReturnLoanLessThan(Boolean value) {
			addCriterion("SELL_RETURN_LOAN <", value, "sellReturnLoan");
			return (Criteria) this;
		}

		public Criteria andSellReturnLoanLessThanOrEqualTo(Boolean value) {
			addCriterion("SELL_RETURN_LOAN <=", value, "sellReturnLoan");
			return (Criteria) this;
		}

		public Criteria andSellReturnLoanIn(List<Boolean> values) {
			addCriterion("SELL_RETURN_LOAN in", values, "sellReturnLoan");
			return (Criteria) this;
		}

		public Criteria andSellReturnLoanNotIn(List<Boolean> values) {
			addCriterion("SELL_RETURN_LOAN not in", values, "sellReturnLoan");
			return (Criteria) this;
		}

		public Criteria andSellReturnLoanBetween(Boolean value1, Boolean value2) {
			addCriterion("SELL_RETURN_LOAN between", value1, value2, "sellReturnLoan");
			return (Criteria) this;
		}

		public Criteria andSellReturnLoanNotBetween(Boolean value1, Boolean value2) {
			addCriterion("SELL_RETURN_LOAN not between", value1, value2, "sellReturnLoan");
			return (Criteria) this;
		}

		public Criteria andOwnerStyleIsNull() {
			addCriterion("OWNER_STYLE is null");
			return (Criteria) this;
		}

		public Criteria andOwnerStyleIsNotNull() {
			addCriterion("OWNER_STYLE is not null");
			return (Criteria) this;
		}

		public Criteria andOwnerStyleEqualTo(Integer value) {
			addCriterion("OWNER_STYLE =", value, "ownerStyle");
			return (Criteria) this;
		}

		public Criteria andOwnerStyleNotEqualTo(Integer value) {
			addCriterion("OWNER_STYLE <>", value, "ownerStyle");
			return (Criteria) this;
		}

		public Criteria andOwnerStyleGreaterThan(Integer value) {
			addCriterion("OWNER_STYLE >", value, "ownerStyle");
			return (Criteria) this;
		}

		public Criteria andOwnerStyleGreaterThanOrEqualTo(Integer value) {
			addCriterion("OWNER_STYLE >=", value, "ownerStyle");
			return (Criteria) this;
		}

		public Criteria andOwnerStyleLessThan(Integer value) {
			addCriterion("OWNER_STYLE <", value, "ownerStyle");
			return (Criteria) this;
		}

		public Criteria andOwnerStyleLessThanOrEqualTo(Integer value) {
			addCriterion("OWNER_STYLE <=", value, "ownerStyle");
			return (Criteria) this;
		}

		public Criteria andOwnerStyleIn(List<Integer> values) {
			addCriterion("OWNER_STYLE in", values, "ownerStyle");
			return (Criteria) this;
		}

		public Criteria andOwnerStyleNotIn(List<Integer> values) {
			addCriterion("OWNER_STYLE not in", values, "ownerStyle");
			return (Criteria) this;
		}

		public Criteria andOwnerStyleBetween(Integer value1, Integer value2) {
			addCriterion("OWNER_STYLE between", value1, value2, "ownerStyle");
			return (Criteria) this;
		}

		public Criteria andOwnerStyleNotBetween(Integer value1, Integer value2) {
			addCriterion("OWNER_STYLE not between", value1, value2, "ownerStyle");
			return (Criteria) this;
		}

		public Criteria andOwnerTypeIsNull() {
			addCriterion("OWNER_TYPE is null");
			return (Criteria) this;
		}

		public Criteria andOwnerTypeIsNotNull() {
			addCriterion("OWNER_TYPE is not null");
			return (Criteria) this;
		}

		public Criteria andOwnerTypeEqualTo(Byte value) {
			addCriterion("OWNER_TYPE =", value, "ownerType");
			return (Criteria) this;
		}

		public Criteria andOwnerTypeNotEqualTo(Byte value) {
			addCriterion("OWNER_TYPE <>", value, "ownerType");
			return (Criteria) this;
		}

		public Criteria andOwnerTypeGreaterThan(Byte value) {
			addCriterion("OWNER_TYPE >", value, "ownerType");
			return (Criteria) this;
		}

		public Criteria andOwnerTypeGreaterThanOrEqualTo(Byte value) {
			addCriterion("OWNER_TYPE >=", value, "ownerType");
			return (Criteria) this;
		}

		public Criteria andOwnerTypeLessThan(Byte value) {
			addCriterion("OWNER_TYPE <", value, "ownerType");
			return (Criteria) this;
		}

		public Criteria andOwnerTypeLessThanOrEqualTo(Byte value) {
			addCriterion("OWNER_TYPE <=", value, "ownerType");
			return (Criteria) this;
		}

		public Criteria andOwnerTypeIn(List<Byte> values) {
			addCriterion("OWNER_TYPE in", values, "ownerType");
			return (Criteria) this;
		}

		public Criteria andOwnerTypeNotIn(List<Byte> values) {
			addCriterion("OWNER_TYPE not in", values, "ownerType");
			return (Criteria) this;
		}

		public Criteria andOwnerTypeBetween(Byte value1, Byte value2) {
			addCriterion("OWNER_TYPE between", value1, value2, "ownerType");
			return (Criteria) this;
		}

		public Criteria andOwnerTypeNotBetween(Byte value1, Byte value2) {
			addCriterion("OWNER_TYPE not between", value1, value2, "ownerType");
			return (Criteria) this;
		}

		public Criteria andOwnerNoIsNull() {
			addCriterion("OWNER_NO is null");
			return (Criteria) this;
		}

		public Criteria andOwnerNoIsNotNull() {
			addCriterion("OWNER_NO is not null");
			return (Criteria) this;
		}

		public Criteria andOwnerNoEqualTo(String value) {
			addCriterion("OWNER_NO =", value, "ownerNo");
			return (Criteria) this;
		}

		public Criteria andOwnerNoNotEqualTo(String value) {
			addCriterion("OWNER_NO <>", value, "ownerNo");
			return (Criteria) this;
		}

		public Criteria andOwnerNoGreaterThan(String value) {
			addCriterion("OWNER_NO >", value, "ownerNo");
			return (Criteria) this;
		}

		public Criteria andOwnerNoGreaterThanOrEqualTo(String value) {
			addCriterion("OWNER_NO >=", value, "ownerNo");
			return (Criteria) this;
		}

		public Criteria andOwnerNoLessThan(String value) {
			addCriterion("OWNER_NO <", value, "ownerNo");
			return (Criteria) this;
		}

		public Criteria andOwnerNoLessThanOrEqualTo(String value) {
			addCriterion("OWNER_NO <=", value, "ownerNo");
			return (Criteria) this;
		}

		public Criteria andOwnerNoLike(String value) {
			addCriterion("OWNER_NO like", value, "ownerNo");
			return (Criteria) this;
		}

		public Criteria andOwnerNoNotLike(String value) {
			addCriterion("OWNER_NO not like", value, "ownerNo");
			return (Criteria) this;
		}

		public Criteria andOwnerNoIn(List<String> values) {
			addCriterion("OWNER_NO in", values, "ownerNo");
			return (Criteria) this;
		}

		public Criteria andOwnerNoNotIn(List<String> values) {
			addCriterion("OWNER_NO not in", values, "ownerNo");
			return (Criteria) this;
		}

		public Criteria andOwnerNoBetween(String value1, String value2) {
			addCriterion("OWNER_NO between", value1, value2, "ownerNo");
			return (Criteria) this;
		}

		public Criteria andOwnerNoNotBetween(String value1, String value2) {
			addCriterion("OWNER_NO not between", value1, value2, "ownerNo");
			return (Criteria) this;
		}

		public Criteria andHaveLandcardIsNull() {
			addCriterion("HAVE_LANDCARD is null");
			return (Criteria) this;
		}

		public Criteria andHaveLandcardIsNotNull() {
			addCriterion("HAVE_LANDCARD is not null");
			return (Criteria) this;
		}

		public Criteria andHaveLandcardEqualTo(Boolean value) {
			addCriterion("HAVE_LANDCARD =", value, "haveLandcard");
			return (Criteria) this;
		}

		public Criteria andHaveLandcardNotEqualTo(Boolean value) {
			addCriterion("HAVE_LANDCARD <>", value, "haveLandcard");
			return (Criteria) this;
		}

		public Criteria andHaveLandcardGreaterThan(Boolean value) {
			addCriterion("HAVE_LANDCARD >", value, "haveLandcard");
			return (Criteria) this;
		}

		public Criteria andHaveLandcardGreaterThanOrEqualTo(Boolean value) {
			addCriterion("HAVE_LANDCARD >=", value, "haveLandcard");
			return (Criteria) this;
		}

		public Criteria andHaveLandcardLessThan(Boolean value) {
			addCriterion("HAVE_LANDCARD <", value, "haveLandcard");
			return (Criteria) this;
		}

		public Criteria andHaveLandcardLessThanOrEqualTo(Boolean value) {
			addCriterion("HAVE_LANDCARD <=", value, "haveLandcard");
			return (Criteria) this;
		}

		public Criteria andHaveLandcardIn(List<Boolean> values) {
			addCriterion("HAVE_LANDCARD in", values, "haveLandcard");
			return (Criteria) this;
		}

		public Criteria andHaveLandcardNotIn(List<Boolean> values) {
			addCriterion("HAVE_LANDCARD not in", values, "haveLandcard");
			return (Criteria) this;
		}

		public Criteria andHaveLandcardBetween(Boolean value1, Boolean value2) {
			addCriterion("HAVE_LANDCARD between", value1, value2, "haveLandcard");
			return (Criteria) this;
		}

		public Criteria andHaveLandcardNotBetween(Boolean value1, Boolean value2) {
			addCriterion("HAVE_LANDCARD not between", value1, value2, "haveLandcard");
			return (Criteria) this;
		}

		public Criteria andLandcardNoIsNull() {
			addCriterion("LANDCARD_NO is null");
			return (Criteria) this;
		}

		public Criteria andLandcardNoIsNotNull() {
			addCriterion("LANDCARD_NO is not null");
			return (Criteria) this;
		}

		public Criteria andLandcardNoEqualTo(String value) {
			addCriterion("LANDCARD_NO =", value, "landcardNo");
			return (Criteria) this;
		}

		public Criteria andLandcardNoNotEqualTo(String value) {
			addCriterion("LANDCARD_NO <>", value, "landcardNo");
			return (Criteria) this;
		}

		public Criteria andLandcardNoGreaterThan(String value) {
			addCriterion("LANDCARD_NO >", value, "landcardNo");
			return (Criteria) this;
		}

		public Criteria andLandcardNoGreaterThanOrEqualTo(String value) {
			addCriterion("LANDCARD_NO >=", value, "landcardNo");
			return (Criteria) this;
		}

		public Criteria andLandcardNoLessThan(String value) {
			addCriterion("LANDCARD_NO <", value, "landcardNo");
			return (Criteria) this;
		}

		public Criteria andLandcardNoLessThanOrEqualTo(String value) {
			addCriterion("LANDCARD_NO <=", value, "landcardNo");
			return (Criteria) this;
		}

		public Criteria andLandcardNoLike(String value) {
			addCriterion("LANDCARD_NO like", value, "landcardNo");
			return (Criteria) this;
		}

		public Criteria andLandcardNoNotLike(String value) {
			addCriterion("LANDCARD_NO not like", value, "landcardNo");
			return (Criteria) this;
		}

		public Criteria andLandcardNoIn(List<String> values) {
			addCriterion("LANDCARD_NO in", values, "landcardNo");
			return (Criteria) this;
		}

		public Criteria andLandcardNoNotIn(List<String> values) {
			addCriterion("LANDCARD_NO not in", values, "landcardNo");
			return (Criteria) this;
		}

		public Criteria andLandcardNoBetween(String value1, String value2) {
			addCriterion("LANDCARD_NO between", value1, value2, "landcardNo");
			return (Criteria) this;
		}

		public Criteria andLandcardNoNotBetween(String value1, String value2) {
			addCriterion("LANDCARD_NO not between", value1, value2, "landcardNo");
			return (Criteria) this;
		}

		public Criteria andMangementTaxIsNull() {
			addCriterion("MANGEMENT_TAX is null");
			return (Criteria) this;
		}

		public Criteria andMangementTaxIsNotNull() {
			addCriterion("MANGEMENT_TAX is not null");
			return (Criteria) this;
		}

		public Criteria andMangementTaxEqualTo(Boolean value) {
			addCriterion("MANGEMENT_TAX =", value, "mangementTax");
			return (Criteria) this;
		}

		public Criteria andMangementTaxNotEqualTo(Boolean value) {
			addCriterion("MANGEMENT_TAX <>", value, "mangementTax");
			return (Criteria) this;
		}

		public Criteria andMangementTaxGreaterThan(Boolean value) {
			addCriterion("MANGEMENT_TAX >", value, "mangementTax");
			return (Criteria) this;
		}

		public Criteria andMangementTaxGreaterThanOrEqualTo(Boolean value) {
			addCriterion("MANGEMENT_TAX >=", value, "mangementTax");
			return (Criteria) this;
		}

		public Criteria andMangementTaxLessThan(Boolean value) {
			addCriterion("MANGEMENT_TAX <", value, "mangementTax");
			return (Criteria) this;
		}

		public Criteria andMangementTaxLessThanOrEqualTo(Boolean value) {
			addCriterion("MANGEMENT_TAX <=", value, "mangementTax");
			return (Criteria) this;
		}

		public Criteria andMangementTaxIn(List<Boolean> values) {
			addCriterion("MANGEMENT_TAX in", values, "mangementTax");
			return (Criteria) this;
		}

		public Criteria andMangementTaxNotIn(List<Boolean> values) {
			addCriterion("MANGEMENT_TAX not in", values, "mangementTax");
			return (Criteria) this;
		}

		public Criteria andMangementTaxBetween(Boolean value1, Boolean value2) {
			addCriterion("MANGEMENT_TAX between", value1, value2, "mangementTax");
			return (Criteria) this;
		}

		public Criteria andMangementTaxNotBetween(Boolean value1, Boolean value2) {
			addCriterion("MANGEMENT_TAX not between", value1, value2, "mangementTax");
			return (Criteria) this;
		}

		public Criteria andOwnerTaxIsNull() {
			addCriterion("OWNER_TAX is null");
			return (Criteria) this;
		}

		public Criteria andOwnerTaxIsNotNull() {
			addCriterion("OWNER_TAX is not null");
			return (Criteria) this;
		}

		public Criteria andOwnerTaxEqualTo(Boolean value) {
			addCriterion("OWNER_TAX =", value, "ownerTax");
			return (Criteria) this;
		}

		public Criteria andOwnerTaxNotEqualTo(Boolean value) {
			addCriterion("OWNER_TAX <>", value, "ownerTax");
			return (Criteria) this;
		}

		public Criteria andOwnerTaxGreaterThan(Boolean value) {
			addCriterion("OWNER_TAX >", value, "ownerTax");
			return (Criteria) this;
		}

		public Criteria andOwnerTaxGreaterThanOrEqualTo(Boolean value) {
			addCriterion("OWNER_TAX >=", value, "ownerTax");
			return (Criteria) this;
		}

		public Criteria andOwnerTaxLessThan(Boolean value) {
			addCriterion("OWNER_TAX <", value, "ownerTax");
			return (Criteria) this;
		}

		public Criteria andOwnerTaxLessThanOrEqualTo(Boolean value) {
			addCriterion("OWNER_TAX <=", value, "ownerTax");
			return (Criteria) this;
		}

		public Criteria andOwnerTaxIn(List<Boolean> values) {
			addCriterion("OWNER_TAX in", values, "ownerTax");
			return (Criteria) this;
		}

		public Criteria andOwnerTaxNotIn(List<Boolean> values) {
			addCriterion("OWNER_TAX not in", values, "ownerTax");
			return (Criteria) this;
		}

		public Criteria andOwnerTaxBetween(Boolean value1, Boolean value2) {
			addCriterion("OWNER_TAX between", value1, value2, "ownerTax");
			return (Criteria) this;
		}

		public Criteria andOwnerTaxNotBetween(Boolean value1, Boolean value2) {
			addCriterion("OWNER_TAX not between", value1, value2, "ownerTax");
			return (Criteria) this;
		}

		public Criteria andTaxIsNull() {
			addCriterion("TAX is null");
			return (Criteria) this;
		}

		public Criteria andTaxIsNotNull() {
			addCriterion("TAX is not null");
			return (Criteria) this;
		}

		public Criteria andTaxEqualTo(String value) {
			addCriterion("TAX =", value, "tax");
			return (Criteria) this;
		}

		public Criteria andTaxNotEqualTo(String value) {
			addCriterion("TAX <>", value, "tax");
			return (Criteria) this;
		}

		public Criteria andTaxGreaterThan(String value) {
			addCriterion("TAX >", value, "tax");
			return (Criteria) this;
		}

		public Criteria andTaxGreaterThanOrEqualTo(String value) {
			addCriterion("TAX >=", value, "tax");
			return (Criteria) this;
		}

		public Criteria andTaxLessThan(String value) {
			addCriterion("TAX <", value, "tax");
			return (Criteria) this;
		}

		public Criteria andTaxLessThanOrEqualTo(String value) {
			addCriterion("TAX <=", value, "tax");
			return (Criteria) this;
		}

		public Criteria andTaxLike(String value) {
			addCriterion("TAX like", value, "tax");
			return (Criteria) this;
		}

		public Criteria andTaxNotLike(String value) {
			addCriterion("TAX not like", value, "tax");
			return (Criteria) this;
		}

		public Criteria andTaxIn(List<String> values) {
			addCriterion("TAX in", values, "tax");
			return (Criteria) this;
		}

		public Criteria andTaxNotIn(List<String> values) {
			addCriterion("TAX not in", values, "tax");
			return (Criteria) this;
		}

		public Criteria andTaxBetween(String value1, String value2) {
			addCriterion("TAX between", value1, value2, "tax");
			return (Criteria) this;
		}

		public Criteria andTaxNotBetween(String value1, String value2) {
			addCriterion("TAX not between", value1, value2, "tax");
			return (Criteria) this;
		}

		public Criteria andTradeRemarkExplainIsNull() {
			addCriterion("TRADE_REMARK_EXPLAIN is null");
			return (Criteria) this;
		}

		public Criteria andTradeRemarkExplainIsNotNull() {
			addCriterion("TRADE_REMARK_EXPLAIN is not null");
			return (Criteria) this;
		}

		public Criteria andTradeRemarkExplainEqualTo(String value) {
			addCriterion("TRADE_REMARK_EXPLAIN =", value, "tradeRemarkExplain");
			return (Criteria) this;
		}

		public Criteria andTradeRemarkExplainNotEqualTo(String value) {
			addCriterion("TRADE_REMARK_EXPLAIN <>", value, "tradeRemarkExplain");
			return (Criteria) this;
		}

		public Criteria andTradeRemarkExplainGreaterThan(String value) {
			addCriterion("TRADE_REMARK_EXPLAIN >", value, "tradeRemarkExplain");
			return (Criteria) this;
		}

		public Criteria andTradeRemarkExplainGreaterThanOrEqualTo(String value) {
			addCriterion("TRADE_REMARK_EXPLAIN >=", value, "tradeRemarkExplain");
			return (Criteria) this;
		}

		public Criteria andTradeRemarkExplainLessThan(String value) {
			addCriterion("TRADE_REMARK_EXPLAIN <", value, "tradeRemarkExplain");
			return (Criteria) this;
		}

		public Criteria andTradeRemarkExplainLessThanOrEqualTo(String value) {
			addCriterion("TRADE_REMARK_EXPLAIN <=", value, "tradeRemarkExplain");
			return (Criteria) this;
		}

		public Criteria andTradeRemarkExplainLike(String value) {
			addCriterion("TRADE_REMARK_EXPLAIN like", value, "tradeRemarkExplain");
			return (Criteria) this;
		}

		public Criteria andTradeRemarkExplainNotLike(String value) {
			addCriterion("TRADE_REMARK_EXPLAIN not like", value, "tradeRemarkExplain");
			return (Criteria) this;
		}

		public Criteria andTradeRemarkExplainIn(List<String> values) {
			addCriterion("TRADE_REMARK_EXPLAIN in", values, "tradeRemarkExplain");
			return (Criteria) this;
		}

		public Criteria andTradeRemarkExplainNotIn(List<String> values) {
			addCriterion("TRADE_REMARK_EXPLAIN not in", values, "tradeRemarkExplain");
			return (Criteria) this;
		}

		public Criteria andTradeRemarkExplainBetween(String value1, String value2) {
			addCriterion("TRADE_REMARK_EXPLAIN between", value1, value2, "tradeRemarkExplain");
			return (Criteria) this;
		}

		public Criteria andTradeRemarkExplainNotBetween(String value1, String value2) {
			addCriterion("TRADE_REMARK_EXPLAIN not between", value1, value2, "tradeRemarkExplain");
			return (Criteria) this;
		}

		public Criteria andRentDealMoneyIsNull() {
			addCriterion("RENT_DEAL_MONEY is null");
			return (Criteria) this;
		}

		public Criteria andRentDealMoneyIsNotNull() {
			addCriterion("RENT_DEAL_MONEY is not null");
			return (Criteria) this;
		}

		public Criteria andRentDealMoneyEqualTo(BigDecimal value) {
			addCriterion("RENT_DEAL_MONEY =", value, "rentDealMoney");
			return (Criteria) this;
		}

		public Criteria andRentDealMoneyNotEqualTo(BigDecimal value) {
			addCriterion("RENT_DEAL_MONEY <>", value, "rentDealMoney");
			return (Criteria) this;
		}

		public Criteria andRentDealMoneyGreaterThan(BigDecimal value) {
			addCriterion("RENT_DEAL_MONEY >", value, "rentDealMoney");
			return (Criteria) this;
		}

		public Criteria andRentDealMoneyGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("RENT_DEAL_MONEY >=", value, "rentDealMoney");
			return (Criteria) this;
		}

		public Criteria andRentDealMoneyLessThan(BigDecimal value) {
			addCriterion("RENT_DEAL_MONEY <", value, "rentDealMoney");
			return (Criteria) this;
		}

		public Criteria andRentDealMoneyLessThanOrEqualTo(BigDecimal value) {
			addCriterion("RENT_DEAL_MONEY <=", value, "rentDealMoney");
			return (Criteria) this;
		}

		public Criteria andRentDealMoneyIn(List<BigDecimal> values) {
			addCriterion("RENT_DEAL_MONEY in", values, "rentDealMoney");
			return (Criteria) this;
		}

		public Criteria andRentDealMoneyNotIn(List<BigDecimal> values) {
			addCriterion("RENT_DEAL_MONEY not in", values, "rentDealMoney");
			return (Criteria) this;
		}

		public Criteria andRentDealMoneyBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("RENT_DEAL_MONEY between", value1, value2, "rentDealMoney");
			return (Criteria) this;
		}

		public Criteria andRentDealMoneyNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("RENT_DEAL_MONEY not between", value1, value2, "rentDealMoney");
			return (Criteria) this;
		}

		public Criteria andRentPriceUnitIsNull() {
			addCriterion("RENT_PRICE_UNIT is null");
			return (Criteria) this;
		}

		public Criteria andRentPriceUnitIsNotNull() {
			addCriterion("RENT_PRICE_UNIT is not null");
			return (Criteria) this;
		}

		public Criteria andRentPriceUnitEqualTo(Byte value) {
			addCriterion("RENT_PRICE_UNIT =", value, "rentPriceUnit");
			return (Criteria) this;
		}

		public Criteria andRentPriceUnitNotEqualTo(Byte value) {
			addCriterion("RENT_PRICE_UNIT <>", value, "rentPriceUnit");
			return (Criteria) this;
		}

		public Criteria andRentPriceUnitGreaterThan(Byte value) {
			addCriterion("RENT_PRICE_UNIT >", value, "rentPriceUnit");
			return (Criteria) this;
		}

		public Criteria andRentPriceUnitGreaterThanOrEqualTo(Byte value) {
			addCriterion("RENT_PRICE_UNIT >=", value, "rentPriceUnit");
			return (Criteria) this;
		}

		public Criteria andRentPriceUnitLessThan(Byte value) {
			addCriterion("RENT_PRICE_UNIT <", value, "rentPriceUnit");
			return (Criteria) this;
		}

		public Criteria andRentPriceUnitLessThanOrEqualTo(Byte value) {
			addCriterion("RENT_PRICE_UNIT <=", value, "rentPriceUnit");
			return (Criteria) this;
		}

		public Criteria andRentPriceUnitIn(List<Byte> values) {
			addCriterion("RENT_PRICE_UNIT in", values, "rentPriceUnit");
			return (Criteria) this;
		}

		public Criteria andRentPriceUnitNotIn(List<Byte> values) {
			addCriterion("RENT_PRICE_UNIT not in", values, "rentPriceUnit");
			return (Criteria) this;
		}

		public Criteria andRentPriceUnitBetween(Byte value1, Byte value2) {
			addCriterion("RENT_PRICE_UNIT between", value1, value2, "rentPriceUnit");
			return (Criteria) this;
		}

		public Criteria andRentPriceUnitNotBetween(Byte value1, Byte value2) {
			addCriterion("RENT_PRICE_UNIT not between", value1, value2, "rentPriceUnit");
			return (Criteria) this;
		}

		public Criteria andRentDateIsNull() {
			addCriterion("RENT_DATE is null");
			return (Criteria) this;
		}

		public Criteria andRentDateIsNotNull() {
			addCriterion("RENT_DATE is not null");
			return (Criteria) this;
		}

		public Criteria andRentDateEqualTo(String value) {
			addCriterion("RENT_DATE =", value, "rentDate");
			return (Criteria) this;
		}

		public Criteria andRentDateNotEqualTo(String value) {
			addCriterion("RENT_DATE <>", value, "rentDate");
			return (Criteria) this;
		}

		public Criteria andRentDateGreaterThan(String value) {
			addCriterion("RENT_DATE >", value, "rentDate");
			return (Criteria) this;
		}

		public Criteria andRentDateGreaterThanOrEqualTo(String value) {
			addCriterion("RENT_DATE >=", value, "rentDate");
			return (Criteria) this;
		}

		public Criteria andRentDateLessThan(String value) {
			addCriterion("RENT_DATE <", value, "rentDate");
			return (Criteria) this;
		}

		public Criteria andRentDateLessThanOrEqualTo(String value) {
			addCriterion("RENT_DATE <=", value, "rentDate");
			return (Criteria) this;
		}

		public Criteria andRentDateLike(String value) {
			addCriterion("RENT_DATE like", value, "rentDate");
			return (Criteria) this;
		}

		public Criteria andRentDateNotLike(String value) {
			addCriterion("RENT_DATE not like", value, "rentDate");
			return (Criteria) this;
		}

		public Criteria andRentDateIn(List<String> values) {
			addCriterion("RENT_DATE in", values, "rentDate");
			return (Criteria) this;
		}

		public Criteria andRentDateNotIn(List<String> values) {
			addCriterion("RENT_DATE not in", values, "rentDate");
			return (Criteria) this;
		}

		public Criteria andRentDateBetween(String value1, String value2) {
			addCriterion("RENT_DATE between", value1, value2, "rentDate");
			return (Criteria) this;
		}

		public Criteria andRentDateNotBetween(String value1, String value2) {
			addCriterion("RENT_DATE not between", value1, value2, "rentDate");
			return (Criteria) this;
		}

		public Criteria andRentOverDateIsNull() {
			addCriterion("RENT_OVER_DATE is null");
			return (Criteria) this;
		}

		public Criteria andRentOverDateIsNotNull() {
			addCriterion("RENT_OVER_DATE is not null");
			return (Criteria) this;
		}

		public Criteria andRentOverDateEqualTo(String value) {
			addCriterion("RENT_OVER_DATE =", value, "rentOverDate");
			return (Criteria) this;
		}

		public Criteria andRentOverDateNotEqualTo(String value) {
			addCriterion("RENT_OVER_DATE <>", value, "rentOverDate");
			return (Criteria) this;
		}

		public Criteria andRentOverDateGreaterThan(String value) {
			addCriterion("RENT_OVER_DATE >", value, "rentOverDate");
			return (Criteria) this;
		}

		public Criteria andRentOverDateGreaterThanOrEqualTo(String value) {
			addCriterion("RENT_OVER_DATE >=", value, "rentOverDate");
			return (Criteria) this;
		}

		public Criteria andRentOverDateLessThan(String value) {
			addCriterion("RENT_OVER_DATE <", value, "rentOverDate");
			return (Criteria) this;
		}

		public Criteria andRentOverDateLessThanOrEqualTo(String value) {
			addCriterion("RENT_OVER_DATE <=", value, "rentOverDate");
			return (Criteria) this;
		}

		public Criteria andRentOverDateLike(String value) {
			addCriterion("RENT_OVER_DATE like", value, "rentOverDate");
			return (Criteria) this;
		}

		public Criteria andRentOverDateNotLike(String value) {
			addCriterion("RENT_OVER_DATE not like", value, "rentOverDate");
			return (Criteria) this;
		}

		public Criteria andRentOverDateIn(List<String> values) {
			addCriterion("RENT_OVER_DATE in", values, "rentOverDate");
			return (Criteria) this;
		}

		public Criteria andRentOverDateNotIn(List<String> values) {
			addCriterion("RENT_OVER_DATE not in", values, "rentOverDate");
			return (Criteria) this;
		}

		public Criteria andRentOverDateBetween(String value1, String value2) {
			addCriterion("RENT_OVER_DATE between", value1, value2, "rentOverDate");
			return (Criteria) this;
		}

		public Criteria andRentOverDateNotBetween(String value1, String value2) {
			addCriterion("RENT_OVER_DATE not between", value1, value2, "rentOverDate");
			return (Criteria) this;
		}

		public Criteria andRentPayMethodIsNull() {
			addCriterion("RENT_PAY_METHOD is null");
			return (Criteria) this;
		}

		public Criteria andRentPayMethodIsNotNull() {
			addCriterion("RENT_PAY_METHOD is not null");
			return (Criteria) this;
		}

		public Criteria andRentPayMethodEqualTo(Byte value) {
			addCriterion("RENT_PAY_METHOD =", value, "rentPayMethod");
			return (Criteria) this;
		}

		public Criteria andRentPayMethodNotEqualTo(Byte value) {
			addCriterion("RENT_PAY_METHOD <>", value, "rentPayMethod");
			return (Criteria) this;
		}

		public Criteria andRentPayMethodGreaterThan(Byte value) {
			addCriterion("RENT_PAY_METHOD >", value, "rentPayMethod");
			return (Criteria) this;
		}

		public Criteria andRentPayMethodGreaterThanOrEqualTo(Byte value) {
			addCriterion("RENT_PAY_METHOD >=", value, "rentPayMethod");
			return (Criteria) this;
		}

		public Criteria andRentPayMethodLessThan(Byte value) {
			addCriterion("RENT_PAY_METHOD <", value, "rentPayMethod");
			return (Criteria) this;
		}

		public Criteria andRentPayMethodLessThanOrEqualTo(Byte value) {
			addCriterion("RENT_PAY_METHOD <=", value, "rentPayMethod");
			return (Criteria) this;
		}

		public Criteria andRentPayMethodIn(List<Byte> values) {
			addCriterion("RENT_PAY_METHOD in", values, "rentPayMethod");
			return (Criteria) this;
		}

		public Criteria andRentPayMethodNotIn(List<Byte> values) {
			addCriterion("RENT_PAY_METHOD not in", values, "rentPayMethod");
			return (Criteria) this;
		}

		public Criteria andRentPayMethodBetween(Byte value1, Byte value2) {
			addCriterion("RENT_PAY_METHOD between", value1, value2, "rentPayMethod");
			return (Criteria) this;
		}

		public Criteria andRentPayMethodNotBetween(Byte value1, Byte value2) {
			addCriterion("RENT_PAY_METHOD not between", value1, value2, "rentPayMethod");
			return (Criteria) this;
		}

		public Criteria andRentPaySpaceIsNull() {
			addCriterion("RENT_PAY_SPACE is null");
			return (Criteria) this;
		}

		public Criteria andRentPaySpaceIsNotNull() {
			addCriterion("RENT_PAY_SPACE is not null");
			return (Criteria) this;
		}

		public Criteria andRentPaySpaceEqualTo(String value) {
			addCriterion("RENT_PAY_SPACE =", value, "rentPaySpace");
			return (Criteria) this;
		}

		public Criteria andRentPaySpaceNotEqualTo(String value) {
			addCriterion("RENT_PAY_SPACE <>", value, "rentPaySpace");
			return (Criteria) this;
		}

		public Criteria andRentPaySpaceGreaterThan(String value) {
			addCriterion("RENT_PAY_SPACE >", value, "rentPaySpace");
			return (Criteria) this;
		}

		public Criteria andRentPaySpaceGreaterThanOrEqualTo(String value) {
			addCriterion("RENT_PAY_SPACE >=", value, "rentPaySpace");
			return (Criteria) this;
		}

		public Criteria andRentPaySpaceLessThan(String value) {
			addCriterion("RENT_PAY_SPACE <", value, "rentPaySpace");
			return (Criteria) this;
		}

		public Criteria andRentPaySpaceLessThanOrEqualTo(String value) {
			addCriterion("RENT_PAY_SPACE <=", value, "rentPaySpace");
			return (Criteria) this;
		}

		public Criteria andRentPaySpaceLike(String value) {
			addCriterion("RENT_PAY_SPACE like", value, "rentPaySpace");
			return (Criteria) this;
		}

		public Criteria andRentPaySpaceNotLike(String value) {
			addCriterion("RENT_PAY_SPACE not like", value, "rentPaySpace");
			return (Criteria) this;
		}

		public Criteria andRentPaySpaceIn(List<String> values) {
			addCriterion("RENT_PAY_SPACE in", values, "rentPaySpace");
			return (Criteria) this;
		}

		public Criteria andRentPaySpaceNotIn(List<String> values) {
			addCriterion("RENT_PAY_SPACE not in", values, "rentPaySpace");
			return (Criteria) this;
		}

		public Criteria andRentPaySpaceBetween(String value1, String value2) {
			addCriterion("RENT_PAY_SPACE between", value1, value2, "rentPaySpace");
			return (Criteria) this;
		}

		public Criteria andRentPaySpaceNotBetween(String value1, String value2) {
			addCriterion("RENT_PAY_SPACE not between", value1, value2, "rentPaySpace");
			return (Criteria) this;
		}

		public Criteria andRentPayEarlyIsNull() {
			addCriterion("RENT_PAY_EARLY is null");
			return (Criteria) this;
		}

		public Criteria andRentPayEarlyIsNotNull() {
			addCriterion("RENT_PAY_EARLY is not null");
			return (Criteria) this;
		}

		public Criteria andRentPayEarlyEqualTo(String value) {
			addCriterion("RENT_PAY_EARLY =", value, "rentPayEarly");
			return (Criteria) this;
		}

		public Criteria andRentPayEarlyNotEqualTo(String value) {
			addCriterion("RENT_PAY_EARLY <>", value, "rentPayEarly");
			return (Criteria) this;
		}

		public Criteria andRentPayEarlyGreaterThan(String value) {
			addCriterion("RENT_PAY_EARLY >", value, "rentPayEarly");
			return (Criteria) this;
		}

		public Criteria andRentPayEarlyGreaterThanOrEqualTo(String value) {
			addCriterion("RENT_PAY_EARLY >=", value, "rentPayEarly");
			return (Criteria) this;
		}

		public Criteria andRentPayEarlyLessThan(String value) {
			addCriterion("RENT_PAY_EARLY <", value, "rentPayEarly");
			return (Criteria) this;
		}

		public Criteria andRentPayEarlyLessThanOrEqualTo(String value) {
			addCriterion("RENT_PAY_EARLY <=", value, "rentPayEarly");
			return (Criteria) this;
		}

		public Criteria andRentPayEarlyLike(String value) {
			addCriterion("RENT_PAY_EARLY like", value, "rentPayEarly");
			return (Criteria) this;
		}

		public Criteria andRentPayEarlyNotLike(String value) {
			addCriterion("RENT_PAY_EARLY not like", value, "rentPayEarly");
			return (Criteria) this;
		}

		public Criteria andRentPayEarlyIn(List<String> values) {
			addCriterion("RENT_PAY_EARLY in", values, "rentPayEarly");
			return (Criteria) this;
		}

		public Criteria andRentPayEarlyNotIn(List<String> values) {
			addCriterion("RENT_PAY_EARLY not in", values, "rentPayEarly");
			return (Criteria) this;
		}

		public Criteria andRentPayEarlyBetween(String value1, String value2) {
			addCriterion("RENT_PAY_EARLY between", value1, value2, "rentPayEarly");
			return (Criteria) this;
		}

		public Criteria andRentPayEarlyNotBetween(String value1, String value2) {
			addCriterion("RENT_PAY_EARLY not between", value1, value2, "rentPayEarly");
			return (Criteria) this;
		}

		public Criteria andRentDepositPayIsNull() {
			addCriterion("RENT_DEPOSIT_PAY is null");
			return (Criteria) this;
		}

		public Criteria andRentDepositPayIsNotNull() {
			addCriterion("RENT_DEPOSIT_PAY is not null");
			return (Criteria) this;
		}

		public Criteria andRentDepositPayEqualTo(BigDecimal value) {
			addCriterion("RENT_DEPOSIT_PAY =", value, "rentDepositPay");
			return (Criteria) this;
		}

		public Criteria andRentDepositPayNotEqualTo(BigDecimal value) {
			addCriterion("RENT_DEPOSIT_PAY <>", value, "rentDepositPay");
			return (Criteria) this;
		}

		public Criteria andRentDepositPayGreaterThan(BigDecimal value) {
			addCriterion("RENT_DEPOSIT_PAY >", value, "rentDepositPay");
			return (Criteria) this;
		}

		public Criteria andRentDepositPayGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("RENT_DEPOSIT_PAY >=", value, "rentDepositPay");
			return (Criteria) this;
		}

		public Criteria andRentDepositPayLessThan(BigDecimal value) {
			addCriterion("RENT_DEPOSIT_PAY <", value, "rentDepositPay");
			return (Criteria) this;
		}

		public Criteria andRentDepositPayLessThanOrEqualTo(BigDecimal value) {
			addCriterion("RENT_DEPOSIT_PAY <=", value, "rentDepositPay");
			return (Criteria) this;
		}

		public Criteria andRentDepositPayIn(List<BigDecimal> values) {
			addCriterion("RENT_DEPOSIT_PAY in", values, "rentDepositPay");
			return (Criteria) this;
		}

		public Criteria andRentDepositPayNotIn(List<BigDecimal> values) {
			addCriterion("RENT_DEPOSIT_PAY not in", values, "rentDepositPay");
			return (Criteria) this;
		}

		public Criteria andRentDepositPayBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("RENT_DEPOSIT_PAY between", value1, value2, "rentDepositPay");
			return (Criteria) this;
		}

		public Criteria andRentDepositPayNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("RENT_DEPOSIT_PAY not between", value1, value2, "rentDepositPay");
			return (Criteria) this;
		}

		public Criteria andRentOtherMoneyIsNull() {
			addCriterion("RENT_OTHER_MONEY is null");
			return (Criteria) this;
		}

		public Criteria andRentOtherMoneyIsNotNull() {
			addCriterion("RENT_OTHER_MONEY is not null");
			return (Criteria) this;
		}

		public Criteria andRentOtherMoneyEqualTo(BigDecimal value) {
			addCriterion("RENT_OTHER_MONEY =", value, "rentOtherMoney");
			return (Criteria) this;
		}

		public Criteria andRentOtherMoneyNotEqualTo(BigDecimal value) {
			addCriterion("RENT_OTHER_MONEY <>", value, "rentOtherMoney");
			return (Criteria) this;
		}

		public Criteria andRentOtherMoneyGreaterThan(BigDecimal value) {
			addCriterion("RENT_OTHER_MONEY >", value, "rentOtherMoney");
			return (Criteria) this;
		}

		public Criteria andRentOtherMoneyGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("RENT_OTHER_MONEY >=", value, "rentOtherMoney");
			return (Criteria) this;
		}

		public Criteria andRentOtherMoneyLessThan(BigDecimal value) {
			addCriterion("RENT_OTHER_MONEY <", value, "rentOtherMoney");
			return (Criteria) this;
		}

		public Criteria andRentOtherMoneyLessThanOrEqualTo(BigDecimal value) {
			addCriterion("RENT_OTHER_MONEY <=", value, "rentOtherMoney");
			return (Criteria) this;
		}

		public Criteria andRentOtherMoneyIn(List<BigDecimal> values) {
			addCriterion("RENT_OTHER_MONEY in", values, "rentOtherMoney");
			return (Criteria) this;
		}

		public Criteria andRentOtherMoneyNotIn(List<BigDecimal> values) {
			addCriterion("RENT_OTHER_MONEY not in", values, "rentOtherMoney");
			return (Criteria) this;
		}

		public Criteria andRentOtherMoneyBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("RENT_OTHER_MONEY between", value1, value2, "rentOtherMoney");
			return (Criteria) this;
		}

		public Criteria andRentOtherMoneyNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("RENT_OTHER_MONEY not between", value1, value2, "rentOtherMoney");
			return (Criteria) this;
		}

		public Criteria andGoodsdetailedIsNull() {
			addCriterion("GOODSDETAILED is null");
			return (Criteria) this;
		}

		public Criteria andGoodsdetailedIsNotNull() {
			addCriterion("GOODSDETAILED is not null");
			return (Criteria) this;
		}

		public Criteria andGoodsdetailedEqualTo(String value) {
			addCriterion("GOODSDETAILED =", value, "goodsdetailed");
			return (Criteria) this;
		}

		public Criteria andGoodsdetailedNotEqualTo(String value) {
			addCriterion("GOODSDETAILED <>", value, "goodsdetailed");
			return (Criteria) this;
		}

		public Criteria andGoodsdetailedGreaterThan(String value) {
			addCriterion("GOODSDETAILED >", value, "goodsdetailed");
			return (Criteria) this;
		}

		public Criteria andGoodsdetailedGreaterThanOrEqualTo(String value) {
			addCriterion("GOODSDETAILED >=", value, "goodsdetailed");
			return (Criteria) this;
		}

		public Criteria andGoodsdetailedLessThan(String value) {
			addCriterion("GOODSDETAILED <", value, "goodsdetailed");
			return (Criteria) this;
		}

		public Criteria andGoodsdetailedLessThanOrEqualTo(String value) {
			addCriterion("GOODSDETAILED <=", value, "goodsdetailed");
			return (Criteria) this;
		}

		public Criteria andGoodsdetailedLike(String value) {
			addCriterion("GOODSDETAILED like", value, "goodsdetailed");
			return (Criteria) this;
		}

		public Criteria andGoodsdetailedNotLike(String value) {
			addCriterion("GOODSDETAILED not like", value, "goodsdetailed");
			return (Criteria) this;
		}

		public Criteria andGoodsdetailedIn(List<String> values) {
			addCriterion("GOODSDETAILED in", values, "goodsdetailed");
			return (Criteria) this;
		}

		public Criteria andGoodsdetailedNotIn(List<String> values) {
			addCriterion("GOODSDETAILED not in", values, "goodsdetailed");
			return (Criteria) this;
		}

		public Criteria andGoodsdetailedBetween(String value1, String value2) {
			addCriterion("GOODSDETAILED between", value1, value2, "goodsdetailed");
			return (Criteria) this;
		}

		public Criteria andGoodsdetailedNotBetween(String value1, String value2) {
			addCriterion("GOODSDETAILED not between", value1, value2, "goodsdetailed");
			return (Criteria) this;
		}

		public Criteria andWaterlightexpensesIsNull() {
			addCriterion("WATERLIGHTEXPENSES is null");
			return (Criteria) this;
		}

		public Criteria andWaterlightexpensesIsNotNull() {
			addCriterion("WATERLIGHTEXPENSES is not null");
			return (Criteria) this;
		}

		public Criteria andWaterlightexpensesEqualTo(String value) {
			addCriterion("WATERLIGHTEXPENSES =", value, "waterlightexpenses");
			return (Criteria) this;
		}

		public Criteria andWaterlightexpensesNotEqualTo(String value) {
			addCriterion("WATERLIGHTEXPENSES <>", value, "waterlightexpenses");
			return (Criteria) this;
		}

		public Criteria andWaterlightexpensesGreaterThan(String value) {
			addCriterion("WATERLIGHTEXPENSES >", value, "waterlightexpenses");
			return (Criteria) this;
		}

		public Criteria andWaterlightexpensesGreaterThanOrEqualTo(String value) {
			addCriterion("WATERLIGHTEXPENSES >=", value, "waterlightexpenses");
			return (Criteria) this;
		}

		public Criteria andWaterlightexpensesLessThan(String value) {
			addCriterion("WATERLIGHTEXPENSES <", value, "waterlightexpenses");
			return (Criteria) this;
		}

		public Criteria andWaterlightexpensesLessThanOrEqualTo(String value) {
			addCriterion("WATERLIGHTEXPENSES <=", value, "waterlightexpenses");
			return (Criteria) this;
		}

		public Criteria andWaterlightexpensesLike(String value) {
			addCriterion("WATERLIGHTEXPENSES like", value, "waterlightexpenses");
			return (Criteria) this;
		}

		public Criteria andWaterlightexpensesNotLike(String value) {
			addCriterion("WATERLIGHTEXPENSES not like", value, "waterlightexpenses");
			return (Criteria) this;
		}

		public Criteria andWaterlightexpensesIn(List<String> values) {
			addCriterion("WATERLIGHTEXPENSES in", values, "waterlightexpenses");
			return (Criteria) this;
		}

		public Criteria andWaterlightexpensesNotIn(List<String> values) {
			addCriterion("WATERLIGHTEXPENSES not in", values, "waterlightexpenses");
			return (Criteria) this;
		}

		public Criteria andWaterlightexpensesBetween(String value1, String value2) {
			addCriterion("WATERLIGHTEXPENSES between", value1, value2, "waterlightexpenses");
			return (Criteria) this;
		}

		public Criteria andWaterlightexpensesNotBetween(String value1, String value2) {
			addCriterion("WATERLIGHTEXPENSES not between", value1, value2, "waterlightexpenses");
			return (Criteria) this;
		}

		public Criteria andSystemRecordTimeIsNull() {
			addCriterion("SYSTEM_RECORD_TIME is null");
			return (Criteria) this;
		}

		public Criteria andSystemRecordTimeIsNotNull() {
			addCriterion("SYSTEM_RECORD_TIME is not null");
			return (Criteria) this;
		}

		public Criteria andSystemRecordTimeEqualTo(String value) {
			addCriterion("SYSTEM_RECORD_TIME =", value, "systemRecordTime");
			return (Criteria) this;
		}

		public Criteria andSystemRecordTimeNotEqualTo(String value) {
			addCriterion("SYSTEM_RECORD_TIME <>", value, "systemRecordTime");
			return (Criteria) this;
		}

		public Criteria andSystemRecordTimeGreaterThan(String value) {
			addCriterion("SYSTEM_RECORD_TIME >", value, "systemRecordTime");
			return (Criteria) this;
		}

		public Criteria andSystemRecordTimeGreaterThanOrEqualTo(String value) {
			addCriterion("SYSTEM_RECORD_TIME >=", value, "systemRecordTime");
			return (Criteria) this;
		}

		public Criteria andSystemRecordTimeLessThan(String value) {
			addCriterion("SYSTEM_RECORD_TIME <", value, "systemRecordTime");
			return (Criteria) this;
		}

		public Criteria andSystemRecordTimeLessThanOrEqualTo(String value) {
			addCriterion("SYSTEM_RECORD_TIME <=", value, "systemRecordTime");
			return (Criteria) this;
		}

		public Criteria andSystemRecordTimeLike(String value) {
			addCriterion("SYSTEM_RECORD_TIME like", value, "systemRecordTime");
			return (Criteria) this;
		}

		public Criteria andSystemRecordTimeNotLike(String value) {
			addCriterion("SYSTEM_RECORD_TIME not like", value, "systemRecordTime");
			return (Criteria) this;
		}

		public Criteria andSystemRecordTimeIn(List<String> values) {
			addCriterion("SYSTEM_RECORD_TIME in", values, "systemRecordTime");
			return (Criteria) this;
		}

		public Criteria andSystemRecordTimeNotIn(List<String> values) {
			addCriterion("SYSTEM_RECORD_TIME not in", values, "systemRecordTime");
			return (Criteria) this;
		}

		public Criteria andSystemRecordTimeBetween(String value1, String value2) {
			addCriterion("SYSTEM_RECORD_TIME between", value1, value2, "systemRecordTime");
			return (Criteria) this;
		}

		public Criteria andSystemRecordTimeNotBetween(String value1, String value2) {
			addCriterion("SYSTEM_RECORD_TIME not between", value1, value2, "systemRecordTime");
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

		public Criteria andCreatorUidIsNull() {
			addCriterion("CREATOR_UID is null");
			return (Criteria) this;
		}

		public Criteria andCreatorUidIsNotNull() {
			addCriterion("CREATOR_UID is not null");
			return (Criteria) this;
		}

		public Criteria andCreatorUidEqualTo(Integer value) {
			addCriterion("CREATOR_UID =", value, "creatorUid");
			return (Criteria) this;
		}

		public Criteria andCreatorUidNotEqualTo(Integer value) {
			addCriterion("CREATOR_UID <>", value, "creatorUid");
			return (Criteria) this;
		}

		public Criteria andCreatorUidGreaterThan(Integer value) {
			addCriterion("CREATOR_UID >", value, "creatorUid");
			return (Criteria) this;
		}

		public Criteria andCreatorUidGreaterThanOrEqualTo(Integer value) {
			addCriterion("CREATOR_UID >=", value, "creatorUid");
			return (Criteria) this;
		}

		public Criteria andCreatorUidLessThan(Integer value) {
			addCriterion("CREATOR_UID <", value, "creatorUid");
			return (Criteria) this;
		}

		public Criteria andCreatorUidLessThanOrEqualTo(Integer value) {
			addCriterion("CREATOR_UID <=", value, "creatorUid");
			return (Criteria) this;
		}

		public Criteria andCreatorUidIn(List<Integer> values) {
			addCriterion("CREATOR_UID in", values, "creatorUid");
			return (Criteria) this;
		}

		public Criteria andCreatorUidNotIn(List<Integer> values) {
			addCriterion("CREATOR_UID not in", values, "creatorUid");
			return (Criteria) this;
		}

		public Criteria andCreatorUidBetween(Integer value1, Integer value2) {
			addCriterion("CREATOR_UID between", value1, value2, "creatorUid");
			return (Criteria) this;
		}

		public Criteria andCreatorUidNotBetween(Integer value1, Integer value2) {
			addCriterion("CREATOR_UID not between", value1, value2, "creatorUid");
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

		public Criteria andCustDeptnameIsNull() {
			addCriterion("CUST_DEPTNAME is null");
			return (Criteria) this;
		}

		public Criteria andCustDeptnameIsNotNull() {
			addCriterion("CUST_DEPTNAME is not null");
			return (Criteria) this;
		}

		public Criteria andCustDeptnameEqualTo(String value) {
			addCriterion("CUST_DEPTNAME =", value, "custDeptname");
			return (Criteria) this;
		}

		public Criteria andCustDeptnameNotEqualTo(String value) {
			addCriterion("CUST_DEPTNAME <>", value, "custDeptname");
			return (Criteria) this;
		}

		public Criteria andCustDeptnameGreaterThan(String value) {
			addCriterion("CUST_DEPTNAME >", value, "custDeptname");
			return (Criteria) this;
		}

		public Criteria andCustDeptnameGreaterThanOrEqualTo(String value) {
			addCriterion("CUST_DEPTNAME >=", value, "custDeptname");
			return (Criteria) this;
		}

		public Criteria andCustDeptnameLessThan(String value) {
			addCriterion("CUST_DEPTNAME <", value, "custDeptname");
			return (Criteria) this;
		}

		public Criteria andCustDeptnameLessThanOrEqualTo(String value) {
			addCriterion("CUST_DEPTNAME <=", value, "custDeptname");
			return (Criteria) this;
		}

		public Criteria andCustDeptnameLike(String value) {
			addCriterion("CUST_DEPTNAME like", value, "custDeptname");
			return (Criteria) this;
		}

		public Criteria andCustDeptnameNotLike(String value) {
			addCriterion("CUST_DEPTNAME not like", value, "custDeptname");
			return (Criteria) this;
		}

		public Criteria andCustDeptnameIn(List<String> values) {
			addCriterion("CUST_DEPTNAME in", values, "custDeptname");
			return (Criteria) this;
		}

		public Criteria andCustDeptnameNotIn(List<String> values) {
			addCriterion("CUST_DEPTNAME not in", values, "custDeptname");
			return (Criteria) this;
		}

		public Criteria andCustDeptnameBetween(String value1, String value2) {
			addCriterion("CUST_DEPTNAME between", value1, value2, "custDeptname");
			return (Criteria) this;
		}

		public Criteria andCustDeptnameNotBetween(String value1, String value2) {
			addCriterion("CUST_DEPTNAME not between", value1, value2, "custDeptname");
			return (Criteria) this;
		}

		public Criteria andCustUsernameIsNull() {
			addCriterion("CUST_USERNAME is null");
			return (Criteria) this;
		}

		public Criteria andCustUsernameIsNotNull() {
			addCriterion("CUST_USERNAME is not null");
			return (Criteria) this;
		}

		public Criteria andCustUsernameEqualTo(String value) {
			addCriterion("CUST_USERNAME =", value, "custUsername");
			return (Criteria) this;
		}

		public Criteria andCustUsernameNotEqualTo(String value) {
			addCriterion("CUST_USERNAME <>", value, "custUsername");
			return (Criteria) this;
		}

		public Criteria andCustUsernameGreaterThan(String value) {
			addCriterion("CUST_USERNAME >", value, "custUsername");
			return (Criteria) this;
		}

		public Criteria andCustUsernameGreaterThanOrEqualTo(String value) {
			addCriterion("CUST_USERNAME >=", value, "custUsername");
			return (Criteria) this;
		}

		public Criteria andCustUsernameLessThan(String value) {
			addCriterion("CUST_USERNAME <", value, "custUsername");
			return (Criteria) this;
		}

		public Criteria andCustUsernameLessThanOrEqualTo(String value) {
			addCriterion("CUST_USERNAME <=", value, "custUsername");
			return (Criteria) this;
		}

		public Criteria andCustUsernameLike(String value) {
			addCriterion("CUST_USERNAME like", value, "custUsername");
			return (Criteria) this;
		}

		public Criteria andCustUsernameNotLike(String value) {
			addCriterion("CUST_USERNAME not like", value, "custUsername");
			return (Criteria) this;
		}

		public Criteria andCustUsernameIn(List<String> values) {
			addCriterion("CUST_USERNAME in", values, "custUsername");
			return (Criteria) this;
		}

		public Criteria andCustUsernameNotIn(List<String> values) {
			addCriterion("CUST_USERNAME not in", values, "custUsername");
			return (Criteria) this;
		}

		public Criteria andCustUsernameBetween(String value1, String value2) {
			addCriterion("CUST_USERNAME between", value1, value2, "custUsername");
			return (Criteria) this;
		}

		public Criteria andCustUsernameNotBetween(String value1, String value2) {
			addCriterion("CUST_USERNAME not between", value1, value2, "custUsername");
			return (Criteria) this;
		}

		public Criteria andCustUserUidIsNull() {
			addCriterion("CUST_USER_UID is null");
			return (Criteria) this;
		}

		public Criteria andCustUserUidIsNotNull() {
			addCriterion("CUST_USER_UID is not null");
			return (Criteria) this;
		}

		public Criteria andCustUserUidEqualTo(Integer value) {
			addCriterion("CUST_USER_UID =", value, "custUserUid");
			return (Criteria) this;
		}

		public Criteria andCustUserUidNotEqualTo(Integer value) {
			addCriterion("CUST_USER_UID <>", value, "custUserUid");
			return (Criteria) this;
		}

		public Criteria andCustUserUidGreaterThan(Integer value) {
			addCriterion("CUST_USER_UID >", value, "custUserUid");
			return (Criteria) this;
		}

		public Criteria andCustUserUidGreaterThanOrEqualTo(Integer value) {
			addCriterion("CUST_USER_UID >=", value, "custUserUid");
			return (Criteria) this;
		}

		public Criteria andCustUserUidLessThan(Integer value) {
			addCriterion("CUST_USER_UID <", value, "custUserUid");
			return (Criteria) this;
		}

		public Criteria andCustUserUidLessThanOrEqualTo(Integer value) {
			addCriterion("CUST_USER_UID <=", value, "custUserUid");
			return (Criteria) this;
		}

		public Criteria andCustUserUidIn(List<Integer> values) {
			addCriterion("CUST_USER_UID in", values, "custUserUid");
			return (Criteria) this;
		}

		public Criteria andCustUserUidNotIn(List<Integer> values) {
			addCriterion("CUST_USER_UID not in", values, "custUserUid");
			return (Criteria) this;
		}

		public Criteria andCustUserUidBetween(Integer value1, Integer value2) {
			addCriterion("CUST_USER_UID between", value1, value2, "custUserUid");
			return (Criteria) this;
		}

		public Criteria andCustUserUidNotBetween(Integer value1, Integer value2) {
			addCriterion("CUST_USER_UID not between", value1, value2, "custUserUid");
			return (Criteria) this;
		}

		public Criteria andCustDeptIdIsNull() {
			addCriterion("CUST_DEPT_ID is null");
			return (Criteria) this;
		}

		public Criteria andCustDeptIdIsNotNull() {
			addCriterion("CUST_DEPT_ID is not null");
			return (Criteria) this;
		}

		public Criteria andCustDeptIdEqualTo(Integer value) {
			addCriterion("CUST_DEPT_ID =", value, "custDeptId");
			return (Criteria) this;
		}

		public Criteria andCustDeptIdNotEqualTo(Integer value) {
			addCriterion("CUST_DEPT_ID <>", value, "custDeptId");
			return (Criteria) this;
		}

		public Criteria andCustDeptIdGreaterThan(Integer value) {
			addCriterion("CUST_DEPT_ID >", value, "custDeptId");
			return (Criteria) this;
		}

		public Criteria andCustDeptIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("CUST_DEPT_ID >=", value, "custDeptId");
			return (Criteria) this;
		}

		public Criteria andCustDeptIdLessThan(Integer value) {
			addCriterion("CUST_DEPT_ID <", value, "custDeptId");
			return (Criteria) this;
		}

		public Criteria andCustDeptIdLessThanOrEqualTo(Integer value) {
			addCriterion("CUST_DEPT_ID <=", value, "custDeptId");
			return (Criteria) this;
		}

		public Criteria andCustDeptIdIn(List<Integer> values) {
			addCriterion("CUST_DEPT_ID in", values, "custDeptId");
			return (Criteria) this;
		}

		public Criteria andCustDeptIdNotIn(List<Integer> values) {
			addCriterion("CUST_DEPT_ID not in", values, "custDeptId");
			return (Criteria) this;
		}

		public Criteria andCustDeptIdBetween(Integer value1, Integer value2) {
			addCriterion("CUST_DEPT_ID between", value1, value2, "custDeptId");
			return (Criteria) this;
		}

		public Criteria andCustDeptIdNotBetween(Integer value1, Integer value2) {
			addCriterion("CUST_DEPT_ID not between", value1, value2, "custDeptId");
			return (Criteria) this;
		}

		public Criteria andCustPlateIsNull() {
			addCriterion("CUST_PLATE is null");
			return (Criteria) this;
		}

		public Criteria andCustPlateIsNotNull() {
			addCriterion("CUST_PLATE is not null");
			return (Criteria) this;
		}

		public Criteria andCustPlateEqualTo(Byte value) {
			addCriterion("CUST_PLATE =", value, "custPlate");
			return (Criteria) this;
		}

		public Criteria andCustPlateNotEqualTo(Byte value) {
			addCriterion("CUST_PLATE <>", value, "custPlate");
			return (Criteria) this;
		}

		public Criteria andCustPlateGreaterThan(Byte value) {
			addCriterion("CUST_PLATE >", value, "custPlate");
			return (Criteria) this;
		}

		public Criteria andCustPlateGreaterThanOrEqualTo(Byte value) {
			addCriterion("CUST_PLATE >=", value, "custPlate");
			return (Criteria) this;
		}

		public Criteria andCustPlateLessThan(Byte value) {
			addCriterion("CUST_PLATE <", value, "custPlate");
			return (Criteria) this;
		}

		public Criteria andCustPlateLessThanOrEqualTo(Byte value) {
			addCriterion("CUST_PLATE <=", value, "custPlate");
			return (Criteria) this;
		}

		public Criteria andCustPlateIn(List<Byte> values) {
			addCriterion("CUST_PLATE in", values, "custPlate");
			return (Criteria) this;
		}

		public Criteria andCustPlateNotIn(List<Byte> values) {
			addCriterion("CUST_PLATE not in", values, "custPlate");
			return (Criteria) this;
		}

		public Criteria andCustPlateBetween(Byte value1, Byte value2) {
			addCriterion("CUST_PLATE between", value1, value2, "custPlate");
			return (Criteria) this;
		}

		public Criteria andCustPlateNotBetween(Byte value1, Byte value2) {
			addCriterion("CUST_PLATE not between", value1, value2, "custPlate");
			return (Criteria) this;
		}

		public Criteria andHouseDeptnameIsNull() {
			addCriterion("HOUSE_DEPTNAME is null");
			return (Criteria) this;
		}

		public Criteria andHouseDeptnameIsNotNull() {
			addCriterion("HOUSE_DEPTNAME is not null");
			return (Criteria) this;
		}

		public Criteria andHouseDeptnameEqualTo(String value) {
			addCriterion("HOUSE_DEPTNAME =", value, "houseDeptname");
			return (Criteria) this;
		}

		public Criteria andHouseDeptnameNotEqualTo(String value) {
			addCriterion("HOUSE_DEPTNAME <>", value, "houseDeptname");
			return (Criteria) this;
		}

		public Criteria andHouseDeptnameGreaterThan(String value) {
			addCriterion("HOUSE_DEPTNAME >", value, "houseDeptname");
			return (Criteria) this;
		}

		public Criteria andHouseDeptnameGreaterThanOrEqualTo(String value) {
			addCriterion("HOUSE_DEPTNAME >=", value, "houseDeptname");
			return (Criteria) this;
		}

		public Criteria andHouseDeptnameLessThan(String value) {
			addCriterion("HOUSE_DEPTNAME <", value, "houseDeptname");
			return (Criteria) this;
		}

		public Criteria andHouseDeptnameLessThanOrEqualTo(String value) {
			addCriterion("HOUSE_DEPTNAME <=", value, "houseDeptname");
			return (Criteria) this;
		}

		public Criteria andHouseDeptnameLike(String value) {
			addCriterion("HOUSE_DEPTNAME like", value, "houseDeptname");
			return (Criteria) this;
		}

		public Criteria andHouseDeptnameNotLike(String value) {
			addCriterion("HOUSE_DEPTNAME not like", value, "houseDeptname");
			return (Criteria) this;
		}

		public Criteria andHouseDeptnameIn(List<String> values) {
			addCriterion("HOUSE_DEPTNAME in", values, "houseDeptname");
			return (Criteria) this;
		}

		public Criteria andHouseDeptnameNotIn(List<String> values) {
			addCriterion("HOUSE_DEPTNAME not in", values, "houseDeptname");
			return (Criteria) this;
		}

		public Criteria andHouseDeptnameBetween(String value1, String value2) {
			addCriterion("HOUSE_DEPTNAME between", value1, value2, "houseDeptname");
			return (Criteria) this;
		}

		public Criteria andHouseDeptnameNotBetween(String value1, String value2) {
			addCriterion("HOUSE_DEPTNAME not between", value1, value2, "houseDeptname");
			return (Criteria) this;
		}

		public Criteria andHouseUsernameIsNull() {
			addCriterion("HOUSE_USERNAME is null");
			return (Criteria) this;
		}

		public Criteria andHouseUsernameIsNotNull() {
			addCriterion("HOUSE_USERNAME is not null");
			return (Criteria) this;
		}

		public Criteria andHouseUsernameEqualTo(String value) {
			addCriterion("HOUSE_USERNAME =", value, "houseUsername");
			return (Criteria) this;
		}

		public Criteria andHouseUsernameNotEqualTo(String value) {
			addCriterion("HOUSE_USERNAME <>", value, "houseUsername");
			return (Criteria) this;
		}

		public Criteria andHouseUsernameGreaterThan(String value) {
			addCriterion("HOUSE_USERNAME >", value, "houseUsername");
			return (Criteria) this;
		}

		public Criteria andHouseUsernameGreaterThanOrEqualTo(String value) {
			addCriterion("HOUSE_USERNAME >=", value, "houseUsername");
			return (Criteria) this;
		}

		public Criteria andHouseUsernameLessThan(String value) {
			addCriterion("HOUSE_USERNAME <", value, "houseUsername");
			return (Criteria) this;
		}

		public Criteria andHouseUsernameLessThanOrEqualTo(String value) {
			addCriterion("HOUSE_USERNAME <=", value, "houseUsername");
			return (Criteria) this;
		}

		public Criteria andHouseUsernameLike(String value) {
			addCriterion("HOUSE_USERNAME like", value, "houseUsername");
			return (Criteria) this;
		}

		public Criteria andHouseUsernameNotLike(String value) {
			addCriterion("HOUSE_USERNAME not like", value, "houseUsername");
			return (Criteria) this;
		}

		public Criteria andHouseUsernameIn(List<String> values) {
			addCriterion("HOUSE_USERNAME in", values, "houseUsername");
			return (Criteria) this;
		}

		public Criteria andHouseUsernameNotIn(List<String> values) {
			addCriterion("HOUSE_USERNAME not in", values, "houseUsername");
			return (Criteria) this;
		}

		public Criteria andHouseUsernameBetween(String value1, String value2) {
			addCriterion("HOUSE_USERNAME between", value1, value2, "houseUsername");
			return (Criteria) this;
		}

		public Criteria andHouseUsernameNotBetween(String value1, String value2) {
			addCriterion("HOUSE_USERNAME not between", value1, value2, "houseUsername");
			return (Criteria) this;
		}

		public Criteria andHouseUserUidIsNull() {
			addCriterion("HOUSE_USER_UID is null");
			return (Criteria) this;
		}

		public Criteria andHouseUserUidIsNotNull() {
			addCriterion("HOUSE_USER_UID is not null");
			return (Criteria) this;
		}

		public Criteria andHouseUserUidEqualTo(Integer value) {
			addCriterion("HOUSE_USER_UID =", value, "houseUserUid");
			return (Criteria) this;
		}

		public Criteria andHouseUserUidNotEqualTo(Integer value) {
			addCriterion("HOUSE_USER_UID <>", value, "houseUserUid");
			return (Criteria) this;
		}

		public Criteria andHouseUserUidGreaterThan(Integer value) {
			addCriterion("HOUSE_USER_UID >", value, "houseUserUid");
			return (Criteria) this;
		}

		public Criteria andHouseUserUidGreaterThanOrEqualTo(Integer value) {
			addCriterion("HOUSE_USER_UID >=", value, "houseUserUid");
			return (Criteria) this;
		}

		public Criteria andHouseUserUidLessThan(Integer value) {
			addCriterion("HOUSE_USER_UID <", value, "houseUserUid");
			return (Criteria) this;
		}

		public Criteria andHouseUserUidLessThanOrEqualTo(Integer value) {
			addCriterion("HOUSE_USER_UID <=", value, "houseUserUid");
			return (Criteria) this;
		}

		public Criteria andHouseUserUidIn(List<Integer> values) {
			addCriterion("HOUSE_USER_UID in", values, "houseUserUid");
			return (Criteria) this;
		}

		public Criteria andHouseUserUidNotIn(List<Integer> values) {
			addCriterion("HOUSE_USER_UID not in", values, "houseUserUid");
			return (Criteria) this;
		}

		public Criteria andHouseUserUidBetween(Integer value1, Integer value2) {
			addCriterion("HOUSE_USER_UID between", value1, value2, "houseUserUid");
			return (Criteria) this;
		}

		public Criteria andHouseUserUidNotBetween(Integer value1, Integer value2) {
			addCriterion("HOUSE_USER_UID not between", value1, value2, "houseUserUid");
			return (Criteria) this;
		}

		public Criteria andHouseDeptIdIsNull() {
			addCriterion("HOUSE_DEPT_ID is null");
			return (Criteria) this;
		}

		public Criteria andHouseDeptIdIsNotNull() {
			addCriterion("HOUSE_DEPT_ID is not null");
			return (Criteria) this;
		}

		public Criteria andHouseDeptIdEqualTo(Integer value) {
			addCriterion("HOUSE_DEPT_ID =", value, "houseDeptId");
			return (Criteria) this;
		}

		public Criteria andHouseDeptIdNotEqualTo(Integer value) {
			addCriterion("HOUSE_DEPT_ID <>", value, "houseDeptId");
			return (Criteria) this;
		}

		public Criteria andHouseDeptIdGreaterThan(Integer value) {
			addCriterion("HOUSE_DEPT_ID >", value, "houseDeptId");
			return (Criteria) this;
		}

		public Criteria andHouseDeptIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("HOUSE_DEPT_ID >=", value, "houseDeptId");
			return (Criteria) this;
		}

		public Criteria andHouseDeptIdLessThan(Integer value) {
			addCriterion("HOUSE_DEPT_ID <", value, "houseDeptId");
			return (Criteria) this;
		}

		public Criteria andHouseDeptIdLessThanOrEqualTo(Integer value) {
			addCriterion("HOUSE_DEPT_ID <=", value, "houseDeptId");
			return (Criteria) this;
		}

		public Criteria andHouseDeptIdIn(List<Integer> values) {
			addCriterion("HOUSE_DEPT_ID in", values, "houseDeptId");
			return (Criteria) this;
		}

		public Criteria andHouseDeptIdNotIn(List<Integer> values) {
			addCriterion("HOUSE_DEPT_ID not in", values, "houseDeptId");
			return (Criteria) this;
		}

		public Criteria andHouseDeptIdBetween(Integer value1, Integer value2) {
			addCriterion("HOUSE_DEPT_ID between", value1, value2, "houseDeptId");
			return (Criteria) this;
		}

		public Criteria andHouseDeptIdNotBetween(Integer value1, Integer value2) {
			addCriterion("HOUSE_DEPT_ID not between", value1, value2, "houseDeptId");
			return (Criteria) this;
		}

		public Criteria andHousePlateIsNull() {
			addCriterion("HOUSE_PLATE is null");
			return (Criteria) this;
		}

		public Criteria andHousePlateIsNotNull() {
			addCriterion("HOUSE_PLATE is not null");
			return (Criteria) this;
		}

		public Criteria andHousePlateEqualTo(Byte value) {
			addCriterion("HOUSE_PLATE =", value, "housePlate");
			return (Criteria) this;
		}

		public Criteria andHousePlateNotEqualTo(Byte value) {
			addCriterion("HOUSE_PLATE <>", value, "housePlate");
			return (Criteria) this;
		}

		public Criteria andHousePlateGreaterThan(Byte value) {
			addCriterion("HOUSE_PLATE >", value, "housePlate");
			return (Criteria) this;
		}

		public Criteria andHousePlateGreaterThanOrEqualTo(Byte value) {
			addCriterion("HOUSE_PLATE >=", value, "housePlate");
			return (Criteria) this;
		}

		public Criteria andHousePlateLessThan(Byte value) {
			addCriterion("HOUSE_PLATE <", value, "housePlate");
			return (Criteria) this;
		}

		public Criteria andHousePlateLessThanOrEqualTo(Byte value) {
			addCriterion("HOUSE_PLATE <=", value, "housePlate");
			return (Criteria) this;
		}

		public Criteria andHousePlateIn(List<Byte> values) {
			addCriterion("HOUSE_PLATE in", values, "housePlate");
			return (Criteria) this;
		}

		public Criteria andHousePlateNotIn(List<Byte> values) {
			addCriterion("HOUSE_PLATE not in", values, "housePlate");
			return (Criteria) this;
		}

		public Criteria andHousePlateBetween(Byte value1, Byte value2) {
			addCriterion("HOUSE_PLATE between", value1, value2, "housePlate");
			return (Criteria) this;
		}

		public Criteria andHousePlateNotBetween(Byte value1, Byte value2) {
			addCriterion("HOUSE_PLATE not between", value1, value2, "housePlate");
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

		public Criteria andHouseaddressIsNull() {
			addCriterion("HOUSEADDRESS is null");
			return (Criteria) this;
		}

		public Criteria andHouseaddressIsNotNull() {
			addCriterion("HOUSEADDRESS is not null");
			return (Criteria) this;
		}

		public Criteria andHouseaddressEqualTo(String value) {
			addCriterion("HOUSEADDRESS =", value, "houseaddress");
			return (Criteria) this;
		}

		public Criteria andHouseaddressNotEqualTo(String value) {
			addCriterion("HOUSEADDRESS <>", value, "houseaddress");
			return (Criteria) this;
		}

		public Criteria andHouseaddressGreaterThan(String value) {
			addCriterion("HOUSEADDRESS >", value, "houseaddress");
			return (Criteria) this;
		}

		public Criteria andHouseaddressGreaterThanOrEqualTo(String value) {
			addCriterion("HOUSEADDRESS >=", value, "houseaddress");
			return (Criteria) this;
		}

		public Criteria andHouseaddressLessThan(String value) {
			addCriterion("HOUSEADDRESS <", value, "houseaddress");
			return (Criteria) this;
		}

		public Criteria andHouseaddressLessThanOrEqualTo(String value) {
			addCriterion("HOUSEADDRESS <=", value, "houseaddress");
			return (Criteria) this;
		}

		public Criteria andHouseaddressLike(String value) {
			addCriterion("HOUSEADDRESS like", value, "houseaddress");
			return (Criteria) this;
		}

		public Criteria andHouseaddressNotLike(String value) {
			addCriterion("HOUSEADDRESS not like", value, "houseaddress");
			return (Criteria) this;
		}

		public Criteria andHouseaddressIn(List<String> values) {
			addCriterion("HOUSEADDRESS in", values, "houseaddress");
			return (Criteria) this;
		}

		public Criteria andHouseaddressNotIn(List<String> values) {
			addCriterion("HOUSEADDRESS not in", values, "houseaddress");
			return (Criteria) this;
		}

		public Criteria andHouseaddressBetween(String value1, String value2) {
			addCriterion("HOUSEADDRESS between", value1, value2, "houseaddress");
			return (Criteria) this;
		}

		public Criteria andHouseaddressNotBetween(String value1, String value2) {
			addCriterion("HOUSEADDRESS not between", value1, value2, "houseaddress");
			return (Criteria) this;
		}

		public Criteria andRealTotalpriceIsNull() {
			addCriterion("REAL_TOTALPRICE is null");
			return (Criteria) this;
		}

		public Criteria andRealTotalpriceIsNotNull() {
			addCriterion("REAL_TOTALPRICE is not null");
			return (Criteria) this;
		}

		public Criteria andRealTotalpriceEqualTo(BigDecimal value) {
			addCriterion("REAL_TOTALPRICE =", value, "realTotalprice");
			return (Criteria) this;
		}

		public Criteria andRealTotalpriceNotEqualTo(BigDecimal value) {
			addCriterion("REAL_TOTALPRICE <>", value, "realTotalprice");
			return (Criteria) this;
		}

		public Criteria andRealTotalpriceGreaterThan(BigDecimal value) {
			addCriterion("REAL_TOTALPRICE >", value, "realTotalprice");
			return (Criteria) this;
		}

		public Criteria andRealTotalpriceGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("REAL_TOTALPRICE >=", value, "realTotalprice");
			return (Criteria) this;
		}

		public Criteria andRealTotalpriceLessThan(BigDecimal value) {
			addCriterion("REAL_TOTALPRICE <", value, "realTotalprice");
			return (Criteria) this;
		}

		public Criteria andRealTotalpriceLessThanOrEqualTo(BigDecimal value) {
			addCriterion("REAL_TOTALPRICE <=", value, "realTotalprice");
			return (Criteria) this;
		}

		public Criteria andRealTotalpriceIn(List<BigDecimal> values) {
			addCriterion("REAL_TOTALPRICE in", values, "realTotalprice");
			return (Criteria) this;
		}

		public Criteria andRealTotalpriceNotIn(List<BigDecimal> values) {
			addCriterion("REAL_TOTALPRICE not in", values, "realTotalprice");
			return (Criteria) this;
		}

		public Criteria andRealTotalpriceBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("REAL_TOTALPRICE between", value1, value2, "realTotalprice");
			return (Criteria) this;
		}

		public Criteria andRealTotalpriceNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("REAL_TOTALPRICE not between", value1, value2, "realTotalprice");
			return (Criteria) this;
		}

		public Criteria andDealDeptIdIsNull() {
			addCriterion("DEAL_DEPT_ID is null");
			return (Criteria) this;
		}

		public Criteria andDealDeptIdIsNotNull() {
			addCriterion("DEAL_DEPT_ID is not null");
			return (Criteria) this;
		}

		public Criteria andDealDeptIdEqualTo(Integer value) {
			addCriterion("DEAL_DEPT_ID =", value, "dealDeptId");
			return (Criteria) this;
		}

		public Criteria andDealDeptIdNotEqualTo(Integer value) {
			addCriterion("DEAL_DEPT_ID <>", value, "dealDeptId");
			return (Criteria) this;
		}

		public Criteria andDealDeptIdGreaterThan(Integer value) {
			addCriterion("DEAL_DEPT_ID >", value, "dealDeptId");
			return (Criteria) this;
		}

		public Criteria andDealDeptIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("DEAL_DEPT_ID >=", value, "dealDeptId");
			return (Criteria) this;
		}

		public Criteria andDealDeptIdLessThan(Integer value) {
			addCriterion("DEAL_DEPT_ID <", value, "dealDeptId");
			return (Criteria) this;
		}

		public Criteria andDealDeptIdLessThanOrEqualTo(Integer value) {
			addCriterion("DEAL_DEPT_ID <=", value, "dealDeptId");
			return (Criteria) this;
		}

		public Criteria andDealDeptIdIn(List<Integer> values) {
			addCriterion("DEAL_DEPT_ID in", values, "dealDeptId");
			return (Criteria) this;
		}

		public Criteria andDealDeptIdNotIn(List<Integer> values) {
			addCriterion("DEAL_DEPT_ID not in", values, "dealDeptId");
			return (Criteria) this;
		}

		public Criteria andDealDeptIdBetween(Integer value1, Integer value2) {
			addCriterion("DEAL_DEPT_ID between", value1, value2, "dealDeptId");
			return (Criteria) this;
		}

		public Criteria andDealDeptIdNotBetween(Integer value1, Integer value2) {
			addCriterion("DEAL_DEPT_ID not between", value1, value2, "dealDeptId");
			return (Criteria) this;
		}

		public Criteria andHouseDuetimeTaskIdIsNull() {
			addCriterion("HOUSE_DUETIME_TASK_ID is null");
			return (Criteria) this;
		}

		public Criteria andHouseDuetimeTaskIdIsNotNull() {
			addCriterion("HOUSE_DUETIME_TASK_ID is not null");
			return (Criteria) this;
		}

		public Criteria andHouseDuetimeTaskIdEqualTo(Integer value) {
			addCriterion("HOUSE_DUETIME_TASK_ID =", value, "houseDuetimeTaskId");
			return (Criteria) this;
		}

		public Criteria andHouseDuetimeTaskIdNotEqualTo(Integer value) {
			addCriterion("HOUSE_DUETIME_TASK_ID <>", value, "houseDuetimeTaskId");
			return (Criteria) this;
		}

		public Criteria andHouseDuetimeTaskIdGreaterThan(Integer value) {
			addCriterion("HOUSE_DUETIME_TASK_ID >", value, "houseDuetimeTaskId");
			return (Criteria) this;
		}

		public Criteria andHouseDuetimeTaskIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("HOUSE_DUETIME_TASK_ID >=", value, "houseDuetimeTaskId");
			return (Criteria) this;
		}

		public Criteria andHouseDuetimeTaskIdLessThan(Integer value) {
			addCriterion("HOUSE_DUETIME_TASK_ID <", value, "houseDuetimeTaskId");
			return (Criteria) this;
		}

		public Criteria andHouseDuetimeTaskIdLessThanOrEqualTo(Integer value) {
			addCriterion("HOUSE_DUETIME_TASK_ID <=", value, "houseDuetimeTaskId");
			return (Criteria) this;
		}

		public Criteria andHouseDuetimeTaskIdIn(List<Integer> values) {
			addCriterion("HOUSE_DUETIME_TASK_ID in", values, "houseDuetimeTaskId");
			return (Criteria) this;
		}

		public Criteria andHouseDuetimeTaskIdNotIn(List<Integer> values) {
			addCriterion("HOUSE_DUETIME_TASK_ID not in", values, "houseDuetimeTaskId");
			return (Criteria) this;
		}

		public Criteria andHouseDuetimeTaskIdBetween(Integer value1, Integer value2) {
			addCriterion("HOUSE_DUETIME_TASK_ID between", value1, value2, "houseDuetimeTaskId");
			return (Criteria) this;
		}

		public Criteria andHouseDuetimeTaskIdNotBetween(Integer value1, Integer value2) {
			addCriterion("HOUSE_DUETIME_TASK_ID not between", value1, value2, "houseDuetimeTaskId");
			return (Criteria) this;
		}

		public Criteria andCustDuetimeTaskIdIsNull() {
			addCriterion("CUST_DUETIME_TASK_ID is null");
			return (Criteria) this;
		}

		public Criteria andCustDuetimeTaskIdIsNotNull() {
			addCriterion("CUST_DUETIME_TASK_ID is not null");
			return (Criteria) this;
		}

		public Criteria andCustDuetimeTaskIdEqualTo(Integer value) {
			addCriterion("CUST_DUETIME_TASK_ID =", value, "custDuetimeTaskId");
			return (Criteria) this;
		}

		public Criteria andCustDuetimeTaskIdNotEqualTo(Integer value) {
			addCriterion("CUST_DUETIME_TASK_ID <>", value, "custDuetimeTaskId");
			return (Criteria) this;
		}

		public Criteria andCustDuetimeTaskIdGreaterThan(Integer value) {
			addCriterion("CUST_DUETIME_TASK_ID >", value, "custDuetimeTaskId");
			return (Criteria) this;
		}

		public Criteria andCustDuetimeTaskIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("CUST_DUETIME_TASK_ID >=", value, "custDuetimeTaskId");
			return (Criteria) this;
		}

		public Criteria andCustDuetimeTaskIdLessThan(Integer value) {
			addCriterion("CUST_DUETIME_TASK_ID <", value, "custDuetimeTaskId");
			return (Criteria) this;
		}

		public Criteria andCustDuetimeTaskIdLessThanOrEqualTo(Integer value) {
			addCriterion("CUST_DUETIME_TASK_ID <=", value, "custDuetimeTaskId");
			return (Criteria) this;
		}

		public Criteria andCustDuetimeTaskIdIn(List<Integer> values) {
			addCriterion("CUST_DUETIME_TASK_ID in", values, "custDuetimeTaskId");
			return (Criteria) this;
		}

		public Criteria andCustDuetimeTaskIdNotIn(List<Integer> values) {
			addCriterion("CUST_DUETIME_TASK_ID not in", values, "custDuetimeTaskId");
			return (Criteria) this;
		}

		public Criteria andCustDuetimeTaskIdBetween(Integer value1, Integer value2) {
			addCriterion("CUST_DUETIME_TASK_ID between", value1, value2, "custDuetimeTaskId");
			return (Criteria) this;
		}

		public Criteria andCustDuetimeTaskIdNotBetween(Integer value1, Integer value2) {
			addCriterion("CUST_DUETIME_TASK_ID not between", value1, value2, "custDuetimeTaskId");
			return (Criteria) this;
		}

		public Criteria andModelIdIsNull() {
			addCriterion("MODEL_ID is null");
			return (Criteria) this;
		}

		public Criteria andModelIdIsNotNull() {
			addCriterion("MODEL_ID is not null");
			return (Criteria) this;
		}

		public Criteria andModelIdEqualTo(Integer value) {
			addCriterion("MODEL_ID =", value, "modelId");
			return (Criteria) this;
		}

		public Criteria andModelIdNotEqualTo(Integer value) {
			addCriterion("MODEL_ID <>", value, "modelId");
			return (Criteria) this;
		}

		public Criteria andModelIdGreaterThan(Integer value) {
			addCriterion("MODEL_ID >", value, "modelId");
			return (Criteria) this;
		}

		public Criteria andModelIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("MODEL_ID >=", value, "modelId");
			return (Criteria) this;
		}

		public Criteria andModelIdLessThan(Integer value) {
			addCriterion("MODEL_ID <", value, "modelId");
			return (Criteria) this;
		}

		public Criteria andModelIdLessThanOrEqualTo(Integer value) {
			addCriterion("MODEL_ID <=", value, "modelId");
			return (Criteria) this;
		}

		public Criteria andModelIdIn(List<Integer> values) {
			addCriterion("MODEL_ID in", values, "modelId");
			return (Criteria) this;
		}

		public Criteria andModelIdNotIn(List<Integer> values) {
			addCriterion("MODEL_ID not in", values, "modelId");
			return (Criteria) this;
		}

		public Criteria andModelIdBetween(Integer value1, Integer value2) {
			addCriterion("MODEL_ID between", value1, value2, "modelId");
			return (Criteria) this;
		}

		public Criteria andModelIdNotBetween(Integer value1, Integer value2) {
			addCriterion("MODEL_ID not between", value1, value2, "modelId");
			return (Criteria) this;
		}

		public Criteria andContractNoIsNull() {
			addCriterion("CONTRACT_NO is null");
			return (Criteria) this;
		}

		public Criteria andContractNoIsNotNull() {
			addCriterion("CONTRACT_NO is not null");
			return (Criteria) this;
		}

		public Criteria andContractNoEqualTo(String value) {
			addCriterion("CONTRACT_NO =", value, "contractNo");
			return (Criteria) this;
		}

		public Criteria andContractNoNotEqualTo(String value) {
			addCriterion("CONTRACT_NO <>", value, "contractNo");
			return (Criteria) this;
		}

		public Criteria andContractNoGreaterThan(String value) {
			addCriterion("CONTRACT_NO >", value, "contractNo");
			return (Criteria) this;
		}

		public Criteria andContractNoGreaterThanOrEqualTo(String value) {
			addCriterion("CONTRACT_NO >=", value, "contractNo");
			return (Criteria) this;
		}

		public Criteria andContractNoLessThan(String value) {
			addCriterion("CONTRACT_NO <", value, "contractNo");
			return (Criteria) this;
		}

		public Criteria andContractNoLessThanOrEqualTo(String value) {
			addCriterion("CONTRACT_NO <=", value, "contractNo");
			return (Criteria) this;
		}

		public Criteria andContractNoLike(String value) {
			addCriterion("CONTRACT_NO like", value, "contractNo");
			return (Criteria) this;
		}

		public Criteria andContractNoNotLike(String value) {
			addCriterion("CONTRACT_NO not like", value, "contractNo");
			return (Criteria) this;
		}

		public Criteria andContractNoIn(List<String> values) {
			addCriterion("CONTRACT_NO in", values, "contractNo");
			return (Criteria) this;
		}

		public Criteria andContractNoNotIn(List<String> values) {
			addCriterion("CONTRACT_NO not in", values, "contractNo");
			return (Criteria) this;
		}

		public Criteria andContractNoBetween(String value1, String value2) {
			addCriterion("CONTRACT_NO between", value1, value2, "contractNo");
			return (Criteria) this;
		}

		public Criteria andContractNoNotBetween(String value1, String value2) {
			addCriterion("CONTRACT_NO not between", value1, value2, "contractNo");
			return (Criteria) this;
		}

		public Criteria andRunstepIdIsNull() {
			addCriterion("RUNSTEP_ID is null");
			return (Criteria) this;
		}

		public Criteria andRunstepIdIsNotNull() {
			addCriterion("RUNSTEP_ID is not null");
			return (Criteria) this;
		}

		public Criteria andRunstepIdEqualTo(Integer value) {
			addCriterion("RUNSTEP_ID =", value, "runstepId");
			return (Criteria) this;
		}

		public Criteria andRunstepIdNotEqualTo(Integer value) {
			addCriterion("RUNSTEP_ID <>", value, "runstepId");
			return (Criteria) this;
		}

		public Criteria andRunstepIdGreaterThan(Integer value) {
			addCriterion("RUNSTEP_ID >", value, "runstepId");
			return (Criteria) this;
		}

		public Criteria andRunstepIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("RUNSTEP_ID >=", value, "runstepId");
			return (Criteria) this;
		}

		public Criteria andRunstepIdLessThan(Integer value) {
			addCriterion("RUNSTEP_ID <", value, "runstepId");
			return (Criteria) this;
		}

		public Criteria andRunstepIdLessThanOrEqualTo(Integer value) {
			addCriterion("RUNSTEP_ID <=", value, "runstepId");
			return (Criteria) this;
		}

		public Criteria andRunstepIdIn(List<Integer> values) {
			addCriterion("RUNSTEP_ID in", values, "runstepId");
			return (Criteria) this;
		}

		public Criteria andRunstepIdNotIn(List<Integer> values) {
			addCriterion("RUNSTEP_ID not in", values, "runstepId");
			return (Criteria) this;
		}

		public Criteria andRunstepIdBetween(Integer value1, Integer value2) {
			addCriterion("RUNSTEP_ID between", value1, value2, "runstepId");
			return (Criteria) this;
		}

		public Criteria andRunstepIdNotBetween(Integer value1, Integer value2) {
			addCriterion("RUNSTEP_ID not between", value1, value2, "runstepId");
			return (Criteria) this;
		}

		public Criteria andRunstepNameIsNull() {
			addCriterion("RUNSTEP_NAME is null");
			return (Criteria) this;
		}

		public Criteria andRunstepNameIsNotNull() {
			addCriterion("RUNSTEP_NAME is not null");
			return (Criteria) this;
		}

		public Criteria andRunstepNameEqualTo(String value) {
			addCriterion("RUNSTEP_NAME =", value, "runstepName");
			return (Criteria) this;
		}

		public Criteria andRunstepNameNotEqualTo(String value) {
			addCriterion("RUNSTEP_NAME <>", value, "runstepName");
			return (Criteria) this;
		}

		public Criteria andRunstepNameGreaterThan(String value) {
			addCriterion("RUNSTEP_NAME >", value, "runstepName");
			return (Criteria) this;
		}

		public Criteria andRunstepNameGreaterThanOrEqualTo(String value) {
			addCriterion("RUNSTEP_NAME >=", value, "runstepName");
			return (Criteria) this;
		}

		public Criteria andRunstepNameLessThan(String value) {
			addCriterion("RUNSTEP_NAME <", value, "runstepName");
			return (Criteria) this;
		}

		public Criteria andRunstepNameLessThanOrEqualTo(String value) {
			addCriterion("RUNSTEP_NAME <=", value, "runstepName");
			return (Criteria) this;
		}

		public Criteria andRunstepNameLike(String value) {
			addCriterion("RUNSTEP_NAME like", value, "runstepName");
			return (Criteria) this;
		}

		public Criteria andRunstepNameNotLike(String value) {
			addCriterion("RUNSTEP_NAME not like", value, "runstepName");
			return (Criteria) this;
		}

		public Criteria andRunstepNameIn(List<String> values) {
			addCriterion("RUNSTEP_NAME in", values, "runstepName");
			return (Criteria) this;
		}

		public Criteria andRunstepNameNotIn(List<String> values) {
			addCriterion("RUNSTEP_NAME not in", values, "runstepName");
			return (Criteria) this;
		}

		public Criteria andRunstepNameBetween(String value1, String value2) {
			addCriterion("RUNSTEP_NAME between", value1, value2, "runstepName");
			return (Criteria) this;
		}

		public Criteria andRunstepNameNotBetween(String value1, String value2) {
			addCriterion("RUNSTEP_NAME not between", value1, value2, "runstepName");
			return (Criteria) this;
		}

		public Criteria andTimelimitdateIsNull() {
			addCriterion("TIMELIMITDATE is null");
			return (Criteria) this;
		}

		public Criteria andTimelimitdateIsNotNull() {
			addCriterion("TIMELIMITDATE is not null");
			return (Criteria) this;
		}

		public Criteria andTimelimitdateEqualTo(String value) {
			addCriterion("TIMELIMITDATE =", value, "timelimitdate");
			return (Criteria) this;
		}

		public Criteria andTimelimitdateNotEqualTo(String value) {
			addCriterion("TIMELIMITDATE <>", value, "timelimitdate");
			return (Criteria) this;
		}

		public Criteria andTimelimitdateGreaterThan(String value) {
			addCriterion("TIMELIMITDATE >", value, "timelimitdate");
			return (Criteria) this;
		}

		public Criteria andTimelimitdateGreaterThanOrEqualTo(String value) {
			addCriterion("TIMELIMITDATE >=", value, "timelimitdate");
			return (Criteria) this;
		}

		public Criteria andTimelimitdateLessThan(String value) {
			addCriterion("TIMELIMITDATE <", value, "timelimitdate");
			return (Criteria) this;
		}

		public Criteria andTimelimitdateLessThanOrEqualTo(String value) {
			addCriterion("TIMELIMITDATE <=", value, "timelimitdate");
			return (Criteria) this;
		}

		public Criteria andTimelimitdateLike(String value) {
			addCriterion("TIMELIMITDATE like", value, "timelimitdate");
			return (Criteria) this;
		}

		public Criteria andTimelimitdateNotLike(String value) {
			addCriterion("TIMELIMITDATE not like", value, "timelimitdate");
			return (Criteria) this;
		}

		public Criteria andTimelimitdateIn(List<String> values) {
			addCriterion("TIMELIMITDATE in", values, "timelimitdate");
			return (Criteria) this;
		}

		public Criteria andTimelimitdateNotIn(List<String> values) {
			addCriterion("TIMELIMITDATE not in", values, "timelimitdate");
			return (Criteria) this;
		}

		public Criteria andTimelimitdateBetween(String value1, String value2) {
			addCriterion("TIMELIMITDATE between", value1, value2, "timelimitdate");
			return (Criteria) this;
		}

		public Criteria andTimelimitdateNotBetween(String value1, String value2) {
			addCriterion("TIMELIMITDATE not between", value1, value2, "timelimitdate");
			return (Criteria) this;
		}

		public Criteria andExecutorIsNull() {
			addCriterion("EXECUTOR is null");
			return (Criteria) this;
		}

		public Criteria andExecutorIsNotNull() {
			addCriterion("EXECUTOR is not null");
			return (Criteria) this;
		}

		public Criteria andExecutorEqualTo(Integer value) {
			addCriterion("EXECUTOR =", value, "executor");
			return (Criteria) this;
		}

		public Criteria andExecutorNotEqualTo(Integer value) {
			addCriterion("EXECUTOR <>", value, "executor");
			return (Criteria) this;
		}

		public Criteria andExecutorGreaterThan(Integer value) {
			addCriterion("EXECUTOR >", value, "executor");
			return (Criteria) this;
		}

		public Criteria andExecutorGreaterThanOrEqualTo(Integer value) {
			addCriterion("EXECUTOR >=", value, "executor");
			return (Criteria) this;
		}

		public Criteria andExecutorLessThan(Integer value) {
			addCriterion("EXECUTOR <", value, "executor");
			return (Criteria) this;
		}

		public Criteria andExecutorLessThanOrEqualTo(Integer value) {
			addCriterion("EXECUTOR <=", value, "executor");
			return (Criteria) this;
		}

		public Criteria andExecutorIn(List<Integer> values) {
			addCriterion("EXECUTOR in", values, "executor");
			return (Criteria) this;
		}

		public Criteria andExecutorNotIn(List<Integer> values) {
			addCriterion("EXECUTOR not in", values, "executor");
			return (Criteria) this;
		}

		public Criteria andExecutorBetween(Integer value1, Integer value2) {
			addCriterion("EXECUTOR between", value1, value2, "executor");
			return (Criteria) this;
		}

		public Criteria andExecutorNotBetween(Integer value1, Integer value2) {
			addCriterion("EXECUTOR not between", value1, value2, "executor");
			return (Criteria) this;
		}

		public Criteria andRemarkIsNull() {
			addCriterion("REMARK is null");
			return (Criteria) this;
		}

		public Criteria andRemarkIsNotNull() {
			addCriterion("REMARK is not null");
			return (Criteria) this;
		}

		public Criteria andRemarkEqualTo(String value) {
			addCriterion("REMARK =", value, "remark");
			return (Criteria) this;
		}

		public Criteria andRemarkNotEqualTo(String value) {
			addCriterion("REMARK <>", value, "remark");
			return (Criteria) this;
		}

		public Criteria andRemarkGreaterThan(String value) {
			addCriterion("REMARK >", value, "remark");
			return (Criteria) this;
		}

		public Criteria andRemarkGreaterThanOrEqualTo(String value) {
			addCriterion("REMARK >=", value, "remark");
			return (Criteria) this;
		}

		public Criteria andRemarkLessThan(String value) {
			addCriterion("REMARK <", value, "remark");
			return (Criteria) this;
		}

		public Criteria andRemarkLessThanOrEqualTo(String value) {
			addCriterion("REMARK <=", value, "remark");
			return (Criteria) this;
		}

		public Criteria andRemarkLike(String value) {
			addCriterion("REMARK like", value, "remark");
			return (Criteria) this;
		}

		public Criteria andRemarkNotLike(String value) {
			addCriterion("REMARK not like", value, "remark");
			return (Criteria) this;
		}

		public Criteria andRemarkIn(List<String> values) {
			addCriterion("REMARK in", values, "remark");
			return (Criteria) this;
		}

		public Criteria andRemarkNotIn(List<String> values) {
			addCriterion("REMARK not in", values, "remark");
			return (Criteria) this;
		}

		public Criteria andRemarkBetween(String value1, String value2) {
			addCriterion("REMARK between", value1, value2, "remark");
			return (Criteria) this;
		}

		public Criteria andRemarkNotBetween(String value1, String value2) {
			addCriterion("REMARK not between", value1, value2, "remark");
			return (Criteria) this;
		}

		public Criteria andCompleteUserIsNull() {
			addCriterion("COMPLETE_USER is null");
			return (Criteria) this;
		}

		public Criteria andCompleteUserIsNotNull() {
			addCriterion("COMPLETE_USER is not null");
			return (Criteria) this;
		}

		public Criteria andCompleteUserEqualTo(Integer value) {
			addCriterion("COMPLETE_USER =", value, "completeUser");
			return (Criteria) this;
		}

		public Criteria andCompleteUserNotEqualTo(Integer value) {
			addCriterion("COMPLETE_USER <>", value, "completeUser");
			return (Criteria) this;
		}

		public Criteria andCompleteUserGreaterThan(Integer value) {
			addCriterion("COMPLETE_USER >", value, "completeUser");
			return (Criteria) this;
		}

		public Criteria andCompleteUserGreaterThanOrEqualTo(Integer value) {
			addCriterion("COMPLETE_USER >=", value, "completeUser");
			return (Criteria) this;
		}

		public Criteria andCompleteUserLessThan(Integer value) {
			addCriterion("COMPLETE_USER <", value, "completeUser");
			return (Criteria) this;
		}

		public Criteria andCompleteUserLessThanOrEqualTo(Integer value) {
			addCriterion("COMPLETE_USER <=", value, "completeUser");
			return (Criteria) this;
		}

		public Criteria andCompleteUserIn(List<Integer> values) {
			addCriterion("COMPLETE_USER in", values, "completeUser");
			return (Criteria) this;
		}

		public Criteria andCompleteUserNotIn(List<Integer> values) {
			addCriterion("COMPLETE_USER not in", values, "completeUser");
			return (Criteria) this;
		}

		public Criteria andCompleteUserBetween(Integer value1, Integer value2) {
			addCriterion("COMPLETE_USER between", value1, value2, "completeUser");
			return (Criteria) this;
		}

		public Criteria andCompleteUserNotBetween(Integer value1, Integer value2) {
			addCriterion("COMPLETE_USER not between", value1, value2, "completeUser");
			return (Criteria) this;
		}

		public Criteria andCompleteDateIsNull() {
			addCriterion("COMPLETE_DATE is null");
			return (Criteria) this;
		}

		public Criteria andCompleteDateIsNotNull() {
			addCriterion("COMPLETE_DATE is not null");
			return (Criteria) this;
		}

		public Criteria andCompleteDateEqualTo(String value) {
			addCriterion("COMPLETE_DATE =", value, "completeDate");
			return (Criteria) this;
		}

		public Criteria andCompleteDateNotEqualTo(String value) {
			addCriterion("COMPLETE_DATE <>", value, "completeDate");
			return (Criteria) this;
		}

		public Criteria andCompleteDateGreaterThan(String value) {
			addCriterion("COMPLETE_DATE >", value, "completeDate");
			return (Criteria) this;
		}

		public Criteria andCompleteDateGreaterThanOrEqualTo(String value) {
			addCriterion("COMPLETE_DATE >=", value, "completeDate");
			return (Criteria) this;
		}

		public Criteria andCompleteDateLessThan(String value) {
			addCriterion("COMPLETE_DATE <", value, "completeDate");
			return (Criteria) this;
		}

		public Criteria andCompleteDateLessThanOrEqualTo(String value) {
			addCriterion("COMPLETE_DATE <=", value, "completeDate");
			return (Criteria) this;
		}

		public Criteria andCompleteDateLike(String value) {
			addCriterion("COMPLETE_DATE like", value, "completeDate");
			return (Criteria) this;
		}

		public Criteria andCompleteDateNotLike(String value) {
			addCriterion("COMPLETE_DATE not like", value, "completeDate");
			return (Criteria) this;
		}

		public Criteria andCompleteDateIn(List<String> values) {
			addCriterion("COMPLETE_DATE in", values, "completeDate");
			return (Criteria) this;
		}

		public Criteria andCompleteDateNotIn(List<String> values) {
			addCriterion("COMPLETE_DATE not in", values, "completeDate");
			return (Criteria) this;
		}

		public Criteria andCompleteDateBetween(String value1, String value2) {
			addCriterion("COMPLETE_DATE between", value1, value2, "completeDate");
			return (Criteria) this;
		}

		public Criteria andCompleteDateNotBetween(String value1, String value2) {
			addCriterion("COMPLETE_DATE not between", value1, value2, "completeDate");
			return (Criteria) this;
		}

		public Criteria andModelNameIsNull() {
			addCriterion("MODEL_NAME is null");
			return (Criteria) this;
		}

		public Criteria andModelNameIsNotNull() {
			addCriterion("MODEL_NAME is not null");
			return (Criteria) this;
		}

		public Criteria andModelNameEqualTo(String value) {
			addCriterion("MODEL_NAME =", value, "modelName");
			return (Criteria) this;
		}

		public Criteria andModelNameNotEqualTo(String value) {
			addCriterion("MODEL_NAME <>", value, "modelName");
			return (Criteria) this;
		}

		public Criteria andModelNameGreaterThan(String value) {
			addCriterion("MODEL_NAME >", value, "modelName");
			return (Criteria) this;
		}

		public Criteria andModelNameGreaterThanOrEqualTo(String value) {
			addCriterion("MODEL_NAME >=", value, "modelName");
			return (Criteria) this;
		}

		public Criteria andModelNameLessThan(String value) {
			addCriterion("MODEL_NAME <", value, "modelName");
			return (Criteria) this;
		}

		public Criteria andModelNameLessThanOrEqualTo(String value) {
			addCriterion("MODEL_NAME <=", value, "modelName");
			return (Criteria) this;
		}

		public Criteria andModelNameLike(String value) {
			addCriterion("MODEL_NAME like", value, "modelName");
			return (Criteria) this;
		}

		public Criteria andModelNameNotLike(String value) {
			addCriterion("MODEL_NAME not like", value, "modelName");
			return (Criteria) this;
		}

		public Criteria andModelNameIn(List<String> values) {
			addCriterion("MODEL_NAME in", values, "modelName");
			return (Criteria) this;
		}

		public Criteria andModelNameNotIn(List<String> values) {
			addCriterion("MODEL_NAME not in", values, "modelName");
			return (Criteria) this;
		}

		public Criteria andModelNameBetween(String value1, String value2) {
			addCriterion("MODEL_NAME between", value1, value2, "modelName");
			return (Criteria) this;
		}

		public Criteria andModelNameNotBetween(String value1, String value2) {
			addCriterion("MODEL_NAME not between", value1, value2, "modelName");
			return (Criteria) this;
		}

		public Criteria andDealUserNameIsNull() {
			addCriterion("DEAL_USER_NAME is null");
			return (Criteria) this;
		}

		public Criteria andDealUserNameIsNotNull() {
			addCriterion("DEAL_USER_NAME is not null");
			return (Criteria) this;
		}

		public Criteria andDealUserNameEqualTo(String value) {
			addCriterion("DEAL_USER_NAME =", value, "dealUserName");
			return (Criteria) this;
		}

		public Criteria andDealUserNameNotEqualTo(String value) {
			addCriterion("DEAL_USER_NAME <>", value, "dealUserName");
			return (Criteria) this;
		}

		public Criteria andDealUserNameGreaterThan(String value) {
			addCriterion("DEAL_USER_NAME >", value, "dealUserName");
			return (Criteria) this;
		}

		public Criteria andDealUserNameGreaterThanOrEqualTo(String value) {
			addCriterion("DEAL_USER_NAME >=", value, "dealUserName");
			return (Criteria) this;
		}

		public Criteria andDealUserNameLessThan(String value) {
			addCriterion("DEAL_USER_NAME <", value, "dealUserName");
			return (Criteria) this;
		}

		public Criteria andDealUserNameLessThanOrEqualTo(String value) {
			addCriterion("DEAL_USER_NAME <=", value, "dealUserName");
			return (Criteria) this;
		}

		public Criteria andDealUserNameLike(String value) {
			addCriterion("DEAL_USER_NAME like", value, "dealUserName");
			return (Criteria) this;
		}

		public Criteria andDealUserNameNotLike(String value) {
			addCriterion("DEAL_USER_NAME not like", value, "dealUserName");
			return (Criteria) this;
		}

		public Criteria andDealUserNameIn(List<String> values) {
			addCriterion("DEAL_USER_NAME in", values, "dealUserName");
			return (Criteria) this;
		}

		public Criteria andDealUserNameNotIn(List<String> values) {
			addCriterion("DEAL_USER_NAME not in", values, "dealUserName");
			return (Criteria) this;
		}

		public Criteria andDealUserNameBetween(String value1, String value2) {
			addCriterion("DEAL_USER_NAME between", value1, value2, "dealUserName");
			return (Criteria) this;
		}

		public Criteria andDealUserNameNotBetween(String value1, String value2) {
			addCriterion("DEAL_USER_NAME not between", value1, value2, "dealUserName");
			return (Criteria) this;
		}

		public Criteria andCompleteUserNameIsNull() {
			addCriterion("COMPLETE_USER_NAME is null");
			return (Criteria) this;
		}

		public Criteria andCompleteUserNameIsNotNull() {
			addCriterion("COMPLETE_USER_NAME is not null");
			return (Criteria) this;
		}

		public Criteria andCompleteUserNameEqualTo(String value) {
			addCriterion("COMPLETE_USER_NAME =", value, "completeUserName");
			return (Criteria) this;
		}

		public Criteria andCompleteUserNameNotEqualTo(String value) {
			addCriterion("COMPLETE_USER_NAME <>", value, "completeUserName");
			return (Criteria) this;
		}

		public Criteria andCompleteUserNameGreaterThan(String value) {
			addCriterion("COMPLETE_USER_NAME >", value, "completeUserName");
			return (Criteria) this;
		}

		public Criteria andCompleteUserNameGreaterThanOrEqualTo(String value) {
			addCriterion("COMPLETE_USER_NAME >=", value, "completeUserName");
			return (Criteria) this;
		}

		public Criteria andCompleteUserNameLessThan(String value) {
			addCriterion("COMPLETE_USER_NAME <", value, "completeUserName");
			return (Criteria) this;
		}

		public Criteria andCompleteUserNameLessThanOrEqualTo(String value) {
			addCriterion("COMPLETE_USER_NAME <=", value, "completeUserName");
			return (Criteria) this;
		}

		public Criteria andCompleteUserNameLike(String value) {
			addCriterion("COMPLETE_USER_NAME like", value, "completeUserName");
			return (Criteria) this;
		}

		public Criteria andCompleteUserNameNotLike(String value) {
			addCriterion("COMPLETE_USER_NAME not like", value, "completeUserName");
			return (Criteria) this;
		}

		public Criteria andCompleteUserNameIn(List<String> values) {
			addCriterion("COMPLETE_USER_NAME in", values, "completeUserName");
			return (Criteria) this;
		}

		public Criteria andCompleteUserNameNotIn(List<String> values) {
			addCriterion("COMPLETE_USER_NAME not in", values, "completeUserName");
			return (Criteria) this;
		}

		public Criteria andCompleteUserNameBetween(String value1, String value2) {
			addCriterion("COMPLETE_USER_NAME between", value1, value2, "completeUserName");
			return (Criteria) this;
		}

		public Criteria andCompleteUserNameNotBetween(String value1, String value2) {
			addCriterion("COMPLETE_USER_NAME not between", value1, value2, "completeUserName");
			return (Criteria) this;
		}

		public Criteria andCreatorNameIsNull() {
			addCriterion("CREATOR_NAME is null");
			return (Criteria) this;
		}

		public Criteria andCreatorNameIsNotNull() {
			addCriterion("CREATOR_NAME is not null");
			return (Criteria) this;
		}

		public Criteria andCreatorNameEqualTo(String value) {
			addCriterion("CREATOR_NAME =", value, "creatorName");
			return (Criteria) this;
		}

		public Criteria andCreatorNameNotEqualTo(String value) {
			addCriterion("CREATOR_NAME <>", value, "creatorName");
			return (Criteria) this;
		}

		public Criteria andCreatorNameGreaterThan(String value) {
			addCriterion("CREATOR_NAME >", value, "creatorName");
			return (Criteria) this;
		}

		public Criteria andCreatorNameGreaterThanOrEqualTo(String value) {
			addCriterion("CREATOR_NAME >=", value, "creatorName");
			return (Criteria) this;
		}

		public Criteria andCreatorNameLessThan(String value) {
			addCriterion("CREATOR_NAME <", value, "creatorName");
			return (Criteria) this;
		}

		public Criteria andCreatorNameLessThanOrEqualTo(String value) {
			addCriterion("CREATOR_NAME <=", value, "creatorName");
			return (Criteria) this;
		}

		public Criteria andCreatorNameLike(String value) {
			addCriterion("CREATOR_NAME like", value, "creatorName");
			return (Criteria) this;
		}

		public Criteria andCreatorNameNotLike(String value) {
			addCriterion("CREATOR_NAME not like", value, "creatorName");
			return (Criteria) this;
		}

		public Criteria andCreatorNameIn(List<String> values) {
			addCriterion("CREATOR_NAME in", values, "creatorName");
			return (Criteria) this;
		}

		public Criteria andCreatorNameNotIn(List<String> values) {
			addCriterion("CREATOR_NAME not in", values, "creatorName");
			return (Criteria) this;
		}

		public Criteria andCreatorNameBetween(String value1, String value2) {
			addCriterion("CREATOR_NAME between", value1, value2, "creatorName");
			return (Criteria) this;
		}

		public Criteria andCreatorNameNotBetween(String value1, String value2) {
			addCriterion("CREATOR_NAME not between", value1, value2, "creatorName");
			return (Criteria) this;
		}

		public Criteria andAreaIsNull() {
			addCriterion("AREA is null");
			return (Criteria) this;
		}

		public Criteria andAreaIsNotNull() {
			addCriterion("AREA is not null");
			return (Criteria) this;
		}

		public Criteria andAreaEqualTo(BigDecimal value) {
			addCriterion("AREA =", value, "area");
			return (Criteria) this;
		}

		public Criteria andAreaNotEqualTo(BigDecimal value) {
			addCriterion("AREA <>", value, "area");
			return (Criteria) this;
		}

		public Criteria andAreaGreaterThan(BigDecimal value) {
			addCriterion("AREA >", value, "area");
			return (Criteria) this;
		}

		public Criteria andAreaGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("AREA >=", value, "area");
			return (Criteria) this;
		}

		public Criteria andAreaLessThan(BigDecimal value) {
			addCriterion("AREA <", value, "area");
			return (Criteria) this;
		}

		public Criteria andAreaLessThanOrEqualTo(BigDecimal value) {
			addCriterion("AREA <=", value, "area");
			return (Criteria) this;
		}

		public Criteria andAreaIn(List<BigDecimal> values) {
			addCriterion("AREA in", values, "area");
			return (Criteria) this;
		}

		public Criteria andAreaNotIn(List<BigDecimal> values) {
			addCriterion("AREA not in", values, "area");
			return (Criteria) this;
		}

		public Criteria andAreaBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("AREA between", value1, value2, "area");
			return (Criteria) this;
		}

		public Criteria andAreaNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("AREA not between", value1, value2, "area");
			return (Criteria) this;
		}

		public Criteria andFitmentIsNull() {
			addCriterion("FITMENT is null");
			return (Criteria) this;
		}

		public Criteria andFitmentIsNotNull() {
			addCriterion("FITMENT is not null");
			return (Criteria) this;
		}

		public Criteria andFitmentEqualTo(Byte value) {
			addCriterion("FITMENT =", value, "fitment");
			return (Criteria) this;
		}

		public Criteria andFitmentNotEqualTo(Byte value) {
			addCriterion("FITMENT <>", value, "fitment");
			return (Criteria) this;
		}

		public Criteria andFitmentGreaterThan(Byte value) {
			addCriterion("FITMENT >", value, "fitment");
			return (Criteria) this;
		}

		public Criteria andFitmentGreaterThanOrEqualTo(Byte value) {
			addCriterion("FITMENT >=", value, "fitment");
			return (Criteria) this;
		}

		public Criteria andFitmentLessThan(Byte value) {
			addCriterion("FITMENT <", value, "fitment");
			return (Criteria) this;
		}

		public Criteria andFitmentLessThanOrEqualTo(Byte value) {
			addCriterion("FITMENT <=", value, "fitment");
			return (Criteria) this;
		}

		public Criteria andFitmentIn(List<Byte> values) {
			addCriterion("FITMENT in", values, "fitment");
			return (Criteria) this;
		}

		public Criteria andFitmentNotIn(List<Byte> values) {
			addCriterion("FITMENT not in", values, "fitment");
			return (Criteria) this;
		}

		public Criteria andFitmentBetween(Byte value1, Byte value2) {
			addCriterion("FITMENT between", value1, value2, "fitment");
			return (Criteria) this;
		}

		public Criteria andFitmentNotBetween(Byte value1, Byte value2) {
			addCriterion("FITMENT not between", value1, value2, "fitment");
			return (Criteria) this;
		}

		public Criteria andModelNoIsNull() {
			addCriterion("MODEL_NO is null");
			return (Criteria) this;
		}

		public Criteria andModelNoIsNotNull() {
			addCriterion("MODEL_NO is not null");
			return (Criteria) this;
		}

		public Criteria andModelNoEqualTo(Short value) {
			addCriterion("MODEL_NO =", value, "modelNo");
			return (Criteria) this;
		}

		public Criteria andModelNoNotEqualTo(Short value) {
			addCriterion("MODEL_NO <>", value, "modelNo");
			return (Criteria) this;
		}

		public Criteria andModelNoGreaterThan(Short value) {
			addCriterion("MODEL_NO >", value, "modelNo");
			return (Criteria) this;
		}

		public Criteria andModelNoGreaterThanOrEqualTo(Short value) {
			addCriterion("MODEL_NO >=", value, "modelNo");
			return (Criteria) this;
		}

		public Criteria andModelNoLessThan(Short value) {
			addCriterion("MODEL_NO <", value, "modelNo");
			return (Criteria) this;
		}

		public Criteria andModelNoLessThanOrEqualTo(Short value) {
			addCriterion("MODEL_NO <=", value, "modelNo");
			return (Criteria) this;
		}

		public Criteria andModelNoIn(List<Short> values) {
			addCriterion("MODEL_NO in", values, "modelNo");
			return (Criteria) this;
		}

		public Criteria andModelNoNotIn(List<Short> values) {
			addCriterion("MODEL_NO not in", values, "modelNo");
			return (Criteria) this;
		}

		public Criteria andModelNoBetween(Short value1, Short value2) {
			addCriterion("MODEL_NO between", value1, value2, "modelNo");
			return (Criteria) this;
		}

		public Criteria andModelNoNotBetween(Short value1, Short value2) {
			addCriterion("MODEL_NO not between", value1, value2, "modelNo");
			return (Criteria) this;
		}

		public Criteria andStepNoIsNull() {
			addCriterion("STEP_NO is null");
			return (Criteria) this;
		}

		public Criteria andStepNoIsNotNull() {
			addCriterion("STEP_NO is not null");
			return (Criteria) this;
		}

		public Criteria andStepNoEqualTo(Short value) {
			addCriterion("STEP_NO =", value, "stepNo");
			return (Criteria) this;
		}

		public Criteria andStepNoNotEqualTo(Short value) {
			addCriterion("STEP_NO <>", value, "stepNo");
			return (Criteria) this;
		}

		public Criteria andStepNoGreaterThan(Short value) {
			addCriterion("STEP_NO >", value, "stepNo");
			return (Criteria) this;
		}

		public Criteria andStepNoGreaterThanOrEqualTo(Short value) {
			addCriterion("STEP_NO >=", value, "stepNo");
			return (Criteria) this;
		}

		public Criteria andStepNoLessThan(Short value) {
			addCriterion("STEP_NO <", value, "stepNo");
			return (Criteria) this;
		}

		public Criteria andStepNoLessThanOrEqualTo(Short value) {
			addCriterion("STEP_NO <=", value, "stepNo");
			return (Criteria) this;
		}

		public Criteria andStepNoIn(List<Short> values) {
			addCriterion("STEP_NO in", values, "stepNo");
			return (Criteria) this;
		}

		public Criteria andStepNoNotIn(List<Short> values) {
			addCriterion("STEP_NO not in", values, "stepNo");
			return (Criteria) this;
		}

		public Criteria andStepNoBetween(Short value1, Short value2) {
			addCriterion("STEP_NO between", value1, value2, "stepNo");
			return (Criteria) this;
		}

		public Criteria andStepNoNotBetween(Short value1, Short value2) {
			addCriterion("STEP_NO not between", value1, value2, "stepNo");
			return (Criteria) this;
		}

		public Criteria andUpdateUsernameIsNull() {
			addCriterion("UPDATE_USERNAME is null");
			return (Criteria) this;
		}

		public Criteria andUpdateUsernameIsNotNull() {
			addCriterion("UPDATE_USERNAME is not null");
			return (Criteria) this;
		}

		public Criteria andUpdateUsernameEqualTo(String value) {
			addCriterion("UPDATE_USERNAME =", value, "updateUsername");
			return (Criteria) this;
		}

		public Criteria andUpdateUsernameNotEqualTo(String value) {
			addCriterion("UPDATE_USERNAME <>", value, "updateUsername");
			return (Criteria) this;
		}

		public Criteria andUpdateUsernameGreaterThan(String value) {
			addCriterion("UPDATE_USERNAME >", value, "updateUsername");
			return (Criteria) this;
		}

		public Criteria andUpdateUsernameGreaterThanOrEqualTo(String value) {
			addCriterion("UPDATE_USERNAME >=", value, "updateUsername");
			return (Criteria) this;
		}

		public Criteria andUpdateUsernameLessThan(String value) {
			addCriterion("UPDATE_USERNAME <", value, "updateUsername");
			return (Criteria) this;
		}

		public Criteria andUpdateUsernameLessThanOrEqualTo(String value) {
			addCriterion("UPDATE_USERNAME <=", value, "updateUsername");
			return (Criteria) this;
		}

		public Criteria andUpdateUsernameLike(String value) {
			addCriterion("UPDATE_USERNAME like", value, "updateUsername");
			return (Criteria) this;
		}

		public Criteria andUpdateUsernameNotLike(String value) {
			addCriterion("UPDATE_USERNAME not like", value, "updateUsername");
			return (Criteria) this;
		}

		public Criteria andUpdateUsernameIn(List<String> values) {
			addCriterion("UPDATE_USERNAME in", values, "updateUsername");
			return (Criteria) this;
		}

		public Criteria andUpdateUsernameNotIn(List<String> values) {
			addCriterion("UPDATE_USERNAME not in", values, "updateUsername");
			return (Criteria) this;
		}

		public Criteria andUpdateUsernameBetween(String value1, String value2) {
			addCriterion("UPDATE_USERNAME between", value1, value2, "updateUsername");
			return (Criteria) this;
		}

		public Criteria andUpdateUsernameNotBetween(String value1, String value2) {
			addCriterion("UPDATE_USERNAME not between", value1, value2, "updateUsername");
			return (Criteria) this;
		}

		public Criteria andLockFlagIsNull() {
			addCriterion("LOCK_FLAG is null");
			return (Criteria) this;
		}

		public Criteria andLockFlagIsNotNull() {
			addCriterion("LOCK_FLAG is not null");
			return (Criteria) this;
		}

		public Criteria andLockFlagEqualTo(Byte value) {
			addCriterion("LOCK_FLAG =", value, "lockFlag");
			return (Criteria) this;
		}

		public Criteria andLockFlagNotEqualTo(Byte value) {
			addCriterion("LOCK_FLAG <>", value, "lockFlag");
			return (Criteria) this;
		}

		public Criteria andLockFlagGreaterThan(Byte value) {
			addCriterion("LOCK_FLAG >", value, "lockFlag");
			return (Criteria) this;
		}

		public Criteria andLockFlagGreaterThanOrEqualTo(Byte value) {
			addCriterion("LOCK_FLAG >=", value, "lockFlag");
			return (Criteria) this;
		}

		public Criteria andLockFlagLessThan(Byte value) {
			addCriterion("LOCK_FLAG <", value, "lockFlag");
			return (Criteria) this;
		}

		public Criteria andLockFlagLessThanOrEqualTo(Byte value) {
			addCriterion("LOCK_FLAG <=", value, "lockFlag");
			return (Criteria) this;
		}

		public Criteria andLockFlagIn(List<Byte> values) {
			addCriterion("LOCK_FLAG in", values, "lockFlag");
			return (Criteria) this;
		}

		public Criteria andLockFlagNotIn(List<Byte> values) {
			addCriterion("LOCK_FLAG not in", values, "lockFlag");
			return (Criteria) this;
		}

		public Criteria andLockFlagBetween(Byte value1, Byte value2) {
			addCriterion("LOCK_FLAG between", value1, value2, "lockFlag");
			return (Criteria) this;
		}

		public Criteria andLockFlagNotBetween(Byte value1, Byte value2) {
			addCriterion("LOCK_FLAG not between", value1, value2, "lockFlag");
			return (Criteria) this;
		}

		public Criteria andDealInfoTypeIsNull() {
			addCriterion("DEAL_INFO_TYPE is null");
			return (Criteria) this;
		}

		public Criteria andDealInfoTypeIsNotNull() {
			addCriterion("DEAL_INFO_TYPE is not null");
			return (Criteria) this;
		}

		public Criteria andDealInfoTypeEqualTo(Byte value) {
			addCriterion("DEAL_INFO_TYPE =", value, "dealInfoType");
			return (Criteria) this;
		}

		public Criteria andDealInfoTypeNotEqualTo(Byte value) {
			addCriterion("DEAL_INFO_TYPE <>", value, "dealInfoType");
			return (Criteria) this;
		}

		public Criteria andDealInfoTypeGreaterThan(Byte value) {
			addCriterion("DEAL_INFO_TYPE >", value, "dealInfoType");
			return (Criteria) this;
		}

		public Criteria andDealInfoTypeGreaterThanOrEqualTo(Byte value) {
			addCriterion("DEAL_INFO_TYPE >=", value, "dealInfoType");
			return (Criteria) this;
		}

		public Criteria andDealInfoTypeLessThan(Byte value) {
			addCriterion("DEAL_INFO_TYPE <", value, "dealInfoType");
			return (Criteria) this;
		}

		public Criteria andDealInfoTypeLessThanOrEqualTo(Byte value) {
			addCriterion("DEAL_INFO_TYPE <=", value, "dealInfoType");
			return (Criteria) this;
		}

		public Criteria andDealInfoTypeIn(List<Byte> values) {
			addCriterion("DEAL_INFO_TYPE in", values, "dealInfoType");
			return (Criteria) this;
		}

		public Criteria andDealInfoTypeNotIn(List<Byte> values) {
			addCriterion("DEAL_INFO_TYPE not in", values, "dealInfoType");
			return (Criteria) this;
		}

		public Criteria andDealInfoTypeBetween(Byte value1, Byte value2) {
			addCriterion("DEAL_INFO_TYPE between", value1, value2, "dealInfoType");
			return (Criteria) this;
		}

		public Criteria andDealInfoTypeNotBetween(Byte value1, Byte value2) {
			addCriterion("DEAL_INFO_TYPE not between", value1, value2, "dealInfoType");
			return (Criteria) this;
		}

		public Criteria andIsbyhandIsNull() {
			addCriterion("ISBYHAND is null");
			return (Criteria) this;
		}

		public Criteria andIsbyhandIsNotNull() {
			addCriterion("ISBYHAND is not null");
			return (Criteria) this;
		}

		public Criteria andIsbyhandEqualTo(Byte value) {
			addCriterion("ISBYHAND =", value, "isbyhand");
			return (Criteria) this;
		}

		public Criteria andIsbyhandNotEqualTo(Byte value) {
			addCriterion("ISBYHAND <>", value, "isbyhand");
			return (Criteria) this;
		}

		public Criteria andIsbyhandGreaterThan(Byte value) {
			addCriterion("ISBYHAND >", value, "isbyhand");
			return (Criteria) this;
		}

		public Criteria andIsbyhandGreaterThanOrEqualTo(Byte value) {
			addCriterion("ISBYHAND >=", value, "isbyhand");
			return (Criteria) this;
		}

		public Criteria andIsbyhandLessThan(Byte value) {
			addCriterion("ISBYHAND <", value, "isbyhand");
			return (Criteria) this;
		}

		public Criteria andIsbyhandLessThanOrEqualTo(Byte value) {
			addCriterion("ISBYHAND <=", value, "isbyhand");
			return (Criteria) this;
		}

		public Criteria andIsbyhandIn(List<Byte> values) {
			addCriterion("ISBYHAND in", values, "isbyhand");
			return (Criteria) this;
		}

		public Criteria andIsbyhandNotIn(List<Byte> values) {
			addCriterion("ISBYHAND not in", values, "isbyhand");
			return (Criteria) this;
		}

		public Criteria andIsbyhandBetween(Byte value1, Byte value2) {
			addCriterion("ISBYHAND between", value1, value2, "isbyhand");
			return (Criteria) this;
		}

		public Criteria andIsbyhandNotBetween(Byte value1, Byte value2) {
			addCriterion("ISBYHAND not between", value1, value2, "isbyhand");
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

		public Criteria andSignUserIdIsNull() {
			addCriterion("SIGN_USER_ID is null");
			return (Criteria) this;
		}

		public Criteria andSignUserIdIsNotNull() {
			addCriterion("SIGN_USER_ID is not null");
			return (Criteria) this;
		}

		public Criteria andSignUserIdEqualTo(Integer value) {
			addCriterion("SIGN_USER_ID =", value, "signUserId");
			return (Criteria) this;
		}

		public Criteria andSignUserIdNotEqualTo(Integer value) {
			addCriterion("SIGN_USER_ID <>", value, "signUserId");
			return (Criteria) this;
		}

		public Criteria andSignUserIdGreaterThan(Integer value) {
			addCriterion("SIGN_USER_ID >", value, "signUserId");
			return (Criteria) this;
		}

		public Criteria andSignUserIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("SIGN_USER_ID >=", value, "signUserId");
			return (Criteria) this;
		}

		public Criteria andSignUserIdLessThan(Integer value) {
			addCriterion("SIGN_USER_ID <", value, "signUserId");
			return (Criteria) this;
		}

		public Criteria andSignUserIdLessThanOrEqualTo(Integer value) {
			addCriterion("SIGN_USER_ID <=", value, "signUserId");
			return (Criteria) this;
		}

		public Criteria andSignUserIdIn(List<Integer> values) {
			addCriterion("SIGN_USER_ID in", values, "signUserId");
			return (Criteria) this;
		}

		public Criteria andSignUserIdNotIn(List<Integer> values) {
			addCriterion("SIGN_USER_ID not in", values, "signUserId");
			return (Criteria) this;
		}

		public Criteria andSignUserIdBetween(Integer value1, Integer value2) {
			addCriterion("SIGN_USER_ID between", value1, value2, "signUserId");
			return (Criteria) this;
		}

		public Criteria andSignUserIdNotBetween(Integer value1, Integer value2) {
			addCriterion("SIGN_USER_ID not between", value1, value2, "signUserId");
			return (Criteria) this;
		}

		public Criteria andSignUserNameIsNull() {
			addCriterion("SIGN_USER_NAME is null");
			return (Criteria) this;
		}

		public Criteria andSignUserNameIsNotNull() {
			addCriterion("SIGN_USER_NAME is not null");
			return (Criteria) this;
		}

		public Criteria andSignUserNameEqualTo(String value) {
			addCriterion("SIGN_USER_NAME =", value, "signUserName");
			return (Criteria) this;
		}

		public Criteria andSignUserNameNotEqualTo(String value) {
			addCriterion("SIGN_USER_NAME <>", value, "signUserName");
			return (Criteria) this;
		}

		public Criteria andSignUserNameGreaterThan(String value) {
			addCriterion("SIGN_USER_NAME >", value, "signUserName");
			return (Criteria) this;
		}

		public Criteria andSignUserNameGreaterThanOrEqualTo(String value) {
			addCriterion("SIGN_USER_NAME >=", value, "signUserName");
			return (Criteria) this;
		}

		public Criteria andSignUserNameLessThan(String value) {
			addCriterion("SIGN_USER_NAME <", value, "signUserName");
			return (Criteria) this;
		}

		public Criteria andSignUserNameLessThanOrEqualTo(String value) {
			addCriterion("SIGN_USER_NAME <=", value, "signUserName");
			return (Criteria) this;
		}

		public Criteria andSignUserNameLike(String value) {
			addCriterion("SIGN_USER_NAME like", value, "signUserName");
			return (Criteria) this;
		}

		public Criteria andSignUserNameNotLike(String value) {
			addCriterion("SIGN_USER_NAME not like", value, "signUserName");
			return (Criteria) this;
		}

		public Criteria andSignUserNameIn(List<String> values) {
			addCriterion("SIGN_USER_NAME in", values, "signUserName");
			return (Criteria) this;
		}

		public Criteria andSignUserNameNotIn(List<String> values) {
			addCriterion("SIGN_USER_NAME not in", values, "signUserName");
			return (Criteria) this;
		}

		public Criteria andSignUserNameBetween(String value1, String value2) {
			addCriterion("SIGN_USER_NAME between", value1, value2, "signUserName");
			return (Criteria) this;
		}

		public Criteria andSignUserNameNotBetween(String value1, String value2) {
			addCriterion("SIGN_USER_NAME not between", value1, value2, "signUserName");
			return (Criteria) this;
		}

		public Criteria andSignManagerIdIsNull() {
			addCriterion("SIGN_MANAGER_ID is null");
			return (Criteria) this;
		}

		public Criteria andSignManagerIdIsNotNull() {
			addCriterion("SIGN_MANAGER_ID is not null");
			return (Criteria) this;
		}

		public Criteria andSignManagerIdEqualTo(Integer value) {
			addCriterion("SIGN_MANAGER_ID =", value, "signManagerId");
			return (Criteria) this;
		}

		public Criteria andSignManagerIdNotEqualTo(Integer value) {
			addCriterion("SIGN_MANAGER_ID <>", value, "signManagerId");
			return (Criteria) this;
		}

		public Criteria andSignManagerIdGreaterThan(Integer value) {
			addCriterion("SIGN_MANAGER_ID >", value, "signManagerId");
			return (Criteria) this;
		}

		public Criteria andSignManagerIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("SIGN_MANAGER_ID >=", value, "signManagerId");
			return (Criteria) this;
		}

		public Criteria andSignManagerIdLessThan(Integer value) {
			addCriterion("SIGN_MANAGER_ID <", value, "signManagerId");
			return (Criteria) this;
		}

		public Criteria andSignManagerIdLessThanOrEqualTo(Integer value) {
			addCriterion("SIGN_MANAGER_ID <=", value, "signManagerId");
			return (Criteria) this;
		}

		public Criteria andSignManagerIdIn(List<Integer> values) {
			addCriterion("SIGN_MANAGER_ID in", values, "signManagerId");
			return (Criteria) this;
		}

		public Criteria andSignManagerIdNotIn(List<Integer> values) {
			addCriterion("SIGN_MANAGER_ID not in", values, "signManagerId");
			return (Criteria) this;
		}

		public Criteria andSignManagerIdBetween(Integer value1, Integer value2) {
			addCriterion("SIGN_MANAGER_ID between", value1, value2, "signManagerId");
			return (Criteria) this;
		}

		public Criteria andSignManagerIdNotBetween(Integer value1, Integer value2) {
			addCriterion("SIGN_MANAGER_ID not between", value1, value2, "signManagerId");
			return (Criteria) this;
		}

		public Criteria andSignManagerNameIsNull() {
			addCriterion("SIGN_MANAGER_NAME is null");
			return (Criteria) this;
		}

		public Criteria andSignManagerNameIsNotNull() {
			addCriterion("SIGN_MANAGER_NAME is not null");
			return (Criteria) this;
		}

		public Criteria andSignManagerNameEqualTo(String value) {
			addCriterion("SIGN_MANAGER_NAME =", value, "signManagerName");
			return (Criteria) this;
		}

		public Criteria andSignManagerNameNotEqualTo(String value) {
			addCriterion("SIGN_MANAGER_NAME <>", value, "signManagerName");
			return (Criteria) this;
		}

		public Criteria andSignManagerNameGreaterThan(String value) {
			addCriterion("SIGN_MANAGER_NAME >", value, "signManagerName");
			return (Criteria) this;
		}

		public Criteria andSignManagerNameGreaterThanOrEqualTo(String value) {
			addCriterion("SIGN_MANAGER_NAME >=", value, "signManagerName");
			return (Criteria) this;
		}

		public Criteria andSignManagerNameLessThan(String value) {
			addCriterion("SIGN_MANAGER_NAME <", value, "signManagerName");
			return (Criteria) this;
		}

		public Criteria andSignManagerNameLessThanOrEqualTo(String value) {
			addCriterion("SIGN_MANAGER_NAME <=", value, "signManagerName");
			return (Criteria) this;
		}

		public Criteria andSignManagerNameLike(String value) {
			addCriterion("SIGN_MANAGER_NAME like", value, "signManagerName");
			return (Criteria) this;
		}

		public Criteria andSignManagerNameNotLike(String value) {
			addCriterion("SIGN_MANAGER_NAME not like", value, "signManagerName");
			return (Criteria) this;
		}

		public Criteria andSignManagerNameIn(List<String> values) {
			addCriterion("SIGN_MANAGER_NAME in", values, "signManagerName");
			return (Criteria) this;
		}

		public Criteria andSignManagerNameNotIn(List<String> values) {
			addCriterion("SIGN_MANAGER_NAME not in", values, "signManagerName");
			return (Criteria) this;
		}

		public Criteria andSignManagerNameBetween(String value1, String value2) {
			addCriterion("SIGN_MANAGER_NAME between", value1, value2, "signManagerName");
			return (Criteria) this;
		}

		public Criteria andSignManagerNameNotBetween(String value1, String value2) {
			addCriterion("SIGN_MANAGER_NAME not between", value1, value2, "signManagerName");
			return (Criteria) this;
		}

		public Criteria andSignUserDeptIdIsNull() {
			addCriterion("SIGN_USER_DEPT_ID is null");
			return (Criteria) this;
		}

		public Criteria andSignUserDeptIdIsNotNull() {
			addCriterion("SIGN_USER_DEPT_ID is not null");
			return (Criteria) this;
		}

		public Criteria andSignUserDeptIdEqualTo(Integer value) {
			addCriterion("SIGN_USER_DEPT_ID =", value, "signUserDeptId");
			return (Criteria) this;
		}

		public Criteria andSignUserDeptIdNotEqualTo(Integer value) {
			addCriterion("SIGN_USER_DEPT_ID <>", value, "signUserDeptId");
			return (Criteria) this;
		}

		public Criteria andSignUserDeptIdGreaterThan(Integer value) {
			addCriterion("SIGN_USER_DEPT_ID >", value, "signUserDeptId");
			return (Criteria) this;
		}

		public Criteria andSignUserDeptIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("SIGN_USER_DEPT_ID >=", value, "signUserDeptId");
			return (Criteria) this;
		}

		public Criteria andSignUserDeptIdLessThan(Integer value) {
			addCriterion("SIGN_USER_DEPT_ID <", value, "signUserDeptId");
			return (Criteria) this;
		}

		public Criteria andSignUserDeptIdLessThanOrEqualTo(Integer value) {
			addCriterion("SIGN_USER_DEPT_ID <=", value, "signUserDeptId");
			return (Criteria) this;
		}

		public Criteria andSignUserDeptIdIn(List<Integer> values) {
			addCriterion("SIGN_USER_DEPT_ID in", values, "signUserDeptId");
			return (Criteria) this;
		}

		public Criteria andSignUserDeptIdNotIn(List<Integer> values) {
			addCriterion("SIGN_USER_DEPT_ID not in", values, "signUserDeptId");
			return (Criteria) this;
		}

		public Criteria andSignUserDeptIdBetween(Integer value1, Integer value2) {
			addCriterion("SIGN_USER_DEPT_ID between", value1, value2, "signUserDeptId");
			return (Criteria) this;
		}

		public Criteria andSignUserDeptIdNotBetween(Integer value1, Integer value2) {
			addCriterion("SIGN_USER_DEPT_ID not between", value1, value2, "signUserDeptId");
			return (Criteria) this;
		}

		public Criteria andSignUserDeptNameIsNull() {
			addCriterion("SIGN_USER_DEPT_NAME is null");
			return (Criteria) this;
		}

		public Criteria andSignUserDeptNameIsNotNull() {
			addCriterion("SIGN_USER_DEPT_NAME is not null");
			return (Criteria) this;
		}

		public Criteria andSignUserDeptNameEqualTo(String value) {
			addCriterion("SIGN_USER_DEPT_NAME =", value, "signUserDeptName");
			return (Criteria) this;
		}

		public Criteria andSignUserDeptNameNotEqualTo(String value) {
			addCriterion("SIGN_USER_DEPT_NAME <>", value, "signUserDeptName");
			return (Criteria) this;
		}

		public Criteria andSignUserDeptNameGreaterThan(String value) {
			addCriterion("SIGN_USER_DEPT_NAME >", value, "signUserDeptName");
			return (Criteria) this;
		}

		public Criteria andSignUserDeptNameGreaterThanOrEqualTo(String value) {
			addCriterion("SIGN_USER_DEPT_NAME >=", value, "signUserDeptName");
			return (Criteria) this;
		}

		public Criteria andSignUserDeptNameLessThan(String value) {
			addCriterion("SIGN_USER_DEPT_NAME <", value, "signUserDeptName");
			return (Criteria) this;
		}

		public Criteria andSignUserDeptNameLessThanOrEqualTo(String value) {
			addCriterion("SIGN_USER_DEPT_NAME <=", value, "signUserDeptName");
			return (Criteria) this;
		}

		public Criteria andSignUserDeptNameLike(String value) {
			addCriterion("SIGN_USER_DEPT_NAME like", value, "signUserDeptName");
			return (Criteria) this;
		}

		public Criteria andSignUserDeptNameNotLike(String value) {
			addCriterion("SIGN_USER_DEPT_NAME not like", value, "signUserDeptName");
			return (Criteria) this;
		}

		public Criteria andSignUserDeptNameIn(List<String> values) {
			addCriterion("SIGN_USER_DEPT_NAME in", values, "signUserDeptName");
			return (Criteria) this;
		}

		public Criteria andSignUserDeptNameNotIn(List<String> values) {
			addCriterion("SIGN_USER_DEPT_NAME not in", values, "signUserDeptName");
			return (Criteria) this;
		}

		public Criteria andSignUserDeptNameBetween(String value1, String value2) {
			addCriterion("SIGN_USER_DEPT_NAME between", value1, value2, "signUserDeptName");
			return (Criteria) this;
		}

		public Criteria andSignUserDeptNameNotBetween(String value1, String value2) {
			addCriterion("SIGN_USER_DEPT_NAME not between", value1, value2, "signUserDeptName");
			return (Criteria) this;
		}

		public Criteria andSignManagerDeptIdIsNull() {
			addCriterion("SIGN_MANAGER_DEPT_ID is null");
			return (Criteria) this;
		}

		public Criteria andSignManagerDeptIdIsNotNull() {
			addCriterion("SIGN_MANAGER_DEPT_ID is not null");
			return (Criteria) this;
		}

		public Criteria andSignManagerDeptIdEqualTo(Integer value) {
			addCriterion("SIGN_MANAGER_DEPT_ID =", value, "signManagerDeptId");
			return (Criteria) this;
		}

		public Criteria andSignManagerDeptIdNotEqualTo(Integer value) {
			addCriterion("SIGN_MANAGER_DEPT_ID <>", value, "signManagerDeptId");
			return (Criteria) this;
		}

		public Criteria andSignManagerDeptIdGreaterThan(Integer value) {
			addCriterion("SIGN_MANAGER_DEPT_ID >", value, "signManagerDeptId");
			return (Criteria) this;
		}

		public Criteria andSignManagerDeptIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("SIGN_MANAGER_DEPT_ID >=", value, "signManagerDeptId");
			return (Criteria) this;
		}

		public Criteria andSignManagerDeptIdLessThan(Integer value) {
			addCriterion("SIGN_MANAGER_DEPT_ID <", value, "signManagerDeptId");
			return (Criteria) this;
		}

		public Criteria andSignManagerDeptIdLessThanOrEqualTo(Integer value) {
			addCriterion("SIGN_MANAGER_DEPT_ID <=", value, "signManagerDeptId");
			return (Criteria) this;
		}

		public Criteria andSignManagerDeptIdIn(List<Integer> values) {
			addCriterion("SIGN_MANAGER_DEPT_ID in", values, "signManagerDeptId");
			return (Criteria) this;
		}

		public Criteria andSignManagerDeptIdNotIn(List<Integer> values) {
			addCriterion("SIGN_MANAGER_DEPT_ID not in", values, "signManagerDeptId");
			return (Criteria) this;
		}

		public Criteria andSignManagerDeptIdBetween(Integer value1, Integer value2) {
			addCriterion("SIGN_MANAGER_DEPT_ID between", value1, value2, "signManagerDeptId");
			return (Criteria) this;
		}

		public Criteria andSignManagerDeptIdNotBetween(Integer value1, Integer value2) {
			addCriterion("SIGN_MANAGER_DEPT_ID not between", value1, value2, "signManagerDeptId");
			return (Criteria) this;
		}

		public Criteria andSignManagerDeptNameIsNull() {
			addCriterion("SIGN_MANAGER_DEPT_NAME is null");
			return (Criteria) this;
		}

		public Criteria andSignManagerDeptNameIsNotNull() {
			addCriterion("SIGN_MANAGER_DEPT_NAME is not null");
			return (Criteria) this;
		}

		public Criteria andSignManagerDeptNameEqualTo(String value) {
			addCriterion("SIGN_MANAGER_DEPT_NAME =", value, "signManagerDeptName");
			return (Criteria) this;
		}

		public Criteria andSignManagerDeptNameNotEqualTo(String value) {
			addCriterion("SIGN_MANAGER_DEPT_NAME <>", value, "signManagerDeptName");
			return (Criteria) this;
		}

		public Criteria andSignManagerDeptNameGreaterThan(String value) {
			addCriterion("SIGN_MANAGER_DEPT_NAME >", value, "signManagerDeptName");
			return (Criteria) this;
		}

		public Criteria andSignManagerDeptNameGreaterThanOrEqualTo(String value) {
			addCriterion("SIGN_MANAGER_DEPT_NAME >=", value, "signManagerDeptName");
			return (Criteria) this;
		}

		public Criteria andSignManagerDeptNameLessThan(String value) {
			addCriterion("SIGN_MANAGER_DEPT_NAME <", value, "signManagerDeptName");
			return (Criteria) this;
		}

		public Criteria andSignManagerDeptNameLessThanOrEqualTo(String value) {
			addCriterion("SIGN_MANAGER_DEPT_NAME <=", value, "signManagerDeptName");
			return (Criteria) this;
		}

		public Criteria andSignManagerDeptNameLike(String value) {
			addCriterion("SIGN_MANAGER_DEPT_NAME like", value, "signManagerDeptName");
			return (Criteria) this;
		}

		public Criteria andSignManagerDeptNameNotLike(String value) {
			addCriterion("SIGN_MANAGER_DEPT_NAME not like", value, "signManagerDeptName");
			return (Criteria) this;
		}

		public Criteria andSignManagerDeptNameIn(List<String> values) {
			addCriterion("SIGN_MANAGER_DEPT_NAME in", values, "signManagerDeptName");
			return (Criteria) this;
		}

		public Criteria andSignManagerDeptNameNotIn(List<String> values) {
			addCriterion("SIGN_MANAGER_DEPT_NAME not in", values, "signManagerDeptName");
			return (Criteria) this;
		}

		public Criteria andSignManagerDeptNameBetween(String value1, String value2) {
			addCriterion("SIGN_MANAGER_DEPT_NAME between", value1, value2, "signManagerDeptName");
			return (Criteria) this;
		}

		public Criteria andSignManagerDeptNameNotBetween(String value1, String value2) {
			addCriterion("SIGN_MANAGER_DEPT_NAME not between", value1, value2, "signManagerDeptName");
			return (Criteria) this;
		}

		public Criteria andFinancStatusIdIsNull() {
			addCriterion("FINANC_STATUS_ID is null");
			return (Criteria) this;
		}

		public Criteria andFinancStatusIdIsNotNull() {
			addCriterion("FINANC_STATUS_ID is not null");
			return (Criteria) this;
		}

		public Criteria andFinancStatusIdEqualTo(Integer value) {
			addCriterion("FINANC_STATUS_ID =", value, "financStatusId");
			return (Criteria) this;
		}

		public Criteria andFinancStatusIdNotEqualTo(Integer value) {
			addCriterion("FINANC_STATUS_ID <>", value, "financStatusId");
			return (Criteria) this;
		}

		public Criteria andFinancStatusIdGreaterThan(Integer value) {
			addCriterion("FINANC_STATUS_ID >", value, "financStatusId");
			return (Criteria) this;
		}

		public Criteria andFinancStatusIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("FINANC_STATUS_ID >=", value, "financStatusId");
			return (Criteria) this;
		}

		public Criteria andFinancStatusIdLessThan(Integer value) {
			addCriterion("FINANC_STATUS_ID <", value, "financStatusId");
			return (Criteria) this;
		}

		public Criteria andFinancStatusIdLessThanOrEqualTo(Integer value) {
			addCriterion("FINANC_STATUS_ID <=", value, "financStatusId");
			return (Criteria) this;
		}

		public Criteria andFinancStatusIdIn(List<Integer> values) {
			addCriterion("FINANC_STATUS_ID in", values, "financStatusId");
			return (Criteria) this;
		}

		public Criteria andFinancStatusIdNotIn(List<Integer> values) {
			addCriterion("FINANC_STATUS_ID not in", values, "financStatusId");
			return (Criteria) this;
		}

		public Criteria andFinancStatusIdBetween(Integer value1, Integer value2) {
			addCriterion("FINANC_STATUS_ID between", value1, value2, "financStatusId");
			return (Criteria) this;
		}

		public Criteria andFinancStatusIdNotBetween(Integer value1, Integer value2) {
			addCriterion("FINANC_STATUS_ID not between", value1, value2, "financStatusId");
			return (Criteria) this;
		}

		public Criteria andFinancNameIsNull() {
			addCriterion("FINANC_NAME is null");
			return (Criteria) this;
		}

		public Criteria andFinancNameIsNotNull() {
			addCriterion("FINANC_NAME is not null");
			return (Criteria) this;
		}

		public Criteria andFinancNameEqualTo(String value) {
			addCriterion("FINANC_NAME =", value, "financName");
			return (Criteria) this;
		}

		public Criteria andFinancNameNotEqualTo(String value) {
			addCriterion("FINANC_NAME <>", value, "financName");
			return (Criteria) this;
		}

		public Criteria andFinancNameGreaterThan(String value) {
			addCriterion("FINANC_NAME >", value, "financName");
			return (Criteria) this;
		}

		public Criteria andFinancNameGreaterThanOrEqualTo(String value) {
			addCriterion("FINANC_NAME >=", value, "financName");
			return (Criteria) this;
		}

		public Criteria andFinancNameLessThan(String value) {
			addCriterion("FINANC_NAME <", value, "financName");
			return (Criteria) this;
		}

		public Criteria andFinancNameLessThanOrEqualTo(String value) {
			addCriterion("FINANC_NAME <=", value, "financName");
			return (Criteria) this;
		}

		public Criteria andFinancNameLike(String value) {
			addCriterion("FINANC_NAME like", value, "financName");
			return (Criteria) this;
		}

		public Criteria andFinancNameNotLike(String value) {
			addCriterion("FINANC_NAME not like", value, "financName");
			return (Criteria) this;
		}

		public Criteria andFinancNameIn(List<String> values) {
			addCriterion("FINANC_NAME in", values, "financName");
			return (Criteria) this;
		}

		public Criteria andFinancNameNotIn(List<String> values) {
			addCriterion("FINANC_NAME not in", values, "financName");
			return (Criteria) this;
		}

		public Criteria andFinancNameBetween(String value1, String value2) {
			addCriterion("FINANC_NAME between", value1, value2, "financName");
			return (Criteria) this;
		}

		public Criteria andFinancNameNotBetween(String value1, String value2) {
			addCriterion("FINANC_NAME not between", value1, value2, "financName");
			return (Criteria) this;
		}

		public Criteria andCategoryIdIsNull() {
			addCriterion("CATEGORY_ID is null");
			return (Criteria) this;
		}

		public Criteria andCategoryIdIsNotNull() {
			addCriterion("CATEGORY_ID is not null");
			return (Criteria) this;
		}

		public Criteria andCategoryIdEqualTo(Integer value) {
			addCriterion("CATEGORY_ID =", value, "categoryId");
			return (Criteria) this;
		}

		public Criteria andCategoryIdNotEqualTo(Integer value) {
			addCriterion("CATEGORY_ID <>", value, "categoryId");
			return (Criteria) this;
		}

		public Criteria andCategoryIdGreaterThan(Integer value) {
			addCriterion("CATEGORY_ID >", value, "categoryId");
			return (Criteria) this;
		}

		public Criteria andCategoryIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("CATEGORY_ID >=", value, "categoryId");
			return (Criteria) this;
		}

		public Criteria andCategoryIdLessThan(Integer value) {
			addCriterion("CATEGORY_ID <", value, "categoryId");
			return (Criteria) this;
		}

		public Criteria andCategoryIdLessThanOrEqualTo(Integer value) {
			addCriterion("CATEGORY_ID <=", value, "categoryId");
			return (Criteria) this;
		}

		public Criteria andCategoryIdIn(List<Integer> values) {
			addCriterion("CATEGORY_ID in", values, "categoryId");
			return (Criteria) this;
		}

		public Criteria andCategoryIdNotIn(List<Integer> values) {
			addCriterion("CATEGORY_ID not in", values, "categoryId");
			return (Criteria) this;
		}

		public Criteria andCategoryIdBetween(Integer value1, Integer value2) {
			addCriterion("CATEGORY_ID between", value1, value2, "categoryId");
			return (Criteria) this;
		}

		public Criteria andCategoryIdNotBetween(Integer value1, Integer value2) {
			addCriterion("CATEGORY_ID not between", value1, value2, "categoryId");
			return (Criteria) this;
		}

		public Criteria andCategoryNameIsNull() {
			addCriterion("CATEGORY_NAME is null");
			return (Criteria) this;
		}

		public Criteria andCategoryNameIsNotNull() {
			addCriterion("CATEGORY_NAME is not null");
			return (Criteria) this;
		}

		public Criteria andCategoryNameEqualTo(String value) {
			addCriterion("CATEGORY_NAME =", value, "categoryName");
			return (Criteria) this;
		}

		public Criteria andCategoryNameNotEqualTo(String value) {
			addCriterion("CATEGORY_NAME <>", value, "categoryName");
			return (Criteria) this;
		}

		public Criteria andCategoryNameGreaterThan(String value) {
			addCriterion("CATEGORY_NAME >", value, "categoryName");
			return (Criteria) this;
		}

		public Criteria andCategoryNameGreaterThanOrEqualTo(String value) {
			addCriterion("CATEGORY_NAME >=", value, "categoryName");
			return (Criteria) this;
		}

		public Criteria andCategoryNameLessThan(String value) {
			addCriterion("CATEGORY_NAME <", value, "categoryName");
			return (Criteria) this;
		}

		public Criteria andCategoryNameLessThanOrEqualTo(String value) {
			addCriterion("CATEGORY_NAME <=", value, "categoryName");
			return (Criteria) this;
		}

		public Criteria andCategoryNameLike(String value) {
			addCriterion("CATEGORY_NAME like", value, "categoryName");
			return (Criteria) this;
		}

		public Criteria andCategoryNameNotLike(String value) {
			addCriterion("CATEGORY_NAME not like", value, "categoryName");
			return (Criteria) this;
		}

		public Criteria andCategoryNameIn(List<String> values) {
			addCriterion("CATEGORY_NAME in", values, "categoryName");
			return (Criteria) this;
		}

		public Criteria andCategoryNameNotIn(List<String> values) {
			addCriterion("CATEGORY_NAME not in", values, "categoryName");
			return (Criteria) this;
		}

		public Criteria andCategoryNameBetween(String value1, String value2) {
			addCriterion("CATEGORY_NAME between", value1, value2, "categoryName");
			return (Criteria) this;
		}

		public Criteria andCategoryNameNotBetween(String value1, String value2) {
			addCriterion("CATEGORY_NAME not between", value1, value2, "categoryName");
			return (Criteria) this;
		}

		public Criteria andSignDateIsNull() {
			addCriterion("SIGN_DATE is null");
			return (Criteria) this;
		}

		public Criteria andSignDateIsNotNull() {
			addCriterion("SIGN_DATE is not null");
			return (Criteria) this;
		}

		public Criteria andSignDateEqualTo(String value) {
			addCriterion("SIGN_DATE =", value, "signDate");
			return (Criteria) this;
		}

		public Criteria andSignDateNotEqualTo(String value) {
			addCriterion("SIGN_DATE <>", value, "signDate");
			return (Criteria) this;
		}

		public Criteria andSignDateGreaterThan(String value) {
			addCriterion("SIGN_DATE >", value, "signDate");
			return (Criteria) this;
		}

		public Criteria andSignDateGreaterThanOrEqualTo(String value) {
			addCriterion("SIGN_DATE >=", value, "signDate");
			return (Criteria) this;
		}

		public Criteria andSignDateLessThan(String value) {
			addCriterion("SIGN_DATE <", value, "signDate");
			return (Criteria) this;
		}

		public Criteria andSignDateLessThanOrEqualTo(String value) {
			addCriterion("SIGN_DATE <=", value, "signDate");
			return (Criteria) this;
		}

		public Criteria andSignDateLike(String value) {
			addCriterion("SIGN_DATE like", value, "signDate");
			return (Criteria) this;
		}

		public Criteria andSignDateNotLike(String value) {
			addCriterion("SIGN_DATE not like", value, "signDate");
			return (Criteria) this;
		}

		public Criteria andSignDateIn(List<String> values) {
			addCriterion("SIGN_DATE in", values, "signDate");
			return (Criteria) this;
		}

		public Criteria andSignDateNotIn(List<String> values) {
			addCriterion("SIGN_DATE not in", values, "signDate");
			return (Criteria) this;
		}

		public Criteria andSignDateBetween(String value1, String value2) {
			addCriterion("SIGN_DATE between", value1, value2, "signDate");
			return (Criteria) this;
		}

		public Criteria andSignDateNotBetween(String value1, String value2) {
			addCriterion("SIGN_DATE not between", value1, value2, "signDate");
			return (Criteria) this;
		}

		public Criteria andTransferDateIsNull() {
			addCriterion("TRANSFER_DATE is null");
			return (Criteria) this;
		}

		public Criteria andTransferDateIsNotNull() {
			addCriterion("TRANSFER_DATE is not null");
			return (Criteria) this;
		}

		public Criteria andTransferDateEqualTo(String value) {
			addCriterion("TRANSFER_DATE =", value, "transferDate");
			return (Criteria) this;
		}

		public Criteria andTransferDateNotEqualTo(String value) {
			addCriterion("TRANSFER_DATE <>", value, "transferDate");
			return (Criteria) this;
		}

		public Criteria andTransferDateGreaterThan(String value) {
			addCriterion("TRANSFER_DATE >", value, "transferDate");
			return (Criteria) this;
		}

		public Criteria andTransferDateGreaterThanOrEqualTo(String value) {
			addCriterion("TRANSFER_DATE >=", value, "transferDate");
			return (Criteria) this;
		}

		public Criteria andTransferDateLessThan(String value) {
			addCriterion("TRANSFER_DATE <", value, "transferDate");
			return (Criteria) this;
		}

		public Criteria andTransferDateLessThanOrEqualTo(String value) {
			addCriterion("TRANSFER_DATE <=", value, "transferDate");
			return (Criteria) this;
		}

		public Criteria andTransferDateLike(String value) {
			addCriterion("TRANSFER_DATE like", value, "transferDate");
			return (Criteria) this;
		}

		public Criteria andTransferDateNotLike(String value) {
			addCriterion("TRANSFER_DATE not like", value, "transferDate");
			return (Criteria) this;
		}

		public Criteria andTransferDateIn(List<String> values) {
			addCriterion("TRANSFER_DATE in", values, "transferDate");
			return (Criteria) this;
		}

		public Criteria andTransferDateNotIn(List<String> values) {
			addCriterion("TRANSFER_DATE not in", values, "transferDate");
			return (Criteria) this;
		}

		public Criteria andTransferDateBetween(String value1, String value2) {
			addCriterion("TRANSFER_DATE between", value1, value2, "transferDate");
			return (Criteria) this;
		}

		public Criteria andTransferDateNotBetween(String value1, String value2) {
			addCriterion("TRANSFER_DATE not between", value1, value2, "transferDate");
			return (Criteria) this;
		}

		public Criteria andEvidenceDateIsNull() {
			addCriterion("EVIDENCE_DATE is null");
			return (Criteria) this;
		}

		public Criteria andEvidenceDateIsNotNull() {
			addCriterion("EVIDENCE_DATE is not null");
			return (Criteria) this;
		}

		public Criteria andEvidenceDateEqualTo(String value) {
			addCriterion("EVIDENCE_DATE =", value, "evidenceDate");
			return (Criteria) this;
		}

		public Criteria andEvidenceDateNotEqualTo(String value) {
			addCriterion("EVIDENCE_DATE <>", value, "evidenceDate");
			return (Criteria) this;
		}

		public Criteria andEvidenceDateGreaterThan(String value) {
			addCriterion("EVIDENCE_DATE >", value, "evidenceDate");
			return (Criteria) this;
		}

		public Criteria andEvidenceDateGreaterThanOrEqualTo(String value) {
			addCriterion("EVIDENCE_DATE >=", value, "evidenceDate");
			return (Criteria) this;
		}

		public Criteria andEvidenceDateLessThan(String value) {
			addCriterion("EVIDENCE_DATE <", value, "evidenceDate");
			return (Criteria) this;
		}

		public Criteria andEvidenceDateLessThanOrEqualTo(String value) {
			addCriterion("EVIDENCE_DATE <=", value, "evidenceDate");
			return (Criteria) this;
		}

		public Criteria andEvidenceDateLike(String value) {
			addCriterion("EVIDENCE_DATE like", value, "evidenceDate");
			return (Criteria) this;
		}

		public Criteria andEvidenceDateNotLike(String value) {
			addCriterion("EVIDENCE_DATE not like", value, "evidenceDate");
			return (Criteria) this;
		}

		public Criteria andEvidenceDateIn(List<String> values) {
			addCriterion("EVIDENCE_DATE in", values, "evidenceDate");
			return (Criteria) this;
		}

		public Criteria andEvidenceDateNotIn(List<String> values) {
			addCriterion("EVIDENCE_DATE not in", values, "evidenceDate");
			return (Criteria) this;
		}

		public Criteria andEvidenceDateBetween(String value1, String value2) {
			addCriterion("EVIDENCE_DATE between", value1, value2, "evidenceDate");
			return (Criteria) this;
		}

		public Criteria andEvidenceDateNotBetween(String value1, String value2) {
			addCriterion("EVIDENCE_DATE not between", value1, value2, "evidenceDate");
			return (Criteria) this;
		}

		public Criteria andBuyOwnerNameBakIsNull() {
			addCriterion("BUY_OWNER_NAME_BAK is null");
			return (Criteria) this;
		}

		public Criteria andBuyOwnerNameBakIsNotNull() {
			addCriterion("BUY_OWNER_NAME_BAK is not null");
			return (Criteria) this;
		}

		public Criteria andBuyOwnerNameBakEqualTo(String value) {
			addCriterion("BUY_OWNER_NAME_BAK =", value, "buyOwnerNameBak");
			return (Criteria) this;
		}

		public Criteria andBuyOwnerNameBakNotEqualTo(String value) {
			addCriterion("BUY_OWNER_NAME_BAK <>", value, "buyOwnerNameBak");
			return (Criteria) this;
		}

		public Criteria andBuyOwnerNameBakGreaterThan(String value) {
			addCriterion("BUY_OWNER_NAME_BAK >", value, "buyOwnerNameBak");
			return (Criteria) this;
		}

		public Criteria andBuyOwnerNameBakGreaterThanOrEqualTo(String value) {
			addCriterion("BUY_OWNER_NAME_BAK >=", value, "buyOwnerNameBak");
			return (Criteria) this;
		}

		public Criteria andBuyOwnerNameBakLessThan(String value) {
			addCriterion("BUY_OWNER_NAME_BAK <", value, "buyOwnerNameBak");
			return (Criteria) this;
		}

		public Criteria andBuyOwnerNameBakLessThanOrEqualTo(String value) {
			addCriterion("BUY_OWNER_NAME_BAK <=", value, "buyOwnerNameBak");
			return (Criteria) this;
		}

		public Criteria andBuyOwnerNameBakLike(String value) {
			addCriterion("BUY_OWNER_NAME_BAK like", value, "buyOwnerNameBak");
			return (Criteria) this;
		}

		public Criteria andBuyOwnerNameBakNotLike(String value) {
			addCriterion("BUY_OWNER_NAME_BAK not like", value, "buyOwnerNameBak");
			return (Criteria) this;
		}

		public Criteria andBuyOwnerNameBakIn(List<String> values) {
			addCriterion("BUY_OWNER_NAME_BAK in", values, "buyOwnerNameBak");
			return (Criteria) this;
		}

		public Criteria andBuyOwnerNameBakNotIn(List<String> values) {
			addCriterion("BUY_OWNER_NAME_BAK not in", values, "buyOwnerNameBak");
			return (Criteria) this;
		}

		public Criteria andBuyOwnerNameBakBetween(String value1, String value2) {
			addCriterion("BUY_OWNER_NAME_BAK between", value1, value2, "buyOwnerNameBak");
			return (Criteria) this;
		}

		public Criteria andBuyOwnerNameBakNotBetween(String value1, String value2) {
			addCriterion("BUY_OWNER_NAME_BAK not between", value1, value2, "buyOwnerNameBak");
			return (Criteria) this;
		}

		public Criteria andSellOwnerNameBakIsNull() {
			addCriterion("SELL_OWNER_NAME_BAK is null");
			return (Criteria) this;
		}

		public Criteria andSellOwnerNameBakIsNotNull() {
			addCriterion("SELL_OWNER_NAME_BAK is not null");
			return (Criteria) this;
		}

		public Criteria andSellOwnerNameBakEqualTo(String value) {
			addCriterion("SELL_OWNER_NAME_BAK =", value, "sellOwnerNameBak");
			return (Criteria) this;
		}

		public Criteria andSellOwnerNameBakNotEqualTo(String value) {
			addCriterion("SELL_OWNER_NAME_BAK <>", value, "sellOwnerNameBak");
			return (Criteria) this;
		}

		public Criteria andSellOwnerNameBakGreaterThan(String value) {
			addCriterion("SELL_OWNER_NAME_BAK >", value, "sellOwnerNameBak");
			return (Criteria) this;
		}

		public Criteria andSellOwnerNameBakGreaterThanOrEqualTo(String value) {
			addCriterion("SELL_OWNER_NAME_BAK >=", value, "sellOwnerNameBak");
			return (Criteria) this;
		}

		public Criteria andSellOwnerNameBakLessThan(String value) {
			addCriterion("SELL_OWNER_NAME_BAK <", value, "sellOwnerNameBak");
			return (Criteria) this;
		}

		public Criteria andSellOwnerNameBakLessThanOrEqualTo(String value) {
			addCriterion("SELL_OWNER_NAME_BAK <=", value, "sellOwnerNameBak");
			return (Criteria) this;
		}

		public Criteria andSellOwnerNameBakLike(String value) {
			addCriterion("SELL_OWNER_NAME_BAK like", value, "sellOwnerNameBak");
			return (Criteria) this;
		}

		public Criteria andSellOwnerNameBakNotLike(String value) {
			addCriterion("SELL_OWNER_NAME_BAK not like", value, "sellOwnerNameBak");
			return (Criteria) this;
		}

		public Criteria andSellOwnerNameBakIn(List<String> values) {
			addCriterion("SELL_OWNER_NAME_BAK in", values, "sellOwnerNameBak");
			return (Criteria) this;
		}

		public Criteria andSellOwnerNameBakNotIn(List<String> values) {
			addCriterion("SELL_OWNER_NAME_BAK not in", values, "sellOwnerNameBak");
			return (Criteria) this;
		}

		public Criteria andSellOwnerNameBakBetween(String value1, String value2) {
			addCriterion("SELL_OWNER_NAME_BAK between", value1, value2, "sellOwnerNameBak");
			return (Criteria) this;
		}

		public Criteria andSellOwnerNameBakNotBetween(String value1, String value2) {
			addCriterion("SELL_OWNER_NAME_BAK not between", value1, value2, "sellOwnerNameBak");
			return (Criteria) this;
		}

		public Criteria andBuyIdCardBakIsNull() {
			addCriterion("BUY_ID_CARD_BAK is null");
			return (Criteria) this;
		}

		public Criteria andBuyIdCardBakIsNotNull() {
			addCriterion("BUY_ID_CARD_BAK is not null");
			return (Criteria) this;
		}

		public Criteria andBuyIdCardBakEqualTo(String value) {
			addCriterion("BUY_ID_CARD_BAK =", value, "buyIdCardBak");
			return (Criteria) this;
		}

		public Criteria andBuyIdCardBakNotEqualTo(String value) {
			addCriterion("BUY_ID_CARD_BAK <>", value, "buyIdCardBak");
			return (Criteria) this;
		}

		public Criteria andBuyIdCardBakGreaterThan(String value) {
			addCriterion("BUY_ID_CARD_BAK >", value, "buyIdCardBak");
			return (Criteria) this;
		}

		public Criteria andBuyIdCardBakGreaterThanOrEqualTo(String value) {
			addCriterion("BUY_ID_CARD_BAK >=", value, "buyIdCardBak");
			return (Criteria) this;
		}

		public Criteria andBuyIdCardBakLessThan(String value) {
			addCriterion("BUY_ID_CARD_BAK <", value, "buyIdCardBak");
			return (Criteria) this;
		}

		public Criteria andBuyIdCardBakLessThanOrEqualTo(String value) {
			addCriterion("BUY_ID_CARD_BAK <=", value, "buyIdCardBak");
			return (Criteria) this;
		}

		public Criteria andBuyIdCardBakLike(String value) {
			addCriterion("BUY_ID_CARD_BAK like", value, "buyIdCardBak");
			return (Criteria) this;
		}

		public Criteria andBuyIdCardBakNotLike(String value) {
			addCriterion("BUY_ID_CARD_BAK not like", value, "buyIdCardBak");
			return (Criteria) this;
		}

		public Criteria andBuyIdCardBakIn(List<String> values) {
			addCriterion("BUY_ID_CARD_BAK in", values, "buyIdCardBak");
			return (Criteria) this;
		}

		public Criteria andBuyIdCardBakNotIn(List<String> values) {
			addCriterion("BUY_ID_CARD_BAK not in", values, "buyIdCardBak");
			return (Criteria) this;
		}

		public Criteria andBuyIdCardBakBetween(String value1, String value2) {
			addCriterion("BUY_ID_CARD_BAK between", value1, value2, "buyIdCardBak");
			return (Criteria) this;
		}

		public Criteria andBuyIdCardBakNotBetween(String value1, String value2) {
			addCriterion("BUY_ID_CARD_BAK not between", value1, value2, "buyIdCardBak");
			return (Criteria) this;
		}

		public Criteria andSellIdCardBakIsNull() {
			addCriterion("SELL_ID_CARD_BAK is null");
			return (Criteria) this;
		}

		public Criteria andSellIdCardBakIsNotNull() {
			addCriterion("SELL_ID_CARD_BAK is not null");
			return (Criteria) this;
		}

		public Criteria andSellIdCardBakEqualTo(String value) {
			addCriterion("SELL_ID_CARD_BAK =", value, "sellIdCardBak");
			return (Criteria) this;
		}

		public Criteria andSellIdCardBakNotEqualTo(String value) {
			addCriterion("SELL_ID_CARD_BAK <>", value, "sellIdCardBak");
			return (Criteria) this;
		}

		public Criteria andSellIdCardBakGreaterThan(String value) {
			addCriterion("SELL_ID_CARD_BAK >", value, "sellIdCardBak");
			return (Criteria) this;
		}

		public Criteria andSellIdCardBakGreaterThanOrEqualTo(String value) {
			addCriterion("SELL_ID_CARD_BAK >=", value, "sellIdCardBak");
			return (Criteria) this;
		}

		public Criteria andSellIdCardBakLessThan(String value) {
			addCriterion("SELL_ID_CARD_BAK <", value, "sellIdCardBak");
			return (Criteria) this;
		}

		public Criteria andSellIdCardBakLessThanOrEqualTo(String value) {
			addCriterion("SELL_ID_CARD_BAK <=", value, "sellIdCardBak");
			return (Criteria) this;
		}

		public Criteria andSellIdCardBakLike(String value) {
			addCriterion("SELL_ID_CARD_BAK like", value, "sellIdCardBak");
			return (Criteria) this;
		}

		public Criteria andSellIdCardBakNotLike(String value) {
			addCriterion("SELL_ID_CARD_BAK not like", value, "sellIdCardBak");
			return (Criteria) this;
		}

		public Criteria andSellIdCardBakIn(List<String> values) {
			addCriterion("SELL_ID_CARD_BAK in", values, "sellIdCardBak");
			return (Criteria) this;
		}

		public Criteria andSellIdCardBakNotIn(List<String> values) {
			addCriterion("SELL_ID_CARD_BAK not in", values, "sellIdCardBak");
			return (Criteria) this;
		}

		public Criteria andSellIdCardBakBetween(String value1, String value2) {
			addCriterion("SELL_ID_CARD_BAK between", value1, value2, "sellIdCardBak");
			return (Criteria) this;
		}

		public Criteria andSellIdCardBakNotBetween(String value1, String value2) {
			addCriterion("SELL_ID_CARD_BAK not between", value1, value2, "sellIdCardBak");
			return (Criteria) this;
		}

		public Criteria andSalePriceUnitIsNull() {
			addCriterion("SALE_PRICE_UNIT is null");
			return (Criteria) this;
		}

		public Criteria andSalePriceUnitIsNotNull() {
			addCriterion("SALE_PRICE_UNIT is not null");
			return (Criteria) this;
		}

		public Criteria andSalePriceUnitEqualTo(Byte value) {
			addCriterion("SALE_PRICE_UNIT =", value, "salePriceUnit");
			return (Criteria) this;
		}

		public Criteria andSalePriceUnitNotEqualTo(Byte value) {
			addCriterion("SALE_PRICE_UNIT <>", value, "salePriceUnit");
			return (Criteria) this;
		}

		public Criteria andSalePriceUnitGreaterThan(Byte value) {
			addCriterion("SALE_PRICE_UNIT >", value, "salePriceUnit");
			return (Criteria) this;
		}

		public Criteria andSalePriceUnitGreaterThanOrEqualTo(Byte value) {
			addCriterion("SALE_PRICE_UNIT >=", value, "salePriceUnit");
			return (Criteria) this;
		}

		public Criteria andSalePriceUnitLessThan(Byte value) {
			addCriterion("SALE_PRICE_UNIT <", value, "salePriceUnit");
			return (Criteria) this;
		}

		public Criteria andSalePriceUnitLessThanOrEqualTo(Byte value) {
			addCriterion("SALE_PRICE_UNIT <=", value, "salePriceUnit");
			return (Criteria) this;
		}

		public Criteria andSalePriceUnitIn(List<Byte> values) {
			addCriterion("SALE_PRICE_UNIT in", values, "salePriceUnit");
			return (Criteria) this;
		}

		public Criteria andSalePriceUnitNotIn(List<Byte> values) {
			addCriterion("SALE_PRICE_UNIT not in", values, "salePriceUnit");
			return (Criteria) this;
		}

		public Criteria andSalePriceUnitBetween(Byte value1, Byte value2) {
			addCriterion("SALE_PRICE_UNIT between", value1, value2, "salePriceUnit");
			return (Criteria) this;
		}

		public Criteria andSalePriceUnitNotBetween(Byte value1, Byte value2) {
			addCriterion("SALE_PRICE_UNIT not between", value1, value2, "salePriceUnit");
			return (Criteria) this;
		}

		public Criteria andRentCycleIsNull() {
			addCriterion("RENT_CYCLE is null");
			return (Criteria) this;
		}

		public Criteria andRentCycleIsNotNull() {
			addCriterion("RENT_CYCLE is not null");
			return (Criteria) this;
		}

		public Criteria andRentCycleEqualTo(String value) {
			addCriterion("RENT_CYCLE =", value, "rentCycle");
			return (Criteria) this;
		}

		public Criteria andRentCycleNotEqualTo(String value) {
			addCriterion("RENT_CYCLE <>", value, "rentCycle");
			return (Criteria) this;
		}

		public Criteria andRentCycleGreaterThan(String value) {
			addCriterion("RENT_CYCLE >", value, "rentCycle");
			return (Criteria) this;
		}

		public Criteria andRentCycleGreaterThanOrEqualTo(String value) {
			addCriterion("RENT_CYCLE >=", value, "rentCycle");
			return (Criteria) this;
		}

		public Criteria andRentCycleLessThan(String value) {
			addCriterion("RENT_CYCLE <", value, "rentCycle");
			return (Criteria) this;
		}

		public Criteria andRentCycleLessThanOrEqualTo(String value) {
			addCriterion("RENT_CYCLE <=", value, "rentCycle");
			return (Criteria) this;
		}

		public Criteria andRentCycleLike(String value) {
			addCriterion("RENT_CYCLE like", value, "rentCycle");
			return (Criteria) this;
		}

		public Criteria andRentCycleNotLike(String value) {
			addCriterion("RENT_CYCLE not like", value, "rentCycle");
			return (Criteria) this;
		}

		public Criteria andRentCycleIn(List<String> values) {
			addCriterion("RENT_CYCLE in", values, "rentCycle");
			return (Criteria) this;
		}

		public Criteria andRentCycleNotIn(List<String> values) {
			addCriterion("RENT_CYCLE not in", values, "rentCycle");
			return (Criteria) this;
		}

		public Criteria andRentCycleBetween(String value1, String value2) {
			addCriterion("RENT_CYCLE between", value1, value2, "rentCycle");
			return (Criteria) this;
		}

		public Criteria andRentCycleNotBetween(String value1, String value2) {
			addCriterion("RENT_CYCLE not between", value1, value2, "rentCycle");
			return (Criteria) this;
		}

		public Criteria andCodeIdIsNull() {
			addCriterion("CODE_ID is null");
			return (Criteria) this;
		}

		public Criteria andCodeIdIsNotNull() {
			addCriterion("CODE_ID is not null");
			return (Criteria) this;
		}

		public Criteria andCodeIdEqualTo(Integer value) {
			addCriterion("CODE_ID =", value, "codeId");
			return (Criteria) this;
		}

		public Criteria andCodeIdNotEqualTo(Integer value) {
			addCriterion("CODE_ID <>", value, "codeId");
			return (Criteria) this;
		}

		public Criteria andCodeIdGreaterThan(Integer value) {
			addCriterion("CODE_ID >", value, "codeId");
			return (Criteria) this;
		}

		public Criteria andCodeIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("CODE_ID >=", value, "codeId");
			return (Criteria) this;
		}

		public Criteria andCodeIdLessThan(Integer value) {
			addCriterion("CODE_ID <", value, "codeId");
			return (Criteria) this;
		}

		public Criteria andCodeIdLessThanOrEqualTo(Integer value) {
			addCriterion("CODE_ID <=", value, "codeId");
			return (Criteria) this;
		}

		public Criteria andCodeIdIn(List<Integer> values) {
			addCriterion("CODE_ID in", values, "codeId");
			return (Criteria) this;
		}

		public Criteria andCodeIdNotIn(List<Integer> values) {
			addCriterion("CODE_ID not in", values, "codeId");
			return (Criteria) this;
		}

		public Criteria andCodeIdBetween(Integer value1, Integer value2) {
			addCriterion("CODE_ID between", value1, value2, "codeId");
			return (Criteria) this;
		}

		public Criteria andCodeIdNotBetween(Integer value1, Integer value2) {
			addCriterion("CODE_ID not between", value1, value2, "codeId");
			return (Criteria) this;
		}

		public Criteria andProcessStatusIsNull() {
			addCriterion("PROCESS_STATUS is null");
			return (Criteria) this;
		}

		public Criteria andProcessStatusIsNotNull() {
			addCriterion("PROCESS_STATUS is not null");
			return (Criteria) this;
		}

		public Criteria andProcessStatusEqualTo(Byte value) {
			addCriterion("PROCESS_STATUS =", value, "processStatus");
			return (Criteria) this;
		}

		public Criteria andProcessStatusNotEqualTo(Byte value) {
			addCriterion("PROCESS_STATUS <>", value, "processStatus");
			return (Criteria) this;
		}

		public Criteria andProcessStatusGreaterThan(Byte value) {
			addCriterion("PROCESS_STATUS >", value, "processStatus");
			return (Criteria) this;
		}

		public Criteria andProcessStatusGreaterThanOrEqualTo(Byte value) {
			addCriterion("PROCESS_STATUS >=", value, "processStatus");
			return (Criteria) this;
		}

		public Criteria andProcessStatusLessThan(Byte value) {
			addCriterion("PROCESS_STATUS <", value, "processStatus");
			return (Criteria) this;
		}

		public Criteria andProcessStatusLessThanOrEqualTo(Byte value) {
			addCriterion("PROCESS_STATUS <=", value, "processStatus");
			return (Criteria) this;
		}

		public Criteria andProcessStatusIn(List<Byte> values) {
			addCriterion("PROCESS_STATUS in", values, "processStatus");
			return (Criteria) this;
		}

		public Criteria andProcessStatusNotIn(List<Byte> values) {
			addCriterion("PROCESS_STATUS not in", values, "processStatus");
			return (Criteria) this;
		}

		public Criteria andProcessStatusBetween(Byte value1, Byte value2) {
			addCriterion("PROCESS_STATUS between", value1, value2, "processStatus");
			return (Criteria) this;
		}

		public Criteria andProcessStatusNotBetween(Byte value1, Byte value2) {
			addCriterion("PROCESS_STATUS not between", value1, value2, "processStatus");
			return (Criteria) this;
		}

		public Criteria andBuyCustomerPhoneIsNull() {
			addCriterion("BUY_CUSTOMER_PHONE is null");
			return (Criteria) this;
		}

		public Criteria andBuyCustomerPhoneIsNotNull() {
			addCriterion("BUY_CUSTOMER_PHONE is not null");
			return (Criteria) this;
		}

		public Criteria andBuyCustomerPhoneEqualTo(String value) {
			addCriterion("BUY_CUSTOMER_PHONE =", value, "buyCustomerPhone");
			return (Criteria) this;
		}

		public Criteria andBuyCustomerPhoneNotEqualTo(String value) {
			addCriterion("BUY_CUSTOMER_PHONE <>", value, "buyCustomerPhone");
			return (Criteria) this;
		}

		public Criteria andBuyCustomerPhoneGreaterThan(String value) {
			addCriterion("BUY_CUSTOMER_PHONE >", value, "buyCustomerPhone");
			return (Criteria) this;
		}

		public Criteria andBuyCustomerPhoneGreaterThanOrEqualTo(String value) {
			addCriterion("BUY_CUSTOMER_PHONE >=", value, "buyCustomerPhone");
			return (Criteria) this;
		}

		public Criteria andBuyCustomerPhoneLessThan(String value) {
			addCriterion("BUY_CUSTOMER_PHONE <", value, "buyCustomerPhone");
			return (Criteria) this;
		}

		public Criteria andBuyCustomerPhoneLessThanOrEqualTo(String value) {
			addCriterion("BUY_CUSTOMER_PHONE <=", value, "buyCustomerPhone");
			return (Criteria) this;
		}

		public Criteria andBuyCustomerPhoneLike(String value) {
			addCriterion("BUY_CUSTOMER_PHONE like", value, "buyCustomerPhone");
			return (Criteria) this;
		}

		public Criteria andBuyCustomerPhoneNotLike(String value) {
			addCriterion("BUY_CUSTOMER_PHONE not like", value, "buyCustomerPhone");
			return (Criteria) this;
		}

		public Criteria andBuyCustomerPhoneIn(List<String> values) {
			addCriterion("BUY_CUSTOMER_PHONE in", values, "buyCustomerPhone");
			return (Criteria) this;
		}

		public Criteria andBuyCustomerPhoneNotIn(List<String> values) {
			addCriterion("BUY_CUSTOMER_PHONE not in", values, "buyCustomerPhone");
			return (Criteria) this;
		}

		public Criteria andBuyCustomerPhoneBetween(String value1, String value2) {
			addCriterion("BUY_CUSTOMER_PHONE between", value1, value2, "buyCustomerPhone");
			return (Criteria) this;
		}

		public Criteria andBuyCustomerPhoneNotBetween(String value1, String value2) {
			addCriterion("BUY_CUSTOMER_PHONE not between", value1, value2, "buyCustomerPhone");
			return (Criteria) this;
		}

		public Criteria andBuyCustomerPhoneencodeIsNull() {
			addCriterion("BUY_CUSTOMER_PHONEENCODE is null");
			return (Criteria) this;
		}

		public Criteria andBuyCustomerPhoneencodeIsNotNull() {
			addCriterion("BUY_CUSTOMER_PHONEENCODE is not null");
			return (Criteria) this;
		}

		public Criteria andBuyCustomerPhoneencodeEqualTo(String value) {
			addCriterion("BUY_CUSTOMER_PHONEENCODE =", value, "buyCustomerPhoneencode");
			return (Criteria) this;
		}

		public Criteria andBuyCustomerPhoneencodeNotEqualTo(String value) {
			addCriterion("BUY_CUSTOMER_PHONEENCODE <>", value, "buyCustomerPhoneencode");
			return (Criteria) this;
		}

		public Criteria andBuyCustomerPhoneencodeGreaterThan(String value) {
			addCriterion("BUY_CUSTOMER_PHONEENCODE >", value, "buyCustomerPhoneencode");
			return (Criteria) this;
		}

		public Criteria andBuyCustomerPhoneencodeGreaterThanOrEqualTo(String value) {
			addCriterion("BUY_CUSTOMER_PHONEENCODE >=", value, "buyCustomerPhoneencode");
			return (Criteria) this;
		}

		public Criteria andBuyCustomerPhoneencodeLessThan(String value) {
			addCriterion("BUY_CUSTOMER_PHONEENCODE <", value, "buyCustomerPhoneencode");
			return (Criteria) this;
		}

		public Criteria andBuyCustomerPhoneencodeLessThanOrEqualTo(String value) {
			addCriterion("BUY_CUSTOMER_PHONEENCODE <=", value, "buyCustomerPhoneencode");
			return (Criteria) this;
		}

		public Criteria andBuyCustomerPhoneencodeLike(String value) {
			addCriterion("BUY_CUSTOMER_PHONEENCODE like", value, "buyCustomerPhoneencode");
			return (Criteria) this;
		}

		public Criteria andBuyCustomerPhoneencodeNotLike(String value) {
			addCriterion("BUY_CUSTOMER_PHONEENCODE not like", value, "buyCustomerPhoneencode");
			return (Criteria) this;
		}

		public Criteria andBuyCustomerPhoneencodeIn(List<String> values) {
			addCriterion("BUY_CUSTOMER_PHONEENCODE in", values, "buyCustomerPhoneencode");
			return (Criteria) this;
		}

		public Criteria andBuyCustomerPhoneencodeNotIn(List<String> values) {
			addCriterion("BUY_CUSTOMER_PHONEENCODE not in", values, "buyCustomerPhoneencode");
			return (Criteria) this;
		}

		public Criteria andBuyCustomerPhoneencodeBetween(String value1, String value2) {
			addCriterion("BUY_CUSTOMER_PHONEENCODE between", value1, value2, "buyCustomerPhoneencode");
			return (Criteria) this;
		}

		public Criteria andBuyCustomerPhoneencodeNotBetween(String value1, String value2) {
			addCriterion("BUY_CUSTOMER_PHONEENCODE not between", value1, value2, "buyCustomerPhoneencode");
			return (Criteria) this;
		}

		public Criteria andSellOwnerPhoneIsNull() {
			addCriterion("SELL_OWNER_PHONE is null");
			return (Criteria) this;
		}

		public Criteria andSellOwnerPhoneIsNotNull() {
			addCriterion("SELL_OWNER_PHONE is not null");
			return (Criteria) this;
		}

		public Criteria andSellOwnerPhoneEqualTo(String value) {
			addCriterion("SELL_OWNER_PHONE =", value, "sellOwnerPhone");
			return (Criteria) this;
		}

		public Criteria andSellOwnerPhoneNotEqualTo(String value) {
			addCriterion("SELL_OWNER_PHONE <>", value, "sellOwnerPhone");
			return (Criteria) this;
		}

		public Criteria andSellOwnerPhoneGreaterThan(String value) {
			addCriterion("SELL_OWNER_PHONE >", value, "sellOwnerPhone");
			return (Criteria) this;
		}

		public Criteria andSellOwnerPhoneGreaterThanOrEqualTo(String value) {
			addCriterion("SELL_OWNER_PHONE >=", value, "sellOwnerPhone");
			return (Criteria) this;
		}

		public Criteria andSellOwnerPhoneLessThan(String value) {
			addCriterion("SELL_OWNER_PHONE <", value, "sellOwnerPhone");
			return (Criteria) this;
		}

		public Criteria andSellOwnerPhoneLessThanOrEqualTo(String value) {
			addCriterion("SELL_OWNER_PHONE <=", value, "sellOwnerPhone");
			return (Criteria) this;
		}

		public Criteria andSellOwnerPhoneLike(String value) {
			addCriterion("SELL_OWNER_PHONE like", value, "sellOwnerPhone");
			return (Criteria) this;
		}

		public Criteria andSellOwnerPhoneNotLike(String value) {
			addCriterion("SELL_OWNER_PHONE not like", value, "sellOwnerPhone");
			return (Criteria) this;
		}

		public Criteria andSellOwnerPhoneIn(List<String> values) {
			addCriterion("SELL_OWNER_PHONE in", values, "sellOwnerPhone");
			return (Criteria) this;
		}

		public Criteria andSellOwnerPhoneNotIn(List<String> values) {
			addCriterion("SELL_OWNER_PHONE not in", values, "sellOwnerPhone");
			return (Criteria) this;
		}

		public Criteria andSellOwnerPhoneBetween(String value1, String value2) {
			addCriterion("SELL_OWNER_PHONE between", value1, value2, "sellOwnerPhone");
			return (Criteria) this;
		}

		public Criteria andSellOwnerPhoneNotBetween(String value1, String value2) {
			addCriterion("SELL_OWNER_PHONE not between", value1, value2, "sellOwnerPhone");
			return (Criteria) this;
		}

		public Criteria andSellOwnerPhoneencodeIsNull() {
			addCriterion("SELL_OWNER_PHONEENCODE is null");
			return (Criteria) this;
		}

		public Criteria andSellOwnerPhoneencodeIsNotNull() {
			addCriterion("SELL_OWNER_PHONEENCODE is not null");
			return (Criteria) this;
		}

		public Criteria andSellOwnerPhoneencodeEqualTo(String value) {
			addCriterion("SELL_OWNER_PHONEENCODE =", value, "sellOwnerPhoneencode");
			return (Criteria) this;
		}

		public Criteria andSellOwnerPhoneencodeNotEqualTo(String value) {
			addCriterion("SELL_OWNER_PHONEENCODE <>", value, "sellOwnerPhoneencode");
			return (Criteria) this;
		}

		public Criteria andSellOwnerPhoneencodeGreaterThan(String value) {
			addCriterion("SELL_OWNER_PHONEENCODE >", value, "sellOwnerPhoneencode");
			return (Criteria) this;
		}

		public Criteria andSellOwnerPhoneencodeGreaterThanOrEqualTo(String value) {
			addCriterion("SELL_OWNER_PHONEENCODE >=", value, "sellOwnerPhoneencode");
			return (Criteria) this;
		}

		public Criteria andSellOwnerPhoneencodeLessThan(String value) {
			addCriterion("SELL_OWNER_PHONEENCODE <", value, "sellOwnerPhoneencode");
			return (Criteria) this;
		}

		public Criteria andSellOwnerPhoneencodeLessThanOrEqualTo(String value) {
			addCriterion("SELL_OWNER_PHONEENCODE <=", value, "sellOwnerPhoneencode");
			return (Criteria) this;
		}

		public Criteria andSellOwnerPhoneencodeLike(String value) {
			addCriterion("SELL_OWNER_PHONEENCODE like", value, "sellOwnerPhoneencode");
			return (Criteria) this;
		}

		public Criteria andSellOwnerPhoneencodeNotLike(String value) {
			addCriterion("SELL_OWNER_PHONEENCODE not like", value, "sellOwnerPhoneencode");
			return (Criteria) this;
		}

		public Criteria andSellOwnerPhoneencodeIn(List<String> values) {
			addCriterion("SELL_OWNER_PHONEENCODE in", values, "sellOwnerPhoneencode");
			return (Criteria) this;
		}

		public Criteria andSellOwnerPhoneencodeNotIn(List<String> values) {
			addCriterion("SELL_OWNER_PHONEENCODE not in", values, "sellOwnerPhoneencode");
			return (Criteria) this;
		}

		public Criteria andSellOwnerPhoneencodeBetween(String value1, String value2) {
			addCriterion("SELL_OWNER_PHONEENCODE between", value1, value2, "sellOwnerPhoneencode");
			return (Criteria) this;
		}

		public Criteria andSellOwnerPhoneencodeNotBetween(String value1, String value2) {
			addCriterion("SELL_OWNER_PHONEENCODE not between", value1, value2, "sellOwnerPhoneencode");
			return (Criteria) this;
		}

		public Criteria andSellOwnerPhoneBakIsNull() {
			addCriterion("SELL_OWNER_PHONE_BAK is null");
			return (Criteria) this;
		}

		public Criteria andSellOwnerPhoneBakIsNotNull() {
			addCriterion("SELL_OWNER_PHONE_BAK is not null");
			return (Criteria) this;
		}

		public Criteria andSellOwnerPhoneBakEqualTo(String value) {
			addCriterion("SELL_OWNER_PHONE_BAK =", value, "sellOwnerPhoneBak");
			return (Criteria) this;
		}

		public Criteria andSellOwnerPhoneBakNotEqualTo(String value) {
			addCriterion("SELL_OWNER_PHONE_BAK <>", value, "sellOwnerPhoneBak");
			return (Criteria) this;
		}

		public Criteria andSellOwnerPhoneBakGreaterThan(String value) {
			addCriterion("SELL_OWNER_PHONE_BAK >", value, "sellOwnerPhoneBak");
			return (Criteria) this;
		}

		public Criteria andSellOwnerPhoneBakGreaterThanOrEqualTo(String value) {
			addCriterion("SELL_OWNER_PHONE_BAK >=", value, "sellOwnerPhoneBak");
			return (Criteria) this;
		}

		public Criteria andSellOwnerPhoneBakLessThan(String value) {
			addCriterion("SELL_OWNER_PHONE_BAK <", value, "sellOwnerPhoneBak");
			return (Criteria) this;
		}

		public Criteria andSellOwnerPhoneBakLessThanOrEqualTo(String value) {
			addCriterion("SELL_OWNER_PHONE_BAK <=", value, "sellOwnerPhoneBak");
			return (Criteria) this;
		}

		public Criteria andSellOwnerPhoneBakLike(String value) {
			addCriterion("SELL_OWNER_PHONE_BAK like", value, "sellOwnerPhoneBak");
			return (Criteria) this;
		}

		public Criteria andSellOwnerPhoneBakNotLike(String value) {
			addCriterion("SELL_OWNER_PHONE_BAK not like", value, "sellOwnerPhoneBak");
			return (Criteria) this;
		}

		public Criteria andSellOwnerPhoneBakIn(List<String> values) {
			addCriterion("SELL_OWNER_PHONE_BAK in", values, "sellOwnerPhoneBak");
			return (Criteria) this;
		}

		public Criteria andSellOwnerPhoneBakNotIn(List<String> values) {
			addCriterion("SELL_OWNER_PHONE_BAK not in", values, "sellOwnerPhoneBak");
			return (Criteria) this;
		}

		public Criteria andSellOwnerPhoneBakBetween(String value1, String value2) {
			addCriterion("SELL_OWNER_PHONE_BAK between", value1, value2, "sellOwnerPhoneBak");
			return (Criteria) this;
		}

		public Criteria andSellOwnerPhoneBakNotBetween(String value1, String value2) {
			addCriterion("SELL_OWNER_PHONE_BAK not between", value1, value2, "sellOwnerPhoneBak");
			return (Criteria) this;
		}

		public Criteria andBuyCustomerPhoneBakIsNull() {
			addCriterion("BUY_CUSTOMER_PHONE_BAK is null");
			return (Criteria) this;
		}

		public Criteria andBuyCustomerPhoneBakIsNotNull() {
			addCriterion("BUY_CUSTOMER_PHONE_BAK is not null");
			return (Criteria) this;
		}

		public Criteria andBuyCustomerPhoneBakEqualTo(String value) {
			addCriterion("BUY_CUSTOMER_PHONE_BAK =", value, "buyCustomerPhoneBak");
			return (Criteria) this;
		}

		public Criteria andBuyCustomerPhoneBakNotEqualTo(String value) {
			addCriterion("BUY_CUSTOMER_PHONE_BAK <>", value, "buyCustomerPhoneBak");
			return (Criteria) this;
		}

		public Criteria andBuyCustomerPhoneBakGreaterThan(String value) {
			addCriterion("BUY_CUSTOMER_PHONE_BAK >", value, "buyCustomerPhoneBak");
			return (Criteria) this;
		}

		public Criteria andBuyCustomerPhoneBakGreaterThanOrEqualTo(String value) {
			addCriterion("BUY_CUSTOMER_PHONE_BAK >=", value, "buyCustomerPhoneBak");
			return (Criteria) this;
		}

		public Criteria andBuyCustomerPhoneBakLessThan(String value) {
			addCriterion("BUY_CUSTOMER_PHONE_BAK <", value, "buyCustomerPhoneBak");
			return (Criteria) this;
		}

		public Criteria andBuyCustomerPhoneBakLessThanOrEqualTo(String value) {
			addCriterion("BUY_CUSTOMER_PHONE_BAK <=", value, "buyCustomerPhoneBak");
			return (Criteria) this;
		}

		public Criteria andBuyCustomerPhoneBakLike(String value) {
			addCriterion("BUY_CUSTOMER_PHONE_BAK like", value, "buyCustomerPhoneBak");
			return (Criteria) this;
		}

		public Criteria andBuyCustomerPhoneBakNotLike(String value) {
			addCriterion("BUY_CUSTOMER_PHONE_BAK not like", value, "buyCustomerPhoneBak");
			return (Criteria) this;
		}

		public Criteria andBuyCustomerPhoneBakIn(List<String> values) {
			addCriterion("BUY_CUSTOMER_PHONE_BAK in", values, "buyCustomerPhoneBak");
			return (Criteria) this;
		}

		public Criteria andBuyCustomerPhoneBakNotIn(List<String> values) {
			addCriterion("BUY_CUSTOMER_PHONE_BAK not in", values, "buyCustomerPhoneBak");
			return (Criteria) this;
		}

		public Criteria andBuyCustomerPhoneBakBetween(String value1, String value2) {
			addCriterion("BUY_CUSTOMER_PHONE_BAK between", value1, value2, "buyCustomerPhoneBak");
			return (Criteria) this;
		}

		public Criteria andBuyCustomerPhoneBakNotBetween(String value1, String value2) {
			addCriterion("BUY_CUSTOMER_PHONE_BAK not between", value1, value2, "buyCustomerPhoneBak");
			return (Criteria) this;
		}

		public Criteria andContractIdIsNull() {
			addCriterion("CONTRACT_ID is null");
			return (Criteria) this;
		}

		public Criteria andContractIdIsNotNull() {
			addCriterion("CONTRACT_ID is not null");
			return (Criteria) this;
		}

		public Criteria andContractIdEqualTo(Integer value) {
			addCriterion("CONTRACT_ID =", value, "contractId");
			return (Criteria) this;
		}

		public Criteria andContractIdNotEqualTo(Integer value) {
			addCriterion("CONTRACT_ID <>", value, "contractId");
			return (Criteria) this;
		}

		public Criteria andContractIdGreaterThan(Integer value) {
			addCriterion("CONTRACT_ID >", value, "contractId");
			return (Criteria) this;
		}

		public Criteria andContractIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("CONTRACT_ID >=", value, "contractId");
			return (Criteria) this;
		}

		public Criteria andContractIdLessThan(Integer value) {
			addCriterion("CONTRACT_ID <", value, "contractId");
			return (Criteria) this;
		}

		public Criteria andContractIdLessThanOrEqualTo(Integer value) {
			addCriterion("CONTRACT_ID <=", value, "contractId");
			return (Criteria) this;
		}

		public Criteria andContractIdIn(List<Integer> values) {
			addCriterion("CONTRACT_ID in", values, "contractId");
			return (Criteria) this;
		}

		public Criteria andContractIdNotIn(List<Integer> values) {
			addCriterion("CONTRACT_ID not in", values, "contractId");
			return (Criteria) this;
		}

		public Criteria andContractIdBetween(Integer value1, Integer value2) {
			addCriterion("CONTRACT_ID between", value1, value2, "contractId");
			return (Criteria) this;
		}

		public Criteria andContractIdNotBetween(Integer value1, Integer value2) {
			addCriterion("CONTRACT_ID not between", value1, value2, "contractId");
			return (Criteria) this;
		}

		public Criteria andPaytypeIdIsNull() {
			addCriterion("PAYTYPE_ID is null");
			return (Criteria) this;
		}

		public Criteria andPaytypeIdIsNotNull() {
			addCriterion("PAYTYPE_ID is not null");
			return (Criteria) this;
		}

		public Criteria andPaytypeIdEqualTo(Integer value) {
			addCriterion("PAYTYPE_ID =", value, "paytypeId");
			return (Criteria) this;
		}

		public Criteria andPaytypeIdNotEqualTo(Integer value) {
			addCriterion("PAYTYPE_ID <>", value, "paytypeId");
			return (Criteria) this;
		}

		public Criteria andPaytypeIdGreaterThan(Integer value) {
			addCriterion("PAYTYPE_ID >", value, "paytypeId");
			return (Criteria) this;
		}

		public Criteria andPaytypeIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("PAYTYPE_ID >=", value, "paytypeId");
			return (Criteria) this;
		}

		public Criteria andPaytypeIdLessThan(Integer value) {
			addCriterion("PAYTYPE_ID <", value, "paytypeId");
			return (Criteria) this;
		}

		public Criteria andPaytypeIdLessThanOrEqualTo(Integer value) {
			addCriterion("PAYTYPE_ID <=", value, "paytypeId");
			return (Criteria) this;
		}

		public Criteria andPaytypeIdIn(List<Integer> values) {
			addCriterion("PAYTYPE_ID in", values, "paytypeId");
			return (Criteria) this;
		}

		public Criteria andPaytypeIdNotIn(List<Integer> values) {
			addCriterion("PAYTYPE_ID not in", values, "paytypeId");
			return (Criteria) this;
		}

		public Criteria andPaytypeIdBetween(Integer value1, Integer value2) {
			addCriterion("PAYTYPE_ID between", value1, value2, "paytypeId");
			return (Criteria) this;
		}

		public Criteria andPaytypeIdNotBetween(Integer value1, Integer value2) {
			addCriterion("PAYTYPE_ID not between", value1, value2, "paytypeId");
			return (Criteria) this;
		}

		public Criteria andPaytypeNameIsNull() {
			addCriterion("PAYTYPE_NAME is null");
			return (Criteria) this;
		}

		public Criteria andPaytypeNameIsNotNull() {
			addCriterion("PAYTYPE_NAME is not null");
			return (Criteria) this;
		}

		public Criteria andPaytypeNameEqualTo(String value) {
			addCriterion("PAYTYPE_NAME =", value, "paytypeName");
			return (Criteria) this;
		}

		public Criteria andPaytypeNameNotEqualTo(String value) {
			addCriterion("PAYTYPE_NAME <>", value, "paytypeName");
			return (Criteria) this;
		}

		public Criteria andPaytypeNameGreaterThan(String value) {
			addCriterion("PAYTYPE_NAME >", value, "paytypeName");
			return (Criteria) this;
		}

		public Criteria andPaytypeNameGreaterThanOrEqualTo(String value) {
			addCriterion("PAYTYPE_NAME >=", value, "paytypeName");
			return (Criteria) this;
		}

		public Criteria andPaytypeNameLessThan(String value) {
			addCriterion("PAYTYPE_NAME <", value, "paytypeName");
			return (Criteria) this;
		}

		public Criteria andPaytypeNameLessThanOrEqualTo(String value) {
			addCriterion("PAYTYPE_NAME <=", value, "paytypeName");
			return (Criteria) this;
		}

		public Criteria andPaytypeNameLike(String value) {
			addCriterion("PAYTYPE_NAME like", value, "paytypeName");
			return (Criteria) this;
		}

		public Criteria andPaytypeNameNotLike(String value) {
			addCriterion("PAYTYPE_NAME not like", value, "paytypeName");
			return (Criteria) this;
		}

		public Criteria andPaytypeNameIn(List<String> values) {
			addCriterion("PAYTYPE_NAME in", values, "paytypeName");
			return (Criteria) this;
		}

		public Criteria andPaytypeNameNotIn(List<String> values) {
			addCriterion("PAYTYPE_NAME not in", values, "paytypeName");
			return (Criteria) this;
		}

		public Criteria andPaytypeNameBetween(String value1, String value2) {
			addCriterion("PAYTYPE_NAME between", value1, value2, "paytypeName");
			return (Criteria) this;
		}

		public Criteria andPaytypeNameNotBetween(String value1, String value2) {
			addCriterion("PAYTYPE_NAME not between", value1, value2, "paytypeName");
			return (Criteria) this;
		}

		public Criteria andYouAduitStatusIsNull() {
			addCriterion("YOU_ADUIT_STATUS is null");
			return (Criteria) this;
		}

		public Criteria andYouAduitStatusIsNotNull() {
			addCriterion("YOU_ADUIT_STATUS is not null");
			return (Criteria) this;
		}

		public Criteria andYouAduitStatusEqualTo(Byte value) {
			addCriterion("YOU_ADUIT_STATUS =", value, "youAduitStatus");
			return (Criteria) this;
		}

		public Criteria andYouAduitStatusNotEqualTo(Byte value) {
			addCriterion("YOU_ADUIT_STATUS <>", value, "youAduitStatus");
			return (Criteria) this;
		}

		public Criteria andYouAduitStatusGreaterThan(Byte value) {
			addCriterion("YOU_ADUIT_STATUS >", value, "youAduitStatus");
			return (Criteria) this;
		}

		public Criteria andYouAduitStatusGreaterThanOrEqualTo(Byte value) {
			addCriterion("YOU_ADUIT_STATUS >=", value, "youAduitStatus");
			return (Criteria) this;
		}

		public Criteria andYouAduitStatusLessThan(Byte value) {
			addCriterion("YOU_ADUIT_STATUS <", value, "youAduitStatus");
			return (Criteria) this;
		}

		public Criteria andYouAduitStatusLessThanOrEqualTo(Byte value) {
			addCriterion("YOU_ADUIT_STATUS <=", value, "youAduitStatus");
			return (Criteria) this;
		}

		public Criteria andYouAduitStatusIn(List<Byte> values) {
			addCriterion("YOU_ADUIT_STATUS in", values, "youAduitStatus");
			return (Criteria) this;
		}

		public Criteria andYouAduitStatusNotIn(List<Byte> values) {
			addCriterion("YOU_ADUIT_STATUS not in", values, "youAduitStatus");
			return (Criteria) this;
		}

		public Criteria andYouAduitStatusBetween(Byte value1, Byte value2) {
			addCriterion("YOU_ADUIT_STATUS between", value1, value2, "youAduitStatus");
			return (Criteria) this;
		}

		public Criteria andYouAduitStatusNotBetween(Byte value1, Byte value2) {
			addCriterion("YOU_ADUIT_STATUS not between", value1, value2, "youAduitStatus");
			return (Criteria) this;
		}

		public Criteria andDealAuditStatusIsNull() {
			addCriterion("DEAL_AUDIT_STATUS is null");
			return (Criteria) this;
		}

		public Criteria andDealAuditStatusIsNotNull() {
			addCriterion("DEAL_AUDIT_STATUS is not null");
			return (Criteria) this;
		}

		public Criteria andDealAuditStatusEqualTo(Byte value) {
			addCriterion("DEAL_AUDIT_STATUS =", value, "dealAuditStatus");
			return (Criteria) this;
		}

		public Criteria andDealAuditStatusNotEqualTo(Byte value) {
			addCriterion("DEAL_AUDIT_STATUS <>", value, "dealAuditStatus");
			return (Criteria) this;
		}

		public Criteria andDealAuditStatusGreaterThan(Byte value) {
			addCriterion("DEAL_AUDIT_STATUS >", value, "dealAuditStatus");
			return (Criteria) this;
		}

		public Criteria andDealAuditStatusGreaterThanOrEqualTo(Byte value) {
			addCriterion("DEAL_AUDIT_STATUS >=", value, "dealAuditStatus");
			return (Criteria) this;
		}

		public Criteria andDealAuditStatusLessThan(Byte value) {
			addCriterion("DEAL_AUDIT_STATUS <", value, "dealAuditStatus");
			return (Criteria) this;
		}

		public Criteria andDealAuditStatusLessThanOrEqualTo(Byte value) {
			addCriterion("DEAL_AUDIT_STATUS <=", value, "dealAuditStatus");
			return (Criteria) this;
		}

		public Criteria andDealAuditStatusIn(List<Byte> values) {
			addCriterion("DEAL_AUDIT_STATUS in", values, "dealAuditStatus");
			return (Criteria) this;
		}

		public Criteria andDealAuditStatusNotIn(List<Byte> values) {
			addCriterion("DEAL_AUDIT_STATUS not in", values, "dealAuditStatus");
			return (Criteria) this;
		}

		public Criteria andDealAuditStatusBetween(Byte value1, Byte value2) {
			addCriterion("DEAL_AUDIT_STATUS between", value1, value2, "dealAuditStatus");
			return (Criteria) this;
		}

		public Criteria andDealAuditStatusNotBetween(Byte value1, Byte value2) {
			addCriterion("DEAL_AUDIT_STATUS not between", value1, value2, "dealAuditStatus");
			return (Criteria) this;
		}

		public Criteria andCommercialLoanDateIsNull() {
			addCriterion("COMMERCIAL_LOAN_DATE is null");
			return (Criteria) this;
		}

		public Criteria andCommercialLoanDateIsNotNull() {
			addCriterion("COMMERCIAL_LOAN_DATE is not null");
			return (Criteria) this;
		}

		public Criteria andCommercialLoanDateEqualTo(Date value) {
			addCriterion("COMMERCIAL_LOAN_DATE =", value, "commercialLoanDate");
			return (Criteria) this;
		}

		public Criteria andCommercialLoanDateNotEqualTo(Date value) {
			addCriterion("COMMERCIAL_LOAN_DATE <>", value, "commercialLoanDate");
			return (Criteria) this;
		}

		public Criteria andCommercialLoanDateGreaterThan(Date value) {
			addCriterion("COMMERCIAL_LOAN_DATE >", value, "commercialLoanDate");
			return (Criteria) this;
		}

		public Criteria andCommercialLoanDateGreaterThanOrEqualTo(Date value) {
			addCriterion("COMMERCIAL_LOAN_DATE >=", value, "commercialLoanDate");
			return (Criteria) this;
		}

		public Criteria andCommercialLoanDateLessThan(Date value) {
			addCriterion("COMMERCIAL_LOAN_DATE <", value, "commercialLoanDate");
			return (Criteria) this;
		}

		public Criteria andCommercialLoanDateLessThanOrEqualTo(Date value) {
			addCriterion("COMMERCIAL_LOAN_DATE <=", value, "commercialLoanDate");
			return (Criteria) this;
		}

		public Criteria andCommercialLoanDateIn(List<Date> values) {
			addCriterion("COMMERCIAL_LOAN_DATE in", values, "commercialLoanDate");
			return (Criteria) this;
		}

		public Criteria andCommercialLoanDateNotIn(List<Date> values) {
			addCriterion("COMMERCIAL_LOAN_DATE not in", values, "commercialLoanDate");
			return (Criteria) this;
		}

		public Criteria andCommercialLoanDateBetween(Date value1, Date value2) {
			addCriterion("COMMERCIAL_LOAN_DATE between", value1, value2, "commercialLoanDate");
			return (Criteria) this;
		}

		public Criteria andCommercialLoanDateNotBetween(Date value1, Date value2) {
			addCriterion("COMMERCIAL_LOAN_DATE not between", value1, value2, "commercialLoanDate");
			return (Criteria) this;
		}

		public Criteria andCommercialLenderDateIsNull() {
			addCriterion("COMMERCIAL_LENDER_DATE is null");
			return (Criteria) this;
		}

		public Criteria andCommercialLenderDateIsNotNull() {
			addCriterion("COMMERCIAL_LENDER_DATE is not null");
			return (Criteria) this;
		}

		public Criteria andCommercialLenderDateEqualTo(Date value) {
			addCriterion("COMMERCIAL_LENDER_DATE =", value, "commercialLenderDate");
			return (Criteria) this;
		}

		public Criteria andCommercialLenderDateNotEqualTo(Date value) {
			addCriterion("COMMERCIAL_LENDER_DATE <>", value, "commercialLenderDate");
			return (Criteria) this;
		}

		public Criteria andCommercialLenderDateGreaterThan(Date value) {
			addCriterion("COMMERCIAL_LENDER_DATE >", value, "commercialLenderDate");
			return (Criteria) this;
		}

		public Criteria andCommercialLenderDateGreaterThanOrEqualTo(Date value) {
			addCriterion("COMMERCIAL_LENDER_DATE >=", value, "commercialLenderDate");
			return (Criteria) this;
		}

		public Criteria andCommercialLenderDateLessThan(Date value) {
			addCriterion("COMMERCIAL_LENDER_DATE <", value, "commercialLenderDate");
			return (Criteria) this;
		}

		public Criteria andCommercialLenderDateLessThanOrEqualTo(Date value) {
			addCriterion("COMMERCIAL_LENDER_DATE <=", value, "commercialLenderDate");
			return (Criteria) this;
		}

		public Criteria andCommercialLenderDateIn(List<Date> values) {
			addCriterion("COMMERCIAL_LENDER_DATE in", values, "commercialLenderDate");
			return (Criteria) this;
		}

		public Criteria andCommercialLenderDateNotIn(List<Date> values) {
			addCriterion("COMMERCIAL_LENDER_DATE not in", values, "commercialLenderDate");
			return (Criteria) this;
		}

		public Criteria andCommercialLenderDateBetween(Date value1, Date value2) {
			addCriterion("COMMERCIAL_LENDER_DATE between", value1, value2, "commercialLenderDate");
			return (Criteria) this;
		}

		public Criteria andCommercialLenderDateNotBetween(Date value1, Date value2) {
			addCriterion("COMMERCIAL_LENDER_DATE not between", value1, value2, "commercialLenderDate");
			return (Criteria) this;
		}

		public Criteria andCommercialLenderLimitIsNull() {
			addCriterion("COMMERCIAL_LENDER_LIMIT is null");
			return (Criteria) this;
		}

		public Criteria andCommercialLenderLimitIsNotNull() {
			addCriterion("COMMERCIAL_LENDER_LIMIT is not null");
			return (Criteria) this;
		}

		public Criteria andCommercialLenderLimitEqualTo(String value) {
			addCriterion("COMMERCIAL_LENDER_LIMIT =", value, "commercialLenderLimit");
			return (Criteria) this;
		}

		public Criteria andCommercialLenderLimitNotEqualTo(String value) {
			addCriterion("COMMERCIAL_LENDER_LIMIT <>", value, "commercialLenderLimit");
			return (Criteria) this;
		}

		public Criteria andCommercialLenderLimitGreaterThan(String value) {
			addCriterion("COMMERCIAL_LENDER_LIMIT >", value, "commercialLenderLimit");
			return (Criteria) this;
		}

		public Criteria andCommercialLenderLimitGreaterThanOrEqualTo(String value) {
			addCriterion("COMMERCIAL_LENDER_LIMIT >=", value, "commercialLenderLimit");
			return (Criteria) this;
		}

		public Criteria andCommercialLenderLimitLessThan(String value) {
			addCriterion("COMMERCIAL_LENDER_LIMIT <", value, "commercialLenderLimit");
			return (Criteria) this;
		}

		public Criteria andCommercialLenderLimitLessThanOrEqualTo(String value) {
			addCriterion("COMMERCIAL_LENDER_LIMIT <=", value, "commercialLenderLimit");
			return (Criteria) this;
		}

		public Criteria andCommercialLenderLimitLike(String value) {
			addCriterion("COMMERCIAL_LENDER_LIMIT like", value, "commercialLenderLimit");
			return (Criteria) this;
		}

		public Criteria andCommercialLenderLimitNotLike(String value) {
			addCriterion("COMMERCIAL_LENDER_LIMIT not like", value, "commercialLenderLimit");
			return (Criteria) this;
		}

		public Criteria andCommercialLenderLimitIn(List<String> values) {
			addCriterion("COMMERCIAL_LENDER_LIMIT in", values, "commercialLenderLimit");
			return (Criteria) this;
		}

		public Criteria andCommercialLenderLimitNotIn(List<String> values) {
			addCriterion("COMMERCIAL_LENDER_LIMIT not in", values, "commercialLenderLimit");
			return (Criteria) this;
		}

		public Criteria andCommercialLenderLimitBetween(String value1, String value2) {
			addCriterion("COMMERCIAL_LENDER_LIMIT between", value1, value2, "commercialLenderLimit");
			return (Criteria) this;
		}

		public Criteria andCommercialLenderLimitNotBetween(String value1, String value2) {
			addCriterion("COMMERCIAL_LENDER_LIMIT not between", value1, value2, "commercialLenderLimit");
			return (Criteria) this;
		}

		public Criteria andCommercialLenderBankIsNull() {
			addCriterion("COMMERCIAL_LENDER_BANK is null");
			return (Criteria) this;
		}

		public Criteria andCommercialLenderBankIsNotNull() {
			addCriterion("COMMERCIAL_LENDER_BANK is not null");
			return (Criteria) this;
		}

		public Criteria andCommercialLenderBankEqualTo(String value) {
			addCriterion("COMMERCIAL_LENDER_BANK =", value, "commercialLenderBank");
			return (Criteria) this;
		}

		public Criteria andCommercialLenderBankNotEqualTo(String value) {
			addCriterion("COMMERCIAL_LENDER_BANK <>", value, "commercialLenderBank");
			return (Criteria) this;
		}

		public Criteria andCommercialLenderBankGreaterThan(String value) {
			addCriterion("COMMERCIAL_LENDER_BANK >", value, "commercialLenderBank");
			return (Criteria) this;
		}

		public Criteria andCommercialLenderBankGreaterThanOrEqualTo(String value) {
			addCriterion("COMMERCIAL_LENDER_BANK >=", value, "commercialLenderBank");
			return (Criteria) this;
		}

		public Criteria andCommercialLenderBankLessThan(String value) {
			addCriterion("COMMERCIAL_LENDER_BANK <", value, "commercialLenderBank");
			return (Criteria) this;
		}

		public Criteria andCommercialLenderBankLessThanOrEqualTo(String value) {
			addCriterion("COMMERCIAL_LENDER_BANK <=", value, "commercialLenderBank");
			return (Criteria) this;
		}

		public Criteria andCommercialLenderBankLike(String value) {
			addCriterion("COMMERCIAL_LENDER_BANK like", value, "commercialLenderBank");
			return (Criteria) this;
		}

		public Criteria andCommercialLenderBankNotLike(String value) {
			addCriterion("COMMERCIAL_LENDER_BANK not like", value, "commercialLenderBank");
			return (Criteria) this;
		}

		public Criteria andCommercialLenderBankIn(List<String> values) {
			addCriterion("COMMERCIAL_LENDER_BANK in", values, "commercialLenderBank");
			return (Criteria) this;
		}

		public Criteria andCommercialLenderBankNotIn(List<String> values) {
			addCriterion("COMMERCIAL_LENDER_BANK not in", values, "commercialLenderBank");
			return (Criteria) this;
		}

		public Criteria andCommercialLenderBankBetween(String value1, String value2) {
			addCriterion("COMMERCIAL_LENDER_BANK between", value1, value2, "commercialLenderBank");
			return (Criteria) this;
		}

		public Criteria andCommercialLenderBankNotBetween(String value1, String value2) {
			addCriterion("COMMERCIAL_LENDER_BANK not between", value1, value2, "commercialLenderBank");
			return (Criteria) this;
		}

		public Criteria andProvidentLoanDateIsNull() {
			addCriterion("PROVIDENT_LOAN_DATE is null");
			return (Criteria) this;
		}

		public Criteria andProvidentLoanDateIsNotNull() {
			addCriterion("PROVIDENT_LOAN_DATE is not null");
			return (Criteria) this;
		}

		public Criteria andProvidentLoanDateEqualTo(Date value) {
			addCriterion("PROVIDENT_LOAN_DATE =", value, "providentLoanDate");
			return (Criteria) this;
		}

		public Criteria andProvidentLoanDateNotEqualTo(Date value) {
			addCriterion("PROVIDENT_LOAN_DATE <>", value, "providentLoanDate");
			return (Criteria) this;
		}

		public Criteria andProvidentLoanDateGreaterThan(Date value) {
			addCriterion("PROVIDENT_LOAN_DATE >", value, "providentLoanDate");
			return (Criteria) this;
		}

		public Criteria andProvidentLoanDateGreaterThanOrEqualTo(Date value) {
			addCriterion("PROVIDENT_LOAN_DATE >=", value, "providentLoanDate");
			return (Criteria) this;
		}

		public Criteria andProvidentLoanDateLessThan(Date value) {
			addCriterion("PROVIDENT_LOAN_DATE <", value, "providentLoanDate");
			return (Criteria) this;
		}

		public Criteria andProvidentLoanDateLessThanOrEqualTo(Date value) {
			addCriterion("PROVIDENT_LOAN_DATE <=", value, "providentLoanDate");
			return (Criteria) this;
		}

		public Criteria andProvidentLoanDateIn(List<Date> values) {
			addCriterion("PROVIDENT_LOAN_DATE in", values, "providentLoanDate");
			return (Criteria) this;
		}

		public Criteria andProvidentLoanDateNotIn(List<Date> values) {
			addCriterion("PROVIDENT_LOAN_DATE not in", values, "providentLoanDate");
			return (Criteria) this;
		}

		public Criteria andProvidentLoanDateBetween(Date value1, Date value2) {
			addCriterion("PROVIDENT_LOAN_DATE between", value1, value2, "providentLoanDate");
			return (Criteria) this;
		}

		public Criteria andProvidentLoanDateNotBetween(Date value1, Date value2) {
			addCriterion("PROVIDENT_LOAN_DATE not between", value1, value2, "providentLoanDate");
			return (Criteria) this;
		}

		public Criteria andProvidentLenderDateIsNull() {
			addCriterion("PROVIDENT_LENDER_DATE is null");
			return (Criteria) this;
		}

		public Criteria andProvidentLenderDateIsNotNull() {
			addCriterion("PROVIDENT_LENDER_DATE is not null");
			return (Criteria) this;
		}

		public Criteria andProvidentLenderDateEqualTo(Date value) {
			addCriterion("PROVIDENT_LENDER_DATE =", value, "providentLenderDate");
			return (Criteria) this;
		}

		public Criteria andProvidentLenderDateNotEqualTo(Date value) {
			addCriterion("PROVIDENT_LENDER_DATE <>", value, "providentLenderDate");
			return (Criteria) this;
		}

		public Criteria andProvidentLenderDateGreaterThan(Date value) {
			addCriterion("PROVIDENT_LENDER_DATE >", value, "providentLenderDate");
			return (Criteria) this;
		}

		public Criteria andProvidentLenderDateGreaterThanOrEqualTo(Date value) {
			addCriterion("PROVIDENT_LENDER_DATE >=", value, "providentLenderDate");
			return (Criteria) this;
		}

		public Criteria andProvidentLenderDateLessThan(Date value) {
			addCriterion("PROVIDENT_LENDER_DATE <", value, "providentLenderDate");
			return (Criteria) this;
		}

		public Criteria andProvidentLenderDateLessThanOrEqualTo(Date value) {
			addCriterion("PROVIDENT_LENDER_DATE <=", value, "providentLenderDate");
			return (Criteria) this;
		}

		public Criteria andProvidentLenderDateIn(List<Date> values) {
			addCriterion("PROVIDENT_LENDER_DATE in", values, "providentLenderDate");
			return (Criteria) this;
		}

		public Criteria andProvidentLenderDateNotIn(List<Date> values) {
			addCriterion("PROVIDENT_LENDER_DATE not in", values, "providentLenderDate");
			return (Criteria) this;
		}

		public Criteria andProvidentLenderDateBetween(Date value1, Date value2) {
			addCriterion("PROVIDENT_LENDER_DATE between", value1, value2, "providentLenderDate");
			return (Criteria) this;
		}

		public Criteria andProvidentLenderDateNotBetween(Date value1, Date value2) {
			addCriterion("PROVIDENT_LENDER_DATE not between", value1, value2, "providentLenderDate");
			return (Criteria) this;
		}

		public Criteria andProvidentLenderLimitIsNull() {
			addCriterion("PROVIDENT_LENDER_LIMIT is null");
			return (Criteria) this;
		}

		public Criteria andProvidentLenderLimitIsNotNull() {
			addCriterion("PROVIDENT_LENDER_LIMIT is not null");
			return (Criteria) this;
		}

		public Criteria andProvidentLenderLimitEqualTo(String value) {
			addCriterion("PROVIDENT_LENDER_LIMIT =", value, "providentLenderLimit");
			return (Criteria) this;
		}

		public Criteria andProvidentLenderLimitNotEqualTo(String value) {
			addCriterion("PROVIDENT_LENDER_LIMIT <>", value, "providentLenderLimit");
			return (Criteria) this;
		}

		public Criteria andProvidentLenderLimitGreaterThan(String value) {
			addCriterion("PROVIDENT_LENDER_LIMIT >", value, "providentLenderLimit");
			return (Criteria) this;
		}

		public Criteria andProvidentLenderLimitGreaterThanOrEqualTo(String value) {
			addCriterion("PROVIDENT_LENDER_LIMIT >=", value, "providentLenderLimit");
			return (Criteria) this;
		}

		public Criteria andProvidentLenderLimitLessThan(String value) {
			addCriterion("PROVIDENT_LENDER_LIMIT <", value, "providentLenderLimit");
			return (Criteria) this;
		}

		public Criteria andProvidentLenderLimitLessThanOrEqualTo(String value) {
			addCriterion("PROVIDENT_LENDER_LIMIT <=", value, "providentLenderLimit");
			return (Criteria) this;
		}

		public Criteria andProvidentLenderLimitLike(String value) {
			addCriterion("PROVIDENT_LENDER_LIMIT like", value, "providentLenderLimit");
			return (Criteria) this;
		}

		public Criteria andProvidentLenderLimitNotLike(String value) {
			addCriterion("PROVIDENT_LENDER_LIMIT not like", value, "providentLenderLimit");
			return (Criteria) this;
		}

		public Criteria andProvidentLenderLimitIn(List<String> values) {
			addCriterion("PROVIDENT_LENDER_LIMIT in", values, "providentLenderLimit");
			return (Criteria) this;
		}

		public Criteria andProvidentLenderLimitNotIn(List<String> values) {
			addCriterion("PROVIDENT_LENDER_LIMIT not in", values, "providentLenderLimit");
			return (Criteria) this;
		}

		public Criteria andProvidentLenderLimitBetween(String value1, String value2) {
			addCriterion("PROVIDENT_LENDER_LIMIT between", value1, value2, "providentLenderLimit");
			return (Criteria) this;
		}

		public Criteria andProvidentLenderLimitNotBetween(String value1, String value2) {
			addCriterion("PROVIDENT_LENDER_LIMIT not between", value1, value2, "providentLenderLimit");
			return (Criteria) this;
		}

		public Criteria andProvidentLenderBankIsNull() {
			addCriterion("PROVIDENT_LENDER_BANK is null");
			return (Criteria) this;
		}

		public Criteria andProvidentLenderBankIsNotNull() {
			addCriterion("PROVIDENT_LENDER_BANK is not null");
			return (Criteria) this;
		}

		public Criteria andProvidentLenderBankEqualTo(String value) {
			addCriterion("PROVIDENT_LENDER_BANK =", value, "providentLenderBank");
			return (Criteria) this;
		}

		public Criteria andProvidentLenderBankNotEqualTo(String value) {
			addCriterion("PROVIDENT_LENDER_BANK <>", value, "providentLenderBank");
			return (Criteria) this;
		}

		public Criteria andProvidentLenderBankGreaterThan(String value) {
			addCriterion("PROVIDENT_LENDER_BANK >", value, "providentLenderBank");
			return (Criteria) this;
		}

		public Criteria andProvidentLenderBankGreaterThanOrEqualTo(String value) {
			addCriterion("PROVIDENT_LENDER_BANK >=", value, "providentLenderBank");
			return (Criteria) this;
		}

		public Criteria andProvidentLenderBankLessThan(String value) {
			addCriterion("PROVIDENT_LENDER_BANK <", value, "providentLenderBank");
			return (Criteria) this;
		}

		public Criteria andProvidentLenderBankLessThanOrEqualTo(String value) {
			addCriterion("PROVIDENT_LENDER_BANK <=", value, "providentLenderBank");
			return (Criteria) this;
		}

		public Criteria andProvidentLenderBankLike(String value) {
			addCriterion("PROVIDENT_LENDER_BANK like", value, "providentLenderBank");
			return (Criteria) this;
		}

		public Criteria andProvidentLenderBankNotLike(String value) {
			addCriterion("PROVIDENT_LENDER_BANK not like", value, "providentLenderBank");
			return (Criteria) this;
		}

		public Criteria andProvidentLenderBankIn(List<String> values) {
			addCriterion("PROVIDENT_LENDER_BANK in", values, "providentLenderBank");
			return (Criteria) this;
		}

		public Criteria andProvidentLenderBankNotIn(List<String> values) {
			addCriterion("PROVIDENT_LENDER_BANK not in", values, "providentLenderBank");
			return (Criteria) this;
		}

		public Criteria andProvidentLenderBankBetween(String value1, String value2) {
			addCriterion("PROVIDENT_LENDER_BANK between", value1, value2, "providentLenderBank");
			return (Criteria) this;
		}

		public Criteria andProvidentLenderBankNotBetween(String value1, String value2) {
			addCriterion("PROVIDENT_LENDER_BANK not between", value1, value2, "providentLenderBank");
			return (Criteria) this;
		}

		public Criteria andTotalNeedIncomeIsNull() {
			addCriterion("TOTAL_NEED_INCOME is null");
			return (Criteria) this;
		}

		public Criteria andTotalNeedIncomeIsNotNull() {
			addCriterion("TOTAL_NEED_INCOME is not null");
			return (Criteria) this;
		}

		public Criteria andTotalNeedIncomeEqualTo(BigDecimal value) {
			addCriterion("TOTAL_NEED_INCOME =", value, "totalNeedIncome");
			return (Criteria) this;
		}

		public Criteria andTotalNeedIncomeNotEqualTo(BigDecimal value) {
			addCriterion("TOTAL_NEED_INCOME <>", value, "totalNeedIncome");
			return (Criteria) this;
		}

		public Criteria andTotalNeedIncomeGreaterThan(BigDecimal value) {
			addCriterion("TOTAL_NEED_INCOME >", value, "totalNeedIncome");
			return (Criteria) this;
		}

		public Criteria andTotalNeedIncomeGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("TOTAL_NEED_INCOME >=", value, "totalNeedIncome");
			return (Criteria) this;
		}

		public Criteria andTotalNeedIncomeLessThan(BigDecimal value) {
			addCriterion("TOTAL_NEED_INCOME <", value, "totalNeedIncome");
			return (Criteria) this;
		}

		public Criteria andTotalNeedIncomeLessThanOrEqualTo(BigDecimal value) {
			addCriterion("TOTAL_NEED_INCOME <=", value, "totalNeedIncome");
			return (Criteria) this;
		}

		public Criteria andTotalNeedIncomeIn(List<BigDecimal> values) {
			addCriterion("TOTAL_NEED_INCOME in", values, "totalNeedIncome");
			return (Criteria) this;
		}

		public Criteria andTotalNeedIncomeNotIn(List<BigDecimal> values) {
			addCriterion("TOTAL_NEED_INCOME not in", values, "totalNeedIncome");
			return (Criteria) this;
		}

		public Criteria andTotalNeedIncomeBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("TOTAL_NEED_INCOME between", value1, value2, "totalNeedIncome");
			return (Criteria) this;
		}

		public Criteria andTotalNeedIncomeNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("TOTAL_NEED_INCOME not between", value1, value2, "totalNeedIncome");
			return (Criteria) this;
		}

		public Criteria andTotalRealIncomeIsNull() {
			addCriterion("TOTAL_REAL_INCOME is null");
			return (Criteria) this;
		}

		public Criteria andTotalRealIncomeIsNotNull() {
			addCriterion("TOTAL_REAL_INCOME is not null");
			return (Criteria) this;
		}

		public Criteria andTotalRealIncomeEqualTo(BigDecimal value) {
			addCriterion("TOTAL_REAL_INCOME =", value, "totalRealIncome");
			return (Criteria) this;
		}

		public Criteria andTotalRealIncomeNotEqualTo(BigDecimal value) {
			addCriterion("TOTAL_REAL_INCOME <>", value, "totalRealIncome");
			return (Criteria) this;
		}

		public Criteria andTotalRealIncomeGreaterThan(BigDecimal value) {
			addCriterion("TOTAL_REAL_INCOME >", value, "totalRealIncome");
			return (Criteria) this;
		}

		public Criteria andTotalRealIncomeGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("TOTAL_REAL_INCOME >=", value, "totalRealIncome");
			return (Criteria) this;
		}

		public Criteria andTotalRealIncomeLessThan(BigDecimal value) {
			addCriterion("TOTAL_REAL_INCOME <", value, "totalRealIncome");
			return (Criteria) this;
		}

		public Criteria andTotalRealIncomeLessThanOrEqualTo(BigDecimal value) {
			addCriterion("TOTAL_REAL_INCOME <=", value, "totalRealIncome");
			return (Criteria) this;
		}

		public Criteria andTotalRealIncomeIn(List<BigDecimal> values) {
			addCriterion("TOTAL_REAL_INCOME in", values, "totalRealIncome");
			return (Criteria) this;
		}

		public Criteria andTotalRealIncomeNotIn(List<BigDecimal> values) {
			addCriterion("TOTAL_REAL_INCOME not in", values, "totalRealIncome");
			return (Criteria) this;
		}

		public Criteria andTotalRealIncomeBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("TOTAL_REAL_INCOME between", value1, value2, "totalRealIncome");
			return (Criteria) this;
		}

		public Criteria andTotalRealIncomeNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("TOTAL_REAL_INCOME not between", value1, value2, "totalRealIncome");
			return (Criteria) this;
		}

		public Criteria andTotalNeedPerformanceIsNull() {
			addCriterion("TOTAL_NEED_PERFORMANCE is null");
			return (Criteria) this;
		}

		public Criteria andTotalNeedPerformanceIsNotNull() {
			addCriterion("TOTAL_NEED_PERFORMANCE is not null");
			return (Criteria) this;
		}

		public Criteria andTotalNeedPerformanceEqualTo(BigDecimal value) {
			addCriterion("TOTAL_NEED_PERFORMANCE =", value, "totalNeedPerformance");
			return (Criteria) this;
		}

		public Criteria andTotalNeedPerformanceNotEqualTo(BigDecimal value) {
			addCriterion("TOTAL_NEED_PERFORMANCE <>", value, "totalNeedPerformance");
			return (Criteria) this;
		}

		public Criteria andTotalNeedPerformanceGreaterThan(BigDecimal value) {
			addCriterion("TOTAL_NEED_PERFORMANCE >", value, "totalNeedPerformance");
			return (Criteria) this;
		}

		public Criteria andTotalNeedPerformanceGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("TOTAL_NEED_PERFORMANCE >=", value, "totalNeedPerformance");
			return (Criteria) this;
		}

		public Criteria andTotalNeedPerformanceLessThan(BigDecimal value) {
			addCriterion("TOTAL_NEED_PERFORMANCE <", value, "totalNeedPerformance");
			return (Criteria) this;
		}

		public Criteria andTotalNeedPerformanceLessThanOrEqualTo(BigDecimal value) {
			addCriterion("TOTAL_NEED_PERFORMANCE <=", value, "totalNeedPerformance");
			return (Criteria) this;
		}

		public Criteria andTotalNeedPerformanceIn(List<BigDecimal> values) {
			addCriterion("TOTAL_NEED_PERFORMANCE in", values, "totalNeedPerformance");
			return (Criteria) this;
		}

		public Criteria andTotalNeedPerformanceNotIn(List<BigDecimal> values) {
			addCriterion("TOTAL_NEED_PERFORMANCE not in", values, "totalNeedPerformance");
			return (Criteria) this;
		}

		public Criteria andTotalNeedPerformanceBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("TOTAL_NEED_PERFORMANCE between", value1, value2, "totalNeedPerformance");
			return (Criteria) this;
		}

		public Criteria andTotalNeedPerformanceNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("TOTAL_NEED_PERFORMANCE not between", value1, value2, "totalNeedPerformance");
			return (Criteria) this;
		}

		public Criteria andTotalRealPerformanceIsNull() {
			addCriterion("TOTAL_REAL_PERFORMANCE is null");
			return (Criteria) this;
		}

		public Criteria andTotalRealPerformanceIsNotNull() {
			addCriterion("TOTAL_REAL_PERFORMANCE is not null");
			return (Criteria) this;
		}

		public Criteria andTotalRealPerformanceEqualTo(BigDecimal value) {
			addCriterion("TOTAL_REAL_PERFORMANCE =", value, "totalRealPerformance");
			return (Criteria) this;
		}

		public Criteria andTotalRealPerformanceNotEqualTo(BigDecimal value) {
			addCriterion("TOTAL_REAL_PERFORMANCE <>", value, "totalRealPerformance");
			return (Criteria) this;
		}

		public Criteria andTotalRealPerformanceGreaterThan(BigDecimal value) {
			addCriterion("TOTAL_REAL_PERFORMANCE >", value, "totalRealPerformance");
			return (Criteria) this;
		}

		public Criteria andTotalRealPerformanceGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("TOTAL_REAL_PERFORMANCE >=", value, "totalRealPerformance");
			return (Criteria) this;
		}

		public Criteria andTotalRealPerformanceLessThan(BigDecimal value) {
			addCriterion("TOTAL_REAL_PERFORMANCE <", value, "totalRealPerformance");
			return (Criteria) this;
		}

		public Criteria andTotalRealPerformanceLessThanOrEqualTo(BigDecimal value) {
			addCriterion("TOTAL_REAL_PERFORMANCE <=", value, "totalRealPerformance");
			return (Criteria) this;
		}

		public Criteria andTotalRealPerformanceIn(List<BigDecimal> values) {
			addCriterion("TOTAL_REAL_PERFORMANCE in", values, "totalRealPerformance");
			return (Criteria) this;
		}

		public Criteria andTotalRealPerformanceNotIn(List<BigDecimal> values) {
			addCriterion("TOTAL_REAL_PERFORMANCE not in", values, "totalRealPerformance");
			return (Criteria) this;
		}

		public Criteria andTotalRealPerformanceBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("TOTAL_REAL_PERFORMANCE between", value1, value2, "totalRealPerformance");
			return (Criteria) this;
		}

		public Criteria andTotalRealPerformanceNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("TOTAL_REAL_PERFORMANCE not between", value1, value2, "totalRealPerformance");
			return (Criteria) this;
		}

		public Criteria andNeedAduitStatusIsNull() {
			addCriterion("NEED_ADUIT_STATUS is null");
			return (Criteria) this;
		}

		public Criteria andNeedAduitStatusIsNotNull() {
			addCriterion("NEED_ADUIT_STATUS is not null");
			return (Criteria) this;
		}

		public Criteria andNeedAduitStatusEqualTo(Byte value) {
			addCriterion("NEED_ADUIT_STATUS =", value, "needAduitStatus");
			return (Criteria) this;
		}

		public Criteria andNeedAduitStatusNotEqualTo(Byte value) {
			addCriterion("NEED_ADUIT_STATUS <>", value, "needAduitStatus");
			return (Criteria) this;
		}

		public Criteria andNeedAduitStatusGreaterThan(Byte value) {
			addCriterion("NEED_ADUIT_STATUS >", value, "needAduitStatus");
			return (Criteria) this;
		}

		public Criteria andNeedAduitStatusGreaterThanOrEqualTo(Byte value) {
			addCriterion("NEED_ADUIT_STATUS >=", value, "needAduitStatus");
			return (Criteria) this;
		}

		public Criteria andNeedAduitStatusLessThan(Byte value) {
			addCriterion("NEED_ADUIT_STATUS <", value, "needAduitStatus");
			return (Criteria) this;
		}

		public Criteria andNeedAduitStatusLessThanOrEqualTo(Byte value) {
			addCriterion("NEED_ADUIT_STATUS <=", value, "needAduitStatus");
			return (Criteria) this;
		}

		public Criteria andNeedAduitStatusIn(List<Byte> values) {
			addCriterion("NEED_ADUIT_STATUS in", values, "needAduitStatus");
			return (Criteria) this;
		}

		public Criteria andNeedAduitStatusNotIn(List<Byte> values) {
			addCriterion("NEED_ADUIT_STATUS not in", values, "needAduitStatus");
			return (Criteria) this;
		}

		public Criteria andNeedAduitStatusBetween(Byte value1, Byte value2) {
			addCriterion("NEED_ADUIT_STATUS between", value1, value2, "needAduitStatus");
			return (Criteria) this;
		}

		public Criteria andNeedAduitStatusNotBetween(Byte value1, Byte value2) {
			addCriterion("NEED_ADUIT_STATUS not between", value1, value2, "needAduitStatus");
			return (Criteria) this;
		}

		public Criteria andRealAduitStatusIsNull() {
			addCriterion("REAL_ADUIT_STATUS is null");
			return (Criteria) this;
		}

		public Criteria andRealAduitStatusIsNotNull() {
			addCriterion("REAL_ADUIT_STATUS is not null");
			return (Criteria) this;
		}

		public Criteria andRealAduitStatusEqualTo(Byte value) {
			addCriterion("REAL_ADUIT_STATUS =", value, "realAduitStatus");
			return (Criteria) this;
		}

		public Criteria andRealAduitStatusNotEqualTo(Byte value) {
			addCriterion("REAL_ADUIT_STATUS <>", value, "realAduitStatus");
			return (Criteria) this;
		}

		public Criteria andRealAduitStatusGreaterThan(Byte value) {
			addCriterion("REAL_ADUIT_STATUS >", value, "realAduitStatus");
			return (Criteria) this;
		}

		public Criteria andRealAduitStatusGreaterThanOrEqualTo(Byte value) {
			addCriterion("REAL_ADUIT_STATUS >=", value, "realAduitStatus");
			return (Criteria) this;
		}

		public Criteria andRealAduitStatusLessThan(Byte value) {
			addCriterion("REAL_ADUIT_STATUS <", value, "realAduitStatus");
			return (Criteria) this;
		}

		public Criteria andRealAduitStatusLessThanOrEqualTo(Byte value) {
			addCriterion("REAL_ADUIT_STATUS <=", value, "realAduitStatus");
			return (Criteria) this;
		}

		public Criteria andRealAduitStatusIn(List<Byte> values) {
			addCriterion("REAL_ADUIT_STATUS in", values, "realAduitStatus");
			return (Criteria) this;
		}

		public Criteria andRealAduitStatusNotIn(List<Byte> values) {
			addCriterion("REAL_ADUIT_STATUS not in", values, "realAduitStatus");
			return (Criteria) this;
		}

		public Criteria andRealAduitStatusBetween(Byte value1, Byte value2) {
			addCriterion("REAL_ADUIT_STATUS between", value1, value2, "realAduitStatus");
			return (Criteria) this;
		}

		public Criteria andRealAduitStatusNotBetween(Byte value1, Byte value2) {
			addCriterion("REAL_ADUIT_STATUS not between", value1, value2, "realAduitStatus");
			return (Criteria) this;
		}

		public Criteria andIntelligentSearchIsNull() {
			addCriterion("INTELLIGENT_SEARCH is null");
			return (Criteria) this;
		}

		public Criteria andIntelligentSearchIsNotNull() {
			addCriterion("INTELLIGENT_SEARCH is not null");
			return (Criteria) this;
		}

		public Criteria andIntelligentSearchEqualTo(String value) {
			addCriterion("INTELLIGENT_SEARCH =", value, "intelligentSearch");
			return (Criteria) this;
		}

		public Criteria andIntelligentSearchNotEqualTo(String value) {
			addCriterion("INTELLIGENT_SEARCH <>", value, "intelligentSearch");
			return (Criteria) this;
		}

		public Criteria andIntelligentSearchGreaterThan(String value) {
			addCriterion("INTELLIGENT_SEARCH >", value, "intelligentSearch");
			return (Criteria) this;
		}

		public Criteria andIntelligentSearchGreaterThanOrEqualTo(String value) {
			addCriterion("INTELLIGENT_SEARCH >=", value, "intelligentSearch");
			return (Criteria) this;
		}

		public Criteria andIntelligentSearchLessThan(String value) {
			addCriterion("INTELLIGENT_SEARCH <", value, "intelligentSearch");
			return (Criteria) this;
		}

		public Criteria andIntelligentSearchLessThanOrEqualTo(String value) {
			addCriterion("INTELLIGENT_SEARCH <=", value, "intelligentSearch");
			return (Criteria) this;
		}

		public Criteria andIntelligentSearchLike(String value) {
			addCriterion("INTELLIGENT_SEARCH like", value, "intelligentSearch");
			return (Criteria) this;
		}

		public Criteria andIntelligentSearchNotLike(String value) {
			addCriterion("INTELLIGENT_SEARCH not like", value, "intelligentSearch");
			return (Criteria) this;
		}

		public Criteria andIntelligentSearchIn(List<String> values) {
			addCriterion("INTELLIGENT_SEARCH in", values, "intelligentSearch");
			return (Criteria) this;
		}

		public Criteria andIntelligentSearchNotIn(List<String> values) {
			addCriterion("INTELLIGENT_SEARCH not in", values, "intelligentSearch");
			return (Criteria) this;
		}

		public Criteria andIntelligentSearchBetween(String value1, String value2) {
			addCriterion("INTELLIGENT_SEARCH between", value1, value2, "intelligentSearch");
			return (Criteria) this;
		}

		public Criteria andIntelligentSearchNotBetween(String value1, String value2) {
			addCriterion("INTELLIGENT_SEARCH not between", value1, value2, "intelligentSearch");
			return (Criteria) this;
		}

		public Criteria andProvidentLoanMoneyIsNull() {
			addCriterion("PROVIDENT_LOAN_MONEY is null");
			return (Criteria) this;
		}

		public Criteria andProvidentLoanMoneyIsNotNull() {
			addCriterion("PROVIDENT_LOAN_MONEY is not null");
			return (Criteria) this;
		}

		public Criteria andProvidentLoanMoneyEqualTo(BigDecimal value) {
			addCriterion("PROVIDENT_LOAN_MONEY =", value, "providentLoanMoney");
			return (Criteria) this;
		}

		public Criteria andProvidentLoanMoneyNotEqualTo(BigDecimal value) {
			addCriterion("PROVIDENT_LOAN_MONEY <>", value, "providentLoanMoney");
			return (Criteria) this;
		}

		public Criteria andProvidentLoanMoneyGreaterThan(BigDecimal value) {
			addCriterion("PROVIDENT_LOAN_MONEY >", value, "providentLoanMoney");
			return (Criteria) this;
		}

		public Criteria andProvidentLoanMoneyGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("PROVIDENT_LOAN_MONEY >=", value, "providentLoanMoney");
			return (Criteria) this;
		}

		public Criteria andProvidentLoanMoneyLessThan(BigDecimal value) {
			addCriterion("PROVIDENT_LOAN_MONEY <", value, "providentLoanMoney");
			return (Criteria) this;
		}

		public Criteria andProvidentLoanMoneyLessThanOrEqualTo(BigDecimal value) {
			addCriterion("PROVIDENT_LOAN_MONEY <=", value, "providentLoanMoney");
			return (Criteria) this;
		}

		public Criteria andProvidentLoanMoneyIn(List<BigDecimal> values) {
			addCriterion("PROVIDENT_LOAN_MONEY in", values, "providentLoanMoney");
			return (Criteria) this;
		}

		public Criteria andProvidentLoanMoneyNotIn(List<BigDecimal> values) {
			addCriterion("PROVIDENT_LOAN_MONEY not in", values, "providentLoanMoney");
			return (Criteria) this;
		}

		public Criteria andProvidentLoanMoneyBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("PROVIDENT_LOAN_MONEY between", value1, value2, "providentLoanMoney");
			return (Criteria) this;
		}

		public Criteria andProvidentLoanMoneyNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("PROVIDENT_LOAN_MONEY not between", value1, value2, "providentLoanMoney");
			return (Criteria) this;
		}

		public Criteria andCommercialLoanMoneyIsNull() {
			addCriterion("COMMERCIAL_LOAN_MONEY is null");
			return (Criteria) this;
		}

		public Criteria andCommercialLoanMoneyIsNotNull() {
			addCriterion("COMMERCIAL_LOAN_MONEY is not null");
			return (Criteria) this;
		}

		public Criteria andCommercialLoanMoneyEqualTo(BigDecimal value) {
			addCriterion("COMMERCIAL_LOAN_MONEY =", value, "commercialLoanMoney");
			return (Criteria) this;
		}

		public Criteria andCommercialLoanMoneyNotEqualTo(BigDecimal value) {
			addCriterion("COMMERCIAL_LOAN_MONEY <>", value, "commercialLoanMoney");
			return (Criteria) this;
		}

		public Criteria andCommercialLoanMoneyGreaterThan(BigDecimal value) {
			addCriterion("COMMERCIAL_LOAN_MONEY >", value, "commercialLoanMoney");
			return (Criteria) this;
		}

		public Criteria andCommercialLoanMoneyGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("COMMERCIAL_LOAN_MONEY >=", value, "commercialLoanMoney");
			return (Criteria) this;
		}

		public Criteria andCommercialLoanMoneyLessThan(BigDecimal value) {
			addCriterion("COMMERCIAL_LOAN_MONEY <", value, "commercialLoanMoney");
			return (Criteria) this;
		}

		public Criteria andCommercialLoanMoneyLessThanOrEqualTo(BigDecimal value) {
			addCriterion("COMMERCIAL_LOAN_MONEY <=", value, "commercialLoanMoney");
			return (Criteria) this;
		}

		public Criteria andCommercialLoanMoneyIn(List<BigDecimal> values) {
			addCriterion("COMMERCIAL_LOAN_MONEY in", values, "commercialLoanMoney");
			return (Criteria) this;
		}

		public Criteria andCommercialLoanMoneyNotIn(List<BigDecimal> values) {
			addCriterion("COMMERCIAL_LOAN_MONEY not in", values, "commercialLoanMoney");
			return (Criteria) this;
		}

		public Criteria andCommercialLoanMoneyBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("COMMERCIAL_LOAN_MONEY between", value1, value2, "commercialLoanMoney");
			return (Criteria) this;
		}

		public Criteria andCommercialLoanMoneyNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("COMMERCIAL_LOAN_MONEY not between", value1, value2, "commercialLoanMoney");
			return (Criteria) this;
		}

		public Criteria andTaxesAuditStatusIsNull() {
			addCriterion("TAXES_AUDIT_STATUS is null");
			return (Criteria) this;
		}

		public Criteria andTaxesAuditStatusIsNotNull() {
			addCriterion("TAXES_AUDIT_STATUS is not null");
			return (Criteria) this;
		}

		public Criteria andTaxesAuditStatusEqualTo(Byte value) {
			addCriterion("TAXES_AUDIT_STATUS =", value, "taxesAuditStatus");
			return (Criteria) this;
		}

		public Criteria andTaxesAuditStatusNotEqualTo(Byte value) {
			addCriterion("TAXES_AUDIT_STATUS <>", value, "taxesAuditStatus");
			return (Criteria) this;
		}

		public Criteria andTaxesAuditStatusGreaterThan(Byte value) {
			addCriterion("TAXES_AUDIT_STATUS >", value, "taxesAuditStatus");
			return (Criteria) this;
		}

		public Criteria andTaxesAuditStatusGreaterThanOrEqualTo(Byte value) {
			addCriterion("TAXES_AUDIT_STATUS >=", value, "taxesAuditStatus");
			return (Criteria) this;
		}

		public Criteria andTaxesAuditStatusLessThan(Byte value) {
			addCriterion("TAXES_AUDIT_STATUS <", value, "taxesAuditStatus");
			return (Criteria) this;
		}

		public Criteria andTaxesAuditStatusLessThanOrEqualTo(Byte value) {
			addCriterion("TAXES_AUDIT_STATUS <=", value, "taxesAuditStatus");
			return (Criteria) this;
		}

		public Criteria andTaxesAuditStatusIn(List<Byte> values) {
			addCriterion("TAXES_AUDIT_STATUS in", values, "taxesAuditStatus");
			return (Criteria) this;
		}

		public Criteria andTaxesAuditStatusNotIn(List<Byte> values) {
			addCriterion("TAXES_AUDIT_STATUS not in", values, "taxesAuditStatus");
			return (Criteria) this;
		}

		public Criteria andTaxesAuditStatusBetween(Byte value1, Byte value2) {
			addCriterion("TAXES_AUDIT_STATUS between", value1, value2, "taxesAuditStatus");
			return (Criteria) this;
		}

		public Criteria andTaxesAuditStatusNotBetween(Byte value1, Byte value2) {
			addCriterion("TAXES_AUDIT_STATUS not between", value1, value2, "taxesAuditStatus");
			return (Criteria) this;
		}

		public Criteria andTaxesAuditNameIsNull() {
			addCriterion("TAXES_AUDIT_NAME is null");
			return (Criteria) this;
		}

		public Criteria andTaxesAuditNameIsNotNull() {
			addCriterion("TAXES_AUDIT_NAME is not null");
			return (Criteria) this;
		}

		public Criteria andTaxesAuditNameEqualTo(String value) {
			addCriterion("TAXES_AUDIT_NAME =", value, "taxesAuditName");
			return (Criteria) this;
		}

		public Criteria andTaxesAuditNameNotEqualTo(String value) {
			addCriterion("TAXES_AUDIT_NAME <>", value, "taxesAuditName");
			return (Criteria) this;
		}

		public Criteria andTaxesAuditNameGreaterThan(String value) {
			addCriterion("TAXES_AUDIT_NAME >", value, "taxesAuditName");
			return (Criteria) this;
		}

		public Criteria andTaxesAuditNameGreaterThanOrEqualTo(String value) {
			addCriterion("TAXES_AUDIT_NAME >=", value, "taxesAuditName");
			return (Criteria) this;
		}

		public Criteria andTaxesAuditNameLessThan(String value) {
			addCriterion("TAXES_AUDIT_NAME <", value, "taxesAuditName");
			return (Criteria) this;
		}

		public Criteria andTaxesAuditNameLessThanOrEqualTo(String value) {
			addCriterion("TAXES_AUDIT_NAME <=", value, "taxesAuditName");
			return (Criteria) this;
		}

		public Criteria andTaxesAuditNameLike(String value) {
			addCriterion("TAXES_AUDIT_NAME like", value, "taxesAuditName");
			return (Criteria) this;
		}

		public Criteria andTaxesAuditNameNotLike(String value) {
			addCriterion("TAXES_AUDIT_NAME not like", value, "taxesAuditName");
			return (Criteria) this;
		}

		public Criteria andTaxesAuditNameIn(List<String> values) {
			addCriterion("TAXES_AUDIT_NAME in", values, "taxesAuditName");
			return (Criteria) this;
		}

		public Criteria andTaxesAuditNameNotIn(List<String> values) {
			addCriterion("TAXES_AUDIT_NAME not in", values, "taxesAuditName");
			return (Criteria) this;
		}

		public Criteria andTaxesAuditNameBetween(String value1, String value2) {
			addCriterion("TAXES_AUDIT_NAME between", value1, value2, "taxesAuditName");
			return (Criteria) this;
		}

		public Criteria andTaxesAuditNameNotBetween(String value1, String value2) {
			addCriterion("TAXES_AUDIT_NAME not between", value1, value2, "taxesAuditName");
			return (Criteria) this;
		}

		public Criteria andTaxesAuditUserIsNull() {
			addCriterion("TAXES_AUDIT_USER is null");
			return (Criteria) this;
		}

		public Criteria andTaxesAuditUserIsNotNull() {
			addCriterion("TAXES_AUDIT_USER is not null");
			return (Criteria) this;
		}

		public Criteria andTaxesAuditUserEqualTo(Integer value) {
			addCriterion("TAXES_AUDIT_USER =", value, "taxesAuditUser");
			return (Criteria) this;
		}

		public Criteria andTaxesAuditUserNotEqualTo(Integer value) {
			addCriterion("TAXES_AUDIT_USER <>", value, "taxesAuditUser");
			return (Criteria) this;
		}

		public Criteria andTaxesAuditUserGreaterThan(Integer value) {
			addCriterion("TAXES_AUDIT_USER >", value, "taxesAuditUser");
			return (Criteria) this;
		}

		public Criteria andTaxesAuditUserGreaterThanOrEqualTo(Integer value) {
			addCriterion("TAXES_AUDIT_USER >=", value, "taxesAuditUser");
			return (Criteria) this;
		}

		public Criteria andTaxesAuditUserLessThan(Integer value) {
			addCriterion("TAXES_AUDIT_USER <", value, "taxesAuditUser");
			return (Criteria) this;
		}

		public Criteria andTaxesAuditUserLessThanOrEqualTo(Integer value) {
			addCriterion("TAXES_AUDIT_USER <=", value, "taxesAuditUser");
			return (Criteria) this;
		}

		public Criteria andTaxesAuditUserIn(List<Integer> values) {
			addCriterion("TAXES_AUDIT_USER in", values, "taxesAuditUser");
			return (Criteria) this;
		}

		public Criteria andTaxesAuditUserNotIn(List<Integer> values) {
			addCriterion("TAXES_AUDIT_USER not in", values, "taxesAuditUser");
			return (Criteria) this;
		}

		public Criteria andTaxesAuditUserBetween(Integer value1, Integer value2) {
			addCriterion("TAXES_AUDIT_USER between", value1, value2, "taxesAuditUser");
			return (Criteria) this;
		}

		public Criteria andTaxesAuditUserNotBetween(Integer value1, Integer value2) {
			addCriterion("TAXES_AUDIT_USER not between", value1, value2, "taxesAuditUser");
			return (Criteria) this;
		}

		public Criteria andTaxesAuditTimeIsNull() {
			addCriterion("TAXES_AUDIT_TIME is null");
			return (Criteria) this;
		}

		public Criteria andTaxesAuditTimeIsNotNull() {
			addCriterion("TAXES_AUDIT_TIME is not null");
			return (Criteria) this;
		}

		public Criteria andTaxesAuditTimeEqualTo(Date value) {
			addCriterion("TAXES_AUDIT_TIME =", value, "taxesAuditTime");
			return (Criteria) this;
		}

		public Criteria andTaxesAuditTimeNotEqualTo(Date value) {
			addCriterion("TAXES_AUDIT_TIME <>", value, "taxesAuditTime");
			return (Criteria) this;
		}

		public Criteria andTaxesAuditTimeGreaterThan(Date value) {
			addCriterion("TAXES_AUDIT_TIME >", value, "taxesAuditTime");
			return (Criteria) this;
		}

		public Criteria andTaxesAuditTimeGreaterThanOrEqualTo(Date value) {
			addCriterion("TAXES_AUDIT_TIME >=", value, "taxesAuditTime");
			return (Criteria) this;
		}

		public Criteria andTaxesAuditTimeLessThan(Date value) {
			addCriterion("TAXES_AUDIT_TIME <", value, "taxesAuditTime");
			return (Criteria) this;
		}

		public Criteria andTaxesAuditTimeLessThanOrEqualTo(Date value) {
			addCriterion("TAXES_AUDIT_TIME <=", value, "taxesAuditTime");
			return (Criteria) this;
		}

		public Criteria andTaxesAuditTimeIn(List<Date> values) {
			addCriterion("TAXES_AUDIT_TIME in", values, "taxesAuditTime");
			return (Criteria) this;
		}

		public Criteria andTaxesAuditTimeNotIn(List<Date> values) {
			addCriterion("TAXES_AUDIT_TIME not in", values, "taxesAuditTime");
			return (Criteria) this;
		}

		public Criteria andTaxesAuditTimeBetween(Date value1, Date value2) {
			addCriterion("TAXES_AUDIT_TIME between", value1, value2, "taxesAuditTime");
			return (Criteria) this;
		}

		public Criteria andTaxesAuditTimeNotBetween(Date value1, Date value2) {
			addCriterion("TAXES_AUDIT_TIME not between", value1, value2, "taxesAuditTime");
			return (Criteria) this;
		}

		public Criteria andDealAuditorIsNull() {
			addCriterion("DEAL_AUDITOR is null");
			return (Criteria) this;
		}

		public Criteria andDealAuditorIsNotNull() {
			addCriterion("DEAL_AUDITOR is not null");
			return (Criteria) this;
		}

		public Criteria andDealAuditorEqualTo(String value) {
			addCriterion("DEAL_AUDITOR =", value, "dealAuditor");
			return (Criteria) this;
		}

		public Criteria andDealAuditorNotEqualTo(String value) {
			addCriterion("DEAL_AUDITOR <>", value, "dealAuditor");
			return (Criteria) this;
		}

		public Criteria andDealAuditorGreaterThan(String value) {
			addCriterion("DEAL_AUDITOR >", value, "dealAuditor");
			return (Criteria) this;
		}

		public Criteria andDealAuditorGreaterThanOrEqualTo(String value) {
			addCriterion("DEAL_AUDITOR >=", value, "dealAuditor");
			return (Criteria) this;
		}

		public Criteria andDealAuditorLessThan(String value) {
			addCriterion("DEAL_AUDITOR <", value, "dealAuditor");
			return (Criteria) this;
		}

		public Criteria andDealAuditorLessThanOrEqualTo(String value) {
			addCriterion("DEAL_AUDITOR <=", value, "dealAuditor");
			return (Criteria) this;
		}

		public Criteria andDealAuditorLike(String value) {
			addCriterion("DEAL_AUDITOR like", value, "dealAuditor");
			return (Criteria) this;
		}

		public Criteria andDealAuditorNotLike(String value) {
			addCriterion("DEAL_AUDITOR not like", value, "dealAuditor");
			return (Criteria) this;
		}

		public Criteria andDealAuditorIn(List<String> values) {
			addCriterion("DEAL_AUDITOR in", values, "dealAuditor");
			return (Criteria) this;
		}

		public Criteria andDealAuditorNotIn(List<String> values) {
			addCriterion("DEAL_AUDITOR not in", values, "dealAuditor");
			return (Criteria) this;
		}

		public Criteria andDealAuditorBetween(String value1, String value2) {
			addCriterion("DEAL_AUDITOR between", value1, value2, "dealAuditor");
			return (Criteria) this;
		}

		public Criteria andDealAuditorNotBetween(String value1, String value2) {
			addCriterion("DEAL_AUDITOR not between", value1, value2, "dealAuditor");
			return (Criteria) this;
		}

		public Criteria andYouAduitOpinionIsNull() {
			addCriterion("YOU_ADUIT_OPINION is null");
			return (Criteria) this;
		}

		public Criteria andYouAduitOpinionIsNotNull() {
			addCriterion("YOU_ADUIT_OPINION is not null");
			return (Criteria) this;
		}

		public Criteria andYouAduitOpinionEqualTo(String value) {
			addCriterion("YOU_ADUIT_OPINION =", value, "youAduitOpinion");
			return (Criteria) this;
		}

		public Criteria andYouAduitOpinionNotEqualTo(String value) {
			addCriterion("YOU_ADUIT_OPINION <>", value, "youAduitOpinion");
			return (Criteria) this;
		}

		public Criteria andYouAduitOpinionGreaterThan(String value) {
			addCriterion("YOU_ADUIT_OPINION >", value, "youAduitOpinion");
			return (Criteria) this;
		}

		public Criteria andYouAduitOpinionGreaterThanOrEqualTo(String value) {
			addCriterion("YOU_ADUIT_OPINION >=", value, "youAduitOpinion");
			return (Criteria) this;
		}

		public Criteria andYouAduitOpinionLessThan(String value) {
			addCriterion("YOU_ADUIT_OPINION <", value, "youAduitOpinion");
			return (Criteria) this;
		}

		public Criteria andYouAduitOpinionLessThanOrEqualTo(String value) {
			addCriterion("YOU_ADUIT_OPINION <=", value, "youAduitOpinion");
			return (Criteria) this;
		}

		public Criteria andYouAduitOpinionLike(String value) {
			addCriterion("YOU_ADUIT_OPINION like", value, "youAduitOpinion");
			return (Criteria) this;
		}

		public Criteria andYouAduitOpinionNotLike(String value) {
			addCriterion("YOU_ADUIT_OPINION not like", value, "youAduitOpinion");
			return (Criteria) this;
		}

		public Criteria andYouAduitOpinionIn(List<String> values) {
			addCriterion("YOU_ADUIT_OPINION in", values, "youAduitOpinion");
			return (Criteria) this;
		}

		public Criteria andYouAduitOpinionNotIn(List<String> values) {
			addCriterion("YOU_ADUIT_OPINION not in", values, "youAduitOpinion");
			return (Criteria) this;
		}

		public Criteria andYouAduitOpinionBetween(String value1, String value2) {
			addCriterion("YOU_ADUIT_OPINION between", value1, value2, "youAduitOpinion");
			return (Criteria) this;
		}

		public Criteria andYouAduitOpinionNotBetween(String value1, String value2) {
			addCriterion("YOU_ADUIT_OPINION not between", value1, value2, "youAduitOpinion");
			return (Criteria) this;
		}

		public Criteria andYouDealFlagIsNull() {
			addCriterion("YOU_DEAL_FLAG is null");
			return (Criteria) this;
		}

		public Criteria andYouDealFlagIsNotNull() {
			addCriterion("YOU_DEAL_FLAG is not null");
			return (Criteria) this;
		}

		public Criteria andYouDealFlagEqualTo(Byte value) {
			addCriterion("YOU_DEAL_FLAG =", value, "youDealFlag");
			return (Criteria) this;
		}

		public Criteria andYouDealFlagNotEqualTo(Byte value) {
			addCriterion("YOU_DEAL_FLAG <>", value, "youDealFlag");
			return (Criteria) this;
		}

		public Criteria andYouDealFlagGreaterThan(Byte value) {
			addCriterion("YOU_DEAL_FLAG >", value, "youDealFlag");
			return (Criteria) this;
		}

		public Criteria andYouDealFlagGreaterThanOrEqualTo(Byte value) {
			addCriterion("YOU_DEAL_FLAG >=", value, "youDealFlag");
			return (Criteria) this;
		}

		public Criteria andYouDealFlagLessThan(Byte value) {
			addCriterion("YOU_DEAL_FLAG <", value, "youDealFlag");
			return (Criteria) this;
		}

		public Criteria andYouDealFlagLessThanOrEqualTo(Byte value) {
			addCriterion("YOU_DEAL_FLAG <=", value, "youDealFlag");
			return (Criteria) this;
		}

		public Criteria andYouDealFlagIn(List<Byte> values) {
			addCriterion("YOU_DEAL_FLAG in", values, "youDealFlag");
			return (Criteria) this;
		}

		public Criteria andYouDealFlagNotIn(List<Byte> values) {
			addCriterion("YOU_DEAL_FLAG not in", values, "youDealFlag");
			return (Criteria) this;
		}

		public Criteria andYouDealFlagBetween(Byte value1, Byte value2) {
			addCriterion("YOU_DEAL_FLAG between", value1, value2, "youDealFlag");
			return (Criteria) this;
		}

		public Criteria andYouDealFlagNotBetween(Byte value1, Byte value2) {
			addCriterion("YOU_DEAL_FLAG not between", value1, value2, "youDealFlag");
			return (Criteria) this;
		}

		public Criteria andSubAduitTimeIsNull() {
			addCriterion("SUB_ADUIT_TIME is null");
			return (Criteria) this;
		}

		public Criteria andSubAduitTimeIsNotNull() {
			addCriterion("SUB_ADUIT_TIME is not null");
			return (Criteria) this;
		}

		public Criteria andSubAduitTimeEqualTo(Date value) {
			addCriterion("SUB_ADUIT_TIME =", value, "subAduitTime");
			return (Criteria) this;
		}

		public Criteria andSubAduitTimeNotEqualTo(Date value) {
			addCriterion("SUB_ADUIT_TIME <>", value, "subAduitTime");
			return (Criteria) this;
		}

		public Criteria andSubAduitTimeGreaterThan(Date value) {
			addCriterion("SUB_ADUIT_TIME >", value, "subAduitTime");
			return (Criteria) this;
		}

		public Criteria andSubAduitTimeGreaterThanOrEqualTo(Date value) {
			addCriterion("SUB_ADUIT_TIME >=", value, "subAduitTime");
			return (Criteria) this;
		}

		public Criteria andSubAduitTimeLessThan(Date value) {
			addCriterion("SUB_ADUIT_TIME <", value, "subAduitTime");
			return (Criteria) this;
		}

		public Criteria andSubAduitTimeLessThanOrEqualTo(Date value) {
			addCriterion("SUB_ADUIT_TIME <=", value, "subAduitTime");
			return (Criteria) this;
		}

		public Criteria andSubAduitTimeIn(List<Date> values) {
			addCriterion("SUB_ADUIT_TIME in", values, "subAduitTime");
			return (Criteria) this;
		}

		public Criteria andSubAduitTimeNotIn(List<Date> values) {
			addCriterion("SUB_ADUIT_TIME not in", values, "subAduitTime");
			return (Criteria) this;
		}

		public Criteria andSubAduitTimeBetween(Date value1, Date value2) {
			addCriterion("SUB_ADUIT_TIME between", value1, value2, "subAduitTime");
			return (Criteria) this;
		}

		public Criteria andSubAduitTimeNotBetween(Date value1, Date value2) {
			addCriterion("SUB_ADUIT_TIME not between", value1, value2, "subAduitTime");
			return (Criteria) this;
		}

		public Criteria andYoujiaDealIsNull() {
			addCriterion("YOUJIA_DEAL is null");
			return (Criteria) this;
		}

		public Criteria andYoujiaDealIsNotNull() {
			addCriterion("YOUJIA_DEAL is not null");
			return (Criteria) this;
		}

		public Criteria andYoujiaDealEqualTo(Byte value) {
			addCriterion("YOUJIA_DEAL =", value, "youjiaDeal");
			return (Criteria) this;
		}

		public Criteria andYoujiaDealNotEqualTo(Byte value) {
			addCriterion("YOUJIA_DEAL <>", value, "youjiaDeal");
			return (Criteria) this;
		}

		public Criteria andYoujiaDealGreaterThan(Byte value) {
			addCriterion("YOUJIA_DEAL >", value, "youjiaDeal");
			return (Criteria) this;
		}

		public Criteria andYoujiaDealGreaterThanOrEqualTo(Byte value) {
			addCriterion("YOUJIA_DEAL >=", value, "youjiaDeal");
			return (Criteria) this;
		}

		public Criteria andYoujiaDealLessThan(Byte value) {
			addCriterion("YOUJIA_DEAL <", value, "youjiaDeal");
			return (Criteria) this;
		}

		public Criteria andYoujiaDealLessThanOrEqualTo(Byte value) {
			addCriterion("YOUJIA_DEAL <=", value, "youjiaDeal");
			return (Criteria) this;
		}

		public Criteria andYoujiaDealIn(List<Byte> values) {
			addCriterion("YOUJIA_DEAL in", values, "youjiaDeal");
			return (Criteria) this;
		}

		public Criteria andYoujiaDealNotIn(List<Byte> values) {
			addCriterion("YOUJIA_DEAL not in", values, "youjiaDeal");
			return (Criteria) this;
		}

		public Criteria andYoujiaDealBetween(Byte value1, Byte value2) {
			addCriterion("YOUJIA_DEAL between", value1, value2, "youjiaDeal");
			return (Criteria) this;
		}

		public Criteria andYoujiaDealNotBetween(Byte value1, Byte value2) {
			addCriterion("YOUJIA_DEAL not between", value1, value2, "youjiaDeal");
			return (Criteria) this;
		}

		public Criteria andBuildRegNameIsNull() {
			addCriterion("BUILD_REG_NAME is null");
			return (Criteria) this;
		}

		public Criteria andBuildRegNameIsNotNull() {
			addCriterion("BUILD_REG_NAME is not null");
			return (Criteria) this;
		}

		public Criteria andBuildRegNameEqualTo(String value) {
			addCriterion("BUILD_REG_NAME =", value, "buildRegName");
			return (Criteria) this;
		}

		public Criteria andBuildRegNameNotEqualTo(String value) {
			addCriterion("BUILD_REG_NAME <>", value, "buildRegName");
			return (Criteria) this;
		}

		public Criteria andBuildRegNameGreaterThan(String value) {
			addCriterion("BUILD_REG_NAME >", value, "buildRegName");
			return (Criteria) this;
		}

		public Criteria andBuildRegNameGreaterThanOrEqualTo(String value) {
			addCriterion("BUILD_REG_NAME >=", value, "buildRegName");
			return (Criteria) this;
		}

		public Criteria andBuildRegNameLessThan(String value) {
			addCriterion("BUILD_REG_NAME <", value, "buildRegName");
			return (Criteria) this;
		}

		public Criteria andBuildRegNameLessThanOrEqualTo(String value) {
			addCriterion("BUILD_REG_NAME <=", value, "buildRegName");
			return (Criteria) this;
		}

		public Criteria andBuildRegNameLike(String value) {
			addCriterion("BUILD_REG_NAME like", value, "buildRegName");
			return (Criteria) this;
		}

		public Criteria andBuildRegNameNotLike(String value) {
			addCriterion("BUILD_REG_NAME not like", value, "buildRegName");
			return (Criteria) this;
		}

		public Criteria andBuildRegNameIn(List<String> values) {
			addCriterion("BUILD_REG_NAME in", values, "buildRegName");
			return (Criteria) this;
		}

		public Criteria andBuildRegNameNotIn(List<String> values) {
			addCriterion("BUILD_REG_NAME not in", values, "buildRegName");
			return (Criteria) this;
		}

		public Criteria andBuildRegNameBetween(String value1, String value2) {
			addCriterion("BUILD_REG_NAME between", value1, value2, "buildRegName");
			return (Criteria) this;
		}

		public Criteria andBuildRegNameNotBetween(String value1, String value2) {
			addCriterion("BUILD_REG_NAME not between", value1, value2, "buildRegName");
			return (Criteria) this;
		}

		public Criteria andBuildRegIdIsNull() {
			addCriterion("BUILD_REG_ID is null");
			return (Criteria) this;
		}

		public Criteria andBuildRegIdIsNotNull() {
			addCriterion("BUILD_REG_ID is not null");
			return (Criteria) this;
		}

		public Criteria andBuildRegIdEqualTo(Integer value) {
			addCriterion("BUILD_REG_ID =", value, "buildRegId");
			return (Criteria) this;
		}

		public Criteria andBuildRegIdNotEqualTo(Integer value) {
			addCriterion("BUILD_REG_ID <>", value, "buildRegId");
			return (Criteria) this;
		}

		public Criteria andBuildRegIdGreaterThan(Integer value) {
			addCriterion("BUILD_REG_ID >", value, "buildRegId");
			return (Criteria) this;
		}

		public Criteria andBuildRegIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("BUILD_REG_ID >=", value, "buildRegId");
			return (Criteria) this;
		}

		public Criteria andBuildRegIdLessThan(Integer value) {
			addCriterion("BUILD_REG_ID <", value, "buildRegId");
			return (Criteria) this;
		}

		public Criteria andBuildRegIdLessThanOrEqualTo(Integer value) {
			addCriterion("BUILD_REG_ID <=", value, "buildRegId");
			return (Criteria) this;
		}

		public Criteria andBuildRegIdIn(List<Integer> values) {
			addCriterion("BUILD_REG_ID in", values, "buildRegId");
			return (Criteria) this;
		}

		public Criteria andBuildRegIdNotIn(List<Integer> values) {
			addCriterion("BUILD_REG_ID not in", values, "buildRegId");
			return (Criteria) this;
		}

		public Criteria andBuildRegIdBetween(Integer value1, Integer value2) {
			addCriterion("BUILD_REG_ID between", value1, value2, "buildRegId");
			return (Criteria) this;
		}

		public Criteria andBuildRegIdNotBetween(Integer value1, Integer value2) {
			addCriterion("BUILD_REG_ID not between", value1, value2, "buildRegId");
			return (Criteria) this;
		}

		public Criteria andProcessEndTimeIsNull() {
			addCriterion("PROCESS_END_TIME is null");
			return (Criteria) this;
		}

		public Criteria andProcessEndTimeIsNotNull() {
			addCriterion("PROCESS_END_TIME is not null");
			return (Criteria) this;
		}

		public Criteria andProcessEndTimeEqualTo(Date value) {
			addCriterion("PROCESS_END_TIME =", value, "processEndTime");
			return (Criteria) this;
		}

		public Criteria andProcessEndTimeNotEqualTo(Date value) {
			addCriterion("PROCESS_END_TIME <>", value, "processEndTime");
			return (Criteria) this;
		}

		public Criteria andProcessEndTimeGreaterThan(Date value) {
			addCriterion("PROCESS_END_TIME >", value, "processEndTime");
			return (Criteria) this;
		}

		public Criteria andProcessEndTimeGreaterThanOrEqualTo(Date value) {
			addCriterion("PROCESS_END_TIME >=", value, "processEndTime");
			return (Criteria) this;
		}

		public Criteria andProcessEndTimeLessThan(Date value) {
			addCriterion("PROCESS_END_TIME <", value, "processEndTime");
			return (Criteria) this;
		}

		public Criteria andProcessEndTimeLessThanOrEqualTo(Date value) {
			addCriterion("PROCESS_END_TIME <=", value, "processEndTime");
			return (Criteria) this;
		}

		public Criteria andProcessEndTimeIn(List<Date> values) {
			addCriterion("PROCESS_END_TIME in", values, "processEndTime");
			return (Criteria) this;
		}

		public Criteria andProcessEndTimeNotIn(List<Date> values) {
			addCriterion("PROCESS_END_TIME not in", values, "processEndTime");
			return (Criteria) this;
		}

		public Criteria andProcessEndTimeBetween(Date value1, Date value2) {
			addCriterion("PROCESS_END_TIME between", value1, value2, "processEndTime");
			return (Criteria) this;
		}

		public Criteria andProcessEndTimeNotBetween(Date value1, Date value2) {
			addCriterion("PROCESS_END_TIME not between", value1, value2, "processEndTime");
			return (Criteria) this;
		}

		public Criteria andYouAduitStatusProtocolIsNull() {
			addCriterion("YOU_ADUIT_STATUS_PROTOCOL is null");
			return (Criteria) this;
		}

		public Criteria andYouAduitStatusProtocolIsNotNull() {
			addCriterion("YOU_ADUIT_STATUS_PROTOCOL is not null");
			return (Criteria) this;
		}

		public Criteria andYouAduitStatusProtocolEqualTo(Byte value) {
			addCriterion("YOU_ADUIT_STATUS_PROTOCOL =", value, "youAduitStatusProtocol");
			return (Criteria) this;
		}

		public Criteria andYouAduitStatusProtocolNotEqualTo(Byte value) {
			addCriterion("YOU_ADUIT_STATUS_PROTOCOL <>", value, "youAduitStatusProtocol");
			return (Criteria) this;
		}

		public Criteria andYouAduitStatusProtocolGreaterThan(Byte value) {
			addCriterion("YOU_ADUIT_STATUS_PROTOCOL >", value, "youAduitStatusProtocol");
			return (Criteria) this;
		}

		public Criteria andYouAduitStatusProtocolGreaterThanOrEqualTo(Byte value) {
			addCriterion("YOU_ADUIT_STATUS_PROTOCOL >=", value, "youAduitStatusProtocol");
			return (Criteria) this;
		}

		public Criteria andYouAduitStatusProtocolLessThan(Byte value) {
			addCriterion("YOU_ADUIT_STATUS_PROTOCOL <", value, "youAduitStatusProtocol");
			return (Criteria) this;
		}

		public Criteria andYouAduitStatusProtocolLessThanOrEqualTo(Byte value) {
			addCriterion("YOU_ADUIT_STATUS_PROTOCOL <=", value, "youAduitStatusProtocol");
			return (Criteria) this;
		}

		public Criteria andYouAduitStatusProtocolIn(List<Byte> values) {
			addCriterion("YOU_ADUIT_STATUS_PROTOCOL in", values, "youAduitStatusProtocol");
			return (Criteria) this;
		}

		public Criteria andYouAduitStatusProtocolNotIn(List<Byte> values) {
			addCriterion("YOU_ADUIT_STATUS_PROTOCOL not in", values, "youAduitStatusProtocol");
			return (Criteria) this;
		}

		public Criteria andYouAduitStatusProtocolBetween(Byte value1, Byte value2) {
			addCriterion("YOU_ADUIT_STATUS_PROTOCOL between", value1, value2, "youAduitStatusProtocol");
			return (Criteria) this;
		}

		public Criteria andYouAduitStatusProtocolNotBetween(Byte value1, Byte value2) {
			addCriterion("YOU_ADUIT_STATUS_PROTOCOL not between", value1, value2, "youAduitStatusProtocol");
			return (Criteria) this;
		}

		public Criteria andProtocolIdIsNull() {
			addCriterion("PROTOCOL_ID is null");
			return (Criteria) this;
		}

		public Criteria andProtocolIdIsNotNull() {
			addCriterion("PROTOCOL_ID is not null");
			return (Criteria) this;
		}

		public Criteria andProtocolIdEqualTo(Integer value) {
			addCriterion("PROTOCOL_ID =", value, "protocolId");
			return (Criteria) this;
		}

		public Criteria andProtocolIdNotEqualTo(Integer value) {
			addCriterion("PROTOCOL_ID <>", value, "protocolId");
			return (Criteria) this;
		}

		public Criteria andProtocolIdGreaterThan(Integer value) {
			addCriterion("PROTOCOL_ID >", value, "protocolId");
			return (Criteria) this;
		}

		public Criteria andProtocolIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("PROTOCOL_ID >=", value, "protocolId");
			return (Criteria) this;
		}

		public Criteria andProtocolIdLessThan(Integer value) {
			addCriterion("PROTOCOL_ID <", value, "protocolId");
			return (Criteria) this;
		}

		public Criteria andProtocolIdLessThanOrEqualTo(Integer value) {
			addCriterion("PROTOCOL_ID <=", value, "protocolId");
			return (Criteria) this;
		}

		public Criteria andProtocolIdIn(List<Integer> values) {
			addCriterion("PROTOCOL_ID in", values, "protocolId");
			return (Criteria) this;
		}

		public Criteria andProtocolIdNotIn(List<Integer> values) {
			addCriterion("PROTOCOL_ID not in", values, "protocolId");
			return (Criteria) this;
		}

		public Criteria andProtocolIdBetween(Integer value1, Integer value2) {
			addCriterion("PROTOCOL_ID between", value1, value2, "protocolId");
			return (Criteria) this;
		}

		public Criteria andProtocolIdNotBetween(Integer value1, Integer value2) {
			addCriterion("PROTOCOL_ID not between", value1, value2, "protocolId");
			return (Criteria) this;
		}

		public Criteria andTransferNeedPerformanceIsNull() {
			addCriterion("TRANSFER_NEED_PERFORMANCE is null");
			return (Criteria) this;
		}

		public Criteria andTransferNeedPerformanceIsNotNull() {
			addCriterion("TRANSFER_NEED_PERFORMANCE is not null");
			return (Criteria) this;
		}

		public Criteria andTransferNeedPerformanceEqualTo(BigDecimal value) {
			addCriterion("TRANSFER_NEED_PERFORMANCE =", value, "transferNeedPerformance");
			return (Criteria) this;
		}

		public Criteria andTransferNeedPerformanceNotEqualTo(BigDecimal value) {
			addCriterion("TRANSFER_NEED_PERFORMANCE <>", value, "transferNeedPerformance");
			return (Criteria) this;
		}

		public Criteria andTransferNeedPerformanceGreaterThan(BigDecimal value) {
			addCriterion("TRANSFER_NEED_PERFORMANCE >", value, "transferNeedPerformance");
			return (Criteria) this;
		}

		public Criteria andTransferNeedPerformanceGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("TRANSFER_NEED_PERFORMANCE >=", value, "transferNeedPerformance");
			return (Criteria) this;
		}

		public Criteria andTransferNeedPerformanceLessThan(BigDecimal value) {
			addCriterion("TRANSFER_NEED_PERFORMANCE <", value, "transferNeedPerformance");
			return (Criteria) this;
		}

		public Criteria andTransferNeedPerformanceLessThanOrEqualTo(BigDecimal value) {
			addCriterion("TRANSFER_NEED_PERFORMANCE <=", value, "transferNeedPerformance");
			return (Criteria) this;
		}

		public Criteria andTransferNeedPerformanceIn(List<BigDecimal> values) {
			addCriterion("TRANSFER_NEED_PERFORMANCE in", values, "transferNeedPerformance");
			return (Criteria) this;
		}

		public Criteria andTransferNeedPerformanceNotIn(List<BigDecimal> values) {
			addCriterion("TRANSFER_NEED_PERFORMANCE not in", values, "transferNeedPerformance");
			return (Criteria) this;
		}

		public Criteria andTransferNeedPerformanceBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("TRANSFER_NEED_PERFORMANCE between", value1, value2, "transferNeedPerformance");
			return (Criteria) this;
		}

		public Criteria andTransferNeedPerformanceNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("TRANSFER_NEED_PERFORMANCE not between", value1, value2, "transferNeedPerformance");
			return (Criteria) this;
		}

		public Criteria andTransferRealPerformanceIsNull() {
			addCriterion("TRANSFER_REAL_PERFORMANCE is null");
			return (Criteria) this;
		}

		public Criteria andTransferRealPerformanceIsNotNull() {
			addCriterion("TRANSFER_REAL_PERFORMANCE is not null");
			return (Criteria) this;
		}

		public Criteria andTransferRealPerformanceEqualTo(BigDecimal value) {
			addCriterion("TRANSFER_REAL_PERFORMANCE =", value, "transferRealPerformance");
			return (Criteria) this;
		}

		public Criteria andTransferRealPerformanceNotEqualTo(BigDecimal value) {
			addCriterion("TRANSFER_REAL_PERFORMANCE <>", value, "transferRealPerformance");
			return (Criteria) this;
		}

		public Criteria andTransferRealPerformanceGreaterThan(BigDecimal value) {
			addCriterion("TRANSFER_REAL_PERFORMANCE >", value, "transferRealPerformance");
			return (Criteria) this;
		}

		public Criteria andTransferRealPerformanceGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("TRANSFER_REAL_PERFORMANCE >=", value, "transferRealPerformance");
			return (Criteria) this;
		}

		public Criteria andTransferRealPerformanceLessThan(BigDecimal value) {
			addCriterion("TRANSFER_REAL_PERFORMANCE <", value, "transferRealPerformance");
			return (Criteria) this;
		}

		public Criteria andTransferRealPerformanceLessThanOrEqualTo(BigDecimal value) {
			addCriterion("TRANSFER_REAL_PERFORMANCE <=", value, "transferRealPerformance");
			return (Criteria) this;
		}

		public Criteria andTransferRealPerformanceIn(List<BigDecimal> values) {
			addCriterion("TRANSFER_REAL_PERFORMANCE in", values, "transferRealPerformance");
			return (Criteria) this;
		}

		public Criteria andTransferRealPerformanceNotIn(List<BigDecimal> values) {
			addCriterion("TRANSFER_REAL_PERFORMANCE not in", values, "transferRealPerformance");
			return (Criteria) this;
		}

		public Criteria andTransferRealPerformanceBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("TRANSFER_REAL_PERFORMANCE between", value1, value2, "transferRealPerformance");
			return (Criteria) this;
		}

		public Criteria andTransferRealPerformanceNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("TRANSFER_REAL_PERFORMANCE not between", value1, value2, "transferRealPerformance");
			return (Criteria) this;
		}

		public Criteria andSecondhandNeedPerformanceIsNull() {
			addCriterion("SECONDHAND_NEED_PERFORMANCE is null");
			return (Criteria) this;
		}

		public Criteria andSecondhandNeedPerformanceIsNotNull() {
			addCriterion("SECONDHAND_NEED_PERFORMANCE is not null");
			return (Criteria) this;
		}

		public Criteria andSecondhandNeedPerformanceEqualTo(BigDecimal value) {
			addCriterion("SECONDHAND_NEED_PERFORMANCE =", value, "secondhandNeedPerformance");
			return (Criteria) this;
		}

		public Criteria andSecondhandNeedPerformanceNotEqualTo(BigDecimal value) {
			addCriterion("SECONDHAND_NEED_PERFORMANCE <>", value, "secondhandNeedPerformance");
			return (Criteria) this;
		}

		public Criteria andSecondhandNeedPerformanceGreaterThan(BigDecimal value) {
			addCriterion("SECONDHAND_NEED_PERFORMANCE >", value, "secondhandNeedPerformance");
			return (Criteria) this;
		}

		public Criteria andSecondhandNeedPerformanceGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("SECONDHAND_NEED_PERFORMANCE >=", value, "secondhandNeedPerformance");
			return (Criteria) this;
		}

		public Criteria andSecondhandNeedPerformanceLessThan(BigDecimal value) {
			addCriterion("SECONDHAND_NEED_PERFORMANCE <", value, "secondhandNeedPerformance");
			return (Criteria) this;
		}

		public Criteria andSecondhandNeedPerformanceLessThanOrEqualTo(BigDecimal value) {
			addCriterion("SECONDHAND_NEED_PERFORMANCE <=", value, "secondhandNeedPerformance");
			return (Criteria) this;
		}

		public Criteria andSecondhandNeedPerformanceIn(List<BigDecimal> values) {
			addCriterion("SECONDHAND_NEED_PERFORMANCE in", values, "secondhandNeedPerformance");
			return (Criteria) this;
		}

		public Criteria andSecondhandNeedPerformanceNotIn(List<BigDecimal> values) {
			addCriterion("SECONDHAND_NEED_PERFORMANCE not in", values, "secondhandNeedPerformance");
			return (Criteria) this;
		}

		public Criteria andSecondhandNeedPerformanceBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("SECONDHAND_NEED_PERFORMANCE between", value1, value2, "secondhandNeedPerformance");
			return (Criteria) this;
		}

		public Criteria andSecondhandNeedPerformanceNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("SECONDHAND_NEED_PERFORMANCE not between", value1, value2, "secondhandNeedPerformance");
			return (Criteria) this;
		}

		public Criteria andSecondhandRealPerformanceIsNull() {
			addCriterion("SECONDHAND_REAL_PERFORMANCE is null");
			return (Criteria) this;
		}

		public Criteria andSecondhandRealPerformanceIsNotNull() {
			addCriterion("SECONDHAND_REAL_PERFORMANCE is not null");
			return (Criteria) this;
		}

		public Criteria andSecondhandRealPerformanceEqualTo(BigDecimal value) {
			addCriterion("SECONDHAND_REAL_PERFORMANCE =", value, "secondhandRealPerformance");
			return (Criteria) this;
		}

		public Criteria andSecondhandRealPerformanceNotEqualTo(BigDecimal value) {
			addCriterion("SECONDHAND_REAL_PERFORMANCE <>", value, "secondhandRealPerformance");
			return (Criteria) this;
		}

		public Criteria andSecondhandRealPerformanceGreaterThan(BigDecimal value) {
			addCriterion("SECONDHAND_REAL_PERFORMANCE >", value, "secondhandRealPerformance");
			return (Criteria) this;
		}

		public Criteria andSecondhandRealPerformanceGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("SECONDHAND_REAL_PERFORMANCE >=", value, "secondhandRealPerformance");
			return (Criteria) this;
		}

		public Criteria andSecondhandRealPerformanceLessThan(BigDecimal value) {
			addCriterion("SECONDHAND_REAL_PERFORMANCE <", value, "secondhandRealPerformance");
			return (Criteria) this;
		}

		public Criteria andSecondhandRealPerformanceLessThanOrEqualTo(BigDecimal value) {
			addCriterion("SECONDHAND_REAL_PERFORMANCE <=", value, "secondhandRealPerformance");
			return (Criteria) this;
		}

		public Criteria andSecondhandRealPerformanceIn(List<BigDecimal> values) {
			addCriterion("SECONDHAND_REAL_PERFORMANCE in", values, "secondhandRealPerformance");
			return (Criteria) this;
		}

		public Criteria andSecondhandRealPerformanceNotIn(List<BigDecimal> values) {
			addCriterion("SECONDHAND_REAL_PERFORMANCE not in", values, "secondhandRealPerformance");
			return (Criteria) this;
		}

		public Criteria andSecondhandRealPerformanceBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("SECONDHAND_REAL_PERFORMANCE between", value1, value2, "secondhandRealPerformance");
			return (Criteria) this;
		}

		public Criteria andSecondhandRealPerformanceNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("SECONDHAND_REAL_PERFORMANCE not between", value1, value2, "secondhandRealPerformance");
			return (Criteria) this;
		}

		public Criteria andNewhouseNeedPerformanceIsNull() {
			addCriterion("NEWHOUSE_NEED_PERFORMANCE is null");
			return (Criteria) this;
		}

		public Criteria andNewhouseNeedPerformanceIsNotNull() {
			addCriterion("NEWHOUSE_NEED_PERFORMANCE is not null");
			return (Criteria) this;
		}

		public Criteria andNewhouseNeedPerformanceEqualTo(BigDecimal value) {
			addCriterion("NEWHOUSE_NEED_PERFORMANCE =", value, "newhouseNeedPerformance");
			return (Criteria) this;
		}

		public Criteria andNewhouseNeedPerformanceNotEqualTo(BigDecimal value) {
			addCriterion("NEWHOUSE_NEED_PERFORMANCE <>", value, "newhouseNeedPerformance");
			return (Criteria) this;
		}

		public Criteria andNewhouseNeedPerformanceGreaterThan(BigDecimal value) {
			addCriterion("NEWHOUSE_NEED_PERFORMANCE >", value, "newhouseNeedPerformance");
			return (Criteria) this;
		}

		public Criteria andNewhouseNeedPerformanceGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("NEWHOUSE_NEED_PERFORMANCE >=", value, "newhouseNeedPerformance");
			return (Criteria) this;
		}

		public Criteria andNewhouseNeedPerformanceLessThan(BigDecimal value) {
			addCriterion("NEWHOUSE_NEED_PERFORMANCE <", value, "newhouseNeedPerformance");
			return (Criteria) this;
		}

		public Criteria andNewhouseNeedPerformanceLessThanOrEqualTo(BigDecimal value) {
			addCriterion("NEWHOUSE_NEED_PERFORMANCE <=", value, "newhouseNeedPerformance");
			return (Criteria) this;
		}

		public Criteria andNewhouseNeedPerformanceIn(List<BigDecimal> values) {
			addCriterion("NEWHOUSE_NEED_PERFORMANCE in", values, "newhouseNeedPerformance");
			return (Criteria) this;
		}

		public Criteria andNewhouseNeedPerformanceNotIn(List<BigDecimal> values) {
			addCriterion("NEWHOUSE_NEED_PERFORMANCE not in", values, "newhouseNeedPerformance");
			return (Criteria) this;
		}

		public Criteria andNewhouseNeedPerformanceBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("NEWHOUSE_NEED_PERFORMANCE between", value1, value2, "newhouseNeedPerformance");
			return (Criteria) this;
		}

		public Criteria andNewhouseNeedPerformanceNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("NEWHOUSE_NEED_PERFORMANCE not between", value1, value2, "newhouseNeedPerformance");
			return (Criteria) this;
		}

		public Criteria andNewhouseRealPerformanceIsNull() {
			addCriterion("NEWHOUSE_REAL_PERFORMANCE is null");
			return (Criteria) this;
		}

		public Criteria andNewhouseRealPerformanceIsNotNull() {
			addCriterion("NEWHOUSE_REAL_PERFORMANCE is not null");
			return (Criteria) this;
		}

		public Criteria andNewhouseRealPerformanceEqualTo(BigDecimal value) {
			addCriterion("NEWHOUSE_REAL_PERFORMANCE =", value, "newhouseRealPerformance");
			return (Criteria) this;
		}

		public Criteria andNewhouseRealPerformanceNotEqualTo(BigDecimal value) {
			addCriterion("NEWHOUSE_REAL_PERFORMANCE <>", value, "newhouseRealPerformance");
			return (Criteria) this;
		}

		public Criteria andNewhouseRealPerformanceGreaterThan(BigDecimal value) {
			addCriterion("NEWHOUSE_REAL_PERFORMANCE >", value, "newhouseRealPerformance");
			return (Criteria) this;
		}

		public Criteria andNewhouseRealPerformanceGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("NEWHOUSE_REAL_PERFORMANCE >=", value, "newhouseRealPerformance");
			return (Criteria) this;
		}

		public Criteria andNewhouseRealPerformanceLessThan(BigDecimal value) {
			addCriterion("NEWHOUSE_REAL_PERFORMANCE <", value, "newhouseRealPerformance");
			return (Criteria) this;
		}

		public Criteria andNewhouseRealPerformanceLessThanOrEqualTo(BigDecimal value) {
			addCriterion("NEWHOUSE_REAL_PERFORMANCE <=", value, "newhouseRealPerformance");
			return (Criteria) this;
		}

		public Criteria andNewhouseRealPerformanceIn(List<BigDecimal> values) {
			addCriterion("NEWHOUSE_REAL_PERFORMANCE in", values, "newhouseRealPerformance");
			return (Criteria) this;
		}

		public Criteria andNewhouseRealPerformanceNotIn(List<BigDecimal> values) {
			addCriterion("NEWHOUSE_REAL_PERFORMANCE not in", values, "newhouseRealPerformance");
			return (Criteria) this;
		}

		public Criteria andNewhouseRealPerformanceBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("NEWHOUSE_REAL_PERFORMANCE between", value1, value2, "newhouseRealPerformance");
			return (Criteria) this;
		}

		public Criteria andNewhouseRealPerformanceNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("NEWHOUSE_REAL_PERFORMANCE not between", value1, value2, "newhouseRealPerformance");
			return (Criteria) this;
		}

		public Criteria andLeaseNeedPerformanceIsNull() {
			addCriterion("LEASE_NEED_PERFORMANCE is null");
			return (Criteria) this;
		}

		public Criteria andLeaseNeedPerformanceIsNotNull() {
			addCriterion("LEASE_NEED_PERFORMANCE is not null");
			return (Criteria) this;
		}

		public Criteria andLeaseNeedPerformanceEqualTo(BigDecimal value) {
			addCriterion("LEASE_NEED_PERFORMANCE =", value, "leaseNeedPerformance");
			return (Criteria) this;
		}

		public Criteria andLeaseNeedPerformanceNotEqualTo(BigDecimal value) {
			addCriterion("LEASE_NEED_PERFORMANCE <>", value, "leaseNeedPerformance");
			return (Criteria) this;
		}

		public Criteria andLeaseNeedPerformanceGreaterThan(BigDecimal value) {
			addCriterion("LEASE_NEED_PERFORMANCE >", value, "leaseNeedPerformance");
			return (Criteria) this;
		}

		public Criteria andLeaseNeedPerformanceGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("LEASE_NEED_PERFORMANCE >=", value, "leaseNeedPerformance");
			return (Criteria) this;
		}

		public Criteria andLeaseNeedPerformanceLessThan(BigDecimal value) {
			addCriterion("LEASE_NEED_PERFORMANCE <", value, "leaseNeedPerformance");
			return (Criteria) this;
		}

		public Criteria andLeaseNeedPerformanceLessThanOrEqualTo(BigDecimal value) {
			addCriterion("LEASE_NEED_PERFORMANCE <=", value, "leaseNeedPerformance");
			return (Criteria) this;
		}

		public Criteria andLeaseNeedPerformanceIn(List<BigDecimal> values) {
			addCriterion("LEASE_NEED_PERFORMANCE in", values, "leaseNeedPerformance");
			return (Criteria) this;
		}

		public Criteria andLeaseNeedPerformanceNotIn(List<BigDecimal> values) {
			addCriterion("LEASE_NEED_PERFORMANCE not in", values, "leaseNeedPerformance");
			return (Criteria) this;
		}

		public Criteria andLeaseNeedPerformanceBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("LEASE_NEED_PERFORMANCE between", value1, value2, "leaseNeedPerformance");
			return (Criteria) this;
		}

		public Criteria andLeaseNeedPerformanceNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("LEASE_NEED_PERFORMANCE not between", value1, value2, "leaseNeedPerformance");
			return (Criteria) this;
		}

		public Criteria andLeaseRealPerformanceIsNull() {
			addCriterion("LEASE_REAL_PERFORMANCE is null");
			return (Criteria) this;
		}

		public Criteria andLeaseRealPerformanceIsNotNull() {
			addCriterion("LEASE_REAL_PERFORMANCE is not null");
			return (Criteria) this;
		}

		public Criteria andLeaseRealPerformanceEqualTo(BigDecimal value) {
			addCriterion("LEASE_REAL_PERFORMANCE =", value, "leaseRealPerformance");
			return (Criteria) this;
		}

		public Criteria andLeaseRealPerformanceNotEqualTo(BigDecimal value) {
			addCriterion("LEASE_REAL_PERFORMANCE <>", value, "leaseRealPerformance");
			return (Criteria) this;
		}

		public Criteria andLeaseRealPerformanceGreaterThan(BigDecimal value) {
			addCriterion("LEASE_REAL_PERFORMANCE >", value, "leaseRealPerformance");
			return (Criteria) this;
		}

		public Criteria andLeaseRealPerformanceGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("LEASE_REAL_PERFORMANCE >=", value, "leaseRealPerformance");
			return (Criteria) this;
		}

		public Criteria andLeaseRealPerformanceLessThan(BigDecimal value) {
			addCriterion("LEASE_REAL_PERFORMANCE <", value, "leaseRealPerformance");
			return (Criteria) this;
		}

		public Criteria andLeaseRealPerformanceLessThanOrEqualTo(BigDecimal value) {
			addCriterion("LEASE_REAL_PERFORMANCE <=", value, "leaseRealPerformance");
			return (Criteria) this;
		}

		public Criteria andLeaseRealPerformanceIn(List<BigDecimal> values) {
			addCriterion("LEASE_REAL_PERFORMANCE in", values, "leaseRealPerformance");
			return (Criteria) this;
		}

		public Criteria andLeaseRealPerformanceNotIn(List<BigDecimal> values) {
			addCriterion("LEASE_REAL_PERFORMANCE not in", values, "leaseRealPerformance");
			return (Criteria) this;
		}

		public Criteria andLeaseRealPerformanceBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("LEASE_REAL_PERFORMANCE between", value1, value2, "leaseRealPerformance");
			return (Criteria) this;
		}

		public Criteria andLeaseRealPerformanceNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("LEASE_REAL_PERFORMANCE not between", value1, value2, "leaseRealPerformance");
			return (Criteria) this;
		}

		public Criteria andFinanceNeedPerformanceIsNull() {
			addCriterion("FINANCE_NEED_PERFORMANCE is null");
			return (Criteria) this;
		}

		public Criteria andFinanceNeedPerformanceIsNotNull() {
			addCriterion("FINANCE_NEED_PERFORMANCE is not null");
			return (Criteria) this;
		}

		public Criteria andFinanceNeedPerformanceEqualTo(BigDecimal value) {
			addCriterion("FINANCE_NEED_PERFORMANCE =", value, "financeNeedPerformance");
			return (Criteria) this;
		}

		public Criteria andFinanceNeedPerformanceNotEqualTo(BigDecimal value) {
			addCriterion("FINANCE_NEED_PERFORMANCE <>", value, "financeNeedPerformance");
			return (Criteria) this;
		}

		public Criteria andFinanceNeedPerformanceGreaterThan(BigDecimal value) {
			addCriterion("FINANCE_NEED_PERFORMANCE >", value, "financeNeedPerformance");
			return (Criteria) this;
		}

		public Criteria andFinanceNeedPerformanceGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("FINANCE_NEED_PERFORMANCE >=", value, "financeNeedPerformance");
			return (Criteria) this;
		}

		public Criteria andFinanceNeedPerformanceLessThan(BigDecimal value) {
			addCriterion("FINANCE_NEED_PERFORMANCE <", value, "financeNeedPerformance");
			return (Criteria) this;
		}

		public Criteria andFinanceNeedPerformanceLessThanOrEqualTo(BigDecimal value) {
			addCriterion("FINANCE_NEED_PERFORMANCE <=", value, "financeNeedPerformance");
			return (Criteria) this;
		}

		public Criteria andFinanceNeedPerformanceIn(List<BigDecimal> values) {
			addCriterion("FINANCE_NEED_PERFORMANCE in", values, "financeNeedPerformance");
			return (Criteria) this;
		}

		public Criteria andFinanceNeedPerformanceNotIn(List<BigDecimal> values) {
			addCriterion("FINANCE_NEED_PERFORMANCE not in", values, "financeNeedPerformance");
			return (Criteria) this;
		}

		public Criteria andFinanceNeedPerformanceBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("FINANCE_NEED_PERFORMANCE between", value1, value2, "financeNeedPerformance");
			return (Criteria) this;
		}

		public Criteria andFinanceNeedPerformanceNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("FINANCE_NEED_PERFORMANCE not between", value1, value2, "financeNeedPerformance");
			return (Criteria) this;
		}

		public Criteria andFinanceRealPerformanceIsNull() {
			addCriterion("FINANCE_REAL_PERFORMANCE is null");
			return (Criteria) this;
		}

		public Criteria andFinanceRealPerformanceIsNotNull() {
			addCriterion("FINANCE_REAL_PERFORMANCE is not null");
			return (Criteria) this;
		}

		public Criteria andFinanceRealPerformanceEqualTo(BigDecimal value) {
			addCriterion("FINANCE_REAL_PERFORMANCE =", value, "financeRealPerformance");
			return (Criteria) this;
		}

		public Criteria andFinanceRealPerformanceNotEqualTo(BigDecimal value) {
			addCriterion("FINANCE_REAL_PERFORMANCE <>", value, "financeRealPerformance");
			return (Criteria) this;
		}

		public Criteria andFinanceRealPerformanceGreaterThan(BigDecimal value) {
			addCriterion("FINANCE_REAL_PERFORMANCE >", value, "financeRealPerformance");
			return (Criteria) this;
		}

		public Criteria andFinanceRealPerformanceGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("FINANCE_REAL_PERFORMANCE >=", value, "financeRealPerformance");
			return (Criteria) this;
		}

		public Criteria andFinanceRealPerformanceLessThan(BigDecimal value) {
			addCriterion("FINANCE_REAL_PERFORMANCE <", value, "financeRealPerformance");
			return (Criteria) this;
		}

		public Criteria andFinanceRealPerformanceLessThanOrEqualTo(BigDecimal value) {
			addCriterion("FINANCE_REAL_PERFORMANCE <=", value, "financeRealPerformance");
			return (Criteria) this;
		}

		public Criteria andFinanceRealPerformanceIn(List<BigDecimal> values) {
			addCriterion("FINANCE_REAL_PERFORMANCE in", values, "financeRealPerformance");
			return (Criteria) this;
		}

		public Criteria andFinanceRealPerformanceNotIn(List<BigDecimal> values) {
			addCriterion("FINANCE_REAL_PERFORMANCE not in", values, "financeRealPerformance");
			return (Criteria) this;
		}

		public Criteria andFinanceRealPerformanceBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("FINANCE_REAL_PERFORMANCE between", value1, value2, "financeRealPerformance");
			return (Criteria) this;
		}

		public Criteria andFinanceRealPerformanceNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("FINANCE_REAL_PERFORMANCE not between", value1, value2, "financeRealPerformance");
			return (Criteria) this;
		}

		public Criteria andCommissionRateIsNull() {
			addCriterion("COMMISSION_RATE is null");
			return (Criteria) this;
		}

		public Criteria andCommissionRateIsNotNull() {
			addCriterion("COMMISSION_RATE is not null");
			return (Criteria) this;
		}

		public Criteria andCommissionRateEqualTo(BigDecimal value) {
			addCriterion("COMMISSION_RATE =", value, "commissionRate");
			return (Criteria) this;
		}

		public Criteria andCommissionRateNotEqualTo(BigDecimal value) {
			addCriterion("COMMISSION_RATE <>", value, "commissionRate");
			return (Criteria) this;
		}

		public Criteria andCommissionRateGreaterThan(BigDecimal value) {
			addCriterion("COMMISSION_RATE >", value, "commissionRate");
			return (Criteria) this;
		}

		public Criteria andCommissionRateGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("COMMISSION_RATE >=", value, "commissionRate");
			return (Criteria) this;
		}

		public Criteria andCommissionRateLessThan(BigDecimal value) {
			addCriterion("COMMISSION_RATE <", value, "commissionRate");
			return (Criteria) this;
		}

		public Criteria andCommissionRateLessThanOrEqualTo(BigDecimal value) {
			addCriterion("COMMISSION_RATE <=", value, "commissionRate");
			return (Criteria) this;
		}

		public Criteria andCommissionRateIn(List<BigDecimal> values) {
			addCriterion("COMMISSION_RATE in", values, "commissionRate");
			return (Criteria) this;
		}

		public Criteria andCommissionRateNotIn(List<BigDecimal> values) {
			addCriterion("COMMISSION_RATE not in", values, "commissionRate");
			return (Criteria) this;
		}

		public Criteria andCommissionRateBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("COMMISSION_RATE between", value1, value2, "commissionRate");
			return (Criteria) this;
		}

		public Criteria andCommissionRateNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("COMMISSION_RATE not between", value1, value2, "commissionRate");
			return (Criteria) this;
		}

		public Criteria andStandardCommissionIsNull() {
			addCriterion("STANDARD_COMMISSION is null");
			return (Criteria) this;
		}

		public Criteria andStandardCommissionIsNotNull() {
			addCriterion("STANDARD_COMMISSION is not null");
			return (Criteria) this;
		}

		public Criteria andStandardCommissionEqualTo(BigDecimal value) {
			addCriterion("STANDARD_COMMISSION =", value, "standardCommission");
			return (Criteria) this;
		}

		public Criteria andStandardCommissionNotEqualTo(BigDecimal value) {
			addCriterion("STANDARD_COMMISSION <>", value, "standardCommission");
			return (Criteria) this;
		}

		public Criteria andStandardCommissionGreaterThan(BigDecimal value) {
			addCriterion("STANDARD_COMMISSION >", value, "standardCommission");
			return (Criteria) this;
		}

		public Criteria andStandardCommissionGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("STANDARD_COMMISSION >=", value, "standardCommission");
			return (Criteria) this;
		}

		public Criteria andStandardCommissionLessThan(BigDecimal value) {
			addCriterion("STANDARD_COMMISSION <", value, "standardCommission");
			return (Criteria) this;
		}

		public Criteria andStandardCommissionLessThanOrEqualTo(BigDecimal value) {
			addCriterion("STANDARD_COMMISSION <=", value, "standardCommission");
			return (Criteria) this;
		}

		public Criteria andStandardCommissionIn(List<BigDecimal> values) {
			addCriterion("STANDARD_COMMISSION in", values, "standardCommission");
			return (Criteria) this;
		}

		public Criteria andStandardCommissionNotIn(List<BigDecimal> values) {
			addCriterion("STANDARD_COMMISSION not in", values, "standardCommission");
			return (Criteria) this;
		}

		public Criteria andStandardCommissionBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("STANDARD_COMMISSION between", value1, value2, "standardCommission");
			return (Criteria) this;
		}

		public Criteria andStandardCommissionNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("STANDARD_COMMISSION not between", value1, value2, "standardCommission");
			return (Criteria) this;
		}

		public Criteria andCodeTypeIsNull() {
			addCriterion("CODE_TYPE is null");
			return (Criteria) this;
		}

		public Criteria andCodeTypeIsNotNull() {
			addCriterion("CODE_TYPE is not null");
			return (Criteria) this;
		}

		public Criteria andCodeTypeEqualTo(Byte value) {
			addCriterion("CODE_TYPE =", value, "codeType");
			return (Criteria) this;
		}

		public Criteria andCodeTypeNotEqualTo(Byte value) {
			addCriterion("CODE_TYPE <>", value, "codeType");
			return (Criteria) this;
		}

		public Criteria andCodeTypeGreaterThan(Byte value) {
			addCriterion("CODE_TYPE >", value, "codeType");
			return (Criteria) this;
		}

		public Criteria andCodeTypeGreaterThanOrEqualTo(Byte value) {
			addCriterion("CODE_TYPE >=", value, "codeType");
			return (Criteria) this;
		}

		public Criteria andCodeTypeLessThan(Byte value) {
			addCriterion("CODE_TYPE <", value, "codeType");
			return (Criteria) this;
		}

		public Criteria andCodeTypeLessThanOrEqualTo(Byte value) {
			addCriterion("CODE_TYPE <=", value, "codeType");
			return (Criteria) this;
		}

		public Criteria andCodeTypeIn(List<Byte> values) {
			addCriterion("CODE_TYPE in", values, "codeType");
			return (Criteria) this;
		}

		public Criteria andCodeTypeNotIn(List<Byte> values) {
			addCriterion("CODE_TYPE not in", values, "codeType");
			return (Criteria) this;
		}

		public Criteria andCodeTypeBetween(Byte value1, Byte value2) {
			addCriterion("CODE_TYPE between", value1, value2, "codeType");
			return (Criteria) this;
		}

		public Criteria andCodeTypeNotBetween(Byte value1, Byte value2) {
			addCriterion("CODE_TYPE not between", value1, value2, "codeType");
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

		public Criteria andSellOwnerCommsionIsNull() {
			addCriterion("SELL_OWNER_COMMSION is null");
			return (Criteria) this;
		}

		public Criteria andSellOwnerCommsionIsNotNull() {
			addCriterion("SELL_OWNER_COMMSION is not null");
			return (Criteria) this;
		}

		public Criteria andSellOwnerCommsionEqualTo(BigDecimal value) {
			addCriterion("SELL_OWNER_COMMSION =", value, "sellOwnerCommsion");
			return (Criteria) this;
		}

		public Criteria andSellOwnerCommsionNotEqualTo(BigDecimal value) {
			addCriterion("SELL_OWNER_COMMSION <>", value, "sellOwnerCommsion");
			return (Criteria) this;
		}

		public Criteria andSellOwnerCommsionGreaterThan(BigDecimal value) {
			addCriterion("SELL_OWNER_COMMSION >", value, "sellOwnerCommsion");
			return (Criteria) this;
		}

		public Criteria andSellOwnerCommsionGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("SELL_OWNER_COMMSION >=", value, "sellOwnerCommsion");
			return (Criteria) this;
		}

		public Criteria andSellOwnerCommsionLessThan(BigDecimal value) {
			addCriterion("SELL_OWNER_COMMSION <", value, "sellOwnerCommsion");
			return (Criteria) this;
		}

		public Criteria andSellOwnerCommsionLessThanOrEqualTo(BigDecimal value) {
			addCriterion("SELL_OWNER_COMMSION <=", value, "sellOwnerCommsion");
			return (Criteria) this;
		}

		public Criteria andSellOwnerCommsionIn(List<BigDecimal> values) {
			addCriterion("SELL_OWNER_COMMSION in", values, "sellOwnerCommsion");
			return (Criteria) this;
		}

		public Criteria andSellOwnerCommsionNotIn(List<BigDecimal> values) {
			addCriterion("SELL_OWNER_COMMSION not in", values, "sellOwnerCommsion");
			return (Criteria) this;
		}

		public Criteria andSellOwnerCommsionBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("SELL_OWNER_COMMSION between", value1, value2, "sellOwnerCommsion");
			return (Criteria) this;
		}

		public Criteria andSellOwnerCommsionNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("SELL_OWNER_COMMSION not between", value1, value2, "sellOwnerCommsion");
			return (Criteria) this;
		}

		public Criteria andBuyCustomerCommsionIsNull() {
			addCriterion("BUY_CUSTOMER_COMMSION is null");
			return (Criteria) this;
		}

		public Criteria andBuyCustomerCommsionIsNotNull() {
			addCriterion("BUY_CUSTOMER_COMMSION is not null");
			return (Criteria) this;
		}

		public Criteria andBuyCustomerCommsionEqualTo(BigDecimal value) {
			addCriterion("BUY_CUSTOMER_COMMSION =", value, "buyCustomerCommsion");
			return (Criteria) this;
		}

		public Criteria andBuyCustomerCommsionNotEqualTo(BigDecimal value) {
			addCriterion("BUY_CUSTOMER_COMMSION <>", value, "buyCustomerCommsion");
			return (Criteria) this;
		}

		public Criteria andBuyCustomerCommsionGreaterThan(BigDecimal value) {
			addCriterion("BUY_CUSTOMER_COMMSION >", value, "buyCustomerCommsion");
			return (Criteria) this;
		}

		public Criteria andBuyCustomerCommsionGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("BUY_CUSTOMER_COMMSION >=", value, "buyCustomerCommsion");
			return (Criteria) this;
		}

		public Criteria andBuyCustomerCommsionLessThan(BigDecimal value) {
			addCriterion("BUY_CUSTOMER_COMMSION <", value, "buyCustomerCommsion");
			return (Criteria) this;
		}

		public Criteria andBuyCustomerCommsionLessThanOrEqualTo(BigDecimal value) {
			addCriterion("BUY_CUSTOMER_COMMSION <=", value, "buyCustomerCommsion");
			return (Criteria) this;
		}

		public Criteria andBuyCustomerCommsionIn(List<BigDecimal> values) {
			addCriterion("BUY_CUSTOMER_COMMSION in", values, "buyCustomerCommsion");
			return (Criteria) this;
		}

		public Criteria andBuyCustomerCommsionNotIn(List<BigDecimal> values) {
			addCriterion("BUY_CUSTOMER_COMMSION not in", values, "buyCustomerCommsion");
			return (Criteria) this;
		}

		public Criteria andBuyCustomerCommsionBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("BUY_CUSTOMER_COMMSION between", value1, value2, "buyCustomerCommsion");
			return (Criteria) this;
		}

		public Criteria andBuyCustomerCommsionNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("BUY_CUSTOMER_COMMSION not between", value1, value2, "buyCustomerCommsion");
			return (Criteria) this;
		}

		public Criteria andPlanningUseIsNull() {
			addCriterion("PLANNING_USE is null");
			return (Criteria) this;
		}

		public Criteria andPlanningUseIsNotNull() {
			addCriterion("PLANNING_USE is not null");
			return (Criteria) this;
		}

		public Criteria andPlanningUseEqualTo(String value) {
			addCriterion("PLANNING_USE =", value, "planningUse");
			return (Criteria) this;
		}

		public Criteria andPlanningUseNotEqualTo(String value) {
			addCriterion("PLANNING_USE <>", value, "planningUse");
			return (Criteria) this;
		}

		public Criteria andPlanningUseGreaterThan(String value) {
			addCriterion("PLANNING_USE >", value, "planningUse");
			return (Criteria) this;
		}

		public Criteria andPlanningUseGreaterThanOrEqualTo(String value) {
			addCriterion("PLANNING_USE >=", value, "planningUse");
			return (Criteria) this;
		}

		public Criteria andPlanningUseLessThan(String value) {
			addCriterion("PLANNING_USE <", value, "planningUse");
			return (Criteria) this;
		}

		public Criteria andPlanningUseLessThanOrEqualTo(String value) {
			addCriterion("PLANNING_USE <=", value, "planningUse");
			return (Criteria) this;
		}

		public Criteria andPlanningUseLike(String value) {
			addCriterion("PLANNING_USE like", value, "planningUse");
			return (Criteria) this;
		}

		public Criteria andPlanningUseNotLike(String value) {
			addCriterion("PLANNING_USE not like", value, "planningUse");
			return (Criteria) this;
		}

		public Criteria andPlanningUseIn(List<String> values) {
			addCriterion("PLANNING_USE in", values, "planningUse");
			return (Criteria) this;
		}

		public Criteria andPlanningUseNotIn(List<String> values) {
			addCriterion("PLANNING_USE not in", values, "planningUse");
			return (Criteria) this;
		}

		public Criteria andPlanningUseBetween(String value1, String value2) {
			addCriterion("PLANNING_USE between", value1, value2, "planningUse");
			return (Criteria) this;
		}

		public Criteria andPlanningUseNotBetween(String value1, String value2) {
			addCriterion("PLANNING_USE not between", value1, value2, "planningUse");
			return (Criteria) this;
		}

		public Criteria andLandcardTypeIsNull() {
			addCriterion("LANDCARD_TYPE is null");
			return (Criteria) this;
		}

		public Criteria andLandcardTypeIsNotNull() {
			addCriterion("LANDCARD_TYPE is not null");
			return (Criteria) this;
		}

		public Criteria andLandcardTypeEqualTo(Byte value) {
			addCriterion("LANDCARD_TYPE =", value, "landcardType");
			return (Criteria) this;
		}

		public Criteria andLandcardTypeNotEqualTo(Byte value) {
			addCriterion("LANDCARD_TYPE <>", value, "landcardType");
			return (Criteria) this;
		}

		public Criteria andLandcardTypeGreaterThan(Byte value) {
			addCriterion("LANDCARD_TYPE >", value, "landcardType");
			return (Criteria) this;
		}

		public Criteria andLandcardTypeGreaterThanOrEqualTo(Byte value) {
			addCriterion("LANDCARD_TYPE >=", value, "landcardType");
			return (Criteria) this;
		}

		public Criteria andLandcardTypeLessThan(Byte value) {
			addCriterion("LANDCARD_TYPE <", value, "landcardType");
			return (Criteria) this;
		}

		public Criteria andLandcardTypeLessThanOrEqualTo(Byte value) {
			addCriterion("LANDCARD_TYPE <=", value, "landcardType");
			return (Criteria) this;
		}

		public Criteria andLandcardTypeIn(List<Byte> values) {
			addCriterion("LANDCARD_TYPE in", values, "landcardType");
			return (Criteria) this;
		}

		public Criteria andLandcardTypeNotIn(List<Byte> values) {
			addCriterion("LANDCARD_TYPE not in", values, "landcardType");
			return (Criteria) this;
		}

		public Criteria andLandcardTypeBetween(Byte value1, Byte value2) {
			addCriterion("LANDCARD_TYPE between", value1, value2, "landcardType");
			return (Criteria) this;
		}

		public Criteria andLandcardTypeNotBetween(Byte value1, Byte value2) {
			addCriterion("LANDCARD_TYPE not between", value1, value2, "landcardType");
			return (Criteria) this;
		}

		public Criteria andMortgageTypeIsNull() {
			addCriterion("MORTGAGE_TYPE is null");
			return (Criteria) this;
		}

		public Criteria andMortgageTypeIsNotNull() {
			addCriterion("MORTGAGE_TYPE is not null");
			return (Criteria) this;
		}

		public Criteria andMortgageTypeEqualTo(Byte value) {
			addCriterion("MORTGAGE_TYPE =", value, "mortgageType");
			return (Criteria) this;
		}

		public Criteria andMortgageTypeNotEqualTo(Byte value) {
			addCriterion("MORTGAGE_TYPE <>", value, "mortgageType");
			return (Criteria) this;
		}

		public Criteria andMortgageTypeGreaterThan(Byte value) {
			addCriterion("MORTGAGE_TYPE >", value, "mortgageType");
			return (Criteria) this;
		}

		public Criteria andMortgageTypeGreaterThanOrEqualTo(Byte value) {
			addCriterion("MORTGAGE_TYPE >=", value, "mortgageType");
			return (Criteria) this;
		}

		public Criteria andMortgageTypeLessThan(Byte value) {
			addCriterion("MORTGAGE_TYPE <", value, "mortgageType");
			return (Criteria) this;
		}

		public Criteria andMortgageTypeLessThanOrEqualTo(Byte value) {
			addCriterion("MORTGAGE_TYPE <=", value, "mortgageType");
			return (Criteria) this;
		}

		public Criteria andMortgageTypeIn(List<Byte> values) {
			addCriterion("MORTGAGE_TYPE in", values, "mortgageType");
			return (Criteria) this;
		}

		public Criteria andMortgageTypeNotIn(List<Byte> values) {
			addCriterion("MORTGAGE_TYPE not in", values, "mortgageType");
			return (Criteria) this;
		}

		public Criteria andMortgageTypeBetween(Byte value1, Byte value2) {
			addCriterion("MORTGAGE_TYPE between", value1, value2, "mortgageType");
			return (Criteria) this;
		}

		public Criteria andMortgageTypeNotBetween(Byte value1, Byte value2) {
			addCriterion("MORTGAGE_TYPE not between", value1, value2, "mortgageType");
			return (Criteria) this;
		}

		public Criteria andLeaseTypeIsNull() {
			addCriterion("LEASE_TYPE is null");
			return (Criteria) this;
		}

		public Criteria andLeaseTypeIsNotNull() {
			addCriterion("LEASE_TYPE is not null");
			return (Criteria) this;
		}

		public Criteria andLeaseTypeEqualTo(Byte value) {
			addCriterion("LEASE_TYPE =", value, "leaseType");
			return (Criteria) this;
		}

		public Criteria andLeaseTypeNotEqualTo(Byte value) {
			addCriterion("LEASE_TYPE <>", value, "leaseType");
			return (Criteria) this;
		}

		public Criteria andLeaseTypeGreaterThan(Byte value) {
			addCriterion("LEASE_TYPE >", value, "leaseType");
			return (Criteria) this;
		}

		public Criteria andLeaseTypeGreaterThanOrEqualTo(Byte value) {
			addCriterion("LEASE_TYPE >=", value, "leaseType");
			return (Criteria) this;
		}

		public Criteria andLeaseTypeLessThan(Byte value) {
			addCriterion("LEASE_TYPE <", value, "leaseType");
			return (Criteria) this;
		}

		public Criteria andLeaseTypeLessThanOrEqualTo(Byte value) {
			addCriterion("LEASE_TYPE <=", value, "leaseType");
			return (Criteria) this;
		}

		public Criteria andLeaseTypeIn(List<Byte> values) {
			addCriterion("LEASE_TYPE in", values, "leaseType");
			return (Criteria) this;
		}

		public Criteria andLeaseTypeNotIn(List<Byte> values) {
			addCriterion("LEASE_TYPE not in", values, "leaseType");
			return (Criteria) this;
		}

		public Criteria andLeaseTypeBetween(Byte value1, Byte value2) {
			addCriterion("LEASE_TYPE between", value1, value2, "leaseType");
			return (Criteria) this;
		}

		public Criteria andLeaseTypeNotBetween(Byte value1, Byte value2) {
			addCriterion("LEASE_TYPE not between", value1, value2, "leaseType");
			return (Criteria) this;
		}

		public Criteria andSellerProxyNameIsNull() {
			addCriterion("SELLER_PROXY_NAME is null");
			return (Criteria) this;
		}

		public Criteria andSellerProxyNameIsNotNull() {
			addCriterion("SELLER_PROXY_NAME is not null");
			return (Criteria) this;
		}

		public Criteria andSellerProxyNameEqualTo(String value) {
			addCriterion("SELLER_PROXY_NAME =", value, "sellerProxyName");
			return (Criteria) this;
		}

		public Criteria andSellerProxyNameNotEqualTo(String value) {
			addCriterion("SELLER_PROXY_NAME <>", value, "sellerProxyName");
			return (Criteria) this;
		}

		public Criteria andSellerProxyNameGreaterThan(String value) {
			addCriterion("SELLER_PROXY_NAME >", value, "sellerProxyName");
			return (Criteria) this;
		}

		public Criteria andSellerProxyNameGreaterThanOrEqualTo(String value) {
			addCriterion("SELLER_PROXY_NAME >=", value, "sellerProxyName");
			return (Criteria) this;
		}

		public Criteria andSellerProxyNameLessThan(String value) {
			addCriterion("SELLER_PROXY_NAME <", value, "sellerProxyName");
			return (Criteria) this;
		}

		public Criteria andSellerProxyNameLessThanOrEqualTo(String value) {
			addCriterion("SELLER_PROXY_NAME <=", value, "sellerProxyName");
			return (Criteria) this;
		}

		public Criteria andSellerProxyNameLike(String value) {
			addCriterion("SELLER_PROXY_NAME like", value, "sellerProxyName");
			return (Criteria) this;
		}

		public Criteria andSellerProxyNameNotLike(String value) {
			addCriterion("SELLER_PROXY_NAME not like", value, "sellerProxyName");
			return (Criteria) this;
		}

		public Criteria andSellerProxyNameIn(List<String> values) {
			addCriterion("SELLER_PROXY_NAME in", values, "sellerProxyName");
			return (Criteria) this;
		}

		public Criteria andSellerProxyNameNotIn(List<String> values) {
			addCriterion("SELLER_PROXY_NAME not in", values, "sellerProxyName");
			return (Criteria) this;
		}

		public Criteria andSellerProxyNameBetween(String value1, String value2) {
			addCriterion("SELLER_PROXY_NAME between", value1, value2, "sellerProxyName");
			return (Criteria) this;
		}

		public Criteria andSellerProxyNameNotBetween(String value1, String value2) {
			addCriterion("SELLER_PROXY_NAME not between", value1, value2, "sellerProxyName");
			return (Criteria) this;
		}

		public Criteria andSellerProxyIdcardIsNull() {
			addCriterion("SELLER_PROXY_IDCARD is null");
			return (Criteria) this;
		}

		public Criteria andSellerProxyIdcardIsNotNull() {
			addCriterion("SELLER_PROXY_IDCARD is not null");
			return (Criteria) this;
		}

		public Criteria andSellerProxyIdcardEqualTo(String value) {
			addCriterion("SELLER_PROXY_IDCARD =", value, "sellerProxyIdcard");
			return (Criteria) this;
		}

		public Criteria andSellerProxyIdcardNotEqualTo(String value) {
			addCriterion("SELLER_PROXY_IDCARD <>", value, "sellerProxyIdcard");
			return (Criteria) this;
		}

		public Criteria andSellerProxyIdcardGreaterThan(String value) {
			addCriterion("SELLER_PROXY_IDCARD >", value, "sellerProxyIdcard");
			return (Criteria) this;
		}

		public Criteria andSellerProxyIdcardGreaterThanOrEqualTo(String value) {
			addCriterion("SELLER_PROXY_IDCARD >=", value, "sellerProxyIdcard");
			return (Criteria) this;
		}

		public Criteria andSellerProxyIdcardLessThan(String value) {
			addCriterion("SELLER_PROXY_IDCARD <", value, "sellerProxyIdcard");
			return (Criteria) this;
		}

		public Criteria andSellerProxyIdcardLessThanOrEqualTo(String value) {
			addCriterion("SELLER_PROXY_IDCARD <=", value, "sellerProxyIdcard");
			return (Criteria) this;
		}

		public Criteria andSellerProxyIdcardLike(String value) {
			addCriterion("SELLER_PROXY_IDCARD like", value, "sellerProxyIdcard");
			return (Criteria) this;
		}

		public Criteria andSellerProxyIdcardNotLike(String value) {
			addCriterion("SELLER_PROXY_IDCARD not like", value, "sellerProxyIdcard");
			return (Criteria) this;
		}

		public Criteria andSellerProxyIdcardIn(List<String> values) {
			addCriterion("SELLER_PROXY_IDCARD in", values, "sellerProxyIdcard");
			return (Criteria) this;
		}

		public Criteria andSellerProxyIdcardNotIn(List<String> values) {
			addCriterion("SELLER_PROXY_IDCARD not in", values, "sellerProxyIdcard");
			return (Criteria) this;
		}

		public Criteria andSellerProxyIdcardBetween(String value1, String value2) {
			addCriterion("SELLER_PROXY_IDCARD between", value1, value2, "sellerProxyIdcard");
			return (Criteria) this;
		}

		public Criteria andSellerProxyIdcardNotBetween(String value1, String value2) {
			addCriterion("SELLER_PROXY_IDCARD not between", value1, value2, "sellerProxyIdcard");
			return (Criteria) this;
		}

		public Criteria andSellerProxyPhoneIsNull() {
			addCriterion("SELLER_PROXY_PHONE is null");
			return (Criteria) this;
		}

		public Criteria andSellerProxyPhoneIsNotNull() {
			addCriterion("SELLER_PROXY_PHONE is not null");
			return (Criteria) this;
		}

		public Criteria andSellerProxyPhoneEqualTo(String value) {
			addCriterion("SELLER_PROXY_PHONE =", value, "sellerProxyPhone");
			return (Criteria) this;
		}

		public Criteria andSellerProxyPhoneNotEqualTo(String value) {
			addCriterion("SELLER_PROXY_PHONE <>", value, "sellerProxyPhone");
			return (Criteria) this;
		}

		public Criteria andSellerProxyPhoneGreaterThan(String value) {
			addCriterion("SELLER_PROXY_PHONE >", value, "sellerProxyPhone");
			return (Criteria) this;
		}

		public Criteria andSellerProxyPhoneGreaterThanOrEqualTo(String value) {
			addCriterion("SELLER_PROXY_PHONE >=", value, "sellerProxyPhone");
			return (Criteria) this;
		}

		public Criteria andSellerProxyPhoneLessThan(String value) {
			addCriterion("SELLER_PROXY_PHONE <", value, "sellerProxyPhone");
			return (Criteria) this;
		}

		public Criteria andSellerProxyPhoneLessThanOrEqualTo(String value) {
			addCriterion("SELLER_PROXY_PHONE <=", value, "sellerProxyPhone");
			return (Criteria) this;
		}

		public Criteria andSellerProxyPhoneLike(String value) {
			addCriterion("SELLER_PROXY_PHONE like", value, "sellerProxyPhone");
			return (Criteria) this;
		}

		public Criteria andSellerProxyPhoneNotLike(String value) {
			addCriterion("SELLER_PROXY_PHONE not like", value, "sellerProxyPhone");
			return (Criteria) this;
		}

		public Criteria andSellerProxyPhoneIn(List<String> values) {
			addCriterion("SELLER_PROXY_PHONE in", values, "sellerProxyPhone");
			return (Criteria) this;
		}

		public Criteria andSellerProxyPhoneNotIn(List<String> values) {
			addCriterion("SELLER_PROXY_PHONE not in", values, "sellerProxyPhone");
			return (Criteria) this;
		}

		public Criteria andSellerProxyPhoneBetween(String value1, String value2) {
			addCriterion("SELLER_PROXY_PHONE between", value1, value2, "sellerProxyPhone");
			return (Criteria) this;
		}

		public Criteria andSellerProxyPhoneNotBetween(String value1, String value2) {
			addCriterion("SELLER_PROXY_PHONE not between", value1, value2, "sellerProxyPhone");
			return (Criteria) this;
		}

		public Criteria andSellerProxyPhoneencodeIsNull() {
			addCriterion("SELLER_PROXY_PHONEENCODE is null");
			return (Criteria) this;
		}

		public Criteria andSellerProxyPhoneencodeIsNotNull() {
			addCriterion("SELLER_PROXY_PHONEENCODE is not null");
			return (Criteria) this;
		}

		public Criteria andSellerProxyPhoneencodeEqualTo(String value) {
			addCriterion("SELLER_PROXY_PHONEENCODE =", value, "sellerProxyPhoneencode");
			return (Criteria) this;
		}

		public Criteria andSellerProxyPhoneencodeNotEqualTo(String value) {
			addCriterion("SELLER_PROXY_PHONEENCODE <>", value, "sellerProxyPhoneencode");
			return (Criteria) this;
		}

		public Criteria andSellerProxyPhoneencodeGreaterThan(String value) {
			addCriterion("SELLER_PROXY_PHONEENCODE >", value, "sellerProxyPhoneencode");
			return (Criteria) this;
		}

		public Criteria andSellerProxyPhoneencodeGreaterThanOrEqualTo(String value) {
			addCriterion("SELLER_PROXY_PHONEENCODE >=", value, "sellerProxyPhoneencode");
			return (Criteria) this;
		}

		public Criteria andSellerProxyPhoneencodeLessThan(String value) {
			addCriterion("SELLER_PROXY_PHONEENCODE <", value, "sellerProxyPhoneencode");
			return (Criteria) this;
		}

		public Criteria andSellerProxyPhoneencodeLessThanOrEqualTo(String value) {
			addCriterion("SELLER_PROXY_PHONEENCODE <=", value, "sellerProxyPhoneencode");
			return (Criteria) this;
		}

		public Criteria andSellerProxyPhoneencodeLike(String value) {
			addCriterion("SELLER_PROXY_PHONEENCODE like", value, "sellerProxyPhoneencode");
			return (Criteria) this;
		}

		public Criteria andSellerProxyPhoneencodeNotLike(String value) {
			addCriterion("SELLER_PROXY_PHONEENCODE not like", value, "sellerProxyPhoneencode");
			return (Criteria) this;
		}

		public Criteria andSellerProxyPhoneencodeIn(List<String> values) {
			addCriterion("SELLER_PROXY_PHONEENCODE in", values, "sellerProxyPhoneencode");
			return (Criteria) this;
		}

		public Criteria andSellerProxyPhoneencodeNotIn(List<String> values) {
			addCriterion("SELLER_PROXY_PHONEENCODE not in", values, "sellerProxyPhoneencode");
			return (Criteria) this;
		}

		public Criteria andSellerProxyPhoneencodeBetween(String value1, String value2) {
			addCriterion("SELLER_PROXY_PHONEENCODE between", value1, value2, "sellerProxyPhoneencode");
			return (Criteria) this;
		}

		public Criteria andSellerProxyPhoneencodeNotBetween(String value1, String value2) {
			addCriterion("SELLER_PROXY_PHONEENCODE not between", value1, value2, "sellerProxyPhoneencode");
			return (Criteria) this;
		}

		public Criteria andBuyerProxyNameIsNull() {
			addCriterion("BUYER_PROXY_NAME is null");
			return (Criteria) this;
		}

		public Criteria andBuyerProxyNameIsNotNull() {
			addCriterion("BUYER_PROXY_NAME is not null");
			return (Criteria) this;
		}

		public Criteria andBuyerProxyNameEqualTo(String value) {
			addCriterion("BUYER_PROXY_NAME =", value, "buyerProxyName");
			return (Criteria) this;
		}

		public Criteria andBuyerProxyNameNotEqualTo(String value) {
			addCriterion("BUYER_PROXY_NAME <>", value, "buyerProxyName");
			return (Criteria) this;
		}

		public Criteria andBuyerProxyNameGreaterThan(String value) {
			addCriterion("BUYER_PROXY_NAME >", value, "buyerProxyName");
			return (Criteria) this;
		}

		public Criteria andBuyerProxyNameGreaterThanOrEqualTo(String value) {
			addCriterion("BUYER_PROXY_NAME >=", value, "buyerProxyName");
			return (Criteria) this;
		}

		public Criteria andBuyerProxyNameLessThan(String value) {
			addCriterion("BUYER_PROXY_NAME <", value, "buyerProxyName");
			return (Criteria) this;
		}

		public Criteria andBuyerProxyNameLessThanOrEqualTo(String value) {
			addCriterion("BUYER_PROXY_NAME <=", value, "buyerProxyName");
			return (Criteria) this;
		}

		public Criteria andBuyerProxyNameLike(String value) {
			addCriterion("BUYER_PROXY_NAME like", value, "buyerProxyName");
			return (Criteria) this;
		}

		public Criteria andBuyerProxyNameNotLike(String value) {
			addCriterion("BUYER_PROXY_NAME not like", value, "buyerProxyName");
			return (Criteria) this;
		}

		public Criteria andBuyerProxyNameIn(List<String> values) {
			addCriterion("BUYER_PROXY_NAME in", values, "buyerProxyName");
			return (Criteria) this;
		}

		public Criteria andBuyerProxyNameNotIn(List<String> values) {
			addCriterion("BUYER_PROXY_NAME not in", values, "buyerProxyName");
			return (Criteria) this;
		}

		public Criteria andBuyerProxyNameBetween(String value1, String value2) {
			addCriterion("BUYER_PROXY_NAME between", value1, value2, "buyerProxyName");
			return (Criteria) this;
		}

		public Criteria andBuyerProxyNameNotBetween(String value1, String value2) {
			addCriterion("BUYER_PROXY_NAME not between", value1, value2, "buyerProxyName");
			return (Criteria) this;
		}

		public Criteria andBuyerProxyIdcardIsNull() {
			addCriterion("BUYER_PROXY_IDCARD is null");
			return (Criteria) this;
		}

		public Criteria andBuyerProxyIdcardIsNotNull() {
			addCriterion("BUYER_PROXY_IDCARD is not null");
			return (Criteria) this;
		}

		public Criteria andBuyerProxyIdcardEqualTo(String value) {
			addCriterion("BUYER_PROXY_IDCARD =", value, "buyerProxyIdcard");
			return (Criteria) this;
		}

		public Criteria andBuyerProxyIdcardNotEqualTo(String value) {
			addCriterion("BUYER_PROXY_IDCARD <>", value, "buyerProxyIdcard");
			return (Criteria) this;
		}

		public Criteria andBuyerProxyIdcardGreaterThan(String value) {
			addCriterion("BUYER_PROXY_IDCARD >", value, "buyerProxyIdcard");
			return (Criteria) this;
		}

		public Criteria andBuyerProxyIdcardGreaterThanOrEqualTo(String value) {
			addCriterion("BUYER_PROXY_IDCARD >=", value, "buyerProxyIdcard");
			return (Criteria) this;
		}

		public Criteria andBuyerProxyIdcardLessThan(String value) {
			addCriterion("BUYER_PROXY_IDCARD <", value, "buyerProxyIdcard");
			return (Criteria) this;
		}

		public Criteria andBuyerProxyIdcardLessThanOrEqualTo(String value) {
			addCriterion("BUYER_PROXY_IDCARD <=", value, "buyerProxyIdcard");
			return (Criteria) this;
		}

		public Criteria andBuyerProxyIdcardLike(String value) {
			addCriterion("BUYER_PROXY_IDCARD like", value, "buyerProxyIdcard");
			return (Criteria) this;
		}

		public Criteria andBuyerProxyIdcardNotLike(String value) {
			addCriterion("BUYER_PROXY_IDCARD not like", value, "buyerProxyIdcard");
			return (Criteria) this;
		}

		public Criteria andBuyerProxyIdcardIn(List<String> values) {
			addCriterion("BUYER_PROXY_IDCARD in", values, "buyerProxyIdcard");
			return (Criteria) this;
		}

		public Criteria andBuyerProxyIdcardNotIn(List<String> values) {
			addCriterion("BUYER_PROXY_IDCARD not in", values, "buyerProxyIdcard");
			return (Criteria) this;
		}

		public Criteria andBuyerProxyIdcardBetween(String value1, String value2) {
			addCriterion("BUYER_PROXY_IDCARD between", value1, value2, "buyerProxyIdcard");
			return (Criteria) this;
		}

		public Criteria andBuyerProxyIdcardNotBetween(String value1, String value2) {
			addCriterion("BUYER_PROXY_IDCARD not between", value1, value2, "buyerProxyIdcard");
			return (Criteria) this;
		}

		public Criteria andBuyerProxyPhoneIsNull() {
			addCriterion("BUYER_PROXY_PHONE is null");
			return (Criteria) this;
		}

		public Criteria andBuyerProxyPhoneIsNotNull() {
			addCriterion("BUYER_PROXY_PHONE is not null");
			return (Criteria) this;
		}

		public Criteria andBuyerProxyPhoneEqualTo(String value) {
			addCriterion("BUYER_PROXY_PHONE =", value, "buyerProxyPhone");
			return (Criteria) this;
		}

		public Criteria andBuyerProxyPhoneNotEqualTo(String value) {
			addCriterion("BUYER_PROXY_PHONE <>", value, "buyerProxyPhone");
			return (Criteria) this;
		}

		public Criteria andBuyerProxyPhoneGreaterThan(String value) {
			addCriterion("BUYER_PROXY_PHONE >", value, "buyerProxyPhone");
			return (Criteria) this;
		}

		public Criteria andBuyerProxyPhoneGreaterThanOrEqualTo(String value) {
			addCriterion("BUYER_PROXY_PHONE >=", value, "buyerProxyPhone");
			return (Criteria) this;
		}

		public Criteria andBuyerProxyPhoneLessThan(String value) {
			addCriterion("BUYER_PROXY_PHONE <", value, "buyerProxyPhone");
			return (Criteria) this;
		}

		public Criteria andBuyerProxyPhoneLessThanOrEqualTo(String value) {
			addCriterion("BUYER_PROXY_PHONE <=", value, "buyerProxyPhone");
			return (Criteria) this;
		}

		public Criteria andBuyerProxyPhoneLike(String value) {
			addCriterion("BUYER_PROXY_PHONE like", value, "buyerProxyPhone");
			return (Criteria) this;
		}

		public Criteria andBuyerProxyPhoneNotLike(String value) {
			addCriterion("BUYER_PROXY_PHONE not like", value, "buyerProxyPhone");
			return (Criteria) this;
		}

		public Criteria andBuyerProxyPhoneIn(List<String> values) {
			addCriterion("BUYER_PROXY_PHONE in", values, "buyerProxyPhone");
			return (Criteria) this;
		}

		public Criteria andBuyerProxyPhoneNotIn(List<String> values) {
			addCriterion("BUYER_PROXY_PHONE not in", values, "buyerProxyPhone");
			return (Criteria) this;
		}

		public Criteria andBuyerProxyPhoneBetween(String value1, String value2) {
			addCriterion("BUYER_PROXY_PHONE between", value1, value2, "buyerProxyPhone");
			return (Criteria) this;
		}

		public Criteria andBuyerProxyPhoneNotBetween(String value1, String value2) {
			addCriterion("BUYER_PROXY_PHONE not between", value1, value2, "buyerProxyPhone");
			return (Criteria) this;
		}

		public Criteria andBuyerProxyPhoneencodeIsNull() {
			addCriterion("BUYER_PROXY_PHONEENCODE is null");
			return (Criteria) this;
		}

		public Criteria andBuyerProxyPhoneencodeIsNotNull() {
			addCriterion("BUYER_PROXY_PHONEENCODE is not null");
			return (Criteria) this;
		}

		public Criteria andBuyerProxyPhoneencodeEqualTo(String value) {
			addCriterion("BUYER_PROXY_PHONEENCODE =", value, "buyerProxyPhoneencode");
			return (Criteria) this;
		}

		public Criteria andBuyerProxyPhoneencodeNotEqualTo(String value) {
			addCriterion("BUYER_PROXY_PHONEENCODE <>", value, "buyerProxyPhoneencode");
			return (Criteria) this;
		}

		public Criteria andBuyerProxyPhoneencodeGreaterThan(String value) {
			addCriterion("BUYER_PROXY_PHONEENCODE >", value, "buyerProxyPhoneencode");
			return (Criteria) this;
		}

		public Criteria andBuyerProxyPhoneencodeGreaterThanOrEqualTo(String value) {
			addCriterion("BUYER_PROXY_PHONEENCODE >=", value, "buyerProxyPhoneencode");
			return (Criteria) this;
		}

		public Criteria andBuyerProxyPhoneencodeLessThan(String value) {
			addCriterion("BUYER_PROXY_PHONEENCODE <", value, "buyerProxyPhoneencode");
			return (Criteria) this;
		}

		public Criteria andBuyerProxyPhoneencodeLessThanOrEqualTo(String value) {
			addCriterion("BUYER_PROXY_PHONEENCODE <=", value, "buyerProxyPhoneencode");
			return (Criteria) this;
		}

		public Criteria andBuyerProxyPhoneencodeLike(String value) {
			addCriterion("BUYER_PROXY_PHONEENCODE like", value, "buyerProxyPhoneencode");
			return (Criteria) this;
		}

		public Criteria andBuyerProxyPhoneencodeNotLike(String value) {
			addCriterion("BUYER_PROXY_PHONEENCODE not like", value, "buyerProxyPhoneencode");
			return (Criteria) this;
		}

		public Criteria andBuyerProxyPhoneencodeIn(List<String> values) {
			addCriterion("BUYER_PROXY_PHONEENCODE in", values, "buyerProxyPhoneencode");
			return (Criteria) this;
		}

		public Criteria andBuyerProxyPhoneencodeNotIn(List<String> values) {
			addCriterion("BUYER_PROXY_PHONEENCODE not in", values, "buyerProxyPhoneencode");
			return (Criteria) this;
		}

		public Criteria andBuyerProxyPhoneencodeBetween(String value1, String value2) {
			addCriterion("BUYER_PROXY_PHONEENCODE between", value1, value2, "buyerProxyPhoneencode");
			return (Criteria) this;
		}

		public Criteria andBuyerProxyPhoneencodeNotBetween(String value1, String value2) {
			addCriterion("BUYER_PROXY_PHONEENCODE not between", value1, value2, "buyerProxyPhoneencode");
			return (Criteria) this;
		}

		public Criteria andHouseHoldElectricalIsNull() {
			addCriterion("HOUSE_HOLD_ELECTRICAL is null");
			return (Criteria) this;
		}

		public Criteria andHouseHoldElectricalIsNotNull() {
			addCriterion("HOUSE_HOLD_ELECTRICAL is not null");
			return (Criteria) this;
		}

		public Criteria andHouseHoldElectricalEqualTo(Byte value) {
			addCriterion("HOUSE_HOLD_ELECTRICAL =", value, "houseHoldElectrical");
			return (Criteria) this;
		}

		public Criteria andHouseHoldElectricalNotEqualTo(Byte value) {
			addCriterion("HOUSE_HOLD_ELECTRICAL <>", value, "houseHoldElectrical");
			return (Criteria) this;
		}

		public Criteria andHouseHoldElectricalGreaterThan(Byte value) {
			addCriterion("HOUSE_HOLD_ELECTRICAL >", value, "houseHoldElectrical");
			return (Criteria) this;
		}

		public Criteria andHouseHoldElectricalGreaterThanOrEqualTo(Byte value) {
			addCriterion("HOUSE_HOLD_ELECTRICAL >=", value, "houseHoldElectrical");
			return (Criteria) this;
		}

		public Criteria andHouseHoldElectricalLessThan(Byte value) {
			addCriterion("HOUSE_HOLD_ELECTRICAL <", value, "houseHoldElectrical");
			return (Criteria) this;
		}

		public Criteria andHouseHoldElectricalLessThanOrEqualTo(Byte value) {
			addCriterion("HOUSE_HOLD_ELECTRICAL <=", value, "houseHoldElectrical");
			return (Criteria) this;
		}

		public Criteria andHouseHoldElectricalIn(List<Byte> values) {
			addCriterion("HOUSE_HOLD_ELECTRICAL in", values, "houseHoldElectrical");
			return (Criteria) this;
		}

		public Criteria andHouseHoldElectricalNotIn(List<Byte> values) {
			addCriterion("HOUSE_HOLD_ELECTRICAL not in", values, "houseHoldElectrical");
			return (Criteria) this;
		}

		public Criteria andHouseHoldElectricalBetween(Byte value1, Byte value2) {
			addCriterion("HOUSE_HOLD_ELECTRICAL between", value1, value2, "houseHoldElectrical");
			return (Criteria) this;
		}

		public Criteria andHouseHoldElectricalNotBetween(Byte value1, Byte value2) {
			addCriterion("HOUSE_HOLD_ELECTRICAL not between", value1, value2, "houseHoldElectrical");
			return (Criteria) this;
		}

		public Criteria andBuyerTaxFeeIsNull() {
			addCriterion("BUYER_TAX_FEE is null");
			return (Criteria) this;
		}

		public Criteria andBuyerTaxFeeIsNotNull() {
			addCriterion("BUYER_TAX_FEE is not null");
			return (Criteria) this;
		}

		public Criteria andBuyerTaxFeeEqualTo(String value) {
			addCriterion("BUYER_TAX_FEE =", value, "buyerTaxFee");
			return (Criteria) this;
		}

		public Criteria andBuyerTaxFeeNotEqualTo(String value) {
			addCriterion("BUYER_TAX_FEE <>", value, "buyerTaxFee");
			return (Criteria) this;
		}

		public Criteria andBuyerTaxFeeGreaterThan(String value) {
			addCriterion("BUYER_TAX_FEE >", value, "buyerTaxFee");
			return (Criteria) this;
		}

		public Criteria andBuyerTaxFeeGreaterThanOrEqualTo(String value) {
			addCriterion("BUYER_TAX_FEE >=", value, "buyerTaxFee");
			return (Criteria) this;
		}

		public Criteria andBuyerTaxFeeLessThan(String value) {
			addCriterion("BUYER_TAX_FEE <", value, "buyerTaxFee");
			return (Criteria) this;
		}

		public Criteria andBuyerTaxFeeLessThanOrEqualTo(String value) {
			addCriterion("BUYER_TAX_FEE <=", value, "buyerTaxFee");
			return (Criteria) this;
		}

		public Criteria andBuyerTaxFeeLike(String value) {
			addCriterion("BUYER_TAX_FEE like", value, "buyerTaxFee");
			return (Criteria) this;
		}

		public Criteria andBuyerTaxFeeNotLike(String value) {
			addCriterion("BUYER_TAX_FEE not like", value, "buyerTaxFee");
			return (Criteria) this;
		}

		public Criteria andBuyerTaxFeeIn(List<String> values) {
			addCriterion("BUYER_TAX_FEE in", values, "buyerTaxFee");
			return (Criteria) this;
		}

		public Criteria andBuyerTaxFeeNotIn(List<String> values) {
			addCriterion("BUYER_TAX_FEE not in", values, "buyerTaxFee");
			return (Criteria) this;
		}

		public Criteria andBuyerTaxFeeBetween(String value1, String value2) {
			addCriterion("BUYER_TAX_FEE between", value1, value2, "buyerTaxFee");
			return (Criteria) this;
		}

		public Criteria andBuyerTaxFeeNotBetween(String value1, String value2) {
			addCriterion("BUYER_TAX_FEE not between", value1, value2, "buyerTaxFee");
			return (Criteria) this;
		}

		public Criteria andSellerTaxFeeIsNull() {
			addCriterion("SELLER_TAX_FEE is null");
			return (Criteria) this;
		}

		public Criteria andSellerTaxFeeIsNotNull() {
			addCriterion("SELLER_TAX_FEE is not null");
			return (Criteria) this;
		}

		public Criteria andSellerTaxFeeEqualTo(String value) {
			addCriterion("SELLER_TAX_FEE =", value, "sellerTaxFee");
			return (Criteria) this;
		}

		public Criteria andSellerTaxFeeNotEqualTo(String value) {
			addCriterion("SELLER_TAX_FEE <>", value, "sellerTaxFee");
			return (Criteria) this;
		}

		public Criteria andSellerTaxFeeGreaterThan(String value) {
			addCriterion("SELLER_TAX_FEE >", value, "sellerTaxFee");
			return (Criteria) this;
		}

		public Criteria andSellerTaxFeeGreaterThanOrEqualTo(String value) {
			addCriterion("SELLER_TAX_FEE >=", value, "sellerTaxFee");
			return (Criteria) this;
		}

		public Criteria andSellerTaxFeeLessThan(String value) {
			addCriterion("SELLER_TAX_FEE <", value, "sellerTaxFee");
			return (Criteria) this;
		}

		public Criteria andSellerTaxFeeLessThanOrEqualTo(String value) {
			addCriterion("SELLER_TAX_FEE <=", value, "sellerTaxFee");
			return (Criteria) this;
		}

		public Criteria andSellerTaxFeeLike(String value) {
			addCriterion("SELLER_TAX_FEE like", value, "sellerTaxFee");
			return (Criteria) this;
		}

		public Criteria andSellerTaxFeeNotLike(String value) {
			addCriterion("SELLER_TAX_FEE not like", value, "sellerTaxFee");
			return (Criteria) this;
		}

		public Criteria andSellerTaxFeeIn(List<String> values) {
			addCriterion("SELLER_TAX_FEE in", values, "sellerTaxFee");
			return (Criteria) this;
		}

		public Criteria andSellerTaxFeeNotIn(List<String> values) {
			addCriterion("SELLER_TAX_FEE not in", values, "sellerTaxFee");
			return (Criteria) this;
		}

		public Criteria andSellerTaxFeeBetween(String value1, String value2) {
			addCriterion("SELLER_TAX_FEE between", value1, value2, "sellerTaxFee");
			return (Criteria) this;
		}

		public Criteria andSellerTaxFeeNotBetween(String value1, String value2) {
			addCriterion("SELLER_TAX_FEE not between", value1, value2, "sellerTaxFee");
			return (Criteria) this;
		}

		public Criteria andDepositPayTimeIsNull() {
			addCriterion("DEPOSIT_PAY_TIME is null");
			return (Criteria) this;
		}

		public Criteria andDepositPayTimeIsNotNull() {
			addCriterion("DEPOSIT_PAY_TIME is not null");
			return (Criteria) this;
		}

		public Criteria andDepositPayTimeEqualTo(Date value) {
			addCriterion("DEPOSIT_PAY_TIME =", value, "depositPayTime");
			return (Criteria) this;
		}

		public Criteria andDepositPayTimeNotEqualTo(Date value) {
			addCriterion("DEPOSIT_PAY_TIME <>", value, "depositPayTime");
			return (Criteria) this;
		}

		public Criteria andDepositPayTimeGreaterThan(Date value) {
			addCriterion("DEPOSIT_PAY_TIME >", value, "depositPayTime");
			return (Criteria) this;
		}

		public Criteria andDepositPayTimeGreaterThanOrEqualTo(Date value) {
			addCriterion("DEPOSIT_PAY_TIME >=", value, "depositPayTime");
			return (Criteria) this;
		}

		public Criteria andDepositPayTimeLessThan(Date value) {
			addCriterion("DEPOSIT_PAY_TIME <", value, "depositPayTime");
			return (Criteria) this;
		}

		public Criteria andDepositPayTimeLessThanOrEqualTo(Date value) {
			addCriterion("DEPOSIT_PAY_TIME <=", value, "depositPayTime");
			return (Criteria) this;
		}

		public Criteria andDepositPayTimeIn(List<Date> values) {
			addCriterion("DEPOSIT_PAY_TIME in", values, "depositPayTime");
			return (Criteria) this;
		}

		public Criteria andDepositPayTimeNotIn(List<Date> values) {
			addCriterion("DEPOSIT_PAY_TIME not in", values, "depositPayTime");
			return (Criteria) this;
		}

		public Criteria andDepositPayTimeBetween(Date value1, Date value2) {
			addCriterion("DEPOSIT_PAY_TIME between", value1, value2, "depositPayTime");
			return (Criteria) this;
		}

		public Criteria andDepositPayTimeNotBetween(Date value1, Date value2) {
			addCriterion("DEPOSIT_PAY_TIME not between", value1, value2, "depositPayTime");
			return (Criteria) this;
		}

		public Criteria andDepositPayTypeIsNull() {
			addCriterion("DEPOSIT_PAY_TYPE is null");
			return (Criteria) this;
		}

		public Criteria andDepositPayTypeIsNotNull() {
			addCriterion("DEPOSIT_PAY_TYPE is not null");
			return (Criteria) this;
		}

		public Criteria andDepositPayTypeEqualTo(Byte value) {
			addCriterion("DEPOSIT_PAY_TYPE =", value, "depositPayType");
			return (Criteria) this;
		}

		public Criteria andDepositPayTypeNotEqualTo(Byte value) {
			addCriterion("DEPOSIT_PAY_TYPE <>", value, "depositPayType");
			return (Criteria) this;
		}

		public Criteria andDepositPayTypeGreaterThan(Byte value) {
			addCriterion("DEPOSIT_PAY_TYPE >", value, "depositPayType");
			return (Criteria) this;
		}

		public Criteria andDepositPayTypeGreaterThanOrEqualTo(Byte value) {
			addCriterion("DEPOSIT_PAY_TYPE >=", value, "depositPayType");
			return (Criteria) this;
		}

		public Criteria andDepositPayTypeLessThan(Byte value) {
			addCriterion("DEPOSIT_PAY_TYPE <", value, "depositPayType");
			return (Criteria) this;
		}

		public Criteria andDepositPayTypeLessThanOrEqualTo(Byte value) {
			addCriterion("DEPOSIT_PAY_TYPE <=", value, "depositPayType");
			return (Criteria) this;
		}

		public Criteria andDepositPayTypeIn(List<Byte> values) {
			addCriterion("DEPOSIT_PAY_TYPE in", values, "depositPayType");
			return (Criteria) this;
		}

		public Criteria andDepositPayTypeNotIn(List<Byte> values) {
			addCriterion("DEPOSIT_PAY_TYPE not in", values, "depositPayType");
			return (Criteria) this;
		}

		public Criteria andDepositPayTypeBetween(Byte value1, Byte value2) {
			addCriterion("DEPOSIT_PAY_TYPE between", value1, value2, "depositPayType");
			return (Criteria) this;
		}

		public Criteria andDepositPayTypeNotBetween(Byte value1, Byte value2) {
			addCriterion("DEPOSIT_PAY_TYPE not between", value1, value2, "depositPayType");
			return (Criteria) this;
		}

		public Criteria andDepositPayOtherIsNull() {
			addCriterion("DEPOSIT_PAY_OTHER is null");
			return (Criteria) this;
		}

		public Criteria andDepositPayOtherIsNotNull() {
			addCriterion("DEPOSIT_PAY_OTHER is not null");
			return (Criteria) this;
		}

		public Criteria andDepositPayOtherEqualTo(String value) {
			addCriterion("DEPOSIT_PAY_OTHER =", value, "depositPayOther");
			return (Criteria) this;
		}

		public Criteria andDepositPayOtherNotEqualTo(String value) {
			addCriterion("DEPOSIT_PAY_OTHER <>", value, "depositPayOther");
			return (Criteria) this;
		}

		public Criteria andDepositPayOtherGreaterThan(String value) {
			addCriterion("DEPOSIT_PAY_OTHER >", value, "depositPayOther");
			return (Criteria) this;
		}

		public Criteria andDepositPayOtherGreaterThanOrEqualTo(String value) {
			addCriterion("DEPOSIT_PAY_OTHER >=", value, "depositPayOther");
			return (Criteria) this;
		}

		public Criteria andDepositPayOtherLessThan(String value) {
			addCriterion("DEPOSIT_PAY_OTHER <", value, "depositPayOther");
			return (Criteria) this;
		}

		public Criteria andDepositPayOtherLessThanOrEqualTo(String value) {
			addCriterion("DEPOSIT_PAY_OTHER <=", value, "depositPayOther");
			return (Criteria) this;
		}

		public Criteria andDepositPayOtherLike(String value) {
			addCriterion("DEPOSIT_PAY_OTHER like", value, "depositPayOther");
			return (Criteria) this;
		}

		public Criteria andDepositPayOtherNotLike(String value) {
			addCriterion("DEPOSIT_PAY_OTHER not like", value, "depositPayOther");
			return (Criteria) this;
		}

		public Criteria andDepositPayOtherIn(List<String> values) {
			addCriterion("DEPOSIT_PAY_OTHER in", values, "depositPayOther");
			return (Criteria) this;
		}

		public Criteria andDepositPayOtherNotIn(List<String> values) {
			addCriterion("DEPOSIT_PAY_OTHER not in", values, "depositPayOther");
			return (Criteria) this;
		}

		public Criteria andDepositPayOtherBetween(String value1, String value2) {
			addCriterion("DEPOSIT_PAY_OTHER between", value1, value2, "depositPayOther");
			return (Criteria) this;
		}

		public Criteria andDepositPayOtherNotBetween(String value1, String value2) {
			addCriterion("DEPOSIT_PAY_OTHER not between", value1, value2, "depositPayOther");
			return (Criteria) this;
		}

		public Criteria andDownPaymentsPayType1IsNull() {
			addCriterion("DOWN_PAYMENTS_PAY_TYPE1 is null");
			return (Criteria) this;
		}

		public Criteria andDownPaymentsPayType1IsNotNull() {
			addCriterion("DOWN_PAYMENTS_PAY_TYPE1 is not null");
			return (Criteria) this;
		}

		public Criteria andDownPaymentsPayType1EqualTo(Byte value) {
			addCriterion("DOWN_PAYMENTS_PAY_TYPE1 =", value, "downPaymentsPayType1");
			return (Criteria) this;
		}

		public Criteria andDownPaymentsPayType1NotEqualTo(Byte value) {
			addCriterion("DOWN_PAYMENTS_PAY_TYPE1 <>", value, "downPaymentsPayType1");
			return (Criteria) this;
		}

		public Criteria andDownPaymentsPayType1GreaterThan(Byte value) {
			addCriterion("DOWN_PAYMENTS_PAY_TYPE1 >", value, "downPaymentsPayType1");
			return (Criteria) this;
		}

		public Criteria andDownPaymentsPayType1GreaterThanOrEqualTo(Byte value) {
			addCriterion("DOWN_PAYMENTS_PAY_TYPE1 >=", value, "downPaymentsPayType1");
			return (Criteria) this;
		}

		public Criteria andDownPaymentsPayType1LessThan(Byte value) {
			addCriterion("DOWN_PAYMENTS_PAY_TYPE1 <", value, "downPaymentsPayType1");
			return (Criteria) this;
		}

		public Criteria andDownPaymentsPayType1LessThanOrEqualTo(Byte value) {
			addCriterion("DOWN_PAYMENTS_PAY_TYPE1 <=", value, "downPaymentsPayType1");
			return (Criteria) this;
		}

		public Criteria andDownPaymentsPayType1In(List<Byte> values) {
			addCriterion("DOWN_PAYMENTS_PAY_TYPE1 in", values, "downPaymentsPayType1");
			return (Criteria) this;
		}

		public Criteria andDownPaymentsPayType1NotIn(List<Byte> values) {
			addCriterion("DOWN_PAYMENTS_PAY_TYPE1 not in", values, "downPaymentsPayType1");
			return (Criteria) this;
		}

		public Criteria andDownPaymentsPayType1Between(Byte value1, Byte value2) {
			addCriterion("DOWN_PAYMENTS_PAY_TYPE1 between", value1, value2, "downPaymentsPayType1");
			return (Criteria) this;
		}

		public Criteria andDownPaymentsPayType1NotBetween(Byte value1, Byte value2) {
			addCriterion("DOWN_PAYMENTS_PAY_TYPE1 not between", value1, value2, "downPaymentsPayType1");
			return (Criteria) this;
		}

		public Criteria andDownPaymentsPayTime1IsNull() {
			addCriterion("DOWN_PAYMENTS_PAY_TIME1 is null");
			return (Criteria) this;
		}

		public Criteria andDownPaymentsPayTime1IsNotNull() {
			addCriterion("DOWN_PAYMENTS_PAY_TIME1 is not null");
			return (Criteria) this;
		}

		public Criteria andDownPaymentsPayTime1EqualTo(String value) {
			addCriterion("DOWN_PAYMENTS_PAY_TIME1 =", value, "downPaymentsPayTime1");
			return (Criteria) this;
		}

		public Criteria andDownPaymentsPayTime1NotEqualTo(String value) {
			addCriterion("DOWN_PAYMENTS_PAY_TIME1 <>", value, "downPaymentsPayTime1");
			return (Criteria) this;
		}

		public Criteria andDownPaymentsPayTime1GreaterThan(String value) {
			addCriterion("DOWN_PAYMENTS_PAY_TIME1 >", value, "downPaymentsPayTime1");
			return (Criteria) this;
		}

		public Criteria andDownPaymentsPayTime1GreaterThanOrEqualTo(String value) {
			addCriterion("DOWN_PAYMENTS_PAY_TIME1 >=", value, "downPaymentsPayTime1");
			return (Criteria) this;
		}

		public Criteria andDownPaymentsPayTime1LessThan(String value) {
			addCriterion("DOWN_PAYMENTS_PAY_TIME1 <", value, "downPaymentsPayTime1");
			return (Criteria) this;
		}

		public Criteria andDownPaymentsPayTime1LessThanOrEqualTo(String value) {
			addCriterion("DOWN_PAYMENTS_PAY_TIME1 <=", value, "downPaymentsPayTime1");
			return (Criteria) this;
		}

		public Criteria andDownPaymentsPayTime1Like(String value) {
			addCriterion("DOWN_PAYMENTS_PAY_TIME1 like", value, "downPaymentsPayTime1");
			return (Criteria) this;
		}

		public Criteria andDownPaymentsPayTime1NotLike(String value) {
			addCriterion("DOWN_PAYMENTS_PAY_TIME1 not like", value, "downPaymentsPayTime1");
			return (Criteria) this;
		}

		public Criteria andDownPaymentsPayTime1In(List<String> values) {
			addCriterion("DOWN_PAYMENTS_PAY_TIME1 in", values, "downPaymentsPayTime1");
			return (Criteria) this;
		}

		public Criteria andDownPaymentsPayTime1NotIn(List<String> values) {
			addCriterion("DOWN_PAYMENTS_PAY_TIME1 not in", values, "downPaymentsPayTime1");
			return (Criteria) this;
		}

		public Criteria andDownPaymentsPayTime1Between(String value1, String value2) {
			addCriterion("DOWN_PAYMENTS_PAY_TIME1 between", value1, value2, "downPaymentsPayTime1");
			return (Criteria) this;
		}

		public Criteria andDownPaymentsPayTime1NotBetween(String value1, String value2) {
			addCriterion("DOWN_PAYMENTS_PAY_TIME1 not between", value1, value2, "downPaymentsPayTime1");
			return (Criteria) this;
		}

		public Criteria andHousePriceLastPayType1IsNull() {
			addCriterion("HOUSE_PRICE_LAST_PAY_TYPE1 is null");
			return (Criteria) this;
		}

		public Criteria andHousePriceLastPayType1IsNotNull() {
			addCriterion("HOUSE_PRICE_LAST_PAY_TYPE1 is not null");
			return (Criteria) this;
		}

		public Criteria andHousePriceLastPayType1EqualTo(Byte value) {
			addCriterion("HOUSE_PRICE_LAST_PAY_TYPE1 =", value, "housePriceLastPayType1");
			return (Criteria) this;
		}

		public Criteria andHousePriceLastPayType1NotEqualTo(Byte value) {
			addCriterion("HOUSE_PRICE_LAST_PAY_TYPE1 <>", value, "housePriceLastPayType1");
			return (Criteria) this;
		}

		public Criteria andHousePriceLastPayType1GreaterThan(Byte value) {
			addCriterion("HOUSE_PRICE_LAST_PAY_TYPE1 >", value, "housePriceLastPayType1");
			return (Criteria) this;
		}

		public Criteria andHousePriceLastPayType1GreaterThanOrEqualTo(Byte value) {
			addCriterion("HOUSE_PRICE_LAST_PAY_TYPE1 >=", value, "housePriceLastPayType1");
			return (Criteria) this;
		}

		public Criteria andHousePriceLastPayType1LessThan(Byte value) {
			addCriterion("HOUSE_PRICE_LAST_PAY_TYPE1 <", value, "housePriceLastPayType1");
			return (Criteria) this;
		}

		public Criteria andHousePriceLastPayType1LessThanOrEqualTo(Byte value) {
			addCriterion("HOUSE_PRICE_LAST_PAY_TYPE1 <=", value, "housePriceLastPayType1");
			return (Criteria) this;
		}

		public Criteria andHousePriceLastPayType1In(List<Byte> values) {
			addCriterion("HOUSE_PRICE_LAST_PAY_TYPE1 in", values, "housePriceLastPayType1");
			return (Criteria) this;
		}

		public Criteria andHousePriceLastPayType1NotIn(List<Byte> values) {
			addCriterion("HOUSE_PRICE_LAST_PAY_TYPE1 not in", values, "housePriceLastPayType1");
			return (Criteria) this;
		}

		public Criteria andHousePriceLastPayType1Between(Byte value1, Byte value2) {
			addCriterion("HOUSE_PRICE_LAST_PAY_TYPE1 between", value1, value2, "housePriceLastPayType1");
			return (Criteria) this;
		}

		public Criteria andHousePriceLastPayType1NotBetween(Byte value1, Byte value2) {
			addCriterion("HOUSE_PRICE_LAST_PAY_TYPE1 not between", value1, value2, "housePriceLastPayType1");
			return (Criteria) this;
		}

		public Criteria andHousePriceLastPayTime1IsNull() {
			addCriterion("HOUSE_PRICE_LAST_PAY_TIME1 is null");
			return (Criteria) this;
		}

		public Criteria andHousePriceLastPayTime1IsNotNull() {
			addCriterion("HOUSE_PRICE_LAST_PAY_TIME1 is not null");
			return (Criteria) this;
		}

		public Criteria andHousePriceLastPayTime1EqualTo(String value) {
			addCriterion("HOUSE_PRICE_LAST_PAY_TIME1 =", value, "housePriceLastPayTime1");
			return (Criteria) this;
		}

		public Criteria andHousePriceLastPayTime1NotEqualTo(String value) {
			addCriterion("HOUSE_PRICE_LAST_PAY_TIME1 <>", value, "housePriceLastPayTime1");
			return (Criteria) this;
		}

		public Criteria andHousePriceLastPayTime1GreaterThan(String value) {
			addCriterion("HOUSE_PRICE_LAST_PAY_TIME1 >", value, "housePriceLastPayTime1");
			return (Criteria) this;
		}

		public Criteria andHousePriceLastPayTime1GreaterThanOrEqualTo(String value) {
			addCriterion("HOUSE_PRICE_LAST_PAY_TIME1 >=", value, "housePriceLastPayTime1");
			return (Criteria) this;
		}

		public Criteria andHousePriceLastPayTime1LessThan(String value) {
			addCriterion("HOUSE_PRICE_LAST_PAY_TIME1 <", value, "housePriceLastPayTime1");
			return (Criteria) this;
		}

		public Criteria andHousePriceLastPayTime1LessThanOrEqualTo(String value) {
			addCriterion("HOUSE_PRICE_LAST_PAY_TIME1 <=", value, "housePriceLastPayTime1");
			return (Criteria) this;
		}

		public Criteria andHousePriceLastPayTime1Like(String value) {
			addCriterion("HOUSE_PRICE_LAST_PAY_TIME1 like", value, "housePriceLastPayTime1");
			return (Criteria) this;
		}

		public Criteria andHousePriceLastPayTime1NotLike(String value) {
			addCriterion("HOUSE_PRICE_LAST_PAY_TIME1 not like", value, "housePriceLastPayTime1");
			return (Criteria) this;
		}

		public Criteria andHousePriceLastPayTime1In(List<String> values) {
			addCriterion("HOUSE_PRICE_LAST_PAY_TIME1 in", values, "housePriceLastPayTime1");
			return (Criteria) this;
		}

		public Criteria andHousePriceLastPayTime1NotIn(List<String> values) {
			addCriterion("HOUSE_PRICE_LAST_PAY_TIME1 not in", values, "housePriceLastPayTime1");
			return (Criteria) this;
		}

		public Criteria andHousePriceLastPayTime1Between(String value1, String value2) {
			addCriterion("HOUSE_PRICE_LAST_PAY_TIME1 between", value1, value2, "housePriceLastPayTime1");
			return (Criteria) this;
		}

		public Criteria andHousePriceLastPayTime1NotBetween(String value1, String value2) {
			addCriterion("HOUSE_PRICE_LAST_PAY_TIME1 not between", value1, value2, "housePriceLastPayTime1");
			return (Criteria) this;
		}

		public Criteria andLoanTimeLengthIsNull() {
			addCriterion("LOAN_TIME_LENGTH is null");
			return (Criteria) this;
		}

		public Criteria andLoanTimeLengthIsNotNull() {
			addCriterion("LOAN_TIME_LENGTH is not null");
			return (Criteria) this;
		}

		public Criteria andLoanTimeLengthEqualTo(String value) {
			addCriterion("LOAN_TIME_LENGTH =", value, "loanTimeLength");
			return (Criteria) this;
		}

		public Criteria andLoanTimeLengthNotEqualTo(String value) {
			addCriterion("LOAN_TIME_LENGTH <>", value, "loanTimeLength");
			return (Criteria) this;
		}

		public Criteria andLoanTimeLengthGreaterThan(String value) {
			addCriterion("LOAN_TIME_LENGTH >", value, "loanTimeLength");
			return (Criteria) this;
		}

		public Criteria andLoanTimeLengthGreaterThanOrEqualTo(String value) {
			addCriterion("LOAN_TIME_LENGTH >=", value, "loanTimeLength");
			return (Criteria) this;
		}

		public Criteria andLoanTimeLengthLessThan(String value) {
			addCriterion("LOAN_TIME_LENGTH <", value, "loanTimeLength");
			return (Criteria) this;
		}

		public Criteria andLoanTimeLengthLessThanOrEqualTo(String value) {
			addCriterion("LOAN_TIME_LENGTH <=", value, "loanTimeLength");
			return (Criteria) this;
		}

		public Criteria andLoanTimeLengthLike(String value) {
			addCriterion("LOAN_TIME_LENGTH like", value, "loanTimeLength");
			return (Criteria) this;
		}

		public Criteria andLoanTimeLengthNotLike(String value) {
			addCriterion("LOAN_TIME_LENGTH not like", value, "loanTimeLength");
			return (Criteria) this;
		}

		public Criteria andLoanTimeLengthIn(List<String> values) {
			addCriterion("LOAN_TIME_LENGTH in", values, "loanTimeLength");
			return (Criteria) this;
		}

		public Criteria andLoanTimeLengthNotIn(List<String> values) {
			addCriterion("LOAN_TIME_LENGTH not in", values, "loanTimeLength");
			return (Criteria) this;
		}

		public Criteria andLoanTimeLengthBetween(String value1, String value2) {
			addCriterion("LOAN_TIME_LENGTH between", value1, value2, "loanTimeLength");
			return (Criteria) this;
		}

		public Criteria andLoanTimeLengthNotBetween(String value1, String value2) {
			addCriterion("LOAN_TIME_LENGTH not between", value1, value2, "loanTimeLength");
			return (Criteria) this;
		}

		public Criteria andLoanAgencyIsNull() {
			addCriterion("LOAN_AGENCY is null");
			return (Criteria) this;
		}

		public Criteria andLoanAgencyIsNotNull() {
			addCriterion("LOAN_AGENCY is not null");
			return (Criteria) this;
		}

		public Criteria andLoanAgencyEqualTo(String value) {
			addCriterion("LOAN_AGENCY =", value, "loanAgency");
			return (Criteria) this;
		}

		public Criteria andLoanAgencyNotEqualTo(String value) {
			addCriterion("LOAN_AGENCY <>", value, "loanAgency");
			return (Criteria) this;
		}

		public Criteria andLoanAgencyGreaterThan(String value) {
			addCriterion("LOAN_AGENCY >", value, "loanAgency");
			return (Criteria) this;
		}

		public Criteria andLoanAgencyGreaterThanOrEqualTo(String value) {
			addCriterion("LOAN_AGENCY >=", value, "loanAgency");
			return (Criteria) this;
		}

		public Criteria andLoanAgencyLessThan(String value) {
			addCriterion("LOAN_AGENCY <", value, "loanAgency");
			return (Criteria) this;
		}

		public Criteria andLoanAgencyLessThanOrEqualTo(String value) {
			addCriterion("LOAN_AGENCY <=", value, "loanAgency");
			return (Criteria) this;
		}

		public Criteria andLoanAgencyLike(String value) {
			addCriterion("LOAN_AGENCY like", value, "loanAgency");
			return (Criteria) this;
		}

		public Criteria andLoanAgencyNotLike(String value) {
			addCriterion("LOAN_AGENCY not like", value, "loanAgency");
			return (Criteria) this;
		}

		public Criteria andLoanAgencyIn(List<String> values) {
			addCriterion("LOAN_AGENCY in", values, "loanAgency");
			return (Criteria) this;
		}

		public Criteria andLoanAgencyNotIn(List<String> values) {
			addCriterion("LOAN_AGENCY not in", values, "loanAgency");
			return (Criteria) this;
		}

		public Criteria andLoanAgencyBetween(String value1, String value2) {
			addCriterion("LOAN_AGENCY between", value1, value2, "loanAgency");
			return (Criteria) this;
		}

		public Criteria andLoanAgencyNotBetween(String value1, String value2) {
			addCriterion("LOAN_AGENCY not between", value1, value2, "loanAgency");
			return (Criteria) this;
		}

		public Criteria andNoPassSloutionTypeIsNull() {
			addCriterion("NO_PASS_SLOUTION_TYPE is null");
			return (Criteria) this;
		}

		public Criteria andNoPassSloutionTypeIsNotNull() {
			addCriterion("NO_PASS_SLOUTION_TYPE is not null");
			return (Criteria) this;
		}

		public Criteria andNoPassSloutionTypeEqualTo(Byte value) {
			addCriterion("NO_PASS_SLOUTION_TYPE =", value, "noPassSloutionType");
			return (Criteria) this;
		}

		public Criteria andNoPassSloutionTypeNotEqualTo(Byte value) {
			addCriterion("NO_PASS_SLOUTION_TYPE <>", value, "noPassSloutionType");
			return (Criteria) this;
		}

		public Criteria andNoPassSloutionTypeGreaterThan(Byte value) {
			addCriterion("NO_PASS_SLOUTION_TYPE >", value, "noPassSloutionType");
			return (Criteria) this;
		}

		public Criteria andNoPassSloutionTypeGreaterThanOrEqualTo(Byte value) {
			addCriterion("NO_PASS_SLOUTION_TYPE >=", value, "noPassSloutionType");
			return (Criteria) this;
		}

		public Criteria andNoPassSloutionTypeLessThan(Byte value) {
			addCriterion("NO_PASS_SLOUTION_TYPE <", value, "noPassSloutionType");
			return (Criteria) this;
		}

		public Criteria andNoPassSloutionTypeLessThanOrEqualTo(Byte value) {
			addCriterion("NO_PASS_SLOUTION_TYPE <=", value, "noPassSloutionType");
			return (Criteria) this;
		}

		public Criteria andNoPassSloutionTypeIn(List<Byte> values) {
			addCriterion("NO_PASS_SLOUTION_TYPE in", values, "noPassSloutionType");
			return (Criteria) this;
		}

		public Criteria andNoPassSloutionTypeNotIn(List<Byte> values) {
			addCriterion("NO_PASS_SLOUTION_TYPE not in", values, "noPassSloutionType");
			return (Criteria) this;
		}

		public Criteria andNoPassSloutionTypeBetween(Byte value1, Byte value2) {
			addCriterion("NO_PASS_SLOUTION_TYPE between", value1, value2, "noPassSloutionType");
			return (Criteria) this;
		}

		public Criteria andNoPassSloutionTypeNotBetween(Byte value1, Byte value2) {
			addCriterion("NO_PASS_SLOUTION_TYPE not between", value1, value2, "noPassSloutionType");
			return (Criteria) this;
		}

		public Criteria andApplicationRepaymentDaysIsNull() {
			addCriterion("APPLICATION_REPAYMENT_DAYS is null");
			return (Criteria) this;
		}

		public Criteria andApplicationRepaymentDaysIsNotNull() {
			addCriterion("APPLICATION_REPAYMENT_DAYS is not null");
			return (Criteria) this;
		}

		public Criteria andApplicationRepaymentDaysEqualTo(Integer value) {
			addCriterion("APPLICATION_REPAYMENT_DAYS =", value, "applicationRepaymentDays");
			return (Criteria) this;
		}

		public Criteria andApplicationRepaymentDaysNotEqualTo(Integer value) {
			addCriterion("APPLICATION_REPAYMENT_DAYS <>", value, "applicationRepaymentDays");
			return (Criteria) this;
		}

		public Criteria andApplicationRepaymentDaysGreaterThan(Integer value) {
			addCriterion("APPLICATION_REPAYMENT_DAYS >", value, "applicationRepaymentDays");
			return (Criteria) this;
		}

		public Criteria andApplicationRepaymentDaysGreaterThanOrEqualTo(Integer value) {
			addCriterion("APPLICATION_REPAYMENT_DAYS >=", value, "applicationRepaymentDays");
			return (Criteria) this;
		}

		public Criteria andApplicationRepaymentDaysLessThan(Integer value) {
			addCriterion("APPLICATION_REPAYMENT_DAYS <", value, "applicationRepaymentDays");
			return (Criteria) this;
		}

		public Criteria andApplicationRepaymentDaysLessThanOrEqualTo(Integer value) {
			addCriterion("APPLICATION_REPAYMENT_DAYS <=", value, "applicationRepaymentDays");
			return (Criteria) this;
		}

		public Criteria andApplicationRepaymentDaysIn(List<Integer> values) {
			addCriterion("APPLICATION_REPAYMENT_DAYS in", values, "applicationRepaymentDays");
			return (Criteria) this;
		}

		public Criteria andApplicationRepaymentDaysNotIn(List<Integer> values) {
			addCriterion("APPLICATION_REPAYMENT_DAYS not in", values, "applicationRepaymentDays");
			return (Criteria) this;
		}

		public Criteria andApplicationRepaymentDaysBetween(Integer value1, Integer value2) {
			addCriterion("APPLICATION_REPAYMENT_DAYS between", value1, value2, "applicationRepaymentDays");
			return (Criteria) this;
		}

		public Criteria andApplicationRepaymentDaysNotBetween(Integer value1, Integer value2) {
			addCriterion("APPLICATION_REPAYMENT_DAYS not between", value1, value2, "applicationRepaymentDays");
			return (Criteria) this;
		}

		public Criteria andApplicationRepaymentOtherIsNull() {
			addCriterion("APPLICATION_REPAYMENT_OTHER is null");
			return (Criteria) this;
		}

		public Criteria andApplicationRepaymentOtherIsNotNull() {
			addCriterion("APPLICATION_REPAYMENT_OTHER is not null");
			return (Criteria) this;
		}

		public Criteria andApplicationRepaymentOtherEqualTo(String value) {
			addCriterion("APPLICATION_REPAYMENT_OTHER =", value, "applicationRepaymentOther");
			return (Criteria) this;
		}

		public Criteria andApplicationRepaymentOtherNotEqualTo(String value) {
			addCriterion("APPLICATION_REPAYMENT_OTHER <>", value, "applicationRepaymentOther");
			return (Criteria) this;
		}

		public Criteria andApplicationRepaymentOtherGreaterThan(String value) {
			addCriterion("APPLICATION_REPAYMENT_OTHER >", value, "applicationRepaymentOther");
			return (Criteria) this;
		}

		public Criteria andApplicationRepaymentOtherGreaterThanOrEqualTo(String value) {
			addCriterion("APPLICATION_REPAYMENT_OTHER >=", value, "applicationRepaymentOther");
			return (Criteria) this;
		}

		public Criteria andApplicationRepaymentOtherLessThan(String value) {
			addCriterion("APPLICATION_REPAYMENT_OTHER <", value, "applicationRepaymentOther");
			return (Criteria) this;
		}

		public Criteria andApplicationRepaymentOtherLessThanOrEqualTo(String value) {
			addCriterion("APPLICATION_REPAYMENT_OTHER <=", value, "applicationRepaymentOther");
			return (Criteria) this;
		}

		public Criteria andApplicationRepaymentOtherLike(String value) {
			addCriterion("APPLICATION_REPAYMENT_OTHER like", value, "applicationRepaymentOther");
			return (Criteria) this;
		}

		public Criteria andApplicationRepaymentOtherNotLike(String value) {
			addCriterion("APPLICATION_REPAYMENT_OTHER not like", value, "applicationRepaymentOther");
			return (Criteria) this;
		}

		public Criteria andApplicationRepaymentOtherIn(List<String> values) {
			addCriterion("APPLICATION_REPAYMENT_OTHER in", values, "applicationRepaymentOther");
			return (Criteria) this;
		}

		public Criteria andApplicationRepaymentOtherNotIn(List<String> values) {
			addCriterion("APPLICATION_REPAYMENT_OTHER not in", values, "applicationRepaymentOther");
			return (Criteria) this;
		}

		public Criteria andApplicationRepaymentOtherBetween(String value1, String value2) {
			addCriterion("APPLICATION_REPAYMENT_OTHER between", value1, value2, "applicationRepaymentOther");
			return (Criteria) this;
		}

		public Criteria andApplicationRepaymentOtherNotBetween(String value1, String value2) {
			addCriterion("APPLICATION_REPAYMENT_OTHER not between", value1, value2, "applicationRepaymentOther");
			return (Criteria) this;
		}

		public Criteria andOwnershipObligatiionNumberIsNull() {
			addCriterion("OWNERSHIP_OBLIGATIION_NUMBER is null");
			return (Criteria) this;
		}

		public Criteria andOwnershipObligatiionNumberIsNotNull() {
			addCriterion("OWNERSHIP_OBLIGATIION_NUMBER is not null");
			return (Criteria) this;
		}

		public Criteria andOwnershipObligatiionNumberEqualTo(String value) {
			addCriterion("OWNERSHIP_OBLIGATIION_NUMBER =", value, "ownershipObligatiionNumber");
			return (Criteria) this;
		}

		public Criteria andOwnershipObligatiionNumberNotEqualTo(String value) {
			addCriterion("OWNERSHIP_OBLIGATIION_NUMBER <>", value, "ownershipObligatiionNumber");
			return (Criteria) this;
		}

		public Criteria andOwnershipObligatiionNumberGreaterThan(String value) {
			addCriterion("OWNERSHIP_OBLIGATIION_NUMBER >", value, "ownershipObligatiionNumber");
			return (Criteria) this;
		}

		public Criteria andOwnershipObligatiionNumberGreaterThanOrEqualTo(String value) {
			addCriterion("OWNERSHIP_OBLIGATIION_NUMBER >=", value, "ownershipObligatiionNumber");
			return (Criteria) this;
		}

		public Criteria andOwnershipObligatiionNumberLessThan(String value) {
			addCriterion("OWNERSHIP_OBLIGATIION_NUMBER <", value, "ownershipObligatiionNumber");
			return (Criteria) this;
		}

		public Criteria andOwnershipObligatiionNumberLessThanOrEqualTo(String value) {
			addCriterion("OWNERSHIP_OBLIGATIION_NUMBER <=", value, "ownershipObligatiionNumber");
			return (Criteria) this;
		}

		public Criteria andOwnershipObligatiionNumberLike(String value) {
			addCriterion("OWNERSHIP_OBLIGATIION_NUMBER like", value, "ownershipObligatiionNumber");
			return (Criteria) this;
		}

		public Criteria andOwnershipObligatiionNumberNotLike(String value) {
			addCriterion("OWNERSHIP_OBLIGATIION_NUMBER not like", value, "ownershipObligatiionNumber");
			return (Criteria) this;
		}

		public Criteria andOwnershipObligatiionNumberIn(List<String> values) {
			addCriterion("OWNERSHIP_OBLIGATIION_NUMBER in", values, "ownershipObligatiionNumber");
			return (Criteria) this;
		}

		public Criteria andOwnershipObligatiionNumberNotIn(List<String> values) {
			addCriterion("OWNERSHIP_OBLIGATIION_NUMBER not in", values, "ownershipObligatiionNumber");
			return (Criteria) this;
		}

		public Criteria andOwnershipObligatiionNumberBetween(String value1, String value2) {
			addCriterion("OWNERSHIP_OBLIGATIION_NUMBER between", value1, value2, "ownershipObligatiionNumber");
			return (Criteria) this;
		}

		public Criteria andOwnershipObligatiionNumberNotBetween(String value1, String value2) {
			addCriterion("OWNERSHIP_OBLIGATIION_NUMBER not between", value1, value2, "ownershipObligatiionNumber");
			return (Criteria) this;
		}

		public Criteria andHousePropertyIsNull() {
			addCriterion("HOUSE_PROPERTY is null");
			return (Criteria) this;
		}

		public Criteria andHousePropertyIsNotNull() {
			addCriterion("HOUSE_PROPERTY is not null");
			return (Criteria) this;
		}

		public Criteria andHousePropertyEqualTo(String value) {
			addCriterion("HOUSE_PROPERTY =", value, "houseProperty");
			return (Criteria) this;
		}

		public Criteria andHousePropertyNotEqualTo(String value) {
			addCriterion("HOUSE_PROPERTY <>", value, "houseProperty");
			return (Criteria) this;
		}

		public Criteria andHousePropertyGreaterThan(String value) {
			addCriterion("HOUSE_PROPERTY >", value, "houseProperty");
			return (Criteria) this;
		}

		public Criteria andHousePropertyGreaterThanOrEqualTo(String value) {
			addCriterion("HOUSE_PROPERTY >=", value, "houseProperty");
			return (Criteria) this;
		}

		public Criteria andHousePropertyLessThan(String value) {
			addCriterion("HOUSE_PROPERTY <", value, "houseProperty");
			return (Criteria) this;
		}

		public Criteria andHousePropertyLessThanOrEqualTo(String value) {
			addCriterion("HOUSE_PROPERTY <=", value, "houseProperty");
			return (Criteria) this;
		}

		public Criteria andHousePropertyLike(String value) {
			addCriterion("HOUSE_PROPERTY like", value, "houseProperty");
			return (Criteria) this;
		}

		public Criteria andHousePropertyNotLike(String value) {
			addCriterion("HOUSE_PROPERTY not like", value, "houseProperty");
			return (Criteria) this;
		}

		public Criteria andHousePropertyIn(List<String> values) {
			addCriterion("HOUSE_PROPERTY in", values, "houseProperty");
			return (Criteria) this;
		}

		public Criteria andHousePropertyNotIn(List<String> values) {
			addCriterion("HOUSE_PROPERTY not in", values, "houseProperty");
			return (Criteria) this;
		}

		public Criteria andHousePropertyBetween(String value1, String value2) {
			addCriterion("HOUSE_PROPERTY between", value1, value2, "houseProperty");
			return (Criteria) this;
		}

		public Criteria andHousePropertyNotBetween(String value1, String value2) {
			addCriterion("HOUSE_PROPERTY not between", value1, value2, "houseProperty");
			return (Criteria) this;
		}

		public Criteria andSellerBankTypeIsNull() {
			addCriterion("SELLER_BANK_TYPE is null");
			return (Criteria) this;
		}

		public Criteria andSellerBankTypeIsNotNull() {
			addCriterion("SELLER_BANK_TYPE is not null");
			return (Criteria) this;
		}

		public Criteria andSellerBankTypeEqualTo(String value) {
			addCriterion("SELLER_BANK_TYPE =", value, "sellerBankType");
			return (Criteria) this;
		}

		public Criteria andSellerBankTypeNotEqualTo(String value) {
			addCriterion("SELLER_BANK_TYPE <>", value, "sellerBankType");
			return (Criteria) this;
		}

		public Criteria andSellerBankTypeGreaterThan(String value) {
			addCriterion("SELLER_BANK_TYPE >", value, "sellerBankType");
			return (Criteria) this;
		}

		public Criteria andSellerBankTypeGreaterThanOrEqualTo(String value) {
			addCriterion("SELLER_BANK_TYPE >=", value, "sellerBankType");
			return (Criteria) this;
		}

		public Criteria andSellerBankTypeLessThan(String value) {
			addCriterion("SELLER_BANK_TYPE <", value, "sellerBankType");
			return (Criteria) this;
		}

		public Criteria andSellerBankTypeLessThanOrEqualTo(String value) {
			addCriterion("SELLER_BANK_TYPE <=", value, "sellerBankType");
			return (Criteria) this;
		}

		public Criteria andSellerBankTypeLike(String value) {
			addCriterion("SELLER_BANK_TYPE like", value, "sellerBankType");
			return (Criteria) this;
		}

		public Criteria andSellerBankTypeNotLike(String value) {
			addCriterion("SELLER_BANK_TYPE not like", value, "sellerBankType");
			return (Criteria) this;
		}

		public Criteria andSellerBankTypeIn(List<String> values) {
			addCriterion("SELLER_BANK_TYPE in", values, "sellerBankType");
			return (Criteria) this;
		}

		public Criteria andSellerBankTypeNotIn(List<String> values) {
			addCriterion("SELLER_BANK_TYPE not in", values, "sellerBankType");
			return (Criteria) this;
		}

		public Criteria andSellerBankTypeBetween(String value1, String value2) {
			addCriterion("SELLER_BANK_TYPE between", value1, value2, "sellerBankType");
			return (Criteria) this;
		}

		public Criteria andSellerBankTypeNotBetween(String value1, String value2) {
			addCriterion("SELLER_BANK_TYPE not between", value1, value2, "sellerBankType");
			return (Criteria) this;
		}

		public Criteria andSellerBankUserNameIsNull() {
			addCriterion("SELLER_BANK_USER_NAME is null");
			return (Criteria) this;
		}

		public Criteria andSellerBankUserNameIsNotNull() {
			addCriterion("SELLER_BANK_USER_NAME is not null");
			return (Criteria) this;
		}

		public Criteria andSellerBankUserNameEqualTo(String value) {
			addCriterion("SELLER_BANK_USER_NAME =", value, "sellerBankUserName");
			return (Criteria) this;
		}

		public Criteria andSellerBankUserNameNotEqualTo(String value) {
			addCriterion("SELLER_BANK_USER_NAME <>", value, "sellerBankUserName");
			return (Criteria) this;
		}

		public Criteria andSellerBankUserNameGreaterThan(String value) {
			addCriterion("SELLER_BANK_USER_NAME >", value, "sellerBankUserName");
			return (Criteria) this;
		}

		public Criteria andSellerBankUserNameGreaterThanOrEqualTo(String value) {
			addCriterion("SELLER_BANK_USER_NAME >=", value, "sellerBankUserName");
			return (Criteria) this;
		}

		public Criteria andSellerBankUserNameLessThan(String value) {
			addCriterion("SELLER_BANK_USER_NAME <", value, "sellerBankUserName");
			return (Criteria) this;
		}

		public Criteria andSellerBankUserNameLessThanOrEqualTo(String value) {
			addCriterion("SELLER_BANK_USER_NAME <=", value, "sellerBankUserName");
			return (Criteria) this;
		}

		public Criteria andSellerBankUserNameLike(String value) {
			addCriterion("SELLER_BANK_USER_NAME like", value, "sellerBankUserName");
			return (Criteria) this;
		}

		public Criteria andSellerBankUserNameNotLike(String value) {
			addCriterion("SELLER_BANK_USER_NAME not like", value, "sellerBankUserName");
			return (Criteria) this;
		}

		public Criteria andSellerBankUserNameIn(List<String> values) {
			addCriterion("SELLER_BANK_USER_NAME in", values, "sellerBankUserName");
			return (Criteria) this;
		}

		public Criteria andSellerBankUserNameNotIn(List<String> values) {
			addCriterion("SELLER_BANK_USER_NAME not in", values, "sellerBankUserName");
			return (Criteria) this;
		}

		public Criteria andSellerBankUserNameBetween(String value1, String value2) {
			addCriterion("SELLER_BANK_USER_NAME between", value1, value2, "sellerBankUserName");
			return (Criteria) this;
		}

		public Criteria andSellerBankUserNameNotBetween(String value1, String value2) {
			addCriterion("SELLER_BANK_USER_NAME not between", value1, value2, "sellerBankUserName");
			return (Criteria) this;
		}

		public Criteria andSellerBankAccountIsNull() {
			addCriterion("SELLER_BANK_ACCOUNT is null");
			return (Criteria) this;
		}

		public Criteria andSellerBankAccountIsNotNull() {
			addCriterion("SELLER_BANK_ACCOUNT is not null");
			return (Criteria) this;
		}

		public Criteria andSellerBankAccountEqualTo(String value) {
			addCriterion("SELLER_BANK_ACCOUNT =", value, "sellerBankAccount");
			return (Criteria) this;
		}

		public Criteria andSellerBankAccountNotEqualTo(String value) {
			addCriterion("SELLER_BANK_ACCOUNT <>", value, "sellerBankAccount");
			return (Criteria) this;
		}

		public Criteria andSellerBankAccountGreaterThan(String value) {
			addCriterion("SELLER_BANK_ACCOUNT >", value, "sellerBankAccount");
			return (Criteria) this;
		}

		public Criteria andSellerBankAccountGreaterThanOrEqualTo(String value) {
			addCriterion("SELLER_BANK_ACCOUNT >=", value, "sellerBankAccount");
			return (Criteria) this;
		}

		public Criteria andSellerBankAccountLessThan(String value) {
			addCriterion("SELLER_BANK_ACCOUNT <", value, "sellerBankAccount");
			return (Criteria) this;
		}

		public Criteria andSellerBankAccountLessThanOrEqualTo(String value) {
			addCriterion("SELLER_BANK_ACCOUNT <=", value, "sellerBankAccount");
			return (Criteria) this;
		}

		public Criteria andSellerBankAccountLike(String value) {
			addCriterion("SELLER_BANK_ACCOUNT like", value, "sellerBankAccount");
			return (Criteria) this;
		}

		public Criteria andSellerBankAccountNotLike(String value) {
			addCriterion("SELLER_BANK_ACCOUNT not like", value, "sellerBankAccount");
			return (Criteria) this;
		}

		public Criteria andSellerBankAccountIn(List<String> values) {
			addCriterion("SELLER_BANK_ACCOUNT in", values, "sellerBankAccount");
			return (Criteria) this;
		}

		public Criteria andSellerBankAccountNotIn(List<String> values) {
			addCriterion("SELLER_BANK_ACCOUNT not in", values, "sellerBankAccount");
			return (Criteria) this;
		}

		public Criteria andSellerBankAccountBetween(String value1, String value2) {
			addCriterion("SELLER_BANK_ACCOUNT between", value1, value2, "sellerBankAccount");
			return (Criteria) this;
		}

		public Criteria andSellerBankAccountNotBetween(String value1, String value2) {
			addCriterion("SELLER_BANK_ACCOUNT not between", value1, value2, "sellerBankAccount");
			return (Criteria) this;
		}

		public Criteria andBuyerBankTypeIsNull() {
			addCriterion("BUYER_BANK_TYPE is null");
			return (Criteria) this;
		}

		public Criteria andBuyerBankTypeIsNotNull() {
			addCriterion("BUYER_BANK_TYPE is not null");
			return (Criteria) this;
		}

		public Criteria andBuyerBankTypeEqualTo(String value) {
			addCriterion("BUYER_BANK_TYPE =", value, "buyerBankType");
			return (Criteria) this;
		}

		public Criteria andBuyerBankTypeNotEqualTo(String value) {
			addCriterion("BUYER_BANK_TYPE <>", value, "buyerBankType");
			return (Criteria) this;
		}

		public Criteria andBuyerBankTypeGreaterThan(String value) {
			addCriterion("BUYER_BANK_TYPE >", value, "buyerBankType");
			return (Criteria) this;
		}

		public Criteria andBuyerBankTypeGreaterThanOrEqualTo(String value) {
			addCriterion("BUYER_BANK_TYPE >=", value, "buyerBankType");
			return (Criteria) this;
		}

		public Criteria andBuyerBankTypeLessThan(String value) {
			addCriterion("BUYER_BANK_TYPE <", value, "buyerBankType");
			return (Criteria) this;
		}

		public Criteria andBuyerBankTypeLessThanOrEqualTo(String value) {
			addCriterion("BUYER_BANK_TYPE <=", value, "buyerBankType");
			return (Criteria) this;
		}

		public Criteria andBuyerBankTypeLike(String value) {
			addCriterion("BUYER_BANK_TYPE like", value, "buyerBankType");
			return (Criteria) this;
		}

		public Criteria andBuyerBankTypeNotLike(String value) {
			addCriterion("BUYER_BANK_TYPE not like", value, "buyerBankType");
			return (Criteria) this;
		}

		public Criteria andBuyerBankTypeIn(List<String> values) {
			addCriterion("BUYER_BANK_TYPE in", values, "buyerBankType");
			return (Criteria) this;
		}

		public Criteria andBuyerBankTypeNotIn(List<String> values) {
			addCriterion("BUYER_BANK_TYPE not in", values, "buyerBankType");
			return (Criteria) this;
		}

		public Criteria andBuyerBankTypeBetween(String value1, String value2) {
			addCriterion("BUYER_BANK_TYPE between", value1, value2, "buyerBankType");
			return (Criteria) this;
		}

		public Criteria andBuyerBankTypeNotBetween(String value1, String value2) {
			addCriterion("BUYER_BANK_TYPE not between", value1, value2, "buyerBankType");
			return (Criteria) this;
		}

		public Criteria andBuyerBankUserNameIsNull() {
			addCriterion("BUYER_BANK_USER_NAME is null");
			return (Criteria) this;
		}

		public Criteria andBuyerBankUserNameIsNotNull() {
			addCriterion("BUYER_BANK_USER_NAME is not null");
			return (Criteria) this;
		}

		public Criteria andBuyerBankUserNameEqualTo(String value) {
			addCriterion("BUYER_BANK_USER_NAME =", value, "buyerBankUserName");
			return (Criteria) this;
		}

		public Criteria andBuyerBankUserNameNotEqualTo(String value) {
			addCriterion("BUYER_BANK_USER_NAME <>", value, "buyerBankUserName");
			return (Criteria) this;
		}

		public Criteria andBuyerBankUserNameGreaterThan(String value) {
			addCriterion("BUYER_BANK_USER_NAME >", value, "buyerBankUserName");
			return (Criteria) this;
		}

		public Criteria andBuyerBankUserNameGreaterThanOrEqualTo(String value) {
			addCriterion("BUYER_BANK_USER_NAME >=", value, "buyerBankUserName");
			return (Criteria) this;
		}

		public Criteria andBuyerBankUserNameLessThan(String value) {
			addCriterion("BUYER_BANK_USER_NAME <", value, "buyerBankUserName");
			return (Criteria) this;
		}

		public Criteria andBuyerBankUserNameLessThanOrEqualTo(String value) {
			addCriterion("BUYER_BANK_USER_NAME <=", value, "buyerBankUserName");
			return (Criteria) this;
		}

		public Criteria andBuyerBankUserNameLike(String value) {
			addCriterion("BUYER_BANK_USER_NAME like", value, "buyerBankUserName");
			return (Criteria) this;
		}

		public Criteria andBuyerBankUserNameNotLike(String value) {
			addCriterion("BUYER_BANK_USER_NAME not like", value, "buyerBankUserName");
			return (Criteria) this;
		}

		public Criteria andBuyerBankUserNameIn(List<String> values) {
			addCriterion("BUYER_BANK_USER_NAME in", values, "buyerBankUserName");
			return (Criteria) this;
		}

		public Criteria andBuyerBankUserNameNotIn(List<String> values) {
			addCriterion("BUYER_BANK_USER_NAME not in", values, "buyerBankUserName");
			return (Criteria) this;
		}

		public Criteria andBuyerBankUserNameBetween(String value1, String value2) {
			addCriterion("BUYER_BANK_USER_NAME between", value1, value2, "buyerBankUserName");
			return (Criteria) this;
		}

		public Criteria andBuyerBankUserNameNotBetween(String value1, String value2) {
			addCriterion("BUYER_BANK_USER_NAME not between", value1, value2, "buyerBankUserName");
			return (Criteria) this;
		}

		public Criteria andBuyerBankAccountIsNull() {
			addCriterion("BUYER_BANK_ACCOUNT is null");
			return (Criteria) this;
		}

		public Criteria andBuyerBankAccountIsNotNull() {
			addCriterion("BUYER_BANK_ACCOUNT is not null");
			return (Criteria) this;
		}

		public Criteria andBuyerBankAccountEqualTo(String value) {
			addCriterion("BUYER_BANK_ACCOUNT =", value, "buyerBankAccount");
			return (Criteria) this;
		}

		public Criteria andBuyerBankAccountNotEqualTo(String value) {
			addCriterion("BUYER_BANK_ACCOUNT <>", value, "buyerBankAccount");
			return (Criteria) this;
		}

		public Criteria andBuyerBankAccountGreaterThan(String value) {
			addCriterion("BUYER_BANK_ACCOUNT >", value, "buyerBankAccount");
			return (Criteria) this;
		}

		public Criteria andBuyerBankAccountGreaterThanOrEqualTo(String value) {
			addCriterion("BUYER_BANK_ACCOUNT >=", value, "buyerBankAccount");
			return (Criteria) this;
		}

		public Criteria andBuyerBankAccountLessThan(String value) {
			addCriterion("BUYER_BANK_ACCOUNT <", value, "buyerBankAccount");
			return (Criteria) this;
		}

		public Criteria andBuyerBankAccountLessThanOrEqualTo(String value) {
			addCriterion("BUYER_BANK_ACCOUNT <=", value, "buyerBankAccount");
			return (Criteria) this;
		}

		public Criteria andBuyerBankAccountLike(String value) {
			addCriterion("BUYER_BANK_ACCOUNT like", value, "buyerBankAccount");
			return (Criteria) this;
		}

		public Criteria andBuyerBankAccountNotLike(String value) {
			addCriterion("BUYER_BANK_ACCOUNT not like", value, "buyerBankAccount");
			return (Criteria) this;
		}

		public Criteria andBuyerBankAccountIn(List<String> values) {
			addCriterion("BUYER_BANK_ACCOUNT in", values, "buyerBankAccount");
			return (Criteria) this;
		}

		public Criteria andBuyerBankAccountNotIn(List<String> values) {
			addCriterion("BUYER_BANK_ACCOUNT not in", values, "buyerBankAccount");
			return (Criteria) this;
		}

		public Criteria andBuyerBankAccountBetween(String value1, String value2) {
			addCriterion("BUYER_BANK_ACCOUNT between", value1, value2, "buyerBankAccount");
			return (Criteria) this;
		}

		public Criteria andBuyerBankAccountNotBetween(String value1, String value2) {
			addCriterion("BUYER_BANK_ACCOUNT not between", value1, value2, "buyerBankAccount");
			return (Criteria) this;
		}

		public Criteria andDownPaymentsPayType2IsNull() {
			addCriterion("DOWN_PAYMENTS_PAY_TYPE2 is null");
			return (Criteria) this;
		}

		public Criteria andDownPaymentsPayType2IsNotNull() {
			addCriterion("DOWN_PAYMENTS_PAY_TYPE2 is not null");
			return (Criteria) this;
		}

		public Criteria andDownPaymentsPayType2EqualTo(Byte value) {
			addCriterion("DOWN_PAYMENTS_PAY_TYPE2 =", value, "downPaymentsPayType2");
			return (Criteria) this;
		}

		public Criteria andDownPaymentsPayType2NotEqualTo(Byte value) {
			addCriterion("DOWN_PAYMENTS_PAY_TYPE2 <>", value, "downPaymentsPayType2");
			return (Criteria) this;
		}

		public Criteria andDownPaymentsPayType2GreaterThan(Byte value) {
			addCriterion("DOWN_PAYMENTS_PAY_TYPE2 >", value, "downPaymentsPayType2");
			return (Criteria) this;
		}

		public Criteria andDownPaymentsPayType2GreaterThanOrEqualTo(Byte value) {
			addCriterion("DOWN_PAYMENTS_PAY_TYPE2 >=", value, "downPaymentsPayType2");
			return (Criteria) this;
		}

		public Criteria andDownPaymentsPayType2LessThan(Byte value) {
			addCriterion("DOWN_PAYMENTS_PAY_TYPE2 <", value, "downPaymentsPayType2");
			return (Criteria) this;
		}

		public Criteria andDownPaymentsPayType2LessThanOrEqualTo(Byte value) {
			addCriterion("DOWN_PAYMENTS_PAY_TYPE2 <=", value, "downPaymentsPayType2");
			return (Criteria) this;
		}

		public Criteria andDownPaymentsPayType2In(List<Byte> values) {
			addCriterion("DOWN_PAYMENTS_PAY_TYPE2 in", values, "downPaymentsPayType2");
			return (Criteria) this;
		}

		public Criteria andDownPaymentsPayType2NotIn(List<Byte> values) {
			addCriterion("DOWN_PAYMENTS_PAY_TYPE2 not in", values, "downPaymentsPayType2");
			return (Criteria) this;
		}

		public Criteria andDownPaymentsPayType2Between(Byte value1, Byte value2) {
			addCriterion("DOWN_PAYMENTS_PAY_TYPE2 between", value1, value2, "downPaymentsPayType2");
			return (Criteria) this;
		}

		public Criteria andDownPaymentsPayType2NotBetween(Byte value1, Byte value2) {
			addCriterion("DOWN_PAYMENTS_PAY_TYPE2 not between", value1, value2, "downPaymentsPayType2");
			return (Criteria) this;
		}

		public Criteria andDownPaymentsPayTime2IsNull() {
			addCriterion("DOWN_PAYMENTS_PAY_TIME2 is null");
			return (Criteria) this;
		}

		public Criteria andDownPaymentsPayTime2IsNotNull() {
			addCriterion("DOWN_PAYMENTS_PAY_TIME2 is not null");
			return (Criteria) this;
		}

		public Criteria andDownPaymentsPayTime2EqualTo(String value) {
			addCriterion("DOWN_PAYMENTS_PAY_TIME2 =", value, "downPaymentsPayTime2");
			return (Criteria) this;
		}

		public Criteria andDownPaymentsPayTime2NotEqualTo(String value) {
			addCriterion("DOWN_PAYMENTS_PAY_TIME2 <>", value, "downPaymentsPayTime2");
			return (Criteria) this;
		}

		public Criteria andDownPaymentsPayTime2GreaterThan(String value) {
			addCriterion("DOWN_PAYMENTS_PAY_TIME2 >", value, "downPaymentsPayTime2");
			return (Criteria) this;
		}

		public Criteria andDownPaymentsPayTime2GreaterThanOrEqualTo(String value) {
			addCriterion("DOWN_PAYMENTS_PAY_TIME2 >=", value, "downPaymentsPayTime2");
			return (Criteria) this;
		}

		public Criteria andDownPaymentsPayTime2LessThan(String value) {
			addCriterion("DOWN_PAYMENTS_PAY_TIME2 <", value, "downPaymentsPayTime2");
			return (Criteria) this;
		}

		public Criteria andDownPaymentsPayTime2LessThanOrEqualTo(String value) {
			addCriterion("DOWN_PAYMENTS_PAY_TIME2 <=", value, "downPaymentsPayTime2");
			return (Criteria) this;
		}

		public Criteria andDownPaymentsPayTime2Like(String value) {
			addCriterion("DOWN_PAYMENTS_PAY_TIME2 like", value, "downPaymentsPayTime2");
			return (Criteria) this;
		}

		public Criteria andDownPaymentsPayTime2NotLike(String value) {
			addCriterion("DOWN_PAYMENTS_PAY_TIME2 not like", value, "downPaymentsPayTime2");
			return (Criteria) this;
		}

		public Criteria andDownPaymentsPayTime2In(List<String> values) {
			addCriterion("DOWN_PAYMENTS_PAY_TIME2 in", values, "downPaymentsPayTime2");
			return (Criteria) this;
		}

		public Criteria andDownPaymentsPayTime2NotIn(List<String> values) {
			addCriterion("DOWN_PAYMENTS_PAY_TIME2 not in", values, "downPaymentsPayTime2");
			return (Criteria) this;
		}

		public Criteria andDownPaymentsPayTime2Between(String value1, String value2) {
			addCriterion("DOWN_PAYMENTS_PAY_TIME2 between", value1, value2, "downPaymentsPayTime2");
			return (Criteria) this;
		}

		public Criteria andDownPaymentsPayTime2NotBetween(String value1, String value2) {
			addCriterion("DOWN_PAYMENTS_PAY_TIME2 not between", value1, value2, "downPaymentsPayTime2");
			return (Criteria) this;
		}

		public Criteria andDownPaymentsPayType3IsNull() {
			addCriterion("DOWN_PAYMENTS_PAY_TYPE3 is null");
			return (Criteria) this;
		}

		public Criteria andDownPaymentsPayType3IsNotNull() {
			addCriterion("DOWN_PAYMENTS_PAY_TYPE3 is not null");
			return (Criteria) this;
		}

		public Criteria andDownPaymentsPayType3EqualTo(Byte value) {
			addCriterion("DOWN_PAYMENTS_PAY_TYPE3 =", value, "downPaymentsPayType3");
			return (Criteria) this;
		}

		public Criteria andDownPaymentsPayType3NotEqualTo(Byte value) {
			addCriterion("DOWN_PAYMENTS_PAY_TYPE3 <>", value, "downPaymentsPayType3");
			return (Criteria) this;
		}

		public Criteria andDownPaymentsPayType3GreaterThan(Byte value) {
			addCriterion("DOWN_PAYMENTS_PAY_TYPE3 >", value, "downPaymentsPayType3");
			return (Criteria) this;
		}

		public Criteria andDownPaymentsPayType3GreaterThanOrEqualTo(Byte value) {
			addCriterion("DOWN_PAYMENTS_PAY_TYPE3 >=", value, "downPaymentsPayType3");
			return (Criteria) this;
		}

		public Criteria andDownPaymentsPayType3LessThan(Byte value) {
			addCriterion("DOWN_PAYMENTS_PAY_TYPE3 <", value, "downPaymentsPayType3");
			return (Criteria) this;
		}

		public Criteria andDownPaymentsPayType3LessThanOrEqualTo(Byte value) {
			addCriterion("DOWN_PAYMENTS_PAY_TYPE3 <=", value, "downPaymentsPayType3");
			return (Criteria) this;
		}

		public Criteria andDownPaymentsPayType3In(List<Byte> values) {
			addCriterion("DOWN_PAYMENTS_PAY_TYPE3 in", values, "downPaymentsPayType3");
			return (Criteria) this;
		}

		public Criteria andDownPaymentsPayType3NotIn(List<Byte> values) {
			addCriterion("DOWN_PAYMENTS_PAY_TYPE3 not in", values, "downPaymentsPayType3");
			return (Criteria) this;
		}

		public Criteria andDownPaymentsPayType3Between(Byte value1, Byte value2) {
			addCriterion("DOWN_PAYMENTS_PAY_TYPE3 between", value1, value2, "downPaymentsPayType3");
			return (Criteria) this;
		}

		public Criteria andDownPaymentsPayType3NotBetween(Byte value1, Byte value2) {
			addCriterion("DOWN_PAYMENTS_PAY_TYPE3 not between", value1, value2, "downPaymentsPayType3");
			return (Criteria) this;
		}

		public Criteria andDownPaymentsPayTime3IsNull() {
			addCriterion("DOWN_PAYMENTS_PAY_TIME3 is null");
			return (Criteria) this;
		}

		public Criteria andDownPaymentsPayTime3IsNotNull() {
			addCriterion("DOWN_PAYMENTS_PAY_TIME3 is not null");
			return (Criteria) this;
		}

		public Criteria andDownPaymentsPayTime3EqualTo(String value) {
			addCriterion("DOWN_PAYMENTS_PAY_TIME3 =", value, "downPaymentsPayTime3");
			return (Criteria) this;
		}

		public Criteria andDownPaymentsPayTime3NotEqualTo(String value) {
			addCriterion("DOWN_PAYMENTS_PAY_TIME3 <>", value, "downPaymentsPayTime3");
			return (Criteria) this;
		}

		public Criteria andDownPaymentsPayTime3GreaterThan(String value) {
			addCriterion("DOWN_PAYMENTS_PAY_TIME3 >", value, "downPaymentsPayTime3");
			return (Criteria) this;
		}

		public Criteria andDownPaymentsPayTime3GreaterThanOrEqualTo(String value) {
			addCriterion("DOWN_PAYMENTS_PAY_TIME3 >=", value, "downPaymentsPayTime3");
			return (Criteria) this;
		}

		public Criteria andDownPaymentsPayTime3LessThan(String value) {
			addCriterion("DOWN_PAYMENTS_PAY_TIME3 <", value, "downPaymentsPayTime3");
			return (Criteria) this;
		}

		public Criteria andDownPaymentsPayTime3LessThanOrEqualTo(String value) {
			addCriterion("DOWN_PAYMENTS_PAY_TIME3 <=", value, "downPaymentsPayTime3");
			return (Criteria) this;
		}

		public Criteria andDownPaymentsPayTime3Like(String value) {
			addCriterion("DOWN_PAYMENTS_PAY_TIME3 like", value, "downPaymentsPayTime3");
			return (Criteria) this;
		}

		public Criteria andDownPaymentsPayTime3NotLike(String value) {
			addCriterion("DOWN_PAYMENTS_PAY_TIME3 not like", value, "downPaymentsPayTime3");
			return (Criteria) this;
		}

		public Criteria andDownPaymentsPayTime3In(List<String> values) {
			addCriterion("DOWN_PAYMENTS_PAY_TIME3 in", values, "downPaymentsPayTime3");
			return (Criteria) this;
		}

		public Criteria andDownPaymentsPayTime3NotIn(List<String> values) {
			addCriterion("DOWN_PAYMENTS_PAY_TIME3 not in", values, "downPaymentsPayTime3");
			return (Criteria) this;
		}

		public Criteria andDownPaymentsPayTime3Between(String value1, String value2) {
			addCriterion("DOWN_PAYMENTS_PAY_TIME3 between", value1, value2, "downPaymentsPayTime3");
			return (Criteria) this;
		}

		public Criteria andDownPaymentsPayTime3NotBetween(String value1, String value2) {
			addCriterion("DOWN_PAYMENTS_PAY_TIME3 not between", value1, value2, "downPaymentsPayTime3");
			return (Criteria) this;
		}

		public Criteria andHousePriceLastPayType2IsNull() {
			addCriterion("HOUSE_PRICE_LAST_PAY_TYPE2 is null");
			return (Criteria) this;
		}

		public Criteria andHousePriceLastPayType2IsNotNull() {
			addCriterion("HOUSE_PRICE_LAST_PAY_TYPE2 is not null");
			return (Criteria) this;
		}

		public Criteria andHousePriceLastPayType2EqualTo(Byte value) {
			addCriterion("HOUSE_PRICE_LAST_PAY_TYPE2 =", value, "housePriceLastPayType2");
			return (Criteria) this;
		}

		public Criteria andHousePriceLastPayType2NotEqualTo(Byte value) {
			addCriterion("HOUSE_PRICE_LAST_PAY_TYPE2 <>", value, "housePriceLastPayType2");
			return (Criteria) this;
		}

		public Criteria andHousePriceLastPayType2GreaterThan(Byte value) {
			addCriterion("HOUSE_PRICE_LAST_PAY_TYPE2 >", value, "housePriceLastPayType2");
			return (Criteria) this;
		}

		public Criteria andHousePriceLastPayType2GreaterThanOrEqualTo(Byte value) {
			addCriterion("HOUSE_PRICE_LAST_PAY_TYPE2 >=", value, "housePriceLastPayType2");
			return (Criteria) this;
		}

		public Criteria andHousePriceLastPayType2LessThan(Byte value) {
			addCriterion("HOUSE_PRICE_LAST_PAY_TYPE2 <", value, "housePriceLastPayType2");
			return (Criteria) this;
		}

		public Criteria andHousePriceLastPayType2LessThanOrEqualTo(Byte value) {
			addCriterion("HOUSE_PRICE_LAST_PAY_TYPE2 <=", value, "housePriceLastPayType2");
			return (Criteria) this;
		}

		public Criteria andHousePriceLastPayType2In(List<Byte> values) {
			addCriterion("HOUSE_PRICE_LAST_PAY_TYPE2 in", values, "housePriceLastPayType2");
			return (Criteria) this;
		}

		public Criteria andHousePriceLastPayType2NotIn(List<Byte> values) {
			addCriterion("HOUSE_PRICE_LAST_PAY_TYPE2 not in", values, "housePriceLastPayType2");
			return (Criteria) this;
		}

		public Criteria andHousePriceLastPayType2Between(Byte value1, Byte value2) {
			addCriterion("HOUSE_PRICE_LAST_PAY_TYPE2 between", value1, value2, "housePriceLastPayType2");
			return (Criteria) this;
		}

		public Criteria andHousePriceLastPayType2NotBetween(Byte value1, Byte value2) {
			addCriterion("HOUSE_PRICE_LAST_PAY_TYPE2 not between", value1, value2, "housePriceLastPayType2");
			return (Criteria) this;
		}

		public Criteria andHousePriceLastPayTime2IsNull() {
			addCriterion("HOUSE_PRICE_LAST_PAY_TIME2 is null");
			return (Criteria) this;
		}

		public Criteria andHousePriceLastPayTime2IsNotNull() {
			addCriterion("HOUSE_PRICE_LAST_PAY_TIME2 is not null");
			return (Criteria) this;
		}

		public Criteria andHousePriceLastPayTime2EqualTo(String value) {
			addCriterion("HOUSE_PRICE_LAST_PAY_TIME2 =", value, "housePriceLastPayTime2");
			return (Criteria) this;
		}

		public Criteria andHousePriceLastPayTime2NotEqualTo(String value) {
			addCriterion("HOUSE_PRICE_LAST_PAY_TIME2 <>", value, "housePriceLastPayTime2");
			return (Criteria) this;
		}

		public Criteria andHousePriceLastPayTime2GreaterThan(String value) {
			addCriterion("HOUSE_PRICE_LAST_PAY_TIME2 >", value, "housePriceLastPayTime2");
			return (Criteria) this;
		}

		public Criteria andHousePriceLastPayTime2GreaterThanOrEqualTo(String value) {
			addCriterion("HOUSE_PRICE_LAST_PAY_TIME2 >=", value, "housePriceLastPayTime2");
			return (Criteria) this;
		}

		public Criteria andHousePriceLastPayTime2LessThan(String value) {
			addCriterion("HOUSE_PRICE_LAST_PAY_TIME2 <", value, "housePriceLastPayTime2");
			return (Criteria) this;
		}

		public Criteria andHousePriceLastPayTime2LessThanOrEqualTo(String value) {
			addCriterion("HOUSE_PRICE_LAST_PAY_TIME2 <=", value, "housePriceLastPayTime2");
			return (Criteria) this;
		}

		public Criteria andHousePriceLastPayTime2Like(String value) {
			addCriterion("HOUSE_PRICE_LAST_PAY_TIME2 like", value, "housePriceLastPayTime2");
			return (Criteria) this;
		}

		public Criteria andHousePriceLastPayTime2NotLike(String value) {
			addCriterion("HOUSE_PRICE_LAST_PAY_TIME2 not like", value, "housePriceLastPayTime2");
			return (Criteria) this;
		}

		public Criteria andHousePriceLastPayTime2In(List<String> values) {
			addCriterion("HOUSE_PRICE_LAST_PAY_TIME2 in", values, "housePriceLastPayTime2");
			return (Criteria) this;
		}

		public Criteria andHousePriceLastPayTime2NotIn(List<String> values) {
			addCriterion("HOUSE_PRICE_LAST_PAY_TIME2 not in", values, "housePriceLastPayTime2");
			return (Criteria) this;
		}

		public Criteria andHousePriceLastPayTime2Between(String value1, String value2) {
			addCriterion("HOUSE_PRICE_LAST_PAY_TIME2 between", value1, value2, "housePriceLastPayTime2");
			return (Criteria) this;
		}

		public Criteria andHousePriceLastPayTime2NotBetween(String value1, String value2) {
			addCriterion("HOUSE_PRICE_LAST_PAY_TIME2 not between", value1, value2, "housePriceLastPayTime2");
			return (Criteria) this;
		}

		public Criteria andHousePriceLastPayType3IsNull() {
			addCriterion("HOUSE_PRICE_LAST_PAY_TYPE3 is null");
			return (Criteria) this;
		}

		public Criteria andHousePriceLastPayType3IsNotNull() {
			addCriterion("HOUSE_PRICE_LAST_PAY_TYPE3 is not null");
			return (Criteria) this;
		}

		public Criteria andHousePriceLastPayType3EqualTo(Byte value) {
			addCriterion("HOUSE_PRICE_LAST_PAY_TYPE3 =", value, "housePriceLastPayType3");
			return (Criteria) this;
		}

		public Criteria andHousePriceLastPayType3NotEqualTo(Byte value) {
			addCriterion("HOUSE_PRICE_LAST_PAY_TYPE3 <>", value, "housePriceLastPayType3");
			return (Criteria) this;
		}

		public Criteria andHousePriceLastPayType3GreaterThan(Byte value) {
			addCriterion("HOUSE_PRICE_LAST_PAY_TYPE3 >", value, "housePriceLastPayType3");
			return (Criteria) this;
		}

		public Criteria andHousePriceLastPayType3GreaterThanOrEqualTo(Byte value) {
			addCriterion("HOUSE_PRICE_LAST_PAY_TYPE3 >=", value, "housePriceLastPayType3");
			return (Criteria) this;
		}

		public Criteria andHousePriceLastPayType3LessThan(Byte value) {
			addCriterion("HOUSE_PRICE_LAST_PAY_TYPE3 <", value, "housePriceLastPayType3");
			return (Criteria) this;
		}

		public Criteria andHousePriceLastPayType3LessThanOrEqualTo(Byte value) {
			addCriterion("HOUSE_PRICE_LAST_PAY_TYPE3 <=", value, "housePriceLastPayType3");
			return (Criteria) this;
		}

		public Criteria andHousePriceLastPayType3In(List<Byte> values) {
			addCriterion("HOUSE_PRICE_LAST_PAY_TYPE3 in", values, "housePriceLastPayType3");
			return (Criteria) this;
		}

		public Criteria andHousePriceLastPayType3NotIn(List<Byte> values) {
			addCriterion("HOUSE_PRICE_LAST_PAY_TYPE3 not in", values, "housePriceLastPayType3");
			return (Criteria) this;
		}

		public Criteria andHousePriceLastPayType3Between(Byte value1, Byte value2) {
			addCriterion("HOUSE_PRICE_LAST_PAY_TYPE3 between", value1, value2, "housePriceLastPayType3");
			return (Criteria) this;
		}

		public Criteria andHousePriceLastPayType3NotBetween(Byte value1, Byte value2) {
			addCriterion("HOUSE_PRICE_LAST_PAY_TYPE3 not between", value1, value2, "housePriceLastPayType3");
			return (Criteria) this;
		}

		public Criteria andHousePriceLastPayTime3IsNull() {
			addCriterion("HOUSE_PRICE_LAST_PAY_TIME3 is null");
			return (Criteria) this;
		}

		public Criteria andHousePriceLastPayTime3IsNotNull() {
			addCriterion("HOUSE_PRICE_LAST_PAY_TIME3 is not null");
			return (Criteria) this;
		}

		public Criteria andHousePriceLastPayTime3EqualTo(String value) {
			addCriterion("HOUSE_PRICE_LAST_PAY_TIME3 =", value, "housePriceLastPayTime3");
			return (Criteria) this;
		}

		public Criteria andHousePriceLastPayTime3NotEqualTo(String value) {
			addCriterion("HOUSE_PRICE_LAST_PAY_TIME3 <>", value, "housePriceLastPayTime3");
			return (Criteria) this;
		}

		public Criteria andHousePriceLastPayTime3GreaterThan(String value) {
			addCriterion("HOUSE_PRICE_LAST_PAY_TIME3 >", value, "housePriceLastPayTime3");
			return (Criteria) this;
		}

		public Criteria andHousePriceLastPayTime3GreaterThanOrEqualTo(String value) {
			addCriterion("HOUSE_PRICE_LAST_PAY_TIME3 >=", value, "housePriceLastPayTime3");
			return (Criteria) this;
		}

		public Criteria andHousePriceLastPayTime3LessThan(String value) {
			addCriterion("HOUSE_PRICE_LAST_PAY_TIME3 <", value, "housePriceLastPayTime3");
			return (Criteria) this;
		}

		public Criteria andHousePriceLastPayTime3LessThanOrEqualTo(String value) {
			addCriterion("HOUSE_PRICE_LAST_PAY_TIME3 <=", value, "housePriceLastPayTime3");
			return (Criteria) this;
		}

		public Criteria andHousePriceLastPayTime3Like(String value) {
			addCriterion("HOUSE_PRICE_LAST_PAY_TIME3 like", value, "housePriceLastPayTime3");
			return (Criteria) this;
		}

		public Criteria andHousePriceLastPayTime3NotLike(String value) {
			addCriterion("HOUSE_PRICE_LAST_PAY_TIME3 not like", value, "housePriceLastPayTime3");
			return (Criteria) this;
		}

		public Criteria andHousePriceLastPayTime3In(List<String> values) {
			addCriterion("HOUSE_PRICE_LAST_PAY_TIME3 in", values, "housePriceLastPayTime3");
			return (Criteria) this;
		}

		public Criteria andHousePriceLastPayTime3NotIn(List<String> values) {
			addCriterion("HOUSE_PRICE_LAST_PAY_TIME3 not in", values, "housePriceLastPayTime3");
			return (Criteria) this;
		}

		public Criteria andHousePriceLastPayTime3Between(String value1, String value2) {
			addCriterion("HOUSE_PRICE_LAST_PAY_TIME3 between", value1, value2, "housePriceLastPayTime3");
			return (Criteria) this;
		}

		public Criteria andHousePriceLastPayTime3NotBetween(String value1, String value2) {
			addCriterion("HOUSE_PRICE_LAST_PAY_TIME3 not between", value1, value2, "housePriceLastPayTime3");
			return (Criteria) this;
		}

		public Criteria andTransferDateStrIsNull() {
			addCriterion("TRANSFER_DATE_STR is null");
			return (Criteria) this;
		}

		public Criteria andTransferDateStrIsNotNull() {
			addCriterion("TRANSFER_DATE_STR is not null");
			return (Criteria) this;
		}

		public Criteria andTransferDateStrEqualTo(String value) {
			addCriterion("TRANSFER_DATE_STR =", value, "transferDateStr");
			return (Criteria) this;
		}

		public Criteria andTransferDateStrNotEqualTo(String value) {
			addCriterion("TRANSFER_DATE_STR <>", value, "transferDateStr");
			return (Criteria) this;
		}

		public Criteria andTransferDateStrGreaterThan(String value) {
			addCriterion("TRANSFER_DATE_STR >", value, "transferDateStr");
			return (Criteria) this;
		}

		public Criteria andTransferDateStrGreaterThanOrEqualTo(String value) {
			addCriterion("TRANSFER_DATE_STR >=", value, "transferDateStr");
			return (Criteria) this;
		}

		public Criteria andTransferDateStrLessThan(String value) {
			addCriterion("TRANSFER_DATE_STR <", value, "transferDateStr");
			return (Criteria) this;
		}

		public Criteria andTransferDateStrLessThanOrEqualTo(String value) {
			addCriterion("TRANSFER_DATE_STR <=", value, "transferDateStr");
			return (Criteria) this;
		}

		public Criteria andTransferDateStrLike(String value) {
			addCriterion("TRANSFER_DATE_STR like", value, "transferDateStr");
			return (Criteria) this;
		}

		public Criteria andTransferDateStrNotLike(String value) {
			addCriterion("TRANSFER_DATE_STR not like", value, "transferDateStr");
			return (Criteria) this;
		}

		public Criteria andTransferDateStrIn(List<String> values) {
			addCriterion("TRANSFER_DATE_STR in", values, "transferDateStr");
			return (Criteria) this;
		}

		public Criteria andTransferDateStrNotIn(List<String> values) {
			addCriterion("TRANSFER_DATE_STR not in", values, "transferDateStr");
			return (Criteria) this;
		}

		public Criteria andTransferDateStrBetween(String value1, String value2) {
			addCriterion("TRANSFER_DATE_STR between", value1, value2, "transferDateStr");
			return (Criteria) this;
		}

		public Criteria andTransferDateStrNotBetween(String value1, String value2) {
			addCriterion("TRANSFER_DATE_STR not between", value1, value2, "transferDateStr");
			return (Criteria) this;
		}

		public Criteria andTransferDateDaysPickupIsNull() {
			addCriterion("TRANSFER_DATE_DAYS_PICKUP is null");
			return (Criteria) this;
		}

		public Criteria andTransferDateDaysPickupIsNotNull() {
			addCriterion("TRANSFER_DATE_DAYS_PICKUP is not null");
			return (Criteria) this;
		}

		public Criteria andTransferDateDaysPickupEqualTo(Integer value) {
			addCriterion("TRANSFER_DATE_DAYS_PICKUP =", value, "transferDateDaysPickup");
			return (Criteria) this;
		}

		public Criteria andTransferDateDaysPickupNotEqualTo(Integer value) {
			addCriterion("TRANSFER_DATE_DAYS_PICKUP <>", value, "transferDateDaysPickup");
			return (Criteria) this;
		}

		public Criteria andTransferDateDaysPickupGreaterThan(Integer value) {
			addCriterion("TRANSFER_DATE_DAYS_PICKUP >", value, "transferDateDaysPickup");
			return (Criteria) this;
		}

		public Criteria andTransferDateDaysPickupGreaterThanOrEqualTo(Integer value) {
			addCriterion("TRANSFER_DATE_DAYS_PICKUP >=", value, "transferDateDaysPickup");
			return (Criteria) this;
		}

		public Criteria andTransferDateDaysPickupLessThan(Integer value) {
			addCriterion("TRANSFER_DATE_DAYS_PICKUP <", value, "transferDateDaysPickup");
			return (Criteria) this;
		}

		public Criteria andTransferDateDaysPickupLessThanOrEqualTo(Integer value) {
			addCriterion("TRANSFER_DATE_DAYS_PICKUP <=", value, "transferDateDaysPickup");
			return (Criteria) this;
		}

		public Criteria andTransferDateDaysPickupIn(List<Integer> values) {
			addCriterion("TRANSFER_DATE_DAYS_PICKUP in", values, "transferDateDaysPickup");
			return (Criteria) this;
		}

		public Criteria andTransferDateDaysPickupNotIn(List<Integer> values) {
			addCriterion("TRANSFER_DATE_DAYS_PICKUP not in", values, "transferDateDaysPickup");
			return (Criteria) this;
		}

		public Criteria andTransferDateDaysPickupBetween(Integer value1, Integer value2) {
			addCriterion("TRANSFER_DATE_DAYS_PICKUP between", value1, value2, "transferDateDaysPickup");
			return (Criteria) this;
		}

		public Criteria andTransferDateDaysPickupNotBetween(Integer value1, Integer value2) {
			addCriterion("TRANSFER_DATE_DAYS_PICKUP not between", value1, value2, "transferDateDaysPickup");
			return (Criteria) this;
		}

		public Criteria andTransferDateDaysRegistIsNull() {
			addCriterion("TRANSFER_DATE_DAYS_REGIST is null");
			return (Criteria) this;
		}

		public Criteria andTransferDateDaysRegistIsNotNull() {
			addCriterion("TRANSFER_DATE_DAYS_REGIST is not null");
			return (Criteria) this;
		}

		public Criteria andTransferDateDaysRegistEqualTo(Integer value) {
			addCriterion("TRANSFER_DATE_DAYS_REGIST =", value, "transferDateDaysRegist");
			return (Criteria) this;
		}

		public Criteria andTransferDateDaysRegistNotEqualTo(Integer value) {
			addCriterion("TRANSFER_DATE_DAYS_REGIST <>", value, "transferDateDaysRegist");
			return (Criteria) this;
		}

		public Criteria andTransferDateDaysRegistGreaterThan(Integer value) {
			addCriterion("TRANSFER_DATE_DAYS_REGIST >", value, "transferDateDaysRegist");
			return (Criteria) this;
		}

		public Criteria andTransferDateDaysRegistGreaterThanOrEqualTo(Integer value) {
			addCriterion("TRANSFER_DATE_DAYS_REGIST >=", value, "transferDateDaysRegist");
			return (Criteria) this;
		}

		public Criteria andTransferDateDaysRegistLessThan(Integer value) {
			addCriterion("TRANSFER_DATE_DAYS_REGIST <", value, "transferDateDaysRegist");
			return (Criteria) this;
		}

		public Criteria andTransferDateDaysRegistLessThanOrEqualTo(Integer value) {
			addCriterion("TRANSFER_DATE_DAYS_REGIST <=", value, "transferDateDaysRegist");
			return (Criteria) this;
		}

		public Criteria andTransferDateDaysRegistIn(List<Integer> values) {
			addCriterion("TRANSFER_DATE_DAYS_REGIST in", values, "transferDateDaysRegist");
			return (Criteria) this;
		}

		public Criteria andTransferDateDaysRegistNotIn(List<Integer> values) {
			addCriterion("TRANSFER_DATE_DAYS_REGIST not in", values, "transferDateDaysRegist");
			return (Criteria) this;
		}

		public Criteria andTransferDateDaysRegistBetween(Integer value1, Integer value2) {
			addCriterion("TRANSFER_DATE_DAYS_REGIST between", value1, value2, "transferDateDaysRegist");
			return (Criteria) this;
		}

		public Criteria andTransferDateDaysRegistNotBetween(Integer value1, Integer value2) {
			addCriterion("TRANSFER_DATE_DAYS_REGIST not between", value1, value2, "transferDateDaysRegist");
			return (Criteria) this;
		}

		public Criteria andWaterLeakageIsNull() {
			addCriterion("WATER_LEAKAGE is null");
			return (Criteria) this;
		}

		public Criteria andWaterLeakageIsNotNull() {
			addCriterion("WATER_LEAKAGE is not null");
			return (Criteria) this;
		}

		public Criteria andWaterLeakageEqualTo(Byte value) {
			addCriterion("WATER_LEAKAGE =", value, "waterLeakage");
			return (Criteria) this;
		}

		public Criteria andWaterLeakageNotEqualTo(Byte value) {
			addCriterion("WATER_LEAKAGE <>", value, "waterLeakage");
			return (Criteria) this;
		}

		public Criteria andWaterLeakageGreaterThan(Byte value) {
			addCriterion("WATER_LEAKAGE >", value, "waterLeakage");
			return (Criteria) this;
		}

		public Criteria andWaterLeakageGreaterThanOrEqualTo(Byte value) {
			addCriterion("WATER_LEAKAGE >=", value, "waterLeakage");
			return (Criteria) this;
		}

		public Criteria andWaterLeakageLessThan(Byte value) {
			addCriterion("WATER_LEAKAGE <", value, "waterLeakage");
			return (Criteria) this;
		}

		public Criteria andWaterLeakageLessThanOrEqualTo(Byte value) {
			addCriterion("WATER_LEAKAGE <=", value, "waterLeakage");
			return (Criteria) this;
		}

		public Criteria andWaterLeakageIn(List<Byte> values) {
			addCriterion("WATER_LEAKAGE in", values, "waterLeakage");
			return (Criteria) this;
		}

		public Criteria andWaterLeakageNotIn(List<Byte> values) {
			addCriterion("WATER_LEAKAGE not in", values, "waterLeakage");
			return (Criteria) this;
		}

		public Criteria andWaterLeakageBetween(Byte value1, Byte value2) {
			addCriterion("WATER_LEAKAGE between", value1, value2, "waterLeakage");
			return (Criteria) this;
		}

		public Criteria andWaterLeakageNotBetween(Byte value1, Byte value2) {
			addCriterion("WATER_LEAKAGE not between", value1, value2, "waterLeakage");
			return (Criteria) this;
		}

		public Criteria andWaterLeakagePositionIsNull() {
			addCriterion("WATER_LEAKAGE_POSITION is null");
			return (Criteria) this;
		}

		public Criteria andWaterLeakagePositionIsNotNull() {
			addCriterion("WATER_LEAKAGE_POSITION is not null");
			return (Criteria) this;
		}

		public Criteria andWaterLeakagePositionEqualTo(String value) {
			addCriterion("WATER_LEAKAGE_POSITION =", value, "waterLeakagePosition");
			return (Criteria) this;
		}

		public Criteria andWaterLeakagePositionNotEqualTo(String value) {
			addCriterion("WATER_LEAKAGE_POSITION <>", value, "waterLeakagePosition");
			return (Criteria) this;
		}

		public Criteria andWaterLeakagePositionGreaterThan(String value) {
			addCriterion("WATER_LEAKAGE_POSITION >", value, "waterLeakagePosition");
			return (Criteria) this;
		}

		public Criteria andWaterLeakagePositionGreaterThanOrEqualTo(String value) {
			addCriterion("WATER_LEAKAGE_POSITION >=", value, "waterLeakagePosition");
			return (Criteria) this;
		}

		public Criteria andWaterLeakagePositionLessThan(String value) {
			addCriterion("WATER_LEAKAGE_POSITION <", value, "waterLeakagePosition");
			return (Criteria) this;
		}

		public Criteria andWaterLeakagePositionLessThanOrEqualTo(String value) {
			addCriterion("WATER_LEAKAGE_POSITION <=", value, "waterLeakagePosition");
			return (Criteria) this;
		}

		public Criteria andWaterLeakagePositionLike(String value) {
			addCriterion("WATER_LEAKAGE_POSITION like", value, "waterLeakagePosition");
			return (Criteria) this;
		}

		public Criteria andWaterLeakagePositionNotLike(String value) {
			addCriterion("WATER_LEAKAGE_POSITION not like", value, "waterLeakagePosition");
			return (Criteria) this;
		}

		public Criteria andWaterLeakagePositionIn(List<String> values) {
			addCriterion("WATER_LEAKAGE_POSITION in", values, "waterLeakagePosition");
			return (Criteria) this;
		}

		public Criteria andWaterLeakagePositionNotIn(List<String> values) {
			addCriterion("WATER_LEAKAGE_POSITION not in", values, "waterLeakagePosition");
			return (Criteria) this;
		}

		public Criteria andWaterLeakagePositionBetween(String value1, String value2) {
			addCriterion("WATER_LEAKAGE_POSITION between", value1, value2, "waterLeakagePosition");
			return (Criteria) this;
		}

		public Criteria andWaterLeakagePositionNotBetween(String value1, String value2) {
			addCriterion("WATER_LEAKAGE_POSITION not between", value1, value2, "waterLeakagePosition");
			return (Criteria) this;
		}

		public Criteria andWaterLeakageConsultIsNull() {
			addCriterion("WATER_LEAKAGE_CONSULT is null");
			return (Criteria) this;
		}

		public Criteria andWaterLeakageConsultIsNotNull() {
			addCriterion("WATER_LEAKAGE_CONSULT is not null");
			return (Criteria) this;
		}

		public Criteria andWaterLeakageConsultEqualTo(Byte value) {
			addCriterion("WATER_LEAKAGE_CONSULT =", value, "waterLeakageConsult");
			return (Criteria) this;
		}

		public Criteria andWaterLeakageConsultNotEqualTo(Byte value) {
			addCriterion("WATER_LEAKAGE_CONSULT <>", value, "waterLeakageConsult");
			return (Criteria) this;
		}

		public Criteria andWaterLeakageConsultGreaterThan(Byte value) {
			addCriterion("WATER_LEAKAGE_CONSULT >", value, "waterLeakageConsult");
			return (Criteria) this;
		}

		public Criteria andWaterLeakageConsultGreaterThanOrEqualTo(Byte value) {
			addCriterion("WATER_LEAKAGE_CONSULT >=", value, "waterLeakageConsult");
			return (Criteria) this;
		}

		public Criteria andWaterLeakageConsultLessThan(Byte value) {
			addCriterion("WATER_LEAKAGE_CONSULT <", value, "waterLeakageConsult");
			return (Criteria) this;
		}

		public Criteria andWaterLeakageConsultLessThanOrEqualTo(Byte value) {
			addCriterion("WATER_LEAKAGE_CONSULT <=", value, "waterLeakageConsult");
			return (Criteria) this;
		}

		public Criteria andWaterLeakageConsultIn(List<Byte> values) {
			addCriterion("WATER_LEAKAGE_CONSULT in", values, "waterLeakageConsult");
			return (Criteria) this;
		}

		public Criteria andWaterLeakageConsultNotIn(List<Byte> values) {
			addCriterion("WATER_LEAKAGE_CONSULT not in", values, "waterLeakageConsult");
			return (Criteria) this;
		}

		public Criteria andWaterLeakageConsultBetween(Byte value1, Byte value2) {
			addCriterion("WATER_LEAKAGE_CONSULT between", value1, value2, "waterLeakageConsult");
			return (Criteria) this;
		}

		public Criteria andWaterLeakageConsultNotBetween(Byte value1, Byte value2) {
			addCriterion("WATER_LEAKAGE_CONSULT not between", value1, value2, "waterLeakageConsult");
			return (Criteria) this;
		}

		public Criteria andWaterLeakageConsultBearPartyIsNull() {
			addCriterion("WATER_LEAKAGE_CONSULT_BEAR_PARTY is null");
			return (Criteria) this;
		}

		public Criteria andWaterLeakageConsultBearPartyIsNotNull() {
			addCriterion("WATER_LEAKAGE_CONSULT_BEAR_PARTY is not null");
			return (Criteria) this;
		}

		public Criteria andWaterLeakageConsultBearPartyEqualTo(Byte value) {
			addCriterion("WATER_LEAKAGE_CONSULT_BEAR_PARTY =", value, "waterLeakageConsultBearParty");
			return (Criteria) this;
		}

		public Criteria andWaterLeakageConsultBearPartyNotEqualTo(Byte value) {
			addCriterion("WATER_LEAKAGE_CONSULT_BEAR_PARTY <>", value, "waterLeakageConsultBearParty");
			return (Criteria) this;
		}

		public Criteria andWaterLeakageConsultBearPartyGreaterThan(Byte value) {
			addCriterion("WATER_LEAKAGE_CONSULT_BEAR_PARTY >", value, "waterLeakageConsultBearParty");
			return (Criteria) this;
		}

		public Criteria andWaterLeakageConsultBearPartyGreaterThanOrEqualTo(Byte value) {
			addCriterion("WATER_LEAKAGE_CONSULT_BEAR_PARTY >=", value, "waterLeakageConsultBearParty");
			return (Criteria) this;
		}

		public Criteria andWaterLeakageConsultBearPartyLessThan(Byte value) {
			addCriterion("WATER_LEAKAGE_CONSULT_BEAR_PARTY <", value, "waterLeakageConsultBearParty");
			return (Criteria) this;
		}

		public Criteria andWaterLeakageConsultBearPartyLessThanOrEqualTo(Byte value) {
			addCriterion("WATER_LEAKAGE_CONSULT_BEAR_PARTY <=", value, "waterLeakageConsultBearParty");
			return (Criteria) this;
		}

		public Criteria andWaterLeakageConsultBearPartyIn(List<Byte> values) {
			addCriterion("WATER_LEAKAGE_CONSULT_BEAR_PARTY in", values, "waterLeakageConsultBearParty");
			return (Criteria) this;
		}

		public Criteria andWaterLeakageConsultBearPartyNotIn(List<Byte> values) {
			addCriterion("WATER_LEAKAGE_CONSULT_BEAR_PARTY not in", values, "waterLeakageConsultBearParty");
			return (Criteria) this;
		}

		public Criteria andWaterLeakageConsultBearPartyBetween(Byte value1, Byte value2) {
			addCriterion("WATER_LEAKAGE_CONSULT_BEAR_PARTY between", value1, value2, "waterLeakageConsultBearParty");
			return (Criteria) this;
		}

		public Criteria andWaterLeakageConsultBearPartyNotBetween(Byte value1, Byte value2) {
			addCriterion("WATER_LEAKAGE_CONSULT_BEAR_PARTY not between", value1, value2,
					"waterLeakageConsultBearParty");
			return (Criteria) this;
		}

		public Criteria andDeathEventIsNull() {
			addCriterion("DEATH_EVENT is null");
			return (Criteria) this;
		}

		public Criteria andDeathEventIsNotNull() {
			addCriterion("DEATH_EVENT is not null");
			return (Criteria) this;
		}

		public Criteria andDeathEventEqualTo(String value) {
			addCriterion("DEATH_EVENT =", value, "deathEvent");
			return (Criteria) this;
		}

		public Criteria andDeathEventNotEqualTo(String value) {
			addCriterion("DEATH_EVENT <>", value, "deathEvent");
			return (Criteria) this;
		}

		public Criteria andDeathEventGreaterThan(String value) {
			addCriterion("DEATH_EVENT >", value, "deathEvent");
			return (Criteria) this;
		}

		public Criteria andDeathEventGreaterThanOrEqualTo(String value) {
			addCriterion("DEATH_EVENT >=", value, "deathEvent");
			return (Criteria) this;
		}

		public Criteria andDeathEventLessThan(String value) {
			addCriterion("DEATH_EVENT <", value, "deathEvent");
			return (Criteria) this;
		}

		public Criteria andDeathEventLessThanOrEqualTo(String value) {
			addCriterion("DEATH_EVENT <=", value, "deathEvent");
			return (Criteria) this;
		}

		public Criteria andDeathEventLike(String value) {
			addCriterion("DEATH_EVENT like", value, "deathEvent");
			return (Criteria) this;
		}

		public Criteria andDeathEventNotLike(String value) {
			addCriterion("DEATH_EVENT not like", value, "deathEvent");
			return (Criteria) this;
		}

		public Criteria andDeathEventIn(List<String> values) {
			addCriterion("DEATH_EVENT in", values, "deathEvent");
			return (Criteria) this;
		}

		public Criteria andDeathEventNotIn(List<String> values) {
			addCriterion("DEATH_EVENT not in", values, "deathEvent");
			return (Criteria) this;
		}

		public Criteria andDeathEventBetween(String value1, String value2) {
			addCriterion("DEATH_EVENT between", value1, value2, "deathEvent");
			return (Criteria) this;
		}

		public Criteria andDeathEventNotBetween(String value1, String value2) {
			addCriterion("DEATH_EVENT not between", value1, value2, "deathEvent");
			return (Criteria) this;
		}

		public Criteria andHousePeelingIsNull() {
			addCriterion("HOUSE_PEELING is null");
			return (Criteria) this;
		}

		public Criteria andHousePeelingIsNotNull() {
			addCriterion("HOUSE_PEELING is not null");
			return (Criteria) this;
		}

		public Criteria andHousePeelingEqualTo(Byte value) {
			addCriterion("HOUSE_PEELING =", value, "housePeeling");
			return (Criteria) this;
		}

		public Criteria andHousePeelingNotEqualTo(Byte value) {
			addCriterion("HOUSE_PEELING <>", value, "housePeeling");
			return (Criteria) this;
		}

		public Criteria andHousePeelingGreaterThan(Byte value) {
			addCriterion("HOUSE_PEELING >", value, "housePeeling");
			return (Criteria) this;
		}

		public Criteria andHousePeelingGreaterThanOrEqualTo(Byte value) {
			addCriterion("HOUSE_PEELING >=", value, "housePeeling");
			return (Criteria) this;
		}

		public Criteria andHousePeelingLessThan(Byte value) {
			addCriterion("HOUSE_PEELING <", value, "housePeeling");
			return (Criteria) this;
		}

		public Criteria andHousePeelingLessThanOrEqualTo(Byte value) {
			addCriterion("HOUSE_PEELING <=", value, "housePeeling");
			return (Criteria) this;
		}

		public Criteria andHousePeelingIn(List<Byte> values) {
			addCriterion("HOUSE_PEELING in", values, "housePeeling");
			return (Criteria) this;
		}

		public Criteria andHousePeelingNotIn(List<Byte> values) {
			addCriterion("HOUSE_PEELING not in", values, "housePeeling");
			return (Criteria) this;
		}

		public Criteria andHousePeelingBetween(Byte value1, Byte value2) {
			addCriterion("HOUSE_PEELING between", value1, value2, "housePeeling");
			return (Criteria) this;
		}

		public Criteria andHousePeelingNotBetween(Byte value1, Byte value2) {
			addCriterion("HOUSE_PEELING not between", value1, value2, "housePeeling");
			return (Criteria) this;
		}

		public Criteria andHousePeelingPositionIsNull() {
			addCriterion("HOUSE_PEELING_POSITION is null");
			return (Criteria) this;
		}

		public Criteria andHousePeelingPositionIsNotNull() {
			addCriterion("HOUSE_PEELING_POSITION is not null");
			return (Criteria) this;
		}

		public Criteria andHousePeelingPositionEqualTo(String value) {
			addCriterion("HOUSE_PEELING_POSITION =", value, "housePeelingPosition");
			return (Criteria) this;
		}

		public Criteria andHousePeelingPositionNotEqualTo(String value) {
			addCriterion("HOUSE_PEELING_POSITION <>", value, "housePeelingPosition");
			return (Criteria) this;
		}

		public Criteria andHousePeelingPositionGreaterThan(String value) {
			addCriterion("HOUSE_PEELING_POSITION >", value, "housePeelingPosition");
			return (Criteria) this;
		}

		public Criteria andHousePeelingPositionGreaterThanOrEqualTo(String value) {
			addCriterion("HOUSE_PEELING_POSITION >=", value, "housePeelingPosition");
			return (Criteria) this;
		}

		public Criteria andHousePeelingPositionLessThan(String value) {
			addCriterion("HOUSE_PEELING_POSITION <", value, "housePeelingPosition");
			return (Criteria) this;
		}

		public Criteria andHousePeelingPositionLessThanOrEqualTo(String value) {
			addCriterion("HOUSE_PEELING_POSITION <=", value, "housePeelingPosition");
			return (Criteria) this;
		}

		public Criteria andHousePeelingPositionLike(String value) {
			addCriterion("HOUSE_PEELING_POSITION like", value, "housePeelingPosition");
			return (Criteria) this;
		}

		public Criteria andHousePeelingPositionNotLike(String value) {
			addCriterion("HOUSE_PEELING_POSITION not like", value, "housePeelingPosition");
			return (Criteria) this;
		}

		public Criteria andHousePeelingPositionIn(List<String> values) {
			addCriterion("HOUSE_PEELING_POSITION in", values, "housePeelingPosition");
			return (Criteria) this;
		}

		public Criteria andHousePeelingPositionNotIn(List<String> values) {
			addCriterion("HOUSE_PEELING_POSITION not in", values, "housePeelingPosition");
			return (Criteria) this;
		}

		public Criteria andHousePeelingPositionBetween(String value1, String value2) {
			addCriterion("HOUSE_PEELING_POSITION between", value1, value2, "housePeelingPosition");
			return (Criteria) this;
		}

		public Criteria andHousePeelingPositionNotBetween(String value1, String value2) {
			addCriterion("HOUSE_PEELING_POSITION not between", value1, value2, "housePeelingPosition");
			return (Criteria) this;
		}

		public Criteria andSubmitLoanInfoFeeDaysIsNull() {
			addCriterion("SUBMIT_LOAN_INFO_FEE_DAYS is null");
			return (Criteria) this;
		}

		public Criteria andSubmitLoanInfoFeeDaysIsNotNull() {
			addCriterion("SUBMIT_LOAN_INFO_FEE_DAYS is not null");
			return (Criteria) this;
		}

		public Criteria andSubmitLoanInfoFeeDaysEqualTo(String value) {
			addCriterion("SUBMIT_LOAN_INFO_FEE_DAYS =", value, "submitLoanInfoFeeDays");
			return (Criteria) this;
		}

		public Criteria andSubmitLoanInfoFeeDaysNotEqualTo(String value) {
			addCriterion("SUBMIT_LOAN_INFO_FEE_DAYS <>", value, "submitLoanInfoFeeDays");
			return (Criteria) this;
		}

		public Criteria andSubmitLoanInfoFeeDaysGreaterThan(String value) {
			addCriterion("SUBMIT_LOAN_INFO_FEE_DAYS >", value, "submitLoanInfoFeeDays");
			return (Criteria) this;
		}

		public Criteria andSubmitLoanInfoFeeDaysGreaterThanOrEqualTo(String value) {
			addCriterion("SUBMIT_LOAN_INFO_FEE_DAYS >=", value, "submitLoanInfoFeeDays");
			return (Criteria) this;
		}

		public Criteria andSubmitLoanInfoFeeDaysLessThan(String value) {
			addCriterion("SUBMIT_LOAN_INFO_FEE_DAYS <", value, "submitLoanInfoFeeDays");
			return (Criteria) this;
		}

		public Criteria andSubmitLoanInfoFeeDaysLessThanOrEqualTo(String value) {
			addCriterion("SUBMIT_LOAN_INFO_FEE_DAYS <=", value, "submitLoanInfoFeeDays");
			return (Criteria) this;
		}

		public Criteria andSubmitLoanInfoFeeDaysLike(String value) {
			addCriterion("SUBMIT_LOAN_INFO_FEE_DAYS like", value, "submitLoanInfoFeeDays");
			return (Criteria) this;
		}

		public Criteria andSubmitLoanInfoFeeDaysNotLike(String value) {
			addCriterion("SUBMIT_LOAN_INFO_FEE_DAYS not like", value, "submitLoanInfoFeeDays");
			return (Criteria) this;
		}

		public Criteria andSubmitLoanInfoFeeDaysIn(List<String> values) {
			addCriterion("SUBMIT_LOAN_INFO_FEE_DAYS in", values, "submitLoanInfoFeeDays");
			return (Criteria) this;
		}

		public Criteria andSubmitLoanInfoFeeDaysNotIn(List<String> values) {
			addCriterion("SUBMIT_LOAN_INFO_FEE_DAYS not in", values, "submitLoanInfoFeeDays");
			return (Criteria) this;
		}

		public Criteria andSubmitLoanInfoFeeDaysBetween(String value1, String value2) {
			addCriterion("SUBMIT_LOAN_INFO_FEE_DAYS between", value1, value2, "submitLoanInfoFeeDays");
			return (Criteria) this;
		}

		public Criteria andSubmitLoanInfoFeeDaysNotBetween(String value1, String value2) {
			addCriterion("SUBMIT_LOAN_INFO_FEE_DAYS not between", value1, value2, "submitLoanInfoFeeDays");
			return (Criteria) this;
		}

		public Criteria andDownPaymentsPayParty1IsNull() {
			addCriterion("DOWN_PAYMENTS_PAY_PARTY1 is null");
			return (Criteria) this;
		}

		public Criteria andDownPaymentsPayParty1IsNotNull() {
			addCriterion("DOWN_PAYMENTS_PAY_PARTY1 is not null");
			return (Criteria) this;
		}

		public Criteria andDownPaymentsPayParty1EqualTo(Byte value) {
			addCriterion("DOWN_PAYMENTS_PAY_PARTY1 =", value, "downPaymentsPayParty1");
			return (Criteria) this;
		}

		public Criteria andDownPaymentsPayParty1NotEqualTo(Byte value) {
			addCriterion("DOWN_PAYMENTS_PAY_PARTY1 <>", value, "downPaymentsPayParty1");
			return (Criteria) this;
		}

		public Criteria andDownPaymentsPayParty1GreaterThan(Byte value) {
			addCriterion("DOWN_PAYMENTS_PAY_PARTY1 >", value, "downPaymentsPayParty1");
			return (Criteria) this;
		}

		public Criteria andDownPaymentsPayParty1GreaterThanOrEqualTo(Byte value) {
			addCriterion("DOWN_PAYMENTS_PAY_PARTY1 >=", value, "downPaymentsPayParty1");
			return (Criteria) this;
		}

		public Criteria andDownPaymentsPayParty1LessThan(Byte value) {
			addCriterion("DOWN_PAYMENTS_PAY_PARTY1 <", value, "downPaymentsPayParty1");
			return (Criteria) this;
		}

		public Criteria andDownPaymentsPayParty1LessThanOrEqualTo(Byte value) {
			addCriterion("DOWN_PAYMENTS_PAY_PARTY1 <=", value, "downPaymentsPayParty1");
			return (Criteria) this;
		}

		public Criteria andDownPaymentsPayParty1In(List<Byte> values) {
			addCriterion("DOWN_PAYMENTS_PAY_PARTY1 in", values, "downPaymentsPayParty1");
			return (Criteria) this;
		}

		public Criteria andDownPaymentsPayParty1NotIn(List<Byte> values) {
			addCriterion("DOWN_PAYMENTS_PAY_PARTY1 not in", values, "downPaymentsPayParty1");
			return (Criteria) this;
		}

		public Criteria andDownPaymentsPayParty1Between(Byte value1, Byte value2) {
			addCriterion("DOWN_PAYMENTS_PAY_PARTY1 between", value1, value2, "downPaymentsPayParty1");
			return (Criteria) this;
		}

		public Criteria andDownPaymentsPayParty1NotBetween(Byte value1, Byte value2) {
			addCriterion("DOWN_PAYMENTS_PAY_PARTY1 not between", value1, value2, "downPaymentsPayParty1");
			return (Criteria) this;
		}

		public Criteria andDownPaymentsPayParty2IsNull() {
			addCriterion("DOWN_PAYMENTS_PAY_PARTY2 is null");
			return (Criteria) this;
		}

		public Criteria andDownPaymentsPayParty2IsNotNull() {
			addCriterion("DOWN_PAYMENTS_PAY_PARTY2 is not null");
			return (Criteria) this;
		}

		public Criteria andDownPaymentsPayParty2EqualTo(Byte value) {
			addCriterion("DOWN_PAYMENTS_PAY_PARTY2 =", value, "downPaymentsPayParty2");
			return (Criteria) this;
		}

		public Criteria andDownPaymentsPayParty2NotEqualTo(Byte value) {
			addCriterion("DOWN_PAYMENTS_PAY_PARTY2 <>", value, "downPaymentsPayParty2");
			return (Criteria) this;
		}

		public Criteria andDownPaymentsPayParty2GreaterThan(Byte value) {
			addCriterion("DOWN_PAYMENTS_PAY_PARTY2 >", value, "downPaymentsPayParty2");
			return (Criteria) this;
		}

		public Criteria andDownPaymentsPayParty2GreaterThanOrEqualTo(Byte value) {
			addCriterion("DOWN_PAYMENTS_PAY_PARTY2 >=", value, "downPaymentsPayParty2");
			return (Criteria) this;
		}

		public Criteria andDownPaymentsPayParty2LessThan(Byte value) {
			addCriterion("DOWN_PAYMENTS_PAY_PARTY2 <", value, "downPaymentsPayParty2");
			return (Criteria) this;
		}

		public Criteria andDownPaymentsPayParty2LessThanOrEqualTo(Byte value) {
			addCriterion("DOWN_PAYMENTS_PAY_PARTY2 <=", value, "downPaymentsPayParty2");
			return (Criteria) this;
		}

		public Criteria andDownPaymentsPayParty2In(List<Byte> values) {
			addCriterion("DOWN_PAYMENTS_PAY_PARTY2 in", values, "downPaymentsPayParty2");
			return (Criteria) this;
		}

		public Criteria andDownPaymentsPayParty2NotIn(List<Byte> values) {
			addCriterion("DOWN_PAYMENTS_PAY_PARTY2 not in", values, "downPaymentsPayParty2");
			return (Criteria) this;
		}

		public Criteria andDownPaymentsPayParty2Between(Byte value1, Byte value2) {
			addCriterion("DOWN_PAYMENTS_PAY_PARTY2 between", value1, value2, "downPaymentsPayParty2");
			return (Criteria) this;
		}

		public Criteria andDownPaymentsPayParty2NotBetween(Byte value1, Byte value2) {
			addCriterion("DOWN_PAYMENTS_PAY_PARTY2 not between", value1, value2, "downPaymentsPayParty2");
			return (Criteria) this;
		}

		public Criteria andDownPaymentsPayParty3IsNull() {
			addCriterion("DOWN_PAYMENTS_PAY_PARTY3 is null");
			return (Criteria) this;
		}

		public Criteria andDownPaymentsPayParty3IsNotNull() {
			addCriterion("DOWN_PAYMENTS_PAY_PARTY3 is not null");
			return (Criteria) this;
		}

		public Criteria andDownPaymentsPayParty3EqualTo(Byte value) {
			addCriterion("DOWN_PAYMENTS_PAY_PARTY3 =", value, "downPaymentsPayParty3");
			return (Criteria) this;
		}

		public Criteria andDownPaymentsPayParty3NotEqualTo(Byte value) {
			addCriterion("DOWN_PAYMENTS_PAY_PARTY3 <>", value, "downPaymentsPayParty3");
			return (Criteria) this;
		}

		public Criteria andDownPaymentsPayParty3GreaterThan(Byte value) {
			addCriterion("DOWN_PAYMENTS_PAY_PARTY3 >", value, "downPaymentsPayParty3");
			return (Criteria) this;
		}

		public Criteria andDownPaymentsPayParty3GreaterThanOrEqualTo(Byte value) {
			addCriterion("DOWN_PAYMENTS_PAY_PARTY3 >=", value, "downPaymentsPayParty3");
			return (Criteria) this;
		}

		public Criteria andDownPaymentsPayParty3LessThan(Byte value) {
			addCriterion("DOWN_PAYMENTS_PAY_PARTY3 <", value, "downPaymentsPayParty3");
			return (Criteria) this;
		}

		public Criteria andDownPaymentsPayParty3LessThanOrEqualTo(Byte value) {
			addCriterion("DOWN_PAYMENTS_PAY_PARTY3 <=", value, "downPaymentsPayParty3");
			return (Criteria) this;
		}

		public Criteria andDownPaymentsPayParty3In(List<Byte> values) {
			addCriterion("DOWN_PAYMENTS_PAY_PARTY3 in", values, "downPaymentsPayParty3");
			return (Criteria) this;
		}

		public Criteria andDownPaymentsPayParty3NotIn(List<Byte> values) {
			addCriterion("DOWN_PAYMENTS_PAY_PARTY3 not in", values, "downPaymentsPayParty3");
			return (Criteria) this;
		}

		public Criteria andDownPaymentsPayParty3Between(Byte value1, Byte value2) {
			addCriterion("DOWN_PAYMENTS_PAY_PARTY3 between", value1, value2, "downPaymentsPayParty3");
			return (Criteria) this;
		}

		public Criteria andDownPaymentsPayParty3NotBetween(Byte value1, Byte value2) {
			addCriterion("DOWN_PAYMENTS_PAY_PARTY3 not between", value1, value2, "downPaymentsPayParty3");
			return (Criteria) this;
		}

		public Criteria andDownPaymentsPayBankIsNull() {
			addCriterion("DOWN_PAYMENTS_PAY_BANK is null");
			return (Criteria) this;
		}

		public Criteria andDownPaymentsPayBankIsNotNull() {
			addCriterion("DOWN_PAYMENTS_PAY_BANK is not null");
			return (Criteria) this;
		}

		public Criteria andDownPaymentsPayBankEqualTo(String value) {
			addCriterion("DOWN_PAYMENTS_PAY_BANK =", value, "downPaymentsPayBank");
			return (Criteria) this;
		}

		public Criteria andDownPaymentsPayBankNotEqualTo(String value) {
			addCriterion("DOWN_PAYMENTS_PAY_BANK <>", value, "downPaymentsPayBank");
			return (Criteria) this;
		}

		public Criteria andDownPaymentsPayBankGreaterThan(String value) {
			addCriterion("DOWN_PAYMENTS_PAY_BANK >", value, "downPaymentsPayBank");
			return (Criteria) this;
		}

		public Criteria andDownPaymentsPayBankGreaterThanOrEqualTo(String value) {
			addCriterion("DOWN_PAYMENTS_PAY_BANK >=", value, "downPaymentsPayBank");
			return (Criteria) this;
		}

		public Criteria andDownPaymentsPayBankLessThan(String value) {
			addCriterion("DOWN_PAYMENTS_PAY_BANK <", value, "downPaymentsPayBank");
			return (Criteria) this;
		}

		public Criteria andDownPaymentsPayBankLessThanOrEqualTo(String value) {
			addCriterion("DOWN_PAYMENTS_PAY_BANK <=", value, "downPaymentsPayBank");
			return (Criteria) this;
		}

		public Criteria andDownPaymentsPayBankLike(String value) {
			addCriterion("DOWN_PAYMENTS_PAY_BANK like", value, "downPaymentsPayBank");
			return (Criteria) this;
		}

		public Criteria andDownPaymentsPayBankNotLike(String value) {
			addCriterion("DOWN_PAYMENTS_PAY_BANK not like", value, "downPaymentsPayBank");
			return (Criteria) this;
		}

		public Criteria andDownPaymentsPayBankIn(List<String> values) {
			addCriterion("DOWN_PAYMENTS_PAY_BANK in", values, "downPaymentsPayBank");
			return (Criteria) this;
		}

		public Criteria andDownPaymentsPayBankNotIn(List<String> values) {
			addCriterion("DOWN_PAYMENTS_PAY_BANK not in", values, "downPaymentsPayBank");
			return (Criteria) this;
		}

		public Criteria andDownPaymentsPayBankBetween(String value1, String value2) {
			addCriterion("DOWN_PAYMENTS_PAY_BANK between", value1, value2, "downPaymentsPayBank");
			return (Criteria) this;
		}

		public Criteria andDownPaymentsPayBankNotBetween(String value1, String value2) {
			addCriterion("DOWN_PAYMENTS_PAY_BANK not between", value1, value2, "downPaymentsPayBank");
			return (Criteria) this;
		}

		public Criteria andDownPaymentsPayAccountNameIsNull() {
			addCriterion("DOWN_PAYMENTS_PAY_ACCOUNT_NAME is null");
			return (Criteria) this;
		}

		public Criteria andDownPaymentsPayAccountNameIsNotNull() {
			addCriterion("DOWN_PAYMENTS_PAY_ACCOUNT_NAME is not null");
			return (Criteria) this;
		}

		public Criteria andDownPaymentsPayAccountNameEqualTo(String value) {
			addCriterion("DOWN_PAYMENTS_PAY_ACCOUNT_NAME =", value, "downPaymentsPayAccountName");
			return (Criteria) this;
		}

		public Criteria andDownPaymentsPayAccountNameNotEqualTo(String value) {
			addCriterion("DOWN_PAYMENTS_PAY_ACCOUNT_NAME <>", value, "downPaymentsPayAccountName");
			return (Criteria) this;
		}

		public Criteria andDownPaymentsPayAccountNameGreaterThan(String value) {
			addCriterion("DOWN_PAYMENTS_PAY_ACCOUNT_NAME >", value, "downPaymentsPayAccountName");
			return (Criteria) this;
		}

		public Criteria andDownPaymentsPayAccountNameGreaterThanOrEqualTo(String value) {
			addCriterion("DOWN_PAYMENTS_PAY_ACCOUNT_NAME >=", value, "downPaymentsPayAccountName");
			return (Criteria) this;
		}

		public Criteria andDownPaymentsPayAccountNameLessThan(String value) {
			addCriterion("DOWN_PAYMENTS_PAY_ACCOUNT_NAME <", value, "downPaymentsPayAccountName");
			return (Criteria) this;
		}

		public Criteria andDownPaymentsPayAccountNameLessThanOrEqualTo(String value) {
			addCriterion("DOWN_PAYMENTS_PAY_ACCOUNT_NAME <=", value, "downPaymentsPayAccountName");
			return (Criteria) this;
		}

		public Criteria andDownPaymentsPayAccountNameLike(String value) {
			addCriterion("DOWN_PAYMENTS_PAY_ACCOUNT_NAME like", value, "downPaymentsPayAccountName");
			return (Criteria) this;
		}

		public Criteria andDownPaymentsPayAccountNameNotLike(String value) {
			addCriterion("DOWN_PAYMENTS_PAY_ACCOUNT_NAME not like", value, "downPaymentsPayAccountName");
			return (Criteria) this;
		}

		public Criteria andDownPaymentsPayAccountNameIn(List<String> values) {
			addCriterion("DOWN_PAYMENTS_PAY_ACCOUNT_NAME in", values, "downPaymentsPayAccountName");
			return (Criteria) this;
		}

		public Criteria andDownPaymentsPayAccountNameNotIn(List<String> values) {
			addCriterion("DOWN_PAYMENTS_PAY_ACCOUNT_NAME not in", values, "downPaymentsPayAccountName");
			return (Criteria) this;
		}

		public Criteria andDownPaymentsPayAccountNameBetween(String value1, String value2) {
			addCriterion("DOWN_PAYMENTS_PAY_ACCOUNT_NAME between", value1, value2, "downPaymentsPayAccountName");
			return (Criteria) this;
		}

		public Criteria andDownPaymentsPayAccountNameNotBetween(String value1, String value2) {
			addCriterion("DOWN_PAYMENTS_PAY_ACCOUNT_NAME not between", value1, value2, "downPaymentsPayAccountName");
			return (Criteria) this;
		}

		public Criteria andDownPaymentsPayAccountNoIsNull() {
			addCriterion("DOWN_PAYMENTS_PAY_ACCOUNT_NO is null");
			return (Criteria) this;
		}

		public Criteria andDownPaymentsPayAccountNoIsNotNull() {
			addCriterion("DOWN_PAYMENTS_PAY_ACCOUNT_NO is not null");
			return (Criteria) this;
		}

		public Criteria andDownPaymentsPayAccountNoEqualTo(String value) {
			addCriterion("DOWN_PAYMENTS_PAY_ACCOUNT_NO =", value, "downPaymentsPayAccountNo");
			return (Criteria) this;
		}

		public Criteria andDownPaymentsPayAccountNoNotEqualTo(String value) {
			addCriterion("DOWN_PAYMENTS_PAY_ACCOUNT_NO <>", value, "downPaymentsPayAccountNo");
			return (Criteria) this;
		}

		public Criteria andDownPaymentsPayAccountNoGreaterThan(String value) {
			addCriterion("DOWN_PAYMENTS_PAY_ACCOUNT_NO >", value, "downPaymentsPayAccountNo");
			return (Criteria) this;
		}

		public Criteria andDownPaymentsPayAccountNoGreaterThanOrEqualTo(String value) {
			addCriterion("DOWN_PAYMENTS_PAY_ACCOUNT_NO >=", value, "downPaymentsPayAccountNo");
			return (Criteria) this;
		}

		public Criteria andDownPaymentsPayAccountNoLessThan(String value) {
			addCriterion("DOWN_PAYMENTS_PAY_ACCOUNT_NO <", value, "downPaymentsPayAccountNo");
			return (Criteria) this;
		}

		public Criteria andDownPaymentsPayAccountNoLessThanOrEqualTo(String value) {
			addCriterion("DOWN_PAYMENTS_PAY_ACCOUNT_NO <=", value, "downPaymentsPayAccountNo");
			return (Criteria) this;
		}

		public Criteria andDownPaymentsPayAccountNoLike(String value) {
			addCriterion("DOWN_PAYMENTS_PAY_ACCOUNT_NO like", value, "downPaymentsPayAccountNo");
			return (Criteria) this;
		}

		public Criteria andDownPaymentsPayAccountNoNotLike(String value) {
			addCriterion("DOWN_PAYMENTS_PAY_ACCOUNT_NO not like", value, "downPaymentsPayAccountNo");
			return (Criteria) this;
		}

		public Criteria andDownPaymentsPayAccountNoIn(List<String> values) {
			addCriterion("DOWN_PAYMENTS_PAY_ACCOUNT_NO in", values, "downPaymentsPayAccountNo");
			return (Criteria) this;
		}

		public Criteria andDownPaymentsPayAccountNoNotIn(List<String> values) {
			addCriterion("DOWN_PAYMENTS_PAY_ACCOUNT_NO not in", values, "downPaymentsPayAccountNo");
			return (Criteria) this;
		}

		public Criteria andDownPaymentsPayAccountNoBetween(String value1, String value2) {
			addCriterion("DOWN_PAYMENTS_PAY_ACCOUNT_NO between", value1, value2, "downPaymentsPayAccountNo");
			return (Criteria) this;
		}

		public Criteria andDownPaymentsPayAccountNoNotBetween(String value1, String value2) {
			addCriterion("DOWN_PAYMENTS_PAY_ACCOUNT_NO not between", value1, value2, "downPaymentsPayAccountNo");
			return (Criteria) this;
		}

		public Criteria andDownPaymentsThirdPartyIsNull() {
			addCriterion("DOWN_PAYMENTS_THIRD_PARTY is null");
			return (Criteria) this;
		}

		public Criteria andDownPaymentsThirdPartyIsNotNull() {
			addCriterion("DOWN_PAYMENTS_THIRD_PARTY is not null");
			return (Criteria) this;
		}

		public Criteria andDownPaymentsThirdPartyEqualTo(String value) {
			addCriterion("DOWN_PAYMENTS_THIRD_PARTY =", value, "downPaymentsThirdParty");
			return (Criteria) this;
		}

		public Criteria andDownPaymentsThirdPartyNotEqualTo(String value) {
			addCriterion("DOWN_PAYMENTS_THIRD_PARTY <>", value, "downPaymentsThirdParty");
			return (Criteria) this;
		}

		public Criteria andDownPaymentsThirdPartyGreaterThan(String value) {
			addCriterion("DOWN_PAYMENTS_THIRD_PARTY >", value, "downPaymentsThirdParty");
			return (Criteria) this;
		}

		public Criteria andDownPaymentsThirdPartyGreaterThanOrEqualTo(String value) {
			addCriterion("DOWN_PAYMENTS_THIRD_PARTY >=", value, "downPaymentsThirdParty");
			return (Criteria) this;
		}

		public Criteria andDownPaymentsThirdPartyLessThan(String value) {
			addCriterion("DOWN_PAYMENTS_THIRD_PARTY <", value, "downPaymentsThirdParty");
			return (Criteria) this;
		}

		public Criteria andDownPaymentsThirdPartyLessThanOrEqualTo(String value) {
			addCriterion("DOWN_PAYMENTS_THIRD_PARTY <=", value, "downPaymentsThirdParty");
			return (Criteria) this;
		}

		public Criteria andDownPaymentsThirdPartyLike(String value) {
			addCriterion("DOWN_PAYMENTS_THIRD_PARTY like", value, "downPaymentsThirdParty");
			return (Criteria) this;
		}

		public Criteria andDownPaymentsThirdPartyNotLike(String value) {
			addCriterion("DOWN_PAYMENTS_THIRD_PARTY not like", value, "downPaymentsThirdParty");
			return (Criteria) this;
		}

		public Criteria andDownPaymentsThirdPartyIn(List<String> values) {
			addCriterion("DOWN_PAYMENTS_THIRD_PARTY in", values, "downPaymentsThirdParty");
			return (Criteria) this;
		}

		public Criteria andDownPaymentsThirdPartyNotIn(List<String> values) {
			addCriterion("DOWN_PAYMENTS_THIRD_PARTY not in", values, "downPaymentsThirdParty");
			return (Criteria) this;
		}

		public Criteria andDownPaymentsThirdPartyBetween(String value1, String value2) {
			addCriterion("DOWN_PAYMENTS_THIRD_PARTY between", value1, value2, "downPaymentsThirdParty");
			return (Criteria) this;
		}

		public Criteria andDownPaymentsThirdPartyNotBetween(String value1, String value2) {
			addCriterion("DOWN_PAYMENTS_THIRD_PARTY not between", value1, value2, "downPaymentsThirdParty");
			return (Criteria) this;
		}

		public Criteria andDownPaymentsRemainingFirstPaytimeIsNull() {
			addCriterion("DOWN_PAYMENTS_REMAINING_FIRST_PAYTIME is null");
			return (Criteria) this;
		}

		public Criteria andDownPaymentsRemainingFirstPaytimeIsNotNull() {
			addCriterion("DOWN_PAYMENTS_REMAINING_FIRST_PAYTIME is not null");
			return (Criteria) this;
		}

		public Criteria andDownPaymentsRemainingFirstPaytimeEqualTo(String value) {
			addCriterion("DOWN_PAYMENTS_REMAINING_FIRST_PAYTIME =", value, "downPaymentsRemainingFirstPaytime");
			return (Criteria) this;
		}

		public Criteria andDownPaymentsRemainingFirstPaytimeNotEqualTo(String value) {
			addCriterion("DOWN_PAYMENTS_REMAINING_FIRST_PAYTIME <>", value, "downPaymentsRemainingFirstPaytime");
			return (Criteria) this;
		}

		public Criteria andDownPaymentsRemainingFirstPaytimeGreaterThan(String value) {
			addCriterion("DOWN_PAYMENTS_REMAINING_FIRST_PAYTIME >", value, "downPaymentsRemainingFirstPaytime");
			return (Criteria) this;
		}

		public Criteria andDownPaymentsRemainingFirstPaytimeGreaterThanOrEqualTo(String value) {
			addCriterion("DOWN_PAYMENTS_REMAINING_FIRST_PAYTIME >=", value, "downPaymentsRemainingFirstPaytime");
			return (Criteria) this;
		}

		public Criteria andDownPaymentsRemainingFirstPaytimeLessThan(String value) {
			addCriterion("DOWN_PAYMENTS_REMAINING_FIRST_PAYTIME <", value, "downPaymentsRemainingFirstPaytime");
			return (Criteria) this;
		}

		public Criteria andDownPaymentsRemainingFirstPaytimeLessThanOrEqualTo(String value) {
			addCriterion("DOWN_PAYMENTS_REMAINING_FIRST_PAYTIME <=", value, "downPaymentsRemainingFirstPaytime");
			return (Criteria) this;
		}

		public Criteria andDownPaymentsRemainingFirstPaytimeLike(String value) {
			addCriterion("DOWN_PAYMENTS_REMAINING_FIRST_PAYTIME like", value, "downPaymentsRemainingFirstPaytime");
			return (Criteria) this;
		}

		public Criteria andDownPaymentsRemainingFirstPaytimeNotLike(String value) {
			addCriterion("DOWN_PAYMENTS_REMAINING_FIRST_PAYTIME not like", value, "downPaymentsRemainingFirstPaytime");
			return (Criteria) this;
		}

		public Criteria andDownPaymentsRemainingFirstPaytimeIn(List<String> values) {
			addCriterion("DOWN_PAYMENTS_REMAINING_FIRST_PAYTIME in", values, "downPaymentsRemainingFirstPaytime");
			return (Criteria) this;
		}

		public Criteria andDownPaymentsRemainingFirstPaytimeNotIn(List<String> values) {
			addCriterion("DOWN_PAYMENTS_REMAINING_FIRST_PAYTIME not in", values, "downPaymentsRemainingFirstPaytime");
			return (Criteria) this;
		}

		public Criteria andDownPaymentsRemainingFirstPaytimeBetween(String value1, String value2) {
			addCriterion("DOWN_PAYMENTS_REMAINING_FIRST_PAYTIME between", value1, value2,
					"downPaymentsRemainingFirstPaytime");
			return (Criteria) this;
		}

		public Criteria andDownPaymentsRemainingFirstPaytimeNotBetween(String value1, String value2) {
			addCriterion("DOWN_PAYMENTS_REMAINING_FIRST_PAYTIME not between", value1, value2,
					"downPaymentsRemainingFirstPaytime");
			return (Criteria) this;
		}

		public Criteria andHousePeelingBearPartyIsNull() {
			addCriterion("HOUSE_PEELING_BEAR_PARTY is null");
			return (Criteria) this;
		}

		public Criteria andHousePeelingBearPartyIsNotNull() {
			addCriterion("HOUSE_PEELING_BEAR_PARTY is not null");
			return (Criteria) this;
		}

		public Criteria andHousePeelingBearPartyEqualTo(Byte value) {
			addCriterion("HOUSE_PEELING_BEAR_PARTY =", value, "housePeelingBearParty");
			return (Criteria) this;
		}

		public Criteria andHousePeelingBearPartyNotEqualTo(Byte value) {
			addCriterion("HOUSE_PEELING_BEAR_PARTY <>", value, "housePeelingBearParty");
			return (Criteria) this;
		}

		public Criteria andHousePeelingBearPartyGreaterThan(Byte value) {
			addCriterion("HOUSE_PEELING_BEAR_PARTY >", value, "housePeelingBearParty");
			return (Criteria) this;
		}

		public Criteria andHousePeelingBearPartyGreaterThanOrEqualTo(Byte value) {
			addCriterion("HOUSE_PEELING_BEAR_PARTY >=", value, "housePeelingBearParty");
			return (Criteria) this;
		}

		public Criteria andHousePeelingBearPartyLessThan(Byte value) {
			addCriterion("HOUSE_PEELING_BEAR_PARTY <", value, "housePeelingBearParty");
			return (Criteria) this;
		}

		public Criteria andHousePeelingBearPartyLessThanOrEqualTo(Byte value) {
			addCriterion("HOUSE_PEELING_BEAR_PARTY <=", value, "housePeelingBearParty");
			return (Criteria) this;
		}

		public Criteria andHousePeelingBearPartyIn(List<Byte> values) {
			addCriterion("HOUSE_PEELING_BEAR_PARTY in", values, "housePeelingBearParty");
			return (Criteria) this;
		}

		public Criteria andHousePeelingBearPartyNotIn(List<Byte> values) {
			addCriterion("HOUSE_PEELING_BEAR_PARTY not in", values, "housePeelingBearParty");
			return (Criteria) this;
		}

		public Criteria andHousePeelingBearPartyBetween(Byte value1, Byte value2) {
			addCriterion("HOUSE_PEELING_BEAR_PARTY between", value1, value2, "housePeelingBearParty");
			return (Criteria) this;
		}

		public Criteria andHousePeelingBearPartyNotBetween(Byte value1, Byte value2) {
			addCriterion("HOUSE_PEELING_BEAR_PARTY not between", value1, value2, "housePeelingBearParty");
			return (Criteria) this;
		}

		public Criteria andDownPaymentsRemainingFirstAmountIsNull() {
			addCriterion("DOWN_PAYMENTS_REMAINING_FIRST_AMOUNT is null");
			return (Criteria) this;
		}

		public Criteria andDownPaymentsRemainingFirstAmountIsNotNull() {
			addCriterion("DOWN_PAYMENTS_REMAINING_FIRST_AMOUNT is not null");
			return (Criteria) this;
		}

		public Criteria andDownPaymentsRemainingFirstAmountEqualTo(String value) {
			addCriterion("DOWN_PAYMENTS_REMAINING_FIRST_AMOUNT =", value, "downPaymentsRemainingFirstAmount");
			return (Criteria) this;
		}

		public Criteria andDownPaymentsRemainingFirstAmountNotEqualTo(String value) {
			addCriterion("DOWN_PAYMENTS_REMAINING_FIRST_AMOUNT <>", value, "downPaymentsRemainingFirstAmount");
			return (Criteria) this;
		}

		public Criteria andDownPaymentsRemainingFirstAmountGreaterThan(String value) {
			addCriterion("DOWN_PAYMENTS_REMAINING_FIRST_AMOUNT >", value, "downPaymentsRemainingFirstAmount");
			return (Criteria) this;
		}

		public Criteria andDownPaymentsRemainingFirstAmountGreaterThanOrEqualTo(String value) {
			addCriterion("DOWN_PAYMENTS_REMAINING_FIRST_AMOUNT >=", value, "downPaymentsRemainingFirstAmount");
			return (Criteria) this;
		}

		public Criteria andDownPaymentsRemainingFirstAmountLessThan(String value) {
			addCriterion("DOWN_PAYMENTS_REMAINING_FIRST_AMOUNT <", value, "downPaymentsRemainingFirstAmount");
			return (Criteria) this;
		}

		public Criteria andDownPaymentsRemainingFirstAmountLessThanOrEqualTo(String value) {
			addCriterion("DOWN_PAYMENTS_REMAINING_FIRST_AMOUNT <=", value, "downPaymentsRemainingFirstAmount");
			return (Criteria) this;
		}

		public Criteria andDownPaymentsRemainingFirstAmountLike(String value) {
			addCriterion("DOWN_PAYMENTS_REMAINING_FIRST_AMOUNT like", value, "downPaymentsRemainingFirstAmount");
			return (Criteria) this;
		}

		public Criteria andDownPaymentsRemainingFirstAmountNotLike(String value) {
			addCriterion("DOWN_PAYMENTS_REMAINING_FIRST_AMOUNT not like", value, "downPaymentsRemainingFirstAmount");
			return (Criteria) this;
		}

		public Criteria andDownPaymentsRemainingFirstAmountIn(List<String> values) {
			addCriterion("DOWN_PAYMENTS_REMAINING_FIRST_AMOUNT in", values, "downPaymentsRemainingFirstAmount");
			return (Criteria) this;
		}

		public Criteria andDownPaymentsRemainingFirstAmountNotIn(List<String> values) {
			addCriterion("DOWN_PAYMENTS_REMAINING_FIRST_AMOUNT not in", values, "downPaymentsRemainingFirstAmount");
			return (Criteria) this;
		}

		public Criteria andDownPaymentsRemainingFirstAmountBetween(String value1, String value2) {
			addCriterion("DOWN_PAYMENTS_REMAINING_FIRST_AMOUNT between", value1, value2,
					"downPaymentsRemainingFirstAmount");
			return (Criteria) this;
		}

		public Criteria andDownPaymentsRemainingFirstAmountNotBetween(String value1, String value2) {
			addCriterion("DOWN_PAYMENTS_REMAINING_FIRST_AMOUNT not between", value1, value2,
					"downPaymentsRemainingFirstAmount");
			return (Criteria) this;
		}

		public Criteria andHousePriceLastPayAmount3IsNull() {
			addCriterion("HOUSE_PRICE_LAST_PAY_AMOUNT3 is null");
			return (Criteria) this;
		}

		public Criteria andHousePriceLastPayAmount3IsNotNull() {
			addCriterion("HOUSE_PRICE_LAST_PAY_AMOUNT3 is not null");
			return (Criteria) this;
		}

		public Criteria andHousePriceLastPayAmount3EqualTo(String value) {
			addCriterion("HOUSE_PRICE_LAST_PAY_AMOUNT3 =", value, "housePriceLastPayAmount3");
			return (Criteria) this;
		}

		public Criteria andHousePriceLastPayAmount3NotEqualTo(String value) {
			addCriterion("HOUSE_PRICE_LAST_PAY_AMOUNT3 <>", value, "housePriceLastPayAmount3");
			return (Criteria) this;
		}

		public Criteria andHousePriceLastPayAmount3GreaterThan(String value) {
			addCriterion("HOUSE_PRICE_LAST_PAY_AMOUNT3 >", value, "housePriceLastPayAmount3");
			return (Criteria) this;
		}

		public Criteria andHousePriceLastPayAmount3GreaterThanOrEqualTo(String value) {
			addCriterion("HOUSE_PRICE_LAST_PAY_AMOUNT3 >=", value, "housePriceLastPayAmount3");
			return (Criteria) this;
		}

		public Criteria andHousePriceLastPayAmount3LessThan(String value) {
			addCriterion("HOUSE_PRICE_LAST_PAY_AMOUNT3 <", value, "housePriceLastPayAmount3");
			return (Criteria) this;
		}

		public Criteria andHousePriceLastPayAmount3LessThanOrEqualTo(String value) {
			addCriterion("HOUSE_PRICE_LAST_PAY_AMOUNT3 <=", value, "housePriceLastPayAmount3");
			return (Criteria) this;
		}

		public Criteria andHousePriceLastPayAmount3Like(String value) {
			addCriterion("HOUSE_PRICE_LAST_PAY_AMOUNT3 like", value, "housePriceLastPayAmount3");
			return (Criteria) this;
		}

		public Criteria andHousePriceLastPayAmount3NotLike(String value) {
			addCriterion("HOUSE_PRICE_LAST_PAY_AMOUNT3 not like", value, "housePriceLastPayAmount3");
			return (Criteria) this;
		}

		public Criteria andHousePriceLastPayAmount3In(List<String> values) {
			addCriterion("HOUSE_PRICE_LAST_PAY_AMOUNT3 in", values, "housePriceLastPayAmount3");
			return (Criteria) this;
		}

		public Criteria andHousePriceLastPayAmount3NotIn(List<String> values) {
			addCriterion("HOUSE_PRICE_LAST_PAY_AMOUNT3 not in", values, "housePriceLastPayAmount3");
			return (Criteria) this;
		}

		public Criteria andHousePriceLastPayAmount3Between(String value1, String value2) {
			addCriterion("HOUSE_PRICE_LAST_PAY_AMOUNT3 between", value1, value2, "housePriceLastPayAmount3");
			return (Criteria) this;
		}

		public Criteria andHousePriceLastPayAmount3NotBetween(String value1, String value2) {
			addCriterion("HOUSE_PRICE_LAST_PAY_AMOUNT3 not between", value1, value2, "housePriceLastPayAmount3");
			return (Criteria) this;
		}

		public Criteria andHousePriceLastPayAmount2IsNull() {
			addCriterion("HOUSE_PRICE_LAST_PAY_AMOUNT2 is null");
			return (Criteria) this;
		}

		public Criteria andHousePriceLastPayAmount2IsNotNull() {
			addCriterion("HOUSE_PRICE_LAST_PAY_AMOUNT2 is not null");
			return (Criteria) this;
		}

		public Criteria andHousePriceLastPayAmount2EqualTo(String value) {
			addCriterion("HOUSE_PRICE_LAST_PAY_AMOUNT2 =", value, "housePriceLastPayAmount2");
			return (Criteria) this;
		}

		public Criteria andHousePriceLastPayAmount2NotEqualTo(String value) {
			addCriterion("HOUSE_PRICE_LAST_PAY_AMOUNT2 <>", value, "housePriceLastPayAmount2");
			return (Criteria) this;
		}

		public Criteria andHousePriceLastPayAmount2GreaterThan(String value) {
			addCriterion("HOUSE_PRICE_LAST_PAY_AMOUNT2 >", value, "housePriceLastPayAmount2");
			return (Criteria) this;
		}

		public Criteria andHousePriceLastPayAmount2GreaterThanOrEqualTo(String value) {
			addCriterion("HOUSE_PRICE_LAST_PAY_AMOUNT2 >=", value, "housePriceLastPayAmount2");
			return (Criteria) this;
		}

		public Criteria andHousePriceLastPayAmount2LessThan(String value) {
			addCriterion("HOUSE_PRICE_LAST_PAY_AMOUNT2 <", value, "housePriceLastPayAmount2");
			return (Criteria) this;
		}

		public Criteria andHousePriceLastPayAmount2LessThanOrEqualTo(String value) {
			addCriterion("HOUSE_PRICE_LAST_PAY_AMOUNT2 <=", value, "housePriceLastPayAmount2");
			return (Criteria) this;
		}

		public Criteria andHousePriceLastPayAmount2Like(String value) {
			addCriterion("HOUSE_PRICE_LAST_PAY_AMOUNT2 like", value, "housePriceLastPayAmount2");
			return (Criteria) this;
		}

		public Criteria andHousePriceLastPayAmount2NotLike(String value) {
			addCriterion("HOUSE_PRICE_LAST_PAY_AMOUNT2 not like", value, "housePriceLastPayAmount2");
			return (Criteria) this;
		}

		public Criteria andHousePriceLastPayAmount2In(List<String> values) {
			addCriterion("HOUSE_PRICE_LAST_PAY_AMOUNT2 in", values, "housePriceLastPayAmount2");
			return (Criteria) this;
		}

		public Criteria andHousePriceLastPayAmount2NotIn(List<String> values) {
			addCriterion("HOUSE_PRICE_LAST_PAY_AMOUNT2 not in", values, "housePriceLastPayAmount2");
			return (Criteria) this;
		}

		public Criteria andHousePriceLastPayAmount2Between(String value1, String value2) {
			addCriterion("HOUSE_PRICE_LAST_PAY_AMOUNT2 between", value1, value2, "housePriceLastPayAmount2");
			return (Criteria) this;
		}

		public Criteria andHousePriceLastPayAmount2NotBetween(String value1, String value2) {
			addCriterion("HOUSE_PRICE_LAST_PAY_AMOUNT2 not between", value1, value2, "housePriceLastPayAmount2");
			return (Criteria) this;
		}

		public Criteria andDownPaymentsPayAmount3IsNull() {
			addCriterion("DOWN_PAYMENTS_PAY_AMOUNT3 is null");
			return (Criteria) this;
		}

		public Criteria andDownPaymentsPayAmount3IsNotNull() {
			addCriterion("DOWN_PAYMENTS_PAY_AMOUNT3 is not null");
			return (Criteria) this;
		}

		public Criteria andDownPaymentsPayAmount3EqualTo(String value) {
			addCriterion("DOWN_PAYMENTS_PAY_AMOUNT3 =", value, "downPaymentsPayAmount3");
			return (Criteria) this;
		}

		public Criteria andDownPaymentsPayAmount3NotEqualTo(String value) {
			addCriterion("DOWN_PAYMENTS_PAY_AMOUNT3 <>", value, "downPaymentsPayAmount3");
			return (Criteria) this;
		}

		public Criteria andDownPaymentsPayAmount3GreaterThan(String value) {
			addCriterion("DOWN_PAYMENTS_PAY_AMOUNT3 >", value, "downPaymentsPayAmount3");
			return (Criteria) this;
		}

		public Criteria andDownPaymentsPayAmount3GreaterThanOrEqualTo(String value) {
			addCriterion("DOWN_PAYMENTS_PAY_AMOUNT3 >=", value, "downPaymentsPayAmount3");
			return (Criteria) this;
		}

		public Criteria andDownPaymentsPayAmount3LessThan(String value) {
			addCriterion("DOWN_PAYMENTS_PAY_AMOUNT3 <", value, "downPaymentsPayAmount3");
			return (Criteria) this;
		}

		public Criteria andDownPaymentsPayAmount3LessThanOrEqualTo(String value) {
			addCriterion("DOWN_PAYMENTS_PAY_AMOUNT3 <=", value, "downPaymentsPayAmount3");
			return (Criteria) this;
		}

		public Criteria andDownPaymentsPayAmount3Like(String value) {
			addCriterion("DOWN_PAYMENTS_PAY_AMOUNT3 like", value, "downPaymentsPayAmount3");
			return (Criteria) this;
		}

		public Criteria andDownPaymentsPayAmount3NotLike(String value) {
			addCriterion("DOWN_PAYMENTS_PAY_AMOUNT3 not like", value, "downPaymentsPayAmount3");
			return (Criteria) this;
		}

		public Criteria andDownPaymentsPayAmount3In(List<String> values) {
			addCriterion("DOWN_PAYMENTS_PAY_AMOUNT3 in", values, "downPaymentsPayAmount3");
			return (Criteria) this;
		}

		public Criteria andDownPaymentsPayAmount3NotIn(List<String> values) {
			addCriterion("DOWN_PAYMENTS_PAY_AMOUNT3 not in", values, "downPaymentsPayAmount3");
			return (Criteria) this;
		}

		public Criteria andDownPaymentsPayAmount3Between(String value1, String value2) {
			addCriterion("DOWN_PAYMENTS_PAY_AMOUNT3 between", value1, value2, "downPaymentsPayAmount3");
			return (Criteria) this;
		}

		public Criteria andDownPaymentsPayAmount3NotBetween(String value1, String value2) {
			addCriterion("DOWN_PAYMENTS_PAY_AMOUNT3 not between", value1, value2, "downPaymentsPayAmount3");
			return (Criteria) this;
		}

		public Criteria andDownPaymentsPayAmount2IsNull() {
			addCriterion("DOWN_PAYMENTS_PAY_AMOUNT2 is null");
			return (Criteria) this;
		}

		public Criteria andDownPaymentsPayAmount2IsNotNull() {
			addCriterion("DOWN_PAYMENTS_PAY_AMOUNT2 is not null");
			return (Criteria) this;
		}

		public Criteria andDownPaymentsPayAmount2EqualTo(String value) {
			addCriterion("DOWN_PAYMENTS_PAY_AMOUNT2 =", value, "downPaymentsPayAmount2");
			return (Criteria) this;
		}

		public Criteria andDownPaymentsPayAmount2NotEqualTo(String value) {
			addCriterion("DOWN_PAYMENTS_PAY_AMOUNT2 <>", value, "downPaymentsPayAmount2");
			return (Criteria) this;
		}

		public Criteria andDownPaymentsPayAmount2GreaterThan(String value) {
			addCriterion("DOWN_PAYMENTS_PAY_AMOUNT2 >", value, "downPaymentsPayAmount2");
			return (Criteria) this;
		}

		public Criteria andDownPaymentsPayAmount2GreaterThanOrEqualTo(String value) {
			addCriterion("DOWN_PAYMENTS_PAY_AMOUNT2 >=", value, "downPaymentsPayAmount2");
			return (Criteria) this;
		}

		public Criteria andDownPaymentsPayAmount2LessThan(String value) {
			addCriterion("DOWN_PAYMENTS_PAY_AMOUNT2 <", value, "downPaymentsPayAmount2");
			return (Criteria) this;
		}

		public Criteria andDownPaymentsPayAmount2LessThanOrEqualTo(String value) {
			addCriterion("DOWN_PAYMENTS_PAY_AMOUNT2 <=", value, "downPaymentsPayAmount2");
			return (Criteria) this;
		}

		public Criteria andDownPaymentsPayAmount2Like(String value) {
			addCriterion("DOWN_PAYMENTS_PAY_AMOUNT2 like", value, "downPaymentsPayAmount2");
			return (Criteria) this;
		}

		public Criteria andDownPaymentsPayAmount2NotLike(String value) {
			addCriterion("DOWN_PAYMENTS_PAY_AMOUNT2 not like", value, "downPaymentsPayAmount2");
			return (Criteria) this;
		}

		public Criteria andDownPaymentsPayAmount2In(List<String> values) {
			addCriterion("DOWN_PAYMENTS_PAY_AMOUNT2 in", values, "downPaymentsPayAmount2");
			return (Criteria) this;
		}

		public Criteria andDownPaymentsPayAmount2NotIn(List<String> values) {
			addCriterion("DOWN_PAYMENTS_PAY_AMOUNT2 not in", values, "downPaymentsPayAmount2");
			return (Criteria) this;
		}

		public Criteria andDownPaymentsPayAmount2Between(String value1, String value2) {
			addCriterion("DOWN_PAYMENTS_PAY_AMOUNT2 between", value1, value2, "downPaymentsPayAmount2");
			return (Criteria) this;
		}

		public Criteria andDownPaymentsPayAmount2NotBetween(String value1, String value2) {
			addCriterion("DOWN_PAYMENTS_PAY_AMOUNT2 not between", value1, value2, "downPaymentsPayAmount2");
			return (Criteria) this;
		}

		public Criteria andNoPassSloutionAmountIsNull() {
			addCriterion("NO_PASS_SLOUTION_AMOUNT is null");
			return (Criteria) this;
		}

		public Criteria andNoPassSloutionAmountIsNotNull() {
			addCriterion("NO_PASS_SLOUTION_AMOUNT is not null");
			return (Criteria) this;
		}

		public Criteria andNoPassSloutionAmountEqualTo(String value) {
			addCriterion("NO_PASS_SLOUTION_AMOUNT =", value, "noPassSloutionAmount");
			return (Criteria) this;
		}

		public Criteria andNoPassSloutionAmountNotEqualTo(String value) {
			addCriterion("NO_PASS_SLOUTION_AMOUNT <>", value, "noPassSloutionAmount");
			return (Criteria) this;
		}

		public Criteria andNoPassSloutionAmountGreaterThan(String value) {
			addCriterion("NO_PASS_SLOUTION_AMOUNT >", value, "noPassSloutionAmount");
			return (Criteria) this;
		}

		public Criteria andNoPassSloutionAmountGreaterThanOrEqualTo(String value) {
			addCriterion("NO_PASS_SLOUTION_AMOUNT >=", value, "noPassSloutionAmount");
			return (Criteria) this;
		}

		public Criteria andNoPassSloutionAmountLessThan(String value) {
			addCriterion("NO_PASS_SLOUTION_AMOUNT <", value, "noPassSloutionAmount");
			return (Criteria) this;
		}

		public Criteria andNoPassSloutionAmountLessThanOrEqualTo(String value) {
			addCriterion("NO_PASS_SLOUTION_AMOUNT <=", value, "noPassSloutionAmount");
			return (Criteria) this;
		}

		public Criteria andNoPassSloutionAmountLike(String value) {
			addCriterion("NO_PASS_SLOUTION_AMOUNT like", value, "noPassSloutionAmount");
			return (Criteria) this;
		}

		public Criteria andNoPassSloutionAmountNotLike(String value) {
			addCriterion("NO_PASS_SLOUTION_AMOUNT not like", value, "noPassSloutionAmount");
			return (Criteria) this;
		}

		public Criteria andNoPassSloutionAmountIn(List<String> values) {
			addCriterion("NO_PASS_SLOUTION_AMOUNT in", values, "noPassSloutionAmount");
			return (Criteria) this;
		}

		public Criteria andNoPassSloutionAmountNotIn(List<String> values) {
			addCriterion("NO_PASS_SLOUTION_AMOUNT not in", values, "noPassSloutionAmount");
			return (Criteria) this;
		}

		public Criteria andNoPassSloutionAmountBetween(String value1, String value2) {
			addCriterion("NO_PASS_SLOUTION_AMOUNT between", value1, value2, "noPassSloutionAmount");
			return (Criteria) this;
		}

		public Criteria andNoPassSloutionAmountNotBetween(String value1, String value2) {
			addCriterion("NO_PASS_SLOUTION_AMOUNT not between", value1, value2, "noPassSloutionAmount");
			return (Criteria) this;
		}

		public Criteria andHousePriceLastPayAmount1IsNull() {
			addCriterion("HOUSE_PRICE_LAST_PAY_AMOUNT1 is null");
			return (Criteria) this;
		}

		public Criteria andHousePriceLastPayAmount1IsNotNull() {
			addCriterion("HOUSE_PRICE_LAST_PAY_AMOUNT1 is not null");
			return (Criteria) this;
		}

		public Criteria andHousePriceLastPayAmount1EqualTo(String value) {
			addCriterion("HOUSE_PRICE_LAST_PAY_AMOUNT1 =", value, "housePriceLastPayAmount1");
			return (Criteria) this;
		}

		public Criteria andHousePriceLastPayAmount1NotEqualTo(String value) {
			addCriterion("HOUSE_PRICE_LAST_PAY_AMOUNT1 <>", value, "housePriceLastPayAmount1");
			return (Criteria) this;
		}

		public Criteria andHousePriceLastPayAmount1GreaterThan(String value) {
			addCriterion("HOUSE_PRICE_LAST_PAY_AMOUNT1 >", value, "housePriceLastPayAmount1");
			return (Criteria) this;
		}

		public Criteria andHousePriceLastPayAmount1GreaterThanOrEqualTo(String value) {
			addCriterion("HOUSE_PRICE_LAST_PAY_AMOUNT1 >=", value, "housePriceLastPayAmount1");
			return (Criteria) this;
		}

		public Criteria andHousePriceLastPayAmount1LessThan(String value) {
			addCriterion("HOUSE_PRICE_LAST_PAY_AMOUNT1 <", value, "housePriceLastPayAmount1");
			return (Criteria) this;
		}

		public Criteria andHousePriceLastPayAmount1LessThanOrEqualTo(String value) {
			addCriterion("HOUSE_PRICE_LAST_PAY_AMOUNT1 <=", value, "housePriceLastPayAmount1");
			return (Criteria) this;
		}

		public Criteria andHousePriceLastPayAmount1Like(String value) {
			addCriterion("HOUSE_PRICE_LAST_PAY_AMOUNT1 like", value, "housePriceLastPayAmount1");
			return (Criteria) this;
		}

		public Criteria andHousePriceLastPayAmount1NotLike(String value) {
			addCriterion("HOUSE_PRICE_LAST_PAY_AMOUNT1 not like", value, "housePriceLastPayAmount1");
			return (Criteria) this;
		}

		public Criteria andHousePriceLastPayAmount1In(List<String> values) {
			addCriterion("HOUSE_PRICE_LAST_PAY_AMOUNT1 in", values, "housePriceLastPayAmount1");
			return (Criteria) this;
		}

		public Criteria andHousePriceLastPayAmount1NotIn(List<String> values) {
			addCriterion("HOUSE_PRICE_LAST_PAY_AMOUNT1 not in", values, "housePriceLastPayAmount1");
			return (Criteria) this;
		}

		public Criteria andHousePriceLastPayAmount1Between(String value1, String value2) {
			addCriterion("HOUSE_PRICE_LAST_PAY_AMOUNT1 between", value1, value2, "housePriceLastPayAmount1");
			return (Criteria) this;
		}

		public Criteria andHousePriceLastPayAmount1NotBetween(String value1, String value2) {
			addCriterion("HOUSE_PRICE_LAST_PAY_AMOUNT1 not between", value1, value2, "housePriceLastPayAmount1");
			return (Criteria) this;
		}

		public Criteria andDownPaymentsPayAmount1IsNull() {
			addCriterion("DOWN_PAYMENTS_PAY_AMOUNT1 is null");
			return (Criteria) this;
		}

		public Criteria andDownPaymentsPayAmount1IsNotNull() {
			addCriterion("DOWN_PAYMENTS_PAY_AMOUNT1 is not null");
			return (Criteria) this;
		}

		public Criteria andDownPaymentsPayAmount1EqualTo(String value) {
			addCriterion("DOWN_PAYMENTS_PAY_AMOUNT1 =", value, "downPaymentsPayAmount1");
			return (Criteria) this;
		}

		public Criteria andDownPaymentsPayAmount1NotEqualTo(String value) {
			addCriterion("DOWN_PAYMENTS_PAY_AMOUNT1 <>", value, "downPaymentsPayAmount1");
			return (Criteria) this;
		}

		public Criteria andDownPaymentsPayAmount1GreaterThan(String value) {
			addCriterion("DOWN_PAYMENTS_PAY_AMOUNT1 >", value, "downPaymentsPayAmount1");
			return (Criteria) this;
		}

		public Criteria andDownPaymentsPayAmount1GreaterThanOrEqualTo(String value) {
			addCriterion("DOWN_PAYMENTS_PAY_AMOUNT1 >=", value, "downPaymentsPayAmount1");
			return (Criteria) this;
		}

		public Criteria andDownPaymentsPayAmount1LessThan(String value) {
			addCriterion("DOWN_PAYMENTS_PAY_AMOUNT1 <", value, "downPaymentsPayAmount1");
			return (Criteria) this;
		}

		public Criteria andDownPaymentsPayAmount1LessThanOrEqualTo(String value) {
			addCriterion("DOWN_PAYMENTS_PAY_AMOUNT1 <=", value, "downPaymentsPayAmount1");
			return (Criteria) this;
		}

		public Criteria andDownPaymentsPayAmount1Like(String value) {
			addCriterion("DOWN_PAYMENTS_PAY_AMOUNT1 like", value, "downPaymentsPayAmount1");
			return (Criteria) this;
		}

		public Criteria andDownPaymentsPayAmount1NotLike(String value) {
			addCriterion("DOWN_PAYMENTS_PAY_AMOUNT1 not like", value, "downPaymentsPayAmount1");
			return (Criteria) this;
		}

		public Criteria andDownPaymentsPayAmount1In(List<String> values) {
			addCriterion("DOWN_PAYMENTS_PAY_AMOUNT1 in", values, "downPaymentsPayAmount1");
			return (Criteria) this;
		}

		public Criteria andDownPaymentsPayAmount1NotIn(List<String> values) {
			addCriterion("DOWN_PAYMENTS_PAY_AMOUNT1 not in", values, "downPaymentsPayAmount1");
			return (Criteria) this;
		}

		public Criteria andDownPaymentsPayAmount1Between(String value1, String value2) {
			addCriterion("DOWN_PAYMENTS_PAY_AMOUNT1 between", value1, value2, "downPaymentsPayAmount1");
			return (Criteria) this;
		}

		public Criteria andDownPaymentsPayAmount1NotBetween(String value1, String value2) {
			addCriterion("DOWN_PAYMENTS_PAY_AMOUNT1 not between", value1, value2, "downPaymentsPayAmount1");
			return (Criteria) this;
		}

		public Criteria andHousePriceLastAmountIsNull() {
			addCriterion("HOUSE_PRICE_LAST_AMOUNT is null");
			return (Criteria) this;
		}

		public Criteria andHousePriceLastAmountIsNotNull() {
			addCriterion("HOUSE_PRICE_LAST_AMOUNT is not null");
			return (Criteria) this;
		}

		public Criteria andHousePriceLastAmountEqualTo(String value) {
			addCriterion("HOUSE_PRICE_LAST_AMOUNT =", value, "housePriceLastAmount");
			return (Criteria) this;
		}

		public Criteria andHousePriceLastAmountNotEqualTo(String value) {
			addCriterion("HOUSE_PRICE_LAST_AMOUNT <>", value, "housePriceLastAmount");
			return (Criteria) this;
		}

		public Criteria andHousePriceLastAmountGreaterThan(String value) {
			addCriterion("HOUSE_PRICE_LAST_AMOUNT >", value, "housePriceLastAmount");
			return (Criteria) this;
		}

		public Criteria andHousePriceLastAmountGreaterThanOrEqualTo(String value) {
			addCriterion("HOUSE_PRICE_LAST_AMOUNT >=", value, "housePriceLastAmount");
			return (Criteria) this;
		}

		public Criteria andHousePriceLastAmountLessThan(String value) {
			addCriterion("HOUSE_PRICE_LAST_AMOUNT <", value, "housePriceLastAmount");
			return (Criteria) this;
		}

		public Criteria andHousePriceLastAmountLessThanOrEqualTo(String value) {
			addCriterion("HOUSE_PRICE_LAST_AMOUNT <=", value, "housePriceLastAmount");
			return (Criteria) this;
		}

		public Criteria andHousePriceLastAmountLike(String value) {
			addCriterion("HOUSE_PRICE_LAST_AMOUNT like", value, "housePriceLastAmount");
			return (Criteria) this;
		}

		public Criteria andHousePriceLastAmountNotLike(String value) {
			addCriterion("HOUSE_PRICE_LAST_AMOUNT not like", value, "housePriceLastAmount");
			return (Criteria) this;
		}

		public Criteria andHousePriceLastAmountIn(List<String> values) {
			addCriterion("HOUSE_PRICE_LAST_AMOUNT in", values, "housePriceLastAmount");
			return (Criteria) this;
		}

		public Criteria andHousePriceLastAmountNotIn(List<String> values) {
			addCriterion("HOUSE_PRICE_LAST_AMOUNT not in", values, "housePriceLastAmount");
			return (Criteria) this;
		}

		public Criteria andHousePriceLastAmountBetween(String value1, String value2) {
			addCriterion("HOUSE_PRICE_LAST_AMOUNT between", value1, value2, "housePriceLastAmount");
			return (Criteria) this;
		}

		public Criteria andHousePriceLastAmountNotBetween(String value1, String value2) {
			addCriterion("HOUSE_PRICE_LAST_AMOUNT not between", value1, value2, "housePriceLastAmount");
			return (Criteria) this;
		}

		public Criteria andDownPaymentsAmountIsNull() {
			addCriterion("DOWN_PAYMENTS_AMOUNT is null");
			return (Criteria) this;
		}

		public Criteria andDownPaymentsAmountIsNotNull() {
			addCriterion("DOWN_PAYMENTS_AMOUNT is not null");
			return (Criteria) this;
		}

		public Criteria andDownPaymentsAmountEqualTo(String value) {
			addCriterion("DOWN_PAYMENTS_AMOUNT =", value, "downPaymentsAmount");
			return (Criteria) this;
		}

		public Criteria andDownPaymentsAmountNotEqualTo(String value) {
			addCriterion("DOWN_PAYMENTS_AMOUNT <>", value, "downPaymentsAmount");
			return (Criteria) this;
		}

		public Criteria andDownPaymentsAmountGreaterThan(String value) {
			addCriterion("DOWN_PAYMENTS_AMOUNT >", value, "downPaymentsAmount");
			return (Criteria) this;
		}

		public Criteria andDownPaymentsAmountGreaterThanOrEqualTo(String value) {
			addCriterion("DOWN_PAYMENTS_AMOUNT >=", value, "downPaymentsAmount");
			return (Criteria) this;
		}

		public Criteria andDownPaymentsAmountLessThan(String value) {
			addCriterion("DOWN_PAYMENTS_AMOUNT <", value, "downPaymentsAmount");
			return (Criteria) this;
		}

		public Criteria andDownPaymentsAmountLessThanOrEqualTo(String value) {
			addCriterion("DOWN_PAYMENTS_AMOUNT <=", value, "downPaymentsAmount");
			return (Criteria) this;
		}

		public Criteria andDownPaymentsAmountLike(String value) {
			addCriterion("DOWN_PAYMENTS_AMOUNT like", value, "downPaymentsAmount");
			return (Criteria) this;
		}

		public Criteria andDownPaymentsAmountNotLike(String value) {
			addCriterion("DOWN_PAYMENTS_AMOUNT not like", value, "downPaymentsAmount");
			return (Criteria) this;
		}

		public Criteria andDownPaymentsAmountIn(List<String> values) {
			addCriterion("DOWN_PAYMENTS_AMOUNT in", values, "downPaymentsAmount");
			return (Criteria) this;
		}

		public Criteria andDownPaymentsAmountNotIn(List<String> values) {
			addCriterion("DOWN_PAYMENTS_AMOUNT not in", values, "downPaymentsAmount");
			return (Criteria) this;
		}

		public Criteria andDownPaymentsAmountBetween(String value1, String value2) {
			addCriterion("DOWN_PAYMENTS_AMOUNT between", value1, value2, "downPaymentsAmount");
			return (Criteria) this;
		}

		public Criteria andDownPaymentsAmountNotBetween(String value1, String value2) {
			addCriterion("DOWN_PAYMENTS_AMOUNT not between", value1, value2, "downPaymentsAmount");
			return (Criteria) this;
		}

		public Criteria andDepositAmountIsNull() {
			addCriterion("DEPOSIT_AMOUNT is null");
			return (Criteria) this;
		}

		public Criteria andDepositAmountIsNotNull() {
			addCriterion("DEPOSIT_AMOUNT is not null");
			return (Criteria) this;
		}

		public Criteria andDepositAmountEqualTo(String value) {
			addCriterion("DEPOSIT_AMOUNT =", value, "depositAmount");
			return (Criteria) this;
		}

		public Criteria andDepositAmountNotEqualTo(String value) {
			addCriterion("DEPOSIT_AMOUNT <>", value, "depositAmount");
			return (Criteria) this;
		}

		public Criteria andDepositAmountGreaterThan(String value) {
			addCriterion("DEPOSIT_AMOUNT >", value, "depositAmount");
			return (Criteria) this;
		}

		public Criteria andDepositAmountGreaterThanOrEqualTo(String value) {
			addCriterion("DEPOSIT_AMOUNT >=", value, "depositAmount");
			return (Criteria) this;
		}

		public Criteria andDepositAmountLessThan(String value) {
			addCriterion("DEPOSIT_AMOUNT <", value, "depositAmount");
			return (Criteria) this;
		}

		public Criteria andDepositAmountLessThanOrEqualTo(String value) {
			addCriterion("DEPOSIT_AMOUNT <=", value, "depositAmount");
			return (Criteria) this;
		}

		public Criteria andDepositAmountLike(String value) {
			addCriterion("DEPOSIT_AMOUNT like", value, "depositAmount");
			return (Criteria) this;
		}

		public Criteria andDepositAmountNotLike(String value) {
			addCriterion("DEPOSIT_AMOUNT not like", value, "depositAmount");
			return (Criteria) this;
		}

		public Criteria andDepositAmountIn(List<String> values) {
			addCriterion("DEPOSIT_AMOUNT in", values, "depositAmount");
			return (Criteria) this;
		}

		public Criteria andDepositAmountNotIn(List<String> values) {
			addCriterion("DEPOSIT_AMOUNT not in", values, "depositAmount");
			return (Criteria) this;
		}

		public Criteria andDepositAmountBetween(String value1, String value2) {
			addCriterion("DEPOSIT_AMOUNT between", value1, value2, "depositAmount");
			return (Criteria) this;
		}

		public Criteria andDepositAmountNotBetween(String value1, String value2) {
			addCriterion("DEPOSIT_AMOUNT not between", value1, value2, "depositAmount");
			return (Criteria) this;
		}

		public Criteria andMortgageAmountIsNull() {
			addCriterion("MORTGAGE_AMOUNT is null");
			return (Criteria) this;
		}

		public Criteria andMortgageAmountIsNotNull() {
			addCriterion("MORTGAGE_AMOUNT is not null");
			return (Criteria) this;
		}

		public Criteria andMortgageAmountEqualTo(String value) {
			addCriterion("MORTGAGE_AMOUNT =", value, "mortgageAmount");
			return (Criteria) this;
		}

		public Criteria andMortgageAmountNotEqualTo(String value) {
			addCriterion("MORTGAGE_AMOUNT <>", value, "mortgageAmount");
			return (Criteria) this;
		}

		public Criteria andMortgageAmountGreaterThan(String value) {
			addCriterion("MORTGAGE_AMOUNT >", value, "mortgageAmount");
			return (Criteria) this;
		}

		public Criteria andMortgageAmountGreaterThanOrEqualTo(String value) {
			addCriterion("MORTGAGE_AMOUNT >=", value, "mortgageAmount");
			return (Criteria) this;
		}

		public Criteria andMortgageAmountLessThan(String value) {
			addCriterion("MORTGAGE_AMOUNT <", value, "mortgageAmount");
			return (Criteria) this;
		}

		public Criteria andMortgageAmountLessThanOrEqualTo(String value) {
			addCriterion("MORTGAGE_AMOUNT <=", value, "mortgageAmount");
			return (Criteria) this;
		}

		public Criteria andMortgageAmountLike(String value) {
			addCriterion("MORTGAGE_AMOUNT like", value, "mortgageAmount");
			return (Criteria) this;
		}

		public Criteria andMortgageAmountNotLike(String value) {
			addCriterion("MORTGAGE_AMOUNT not like", value, "mortgageAmount");
			return (Criteria) this;
		}

		public Criteria andMortgageAmountIn(List<String> values) {
			addCriterion("MORTGAGE_AMOUNT in", values, "mortgageAmount");
			return (Criteria) this;
		}

		public Criteria andMortgageAmountNotIn(List<String> values) {
			addCriterion("MORTGAGE_AMOUNT not in", values, "mortgageAmount");
			return (Criteria) this;
		}

		public Criteria andMortgageAmountBetween(String value1, String value2) {
			addCriterion("MORTGAGE_AMOUNT between", value1, value2, "mortgageAmount");
			return (Criteria) this;
		}

		public Criteria andMortgageAmountNotBetween(String value1, String value2) {
			addCriterion("MORTGAGE_AMOUNT not between", value1, value2, "mortgageAmount");
			return (Criteria) this;
		}

		public Criteria andSignUserArchiveIsNull() {
			addCriterion("SIGN_USER_ARCHIVE is null");
			return (Criteria) this;
		}

		public Criteria andSignUserArchiveIsNotNull() {
			addCriterion("SIGN_USER_ARCHIVE is not null");
			return (Criteria) this;
		}

		public Criteria andSignUserArchiveEqualTo(Integer value) {
			addCriterion("SIGN_USER_ARCHIVE =", value, "signUserArchive");
			return (Criteria) this;
		}

		public Criteria andSignUserArchiveNotEqualTo(Integer value) {
			addCriterion("SIGN_USER_ARCHIVE <>", value, "signUserArchive");
			return (Criteria) this;
		}

		public Criteria andSignUserArchiveGreaterThan(Integer value) {
			addCriterion("SIGN_USER_ARCHIVE >", value, "signUserArchive");
			return (Criteria) this;
		}

		public Criteria andSignUserArchiveGreaterThanOrEqualTo(Integer value) {
			addCriterion("SIGN_USER_ARCHIVE >=", value, "signUserArchive");
			return (Criteria) this;
		}

		public Criteria andSignUserArchiveLessThan(Integer value) {
			addCriterion("SIGN_USER_ARCHIVE <", value, "signUserArchive");
			return (Criteria) this;
		}

		public Criteria andSignUserArchiveLessThanOrEqualTo(Integer value) {
			addCriterion("SIGN_USER_ARCHIVE <=", value, "signUserArchive");
			return (Criteria) this;
		}

		public Criteria andSignUserArchiveIn(List<Integer> values) {
			addCriterion("SIGN_USER_ARCHIVE in", values, "signUserArchive");
			return (Criteria) this;
		}

		public Criteria andSignUserArchiveNotIn(List<Integer> values) {
			addCriterion("SIGN_USER_ARCHIVE not in", values, "signUserArchive");
			return (Criteria) this;
		}

		public Criteria andSignUserArchiveBetween(Integer value1, Integer value2) {
			addCriterion("SIGN_USER_ARCHIVE between", value1, value2, "signUserArchive");
			return (Criteria) this;
		}

		public Criteria andSignUserArchiveNotBetween(Integer value1, Integer value2) {
			addCriterion("SIGN_USER_ARCHIVE not between", value1, value2, "signUserArchive");
			return (Criteria) this;
		}

		public Criteria andBuyIdCardTypeIsNull() {
			addCriterion("BUY_ID_CARD_TYPE is null");
			return (Criteria) this;
		}

		public Criteria andBuyIdCardTypeIsNotNull() {
			addCriterion("BUY_ID_CARD_TYPE is not null");
			return (Criteria) this;
		}

		public Criteria andBuyIdCardTypeEqualTo(Integer value) {
			addCriterion("BUY_ID_CARD_TYPE =", value, "buyIdCardType");
			return (Criteria) this;
		}

		public Criteria andBuyIdCardTypeNotEqualTo(Integer value) {
			addCriterion("BUY_ID_CARD_TYPE <>", value, "buyIdCardType");
			return (Criteria) this;
		}

		public Criteria andBuyIdCardTypeGreaterThan(Integer value) {
			addCriterion("BUY_ID_CARD_TYPE >", value, "buyIdCardType");
			return (Criteria) this;
		}

		public Criteria andBuyIdCardTypeGreaterThanOrEqualTo(Integer value) {
			addCriterion("BUY_ID_CARD_TYPE >=", value, "buyIdCardType");
			return (Criteria) this;
		}

		public Criteria andBuyIdCardTypeLessThan(Integer value) {
			addCriterion("BUY_ID_CARD_TYPE <", value, "buyIdCardType");
			return (Criteria) this;
		}

		public Criteria andBuyIdCardTypeLessThanOrEqualTo(Integer value) {
			addCriterion("BUY_ID_CARD_TYPE <=", value, "buyIdCardType");
			return (Criteria) this;
		}

		public Criteria andBuyIdCardTypeIn(List<Integer> values) {
			addCriterion("BUY_ID_CARD_TYPE in", values, "buyIdCardType");
			return (Criteria) this;
		}

		public Criteria andBuyIdCardTypeNotIn(List<Integer> values) {
			addCriterion("BUY_ID_CARD_TYPE not in", values, "buyIdCardType");
			return (Criteria) this;
		}

		public Criteria andBuyIdCardTypeBetween(Integer value1, Integer value2) {
			addCriterion("BUY_ID_CARD_TYPE between", value1, value2, "buyIdCardType");
			return (Criteria) this;
		}

		public Criteria andBuyIdCardTypeNotBetween(Integer value1, Integer value2) {
			addCriterion("BUY_ID_CARD_TYPE not between", value1, value2, "buyIdCardType");
			return (Criteria) this;
		}

		public Criteria andSellIdCardTypeIsNull() {
			addCriterion("SELL_ID_CARD_TYPE is null");
			return (Criteria) this;
		}

		public Criteria andSellIdCardTypeIsNotNull() {
			addCriterion("SELL_ID_CARD_TYPE is not null");
			return (Criteria) this;
		}

		public Criteria andSellIdCardTypeEqualTo(Integer value) {
			addCriterion("SELL_ID_CARD_TYPE =", value, "sellIdCardType");
			return (Criteria) this;
		}

		public Criteria andSellIdCardTypeNotEqualTo(Integer value) {
			addCriterion("SELL_ID_CARD_TYPE <>", value, "sellIdCardType");
			return (Criteria) this;
		}

		public Criteria andSellIdCardTypeGreaterThan(Integer value) {
			addCriterion("SELL_ID_CARD_TYPE >", value, "sellIdCardType");
			return (Criteria) this;
		}

		public Criteria andSellIdCardTypeGreaterThanOrEqualTo(Integer value) {
			addCriterion("SELL_ID_CARD_TYPE >=", value, "sellIdCardType");
			return (Criteria) this;
		}

		public Criteria andSellIdCardTypeLessThan(Integer value) {
			addCriterion("SELL_ID_CARD_TYPE <", value, "sellIdCardType");
			return (Criteria) this;
		}

		public Criteria andSellIdCardTypeLessThanOrEqualTo(Integer value) {
			addCriterion("SELL_ID_CARD_TYPE <=", value, "sellIdCardType");
			return (Criteria) this;
		}

		public Criteria andSellIdCardTypeIn(List<Integer> values) {
			addCriterion("SELL_ID_CARD_TYPE in", values, "sellIdCardType");
			return (Criteria) this;
		}

		public Criteria andSellIdCardTypeNotIn(List<Integer> values) {
			addCriterion("SELL_ID_CARD_TYPE not in", values, "sellIdCardType");
			return (Criteria) this;
		}

		public Criteria andSellIdCardTypeBetween(Integer value1, Integer value2) {
			addCriterion("SELL_ID_CARD_TYPE between", value1, value2, "sellIdCardType");
			return (Criteria) this;
		}

		public Criteria andSellIdCardTypeNotBetween(Integer value1, Integer value2) {
			addCriterion("SELL_ID_CARD_TYPE not between", value1, value2, "sellIdCardType");
			return (Criteria) this;
		}

		public Criteria andSellIdCardBakTypeIsNull() {
			addCriterion("SELL_ID_CARD_BAK_TYPE is null");
			return (Criteria) this;
		}

		public Criteria andSellIdCardBakTypeIsNotNull() {
			addCriterion("SELL_ID_CARD_BAK_TYPE is not null");
			return (Criteria) this;
		}

		public Criteria andSellIdCardBakTypeEqualTo(Integer value) {
			addCriterion("SELL_ID_CARD_BAK_TYPE =", value, "sellIdCardBakType");
			return (Criteria) this;
		}

		public Criteria andSellIdCardBakTypeNotEqualTo(Integer value) {
			addCriterion("SELL_ID_CARD_BAK_TYPE <>", value, "sellIdCardBakType");
			return (Criteria) this;
		}

		public Criteria andSellIdCardBakTypeGreaterThan(Integer value) {
			addCriterion("SELL_ID_CARD_BAK_TYPE >", value, "sellIdCardBakType");
			return (Criteria) this;
		}

		public Criteria andSellIdCardBakTypeGreaterThanOrEqualTo(Integer value) {
			addCriterion("SELL_ID_CARD_BAK_TYPE >=", value, "sellIdCardBakType");
			return (Criteria) this;
		}

		public Criteria andSellIdCardBakTypeLessThan(Integer value) {
			addCriterion("SELL_ID_CARD_BAK_TYPE <", value, "sellIdCardBakType");
			return (Criteria) this;
		}

		public Criteria andSellIdCardBakTypeLessThanOrEqualTo(Integer value) {
			addCriterion("SELL_ID_CARD_BAK_TYPE <=", value, "sellIdCardBakType");
			return (Criteria) this;
		}

		public Criteria andSellIdCardBakTypeIn(List<Integer> values) {
			addCriterion("SELL_ID_CARD_BAK_TYPE in", values, "sellIdCardBakType");
			return (Criteria) this;
		}

		public Criteria andSellIdCardBakTypeNotIn(List<Integer> values) {
			addCriterion("SELL_ID_CARD_BAK_TYPE not in", values, "sellIdCardBakType");
			return (Criteria) this;
		}

		public Criteria andSellIdCardBakTypeBetween(Integer value1, Integer value2) {
			addCriterion("SELL_ID_CARD_BAK_TYPE between", value1, value2, "sellIdCardBakType");
			return (Criteria) this;
		}

		public Criteria andSellIdCardBakTypeNotBetween(Integer value1, Integer value2) {
			addCriterion("SELL_ID_CARD_BAK_TYPE not between", value1, value2, "sellIdCardBakType");
			return (Criteria) this;
		}

		public Criteria andBuyIdCardBakTypeIsNull() {
			addCriterion("BUY_ID_CARD_BAK_TYPE is null");
			return (Criteria) this;
		}

		public Criteria andBuyIdCardBakTypeIsNotNull() {
			addCriterion("BUY_ID_CARD_BAK_TYPE is not null");
			return (Criteria) this;
		}

		public Criteria andBuyIdCardBakTypeEqualTo(Integer value) {
			addCriterion("BUY_ID_CARD_BAK_TYPE =", value, "buyIdCardBakType");
			return (Criteria) this;
		}

		public Criteria andBuyIdCardBakTypeNotEqualTo(Integer value) {
			addCriterion("BUY_ID_CARD_BAK_TYPE <>", value, "buyIdCardBakType");
			return (Criteria) this;
		}

		public Criteria andBuyIdCardBakTypeGreaterThan(Integer value) {
			addCriterion("BUY_ID_CARD_BAK_TYPE >", value, "buyIdCardBakType");
			return (Criteria) this;
		}

		public Criteria andBuyIdCardBakTypeGreaterThanOrEqualTo(Integer value) {
			addCriterion("BUY_ID_CARD_BAK_TYPE >=", value, "buyIdCardBakType");
			return (Criteria) this;
		}

		public Criteria andBuyIdCardBakTypeLessThan(Integer value) {
			addCriterion("BUY_ID_CARD_BAK_TYPE <", value, "buyIdCardBakType");
			return (Criteria) this;
		}

		public Criteria andBuyIdCardBakTypeLessThanOrEqualTo(Integer value) {
			addCriterion("BUY_ID_CARD_BAK_TYPE <=", value, "buyIdCardBakType");
			return (Criteria) this;
		}

		public Criteria andBuyIdCardBakTypeIn(List<Integer> values) {
			addCriterion("BUY_ID_CARD_BAK_TYPE in", values, "buyIdCardBakType");
			return (Criteria) this;
		}

		public Criteria andBuyIdCardBakTypeNotIn(List<Integer> values) {
			addCriterion("BUY_ID_CARD_BAK_TYPE not in", values, "buyIdCardBakType");
			return (Criteria) this;
		}

		public Criteria andBuyIdCardBakTypeBetween(Integer value1, Integer value2) {
			addCriterion("BUY_ID_CARD_BAK_TYPE between", value1, value2, "buyIdCardBakType");
			return (Criteria) this;
		}

		public Criteria andBuyIdCardBakTypeNotBetween(Integer value1, Integer value2) {
			addCriterion("BUY_ID_CARD_BAK_TYPE not between", value1, value2, "buyIdCardBakType");
			return (Criteria) this;
		}

		public Criteria andSellerProxyIdcardTypeIsNull() {
			addCriterion("SELLER_PROXY_IDCARD_TYPE is null");
			return (Criteria) this;
		}

		public Criteria andSellerProxyIdcardTypeIsNotNull() {
			addCriterion("SELLER_PROXY_IDCARD_TYPE is not null");
			return (Criteria) this;
		}

		public Criteria andSellerProxyIdcardTypeEqualTo(Integer value) {
			addCriterion("SELLER_PROXY_IDCARD_TYPE =", value, "sellerProxyIdcardType");
			return (Criteria) this;
		}

		public Criteria andSellerProxyIdcardTypeNotEqualTo(Integer value) {
			addCriterion("SELLER_PROXY_IDCARD_TYPE <>", value, "sellerProxyIdcardType");
			return (Criteria) this;
		}

		public Criteria andSellerProxyIdcardTypeGreaterThan(Integer value) {
			addCriterion("SELLER_PROXY_IDCARD_TYPE >", value, "sellerProxyIdcardType");
			return (Criteria) this;
		}

		public Criteria andSellerProxyIdcardTypeGreaterThanOrEqualTo(Integer value) {
			addCriterion("SELLER_PROXY_IDCARD_TYPE >=", value, "sellerProxyIdcardType");
			return (Criteria) this;
		}

		public Criteria andSellerProxyIdcardTypeLessThan(Integer value) {
			addCriterion("SELLER_PROXY_IDCARD_TYPE <", value, "sellerProxyIdcardType");
			return (Criteria) this;
		}

		public Criteria andSellerProxyIdcardTypeLessThanOrEqualTo(Integer value) {
			addCriterion("SELLER_PROXY_IDCARD_TYPE <=", value, "sellerProxyIdcardType");
			return (Criteria) this;
		}

		public Criteria andSellerProxyIdcardTypeIn(List<Integer> values) {
			addCriterion("SELLER_PROXY_IDCARD_TYPE in", values, "sellerProxyIdcardType");
			return (Criteria) this;
		}

		public Criteria andSellerProxyIdcardTypeNotIn(List<Integer> values) {
			addCriterion("SELLER_PROXY_IDCARD_TYPE not in", values, "sellerProxyIdcardType");
			return (Criteria) this;
		}

		public Criteria andSellerProxyIdcardTypeBetween(Integer value1, Integer value2) {
			addCriterion("SELLER_PROXY_IDCARD_TYPE between", value1, value2, "sellerProxyIdcardType");
			return (Criteria) this;
		}

		public Criteria andSellerProxyIdcardTypeNotBetween(Integer value1, Integer value2) {
			addCriterion("SELLER_PROXY_IDCARD_TYPE not between", value1, value2, "sellerProxyIdcardType");
			return (Criteria) this;
		}

		public Criteria andBuyerProxyIdcardTypeIsNull() {
			addCriterion("BUYER_PROXY_IDCARD_TYPE is null");
			return (Criteria) this;
		}

		public Criteria andBuyerProxyIdcardTypeIsNotNull() {
			addCriterion("BUYER_PROXY_IDCARD_TYPE is not null");
			return (Criteria) this;
		}

		public Criteria andBuyerProxyIdcardTypeEqualTo(Integer value) {
			addCriterion("BUYER_PROXY_IDCARD_TYPE =", value, "buyerProxyIdcardType");
			return (Criteria) this;
		}

		public Criteria andBuyerProxyIdcardTypeNotEqualTo(Integer value) {
			addCriterion("BUYER_PROXY_IDCARD_TYPE <>", value, "buyerProxyIdcardType");
			return (Criteria) this;
		}

		public Criteria andBuyerProxyIdcardTypeGreaterThan(Integer value) {
			addCriterion("BUYER_PROXY_IDCARD_TYPE >", value, "buyerProxyIdcardType");
			return (Criteria) this;
		}

		public Criteria andBuyerProxyIdcardTypeGreaterThanOrEqualTo(Integer value) {
			addCriterion("BUYER_PROXY_IDCARD_TYPE >=", value, "buyerProxyIdcardType");
			return (Criteria) this;
		}

		public Criteria andBuyerProxyIdcardTypeLessThan(Integer value) {
			addCriterion("BUYER_PROXY_IDCARD_TYPE <", value, "buyerProxyIdcardType");
			return (Criteria) this;
		}

		public Criteria andBuyerProxyIdcardTypeLessThanOrEqualTo(Integer value) {
			addCriterion("BUYER_PROXY_IDCARD_TYPE <=", value, "buyerProxyIdcardType");
			return (Criteria) this;
		}

		public Criteria andBuyerProxyIdcardTypeIn(List<Integer> values) {
			addCriterion("BUYER_PROXY_IDCARD_TYPE in", values, "buyerProxyIdcardType");
			return (Criteria) this;
		}

		public Criteria andBuyerProxyIdcardTypeNotIn(List<Integer> values) {
			addCriterion("BUYER_PROXY_IDCARD_TYPE not in", values, "buyerProxyIdcardType");
			return (Criteria) this;
		}

		public Criteria andBuyerProxyIdcardTypeBetween(Integer value1, Integer value2) {
			addCriterion("BUYER_PROXY_IDCARD_TYPE between", value1, value2, "buyerProxyIdcardType");
			return (Criteria) this;
		}

		public Criteria andBuyerProxyIdcardTypeNotBetween(Integer value1, Integer value2) {
			addCriterion("BUYER_PROXY_IDCARD_TYPE not between", value1, value2, "buyerProxyIdcardType");
			return (Criteria) this;
		}

		public Criteria andEntrustBankIsNull() {
			addCriterion("ENTRUST_BANK is null");
			return (Criteria) this;
		}

		public Criteria andEntrustBankIsNotNull() {
			addCriterion("ENTRUST_BANK is not null");
			return (Criteria) this;
		}

		public Criteria andEntrustBankEqualTo(String value) {
			addCriterion("ENTRUST_BANK =", value, "entrustBank");
			return (Criteria) this;
		}

		public Criteria andEntrustBankNotEqualTo(String value) {
			addCriterion("ENTRUST_BANK <>", value, "entrustBank");
			return (Criteria) this;
		}

		public Criteria andEntrustBankGreaterThan(String value) {
			addCriterion("ENTRUST_BANK >", value, "entrustBank");
			return (Criteria) this;
		}

		public Criteria andEntrustBankGreaterThanOrEqualTo(String value) {
			addCriterion("ENTRUST_BANK >=", value, "entrustBank");
			return (Criteria) this;
		}

		public Criteria andEntrustBankLessThan(String value) {
			addCriterion("ENTRUST_BANK <", value, "entrustBank");
			return (Criteria) this;
		}

		public Criteria andEntrustBankLessThanOrEqualTo(String value) {
			addCriterion("ENTRUST_BANK <=", value, "entrustBank");
			return (Criteria) this;
		}

		public Criteria andEntrustBankLike(String value) {
			addCriterion("ENTRUST_BANK like", value, "entrustBank");
			return (Criteria) this;
		}

		public Criteria andEntrustBankNotLike(String value) {
			addCriterion("ENTRUST_BANK not like", value, "entrustBank");
			return (Criteria) this;
		}

		public Criteria andEntrustBankIn(List<String> values) {
			addCriterion("ENTRUST_BANK in", values, "entrustBank");
			return (Criteria) this;
		}

		public Criteria andEntrustBankNotIn(List<String> values) {
			addCriterion("ENTRUST_BANK not in", values, "entrustBank");
			return (Criteria) this;
		}

		public Criteria andEntrustBankBetween(String value1, String value2) {
			addCriterion("ENTRUST_BANK between", value1, value2, "entrustBank");
			return (Criteria) this;
		}

		public Criteria andEntrustBankNotBetween(String value1, String value2) {
			addCriterion("ENTRUST_BANK not between", value1, value2, "entrustBank");
			return (Criteria) this;
		}

		public Criteria andEntrustMoneyIsNull() {
			addCriterion("ENTRUST_MONEY is null");
			return (Criteria) this;
		}

		public Criteria andEntrustMoneyIsNotNull() {
			addCriterion("ENTRUST_MONEY is not null");
			return (Criteria) this;
		}

		public Criteria andEntrustMoneyEqualTo(BigDecimal value) {
			addCriterion("ENTRUST_MONEY =", value, "entrustMoney");
			return (Criteria) this;
		}

		public Criteria andEntrustMoneyNotEqualTo(BigDecimal value) {
			addCriterion("ENTRUST_MONEY <>", value, "entrustMoney");
			return (Criteria) this;
		}

		public Criteria andEntrustMoneyGreaterThan(BigDecimal value) {
			addCriterion("ENTRUST_MONEY >", value, "entrustMoney");
			return (Criteria) this;
		}

		public Criteria andEntrustMoneyGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("ENTRUST_MONEY >=", value, "entrustMoney");
			return (Criteria) this;
		}

		public Criteria andEntrustMoneyLessThan(BigDecimal value) {
			addCriterion("ENTRUST_MONEY <", value, "entrustMoney");
			return (Criteria) this;
		}

		public Criteria andEntrustMoneyLessThanOrEqualTo(BigDecimal value) {
			addCriterion("ENTRUST_MONEY <=", value, "entrustMoney");
			return (Criteria) this;
		}

		public Criteria andEntrustMoneyIn(List<BigDecimal> values) {
			addCriterion("ENTRUST_MONEY in", values, "entrustMoney");
			return (Criteria) this;
		}

		public Criteria andEntrustMoneyNotIn(List<BigDecimal> values) {
			addCriterion("ENTRUST_MONEY not in", values, "entrustMoney");
			return (Criteria) this;
		}

		public Criteria andEntrustMoneyBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("ENTRUST_MONEY between", value1, value2, "entrustMoney");
			return (Criteria) this;
		}

		public Criteria andEntrustMoneyNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("ENTRUST_MONEY not between", value1, value2, "entrustMoney");
			return (Criteria) this;
		}

		public Criteria andFirstTrialCompleteDateIsNull() {
			addCriterion("FIRST_TRIAL_COMPLETE_DATE is null");
			return (Criteria) this;
		}

		public Criteria andFirstTrialCompleteDateIsNotNull() {
			addCriterion("FIRST_TRIAL_COMPLETE_DATE is not null");
			return (Criteria) this;
		}

		public Criteria andFirstTrialCompleteDateEqualTo(String value) {
			addCriterion("FIRST_TRIAL_COMPLETE_DATE =", value, "firstTrialCompleteDate");
			return (Criteria) this;
		}

		public Criteria andFirstTrialCompleteDateNotEqualTo(String value) {
			addCriterion("FIRST_TRIAL_COMPLETE_DATE <>", value, "firstTrialCompleteDate");
			return (Criteria) this;
		}

		public Criteria andFirstTrialCompleteDateGreaterThan(String value) {
			addCriterion("FIRST_TRIAL_COMPLETE_DATE >", value, "firstTrialCompleteDate");
			return (Criteria) this;
		}

		public Criteria andFirstTrialCompleteDateGreaterThanOrEqualTo(String value) {
			addCriterion("FIRST_TRIAL_COMPLETE_DATE >=", value, "firstTrialCompleteDate");
			return (Criteria) this;
		}

		public Criteria andFirstTrialCompleteDateLessThan(String value) {
			addCriterion("FIRST_TRIAL_COMPLETE_DATE <", value, "firstTrialCompleteDate");
			return (Criteria) this;
		}

		public Criteria andFirstTrialCompleteDateLessThanOrEqualTo(String value) {
			addCriterion("FIRST_TRIAL_COMPLETE_DATE <=", value, "firstTrialCompleteDate");
			return (Criteria) this;
		}

		public Criteria andFirstTrialCompleteDateLike(String value) {
			addCriterion("FIRST_TRIAL_COMPLETE_DATE like", value, "firstTrialCompleteDate");
			return (Criteria) this;
		}

		public Criteria andFirstTrialCompleteDateNotLike(String value) {
			addCriterion("FIRST_TRIAL_COMPLETE_DATE not like", value, "firstTrialCompleteDate");
			return (Criteria) this;
		}

		public Criteria andFirstTrialCompleteDateIn(List<String> values) {
			addCriterion("FIRST_TRIAL_COMPLETE_DATE in", values, "firstTrialCompleteDate");
			return (Criteria) this;
		}

		public Criteria andFirstTrialCompleteDateNotIn(List<String> values) {
			addCriterion("FIRST_TRIAL_COMPLETE_DATE not in", values, "firstTrialCompleteDate");
			return (Criteria) this;
		}

		public Criteria andFirstTrialCompleteDateBetween(String value1, String value2) {
			addCriterion("FIRST_TRIAL_COMPLETE_DATE between", value1, value2, "firstTrialCompleteDate");
			return (Criteria) this;
		}

		public Criteria andFirstTrialCompleteDateNotBetween(String value1, String value2) {
			addCriterion("FIRST_TRIAL_COMPLETE_DATE not between", value1, value2, "firstTrialCompleteDate");
			return (Criteria) this;
		}

		public Criteria andRecheckCompleteDateIsNull() {
			addCriterion("RECHECK_COMPLETE_DATE is null");
			return (Criteria) this;
		}

		public Criteria andRecheckCompleteDateIsNotNull() {
			addCriterion("RECHECK_COMPLETE_DATE is not null");
			return (Criteria) this;
		}

		public Criteria andRecheckCompleteDateEqualTo(String value) {
			addCriterion("RECHECK_COMPLETE_DATE =", value, "recheckCompleteDate");
			return (Criteria) this;
		}

		public Criteria andRecheckCompleteDateNotEqualTo(String value) {
			addCriterion("RECHECK_COMPLETE_DATE <>", value, "recheckCompleteDate");
			return (Criteria) this;
		}

		public Criteria andRecheckCompleteDateGreaterThan(String value) {
			addCriterion("RECHECK_COMPLETE_DATE >", value, "recheckCompleteDate");
			return (Criteria) this;
		}

		public Criteria andRecheckCompleteDateGreaterThanOrEqualTo(String value) {
			addCriterion("RECHECK_COMPLETE_DATE >=", value, "recheckCompleteDate");
			return (Criteria) this;
		}

		public Criteria andRecheckCompleteDateLessThan(String value) {
			addCriterion("RECHECK_COMPLETE_DATE <", value, "recheckCompleteDate");
			return (Criteria) this;
		}

		public Criteria andRecheckCompleteDateLessThanOrEqualTo(String value) {
			addCriterion("RECHECK_COMPLETE_DATE <=", value, "recheckCompleteDate");
			return (Criteria) this;
		}

		public Criteria andRecheckCompleteDateLike(String value) {
			addCriterion("RECHECK_COMPLETE_DATE like", value, "recheckCompleteDate");
			return (Criteria) this;
		}

		public Criteria andRecheckCompleteDateNotLike(String value) {
			addCriterion("RECHECK_COMPLETE_DATE not like", value, "recheckCompleteDate");
			return (Criteria) this;
		}

		public Criteria andRecheckCompleteDateIn(List<String> values) {
			addCriterion("RECHECK_COMPLETE_DATE in", values, "recheckCompleteDate");
			return (Criteria) this;
		}

		public Criteria andRecheckCompleteDateNotIn(List<String> values) {
			addCriterion("RECHECK_COMPLETE_DATE not in", values, "recheckCompleteDate");
			return (Criteria) this;
		}

		public Criteria andRecheckCompleteDateBetween(String value1, String value2) {
			addCriterion("RECHECK_COMPLETE_DATE between", value1, value2, "recheckCompleteDate");
			return (Criteria) this;
		}

		public Criteria andRecheckCompleteDateNotBetween(String value1, String value2) {
			addCriterion("RECHECK_COMPLETE_DATE not between", value1, value2, "recheckCompleteDate");
			return (Criteria) this;
		}

		public Criteria andInvalidCompleteDateIsNull() {
			addCriterion("INVALID_COMPLETE_DATE is null");
			return (Criteria) this;
		}

		public Criteria andInvalidCompleteDateIsNotNull() {
			addCriterion("INVALID_COMPLETE_DATE is not null");
			return (Criteria) this;
		}

		public Criteria andInvalidCompleteDateEqualTo(String value) {
			addCriterion("INVALID_COMPLETE_DATE =", value, "invalidCompleteDate");
			return (Criteria) this;
		}

		public Criteria andInvalidCompleteDateNotEqualTo(String value) {
			addCriterion("INVALID_COMPLETE_DATE <>", value, "invalidCompleteDate");
			return (Criteria) this;
		}

		public Criteria andInvalidCompleteDateGreaterThan(String value) {
			addCriterion("INVALID_COMPLETE_DATE >", value, "invalidCompleteDate");
			return (Criteria) this;
		}

		public Criteria andInvalidCompleteDateGreaterThanOrEqualTo(String value) {
			addCriterion("INVALID_COMPLETE_DATE >=", value, "invalidCompleteDate");
			return (Criteria) this;
		}

		public Criteria andInvalidCompleteDateLessThan(String value) {
			addCriterion("INVALID_COMPLETE_DATE <", value, "invalidCompleteDate");
			return (Criteria) this;
		}

		public Criteria andInvalidCompleteDateLessThanOrEqualTo(String value) {
			addCriterion("INVALID_COMPLETE_DATE <=", value, "invalidCompleteDate");
			return (Criteria) this;
		}

		public Criteria andInvalidCompleteDateLike(String value) {
			addCriterion("INVALID_COMPLETE_DATE like", value, "invalidCompleteDate");
			return (Criteria) this;
		}

		public Criteria andInvalidCompleteDateNotLike(String value) {
			addCriterion("INVALID_COMPLETE_DATE not like", value, "invalidCompleteDate");
			return (Criteria) this;
		}

		public Criteria andInvalidCompleteDateIn(List<String> values) {
			addCriterion("INVALID_COMPLETE_DATE in", values, "invalidCompleteDate");
			return (Criteria) this;
		}

		public Criteria andInvalidCompleteDateNotIn(List<String> values) {
			addCriterion("INVALID_COMPLETE_DATE not in", values, "invalidCompleteDate");
			return (Criteria) this;
		}

		public Criteria andInvalidCompleteDateBetween(String value1, String value2) {
			addCriterion("INVALID_COMPLETE_DATE between", value1, value2, "invalidCompleteDate");
			return (Criteria) this;
		}

		public Criteria andInvalidCompleteDateNotBetween(String value1, String value2) {
			addCriterion("INVALID_COMPLETE_DATE not between", value1, value2, "invalidCompleteDate");
			return (Criteria) this;
		}

		public Criteria andDealAuditStatusBeforeIsNull() {
			addCriterion("DEAL_AUDIT_STATUS_BEFORE is null");
			return (Criteria) this;
		}

		public Criteria andDealAuditStatusBeforeIsNotNull() {
			addCriterion("DEAL_AUDIT_STATUS_BEFORE is not null");
			return (Criteria) this;
		}

		public Criteria andDealAuditStatusBeforeEqualTo(Byte value) {
			addCriterion("DEAL_AUDIT_STATUS_BEFORE =", value, "dealAuditStatusBefore");
			return (Criteria) this;
		}

		public Criteria andDealAuditStatusBeforeNotEqualTo(Byte value) {
			addCriterion("DEAL_AUDIT_STATUS_BEFORE <>", value, "dealAuditStatusBefore");
			return (Criteria) this;
		}

		public Criteria andDealAuditStatusBeforeGreaterThan(Byte value) {
			addCriterion("DEAL_AUDIT_STATUS_BEFORE >", value, "dealAuditStatusBefore");
			return (Criteria) this;
		}

		public Criteria andDealAuditStatusBeforeGreaterThanOrEqualTo(Byte value) {
			addCriterion("DEAL_AUDIT_STATUS_BEFORE >=", value, "dealAuditStatusBefore");
			return (Criteria) this;
		}

		public Criteria andDealAuditStatusBeforeLessThan(Byte value) {
			addCriterion("DEAL_AUDIT_STATUS_BEFORE <", value, "dealAuditStatusBefore");
			return (Criteria) this;
		}

		public Criteria andDealAuditStatusBeforeLessThanOrEqualTo(Byte value) {
			addCriterion("DEAL_AUDIT_STATUS_BEFORE <=", value, "dealAuditStatusBefore");
			return (Criteria) this;
		}

		public Criteria andDealAuditStatusBeforeIn(List<Byte> values) {
			addCriterion("DEAL_AUDIT_STATUS_BEFORE in", values, "dealAuditStatusBefore");
			return (Criteria) this;
		}

		public Criteria andDealAuditStatusBeforeNotIn(List<Byte> values) {
			addCriterion("DEAL_AUDIT_STATUS_BEFORE not in", values, "dealAuditStatusBefore");
			return (Criteria) this;
		}

		public Criteria andDealAuditStatusBeforeBetween(Byte value1, Byte value2) {
			addCriterion("DEAL_AUDIT_STATUS_BEFORE between", value1, value2, "dealAuditStatusBefore");
			return (Criteria) this;
		}

		public Criteria andDealAuditStatusBeforeNotBetween(Byte value1, Byte value2) {
			addCriterion("DEAL_AUDIT_STATUS_BEFORE not between", value1, value2, "dealAuditStatusBefore");
			return (Criteria) this;
		}

		public Criteria andSsqContractIdIsNull() {
			addCriterion("SSQ_CONTRACT_ID is null");
			return (Criteria) this;
		}

		public Criteria andSsqContractIdIsNotNull() {
			addCriterion("SSQ_CONTRACT_ID is not null");
			return (Criteria) this;
		}

		public Criteria andSsqContractIdEqualTo(String value) {
			addCriterion("SSQ_CONTRACT_ID =", value, "ssqContractId");
			return (Criteria) this;
		}

		public Criteria andSsqContractIdNotEqualTo(String value) {
			addCriterion("SSQ_CONTRACT_ID <>", value, "ssqContractId");
			return (Criteria) this;
		}

		public Criteria andSsqContractIdGreaterThan(String value) {
			addCriterion("SSQ_CONTRACT_ID >", value, "ssqContractId");
			return (Criteria) this;
		}

		public Criteria andSsqContractIdGreaterThanOrEqualTo(String value) {
			addCriterion("SSQ_CONTRACT_ID >=", value, "ssqContractId");
			return (Criteria) this;
		}

		public Criteria andSsqContractIdLessThan(String value) {
			addCriterion("SSQ_CONTRACT_ID <", value, "ssqContractId");
			return (Criteria) this;
		}

		public Criteria andSsqContractIdLessThanOrEqualTo(String value) {
			addCriterion("SSQ_CONTRACT_ID <=", value, "ssqContractId");
			return (Criteria) this;
		}

		public Criteria andSsqContractIdLike(String value) {
			addCriterion("SSQ_CONTRACT_ID like", value, "ssqContractId");
			return (Criteria) this;
		}

		public Criteria andSsqContractIdNotLike(String value) {
			addCriterion("SSQ_CONTRACT_ID not like", value, "ssqContractId");
			return (Criteria) this;
		}

		public Criteria andSsqContractIdIn(List<String> values) {
			addCriterion("SSQ_CONTRACT_ID in", values, "ssqContractId");
			return (Criteria) this;
		}

		public Criteria andSsqContractIdNotIn(List<String> values) {
			addCriterion("SSQ_CONTRACT_ID not in", values, "ssqContractId");
			return (Criteria) this;
		}

		public Criteria andSsqContractIdBetween(String value1, String value2) {
			addCriterion("SSQ_CONTRACT_ID between", value1, value2, "ssqContractId");
			return (Criteria) this;
		}

		public Criteria andSsqContractIdNotBetween(String value1, String value2) {
			addCriterion("SSQ_CONTRACT_ID not between", value1, value2, "ssqContractId");
			return (Criteria) this;
		}

		public Criteria andSellOwnerWxUserIdIsNull() {
			addCriterion("SELL_OWNER_WX_USER_ID is null");
			return (Criteria) this;
		}

		public Criteria andSellOwnerWxUserIdIsNotNull() {
			addCriterion("SELL_OWNER_WX_USER_ID is not null");
			return (Criteria) this;
		}

		public Criteria andSellOwnerWxUserIdEqualTo(String value) {
			addCriterion("SELL_OWNER_WX_USER_ID =", value, "sellOwnerWxUserId");
			return (Criteria) this;
		}

		public Criteria andSellOwnerWxUserIdNotEqualTo(String value) {
			addCriterion("SELL_OWNER_WX_USER_ID <>", value, "sellOwnerWxUserId");
			return (Criteria) this;
		}

		public Criteria andSellOwnerWxUserIdGreaterThan(String value) {
			addCriterion("SELL_OWNER_WX_USER_ID >", value, "sellOwnerWxUserId");
			return (Criteria) this;
		}

		public Criteria andSellOwnerWxUserIdGreaterThanOrEqualTo(String value) {
			addCriterion("SELL_OWNER_WX_USER_ID >=", value, "sellOwnerWxUserId");
			return (Criteria) this;
		}

		public Criteria andSellOwnerWxUserIdLessThan(String value) {
			addCriterion("SELL_OWNER_WX_USER_ID <", value, "sellOwnerWxUserId");
			return (Criteria) this;
		}

		public Criteria andSellOwnerWxUserIdLessThanOrEqualTo(String value) {
			addCriterion("SELL_OWNER_WX_USER_ID <=", value, "sellOwnerWxUserId");
			return (Criteria) this;
		}

		public Criteria andSellOwnerWxUserIdLike(String value) {
			addCriterion("SELL_OWNER_WX_USER_ID like", value, "sellOwnerWxUserId");
			return (Criteria) this;
		}

		public Criteria andSellOwnerWxUserIdNotLike(String value) {
			addCriterion("SELL_OWNER_WX_USER_ID not like", value, "sellOwnerWxUserId");
			return (Criteria) this;
		}

		public Criteria andSellOwnerWxUserIdIn(List<String> values) {
			addCriterion("SELL_OWNER_WX_USER_ID in", values, "sellOwnerWxUserId");
			return (Criteria) this;
		}

		public Criteria andSellOwnerWxUserIdNotIn(List<String> values) {
			addCriterion("SELL_OWNER_WX_USER_ID not in", values, "sellOwnerWxUserId");
			return (Criteria) this;
		}

		public Criteria andSellOwnerWxUserIdBetween(String value1, String value2) {
			addCriterion("SELL_OWNER_WX_USER_ID between", value1, value2, "sellOwnerWxUserId");
			return (Criteria) this;
		}

		public Criteria andSellOwnerWxUserIdNotBetween(String value1, String value2) {
			addCriterion("SELL_OWNER_WX_USER_ID not between", value1, value2, "sellOwnerWxUserId");
			return (Criteria) this;
		}

		public Criteria andSellOwnerWxOpenIdIsNull() {
			addCriterion("SELL_OWNER_WX_OPEN_ID is null");
			return (Criteria) this;
		}

		public Criteria andSellOwnerWxOpenIdIsNotNull() {
			addCriterion("SELL_OWNER_WX_OPEN_ID is not null");
			return (Criteria) this;
		}

		public Criteria andSellOwnerWxOpenIdEqualTo(String value) {
			addCriterion("SELL_OWNER_WX_OPEN_ID =", value, "sellOwnerWxOpenId");
			return (Criteria) this;
		}

		public Criteria andSellOwnerWxOpenIdNotEqualTo(String value) {
			addCriterion("SELL_OWNER_WX_OPEN_ID <>", value, "sellOwnerWxOpenId");
			return (Criteria) this;
		}

		public Criteria andSellOwnerWxOpenIdGreaterThan(String value) {
			addCriterion("SELL_OWNER_WX_OPEN_ID >", value, "sellOwnerWxOpenId");
			return (Criteria) this;
		}

		public Criteria andSellOwnerWxOpenIdGreaterThanOrEqualTo(String value) {
			addCriterion("SELL_OWNER_WX_OPEN_ID >=", value, "sellOwnerWxOpenId");
			return (Criteria) this;
		}

		public Criteria andSellOwnerWxOpenIdLessThan(String value) {
			addCriterion("SELL_OWNER_WX_OPEN_ID <", value, "sellOwnerWxOpenId");
			return (Criteria) this;
		}

		public Criteria andSellOwnerWxOpenIdLessThanOrEqualTo(String value) {
			addCriterion("SELL_OWNER_WX_OPEN_ID <=", value, "sellOwnerWxOpenId");
			return (Criteria) this;
		}

		public Criteria andSellOwnerWxOpenIdLike(String value) {
			addCriterion("SELL_OWNER_WX_OPEN_ID like", value, "sellOwnerWxOpenId");
			return (Criteria) this;
		}

		public Criteria andSellOwnerWxOpenIdNotLike(String value) {
			addCriterion("SELL_OWNER_WX_OPEN_ID not like", value, "sellOwnerWxOpenId");
			return (Criteria) this;
		}

		public Criteria andSellOwnerWxOpenIdIn(List<String> values) {
			addCriterion("SELL_OWNER_WX_OPEN_ID in", values, "sellOwnerWxOpenId");
			return (Criteria) this;
		}

		public Criteria andSellOwnerWxOpenIdNotIn(List<String> values) {
			addCriterion("SELL_OWNER_WX_OPEN_ID not in", values, "sellOwnerWxOpenId");
			return (Criteria) this;
		}

		public Criteria andSellOwnerWxOpenIdBetween(String value1, String value2) {
			addCriterion("SELL_OWNER_WX_OPEN_ID between", value1, value2, "sellOwnerWxOpenId");
			return (Criteria) this;
		}

		public Criteria andSellOwnerWxOpenIdNotBetween(String value1, String value2) {
			addCriterion("SELL_OWNER_WX_OPEN_ID not between", value1, value2, "sellOwnerWxOpenId");
			return (Criteria) this;
		}

		public Criteria andBuyOwnerWxUserIdIsNull() {
			addCriterion("BUY_OWNER_WX_USER_ID is null");
			return (Criteria) this;
		}

		public Criteria andBuyOwnerWxUserIdIsNotNull() {
			addCriterion("BUY_OWNER_WX_USER_ID is not null");
			return (Criteria) this;
		}

		public Criteria andBuyOwnerWxUserIdEqualTo(String value) {
			addCriterion("BUY_OWNER_WX_USER_ID =", value, "buyOwnerWxUserId");
			return (Criteria) this;
		}

		public Criteria andBuyOwnerWxUserIdNotEqualTo(String value) {
			addCriterion("BUY_OWNER_WX_USER_ID <>", value, "buyOwnerWxUserId");
			return (Criteria) this;
		}

		public Criteria andBuyOwnerWxUserIdGreaterThan(String value) {
			addCriterion("BUY_OWNER_WX_USER_ID >", value, "buyOwnerWxUserId");
			return (Criteria) this;
		}

		public Criteria andBuyOwnerWxUserIdGreaterThanOrEqualTo(String value) {
			addCriterion("BUY_OWNER_WX_USER_ID >=", value, "buyOwnerWxUserId");
			return (Criteria) this;
		}

		public Criteria andBuyOwnerWxUserIdLessThan(String value) {
			addCriterion("BUY_OWNER_WX_USER_ID <", value, "buyOwnerWxUserId");
			return (Criteria) this;
		}

		public Criteria andBuyOwnerWxUserIdLessThanOrEqualTo(String value) {
			addCriterion("BUY_OWNER_WX_USER_ID <=", value, "buyOwnerWxUserId");
			return (Criteria) this;
		}

		public Criteria andBuyOwnerWxUserIdLike(String value) {
			addCriterion("BUY_OWNER_WX_USER_ID like", value, "buyOwnerWxUserId");
			return (Criteria) this;
		}

		public Criteria andBuyOwnerWxUserIdNotLike(String value) {
			addCriterion("BUY_OWNER_WX_USER_ID not like", value, "buyOwnerWxUserId");
			return (Criteria) this;
		}

		public Criteria andBuyOwnerWxUserIdIn(List<String> values) {
			addCriterion("BUY_OWNER_WX_USER_ID in", values, "buyOwnerWxUserId");
			return (Criteria) this;
		}

		public Criteria andBuyOwnerWxUserIdNotIn(List<String> values) {
			addCriterion("BUY_OWNER_WX_USER_ID not in", values, "buyOwnerWxUserId");
			return (Criteria) this;
		}

		public Criteria andBuyOwnerWxUserIdBetween(String value1, String value2) {
			addCriterion("BUY_OWNER_WX_USER_ID between", value1, value2, "buyOwnerWxUserId");
			return (Criteria) this;
		}

		public Criteria andBuyOwnerWxUserIdNotBetween(String value1, String value2) {
			addCriterion("BUY_OWNER_WX_USER_ID not between", value1, value2, "buyOwnerWxUserId");
			return (Criteria) this;
		}

		public Criteria andBuyOwnerWxOpenIdIsNull() {
			addCriterion("BUY_OWNER_WX_OPEN_ID is null");
			return (Criteria) this;
		}

		public Criteria andBuyOwnerWxOpenIdIsNotNull() {
			addCriterion("BUY_OWNER_WX_OPEN_ID is not null");
			return (Criteria) this;
		}

		public Criteria andBuyOwnerWxOpenIdEqualTo(String value) {
			addCriterion("BUY_OWNER_WX_OPEN_ID =", value, "buyOwnerWxOpenId");
			return (Criteria) this;
		}

		public Criteria andBuyOwnerWxOpenIdNotEqualTo(String value) {
			addCriterion("BUY_OWNER_WX_OPEN_ID <>", value, "buyOwnerWxOpenId");
			return (Criteria) this;
		}

		public Criteria andBuyOwnerWxOpenIdGreaterThan(String value) {
			addCriterion("BUY_OWNER_WX_OPEN_ID >", value, "buyOwnerWxOpenId");
			return (Criteria) this;
		}

		public Criteria andBuyOwnerWxOpenIdGreaterThanOrEqualTo(String value) {
			addCriterion("BUY_OWNER_WX_OPEN_ID >=", value, "buyOwnerWxOpenId");
			return (Criteria) this;
		}

		public Criteria andBuyOwnerWxOpenIdLessThan(String value) {
			addCriterion("BUY_OWNER_WX_OPEN_ID <", value, "buyOwnerWxOpenId");
			return (Criteria) this;
		}

		public Criteria andBuyOwnerWxOpenIdLessThanOrEqualTo(String value) {
			addCriterion("BUY_OWNER_WX_OPEN_ID <=", value, "buyOwnerWxOpenId");
			return (Criteria) this;
		}

		public Criteria andBuyOwnerWxOpenIdLike(String value) {
			addCriterion("BUY_OWNER_WX_OPEN_ID like", value, "buyOwnerWxOpenId");
			return (Criteria) this;
		}

		public Criteria andBuyOwnerWxOpenIdNotLike(String value) {
			addCriterion("BUY_OWNER_WX_OPEN_ID not like", value, "buyOwnerWxOpenId");
			return (Criteria) this;
		}

		public Criteria andBuyOwnerWxOpenIdIn(List<String> values) {
			addCriterion("BUY_OWNER_WX_OPEN_ID in", values, "buyOwnerWxOpenId");
			return (Criteria) this;
		}

		public Criteria andBuyOwnerWxOpenIdNotIn(List<String> values) {
			addCriterion("BUY_OWNER_WX_OPEN_ID not in", values, "buyOwnerWxOpenId");
			return (Criteria) this;
		}

		public Criteria andBuyOwnerWxOpenIdBetween(String value1, String value2) {
			addCriterion("BUY_OWNER_WX_OPEN_ID between", value1, value2, "buyOwnerWxOpenId");
			return (Criteria) this;
		}

		public Criteria andBuyOwnerWxOpenIdNotBetween(String value1, String value2) {
			addCriterion("BUY_OWNER_WX_OPEN_ID not between", value1, value2, "buyOwnerWxOpenId");
			return (Criteria) this;
		}

		public Criteria andSignTypeIsNull() {
			addCriterion("SIGN_TYPE is null");
			return (Criteria) this;
		}

		public Criteria andSignTypeIsNotNull() {
			addCriterion("SIGN_TYPE is not null");
			return (Criteria) this;
		}

		public Criteria andSignTypeEqualTo(Byte value) {
			addCriterion("SIGN_TYPE =", value, "signType");
			return (Criteria) this;
		}

		public Criteria andSignTypeNotEqualTo(Byte value) {
			addCriterion("SIGN_TYPE <>", value, "signType");
			return (Criteria) this;
		}

		public Criteria andSignTypeGreaterThan(Byte value) {
			addCriterion("SIGN_TYPE >", value, "signType");
			return (Criteria) this;
		}

		public Criteria andSignTypeGreaterThanOrEqualTo(Byte value) {
			addCriterion("SIGN_TYPE >=", value, "signType");
			return (Criteria) this;
		}

		public Criteria andSignTypeLessThan(Byte value) {
			addCriterion("SIGN_TYPE <", value, "signType");
			return (Criteria) this;
		}

		public Criteria andSignTypeLessThanOrEqualTo(Byte value) {
			addCriterion("SIGN_TYPE <=", value, "signType");
			return (Criteria) this;
		}

		public Criteria andSignTypeIn(List<Byte> values) {
			addCriterion("SIGN_TYPE in", values, "signType");
			return (Criteria) this;
		}

		public Criteria andSignTypeNotIn(List<Byte> values) {
			addCriterion("SIGN_TYPE not in", values, "signType");
			return (Criteria) this;
		}

		public Criteria andSignTypeBetween(Byte value1, Byte value2) {
			addCriterion("SIGN_TYPE between", value1, value2, "signType");
			return (Criteria) this;
		}

		public Criteria andSignTypeNotBetween(Byte value1, Byte value2) {
			addCriterion("SIGN_TYPE not between", value1, value2, "signType");
			return (Criteria) this;
		}

		public Criteria andSignSiteDeptIsNull() {
			addCriterion("SIGN_SITE_DEPT is null");
			return (Criteria) this;
		}

		public Criteria andSignSiteDeptIsNotNull() {
			addCriterion("SIGN_SITE_DEPT is not null");
			return (Criteria) this;
		}

		public Criteria andSignSiteDeptEqualTo(Integer value) {
			addCriterion("SIGN_SITE_DEPT =", value, "signSiteDept");
			return (Criteria) this;
		}

		public Criteria andSignSiteDeptNotEqualTo(Integer value) {
			addCriterion("SIGN_SITE_DEPT <>", value, "signSiteDept");
			return (Criteria) this;
		}

		public Criteria andSignSiteDeptGreaterThan(Integer value) {
			addCriterion("SIGN_SITE_DEPT >", value, "signSiteDept");
			return (Criteria) this;
		}

		public Criteria andSignSiteDeptGreaterThanOrEqualTo(Integer value) {
			addCriterion("SIGN_SITE_DEPT >=", value, "signSiteDept");
			return (Criteria) this;
		}

		public Criteria andSignSiteDeptLessThan(Integer value) {
			addCriterion("SIGN_SITE_DEPT <", value, "signSiteDept");
			return (Criteria) this;
		}

		public Criteria andSignSiteDeptLessThanOrEqualTo(Integer value) {
			addCriterion("SIGN_SITE_DEPT <=", value, "signSiteDept");
			return (Criteria) this;
		}

		public Criteria andSignSiteDeptIn(List<Integer> values) {
			addCriterion("SIGN_SITE_DEPT in", values, "signSiteDept");
			return (Criteria) this;
		}

		public Criteria andSignSiteDeptNotIn(List<Integer> values) {
			addCriterion("SIGN_SITE_DEPT not in", values, "signSiteDept");
			return (Criteria) this;
		}

		public Criteria andSignSiteDeptBetween(Integer value1, Integer value2) {
			addCriterion("SIGN_SITE_DEPT between", value1, value2, "signSiteDept");
			return (Criteria) this;
		}

		public Criteria andSignSiteDeptNotBetween(Integer value1, Integer value2) {
			addCriterion("SIGN_SITE_DEPT not between", value1, value2, "signSiteDept");
			return (Criteria) this;
		}

		public Criteria andSignSiteGrIsNull() {
			addCriterion("SIGN_SITE_GR is null");
			return (Criteria) this;
		}

		public Criteria andSignSiteGrIsNotNull() {
			addCriterion("SIGN_SITE_GR is not null");
			return (Criteria) this;
		}

		public Criteria andSignSiteGrEqualTo(Integer value) {
			addCriterion("SIGN_SITE_GR =", value, "signSiteGr");
			return (Criteria) this;
		}

		public Criteria andSignSiteGrNotEqualTo(Integer value) {
			addCriterion("SIGN_SITE_GR <>", value, "signSiteGr");
			return (Criteria) this;
		}

		public Criteria andSignSiteGrGreaterThan(Integer value) {
			addCriterion("SIGN_SITE_GR >", value, "signSiteGr");
			return (Criteria) this;
		}

		public Criteria andSignSiteGrGreaterThanOrEqualTo(Integer value) {
			addCriterion("SIGN_SITE_GR >=", value, "signSiteGr");
			return (Criteria) this;
		}

		public Criteria andSignSiteGrLessThan(Integer value) {
			addCriterion("SIGN_SITE_GR <", value, "signSiteGr");
			return (Criteria) this;
		}

		public Criteria andSignSiteGrLessThanOrEqualTo(Integer value) {
			addCriterion("SIGN_SITE_GR <=", value, "signSiteGr");
			return (Criteria) this;
		}

		public Criteria andSignSiteGrIn(List<Integer> values) {
			addCriterion("SIGN_SITE_GR in", values, "signSiteGr");
			return (Criteria) this;
		}

		public Criteria andSignSiteGrNotIn(List<Integer> values) {
			addCriterion("SIGN_SITE_GR not in", values, "signSiteGr");
			return (Criteria) this;
		}

		public Criteria andSignSiteGrBetween(Integer value1, Integer value2) {
			addCriterion("SIGN_SITE_GR between", value1, value2, "signSiteGr");
			return (Criteria) this;
		}

		public Criteria andSignSiteGrNotBetween(Integer value1, Integer value2) {
			addCriterion("SIGN_SITE_GR not between", value1, value2, "signSiteGr");
			return (Criteria) this;
		}

		public Criteria andIntroducerIdIsNull() {
			addCriterion("INTRODUCER_ID is null");
			return (Criteria) this;
		}

		public Criteria andIntroducerIdIsNotNull() {
			addCriterion("INTRODUCER_ID is not null");
			return (Criteria) this;
		}

		public Criteria andIntroducerIdEqualTo(Integer value) {
			addCriterion("INTRODUCER_ID =", value, "introducerId");
			return (Criteria) this;
		}

		public Criteria andIntroducerIdNotEqualTo(Integer value) {
			addCriterion("INTRODUCER_ID <>", value, "introducerId");
			return (Criteria) this;
		}

		public Criteria andIntroducerIdGreaterThan(Integer value) {
			addCriterion("INTRODUCER_ID >", value, "introducerId");
			return (Criteria) this;
		}

		public Criteria andIntroducerIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("INTRODUCER_ID >=", value, "introducerId");
			return (Criteria) this;
		}

		public Criteria andIntroducerIdLessThan(Integer value) {
			addCriterion("INTRODUCER_ID <", value, "introducerId");
			return (Criteria) this;
		}

		public Criteria andIntroducerIdLessThanOrEqualTo(Integer value) {
			addCriterion("INTRODUCER_ID <=", value, "introducerId");
			return (Criteria) this;
		}

		public Criteria andIntroducerIdIn(List<Integer> values) {
			addCriterion("INTRODUCER_ID in", values, "introducerId");
			return (Criteria) this;
		}

		public Criteria andIntroducerIdNotIn(List<Integer> values) {
			addCriterion("INTRODUCER_ID not in", values, "introducerId");
			return (Criteria) this;
		}

		public Criteria andIntroducerIdBetween(Integer value1, Integer value2) {
			addCriterion("INTRODUCER_ID between", value1, value2, "introducerId");
			return (Criteria) this;
		}

		public Criteria andIntroducerIdNotBetween(Integer value1, Integer value2) {
			addCriterion("INTRODUCER_ID not between", value1, value2, "introducerId");
			return (Criteria) this;
		}

		public Criteria andAdultPromotionIdIsNull() {
			addCriterion("ADULT_PROMOTION_ID is null");
			return (Criteria) this;
		}

		public Criteria andAdultPromotionIdIsNotNull() {
			addCriterion("ADULT_PROMOTION_ID is not null");
			return (Criteria) this;
		}

		public Criteria andAdultPromotionIdEqualTo(Integer value) {
			addCriterion("ADULT_PROMOTION_ID =", value, "adultPromotionId");
			return (Criteria) this;
		}

		public Criteria andAdultPromotionIdNotEqualTo(Integer value) {
			addCriterion("ADULT_PROMOTION_ID <>", value, "adultPromotionId");
			return (Criteria) this;
		}

		public Criteria andAdultPromotionIdGreaterThan(Integer value) {
			addCriterion("ADULT_PROMOTION_ID >", value, "adultPromotionId");
			return (Criteria) this;
		}

		public Criteria andAdultPromotionIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("ADULT_PROMOTION_ID >=", value, "adultPromotionId");
			return (Criteria) this;
		}

		public Criteria andAdultPromotionIdLessThan(Integer value) {
			addCriterion("ADULT_PROMOTION_ID <", value, "adultPromotionId");
			return (Criteria) this;
		}

		public Criteria andAdultPromotionIdLessThanOrEqualTo(Integer value) {
			addCriterion("ADULT_PROMOTION_ID <=", value, "adultPromotionId");
			return (Criteria) this;
		}

		public Criteria andAdultPromotionIdIn(List<Integer> values) {
			addCriterion("ADULT_PROMOTION_ID in", values, "adultPromotionId");
			return (Criteria) this;
		}

		public Criteria andAdultPromotionIdNotIn(List<Integer> values) {
			addCriterion("ADULT_PROMOTION_ID not in", values, "adultPromotionId");
			return (Criteria) this;
		}

		public Criteria andAdultPromotionIdBetween(Integer value1, Integer value2) {
			addCriterion("ADULT_PROMOTION_ID between", value1, value2, "adultPromotionId");
			return (Criteria) this;
		}

		public Criteria andAdultPromotionIdNotBetween(Integer value1, Integer value2) {
			addCriterion("ADULT_PROMOTION_ID not between", value1, value2, "adultPromotionId");
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