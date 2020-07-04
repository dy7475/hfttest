package com.myfun.repository.erpdb.po;

import com.myfun.repository.support.generator.shard.ShardDb;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ErpRenovationCustomerFileExample extends ShardDb {
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
	public ErpRenovationCustomerFileExample() {
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

		public Criteria andFileTypeIsNull() {
			addCriterion("FILE_TYPE is null");
			return (Criteria) this;
		}

		public Criteria andFileTypeIsNotNull() {
			addCriterion("FILE_TYPE is not null");
			return (Criteria) this;
		}

		public Criteria andFileTypeEqualTo(Integer value) {
			addCriterion("FILE_TYPE =", value, "fileType");
			return (Criteria) this;
		}

		public Criteria andFileTypeNotEqualTo(Integer value) {
			addCriterion("FILE_TYPE <>", value, "fileType");
			return (Criteria) this;
		}

		public Criteria andFileTypeGreaterThan(Integer value) {
			addCriterion("FILE_TYPE >", value, "fileType");
			return (Criteria) this;
		}

		public Criteria andFileTypeGreaterThanOrEqualTo(Integer value) {
			addCriterion("FILE_TYPE >=", value, "fileType");
			return (Criteria) this;
		}

		public Criteria andFileTypeLessThan(Integer value) {
			addCriterion("FILE_TYPE <", value, "fileType");
			return (Criteria) this;
		}

		public Criteria andFileTypeLessThanOrEqualTo(Integer value) {
			addCriterion("FILE_TYPE <=", value, "fileType");
			return (Criteria) this;
		}

		public Criteria andFileTypeIn(List<Integer> values) {
			addCriterion("FILE_TYPE in", values, "fileType");
			return (Criteria) this;
		}

		public Criteria andFileTypeNotIn(List<Integer> values) {
			addCriterion("FILE_TYPE not in", values, "fileType");
			return (Criteria) this;
		}

		public Criteria andFileTypeBetween(Integer value1, Integer value2) {
			addCriterion("FILE_TYPE between", value1, value2, "fileType");
			return (Criteria) this;
		}

		public Criteria andFileTypeNotBetween(Integer value1, Integer value2) {
			addCriterion("FILE_TYPE not between", value1, value2, "fileType");
			return (Criteria) this;
		}

		public Criteria andFileAddrIsNull() {
			addCriterion("FILE_ADDR is null");
			return (Criteria) this;
		}

		public Criteria andFileAddrIsNotNull() {
			addCriterion("FILE_ADDR is not null");
			return (Criteria) this;
		}

		public Criteria andFileAddrEqualTo(String value) {
			addCriterion("FILE_ADDR =", value, "fileAddr");
			return (Criteria) this;
		}

		public Criteria andFileAddrNotEqualTo(String value) {
			addCriterion("FILE_ADDR <>", value, "fileAddr");
			return (Criteria) this;
		}

		public Criteria andFileAddrGreaterThan(String value) {
			addCriterion("FILE_ADDR >", value, "fileAddr");
			return (Criteria) this;
		}

		public Criteria andFileAddrGreaterThanOrEqualTo(String value) {
			addCriterion("FILE_ADDR >=", value, "fileAddr");
			return (Criteria) this;
		}

		public Criteria andFileAddrLessThan(String value) {
			addCriterion("FILE_ADDR <", value, "fileAddr");
			return (Criteria) this;
		}

		public Criteria andFileAddrLessThanOrEqualTo(String value) {
			addCriterion("FILE_ADDR <=", value, "fileAddr");
			return (Criteria) this;
		}

		public Criteria andFileAddrLike(String value) {
			addCriterion("FILE_ADDR like", value, "fileAddr");
			return (Criteria) this;
		}

		public Criteria andFileAddrNotLike(String value) {
			addCriterion("FILE_ADDR not like", value, "fileAddr");
			return (Criteria) this;
		}

		public Criteria andFileAddrIn(List<String> values) {
			addCriterion("FILE_ADDR in", values, "fileAddr");
			return (Criteria) this;
		}

		public Criteria andFileAddrNotIn(List<String> values) {
			addCriterion("FILE_ADDR not in", values, "fileAddr");
			return (Criteria) this;
		}

		public Criteria andFileAddrBetween(String value1, String value2) {
			addCriterion("FILE_ADDR between", value1, value2, "fileAddr");
			return (Criteria) this;
		}

		public Criteria andFileAddrNotBetween(String value1, String value2) {
			addCriterion("FILE_ADDR not between", value1, value2, "fileAddr");
			return (Criteria) this;
		}

		public Criteria andRenovationCustomerIdIsNull() {
			addCriterion("RENOVATION_CUSTOMER_ID is null");
			return (Criteria) this;
		}

		public Criteria andRenovationCustomerIdIsNotNull() {
			addCriterion("RENOVATION_CUSTOMER_ID is not null");
			return (Criteria) this;
		}

		public Criteria andRenovationCustomerIdEqualTo(Integer value) {
			addCriterion("RENOVATION_CUSTOMER_ID =", value, "renovationCustomerId");
			return (Criteria) this;
		}

		public Criteria andRenovationCustomerIdNotEqualTo(Integer value) {
			addCriterion("RENOVATION_CUSTOMER_ID <>", value, "renovationCustomerId");
			return (Criteria) this;
		}

		public Criteria andRenovationCustomerIdGreaterThan(Integer value) {
			addCriterion("RENOVATION_CUSTOMER_ID >", value, "renovationCustomerId");
			return (Criteria) this;
		}

		public Criteria andRenovationCustomerIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("RENOVATION_CUSTOMER_ID >=", value, "renovationCustomerId");
			return (Criteria) this;
		}

		public Criteria andRenovationCustomerIdLessThan(Integer value) {
			addCriterion("RENOVATION_CUSTOMER_ID <", value, "renovationCustomerId");
			return (Criteria) this;
		}

		public Criteria andRenovationCustomerIdLessThanOrEqualTo(Integer value) {
			addCriterion("RENOVATION_CUSTOMER_ID <=", value, "renovationCustomerId");
			return (Criteria) this;
		}

		public Criteria andRenovationCustomerIdIn(List<Integer> values) {
			addCriterion("RENOVATION_CUSTOMER_ID in", values, "renovationCustomerId");
			return (Criteria) this;
		}

		public Criteria andRenovationCustomerIdNotIn(List<Integer> values) {
			addCriterion("RENOVATION_CUSTOMER_ID not in", values, "renovationCustomerId");
			return (Criteria) this;
		}

		public Criteria andRenovationCustomerIdBetween(Integer value1, Integer value2) {
			addCriterion("RENOVATION_CUSTOMER_ID between", value1, value2, "renovationCustomerId");
			return (Criteria) this;
		}

		public Criteria andRenovationCustomerIdNotBetween(Integer value1, Integer value2) {
			addCriterion("RENOVATION_CUSTOMER_ID not between", value1, value2, "renovationCustomerId");
			return (Criteria) this;
		}

		public Criteria andUploadUserIsNull() {
			addCriterion("UPLOAD_USER is null");
			return (Criteria) this;
		}

		public Criteria andUploadUserIsNotNull() {
			addCriterion("UPLOAD_USER is not null");
			return (Criteria) this;
		}

		public Criteria andUploadUserEqualTo(Integer value) {
			addCriterion("UPLOAD_USER =", value, "uploadUser");
			return (Criteria) this;
		}

		public Criteria andUploadUserNotEqualTo(Integer value) {
			addCriterion("UPLOAD_USER <>", value, "uploadUser");
			return (Criteria) this;
		}

		public Criteria andUploadUserGreaterThan(Integer value) {
			addCriterion("UPLOAD_USER >", value, "uploadUser");
			return (Criteria) this;
		}

		public Criteria andUploadUserGreaterThanOrEqualTo(Integer value) {
			addCriterion("UPLOAD_USER >=", value, "uploadUser");
			return (Criteria) this;
		}

		public Criteria andUploadUserLessThan(Integer value) {
			addCriterion("UPLOAD_USER <", value, "uploadUser");
			return (Criteria) this;
		}

		public Criteria andUploadUserLessThanOrEqualTo(Integer value) {
			addCriterion("UPLOAD_USER <=", value, "uploadUser");
			return (Criteria) this;
		}

		public Criteria andUploadUserIn(List<Integer> values) {
			addCriterion("UPLOAD_USER in", values, "uploadUser");
			return (Criteria) this;
		}

		public Criteria andUploadUserNotIn(List<Integer> values) {
			addCriterion("UPLOAD_USER not in", values, "uploadUser");
			return (Criteria) this;
		}

		public Criteria andUploadUserBetween(Integer value1, Integer value2) {
			addCriterion("UPLOAD_USER between", value1, value2, "uploadUser");
			return (Criteria) this;
		}

		public Criteria andUploadUserNotBetween(Integer value1, Integer value2) {
			addCriterion("UPLOAD_USER not between", value1, value2, "uploadUser");
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

		public Criteria andIsDelIsNull() {
			addCriterion("IS_DEL is null");
			return (Criteria) this;
		}

		public Criteria andIsDelIsNotNull() {
			addCriterion("IS_DEL is not null");
			return (Criteria) this;
		}

		public Criteria andIsDelEqualTo(Integer value) {
			addCriterion("IS_DEL =", value, "isDel");
			return (Criteria) this;
		}

		public Criteria andIsDelNotEqualTo(Integer value) {
			addCriterion("IS_DEL <>", value, "isDel");
			return (Criteria) this;
		}

		public Criteria andIsDelGreaterThan(Integer value) {
			addCriterion("IS_DEL >", value, "isDel");
			return (Criteria) this;
		}

		public Criteria andIsDelGreaterThanOrEqualTo(Integer value) {
			addCriterion("IS_DEL >=", value, "isDel");
			return (Criteria) this;
		}

		public Criteria andIsDelLessThan(Integer value) {
			addCriterion("IS_DEL <", value, "isDel");
			return (Criteria) this;
		}

		public Criteria andIsDelLessThanOrEqualTo(Integer value) {
			addCriterion("IS_DEL <=", value, "isDel");
			return (Criteria) this;
		}

		public Criteria andIsDelIn(List<Integer> values) {
			addCriterion("IS_DEL in", values, "isDel");
			return (Criteria) this;
		}

		public Criteria andIsDelNotIn(List<Integer> values) {
			addCriterion("IS_DEL not in", values, "isDel");
			return (Criteria) this;
		}

		public Criteria andIsDelBetween(Integer value1, Integer value2) {
			addCriterion("IS_DEL between", value1, value2, "isDel");
			return (Criteria) this;
		}

		public Criteria andIsDelNotBetween(Integer value1, Integer value2) {
			addCriterion("IS_DEL not between", value1, value2, "isDel");
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