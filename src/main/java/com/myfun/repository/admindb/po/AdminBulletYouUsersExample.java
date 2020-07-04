package com.myfun.repository.admindb.po;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AdminBulletYouUsersExample {
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
    public AdminBulletYouUsersExample() {
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

        public Criteria andBulletIdIsNull() {
            addCriterion("BULLET_ID is null");
            return (Criteria) this;
        }

        public Criteria andBulletIdIsNotNull() {
            addCriterion("BULLET_ID is not null");
            return (Criteria) this;
        }

        public Criteria andBulletIdEqualTo(Integer value) {
            addCriterion("BULLET_ID =", value, "bulletId");
            return (Criteria) this;
        }

        public Criteria andBulletIdNotEqualTo(Integer value) {
            addCriterion("BULLET_ID <>", value, "bulletId");
            return (Criteria) this;
        }

        public Criteria andBulletIdGreaterThan(Integer value) {
            addCriterion("BULLET_ID >", value, "bulletId");
            return (Criteria) this;
        }

        public Criteria andBulletIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("BULLET_ID >=", value, "bulletId");
            return (Criteria) this;
        }

        public Criteria andBulletIdLessThan(Integer value) {
            addCriterion("BULLET_ID <", value, "bulletId");
            return (Criteria) this;
        }

        public Criteria andBulletIdLessThanOrEqualTo(Integer value) {
            addCriterion("BULLET_ID <=", value, "bulletId");
            return (Criteria) this;
        }

        public Criteria andBulletIdIn(List<Integer> values) {
            addCriterion("BULLET_ID in", values, "bulletId");
            return (Criteria) this;
        }

        public Criteria andBulletIdNotIn(List<Integer> values) {
            addCriterion("BULLET_ID not in", values, "bulletId");
            return (Criteria) this;
        }

        public Criteria andBulletIdBetween(Integer value1, Integer value2) {
            addCriterion("BULLET_ID between", value1, value2, "bulletId");
            return (Criteria) this;
        }

        public Criteria andBulletIdNotBetween(Integer value1, Integer value2) {
            addCriterion("BULLET_ID not between", value1, value2, "bulletId");
            return (Criteria) this;
        }

        public Criteria andErpUserIdIsNull() {
            addCriterion("ERP_USER_ID is null");
            return (Criteria) this;
        }

        public Criteria andErpUserIdIsNotNull() {
            addCriterion("ERP_USER_ID is not null");
            return (Criteria) this;
        }

        public Criteria andErpUserIdEqualTo(Integer value) {
            addCriterion("ERP_USER_ID =", value, "erpUserId");
            return (Criteria) this;
        }

        public Criteria andErpUserIdNotEqualTo(Integer value) {
            addCriterion("ERP_USER_ID <>", value, "erpUserId");
            return (Criteria) this;
        }

        public Criteria andErpUserIdGreaterThan(Integer value) {
            addCriterion("ERP_USER_ID >", value, "erpUserId");
            return (Criteria) this;
        }

        public Criteria andErpUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("ERP_USER_ID >=", value, "erpUserId");
            return (Criteria) this;
        }

        public Criteria andErpUserIdLessThan(Integer value) {
            addCriterion("ERP_USER_ID <", value, "erpUserId");
            return (Criteria) this;
        }

        public Criteria andErpUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("ERP_USER_ID <=", value, "erpUserId");
            return (Criteria) this;
        }

        public Criteria andErpUserIdIn(List<Integer> values) {
            addCriterion("ERP_USER_ID in", values, "erpUserId");
            return (Criteria) this;
        }

        public Criteria andErpUserIdNotIn(List<Integer> values) {
            addCriterion("ERP_USER_ID not in", values, "erpUserId");
            return (Criteria) this;
        }

        public Criteria andErpUserIdBetween(Integer value1, Integer value2) {
            addCriterion("ERP_USER_ID between", value1, value2, "erpUserId");
            return (Criteria) this;
        }

        public Criteria andErpUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("ERP_USER_ID not between", value1, value2, "erpUserId");
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

        public Criteria andIsViewIsNull() {
            addCriterion("IS_VIEW is null");
            return (Criteria) this;
        }

        public Criteria andIsViewIsNotNull() {
            addCriterion("IS_VIEW is not null");
            return (Criteria) this;
        }

        public Criteria andIsViewEqualTo(Byte value) {
            addCriterion("IS_VIEW =", value, "isView");
            return (Criteria) this;
        }

        public Criteria andIsViewNotEqualTo(Byte value) {
            addCriterion("IS_VIEW <>", value, "isView");
            return (Criteria) this;
        }

        public Criteria andIsViewGreaterThan(Byte value) {
            addCriterion("IS_VIEW >", value, "isView");
            return (Criteria) this;
        }

        public Criteria andIsViewGreaterThanOrEqualTo(Byte value) {
            addCriterion("IS_VIEW >=", value, "isView");
            return (Criteria) this;
        }

        public Criteria andIsViewLessThan(Byte value) {
            addCriterion("IS_VIEW <", value, "isView");
            return (Criteria) this;
        }

        public Criteria andIsViewLessThanOrEqualTo(Byte value) {
            addCriterion("IS_VIEW <=", value, "isView");
            return (Criteria) this;
        }

        public Criteria andIsViewIn(List<Byte> values) {
            addCriterion("IS_VIEW in", values, "isView");
            return (Criteria) this;
        }

        public Criteria andIsViewNotIn(List<Byte> values) {
            addCriterion("IS_VIEW not in", values, "isView");
            return (Criteria) this;
        }

        public Criteria andIsViewBetween(Byte value1, Byte value2) {
            addCriterion("IS_VIEW between", value1, value2, "isView");
            return (Criteria) this;
        }

        public Criteria andIsViewNotBetween(Byte value1, Byte value2) {
            addCriterion("IS_VIEW not between", value1, value2, "isView");
            return (Criteria) this;
        }

        public Criteria andViewTimeIsNull() {
            addCriterion("VIEW_TIME is null");
            return (Criteria) this;
        }

        public Criteria andViewTimeIsNotNull() {
            addCriterion("VIEW_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andViewTimeEqualTo(Date value) {
            addCriterion("VIEW_TIME =", value, "viewTime");
            return (Criteria) this;
        }

        public Criteria andViewTimeNotEqualTo(Date value) {
            addCriterion("VIEW_TIME <>", value, "viewTime");
            return (Criteria) this;
        }

        public Criteria andViewTimeGreaterThan(Date value) {
            addCriterion("VIEW_TIME >", value, "viewTime");
            return (Criteria) this;
        }

        public Criteria andViewTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("VIEW_TIME >=", value, "viewTime");
            return (Criteria) this;
        }

        public Criteria andViewTimeLessThan(Date value) {
            addCriterion("VIEW_TIME <", value, "viewTime");
            return (Criteria) this;
        }

        public Criteria andViewTimeLessThanOrEqualTo(Date value) {
            addCriterion("VIEW_TIME <=", value, "viewTime");
            return (Criteria) this;
        }

        public Criteria andViewTimeIn(List<Date> values) {
            addCriterion("VIEW_TIME in", values, "viewTime");
            return (Criteria) this;
        }

        public Criteria andViewTimeNotIn(List<Date> values) {
            addCriterion("VIEW_TIME not in", values, "viewTime");
            return (Criteria) this;
        }

        public Criteria andViewTimeBetween(Date value1, Date value2) {
            addCriterion("VIEW_TIME between", value1, value2, "viewTime");
            return (Criteria) this;
        }

        public Criteria andViewTimeNotBetween(Date value1, Date value2) {
            addCriterion("VIEW_TIME not between", value1, value2, "viewTime");
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

        public Criteria andUserDeptNoIsNull() {
            addCriterion("USER_DEPT_NO is null");
            return (Criteria) this;
        }

        public Criteria andUserDeptNoIsNotNull() {
            addCriterion("USER_DEPT_NO is not null");
            return (Criteria) this;
        }

        public Criteria andUserDeptNoEqualTo(String value) {
            addCriterion("USER_DEPT_NO =", value, "userDeptNo");
            return (Criteria) this;
        }

        public Criteria andUserDeptNoNotEqualTo(String value) {
            addCriterion("USER_DEPT_NO <>", value, "userDeptNo");
            return (Criteria) this;
        }

        public Criteria andUserDeptNoGreaterThan(String value) {
            addCriterion("USER_DEPT_NO >", value, "userDeptNo");
            return (Criteria) this;
        }

        public Criteria andUserDeptNoGreaterThanOrEqualTo(String value) {
            addCriterion("USER_DEPT_NO >=", value, "userDeptNo");
            return (Criteria) this;
        }

        public Criteria andUserDeptNoLessThan(String value) {
            addCriterion("USER_DEPT_NO <", value, "userDeptNo");
            return (Criteria) this;
        }

        public Criteria andUserDeptNoLessThanOrEqualTo(String value) {
            addCriterion("USER_DEPT_NO <=", value, "userDeptNo");
            return (Criteria) this;
        }

        public Criteria andUserDeptNoLike(String value) {
            addCriterion("USER_DEPT_NO like", value, "userDeptNo");
            return (Criteria) this;
        }

        public Criteria andUserDeptNoNotLike(String value) {
            addCriterion("USER_DEPT_NO not like", value, "userDeptNo");
            return (Criteria) this;
        }

        public Criteria andUserDeptNoIn(List<String> values) {
            addCriterion("USER_DEPT_NO in", values, "userDeptNo");
            return (Criteria) this;
        }

        public Criteria andUserDeptNoNotIn(List<String> values) {
            addCriterion("USER_DEPT_NO not in", values, "userDeptNo");
            return (Criteria) this;
        }

        public Criteria andUserDeptNoBetween(String value1, String value2) {
            addCriterion("USER_DEPT_NO between", value1, value2, "userDeptNo");
            return (Criteria) this;
        }

        public Criteria andUserDeptNoNotBetween(String value1, String value2) {
            addCriterion("USER_DEPT_NO not between", value1, value2, "userDeptNo");
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