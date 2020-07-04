package com.myfun.repository.erpdb.po;

import com.myfun.repository.support.generator.shard.ShardDb;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ErpFunMlTaskTimeExample extends ShardDb {
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
	 */public ErpFunMlTaskTimeExample(){oredCriteria=new ArrayList<Criteria>();}

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
	 */protected abstract static class GeneratedCriteria {protected List<Criterion> criteria;protected GeneratedCriteria(){super();criteria=new ArrayList<Criterion>();}public boolean isValid(){return criteria.size() > 0;}public List<Criterion> getAllCriteria(){return criteria;}public List<Criterion> getCriteria(){return criteria;}protected void addCriterion(String condition){if (condition == null){throw new RuntimeException("Value for condition cannot be null");}criteria.add(new Criterion(condition));}protected void addCriterion(String condition,Object value,String property){if (value == null){throw new RuntimeException("Value for " + property + " cannot be null");}criteria.add(new Criterion(condition,value));}protected void addCriterion(String condition,Object value1,Object value2,String property){if (value1 == null || value2 == null){throw new RuntimeException("Between values for " + property + " cannot be null");}criteria.add(new Criterion(condition,value1,value2));}public Criteria andTaskTimeIdIsNull(){addCriterion("TASK_TIME_ID is null");return (Criteria)this;}public Criteria andTaskTimeIdIsNotNull(){addCriterion("TASK_TIME_ID is not null");return (Criteria)this;}public Criteria andTaskTimeIdEqualTo(Integer value){addCriterion("TASK_TIME_ID =",value,"taskTimeId");return (Criteria)this;}public Criteria andTaskTimeIdNotEqualTo(Integer value){addCriterion("TASK_TIME_ID <>",value,"taskTimeId");return (Criteria)this;}public Criteria andTaskTimeIdGreaterThan(Integer value){addCriterion("TASK_TIME_ID >",value,"taskTimeId");return (Criteria)this;}public Criteria andTaskTimeIdGreaterThanOrEqualTo(Integer value){addCriterion("TASK_TIME_ID >=",value,"taskTimeId");return (Criteria)this;}public Criteria andTaskTimeIdLessThan(Integer value){addCriterion("TASK_TIME_ID <",value,"taskTimeId");return (Criteria)this;}public Criteria andTaskTimeIdLessThanOrEqualTo(Integer value){addCriterion("TASK_TIME_ID <=",value,"taskTimeId");return (Criteria)this;}public Criteria andTaskTimeIdIn(List<Integer> values){addCriterion("TASK_TIME_ID in",values,"taskTimeId");return (Criteria)this;}public Criteria andTaskTimeIdNotIn(List<Integer> values){addCriterion("TASK_TIME_ID not in",values,"taskTimeId");return (Criteria)this;}public Criteria andTaskTimeIdBetween(Integer value1,Integer value2){addCriterion("TASK_TIME_ID between",value1,value2,"taskTimeId");return (Criteria)this;}public Criteria andTaskTimeIdNotBetween(Integer value1,Integer value2){addCriterion("TASK_TIME_ID not between",value1,value2,"taskTimeId");return (Criteria)this;}public Criteria andRecieveTaskIdIsNull(){addCriterion("RECIEVE_TASK_ID is null");return (Criteria)this;}public Criteria andRecieveTaskIdIsNotNull(){addCriterion("RECIEVE_TASK_ID is not null");return (Criteria)this;}public Criteria andRecieveTaskIdEqualTo(Integer value){addCriterion("RECIEVE_TASK_ID =",value,"recieveTaskId");return (Criteria)this;}public Criteria andRecieveTaskIdNotEqualTo(Integer value){addCriterion("RECIEVE_TASK_ID <>",value,"recieveTaskId");return (Criteria)this;}public Criteria andRecieveTaskIdGreaterThan(Integer value){addCriterion("RECIEVE_TASK_ID >",value,"recieveTaskId");return (Criteria)this;}public Criteria andRecieveTaskIdGreaterThanOrEqualTo(Integer value){addCriterion("RECIEVE_TASK_ID >=",value,"recieveTaskId");return (Criteria)this;}public Criteria andRecieveTaskIdLessThan(Integer value){addCriterion("RECIEVE_TASK_ID <",value,"recieveTaskId");return (Criteria)this;}public Criteria andRecieveTaskIdLessThanOrEqualTo(Integer value){addCriterion("RECIEVE_TASK_ID <=",value,"recieveTaskId");return (Criteria)this;}public Criteria andRecieveTaskIdIn(List<Integer> values){addCriterion("RECIEVE_TASK_ID in",values,"recieveTaskId");return (Criteria)this;}public Criteria andRecieveTaskIdNotIn(List<Integer> values){addCriterion("RECIEVE_TASK_ID not in",values,"recieveTaskId");return (Criteria)this;}public Criteria andRecieveTaskIdBetween(Integer value1,Integer value2){addCriterion("RECIEVE_TASK_ID between",value1,value2,"recieveTaskId");return (Criteria)this;}public Criteria andRecieveTaskIdNotBetween(Integer value1,Integer value2){addCriterion("RECIEVE_TASK_ID not between",value1,value2,"recieveTaskId");return (Criteria)this;}public Criteria andCreatedTimeIsNull(){addCriterion("CREATED_TIME is null");return (Criteria)this;}public Criteria andCreatedTimeIsNotNull(){addCriterion("CREATED_TIME is not null");return (Criteria)this;}public Criteria andCreatedTimeEqualTo(Date value){addCriterion("CREATED_TIME =",value,"createdTime");return (Criteria)this;}public Criteria andCreatedTimeNotEqualTo(Date value){addCriterion("CREATED_TIME <>",value,"createdTime");return (Criteria)this;}public Criteria andCreatedTimeGreaterThan(Date value){addCriterion("CREATED_TIME >",value,"createdTime");return (Criteria)this;}public Criteria andCreatedTimeGreaterThanOrEqualTo(Date value){addCriterion("CREATED_TIME >=",value,"createdTime");return (Criteria)this;}public Criteria andCreatedTimeLessThan(Date value){addCriterion("CREATED_TIME <",value,"createdTime");return (Criteria)this;}public Criteria andCreatedTimeLessThanOrEqualTo(Date value){addCriterion("CREATED_TIME <=",value,"createdTime");return (Criteria)this;}public Criteria andCreatedTimeIn(List<Date> values){addCriterion("CREATED_TIME in",values,"createdTime");return (Criteria)this;}public Criteria andCreatedTimeNotIn(List<Date> values){addCriterion("CREATED_TIME not in",values,"createdTime");return (Criteria)this;}public Criteria andCreatedTimeBetween(Date value1,Date value2){addCriterion("CREATED_TIME between",value1,value2,"createdTime");return (Criteria)this;}public Criteria andCreatedTimeNotBetween(Date value1,Date value2){addCriterion("CREATED_TIME not between",value1,value2,"createdTime");return (Criteria)this;}public Criteria andRecieveUserIdIsNull(){addCriterion("RECIEVE_USER_ID is null");return (Criteria)this;}public Criteria andRecieveUserIdIsNotNull(){addCriterion("RECIEVE_USER_ID is not null");return (Criteria)this;}public Criteria andRecieveUserIdEqualTo(Integer value){addCriterion("RECIEVE_USER_ID =",value,"recieveUserId");return (Criteria)this;}public Criteria andRecieveUserIdNotEqualTo(Integer value){addCriterion("RECIEVE_USER_ID <>",value,"recieveUserId");return (Criteria)this;}public Criteria andRecieveUserIdGreaterThan(Integer value){addCriterion("RECIEVE_USER_ID >",value,"recieveUserId");return (Criteria)this;}public Criteria andRecieveUserIdGreaterThanOrEqualTo(Integer value){addCriterion("RECIEVE_USER_ID >=",value,"recieveUserId");return (Criteria)this;}public Criteria andRecieveUserIdLessThan(Integer value){addCriterion("RECIEVE_USER_ID <",value,"recieveUserId");return (Criteria)this;}public Criteria andRecieveUserIdLessThanOrEqualTo(Integer value){addCriterion("RECIEVE_USER_ID <=",value,"recieveUserId");return (Criteria)this;}public Criteria andRecieveUserIdIn(List<Integer> values){addCriterion("RECIEVE_USER_ID in",values,"recieveUserId");return (Criteria)this;}public Criteria andRecieveUserIdNotIn(List<Integer> values){addCriterion("RECIEVE_USER_ID not in",values,"recieveUserId");return (Criteria)this;}public Criteria andRecieveUserIdBetween(Integer value1,Integer value2){addCriterion("RECIEVE_USER_ID between",value1,value2,"recieveUserId");return (Criteria)this;}public Criteria andRecieveUserIdNotBetween(Integer value1,Integer value2){addCriterion("RECIEVE_USER_ID not between",value1,value2,"recieveUserId");return (Criteria)this;}public Criteria andRecieveArchiveIdIsNull(){addCriterion("RECIEVE_ARCHIVE_ID is null");return (Criteria)this;}public Criteria andRecieveArchiveIdIsNotNull(){addCriterion("RECIEVE_ARCHIVE_ID is not null");return (Criteria)this;}public Criteria andRecieveArchiveIdEqualTo(Integer value){addCriterion("RECIEVE_ARCHIVE_ID =",value,"recieveArchiveId");return (Criteria)this;}public Criteria andRecieveArchiveIdNotEqualTo(Integer value){addCriterion("RECIEVE_ARCHIVE_ID <>",value,"recieveArchiveId");return (Criteria)this;}public Criteria andRecieveArchiveIdGreaterThan(Integer value){addCriterion("RECIEVE_ARCHIVE_ID >",value,"recieveArchiveId");return (Criteria)this;}public Criteria andRecieveArchiveIdGreaterThanOrEqualTo(Integer value){addCriterion("RECIEVE_ARCHIVE_ID >=",value,"recieveArchiveId");return (Criteria)this;}public Criteria andRecieveArchiveIdLessThan(Integer value){addCriterion("RECIEVE_ARCHIVE_ID <",value,"recieveArchiveId");return (Criteria)this;}public Criteria andRecieveArchiveIdLessThanOrEqualTo(Integer value){addCriterion("RECIEVE_ARCHIVE_ID <=",value,"recieveArchiveId");return (Criteria)this;}public Criteria andRecieveArchiveIdIn(List<Integer> values){addCriterion("RECIEVE_ARCHIVE_ID in",values,"recieveArchiveId");return (Criteria)this;}public Criteria andRecieveArchiveIdNotIn(List<Integer> values){addCriterion("RECIEVE_ARCHIVE_ID not in",values,"recieveArchiveId");return (Criteria)this;}public Criteria andRecieveArchiveIdBetween(Integer value1,Integer value2){addCriterion("RECIEVE_ARCHIVE_ID between",value1,value2,"recieveArchiveId");return (Criteria)this;}public Criteria andRecieveArchiveIdNotBetween(Integer value1,Integer value2){addCriterion("RECIEVE_ARCHIVE_ID not between",value1,value2,"recieveArchiveId");return (Criteria)this;}public Criteria andRecieveTimeIsNull(){addCriterion("RECIEVE_TIME is null");return (Criteria)this;}public Criteria andRecieveTimeIsNotNull(){addCriterion("RECIEVE_TIME is not null");return (Criteria)this;}public Criteria andRecieveTimeEqualTo(Date value){addCriterion("RECIEVE_TIME =",value,"recieveTime");return (Criteria)this;}public Criteria andRecieveTimeNotEqualTo(Date value){addCriterion("RECIEVE_TIME <>",value,"recieveTime");return (Criteria)this;}public Criteria andRecieveTimeGreaterThan(Date value){addCriterion("RECIEVE_TIME >",value,"recieveTime");return (Criteria)this;}public Criteria andRecieveTimeGreaterThanOrEqualTo(Date value){addCriterion("RECIEVE_TIME >=",value,"recieveTime");return (Criteria)this;}public Criteria andRecieveTimeLessThan(Date value){addCriterion("RECIEVE_TIME <",value,"recieveTime");return (Criteria)this;}public Criteria andRecieveTimeLessThanOrEqualTo(Date value){addCriterion("RECIEVE_TIME <=",value,"recieveTime");return (Criteria)this;}public Criteria andRecieveTimeIn(List<Date> values){addCriterion("RECIEVE_TIME in",values,"recieveTime");return (Criteria)this;}public Criteria andRecieveTimeNotIn(List<Date> values){addCriterion("RECIEVE_TIME not in",values,"recieveTime");return (Criteria)this;}public Criteria andRecieveTimeBetween(Date value1,Date value2){addCriterion("RECIEVE_TIME between",value1,value2,"recieveTime");return (Criteria)this;}public Criteria andRecieveTimeNotBetween(Date value1,Date value2){addCriterion("RECIEVE_TIME not between",value1,value2,"recieveTime");return (Criteria)this;}public Criteria andCompIdIsNull(){addCriterion("COMP_ID is null");return (Criteria)this;}public Criteria andCompIdIsNotNull(){addCriterion("COMP_ID is not null");return (Criteria)this;}public Criteria andCompIdEqualTo(Integer value){addCriterion("COMP_ID =",value,"compId");return (Criteria)this;}public Criteria andCompIdNotEqualTo(Integer value){addCriterion("COMP_ID <>",value,"compId");return (Criteria)this;}public Criteria andCompIdGreaterThan(Integer value){addCriterion("COMP_ID >",value,"compId");return (Criteria)this;}public Criteria andCompIdGreaterThanOrEqualTo(Integer value){addCriterion("COMP_ID >=",value,"compId");return (Criteria)this;}public Criteria andCompIdLessThan(Integer value){addCriterion("COMP_ID <",value,"compId");return (Criteria)this;}public Criteria andCompIdLessThanOrEqualTo(Integer value){addCriterion("COMP_ID <=",value,"compId");return (Criteria)this;}public Criteria andCompIdIn(List<Integer> values){addCriterion("COMP_ID in",values,"compId");return (Criteria)this;}public Criteria andCompIdNotIn(List<Integer> values){addCriterion("COMP_ID not in",values,"compId");return (Criteria)this;}public Criteria andCompIdBetween(Integer value1,Integer value2){addCriterion("COMP_ID between",value1,value2,"compId");return (Criteria)this;}public Criteria andCompIdNotBetween(Integer value1,Integer value2){addCriterion("COMP_ID not between",value1,value2,"compId");return (Criteria)this;}}

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