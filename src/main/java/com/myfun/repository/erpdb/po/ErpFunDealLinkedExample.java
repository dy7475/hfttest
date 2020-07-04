package com.myfun.repository.erpdb.po;

import com.myfun.repository.support.generator.shard.ShardDb;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ErpFunDealLinkedExample extends ShardDb {
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
	public ErpFunDealLinkedExample() {
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

		public Criteria andPartnerIdIsNull() {
			addCriterion("PARTNER_ID is null");
			return (Criteria) this;
		}

		public Criteria andPartnerIdIsNotNull() {
			addCriterion("PARTNER_ID is not null");
			return (Criteria) this;
		}

		public Criteria andPartnerIdEqualTo(Integer value) {
			addCriterion("PARTNER_ID =", value, "partnerId");
			return (Criteria) this;
		}

		public Criteria andPartnerIdNotEqualTo(Integer value) {
			addCriterion("PARTNER_ID <>", value, "partnerId");
			return (Criteria) this;
		}

		public Criteria andPartnerIdGreaterThan(Integer value) {
			addCriterion("PARTNER_ID >", value, "partnerId");
			return (Criteria) this;
		}

		public Criteria andPartnerIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("PARTNER_ID >=", value, "partnerId");
			return (Criteria) this;
		}

		public Criteria andPartnerIdLessThan(Integer value) {
			addCriterion("PARTNER_ID <", value, "partnerId");
			return (Criteria) this;
		}

		public Criteria andPartnerIdLessThanOrEqualTo(Integer value) {
			addCriterion("PARTNER_ID <=", value, "partnerId");
			return (Criteria) this;
		}

		public Criteria andPartnerIdIn(List<Integer> values) {
			addCriterion("PARTNER_ID in", values, "partnerId");
			return (Criteria) this;
		}

		public Criteria andPartnerIdNotIn(List<Integer> values) {
			addCriterion("PARTNER_ID not in", values, "partnerId");
			return (Criteria) this;
		}

		public Criteria andPartnerIdBetween(Integer value1, Integer value2) {
			addCriterion("PARTNER_ID between", value1, value2, "partnerId");
			return (Criteria) this;
		}

		public Criteria andPartnerIdNotBetween(Integer value1, Integer value2) {
			addCriterion("PARTNER_ID not between", value1, value2, "partnerId");
			return (Criteria) this;
		}

		public Criteria andEnterpriseNameIsNull() {
			addCriterion("ENTERPRISE_NAME is null");
			return (Criteria) this;
		}

		public Criteria andEnterpriseNameIsNotNull() {
			addCriterion("ENTERPRISE_NAME is not null");
			return (Criteria) this;
		}

		public Criteria andEnterpriseNameEqualTo(String value) {
			addCriterion("ENTERPRISE_NAME =", value, "enterpriseName");
			return (Criteria) this;
		}

		public Criteria andEnterpriseNameNotEqualTo(String value) {
			addCriterion("ENTERPRISE_NAME <>", value, "enterpriseName");
			return (Criteria) this;
		}

		public Criteria andEnterpriseNameGreaterThan(String value) {
			addCriterion("ENTERPRISE_NAME >", value, "enterpriseName");
			return (Criteria) this;
		}

		public Criteria andEnterpriseNameGreaterThanOrEqualTo(String value) {
			addCriterion("ENTERPRISE_NAME >=", value, "enterpriseName");
			return (Criteria) this;
		}

		public Criteria andEnterpriseNameLessThan(String value) {
			addCriterion("ENTERPRISE_NAME <", value, "enterpriseName");
			return (Criteria) this;
		}

		public Criteria andEnterpriseNameLessThanOrEqualTo(String value) {
			addCriterion("ENTERPRISE_NAME <=", value, "enterpriseName");
			return (Criteria) this;
		}

		public Criteria andEnterpriseNameLike(String value) {
			addCriterion("ENTERPRISE_NAME like", value, "enterpriseName");
			return (Criteria) this;
		}

		public Criteria andEnterpriseNameNotLike(String value) {
			addCriterion("ENTERPRISE_NAME not like", value, "enterpriseName");
			return (Criteria) this;
		}

		public Criteria andEnterpriseNameIn(List<String> values) {
			addCriterion("ENTERPRISE_NAME in", values, "enterpriseName");
			return (Criteria) this;
		}

		public Criteria andEnterpriseNameNotIn(List<String> values) {
			addCriterion("ENTERPRISE_NAME not in", values, "enterpriseName");
			return (Criteria) this;
		}

		public Criteria andEnterpriseNameBetween(String value1, String value2) {
			addCriterion("ENTERPRISE_NAME between", value1, value2, "enterpriseName");
			return (Criteria) this;
		}

		public Criteria andEnterpriseNameNotBetween(String value1, String value2) {
			addCriterion("ENTERPRISE_NAME not between", value1, value2, "enterpriseName");
			return (Criteria) this;
		}

		public Criteria andEnterpriseCreditCodeIsNull() {
			addCriterion("ENTERPRISE_CREDIT_CODE is null");
			return (Criteria) this;
		}

		public Criteria andEnterpriseCreditCodeIsNotNull() {
			addCriterion("ENTERPRISE_CREDIT_CODE is not null");
			return (Criteria) this;
		}

		public Criteria andEnterpriseCreditCodeEqualTo(String value) {
			addCriterion("ENTERPRISE_CREDIT_CODE =", value, "enterpriseCreditCode");
			return (Criteria) this;
		}

		public Criteria andEnterpriseCreditCodeNotEqualTo(String value) {
			addCriterion("ENTERPRISE_CREDIT_CODE <>", value, "enterpriseCreditCode");
			return (Criteria) this;
		}

		public Criteria andEnterpriseCreditCodeGreaterThan(String value) {
			addCriterion("ENTERPRISE_CREDIT_CODE >", value, "enterpriseCreditCode");
			return (Criteria) this;
		}

		public Criteria andEnterpriseCreditCodeGreaterThanOrEqualTo(String value) {
			addCriterion("ENTERPRISE_CREDIT_CODE >=", value, "enterpriseCreditCode");
			return (Criteria) this;
		}

		public Criteria andEnterpriseCreditCodeLessThan(String value) {
			addCriterion("ENTERPRISE_CREDIT_CODE <", value, "enterpriseCreditCode");
			return (Criteria) this;
		}

		public Criteria andEnterpriseCreditCodeLessThanOrEqualTo(String value) {
			addCriterion("ENTERPRISE_CREDIT_CODE <=", value, "enterpriseCreditCode");
			return (Criteria) this;
		}

		public Criteria andEnterpriseCreditCodeLike(String value) {
			addCriterion("ENTERPRISE_CREDIT_CODE like", value, "enterpriseCreditCode");
			return (Criteria) this;
		}

		public Criteria andEnterpriseCreditCodeNotLike(String value) {
			addCriterion("ENTERPRISE_CREDIT_CODE not like", value, "enterpriseCreditCode");
			return (Criteria) this;
		}

		public Criteria andEnterpriseCreditCodeIn(List<String> values) {
			addCriterion("ENTERPRISE_CREDIT_CODE in", values, "enterpriseCreditCode");
			return (Criteria) this;
		}

		public Criteria andEnterpriseCreditCodeNotIn(List<String> values) {
			addCriterion("ENTERPRISE_CREDIT_CODE not in", values, "enterpriseCreditCode");
			return (Criteria) this;
		}

		public Criteria andEnterpriseCreditCodeBetween(String value1, String value2) {
			addCriterion("ENTERPRISE_CREDIT_CODE between", value1, value2, "enterpriseCreditCode");
			return (Criteria) this;
		}

		public Criteria andEnterpriseCreditCodeNotBetween(String value1, String value2) {
			addCriterion("ENTERPRISE_CREDIT_CODE not between", value1, value2, "enterpriseCreditCode");
			return (Criteria) this;
		}

		public Criteria andEnterpriseLegalNameIsNull() {
			addCriterion("ENTERPRISE_LEGAL_NAME is null");
			return (Criteria) this;
		}

		public Criteria andEnterpriseLegalNameIsNotNull() {
			addCriterion("ENTERPRISE_LEGAL_NAME is not null");
			return (Criteria) this;
		}

		public Criteria andEnterpriseLegalNameEqualTo(String value) {
			addCriterion("ENTERPRISE_LEGAL_NAME =", value, "enterpriseLegalName");
			return (Criteria) this;
		}

		public Criteria andEnterpriseLegalNameNotEqualTo(String value) {
			addCriterion("ENTERPRISE_LEGAL_NAME <>", value, "enterpriseLegalName");
			return (Criteria) this;
		}

		public Criteria andEnterpriseLegalNameGreaterThan(String value) {
			addCriterion("ENTERPRISE_LEGAL_NAME >", value, "enterpriseLegalName");
			return (Criteria) this;
		}

		public Criteria andEnterpriseLegalNameGreaterThanOrEqualTo(String value) {
			addCriterion("ENTERPRISE_LEGAL_NAME >=", value, "enterpriseLegalName");
			return (Criteria) this;
		}

		public Criteria andEnterpriseLegalNameLessThan(String value) {
			addCriterion("ENTERPRISE_LEGAL_NAME <", value, "enterpriseLegalName");
			return (Criteria) this;
		}

		public Criteria andEnterpriseLegalNameLessThanOrEqualTo(String value) {
			addCriterion("ENTERPRISE_LEGAL_NAME <=", value, "enterpriseLegalName");
			return (Criteria) this;
		}

		public Criteria andEnterpriseLegalNameLike(String value) {
			addCriterion("ENTERPRISE_LEGAL_NAME like", value, "enterpriseLegalName");
			return (Criteria) this;
		}

		public Criteria andEnterpriseLegalNameNotLike(String value) {
			addCriterion("ENTERPRISE_LEGAL_NAME not like", value, "enterpriseLegalName");
			return (Criteria) this;
		}

		public Criteria andEnterpriseLegalNameIn(List<String> values) {
			addCriterion("ENTERPRISE_LEGAL_NAME in", values, "enterpriseLegalName");
			return (Criteria) this;
		}

		public Criteria andEnterpriseLegalNameNotIn(List<String> values) {
			addCriterion("ENTERPRISE_LEGAL_NAME not in", values, "enterpriseLegalName");
			return (Criteria) this;
		}

		public Criteria andEnterpriseLegalNameBetween(String value1, String value2) {
			addCriterion("ENTERPRISE_LEGAL_NAME between", value1, value2, "enterpriseLegalName");
			return (Criteria) this;
		}

		public Criteria andEnterpriseLegalNameNotBetween(String value1, String value2) {
			addCriterion("ENTERPRISE_LEGAL_NAME not between", value1, value2, "enterpriseLegalName");
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

		public Criteria andPartnerAddrIsNull() {
			addCriterion("PARTNER_ADDR is null");
			return (Criteria) this;
		}

		public Criteria andPartnerAddrIsNotNull() {
			addCriterion("PARTNER_ADDR is not null");
			return (Criteria) this;
		}

		public Criteria andPartnerAddrEqualTo(String value) {
			addCriterion("PARTNER_ADDR =", value, "partnerAddr");
			return (Criteria) this;
		}

		public Criteria andPartnerAddrNotEqualTo(String value) {
			addCriterion("PARTNER_ADDR <>", value, "partnerAddr");
			return (Criteria) this;
		}

		public Criteria andPartnerAddrGreaterThan(String value) {
			addCriterion("PARTNER_ADDR >", value, "partnerAddr");
			return (Criteria) this;
		}

		public Criteria andPartnerAddrGreaterThanOrEqualTo(String value) {
			addCriterion("PARTNER_ADDR >=", value, "partnerAddr");
			return (Criteria) this;
		}

		public Criteria andPartnerAddrLessThan(String value) {
			addCriterion("PARTNER_ADDR <", value, "partnerAddr");
			return (Criteria) this;
		}

		public Criteria andPartnerAddrLessThanOrEqualTo(String value) {
			addCriterion("PARTNER_ADDR <=", value, "partnerAddr");
			return (Criteria) this;
		}

		public Criteria andPartnerAddrLike(String value) {
			addCriterion("PARTNER_ADDR like", value, "partnerAddr");
			return (Criteria) this;
		}

		public Criteria andPartnerAddrNotLike(String value) {
			addCriterion("PARTNER_ADDR not like", value, "partnerAddr");
			return (Criteria) this;
		}

		public Criteria andPartnerAddrIn(List<String> values) {
			addCriterion("PARTNER_ADDR in", values, "partnerAddr");
			return (Criteria) this;
		}

		public Criteria andPartnerAddrNotIn(List<String> values) {
			addCriterion("PARTNER_ADDR not in", values, "partnerAddr");
			return (Criteria) this;
		}

		public Criteria andPartnerAddrBetween(String value1, String value2) {
			addCriterion("PARTNER_ADDR between", value1, value2, "partnerAddr");
			return (Criteria) this;
		}

		public Criteria andPartnerAddrNotBetween(String value1, String value2) {
			addCriterion("PARTNER_ADDR not between", value1, value2, "partnerAddr");
			return (Criteria) this;
		}

		public Criteria andPartnerTeleIsNull() {
			addCriterion("PARTNER_TELE is null");
			return (Criteria) this;
		}

		public Criteria andPartnerTeleIsNotNull() {
			addCriterion("PARTNER_TELE is not null");
			return (Criteria) this;
		}

		public Criteria andPartnerTeleEqualTo(String value) {
			addCriterion("PARTNER_TELE =", value, "partnerTele");
			return (Criteria) this;
		}

		public Criteria andPartnerTeleNotEqualTo(String value) {
			addCriterion("PARTNER_TELE <>", value, "partnerTele");
			return (Criteria) this;
		}

		public Criteria andPartnerTeleGreaterThan(String value) {
			addCriterion("PARTNER_TELE >", value, "partnerTele");
			return (Criteria) this;
		}

		public Criteria andPartnerTeleGreaterThanOrEqualTo(String value) {
			addCriterion("PARTNER_TELE >=", value, "partnerTele");
			return (Criteria) this;
		}

		public Criteria andPartnerTeleLessThan(String value) {
			addCriterion("PARTNER_TELE <", value, "partnerTele");
			return (Criteria) this;
		}

		public Criteria andPartnerTeleLessThanOrEqualTo(String value) {
			addCriterion("PARTNER_TELE <=", value, "partnerTele");
			return (Criteria) this;
		}

		public Criteria andPartnerTeleLike(String value) {
			addCriterion("PARTNER_TELE like", value, "partnerTele");
			return (Criteria) this;
		}

		public Criteria andPartnerTeleNotLike(String value) {
			addCriterion("PARTNER_TELE not like", value, "partnerTele");
			return (Criteria) this;
		}

		public Criteria andPartnerTeleIn(List<String> values) {
			addCriterion("PARTNER_TELE in", values, "partnerTele");
			return (Criteria) this;
		}

		public Criteria andPartnerTeleNotIn(List<String> values) {
			addCriterion("PARTNER_TELE not in", values, "partnerTele");
			return (Criteria) this;
		}

		public Criteria andPartnerTeleBetween(String value1, String value2) {
			addCriterion("PARTNER_TELE between", value1, value2, "partnerTele");
			return (Criteria) this;
		}

		public Criteria andPartnerTeleNotBetween(String value1, String value2) {
			addCriterion("PARTNER_TELE not between", value1, value2, "partnerTele");
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