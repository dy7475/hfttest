package com.myfun.repository.admindb.po;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AdminZhiyeSynchronousTestRecordsExample {
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
	public AdminZhiyeSynchronousTestRecordsExample() {
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

		public Criteria andRecordsIdIsNull() {
			addCriterion("RECORDS_ID is null");
			return (Criteria) this;
		}

		public Criteria andRecordsIdIsNotNull() {
			addCriterion("RECORDS_ID is not null");
			return (Criteria) this;
		}

		public Criteria andRecordsIdEqualTo(Integer value) {
			addCriterion("RECORDS_ID =", value, "recordsId");
			return (Criteria) this;
		}

		public Criteria andRecordsIdNotEqualTo(Integer value) {
			addCriterion("RECORDS_ID <>", value, "recordsId");
			return (Criteria) this;
		}

		public Criteria andRecordsIdGreaterThan(Integer value) {
			addCriterion("RECORDS_ID >", value, "recordsId");
			return (Criteria) this;
		}

		public Criteria andRecordsIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("RECORDS_ID >=", value, "recordsId");
			return (Criteria) this;
		}

		public Criteria andRecordsIdLessThan(Integer value) {
			addCriterion("RECORDS_ID <", value, "recordsId");
			return (Criteria) this;
		}

		public Criteria andRecordsIdLessThanOrEqualTo(Integer value) {
			addCriterion("RECORDS_ID <=", value, "recordsId");
			return (Criteria) this;
		}

		public Criteria andRecordsIdIn(List<Integer> values) {
			addCriterion("RECORDS_ID in", values, "recordsId");
			return (Criteria) this;
		}

		public Criteria andRecordsIdNotIn(List<Integer> values) {
			addCriterion("RECORDS_ID not in", values, "recordsId");
			return (Criteria) this;
		}

		public Criteria andRecordsIdBetween(Integer value1, Integer value2) {
			addCriterion("RECORDS_ID between", value1, value2, "recordsId");
			return (Criteria) this;
		}

		public Criteria andRecordsIdNotBetween(Integer value1, Integer value2) {
			addCriterion("RECORDS_ID not between", value1, value2, "recordsId");
			return (Criteria) this;
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

		public Criteria andBrokerIdIsNull() {
			addCriterion("BROKER_ID is null");
			return (Criteria) this;
		}

		public Criteria andBrokerIdIsNotNull() {
			addCriterion("BROKER_ID is not null");
			return (Criteria) this;
		}

		public Criteria andBrokerIdEqualTo(Integer value) {
			addCriterion("BROKER_ID =", value, "brokerId");
			return (Criteria) this;
		}

		public Criteria andBrokerIdNotEqualTo(Integer value) {
			addCriterion("BROKER_ID <>", value, "brokerId");
			return (Criteria) this;
		}

		public Criteria andBrokerIdGreaterThan(Integer value) {
			addCriterion("BROKER_ID >", value, "brokerId");
			return (Criteria) this;
		}

		public Criteria andBrokerIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("BROKER_ID >=", value, "brokerId");
			return (Criteria) this;
		}

		public Criteria andBrokerIdLessThan(Integer value) {
			addCriterion("BROKER_ID <", value, "brokerId");
			return (Criteria) this;
		}

		public Criteria andBrokerIdLessThanOrEqualTo(Integer value) {
			addCriterion("BROKER_ID <=", value, "brokerId");
			return (Criteria) this;
		}

		public Criteria andBrokerIdIn(List<Integer> values) {
			addCriterion("BROKER_ID in", values, "brokerId");
			return (Criteria) this;
		}

		public Criteria andBrokerIdNotIn(List<Integer> values) {
			addCriterion("BROKER_ID not in", values, "brokerId");
			return (Criteria) this;
		}

		public Criteria andBrokerIdBetween(Integer value1, Integer value2) {
			addCriterion("BROKER_ID between", value1, value2, "brokerId");
			return (Criteria) this;
		}

		public Criteria andBrokerIdNotBetween(Integer value1, Integer value2) {
			addCriterion("BROKER_ID not between", value1, value2, "brokerId");
			return (Criteria) this;
		}

		public Criteria andExamIdIsNull() {
			addCriterion("EXAM_ID is null");
			return (Criteria) this;
		}

		public Criteria andExamIdIsNotNull() {
			addCriterion("EXAM_ID is not null");
			return (Criteria) this;
		}

		public Criteria andExamIdEqualTo(Integer value) {
			addCriterion("EXAM_ID =", value, "examId");
			return (Criteria) this;
		}

		public Criteria andExamIdNotEqualTo(Integer value) {
			addCriterion("EXAM_ID <>", value, "examId");
			return (Criteria) this;
		}

		public Criteria andExamIdGreaterThan(Integer value) {
			addCriterion("EXAM_ID >", value, "examId");
			return (Criteria) this;
		}

		public Criteria andExamIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("EXAM_ID >=", value, "examId");
			return (Criteria) this;
		}

		public Criteria andExamIdLessThan(Integer value) {
			addCriterion("EXAM_ID <", value, "examId");
			return (Criteria) this;
		}

		public Criteria andExamIdLessThanOrEqualTo(Integer value) {
			addCriterion("EXAM_ID <=", value, "examId");
			return (Criteria) this;
		}

		public Criteria andExamIdIn(List<Integer> values) {
			addCriterion("EXAM_ID in", values, "examId");
			return (Criteria) this;
		}

		public Criteria andExamIdNotIn(List<Integer> values) {
			addCriterion("EXAM_ID not in", values, "examId");
			return (Criteria) this;
		}

		public Criteria andExamIdBetween(Integer value1, Integer value2) {
			addCriterion("EXAM_ID between", value1, value2, "examId");
			return (Criteria) this;
		}

		public Criteria andExamIdNotBetween(Integer value1, Integer value2) {
			addCriterion("EXAM_ID not between", value1, value2, "examId");
			return (Criteria) this;
		}

		public Criteria andExamNameIsNull() {
			addCriterion("EXAM_NAME is null");
			return (Criteria) this;
		}

		public Criteria andExamNameIsNotNull() {
			addCriterion("EXAM_NAME is not null");
			return (Criteria) this;
		}

		public Criteria andExamNameEqualTo(String value) {
			addCriterion("EXAM_NAME =", value, "examName");
			return (Criteria) this;
		}

		public Criteria andExamNameNotEqualTo(String value) {
			addCriterion("EXAM_NAME <>", value, "examName");
			return (Criteria) this;
		}

		public Criteria andExamNameGreaterThan(String value) {
			addCriterion("EXAM_NAME >", value, "examName");
			return (Criteria) this;
		}

		public Criteria andExamNameGreaterThanOrEqualTo(String value) {
			addCriterion("EXAM_NAME >=", value, "examName");
			return (Criteria) this;
		}

		public Criteria andExamNameLessThan(String value) {
			addCriterion("EXAM_NAME <", value, "examName");
			return (Criteria) this;
		}

		public Criteria andExamNameLessThanOrEqualTo(String value) {
			addCriterion("EXAM_NAME <=", value, "examName");
			return (Criteria) this;
		}

		public Criteria andExamNameLike(String value) {
			addCriterion("EXAM_NAME like", value, "examName");
			return (Criteria) this;
		}

		public Criteria andExamNameNotLike(String value) {
			addCriterion("EXAM_NAME not like", value, "examName");
			return (Criteria) this;
		}

		public Criteria andExamNameIn(List<String> values) {
			addCriterion("EXAM_NAME in", values, "examName");
			return (Criteria) this;
		}

		public Criteria andExamNameNotIn(List<String> values) {
			addCriterion("EXAM_NAME not in", values, "examName");
			return (Criteria) this;
		}

		public Criteria andExamNameBetween(String value1, String value2) {
			addCriterion("EXAM_NAME between", value1, value2, "examName");
			return (Criteria) this;
		}

		public Criteria andExamNameNotBetween(String value1, String value2) {
			addCriterion("EXAM_NAME not between", value1, value2, "examName");
			return (Criteria) this;
		}

		public Criteria andExamResultIsNull() {
			addCriterion("EXAM_RESULT is null");
			return (Criteria) this;
		}

		public Criteria andExamResultIsNotNull() {
			addCriterion("EXAM_RESULT is not null");
			return (Criteria) this;
		}

		public Criteria andExamResultEqualTo(Integer value) {
			addCriterion("EXAM_RESULT =", value, "examResult");
			return (Criteria) this;
		}

		public Criteria andExamResultNotEqualTo(Integer value) {
			addCriterion("EXAM_RESULT <>", value, "examResult");
			return (Criteria) this;
		}

		public Criteria andExamResultGreaterThan(Integer value) {
			addCriterion("EXAM_RESULT >", value, "examResult");
			return (Criteria) this;
		}

		public Criteria andExamResultGreaterThanOrEqualTo(Integer value) {
			addCriterion("EXAM_RESULT >=", value, "examResult");
			return (Criteria) this;
		}

		public Criteria andExamResultLessThan(Integer value) {
			addCriterion("EXAM_RESULT <", value, "examResult");
			return (Criteria) this;
		}

		public Criteria andExamResultLessThanOrEqualTo(Integer value) {
			addCriterion("EXAM_RESULT <=", value, "examResult");
			return (Criteria) this;
		}

		public Criteria andExamResultIn(List<Integer> values) {
			addCriterion("EXAM_RESULT in", values, "examResult");
			return (Criteria) this;
		}

		public Criteria andExamResultNotIn(List<Integer> values) {
			addCriterion("EXAM_RESULT not in", values, "examResult");
			return (Criteria) this;
		}

		public Criteria andExamResultBetween(Integer value1, Integer value2) {
			addCriterion("EXAM_RESULT between", value1, value2, "examResult");
			return (Criteria) this;
		}

		public Criteria andExamResultNotBetween(Integer value1, Integer value2) {
			addCriterion("EXAM_RESULT not between", value1, value2, "examResult");
			return (Criteria) this;
		}

		public Criteria andUserScoreIsNull() {
			addCriterion("USER_SCORE is null");
			return (Criteria) this;
		}

		public Criteria andUserScoreIsNotNull() {
			addCriterion("USER_SCORE is not null");
			return (Criteria) this;
		}

		public Criteria andUserScoreEqualTo(BigDecimal value) {
			addCriterion("USER_SCORE =", value, "userScore");
			return (Criteria) this;
		}

		public Criteria andUserScoreNotEqualTo(BigDecimal value) {
			addCriterion("USER_SCORE <>", value, "userScore");
			return (Criteria) this;
		}

		public Criteria andUserScoreGreaterThan(BigDecimal value) {
			addCriterion("USER_SCORE >", value, "userScore");
			return (Criteria) this;
		}

		public Criteria andUserScoreGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("USER_SCORE >=", value, "userScore");
			return (Criteria) this;
		}

		public Criteria andUserScoreLessThan(BigDecimal value) {
			addCriterion("USER_SCORE <", value, "userScore");
			return (Criteria) this;
		}

		public Criteria andUserScoreLessThanOrEqualTo(BigDecimal value) {
			addCriterion("USER_SCORE <=", value, "userScore");
			return (Criteria) this;
		}

		public Criteria andUserScoreIn(List<BigDecimal> values) {
			addCriterion("USER_SCORE in", values, "userScore");
			return (Criteria) this;
		}

		public Criteria andUserScoreNotIn(List<BigDecimal> values) {
			addCriterion("USER_SCORE not in", values, "userScore");
			return (Criteria) this;
		}

		public Criteria andUserScoreBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("USER_SCORE between", value1, value2, "userScore");
			return (Criteria) this;
		}

		public Criteria andUserScoreNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("USER_SCORE not between", value1, value2, "userScore");
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

		public Criteria andSubjectIdEqualTo(Integer value) {
			addCriterion("SUBJECT_ID =", value, "subjectId");
			return (Criteria) this;
		}

		public Criteria andSubjectIdNotEqualTo(Integer value) {
			addCriterion("SUBJECT_ID <>", value, "subjectId");
			return (Criteria) this;
		}

		public Criteria andSubjectIdGreaterThan(Integer value) {
			addCriterion("SUBJECT_ID >", value, "subjectId");
			return (Criteria) this;
		}

		public Criteria andSubjectIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("SUBJECT_ID >=", value, "subjectId");
			return (Criteria) this;
		}

		public Criteria andSubjectIdLessThan(Integer value) {
			addCriterion("SUBJECT_ID <", value, "subjectId");
			return (Criteria) this;
		}

		public Criteria andSubjectIdLessThanOrEqualTo(Integer value) {
			addCriterion("SUBJECT_ID <=", value, "subjectId");
			return (Criteria) this;
		}

		public Criteria andSubjectIdIn(List<Integer> values) {
			addCriterion("SUBJECT_ID in", values, "subjectId");
			return (Criteria) this;
		}

		public Criteria andSubjectIdNotIn(List<Integer> values) {
			addCriterion("SUBJECT_ID not in", values, "subjectId");
			return (Criteria) this;
		}

		public Criteria andSubjectIdBetween(Integer value1, Integer value2) {
			addCriterion("SUBJECT_ID between", value1, value2, "subjectId");
			return (Criteria) this;
		}

		public Criteria andSubjectIdNotBetween(Integer value1, Integer value2) {
			addCriterion("SUBJECT_ID not between", value1, value2, "subjectId");
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