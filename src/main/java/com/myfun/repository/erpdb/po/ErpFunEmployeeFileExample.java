package com.myfun.repository.erpdb.po;

import com.myfun.repository.support.generator.shard.ShardDb;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ErpFunEmployeeFileExample extends ShardDb {
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
	public ErpFunEmployeeFileExample() {
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

		public Criteria andEmployeeDocIdIsNull() {
			addCriterion("EMPLOYEE_DOC_ID is null");
			return (Criteria) this;
		}

		public Criteria andEmployeeDocIdIsNotNull() {
			addCriterion("EMPLOYEE_DOC_ID is not null");
			return (Criteria) this;
		}

		public Criteria andEmployeeDocIdEqualTo(Integer value) {
			addCriterion("EMPLOYEE_DOC_ID =", value, "employeeDocId");
			return (Criteria) this;
		}

		public Criteria andEmployeeDocIdNotEqualTo(Integer value) {
			addCriterion("EMPLOYEE_DOC_ID <>", value, "employeeDocId");
			return (Criteria) this;
		}

		public Criteria andEmployeeDocIdGreaterThan(Integer value) {
			addCriterion("EMPLOYEE_DOC_ID >", value, "employeeDocId");
			return (Criteria) this;
		}

		public Criteria andEmployeeDocIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("EMPLOYEE_DOC_ID >=", value, "employeeDocId");
			return (Criteria) this;
		}

		public Criteria andEmployeeDocIdLessThan(Integer value) {
			addCriterion("EMPLOYEE_DOC_ID <", value, "employeeDocId");
			return (Criteria) this;
		}

		public Criteria andEmployeeDocIdLessThanOrEqualTo(Integer value) {
			addCriterion("EMPLOYEE_DOC_ID <=", value, "employeeDocId");
			return (Criteria) this;
		}

		public Criteria andEmployeeDocIdIn(List<Integer> values) {
			addCriterion("EMPLOYEE_DOC_ID in", values, "employeeDocId");
			return (Criteria) this;
		}

		public Criteria andEmployeeDocIdNotIn(List<Integer> values) {
			addCriterion("EMPLOYEE_DOC_ID not in", values, "employeeDocId");
			return (Criteria) this;
		}

		public Criteria andEmployeeDocIdBetween(Integer value1, Integer value2) {
			addCriterion("EMPLOYEE_DOC_ID between", value1, value2, "employeeDocId");
			return (Criteria) this;
		}

		public Criteria andEmployeeDocIdNotBetween(Integer value1, Integer value2) {
			addCriterion("EMPLOYEE_DOC_ID not between", value1, value2, "employeeDocId");
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

		public Criteria andFileTypeIsNull() {
			addCriterion("FILE_TYPE is null");
			return (Criteria) this;
		}

		public Criteria andFileTypeIsNotNull() {
			addCriterion("FILE_TYPE is not null");
			return (Criteria) this;
		}

		public Criteria andFileTypeEqualTo(Byte value) {
			addCriterion("FILE_TYPE =", value, "fileType");
			return (Criteria) this;
		}

		public Criteria andFileTypeNotEqualTo(Byte value) {
			addCriterion("FILE_TYPE <>", value, "fileType");
			return (Criteria) this;
		}

		public Criteria andFileTypeGreaterThan(Byte value) {
			addCriterion("FILE_TYPE >", value, "fileType");
			return (Criteria) this;
		}

		public Criteria andFileTypeGreaterThanOrEqualTo(Byte value) {
			addCriterion("FILE_TYPE >=", value, "fileType");
			return (Criteria) this;
		}

		public Criteria andFileTypeLessThan(Byte value) {
			addCriterion("FILE_TYPE <", value, "fileType");
			return (Criteria) this;
		}

		public Criteria andFileTypeLessThanOrEqualTo(Byte value) {
			addCriterion("FILE_TYPE <=", value, "fileType");
			return (Criteria) this;
		}

		public Criteria andFileTypeIn(List<Byte> values) {
			addCriterion("FILE_TYPE in", values, "fileType");
			return (Criteria) this;
		}

		public Criteria andFileTypeNotIn(List<Byte> values) {
			addCriterion("FILE_TYPE not in", values, "fileType");
			return (Criteria) this;
		}

		public Criteria andFileTypeBetween(Byte value1, Byte value2) {
			addCriterion("FILE_TYPE between", value1, value2, "fileType");
			return (Criteria) this;
		}

		public Criteria andFileTypeNotBetween(Byte value1, Byte value2) {
			addCriterion("FILE_TYPE not between", value1, value2, "fileType");
			return (Criteria) this;
		}

		public Criteria andFileUrlIsNull() {
			addCriterion("FILE_URL is null");
			return (Criteria) this;
		}

		public Criteria andFileUrlIsNotNull() {
			addCriterion("FILE_URL is not null");
			return (Criteria) this;
		}

		public Criteria andFileUrlEqualTo(String value) {
			addCriterion("FILE_URL =", value, "fileUrl");
			return (Criteria) this;
		}

		public Criteria andFileUrlNotEqualTo(String value) {
			addCriterion("FILE_URL <>", value, "fileUrl");
			return (Criteria) this;
		}

		public Criteria andFileUrlGreaterThan(String value) {
			addCriterion("FILE_URL >", value, "fileUrl");
			return (Criteria) this;
		}

		public Criteria andFileUrlGreaterThanOrEqualTo(String value) {
			addCriterion("FILE_URL >=", value, "fileUrl");
			return (Criteria) this;
		}

		public Criteria andFileUrlLessThan(String value) {
			addCriterion("FILE_URL <", value, "fileUrl");
			return (Criteria) this;
		}

		public Criteria andFileUrlLessThanOrEqualTo(String value) {
			addCriterion("FILE_URL <=", value, "fileUrl");
			return (Criteria) this;
		}

		public Criteria andFileUrlLike(String value) {
			addCriterion("FILE_URL like", value, "fileUrl");
			return (Criteria) this;
		}

		public Criteria andFileUrlNotLike(String value) {
			addCriterion("FILE_URL not like", value, "fileUrl");
			return (Criteria) this;
		}

		public Criteria andFileUrlIn(List<String> values) {
			addCriterion("FILE_URL in", values, "fileUrl");
			return (Criteria) this;
		}

		public Criteria andFileUrlNotIn(List<String> values) {
			addCriterion("FILE_URL not in", values, "fileUrl");
			return (Criteria) this;
		}

		public Criteria andFileUrlBetween(String value1, String value2) {
			addCriterion("FILE_URL between", value1, value2, "fileUrl");
			return (Criteria) this;
		}

		public Criteria andFileUrlNotBetween(String value1, String value2) {
			addCriterion("FILE_URL not between", value1, value2, "fileUrl");
			return (Criteria) this;
		}

		public Criteria andFileStatusIsNull() {
			addCriterion("FILE_STATUS is null");
			return (Criteria) this;
		}

		public Criteria andFileStatusIsNotNull() {
			addCriterion("FILE_STATUS is not null");
			return (Criteria) this;
		}

		public Criteria andFileStatusEqualTo(Byte value) {
			addCriterion("FILE_STATUS =", value, "fileStatus");
			return (Criteria) this;
		}

		public Criteria andFileStatusNotEqualTo(Byte value) {
			addCriterion("FILE_STATUS <>", value, "fileStatus");
			return (Criteria) this;
		}

		public Criteria andFileStatusGreaterThan(Byte value) {
			addCriterion("FILE_STATUS >", value, "fileStatus");
			return (Criteria) this;
		}

		public Criteria andFileStatusGreaterThanOrEqualTo(Byte value) {
			addCriterion("FILE_STATUS >=", value, "fileStatus");
			return (Criteria) this;
		}

		public Criteria andFileStatusLessThan(Byte value) {
			addCriterion("FILE_STATUS <", value, "fileStatus");
			return (Criteria) this;
		}

		public Criteria andFileStatusLessThanOrEqualTo(Byte value) {
			addCriterion("FILE_STATUS <=", value, "fileStatus");
			return (Criteria) this;
		}

		public Criteria andFileStatusIn(List<Byte> values) {
			addCriterion("FILE_STATUS in", values, "fileStatus");
			return (Criteria) this;
		}

		public Criteria andFileStatusNotIn(List<Byte> values) {
			addCriterion("FILE_STATUS not in", values, "fileStatus");
			return (Criteria) this;
		}

		public Criteria andFileStatusBetween(Byte value1, Byte value2) {
			addCriterion("FILE_STATUS between", value1, value2, "fileStatus");
			return (Criteria) this;
		}

		public Criteria andFileStatusNotBetween(Byte value1, Byte value2) {
			addCriterion("FILE_STATUS not between", value1, value2, "fileStatus");
			return (Criteria) this;
		}

		public Criteria andCreatorUidIsNull() {
			addCriterion("CREATOR_UID is null");
			return (Criteria) this;
		}

		public Criteria andCreatorUidIsNotNull() {
			addCriterion("CREATOR_UID is not null");
			return (Criteria) this;
		}

		public Criteria andCreatorUidEqualTo(Integer value) {
			addCriterion("CREATOR_UID =", value, "creatorUid");
			return (Criteria) this;
		}

		public Criteria andCreatorUidNotEqualTo(Integer value) {
			addCriterion("CREATOR_UID <>", value, "creatorUid");
			return (Criteria) this;
		}

		public Criteria andCreatorUidGreaterThan(Integer value) {
			addCriterion("CREATOR_UID >", value, "creatorUid");
			return (Criteria) this;
		}

		public Criteria andCreatorUidGreaterThanOrEqualTo(Integer value) {
			addCriterion("CREATOR_UID >=", value, "creatorUid");
			return (Criteria) this;
		}

		public Criteria andCreatorUidLessThan(Integer value) {
			addCriterion("CREATOR_UID <", value, "creatorUid");
			return (Criteria) this;
		}

		public Criteria andCreatorUidLessThanOrEqualTo(Integer value) {
			addCriterion("CREATOR_UID <=", value, "creatorUid");
			return (Criteria) this;
		}

		public Criteria andCreatorUidIn(List<Integer> values) {
			addCriterion("CREATOR_UID in", values, "creatorUid");
			return (Criteria) this;
		}

		public Criteria andCreatorUidNotIn(List<Integer> values) {
			addCriterion("CREATOR_UID not in", values, "creatorUid");
			return (Criteria) this;
		}

		public Criteria andCreatorUidBetween(Integer value1, Integer value2) {
			addCriterion("CREATOR_UID between", value1, value2, "creatorUid");
			return (Criteria) this;
		}

		public Criteria andCreatorUidNotBetween(Integer value1, Integer value2) {
			addCriterion("CREATOR_UID not between", value1, value2, "creatorUid");
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