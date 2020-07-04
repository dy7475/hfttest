package com.myfun.repository.erpdb.po;

import com.myfun.repository.support.generator.shard.ShardDb;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ErpFunPartnerConfigExample extends ShardDb {
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
	public ErpFunPartnerConfigExample() {
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

		public Criteria andHouseDataApartIsNull() {
			addCriterion("HOUSE_DATA_APART is null");
			return (Criteria) this;
		}

		public Criteria andHouseDataApartIsNotNull() {
			addCriterion("HOUSE_DATA_APART is not null");
			return (Criteria) this;
		}

		public Criteria andHouseDataApartEqualTo(Byte value) {
			addCriterion("HOUSE_DATA_APART =", value, "houseDataApart");
			return (Criteria) this;
		}

		public Criteria andHouseDataApartNotEqualTo(Byte value) {
			addCriterion("HOUSE_DATA_APART <>", value, "houseDataApart");
			return (Criteria) this;
		}

		public Criteria andHouseDataApartGreaterThan(Byte value) {
			addCriterion("HOUSE_DATA_APART >", value, "houseDataApart");
			return (Criteria) this;
		}

		public Criteria andHouseDataApartGreaterThanOrEqualTo(Byte value) {
			addCriterion("HOUSE_DATA_APART >=", value, "houseDataApart");
			return (Criteria) this;
		}

		public Criteria andHouseDataApartLessThan(Byte value) {
			addCriterion("HOUSE_DATA_APART <", value, "houseDataApart");
			return (Criteria) this;
		}

		public Criteria andHouseDataApartLessThanOrEqualTo(Byte value) {
			addCriterion("HOUSE_DATA_APART <=", value, "houseDataApart");
			return (Criteria) this;
		}

		public Criteria andHouseDataApartIn(List<Byte> values) {
			addCriterion("HOUSE_DATA_APART in", values, "houseDataApart");
			return (Criteria) this;
		}

		public Criteria andHouseDataApartNotIn(List<Byte> values) {
			addCriterion("HOUSE_DATA_APART not in", values, "houseDataApart");
			return (Criteria) this;
		}

		public Criteria andHouseDataApartBetween(Byte value1, Byte value2) {
			addCriterion("HOUSE_DATA_APART between", value1, value2, "houseDataApart");
			return (Criteria) this;
		}

		public Criteria andHouseDataApartNotBetween(Byte value1, Byte value2) {
			addCriterion("HOUSE_DATA_APART not between", value1, value2, "houseDataApart");
			return (Criteria) this;
		}

		public Criteria andCustDataApartIsNull() {
			addCriterion("CUST_DATA_APART is null");
			return (Criteria) this;
		}

		public Criteria andCustDataApartIsNotNull() {
			addCriterion("CUST_DATA_APART is not null");
			return (Criteria) this;
		}

		public Criteria andCustDataApartEqualTo(Byte value) {
			addCriterion("CUST_DATA_APART =", value, "custDataApart");
			return (Criteria) this;
		}

		public Criteria andCustDataApartNotEqualTo(Byte value) {
			addCriterion("CUST_DATA_APART <>", value, "custDataApart");
			return (Criteria) this;
		}

		public Criteria andCustDataApartGreaterThan(Byte value) {
			addCriterion("CUST_DATA_APART >", value, "custDataApart");
			return (Criteria) this;
		}

		public Criteria andCustDataApartGreaterThanOrEqualTo(Byte value) {
			addCriterion("CUST_DATA_APART >=", value, "custDataApart");
			return (Criteria) this;
		}

		public Criteria andCustDataApartLessThan(Byte value) {
			addCriterion("CUST_DATA_APART <", value, "custDataApart");
			return (Criteria) this;
		}

		public Criteria andCustDataApartLessThanOrEqualTo(Byte value) {
			addCriterion("CUST_DATA_APART <=", value, "custDataApart");
			return (Criteria) this;
		}

		public Criteria andCustDataApartIn(List<Byte> values) {
			addCriterion("CUST_DATA_APART in", values, "custDataApart");
			return (Criteria) this;
		}

		public Criteria andCustDataApartNotIn(List<Byte> values) {
			addCriterion("CUST_DATA_APART not in", values, "custDataApart");
			return (Criteria) this;
		}

		public Criteria andCustDataApartBetween(Byte value1, Byte value2) {
			addCriterion("CUST_DATA_APART between", value1, value2, "custDataApart");
			return (Criteria) this;
		}

		public Criteria andCustDataApartNotBetween(Byte value1, Byte value2) {
			addCriterion("CUST_DATA_APART not between", value1, value2, "custDataApart");
			return (Criteria) this;
		}

		public Criteria andBusinessDataApartIsNull() {
			addCriterion("BUSINESS_DATA_APART is null");
			return (Criteria) this;
		}

		public Criteria andBusinessDataApartIsNotNull() {
			addCriterion("BUSINESS_DATA_APART is not null");
			return (Criteria) this;
		}

		public Criteria andBusinessDataApartEqualTo(Byte value) {
			addCriterion("BUSINESS_DATA_APART =", value, "businessDataApart");
			return (Criteria) this;
		}

		public Criteria andBusinessDataApartNotEqualTo(Byte value) {
			addCriterion("BUSINESS_DATA_APART <>", value, "businessDataApart");
			return (Criteria) this;
		}

		public Criteria andBusinessDataApartGreaterThan(Byte value) {
			addCriterion("BUSINESS_DATA_APART >", value, "businessDataApart");
			return (Criteria) this;
		}

		public Criteria andBusinessDataApartGreaterThanOrEqualTo(Byte value) {
			addCriterion("BUSINESS_DATA_APART >=", value, "businessDataApart");
			return (Criteria) this;
		}

		public Criteria andBusinessDataApartLessThan(Byte value) {
			addCriterion("BUSINESS_DATA_APART <", value, "businessDataApart");
			return (Criteria) this;
		}

		public Criteria andBusinessDataApartLessThanOrEqualTo(Byte value) {
			addCriterion("BUSINESS_DATA_APART <=", value, "businessDataApart");
			return (Criteria) this;
		}

		public Criteria andBusinessDataApartIn(List<Byte> values) {
			addCriterion("BUSINESS_DATA_APART in", values, "businessDataApart");
			return (Criteria) this;
		}

		public Criteria andBusinessDataApartNotIn(List<Byte> values) {
			addCriterion("BUSINESS_DATA_APART not in", values, "businessDataApart");
			return (Criteria) this;
		}

		public Criteria andBusinessDataApartBetween(Byte value1, Byte value2) {
			addCriterion("BUSINESS_DATA_APART between", value1, value2, "businessDataApart");
			return (Criteria) this;
		}

		public Criteria andBusinessDataApartNotBetween(Byte value1, Byte value2) {
			addCriterion("BUSINESS_DATA_APART not between", value1, value2, "businessDataApart");
			return (Criteria) this;
		}

		public Criteria andOrganizationApartIsNull() {
			addCriterion("ORGANIZATION_APART is null");
			return (Criteria) this;
		}

		public Criteria andOrganizationApartIsNotNull() {
			addCriterion("ORGANIZATION_APART is not null");
			return (Criteria) this;
		}

		public Criteria andOrganizationApartEqualTo(Byte value) {
			addCriterion("ORGANIZATION_APART =", value, "organizationApart");
			return (Criteria) this;
		}

		public Criteria andOrganizationApartNotEqualTo(Byte value) {
			addCriterion("ORGANIZATION_APART <>", value, "organizationApart");
			return (Criteria) this;
		}

		public Criteria andOrganizationApartGreaterThan(Byte value) {
			addCriterion("ORGANIZATION_APART >", value, "organizationApart");
			return (Criteria) this;
		}

		public Criteria andOrganizationApartGreaterThanOrEqualTo(Byte value) {
			addCriterion("ORGANIZATION_APART >=", value, "organizationApart");
			return (Criteria) this;
		}

		public Criteria andOrganizationApartLessThan(Byte value) {
			addCriterion("ORGANIZATION_APART <", value, "organizationApart");
			return (Criteria) this;
		}

		public Criteria andOrganizationApartLessThanOrEqualTo(Byte value) {
			addCriterion("ORGANIZATION_APART <=", value, "organizationApart");
			return (Criteria) this;
		}

		public Criteria andOrganizationApartIn(List<Byte> values) {
			addCriterion("ORGANIZATION_APART in", values, "organizationApart");
			return (Criteria) this;
		}

		public Criteria andOrganizationApartNotIn(List<Byte> values) {
			addCriterion("ORGANIZATION_APART not in", values, "organizationApart");
			return (Criteria) this;
		}

		public Criteria andOrganizationApartBetween(Byte value1, Byte value2) {
			addCriterion("ORGANIZATION_APART between", value1, value2, "organizationApart");
			return (Criteria) this;
		}

		public Criteria andOrganizationApartNotBetween(Byte value1, Byte value2) {
			addCriterion("ORGANIZATION_APART not between", value1, value2, "organizationApart");
			return (Criteria) this;
		}

		public Criteria andDealApartIsNull() {
			addCriterion("DEAL_APART is null");
			return (Criteria) this;
		}

		public Criteria andDealApartIsNotNull() {
			addCriterion("DEAL_APART is not null");
			return (Criteria) this;
		}

		public Criteria andDealApartEqualTo(Byte value) {
			addCriterion("DEAL_APART =", value, "dealApart");
			return (Criteria) this;
		}

		public Criteria andDealApartNotEqualTo(Byte value) {
			addCriterion("DEAL_APART <>", value, "dealApart");
			return (Criteria) this;
		}

		public Criteria andDealApartGreaterThan(Byte value) {
			addCriterion("DEAL_APART >", value, "dealApart");
			return (Criteria) this;
		}

		public Criteria andDealApartGreaterThanOrEqualTo(Byte value) {
			addCriterion("DEAL_APART >=", value, "dealApart");
			return (Criteria) this;
		}

		public Criteria andDealApartLessThan(Byte value) {
			addCriterion("DEAL_APART <", value, "dealApart");
			return (Criteria) this;
		}

		public Criteria andDealApartLessThanOrEqualTo(Byte value) {
			addCriterion("DEAL_APART <=", value, "dealApart");
			return (Criteria) this;
		}

		public Criteria andDealApartIn(List<Byte> values) {
			addCriterion("DEAL_APART in", values, "dealApart");
			return (Criteria) this;
		}

		public Criteria andDealApartNotIn(List<Byte> values) {
			addCriterion("DEAL_APART not in", values, "dealApart");
			return (Criteria) this;
		}

		public Criteria andDealApartBetween(Byte value1, Byte value2) {
			addCriterion("DEAL_APART between", value1, value2, "dealApart");
			return (Criteria) this;
		}

		public Criteria andDealApartNotBetween(Byte value1, Byte value2) {
			addCriterion("DEAL_APART not between", value1, value2, "dealApart");
			return (Criteria) this;
		}

		public Criteria andWageApartIsNull() {
			addCriterion("WAGE_APART is null");
			return (Criteria) this;
		}

		public Criteria andWageApartIsNotNull() {
			addCriterion("WAGE_APART is not null");
			return (Criteria) this;
		}

		public Criteria andWageApartEqualTo(Byte value) {
			addCriterion("WAGE_APART =", value, "wageApart");
			return (Criteria) this;
		}

		public Criteria andWageApartNotEqualTo(Byte value) {
			addCriterion("WAGE_APART <>", value, "wageApart");
			return (Criteria) this;
		}

		public Criteria andWageApartGreaterThan(Byte value) {
			addCriterion("WAGE_APART >", value, "wageApart");
			return (Criteria) this;
		}

		public Criteria andWageApartGreaterThanOrEqualTo(Byte value) {
			addCriterion("WAGE_APART >=", value, "wageApart");
			return (Criteria) this;
		}

		public Criteria andWageApartLessThan(Byte value) {
			addCriterion("WAGE_APART <", value, "wageApart");
			return (Criteria) this;
		}

		public Criteria andWageApartLessThanOrEqualTo(Byte value) {
			addCriterion("WAGE_APART <=", value, "wageApart");
			return (Criteria) this;
		}

		public Criteria andWageApartIn(List<Byte> values) {
			addCriterion("WAGE_APART in", values, "wageApart");
			return (Criteria) this;
		}

		public Criteria andWageApartNotIn(List<Byte> values) {
			addCriterion("WAGE_APART not in", values, "wageApart");
			return (Criteria) this;
		}

		public Criteria andWageApartBetween(Byte value1, Byte value2) {
			addCriterion("WAGE_APART between", value1, value2, "wageApart");
			return (Criteria) this;
		}

		public Criteria andWageApartNotBetween(Byte value1, Byte value2) {
			addCriterion("WAGE_APART not between", value1, value2, "wageApart");
			return (Criteria) this;
		}

		public Criteria andAttendanceApartIsNull() {
			addCriterion("ATTENDANCE_APART is null");
			return (Criteria) this;
		}

		public Criteria andAttendanceApartIsNotNull() {
			addCriterion("ATTENDANCE_APART is not null");
			return (Criteria) this;
		}

		public Criteria andAttendanceApartEqualTo(Byte value) {
			addCriterion("ATTENDANCE_APART =", value, "attendanceApart");
			return (Criteria) this;
		}

		public Criteria andAttendanceApartNotEqualTo(Byte value) {
			addCriterion("ATTENDANCE_APART <>", value, "attendanceApart");
			return (Criteria) this;
		}

		public Criteria andAttendanceApartGreaterThan(Byte value) {
			addCriterion("ATTENDANCE_APART >", value, "attendanceApart");
			return (Criteria) this;
		}

		public Criteria andAttendanceApartGreaterThanOrEqualTo(Byte value) {
			addCriterion("ATTENDANCE_APART >=", value, "attendanceApart");
			return (Criteria) this;
		}

		public Criteria andAttendanceApartLessThan(Byte value) {
			addCriterion("ATTENDANCE_APART <", value, "attendanceApart");
			return (Criteria) this;
		}

		public Criteria andAttendanceApartLessThanOrEqualTo(Byte value) {
			addCriterion("ATTENDANCE_APART <=", value, "attendanceApart");
			return (Criteria) this;
		}

		public Criteria andAttendanceApartIn(List<Byte> values) {
			addCriterion("ATTENDANCE_APART in", values, "attendanceApart");
			return (Criteria) this;
		}

		public Criteria andAttendanceApartNotIn(List<Byte> values) {
			addCriterion("ATTENDANCE_APART not in", values, "attendanceApart");
			return (Criteria) this;
		}

		public Criteria andAttendanceApartBetween(Byte value1, Byte value2) {
			addCriterion("ATTENDANCE_APART between", value1, value2, "attendanceApart");
			return (Criteria) this;
		}

		public Criteria andAttendanceApartNotBetween(Byte value1, Byte value2) {
			addCriterion("ATTENDANCE_APART not between", value1, value2, "attendanceApart");
			return (Criteria) this;
		}

		public Criteria andImplicitCallApartIsNull() {
			addCriterion("IMPLICIT_CALL_APART is null");
			return (Criteria) this;
		}

		public Criteria andImplicitCallApartIsNotNull() {
			addCriterion("IMPLICIT_CALL_APART is not null");
			return (Criteria) this;
		}

		public Criteria andImplicitCallApartEqualTo(Byte value) {
			addCriterion("IMPLICIT_CALL_APART =", value, "implicitCallApart");
			return (Criteria) this;
		}

		public Criteria andImplicitCallApartNotEqualTo(Byte value) {
			addCriterion("IMPLICIT_CALL_APART <>", value, "implicitCallApart");
			return (Criteria) this;
		}

		public Criteria andImplicitCallApartGreaterThan(Byte value) {
			addCriterion("IMPLICIT_CALL_APART >", value, "implicitCallApart");
			return (Criteria) this;
		}

		public Criteria andImplicitCallApartGreaterThanOrEqualTo(Byte value) {
			addCriterion("IMPLICIT_CALL_APART >=", value, "implicitCallApart");
			return (Criteria) this;
		}

		public Criteria andImplicitCallApartLessThan(Byte value) {
			addCriterion("IMPLICIT_CALL_APART <", value, "implicitCallApart");
			return (Criteria) this;
		}

		public Criteria andImplicitCallApartLessThanOrEqualTo(Byte value) {
			addCriterion("IMPLICIT_CALL_APART <=", value, "implicitCallApart");
			return (Criteria) this;
		}

		public Criteria andImplicitCallApartIn(List<Byte> values) {
			addCriterion("IMPLICIT_CALL_APART in", values, "implicitCallApart");
			return (Criteria) this;
		}

		public Criteria andImplicitCallApartNotIn(List<Byte> values) {
			addCriterion("IMPLICIT_CALL_APART not in", values, "implicitCallApart");
			return (Criteria) this;
		}

		public Criteria andImplicitCallApartBetween(Byte value1, Byte value2) {
			addCriterion("IMPLICIT_CALL_APART between", value1, value2, "implicitCallApart");
			return (Criteria) this;
		}

		public Criteria andImplicitCallApartNotBetween(Byte value1, Byte value2) {
			addCriterion("IMPLICIT_CALL_APART not between", value1, value2, "implicitCallApart");
			return (Criteria) this;
		}

		public Criteria andTransPlateRuleApartIsNull() {
			addCriterion("TRANS_PLATE_RULE_APART is null");
			return (Criteria) this;
		}

		public Criteria andTransPlateRuleApartIsNotNull() {
			addCriterion("TRANS_PLATE_RULE_APART is not null");
			return (Criteria) this;
		}

		public Criteria andTransPlateRuleApartEqualTo(Byte value) {
			addCriterion("TRANS_PLATE_RULE_APART =", value, "transPlateRuleApart");
			return (Criteria) this;
		}

		public Criteria andTransPlateRuleApartNotEqualTo(Byte value) {
			addCriterion("TRANS_PLATE_RULE_APART <>", value, "transPlateRuleApart");
			return (Criteria) this;
		}

		public Criteria andTransPlateRuleApartGreaterThan(Byte value) {
			addCriterion("TRANS_PLATE_RULE_APART >", value, "transPlateRuleApart");
			return (Criteria) this;
		}

		public Criteria andTransPlateRuleApartGreaterThanOrEqualTo(Byte value) {
			addCriterion("TRANS_PLATE_RULE_APART >=", value, "transPlateRuleApart");
			return (Criteria) this;
		}

		public Criteria andTransPlateRuleApartLessThan(Byte value) {
			addCriterion("TRANS_PLATE_RULE_APART <", value, "transPlateRuleApart");
			return (Criteria) this;
		}

		public Criteria andTransPlateRuleApartLessThanOrEqualTo(Byte value) {
			addCriterion("TRANS_PLATE_RULE_APART <=", value, "transPlateRuleApart");
			return (Criteria) this;
		}

		public Criteria andTransPlateRuleApartIn(List<Byte> values) {
			addCriterion("TRANS_PLATE_RULE_APART in", values, "transPlateRuleApart");
			return (Criteria) this;
		}

		public Criteria andTransPlateRuleApartNotIn(List<Byte> values) {
			addCriterion("TRANS_PLATE_RULE_APART not in", values, "transPlateRuleApart");
			return (Criteria) this;
		}

		public Criteria andTransPlateRuleApartBetween(Byte value1, Byte value2) {
			addCriterion("TRANS_PLATE_RULE_APART between", value1, value2, "transPlateRuleApart");
			return (Criteria) this;
		}

		public Criteria andTransPlateRuleApartNotBetween(Byte value1, Byte value2) {
			addCriterion("TRANS_PLATE_RULE_APART not between", value1, value2, "transPlateRuleApart");
			return (Criteria) this;
		}

		public Criteria andPlateRangeApartIsNull() {
			addCriterion("PLATE_RANGE_APART is null");
			return (Criteria) this;
		}

		public Criteria andPlateRangeApartIsNotNull() {
			addCriterion("PLATE_RANGE_APART is not null");
			return (Criteria) this;
		}

		public Criteria andPlateRangeApartEqualTo(Byte value) {
			addCriterion("PLATE_RANGE_APART =", value, "plateRangeApart");
			return (Criteria) this;
		}

		public Criteria andPlateRangeApartNotEqualTo(Byte value) {
			addCriterion("PLATE_RANGE_APART <>", value, "plateRangeApart");
			return (Criteria) this;
		}

		public Criteria andPlateRangeApartGreaterThan(Byte value) {
			addCriterion("PLATE_RANGE_APART >", value, "plateRangeApart");
			return (Criteria) this;
		}

		public Criteria andPlateRangeApartGreaterThanOrEqualTo(Byte value) {
			addCriterion("PLATE_RANGE_APART >=", value, "plateRangeApart");
			return (Criteria) this;
		}

		public Criteria andPlateRangeApartLessThan(Byte value) {
			addCriterion("PLATE_RANGE_APART <", value, "plateRangeApart");
			return (Criteria) this;
		}

		public Criteria andPlateRangeApartLessThanOrEqualTo(Byte value) {
			addCriterion("PLATE_RANGE_APART <=", value, "plateRangeApart");
			return (Criteria) this;
		}

		public Criteria andPlateRangeApartIn(List<Byte> values) {
			addCriterion("PLATE_RANGE_APART in", values, "plateRangeApart");
			return (Criteria) this;
		}

		public Criteria andPlateRangeApartNotIn(List<Byte> values) {
			addCriterion("PLATE_RANGE_APART not in", values, "plateRangeApart");
			return (Criteria) this;
		}

		public Criteria andPlateRangeApartBetween(Byte value1, Byte value2) {
			addCriterion("PLATE_RANGE_APART between", value1, value2, "plateRangeApart");
			return (Criteria) this;
		}

		public Criteria andPlateRangeApartNotBetween(Byte value1, Byte value2) {
			addCriterion("PLATE_RANGE_APART not between", value1, value2, "plateRangeApart");
			return (Criteria) this;
		}

		public Criteria andCoreInfoApartIsNull() {
			addCriterion("CORE_INFO_APART is null");
			return (Criteria) this;
		}

		public Criteria andCoreInfoApartIsNotNull() {
			addCriterion("CORE_INFO_APART is not null");
			return (Criteria) this;
		}

		public Criteria andCoreInfoApartEqualTo(Byte value) {
			addCriterion("CORE_INFO_APART =", value, "coreInfoApart");
			return (Criteria) this;
		}

		public Criteria andCoreInfoApartNotEqualTo(Byte value) {
			addCriterion("CORE_INFO_APART <>", value, "coreInfoApart");
			return (Criteria) this;
		}

		public Criteria andCoreInfoApartGreaterThan(Byte value) {
			addCriterion("CORE_INFO_APART >", value, "coreInfoApart");
			return (Criteria) this;
		}

		public Criteria andCoreInfoApartGreaterThanOrEqualTo(Byte value) {
			addCriterion("CORE_INFO_APART >=", value, "coreInfoApart");
			return (Criteria) this;
		}

		public Criteria andCoreInfoApartLessThan(Byte value) {
			addCriterion("CORE_INFO_APART <", value, "coreInfoApart");
			return (Criteria) this;
		}

		public Criteria andCoreInfoApartLessThanOrEqualTo(Byte value) {
			addCriterion("CORE_INFO_APART <=", value, "coreInfoApart");
			return (Criteria) this;
		}

		public Criteria andCoreInfoApartIn(List<Byte> values) {
			addCriterion("CORE_INFO_APART in", values, "coreInfoApart");
			return (Criteria) this;
		}

		public Criteria andCoreInfoApartNotIn(List<Byte> values) {
			addCriterion("CORE_INFO_APART not in", values, "coreInfoApart");
			return (Criteria) this;
		}

		public Criteria andCoreInfoApartBetween(Byte value1, Byte value2) {
			addCriterion("CORE_INFO_APART between", value1, value2, "coreInfoApart");
			return (Criteria) this;
		}

		public Criteria andCoreInfoApartNotBetween(Byte value1, Byte value2) {
			addCriterion("CORE_INFO_APART not between", value1, value2, "coreInfoApart");
			return (Criteria) this;
		}

		public Criteria andStrategyParamApartIsNull() {
			addCriterion("STRATEGY_PARAM_APART is null");
			return (Criteria) this;
		}

		public Criteria andStrategyParamApartIsNotNull() {
			addCriterion("STRATEGY_PARAM_APART is not null");
			return (Criteria) this;
		}

		public Criteria andStrategyParamApartEqualTo(Byte value) {
			addCriterion("STRATEGY_PARAM_APART =", value, "strategyParamApart");
			return (Criteria) this;
		}

		public Criteria andStrategyParamApartNotEqualTo(Byte value) {
			addCriterion("STRATEGY_PARAM_APART <>", value, "strategyParamApart");
			return (Criteria) this;
		}

		public Criteria andStrategyParamApartGreaterThan(Byte value) {
			addCriterion("STRATEGY_PARAM_APART >", value, "strategyParamApart");
			return (Criteria) this;
		}

		public Criteria andStrategyParamApartGreaterThanOrEqualTo(Byte value) {
			addCriterion("STRATEGY_PARAM_APART >=", value, "strategyParamApart");
			return (Criteria) this;
		}

		public Criteria andStrategyParamApartLessThan(Byte value) {
			addCriterion("STRATEGY_PARAM_APART <", value, "strategyParamApart");
			return (Criteria) this;
		}

		public Criteria andStrategyParamApartLessThanOrEqualTo(Byte value) {
			addCriterion("STRATEGY_PARAM_APART <=", value, "strategyParamApart");
			return (Criteria) this;
		}

		public Criteria andStrategyParamApartIn(List<Byte> values) {
			addCriterion("STRATEGY_PARAM_APART in", values, "strategyParamApart");
			return (Criteria) this;
		}

		public Criteria andStrategyParamApartNotIn(List<Byte> values) {
			addCriterion("STRATEGY_PARAM_APART not in", values, "strategyParamApart");
			return (Criteria) this;
		}

		public Criteria andStrategyParamApartBetween(Byte value1, Byte value2) {
			addCriterion("STRATEGY_PARAM_APART between", value1, value2, "strategyParamApart");
			return (Criteria) this;
		}

		public Criteria andStrategyParamApartNotBetween(Byte value1, Byte value2) {
			addCriterion("STRATEGY_PARAM_APART not between", value1, value2, "strategyParamApart");
			return (Criteria) this;
		}

		public Criteria andDealConfigApartIsNull() {
			addCriterion("DEAL_CONFIG_APART is null");
			return (Criteria) this;
		}

		public Criteria andDealConfigApartIsNotNull() {
			addCriterion("DEAL_CONFIG_APART is not null");
			return (Criteria) this;
		}

		public Criteria andDealConfigApartEqualTo(Byte value) {
			addCriterion("DEAL_CONFIG_APART =", value, "dealConfigApart");
			return (Criteria) this;
		}

		public Criteria andDealConfigApartNotEqualTo(Byte value) {
			addCriterion("DEAL_CONFIG_APART <>", value, "dealConfigApart");
			return (Criteria) this;
		}

		public Criteria andDealConfigApartGreaterThan(Byte value) {
			addCriterion("DEAL_CONFIG_APART >", value, "dealConfigApart");
			return (Criteria) this;
		}

		public Criteria andDealConfigApartGreaterThanOrEqualTo(Byte value) {
			addCriterion("DEAL_CONFIG_APART >=", value, "dealConfigApart");
			return (Criteria) this;
		}

		public Criteria andDealConfigApartLessThan(Byte value) {
			addCriterion("DEAL_CONFIG_APART <", value, "dealConfigApart");
			return (Criteria) this;
		}

		public Criteria andDealConfigApartLessThanOrEqualTo(Byte value) {
			addCriterion("DEAL_CONFIG_APART <=", value, "dealConfigApart");
			return (Criteria) this;
		}

		public Criteria andDealConfigApartIn(List<Byte> values) {
			addCriterion("DEAL_CONFIG_APART in", values, "dealConfigApart");
			return (Criteria) this;
		}

		public Criteria andDealConfigApartNotIn(List<Byte> values) {
			addCriterion("DEAL_CONFIG_APART not in", values, "dealConfigApart");
			return (Criteria) this;
		}

		public Criteria andDealConfigApartBetween(Byte value1, Byte value2) {
			addCriterion("DEAL_CONFIG_APART between", value1, value2, "dealConfigApart");
			return (Criteria) this;
		}

		public Criteria andDealConfigApartNotBetween(Byte value1, Byte value2) {
			addCriterion("DEAL_CONFIG_APART not between", value1, value2, "dealConfigApart");
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

		public Criteria andCurrentMonthIsNull() {
			addCriterion("CURRENT_MONTH is null");
			return (Criteria) this;
		}

		public Criteria andCurrentMonthIsNotNull() {
			addCriterion("CURRENT_MONTH is not null");
			return (Criteria) this;
		}

		public Criteria andCurrentMonthEqualTo(Date value) {
			addCriterion("CURRENT_MONTH =", value, "currentMonth");
			return (Criteria) this;
		}

		public Criteria andCurrentMonthNotEqualTo(Date value) {
			addCriterion("CURRENT_MONTH <>", value, "currentMonth");
			return (Criteria) this;
		}

		public Criteria andCurrentMonthGreaterThan(Date value) {
			addCriterion("CURRENT_MONTH >", value, "currentMonth");
			return (Criteria) this;
		}

		public Criteria andCurrentMonthGreaterThanOrEqualTo(Date value) {
			addCriterion("CURRENT_MONTH >=", value, "currentMonth");
			return (Criteria) this;
		}

		public Criteria andCurrentMonthLessThan(Date value) {
			addCriterion("CURRENT_MONTH <", value, "currentMonth");
			return (Criteria) this;
		}

		public Criteria andCurrentMonthLessThanOrEqualTo(Date value) {
			addCriterion("CURRENT_MONTH <=", value, "currentMonth");
			return (Criteria) this;
		}

		public Criteria andCurrentMonthIn(List<Date> values) {
			addCriterion("CURRENT_MONTH in", values, "currentMonth");
			return (Criteria) this;
		}

		public Criteria andCurrentMonthNotIn(List<Date> values) {
			addCriterion("CURRENT_MONTH not in", values, "currentMonth");
			return (Criteria) this;
		}

		public Criteria andCurrentMonthBetween(Date value1, Date value2) {
			addCriterion("CURRENT_MONTH between", value1, value2, "currentMonth");
			return (Criteria) this;
		}

		public Criteria andCurrentMonthNotBetween(Date value1, Date value2) {
			addCriterion("CURRENT_MONTH not between", value1, value2, "currentMonth");
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