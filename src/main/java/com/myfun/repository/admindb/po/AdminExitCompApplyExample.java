package com.myfun.repository.admindb.po;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AdminExitCompApplyExample {
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
	 */protected List<Criteria> oredCriteria;

	/**
	 * @mbggenerated
	 */public AdminExitCompApplyExample(){oredCriteria=new ArrayList<Criteria>();}

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
	 */public List<Criteria> getOredCriteria(){return oredCriteria;}

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
	 */protected abstract static class GeneratedCriteria {protected List<Criterion> criteria;protected GeneratedCriteria(){super();criteria=new ArrayList<Criterion>();}public boolean isValid(){return criteria.size() > 0;}public List<Criterion> getAllCriteria(){return criteria;}public List<Criterion> getCriteria(){return criteria;}protected void addCriterion(String condition){if (condition == null){throw new RuntimeException("Value for condition cannot be null");}criteria.add(new Criterion(condition));}protected void addCriterion(String condition,Object value,String property){if (value == null){throw new RuntimeException("Value for " + property + " cannot be null");}criteria.add(new Criterion(condition,value));}protected void addCriterion(String condition,Object value1,Object value2,String property){if (value1 == null || value2 == null){throw new RuntimeException("Between values for " + property + " cannot be null");}criteria.add(new Criterion(condition,value1,value2));}public Criteria andIdIsNull(){addCriterion("ID is null");return (Criteria)this;}public Criteria andIdIsNotNull(){addCriterion("ID is not null");return (Criteria)this;}public Criteria andIdEqualTo(Integer value){addCriterion("ID =",value,"id");return (Criteria)this;}public Criteria andIdNotEqualTo(Integer value){addCriterion("ID <>",value,"id");return (Criteria)this;}public Criteria andIdGreaterThan(Integer value){addCriterion("ID >",value,"id");return (Criteria)this;}public Criteria andIdGreaterThanOrEqualTo(Integer value){addCriterion("ID >=",value,"id");return (Criteria)this;}public Criteria andIdLessThan(Integer value){addCriterion("ID <",value,"id");return (Criteria)this;}public Criteria andIdLessThanOrEqualTo(Integer value){addCriterion("ID <=",value,"id");return (Criteria)this;}public Criteria andIdIn(List<Integer> values){addCriterion("ID in",values,"id");return (Criteria)this;}public Criteria andIdNotIn(List<Integer> values){addCriterion("ID not in",values,"id");return (Criteria)this;}public Criteria andIdBetween(Integer value1,Integer value2){addCriterion("ID between",value1,value2,"id");return (Criteria)this;}public Criteria andIdNotBetween(Integer value1,Integer value2){addCriterion("ID not between",value1,value2,"id");return (Criteria)this;}public Criteria andCityIdIsNull(){addCriterion("CITY_ID is null");return (Criteria)this;}public Criteria andCityIdIsNotNull(){addCriterion("CITY_ID is not null");return (Criteria)this;}public Criteria andCityIdEqualTo(Integer value){addCriterion("CITY_ID =",value,"cityId");return (Criteria)this;}public Criteria andCityIdNotEqualTo(Integer value){addCriterion("CITY_ID <>",value,"cityId");return (Criteria)this;}public Criteria andCityIdGreaterThan(Integer value){addCriterion("CITY_ID >",value,"cityId");return (Criteria)this;}public Criteria andCityIdGreaterThanOrEqualTo(Integer value){addCriterion("CITY_ID >=",value,"cityId");return (Criteria)this;}public Criteria andCityIdLessThan(Integer value){addCriterion("CITY_ID <",value,"cityId");return (Criteria)this;}public Criteria andCityIdLessThanOrEqualTo(Integer value){addCriterion("CITY_ID <=",value,"cityId");return (Criteria)this;}public Criteria andCityIdIn(List<Integer> values){addCriterion("CITY_ID in",values,"cityId");return (Criteria)this;}public Criteria andCityIdNotIn(List<Integer> values){addCriterion("CITY_ID not in",values,"cityId");return (Criteria)this;}public Criteria andCityIdBetween(Integer value1,Integer value2){addCriterion("CITY_ID between",value1,value2,"cityId");return (Criteria)this;}public Criteria andCityIdNotBetween(Integer value1,Integer value2){addCriterion("CITY_ID not between",value1,value2,"cityId");return (Criteria)this;}public Criteria andCompIdIsNull(){addCriterion("COMP_ID is null");return (Criteria)this;}public Criteria andCompIdIsNotNull(){addCriterion("COMP_ID is not null");return (Criteria)this;}public Criteria andCompIdEqualTo(Integer value){addCriterion("COMP_ID =",value,"compId");return (Criteria)this;}public Criteria andCompIdNotEqualTo(Integer value){addCriterion("COMP_ID <>",value,"compId");return (Criteria)this;}public Criteria andCompIdGreaterThan(Integer value){addCriterion("COMP_ID >",value,"compId");return (Criteria)this;}public Criteria andCompIdGreaterThanOrEqualTo(Integer value){addCriterion("COMP_ID >=",value,"compId");return (Criteria)this;}public Criteria andCompIdLessThan(Integer value){addCriterion("COMP_ID <",value,"compId");return (Criteria)this;}public Criteria andCompIdLessThanOrEqualTo(Integer value){addCriterion("COMP_ID <=",value,"compId");return (Criteria)this;}public Criteria andCompIdIn(List<Integer> values){addCriterion("COMP_ID in",values,"compId");return (Criteria)this;}public Criteria andCompIdNotIn(List<Integer> values){addCriterion("COMP_ID not in",values,"compId");return (Criteria)this;}public Criteria andCompIdBetween(Integer value1,Integer value2){addCriterion("COMP_ID between",value1,value2,"compId");return (Criteria)this;}public Criteria andCompIdNotBetween(Integer value1,Integer value2){addCriterion("COMP_ID not between",value1,value2,"compId");return (Criteria)this;}public Criteria andArchiveIdIsNull(){addCriterion("ARCHIVE_ID is null");return (Criteria)this;}public Criteria andArchiveIdIsNotNull(){addCriterion("ARCHIVE_ID is not null");return (Criteria)this;}public Criteria andArchiveIdEqualTo(Integer value){addCriterion("ARCHIVE_ID =",value,"archiveId");return (Criteria)this;}public Criteria andArchiveIdNotEqualTo(Integer value){addCriterion("ARCHIVE_ID <>",value,"archiveId");return (Criteria)this;}public Criteria andArchiveIdGreaterThan(Integer value){addCriterion("ARCHIVE_ID >",value,"archiveId");return (Criteria)this;}public Criteria andArchiveIdGreaterThanOrEqualTo(Integer value){addCriterion("ARCHIVE_ID >=",value,"archiveId");return (Criteria)this;}public Criteria andArchiveIdLessThan(Integer value){addCriterion("ARCHIVE_ID <",value,"archiveId");return (Criteria)this;}public Criteria andArchiveIdLessThanOrEqualTo(Integer value){addCriterion("ARCHIVE_ID <=",value,"archiveId");return (Criteria)this;}public Criteria andArchiveIdIn(List<Integer> values){addCriterion("ARCHIVE_ID in",values,"archiveId");return (Criteria)this;}public Criteria andArchiveIdNotIn(List<Integer> values){addCriterion("ARCHIVE_ID not in",values,"archiveId");return (Criteria)this;}public Criteria andArchiveIdBetween(Integer value1,Integer value2){addCriterion("ARCHIVE_ID between",value1,value2,"archiveId");return (Criteria)this;}public Criteria andArchiveIdNotBetween(Integer value1,Integer value2){addCriterion("ARCHIVE_ID not between",value1,value2,"archiveId");return (Criteria)this;}public Criteria andUserIdIsNull(){addCriterion("USER_ID is null");return (Criteria)this;}public Criteria andUserIdIsNotNull(){addCriterion("USER_ID is not null");return (Criteria)this;}public Criteria andUserIdEqualTo(Integer value){addCriterion("USER_ID =",value,"userId");return (Criteria)this;}public Criteria andUserIdNotEqualTo(Integer value){addCriterion("USER_ID <>",value,"userId");return (Criteria)this;}public Criteria andUserIdGreaterThan(Integer value){addCriterion("USER_ID >",value,"userId");return (Criteria)this;}public Criteria andUserIdGreaterThanOrEqualTo(Integer value){addCriterion("USER_ID >=",value,"userId");return (Criteria)this;}public Criteria andUserIdLessThan(Integer value){addCriterion("USER_ID <",value,"userId");return (Criteria)this;}public Criteria andUserIdLessThanOrEqualTo(Integer value){addCriterion("USER_ID <=",value,"userId");return (Criteria)this;}public Criteria andUserIdIn(List<Integer> values){addCriterion("USER_ID in",values,"userId");return (Criteria)this;}public Criteria andUserIdNotIn(List<Integer> values){addCriterion("USER_ID not in",values,"userId");return (Criteria)this;}public Criteria andUserIdBetween(Integer value1,Integer value2){addCriterion("USER_ID between",value1,value2,"userId");return (Criteria)this;}public Criteria andUserIdNotBetween(Integer value1,Integer value2){addCriterion("USER_ID not between",value1,value2,"userId");return (Criteria)this;}public Criteria andEcardAddrIsNull(){addCriterion("ECARD_ADDR is null");return (Criteria)this;}public Criteria andEcardAddrIsNotNull(){addCriterion("ECARD_ADDR is not null");return (Criteria)this;}public Criteria andEcardAddrEqualTo(String value){addCriterion("ECARD_ADDR =",value,"ecardAddr");return (Criteria)this;}public Criteria andEcardAddrNotEqualTo(String value){addCriterion("ECARD_ADDR <>",value,"ecardAddr");return (Criteria)this;}public Criteria andEcardAddrGreaterThan(String value){addCriterion("ECARD_ADDR >",value,"ecardAddr");return (Criteria)this;}public Criteria andEcardAddrGreaterThanOrEqualTo(String value){addCriterion("ECARD_ADDR >=",value,"ecardAddr");return (Criteria)this;}public Criteria andEcardAddrLessThan(String value){addCriterion("ECARD_ADDR <",value,"ecardAddr");return (Criteria)this;}public Criteria andEcardAddrLessThanOrEqualTo(String value){addCriterion("ECARD_ADDR <=",value,"ecardAddr");return (Criteria)this;}public Criteria andEcardAddrLike(String value){addCriterion("ECARD_ADDR like",value,"ecardAddr");return (Criteria)this;}public Criteria andEcardAddrNotLike(String value){addCriterion("ECARD_ADDR not like",value,"ecardAddr");return (Criteria)this;}public Criteria andEcardAddrIn(List<String> values){addCriterion("ECARD_ADDR in",values,"ecardAddr");return (Criteria)this;}public Criteria andEcardAddrNotIn(List<String> values){addCriterion("ECARD_ADDR not in",values,"ecardAddr");return (Criteria)this;}public Criteria andEcardAddrBetween(String value1,String value2){addCriterion("ECARD_ADDR between",value1,value2,"ecardAddr");return (Criteria)this;}public Criteria andEcardAddrNotBetween(String value1,String value2){addCriterion("ECARD_ADDR not between",value1,value2,"ecardAddr");return (Criteria)this;}public Criteria andCreationTimeIsNull(){addCriterion("CREATION_TIME is null");return (Criteria)this;}public Criteria andCreationTimeIsNotNull(){addCriterion("CREATION_TIME is not null");return (Criteria)this;}public Criteria andCreationTimeEqualTo(Date value){addCriterion("CREATION_TIME =",value,"creationTime");return (Criteria)this;}public Criteria andCreationTimeNotEqualTo(Date value){addCriterion("CREATION_TIME <>",value,"creationTime");return (Criteria)this;}public Criteria andCreationTimeGreaterThan(Date value){addCriterion("CREATION_TIME >",value,"creationTime");return (Criteria)this;}public Criteria andCreationTimeGreaterThanOrEqualTo(Date value){addCriterion("CREATION_TIME >=",value,"creationTime");return (Criteria)this;}public Criteria andCreationTimeLessThan(Date value){addCriterion("CREATION_TIME <",value,"creationTime");return (Criteria)this;}public Criteria andCreationTimeLessThanOrEqualTo(Date value){addCriterion("CREATION_TIME <=",value,"creationTime");return (Criteria)this;}public Criteria andCreationTimeIn(List<Date> values){addCriterion("CREATION_TIME in",values,"creationTime");return (Criteria)this;}public Criteria andCreationTimeNotIn(List<Date> values){addCriterion("CREATION_TIME not in",values,"creationTime");return (Criteria)this;}public Criteria andCreationTimeBetween(Date value1,Date value2){addCriterion("CREATION_TIME between",value1,value2,"creationTime");return (Criteria)this;}public Criteria andCreationTimeNotBetween(Date value1,Date value2){addCriterion("CREATION_TIME not between",value1,value2,"creationTime");return (Criteria)this;}public Criteria andUpdateTimeIsNull(){addCriterion("UPDATE_TIME is null");return (Criteria)this;}public Criteria andUpdateTimeIsNotNull(){addCriterion("UPDATE_TIME is not null");return (Criteria)this;}public Criteria andUpdateTimeEqualTo(Date value){addCriterion("UPDATE_TIME =",value,"updateTime");return (Criteria)this;}public Criteria andUpdateTimeNotEqualTo(Date value){addCriterion("UPDATE_TIME <>",value,"updateTime");return (Criteria)this;}public Criteria andUpdateTimeGreaterThan(Date value){addCriterion("UPDATE_TIME >",value,"updateTime");return (Criteria)this;}public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value){addCriterion("UPDATE_TIME >=",value,"updateTime");return (Criteria)this;}public Criteria andUpdateTimeLessThan(Date value){addCriterion("UPDATE_TIME <",value,"updateTime");return (Criteria)this;}public Criteria andUpdateTimeLessThanOrEqualTo(Date value){addCriterion("UPDATE_TIME <=",value,"updateTime");return (Criteria)this;}public Criteria andUpdateTimeIn(List<Date> values){addCriterion("UPDATE_TIME in",values,"updateTime");return (Criteria)this;}public Criteria andUpdateTimeNotIn(List<Date> values){addCriterion("UPDATE_TIME not in",values,"updateTime");return (Criteria)this;}public Criteria andUpdateTimeBetween(Date value1,Date value2){addCriterion("UPDATE_TIME between",value1,value2,"updateTime");return (Criteria)this;}public Criteria andUpdateTimeNotBetween(Date value1,Date value2){addCriterion("UPDATE_TIME not between",value1,value2,"updateTime");return (Criteria)this;}public Criteria andAuditStatusIsNull(){addCriterion("AUDIT_STATUS is null");return (Criteria)this;}public Criteria andAuditStatusIsNotNull(){addCriterion("AUDIT_STATUS is not null");return (Criteria)this;}public Criteria andAuditStatusEqualTo(Integer value){addCriterion("AUDIT_STATUS =",value,"auditStatus");return (Criteria)this;}public Criteria andAuditStatusNotEqualTo(Integer value){addCriterion("AUDIT_STATUS <>",value,"auditStatus");return (Criteria)this;}public Criteria andAuditStatusGreaterThan(Integer value){addCriterion("AUDIT_STATUS >",value,"auditStatus");return (Criteria)this;}public Criteria andAuditStatusGreaterThanOrEqualTo(Integer value){addCriterion("AUDIT_STATUS >=",value,"auditStatus");return (Criteria)this;}public Criteria andAuditStatusLessThan(Integer value){addCriterion("AUDIT_STATUS <",value,"auditStatus");return (Criteria)this;}public Criteria andAuditStatusLessThanOrEqualTo(Integer value){addCriterion("AUDIT_STATUS <=",value,"auditStatus");return (Criteria)this;}public Criteria andAuditStatusIn(List<Integer> values){addCriterion("AUDIT_STATUS in",values,"auditStatus");return (Criteria)this;}public Criteria andAuditStatusNotIn(List<Integer> values){addCriterion("AUDIT_STATUS not in",values,"auditStatus");return (Criteria)this;}public Criteria andAuditStatusBetween(Integer value1,Integer value2){addCriterion("AUDIT_STATUS between",value1,value2,"auditStatus");return (Criteria)this;}public Criteria andAuditStatusNotBetween(Integer value1,Integer value2){addCriterion("AUDIT_STATUS not between",value1,value2,"auditStatus");return (Criteria)this;}public Criteria andExamineIdIsNull(){addCriterion("EXAMINE_ID is null");return (Criteria)this;}public Criteria andExamineIdIsNotNull(){addCriterion("EXAMINE_ID is not null");return (Criteria)this;}public Criteria andExamineIdEqualTo(Integer value){addCriterion("EXAMINE_ID =",value,"examineId");return (Criteria)this;}public Criteria andExamineIdNotEqualTo(Integer value){addCriterion("EXAMINE_ID <>",value,"examineId");return (Criteria)this;}public Criteria andExamineIdGreaterThan(Integer value){addCriterion("EXAMINE_ID >",value,"examineId");return (Criteria)this;}public Criteria andExamineIdGreaterThanOrEqualTo(Integer value){addCriterion("EXAMINE_ID >=",value,"examineId");return (Criteria)this;}public Criteria andExamineIdLessThan(Integer value){addCriterion("EXAMINE_ID <",value,"examineId");return (Criteria)this;}public Criteria andExamineIdLessThanOrEqualTo(Integer value){addCriterion("EXAMINE_ID <=",value,"examineId");return (Criteria)this;}public Criteria andExamineIdIn(List<Integer> values){addCriterion("EXAMINE_ID in",values,"examineId");return (Criteria)this;}public Criteria andExamineIdNotIn(List<Integer> values){addCriterion("EXAMINE_ID not in",values,"examineId");return (Criteria)this;}public Criteria andExamineIdBetween(Integer value1,Integer value2){addCriterion("EXAMINE_ID between",value1,value2,"examineId");return (Criteria)this;}public Criteria andExamineIdNotBetween(Integer value1,Integer value2){addCriterion("EXAMINE_ID not between",value1,value2,"examineId");return (Criteria)this;}public Criteria andExamineTimeIsNull(){addCriterion("EXAMINE_TIME is null");return (Criteria)this;}public Criteria andExamineTimeIsNotNull(){addCriterion("EXAMINE_TIME is not null");return (Criteria)this;}public Criteria andExamineTimeEqualTo(Date value){addCriterion("EXAMINE_TIME =",value,"examineTime");return (Criteria)this;}public Criteria andExamineTimeNotEqualTo(Date value){addCriterion("EXAMINE_TIME <>",value,"examineTime");return (Criteria)this;}public Criteria andExamineTimeGreaterThan(Date value){addCriterion("EXAMINE_TIME >",value,"examineTime");return (Criteria)this;}public Criteria andExamineTimeGreaterThanOrEqualTo(Date value){addCriterion("EXAMINE_TIME >=",value,"examineTime");return (Criteria)this;}public Criteria andExamineTimeLessThan(Date value){addCriterion("EXAMINE_TIME <",value,"examineTime");return (Criteria)this;}public Criteria andExamineTimeLessThanOrEqualTo(Date value){addCriterion("EXAMINE_TIME <=",value,"examineTime");return (Criteria)this;}public Criteria andExamineTimeIn(List<Date> values){addCriterion("EXAMINE_TIME in",values,"examineTime");return (Criteria)this;}public Criteria andExamineTimeNotIn(List<Date> values){addCriterion("EXAMINE_TIME not in",values,"examineTime");return (Criteria)this;}public Criteria andExamineTimeBetween(Date value1,Date value2){addCriterion("EXAMINE_TIME between",value1,value2,"examineTime");return (Criteria)this;}public Criteria andExamineTimeNotBetween(Date value1,Date value2){addCriterion("EXAMINE_TIME not between",value1,value2,"examineTime");return (Criteria)this;}}

	/**
	 * @mbggenerated
	 */public static class Criterion {private String condition;private Object value;private Object secondValue;private boolean noValue;private boolean singleValue;private boolean betweenValue;private boolean listValue;private String typeHandler;public String getCondition(){return condition;}public Object getValue(){return value;}public Object getSecondValue(){return secondValue;}public boolean isNoValue(){return noValue;}public boolean isSingleValue(){return singleValue;}public boolean isBetweenValue(){return betweenValue;}public boolean isListValue(){return listValue;}public String getTypeHandler(){return typeHandler;}protected Criterion(String condition){super();this.condition=condition;this.typeHandler=null;this.noValue=true;}protected Criterion(String condition,Object value,String typeHandler){super();this.condition=condition;this.value=value;this.typeHandler=typeHandler;if (value instanceof List<?>){this.listValue=true;} else {this.singleValue=true;}}protected Criterion(String condition,Object value){this(condition,value,null);}protected Criterion(String condition,Object value,Object secondValue,String typeHandler){super();this.condition=condition;this.value=value;this.secondValue=secondValue;this.typeHandler=typeHandler;this.betweenValue=true;}protected Criterion(String condition,Object value,Object secondValue){this(condition,value,secondValue,null);}}

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