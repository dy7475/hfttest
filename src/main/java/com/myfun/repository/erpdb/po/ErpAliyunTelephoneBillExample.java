package com.myfun.repository.erpdb.po;

import com.myfun.repository.support.generator.shard.ShardDb;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ErpAliyunTelephoneBillExample extends ShardDb {
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
    public ErpAliyunTelephoneBillExample() {
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

        public Criteria andAPhoneIsNull() {
            addCriterion("A_PHONE is null");
            return (Criteria) this;
        }

        public Criteria andAPhoneIsNotNull() {
            addCriterion("A_PHONE is not null");
            return (Criteria) this;
        }

        public Criteria andAPhoneEqualTo(String value) {
            addCriterion("A_PHONE =", value, "aPhone");
            return (Criteria) this;
        }

        public Criteria andAPhoneNotEqualTo(String value) {
            addCriterion("A_PHONE <>", value, "aPhone");
            return (Criteria) this;
        }

        public Criteria andAPhoneGreaterThan(String value) {
            addCriterion("A_PHONE >", value, "aPhone");
            return (Criteria) this;
        }

        public Criteria andAPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("A_PHONE >=", value, "aPhone");
            return (Criteria) this;
        }

        public Criteria andAPhoneLessThan(String value) {
            addCriterion("A_PHONE <", value, "aPhone");
            return (Criteria) this;
        }

        public Criteria andAPhoneLessThanOrEqualTo(String value) {
            addCriterion("A_PHONE <=", value, "aPhone");
            return (Criteria) this;
        }

        public Criteria andAPhoneLike(String value) {
            addCriterion("A_PHONE like", value, "aPhone");
            return (Criteria) this;
        }

        public Criteria andAPhoneNotLike(String value) {
            addCriterion("A_PHONE not like", value, "aPhone");
            return (Criteria) this;
        }

        public Criteria andAPhoneIn(List<String> values) {
            addCriterion("A_PHONE in", values, "aPhone");
            return (Criteria) this;
        }

        public Criteria andAPhoneNotIn(List<String> values) {
            addCriterion("A_PHONE not in", values, "aPhone");
            return (Criteria) this;
        }

        public Criteria andAPhoneBetween(String value1, String value2) {
            addCriterion("A_PHONE between", value1, value2, "aPhone");
            return (Criteria) this;
        }

        public Criteria andAPhoneNotBetween(String value1, String value2) {
            addCriterion("A_PHONE not between", value1, value2, "aPhone");
            return (Criteria) this;
        }

        public Criteria andXPhoneIsNull() {
            addCriterion("X_PHONE is null");
            return (Criteria) this;
        }

        public Criteria andXPhoneIsNotNull() {
            addCriterion("X_PHONE is not null");
            return (Criteria) this;
        }

        public Criteria andXPhoneEqualTo(String value) {
            addCriterion("X_PHONE =", value, "xPhone");
            return (Criteria) this;
        }

        public Criteria andXPhoneNotEqualTo(String value) {
            addCriterion("X_PHONE <>", value, "xPhone");
            return (Criteria) this;
        }

        public Criteria andXPhoneGreaterThan(String value) {
            addCriterion("X_PHONE >", value, "xPhone");
            return (Criteria) this;
        }

        public Criteria andXPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("X_PHONE >=", value, "xPhone");
            return (Criteria) this;
        }

        public Criteria andXPhoneLessThan(String value) {
            addCriterion("X_PHONE <", value, "xPhone");
            return (Criteria) this;
        }

        public Criteria andXPhoneLessThanOrEqualTo(String value) {
            addCriterion("X_PHONE <=", value, "xPhone");
            return (Criteria) this;
        }

        public Criteria andXPhoneLike(String value) {
            addCriterion("X_PHONE like", value, "xPhone");
            return (Criteria) this;
        }

        public Criteria andXPhoneNotLike(String value) {
            addCriterion("X_PHONE not like", value, "xPhone");
            return (Criteria) this;
        }

        public Criteria andXPhoneIn(List<String> values) {
            addCriterion("X_PHONE in", values, "xPhone");
            return (Criteria) this;
        }

        public Criteria andXPhoneNotIn(List<String> values) {
            addCriterion("X_PHONE not in", values, "xPhone");
            return (Criteria) this;
        }

        public Criteria andXPhoneBetween(String value1, String value2) {
            addCriterion("X_PHONE between", value1, value2, "xPhone");
            return (Criteria) this;
        }

        public Criteria andXPhoneNotBetween(String value1, String value2) {
            addCriterion("X_PHONE not between", value1, value2, "xPhone");
            return (Criteria) this;
        }

        public Criteria andBindATimeIsNull() {
            addCriterion("BIND_A_TIME is null");
            return (Criteria) this;
        }

        public Criteria andBindATimeIsNotNull() {
            addCriterion("BIND_A_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andBindATimeEqualTo(Date value) {
            addCriterion("BIND_A_TIME =", value, "bindATime");
            return (Criteria) this;
        }

        public Criteria andBindATimeNotEqualTo(Date value) {
            addCriterion("BIND_A_TIME <>", value, "bindATime");
            return (Criteria) this;
        }

        public Criteria andBindATimeGreaterThan(Date value) {
            addCriterion("BIND_A_TIME >", value, "bindATime");
            return (Criteria) this;
        }

        public Criteria andBindATimeGreaterThanOrEqualTo(Date value) {
            addCriterion("BIND_A_TIME >=", value, "bindATime");
            return (Criteria) this;
        }

        public Criteria andBindATimeLessThan(Date value) {
            addCriterion("BIND_A_TIME <", value, "bindATime");
            return (Criteria) this;
        }

        public Criteria andBindATimeLessThanOrEqualTo(Date value) {
            addCriterion("BIND_A_TIME <=", value, "bindATime");
            return (Criteria) this;
        }

        public Criteria andBindATimeIn(List<Date> values) {
            addCriterion("BIND_A_TIME in", values, "bindATime");
            return (Criteria) this;
        }

        public Criteria andBindATimeNotIn(List<Date> values) {
            addCriterion("BIND_A_TIME not in", values, "bindATime");
            return (Criteria) this;
        }

        public Criteria andBindATimeBetween(Date value1, Date value2) {
            addCriterion("BIND_A_TIME between", value1, value2, "bindATime");
            return (Criteria) this;
        }

        public Criteria andBindATimeNotBetween(Date value1, Date value2) {
            addCriterion("BIND_A_TIME not between", value1, value2, "bindATime");
            return (Criteria) this;
        }

        public Criteria andOrgIdIsNull() {
            addCriterion("ORG_ID is null");
            return (Criteria) this;
        }

        public Criteria andOrgIdIsNotNull() {
            addCriterion("ORG_ID is not null");
            return (Criteria) this;
        }

        public Criteria andOrgIdEqualTo(Integer value) {
            addCriterion("ORG_ID =", value, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdNotEqualTo(Integer value) {
            addCriterion("ORG_ID <>", value, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdGreaterThan(Integer value) {
            addCriterion("ORG_ID >", value, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("ORG_ID >=", value, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdLessThan(Integer value) {
            addCriterion("ORG_ID <", value, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdLessThanOrEqualTo(Integer value) {
            addCriterion("ORG_ID <=", value, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdIn(List<Integer> values) {
            addCriterion("ORG_ID in", values, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdNotIn(List<Integer> values) {
            addCriterion("ORG_ID not in", values, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdBetween(Integer value1, Integer value2) {
            addCriterion("ORG_ID between", value1, value2, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdNotBetween(Integer value1, Integer value2) {
            addCriterion("ORG_ID not between", value1, value2, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgNameIsNull() {
            addCriterion("ORG_NAME is null");
            return (Criteria) this;
        }

        public Criteria andOrgNameIsNotNull() {
            addCriterion("ORG_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andOrgNameEqualTo(String value) {
            addCriterion("ORG_NAME =", value, "orgName");
            return (Criteria) this;
        }

        public Criteria andOrgNameNotEqualTo(String value) {
            addCriterion("ORG_NAME <>", value, "orgName");
            return (Criteria) this;
        }

        public Criteria andOrgNameGreaterThan(String value) {
            addCriterion("ORG_NAME >", value, "orgName");
            return (Criteria) this;
        }

        public Criteria andOrgNameGreaterThanOrEqualTo(String value) {
            addCriterion("ORG_NAME >=", value, "orgName");
            return (Criteria) this;
        }

        public Criteria andOrgNameLessThan(String value) {
            addCriterion("ORG_NAME <", value, "orgName");
            return (Criteria) this;
        }

        public Criteria andOrgNameLessThanOrEqualTo(String value) {
            addCriterion("ORG_NAME <=", value, "orgName");
            return (Criteria) this;
        }

        public Criteria andOrgNameLike(String value) {
            addCriterion("ORG_NAME like", value, "orgName");
            return (Criteria) this;
        }

        public Criteria andOrgNameNotLike(String value) {
            addCriterion("ORG_NAME not like", value, "orgName");
            return (Criteria) this;
        }

        public Criteria andOrgNameIn(List<String> values) {
            addCriterion("ORG_NAME in", values, "orgName");
            return (Criteria) this;
        }

        public Criteria andOrgNameNotIn(List<String> values) {
            addCriterion("ORG_NAME not in", values, "orgName");
            return (Criteria) this;
        }

        public Criteria andOrgNameBetween(String value1, String value2) {
            addCriterion("ORG_NAME between", value1, value2, "orgName");
            return (Criteria) this;
        }

        public Criteria andOrgNameNotBetween(String value1, String value2) {
            addCriterion("ORG_NAME not between", value1, value2, "orgName");
            return (Criteria) this;
        }

        public Criteria andOrgNoIsNull() {
            addCriterion("ORG_NO is null");
            return (Criteria) this;
        }

        public Criteria andOrgNoIsNotNull() {
            addCriterion("ORG_NO is not null");
            return (Criteria) this;
        }

        public Criteria andOrgNoEqualTo(String value) {
            addCriterion("ORG_NO =", value, "orgNo");
            return (Criteria) this;
        }

        public Criteria andOrgNoNotEqualTo(String value) {
            addCriterion("ORG_NO <>", value, "orgNo");
            return (Criteria) this;
        }

        public Criteria andOrgNoGreaterThan(String value) {
            addCriterion("ORG_NO >", value, "orgNo");
            return (Criteria) this;
        }

        public Criteria andOrgNoGreaterThanOrEqualTo(String value) {
            addCriterion("ORG_NO >=", value, "orgNo");
            return (Criteria) this;
        }

        public Criteria andOrgNoLessThan(String value) {
            addCriterion("ORG_NO <", value, "orgNo");
            return (Criteria) this;
        }

        public Criteria andOrgNoLessThanOrEqualTo(String value) {
            addCriterion("ORG_NO <=", value, "orgNo");
            return (Criteria) this;
        }

        public Criteria andOrgNoLike(String value) {
            addCriterion("ORG_NO like", value, "orgNo");
            return (Criteria) this;
        }

        public Criteria andOrgNoNotLike(String value) {
            addCriterion("ORG_NO not like", value, "orgNo");
            return (Criteria) this;
        }

        public Criteria andOrgNoIn(List<String> values) {
            addCriterion("ORG_NO in", values, "orgNo");
            return (Criteria) this;
        }

        public Criteria andOrgNoNotIn(List<String> values) {
            addCriterion("ORG_NO not in", values, "orgNo");
            return (Criteria) this;
        }

        public Criteria andOrgNoBetween(String value1, String value2) {
            addCriterion("ORG_NO between", value1, value2, "orgNo");
            return (Criteria) this;
        }

        public Criteria andOrgNoNotBetween(String value1, String value2) {
            addCriterion("ORG_NO not between", value1, value2, "orgNo");
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

        public Criteria andUserNameIsNull() {
            addCriterion("USER_NAME is null");
            return (Criteria) this;
        }

        public Criteria andUserNameIsNotNull() {
            addCriterion("USER_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andUserNameEqualTo(String value) {
            addCriterion("USER_NAME =", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotEqualTo(String value) {
            addCriterion("USER_NAME <>", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameGreaterThan(String value) {
            addCriterion("USER_NAME >", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameGreaterThanOrEqualTo(String value) {
            addCriterion("USER_NAME >=", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLessThan(String value) {
            addCriterion("USER_NAME <", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLessThanOrEqualTo(String value) {
            addCriterion("USER_NAME <=", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLike(String value) {
            addCriterion("USER_NAME like", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotLike(String value) {
            addCriterion("USER_NAME not like", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameIn(List<String> values) {
            addCriterion("USER_NAME in", values, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotIn(List<String> values) {
            addCriterion("USER_NAME not in", values, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameBetween(String value1, String value2) {
            addCriterion("USER_NAME between", value1, value2, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotBetween(String value1, String value2) {
            addCriterion("USER_NAME not between", value1, value2, "userName");
            return (Criteria) this;
        }

        public Criteria andTelePhoneBillIsNull() {
            addCriterion("TELE_PHONE_BILL is null");
            return (Criteria) this;
        }

        public Criteria andTelePhoneBillIsNotNull() {
            addCriterion("TELE_PHONE_BILL is not null");
            return (Criteria) this;
        }

        public Criteria andTelePhoneBillEqualTo(BigDecimal value) {
            addCriterion("TELE_PHONE_BILL =", value, "telePhoneBill");
            return (Criteria) this;
        }

        public Criteria andTelePhoneBillNotEqualTo(BigDecimal value) {
            addCriterion("TELE_PHONE_BILL <>", value, "telePhoneBill");
            return (Criteria) this;
        }

        public Criteria andTelePhoneBillGreaterThan(BigDecimal value) {
            addCriterion("TELE_PHONE_BILL >", value, "telePhoneBill");
            return (Criteria) this;
        }

        public Criteria andTelePhoneBillGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("TELE_PHONE_BILL >=", value, "telePhoneBill");
            return (Criteria) this;
        }

        public Criteria andTelePhoneBillLessThan(BigDecimal value) {
            addCriterion("TELE_PHONE_BILL <", value, "telePhoneBill");
            return (Criteria) this;
        }

        public Criteria andTelePhoneBillLessThanOrEqualTo(BigDecimal value) {
            addCriterion("TELE_PHONE_BILL <=", value, "telePhoneBill");
            return (Criteria) this;
        }

        public Criteria andTelePhoneBillIn(List<BigDecimal> values) {
            addCriterion("TELE_PHONE_BILL in", values, "telePhoneBill");
            return (Criteria) this;
        }

        public Criteria andTelePhoneBillNotIn(List<BigDecimal> values) {
            addCriterion("TELE_PHONE_BILL not in", values, "telePhoneBill");
            return (Criteria) this;
        }

        public Criteria andTelePhoneBillBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("TELE_PHONE_BILL between", value1, value2, "telePhoneBill");
            return (Criteria) this;
        }

        public Criteria andTelePhoneBillNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("TELE_PHONE_BILL not between", value1, value2, "telePhoneBill");
            return (Criteria) this;
        }

        public Criteria andMonthlyrentIsNull() {
            addCriterion("MONTHLYRENT is null");
            return (Criteria) this;
        }

        public Criteria andMonthlyrentIsNotNull() {
            addCriterion("MONTHLYRENT is not null");
            return (Criteria) this;
        }

        public Criteria andMonthlyrentEqualTo(BigDecimal value) {
            addCriterion("MONTHLYRENT =", value, "monthlyrent");
            return (Criteria) this;
        }

        public Criteria andMonthlyrentNotEqualTo(BigDecimal value) {
            addCriterion("MONTHLYRENT <>", value, "monthlyrent");
            return (Criteria) this;
        }

        public Criteria andMonthlyrentGreaterThan(BigDecimal value) {
            addCriterion("MONTHLYRENT >", value, "monthlyrent");
            return (Criteria) this;
        }

        public Criteria andMonthlyrentGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("MONTHLYRENT >=", value, "monthlyrent");
            return (Criteria) this;
        }

        public Criteria andMonthlyrentLessThan(BigDecimal value) {
            addCriterion("MONTHLYRENT <", value, "monthlyrent");
            return (Criteria) this;
        }

        public Criteria andMonthlyrentLessThanOrEqualTo(BigDecimal value) {
            addCriterion("MONTHLYRENT <=", value, "monthlyrent");
            return (Criteria) this;
        }

        public Criteria andMonthlyrentIn(List<BigDecimal> values) {
            addCriterion("MONTHLYRENT in", values, "monthlyrent");
            return (Criteria) this;
        }

        public Criteria andMonthlyrentNotIn(List<BigDecimal> values) {
            addCriterion("MONTHLYRENT not in", values, "monthlyrent");
            return (Criteria) this;
        }

        public Criteria andMonthlyrentBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("MONTHLYRENT between", value1, value2, "monthlyrent");
            return (Criteria) this;
        }

        public Criteria andMonthlyrentNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("MONTHLYRENT not between", value1, value2, "monthlyrent");
            return (Criteria) this;
        }

        public Criteria andOtherBillIsNull() {
            addCriterion("OTHER_BILL is null");
            return (Criteria) this;
        }

        public Criteria andOtherBillIsNotNull() {
            addCriterion("OTHER_BILL is not null");
            return (Criteria) this;
        }

        public Criteria andOtherBillEqualTo(BigDecimal value) {
            addCriterion("OTHER_BILL =", value, "otherBill");
            return (Criteria) this;
        }

        public Criteria andOtherBillNotEqualTo(BigDecimal value) {
            addCriterion("OTHER_BILL <>", value, "otherBill");
            return (Criteria) this;
        }

        public Criteria andOtherBillGreaterThan(BigDecimal value) {
            addCriterion("OTHER_BILL >", value, "otherBill");
            return (Criteria) this;
        }

        public Criteria andOtherBillGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("OTHER_BILL >=", value, "otherBill");
            return (Criteria) this;
        }

        public Criteria andOtherBillLessThan(BigDecimal value) {
            addCriterion("OTHER_BILL <", value, "otherBill");
            return (Criteria) this;
        }

        public Criteria andOtherBillLessThanOrEqualTo(BigDecimal value) {
            addCriterion("OTHER_BILL <=", value, "otherBill");
            return (Criteria) this;
        }

        public Criteria andOtherBillIn(List<BigDecimal> values) {
            addCriterion("OTHER_BILL in", values, "otherBill");
            return (Criteria) this;
        }

        public Criteria andOtherBillNotIn(List<BigDecimal> values) {
            addCriterion("OTHER_BILL not in", values, "otherBill");
            return (Criteria) this;
        }

        public Criteria andOtherBillBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("OTHER_BILL between", value1, value2, "otherBill");
            return (Criteria) this;
        }

        public Criteria andOtherBillNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("OTHER_BILL not between", value1, value2, "otherBill");
            return (Criteria) this;
        }

        public Criteria andRecordingIsNull() {
            addCriterion("RECORDING is null");
            return (Criteria) this;
        }

        public Criteria andRecordingIsNotNull() {
            addCriterion("RECORDING is not null");
            return (Criteria) this;
        }

        public Criteria andRecordingEqualTo(BigDecimal value) {
            addCriterion("RECORDING =", value, "recording");
            return (Criteria) this;
        }

        public Criteria andRecordingNotEqualTo(BigDecimal value) {
            addCriterion("RECORDING <>", value, "recording");
            return (Criteria) this;
        }

        public Criteria andRecordingGreaterThan(BigDecimal value) {
            addCriterion("RECORDING >", value, "recording");
            return (Criteria) this;
        }

        public Criteria andRecordingGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("RECORDING >=", value, "recording");
            return (Criteria) this;
        }

        public Criteria andRecordingLessThan(BigDecimal value) {
            addCriterion("RECORDING <", value, "recording");
            return (Criteria) this;
        }

        public Criteria andRecordingLessThanOrEqualTo(BigDecimal value) {
            addCriterion("RECORDING <=", value, "recording");
            return (Criteria) this;
        }

        public Criteria andRecordingIn(List<BigDecimal> values) {
            addCriterion("RECORDING in", values, "recording");
            return (Criteria) this;
        }

        public Criteria andRecordingNotIn(List<BigDecimal> values) {
            addCriterion("RECORDING not in", values, "recording");
            return (Criteria) this;
        }

        public Criteria andRecordingBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("RECORDING between", value1, value2, "recording");
            return (Criteria) this;
        }

        public Criteria andRecordingNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("RECORDING not between", value1, value2, "recording");
            return (Criteria) this;
        }

        public Criteria andAllMoneyIsNull() {
            addCriterion("ALL_MONEY is null");
            return (Criteria) this;
        }

        public Criteria andAllMoneyIsNotNull() {
            addCriterion("ALL_MONEY is not null");
            return (Criteria) this;
        }

        public Criteria andAllMoneyEqualTo(BigDecimal value) {
            addCriterion("ALL_MONEY =", value, "allMoney");
            return (Criteria) this;
        }

        public Criteria andAllMoneyNotEqualTo(BigDecimal value) {
            addCriterion("ALL_MONEY <>", value, "allMoney");
            return (Criteria) this;
        }

        public Criteria andAllMoneyGreaterThan(BigDecimal value) {
            addCriterion("ALL_MONEY >", value, "allMoney");
            return (Criteria) this;
        }

        public Criteria andAllMoneyGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("ALL_MONEY >=", value, "allMoney");
            return (Criteria) this;
        }

        public Criteria andAllMoneyLessThan(BigDecimal value) {
            addCriterion("ALL_MONEY <", value, "allMoney");
            return (Criteria) this;
        }

        public Criteria andAllMoneyLessThanOrEqualTo(BigDecimal value) {
            addCriterion("ALL_MONEY <=", value, "allMoney");
            return (Criteria) this;
        }

        public Criteria andAllMoneyIn(List<BigDecimal> values) {
            addCriterion("ALL_MONEY in", values, "allMoney");
            return (Criteria) this;
        }

        public Criteria andAllMoneyNotIn(List<BigDecimal> values) {
            addCriterion("ALL_MONEY not in", values, "allMoney");
            return (Criteria) this;
        }

        public Criteria andAllMoneyBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ALL_MONEY between", value1, value2, "allMoney");
            return (Criteria) this;
        }

        public Criteria andAllMoneyNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ALL_MONEY not between", value1, value2, "allMoney");
            return (Criteria) this;
        }

        public Criteria andToallTimeIsNull() {
            addCriterion("TOALL_TIME is null");
            return (Criteria) this;
        }

        public Criteria andToallTimeIsNotNull() {
            addCriterion("TOALL_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andToallTimeEqualTo(Integer value) {
            addCriterion("TOALL_TIME =", value, "toallTime");
            return (Criteria) this;
        }

        public Criteria andToallTimeNotEqualTo(Integer value) {
            addCriterion("TOALL_TIME <>", value, "toallTime");
            return (Criteria) this;
        }

        public Criteria andToallTimeGreaterThan(Integer value) {
            addCriterion("TOALL_TIME >", value, "toallTime");
            return (Criteria) this;
        }

        public Criteria andToallTimeGreaterThanOrEqualTo(Integer value) {
            addCriterion("TOALL_TIME >=", value, "toallTime");
            return (Criteria) this;
        }

        public Criteria andToallTimeLessThan(Integer value) {
            addCriterion("TOALL_TIME <", value, "toallTime");
            return (Criteria) this;
        }

        public Criteria andToallTimeLessThanOrEqualTo(Integer value) {
            addCriterion("TOALL_TIME <=", value, "toallTime");
            return (Criteria) this;
        }

        public Criteria andToallTimeIn(List<Integer> values) {
            addCriterion("TOALL_TIME in", values, "toallTime");
            return (Criteria) this;
        }

        public Criteria andToallTimeNotIn(List<Integer> values) {
            addCriterion("TOALL_TIME not in", values, "toallTime");
            return (Criteria) this;
        }

        public Criteria andToallTimeBetween(Integer value1, Integer value2) {
            addCriterion("TOALL_TIME between", value1, value2, "toallTime");
            return (Criteria) this;
        }

        public Criteria andToallTimeNotBetween(Integer value1, Integer value2) {
            addCriterion("TOALL_TIME not between", value1, value2, "toallTime");
            return (Criteria) this;
        }

        public Criteria andToallCountIsNull() {
            addCriterion("TOALL_COUNT is null");
            return (Criteria) this;
        }

        public Criteria andToallCountIsNotNull() {
            addCriterion("TOALL_COUNT is not null");
            return (Criteria) this;
        }

        public Criteria andToallCountEqualTo(Integer value) {
            addCriterion("TOALL_COUNT =", value, "toallCount");
            return (Criteria) this;
        }

        public Criteria andToallCountNotEqualTo(Integer value) {
            addCriterion("TOALL_COUNT <>", value, "toallCount");
            return (Criteria) this;
        }

        public Criteria andToallCountGreaterThan(Integer value) {
            addCriterion("TOALL_COUNT >", value, "toallCount");
            return (Criteria) this;
        }

        public Criteria andToallCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("TOALL_COUNT >=", value, "toallCount");
            return (Criteria) this;
        }

        public Criteria andToallCountLessThan(Integer value) {
            addCriterion("TOALL_COUNT <", value, "toallCount");
            return (Criteria) this;
        }

        public Criteria andToallCountLessThanOrEqualTo(Integer value) {
            addCriterion("TOALL_COUNT <=", value, "toallCount");
            return (Criteria) this;
        }

        public Criteria andToallCountIn(List<Integer> values) {
            addCriterion("TOALL_COUNT in", values, "toallCount");
            return (Criteria) this;
        }

        public Criteria andToallCountNotIn(List<Integer> values) {
            addCriterion("TOALL_COUNT not in", values, "toallCount");
            return (Criteria) this;
        }

        public Criteria andToallCountBetween(Integer value1, Integer value2) {
            addCriterion("TOALL_COUNT between", value1, value2, "toallCount");
            return (Criteria) this;
        }

        public Criteria andToallCountNotBetween(Integer value1, Integer value2) {
            addCriterion("TOALL_COUNT not between", value1, value2, "toallCount");
            return (Criteria) this;
        }

        public Criteria andSuffixIsNull() {
            addCriterion("SUFFIX is null");
            return (Criteria) this;
        }

        public Criteria andSuffixIsNotNull() {
            addCriterion("SUFFIX is not null");
            return (Criteria) this;
        }

        public Criteria andSuffixEqualTo(Date value) {
            addCriterion("SUFFIX =", value, "suffix");
            return (Criteria) this;
        }

        public Criteria andSuffixNotEqualTo(Date value) {
            addCriterion("SUFFIX <>", value, "suffix");
            return (Criteria) this;
        }

        public Criteria andSuffixGreaterThan(Date value) {
            addCriterion("SUFFIX >", value, "suffix");
            return (Criteria) this;
        }

        public Criteria andSuffixGreaterThanOrEqualTo(Date value) {
            addCriterion("SUFFIX >=", value, "suffix");
            return (Criteria) this;
        }

        public Criteria andSuffixLessThan(Date value) {
            addCriterion("SUFFIX <", value, "suffix");
            return (Criteria) this;
        }

        public Criteria andSuffixLessThanOrEqualTo(Date value) {
            addCriterion("SUFFIX <=", value, "suffix");
            return (Criteria) this;
        }

        public Criteria andSuffixIn(List<Date> values) {
            addCriterion("SUFFIX in", values, "suffix");
            return (Criteria) this;
        }

        public Criteria andSuffixNotIn(List<Date> values) {
            addCriterion("SUFFIX not in", values, "suffix");
            return (Criteria) this;
        }

        public Criteria andSuffixBetween(Date value1, Date value2) {
            addCriterion("SUFFIX between", value1, value2, "suffix");
            return (Criteria) this;
        }

        public Criteria andSuffixNotBetween(Date value1, Date value2) {
            addCriterion("SUFFIX not between", value1, value2, "suffix");
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