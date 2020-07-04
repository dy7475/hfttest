package com.myfun.repository.erpdb.po;

import com.myfun.repository.support.generator.shard.ShardDb;
import java.util.ArrayList;
import java.util.List;

public class ErpFunDeptsExample extends ShardDb {
    /**
	 * @mbggenerated
	 */
	protected String orderByClause;
	/**
	 * @mbggenerated
	 */
	protected boolean distinct;
	/**
	 * @mbggenerated
	 */
	protected List<Criteria> oredCriteria;

	/**
	 * @mbggenerated
	 */
	public ErpFunDeptsExample() {
		oredCriteria = new ArrayList<Criteria>();
	}

	/**
	 * @mbggenerated
	 */
	public void setOrderByClause(String orderByClause) {
		this.orderByClause = orderByClause;
	}

	/**
	 * @mbggenerated
	 */
	public String getOrderByClause() {
		return orderByClause;
	}

	/**
	 * @mbggenerated
	 */
	public void setDistinct(boolean distinct) {
		this.distinct = distinct;
	}

	/**
	 * @mbggenerated
	 */
	public boolean isDistinct() {
		return distinct;
	}

	/**
	 * @mbggenerated
	 */
	public List<Criteria> getOredCriteria() {
		return oredCriteria;
	}

	/**
	 * @mbggenerated
	 */
	public void or(Criteria criteria) {
		oredCriteria.add(criteria);
	}

	/**
	 * @mbggenerated
	 */
	public Criteria or() {
		Criteria criteria = createCriteriaInternal();
		oredCriteria.add(criteria);
		return criteria;
	}

	/**
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
	 * @mbggenerated
	 */
	protected Criteria createCriteriaInternal() {
		Criteria criteria = new Criteria();
		return criteria;
	}

	/**
	 * @mbggenerated
	 */
	public void clear() {
		oredCriteria.clear();
		orderByClause = null;
		distinct = false;
	}

