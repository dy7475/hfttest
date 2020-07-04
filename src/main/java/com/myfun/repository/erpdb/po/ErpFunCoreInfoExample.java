package com.myfun.repository.erpdb.po;

import com.myfun.repository.support.generator.shard.ShardDb;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ErpFunCoreInfoExample extends ShardDb {
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
    public ErpFunCoreInfoExample() {
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

        public Criteria andBuildIdIsNull() {
            addCriterion("BUILD_ID is null");
            return (Criteria) this;
        }

        public Criteria andBuildIdIsNotNull() {
            addCriterion("BUILD_ID is not null");
            return (Criteria) this;
        }

        public Criteria andBuildIdEqualTo(Integer value) {
            addCriterion("BUILD_ID =", value, "buildId");
            return (Criteria) this;
        }

        public Criteria andBuildIdNotEqualTo(Integer value) {
            addCriterion("BUILD_ID <>", value, "buildId");
            return (Criteria) this;
        }

        public Criteria andBuildIdGreaterThan(Integer value) {
            addCriterion("BUILD_ID >", value, "buildId");
            return (Criteria) this;
        }

        public Criteria andBuildIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("BUILD_ID >=", value, "buildId");
            return (Criteria) this;
        }

        public Criteria andBuildIdLessThan(Integer value) {
            addCriterion("BUILD_ID <", value, "buildId");
            return (Criteria) this;
        }

        public Criteria andBuildIdLessThanOrEqualTo(Integer value) {
            addCriterion("BUILD_ID <=", value, "buildId");
            return (Criteria) this;
        }

        public Criteria andBuildIdIn(List<Integer> values) {
            addCriterion("BUILD_ID in", values, "buildId");
            return (Criteria) this;
        }

        public Criteria andBuildIdNotIn(List<Integer> values) {
            addCriterion("BUILD_ID not in", values, "buildId");
            return (Criteria) this;
        }

        public Criteria andBuildIdBetween(Integer value1, Integer value2) {
            addCriterion("BUILD_ID between", value1, value2, "buildId");
            return (Criteria) this;
        }

        public Criteria andBuildIdNotBetween(Integer value1, Integer value2) {
            addCriterion("BUILD_ID not between", value1, value2, "buildId");
            return (Criteria) this;
        }

        public Criteria andHouseRoofIsNull() {
            addCriterion("HOUSE_ROOF is null");
            return (Criteria) this;
        }

        public Criteria andHouseRoofIsNotNull() {
            addCriterion("HOUSE_ROOF is not null");
            return (Criteria) this;
        }

        public Criteria andHouseRoofEqualTo(String value) {
            addCriterion("HOUSE_ROOF =", value, "houseRoof");
            return (Criteria) this;
        }

        public Criteria andHouseRoofNotEqualTo(String value) {
            addCriterion("HOUSE_ROOF <>", value, "houseRoof");
            return (Criteria) this;
        }

        public Criteria andHouseRoofGreaterThan(String value) {
            addCriterion("HOUSE_ROOF >", value, "houseRoof");
            return (Criteria) this;
        }

        public Criteria andHouseRoofGreaterThanOrEqualTo(String value) {
            addCriterion("HOUSE_ROOF >=", value, "houseRoof");
            return (Criteria) this;
        }

        public Criteria andHouseRoofLessThan(String value) {
            addCriterion("HOUSE_ROOF <", value, "houseRoof");
            return (Criteria) this;
        }

        public Criteria andHouseRoofLessThanOrEqualTo(String value) {
            addCriterion("HOUSE_ROOF <=", value, "houseRoof");
            return (Criteria) this;
        }

        public Criteria andHouseRoofLike(String value) {
            addCriterion("HOUSE_ROOF like", value, "houseRoof");
            return (Criteria) this;
        }

        public Criteria andHouseRoofNotLike(String value) {
            addCriterion("HOUSE_ROOF not like", value, "houseRoof");
            return (Criteria) this;
        }

        public Criteria andHouseRoofIn(List<String> values) {
            addCriterion("HOUSE_ROOF in", values, "houseRoof");
            return (Criteria) this;
        }

        public Criteria andHouseRoofNotIn(List<String> values) {
            addCriterion("HOUSE_ROOF not in", values, "houseRoof");
            return (Criteria) this;
        }

        public Criteria andHouseRoofBetween(String value1, String value2) {
            addCriterion("HOUSE_ROOF between", value1, value2, "houseRoof");
            return (Criteria) this;
        }

        public Criteria andHouseRoofNotBetween(String value1, String value2) {
            addCriterion("HOUSE_ROOF not between", value1, value2, "houseRoof");
            return (Criteria) this;
        }

        public Criteria andHouseUnitIsNull() {
            addCriterion("HOUSE_UNIT is null");
            return (Criteria) this;
        }

        public Criteria andHouseUnitIsNotNull() {
            addCriterion("HOUSE_UNIT is not null");
            return (Criteria) this;
        }

        public Criteria andHouseUnitEqualTo(String value) {
            addCriterion("HOUSE_UNIT =", value, "houseUnit");
            return (Criteria) this;
        }

        public Criteria andHouseUnitNotEqualTo(String value) {
            addCriterion("HOUSE_UNIT <>", value, "houseUnit");
            return (Criteria) this;
        }

        public Criteria andHouseUnitGreaterThan(String value) {
            addCriterion("HOUSE_UNIT >", value, "houseUnit");
            return (Criteria) this;
        }

        public Criteria andHouseUnitGreaterThanOrEqualTo(String value) {
            addCriterion("HOUSE_UNIT >=", value, "houseUnit");
            return (Criteria) this;
        }

        public Criteria andHouseUnitLessThan(String value) {
            addCriterion("HOUSE_UNIT <", value, "houseUnit");
            return (Criteria) this;
        }

        public Criteria andHouseUnitLessThanOrEqualTo(String value) {
            addCriterion("HOUSE_UNIT <=", value, "houseUnit");
            return (Criteria) this;
        }

        public Criteria andHouseUnitLike(String value) {
            addCriterion("HOUSE_UNIT like", value, "houseUnit");
            return (Criteria) this;
        }

        public Criteria andHouseUnitNotLike(String value) {
            addCriterion("HOUSE_UNIT not like", value, "houseUnit");
            return (Criteria) this;
        }

        public Criteria andHouseUnitIn(List<String> values) {
            addCriterion("HOUSE_UNIT in", values, "houseUnit");
            return (Criteria) this;
        }

        public Criteria andHouseUnitNotIn(List<String> values) {
            addCriterion("HOUSE_UNIT not in", values, "houseUnit");
            return (Criteria) this;
        }

        public Criteria andHouseUnitBetween(String value1, String value2) {
            addCriterion("HOUSE_UNIT between", value1, value2, "houseUnit");
            return (Criteria) this;
        }

        public Criteria andHouseUnitNotBetween(String value1, String value2) {
            addCriterion("HOUSE_UNIT not between", value1, value2, "houseUnit");
            return (Criteria) this;
        }

        public Criteria andHouseFloorIsNull() {
            addCriterion("HOUSE_FLOOR is null");
            return (Criteria) this;
        }

        public Criteria andHouseFloorIsNotNull() {
            addCriterion("HOUSE_FLOOR is not null");
            return (Criteria) this;
        }

        public Criteria andHouseFloorEqualTo(String value) {
            addCriterion("HOUSE_FLOOR =", value, "houseFloor");
            return (Criteria) this;
        }

        public Criteria andHouseFloorNotEqualTo(String value) {
            addCriterion("HOUSE_FLOOR <>", value, "houseFloor");
            return (Criteria) this;
        }

        public Criteria andHouseFloorGreaterThan(String value) {
            addCriterion("HOUSE_FLOOR >", value, "houseFloor");
            return (Criteria) this;
        }

        public Criteria andHouseFloorGreaterThanOrEqualTo(String value) {
            addCriterion("HOUSE_FLOOR >=", value, "houseFloor");
            return (Criteria) this;
        }

        public Criteria andHouseFloorLessThan(String value) {
            addCriterion("HOUSE_FLOOR <", value, "houseFloor");
            return (Criteria) this;
        }

        public Criteria andHouseFloorLessThanOrEqualTo(String value) {
            addCriterion("HOUSE_FLOOR <=", value, "houseFloor");
            return (Criteria) this;
        }

        public Criteria andHouseFloorLike(String value) {
            addCriterion("HOUSE_FLOOR like", value, "houseFloor");
            return (Criteria) this;
        }

        public Criteria andHouseFloorNotLike(String value) {
            addCriterion("HOUSE_FLOOR not like", value, "houseFloor");
            return (Criteria) this;
        }

        public Criteria andHouseFloorIn(List<String> values) {
            addCriterion("HOUSE_FLOOR in", values, "houseFloor");
            return (Criteria) this;
        }

        public Criteria andHouseFloorNotIn(List<String> values) {
            addCriterion("HOUSE_FLOOR not in", values, "houseFloor");
            return (Criteria) this;
        }

        public Criteria andHouseFloorBetween(String value1, String value2) {
            addCriterion("HOUSE_FLOOR between", value1, value2, "houseFloor");
            return (Criteria) this;
        }

        public Criteria andHouseFloorNotBetween(String value1, String value2) {
            addCriterion("HOUSE_FLOOR not between", value1, value2, "houseFloor");
            return (Criteria) this;
        }

        public Criteria andRoomIdIsNull() {
            addCriterion("ROOM_ID is null");
            return (Criteria) this;
        }

        public Criteria andRoomIdIsNotNull() {
            addCriterion("ROOM_ID is not null");
            return (Criteria) this;
        }

        public Criteria andRoomIdEqualTo(String value) {
            addCriterion("ROOM_ID =", value, "roomId");
            return (Criteria) this;
        }

        public Criteria andRoomIdNotEqualTo(String value) {
            addCriterion("ROOM_ID <>", value, "roomId");
            return (Criteria) this;
        }

        public Criteria andRoomIdGreaterThan(String value) {
            addCriterion("ROOM_ID >", value, "roomId");
            return (Criteria) this;
        }

        public Criteria andRoomIdGreaterThanOrEqualTo(String value) {
            addCriterion("ROOM_ID >=", value, "roomId");
            return (Criteria) this;
        }

        public Criteria andRoomIdLessThan(String value) {
            addCriterion("ROOM_ID <", value, "roomId");
            return (Criteria) this;
        }

        public Criteria andRoomIdLessThanOrEqualTo(String value) {
            addCriterion("ROOM_ID <=", value, "roomId");
            return (Criteria) this;
        }

        public Criteria andRoomIdLike(String value) {
            addCriterion("ROOM_ID like", value, "roomId");
            return (Criteria) this;
        }

        public Criteria andRoomIdNotLike(String value) {
            addCriterion("ROOM_ID not like", value, "roomId");
            return (Criteria) this;
        }

        public Criteria andRoomIdIn(List<String> values) {
            addCriterion("ROOM_ID in", values, "roomId");
            return (Criteria) this;
        }

        public Criteria andRoomIdNotIn(List<String> values) {
            addCriterion("ROOM_ID not in", values, "roomId");
            return (Criteria) this;
        }

        public Criteria andRoomIdBetween(String value1, String value2) {
            addCriterion("ROOM_ID between", value1, value2, "roomId");
            return (Criteria) this;
        }

        public Criteria andRoomIdNotBetween(String value1, String value2) {
            addCriterion("ROOM_ID not between", value1, value2, "roomId");
            return (Criteria) this;
        }

        public Criteria andAddrMd5IsNull() {
            addCriterion("ADDR_MD5 is null");
            return (Criteria) this;
        }

        public Criteria andAddrMd5IsNotNull() {
            addCriterion("ADDR_MD5 is not null");
            return (Criteria) this;
        }

        public Criteria andAddrMd5EqualTo(String value) {
            addCriterion("ADDR_MD5 =", value, "addrMd5");
            return (Criteria) this;
        }

        public Criteria andAddrMd5NotEqualTo(String value) {
            addCriterion("ADDR_MD5 <>", value, "addrMd5");
            return (Criteria) this;
        }

        public Criteria andAddrMd5GreaterThan(String value) {
            addCriterion("ADDR_MD5 >", value, "addrMd5");
            return (Criteria) this;
        }

        public Criteria andAddrMd5GreaterThanOrEqualTo(String value) {
            addCriterion("ADDR_MD5 >=", value, "addrMd5");
            return (Criteria) this;
        }

        public Criteria andAddrMd5LessThan(String value) {
            addCriterion("ADDR_MD5 <", value, "addrMd5");
            return (Criteria) this;
        }

        public Criteria andAddrMd5LessThanOrEqualTo(String value) {
            addCriterion("ADDR_MD5 <=", value, "addrMd5");
            return (Criteria) this;
        }

        public Criteria andAddrMd5Like(String value) {
            addCriterion("ADDR_MD5 like", value, "addrMd5");
            return (Criteria) this;
        }

        public Criteria andAddrMd5NotLike(String value) {
            addCriterion("ADDR_MD5 not like", value, "addrMd5");
            return (Criteria) this;
        }

        public Criteria andAddrMd5In(List<String> values) {
            addCriterion("ADDR_MD5 in", values, "addrMd5");
            return (Criteria) this;
        }

        public Criteria andAddrMd5NotIn(List<String> values) {
            addCriterion("ADDR_MD5 not in", values, "addrMd5");
            return (Criteria) this;
        }

        public Criteria andAddrMd5Between(String value1, String value2) {
            addCriterion("ADDR_MD5 between", value1, value2, "addrMd5");
            return (Criteria) this;
        }

        public Criteria andAddrMd5NotBetween(String value1, String value2) {
            addCriterion("ADDR_MD5 not between", value1, value2, "addrMd5");
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