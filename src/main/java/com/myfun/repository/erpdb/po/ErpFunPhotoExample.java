package com.myfun.repository.erpdb.po;

import com.myfun.repository.support.generator.shard.ShardDb;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ErpFunPhotoExample extends ShardDb {
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
	public ErpFunPhotoExample() {
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

		public Criteria andPhotoIdIsNull() {
			addCriterion("PHOTO_ID is null");
			return (Criteria) this;
		}

		public Criteria andPhotoIdIsNotNull() {
			addCriterion("PHOTO_ID is not null");
			return (Criteria) this;
		}

		public Criteria andPhotoIdEqualTo(Integer value) {
			addCriterion("PHOTO_ID =", value, "photoId");
			return (Criteria) this;
		}

		public Criteria andPhotoIdNotEqualTo(Integer value) {
			addCriterion("PHOTO_ID <>", value, "photoId");
			return (Criteria) this;
		}

		public Criteria andPhotoIdGreaterThan(Integer value) {
			addCriterion("PHOTO_ID >", value, "photoId");
			return (Criteria) this;
		}

		public Criteria andPhotoIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("PHOTO_ID >=", value, "photoId");
			return (Criteria) this;
		}

		public Criteria andPhotoIdLessThan(Integer value) {
			addCriterion("PHOTO_ID <", value, "photoId");
			return (Criteria) this;
		}

		public Criteria andPhotoIdLessThanOrEqualTo(Integer value) {
			addCriterion("PHOTO_ID <=", value, "photoId");
			return (Criteria) this;
		}

		public Criteria andPhotoIdIn(List<Integer> values) {
			addCriterion("PHOTO_ID in", values, "photoId");
			return (Criteria) this;
		}

		public Criteria andPhotoIdNotIn(List<Integer> values) {
			addCriterion("PHOTO_ID not in", values, "photoId");
			return (Criteria) this;
		}

		public Criteria andPhotoIdBetween(Integer value1, Integer value2) {
			addCriterion("PHOTO_ID between", value1, value2, "photoId");
			return (Criteria) this;
		}

		public Criteria andPhotoIdNotBetween(Integer value1, Integer value2) {
			addCriterion("PHOTO_ID not between", value1, value2, "photoId");
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

		public Criteria andPhotoAddrIsNull() {
			addCriterion("PHOTO_ADDR is null");
			return (Criteria) this;
		}

		public Criteria andPhotoAddrIsNotNull() {
			addCriterion("PHOTO_ADDR is not null");
			return (Criteria) this;
		}

		public Criteria andPhotoAddrEqualTo(String value) {
			addCriterion("PHOTO_ADDR =", value, "photoAddr");
			return (Criteria) this;
		}

		public Criteria andPhotoAddrNotEqualTo(String value) {
			addCriterion("PHOTO_ADDR <>", value, "photoAddr");
			return (Criteria) this;
		}

		public Criteria andPhotoAddrGreaterThan(String value) {
			addCriterion("PHOTO_ADDR >", value, "photoAddr");
			return (Criteria) this;
		}

		public Criteria andPhotoAddrGreaterThanOrEqualTo(String value) {
			addCriterion("PHOTO_ADDR >=", value, "photoAddr");
			return (Criteria) this;
		}

		public Criteria andPhotoAddrLessThan(String value) {
			addCriterion("PHOTO_ADDR <", value, "photoAddr");
			return (Criteria) this;
		}

		public Criteria andPhotoAddrLessThanOrEqualTo(String value) {
			addCriterion("PHOTO_ADDR <=", value, "photoAddr");
			return (Criteria) this;
		}

		public Criteria andPhotoAddrLike(String value) {
			addCriterion("PHOTO_ADDR like", value, "photoAddr");
			return (Criteria) this;
		}

		public Criteria andPhotoAddrNotLike(String value) {
			addCriterion("PHOTO_ADDR not like", value, "photoAddr");
			return (Criteria) this;
		}

		public Criteria andPhotoAddrIn(List<String> values) {
			addCriterion("PHOTO_ADDR in", values, "photoAddr");
			return (Criteria) this;
		}

		public Criteria andPhotoAddrNotIn(List<String> values) {
			addCriterion("PHOTO_ADDR not in", values, "photoAddr");
			return (Criteria) this;
		}

		public Criteria andPhotoAddrBetween(String value1, String value2) {
			addCriterion("PHOTO_ADDR between", value1, value2, "photoAddr");
			return (Criteria) this;
		}

		public Criteria andPhotoAddrNotBetween(String value1, String value2) {
			addCriterion("PHOTO_ADDR not between", value1, value2, "photoAddr");
			return (Criteria) this;
		}

		public Criteria andPhotoTypeIsNull() {
			addCriterion("PHOTO_TYPE is null");
			return (Criteria) this;
		}

		public Criteria andPhotoTypeIsNotNull() {
			addCriterion("PHOTO_TYPE is not null");
			return (Criteria) this;
		}

		public Criteria andPhotoTypeEqualTo(Byte value) {
			addCriterion("PHOTO_TYPE =", value, "photoType");
			return (Criteria) this;
		}

		public Criteria andPhotoTypeNotEqualTo(Byte value) {
			addCriterion("PHOTO_TYPE <>", value, "photoType");
			return (Criteria) this;
		}

		public Criteria andPhotoTypeGreaterThan(Byte value) {
			addCriterion("PHOTO_TYPE >", value, "photoType");
			return (Criteria) this;
		}

		public Criteria andPhotoTypeGreaterThanOrEqualTo(Byte value) {
			addCriterion("PHOTO_TYPE >=", value, "photoType");
			return (Criteria) this;
		}

		public Criteria andPhotoTypeLessThan(Byte value) {
			addCriterion("PHOTO_TYPE <", value, "photoType");
			return (Criteria) this;
		}

		public Criteria andPhotoTypeLessThanOrEqualTo(Byte value) {
			addCriterion("PHOTO_TYPE <=", value, "photoType");
			return (Criteria) this;
		}

		public Criteria andPhotoTypeIn(List<Byte> values) {
			addCriterion("PHOTO_TYPE in", values, "photoType");
			return (Criteria) this;
		}

		public Criteria andPhotoTypeNotIn(List<Byte> values) {
			addCriterion("PHOTO_TYPE not in", values, "photoType");
			return (Criteria) this;
		}

		public Criteria andPhotoTypeBetween(Byte value1, Byte value2) {
			addCriterion("PHOTO_TYPE between", value1, value2, "photoType");
			return (Criteria) this;
		}

		public Criteria andPhotoTypeNotBetween(Byte value1, Byte value2) {
			addCriterion("PHOTO_TYPE not between", value1, value2, "photoType");
			return (Criteria) this;
		}

		public Criteria andUseageTypeIsNull() {
			addCriterion("USEAGE_TYPE is null");
			return (Criteria) this;
		}

		public Criteria andUseageTypeIsNotNull() {
			addCriterion("USEAGE_TYPE is not null");
			return (Criteria) this;
		}

		public Criteria andUseageTypeEqualTo(Byte value) {
			addCriterion("USEAGE_TYPE =", value, "useageType");
			return (Criteria) this;
		}

		public Criteria andUseageTypeNotEqualTo(Byte value) {
			addCriterion("USEAGE_TYPE <>", value, "useageType");
			return (Criteria) this;
		}

		public Criteria andUseageTypeGreaterThan(Byte value) {
			addCriterion("USEAGE_TYPE >", value, "useageType");
			return (Criteria) this;
		}

		public Criteria andUseageTypeGreaterThanOrEqualTo(Byte value) {
			addCriterion("USEAGE_TYPE >=", value, "useageType");
			return (Criteria) this;
		}

		public Criteria andUseageTypeLessThan(Byte value) {
			addCriterion("USEAGE_TYPE <", value, "useageType");
			return (Criteria) this;
		}

		public Criteria andUseageTypeLessThanOrEqualTo(Byte value) {
			addCriterion("USEAGE_TYPE <=", value, "useageType");
			return (Criteria) this;
		}

		public Criteria andUseageTypeIn(List<Byte> values) {
			addCriterion("USEAGE_TYPE in", values, "useageType");
			return (Criteria) this;
		}

		public Criteria andUseageTypeNotIn(List<Byte> values) {
			addCriterion("USEAGE_TYPE not in", values, "useageType");
			return (Criteria) this;
		}

		public Criteria andUseageTypeBetween(Byte value1, Byte value2) {
			addCriterion("USEAGE_TYPE between", value1, value2, "useageType");
			return (Criteria) this;
		}

		public Criteria andUseageTypeNotBetween(Byte value1, Byte value2) {
			addCriterion("USEAGE_TYPE not between", value1, value2, "useageType");
			return (Criteria) this;
		}

		public Criteria andPdIdIsNull() {
			addCriterion("PD_ID is null");
			return (Criteria) this;
		}

		public Criteria andPdIdIsNotNull() {
			addCriterion("PD_ID is not null");
			return (Criteria) this;
		}

		public Criteria andPdIdEqualTo(Integer value) {
			addCriterion("PD_ID =", value, "pdId");
			return (Criteria) this;
		}

		public Criteria andPdIdNotEqualTo(Integer value) {
			addCriterion("PD_ID <>", value, "pdId");
			return (Criteria) this;
		}

		public Criteria andPdIdGreaterThan(Integer value) {
			addCriterion("PD_ID >", value, "pdId");
			return (Criteria) this;
		}

		public Criteria andPdIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("PD_ID >=", value, "pdId");
			return (Criteria) this;
		}

		public Criteria andPdIdLessThan(Integer value) {
			addCriterion("PD_ID <", value, "pdId");
			return (Criteria) this;
		}

		public Criteria andPdIdLessThanOrEqualTo(Integer value) {
			addCriterion("PD_ID <=", value, "pdId");
			return (Criteria) this;
		}

		public Criteria andPdIdIn(List<Integer> values) {
			addCriterion("PD_ID in", values, "pdId");
			return (Criteria) this;
		}

		public Criteria andPdIdNotIn(List<Integer> values) {
			addCriterion("PD_ID not in", values, "pdId");
			return (Criteria) this;
		}

		public Criteria andPdIdBetween(Integer value1, Integer value2) {
			addCriterion("PD_ID between", value1, value2, "pdId");
			return (Criteria) this;
		}

		public Criteria andPdIdNotBetween(Integer value1, Integer value2) {
			addCriterion("PD_ID not between", value1, value2, "pdId");
			return (Criteria) this;
		}

		public Criteria andUploadUserIsNull() {
			addCriterion("UPLOAD_USER is null");
			return (Criteria) this;
		}

		public Criteria andUploadUserIsNotNull() {
			addCriterion("UPLOAD_USER is not null");
			return (Criteria) this;
		}

		public Criteria andUploadUserEqualTo(Integer value) {
			addCriterion("UPLOAD_USER =", value, "uploadUser");
			return (Criteria) this;
		}

		public Criteria andUploadUserNotEqualTo(Integer value) {
			addCriterion("UPLOAD_USER <>", value, "uploadUser");
			return (Criteria) this;
		}

		public Criteria andUploadUserGreaterThan(Integer value) {
			addCriterion("UPLOAD_USER >", value, "uploadUser");
			return (Criteria) this;
		}

		public Criteria andUploadUserGreaterThanOrEqualTo(Integer value) {
			addCriterion("UPLOAD_USER >=", value, "uploadUser");
			return (Criteria) this;
		}

		public Criteria andUploadUserLessThan(Integer value) {
			addCriterion("UPLOAD_USER <", value, "uploadUser");
			return (Criteria) this;
		}

		public Criteria andUploadUserLessThanOrEqualTo(Integer value) {
			addCriterion("UPLOAD_USER <=", value, "uploadUser");
			return (Criteria) this;
		}

		public Criteria andUploadUserIn(List<Integer> values) {
			addCriterion("UPLOAD_USER in", values, "uploadUser");
			return (Criteria) this;
		}

		public Criteria andUploadUserNotIn(List<Integer> values) {
			addCriterion("UPLOAD_USER not in", values, "uploadUser");
			return (Criteria) this;
		}

		public Criteria andUploadUserBetween(Integer value1, Integer value2) {
			addCriterion("UPLOAD_USER between", value1, value2, "uploadUser");
			return (Criteria) this;
		}

		public Criteria andUploadUserNotBetween(Integer value1, Integer value2) {
			addCriterion("UPLOAD_USER not between", value1, value2, "uploadUser");
			return (Criteria) this;
		}

		public Criteria andUploadDateIsNull() {
			addCriterion("UPLOAD_DATE is null");
			return (Criteria) this;
		}

		public Criteria andUploadDateIsNotNull() {
			addCriterion("UPLOAD_DATE is not null");
			return (Criteria) this;
		}

		public Criteria andUploadDateEqualTo(String value) {
			addCriterion("UPLOAD_DATE =", value, "uploadDate");
			return (Criteria) this;
		}

		public Criteria andUploadDateNotEqualTo(String value) {
			addCriterion("UPLOAD_DATE <>", value, "uploadDate");
			return (Criteria) this;
		}

		public Criteria andUploadDateGreaterThan(String value) {
			addCriterion("UPLOAD_DATE >", value, "uploadDate");
			return (Criteria) this;
		}

		public Criteria andUploadDateGreaterThanOrEqualTo(String value) {
			addCriterion("UPLOAD_DATE >=", value, "uploadDate");
			return (Criteria) this;
		}

		public Criteria andUploadDateLessThan(String value) {
			addCriterion("UPLOAD_DATE <", value, "uploadDate");
			return (Criteria) this;
		}

		public Criteria andUploadDateLessThanOrEqualTo(String value) {
			addCriterion("UPLOAD_DATE <=", value, "uploadDate");
			return (Criteria) this;
		}

		public Criteria andUploadDateLike(String value) {
			addCriterion("UPLOAD_DATE like", value, "uploadDate");
			return (Criteria) this;
		}

		public Criteria andUploadDateNotLike(String value) {
			addCriterion("UPLOAD_DATE not like", value, "uploadDate");
			return (Criteria) this;
		}

		public Criteria andUploadDateIn(List<String> values) {
			addCriterion("UPLOAD_DATE in", values, "uploadDate");
			return (Criteria) this;
		}

		public Criteria andUploadDateNotIn(List<String> values) {
			addCriterion("UPLOAD_DATE not in", values, "uploadDate");
			return (Criteria) this;
		}

		public Criteria andUploadDateBetween(String value1, String value2) {
			addCriterion("UPLOAD_DATE between", value1, value2, "uploadDate");
			return (Criteria) this;
		}

		public Criteria andUploadDateNotBetween(String value1, String value2) {
			addCriterion("UPLOAD_DATE not between", value1, value2, "uploadDate");
			return (Criteria) this;
		}

		public Criteria andIsTopIsNull() {
			addCriterion("IS_TOP is null");
			return (Criteria) this;
		}

		public Criteria andIsTopIsNotNull() {
			addCriterion("IS_TOP is not null");
			return (Criteria) this;
		}

		public Criteria andIsTopEqualTo(Byte value) {
			addCriterion("IS_TOP =", value, "isTop");
			return (Criteria) this;
		}

		public Criteria andIsTopNotEqualTo(Byte value) {
			addCriterion("IS_TOP <>", value, "isTop");
			return (Criteria) this;
		}

		public Criteria andIsTopGreaterThan(Byte value) {
			addCriterion("IS_TOP >", value, "isTop");
			return (Criteria) this;
		}

		public Criteria andIsTopGreaterThanOrEqualTo(Byte value) {
			addCriterion("IS_TOP >=", value, "isTop");
			return (Criteria) this;
		}

		public Criteria andIsTopLessThan(Byte value) {
			addCriterion("IS_TOP <", value, "isTop");
			return (Criteria) this;
		}

		public Criteria andIsTopLessThanOrEqualTo(Byte value) {
			addCriterion("IS_TOP <=", value, "isTop");
			return (Criteria) this;
		}

		public Criteria andIsTopIn(List<Byte> values) {
			addCriterion("IS_TOP in", values, "isTop");
			return (Criteria) this;
		}

		public Criteria andIsTopNotIn(List<Byte> values) {
			addCriterion("IS_TOP not in", values, "isTop");
			return (Criteria) this;
		}

		public Criteria andIsTopBetween(Byte value1, Byte value2) {
			addCriterion("IS_TOP between", value1, value2, "isTop");
			return (Criteria) this;
		}

		public Criteria andIsTopNotBetween(Byte value1, Byte value2) {
			addCriterion("IS_TOP not between", value1, value2, "isTop");
			return (Criteria) this;
		}

		public Criteria andPhotoSourceIsNull() {
			addCriterion("PHOTO_SOURCE is null");
			return (Criteria) this;
		}

		public Criteria andPhotoSourceIsNotNull() {
			addCriterion("PHOTO_SOURCE is not null");
			return (Criteria) this;
		}

		public Criteria andPhotoSourceEqualTo(Byte value) {
			addCriterion("PHOTO_SOURCE =", value, "photoSource");
			return (Criteria) this;
		}

		public Criteria andPhotoSourceNotEqualTo(Byte value) {
			addCriterion("PHOTO_SOURCE <>", value, "photoSource");
			return (Criteria) this;
		}

		public Criteria andPhotoSourceGreaterThan(Byte value) {
			addCriterion("PHOTO_SOURCE >", value, "photoSource");
			return (Criteria) this;
		}

		public Criteria andPhotoSourceGreaterThanOrEqualTo(Byte value) {
			addCriterion("PHOTO_SOURCE >=", value, "photoSource");
			return (Criteria) this;
		}

		public Criteria andPhotoSourceLessThan(Byte value) {
			addCriterion("PHOTO_SOURCE <", value, "photoSource");
			return (Criteria) this;
		}

		public Criteria andPhotoSourceLessThanOrEqualTo(Byte value) {
			addCriterion("PHOTO_SOURCE <=", value, "photoSource");
			return (Criteria) this;
		}

		public Criteria andPhotoSourceIn(List<Byte> values) {
			addCriterion("PHOTO_SOURCE in", values, "photoSource");
			return (Criteria) this;
		}

		public Criteria andPhotoSourceNotIn(List<Byte> values) {
			addCriterion("PHOTO_SOURCE not in", values, "photoSource");
			return (Criteria) this;
		}

		public Criteria andPhotoSourceBetween(Byte value1, Byte value2) {
			addCriterion("PHOTO_SOURCE between", value1, value2, "photoSource");
			return (Criteria) this;
		}

		public Criteria andPhotoSourceNotBetween(Byte value1, Byte value2) {
			addCriterion("PHOTO_SOURCE not between", value1, value2, "photoSource");
			return (Criteria) this;
		}

		public Criteria andTransmitFlagIsNull() {
			addCriterion("TRANSMIT_FLAG is null");
			return (Criteria) this;
		}

		public Criteria andTransmitFlagIsNotNull() {
			addCriterion("TRANSMIT_FLAG is not null");
			return (Criteria) this;
		}

		public Criteria andTransmitFlagEqualTo(Byte value) {
			addCriterion("TRANSMIT_FLAG =", value, "transmitFlag");
			return (Criteria) this;
		}

		public Criteria andTransmitFlagNotEqualTo(Byte value) {
			addCriterion("TRANSMIT_FLAG <>", value, "transmitFlag");
			return (Criteria) this;
		}

		public Criteria andTransmitFlagGreaterThan(Byte value) {
			addCriterion("TRANSMIT_FLAG >", value, "transmitFlag");
			return (Criteria) this;
		}

		public Criteria andTransmitFlagGreaterThanOrEqualTo(Byte value) {
			addCriterion("TRANSMIT_FLAG >=", value, "transmitFlag");
			return (Criteria) this;
		}

		public Criteria andTransmitFlagLessThan(Byte value) {
			addCriterion("TRANSMIT_FLAG <", value, "transmitFlag");
			return (Criteria) this;
		}

		public Criteria andTransmitFlagLessThanOrEqualTo(Byte value) {
			addCriterion("TRANSMIT_FLAG <=", value, "transmitFlag");
			return (Criteria) this;
		}

		public Criteria andTransmitFlagIn(List<Byte> values) {
			addCriterion("TRANSMIT_FLAG in", values, "transmitFlag");
			return (Criteria) this;
		}

		public Criteria andTransmitFlagNotIn(List<Byte> values) {
			addCriterion("TRANSMIT_FLAG not in", values, "transmitFlag");
			return (Criteria) this;
		}

		public Criteria andTransmitFlagBetween(Byte value1, Byte value2) {
			addCriterion("TRANSMIT_FLAG between", value1, value2, "transmitFlag");
			return (Criteria) this;
		}

		public Criteria andTransmitFlagNotBetween(Byte value1, Byte value2) {
			addCriterion("TRANSMIT_FLAG not between", value1, value2, "transmitFlag");
			return (Criteria) this;
		}

		public Criteria andPhotoIdOldIsNull() {
			addCriterion("PHOTO_ID_OLD is null");
			return (Criteria) this;
		}

		public Criteria andPhotoIdOldIsNotNull() {
			addCriterion("PHOTO_ID_OLD is not null");
			return (Criteria) this;
		}

		public Criteria andPhotoIdOldEqualTo(Integer value) {
			addCriterion("PHOTO_ID_OLD =", value, "photoIdOld");
			return (Criteria) this;
		}

		public Criteria andPhotoIdOldNotEqualTo(Integer value) {
			addCriterion("PHOTO_ID_OLD <>", value, "photoIdOld");
			return (Criteria) this;
		}

		public Criteria andPhotoIdOldGreaterThan(Integer value) {
			addCriterion("PHOTO_ID_OLD >", value, "photoIdOld");
			return (Criteria) this;
		}

		public Criteria andPhotoIdOldGreaterThanOrEqualTo(Integer value) {
			addCriterion("PHOTO_ID_OLD >=", value, "photoIdOld");
			return (Criteria) this;
		}

		public Criteria andPhotoIdOldLessThan(Integer value) {
			addCriterion("PHOTO_ID_OLD <", value, "photoIdOld");
			return (Criteria) this;
		}

		public Criteria andPhotoIdOldLessThanOrEqualTo(Integer value) {
			addCriterion("PHOTO_ID_OLD <=", value, "photoIdOld");
			return (Criteria) this;
		}

		public Criteria andPhotoIdOldIn(List<Integer> values) {
			addCriterion("PHOTO_ID_OLD in", values, "photoIdOld");
			return (Criteria) this;
		}

		public Criteria andPhotoIdOldNotIn(List<Integer> values) {
			addCriterion("PHOTO_ID_OLD not in", values, "photoIdOld");
			return (Criteria) this;
		}

		public Criteria andPhotoIdOldBetween(Integer value1, Integer value2) {
			addCriterion("PHOTO_ID_OLD between", value1, value2, "photoIdOld");
			return (Criteria) this;
		}

		public Criteria andPhotoIdOldNotBetween(Integer value1, Integer value2) {
			addCriterion("PHOTO_ID_OLD not between", value1, value2, "photoIdOld");
			return (Criteria) this;
		}

		public Criteria andPhotoSeqIsNull() {
			addCriterion("PHOTO_SEQ is null");
			return (Criteria) this;
		}

		public Criteria andPhotoSeqIsNotNull() {
			addCriterion("PHOTO_SEQ is not null");
			return (Criteria) this;
		}

		public Criteria andPhotoSeqEqualTo(Integer value) {
			addCriterion("PHOTO_SEQ =", value, "photoSeq");
			return (Criteria) this;
		}

		public Criteria andPhotoSeqNotEqualTo(Integer value) {
			addCriterion("PHOTO_SEQ <>", value, "photoSeq");
			return (Criteria) this;
		}

		public Criteria andPhotoSeqGreaterThan(Integer value) {
			addCriterion("PHOTO_SEQ >", value, "photoSeq");
			return (Criteria) this;
		}

		public Criteria andPhotoSeqGreaterThanOrEqualTo(Integer value) {
			addCriterion("PHOTO_SEQ >=", value, "photoSeq");
			return (Criteria) this;
		}

		public Criteria andPhotoSeqLessThan(Integer value) {
			addCriterion("PHOTO_SEQ <", value, "photoSeq");
			return (Criteria) this;
		}

		public Criteria andPhotoSeqLessThanOrEqualTo(Integer value) {
			addCriterion("PHOTO_SEQ <=", value, "photoSeq");
			return (Criteria) this;
		}

		public Criteria andPhotoSeqIn(List<Integer> values) {
			addCriterion("PHOTO_SEQ in", values, "photoSeq");
			return (Criteria) this;
		}

		public Criteria andPhotoSeqNotIn(List<Integer> values) {
			addCriterion("PHOTO_SEQ not in", values, "photoSeq");
			return (Criteria) this;
		}

		public Criteria andPhotoSeqBetween(Integer value1, Integer value2) {
			addCriterion("PHOTO_SEQ between", value1, value2, "photoSeq");
			return (Criteria) this;
		}

		public Criteria andPhotoSeqNotBetween(Integer value1, Integer value2) {
			addCriterion("PHOTO_SEQ not between", value1, value2, "photoSeq");
			return (Criteria) this;
		}

		public Criteria andPhotoReviewFlagIsNull() {
			addCriterion("PHOTO_REVIEW_FLAG is null");
			return (Criteria) this;
		}

		public Criteria andPhotoReviewFlagIsNotNull() {
			addCriterion("PHOTO_REVIEW_FLAG is not null");
			return (Criteria) this;
		}

		public Criteria andPhotoReviewFlagEqualTo(Byte value) {
			addCriterion("PHOTO_REVIEW_FLAG =", value, "photoReviewFlag");
			return (Criteria) this;
		}

		public Criteria andPhotoReviewFlagNotEqualTo(Byte value) {
			addCriterion("PHOTO_REVIEW_FLAG <>", value, "photoReviewFlag");
			return (Criteria) this;
		}

		public Criteria andPhotoReviewFlagGreaterThan(Byte value) {
			addCriterion("PHOTO_REVIEW_FLAG >", value, "photoReviewFlag");
			return (Criteria) this;
		}

		public Criteria andPhotoReviewFlagGreaterThanOrEqualTo(Byte value) {
			addCriterion("PHOTO_REVIEW_FLAG >=", value, "photoReviewFlag");
			return (Criteria) this;
		}

		public Criteria andPhotoReviewFlagLessThan(Byte value) {
			addCriterion("PHOTO_REVIEW_FLAG <", value, "photoReviewFlag");
			return (Criteria) this;
		}

		public Criteria andPhotoReviewFlagLessThanOrEqualTo(Byte value) {
			addCriterion("PHOTO_REVIEW_FLAG <=", value, "photoReviewFlag");
			return (Criteria) this;
		}

		public Criteria andPhotoReviewFlagIn(List<Byte> values) {
			addCriterion("PHOTO_REVIEW_FLAG in", values, "photoReviewFlag");
			return (Criteria) this;
		}

		public Criteria andPhotoReviewFlagNotIn(List<Byte> values) {
			addCriterion("PHOTO_REVIEW_FLAG not in", values, "photoReviewFlag");
			return (Criteria) this;
		}

		public Criteria andPhotoReviewFlagBetween(Byte value1, Byte value2) {
			addCriterion("PHOTO_REVIEW_FLAG between", value1, value2, "photoReviewFlag");
			return (Criteria) this;
		}

		public Criteria andPhotoReviewFlagNotBetween(Byte value1, Byte value2) {
			addCriterion("PHOTO_REVIEW_FLAG not between", value1, value2, "photoReviewFlag");
			return (Criteria) this;
		}

		public Criteria andPhotoReviewUidIsNull() {
			addCriterion("PHOTO_REVIEW_UID is null");
			return (Criteria) this;
		}

		public Criteria andPhotoReviewUidIsNotNull() {
			addCriterion("PHOTO_REVIEW_UID is not null");
			return (Criteria) this;
		}

		public Criteria andPhotoReviewUidEqualTo(Integer value) {
			addCriterion("PHOTO_REVIEW_UID =", value, "photoReviewUid");
			return (Criteria) this;
		}

		public Criteria andPhotoReviewUidNotEqualTo(Integer value) {
			addCriterion("PHOTO_REVIEW_UID <>", value, "photoReviewUid");
			return (Criteria) this;
		}

		public Criteria andPhotoReviewUidGreaterThan(Integer value) {
			addCriterion("PHOTO_REVIEW_UID >", value, "photoReviewUid");
			return (Criteria) this;
		}

		public Criteria andPhotoReviewUidGreaterThanOrEqualTo(Integer value) {
			addCriterion("PHOTO_REVIEW_UID >=", value, "photoReviewUid");
			return (Criteria) this;
		}

		public Criteria andPhotoReviewUidLessThan(Integer value) {
			addCriterion("PHOTO_REVIEW_UID <", value, "photoReviewUid");
			return (Criteria) this;
		}

		public Criteria andPhotoReviewUidLessThanOrEqualTo(Integer value) {
			addCriterion("PHOTO_REVIEW_UID <=", value, "photoReviewUid");
			return (Criteria) this;
		}

		public Criteria andPhotoReviewUidIn(List<Integer> values) {
			addCriterion("PHOTO_REVIEW_UID in", values, "photoReviewUid");
			return (Criteria) this;
		}

		public Criteria andPhotoReviewUidNotIn(List<Integer> values) {
			addCriterion("PHOTO_REVIEW_UID not in", values, "photoReviewUid");
			return (Criteria) this;
		}

		public Criteria andPhotoReviewUidBetween(Integer value1, Integer value2) {
			addCriterion("PHOTO_REVIEW_UID between", value1, value2, "photoReviewUid");
			return (Criteria) this;
		}

		public Criteria andPhotoReviewUidNotBetween(Integer value1, Integer value2) {
			addCriterion("PHOTO_REVIEW_UID not between", value1, value2, "photoReviewUid");
			return (Criteria) this;
		}

		public Criteria andPhotoReviewTimeIsNull() {
			addCriterion("PHOTO_REVIEW_TIME is null");
			return (Criteria) this;
		}

		public Criteria andPhotoReviewTimeIsNotNull() {
			addCriterion("PHOTO_REVIEW_TIME is not null");
			return (Criteria) this;
		}

		public Criteria andPhotoReviewTimeEqualTo(Date value) {
			addCriterion("PHOTO_REVIEW_TIME =", value, "photoReviewTime");
			return (Criteria) this;
		}

		public Criteria andPhotoReviewTimeNotEqualTo(Date value) {
			addCriterion("PHOTO_REVIEW_TIME <>", value, "photoReviewTime");
			return (Criteria) this;
		}

		public Criteria andPhotoReviewTimeGreaterThan(Date value) {
			addCriterion("PHOTO_REVIEW_TIME >", value, "photoReviewTime");
			return (Criteria) this;
		}

		public Criteria andPhotoReviewTimeGreaterThanOrEqualTo(Date value) {
			addCriterion("PHOTO_REVIEW_TIME >=", value, "photoReviewTime");
			return (Criteria) this;
		}

		public Criteria andPhotoReviewTimeLessThan(Date value) {
			addCriterion("PHOTO_REVIEW_TIME <", value, "photoReviewTime");
			return (Criteria) this;
		}

		public Criteria andPhotoReviewTimeLessThanOrEqualTo(Date value) {
			addCriterion("PHOTO_REVIEW_TIME <=", value, "photoReviewTime");
			return (Criteria) this;
		}

		public Criteria andPhotoReviewTimeIn(List<Date> values) {
			addCriterion("PHOTO_REVIEW_TIME in", values, "photoReviewTime");
			return (Criteria) this;
		}

		public Criteria andPhotoReviewTimeNotIn(List<Date> values) {
			addCriterion("PHOTO_REVIEW_TIME not in", values, "photoReviewTime");
			return (Criteria) this;
		}

		public Criteria andPhotoReviewTimeBetween(Date value1, Date value2) {
			addCriterion("PHOTO_REVIEW_TIME between", value1, value2, "photoReviewTime");
			return (Criteria) this;
		}

		public Criteria andPhotoReviewTimeNotBetween(Date value1, Date value2) {
			addCriterion("PHOTO_REVIEW_TIME not between", value1, value2, "photoReviewTime");
			return (Criteria) this;
		}

		public Criteria andLockUserIsNull() {
			addCriterion("LOCK_USER is null");
			return (Criteria) this;
		}

		public Criteria andLockUserIsNotNull() {
			addCriterion("LOCK_USER is not null");
			return (Criteria) this;
		}

		public Criteria andLockUserEqualTo(Integer value) {
			addCriterion("LOCK_USER =", value, "lockUser");
			return (Criteria) this;
		}

		public Criteria andLockUserNotEqualTo(Integer value) {
			addCriterion("LOCK_USER <>", value, "lockUser");
			return (Criteria) this;
		}

		public Criteria andLockUserGreaterThan(Integer value) {
			addCriterion("LOCK_USER >", value, "lockUser");
			return (Criteria) this;
		}

		public Criteria andLockUserGreaterThanOrEqualTo(Integer value) {
			addCriterion("LOCK_USER >=", value, "lockUser");
			return (Criteria) this;
		}

		public Criteria andLockUserLessThan(Integer value) {
			addCriterion("LOCK_USER <", value, "lockUser");
			return (Criteria) this;
		}

		public Criteria andLockUserLessThanOrEqualTo(Integer value) {
			addCriterion("LOCK_USER <=", value, "lockUser");
			return (Criteria) this;
		}

		public Criteria andLockUserIn(List<Integer> values) {
			addCriterion("LOCK_USER in", values, "lockUser");
			return (Criteria) this;
		}

		public Criteria andLockUserNotIn(List<Integer> values) {
			addCriterion("LOCK_USER not in", values, "lockUser");
			return (Criteria) this;
		}

		public Criteria andLockUserBetween(Integer value1, Integer value2) {
			addCriterion("LOCK_USER between", value1, value2, "lockUser");
			return (Criteria) this;
		}

		public Criteria andLockUserNotBetween(Integer value1, Integer value2) {
			addCriterion("LOCK_USER not between", value1, value2, "lockUser");
			return (Criteria) this;
		}

		public Criteria andIsInvalidIsNull() {
			addCriterion("IS_INVALID is null");
			return (Criteria) this;
		}

		public Criteria andIsInvalidIsNotNull() {
			addCriterion("IS_INVALID is not null");
			return (Criteria) this;
		}

		public Criteria andIsInvalidEqualTo(Integer value) {
			addCriterion("IS_INVALID =", value, "isInvalid");
			return (Criteria) this;
		}

		public Criteria andIsInvalidNotEqualTo(Integer value) {
			addCriterion("IS_INVALID <>", value, "isInvalid");
			return (Criteria) this;
		}

		public Criteria andIsInvalidGreaterThan(Integer value) {
			addCriterion("IS_INVALID >", value, "isInvalid");
			return (Criteria) this;
		}

		public Criteria andIsInvalidGreaterThanOrEqualTo(Integer value) {
			addCriterion("IS_INVALID >=", value, "isInvalid");
			return (Criteria) this;
		}

		public Criteria andIsInvalidLessThan(Integer value) {
			addCriterion("IS_INVALID <", value, "isInvalid");
			return (Criteria) this;
		}

		public Criteria andIsInvalidLessThanOrEqualTo(Integer value) {
			addCriterion("IS_INVALID <=", value, "isInvalid");
			return (Criteria) this;
		}

		public Criteria andIsInvalidIn(List<Integer> values) {
			addCriterion("IS_INVALID in", values, "isInvalid");
			return (Criteria) this;
		}

		public Criteria andIsInvalidNotIn(List<Integer> values) {
			addCriterion("IS_INVALID not in", values, "isInvalid");
			return (Criteria) this;
		}

		public Criteria andIsInvalidBetween(Integer value1, Integer value2) {
			addCriterion("IS_INVALID between", value1, value2, "isInvalid");
			return (Criteria) this;
		}

		public Criteria andIsInvalidNotBetween(Integer value1, Integer value2) {
			addCriterion("IS_INVALID not between", value1, value2, "isInvalid");
			return (Criteria) this;
		}

		public Criteria andDelUserIsNull() {
			addCriterion("DEL_USER is null");
			return (Criteria) this;
		}

		public Criteria andDelUserIsNotNull() {
			addCriterion("DEL_USER is not null");
			return (Criteria) this;
		}

		public Criteria andDelUserEqualTo(Integer value) {
			addCriterion("DEL_USER =", value, "delUser");
			return (Criteria) this;
		}

		public Criteria andDelUserNotEqualTo(Integer value) {
			addCriterion("DEL_USER <>", value, "delUser");
			return (Criteria) this;
		}

		public Criteria andDelUserGreaterThan(Integer value) {
			addCriterion("DEL_USER >", value, "delUser");
			return (Criteria) this;
		}

		public Criteria andDelUserGreaterThanOrEqualTo(Integer value) {
			addCriterion("DEL_USER >=", value, "delUser");
			return (Criteria) this;
		}

		public Criteria andDelUserLessThan(Integer value) {
			addCriterion("DEL_USER <", value, "delUser");
			return (Criteria) this;
		}

		public Criteria andDelUserLessThanOrEqualTo(Integer value) {
			addCriterion("DEL_USER <=", value, "delUser");
			return (Criteria) this;
		}

		public Criteria andDelUserIn(List<Integer> values) {
			addCriterion("DEL_USER in", values, "delUser");
			return (Criteria) this;
		}

		public Criteria andDelUserNotIn(List<Integer> values) {
			addCriterion("DEL_USER not in", values, "delUser");
			return (Criteria) this;
		}

		public Criteria andDelUserBetween(Integer value1, Integer value2) {
			addCriterion("DEL_USER between", value1, value2, "delUser");
			return (Criteria) this;
		}

		public Criteria andDelUserNotBetween(Integer value1, Integer value2) {
			addCriterion("DEL_USER not between", value1, value2, "delUser");
			return (Criteria) this;
		}

		public Criteria andDelTimeIsNull() {
			addCriterion("DEL_TIME is null");
			return (Criteria) this;
		}

		public Criteria andDelTimeIsNotNull() {
			addCriterion("DEL_TIME is not null");
			return (Criteria) this;
		}

		public Criteria andDelTimeEqualTo(Date value) {
			addCriterion("DEL_TIME =", value, "delTime");
			return (Criteria) this;
		}

		public Criteria andDelTimeNotEqualTo(Date value) {
			addCriterion("DEL_TIME <>", value, "delTime");
			return (Criteria) this;
		}

		public Criteria andDelTimeGreaterThan(Date value) {
			addCriterion("DEL_TIME >", value, "delTime");
			return (Criteria) this;
		}

		public Criteria andDelTimeGreaterThanOrEqualTo(Date value) {
			addCriterion("DEL_TIME >=", value, "delTime");
			return (Criteria) this;
		}

		public Criteria andDelTimeLessThan(Date value) {
			addCriterion("DEL_TIME <", value, "delTime");
			return (Criteria) this;
		}

		public Criteria andDelTimeLessThanOrEqualTo(Date value) {
			addCriterion("DEL_TIME <=", value, "delTime");
			return (Criteria) this;
		}

		public Criteria andDelTimeIn(List<Date> values) {
			addCriterion("DEL_TIME in", values, "delTime");
			return (Criteria) this;
		}

		public Criteria andDelTimeNotIn(List<Date> values) {
			addCriterion("DEL_TIME not in", values, "delTime");
			return (Criteria) this;
		}

		public Criteria andDelTimeBetween(Date value1, Date value2) {
			addCriterion("DEL_TIME between", value1, value2, "delTime");
			return (Criteria) this;
		}

		public Criteria andDelTimeNotBetween(Date value1, Date value2) {
			addCriterion("DEL_TIME not between", value1, value2, "delTime");
			return (Criteria) this;
		}

		public Criteria andTrackIdIsNull() {
			addCriterion("TRACK_ID is null");
			return (Criteria) this;
		}

		public Criteria andTrackIdIsNotNull() {
			addCriterion("TRACK_ID is not null");
			return (Criteria) this;
		}

		public Criteria andTrackIdEqualTo(Integer value) {
			addCriterion("TRACK_ID =", value, "trackId");
			return (Criteria) this;
		}

		public Criteria andTrackIdNotEqualTo(Integer value) {
			addCriterion("TRACK_ID <>", value, "trackId");
			return (Criteria) this;
		}

		public Criteria andTrackIdGreaterThan(Integer value) {
			addCriterion("TRACK_ID >", value, "trackId");
			return (Criteria) this;
		}

		public Criteria andTrackIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("TRACK_ID >=", value, "trackId");
			return (Criteria) this;
		}

		public Criteria andTrackIdLessThan(Integer value) {
			addCriterion("TRACK_ID <", value, "trackId");
			return (Criteria) this;
		}

		public Criteria andTrackIdLessThanOrEqualTo(Integer value) {
			addCriterion("TRACK_ID <=", value, "trackId");
			return (Criteria) this;
		}

		public Criteria andTrackIdIn(List<Integer> values) {
			addCriterion("TRACK_ID in", values, "trackId");
			return (Criteria) this;
		}

		public Criteria andTrackIdNotIn(List<Integer> values) {
			addCriterion("TRACK_ID not in", values, "trackId");
			return (Criteria) this;
		}

		public Criteria andTrackIdBetween(Integer value1, Integer value2) {
			addCriterion("TRACK_ID between", value1, value2, "trackId");
			return (Criteria) this;
		}

		public Criteria andTrackIdNotBetween(Integer value1, Integer value2) {
			addCriterion("TRACK_ID not between", value1, value2, "trackId");
			return (Criteria) this;
		}

		public Criteria andFileSystemTypeIsNull() {
			addCriterion("FILE_SYSTEM_TYPE is null");
			return (Criteria) this;
		}

		public Criteria andFileSystemTypeIsNotNull() {
			addCriterion("FILE_SYSTEM_TYPE is not null");
			return (Criteria) this;
		}

		public Criteria andFileSystemTypeEqualTo(Byte value) {
			addCriterion("FILE_SYSTEM_TYPE =", value, "fileSystemType");
			return (Criteria) this;
		}

		public Criteria andFileSystemTypeNotEqualTo(Byte value) {
			addCriterion("FILE_SYSTEM_TYPE <>", value, "fileSystemType");
			return (Criteria) this;
		}

		public Criteria andFileSystemTypeGreaterThan(Byte value) {
			addCriterion("FILE_SYSTEM_TYPE >", value, "fileSystemType");
			return (Criteria) this;
		}

		public Criteria andFileSystemTypeGreaterThanOrEqualTo(Byte value) {
			addCriterion("FILE_SYSTEM_TYPE >=", value, "fileSystemType");
			return (Criteria) this;
		}

		public Criteria andFileSystemTypeLessThan(Byte value) {
			addCriterion("FILE_SYSTEM_TYPE <", value, "fileSystemType");
			return (Criteria) this;
		}

		public Criteria andFileSystemTypeLessThanOrEqualTo(Byte value) {
			addCriterion("FILE_SYSTEM_TYPE <=", value, "fileSystemType");
			return (Criteria) this;
		}

		public Criteria andFileSystemTypeIn(List<Byte> values) {
			addCriterion("FILE_SYSTEM_TYPE in", values, "fileSystemType");
			return (Criteria) this;
		}

		public Criteria andFileSystemTypeNotIn(List<Byte> values) {
			addCriterion("FILE_SYSTEM_TYPE not in", values, "fileSystemType");
			return (Criteria) this;
		}

		public Criteria andFileSystemTypeBetween(Byte value1, Byte value2) {
			addCriterion("FILE_SYSTEM_TYPE between", value1, value2, "fileSystemType");
			return (Criteria) this;
		}

		public Criteria andFileSystemTypeNotBetween(Byte value1, Byte value2) {
			addCriterion("FILE_SYSTEM_TYPE not between", value1, value2, "fileSystemType");
			return (Criteria) this;
		}

		public Criteria andFileAddrIsNull() {
			addCriterion("FILE_ADDR is null");
			return (Criteria) this;
		}

		public Criteria andFileAddrIsNotNull() {
			addCriterion("FILE_ADDR is not null");
			return (Criteria) this;
		}

		public Criteria andFileAddrEqualTo(String value) {
			addCriterion("FILE_ADDR =", value, "fileAddr");
			return (Criteria) this;
		}

		public Criteria andFileAddrNotEqualTo(String value) {
			addCriterion("FILE_ADDR <>", value, "fileAddr");
			return (Criteria) this;
		}

		public Criteria andFileAddrGreaterThan(String value) {
			addCriterion("FILE_ADDR >", value, "fileAddr");
			return (Criteria) this;
		}

		public Criteria andFileAddrGreaterThanOrEqualTo(String value) {
			addCriterion("FILE_ADDR >=", value, "fileAddr");
			return (Criteria) this;
		}

		public Criteria andFileAddrLessThan(String value) {
			addCriterion("FILE_ADDR <", value, "fileAddr");
			return (Criteria) this;
		}

		public Criteria andFileAddrLessThanOrEqualTo(String value) {
			addCriterion("FILE_ADDR <=", value, "fileAddr");
			return (Criteria) this;
		}

		public Criteria andFileAddrLike(String value) {
			addCriterion("FILE_ADDR like", value, "fileAddr");
			return (Criteria) this;
		}

		public Criteria andFileAddrNotLike(String value) {
			addCriterion("FILE_ADDR not like", value, "fileAddr");
			return (Criteria) this;
		}

		public Criteria andFileAddrIn(List<String> values) {
			addCriterion("FILE_ADDR in", values, "fileAddr");
			return (Criteria) this;
		}

		public Criteria andFileAddrNotIn(List<String> values) {
			addCriterion("FILE_ADDR not in", values, "fileAddr");
			return (Criteria) this;
		}

		public Criteria andFileAddrBetween(String value1, String value2) {
			addCriterion("FILE_ADDR between", value1, value2, "fileAddr");
			return (Criteria) this;
		}

		public Criteria andFileAddrNotBetween(String value1, String value2) {
			addCriterion("FILE_ADDR not between", value1, value2, "fileAddr");
			return (Criteria) this;
		}

		public Criteria andUploadClientIdIsNull() {
			addCriterion("UPLOAD_CLIENT_ID is null");
			return (Criteria) this;
		}

		public Criteria andUploadClientIdIsNotNull() {
			addCriterion("UPLOAD_CLIENT_ID is not null");
			return (Criteria) this;
		}

		public Criteria andUploadClientIdEqualTo(String value) {
			addCriterion("UPLOAD_CLIENT_ID =", value, "uploadClientId");
			return (Criteria) this;
		}

		public Criteria andUploadClientIdNotEqualTo(String value) {
			addCriterion("UPLOAD_CLIENT_ID <>", value, "uploadClientId");
			return (Criteria) this;
		}

		public Criteria andUploadClientIdGreaterThan(String value) {
			addCriterion("UPLOAD_CLIENT_ID >", value, "uploadClientId");
			return (Criteria) this;
		}

		public Criteria andUploadClientIdGreaterThanOrEqualTo(String value) {
			addCriterion("UPLOAD_CLIENT_ID >=", value, "uploadClientId");
			return (Criteria) this;
		}

		public Criteria andUploadClientIdLessThan(String value) {
			addCriterion("UPLOAD_CLIENT_ID <", value, "uploadClientId");
			return (Criteria) this;
		}

		public Criteria andUploadClientIdLessThanOrEqualTo(String value) {
			addCriterion("UPLOAD_CLIENT_ID <=", value, "uploadClientId");
			return (Criteria) this;
		}

		public Criteria andUploadClientIdLike(String value) {
			addCriterion("UPLOAD_CLIENT_ID like", value, "uploadClientId");
			return (Criteria) this;
		}

		public Criteria andUploadClientIdNotLike(String value) {
			addCriterion("UPLOAD_CLIENT_ID not like", value, "uploadClientId");
			return (Criteria) this;
		}

		public Criteria andUploadClientIdIn(List<String> values) {
			addCriterion("UPLOAD_CLIENT_ID in", values, "uploadClientId");
			return (Criteria) this;
		}

		public Criteria andUploadClientIdNotIn(List<String> values) {
			addCriterion("UPLOAD_CLIENT_ID not in", values, "uploadClientId");
			return (Criteria) this;
		}

		public Criteria andUploadClientIdBetween(String value1, String value2) {
			addCriterion("UPLOAD_CLIENT_ID between", value1, value2, "uploadClientId");
			return (Criteria) this;
		}

		public Criteria andUploadClientIdNotBetween(String value1, String value2) {
			addCriterion("UPLOAD_CLIENT_ID not between", value1, value2, "uploadClientId");
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

		public Criteria andHouseIndoorPhotoTypeIsNull() {
			addCriterion("HOUSE_INDOOR_PHOTO_TYPE is null");
			return (Criteria) this;
		}

		public Criteria andHouseIndoorPhotoTypeIsNotNull() {
			addCriterion("HOUSE_INDOOR_PHOTO_TYPE is not null");
			return (Criteria) this;
		}

		public Criteria andHouseIndoorPhotoTypeEqualTo(Byte value) {
			addCriterion("HOUSE_INDOOR_PHOTO_TYPE =", value, "houseIndoorPhotoType");
			return (Criteria) this;
		}

		public Criteria andHouseIndoorPhotoTypeNotEqualTo(Byte value) {
			addCriterion("HOUSE_INDOOR_PHOTO_TYPE <>", value, "houseIndoorPhotoType");
			return (Criteria) this;
		}

		public Criteria andHouseIndoorPhotoTypeGreaterThan(Byte value) {
			addCriterion("HOUSE_INDOOR_PHOTO_TYPE >", value, "houseIndoorPhotoType");
			return (Criteria) this;
		}

		public Criteria andHouseIndoorPhotoTypeGreaterThanOrEqualTo(Byte value) {
			addCriterion("HOUSE_INDOOR_PHOTO_TYPE >=", value, "houseIndoorPhotoType");
			return (Criteria) this;
		}

		public Criteria andHouseIndoorPhotoTypeLessThan(Byte value) {
			addCriterion("HOUSE_INDOOR_PHOTO_TYPE <", value, "houseIndoorPhotoType");
			return (Criteria) this;
		}

		public Criteria andHouseIndoorPhotoTypeLessThanOrEqualTo(Byte value) {
			addCriterion("HOUSE_INDOOR_PHOTO_TYPE <=", value, "houseIndoorPhotoType");
			return (Criteria) this;
		}

		public Criteria andHouseIndoorPhotoTypeIn(List<Byte> values) {
			addCriterion("HOUSE_INDOOR_PHOTO_TYPE in", values, "houseIndoorPhotoType");
			return (Criteria) this;
		}

		public Criteria andHouseIndoorPhotoTypeNotIn(List<Byte> values) {
			addCriterion("HOUSE_INDOOR_PHOTO_TYPE not in", values, "houseIndoorPhotoType");
			return (Criteria) this;
		}

		public Criteria andHouseIndoorPhotoTypeBetween(Byte value1, Byte value2) {
			addCriterion("HOUSE_INDOOR_PHOTO_TYPE between", value1, value2, "houseIndoorPhotoType");
			return (Criteria) this;
		}

		public Criteria andHouseIndoorPhotoTypeNotBetween(Byte value1, Byte value2) {
			addCriterion("HOUSE_INDOOR_PHOTO_TYPE not between", value1, value2, "houseIndoorPhotoType");
			return (Criteria) this;
		}

		public Criteria andFkPhotoIsNull() {
			addCriterion("FK_PHOTO is null");
			return (Criteria) this;
		}

		public Criteria andFkPhotoIsNotNull() {
			addCriterion("FK_PHOTO is not null");
			return (Criteria) this;
		}

		public Criteria andFkPhotoEqualTo(Byte value) {
			addCriterion("FK_PHOTO =", value, "fkPhoto");
			return (Criteria) this;
		}

		public Criteria andFkPhotoNotEqualTo(Byte value) {
			addCriterion("FK_PHOTO <>", value, "fkPhoto");
			return (Criteria) this;
		}

		public Criteria andFkPhotoGreaterThan(Byte value) {
			addCriterion("FK_PHOTO >", value, "fkPhoto");
			return (Criteria) this;
		}

		public Criteria andFkPhotoGreaterThanOrEqualTo(Byte value) {
			addCriterion("FK_PHOTO >=", value, "fkPhoto");
			return (Criteria) this;
		}

		public Criteria andFkPhotoLessThan(Byte value) {
			addCriterion("FK_PHOTO <", value, "fkPhoto");
			return (Criteria) this;
		}

		public Criteria andFkPhotoLessThanOrEqualTo(Byte value) {
			addCriterion("FK_PHOTO <=", value, "fkPhoto");
			return (Criteria) this;
		}

		public Criteria andFkPhotoIn(List<Byte> values) {
			addCriterion("FK_PHOTO in", values, "fkPhoto");
			return (Criteria) this;
		}

		public Criteria andFkPhotoNotIn(List<Byte> values) {
			addCriterion("FK_PHOTO not in", values, "fkPhoto");
			return (Criteria) this;
		}

		public Criteria andFkPhotoBetween(Byte value1, Byte value2) {
			addCriterion("FK_PHOTO between", value1, value2, "fkPhoto");
			return (Criteria) this;
		}

		public Criteria andFkPhotoNotBetween(Byte value1, Byte value2) {
			addCriterion("FK_PHOTO not between", value1, value2, "fkPhoto");
			return (Criteria) this;
		}

		public Criteria andOrganizationIdIsNull() {
			addCriterion("ORGANIZATION_ID is null");
			return (Criteria) this;
		}

		public Criteria andOrganizationIdIsNotNull() {
			addCriterion("ORGANIZATION_ID is not null");
			return (Criteria) this;
		}

		public Criteria andOrganizationIdEqualTo(Integer value) {
			addCriterion("ORGANIZATION_ID =", value, "organizationId");
			return (Criteria) this;
		}

		public Criteria andOrganizationIdNotEqualTo(Integer value) {
			addCriterion("ORGANIZATION_ID <>", value, "organizationId");
			return (Criteria) this;
		}

		public Criteria andOrganizationIdGreaterThan(Integer value) {
			addCriterion("ORGANIZATION_ID >", value, "organizationId");
			return (Criteria) this;
		}

		public Criteria andOrganizationIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("ORGANIZATION_ID >=", value, "organizationId");
			return (Criteria) this;
		}

		public Criteria andOrganizationIdLessThan(Integer value) {
			addCriterion("ORGANIZATION_ID <", value, "organizationId");
			return (Criteria) this;
		}

		public Criteria andOrganizationIdLessThanOrEqualTo(Integer value) {
			addCriterion("ORGANIZATION_ID <=", value, "organizationId");
			return (Criteria) this;
		}

		public Criteria andOrganizationIdIn(List<Integer> values) {
			addCriterion("ORGANIZATION_ID in", values, "organizationId");
			return (Criteria) this;
		}

		public Criteria andOrganizationIdNotIn(List<Integer> values) {
			addCriterion("ORGANIZATION_ID not in", values, "organizationId");
			return (Criteria) this;
		}

		public Criteria andOrganizationIdBetween(Integer value1, Integer value2) {
			addCriterion("ORGANIZATION_ID between", value1, value2, "organizationId");
			return (Criteria) this;
		}

		public Criteria andOrganizationIdNotBetween(Integer value1, Integer value2) {
			addCriterion("ORGANIZATION_ID not between", value1, value2, "organizationId");
			return (Criteria) this;
		}

		public Criteria andOrganizationNameIsNull() {
			addCriterion("ORGANIZATION_NAME is null");
			return (Criteria) this;
		}

		public Criteria andOrganizationNameIsNotNull() {
			addCriterion("ORGANIZATION_NAME is not null");
			return (Criteria) this;
		}

		public Criteria andOrganizationNameEqualTo(String value) {
			addCriterion("ORGANIZATION_NAME =", value, "organizationName");
			return (Criteria) this;
		}

		public Criteria andOrganizationNameNotEqualTo(String value) {
			addCriterion("ORGANIZATION_NAME <>", value, "organizationName");
			return (Criteria) this;
		}

		public Criteria andOrganizationNameGreaterThan(String value) {
			addCriterion("ORGANIZATION_NAME >", value, "organizationName");
			return (Criteria) this;
		}

		public Criteria andOrganizationNameGreaterThanOrEqualTo(String value) {
			addCriterion("ORGANIZATION_NAME >=", value, "organizationName");
			return (Criteria) this;
		}

		public Criteria andOrganizationNameLessThan(String value) {
			addCriterion("ORGANIZATION_NAME <", value, "organizationName");
			return (Criteria) this;
		}

		public Criteria andOrganizationNameLessThanOrEqualTo(String value) {
			addCriterion("ORGANIZATION_NAME <=", value, "organizationName");
			return (Criteria) this;
		}

		public Criteria andOrganizationNameLike(String value) {
			addCriterion("ORGANIZATION_NAME like", value, "organizationName");
			return (Criteria) this;
		}

		public Criteria andOrganizationNameNotLike(String value) {
			addCriterion("ORGANIZATION_NAME not like", value, "organizationName");
			return (Criteria) this;
		}

		public Criteria andOrganizationNameIn(List<String> values) {
			addCriterion("ORGANIZATION_NAME in", values, "organizationName");
			return (Criteria) this;
		}

		public Criteria andOrganizationNameNotIn(List<String> values) {
			addCriterion("ORGANIZATION_NAME not in", values, "organizationName");
			return (Criteria) this;
		}

		public Criteria andOrganizationNameBetween(String value1, String value2) {
			addCriterion("ORGANIZATION_NAME between", value1, value2, "organizationName");
			return (Criteria) this;
		}

		public Criteria andOrganizationNameNotBetween(String value1, String value2) {
			addCriterion("ORGANIZATION_NAME not between", value1, value2, "organizationName");
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