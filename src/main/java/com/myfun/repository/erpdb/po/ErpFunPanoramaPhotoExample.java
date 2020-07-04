package com.myfun.repository.erpdb.po;

import com.myfun.repository.support.generator.shard.ShardDb;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ErpFunPanoramaPhotoExample extends ShardDb {
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
	public ErpFunPanoramaPhotoExample() {
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

		public Criteria andArchiveIdIsNull() {
			addCriterion("ARCHIVE_ID is null");
			return (Criteria) this;
		}

		public Criteria andArchiveIdIsNotNull() {
			addCriterion("ARCHIVE_ID is not null");
			return (Criteria) this;
		}

		public Criteria andArchiveIdEqualTo(Integer value) {
			addCriterion("ARCHIVE_ID =", value, "archiveId");
			return (Criteria) this;
		}

		public Criteria andArchiveIdNotEqualTo(Integer value) {
			addCriterion("ARCHIVE_ID <>", value, "archiveId");
			return (Criteria) this;
		}

		public Criteria andArchiveIdGreaterThan(Integer value) {
			addCriterion("ARCHIVE_ID >", value, "archiveId");
			return (Criteria) this;
		}

		public Criteria andArchiveIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("ARCHIVE_ID >=", value, "archiveId");
			return (Criteria) this;
		}

		public Criteria andArchiveIdLessThan(Integer value) {
			addCriterion("ARCHIVE_ID <", value, "archiveId");
			return (Criteria) this;
		}

		public Criteria andArchiveIdLessThanOrEqualTo(Integer value) {
			addCriterion("ARCHIVE_ID <=", value, "archiveId");
			return (Criteria) this;
		}

		public Criteria andArchiveIdIn(List<Integer> values) {
			addCriterion("ARCHIVE_ID in", values, "archiveId");
			return (Criteria) this;
		}

		public Criteria andArchiveIdNotIn(List<Integer> values) {
			addCriterion("ARCHIVE_ID not in", values, "archiveId");
			return (Criteria) this;
		}

		public Criteria andArchiveIdBetween(Integer value1, Integer value2) {
			addCriterion("ARCHIVE_ID between", value1, value2, "archiveId");
			return (Criteria) this;
		}

		public Criteria andArchiveIdNotBetween(Integer value1, Integer value2) {
			addCriterion("ARCHIVE_ID not between", value1, value2, "archiveId");
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

		public Criteria andUploadDateEqualTo(Date value) {
			addCriterion("UPLOAD_DATE =", value, "uploadDate");
			return (Criteria) this;
		}

		public Criteria andUploadDateNotEqualTo(Date value) {
			addCriterion("UPLOAD_DATE <>", value, "uploadDate");
			return (Criteria) this;
		}

		public Criteria andUploadDateGreaterThan(Date value) {
			addCriterion("UPLOAD_DATE >", value, "uploadDate");
			return (Criteria) this;
		}

		public Criteria andUploadDateGreaterThanOrEqualTo(Date value) {
			addCriterion("UPLOAD_DATE >=", value, "uploadDate");
			return (Criteria) this;
		}

		public Criteria andUploadDateLessThan(Date value) {
			addCriterion("UPLOAD_DATE <", value, "uploadDate");
			return (Criteria) this;
		}

		public Criteria andUploadDateLessThanOrEqualTo(Date value) {
			addCriterion("UPLOAD_DATE <=", value, "uploadDate");
			return (Criteria) this;
		}

		public Criteria andUploadDateIn(List<Date> values) {
			addCriterion("UPLOAD_DATE in", values, "uploadDate");
			return (Criteria) this;
		}

		public Criteria andUploadDateNotIn(List<Date> values) {
			addCriterion("UPLOAD_DATE not in", values, "uploadDate");
			return (Criteria) this;
		}

		public Criteria andUploadDateBetween(Date value1, Date value2) {
			addCriterion("UPLOAD_DATE between", value1, value2, "uploadDate");
			return (Criteria) this;
		}

		public Criteria andUploadDateNotBetween(Date value1, Date value2) {
			addCriterion("UPLOAD_DATE not between", value1, value2, "uploadDate");
			return (Criteria) this;
		}

		public Criteria andSceneIsNull() {
			addCriterion("SCENE is null");
			return (Criteria) this;
		}

		public Criteria andSceneIsNotNull() {
			addCriterion("SCENE is not null");
			return (Criteria) this;
		}

		public Criteria andSceneEqualTo(String value) {
			addCriterion("SCENE =", value, "scene");
			return (Criteria) this;
		}

		public Criteria andSceneNotEqualTo(String value) {
			addCriterion("SCENE <>", value, "scene");
			return (Criteria) this;
		}

		public Criteria andSceneGreaterThan(String value) {
			addCriterion("SCENE >", value, "scene");
			return (Criteria) this;
		}

		public Criteria andSceneGreaterThanOrEqualTo(String value) {
			addCriterion("SCENE >=", value, "scene");
			return (Criteria) this;
		}

		public Criteria andSceneLessThan(String value) {
			addCriterion("SCENE <", value, "scene");
			return (Criteria) this;
		}

		public Criteria andSceneLessThanOrEqualTo(String value) {
			addCriterion("SCENE <=", value, "scene");
			return (Criteria) this;
		}

		public Criteria andSceneLike(String value) {
			addCriterion("SCENE like", value, "scene");
			return (Criteria) this;
		}

		public Criteria andSceneNotLike(String value) {
			addCriterion("SCENE not like", value, "scene");
			return (Criteria) this;
		}

		public Criteria andSceneIn(List<String> values) {
			addCriterion("SCENE in", values, "scene");
			return (Criteria) this;
		}

		public Criteria andSceneNotIn(List<String> values) {
			addCriterion("SCENE not in", values, "scene");
			return (Criteria) this;
		}

		public Criteria andSceneBetween(String value1, String value2) {
			addCriterion("SCENE between", value1, value2, "scene");
			return (Criteria) this;
		}

		public Criteria andSceneNotBetween(String value1, String value2) {
			addCriterion("SCENE not between", value1, value2, "scene");
			return (Criteria) this;
		}

		public Criteria andCfovIsNull() {
			addCriterion("CFOV is null");
			return (Criteria) this;
		}

		public Criteria andCfovIsNotNull() {
			addCriterion("CFOV is not null");
			return (Criteria) this;
		}

		public Criteria andCfovEqualTo(String value) {
			addCriterion("CFOV =", value, "cfov");
			return (Criteria) this;
		}

		public Criteria andCfovNotEqualTo(String value) {
			addCriterion("CFOV <>", value, "cfov");
			return (Criteria) this;
		}

		public Criteria andCfovGreaterThan(String value) {
			addCriterion("CFOV >", value, "cfov");
			return (Criteria) this;
		}

		public Criteria andCfovGreaterThanOrEqualTo(String value) {
			addCriterion("CFOV >=", value, "cfov");
			return (Criteria) this;
		}

		public Criteria andCfovLessThan(String value) {
			addCriterion("CFOV <", value, "cfov");
			return (Criteria) this;
		}

		public Criteria andCfovLessThanOrEqualTo(String value) {
			addCriterion("CFOV <=", value, "cfov");
			return (Criteria) this;
		}

		public Criteria andCfovLike(String value) {
			addCriterion("CFOV like", value, "cfov");
			return (Criteria) this;
		}

		public Criteria andCfovNotLike(String value) {
			addCriterion("CFOV not like", value, "cfov");
			return (Criteria) this;
		}

		public Criteria andCfovIn(List<String> values) {
			addCriterion("CFOV in", values, "cfov");
			return (Criteria) this;
		}

		public Criteria andCfovNotIn(List<String> values) {
			addCriterion("CFOV not in", values, "cfov");
			return (Criteria) this;
		}

		public Criteria andCfovBetween(String value1, String value2) {
			addCriterion("CFOV between", value1, value2, "cfov");
			return (Criteria) this;
		}

		public Criteria andCfovNotBetween(String value1, String value2) {
			addCriterion("CFOV not between", value1, value2, "cfov");
			return (Criteria) this;
		}

		public Criteria andPhotoStatusIsNull() {
			addCriterion("PHOTO_STATUS is null");
			return (Criteria) this;
		}

		public Criteria andPhotoStatusIsNotNull() {
			addCriterion("PHOTO_STATUS is not null");
			return (Criteria) this;
		}

		public Criteria andPhotoStatusEqualTo(Byte value) {
			addCriterion("PHOTO_STATUS =", value, "photoStatus");
			return (Criteria) this;
		}

		public Criteria andPhotoStatusNotEqualTo(Byte value) {
			addCriterion("PHOTO_STATUS <>", value, "photoStatus");
			return (Criteria) this;
		}

		public Criteria andPhotoStatusGreaterThan(Byte value) {
			addCriterion("PHOTO_STATUS >", value, "photoStatus");
			return (Criteria) this;
		}

		public Criteria andPhotoStatusGreaterThanOrEqualTo(Byte value) {
			addCriterion("PHOTO_STATUS >=", value, "photoStatus");
			return (Criteria) this;
		}

		public Criteria andPhotoStatusLessThan(Byte value) {
			addCriterion("PHOTO_STATUS <", value, "photoStatus");
			return (Criteria) this;
		}

		public Criteria andPhotoStatusLessThanOrEqualTo(Byte value) {
			addCriterion("PHOTO_STATUS <=", value, "photoStatus");
			return (Criteria) this;
		}

		public Criteria andPhotoStatusIn(List<Byte> values) {
			addCriterion("PHOTO_STATUS in", values, "photoStatus");
			return (Criteria) this;
		}

		public Criteria andPhotoStatusNotIn(List<Byte> values) {
			addCriterion("PHOTO_STATUS not in", values, "photoStatus");
			return (Criteria) this;
		}

		public Criteria andPhotoStatusBetween(Byte value1, Byte value2) {
			addCriterion("PHOTO_STATUS between", value1, value2, "photoStatus");
			return (Criteria) this;
		}

		public Criteria andPhotoStatusNotBetween(Byte value1, Byte value2) {
			addCriterion("PHOTO_STATUS not between", value1, value2, "photoStatus");
			return (Criteria) this;
		}

		public Criteria andDeviceNumIsNull() {
			addCriterion("DEVICE_NUM is null");
			return (Criteria) this;
		}

		public Criteria andDeviceNumIsNotNull() {
			addCriterion("DEVICE_NUM is not null");
			return (Criteria) this;
		}

		public Criteria andDeviceNumEqualTo(String value) {
			addCriterion("DEVICE_NUM =", value, "deviceNum");
			return (Criteria) this;
		}

		public Criteria andDeviceNumNotEqualTo(String value) {
			addCriterion("DEVICE_NUM <>", value, "deviceNum");
			return (Criteria) this;
		}

		public Criteria andDeviceNumGreaterThan(String value) {
			addCriterion("DEVICE_NUM >", value, "deviceNum");
			return (Criteria) this;
		}

		public Criteria andDeviceNumGreaterThanOrEqualTo(String value) {
			addCriterion("DEVICE_NUM >=", value, "deviceNum");
			return (Criteria) this;
		}

		public Criteria andDeviceNumLessThan(String value) {
			addCriterion("DEVICE_NUM <", value, "deviceNum");
			return (Criteria) this;
		}

		public Criteria andDeviceNumLessThanOrEqualTo(String value) {
			addCriterion("DEVICE_NUM <=", value, "deviceNum");
			return (Criteria) this;
		}

		public Criteria andDeviceNumLike(String value) {
			addCriterion("DEVICE_NUM like", value, "deviceNum");
			return (Criteria) this;
		}

		public Criteria andDeviceNumNotLike(String value) {
			addCriterion("DEVICE_NUM not like", value, "deviceNum");
			return (Criteria) this;
		}

		public Criteria andDeviceNumIn(List<String> values) {
			addCriterion("DEVICE_NUM in", values, "deviceNum");
			return (Criteria) this;
		}

		public Criteria andDeviceNumNotIn(List<String> values) {
			addCriterion("DEVICE_NUM not in", values, "deviceNum");
			return (Criteria) this;
		}

		public Criteria andDeviceNumBetween(String value1, String value2) {
			addCriterion("DEVICE_NUM between", value1, value2, "deviceNum");
			return (Criteria) this;
		}

		public Criteria andDeviceNumNotBetween(String value1, String value2) {
			addCriterion("DEVICE_NUM not between", value1, value2, "deviceNum");
			return (Criteria) this;
		}

		public Criteria andCaseNoIsNull() {
			addCriterion("CASE_NO is null");
			return (Criteria) this;
		}

		public Criteria andCaseNoIsNotNull() {
			addCriterion("CASE_NO is not null");
			return (Criteria) this;
		}

		public Criteria andCaseNoEqualTo(String value) {
			addCriterion("CASE_NO =", value, "caseNo");
			return (Criteria) this;
		}

		public Criteria andCaseNoNotEqualTo(String value) {
			addCriterion("CASE_NO <>", value, "caseNo");
			return (Criteria) this;
		}

		public Criteria andCaseNoGreaterThan(String value) {
			addCriterion("CASE_NO >", value, "caseNo");
			return (Criteria) this;
		}

		public Criteria andCaseNoGreaterThanOrEqualTo(String value) {
			addCriterion("CASE_NO >=", value, "caseNo");
			return (Criteria) this;
		}

		public Criteria andCaseNoLessThan(String value) {
			addCriterion("CASE_NO <", value, "caseNo");
			return (Criteria) this;
		}

		public Criteria andCaseNoLessThanOrEqualTo(String value) {
			addCriterion("CASE_NO <=", value, "caseNo");
			return (Criteria) this;
		}

		public Criteria andCaseNoLike(String value) {
			addCriterion("CASE_NO like", value, "caseNo");
			return (Criteria) this;
		}

		public Criteria andCaseNoNotLike(String value) {
			addCriterion("CASE_NO not like", value, "caseNo");
			return (Criteria) this;
		}

		public Criteria andCaseNoIn(List<String> values) {
			addCriterion("CASE_NO in", values, "caseNo");
			return (Criteria) this;
		}

		public Criteria andCaseNoNotIn(List<String> values) {
			addCriterion("CASE_NO not in", values, "caseNo");
			return (Criteria) this;
		}

		public Criteria andCaseNoBetween(String value1, String value2) {
			addCriterion("CASE_NO between", value1, value2, "caseNo");
			return (Criteria) this;
		}

		public Criteria andCaseNoNotBetween(String value1, String value2) {
			addCriterion("CASE_NO not between", value1, value2, "caseNo");
			return (Criteria) this;
		}

		public Criteria andSourceIsNull() {
			addCriterion("[SOURCE] is null");
			return (Criteria) this;
		}

		public Criteria andSourceIsNotNull() {
			addCriterion("[SOURCE] is not null");
			return (Criteria) this;
		}

		public Criteria andSourceEqualTo(Byte value) {
			addCriterion("[SOURCE] =", value, "source");
			return (Criteria) this;
		}

		public Criteria andSourceNotEqualTo(Byte value) {
			addCriterion("[SOURCE] <>", value, "source");
			return (Criteria) this;
		}

		public Criteria andSourceGreaterThan(Byte value) {
			addCriterion("[SOURCE] >", value, "source");
			return (Criteria) this;
		}

		public Criteria andSourceGreaterThanOrEqualTo(Byte value) {
			addCriterion("[SOURCE] >=", value, "source");
			return (Criteria) this;
		}

		public Criteria andSourceLessThan(Byte value) {
			addCriterion("[SOURCE] <", value, "source");
			return (Criteria) this;
		}

		public Criteria andSourceLessThanOrEqualTo(Byte value) {
			addCriterion("[SOURCE] <=", value, "source");
			return (Criteria) this;
		}

		public Criteria andSourceIn(List<Byte> values) {
			addCriterion("[SOURCE] in", values, "source");
			return (Criteria) this;
		}

		public Criteria andSourceNotIn(List<Byte> values) {
			addCriterion("[SOURCE] not in", values, "source");
			return (Criteria) this;
		}

		public Criteria andSourceBetween(Byte value1, Byte value2) {
			addCriterion("[SOURCE] between", value1, value2, "source");
			return (Criteria) this;
		}

		public Criteria andSourceNotBetween(Byte value1, Byte value2) {
			addCriterion("[SOURCE] not between", value1, value2, "source");
			return (Criteria) this;
		}

		public Criteria andVrReviewFlagIsNull() {
			addCriterion("VR_REVIEW_FLAG is null");
			return (Criteria) this;
		}

		public Criteria andVrReviewFlagIsNotNull() {
			addCriterion("VR_REVIEW_FLAG is not null");
			return (Criteria) this;
		}

		public Criteria andVrReviewFlagEqualTo(Byte value) {
			addCriterion("VR_REVIEW_FLAG =", value, "vrReviewFlag");
			return (Criteria) this;
		}

		public Criteria andVrReviewFlagNotEqualTo(Byte value) {
			addCriterion("VR_REVIEW_FLAG <>", value, "vrReviewFlag");
			return (Criteria) this;
		}

		public Criteria andVrReviewFlagGreaterThan(Byte value) {
			addCriterion("VR_REVIEW_FLAG >", value, "vrReviewFlag");
			return (Criteria) this;
		}

		public Criteria andVrReviewFlagGreaterThanOrEqualTo(Byte value) {
			addCriterion("VR_REVIEW_FLAG >=", value, "vrReviewFlag");
			return (Criteria) this;
		}

		public Criteria andVrReviewFlagLessThan(Byte value) {
			addCriterion("VR_REVIEW_FLAG <", value, "vrReviewFlag");
			return (Criteria) this;
		}

		public Criteria andVrReviewFlagLessThanOrEqualTo(Byte value) {
			addCriterion("VR_REVIEW_FLAG <=", value, "vrReviewFlag");
			return (Criteria) this;
		}

		public Criteria andVrReviewFlagIn(List<Byte> values) {
			addCriterion("VR_REVIEW_FLAG in", values, "vrReviewFlag");
			return (Criteria) this;
		}

		public Criteria andVrReviewFlagNotIn(List<Byte> values) {
			addCriterion("VR_REVIEW_FLAG not in", values, "vrReviewFlag");
			return (Criteria) this;
		}

		public Criteria andVrReviewFlagBetween(Byte value1, Byte value2) {
			addCriterion("VR_REVIEW_FLAG between", value1, value2, "vrReviewFlag");
			return (Criteria) this;
		}

		public Criteria andVrReviewFlagNotBetween(Byte value1, Byte value2) {
			addCriterion("VR_REVIEW_FLAG not between", value1, value2, "vrReviewFlag");
			return (Criteria) this;
		}

		public Criteria andVrReviewUidIsNull() {
			addCriterion("VR_REVIEW_UID is null");
			return (Criteria) this;
		}

		public Criteria andVrReviewUidIsNotNull() {
			addCriterion("VR_REVIEW_UID is not null");
			return (Criteria) this;
		}

		public Criteria andVrReviewUidEqualTo(Integer value) {
			addCriterion("VR_REVIEW_UID =", value, "vrReviewUid");
			return (Criteria) this;
		}

		public Criteria andVrReviewUidNotEqualTo(Integer value) {
			addCriterion("VR_REVIEW_UID <>", value, "vrReviewUid");
			return (Criteria) this;
		}

		public Criteria andVrReviewUidGreaterThan(Integer value) {
			addCriterion("VR_REVIEW_UID >", value, "vrReviewUid");
			return (Criteria) this;
		}

		public Criteria andVrReviewUidGreaterThanOrEqualTo(Integer value) {
			addCriterion("VR_REVIEW_UID >=", value, "vrReviewUid");
			return (Criteria) this;
		}

		public Criteria andVrReviewUidLessThan(Integer value) {
			addCriterion("VR_REVIEW_UID <", value, "vrReviewUid");
			return (Criteria) this;
		}

		public Criteria andVrReviewUidLessThanOrEqualTo(Integer value) {
			addCriterion("VR_REVIEW_UID <=", value, "vrReviewUid");
			return (Criteria) this;
		}

		public Criteria andVrReviewUidIn(List<Integer> values) {
			addCriterion("VR_REVIEW_UID in", values, "vrReviewUid");
			return (Criteria) this;
		}

		public Criteria andVrReviewUidNotIn(List<Integer> values) {
			addCriterion("VR_REVIEW_UID not in", values, "vrReviewUid");
			return (Criteria) this;
		}

		public Criteria andVrReviewUidBetween(Integer value1, Integer value2) {
			addCriterion("VR_REVIEW_UID between", value1, value2, "vrReviewUid");
			return (Criteria) this;
		}

		public Criteria andVrReviewUidNotBetween(Integer value1, Integer value2) {
			addCriterion("VR_REVIEW_UID not between", value1, value2, "vrReviewUid");
			return (Criteria) this;
		}

		public Criteria andVrReviewTimeIsNull() {
			addCriterion("VR_REVIEW_TIME is null");
			return (Criteria) this;
		}

		public Criteria andVrReviewTimeIsNotNull() {
			addCriterion("VR_REVIEW_TIME is not null");
			return (Criteria) this;
		}

		public Criteria andVrReviewTimeEqualTo(Date value) {
			addCriterion("VR_REVIEW_TIME =", value, "vrReviewTime");
			return (Criteria) this;
		}

		public Criteria andVrReviewTimeNotEqualTo(Date value) {
			addCriterion("VR_REVIEW_TIME <>", value, "vrReviewTime");
			return (Criteria) this;
		}

		public Criteria andVrReviewTimeGreaterThan(Date value) {
			addCriterion("VR_REVIEW_TIME >", value, "vrReviewTime");
			return (Criteria) this;
		}

		public Criteria andVrReviewTimeGreaterThanOrEqualTo(Date value) {
			addCriterion("VR_REVIEW_TIME >=", value, "vrReviewTime");
			return (Criteria) this;
		}

		public Criteria andVrReviewTimeLessThan(Date value) {
			addCriterion("VR_REVIEW_TIME <", value, "vrReviewTime");
			return (Criteria) this;
		}

		public Criteria andVrReviewTimeLessThanOrEqualTo(Date value) {
			addCriterion("VR_REVIEW_TIME <=", value, "vrReviewTime");
			return (Criteria) this;
		}

		public Criteria andVrReviewTimeIn(List<Date> values) {
			addCriterion("VR_REVIEW_TIME in", values, "vrReviewTime");
			return (Criteria) this;
		}

		public Criteria andVrReviewTimeNotIn(List<Date> values) {
			addCriterion("VR_REVIEW_TIME not in", values, "vrReviewTime");
			return (Criteria) this;
		}

		public Criteria andVrReviewTimeBetween(Date value1, Date value2) {
			addCriterion("VR_REVIEW_TIME between", value1, value2, "vrReviewTime");
			return (Criteria) this;
		}

		public Criteria andVrReviewTimeNotBetween(Date value1, Date value2) {
			addCriterion("VR_REVIEW_TIME not between", value1, value2, "vrReviewTime");
			return (Criteria) this;
		}

		public Criteria andVrReviewDescIsNull() {
			addCriterion("VR_REVIEW_DESC is null");
			return (Criteria) this;
		}

		public Criteria andVrReviewDescIsNotNull() {
			addCriterion("VR_REVIEW_DESC is not null");
			return (Criteria) this;
		}

		public Criteria andVrReviewDescEqualTo(String value) {
			addCriterion("VR_REVIEW_DESC =", value, "vrReviewDesc");
			return (Criteria) this;
		}

		public Criteria andVrReviewDescNotEqualTo(String value) {
			addCriterion("VR_REVIEW_DESC <>", value, "vrReviewDesc");
			return (Criteria) this;
		}

		public Criteria andVrReviewDescGreaterThan(String value) {
			addCriterion("VR_REVIEW_DESC >", value, "vrReviewDesc");
			return (Criteria) this;
		}

		public Criteria andVrReviewDescGreaterThanOrEqualTo(String value) {
			addCriterion("VR_REVIEW_DESC >=", value, "vrReviewDesc");
			return (Criteria) this;
		}

		public Criteria andVrReviewDescLessThan(String value) {
			addCriterion("VR_REVIEW_DESC <", value, "vrReviewDesc");
			return (Criteria) this;
		}

		public Criteria andVrReviewDescLessThanOrEqualTo(String value) {
			addCriterion("VR_REVIEW_DESC <=", value, "vrReviewDesc");
			return (Criteria) this;
		}

		public Criteria andVrReviewDescLike(String value) {
			addCriterion("VR_REVIEW_DESC like", value, "vrReviewDesc");
			return (Criteria) this;
		}

		public Criteria andVrReviewDescNotLike(String value) {
			addCriterion("VR_REVIEW_DESC not like", value, "vrReviewDesc");
			return (Criteria) this;
		}

		public Criteria andVrReviewDescIn(List<String> values) {
			addCriterion("VR_REVIEW_DESC in", values, "vrReviewDesc");
			return (Criteria) this;
		}

		public Criteria andVrReviewDescNotIn(List<String> values) {
			addCriterion("VR_REVIEW_DESC not in", values, "vrReviewDesc");
			return (Criteria) this;
		}

		public Criteria andVrReviewDescBetween(String value1, String value2) {
			addCriterion("VR_REVIEW_DESC between", value1, value2, "vrReviewDesc");
			return (Criteria) this;
		}

		public Criteria andVrReviewDescNotBetween(String value1, String value2) {
			addCriterion("VR_REVIEW_DESC not between", value1, value2, "vrReviewDesc");
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

		public Criteria andServiceIdIsNull() {
			addCriterion("SERVICE_ID is null");
			return (Criteria) this;
		}

		public Criteria andServiceIdIsNotNull() {
			addCriterion("SERVICE_ID is not null");
			return (Criteria) this;
		}

		public Criteria andServiceIdEqualTo(Integer value) {
			addCriterion("SERVICE_ID =", value, "serviceId");
			return (Criteria) this;
		}

		public Criteria andServiceIdNotEqualTo(Integer value) {
			addCriterion("SERVICE_ID <>", value, "serviceId");
			return (Criteria) this;
		}

		public Criteria andServiceIdGreaterThan(Integer value) {
			addCriterion("SERVICE_ID >", value, "serviceId");
			return (Criteria) this;
		}

		public Criteria andServiceIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("SERVICE_ID >=", value, "serviceId");
			return (Criteria) this;
		}

		public Criteria andServiceIdLessThan(Integer value) {
			addCriterion("SERVICE_ID <", value, "serviceId");
			return (Criteria) this;
		}

		public Criteria andServiceIdLessThanOrEqualTo(Integer value) {
			addCriterion("SERVICE_ID <=", value, "serviceId");
			return (Criteria) this;
		}

		public Criteria andServiceIdIn(List<Integer> values) {
			addCriterion("SERVICE_ID in", values, "serviceId");
			return (Criteria) this;
		}

		public Criteria andServiceIdNotIn(List<Integer> values) {
			addCriterion("SERVICE_ID not in", values, "serviceId");
			return (Criteria) this;
		}

		public Criteria andServiceIdBetween(Integer value1, Integer value2) {
			addCriterion("SERVICE_ID between", value1, value2, "serviceId");
			return (Criteria) this;
		}

		public Criteria andServiceIdNotBetween(Integer value1, Integer value2) {
			addCriterion("SERVICE_ID not between", value1, value2, "serviceId");
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

		public Criteria andCameraTypeIsNull() {
			addCriterion("CAMERA_TYPE is null");
			return (Criteria) this;
		}

		public Criteria andCameraTypeIsNotNull() {
			addCriterion("CAMERA_TYPE is not null");
			return (Criteria) this;
		}

		public Criteria andCameraTypeEqualTo(Byte value) {
			addCriterion("CAMERA_TYPE =", value, "cameraType");
			return (Criteria) this;
		}

		public Criteria andCameraTypeNotEqualTo(Byte value) {
			addCriterion("CAMERA_TYPE <>", value, "cameraType");
			return (Criteria) this;
		}

		public Criteria andCameraTypeGreaterThan(Byte value) {
			addCriterion("CAMERA_TYPE >", value, "cameraType");
			return (Criteria) this;
		}

		public Criteria andCameraTypeGreaterThanOrEqualTo(Byte value) {
			addCriterion("CAMERA_TYPE >=", value, "cameraType");
			return (Criteria) this;
		}

		public Criteria andCameraTypeLessThan(Byte value) {
			addCriterion("CAMERA_TYPE <", value, "cameraType");
			return (Criteria) this;
		}

		public Criteria andCameraTypeLessThanOrEqualTo(Byte value) {
			addCriterion("CAMERA_TYPE <=", value, "cameraType");
			return (Criteria) this;
		}

		public Criteria andCameraTypeIn(List<Byte> values) {
			addCriterion("CAMERA_TYPE in", values, "cameraType");
			return (Criteria) this;
		}

		public Criteria andCameraTypeNotIn(List<Byte> values) {
			addCriterion("CAMERA_TYPE not in", values, "cameraType");
			return (Criteria) this;
		}

		public Criteria andCameraTypeBetween(Byte value1, Byte value2) {
			addCriterion("CAMERA_TYPE between", value1, value2, "cameraType");
			return (Criteria) this;
		}

		public Criteria andCameraTypeNotBetween(Byte value1, Byte value2) {
			addCriterion("CAMERA_TYPE not between", value1, value2, "cameraType");
			return (Criteria) this;
		}

		public Criteria andSceneCnIsNull() {
			addCriterion("SCENE_CN is null");
			return (Criteria) this;
		}

		public Criteria andSceneCnIsNotNull() {
			addCriterion("SCENE_CN is not null");
			return (Criteria) this;
		}

		public Criteria andSceneCnEqualTo(String value) {
			addCriterion("SCENE_CN =", value, "sceneCn");
			return (Criteria) this;
		}

		public Criteria andSceneCnNotEqualTo(String value) {
			addCriterion("SCENE_CN <>", value, "sceneCn");
			return (Criteria) this;
		}

		public Criteria andSceneCnGreaterThan(String value) {
			addCriterion("SCENE_CN >", value, "sceneCn");
			return (Criteria) this;
		}

		public Criteria andSceneCnGreaterThanOrEqualTo(String value) {
			addCriterion("SCENE_CN >=", value, "sceneCn");
			return (Criteria) this;
		}

		public Criteria andSceneCnLessThan(String value) {
			addCriterion("SCENE_CN <", value, "sceneCn");
			return (Criteria) this;
		}

		public Criteria andSceneCnLessThanOrEqualTo(String value) {
			addCriterion("SCENE_CN <=", value, "sceneCn");
			return (Criteria) this;
		}

		public Criteria andSceneCnLike(String value) {
			addCriterion("SCENE_CN like", value, "sceneCn");
			return (Criteria) this;
		}

		public Criteria andSceneCnNotLike(String value) {
			addCriterion("SCENE_CN not like", value, "sceneCn");
			return (Criteria) this;
		}

		public Criteria andSceneCnIn(List<String> values) {
			addCriterion("SCENE_CN in", values, "sceneCn");
			return (Criteria) this;
		}

		public Criteria andSceneCnNotIn(List<String> values) {
			addCriterion("SCENE_CN not in", values, "sceneCn");
			return (Criteria) this;
		}

		public Criteria andSceneCnBetween(String value1, String value2) {
			addCriterion("SCENE_CN between", value1, value2, "sceneCn");
			return (Criteria) this;
		}

		public Criteria andSceneCnNotBetween(String value1, String value2) {
			addCriterion("SCENE_CN not between", value1, value2, "sceneCn");
			return (Criteria) this;
		}

		public Criteria andHouseInnerFloorIsNull() {
			addCriterion("HOUSE_INNER_FLOOR is null");
			return (Criteria) this;
		}

		public Criteria andHouseInnerFloorIsNotNull() {
			addCriterion("HOUSE_INNER_FLOOR is not null");
			return (Criteria) this;
		}

		public Criteria andHouseInnerFloorEqualTo(Byte value) {
			addCriterion("HOUSE_INNER_FLOOR =", value, "houseInnerFloor");
			return (Criteria) this;
		}

		public Criteria andHouseInnerFloorNotEqualTo(Byte value) {
			addCriterion("HOUSE_INNER_FLOOR <>", value, "houseInnerFloor");
			return (Criteria) this;
		}

		public Criteria andHouseInnerFloorGreaterThan(Byte value) {
			addCriterion("HOUSE_INNER_FLOOR >", value, "houseInnerFloor");
			return (Criteria) this;
		}

		public Criteria andHouseInnerFloorGreaterThanOrEqualTo(Byte value) {
			addCriterion("HOUSE_INNER_FLOOR >=", value, "houseInnerFloor");
			return (Criteria) this;
		}

		public Criteria andHouseInnerFloorLessThan(Byte value) {
			addCriterion("HOUSE_INNER_FLOOR <", value, "houseInnerFloor");
			return (Criteria) this;
		}

		public Criteria andHouseInnerFloorLessThanOrEqualTo(Byte value) {
			addCriterion("HOUSE_INNER_FLOOR <=", value, "houseInnerFloor");
			return (Criteria) this;
		}

		public Criteria andHouseInnerFloorIn(List<Byte> values) {
			addCriterion("HOUSE_INNER_FLOOR in", values, "houseInnerFloor");
			return (Criteria) this;
		}

		public Criteria andHouseInnerFloorNotIn(List<Byte> values) {
			addCriterion("HOUSE_INNER_FLOOR not in", values, "houseInnerFloor");
			return (Criteria) this;
		}

		public Criteria andHouseInnerFloorBetween(Byte value1, Byte value2) {
			addCriterion("HOUSE_INNER_FLOOR between", value1, value2, "houseInnerFloor");
			return (Criteria) this;
		}

		public Criteria andHouseInnerFloorNotBetween(Byte value1, Byte value2) {
			addCriterion("HOUSE_INNER_FLOOR not between", value1, value2, "houseInnerFloor");
			return (Criteria) this;
		}

		public Criteria andFkPanoramaIsNull() {
			addCriterion("FK_PANORAMA is null");
			return (Criteria) this;
		}

		public Criteria andFkPanoramaIsNotNull() {
			addCriterion("FK_PANORAMA is not null");
			return (Criteria) this;
		}

		public Criteria andFkPanoramaEqualTo(Byte value) {
			addCriterion("FK_PANORAMA =", value, "fkPanorama");
			return (Criteria) this;
		}

		public Criteria andFkPanoramaNotEqualTo(Byte value) {
			addCriterion("FK_PANORAMA <>", value, "fkPanorama");
			return (Criteria) this;
		}

		public Criteria andFkPanoramaGreaterThan(Byte value) {
			addCriterion("FK_PANORAMA >", value, "fkPanorama");
			return (Criteria) this;
		}

		public Criteria andFkPanoramaGreaterThanOrEqualTo(Byte value) {
			addCriterion("FK_PANORAMA >=", value, "fkPanorama");
			return (Criteria) this;
		}

		public Criteria andFkPanoramaLessThan(Byte value) {
			addCriterion("FK_PANORAMA <", value, "fkPanorama");
			return (Criteria) this;
		}

		public Criteria andFkPanoramaLessThanOrEqualTo(Byte value) {
			addCriterion("FK_PANORAMA <=", value, "fkPanorama");
			return (Criteria) this;
		}

		public Criteria andFkPanoramaIn(List<Byte> values) {
			addCriterion("FK_PANORAMA in", values, "fkPanorama");
			return (Criteria) this;
		}

		public Criteria andFkPanoramaNotIn(List<Byte> values) {
			addCriterion("FK_PANORAMA not in", values, "fkPanorama");
			return (Criteria) this;
		}

		public Criteria andFkPanoramaBetween(Byte value1, Byte value2) {
			addCriterion("FK_PANORAMA between", value1, value2, "fkPanorama");
			return (Criteria) this;
		}

		public Criteria andFkPanoramaNotBetween(Byte value1, Byte value2) {
			addCriterion("FK_PANORAMA not between", value1, value2, "fkPanorama");
			return (Criteria) this;
		}

		public Criteria andVrCoordinateJsonIsNull() {
			addCriterion("VR_COORDINATE_JSON is null");
			return (Criteria) this;
		}

		public Criteria andVrCoordinateJsonIsNotNull() {
			addCriterion("VR_COORDINATE_JSON is not null");
			return (Criteria) this;
		}

		public Criteria andVrCoordinateJsonEqualTo(String value) {
			addCriterion("VR_COORDINATE_JSON =", value, "vrCoordinateJson");
			return (Criteria) this;
		}

		public Criteria andVrCoordinateJsonNotEqualTo(String value) {
			addCriterion("VR_COORDINATE_JSON <>", value, "vrCoordinateJson");
			return (Criteria) this;
		}

		public Criteria andVrCoordinateJsonGreaterThan(String value) {
			addCriterion("VR_COORDINATE_JSON >", value, "vrCoordinateJson");
			return (Criteria) this;
		}

		public Criteria andVrCoordinateJsonGreaterThanOrEqualTo(String value) {
			addCriterion("VR_COORDINATE_JSON >=", value, "vrCoordinateJson");
			return (Criteria) this;
		}

		public Criteria andVrCoordinateJsonLessThan(String value) {
			addCriterion("VR_COORDINATE_JSON <", value, "vrCoordinateJson");
			return (Criteria) this;
		}

		public Criteria andVrCoordinateJsonLessThanOrEqualTo(String value) {
			addCriterion("VR_COORDINATE_JSON <=", value, "vrCoordinateJson");
			return (Criteria) this;
		}

		public Criteria andVrCoordinateJsonLike(String value) {
			addCriterion("VR_COORDINATE_JSON like", value, "vrCoordinateJson");
			return (Criteria) this;
		}

		public Criteria andVrCoordinateJsonNotLike(String value) {
			addCriterion("VR_COORDINATE_JSON not like", value, "vrCoordinateJson");
			return (Criteria) this;
		}

		public Criteria andVrCoordinateJsonIn(List<String> values) {
			addCriterion("VR_COORDINATE_JSON in", values, "vrCoordinateJson");
			return (Criteria) this;
		}

		public Criteria andVrCoordinateJsonNotIn(List<String> values) {
			addCriterion("VR_COORDINATE_JSON not in", values, "vrCoordinateJson");
			return (Criteria) this;
		}

		public Criteria andVrCoordinateJsonBetween(String value1, String value2) {
			addCriterion("VR_COORDINATE_JSON between", value1, value2, "vrCoordinateJson");
			return (Criteria) this;
		}

		public Criteria andVrCoordinateJsonNotBetween(String value1, String value2) {
			addCriterion("VR_COORDINATE_JSON not between", value1, value2, "vrCoordinateJson");
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