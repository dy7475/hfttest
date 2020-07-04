package com.myfun.repository.erpdb.po;

import com.myfun.repository.support.generator.shard.ShardDb;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ErpTrackVideoExample extends ShardDb {
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
	public ErpTrackVideoExample() {
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

		public Criteria andVideoIdIsNull() {
			addCriterion("VIDEO_ID is null");
			return (Criteria) this;
		}

		public Criteria andVideoIdIsNotNull() {
			addCriterion("VIDEO_ID is not null");
			return (Criteria) this;
		}

		public Criteria andVideoIdEqualTo(Integer value) {
			addCriterion("VIDEO_ID =", value, "videoId");
			return (Criteria) this;
		}

		public Criteria andVideoIdNotEqualTo(Integer value) {
			addCriterion("VIDEO_ID <>", value, "videoId");
			return (Criteria) this;
		}

		public Criteria andVideoIdGreaterThan(Integer value) {
			addCriterion("VIDEO_ID >", value, "videoId");
			return (Criteria) this;
		}

		public Criteria andVideoIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("VIDEO_ID >=", value, "videoId");
			return (Criteria) this;
		}

		public Criteria andVideoIdLessThan(Integer value) {
			addCriterion("VIDEO_ID <", value, "videoId");
			return (Criteria) this;
		}

		public Criteria andVideoIdLessThanOrEqualTo(Integer value) {
			addCriterion("VIDEO_ID <=", value, "videoId");
			return (Criteria) this;
		}

		public Criteria andVideoIdIn(List<Integer> values) {
			addCriterion("VIDEO_ID in", values, "videoId");
			return (Criteria) this;
		}

		public Criteria andVideoIdNotIn(List<Integer> values) {
			addCriterion("VIDEO_ID not in", values, "videoId");
			return (Criteria) this;
		}

		public Criteria andVideoIdBetween(Integer value1, Integer value2) {
			addCriterion("VIDEO_ID between", value1, value2, "videoId");
			return (Criteria) this;
		}

		public Criteria andVideoIdNotBetween(Integer value1, Integer value2) {
			addCriterion("VIDEO_ID not between", value1, value2, "videoId");
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

		public Criteria andHouseIdIsNull() {
			addCriterion("HOUSE_ID is null");
			return (Criteria) this;
		}

		public Criteria andHouseIdIsNotNull() {
			addCriterion("HOUSE_ID is not null");
			return (Criteria) this;
		}

		public Criteria andHouseIdEqualTo(Integer value) {
			addCriterion("HOUSE_ID =", value, "houseId");
			return (Criteria) this;
		}

		public Criteria andHouseIdNotEqualTo(Integer value) {
			addCriterion("HOUSE_ID <>", value, "houseId");
			return (Criteria) this;
		}

		public Criteria andHouseIdGreaterThan(Integer value) {
			addCriterion("HOUSE_ID >", value, "houseId");
			return (Criteria) this;
		}

		public Criteria andHouseIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("HOUSE_ID >=", value, "houseId");
			return (Criteria) this;
		}

		public Criteria andHouseIdLessThan(Integer value) {
			addCriterion("HOUSE_ID <", value, "houseId");
			return (Criteria) this;
		}

		public Criteria andHouseIdLessThanOrEqualTo(Integer value) {
			addCriterion("HOUSE_ID <=", value, "houseId");
			return (Criteria) this;
		}

		public Criteria andHouseIdIn(List<Integer> values) {
			addCriterion("HOUSE_ID in", values, "houseId");
			return (Criteria) this;
		}

		public Criteria andHouseIdNotIn(List<Integer> values) {
			addCriterion("HOUSE_ID not in", values, "houseId");
			return (Criteria) this;
		}

		public Criteria andHouseIdBetween(Integer value1, Integer value2) {
			addCriterion("HOUSE_ID between", value1, value2, "houseId");
			return (Criteria) this;
		}

		public Criteria andHouseIdNotBetween(Integer value1, Integer value2) {
			addCriterion("HOUSE_ID not between", value1, value2, "houseId");
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

		public Criteria andVideoAddrIsNull() {
			addCriterion("VIDEO_ADDR is null");
			return (Criteria) this;
		}

		public Criteria andVideoAddrIsNotNull() {
			addCriterion("VIDEO_ADDR is not null");
			return (Criteria) this;
		}

		public Criteria andVideoAddrEqualTo(String value) {
			addCriterion("VIDEO_ADDR =", value, "videoAddr");
			return (Criteria) this;
		}

		public Criteria andVideoAddrNotEqualTo(String value) {
			addCriterion("VIDEO_ADDR <>", value, "videoAddr");
			return (Criteria) this;
		}

		public Criteria andVideoAddrGreaterThan(String value) {
			addCriterion("VIDEO_ADDR >", value, "videoAddr");
			return (Criteria) this;
		}

		public Criteria andVideoAddrGreaterThanOrEqualTo(String value) {
			addCriterion("VIDEO_ADDR >=", value, "videoAddr");
			return (Criteria) this;
		}

		public Criteria andVideoAddrLessThan(String value) {
			addCriterion("VIDEO_ADDR <", value, "videoAddr");
			return (Criteria) this;
		}

		public Criteria andVideoAddrLessThanOrEqualTo(String value) {
			addCriterion("VIDEO_ADDR <=", value, "videoAddr");
			return (Criteria) this;
		}

		public Criteria andVideoAddrLike(String value) {
			addCriterion("VIDEO_ADDR like", value, "videoAddr");
			return (Criteria) this;
		}

		public Criteria andVideoAddrNotLike(String value) {
			addCriterion("VIDEO_ADDR not like", value, "videoAddr");
			return (Criteria) this;
		}

		public Criteria andVideoAddrIn(List<String> values) {
			addCriterion("VIDEO_ADDR in", values, "videoAddr");
			return (Criteria) this;
		}

		public Criteria andVideoAddrNotIn(List<String> values) {
			addCriterion("VIDEO_ADDR not in", values, "videoAddr");
			return (Criteria) this;
		}

		public Criteria andVideoAddrBetween(String value1, String value2) {
			addCriterion("VIDEO_ADDR between", value1, value2, "videoAddr");
			return (Criteria) this;
		}

		public Criteria andVideoAddrNotBetween(String value1, String value2) {
			addCriterion("VIDEO_ADDR not between", value1, value2, "videoAddr");
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

		public Criteria andVideoStatusIsNull() {
			addCriterion("VIDEO_STATUS is null");
			return (Criteria) this;
		}

		public Criteria andVideoStatusIsNotNull() {
			addCriterion("VIDEO_STATUS is not null");
			return (Criteria) this;
		}

		public Criteria andVideoStatusEqualTo(Integer value) {
			addCriterion("VIDEO_STATUS =", value, "videoStatus");
			return (Criteria) this;
		}

		public Criteria andVideoStatusNotEqualTo(Integer value) {
			addCriterion("VIDEO_STATUS <>", value, "videoStatus");
			return (Criteria) this;
		}

		public Criteria andVideoStatusGreaterThan(Integer value) {
			addCriterion("VIDEO_STATUS >", value, "videoStatus");
			return (Criteria) this;
		}

		public Criteria andVideoStatusGreaterThanOrEqualTo(Integer value) {
			addCriterion("VIDEO_STATUS >=", value, "videoStatus");
			return (Criteria) this;
		}

		public Criteria andVideoStatusLessThan(Integer value) {
			addCriterion("VIDEO_STATUS <", value, "videoStatus");
			return (Criteria) this;
		}

		public Criteria andVideoStatusLessThanOrEqualTo(Integer value) {
			addCriterion("VIDEO_STATUS <=", value, "videoStatus");
			return (Criteria) this;
		}

		public Criteria andVideoStatusIn(List<Integer> values) {
			addCriterion("VIDEO_STATUS in", values, "videoStatus");
			return (Criteria) this;
		}

		public Criteria andVideoStatusNotIn(List<Integer> values) {
			addCriterion("VIDEO_STATUS not in", values, "videoStatus");
			return (Criteria) this;
		}

		public Criteria andVideoStatusBetween(Integer value1, Integer value2) {
			addCriterion("VIDEO_STATUS between", value1, value2, "videoStatus");
			return (Criteria) this;
		}

		public Criteria andVideoStatusNotBetween(Integer value1, Integer value2) {
			addCriterion("VIDEO_STATUS not between", value1, value2, "videoStatus");
			return (Criteria) this;
		}

		public Criteria andLocationsIsNull() {
			addCriterion("LOCATIONS is null");
			return (Criteria) this;
		}

		public Criteria andLocationsIsNotNull() {
			addCriterion("LOCATIONS is not null");
			return (Criteria) this;
		}

		public Criteria andLocationsEqualTo(String value) {
			addCriterion("LOCATIONS =", value, "locations");
			return (Criteria) this;
		}

		public Criteria andLocationsNotEqualTo(String value) {
			addCriterion("LOCATIONS <>", value, "locations");
			return (Criteria) this;
		}

		public Criteria andLocationsGreaterThan(String value) {
			addCriterion("LOCATIONS >", value, "locations");
			return (Criteria) this;
		}

		public Criteria andLocationsGreaterThanOrEqualTo(String value) {
			addCriterion("LOCATIONS >=", value, "locations");
			return (Criteria) this;
		}

		public Criteria andLocationsLessThan(String value) {
			addCriterion("LOCATIONS <", value, "locations");
			return (Criteria) this;
		}

		public Criteria andLocationsLessThanOrEqualTo(String value) {
			addCriterion("LOCATIONS <=", value, "locations");
			return (Criteria) this;
		}

		public Criteria andLocationsLike(String value) {
			addCriterion("LOCATIONS like", value, "locations");
			return (Criteria) this;
		}

		public Criteria andLocationsNotLike(String value) {
			addCriterion("LOCATIONS not like", value, "locations");
			return (Criteria) this;
		}

		public Criteria andLocationsIn(List<String> values) {
			addCriterion("LOCATIONS in", values, "locations");
			return (Criteria) this;
		}

		public Criteria andLocationsNotIn(List<String> values) {
			addCriterion("LOCATIONS not in", values, "locations");
			return (Criteria) this;
		}

		public Criteria andLocationsBetween(String value1, String value2) {
			addCriterion("LOCATIONS between", value1, value2, "locations");
			return (Criteria) this;
		}

		public Criteria andLocationsNotBetween(String value1, String value2) {
			addCriterion("LOCATIONS not between", value1, value2, "locations");
			return (Criteria) this;
		}

		public Criteria andVideoShootingTimeIsNull() {
			addCriterion("VIDEO_SHOOTING_TIME is null");
			return (Criteria) this;
		}

		public Criteria andVideoShootingTimeIsNotNull() {
			addCriterion("VIDEO_SHOOTING_TIME is not null");
			return (Criteria) this;
		}

		public Criteria andVideoShootingTimeEqualTo(String value) {
			addCriterion("VIDEO_SHOOTING_TIME =", value, "videoShootingTime");
			return (Criteria) this;
		}

		public Criteria andVideoShootingTimeNotEqualTo(String value) {
			addCriterion("VIDEO_SHOOTING_TIME <>", value, "videoShootingTime");
			return (Criteria) this;
		}

		public Criteria andVideoShootingTimeGreaterThan(String value) {
			addCriterion("VIDEO_SHOOTING_TIME >", value, "videoShootingTime");
			return (Criteria) this;
		}

		public Criteria andVideoShootingTimeGreaterThanOrEqualTo(String value) {
			addCriterion("VIDEO_SHOOTING_TIME >=", value, "videoShootingTime");
			return (Criteria) this;
		}

		public Criteria andVideoShootingTimeLessThan(String value) {
			addCriterion("VIDEO_SHOOTING_TIME <", value, "videoShootingTime");
			return (Criteria) this;
		}

		public Criteria andVideoShootingTimeLessThanOrEqualTo(String value) {
			addCriterion("VIDEO_SHOOTING_TIME <=", value, "videoShootingTime");
			return (Criteria) this;
		}

		public Criteria andVideoShootingTimeLike(String value) {
			addCriterion("VIDEO_SHOOTING_TIME like", value, "videoShootingTime");
			return (Criteria) this;
		}

		public Criteria andVideoShootingTimeNotLike(String value) {
			addCriterion("VIDEO_SHOOTING_TIME not like", value, "videoShootingTime");
			return (Criteria) this;
		}

		public Criteria andVideoShootingTimeIn(List<String> values) {
			addCriterion("VIDEO_SHOOTING_TIME in", values, "videoShootingTime");
			return (Criteria) this;
		}

		public Criteria andVideoShootingTimeNotIn(List<String> values) {
			addCriterion("VIDEO_SHOOTING_TIME not in", values, "videoShootingTime");
			return (Criteria) this;
		}

		public Criteria andVideoShootingTimeBetween(String value1, String value2) {
			addCriterion("VIDEO_SHOOTING_TIME between", value1, value2, "videoShootingTime");
			return (Criteria) this;
		}

		public Criteria andVideoShootingTimeNotBetween(String value1, String value2) {
			addCriterion("VIDEO_SHOOTING_TIME not between", value1, value2, "videoShootingTime");
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