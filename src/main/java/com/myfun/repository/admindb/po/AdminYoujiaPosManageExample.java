package com.myfun.repository.admindb.po;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AdminYoujiaPosManageExample {
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
	public AdminYoujiaPosManageExample() {
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

		public Criteria andProvinceIdIsNull() {
			addCriterion("PROVINCE_ID is null");
			return (Criteria) this;
		}

		public Criteria andProvinceIdIsNotNull() {
			addCriterion("PROVINCE_ID is not null");
			return (Criteria) this;
		}

		public Criteria andProvinceIdEqualTo(Integer value) {
			addCriterion("PROVINCE_ID =", value, "provinceId");
			return (Criteria) this;
		}

		public Criteria andProvinceIdNotEqualTo(Integer value) {
			addCriterion("PROVINCE_ID <>", value, "provinceId");
			return (Criteria) this;
		}

		public Criteria andProvinceIdGreaterThan(Integer value) {
			addCriterion("PROVINCE_ID >", value, "provinceId");
			return (Criteria) this;
		}

		public Criteria andProvinceIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("PROVINCE_ID >=", value, "provinceId");
			return (Criteria) this;
		}

		public Criteria andProvinceIdLessThan(Integer value) {
			addCriterion("PROVINCE_ID <", value, "provinceId");
			return (Criteria) this;
		}

		public Criteria andProvinceIdLessThanOrEqualTo(Integer value) {
			addCriterion("PROVINCE_ID <=", value, "provinceId");
			return (Criteria) this;
		}

		public Criteria andProvinceIdIn(List<Integer> values) {
			addCriterion("PROVINCE_ID in", values, "provinceId");
			return (Criteria) this;
		}

		public Criteria andProvinceIdNotIn(List<Integer> values) {
			addCriterion("PROVINCE_ID not in", values, "provinceId");
			return (Criteria) this;
		}

		public Criteria andProvinceIdBetween(Integer value1, Integer value2) {
			addCriterion("PROVINCE_ID between", value1, value2, "provinceId");
			return (Criteria) this;
		}

		public Criteria andProvinceIdNotBetween(Integer value1, Integer value2) {
			addCriterion("PROVINCE_ID not between", value1, value2, "provinceId");
			return (Criteria) this;
		}

		public Criteria andCityIdIsNull() {
			addCriterion("CITY_ID is null");
			return (Criteria) this;
		}

		public Criteria andCityIdIsNotNull() {
			addCriterion("CITY_ID is not null");
			return (Criteria) this;
		}

		public Criteria andCityIdEqualTo(Integer value) {
			addCriterion("CITY_ID =", value, "cityId");
			return (Criteria) this;
		}

		public Criteria andCityIdNotEqualTo(Integer value) {
			addCriterion("CITY_ID <>", value, "cityId");
			return (Criteria) this;
		}

		public Criteria andCityIdGreaterThan(Integer value) {
			addCriterion("CITY_ID >", value, "cityId");
			return (Criteria) this;
		}

		public Criteria andCityIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("CITY_ID >=", value, "cityId");
			return (Criteria) this;
		}

		public Criteria andCityIdLessThan(Integer value) {
			addCriterion("CITY_ID <", value, "cityId");
			return (Criteria) this;
		}

		public Criteria andCityIdLessThanOrEqualTo(Integer value) {
			addCriterion("CITY_ID <=", value, "cityId");
			return (Criteria) this;
		}

		public Criteria andCityIdIn(List<Integer> values) {
			addCriterion("CITY_ID in", values, "cityId");
			return (Criteria) this;
		}

		public Criteria andCityIdNotIn(List<Integer> values) {
			addCriterion("CITY_ID not in", values, "cityId");
			return (Criteria) this;
		}

		public Criteria andCityIdBetween(Integer value1, Integer value2) {
			addCriterion("CITY_ID between", value1, value2, "cityId");
			return (Criteria) this;
		}

		public Criteria andCityIdNotBetween(Integer value1, Integer value2) {
			addCriterion("CITY_ID not between", value1, value2, "cityId");
			return (Criteria) this;
		}

		public Criteria andCompNoIsNull() {
			addCriterion("COMP_NO is null");
			return (Criteria) this;
		}

		public Criteria andCompNoIsNotNull() {
			addCriterion("COMP_NO is not null");
			return (Criteria) this;
		}

		public Criteria andCompNoEqualTo(String value) {
			addCriterion("COMP_NO =", value, "compNo");
			return (Criteria) this;
		}

		public Criteria andCompNoNotEqualTo(String value) {
			addCriterion("COMP_NO <>", value, "compNo");
			return (Criteria) this;
		}

		public Criteria andCompNoGreaterThan(String value) {
			addCriterion("COMP_NO >", value, "compNo");
			return (Criteria) this;
		}

		public Criteria andCompNoGreaterThanOrEqualTo(String value) {
			addCriterion("COMP_NO >=", value, "compNo");
			return (Criteria) this;
		}

		public Criteria andCompNoLessThan(String value) {
			addCriterion("COMP_NO <", value, "compNo");
			return (Criteria) this;
		}

		public Criteria andCompNoLessThanOrEqualTo(String value) {
			addCriterion("COMP_NO <=", value, "compNo");
			return (Criteria) this;
		}

		public Criteria andCompNoLike(String value) {
			addCriterion("COMP_NO like", value, "compNo");
			return (Criteria) this;
		}

		public Criteria andCompNoNotLike(String value) {
			addCriterion("COMP_NO not like", value, "compNo");
			return (Criteria) this;
		}

		public Criteria andCompNoIn(List<String> values) {
			addCriterion("COMP_NO in", values, "compNo");
			return (Criteria) this;
		}

		public Criteria andCompNoNotIn(List<String> values) {
			addCriterion("COMP_NO not in", values, "compNo");
			return (Criteria) this;
		}

		public Criteria andCompNoBetween(String value1, String value2) {
			addCriterion("COMP_NO between", value1, value2, "compNo");
			return (Criteria) this;
		}

		public Criteria andCompNoNotBetween(String value1, String value2) {
			addCriterion("COMP_NO not between", value1, value2, "compNo");
			return (Criteria) this;
		}

		public Criteria andDeptNoIsNull() {
			addCriterion("DEPT_NO is null");
			return (Criteria) this;
		}

		public Criteria andDeptNoIsNotNull() {
			addCriterion("DEPT_NO is not null");
			return (Criteria) this;
		}

		public Criteria andDeptNoEqualTo(String value) {
			addCriterion("DEPT_NO =", value, "deptNo");
			return (Criteria) this;
		}

		public Criteria andDeptNoNotEqualTo(String value) {
			addCriterion("DEPT_NO <>", value, "deptNo");
			return (Criteria) this;
		}

		public Criteria andDeptNoGreaterThan(String value) {
			addCriterion("DEPT_NO >", value, "deptNo");
			return (Criteria) this;
		}

		public Criteria andDeptNoGreaterThanOrEqualTo(String value) {
			addCriterion("DEPT_NO >=", value, "deptNo");
			return (Criteria) this;
		}

		public Criteria andDeptNoLessThan(String value) {
			addCriterion("DEPT_NO <", value, "deptNo");
			return (Criteria) this;
		}

		public Criteria andDeptNoLessThanOrEqualTo(String value) {
			addCriterion("DEPT_NO <=", value, "deptNo");
			return (Criteria) this;
		}

		public Criteria andDeptNoLike(String value) {
			addCriterion("DEPT_NO like", value, "deptNo");
			return (Criteria) this;
		}

		public Criteria andDeptNoNotLike(String value) {
			addCriterion("DEPT_NO not like", value, "deptNo");
			return (Criteria) this;
		}

		public Criteria andDeptNoIn(List<String> values) {
			addCriterion("DEPT_NO in", values, "deptNo");
			return (Criteria) this;
		}

		public Criteria andDeptNoNotIn(List<String> values) {
			addCriterion("DEPT_NO not in", values, "deptNo");
			return (Criteria) this;
		}

		public Criteria andDeptNoBetween(String value1, String value2) {
			addCriterion("DEPT_NO between", value1, value2, "deptNo");
			return (Criteria) this;
		}

		public Criteria andDeptNoNotBetween(String value1, String value2) {
			addCriterion("DEPT_NO not between", value1, value2, "deptNo");
			return (Criteria) this;
		}

		public Criteria andAdminCompIdIsNull() {
			addCriterion("ADMIN_COMP_ID is null");
			return (Criteria) this;
		}

		public Criteria andAdminCompIdIsNotNull() {
			addCriterion("ADMIN_COMP_ID is not null");
			return (Criteria) this;
		}

		public Criteria andAdminCompIdEqualTo(Integer value) {
			addCriterion("ADMIN_COMP_ID =", value, "adminCompId");
			return (Criteria) this;
		}

		public Criteria andAdminCompIdNotEqualTo(Integer value) {
			addCriterion("ADMIN_COMP_ID <>", value, "adminCompId");
			return (Criteria) this;
		}

		public Criteria andAdminCompIdGreaterThan(Integer value) {
			addCriterion("ADMIN_COMP_ID >", value, "adminCompId");
			return (Criteria) this;
		}

		public Criteria andAdminCompIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("ADMIN_COMP_ID >=", value, "adminCompId");
			return (Criteria) this;
		}

		public Criteria andAdminCompIdLessThan(Integer value) {
			addCriterion("ADMIN_COMP_ID <", value, "adminCompId");
			return (Criteria) this;
		}

		public Criteria andAdminCompIdLessThanOrEqualTo(Integer value) {
			addCriterion("ADMIN_COMP_ID <=", value, "adminCompId");
			return (Criteria) this;
		}

		public Criteria andAdminCompIdIn(List<Integer> values) {
			addCriterion("ADMIN_COMP_ID in", values, "adminCompId");
			return (Criteria) this;
		}

		public Criteria andAdminCompIdNotIn(List<Integer> values) {
			addCriterion("ADMIN_COMP_ID not in", values, "adminCompId");
			return (Criteria) this;
		}

		public Criteria andAdminCompIdBetween(Integer value1, Integer value2) {
			addCriterion("ADMIN_COMP_ID between", value1, value2, "adminCompId");
			return (Criteria) this;
		}

		public Criteria andAdminCompIdNotBetween(Integer value1, Integer value2) {
			addCriterion("ADMIN_COMP_ID not between", value1, value2, "adminCompId");
			return (Criteria) this;
		}

		public Criteria andAdminDeptIdIsNull() {
			addCriterion("ADMIN_DEPT_ID is null");
			return (Criteria) this;
		}

		public Criteria andAdminDeptIdIsNotNull() {
			addCriterion("ADMIN_DEPT_ID is not null");
			return (Criteria) this;
		}

		public Criteria andAdminDeptIdEqualTo(Integer value) {
			addCriterion("ADMIN_DEPT_ID =", value, "adminDeptId");
			return (Criteria) this;
		}

		public Criteria andAdminDeptIdNotEqualTo(Integer value) {
			addCriterion("ADMIN_DEPT_ID <>", value, "adminDeptId");
			return (Criteria) this;
		}

		public Criteria andAdminDeptIdGreaterThan(Integer value) {
			addCriterion("ADMIN_DEPT_ID >", value, "adminDeptId");
			return (Criteria) this;
		}

		public Criteria andAdminDeptIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("ADMIN_DEPT_ID >=", value, "adminDeptId");
			return (Criteria) this;
		}

		public Criteria andAdminDeptIdLessThan(Integer value) {
			addCriterion("ADMIN_DEPT_ID <", value, "adminDeptId");
			return (Criteria) this;
		}

		public Criteria andAdminDeptIdLessThanOrEqualTo(Integer value) {
			addCriterion("ADMIN_DEPT_ID <=", value, "adminDeptId");
			return (Criteria) this;
		}

		public Criteria andAdminDeptIdIn(List<Integer> values) {
			addCriterion("ADMIN_DEPT_ID in", values, "adminDeptId");
			return (Criteria) this;
		}

		public Criteria andAdminDeptIdNotIn(List<Integer> values) {
			addCriterion("ADMIN_DEPT_ID not in", values, "adminDeptId");
			return (Criteria) this;
		}

		public Criteria andAdminDeptIdBetween(Integer value1, Integer value2) {
			addCriterion("ADMIN_DEPT_ID between", value1, value2, "adminDeptId");
			return (Criteria) this;
		}

		public Criteria andAdminDeptIdNotBetween(Integer value1, Integer value2) {
			addCriterion("ADMIN_DEPT_ID not between", value1, value2, "adminDeptId");
			return (Criteria) this;
		}

		public Criteria andDeptNameIsNull() {
			addCriterion("DEPT_NAME is null");
			return (Criteria) this;
		}

		public Criteria andDeptNameIsNotNull() {
			addCriterion("DEPT_NAME is not null");
			return (Criteria) this;
		}

		public Criteria andDeptNameEqualTo(String value) {
			addCriterion("DEPT_NAME =", value, "deptName");
			return (Criteria) this;
		}

		public Criteria andDeptNameNotEqualTo(String value) {
			addCriterion("DEPT_NAME <>", value, "deptName");
			return (Criteria) this;
		}

		public Criteria andDeptNameGreaterThan(String value) {
			addCriterion("DEPT_NAME >", value, "deptName");
			return (Criteria) this;
		}

		public Criteria andDeptNameGreaterThanOrEqualTo(String value) {
			addCriterion("DEPT_NAME >=", value, "deptName");
			return (Criteria) this;
		}

		public Criteria andDeptNameLessThan(String value) {
			addCriterion("DEPT_NAME <", value, "deptName");
			return (Criteria) this;
		}

		public Criteria andDeptNameLessThanOrEqualTo(String value) {
			addCriterion("DEPT_NAME <=", value, "deptName");
			return (Criteria) this;
		}

		public Criteria andDeptNameLike(String value) {
			addCriterion("DEPT_NAME like", value, "deptName");
			return (Criteria) this;
		}

		public Criteria andDeptNameNotLike(String value) {
			addCriterion("DEPT_NAME not like", value, "deptName");
			return (Criteria) this;
		}

		public Criteria andDeptNameIn(List<String> values) {
			addCriterion("DEPT_NAME in", values, "deptName");
			return (Criteria) this;
		}

		public Criteria andDeptNameNotIn(List<String> values) {
			addCriterion("DEPT_NAME not in", values, "deptName");
			return (Criteria) this;
		}

		public Criteria andDeptNameBetween(String value1, String value2) {
			addCriterion("DEPT_NAME between", value1, value2, "deptName");
			return (Criteria) this;
		}

		public Criteria andDeptNameNotBetween(String value1, String value2) {
			addCriterion("DEPT_NAME not between", value1, value2, "deptName");
			return (Criteria) this;
		}

		public Criteria andDeptContactIsNull() {
			addCriterion("DEPT_CONTACT is null");
			return (Criteria) this;
		}

		public Criteria andDeptContactIsNotNull() {
			addCriterion("DEPT_CONTACT is not null");
			return (Criteria) this;
		}

		public Criteria andDeptContactEqualTo(String value) {
			addCriterion("DEPT_CONTACT =", value, "deptContact");
			return (Criteria) this;
		}

		public Criteria andDeptContactNotEqualTo(String value) {
			addCriterion("DEPT_CONTACT <>", value, "deptContact");
			return (Criteria) this;
		}

		public Criteria andDeptContactGreaterThan(String value) {
			addCriterion("DEPT_CONTACT >", value, "deptContact");
			return (Criteria) this;
		}

		public Criteria andDeptContactGreaterThanOrEqualTo(String value) {
			addCriterion("DEPT_CONTACT >=", value, "deptContact");
			return (Criteria) this;
		}

		public Criteria andDeptContactLessThan(String value) {
			addCriterion("DEPT_CONTACT <", value, "deptContact");
			return (Criteria) this;
		}

		public Criteria andDeptContactLessThanOrEqualTo(String value) {
			addCriterion("DEPT_CONTACT <=", value, "deptContact");
			return (Criteria) this;
		}

		public Criteria andDeptContactLike(String value) {
			addCriterion("DEPT_CONTACT like", value, "deptContact");
			return (Criteria) this;
		}

		public Criteria andDeptContactNotLike(String value) {
			addCriterion("DEPT_CONTACT not like", value, "deptContact");
			return (Criteria) this;
		}

		public Criteria andDeptContactIn(List<String> values) {
			addCriterion("DEPT_CONTACT in", values, "deptContact");
			return (Criteria) this;
		}

		public Criteria andDeptContactNotIn(List<String> values) {
			addCriterion("DEPT_CONTACT not in", values, "deptContact");
			return (Criteria) this;
		}

		public Criteria andDeptContactBetween(String value1, String value2) {
			addCriterion("DEPT_CONTACT between", value1, value2, "deptContact");
			return (Criteria) this;
		}

		public Criteria andDeptContactNotBetween(String value1, String value2) {
			addCriterion("DEPT_CONTACT not between", value1, value2, "deptContact");
			return (Criteria) this;
		}

		public Criteria andContactPhoneIsNull() {
			addCriterion("CONTACT_PHONE is null");
			return (Criteria) this;
		}

		public Criteria andContactPhoneIsNotNull() {
			addCriterion("CONTACT_PHONE is not null");
			return (Criteria) this;
		}

		public Criteria andContactPhoneEqualTo(String value) {
			addCriterion("CONTACT_PHONE =", value, "contactPhone");
			return (Criteria) this;
		}

		public Criteria andContactPhoneNotEqualTo(String value) {
			addCriterion("CONTACT_PHONE <>", value, "contactPhone");
			return (Criteria) this;
		}

		public Criteria andContactPhoneGreaterThan(String value) {
			addCriterion("CONTACT_PHONE >", value, "contactPhone");
			return (Criteria) this;
		}

		public Criteria andContactPhoneGreaterThanOrEqualTo(String value) {
			addCriterion("CONTACT_PHONE >=", value, "contactPhone");
			return (Criteria) this;
		}

		public Criteria andContactPhoneLessThan(String value) {
			addCriterion("CONTACT_PHONE <", value, "contactPhone");
			return (Criteria) this;
		}

		public Criteria andContactPhoneLessThanOrEqualTo(String value) {
			addCriterion("CONTACT_PHONE <=", value, "contactPhone");
			return (Criteria) this;
		}

		public Criteria andContactPhoneLike(String value) {
			addCriterion("CONTACT_PHONE like", value, "contactPhone");
			return (Criteria) this;
		}

		public Criteria andContactPhoneNotLike(String value) {
			addCriterion("CONTACT_PHONE not like", value, "contactPhone");
			return (Criteria) this;
		}

		public Criteria andContactPhoneIn(List<String> values) {
			addCriterion("CONTACT_PHONE in", values, "contactPhone");
			return (Criteria) this;
		}

		public Criteria andContactPhoneNotIn(List<String> values) {
			addCriterion("CONTACT_PHONE not in", values, "contactPhone");
			return (Criteria) this;
		}

		public Criteria andContactPhoneBetween(String value1, String value2) {
			addCriterion("CONTACT_PHONE between", value1, value2, "contactPhone");
			return (Criteria) this;
		}

		public Criteria andContactPhoneNotBetween(String value1, String value2) {
			addCriterion("CONTACT_PHONE not between", value1, value2, "contactPhone");
			return (Criteria) this;
		}

		public Criteria andYunxinIdIsNull() {
			addCriterion("YUNXIN_ID is null");
			return (Criteria) this;
		}

		public Criteria andYunxinIdIsNotNull() {
			addCriterion("YUNXIN_ID is not null");
			return (Criteria) this;
		}

		public Criteria andYunxinIdEqualTo(String value) {
			addCriterion("YUNXIN_ID =", value, "yunxinId");
			return (Criteria) this;
		}

		public Criteria andYunxinIdNotEqualTo(String value) {
			addCriterion("YUNXIN_ID <>", value, "yunxinId");
			return (Criteria) this;
		}

		public Criteria andYunxinIdGreaterThan(String value) {
			addCriterion("YUNXIN_ID >", value, "yunxinId");
			return (Criteria) this;
		}

		public Criteria andYunxinIdGreaterThanOrEqualTo(String value) {
			addCriterion("YUNXIN_ID >=", value, "yunxinId");
			return (Criteria) this;
		}

		public Criteria andYunxinIdLessThan(String value) {
			addCriterion("YUNXIN_ID <", value, "yunxinId");
			return (Criteria) this;
		}

		public Criteria andYunxinIdLessThanOrEqualTo(String value) {
			addCriterion("YUNXIN_ID <=", value, "yunxinId");
			return (Criteria) this;
		}

		public Criteria andYunxinIdLike(String value) {
			addCriterion("YUNXIN_ID like", value, "yunxinId");
			return (Criteria) this;
		}

		public Criteria andYunxinIdNotLike(String value) {
			addCriterion("YUNXIN_ID not like", value, "yunxinId");
			return (Criteria) this;
		}

		public Criteria andYunxinIdIn(List<String> values) {
			addCriterion("YUNXIN_ID in", values, "yunxinId");
			return (Criteria) this;
		}

		public Criteria andYunxinIdNotIn(List<String> values) {
			addCriterion("YUNXIN_ID not in", values, "yunxinId");
			return (Criteria) this;
		}

		public Criteria andYunxinIdBetween(String value1, String value2) {
			addCriterion("YUNXIN_ID between", value1, value2, "yunxinId");
			return (Criteria) this;
		}

		public Criteria andYunxinIdNotBetween(String value1, String value2) {
			addCriterion("YUNXIN_ID not between", value1, value2, "yunxinId");
			return (Criteria) this;
		}

		public Criteria andEquipmentIdIsNull() {
			addCriterion("EQUIPMENT_ID is null");
			return (Criteria) this;
		}

		public Criteria andEquipmentIdIsNotNull() {
			addCriterion("EQUIPMENT_ID is not null");
			return (Criteria) this;
		}

		public Criteria andEquipmentIdEqualTo(String value) {
			addCriterion("EQUIPMENT_ID =", value, "equipmentId");
			return (Criteria) this;
		}

		public Criteria andEquipmentIdNotEqualTo(String value) {
			addCriterion("EQUIPMENT_ID <>", value, "equipmentId");
			return (Criteria) this;
		}

		public Criteria andEquipmentIdGreaterThan(String value) {
			addCriterion("EQUIPMENT_ID >", value, "equipmentId");
			return (Criteria) this;
		}

		public Criteria andEquipmentIdGreaterThanOrEqualTo(String value) {
			addCriterion("EQUIPMENT_ID >=", value, "equipmentId");
			return (Criteria) this;
		}

		public Criteria andEquipmentIdLessThan(String value) {
			addCriterion("EQUIPMENT_ID <", value, "equipmentId");
			return (Criteria) this;
		}

		public Criteria andEquipmentIdLessThanOrEqualTo(String value) {
			addCriterion("EQUIPMENT_ID <=", value, "equipmentId");
			return (Criteria) this;
		}

		public Criteria andEquipmentIdLike(String value) {
			addCriterion("EQUIPMENT_ID like", value, "equipmentId");
			return (Criteria) this;
		}

		public Criteria andEquipmentIdNotLike(String value) {
			addCriterion("EQUIPMENT_ID not like", value, "equipmentId");
			return (Criteria) this;
		}

		public Criteria andEquipmentIdIn(List<String> values) {
			addCriterion("EQUIPMENT_ID in", values, "equipmentId");
			return (Criteria) this;
		}

		public Criteria andEquipmentIdNotIn(List<String> values) {
			addCriterion("EQUIPMENT_ID not in", values, "equipmentId");
			return (Criteria) this;
		}

		public Criteria andEquipmentIdBetween(String value1, String value2) {
			addCriterion("EQUIPMENT_ID between", value1, value2, "equipmentId");
			return (Criteria) this;
		}

		public Criteria andEquipmentIdNotBetween(String value1, String value2) {
			addCriterion("EQUIPMENT_ID not between", value1, value2, "equipmentId");
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

		public Criteria andCrmCompIdIsNull() {
			addCriterion("CRM_COMP_ID is null");
			return (Criteria) this;
		}

		public Criteria andCrmCompIdIsNotNull() {
			addCriterion("CRM_COMP_ID is not null");
			return (Criteria) this;
		}

		public Criteria andCrmCompIdEqualTo(Integer value) {
			addCriterion("CRM_COMP_ID =", value, "crmCompId");
			return (Criteria) this;
		}

		public Criteria andCrmCompIdNotEqualTo(Integer value) {
			addCriterion("CRM_COMP_ID <>", value, "crmCompId");
			return (Criteria) this;
		}

		public Criteria andCrmCompIdGreaterThan(Integer value) {
			addCriterion("CRM_COMP_ID >", value, "crmCompId");
			return (Criteria) this;
		}

		public Criteria andCrmCompIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("CRM_COMP_ID >=", value, "crmCompId");
			return (Criteria) this;
		}

		public Criteria andCrmCompIdLessThan(Integer value) {
			addCriterion("CRM_COMP_ID <", value, "crmCompId");
			return (Criteria) this;
		}

		public Criteria andCrmCompIdLessThanOrEqualTo(Integer value) {
			addCriterion("CRM_COMP_ID <=", value, "crmCompId");
			return (Criteria) this;
		}

		public Criteria andCrmCompIdIn(List<Integer> values) {
			addCriterion("CRM_COMP_ID in", values, "crmCompId");
			return (Criteria) this;
		}

		public Criteria andCrmCompIdNotIn(List<Integer> values) {
			addCriterion("CRM_COMP_ID not in", values, "crmCompId");
			return (Criteria) this;
		}

		public Criteria andCrmCompIdBetween(Integer value1, Integer value2) {
			addCriterion("CRM_COMP_ID between", value1, value2, "crmCompId");
			return (Criteria) this;
		}

		public Criteria andCrmCompIdNotBetween(Integer value1, Integer value2) {
			addCriterion("CRM_COMP_ID not between", value1, value2, "crmCompId");
			return (Criteria) this;
		}

		public Criteria andCreateUserIdIsNull() {
			addCriterion("CREATE_USER_ID is null");
			return (Criteria) this;
		}

		public Criteria andCreateUserIdIsNotNull() {
			addCriterion("CREATE_USER_ID is not null");
			return (Criteria) this;
		}

		public Criteria andCreateUserIdEqualTo(Integer value) {
			addCriterion("CREATE_USER_ID =", value, "createUserId");
			return (Criteria) this;
		}

		public Criteria andCreateUserIdNotEqualTo(Integer value) {
			addCriterion("CREATE_USER_ID <>", value, "createUserId");
			return (Criteria) this;
		}

		public Criteria andCreateUserIdGreaterThan(Integer value) {
			addCriterion("CREATE_USER_ID >", value, "createUserId");
			return (Criteria) this;
		}

		public Criteria andCreateUserIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("CREATE_USER_ID >=", value, "createUserId");
			return (Criteria) this;
		}

		public Criteria andCreateUserIdLessThan(Integer value) {
			addCriterion("CREATE_USER_ID <", value, "createUserId");
			return (Criteria) this;
		}

		public Criteria andCreateUserIdLessThanOrEqualTo(Integer value) {
			addCriterion("CREATE_USER_ID <=", value, "createUserId");
			return (Criteria) this;
		}

		public Criteria andCreateUserIdIn(List<Integer> values) {
			addCriterion("CREATE_USER_ID in", values, "createUserId");
			return (Criteria) this;
		}

		public Criteria andCreateUserIdNotIn(List<Integer> values) {
			addCriterion("CREATE_USER_ID not in", values, "createUserId");
			return (Criteria) this;
		}

		public Criteria andCreateUserIdBetween(Integer value1, Integer value2) {
			addCriterion("CREATE_USER_ID between", value1, value2, "createUserId");
			return (Criteria) this;
		}

		public Criteria andCreateUserIdNotBetween(Integer value1, Integer value2) {
			addCriterion("CREATE_USER_ID not between", value1, value2, "createUserId");
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

		public Criteria andFlagIsNull() {
			addCriterion("FLAG is null");
			return (Criteria) this;
		}

		public Criteria andFlagIsNotNull() {
			addCriterion("FLAG is not null");
			return (Criteria) this;
		}

		public Criteria andFlagEqualTo(Byte value) {
			addCriterion("FLAG =", value, "flag");
			return (Criteria) this;
		}

		public Criteria andFlagNotEqualTo(Byte value) {
			addCriterion("FLAG <>", value, "flag");
			return (Criteria) this;
		}

		public Criteria andFlagGreaterThan(Byte value) {
			addCriterion("FLAG >", value, "flag");
			return (Criteria) this;
		}

		public Criteria andFlagGreaterThanOrEqualTo(Byte value) {
			addCriterion("FLAG >=", value, "flag");
			return (Criteria) this;
		}

		public Criteria andFlagLessThan(Byte value) {
			addCriterion("FLAG <", value, "flag");
			return (Criteria) this;
		}

		public Criteria andFlagLessThanOrEqualTo(Byte value) {
			addCriterion("FLAG <=", value, "flag");
			return (Criteria) this;
		}

		public Criteria andFlagIn(List<Byte> values) {
			addCriterion("FLAG in", values, "flag");
			return (Criteria) this;
		}

		public Criteria andFlagNotIn(List<Byte> values) {
			addCriterion("FLAG not in", values, "flag");
			return (Criteria) this;
		}

		public Criteria andFlagBetween(Byte value1, Byte value2) {
			addCriterion("FLAG between", value1, value2, "flag");
			return (Criteria) this;
		}

		public Criteria andFlagNotBetween(Byte value1, Byte value2) {
			addCriterion("FLAG not between", value1, value2, "flag");
			return (Criteria) this;
		}

		public Criteria andErpCompIdIsNull() {
			addCriterion("ERP_COMP_ID is null");
			return (Criteria) this;
		}

		public Criteria andErpCompIdIsNotNull() {
			addCriterion("ERP_COMP_ID is not null");
			return (Criteria) this;
		}

		public Criteria andErpCompIdEqualTo(Integer value) {
			addCriterion("ERP_COMP_ID =", value, "erpCompId");
			return (Criteria) this;
		}

		public Criteria andErpCompIdNotEqualTo(Integer value) {
			addCriterion("ERP_COMP_ID <>", value, "erpCompId");
			return (Criteria) this;
		}

		public Criteria andErpCompIdGreaterThan(Integer value) {
			addCriterion("ERP_COMP_ID >", value, "erpCompId");
			return (Criteria) this;
		}

		public Criteria andErpCompIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("ERP_COMP_ID >=", value, "erpCompId");
			return (Criteria) this;
		}

		public Criteria andErpCompIdLessThan(Integer value) {
			addCriterion("ERP_COMP_ID <", value, "erpCompId");
			return (Criteria) this;
		}

		public Criteria andErpCompIdLessThanOrEqualTo(Integer value) {
			addCriterion("ERP_COMP_ID <=", value, "erpCompId");
			return (Criteria) this;
		}

		public Criteria andErpCompIdIn(List<Integer> values) {
			addCriterion("ERP_COMP_ID in", values, "erpCompId");
			return (Criteria) this;
		}

		public Criteria andErpCompIdNotIn(List<Integer> values) {
			addCriterion("ERP_COMP_ID not in", values, "erpCompId");
			return (Criteria) this;
		}

		public Criteria andErpCompIdBetween(Integer value1, Integer value2) {
			addCriterion("ERP_COMP_ID between", value1, value2, "erpCompId");
			return (Criteria) this;
		}

		public Criteria andErpCompIdNotBetween(Integer value1, Integer value2) {
			addCriterion("ERP_COMP_ID not between", value1, value2, "erpCompId");
			return (Criteria) this;
		}

		public Criteria andErpDeptIdIsNull() {
			addCriterion("ERP_DEPT_ID is null");
			return (Criteria) this;
		}

		public Criteria andErpDeptIdIsNotNull() {
			addCriterion("ERP_DEPT_ID is not null");
			return (Criteria) this;
		}

		public Criteria andErpDeptIdEqualTo(Integer value) {
			addCriterion("ERP_DEPT_ID =", value, "erpDeptId");
			return (Criteria) this;
		}

		public Criteria andErpDeptIdNotEqualTo(Integer value) {
			addCriterion("ERP_DEPT_ID <>", value, "erpDeptId");
			return (Criteria) this;
		}

		public Criteria andErpDeptIdGreaterThan(Integer value) {
			addCriterion("ERP_DEPT_ID >", value, "erpDeptId");
			return (Criteria) this;
		}

		public Criteria andErpDeptIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("ERP_DEPT_ID >=", value, "erpDeptId");
			return (Criteria) this;
		}

		public Criteria andErpDeptIdLessThan(Integer value) {
			addCriterion("ERP_DEPT_ID <", value, "erpDeptId");
			return (Criteria) this;
		}

		public Criteria andErpDeptIdLessThanOrEqualTo(Integer value) {
			addCriterion("ERP_DEPT_ID <=", value, "erpDeptId");
			return (Criteria) this;
		}

		public Criteria andErpDeptIdIn(List<Integer> values) {
			addCriterion("ERP_DEPT_ID in", values, "erpDeptId");
			return (Criteria) this;
		}

		public Criteria andErpDeptIdNotIn(List<Integer> values) {
			addCriterion("ERP_DEPT_ID not in", values, "erpDeptId");
			return (Criteria) this;
		}

		public Criteria andErpDeptIdBetween(Integer value1, Integer value2) {
			addCriterion("ERP_DEPT_ID between", value1, value2, "erpDeptId");
			return (Criteria) this;
		}

		public Criteria andErpDeptIdNotBetween(Integer value1, Integer value2) {
			addCriterion("ERP_DEPT_ID not between", value1, value2, "erpDeptId");
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