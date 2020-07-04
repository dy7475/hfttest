package com.myfun.repository.erpdb.po;

import com.myfun.repository.support.generator.shard.ShardDb;
import java.util.ArrayList;
import java.util.List;

public class ErpFunDealTaxesExample extends ShardDb {
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
	public ErpFunDealTaxesExample() {
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

		public Criteria andTaxesFatherIdIsNull() {
			addCriterion("TAXES_FATHER_ID is null");
			return (Criteria) this;
		}

		public Criteria andTaxesFatherIdIsNotNull() {
			addCriterion("TAXES_FATHER_ID is not null");
			return (Criteria) this;
		}

		public Criteria andTaxesFatherIdEqualTo(Integer value) {
			addCriterion("TAXES_FATHER_ID =", value, "taxesFatherId");
			return (Criteria) this;
		}

		public Criteria andTaxesFatherIdNotEqualTo(Integer value) {
			addCriterion("TAXES_FATHER_ID <>", value, "taxesFatherId");
			return (Criteria) this;
		}

		public Criteria andTaxesFatherIdGreaterThan(Integer value) {
			addCriterion("TAXES_FATHER_ID >", value, "taxesFatherId");
			return (Criteria) this;
		}

		public Criteria andTaxesFatherIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("TAXES_FATHER_ID >=", value, "taxesFatherId");
			return (Criteria) this;
		}

		public Criteria andTaxesFatherIdLessThan(Integer value) {
			addCriterion("TAXES_FATHER_ID <", value, "taxesFatherId");
			return (Criteria) this;
		}

		public Criteria andTaxesFatherIdLessThanOrEqualTo(Integer value) {
			addCriterion("TAXES_FATHER_ID <=", value, "taxesFatherId");
			return (Criteria) this;
		}

		public Criteria andTaxesFatherIdIn(List<Integer> values) {
			addCriterion("TAXES_FATHER_ID in", values, "taxesFatherId");
			return (Criteria) this;
		}

		public Criteria andTaxesFatherIdNotIn(List<Integer> values) {
			addCriterion("TAXES_FATHER_ID not in", values, "taxesFatherId");
			return (Criteria) this;
		}

		public Criteria andTaxesFatherIdBetween(Integer value1, Integer value2) {
			addCriterion("TAXES_FATHER_ID between", value1, value2, "taxesFatherId");
			return (Criteria) this;
		}

		public Criteria andTaxesFatherIdNotBetween(Integer value1, Integer value2) {
			addCriterion("TAXES_FATHER_ID not between", value1, value2, "taxesFatherId");
			return (Criteria) this;
		}

		public Criteria andTaxesSubIdIsNull() {
			addCriterion("TAXES_SUB_ID is null");
			return (Criteria) this;
		}

		public Criteria andTaxesSubIdIsNotNull() {
			addCriterion("TAXES_SUB_ID is not null");
			return (Criteria) this;
		}

		public Criteria andTaxesSubIdEqualTo(Integer value) {
			addCriterion("TAXES_SUB_ID =", value, "taxesSubId");
			return (Criteria) this;
		}

		public Criteria andTaxesSubIdNotEqualTo(Integer value) {
			addCriterion("TAXES_SUB_ID <>", value, "taxesSubId");
			return (Criteria) this;
		}

		public Criteria andTaxesSubIdGreaterThan(Integer value) {
			addCriterion("TAXES_SUB_ID >", value, "taxesSubId");
			return (Criteria) this;
		}

