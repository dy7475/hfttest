package com.myfun.repository.erpdb.po;

import com.myfun.repository.support.generator.shard.ShardDb;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ErpFunPhotoMlExample extends ShardDb {
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
    public ErpFunPhotoMlExample() {
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

        public Criteria andPhotoIdIsNull() {
            addCriterion("PHOTO_ID is null");
            return (Criteria) this;
        }

        public Criteria andPhotoIdIsNotNull() {
            addCriterion("PHOTO_ID is not null");
            return (Criteria) this;
        }

        public Criteria andPhotoIdEqualTo(Integer value) {
            addCriterion("PHOTO_ID =", value, "photoId");
            return (Criteria) this;
        }

        public Criteria andPhotoIdNotEqualTo(Integer value) {
            addCriterion("PHOTO_ID <>", value, "photoId");
            return (Criteria) this;
        }

        public Criteria andPhotoIdGreaterThan(Integer value) {
            addCriterion("PHOTO_ID >", value, "photoId");
            return (Criteria) this;
        }

        public Criteria andPhotoIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("PHOTO_ID >=", value, "photoId");
            return (Criteria) this;
        }

        public Criteria andPhotoIdLessThan(Integer value) {
            addCriterion("PHOTO_ID <", value, "photoId");
            return (Criteria) this;
        }

        public Criteria andPhotoIdLessThanOrEqualTo(Integer value) {
            addCriterion("PHOTO_ID <=", value, "photoId");
            return (Criteria) this;
        }

        public Criteria andPhotoIdIn(List<Integer> values) {
            addCriterion("PHOTO_ID in", values, "photoId");
            return (Criteria) this;
        }

        public Criteria andPhotoIdNotIn(List<Integer> values) {
            addCriterion("PHOTO_ID not in", values, "photoId");
            return (Criteria) this;
        }

        public Criteria andPhotoIdBetween(Integer value1, Integer value2) {
            addCriterion("PHOTO_ID between", value1, value2, "photoId");
            return (Criteria) this;
        }

        public Criteria andPhotoIdNotBetween(Integer value1, Integer value2) {
            addCriterion("PHOTO_ID not between", value1, value2, "photoId");
            return (Criteria) this;
        }

        public Criteria andUploadSourceUserIsNull() {
            addCriterion("UPLOAD_SOURCE_USER is null");
            return (Criteria) this;
        }

        public Criteria andUploadSourceUserIsNotNull() {
            addCriterion("UPLOAD_SOURCE_USER is not null");
            return (Criteria) this;
        }

        public Criteria andUploadSourceUserEqualTo(Integer value) {
            addCriterion("UPLOAD_SOURCE_USER =", value, "uploadSourceUser");
            return (Criteria) this;
        }

        public Criteria andUploadSourceUserNotEqualTo(Integer value) {
            addCriterion("UPLOAD_SOURCE_USER <>", value, "uploadSourceUser");
            return (Criteria) this;
        }

        public Criteria andUploadSourceUserGreaterThan(Integer value) {
            addCriterion("UPLOAD_SOURCE_USER >", value, "uploadSourceUser");
            return (Criteria) this;
        }

        public Criteria andUploadSourceUserGreaterThanOrEqualTo(Integer value) {
            addCriterion("UPLOAD_SOURCE_USER >=", value, "uploadSourceUser");
            return (Criteria) this;
        }

        public Criteria andUploadSourceUserLessThan(Integer value) {
            addCriterion("UPLOAD_SOURCE_USER <", value, "uploadSourceUser");
            return (Criteria) this;
        }

        public Criteria andUploadSourceUserLessThanOrEqualTo(Integer value) {
            addCriterion("UPLOAD_SOURCE_USER <=", value, "uploadSourceUser");
            return (Criteria) this;
        }

        public Criteria andUploadSourceUserIn(List<Integer> values) {
            addCriterion("UPLOAD_SOURCE_USER in", values, "uploadSourceUser");
            return (Criteria) this;
        }

        public Criteria andUploadSourceUserNotIn(List<Integer> values) {
            addCriterion("UPLOAD_SOURCE_USER not in", values, "uploadSourceUser");
            return (Criteria) this;
        }

        public Criteria andUploadSourceUserBetween(Integer value1, Integer value2) {
            addCriterion("UPLOAD_SOURCE_USER between", value1, value2, "uploadSourceUser");
            return (Criteria) this;
        }

        public Criteria andUploadSourceUserNotBetween(Integer value1, Integer value2) {
            addCriterion("UPLOAD_SOURCE_USER not between", value1, value2, "uploadSourceUser");
            return (Criteria) this;
        }

        public Criteria andPhotographerFlagIsNull() {
            addCriterion("PHOTOGRAPHER_FLAG is null");
            return (Criteria) this;
        }

        public Criteria andPhotographerFlagIsNotNull() {
            addCriterion("PHOTOGRAPHER_FLAG is not null");
            return (Criteria) this;
        }

        public Criteria andPhotographerFlagEqualTo(Byte value) {
            addCriterion("PHOTOGRAPHER_FLAG =", value, "photographerFlag");
            return (Criteria) this;
        }

        public Criteria andPhotographerFlagNotEqualTo(Byte value) {
            addCriterion("PHOTOGRAPHER_FLAG <>", value, "photographerFlag");
            return (Criteria) this;
        }

        public Criteria andPhotographerFlagGreaterThan(Byte value) {
            addCriterion("PHOTOGRAPHER_FLAG >", value, "photographerFlag");
            return (Criteria) this;
        }

        public Criteria andPhotographerFlagGreaterThanOrEqualTo(Byte value) {
            addCriterion("PHOTOGRAPHER_FLAG >=", value, "photographerFlag");
            return (Criteria) this;
        }

        public Criteria andPhotographerFlagLessThan(Byte value) {
            addCriterion("PHOTOGRAPHER_FLAG <", value, "photographerFlag");
            return (Criteria) this;
        }

        public Criteria andPhotographerFlagLessThanOrEqualTo(Byte value) {
            addCriterion("PHOTOGRAPHER_FLAG <=", value, "photographerFlag");
            return (Criteria) this;
        }

        public Criteria andPhotographerFlagIn(List<Byte> values) {
            addCriterion("PHOTOGRAPHER_FLAG in", values, "photographerFlag");
            return (Criteria) this;
        }

        public Criteria andPhotographerFlagNotIn(List<Byte> values) {
            addCriterion("PHOTOGRAPHER_FLAG not in", values, "photographerFlag");
            return (Criteria) this;
        }

        public Criteria andPhotographerFlagBetween(Byte value1, Byte value2) {
            addCriterion("PHOTOGRAPHER_FLAG between", value1, value2, "photographerFlag");
            return (Criteria) this;
        }

        public Criteria andPhotographerFlagNotBetween(Byte value1, Byte value2) {
            addCriterion("PHOTOGRAPHER_FLAG not between", value1, value2, "photographerFlag");
            return (Criteria) this;
        }

        public Criteria andIsDelIsNull() {
            addCriterion("IS_DEL is null");
            return (Criteria) this;
        }

        public Criteria andIsDelIsNotNull() {
            addCriterion("IS_DEL is not null");
            return (Criteria) this;
        }

        public Criteria andIsDelEqualTo(Byte value) {
            addCriterion("IS_DEL =", value, "isDel");
            return (Criteria) this;
        }

        public Criteria andIsDelNotEqualTo(Byte value) {
            addCriterion("IS_DEL <>", value, "isDel");
            return (Criteria) this;
        }

        public Criteria andIsDelGreaterThan(Byte value) {
            addCriterion("IS_DEL >", value, "isDel");
            return (Criteria) this;
        }

        public Criteria andIsDelGreaterThanOrEqualTo(Byte value) {
            addCriterion("IS_DEL >=", value, "isDel");
            return (Criteria) this;
        }

        public Criteria andIsDelLessThan(Byte value) {
            addCriterion("IS_DEL <", value, "isDel");
            return (Criteria) this;
        }

        public Criteria andIsDelLessThanOrEqualTo(Byte value) {
            addCriterion("IS_DEL <=", value, "isDel");
            return (Criteria) this;
        }

        public Criteria andIsDelIn(List<Byte> values) {
            addCriterion("IS_DEL in", values, "isDel");
            return (Criteria) this;
        }

        public Criteria andIsDelNotIn(List<Byte> values) {
            addCriterion("IS_DEL not in", values, "isDel");
            return (Criteria) this;
        }

        public Criteria andIsDelBetween(Byte value1, Byte value2) {
            addCriterion("IS_DEL between", value1, value2, "isDel");
            return (Criteria) this;
        }

        public Criteria andIsDelNotBetween(Byte value1, Byte value2) {
            addCriterion("IS_DEL not between", value1, value2, "isDel");
            return (Criteria) this;
        }

        public Criteria andComplaintStatusIsNull() {
            addCriterion("COMPLAINT_STATUS is null");
            return (Criteria) this;
        }

        public Criteria andComplaintStatusIsNotNull() {
            addCriterion("COMPLAINT_STATUS is not null");
            return (Criteria) this;
        }

        public Criteria andComplaintStatusEqualTo(Byte value) {
            addCriterion("COMPLAINT_STATUS =", value, "complaintStatus");
            return (Criteria) this;
        }

        public Criteria andComplaintStatusNotEqualTo(Byte value) {
            addCriterion("COMPLAINT_STATUS <>", value, "complaintStatus");
            return (Criteria) this;
        }

        public Criteria andComplaintStatusGreaterThan(Byte value) {
            addCriterion("COMPLAINT_STATUS >", value, "complaintStatus");
            return (Criteria) this;
        }

        public Criteria andComplaintStatusGreaterThanOrEqualTo(Byte value) {
            addCriterion("COMPLAINT_STATUS >=", value, "complaintStatus");
            return (Criteria) this;
        }

        public Criteria andComplaintStatusLessThan(Byte value) {
            addCriterion("COMPLAINT_STATUS <", value, "complaintStatus");
            return (Criteria) this;
        }

        public Criteria andComplaintStatusLessThanOrEqualTo(Byte value) {
            addCriterion("COMPLAINT_STATUS <=", value, "complaintStatus");
            return (Criteria) this;
        }

        public Criteria andComplaintStatusIn(List<Byte> values) {
            addCriterion("COMPLAINT_STATUS in", values, "complaintStatus");
            return (Criteria) this;
        }

        public Criteria andComplaintStatusNotIn(List<Byte> values) {
            addCriterion("COMPLAINT_STATUS not in", values, "complaintStatus");
            return (Criteria) this;
        }

        public Criteria andComplaintStatusBetween(Byte value1, Byte value2) {
            addCriterion("COMPLAINT_STATUS between", value1, value2, "complaintStatus");
            return (Criteria) this;
        }

        public Criteria andComplaintStatusNotBetween(Byte value1, Byte value2) {
            addCriterion("COMPLAINT_STATUS not between", value1, value2, "complaintStatus");
            return (Criteria) this;
        }

        public Criteria andComplaintViewIsNull() {
            addCriterion("COMPLAINT_VIEW is null");
            return (Criteria) this;
        }

        public Criteria andComplaintViewIsNotNull() {
            addCriterion("COMPLAINT_VIEW is not null");
            return (Criteria) this;
        }

        public Criteria andComplaintViewEqualTo(String value) {
            addCriterion("COMPLAINT_VIEW =", value, "complaintView");
            return (Criteria) this;
        }

        public Criteria andComplaintViewNotEqualTo(String value) {
            addCriterion("COMPLAINT_VIEW <>", value, "complaintView");
            return (Criteria) this;
        }

        public Criteria andComplaintViewGreaterThan(String value) {
            addCriterion("COMPLAINT_VIEW >", value, "complaintView");
            return (Criteria) this;
        }

        public Criteria andComplaintViewGreaterThanOrEqualTo(String value) {
            addCriterion("COMPLAINT_VIEW >=", value, "complaintView");
            return (Criteria) this;
        }

        public Criteria andComplaintViewLessThan(String value) {
            addCriterion("COMPLAINT_VIEW <", value, "complaintView");
            return (Criteria) this;
        }

        public Criteria andComplaintViewLessThanOrEqualTo(String value) {
            addCriterion("COMPLAINT_VIEW <=", value, "complaintView");
            return (Criteria) this;
        }

        public Criteria andComplaintViewLike(String value) {
            addCriterion("COMPLAINT_VIEW like", value, "complaintView");
            return (Criteria) this;
        }

        public Criteria andComplaintViewNotLike(String value) {
            addCriterion("COMPLAINT_VIEW not like", value, "complaintView");
            return (Criteria) this;
        }

        public Criteria andComplaintViewIn(List<String> values) {
            addCriterion("COMPLAINT_VIEW in", values, "complaintView");
            return (Criteria) this;
        }

        public Criteria andComplaintViewNotIn(List<String> values) {
            addCriterion("COMPLAINT_VIEW not in", values, "complaintView");
            return (Criteria) this;
        }

        public Criteria andComplaintViewBetween(String value1, String value2) {
            addCriterion("COMPLAINT_VIEW between", value1, value2, "complaintView");
            return (Criteria) this;
        }

        public Criteria andComplaintViewNotBetween(String value1, String value2) {
            addCriterion("COMPLAINT_VIEW not between", value1, value2, "complaintView");
            return (Criteria) this;
        }

        public Criteria andComplaintReviewUidIsNull() {
            addCriterion("COMPLAINT_REVIEW_UID is null");
            return (Criteria) this;
        }

        public Criteria andComplaintReviewUidIsNotNull() {
            addCriterion("COMPLAINT_REVIEW_UID is not null");
            return (Criteria) this;
        }

        public Criteria andComplaintReviewUidEqualTo(Integer value) {
            addCriterion("COMPLAINT_REVIEW_UID =", value, "complaintReviewUid");
            return (Criteria) this;
        }

        public Criteria andComplaintReviewUidNotEqualTo(Integer value) {
            addCriterion("COMPLAINT_REVIEW_UID <>", value, "complaintReviewUid");
            return (Criteria) this;
        }

        public Criteria andComplaintReviewUidGreaterThan(Integer value) {
            addCriterion("COMPLAINT_REVIEW_UID >", value, "complaintReviewUid");
            return (Criteria) this;
        }

        public Criteria andComplaintReviewUidGreaterThanOrEqualTo(Integer value) {
            addCriterion("COMPLAINT_REVIEW_UID >=", value, "complaintReviewUid");
            return (Criteria) this;
        }

        public Criteria andComplaintReviewUidLessThan(Integer value) {
            addCriterion("COMPLAINT_REVIEW_UID <", value, "complaintReviewUid");
            return (Criteria) this;
        }

        public Criteria andComplaintReviewUidLessThanOrEqualTo(Integer value) {
            addCriterion("COMPLAINT_REVIEW_UID <=", value, "complaintReviewUid");
            return (Criteria) this;
        }

        public Criteria andComplaintReviewUidIn(List<Integer> values) {
            addCriterion("COMPLAINT_REVIEW_UID in", values, "complaintReviewUid");
            return (Criteria) this;
        }

        public Criteria andComplaintReviewUidNotIn(List<Integer> values) {
            addCriterion("COMPLAINT_REVIEW_UID not in", values, "complaintReviewUid");
            return (Criteria) this;
        }

        public Criteria andComplaintReviewUidBetween(Integer value1, Integer value2) {
            addCriterion("COMPLAINT_REVIEW_UID between", value1, value2, "complaintReviewUid");
            return (Criteria) this;
        }

        public Criteria andComplaintReviewUidNotBetween(Integer value1, Integer value2) {
            addCriterion("COMPLAINT_REVIEW_UID not between", value1, value2, "complaintReviewUid");
            return (Criteria) this;
        }

        public Criteria andComplaintReviewTimeIsNull() {
            addCriterion("COMPLAINT_REVIEW_TIME is null");
            return (Criteria) this;
        }

        public Criteria andComplaintReviewTimeIsNotNull() {
            addCriterion("COMPLAINT_REVIEW_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andComplaintReviewTimeEqualTo(Date value) {
            addCriterion("COMPLAINT_REVIEW_TIME =", value, "complaintReviewTime");
            return (Criteria) this;
        }

        public Criteria andComplaintReviewTimeNotEqualTo(Date value) {
            addCriterion("COMPLAINT_REVIEW_TIME <>", value, "complaintReviewTime");
            return (Criteria) this;
        }

        public Criteria andComplaintReviewTimeGreaterThan(Date value) {
            addCriterion("COMPLAINT_REVIEW_TIME >", value, "complaintReviewTime");
            return (Criteria) this;
        }

        public Criteria andComplaintReviewTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("COMPLAINT_REVIEW_TIME >=", value, "complaintReviewTime");
            return (Criteria) this;
        }

        public Criteria andComplaintReviewTimeLessThan(Date value) {
            addCriterion("COMPLAINT_REVIEW_TIME <", value, "complaintReviewTime");
            return (Criteria) this;
        }

        public Criteria andComplaintReviewTimeLessThanOrEqualTo(Date value) {
            addCriterion("COMPLAINT_REVIEW_TIME <=", value, "complaintReviewTime");
            return (Criteria) this;
        }

        public Criteria andComplaintReviewTimeIn(List<Date> values) {
            addCriterion("COMPLAINT_REVIEW_TIME in", values, "complaintReviewTime");
            return (Criteria) this;
        }

        public Criteria andComplaintReviewTimeNotIn(List<Date> values) {
            addCriterion("COMPLAINT_REVIEW_TIME not in", values, "complaintReviewTime");
            return (Criteria) this;
        }

        public Criteria andComplaintReviewTimeBetween(Date value1, Date value2) {
            addCriterion("COMPLAINT_REVIEW_TIME between", value1, value2, "complaintReviewTime");
            return (Criteria) this;
        }

        public Criteria andComplaintReviewTimeNotBetween(Date value1, Date value2) {
            addCriterion("COMPLAINT_REVIEW_TIME not between", value1, value2, "complaintReviewTime");
            return (Criteria) this;
        }

        public Criteria andComplaintReviewViewIsNull() {
            addCriterion("COMPLAINT_REVIEW_VIEW is null");
            return (Criteria) this;
        }

        public Criteria andComplaintReviewViewIsNotNull() {
            addCriterion("COMPLAINT_REVIEW_VIEW is not null");
            return (Criteria) this;
        }

        public Criteria andComplaintReviewViewEqualTo(String value) {
            addCriterion("COMPLAINT_REVIEW_VIEW =", value, "complaintReviewView");
            return (Criteria) this;
        }

        public Criteria andComplaintReviewViewNotEqualTo(String value) {
            addCriterion("COMPLAINT_REVIEW_VIEW <>", value, "complaintReviewView");
            return (Criteria) this;
        }

        public Criteria andComplaintReviewViewGreaterThan(String value) {
            addCriterion("COMPLAINT_REVIEW_VIEW >", value, "complaintReviewView");
            return (Criteria) this;
        }

        public Criteria andComplaintReviewViewGreaterThanOrEqualTo(String value) {
            addCriterion("COMPLAINT_REVIEW_VIEW >=", value, "complaintReviewView");
            return (Criteria) this;
        }

        public Criteria andComplaintReviewViewLessThan(String value) {
            addCriterion("COMPLAINT_REVIEW_VIEW <", value, "complaintReviewView");
            return (Criteria) this;
        }

        public Criteria andComplaintReviewViewLessThanOrEqualTo(String value) {
            addCriterion("COMPLAINT_REVIEW_VIEW <=", value, "complaintReviewView");
            return (Criteria) this;
        }

        public Criteria andComplaintReviewViewLike(String value) {
            addCriterion("COMPLAINT_REVIEW_VIEW like", value, "complaintReviewView");
            return (Criteria) this;
        }

        public Criteria andComplaintReviewViewNotLike(String value) {
            addCriterion("COMPLAINT_REVIEW_VIEW not like", value, "complaintReviewView");
            return (Criteria) this;
        }

        public Criteria andComplaintReviewViewIn(List<String> values) {
            addCriterion("COMPLAINT_REVIEW_VIEW in", values, "complaintReviewView");
            return (Criteria) this;
        }

        public Criteria andComplaintReviewViewNotIn(List<String> values) {
            addCriterion("COMPLAINT_REVIEW_VIEW not in", values, "complaintReviewView");
            return (Criteria) this;
        }

        public Criteria andComplaintReviewViewBetween(String value1, String value2) {
            addCriterion("COMPLAINT_REVIEW_VIEW between", value1, value2, "complaintReviewView");
            return (Criteria) this;
        }

        public Criteria andComplaintReviewViewNotBetween(String value1, String value2) {
            addCriterion("COMPLAINT_REVIEW_VIEW not between", value1, value2, "complaintReviewView");
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