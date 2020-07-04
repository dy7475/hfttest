package com.myfun.repository.erpdb.po;

import com.myfun.repository.support.generator.shard.ShardDb;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ErpFunEntrustOwnersExample extends ShardDb {
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
	public ErpFunEntrustOwnersExample() {
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

		public Criteria andEntrustIdIsNull() {
			addCriterion("ENTRUST_ID is null");
			return (Criteria) this;
		}

		public Criteria andEntrustIdIsNotNull() {
			addCriterion("ENTRUST_ID is not null");
			return (Criteria) this;
		}

		public Criteria andEntrustIdEqualTo(Integer value) {
			addCriterion("ENTRUST_ID =", value, "entrustId");
			return (Criteria) this;
		}

		public Criteria andEntrustIdNotEqualTo(Integer value) {
			addCriterion("ENTRUST_ID <>", value, "entrustId");
			return (Criteria) this;
		}

		public Criteria andEntrustIdGreaterThan(Integer value) {
			addCriterion("ENTRUST_ID >", value, "entrustId");
			return (Criteria) this;
		}

		public Criteria andEntrustIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("ENTRUST_ID >=", value, "entrustId");
			return (Criteria) this;
		}

		public Criteria andEntrustIdLessThan(Integer value) {
			addCriterion("ENTRUST_ID <", value, "entrustId");
			return (Criteria) this;
		}

		public Criteria andEntrustIdLessThanOrEqualTo(Integer value) {
			addCriterion("ENTRUST_ID <=", value, "entrustId");
			return (Criteria) this;
		}

		public Criteria andEntrustIdIn(List<Integer> values) {
			addCriterion("ENTRUST_ID in", values, "entrustId");
			return (Criteria) this;
		}

		public Criteria andEntrustIdNotIn(List<Integer> values) {
			addCriterion("ENTRUST_ID not in", values, "entrustId");
			return (Criteria) this;
		}

		public Criteria andEntrustIdBetween(Integer value1, Integer value2) {
			addCriterion("ENTRUST_ID between", value1, value2, "entrustId");
			return (Criteria) this;
		}

		public Criteria andEntrustIdNotBetween(Integer value1, Integer value2) {
			addCriterion("ENTRUST_ID not between", value1, value2, "entrustId");
			return (Criteria) this;
		}

		public Criteria andOwnerNameIsNull() {
			addCriterion("OWNER_NAME is null");
			return (Criteria) this;
		}

		public Criteria andOwnerNameIsNotNull() {
			addCriterion("OWNER_NAME is not null");
			return (Criteria) this;
		}

		public Criteria andOwnerNameEqualTo(String value) {
			addCriterion("OWNER_NAME =", value, "ownerName");
			return (Criteria) this;
		}

		public Criteria andOwnerNameNotEqualTo(String value) {
			addCriterion("OWNER_NAME <>", value, "ownerName");
			return (Criteria) this;
		}

		public Criteria andOwnerNameGreaterThan(String value) {
			addCriterion("OWNER_NAME >", value, "ownerName");
			return (Criteria) this;
		}

		public Criteria andOwnerNameGreaterThanOrEqualTo(String value) {
			addCriterion("OWNER_NAME >=", value, "ownerName");
			return (Criteria) this;
		}

		public Criteria andOwnerNameLessThan(String value) {
			addCriterion("OWNER_NAME <", value, "ownerName");
			return (Criteria) this;
		}

		public Criteria andOwnerNameLessThanOrEqualTo(String value) {
			addCriterion("OWNER_NAME <=", value, "ownerName");
			return (Criteria) this;
		}

		public Criteria andOwnerNameLike(String value) {
			addCriterion("OWNER_NAME like", value, "ownerName");
			return (Criteria) this;
		}

		public Criteria andOwnerNameNotLike(String value) {
			addCriterion("OWNER_NAME not like", value, "ownerName");
			return (Criteria) this;
		}

		public Criteria andOwnerNameIn(List<String> values) {
			addCriterion("OWNER_NAME in", values, "ownerName");
			return (Criteria) this;
		}

		public Criteria andOwnerNameNotIn(List<String> values) {
			addCriterion("OWNER_NAME not in", values, "ownerName");
			return (Criteria) this;
		}

		public Criteria andOwnerNameBetween(String value1, String value2) {
			addCriterion("OWNER_NAME between", value1, value2, "ownerName");
			return (Criteria) this;
		}

		public Criteria andOwnerNameNotBetween(String value1, String value2) {
			addCriterion("OWNER_NAME not between", value1, value2, "ownerName");
			return (Criteria) this;
		}

		public Criteria andNativePlaceIsNull() {
			addCriterion("NATIVE_PLACE is null");
			return (Criteria) this;
		}

		public Criteria andNativePlaceIsNotNull() {
			addCriterion("NATIVE_PLACE is not null");
			return (Criteria) this;
		}

		public Criteria andNativePlaceEqualTo(Byte value) {
			addCriterion("NATIVE_PLACE =", value, "nativePlace");
			return (Criteria) this;
		}

		public Criteria andNativePlaceNotEqualTo(Byte value) {
			addCriterion("NATIVE_PLACE <>", value, "nativePlace");
			return (Criteria) this;
		}

		public Criteria andNativePlaceGreaterThan(Byte value) {
			addCriterion("NATIVE_PLACE >", value, "nativePlace");
			return (Criteria) this;
		}

		public Criteria andNativePlaceGreaterThanOrEqualTo(Byte value) {
			addCriterion("NATIVE_PLACE >=", value, "nativePlace");
			return (Criteria) this;
		}

		public Criteria andNativePlaceLessThan(Byte value) {
			addCriterion("NATIVE_PLACE <", value, "nativePlace");
			return (Criteria) this;
		}

		public Criteria andNativePlaceLessThanOrEqualTo(Byte value) {
			addCriterion("NATIVE_PLACE <=", value, "nativePlace");
			return (Criteria) this;
		}

		public Criteria andNativePlaceIn(List<Byte> values) {
			addCriterion("NATIVE_PLACE in", values, "nativePlace");
			return (Criteria) this;
		}

		public Criteria andNativePlaceNotIn(List<Byte> values) {
			addCriterion("NATIVE_PLACE not in", values, "nativePlace");
			return (Criteria) this;
		}

		public Criteria andNativePlaceBetween(Byte value1, Byte value2) {
			addCriterion("NATIVE_PLACE between", value1, value2, "nativePlace");
			return (Criteria) this;
		}

		public Criteria andNativePlaceNotBetween(Byte value1, Byte value2) {
			addCriterion("NATIVE_PLACE not between", value1, value2, "nativePlace");
			return (Criteria) this;
		}

		public Criteria andIdTypeIsNull() {
			addCriterion("ID_TYPE is null");
			return (Criteria) this;
		}

		public Criteria andIdTypeIsNotNull() {
			addCriterion("ID_TYPE is not null");
			return (Criteria) this;
		}

		public Criteria andIdTypeEqualTo(Byte value) {
			addCriterion("ID_TYPE =", value, "idType");
			return (Criteria) this;
		}

		public Criteria andIdTypeNotEqualTo(Byte value) {
			addCriterion("ID_TYPE <>", value, "idType");
			return (Criteria) this;
		}

		public Criteria andIdTypeGreaterThan(Byte value) {
			addCriterion("ID_TYPE >", value, "idType");
			return (Criteria) this;
		}

		public Criteria andIdTypeGreaterThanOrEqualTo(Byte value) {
			addCriterion("ID_TYPE >=", value, "idType");
			return (Criteria) this;
		}

		public Criteria andIdTypeLessThan(Byte value) {
			addCriterion("ID_TYPE <", value, "idType");
			return (Criteria) this;
		}

		public Criteria andIdTypeLessThanOrEqualTo(Byte value) {
			addCriterion("ID_TYPE <=", value, "idType");
			return (Criteria) this;
		}

		public Criteria andIdTypeIn(List<Byte> values) {
			addCriterion("ID_TYPE in", values, "idType");
			return (Criteria) this;
		}

		public Criteria andIdTypeNotIn(List<Byte> values) {
			addCriterion("ID_TYPE not in", values, "idType");
			return (Criteria) this;
		}

		public Criteria andIdTypeBetween(Byte value1, Byte value2) {
			addCriterion("ID_TYPE between", value1, value2, "idType");
			return (Criteria) this;
		}

		public Criteria andIdTypeNotBetween(Byte value1, Byte value2) {
			addCriterion("ID_TYPE not between", value1, value2, "idType");
			return (Criteria) this;
		}

		public Criteria andCardNoIsNull() {
			addCriterion("CARD_NO is null");
			return (Criteria) this;
		}

		public Criteria andCardNoIsNotNull() {
			addCriterion("CARD_NO is not null");
			return (Criteria) this;
		}

		public Criteria andCardNoEqualTo(String value) {
			addCriterion("CARD_NO =", value, "cardNo");
			return (Criteria) this;
		}

		public Criteria andCardNoNotEqualTo(String value) {
			addCriterion("CARD_NO <>", value, "cardNo");
			return (Criteria) this;
		}

		public Criteria andCardNoGreaterThan(String value) {
			addCriterion("CARD_NO >", value, "cardNo");
			return (Criteria) this;
		}

		public Criteria andCardNoGreaterThanOrEqualTo(String value) {
			addCriterion("CARD_NO >=", value, "cardNo");
			return (Criteria) this;
		}

		public Criteria andCardNoLessThan(String value) {
			addCriterion("CARD_NO <", value, "cardNo");
			return (Criteria) this;
		}

		public Criteria andCardNoLessThanOrEqualTo(String value) {
			addCriterion("CARD_NO <=", value, "cardNo");
			return (Criteria) this;
		}

		public Criteria andCardNoLike(String value) {
			addCriterion("CARD_NO like", value, "cardNo");
			return (Criteria) this;
		}

		public Criteria andCardNoNotLike(String value) {
			addCriterion("CARD_NO not like", value, "cardNo");
			return (Criteria) this;
		}

		public Criteria andCardNoIn(List<String> values) {
			addCriterion("CARD_NO in", values, "cardNo");
			return (Criteria) this;
		}

		public Criteria andCardNoNotIn(List<String> values) {
			addCriterion("CARD_NO not in", values, "cardNo");
			return (Criteria) this;
		}

		public Criteria andCardNoBetween(String value1, String value2) {
			addCriterion("CARD_NO between", value1, value2, "cardNo");
			return (Criteria) this;
		}

		public Criteria andCardNoNotBetween(String value1, String value2) {
			addCriterion("CARD_NO not between", value1, value2, "cardNo");
			return (Criteria) this;
		}

		public Criteria andOwnerPhoneIsNull() {
			addCriterion("OWNER_PHONE is null");
			return (Criteria) this;
		}

		public Criteria andOwnerPhoneIsNotNull() {
			addCriterion("OWNER_PHONE is not null");
			return (Criteria) this;
		}

		public Criteria andOwnerPhoneEqualTo(String value) {
			addCriterion("OWNER_PHONE =", value, "ownerPhone");
			return (Criteria) this;
		}

		public Criteria andOwnerPhoneNotEqualTo(String value) {
			addCriterion("OWNER_PHONE <>", value, "ownerPhone");
			return (Criteria) this;
		}

		public Criteria andOwnerPhoneGreaterThan(String value) {
			addCriterion("OWNER_PHONE >", value, "ownerPhone");
			return (Criteria) this;
		}

		public Criteria andOwnerPhoneGreaterThanOrEqualTo(String value) {
			addCriterion("OWNER_PHONE >=", value, "ownerPhone");
			return (Criteria) this;
		}

		public Criteria andOwnerPhoneLessThan(String value) {
			addCriterion("OWNER_PHONE <", value, "ownerPhone");
			return (Criteria) this;
		}

		public Criteria andOwnerPhoneLessThanOrEqualTo(String value) {
			addCriterion("OWNER_PHONE <=", value, "ownerPhone");
			return (Criteria) this;
		}

		public Criteria andOwnerPhoneLike(String value) {
			addCriterion("OWNER_PHONE like", value, "ownerPhone");
			return (Criteria) this;
		}

		public Criteria andOwnerPhoneNotLike(String value) {
			addCriterion("OWNER_PHONE not like", value, "ownerPhone");
			return (Criteria) this;
		}

		public Criteria andOwnerPhoneIn(List<String> values) {
			addCriterion("OWNER_PHONE in", values, "ownerPhone");
			return (Criteria) this;
		}

		public Criteria andOwnerPhoneNotIn(List<String> values) {
			addCriterion("OWNER_PHONE not in", values, "ownerPhone");
			return (Criteria) this;
		}

		public Criteria andOwnerPhoneBetween(String value1, String value2) {
			addCriterion("OWNER_PHONE between", value1, value2, "ownerPhone");
			return (Criteria) this;
		}

		public Criteria andOwnerPhoneNotBetween(String value1, String value2) {
			addCriterion("OWNER_PHONE not between", value1, value2, "ownerPhone");
			return (Criteria) this;
		}

		public Criteria andAddressIsNull() {
			addCriterion("ADDRESS is null");
			return (Criteria) this;
		}

		public Criteria andAddressIsNotNull() {
			addCriterion("ADDRESS is not null");
			return (Criteria) this;
		}

		public Criteria andAddressEqualTo(String value) {
			addCriterion("ADDRESS =", value, "address");
			return (Criteria) this;
		}

		public Criteria andAddressNotEqualTo(String value) {
			addCriterion("ADDRESS <>", value, "address");
			return (Criteria) this;
		}

		public Criteria andAddressGreaterThan(String value) {
			addCriterion("ADDRESS >", value, "address");
			return (Criteria) this;
		}

		public Criteria andAddressGreaterThanOrEqualTo(String value) {
			addCriterion("ADDRESS >=", value, "address");
			return (Criteria) this;
		}

		public Criteria andAddressLessThan(String value) {
			addCriterion("ADDRESS <", value, "address");
			return (Criteria) this;
		}

		public Criteria andAddressLessThanOrEqualTo(String value) {
			addCriterion("ADDRESS <=", value, "address");
			return (Criteria) this;
		}

		public Criteria andAddressLike(String value) {
			addCriterion("ADDRESS like", value, "address");
			return (Criteria) this;
		}

		public Criteria andAddressNotLike(String value) {
			addCriterion("ADDRESS not like", value, "address");
			return (Criteria) this;
		}

		public Criteria andAddressIn(List<String> values) {
			addCriterion("ADDRESS in", values, "address");
			return (Criteria) this;
		}

		public Criteria andAddressNotIn(List<String> values) {
			addCriterion("ADDRESS not in", values, "address");
			return (Criteria) this;
		}

		public Criteria andAddressBetween(String value1, String value2) {
			addCriterion("ADDRESS between", value1, value2, "address");
			return (Criteria) this;
		}

		public Criteria andAddressNotBetween(String value1, String value2) {
			addCriterion("ADDRESS not between", value1, value2, "address");
			return (Criteria) this;
		}

		public Criteria andIsSignIsNull() {
			addCriterion("IS_SIGN is null");
			return (Criteria) this;
		}

		public Criteria andIsSignIsNotNull() {
			addCriterion("IS_SIGN is not null");
			return (Criteria) this;
		}

		public Criteria andIsSignEqualTo(Byte value) {
			addCriterion("IS_SIGN =", value, "isSign");
			return (Criteria) this;
		}

		public Criteria andIsSignNotEqualTo(Byte value) {
			addCriterion("IS_SIGN <>", value, "isSign");
			return (Criteria) this;
		}

		public Criteria andIsSignGreaterThan(Byte value) {
			addCriterion("IS_SIGN >", value, "isSign");
			return (Criteria) this;
		}

		public Criteria andIsSignGreaterThanOrEqualTo(Byte value) {
			addCriterion("IS_SIGN >=", value, "isSign");
			return (Criteria) this;
		}

		public Criteria andIsSignLessThan(Byte value) {
			addCriterion("IS_SIGN <", value, "isSign");
			return (Criteria) this;
		}

		public Criteria andIsSignLessThanOrEqualTo(Byte value) {
			addCriterion("IS_SIGN <=", value, "isSign");
			return (Criteria) this;
		}

		public Criteria andIsSignIn(List<Byte> values) {
			addCriterion("IS_SIGN in", values, "isSign");
			return (Criteria) this;
		}

		public Criteria andIsSignNotIn(List<Byte> values) {
			addCriterion("IS_SIGN not in", values, "isSign");
			return (Criteria) this;
		}

		public Criteria andIsSignBetween(Byte value1, Byte value2) {
			addCriterion("IS_SIGN between", value1, value2, "isSign");
			return (Criteria) this;
		}

		public Criteria andIsSignNotBetween(Byte value1, Byte value2) {
			addCriterion("IS_SIGN not between", value1, value2, "isSign");
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

		public Criteria andSignDateEqualTo(Date value) {
			addCriterion("SIGN_DATE =", value, "signDate");
			return (Criteria) this;
		}

		public Criteria andSignDateNotEqualTo(Date value) {
			addCriterion("SIGN_DATE <>", value, "signDate");
			return (Criteria) this;
		}

		public Criteria andSignDateGreaterThan(Date value) {
			addCriterion("SIGN_DATE >", value, "signDate");
			return (Criteria) this;
		}

		public Criteria andSignDateGreaterThanOrEqualTo(Date value) {
			addCriterion("SIGN_DATE >=", value, "signDate");
			return (Criteria) this;
		}

		public Criteria andSignDateLessThan(Date value) {
			addCriterion("SIGN_DATE <", value, "signDate");
			return (Criteria) this;
		}

		public Criteria andSignDateLessThanOrEqualTo(Date value) {
			addCriterion("SIGN_DATE <=", value, "signDate");
			return (Criteria) this;
		}

		public Criteria andSignDateIn(List<Date> values) {
			addCriterion("SIGN_DATE in", values, "signDate");
			return (Criteria) this;
		}

		public Criteria andSignDateNotIn(List<Date> values) {
			addCriterion("SIGN_DATE not in", values, "signDate");
			return (Criteria) this;
		}

		public Criteria andSignDateBetween(Date value1, Date value2) {
			addCriterion("SIGN_DATE between", value1, value2, "signDate");
			return (Criteria) this;
		}

		public Criteria andSignDateNotBetween(Date value1, Date value2) {
			addCriterion("SIGN_DATE not between", value1, value2, "signDate");
			return (Criteria) this;
		}

		public Criteria andSignPicAddrIsNull() {
			addCriterion("SIGN_PIC_ADDR is null");
			return (Criteria) this;
		}

		public Criteria andSignPicAddrIsNotNull() {
			addCriterion("SIGN_PIC_ADDR is not null");
			return (Criteria) this;
		}

		public Criteria andSignPicAddrEqualTo(String value) {
			addCriterion("SIGN_PIC_ADDR =", value, "signPicAddr");
			return (Criteria) this;
		}

		public Criteria andSignPicAddrNotEqualTo(String value) {
			addCriterion("SIGN_PIC_ADDR <>", value, "signPicAddr");
			return (Criteria) this;
		}

		public Criteria andSignPicAddrGreaterThan(String value) {
			addCriterion("SIGN_PIC_ADDR >", value, "signPicAddr");
			return (Criteria) this;
		}

		public Criteria andSignPicAddrGreaterThanOrEqualTo(String value) {
			addCriterion("SIGN_PIC_ADDR >=", value, "signPicAddr");
			return (Criteria) this;
		}

		public Criteria andSignPicAddrLessThan(String value) {
			addCriterion("SIGN_PIC_ADDR <", value, "signPicAddr");
			return (Criteria) this;
		}

		public Criteria andSignPicAddrLessThanOrEqualTo(String value) {
			addCriterion("SIGN_PIC_ADDR <=", value, "signPicAddr");
			return (Criteria) this;
		}

		public Criteria andSignPicAddrLike(String value) {
			addCriterion("SIGN_PIC_ADDR like", value, "signPicAddr");
			return (Criteria) this;
		}

		public Criteria andSignPicAddrNotLike(String value) {
			addCriterion("SIGN_PIC_ADDR not like", value, "signPicAddr");
			return (Criteria) this;
		}

		public Criteria andSignPicAddrIn(List<String> values) {
			addCriterion("SIGN_PIC_ADDR in", values, "signPicAddr");
			return (Criteria) this;
		}

		public Criteria andSignPicAddrNotIn(List<String> values) {
			addCriterion("SIGN_PIC_ADDR not in", values, "signPicAddr");
			return (Criteria) this;
		}

		public Criteria andSignPicAddrBetween(String value1, String value2) {
			addCriterion("SIGN_PIC_ADDR between", value1, value2, "signPicAddr");
			return (Criteria) this;
		}

		public Criteria andSignPicAddrNotBetween(String value1, String value2) {
			addCriterion("SIGN_PIC_ADDR not between", value1, value2, "signPicAddr");
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