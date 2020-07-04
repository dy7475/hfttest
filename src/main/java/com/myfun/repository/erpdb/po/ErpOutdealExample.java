package com.myfun.repository.erpdb.po;

import com.myfun.repository.support.generator.shard.ShardDb;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ErpOutdealExample extends ShardDb {
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
	public ErpOutdealExample() {
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

		public Criteria andCreatorUserIdIsNull() {
			addCriterion("CREATOR_USER_ID is null");
			return (Criteria) this;
		}

		public Criteria andCreatorUserIdIsNotNull() {
			addCriterion("CREATOR_USER_ID is not null");
			return (Criteria) this;
		}

		public Criteria andCreatorUserIdEqualTo(Integer value) {
			addCriterion("CREATOR_USER_ID =", value, "creatorUserId");
			return (Criteria) this;
		}

		public Criteria andCreatorUserIdNotEqualTo(Integer value) {
			addCriterion("CREATOR_USER_ID <>", value, "creatorUserId");
			return (Criteria) this;
		}

		public Criteria andCreatorUserIdGreaterThan(Integer value) {
			addCriterion("CREATOR_USER_ID >", value, "creatorUserId");
			return (Criteria) this;
		}

		public Criteria andCreatorUserIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("CREATOR_USER_ID >=", value, "creatorUserId");
			return (Criteria) this;
		}

		public Criteria andCreatorUserIdLessThan(Integer value) {
			addCriterion("CREATOR_USER_ID <", value, "creatorUserId");
			return (Criteria) this;
		}

		public Criteria andCreatorUserIdLessThanOrEqualTo(Integer value) {
			addCriterion("CREATOR_USER_ID <=", value, "creatorUserId");
			return (Criteria) this;
		}

		public Criteria andCreatorUserIdIn(List<Integer> values) {
			addCriterion("CREATOR_USER_ID in", values, "creatorUserId");
			return (Criteria) this;
		}

		public Criteria andCreatorUserIdNotIn(List<Integer> values) {
			addCriterion("CREATOR_USER_ID not in", values, "creatorUserId");
			return (Criteria) this;
		}

		public Criteria andCreatorUserIdBetween(Integer value1, Integer value2) {
			addCriterion("CREATOR_USER_ID between", value1, value2, "creatorUserId");
			return (Criteria) this;
		}

		public Criteria andCreatorUserIdNotBetween(Integer value1, Integer value2) {
			addCriterion("CREATOR_USER_ID not between", value1, value2, "creatorUserId");
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

		public Criteria andCaseIdIsNull() {
			addCriterion("CASE_ID is null");
			return (Criteria) this;
		}

		public Criteria andCaseIdIsNotNull() {
			addCriterion("CASE_ID is not null");
			return (Criteria) this;
		}

		public Criteria andCaseIdEqualTo(Integer value) {
			addCriterion("CASE_ID =", value, "caseId");
			return (Criteria) this;
		}

		public Criteria andCaseIdNotEqualTo(Integer value) {
			addCriterion("CASE_ID <>", value, "caseId");
			return (Criteria) this;
		}

		public Criteria andCaseIdGreaterThan(Integer value) {
			addCriterion("CASE_ID >", value, "caseId");
			return (Criteria) this;
		}

		public Criteria andCaseIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("CASE_ID >=", value, "caseId");
			return (Criteria) this;
		}

		public Criteria andCaseIdLessThan(Integer value) {
			addCriterion("CASE_ID <", value, "caseId");
			return (Criteria) this;
		}

		public Criteria andCaseIdLessThanOrEqualTo(Integer value) {
			addCriterion("CASE_ID <=", value, "caseId");
			return (Criteria) this;
		}

		public Criteria andCaseIdIn(List<Integer> values) {
			addCriterion("CASE_ID in", values, "caseId");
			return (Criteria) this;
		}

		public Criteria andCaseIdNotIn(List<Integer> values) {
			addCriterion("CASE_ID not in", values, "caseId");
			return (Criteria) this;
		}

		public Criteria andCaseIdBetween(Integer value1, Integer value2) {
			addCriterion("CASE_ID between", value1, value2, "caseId");
			return (Criteria) this;
		}

		public Criteria andCaseIdNotBetween(Integer value1, Integer value2) {
			addCriterion("CASE_ID not between", value1, value2, "caseId");
			return (Criteria) this;
		}

		public Criteria andCaseTypeIsNull() {
			addCriterion("CASE_TYPE is null");
			return (Criteria) this;
		}

		public Criteria andCaseTypeIsNotNull() {
			addCriterion("CASE_TYPE is not null");
			return (Criteria) this;
		}

		public Criteria andCaseTypeEqualTo(Byte value) {
			addCriterion("CASE_TYPE =", value, "caseType");
			return (Criteria) this;
		}

		public Criteria andCaseTypeNotEqualTo(Byte value) {
			addCriterion("CASE_TYPE <>", value, "caseType");
			return (Criteria) this;
		}

		public Criteria andCaseTypeGreaterThan(Byte value) {
			addCriterion("CASE_TYPE >", value, "caseType");
			return (Criteria) this;
		}

		public Criteria andCaseTypeGreaterThanOrEqualTo(Byte value) {
			addCriterion("CASE_TYPE >=", value, "caseType");
			return (Criteria) this;
		}

		public Criteria andCaseTypeLessThan(Byte value) {
			addCriterion("CASE_TYPE <", value, "caseType");
			return (Criteria) this;
		}

		public Criteria andCaseTypeLessThanOrEqualTo(Byte value) {
			addCriterion("CASE_TYPE <=", value, "caseType");
			return (Criteria) this;
		}

		public Criteria andCaseTypeIn(List<Byte> values) {
			addCriterion("CASE_TYPE in", values, "caseType");
			return (Criteria) this;
		}

		public Criteria andCaseTypeNotIn(List<Byte> values) {
			addCriterion("CASE_TYPE not in", values, "caseType");
			return (Criteria) this;
		}

		public Criteria andCaseTypeBetween(Byte value1, Byte value2) {
			addCriterion("CASE_TYPE between", value1, value2, "caseType");
			return (Criteria) this;
		}

		public Criteria andCaseTypeNotBetween(Byte value1, Byte value2) {
			addCriterion("CASE_TYPE not between", value1, value2, "caseType");
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

		public Criteria andDealTotalPriceIsNull() {
			addCriterion("DEAL_TOTAL_PRICE is null");
			return (Criteria) this;
		}

		public Criteria andDealTotalPriceIsNotNull() {
			addCriterion("DEAL_TOTAL_PRICE is not null");
			return (Criteria) this;
		}

		public Criteria andDealTotalPriceEqualTo(BigDecimal value) {
			addCriterion("DEAL_TOTAL_PRICE =", value, "dealTotalPrice");
			return (Criteria) this;
		}

		public Criteria andDealTotalPriceNotEqualTo(BigDecimal value) {
			addCriterion("DEAL_TOTAL_PRICE <>", value, "dealTotalPrice");
			return (Criteria) this;
		}

		public Criteria andDealTotalPriceGreaterThan(BigDecimal value) {
			addCriterion("DEAL_TOTAL_PRICE >", value, "dealTotalPrice");
			return (Criteria) this;
		}

		public Criteria andDealTotalPriceGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("DEAL_TOTAL_PRICE >=", value, "dealTotalPrice");
			return (Criteria) this;
		}

		public Criteria andDealTotalPriceLessThan(BigDecimal value) {
			addCriterion("DEAL_TOTAL_PRICE <", value, "dealTotalPrice");
			return (Criteria) this;
		}

		public Criteria andDealTotalPriceLessThanOrEqualTo(BigDecimal value) {
			addCriterion("DEAL_TOTAL_PRICE <=", value, "dealTotalPrice");
			return (Criteria) this;
		}

		public Criteria andDealTotalPriceIn(List<BigDecimal> values) {
			addCriterion("DEAL_TOTAL_PRICE in", values, "dealTotalPrice");
			return (Criteria) this;
		}

		public Criteria andDealTotalPriceNotIn(List<BigDecimal> values) {
			addCriterion("DEAL_TOTAL_PRICE not in", values, "dealTotalPrice");
			return (Criteria) this;
		}

		public Criteria andDealTotalPriceBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("DEAL_TOTAL_PRICE between", value1, value2, "dealTotalPrice");
			return (Criteria) this;
		}

		public Criteria andDealTotalPriceNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("DEAL_TOTAL_PRICE not between", value1, value2, "dealTotalPrice");
			return (Criteria) this;
		}

		public Criteria andDealCommissionIsNull() {
			addCriterion("DEAL_COMMISSION is null");
			return (Criteria) this;
		}

		public Criteria andDealCommissionIsNotNull() {
			addCriterion("DEAL_COMMISSION is not null");
			return (Criteria) this;
		}

		public Criteria andDealCommissionEqualTo(BigDecimal value) {
			addCriterion("DEAL_COMMISSION =", value, "dealCommission");
			return (Criteria) this;
		}

		public Criteria andDealCommissionNotEqualTo(BigDecimal value) {
			addCriterion("DEAL_COMMISSION <>", value, "dealCommission");
			return (Criteria) this;
		}

		public Criteria andDealCommissionGreaterThan(BigDecimal value) {
			addCriterion("DEAL_COMMISSION >", value, "dealCommission");
			return (Criteria) this;
		}

		public Criteria andDealCommissionGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("DEAL_COMMISSION >=", value, "dealCommission");
			return (Criteria) this;
		}

		public Criteria andDealCommissionLessThan(BigDecimal value) {
			addCriterion("DEAL_COMMISSION <", value, "dealCommission");
			return (Criteria) this;
		}

		public Criteria andDealCommissionLessThanOrEqualTo(BigDecimal value) {
			addCriterion("DEAL_COMMISSION <=", value, "dealCommission");
			return (Criteria) this;
		}

		public Criteria andDealCommissionIn(List<BigDecimal> values) {
			addCriterion("DEAL_COMMISSION in", values, "dealCommission");
			return (Criteria) this;
		}

		public Criteria andDealCommissionNotIn(List<BigDecimal> values) {
			addCriterion("DEAL_COMMISSION not in", values, "dealCommission");
			return (Criteria) this;
		}

		public Criteria andDealCommissionBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("DEAL_COMMISSION between", value1, value2, "dealCommission");
			return (Criteria) this;
		}

		public Criteria andDealCommissionNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("DEAL_COMMISSION not between", value1, value2, "dealCommission");
			return (Criteria) this;
		}

		public Criteria andTotalPriceUnitIsNull() {
			addCriterion("TOTAL_PRICE_UNIT is null");
			return (Criteria) this;
		}

		public Criteria andTotalPriceUnitIsNotNull() {
			addCriterion("TOTAL_PRICE_UNIT is not null");
			return (Criteria) this;
		}

		public Criteria andTotalPriceUnitEqualTo(Byte value) {
			addCriterion("TOTAL_PRICE_UNIT =", value, "totalPriceUnit");
			return (Criteria) this;
		}

		public Criteria andTotalPriceUnitNotEqualTo(Byte value) {
			addCriterion("TOTAL_PRICE_UNIT <>", value, "totalPriceUnit");
			return (Criteria) this;
		}

		public Criteria andTotalPriceUnitGreaterThan(Byte value) {
			addCriterion("TOTAL_PRICE_UNIT >", value, "totalPriceUnit");
			return (Criteria) this;
		}

		public Criteria andTotalPriceUnitGreaterThanOrEqualTo(Byte value) {
			addCriterion("TOTAL_PRICE_UNIT >=", value, "totalPriceUnit");
			return (Criteria) this;
		}

		public Criteria andTotalPriceUnitLessThan(Byte value) {
			addCriterion("TOTAL_PRICE_UNIT <", value, "totalPriceUnit");
			return (Criteria) this;
		}

		public Criteria andTotalPriceUnitLessThanOrEqualTo(Byte value) {
			addCriterion("TOTAL_PRICE_UNIT <=", value, "totalPriceUnit");
			return (Criteria) this;
		}

		public Criteria andTotalPriceUnitIn(List<Byte> values) {
			addCriterion("TOTAL_PRICE_UNIT in", values, "totalPriceUnit");
			return (Criteria) this;
		}

		public Criteria andTotalPriceUnitNotIn(List<Byte> values) {
			addCriterion("TOTAL_PRICE_UNIT not in", values, "totalPriceUnit");
			return (Criteria) this;
		}

		public Criteria andTotalPriceUnitBetween(Byte value1, Byte value2) {
			addCriterion("TOTAL_PRICE_UNIT between", value1, value2, "totalPriceUnit");
			return (Criteria) this;
		}

		public Criteria andTotalPriceUnitNotBetween(Byte value1, Byte value2) {
			addCriterion("TOTAL_PRICE_UNIT not between", value1, value2, "totalPriceUnit");
			return (Criteria) this;
		}

		public Criteria andCaseCharacterIsNull() {
			addCriterion("CASE_CHARACTER is null");
			return (Criteria) this;
		}

		public Criteria andCaseCharacterIsNotNull() {
			addCriterion("CASE_CHARACTER is not null");
			return (Criteria) this;
		}

		public Criteria andCaseCharacterEqualTo(String value) {
			addCriterion("CASE_CHARACTER =", value, "caseCharacter");
			return (Criteria) this;
		}

		public Criteria andCaseCharacterNotEqualTo(String value) {
			addCriterion("CASE_CHARACTER <>", value, "caseCharacter");
			return (Criteria) this;
		}

		public Criteria andCaseCharacterGreaterThan(String value) {
			addCriterion("CASE_CHARACTER >", value, "caseCharacter");
			return (Criteria) this;
		}

		public Criteria andCaseCharacterGreaterThanOrEqualTo(String value) {
			addCriterion("CASE_CHARACTER >=", value, "caseCharacter");
			return (Criteria) this;
		}

		public Criteria andCaseCharacterLessThan(String value) {
			addCriterion("CASE_CHARACTER <", value, "caseCharacter");
			return (Criteria) this;
		}

		public Criteria andCaseCharacterLessThanOrEqualTo(String value) {
			addCriterion("CASE_CHARACTER <=", value, "caseCharacter");
			return (Criteria) this;
		}

		public Criteria andCaseCharacterLike(String value) {
			addCriterion("CASE_CHARACTER like", value, "caseCharacter");
			return (Criteria) this;
		}

		public Criteria andCaseCharacterNotLike(String value) {
			addCriterion("CASE_CHARACTER not like", value, "caseCharacter");
			return (Criteria) this;
		}

		public Criteria andCaseCharacterIn(List<String> values) {
			addCriterion("CASE_CHARACTER in", values, "caseCharacter");
			return (Criteria) this;
		}

		public Criteria andCaseCharacterNotIn(List<String> values) {
			addCriterion("CASE_CHARACTER not in", values, "caseCharacter");
			return (Criteria) this;
		}

		public Criteria andCaseCharacterBetween(String value1, String value2) {
			addCriterion("CASE_CHARACTER between", value1, value2, "caseCharacter");
			return (Criteria) this;
		}

		public Criteria andCaseCharacterNotBetween(String value1, String value2) {
			addCriterion("CASE_CHARACTER not between", value1, value2, "caseCharacter");
			return (Criteria) this;
		}

		public Criteria andCaseUserIsNull() {
			addCriterion("CASE_USER is null");
			return (Criteria) this;
		}

		public Criteria andCaseUserIsNotNull() {
			addCriterion("CASE_USER is not null");
			return (Criteria) this;
		}

		public Criteria andCaseUserEqualTo(Integer value) {
			addCriterion("CASE_USER =", value, "caseUser");
			return (Criteria) this;
		}

		public Criteria andCaseUserNotEqualTo(Integer value) {
			addCriterion("CASE_USER <>", value, "caseUser");
			return (Criteria) this;
		}

		public Criteria andCaseUserGreaterThan(Integer value) {
			addCriterion("CASE_USER >", value, "caseUser");
			return (Criteria) this;
		}

		public Criteria andCaseUserGreaterThanOrEqualTo(Integer value) {
			addCriterion("CASE_USER >=", value, "caseUser");
			return (Criteria) this;
		}

		public Criteria andCaseUserLessThan(Integer value) {
			addCriterion("CASE_USER <", value, "caseUser");
			return (Criteria) this;
		}

		public Criteria andCaseUserLessThanOrEqualTo(Integer value) {
			addCriterion("CASE_USER <=", value, "caseUser");
			return (Criteria) this;
		}

		public Criteria andCaseUserIn(List<Integer> values) {
			addCriterion("CASE_USER in", values, "caseUser");
			return (Criteria) this;
		}

		public Criteria andCaseUserNotIn(List<Integer> values) {
			addCriterion("CASE_USER not in", values, "caseUser");
			return (Criteria) this;
		}

		public Criteria andCaseUserBetween(Integer value1, Integer value2) {
			addCriterion("CASE_USER between", value1, value2, "caseUser");
			return (Criteria) this;
		}

		public Criteria andCaseUserNotBetween(Integer value1, Integer value2) {
			addCriterion("CASE_USER not between", value1, value2, "caseUser");
			return (Criteria) this;
		}

		public Criteria andCaseDealTypeIsNull() {
			addCriterion("CASE_DEAL_TYPE is null");
			return (Criteria) this;
		}

		public Criteria andCaseDealTypeIsNotNull() {
			addCriterion("CASE_DEAL_TYPE is not null");
			return (Criteria) this;
		}

		public Criteria andCaseDealTypeEqualTo(Integer value) {
			addCriterion("CASE_DEAL_TYPE =", value, "caseDealType");
			return (Criteria) this;
		}

		public Criteria andCaseDealTypeNotEqualTo(Integer value) {
			addCriterion("CASE_DEAL_TYPE <>", value, "caseDealType");
			return (Criteria) this;
		}

		public Criteria andCaseDealTypeGreaterThan(Integer value) {
			addCriterion("CASE_DEAL_TYPE >", value, "caseDealType");
			return (Criteria) this;
		}

		public Criteria andCaseDealTypeGreaterThanOrEqualTo(Integer value) {
			addCriterion("CASE_DEAL_TYPE >=", value, "caseDealType");
			return (Criteria) this;
		}

		public Criteria andCaseDealTypeLessThan(Integer value) {
			addCriterion("CASE_DEAL_TYPE <", value, "caseDealType");
			return (Criteria) this;
		}

		public Criteria andCaseDealTypeLessThanOrEqualTo(Integer value) {
			addCriterion("CASE_DEAL_TYPE <=", value, "caseDealType");
			return (Criteria) this;
		}

		public Criteria andCaseDealTypeIn(List<Integer> values) {
			addCriterion("CASE_DEAL_TYPE in", values, "caseDealType");
			return (Criteria) this;
		}

		public Criteria andCaseDealTypeNotIn(List<Integer> values) {
			addCriterion("CASE_DEAL_TYPE not in", values, "caseDealType");
			return (Criteria) this;
		}

		public Criteria andCaseDealTypeBetween(Integer value1, Integer value2) {
			addCriterion("CASE_DEAL_TYPE between", value1, value2, "caseDealType");
			return (Criteria) this;
		}

		public Criteria andCaseDealTypeNotBetween(Integer value1, Integer value2) {
			addCriterion("CASE_DEAL_TYPE not between", value1, value2, "caseDealType");
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