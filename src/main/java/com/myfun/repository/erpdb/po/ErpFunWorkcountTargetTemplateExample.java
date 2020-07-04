package com.myfun.repository.erpdb.po;

import com.myfun.repository.support.generator.shard.ShardDb;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ErpFunWorkcountTargetTemplateExample extends ShardDb {
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
	public ErpFunWorkcountTargetTemplateExample() {
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

		public Criteria andGjHouseCountIsNull() {
			addCriterion("GJ_HOUSE_COUNT is null");
			return (Criteria) this;
		}

		public Criteria andGjHouseCountIsNotNull() {
			addCriterion("GJ_HOUSE_COUNT is not null");
			return (Criteria) this;
		}

		public Criteria andGjHouseCountEqualTo(Integer value) {
			addCriterion("GJ_HOUSE_COUNT =", value, "gjHouseCount");
			return (Criteria) this;
		}

		public Criteria andGjHouseCountNotEqualTo(Integer value) {
			addCriterion("GJ_HOUSE_COUNT <>", value, "gjHouseCount");
			return (Criteria) this;
		}

		public Criteria andGjHouseCountGreaterThan(Integer value) {
			addCriterion("GJ_HOUSE_COUNT >", value, "gjHouseCount");
			return (Criteria) this;
		}

		public Criteria andGjHouseCountGreaterThanOrEqualTo(Integer value) {
			addCriterion("GJ_HOUSE_COUNT >=", value, "gjHouseCount");
			return (Criteria) this;
		}

		public Criteria andGjHouseCountLessThan(Integer value) {
			addCriterion("GJ_HOUSE_COUNT <", value, "gjHouseCount");
			return (Criteria) this;
		}

		public Criteria andGjHouseCountLessThanOrEqualTo(Integer value) {
			addCriterion("GJ_HOUSE_COUNT <=", value, "gjHouseCount");
			return (Criteria) this;
		}

		public Criteria andGjHouseCountIn(List<Integer> values) {
			addCriterion("GJ_HOUSE_COUNT in", values, "gjHouseCount");
			return (Criteria) this;
		}

		public Criteria andGjHouseCountNotIn(List<Integer> values) {
			addCriterion("GJ_HOUSE_COUNT not in", values, "gjHouseCount");
			return (Criteria) this;
		}

		public Criteria andGjHouseCountBetween(Integer value1, Integer value2) {
			addCriterion("GJ_HOUSE_COUNT between", value1, value2, "gjHouseCount");
			return (Criteria) this;
		}

		public Criteria andGjHouseCountNotBetween(Integer value1, Integer value2) {
			addCriterion("GJ_HOUSE_COUNT not between", value1, value2, "gjHouseCount");
			return (Criteria) this;
		}

		public Criteria andGjCustomerCountIsNull() {
			addCriterion("GJ_CUSTOMER_COUNT is null");
			return (Criteria) this;
		}

		public Criteria andGjCustomerCountIsNotNull() {
			addCriterion("GJ_CUSTOMER_COUNT is not null");
			return (Criteria) this;
		}

		public Criteria andGjCustomerCountEqualTo(Integer value) {
			addCriterion("GJ_CUSTOMER_COUNT =", value, "gjCustomerCount");
			return (Criteria) this;
		}

		public Criteria andGjCustomerCountNotEqualTo(Integer value) {
			addCriterion("GJ_CUSTOMER_COUNT <>", value, "gjCustomerCount");
			return (Criteria) this;
		}

		public Criteria andGjCustomerCountGreaterThan(Integer value) {
			addCriterion("GJ_CUSTOMER_COUNT >", value, "gjCustomerCount");
			return (Criteria) this;
		}

		public Criteria andGjCustomerCountGreaterThanOrEqualTo(Integer value) {
			addCriterion("GJ_CUSTOMER_COUNT >=", value, "gjCustomerCount");
			return (Criteria) this;
		}

		public Criteria andGjCustomerCountLessThan(Integer value) {
			addCriterion("GJ_CUSTOMER_COUNT <", value, "gjCustomerCount");
			return (Criteria) this;
		}

		public Criteria andGjCustomerCountLessThanOrEqualTo(Integer value) {
			addCriterion("GJ_CUSTOMER_COUNT <=", value, "gjCustomerCount");
			return (Criteria) this;
		}

		public Criteria andGjCustomerCountIn(List<Integer> values) {
			addCriterion("GJ_CUSTOMER_COUNT in", values, "gjCustomerCount");
			return (Criteria) this;
		}

		public Criteria andGjCustomerCountNotIn(List<Integer> values) {
			addCriterion("GJ_CUSTOMER_COUNT not in", values, "gjCustomerCount");
			return (Criteria) this;
		}

		public Criteria andGjCustomerCountBetween(Integer value1, Integer value2) {
			addCriterion("GJ_CUSTOMER_COUNT between", value1, value2, "gjCustomerCount");
			return (Criteria) this;
		}

		public Criteria andGjCustomerCountNotBetween(Integer value1, Integer value2) {
			addCriterion("GJ_CUSTOMER_COUNT not between", value1, value2, "gjCustomerCount");
			return (Criteria) this;
		}

		public Criteria andVrCountIsNull() {
			addCriterion("VR_COUNT is null");
			return (Criteria) this;
		}

		public Criteria andVrCountIsNotNull() {
			addCriterion("VR_COUNT is not null");
			return (Criteria) this;
		}

		public Criteria andVrCountEqualTo(Integer value) {
			addCriterion("VR_COUNT =", value, "vrCount");
			return (Criteria) this;
		}

		public Criteria andVrCountNotEqualTo(Integer value) {
			addCriterion("VR_COUNT <>", value, "vrCount");
			return (Criteria) this;
		}

		public Criteria andVrCountGreaterThan(Integer value) {
			addCriterion("VR_COUNT >", value, "vrCount");
			return (Criteria) this;
		}

		public Criteria andVrCountGreaterThanOrEqualTo(Integer value) {
			addCriterion("VR_COUNT >=", value, "vrCount");
			return (Criteria) this;
		}

		public Criteria andVrCountLessThan(Integer value) {
			addCriterion("VR_COUNT <", value, "vrCount");
			return (Criteria) this;
		}

		public Criteria andVrCountLessThanOrEqualTo(Integer value) {
			addCriterion("VR_COUNT <=", value, "vrCount");
			return (Criteria) this;
		}

		public Criteria andVrCountIn(List<Integer> values) {
			addCriterion("VR_COUNT in", values, "vrCount");
			return (Criteria) this;
		}

		public Criteria andVrCountNotIn(List<Integer> values) {
			addCriterion("VR_COUNT not in", values, "vrCount");
			return (Criteria) this;
		}

		public Criteria andVrCountBetween(Integer value1, Integer value2) {
			addCriterion("VR_COUNT between", value1, value2, "vrCount");
			return (Criteria) this;
		}

		public Criteria andVrCountNotBetween(Integer value1, Integer value2) {
			addCriterion("VR_COUNT not between", value1, value2, "vrCount");
			return (Criteria) this;
		}

		public Criteria andSpCountIsNull() {
			addCriterion("SP_COUNT is null");
			return (Criteria) this;
		}

		public Criteria andSpCountIsNotNull() {
			addCriterion("SP_COUNT is not null");
			return (Criteria) this;
		}

		public Criteria andSpCountEqualTo(Integer value) {
			addCriterion("SP_COUNT =", value, "spCount");
			return (Criteria) this;
		}

		public Criteria andSpCountNotEqualTo(Integer value) {
			addCriterion("SP_COUNT <>", value, "spCount");
			return (Criteria) this;
		}

		public Criteria andSpCountGreaterThan(Integer value) {
			addCriterion("SP_COUNT >", value, "spCount");
			return (Criteria) this;
		}

		public Criteria andSpCountGreaterThanOrEqualTo(Integer value) {
			addCriterion("SP_COUNT >=", value, "spCount");
			return (Criteria) this;
		}

		public Criteria andSpCountLessThan(Integer value) {
			addCriterion("SP_COUNT <", value, "spCount");
			return (Criteria) this;
		}

		public Criteria andSpCountLessThanOrEqualTo(Integer value) {
			addCriterion("SP_COUNT <=", value, "spCount");
			return (Criteria) this;
		}

		public Criteria andSpCountIn(List<Integer> values) {
			addCriterion("SP_COUNT in", values, "spCount");
			return (Criteria) this;
		}

		public Criteria andSpCountNotIn(List<Integer> values) {
			addCriterion("SP_COUNT not in", values, "spCount");
			return (Criteria) this;
		}

		public Criteria andSpCountBetween(Integer value1, Integer value2) {
			addCriterion("SP_COUNT between", value1, value2, "spCount");
			return (Criteria) this;
		}

		public Criteria andSpCountNotBetween(Integer value1, Integer value2) {
			addCriterion("SP_COUNT not between", value1, value2, "spCount");
			return (Criteria) this;
		}

		public Criteria andKkCountIsNull() {
			addCriterion("KK_COUNT is null");
			return (Criteria) this;
		}

		public Criteria andKkCountIsNotNull() {
			addCriterion("KK_COUNT is not null");
			return (Criteria) this;
		}

		public Criteria andKkCountEqualTo(Integer value) {
			addCriterion("KK_COUNT =", value, "kkCount");
			return (Criteria) this;
		}

		public Criteria andKkCountNotEqualTo(Integer value) {
			addCriterion("KK_COUNT <>", value, "kkCount");
			return (Criteria) this;
		}

		public Criteria andKkCountGreaterThan(Integer value) {
			addCriterion("KK_COUNT >", value, "kkCount");
			return (Criteria) this;
		}

		public Criteria andKkCountGreaterThanOrEqualTo(Integer value) {
			addCriterion("KK_COUNT >=", value, "kkCount");
			return (Criteria) this;
		}

		public Criteria andKkCountLessThan(Integer value) {
			addCriterion("KK_COUNT <", value, "kkCount");
			return (Criteria) this;
		}

		public Criteria andKkCountLessThanOrEqualTo(Integer value) {
			addCriterion("KK_COUNT <=", value, "kkCount");
			return (Criteria) this;
		}

		public Criteria andKkCountIn(List<Integer> values) {
			addCriterion("KK_COUNT in", values, "kkCount");
			return (Criteria) this;
		}

		public Criteria andKkCountNotIn(List<Integer> values) {
			addCriterion("KK_COUNT not in", values, "kkCount");
			return (Criteria) this;
		}

		public Criteria andKkCountBetween(Integer value1, Integer value2) {
			addCriterion("KK_COUNT between", value1, value2, "kkCount");
			return (Criteria) this;
		}

		public Criteria andKkCountNotBetween(Integer value1, Integer value2) {
			addCriterion("KK_COUNT not between", value1, value2, "kkCount");
			return (Criteria) this;
		}

		public Criteria andHouseFafaCountIsNull() {
			addCriterion("HOUSE_FAFA_COUNT is null");
			return (Criteria) this;
		}

		public Criteria andHouseFafaCountIsNotNull() {
			addCriterion("HOUSE_FAFA_COUNT is not null");
			return (Criteria) this;
		}

		public Criteria andHouseFafaCountEqualTo(Integer value) {
			addCriterion("HOUSE_FAFA_COUNT =", value, "houseFafaCount");
			return (Criteria) this;
		}

		public Criteria andHouseFafaCountNotEqualTo(Integer value) {
			addCriterion("HOUSE_FAFA_COUNT <>", value, "houseFafaCount");
			return (Criteria) this;
		}

		public Criteria andHouseFafaCountGreaterThan(Integer value) {
			addCriterion("HOUSE_FAFA_COUNT >", value, "houseFafaCount");
			return (Criteria) this;
		}

		public Criteria andHouseFafaCountGreaterThanOrEqualTo(Integer value) {
			addCriterion("HOUSE_FAFA_COUNT >=", value, "houseFafaCount");
			return (Criteria) this;
		}

		public Criteria andHouseFafaCountLessThan(Integer value) {
			addCriterion("HOUSE_FAFA_COUNT <", value, "houseFafaCount");
			return (Criteria) this;
		}

		public Criteria andHouseFafaCountLessThanOrEqualTo(Integer value) {
			addCriterion("HOUSE_FAFA_COUNT <=", value, "houseFafaCount");
			return (Criteria) this;
		}

		public Criteria andHouseFafaCountIn(List<Integer> values) {
			addCriterion("HOUSE_FAFA_COUNT in", values, "houseFafaCount");
			return (Criteria) this;
		}

		public Criteria andHouseFafaCountNotIn(List<Integer> values) {
			addCriterion("HOUSE_FAFA_COUNT not in", values, "houseFafaCount");
			return (Criteria) this;
		}

		public Criteria andHouseFafaCountBetween(Integer value1, Integer value2) {
			addCriterion("HOUSE_FAFA_COUNT between", value1, value2, "houseFafaCount");
			return (Criteria) this;
		}

		public Criteria andHouseFafaCountNotBetween(Integer value1, Integer value2) {
			addCriterion("HOUSE_FAFA_COUNT not between", value1, value2, "houseFafaCount");
			return (Criteria) this;
		}

		public Criteria andPostShareCountIsNull() {
			addCriterion("POST_SHARE_COUNT is null");
			return (Criteria) this;
		}

		public Criteria andPostShareCountIsNotNull() {
			addCriterion("POST_SHARE_COUNT is not null");
			return (Criteria) this;
		}

		public Criteria andPostShareCountEqualTo(Integer value) {
			addCriterion("POST_SHARE_COUNT =", value, "postShareCount");
			return (Criteria) this;
		}

		public Criteria andPostShareCountNotEqualTo(Integer value) {
			addCriterion("POST_SHARE_COUNT <>", value, "postShareCount");
			return (Criteria) this;
		}

		public Criteria andPostShareCountGreaterThan(Integer value) {
			addCriterion("POST_SHARE_COUNT >", value, "postShareCount");
			return (Criteria) this;
		}

		public Criteria andPostShareCountGreaterThanOrEqualTo(Integer value) {
			addCriterion("POST_SHARE_COUNT >=", value, "postShareCount");
			return (Criteria) this;
		}

		public Criteria andPostShareCountLessThan(Integer value) {
			addCriterion("POST_SHARE_COUNT <", value, "postShareCount");
			return (Criteria) this;
		}

		public Criteria andPostShareCountLessThanOrEqualTo(Integer value) {
			addCriterion("POST_SHARE_COUNT <=", value, "postShareCount");
			return (Criteria) this;
		}

		public Criteria andPostShareCountIn(List<Integer> values) {
			addCriterion("POST_SHARE_COUNT in", values, "postShareCount");
			return (Criteria) this;
		}

		public Criteria andPostShareCountNotIn(List<Integer> values) {
			addCriterion("POST_SHARE_COUNT not in", values, "postShareCount");
			return (Criteria) this;
		}

		public Criteria andPostShareCountBetween(Integer value1, Integer value2) {
			addCriterion("POST_SHARE_COUNT between", value1, value2, "postShareCount");
			return (Criteria) this;
		}

		public Criteria andPostShareCountNotBetween(Integer value1, Integer value2) {
			addCriterion("POST_SHARE_COUNT not between", value1, value2, "postShareCount");
			return (Criteria) this;
		}

		public Criteria andHouseAddIsNull() {
			addCriterion("HOUSE_ADD is null");
			return (Criteria) this;
		}

		public Criteria andHouseAddIsNotNull() {
			addCriterion("HOUSE_ADD is not null");
			return (Criteria) this;
		}

		public Criteria andHouseAddEqualTo(Integer value) {
			addCriterion("HOUSE_ADD =", value, "houseAdd");
			return (Criteria) this;
		}

		public Criteria andHouseAddNotEqualTo(Integer value) {
			addCriterion("HOUSE_ADD <>", value, "houseAdd");
			return (Criteria) this;
		}

		public Criteria andHouseAddGreaterThan(Integer value) {
			addCriterion("HOUSE_ADD >", value, "houseAdd");
			return (Criteria) this;
		}

		public Criteria andHouseAddGreaterThanOrEqualTo(Integer value) {
			addCriterion("HOUSE_ADD >=", value, "houseAdd");
			return (Criteria) this;
		}

		public Criteria andHouseAddLessThan(Integer value) {
			addCriterion("HOUSE_ADD <", value, "houseAdd");
			return (Criteria) this;
		}

		public Criteria andHouseAddLessThanOrEqualTo(Integer value) {
			addCriterion("HOUSE_ADD <=", value, "houseAdd");
			return (Criteria) this;
		}

		public Criteria andHouseAddIn(List<Integer> values) {
			addCriterion("HOUSE_ADD in", values, "houseAdd");
			return (Criteria) this;
		}

		public Criteria andHouseAddNotIn(List<Integer> values) {
			addCriterion("HOUSE_ADD not in", values, "houseAdd");
			return (Criteria) this;
		}

		public Criteria andHouseAddBetween(Integer value1, Integer value2) {
			addCriterion("HOUSE_ADD between", value1, value2, "houseAdd");
			return (Criteria) this;
		}

		public Criteria andHouseAddNotBetween(Integer value1, Integer value2) {
			addCriterion("HOUSE_ADD not between", value1, value2, "houseAdd");
			return (Criteria) this;
		}

		public Criteria andCustomerAddIsNull() {
			addCriterion("CUSTOMER_ADD is null");
			return (Criteria) this;
		}

		public Criteria andCustomerAddIsNotNull() {
			addCriterion("CUSTOMER_ADD is not null");
			return (Criteria) this;
		}

		public Criteria andCustomerAddEqualTo(Integer value) {
			addCriterion("CUSTOMER_ADD =", value, "customerAdd");
			return (Criteria) this;
		}

		public Criteria andCustomerAddNotEqualTo(Integer value) {
			addCriterion("CUSTOMER_ADD <>", value, "customerAdd");
			return (Criteria) this;
		}

		public Criteria andCustomerAddGreaterThan(Integer value) {
			addCriterion("CUSTOMER_ADD >", value, "customerAdd");
			return (Criteria) this;
		}

		public Criteria andCustomerAddGreaterThanOrEqualTo(Integer value) {
			addCriterion("CUSTOMER_ADD >=", value, "customerAdd");
			return (Criteria) this;
		}

		public Criteria andCustomerAddLessThan(Integer value) {
			addCriterion("CUSTOMER_ADD <", value, "customerAdd");
			return (Criteria) this;
		}

		public Criteria andCustomerAddLessThanOrEqualTo(Integer value) {
			addCriterion("CUSTOMER_ADD <=", value, "customerAdd");
			return (Criteria) this;
		}

		public Criteria andCustomerAddIn(List<Integer> values) {
			addCriterion("CUSTOMER_ADD in", values, "customerAdd");
			return (Criteria) this;
		}

		public Criteria andCustomerAddNotIn(List<Integer> values) {
			addCriterion("CUSTOMER_ADD not in", values, "customerAdd");
			return (Criteria) this;
		}

		public Criteria andCustomerAddBetween(Integer value1, Integer value2) {
			addCriterion("CUSTOMER_ADD between", value1, value2, "customerAdd");
			return (Criteria) this;
		}

		public Criteria andCustomerAddNotBetween(Integer value1, Integer value2) {
			addCriterion("CUSTOMER_ADD not between", value1, value2, "customerAdd");
			return (Criteria) this;
		}

		public Criteria andDkCountIsNull() {
			addCriterion("DK_COUNT is null");
			return (Criteria) this;
		}

		public Criteria andDkCountIsNotNull() {
			addCriterion("DK_COUNT is not null");
			return (Criteria) this;
		}

		public Criteria andDkCountEqualTo(Integer value) {
			addCriterion("DK_COUNT =", value, "dkCount");
			return (Criteria) this;
		}

		public Criteria andDkCountNotEqualTo(Integer value) {
			addCriterion("DK_COUNT <>", value, "dkCount");
			return (Criteria) this;
		}

		public Criteria andDkCountGreaterThan(Integer value) {
			addCriterion("DK_COUNT >", value, "dkCount");
			return (Criteria) this;
		}

		public Criteria andDkCountGreaterThanOrEqualTo(Integer value) {
			addCriterion("DK_COUNT >=", value, "dkCount");
			return (Criteria) this;
		}

		public Criteria andDkCountLessThan(Integer value) {
			addCriterion("DK_COUNT <", value, "dkCount");
			return (Criteria) this;
		}

		public Criteria andDkCountLessThanOrEqualTo(Integer value) {
			addCriterion("DK_COUNT <=", value, "dkCount");
			return (Criteria) this;
		}

		public Criteria andDkCountIn(List<Integer> values) {
			addCriterion("DK_COUNT in", values, "dkCount");
			return (Criteria) this;
		}

		public Criteria andDkCountNotIn(List<Integer> values) {
			addCriterion("DK_COUNT not in", values, "dkCount");
			return (Criteria) this;
		}

		public Criteria andDkCountBetween(Integer value1, Integer value2) {
			addCriterion("DK_COUNT between", value1, value2, "dkCount");
			return (Criteria) this;
		}

		public Criteria andDkCountNotBetween(Integer value1, Integer value2) {
			addCriterion("DK_COUNT not between", value1, value2, "dkCount");
			return (Criteria) this;
		}

		public Criteria andFkCountIsNull() {
			addCriterion("FK_COUNT is null");
			return (Criteria) this;
		}

		public Criteria andFkCountIsNotNull() {
			addCriterion("FK_COUNT is not null");
			return (Criteria) this;
		}

		public Criteria andFkCountEqualTo(Integer value) {
			addCriterion("FK_COUNT =", value, "fkCount");
			return (Criteria) this;
		}

		public Criteria andFkCountNotEqualTo(Integer value) {
			addCriterion("FK_COUNT <>", value, "fkCount");
			return (Criteria) this;
		}

		public Criteria andFkCountGreaterThan(Integer value) {
			addCriterion("FK_COUNT >", value, "fkCount");
			return (Criteria) this;
		}

		public Criteria andFkCountGreaterThanOrEqualTo(Integer value) {
			addCriterion("FK_COUNT >=", value, "fkCount");
			return (Criteria) this;
		}

		public Criteria andFkCountLessThan(Integer value) {
			addCriterion("FK_COUNT <", value, "fkCount");
			return (Criteria) this;
		}

		public Criteria andFkCountLessThanOrEqualTo(Integer value) {
			addCriterion("FK_COUNT <=", value, "fkCount");
			return (Criteria) this;
		}

		public Criteria andFkCountIn(List<Integer> values) {
			addCriterion("FK_COUNT in", values, "fkCount");
			return (Criteria) this;
		}

		public Criteria andFkCountNotIn(List<Integer> values) {
			addCriterion("FK_COUNT not in", values, "fkCount");
			return (Criteria) this;
		}

		public Criteria andFkCountBetween(Integer value1, Integer value2) {
			addCriterion("FK_COUNT between", value1, value2, "fkCount");
			return (Criteria) this;
		}

		public Criteria andFkCountNotBetween(Integer value1, Integer value2) {
			addCriterion("FK_COUNT not between", value1, value2, "fkCount");
			return (Criteria) this;
		}

		public Criteria andYsCountIsNull() {
			addCriterion("YS_COUNT is null");
			return (Criteria) this;
		}

		public Criteria andYsCountIsNotNull() {
			addCriterion("YS_COUNT is not null");
			return (Criteria) this;
		}

		public Criteria andYsCountEqualTo(Integer value) {
			addCriterion("YS_COUNT =", value, "ysCount");
			return (Criteria) this;
		}

		public Criteria andYsCountNotEqualTo(Integer value) {
			addCriterion("YS_COUNT <>", value, "ysCount");
			return (Criteria) this;
		}

		public Criteria andYsCountGreaterThan(Integer value) {
			addCriterion("YS_COUNT >", value, "ysCount");
			return (Criteria) this;
		}

		public Criteria andYsCountGreaterThanOrEqualTo(Integer value) {
			addCriterion("YS_COUNT >=", value, "ysCount");
			return (Criteria) this;
		}

		public Criteria andYsCountLessThan(Integer value) {
			addCriterion("YS_COUNT <", value, "ysCount");
			return (Criteria) this;
		}

		public Criteria andYsCountLessThanOrEqualTo(Integer value) {
			addCriterion("YS_COUNT <=", value, "ysCount");
			return (Criteria) this;
		}

		public Criteria andYsCountIn(List<Integer> values) {
			addCriterion("YS_COUNT in", values, "ysCount");
			return (Criteria) this;
		}

		public Criteria andYsCountNotIn(List<Integer> values) {
			addCriterion("YS_COUNT not in", values, "ysCount");
			return (Criteria) this;
		}

		public Criteria andYsCountBetween(Integer value1, Integer value2) {
			addCriterion("YS_COUNT between", value1, value2, "ysCount");
			return (Criteria) this;
		}

		public Criteria andYsCountNotBetween(Integer value1, Integer value2) {
			addCriterion("YS_COUNT not between", value1, value2, "ysCount");
			return (Criteria) this;
		}

		public Criteria andDjwtCountIsNull() {
			addCriterion("DJWT_COUNT is null");
			return (Criteria) this;
		}

		public Criteria andDjwtCountIsNotNull() {
			addCriterion("DJWT_COUNT is not null");
			return (Criteria) this;
		}

		public Criteria andDjwtCountEqualTo(Integer value) {
			addCriterion("DJWT_COUNT =", value, "djwtCount");
			return (Criteria) this;
		}

		public Criteria andDjwtCountNotEqualTo(Integer value) {
			addCriterion("DJWT_COUNT <>", value, "djwtCount");
			return (Criteria) this;
		}

		public Criteria andDjwtCountGreaterThan(Integer value) {
			addCriterion("DJWT_COUNT >", value, "djwtCount");
			return (Criteria) this;
		}

		public Criteria andDjwtCountGreaterThanOrEqualTo(Integer value) {
			addCriterion("DJWT_COUNT >=", value, "djwtCount");
			return (Criteria) this;
		}

		public Criteria andDjwtCountLessThan(Integer value) {
			addCriterion("DJWT_COUNT <", value, "djwtCount");
			return (Criteria) this;
		}

		public Criteria andDjwtCountLessThanOrEqualTo(Integer value) {
			addCriterion("DJWT_COUNT <=", value, "djwtCount");
			return (Criteria) this;
		}

		public Criteria andDjwtCountIn(List<Integer> values) {
			addCriterion("DJWT_COUNT in", values, "djwtCount");
			return (Criteria) this;
		}

		public Criteria andDjwtCountNotIn(List<Integer> values) {
			addCriterion("DJWT_COUNT not in", values, "djwtCount");
			return (Criteria) this;
		}

		public Criteria andDjwtCountBetween(Integer value1, Integer value2) {
			addCriterion("DJWT_COUNT between", value1, value2, "djwtCount");
			return (Criteria) this;
		}

		public Criteria andDjwtCountNotBetween(Integer value1, Integer value2) {
			addCriterion("DJWT_COUNT not between", value1, value2, "djwtCount");
			return (Criteria) this;
		}

		public Criteria andSignDealCountIsNull() {
			addCriterion("SIGN_DEAL_COUNT is null");
			return (Criteria) this;
		}

		public Criteria andSignDealCountIsNotNull() {
			addCriterion("SIGN_DEAL_COUNT is not null");
			return (Criteria) this;
		}

		public Criteria andSignDealCountEqualTo(Integer value) {
			addCriterion("SIGN_DEAL_COUNT =", value, "signDealCount");
			return (Criteria) this;
		}

		public Criteria andSignDealCountNotEqualTo(Integer value) {
			addCriterion("SIGN_DEAL_COUNT <>", value, "signDealCount");
			return (Criteria) this;
		}

		public Criteria andSignDealCountGreaterThan(Integer value) {
			addCriterion("SIGN_DEAL_COUNT >", value, "signDealCount");
			return (Criteria) this;
		}

		public Criteria andSignDealCountGreaterThanOrEqualTo(Integer value) {
			addCriterion("SIGN_DEAL_COUNT >=", value, "signDealCount");
			return (Criteria) this;
		}

		public Criteria andSignDealCountLessThan(Integer value) {
			addCriterion("SIGN_DEAL_COUNT <", value, "signDealCount");
			return (Criteria) this;
		}

		public Criteria andSignDealCountLessThanOrEqualTo(Integer value) {
			addCriterion("SIGN_DEAL_COUNT <=", value, "signDealCount");
			return (Criteria) this;
		}

		public Criteria andSignDealCountIn(List<Integer> values) {
			addCriterion("SIGN_DEAL_COUNT in", values, "signDealCount");
			return (Criteria) this;
		}

		public Criteria andSignDealCountNotIn(List<Integer> values) {
			addCriterion("SIGN_DEAL_COUNT not in", values, "signDealCount");
			return (Criteria) this;
		}

		public Criteria andSignDealCountBetween(Integer value1, Integer value2) {
			addCriterion("SIGN_DEAL_COUNT between", value1, value2, "signDealCount");
			return (Criteria) this;
		}

		public Criteria andSignDealCountNotBetween(Integer value1, Integer value2) {
			addCriterion("SIGN_DEAL_COUNT not between", value1, value2, "signDealCount");
			return (Criteria) this;
		}

		public Criteria andTargetTypeIsNull() {
			addCriterion("TARGET_TYPE is null");
			return (Criteria) this;
		}

		public Criteria andTargetTypeIsNotNull() {
			addCriterion("TARGET_TYPE is not null");
			return (Criteria) this;
		}

		public Criteria andTargetTypeEqualTo(Byte value) {
			addCriterion("TARGET_TYPE =", value, "targetType");
			return (Criteria) this;
		}

		public Criteria andTargetTypeNotEqualTo(Byte value) {
			addCriterion("TARGET_TYPE <>", value, "targetType");
			return (Criteria) this;
		}

		public Criteria andTargetTypeGreaterThan(Byte value) {
			addCriterion("TARGET_TYPE >", value, "targetType");
			return (Criteria) this;
		}

		public Criteria andTargetTypeGreaterThanOrEqualTo(Byte value) {
			addCriterion("TARGET_TYPE >=", value, "targetType");
			return (Criteria) this;
		}

		public Criteria andTargetTypeLessThan(Byte value) {
			addCriterion("TARGET_TYPE <", value, "targetType");
			return (Criteria) this;
		}

		public Criteria andTargetTypeLessThanOrEqualTo(Byte value) {
			addCriterion("TARGET_TYPE <=", value, "targetType");
			return (Criteria) this;
		}

		public Criteria andTargetTypeIn(List<Byte> values) {
			addCriterion("TARGET_TYPE in", values, "targetType");
			return (Criteria) this;
		}

		public Criteria andTargetTypeNotIn(List<Byte> values) {
			addCriterion("TARGET_TYPE not in", values, "targetType");
			return (Criteria) this;
		}

		public Criteria andTargetTypeBetween(Byte value1, Byte value2) {
			addCriterion("TARGET_TYPE between", value1, value2, "targetType");
			return (Criteria) this;
		}

		public Criteria andTargetTypeNotBetween(Byte value1, Byte value2) {
			addCriterion("TARGET_TYPE not between", value1, value2, "targetType");
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

		public Criteria andTpscCountIsNull() {
			addCriterion("TPSC_COUNT is null");
			return (Criteria) this;
		}

		public Criteria andTpscCountIsNotNull() {
			addCriterion("TPSC_COUNT is not null");
			return (Criteria) this;
		}

		public Criteria andTpscCountEqualTo(Integer value) {
			addCriterion("TPSC_COUNT =", value, "tpscCount");
			return (Criteria) this;
		}

		public Criteria andTpscCountNotEqualTo(Integer value) {
			addCriterion("TPSC_COUNT <>", value, "tpscCount");
			return (Criteria) this;
		}

		public Criteria andTpscCountGreaterThan(Integer value) {
			addCriterion("TPSC_COUNT >", value, "tpscCount");
			return (Criteria) this;
		}

		public Criteria andTpscCountGreaterThanOrEqualTo(Integer value) {
			addCriterion("TPSC_COUNT >=", value, "tpscCount");
			return (Criteria) this;
		}

		public Criteria andTpscCountLessThan(Integer value) {
			addCriterion("TPSC_COUNT <", value, "tpscCount");
			return (Criteria) this;
		}

		public Criteria andTpscCountLessThanOrEqualTo(Integer value) {
			addCriterion("TPSC_COUNT <=", value, "tpscCount");
			return (Criteria) this;
		}

		public Criteria andTpscCountIn(List<Integer> values) {
			addCriterion("TPSC_COUNT in", values, "tpscCount");
			return (Criteria) this;
		}

		public Criteria andTpscCountNotIn(List<Integer> values) {
			addCriterion("TPSC_COUNT not in", values, "tpscCount");
			return (Criteria) this;
		}

		public Criteria andTpscCountBetween(Integer value1, Integer value2) {
			addCriterion("TPSC_COUNT between", value1, value2, "tpscCount");
			return (Criteria) this;
		}

		public Criteria andTpscCountNotBetween(Integer value1, Integer value2) {
			addCriterion("TPSC_COUNT not between", value1, value2, "tpscCount");
			return (Criteria) this;
		}

		public Criteria andCkdhCountIsNull() {
			addCriterion("CKDH_COUNT is null");
			return (Criteria) this;
		}

		public Criteria andCkdhCountIsNotNull() {
			addCriterion("CKDH_COUNT is not null");
			return (Criteria) this;
		}

		public Criteria andCkdhCountEqualTo(Integer value) {
			addCriterion("CKDH_COUNT =", value, "ckdhCount");
			return (Criteria) this;
		}

		public Criteria andCkdhCountNotEqualTo(Integer value) {
			addCriterion("CKDH_COUNT <>", value, "ckdhCount");
			return (Criteria) this;
		}

		public Criteria andCkdhCountGreaterThan(Integer value) {
			addCriterion("CKDH_COUNT >", value, "ckdhCount");
			return (Criteria) this;
		}

		public Criteria andCkdhCountGreaterThanOrEqualTo(Integer value) {
			addCriterion("CKDH_COUNT >=", value, "ckdhCount");
			return (Criteria) this;
		}

		public Criteria andCkdhCountLessThan(Integer value) {
			addCriterion("CKDH_COUNT <", value, "ckdhCount");
			return (Criteria) this;
		}

		public Criteria andCkdhCountLessThanOrEqualTo(Integer value) {
			addCriterion("CKDH_COUNT <=", value, "ckdhCount");
			return (Criteria) this;
		}

		public Criteria andCkdhCountIn(List<Integer> values) {
			addCriterion("CKDH_COUNT in", values, "ckdhCount");
			return (Criteria) this;
		}

		public Criteria andCkdhCountNotIn(List<Integer> values) {
			addCriterion("CKDH_COUNT not in", values, "ckdhCount");
			return (Criteria) this;
		}

		public Criteria andCkdhCountBetween(Integer value1, Integer value2) {
			addCriterion("CKDH_COUNT between", value1, value2, "ckdhCount");
			return (Criteria) this;
		}

		public Criteria andCkdhCountNotBetween(Integer value1, Integer value2) {
			addCriterion("CKDH_COUNT not between", value1, value2, "ckdhCount");
			return (Criteria) this;
		}

		public Criteria andXswtCountIsNull() {
			addCriterion("XSWT_COUNT is null");
			return (Criteria) this;
		}

		public Criteria andXswtCountIsNotNull() {
			addCriterion("XSWT_COUNT is not null");
			return (Criteria) this;
		}

		public Criteria andXswtCountEqualTo(Integer value) {
			addCriterion("XSWT_COUNT =", value, "xswtCount");
			return (Criteria) this;
		}

		public Criteria andXswtCountNotEqualTo(Integer value) {
			addCriterion("XSWT_COUNT <>", value, "xswtCount");
			return (Criteria) this;
		}

		public Criteria andXswtCountGreaterThan(Integer value) {
			addCriterion("XSWT_COUNT >", value, "xswtCount");
			return (Criteria) this;
		}

		public Criteria andXswtCountGreaterThanOrEqualTo(Integer value) {
			addCriterion("XSWT_COUNT >=", value, "xswtCount");
			return (Criteria) this;
		}

		public Criteria andXswtCountLessThan(Integer value) {
			addCriterion("XSWT_COUNT <", value, "xswtCount");
			return (Criteria) this;
		}

		public Criteria andXswtCountLessThanOrEqualTo(Integer value) {
			addCriterion("XSWT_COUNT <=", value, "xswtCount");
			return (Criteria) this;
		}

		public Criteria andXswtCountIn(List<Integer> values) {
			addCriterion("XSWT_COUNT in", values, "xswtCount");
			return (Criteria) this;
		}

		public Criteria andXswtCountNotIn(List<Integer> values) {
			addCriterion("XSWT_COUNT not in", values, "xswtCount");
			return (Criteria) this;
		}

		public Criteria andXswtCountBetween(Integer value1, Integer value2) {
			addCriterion("XSWT_COUNT between", value1, value2, "xswtCount");
			return (Criteria) this;
		}

		public Criteria andXswtCountNotBetween(Integer value1, Integer value2) {
			addCriterion("XSWT_COUNT not between", value1, value2, "xswtCount");
			return (Criteria) this;
		}

		public Criteria andBzwtCountIsNull() {
			addCriterion("BZWT_COUNT is null");
			return (Criteria) this;
		}

		public Criteria andBzwtCountIsNotNull() {
			addCriterion("BZWT_COUNT is not null");
			return (Criteria) this;
		}

		public Criteria andBzwtCountEqualTo(Integer value) {
			addCriterion("BZWT_COUNT =", value, "bzwtCount");
			return (Criteria) this;
		}

		public Criteria andBzwtCountNotEqualTo(Integer value) {
			addCriterion("BZWT_COUNT <>", value, "bzwtCount");
			return (Criteria) this;
		}

		public Criteria andBzwtCountGreaterThan(Integer value) {
			addCriterion("BZWT_COUNT >", value, "bzwtCount");
			return (Criteria) this;
		}

		public Criteria andBzwtCountGreaterThanOrEqualTo(Integer value) {
			addCriterion("BZWT_COUNT >=", value, "bzwtCount");
			return (Criteria) this;
		}

		public Criteria andBzwtCountLessThan(Integer value) {
			addCriterion("BZWT_COUNT <", value, "bzwtCount");
			return (Criteria) this;
		}

		public Criteria andBzwtCountLessThanOrEqualTo(Integer value) {
			addCriterion("BZWT_COUNT <=", value, "bzwtCount");
			return (Criteria) this;
		}

		public Criteria andBzwtCountIn(List<Integer> values) {
			addCriterion("BZWT_COUNT in", values, "bzwtCount");
			return (Criteria) this;
		}

		public Criteria andBzwtCountNotIn(List<Integer> values) {
			addCriterion("BZWT_COUNT not in", values, "bzwtCount");
			return (Criteria) this;
		}

		public Criteria andBzwtCountBetween(Integer value1, Integer value2) {
			addCriterion("BZWT_COUNT between", value1, value2, "bzwtCount");
			return (Criteria) this;
		}

		public Criteria andBzwtCountNotBetween(Integer value1, Integer value2) {
			addCriterion("BZWT_COUNT not between", value1, value2, "bzwtCount");
			return (Criteria) this;
		}

		public Criteria andWtCountIsNull() {
			addCriterion("WT_COUNT is null");
			return (Criteria) this;
		}

		public Criteria andWtCountIsNotNull() {
			addCriterion("WT_COUNT is not null");
			return (Criteria) this;
		}

		public Criteria andWtCountEqualTo(Integer value) {
			addCriterion("WT_COUNT =", value, "wtCount");
			return (Criteria) this;
		}

		public Criteria andWtCountNotEqualTo(Integer value) {
			addCriterion("WT_COUNT <>", value, "wtCount");
			return (Criteria) this;
		}

		public Criteria andWtCountGreaterThan(Integer value) {
			addCriterion("WT_COUNT >", value, "wtCount");
			return (Criteria) this;
		}

		public Criteria andWtCountGreaterThanOrEqualTo(Integer value) {
			addCriterion("WT_COUNT >=", value, "wtCount");
			return (Criteria) this;
		}

		public Criteria andWtCountLessThan(Integer value) {
			addCriterion("WT_COUNT <", value, "wtCount");
			return (Criteria) this;
		}

		public Criteria andWtCountLessThanOrEqualTo(Integer value) {
			addCriterion("WT_COUNT <=", value, "wtCount");
			return (Criteria) this;
		}

		public Criteria andWtCountIn(List<Integer> values) {
			addCriterion("WT_COUNT in", values, "wtCount");
			return (Criteria) this;
		}

		public Criteria andWtCountNotIn(List<Integer> values) {
			addCriterion("WT_COUNT not in", values, "wtCount");
			return (Criteria) this;
		}

		public Criteria andWtCountBetween(Integer value1, Integer value2) {
			addCriterion("WT_COUNT between", value1, value2, "wtCount");
			return (Criteria) this;
		}

		public Criteria andWtCountNotBetween(Integer value1, Integer value2) {
			addCriterion("WT_COUNT not between", value1, value2, "wtCount");
			return (Criteria) this;
		}

		public Criteria andRangeTypeIsNull() {
			addCriterion("RANGE_TYPE is null");
			return (Criteria) this;
		}

		public Criteria andRangeTypeIsNotNull() {
			addCriterion("RANGE_TYPE is not null");
			return (Criteria) this;
		}

		public Criteria andRangeTypeEqualTo(Byte value) {
			addCriterion("RANGE_TYPE =", value, "rangeType");
			return (Criteria) this;
		}

		public Criteria andRangeTypeNotEqualTo(Byte value) {
			addCriterion("RANGE_TYPE <>", value, "rangeType");
			return (Criteria) this;
		}

		public Criteria andRangeTypeGreaterThan(Byte value) {
			addCriterion("RANGE_TYPE >", value, "rangeType");
			return (Criteria) this;
		}

		public Criteria andRangeTypeGreaterThanOrEqualTo(Byte value) {
			addCriterion("RANGE_TYPE >=", value, "rangeType");
			return (Criteria) this;
		}

		public Criteria andRangeTypeLessThan(Byte value) {
			addCriterion("RANGE_TYPE <", value, "rangeType");
			return (Criteria) this;
		}

		public Criteria andRangeTypeLessThanOrEqualTo(Byte value) {
			addCriterion("RANGE_TYPE <=", value, "rangeType");
			return (Criteria) this;
		}

		public Criteria andRangeTypeIn(List<Byte> values) {
			addCriterion("RANGE_TYPE in", values, "rangeType");
			return (Criteria) this;
		}

		public Criteria andRangeTypeNotIn(List<Byte> values) {
			addCriterion("RANGE_TYPE not in", values, "rangeType");
			return (Criteria) this;
		}

		public Criteria andRangeTypeBetween(Byte value1, Byte value2) {
			addCriterion("RANGE_TYPE between", value1, value2, "rangeType");
			return (Criteria) this;
		}

		public Criteria andRangeTypeNotBetween(Byte value1, Byte value2) {
			addCriterion("RANGE_TYPE not between", value1, value2, "rangeType");
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

		public Criteria andUserPositionIsNull() {
			addCriterion("USER_POSITION is null");
			return (Criteria) this;
		}

		public Criteria andUserPositionIsNotNull() {
			addCriterion("USER_POSITION is not null");
			return (Criteria) this;
		}

		public Criteria andUserPositionEqualTo(String value) {
			addCriterion("USER_POSITION =", value, "userPosition");
			return (Criteria) this;
		}

		public Criteria andUserPositionNotEqualTo(String value) {
			addCriterion("USER_POSITION <>", value, "userPosition");
			return (Criteria) this;
		}

		public Criteria andUserPositionGreaterThan(String value) {
			addCriterion("USER_POSITION >", value, "userPosition");
			return (Criteria) this;
		}

		public Criteria andUserPositionGreaterThanOrEqualTo(String value) {
			addCriterion("USER_POSITION >=", value, "userPosition");
			return (Criteria) this;
		}

		public Criteria andUserPositionLessThan(String value) {
			addCriterion("USER_POSITION <", value, "userPosition");
			return (Criteria) this;
		}

		public Criteria andUserPositionLessThanOrEqualTo(String value) {
			addCriterion("USER_POSITION <=", value, "userPosition");
			return (Criteria) this;
		}

		public Criteria andUserPositionLike(String value) {
			addCriterion("USER_POSITION like", value, "userPosition");
			return (Criteria) this;
		}

		public Criteria andUserPositionNotLike(String value) {
			addCriterion("USER_POSITION not like", value, "userPosition");
			return (Criteria) this;
		}

		public Criteria andUserPositionIn(List<String> values) {
			addCriterion("USER_POSITION in", values, "userPosition");
			return (Criteria) this;
		}

		public Criteria andUserPositionNotIn(List<String> values) {
			addCriterion("USER_POSITION not in", values, "userPosition");
			return (Criteria) this;
		}

		public Criteria andUserPositionBetween(String value1, String value2) {
			addCriterion("USER_POSITION between", value1, value2, "userPosition");
			return (Criteria) this;
		}

		public Criteria andUserPositionNotBetween(String value1, String value2) {
			addCriterion("USER_POSITION not between", value1, value2, "userPosition");
			return (Criteria) this;
		}

		public Criteria andMtHouseCountIsNull() {
			addCriterion("MT_HOUSE_COUNT is null");
			return (Criteria) this;
		}

		public Criteria andMtHouseCountIsNotNull() {
			addCriterion("MT_HOUSE_COUNT is not null");
			return (Criteria) this;
		}

		public Criteria andMtHouseCountEqualTo(Integer value) {
			addCriterion("MT_HOUSE_COUNT =", value, "mtHouseCount");
			return (Criteria) this;
		}

		public Criteria andMtHouseCountNotEqualTo(Integer value) {
			addCriterion("MT_HOUSE_COUNT <>", value, "mtHouseCount");
			return (Criteria) this;
		}

		public Criteria andMtHouseCountGreaterThan(Integer value) {
			addCriterion("MT_HOUSE_COUNT >", value, "mtHouseCount");
			return (Criteria) this;
		}

		public Criteria andMtHouseCountGreaterThanOrEqualTo(Integer value) {
			addCriterion("MT_HOUSE_COUNT >=", value, "mtHouseCount");
			return (Criteria) this;
		}

		public Criteria andMtHouseCountLessThan(Integer value) {
			addCriterion("MT_HOUSE_COUNT <", value, "mtHouseCount");
			return (Criteria) this;
		}

		public Criteria andMtHouseCountLessThanOrEqualTo(Integer value) {
			addCriterion("MT_HOUSE_COUNT <=", value, "mtHouseCount");
			return (Criteria) this;
		}

		public Criteria andMtHouseCountIn(List<Integer> values) {
			addCriterion("MT_HOUSE_COUNT in", values, "mtHouseCount");
			return (Criteria) this;
		}

		public Criteria andMtHouseCountNotIn(List<Integer> values) {
			addCriterion("MT_HOUSE_COUNT not in", values, "mtHouseCount");
			return (Criteria) this;
		}

		public Criteria andMtHouseCountBetween(Integer value1, Integer value2) {
			addCriterion("MT_HOUSE_COUNT between", value1, value2, "mtHouseCount");
			return (Criteria) this;
		}

		public Criteria andMtHouseCountNotBetween(Integer value1, Integer value2) {
			addCriterion("MT_HOUSE_COUNT not between", value1, value2, "mtHouseCount");
			return (Criteria) this;
		}

		public Criteria andMtCustomerCountIsNull() {
			addCriterion("MT_CUSTOMER_COUNT is null");
			return (Criteria) this;
		}

		public Criteria andMtCustomerCountIsNotNull() {
			addCriterion("MT_CUSTOMER_COUNT is not null");
			return (Criteria) this;
		}

		public Criteria andMtCustomerCountEqualTo(Integer value) {
			addCriterion("MT_CUSTOMER_COUNT =", value, "mtCustomerCount");
			return (Criteria) this;
		}

		public Criteria andMtCustomerCountNotEqualTo(Integer value) {
			addCriterion("MT_CUSTOMER_COUNT <>", value, "mtCustomerCount");
			return (Criteria) this;
		}

		public Criteria andMtCustomerCountGreaterThan(Integer value) {
			addCriterion("MT_CUSTOMER_COUNT >", value, "mtCustomerCount");
			return (Criteria) this;
		}

		public Criteria andMtCustomerCountGreaterThanOrEqualTo(Integer value) {
			addCriterion("MT_CUSTOMER_COUNT >=", value, "mtCustomerCount");
			return (Criteria) this;
		}

		public Criteria andMtCustomerCountLessThan(Integer value) {
			addCriterion("MT_CUSTOMER_COUNT <", value, "mtCustomerCount");
			return (Criteria) this;
		}

		public Criteria andMtCustomerCountLessThanOrEqualTo(Integer value) {
			addCriterion("MT_CUSTOMER_COUNT <=", value, "mtCustomerCount");
			return (Criteria) this;
		}

		public Criteria andMtCustomerCountIn(List<Integer> values) {
			addCriterion("MT_CUSTOMER_COUNT in", values, "mtCustomerCount");
			return (Criteria) this;
		}

		public Criteria andMtCustomerCountNotIn(List<Integer> values) {
			addCriterion("MT_CUSTOMER_COUNT not in", values, "mtCustomerCount");
			return (Criteria) this;
		}

		public Criteria andMtCustomerCountBetween(Integer value1, Integer value2) {
			addCriterion("MT_CUSTOMER_COUNT between", value1, value2, "mtCustomerCount");
			return (Criteria) this;
		}

		public Criteria andMtCustomerCountNotBetween(Integer value1, Integer value2) {
			addCriterion("MT_CUSTOMER_COUNT not between", value1, value2, "mtCustomerCount");
			return (Criteria) this;
		}

		public Criteria andKyykCountIsNull() {
			addCriterion("KYYK_COUNT is null");
			return (Criteria) this;
		}

		public Criteria andKyykCountIsNotNull() {
			addCriterion("KYYK_COUNT is not null");
			return (Criteria) this;
		}

		public Criteria andKyykCountEqualTo(Integer value) {
			addCriterion("KYYK_COUNT =", value, "kyykCount");
			return (Criteria) this;
		}

		public Criteria andKyykCountNotEqualTo(Integer value) {
			addCriterion("KYYK_COUNT <>", value, "kyykCount");
			return (Criteria) this;
		}

		public Criteria andKyykCountGreaterThan(Integer value) {
			addCriterion("KYYK_COUNT >", value, "kyykCount");
			return (Criteria) this;
		}

		public Criteria andKyykCountGreaterThanOrEqualTo(Integer value) {
			addCriterion("KYYK_COUNT >=", value, "kyykCount");
			return (Criteria) this;
		}

		public Criteria andKyykCountLessThan(Integer value) {
			addCriterion("KYYK_COUNT <", value, "kyykCount");
			return (Criteria) this;
		}

		public Criteria andKyykCountLessThanOrEqualTo(Integer value) {
			addCriterion("KYYK_COUNT <=", value, "kyykCount");
			return (Criteria) this;
		}

		public Criteria andKyykCountIn(List<Integer> values) {
			addCriterion("KYYK_COUNT in", values, "kyykCount");
			return (Criteria) this;
		}

		public Criteria andKyykCountNotIn(List<Integer> values) {
			addCriterion("KYYK_COUNT not in", values, "kyykCount");
			return (Criteria) this;
		}

		public Criteria andKyykCountBetween(Integer value1, Integer value2) {
			addCriterion("KYYK_COUNT between", value1, value2, "kyykCount");
			return (Criteria) this;
		}

		public Criteria andKyykCountNotBetween(Integer value1, Integer value2) {
			addCriterion("KYYK_COUNT not between", value1, value2, "kyykCount");
			return (Criteria) this;
		}

		public Criteria andYjCountIsNull() {
			addCriterion("YJ_COUNT is null");
			return (Criteria) this;
		}

		public Criteria andYjCountIsNotNull() {
			addCriterion("YJ_COUNT is not null");
			return (Criteria) this;
		}

		public Criteria andYjCountEqualTo(Integer value) {
			addCriterion("YJ_COUNT =", value, "yjCount");
			return (Criteria) this;
		}

		public Criteria andYjCountNotEqualTo(Integer value) {
			addCriterion("YJ_COUNT <>", value, "yjCount");
			return (Criteria) this;
		}

		public Criteria andYjCountGreaterThan(Integer value) {
			addCriterion("YJ_COUNT >", value, "yjCount");
			return (Criteria) this;
		}

		public Criteria andYjCountGreaterThanOrEqualTo(Integer value) {
			addCriterion("YJ_COUNT >=", value, "yjCount");
			return (Criteria) this;
		}

		public Criteria andYjCountLessThan(Integer value) {
			addCriterion("YJ_COUNT <", value, "yjCount");
			return (Criteria) this;
		}

		public Criteria andYjCountLessThanOrEqualTo(Integer value) {
			addCriterion("YJ_COUNT <=", value, "yjCount");
			return (Criteria) this;
		}

		public Criteria andYjCountIn(List<Integer> values) {
			addCriterion("YJ_COUNT in", values, "yjCount");
			return (Criteria) this;
		}

		public Criteria andYjCountNotIn(List<Integer> values) {
			addCriterion("YJ_COUNT not in", values, "yjCount");
			return (Criteria) this;
		}

		public Criteria andYjCountBetween(Integer value1, Integer value2) {
			addCriterion("YJ_COUNT between", value1, value2, "yjCount");
			return (Criteria) this;
		}

		public Criteria andYjCountNotBetween(Integer value1, Integer value2) {
			addCriterion("YJ_COUNT not between", value1, value2, "yjCount");
			return (Criteria) this;
		}

		public Criteria andIpcallCountIsNull() {
			addCriterion("IPCALL_COUNT is null");
			return (Criteria) this;
		}

		public Criteria andIpcallCountIsNotNull() {
			addCriterion("IPCALL_COUNT is not null");
			return (Criteria) this;
		}

		public Criteria andIpcallCountEqualTo(Integer value) {
			addCriterion("IPCALL_COUNT =", value, "ipcallCount");
			return (Criteria) this;
		}

		public Criteria andIpcallCountNotEqualTo(Integer value) {
			addCriterion("IPCALL_COUNT <>", value, "ipcallCount");
			return (Criteria) this;
		}

		public Criteria andIpcallCountGreaterThan(Integer value) {
			addCriterion("IPCALL_COUNT >", value, "ipcallCount");
			return (Criteria) this;
		}

		public Criteria andIpcallCountGreaterThanOrEqualTo(Integer value) {
			addCriterion("IPCALL_COUNT >=", value, "ipcallCount");
			return (Criteria) this;
		}

		public Criteria andIpcallCountLessThan(Integer value) {
			addCriterion("IPCALL_COUNT <", value, "ipcallCount");
			return (Criteria) this;
		}

		public Criteria andIpcallCountLessThanOrEqualTo(Integer value) {
			addCriterion("IPCALL_COUNT <=", value, "ipcallCount");
			return (Criteria) this;
		}

		public Criteria andIpcallCountIn(List<Integer> values) {
			addCriterion("IPCALL_COUNT in", values, "ipcallCount");
			return (Criteria) this;
		}

		public Criteria andIpcallCountNotIn(List<Integer> values) {
			addCriterion("IPCALL_COUNT not in", values, "ipcallCount");
			return (Criteria) this;
		}

		public Criteria andIpcallCountBetween(Integer value1, Integer value2) {
			addCriterion("IPCALL_COUNT between", value1, value2, "ipcallCount");
			return (Criteria) this;
		}

		public Criteria andIpcallCountNotBetween(Integer value1, Integer value2) {
			addCriterion("IPCALL_COUNT not between", value1, value2, "ipcallCount");
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