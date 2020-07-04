package com.myfun.repository.admindb.po;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AdminZhiYeViewLogExample {
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
    public AdminZhiYeViewLogExample() {
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

        public Criteria andSubjectIdIsNull() {
            addCriterion("SUBJECT_ID is null");
            return (Criteria) this;
        }

        public Criteria andSubjectIdIsNotNull() {
            addCriterion("SUBJECT_ID is not null");
            return (Criteria) this;
        }

        public Criteria andSubjectIdEqualTo(String value) {
            addCriterion("SUBJECT_ID =", value, "subjectId");
            return (Criteria) this;
        }

        public Criteria andSubjectIdNotEqualTo(String value) {
            addCriterion("SUBJECT_ID <>", value, "subjectId");
            return (Criteria) this;
        }

        public Criteria andSubjectIdGreaterThan(String value) {
            addCriterion("SUBJECT_ID >", value, "subjectId");
            return (Criteria) this;
        }

        public Criteria andSubjectIdGreaterThanOrEqualTo(String value) {
            addCriterion("SUBJECT_ID >=", value, "subjectId");
            return (Criteria) this;
        }

        public Criteria andSubjectIdLessThan(String value) {
            addCriterion("SUBJECT_ID <", value, "subjectId");
            return (Criteria) this;
        }

        public Criteria andSubjectIdLessThanOrEqualTo(String value) {
            addCriterion("SUBJECT_ID <=", value, "subjectId");
            return (Criteria) this;
        }

        public Criteria andSubjectIdLike(String value) {
            addCriterion("SUBJECT_ID like", value, "subjectId");
            return (Criteria) this;
        }

        public Criteria andSubjectIdNotLike(String value) {
            addCriterion("SUBJECT_ID not like", value, "subjectId");
            return (Criteria) this;
        }

        public Criteria andSubjectIdIn(List<String> values) {
            addCriterion("SUBJECT_ID in", values, "subjectId");
            return (Criteria) this;
        }

        public Criteria andSubjectIdNotIn(List<String> values) {
            addCriterion("SUBJECT_ID not in", values, "subjectId");
            return (Criteria) this;
        }

        public Criteria andSubjectIdBetween(String value1, String value2) {
            addCriterion("SUBJECT_ID between", value1, value2, "subjectId");
            return (Criteria) this;
        }

        public Criteria andSubjectIdNotBetween(String value1, String value2) {
            addCriterion("SUBJECT_ID not between", value1, value2, "subjectId");
            return (Criteria) this;
        }

        public Criteria andCoursesTypeIsNull() {
            addCriterion("COURSES_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andCoursesTypeIsNotNull() {
            addCriterion("COURSES_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andCoursesTypeEqualTo(String value) {
            addCriterion("COURSES_TYPE =", value, "coursesType");
            return (Criteria) this;
        }

        public Criteria andCoursesTypeNotEqualTo(String value) {
            addCriterion("COURSES_TYPE <>", value, "coursesType");
            return (Criteria) this;
        }

        public Criteria andCoursesTypeGreaterThan(String value) {
            addCriterion("COURSES_TYPE >", value, "coursesType");
            return (Criteria) this;
        }

        public Criteria andCoursesTypeGreaterThanOrEqualTo(String value) {
            addCriterion("COURSES_TYPE >=", value, "coursesType");
            return (Criteria) this;
        }

        public Criteria andCoursesTypeLessThan(String value) {
            addCriterion("COURSES_TYPE <", value, "coursesType");
            return (Criteria) this;
        }

        public Criteria andCoursesTypeLessThanOrEqualTo(String value) {
            addCriterion("COURSES_TYPE <=", value, "coursesType");
            return (Criteria) this;
        }

        public Criteria andCoursesTypeLike(String value) {
            addCriterion("COURSES_TYPE like", value, "coursesType");
            return (Criteria) this;
        }

        public Criteria andCoursesTypeNotLike(String value) {
            addCriterion("COURSES_TYPE not like", value, "coursesType");
            return (Criteria) this;
        }

        public Criteria andCoursesTypeIn(List<String> values) {
            addCriterion("COURSES_TYPE in", values, "coursesType");
            return (Criteria) this;
        }

        public Criteria andCoursesTypeNotIn(List<String> values) {
            addCriterion("COURSES_TYPE not in", values, "coursesType");
            return (Criteria) this;
        }

        public Criteria andCoursesTypeBetween(String value1, String value2) {
            addCriterion("COURSES_TYPE between", value1, value2, "coursesType");
            return (Criteria) this;
        }

        public Criteria andCoursesTypeNotBetween(String value1, String value2) {
            addCriterion("COURSES_TYPE not between", value1, value2, "coursesType");
            return (Criteria) this;
        }

        public Criteria andMediaIdIsNull() {
            addCriterion("MEDIA_ID is null");
            return (Criteria) this;
        }

        public Criteria andMediaIdIsNotNull() {
            addCriterion("MEDIA_ID is not null");
            return (Criteria) this;
        }

        public Criteria andMediaIdEqualTo(String value) {
            addCriterion("MEDIA_ID =", value, "mediaId");
            return (Criteria) this;
        }

        public Criteria andMediaIdNotEqualTo(String value) {
            addCriterion("MEDIA_ID <>", value, "mediaId");
            return (Criteria) this;
        }

        public Criteria andMediaIdGreaterThan(String value) {
            addCriterion("MEDIA_ID >", value, "mediaId");
            return (Criteria) this;
        }

        public Criteria andMediaIdGreaterThanOrEqualTo(String value) {
            addCriterion("MEDIA_ID >=", value, "mediaId");
            return (Criteria) this;
        }

        public Criteria andMediaIdLessThan(String value) {
            addCriterion("MEDIA_ID <", value, "mediaId");
            return (Criteria) this;
        }

        public Criteria andMediaIdLessThanOrEqualTo(String value) {
            addCriterion("MEDIA_ID <=", value, "mediaId");
            return (Criteria) this;
        }

        public Criteria andMediaIdLike(String value) {
            addCriterion("MEDIA_ID like", value, "mediaId");
            return (Criteria) this;
        }

        public Criteria andMediaIdNotLike(String value) {
            addCriterion("MEDIA_ID not like", value, "mediaId");
            return (Criteria) this;
        }

        public Criteria andMediaIdIn(List<String> values) {
            addCriterion("MEDIA_ID in", values, "mediaId");
            return (Criteria) this;
        }

        public Criteria andMediaIdNotIn(List<String> values) {
            addCriterion("MEDIA_ID not in", values, "mediaId");
            return (Criteria) this;
        }

        public Criteria andMediaIdBetween(String value1, String value2) {
            addCriterion("MEDIA_ID between", value1, value2, "mediaId");
            return (Criteria) this;
        }

        public Criteria andMediaIdNotBetween(String value1, String value2) {
            addCriterion("MEDIA_ID not between", value1, value2, "mediaId");
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

        public Criteria andErrMsgIsNull() {
            addCriterion("ERR_MSG is null");
            return (Criteria) this;
        }

        public Criteria andErrMsgIsNotNull() {
            addCriterion("ERR_MSG is not null");
            return (Criteria) this;
        }

        public Criteria andErrMsgEqualTo(String value) {
            addCriterion("ERR_MSG =", value, "errMsg");
            return (Criteria) this;
        }

        public Criteria andErrMsgNotEqualTo(String value) {
            addCriterion("ERR_MSG <>", value, "errMsg");
            return (Criteria) this;
        }

        public Criteria andErrMsgGreaterThan(String value) {
            addCriterion("ERR_MSG >", value, "errMsg");
            return (Criteria) this;
        }

        public Criteria andErrMsgGreaterThanOrEqualTo(String value) {
            addCriterion("ERR_MSG >=", value, "errMsg");
            return (Criteria) this;
        }

        public Criteria andErrMsgLessThan(String value) {
            addCriterion("ERR_MSG <", value, "errMsg");
            return (Criteria) this;
        }

        public Criteria andErrMsgLessThanOrEqualTo(String value) {
            addCriterion("ERR_MSG <=", value, "errMsg");
            return (Criteria) this;
        }

        public Criteria andErrMsgLike(String value) {
            addCriterion("ERR_MSG like", value, "errMsg");
            return (Criteria) this;
        }

        public Criteria andErrMsgNotLike(String value) {
            addCriterion("ERR_MSG not like", value, "errMsg");
            return (Criteria) this;
        }

        public Criteria andErrMsgIn(List<String> values) {
            addCriterion("ERR_MSG in", values, "errMsg");
            return (Criteria) this;
        }

        public Criteria andErrMsgNotIn(List<String> values) {
            addCriterion("ERR_MSG not in", values, "errMsg");
            return (Criteria) this;
        }

        public Criteria andErrMsgBetween(String value1, String value2) {
            addCriterion("ERR_MSG between", value1, value2, "errMsg");
            return (Criteria) this;
        }

        public Criteria andErrMsgNotBetween(String value1, String value2) {
            addCriterion("ERR_MSG not between", value1, value2, "errMsg");
            return (Criteria) this;
        }

        public Criteria andErrCodeIsNull() {
            addCriterion("ERR_CODE is null");
            return (Criteria) this;
        }

        public Criteria andErrCodeIsNotNull() {
            addCriterion("ERR_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andErrCodeEqualTo(Integer value) {
            addCriterion("ERR_CODE =", value, "errCode");
            return (Criteria) this;
        }

        public Criteria andErrCodeNotEqualTo(Integer value) {
            addCriterion("ERR_CODE <>", value, "errCode");
            return (Criteria) this;
        }

        public Criteria andErrCodeGreaterThan(Integer value) {
            addCriterion("ERR_CODE >", value, "errCode");
            return (Criteria) this;
        }

        public Criteria andErrCodeGreaterThanOrEqualTo(Integer value) {
            addCriterion("ERR_CODE >=", value, "errCode");
            return (Criteria) this;
        }

        public Criteria andErrCodeLessThan(Integer value) {
            addCriterion("ERR_CODE <", value, "errCode");
            return (Criteria) this;
        }

        public Criteria andErrCodeLessThanOrEqualTo(Integer value) {
            addCriterion("ERR_CODE <=", value, "errCode");
            return (Criteria) this;
        }

        public Criteria andErrCodeIn(List<Integer> values) {
            addCriterion("ERR_CODE in", values, "errCode");
            return (Criteria) this;
        }

        public Criteria andErrCodeNotIn(List<Integer> values) {
            addCriterion("ERR_CODE not in", values, "errCode");
            return (Criteria) this;
        }

        public Criteria andErrCodeBetween(Integer value1, Integer value2) {
            addCriterion("ERR_CODE between", value1, value2, "errCode");
            return (Criteria) this;
        }

        public Criteria andErrCodeNotBetween(Integer value1, Integer value2) {
            addCriterion("ERR_CODE not between", value1, value2, "errCode");
            return (Criteria) this;
        }

        public Criteria andViewSourceIsNull() {
            addCriterion("VIEW_SOURCE is null");
            return (Criteria) this;
        }

        public Criteria andViewSourceIsNotNull() {
            addCriterion("VIEW_SOURCE is not null");
            return (Criteria) this;
        }

        public Criteria andViewSourceEqualTo(Byte value) {
            addCriterion("VIEW_SOURCE =", value, "viewSource");
            return (Criteria) this;
        }

        public Criteria andViewSourceNotEqualTo(Byte value) {
            addCriterion("VIEW_SOURCE <>", value, "viewSource");
            return (Criteria) this;
        }

        public Criteria andViewSourceGreaterThan(Byte value) {
            addCriterion("VIEW_SOURCE >", value, "viewSource");
            return (Criteria) this;
        }

        public Criteria andViewSourceGreaterThanOrEqualTo(Byte value) {
            addCriterion("VIEW_SOURCE >=", value, "viewSource");
            return (Criteria) this;
        }

        public Criteria andViewSourceLessThan(Byte value) {
            addCriterion("VIEW_SOURCE <", value, "viewSource");
            return (Criteria) this;
        }

        public Criteria andViewSourceLessThanOrEqualTo(Byte value) {
            addCriterion("VIEW_SOURCE <=", value, "viewSource");
            return (Criteria) this;
        }

        public Criteria andViewSourceIn(List<Byte> values) {
            addCriterion("VIEW_SOURCE in", values, "viewSource");
            return (Criteria) this;
        }

        public Criteria andViewSourceNotIn(List<Byte> values) {
            addCriterion("VIEW_SOURCE not in", values, "viewSource");
            return (Criteria) this;
        }

        public Criteria andViewSourceBetween(Byte value1, Byte value2) {
            addCriterion("VIEW_SOURCE between", value1, value2, "viewSource");
            return (Criteria) this;
        }

        public Criteria andViewSourceNotBetween(Byte value1, Byte value2) {
            addCriterion("VIEW_SOURCE not between", value1, value2, "viewSource");
            return (Criteria) this;
        }

        public Criteria andCoursesIdIsNull() {
            addCriterion("COURSES_ID is null");
            return (Criteria) this;
        }

        public Criteria andCoursesIdIsNotNull() {
            addCriterion("COURSES_ID is not null");
            return (Criteria) this;
        }

        public Criteria andCoursesIdEqualTo(String value) {
            addCriterion("COURSES_ID =", value, "coursesId");
            return (Criteria) this;
        }

        public Criteria andCoursesIdNotEqualTo(String value) {
            addCriterion("COURSES_ID <>", value, "coursesId");
            return (Criteria) this;
        }

        public Criteria andCoursesIdGreaterThan(String value) {
            addCriterion("COURSES_ID >", value, "coursesId");
            return (Criteria) this;
        }

        public Criteria andCoursesIdGreaterThanOrEqualTo(String value) {
            addCriterion("COURSES_ID >=", value, "coursesId");
            return (Criteria) this;
        }

        public Criteria andCoursesIdLessThan(String value) {
            addCriterion("COURSES_ID <", value, "coursesId");
            return (Criteria) this;
        }

        public Criteria andCoursesIdLessThanOrEqualTo(String value) {
            addCriterion("COURSES_ID <=", value, "coursesId");
            return (Criteria) this;
        }

        public Criteria andCoursesIdLike(String value) {
            addCriterion("COURSES_ID like", value, "coursesId");
            return (Criteria) this;
        }

        public Criteria andCoursesIdNotLike(String value) {
            addCriterion("COURSES_ID not like", value, "coursesId");
            return (Criteria) this;
        }

        public Criteria andCoursesIdIn(List<String> values) {
            addCriterion("COURSES_ID in", values, "coursesId");
            return (Criteria) this;
        }

        public Criteria andCoursesIdNotIn(List<String> values) {
            addCriterion("COURSES_ID not in", values, "coursesId");
            return (Criteria) this;
        }

        public Criteria andCoursesIdBetween(String value1, String value2) {
            addCriterion("COURSES_ID between", value1, value2, "coursesId");
            return (Criteria) this;
        }

        public Criteria andCoursesIdNotBetween(String value1, String value2) {
            addCriterion("COURSES_ID not between", value1, value2, "coursesId");
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