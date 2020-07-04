package com.myfun.repository.erpdb.po;

import com.myfun.repository.support.generator.shard.ShardDb;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ErpFunRegsectionControlExample extends ShardDb {
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
	public ErpFunRegsectionControlExample() {
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

		public Criteria andCreateUidIsNull() {
			addCriterion("CREATE_UID is null");
			return (Criteria) this;
		}

		public Criteria andCreateUidIsNotNull() {
			addCriterion("CREATE_UID is not null");
			return (Criteria) this;
		}

		public Criteria andCreateUidEqualTo(Integer value) {
			addCriterion("CREATE_UID =", value, "createUid");
			return (Criteria) this;
		}

		public Criteria andCreateUidNotEqualTo(Integer value) {
			addCriterion("CREATE_UID <>", value, "createUid");
			return (Criteria) this;
		}

		public Criteria andCreateUidGreaterThan(Integer value) {
			addCriterion("CREATE_UID >", value, "createUid");
			return (Criteria) this;
		}

		public Criteria andCreateUidGreaterThanOrEqualTo(Integer value) {
			addCriterion("CREATE_UID >=", value, "createUid");
			return (Criteria) this;
		}

		public Criteria andCreateUidLessThan(Integer value) {
			addCriterion("CREATE_UID <", value, "createUid");
			return (Criteria) this;
		}

		public Criteria andCreateUidLessThanOrEqualTo(Integer value) {
			addCriterion("CREATE_UID <=", value, "createUid");
			return (Criteria) this;
		}

		public Criteria andCreateUidIn(List<Integer> values) {
			addCriterion("CREATE_UID in", values, "createUid");
			return (Criteria) this;
		}

		public Criteria andCreateUidNotIn(List<Integer> values) {
			addCriterion("CREATE_UID not in", values, "createUid");
			return (Criteria) this;
		}

		public Criteria andCreateUidBetween(Integer value1, Integer value2) {
			addCriterion("CREATE_UID between", value1, value2, "createUid");
			return (Criteria) this;
		}

		public Criteria andCreateUidNotBetween(Integer value1, Integer value2) {
			addCriterion("CREATE_UID not between", value1, value2, "createUid");
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

		public Criteria andSectionIdIsNull() {
			addCriterion("SECTION_ID is null");
			return (Criteria) this;
		}

		public Criteria andSectionIdIsNotNull() {
			addCriterion("SECTION_ID is not null");
			return (Criteria) this;
		}

		public Criteria andSectionIdEqualTo(Integer value) {
			addCriterion("SECTION_ID =", value, "sectionId");
			return (Criteria) this;
		}

		public Criteria andSectionIdNotEqualTo(Integer value) {
			addCriterion("SECTION_ID <>", value, "sectionId");
			return (Criteria) this;
		}

		public Criteria andSectionIdGreaterThan(Integer value) {
			addCriterion("SECTION_ID >", value, "sectionId");
			return (Criteria) this;
		}

		public Criteria andSectionIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("SECTION_ID >=", value, "sectionId");
			return (Criteria) this;
		}

		public Criteria andSectionIdLessThan(Integer value) {
			addCriterion("SECTION_ID <", value, "sectionId");
			return (Criteria) this;
		}

		public Criteria andSectionIdLessThanOrEqualTo(Integer value) {
			addCriterion("SECTION_ID <=", value, "sectionId");
			return (Criteria) this;
		}

		public Criteria andSectionIdIn(List<Integer> values) {
			addCriterion("SECTION_ID in", values, "sectionId");
			return (Criteria) this;
		}

		public Criteria andSectionIdNotIn(List<Integer> values) {
			addCriterion("SECTION_ID not in", values, "sectionId");
			return (Criteria) this;
		}

		public Criteria andSectionIdBetween(Integer value1, Integer value2) {
			addCriterion("SECTION_ID between", value1, value2, "sectionId");
			return (Criteria) this;
		}

		public Criteria andSectionIdNotBetween(Integer value1, Integer value2) {
			addCriterion("SECTION_ID not between", value1, value2, "sectionId");
			return (Criteria) this;
		}

		public Criteria andControlTypeIsNull() {
			addCriterion("CONTROL_TYPE is null");
			return (Criteria) this;
		}

		public Criteria andControlTypeIsNotNull() {
			addCriterion("CONTROL_TYPE is not null");
			return (Criteria) this;
		}

		public Criteria andControlTypeEqualTo(Integer value) {
			addCriterion("CONTROL_TYPE =", value, "controlType");
			return (Criteria) this;
		}

		public Criteria andControlTypeNotEqualTo(Integer value) {
			addCriterion("CONTROL_TYPE <>", value, "controlType");
			return (Criteria) this;
		}

		public Criteria andControlTypeGreaterThan(Integer value) {
			addCriterion("CONTROL_TYPE >", value, "controlType");
			return (Criteria) this;
		}

		public Criteria andControlTypeGreaterThanOrEqualTo(Integer value) {
			addCriterion("CONTROL_TYPE >=", value, "controlType");
			return (Criteria) this;
		}

		public Criteria andControlTypeLessThan(Integer value) {
			addCriterion("CONTROL_TYPE <", value, "controlType");
			return (Criteria) this;
		}

		public Criteria andControlTypeLessThanOrEqualTo(Integer value) {
			addCriterion("CONTROL_TYPE <=", value, "controlType");
			return (Criteria) this;
		}

		public Criteria andControlTypeIn(List<Integer> values) {
			addCriterion("CONTROL_TYPE in", values, "controlType");
			return (Criteria) this;
		}

		public Criteria andControlTypeNotIn(List<Integer> values) {
			addCriterion("CONTROL_TYPE not in", values, "controlType");
			return (Criteria) this;
		}

		public Criteria andControlTypeBetween(Integer value1, Integer value2) {
			addCriterion("CONTROL_TYPE between", value1, value2, "controlType");
			return (Criteria) this;
		}

		public Criteria andControlTypeNotBetween(Integer value1, Integer value2) {
			addCriterion("CONTROL_TYPE not between", value1, value2, "controlType");
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