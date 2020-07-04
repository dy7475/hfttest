package com.myfun.repository.admindb.po;

import java.util.ArrayList;
import java.util.List;

public class AdminFunUsersCountExample {
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
    public AdminFunUsersCountExample() {
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

        public Criteria andUserSaleScoreIsNull() {
            addCriterion("USER_SALE_SCORE is null");
            return (Criteria) this;
        }

        public Criteria andUserSaleScoreIsNotNull() {
            addCriterion("USER_SALE_SCORE is not null");
            return (Criteria) this;
        }

        public Criteria andUserSaleScoreEqualTo(Double value) {
            addCriterion("USER_SALE_SCORE =", value, "userSaleScore");
            return (Criteria) this;
        }

        public Criteria andUserSaleScoreNotEqualTo(Double value) {
            addCriterion("USER_SALE_SCORE <>", value, "userSaleScore");
            return (Criteria) this;
        }

        public Criteria andUserSaleScoreGreaterThan(Double value) {
            addCriterion("USER_SALE_SCORE >", value, "userSaleScore");
            return (Criteria) this;
        }

        public Criteria andUserSaleScoreGreaterThanOrEqualTo(Double value) {
            addCriterion("USER_SALE_SCORE >=", value, "userSaleScore");
            return (Criteria) this;
        }

        public Criteria andUserSaleScoreLessThan(Double value) {
            addCriterion("USER_SALE_SCORE <", value, "userSaleScore");
            return (Criteria) this;
        }

        public Criteria andUserSaleScoreLessThanOrEqualTo(Double value) {
            addCriterion("USER_SALE_SCORE <=", value, "userSaleScore");
            return (Criteria) this;
        }

        public Criteria andUserSaleScoreIn(List<Double> values) {
            addCriterion("USER_SALE_SCORE in", values, "userSaleScore");
            return (Criteria) this;
        }

        public Criteria andUserSaleScoreNotIn(List<Double> values) {
            addCriterion("USER_SALE_SCORE not in", values, "userSaleScore");
            return (Criteria) this;
        }

        public Criteria andUserSaleScoreBetween(Double value1, Double value2) {
            addCriterion("USER_SALE_SCORE between", value1, value2, "userSaleScore");
            return (Criteria) this;
        }

        public Criteria andUserSaleScoreNotBetween(Double value1, Double value2) {
            addCriterion("USER_SALE_SCORE not between", value1, value2, "userSaleScore");
            return (Criteria) this;
        }

        public Criteria andUserSalePerIsNull() {
            addCriterion("USER_SALE_PER is null");
            return (Criteria) this;
        }

        public Criteria andUserSalePerIsNotNull() {
            addCriterion("USER_SALE_PER is not null");
            return (Criteria) this;
        }

        public Criteria andUserSalePerEqualTo(Double value) {
            addCriterion("USER_SALE_PER =", value, "userSalePer");
            return (Criteria) this;
        }

        public Criteria andUserSalePerNotEqualTo(Double value) {
            addCriterion("USER_SALE_PER <>", value, "userSalePer");
            return (Criteria) this;
        }

        public Criteria andUserSalePerGreaterThan(Double value) {
            addCriterion("USER_SALE_PER >", value, "userSalePer");
            return (Criteria) this;
        }

        public Criteria andUserSalePerGreaterThanOrEqualTo(Double value) {
            addCriterion("USER_SALE_PER >=", value, "userSalePer");
            return (Criteria) this;
        }

        public Criteria andUserSalePerLessThan(Double value) {
            addCriterion("USER_SALE_PER <", value, "userSalePer");
            return (Criteria) this;
        }

        public Criteria andUserSalePerLessThanOrEqualTo(Double value) {
            addCriterion("USER_SALE_PER <=", value, "userSalePer");
            return (Criteria) this;
        }

        public Criteria andUserSalePerIn(List<Double> values) {
            addCriterion("USER_SALE_PER in", values, "userSalePer");
            return (Criteria) this;
        }

        public Criteria andUserSalePerNotIn(List<Double> values) {
            addCriterion("USER_SALE_PER not in", values, "userSalePer");
            return (Criteria) this;
        }

        public Criteria andUserSalePerBetween(Double value1, Double value2) {
            addCriterion("USER_SALE_PER between", value1, value2, "userSalePer");
            return (Criteria) this;
        }

        public Criteria andUserSalePerNotBetween(Double value1, Double value2) {
            addCriterion("USER_SALE_PER not between", value1, value2, "userSalePer");
            return (Criteria) this;
        }

        public Criteria andUserLeaseScoreIsNull() {
            addCriterion("USER_LEASE_SCORE is null");
            return (Criteria) this;
        }

        public Criteria andUserLeaseScoreIsNotNull() {
            addCriterion("USER_LEASE_SCORE is not null");
            return (Criteria) this;
        }

        public Criteria andUserLeaseScoreEqualTo(Double value) {
            addCriterion("USER_LEASE_SCORE =", value, "userLeaseScore");
            return (Criteria) this;
        }

        public Criteria andUserLeaseScoreNotEqualTo(Double value) {
            addCriterion("USER_LEASE_SCORE <>", value, "userLeaseScore");
            return (Criteria) this;
        }

        public Criteria andUserLeaseScoreGreaterThan(Double value) {
            addCriterion("USER_LEASE_SCORE >", value, "userLeaseScore");
            return (Criteria) this;
        }

        public Criteria andUserLeaseScoreGreaterThanOrEqualTo(Double value) {
            addCriterion("USER_LEASE_SCORE >=", value, "userLeaseScore");
            return (Criteria) this;
        }

        public Criteria andUserLeaseScoreLessThan(Double value) {
            addCriterion("USER_LEASE_SCORE <", value, "userLeaseScore");
            return (Criteria) this;
        }

        public Criteria andUserLeaseScoreLessThanOrEqualTo(Double value) {
            addCriterion("USER_LEASE_SCORE <=", value, "userLeaseScore");
            return (Criteria) this;
        }

        public Criteria andUserLeaseScoreIn(List<Double> values) {
            addCriterion("USER_LEASE_SCORE in", values, "userLeaseScore");
            return (Criteria) this;
        }

        public Criteria andUserLeaseScoreNotIn(List<Double> values) {
            addCriterion("USER_LEASE_SCORE not in", values, "userLeaseScore");
            return (Criteria) this;
        }

        public Criteria andUserLeaseScoreBetween(Double value1, Double value2) {
            addCriterion("USER_LEASE_SCORE between", value1, value2, "userLeaseScore");
            return (Criteria) this;
        }

        public Criteria andUserLeaseScoreNotBetween(Double value1, Double value2) {
            addCriterion("USER_LEASE_SCORE not between", value1, value2, "userLeaseScore");
            return (Criteria) this;
        }

        public Criteria andUserLeasePerIsNull() {
            addCriterion("USER_LEASE_PER is null");
            return (Criteria) this;
        }

        public Criteria andUserLeasePerIsNotNull() {
            addCriterion("USER_LEASE_PER is not null");
            return (Criteria) this;
        }

        public Criteria andUserLeasePerEqualTo(Double value) {
            addCriterion("USER_LEASE_PER =", value, "userLeasePer");
            return (Criteria) this;
        }

        public Criteria andUserLeasePerNotEqualTo(Double value) {
            addCriterion("USER_LEASE_PER <>", value, "userLeasePer");
            return (Criteria) this;
        }

        public Criteria andUserLeasePerGreaterThan(Double value) {
            addCriterion("USER_LEASE_PER >", value, "userLeasePer");
            return (Criteria) this;
        }

        public Criteria andUserLeasePerGreaterThanOrEqualTo(Double value) {
            addCriterion("USER_LEASE_PER >=", value, "userLeasePer");
            return (Criteria) this;
        }

        public Criteria andUserLeasePerLessThan(Double value) {
            addCriterion("USER_LEASE_PER <", value, "userLeasePer");
            return (Criteria) this;
        }

        public Criteria andUserLeasePerLessThanOrEqualTo(Double value) {
            addCriterion("USER_LEASE_PER <=", value, "userLeasePer");
            return (Criteria) this;
        }

        public Criteria andUserLeasePerIn(List<Double> values) {
            addCriterion("USER_LEASE_PER in", values, "userLeasePer");
            return (Criteria) this;
        }

        public Criteria andUserLeasePerNotIn(List<Double> values) {
            addCriterion("USER_LEASE_PER not in", values, "userLeasePer");
            return (Criteria) this;
        }

        public Criteria andUserLeasePerBetween(Double value1, Double value2) {
            addCriterion("USER_LEASE_PER between", value1, value2, "userLeasePer");
            return (Criteria) this;
        }

        public Criteria andUserLeasePerNotBetween(Double value1, Double value2) {
            addCriterion("USER_LEASE_PER not between", value1, value2, "userLeasePer");
            return (Criteria) this;
        }

        public Criteria andUserUinfoScoreIsNull() {
            addCriterion("USER_UINFO_SCORE is null");
            return (Criteria) this;
        }

        public Criteria andUserUinfoScoreIsNotNull() {
            addCriterion("USER_UINFO_SCORE is not null");
            return (Criteria) this;
        }

        public Criteria andUserUinfoScoreEqualTo(Double value) {
            addCriterion("USER_UINFO_SCORE =", value, "userUinfoScore");
            return (Criteria) this;
        }

        public Criteria andUserUinfoScoreNotEqualTo(Double value) {
            addCriterion("USER_UINFO_SCORE <>", value, "userUinfoScore");
            return (Criteria) this;
        }

        public Criteria andUserUinfoScoreGreaterThan(Double value) {
            addCriterion("USER_UINFO_SCORE >", value, "userUinfoScore");
            return (Criteria) this;
        }

        public Criteria andUserUinfoScoreGreaterThanOrEqualTo(Double value) {
            addCriterion("USER_UINFO_SCORE >=", value, "userUinfoScore");
            return (Criteria) this;
        }

        public Criteria andUserUinfoScoreLessThan(Double value) {
            addCriterion("USER_UINFO_SCORE <", value, "userUinfoScore");
            return (Criteria) this;
        }

        public Criteria andUserUinfoScoreLessThanOrEqualTo(Double value) {
            addCriterion("USER_UINFO_SCORE <=", value, "userUinfoScore");
            return (Criteria) this;
        }

        public Criteria andUserUinfoScoreIn(List<Double> values) {
            addCriterion("USER_UINFO_SCORE in", values, "userUinfoScore");
            return (Criteria) this;
        }

        public Criteria andUserUinfoScoreNotIn(List<Double> values) {
            addCriterion("USER_UINFO_SCORE not in", values, "userUinfoScore");
            return (Criteria) this;
        }

        public Criteria andUserUinfoScoreBetween(Double value1, Double value2) {
            addCriterion("USER_UINFO_SCORE between", value1, value2, "userUinfoScore");
            return (Criteria) this;
        }

        public Criteria andUserUinfoScoreNotBetween(Double value1, Double value2) {
            addCriterion("USER_UINFO_SCORE not between", value1, value2, "userUinfoScore");
            return (Criteria) this;
        }

        public Criteria andUserPaidScoreIsNull() {
            addCriterion("USER_PAID_SCORE is null");
            return (Criteria) this;
        }

        public Criteria andUserPaidScoreIsNotNull() {
            addCriterion("USER_PAID_SCORE is not null");
            return (Criteria) this;
        }

        public Criteria andUserPaidScoreEqualTo(Double value) {
            addCriterion("USER_PAID_SCORE =", value, "userPaidScore");
            return (Criteria) this;
        }

        public Criteria andUserPaidScoreNotEqualTo(Double value) {
            addCriterion("USER_PAID_SCORE <>", value, "userPaidScore");
            return (Criteria) this;
        }

        public Criteria andUserPaidScoreGreaterThan(Double value) {
            addCriterion("USER_PAID_SCORE >", value, "userPaidScore");
            return (Criteria) this;
        }

        public Criteria andUserPaidScoreGreaterThanOrEqualTo(Double value) {
            addCriterion("USER_PAID_SCORE >=", value, "userPaidScore");
            return (Criteria) this;
        }

        public Criteria andUserPaidScoreLessThan(Double value) {
            addCriterion("USER_PAID_SCORE <", value, "userPaidScore");
            return (Criteria) this;
        }

        public Criteria andUserPaidScoreLessThanOrEqualTo(Double value) {
            addCriterion("USER_PAID_SCORE <=", value, "userPaidScore");
            return (Criteria) this;
        }

        public Criteria andUserPaidScoreIn(List<Double> values) {
            addCriterion("USER_PAID_SCORE in", values, "userPaidScore");
            return (Criteria) this;
        }

        public Criteria andUserPaidScoreNotIn(List<Double> values) {
            addCriterion("USER_PAID_SCORE not in", values, "userPaidScore");
            return (Criteria) this;
        }

        public Criteria andUserPaidScoreBetween(Double value1, Double value2) {
            addCriterion("USER_PAID_SCORE between", value1, value2, "userPaidScore");
            return (Criteria) this;
        }

        public Criteria andUserPaidScoreNotBetween(Double value1, Double value2) {
            addCriterion("USER_PAID_SCORE not between", value1, value2, "userPaidScore");
            return (Criteria) this;
        }

        public Criteria andUserPubScoreIsNull() {
            addCriterion("USER_PUB_SCORE is null");
            return (Criteria) this;
        }

        public Criteria andUserPubScoreIsNotNull() {
            addCriterion("USER_PUB_SCORE is not null");
            return (Criteria) this;
        }

        public Criteria andUserPubScoreEqualTo(Double value) {
            addCriterion("USER_PUB_SCORE =", value, "userPubScore");
            return (Criteria) this;
        }

        public Criteria andUserPubScoreNotEqualTo(Double value) {
            addCriterion("USER_PUB_SCORE <>", value, "userPubScore");
            return (Criteria) this;
        }

        public Criteria andUserPubScoreGreaterThan(Double value) {
            addCriterion("USER_PUB_SCORE >", value, "userPubScore");
            return (Criteria) this;
        }

        public Criteria andUserPubScoreGreaterThanOrEqualTo(Double value) {
            addCriterion("USER_PUB_SCORE >=", value, "userPubScore");
            return (Criteria) this;
        }

        public Criteria andUserPubScoreLessThan(Double value) {
            addCriterion("USER_PUB_SCORE <", value, "userPubScore");
            return (Criteria) this;
        }

        public Criteria andUserPubScoreLessThanOrEqualTo(Double value) {
            addCriterion("USER_PUB_SCORE <=", value, "userPubScore");
            return (Criteria) this;
        }

        public Criteria andUserPubScoreIn(List<Double> values) {
            addCriterion("USER_PUB_SCORE in", values, "userPubScore");
            return (Criteria) this;
        }

        public Criteria andUserPubScoreNotIn(List<Double> values) {
            addCriterion("USER_PUB_SCORE not in", values, "userPubScore");
            return (Criteria) this;
        }

        public Criteria andUserPubScoreBetween(Double value1, Double value2) {
            addCriterion("USER_PUB_SCORE between", value1, value2, "userPubScore");
            return (Criteria) this;
        }

        public Criteria andUserPubScoreNotBetween(Double value1, Double value2) {
            addCriterion("USER_PUB_SCORE not between", value1, value2, "userPubScore");
            return (Criteria) this;
        }

        public Criteria andUserUinfoPerIsNull() {
            addCriterion("USER_UINFO_PER is null");
            return (Criteria) this;
        }

        public Criteria andUserUinfoPerIsNotNull() {
            addCriterion("USER_UINFO_PER is not null");
            return (Criteria) this;
        }

        public Criteria andUserUinfoPerEqualTo(Double value) {
            addCriterion("USER_UINFO_PER =", value, "userUinfoPer");
            return (Criteria) this;
        }

        public Criteria andUserUinfoPerNotEqualTo(Double value) {
            addCriterion("USER_UINFO_PER <>", value, "userUinfoPer");
            return (Criteria) this;
        }

        public Criteria andUserUinfoPerGreaterThan(Double value) {
            addCriterion("USER_UINFO_PER >", value, "userUinfoPer");
            return (Criteria) this;
        }

        public Criteria andUserUinfoPerGreaterThanOrEqualTo(Double value) {
            addCriterion("USER_UINFO_PER >=", value, "userUinfoPer");
            return (Criteria) this;
        }

        public Criteria andUserUinfoPerLessThan(Double value) {
            addCriterion("USER_UINFO_PER <", value, "userUinfoPer");
            return (Criteria) this;
        }

        public Criteria andUserUinfoPerLessThanOrEqualTo(Double value) {
            addCriterion("USER_UINFO_PER <=", value, "userUinfoPer");
            return (Criteria) this;
        }

        public Criteria andUserUinfoPerIn(List<Double> values) {
            addCriterion("USER_UINFO_PER in", values, "userUinfoPer");
            return (Criteria) this;
        }

        public Criteria andUserUinfoPerNotIn(List<Double> values) {
            addCriterion("USER_UINFO_PER not in", values, "userUinfoPer");
            return (Criteria) this;
        }

        public Criteria andUserUinfoPerBetween(Double value1, Double value2) {
            addCriterion("USER_UINFO_PER between", value1, value2, "userUinfoPer");
            return (Criteria) this;
        }

        public Criteria andUserUinfoPerNotBetween(Double value1, Double value2) {
            addCriterion("USER_UINFO_PER not between", value1, value2, "userUinfoPer");
            return (Criteria) this;
        }

        public Criteria andUserPaidPerIsNull() {
            addCriterion("USER_PAID_PER is null");
            return (Criteria) this;
        }

        public Criteria andUserPaidPerIsNotNull() {
            addCriterion("USER_PAID_PER is not null");
            return (Criteria) this;
        }

        public Criteria andUserPaidPerEqualTo(Double value) {
            addCriterion("USER_PAID_PER =", value, "userPaidPer");
            return (Criteria) this;
        }

        public Criteria andUserPaidPerNotEqualTo(Double value) {
            addCriterion("USER_PAID_PER <>", value, "userPaidPer");
            return (Criteria) this;
        }

        public Criteria andUserPaidPerGreaterThan(Double value) {
            addCriterion("USER_PAID_PER >", value, "userPaidPer");
            return (Criteria) this;
        }

        public Criteria andUserPaidPerGreaterThanOrEqualTo(Double value) {
            addCriterion("USER_PAID_PER >=", value, "userPaidPer");
            return (Criteria) this;
        }

        public Criteria andUserPaidPerLessThan(Double value) {
            addCriterion("USER_PAID_PER <", value, "userPaidPer");
            return (Criteria) this;
        }

        public Criteria andUserPaidPerLessThanOrEqualTo(Double value) {
            addCriterion("USER_PAID_PER <=", value, "userPaidPer");
            return (Criteria) this;
        }

        public Criteria andUserPaidPerIn(List<Double> values) {
            addCriterion("USER_PAID_PER in", values, "userPaidPer");
            return (Criteria) this;
        }

        public Criteria andUserPaidPerNotIn(List<Double> values) {
            addCriterion("USER_PAID_PER not in", values, "userPaidPer");
            return (Criteria) this;
        }

        public Criteria andUserPaidPerBetween(Double value1, Double value2) {
            addCriterion("USER_PAID_PER between", value1, value2, "userPaidPer");
            return (Criteria) this;
        }

        public Criteria andUserPaidPerNotBetween(Double value1, Double value2) {
            addCriterion("USER_PAID_PER not between", value1, value2, "userPaidPer");
            return (Criteria) this;
        }

        public Criteria andUserPubPerIsNull() {
            addCriterion("USER_PUB_PER is null");
            return (Criteria) this;
        }

        public Criteria andUserPubPerIsNotNull() {
            addCriterion("USER_PUB_PER is not null");
            return (Criteria) this;
        }

        public Criteria andUserPubPerEqualTo(Double value) {
            addCriterion("USER_PUB_PER =", value, "userPubPer");
            return (Criteria) this;
        }

        public Criteria andUserPubPerNotEqualTo(Double value) {
            addCriterion("USER_PUB_PER <>", value, "userPubPer");
            return (Criteria) this;
        }

        public Criteria andUserPubPerGreaterThan(Double value) {
            addCriterion("USER_PUB_PER >", value, "userPubPer");
            return (Criteria) this;
        }

        public Criteria andUserPubPerGreaterThanOrEqualTo(Double value) {
            addCriterion("USER_PUB_PER >=", value, "userPubPer");
            return (Criteria) this;
        }

        public Criteria andUserPubPerLessThan(Double value) {
            addCriterion("USER_PUB_PER <", value, "userPubPer");
            return (Criteria) this;
        }

        public Criteria andUserPubPerLessThanOrEqualTo(Double value) {
            addCriterion("USER_PUB_PER <=", value, "userPubPer");
            return (Criteria) this;
        }

        public Criteria andUserPubPerIn(List<Double> values) {
            addCriterion("USER_PUB_PER in", values, "userPubPer");
            return (Criteria) this;
        }

        public Criteria andUserPubPerNotIn(List<Double> values) {
            addCriterion("USER_PUB_PER not in", values, "userPubPer");
            return (Criteria) this;
        }

        public Criteria andUserPubPerBetween(Double value1, Double value2) {
            addCriterion("USER_PUB_PER between", value1, value2, "userPubPer");
            return (Criteria) this;
        }

        public Criteria andUserPubPerNotBetween(Double value1, Double value2) {
            addCriterion("USER_PUB_PER not between", value1, value2, "userPubPer");
            return (Criteria) this;
        }

        public Criteria andSaleTotalIsNull() {
            addCriterion("SALE_TOTAL is null");
            return (Criteria) this;
        }

        public Criteria andSaleTotalIsNotNull() {
            addCriterion("SALE_TOTAL is not null");
            return (Criteria) this;
        }

        public Criteria andSaleTotalEqualTo(Integer value) {
            addCriterion("SALE_TOTAL =", value, "saleTotal");
            return (Criteria) this;
        }

        public Criteria andSaleTotalNotEqualTo(Integer value) {
            addCriterion("SALE_TOTAL <>", value, "saleTotal");
            return (Criteria) this;
        }

        public Criteria andSaleTotalGreaterThan(Integer value) {
            addCriterion("SALE_TOTAL >", value, "saleTotal");
            return (Criteria) this;
        }

        public Criteria andSaleTotalGreaterThanOrEqualTo(Integer value) {
            addCriterion("SALE_TOTAL >=", value, "saleTotal");
            return (Criteria) this;
        }

        public Criteria andSaleTotalLessThan(Integer value) {
            addCriterion("SALE_TOTAL <", value, "saleTotal");
            return (Criteria) this;
        }

        public Criteria andSaleTotalLessThanOrEqualTo(Integer value) {
            addCriterion("SALE_TOTAL <=", value, "saleTotal");
            return (Criteria) this;
        }

        public Criteria andSaleTotalIn(List<Integer> values) {
            addCriterion("SALE_TOTAL in", values, "saleTotal");
            return (Criteria) this;
        }

        public Criteria andSaleTotalNotIn(List<Integer> values) {
            addCriterion("SALE_TOTAL not in", values, "saleTotal");
            return (Criteria) this;
        }

        public Criteria andSaleTotalBetween(Integer value1, Integer value2) {
            addCriterion("SALE_TOTAL between", value1, value2, "saleTotal");
            return (Criteria) this;
        }

        public Criteria andSaleTotalNotBetween(Integer value1, Integer value2) {
            addCriterion("SALE_TOTAL not between", value1, value2, "saleTotal");
            return (Criteria) this;
        }

        public Criteria andLeaseTotalIsNull() {
            addCriterion("LEASE_TOTAL is null");
            return (Criteria) this;
        }

        public Criteria andLeaseTotalIsNotNull() {
            addCriterion("LEASE_TOTAL is not null");
            return (Criteria) this;
        }

        public Criteria andLeaseTotalEqualTo(Integer value) {
            addCriterion("LEASE_TOTAL =", value, "leaseTotal");
            return (Criteria) this;
        }

        public Criteria andLeaseTotalNotEqualTo(Integer value) {
            addCriterion("LEASE_TOTAL <>", value, "leaseTotal");
            return (Criteria) this;
        }

        public Criteria andLeaseTotalGreaterThan(Integer value) {
            addCriterion("LEASE_TOTAL >", value, "leaseTotal");
            return (Criteria) this;
        }

        public Criteria andLeaseTotalGreaterThanOrEqualTo(Integer value) {
            addCriterion("LEASE_TOTAL >=", value, "leaseTotal");
            return (Criteria) this;
        }

        public Criteria andLeaseTotalLessThan(Integer value) {
            addCriterion("LEASE_TOTAL <", value, "leaseTotal");
            return (Criteria) this;
        }

        public Criteria andLeaseTotalLessThanOrEqualTo(Integer value) {
            addCriterion("LEASE_TOTAL <=", value, "leaseTotal");
            return (Criteria) this;
        }

        public Criteria andLeaseTotalIn(List<Integer> values) {
            addCriterion("LEASE_TOTAL in", values, "leaseTotal");
            return (Criteria) this;
        }

        public Criteria andLeaseTotalNotIn(List<Integer> values) {
            addCriterion("LEASE_TOTAL not in", values, "leaseTotal");
            return (Criteria) this;
        }

        public Criteria andLeaseTotalBetween(Integer value1, Integer value2) {
            addCriterion("LEASE_TOTAL between", value1, value2, "leaseTotal");
            return (Criteria) this;
        }

        public Criteria andLeaseTotalNotBetween(Integer value1, Integer value2) {
            addCriterion("LEASE_TOTAL not between", value1, value2, "leaseTotal");
            return (Criteria) this;
        }

        public Criteria andWeidianLikeNumIsNull() {
            addCriterion("WEIDIAN_LIKE_NUM is null");
            return (Criteria) this;
        }

        public Criteria andWeidianLikeNumIsNotNull() {
            addCriterion("WEIDIAN_LIKE_NUM is not null");
            return (Criteria) this;
        }

        public Criteria andWeidianLikeNumEqualTo(Integer value) {
            addCriterion("WEIDIAN_LIKE_NUM =", value, "weidianLikeNum");
            return (Criteria) this;
        }

        public Criteria andWeidianLikeNumNotEqualTo(Integer value) {
            addCriterion("WEIDIAN_LIKE_NUM <>", value, "weidianLikeNum");
            return (Criteria) this;
        }

        public Criteria andWeidianLikeNumGreaterThan(Integer value) {
            addCriterion("WEIDIAN_LIKE_NUM >", value, "weidianLikeNum");
            return (Criteria) this;
        }

        public Criteria andWeidianLikeNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("WEIDIAN_LIKE_NUM >=", value, "weidianLikeNum");
            return (Criteria) this;
        }

        public Criteria andWeidianLikeNumLessThan(Integer value) {
            addCriterion("WEIDIAN_LIKE_NUM <", value, "weidianLikeNum");
            return (Criteria) this;
        }

        public Criteria andWeidianLikeNumLessThanOrEqualTo(Integer value) {
            addCriterion("WEIDIAN_LIKE_NUM <=", value, "weidianLikeNum");
            return (Criteria) this;
        }

        public Criteria andWeidianLikeNumIn(List<Integer> values) {
            addCriterion("WEIDIAN_LIKE_NUM in", values, "weidianLikeNum");
            return (Criteria) this;
        }

        public Criteria andWeidianLikeNumNotIn(List<Integer> values) {
            addCriterion("WEIDIAN_LIKE_NUM not in", values, "weidianLikeNum");
            return (Criteria) this;
        }

        public Criteria andWeidianLikeNumBetween(Integer value1, Integer value2) {
            addCriterion("WEIDIAN_LIKE_NUM between", value1, value2, "weidianLikeNum");
            return (Criteria) this;
        }

        public Criteria andWeidianLikeNumNotBetween(Integer value1, Integer value2) {
            addCriterion("WEIDIAN_LIKE_NUM not between", value1, value2, "weidianLikeNum");
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