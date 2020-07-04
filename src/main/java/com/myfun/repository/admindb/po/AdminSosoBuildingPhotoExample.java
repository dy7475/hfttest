package com.myfun.repository.admindb.po;

import java.util.ArrayList;
import java.util.List;

public class AdminSosoBuildingPhotoExample {
    /**
     *
     * @mbggenerated
     */
    protected String orderByClause;

    /**
     *
     * @mbggenerated
     */
    protected boolean distinct;

    /**
     *
     * @mbggenerated
     */
    protected List<Criteria> oredCriteria;

    /**
     *
     * @mbggenerated
     */
    public AdminSosoBuildingPhotoExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     *
     * @mbggenerated
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     *
     * @mbggenerated
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     *
     * @mbggenerated
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     *
     * @mbggenerated
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     *
     * @mbggenerated
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     *
     * @mbggenerated
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     *
     * @mbggenerated
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     *
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
     *
     * @mbggenerated
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     *
     * @mbggenerated
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     *
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

        public Criteria andBuildingIdIsNull() {
            addCriterion("BUILDING_ID is null");
            return (Criteria) this;
        }

        public Criteria andBuildingIdIsNotNull() {
            addCriterion("BUILDING_ID is not null");
            return (Criteria) this;
        }

        public Criteria andBuildingIdEqualTo(Integer value) {
            addCriterion("BUILDING_ID =", value, "buildingId");
            return (Criteria) this;
        }

        public Criteria andBuildingIdNotEqualTo(Integer value) {
            addCriterion("BUILDING_ID <>", value, "buildingId");
            return (Criteria) this;
        }

        public Criteria andBuildingIdGreaterThan(Integer value) {
            addCriterion("BUILDING_ID >", value, "buildingId");
            return (Criteria) this;
        }

