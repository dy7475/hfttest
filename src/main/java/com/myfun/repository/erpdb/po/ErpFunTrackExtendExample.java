package com.myfun.repository.erpdb.po;

import com.myfun.repository.support.generator.shard.ShardDb;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ErpFunTrackExtendExample extends ShardDb {
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
	public ErpFunTrackExtendExample() {
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

		public Criteria andAuditIdIsNull() {
			addCriterion("AUDIT_ID is null");
			return (Criteria) this;
		}

		public Criteria andAuditIdIsNotNull() {
			addCriterion("AUDIT_ID is not null");
			return (Criteria) this;
		}

		public Criteria andAuditIdEqualTo(Integer value) {
			addCriterion("AUDIT_ID =", value, "auditId");
			return (Criteria) this;
		}

		public Criteria andAuditIdNotEqualTo(Integer value) {
			addCriterion("AUDIT_ID <>", value, "auditId");
			return (Criteria) this;
		}

		public Criteria andAuditIdGreaterThan(Integer value) {
			addCriterion("AUDIT_ID >", value, "auditId");
			return (Criteria) this;
		}

		public Criteria andAuditIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("AUDIT_ID >=", value, "auditId");
			return (Criteria) this;
		}

		public Criteria andAuditIdLessThan(Integer value) {
			addCriterion("AUDIT_ID <", value, "auditId");
			return (Criteria) this;
		}

		public Criteria andAuditIdLessThanOrEqualTo(Integer value) {
			addCriterion("AUDIT_ID <=", value, "auditId");
			return (Criteria) this;
		}

		public Criteria andAuditIdIn(List<Integer> values) {
			addCriterion("AUDIT_ID in", values, "auditId");
			return (Criteria) this;
		}

		public Criteria andAuditIdNotIn(List<Integer> values) {
			addCriterion("AUDIT_ID not in", values, "auditId");
			return (Criteria) this;
		}

		public Criteria andAuditIdBetween(Integer value1, Integer value2) {
			addCriterion("AUDIT_ID between", value1, value2, "auditId");
			return (Criteria) this;
		}

		public Criteria andAuditIdNotBetween(Integer value1, Integer value2) {
			addCriterion("AUDIT_ID not between", value1, value2, "auditId");
			return (Criteria) this;
		}

		public Criteria andTrackIdIsNull() {
			addCriterion("TRACK_ID is null");
			return (Criteria) this;
		}

		public Criteria andTrackIdIsNotNull() {
			addCriterion("TRACK_ID is not null");
			return (Criteria) this;
		}

		public Criteria andTrackIdEqualTo(Integer value) {
			addCriterion("TRACK_ID =", value, "trackId");
			return (Criteria) this;
		}

		public Criteria andTrackIdNotEqualTo(Integer value) {
			addCriterion("TRACK_ID <>", value, "trackId");
			return (Criteria) this;
		}

		public Criteria andTrackIdGreaterThan(Integer value) {
			addCriterion("TRACK_ID >", value, "trackId");
			return (Criteria) this;
		}

		public Criteria andTrackIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("TRACK_ID >=", value, "trackId");
			return (Criteria) this;
		}

		public Criteria andTrackIdLessThan(Integer value) {
			addCriterion("TRACK_ID <", value, "trackId");
			return (Criteria) this;
		}

		public Criteria andTrackIdLessThanOrEqualTo(Integer value) {
			addCriterion("TRACK_ID <=", value, "trackId");
			return (Criteria) this;
		}

		public Criteria andTrackIdIn(List<Integer> values) {
			addCriterion("TRACK_ID in", values, "trackId");
			return (Criteria) this;
		}

		public Criteria andTrackIdNotIn(List<Integer> values) {
			addCriterion("TRACK_ID not in", values, "trackId");
			return (Criteria) this;
		}

		public Criteria andTrackIdBetween(Integer value1, Integer value2) {
			addCriterion("TRACK_ID between", value1, value2, "trackId");
			return (Criteria) this;
		}

		public Criteria andTrackIdNotBetween(Integer value1, Integer value2) {
			addCriterion("TRACK_ID not between", value1, value2, "trackId");
			return (Criteria) this;
		}

		public Criteria andFitmentDescribeIsNull() {
			addCriterion("FITMENT_DESCRIBE is null");
			return (Criteria) this;
		}

		public Criteria andFitmentDescribeIsNotNull() {
			addCriterion("FITMENT_DESCRIBE is not null");
			return (Criteria) this;
		}

		public Criteria andFitmentDescribeEqualTo(String value) {
			addCriterion("FITMENT_DESCRIBE =", value, "fitmentDescribe");
			return (Criteria) this;
		}

		public Criteria andFitmentDescribeNotEqualTo(String value) {
			addCriterion("FITMENT_DESCRIBE <>", value, "fitmentDescribe");
			return (Criteria) this;
		}

		public Criteria andFitmentDescribeGreaterThan(String value) {
			addCriterion("FITMENT_DESCRIBE >", value, "fitmentDescribe");
			return (Criteria) this;
		}

		public Criteria andFitmentDescribeGreaterThanOrEqualTo(String value) {
			addCriterion("FITMENT_DESCRIBE >=", value, "fitmentDescribe");
			return (Criteria) this;
		}

		public Criteria andFitmentDescribeLessThan(String value) {
			addCriterion("FITMENT_DESCRIBE <", value, "fitmentDescribe");
			return (Criteria) this;
		}

		public Criteria andFitmentDescribeLessThanOrEqualTo(String value) {
			addCriterion("FITMENT_DESCRIBE <=", value, "fitmentDescribe");
			return (Criteria) this;
		}

		public Criteria andFitmentDescribeLike(String value) {
			addCriterion("FITMENT_DESCRIBE like", value, "fitmentDescribe");
			return (Criteria) this;
		}

		public Criteria andFitmentDescribeNotLike(String value) {
			addCriterion("FITMENT_DESCRIBE not like", value, "fitmentDescribe");
			return (Criteria) this;
		}

		public Criteria andFitmentDescribeIn(List<String> values) {
			addCriterion("FITMENT_DESCRIBE in", values, "fitmentDescribe");
			return (Criteria) this;
		}

		public Criteria andFitmentDescribeNotIn(List<String> values) {
			addCriterion("FITMENT_DESCRIBE not in", values, "fitmentDescribe");
			return (Criteria) this;
		}

		public Criteria andFitmentDescribeBetween(String value1, String value2) {
			addCriterion("FITMENT_DESCRIBE between", value1, value2, "fitmentDescribe");
			return (Criteria) this;
		}

		public Criteria andFitmentDescribeNotBetween(String value1, String value2) {
			addCriterion("FITMENT_DESCRIBE not between", value1, value2, "fitmentDescribe");
			return (Criteria) this;
		}

		public Criteria andCoreSellPointIsNull() {
			addCriterion("CORE_SELL_POINT is null");
			return (Criteria) this;
		}

		public Criteria andCoreSellPointIsNotNull() {
			addCriterion("CORE_SELL_POINT is not null");
			return (Criteria) this;
		}

		public Criteria andCoreSellPointEqualTo(String value) {
			addCriterion("CORE_SELL_POINT =", value, "coreSellPoint");
			return (Criteria) this;
		}

		public Criteria andCoreSellPointNotEqualTo(String value) {
			addCriterion("CORE_SELL_POINT <>", value, "coreSellPoint");
			return (Criteria) this;
		}

		public Criteria andCoreSellPointGreaterThan(String value) {
			addCriterion("CORE_SELL_POINT >", value, "coreSellPoint");
			return (Criteria) this;
		}

		public Criteria andCoreSellPointGreaterThanOrEqualTo(String value) {
			addCriterion("CORE_SELL_POINT >=", value, "coreSellPoint");
			return (Criteria) this;
		}

		public Criteria andCoreSellPointLessThan(String value) {
			addCriterion("CORE_SELL_POINT <", value, "coreSellPoint");
			return (Criteria) this;
		}

		public Criteria andCoreSellPointLessThanOrEqualTo(String value) {
			addCriterion("CORE_SELL_POINT <=", value, "coreSellPoint");
			return (Criteria) this;
		}

		public Criteria andCoreSellPointLike(String value) {
			addCriterion("CORE_SELL_POINT like", value, "coreSellPoint");
			return (Criteria) this;
		}

		public Criteria andCoreSellPointNotLike(String value) {
			addCriterion("CORE_SELL_POINT not like", value, "coreSellPoint");
			return (Criteria) this;
		}

		public Criteria andCoreSellPointIn(List<String> values) {
			addCriterion("CORE_SELL_POINT in", values, "coreSellPoint");
			return (Criteria) this;
		}

		public Criteria andCoreSellPointNotIn(List<String> values) {
			addCriterion("CORE_SELL_POINT not in", values, "coreSellPoint");
			return (Criteria) this;
		}

		public Criteria andCoreSellPointBetween(String value1, String value2) {
			addCriterion("CORE_SELL_POINT between", value1, value2, "coreSellPoint");
			return (Criteria) this;
		}

		public Criteria andCoreSellPointNotBetween(String value1, String value2) {
			addCriterion("CORE_SELL_POINT not between", value1, value2, "coreSellPoint");
			return (Criteria) this;
		}

		public Criteria andPropertyRightsIsNull() {
			addCriterion("PROPERTY_RIGHTS is null");
			return (Criteria) this;
		}

		public Criteria andPropertyRightsIsNotNull() {
			addCriterion("PROPERTY_RIGHTS is not null");
			return (Criteria) this;
		}

		public Criteria andPropertyRightsEqualTo(String value) {
			addCriterion("PROPERTY_RIGHTS =", value, "propertyRights");
			return (Criteria) this;
		}

		public Criteria andPropertyRightsNotEqualTo(String value) {
			addCriterion("PROPERTY_RIGHTS <>", value, "propertyRights");
			return (Criteria) this;
		}

		public Criteria andPropertyRightsGreaterThan(String value) {
			addCriterion("PROPERTY_RIGHTS >", value, "propertyRights");
			return (Criteria) this;
		}

		public Criteria andPropertyRightsGreaterThanOrEqualTo(String value) {
			addCriterion("PROPERTY_RIGHTS >=", value, "propertyRights");
			return (Criteria) this;
		}

		public Criteria andPropertyRightsLessThan(String value) {
			addCriterion("PROPERTY_RIGHTS <", value, "propertyRights");
			return (Criteria) this;
		}

		public Criteria andPropertyRightsLessThanOrEqualTo(String value) {
			addCriterion("PROPERTY_RIGHTS <=", value, "propertyRights");
			return (Criteria) this;
		}

		public Criteria andPropertyRightsLike(String value) {
			addCriterion("PROPERTY_RIGHTS like", value, "propertyRights");
			return (Criteria) this;
		}

		public Criteria andPropertyRightsNotLike(String value) {
			addCriterion("PROPERTY_RIGHTS not like", value, "propertyRights");
			return (Criteria) this;
		}

		public Criteria andPropertyRightsIn(List<String> values) {
			addCriterion("PROPERTY_RIGHTS in", values, "propertyRights");
			return (Criteria) this;
		}

		public Criteria andPropertyRightsNotIn(List<String> values) {
			addCriterion("PROPERTY_RIGHTS not in", values, "propertyRights");
			return (Criteria) this;
		}

		public Criteria andPropertyRightsBetween(String value1, String value2) {
			addCriterion("PROPERTY_RIGHTS between", value1, value2, "propertyRights");
			return (Criteria) this;
		}

		public Criteria andPropertyRightsNotBetween(String value1, String value2) {
			addCriterion("PROPERTY_RIGHTS not between", value1, value2, "propertyRights");
			return (Criteria) this;
		}

		public Criteria andLayoutIntroduceIsNull() {
			addCriterion("LAYOUT_INTRODUCE is null");
			return (Criteria) this;
		}

		public Criteria andLayoutIntroduceIsNotNull() {
			addCriterion("LAYOUT_INTRODUCE is not null");
			return (Criteria) this;
		}

		public Criteria andLayoutIntroduceEqualTo(String value) {
			addCriterion("LAYOUT_INTRODUCE =", value, "layoutIntroduce");
			return (Criteria) this;
		}

		public Criteria andLayoutIntroduceNotEqualTo(String value) {
			addCriterion("LAYOUT_INTRODUCE <>", value, "layoutIntroduce");
			return (Criteria) this;
		}

		public Criteria andLayoutIntroduceGreaterThan(String value) {
			addCriterion("LAYOUT_INTRODUCE >", value, "layoutIntroduce");
			return (Criteria) this;
		}

		public Criteria andLayoutIntroduceGreaterThanOrEqualTo(String value) {
			addCriterion("LAYOUT_INTRODUCE >=", value, "layoutIntroduce");
			return (Criteria) this;
		}

		public Criteria andLayoutIntroduceLessThan(String value) {
			addCriterion("LAYOUT_INTRODUCE <", value, "layoutIntroduce");
			return (Criteria) this;
		}

		public Criteria andLayoutIntroduceLessThanOrEqualTo(String value) {
			addCriterion("LAYOUT_INTRODUCE <=", value, "layoutIntroduce");
			return (Criteria) this;
		}

		public Criteria andLayoutIntroduceLike(String value) {
			addCriterion("LAYOUT_INTRODUCE like", value, "layoutIntroduce");
			return (Criteria) this;
		}

		public Criteria andLayoutIntroduceNotLike(String value) {
			addCriterion("LAYOUT_INTRODUCE not like", value, "layoutIntroduce");
			return (Criteria) this;
		}

		public Criteria andLayoutIntroduceIn(List<String> values) {
			addCriterion("LAYOUT_INTRODUCE in", values, "layoutIntroduce");
			return (Criteria) this;
		}

		public Criteria andLayoutIntroduceNotIn(List<String> values) {
			addCriterion("LAYOUT_INTRODUCE not in", values, "layoutIntroduce");
			return (Criteria) this;
		}

		public Criteria andLayoutIntroduceBetween(String value1, String value2) {
			addCriterion("LAYOUT_INTRODUCE between", value1, value2, "layoutIntroduce");
			return (Criteria) this;
		}

		public Criteria andLayoutIntroduceNotBetween(String value1, String value2) {
			addCriterion("LAYOUT_INTRODUCE not between", value1, value2, "layoutIntroduce");
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

		public Criteria andOtherInfoIsNull() {
			addCriterion("OTHER_INFO is null");
			return (Criteria) this;
		}

		public Criteria andOtherInfoIsNotNull() {
			addCriterion("OTHER_INFO is not null");
			return (Criteria) this;
		}

		public Criteria andOtherInfoEqualTo(String value) {
			addCriterion("OTHER_INFO =", value, "otherInfo");
			return (Criteria) this;
		}

		public Criteria andOtherInfoNotEqualTo(String value) {
			addCriterion("OTHER_INFO <>", value, "otherInfo");
			return (Criteria) this;
		}

		public Criteria andOtherInfoGreaterThan(String value) {
			addCriterion("OTHER_INFO >", value, "otherInfo");
			return (Criteria) this;
		}

		public Criteria andOtherInfoGreaterThanOrEqualTo(String value) {
			addCriterion("OTHER_INFO >=", value, "otherInfo");
			return (Criteria) this;
		}

		public Criteria andOtherInfoLessThan(String value) {
			addCriterion("OTHER_INFO <", value, "otherInfo");
			return (Criteria) this;
		}

		public Criteria andOtherInfoLessThanOrEqualTo(String value) {
			addCriterion("OTHER_INFO <=", value, "otherInfo");
			return (Criteria) this;
		}

		public Criteria andOtherInfoLike(String value) {
			addCriterion("OTHER_INFO like", value, "otherInfo");
			return (Criteria) this;
		}

		public Criteria andOtherInfoNotLike(String value) {
			addCriterion("OTHER_INFO not like", value, "otherInfo");
			return (Criteria) this;
		}

		public Criteria andOtherInfoIn(List<String> values) {
			addCriterion("OTHER_INFO in", values, "otherInfo");
			return (Criteria) this;
		}

		public Criteria andOtherInfoNotIn(List<String> values) {
			addCriterion("OTHER_INFO not in", values, "otherInfo");
			return (Criteria) this;
		}

		public Criteria andOtherInfoBetween(String value1, String value2) {
			addCriterion("OTHER_INFO between", value1, value2, "otherInfo");
			return (Criteria) this;
		}

		public Criteria andOtherInfoNotBetween(String value1, String value2) {
			addCriterion("OTHER_INFO not between", value1, value2, "otherInfo");
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