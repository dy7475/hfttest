package com.myfun.repository.admindb.po;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AdminFunArchiveFastdfsExample {
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
    public AdminFunArchiveFastdfsExample() {
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

        public Criteria andIcPhoto1IsNull() {
            addCriterion("IC_PHOTO_1 is null");
            return (Criteria) this;
        }

        public Criteria andIcPhoto1IsNotNull() {
            addCriterion("IC_PHOTO_1 is not null");
            return (Criteria) this;
        }

        public Criteria andIcPhoto1EqualTo(String value) {
            addCriterion("IC_PHOTO_1 =", value, "icPhoto1");
            return (Criteria) this;
        }

        public Criteria andIcPhoto1NotEqualTo(String value) {
            addCriterion("IC_PHOTO_1 <>", value, "icPhoto1");
            return (Criteria) this;
        }

        public Criteria andIcPhoto1GreaterThan(String value) {
            addCriterion("IC_PHOTO_1 >", value, "icPhoto1");
            return (Criteria) this;
        }

        public Criteria andIcPhoto1GreaterThanOrEqualTo(String value) {
            addCriterion("IC_PHOTO_1 >=", value, "icPhoto1");
            return (Criteria) this;
        }

        public Criteria andIcPhoto1LessThan(String value) {
            addCriterion("IC_PHOTO_1 <", value, "icPhoto1");
            return (Criteria) this;
        }

        public Criteria andIcPhoto1LessThanOrEqualTo(String value) {
            addCriterion("IC_PHOTO_1 <=", value, "icPhoto1");
            return (Criteria) this;
        }

        public Criteria andIcPhoto1Like(String value) {
            addCriterion("IC_PHOTO_1 like", value, "icPhoto1");
            return (Criteria) this;
        }

        public Criteria andIcPhoto1NotLike(String value) {
            addCriterion("IC_PHOTO_1 not like", value, "icPhoto1");
            return (Criteria) this;
        }

        public Criteria andIcPhoto1In(List<String> values) {
            addCriterion("IC_PHOTO_1 in", values, "icPhoto1");
            return (Criteria) this;
        }

        public Criteria andIcPhoto1NotIn(List<String> values) {
            addCriterion("IC_PHOTO_1 not in", values, "icPhoto1");
            return (Criteria) this;
        }

        public Criteria andIcPhoto1Between(String value1, String value2) {
            addCriterion("IC_PHOTO_1 between", value1, value2, "icPhoto1");
            return (Criteria) this;
        }

        public Criteria andIcPhoto1NotBetween(String value1, String value2) {
            addCriterion("IC_PHOTO_1 not between", value1, value2, "icPhoto1");
            return (Criteria) this;
        }

        public Criteria andIcPhoto2IsNull() {
            addCriterion("IC_PHOTO_2 is null");
            return (Criteria) this;
        }

        public Criteria andIcPhoto2IsNotNull() {
            addCriterion("IC_PHOTO_2 is not null");
            return (Criteria) this;
        }

        public Criteria andIcPhoto2EqualTo(String value) {
            addCriterion("IC_PHOTO_2 =", value, "icPhoto2");
            return (Criteria) this;
        }

        public Criteria andIcPhoto2NotEqualTo(String value) {
            addCriterion("IC_PHOTO_2 <>", value, "icPhoto2");
            return (Criteria) this;
        }

        public Criteria andIcPhoto2GreaterThan(String value) {
            addCriterion("IC_PHOTO_2 >", value, "icPhoto2");
            return (Criteria) this;
        }

        public Criteria andIcPhoto2GreaterThanOrEqualTo(String value) {
            addCriterion("IC_PHOTO_2 >=", value, "icPhoto2");
            return (Criteria) this;
        }

        public Criteria andIcPhoto2LessThan(String value) {
            addCriterion("IC_PHOTO_2 <", value, "icPhoto2");
            return (Criteria) this;
        }

        public Criteria andIcPhoto2LessThanOrEqualTo(String value) {
            addCriterion("IC_PHOTO_2 <=", value, "icPhoto2");
            return (Criteria) this;
        }

        public Criteria andIcPhoto2Like(String value) {
            addCriterion("IC_PHOTO_2 like", value, "icPhoto2");
            return (Criteria) this;
        }

        public Criteria andIcPhoto2NotLike(String value) {
            addCriterion("IC_PHOTO_2 not like", value, "icPhoto2");
            return (Criteria) this;
        }

        public Criteria andIcPhoto2In(List<String> values) {
            addCriterion("IC_PHOTO_2 in", values, "icPhoto2");
            return (Criteria) this;
        }

        public Criteria andIcPhoto2NotIn(List<String> values) {
            addCriterion("IC_PHOTO_2 not in", values, "icPhoto2");
            return (Criteria) this;
        }

        public Criteria andIcPhoto2Between(String value1, String value2) {
            addCriterion("IC_PHOTO_2 between", value1, value2, "icPhoto2");
            return (Criteria) this;
        }

        public Criteria andIcPhoto2NotBetween(String value1, String value2) {
            addCriterion("IC_PHOTO_2 not between", value1, value2, "icPhoto2");
            return (Criteria) this;
        }

        public Criteria andUserPhotoIsNull() {
            addCriterion("USER_PHOTO is null");
            return (Criteria) this;
        }

        public Criteria andUserPhotoIsNotNull() {
            addCriterion("USER_PHOTO is not null");
            return (Criteria) this;
        }

        public Criteria andUserPhotoEqualTo(String value) {
            addCriterion("USER_PHOTO =", value, "userPhoto");
            return (Criteria) this;
        }

        public Criteria andUserPhotoNotEqualTo(String value) {
            addCriterion("USER_PHOTO <>", value, "userPhoto");
            return (Criteria) this;
        }

        public Criteria andUserPhotoGreaterThan(String value) {
            addCriterion("USER_PHOTO >", value, "userPhoto");
            return (Criteria) this;
        }

        public Criteria andUserPhotoGreaterThanOrEqualTo(String value) {
            addCriterion("USER_PHOTO >=", value, "userPhoto");
            return (Criteria) this;
        }

        public Criteria andUserPhotoLessThan(String value) {
            addCriterion("USER_PHOTO <", value, "userPhoto");
            return (Criteria) this;
        }

        public Criteria andUserPhotoLessThanOrEqualTo(String value) {
            addCriterion("USER_PHOTO <=", value, "userPhoto");
            return (Criteria) this;
        }

        public Criteria andUserPhotoLike(String value) {
            addCriterion("USER_PHOTO like", value, "userPhoto");
            return (Criteria) this;
        }

        public Criteria andUserPhotoNotLike(String value) {
            addCriterion("USER_PHOTO not like", value, "userPhoto");
            return (Criteria) this;
        }

        public Criteria andUserPhotoIn(List<String> values) {
            addCriterion("USER_PHOTO in", values, "userPhoto");
            return (Criteria) this;
        }

        public Criteria andUserPhotoNotIn(List<String> values) {
            addCriterion("USER_PHOTO not in", values, "userPhoto");
            return (Criteria) this;
        }

        public Criteria andUserPhotoBetween(String value1, String value2) {
            addCriterion("USER_PHOTO between", value1, value2, "userPhoto");
            return (Criteria) this;
        }

        public Criteria andUserPhotoNotBetween(String value1, String value2) {
            addCriterion("USER_PHOTO not between", value1, value2, "userPhoto");
            return (Criteria) this;
        }

        public Criteria andUserPhotoMinIsNull() {
            addCriterion("USER_PHOTO_MIN is null");
            return (Criteria) this;
        }

        public Criteria andUserPhotoMinIsNotNull() {
            addCriterion("USER_PHOTO_MIN is not null");
            return (Criteria) this;
        }

        public Criteria andUserPhotoMinEqualTo(String value) {
            addCriterion("USER_PHOTO_MIN =", value, "userPhotoMin");
            return (Criteria) this;
        }

        public Criteria andUserPhotoMinNotEqualTo(String value) {
            addCriterion("USER_PHOTO_MIN <>", value, "userPhotoMin");
            return (Criteria) this;
        }

        public Criteria andUserPhotoMinGreaterThan(String value) {
            addCriterion("USER_PHOTO_MIN >", value, "userPhotoMin");
            return (Criteria) this;
        }

        public Criteria andUserPhotoMinGreaterThanOrEqualTo(String value) {
            addCriterion("USER_PHOTO_MIN >=", value, "userPhotoMin");
            return (Criteria) this;
        }

        public Criteria andUserPhotoMinLessThan(String value) {
            addCriterion("USER_PHOTO_MIN <", value, "userPhotoMin");
            return (Criteria) this;
        }

        public Criteria andUserPhotoMinLessThanOrEqualTo(String value) {
            addCriterion("USER_PHOTO_MIN <=", value, "userPhotoMin");
            return (Criteria) this;
        }

        public Criteria andUserPhotoMinLike(String value) {
            addCriterion("USER_PHOTO_MIN like", value, "userPhotoMin");
            return (Criteria) this;
        }

        public Criteria andUserPhotoMinNotLike(String value) {
            addCriterion("USER_PHOTO_MIN not like", value, "userPhotoMin");
            return (Criteria) this;
        }

        public Criteria andUserPhotoMinIn(List<String> values) {
            addCriterion("USER_PHOTO_MIN in", values, "userPhotoMin");
            return (Criteria) this;
        }

        public Criteria andUserPhotoMinNotIn(List<String> values) {
            addCriterion("USER_PHOTO_MIN not in", values, "userPhotoMin");
            return (Criteria) this;
        }

        public Criteria andUserPhotoMinBetween(String value1, String value2) {
            addCriterion("USER_PHOTO_MIN between", value1, value2, "userPhotoMin");
            return (Criteria) this;
        }

        public Criteria andUserPhotoMinNotBetween(String value1, String value2) {
            addCriterion("USER_PHOTO_MIN not between", value1, value2, "userPhotoMin");
            return (Criteria) this;
        }

        public Criteria andCardPhotoIsNull() {
            addCriterion("CARD_PHOTO is null");
            return (Criteria) this;
        }

        public Criteria andCardPhotoIsNotNull() {
            addCriterion("CARD_PHOTO is not null");
            return (Criteria) this;
        }

        public Criteria andCardPhotoEqualTo(String value) {
            addCriterion("CARD_PHOTO =", value, "cardPhoto");
            return (Criteria) this;
        }

        public Criteria andCardPhotoNotEqualTo(String value) {
            addCriterion("CARD_PHOTO <>", value, "cardPhoto");
            return (Criteria) this;
        }

        public Criteria andCardPhotoGreaterThan(String value) {
            addCriterion("CARD_PHOTO >", value, "cardPhoto");
            return (Criteria) this;
        }

        public Criteria andCardPhotoGreaterThanOrEqualTo(String value) {
            addCriterion("CARD_PHOTO >=", value, "cardPhoto");
            return (Criteria) this;
        }

        public Criteria andCardPhotoLessThan(String value) {
            addCriterion("CARD_PHOTO <", value, "cardPhoto");
            return (Criteria) this;
        }

        public Criteria andCardPhotoLessThanOrEqualTo(String value) {
            addCriterion("CARD_PHOTO <=", value, "cardPhoto");
            return (Criteria) this;
        }

        public Criteria andCardPhotoLike(String value) {
            addCriterion("CARD_PHOTO like", value, "cardPhoto");
            return (Criteria) this;
        }

        public Criteria andCardPhotoNotLike(String value) {
            addCriterion("CARD_PHOTO not like", value, "cardPhoto");
            return (Criteria) this;
        }

        public Criteria andCardPhotoIn(List<String> values) {
            addCriterion("CARD_PHOTO in", values, "cardPhoto");
            return (Criteria) this;
        }

        public Criteria andCardPhotoNotIn(List<String> values) {
            addCriterion("CARD_PHOTO not in", values, "cardPhoto");
            return (Criteria) this;
        }

        public Criteria andCardPhotoBetween(String value1, String value2) {
            addCriterion("CARD_PHOTO between", value1, value2, "cardPhoto");
            return (Criteria) this;
        }

        public Criteria andCardPhotoNotBetween(String value1, String value2) {
            addCriterion("CARD_PHOTO not between", value1, value2, "cardPhoto");
            return (Criteria) this;
        }

        public Criteria andBbsPhotoIsNull() {
            addCriterion("BBS_PHOTO is null");
            return (Criteria) this;
        }

        public Criteria andBbsPhotoIsNotNull() {
            addCriterion("BBS_PHOTO is not null");
            return (Criteria) this;
        }

        public Criteria andBbsPhotoEqualTo(String value) {
            addCriterion("BBS_PHOTO =", value, "bbsPhoto");
            return (Criteria) this;
        }

        public Criteria andBbsPhotoNotEqualTo(String value) {
            addCriterion("BBS_PHOTO <>", value, "bbsPhoto");
            return (Criteria) this;
        }

        public Criteria andBbsPhotoGreaterThan(String value) {
            addCriterion("BBS_PHOTO >", value, "bbsPhoto");
            return (Criteria) this;
        }

        public Criteria andBbsPhotoGreaterThanOrEqualTo(String value) {
            addCriterion("BBS_PHOTO >=", value, "bbsPhoto");
            return (Criteria) this;
        }

        public Criteria andBbsPhotoLessThan(String value) {
            addCriterion("BBS_PHOTO <", value, "bbsPhoto");
            return (Criteria) this;
        }

        public Criteria andBbsPhotoLessThanOrEqualTo(String value) {
            addCriterion("BBS_PHOTO <=", value, "bbsPhoto");
            return (Criteria) this;
        }

        public Criteria andBbsPhotoLike(String value) {
            addCriterion("BBS_PHOTO like", value, "bbsPhoto");
            return (Criteria) this;
        }

        public Criteria andBbsPhotoNotLike(String value) {
            addCriterion("BBS_PHOTO not like", value, "bbsPhoto");
            return (Criteria) this;
        }

        public Criteria andBbsPhotoIn(List<String> values) {
            addCriterion("BBS_PHOTO in", values, "bbsPhoto");
            return (Criteria) this;
        }

        public Criteria andBbsPhotoNotIn(List<String> values) {
            addCriterion("BBS_PHOTO not in", values, "bbsPhoto");
            return (Criteria) this;
        }

        public Criteria andBbsPhotoBetween(String value1, String value2) {
            addCriterion("BBS_PHOTO between", value1, value2, "bbsPhoto");
            return (Criteria) this;
        }

        public Criteria andBbsPhotoNotBetween(String value1, String value2) {
            addCriterion("BBS_PHOTO not between", value1, value2, "bbsPhoto");
            return (Criteria) this;
        }

        public Criteria andShopInnerPhotoIsNull() {
            addCriterion("SHOP_INNER_PHOTO is null");
            return (Criteria) this;
        }

        public Criteria andShopInnerPhotoIsNotNull() {
            addCriterion("SHOP_INNER_PHOTO is not null");
            return (Criteria) this;
        }

        public Criteria andShopInnerPhotoEqualTo(String value) {
            addCriterion("SHOP_INNER_PHOTO =", value, "shopInnerPhoto");
            return (Criteria) this;
        }

        public Criteria andShopInnerPhotoNotEqualTo(String value) {
            addCriterion("SHOP_INNER_PHOTO <>", value, "shopInnerPhoto");
            return (Criteria) this;
        }

        public Criteria andShopInnerPhotoGreaterThan(String value) {
            addCriterion("SHOP_INNER_PHOTO >", value, "shopInnerPhoto");
            return (Criteria) this;
        }

        public Criteria andShopInnerPhotoGreaterThanOrEqualTo(String value) {
            addCriterion("SHOP_INNER_PHOTO >=", value, "shopInnerPhoto");
            return (Criteria) this;
        }

        public Criteria andShopInnerPhotoLessThan(String value) {
            addCriterion("SHOP_INNER_PHOTO <", value, "shopInnerPhoto");
            return (Criteria) this;
        }

        public Criteria andShopInnerPhotoLessThanOrEqualTo(String value) {
            addCriterion("SHOP_INNER_PHOTO <=", value, "shopInnerPhoto");
            return (Criteria) this;
        }

        public Criteria andShopInnerPhotoLike(String value) {
            addCriterion("SHOP_INNER_PHOTO like", value, "shopInnerPhoto");
            return (Criteria) this;
        }

        public Criteria andShopInnerPhotoNotLike(String value) {
            addCriterion("SHOP_INNER_PHOTO not like", value, "shopInnerPhoto");
            return (Criteria) this;
        }

        public Criteria andShopInnerPhotoIn(List<String> values) {
            addCriterion("SHOP_INNER_PHOTO in", values, "shopInnerPhoto");
            return (Criteria) this;
        }

        public Criteria andShopInnerPhotoNotIn(List<String> values) {
            addCriterion("SHOP_INNER_PHOTO not in", values, "shopInnerPhoto");
            return (Criteria) this;
        }

        public Criteria andShopInnerPhotoBetween(String value1, String value2) {
            addCriterion("SHOP_INNER_PHOTO between", value1, value2, "shopInnerPhoto");
            return (Criteria) this;
        }

        public Criteria andShopInnerPhotoNotBetween(String value1, String value2) {
            addCriterion("SHOP_INNER_PHOTO not between", value1, value2, "shopInnerPhoto");
            return (Criteria) this;
        }

        public Criteria andShopOuterPhotoIsNull() {
            addCriterion("SHOP_OUTER_PHOTO is null");
            return (Criteria) this;
        }

        public Criteria andShopOuterPhotoIsNotNull() {
            addCriterion("SHOP_OUTER_PHOTO is not null");
            return (Criteria) this;
        }

        public Criteria andShopOuterPhotoEqualTo(String value) {
            addCriterion("SHOP_OUTER_PHOTO =", value, "shopOuterPhoto");
            return (Criteria) this;
        }

        public Criteria andShopOuterPhotoNotEqualTo(String value) {
            addCriterion("SHOP_OUTER_PHOTO <>", value, "shopOuterPhoto");
            return (Criteria) this;
        }

        public Criteria andShopOuterPhotoGreaterThan(String value) {
            addCriterion("SHOP_OUTER_PHOTO >", value, "shopOuterPhoto");
            return (Criteria) this;
        }

        public Criteria andShopOuterPhotoGreaterThanOrEqualTo(String value) {
            addCriterion("SHOP_OUTER_PHOTO >=", value, "shopOuterPhoto");
            return (Criteria) this;
        }

        public Criteria andShopOuterPhotoLessThan(String value) {
            addCriterion("SHOP_OUTER_PHOTO <", value, "shopOuterPhoto");
            return (Criteria) this;
        }

        public Criteria andShopOuterPhotoLessThanOrEqualTo(String value) {
            addCriterion("SHOP_OUTER_PHOTO <=", value, "shopOuterPhoto");
            return (Criteria) this;
        }

        public Criteria andShopOuterPhotoLike(String value) {
            addCriterion("SHOP_OUTER_PHOTO like", value, "shopOuterPhoto");
            return (Criteria) this;
        }

        public Criteria andShopOuterPhotoNotLike(String value) {
            addCriterion("SHOP_OUTER_PHOTO not like", value, "shopOuterPhoto");
            return (Criteria) this;
        }

        public Criteria andShopOuterPhotoIn(List<String> values) {
            addCriterion("SHOP_OUTER_PHOTO in", values, "shopOuterPhoto");
            return (Criteria) this;
        }

        public Criteria andShopOuterPhotoNotIn(List<String> values) {
            addCriterion("SHOP_OUTER_PHOTO not in", values, "shopOuterPhoto");
            return (Criteria) this;
        }

        public Criteria andShopOuterPhotoBetween(String value1, String value2) {
            addCriterion("SHOP_OUTER_PHOTO between", value1, value2, "shopOuterPhoto");
            return (Criteria) this;
        }

        public Criteria andShopOuterPhotoNotBetween(String value1, String value2) {
            addCriterion("SHOP_OUTER_PHOTO not between", value1, value2, "shopOuterPhoto");
            return (Criteria) this;
        }

        public Criteria andIcPhoto1OldIsNull() {
            addCriterion("IC_PHOTO_1_OLD is null");
            return (Criteria) this;
        }

        public Criteria andIcPhoto1OldIsNotNull() {
            addCriterion("IC_PHOTO_1_OLD is not null");
            return (Criteria) this;
        }

        public Criteria andIcPhoto1OldEqualTo(String value) {
            addCriterion("IC_PHOTO_1_OLD =", value, "icPhoto1Old");
            return (Criteria) this;
        }

        public Criteria andIcPhoto1OldNotEqualTo(String value) {
            addCriterion("IC_PHOTO_1_OLD <>", value, "icPhoto1Old");
            return (Criteria) this;
        }

        public Criteria andIcPhoto1OldGreaterThan(String value) {
            addCriterion("IC_PHOTO_1_OLD >", value, "icPhoto1Old");
            return (Criteria) this;
        }

        public Criteria andIcPhoto1OldGreaterThanOrEqualTo(String value) {
            addCriterion("IC_PHOTO_1_OLD >=", value, "icPhoto1Old");
            return (Criteria) this;
        }

        public Criteria andIcPhoto1OldLessThan(String value) {
            addCriterion("IC_PHOTO_1_OLD <", value, "icPhoto1Old");
            return (Criteria) this;
        }

        public Criteria andIcPhoto1OldLessThanOrEqualTo(String value) {
            addCriterion("IC_PHOTO_1_OLD <=", value, "icPhoto1Old");
            return (Criteria) this;
        }

        public Criteria andIcPhoto1OldLike(String value) {
            addCriterion("IC_PHOTO_1_OLD like", value, "icPhoto1Old");
            return (Criteria) this;
        }

        public Criteria andIcPhoto1OldNotLike(String value) {
            addCriterion("IC_PHOTO_1_OLD not like", value, "icPhoto1Old");
            return (Criteria) this;
        }

        public Criteria andIcPhoto1OldIn(List<String> values) {
            addCriterion("IC_PHOTO_1_OLD in", values, "icPhoto1Old");
            return (Criteria) this;
        }

        public Criteria andIcPhoto1OldNotIn(List<String> values) {
            addCriterion("IC_PHOTO_1_OLD not in", values, "icPhoto1Old");
            return (Criteria) this;
        }

        public Criteria andIcPhoto1OldBetween(String value1, String value2) {
            addCriterion("IC_PHOTO_1_OLD between", value1, value2, "icPhoto1Old");
            return (Criteria) this;
        }

        public Criteria andIcPhoto1OldNotBetween(String value1, String value2) {
            addCriterion("IC_PHOTO_1_OLD not between", value1, value2, "icPhoto1Old");
            return (Criteria) this;
        }

        public Criteria andIcPhoto2OldIsNull() {
            addCriterion("IC_PHOTO_2_OLD is null");
            return (Criteria) this;
        }

        public Criteria andIcPhoto2OldIsNotNull() {
            addCriterion("IC_PHOTO_2_OLD is not null");
            return (Criteria) this;
        }

        public Criteria andIcPhoto2OldEqualTo(String value) {
            addCriterion("IC_PHOTO_2_OLD =", value, "icPhoto2Old");
            return (Criteria) this;
        }

        public Criteria andIcPhoto2OldNotEqualTo(String value) {
            addCriterion("IC_PHOTO_2_OLD <>", value, "icPhoto2Old");
            return (Criteria) this;
        }

        public Criteria andIcPhoto2OldGreaterThan(String value) {
            addCriterion("IC_PHOTO_2_OLD >", value, "icPhoto2Old");
            return (Criteria) this;
        }

        public Criteria andIcPhoto2OldGreaterThanOrEqualTo(String value) {
            addCriterion("IC_PHOTO_2_OLD >=", value, "icPhoto2Old");
            return (Criteria) this;
        }

        public Criteria andIcPhoto2OldLessThan(String value) {
            addCriterion("IC_PHOTO_2_OLD <", value, "icPhoto2Old");
            return (Criteria) this;
        }

        public Criteria andIcPhoto2OldLessThanOrEqualTo(String value) {
            addCriterion("IC_PHOTO_2_OLD <=", value, "icPhoto2Old");
            return (Criteria) this;
        }

        public Criteria andIcPhoto2OldLike(String value) {
            addCriterion("IC_PHOTO_2_OLD like", value, "icPhoto2Old");
            return (Criteria) this;
        }

        public Criteria andIcPhoto2OldNotLike(String value) {
            addCriterion("IC_PHOTO_2_OLD not like", value, "icPhoto2Old");
            return (Criteria) this;
        }

        public Criteria andIcPhoto2OldIn(List<String> values) {
            addCriterion("IC_PHOTO_2_OLD in", values, "icPhoto2Old");
            return (Criteria) this;
        }

        public Criteria andIcPhoto2OldNotIn(List<String> values) {
            addCriterion("IC_PHOTO_2_OLD not in", values, "icPhoto2Old");
            return (Criteria) this;
        }

        public Criteria andIcPhoto2OldBetween(String value1, String value2) {
            addCriterion("IC_PHOTO_2_OLD between", value1, value2, "icPhoto2Old");
            return (Criteria) this;
        }

        public Criteria andIcPhoto2OldNotBetween(String value1, String value2) {
            addCriterion("IC_PHOTO_2_OLD not between", value1, value2, "icPhoto2Old");
            return (Criteria) this;
        }

        public Criteria andUserPhotoOldIsNull() {
            addCriterion("USER_PHOTO_OLD is null");
            return (Criteria) this;
        }

        public Criteria andUserPhotoOldIsNotNull() {
            addCriterion("USER_PHOTO_OLD is not null");
            return (Criteria) this;
        }

        public Criteria andUserPhotoOldEqualTo(String value) {
            addCriterion("USER_PHOTO_OLD =", value, "userPhotoOld");
            return (Criteria) this;
        }

        public Criteria andUserPhotoOldNotEqualTo(String value) {
            addCriterion("USER_PHOTO_OLD <>", value, "userPhotoOld");
            return (Criteria) this;
        }

        public Criteria andUserPhotoOldGreaterThan(String value) {
            addCriterion("USER_PHOTO_OLD >", value, "userPhotoOld");
            return (Criteria) this;
        }

        public Criteria andUserPhotoOldGreaterThanOrEqualTo(String value) {
            addCriterion("USER_PHOTO_OLD >=", value, "userPhotoOld");
            return (Criteria) this;
        }

        public Criteria andUserPhotoOldLessThan(String value) {
            addCriterion("USER_PHOTO_OLD <", value, "userPhotoOld");
            return (Criteria) this;
        }

        public Criteria andUserPhotoOldLessThanOrEqualTo(String value) {
            addCriterion("USER_PHOTO_OLD <=", value, "userPhotoOld");
            return (Criteria) this;
        }

        public Criteria andUserPhotoOldLike(String value) {
            addCriterion("USER_PHOTO_OLD like", value, "userPhotoOld");
            return (Criteria) this;
        }

        public Criteria andUserPhotoOldNotLike(String value) {
            addCriterion("USER_PHOTO_OLD not like", value, "userPhotoOld");
            return (Criteria) this;
        }

        public Criteria andUserPhotoOldIn(List<String> values) {
            addCriterion("USER_PHOTO_OLD in", values, "userPhotoOld");
            return (Criteria) this;
        }

        public Criteria andUserPhotoOldNotIn(List<String> values) {
            addCriterion("USER_PHOTO_OLD not in", values, "userPhotoOld");
            return (Criteria) this;
        }

        public Criteria andUserPhotoOldBetween(String value1, String value2) {
            addCriterion("USER_PHOTO_OLD between", value1, value2, "userPhotoOld");
            return (Criteria) this;
        }

        public Criteria andUserPhotoOldNotBetween(String value1, String value2) {
            addCriterion("USER_PHOTO_OLD not between", value1, value2, "userPhotoOld");
            return (Criteria) this;
        }

        public Criteria andUserPhotoMinOldIsNull() {
            addCriterion("USER_PHOTO_MIN_OLD is null");
            return (Criteria) this;
        }

        public Criteria andUserPhotoMinOldIsNotNull() {
            addCriterion("USER_PHOTO_MIN_OLD is not null");
            return (Criteria) this;
        }

        public Criteria andUserPhotoMinOldEqualTo(String value) {
            addCriterion("USER_PHOTO_MIN_OLD =", value, "userPhotoMinOld");
            return (Criteria) this;
        }

        public Criteria andUserPhotoMinOldNotEqualTo(String value) {
            addCriterion("USER_PHOTO_MIN_OLD <>", value, "userPhotoMinOld");
            return (Criteria) this;
        }

        public Criteria andUserPhotoMinOldGreaterThan(String value) {
            addCriterion("USER_PHOTO_MIN_OLD >", value, "userPhotoMinOld");
            return (Criteria) this;
        }

        public Criteria andUserPhotoMinOldGreaterThanOrEqualTo(String value) {
            addCriterion("USER_PHOTO_MIN_OLD >=", value, "userPhotoMinOld");
            return (Criteria) this;
        }

        public Criteria andUserPhotoMinOldLessThan(String value) {
            addCriterion("USER_PHOTO_MIN_OLD <", value, "userPhotoMinOld");
            return (Criteria) this;
        }

        public Criteria andUserPhotoMinOldLessThanOrEqualTo(String value) {
            addCriterion("USER_PHOTO_MIN_OLD <=", value, "userPhotoMinOld");
            return (Criteria) this;
        }

        public Criteria andUserPhotoMinOldLike(String value) {
            addCriterion("USER_PHOTO_MIN_OLD like", value, "userPhotoMinOld");
            return (Criteria) this;
        }

        public Criteria andUserPhotoMinOldNotLike(String value) {
            addCriterion("USER_PHOTO_MIN_OLD not like", value, "userPhotoMinOld");
            return (Criteria) this;
        }

        public Criteria andUserPhotoMinOldIn(List<String> values) {
            addCriterion("USER_PHOTO_MIN_OLD in", values, "userPhotoMinOld");
            return (Criteria) this;
        }

        public Criteria andUserPhotoMinOldNotIn(List<String> values) {
            addCriterion("USER_PHOTO_MIN_OLD not in", values, "userPhotoMinOld");
            return (Criteria) this;
        }

        public Criteria andUserPhotoMinOldBetween(String value1, String value2) {
            addCriterion("USER_PHOTO_MIN_OLD between", value1, value2, "userPhotoMinOld");
            return (Criteria) this;
        }

        public Criteria andUserPhotoMinOldNotBetween(String value1, String value2) {
            addCriterion("USER_PHOTO_MIN_OLD not between", value1, value2, "userPhotoMinOld");
            return (Criteria) this;
        }

        public Criteria andCardPhotoOldIsNull() {
            addCriterion("CARD_PHOTO_OLD is null");
            return (Criteria) this;
        }

        public Criteria andCardPhotoOldIsNotNull() {
            addCriterion("CARD_PHOTO_OLD is not null");
            return (Criteria) this;
        }

        public Criteria andCardPhotoOldEqualTo(String value) {
            addCriterion("CARD_PHOTO_OLD =", value, "cardPhotoOld");
            return (Criteria) this;
        }

        public Criteria andCardPhotoOldNotEqualTo(String value) {
            addCriterion("CARD_PHOTO_OLD <>", value, "cardPhotoOld");
            return (Criteria) this;
        }

        public Criteria andCardPhotoOldGreaterThan(String value) {
            addCriterion("CARD_PHOTO_OLD >", value, "cardPhotoOld");
            return (Criteria) this;
        }

        public Criteria andCardPhotoOldGreaterThanOrEqualTo(String value) {
            addCriterion("CARD_PHOTO_OLD >=", value, "cardPhotoOld");
            return (Criteria) this;
        }

        public Criteria andCardPhotoOldLessThan(String value) {
            addCriterion("CARD_PHOTO_OLD <", value, "cardPhotoOld");
            return (Criteria) this;
        }

        public Criteria andCardPhotoOldLessThanOrEqualTo(String value) {
            addCriterion("CARD_PHOTO_OLD <=", value, "cardPhotoOld");
            return (Criteria) this;
        }

        public Criteria andCardPhotoOldLike(String value) {
            addCriterion("CARD_PHOTO_OLD like", value, "cardPhotoOld");
            return (Criteria) this;
        }

        public Criteria andCardPhotoOldNotLike(String value) {
            addCriterion("CARD_PHOTO_OLD not like", value, "cardPhotoOld");
            return (Criteria) this;
        }

        public Criteria andCardPhotoOldIn(List<String> values) {
            addCriterion("CARD_PHOTO_OLD in", values, "cardPhotoOld");
            return (Criteria) this;
        }

        public Criteria andCardPhotoOldNotIn(List<String> values) {
            addCriterion("CARD_PHOTO_OLD not in", values, "cardPhotoOld");
            return (Criteria) this;
        }

        public Criteria andCardPhotoOldBetween(String value1, String value2) {
            addCriterion("CARD_PHOTO_OLD between", value1, value2, "cardPhotoOld");
            return (Criteria) this;
        }

        public Criteria andCardPhotoOldNotBetween(String value1, String value2) {
            addCriterion("CARD_PHOTO_OLD not between", value1, value2, "cardPhotoOld");
            return (Criteria) this;
        }

        public Criteria andBbsPhotoOldIsNull() {
            addCriterion("BBS_PHOTO_OLD is null");
            return (Criteria) this;
        }

        public Criteria andBbsPhotoOldIsNotNull() {
            addCriterion("BBS_PHOTO_OLD is not null");
            return (Criteria) this;
        }

        public Criteria andBbsPhotoOldEqualTo(String value) {
            addCriterion("BBS_PHOTO_OLD =", value, "bbsPhotoOld");
            return (Criteria) this;
        }

        public Criteria andBbsPhotoOldNotEqualTo(String value) {
            addCriterion("BBS_PHOTO_OLD <>", value, "bbsPhotoOld");
            return (Criteria) this;
        }

        public Criteria andBbsPhotoOldGreaterThan(String value) {
            addCriterion("BBS_PHOTO_OLD >", value, "bbsPhotoOld");
            return (Criteria) this;
        }

        public Criteria andBbsPhotoOldGreaterThanOrEqualTo(String value) {
            addCriterion("BBS_PHOTO_OLD >=", value, "bbsPhotoOld");
            return (Criteria) this;
        }

        public Criteria andBbsPhotoOldLessThan(String value) {
            addCriterion("BBS_PHOTO_OLD <", value, "bbsPhotoOld");
            return (Criteria) this;
        }

        public Criteria andBbsPhotoOldLessThanOrEqualTo(String value) {
            addCriterion("BBS_PHOTO_OLD <=", value, "bbsPhotoOld");
            return (Criteria) this;
        }

        public Criteria andBbsPhotoOldLike(String value) {
            addCriterion("BBS_PHOTO_OLD like", value, "bbsPhotoOld");
            return (Criteria) this;
        }

        public Criteria andBbsPhotoOldNotLike(String value) {
            addCriterion("BBS_PHOTO_OLD not like", value, "bbsPhotoOld");
            return (Criteria) this;
        }

        public Criteria andBbsPhotoOldIn(List<String> values) {
            addCriterion("BBS_PHOTO_OLD in", values, "bbsPhotoOld");
            return (Criteria) this;
        }

        public Criteria andBbsPhotoOldNotIn(List<String> values) {
            addCriterion("BBS_PHOTO_OLD not in", values, "bbsPhotoOld");
            return (Criteria) this;
        }

        public Criteria andBbsPhotoOldBetween(String value1, String value2) {
            addCriterion("BBS_PHOTO_OLD between", value1, value2, "bbsPhotoOld");
            return (Criteria) this;
        }

        public Criteria andBbsPhotoOldNotBetween(String value1, String value2) {
            addCriterion("BBS_PHOTO_OLD not between", value1, value2, "bbsPhotoOld");
            return (Criteria) this;
        }

        public Criteria andShopInnerPhotoOldIsNull() {
            addCriterion("SHOP_INNER_PHOTO_OLD is null");
            return (Criteria) this;
        }

        public Criteria andShopInnerPhotoOldIsNotNull() {
            addCriterion("SHOP_INNER_PHOTO_OLD is not null");
            return (Criteria) this;
        }

        public Criteria andShopInnerPhotoOldEqualTo(String value) {
            addCriterion("SHOP_INNER_PHOTO_OLD =", value, "shopInnerPhotoOld");
            return (Criteria) this;
        }

        public Criteria andShopInnerPhotoOldNotEqualTo(String value) {
            addCriterion("SHOP_INNER_PHOTO_OLD <>", value, "shopInnerPhotoOld");
            return (Criteria) this;
        }

        public Criteria andShopInnerPhotoOldGreaterThan(String value) {
            addCriterion("SHOP_INNER_PHOTO_OLD >", value, "shopInnerPhotoOld");
            return (Criteria) this;
        }

        public Criteria andShopInnerPhotoOldGreaterThanOrEqualTo(String value) {
            addCriterion("SHOP_INNER_PHOTO_OLD >=", value, "shopInnerPhotoOld");
            return (Criteria) this;
        }

        public Criteria andShopInnerPhotoOldLessThan(String value) {
            addCriterion("SHOP_INNER_PHOTO_OLD <", value, "shopInnerPhotoOld");
            return (Criteria) this;
        }

        public Criteria andShopInnerPhotoOldLessThanOrEqualTo(String value) {
            addCriterion("SHOP_INNER_PHOTO_OLD <=", value, "shopInnerPhotoOld");
            return (Criteria) this;
        }

        public Criteria andShopInnerPhotoOldLike(String value) {
            addCriterion("SHOP_INNER_PHOTO_OLD like", value, "shopInnerPhotoOld");
            return (Criteria) this;
        }

        public Criteria andShopInnerPhotoOldNotLike(String value) {
            addCriterion("SHOP_INNER_PHOTO_OLD not like", value, "shopInnerPhotoOld");
            return (Criteria) this;
        }

        public Criteria andShopInnerPhotoOldIn(List<String> values) {
            addCriterion("SHOP_INNER_PHOTO_OLD in", values, "shopInnerPhotoOld");
            return (Criteria) this;
        }

        public Criteria andShopInnerPhotoOldNotIn(List<String> values) {
            addCriterion("SHOP_INNER_PHOTO_OLD not in", values, "shopInnerPhotoOld");
            return (Criteria) this;
        }

        public Criteria andShopInnerPhotoOldBetween(String value1, String value2) {
            addCriterion("SHOP_INNER_PHOTO_OLD between", value1, value2, "shopInnerPhotoOld");
            return (Criteria) this;
        }

        public Criteria andShopInnerPhotoOldNotBetween(String value1, String value2) {
            addCriterion("SHOP_INNER_PHOTO_OLD not between", value1, value2, "shopInnerPhotoOld");
            return (Criteria) this;
        }

        public Criteria andShopOuterPhotoOldIsNull() {
            addCriterion("SHOP_OUTER_PHOTO_OLD is null");
            return (Criteria) this;
        }

        public Criteria andShopOuterPhotoOldIsNotNull() {
            addCriterion("SHOP_OUTER_PHOTO_OLD is not null");
            return (Criteria) this;
        }

        public Criteria andShopOuterPhotoOldEqualTo(String value) {
            addCriterion("SHOP_OUTER_PHOTO_OLD =", value, "shopOuterPhotoOld");
            return (Criteria) this;
        }

        public Criteria andShopOuterPhotoOldNotEqualTo(String value) {
            addCriterion("SHOP_OUTER_PHOTO_OLD <>", value, "shopOuterPhotoOld");
            return (Criteria) this;
        }

        public Criteria andShopOuterPhotoOldGreaterThan(String value) {
            addCriterion("SHOP_OUTER_PHOTO_OLD >", value, "shopOuterPhotoOld");
            return (Criteria) this;
        }

        public Criteria andShopOuterPhotoOldGreaterThanOrEqualTo(String value) {
            addCriterion("SHOP_OUTER_PHOTO_OLD >=", value, "shopOuterPhotoOld");
            return (Criteria) this;
        }

        public Criteria andShopOuterPhotoOldLessThan(String value) {
            addCriterion("SHOP_OUTER_PHOTO_OLD <", value, "shopOuterPhotoOld");
            return (Criteria) this;
        }

        public Criteria andShopOuterPhotoOldLessThanOrEqualTo(String value) {
            addCriterion("SHOP_OUTER_PHOTO_OLD <=", value, "shopOuterPhotoOld");
            return (Criteria) this;
        }

        public Criteria andShopOuterPhotoOldLike(String value) {
            addCriterion("SHOP_OUTER_PHOTO_OLD like", value, "shopOuterPhotoOld");
            return (Criteria) this;
        }

        public Criteria andShopOuterPhotoOldNotLike(String value) {
            addCriterion("SHOP_OUTER_PHOTO_OLD not like", value, "shopOuterPhotoOld");
            return (Criteria) this;
        }

        public Criteria andShopOuterPhotoOldIn(List<String> values) {
            addCriterion("SHOP_OUTER_PHOTO_OLD in", values, "shopOuterPhotoOld");
            return (Criteria) this;
        }

        public Criteria andShopOuterPhotoOldNotIn(List<String> values) {
            addCriterion("SHOP_OUTER_PHOTO_OLD not in", values, "shopOuterPhotoOld");
            return (Criteria) this;
        }

        public Criteria andShopOuterPhotoOldBetween(String value1, String value2) {
            addCriterion("SHOP_OUTER_PHOTO_OLD between", value1, value2, "shopOuterPhotoOld");
            return (Criteria) this;
        }

        public Criteria andShopOuterPhotoOldNotBetween(String value1, String value2) {
            addCriterion("SHOP_OUTER_PHOTO_OLD not between", value1, value2, "shopOuterPhotoOld");
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

        public Criteria andOldAddrIsNull() {
            addCriterion("OLD_ADDR is null");
            return (Criteria) this;
        }

        public Criteria andOldAddrIsNotNull() {
            addCriterion("OLD_ADDR is not null");
            return (Criteria) this;
        }

        public Criteria andOldAddrEqualTo(String value) {
            addCriterion("OLD_ADDR =", value, "oldAddr");
            return (Criteria) this;
        }

        public Criteria andOldAddrNotEqualTo(String value) {
            addCriterion("OLD_ADDR <>", value, "oldAddr");
            return (Criteria) this;
        }

        public Criteria andOldAddrGreaterThan(String value) {
            addCriterion("OLD_ADDR >", value, "oldAddr");
            return (Criteria) this;
        }

        public Criteria andOldAddrGreaterThanOrEqualTo(String value) {
            addCriterion("OLD_ADDR >=", value, "oldAddr");
            return (Criteria) this;
        }

        public Criteria andOldAddrLessThan(String value) {
            addCriterion("OLD_ADDR <", value, "oldAddr");
            return (Criteria) this;
        }

        public Criteria andOldAddrLessThanOrEqualTo(String value) {
            addCriterion("OLD_ADDR <=", value, "oldAddr");
            return (Criteria) this;
        }

        public Criteria andOldAddrLike(String value) {
            addCriterion("OLD_ADDR like", value, "oldAddr");
            return (Criteria) this;
        }

        public Criteria andOldAddrNotLike(String value) {
            addCriterion("OLD_ADDR not like", value, "oldAddr");
            return (Criteria) this;
        }

        public Criteria andOldAddrIn(List<String> values) {
            addCriterion("OLD_ADDR in", values, "oldAddr");
            return (Criteria) this;
        }

        public Criteria andOldAddrNotIn(List<String> values) {
            addCriterion("OLD_ADDR not in", values, "oldAddr");
            return (Criteria) this;
        }

        public Criteria andOldAddrBetween(String value1, String value2) {
            addCriterion("OLD_ADDR between", value1, value2, "oldAddr");
            return (Criteria) this;
        }

        public Criteria andOldAddrNotBetween(String value1, String value2) {
            addCriterion("OLD_ADDR not between", value1, value2, "oldAddr");
            return (Criteria) this;
        }

        public Criteria andIsDealIsNull() {
            addCriterion("IS_DEAL is null");
            return (Criteria) this;
        }

        public Criteria andIsDealIsNotNull() {
            addCriterion("IS_DEAL is not null");
            return (Criteria) this;
        }

        public Criteria andIsDealEqualTo(Byte value) {
            addCriterion("IS_DEAL =", value, "isDeal");
            return (Criteria) this;
        }

        public Criteria andIsDealNotEqualTo(Byte value) {
            addCriterion("IS_DEAL <>", value, "isDeal");
            return (Criteria) this;
        }

        public Criteria andIsDealGreaterThan(Byte value) {
            addCriterion("IS_DEAL >", value, "isDeal");
            return (Criteria) this;
        }

        public Criteria andIsDealGreaterThanOrEqualTo(Byte value) {
            addCriterion("IS_DEAL >=", value, "isDeal");
            return (Criteria) this;
        }

        public Criteria andIsDealLessThan(Byte value) {
            addCriterion("IS_DEAL <", value, "isDeal");
            return (Criteria) this;
        }

        public Criteria andIsDealLessThanOrEqualTo(Byte value) {
            addCriterion("IS_DEAL <=", value, "isDeal");
            return (Criteria) this;
        }

        public Criteria andIsDealIn(List<Byte> values) {
            addCriterion("IS_DEAL in", values, "isDeal");
            return (Criteria) this;
        }

        public Criteria andIsDealNotIn(List<Byte> values) {
            addCriterion("IS_DEAL not in", values, "isDeal");
            return (Criteria) this;
        }

        public Criteria andIsDealBetween(Byte value1, Byte value2) {
            addCriterion("IS_DEAL between", value1, value2, "isDeal");
            return (Criteria) this;
        }

        public Criteria andIsDealNotBetween(Byte value1, Byte value2) {
            addCriterion("IS_DEAL not between", value1, value2, "isDeal");
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