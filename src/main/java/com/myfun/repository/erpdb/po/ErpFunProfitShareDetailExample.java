package com.myfun.repository.erpdb.po;

import com.myfun.repository.support.generator.shard.ShardDb;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ErpFunProfitShareDetailExample extends ShardDb {
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
    public ErpFunProfitShareDetailExample() {
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

        public Criteria andDealIdIsNull() {
            addCriterion("DEAL_ID is null");
            return (Criteria) this;
        }

        public Criteria andDealIdIsNotNull() {
            addCriterion("DEAL_ID is not null");
            return (Criteria) this;
        }

        public Criteria andDealIdEqualTo(Integer value) {
            addCriterion("DEAL_ID =", value, "dealId");
            return (Criteria) this;
        }

        public Criteria andDealIdNotEqualTo(Integer value) {
            addCriterion("DEAL_ID <>", value, "dealId");
            return (Criteria) this;
        }

        public Criteria andDealIdGreaterThan(Integer value) {
            addCriterion("DEAL_ID >", value, "dealId");
            return (Criteria) this;
        }

        public Criteria andDealIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("DEAL_ID >=", value, "dealId");
            return (Criteria) this;
        }

        public Criteria andDealIdLessThan(Integer value) {
            addCriterion("DEAL_ID <", value, "dealId");
            return (Criteria) this;
        }

        public Criteria andDealIdLessThanOrEqualTo(Integer value) {
            addCriterion("DEAL_ID <=", value, "dealId");
            return (Criteria) this;
        }

        public Criteria andDealIdIn(List<Integer> values) {
            addCriterion("DEAL_ID in", values, "dealId");
            return (Criteria) this;
        }

        public Criteria andDealIdNotIn(List<Integer> values) {
            addCriterion("DEAL_ID not in", values, "dealId");
            return (Criteria) this;
        }

        public Criteria andDealIdBetween(Integer value1, Integer value2) {
            addCriterion("DEAL_ID between", value1, value2, "dealId");
            return (Criteria) this;
        }

        public Criteria andDealIdNotBetween(Integer value1, Integer value2) {
            addCriterion("DEAL_ID not between", value1, value2, "dealId");
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

        public Criteria andAreaIdIsNull() {
            addCriterion("AREA_ID is null");
            return (Criteria) this;
        }

        public Criteria andAreaIdIsNotNull() {
            addCriterion("AREA_ID is not null");
            return (Criteria) this;
        }

        public Criteria andAreaIdEqualTo(Integer value) {
            addCriterion("AREA_ID =", value, "areaId");
            return (Criteria) this;
        }

        public Criteria andAreaIdNotEqualTo(Integer value) {
            addCriterion("AREA_ID <>", value, "areaId");
            return (Criteria) this;
        }

        public Criteria andAreaIdGreaterThan(Integer value) {
            addCriterion("AREA_ID >", value, "areaId");
            return (Criteria) this;
        }

        public Criteria andAreaIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("AREA_ID >=", value, "areaId");
            return (Criteria) this;
        }

        public Criteria andAreaIdLessThan(Integer value) {
            addCriterion("AREA_ID <", value, "areaId");
            return (Criteria) this;
        }

        public Criteria andAreaIdLessThanOrEqualTo(Integer value) {
            addCriterion("AREA_ID <=", value, "areaId");
            return (Criteria) this;
        }

        public Criteria andAreaIdIn(List<Integer> values) {
            addCriterion("AREA_ID in", values, "areaId");
            return (Criteria) this;
        }

        public Criteria andAreaIdNotIn(List<Integer> values) {
            addCriterion("AREA_ID not in", values, "areaId");
            return (Criteria) this;
        }

        public Criteria andAreaIdBetween(Integer value1, Integer value2) {
            addCriterion("AREA_ID between", value1, value2, "areaId");
            return (Criteria) this;
        }

        public Criteria andAreaIdNotBetween(Integer value1, Integer value2) {
            addCriterion("AREA_ID not between", value1, value2, "areaId");
            return (Criteria) this;
        }

        public Criteria andRegIdIsNull() {
            addCriterion("REG_ID is null");
            return (Criteria) this;
        }

        public Criteria andRegIdIsNotNull() {
            addCriterion("REG_ID is not null");
            return (Criteria) this;
        }

        public Criteria andRegIdEqualTo(Integer value) {
            addCriterion("REG_ID =", value, "regId");
            return (Criteria) this;
        }

        public Criteria andRegIdNotEqualTo(Integer value) {
            addCriterion("REG_ID <>", value, "regId");
            return (Criteria) this;
        }

        public Criteria andRegIdGreaterThan(Integer value) {
            addCriterion("REG_ID >", value, "regId");
            return (Criteria) this;
        }

        public Criteria andRegIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("REG_ID >=", value, "regId");
            return (Criteria) this;
        }

        public Criteria andRegIdLessThan(Integer value) {
            addCriterion("REG_ID <", value, "regId");
            return (Criteria) this;
        }

        public Criteria andRegIdLessThanOrEqualTo(Integer value) {
            addCriterion("REG_ID <=", value, "regId");
            return (Criteria) this;
        }

        public Criteria andRegIdIn(List<Integer> values) {
            addCriterion("REG_ID in", values, "regId");
            return (Criteria) this;
        }

        public Criteria andRegIdNotIn(List<Integer> values) {
            addCriterion("REG_ID not in", values, "regId");
            return (Criteria) this;
        }

        public Criteria andRegIdBetween(Integer value1, Integer value2) {
            addCriterion("REG_ID between", value1, value2, "regId");
            return (Criteria) this;
        }

        public Criteria andRegIdNotBetween(Integer value1, Integer value2) {
            addCriterion("REG_ID not between", value1, value2, "regId");
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

        public Criteria andGrIdIsNull() {
            addCriterion("GR_ID is null");
            return (Criteria) this;
        }

        public Criteria andGrIdIsNotNull() {
            addCriterion("GR_ID is not null");
            return (Criteria) this;
        }

        public Criteria andGrIdEqualTo(Integer value) {
            addCriterion("GR_ID =", value, "grId");
            return (Criteria) this;
        }

        public Criteria andGrIdNotEqualTo(Integer value) {
            addCriterion("GR_ID <>", value, "grId");
            return (Criteria) this;
        }

        public Criteria andGrIdGreaterThan(Integer value) {
            addCriterion("GR_ID >", value, "grId");
            return (Criteria) this;
        }

        public Criteria andGrIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("GR_ID >=", value, "grId");
            return (Criteria) this;
        }

        public Criteria andGrIdLessThan(Integer value) {
            addCriterion("GR_ID <", value, "grId");
            return (Criteria) this;
        }

        public Criteria andGrIdLessThanOrEqualTo(Integer value) {
            addCriterion("GR_ID <=", value, "grId");
            return (Criteria) this;
        }

        public Criteria andGrIdIn(List<Integer> values) {
            addCriterion("GR_ID in", values, "grId");
            return (Criteria) this;
        }

        public Criteria andGrIdNotIn(List<Integer> values) {
            addCriterion("GR_ID not in", values, "grId");
            return (Criteria) this;
        }

        public Criteria andGrIdBetween(Integer value1, Integer value2) {
            addCriterion("GR_ID between", value1, value2, "grId");
            return (Criteria) this;
        }

        public Criteria andGrIdNotBetween(Integer value1, Integer value2) {
            addCriterion("GR_ID not between", value1, value2, "grId");
            return (Criteria) this;
        }

        public Criteria andSignMonthIsNull() {
            addCriterion("SIGN_MONTH is null");
            return (Criteria) this;
        }

        public Criteria andSignMonthIsNotNull() {
            addCriterion("SIGN_MONTH is not null");
            return (Criteria) this;
        }

        public Criteria andSignMonthEqualTo(String value) {
            addCriterion("SIGN_MONTH =", value, "signMonth");
            return (Criteria) this;
        }

        public Criteria andSignMonthNotEqualTo(String value) {
            addCriterion("SIGN_MONTH <>", value, "signMonth");
            return (Criteria) this;
        }

        public Criteria andSignMonthGreaterThan(String value) {
            addCriterion("SIGN_MONTH >", value, "signMonth");
            return (Criteria) this;
        }

        public Criteria andSignMonthGreaterThanOrEqualTo(String value) {
            addCriterion("SIGN_MONTH >=", value, "signMonth");
            return (Criteria) this;
        }

        public Criteria andSignMonthLessThan(String value) {
            addCriterion("SIGN_MONTH <", value, "signMonth");
            return (Criteria) this;
        }

        public Criteria andSignMonthLessThanOrEqualTo(String value) {
            addCriterion("SIGN_MONTH <=", value, "signMonth");
            return (Criteria) this;
        }

        public Criteria andSignMonthLike(String value) {
            addCriterion("SIGN_MONTH like", value, "signMonth");
            return (Criteria) this;
        }

        public Criteria andSignMonthNotLike(String value) {
            addCriterion("SIGN_MONTH not like", value, "signMonth");
            return (Criteria) this;
        }

        public Criteria andSignMonthIn(List<String> values) {
            addCriterion("SIGN_MONTH in", values, "signMonth");
            return (Criteria) this;
        }

        public Criteria andSignMonthNotIn(List<String> values) {
            addCriterion("SIGN_MONTH not in", values, "signMonth");
            return (Criteria) this;
        }

        public Criteria andSignMonthBetween(String value1, String value2) {
            addCriterion("SIGN_MONTH between", value1, value2, "signMonth");
            return (Criteria) this;
        }

        public Criteria andSignMonthNotBetween(String value1, String value2) {
            addCriterion("SIGN_MONTH not between", value1, value2, "signMonth");
            return (Criteria) this;
        }

        public Criteria andIncomeMonthIsNull() {
            addCriterion("INCOME_MONTH is null");
            return (Criteria) this;
        }

        public Criteria andIncomeMonthIsNotNull() {
            addCriterion("INCOME_MONTH is not null");
            return (Criteria) this;
        }

        public Criteria andIncomeMonthEqualTo(String value) {
            addCriterion("INCOME_MONTH =", value, "incomeMonth");
            return (Criteria) this;
        }

        public Criteria andIncomeMonthNotEqualTo(String value) {
            addCriterion("INCOME_MONTH <>", value, "incomeMonth");
            return (Criteria) this;
        }

        public Criteria andIncomeMonthGreaterThan(String value) {
            addCriterion("INCOME_MONTH >", value, "incomeMonth");
            return (Criteria) this;
        }

        public Criteria andIncomeMonthGreaterThanOrEqualTo(String value) {
            addCriterion("INCOME_MONTH >=", value, "incomeMonth");
            return (Criteria) this;
        }

        public Criteria andIncomeMonthLessThan(String value) {
            addCriterion("INCOME_MONTH <", value, "incomeMonth");
            return (Criteria) this;
        }

        public Criteria andIncomeMonthLessThanOrEqualTo(String value) {
            addCriterion("INCOME_MONTH <=", value, "incomeMonth");
            return (Criteria) this;
        }

        public Criteria andIncomeMonthLike(String value) {
            addCriterion("INCOME_MONTH like", value, "incomeMonth");
            return (Criteria) this;
        }

        public Criteria andIncomeMonthNotLike(String value) {
            addCriterion("INCOME_MONTH not like", value, "incomeMonth");
            return (Criteria) this;
        }

        public Criteria andIncomeMonthIn(List<String> values) {
            addCriterion("INCOME_MONTH in", values, "incomeMonth");
            return (Criteria) this;
        }

        public Criteria andIncomeMonthNotIn(List<String> values) {
            addCriterion("INCOME_MONTH not in", values, "incomeMonth");
            return (Criteria) this;
        }

        public Criteria andIncomeMonthBetween(String value1, String value2) {
            addCriterion("INCOME_MONTH between", value1, value2, "incomeMonth");
            return (Criteria) this;
        }

        public Criteria andIncomeMonthNotBetween(String value1, String value2) {
            addCriterion("INCOME_MONTH not between", value1, value2, "incomeMonth");
            return (Criteria) this;
        }

        public Criteria andSettlementMonthIsNull() {
            addCriterion("SETTLEMENT_MONTH is null");
            return (Criteria) this;
        }

        public Criteria andSettlementMonthIsNotNull() {
            addCriterion("SETTLEMENT_MONTH is not null");
            return (Criteria) this;
        }

        public Criteria andSettlementMonthEqualTo(String value) {
            addCriterion("SETTLEMENT_MONTH =", value, "settlementMonth");
            return (Criteria) this;
        }

        public Criteria andSettlementMonthNotEqualTo(String value) {
            addCriterion("SETTLEMENT_MONTH <>", value, "settlementMonth");
            return (Criteria) this;
        }

        public Criteria andSettlementMonthGreaterThan(String value) {
            addCriterion("SETTLEMENT_MONTH >", value, "settlementMonth");
            return (Criteria) this;
        }

        public Criteria andSettlementMonthGreaterThanOrEqualTo(String value) {
            addCriterion("SETTLEMENT_MONTH >=", value, "settlementMonth");
            return (Criteria) this;
        }

        public Criteria andSettlementMonthLessThan(String value) {
            addCriterion("SETTLEMENT_MONTH <", value, "settlementMonth");
            return (Criteria) this;
        }

        public Criteria andSettlementMonthLessThanOrEqualTo(String value) {
            addCriterion("SETTLEMENT_MONTH <=", value, "settlementMonth");
            return (Criteria) this;
        }

        public Criteria andSettlementMonthLike(String value) {
            addCriterion("SETTLEMENT_MONTH like", value, "settlementMonth");
            return (Criteria) this;
        }

        public Criteria andSettlementMonthNotLike(String value) {
            addCriterion("SETTLEMENT_MONTH not like", value, "settlementMonth");
            return (Criteria) this;
        }

        public Criteria andSettlementMonthIn(List<String> values) {
            addCriterion("SETTLEMENT_MONTH in", values, "settlementMonth");
            return (Criteria) this;
        }

        public Criteria andSettlementMonthNotIn(List<String> values) {
            addCriterion("SETTLEMENT_MONTH not in", values, "settlementMonth");
            return (Criteria) this;
        }

        public Criteria andSettlementMonthBetween(String value1, String value2) {
            addCriterion("SETTLEMENT_MONTH between", value1, value2, "settlementMonth");
            return (Criteria) this;
        }

        public Criteria andSettlementMonthNotBetween(String value1, String value2) {
            addCriterion("SETTLEMENT_MONTH not between", value1, value2, "settlementMonth");
            return (Criteria) this;
        }

        public Criteria andPlannedDistributionIsNull() {
            addCriterion("PLANNED_DISTRIBUTION is null");
            return (Criteria) this;
        }

        public Criteria andPlannedDistributionIsNotNull() {
            addCriterion("PLANNED_DISTRIBUTION is not null");
            return (Criteria) this;
        }

        public Criteria andPlannedDistributionEqualTo(BigDecimal value) {
            addCriterion("PLANNED_DISTRIBUTION =", value, "plannedDistribution");
            return (Criteria) this;
        }

        public Criteria andPlannedDistributionNotEqualTo(BigDecimal value) {
            addCriterion("PLANNED_DISTRIBUTION <>", value, "plannedDistribution");
            return (Criteria) this;
        }

        public Criteria andPlannedDistributionGreaterThan(BigDecimal value) {
            addCriterion("PLANNED_DISTRIBUTION >", value, "plannedDistribution");
            return (Criteria) this;
        }

        public Criteria andPlannedDistributionGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("PLANNED_DISTRIBUTION >=", value, "plannedDistribution");
            return (Criteria) this;
        }

        public Criteria andPlannedDistributionLessThan(BigDecimal value) {
            addCriterion("PLANNED_DISTRIBUTION <", value, "plannedDistribution");
            return (Criteria) this;
        }

        public Criteria andPlannedDistributionLessThanOrEqualTo(BigDecimal value) {
            addCriterion("PLANNED_DISTRIBUTION <=", value, "plannedDistribution");
            return (Criteria) this;
        }

        public Criteria andPlannedDistributionIn(List<BigDecimal> values) {
            addCriterion("PLANNED_DISTRIBUTION in", values, "plannedDistribution");
            return (Criteria) this;
        }

        public Criteria andPlannedDistributionNotIn(List<BigDecimal> values) {
            addCriterion("PLANNED_DISTRIBUTION not in", values, "plannedDistribution");
            return (Criteria) this;
        }

        public Criteria andPlannedDistributionBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("PLANNED_DISTRIBUTION between", value1, value2, "plannedDistribution");
            return (Criteria) this;
        }

        public Criteria andPlannedDistributionNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("PLANNED_DISTRIBUTION not between", value1, value2, "plannedDistribution");
            return (Criteria) this;
        }

        public Criteria andDistributionPercentIsNull() {
            addCriterion("DISTRIBUTION_PERCENT is null");
            return (Criteria) this;
        }

        public Criteria andDistributionPercentIsNotNull() {
            addCriterion("DISTRIBUTION_PERCENT is not null");
            return (Criteria) this;
        }

        public Criteria andDistributionPercentEqualTo(BigDecimal value) {
            addCriterion("DISTRIBUTION_PERCENT =", value, "distributionPercent");
            return (Criteria) this;
        }

        public Criteria andDistributionPercentNotEqualTo(BigDecimal value) {
            addCriterion("DISTRIBUTION_PERCENT <>", value, "distributionPercent");
            return (Criteria) this;
        }

        public Criteria andDistributionPercentGreaterThan(BigDecimal value) {
            addCriterion("DISTRIBUTION_PERCENT >", value, "distributionPercent");
            return (Criteria) this;
        }

        public Criteria andDistributionPercentGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("DISTRIBUTION_PERCENT >=", value, "distributionPercent");
            return (Criteria) this;
        }

        public Criteria andDistributionPercentLessThan(BigDecimal value) {
            addCriterion("DISTRIBUTION_PERCENT <", value, "distributionPercent");
            return (Criteria) this;
        }

        public Criteria andDistributionPercentLessThanOrEqualTo(BigDecimal value) {
            addCriterion("DISTRIBUTION_PERCENT <=", value, "distributionPercent");
            return (Criteria) this;
        }

        public Criteria andDistributionPercentIn(List<BigDecimal> values) {
            addCriterion("DISTRIBUTION_PERCENT in", values, "distributionPercent");
            return (Criteria) this;
        }

        public Criteria andDistributionPercentNotIn(List<BigDecimal> values) {
            addCriterion("DISTRIBUTION_PERCENT not in", values, "distributionPercent");
            return (Criteria) this;
        }

        public Criteria andDistributionPercentBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("DISTRIBUTION_PERCENT between", value1, value2, "distributionPercent");
            return (Criteria) this;
        }

        public Criteria andDistributionPercentNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("DISTRIBUTION_PERCENT not between", value1, value2, "distributionPercent");
            return (Criteria) this;
        }

        public Criteria andIncomeAmountIsNull() {
            addCriterion("INCOME_AMOUNT is null");
            return (Criteria) this;
        }

        public Criteria andIncomeAmountIsNotNull() {
            addCriterion("INCOME_AMOUNT is not null");
            return (Criteria) this;
        }

        public Criteria andIncomeAmountEqualTo(BigDecimal value) {
            addCriterion("INCOME_AMOUNT =", value, "incomeAmount");
            return (Criteria) this;
        }

        public Criteria andIncomeAmountNotEqualTo(BigDecimal value) {
            addCriterion("INCOME_AMOUNT <>", value, "incomeAmount");
            return (Criteria) this;
        }

        public Criteria andIncomeAmountGreaterThan(BigDecimal value) {
            addCriterion("INCOME_AMOUNT >", value, "incomeAmount");
            return (Criteria) this;
        }

        public Criteria andIncomeAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("INCOME_AMOUNT >=", value, "incomeAmount");
            return (Criteria) this;
        }

        public Criteria andIncomeAmountLessThan(BigDecimal value) {
            addCriterion("INCOME_AMOUNT <", value, "incomeAmount");
            return (Criteria) this;
        }

        public Criteria andIncomeAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("INCOME_AMOUNT <=", value, "incomeAmount");
            return (Criteria) this;
        }

        public Criteria andIncomeAmountIn(List<BigDecimal> values) {
            addCriterion("INCOME_AMOUNT in", values, "incomeAmount");
            return (Criteria) this;
        }

        public Criteria andIncomeAmountNotIn(List<BigDecimal> values) {
            addCriterion("INCOME_AMOUNT not in", values, "incomeAmount");
            return (Criteria) this;
        }

        public Criteria andIncomeAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("INCOME_AMOUNT between", value1, value2, "incomeAmount");
            return (Criteria) this;
        }

        public Criteria andIncomeAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("INCOME_AMOUNT not between", value1, value2, "incomeAmount");
            return (Criteria) this;
        }

        public Criteria andPerformanceAmountIsNull() {
            addCriterion("PERFORMANCE_AMOUNT is null");
            return (Criteria) this;
        }

        public Criteria andPerformanceAmountIsNotNull() {
            addCriterion("PERFORMANCE_AMOUNT is not null");
            return (Criteria) this;
        }

        public Criteria andPerformanceAmountEqualTo(BigDecimal value) {
            addCriterion("PERFORMANCE_AMOUNT =", value, "performanceAmount");
            return (Criteria) this;
        }

        public Criteria andPerformanceAmountNotEqualTo(BigDecimal value) {
            addCriterion("PERFORMANCE_AMOUNT <>", value, "performanceAmount");
            return (Criteria) this;
        }

        public Criteria andPerformanceAmountGreaterThan(BigDecimal value) {
            addCriterion("PERFORMANCE_AMOUNT >", value, "performanceAmount");
            return (Criteria) this;
        }

        public Criteria andPerformanceAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("PERFORMANCE_AMOUNT >=", value, "performanceAmount");
            return (Criteria) this;
        }

        public Criteria andPerformanceAmountLessThan(BigDecimal value) {
            addCriterion("PERFORMANCE_AMOUNT <", value, "performanceAmount");
            return (Criteria) this;
        }

        public Criteria andPerformanceAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("PERFORMANCE_AMOUNT <=", value, "performanceAmount");
            return (Criteria) this;
        }

        public Criteria andPerformanceAmountIn(List<BigDecimal> values) {
            addCriterion("PERFORMANCE_AMOUNT in", values, "performanceAmount");
            return (Criteria) this;
        }

        public Criteria andPerformanceAmountNotIn(List<BigDecimal> values) {
            addCriterion("PERFORMANCE_AMOUNT not in", values, "performanceAmount");
            return (Criteria) this;
        }

        public Criteria andPerformanceAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("PERFORMANCE_AMOUNT between", value1, value2, "performanceAmount");
            return (Criteria) this;
        }

        public Criteria andPerformanceAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("PERFORMANCE_AMOUNT not between", value1, value2, "performanceAmount");
            return (Criteria) this;
        }

        public Criteria andDividedAmountIsNull() {
            addCriterion("DIVIDED_AMOUNT is null");
            return (Criteria) this;
        }

        public Criteria andDividedAmountIsNotNull() {
            addCriterion("DIVIDED_AMOUNT is not null");
            return (Criteria) this;
        }

        public Criteria andDividedAmountEqualTo(BigDecimal value) {
            addCriterion("DIVIDED_AMOUNT =", value, "dividedAmount");
            return (Criteria) this;
        }

        public Criteria andDividedAmountNotEqualTo(BigDecimal value) {
            addCriterion("DIVIDED_AMOUNT <>", value, "dividedAmount");
            return (Criteria) this;
        }

        public Criteria andDividedAmountGreaterThan(BigDecimal value) {
            addCriterion("DIVIDED_AMOUNT >", value, "dividedAmount");
            return (Criteria) this;
        }

        public Criteria andDividedAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("DIVIDED_AMOUNT >=", value, "dividedAmount");
            return (Criteria) this;
        }

        public Criteria andDividedAmountLessThan(BigDecimal value) {
            addCriterion("DIVIDED_AMOUNT <", value, "dividedAmount");
            return (Criteria) this;
        }

        public Criteria andDividedAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("DIVIDED_AMOUNT <=", value, "dividedAmount");
            return (Criteria) this;
        }

        public Criteria andDividedAmountIn(List<BigDecimal> values) {
            addCriterion("DIVIDED_AMOUNT in", values, "dividedAmount");
            return (Criteria) this;
        }

        public Criteria andDividedAmountNotIn(List<BigDecimal> values) {
            addCriterion("DIVIDED_AMOUNT not in", values, "dividedAmount");
            return (Criteria) this;
        }

        public Criteria andDividedAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("DIVIDED_AMOUNT between", value1, value2, "dividedAmount");
            return (Criteria) this;
        }

        public Criteria andDividedAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("DIVIDED_AMOUNT not between", value1, value2, "dividedAmount");
            return (Criteria) this;
        }

        public Criteria andGrantFlagIsNull() {
            addCriterion("GRANT_FLAG is null");
            return (Criteria) this;
        }

        public Criteria andGrantFlagIsNotNull() {
            addCriterion("GRANT_FLAG is not null");
            return (Criteria) this;
        }

        public Criteria andGrantFlagEqualTo(Byte value) {
            addCriterion("GRANT_FLAG =", value, "grantFlag");
            return (Criteria) this;
        }

        public Criteria andGrantFlagNotEqualTo(Byte value) {
            addCriterion("GRANT_FLAG <>", value, "grantFlag");
            return (Criteria) this;
        }

        public Criteria andGrantFlagGreaterThan(Byte value) {
            addCriterion("GRANT_FLAG >", value, "grantFlag");
            return (Criteria) this;
        }

        public Criteria andGrantFlagGreaterThanOrEqualTo(Byte value) {
            addCriterion("GRANT_FLAG >=", value, "grantFlag");
            return (Criteria) this;
        }

        public Criteria andGrantFlagLessThan(Byte value) {
            addCriterion("GRANT_FLAG <", value, "grantFlag");
            return (Criteria) this;
        }

        public Criteria andGrantFlagLessThanOrEqualTo(Byte value) {
            addCriterion("GRANT_FLAG <=", value, "grantFlag");
            return (Criteria) this;
        }

        public Criteria andGrantFlagIn(List<Byte> values) {
            addCriterion("GRANT_FLAG in", values, "grantFlag");
            return (Criteria) this;
        }

        public Criteria andGrantFlagNotIn(List<Byte> values) {
            addCriterion("GRANT_FLAG not in", values, "grantFlag");
            return (Criteria) this;
        }

        public Criteria andGrantFlagBetween(Byte value1, Byte value2) {
            addCriterion("GRANT_FLAG between", value1, value2, "grantFlag");
            return (Criteria) this;
        }

        public Criteria andGrantFlagNotBetween(Byte value1, Byte value2) {
            addCriterion("GRANT_FLAG not between", value1, value2, "grantFlag");
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

        public Criteria andPerformanceIdIsNull() {
            addCriterion("PERFORMANCE_ID is null");
            return (Criteria) this;
        }

        public Criteria andPerformanceIdIsNotNull() {
            addCriterion("PERFORMANCE_ID is not null");
            return (Criteria) this;
        }

        public Criteria andPerformanceIdEqualTo(Integer value) {
            addCriterion("PERFORMANCE_ID =", value, "performanceId");
            return (Criteria) this;
        }

        public Criteria andPerformanceIdNotEqualTo(Integer value) {
            addCriterion("PERFORMANCE_ID <>", value, "performanceId");
            return (Criteria) this;
        }

        public Criteria andPerformanceIdGreaterThan(Integer value) {
            addCriterion("PERFORMANCE_ID >", value, "performanceId");
            return (Criteria) this;
        }

        public Criteria andPerformanceIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("PERFORMANCE_ID >=", value, "performanceId");
            return (Criteria) this;
        }

        public Criteria andPerformanceIdLessThan(Integer value) {
            addCriterion("PERFORMANCE_ID <", value, "performanceId");
            return (Criteria) this;
        }

        public Criteria andPerformanceIdLessThanOrEqualTo(Integer value) {
            addCriterion("PERFORMANCE_ID <=", value, "performanceId");
            return (Criteria) this;
        }

        public Criteria andPerformanceIdIn(List<Integer> values) {
            addCriterion("PERFORMANCE_ID in", values, "performanceId");
            return (Criteria) this;
        }

        public Criteria andPerformanceIdNotIn(List<Integer> values) {
            addCriterion("PERFORMANCE_ID not in", values, "performanceId");
            return (Criteria) this;
        }

        public Criteria andPerformanceIdBetween(Integer value1, Integer value2) {
            addCriterion("PERFORMANCE_ID between", value1, value2, "performanceId");
            return (Criteria) this;
        }

        public Criteria andPerformanceIdNotBetween(Integer value1, Integer value2) {
            addCriterion("PERFORMANCE_ID not between", value1, value2, "performanceId");
            return (Criteria) this;
        }

        public Criteria andPerformanceNameIsNull() {
            addCriterion("PERFORMANCE_NAME is null");
            return (Criteria) this;
        }

        public Criteria andPerformanceNameIsNotNull() {
            addCriterion("PERFORMANCE_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andPerformanceNameEqualTo(String value) {
            addCriterion("PERFORMANCE_NAME =", value, "performanceName");
            return (Criteria) this;
        }

        public Criteria andPerformanceNameNotEqualTo(String value) {
            addCriterion("PERFORMANCE_NAME <>", value, "performanceName");
            return (Criteria) this;
        }

        public Criteria andPerformanceNameGreaterThan(String value) {
            addCriterion("PERFORMANCE_NAME >", value, "performanceName");
            return (Criteria) this;
        }

        public Criteria andPerformanceNameGreaterThanOrEqualTo(String value) {
            addCriterion("PERFORMANCE_NAME >=", value, "performanceName");
            return (Criteria) this;
        }

        public Criteria andPerformanceNameLessThan(String value) {
            addCriterion("PERFORMANCE_NAME <", value, "performanceName");
            return (Criteria) this;
        }

        public Criteria andPerformanceNameLessThanOrEqualTo(String value) {
            addCriterion("PERFORMANCE_NAME <=", value, "performanceName");
            return (Criteria) this;
        }

        public Criteria andPerformanceNameLike(String value) {
            addCriterion("PERFORMANCE_NAME like", value, "performanceName");
            return (Criteria) this;
        }

        public Criteria andPerformanceNameNotLike(String value) {
            addCriterion("PERFORMANCE_NAME not like", value, "performanceName");
            return (Criteria) this;
        }

        public Criteria andPerformanceNameIn(List<String> values) {
            addCriterion("PERFORMANCE_NAME in", values, "performanceName");
            return (Criteria) this;
        }

        public Criteria andPerformanceNameNotIn(List<String> values) {
            addCriterion("PERFORMANCE_NAME not in", values, "performanceName");
            return (Criteria) this;
        }

        public Criteria andPerformanceNameBetween(String value1, String value2) {
            addCriterion("PERFORMANCE_NAME between", value1, value2, "performanceName");
            return (Criteria) this;
        }

        public Criteria andPerformanceNameNotBetween(String value1, String value2) {
            addCriterion("PERFORMANCE_NAME not between", value1, value2, "performanceName");
            return (Criteria) this;
        }

        public Criteria andIncomeTimeIsNull() {
            addCriterion("INCOME_TIME is null");
            return (Criteria) this;
        }

        public Criteria andIncomeTimeIsNotNull() {
            addCriterion("INCOME_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andIncomeTimeEqualTo(Date value) {
            addCriterion("INCOME_TIME =", value, "incomeTime");
            return (Criteria) this;
        }

        public Criteria andIncomeTimeNotEqualTo(Date value) {
            addCriterion("INCOME_TIME <>", value, "incomeTime");
            return (Criteria) this;
        }

        public Criteria andIncomeTimeGreaterThan(Date value) {
            addCriterion("INCOME_TIME >", value, "incomeTime");
            return (Criteria) this;
        }

        public Criteria andIncomeTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("INCOME_TIME >=", value, "incomeTime");
            return (Criteria) this;
        }

        public Criteria andIncomeTimeLessThan(Date value) {
            addCriterion("INCOME_TIME <", value, "incomeTime");
            return (Criteria) this;
        }

        public Criteria andIncomeTimeLessThanOrEqualTo(Date value) {
            addCriterion("INCOME_TIME <=", value, "incomeTime");
            return (Criteria) this;
        }

        public Criteria andIncomeTimeIn(List<Date> values) {
            addCriterion("INCOME_TIME in", values, "incomeTime");
            return (Criteria) this;
        }

        public Criteria andIncomeTimeNotIn(List<Date> values) {
            addCriterion("INCOME_TIME not in", values, "incomeTime");
            return (Criteria) this;
        }

        public Criteria andIncomeTimeBetween(Date value1, Date value2) {
            addCriterion("INCOME_TIME between", value1, value2, "incomeTime");
            return (Criteria) this;
        }

        public Criteria andIncomeTimeNotBetween(Date value1, Date value2) {
            addCriterion("INCOME_TIME not between", value1, value2, "incomeTime");
            return (Criteria) this;
        }

        public Criteria andIssuedAmountIsNull() {
            addCriterion("ISSUED_AMOUNT is null");
            return (Criteria) this;
        }

        public Criteria andIssuedAmountIsNotNull() {
            addCriterion("ISSUED_AMOUNT is not null");
            return (Criteria) this;
        }

        public Criteria andIssuedAmountEqualTo(BigDecimal value) {
            addCriterion("ISSUED_AMOUNT =", value, "issuedAmount");
            return (Criteria) this;
        }

        public Criteria andIssuedAmountNotEqualTo(BigDecimal value) {
            addCriterion("ISSUED_AMOUNT <>", value, "issuedAmount");
            return (Criteria) this;
        }

        public Criteria andIssuedAmountGreaterThan(BigDecimal value) {
            addCriterion("ISSUED_AMOUNT >", value, "issuedAmount");
            return (Criteria) this;
        }

        public Criteria andIssuedAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("ISSUED_AMOUNT >=", value, "issuedAmount");
            return (Criteria) this;
        }

        public Criteria andIssuedAmountLessThan(BigDecimal value) {
            addCriterion("ISSUED_AMOUNT <", value, "issuedAmount");
            return (Criteria) this;
        }

        public Criteria andIssuedAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("ISSUED_AMOUNT <=", value, "issuedAmount");
            return (Criteria) this;
        }

        public Criteria andIssuedAmountIn(List<BigDecimal> values) {
            addCriterion("ISSUED_AMOUNT in", values, "issuedAmount");
            return (Criteria) this;
        }

        public Criteria andIssuedAmountNotIn(List<BigDecimal> values) {
            addCriterion("ISSUED_AMOUNT not in", values, "issuedAmount");
            return (Criteria) this;
        }

        public Criteria andIssuedAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ISSUED_AMOUNT between", value1, value2, "issuedAmount");
            return (Criteria) this;
        }

        public Criteria andIssuedAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ISSUED_AMOUNT not between", value1, value2, "issuedAmount");
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

        public Criteria andPfIdIsNull() {
            addCriterion("PF_ID is null");
            return (Criteria) this;
        }

        public Criteria andPfIdIsNotNull() {
            addCriterion("PF_ID is not null");
            return (Criteria) this;
        }

        public Criteria andPfIdEqualTo(Integer value) {
            addCriterion("PF_ID =", value, "pfId");
            return (Criteria) this;
        }

        public Criteria andPfIdNotEqualTo(Integer value) {
            addCriterion("PF_ID <>", value, "pfId");
            return (Criteria) this;
        }

        public Criteria andPfIdGreaterThan(Integer value) {
            addCriterion("PF_ID >", value, "pfId");
            return (Criteria) this;
        }

        public Criteria andPfIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("PF_ID >=", value, "pfId");
            return (Criteria) this;
        }

        public Criteria andPfIdLessThan(Integer value) {
            addCriterion("PF_ID <", value, "pfId");
            return (Criteria) this;
        }

        public Criteria andPfIdLessThanOrEqualTo(Integer value) {
            addCriterion("PF_ID <=", value, "pfId");
            return (Criteria) this;
        }

        public Criteria andPfIdIn(List<Integer> values) {
            addCriterion("PF_ID in", values, "pfId");
            return (Criteria) this;
        }

        public Criteria andPfIdNotIn(List<Integer> values) {
            addCriterion("PF_ID not in", values, "pfId");
            return (Criteria) this;
        }

        public Criteria andPfIdBetween(Integer value1, Integer value2) {
            addCriterion("PF_ID between", value1, value2, "pfId");
            return (Criteria) this;
        }

        public Criteria andPfIdNotBetween(Integer value1, Integer value2) {
            addCriterion("PF_ID not between", value1, value2, "pfId");
            return (Criteria) this;
        }

        public Criteria andNeedIncomeAmountIsNull() {
            addCriterion("NEED_INCOME_AMOUNT is null");
            return (Criteria) this;
        }

        public Criteria andNeedIncomeAmountIsNotNull() {
            addCriterion("NEED_INCOME_AMOUNT is not null");
            return (Criteria) this;
        }

        public Criteria andNeedIncomeAmountEqualTo(BigDecimal value) {
            addCriterion("NEED_INCOME_AMOUNT =", value, "needIncomeAmount");
            return (Criteria) this;
        }

        public Criteria andNeedIncomeAmountNotEqualTo(BigDecimal value) {
            addCriterion("NEED_INCOME_AMOUNT <>", value, "needIncomeAmount");
            return (Criteria) this;
        }

        public Criteria andNeedIncomeAmountGreaterThan(BigDecimal value) {
            addCriterion("NEED_INCOME_AMOUNT >", value, "needIncomeAmount");
            return (Criteria) this;
        }

        public Criteria andNeedIncomeAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("NEED_INCOME_AMOUNT >=", value, "needIncomeAmount");
            return (Criteria) this;
        }

        public Criteria andNeedIncomeAmountLessThan(BigDecimal value) {
            addCriterion("NEED_INCOME_AMOUNT <", value, "needIncomeAmount");
            return (Criteria) this;
        }

        public Criteria andNeedIncomeAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("NEED_INCOME_AMOUNT <=", value, "needIncomeAmount");
            return (Criteria) this;
        }

        public Criteria andNeedIncomeAmountIn(List<BigDecimal> values) {
            addCriterion("NEED_INCOME_AMOUNT in", values, "needIncomeAmount");
            return (Criteria) this;
        }

        public Criteria andNeedIncomeAmountNotIn(List<BigDecimal> values) {
            addCriterion("NEED_INCOME_AMOUNT not in", values, "needIncomeAmount");
            return (Criteria) this;
        }

        public Criteria andNeedIncomeAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("NEED_INCOME_AMOUNT between", value1, value2, "needIncomeAmount");
            return (Criteria) this;
        }

        public Criteria andNeedIncomeAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("NEED_INCOME_AMOUNT not between", value1, value2, "needIncomeAmount");
            return (Criteria) this;
        }

        public Criteria andDelFlagIsNull() {
            addCriterion("DEL_FLAG is null");
            return (Criteria) this;
        }

        public Criteria andDelFlagIsNotNull() {
            addCriterion("DEL_FLAG is not null");
            return (Criteria) this;
        }

        public Criteria andDelFlagEqualTo(Byte value) {
            addCriterion("DEL_FLAG =", value, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagNotEqualTo(Byte value) {
            addCriterion("DEL_FLAG <>", value, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagGreaterThan(Byte value) {
            addCriterion("DEL_FLAG >", value, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagGreaterThanOrEqualTo(Byte value) {
            addCriterion("DEL_FLAG >=", value, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagLessThan(Byte value) {
            addCriterion("DEL_FLAG <", value, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagLessThanOrEqualTo(Byte value) {
            addCriterion("DEL_FLAG <=", value, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagIn(List<Byte> values) {
            addCriterion("DEL_FLAG in", values, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagNotIn(List<Byte> values) {
            addCriterion("DEL_FLAG not in", values, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagBetween(Byte value1, Byte value2) {
            addCriterion("DEL_FLAG between", value1, value2, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagNotBetween(Byte value1, Byte value2) {
            addCriterion("DEL_FLAG not between", value1, value2, "delFlag");
            return (Criteria) this;
        }

        public Criteria andIsAbnormalIsNull() {
            addCriterion("IS_ABNORMAL is null");
            return (Criteria) this;
        }

        public Criteria andIsAbnormalIsNotNull() {
            addCriterion("IS_ABNORMAL is not null");
            return (Criteria) this;
        }

        public Criteria andIsAbnormalEqualTo(Byte value) {
            addCriterion("IS_ABNORMAL =", value, "isAbnormal");
            return (Criteria) this;
        }

        public Criteria andIsAbnormalNotEqualTo(Byte value) {
            addCriterion("IS_ABNORMAL <>", value, "isAbnormal");
            return (Criteria) this;
        }

        public Criteria andIsAbnormalGreaterThan(Byte value) {
            addCriterion("IS_ABNORMAL >", value, "isAbnormal");
            return (Criteria) this;
        }

        public Criteria andIsAbnormalGreaterThanOrEqualTo(Byte value) {
            addCriterion("IS_ABNORMAL >=", value, "isAbnormal");
            return (Criteria) this;
        }

        public Criteria andIsAbnormalLessThan(Byte value) {
            addCriterion("IS_ABNORMAL <", value, "isAbnormal");
            return (Criteria) this;
        }

        public Criteria andIsAbnormalLessThanOrEqualTo(Byte value) {
            addCriterion("IS_ABNORMAL <=", value, "isAbnormal");
            return (Criteria) this;
        }

        public Criteria andIsAbnormalIn(List<Byte> values) {
            addCriterion("IS_ABNORMAL in", values, "isAbnormal");
            return (Criteria) this;
        }

        public Criteria andIsAbnormalNotIn(List<Byte> values) {
            addCriterion("IS_ABNORMAL not in", values, "isAbnormal");
            return (Criteria) this;
        }

        public Criteria andIsAbnormalBetween(Byte value1, Byte value2) {
            addCriterion("IS_ABNORMAL between", value1, value2, "isAbnormal");
            return (Criteria) this;
        }

        public Criteria andIsAbnormalNotBetween(Byte value1, Byte value2) {
            addCriterion("IS_ABNORMAL not between", value1, value2, "isAbnormal");
            return (Criteria) this;
        }

        public Criteria andAbnormalMonthIsNull() {
            addCriterion("ABNORMAL_MONTH is null");
            return (Criteria) this;
        }

        public Criteria andAbnormalMonthIsNotNull() {
            addCriterion("ABNORMAL_MONTH is not null");
            return (Criteria) this;
        }

        public Criteria andAbnormalMonthEqualTo(String value) {
            addCriterion("ABNORMAL_MONTH =", value, "abnormalMonth");
            return (Criteria) this;
        }

        public Criteria andAbnormalMonthNotEqualTo(String value) {
            addCriterion("ABNORMAL_MONTH <>", value, "abnormalMonth");
            return (Criteria) this;
        }

        public Criteria andAbnormalMonthGreaterThan(String value) {
            addCriterion("ABNORMAL_MONTH >", value, "abnormalMonth");
            return (Criteria) this;
        }

        public Criteria andAbnormalMonthGreaterThanOrEqualTo(String value) {
            addCriterion("ABNORMAL_MONTH >=", value, "abnormalMonth");
            return (Criteria) this;
        }

        public Criteria andAbnormalMonthLessThan(String value) {
            addCriterion("ABNORMAL_MONTH <", value, "abnormalMonth");
            return (Criteria) this;
        }

        public Criteria andAbnormalMonthLessThanOrEqualTo(String value) {
            addCriterion("ABNORMAL_MONTH <=", value, "abnormalMonth");
            return (Criteria) this;
        }

        public Criteria andAbnormalMonthLike(String value) {
            addCriterion("ABNORMAL_MONTH like", value, "abnormalMonth");
            return (Criteria) this;
        }

        public Criteria andAbnormalMonthNotLike(String value) {
            addCriterion("ABNORMAL_MONTH not like", value, "abnormalMonth");
            return (Criteria) this;
        }

        public Criteria andAbnormalMonthIn(List<String> values) {
            addCriterion("ABNORMAL_MONTH in", values, "abnormalMonth");
            return (Criteria) this;
        }

        public Criteria andAbnormalMonthNotIn(List<String> values) {
            addCriterion("ABNORMAL_MONTH not in", values, "abnormalMonth");
            return (Criteria) this;
        }

        public Criteria andAbnormalMonthBetween(String value1, String value2) {
            addCriterion("ABNORMAL_MONTH between", value1, value2, "abnormalMonth");
            return (Criteria) this;
        }

        public Criteria andAbnormalMonthNotBetween(String value1, String value2) {
            addCriterion("ABNORMAL_MONTH not between", value1, value2, "abnormalMonth");
            return (Criteria) this;
        }

        public Criteria andIsCalculateIsNull() {
            addCriterion("IS_CALCULATE is null");
            return (Criteria) this;
        }

        public Criteria andIsCalculateIsNotNull() {
            addCriterion("IS_CALCULATE is not null");
            return (Criteria) this;
        }

        public Criteria andIsCalculateEqualTo(Byte value) {
            addCriterion("IS_CALCULATE =", value, "isCalculate");
            return (Criteria) this;
        }

        public Criteria andIsCalculateNotEqualTo(Byte value) {
            addCriterion("IS_CALCULATE <>", value, "isCalculate");
            return (Criteria) this;
        }

        public Criteria andIsCalculateGreaterThan(Byte value) {
            addCriterion("IS_CALCULATE >", value, "isCalculate");
            return (Criteria) this;
        }

        public Criteria andIsCalculateGreaterThanOrEqualTo(Byte value) {
            addCriterion("IS_CALCULATE >=", value, "isCalculate");
            return (Criteria) this;
        }

        public Criteria andIsCalculateLessThan(Byte value) {
            addCriterion("IS_CALCULATE <", value, "isCalculate");
            return (Criteria) this;
        }

        public Criteria andIsCalculateLessThanOrEqualTo(Byte value) {
            addCriterion("IS_CALCULATE <=", value, "isCalculate");
            return (Criteria) this;
        }

        public Criteria andIsCalculateIn(List<Byte> values) {
            addCriterion("IS_CALCULATE in", values, "isCalculate");
            return (Criteria) this;
        }

        public Criteria andIsCalculateNotIn(List<Byte> values) {
            addCriterion("IS_CALCULATE not in", values, "isCalculate");
            return (Criteria) this;
        }

        public Criteria andIsCalculateBetween(Byte value1, Byte value2) {
            addCriterion("IS_CALCULATE between", value1, value2, "isCalculate");
            return (Criteria) this;
        }

        public Criteria andIsCalculateNotBetween(Byte value1, Byte value2) {
            addCriterion("IS_CALCULATE not between", value1, value2, "isCalculate");
            return (Criteria) this;
        }

        public Criteria andDelDataIsNull() {
            addCriterion("DEL_DATA is null");
            return (Criteria) this;
        }

        public Criteria andDelDataIsNotNull() {
            addCriterion("DEL_DATA is not null");
            return (Criteria) this;
        }

        public Criteria andDelDataEqualTo(Date value) {
            addCriterion("DEL_DATA =", value, "delData");
            return (Criteria) this;
        }

        public Criteria andDelDataNotEqualTo(Date value) {
            addCriterion("DEL_DATA <>", value, "delData");
            return (Criteria) this;
        }

        public Criteria andDelDataGreaterThan(Date value) {
            addCriterion("DEL_DATA >", value, "delData");
            return (Criteria) this;
        }

        public Criteria andDelDataGreaterThanOrEqualTo(Date value) {
            addCriterion("DEL_DATA >=", value, "delData");
            return (Criteria) this;
        }

        public Criteria andDelDataLessThan(Date value) {
            addCriterion("DEL_DATA <", value, "delData");
            return (Criteria) this;
        }

        public Criteria andDelDataLessThanOrEqualTo(Date value) {
            addCriterion("DEL_DATA <=", value, "delData");
            return (Criteria) this;
        }

        public Criteria andDelDataIn(List<Date> values) {
            addCriterion("DEL_DATA in", values, "delData");
            return (Criteria) this;
        }

        public Criteria andDelDataNotIn(List<Date> values) {
            addCriterion("DEL_DATA not in", values, "delData");
            return (Criteria) this;
        }

        public Criteria andDelDataBetween(Date value1, Date value2) {
            addCriterion("DEL_DATA between", value1, value2, "delData");
            return (Criteria) this;
        }

        public Criteria andDelDataNotBetween(Date value1, Date value2) {
            addCriterion("DEL_DATA not between", value1, value2, "delData");
            return (Criteria) this;
        }

        public Criteria andAssessmentMonthIsNull() {
            addCriterion("ASSESSMENT_MONTH is null");
            return (Criteria) this;
        }

        public Criteria andAssessmentMonthIsNotNull() {
            addCriterion("ASSESSMENT_MONTH is not null");
            return (Criteria) this;
        }

        public Criteria andAssessmentMonthEqualTo(String value) {
            addCriterion("ASSESSMENT_MONTH =", value, "assessmentMonth");
            return (Criteria) this;
        }

        public Criteria andAssessmentMonthNotEqualTo(String value) {
            addCriterion("ASSESSMENT_MONTH <>", value, "assessmentMonth");
            return (Criteria) this;
        }

        public Criteria andAssessmentMonthGreaterThan(String value) {
            addCriterion("ASSESSMENT_MONTH >", value, "assessmentMonth");
            return (Criteria) this;
        }

        public Criteria andAssessmentMonthGreaterThanOrEqualTo(String value) {
            addCriterion("ASSESSMENT_MONTH >=", value, "assessmentMonth");
            return (Criteria) this;
        }

        public Criteria andAssessmentMonthLessThan(String value) {
            addCriterion("ASSESSMENT_MONTH <", value, "assessmentMonth");
            return (Criteria) this;
        }

        public Criteria andAssessmentMonthLessThanOrEqualTo(String value) {
            addCriterion("ASSESSMENT_MONTH <=", value, "assessmentMonth");
            return (Criteria) this;
        }

        public Criteria andAssessmentMonthLike(String value) {
            addCriterion("ASSESSMENT_MONTH like", value, "assessmentMonth");
            return (Criteria) this;
        }

        public Criteria andAssessmentMonthNotLike(String value) {
            addCriterion("ASSESSMENT_MONTH not like", value, "assessmentMonth");
            return (Criteria) this;
        }

        public Criteria andAssessmentMonthIn(List<String> values) {
            addCriterion("ASSESSMENT_MONTH in", values, "assessmentMonth");
            return (Criteria) this;
        }

        public Criteria andAssessmentMonthNotIn(List<String> values) {
            addCriterion("ASSESSMENT_MONTH not in", values, "assessmentMonth");
            return (Criteria) this;
        }

        public Criteria andAssessmentMonthBetween(String value1, String value2) {
            addCriterion("ASSESSMENT_MONTH between", value1, value2, "assessmentMonth");
            return (Criteria) this;
        }

        public Criteria andAssessmentMonthNotBetween(String value1, String value2) {
            addCriterion("ASSESSMENT_MONTH not between", value1, value2, "assessmentMonth");
            return (Criteria) this;
        }

        public Criteria andDividedAmountTotalIsNull() {
            addCriterion("DIVIDED_AMOUNT_TOTAL is null");
            return (Criteria) this;
        }

        public Criteria andDividedAmountTotalIsNotNull() {
            addCriterion("DIVIDED_AMOUNT_TOTAL is not null");
            return (Criteria) this;
        }

        public Criteria andDividedAmountTotalEqualTo(BigDecimal value) {
            addCriterion("DIVIDED_AMOUNT_TOTAL =", value, "dividedAmountTotal");
            return (Criteria) this;
        }

        public Criteria andDividedAmountTotalNotEqualTo(BigDecimal value) {
            addCriterion("DIVIDED_AMOUNT_TOTAL <>", value, "dividedAmountTotal");
            return (Criteria) this;
        }

        public Criteria andDividedAmountTotalGreaterThan(BigDecimal value) {
            addCriterion("DIVIDED_AMOUNT_TOTAL >", value, "dividedAmountTotal");
            return (Criteria) this;
        }

        public Criteria andDividedAmountTotalGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("DIVIDED_AMOUNT_TOTAL >=", value, "dividedAmountTotal");
            return (Criteria) this;
        }

        public Criteria andDividedAmountTotalLessThan(BigDecimal value) {
            addCriterion("DIVIDED_AMOUNT_TOTAL <", value, "dividedAmountTotal");
            return (Criteria) this;
        }

        public Criteria andDividedAmountTotalLessThanOrEqualTo(BigDecimal value) {
            addCriterion("DIVIDED_AMOUNT_TOTAL <=", value, "dividedAmountTotal");
            return (Criteria) this;
        }

        public Criteria andDividedAmountTotalIn(List<BigDecimal> values) {
            addCriterion("DIVIDED_AMOUNT_TOTAL in", values, "dividedAmountTotal");
            return (Criteria) this;
        }

        public Criteria andDividedAmountTotalNotIn(List<BigDecimal> values) {
            addCriterion("DIVIDED_AMOUNT_TOTAL not in", values, "dividedAmountTotal");
            return (Criteria) this;
        }

        public Criteria andDividedAmountTotalBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("DIVIDED_AMOUNT_TOTAL between", value1, value2, "dividedAmountTotal");
            return (Criteria) this;
        }

        public Criteria andDividedAmountTotalNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("DIVIDED_AMOUNT_TOTAL not between", value1, value2, "dividedAmountTotal");
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

        public Criteria andProfitIdIsNull() {
            addCriterion("PROFIT_ID is null");
            return (Criteria) this;
        }

        public Criteria andProfitIdIsNotNull() {
            addCriterion("PROFIT_ID is not null");
            return (Criteria) this;
        }

        public Criteria andProfitIdEqualTo(Integer value) {
            addCriterion("PROFIT_ID =", value, "profitId");
            return (Criteria) this;
        }

        public Criteria andProfitIdNotEqualTo(Integer value) {
            addCriterion("PROFIT_ID <>", value, "profitId");
            return (Criteria) this;
        }

        public Criteria andProfitIdGreaterThan(Integer value) {
            addCriterion("PROFIT_ID >", value, "profitId");
            return (Criteria) this;
        }

        public Criteria andProfitIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("PROFIT_ID >=", value, "profitId");
            return (Criteria) this;
        }

        public Criteria andProfitIdLessThan(Integer value) {
            addCriterion("PROFIT_ID <", value, "profitId");
            return (Criteria) this;
        }

        public Criteria andProfitIdLessThanOrEqualTo(Integer value) {
            addCriterion("PROFIT_ID <=", value, "profitId");
            return (Criteria) this;
        }

        public Criteria andProfitIdIn(List<Integer> values) {
            addCriterion("PROFIT_ID in", values, "profitId");
            return (Criteria) this;
        }

        public Criteria andProfitIdNotIn(List<Integer> values) {
            addCriterion("PROFIT_ID not in", values, "profitId");
            return (Criteria) this;
        }

        public Criteria andProfitIdBetween(Integer value1, Integer value2) {
            addCriterion("PROFIT_ID between", value1, value2, "profitId");
            return (Criteria) this;
        }

        public Criteria andProfitIdNotBetween(Integer value1, Integer value2) {
            addCriterion("PROFIT_ID not between", value1, value2, "profitId");
            return (Criteria) this;
        }

        public Criteria andProfitShareProfitIsNull() {
            addCriterion("PROFIT_SHARE_PROFIT is null");
            return (Criteria) this;
        }

        public Criteria andProfitShareProfitIsNotNull() {
            addCriterion("PROFIT_SHARE_PROFIT is not null");
            return (Criteria) this;
        }

        public Criteria andProfitShareProfitEqualTo(BigDecimal value) {
            addCriterion("PROFIT_SHARE_PROFIT =", value, "profitShareProfit");
            return (Criteria) this;
        }

        public Criteria andProfitShareProfitNotEqualTo(BigDecimal value) {
            addCriterion("PROFIT_SHARE_PROFIT <>", value, "profitShareProfit");
            return (Criteria) this;
        }

        public Criteria andProfitShareProfitGreaterThan(BigDecimal value) {
            addCriterion("PROFIT_SHARE_PROFIT >", value, "profitShareProfit");
            return (Criteria) this;
        }

        public Criteria andProfitShareProfitGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("PROFIT_SHARE_PROFIT >=", value, "profitShareProfit");
            return (Criteria) this;
        }

        public Criteria andProfitShareProfitLessThan(BigDecimal value) {
            addCriterion("PROFIT_SHARE_PROFIT <", value, "profitShareProfit");
            return (Criteria) this;
        }

        public Criteria andProfitShareProfitLessThanOrEqualTo(BigDecimal value) {
            addCriterion("PROFIT_SHARE_PROFIT <=", value, "profitShareProfit");
            return (Criteria) this;
        }

        public Criteria andProfitShareProfitIn(List<BigDecimal> values) {
            addCriterion("PROFIT_SHARE_PROFIT in", values, "profitShareProfit");
            return (Criteria) this;
        }

        public Criteria andProfitShareProfitNotIn(List<BigDecimal> values) {
            addCriterion("PROFIT_SHARE_PROFIT not in", values, "profitShareProfit");
            return (Criteria) this;
        }

        public Criteria andProfitShareProfitBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("PROFIT_SHARE_PROFIT between", value1, value2, "profitShareProfit");
            return (Criteria) this;
        }

        public Criteria andProfitShareProfitNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("PROFIT_SHARE_PROFIT not between", value1, value2, "profitShareProfit");
            return (Criteria) this;
        }

        public Criteria andProfitSharePercentIsNull() {
            addCriterion("PROFIT_SHARE_PERCENT is null");
            return (Criteria) this;
        }

        public Criteria andProfitSharePercentIsNotNull() {
            addCriterion("PROFIT_SHARE_PERCENT is not null");
            return (Criteria) this;
        }

        public Criteria andProfitSharePercentEqualTo(BigDecimal value) {
            addCriterion("PROFIT_SHARE_PERCENT =", value, "profitSharePercent");
            return (Criteria) this;
        }

        public Criteria andProfitSharePercentNotEqualTo(BigDecimal value) {
            addCriterion("PROFIT_SHARE_PERCENT <>", value, "profitSharePercent");
            return (Criteria) this;
        }

        public Criteria andProfitSharePercentGreaterThan(BigDecimal value) {
            addCriterion("PROFIT_SHARE_PERCENT >", value, "profitSharePercent");
            return (Criteria) this;
        }

        public Criteria andProfitSharePercentGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("PROFIT_SHARE_PERCENT >=", value, "profitSharePercent");
            return (Criteria) this;
        }

        public Criteria andProfitSharePercentLessThan(BigDecimal value) {
            addCriterion("PROFIT_SHARE_PERCENT <", value, "profitSharePercent");
            return (Criteria) this;
        }

        public Criteria andProfitSharePercentLessThanOrEqualTo(BigDecimal value) {
            addCriterion("PROFIT_SHARE_PERCENT <=", value, "profitSharePercent");
            return (Criteria) this;
        }

        public Criteria andProfitSharePercentIn(List<BigDecimal> values) {
            addCriterion("PROFIT_SHARE_PERCENT in", values, "profitSharePercent");
            return (Criteria) this;
        }

        public Criteria andProfitSharePercentNotIn(List<BigDecimal> values) {
            addCriterion("PROFIT_SHARE_PERCENT not in", values, "profitSharePercent");
            return (Criteria) this;
        }

        public Criteria andProfitSharePercentBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("PROFIT_SHARE_PERCENT between", value1, value2, "profitSharePercent");
            return (Criteria) this;
        }

        public Criteria andProfitSharePercentNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("PROFIT_SHARE_PERCENT not between", value1, value2, "profitSharePercent");
            return (Criteria) this;
        }

        public Criteria andUpLeaderUserIsNull() {
            addCriterion("UP_LEADER_USER is null");
            return (Criteria) this;
        }

        public Criteria andUpLeaderUserIsNotNull() {
            addCriterion("UP_LEADER_USER is not null");
            return (Criteria) this;
        }

        public Criteria andUpLeaderUserEqualTo(Integer value) {
            addCriterion("UP_LEADER_USER =", value, "upLeaderUser");
            return (Criteria) this;
        }

        public Criteria andUpLeaderUserNotEqualTo(Integer value) {
            addCriterion("UP_LEADER_USER <>", value, "upLeaderUser");
            return (Criteria) this;
        }

        public Criteria andUpLeaderUserGreaterThan(Integer value) {
            addCriterion("UP_LEADER_USER >", value, "upLeaderUser");
            return (Criteria) this;
        }

        public Criteria andUpLeaderUserGreaterThanOrEqualTo(Integer value) {
            addCriterion("UP_LEADER_USER >=", value, "upLeaderUser");
            return (Criteria) this;
        }

        public Criteria andUpLeaderUserLessThan(Integer value) {
            addCriterion("UP_LEADER_USER <", value, "upLeaderUser");
            return (Criteria) this;
        }

        public Criteria andUpLeaderUserLessThanOrEqualTo(Integer value) {
            addCriterion("UP_LEADER_USER <=", value, "upLeaderUser");
            return (Criteria) this;
        }

        public Criteria andUpLeaderUserIn(List<Integer> values) {
            addCriterion("UP_LEADER_USER in", values, "upLeaderUser");
            return (Criteria) this;
        }

        public Criteria andUpLeaderUserNotIn(List<Integer> values) {
            addCriterion("UP_LEADER_USER not in", values, "upLeaderUser");
            return (Criteria) this;
        }

        public Criteria andUpLeaderUserBetween(Integer value1, Integer value2) {
            addCriterion("UP_LEADER_USER between", value1, value2, "upLeaderUser");
            return (Criteria) this;
        }

        public Criteria andUpLeaderUserNotBetween(Integer value1, Integer value2) {
            addCriterion("UP_LEADER_USER not between", value1, value2, "upLeaderUser");
            return (Criteria) this;
        }

        public Criteria andUpLeaderTypeIsNull() {
            addCriterion("UP_LEADER_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andUpLeaderTypeIsNotNull() {
            addCriterion("UP_LEADER_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andUpLeaderTypeEqualTo(Byte value) {
            addCriterion("UP_LEADER_TYPE =", value, "upLeaderType");
            return (Criteria) this;
        }

        public Criteria andUpLeaderTypeNotEqualTo(Byte value) {
            addCriterion("UP_LEADER_TYPE <>", value, "upLeaderType");
            return (Criteria) this;
        }

        public Criteria andUpLeaderTypeGreaterThan(Byte value) {
            addCriterion("UP_LEADER_TYPE >", value, "upLeaderType");
            return (Criteria) this;
        }

        public Criteria andUpLeaderTypeGreaterThanOrEqualTo(Byte value) {
            addCriterion("UP_LEADER_TYPE >=", value, "upLeaderType");
            return (Criteria) this;
        }

        public Criteria andUpLeaderTypeLessThan(Byte value) {
            addCriterion("UP_LEADER_TYPE <", value, "upLeaderType");
            return (Criteria) this;
        }

        public Criteria andUpLeaderTypeLessThanOrEqualTo(Byte value) {
            addCriterion("UP_LEADER_TYPE <=", value, "upLeaderType");
            return (Criteria) this;
        }

        public Criteria andUpLeaderTypeIn(List<Byte> values) {
            addCriterion("UP_LEADER_TYPE in", values, "upLeaderType");
            return (Criteria) this;
        }

        public Criteria andUpLeaderTypeNotIn(List<Byte> values) {
            addCriterion("UP_LEADER_TYPE not in", values, "upLeaderType");
            return (Criteria) this;
        }

        public Criteria andUpLeaderTypeBetween(Byte value1, Byte value2) {
            addCriterion("UP_LEADER_TYPE between", value1, value2, "upLeaderType");
            return (Criteria) this;
        }

        public Criteria andUpLeaderTypeNotBetween(Byte value1, Byte value2) {
            addCriterion("UP_LEADER_TYPE not between", value1, value2, "upLeaderType");
            return (Criteria) this;
        }

        public Criteria andInviteSharePercentIsNull() {
            addCriterion("INVITE_SHARE_PERCENT is null");
            return (Criteria) this;
        }

        public Criteria andInviteSharePercentIsNotNull() {
            addCriterion("INVITE_SHARE_PERCENT is not null");
            return (Criteria) this;
        }

        public Criteria andInviteSharePercentEqualTo(BigDecimal value) {
            addCriterion("INVITE_SHARE_PERCENT =", value, "inviteSharePercent");
            return (Criteria) this;
        }

        public Criteria andInviteSharePercentNotEqualTo(BigDecimal value) {
            addCriterion("INVITE_SHARE_PERCENT <>", value, "inviteSharePercent");
            return (Criteria) this;
        }

        public Criteria andInviteSharePercentGreaterThan(BigDecimal value) {
            addCriterion("INVITE_SHARE_PERCENT >", value, "inviteSharePercent");
            return (Criteria) this;
        }

        public Criteria andInviteSharePercentGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("INVITE_SHARE_PERCENT >=", value, "inviteSharePercent");
            return (Criteria) this;
        }

        public Criteria andInviteSharePercentLessThan(BigDecimal value) {
            addCriterion("INVITE_SHARE_PERCENT <", value, "inviteSharePercent");
            return (Criteria) this;
        }

        public Criteria andInviteSharePercentLessThanOrEqualTo(BigDecimal value) {
            addCriterion("INVITE_SHARE_PERCENT <=", value, "inviteSharePercent");
            return (Criteria) this;
        }

        public Criteria andInviteSharePercentIn(List<BigDecimal> values) {
            addCriterion("INVITE_SHARE_PERCENT in", values, "inviteSharePercent");
            return (Criteria) this;
        }

        public Criteria andInviteSharePercentNotIn(List<BigDecimal> values) {
            addCriterion("INVITE_SHARE_PERCENT not in", values, "inviteSharePercent");
            return (Criteria) this;
        }

        public Criteria andInviteSharePercentBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("INVITE_SHARE_PERCENT between", value1, value2, "inviteSharePercent");
            return (Criteria) this;
        }

        public Criteria andInviteSharePercentNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("INVITE_SHARE_PERCENT not between", value1, value2, "inviteSharePercent");
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