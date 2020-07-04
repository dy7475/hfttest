package com.myfun.repository.erpdb.po;

import com.myfun.repository.support.generator.shard.ShardDb;
import java.util.ArrayList;
import java.util.List;

public class ErpDicDefinitionsExample extends ShardDb {
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
	public ErpDicDefinitionsExample() {
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

		public Criteria andDicIdIsNull() {
			addCriterion("DIC_ID is null");
			return (Criteria) this;
		}

		public Criteria andDicIdIsNotNull() {
			addCriterion("DIC_ID is not null");
			return (Criteria) this;
		}

		public Criteria andDicIdEqualTo(Short value) {
			addCriterion("DIC_ID =", value, "dicId");
			return (Criteria) this;
		}

		public Criteria andDicIdNotEqualTo(Short value) {
			addCriterion("DIC_ID <>", value, "dicId");
			return (Criteria) this;
		}

		public Criteria andDicIdGreaterThan(Short value) {
			addCriterion("DIC_ID >", value, "dicId");
			return (Criteria) this;
		}

		public Criteria andDicIdGreaterThanOrEqualTo(Short value) {
			addCriterion("DIC_ID >=", value, "dicId");
			return (Criteria) this;
		}

		public Criteria andDicIdLessThan(Short value) {
			addCriterion("DIC_ID <", value, "dicId");
			return (Criteria) this;
		}

		public Criteria andDicIdLessThanOrEqualTo(Short value) {
			addCriterion("DIC_ID <=", value, "dicId");
			return (Criteria) this;
		}

		public Criteria andDicIdIn(List<Short> values) {
			addCriterion("DIC_ID in", values, "dicId");
			return (Criteria) this;
		}

		public Criteria andDicIdNotIn(List<Short> values) {
			addCriterion("DIC_ID not in", values, "dicId");
			return (Criteria) this;
		}

		public Criteria andDicIdBetween(Short value1, Short value2) {
			addCriterion("DIC_ID between", value1, value2, "dicId");
			return (Criteria) this;
		}

		public Criteria andDicIdNotBetween(Short value1, Short value2) {
			addCriterion("DIC_ID not between", value1, value2, "dicId");
			return (Criteria) this;
		}

		public Criteria andDicGroupTypeIsNull() {
			addCriterion("DIC_GROUP_TYPE is null");
			return (Criteria) this;
		}

		public Criteria andDicGroupTypeIsNotNull() {
			addCriterion("DIC_GROUP_TYPE is not null");
			return (Criteria) this;
		}

		public Criteria andDicGroupTypeEqualTo(String value) {
			addCriterion("DIC_GROUP_TYPE =", value, "dicGroupType");
			return (Criteria) this;
		}

		public Criteria andDicGroupTypeNotEqualTo(String value) {
			addCriterion("DIC_GROUP_TYPE <>", value, "dicGroupType");
			return (Criteria) this;
		}

		public Criteria andDicGroupTypeGreaterThan(String value) {
			addCriterion("DIC_GROUP_TYPE >", value, "dicGroupType");
			return (Criteria) this;
		}

		public Criteria andDicGroupTypeGreaterThanOrEqualTo(String value) {
			addCriterion("DIC_GROUP_TYPE >=", value, "dicGroupType");
			return (Criteria) this;
		}

		public Criteria andDicGroupTypeLessThan(String value) {
			addCriterion("DIC_GROUP_TYPE <", value, "dicGroupType");
			return (Criteria) this;
		}

		public Criteria andDicGroupTypeLessThanOrEqualTo(String value) {
			addCriterion("DIC_GROUP_TYPE <=", value, "dicGroupType");
			return (Criteria) this;
		}

		public Criteria andDicGroupTypeLike(String value) {
			addCriterion("DIC_GROUP_TYPE like", value, "dicGroupType");
			return (Criteria) this;
		}

		public Criteria andDicGroupTypeNotLike(String value) {
			addCriterion("DIC_GROUP_TYPE not like", value, "dicGroupType");
			return (Criteria) this;
		}

		public Criteria andDicGroupTypeIn(List<String> values) {
			addCriterion("DIC_GROUP_TYPE in", values, "dicGroupType");
			return (Criteria) this;
		}

		public Criteria andDicGroupTypeNotIn(List<String> values) {
			addCriterion("DIC_GROUP_TYPE not in", values, "dicGroupType");
			return (Criteria) this;
		}

		public Criteria andDicGroupTypeBetween(String value1, String value2) {
			addCriterion("DIC_GROUP_TYPE between", value1, value2, "dicGroupType");
			return (Criteria) this;
		}

		public Criteria andDicGroupTypeNotBetween(String value1, String value2) {
			addCriterion("DIC_GROUP_TYPE not between", value1, value2, "dicGroupType");
			return (Criteria) this;
		}

		public Criteria andDicTypeIsNull() {
			addCriterion("DIC_TYPE is null");
			return (Criteria) this;
		}

		public Criteria andDicTypeIsNotNull() {
			addCriterion("DIC_TYPE is not null");
			return (Criteria) this;
		}

		public Criteria andDicTypeEqualTo(String value) {
			addCriterion("DIC_TYPE =", value, "dicType");
			return (Criteria) this;
		}

		public Criteria andDicTypeNotEqualTo(String value) {
			addCriterion("DIC_TYPE <>", value, "dicType");
			return (Criteria) this;
		}

		public Criteria andDicTypeGreaterThan(String value) {
			addCriterion("DIC_TYPE >", value, "dicType");
			return (Criteria) this;
		}

		public Criteria andDicTypeGreaterThanOrEqualTo(String value) {
			addCriterion("DIC_TYPE >=", value, "dicType");
			return (Criteria) this;
		}

		public Criteria andDicTypeLessThan(String value) {
			addCriterion("DIC_TYPE <", value, "dicType");
			return (Criteria) this;
		}

		public Criteria andDicTypeLessThanOrEqualTo(String value) {
			addCriterion("DIC_TYPE <=", value, "dicType");
			return (Criteria) this;
		}

		public Criteria andDicTypeLike(String value) {
			addCriterion("DIC_TYPE like", value, "dicType");
			return (Criteria) this;
		}

		public Criteria andDicTypeNotLike(String value) {
			addCriterion("DIC_TYPE not like", value, "dicType");
			return (Criteria) this;
		}

		public Criteria andDicTypeIn(List<String> values) {
			addCriterion("DIC_TYPE in", values, "dicType");
			return (Criteria) this;
		}

		public Criteria andDicTypeNotIn(List<String> values) {
			addCriterion("DIC_TYPE not in", values, "dicType");
			return (Criteria) this;
		}

		public Criteria andDicTypeBetween(String value1, String value2) {
			addCriterion("DIC_TYPE between", value1, value2, "dicType");
			return (Criteria) this;
		}

		public Criteria andDicTypeNotBetween(String value1, String value2) {
			addCriterion("DIC_TYPE not between", value1, value2, "dicType");
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

		public Criteria andProvinceIdEqualTo(Short value) {
			addCriterion("PROVINCE_ID =", value, "provinceId");
			return (Criteria) this;
		}

		public Criteria andProvinceIdNotEqualTo(Short value) {
			addCriterion("PROVINCE_ID <>", value, "provinceId");
			return (Criteria) this;
		}

		public Criteria andProvinceIdGreaterThan(Short value) {
			addCriterion("PROVINCE_ID >", value, "provinceId");
			return (Criteria) this;
		}

		public Criteria andProvinceIdGreaterThanOrEqualTo(Short value) {
			addCriterion("PROVINCE_ID >=", value, "provinceId");
			return (Criteria) this;
		}

		public Criteria andProvinceIdLessThan(Short value) {
			addCriterion("PROVINCE_ID <", value, "provinceId");
			return (Criteria) this;
		}

		public Criteria andProvinceIdLessThanOrEqualTo(Short value) {
			addCriterion("PROVINCE_ID <=", value, "provinceId");
			return (Criteria) this;
		}

		public Criteria andProvinceIdIn(List<Short> values) {
			addCriterion("PROVINCE_ID in", values, "provinceId");
			return (Criteria) this;
		}

		public Criteria andProvinceIdNotIn(List<Short> values) {
			addCriterion("PROVINCE_ID not in", values, "provinceId");
			return (Criteria) this;
		}

		public Criteria andProvinceIdBetween(Short value1, Short value2) {
			addCriterion("PROVINCE_ID between", value1, value2, "provinceId");
			return (Criteria) this;
		}

		public Criteria andProvinceIdNotBetween(Short value1, Short value2) {
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

		public Criteria andCityIdEqualTo(Short value) {
			addCriterion("CITY_ID =", value, "cityId");
			return (Criteria) this;
		}

		public Criteria andCityIdNotEqualTo(Short value) {
			addCriterion("CITY_ID <>", value, "cityId");
			return (Criteria) this;
		}

		public Criteria andCityIdGreaterThan(Short value) {
			addCriterion("CITY_ID >", value, "cityId");
			return (Criteria) this;
		}

		public Criteria andCityIdGreaterThanOrEqualTo(Short value) {
			addCriterion("CITY_ID >=", value, "cityId");
			return (Criteria) this;
		}

		public Criteria andCityIdLessThan(Short value) {
			addCriterion("CITY_ID <", value, "cityId");
			return (Criteria) this;
		}

		public Criteria andCityIdLessThanOrEqualTo(Short value) {
			addCriterion("CITY_ID <=", value, "cityId");
			return (Criteria) this;
		}

		public Criteria andCityIdIn(List<Short> values) {
			addCriterion("CITY_ID in", values, "cityId");
			return (Criteria) this;
		}

		public Criteria andCityIdNotIn(List<Short> values) {
			addCriterion("CITY_ID not in", values, "cityId");
			return (Criteria) this;
		}

		public Criteria andCityIdBetween(Short value1, Short value2) {
			addCriterion("CITY_ID between", value1, value2, "cityId");
			return (Criteria) this;
		}

		public Criteria andCityIdNotBetween(Short value1, Short value2) {
			addCriterion("CITY_ID not between", value1, value2, "cityId");
			return (Criteria) this;
		}

		public Criteria andSeqNoIsNull() {
			addCriterion("SEQ_NO is null");
			return (Criteria) this;
		}

		public Criteria andSeqNoIsNotNull() {
			addCriterion("SEQ_NO is not null");
			return (Criteria) this;
		}

		public Criteria andSeqNoEqualTo(Byte value) {
			addCriterion("SEQ_NO =", value, "seqNo");
			return (Criteria) this;
		}

		public Criteria andSeqNoNotEqualTo(Byte value) {
			addCriterion("SEQ_NO <>", value, "seqNo");
			return (Criteria) this;
		}

		public Criteria andSeqNoGreaterThan(Byte value) {
			addCriterion("SEQ_NO >", value, "seqNo");
			return (Criteria) this;
		}

		public Criteria andSeqNoGreaterThanOrEqualTo(Byte value) {
			addCriterion("SEQ_NO >=", value, "seqNo");
			return (Criteria) this;
		}

		public Criteria andSeqNoLessThan(Byte value) {
			addCriterion("SEQ_NO <", value, "seqNo");
			return (Criteria) this;
		}

		public Criteria andSeqNoLessThanOrEqualTo(Byte value) {
			addCriterion("SEQ_NO <=", value, "seqNo");
			return (Criteria) this;
		}

		public Criteria andSeqNoIn(List<Byte> values) {
			addCriterion("SEQ_NO in", values, "seqNo");
			return (Criteria) this;
		}

		public Criteria andSeqNoNotIn(List<Byte> values) {
			addCriterion("SEQ_NO not in", values, "seqNo");
			return (Criteria) this;
		}

		public Criteria andSeqNoBetween(Byte value1, Byte value2) {
			addCriterion("SEQ_NO between", value1, value2, "seqNo");
			return (Criteria) this;
		}

		public Criteria andSeqNoNotBetween(Byte value1, Byte value2) {
			addCriterion("SEQ_NO not between", value1, value2, "seqNo");
			return (Criteria) this;
		}

		public Criteria andDicValueIsNull() {
			addCriterion("DIC_VALUE is null");
			return (Criteria) this;
		}

		public Criteria andDicValueIsNotNull() {
			addCriterion("DIC_VALUE is not null");
			return (Criteria) this;
		}

		public Criteria andDicValueEqualTo(String value) {
			addCriterion("DIC_VALUE =", value, "dicValue");
			return (Criteria) this;
		}

		public Criteria andDicValueNotEqualTo(String value) {
			addCriterion("DIC_VALUE <>", value, "dicValue");
			return (Criteria) this;
		}

		public Criteria andDicValueGreaterThan(String value) {
			addCriterion("DIC_VALUE >", value, "dicValue");
			return (Criteria) this;
		}

		public Criteria andDicValueGreaterThanOrEqualTo(String value) {
			addCriterion("DIC_VALUE >=", value, "dicValue");
			return (Criteria) this;
		}

		public Criteria andDicValueLessThan(String value) {
			addCriterion("DIC_VALUE <", value, "dicValue");
			return (Criteria) this;
		}

		public Criteria andDicValueLessThanOrEqualTo(String value) {
			addCriterion("DIC_VALUE <=", value, "dicValue");
			return (Criteria) this;
		}

		public Criteria andDicValueLike(String value) {
			addCriterion("DIC_VALUE like", value, "dicValue");
			return (Criteria) this;
		}

		public Criteria andDicValueNotLike(String value) {
			addCriterion("DIC_VALUE not like", value, "dicValue");
			return (Criteria) this;
		}

		public Criteria andDicValueIn(List<String> values) {
			addCriterion("DIC_VALUE in", values, "dicValue");
			return (Criteria) this;
		}

		public Criteria andDicValueNotIn(List<String> values) {
			addCriterion("DIC_VALUE not in", values, "dicValue");
			return (Criteria) this;
		}

		public Criteria andDicValueBetween(String value1, String value2) {
			addCriterion("DIC_VALUE between", value1, value2, "dicValue");
			return (Criteria) this;
		}

		public Criteria andDicValueNotBetween(String value1, String value2) {
			addCriterion("DIC_VALUE not between", value1, value2, "dicValue");
			return (Criteria) this;
		}

		public Criteria andDicValue1IsNull() {
			addCriterion("DIC_VALUE_1 is null");
			return (Criteria) this;
		}

		public Criteria andDicValue1IsNotNull() {
			addCriterion("DIC_VALUE_1 is not null");
			return (Criteria) this;
		}

		public Criteria andDicValue1EqualTo(String value) {
			addCriterion("DIC_VALUE_1 =", value, "dicValue1");
			return (Criteria) this;
		}

		public Criteria andDicValue1NotEqualTo(String value) {
			addCriterion("DIC_VALUE_1 <>", value, "dicValue1");
			return (Criteria) this;
		}

		public Criteria andDicValue1GreaterThan(String value) {
			addCriterion("DIC_VALUE_1 >", value, "dicValue1");
			return (Criteria) this;
		}

		public Criteria andDicValue1GreaterThanOrEqualTo(String value) {
			addCriterion("DIC_VALUE_1 >=", value, "dicValue1");
			return (Criteria) this;
		}

		public Criteria andDicValue1LessThan(String value) {
			addCriterion("DIC_VALUE_1 <", value, "dicValue1");
			return (Criteria) this;
		}

		public Criteria andDicValue1LessThanOrEqualTo(String value) {
			addCriterion("DIC_VALUE_1 <=", value, "dicValue1");
			return (Criteria) this;
		}

		public Criteria andDicValue1Like(String value) {
			addCriterion("DIC_VALUE_1 like", value, "dicValue1");
			return (Criteria) this;
		}

		public Criteria andDicValue1NotLike(String value) {
			addCriterion("DIC_VALUE_1 not like", value, "dicValue1");
			return (Criteria) this;
		}

		public Criteria andDicValue1In(List<String> values) {
			addCriterion("DIC_VALUE_1 in", values, "dicValue1");
			return (Criteria) this;
		}

		public Criteria andDicValue1NotIn(List<String> values) {
			addCriterion("DIC_VALUE_1 not in", values, "dicValue1");
			return (Criteria) this;
		}

		public Criteria andDicValue1Between(String value1, String value2) {
			addCriterion("DIC_VALUE_1 between", value1, value2, "dicValue1");
			return (Criteria) this;
		}

		public Criteria andDicValue1NotBetween(String value1, String value2) {
			addCriterion("DIC_VALUE_1 not between", value1, value2, "dicValue1");
			return (Criteria) this;
		}

		public Criteria andDicEnMsgIsNull() {
			addCriterion("DIC_EN_MSG is null");
			return (Criteria) this;
		}

		public Criteria andDicEnMsgIsNotNull() {
			addCriterion("DIC_EN_MSG is not null");
			return (Criteria) this;
		}

		public Criteria andDicEnMsgEqualTo(String value) {
			addCriterion("DIC_EN_MSG =", value, "dicEnMsg");
			return (Criteria) this;
		}

		public Criteria andDicEnMsgNotEqualTo(String value) {
			addCriterion("DIC_EN_MSG <>", value, "dicEnMsg");
			return (Criteria) this;
		}

		public Criteria andDicEnMsgGreaterThan(String value) {
			addCriterion("DIC_EN_MSG >", value, "dicEnMsg");
			return (Criteria) this;
		}

		public Criteria andDicEnMsgGreaterThanOrEqualTo(String value) {
			addCriterion("DIC_EN_MSG >=", value, "dicEnMsg");
			return (Criteria) this;
		}

		public Criteria andDicEnMsgLessThan(String value) {
			addCriterion("DIC_EN_MSG <", value, "dicEnMsg");
			return (Criteria) this;
		}

		public Criteria andDicEnMsgLessThanOrEqualTo(String value) {
			addCriterion("DIC_EN_MSG <=", value, "dicEnMsg");
			return (Criteria) this;
		}

		public Criteria andDicEnMsgLike(String value) {
			addCriterion("DIC_EN_MSG like", value, "dicEnMsg");
			return (Criteria) this;
		}

		public Criteria andDicEnMsgNotLike(String value) {
			addCriterion("DIC_EN_MSG not like", value, "dicEnMsg");
			return (Criteria) this;
		}

		public Criteria andDicEnMsgIn(List<String> values) {
			addCriterion("DIC_EN_MSG in", values, "dicEnMsg");
			return (Criteria) this;
		}

		public Criteria andDicEnMsgNotIn(List<String> values) {
			addCriterion("DIC_EN_MSG not in", values, "dicEnMsg");
			return (Criteria) this;
		}

		public Criteria andDicEnMsgBetween(String value1, String value2) {
			addCriterion("DIC_EN_MSG between", value1, value2, "dicEnMsg");
			return (Criteria) this;
		}

		public Criteria andDicEnMsgNotBetween(String value1, String value2) {
			addCriterion("DIC_EN_MSG not between", value1, value2, "dicEnMsg");
			return (Criteria) this;
		}

		public Criteria andDicCnMsgIsNull() {
			addCriterion("DIC_CN_MSG is null");
			return (Criteria) this;
		}

		public Criteria andDicCnMsgIsNotNull() {
			addCriterion("DIC_CN_MSG is not null");
			return (Criteria) this;
		}

		public Criteria andDicCnMsgEqualTo(String value) {
			addCriterion("DIC_CN_MSG =", value, "dicCnMsg");
			return (Criteria) this;
		}

		public Criteria andDicCnMsgNotEqualTo(String value) {
			addCriterion("DIC_CN_MSG <>", value, "dicCnMsg");
			return (Criteria) this;
		}

		public Criteria andDicCnMsgGreaterThan(String value) {
			addCriterion("DIC_CN_MSG >", value, "dicCnMsg");
			return (Criteria) this;
		}

		public Criteria andDicCnMsgGreaterThanOrEqualTo(String value) {
			addCriterion("DIC_CN_MSG >=", value, "dicCnMsg");
			return (Criteria) this;
		}

		public Criteria andDicCnMsgLessThan(String value) {
			addCriterion("DIC_CN_MSG <", value, "dicCnMsg");
			return (Criteria) this;
		}

		public Criteria andDicCnMsgLessThanOrEqualTo(String value) {
			addCriterion("DIC_CN_MSG <=", value, "dicCnMsg");
			return (Criteria) this;
		}

		public Criteria andDicCnMsgLike(String value) {
			addCriterion("DIC_CN_MSG like", value, "dicCnMsg");
			return (Criteria) this;
		}

		public Criteria andDicCnMsgNotLike(String value) {
			addCriterion("DIC_CN_MSG not like", value, "dicCnMsg");
			return (Criteria) this;
		}

		public Criteria andDicCnMsgIn(List<String> values) {
			addCriterion("DIC_CN_MSG in", values, "dicCnMsg");
			return (Criteria) this;
		}

		public Criteria andDicCnMsgNotIn(List<String> values) {
			addCriterion("DIC_CN_MSG not in", values, "dicCnMsg");
			return (Criteria) this;
		}

		public Criteria andDicCnMsgBetween(String value1, String value2) {
			addCriterion("DIC_CN_MSG between", value1, value2, "dicCnMsg");
			return (Criteria) this;
		}

		public Criteria andDicCnMsgNotBetween(String value1, String value2) {
			addCriterion("DIC_CN_MSG not between", value1, value2, "dicCnMsg");
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

		public Criteria andUpdateTimeEqualTo(String value) {
			addCriterion("UPDATE_TIME =", value, "updateTime");
			return (Criteria) this;
		}

		public Criteria andUpdateTimeNotEqualTo(String value) {
			addCriterion("UPDATE_TIME <>", value, "updateTime");
			return (Criteria) this;
		}

		public Criteria andUpdateTimeGreaterThan(String value) {
			addCriterion("UPDATE_TIME >", value, "updateTime");
			return (Criteria) this;
		}

		public Criteria andUpdateTimeGreaterThanOrEqualTo(String value) {
			addCriterion("UPDATE_TIME >=", value, "updateTime");
			return (Criteria) this;
		}

		public Criteria andUpdateTimeLessThan(String value) {
			addCriterion("UPDATE_TIME <", value, "updateTime");
			return (Criteria) this;
		}

		public Criteria andUpdateTimeLessThanOrEqualTo(String value) {
			addCriterion("UPDATE_TIME <=", value, "updateTime");
			return (Criteria) this;
		}

		public Criteria andUpdateTimeLike(String value) {
			addCriterion("UPDATE_TIME like", value, "updateTime");
			return (Criteria) this;
		}

		public Criteria andUpdateTimeNotLike(String value) {
			addCriterion("UPDATE_TIME not like", value, "updateTime");
			return (Criteria) this;
		}

		public Criteria andUpdateTimeIn(List<String> values) {
			addCriterion("UPDATE_TIME in", values, "updateTime");
			return (Criteria) this;
		}

		public Criteria andUpdateTimeNotIn(List<String> values) {
			addCriterion("UPDATE_TIME not in", values, "updateTime");
			return (Criteria) this;
		}

		public Criteria andUpdateTimeBetween(String value1, String value2) {
			addCriterion("UPDATE_TIME between", value1, value2, "updateTime");
			return (Criteria) this;
		}

		public Criteria andUpdateTimeNotBetween(String value1, String value2) {
			addCriterion("UPDATE_TIME not between", value1, value2, "updateTime");
			return (Criteria) this;
		}

		public Criteria andDicCnMsg2IsNull() {
			addCriterion("DIC_CN_MSG2 is null");
			return (Criteria) this;
		}

		public Criteria andDicCnMsg2IsNotNull() {
			addCriterion("DIC_CN_MSG2 is not null");
			return (Criteria) this;
		}

		public Criteria andDicCnMsg2EqualTo(String value) {
			addCriterion("DIC_CN_MSG2 =", value, "dicCnMsg2");
			return (Criteria) this;
		}

		public Criteria andDicCnMsg2NotEqualTo(String value) {
			addCriterion("DIC_CN_MSG2 <>", value, "dicCnMsg2");
			return (Criteria) this;
		}

		public Criteria andDicCnMsg2GreaterThan(String value) {
			addCriterion("DIC_CN_MSG2 >", value, "dicCnMsg2");
			return (Criteria) this;
		}

		public Criteria andDicCnMsg2GreaterThanOrEqualTo(String value) {
			addCriterion("DIC_CN_MSG2 >=", value, "dicCnMsg2");
			return (Criteria) this;
		}

		public Criteria andDicCnMsg2LessThan(String value) {
			addCriterion("DIC_CN_MSG2 <", value, "dicCnMsg2");
			return (Criteria) this;
		}

		public Criteria andDicCnMsg2LessThanOrEqualTo(String value) {
			addCriterion("DIC_CN_MSG2 <=", value, "dicCnMsg2");
			return (Criteria) this;
		}

		public Criteria andDicCnMsg2Like(String value) {
			addCriterion("DIC_CN_MSG2 like", value, "dicCnMsg2");
			return (Criteria) this;
		}

		public Criteria andDicCnMsg2NotLike(String value) {
			addCriterion("DIC_CN_MSG2 not like", value, "dicCnMsg2");
			return (Criteria) this;
		}

		public Criteria andDicCnMsg2In(List<String> values) {
			addCriterion("DIC_CN_MSG2 in", values, "dicCnMsg2");
			return (Criteria) this;
		}

		public Criteria andDicCnMsg2NotIn(List<String> values) {
			addCriterion("DIC_CN_MSG2 not in", values, "dicCnMsg2");
			return (Criteria) this;
		}

		public Criteria andDicCnMsg2Between(String value1, String value2) {
			addCriterion("DIC_CN_MSG2 between", value1, value2, "dicCnMsg2");
			return (Criteria) this;
		}

		public Criteria andDicCnMsg2NotBetween(String value1, String value2) {
			addCriterion("DIC_CN_MSG2 not between", value1, value2, "dicCnMsg2");
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

		public Criteria andDicValue2IsNull() {
			addCriterion("DIC_VALUE_2 is null");
			return (Criteria) this;
		}

		public Criteria andDicValue2IsNotNull() {
			addCriterion("DIC_VALUE_2 is not null");
			return (Criteria) this;
		}

		public Criteria andDicValue2EqualTo(String value) {
			addCriterion("DIC_VALUE_2 =", value, "dicValue2");
			return (Criteria) this;
		}

		public Criteria andDicValue2NotEqualTo(String value) {
			addCriterion("DIC_VALUE_2 <>", value, "dicValue2");
			return (Criteria) this;
		}

		public Criteria andDicValue2GreaterThan(String value) {
			addCriterion("DIC_VALUE_2 >", value, "dicValue2");
			return (Criteria) this;
		}

		public Criteria andDicValue2GreaterThanOrEqualTo(String value) {
			addCriterion("DIC_VALUE_2 >=", value, "dicValue2");
			return (Criteria) this;
		}

		public Criteria andDicValue2LessThan(String value) {
			addCriterion("DIC_VALUE_2 <", value, "dicValue2");
			return (Criteria) this;
		}

		public Criteria andDicValue2LessThanOrEqualTo(String value) {
			addCriterion("DIC_VALUE_2 <=", value, "dicValue2");
			return (Criteria) this;
		}

		public Criteria andDicValue2Like(String value) {
			addCriterion("DIC_VALUE_2 like", value, "dicValue2");
			return (Criteria) this;
		}

		public Criteria andDicValue2NotLike(String value) {
			addCriterion("DIC_VALUE_2 not like", value, "dicValue2");
			return (Criteria) this;
		}

		public Criteria andDicValue2In(List<String> values) {
			addCriterion("DIC_VALUE_2 in", values, "dicValue2");
			return (Criteria) this;
		}

		public Criteria andDicValue2NotIn(List<String> values) {
			addCriterion("DIC_VALUE_2 not in", values, "dicValue2");
			return (Criteria) this;
		}

		public Criteria andDicValue2Between(String value1, String value2) {
			addCriterion("DIC_VALUE_2 between", value1, value2, "dicValue2");
			return (Criteria) this;
		}

		public Criteria andDicValue2NotBetween(String value1, String value2) {
			addCriterion("DIC_VALUE_2 not between", value1, value2, "dicValue2");
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