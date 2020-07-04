package com.myfun.repository.admindb.po;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AdminFddCityExample {
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
    public AdminFddCityExample() {
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

        public Criteria andFddCityIdIsNull() {
            addCriterion("FDD_CITY_ID is null");
            return (Criteria) this;
        }

        public Criteria andFddCityIdIsNotNull() {
            addCriterion("FDD_CITY_ID is not null");
            return (Criteria) this;
        }

        public Criteria andFddCityIdEqualTo(Integer value) {
            addCriterion("FDD_CITY_ID =", value, "fddCityId");
            return (Criteria) this;
        }

        public Criteria andFddCityIdNotEqualTo(Integer value) {
            addCriterion("FDD_CITY_ID <>", value, "fddCityId");
            return (Criteria) this;
        }

        public Criteria andFddCityIdGreaterThan(Integer value) {
            addCriterion("FDD_CITY_ID >", value, "fddCityId");
            return (Criteria) this;
        }

        public Criteria andFddCityIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("FDD_CITY_ID >=", value, "fddCityId");
            return (Criteria) this;
        }

        public Criteria andFddCityIdLessThan(Integer value) {
            addCriterion("FDD_CITY_ID <", value, "fddCityId");
            return (Criteria) this;
        }

        public Criteria andFddCityIdLessThanOrEqualTo(Integer value) {
            addCriterion("FDD_CITY_ID <=", value, "fddCityId");
            return (Criteria) this;
        }

        public Criteria andFddCityIdIn(List<Integer> values) {
            addCriterion("FDD_CITY_ID in", values, "fddCityId");
            return (Criteria) this;
        }

        public Criteria andFddCityIdNotIn(List<Integer> values) {
            addCriterion("FDD_CITY_ID not in", values, "fddCityId");
            return (Criteria) this;
        }

        public Criteria andFddCityIdBetween(Integer value1, Integer value2) {
            addCriterion("FDD_CITY_ID between", value1, value2, "fddCityId");
            return (Criteria) this;
        }

        public Criteria andFddCityIdNotBetween(Integer value1, Integer value2) {
            addCriterion("FDD_CITY_ID not between", value1, value2, "fddCityId");
            return (Criteria) this;
        }

        public Criteria andFddCityNameIsNull() {
            addCriterion("FDD_CITY_NAME is null");
            return (Criteria) this;
        }

        public Criteria andFddCityNameIsNotNull() {
            addCriterion("FDD_CITY_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andFddCityNameEqualTo(String value) {
            addCriterion("FDD_CITY_NAME =", value, "fddCityName");
            return (Criteria) this;
        }

        public Criteria andFddCityNameNotEqualTo(String value) {
            addCriterion("FDD_CITY_NAME <>", value, "fddCityName");
            return (Criteria) this;
        }

        public Criteria andFddCityNameGreaterThan(String value) {
            addCriterion("FDD_CITY_NAME >", value, "fddCityName");
            return (Criteria) this;
        }

        public Criteria andFddCityNameGreaterThanOrEqualTo(String value) {
            addCriterion("FDD_CITY_NAME >=", value, "fddCityName");
            return (Criteria) this;
        }

        public Criteria andFddCityNameLessThan(String value) {
            addCriterion("FDD_CITY_NAME <", value, "fddCityName");
            return (Criteria) this;
        }

        public Criteria andFddCityNameLessThanOrEqualTo(String value) {
            addCriterion("FDD_CITY_NAME <=", value, "fddCityName");
            return (Criteria) this;
        }

        public Criteria andFddCityNameLike(String value) {
            addCriterion("FDD_CITY_NAME like", value, "fddCityName");
            return (Criteria) this;
        }

        public Criteria andFddCityNameNotLike(String value) {
            addCriterion("FDD_CITY_NAME not like", value, "fddCityName");
            return (Criteria) this;
        }

        public Criteria andFddCityNameIn(List<String> values) {
            addCriterion("FDD_CITY_NAME in", values, "fddCityName");
            return (Criteria) this;
        }

        public Criteria andFddCityNameNotIn(List<String> values) {
            addCriterion("FDD_CITY_NAME not in", values, "fddCityName");
            return (Criteria) this;
        }

        public Criteria andFddCityNameBetween(String value1, String value2) {
            addCriterion("FDD_CITY_NAME between", value1, value2, "fddCityName");
            return (Criteria) this;
        }

        public Criteria andFddCityNameNotBetween(String value1, String value2) {
            addCriterion("FDD_CITY_NAME not between", value1, value2, "fddCityName");
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

        public Criteria andHftCityIdIsNull() {
            addCriterion("HFT_CITY_ID is null");
            return (Criteria) this;
        }

        public Criteria andHftCityIdIsNotNull() {
            addCriterion("HFT_CITY_ID is not null");
            return (Criteria) this;
        }

        public Criteria andHftCityIdEqualTo(Integer value) {
            addCriterion("HFT_CITY_ID =", value, "hftCityId");
            return (Criteria) this;
        }

        public Criteria andHftCityIdNotEqualTo(Integer value) {
            addCriterion("HFT_CITY_ID <>", value, "hftCityId");
            return (Criteria) this;
        }

        public Criteria andHftCityIdGreaterThan(Integer value) {
            addCriterion("HFT_CITY_ID >", value, "hftCityId");
            return (Criteria) this;
        }

        public Criteria andHftCityIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("HFT_CITY_ID >=", value, "hftCityId");
            return (Criteria) this;
        }

        public Criteria andHftCityIdLessThan(Integer value) {
            addCriterion("HFT_CITY_ID <", value, "hftCityId");
            return (Criteria) this;
        }

        public Criteria andHftCityIdLessThanOrEqualTo(Integer value) {
            addCriterion("HFT_CITY_ID <=", value, "hftCityId");
            return (Criteria) this;
        }

        public Criteria andHftCityIdIn(List<Integer> values) {
            addCriterion("HFT_CITY_ID in", values, "hftCityId");
            return (Criteria) this;
        }

        public Criteria andHftCityIdNotIn(List<Integer> values) {
            addCriterion("HFT_CITY_ID not in", values, "hftCityId");
            return (Criteria) this;
        }

        public Criteria andHftCityIdBetween(Integer value1, Integer value2) {
            addCriterion("HFT_CITY_ID between", value1, value2, "hftCityId");
            return (Criteria) this;
        }

        public Criteria andHftCityIdNotBetween(Integer value1, Integer value2) {
            addCriterion("HFT_CITY_ID not between", value1, value2, "hftCityId");
            return (Criteria) this;
        }

        public Criteria andOpenFddFlagIsNull() {
            addCriterion("OPEN_FDD_FLAG is null");
            return (Criteria) this;
        }

        public Criteria andOpenFddFlagIsNotNull() {
            addCriterion("OPEN_FDD_FLAG is not null");
            return (Criteria) this;
        }

        public Criteria andOpenFddFlagEqualTo(Byte value) {
            addCriterion("OPEN_FDD_FLAG =", value, "openFddFlag");
            return (Criteria) this;
        }

        public Criteria andOpenFddFlagNotEqualTo(Byte value) {
            addCriterion("OPEN_FDD_FLAG <>", value, "openFddFlag");
            return (Criteria) this;
        }

        public Criteria andOpenFddFlagGreaterThan(Byte value) {
            addCriterion("OPEN_FDD_FLAG >", value, "openFddFlag");
            return (Criteria) this;
        }

        public Criteria andOpenFddFlagGreaterThanOrEqualTo(Byte value) {
            addCriterion("OPEN_FDD_FLAG >=", value, "openFddFlag");
            return (Criteria) this;
        }

        public Criteria andOpenFddFlagLessThan(Byte value) {
            addCriterion("OPEN_FDD_FLAG <", value, "openFddFlag");
            return (Criteria) this;
        }

        public Criteria andOpenFddFlagLessThanOrEqualTo(Byte value) {
            addCriterion("OPEN_FDD_FLAG <=", value, "openFddFlag");
            return (Criteria) this;
        }

        public Criteria andOpenFddFlagIn(List<Byte> values) {
            addCriterion("OPEN_FDD_FLAG in", values, "openFddFlag");
            return (Criteria) this;
        }

        public Criteria andOpenFddFlagNotIn(List<Byte> values) {
            addCriterion("OPEN_FDD_FLAG not in", values, "openFddFlag");
            return (Criteria) this;
        }

        public Criteria andOpenFddFlagBetween(Byte value1, Byte value2) {
            addCriterion("OPEN_FDD_FLAG between", value1, value2, "openFddFlag");
            return (Criteria) this;
        }

        public Criteria andOpenFddFlagNotBetween(Byte value1, Byte value2) {
            addCriterion("OPEN_FDD_FLAG not between", value1, value2, "openFddFlag");
            return (Criteria) this;
        }

        public Criteria andHouseToplineIsNull() {
            addCriterion("HOUSE_TOPLINE is null");
            return (Criteria) this;
        }

        public Criteria andHouseToplineIsNotNull() {
            addCriterion("HOUSE_TOPLINE is not null");
            return (Criteria) this;
        }

        public Criteria andHouseToplineEqualTo(Byte value) {
            addCriterion("HOUSE_TOPLINE =", value, "houseTopline");
            return (Criteria) this;
        }

        public Criteria andHouseToplineNotEqualTo(Byte value) {
            addCriterion("HOUSE_TOPLINE <>", value, "houseTopline");
            return (Criteria) this;
        }

        public Criteria andHouseToplineGreaterThan(Byte value) {
            addCriterion("HOUSE_TOPLINE >", value, "houseTopline");
            return (Criteria) this;
        }

        public Criteria andHouseToplineGreaterThanOrEqualTo(Byte value) {
            addCriterion("HOUSE_TOPLINE >=", value, "houseTopline");
            return (Criteria) this;
        }

        public Criteria andHouseToplineLessThan(Byte value) {
            addCriterion("HOUSE_TOPLINE <", value, "houseTopline");
            return (Criteria) this;
        }

        public Criteria andHouseToplineLessThanOrEqualTo(Byte value) {
            addCriterion("HOUSE_TOPLINE <=", value, "houseTopline");
            return (Criteria) this;
        }

        public Criteria andHouseToplineIn(List<Byte> values) {
            addCriterion("HOUSE_TOPLINE in", values, "houseTopline");
            return (Criteria) this;
        }

        public Criteria andHouseToplineNotIn(List<Byte> values) {
            addCriterion("HOUSE_TOPLINE not in", values, "houseTopline");
            return (Criteria) this;
        }

        public Criteria andHouseToplineBetween(Byte value1, Byte value2) {
            addCriterion("HOUSE_TOPLINE between", value1, value2, "houseTopline");
            return (Criteria) this;
        }

        public Criteria andHouseToplineNotBetween(Byte value1, Byte value2) {
            addCriterion("HOUSE_TOPLINE not between", value1, value2, "houseTopline");
            return (Criteria) this;
        }

        public Criteria andBuildRedpacketIsNull() {
            addCriterion("BUILD_REDPACKET is null");
            return (Criteria) this;
        }

        public Criteria andBuildRedpacketIsNotNull() {
            addCriterion("BUILD_REDPACKET is not null");
            return (Criteria) this;
        }

        public Criteria andBuildRedpacketEqualTo(Byte value) {
            addCriterion("BUILD_REDPACKET =", value, "buildRedpacket");
            return (Criteria) this;
        }

        public Criteria andBuildRedpacketNotEqualTo(Byte value) {
            addCriterion("BUILD_REDPACKET <>", value, "buildRedpacket");
            return (Criteria) this;
        }

        public Criteria andBuildRedpacketGreaterThan(Byte value) {
            addCriterion("BUILD_REDPACKET >", value, "buildRedpacket");
            return (Criteria) this;
        }

        public Criteria andBuildRedpacketGreaterThanOrEqualTo(Byte value) {
            addCriterion("BUILD_REDPACKET >=", value, "buildRedpacket");
            return (Criteria) this;
        }

        public Criteria andBuildRedpacketLessThan(Byte value) {
            addCriterion("BUILD_REDPACKET <", value, "buildRedpacket");
            return (Criteria) this;
        }

        public Criteria andBuildRedpacketLessThanOrEqualTo(Byte value) {
            addCriterion("BUILD_REDPACKET <=", value, "buildRedpacket");
            return (Criteria) this;
        }

        public Criteria andBuildRedpacketIn(List<Byte> values) {
            addCriterion("BUILD_REDPACKET in", values, "buildRedpacket");
            return (Criteria) this;
        }

        public Criteria andBuildRedpacketNotIn(List<Byte> values) {
            addCriterion("BUILD_REDPACKET not in", values, "buildRedpacket");
            return (Criteria) this;
        }

        public Criteria andBuildRedpacketBetween(Byte value1, Byte value2) {
            addCriterion("BUILD_REDPACKET between", value1, value2, "buildRedpacket");
            return (Criteria) this;
        }

        public Criteria andBuildRedpacketNotBetween(Byte value1, Byte value2) {
            addCriterion("BUILD_REDPACKET not between", value1, value2, "buildRedpacket");
            return (Criteria) this;
        }

        public Criteria andNewHouseSaleIsNull() {
            addCriterion("NEW_HOUSE_SALE is null");
            return (Criteria) this;
        }

        public Criteria andNewHouseSaleIsNotNull() {
            addCriterion("NEW_HOUSE_SALE is not null");
            return (Criteria) this;
        }

        public Criteria andNewHouseSaleEqualTo(Byte value) {
            addCriterion("NEW_HOUSE_SALE =", value, "newHouseSale");
            return (Criteria) this;
        }

        public Criteria andNewHouseSaleNotEqualTo(Byte value) {
            addCriterion("NEW_HOUSE_SALE <>", value, "newHouseSale");
            return (Criteria) this;
        }

        public Criteria andNewHouseSaleGreaterThan(Byte value) {
            addCriterion("NEW_HOUSE_SALE >", value, "newHouseSale");
            return (Criteria) this;
        }

        public Criteria andNewHouseSaleGreaterThanOrEqualTo(Byte value) {
            addCriterion("NEW_HOUSE_SALE >=", value, "newHouseSale");
            return (Criteria) this;
        }

        public Criteria andNewHouseSaleLessThan(Byte value) {
            addCriterion("NEW_HOUSE_SALE <", value, "newHouseSale");
            return (Criteria) this;
        }

        public Criteria andNewHouseSaleLessThanOrEqualTo(Byte value) {
            addCriterion("NEW_HOUSE_SALE <=", value, "newHouseSale");
            return (Criteria) this;
        }

        public Criteria andNewHouseSaleIn(List<Byte> values) {
            addCriterion("NEW_HOUSE_SALE in", values, "newHouseSale");
            return (Criteria) this;
        }

        public Criteria andNewHouseSaleNotIn(List<Byte> values) {
            addCriterion("NEW_HOUSE_SALE not in", values, "newHouseSale");
            return (Criteria) this;
        }

        public Criteria andNewHouseSaleBetween(Byte value1, Byte value2) {
            addCriterion("NEW_HOUSE_SALE between", value1, value2, "newHouseSale");
            return (Criteria) this;
        }

        public Criteria andNewHouseSaleNotBetween(Byte value1, Byte value2) {
            addCriterion("NEW_HOUSE_SALE not between", value1, value2, "newHouseSale");
            return (Criteria) this;
        }

        public Criteria andBuyPreCardIsNull() {
            addCriterion("BUY_PRE_CARD is null");
            return (Criteria) this;
        }

        public Criteria andBuyPreCardIsNotNull() {
            addCriterion("BUY_PRE_CARD is not null");
            return (Criteria) this;
        }

        public Criteria andBuyPreCardEqualTo(Byte value) {
            addCriterion("BUY_PRE_CARD =", value, "buyPreCard");
            return (Criteria) this;
        }

        public Criteria andBuyPreCardNotEqualTo(Byte value) {
            addCriterion("BUY_PRE_CARD <>", value, "buyPreCard");
            return (Criteria) this;
        }

        public Criteria andBuyPreCardGreaterThan(Byte value) {
            addCriterion("BUY_PRE_CARD >", value, "buyPreCard");
            return (Criteria) this;
        }

        public Criteria andBuyPreCardGreaterThanOrEqualTo(Byte value) {
            addCriterion("BUY_PRE_CARD >=", value, "buyPreCard");
            return (Criteria) this;
        }

        public Criteria andBuyPreCardLessThan(Byte value) {
            addCriterion("BUY_PRE_CARD <", value, "buyPreCard");
            return (Criteria) this;
        }

        public Criteria andBuyPreCardLessThanOrEqualTo(Byte value) {
            addCriterion("BUY_PRE_CARD <=", value, "buyPreCard");
            return (Criteria) this;
        }

        public Criteria andBuyPreCardIn(List<Byte> values) {
            addCriterion("BUY_PRE_CARD in", values, "buyPreCard");
            return (Criteria) this;
        }

        public Criteria andBuyPreCardNotIn(List<Byte> values) {
            addCriterion("BUY_PRE_CARD not in", values, "buyPreCard");
            return (Criteria) this;
        }

        public Criteria andBuyPreCardBetween(Byte value1, Byte value2) {
            addCriterion("BUY_PRE_CARD between", value1, value2, "buyPreCard");
            return (Criteria) this;
        }

        public Criteria andBuyPreCardNotBetween(Byte value1, Byte value2) {
            addCriterion("BUY_PRE_CARD not between", value1, value2, "buyPreCard");
            return (Criteria) this;
        }

        public Criteria andOpenFddIconIsNull() {
            addCriterion("OPEN_FDD_ICON is null");
            return (Criteria) this;
        }

        public Criteria andOpenFddIconIsNotNull() {
            addCriterion("OPEN_FDD_ICON is not null");
            return (Criteria) this;
        }

        public Criteria andOpenFddIconEqualTo(Byte value) {
            addCriterion("OPEN_FDD_ICON =", value, "openFddIcon");
            return (Criteria) this;
        }

        public Criteria andOpenFddIconNotEqualTo(Byte value) {
            addCriterion("OPEN_FDD_ICON <>", value, "openFddIcon");
            return (Criteria) this;
        }

        public Criteria andOpenFddIconGreaterThan(Byte value) {
            addCriterion("OPEN_FDD_ICON >", value, "openFddIcon");
            return (Criteria) this;
        }

        public Criteria andOpenFddIconGreaterThanOrEqualTo(Byte value) {
            addCriterion("OPEN_FDD_ICON >=", value, "openFddIcon");
            return (Criteria) this;
        }

        public Criteria andOpenFddIconLessThan(Byte value) {
            addCriterion("OPEN_FDD_ICON <", value, "openFddIcon");
            return (Criteria) this;
        }

        public Criteria andOpenFddIconLessThanOrEqualTo(Byte value) {
            addCriterion("OPEN_FDD_ICON <=", value, "openFddIcon");
            return (Criteria) this;
        }

        public Criteria andOpenFddIconIn(List<Byte> values) {
            addCriterion("OPEN_FDD_ICON in", values, "openFddIcon");
            return (Criteria) this;
        }

        public Criteria andOpenFddIconNotIn(List<Byte> values) {
            addCriterion("OPEN_FDD_ICON not in", values, "openFddIcon");
            return (Criteria) this;
        }

        public Criteria andOpenFddIconBetween(Byte value1, Byte value2) {
            addCriterion("OPEN_FDD_ICON between", value1, value2, "openFddIcon");
            return (Criteria) this;
        }

        public Criteria andOpenFddIconNotBetween(Byte value1, Byte value2) {
            addCriterion("OPEN_FDD_ICON not between", value1, value2, "openFddIcon");
            return (Criteria) this;
        }

        public Criteria andIsOpenFddIsNull() {
            addCriterion("IS_OPEN_FDD is null");
            return (Criteria) this;
        }

        public Criteria andIsOpenFddIsNotNull() {
            addCriterion("IS_OPEN_FDD is not null");
            return (Criteria) this;
        }

        public Criteria andIsOpenFddEqualTo(Byte value) {
            addCriterion("IS_OPEN_FDD =", value, "isOpenFdd");
            return (Criteria) this;
        }

        public Criteria andIsOpenFddNotEqualTo(Byte value) {
            addCriterion("IS_OPEN_FDD <>", value, "isOpenFdd");
            return (Criteria) this;
        }

        public Criteria andIsOpenFddGreaterThan(Byte value) {
            addCriterion("IS_OPEN_FDD >", value, "isOpenFdd");
            return (Criteria) this;
        }

        public Criteria andIsOpenFddGreaterThanOrEqualTo(Byte value) {
            addCriterion("IS_OPEN_FDD >=", value, "isOpenFdd");
            return (Criteria) this;
        }

        public Criteria andIsOpenFddLessThan(Byte value) {
            addCriterion("IS_OPEN_FDD <", value, "isOpenFdd");
            return (Criteria) this;
        }

        public Criteria andIsOpenFddLessThanOrEqualTo(Byte value) {
            addCriterion("IS_OPEN_FDD <=", value, "isOpenFdd");
            return (Criteria) this;
        }

        public Criteria andIsOpenFddIn(List<Byte> values) {
            addCriterion("IS_OPEN_FDD in", values, "isOpenFdd");
            return (Criteria) this;
        }

        public Criteria andIsOpenFddNotIn(List<Byte> values) {
            addCriterion("IS_OPEN_FDD not in", values, "isOpenFdd");
            return (Criteria) this;
        }

        public Criteria andIsOpenFddBetween(Byte value1, Byte value2) {
            addCriterion("IS_OPEN_FDD between", value1, value2, "isOpenFdd");
            return (Criteria) this;
        }

        public Criteria andIsOpenFddNotBetween(Byte value1, Byte value2) {
            addCriterion("IS_OPEN_FDD not between", value1, value2, "isOpenFdd");
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