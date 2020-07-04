package com.myfun.repository.admindb.po;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AdminCrmPaymentTasksExample {
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
    public AdminCrmPaymentTasksExample() {
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

        public Criteria andPtIdIsNull() {
            addCriterion("PT_ID is null");
            return (Criteria) this;
        }

        public Criteria andPtIdIsNotNull() {
            addCriterion("PT_ID is not null");
            return (Criteria) this;
        }

        public Criteria andPtIdEqualTo(Integer value) {
            addCriterion("PT_ID =", value, "ptId");
            return (Criteria) this;
        }

        public Criteria andPtIdNotEqualTo(Integer value) {
            addCriterion("PT_ID <>", value, "ptId");
            return (Criteria) this;
        }

        public Criteria andPtIdGreaterThan(Integer value) {
            addCriterion("PT_ID >", value, "ptId");
            return (Criteria) this;
        }

        public Criteria andPtIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("PT_ID >=", value, "ptId");
            return (Criteria) this;
        }

        public Criteria andPtIdLessThan(Integer value) {
            addCriterion("PT_ID <", value, "ptId");
            return (Criteria) this;
        }

        public Criteria andPtIdLessThanOrEqualTo(Integer value) {
            addCriterion("PT_ID <=", value, "ptId");
            return (Criteria) this;
        }

        public Criteria andPtIdIn(List<Integer> values) {
            addCriterion("PT_ID in", values, "ptId");
            return (Criteria) this;
        }

        public Criteria andPtIdNotIn(List<Integer> values) {
            addCriterion("PT_ID not in", values, "ptId");
            return (Criteria) this;
        }

        public Criteria andPtIdBetween(Integer value1, Integer value2) {
            addCriterion("PT_ID between", value1, value2, "ptId");
            return (Criteria) this;
        }

        public Criteria andPtIdNotBetween(Integer value1, Integer value2) {
            addCriterion("PT_ID not between", value1, value2, "ptId");
            return (Criteria) this;
        }

        public Criteria andPtTypeIsNull() {
            addCriterion("PT_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andPtTypeIsNotNull() {
            addCriterion("PT_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andPtTypeEqualTo(Integer value) {
            addCriterion("PT_TYPE =", value, "ptType");
            return (Criteria) this;
        }

        public Criteria andPtTypeNotEqualTo(Integer value) {
            addCriterion("PT_TYPE <>", value, "ptType");
            return (Criteria) this;
        }

        public Criteria andPtTypeGreaterThan(Integer value) {
            addCriterion("PT_TYPE >", value, "ptType");
            return (Criteria) this;
        }

        public Criteria andPtTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("PT_TYPE >=", value, "ptType");
            return (Criteria) this;
        }

        public Criteria andPtTypeLessThan(Integer value) {
            addCriterion("PT_TYPE <", value, "ptType");
            return (Criteria) this;
        }

        public Criteria andPtTypeLessThanOrEqualTo(Integer value) {
            addCriterion("PT_TYPE <=", value, "ptType");
            return (Criteria) this;
        }

        public Criteria andPtTypeIn(List<Integer> values) {
            addCriterion("PT_TYPE in", values, "ptType");
            return (Criteria) this;
        }

        public Criteria andPtTypeNotIn(List<Integer> values) {
            addCriterion("PT_TYPE not in", values, "ptType");
            return (Criteria) this;
        }

        public Criteria andPtTypeBetween(Integer value1, Integer value2) {
            addCriterion("PT_TYPE between", value1, value2, "ptType");
            return (Criteria) this;
        }

        public Criteria andPtTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("PT_TYPE not between", value1, value2, "ptType");
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

        public Criteria andUaIdIsNull() {
            addCriterion("UA_ID is null");
            return (Criteria) this;
        }

        public Criteria andUaIdIsNotNull() {
            addCriterion("UA_ID is not null");
            return (Criteria) this;
        }

        public Criteria andUaIdEqualTo(Integer value) {
            addCriterion("UA_ID =", value, "uaId");
            return (Criteria) this;
        }

        public Criteria andUaIdNotEqualTo(Integer value) {
            addCriterion("UA_ID <>", value, "uaId");
            return (Criteria) this;
        }

        public Criteria andUaIdGreaterThan(Integer value) {
            addCriterion("UA_ID >", value, "uaId");
            return (Criteria) this;
        }

        public Criteria andUaIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("UA_ID >=", value, "uaId");
            return (Criteria) this;
        }

        public Criteria andUaIdLessThan(Integer value) {
            addCriterion("UA_ID <", value, "uaId");
            return (Criteria) this;
        }

        public Criteria andUaIdLessThanOrEqualTo(Integer value) {
            addCriterion("UA_ID <=", value, "uaId");
            return (Criteria) this;
        }

        public Criteria andUaIdIn(List<Integer> values) {
            addCriterion("UA_ID in", values, "uaId");
            return (Criteria) this;
        }

        public Criteria andUaIdNotIn(List<Integer> values) {
            addCriterion("UA_ID not in", values, "uaId");
            return (Criteria) this;
        }

        public Criteria andUaIdBetween(Integer value1, Integer value2) {
            addCriterion("UA_ID between", value1, value2, "uaId");
            return (Criteria) this;
        }

        public Criteria andUaIdNotBetween(Integer value1, Integer value2) {
            addCriterion("UA_ID not between", value1, value2, "uaId");
            return (Criteria) this;
        }

        public Criteria andSrvMonthIsNull() {
            addCriterion("SRV_MONTH is null");
            return (Criteria) this;
        }

        public Criteria andSrvMonthIsNotNull() {
            addCriterion("SRV_MONTH is not null");
            return (Criteria) this;
        }

        public Criteria andSrvMonthEqualTo(Integer value) {
            addCriterion("SRV_MONTH =", value, "srvMonth");
            return (Criteria) this;
        }

        public Criteria andSrvMonthNotEqualTo(Integer value) {
            addCriterion("SRV_MONTH <>", value, "srvMonth");
            return (Criteria) this;
        }

        public Criteria andSrvMonthGreaterThan(Integer value) {
            addCriterion("SRV_MONTH >", value, "srvMonth");
            return (Criteria) this;
        }

        public Criteria andSrvMonthGreaterThanOrEqualTo(Integer value) {
            addCriterion("SRV_MONTH >=", value, "srvMonth");
            return (Criteria) this;
        }

        public Criteria andSrvMonthLessThan(Integer value) {
            addCriterion("SRV_MONTH <", value, "srvMonth");
            return (Criteria) this;
        }

        public Criteria andSrvMonthLessThanOrEqualTo(Integer value) {
            addCriterion("SRV_MONTH <=", value, "srvMonth");
            return (Criteria) this;
        }

        public Criteria andSrvMonthIn(List<Integer> values) {
            addCriterion("SRV_MONTH in", values, "srvMonth");
            return (Criteria) this;
        }

        public Criteria andSrvMonthNotIn(List<Integer> values) {
            addCriterion("SRV_MONTH not in", values, "srvMonth");
            return (Criteria) this;
        }

        public Criteria andSrvMonthBetween(Integer value1, Integer value2) {
            addCriterion("SRV_MONTH between", value1, value2, "srvMonth");
            return (Criteria) this;
        }

        public Criteria andSrvMonthNotBetween(Integer value1, Integer value2) {
            addCriterion("SRV_MONTH not between", value1, value2, "srvMonth");
            return (Criteria) this;
        }

        public Criteria andSrvGiftIsNull() {
            addCriterion("SRV_GIFT is null");
            return (Criteria) this;
        }

        public Criteria andSrvGiftIsNotNull() {
            addCriterion("SRV_GIFT is not null");
            return (Criteria) this;
        }

        public Criteria andSrvGiftEqualTo(Integer value) {
            addCriterion("SRV_GIFT =", value, "srvGift");
            return (Criteria) this;
        }

        public Criteria andSrvGiftNotEqualTo(Integer value) {
            addCriterion("SRV_GIFT <>", value, "srvGift");
            return (Criteria) this;
        }

        public Criteria andSrvGiftGreaterThan(Integer value) {
            addCriterion("SRV_GIFT >", value, "srvGift");
            return (Criteria) this;
        }

        public Criteria andSrvGiftGreaterThanOrEqualTo(Integer value) {
            addCriterion("SRV_GIFT >=", value, "srvGift");
            return (Criteria) this;
        }

        public Criteria andSrvGiftLessThan(Integer value) {
            addCriterion("SRV_GIFT <", value, "srvGift");
            return (Criteria) this;
        }

        public Criteria andSrvGiftLessThanOrEqualTo(Integer value) {
            addCriterion("SRV_GIFT <=", value, "srvGift");
            return (Criteria) this;
        }

        public Criteria andSrvGiftIn(List<Integer> values) {
            addCriterion("SRV_GIFT in", values, "srvGift");
            return (Criteria) this;
        }

        public Criteria andSrvGiftNotIn(List<Integer> values) {
            addCriterion("SRV_GIFT not in", values, "srvGift");
            return (Criteria) this;
        }

        public Criteria andSrvGiftBetween(Integer value1, Integer value2) {
            addCriterion("SRV_GIFT between", value1, value2, "srvGift");
            return (Criteria) this;
        }

        public Criteria andSrvGiftNotBetween(Integer value1, Integer value2) {
            addCriterion("SRV_GIFT not between", value1, value2, "srvGift");
            return (Criteria) this;
        }

        public Criteria andCionGiftIsNull() {
            addCriterion("CION_GIFT is null");
            return (Criteria) this;
        }

        public Criteria andCionGiftIsNotNull() {
            addCriterion("CION_GIFT is not null");
            return (Criteria) this;
        }

        public Criteria andCionGiftEqualTo(Integer value) {
            addCriterion("CION_GIFT =", value, "cionGift");
            return (Criteria) this;
        }

        public Criteria andCionGiftNotEqualTo(Integer value) {
            addCriterion("CION_GIFT <>", value, "cionGift");
            return (Criteria) this;
        }

        public Criteria andCionGiftGreaterThan(Integer value) {
            addCriterion("CION_GIFT >", value, "cionGift");
            return (Criteria) this;
        }

        public Criteria andCionGiftGreaterThanOrEqualTo(Integer value) {
            addCriterion("CION_GIFT >=", value, "cionGift");
            return (Criteria) this;
        }

        public Criteria andCionGiftLessThan(Integer value) {
            addCriterion("CION_GIFT <", value, "cionGift");
            return (Criteria) this;
        }

        public Criteria andCionGiftLessThanOrEqualTo(Integer value) {
            addCriterion("CION_GIFT <=", value, "cionGift");
            return (Criteria) this;
        }

        public Criteria andCionGiftIn(List<Integer> values) {
            addCriterion("CION_GIFT in", values, "cionGift");
            return (Criteria) this;
        }

        public Criteria andCionGiftNotIn(List<Integer> values) {
            addCriterion("CION_GIFT not in", values, "cionGift");
            return (Criteria) this;
        }

        public Criteria andCionGiftBetween(Integer value1, Integer value2) {
            addCriterion("CION_GIFT between", value1, value2, "cionGift");
            return (Criteria) this;
        }

        public Criteria andCionGiftNotBetween(Integer value1, Integer value2) {
            addCriterion("CION_GIFT not between", value1, value2, "cionGift");
            return (Criteria) this;
        }

        public Criteria andIsPromotionIsNull() {
            addCriterion("IS_PROMOTION is null");
            return (Criteria) this;
        }

        public Criteria andIsPromotionIsNotNull() {
            addCriterion("IS_PROMOTION is not null");
            return (Criteria) this;
        }

        public Criteria andIsPromotionEqualTo(Byte value) {
            addCriterion("IS_PROMOTION =", value, "isPromotion");
            return (Criteria) this;
        }

        public Criteria andIsPromotionNotEqualTo(Byte value) {
            addCriterion("IS_PROMOTION <>", value, "isPromotion");
            return (Criteria) this;
        }

        public Criteria andIsPromotionGreaterThan(Byte value) {
            addCriterion("IS_PROMOTION >", value, "isPromotion");
            return (Criteria) this;
        }

        public Criteria andIsPromotionGreaterThanOrEqualTo(Byte value) {
            addCriterion("IS_PROMOTION >=", value, "isPromotion");
            return (Criteria) this;
        }

        public Criteria andIsPromotionLessThan(Byte value) {
            addCriterion("IS_PROMOTION <", value, "isPromotion");
            return (Criteria) this;
        }

        public Criteria andIsPromotionLessThanOrEqualTo(Byte value) {
            addCriterion("IS_PROMOTION <=", value, "isPromotion");
            return (Criteria) this;
        }

        public Criteria andIsPromotionIn(List<Byte> values) {
            addCriterion("IS_PROMOTION in", values, "isPromotion");
            return (Criteria) this;
        }

        public Criteria andIsPromotionNotIn(List<Byte> values) {
            addCriterion("IS_PROMOTION not in", values, "isPromotion");
            return (Criteria) this;
        }

        public Criteria andIsPromotionBetween(Byte value1, Byte value2) {
            addCriterion("IS_PROMOTION between", value1, value2, "isPromotion");
            return (Criteria) this;
        }

        public Criteria andIsPromotionNotBetween(Byte value1, Byte value2) {
            addCriterion("IS_PROMOTION not between", value1, value2, "isPromotion");
            return (Criteria) this;
        }

        public Criteria andTotalMoneyIsNull() {
            addCriterion("TOTAL_MONEY is null");
            return (Criteria) this;
        }

        public Criteria andTotalMoneyIsNotNull() {
            addCriterion("TOTAL_MONEY is not null");
            return (Criteria) this;
        }

        public Criteria andTotalMoneyEqualTo(Double value) {
            addCriterion("TOTAL_MONEY =", value, "totalMoney");
            return (Criteria) this;
        }

        public Criteria andTotalMoneyNotEqualTo(Double value) {
            addCriterion("TOTAL_MONEY <>", value, "totalMoney");
            return (Criteria) this;
        }

        public Criteria andTotalMoneyGreaterThan(Double value) {
            addCriterion("TOTAL_MONEY >", value, "totalMoney");
            return (Criteria) this;
        }

        public Criteria andTotalMoneyGreaterThanOrEqualTo(Double value) {
            addCriterion("TOTAL_MONEY >=", value, "totalMoney");
            return (Criteria) this;
        }

        public Criteria andTotalMoneyLessThan(Double value) {
            addCriterion("TOTAL_MONEY <", value, "totalMoney");
            return (Criteria) this;
        }

        public Criteria andTotalMoneyLessThanOrEqualTo(Double value) {
            addCriterion("TOTAL_MONEY <=", value, "totalMoney");
            return (Criteria) this;
        }

        public Criteria andTotalMoneyIn(List<Double> values) {
            addCriterion("TOTAL_MONEY in", values, "totalMoney");
            return (Criteria) this;
        }

        public Criteria andTotalMoneyNotIn(List<Double> values) {
            addCriterion("TOTAL_MONEY not in", values, "totalMoney");
            return (Criteria) this;
        }

        public Criteria andTotalMoneyBetween(Double value1, Double value2) {
            addCriterion("TOTAL_MONEY between", value1, value2, "totalMoney");
            return (Criteria) this;
        }

        public Criteria andTotalMoneyNotBetween(Double value1, Double value2) {
            addCriterion("TOTAL_MONEY not between", value1, value2, "totalMoney");
            return (Criteria) this;
        }

        public Criteria andPtCreatorIsNull() {
            addCriterion("PT_CREATOR is null");
            return (Criteria) this;
        }

        public Criteria andPtCreatorIsNotNull() {
            addCriterion("PT_CREATOR is not null");
            return (Criteria) this;
        }

        public Criteria andPtCreatorEqualTo(Integer value) {
            addCriterion("PT_CREATOR =", value, "ptCreator");
            return (Criteria) this;
        }

        public Criteria andPtCreatorNotEqualTo(Integer value) {
            addCriterion("PT_CREATOR <>", value, "ptCreator");
            return (Criteria) this;
        }

        public Criteria andPtCreatorGreaterThan(Integer value) {
            addCriterion("PT_CREATOR >", value, "ptCreator");
            return (Criteria) this;
        }

        public Criteria andPtCreatorGreaterThanOrEqualTo(Integer value) {
            addCriterion("PT_CREATOR >=", value, "ptCreator");
            return (Criteria) this;
        }

        public Criteria andPtCreatorLessThan(Integer value) {
            addCriterion("PT_CREATOR <", value, "ptCreator");
            return (Criteria) this;
        }

        public Criteria andPtCreatorLessThanOrEqualTo(Integer value) {
            addCriterion("PT_CREATOR <=", value, "ptCreator");
            return (Criteria) this;
        }

        public Criteria andPtCreatorIn(List<Integer> values) {
            addCriterion("PT_CREATOR in", values, "ptCreator");
            return (Criteria) this;
        }

        public Criteria andPtCreatorNotIn(List<Integer> values) {
            addCriterion("PT_CREATOR not in", values, "ptCreator");
            return (Criteria) this;
        }

        public Criteria andPtCreatorBetween(Integer value1, Integer value2) {
            addCriterion("PT_CREATOR between", value1, value2, "ptCreator");
            return (Criteria) this;
        }

        public Criteria andPtCreatorNotBetween(Integer value1, Integer value2) {
            addCriterion("PT_CREATOR not between", value1, value2, "ptCreator");
            return (Criteria) this;
        }

        public Criteria andPtTimeIsNull() {
            addCriterion("PT_TIME is null");
            return (Criteria) this;
        }

        public Criteria andPtTimeIsNotNull() {
            addCriterion("PT_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andPtTimeEqualTo(Date value) {
            addCriterion("PT_TIME =", value, "ptTime");
            return (Criteria) this;
        }

        public Criteria andPtTimeNotEqualTo(Date value) {
            addCriterion("PT_TIME <>", value, "ptTime");
            return (Criteria) this;
        }

        public Criteria andPtTimeGreaterThan(Date value) {
            addCriterion("PT_TIME >", value, "ptTime");
            return (Criteria) this;
        }

        public Criteria andPtTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("PT_TIME >=", value, "ptTime");
            return (Criteria) this;
        }

        public Criteria andPtTimeLessThan(Date value) {
            addCriterion("PT_TIME <", value, "ptTime");
            return (Criteria) this;
        }

        public Criteria andPtTimeLessThanOrEqualTo(Date value) {
            addCriterion("PT_TIME <=", value, "ptTime");
            return (Criteria) this;
        }

        public Criteria andPtTimeIn(List<Date> values) {
            addCriterion("PT_TIME in", values, "ptTime");
            return (Criteria) this;
        }

        public Criteria andPtTimeNotIn(List<Date> values) {
            addCriterion("PT_TIME not in", values, "ptTime");
            return (Criteria) this;
        }

        public Criteria andPtTimeBetween(Date value1, Date value2) {
            addCriterion("PT_TIME between", value1, value2, "ptTime");
            return (Criteria) this;
        }

        public Criteria andPtTimeNotBetween(Date value1, Date value2) {
            addCriterion("PT_TIME not between", value1, value2, "ptTime");
            return (Criteria) this;
        }

        public Criteria andIsClearIsNull() {
            addCriterion("IS_CLEAR is null");
            return (Criteria) this;
        }

        public Criteria andIsClearIsNotNull() {
            addCriterion("IS_CLEAR is not null");
            return (Criteria) this;
        }

        public Criteria andIsClearEqualTo(Byte value) {
            addCriterion("IS_CLEAR =", value, "isClear");
            return (Criteria) this;
        }

        public Criteria andIsClearNotEqualTo(Byte value) {
            addCriterion("IS_CLEAR <>", value, "isClear");
            return (Criteria) this;
        }

        public Criteria andIsClearGreaterThan(Byte value) {
            addCriterion("IS_CLEAR >", value, "isClear");
            return (Criteria) this;
        }

        public Criteria andIsClearGreaterThanOrEqualTo(Byte value) {
            addCriterion("IS_CLEAR >=", value, "isClear");
            return (Criteria) this;
        }

        public Criteria andIsClearLessThan(Byte value) {
            addCriterion("IS_CLEAR <", value, "isClear");
            return (Criteria) this;
        }

        public Criteria andIsClearLessThanOrEqualTo(Byte value) {
            addCriterion("IS_CLEAR <=", value, "isClear");
            return (Criteria) this;
        }

        public Criteria andIsClearIn(List<Byte> values) {
            addCriterion("IS_CLEAR in", values, "isClear");
            return (Criteria) this;
        }

        public Criteria andIsClearNotIn(List<Byte> values) {
            addCriterion("IS_CLEAR not in", values, "isClear");
            return (Criteria) this;
        }

        public Criteria andIsClearBetween(Byte value1, Byte value2) {
            addCriterion("IS_CLEAR between", value1, value2, "isClear");
            return (Criteria) this;
        }

        public Criteria andIsClearNotBetween(Byte value1, Byte value2) {
            addCriterion("IS_CLEAR not between", value1, value2, "isClear");
            return (Criteria) this;
        }

        public Criteria andClearTimeIsNull() {
            addCriterion("CLEAR_TIME is null");
            return (Criteria) this;
        }

        public Criteria andClearTimeIsNotNull() {
            addCriterion("CLEAR_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andClearTimeEqualTo(Date value) {
            addCriterion("CLEAR_TIME =", value, "clearTime");
            return (Criteria) this;
        }

        public Criteria andClearTimeNotEqualTo(Date value) {
            addCriterion("CLEAR_TIME <>", value, "clearTime");
            return (Criteria) this;
        }

        public Criteria andClearTimeGreaterThan(Date value) {
            addCriterion("CLEAR_TIME >", value, "clearTime");
            return (Criteria) this;
        }

        public Criteria andClearTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("CLEAR_TIME >=", value, "clearTime");
            return (Criteria) this;
        }

        public Criteria andClearTimeLessThan(Date value) {
            addCriterion("CLEAR_TIME <", value, "clearTime");
            return (Criteria) this;
        }

        public Criteria andClearTimeLessThanOrEqualTo(Date value) {
            addCriterion("CLEAR_TIME <=", value, "clearTime");
            return (Criteria) this;
        }

        public Criteria andClearTimeIn(List<Date> values) {
            addCriterion("CLEAR_TIME in", values, "clearTime");
            return (Criteria) this;
        }

        public Criteria andClearTimeNotIn(List<Date> values) {
            addCriterion("CLEAR_TIME not in", values, "clearTime");
            return (Criteria) this;
        }

        public Criteria andClearTimeBetween(Date value1, Date value2) {
            addCriterion("CLEAR_TIME between", value1, value2, "clearTime");
            return (Criteria) this;
        }

        public Criteria andClearTimeNotBetween(Date value1, Date value2) {
            addCriterion("CLEAR_TIME not between", value1, value2, "clearTime");
            return (Criteria) this;
        }

        public Criteria andPaymentsDescIsNull() {
            addCriterion("PAYMENTS_DESC is null");
            return (Criteria) this;
        }

        public Criteria andPaymentsDescIsNotNull() {
            addCriterion("PAYMENTS_DESC is not null");
            return (Criteria) this;
        }

        public Criteria andPaymentsDescEqualTo(String value) {
            addCriterion("PAYMENTS_DESC =", value, "paymentsDesc");
            return (Criteria) this;
        }

        public Criteria andPaymentsDescNotEqualTo(String value) {
            addCriterion("PAYMENTS_DESC <>", value, "paymentsDesc");
            return (Criteria) this;
        }

        public Criteria andPaymentsDescGreaterThan(String value) {
            addCriterion("PAYMENTS_DESC >", value, "paymentsDesc");
            return (Criteria) this;
        }

        public Criteria andPaymentsDescGreaterThanOrEqualTo(String value) {
            addCriterion("PAYMENTS_DESC >=", value, "paymentsDesc");
            return (Criteria) this;
        }

        public Criteria andPaymentsDescLessThan(String value) {
            addCriterion("PAYMENTS_DESC <", value, "paymentsDesc");
            return (Criteria) this;
        }

        public Criteria andPaymentsDescLessThanOrEqualTo(String value) {
            addCriterion("PAYMENTS_DESC <=", value, "paymentsDesc");
            return (Criteria) this;
        }

        public Criteria andPaymentsDescLike(String value) {
            addCriterion("PAYMENTS_DESC like", value, "paymentsDesc");
            return (Criteria) this;
        }

        public Criteria andPaymentsDescNotLike(String value) {
            addCriterion("PAYMENTS_DESC not like", value, "paymentsDesc");
            return (Criteria) this;
        }

        public Criteria andPaymentsDescIn(List<String> values) {
            addCriterion("PAYMENTS_DESC in", values, "paymentsDesc");
            return (Criteria) this;
        }

        public Criteria andPaymentsDescNotIn(List<String> values) {
            addCriterion("PAYMENTS_DESC not in", values, "paymentsDesc");
            return (Criteria) this;
        }

        public Criteria andPaymentsDescBetween(String value1, String value2) {
            addCriterion("PAYMENTS_DESC between", value1, value2, "paymentsDesc");
            return (Criteria) this;
        }

        public Criteria andPaymentsDescNotBetween(String value1, String value2) {
            addCriterion("PAYMENTS_DESC not between", value1, value2, "paymentsDesc");
            return (Criteria) this;
        }

        public Criteria andQuanGiftIsNull() {
            addCriterion("QUAN_GIFT is null");
            return (Criteria) this;
        }

        public Criteria andQuanGiftIsNotNull() {
            addCriterion("QUAN_GIFT is not null");
            return (Criteria) this;
        }

        public Criteria andQuanGiftEqualTo(Integer value) {
            addCriterion("QUAN_GIFT =", value, "quanGift");
            return (Criteria) this;
        }

        public Criteria andQuanGiftNotEqualTo(Integer value) {
            addCriterion("QUAN_GIFT <>", value, "quanGift");
            return (Criteria) this;
        }

        public Criteria andQuanGiftGreaterThan(Integer value) {
            addCriterion("QUAN_GIFT >", value, "quanGift");
            return (Criteria) this;
        }

        public Criteria andQuanGiftGreaterThanOrEqualTo(Integer value) {
            addCriterion("QUAN_GIFT >=", value, "quanGift");
            return (Criteria) this;
        }

        public Criteria andQuanGiftLessThan(Integer value) {
            addCriterion("QUAN_GIFT <", value, "quanGift");
            return (Criteria) this;
        }

        public Criteria andQuanGiftLessThanOrEqualTo(Integer value) {
            addCriterion("QUAN_GIFT <=", value, "quanGift");
            return (Criteria) this;
        }

        public Criteria andQuanGiftIn(List<Integer> values) {
            addCriterion("QUAN_GIFT in", values, "quanGift");
            return (Criteria) this;
        }

        public Criteria andQuanGiftNotIn(List<Integer> values) {
            addCriterion("QUAN_GIFT not in", values, "quanGift");
            return (Criteria) this;
        }

        public Criteria andQuanGiftBetween(Integer value1, Integer value2) {
            addCriterion("QUAN_GIFT between", value1, value2, "quanGift");
            return (Criteria) this;
        }

        public Criteria andQuanGiftNotBetween(Integer value1, Integer value2) {
            addCriterion("QUAN_GIFT not between", value1, value2, "quanGift");
            return (Criteria) this;
        }

        public Criteria andAutoTaskIsNull() {
            addCriterion("AUTO_TASK is null");
            return (Criteria) this;
        }

        public Criteria andAutoTaskIsNotNull() {
            addCriterion("AUTO_TASK is not null");
            return (Criteria) this;
        }

        public Criteria andAutoTaskEqualTo(Boolean value) {
            addCriterion("AUTO_TASK =", value, "autoTask");
            return (Criteria) this;
        }

        public Criteria andAutoTaskNotEqualTo(Boolean value) {
            addCriterion("AUTO_TASK <>", value, "autoTask");
            return (Criteria) this;
        }

        public Criteria andAutoTaskGreaterThan(Boolean value) {
            addCriterion("AUTO_TASK >", value, "autoTask");
            return (Criteria) this;
        }

        public Criteria andAutoTaskGreaterThanOrEqualTo(Boolean value) {
            addCriterion("AUTO_TASK >=", value, "autoTask");
            return (Criteria) this;
        }

        public Criteria andAutoTaskLessThan(Boolean value) {
            addCriterion("AUTO_TASK <", value, "autoTask");
            return (Criteria) this;
        }

        public Criteria andAutoTaskLessThanOrEqualTo(Boolean value) {
            addCriterion("AUTO_TASK <=", value, "autoTask");
            return (Criteria) this;
        }

        public Criteria andAutoTaskIn(List<Boolean> values) {
            addCriterion("AUTO_TASK in", values, "autoTask");
            return (Criteria) this;
        }

        public Criteria andAutoTaskNotIn(List<Boolean> values) {
            addCriterion("AUTO_TASK not in", values, "autoTask");
            return (Criteria) this;
        }

        public Criteria andAutoTaskBetween(Boolean value1, Boolean value2) {
            addCriterion("AUTO_TASK between", value1, value2, "autoTask");
            return (Criteria) this;
        }

        public Criteria andAutoTaskNotBetween(Boolean value1, Boolean value2) {
            addCriterion("AUTO_TASK not between", value1, value2, "autoTask");
            return (Criteria) this;
        }

        public Criteria andPaymentStatusIsNull() {
            addCriterion("PAYMENT_STATUS is null");
            return (Criteria) this;
        }

        public Criteria andPaymentStatusIsNotNull() {
            addCriterion("PAYMENT_STATUS is not null");
            return (Criteria) this;
        }

        public Criteria andPaymentStatusEqualTo(Byte value) {
            addCriterion("PAYMENT_STATUS =", value, "paymentStatus");
            return (Criteria) this;
        }

        public Criteria andPaymentStatusNotEqualTo(Byte value) {
            addCriterion("PAYMENT_STATUS <>", value, "paymentStatus");
            return (Criteria) this;
        }

        public Criteria andPaymentStatusGreaterThan(Byte value) {
            addCriterion("PAYMENT_STATUS >", value, "paymentStatus");
            return (Criteria) this;
        }

        public Criteria andPaymentStatusGreaterThanOrEqualTo(Byte value) {
            addCriterion("PAYMENT_STATUS >=", value, "paymentStatus");
            return (Criteria) this;
        }

        public Criteria andPaymentStatusLessThan(Byte value) {
            addCriterion("PAYMENT_STATUS <", value, "paymentStatus");
            return (Criteria) this;
        }

        public Criteria andPaymentStatusLessThanOrEqualTo(Byte value) {
            addCriterion("PAYMENT_STATUS <=", value, "paymentStatus");
            return (Criteria) this;
        }

        public Criteria andPaymentStatusIn(List<Byte> values) {
            addCriterion("PAYMENT_STATUS in", values, "paymentStatus");
            return (Criteria) this;
        }

        public Criteria andPaymentStatusNotIn(List<Byte> values) {
            addCriterion("PAYMENT_STATUS not in", values, "paymentStatus");
            return (Criteria) this;
        }

        public Criteria andPaymentStatusBetween(Byte value1, Byte value2) {
            addCriterion("PAYMENT_STATUS between", value1, value2, "paymentStatus");
            return (Criteria) this;
        }

        public Criteria andPaymentStatusNotBetween(Byte value1, Byte value2) {
            addCriterion("PAYMENT_STATUS not between", value1, value2, "paymentStatus");
            return (Criteria) this;
        }

        public Criteria andTargetIdsIsNull() {
            addCriterion("TARGET_IDS is null");
            return (Criteria) this;
        }

        public Criteria andTargetIdsIsNotNull() {
            addCriterion("TARGET_IDS is not null");
            return (Criteria) this;
        }

        public Criteria andTargetIdsEqualTo(String value) {
            addCriterion("TARGET_IDS =", value, "targetIds");
            return (Criteria) this;
        }

        public Criteria andTargetIdsNotEqualTo(String value) {
            addCriterion("TARGET_IDS <>", value, "targetIds");
            return (Criteria) this;
        }

        public Criteria andTargetIdsGreaterThan(String value) {
            addCriterion("TARGET_IDS >", value, "targetIds");
            return (Criteria) this;
        }

        public Criteria andTargetIdsGreaterThanOrEqualTo(String value) {
            addCriterion("TARGET_IDS >=", value, "targetIds");
            return (Criteria) this;
        }

        public Criteria andTargetIdsLessThan(String value) {
            addCriterion("TARGET_IDS <", value, "targetIds");
            return (Criteria) this;
        }

        public Criteria andTargetIdsLessThanOrEqualTo(String value) {
            addCriterion("TARGET_IDS <=", value, "targetIds");
            return (Criteria) this;
        }

        public Criteria andTargetIdsLike(String value) {
            addCriterion("TARGET_IDS like", value, "targetIds");
            return (Criteria) this;
        }

        public Criteria andTargetIdsNotLike(String value) {
            addCriterion("TARGET_IDS not like", value, "targetIds");
            return (Criteria) this;
        }

        public Criteria andTargetIdsIn(List<String> values) {
            addCriterion("TARGET_IDS in", values, "targetIds");
            return (Criteria) this;
        }

        public Criteria andTargetIdsNotIn(List<String> values) {
            addCriterion("TARGET_IDS not in", values, "targetIds");
            return (Criteria) this;
        }

        public Criteria andTargetIdsBetween(String value1, String value2) {
            addCriterion("TARGET_IDS between", value1, value2, "targetIds");
            return (Criteria) this;
        }

        public Criteria andTargetIdsNotBetween(String value1, String value2) {
            addCriterion("TARGET_IDS not between", value1, value2, "targetIds");
            return (Criteria) this;
        }

        public Criteria andExtFieldIsNull() {
            addCriterion("EXT_FIELD is null");
            return (Criteria) this;
        }

        public Criteria andExtFieldIsNotNull() {
            addCriterion("EXT_FIELD is not null");
            return (Criteria) this;
        }

        public Criteria andExtFieldEqualTo(String value) {
            addCriterion("EXT_FIELD =", value, "extField");
            return (Criteria) this;
        }

        public Criteria andExtFieldNotEqualTo(String value) {
            addCriterion("EXT_FIELD <>", value, "extField");
            return (Criteria) this;
        }

        public Criteria andExtFieldGreaterThan(String value) {
            addCriterion("EXT_FIELD >", value, "extField");
            return (Criteria) this;
        }

        public Criteria andExtFieldGreaterThanOrEqualTo(String value) {
            addCriterion("EXT_FIELD >=", value, "extField");
            return (Criteria) this;
        }

        public Criteria andExtFieldLessThan(String value) {
            addCriterion("EXT_FIELD <", value, "extField");
            return (Criteria) this;
        }

        public Criteria andExtFieldLessThanOrEqualTo(String value) {
            addCriterion("EXT_FIELD <=", value, "extField");
            return (Criteria) this;
        }

        public Criteria andExtFieldLike(String value) {
            addCriterion("EXT_FIELD like", value, "extField");
            return (Criteria) this;
        }

        public Criteria andExtFieldNotLike(String value) {
            addCriterion("EXT_FIELD not like", value, "extField");
            return (Criteria) this;
        }

        public Criteria andExtFieldIn(List<String> values) {
            addCriterion("EXT_FIELD in", values, "extField");
            return (Criteria) this;
        }

        public Criteria andExtFieldNotIn(List<String> values) {
            addCriterion("EXT_FIELD not in", values, "extField");
            return (Criteria) this;
        }

        public Criteria andExtFieldBetween(String value1, String value2) {
            addCriterion("EXT_FIELD between", value1, value2, "extField");
            return (Criteria) this;
        }

        public Criteria andExtFieldNotBetween(String value1, String value2) {
            addCriterion("EXT_FIELD not between", value1, value2, "extField");
            return (Criteria) this;
        }

        public Criteria andOpenWeinxinStatusIsNull() {
            addCriterion("OPEN_WEINXIN_STATUS is null");
            return (Criteria) this;
        }

        public Criteria andOpenWeinxinStatusIsNotNull() {
            addCriterion("OPEN_WEINXIN_STATUS is not null");
            return (Criteria) this;
        }

        public Criteria andOpenWeinxinStatusEqualTo(Byte value) {
            addCriterion("OPEN_WEINXIN_STATUS =", value, "openWeinxinStatus");
            return (Criteria) this;
        }

        public Criteria andOpenWeinxinStatusNotEqualTo(Byte value) {
            addCriterion("OPEN_WEINXIN_STATUS <>", value, "openWeinxinStatus");
            return (Criteria) this;
        }

        public Criteria andOpenWeinxinStatusGreaterThan(Byte value) {
            addCriterion("OPEN_WEINXIN_STATUS >", value, "openWeinxinStatus");
            return (Criteria) this;
        }

        public Criteria andOpenWeinxinStatusGreaterThanOrEqualTo(Byte value) {
            addCriterion("OPEN_WEINXIN_STATUS >=", value, "openWeinxinStatus");
            return (Criteria) this;
        }

        public Criteria andOpenWeinxinStatusLessThan(Byte value) {
            addCriterion("OPEN_WEINXIN_STATUS <", value, "openWeinxinStatus");
            return (Criteria) this;
        }

        public Criteria andOpenWeinxinStatusLessThanOrEqualTo(Byte value) {
            addCriterion("OPEN_WEINXIN_STATUS <=", value, "openWeinxinStatus");
            return (Criteria) this;
        }

        public Criteria andOpenWeinxinStatusIn(List<Byte> values) {
            addCriterion("OPEN_WEINXIN_STATUS in", values, "openWeinxinStatus");
            return (Criteria) this;
        }

        public Criteria andOpenWeinxinStatusNotIn(List<Byte> values) {
            addCriterion("OPEN_WEINXIN_STATUS not in", values, "openWeinxinStatus");
            return (Criteria) this;
        }

        public Criteria andOpenWeinxinStatusBetween(Byte value1, Byte value2) {
            addCriterion("OPEN_WEINXIN_STATUS between", value1, value2, "openWeinxinStatus");
            return (Criteria) this;
        }

        public Criteria andOpenWeinxinStatusNotBetween(Byte value1, Byte value2) {
            addCriterion("OPEN_WEINXIN_STATUS not between", value1, value2, "openWeinxinStatus");
            return (Criteria) this;
        }

        public Criteria andOpenCustLevelIsNull() {
            addCriterion("OPEN_CUST_LEVEL is null");
            return (Criteria) this;
        }

        public Criteria andOpenCustLevelIsNotNull() {
            addCriterion("OPEN_CUST_LEVEL is not null");
            return (Criteria) this;
        }

        public Criteria andOpenCustLevelEqualTo(Byte value) {
            addCriterion("OPEN_CUST_LEVEL =", value, "openCustLevel");
            return (Criteria) this;
        }

        public Criteria andOpenCustLevelNotEqualTo(Byte value) {
            addCriterion("OPEN_CUST_LEVEL <>", value, "openCustLevel");
            return (Criteria) this;
        }

        public Criteria andOpenCustLevelGreaterThan(Byte value) {
            addCriterion("OPEN_CUST_LEVEL >", value, "openCustLevel");
            return (Criteria) this;
        }

        public Criteria andOpenCustLevelGreaterThanOrEqualTo(Byte value) {
            addCriterion("OPEN_CUST_LEVEL >=", value, "openCustLevel");
            return (Criteria) this;
        }

        public Criteria andOpenCustLevelLessThan(Byte value) {
            addCriterion("OPEN_CUST_LEVEL <", value, "openCustLevel");
            return (Criteria) this;
        }

        public Criteria andOpenCustLevelLessThanOrEqualTo(Byte value) {
            addCriterion("OPEN_CUST_LEVEL <=", value, "openCustLevel");
            return (Criteria) this;
        }

        public Criteria andOpenCustLevelIn(List<Byte> values) {
            addCriterion("OPEN_CUST_LEVEL in", values, "openCustLevel");
            return (Criteria) this;
        }

        public Criteria andOpenCustLevelNotIn(List<Byte> values) {
            addCriterion("OPEN_CUST_LEVEL not in", values, "openCustLevel");
            return (Criteria) this;
        }

        public Criteria andOpenCustLevelBetween(Byte value1, Byte value2) {
            addCriterion("OPEN_CUST_LEVEL between", value1, value2, "openCustLevel");
            return (Criteria) this;
        }

        public Criteria andOpenCustLevelNotBetween(Byte value1, Byte value2) {
            addCriterion("OPEN_CUST_LEVEL not between", value1, value2, "openCustLevel");
            return (Criteria) this;
        }

        public Criteria andPaySourceIsNull() {
            addCriterion("PAY_SOURCE is null");
            return (Criteria) this;
        }

        public Criteria andPaySourceIsNotNull() {
            addCriterion("PAY_SOURCE is not null");
            return (Criteria) this;
        }

        public Criteria andPaySourceEqualTo(Byte value) {
            addCriterion("PAY_SOURCE =", value, "paySource");
            return (Criteria) this;
        }

        public Criteria andPaySourceNotEqualTo(Byte value) {
            addCriterion("PAY_SOURCE <>", value, "paySource");
            return (Criteria) this;
        }

        public Criteria andPaySourceGreaterThan(Byte value) {
            addCriterion("PAY_SOURCE >", value, "paySource");
            return (Criteria) this;
        }

        public Criteria andPaySourceGreaterThanOrEqualTo(Byte value) {
            addCriterion("PAY_SOURCE >=", value, "paySource");
            return (Criteria) this;
        }

        public Criteria andPaySourceLessThan(Byte value) {
            addCriterion("PAY_SOURCE <", value, "paySource");
            return (Criteria) this;
        }

        public Criteria andPaySourceLessThanOrEqualTo(Byte value) {
            addCriterion("PAY_SOURCE <=", value, "paySource");
            return (Criteria) this;
        }

        public Criteria andPaySourceIn(List<Byte> values) {
            addCriterion("PAY_SOURCE in", values, "paySource");
            return (Criteria) this;
        }

        public Criteria andPaySourceNotIn(List<Byte> values) {
            addCriterion("PAY_SOURCE not in", values, "paySource");
            return (Criteria) this;
        }

        public Criteria andPaySourceBetween(Byte value1, Byte value2) {
            addCriterion("PAY_SOURCE between", value1, value2, "paySource");
            return (Criteria) this;
        }

        public Criteria andPaySourceNotBetween(Byte value1, Byte value2) {
            addCriterion("PAY_SOURCE not between", value1, value2, "paySource");
            return (Criteria) this;
        }

        public Criteria andOtoVrActivityIsNull() {
            addCriterion("OTO_VR_ACTIVITY is null");
            return (Criteria) this;
        }

        public Criteria andOtoVrActivityIsNotNull() {
            addCriterion("OTO_VR_ACTIVITY is not null");
            return (Criteria) this;
        }

        public Criteria andOtoVrActivityEqualTo(Byte value) {
            addCriterion("OTO_VR_ACTIVITY =", value, "otoVrActivity");
            return (Criteria) this;
        }

        public Criteria andOtoVrActivityNotEqualTo(Byte value) {
            addCriterion("OTO_VR_ACTIVITY <>", value, "otoVrActivity");
            return (Criteria) this;
        }

        public Criteria andOtoVrActivityGreaterThan(Byte value) {
            addCriterion("OTO_VR_ACTIVITY >", value, "otoVrActivity");
            return (Criteria) this;
        }

        public Criteria andOtoVrActivityGreaterThanOrEqualTo(Byte value) {
            addCriterion("OTO_VR_ACTIVITY >=", value, "otoVrActivity");
            return (Criteria) this;
        }

        public Criteria andOtoVrActivityLessThan(Byte value) {
            addCriterion("OTO_VR_ACTIVITY <", value, "otoVrActivity");
            return (Criteria) this;
        }

        public Criteria andOtoVrActivityLessThanOrEqualTo(Byte value) {
            addCriterion("OTO_VR_ACTIVITY <=", value, "otoVrActivity");
            return (Criteria) this;
        }

        public Criteria andOtoVrActivityIn(List<Byte> values) {
            addCriterion("OTO_VR_ACTIVITY in", values, "otoVrActivity");
            return (Criteria) this;
        }

        public Criteria andOtoVrActivityNotIn(List<Byte> values) {
            addCriterion("OTO_VR_ACTIVITY not in", values, "otoVrActivity");
            return (Criteria) this;
        }

        public Criteria andOtoVrActivityBetween(Byte value1, Byte value2) {
            addCriterion("OTO_VR_ACTIVITY between", value1, value2, "otoVrActivity");
            return (Criteria) this;
        }

        public Criteria andOtoVrActivityNotBetween(Byte value1, Byte value2) {
            addCriterion("OTO_VR_ACTIVITY not between", value1, value2, "otoVrActivity");
            return (Criteria) this;
        }

        public Criteria andCommisionRateIsNull() {
            addCriterion("COMMISION_RATE is null");
            return (Criteria) this;
        }

        public Criteria andCommisionRateIsNotNull() {
            addCriterion("COMMISION_RATE is not null");
            return (Criteria) this;
        }

        public Criteria andCommisionRateEqualTo(Double value) {
            addCriterion("COMMISION_RATE =", value, "commisionRate");
            return (Criteria) this;
        }

        public Criteria andCommisionRateNotEqualTo(Double value) {
            addCriterion("COMMISION_RATE <>", value, "commisionRate");
            return (Criteria) this;
        }

        public Criteria andCommisionRateGreaterThan(Double value) {
            addCriterion("COMMISION_RATE >", value, "commisionRate");
            return (Criteria) this;
        }

        public Criteria andCommisionRateGreaterThanOrEqualTo(Double value) {
            addCriterion("COMMISION_RATE >=", value, "commisionRate");
            return (Criteria) this;
        }

        public Criteria andCommisionRateLessThan(Double value) {
            addCriterion("COMMISION_RATE <", value, "commisionRate");
            return (Criteria) this;
        }

        public Criteria andCommisionRateLessThanOrEqualTo(Double value) {
            addCriterion("COMMISION_RATE <=", value, "commisionRate");
            return (Criteria) this;
        }

        public Criteria andCommisionRateIn(List<Double> values) {
            addCriterion("COMMISION_RATE in", values, "commisionRate");
            return (Criteria) this;
        }

        public Criteria andCommisionRateNotIn(List<Double> values) {
            addCriterion("COMMISION_RATE not in", values, "commisionRate");
            return (Criteria) this;
        }

        public Criteria andCommisionRateBetween(Double value1, Double value2) {
            addCriterion("COMMISION_RATE between", value1, value2, "commisionRate");
            return (Criteria) this;
        }

        public Criteria andCommisionRateNotBetween(Double value1, Double value2) {
            addCriterion("COMMISION_RATE not between", value1, value2, "commisionRate");
            return (Criteria) this;
        }

        public Criteria andOrderNoIsNull() {
            addCriterion("ORDER_NO is null");
            return (Criteria) this;
        }

        public Criteria andOrderNoIsNotNull() {
            addCriterion("ORDER_NO is not null");
            return (Criteria) this;
        }

        public Criteria andOrderNoEqualTo(String value) {
            addCriterion("ORDER_NO =", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoNotEqualTo(String value) {
            addCriterion("ORDER_NO <>", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoGreaterThan(String value) {
            addCriterion("ORDER_NO >", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoGreaterThanOrEqualTo(String value) {
            addCriterion("ORDER_NO >=", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoLessThan(String value) {
            addCriterion("ORDER_NO <", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoLessThanOrEqualTo(String value) {
            addCriterion("ORDER_NO <=", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoLike(String value) {
            addCriterion("ORDER_NO like", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoNotLike(String value) {
            addCriterion("ORDER_NO not like", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoIn(List<String> values) {
            addCriterion("ORDER_NO in", values, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoNotIn(List<String> values) {
            addCriterion("ORDER_NO not in", values, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoBetween(String value1, String value2) {
            addCriterion("ORDER_NO between", value1, value2, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoNotBetween(String value1, String value2) {
            addCriterion("ORDER_NO not between", value1, value2, "orderNo");
            return (Criteria) this;
        }

        public Criteria andPayModelIsNull() {
            addCriterion("PAY_MODEL is null");
            return (Criteria) this;
        }

        public Criteria andPayModelIsNotNull() {
            addCriterion("PAY_MODEL is not null");
            return (Criteria) this;
        }

        public Criteria andPayModelEqualTo(Byte value) {
            addCriterion("PAY_MODEL =", value, "payModel");
            return (Criteria) this;
        }

        public Criteria andPayModelNotEqualTo(Byte value) {
            addCriterion("PAY_MODEL <>", value, "payModel");
            return (Criteria) this;
        }

        public Criteria andPayModelGreaterThan(Byte value) {
            addCriterion("PAY_MODEL >", value, "payModel");
            return (Criteria) this;
        }

        public Criteria andPayModelGreaterThanOrEqualTo(Byte value) {
            addCriterion("PAY_MODEL >=", value, "payModel");
            return (Criteria) this;
        }

        public Criteria andPayModelLessThan(Byte value) {
            addCriterion("PAY_MODEL <", value, "payModel");
            return (Criteria) this;
        }

        public Criteria andPayModelLessThanOrEqualTo(Byte value) {
            addCriterion("PAY_MODEL <=", value, "payModel");
            return (Criteria) this;
        }

        public Criteria andPayModelIn(List<Byte> values) {
            addCriterion("PAY_MODEL in", values, "payModel");
            return (Criteria) this;
        }

        public Criteria andPayModelNotIn(List<Byte> values) {
            addCriterion("PAY_MODEL not in", values, "payModel");
            return (Criteria) this;
        }

        public Criteria andPayModelBetween(Byte value1, Byte value2) {
            addCriterion("PAY_MODEL between", value1, value2, "payModel");
            return (Criteria) this;
        }

        public Criteria andPayModelNotBetween(Byte value1, Byte value2) {
            addCriterion("PAY_MODEL not between", value1, value2, "payModel");
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

        public Criteria andActivityNumIsNull() {
            addCriterion("ACTIVITY_NUM is null");
            return (Criteria) this;
        }

        public Criteria andActivityNumIsNotNull() {
            addCriterion("ACTIVITY_NUM is not null");
            return (Criteria) this;
        }

        public Criteria andActivityNumEqualTo(String value) {
            addCriterion("ACTIVITY_NUM =", value, "activityNum");
            return (Criteria) this;
        }

        public Criteria andActivityNumNotEqualTo(String value) {
            addCriterion("ACTIVITY_NUM <>", value, "activityNum");
            return (Criteria) this;
        }

        public Criteria andActivityNumGreaterThan(String value) {
            addCriterion("ACTIVITY_NUM >", value, "activityNum");
            return (Criteria) this;
        }

        public Criteria andActivityNumGreaterThanOrEqualTo(String value) {
            addCriterion("ACTIVITY_NUM >=", value, "activityNum");
            return (Criteria) this;
        }

        public Criteria andActivityNumLessThan(String value) {
            addCriterion("ACTIVITY_NUM <", value, "activityNum");
            return (Criteria) this;
        }

        public Criteria andActivityNumLessThanOrEqualTo(String value) {
            addCriterion("ACTIVITY_NUM <=", value, "activityNum");
            return (Criteria) this;
        }

        public Criteria andActivityNumLike(String value) {
            addCriterion("ACTIVITY_NUM like", value, "activityNum");
            return (Criteria) this;
        }

        public Criteria andActivityNumNotLike(String value) {
            addCriterion("ACTIVITY_NUM not like", value, "activityNum");
            return (Criteria) this;
        }

        public Criteria andActivityNumIn(List<String> values) {
            addCriterion("ACTIVITY_NUM in", values, "activityNum");
            return (Criteria) this;
        }

        public Criteria andActivityNumNotIn(List<String> values) {
            addCriterion("ACTIVITY_NUM not in", values, "activityNum");
            return (Criteria) this;
        }

        public Criteria andActivityNumBetween(String value1, String value2) {
            addCriterion("ACTIVITY_NUM between", value1, value2, "activityNum");
            return (Criteria) this;
        }

        public Criteria andActivityNumNotBetween(String value1, String value2) {
            addCriterion("ACTIVITY_NUM not between", value1, value2, "activityNum");
            return (Criteria) this;
        }

        public Criteria andAddVrIsNull() {
            addCriterion("ADD_VR is null");
            return (Criteria) this;
        }

        public Criteria andAddVrIsNotNull() {
            addCriterion("ADD_VR is not null");
            return (Criteria) this;
        }

        public Criteria andAddVrEqualTo(Byte value) {
            addCriterion("ADD_VR =", value, "addVr");
            return (Criteria) this;
        }

        public Criteria andAddVrNotEqualTo(Byte value) {
            addCriterion("ADD_VR <>", value, "addVr");
            return (Criteria) this;
        }

        public Criteria andAddVrGreaterThan(Byte value) {
            addCriterion("ADD_VR >", value, "addVr");
            return (Criteria) this;
        }

        public Criteria andAddVrGreaterThanOrEqualTo(Byte value) {
            addCriterion("ADD_VR >=", value, "addVr");
            return (Criteria) this;
        }

        public Criteria andAddVrLessThan(Byte value) {
            addCriterion("ADD_VR <", value, "addVr");
            return (Criteria) this;
        }

        public Criteria andAddVrLessThanOrEqualTo(Byte value) {
            addCriterion("ADD_VR <=", value, "addVr");
            return (Criteria) this;
        }

        public Criteria andAddVrIn(List<Byte> values) {
            addCriterion("ADD_VR in", values, "addVr");
            return (Criteria) this;
        }

        public Criteria andAddVrNotIn(List<Byte> values) {
            addCriterion("ADD_VR not in", values, "addVr");
            return (Criteria) this;
        }

        public Criteria andAddVrBetween(Byte value1, Byte value2) {
            addCriterion("ADD_VR between", value1, value2, "addVr");
            return (Criteria) this;
        }

        public Criteria andAddVrNotBetween(Byte value1, Byte value2) {
            addCriterion("ADD_VR not between", value1, value2, "addVr");
            return (Criteria) this;
        }

        public Criteria andVrPriceIsNull() {
            addCriterion("VR_PRICE is null");
            return (Criteria) this;
        }

        public Criteria andVrPriceIsNotNull() {
            addCriterion("VR_PRICE is not null");
            return (Criteria) this;
        }

        public Criteria andVrPriceEqualTo(Double value) {
            addCriterion("VR_PRICE =", value, "vrPrice");
            return (Criteria) this;
        }

        public Criteria andVrPriceNotEqualTo(Double value) {
            addCriterion("VR_PRICE <>", value, "vrPrice");
            return (Criteria) this;
        }

        public Criteria andVrPriceGreaterThan(Double value) {
            addCriterion("VR_PRICE >", value, "vrPrice");
            return (Criteria) this;
        }

        public Criteria andVrPriceGreaterThanOrEqualTo(Double value) {
            addCriterion("VR_PRICE >=", value, "vrPrice");
            return (Criteria) this;
        }

        public Criteria andVrPriceLessThan(Double value) {
            addCriterion("VR_PRICE <", value, "vrPrice");
            return (Criteria) this;
        }

        public Criteria andVrPriceLessThanOrEqualTo(Double value) {
            addCriterion("VR_PRICE <=", value, "vrPrice");
            return (Criteria) this;
        }

        public Criteria andVrPriceIn(List<Double> values) {
            addCriterion("VR_PRICE in", values, "vrPrice");
            return (Criteria) this;
        }

        public Criteria andVrPriceNotIn(List<Double> values) {
            addCriterion("VR_PRICE not in", values, "vrPrice");
            return (Criteria) this;
        }

        public Criteria andVrPriceBetween(Double value1, Double value2) {
            addCriterion("VR_PRICE between", value1, value2, "vrPrice");
            return (Criteria) this;
        }

        public Criteria andVrPriceNotBetween(Double value1, Double value2) {
            addCriterion("VR_PRICE not between", value1, value2, "vrPrice");
            return (Criteria) this;
        }

        public Criteria andDkqPriceIsNull() {
            addCriterion("DKQ_PRICE is null");
            return (Criteria) this;
        }

        public Criteria andDkqPriceIsNotNull() {
            addCriterion("DKQ_PRICE is not null");
            return (Criteria) this;
        }

        public Criteria andDkqPriceEqualTo(BigDecimal value) {
            addCriterion("DKQ_PRICE =", value, "dkqPrice");
            return (Criteria) this;
        }

        public Criteria andDkqPriceNotEqualTo(BigDecimal value) {
            addCriterion("DKQ_PRICE <>", value, "dkqPrice");
            return (Criteria) this;
        }

        public Criteria andDkqPriceGreaterThan(BigDecimal value) {
            addCriterion("DKQ_PRICE >", value, "dkqPrice");
            return (Criteria) this;
        }

        public Criteria andDkqPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("DKQ_PRICE >=", value, "dkqPrice");
            return (Criteria) this;
        }

        public Criteria andDkqPriceLessThan(BigDecimal value) {
            addCriterion("DKQ_PRICE <", value, "dkqPrice");
            return (Criteria) this;
        }

        public Criteria andDkqPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("DKQ_PRICE <=", value, "dkqPrice");
            return (Criteria) this;
        }

        public Criteria andDkqPriceIn(List<BigDecimal> values) {
            addCriterion("DKQ_PRICE in", values, "dkqPrice");
            return (Criteria) this;
        }

        public Criteria andDkqPriceNotIn(List<BigDecimal> values) {
            addCriterion("DKQ_PRICE not in", values, "dkqPrice");
            return (Criteria) this;
        }

        public Criteria andDkqPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("DKQ_PRICE between", value1, value2, "dkqPrice");
            return (Criteria) this;
        }

        public Criteria andDkqPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("DKQ_PRICE not between", value1, value2, "dkqPrice");
            return (Criteria) this;
        }

        public Criteria andServerIdIsNull() {
            addCriterion("SERVER_ID is null");
            return (Criteria) this;
        }

        public Criteria andServerIdIsNotNull() {
            addCriterion("SERVER_ID is not null");
            return (Criteria) this;
        }

        public Criteria andServerIdEqualTo(Integer value) {
            addCriterion("SERVER_ID =", value, "serverId");
            return (Criteria) this;
        }

        public Criteria andServerIdNotEqualTo(Integer value) {
            addCriterion("SERVER_ID <>", value, "serverId");
            return (Criteria) this;
        }

        public Criteria andServerIdGreaterThan(Integer value) {
            addCriterion("SERVER_ID >", value, "serverId");
            return (Criteria) this;
        }

        public Criteria andServerIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("SERVER_ID >=", value, "serverId");
            return (Criteria) this;
        }

        public Criteria andServerIdLessThan(Integer value) {
            addCriterion("SERVER_ID <", value, "serverId");
            return (Criteria) this;
        }

        public Criteria andServerIdLessThanOrEqualTo(Integer value) {
            addCriterion("SERVER_ID <=", value, "serverId");
            return (Criteria) this;
        }

        public Criteria andServerIdIn(List<Integer> values) {
            addCriterion("SERVER_ID in", values, "serverId");
            return (Criteria) this;
        }

        public Criteria andServerIdNotIn(List<Integer> values) {
            addCriterion("SERVER_ID not in", values, "serverId");
            return (Criteria) this;
        }

        public Criteria andServerIdBetween(Integer value1, Integer value2) {
            addCriterion("SERVER_ID between", value1, value2, "serverId");
            return (Criteria) this;
        }

        public Criteria andServerIdNotBetween(Integer value1, Integer value2) {
            addCriterion("SERVER_ID not between", value1, value2, "serverId");
            return (Criteria) this;
        }

        public Criteria andRefundTimeIsNull() {
            addCriterion("REFUND_TIME is null");
            return (Criteria) this;
        }

        public Criteria andRefundTimeIsNotNull() {
            addCriterion("REFUND_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andRefundTimeEqualTo(Date value) {
            addCriterion("REFUND_TIME =", value, "refundTime");
            return (Criteria) this;
        }

        public Criteria andRefundTimeNotEqualTo(Date value) {
            addCriterion("REFUND_TIME <>", value, "refundTime");
            return (Criteria) this;
        }

        public Criteria andRefundTimeGreaterThan(Date value) {
            addCriterion("REFUND_TIME >", value, "refundTime");
            return (Criteria) this;
        }

        public Criteria andRefundTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("REFUND_TIME >=", value, "refundTime");
            return (Criteria) this;
        }

        public Criteria andRefundTimeLessThan(Date value) {
            addCriterion("REFUND_TIME <", value, "refundTime");
            return (Criteria) this;
        }

        public Criteria andRefundTimeLessThanOrEqualTo(Date value) {
            addCriterion("REFUND_TIME <=", value, "refundTime");
            return (Criteria) this;
        }

        public Criteria andRefundTimeIn(List<Date> values) {
            addCriterion("REFUND_TIME in", values, "refundTime");
            return (Criteria) this;
        }

        public Criteria andRefundTimeNotIn(List<Date> values) {
            addCriterion("REFUND_TIME not in", values, "refundTime");
            return (Criteria) this;
        }

        public Criteria andRefundTimeBetween(Date value1, Date value2) {
            addCriterion("REFUND_TIME between", value1, value2, "refundTime");
            return (Criteria) this;
        }

        public Criteria andRefundTimeNotBetween(Date value1, Date value2) {
            addCriterion("REFUND_TIME not between", value1, value2, "refundTime");
            return (Criteria) this;
        }

        public Criteria andRecommendIdIsNull() {
            addCriterion("RECOMMEND_ID is null");
            return (Criteria) this;
        }

        public Criteria andRecommendIdIsNotNull() {
            addCriterion("RECOMMEND_ID is not null");
            return (Criteria) this;
        }

        public Criteria andRecommendIdEqualTo(Integer value) {
            addCriterion("RECOMMEND_ID =", value, "recommendId");
            return (Criteria) this;
        }

        public Criteria andRecommendIdNotEqualTo(Integer value) {
            addCriterion("RECOMMEND_ID <>", value, "recommendId");
            return (Criteria) this;
        }

        public Criteria andRecommendIdGreaterThan(Integer value) {
            addCriterion("RECOMMEND_ID >", value, "recommendId");
            return (Criteria) this;
        }

        public Criteria andRecommendIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("RECOMMEND_ID >=", value, "recommendId");
            return (Criteria) this;
        }

        public Criteria andRecommendIdLessThan(Integer value) {
            addCriterion("RECOMMEND_ID <", value, "recommendId");
            return (Criteria) this;
        }

        public Criteria andRecommendIdLessThanOrEqualTo(Integer value) {
            addCriterion("RECOMMEND_ID <=", value, "recommendId");
            return (Criteria) this;
        }

        public Criteria andRecommendIdIn(List<Integer> values) {
            addCriterion("RECOMMEND_ID in", values, "recommendId");
            return (Criteria) this;
        }

        public Criteria andRecommendIdNotIn(List<Integer> values) {
            addCriterion("RECOMMEND_ID not in", values, "recommendId");
            return (Criteria) this;
        }

        public Criteria andRecommendIdBetween(Integer value1, Integer value2) {
            addCriterion("RECOMMEND_ID between", value1, value2, "recommendId");
            return (Criteria) this;
        }

        public Criteria andRecommendIdNotBetween(Integer value1, Integer value2) {
            addCriterion("RECOMMEND_ID not between", value1, value2, "recommendId");
            return (Criteria) this;
        }

        public Criteria andBalancePriceIsNull() {
            addCriterion("BALANCE_PRICE is null");
            return (Criteria) this;
        }

        public Criteria andBalancePriceIsNotNull() {
            addCriterion("BALANCE_PRICE is not null");
            return (Criteria) this;
        }

        public Criteria andBalancePriceEqualTo(BigDecimal value) {
            addCriterion("BALANCE_PRICE =", value, "balancePrice");
            return (Criteria) this;
        }

        public Criteria andBalancePriceNotEqualTo(BigDecimal value) {
            addCriterion("BALANCE_PRICE <>", value, "balancePrice");
            return (Criteria) this;
        }

        public Criteria andBalancePriceGreaterThan(BigDecimal value) {
            addCriterion("BALANCE_PRICE >", value, "balancePrice");
            return (Criteria) this;
        }

        public Criteria andBalancePriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("BALANCE_PRICE >=", value, "balancePrice");
            return (Criteria) this;
        }

        public Criteria andBalancePriceLessThan(BigDecimal value) {
            addCriterion("BALANCE_PRICE <", value, "balancePrice");
            return (Criteria) this;
        }

        public Criteria andBalancePriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("BALANCE_PRICE <=", value, "balancePrice");
            return (Criteria) this;
        }

        public Criteria andBalancePriceIn(List<BigDecimal> values) {
            addCriterion("BALANCE_PRICE in", values, "balancePrice");
            return (Criteria) this;
        }

        public Criteria andBalancePriceNotIn(List<BigDecimal> values) {
            addCriterion("BALANCE_PRICE not in", values, "balancePrice");
            return (Criteria) this;
        }

        public Criteria andBalancePriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("BALANCE_PRICE between", value1, value2, "balancePrice");
            return (Criteria) this;
        }

        public Criteria andBalancePriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("BALANCE_PRICE not between", value1, value2, "balancePrice");
            return (Criteria) this;
        }

        public Criteria andAddVrPriceIsNull() {
            addCriterion("ADD_VR_PRICE is null");
            return (Criteria) this;
        }

        public Criteria andAddVrPriceIsNotNull() {
            addCriterion("ADD_VR_PRICE is not null");
            return (Criteria) this;
        }

        public Criteria andAddVrPriceEqualTo(Double value) {
            addCriterion("ADD_VR_PRICE =", value, "addVrPrice");
            return (Criteria) this;
        }

        public Criteria andAddVrPriceNotEqualTo(Double value) {
            addCriterion("ADD_VR_PRICE <>", value, "addVrPrice");
            return (Criteria) this;
        }

        public Criteria andAddVrPriceGreaterThan(Double value) {
            addCriterion("ADD_VR_PRICE >", value, "addVrPrice");
            return (Criteria) this;
        }

        public Criteria andAddVrPriceGreaterThanOrEqualTo(Double value) {
            addCriterion("ADD_VR_PRICE >=", value, "addVrPrice");
            return (Criteria) this;
        }

        public Criteria andAddVrPriceLessThan(Double value) {
            addCriterion("ADD_VR_PRICE <", value, "addVrPrice");
            return (Criteria) this;
        }

        public Criteria andAddVrPriceLessThanOrEqualTo(Double value) {
            addCriterion("ADD_VR_PRICE <=", value, "addVrPrice");
            return (Criteria) this;
        }

        public Criteria andAddVrPriceIn(List<Double> values) {
            addCriterion("ADD_VR_PRICE in", values, "addVrPrice");
            return (Criteria) this;
        }

        public Criteria andAddVrPriceNotIn(List<Double> values) {
            addCriterion("ADD_VR_PRICE not in", values, "addVrPrice");
            return (Criteria) this;
        }

        public Criteria andAddVrPriceBetween(Double value1, Double value2) {
            addCriterion("ADD_VR_PRICE between", value1, value2, "addVrPrice");
            return (Criteria) this;
        }

        public Criteria andAddVrPriceNotBetween(Double value1, Double value2) {
            addCriterion("ADD_VR_PRICE not between", value1, value2, "addVrPrice");
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

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterion("UPDATE_TIME =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterion("UPDATE_TIME <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterion("UPDATE_TIME >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("UPDATE_TIME >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterion("UPDATE_TIME <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("UPDATE_TIME <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterion("UPDATE_TIME in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterion("UPDATE_TIME not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("UPDATE_TIME between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("UPDATE_TIME not between", value1, value2, "updateTime");
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

        public Criteria andSourceEqualTo(Integer value) {
            addCriterion("[SOURCE] =", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceNotEqualTo(Integer value) {
            addCriterion("[SOURCE] <>", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceGreaterThan(Integer value) {
            addCriterion("[SOURCE] >", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceGreaterThanOrEqualTo(Integer value) {
            addCriterion("[SOURCE] >=", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceLessThan(Integer value) {
            addCriterion("[SOURCE] <", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceLessThanOrEqualTo(Integer value) {
            addCriterion("[SOURCE] <=", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceIn(List<Integer> values) {
            addCriterion("[SOURCE] in", values, "source");
            return (Criteria) this;
        }

        public Criteria andSourceNotIn(List<Integer> values) {
            addCriterion("[SOURCE] not in", values, "source");
            return (Criteria) this;
        }

        public Criteria andSourceBetween(Integer value1, Integer value2) {
            addCriterion("[SOURCE] between", value1, value2, "source");
            return (Criteria) this;
        }

        public Criteria andSourceNotBetween(Integer value1, Integer value2) {
            addCriterion("[SOURCE] not between", value1, value2, "source");
            return (Criteria) this;
        }

        public Criteria andHbFqNumIsNull() {
            addCriterion("HB_FQ_NUM is null");
            return (Criteria) this;
        }

        public Criteria andHbFqNumIsNotNull() {
            addCriterion("HB_FQ_NUM is not null");
            return (Criteria) this;
        }

        public Criteria andHbFqNumEqualTo(Integer value) {
            addCriterion("HB_FQ_NUM =", value, "hbFqNum");
            return (Criteria) this;
        }

        public Criteria andHbFqNumNotEqualTo(Integer value) {
            addCriterion("HB_FQ_NUM <>", value, "hbFqNum");
            return (Criteria) this;
        }

        public Criteria andHbFqNumGreaterThan(Integer value) {
            addCriterion("HB_FQ_NUM >", value, "hbFqNum");
            return (Criteria) this;
        }

        public Criteria andHbFqNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("HB_FQ_NUM >=", value, "hbFqNum");
            return (Criteria) this;
        }

        public Criteria andHbFqNumLessThan(Integer value) {
            addCriterion("HB_FQ_NUM <", value, "hbFqNum");
            return (Criteria) this;
        }

        public Criteria andHbFqNumLessThanOrEqualTo(Integer value) {
            addCriterion("HB_FQ_NUM <=", value, "hbFqNum");
            return (Criteria) this;
        }

        public Criteria andHbFqNumIn(List<Integer> values) {
            addCriterion("HB_FQ_NUM in", values, "hbFqNum");
            return (Criteria) this;
        }

        public Criteria andHbFqNumNotIn(List<Integer> values) {
            addCriterion("HB_FQ_NUM not in", values, "hbFqNum");
            return (Criteria) this;
        }

        public Criteria andHbFqNumBetween(Integer value1, Integer value2) {
            addCriterion("HB_FQ_NUM between", value1, value2, "hbFqNum");
            return (Criteria) this;
        }

        public Criteria andHbFqNumNotBetween(Integer value1, Integer value2) {
            addCriterion("HB_FQ_NUM not between", value1, value2, "hbFqNum");
            return (Criteria) this;
        }

        public Criteria andHbFqSellerPercentIsNull() {
            addCriterion("HB_FQ_SELLER_PERCENT is null");
            return (Criteria) this;
        }

        public Criteria andHbFqSellerPercentIsNotNull() {
            addCriterion("HB_FQ_SELLER_PERCENT is not null");
            return (Criteria) this;
        }

        public Criteria andHbFqSellerPercentEqualTo(BigDecimal value) {
            addCriterion("HB_FQ_SELLER_PERCENT =", value, "hbFqSellerPercent");
            return (Criteria) this;
        }

        public Criteria andHbFqSellerPercentNotEqualTo(BigDecimal value) {
            addCriterion("HB_FQ_SELLER_PERCENT <>", value, "hbFqSellerPercent");
            return (Criteria) this;
        }

        public Criteria andHbFqSellerPercentGreaterThan(BigDecimal value) {
            addCriterion("HB_FQ_SELLER_PERCENT >", value, "hbFqSellerPercent");
            return (Criteria) this;
        }

        public Criteria andHbFqSellerPercentGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("HB_FQ_SELLER_PERCENT >=", value, "hbFqSellerPercent");
            return (Criteria) this;
        }

        public Criteria andHbFqSellerPercentLessThan(BigDecimal value) {
            addCriterion("HB_FQ_SELLER_PERCENT <", value, "hbFqSellerPercent");
            return (Criteria) this;
        }

        public Criteria andHbFqSellerPercentLessThanOrEqualTo(BigDecimal value) {
            addCriterion("HB_FQ_SELLER_PERCENT <=", value, "hbFqSellerPercent");
            return (Criteria) this;
        }

        public Criteria andHbFqSellerPercentIn(List<BigDecimal> values) {
            addCriterion("HB_FQ_SELLER_PERCENT in", values, "hbFqSellerPercent");
            return (Criteria) this;
        }

        public Criteria andHbFqSellerPercentNotIn(List<BigDecimal> values) {
            addCriterion("HB_FQ_SELLER_PERCENT not in", values, "hbFqSellerPercent");
            return (Criteria) this;
        }

        public Criteria andHbFqSellerPercentBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("HB_FQ_SELLER_PERCENT between", value1, value2, "hbFqSellerPercent");
            return (Criteria) this;
        }

        public Criteria andHbFqSellerPercentNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("HB_FQ_SELLER_PERCENT not between", value1, value2, "hbFqSellerPercent");
            return (Criteria) this;
        }

        public Criteria andFundChannelIsNull() {
            addCriterion("FUND_CHANNEL is null");
            return (Criteria) this;
        }

        public Criteria andFundChannelIsNotNull() {
            addCriterion("FUND_CHANNEL is not null");
            return (Criteria) this;
        }

        public Criteria andFundChannelEqualTo(String value) {
            addCriterion("FUND_CHANNEL =", value, "fundChannel");
            return (Criteria) this;
        }

        public Criteria andFundChannelNotEqualTo(String value) {
            addCriterion("FUND_CHANNEL <>", value, "fundChannel");
            return (Criteria) this;
        }

        public Criteria andFundChannelGreaterThan(String value) {
            addCriterion("FUND_CHANNEL >", value, "fundChannel");
            return (Criteria) this;
        }

        public Criteria andFundChannelGreaterThanOrEqualTo(String value) {
            addCriterion("FUND_CHANNEL >=", value, "fundChannel");
            return (Criteria) this;
        }

        public Criteria andFundChannelLessThan(String value) {
            addCriterion("FUND_CHANNEL <", value, "fundChannel");
            return (Criteria) this;
        }

        public Criteria andFundChannelLessThanOrEqualTo(String value) {
            addCriterion("FUND_CHANNEL <=", value, "fundChannel");
            return (Criteria) this;
        }

        public Criteria andFundChannelLike(String value) {
            addCriterion("FUND_CHANNEL like", value, "fundChannel");
            return (Criteria) this;
        }

        public Criteria andFundChannelNotLike(String value) {
            addCriterion("FUND_CHANNEL not like", value, "fundChannel");
            return (Criteria) this;
        }

        public Criteria andFundChannelIn(List<String> values) {
            addCriterion("FUND_CHANNEL in", values, "fundChannel");
            return (Criteria) this;
        }

        public Criteria andFundChannelNotIn(List<String> values) {
            addCriterion("FUND_CHANNEL not in", values, "fundChannel");
            return (Criteria) this;
        }

        public Criteria andFundChannelBetween(String value1, String value2) {
            addCriterion("FUND_CHANNEL between", value1, value2, "fundChannel");
            return (Criteria) this;
        }

        public Criteria andFundChannelNotBetween(String value1, String value2) {
            addCriterion("FUND_CHANNEL not between", value1, value2, "fundChannel");
            return (Criteria) this;
        }

        public Criteria andReceivableIsNull() {
            addCriterion("RECEIVABLE is null");
            return (Criteria) this;
        }

        public Criteria andReceivableIsNotNull() {
            addCriterion("RECEIVABLE is not null");
            return (Criteria) this;
        }

        public Criteria andReceivableEqualTo(BigDecimal value) {
            addCriterion("RECEIVABLE =", value, "receivable");
            return (Criteria) this;
        }

        public Criteria andReceivableNotEqualTo(BigDecimal value) {
            addCriterion("RECEIVABLE <>", value, "receivable");
            return (Criteria) this;
        }

        public Criteria andReceivableGreaterThan(BigDecimal value) {
            addCriterion("RECEIVABLE >", value, "receivable");
            return (Criteria) this;
        }

        public Criteria andReceivableGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("RECEIVABLE >=", value, "receivable");
            return (Criteria) this;
        }

        public Criteria andReceivableLessThan(BigDecimal value) {
            addCriterion("RECEIVABLE <", value, "receivable");
            return (Criteria) this;
        }

        public Criteria andReceivableLessThanOrEqualTo(BigDecimal value) {
            addCriterion("RECEIVABLE <=", value, "receivable");
            return (Criteria) this;
        }

        public Criteria andReceivableIn(List<BigDecimal> values) {
            addCriterion("RECEIVABLE in", values, "receivable");
            return (Criteria) this;
        }

        public Criteria andReceivableNotIn(List<BigDecimal> values) {
            addCriterion("RECEIVABLE not in", values, "receivable");
            return (Criteria) this;
        }

        public Criteria andReceivableBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("RECEIVABLE between", value1, value2, "receivable");
            return (Criteria) this;
        }

        public Criteria andReceivableNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("RECEIVABLE not between", value1, value2, "receivable");
            return (Criteria) this;
        }

        public Criteria andHbFqSellerPrecentRateIsNull() {
            addCriterion("HB_FQ_SELLER_PRECENT_RATE is null");
            return (Criteria) this;
        }

        public Criteria andHbFqSellerPrecentRateIsNotNull() {
            addCriterion("HB_FQ_SELLER_PRECENT_RATE is not null");
            return (Criteria) this;
        }

        public Criteria andHbFqSellerPrecentRateEqualTo(BigDecimal value) {
            addCriterion("HB_FQ_SELLER_PRECENT_RATE =", value, "hbFqSellerPrecentRate");
            return (Criteria) this;
        }

        public Criteria andHbFqSellerPrecentRateNotEqualTo(BigDecimal value) {
            addCriterion("HB_FQ_SELLER_PRECENT_RATE <>", value, "hbFqSellerPrecentRate");
            return (Criteria) this;
        }

        public Criteria andHbFqSellerPrecentRateGreaterThan(BigDecimal value) {
            addCriterion("HB_FQ_SELLER_PRECENT_RATE >", value, "hbFqSellerPrecentRate");
            return (Criteria) this;
        }

        public Criteria andHbFqSellerPrecentRateGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("HB_FQ_SELLER_PRECENT_RATE >=", value, "hbFqSellerPrecentRate");
            return (Criteria) this;
        }

        public Criteria andHbFqSellerPrecentRateLessThan(BigDecimal value) {
            addCriterion("HB_FQ_SELLER_PRECENT_RATE <", value, "hbFqSellerPrecentRate");
            return (Criteria) this;
        }

        public Criteria andHbFqSellerPrecentRateLessThanOrEqualTo(BigDecimal value) {
            addCriterion("HB_FQ_SELLER_PRECENT_RATE <=", value, "hbFqSellerPrecentRate");
            return (Criteria) this;
        }

        public Criteria andHbFqSellerPrecentRateIn(List<BigDecimal> values) {
            addCriterion("HB_FQ_SELLER_PRECENT_RATE in", values, "hbFqSellerPrecentRate");
            return (Criteria) this;
        }

        public Criteria andHbFqSellerPrecentRateNotIn(List<BigDecimal> values) {
            addCriterion("HB_FQ_SELLER_PRECENT_RATE not in", values, "hbFqSellerPrecentRate");
            return (Criteria) this;
        }

        public Criteria andHbFqSellerPrecentRateBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("HB_FQ_SELLER_PRECENT_RATE between", value1, value2, "hbFqSellerPrecentRate");
            return (Criteria) this;
        }

        public Criteria andHbFqSellerPrecentRateNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("HB_FQ_SELLER_PRECENT_RATE not between", value1, value2, "hbFqSellerPrecentRate");
            return (Criteria) this;
        }

        public Criteria andGiftVrNumIsNull() {
            addCriterion("GIFT_VR_NUM is null");
            return (Criteria) this;
        }

        public Criteria andGiftVrNumIsNotNull() {
            addCriterion("GIFT_VR_NUM is not null");
            return (Criteria) this;
        }

        public Criteria andGiftVrNumEqualTo(Integer value) {
            addCriterion("GIFT_VR_NUM =", value, "giftVrNum");
            return (Criteria) this;
        }

        public Criteria andGiftVrNumNotEqualTo(Integer value) {
            addCriterion("GIFT_VR_NUM <>", value, "giftVrNum");
            return (Criteria) this;
        }

        public Criteria andGiftVrNumGreaterThan(Integer value) {
            addCriterion("GIFT_VR_NUM >", value, "giftVrNum");
            return (Criteria) this;
        }

        public Criteria andGiftVrNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("GIFT_VR_NUM >=", value, "giftVrNum");
            return (Criteria) this;
        }

        public Criteria andGiftVrNumLessThan(Integer value) {
            addCriterion("GIFT_VR_NUM <", value, "giftVrNum");
            return (Criteria) this;
        }

        public Criteria andGiftVrNumLessThanOrEqualTo(Integer value) {
            addCriterion("GIFT_VR_NUM <=", value, "giftVrNum");
            return (Criteria) this;
        }

        public Criteria andGiftVrNumIn(List<Integer> values) {
            addCriterion("GIFT_VR_NUM in", values, "giftVrNum");
            return (Criteria) this;
        }

        public Criteria andGiftVrNumNotIn(List<Integer> values) {
            addCriterion("GIFT_VR_NUM not in", values, "giftVrNum");
            return (Criteria) this;
        }

        public Criteria andGiftVrNumBetween(Integer value1, Integer value2) {
            addCriterion("GIFT_VR_NUM between", value1, value2, "giftVrNum");
            return (Criteria) this;
        }

        public Criteria andGiftVrNumNotBetween(Integer value1, Integer value2) {
            addCriterion("GIFT_VR_NUM not between", value1, value2, "giftVrNum");
            return (Criteria) this;
        }

        public Criteria andTrainTicketIsNull() {
            addCriterion("TRAIN_TICKET is null");
            return (Criteria) this;
        }

        public Criteria andTrainTicketIsNotNull() {
            addCriterion("TRAIN_TICKET is not null");
            return (Criteria) this;
        }

        public Criteria andTrainTicketEqualTo(Integer value) {
            addCriterion("TRAIN_TICKET =", value, "trainTicket");
            return (Criteria) this;
        }

        public Criteria andTrainTicketNotEqualTo(Integer value) {
            addCriterion("TRAIN_TICKET <>", value, "trainTicket");
            return (Criteria) this;
        }

        public Criteria andTrainTicketGreaterThan(Integer value) {
            addCriterion("TRAIN_TICKET >", value, "trainTicket");
            return (Criteria) this;
        }

        public Criteria andTrainTicketGreaterThanOrEqualTo(Integer value) {
            addCriterion("TRAIN_TICKET >=", value, "trainTicket");
            return (Criteria) this;
        }

        public Criteria andTrainTicketLessThan(Integer value) {
            addCriterion("TRAIN_TICKET <", value, "trainTicket");
            return (Criteria) this;
        }

        public Criteria andTrainTicketLessThanOrEqualTo(Integer value) {
            addCriterion("TRAIN_TICKET <=", value, "trainTicket");
            return (Criteria) this;
        }

        public Criteria andTrainTicketIn(List<Integer> values) {
            addCriterion("TRAIN_TICKET in", values, "trainTicket");
            return (Criteria) this;
        }

        public Criteria andTrainTicketNotIn(List<Integer> values) {
            addCriterion("TRAIN_TICKET not in", values, "trainTicket");
            return (Criteria) this;
        }

        public Criteria andTrainTicketBetween(Integer value1, Integer value2) {
            addCriterion("TRAIN_TICKET between", value1, value2, "trainTicket");
            return (Criteria) this;
        }

        public Criteria andTrainTicketNotBetween(Integer value1, Integer value2) {
            addCriterion("TRAIN_TICKET not between", value1, value2, "trainTicket");
            return (Criteria) this;
        }

        public Criteria andSoftPriceIsNull() {
            addCriterion("SOFT_PRICE is null");
            return (Criteria) this;
        }

        public Criteria andSoftPriceIsNotNull() {
            addCriterion("SOFT_PRICE is not null");
            return (Criteria) this;
        }

        public Criteria andSoftPriceEqualTo(Integer value) {
            addCriterion("SOFT_PRICE =", value, "softPrice");
            return (Criteria) this;
        }

        public Criteria andSoftPriceNotEqualTo(Integer value) {
            addCriterion("SOFT_PRICE <>", value, "softPrice");
            return (Criteria) this;
        }

        public Criteria andSoftPriceGreaterThan(Integer value) {
            addCriterion("SOFT_PRICE >", value, "softPrice");
            return (Criteria) this;
        }

        public Criteria andSoftPriceGreaterThanOrEqualTo(Integer value) {
            addCriterion("SOFT_PRICE >=", value, "softPrice");
            return (Criteria) this;
        }

        public Criteria andSoftPriceLessThan(Integer value) {
            addCriterion("SOFT_PRICE <", value, "softPrice");
            return (Criteria) this;
        }

        public Criteria andSoftPriceLessThanOrEqualTo(Integer value) {
            addCriterion("SOFT_PRICE <=", value, "softPrice");
            return (Criteria) this;
        }

        public Criteria andSoftPriceIn(List<Integer> values) {
            addCriterion("SOFT_PRICE in", values, "softPrice");
            return (Criteria) this;
        }

        public Criteria andSoftPriceNotIn(List<Integer> values) {
            addCriterion("SOFT_PRICE not in", values, "softPrice");
            return (Criteria) this;
        }

        public Criteria andSoftPriceBetween(Integer value1, Integer value2) {
            addCriterion("SOFT_PRICE between", value1, value2, "softPrice");
            return (Criteria) this;
        }

        public Criteria andSoftPriceNotBetween(Integer value1, Integer value2) {
            addCriterion("SOFT_PRICE not between", value1, value2, "softPrice");
            return (Criteria) this;
        }

        public Criteria andBindVrUnitPriceIsNull() {
            addCriterion("BIND_VR_UNIT_PRICE is null");
            return (Criteria) this;
        }

        public Criteria andBindVrUnitPriceIsNotNull() {
            addCriterion("BIND_VR_UNIT_PRICE is not null");
            return (Criteria) this;
        }

        public Criteria andBindVrUnitPriceEqualTo(Integer value) {
            addCriterion("BIND_VR_UNIT_PRICE =", value, "bindVrUnitPrice");
            return (Criteria) this;
        }

        public Criteria andBindVrUnitPriceNotEqualTo(Integer value) {
            addCriterion("BIND_VR_UNIT_PRICE <>", value, "bindVrUnitPrice");
            return (Criteria) this;
        }

        public Criteria andBindVrUnitPriceGreaterThan(Integer value) {
            addCriterion("BIND_VR_UNIT_PRICE >", value, "bindVrUnitPrice");
            return (Criteria) this;
        }

        public Criteria andBindVrUnitPriceGreaterThanOrEqualTo(Integer value) {
            addCriterion("BIND_VR_UNIT_PRICE >=", value, "bindVrUnitPrice");
            return (Criteria) this;
        }

        public Criteria andBindVrUnitPriceLessThan(Integer value) {
            addCriterion("BIND_VR_UNIT_PRICE <", value, "bindVrUnitPrice");
            return (Criteria) this;
        }

        public Criteria andBindVrUnitPriceLessThanOrEqualTo(Integer value) {
            addCriterion("BIND_VR_UNIT_PRICE <=", value, "bindVrUnitPrice");
            return (Criteria) this;
        }

        public Criteria andBindVrUnitPriceIn(List<Integer> values) {
            addCriterion("BIND_VR_UNIT_PRICE in", values, "bindVrUnitPrice");
            return (Criteria) this;
        }

        public Criteria andBindVrUnitPriceNotIn(List<Integer> values) {
            addCriterion("BIND_VR_UNIT_PRICE not in", values, "bindVrUnitPrice");
            return (Criteria) this;
        }

        public Criteria andBindVrUnitPriceBetween(Integer value1, Integer value2) {
            addCriterion("BIND_VR_UNIT_PRICE between", value1, value2, "bindVrUnitPrice");
            return (Criteria) this;
        }

        public Criteria andBindVrUnitPriceNotBetween(Integer value1, Integer value2) {
            addCriterion("BIND_VR_UNIT_PRICE not between", value1, value2, "bindVrUnitPrice");
            return (Criteria) this;
        }

        public Criteria andBindWxPriceIsNull() {
            addCriterion("BIND_WX_PRICE is null");
            return (Criteria) this;
        }

        public Criteria andBindWxPriceIsNotNull() {
            addCriterion("BIND_WX_PRICE is not null");
            return (Criteria) this;
        }

        public Criteria andBindWxPriceEqualTo(Integer value) {
            addCriterion("BIND_WX_PRICE =", value, "bindWxPrice");
            return (Criteria) this;
        }

        public Criteria andBindWxPriceNotEqualTo(Integer value) {
            addCriterion("BIND_WX_PRICE <>", value, "bindWxPrice");
            return (Criteria) this;
        }

        public Criteria andBindWxPriceGreaterThan(Integer value) {
            addCriterion("BIND_WX_PRICE >", value, "bindWxPrice");
            return (Criteria) this;
        }

        public Criteria andBindWxPriceGreaterThanOrEqualTo(Integer value) {
            addCriterion("BIND_WX_PRICE >=", value, "bindWxPrice");
            return (Criteria) this;
        }

        public Criteria andBindWxPriceLessThan(Integer value) {
            addCriterion("BIND_WX_PRICE <", value, "bindWxPrice");
            return (Criteria) this;
        }

        public Criteria andBindWxPriceLessThanOrEqualTo(Integer value) {
            addCriterion("BIND_WX_PRICE <=", value, "bindWxPrice");
            return (Criteria) this;
        }

        public Criteria andBindWxPriceIn(List<Integer> values) {
            addCriterion("BIND_WX_PRICE in", values, "bindWxPrice");
            return (Criteria) this;
        }

        public Criteria andBindWxPriceNotIn(List<Integer> values) {
            addCriterion("BIND_WX_PRICE not in", values, "bindWxPrice");
            return (Criteria) this;
        }

        public Criteria andBindWxPriceBetween(Integer value1, Integer value2) {
            addCriterion("BIND_WX_PRICE between", value1, value2, "bindWxPrice");
            return (Criteria) this;
        }

        public Criteria andBindWxPriceNotBetween(Integer value1, Integer value2) {
            addCriterion("BIND_WX_PRICE not between", value1, value2, "bindWxPrice");
            return (Criteria) this;
        }

        public Criteria andBindCustPriceIsNull() {
            addCriterion("BIND_CUST_PRICE is null");
            return (Criteria) this;
        }

        public Criteria andBindCustPriceIsNotNull() {
            addCriterion("BIND_CUST_PRICE is not null");
            return (Criteria) this;
        }

        public Criteria andBindCustPriceEqualTo(Integer value) {
            addCriterion("BIND_CUST_PRICE =", value, "bindCustPrice");
            return (Criteria) this;
        }

        public Criteria andBindCustPriceNotEqualTo(Integer value) {
            addCriterion("BIND_CUST_PRICE <>", value, "bindCustPrice");
            return (Criteria) this;
        }

        public Criteria andBindCustPriceGreaterThan(Integer value) {
            addCriterion("BIND_CUST_PRICE >", value, "bindCustPrice");
            return (Criteria) this;
        }

        public Criteria andBindCustPriceGreaterThanOrEqualTo(Integer value) {
            addCriterion("BIND_CUST_PRICE >=", value, "bindCustPrice");
            return (Criteria) this;
        }

        public Criteria andBindCustPriceLessThan(Integer value) {
            addCriterion("BIND_CUST_PRICE <", value, "bindCustPrice");
            return (Criteria) this;
        }

        public Criteria andBindCustPriceLessThanOrEqualTo(Integer value) {
            addCriterion("BIND_CUST_PRICE <=", value, "bindCustPrice");
            return (Criteria) this;
        }

        public Criteria andBindCustPriceIn(List<Integer> values) {
            addCriterion("BIND_CUST_PRICE in", values, "bindCustPrice");
            return (Criteria) this;
        }

        public Criteria andBindCustPriceNotIn(List<Integer> values) {
            addCriterion("BIND_CUST_PRICE not in", values, "bindCustPrice");
            return (Criteria) this;
        }

        public Criteria andBindCustPriceBetween(Integer value1, Integer value2) {
            addCriterion("BIND_CUST_PRICE between", value1, value2, "bindCustPrice");
            return (Criteria) this;
        }

        public Criteria andBindCustPriceNotBetween(Integer value1, Integer value2) {
            addCriterion("BIND_CUST_PRICE not between", value1, value2, "bindCustPrice");
            return (Criteria) this;
        }

        public Criteria andBindSmaleProgramPriceIsNull() {
            addCriterion("BIND_SMALE_PROGRAM_PRICE is null");
            return (Criteria) this;
        }

        public Criteria andBindSmaleProgramPriceIsNotNull() {
            addCriterion("BIND_SMALE_PROGRAM_PRICE is not null");
            return (Criteria) this;
        }

        public Criteria andBindSmaleProgramPriceEqualTo(Integer value) {
            addCriterion("BIND_SMALE_PROGRAM_PRICE =", value, "bindSmaleProgramPrice");
            return (Criteria) this;
        }

        public Criteria andBindSmaleProgramPriceNotEqualTo(Integer value) {
            addCriterion("BIND_SMALE_PROGRAM_PRICE <>", value, "bindSmaleProgramPrice");
            return (Criteria) this;
        }

        public Criteria andBindSmaleProgramPriceGreaterThan(Integer value) {
            addCriterion("BIND_SMALE_PROGRAM_PRICE >", value, "bindSmaleProgramPrice");
            return (Criteria) this;
        }

        public Criteria andBindSmaleProgramPriceGreaterThanOrEqualTo(Integer value) {
            addCriterion("BIND_SMALE_PROGRAM_PRICE >=", value, "bindSmaleProgramPrice");
            return (Criteria) this;
        }

        public Criteria andBindSmaleProgramPriceLessThan(Integer value) {
            addCriterion("BIND_SMALE_PROGRAM_PRICE <", value, "bindSmaleProgramPrice");
            return (Criteria) this;
        }

        public Criteria andBindSmaleProgramPriceLessThanOrEqualTo(Integer value) {
            addCriterion("BIND_SMALE_PROGRAM_PRICE <=", value, "bindSmaleProgramPrice");
            return (Criteria) this;
        }

        public Criteria andBindSmaleProgramPriceIn(List<Integer> values) {
            addCriterion("BIND_SMALE_PROGRAM_PRICE in", values, "bindSmaleProgramPrice");
            return (Criteria) this;
        }

        public Criteria andBindSmaleProgramPriceNotIn(List<Integer> values) {
            addCriterion("BIND_SMALE_PROGRAM_PRICE not in", values, "bindSmaleProgramPrice");
            return (Criteria) this;
        }

        public Criteria andBindSmaleProgramPriceBetween(Integer value1, Integer value2) {
            addCriterion("BIND_SMALE_PROGRAM_PRICE between", value1, value2, "bindSmaleProgramPrice");
            return (Criteria) this;
        }

        public Criteria andBindSmaleProgramPriceNotBetween(Integer value1, Integer value2) {
            addCriterion("BIND_SMALE_PROGRAM_PRICE not between", value1, value2, "bindSmaleProgramPrice");
            return (Criteria) this;
        }

        public Criteria andBindCustVipNumIsNull() {
            addCriterion("BIND_CUST_VIP_NUM is null");
            return (Criteria) this;
        }

        public Criteria andBindCustVipNumIsNotNull() {
            addCriterion("BIND_CUST_VIP_NUM is not null");
            return (Criteria) this;
        }

        public Criteria andBindCustVipNumEqualTo(Integer value) {
            addCriterion("BIND_CUST_VIP_NUM =", value, "bindCustVipNum");
            return (Criteria) this;
        }

        public Criteria andBindCustVipNumNotEqualTo(Integer value) {
            addCriterion("BIND_CUST_VIP_NUM <>", value, "bindCustVipNum");
            return (Criteria) this;
        }

        public Criteria andBindCustVipNumGreaterThan(Integer value) {
            addCriterion("BIND_CUST_VIP_NUM >", value, "bindCustVipNum");
            return (Criteria) this;
        }

        public Criteria andBindCustVipNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("BIND_CUST_VIP_NUM >=", value, "bindCustVipNum");
            return (Criteria) this;
        }

        public Criteria andBindCustVipNumLessThan(Integer value) {
            addCriterion("BIND_CUST_VIP_NUM <", value, "bindCustVipNum");
            return (Criteria) this;
        }

        public Criteria andBindCustVipNumLessThanOrEqualTo(Integer value) {
            addCriterion("BIND_CUST_VIP_NUM <=", value, "bindCustVipNum");
            return (Criteria) this;
        }

        public Criteria andBindCustVipNumIn(List<Integer> values) {
            addCriterion("BIND_CUST_VIP_NUM in", values, "bindCustVipNum");
            return (Criteria) this;
        }

        public Criteria andBindCustVipNumNotIn(List<Integer> values) {
            addCriterion("BIND_CUST_VIP_NUM not in", values, "bindCustVipNum");
            return (Criteria) this;
        }

        public Criteria andBindCustVipNumBetween(Integer value1, Integer value2) {
            addCriterion("BIND_CUST_VIP_NUM between", value1, value2, "bindCustVipNum");
            return (Criteria) this;
        }

        public Criteria andBindCustVipNumNotBetween(Integer value1, Integer value2) {
            addCriterion("BIND_CUST_VIP_NUM not between", value1, value2, "bindCustVipNum");
            return (Criteria) this;
        }

        public Criteria andBindOtoNumIsNull() {
            addCriterion("BIND_OTO_NUM is null");
            return (Criteria) this;
        }

        public Criteria andBindOtoNumIsNotNull() {
            addCriterion("BIND_OTO_NUM is not null");
            return (Criteria) this;
        }

        public Criteria andBindOtoNumEqualTo(Integer value) {
            addCriterion("BIND_OTO_NUM =", value, "bindOtoNum");
            return (Criteria) this;
        }

        public Criteria andBindOtoNumNotEqualTo(Integer value) {
            addCriterion("BIND_OTO_NUM <>", value, "bindOtoNum");
            return (Criteria) this;
        }

        public Criteria andBindOtoNumGreaterThan(Integer value) {
            addCriterion("BIND_OTO_NUM >", value, "bindOtoNum");
            return (Criteria) this;
        }

        public Criteria andBindOtoNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("BIND_OTO_NUM >=", value, "bindOtoNum");
            return (Criteria) this;
        }

        public Criteria andBindOtoNumLessThan(Integer value) {
            addCriterion("BIND_OTO_NUM <", value, "bindOtoNum");
            return (Criteria) this;
        }

        public Criteria andBindOtoNumLessThanOrEqualTo(Integer value) {
            addCriterion("BIND_OTO_NUM <=", value, "bindOtoNum");
            return (Criteria) this;
        }

        public Criteria andBindOtoNumIn(List<Integer> values) {
            addCriterion("BIND_OTO_NUM in", values, "bindOtoNum");
            return (Criteria) this;
        }

        public Criteria andBindOtoNumNotIn(List<Integer> values) {
            addCriterion("BIND_OTO_NUM not in", values, "bindOtoNum");
            return (Criteria) this;
        }

        public Criteria andBindOtoNumBetween(Integer value1, Integer value2) {
            addCriterion("BIND_OTO_NUM between", value1, value2, "bindOtoNum");
            return (Criteria) this;
        }

        public Criteria andBindOtoNumNotBetween(Integer value1, Integer value2) {
            addCriterion("BIND_OTO_NUM not between", value1, value2, "bindOtoNum");
            return (Criteria) this;
        }

        public Criteria andBindOtoPriceIsNull() {
            addCriterion("BIND_OTO_PRICE is null");
            return (Criteria) this;
        }

        public Criteria andBindOtoPriceIsNotNull() {
            addCriterion("BIND_OTO_PRICE is not null");
            return (Criteria) this;
        }

        public Criteria andBindOtoPriceEqualTo(Integer value) {
            addCriterion("BIND_OTO_PRICE =", value, "bindOtoPrice");
            return (Criteria) this;
        }

        public Criteria andBindOtoPriceNotEqualTo(Integer value) {
            addCriterion("BIND_OTO_PRICE <>", value, "bindOtoPrice");
            return (Criteria) this;
        }

        public Criteria andBindOtoPriceGreaterThan(Integer value) {
            addCriterion("BIND_OTO_PRICE >", value, "bindOtoPrice");
            return (Criteria) this;
        }

        public Criteria andBindOtoPriceGreaterThanOrEqualTo(Integer value) {
            addCriterion("BIND_OTO_PRICE >=", value, "bindOtoPrice");
            return (Criteria) this;
        }

        public Criteria andBindOtoPriceLessThan(Integer value) {
            addCriterion("BIND_OTO_PRICE <", value, "bindOtoPrice");
            return (Criteria) this;
        }

        public Criteria andBindOtoPriceLessThanOrEqualTo(Integer value) {
            addCriterion("BIND_OTO_PRICE <=", value, "bindOtoPrice");
            return (Criteria) this;
        }

        public Criteria andBindOtoPriceIn(List<Integer> values) {
            addCriterion("BIND_OTO_PRICE in", values, "bindOtoPrice");
            return (Criteria) this;
        }

        public Criteria andBindOtoPriceNotIn(List<Integer> values) {
            addCriterion("BIND_OTO_PRICE not in", values, "bindOtoPrice");
            return (Criteria) this;
        }

        public Criteria andBindOtoPriceBetween(Integer value1, Integer value2) {
            addCriterion("BIND_OTO_PRICE between", value1, value2, "bindOtoPrice");
            return (Criteria) this;
        }

        public Criteria andBindOtoPriceNotBetween(Integer value1, Integer value2) {
            addCriterion("BIND_OTO_PRICE not between", value1, value2, "bindOtoPrice");
            return (Criteria) this;
        }

        public Criteria andServiceStartTimeIsNull() {
            addCriterion("SERVICE_START_TIME is null");
            return (Criteria) this;
        }

        public Criteria andServiceStartTimeIsNotNull() {
            addCriterion("SERVICE_START_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andServiceStartTimeEqualTo(Date value) {
            addCriterion("SERVICE_START_TIME =", value, "serviceStartTime");
            return (Criteria) this;
        }

        public Criteria andServiceStartTimeNotEqualTo(Date value) {
            addCriterion("SERVICE_START_TIME <>", value, "serviceStartTime");
            return (Criteria) this;
        }

        public Criteria andServiceStartTimeGreaterThan(Date value) {
            addCriterion("SERVICE_START_TIME >", value, "serviceStartTime");
            return (Criteria) this;
        }

        public Criteria andServiceStartTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("SERVICE_START_TIME >=", value, "serviceStartTime");
            return (Criteria) this;
        }

        public Criteria andServiceStartTimeLessThan(Date value) {
            addCriterion("SERVICE_START_TIME <", value, "serviceStartTime");
            return (Criteria) this;
        }

        public Criteria andServiceStartTimeLessThanOrEqualTo(Date value) {
            addCriterion("SERVICE_START_TIME <=", value, "serviceStartTime");
            return (Criteria) this;
        }

        public Criteria andServiceStartTimeIn(List<Date> values) {
            addCriterion("SERVICE_START_TIME in", values, "serviceStartTime");
            return (Criteria) this;
        }

        public Criteria andServiceStartTimeNotIn(List<Date> values) {
            addCriterion("SERVICE_START_TIME not in", values, "serviceStartTime");
            return (Criteria) this;
        }

        public Criteria andServiceStartTimeBetween(Date value1, Date value2) {
            addCriterion("SERVICE_START_TIME between", value1, value2, "serviceStartTime");
            return (Criteria) this;
        }

        public Criteria andServiceStartTimeNotBetween(Date value1, Date value2) {
            addCriterion("SERVICE_START_TIME not between", value1, value2, "serviceStartTime");
            return (Criteria) this;
        }

        public Criteria andServiceEndTimeIsNull() {
            addCriterion("SERVICE_END_TIME is null");
            return (Criteria) this;
        }

        public Criteria andServiceEndTimeIsNotNull() {
            addCriterion("SERVICE_END_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andServiceEndTimeEqualTo(Date value) {
            addCriterion("SERVICE_END_TIME =", value, "serviceEndTime");
            return (Criteria) this;
        }

        public Criteria andServiceEndTimeNotEqualTo(Date value) {
            addCriterion("SERVICE_END_TIME <>", value, "serviceEndTime");
            return (Criteria) this;
        }

        public Criteria andServiceEndTimeGreaterThan(Date value) {
            addCriterion("SERVICE_END_TIME >", value, "serviceEndTime");
            return (Criteria) this;
        }

        public Criteria andServiceEndTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("SERVICE_END_TIME >=", value, "serviceEndTime");
            return (Criteria) this;
        }

        public Criteria andServiceEndTimeLessThan(Date value) {
            addCriterion("SERVICE_END_TIME <", value, "serviceEndTime");
            return (Criteria) this;
        }

        public Criteria andServiceEndTimeLessThanOrEqualTo(Date value) {
            addCriterion("SERVICE_END_TIME <=", value, "serviceEndTime");
            return (Criteria) this;
        }

        public Criteria andServiceEndTimeIn(List<Date> values) {
            addCriterion("SERVICE_END_TIME in", values, "serviceEndTime");
            return (Criteria) this;
        }

        public Criteria andServiceEndTimeNotIn(List<Date> values) {
            addCriterion("SERVICE_END_TIME not in", values, "serviceEndTime");
            return (Criteria) this;
        }

        public Criteria andServiceEndTimeBetween(Date value1, Date value2) {
            addCriterion("SERVICE_END_TIME between", value1, value2, "serviceEndTime");
            return (Criteria) this;
        }

        public Criteria andServiceEndTimeNotBetween(Date value1, Date value2) {
            addCriterion("SERVICE_END_TIME not between", value1, value2, "serviceEndTime");
            return (Criteria) this;
        }

        public Criteria andSubPtTypeIsNull() {
            addCriterion("SUB_PT_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andSubPtTypeIsNotNull() {
            addCriterion("SUB_PT_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andSubPtTypeEqualTo(String value) {
            addCriterion("SUB_PT_TYPE =", value, "subPtType");
            return (Criteria) this;
        }

        public Criteria andSubPtTypeNotEqualTo(String value) {
            addCriterion("SUB_PT_TYPE <>", value, "subPtType");
            return (Criteria) this;
        }

        public Criteria andSubPtTypeGreaterThan(String value) {
            addCriterion("SUB_PT_TYPE >", value, "subPtType");
            return (Criteria) this;
        }

        public Criteria andSubPtTypeGreaterThanOrEqualTo(String value) {
            addCriterion("SUB_PT_TYPE >=", value, "subPtType");
            return (Criteria) this;
        }

        public Criteria andSubPtTypeLessThan(String value) {
            addCriterion("SUB_PT_TYPE <", value, "subPtType");
            return (Criteria) this;
        }

        public Criteria andSubPtTypeLessThanOrEqualTo(String value) {
            addCriterion("SUB_PT_TYPE <=", value, "subPtType");
            return (Criteria) this;
        }

        public Criteria andSubPtTypeLike(String value) {
            addCriterion("SUB_PT_TYPE like", value, "subPtType");
            return (Criteria) this;
        }

        public Criteria andSubPtTypeNotLike(String value) {
            addCriterion("SUB_PT_TYPE not like", value, "subPtType");
            return (Criteria) this;
        }

        public Criteria andSubPtTypeIn(List<String> values) {
            addCriterion("SUB_PT_TYPE in", values, "subPtType");
            return (Criteria) this;
        }

        public Criteria andSubPtTypeNotIn(List<String> values) {
            addCriterion("SUB_PT_TYPE not in", values, "subPtType");
            return (Criteria) this;
        }

        public Criteria andSubPtTypeBetween(String value1, String value2) {
            addCriterion("SUB_PT_TYPE between", value1, value2, "subPtType");
            return (Criteria) this;
        }

        public Criteria andSubPtTypeNotBetween(String value1, String value2) {
            addCriterion("SUB_PT_TYPE not between", value1, value2, "subPtType");
            return (Criteria) this;
        }

        public Criteria andSharePriceIsNull() {
            addCriterion("SHARE_PRICE is null");
            return (Criteria) this;
        }

        public Criteria andSharePriceIsNotNull() {
            addCriterion("SHARE_PRICE is not null");
            return (Criteria) this;
        }

        public Criteria andSharePriceEqualTo(BigDecimal value) {
            addCriterion("SHARE_PRICE =", value, "sharePrice");
            return (Criteria) this;
        }

        public Criteria andSharePriceNotEqualTo(BigDecimal value) {
            addCriterion("SHARE_PRICE <>", value, "sharePrice");
            return (Criteria) this;
        }

        public Criteria andSharePriceGreaterThan(BigDecimal value) {
            addCriterion("SHARE_PRICE >", value, "sharePrice");
            return (Criteria) this;
        }

        public Criteria andSharePriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("SHARE_PRICE >=", value, "sharePrice");
            return (Criteria) this;
        }

        public Criteria andSharePriceLessThan(BigDecimal value) {
            addCriterion("SHARE_PRICE <", value, "sharePrice");
            return (Criteria) this;
        }

        public Criteria andSharePriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("SHARE_PRICE <=", value, "sharePrice");
            return (Criteria) this;
        }

        public Criteria andSharePriceIn(List<BigDecimal> values) {
            addCriterion("SHARE_PRICE in", values, "sharePrice");
            return (Criteria) this;
        }

        public Criteria andSharePriceNotIn(List<BigDecimal> values) {
            addCriterion("SHARE_PRICE not in", values, "sharePrice");
            return (Criteria) this;
        }

        public Criteria andSharePriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("SHARE_PRICE between", value1, value2, "sharePrice");
            return (Criteria) this;
        }

        public Criteria andSharePriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("SHARE_PRICE not between", value1, value2, "sharePrice");
            return (Criteria) this;
        }

        public Criteria andBrokerArchiveIdIsNull() {
            addCriterion("BROKER_ARCHIVE_ID is null");
            return (Criteria) this;
        }

        public Criteria andBrokerArchiveIdIsNotNull() {
            addCriterion("BROKER_ARCHIVE_ID is not null");
            return (Criteria) this;
        }

        public Criteria andBrokerArchiveIdEqualTo(Integer value) {
            addCriterion("BROKER_ARCHIVE_ID =", value, "brokerArchiveId");
            return (Criteria) this;
        }

        public Criteria andBrokerArchiveIdNotEqualTo(Integer value) {
            addCriterion("BROKER_ARCHIVE_ID <>", value, "brokerArchiveId");
            return (Criteria) this;
        }

        public Criteria andBrokerArchiveIdGreaterThan(Integer value) {
            addCriterion("BROKER_ARCHIVE_ID >", value, "brokerArchiveId");
            return (Criteria) this;
        }

        public Criteria andBrokerArchiveIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("BROKER_ARCHIVE_ID >=", value, "brokerArchiveId");
            return (Criteria) this;
        }

        public Criteria andBrokerArchiveIdLessThan(Integer value) {
            addCriterion("BROKER_ARCHIVE_ID <", value, "brokerArchiveId");
            return (Criteria) this;
        }

        public Criteria andBrokerArchiveIdLessThanOrEqualTo(Integer value) {
            addCriterion("BROKER_ARCHIVE_ID <=", value, "brokerArchiveId");
            return (Criteria) this;
        }

        public Criteria andBrokerArchiveIdIn(List<Integer> values) {
            addCriterion("BROKER_ARCHIVE_ID in", values, "brokerArchiveId");
            return (Criteria) this;
        }

        public Criteria andBrokerArchiveIdNotIn(List<Integer> values) {
            addCriterion("BROKER_ARCHIVE_ID not in", values, "brokerArchiveId");
            return (Criteria) this;
        }

        public Criteria andBrokerArchiveIdBetween(Integer value1, Integer value2) {
            addCriterion("BROKER_ARCHIVE_ID between", value1, value2, "brokerArchiveId");
            return (Criteria) this;
        }

        public Criteria andBrokerArchiveIdNotBetween(Integer value1, Integer value2) {
            addCriterion("BROKER_ARCHIVE_ID not between", value1, value2, "brokerArchiveId");
            return (Criteria) this;
        }

        public Criteria andGiftWskNumIsNull() {
            addCriterion("GIFT_WSK_NUM is null");
            return (Criteria) this;
        }

        public Criteria andGiftWskNumIsNotNull() {
            addCriterion("GIFT_WSK_NUM is not null");
            return (Criteria) this;
        }

        public Criteria andGiftWskNumEqualTo(Double value) {
            addCriterion("GIFT_WSK_NUM =", value, "giftWskNum");
            return (Criteria) this;
        }

        public Criteria andGiftWskNumNotEqualTo(Double value) {
            addCriterion("GIFT_WSK_NUM <>", value, "giftWskNum");
            return (Criteria) this;
        }

        public Criteria andGiftWskNumGreaterThan(Double value) {
            addCriterion("GIFT_WSK_NUM >", value, "giftWskNum");
            return (Criteria) this;
        }

        public Criteria andGiftWskNumGreaterThanOrEqualTo(Double value) {
            addCriterion("GIFT_WSK_NUM >=", value, "giftWskNum");
            return (Criteria) this;
        }

        public Criteria andGiftWskNumLessThan(Double value) {
            addCriterion("GIFT_WSK_NUM <", value, "giftWskNum");
            return (Criteria) this;
        }

        public Criteria andGiftWskNumLessThanOrEqualTo(Double value) {
            addCriterion("GIFT_WSK_NUM <=", value, "giftWskNum");
            return (Criteria) this;
        }

        public Criteria andGiftWskNumIn(List<Double> values) {
            addCriterion("GIFT_WSK_NUM in", values, "giftWskNum");
            return (Criteria) this;
        }

        public Criteria andGiftWskNumNotIn(List<Double> values) {
            addCriterion("GIFT_WSK_NUM not in", values, "giftWskNum");
            return (Criteria) this;
        }

        public Criteria andGiftWskNumBetween(Double value1, Double value2) {
            addCriterion("GIFT_WSK_NUM between", value1, value2, "giftWskNum");
            return (Criteria) this;
        }

        public Criteria andGiftWskNumNotBetween(Double value1, Double value2) {
            addCriterion("GIFT_WSK_NUM not between", value1, value2, "giftWskNum");
            return (Criteria) this;
        }

        public Criteria andCompAccountMoneyIsNull() {
            addCriterion("COMP_ACCOUNT_MONEY is null");
            return (Criteria) this;
        }

        public Criteria andCompAccountMoneyIsNotNull() {
            addCriterion("COMP_ACCOUNT_MONEY is not null");
            return (Criteria) this;
        }

        public Criteria andCompAccountMoneyEqualTo(BigDecimal value) {
            addCriterion("COMP_ACCOUNT_MONEY =", value, "compAccountMoney");
            return (Criteria) this;
        }

        public Criteria andCompAccountMoneyNotEqualTo(BigDecimal value) {
            addCriterion("COMP_ACCOUNT_MONEY <>", value, "compAccountMoney");
            return (Criteria) this;
        }

        public Criteria andCompAccountMoneyGreaterThan(BigDecimal value) {
            addCriterion("COMP_ACCOUNT_MONEY >", value, "compAccountMoney");
            return (Criteria) this;
        }

        public Criteria andCompAccountMoneyGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("COMP_ACCOUNT_MONEY >=", value, "compAccountMoney");
            return (Criteria) this;
        }

        public Criteria andCompAccountMoneyLessThan(BigDecimal value) {
            addCriterion("COMP_ACCOUNT_MONEY <", value, "compAccountMoney");
            return (Criteria) this;
        }

        public Criteria andCompAccountMoneyLessThanOrEqualTo(BigDecimal value) {
            addCriterion("COMP_ACCOUNT_MONEY <=", value, "compAccountMoney");
            return (Criteria) this;
        }

        public Criteria andCompAccountMoneyIn(List<BigDecimal> values) {
            addCriterion("COMP_ACCOUNT_MONEY in", values, "compAccountMoney");
            return (Criteria) this;
        }

        public Criteria andCompAccountMoneyNotIn(List<BigDecimal> values) {
            addCriterion("COMP_ACCOUNT_MONEY not in", values, "compAccountMoney");
            return (Criteria) this;
        }

        public Criteria andCompAccountMoneyBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("COMP_ACCOUNT_MONEY between", value1, value2, "compAccountMoney");
            return (Criteria) this;
        }

        public Criteria andCompAccountMoneyNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("COMP_ACCOUNT_MONEY not between", value1, value2, "compAccountMoney");
            return (Criteria) this;
        }

        public Criteria andCompUaIdIsNull() {
            addCriterion("COMP_UA_ID is null");
            return (Criteria) this;
        }

        public Criteria andCompUaIdIsNotNull() {
            addCriterion("COMP_UA_ID is not null");
            return (Criteria) this;
        }

        public Criteria andCompUaIdEqualTo(Integer value) {
            addCriterion("COMP_UA_ID =", value, "compUaId");
            return (Criteria) this;
        }

        public Criteria andCompUaIdNotEqualTo(Integer value) {
            addCriterion("COMP_UA_ID <>", value, "compUaId");
            return (Criteria) this;
        }

        public Criteria andCompUaIdGreaterThan(Integer value) {
            addCriterion("COMP_UA_ID >", value, "compUaId");
            return (Criteria) this;
        }

        public Criteria andCompUaIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("COMP_UA_ID >=", value, "compUaId");
            return (Criteria) this;
        }

        public Criteria andCompUaIdLessThan(Integer value) {
            addCriterion("COMP_UA_ID <", value, "compUaId");
            return (Criteria) this;
        }

        public Criteria andCompUaIdLessThanOrEqualTo(Integer value) {
            addCriterion("COMP_UA_ID <=", value, "compUaId");
            return (Criteria) this;
        }

        public Criteria andCompUaIdIn(List<Integer> values) {
            addCriterion("COMP_UA_ID in", values, "compUaId");
            return (Criteria) this;
        }

        public Criteria andCompUaIdNotIn(List<Integer> values) {
            addCriterion("COMP_UA_ID not in", values, "compUaId");
            return (Criteria) this;
        }

        public Criteria andCompUaIdBetween(Integer value1, Integer value2) {
            addCriterion("COMP_UA_ID between", value1, value2, "compUaId");
            return (Criteria) this;
        }

        public Criteria andCompUaIdNotBetween(Integer value1, Integer value2) {
            addCriterion("COMP_UA_ID not between", value1, value2, "compUaId");
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