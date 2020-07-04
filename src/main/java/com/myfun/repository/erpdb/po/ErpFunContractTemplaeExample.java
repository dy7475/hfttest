package com.myfun.repository.erpdb.po;

import com.myfun.repository.support.generator.shard.ShardDb;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ErpFunContractTemplaeExample extends ShardDb {
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
	public ErpFunContractTemplaeExample() {
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

		public Criteria andTemplateIdIsNull() {
			addCriterion("TEMPLATE_ID is null");
			return (Criteria) this;
		}

		public Criteria andTemplateIdIsNotNull() {
			addCriterion("TEMPLATE_ID is not null");
			return (Criteria) this;
		}

		public Criteria andTemplateIdEqualTo(Integer value) {
			addCriterion("TEMPLATE_ID =", value, "templateId");
			return (Criteria) this;
		}

		public Criteria andTemplateIdNotEqualTo(Integer value) {
			addCriterion("TEMPLATE_ID <>", value, "templateId");
			return (Criteria) this;
		}

		public Criteria andTemplateIdGreaterThan(Integer value) {
			addCriterion("TEMPLATE_ID >", value, "templateId");
			return (Criteria) this;
		}

		public Criteria andTemplateIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("TEMPLATE_ID >=", value, "templateId");
			return (Criteria) this;
		}

		public Criteria andTemplateIdLessThan(Integer value) {
			addCriterion("TEMPLATE_ID <", value, "templateId");
			return (Criteria) this;
		}

		public Criteria andTemplateIdLessThanOrEqualTo(Integer value) {
			addCriterion("TEMPLATE_ID <=", value, "templateId");
			return (Criteria) this;
		}

		public Criteria andTemplateIdIn(List<Integer> values) {
			addCriterion("TEMPLATE_ID in", values, "templateId");
			return (Criteria) this;
		}

		public Criteria andTemplateIdNotIn(List<Integer> values) {
			addCriterion("TEMPLATE_ID not in", values, "templateId");
			return (Criteria) this;
		}

		public Criteria andTemplateIdBetween(Integer value1, Integer value2) {
			addCriterion("TEMPLATE_ID between", value1, value2, "templateId");
			return (Criteria) this;
		}

		public Criteria andTemplateIdNotBetween(Integer value1, Integer value2) {
			addCriterion("TEMPLATE_ID not between", value1, value2, "templateId");
			return (Criteria) this;
		}

		public Criteria andTemplateNameIsNull() {
			addCriterion("TEMPLATE_NAME is null");
			return (Criteria) this;
		}

		public Criteria andTemplateNameIsNotNull() {
			addCriterion("TEMPLATE_NAME is not null");
			return (Criteria) this;
		}

		public Criteria andTemplateNameEqualTo(String value) {
			addCriterion("TEMPLATE_NAME =", value, "templateName");
			return (Criteria) this;
		}

		public Criteria andTemplateNameNotEqualTo(String value) {
			addCriterion("TEMPLATE_NAME <>", value, "templateName");
			return (Criteria) this;
		}

		public Criteria andTemplateNameGreaterThan(String value) {
			addCriterion("TEMPLATE_NAME >", value, "templateName");
			return (Criteria) this;
		}

		public Criteria andTemplateNameGreaterThanOrEqualTo(String value) {
			addCriterion("TEMPLATE_NAME >=", value, "templateName");
			return (Criteria) this;
		}

		public Criteria andTemplateNameLessThan(String value) {
			addCriterion("TEMPLATE_NAME <", value, "templateName");
			return (Criteria) this;
		}

		public Criteria andTemplateNameLessThanOrEqualTo(String value) {
			addCriterion("TEMPLATE_NAME <=", value, "templateName");
			return (Criteria) this;
		}

		public Criteria andTemplateNameLike(String value) {
			addCriterion("TEMPLATE_NAME like", value, "templateName");
			return (Criteria) this;
		}

		public Criteria andTemplateNameNotLike(String value) {
			addCriterion("TEMPLATE_NAME not like", value, "templateName");
			return (Criteria) this;
		}

		public Criteria andTemplateNameIn(List<String> values) {
			addCriterion("TEMPLATE_NAME in", values, "templateName");
			return (Criteria) this;
		}

		public Criteria andTemplateNameNotIn(List<String> values) {
			addCriterion("TEMPLATE_NAME not in", values, "templateName");
			return (Criteria) this;
		}

		public Criteria andTemplateNameBetween(String value1, String value2) {
			addCriterion("TEMPLATE_NAME between", value1, value2, "templateName");
			return (Criteria) this;
		}

		public Criteria andTemplateNameNotBetween(String value1, String value2) {
			addCriterion("TEMPLATE_NAME not between", value1, value2, "templateName");
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

		public Criteria andTemplateTypeIsNull() {
			addCriterion("TEMPLATE_TYPE is null");
			return (Criteria) this;
		}

		public Criteria andTemplateTypeIsNotNull() {
			addCriterion("TEMPLATE_TYPE is not null");
			return (Criteria) this;
		}

		public Criteria andTemplateTypeEqualTo(Byte value) {
			addCriterion("TEMPLATE_TYPE =", value, "templateType");
			return (Criteria) this;
		}

		public Criteria andTemplateTypeNotEqualTo(Byte value) {
			addCriterion("TEMPLATE_TYPE <>", value, "templateType");
			return (Criteria) this;
		}

		public Criteria andTemplateTypeGreaterThan(Byte value) {
			addCriterion("TEMPLATE_TYPE >", value, "templateType");
			return (Criteria) this;
		}

		public Criteria andTemplateTypeGreaterThanOrEqualTo(Byte value) {
			addCriterion("TEMPLATE_TYPE >=", value, "templateType");
			return (Criteria) this;
		}

		public Criteria andTemplateTypeLessThan(Byte value) {
			addCriterion("TEMPLATE_TYPE <", value, "templateType");
			return (Criteria) this;
		}

		public Criteria andTemplateTypeLessThanOrEqualTo(Byte value) {
			addCriterion("TEMPLATE_TYPE <=", value, "templateType");
			return (Criteria) this;
		}

		public Criteria andTemplateTypeIn(List<Byte> values) {
			addCriterion("TEMPLATE_TYPE in", values, "templateType");
			return (Criteria) this;
		}

		public Criteria andTemplateTypeNotIn(List<Byte> values) {
			addCriterion("TEMPLATE_TYPE not in", values, "templateType");
			return (Criteria) this;
		}

		public Criteria andTemplateTypeBetween(Byte value1, Byte value2) {
			addCriterion("TEMPLATE_TYPE between", value1, value2, "templateType");
			return (Criteria) this;
		}

		public Criteria andTemplateTypeNotBetween(Byte value1, Byte value2) {
			addCriterion("TEMPLATE_TYPE not between", value1, value2, "templateType");
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

		public Criteria andTemplateStatusIsNull() {
			addCriterion("TEMPLATE_STATUS is null");
			return (Criteria) this;
		}

		public Criteria andTemplateStatusIsNotNull() {
			addCriterion("TEMPLATE_STATUS is not null");
			return (Criteria) this;
		}

		public Criteria andTemplateStatusEqualTo(Byte value) {
			addCriterion("TEMPLATE_STATUS =", value, "templateStatus");
			return (Criteria) this;
		}

		public Criteria andTemplateStatusNotEqualTo(Byte value) {
			addCriterion("TEMPLATE_STATUS <>", value, "templateStatus");
			return (Criteria) this;
		}

		public Criteria andTemplateStatusGreaterThan(Byte value) {
			addCriterion("TEMPLATE_STATUS >", value, "templateStatus");
			return (Criteria) this;
		}

		public Criteria andTemplateStatusGreaterThanOrEqualTo(Byte value) {
			addCriterion("TEMPLATE_STATUS >=", value, "templateStatus");
			return (Criteria) this;
		}

		public Criteria andTemplateStatusLessThan(Byte value) {
			addCriterion("TEMPLATE_STATUS <", value, "templateStatus");
			return (Criteria) this;
		}

		public Criteria andTemplateStatusLessThanOrEqualTo(Byte value) {
			addCriterion("TEMPLATE_STATUS <=", value, "templateStatus");
			return (Criteria) this;
		}

		public Criteria andTemplateStatusIn(List<Byte> values) {
			addCriterion("TEMPLATE_STATUS in", values, "templateStatus");
			return (Criteria) this;
		}

		public Criteria andTemplateStatusNotIn(List<Byte> values) {
			addCriterion("TEMPLATE_STATUS not in", values, "templateStatus");
			return (Criteria) this;
		}

		public Criteria andTemplateStatusBetween(Byte value1, Byte value2) {
			addCriterion("TEMPLATE_STATUS between", value1, value2, "templateStatus");
			return (Criteria) this;
		}

		public Criteria andTemplateStatusNotBetween(Byte value1, Byte value2) {
			addCriterion("TEMPLATE_STATUS not between", value1, value2, "templateStatus");
			return (Criteria) this;
		}

		public Criteria andLineHeightIsNull() {
			addCriterion("LINE_HEIGHT is null");
			return (Criteria) this;
		}

		public Criteria andLineHeightIsNotNull() {
			addCriterion("LINE_HEIGHT is not null");
			return (Criteria) this;
		}

		public Criteria andLineHeightEqualTo(BigDecimal value) {
			addCriterion("LINE_HEIGHT =", value, "lineHeight");
			return (Criteria) this;
		}

		public Criteria andLineHeightNotEqualTo(BigDecimal value) {
			addCriterion("LINE_HEIGHT <>", value, "lineHeight");
			return (Criteria) this;
		}

		public Criteria andLineHeightGreaterThan(BigDecimal value) {
			addCriterion("LINE_HEIGHT >", value, "lineHeight");
			return (Criteria) this;
		}

		public Criteria andLineHeightGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("LINE_HEIGHT >=", value, "lineHeight");
			return (Criteria) this;
		}

		public Criteria andLineHeightLessThan(BigDecimal value) {
			addCriterion("LINE_HEIGHT <", value, "lineHeight");
			return (Criteria) this;
		}

		public Criteria andLineHeightLessThanOrEqualTo(BigDecimal value) {
			addCriterion("LINE_HEIGHT <=", value, "lineHeight");
			return (Criteria) this;
		}

		public Criteria andLineHeightIn(List<BigDecimal> values) {
			addCriterion("LINE_HEIGHT in", values, "lineHeight");
			return (Criteria) this;
		}

		public Criteria andLineHeightNotIn(List<BigDecimal> values) {
			addCriterion("LINE_HEIGHT not in", values, "lineHeight");
			return (Criteria) this;
		}

		public Criteria andLineHeightBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("LINE_HEIGHT between", value1, value2, "lineHeight");
			return (Criteria) this;
		}

		public Criteria andLineHeightNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("LINE_HEIGHT not between", value1, value2, "lineHeight");
			return (Criteria) this;
		}

		public Criteria andIsYoujiaTemplateIsNull() {
			addCriterion("IS_YOUJIA_TEMPLATE is null");
			return (Criteria) this;
		}

		public Criteria andIsYoujiaTemplateIsNotNull() {
			addCriterion("IS_YOUJIA_TEMPLATE is not null");
			return (Criteria) this;
		}

		public Criteria andIsYoujiaTemplateEqualTo(Byte value) {
			addCriterion("IS_YOUJIA_TEMPLATE =", value, "isYoujiaTemplate");
			return (Criteria) this;
		}

		public Criteria andIsYoujiaTemplateNotEqualTo(Byte value) {
			addCriterion("IS_YOUJIA_TEMPLATE <>", value, "isYoujiaTemplate");
			return (Criteria) this;
		}

		public Criteria andIsYoujiaTemplateGreaterThan(Byte value) {
			addCriterion("IS_YOUJIA_TEMPLATE >", value, "isYoujiaTemplate");
			return (Criteria) this;
		}

		public Criteria andIsYoujiaTemplateGreaterThanOrEqualTo(Byte value) {
			addCriterion("IS_YOUJIA_TEMPLATE >=", value, "isYoujiaTemplate");
			return (Criteria) this;
		}

		public Criteria andIsYoujiaTemplateLessThan(Byte value) {
			addCriterion("IS_YOUJIA_TEMPLATE <", value, "isYoujiaTemplate");
			return (Criteria) this;
		}

		public Criteria andIsYoujiaTemplateLessThanOrEqualTo(Byte value) {
			addCriterion("IS_YOUJIA_TEMPLATE <=", value, "isYoujiaTemplate");
			return (Criteria) this;
		}

		public Criteria andIsYoujiaTemplateIn(List<Byte> values) {
			addCriterion("IS_YOUJIA_TEMPLATE in", values, "isYoujiaTemplate");
			return (Criteria) this;
		}

		public Criteria andIsYoujiaTemplateNotIn(List<Byte> values) {
			addCriterion("IS_YOUJIA_TEMPLATE not in", values, "isYoujiaTemplate");
			return (Criteria) this;
		}

		public Criteria andIsYoujiaTemplateBetween(Byte value1, Byte value2) {
			addCriterion("IS_YOUJIA_TEMPLATE between", value1, value2, "isYoujiaTemplate");
			return (Criteria) this;
		}

		public Criteria andIsYoujiaTemplateNotBetween(Byte value1, Byte value2) {
			addCriterion("IS_YOUJIA_TEMPLATE not between", value1, value2, "isYoujiaTemplate");
			return (Criteria) this;
		}

		public Criteria andIsSysModelIsNull() {
			addCriterion("IS_SYS_MODEL is null");
			return (Criteria) this;
		}

		public Criteria andIsSysModelIsNotNull() {
			addCriterion("IS_SYS_MODEL is not null");
			return (Criteria) this;
		}

		public Criteria andIsSysModelEqualTo(Integer value) {
			addCriterion("IS_SYS_MODEL =", value, "isSysModel");
			return (Criteria) this;
		}

		public Criteria andIsSysModelNotEqualTo(Integer value) {
			addCriterion("IS_SYS_MODEL <>", value, "isSysModel");
			return (Criteria) this;
		}

		public Criteria andIsSysModelGreaterThan(Integer value) {
			addCriterion("IS_SYS_MODEL >", value, "isSysModel");
			return (Criteria) this;
		}

		public Criteria andIsSysModelGreaterThanOrEqualTo(Integer value) {
			addCriterion("IS_SYS_MODEL >=", value, "isSysModel");
			return (Criteria) this;
		}

		public Criteria andIsSysModelLessThan(Integer value) {
			addCriterion("IS_SYS_MODEL <", value, "isSysModel");
			return (Criteria) this;
		}

		public Criteria andIsSysModelLessThanOrEqualTo(Integer value) {
			addCriterion("IS_SYS_MODEL <=", value, "isSysModel");
			return (Criteria) this;
		}

		public Criteria andIsSysModelIn(List<Integer> values) {
			addCriterion("IS_SYS_MODEL in", values, "isSysModel");
			return (Criteria) this;
		}

		public Criteria andIsSysModelNotIn(List<Integer> values) {
			addCriterion("IS_SYS_MODEL not in", values, "isSysModel");
			return (Criteria) this;
		}

		public Criteria andIsSysModelBetween(Integer value1, Integer value2) {
			addCriterion("IS_SYS_MODEL between", value1, value2, "isSysModel");
			return (Criteria) this;
		}

		public Criteria andIsSysModelNotBetween(Integer value1, Integer value2) {
			addCriterion("IS_SYS_MODEL not between", value1, value2, "isSysModel");
			return (Criteria) this;
		}

		public Criteria andSysTemplateIdIsNull() {
			addCriterion("SYS_TEMPLATE_ID is null");
			return (Criteria) this;
		}

		public Criteria andSysTemplateIdIsNotNull() {
			addCriterion("SYS_TEMPLATE_ID is not null");
			return (Criteria) this;
		}

		public Criteria andSysTemplateIdEqualTo(Integer value) {
			addCriterion("SYS_TEMPLATE_ID =", value, "sysTemplateId");
			return (Criteria) this;
		}

		public Criteria andSysTemplateIdNotEqualTo(Integer value) {
			addCriterion("SYS_TEMPLATE_ID <>", value, "sysTemplateId");
			return (Criteria) this;
		}

		public Criteria andSysTemplateIdGreaterThan(Integer value) {
			addCriterion("SYS_TEMPLATE_ID >", value, "sysTemplateId");
			return (Criteria) this;
		}

		public Criteria andSysTemplateIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("SYS_TEMPLATE_ID >=", value, "sysTemplateId");
			return (Criteria) this;
		}

		public Criteria andSysTemplateIdLessThan(Integer value) {
			addCriterion("SYS_TEMPLATE_ID <", value, "sysTemplateId");
			return (Criteria) this;
		}

		public Criteria andSysTemplateIdLessThanOrEqualTo(Integer value) {
			addCriterion("SYS_TEMPLATE_ID <=", value, "sysTemplateId");
			return (Criteria) this;
		}

		public Criteria andSysTemplateIdIn(List<Integer> values) {
			addCriterion("SYS_TEMPLATE_ID in", values, "sysTemplateId");
			return (Criteria) this;
		}

		public Criteria andSysTemplateIdNotIn(List<Integer> values) {
			addCriterion("SYS_TEMPLATE_ID not in", values, "sysTemplateId");
			return (Criteria) this;
		}

		public Criteria andSysTemplateIdBetween(Integer value1, Integer value2) {
			addCriterion("SYS_TEMPLATE_ID between", value1, value2, "sysTemplateId");
			return (Criteria) this;
		}

		public Criteria andSysTemplateIdNotBetween(Integer value1, Integer value2) {
			addCriterion("SYS_TEMPLATE_ID not between", value1, value2, "sysTemplateId");
			return (Criteria) this;
		}

		public Criteria andContentTypeIsNull() {
			addCriterion("CONTENT_TYPE is null");
			return (Criteria) this;
		}

		public Criteria andContentTypeIsNotNull() {
			addCriterion("CONTENT_TYPE is not null");
			return (Criteria) this;
		}

		public Criteria andContentTypeEqualTo(Byte value) {
			addCriterion("CONTENT_TYPE =", value, "contentType");
			return (Criteria) this;
		}

		public Criteria andContentTypeNotEqualTo(Byte value) {
			addCriterion("CONTENT_TYPE <>", value, "contentType");
			return (Criteria) this;
		}

		public Criteria andContentTypeGreaterThan(Byte value) {
			addCriterion("CONTENT_TYPE >", value, "contentType");
			return (Criteria) this;
		}

		public Criteria andContentTypeGreaterThanOrEqualTo(Byte value) {
			addCriterion("CONTENT_TYPE >=", value, "contentType");
			return (Criteria) this;
		}

		public Criteria andContentTypeLessThan(Byte value) {
			addCriterion("CONTENT_TYPE <", value, "contentType");
			return (Criteria) this;
		}

		public Criteria andContentTypeLessThanOrEqualTo(Byte value) {
			addCriterion("CONTENT_TYPE <=", value, "contentType");
			return (Criteria) this;
		}

		public Criteria andContentTypeIn(List<Byte> values) {
			addCriterion("CONTENT_TYPE in", values, "contentType");
			return (Criteria) this;
		}

		public Criteria andContentTypeNotIn(List<Byte> values) {
			addCriterion("CONTENT_TYPE not in", values, "contentType");
			return (Criteria) this;
		}

		public Criteria andContentTypeBetween(Byte value1, Byte value2) {
			addCriterion("CONTENT_TYPE between", value1, value2, "contentType");
			return (Criteria) this;
		}

		public Criteria andContentTypeNotBetween(Byte value1, Byte value2) {
			addCriterion("CONTENT_TYPE not between", value1, value2, "contentType");
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