package com.myfun.repository.admindb.po;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AdminSsqAccountInfoExample {
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
	public AdminSsqAccountInfoExample() {
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

		public Criteria andUserTypeIsNull() {
			addCriterion("USER_TYPE is null");
			return (Criteria) this;
		}

		public Criteria andUserTypeIsNotNull() {
			addCriterion("USER_TYPE is not null");
			return (Criteria) this;
		}

		public Criteria andUserTypeEqualTo(Integer value) {
			addCriterion("USER_TYPE =", value, "userType");
			return (Criteria) this;
		}

		public Criteria andUserTypeNotEqualTo(Integer value) {
			addCriterion("USER_TYPE <>", value, "userType");
			return (Criteria) this;
		}

		public Criteria andUserTypeGreaterThan(Integer value) {
			addCriterion("USER_TYPE >", value, "userType");
			return (Criteria) this;
		}

		public Criteria andUserTypeGreaterThanOrEqualTo(Integer value) {
			addCriterion("USER_TYPE >=", value, "userType");
			return (Criteria) this;
		}

		public Criteria andUserTypeLessThan(Integer value) {
			addCriterion("USER_TYPE <", value, "userType");
			return (Criteria) this;
		}

		public Criteria andUserTypeLessThanOrEqualTo(Integer value) {
			addCriterion("USER_TYPE <=", value, "userType");
			return (Criteria) this;
		}

		public Criteria andUserTypeIn(List<Integer> values) {
			addCriterion("USER_TYPE in", values, "userType");
			return (Criteria) this;
		}

		public Criteria andUserTypeNotIn(List<Integer> values) {
			addCriterion("USER_TYPE not in", values, "userType");
			return (Criteria) this;
		}

		public Criteria andUserTypeBetween(Integer value1, Integer value2) {
			addCriterion("USER_TYPE between", value1, value2, "userType");
			return (Criteria) this;
		}

		public Criteria andUserTypeNotBetween(Integer value1, Integer value2) {
			addCriterion("USER_TYPE not between", value1, value2, "userType");
			return (Criteria) this;
		}

		public Criteria andCertIdIsNull() {
			addCriterion("CERT_ID is null");
			return (Criteria) this;
		}

		public Criteria andCertIdIsNotNull() {
			addCriterion("CERT_ID is not null");
			return (Criteria) this;
		}

		public Criteria andCertIdEqualTo(String value) {
			addCriterion("CERT_ID =", value, "certId");
			return (Criteria) this;
		}

		public Criteria andCertIdNotEqualTo(String value) {
			addCriterion("CERT_ID <>", value, "certId");
			return (Criteria) this;
		}

		public Criteria andCertIdGreaterThan(String value) {
			addCriterion("CERT_ID >", value, "certId");
			return (Criteria) this;
		}

		public Criteria andCertIdGreaterThanOrEqualTo(String value) {
			addCriterion("CERT_ID >=", value, "certId");
			return (Criteria) this;
		}

		public Criteria andCertIdLessThan(String value) {
			addCriterion("CERT_ID <", value, "certId");
			return (Criteria) this;
		}

		public Criteria andCertIdLessThanOrEqualTo(String value) {
			addCriterion("CERT_ID <=", value, "certId");
			return (Criteria) this;
		}

		public Criteria andCertIdLike(String value) {
			addCriterion("CERT_ID like", value, "certId");
			return (Criteria) this;
		}

		public Criteria andCertIdNotLike(String value) {
			addCriterion("CERT_ID not like", value, "certId");
			return (Criteria) this;
		}

		public Criteria andCertIdIn(List<String> values) {
			addCriterion("CERT_ID in", values, "certId");
			return (Criteria) this;
		}

		public Criteria andCertIdNotIn(List<String> values) {
			addCriterion("CERT_ID not in", values, "certId");
			return (Criteria) this;
		}

		public Criteria andCertIdBetween(String value1, String value2) {
			addCriterion("CERT_ID between", value1, value2, "certId");
			return (Criteria) this;
		}

		public Criteria andCertIdNotBetween(String value1, String value2) {
			addCriterion("CERT_ID not between", value1, value2, "certId");
			return (Criteria) this;
		}

		public Criteria andNameIsNull() {
			addCriterion("[NAME] is null");
			return (Criteria) this;
		}

		public Criteria andNameIsNotNull() {
			addCriterion("[NAME] is not null");
			return (Criteria) this;
		}

		public Criteria andNameEqualTo(String value) {
			addCriterion("[NAME] =", value, "name");
			return (Criteria) this;
		}

		public Criteria andNameNotEqualTo(String value) {
			addCriterion("[NAME] <>", value, "name");
			return (Criteria) this;
		}

		public Criteria andNameGreaterThan(String value) {
			addCriterion("[NAME] >", value, "name");
			return (Criteria) this;
		}

		public Criteria andNameGreaterThanOrEqualTo(String value) {
			addCriterion("[NAME] >=", value, "name");
			return (Criteria) this;
		}

		public Criteria andNameLessThan(String value) {
			addCriterion("[NAME] <", value, "name");
			return (Criteria) this;
		}

		public Criteria andNameLessThanOrEqualTo(String value) {
			addCriterion("[NAME] <=", value, "name");
			return (Criteria) this;
		}

		public Criteria andNameLike(String value) {
			addCriterion("[NAME] like", value, "name");
			return (Criteria) this;
		}

		public Criteria andNameNotLike(String value) {
			addCriterion("[NAME] not like", value, "name");
			return (Criteria) this;
		}

		public Criteria andNameIn(List<String> values) {
			addCriterion("[NAME] in", values, "name");
			return (Criteria) this;
		}

		public Criteria andNameNotIn(List<String> values) {
			addCriterion("[NAME] not in", values, "name");
			return (Criteria) this;
		}

		public Criteria andNameBetween(String value1, String value2) {
			addCriterion("[NAME] between", value1, value2, "name");
			return (Criteria) this;
		}

		public Criteria andNameNotBetween(String value1, String value2) {
			addCriterion("[NAME] not between", value1, value2, "name");
			return (Criteria) this;
		}

		public Criteria andIdentityCodeIsNull() {
			addCriterion("IDENTITY_CODE is null");
			return (Criteria) this;
		}

		public Criteria andIdentityCodeIsNotNull() {
			addCriterion("IDENTITY_CODE is not null");
			return (Criteria) this;
		}

		public Criteria andIdentityCodeEqualTo(String value) {
			addCriterion("IDENTITY_CODE =", value, "identityCode");
			return (Criteria) this;
		}

		public Criteria andIdentityCodeNotEqualTo(String value) {
			addCriterion("IDENTITY_CODE <>", value, "identityCode");
			return (Criteria) this;
		}

		public Criteria andIdentityCodeGreaterThan(String value) {
			addCriterion("IDENTITY_CODE >", value, "identityCode");
			return (Criteria) this;
		}

		public Criteria andIdentityCodeGreaterThanOrEqualTo(String value) {
			addCriterion("IDENTITY_CODE >=", value, "identityCode");
			return (Criteria) this;
		}

		public Criteria andIdentityCodeLessThan(String value) {
			addCriterion("IDENTITY_CODE <", value, "identityCode");
			return (Criteria) this;
		}

		public Criteria andIdentityCodeLessThanOrEqualTo(String value) {
			addCriterion("IDENTITY_CODE <=", value, "identityCode");
			return (Criteria) this;
		}

		public Criteria andIdentityCodeLike(String value) {
			addCriterion("IDENTITY_CODE like", value, "identityCode");
			return (Criteria) this;
		}

		public Criteria andIdentityCodeNotLike(String value) {
			addCriterion("IDENTITY_CODE not like", value, "identityCode");
			return (Criteria) this;
		}

		public Criteria andIdentityCodeIn(List<String> values) {
			addCriterion("IDENTITY_CODE in", values, "identityCode");
			return (Criteria) this;
		}

		public Criteria andIdentityCodeNotIn(List<String> values) {
			addCriterion("IDENTITY_CODE not in", values, "identityCode");
			return (Criteria) this;
		}

		public Criteria andIdentityCodeBetween(String value1, String value2) {
			addCriterion("IDENTITY_CODE between", value1, value2, "identityCode");
			return (Criteria) this;
		}

		public Criteria andIdentityCodeNotBetween(String value1, String value2) {
			addCriterion("IDENTITY_CODE not between", value1, value2, "identityCode");
			return (Criteria) this;
		}

		public Criteria andRegCodeIsNull() {
			addCriterion("REG_CODE is null");
			return (Criteria) this;
		}

		public Criteria andRegCodeIsNotNull() {
			addCriterion("REG_CODE is not null");
			return (Criteria) this;
		}

		public Criteria andRegCodeEqualTo(String value) {
			addCriterion("REG_CODE =", value, "regCode");
			return (Criteria) this;
		}

		public Criteria andRegCodeNotEqualTo(String value) {
			addCriterion("REG_CODE <>", value, "regCode");
			return (Criteria) this;
		}

		public Criteria andRegCodeGreaterThan(String value) {
			addCriterion("REG_CODE >", value, "regCode");
			return (Criteria) this;
		}

		public Criteria andRegCodeGreaterThanOrEqualTo(String value) {
			addCriterion("REG_CODE >=", value, "regCode");
			return (Criteria) this;
		}

		public Criteria andRegCodeLessThan(String value) {
			addCriterion("REG_CODE <", value, "regCode");
			return (Criteria) this;
		}

		public Criteria andRegCodeLessThanOrEqualTo(String value) {
			addCriterion("REG_CODE <=", value, "regCode");
			return (Criteria) this;
		}

		public Criteria andRegCodeLike(String value) {
			addCriterion("REG_CODE like", value, "regCode");
			return (Criteria) this;
		}

		public Criteria andRegCodeNotLike(String value) {
			addCriterion("REG_CODE not like", value, "regCode");
			return (Criteria) this;
		}

		public Criteria andRegCodeIn(List<String> values) {
			addCriterion("REG_CODE in", values, "regCode");
			return (Criteria) this;
		}

		public Criteria andRegCodeNotIn(List<String> values) {
			addCriterion("REG_CODE not in", values, "regCode");
			return (Criteria) this;
		}

		public Criteria andRegCodeBetween(String value1, String value2) {
			addCriterion("REG_CODE between", value1, value2, "regCode");
			return (Criteria) this;
		}

		public Criteria andRegCodeNotBetween(String value1, String value2) {
			addCriterion("REG_CODE not between", value1, value2, "regCode");
			return (Criteria) this;
		}

		public Criteria andOrgCodeIsNull() {
			addCriterion("ORG_CODE is null");
			return (Criteria) this;
		}

		public Criteria andOrgCodeIsNotNull() {
			addCriterion("ORG_CODE is not null");
			return (Criteria) this;
		}

		public Criteria andOrgCodeEqualTo(String value) {
			addCriterion("ORG_CODE =", value, "orgCode");
			return (Criteria) this;
		}

		public Criteria andOrgCodeNotEqualTo(String value) {
			addCriterion("ORG_CODE <>", value, "orgCode");
			return (Criteria) this;
		}

		public Criteria andOrgCodeGreaterThan(String value) {
			addCriterion("ORG_CODE >", value, "orgCode");
			return (Criteria) this;
		}

		public Criteria andOrgCodeGreaterThanOrEqualTo(String value) {
			addCriterion("ORG_CODE >=", value, "orgCode");
			return (Criteria) this;
		}

		public Criteria andOrgCodeLessThan(String value) {
			addCriterion("ORG_CODE <", value, "orgCode");
			return (Criteria) this;
		}

		public Criteria andOrgCodeLessThanOrEqualTo(String value) {
			addCriterion("ORG_CODE <=", value, "orgCode");
			return (Criteria) this;
		}

		public Criteria andOrgCodeLike(String value) {
			addCriterion("ORG_CODE like", value, "orgCode");
			return (Criteria) this;
		}

		public Criteria andOrgCodeNotLike(String value) {
			addCriterion("ORG_CODE not like", value, "orgCode");
			return (Criteria) this;
		}

		public Criteria andOrgCodeIn(List<String> values) {
			addCriterion("ORG_CODE in", values, "orgCode");
			return (Criteria) this;
		}

		public Criteria andOrgCodeNotIn(List<String> values) {
			addCriterion("ORG_CODE not in", values, "orgCode");
			return (Criteria) this;
		}

		public Criteria andOrgCodeBetween(String value1, String value2) {
			addCriterion("ORG_CODE between", value1, value2, "orgCode");
			return (Criteria) this;
		}

		public Criteria andOrgCodeNotBetween(String value1, String value2) {
			addCriterion("ORG_CODE not between", value1, value2, "orgCode");
			return (Criteria) this;
		}

		public Criteria andTaxCodeIsNull() {
			addCriterion("TAX_CODE is null");
			return (Criteria) this;
		}

		public Criteria andTaxCodeIsNotNull() {
			addCriterion("TAX_CODE is not null");
			return (Criteria) this;
		}

		public Criteria andTaxCodeEqualTo(String value) {
			addCriterion("TAX_CODE =", value, "taxCode");
			return (Criteria) this;
		}

		public Criteria andTaxCodeNotEqualTo(String value) {
			addCriterion("TAX_CODE <>", value, "taxCode");
			return (Criteria) this;
		}

		public Criteria andTaxCodeGreaterThan(String value) {
			addCriterion("TAX_CODE >", value, "taxCode");
			return (Criteria) this;
		}

		public Criteria andTaxCodeGreaterThanOrEqualTo(String value) {
			addCriterion("TAX_CODE >=", value, "taxCode");
			return (Criteria) this;
		}

		public Criteria andTaxCodeLessThan(String value) {
			addCriterion("TAX_CODE <", value, "taxCode");
			return (Criteria) this;
		}

		public Criteria andTaxCodeLessThanOrEqualTo(String value) {
			addCriterion("TAX_CODE <=", value, "taxCode");
			return (Criteria) this;
		}

		public Criteria andTaxCodeLike(String value) {
			addCriterion("TAX_CODE like", value, "taxCode");
			return (Criteria) this;
		}

		public Criteria andTaxCodeNotLike(String value) {
			addCriterion("TAX_CODE not like", value, "taxCode");
			return (Criteria) this;
		}

		public Criteria andTaxCodeIn(List<String> values) {
			addCriterion("TAX_CODE in", values, "taxCode");
			return (Criteria) this;
		}

		public Criteria andTaxCodeNotIn(List<String> values) {
			addCriterion("TAX_CODE not in", values, "taxCode");
			return (Criteria) this;
		}

		public Criteria andTaxCodeBetween(String value1, String value2) {
			addCriterion("TAX_CODE between", value1, value2, "taxCode");
			return (Criteria) this;
		}

		public Criteria andTaxCodeNotBetween(String value1, String value2) {
			addCriterion("TAX_CODE not between", value1, value2, "taxCode");
			return (Criteria) this;
		}

		public Criteria andLegalPersonIsNull() {
			addCriterion("LEGAL_PERSON is null");
			return (Criteria) this;
		}

		public Criteria andLegalPersonIsNotNull() {
			addCriterion("LEGAL_PERSON is not null");
			return (Criteria) this;
		}

		public Criteria andLegalPersonEqualTo(String value) {
			addCriterion("LEGAL_PERSON =", value, "legalPerson");
			return (Criteria) this;
		}

		public Criteria andLegalPersonNotEqualTo(String value) {
			addCriterion("LEGAL_PERSON <>", value, "legalPerson");
			return (Criteria) this;
		}

		public Criteria andLegalPersonGreaterThan(String value) {
			addCriterion("LEGAL_PERSON >", value, "legalPerson");
			return (Criteria) this;
		}

		public Criteria andLegalPersonGreaterThanOrEqualTo(String value) {
			addCriterion("LEGAL_PERSON >=", value, "legalPerson");
			return (Criteria) this;
		}

		public Criteria andLegalPersonLessThan(String value) {
			addCriterion("LEGAL_PERSON <", value, "legalPerson");
			return (Criteria) this;
		}

		public Criteria andLegalPersonLessThanOrEqualTo(String value) {
			addCriterion("LEGAL_PERSON <=", value, "legalPerson");
			return (Criteria) this;
		}

		public Criteria andLegalPersonLike(String value) {
			addCriterion("LEGAL_PERSON like", value, "legalPerson");
			return (Criteria) this;
		}

		public Criteria andLegalPersonNotLike(String value) {
			addCriterion("LEGAL_PERSON not like", value, "legalPerson");
			return (Criteria) this;
		}

		public Criteria andLegalPersonIn(List<String> values) {
			addCriterion("LEGAL_PERSON in", values, "legalPerson");
			return (Criteria) this;
		}

		public Criteria andLegalPersonNotIn(List<String> values) {
			addCriterion("LEGAL_PERSON not in", values, "legalPerson");
			return (Criteria) this;
		}

		public Criteria andLegalPersonBetween(String value1, String value2) {
			addCriterion("LEGAL_PERSON between", value1, value2, "legalPerson");
			return (Criteria) this;
		}

		public Criteria andLegalPersonNotBetween(String value1, String value2) {
			addCriterion("LEGAL_PERSON not between", value1, value2, "legalPerson");
			return (Criteria) this;
		}

		public Criteria andContactMobileIsNull() {
			addCriterion("CONTACT_MOBILE is null");
			return (Criteria) this;
		}

		public Criteria andContactMobileIsNotNull() {
			addCriterion("CONTACT_MOBILE is not null");
			return (Criteria) this;
		}

		public Criteria andContactMobileEqualTo(String value) {
			addCriterion("CONTACT_MOBILE =", value, "contactMobile");
			return (Criteria) this;
		}

		public Criteria andContactMobileNotEqualTo(String value) {
			addCriterion("CONTACT_MOBILE <>", value, "contactMobile");
			return (Criteria) this;
		}

		public Criteria andContactMobileGreaterThan(String value) {
			addCriterion("CONTACT_MOBILE >", value, "contactMobile");
			return (Criteria) this;
		}

		public Criteria andContactMobileGreaterThanOrEqualTo(String value) {
			addCriterion("CONTACT_MOBILE >=", value, "contactMobile");
			return (Criteria) this;
		}

		public Criteria andContactMobileLessThan(String value) {
			addCriterion("CONTACT_MOBILE <", value, "contactMobile");
			return (Criteria) this;
		}

		public Criteria andContactMobileLessThanOrEqualTo(String value) {
			addCriterion("CONTACT_MOBILE <=", value, "contactMobile");
			return (Criteria) this;
		}

		public Criteria andContactMobileLike(String value) {
			addCriterion("CONTACT_MOBILE like", value, "contactMobile");
			return (Criteria) this;
		}

		public Criteria andContactMobileNotLike(String value) {
			addCriterion("CONTACT_MOBILE not like", value, "contactMobile");
			return (Criteria) this;
		}

		public Criteria andContactMobileIn(List<String> values) {
			addCriterion("CONTACT_MOBILE in", values, "contactMobile");
			return (Criteria) this;
		}

		public Criteria andContactMobileNotIn(List<String> values) {
			addCriterion("CONTACT_MOBILE not in", values, "contactMobile");
			return (Criteria) this;
		}

		public Criteria andContactMobileBetween(String value1, String value2) {
			addCriterion("CONTACT_MOBILE between", value1, value2, "contactMobile");
			return (Criteria) this;
		}

		public Criteria andContactMobileNotBetween(String value1, String value2) {
			addCriterion("CONTACT_MOBILE not between", value1, value2, "contactMobile");
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