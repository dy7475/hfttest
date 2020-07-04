package com.myfun.repository.erpdb.po;

import com.myfun.repository.support.generator.shard.ShardDb;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ErpCheckInRecordExample extends ShardDb {
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
	public ErpCheckInRecordExample() {
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

		public Criteria andUserIdIsNull() {
			addCriterion("USER_ID is null");
			return (Criteria) this;
		}

		public Criteria andUserIdIsNotNull() {
			addCriterion("USER_ID is not null");
			return (Criteria) this;
		}

		public Criteria andUserIdEqualTo(Integer value) {
			addCriterion("USER_ID =", value, "userId");
			return (Criteria) this;
		}

		public Criteria andUserIdNotEqualTo(Integer value) {
			addCriterion("USER_ID <>", value, "userId");
			return (Criteria) this;
		}

		public Criteria andUserIdGreaterThan(Integer value) {
			addCriterion("USER_ID >", value, "userId");
			return (Criteria) this;
		}

		public Criteria andUserIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("USER_ID >=", value, "userId");
			return (Criteria) this;
		}

		public Criteria andUserIdLessThan(Integer value) {
			addCriterion("USER_ID <", value, "userId");
			return (Criteria) this;
		}

		public Criteria andUserIdLessThanOrEqualTo(Integer value) {
			addCriterion("USER_ID <=", value, "userId");
			return (Criteria) this;
		}

		public Criteria andUserIdIn(List<Integer> values) {
			addCriterion("USER_ID in", values, "userId");
			return (Criteria) this;
		}

		public Criteria andUserIdNotIn(List<Integer> values) {
			addCriterion("USER_ID not in", values, "userId");
			return (Criteria) this;
		}

		public Criteria andUserIdBetween(Integer value1, Integer value2) {
			addCriterion("USER_ID between", value1, value2, "userId");
			return (Criteria) this;
		}

		public Criteria andUserIdNotBetween(Integer value1, Integer value2) {
			addCriterion("USER_ID not between", value1, value2, "userId");
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

		public Criteria andGrIdIsNull() {
			addCriterion("GR_ID is null");
			return (Criteria) this;
		}

		public Criteria andGrIdIsNotNull() {
			addCriterion("GR_ID is not null");
			return (Criteria) this;
		}

		public Criteria andGrIdEqualTo(Integer value) {
			addCriterion("GR_ID =", value, "grId");
			return (Criteria) this;
		}

		public Criteria andGrIdNotEqualTo(Integer value) {
			addCriterion("GR_ID <>", value, "grId");
			return (Criteria) this;
		}

		public Criteria andGrIdGreaterThan(Integer value) {
			addCriterion("GR_ID >", value, "grId");
			return (Criteria) this;
		}

		public Criteria andGrIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("GR_ID >=", value, "grId");
			return (Criteria) this;
		}

		public Criteria andGrIdLessThan(Integer value) {
			addCriterion("GR_ID <", value, "grId");
			return (Criteria) this;
		}

		public Criteria andGrIdLessThanOrEqualTo(Integer value) {
			addCriterion("GR_ID <=", value, "grId");
			return (Criteria) this;
		}

		public Criteria andGrIdIn(List<Integer> values) {
			addCriterion("GR_ID in", values, "grId");
			return (Criteria) this;
		}

		public Criteria andGrIdNotIn(List<Integer> values) {
			addCriterion("GR_ID not in", values, "grId");
			return (Criteria) this;
		}

		public Criteria andGrIdBetween(Integer value1, Integer value2) {
			addCriterion("GR_ID between", value1, value2, "grId");
			return (Criteria) this;
		}

		public Criteria andGrIdNotBetween(Integer value1, Integer value2) {
			addCriterion("GR_ID not between", value1, value2, "grId");
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

		public Criteria andDeviceTypeIsNull() {
			addCriterion("DEVICE_TYPE is null");
			return (Criteria) this;
		}

		public Criteria andDeviceTypeIsNotNull() {
			addCriterion("DEVICE_TYPE is not null");
			return (Criteria) this;
		}

		public Criteria andDeviceTypeEqualTo(Byte value) {
			addCriterion("DEVICE_TYPE =", value, "deviceType");
			return (Criteria) this;
		}

		public Criteria andDeviceTypeNotEqualTo(Byte value) {
			addCriterion("DEVICE_TYPE <>", value, "deviceType");
			return (Criteria) this;
		}

		public Criteria andDeviceTypeGreaterThan(Byte value) {
			addCriterion("DEVICE_TYPE >", value, "deviceType");
			return (Criteria) this;
		}

		public Criteria andDeviceTypeGreaterThanOrEqualTo(Byte value) {
			addCriterion("DEVICE_TYPE >=", value, "deviceType");
			return (Criteria) this;
		}

		public Criteria andDeviceTypeLessThan(Byte value) {
			addCriterion("DEVICE_TYPE <", value, "deviceType");
			return (Criteria) this;
		}

		public Criteria andDeviceTypeLessThanOrEqualTo(Byte value) {
			addCriterion("DEVICE_TYPE <=", value, "deviceType");
			return (Criteria) this;
		}

		public Criteria andDeviceTypeIn(List<Byte> values) {
			addCriterion("DEVICE_TYPE in", values, "deviceType");
			return (Criteria) this;
		}

		public Criteria andDeviceTypeNotIn(List<Byte> values) {
			addCriterion("DEVICE_TYPE not in", values, "deviceType");
			return (Criteria) this;
		}

		public Criteria andDeviceTypeBetween(Byte value1, Byte value2) {
			addCriterion("DEVICE_TYPE between", value1, value2, "deviceType");
			return (Criteria) this;
		}

		public Criteria andDeviceTypeNotBetween(Byte value1, Byte value2) {
			addCriterion("DEVICE_TYPE not between", value1, value2, "deviceType");
			return (Criteria) this;
		}

		public Criteria andLongiIsNull() {
			addCriterion("LONGI is null");
			return (Criteria) this;
		}

		public Criteria andLongiIsNotNull() {
			addCriterion("LONGI is not null");
			return (Criteria) this;
		}

		public Criteria andLongiEqualTo(String value) {
			addCriterion("LONGI =", value, "longi");
			return (Criteria) this;
		}

		public Criteria andLongiNotEqualTo(String value) {
			addCriterion("LONGI <>", value, "longi");
			return (Criteria) this;
		}

		public Criteria andLongiGreaterThan(String value) {
			addCriterion("LONGI >", value, "longi");
			return (Criteria) this;
		}

		public Criteria andLongiGreaterThanOrEqualTo(String value) {
			addCriterion("LONGI >=", value, "longi");
			return (Criteria) this;
		}

		public Criteria andLongiLessThan(String value) {
			addCriterion("LONGI <", value, "longi");
			return (Criteria) this;
		}

		public Criteria andLongiLessThanOrEqualTo(String value) {
			addCriterion("LONGI <=", value, "longi");
			return (Criteria) this;
		}

		public Criteria andLongiLike(String value) {
			addCriterion("LONGI like", value, "longi");
			return (Criteria) this;
		}

		public Criteria andLongiNotLike(String value) {
			addCriterion("LONGI not like", value, "longi");
			return (Criteria) this;
		}

		public Criteria andLongiIn(List<String> values) {
			addCriterion("LONGI in", values, "longi");
			return (Criteria) this;
		}

		public Criteria andLongiNotIn(List<String> values) {
			addCriterion("LONGI not in", values, "longi");
			return (Criteria) this;
		}

		public Criteria andLongiBetween(String value1, String value2) {
			addCriterion("LONGI between", value1, value2, "longi");
			return (Criteria) this;
		}

		public Criteria andLongiNotBetween(String value1, String value2) {
			addCriterion("LONGI not between", value1, value2, "longi");
			return (Criteria) this;
		}

		public Criteria andLatiIsNull() {
			addCriterion("LATI is null");
			return (Criteria) this;
		}

		public Criteria andLatiIsNotNull() {
			addCriterion("LATI is not null");
			return (Criteria) this;
		}

		public Criteria andLatiEqualTo(String value) {
			addCriterion("LATI =", value, "lati");
			return (Criteria) this;
		}

		public Criteria andLatiNotEqualTo(String value) {
			addCriterion("LATI <>", value, "lati");
			return (Criteria) this;
		}

		public Criteria andLatiGreaterThan(String value) {
			addCriterion("LATI >", value, "lati");
			return (Criteria) this;
		}

		public Criteria andLatiGreaterThanOrEqualTo(String value) {
			addCriterion("LATI >=", value, "lati");
			return (Criteria) this;
		}

		public Criteria andLatiLessThan(String value) {
			addCriterion("LATI <", value, "lati");
			return (Criteria) this;
		}

		public Criteria andLatiLessThanOrEqualTo(String value) {
			addCriterion("LATI <=", value, "lati");
			return (Criteria) this;
		}

		public Criteria andLatiLike(String value) {
			addCriterion("LATI like", value, "lati");
			return (Criteria) this;
		}

		public Criteria andLatiNotLike(String value) {
			addCriterion("LATI not like", value, "lati");
			return (Criteria) this;
		}

		public Criteria andLatiIn(List<String> values) {
			addCriterion("LATI in", values, "lati");
			return (Criteria) this;
		}

		public Criteria andLatiNotIn(List<String> values) {
			addCriterion("LATI not in", values, "lati");
			return (Criteria) this;
		}

		public Criteria andLatiBetween(String value1, String value2) {
			addCriterion("LATI between", value1, value2, "lati");
			return (Criteria) this;
		}

		public Criteria andLatiNotBetween(String value1, String value2) {
			addCriterion("LATI not between", value1, value2, "lati");
			return (Criteria) this;
		}

		public Criteria andPhotoPathIsNull() {
			addCriterion("PHOTO_PATH is null");
			return (Criteria) this;
		}

		public Criteria andPhotoPathIsNotNull() {
			addCriterion("PHOTO_PATH is not null");
			return (Criteria) this;
		}

		public Criteria andPhotoPathEqualTo(String value) {
			addCriterion("PHOTO_PATH =", value, "photoPath");
			return (Criteria) this;
		}

		public Criteria andPhotoPathNotEqualTo(String value) {
			addCriterion("PHOTO_PATH <>", value, "photoPath");
			return (Criteria) this;
		}

		public Criteria andPhotoPathGreaterThan(String value) {
			addCriterion("PHOTO_PATH >", value, "photoPath");
			return (Criteria) this;
		}

		public Criteria andPhotoPathGreaterThanOrEqualTo(String value) {
			addCriterion("PHOTO_PATH >=", value, "photoPath");
			return (Criteria) this;
		}

		public Criteria andPhotoPathLessThan(String value) {
			addCriterion("PHOTO_PATH <", value, "photoPath");
			return (Criteria) this;
		}

		public Criteria andPhotoPathLessThanOrEqualTo(String value) {
			addCriterion("PHOTO_PATH <=", value, "photoPath");
			return (Criteria) this;
		}

		public Criteria andPhotoPathLike(String value) {
			addCriterion("PHOTO_PATH like", value, "photoPath");
			return (Criteria) this;
		}

		public Criteria andPhotoPathNotLike(String value) {
			addCriterion("PHOTO_PATH not like", value, "photoPath");
			return (Criteria) this;
		}

		public Criteria andPhotoPathIn(List<String> values) {
			addCriterion("PHOTO_PATH in", values, "photoPath");
			return (Criteria) this;
		}

		public Criteria andPhotoPathNotIn(List<String> values) {
			addCriterion("PHOTO_PATH not in", values, "photoPath");
			return (Criteria) this;
		}

		public Criteria andPhotoPathBetween(String value1, String value2) {
			addCriterion("PHOTO_PATH between", value1, value2, "photoPath");
			return (Criteria) this;
		}

		public Criteria andPhotoPathNotBetween(String value1, String value2) {
			addCriterion("PHOTO_PATH not between", value1, value2, "photoPath");
			return (Criteria) this;
		}

		public Criteria andCheckInDescIsNull() {
			addCriterion("CHECK_IN_DESC is null");
			return (Criteria) this;
		}

		public Criteria andCheckInDescIsNotNull() {
			addCriterion("CHECK_IN_DESC is not null");
			return (Criteria) this;
		}

		public Criteria andCheckInDescEqualTo(String value) {
			addCriterion("CHECK_IN_DESC =", value, "checkInDesc");
			return (Criteria) this;
		}

		public Criteria andCheckInDescNotEqualTo(String value) {
			addCriterion("CHECK_IN_DESC <>", value, "checkInDesc");
			return (Criteria) this;
		}

		public Criteria andCheckInDescGreaterThan(String value) {
			addCriterion("CHECK_IN_DESC >", value, "checkInDesc");
			return (Criteria) this;
		}

		public Criteria andCheckInDescGreaterThanOrEqualTo(String value) {
			addCriterion("CHECK_IN_DESC >=", value, "checkInDesc");
			return (Criteria) this;
		}

		public Criteria andCheckInDescLessThan(String value) {
			addCriterion("CHECK_IN_DESC <", value, "checkInDesc");
			return (Criteria) this;
		}

		public Criteria andCheckInDescLessThanOrEqualTo(String value) {
			addCriterion("CHECK_IN_DESC <=", value, "checkInDesc");
			return (Criteria) this;
		}

		public Criteria andCheckInDescLike(String value) {
			addCriterion("CHECK_IN_DESC like", value, "checkInDesc");
			return (Criteria) this;
		}

		public Criteria andCheckInDescNotLike(String value) {
			addCriterion("CHECK_IN_DESC not like", value, "checkInDesc");
			return (Criteria) this;
		}

		public Criteria andCheckInDescIn(List<String> values) {
			addCriterion("CHECK_IN_DESC in", values, "checkInDesc");
			return (Criteria) this;
		}

		public Criteria andCheckInDescNotIn(List<String> values) {
			addCriterion("CHECK_IN_DESC not in", values, "checkInDesc");
			return (Criteria) this;
		}

		public Criteria andCheckInDescBetween(String value1, String value2) {
			addCriterion("CHECK_IN_DESC between", value1, value2, "checkInDesc");
			return (Criteria) this;
		}

		public Criteria andCheckInDescNotBetween(String value1, String value2) {
			addCriterion("CHECK_IN_DESC not between", value1, value2, "checkInDesc");
			return (Criteria) this;
		}

		public Criteria andLocationDescIsNull() {
			addCriterion("LOCATION_DESC is null");
			return (Criteria) this;
		}

		public Criteria andLocationDescIsNotNull() {
			addCriterion("LOCATION_DESC is not null");
			return (Criteria) this;
		}

		public Criteria andLocationDescEqualTo(String value) {
			addCriterion("LOCATION_DESC =", value, "locationDesc");
			return (Criteria) this;
		}

		public Criteria andLocationDescNotEqualTo(String value) {
			addCriterion("LOCATION_DESC <>", value, "locationDesc");
			return (Criteria) this;
		}

		public Criteria andLocationDescGreaterThan(String value) {
			addCriterion("LOCATION_DESC >", value, "locationDesc");
			return (Criteria) this;
		}

		public Criteria andLocationDescGreaterThanOrEqualTo(String value) {
			addCriterion("LOCATION_DESC >=", value, "locationDesc");
			return (Criteria) this;
		}

		public Criteria andLocationDescLessThan(String value) {
			addCriterion("LOCATION_DESC <", value, "locationDesc");
			return (Criteria) this;
		}

		public Criteria andLocationDescLessThanOrEqualTo(String value) {
			addCriterion("LOCATION_DESC <=", value, "locationDesc");
			return (Criteria) this;
		}

		public Criteria andLocationDescLike(String value) {
			addCriterion("LOCATION_DESC like", value, "locationDesc");
			return (Criteria) this;
		}

		public Criteria andLocationDescNotLike(String value) {
			addCriterion("LOCATION_DESC not like", value, "locationDesc");
			return (Criteria) this;
		}

		public Criteria andLocationDescIn(List<String> values) {
			addCriterion("LOCATION_DESC in", values, "locationDesc");
			return (Criteria) this;
		}

		public Criteria andLocationDescNotIn(List<String> values) {
			addCriterion("LOCATION_DESC not in", values, "locationDesc");
			return (Criteria) this;
		}

		public Criteria andLocationDescBetween(String value1, String value2) {
			addCriterion("LOCATION_DESC between", value1, value2, "locationDesc");
			return (Criteria) this;
		}

		public Criteria andLocationDescNotBetween(String value1, String value2) {
			addCriterion("LOCATION_DESC not between", value1, value2, "locationDesc");
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

		public Criteria andDeviceIdIsNull() {
			addCriterion("DEVICE_ID is null");
			return (Criteria) this;
		}

		public Criteria andDeviceIdIsNotNull() {
			addCriterion("DEVICE_ID is not null");
			return (Criteria) this;
		}

		public Criteria andDeviceIdEqualTo(String value) {
			addCriterion("DEVICE_ID =", value, "deviceId");
			return (Criteria) this;
		}

		public Criteria andDeviceIdNotEqualTo(String value) {
			addCriterion("DEVICE_ID <>", value, "deviceId");
			return (Criteria) this;
		}

		public Criteria andDeviceIdGreaterThan(String value) {
			addCriterion("DEVICE_ID >", value, "deviceId");
			return (Criteria) this;
		}

		public Criteria andDeviceIdGreaterThanOrEqualTo(String value) {
			addCriterion("DEVICE_ID >=", value, "deviceId");
			return (Criteria) this;
		}

		public Criteria andDeviceIdLessThan(String value) {
			addCriterion("DEVICE_ID <", value, "deviceId");
			return (Criteria) this;
		}

		public Criteria andDeviceIdLessThanOrEqualTo(String value) {
			addCriterion("DEVICE_ID <=", value, "deviceId");
			return (Criteria) this;
		}

		public Criteria andDeviceIdLike(String value) {
			addCriterion("DEVICE_ID like", value, "deviceId");
			return (Criteria) this;
		}

		public Criteria andDeviceIdNotLike(String value) {
			addCriterion("DEVICE_ID not like", value, "deviceId");
			return (Criteria) this;
		}

		public Criteria andDeviceIdIn(List<String> values) {
			addCriterion("DEVICE_ID in", values, "deviceId");
			return (Criteria) this;
		}

		public Criteria andDeviceIdNotIn(List<String> values) {
			addCriterion("DEVICE_ID not in", values, "deviceId");
			return (Criteria) this;
		}

		public Criteria andDeviceIdBetween(String value1, String value2) {
			addCriterion("DEVICE_ID between", value1, value2, "deviceId");
			return (Criteria) this;
		}

		public Criteria andDeviceIdNotBetween(String value1, String value2) {
			addCriterion("DEVICE_ID not between", value1, value2, "deviceId");
			return (Criteria) this;
		}

		public Criteria andDeviceNameIsNull() {
			addCriterion("DEVICE_NAME is null");
			return (Criteria) this;
		}

		public Criteria andDeviceNameIsNotNull() {
			addCriterion("DEVICE_NAME is not null");
			return (Criteria) this;
		}

		public Criteria andDeviceNameEqualTo(String value) {
			addCriterion("DEVICE_NAME =", value, "deviceName");
			return (Criteria) this;
		}

		public Criteria andDeviceNameNotEqualTo(String value) {
			addCriterion("DEVICE_NAME <>", value, "deviceName");
			return (Criteria) this;
		}

		public Criteria andDeviceNameGreaterThan(String value) {
			addCriterion("DEVICE_NAME >", value, "deviceName");
			return (Criteria) this;
		}

		public Criteria andDeviceNameGreaterThanOrEqualTo(String value) {
			addCriterion("DEVICE_NAME >=", value, "deviceName");
			return (Criteria) this;
		}

		public Criteria andDeviceNameLessThan(String value) {
			addCriterion("DEVICE_NAME <", value, "deviceName");
			return (Criteria) this;
		}

		public Criteria andDeviceNameLessThanOrEqualTo(String value) {
			addCriterion("DEVICE_NAME <=", value, "deviceName");
			return (Criteria) this;
		}

		public Criteria andDeviceNameLike(String value) {
			addCriterion("DEVICE_NAME like", value, "deviceName");
			return (Criteria) this;
		}

		public Criteria andDeviceNameNotLike(String value) {
			addCriterion("DEVICE_NAME not like", value, "deviceName");
			return (Criteria) this;
		}

		public Criteria andDeviceNameIn(List<String> values) {
			addCriterion("DEVICE_NAME in", values, "deviceName");
			return (Criteria) this;
		}

		public Criteria andDeviceNameNotIn(List<String> values) {
			addCriterion("DEVICE_NAME not in", values, "deviceName");
			return (Criteria) this;
		}

		public Criteria andDeviceNameBetween(String value1, String value2) {
			addCriterion("DEVICE_NAME between", value1, value2, "deviceName");
			return (Criteria) this;
		}

		public Criteria andDeviceNameNotBetween(String value1, String value2) {
			addCriterion("DEVICE_NAME not between", value1, value2, "deviceName");
			return (Criteria) this;
		}

		public Criteria andAreaIdIsNull() {
			addCriterion("AREA_ID is null");
			return (Criteria) this;
		}

		public Criteria andAreaIdIsNotNull() {
			addCriterion("AREA_ID is not null");
			return (Criteria) this;
		}

		public Criteria andAreaIdEqualTo(Integer value) {
			addCriterion("AREA_ID =", value, "areaId");
			return (Criteria) this;
		}

		public Criteria andAreaIdNotEqualTo(Integer value) {
			addCriterion("AREA_ID <>", value, "areaId");
			return (Criteria) this;
		}

		public Criteria andAreaIdGreaterThan(Integer value) {
			addCriterion("AREA_ID >", value, "areaId");
			return (Criteria) this;
		}

		public Criteria andAreaIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("AREA_ID >=", value, "areaId");
			return (Criteria) this;
		}

		public Criteria andAreaIdLessThan(Integer value) {
			addCriterion("AREA_ID <", value, "areaId");
			return (Criteria) this;
		}

		public Criteria andAreaIdLessThanOrEqualTo(Integer value) {
			addCriterion("AREA_ID <=", value, "areaId");
			return (Criteria) this;
		}

		public Criteria andAreaIdIn(List<Integer> values) {
			addCriterion("AREA_ID in", values, "areaId");
			return (Criteria) this;
		}

		public Criteria andAreaIdNotIn(List<Integer> values) {
			addCriterion("AREA_ID not in", values, "areaId");
			return (Criteria) this;
		}

		public Criteria andAreaIdBetween(Integer value1, Integer value2) {
			addCriterion("AREA_ID between", value1, value2, "areaId");
			return (Criteria) this;
		}

		public Criteria andAreaIdNotBetween(Integer value1, Integer value2) {
			addCriterion("AREA_ID not between", value1, value2, "areaId");
			return (Criteria) this;
		}

		public Criteria andRegIdIsNull() {
			addCriterion("REG_ID is null");
			return (Criteria) this;
		}

		public Criteria andRegIdIsNotNull() {
			addCriterion("REG_ID is not null");
			return (Criteria) this;
		}

		public Criteria andRegIdEqualTo(Integer value) {
			addCriterion("REG_ID =", value, "regId");
			return (Criteria) this;
		}

		public Criteria andRegIdNotEqualTo(Integer value) {
			addCriterion("REG_ID <>", value, "regId");
			return (Criteria) this;
		}

		public Criteria andRegIdGreaterThan(Integer value) {
			addCriterion("REG_ID >", value, "regId");
			return (Criteria) this;
		}

		public Criteria andRegIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("REG_ID >=", value, "regId");
			return (Criteria) this;
		}

		public Criteria andRegIdLessThan(Integer value) {
			addCriterion("REG_ID <", value, "regId");
			return (Criteria) this;
		}

		public Criteria andRegIdLessThanOrEqualTo(Integer value) {
			addCriterion("REG_ID <=", value, "regId");
			return (Criteria) this;
		}

		public Criteria andRegIdIn(List<Integer> values) {
			addCriterion("REG_ID in", values, "regId");
			return (Criteria) this;
		}

		public Criteria andRegIdNotIn(List<Integer> values) {
			addCriterion("REG_ID not in", values, "regId");
			return (Criteria) this;
		}

		public Criteria andRegIdBetween(Integer value1, Integer value2) {
			addCriterion("REG_ID between", value1, value2, "regId");
			return (Criteria) this;
		}

		public Criteria andRegIdNotBetween(Integer value1, Integer value2) {
			addCriterion("REG_ID not between", value1, value2, "regId");
			return (Criteria) this;
		}

		public Criteria andLocationDetailIsNull() {
			addCriterion("LOCATION_DETAIL is null");
			return (Criteria) this;
		}

		public Criteria andLocationDetailIsNotNull() {
			addCriterion("LOCATION_DETAIL is not null");
			return (Criteria) this;
		}

		public Criteria andLocationDetailEqualTo(String value) {
			addCriterion("LOCATION_DETAIL =", value, "locationDetail");
			return (Criteria) this;
		}

		public Criteria andLocationDetailNotEqualTo(String value) {
			addCriterion("LOCATION_DETAIL <>", value, "locationDetail");
			return (Criteria) this;
		}

		public Criteria andLocationDetailGreaterThan(String value) {
			addCriterion("LOCATION_DETAIL >", value, "locationDetail");
			return (Criteria) this;
		}

		public Criteria andLocationDetailGreaterThanOrEqualTo(String value) {
			addCriterion("LOCATION_DETAIL >=", value, "locationDetail");
			return (Criteria) this;
		}

		public Criteria andLocationDetailLessThan(String value) {
			addCriterion("LOCATION_DETAIL <", value, "locationDetail");
			return (Criteria) this;
		}

		public Criteria andLocationDetailLessThanOrEqualTo(String value) {
			addCriterion("LOCATION_DETAIL <=", value, "locationDetail");
			return (Criteria) this;
		}

		public Criteria andLocationDetailLike(String value) {
			addCriterion("LOCATION_DETAIL like", value, "locationDetail");
			return (Criteria) this;
		}

		public Criteria andLocationDetailNotLike(String value) {
			addCriterion("LOCATION_DETAIL not like", value, "locationDetail");
			return (Criteria) this;
		}

		public Criteria andLocationDetailIn(List<String> values) {
			addCriterion("LOCATION_DETAIL in", values, "locationDetail");
			return (Criteria) this;
		}

		public Criteria andLocationDetailNotIn(List<String> values) {
			addCriterion("LOCATION_DETAIL not in", values, "locationDetail");
			return (Criteria) this;
		}

		public Criteria andLocationDetailBetween(String value1, String value2) {
			addCriterion("LOCATION_DETAIL between", value1, value2, "locationDetail");
			return (Criteria) this;
		}

		public Criteria andLocationDetailNotBetween(String value1, String value2) {
			addCriterion("LOCATION_DETAIL not between", value1, value2, "locationDetail");
			return (Criteria) this;
		}

		public Criteria andOutIdIsNull() {
			addCriterion("OUT_ID is null");
			return (Criteria) this;
		}

		public Criteria andOutIdIsNotNull() {
			addCriterion("OUT_ID is not null");
			return (Criteria) this;
		}

		public Criteria andOutIdEqualTo(Integer value) {
			addCriterion("OUT_ID =", value, "outId");
			return (Criteria) this;
		}

		public Criteria andOutIdNotEqualTo(Integer value) {
			addCriterion("OUT_ID <>", value, "outId");
			return (Criteria) this;
		}

		public Criteria andOutIdGreaterThan(Integer value) {
			addCriterion("OUT_ID >", value, "outId");
			return (Criteria) this;
		}

		public Criteria andOutIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("OUT_ID >=", value, "outId");
			return (Criteria) this;
		}

		public Criteria andOutIdLessThan(Integer value) {
			addCriterion("OUT_ID <", value, "outId");
			return (Criteria) this;
		}

		public Criteria andOutIdLessThanOrEqualTo(Integer value) {
			addCriterion("OUT_ID <=", value, "outId");
			return (Criteria) this;
		}

		public Criteria andOutIdIn(List<Integer> values) {
			addCriterion("OUT_ID in", values, "outId");
			return (Criteria) this;
		}

		public Criteria andOutIdNotIn(List<Integer> values) {
			addCriterion("OUT_ID not in", values, "outId");
			return (Criteria) this;
		}

		public Criteria andOutIdBetween(Integer value1, Integer value2) {
			addCriterion("OUT_ID between", value1, value2, "outId");
			return (Criteria) this;
		}

		public Criteria andOutIdNotBetween(Integer value1, Integer value2) {
			addCriterion("OUT_ID not between", value1, value2, "outId");
			return (Criteria) this;
		}

		public Criteria andOrganizationPathIsNull() {
			addCriterion("ORGANIZATION_PATH is null");
			return (Criteria) this;
		}

		public Criteria andOrganizationPathIsNotNull() {
			addCriterion("ORGANIZATION_PATH is not null");
			return (Criteria) this;
		}

		public Criteria andOrganizationPathEqualTo(String value) {
			addCriterion("ORGANIZATION_PATH =", value, "organizationPath");
			return (Criteria) this;
		}

		public Criteria andOrganizationPathNotEqualTo(String value) {
			addCriterion("ORGANIZATION_PATH <>", value, "organizationPath");
			return (Criteria) this;
		}

		public Criteria andOrganizationPathGreaterThan(String value) {
			addCriterion("ORGANIZATION_PATH >", value, "organizationPath");
			return (Criteria) this;
		}

		public Criteria andOrganizationPathGreaterThanOrEqualTo(String value) {
			addCriterion("ORGANIZATION_PATH >=", value, "organizationPath");
			return (Criteria) this;
		}

		public Criteria andOrganizationPathLessThan(String value) {
			addCriterion("ORGANIZATION_PATH <", value, "organizationPath");
			return (Criteria) this;
		}

		public Criteria andOrganizationPathLessThanOrEqualTo(String value) {
			addCriterion("ORGANIZATION_PATH <=", value, "organizationPath");
			return (Criteria) this;
		}

		public Criteria andOrganizationPathLike(String value) {
			addCriterion("ORGANIZATION_PATH like", value, "organizationPath");
			return (Criteria) this;
		}

		public Criteria andOrganizationPathNotLike(String value) {
			addCriterion("ORGANIZATION_PATH not like", value, "organizationPath");
			return (Criteria) this;
		}

		public Criteria andOrganizationPathIn(List<String> values) {
			addCriterion("ORGANIZATION_PATH in", values, "organizationPath");
			return (Criteria) this;
		}

		public Criteria andOrganizationPathNotIn(List<String> values) {
			addCriterion("ORGANIZATION_PATH not in", values, "organizationPath");
			return (Criteria) this;
		}

		public Criteria andOrganizationPathBetween(String value1, String value2) {
			addCriterion("ORGANIZATION_PATH between", value1, value2, "organizationPath");
			return (Criteria) this;
		}

		public Criteria andOrganizationPathNotBetween(String value1, String value2) {
			addCriterion("ORGANIZATION_PATH not between", value1, value2, "organizationPath");
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