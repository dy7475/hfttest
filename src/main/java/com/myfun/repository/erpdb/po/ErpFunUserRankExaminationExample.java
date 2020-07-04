package com.myfun.repository.erpdb.po;

import com.myfun.repository.support.generator.shard.ShardDb;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ErpFunUserRankExaminationExample extends ShardDb {
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
    public ErpFunUserRankExaminationExample() {
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

        public Criteria andRoleIdIsNull() {
            addCriterion("ROLE_ID is null");
            return (Criteria) this;
        }

        public Criteria andRoleIdIsNotNull() {
            addCriterion("ROLE_ID is not null");
            return (Criteria) this;
        }

        public Criteria andRoleIdEqualTo(String value) {
            addCriterion("ROLE_ID =", value, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdNotEqualTo(String value) {
            addCriterion("ROLE_ID <>", value, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdGreaterThan(String value) {
            addCriterion("ROLE_ID >", value, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdGreaterThanOrEqualTo(String value) {
            addCriterion("ROLE_ID >=", value, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdLessThan(String value) {
            addCriterion("ROLE_ID <", value, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdLessThanOrEqualTo(String value) {
            addCriterion("ROLE_ID <=", value, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdLike(String value) {
            addCriterion("ROLE_ID like", value, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdNotLike(String value) {
            addCriterion("ROLE_ID not like", value, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdIn(List<String> values) {
            addCriterion("ROLE_ID in", values, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdNotIn(List<String> values) {
            addCriterion("ROLE_ID not in", values, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdBetween(String value1, String value2) {
            addCriterion("ROLE_ID between", value1, value2, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdNotBetween(String value1, String value2) {
            addCriterion("ROLE_ID not between", value1, value2, "roleId");
            return (Criteria) this;
        }

        public Criteria andCurrentPIdIsNull() {
            addCriterion("CURRENT_P_ID is null");
            return (Criteria) this;
        }

        public Criteria andCurrentPIdIsNotNull() {
            addCriterion("CURRENT_P_ID is not null");
            return (Criteria) this;
        }

        public Criteria andCurrentPIdEqualTo(Integer value) {
            addCriterion("CURRENT_P_ID =", value, "currentPId");
            return (Criteria) this;
        }

        public Criteria andCurrentPIdNotEqualTo(Integer value) {
            addCriterion("CURRENT_P_ID <>", value, "currentPId");
            return (Criteria) this;
        }

        public Criteria andCurrentPIdGreaterThan(Integer value) {
            addCriterion("CURRENT_P_ID >", value, "currentPId");
            return (Criteria) this;
        }

        public Criteria andCurrentPIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("CURRENT_P_ID >=", value, "currentPId");
            return (Criteria) this;
        }

        public Criteria andCurrentPIdLessThan(Integer value) {
            addCriterion("CURRENT_P_ID <", value, "currentPId");
            return (Criteria) this;
        }

        public Criteria andCurrentPIdLessThanOrEqualTo(Integer value) {
            addCriterion("CURRENT_P_ID <=", value, "currentPId");
            return (Criteria) this;
        }

        public Criteria andCurrentPIdIn(List<Integer> values) {
            addCriterion("CURRENT_P_ID in", values, "currentPId");
            return (Criteria) this;
        }

        public Criteria andCurrentPIdNotIn(List<Integer> values) {
            addCriterion("CURRENT_P_ID not in", values, "currentPId");
            return (Criteria) this;
        }

        public Criteria andCurrentPIdBetween(Integer value1, Integer value2) {
            addCriterion("CURRENT_P_ID between", value1, value2, "currentPId");
            return (Criteria) this;
        }

        public Criteria andCurrentPIdNotBetween(Integer value1, Integer value2) {
            addCriterion("CURRENT_P_ID not between", value1, value2, "currentPId");
            return (Criteria) this;
        }

        public Criteria andRegistTimeIsNull() {
            addCriterion("REGIST_TIME is null");
            return (Criteria) this;
        }

        public Criteria andRegistTimeIsNotNull() {
            addCriterion("REGIST_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andRegistTimeEqualTo(Date value) {
            addCriterion("REGIST_TIME =", value, "registTime");
            return (Criteria) this;
        }

        public Criteria andRegistTimeNotEqualTo(Date value) {
            addCriterion("REGIST_TIME <>", value, "registTime");
            return (Criteria) this;
        }

        public Criteria andRegistTimeGreaterThan(Date value) {
            addCriterion("REGIST_TIME >", value, "registTime");
            return (Criteria) this;
        }

        public Criteria andRegistTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("REGIST_TIME >=", value, "registTime");
            return (Criteria) this;
        }

        public Criteria andRegistTimeLessThan(Date value) {
            addCriterion("REGIST_TIME <", value, "registTime");
            return (Criteria) this;
        }

        public Criteria andRegistTimeLessThanOrEqualTo(Date value) {
            addCriterion("REGIST_TIME <=", value, "registTime");
            return (Criteria) this;
        }

        public Criteria andRegistTimeIn(List<Date> values) {
            addCriterion("REGIST_TIME in", values, "registTime");
            return (Criteria) this;
        }

        public Criteria andRegistTimeNotIn(List<Date> values) {
            addCriterion("REGIST_TIME not in", values, "registTime");
            return (Criteria) this;
        }

        public Criteria andRegistTimeBetween(Date value1, Date value2) {
            addCriterion("REGIST_TIME between", value1, value2, "registTime");
            return (Criteria) this;
        }

        public Criteria andRegistTimeNotBetween(Date value1, Date value2) {
            addCriterion("REGIST_TIME not between", value1, value2, "registTime");
            return (Criteria) this;
        }

        public Criteria andPersonAchievementIsNull() {
            addCriterion("PERSON_ACHIEVEMENT is null");
            return (Criteria) this;
        }

        public Criteria andPersonAchievementIsNotNull() {
            addCriterion("PERSON_ACHIEVEMENT is not null");
            return (Criteria) this;
        }

        public Criteria andPersonAchievementEqualTo(BigDecimal value) {
            addCriterion("PERSON_ACHIEVEMENT =", value, "personAchievement");
            return (Criteria) this;
        }

        public Criteria andPersonAchievementNotEqualTo(BigDecimal value) {
            addCriterion("PERSON_ACHIEVEMENT <>", value, "personAchievement");
            return (Criteria) this;
        }

        public Criteria andPersonAchievementGreaterThan(BigDecimal value) {
            addCriterion("PERSON_ACHIEVEMENT >", value, "personAchievement");
            return (Criteria) this;
        }

        public Criteria andPersonAchievementGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("PERSON_ACHIEVEMENT >=", value, "personAchievement");
            return (Criteria) this;
        }

        public Criteria andPersonAchievementLessThan(BigDecimal value) {
            addCriterion("PERSON_ACHIEVEMENT <", value, "personAchievement");
            return (Criteria) this;
        }

        public Criteria andPersonAchievementLessThanOrEqualTo(BigDecimal value) {
            addCriterion("PERSON_ACHIEVEMENT <=", value, "personAchievement");
            return (Criteria) this;
        }

        public Criteria andPersonAchievementIn(List<BigDecimal> values) {
            addCriterion("PERSON_ACHIEVEMENT in", values, "personAchievement");
            return (Criteria) this;
        }

        public Criteria andPersonAchievementNotIn(List<BigDecimal> values) {
            addCriterion("PERSON_ACHIEVEMENT not in", values, "personAchievement");
            return (Criteria) this;
        }

        public Criteria andPersonAchievementBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("PERSON_ACHIEVEMENT between", value1, value2, "personAchievement");
            return (Criteria) this;
        }

        public Criteria andPersonAchievementNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("PERSON_ACHIEVEMENT not between", value1, value2, "personAchievement");
            return (Criteria) this;
        }

        public Criteria andTeamAchievementIsNull() {
            addCriterion("TEAM_ACHIEVEMENT is null");
            return (Criteria) this;
        }

        public Criteria andTeamAchievementIsNotNull() {
            addCriterion("TEAM_ACHIEVEMENT is not null");
            return (Criteria) this;
        }

        public Criteria andTeamAchievementEqualTo(BigDecimal value) {
            addCriterion("TEAM_ACHIEVEMENT =", value, "teamAchievement");
            return (Criteria) this;
        }

        public Criteria andTeamAchievementNotEqualTo(BigDecimal value) {
            addCriterion("TEAM_ACHIEVEMENT <>", value, "teamAchievement");
            return (Criteria) this;
        }

        public Criteria andTeamAchievementGreaterThan(BigDecimal value) {
            addCriterion("TEAM_ACHIEVEMENT >", value, "teamAchievement");
            return (Criteria) this;
        }

        public Criteria andTeamAchievementGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("TEAM_ACHIEVEMENT >=", value, "teamAchievement");
            return (Criteria) this;
        }

        public Criteria andTeamAchievementLessThan(BigDecimal value) {
            addCriterion("TEAM_ACHIEVEMENT <", value, "teamAchievement");
            return (Criteria) this;
        }

        public Criteria andTeamAchievementLessThanOrEqualTo(BigDecimal value) {
            addCriterion("TEAM_ACHIEVEMENT <=", value, "teamAchievement");
            return (Criteria) this;
        }

        public Criteria andTeamAchievementIn(List<BigDecimal> values) {
            addCriterion("TEAM_ACHIEVEMENT in", values, "teamAchievement");
            return (Criteria) this;
        }

        public Criteria andTeamAchievementNotIn(List<BigDecimal> values) {
            addCriterion("TEAM_ACHIEVEMENT not in", values, "teamAchievement");
            return (Criteria) this;
        }

        public Criteria andTeamAchievementBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("TEAM_ACHIEVEMENT between", value1, value2, "teamAchievement");
            return (Criteria) this;
        }

        public Criteria andTeamAchievementNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("TEAM_ACHIEVEMENT not between", value1, value2, "teamAchievement");
            return (Criteria) this;
        }

        public Criteria andAchievementRankIsNull() {
            addCriterion("ACHIEVEMENT_RANK is null");
            return (Criteria) this;
        }

        public Criteria andAchievementRankIsNotNull() {
            addCriterion("ACHIEVEMENT_RANK is not null");
            return (Criteria) this;
        }

        public Criteria andAchievementRankEqualTo(Integer value) {
            addCriterion("ACHIEVEMENT_RANK =", value, "achievementRank");
            return (Criteria) this;
        }

        public Criteria andAchievementRankNotEqualTo(Integer value) {
            addCriterion("ACHIEVEMENT_RANK <>", value, "achievementRank");
            return (Criteria) this;
        }

        public Criteria andAchievementRankGreaterThan(Integer value) {
            addCriterion("ACHIEVEMENT_RANK >", value, "achievementRank");
            return (Criteria) this;
        }

        public Criteria andAchievementRankGreaterThanOrEqualTo(Integer value) {
            addCriterion("ACHIEVEMENT_RANK >=", value, "achievementRank");
            return (Criteria) this;
        }

        public Criteria andAchievementRankLessThan(Integer value) {
            addCriterion("ACHIEVEMENT_RANK <", value, "achievementRank");
            return (Criteria) this;
        }

        public Criteria andAchievementRankLessThanOrEqualTo(Integer value) {
            addCriterion("ACHIEVEMENT_RANK <=", value, "achievementRank");
            return (Criteria) this;
        }

        public Criteria andAchievementRankIn(List<Integer> values) {
            addCriterion("ACHIEVEMENT_RANK in", values, "achievementRank");
            return (Criteria) this;
        }

        public Criteria andAchievementRankNotIn(List<Integer> values) {
            addCriterion("ACHIEVEMENT_RANK not in", values, "achievementRank");
            return (Criteria) this;
        }

        public Criteria andAchievementRankBetween(Integer value1, Integer value2) {
            addCriterion("ACHIEVEMENT_RANK between", value1, value2, "achievementRank");
            return (Criteria) this;
        }

        public Criteria andAchievementRankNotBetween(Integer value1, Integer value2) {
            addCriterion("ACHIEVEMENT_RANK not between", value1, value2, "achievementRank");
            return (Criteria) this;
        }

        public Criteria andDAssessmentTimeIsNull() {
            addCriterion("D_ASSESSMENT_TIME is null");
            return (Criteria) this;
        }

        public Criteria andDAssessmentTimeIsNotNull() {
            addCriterion("D_ASSESSMENT_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andDAssessmentTimeEqualTo(Date value) {
            addCriterion("D_ASSESSMENT_TIME =", value, "dAssessmentTime");
            return (Criteria) this;
        }

        public Criteria andDAssessmentTimeNotEqualTo(Date value) {
            addCriterion("D_ASSESSMENT_TIME <>", value, "dAssessmentTime");
            return (Criteria) this;
        }

        public Criteria andDAssessmentTimeGreaterThan(Date value) {
            addCriterion("D_ASSESSMENT_TIME >", value, "dAssessmentTime");
            return (Criteria) this;
        }

        public Criteria andDAssessmentTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("D_ASSESSMENT_TIME >=", value, "dAssessmentTime");
            return (Criteria) this;
        }

        public Criteria andDAssessmentTimeLessThan(Date value) {
            addCriterion("D_ASSESSMENT_TIME <", value, "dAssessmentTime");
            return (Criteria) this;
        }

        public Criteria andDAssessmentTimeLessThanOrEqualTo(Date value) {
            addCriterion("D_ASSESSMENT_TIME <=", value, "dAssessmentTime");
            return (Criteria) this;
        }

        public Criteria andDAssessmentTimeIn(List<Date> values) {
            addCriterion("D_ASSESSMENT_TIME in", values, "dAssessmentTime");
            return (Criteria) this;
        }

        public Criteria andDAssessmentTimeNotIn(List<Date> values) {
            addCriterion("D_ASSESSMENT_TIME not in", values, "dAssessmentTime");
            return (Criteria) this;
        }

        public Criteria andDAssessmentTimeBetween(Date value1, Date value2) {
            addCriterion("D_ASSESSMENT_TIME between", value1, value2, "dAssessmentTime");
            return (Criteria) this;
        }

        public Criteria andDAssessmentTimeNotBetween(Date value1, Date value2) {
            addCriterion("D_ASSESSMENT_TIME not between", value1, value2, "dAssessmentTime");
            return (Criteria) this;
        }

        public Criteria andPersonAchievementTimeIsNull() {
            addCriterion("PERSON_ACHIEVEMENT_TIME is null");
            return (Criteria) this;
        }

        public Criteria andPersonAchievementTimeIsNotNull() {
            addCriterion("PERSON_ACHIEVEMENT_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andPersonAchievementTimeEqualTo(Date value) {
            addCriterion("PERSON_ACHIEVEMENT_TIME =", value, "personAchievementTime");
            return (Criteria) this;
        }

        public Criteria andPersonAchievementTimeNotEqualTo(Date value) {
            addCriterion("PERSON_ACHIEVEMENT_TIME <>", value, "personAchievementTime");
            return (Criteria) this;
        }

        public Criteria andPersonAchievementTimeGreaterThan(Date value) {
            addCriterion("PERSON_ACHIEVEMENT_TIME >", value, "personAchievementTime");
            return (Criteria) this;
        }

        public Criteria andPersonAchievementTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("PERSON_ACHIEVEMENT_TIME >=", value, "personAchievementTime");
            return (Criteria) this;
        }

        public Criteria andPersonAchievementTimeLessThan(Date value) {
            addCriterion("PERSON_ACHIEVEMENT_TIME <", value, "personAchievementTime");
            return (Criteria) this;
        }

        public Criteria andPersonAchievementTimeLessThanOrEqualTo(Date value) {
            addCriterion("PERSON_ACHIEVEMENT_TIME <=", value, "personAchievementTime");
            return (Criteria) this;
        }

        public Criteria andPersonAchievementTimeIn(List<Date> values) {
            addCriterion("PERSON_ACHIEVEMENT_TIME in", values, "personAchievementTime");
            return (Criteria) this;
        }

        public Criteria andPersonAchievementTimeNotIn(List<Date> values) {
            addCriterion("PERSON_ACHIEVEMENT_TIME not in", values, "personAchievementTime");
            return (Criteria) this;
        }

        public Criteria andPersonAchievementTimeBetween(Date value1, Date value2) {
            addCriterion("PERSON_ACHIEVEMENT_TIME between", value1, value2, "personAchievementTime");
            return (Criteria) this;
        }

        public Criteria andPersonAchievementTimeNotBetween(Date value1, Date value2) {
            addCriterion("PERSON_ACHIEVEMENT_TIME not between", value1, value2, "personAchievementTime");
            return (Criteria) this;
        }

        public Criteria andTeamAchievementTimeIsNull() {
            addCriterion("TEAM_ACHIEVEMENT_TIME is null");
            return (Criteria) this;
        }

        public Criteria andTeamAchievementTimeIsNotNull() {
            addCriterion("TEAM_ACHIEVEMENT_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andTeamAchievementTimeEqualTo(Date value) {
            addCriterion("TEAM_ACHIEVEMENT_TIME =", value, "teamAchievementTime");
            return (Criteria) this;
        }

        public Criteria andTeamAchievementTimeNotEqualTo(Date value) {
            addCriterion("TEAM_ACHIEVEMENT_TIME <>", value, "teamAchievementTime");
            return (Criteria) this;
        }

        public Criteria andTeamAchievementTimeGreaterThan(Date value) {
            addCriterion("TEAM_ACHIEVEMENT_TIME >", value, "teamAchievementTime");
            return (Criteria) this;
        }

        public Criteria andTeamAchievementTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("TEAM_ACHIEVEMENT_TIME >=", value, "teamAchievementTime");
            return (Criteria) this;
        }

        public Criteria andTeamAchievementTimeLessThan(Date value) {
            addCriterion("TEAM_ACHIEVEMENT_TIME <", value, "teamAchievementTime");
            return (Criteria) this;
        }

        public Criteria andTeamAchievementTimeLessThanOrEqualTo(Date value) {
            addCriterion("TEAM_ACHIEVEMENT_TIME <=", value, "teamAchievementTime");
            return (Criteria) this;
        }

        public Criteria andTeamAchievementTimeIn(List<Date> values) {
            addCriterion("TEAM_ACHIEVEMENT_TIME in", values, "teamAchievementTime");
            return (Criteria) this;
        }

        public Criteria andTeamAchievementTimeNotIn(List<Date> values) {
            addCriterion("TEAM_ACHIEVEMENT_TIME not in", values, "teamAchievementTime");
            return (Criteria) this;
        }

        public Criteria andTeamAchievementTimeBetween(Date value1, Date value2) {
            addCriterion("TEAM_ACHIEVEMENT_TIME between", value1, value2, "teamAchievementTime");
            return (Criteria) this;
        }

        public Criteria andTeamAchievementTimeNotBetween(Date value1, Date value2) {
            addCriterion("TEAM_ACHIEVEMENT_TIME not between", value1, value2, "teamAchievementTime");
            return (Criteria) this;
        }

        public Criteria andPersonAchievementNowIsNull() {
            addCriterion("PERSON_ACHIEVEMENT_NOW is null");
            return (Criteria) this;
        }

        public Criteria andPersonAchievementNowIsNotNull() {
            addCriterion("PERSON_ACHIEVEMENT_NOW is not null");
            return (Criteria) this;
        }

        public Criteria andPersonAchievementNowEqualTo(BigDecimal value) {
            addCriterion("PERSON_ACHIEVEMENT_NOW =", value, "personAchievementNow");
            return (Criteria) this;
        }

        public Criteria andPersonAchievementNowNotEqualTo(BigDecimal value) {
            addCriterion("PERSON_ACHIEVEMENT_NOW <>", value, "personAchievementNow");
            return (Criteria) this;
        }

        public Criteria andPersonAchievementNowGreaterThan(BigDecimal value) {
            addCriterion("PERSON_ACHIEVEMENT_NOW >", value, "personAchievementNow");
            return (Criteria) this;
        }

        public Criteria andPersonAchievementNowGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("PERSON_ACHIEVEMENT_NOW >=", value, "personAchievementNow");
            return (Criteria) this;
        }

        public Criteria andPersonAchievementNowLessThan(BigDecimal value) {
            addCriterion("PERSON_ACHIEVEMENT_NOW <", value, "personAchievementNow");
            return (Criteria) this;
        }

        public Criteria andPersonAchievementNowLessThanOrEqualTo(BigDecimal value) {
            addCriterion("PERSON_ACHIEVEMENT_NOW <=", value, "personAchievementNow");
            return (Criteria) this;
        }

        public Criteria andPersonAchievementNowIn(List<BigDecimal> values) {
            addCriterion("PERSON_ACHIEVEMENT_NOW in", values, "personAchievementNow");
            return (Criteria) this;
        }

        public Criteria andPersonAchievementNowNotIn(List<BigDecimal> values) {
            addCriterion("PERSON_ACHIEVEMENT_NOW not in", values, "personAchievementNow");
            return (Criteria) this;
        }

        public Criteria andPersonAchievementNowBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("PERSON_ACHIEVEMENT_NOW between", value1, value2, "personAchievementNow");
            return (Criteria) this;
        }

        public Criteria andPersonAchievementNowNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("PERSON_ACHIEVEMENT_NOW not between", value1, value2, "personAchievementNow");
            return (Criteria) this;
        }

        public Criteria andTeamAchievementNowIsNull() {
            addCriterion("TEAM_ACHIEVEMENT_NOW is null");
            return (Criteria) this;
        }

        public Criteria andTeamAchievementNowIsNotNull() {
            addCriterion("TEAM_ACHIEVEMENT_NOW is not null");
            return (Criteria) this;
        }

        public Criteria andTeamAchievementNowEqualTo(BigDecimal value) {
            addCriterion("TEAM_ACHIEVEMENT_NOW =", value, "teamAchievementNow");
            return (Criteria) this;
        }

        public Criteria andTeamAchievementNowNotEqualTo(BigDecimal value) {
            addCriterion("TEAM_ACHIEVEMENT_NOW <>", value, "teamAchievementNow");
            return (Criteria) this;
        }

        public Criteria andTeamAchievementNowGreaterThan(BigDecimal value) {
            addCriterion("TEAM_ACHIEVEMENT_NOW >", value, "teamAchievementNow");
            return (Criteria) this;
        }

        public Criteria andTeamAchievementNowGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("TEAM_ACHIEVEMENT_NOW >=", value, "teamAchievementNow");
            return (Criteria) this;
        }

        public Criteria andTeamAchievementNowLessThan(BigDecimal value) {
            addCriterion("TEAM_ACHIEVEMENT_NOW <", value, "teamAchievementNow");
            return (Criteria) this;
        }

        public Criteria andTeamAchievementNowLessThanOrEqualTo(BigDecimal value) {
            addCriterion("TEAM_ACHIEVEMENT_NOW <=", value, "teamAchievementNow");
            return (Criteria) this;
        }

        public Criteria andTeamAchievementNowIn(List<BigDecimal> values) {
            addCriterion("TEAM_ACHIEVEMENT_NOW in", values, "teamAchievementNow");
            return (Criteria) this;
        }

        public Criteria andTeamAchievementNowNotIn(List<BigDecimal> values) {
            addCriterion("TEAM_ACHIEVEMENT_NOW not in", values, "teamAchievementNow");
            return (Criteria) this;
        }

        public Criteria andTeamAchievementNowBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("TEAM_ACHIEVEMENT_NOW between", value1, value2, "teamAchievementNow");
            return (Criteria) this;
        }

        public Criteria andTeamAchievementNowNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("TEAM_ACHIEVEMENT_NOW not between", value1, value2, "teamAchievementNow");
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

        public Criteria andUpdateTimeIsNull() {
            addCriterion("UPDATE_TIME is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("UPDATE_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterion("UPDATE_TIME =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterion("UPDATE_TIME <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterion("UPDATE_TIME >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("UPDATE_TIME >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterion("UPDATE_TIME <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("UPDATE_TIME <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterion("UPDATE_TIME in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterion("UPDATE_TIME not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("UPDATE_TIME between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("UPDATE_TIME not between", value1, value2, "updateTime");
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