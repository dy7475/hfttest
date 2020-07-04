package com.myfun.repository.erpdb.po;

import com.myfun.repository.support.generator.shard.ShardDb;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ErpSsqContractExample extends ShardDb {
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
	public ErpSsqContractExample() {
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

		public Criteria andContractStatusIsNull() {
			addCriterion("CONTRACT_STATUS is null");
			return (Criteria) this;
		}

		public Criteria andContractStatusIsNotNull() {
			addCriterion("CONTRACT_STATUS is not null");
			return (Criteria) this;
		}

		public Criteria andContractStatusEqualTo(Integer value) {
			addCriterion("CONTRACT_STATUS =", value, "contractStatus");
			return (Criteria) this;
		}

		public Criteria andContractStatusNotEqualTo(Integer value) {
			addCriterion("CONTRACT_STATUS <>", value, "contractStatus");
			return (Criteria) this;
		}

		public Criteria andContractStatusGreaterThan(Integer value) {
			addCriterion("CONTRACT_STATUS >", value, "contractStatus");
			return (Criteria) this;
		}

		public Criteria andContractStatusGreaterThanOrEqualTo(Integer value) {
			addCriterion("CONTRACT_STATUS >=", value, "contractStatus");
			return (Criteria) this;
		}

		public Criteria andContractStatusLessThan(Integer value) {
			addCriterion("CONTRACT_STATUS <", value, "contractStatus");
			return (Criteria) this;
		}

		public Criteria andContractStatusLessThanOrEqualTo(Integer value) {
			addCriterion("CONTRACT_STATUS <=", value, "contractStatus");
			return (Criteria) this;
		}

		public Criteria andContractStatusIn(List<Integer> values) {
			addCriterion("CONTRACT_STATUS in", values, "contractStatus");
			return (Criteria) this;
		}

		public Criteria andContractStatusNotIn(List<Integer> values) {
			addCriterion("CONTRACT_STATUS not in", values, "contractStatus");
			return (Criteria) this;
		}

		public Criteria andContractStatusBetween(Integer value1, Integer value2) {
			addCriterion("CONTRACT_STATUS between", value1, value2, "contractStatus");
			return (Criteria) this;
		}

		public Criteria andContractStatusNotBetween(Integer value1, Integer value2) {
			addCriterion("CONTRACT_STATUS not between", value1, value2, "contractStatus");
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

		public Criteria andPagesIsNull() {
			addCriterion("PAGES is null");
			return (Criteria) this;
		}

		public Criteria andPagesIsNotNull() {
			addCriterion("PAGES is not null");
			return (Criteria) this;
		}

		public Criteria andPagesEqualTo(Integer value) {
			addCriterion("PAGES =", value, "pages");
			return (Criteria) this;
		}

		public Criteria andPagesNotEqualTo(Integer value) {
			addCriterion("PAGES <>", value, "pages");
			return (Criteria) this;
		}

		public Criteria andPagesGreaterThan(Integer value) {
			addCriterion("PAGES >", value, "pages");
			return (Criteria) this;
		}

		public Criteria andPagesGreaterThanOrEqualTo(Integer value) {
			addCriterion("PAGES >=", value, "pages");
			return (Criteria) this;
		}

		public Criteria andPagesLessThan(Integer value) {
			addCriterion("PAGES <", value, "pages");
			return (Criteria) this;
		}

		public Criteria andPagesLessThanOrEqualTo(Integer value) {
			addCriterion("PAGES <=", value, "pages");
			return (Criteria) this;
		}

		public Criteria andPagesIn(List<Integer> values) {
			addCriterion("PAGES in", values, "pages");
			return (Criteria) this;
		}

		public Criteria andPagesNotIn(List<Integer> values) {
			addCriterion("PAGES not in", values, "pages");
			return (Criteria) this;
		}

		public Criteria andPagesBetween(Integer value1, Integer value2) {
			addCriterion("PAGES between", value1, value2, "pages");
			return (Criteria) this;
		}

		public Criteria andPagesNotBetween(Integer value1, Integer value2) {
			addCriterion("PAGES not between", value1, value2, "pages");
			return (Criteria) this;
		}

		public Criteria andInitContractPdfIsNull() {
			addCriterion("INIT_CONTRACT_PDF is null");
			return (Criteria) this;
		}

		public Criteria andInitContractPdfIsNotNull() {
			addCriterion("INIT_CONTRACT_PDF is not null");
			return (Criteria) this;
		}

		public Criteria andInitContractPdfEqualTo(String value) {
			addCriterion("INIT_CONTRACT_PDF =", value, "initContractPdf");
			return (Criteria) this;
		}

		public Criteria andInitContractPdfNotEqualTo(String value) {
			addCriterion("INIT_CONTRACT_PDF <>", value, "initContractPdf");
			return (Criteria) this;
		}

		public Criteria andInitContractPdfGreaterThan(String value) {
			addCriterion("INIT_CONTRACT_PDF >", value, "initContractPdf");
			return (Criteria) this;
		}

		public Criteria andInitContractPdfGreaterThanOrEqualTo(String value) {
			addCriterion("INIT_CONTRACT_PDF >=", value, "initContractPdf");
			return (Criteria) this;
		}

		public Criteria andInitContractPdfLessThan(String value) {
			addCriterion("INIT_CONTRACT_PDF <", value, "initContractPdf");
			return (Criteria) this;
		}

		public Criteria andInitContractPdfLessThanOrEqualTo(String value) {
			addCriterion("INIT_CONTRACT_PDF <=", value, "initContractPdf");
			return (Criteria) this;
		}

		public Criteria andInitContractPdfLike(String value) {
			addCriterion("INIT_CONTRACT_PDF like", value, "initContractPdf");
			return (Criteria) this;
		}

		public Criteria andInitContractPdfNotLike(String value) {
			addCriterion("INIT_CONTRACT_PDF not like", value, "initContractPdf");
			return (Criteria) this;
		}

		public Criteria andInitContractPdfIn(List<String> values) {
			addCriterion("INIT_CONTRACT_PDF in", values, "initContractPdf");
			return (Criteria) this;
		}

		public Criteria andInitContractPdfNotIn(List<String> values) {
			addCriterion("INIT_CONTRACT_PDF not in", values, "initContractPdf");
			return (Criteria) this;
		}

		public Criteria andInitContractPdfBetween(String value1, String value2) {
			addCriterion("INIT_CONTRACT_PDF between", value1, value2, "initContractPdf");
			return (Criteria) this;
		}

		public Criteria andInitContractPdfNotBetween(String value1, String value2) {
			addCriterion("INIT_CONTRACT_PDF not between", value1, value2, "initContractPdf");
			return (Criteria) this;
		}

		public Criteria andCompleteContractPdfIsNull() {
			addCriterion("COMPLETE_CONTRACT_PDF is null");
			return (Criteria) this;
		}

		public Criteria andCompleteContractPdfIsNotNull() {
			addCriterion("COMPLETE_CONTRACT_PDF is not null");
			return (Criteria) this;
		}

		public Criteria andCompleteContractPdfEqualTo(String value) {
			addCriterion("COMPLETE_CONTRACT_PDF =", value, "completeContractPdf");
			return (Criteria) this;
		}

		public Criteria andCompleteContractPdfNotEqualTo(String value) {
			addCriterion("COMPLETE_CONTRACT_PDF <>", value, "completeContractPdf");
			return (Criteria) this;
		}

		public Criteria andCompleteContractPdfGreaterThan(String value) {
			addCriterion("COMPLETE_CONTRACT_PDF >", value, "completeContractPdf");
			return (Criteria) this;
		}

		public Criteria andCompleteContractPdfGreaterThanOrEqualTo(String value) {
			addCriterion("COMPLETE_CONTRACT_PDF >=", value, "completeContractPdf");
			return (Criteria) this;
		}

		public Criteria andCompleteContractPdfLessThan(String value) {
			addCriterion("COMPLETE_CONTRACT_PDF <", value, "completeContractPdf");
			return (Criteria) this;
		}

		public Criteria andCompleteContractPdfLessThanOrEqualTo(String value) {
			addCriterion("COMPLETE_CONTRACT_PDF <=", value, "completeContractPdf");
			return (Criteria) this;
		}

		public Criteria andCompleteContractPdfLike(String value) {
			addCriterion("COMPLETE_CONTRACT_PDF like", value, "completeContractPdf");
			return (Criteria) this;
		}

		public Criteria andCompleteContractPdfNotLike(String value) {
			addCriterion("COMPLETE_CONTRACT_PDF not like", value, "completeContractPdf");
			return (Criteria) this;
		}

		public Criteria andCompleteContractPdfIn(List<String> values) {
			addCriterion("COMPLETE_CONTRACT_PDF in", values, "completeContractPdf");
			return (Criteria) this;
		}

		public Criteria andCompleteContractPdfNotIn(List<String> values) {
			addCriterion("COMPLETE_CONTRACT_PDF not in", values, "completeContractPdf");
			return (Criteria) this;
		}

		public Criteria andCompleteContractPdfBetween(String value1, String value2) {
			addCriterion("COMPLETE_CONTRACT_PDF between", value1, value2, "completeContractPdf");
			return (Criteria) this;
		}

		public Criteria andCompleteContractPdfNotBetween(String value1, String value2) {
			addCriterion("COMPLETE_CONTRACT_PDF not between", value1, value2, "completeContractPdf");
			return (Criteria) this;
		}

		public Criteria andFmd5IsNull() {
			addCriterion("FMD5 is null");
			return (Criteria) this;
		}

		public Criteria andFmd5IsNotNull() {
			addCriterion("FMD5 is not null");
			return (Criteria) this;
		}

		public Criteria andFmd5EqualTo(String value) {
			addCriterion("FMD5 =", value, "fmd5");
			return (Criteria) this;
		}

		public Criteria andFmd5NotEqualTo(String value) {
			addCriterion("FMD5 <>", value, "fmd5");
			return (Criteria) this;
		}

		public Criteria andFmd5GreaterThan(String value) {
			addCriterion("FMD5 >", value, "fmd5");
			return (Criteria) this;
		}

		public Criteria andFmd5GreaterThanOrEqualTo(String value) {
			addCriterion("FMD5 >=", value, "fmd5");
			return (Criteria) this;
		}

		public Criteria andFmd5LessThan(String value) {
			addCriterion("FMD5 <", value, "fmd5");
			return (Criteria) this;
		}

		public Criteria andFmd5LessThanOrEqualTo(String value) {
			addCriterion("FMD5 <=", value, "fmd5");
			return (Criteria) this;
		}

		public Criteria andFmd5Like(String value) {
			addCriterion("FMD5 like", value, "fmd5");
			return (Criteria) this;
		}

		public Criteria andFmd5NotLike(String value) {
			addCriterion("FMD5 not like", value, "fmd5");
			return (Criteria) this;
		}

		public Criteria andFmd5In(List<String> values) {
			addCriterion("FMD5 in", values, "fmd5");
			return (Criteria) this;
		}

		public Criteria andFmd5NotIn(List<String> values) {
			addCriterion("FMD5 not in", values, "fmd5");
			return (Criteria) this;
		}

		public Criteria andFmd5Between(String value1, String value2) {
			addCriterion("FMD5 between", value1, value2, "fmd5");
			return (Criteria) this;
		}

		public Criteria andFmd5NotBetween(String value1, String value2) {
			addCriterion("FMD5 not between", value1, value2, "fmd5");
			return (Criteria) this;
		}

		public Criteria andAccountIsNull() {
			addCriterion("ACCOUNT is null");
			return (Criteria) this;
		}

		public Criteria andAccountIsNotNull() {
			addCriterion("ACCOUNT is not null");
			return (Criteria) this;
		}

		public Criteria andAccountEqualTo(String value) {
			addCriterion("ACCOUNT =", value, "account");
			return (Criteria) this;
		}

		public Criteria andAccountNotEqualTo(String value) {
			addCriterion("ACCOUNT <>", value, "account");
			return (Criteria) this;
		}

		public Criteria andAccountGreaterThan(String value) {
			addCriterion("ACCOUNT >", value, "account");
			return (Criteria) this;
		}

		public Criteria andAccountGreaterThanOrEqualTo(String value) {
			addCriterion("ACCOUNT >=", value, "account");
			return (Criteria) this;
		}

		public Criteria andAccountLessThan(String value) {
			addCriterion("ACCOUNT <", value, "account");
			return (Criteria) this;
		}

		public Criteria andAccountLessThanOrEqualTo(String value) {
			addCriterion("ACCOUNT <=", value, "account");
			return (Criteria) this;
		}

		public Criteria andAccountLike(String value) {
			addCriterion("ACCOUNT like", value, "account");
			return (Criteria) this;
		}

		public Criteria andAccountNotLike(String value) {
			addCriterion("ACCOUNT not like", value, "account");
			return (Criteria) this;
		}

		public Criteria andAccountIn(List<String> values) {
			addCriterion("ACCOUNT in", values, "account");
			return (Criteria) this;
		}

		public Criteria andAccountNotIn(List<String> values) {
			addCriterion("ACCOUNT not in", values, "account");
			return (Criteria) this;
		}

		public Criteria andAccountBetween(String value1, String value2) {
			addCriterion("ACCOUNT between", value1, value2, "account");
			return (Criteria) this;
		}

		public Criteria andAccountNotBetween(String value1, String value2) {
			addCriterion("ACCOUNT not between", value1, value2, "account");
			return (Criteria) this;
		}

		public Criteria andPartyAInfoIsNull() {
			addCriterion("PARTY_A_INFO is null");
			return (Criteria) this;
		}

		public Criteria andPartyAInfoIsNotNull() {
			addCriterion("PARTY_A_INFO is not null");
			return (Criteria) this;
		}

		public Criteria andPartyAInfoEqualTo(String value) {
			addCriterion("PARTY_A_INFO =", value, "partyAInfo");
			return (Criteria) this;
		}

		public Criteria andPartyAInfoNotEqualTo(String value) {
			addCriterion("PARTY_A_INFO <>", value, "partyAInfo");
			return (Criteria) this;
		}

		public Criteria andPartyAInfoGreaterThan(String value) {
			addCriterion("PARTY_A_INFO >", value, "partyAInfo");
			return (Criteria) this;
		}

		public Criteria andPartyAInfoGreaterThanOrEqualTo(String value) {
			addCriterion("PARTY_A_INFO >=", value, "partyAInfo");
			return (Criteria) this;
		}

		public Criteria andPartyAInfoLessThan(String value) {
			addCriterion("PARTY_A_INFO <", value, "partyAInfo");
			return (Criteria) this;
		}

		public Criteria andPartyAInfoLessThanOrEqualTo(String value) {
			addCriterion("PARTY_A_INFO <=", value, "partyAInfo");
			return (Criteria) this;
		}

		public Criteria andPartyAInfoLike(String value) {
			addCriterion("PARTY_A_INFO like", value, "partyAInfo");
			return (Criteria) this;
		}

		public Criteria andPartyAInfoNotLike(String value) {
			addCriterion("PARTY_A_INFO not like", value, "partyAInfo");
			return (Criteria) this;
		}

		public Criteria andPartyAInfoIn(List<String> values) {
			addCriterion("PARTY_A_INFO in", values, "partyAInfo");
			return (Criteria) this;
		}

		public Criteria andPartyAInfoNotIn(List<String> values) {
			addCriterion("PARTY_A_INFO not in", values, "partyAInfo");
			return (Criteria) this;
		}

		public Criteria andPartyAInfoBetween(String value1, String value2) {
			addCriterion("PARTY_A_INFO between", value1, value2, "partyAInfo");
			return (Criteria) this;
		}

		public Criteria andPartyAInfoNotBetween(String value1, String value2) {
			addCriterion("PARTY_A_INFO not between", value1, value2, "partyAInfo");
			return (Criteria) this;
		}

		public Criteria andPartyBInfoIsNull() {
			addCriterion("PARTY_B_INFO is null");
			return (Criteria) this;
		}

		public Criteria andPartyBInfoIsNotNull() {
			addCriterion("PARTY_B_INFO is not null");
			return (Criteria) this;
		}

		public Criteria andPartyBInfoEqualTo(String value) {
			addCriterion("PARTY_B_INFO =", value, "partyBInfo");
			return (Criteria) this;
		}

		public Criteria andPartyBInfoNotEqualTo(String value) {
			addCriterion("PARTY_B_INFO <>", value, "partyBInfo");
			return (Criteria) this;
		}

		public Criteria andPartyBInfoGreaterThan(String value) {
			addCriterion("PARTY_B_INFO >", value, "partyBInfo");
			return (Criteria) this;
		}

		public Criteria andPartyBInfoGreaterThanOrEqualTo(String value) {
			addCriterion("PARTY_B_INFO >=", value, "partyBInfo");
			return (Criteria) this;
		}

		public Criteria andPartyBInfoLessThan(String value) {
			addCriterion("PARTY_B_INFO <", value, "partyBInfo");
			return (Criteria) this;
		}

		public Criteria andPartyBInfoLessThanOrEqualTo(String value) {
			addCriterion("PARTY_B_INFO <=", value, "partyBInfo");
			return (Criteria) this;
		}

		public Criteria andPartyBInfoLike(String value) {
			addCriterion("PARTY_B_INFO like", value, "partyBInfo");
			return (Criteria) this;
		}

		public Criteria andPartyBInfoNotLike(String value) {
			addCriterion("PARTY_B_INFO not like", value, "partyBInfo");
			return (Criteria) this;
		}

		public Criteria andPartyBInfoIn(List<String> values) {
			addCriterion("PARTY_B_INFO in", values, "partyBInfo");
			return (Criteria) this;
		}

		public Criteria andPartyBInfoNotIn(List<String> values) {
			addCriterion("PARTY_B_INFO not in", values, "partyBInfo");
			return (Criteria) this;
		}

		public Criteria andPartyBInfoBetween(String value1, String value2) {
			addCriterion("PARTY_B_INFO between", value1, value2, "partyBInfo");
			return (Criteria) this;
		}

		public Criteria andPartyBInfoNotBetween(String value1, String value2) {
			addCriterion("PARTY_B_INFO not between", value1, value2, "partyBInfo");
			return (Criteria) this;
		}

		public Criteria andPartyCInfoIsNull() {
			addCriterion("PARTY_C_INFO is null");
			return (Criteria) this;
		}

		public Criteria andPartyCInfoIsNotNull() {
			addCriterion("PARTY_C_INFO is not null");
			return (Criteria) this;
		}

		public Criteria andPartyCInfoEqualTo(String value) {
			addCriterion("PARTY_C_INFO =", value, "partyCInfo");
			return (Criteria) this;
		}

		public Criteria andPartyCInfoNotEqualTo(String value) {
			addCriterion("PARTY_C_INFO <>", value, "partyCInfo");
			return (Criteria) this;
		}

		public Criteria andPartyCInfoGreaterThan(String value) {
			addCriterion("PARTY_C_INFO >", value, "partyCInfo");
			return (Criteria) this;
		}

		public Criteria andPartyCInfoGreaterThanOrEqualTo(String value) {
			addCriterion("PARTY_C_INFO >=", value, "partyCInfo");
			return (Criteria) this;
		}

		public Criteria andPartyCInfoLessThan(String value) {
			addCriterion("PARTY_C_INFO <", value, "partyCInfo");
			return (Criteria) this;
		}

		public Criteria andPartyCInfoLessThanOrEqualTo(String value) {
			addCriterion("PARTY_C_INFO <=", value, "partyCInfo");
			return (Criteria) this;
		}

		public Criteria andPartyCInfoLike(String value) {
			addCriterion("PARTY_C_INFO like", value, "partyCInfo");
			return (Criteria) this;
		}

		public Criteria andPartyCInfoNotLike(String value) {
			addCriterion("PARTY_C_INFO not like", value, "partyCInfo");
			return (Criteria) this;
		}

		public Criteria andPartyCInfoIn(List<String> values) {
			addCriterion("PARTY_C_INFO in", values, "partyCInfo");
			return (Criteria) this;
		}

		public Criteria andPartyCInfoNotIn(List<String> values) {
			addCriterion("PARTY_C_INFO not in", values, "partyCInfo");
			return (Criteria) this;
		}

		public Criteria andPartyCInfoBetween(String value1, String value2) {
			addCriterion("PARTY_C_INFO between", value1, value2, "partyCInfo");
			return (Criteria) this;
		}

		public Criteria andPartyCInfoNotBetween(String value1, String value2) {
			addCriterion("PARTY_C_INFO not between", value1, value2, "partyCInfo");
			return (Criteria) this;
		}

		public Criteria andPartyACompleteIsNull() {
			addCriterion("PARTY_A_COMPLETE is null");
			return (Criteria) this;
		}

		public Criteria andPartyACompleteIsNotNull() {
			addCriterion("PARTY_A_COMPLETE is not null");
			return (Criteria) this;
		}

		public Criteria andPartyACompleteEqualTo(Byte value) {
			addCriterion("PARTY_A_COMPLETE =", value, "partyAComplete");
			return (Criteria) this;
		}

		public Criteria andPartyACompleteNotEqualTo(Byte value) {
			addCriterion("PARTY_A_COMPLETE <>", value, "partyAComplete");
			return (Criteria) this;
		}

		public Criteria andPartyACompleteGreaterThan(Byte value) {
			addCriterion("PARTY_A_COMPLETE >", value, "partyAComplete");
			return (Criteria) this;
		}

		public Criteria andPartyACompleteGreaterThanOrEqualTo(Byte value) {
			addCriterion("PARTY_A_COMPLETE >=", value, "partyAComplete");
			return (Criteria) this;
		}

		public Criteria andPartyACompleteLessThan(Byte value) {
			addCriterion("PARTY_A_COMPLETE <", value, "partyAComplete");
			return (Criteria) this;
		}

		public Criteria andPartyACompleteLessThanOrEqualTo(Byte value) {
			addCriterion("PARTY_A_COMPLETE <=", value, "partyAComplete");
			return (Criteria) this;
		}

		public Criteria andPartyACompleteIn(List<Byte> values) {
			addCriterion("PARTY_A_COMPLETE in", values, "partyAComplete");
			return (Criteria) this;
		}

		public Criteria andPartyACompleteNotIn(List<Byte> values) {
			addCriterion("PARTY_A_COMPLETE not in", values, "partyAComplete");
			return (Criteria) this;
		}

		public Criteria andPartyACompleteBetween(Byte value1, Byte value2) {
			addCriterion("PARTY_A_COMPLETE between", value1, value2, "partyAComplete");
			return (Criteria) this;
		}

		public Criteria andPartyACompleteNotBetween(Byte value1, Byte value2) {
			addCriterion("PARTY_A_COMPLETE not between", value1, value2, "partyAComplete");
			return (Criteria) this;
		}

		public Criteria andPartyBCompleteIsNull() {
			addCriterion("PARTY_B_COMPLETE is null");
			return (Criteria) this;
		}

		public Criteria andPartyBCompleteIsNotNull() {
			addCriterion("PARTY_B_COMPLETE is not null");
			return (Criteria) this;
		}

		public Criteria andPartyBCompleteEqualTo(Byte value) {
			addCriterion("PARTY_B_COMPLETE =", value, "partyBComplete");
			return (Criteria) this;
		}

		public Criteria andPartyBCompleteNotEqualTo(Byte value) {
			addCriterion("PARTY_B_COMPLETE <>", value, "partyBComplete");
			return (Criteria) this;
		}

		public Criteria andPartyBCompleteGreaterThan(Byte value) {
			addCriterion("PARTY_B_COMPLETE >", value, "partyBComplete");
			return (Criteria) this;
		}

		public Criteria andPartyBCompleteGreaterThanOrEqualTo(Byte value) {
			addCriterion("PARTY_B_COMPLETE >=", value, "partyBComplete");
			return (Criteria) this;
		}

		public Criteria andPartyBCompleteLessThan(Byte value) {
			addCriterion("PARTY_B_COMPLETE <", value, "partyBComplete");
			return (Criteria) this;
		}

		public Criteria andPartyBCompleteLessThanOrEqualTo(Byte value) {
			addCriterion("PARTY_B_COMPLETE <=", value, "partyBComplete");
			return (Criteria) this;
		}

		public Criteria andPartyBCompleteIn(List<Byte> values) {
			addCriterion("PARTY_B_COMPLETE in", values, "partyBComplete");
			return (Criteria) this;
		}

		public Criteria andPartyBCompleteNotIn(List<Byte> values) {
			addCriterion("PARTY_B_COMPLETE not in", values, "partyBComplete");
			return (Criteria) this;
		}

		public Criteria andPartyBCompleteBetween(Byte value1, Byte value2) {
			addCriterion("PARTY_B_COMPLETE between", value1, value2, "partyBComplete");
			return (Criteria) this;
		}

		public Criteria andPartyBCompleteNotBetween(Byte value1, Byte value2) {
			addCriterion("PARTY_B_COMPLETE not between", value1, value2, "partyBComplete");
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

		public Criteria andCompleteTimeIsNull() {
			addCriterion("COMPLETE_TIME is null");
			return (Criteria) this;
		}

		public Criteria andCompleteTimeIsNotNull() {
			addCriterion("COMPLETE_TIME is not null");
			return (Criteria) this;
		}

		public Criteria andCompleteTimeEqualTo(Date value) {
			addCriterion("COMPLETE_TIME =", value, "completeTime");
			return (Criteria) this;
		}

		public Criteria andCompleteTimeNotEqualTo(Date value) {
			addCriterion("COMPLETE_TIME <>", value, "completeTime");
			return (Criteria) this;
		}

		public Criteria andCompleteTimeGreaterThan(Date value) {
			addCriterion("COMPLETE_TIME >", value, "completeTime");
			return (Criteria) this;
		}

		public Criteria andCompleteTimeGreaterThanOrEqualTo(Date value) {
			addCriterion("COMPLETE_TIME >=", value, "completeTime");
			return (Criteria) this;
		}

		public Criteria andCompleteTimeLessThan(Date value) {
			addCriterion("COMPLETE_TIME <", value, "completeTime");
			return (Criteria) this;
		}

		public Criteria andCompleteTimeLessThanOrEqualTo(Date value) {
			addCriterion("COMPLETE_TIME <=", value, "completeTime");
			return (Criteria) this;
		}

		public Criteria andCompleteTimeIn(List<Date> values) {
			addCriterion("COMPLETE_TIME in", values, "completeTime");
			return (Criteria) this;
		}

		public Criteria andCompleteTimeNotIn(List<Date> values) {
			addCriterion("COMPLETE_TIME not in", values, "completeTime");
			return (Criteria) this;
		}

		public Criteria andCompleteTimeBetween(Date value1, Date value2) {
			addCriterion("COMPLETE_TIME between", value1, value2, "completeTime");
			return (Criteria) this;
		}

		public Criteria andCompleteTimeNotBetween(Date value1, Date value2) {
			addCriterion("COMPLETE_TIME not between", value1, value2, "completeTime");
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