package com.myfun.repository.erpdb.po;

import com.myfun.repository.support.generator.shard.ShardDb;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ErpCountDoneExample extends ShardDb {
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
    public ErpCountDoneExample() {
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

        public Criteria andSIdIsNull() {
            addCriterion("S_ID is null");
            return (Criteria) this;
        }

        public Criteria andSIdIsNotNull() {
            addCriterion("S_ID is not null");
            return (Criteria) this;
        }

        public Criteria andSIdEqualTo(Integer value) {
            addCriterion("S_ID =", value, "sId");
            return (Criteria) this;
        }

        public Criteria andSIdNotEqualTo(Integer value) {
            addCriterion("S_ID <>", value, "sId");
            return (Criteria) this;
        }

        public Criteria andSIdGreaterThan(Integer value) {
            addCriterion("S_ID >", value, "sId");
            return (Criteria) this;
        }

        public Criteria andSIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("S_ID >=", value, "sId");
            return (Criteria) this;
        }

        public Criteria andSIdLessThan(Integer value) {
            addCriterion("S_ID <", value, "sId");
            return (Criteria) this;
        }

        public Criteria andSIdLessThanOrEqualTo(Integer value) {
            addCriterion("S_ID <=", value, "sId");
            return (Criteria) this;
        }

        public Criteria andSIdIn(List<Integer> values) {
            addCriterion("S_ID in", values, "sId");
            return (Criteria) this;
        }

        public Criteria andSIdNotIn(List<Integer> values) {
            addCriterion("S_ID not in", values, "sId");
            return (Criteria) this;
        }

        public Criteria andSIdBetween(Integer value1, Integer value2) {
            addCriterion("S_ID between", value1, value2, "sId");
            return (Criteria) this;
        }

        public Criteria andSIdNotBetween(Integer value1, Integer value2) {
            addCriterion("S_ID not between", value1, value2, "sId");
            return (Criteria) this;
        }

        public Criteria andSaleLeaseIsNull() {
            addCriterion("SALE_LEASE is null");
            return (Criteria) this;
        }

        public Criteria andSaleLeaseIsNotNull() {
            addCriterion("SALE_LEASE is not null");
            return (Criteria) this;
        }

        public Criteria andSaleLeaseEqualTo(Byte value) {
            addCriterion("SALE_LEASE =", value, "saleLease");
            return (Criteria) this;
        }

        public Criteria andSaleLeaseNotEqualTo(Byte value) {
            addCriterion("SALE_LEASE <>", value, "saleLease");
            return (Criteria) this;
        }

        public Criteria andSaleLeaseGreaterThan(Byte value) {
            addCriterion("SALE_LEASE >", value, "saleLease");
            return (Criteria) this;
        }

        public Criteria andSaleLeaseGreaterThanOrEqualTo(Byte value) {
            addCriterion("SALE_LEASE >=", value, "saleLease");
            return (Criteria) this;
        }

        public Criteria andSaleLeaseLessThan(Byte value) {
            addCriterion("SALE_LEASE <", value, "saleLease");
            return (Criteria) this;
        }

        public Criteria andSaleLeaseLessThanOrEqualTo(Byte value) {
            addCriterion("SALE_LEASE <=", value, "saleLease");
            return (Criteria) this;
        }

        public Criteria andSaleLeaseIn(List<Byte> values) {
            addCriterion("SALE_LEASE in", values, "saleLease");
            return (Criteria) this;
        }

        public Criteria andSaleLeaseNotIn(List<Byte> values) {
            addCriterion("SALE_LEASE not in", values, "saleLease");
            return (Criteria) this;
        }

        public Criteria andSaleLeaseBetween(Byte value1, Byte value2) {
            addCriterion("SALE_LEASE between", value1, value2, "saleLease");
            return (Criteria) this;
        }

        public Criteria andSaleLeaseNotBetween(Byte value1, Byte value2) {
            addCriterion("SALE_LEASE not between", value1, value2, "saleLease");
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

        public Criteria andHouseUseageIsNull() {
            addCriterion("HOUSE_USEAGE is null");
            return (Criteria) this;
        }

        public Criteria andHouseUseageIsNotNull() {
            addCriterion("HOUSE_USEAGE is not null");
            return (Criteria) this;
        }

        public Criteria andHouseUseageEqualTo(Integer value) {
            addCriterion("HOUSE_USEAGE =", value, "houseUseage");
            return (Criteria) this;
        }

        public Criteria andHouseUseageNotEqualTo(Integer value) {
            addCriterion("HOUSE_USEAGE <>", value, "houseUseage");
            return (Criteria) this;
        }

        public Criteria andHouseUseageGreaterThan(Integer value) {
            addCriterion("HOUSE_USEAGE >", value, "houseUseage");
            return (Criteria) this;
        }

        public Criteria andHouseUseageGreaterThanOrEqualTo(Integer value) {
            addCriterion("HOUSE_USEAGE >=", value, "houseUseage");
            return (Criteria) this;
        }

        public Criteria andHouseUseageLessThan(Integer value) {
            addCriterion("HOUSE_USEAGE <", value, "houseUseage");
            return (Criteria) this;
        }

        public Criteria andHouseUseageLessThanOrEqualTo(Integer value) {
            addCriterion("HOUSE_USEAGE <=", value, "houseUseage");
            return (Criteria) this;
        }

        public Criteria andHouseUseageIn(List<Integer> values) {
            addCriterion("HOUSE_USEAGE in", values, "houseUseage");
            return (Criteria) this;
        }

        public Criteria andHouseUseageNotIn(List<Integer> values) {
            addCriterion("HOUSE_USEAGE not in", values, "houseUseage");
            return (Criteria) this;
        }

        public Criteria andHouseUseageBetween(Integer value1, Integer value2) {
            addCriterion("HOUSE_USEAGE between", value1, value2, "houseUseage");
            return (Criteria) this;
        }

        public Criteria andHouseUseageNotBetween(Integer value1, Integer value2) {
            addCriterion("HOUSE_USEAGE not between", value1, value2, "houseUseage");
            return (Criteria) this;
        }

        public Criteria andStatuNowIsNull() {
            addCriterion("STATU_NOW is null");
            return (Criteria) this;
        }

        public Criteria andStatuNowIsNotNull() {
            addCriterion("STATU_NOW is not null");
            return (Criteria) this;
        }

        public Criteria andStatuNowEqualTo(Integer value) {
            addCriterion("STATU_NOW =", value, "statuNow");
            return (Criteria) this;
        }

        public Criteria andStatuNowNotEqualTo(Integer value) {
            addCriterion("STATU_NOW <>", value, "statuNow");
            return (Criteria) this;
        }

        public Criteria andStatuNowGreaterThan(Integer value) {
            addCriterion("STATU_NOW >", value, "statuNow");
            return (Criteria) this;
        }

        public Criteria andStatuNowGreaterThanOrEqualTo(Integer value) {
            addCriterion("STATU_NOW >=", value, "statuNow");
            return (Criteria) this;
        }

        public Criteria andStatuNowLessThan(Integer value) {
            addCriterion("STATU_NOW <", value, "statuNow");
            return (Criteria) this;
        }

        public Criteria andStatuNowLessThanOrEqualTo(Integer value) {
            addCriterion("STATU_NOW <=", value, "statuNow");
            return (Criteria) this;
        }

        public Criteria andStatuNowIn(List<Integer> values) {
            addCriterion("STATU_NOW in", values, "statuNow");
            return (Criteria) this;
        }

        public Criteria andStatuNowNotIn(List<Integer> values) {
            addCriterion("STATU_NOW not in", values, "statuNow");
            return (Criteria) this;
        }

        public Criteria andStatuNowBetween(Integer value1, Integer value2) {
            addCriterion("STATU_NOW between", value1, value2, "statuNow");
            return (Criteria) this;
        }

        public Criteria andStatuNowNotBetween(Integer value1, Integer value2) {
            addCriterion("STATU_NOW not between", value1, value2, "statuNow");
            return (Criteria) this;
        }

        public Criteria andSiteHouseIdIsNull() {
            addCriterion("SITE_HOUSE_ID is null");
            return (Criteria) this;
        }

        public Criteria andSiteHouseIdIsNotNull() {
            addCriterion("SITE_HOUSE_ID is not null");
            return (Criteria) this;
        }

        public Criteria andSiteHouseIdEqualTo(String value) {
            addCriterion("SITE_HOUSE_ID =", value, "siteHouseId");
            return (Criteria) this;
        }

        public Criteria andSiteHouseIdNotEqualTo(String value) {
            addCriterion("SITE_HOUSE_ID <>", value, "siteHouseId");
            return (Criteria) this;
        }

        public Criteria andSiteHouseIdGreaterThan(String value) {
            addCriterion("SITE_HOUSE_ID >", value, "siteHouseId");
            return (Criteria) this;
        }

        public Criteria andSiteHouseIdGreaterThanOrEqualTo(String value) {
            addCriterion("SITE_HOUSE_ID >=", value, "siteHouseId");
            return (Criteria) this;
        }

        public Criteria andSiteHouseIdLessThan(String value) {
            addCriterion("SITE_HOUSE_ID <", value, "siteHouseId");
            return (Criteria) this;
        }

        public Criteria andSiteHouseIdLessThanOrEqualTo(String value) {
            addCriterion("SITE_HOUSE_ID <=", value, "siteHouseId");
            return (Criteria) this;
        }

        public Criteria andSiteHouseIdLike(String value) {
            addCriterion("SITE_HOUSE_ID like", value, "siteHouseId");
            return (Criteria) this;
        }

        public Criteria andSiteHouseIdNotLike(String value) {
            addCriterion("SITE_HOUSE_ID not like", value, "siteHouseId");
            return (Criteria) this;
        }

        public Criteria andSiteHouseIdIn(List<String> values) {
            addCriterion("SITE_HOUSE_ID in", values, "siteHouseId");
            return (Criteria) this;
        }

        public Criteria andSiteHouseIdNotIn(List<String> values) {
            addCriterion("SITE_HOUSE_ID not in", values, "siteHouseId");
            return (Criteria) this;
        }

        public Criteria andSiteHouseIdBetween(String value1, String value2) {
            addCriterion("SITE_HOUSE_ID between", value1, value2, "siteHouseId");
            return (Criteria) this;
        }

        public Criteria andSiteHouseIdNotBetween(String value1, String value2) {
            addCriterion("SITE_HOUSE_ID not between", value1, value2, "siteHouseId");
            return (Criteria) this;
        }

        public Criteria andLastDoneTimeIsNull() {
            addCriterion("LAST_DONE_TIME is null");
            return (Criteria) this;
        }

        public Criteria andLastDoneTimeIsNotNull() {
            addCriterion("LAST_DONE_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andLastDoneTimeEqualTo(Date value) {
            addCriterion("LAST_DONE_TIME =", value, "lastDoneTime");
            return (Criteria) this;
        }

        public Criteria andLastDoneTimeNotEqualTo(Date value) {
            addCriterion("LAST_DONE_TIME <>", value, "lastDoneTime");
            return (Criteria) this;
        }

        public Criteria andLastDoneTimeGreaterThan(Date value) {
            addCriterion("LAST_DONE_TIME >", value, "lastDoneTime");
            return (Criteria) this;
        }

        public Criteria andLastDoneTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("LAST_DONE_TIME >=", value, "lastDoneTime");
            return (Criteria) this;
        }

        public Criteria andLastDoneTimeLessThan(Date value) {
            addCriterion("LAST_DONE_TIME <", value, "lastDoneTime");
            return (Criteria) this;
        }

        public Criteria andLastDoneTimeLessThanOrEqualTo(Date value) {
            addCriterion("LAST_DONE_TIME <=", value, "lastDoneTime");
            return (Criteria) this;
        }

        public Criteria andLastDoneTimeIn(List<Date> values) {
            addCriterion("LAST_DONE_TIME in", values, "lastDoneTime");
            return (Criteria) this;
        }

        public Criteria andLastDoneTimeNotIn(List<Date> values) {
            addCriterion("LAST_DONE_TIME not in", values, "lastDoneTime");
            return (Criteria) this;
        }

        public Criteria andLastDoneTimeBetween(Date value1, Date value2) {
            addCriterion("LAST_DONE_TIME between", value1, value2, "lastDoneTime");
            return (Criteria) this;
        }

        public Criteria andLastDoneTimeNotBetween(Date value1, Date value2) {
            addCriterion("LAST_DONE_TIME not between", value1, value2, "lastDoneTime");
            return (Criteria) this;
        }

        public Criteria andEditIdIsNull() {
            addCriterion("EDIT_ID is null");
            return (Criteria) this;
        }

        public Criteria andEditIdIsNotNull() {
            addCriterion("EDIT_ID is not null");
            return (Criteria) this;
        }

        public Criteria andEditIdEqualTo(String value) {
            addCriterion("EDIT_ID =", value, "editId");
            return (Criteria) this;
        }

        public Criteria andEditIdNotEqualTo(String value) {
            addCriterion("EDIT_ID <>", value, "editId");
            return (Criteria) this;
        }

        public Criteria andEditIdGreaterThan(String value) {
            addCriterion("EDIT_ID >", value, "editId");
            return (Criteria) this;
        }

        public Criteria andEditIdGreaterThanOrEqualTo(String value) {
            addCriterion("EDIT_ID >=", value, "editId");
            return (Criteria) this;
        }

        public Criteria andEditIdLessThan(String value) {
            addCriterion("EDIT_ID <", value, "editId");
            return (Criteria) this;
        }

        public Criteria andEditIdLessThanOrEqualTo(String value) {
            addCriterion("EDIT_ID <=", value, "editId");
            return (Criteria) this;
        }

        public Criteria andEditIdLike(String value) {
            addCriterion("EDIT_ID like", value, "editId");
            return (Criteria) this;
        }

        public Criteria andEditIdNotLike(String value) {
            addCriterion("EDIT_ID not like", value, "editId");
            return (Criteria) this;
        }

        public Criteria andEditIdIn(List<String> values) {
            addCriterion("EDIT_ID in", values, "editId");
            return (Criteria) this;
        }

        public Criteria andEditIdNotIn(List<String> values) {
            addCriterion("EDIT_ID not in", values, "editId");
            return (Criteria) this;
        }

        public Criteria andEditIdBetween(String value1, String value2) {
            addCriterion("EDIT_ID between", value1, value2, "editId");
            return (Criteria) this;
        }

        public Criteria andEditIdNotBetween(String value1, String value2) {
            addCriterion("EDIT_ID not between", value1, value2, "editId");
            return (Criteria) this;
        }

        public Criteria andDeleteIdIsNull() {
            addCriterion("DELETE_ID is null");
            return (Criteria) this;
        }

        public Criteria andDeleteIdIsNotNull() {
            addCriterion("DELETE_ID is not null");
            return (Criteria) this;
        }

        public Criteria andDeleteIdEqualTo(String value) {
            addCriterion("DELETE_ID =", value, "deleteId");
            return (Criteria) this;
        }

        public Criteria andDeleteIdNotEqualTo(String value) {
            addCriterion("DELETE_ID <>", value, "deleteId");
            return (Criteria) this;
        }

        public Criteria andDeleteIdGreaterThan(String value) {
            addCriterion("DELETE_ID >", value, "deleteId");
            return (Criteria) this;
        }

        public Criteria andDeleteIdGreaterThanOrEqualTo(String value) {
            addCriterion("DELETE_ID >=", value, "deleteId");
            return (Criteria) this;
        }

        public Criteria andDeleteIdLessThan(String value) {
            addCriterion("DELETE_ID <", value, "deleteId");
            return (Criteria) this;
        }

        public Criteria andDeleteIdLessThanOrEqualTo(String value) {
            addCriterion("DELETE_ID <=", value, "deleteId");
            return (Criteria) this;
        }

        public Criteria andDeleteIdLike(String value) {
            addCriterion("DELETE_ID like", value, "deleteId");
            return (Criteria) this;
        }

        public Criteria andDeleteIdNotLike(String value) {
            addCriterion("DELETE_ID not like", value, "deleteId");
            return (Criteria) this;
        }

        public Criteria andDeleteIdIn(List<String> values) {
            addCriterion("DELETE_ID in", values, "deleteId");
            return (Criteria) this;
        }

        public Criteria andDeleteIdNotIn(List<String> values) {
            addCriterion("DELETE_ID not in", values, "deleteId");
            return (Criteria) this;
        }

        public Criteria andDeleteIdBetween(String value1, String value2) {
            addCriterion("DELETE_ID between", value1, value2, "deleteId");
            return (Criteria) this;
        }

        public Criteria andDeleteIdNotBetween(String value1, String value2) {
            addCriterion("DELETE_ID not between", value1, value2, "deleteId");
            return (Criteria) this;
        }

        public Criteria andSynrandIsNull() {
            addCriterion("SYNRAND is null");
            return (Criteria) this;
        }

        public Criteria andSynrandIsNotNull() {
            addCriterion("SYNRAND is not null");
            return (Criteria) this;
        }

        public Criteria andSynrandEqualTo(Short value) {
            addCriterion("SYNRAND =", value, "synrand");
            return (Criteria) this;
        }

        public Criteria andSynrandNotEqualTo(Short value) {
            addCriterion("SYNRAND <>", value, "synrand");
            return (Criteria) this;
        }

        public Criteria andSynrandGreaterThan(Short value) {
            addCriterion("SYNRAND >", value, "synrand");
            return (Criteria) this;
        }

        public Criteria andSynrandGreaterThanOrEqualTo(Short value) {
            addCriterion("SYNRAND >=", value, "synrand");
            return (Criteria) this;
        }

        public Criteria andSynrandLessThan(Short value) {
            addCriterion("SYNRAND <", value, "synrand");
            return (Criteria) this;
        }

        public Criteria andSynrandLessThanOrEqualTo(Short value) {
            addCriterion("SYNRAND <=", value, "synrand");
            return (Criteria) this;
        }

        public Criteria andSynrandIn(List<Short> values) {
            addCriterion("SYNRAND in", values, "synrand");
            return (Criteria) this;
        }

        public Criteria andSynrandNotIn(List<Short> values) {
            addCriterion("SYNRAND not in", values, "synrand");
            return (Criteria) this;
        }

        public Criteria andSynrandBetween(Short value1, Short value2) {
            addCriterion("SYNRAND between", value1, value2, "synrand");
            return (Criteria) this;
        }

        public Criteria andSynrandNotBetween(Short value1, Short value2) {
            addCriterion("SYNRAND not between", value1, value2, "synrand");
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

        public Criteria andCompNoIsNull() {
            addCriterion("COMP_NO is null");
            return (Criteria) this;
        }

        public Criteria andCompNoIsNotNull() {
            addCriterion("COMP_NO is not null");
            return (Criteria) this;
        }

        public Criteria andCompNoEqualTo(String value) {
            addCriterion("COMP_NO =", value, "compNo");
            return (Criteria) this;
        }

        public Criteria andCompNoNotEqualTo(String value) {
            addCriterion("COMP_NO <>", value, "compNo");
            return (Criteria) this;
        }

        public Criteria andCompNoGreaterThan(String value) {
            addCriterion("COMP_NO >", value, "compNo");
            return (Criteria) this;
        }

        public Criteria andCompNoGreaterThanOrEqualTo(String value) {
            addCriterion("COMP_NO >=", value, "compNo");
            return (Criteria) this;
        }

        public Criteria andCompNoLessThan(String value) {
            addCriterion("COMP_NO <", value, "compNo");
            return (Criteria) this;
        }

        public Criteria andCompNoLessThanOrEqualTo(String value) {
            addCriterion("COMP_NO <=", value, "compNo");
            return (Criteria) this;
        }

        public Criteria andCompNoLike(String value) {
            addCriterion("COMP_NO like", value, "compNo");
            return (Criteria) this;
        }

        public Criteria andCompNoNotLike(String value) {
            addCriterion("COMP_NO not like", value, "compNo");
            return (Criteria) this;
        }

        public Criteria andCompNoIn(List<String> values) {
            addCriterion("COMP_NO in", values, "compNo");
            return (Criteria) this;
        }

        public Criteria andCompNoNotIn(List<String> values) {
            addCriterion("COMP_NO not in", values, "compNo");
            return (Criteria) this;
        }

        public Criteria andCompNoBetween(String value1, String value2) {
            addCriterion("COMP_NO between", value1, value2, "compNo");
            return (Criteria) this;
        }

        public Criteria andCompNoNotBetween(String value1, String value2) {
            addCriterion("COMP_NO not between", value1, value2, "compNo");
            return (Criteria) this;
        }

        public Criteria andActionOperIsNull() {
            addCriterion("ACTION_OPER is null");
            return (Criteria) this;
        }

        public Criteria andActionOperIsNotNull() {
            addCriterion("ACTION_OPER is not null");
            return (Criteria) this;
        }

        public Criteria andActionOperEqualTo(Byte value) {
            addCriterion("ACTION_OPER =", value, "actionOper");
            return (Criteria) this;
        }

        public Criteria andActionOperNotEqualTo(Byte value) {
            addCriterion("ACTION_OPER <>", value, "actionOper");
            return (Criteria) this;
        }

        public Criteria andActionOperGreaterThan(Byte value) {
            addCriterion("ACTION_OPER >", value, "actionOper");
            return (Criteria) this;
        }

        public Criteria andActionOperGreaterThanOrEqualTo(Byte value) {
            addCriterion("ACTION_OPER >=", value, "actionOper");
            return (Criteria) this;
        }

        public Criteria andActionOperLessThan(Byte value) {
            addCriterion("ACTION_OPER <", value, "actionOper");
            return (Criteria) this;
        }

        public Criteria andActionOperLessThanOrEqualTo(Byte value) {
            addCriterion("ACTION_OPER <=", value, "actionOper");
            return (Criteria) this;
        }

        public Criteria andActionOperIn(List<Byte> values) {
            addCriterion("ACTION_OPER in", values, "actionOper");
            return (Criteria) this;
        }

        public Criteria andActionOperNotIn(List<Byte> values) {
            addCriterion("ACTION_OPER not in", values, "actionOper");
            return (Criteria) this;
        }

        public Criteria andActionOperBetween(Byte value1, Byte value2) {
            addCriterion("ACTION_OPER between", value1, value2, "actionOper");
            return (Criteria) this;
        }

        public Criteria andActionOperNotBetween(Byte value1, Byte value2) {
            addCriterion("ACTION_OPER not between", value1, value2, "actionOper");
            return (Criteria) this;
        }

        public Criteria andTaskIdIsNull() {
            addCriterion("TASK_ID is null");
            return (Criteria) this;
        }

        public Criteria andTaskIdIsNotNull() {
            addCriterion("TASK_ID is not null");
            return (Criteria) this;
        }

        public Criteria andTaskIdEqualTo(String value) {
            addCriterion("TASK_ID =", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdNotEqualTo(String value) {
            addCriterion("TASK_ID <>", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdGreaterThan(String value) {
            addCriterion("TASK_ID >", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdGreaterThanOrEqualTo(String value) {
            addCriterion("TASK_ID >=", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdLessThan(String value) {
            addCriterion("TASK_ID <", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdLessThanOrEqualTo(String value) {
            addCriterion("TASK_ID <=", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdLike(String value) {
            addCriterion("TASK_ID like", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdNotLike(String value) {
            addCriterion("TASK_ID not like", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdIn(List<String> values) {
            addCriterion("TASK_ID in", values, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdNotIn(List<String> values) {
            addCriterion("TASK_ID not in", values, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdBetween(String value1, String value2) {
            addCriterion("TASK_ID between", value1, value2, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdNotBetween(String value1, String value2) {
            addCriterion("TASK_ID not between", value1, value2, "taskId");
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