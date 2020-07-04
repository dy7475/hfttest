package com.myfun.repository.admindb.po;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AdminPropertyModuleControlExample {
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
    public AdminPropertyModuleControlExample() {
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

        public Criteria andPropertyIdIsNull() {
            addCriterion("PROPERTY_ID is null");
            return (Criteria) this;
        }

        public Criteria andPropertyIdIsNotNull() {
            addCriterion("PROPERTY_ID is not null");
            return (Criteria) this;
        }

        public Criteria andPropertyIdEqualTo(Integer value) {
            addCriterion("PROPERTY_ID =", value, "propertyId");
            return (Criteria) this;
        }

        public Criteria andPropertyIdNotEqualTo(Integer value) {
            addCriterion("PROPERTY_ID <>", value, "propertyId");
            return (Criteria) this;
        }

        public Criteria andPropertyIdGreaterThan(Integer value) {
            addCriterion("PROPERTY_ID >", value, "propertyId");
            return (Criteria) this;
        }

        public Criteria andPropertyIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("PROPERTY_ID >=", value, "propertyId");
            return (Criteria) this;
        }

        public Criteria andPropertyIdLessThan(Integer value) {
            addCriterion("PROPERTY_ID <", value, "propertyId");
            return (Criteria) this;
        }

        public Criteria andPropertyIdLessThanOrEqualTo(Integer value) {
            addCriterion("PROPERTY_ID <=", value, "propertyId");
            return (Criteria) this;
        }

        public Criteria andPropertyIdIn(List<Integer> values) {
            addCriterion("PROPERTY_ID in", values, "propertyId");
            return (Criteria) this;
        }

        public Criteria andPropertyIdNotIn(List<Integer> values) {
            addCriterion("PROPERTY_ID not in", values, "propertyId");
            return (Criteria) this;
        }

        public Criteria andPropertyIdBetween(Integer value1, Integer value2) {
            addCriterion("PROPERTY_ID between", value1, value2, "propertyId");
            return (Criteria) this;
        }

        public Criteria andPropertyIdNotBetween(Integer value1, Integer value2) {
            addCriterion("PROPERTY_ID not between", value1, value2, "propertyId");
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

        public Criteria andDeptNoIsNull() {
            addCriterion("DEPT_NO is null");
            return (Criteria) this;
        }

        public Criteria andDeptNoIsNotNull() {
            addCriterion("DEPT_NO is not null");
            return (Criteria) this;
        }

        public Criteria andDeptNoEqualTo(String value) {
            addCriterion("DEPT_NO =", value, "deptNo");
            return (Criteria) this;
        }

        public Criteria andDeptNoNotEqualTo(String value) {
            addCriterion("DEPT_NO <>", value, "deptNo");
            return (Criteria) this;
        }

        public Criteria andDeptNoGreaterThan(String value) {
            addCriterion("DEPT_NO >", value, "deptNo");
            return (Criteria) this;
        }

        public Criteria andDeptNoGreaterThanOrEqualTo(String value) {
            addCriterion("DEPT_NO >=", value, "deptNo");
            return (Criteria) this;
        }

        public Criteria andDeptNoLessThan(String value) {
            addCriterion("DEPT_NO <", value, "deptNo");
            return (Criteria) this;
        }

        public Criteria andDeptNoLessThanOrEqualTo(String value) {
            addCriterion("DEPT_NO <=", value, "deptNo");
            return (Criteria) this;
        }

        public Criteria andDeptNoLike(String value) {
            addCriterion("DEPT_NO like", value, "deptNo");
            return (Criteria) this;
        }

        public Criteria andDeptNoNotLike(String value) {
            addCriterion("DEPT_NO not like", value, "deptNo");
            return (Criteria) this;
        }

        public Criteria andDeptNoIn(List<String> values) {
            addCriterion("DEPT_NO in", values, "deptNo");
            return (Criteria) this;
        }

        public Criteria andDeptNoNotIn(List<String> values) {
            addCriterion("DEPT_NO not in", values, "deptNo");
            return (Criteria) this;
        }

        public Criteria andDeptNoBetween(String value1, String value2) {
            addCriterion("DEPT_NO between", value1, value2, "deptNo");
            return (Criteria) this;
        }

        public Criteria andDeptNoNotBetween(String value1, String value2) {
            addCriterion("DEPT_NO not between", value1, value2, "deptNo");
            return (Criteria) this;
        }

        public Criteria andCityExchangesFlagIsNull() {
            addCriterion("CITY_EXCHANGES_FLAG is null");
            return (Criteria) this;
        }

        public Criteria andCityExchangesFlagIsNotNull() {
            addCriterion("CITY_EXCHANGES_FLAG is not null");
            return (Criteria) this;
        }

        public Criteria andCityExchangesFlagEqualTo(Byte value) {
            addCriterion("CITY_EXCHANGES_FLAG =", value, "cityExchangesFlag");
            return (Criteria) this;
        }

        public Criteria andCityExchangesFlagNotEqualTo(Byte value) {
            addCriterion("CITY_EXCHANGES_FLAG <>", value, "cityExchangesFlag");
            return (Criteria) this;
        }

        public Criteria andCityExchangesFlagGreaterThan(Byte value) {
            addCriterion("CITY_EXCHANGES_FLAG >", value, "cityExchangesFlag");
            return (Criteria) this;
        }

        public Criteria andCityExchangesFlagGreaterThanOrEqualTo(Byte value) {
            addCriterion("CITY_EXCHANGES_FLAG >=", value, "cityExchangesFlag");
            return (Criteria) this;
        }

        public Criteria andCityExchangesFlagLessThan(Byte value) {
            addCriterion("CITY_EXCHANGES_FLAG <", value, "cityExchangesFlag");
            return (Criteria) this;
        }

        public Criteria andCityExchangesFlagLessThanOrEqualTo(Byte value) {
            addCriterion("CITY_EXCHANGES_FLAG <=", value, "cityExchangesFlag");
            return (Criteria) this;
        }

        public Criteria andCityExchangesFlagIn(List<Byte> values) {
            addCriterion("CITY_EXCHANGES_FLAG in", values, "cityExchangesFlag");
            return (Criteria) this;
        }

        public Criteria andCityExchangesFlagNotIn(List<Byte> values) {
            addCriterion("CITY_EXCHANGES_FLAG not in", values, "cityExchangesFlag");
            return (Criteria) this;
        }

        public Criteria andCityExchangesFlagBetween(Byte value1, Byte value2) {
            addCriterion("CITY_EXCHANGES_FLAG between", value1, value2, "cityExchangesFlag");
            return (Criteria) this;
        }

        public Criteria andCityExchangesFlagNotBetween(Byte value1, Byte value2) {
            addCriterion("CITY_EXCHANGES_FLAG not between", value1, value2, "cityExchangesFlag");
            return (Criteria) this;
        }

        public Criteria andHfSosoFlagIsNull() {
            addCriterion("HF_SOSO_FLAG is null");
            return (Criteria) this;
        }

        public Criteria andHfSosoFlagIsNotNull() {
            addCriterion("HF_SOSO_FLAG is not null");
            return (Criteria) this;
        }

        public Criteria andHfSosoFlagEqualTo(Byte value) {
            addCriterion("HF_SOSO_FLAG =", value, "hfSosoFlag");
            return (Criteria) this;
        }

        public Criteria andHfSosoFlagNotEqualTo(Byte value) {
            addCriterion("HF_SOSO_FLAG <>", value, "hfSosoFlag");
            return (Criteria) this;
        }

        public Criteria andHfSosoFlagGreaterThan(Byte value) {
            addCriterion("HF_SOSO_FLAG >", value, "hfSosoFlag");
            return (Criteria) this;
        }

        public Criteria andHfSosoFlagGreaterThanOrEqualTo(Byte value) {
            addCriterion("HF_SOSO_FLAG >=", value, "hfSosoFlag");
            return (Criteria) this;
        }

        public Criteria andHfSosoFlagLessThan(Byte value) {
            addCriterion("HF_SOSO_FLAG <", value, "hfSosoFlag");
            return (Criteria) this;
        }

        public Criteria andHfSosoFlagLessThanOrEqualTo(Byte value) {
            addCriterion("HF_SOSO_FLAG <=", value, "hfSosoFlag");
            return (Criteria) this;
        }

        public Criteria andHfSosoFlagIn(List<Byte> values) {
            addCriterion("HF_SOSO_FLAG in", values, "hfSosoFlag");
            return (Criteria) this;
        }

        public Criteria andHfSosoFlagNotIn(List<Byte> values) {
            addCriterion("HF_SOSO_FLAG not in", values, "hfSosoFlag");
            return (Criteria) this;
        }

        public Criteria andHfSosoFlagBetween(Byte value1, Byte value2) {
            addCriterion("HF_SOSO_FLAG between", value1, value2, "hfSosoFlag");
            return (Criteria) this;
        }

        public Criteria andHfSosoFlagNotBetween(Byte value1, Byte value2) {
            addCriterion("HF_SOSO_FLAG not between", value1, value2, "hfSosoFlag");
            return (Criteria) this;
        }

        public Criteria andWeiDeptFlagIsNull() {
            addCriterion("WEI_DEPT_FLAG is null");
            return (Criteria) this;
        }

        public Criteria andWeiDeptFlagIsNotNull() {
            addCriterion("WEI_DEPT_FLAG is not null");
            return (Criteria) this;
        }

        public Criteria andWeiDeptFlagEqualTo(Byte value) {
            addCriterion("WEI_DEPT_FLAG =", value, "weiDeptFlag");
            return (Criteria) this;
        }

        public Criteria andWeiDeptFlagNotEqualTo(Byte value) {
            addCriterion("WEI_DEPT_FLAG <>", value, "weiDeptFlag");
            return (Criteria) this;
        }

        public Criteria andWeiDeptFlagGreaterThan(Byte value) {
            addCriterion("WEI_DEPT_FLAG >", value, "weiDeptFlag");
            return (Criteria) this;
        }

        public Criteria andWeiDeptFlagGreaterThanOrEqualTo(Byte value) {
            addCriterion("WEI_DEPT_FLAG >=", value, "weiDeptFlag");
            return (Criteria) this;
        }

        public Criteria andWeiDeptFlagLessThan(Byte value) {
            addCriterion("WEI_DEPT_FLAG <", value, "weiDeptFlag");
            return (Criteria) this;
        }

        public Criteria andWeiDeptFlagLessThanOrEqualTo(Byte value) {
            addCriterion("WEI_DEPT_FLAG <=", value, "weiDeptFlag");
            return (Criteria) this;
        }

        public Criteria andWeiDeptFlagIn(List<Byte> values) {
            addCriterion("WEI_DEPT_FLAG in", values, "weiDeptFlag");
            return (Criteria) this;
        }

        public Criteria andWeiDeptFlagNotIn(List<Byte> values) {
            addCriterion("WEI_DEPT_FLAG not in", values, "weiDeptFlag");
            return (Criteria) this;
        }

        public Criteria andWeiDeptFlagBetween(Byte value1, Byte value2) {
            addCriterion("WEI_DEPT_FLAG between", value1, value2, "weiDeptFlag");
            return (Criteria) this;
        }

        public Criteria andWeiDeptFlagNotBetween(Byte value1, Byte value2) {
            addCriterion("WEI_DEPT_FLAG not between", value1, value2, "weiDeptFlag");
            return (Criteria) this;
        }

        public Criteria andYouHfFlagIsNull() {
            addCriterion("YOU_HF_FLAG is null");
            return (Criteria) this;
        }

        public Criteria andYouHfFlagIsNotNull() {
            addCriterion("YOU_HF_FLAG is not null");
            return (Criteria) this;
        }

        public Criteria andYouHfFlagEqualTo(Byte value) {
            addCriterion("YOU_HF_FLAG =", value, "youHfFlag");
            return (Criteria) this;
        }

        public Criteria andYouHfFlagNotEqualTo(Byte value) {
            addCriterion("YOU_HF_FLAG <>", value, "youHfFlag");
            return (Criteria) this;
        }

        public Criteria andYouHfFlagGreaterThan(Byte value) {
            addCriterion("YOU_HF_FLAG >", value, "youHfFlag");
            return (Criteria) this;
        }

        public Criteria andYouHfFlagGreaterThanOrEqualTo(Byte value) {
            addCriterion("YOU_HF_FLAG >=", value, "youHfFlag");
            return (Criteria) this;
        }

        public Criteria andYouHfFlagLessThan(Byte value) {
            addCriterion("YOU_HF_FLAG <", value, "youHfFlag");
            return (Criteria) this;
        }

        public Criteria andYouHfFlagLessThanOrEqualTo(Byte value) {
            addCriterion("YOU_HF_FLAG <=", value, "youHfFlag");
            return (Criteria) this;
        }

        public Criteria andYouHfFlagIn(List<Byte> values) {
            addCriterion("YOU_HF_FLAG in", values, "youHfFlag");
            return (Criteria) this;
        }

        public Criteria andYouHfFlagNotIn(List<Byte> values) {
            addCriterion("YOU_HF_FLAG not in", values, "youHfFlag");
            return (Criteria) this;
        }

        public Criteria andYouHfFlagBetween(Byte value1, Byte value2) {
            addCriterion("YOU_HF_FLAG between", value1, value2, "youHfFlag");
            return (Criteria) this;
        }

        public Criteria andYouHfFlagNotBetween(Byte value1, Byte value2) {
            addCriterion("YOU_HF_FLAG not between", value1, value2, "youHfFlag");
            return (Criteria) this;
        }

        public Criteria andHfFafaFlagIsNull() {
            addCriterion("HF_FAFA_FLAG is null");
            return (Criteria) this;
        }

        public Criteria andHfFafaFlagIsNotNull() {
            addCriterion("HF_FAFA_FLAG is not null");
            return (Criteria) this;
        }

        public Criteria andHfFafaFlagEqualTo(Byte value) {
            addCriterion("HF_FAFA_FLAG =", value, "hfFafaFlag");
            return (Criteria) this;
        }

        public Criteria andHfFafaFlagNotEqualTo(Byte value) {
            addCriterion("HF_FAFA_FLAG <>", value, "hfFafaFlag");
            return (Criteria) this;
        }

        public Criteria andHfFafaFlagGreaterThan(Byte value) {
            addCriterion("HF_FAFA_FLAG >", value, "hfFafaFlag");
            return (Criteria) this;
        }

        public Criteria andHfFafaFlagGreaterThanOrEqualTo(Byte value) {
            addCriterion("HF_FAFA_FLAG >=", value, "hfFafaFlag");
            return (Criteria) this;
        }

        public Criteria andHfFafaFlagLessThan(Byte value) {
            addCriterion("HF_FAFA_FLAG <", value, "hfFafaFlag");
            return (Criteria) this;
        }

        public Criteria andHfFafaFlagLessThanOrEqualTo(Byte value) {
            addCriterion("HF_FAFA_FLAG <=", value, "hfFafaFlag");
            return (Criteria) this;
        }

        public Criteria andHfFafaFlagIn(List<Byte> values) {
            addCriterion("HF_FAFA_FLAG in", values, "hfFafaFlag");
            return (Criteria) this;
        }

        public Criteria andHfFafaFlagNotIn(List<Byte> values) {
            addCriterion("HF_FAFA_FLAG not in", values, "hfFafaFlag");
            return (Criteria) this;
        }

        public Criteria andHfFafaFlagBetween(Byte value1, Byte value2) {
            addCriterion("HF_FAFA_FLAG between", value1, value2, "hfFafaFlag");
            return (Criteria) this;
        }

        public Criteria andHfFafaFlagNotBetween(Byte value1, Byte value2) {
            addCriterion("HF_FAFA_FLAG not between", value1, value2, "hfFafaFlag");
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