package com.myfun.repository.erpdb.po;

import com.myfun.repository.support.generator.shard.ShardDb;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ErpMakeLookHouseExample extends ShardDb {
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
    public ErpMakeLookHouseExample() {
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

        public Criteria andLookTypeIsNull() {
            addCriterion("LOOK_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andLookTypeIsNotNull() {
            addCriterion("LOOK_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andLookTypeEqualTo(Byte value) {
            addCriterion("LOOK_TYPE =", value, "lookType");
            return (Criteria) this;
        }

        public Criteria andLookTypeNotEqualTo(Byte value) {
            addCriterion("LOOK_TYPE <>", value, "lookType");
            return (Criteria) this;
        }

        public Criteria andLookTypeGreaterThan(Byte value) {
            addCriterion("LOOK_TYPE >", value, "lookType");
            return (Criteria) this;
        }

        public Criteria andLookTypeGreaterThanOrEqualTo(Byte value) {
            addCriterion("LOOK_TYPE >=", value, "lookType");
            return (Criteria) this;
        }

        public Criteria andLookTypeLessThan(Byte value) {
            addCriterion("LOOK_TYPE <", value, "lookType");
            return (Criteria) this;
        }

        public Criteria andLookTypeLessThanOrEqualTo(Byte value) {
            addCriterion("LOOK_TYPE <=", value, "lookType");
            return (Criteria) this;
        }

        public Criteria andLookTypeIn(List<Byte> values) {
            addCriterion("LOOK_TYPE in", values, "lookType");
            return (Criteria) this;
        }

        public Criteria andLookTypeNotIn(List<Byte> values) {
            addCriterion("LOOK_TYPE not in", values, "lookType");
            return (Criteria) this;
        }

        public Criteria andLookTypeBetween(Byte value1, Byte value2) {
            addCriterion("LOOK_TYPE between", value1, value2, "lookType");
            return (Criteria) this;
        }

        public Criteria andLookTypeNotBetween(Byte value1, Byte value2) {
            addCriterion("LOOK_TYPE not between", value1, value2, "lookType");
            return (Criteria) this;
        }

        public Criteria andMakeLookTitleIsNull() {
            addCriterion("MAKE_LOOK_TITLE is null");
            return (Criteria) this;
        }

        public Criteria andMakeLookTitleIsNotNull() {
            addCriterion("MAKE_LOOK_TITLE is not null");
            return (Criteria) this;
        }

        public Criteria andMakeLookTitleEqualTo(String value) {
            addCriterion("MAKE_LOOK_TITLE =", value, "makeLookTitle");
            return (Criteria) this;
        }

        public Criteria andMakeLookTitleNotEqualTo(String value) {
            addCriterion("MAKE_LOOK_TITLE <>", value, "makeLookTitle");
            return (Criteria) this;
        }

        public Criteria andMakeLookTitleGreaterThan(String value) {
            addCriterion("MAKE_LOOK_TITLE >", value, "makeLookTitle");
            return (Criteria) this;
        }

        public Criteria andMakeLookTitleGreaterThanOrEqualTo(String value) {
            addCriterion("MAKE_LOOK_TITLE >=", value, "makeLookTitle");
            return (Criteria) this;
        }

        public Criteria andMakeLookTitleLessThan(String value) {
            addCriterion("MAKE_LOOK_TITLE <", value, "makeLookTitle");
            return (Criteria) this;
        }

        public Criteria andMakeLookTitleLessThanOrEqualTo(String value) {
            addCriterion("MAKE_LOOK_TITLE <=", value, "makeLookTitle");
            return (Criteria) this;
        }

        public Criteria andMakeLookTitleLike(String value) {
            addCriterion("MAKE_LOOK_TITLE like", value, "makeLookTitle");
            return (Criteria) this;
        }

        public Criteria andMakeLookTitleNotLike(String value) {
            addCriterion("MAKE_LOOK_TITLE not like", value, "makeLookTitle");
            return (Criteria) this;
        }

        public Criteria andMakeLookTitleIn(List<String> values) {
            addCriterion("MAKE_LOOK_TITLE in", values, "makeLookTitle");
            return (Criteria) this;
        }

        public Criteria andMakeLookTitleNotIn(List<String> values) {
            addCriterion("MAKE_LOOK_TITLE not in", values, "makeLookTitle");
            return (Criteria) this;
        }

        public Criteria andMakeLookTitleBetween(String value1, String value2) {
            addCriterion("MAKE_LOOK_TITLE between", value1, value2, "makeLookTitle");
            return (Criteria) this;
        }

        public Criteria andMakeLookTitleNotBetween(String value1, String value2) {
            addCriterion("MAKE_LOOK_TITLE not between", value1, value2, "makeLookTitle");
            return (Criteria) this;
        }

        public Criteria andMakeLookDescIsNull() {
            addCriterion("MAKE_LOOK_DESC is null");
            return (Criteria) this;
        }

        public Criteria andMakeLookDescIsNotNull() {
            addCriterion("MAKE_LOOK_DESC is not null");
            return (Criteria) this;
        }

        public Criteria andMakeLookDescEqualTo(String value) {
            addCriterion("MAKE_LOOK_DESC =", value, "makeLookDesc");
            return (Criteria) this;
        }

        public Criteria andMakeLookDescNotEqualTo(String value) {
            addCriterion("MAKE_LOOK_DESC <>", value, "makeLookDesc");
            return (Criteria) this;
        }

        public Criteria andMakeLookDescGreaterThan(String value) {
            addCriterion("MAKE_LOOK_DESC >", value, "makeLookDesc");
            return (Criteria) this;
        }

        public Criteria andMakeLookDescGreaterThanOrEqualTo(String value) {
            addCriterion("MAKE_LOOK_DESC >=", value, "makeLookDesc");
            return (Criteria) this;
        }

        public Criteria andMakeLookDescLessThan(String value) {
            addCriterion("MAKE_LOOK_DESC <", value, "makeLookDesc");
            return (Criteria) this;
        }

        public Criteria andMakeLookDescLessThanOrEqualTo(String value) {
            addCriterion("MAKE_LOOK_DESC <=", value, "makeLookDesc");
            return (Criteria) this;
        }

        public Criteria andMakeLookDescLike(String value) {
            addCriterion("MAKE_LOOK_DESC like", value, "makeLookDesc");
            return (Criteria) this;
        }

        public Criteria andMakeLookDescNotLike(String value) {
            addCriterion("MAKE_LOOK_DESC not like", value, "makeLookDesc");
            return (Criteria) this;
        }

        public Criteria andMakeLookDescIn(List<String> values) {
            addCriterion("MAKE_LOOK_DESC in", values, "makeLookDesc");
            return (Criteria) this;
        }

        public Criteria andMakeLookDescNotIn(List<String> values) {
            addCriterion("MAKE_LOOK_DESC not in", values, "makeLookDesc");
            return (Criteria) this;
        }

        public Criteria andMakeLookDescBetween(String value1, String value2) {
            addCriterion("MAKE_LOOK_DESC between", value1, value2, "makeLookDesc");
            return (Criteria) this;
        }

        public Criteria andMakeLookDescNotBetween(String value1, String value2) {
            addCriterion("MAKE_LOOK_DESC not between", value1, value2, "makeLookDesc");
            return (Criteria) this;
        }

        public Criteria andHouseInfoIsNull() {
            addCriterion("HOUSE_INFO is null");
            return (Criteria) this;
        }

        public Criteria andHouseInfoIsNotNull() {
            addCriterion("HOUSE_INFO is not null");
            return (Criteria) this;
        }

        public Criteria andHouseInfoEqualTo(String value) {
            addCriterion("HOUSE_INFO =", value, "houseInfo");
            return (Criteria) this;
        }

        public Criteria andHouseInfoNotEqualTo(String value) {
            addCriterion("HOUSE_INFO <>", value, "houseInfo");
            return (Criteria) this;
        }

        public Criteria andHouseInfoGreaterThan(String value) {
            addCriterion("HOUSE_INFO >", value, "houseInfo");
            return (Criteria) this;
        }

        public Criteria andHouseInfoGreaterThanOrEqualTo(String value) {
            addCriterion("HOUSE_INFO >=", value, "houseInfo");
            return (Criteria) this;
        }

        public Criteria andHouseInfoLessThan(String value) {
            addCriterion("HOUSE_INFO <", value, "houseInfo");
            return (Criteria) this;
        }

        public Criteria andHouseInfoLessThanOrEqualTo(String value) {
            addCriterion("HOUSE_INFO <=", value, "houseInfo");
            return (Criteria) this;
        }

        public Criteria andHouseInfoLike(String value) {
            addCriterion("HOUSE_INFO like", value, "houseInfo");
            return (Criteria) this;
        }

        public Criteria andHouseInfoNotLike(String value) {
            addCriterion("HOUSE_INFO not like", value, "houseInfo");
            return (Criteria) this;
        }

        public Criteria andHouseInfoIn(List<String> values) {
            addCriterion("HOUSE_INFO in", values, "houseInfo");
            return (Criteria) this;
        }

        public Criteria andHouseInfoNotIn(List<String> values) {
            addCriterion("HOUSE_INFO not in", values, "houseInfo");
            return (Criteria) this;
        }

        public Criteria andHouseInfoBetween(String value1, String value2) {
            addCriterion("HOUSE_INFO between", value1, value2, "houseInfo");
            return (Criteria) this;
        }

        public Criteria andHouseInfoNotBetween(String value1, String value2) {
            addCriterion("HOUSE_INFO not between", value1, value2, "houseInfo");
            return (Criteria) this;
        }

        public Criteria andHouseIdsIsNull() {
            addCriterion("HOUSE_IDS is null");
            return (Criteria) this;
        }

        public Criteria andHouseIdsIsNotNull() {
            addCriterion("HOUSE_IDS is not null");
            return (Criteria) this;
        }

        public Criteria andHouseIdsEqualTo(String value) {
            addCriterion("HOUSE_IDS =", value, "houseIds");
            return (Criteria) this;
        }

        public Criteria andHouseIdsNotEqualTo(String value) {
            addCriterion("HOUSE_IDS <>", value, "houseIds");
            return (Criteria) this;
        }

        public Criteria andHouseIdsGreaterThan(String value) {
            addCriterion("HOUSE_IDS >", value, "houseIds");
            return (Criteria) this;
        }

        public Criteria andHouseIdsGreaterThanOrEqualTo(String value) {
            addCriterion("HOUSE_IDS >=", value, "houseIds");
            return (Criteria) this;
        }

        public Criteria andHouseIdsLessThan(String value) {
            addCriterion("HOUSE_IDS <", value, "houseIds");
            return (Criteria) this;
        }

        public Criteria andHouseIdsLessThanOrEqualTo(String value) {
            addCriterion("HOUSE_IDS <=", value, "houseIds");
            return (Criteria) this;
        }

        public Criteria andHouseIdsLike(String value) {
            addCriterion("HOUSE_IDS like", value, "houseIds");
            return (Criteria) this;
        }

        public Criteria andHouseIdsNotLike(String value) {
            addCriterion("HOUSE_IDS not like", value, "houseIds");
            return (Criteria) this;
        }

        public Criteria andHouseIdsIn(List<String> values) {
            addCriterion("HOUSE_IDS in", values, "houseIds");
            return (Criteria) this;
        }

        public Criteria andHouseIdsNotIn(List<String> values) {
            addCriterion("HOUSE_IDS not in", values, "houseIds");
            return (Criteria) this;
        }

        public Criteria andHouseIdsBetween(String value1, String value2) {
            addCriterion("HOUSE_IDS between", value1, value2, "houseIds");
            return (Criteria) this;
        }

        public Criteria andHouseIdsNotBetween(String value1, String value2) {
            addCriterion("HOUSE_IDS not between", value1, value2, "houseIds");
            return (Criteria) this;
        }

        public Criteria andLookTimeIsNull() {
            addCriterion("LOOK_TIME is null");
            return (Criteria) this;
        }

        public Criteria andLookTimeIsNotNull() {
            addCriterion("LOOK_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andLookTimeEqualTo(Date value) {
            addCriterion("LOOK_TIME =", value, "lookTime");
            return (Criteria) this;
        }

        public Criteria andLookTimeNotEqualTo(Date value) {
            addCriterion("LOOK_TIME <>", value, "lookTime");
            return (Criteria) this;
        }

        public Criteria andLookTimeGreaterThan(Date value) {
            addCriterion("LOOK_TIME >", value, "lookTime");
            return (Criteria) this;
        }

        public Criteria andLookTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("LOOK_TIME >=", value, "lookTime");
            return (Criteria) this;
        }

        public Criteria andLookTimeLessThan(Date value) {
            addCriterion("LOOK_TIME <", value, "lookTime");
            return (Criteria) this;
        }

        public Criteria andLookTimeLessThanOrEqualTo(Date value) {
            addCriterion("LOOK_TIME <=", value, "lookTime");
            return (Criteria) this;
        }

        public Criteria andLookTimeIn(List<Date> values) {
            addCriterion("LOOK_TIME in", values, "lookTime");
            return (Criteria) this;
        }

        public Criteria andLookTimeNotIn(List<Date> values) {
            addCriterion("LOOK_TIME not in", values, "lookTime");
            return (Criteria) this;
        }

        public Criteria andLookTimeBetween(Date value1, Date value2) {
            addCriterion("LOOK_TIME between", value1, value2, "lookTime");
            return (Criteria) this;
        }

        public Criteria andLookTimeNotBetween(Date value1, Date value2) {
            addCriterion("LOOK_TIME not between", value1, value2, "lookTime");
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

        public Criteria andIsAuditIsNull() {
            addCriterion("IS_AUDIT is null");
            return (Criteria) this;
        }

        public Criteria andIsAuditIsNotNull() {
            addCriterion("IS_AUDIT is not null");
            return (Criteria) this;
        }

        public Criteria andIsAuditEqualTo(Byte value) {
            addCriterion("IS_AUDIT =", value, "isAudit");
            return (Criteria) this;
        }

        public Criteria andIsAuditNotEqualTo(Byte value) {
            addCriterion("IS_AUDIT <>", value, "isAudit");
            return (Criteria) this;
        }

        public Criteria andIsAuditGreaterThan(Byte value) {
            addCriterion("IS_AUDIT >", value, "isAudit");
            return (Criteria) this;
        }

        public Criteria andIsAuditGreaterThanOrEqualTo(Byte value) {
            addCriterion("IS_AUDIT >=", value, "isAudit");
            return (Criteria) this;
        }

        public Criteria andIsAuditLessThan(Byte value) {
            addCriterion("IS_AUDIT <", value, "isAudit");
            return (Criteria) this;
        }

        public Criteria andIsAuditLessThanOrEqualTo(Byte value) {
            addCriterion("IS_AUDIT <=", value, "isAudit");
            return (Criteria) this;
        }

        public Criteria andIsAuditIn(List<Byte> values) {
            addCriterion("IS_AUDIT in", values, "isAudit");
            return (Criteria) this;
        }

        public Criteria andIsAuditNotIn(List<Byte> values) {
            addCriterion("IS_AUDIT not in", values, "isAudit");
            return (Criteria) this;
        }

        public Criteria andIsAuditBetween(Byte value1, Byte value2) {
            addCriterion("IS_AUDIT between", value1, value2, "isAudit");
            return (Criteria) this;
        }

        public Criteria andIsAuditNotBetween(Byte value1, Byte value2) {
            addCriterion("IS_AUDIT not between", value1, value2, "isAudit");
            return (Criteria) this;
        }

        public Criteria andLookStatusIsNull() {
            addCriterion("LOOK_STATUS is null");
            return (Criteria) this;
        }

        public Criteria andLookStatusIsNotNull() {
            addCriterion("LOOK_STATUS is not null");
            return (Criteria) this;
        }

        public Criteria andLookStatusEqualTo(Byte value) {
            addCriterion("LOOK_STATUS =", value, "lookStatus");
            return (Criteria) this;
        }

        public Criteria andLookStatusNotEqualTo(Byte value) {
            addCriterion("LOOK_STATUS <>", value, "lookStatus");
            return (Criteria) this;
        }

        public Criteria andLookStatusGreaterThan(Byte value) {
            addCriterion("LOOK_STATUS >", value, "lookStatus");
            return (Criteria) this;
        }

        public Criteria andLookStatusGreaterThanOrEqualTo(Byte value) {
            addCriterion("LOOK_STATUS >=", value, "lookStatus");
            return (Criteria) this;
        }

        public Criteria andLookStatusLessThan(Byte value) {
            addCriterion("LOOK_STATUS <", value, "lookStatus");
            return (Criteria) this;
        }

        public Criteria andLookStatusLessThanOrEqualTo(Byte value) {
            addCriterion("LOOK_STATUS <=", value, "lookStatus");
            return (Criteria) this;
        }

        public Criteria andLookStatusIn(List<Byte> values) {
            addCriterion("LOOK_STATUS in", values, "lookStatus");
            return (Criteria) this;
        }

        public Criteria andLookStatusNotIn(List<Byte> values) {
            addCriterion("LOOK_STATUS not in", values, "lookStatus");
            return (Criteria) this;
        }

        public Criteria andLookStatusBetween(Byte value1, Byte value2) {
            addCriterion("LOOK_STATUS between", value1, value2, "lookStatus");
            return (Criteria) this;
        }

        public Criteria andLookStatusNotBetween(Byte value1, Byte value2) {
            addCriterion("LOOK_STATUS not between", value1, value2, "lookStatus");
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

        public Criteria andCreationTimeIsNull() {
            addCriterion("CREATION_TIME is null");
            return (Criteria) this;
        }

        public Criteria andCreationTimeIsNotNull() {
            addCriterion("CREATION_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andCreationTimeEqualTo(Date value) {
            addCriterion("CREATION_TIME =", value, "creationTime");
            return (Criteria) this;
        }

        public Criteria andCreationTimeNotEqualTo(Date value) {
            addCriterion("CREATION_TIME <>", value, "creationTime");
            return (Criteria) this;
        }

        public Criteria andCreationTimeGreaterThan(Date value) {
            addCriterion("CREATION_TIME >", value, "creationTime");
            return (Criteria) this;
        }

        public Criteria andCreationTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("CREATION_TIME >=", value, "creationTime");
            return (Criteria) this;
        }

        public Criteria andCreationTimeLessThan(Date value) {
            addCriterion("CREATION_TIME <", value, "creationTime");
            return (Criteria) this;
        }

        public Criteria andCreationTimeLessThanOrEqualTo(Date value) {
            addCriterion("CREATION_TIME <=", value, "creationTime");
            return (Criteria) this;
        }

        public Criteria andCreationTimeIn(List<Date> values) {
            addCriterion("CREATION_TIME in", values, "creationTime");
            return (Criteria) this;
        }

        public Criteria andCreationTimeNotIn(List<Date> values) {
            addCriterion("CREATION_TIME not in", values, "creationTime");
            return (Criteria) this;
        }

        public Criteria andCreationTimeBetween(Date value1, Date value2) {
            addCriterion("CREATION_TIME between", value1, value2, "creationTime");
            return (Criteria) this;
        }

        public Criteria andCreationTimeNotBetween(Date value1, Date value2) {
            addCriterion("CREATION_TIME not between", value1, value2, "creationTime");
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

        public Criteria andMakeLookRichTitleIsNull() {
            addCriterion("MAKE_LOOK_RICH_TITLE is null");
            return (Criteria) this;
        }

        public Criteria andMakeLookRichTitleIsNotNull() {
            addCriterion("MAKE_LOOK_RICH_TITLE is not null");
            return (Criteria) this;
        }

        public Criteria andMakeLookRichTitleEqualTo(String value) {
            addCriterion("MAKE_LOOK_RICH_TITLE =", value, "makeLookRichTitle");
            return (Criteria) this;
        }

        public Criteria andMakeLookRichTitleNotEqualTo(String value) {
            addCriterion("MAKE_LOOK_RICH_TITLE <>", value, "makeLookRichTitle");
            return (Criteria) this;
        }

        public Criteria andMakeLookRichTitleGreaterThan(String value) {
            addCriterion("MAKE_LOOK_RICH_TITLE >", value, "makeLookRichTitle");
            return (Criteria) this;
        }

        public Criteria andMakeLookRichTitleGreaterThanOrEqualTo(String value) {
            addCriterion("MAKE_LOOK_RICH_TITLE >=", value, "makeLookRichTitle");
            return (Criteria) this;
        }

        public Criteria andMakeLookRichTitleLessThan(String value) {
            addCriterion("MAKE_LOOK_RICH_TITLE <", value, "makeLookRichTitle");
            return (Criteria) this;
        }

        public Criteria andMakeLookRichTitleLessThanOrEqualTo(String value) {
            addCriterion("MAKE_LOOK_RICH_TITLE <=", value, "makeLookRichTitle");
            return (Criteria) this;
        }

        public Criteria andMakeLookRichTitleLike(String value) {
            addCriterion("MAKE_LOOK_RICH_TITLE like", value, "makeLookRichTitle");
            return (Criteria) this;
        }

        public Criteria andMakeLookRichTitleNotLike(String value) {
            addCriterion("MAKE_LOOK_RICH_TITLE not like", value, "makeLookRichTitle");
            return (Criteria) this;
        }

        public Criteria andMakeLookRichTitleIn(List<String> values) {
            addCriterion("MAKE_LOOK_RICH_TITLE in", values, "makeLookRichTitle");
            return (Criteria) this;
        }

        public Criteria andMakeLookRichTitleNotIn(List<String> values) {
            addCriterion("MAKE_LOOK_RICH_TITLE not in", values, "makeLookRichTitle");
            return (Criteria) this;
        }

        public Criteria andMakeLookRichTitleBetween(String value1, String value2) {
            addCriterion("MAKE_LOOK_RICH_TITLE between", value1, value2, "makeLookRichTitle");
            return (Criteria) this;
        }

        public Criteria andMakeLookRichTitleNotBetween(String value1, String value2) {
            addCriterion("MAKE_LOOK_RICH_TITLE not between", value1, value2, "makeLookRichTitle");
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