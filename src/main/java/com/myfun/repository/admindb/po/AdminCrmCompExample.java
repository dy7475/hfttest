package com.myfun.repository.admindb.po;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AdminCrmCompExample {
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
    public AdminCrmCompExample() {
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

        public Criteria andProvinceIdIsNull() {
            addCriterion("PROVINCE_ID is null");
            return (Criteria) this;
        }

        public Criteria andProvinceIdIsNotNull() {
            addCriterion("PROVINCE_ID is not null");
            return (Criteria) this;
        }

        public Criteria andProvinceIdEqualTo(Integer value) {
            addCriterion("PROVINCE_ID =", value, "provinceId");
            return (Criteria) this;
        }

        public Criteria andProvinceIdNotEqualTo(Integer value) {
            addCriterion("PROVINCE_ID <>", value, "provinceId");
            return (Criteria) this;
        }

        public Criteria andProvinceIdGreaterThan(Integer value) {
            addCriterion("PROVINCE_ID >", value, "provinceId");
            return (Criteria) this;
        }

        public Criteria andProvinceIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("PROVINCE_ID >=", value, "provinceId");
            return (Criteria) this;
        }

        public Criteria andProvinceIdLessThan(Integer value) {
            addCriterion("PROVINCE_ID <", value, "provinceId");
            return (Criteria) this;
        }

        public Criteria andProvinceIdLessThanOrEqualTo(Integer value) {
            addCriterion("PROVINCE_ID <=", value, "provinceId");
            return (Criteria) this;
        }

        public Criteria andProvinceIdIn(List<Integer> values) {
            addCriterion("PROVINCE_ID in", values, "provinceId");
            return (Criteria) this;
        }

        public Criteria andProvinceIdNotIn(List<Integer> values) {
            addCriterion("PROVINCE_ID not in", values, "provinceId");
            return (Criteria) this;
        }

        public Criteria andProvinceIdBetween(Integer value1, Integer value2) {
            addCriterion("PROVINCE_ID between", value1, value2, "provinceId");
            return (Criteria) this;
        }

        public Criteria andProvinceIdNotBetween(Integer value1, Integer value2) {
            addCriterion("PROVINCE_ID not between", value1, value2, "provinceId");
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

        public Criteria andCompNameIsNull() {
            addCriterion("COMP_NAME is null");
            return (Criteria) this;
        }

        public Criteria andCompNameIsNotNull() {
            addCriterion("COMP_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andCompNameEqualTo(String value) {
            addCriterion("COMP_NAME =", value, "compName");
            return (Criteria) this;
        }

        public Criteria andCompNameNotEqualTo(String value) {
            addCriterion("COMP_NAME <>", value, "compName");
            return (Criteria) this;
        }

        public Criteria andCompNameGreaterThan(String value) {
            addCriterion("COMP_NAME >", value, "compName");
            return (Criteria) this;
        }

        public Criteria andCompNameGreaterThanOrEqualTo(String value) {
            addCriterion("COMP_NAME >=", value, "compName");
            return (Criteria) this;
        }

        public Criteria andCompNameLessThan(String value) {
            addCriterion("COMP_NAME <", value, "compName");
            return (Criteria) this;
        }

        public Criteria andCompNameLessThanOrEqualTo(String value) {
            addCriterion("COMP_NAME <=", value, "compName");
            return (Criteria) this;
        }

        public Criteria andCompNameLike(String value) {
            addCriterion("COMP_NAME like", value, "compName");
            return (Criteria) this;
        }

        public Criteria andCompNameNotLike(String value) {
            addCriterion("COMP_NAME not like", value, "compName");
            return (Criteria) this;
        }

        public Criteria andCompNameIn(List<String> values) {
            addCriterion("COMP_NAME in", values, "compName");
            return (Criteria) this;
        }

        public Criteria andCompNameNotIn(List<String> values) {
            addCriterion("COMP_NAME not in", values, "compName");
            return (Criteria) this;
        }

        public Criteria andCompNameBetween(String value1, String value2) {
            addCriterion("COMP_NAME between", value1, value2, "compName");
            return (Criteria) this;
        }

        public Criteria andCompNameNotBetween(String value1, String value2) {
            addCriterion("COMP_NAME not between", value1, value2, "compName");
            return (Criteria) this;
        }

        public Criteria andCompCnameIsNull() {
            addCriterion("COMP_CNAME is null");
            return (Criteria) this;
        }

        public Criteria andCompCnameIsNotNull() {
            addCriterion("COMP_CNAME is not null");
            return (Criteria) this;
        }

        public Criteria andCompCnameEqualTo(String value) {
            addCriterion("COMP_CNAME =", value, "compCname");
            return (Criteria) this;
        }

        public Criteria andCompCnameNotEqualTo(String value) {
            addCriterion("COMP_CNAME <>", value, "compCname");
            return (Criteria) this;
        }

        public Criteria andCompCnameGreaterThan(String value) {
            addCriterion("COMP_CNAME >", value, "compCname");
            return (Criteria) this;
        }

        public Criteria andCompCnameGreaterThanOrEqualTo(String value) {
            addCriterion("COMP_CNAME >=", value, "compCname");
            return (Criteria) this;
        }

        public Criteria andCompCnameLessThan(String value) {
            addCriterion("COMP_CNAME <", value, "compCname");
            return (Criteria) this;
        }

        public Criteria andCompCnameLessThanOrEqualTo(String value) {
            addCriterion("COMP_CNAME <=", value, "compCname");
            return (Criteria) this;
        }

        public Criteria andCompCnameLike(String value) {
            addCriterion("COMP_CNAME like", value, "compCname");
            return (Criteria) this;
        }

        public Criteria andCompCnameNotLike(String value) {
            addCriterion("COMP_CNAME not like", value, "compCname");
            return (Criteria) this;
        }

        public Criteria andCompCnameIn(List<String> values) {
            addCriterion("COMP_CNAME in", values, "compCname");
            return (Criteria) this;
        }

        public Criteria andCompCnameNotIn(List<String> values) {
            addCriterion("COMP_CNAME not in", values, "compCname");
            return (Criteria) this;
        }

        public Criteria andCompCnameBetween(String value1, String value2) {
            addCriterion("COMP_CNAME between", value1, value2, "compCname");
            return (Criteria) this;
        }

        public Criteria andCompCnameNotBetween(String value1, String value2) {
            addCriterion("COMP_CNAME not between", value1, value2, "compCname");
            return (Criteria) this;
        }

        public Criteria andCompAddrIsNull() {
            addCriterion("COMP_ADDR is null");
            return (Criteria) this;
        }

        public Criteria andCompAddrIsNotNull() {
            addCriterion("COMP_ADDR is not null");
            return (Criteria) this;
        }

        public Criteria andCompAddrEqualTo(String value) {
            addCriterion("COMP_ADDR =", value, "compAddr");
            return (Criteria) this;
        }

        public Criteria andCompAddrNotEqualTo(String value) {
            addCriterion("COMP_ADDR <>", value, "compAddr");
            return (Criteria) this;
        }

        public Criteria andCompAddrGreaterThan(String value) {
            addCriterion("COMP_ADDR >", value, "compAddr");
            return (Criteria) this;
        }

        public Criteria andCompAddrGreaterThanOrEqualTo(String value) {
            addCriterion("COMP_ADDR >=", value, "compAddr");
            return (Criteria) this;
        }

        public Criteria andCompAddrLessThan(String value) {
            addCriterion("COMP_ADDR <", value, "compAddr");
            return (Criteria) this;
        }

        public Criteria andCompAddrLessThanOrEqualTo(String value) {
            addCriterion("COMP_ADDR <=", value, "compAddr");
            return (Criteria) this;
        }

        public Criteria andCompAddrLike(String value) {
            addCriterion("COMP_ADDR like", value, "compAddr");
            return (Criteria) this;
        }

        public Criteria andCompAddrNotLike(String value) {
            addCriterion("COMP_ADDR not like", value, "compAddr");
            return (Criteria) this;
        }

        public Criteria andCompAddrIn(List<String> values) {
            addCriterion("COMP_ADDR in", values, "compAddr");
            return (Criteria) this;
        }

        public Criteria andCompAddrNotIn(List<String> values) {
            addCriterion("COMP_ADDR not in", values, "compAddr");
            return (Criteria) this;
        }

        public Criteria andCompAddrBetween(String value1, String value2) {
            addCriterion("COMP_ADDR between", value1, value2, "compAddr");
            return (Criteria) this;
        }

        public Criteria andCompAddrNotBetween(String value1, String value2) {
            addCriterion("COMP_ADDR not between", value1, value2, "compAddr");
            return (Criteria) this;
        }

        public Criteria andRegNameIsNull() {
            addCriterion("REG_NAME is null");
            return (Criteria) this;
        }

        public Criteria andRegNameIsNotNull() {
            addCriterion("REG_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andRegNameEqualTo(String value) {
            addCriterion("REG_NAME =", value, "regName");
            return (Criteria) this;
        }

        public Criteria andRegNameNotEqualTo(String value) {
            addCriterion("REG_NAME <>", value, "regName");
            return (Criteria) this;
        }

        public Criteria andRegNameGreaterThan(String value) {
            addCriterion("REG_NAME >", value, "regName");
            return (Criteria) this;
        }

        public Criteria andRegNameGreaterThanOrEqualTo(String value) {
            addCriterion("REG_NAME >=", value, "regName");
            return (Criteria) this;
        }

        public Criteria andRegNameLessThan(String value) {
            addCriterion("REG_NAME <", value, "regName");
            return (Criteria) this;
        }

        public Criteria andRegNameLessThanOrEqualTo(String value) {
            addCriterion("REG_NAME <=", value, "regName");
            return (Criteria) this;
        }

        public Criteria andRegNameLike(String value) {
            addCriterion("REG_NAME like", value, "regName");
            return (Criteria) this;
        }

        public Criteria andRegNameNotLike(String value) {
            addCriterion("REG_NAME not like", value, "regName");
            return (Criteria) this;
        }

        public Criteria andRegNameIn(List<String> values) {
            addCriterion("REG_NAME in", values, "regName");
            return (Criteria) this;
        }

        public Criteria andRegNameNotIn(List<String> values) {
            addCriterion("REG_NAME not in", values, "regName");
            return (Criteria) this;
        }

        public Criteria andRegNameBetween(String value1, String value2) {
            addCriterion("REG_NAME between", value1, value2, "regName");
            return (Criteria) this;
        }

        public Criteria andRegNameNotBetween(String value1, String value2) {
            addCriterion("REG_NAME not between", value1, value2, "regName");
            return (Criteria) this;
        }

        public Criteria andCompContactIsNull() {
            addCriterion("COMP_CONTACT is null");
            return (Criteria) this;
        }

        public Criteria andCompContactIsNotNull() {
            addCriterion("COMP_CONTACT is not null");
            return (Criteria) this;
        }

        public Criteria andCompContactEqualTo(String value) {
            addCriterion("COMP_CONTACT =", value, "compContact");
            return (Criteria) this;
        }

        public Criteria andCompContactNotEqualTo(String value) {
            addCriterion("COMP_CONTACT <>", value, "compContact");
            return (Criteria) this;
        }

        public Criteria andCompContactGreaterThan(String value) {
            addCriterion("COMP_CONTACT >", value, "compContact");
            return (Criteria) this;
        }

        public Criteria andCompContactGreaterThanOrEqualTo(String value) {
            addCriterion("COMP_CONTACT >=", value, "compContact");
            return (Criteria) this;
        }

        public Criteria andCompContactLessThan(String value) {
            addCriterion("COMP_CONTACT <", value, "compContact");
            return (Criteria) this;
        }

        public Criteria andCompContactLessThanOrEqualTo(String value) {
            addCriterion("COMP_CONTACT <=", value, "compContact");
            return (Criteria) this;
        }

        public Criteria andCompContactLike(String value) {
            addCriterion("COMP_CONTACT like", value, "compContact");
            return (Criteria) this;
        }

        public Criteria andCompContactNotLike(String value) {
            addCriterion("COMP_CONTACT not like", value, "compContact");
            return (Criteria) this;
        }

        public Criteria andCompContactIn(List<String> values) {
            addCriterion("COMP_CONTACT in", values, "compContact");
            return (Criteria) this;
        }

        public Criteria andCompContactNotIn(List<String> values) {
            addCriterion("COMP_CONTACT not in", values, "compContact");
            return (Criteria) this;
        }

        public Criteria andCompContactBetween(String value1, String value2) {
            addCriterion("COMP_CONTACT between", value1, value2, "compContact");
            return (Criteria) this;
        }

        public Criteria andCompContactNotBetween(String value1, String value2) {
            addCriterion("COMP_CONTACT not between", value1, value2, "compContact");
            return (Criteria) this;
        }

        public Criteria andContactPhoneIsNull() {
            addCriterion("CONTACT_PHONE is null");
            return (Criteria) this;
        }

        public Criteria andContactPhoneIsNotNull() {
            addCriterion("CONTACT_PHONE is not null");
            return (Criteria) this;
        }

        public Criteria andContactPhoneEqualTo(String value) {
            addCriterion("CONTACT_PHONE =", value, "contactPhone");
            return (Criteria) this;
        }

        public Criteria andContactPhoneNotEqualTo(String value) {
            addCriterion("CONTACT_PHONE <>", value, "contactPhone");
            return (Criteria) this;
        }

        public Criteria andContactPhoneGreaterThan(String value) {
            addCriterion("CONTACT_PHONE >", value, "contactPhone");
            return (Criteria) this;
        }

        public Criteria andContactPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("CONTACT_PHONE >=", value, "contactPhone");
            return (Criteria) this;
        }

        public Criteria andContactPhoneLessThan(String value) {
            addCriterion("CONTACT_PHONE <", value, "contactPhone");
            return (Criteria) this;
        }

        public Criteria andContactPhoneLessThanOrEqualTo(String value) {
            addCriterion("CONTACT_PHONE <=", value, "contactPhone");
            return (Criteria) this;
        }

        public Criteria andContactPhoneLike(String value) {
            addCriterion("CONTACT_PHONE like", value, "contactPhone");
            return (Criteria) this;
        }

        public Criteria andContactPhoneNotLike(String value) {
            addCriterion("CONTACT_PHONE not like", value, "contactPhone");
            return (Criteria) this;
        }

        public Criteria andContactPhoneIn(List<String> values) {
            addCriterion("CONTACT_PHONE in", values, "contactPhone");
            return (Criteria) this;
        }

        public Criteria andContactPhoneNotIn(List<String> values) {
            addCriterion("CONTACT_PHONE not in", values, "contactPhone");
            return (Criteria) this;
        }

        public Criteria andContactPhoneBetween(String value1, String value2) {
            addCriterion("CONTACT_PHONE between", value1, value2, "contactPhone");
            return (Criteria) this;
        }

        public Criteria andContactPhoneNotBetween(String value1, String value2) {
            addCriterion("CONTACT_PHONE not between", value1, value2, "contactPhone");
            return (Criteria) this;
        }

        public Criteria andCompTeleIsNull() {
            addCriterion("COMP_TELE is null");
            return (Criteria) this;
        }

        public Criteria andCompTeleIsNotNull() {
            addCriterion("COMP_TELE is not null");
            return (Criteria) this;
        }

        public Criteria andCompTeleEqualTo(String value) {
            addCriterion("COMP_TELE =", value, "compTele");
            return (Criteria) this;
        }

        public Criteria andCompTeleNotEqualTo(String value) {
            addCriterion("COMP_TELE <>", value, "compTele");
            return (Criteria) this;
        }

        public Criteria andCompTeleGreaterThan(String value) {
            addCriterion("COMP_TELE >", value, "compTele");
            return (Criteria) this;
        }

        public Criteria andCompTeleGreaterThanOrEqualTo(String value) {
            addCriterion("COMP_TELE >=", value, "compTele");
            return (Criteria) this;
        }

        public Criteria andCompTeleLessThan(String value) {
            addCriterion("COMP_TELE <", value, "compTele");
            return (Criteria) this;
        }

        public Criteria andCompTeleLessThanOrEqualTo(String value) {
            addCriterion("COMP_TELE <=", value, "compTele");
            return (Criteria) this;
        }

        public Criteria andCompTeleLike(String value) {
            addCriterion("COMP_TELE like", value, "compTele");
            return (Criteria) this;
        }

        public Criteria andCompTeleNotLike(String value) {
            addCriterion("COMP_TELE not like", value, "compTele");
            return (Criteria) this;
        }

        public Criteria andCompTeleIn(List<String> values) {
            addCriterion("COMP_TELE in", values, "compTele");
            return (Criteria) this;
        }

        public Criteria andCompTeleNotIn(List<String> values) {
            addCriterion("COMP_TELE not in", values, "compTele");
            return (Criteria) this;
        }

        public Criteria andCompTeleBetween(String value1, String value2) {
            addCriterion("COMP_TELE between", value1, value2, "compTele");
            return (Criteria) this;
        }

        public Criteria andCompTeleNotBetween(String value1, String value2) {
            addCriterion("COMP_TELE not between", value1, value2, "compTele");
            return (Criteria) this;
        }

        public Criteria andSuperCompIsNull() {
            addCriterion("SUPER_COMP is null");
            return (Criteria) this;
        }

        public Criteria andSuperCompIsNotNull() {
            addCriterion("SUPER_COMP is not null");
            return (Criteria) this;
        }

        public Criteria andSuperCompEqualTo(Boolean value) {
            addCriterion("SUPER_COMP =", value, "superComp");
            return (Criteria) this;
        }

        public Criteria andSuperCompNotEqualTo(Boolean value) {
            addCriterion("SUPER_COMP <>", value, "superComp");
            return (Criteria) this;
        }

        public Criteria andSuperCompGreaterThan(Boolean value) {
            addCriterion("SUPER_COMP >", value, "superComp");
            return (Criteria) this;
        }

        public Criteria andSuperCompGreaterThanOrEqualTo(Boolean value) {
            addCriterion("SUPER_COMP >=", value, "superComp");
            return (Criteria) this;
        }

        public Criteria andSuperCompLessThan(Boolean value) {
            addCriterion("SUPER_COMP <", value, "superComp");
            return (Criteria) this;
        }

        public Criteria andSuperCompLessThanOrEqualTo(Boolean value) {
            addCriterion("SUPER_COMP <=", value, "superComp");
            return (Criteria) this;
        }

        public Criteria andSuperCompIn(List<Boolean> values) {
            addCriterion("SUPER_COMP in", values, "superComp");
            return (Criteria) this;
        }

        public Criteria andSuperCompNotIn(List<Boolean> values) {
            addCriterion("SUPER_COMP not in", values, "superComp");
            return (Criteria) this;
        }

        public Criteria andSuperCompBetween(Boolean value1, Boolean value2) {
            addCriterion("SUPER_COMP between", value1, value2, "superComp");
            return (Criteria) this;
        }

        public Criteria andSuperCompNotBetween(Boolean value1, Boolean value2) {
            addCriterion("SUPER_COMP not between", value1, value2, "superComp");
            return (Criteria) this;
        }

        public Criteria andRegistFlagIsNull() {
            addCriterion("REGIST_FLAG is null");
            return (Criteria) this;
        }

        public Criteria andRegistFlagIsNotNull() {
            addCriterion("REGIST_FLAG is not null");
            return (Criteria) this;
        }

        public Criteria andRegistFlagEqualTo(Boolean value) {
            addCriterion("REGIST_FLAG =", value, "registFlag");
            return (Criteria) this;
        }

        public Criteria andRegistFlagNotEqualTo(Boolean value) {
            addCriterion("REGIST_FLAG <>", value, "registFlag");
            return (Criteria) this;
        }

        public Criteria andRegistFlagGreaterThan(Boolean value) {
            addCriterion("REGIST_FLAG >", value, "registFlag");
            return (Criteria) this;
        }

        public Criteria andRegistFlagGreaterThanOrEqualTo(Boolean value) {
            addCriterion("REGIST_FLAG >=", value, "registFlag");
            return (Criteria) this;
        }

        public Criteria andRegistFlagLessThan(Boolean value) {
            addCriterion("REGIST_FLAG <", value, "registFlag");
            return (Criteria) this;
        }

        public Criteria andRegistFlagLessThanOrEqualTo(Boolean value) {
            addCriterion("REGIST_FLAG <=", value, "registFlag");
            return (Criteria) this;
        }

        public Criteria andRegistFlagIn(List<Boolean> values) {
            addCriterion("REGIST_FLAG in", values, "registFlag");
            return (Criteria) this;
        }

        public Criteria andRegistFlagNotIn(List<Boolean> values) {
            addCriterion("REGIST_FLAG not in", values, "registFlag");
            return (Criteria) this;
        }

        public Criteria andRegistFlagBetween(Boolean value1, Boolean value2) {
            addCriterion("REGIST_FLAG between", value1, value2, "registFlag");
            return (Criteria) this;
        }

        public Criteria andRegistFlagNotBetween(Boolean value1, Boolean value2) {
            addCriterion("REGIST_FLAG not between", value1, value2, "registFlag");
            return (Criteria) this;
        }

        public Criteria andPwdDescIsNull() {
            addCriterion("PWD_DESC is null");
            return (Criteria) this;
        }

        public Criteria andPwdDescIsNotNull() {
            addCriterion("PWD_DESC is not null");
            return (Criteria) this;
        }

        public Criteria andPwdDescEqualTo(String value) {
            addCriterion("PWD_DESC =", value, "pwdDesc");
            return (Criteria) this;
        }

        public Criteria andPwdDescNotEqualTo(String value) {
            addCriterion("PWD_DESC <>", value, "pwdDesc");
            return (Criteria) this;
        }

        public Criteria andPwdDescGreaterThan(String value) {
            addCriterion("PWD_DESC >", value, "pwdDesc");
            return (Criteria) this;
        }

        public Criteria andPwdDescGreaterThanOrEqualTo(String value) {
            addCriterion("PWD_DESC >=", value, "pwdDesc");
            return (Criteria) this;
        }

        public Criteria andPwdDescLessThan(String value) {
            addCriterion("PWD_DESC <", value, "pwdDesc");
            return (Criteria) this;
        }

        public Criteria andPwdDescLessThanOrEqualTo(String value) {
            addCriterion("PWD_DESC <=", value, "pwdDesc");
            return (Criteria) this;
        }

        public Criteria andPwdDescLike(String value) {
            addCriterion("PWD_DESC like", value, "pwdDesc");
            return (Criteria) this;
        }

        public Criteria andPwdDescNotLike(String value) {
            addCriterion("PWD_DESC not like", value, "pwdDesc");
            return (Criteria) this;
        }

        public Criteria andPwdDescIn(List<String> values) {
            addCriterion("PWD_DESC in", values, "pwdDesc");
            return (Criteria) this;
        }

        public Criteria andPwdDescNotIn(List<String> values) {
            addCriterion("PWD_DESC not in", values, "pwdDesc");
            return (Criteria) this;
        }

        public Criteria andPwdDescBetween(String value1, String value2) {
            addCriterion("PWD_DESC between", value1, value2, "pwdDesc");
            return (Criteria) this;
        }

        public Criteria andPwdDescNotBetween(String value1, String value2) {
            addCriterion("PWD_DESC not between", value1, value2, "pwdDesc");
            return (Criteria) this;
        }

        public Criteria andRouteMacIsNull() {
            addCriterion("ROUTE_MAC is null");
            return (Criteria) this;
        }

        public Criteria andRouteMacIsNotNull() {
            addCriterion("ROUTE_MAC is not null");
            return (Criteria) this;
        }

        public Criteria andRouteMacEqualTo(String value) {
            addCriterion("ROUTE_MAC =", value, "routeMac");
            return (Criteria) this;
        }

        public Criteria andRouteMacNotEqualTo(String value) {
            addCriterion("ROUTE_MAC <>", value, "routeMac");
            return (Criteria) this;
        }

        public Criteria andRouteMacGreaterThan(String value) {
            addCriterion("ROUTE_MAC >", value, "routeMac");
            return (Criteria) this;
        }

        public Criteria andRouteMacGreaterThanOrEqualTo(String value) {
            addCriterion("ROUTE_MAC >=", value, "routeMac");
            return (Criteria) this;
        }

        public Criteria andRouteMacLessThan(String value) {
            addCriterion("ROUTE_MAC <", value, "routeMac");
            return (Criteria) this;
        }

        public Criteria andRouteMacLessThanOrEqualTo(String value) {
            addCriterion("ROUTE_MAC <=", value, "routeMac");
            return (Criteria) this;
        }

        public Criteria andRouteMacLike(String value) {
            addCriterion("ROUTE_MAC like", value, "routeMac");
            return (Criteria) this;
        }

        public Criteria andRouteMacNotLike(String value) {
            addCriterion("ROUTE_MAC not like", value, "routeMac");
            return (Criteria) this;
        }

        public Criteria andRouteMacIn(List<String> values) {
            addCriterion("ROUTE_MAC in", values, "routeMac");
            return (Criteria) this;
        }

        public Criteria andRouteMacNotIn(List<String> values) {
            addCriterion("ROUTE_MAC not in", values, "routeMac");
            return (Criteria) this;
        }

        public Criteria andRouteMacBetween(String value1, String value2) {
            addCriterion("ROUTE_MAC between", value1, value2, "routeMac");
            return (Criteria) this;
        }

        public Criteria andRouteMacNotBetween(String value1, String value2) {
            addCriterion("ROUTE_MAC not between", value1, value2, "routeMac");
            return (Criteria) this;
        }

        public Criteria andIsDistributeIsNull() {
            addCriterion("IS_DISTRIBUTE is null");
            return (Criteria) this;
        }

        public Criteria andIsDistributeIsNotNull() {
            addCriterion("IS_DISTRIBUTE is not null");
            return (Criteria) this;
        }

        public Criteria andIsDistributeEqualTo(Boolean value) {
            addCriterion("IS_DISTRIBUTE =", value, "isDistribute");
            return (Criteria) this;
        }

        public Criteria andIsDistributeNotEqualTo(Boolean value) {
            addCriterion("IS_DISTRIBUTE <>", value, "isDistribute");
            return (Criteria) this;
        }

        public Criteria andIsDistributeGreaterThan(Boolean value) {
            addCriterion("IS_DISTRIBUTE >", value, "isDistribute");
            return (Criteria) this;
        }

        public Criteria andIsDistributeGreaterThanOrEqualTo(Boolean value) {
            addCriterion("IS_DISTRIBUTE >=", value, "isDistribute");
            return (Criteria) this;
        }

        public Criteria andIsDistributeLessThan(Boolean value) {
            addCriterion("IS_DISTRIBUTE <", value, "isDistribute");
            return (Criteria) this;
        }

        public Criteria andIsDistributeLessThanOrEqualTo(Boolean value) {
            addCriterion("IS_DISTRIBUTE <=", value, "isDistribute");
            return (Criteria) this;
        }

        public Criteria andIsDistributeIn(List<Boolean> values) {
            addCriterion("IS_DISTRIBUTE in", values, "isDistribute");
            return (Criteria) this;
        }

        public Criteria andIsDistributeNotIn(List<Boolean> values) {
            addCriterion("IS_DISTRIBUTE not in", values, "isDistribute");
            return (Criteria) this;
        }

        public Criteria andIsDistributeBetween(Boolean value1, Boolean value2) {
            addCriterion("IS_DISTRIBUTE between", value1, value2, "isDistribute");
            return (Criteria) this;
        }

        public Criteria andIsDistributeNotBetween(Boolean value1, Boolean value2) {
            addCriterion("IS_DISTRIBUTE not between", value1, value2, "isDistribute");
            return (Criteria) this;
        }

        public Criteria andFatherCompIsNull() {
            addCriterion("FATHER_COMP is null");
            return (Criteria) this;
        }

        public Criteria andFatherCompIsNotNull() {
            addCriterion("FATHER_COMP is not null");
            return (Criteria) this;
        }

        public Criteria andFatherCompEqualTo(Integer value) {
            addCriterion("FATHER_COMP =", value, "fatherComp");
            return (Criteria) this;
        }

        public Criteria andFatherCompNotEqualTo(Integer value) {
            addCriterion("FATHER_COMP <>", value, "fatherComp");
            return (Criteria) this;
        }

        public Criteria andFatherCompGreaterThan(Integer value) {
            addCriterion("FATHER_COMP >", value, "fatherComp");
            return (Criteria) this;
        }

        public Criteria andFatherCompGreaterThanOrEqualTo(Integer value) {
            addCriterion("FATHER_COMP >=", value, "fatherComp");
            return (Criteria) this;
        }

        public Criteria andFatherCompLessThan(Integer value) {
            addCriterion("FATHER_COMP <", value, "fatherComp");
            return (Criteria) this;
        }

        public Criteria andFatherCompLessThanOrEqualTo(Integer value) {
            addCriterion("FATHER_COMP <=", value, "fatherComp");
            return (Criteria) this;
        }

        public Criteria andFatherCompIn(List<Integer> values) {
            addCriterion("FATHER_COMP in", values, "fatherComp");
            return (Criteria) this;
        }

        public Criteria andFatherCompNotIn(List<Integer> values) {
            addCriterion("FATHER_COMP not in", values, "fatherComp");
            return (Criteria) this;
        }

        public Criteria andFatherCompBetween(Integer value1, Integer value2) {
            addCriterion("FATHER_COMP between", value1, value2, "fatherComp");
            return (Criteria) this;
        }

        public Criteria andFatherCompNotBetween(Integer value1, Integer value2) {
            addCriterion("FATHER_COMP not between", value1, value2, "fatherComp");
            return (Criteria) this;
        }

        public Criteria andWriteoffFlagIsNull() {
            addCriterion("WRITEOFF_FLAG is null");
            return (Criteria) this;
        }

        public Criteria andWriteoffFlagIsNotNull() {
            addCriterion("WRITEOFF_FLAG is not null");
            return (Criteria) this;
        }

        public Criteria andWriteoffFlagEqualTo(Boolean value) {
            addCriterion("WRITEOFF_FLAG =", value, "writeoffFlag");
            return (Criteria) this;
        }

        public Criteria andWriteoffFlagNotEqualTo(Boolean value) {
            addCriterion("WRITEOFF_FLAG <>", value, "writeoffFlag");
            return (Criteria) this;
        }

        public Criteria andWriteoffFlagGreaterThan(Boolean value) {
            addCriterion("WRITEOFF_FLAG >", value, "writeoffFlag");
            return (Criteria) this;
        }

        public Criteria andWriteoffFlagGreaterThanOrEqualTo(Boolean value) {
            addCriterion("WRITEOFF_FLAG >=", value, "writeoffFlag");
            return (Criteria) this;
        }

        public Criteria andWriteoffFlagLessThan(Boolean value) {
            addCriterion("WRITEOFF_FLAG <", value, "writeoffFlag");
            return (Criteria) this;
        }

        public Criteria andWriteoffFlagLessThanOrEqualTo(Boolean value) {
            addCriterion("WRITEOFF_FLAG <=", value, "writeoffFlag");
            return (Criteria) this;
        }

        public Criteria andWriteoffFlagIn(List<Boolean> values) {
            addCriterion("WRITEOFF_FLAG in", values, "writeoffFlag");
            return (Criteria) this;
        }

        public Criteria andWriteoffFlagNotIn(List<Boolean> values) {
            addCriterion("WRITEOFF_FLAG not in", values, "writeoffFlag");
            return (Criteria) this;
        }

        public Criteria andWriteoffFlagBetween(Boolean value1, Boolean value2) {
            addCriterion("WRITEOFF_FLAG between", value1, value2, "writeoffFlag");
            return (Criteria) this;
        }

        public Criteria andWriteoffFlagNotBetween(Boolean value1, Boolean value2) {
            addCriterion("WRITEOFF_FLAG not between", value1, value2, "writeoffFlag");
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

        public Criteria andWriteoffTimeIsNull() {
            addCriterion("WRITEOFF_TIME is null");
            return (Criteria) this;
        }

        public Criteria andWriteoffTimeIsNotNull() {
            addCriterion("WRITEOFF_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andWriteoffTimeEqualTo(Date value) {
            addCriterion("WRITEOFF_TIME =", value, "writeoffTime");
            return (Criteria) this;
        }

        public Criteria andWriteoffTimeNotEqualTo(Date value) {
            addCriterion("WRITEOFF_TIME <>", value, "writeoffTime");
            return (Criteria) this;
        }

        public Criteria andWriteoffTimeGreaterThan(Date value) {
            addCriterion("WRITEOFF_TIME >", value, "writeoffTime");
            return (Criteria) this;
        }

        public Criteria andWriteoffTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("WRITEOFF_TIME >=", value, "writeoffTime");
            return (Criteria) this;
        }

        public Criteria andWriteoffTimeLessThan(Date value) {
            addCriterion("WRITEOFF_TIME <", value, "writeoffTime");
            return (Criteria) this;
        }

        public Criteria andWriteoffTimeLessThanOrEqualTo(Date value) {
            addCriterion("WRITEOFF_TIME <=", value, "writeoffTime");
            return (Criteria) this;
        }

        public Criteria andWriteoffTimeIn(List<Date> values) {
            addCriterion("WRITEOFF_TIME in", values, "writeoffTime");
            return (Criteria) this;
        }

        public Criteria andWriteoffTimeNotIn(List<Date> values) {
            addCriterion("WRITEOFF_TIME not in", values, "writeoffTime");
            return (Criteria) this;
        }

        public Criteria andWriteoffTimeBetween(Date value1, Date value2) {
            addCriterion("WRITEOFF_TIME between", value1, value2, "writeoffTime");
            return (Criteria) this;
        }

        public Criteria andWriteoffTimeNotBetween(Date value1, Date value2) {
            addCriterion("WRITEOFF_TIME not between", value1, value2, "writeoffTime");
            return (Criteria) this;
        }

        public Criteria andIsCarriersIsNull() {
            addCriterion("IS_CARRIERS is null");
            return (Criteria) this;
        }

        public Criteria andIsCarriersIsNotNull() {
            addCriterion("IS_CARRIERS is not null");
            return (Criteria) this;
        }

        public Criteria andIsCarriersEqualTo(Boolean value) {
            addCriterion("IS_CARRIERS =", value, "isCarriers");
            return (Criteria) this;
        }

        public Criteria andIsCarriersNotEqualTo(Boolean value) {
            addCriterion("IS_CARRIERS <>", value, "isCarriers");
            return (Criteria) this;
        }

        public Criteria andIsCarriersGreaterThan(Boolean value) {
            addCriterion("IS_CARRIERS >", value, "isCarriers");
            return (Criteria) this;
        }

        public Criteria andIsCarriersGreaterThanOrEqualTo(Boolean value) {
            addCriterion("IS_CARRIERS >=", value, "isCarriers");
            return (Criteria) this;
        }

        public Criteria andIsCarriersLessThan(Boolean value) {
            addCriterion("IS_CARRIERS <", value, "isCarriers");
            return (Criteria) this;
        }

        public Criteria andIsCarriersLessThanOrEqualTo(Boolean value) {
            addCriterion("IS_CARRIERS <=", value, "isCarriers");
            return (Criteria) this;
        }

        public Criteria andIsCarriersIn(List<Boolean> values) {
            addCriterion("IS_CARRIERS in", values, "isCarriers");
            return (Criteria) this;
        }

        public Criteria andIsCarriersNotIn(List<Boolean> values) {
            addCriterion("IS_CARRIERS not in", values, "isCarriers");
            return (Criteria) this;
        }

        public Criteria andIsCarriersBetween(Boolean value1, Boolean value2) {
            addCriterion("IS_CARRIERS between", value1, value2, "isCarriers");
            return (Criteria) this;
        }

        public Criteria andIsCarriersNotBetween(Boolean value1, Boolean value2) {
            addCriterion("IS_CARRIERS not between", value1, value2, "isCarriers");
            return (Criteria) this;
        }

        public Criteria andCompTypeIsNull() {
            addCriterion("COMP_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andCompTypeIsNotNull() {
            addCriterion("COMP_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andCompTypeEqualTo(Byte value) {
            addCriterion("COMP_TYPE =", value, "compType");
            return (Criteria) this;
        }

        public Criteria andCompTypeNotEqualTo(Byte value) {
            addCriterion("COMP_TYPE <>", value, "compType");
            return (Criteria) this;
        }

        public Criteria andCompTypeGreaterThan(Byte value) {
            addCriterion("COMP_TYPE >", value, "compType");
            return (Criteria) this;
        }

        public Criteria andCompTypeGreaterThanOrEqualTo(Byte value) {
            addCriterion("COMP_TYPE >=", value, "compType");
            return (Criteria) this;
        }

        public Criteria andCompTypeLessThan(Byte value) {
            addCriterion("COMP_TYPE <", value, "compType");
            return (Criteria) this;
        }

        public Criteria andCompTypeLessThanOrEqualTo(Byte value) {
            addCriterion("COMP_TYPE <=", value, "compType");
            return (Criteria) this;
        }

        public Criteria andCompTypeIn(List<Byte> values) {
            addCriterion("COMP_TYPE in", values, "compType");
            return (Criteria) this;
        }

        public Criteria andCompTypeNotIn(List<Byte> values) {
            addCriterion("COMP_TYPE not in", values, "compType");
            return (Criteria) this;
        }

        public Criteria andCompTypeBetween(Byte value1, Byte value2) {
            addCriterion("COMP_TYPE between", value1, value2, "compType");
            return (Criteria) this;
        }

        public Criteria andCompTypeNotBetween(Byte value1, Byte value2) {
            addCriterion("COMP_TYPE not between", value1, value2, "compType");
            return (Criteria) this;
        }

        public Criteria andPlotSwitchIsNull() {
            addCriterion("PLOT_SWITCH is null");
            return (Criteria) this;
        }

        public Criteria andPlotSwitchIsNotNull() {
            addCriterion("PLOT_SWITCH is not null");
            return (Criteria) this;
        }

        public Criteria andPlotSwitchEqualTo(Byte value) {
            addCriterion("PLOT_SWITCH =", value, "plotSwitch");
            return (Criteria) this;
        }

        public Criteria andPlotSwitchNotEqualTo(Byte value) {
            addCriterion("PLOT_SWITCH <>", value, "plotSwitch");
            return (Criteria) this;
        }

        public Criteria andPlotSwitchGreaterThan(Byte value) {
            addCriterion("PLOT_SWITCH >", value, "plotSwitch");
            return (Criteria) this;
        }

        public Criteria andPlotSwitchGreaterThanOrEqualTo(Byte value) {
            addCriterion("PLOT_SWITCH >=", value, "plotSwitch");
            return (Criteria) this;
        }

        public Criteria andPlotSwitchLessThan(Byte value) {
            addCriterion("PLOT_SWITCH <", value, "plotSwitch");
            return (Criteria) this;
        }

        public Criteria andPlotSwitchLessThanOrEqualTo(Byte value) {
            addCriterion("PLOT_SWITCH <=", value, "plotSwitch");
            return (Criteria) this;
        }

        public Criteria andPlotSwitchIn(List<Byte> values) {
            addCriterion("PLOT_SWITCH in", values, "plotSwitch");
            return (Criteria) this;
        }

        public Criteria andPlotSwitchNotIn(List<Byte> values) {
            addCriterion("PLOT_SWITCH not in", values, "plotSwitch");
            return (Criteria) this;
        }

        public Criteria andPlotSwitchBetween(Byte value1, Byte value2) {
            addCriterion("PLOT_SWITCH between", value1, value2, "plotSwitch");
            return (Criteria) this;
        }

        public Criteria andPlotSwitchNotBetween(Byte value1, Byte value2) {
            addCriterion("PLOT_SWITCH not between", value1, value2, "plotSwitch");
            return (Criteria) this;
        }

        public Criteria andYoujiaDeptAutoPaymentIsNull() {
            addCriterion("YOUJIA_DEPT_AUTO_PAYMENT is null");
            return (Criteria) this;
        }

        public Criteria andYoujiaDeptAutoPaymentIsNotNull() {
            addCriterion("YOUJIA_DEPT_AUTO_PAYMENT is not null");
            return (Criteria) this;
        }

        public Criteria andYoujiaDeptAutoPaymentEqualTo(Byte value) {
            addCriterion("YOUJIA_DEPT_AUTO_PAYMENT =", value, "youjiaDeptAutoPayment");
            return (Criteria) this;
        }

        public Criteria andYoujiaDeptAutoPaymentNotEqualTo(Byte value) {
            addCriterion("YOUJIA_DEPT_AUTO_PAYMENT <>", value, "youjiaDeptAutoPayment");
            return (Criteria) this;
        }

        public Criteria andYoujiaDeptAutoPaymentGreaterThan(Byte value) {
            addCriterion("YOUJIA_DEPT_AUTO_PAYMENT >", value, "youjiaDeptAutoPayment");
            return (Criteria) this;
        }

        public Criteria andYoujiaDeptAutoPaymentGreaterThanOrEqualTo(Byte value) {
            addCriterion("YOUJIA_DEPT_AUTO_PAYMENT >=", value, "youjiaDeptAutoPayment");
            return (Criteria) this;
        }

        public Criteria andYoujiaDeptAutoPaymentLessThan(Byte value) {
            addCriterion("YOUJIA_DEPT_AUTO_PAYMENT <", value, "youjiaDeptAutoPayment");
            return (Criteria) this;
        }

        public Criteria andYoujiaDeptAutoPaymentLessThanOrEqualTo(Byte value) {
            addCriterion("YOUJIA_DEPT_AUTO_PAYMENT <=", value, "youjiaDeptAutoPayment");
            return (Criteria) this;
        }

        public Criteria andYoujiaDeptAutoPaymentIn(List<Byte> values) {
            addCriterion("YOUJIA_DEPT_AUTO_PAYMENT in", values, "youjiaDeptAutoPayment");
            return (Criteria) this;
        }

        public Criteria andYoujiaDeptAutoPaymentNotIn(List<Byte> values) {
            addCriterion("YOUJIA_DEPT_AUTO_PAYMENT not in", values, "youjiaDeptAutoPayment");
            return (Criteria) this;
        }

        public Criteria andYoujiaDeptAutoPaymentBetween(Byte value1, Byte value2) {
            addCriterion("YOUJIA_DEPT_AUTO_PAYMENT between", value1, value2, "youjiaDeptAutoPayment");
            return (Criteria) this;
        }

        public Criteria andYoujiaDeptAutoPaymentNotBetween(Byte value1, Byte value2) {
            addCriterion("YOUJIA_DEPT_AUTO_PAYMENT not between", value1, value2, "youjiaDeptAutoPayment");
            return (Criteria) this;
        }

        public Criteria andAgentBuildAutoPaymentIsNull() {
            addCriterion("AGENT_BUILD_AUTO_PAYMENT is null");
            return (Criteria) this;
        }

        public Criteria andAgentBuildAutoPaymentIsNotNull() {
            addCriterion("AGENT_BUILD_AUTO_PAYMENT is not null");
            return (Criteria) this;
        }

        public Criteria andAgentBuildAutoPaymentEqualTo(Byte value) {
            addCriterion("AGENT_BUILD_AUTO_PAYMENT =", value, "agentBuildAutoPayment");
            return (Criteria) this;
        }

        public Criteria andAgentBuildAutoPaymentNotEqualTo(Byte value) {
            addCriterion("AGENT_BUILD_AUTO_PAYMENT <>", value, "agentBuildAutoPayment");
            return (Criteria) this;
        }

        public Criteria andAgentBuildAutoPaymentGreaterThan(Byte value) {
            addCriterion("AGENT_BUILD_AUTO_PAYMENT >", value, "agentBuildAutoPayment");
            return (Criteria) this;
        }

        public Criteria andAgentBuildAutoPaymentGreaterThanOrEqualTo(Byte value) {
            addCriterion("AGENT_BUILD_AUTO_PAYMENT >=", value, "agentBuildAutoPayment");
            return (Criteria) this;
        }

        public Criteria andAgentBuildAutoPaymentLessThan(Byte value) {
            addCriterion("AGENT_BUILD_AUTO_PAYMENT <", value, "agentBuildAutoPayment");
            return (Criteria) this;
        }

        public Criteria andAgentBuildAutoPaymentLessThanOrEqualTo(Byte value) {
            addCriterion("AGENT_BUILD_AUTO_PAYMENT <=", value, "agentBuildAutoPayment");
            return (Criteria) this;
        }

        public Criteria andAgentBuildAutoPaymentIn(List<Byte> values) {
            addCriterion("AGENT_BUILD_AUTO_PAYMENT in", values, "agentBuildAutoPayment");
            return (Criteria) this;
        }

        public Criteria andAgentBuildAutoPaymentNotIn(List<Byte> values) {
            addCriterion("AGENT_BUILD_AUTO_PAYMENT not in", values, "agentBuildAutoPayment");
            return (Criteria) this;
        }

        public Criteria andAgentBuildAutoPaymentBetween(Byte value1, Byte value2) {
            addCriterion("AGENT_BUILD_AUTO_PAYMENT between", value1, value2, "agentBuildAutoPayment");
            return (Criteria) this;
        }

        public Criteria andAgentBuildAutoPaymentNotBetween(Byte value1, Byte value2) {
            addCriterion("AGENT_BUILD_AUTO_PAYMENT not between", value1, value2, "agentBuildAutoPayment");
            return (Criteria) this;
        }

        public Criteria andAcountsWarnFlagIsNull() {
            addCriterion("ACOUNTS_WARN_FLAG is null");
            return (Criteria) this;
        }

        public Criteria andAcountsWarnFlagIsNotNull() {
            addCriterion("ACOUNTS_WARN_FLAG is not null");
            return (Criteria) this;
        }

        public Criteria andAcountsWarnFlagEqualTo(Byte value) {
            addCriterion("ACOUNTS_WARN_FLAG =", value, "acountsWarnFlag");
            return (Criteria) this;
        }

        public Criteria andAcountsWarnFlagNotEqualTo(Byte value) {
            addCriterion("ACOUNTS_WARN_FLAG <>", value, "acountsWarnFlag");
            return (Criteria) this;
        }

        public Criteria andAcountsWarnFlagGreaterThan(Byte value) {
            addCriterion("ACOUNTS_WARN_FLAG >", value, "acountsWarnFlag");
            return (Criteria) this;
        }

        public Criteria andAcountsWarnFlagGreaterThanOrEqualTo(Byte value) {
            addCriterion("ACOUNTS_WARN_FLAG >=", value, "acountsWarnFlag");
            return (Criteria) this;
        }

        public Criteria andAcountsWarnFlagLessThan(Byte value) {
            addCriterion("ACOUNTS_WARN_FLAG <", value, "acountsWarnFlag");
            return (Criteria) this;
        }

        public Criteria andAcountsWarnFlagLessThanOrEqualTo(Byte value) {
            addCriterion("ACOUNTS_WARN_FLAG <=", value, "acountsWarnFlag");
            return (Criteria) this;
        }

        public Criteria andAcountsWarnFlagIn(List<Byte> values) {
            addCriterion("ACOUNTS_WARN_FLAG in", values, "acountsWarnFlag");
            return (Criteria) this;
        }

        public Criteria andAcountsWarnFlagNotIn(List<Byte> values) {
            addCriterion("ACOUNTS_WARN_FLAG not in", values, "acountsWarnFlag");
            return (Criteria) this;
        }

        public Criteria andAcountsWarnFlagBetween(Byte value1, Byte value2) {
            addCriterion("ACOUNTS_WARN_FLAG between", value1, value2, "acountsWarnFlag");
            return (Criteria) this;
        }

        public Criteria andAcountsWarnFlagNotBetween(Byte value1, Byte value2) {
            addCriterion("ACOUNTS_WARN_FLAG not between", value1, value2, "acountsWarnFlag");
            return (Criteria) this;
        }

        public Criteria andAccreditFeeIsNull() {
            addCriterion("ACCREDIT_FEE is null");
            return (Criteria) this;
        }

        public Criteria andAccreditFeeIsNotNull() {
            addCriterion("ACCREDIT_FEE is not null");
            return (Criteria) this;
        }

        public Criteria andAccreditFeeEqualTo(BigDecimal value) {
            addCriterion("ACCREDIT_FEE =", value, "accreditFee");
            return (Criteria) this;
        }

        public Criteria andAccreditFeeNotEqualTo(BigDecimal value) {
            addCriterion("ACCREDIT_FEE <>", value, "accreditFee");
            return (Criteria) this;
        }

        public Criteria andAccreditFeeGreaterThan(BigDecimal value) {
            addCriterion("ACCREDIT_FEE >", value, "accreditFee");
            return (Criteria) this;
        }

        public Criteria andAccreditFeeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("ACCREDIT_FEE >=", value, "accreditFee");
            return (Criteria) this;
        }

        public Criteria andAccreditFeeLessThan(BigDecimal value) {
            addCriterion("ACCREDIT_FEE <", value, "accreditFee");
            return (Criteria) this;
        }

        public Criteria andAccreditFeeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("ACCREDIT_FEE <=", value, "accreditFee");
            return (Criteria) this;
        }

        public Criteria andAccreditFeeIn(List<BigDecimal> values) {
            addCriterion("ACCREDIT_FEE in", values, "accreditFee");
            return (Criteria) this;
        }

        public Criteria andAccreditFeeNotIn(List<BigDecimal> values) {
            addCriterion("ACCREDIT_FEE not in", values, "accreditFee");
            return (Criteria) this;
        }

        public Criteria andAccreditFeeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ACCREDIT_FEE between", value1, value2, "accreditFee");
            return (Criteria) this;
        }

        public Criteria andAccreditFeeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ACCREDIT_FEE not between", value1, value2, "accreditFee");
            return (Criteria) this;
        }

        public Criteria andDepositIsNull() {
            addCriterion("DEPOSIT is null");
            return (Criteria) this;
        }

        public Criteria andDepositIsNotNull() {
            addCriterion("DEPOSIT is not null");
            return (Criteria) this;
        }

        public Criteria andDepositEqualTo(BigDecimal value) {
            addCriterion("DEPOSIT =", value, "deposit");
            return (Criteria) this;
        }

        public Criteria andDepositNotEqualTo(BigDecimal value) {
            addCriterion("DEPOSIT <>", value, "deposit");
            return (Criteria) this;
        }

        public Criteria andDepositGreaterThan(BigDecimal value) {
            addCriterion("DEPOSIT >", value, "deposit");
            return (Criteria) this;
        }

        public Criteria andDepositGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("DEPOSIT >=", value, "deposit");
            return (Criteria) this;
        }

        public Criteria andDepositLessThan(BigDecimal value) {
            addCriterion("DEPOSIT <", value, "deposit");
            return (Criteria) this;
        }

        public Criteria andDepositLessThanOrEqualTo(BigDecimal value) {
            addCriterion("DEPOSIT <=", value, "deposit");
            return (Criteria) this;
        }

        public Criteria andDepositIn(List<BigDecimal> values) {
            addCriterion("DEPOSIT in", values, "deposit");
            return (Criteria) this;
        }

        public Criteria andDepositNotIn(List<BigDecimal> values) {
            addCriterion("DEPOSIT not in", values, "deposit");
            return (Criteria) this;
        }

        public Criteria andDepositBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("DEPOSIT between", value1, value2, "deposit");
            return (Criteria) this;
        }

        public Criteria andDepositNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("DEPOSIT not between", value1, value2, "deposit");
            return (Criteria) this;
        }

        public Criteria andFinanceFlagIsNull() {
            addCriterion("FINANCE_FLAG is null");
            return (Criteria) this;
        }

        public Criteria andFinanceFlagIsNotNull() {
            addCriterion("FINANCE_FLAG is not null");
            return (Criteria) this;
        }

        public Criteria andFinanceFlagEqualTo(Byte value) {
            addCriterion("FINANCE_FLAG =", value, "financeFlag");
            return (Criteria) this;
        }

        public Criteria andFinanceFlagNotEqualTo(Byte value) {
            addCriterion("FINANCE_FLAG <>", value, "financeFlag");
            return (Criteria) this;
        }

        public Criteria andFinanceFlagGreaterThan(Byte value) {
            addCriterion("FINANCE_FLAG >", value, "financeFlag");
            return (Criteria) this;
        }

        public Criteria andFinanceFlagGreaterThanOrEqualTo(Byte value) {
            addCriterion("FINANCE_FLAG >=", value, "financeFlag");
            return (Criteria) this;
        }

        public Criteria andFinanceFlagLessThan(Byte value) {
            addCriterion("FINANCE_FLAG <", value, "financeFlag");
            return (Criteria) this;
        }

        public Criteria andFinanceFlagLessThanOrEqualTo(Byte value) {
            addCriterion("FINANCE_FLAG <=", value, "financeFlag");
            return (Criteria) this;
        }

        public Criteria andFinanceFlagIn(List<Byte> values) {
            addCriterion("FINANCE_FLAG in", values, "financeFlag");
            return (Criteria) this;
        }

        public Criteria andFinanceFlagNotIn(List<Byte> values) {
            addCriterion("FINANCE_FLAG not in", values, "financeFlag");
            return (Criteria) this;
        }

        public Criteria andFinanceFlagBetween(Byte value1, Byte value2) {
            addCriterion("FINANCE_FLAG between", value1, value2, "financeFlag");
            return (Criteria) this;
        }

        public Criteria andFinanceFlagNotBetween(Byte value1, Byte value2) {
            addCriterion("FINANCE_FLAG not between", value1, value2, "financeFlag");
            return (Criteria) this;
        }

        public Criteria andErpSystemNameIsNull() {
            addCriterion("ERP_SYSTEM_NAME is null");
            return (Criteria) this;
        }

        public Criteria andErpSystemNameIsNotNull() {
            addCriterion("ERP_SYSTEM_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andErpSystemNameEqualTo(String value) {
            addCriterion("ERP_SYSTEM_NAME =", value, "erpSystemName");
            return (Criteria) this;
        }

        public Criteria andErpSystemNameNotEqualTo(String value) {
            addCriterion("ERP_SYSTEM_NAME <>", value, "erpSystemName");
            return (Criteria) this;
        }

        public Criteria andErpSystemNameGreaterThan(String value) {
            addCriterion("ERP_SYSTEM_NAME >", value, "erpSystemName");
            return (Criteria) this;
        }

        public Criteria andErpSystemNameGreaterThanOrEqualTo(String value) {
            addCriterion("ERP_SYSTEM_NAME >=", value, "erpSystemName");
            return (Criteria) this;
        }

        public Criteria andErpSystemNameLessThan(String value) {
            addCriterion("ERP_SYSTEM_NAME <", value, "erpSystemName");
            return (Criteria) this;
        }

        public Criteria andErpSystemNameLessThanOrEqualTo(String value) {
            addCriterion("ERP_SYSTEM_NAME <=", value, "erpSystemName");
            return (Criteria) this;
        }

        public Criteria andErpSystemNameLike(String value) {
            addCriterion("ERP_SYSTEM_NAME like", value, "erpSystemName");
            return (Criteria) this;
        }

        public Criteria andErpSystemNameNotLike(String value) {
            addCriterion("ERP_SYSTEM_NAME not like", value, "erpSystemName");
            return (Criteria) this;
        }

        public Criteria andErpSystemNameIn(List<String> values) {
            addCriterion("ERP_SYSTEM_NAME in", values, "erpSystemName");
            return (Criteria) this;
        }

        public Criteria andErpSystemNameNotIn(List<String> values) {
            addCriterion("ERP_SYSTEM_NAME not in", values, "erpSystemName");
            return (Criteria) this;
        }

        public Criteria andErpSystemNameBetween(String value1, String value2) {
            addCriterion("ERP_SYSTEM_NAME between", value1, value2, "erpSystemName");
            return (Criteria) this;
        }

        public Criteria andErpSystemNameNotBetween(String value1, String value2) {
            addCriterion("ERP_SYSTEM_NAME not between", value1, value2, "erpSystemName");
            return (Criteria) this;
        }

        public Criteria andErpSystemIconIsNull() {
            addCriterion("ERP_SYSTEM_ICON is null");
            return (Criteria) this;
        }

        public Criteria andErpSystemIconIsNotNull() {
            addCriterion("ERP_SYSTEM_ICON is not null");
            return (Criteria) this;
        }

        public Criteria andErpSystemIconEqualTo(String value) {
            addCriterion("ERP_SYSTEM_ICON =", value, "erpSystemIcon");
            return (Criteria) this;
        }

        public Criteria andErpSystemIconNotEqualTo(String value) {
            addCriterion("ERP_SYSTEM_ICON <>", value, "erpSystemIcon");
            return (Criteria) this;
        }

        public Criteria andErpSystemIconGreaterThan(String value) {
            addCriterion("ERP_SYSTEM_ICON >", value, "erpSystemIcon");
            return (Criteria) this;
        }

        public Criteria andErpSystemIconGreaterThanOrEqualTo(String value) {
            addCriterion("ERP_SYSTEM_ICON >=", value, "erpSystemIcon");
            return (Criteria) this;
        }

        public Criteria andErpSystemIconLessThan(String value) {
            addCriterion("ERP_SYSTEM_ICON <", value, "erpSystemIcon");
            return (Criteria) this;
        }

        public Criteria andErpSystemIconLessThanOrEqualTo(String value) {
            addCriterion("ERP_SYSTEM_ICON <=", value, "erpSystemIcon");
            return (Criteria) this;
        }

        public Criteria andErpSystemIconLike(String value) {
            addCriterion("ERP_SYSTEM_ICON like", value, "erpSystemIcon");
            return (Criteria) this;
        }

        public Criteria andErpSystemIconNotLike(String value) {
            addCriterion("ERP_SYSTEM_ICON not like", value, "erpSystemIcon");
            return (Criteria) this;
        }

        public Criteria andErpSystemIconIn(List<String> values) {
            addCriterion("ERP_SYSTEM_ICON in", values, "erpSystemIcon");
            return (Criteria) this;
        }

        public Criteria andErpSystemIconNotIn(List<String> values) {
            addCriterion("ERP_SYSTEM_ICON not in", values, "erpSystemIcon");
            return (Criteria) this;
        }

        public Criteria andErpSystemIconBetween(String value1, String value2) {
            addCriterion("ERP_SYSTEM_ICON between", value1, value2, "erpSystemIcon");
            return (Criteria) this;
        }

        public Criteria andErpSystemIconNotBetween(String value1, String value2) {
            addCriterion("ERP_SYSTEM_ICON not between", value1, value2, "erpSystemIcon");
            return (Criteria) this;
        }

        public Criteria andErpSystemNavigationBackgroundIsNull() {
            addCriterion("ERP_SYSTEM_NAVIGATION_BACKGROUND is null");
            return (Criteria) this;
        }

        public Criteria andErpSystemNavigationBackgroundIsNotNull() {
            addCriterion("ERP_SYSTEM_NAVIGATION_BACKGROUND is not null");
            return (Criteria) this;
        }

        public Criteria andErpSystemNavigationBackgroundEqualTo(String value) {
            addCriterion("ERP_SYSTEM_NAVIGATION_BACKGROUND =", value, "erpSystemNavigationBackground");
            return (Criteria) this;
        }

        public Criteria andErpSystemNavigationBackgroundNotEqualTo(String value) {
            addCriterion("ERP_SYSTEM_NAVIGATION_BACKGROUND <>", value, "erpSystemNavigationBackground");
            return (Criteria) this;
        }

        public Criteria andErpSystemNavigationBackgroundGreaterThan(String value) {
            addCriterion("ERP_SYSTEM_NAVIGATION_BACKGROUND >", value, "erpSystemNavigationBackground");
            return (Criteria) this;
        }

        public Criteria andErpSystemNavigationBackgroundGreaterThanOrEqualTo(String value) {
            addCriterion("ERP_SYSTEM_NAVIGATION_BACKGROUND >=", value, "erpSystemNavigationBackground");
            return (Criteria) this;
        }

        public Criteria andErpSystemNavigationBackgroundLessThan(String value) {
            addCriterion("ERP_SYSTEM_NAVIGATION_BACKGROUND <", value, "erpSystemNavigationBackground");
            return (Criteria) this;
        }

        public Criteria andErpSystemNavigationBackgroundLessThanOrEqualTo(String value) {
            addCriterion("ERP_SYSTEM_NAVIGATION_BACKGROUND <=", value, "erpSystemNavigationBackground");
            return (Criteria) this;
        }

        public Criteria andErpSystemNavigationBackgroundLike(String value) {
            addCriterion("ERP_SYSTEM_NAVIGATION_BACKGROUND like", value, "erpSystemNavigationBackground");
            return (Criteria) this;
        }

        public Criteria andErpSystemNavigationBackgroundNotLike(String value) {
            addCriterion("ERP_SYSTEM_NAVIGATION_BACKGROUND not like", value, "erpSystemNavigationBackground");
            return (Criteria) this;
        }

        public Criteria andErpSystemNavigationBackgroundIn(List<String> values) {
            addCriterion("ERP_SYSTEM_NAVIGATION_BACKGROUND in", values, "erpSystemNavigationBackground");
            return (Criteria) this;
        }

        public Criteria andErpSystemNavigationBackgroundNotIn(List<String> values) {
            addCriterion("ERP_SYSTEM_NAVIGATION_BACKGROUND not in", values, "erpSystemNavigationBackground");
            return (Criteria) this;
        }

        public Criteria andErpSystemNavigationBackgroundBetween(String value1, String value2) {
            addCriterion("ERP_SYSTEM_NAVIGATION_BACKGROUND between", value1, value2, "erpSystemNavigationBackground");
            return (Criteria) this;
        }

        public Criteria andErpSystemNavigationBackgroundNotBetween(String value1, String value2) {
            addCriterion("ERP_SYSTEM_NAVIGATION_BACKGROUND not between", value1, value2, "erpSystemNavigationBackground");
            return (Criteria) this;
        }

        public Criteria andErpSystemPopupWindowBackgroundIsNull() {
            addCriterion("ERP_SYSTEM_POPUP_WINDOW_BACKGROUND is null");
            return (Criteria) this;
        }

        public Criteria andErpSystemPopupWindowBackgroundIsNotNull() {
            addCriterion("ERP_SYSTEM_POPUP_WINDOW_BACKGROUND is not null");
            return (Criteria) this;
        }

        public Criteria andErpSystemPopupWindowBackgroundEqualTo(String value) {
            addCriterion("ERP_SYSTEM_POPUP_WINDOW_BACKGROUND =", value, "erpSystemPopupWindowBackground");
            return (Criteria) this;
        }

        public Criteria andErpSystemPopupWindowBackgroundNotEqualTo(String value) {
            addCriterion("ERP_SYSTEM_POPUP_WINDOW_BACKGROUND <>", value, "erpSystemPopupWindowBackground");
            return (Criteria) this;
        }

        public Criteria andErpSystemPopupWindowBackgroundGreaterThan(String value) {
            addCriterion("ERP_SYSTEM_POPUP_WINDOW_BACKGROUND >", value, "erpSystemPopupWindowBackground");
            return (Criteria) this;
        }

        public Criteria andErpSystemPopupWindowBackgroundGreaterThanOrEqualTo(String value) {
            addCriterion("ERP_SYSTEM_POPUP_WINDOW_BACKGROUND >=", value, "erpSystemPopupWindowBackground");
            return (Criteria) this;
        }

        public Criteria andErpSystemPopupWindowBackgroundLessThan(String value) {
            addCriterion("ERP_SYSTEM_POPUP_WINDOW_BACKGROUND <", value, "erpSystemPopupWindowBackground");
            return (Criteria) this;
        }

        public Criteria andErpSystemPopupWindowBackgroundLessThanOrEqualTo(String value) {
            addCriterion("ERP_SYSTEM_POPUP_WINDOW_BACKGROUND <=", value, "erpSystemPopupWindowBackground");
            return (Criteria) this;
        }

        public Criteria andErpSystemPopupWindowBackgroundLike(String value) {
            addCriterion("ERP_SYSTEM_POPUP_WINDOW_BACKGROUND like", value, "erpSystemPopupWindowBackground");
            return (Criteria) this;
        }

        public Criteria andErpSystemPopupWindowBackgroundNotLike(String value) {
            addCriterion("ERP_SYSTEM_POPUP_WINDOW_BACKGROUND not like", value, "erpSystemPopupWindowBackground");
            return (Criteria) this;
        }

        public Criteria andErpSystemPopupWindowBackgroundIn(List<String> values) {
            addCriterion("ERP_SYSTEM_POPUP_WINDOW_BACKGROUND in", values, "erpSystemPopupWindowBackground");
            return (Criteria) this;
        }

        public Criteria andErpSystemPopupWindowBackgroundNotIn(List<String> values) {
            addCriterion("ERP_SYSTEM_POPUP_WINDOW_BACKGROUND not in", values, "erpSystemPopupWindowBackground");
            return (Criteria) this;
        }

        public Criteria andErpSystemPopupWindowBackgroundBetween(String value1, String value2) {
            addCriterion("ERP_SYSTEM_POPUP_WINDOW_BACKGROUND between", value1, value2, "erpSystemPopupWindowBackground");
            return (Criteria) this;
        }

        public Criteria andErpSystemPopupWindowBackgroundNotBetween(String value1, String value2) {
            addCriterion("ERP_SYSTEM_POPUP_WINDOW_BACKGROUND not between", value1, value2, "erpSystemPopupWindowBackground");
            return (Criteria) this;
        }

        public Criteria andErpSystemTonalIsNull() {
            addCriterion("ERP_SYSTEM_TONAL is null");
            return (Criteria) this;
        }

        public Criteria andErpSystemTonalIsNotNull() {
            addCriterion("ERP_SYSTEM_TONAL is not null");
            return (Criteria) this;
        }

        public Criteria andErpSystemTonalEqualTo(String value) {
            addCriterion("ERP_SYSTEM_TONAL =", value, "erpSystemTonal");
            return (Criteria) this;
        }

        public Criteria andErpSystemTonalNotEqualTo(String value) {
            addCriterion("ERP_SYSTEM_TONAL <>", value, "erpSystemTonal");
            return (Criteria) this;
        }

        public Criteria andErpSystemTonalGreaterThan(String value) {
            addCriterion("ERP_SYSTEM_TONAL >", value, "erpSystemTonal");
            return (Criteria) this;
        }

        public Criteria andErpSystemTonalGreaterThanOrEqualTo(String value) {
            addCriterion("ERP_SYSTEM_TONAL >=", value, "erpSystemTonal");
            return (Criteria) this;
        }

        public Criteria andErpSystemTonalLessThan(String value) {
            addCriterion("ERP_SYSTEM_TONAL <", value, "erpSystemTonal");
            return (Criteria) this;
        }

        public Criteria andErpSystemTonalLessThanOrEqualTo(String value) {
            addCriterion("ERP_SYSTEM_TONAL <=", value, "erpSystemTonal");
            return (Criteria) this;
        }

        public Criteria andErpSystemTonalLike(String value) {
            addCriterion("ERP_SYSTEM_TONAL like", value, "erpSystemTonal");
            return (Criteria) this;
        }

        public Criteria andErpSystemTonalNotLike(String value) {
            addCriterion("ERP_SYSTEM_TONAL not like", value, "erpSystemTonal");
            return (Criteria) this;
        }

        public Criteria andErpSystemTonalIn(List<String> values) {
            addCriterion("ERP_SYSTEM_TONAL in", values, "erpSystemTonal");
            return (Criteria) this;
        }

        public Criteria andErpSystemTonalNotIn(List<String> values) {
            addCriterion("ERP_SYSTEM_TONAL not in", values, "erpSystemTonal");
            return (Criteria) this;
        }

        public Criteria andErpSystemTonalBetween(String value1, String value2) {
            addCriterion("ERP_SYSTEM_TONAL between", value1, value2, "erpSystemTonal");
            return (Criteria) this;
        }

        public Criteria andErpSystemTonalNotBetween(String value1, String value2) {
            addCriterion("ERP_SYSTEM_TONAL not between", value1, value2, "erpSystemTonal");
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