	/**
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

		public Criteria andRegionIdIsNull() {
			addCriterion("REGION_ID is null");
			return (Criteria) this;
		}

		public Criteria andRegionIdIsNotNull() {
			addCriterion("REGION_ID is not null");
			return (Criteria) this;
		}

		public Criteria andRegionIdEqualTo(Integer value) {
			addCriterion("REGION_ID =", value, "regionId");
			return (Criteria) this;
		}

		public Criteria andRegionIdNotEqualTo(Integer value) {
			addCriterion("REGION_ID <>", value, "regionId");
			return (Criteria) this;
		}

		public Criteria andRegionIdGreaterThan(Integer value) {
			addCriterion("REGION_ID >", value, "regionId");
			return (Criteria) this;
		}

		public Criteria andRegionIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("REGION_ID >=", value, "regionId");
			return (Criteria) this;
		}

		public Criteria andRegionIdLessThan(Integer value) {
			addCriterion("REGION_ID <", value, "regionId");
			return (Criteria) this;
		}

		public Criteria andRegionIdLessThanOrEqualTo(Integer value) {
			addCriterion("REGION_ID <=", value, "regionId");
			return (Criteria) this;
		}

		public Criteria andRegionIdIn(List<Integer> values) {
			addCriterion("REGION_ID in", values, "regionId");
			return (Criteria) this;
		}

		public Criteria andRegionIdNotIn(List<Integer> values) {
			addCriterion("REGION_ID not in", values, "regionId");
			return (Criteria) this;
		}

		public Criteria andRegionIdBetween(Integer value1, Integer value2) {
			addCriterion("REGION_ID between", value1, value2, "regionId");
			return (Criteria) this;
		}

		public Criteria andRegionIdNotBetween(Integer value1, Integer value2) {
			addCriterion("REGION_ID not between", value1, value2, "regionId");
			return (Criteria) this;
		}

		public Criteria andSeqNoIsNull() {
			addCriterion("SEQ_NO is null");
			return (Criteria) this;
		}

		public Criteria andSeqNoIsNotNull() {
			addCriterion("SEQ_NO is not null");
			return (Criteria) this;
		}

		public Criteria andSeqNoEqualTo(Integer value) {
			addCriterion("SEQ_NO =", value, "seqNo");
			return (Criteria) this;
		}

		public Criteria andSeqNoNotEqualTo(Integer value) {
			addCriterion("SEQ_NO <>", value, "seqNo");
			return (Criteria) this;
		}

		public Criteria andSeqNoGreaterThan(Integer value) {
			addCriterion("SEQ_NO >", value, "seqNo");
			return (Criteria) this;
		}

		public Criteria andSeqNoGreaterThanOrEqualTo(Integer value) {
			addCriterion("SEQ_NO >=", value, "seqNo");
			return (Criteria) this;
		}

		public Criteria andSeqNoLessThan(Integer value) {
			addCriterion("SEQ_NO <", value, "seqNo");
			return (Criteria) this;
		}

		public Criteria andSeqNoLessThanOrEqualTo(Integer value) {
			addCriterion("SEQ_NO <=", value, "seqNo");
			return (Criteria) this;
		}

		public Criteria andSeqNoIn(List<Integer> values) {
			addCriterion("SEQ_NO in", values, "seqNo");
			return (Criteria) this;
		}

		public Criteria andSeqNoNotIn(List<Integer> values) {
			addCriterion("SEQ_NO not in", values, "seqNo");
			return (Criteria) this;
		}

		public Criteria andSeqNoBetween(Integer value1, Integer value2) {
			addCriterion("SEQ_NO between", value1, value2, "seqNo");
			return (Criteria) this;
		}

		public Criteria andSeqNoNotBetween(Integer value1, Integer value2) {
			addCriterion("SEQ_NO not between", value1, value2, "seqNo");
			return (Criteria) this;
		}

		public Criteria andDeptNameIsNull() {
			addCriterion("DEPT_NAME is null");
			return (Criteria) this;
		}

		public Criteria andDeptNameIsNotNull() {
			addCriterion("DEPT_NAME is not null");
			return (Criteria) this;
		}

		public Criteria andDeptNameEqualTo(String value) {
			addCriterion("DEPT_NAME =", value, "deptName");
			return (Criteria) this;
		}

		public Criteria andDeptNameNotEqualTo(String value) {
			addCriterion("DEPT_NAME <>", value, "deptName");
			return (Criteria) this;
		}

		public Criteria andDeptNameGreaterThan(String value) {
			addCriterion("DEPT_NAME >", value, "deptName");
			return (Criteria) this;
		}

		public Criteria andDeptNameGreaterThanOrEqualTo(String value) {
			addCriterion("DEPT_NAME >=", value, "deptName");
			return (Criteria) this;
		}

		public Criteria andDeptNameLessThan(String value) {
			addCriterion("DEPT_NAME <", value, "deptName");
			return (Criteria) this;
		}

		public Criteria andDeptNameLessThanOrEqualTo(String value) {
			addCriterion("DEPT_NAME <=", value, "deptName");
			return (Criteria) this;
		}

		public Criteria andDeptNameLike(String value) {
			addCriterion("DEPT_NAME like", value, "deptName");
			return (Criteria) this;
		}

		public Criteria andDeptNameNotLike(String value) {
			addCriterion("DEPT_NAME not like", value, "deptName");
			return (Criteria) this;
		}

		public Criteria andDeptNameIn(List<String> values) {
			addCriterion("DEPT_NAME in", values, "deptName");
			return (Criteria) this;
		}

		public Criteria andDeptNameNotIn(List<String> values) {
			addCriterion("DEPT_NAME not in", values, "deptName");
			return (Criteria) this;
		}

		public Criteria andDeptNameBetween(String value1, String value2) {
			addCriterion("DEPT_NAME between", value1, value2, "deptName");
			return (Criteria) this;
		}

		public Criteria andDeptNameNotBetween(String value1, String value2) {
			addCriterion("DEPT_NAME not between", value1, value2, "deptName");
			return (Criteria) this;
		}

		public Criteria andDeptCodeIsNull() {
			addCriterion("DEPT_CODE is null");
			return (Criteria) this;
		}

		public Criteria andDeptCodeIsNotNull() {
			addCriterion("DEPT_CODE is not null");
			return (Criteria) this;
		}

		public Criteria andDeptCodeEqualTo(String value) {
			addCriterion("DEPT_CODE =", value, "deptCode");
			return (Criteria) this;
		}

		public Criteria andDeptCodeNotEqualTo(String value) {
			addCriterion("DEPT_CODE <>", value, "deptCode");
			return (Criteria) this;
		}

		public Criteria andDeptCodeGreaterThan(String value) {
			addCriterion("DEPT_CODE >", value, "deptCode");
			return (Criteria) this;
		}

		public Criteria andDeptCodeGreaterThanOrEqualTo(String value) {
			addCriterion("DEPT_CODE >=", value, "deptCode");
			return (Criteria) this;
		}

		public Criteria andDeptCodeLessThan(String value) {
			addCriterion("DEPT_CODE <", value, "deptCode");
			return (Criteria) this;
		}

		public Criteria andDeptCodeLessThanOrEqualTo(String value) {
			addCriterion("DEPT_CODE <=", value, "deptCode");
			return (Criteria) this;
		}

		public Criteria andDeptCodeLike(String value) {
			addCriterion("DEPT_CODE like", value, "deptCode");
			return (Criteria) this;
		}

		public Criteria andDeptCodeNotLike(String value) {
			addCriterion("DEPT_CODE not like", value, "deptCode");
			return (Criteria) this;
		}

		public Criteria andDeptCodeIn(List<String> values) {
			addCriterion("DEPT_CODE in", values, "deptCode");
			return (Criteria) this;
		}

		public Criteria andDeptCodeNotIn(List<String> values) {
			addCriterion("DEPT_CODE not in", values, "deptCode");
			return (Criteria) this;
		}

		public Criteria andDeptCodeBetween(String value1, String value2) {
			addCriterion("DEPT_CODE between", value1, value2, "deptCode");
			return (Criteria) this;
		}

		public Criteria andDeptCodeNotBetween(String value1, String value2) {
			addCriterion("DEPT_CODE not between", value1, value2, "deptCode");
			return (Criteria) this;
		}

		public Criteria andDeptAddrIsNull() {
			addCriterion("DEPT_ADDR is null");
			return (Criteria) this;
		}

		public Criteria andDeptAddrIsNotNull() {
			addCriterion("DEPT_ADDR is not null");
			return (Criteria) this;
		}

		public Criteria andDeptAddrEqualTo(String value) {
			addCriterion("DEPT_ADDR =", value, "deptAddr");
			return (Criteria) this;
		}

		public Criteria andDeptAddrNotEqualTo(String value) {
			addCriterion("DEPT_ADDR <>", value, "deptAddr");
			return (Criteria) this;
		}

		public Criteria andDeptAddrGreaterThan(String value) {
			addCriterion("DEPT_ADDR >", value, "deptAddr");
			return (Criteria) this;
		}

		public Criteria andDeptAddrGreaterThanOrEqualTo(String value) {
			addCriterion("DEPT_ADDR >=", value, "deptAddr");
			return (Criteria) this;
		}

		public Criteria andDeptAddrLessThan(String value) {
			addCriterion("DEPT_ADDR <", value, "deptAddr");
			return (Criteria) this;
		}

		public Criteria andDeptAddrLessThanOrEqualTo(String value) {
			addCriterion("DEPT_ADDR <=", value, "deptAddr");
			return (Criteria) this;
		}

		public Criteria andDeptAddrLike(String value) {
			addCriterion("DEPT_ADDR like", value, "deptAddr");
			return (Criteria) this;
		}

		public Criteria andDeptAddrNotLike(String value) {
			addCriterion("DEPT_ADDR not like", value, "deptAddr");
			return (Criteria) this;
		}

		public Criteria andDeptAddrIn(List<String> values) {
			addCriterion("DEPT_ADDR in", values, "deptAddr");
			return (Criteria) this;
		}

		public Criteria andDeptAddrNotIn(List<String> values) {
			addCriterion("DEPT_ADDR not in", values, "deptAddr");
			return (Criteria) this;
		}

		public Criteria andDeptAddrBetween(String value1, String value2) {
			addCriterion("DEPT_ADDR between", value1, value2, "deptAddr");
			return (Criteria) this;
		}

		public Criteria andDeptAddrNotBetween(String value1, String value2) {
			addCriterion("DEPT_ADDR not between", value1, value2, "deptAddr");
			return (Criteria) this;
		}

		public Criteria andDeptTeleIsNull() {
			addCriterion("DEPT_TELE is null");
			return (Criteria) this;
		}

		public Criteria andDeptTeleIsNotNull() {
			addCriterion("DEPT_TELE is not null");
			return (Criteria) this;
		}

		public Criteria andDeptTeleEqualTo(String value) {
			addCriterion("DEPT_TELE =", value, "deptTele");
			return (Criteria) this;
		}

		public Criteria andDeptTeleNotEqualTo(String value) {
			addCriterion("DEPT_TELE <>", value, "deptTele");
			return (Criteria) this;
		}

		public Criteria andDeptTeleGreaterThan(String value) {
			addCriterion("DEPT_TELE >", value, "deptTele");
			return (Criteria) this;
		}

		public Criteria andDeptTeleGreaterThanOrEqualTo(String value) {
			addCriterion("DEPT_TELE >=", value, "deptTele");
			return (Criteria) this;
		}

		public Criteria andDeptTeleLessThan(String value) {
			addCriterion("DEPT_TELE <", value, "deptTele");
			return (Criteria) this;
		}

		public Criteria andDeptTeleLessThanOrEqualTo(String value) {
			addCriterion("DEPT_TELE <=", value, "deptTele");
			return (Criteria) this;
		}

		public Criteria andDeptTeleLike(String value) {
			addCriterion("DEPT_TELE like", value, "deptTele");
			return (Criteria) this;
		}

		public Criteria andDeptTeleNotLike(String value) {
			addCriterion("DEPT_TELE not like", value, "deptTele");
			return (Criteria) this;
		}

		public Criteria andDeptTeleIn(List<String> values) {
			addCriterion("DEPT_TELE in", values, "deptTele");
			return (Criteria) this;
		}

		public Criteria andDeptTeleNotIn(List<String> values) {
			addCriterion("DEPT_TELE not in", values, "deptTele");
			return (Criteria) this;
		}

		public Criteria andDeptTeleBetween(String value1, String value2) {
			addCriterion("DEPT_TELE between", value1, value2, "deptTele");
			return (Criteria) this;
		}

		public Criteria andDeptTeleNotBetween(String value1, String value2) {
			addCriterion("DEPT_TELE not between", value1, value2, "deptTele");
			return (Criteria) this;
		}

		public Criteria andDeptContactIsNull() {
			addCriterion("DEPT_CONTACT is null");
			return (Criteria) this;
		}

		public Criteria andDeptContactIsNotNull() {
			addCriterion("DEPT_CONTACT is not null");
			return (Criteria) this;
		}

		public Criteria andDeptContactEqualTo(String value) {
			addCriterion("DEPT_CONTACT =", value, "deptContact");
			return (Criteria) this;
		}

		public Criteria andDeptContactNotEqualTo(String value) {
			addCriterion("DEPT_CONTACT <>", value, "deptContact");
			return (Criteria) this;
		}

		public Criteria andDeptContactGreaterThan(String value) {
			addCriterion("DEPT_CONTACT >", value, "deptContact");
			return (Criteria) this;
		}

		public Criteria andDeptContactGreaterThanOrEqualTo(String value) {
			addCriterion("DEPT_CONTACT >=", value, "deptContact");
			return (Criteria) this;
		}

		public Criteria andDeptContactLessThan(String value) {
			addCriterion("DEPT_CONTACT <", value, "deptContact");
			return (Criteria) this;
		}

		public Criteria andDeptContactLessThanOrEqualTo(String value) {
			addCriterion("DEPT_CONTACT <=", value, "deptContact");
			return (Criteria) this;
		}

		public Criteria andDeptContactLike(String value) {
			addCriterion("DEPT_CONTACT like", value, "deptContact");
			return (Criteria) this;
		}

		public Criteria andDeptContactNotLike(String value) {
			addCriterion("DEPT_CONTACT not like", value, "deptContact");
			return (Criteria) this;
		}

		public Criteria andDeptContactIn(List<String> values) {
			addCriterion("DEPT_CONTACT in", values, "deptContact");
			return (Criteria) this;
		}

		public Criteria andDeptContactNotIn(List<String> values) {
			addCriterion("DEPT_CONTACT not in", values, "deptContact");
			return (Criteria) this;
		}

		public Criteria andDeptContactBetween(String value1, String value2) {
			addCriterion("DEPT_CONTACT between", value1, value2, "deptContact");
			return (Criteria) this;
		}

		public Criteria andDeptContactNotBetween(String value1, String value2) {
			addCriterion("DEPT_CONTACT not between", value1, value2, "deptContact");
			return (Criteria) this;
		}

		public Criteria andDeptDescIsNull() {
			addCriterion("DEPT_DESC is null");
			return (Criteria) this;
		}

		public Criteria andDeptDescIsNotNull() {
			addCriterion("DEPT_DESC is not null");
			return (Criteria) this;
		}

		public Criteria andDeptDescEqualTo(String value) {
			addCriterion("DEPT_DESC =", value, "deptDesc");
			return (Criteria) this;
		}

		public Criteria andDeptDescNotEqualTo(String value) {
			addCriterion("DEPT_DESC <>", value, "deptDesc");
			return (Criteria) this;
		}

		public Criteria andDeptDescGreaterThan(String value) {
			addCriterion("DEPT_DESC >", value, "deptDesc");
			return (Criteria) this;
		}

		public Criteria andDeptDescGreaterThanOrEqualTo(String value) {
			addCriterion("DEPT_DESC >=", value, "deptDesc");
			return (Criteria) this;
		}

		public Criteria andDeptDescLessThan(String value) {
			addCriterion("DEPT_DESC <", value, "deptDesc");
			return (Criteria) this;
		}

		public Criteria andDeptDescLessThanOrEqualTo(String value) {
			addCriterion("DEPT_DESC <=", value, "deptDesc");
			return (Criteria) this;
		}

		public Criteria andDeptDescLike(String value) {
			addCriterion("DEPT_DESC like", value, "deptDesc");
			return (Criteria) this;
		}

		public Criteria andDeptDescNotLike(String value) {
			addCriterion("DEPT_DESC not like", value, "deptDesc");
			return (Criteria) this;
		}

		public Criteria andDeptDescIn(List<String> values) {
			addCriterion("DEPT_DESC in", values, "deptDesc");
			return (Criteria) this;
		}

		public Criteria andDeptDescNotIn(List<String> values) {
			addCriterion("DEPT_DESC not in", values, "deptDesc");
			return (Criteria) this;
		}

		public Criteria andDeptDescBetween(String value1, String value2) {
			addCriterion("DEPT_DESC between", value1, value2, "deptDesc");
			return (Criteria) this;
		}

		public Criteria andDeptDescNotBetween(String value1, String value2) {
			addCriterion("DEPT_DESC not between", value1, value2, "deptDesc");
			return (Criteria) this;
		}

		public Criteria andDeptFlagIsNull() {
			addCriterion("DEPT_FLAG is null");
			return (Criteria) this;
		}

		public Criteria andDeptFlagIsNotNull() {
			addCriterion("DEPT_FLAG is not null");
			return (Criteria) this;
		}

		public Criteria andDeptFlagEqualTo(Integer value) {
			addCriterion("DEPT_FLAG =", value, "deptFlag");
			return (Criteria) this;
		}

		public Criteria andDeptFlagNotEqualTo(Integer value) {
			addCriterion("DEPT_FLAG <>", value, "deptFlag");
			return (Criteria) this;
		}

		public Criteria andDeptFlagGreaterThan(Integer value) {
			addCriterion("DEPT_FLAG >", value, "deptFlag");
			return (Criteria) this;
		}

		public Criteria andDeptFlagGreaterThanOrEqualTo(Integer value) {
			addCriterion("DEPT_FLAG >=", value, "deptFlag");
			return (Criteria) this;
		}

		public Criteria andDeptFlagLessThan(Integer value) {
			addCriterion("DEPT_FLAG <", value, "deptFlag");
			return (Criteria) this;
		}

		public Criteria andDeptFlagLessThanOrEqualTo(Integer value) {
			addCriterion("DEPT_FLAG <=", value, "deptFlag");
			return (Criteria) this;
		}

		public Criteria andDeptFlagIn(List<Integer> values) {
			addCriterion("DEPT_FLAG in", values, "deptFlag");
			return (Criteria) this;
		}

		public Criteria andDeptFlagNotIn(List<Integer> values) {
			addCriterion("DEPT_FLAG not in", values, "deptFlag");
			return (Criteria) this;
		}

		public Criteria andDeptFlagBetween(Integer value1, Integer value2) {
			addCriterion("DEPT_FLAG between", value1, value2, "deptFlag");
			return (Criteria) this;
		}

		public Criteria andDeptFlagNotBetween(Integer value1, Integer value2) {
			addCriterion("DEPT_FLAG not between", value1, value2, "deptFlag");
			return (Criteria) this;
		}

		public Criteria andRoamNumIsNull() {
			addCriterion("ROAM_NUM is null");
			return (Criteria) this;
		}

		public Criteria andRoamNumIsNotNull() {
			addCriterion("ROAM_NUM is not null");
			return (Criteria) this;
		}

		public Criteria andRoamNumEqualTo(Byte value) {
			addCriterion("ROAM_NUM =", value, "roamNum");
			return (Criteria) this;
		}

		public Criteria andRoamNumNotEqualTo(Byte value) {
			addCriterion("ROAM_NUM <>", value, "roamNum");
			return (Criteria) this;
		}

		public Criteria andRoamNumGreaterThan(Byte value) {
			addCriterion("ROAM_NUM >", value, "roamNum");
			return (Criteria) this;
		}

		public Criteria andRoamNumGreaterThanOrEqualTo(Byte value) {
			addCriterion("ROAM_NUM >=", value, "roamNum");
			return (Criteria) this;
		}

		public Criteria andRoamNumLessThan(Byte value) {
			addCriterion("ROAM_NUM <", value, "roamNum");
			return (Criteria) this;
		}

		public Criteria andRoamNumLessThanOrEqualTo(Byte value) {
			addCriterion("ROAM_NUM <=", value, "roamNum");
			return (Criteria) this;
		}

		public Criteria andRoamNumIn(List<Byte> values) {
			addCriterion("ROAM_NUM in", values, "roamNum");
			return (Criteria) this;
		}

		public Criteria andRoamNumNotIn(List<Byte> values) {
			addCriterion("ROAM_NUM not in", values, "roamNum");
			return (Criteria) this;
		}

		public Criteria andRoamNumBetween(Byte value1, Byte value2) {
			addCriterion("ROAM_NUM between", value1, value2, "roamNum");
			return (Criteria) this;
		}

		public Criteria andRoamNumNotBetween(Byte value1, Byte value2) {
			addCriterion("ROAM_NUM not between", value1, value2, "roamNum");
			return (Criteria) this;
		}

		public Criteria andUserNumIsNull() {
			addCriterion("USER_NUM is null");
			return (Criteria) this;
		}

		public Criteria andUserNumIsNotNull() {
			addCriterion("USER_NUM is not null");
			return (Criteria) this;
		}

		public Criteria andUserNumEqualTo(Integer value) {
			addCriterion("USER_NUM =", value, "userNum");
			return (Criteria) this;
		}

		public Criteria andUserNumNotEqualTo(Integer value) {
			addCriterion("USER_NUM <>", value, "userNum");
			return (Criteria) this;
		}

		public Criteria andUserNumGreaterThan(Integer value) {
			addCriterion("USER_NUM >", value, "userNum");
			return (Criteria) this;
		}

		public Criteria andUserNumGreaterThanOrEqualTo(Integer value) {
			addCriterion("USER_NUM >=", value, "userNum");
			return (Criteria) this;
		}

		public Criteria andUserNumLessThan(Integer value) {
			addCriterion("USER_NUM <", value, "userNum");
			return (Criteria) this;
		}

		public Criteria andUserNumLessThanOrEqualTo(Integer value) {
			addCriterion("USER_NUM <=", value, "userNum");
			return (Criteria) this;
		}

		public Criteria andUserNumIn(List<Integer> values) {
			addCriterion("USER_NUM in", values, "userNum");
			return (Criteria) this;
		}

		public Criteria andUserNumNotIn(List<Integer> values) {
			addCriterion("USER_NUM not in", values, "userNum");
			return (Criteria) this;
		}

		public Criteria andUserNumBetween(Integer value1, Integer value2) {
			addCriterion("USER_NUM between", value1, value2, "userNum");
			return (Criteria) this;
		}

		public Criteria andUserNumNotBetween(Integer value1, Integer value2) {
			addCriterion("USER_NUM not between", value1, value2, "userNum");
			return (Criteria) this;
		}

		public Criteria andDeptTypeIsNull() {
			addCriterion("DEPT_TYPE is null");
			return (Criteria) this;
		}

		public Criteria andDeptTypeIsNotNull() {
			addCriterion("DEPT_TYPE is not null");
			return (Criteria) this;
		}

		public Criteria andDeptTypeEqualTo(Byte value) {
			addCriterion("DEPT_TYPE =", value, "deptType");
			return (Criteria) this;
		}

		public Criteria andDeptTypeNotEqualTo(Byte value) {
			addCriterion("DEPT_TYPE <>", value, "deptType");
			return (Criteria) this;
		}

		public Criteria andDeptTypeGreaterThan(Byte value) {
			addCriterion("DEPT_TYPE >", value, "deptType");
			return (Criteria) this;
		}

		public Criteria andDeptTypeGreaterThanOrEqualTo(Byte value) {
			addCriterion("DEPT_TYPE >=", value, "deptType");
			return (Criteria) this;
		}

		public Criteria andDeptTypeLessThan(Byte value) {
			addCriterion("DEPT_TYPE <", value, "deptType");
			return (Criteria) this;
		}

		public Criteria andDeptTypeLessThanOrEqualTo(Byte value) {
			addCriterion("DEPT_TYPE <=", value, "deptType");
			return (Criteria) this;
		}

		public Criteria andDeptTypeIn(List<Byte> values) {
			addCriterion("DEPT_TYPE in", values, "deptType");
			return (Criteria) this;
		}

		public Criteria andDeptTypeNotIn(List<Byte> values) {
			addCriterion("DEPT_TYPE not in", values, "deptType");
			return (Criteria) this;
		}

		public Criteria andDeptTypeBetween(Byte value1, Byte value2) {
			addCriterion("DEPT_TYPE between", value1, value2, "deptType");
			return (Criteria) this;
		}

		public Criteria andDeptTypeNotBetween(Byte value1, Byte value2) {
			addCriterion("DEPT_TYPE not between", value1, value2, "deptType");
			return (Criteria) this;
		}

		public Criteria andCustLevelIsNull() {
			addCriterion("CUST_LEVEL is null");
			return (Criteria) this;
		}

		public Criteria andCustLevelIsNotNull() {
			addCriterion("CUST_LEVEL is not null");
			return (Criteria) this;
		}

		public Criteria andCustLevelEqualTo(Byte value) {
			addCriterion("CUST_LEVEL =", value, "custLevel");
			return (Criteria) this;
		}

		public Criteria andCustLevelNotEqualTo(Byte value) {
			addCriterion("CUST_LEVEL <>", value, "custLevel");
			return (Criteria) this;
		}

		public Criteria andCustLevelGreaterThan(Byte value) {
			addCriterion("CUST_LEVEL >", value, "custLevel");
			return (Criteria) this;
		}

		public Criteria andCustLevelGreaterThanOrEqualTo(Byte value) {
			addCriterion("CUST_LEVEL >=", value, "custLevel");
			return (Criteria) this;
		}

		public Criteria andCustLevelLessThan(Byte value) {
			addCriterion("CUST_LEVEL <", value, "custLevel");
			return (Criteria) this;
		}

		public Criteria andCustLevelLessThanOrEqualTo(Byte value) {
			addCriterion("CUST_LEVEL <=", value, "custLevel");
			return (Criteria) this;
		}

		public Criteria andCustLevelIn(List<Byte> values) {
			addCriterion("CUST_LEVEL in", values, "custLevel");
			return (Criteria) this;
		}

		public Criteria andCustLevelNotIn(List<Byte> values) {
			addCriterion("CUST_LEVEL not in", values, "custLevel");
			return (Criteria) this;
		}

		public Criteria andCustLevelBetween(Byte value1, Byte value2) {
			addCriterion("CUST_LEVEL between", value1, value2, "custLevel");
			return (Criteria) this;
		}

		public Criteria andCustLevelNotBetween(Byte value1, Byte value2) {
			addCriterion("CUST_LEVEL not between", value1, value2, "custLevel");
			return (Criteria) this;
		}

		public Criteria andUpdateUidIsNull() {
			addCriterion("UPDATE_UID is null");
			return (Criteria) this;
		}

		public Criteria andUpdateUidIsNotNull() {
			addCriterion("UPDATE_UID is not null");
			return (Criteria) this;
		}

		public Criteria andUpdateUidEqualTo(Integer value) {
			addCriterion("UPDATE_UID =", value, "updateUid");
			return (Criteria) this;
		}

		public Criteria andUpdateUidNotEqualTo(Integer value) {
			addCriterion("UPDATE_UID <>", value, "updateUid");
			return (Criteria) this;
		}

		public Criteria andUpdateUidGreaterThan(Integer value) {
			addCriterion("UPDATE_UID >", value, "updateUid");
			return (Criteria) this;
		}

		public Criteria andUpdateUidGreaterThanOrEqualTo(Integer value) {
			addCriterion("UPDATE_UID >=", value, "updateUid");
			return (Criteria) this;
		}

		public Criteria andUpdateUidLessThan(Integer value) {
			addCriterion("UPDATE_UID <", value, "updateUid");
			return (Criteria) this;
		}

		public Criteria andUpdateUidLessThanOrEqualTo(Integer value) {
			addCriterion("UPDATE_UID <=", value, "updateUid");
			return (Criteria) this;
		}

		public Criteria andUpdateUidIn(List<Integer> values) {
			addCriterion("UPDATE_UID in", values, "updateUid");
			return (Criteria) this;
		}

		public Criteria andUpdateUidNotIn(List<Integer> values) {
			addCriterion("UPDATE_UID not in", values, "updateUid");
			return (Criteria) this;
		}

		public Criteria andUpdateUidBetween(Integer value1, Integer value2) {
			addCriterion("UPDATE_UID between", value1, value2, "updateUid");
			return (Criteria) this;
		}

		public Criteria andUpdateUidNotBetween(Integer value1, Integer value2) {
			addCriterion("UPDATE_UID not between", value1, value2, "updateUid");
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

		public Criteria andUpdateTimeEqualTo(String value) {
			addCriterion("UPDATE_TIME =", value, "updateTime");
			return (Criteria) this;
		}

		public Criteria andUpdateTimeNotEqualTo(String value) {
			addCriterion("UPDATE_TIME <>", value, "updateTime");
			return (Criteria) this;
		}

		public Criteria andUpdateTimeGreaterThan(String value) {
			addCriterion("UPDATE_TIME >", value, "updateTime");
			return (Criteria) this;
		}

		public Criteria andUpdateTimeGreaterThanOrEqualTo(String value) {
			addCriterion("UPDATE_TIME >=", value, "updateTime");
			return (Criteria) this;
		}

		public Criteria andUpdateTimeLessThan(String value) {
			addCriterion("UPDATE_TIME <", value, "updateTime");
			return (Criteria) this;
		}

		public Criteria andUpdateTimeLessThanOrEqualTo(String value) {
			addCriterion("UPDATE_TIME <=", value, "updateTime");
			return (Criteria) this;
		}

		public Criteria andUpdateTimeLike(String value) {
			addCriterion("UPDATE_TIME like", value, "updateTime");
			return (Criteria) this;
		}

		public Criteria andUpdateTimeNotLike(String value) {
			addCriterion("UPDATE_TIME not like", value, "updateTime");
			return (Criteria) this;
		}

		public Criteria andUpdateTimeIn(List<String> values) {
			addCriterion("UPDATE_TIME in", values, "updateTime");
			return (Criteria) this;
		}

		public Criteria andUpdateTimeNotIn(List<String> values) {
			addCriterion("UPDATE_TIME not in", values, "updateTime");
			return (Criteria) this;
		}

		public Criteria andUpdateTimeBetween(String value1, String value2) {
			addCriterion("UPDATE_TIME between", value1, value2, "updateTime");
			return (Criteria) this;
		}

		public Criteria andUpdateTimeNotBetween(String value1, String value2) {
			addCriterion("UPDATE_TIME not between", value1, value2, "updateTime");
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

		public Criteria andDdhaofangFlagIsNull() {
			addCriterion("DDHAOFANG_FLAG is null");
			return (Criteria) this;
		}

		public Criteria andDdhaofangFlagIsNotNull() {
			addCriterion("DDHAOFANG_FLAG is not null");
			return (Criteria) this;
		}

		public Criteria andDdhaofangFlagEqualTo(Byte value) {
			addCriterion("DDHAOFANG_FLAG =", value, "ddhaofangFlag");
			return (Criteria) this;
		}

		public Criteria andDdhaofangFlagNotEqualTo(Byte value) {
			addCriterion("DDHAOFANG_FLAG <>", value, "ddhaofangFlag");
			return (Criteria) this;
		}

		public Criteria andDdhaofangFlagGreaterThan(Byte value) {
			addCriterion("DDHAOFANG_FLAG >", value, "ddhaofangFlag");
			return (Criteria) this;
		}

		public Criteria andDdhaofangFlagGreaterThanOrEqualTo(Byte value) {
			addCriterion("DDHAOFANG_FLAG >=", value, "ddhaofangFlag");
			return (Criteria) this;
		}

		public Criteria andDdhaofangFlagLessThan(Byte value) {
			addCriterion("DDHAOFANG_FLAG <", value, "ddhaofangFlag");
			return (Criteria) this;
		}

		public Criteria andDdhaofangFlagLessThanOrEqualTo(Byte value) {
			addCriterion("DDHAOFANG_FLAG <=", value, "ddhaofangFlag");
			return (Criteria) this;
		}

		public Criteria andDdhaofangFlagIn(List<Byte> values) {
			addCriterion("DDHAOFANG_FLAG in", values, "ddhaofangFlag");
			return (Criteria) this;
		}

		public Criteria andDdhaofangFlagNotIn(List<Byte> values) {
			addCriterion("DDHAOFANG_FLAG not in", values, "ddhaofangFlag");
			return (Criteria) this;
		}

		public Criteria andDdhaofangFlagBetween(Byte value1, Byte value2) {
			addCriterion("DDHAOFANG_FLAG between", value1, value2, "ddhaofangFlag");
			return (Criteria) this;
		}

		public Criteria andDdhaofangFlagNotBetween(Byte value1, Byte value2) {
			addCriterion("DDHAOFANG_FLAG not between", value1, value2, "ddhaofangFlag");
			return (Criteria) this;
		}

		public Criteria andDeptCnameIsNull() {
			addCriterion("DEPT_CNAME is null");
			return (Criteria) this;
		}

		public Criteria andDeptCnameIsNotNull() {
			addCriterion("DEPT_CNAME is not null");
			return (Criteria) this;
		}

		public Criteria andDeptCnameEqualTo(String value) {
			addCriterion("DEPT_CNAME =", value, "deptCname");
			return (Criteria) this;
		}

		public Criteria andDeptCnameNotEqualTo(String value) {
			addCriterion("DEPT_CNAME <>", value, "deptCname");
			return (Criteria) this;
		}

		public Criteria andDeptCnameGreaterThan(String value) {
			addCriterion("DEPT_CNAME >", value, "deptCname");
			return (Criteria) this;
		}

		public Criteria andDeptCnameGreaterThanOrEqualTo(String value) {
			addCriterion("DEPT_CNAME >=", value, "deptCname");
			return (Criteria) this;
		}

		public Criteria andDeptCnameLessThan(String value) {
			addCriterion("DEPT_CNAME <", value, "deptCname");
			return (Criteria) this;
		}

		public Criteria andDeptCnameLessThanOrEqualTo(String value) {
			addCriterion("DEPT_CNAME <=", value, "deptCname");
			return (Criteria) this;
		}

		public Criteria andDeptCnameLike(String value) {
			addCriterion("DEPT_CNAME like", value, "deptCname");
			return (Criteria) this;
		}

		public Criteria andDeptCnameNotLike(String value) {
			addCriterion("DEPT_CNAME not like", value, "deptCname");
			return (Criteria) this;
		}

		public Criteria andDeptCnameIn(List<String> values) {
			addCriterion("DEPT_CNAME in", values, "deptCname");
			return (Criteria) this;
		}

		public Criteria andDeptCnameNotIn(List<String> values) {
			addCriterion("DEPT_CNAME not in", values, "deptCname");
			return (Criteria) this;
		}

		public Criteria andDeptCnameBetween(String value1, String value2) {
			addCriterion("DEPT_CNAME between", value1, value2, "deptCname");
			return (Criteria) this;
		}

		public Criteria andDeptCnameNotBetween(String value1, String value2) {
			addCriterion("DEPT_CNAME not between", value1, value2, "deptCname");
			return (Criteria) this;
		}

		public Criteria andBuyAccountNumIsNull() {
			addCriterion("BUY_ACCOUNT_NUM is null");
			return (Criteria) this;
		}

		public Criteria andBuyAccountNumIsNotNull() {
			addCriterion("BUY_ACCOUNT_NUM is not null");
			return (Criteria) this;
		}

		public Criteria andBuyAccountNumEqualTo(Integer value) {
			addCriterion("BUY_ACCOUNT_NUM =", value, "buyAccountNum");
			return (Criteria) this;
		}

		public Criteria andBuyAccountNumNotEqualTo(Integer value) {
			addCriterion("BUY_ACCOUNT_NUM <>", value, "buyAccountNum");
			return (Criteria) this;
		}

		public Criteria andBuyAccountNumGreaterThan(Integer value) {
			addCriterion("BUY_ACCOUNT_NUM >", value, "buyAccountNum");
			return (Criteria) this;
		}

		public Criteria andBuyAccountNumGreaterThanOrEqualTo(Integer value) {
			addCriterion("BUY_ACCOUNT_NUM >=", value, "buyAccountNum");
			return (Criteria) this;
		}

		public Criteria andBuyAccountNumLessThan(Integer value) {
			addCriterion("BUY_ACCOUNT_NUM <", value, "buyAccountNum");
			return (Criteria) this;
		}

		public Criteria andBuyAccountNumLessThanOrEqualTo(Integer value) {
			addCriterion("BUY_ACCOUNT_NUM <=", value, "buyAccountNum");
			return (Criteria) this;
		}

		public Criteria andBuyAccountNumIn(List<Integer> values) {
			addCriterion("BUY_ACCOUNT_NUM in", values, "buyAccountNum");
			return (Criteria) this;
		}

		public Criteria andBuyAccountNumNotIn(List<Integer> values) {
			addCriterion("BUY_ACCOUNT_NUM not in", values, "buyAccountNum");
			return (Criteria) this;
		}

		public Criteria andBuyAccountNumBetween(Integer value1, Integer value2) {
			addCriterion("BUY_ACCOUNT_NUM between", value1, value2, "buyAccountNum");
			return (Criteria) this;
		}

		public Criteria andBuyAccountNumNotBetween(Integer value1, Integer value2) {
			addCriterion("BUY_ACCOUNT_NUM not between", value1, value2, "buyAccountNum");
			return (Criteria) this;
		}

		public Criteria andIsHeadquartersIsNull() {
			addCriterion("IS_HEADQUARTERS is null");
			return (Criteria) this;
		}

		public Criteria andIsHeadquartersIsNotNull() {
			addCriterion("IS_HEADQUARTERS is not null");
			return (Criteria) this;
		}

		public Criteria andIsHeadquartersEqualTo(Byte value) {
			addCriterion("IS_HEADQUARTERS =", value, "isHeadquarters");
			return (Criteria) this;
		}

		public Criteria andIsHeadquartersNotEqualTo(Byte value) {
			addCriterion("IS_HEADQUARTERS <>", value, "isHeadquarters");
			return (Criteria) this;
		}

		public Criteria andIsHeadquartersGreaterThan(Byte value) {
			addCriterion("IS_HEADQUARTERS >", value, "isHeadquarters");
			return (Criteria) this;
		}

		public Criteria andIsHeadquartersGreaterThanOrEqualTo(Byte value) {
			addCriterion("IS_HEADQUARTERS >=", value, "isHeadquarters");
			return (Criteria) this;
		}

		public Criteria andIsHeadquartersLessThan(Byte value) {
			addCriterion("IS_HEADQUARTERS <", value, "isHeadquarters");
			return (Criteria) this;
		}

		public Criteria andIsHeadquartersLessThanOrEqualTo(Byte value) {
			addCriterion("IS_HEADQUARTERS <=", value, "isHeadquarters");
			return (Criteria) this;
		}

		public Criteria andIsHeadquartersIn(List<Byte> values) {
			addCriterion("IS_HEADQUARTERS in", values, "isHeadquarters");
			return (Criteria) this;
		}

		public Criteria andIsHeadquartersNotIn(List<Byte> values) {
			addCriterion("IS_HEADQUARTERS not in", values, "isHeadquarters");
			return (Criteria) this;
		}

		public Criteria andIsHeadquartersBetween(Byte value1, Byte value2) {
			addCriterion("IS_HEADQUARTERS between", value1, value2, "isHeadquarters");
			return (Criteria) this;
		}

		public Criteria andIsHeadquartersNotBetween(Byte value1, Byte value2) {
			addCriterion("IS_HEADQUARTERS not between", value1, value2, "isHeadquarters");
			return (Criteria) this;
		}

		public Criteria andIsUnpaidDeptIsNull() {
			addCriterion("IS_UNPAID_DEPT is null");
			return (Criteria) this;
		}

		public Criteria andIsUnpaidDeptIsNotNull() {
			addCriterion("IS_UNPAID_DEPT is not null");
			return (Criteria) this;
		}

		public Criteria andIsUnpaidDeptEqualTo(Byte value) {
			addCriterion("IS_UNPAID_DEPT =", value, "isUnpaidDept");
			return (Criteria) this;
		}

		public Criteria andIsUnpaidDeptNotEqualTo(Byte value) {
			addCriterion("IS_UNPAID_DEPT <>", value, "isUnpaidDept");
			return (Criteria) this;
		}

		public Criteria andIsUnpaidDeptGreaterThan(Byte value) {
			addCriterion("IS_UNPAID_DEPT >", value, "isUnpaidDept");
			return (Criteria) this;
		}

		public Criteria andIsUnpaidDeptGreaterThanOrEqualTo(Byte value) {
			addCriterion("IS_UNPAID_DEPT >=", value, "isUnpaidDept");
			return (Criteria) this;
		}

		public Criteria andIsUnpaidDeptLessThan(Byte value) {
			addCriterion("IS_UNPAID_DEPT <", value, "isUnpaidDept");
			return (Criteria) this;
		}

		public Criteria andIsUnpaidDeptLessThanOrEqualTo(Byte value) {
			addCriterion("IS_UNPAID_DEPT <=", value, "isUnpaidDept");
			return (Criteria) this;
		}

		public Criteria andIsUnpaidDeptIn(List<Byte> values) {
			addCriterion("IS_UNPAID_DEPT in", values, "isUnpaidDept");
			return (Criteria) this;
		}

		public Criteria andIsUnpaidDeptNotIn(List<Byte> values) {
			addCriterion("IS_UNPAID_DEPT not in", values, "isUnpaidDept");
			return (Criteria) this;
		}

		public Criteria andIsUnpaidDeptBetween(Byte value1, Byte value2) {
			addCriterion("IS_UNPAID_DEPT between", value1, value2, "isUnpaidDept");
			return (Criteria) this;
		}

		public Criteria andIsUnpaidDeptNotBetween(Byte value1, Byte value2) {
			addCriterion("IS_UNPAID_DEPT not between", value1, value2, "isUnpaidDept");
			return (Criteria) this;
		}

		public Criteria andStatisticsFlagIsNull() {
			addCriterion("STATISTICS_FLAG is null");
			return (Criteria) this;
		}

		public Criteria andStatisticsFlagIsNotNull() {
			addCriterion("STATISTICS_FLAG is not null");
			return (Criteria) this;
		}

		public Criteria andStatisticsFlagEqualTo(Byte value) {
			addCriterion("STATISTICS_FLAG =", value, "statisticsFlag");
			return (Criteria) this;
		}

		public Criteria andStatisticsFlagNotEqualTo(Byte value) {
			addCriterion("STATISTICS_FLAG <>", value, "statisticsFlag");
			return (Criteria) this;
		}

		public Criteria andStatisticsFlagGreaterThan(Byte value) {
			addCriterion("STATISTICS_FLAG >", value, "statisticsFlag");
			return (Criteria) this;
		}

		public Criteria andStatisticsFlagGreaterThanOrEqualTo(Byte value) {
			addCriterion("STATISTICS_FLAG >=", value, "statisticsFlag");
			return (Criteria) this;
		}

		public Criteria andStatisticsFlagLessThan(Byte value) {
			addCriterion("STATISTICS_FLAG <", value, "statisticsFlag");
			return (Criteria) this;
		}

		public Criteria andStatisticsFlagLessThanOrEqualTo(Byte value) {
			addCriterion("STATISTICS_FLAG <=", value, "statisticsFlag");
			return (Criteria) this;
		}

		public Criteria andStatisticsFlagIn(List<Byte> values) {
			addCriterion("STATISTICS_FLAG in", values, "statisticsFlag");
			return (Criteria) this;
		}

		public Criteria andStatisticsFlagNotIn(List<Byte> values) {
			addCriterion("STATISTICS_FLAG not in", values, "statisticsFlag");
			return (Criteria) this;
		}

		public Criteria andStatisticsFlagBetween(Byte value1, Byte value2) {
			addCriterion("STATISTICS_FLAG between", value1, value2, "statisticsFlag");
			return (Criteria) this;
		}

		public Criteria andStatisticsFlagNotBetween(Byte value1, Byte value2) {
			addCriterion("STATISTICS_FLAG not between", value1, value2, "statisticsFlag");
			return (Criteria) this;
		}

		public Criteria andHiddenOrganizationIsNull() {
			addCriterion("HIDDEN_ORGANIZATION is null");
			return (Criteria) this;
		}

		public Criteria andHiddenOrganizationIsNotNull() {
			addCriterion("HIDDEN_ORGANIZATION is not null");
			return (Criteria) this;
		}

		public Criteria andHiddenOrganizationEqualTo(Byte value) {
			addCriterion("HIDDEN_ORGANIZATION =", value, "hiddenOrganization");
			return (Criteria) this;
		}

		public Criteria andHiddenOrganizationNotEqualTo(Byte value) {
			addCriterion("HIDDEN_ORGANIZATION <>", value, "hiddenOrganization");
			return (Criteria) this;
		}

		public Criteria andHiddenOrganizationGreaterThan(Byte value) {
			addCriterion("HIDDEN_ORGANIZATION >", value, "hiddenOrganization");
			return (Criteria) this;
		}

		public Criteria andHiddenOrganizationGreaterThanOrEqualTo(Byte value) {
			addCriterion("HIDDEN_ORGANIZATION >=", value, "hiddenOrganization");
			return (Criteria) this;
		}

		public Criteria andHiddenOrganizationLessThan(Byte value) {
			addCriterion("HIDDEN_ORGANIZATION <", value, "hiddenOrganization");
			return (Criteria) this;
		}

		public Criteria andHiddenOrganizationLessThanOrEqualTo(Byte value) {
			addCriterion("HIDDEN_ORGANIZATION <=", value, "hiddenOrganization");
			return (Criteria) this;
		}

		public Criteria andHiddenOrganizationIn(List<Byte> values) {
			addCriterion("HIDDEN_ORGANIZATION in", values, "hiddenOrganization");
			return (Criteria) this;
		}

		public Criteria andHiddenOrganizationNotIn(List<Byte> values) {
			addCriterion("HIDDEN_ORGANIZATION not in", values, "hiddenOrganization");
			return (Criteria) this;
		}

		public Criteria andHiddenOrganizationBetween(Byte value1, Byte value2) {
			addCriterion("HIDDEN_ORGANIZATION between", value1, value2, "hiddenOrganization");
			return (Criteria) this;
		}

		public Criteria andHiddenOrganizationNotBetween(Byte value1, Byte value2) {
			addCriterion("HIDDEN_ORGANIZATION not between", value1, value2, "hiddenOrganization");
			return (Criteria) this;
		}

		public Criteria andSupportPropertyFlagIsNull() {
			addCriterion("SUPPORT_PROPERTY_FLAG is null");
			return (Criteria) this;
		}

		public Criteria andSupportPropertyFlagIsNotNull() {
			addCriterion("SUPPORT_PROPERTY_FLAG is not null");
			return (Criteria) this;
		}

		public Criteria andSupportPropertyFlagEqualTo(Byte value) {
			addCriterion("SUPPORT_PROPERTY_FLAG =", value, "supportPropertyFlag");
			return (Criteria) this;
		}

		public Criteria andSupportPropertyFlagNotEqualTo(Byte value) {
			addCriterion("SUPPORT_PROPERTY_FLAG <>", value, "supportPropertyFlag");
			return (Criteria) this;
		}

		public Criteria andSupportPropertyFlagGreaterThan(Byte value) {
			addCriterion("SUPPORT_PROPERTY_FLAG >", value, "supportPropertyFlag");
			return (Criteria) this;
		}

		public Criteria andSupportPropertyFlagGreaterThanOrEqualTo(Byte value) {
			addCriterion("SUPPORT_PROPERTY_FLAG >=", value, "supportPropertyFlag");
			return (Criteria) this;
		}

		public Criteria andSupportPropertyFlagLessThan(Byte value) {
			addCriterion("SUPPORT_PROPERTY_FLAG <", value, "supportPropertyFlag");
			return (Criteria) this;
		}

		public Criteria andSupportPropertyFlagLessThanOrEqualTo(Byte value) {
			addCriterion("SUPPORT_PROPERTY_FLAG <=", value, "supportPropertyFlag");
			return (Criteria) this;
		}

		public Criteria andSupportPropertyFlagIn(List<Byte> values) {
			addCriterion("SUPPORT_PROPERTY_FLAG in", values, "supportPropertyFlag");
			return (Criteria) this;
		}

		public Criteria andSupportPropertyFlagNotIn(List<Byte> values) {
			addCriterion("SUPPORT_PROPERTY_FLAG not in", values, "supportPropertyFlag");
			return (Criteria) this;
		}

		public Criteria andSupportPropertyFlagBetween(Byte value1, Byte value2) {
			addCriterion("SUPPORT_PROPERTY_FLAG between", value1, value2, "supportPropertyFlag");
			return (Criteria) this;
		}

		public Criteria andSupportPropertyFlagNotBetween(Byte value1, Byte value2) {
			addCriterion("SUPPORT_PROPERTY_FLAG not between", value1, value2, "supportPropertyFlag");
			return (Criteria) this;
		}

		public Criteria andPartnerIdIsNull() {
			addCriterion("PARTNER_ID is null");
			return (Criteria) this;
		}

		public Criteria andPartnerIdIsNotNull() {
			addCriterion("PARTNER_ID is not null");
			return (Criteria) this;
		}

		public Criteria andPartnerIdEqualTo(Integer value) {
			addCriterion("PARTNER_ID =", value, "partnerId");
			return (Criteria) this;
		}

		public Criteria andPartnerIdNotEqualTo(Integer value) {
			addCriterion("PARTNER_ID <>", value, "partnerId");
			return (Criteria) this;
		}

		public Criteria andPartnerIdGreaterThan(Integer value) {
			addCriterion("PARTNER_ID >", value, "partnerId");
			return (Criteria) this;
		}

		public Criteria andPartnerIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("PARTNER_ID >=", value, "partnerId");
			return (Criteria) this;
		}

		public Criteria andPartnerIdLessThan(Integer value) {
			addCriterion("PARTNER_ID <", value, "partnerId");
			return (Criteria) this;
		}

		public Criteria andPartnerIdLessThanOrEqualTo(Integer value) {
			addCriterion("PARTNER_ID <=", value, "partnerId");
			return (Criteria) this;
		}

		public Criteria andPartnerIdIn(List<Integer> values) {
			addCriterion("PARTNER_ID in", values, "partnerId");
			return (Criteria) this;
		}

		public Criteria andPartnerIdNotIn(List<Integer> values) {
			addCriterion("PARTNER_ID not in", values, "partnerId");
			return (Criteria) this;
		}

		public Criteria andPartnerIdBetween(Integer value1, Integer value2) {
			addCriterion("PARTNER_ID between", value1, value2, "partnerId");
			return (Criteria) this;
		}

		public Criteria andPartnerIdNotBetween(Integer value1, Integer value2) {
			addCriterion("PARTNER_ID not between", value1, value2, "partnerId");
			return (Criteria) this;
		}
	}

	/**
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

	/**
     *
     * @mbggenerated do_not_delete_during_merge
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }
}