		public Criteria andTaxesSubIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("TAXES_SUB_ID >=", value, "taxesSubId");
			return (Criteria) this;
		}

		public Criteria andTaxesSubIdLessThan(Integer value) {
			addCriterion("TAXES_SUB_ID <", value, "taxesSubId");
			return (Criteria) this;
		}

		public Criteria andTaxesSubIdLessThanOrEqualTo(Integer value) {
			addCriterion("TAXES_SUB_ID <=", value, "taxesSubId");
			return (Criteria) this;
		}

		public Criteria andTaxesSubIdIn(List<Integer> values) {
			addCriterion("TAXES_SUB_ID in", values, "taxesSubId");
			return (Criteria) this;
		}

		public Criteria andTaxesSubIdNotIn(List<Integer> values) {
			addCriterion("TAXES_SUB_ID not in", values, "taxesSubId");
			return (Criteria) this;
		}

		public Criteria andTaxesSubIdBetween(Integer value1, Integer value2) {
			addCriterion("TAXES_SUB_ID between", value1, value2, "taxesSubId");
			return (Criteria) this;
		}

		public Criteria andTaxesSubIdNotBetween(Integer value1, Integer value2) {
			addCriterion("TAXES_SUB_ID not between", value1, value2, "taxesSubId");
			return (Criteria) this;
		}

		public Criteria andTaxesTypeIsNull() {
			addCriterion("TAXES_TYPE is null");
			return (Criteria) this;
		}

		public Criteria andTaxesTypeIsNotNull() {
			addCriterion("TAXES_TYPE is not null");
			return (Criteria) this;
		}

		public Criteria andTaxesTypeEqualTo(Byte value) {
			addCriterion("TAXES_TYPE =", value, "taxesType");
			return (Criteria) this;
		}

		public Criteria andTaxesTypeNotEqualTo(Byte value) {
			addCriterion("TAXES_TYPE <>", value, "taxesType");
			return (Criteria) this;
		}

		public Criteria andTaxesTypeGreaterThan(Byte value) {
			addCriterion("TAXES_TYPE >", value, "taxesType");
			return (Criteria) this;
		}

		public Criteria andTaxesTypeGreaterThanOrEqualTo(Byte value) {
			addCriterion("TAXES_TYPE >=", value, "taxesType");
			return (Criteria) this;
		}

		public Criteria andTaxesTypeLessThan(Byte value) {
			addCriterion("TAXES_TYPE <", value, "taxesType");
			return (Criteria) this;
		}

		public Criteria andTaxesTypeLessThanOrEqualTo(Byte value) {
			addCriterion("TAXES_TYPE <=", value, "taxesType");
			return (Criteria) this;
		}

		public Criteria andTaxesTypeIn(List<Byte> values) {
			addCriterion("TAXES_TYPE in", values, "taxesType");
			return (Criteria) this;
		}

		public Criteria andTaxesTypeNotIn(List<Byte> values) {
			addCriterion("TAXES_TYPE not in", values, "taxesType");
			return (Criteria) this;
		}

		public Criteria andTaxesTypeBetween(Byte value1, Byte value2) {
			addCriterion("TAXES_TYPE between", value1, value2, "taxesType");
			return (Criteria) this;
		}

		public Criteria andTaxesTypeNotBetween(Byte value1, Byte value2) {
			addCriterion("TAXES_TYPE not between", value1, value2, "taxesType");
			return (Criteria) this;
		}

		public Criteria andTaxesDateIsNull() {
			addCriterion("TAXES_DATE is null");
			return (Criteria) this;
		}

		public Criteria andTaxesDateIsNotNull() {
			addCriterion("TAXES_DATE is not null");
			return (Criteria) this;
		}

		public Criteria andTaxesDateEqualTo(String value) {
			addCriterion("TAXES_DATE =", value, "taxesDate");
			return (Criteria) this;
		}

		public Criteria andTaxesDateNotEqualTo(String value) {
			addCriterion("TAXES_DATE <>", value, "taxesDate");
			return (Criteria) this;
		}

		public Criteria andTaxesDateGreaterThan(String value) {
			addCriterion("TAXES_DATE >", value, "taxesDate");
			return (Criteria) this;
		}

		public Criteria andTaxesDateGreaterThanOrEqualTo(String value) {
			addCriterion("TAXES_DATE >=", value, "taxesDate");
			return (Criteria) this;
		}

		public Criteria andTaxesDateLessThan(String value) {
			addCriterion("TAXES_DATE <", value, "taxesDate");
			return (Criteria) this;
		}

		public Criteria andTaxesDateLessThanOrEqualTo(String value) {
			addCriterion("TAXES_DATE <=", value, "taxesDate");
			return (Criteria) this;
		}

		public Criteria andTaxesDateLike(String value) {
			addCriterion("TAXES_DATE like", value, "taxesDate");
			return (Criteria) this;
		}

		public Criteria andTaxesDateNotLike(String value) {
			addCriterion("TAXES_DATE not like", value, "taxesDate");
			return (Criteria) this;
		}

		public Criteria andTaxesDateIn(List<String> values) {
			addCriterion("TAXES_DATE in", values, "taxesDate");
			return (Criteria) this;
		}

		public Criteria andTaxesDateNotIn(List<String> values) {
			addCriterion("TAXES_DATE not in", values, "taxesDate");
			return (Criteria) this;
		}

		public Criteria andTaxesDateBetween(String value1, String value2) {
			addCriterion("TAXES_DATE between", value1, value2, "taxesDate");
			return (Criteria) this;
		}

		public Criteria andTaxesDateNotBetween(String value1, String value2) {
			addCriterion("TAXES_DATE not between", value1, value2, "taxesDate");
			return (Criteria) this;
		}

		public Criteria andPriceIsNull() {
			addCriterion("PRICE is null");
			return (Criteria) this;
		}

		public Criteria andPriceIsNotNull() {
			addCriterion("PRICE is not null");
			return (Criteria) this;
		}

		public Criteria andPriceEqualTo(String value) {
			addCriterion("PRICE =", value, "price");
			return (Criteria) this;
		}

		public Criteria andPriceNotEqualTo(String value) {
			addCriterion("PRICE <>", value, "price");
			return (Criteria) this;
		}

		public Criteria andPriceGreaterThan(String value) {
			addCriterion("PRICE >", value, "price");
			return (Criteria) this;
		}

		public Criteria andPriceGreaterThanOrEqualTo(String value) {
			addCriterion("PRICE >=", value, "price");
			return (Criteria) this;
		}

		public Criteria andPriceLessThan(String value) {
			addCriterion("PRICE <", value, "price");
			return (Criteria) this;
		}

		public Criteria andPriceLessThanOrEqualTo(String value) {
			addCriterion("PRICE <=", value, "price");
			return (Criteria) this;
		}

		public Criteria andPriceLike(String value) {
			addCriterion("PRICE like", value, "price");
			return (Criteria) this;
		}

		public Criteria andPriceNotLike(String value) {
			addCriterion("PRICE not like", value, "price");
			return (Criteria) this;
		}

		public Criteria andPriceIn(List<String> values) {
			addCriterion("PRICE in", values, "price");
			return (Criteria) this;
		}

		public Criteria andPriceNotIn(List<String> values) {
			addCriterion("PRICE not in", values, "price");
			return (Criteria) this;
		}

		public Criteria andPriceBetween(String value1, String value2) {
			addCriterion("PRICE between", value1, value2, "price");
			return (Criteria) this;
		}

		public Criteria andPriceNotBetween(String value1, String value2) {
			addCriterion("PRICE not between", value1, value2, "price");
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

		public Criteria andTaxesFatherNameIsNull() {
			addCriterion("TAXES_FATHER_NAME is null");
			return (Criteria) this;
		}

		public Criteria andTaxesFatherNameIsNotNull() {
			addCriterion("TAXES_FATHER_NAME is not null");
			return (Criteria) this;
		}

		public Criteria andTaxesFatherNameEqualTo(String value) {
			addCriterion("TAXES_FATHER_NAME =", value, "taxesFatherName");
			return (Criteria) this;
		}

		public Criteria andTaxesFatherNameNotEqualTo(String value) {
			addCriterion("TAXES_FATHER_NAME <>", value, "taxesFatherName");
			return (Criteria) this;
		}

		public Criteria andTaxesFatherNameGreaterThan(String value) {
			addCriterion("TAXES_FATHER_NAME >", value, "taxesFatherName");
			return (Criteria) this;
		}

		public Criteria andTaxesFatherNameGreaterThanOrEqualTo(String value) {
			addCriterion("TAXES_FATHER_NAME >=", value, "taxesFatherName");
			return (Criteria) this;
		}

		public Criteria andTaxesFatherNameLessThan(String value) {
			addCriterion("TAXES_FATHER_NAME <", value, "taxesFatherName");
			return (Criteria) this;
		}

		public Criteria andTaxesFatherNameLessThanOrEqualTo(String value) {
			addCriterion("TAXES_FATHER_NAME <=", value, "taxesFatherName");
			return (Criteria) this;
		}

		public Criteria andTaxesFatherNameLike(String value) {
			addCriterion("TAXES_FATHER_NAME like", value, "taxesFatherName");
			return (Criteria) this;
		}

		public Criteria andTaxesFatherNameNotLike(String value) {
			addCriterion("TAXES_FATHER_NAME not like", value, "taxesFatherName");
			return (Criteria) this;
		}

		public Criteria andTaxesFatherNameIn(List<String> values) {
			addCriterion("TAXES_FATHER_NAME in", values, "taxesFatherName");
			return (Criteria) this;
		}

		public Criteria andTaxesFatherNameNotIn(List<String> values) {
			addCriterion("TAXES_FATHER_NAME not in", values, "taxesFatherName");
			return (Criteria) this;
		}

		public Criteria andTaxesFatherNameBetween(String value1, String value2) {
			addCriterion("TAXES_FATHER_NAME between", value1, value2, "taxesFatherName");
			return (Criteria) this;
		}

		public Criteria andTaxesFatherNameNotBetween(String value1, String value2) {
			addCriterion("TAXES_FATHER_NAME not between", value1, value2, "taxesFatherName");
			return (Criteria) this;
		}

		public Criteria andTaxesSubNameIsNull() {
			addCriterion("TAXES_SUB_NAME is null");
			return (Criteria) this;
		}

		public Criteria andTaxesSubNameIsNotNull() {
			addCriterion("TAXES_SUB_NAME is not null");
			return (Criteria) this;
		}

		public Criteria andTaxesSubNameEqualTo(String value) {
			addCriterion("TAXES_SUB_NAME =", value, "taxesSubName");
			return (Criteria) this;
		}

		public Criteria andTaxesSubNameNotEqualTo(String value) {
			addCriterion("TAXES_SUB_NAME <>", value, "taxesSubName");
			return (Criteria) this;
		}

		public Criteria andTaxesSubNameGreaterThan(String value) {
			addCriterion("TAXES_SUB_NAME >", value, "taxesSubName");
			return (Criteria) this;
		}

		public Criteria andTaxesSubNameGreaterThanOrEqualTo(String value) {
			addCriterion("TAXES_SUB_NAME >=", value, "taxesSubName");
			return (Criteria) this;
		}

		public Criteria andTaxesSubNameLessThan(String value) {
			addCriterion("TAXES_SUB_NAME <", value, "taxesSubName");
			return (Criteria) this;
		}

		public Criteria andTaxesSubNameLessThanOrEqualTo(String value) {
			addCriterion("TAXES_SUB_NAME <=", value, "taxesSubName");
			return (Criteria) this;
		}

		public Criteria andTaxesSubNameLike(String value) {
			addCriterion("TAXES_SUB_NAME like", value, "taxesSubName");
			return (Criteria) this;
		}

		public Criteria andTaxesSubNameNotLike(String value) {
			addCriterion("TAXES_SUB_NAME not like", value, "taxesSubName");
			return (Criteria) this;
		}

		public Criteria andTaxesSubNameIn(List<String> values) {
			addCriterion("TAXES_SUB_NAME in", values, "taxesSubName");
			return (Criteria) this;
		}

		public Criteria andTaxesSubNameNotIn(List<String> values) {
			addCriterion("TAXES_SUB_NAME not in", values, "taxesSubName");
			return (Criteria) this;
		}

		public Criteria andTaxesSubNameBetween(String value1, String value2) {
			addCriterion("TAXES_SUB_NAME between", value1, value2, "taxesSubName");
			return (Criteria) this;
		}

		public Criteria andTaxesSubNameNotBetween(String value1, String value2) {
			addCriterion("TAXES_SUB_NAME not between", value1, value2, "taxesSubName");
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

		public Criteria andCreateTimeEqualTo(String value) {
			addCriterion("CREATE_TIME =", value, "createTime");
			return (Criteria) this;
		}

		public Criteria andCreateTimeNotEqualTo(String value) {
			addCriterion("CREATE_TIME <>", value, "createTime");
			return (Criteria) this;
		}

		public Criteria andCreateTimeGreaterThan(String value) {
			addCriterion("CREATE_TIME >", value, "createTime");
			return (Criteria) this;
		}

		public Criteria andCreateTimeGreaterThanOrEqualTo(String value) {
			addCriterion("CREATE_TIME >=", value, "createTime");
			return (Criteria) this;
		}

		public Criteria andCreateTimeLessThan(String value) {
			addCriterion("CREATE_TIME <", value, "createTime");
			return (Criteria) this;
		}

		public Criteria andCreateTimeLessThanOrEqualTo(String value) {
			addCriterion("CREATE_TIME <=", value, "createTime");
			return (Criteria) this;
		}

		public Criteria andCreateTimeLike(String value) {
			addCriterion("CREATE_TIME like", value, "createTime");
			return (Criteria) this;
		}

		public Criteria andCreateTimeNotLike(String value) {
			addCriterion("CREATE_TIME not like", value, "createTime");
			return (Criteria) this;
		}

		public Criteria andCreateTimeIn(List<String> values) {
			addCriterion("CREATE_TIME in", values, "createTime");
			return (Criteria) this;
		}

		public Criteria andCreateTimeNotIn(List<String> values) {
			addCriterion("CREATE_TIME not in", values, "createTime");
			return (Criteria) this;
		}

		public Criteria andCreateTimeBetween(String value1, String value2) {
			addCriterion("CREATE_TIME between", value1, value2, "createTime");
			return (Criteria) this;
		}

		public Criteria andCreateTimeNotBetween(String value1, String value2) {
			addCriterion("CREATE_TIME not between", value1, value2, "createTime");
			return (Criteria) this;
		}

		public Criteria andPayTypeIsNull() {
			addCriterion("pay_type is null");
			return (Criteria) this;
		}

		public Criteria andPayTypeIsNotNull() {
			addCriterion("pay_type is not null");
			return (Criteria) this;
		}

		public Criteria andPayTypeEqualTo(Byte value) {
			addCriterion("pay_type =", value, "payType");
			return (Criteria) this;
		}

		public Criteria andPayTypeNotEqualTo(Byte value) {
			addCriterion("pay_type <>", value, "payType");
			return (Criteria) this;
		}

		public Criteria andPayTypeGreaterThan(Byte value) {
			addCriterion("pay_type >", value, "payType");
			return (Criteria) this;
		}

		public Criteria andPayTypeGreaterThanOrEqualTo(Byte value) {
			addCriterion("pay_type >=", value, "payType");
			return (Criteria) this;
		}

		public Criteria andPayTypeLessThan(Byte value) {
			addCriterion("pay_type <", value, "payType");
			return (Criteria) this;
		}

		public Criteria andPayTypeLessThanOrEqualTo(Byte value) {
			addCriterion("pay_type <=", value, "payType");
			return (Criteria) this;
		}

		public Criteria andPayTypeIn(List<Byte> values) {
			addCriterion("pay_type in", values, "payType");
			return (Criteria) this;
		}

		public Criteria andPayTypeNotIn(List<Byte> values) {
			addCriterion("pay_type not in", values, "payType");
			return (Criteria) this;
		}

		public Criteria andPayTypeBetween(Byte value1, Byte value2) {
			addCriterion("pay_type between", value1, value2, "payType");
			return (Criteria) this;
		}

		public Criteria andPayTypeNotBetween(Byte value1, Byte value2) {
			addCriterion("pay_type not between", value1, value2, "payType");
			return (Criteria) this;
		}

		public Criteria andTaxesFixedUnitIsNull() {
			addCriterion("taxes_fixed_unit is null");
			return (Criteria) this;
		}

		public Criteria andTaxesFixedUnitIsNotNull() {
			addCriterion("taxes_fixed_unit is not null");
			return (Criteria) this;
		}

		public Criteria andTaxesFixedUnitEqualTo(Byte value) {
			addCriterion("taxes_fixed_unit =", value, "taxesFixedUnit");
			return (Criteria) this;
		}

		public Criteria andTaxesFixedUnitNotEqualTo(Byte value) {
			addCriterion("taxes_fixed_unit <>", value, "taxesFixedUnit");
			return (Criteria) this;
		}

		public Criteria andTaxesFixedUnitGreaterThan(Byte value) {
			addCriterion("taxes_fixed_unit >", value, "taxesFixedUnit");
			return (Criteria) this;
		}

		public Criteria andTaxesFixedUnitGreaterThanOrEqualTo(Byte value) {
			addCriterion("taxes_fixed_unit >=", value, "taxesFixedUnit");
			return (Criteria) this;
		}

		public Criteria andTaxesFixedUnitLessThan(Byte value) {
			addCriterion("taxes_fixed_unit <", value, "taxesFixedUnit");
			return (Criteria) this;
		}

		public Criteria andTaxesFixedUnitLessThanOrEqualTo(Byte value) {
			addCriterion("taxes_fixed_unit <=", value, "taxesFixedUnit");
			return (Criteria) this;
		}

		public Criteria andTaxesFixedUnitIn(List<Byte> values) {
			addCriterion("taxes_fixed_unit in", values, "taxesFixedUnit");
			return (Criteria) this;
		}

		public Criteria andTaxesFixedUnitNotIn(List<Byte> values) {
			addCriterion("taxes_fixed_unit not in", values, "taxesFixedUnit");
			return (Criteria) this;
		}

		public Criteria andTaxesFixedUnitBetween(Byte value1, Byte value2) {
			addCriterion("taxes_fixed_unit between", value1, value2, "taxesFixedUnit");
			return (Criteria) this;
		}

		public Criteria andTaxesFixedUnitNotBetween(Byte value1, Byte value2) {
			addCriterion("taxes_fixed_unit not between", value1, value2, "taxesFixedUnit");
			return (Criteria) this;
		}

		public Criteria andUpdateUserIsNull() {
			addCriterion("UPDATE_USER is null");
			return (Criteria) this;
		}

		public Criteria andUpdateUserIsNotNull() {
			addCriterion("UPDATE_USER is not null");
			return (Criteria) this;
		}

		public Criteria andUpdateUserEqualTo(Integer value) {
			addCriterion("UPDATE_USER =", value, "updateUser");
			return (Criteria) this;
		}

		public Criteria andUpdateUserNotEqualTo(Integer value) {
			addCriterion("UPDATE_USER <>", value, "updateUser");
			return (Criteria) this;
		}

		public Criteria andUpdateUserGreaterThan(Integer value) {
			addCriterion("UPDATE_USER >", value, "updateUser");
			return (Criteria) this;
		}

		public Criteria andUpdateUserGreaterThanOrEqualTo(Integer value) {
			addCriterion("UPDATE_USER >=", value, "updateUser");
			return (Criteria) this;
		}

		public Criteria andUpdateUserLessThan(Integer value) {
			addCriterion("UPDATE_USER <", value, "updateUser");
			return (Criteria) this;
		}

		public Criteria andUpdateUserLessThanOrEqualTo(Integer value) {
			addCriterion("UPDATE_USER <=", value, "updateUser");
			return (Criteria) this;
		}

		public Criteria andUpdateUserIn(List<Integer> values) {
			addCriterion("UPDATE_USER in", values, "updateUser");
			return (Criteria) this;
		}

		public Criteria andUpdateUserNotIn(List<Integer> values) {
			addCriterion("UPDATE_USER not in", values, "updateUser");
			return (Criteria) this;
		}

		public Criteria andUpdateUserBetween(Integer value1, Integer value2) {
			addCriterion("UPDATE_USER between", value1, value2, "updateUser");
			return (Criteria) this;
		}

		public Criteria andUpdateUserNotBetween(Integer value1, Integer value2) {
			addCriterion("UPDATE_USER not between", value1, value2, "updateUser");
			return (Criteria) this;
		}

		public Criteria andUpdateUserNameIsNull() {
			addCriterion("UPDATE_USER_NAME is null");
			return (Criteria) this;
		}

		public Criteria andUpdateUserNameIsNotNull() {
			addCriterion("UPDATE_USER_NAME is not null");
			return (Criteria) this;
		}

		public Criteria andUpdateUserNameEqualTo(String value) {
			addCriterion("UPDATE_USER_NAME =", value, "updateUserName");
			return (Criteria) this;
		}

		public Criteria andUpdateUserNameNotEqualTo(String value) {
			addCriterion("UPDATE_USER_NAME <>", value, "updateUserName");
			return (Criteria) this;
		}

		public Criteria andUpdateUserNameGreaterThan(String value) {
			addCriterion("UPDATE_USER_NAME >", value, "updateUserName");
			return (Criteria) this;
		}

		public Criteria andUpdateUserNameGreaterThanOrEqualTo(String value) {
			addCriterion("UPDATE_USER_NAME >=", value, "updateUserName");
			return (Criteria) this;
		}

		public Criteria andUpdateUserNameLessThan(String value) {
			addCriterion("UPDATE_USER_NAME <", value, "updateUserName");
			return (Criteria) this;
		}

		public Criteria andUpdateUserNameLessThanOrEqualTo(String value) {
			addCriterion("UPDATE_USER_NAME <=", value, "updateUserName");
			return (Criteria) this;
		}

		public Criteria andUpdateUserNameLike(String value) {
			addCriterion("UPDATE_USER_NAME like", value, "updateUserName");
			return (Criteria) this;
		}

		public Criteria andUpdateUserNameNotLike(String value) {
			addCriterion("UPDATE_USER_NAME not like", value, "updateUserName");
			return (Criteria) this;
		}

		public Criteria andUpdateUserNameIn(List<String> values) {
			addCriterion("UPDATE_USER_NAME in", values, "updateUserName");
			return (Criteria) this;
		}

		public Criteria andUpdateUserNameNotIn(List<String> values) {
			addCriterion("UPDATE_USER_NAME not in", values, "updateUserName");
			return (Criteria) this;
		}

		public Criteria andUpdateUserNameBetween(String value1, String value2) {
			addCriterion("UPDATE_USER_NAME between", value1, value2, "updateUserName");
			return (Criteria) this;
		}

		public Criteria andUpdateUserNameNotBetween(String value1, String value2) {
			addCriterion("UPDATE_USER_NAME not between", value1, value2, "updateUserName");
			return (Criteria) this;
		}

		public Criteria andCheckFlagIsNull() {
			addCriterion("CHECK_FLAG is null");
			return (Criteria) this;
		}

		public Criteria andCheckFlagIsNotNull() {
			addCriterion("CHECK_FLAG is not null");
			return (Criteria) this;
		}

		public Criteria andCheckFlagEqualTo(Byte value) {
			addCriterion("CHECK_FLAG =", value, "checkFlag");
			return (Criteria) this;
		}

		public Criteria andCheckFlagNotEqualTo(Byte value) {
			addCriterion("CHECK_FLAG <>", value, "checkFlag");
			return (Criteria) this;
		}

		public Criteria andCheckFlagGreaterThan(Byte value) {
			addCriterion("CHECK_FLAG >", value, "checkFlag");
			return (Criteria) this;
		}

		public Criteria andCheckFlagGreaterThanOrEqualTo(Byte value) {
			addCriterion("CHECK_FLAG >=", value, "checkFlag");
			return (Criteria) this;
		}

		public Criteria andCheckFlagLessThan(Byte value) {
			addCriterion("CHECK_FLAG <", value, "checkFlag");
			return (Criteria) this;
		}

		public Criteria andCheckFlagLessThanOrEqualTo(Byte value) {
			addCriterion("CHECK_FLAG <=", value, "checkFlag");
			return (Criteria) this;
		}

		public Criteria andCheckFlagIn(List<Byte> values) {
			addCriterion("CHECK_FLAG in", values, "checkFlag");
			return (Criteria) this;
		}

		public Criteria andCheckFlagNotIn(List<Byte> values) {
			addCriterion("CHECK_FLAG not in", values, "checkFlag");
			return (Criteria) this;
		}

		public Criteria andCheckFlagBetween(Byte value1, Byte value2) {
			addCriterion("CHECK_FLAG between", value1, value2, "checkFlag");
			return (Criteria) this;
		}

		public Criteria andCheckFlagNotBetween(Byte value1, Byte value2) {
			addCriterion("CHECK_FLAG not between", value1, value2, "checkFlag");
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