        public Criteria andBuildingIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("BUILDING_ID >=", value, "buildingId");
            return (Criteria) this;
        }

        public Criteria andBuildingIdLessThan(Integer value) {
            addCriterion("BUILDING_ID <", value, "buildingId");
            return (Criteria) this;
        }

        public Criteria andBuildingIdLessThanOrEqualTo(Integer value) {
            addCriterion("BUILDING_ID <=", value, "buildingId");
            return (Criteria) this;
        }

        public Criteria andBuildingIdIn(List<Integer> values) {
            addCriterion("BUILDING_ID in", values, "buildingId");
            return (Criteria) this;
        }

        public Criteria andBuildingIdNotIn(List<Integer> values) {
            addCriterion("BUILDING_ID not in", values, "buildingId");
            return (Criteria) this;
        }

        public Criteria andBuildingIdBetween(Integer value1, Integer value2) {
            addCriterion("BUILDING_ID between", value1, value2, "buildingId");
            return (Criteria) this;
        }

        public Criteria andBuildingIdNotBetween(Integer value1, Integer value2) {
            addCriterion("BUILDING_ID not between", value1, value2, "buildingId");
            return (Criteria) this;
        }

        public Criteria andPhotoNameIsNull() {
            addCriterion("PHOTO_NAME is null");
            return (Criteria) this;
        }

        public Criteria andPhotoNameIsNotNull() {
            addCriterion("PHOTO_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andPhotoNameEqualTo(String value) {
            addCriterion("PHOTO_NAME =", value, "photoName");
            return (Criteria) this;
        }

        public Criteria andPhotoNameNotEqualTo(String value) {
            addCriterion("PHOTO_NAME <>", value, "photoName");
            return (Criteria) this;
        }

        public Criteria andPhotoNameGreaterThan(String value) {
            addCriterion("PHOTO_NAME >", value, "photoName");
            return (Criteria) this;
        }

        public Criteria andPhotoNameGreaterThanOrEqualTo(String value) {
            addCriterion("PHOTO_NAME >=", value, "photoName");
            return (Criteria) this;
        }

        public Criteria andPhotoNameLessThan(String value) {
            addCriterion("PHOTO_NAME <", value, "photoName");
            return (Criteria) this;
        }

        public Criteria andPhotoNameLessThanOrEqualTo(String value) {
            addCriterion("PHOTO_NAME <=", value, "photoName");
            return (Criteria) this;
        }

        public Criteria andPhotoNameLike(String value) {
            addCriterion("PHOTO_NAME like", value, "photoName");
            return (Criteria) this;
        }

        public Criteria andPhotoNameNotLike(String value) {
            addCriterion("PHOTO_NAME not like", value, "photoName");
            return (Criteria) this;
        }

        public Criteria andPhotoNameIn(List<String> values) {
            addCriterion("PHOTO_NAME in", values, "photoName");
            return (Criteria) this;
        }

        public Criteria andPhotoNameNotIn(List<String> values) {
            addCriterion("PHOTO_NAME not in", values, "photoName");
            return (Criteria) this;
        }

        public Criteria andPhotoNameBetween(String value1, String value2) {
            addCriterion("PHOTO_NAME between", value1, value2, "photoName");
            return (Criteria) this;
        }

        public Criteria andPhotoNameNotBetween(String value1, String value2) {
            addCriterion("PHOTO_NAME not between", value1, value2, "photoName");
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

        public Criteria andIsFirstIsNull() {
            addCriterion("IS_FIRST is null");
            return (Criteria) this;
        }

        public Criteria andIsFirstIsNotNull() {
            addCriterion("IS_FIRST is not null");
            return (Criteria) this;
        }

        public Criteria andIsFirstEqualTo(Byte value) {
            addCriterion("IS_FIRST =", value, "isFirst");
            return (Criteria) this;
        }

        public Criteria andIsFirstNotEqualTo(Byte value) {
            addCriterion("IS_FIRST <>", value, "isFirst");
            return (Criteria) this;
        }

        public Criteria andIsFirstGreaterThan(Byte value) {
            addCriterion("IS_FIRST >", value, "isFirst");
            return (Criteria) this;
        }

        public Criteria andIsFirstGreaterThanOrEqualTo(Byte value) {
            addCriterion("IS_FIRST >=", value, "isFirst");
            return (Criteria) this;
        }

        public Criteria andIsFirstLessThan(Byte value) {
            addCriterion("IS_FIRST <", value, "isFirst");
            return (Criteria) this;
        }

        public Criteria andIsFirstLessThanOrEqualTo(Byte value) {
            addCriterion("IS_FIRST <=", value, "isFirst");
            return (Criteria) this;
        }

        public Criteria andIsFirstIn(List<Byte> values) {
            addCriterion("IS_FIRST in", values, "isFirst");
            return (Criteria) this;
        }

        public Criteria andIsFirstNotIn(List<Byte> values) {
            addCriterion("IS_FIRST not in", values, "isFirst");
            return (Criteria) this;
        }

        public Criteria andIsFirstBetween(Byte value1, Byte value2) {
            addCriterion("IS_FIRST between", value1, value2, "isFirst");
            return (Criteria) this;
        }

        public Criteria andIsFirstNotBetween(Byte value1, Byte value2) {
            addCriterion("IS_FIRST not between", value1, value2, "isFirst");
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

        public Criteria andHuxingIdIsNull() {
            addCriterion("HUXING_ID is null");
            return (Criteria) this;
        }

        public Criteria andHuxingIdIsNotNull() {
            addCriterion("HUXING_ID is not null");
            return (Criteria) this;
        }

        public Criteria andHuxingIdEqualTo(Integer value) {
            addCriterion("HUXING_ID =", value, "huxingId");
            return (Criteria) this;
        }

        public Criteria andHuxingIdNotEqualTo(Integer value) {
            addCriterion("HUXING_ID <>", value, "huxingId");
            return (Criteria) this;
        }

        public Criteria andHuxingIdGreaterThan(Integer value) {
            addCriterion("HUXING_ID >", value, "huxingId");
            return (Criteria) this;
        }

        public Criteria andHuxingIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("HUXING_ID >=", value, "huxingId");
            return (Criteria) this;
        }

        public Criteria andHuxingIdLessThan(Integer value) {
            addCriterion("HUXING_ID <", value, "huxingId");
            return (Criteria) this;
        }

        public Criteria andHuxingIdLessThanOrEqualTo(Integer value) {
            addCriterion("HUXING_ID <=", value, "huxingId");
            return (Criteria) this;
        }

        public Criteria andHuxingIdIn(List<Integer> values) {
            addCriterion("HUXING_ID in", values, "huxingId");
            return (Criteria) this;
        }

        public Criteria andHuxingIdNotIn(List<Integer> values) {
            addCriterion("HUXING_ID not in", values, "huxingId");
            return (Criteria) this;
        }

        public Criteria andHuxingIdBetween(Integer value1, Integer value2) {
            addCriterion("HUXING_ID between", value1, value2, "huxingId");
            return (Criteria) this;
        }

        public Criteria andHuxingIdNotBetween(Integer value1, Integer value2) {
            addCriterion("HUXING_ID not between", value1, value2, "huxingId");
            return (Criteria) this;
        }

        public Criteria andPhotoCategoryIsNull() {
            addCriterion("PHOTO_CATEGORY is null");
            return (Criteria) this;
        }

        public Criteria andPhotoCategoryIsNotNull() {
            addCriterion("PHOTO_CATEGORY is not null");
            return (Criteria) this;
        }

        public Criteria andPhotoCategoryEqualTo(Byte value) {
            addCriterion("PHOTO_CATEGORY =", value, "photoCategory");
            return (Criteria) this;
        }

        public Criteria andPhotoCategoryNotEqualTo(Byte value) {
            addCriterion("PHOTO_CATEGORY <>", value, "photoCategory");
            return (Criteria) this;
        }

        public Criteria andPhotoCategoryGreaterThan(Byte value) {
            addCriterion("PHOTO_CATEGORY >", value, "photoCategory");
            return (Criteria) this;
        }

        public Criteria andPhotoCategoryGreaterThanOrEqualTo(Byte value) {
            addCriterion("PHOTO_CATEGORY >=", value, "photoCategory");
            return (Criteria) this;
        }

        public Criteria andPhotoCategoryLessThan(Byte value) {
            addCriterion("PHOTO_CATEGORY <", value, "photoCategory");
            return (Criteria) this;
        }

        public Criteria andPhotoCategoryLessThanOrEqualTo(Byte value) {
            addCriterion("PHOTO_CATEGORY <=", value, "photoCategory");
            return (Criteria) this;
        }

        public Criteria andPhotoCategoryIn(List<Byte> values) {
            addCriterion("PHOTO_CATEGORY in", values, "photoCategory");
            return (Criteria) this;
        }

        public Criteria andPhotoCategoryNotIn(List<Byte> values) {
            addCriterion("PHOTO_CATEGORY not in", values, "photoCategory");
            return (Criteria) this;
        }

        public Criteria andPhotoCategoryBetween(Byte value1, Byte value2) {
            addCriterion("PHOTO_CATEGORY between", value1, value2, "photoCategory");
            return (Criteria) this;
        }

        public Criteria andPhotoCategoryNotBetween(Byte value1, Byte value2) {
            addCriterion("PHOTO_CATEGORY not between", value1, value2, "photoCategory");
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

        public Criteria andAuditStatusIsNull() {
            addCriterion("AUDIT_STATUS is null");
            return (Criteria) this;
        }

        public Criteria andAuditStatusIsNotNull() {
            addCriterion("AUDIT_STATUS is not null");
            return (Criteria) this;
        }

        public Criteria andAuditStatusEqualTo(Byte value) {
            addCriterion("AUDIT_STATUS =", value, "auditStatus");
            return (Criteria) this;
        }

        public Criteria andAuditStatusNotEqualTo(Byte value) {
            addCriterion("AUDIT_STATUS <>", value, "auditStatus");
            return (Criteria) this;
        }

        public Criteria andAuditStatusGreaterThan(Byte value) {
            addCriterion("AUDIT_STATUS >", value, "auditStatus");
            return (Criteria) this;
        }

        public Criteria andAuditStatusGreaterThanOrEqualTo(Byte value) {
            addCriterion("AUDIT_STATUS >=", value, "auditStatus");
            return (Criteria) this;
        }

        public Criteria andAuditStatusLessThan(Byte value) {
            addCriterion("AUDIT_STATUS <", value, "auditStatus");
            return (Criteria) this;
        }

        public Criteria andAuditStatusLessThanOrEqualTo(Byte value) {
            addCriterion("AUDIT_STATUS <=", value, "auditStatus");
            return (Criteria) this;
        }

        public Criteria andAuditStatusIn(List<Byte> values) {
            addCriterion("AUDIT_STATUS in", values, "auditStatus");
            return (Criteria) this;
        }

        public Criteria andAuditStatusNotIn(List<Byte> values) {
            addCriterion("AUDIT_STATUS not in", values, "auditStatus");
            return (Criteria) this;
        }

        public Criteria andAuditStatusBetween(Byte value1, Byte value2) {
            addCriterion("AUDIT_STATUS between", value1, value2, "auditStatus");
            return (Criteria) this;
        }

        public Criteria andAuditStatusNotBetween(Byte value1, Byte value2) {
            addCriterion("AUDIT_STATUS not between", value1, value2, "auditStatus");
            return (Criteria) this;
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

    /**
     *
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
}