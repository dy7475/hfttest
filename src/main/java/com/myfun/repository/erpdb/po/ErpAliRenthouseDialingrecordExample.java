package com.myfun.repository.erpdb.po;

import com.myfun.repository.support.generator.shard.ShardDb;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ErpAliRenthouseDialingrecordExample extends ShardDb {
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
    public ErpAliRenthouseDialingrecordExample() {
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

        public Criteria andAliUserIdIsNull() {
            addCriterion("ALI_USER_ID is null");
            return (Criteria) this;
        }

        public Criteria andAliUserIdIsNotNull() {
            addCriterion("ALI_USER_ID is not null");
            return (Criteria) this;
        }

        public Criteria andAliUserIdEqualTo(String value) {
            addCriterion("ALI_USER_ID =", value, "aliUserId");
            return (Criteria) this;
        }

        public Criteria andAliUserIdNotEqualTo(String value) {
            addCriterion("ALI_USER_ID <>", value, "aliUserId");
            return (Criteria) this;
        }

        public Criteria andAliUserIdGreaterThan(String value) {
            addCriterion("ALI_USER_ID >", value, "aliUserId");
            return (Criteria) this;
        }

        public Criteria andAliUserIdGreaterThanOrEqualTo(String value) {
            addCriterion("ALI_USER_ID >=", value, "aliUserId");
            return (Criteria) this;
        }

        public Criteria andAliUserIdLessThan(String value) {
            addCriterion("ALI_USER_ID <", value, "aliUserId");
            return (Criteria) this;
        }

        public Criteria andAliUserIdLessThanOrEqualTo(String value) {
            addCriterion("ALI_USER_ID <=", value, "aliUserId");
            return (Criteria) this;
        }

        public Criteria andAliUserIdLike(String value) {
            addCriterion("ALI_USER_ID like", value, "aliUserId");
            return (Criteria) this;
        }

        public Criteria andAliUserIdNotLike(String value) {
            addCriterion("ALI_USER_ID not like", value, "aliUserId");
            return (Criteria) this;
        }

        public Criteria andAliUserIdIn(List<String> values) {
            addCriterion("ALI_USER_ID in", values, "aliUserId");
            return (Criteria) this;
        }

        public Criteria andAliUserIdNotIn(List<String> values) {
            addCriterion("ALI_USER_ID not in", values, "aliUserId");
            return (Criteria) this;
        }

        public Criteria andAliUserIdBetween(String value1, String value2) {
            addCriterion("ALI_USER_ID between", value1, value2, "aliUserId");
            return (Criteria) this;
        }

        public Criteria andAliUserIdNotBetween(String value1, String value2) {
            addCriterion("ALI_USER_ID not between", value1, value2, "aliUserId");
            return (Criteria) this;
        }

        public Criteria andZhimaOpenIdIsNull() {
            addCriterion("ZHIMA_OPEN_ID is null");
            return (Criteria) this;
        }

        public Criteria andZhimaOpenIdIsNotNull() {
            addCriterion("ZHIMA_OPEN_ID is not null");
            return (Criteria) this;
        }

        public Criteria andZhimaOpenIdEqualTo(String value) {
            addCriterion("ZHIMA_OPEN_ID =", value, "zhimaOpenId");
            return (Criteria) this;
        }

        public Criteria andZhimaOpenIdNotEqualTo(String value) {
            addCriterion("ZHIMA_OPEN_ID <>", value, "zhimaOpenId");
            return (Criteria) this;
        }

        public Criteria andZhimaOpenIdGreaterThan(String value) {
            addCriterion("ZHIMA_OPEN_ID >", value, "zhimaOpenId");
            return (Criteria) this;
        }

        public Criteria andZhimaOpenIdGreaterThanOrEqualTo(String value) {
            addCriterion("ZHIMA_OPEN_ID >=", value, "zhimaOpenId");
            return (Criteria) this;
        }

        public Criteria andZhimaOpenIdLessThan(String value) {
            addCriterion("ZHIMA_OPEN_ID <", value, "zhimaOpenId");
            return (Criteria) this;
        }

        public Criteria andZhimaOpenIdLessThanOrEqualTo(String value) {
            addCriterion("ZHIMA_OPEN_ID <=", value, "zhimaOpenId");
            return (Criteria) this;
        }

        public Criteria andZhimaOpenIdLike(String value) {
            addCriterion("ZHIMA_OPEN_ID like", value, "zhimaOpenId");
            return (Criteria) this;
        }

        public Criteria andZhimaOpenIdNotLike(String value) {
            addCriterion("ZHIMA_OPEN_ID not like", value, "zhimaOpenId");
            return (Criteria) this;
        }

        public Criteria andZhimaOpenIdIn(List<String> values) {
            addCriterion("ZHIMA_OPEN_ID in", values, "zhimaOpenId");
            return (Criteria) this;
        }

        public Criteria andZhimaOpenIdNotIn(List<String> values) {
            addCriterion("ZHIMA_OPEN_ID not in", values, "zhimaOpenId");
            return (Criteria) this;
        }

        public Criteria andZhimaOpenIdBetween(String value1, String value2) {
            addCriterion("ZHIMA_OPEN_ID between", value1, value2, "zhimaOpenId");
            return (Criteria) this;
        }

        public Criteria andZhimaOpenIdNotBetween(String value1, String value2) {
            addCriterion("ZHIMA_OPEN_ID not between", value1, value2, "zhimaOpenId");
            return (Criteria) this;
        }

        public Criteria andRoomCodeIsNull() {
            addCriterion("ROOM_CODE is null");
            return (Criteria) this;
        }

        public Criteria andRoomCodeIsNotNull() {
            addCriterion("ROOM_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andRoomCodeEqualTo(String value) {
            addCriterion("ROOM_CODE =", value, "roomCode");
            return (Criteria) this;
        }

        public Criteria andRoomCodeNotEqualTo(String value) {
            addCriterion("ROOM_CODE <>", value, "roomCode");
            return (Criteria) this;
        }

        public Criteria andRoomCodeGreaterThan(String value) {
            addCriterion("ROOM_CODE >", value, "roomCode");
            return (Criteria) this;
        }

        public Criteria andRoomCodeGreaterThanOrEqualTo(String value) {
            addCriterion("ROOM_CODE >=", value, "roomCode");
            return (Criteria) this;
        }

        public Criteria andRoomCodeLessThan(String value) {
            addCriterion("ROOM_CODE <", value, "roomCode");
            return (Criteria) this;
        }

        public Criteria andRoomCodeLessThanOrEqualTo(String value) {
            addCriterion("ROOM_CODE <=", value, "roomCode");
            return (Criteria) this;
        }

        public Criteria andRoomCodeLike(String value) {
            addCriterion("ROOM_CODE like", value, "roomCode");
            return (Criteria) this;
        }

        public Criteria andRoomCodeNotLike(String value) {
            addCriterion("ROOM_CODE not like", value, "roomCode");
            return (Criteria) this;
        }

        public Criteria andRoomCodeIn(List<String> values) {
            addCriterion("ROOM_CODE in", values, "roomCode");
            return (Criteria) this;
        }

        public Criteria andRoomCodeNotIn(List<String> values) {
            addCriterion("ROOM_CODE not in", values, "roomCode");
            return (Criteria) this;
        }

        public Criteria andRoomCodeBetween(String value1, String value2) {
            addCriterion("ROOM_CODE between", value1, value2, "roomCode");
            return (Criteria) this;
        }

        public Criteria andRoomCodeNotBetween(String value1, String value2) {
            addCriterion("ROOM_CODE not between", value1, value2, "roomCode");
            return (Criteria) this;
        }

        public Criteria andFlatsTagIsNull() {
            addCriterion("FLATS_TAG is null");
            return (Criteria) this;
        }

        public Criteria andFlatsTagIsNotNull() {
            addCriterion("FLATS_TAG is not null");
            return (Criteria) this;
        }

        public Criteria andFlatsTagEqualTo(Integer value) {
            addCriterion("FLATS_TAG =", value, "flatsTag");
            return (Criteria) this;
        }

        public Criteria andFlatsTagNotEqualTo(Integer value) {
            addCriterion("FLATS_TAG <>", value, "flatsTag");
            return (Criteria) this;
        }

        public Criteria andFlatsTagGreaterThan(Integer value) {
            addCriterion("FLATS_TAG >", value, "flatsTag");
            return (Criteria) this;
        }

        public Criteria andFlatsTagGreaterThanOrEqualTo(Integer value) {
            addCriterion("FLATS_TAG >=", value, "flatsTag");
            return (Criteria) this;
        }

        public Criteria andFlatsTagLessThan(Integer value) {
            addCriterion("FLATS_TAG <", value, "flatsTag");
            return (Criteria) this;
        }

        public Criteria andFlatsTagLessThanOrEqualTo(Integer value) {
            addCriterion("FLATS_TAG <=", value, "flatsTag");
            return (Criteria) this;
        }

        public Criteria andFlatsTagIn(List<Integer> values) {
            addCriterion("FLATS_TAG in", values, "flatsTag");
            return (Criteria) this;
        }

        public Criteria andFlatsTagNotIn(List<Integer> values) {
            addCriterion("FLATS_TAG not in", values, "flatsTag");
            return (Criteria) this;
        }

        public Criteria andFlatsTagBetween(Integer value1, Integer value2) {
            addCriterion("FLATS_TAG between", value1, value2, "flatsTag");
            return (Criteria) this;
        }

        public Criteria andFlatsTagNotBetween(Integer value1, Integer value2) {
            addCriterion("FLATS_TAG not between", value1, value2, "flatsTag");
            return (Criteria) this;
        }

        public Criteria andRecordTimeIsNull() {
            addCriterion("RECORD_TIME is null");
            return (Criteria) this;
        }

        public Criteria andRecordTimeIsNotNull() {
            addCriterion("RECORD_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andRecordTimeEqualTo(Date value) {
            addCriterion("RECORD_TIME =", value, "recordTime");
            return (Criteria) this;
        }

        public Criteria andRecordTimeNotEqualTo(Date value) {
            addCriterion("RECORD_TIME <>", value, "recordTime");
            return (Criteria) this;
        }

        public Criteria andRecordTimeGreaterThan(Date value) {
            addCriterion("RECORD_TIME >", value, "recordTime");
            return (Criteria) this;
        }

        public Criteria andRecordTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("RECORD_TIME >=", value, "recordTime");
            return (Criteria) this;
        }

        public Criteria andRecordTimeLessThan(Date value) {
            addCriterion("RECORD_TIME <", value, "recordTime");
            return (Criteria) this;
        }

        public Criteria andRecordTimeLessThanOrEqualTo(Date value) {
            addCriterion("RECORD_TIME <=", value, "recordTime");
            return (Criteria) this;
        }

        public Criteria andRecordTimeIn(List<Date> values) {
            addCriterion("RECORD_TIME in", values, "recordTime");
            return (Criteria) this;
        }

        public Criteria andRecordTimeNotIn(List<Date> values) {
            addCriterion("RECORD_TIME not in", values, "recordTime");
            return (Criteria) this;
        }

        public Criteria andRecordTimeBetween(Date value1, Date value2) {
            addCriterion("RECORD_TIME between", value1, value2, "recordTime");
            return (Criteria) this;
        }

        public Criteria andRecordTimeNotBetween(Date value1, Date value2) {
            addCriterion("RECORD_TIME not between", value1, value2, "recordTime");
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

        public Criteria andCaseTypeEqualTo(Integer value) {
            addCriterion("CASE_TYPE =", value, "caseType");
            return (Criteria) this;
        }

        public Criteria andCaseTypeNotEqualTo(Integer value) {
            addCriterion("CASE_TYPE <>", value, "caseType");
            return (Criteria) this;
        }

        public Criteria andCaseTypeGreaterThan(Integer value) {
            addCriterion("CASE_TYPE >", value, "caseType");
            return (Criteria) this;
        }

        public Criteria andCaseTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("CASE_TYPE >=", value, "caseType");
            return (Criteria) this;
        }

        public Criteria andCaseTypeLessThan(Integer value) {
            addCriterion("CASE_TYPE <", value, "caseType");
            return (Criteria) this;
        }

        public Criteria andCaseTypeLessThanOrEqualTo(Integer value) {
            addCriterion("CASE_TYPE <=", value, "caseType");
            return (Criteria) this;
        }

        public Criteria andCaseTypeIn(List<Integer> values) {
            addCriterion("CASE_TYPE in", values, "caseType");
            return (Criteria) this;
        }

        public Criteria andCaseTypeNotIn(List<Integer> values) {
            addCriterion("CASE_TYPE not in", values, "caseType");
            return (Criteria) this;
        }

        public Criteria andCaseTypeBetween(Integer value1, Integer value2) {
            addCriterion("CASE_TYPE between", value1, value2, "caseType");
            return (Criteria) this;
        }

        public Criteria andCaseTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("CASE_TYPE not between", value1, value2, "caseType");
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