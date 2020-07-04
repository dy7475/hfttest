package com.myfun.repository.erpdb.po;

import com.myfun.repository.support.generator.shard.ShardDb;
import java.util.ArrayList;
import java.util.List;

public class ErpFunMlTaskFileExample extends ShardDb {
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
	 */public ErpFunMlTaskFileExample(){oredCriteria=new ArrayList<Criteria>();}

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
	 */protected abstract static class GeneratedCriteria {protected List<Criterion> criteria;protected GeneratedCriteria(){super();criteria=new ArrayList<Criterion>();}public boolean isValid(){return criteria.size() > 0;}public List<Criterion> getAllCriteria(){return criteria;}public List<Criterion> getCriteria(){return criteria;}protected void addCriterion(String condition){if (condition == null){throw new RuntimeException("Value for condition cannot be null");}criteria.add(new Criterion(condition));}protected void addCriterion(String condition,Object value,String property){if (value == null){throw new RuntimeException("Value for " + property + " cannot be null");}criteria.add(new Criterion(condition,value));}protected void addCriterion(String condition,Object value1,Object value2,String property){if (value1 == null || value2 == null){throw new RuntimeException("Between values for " + property + " cannot be null");}criteria.add(new Criterion(condition,value1,value2));}public Criteria andTaskFileIdIsNull(){addCriterion("TASK_FILE_ID is null");return (Criteria)this;}public Criteria andTaskFileIdIsNotNull(){addCriterion("TASK_FILE_ID is not null");return (Criteria)this;}public Criteria andTaskFileIdEqualTo(Integer value){addCriterion("TASK_FILE_ID =",value,"taskFileId");return (Criteria)this;}public Criteria andTaskFileIdNotEqualTo(Integer value){addCriterion("TASK_FILE_ID <>",value,"taskFileId");return (Criteria)this;}public Criteria andTaskFileIdGreaterThan(Integer value){addCriterion("TASK_FILE_ID >",value,"taskFileId");return (Criteria)this;}public Criteria andTaskFileIdGreaterThanOrEqualTo(Integer value){addCriterion("TASK_FILE_ID >=",value,"taskFileId");return (Criteria)this;}public Criteria andTaskFileIdLessThan(Integer value){addCriterion("TASK_FILE_ID <",value,"taskFileId");return (Criteria)this;}public Criteria andTaskFileIdLessThanOrEqualTo(Integer value){addCriterion("TASK_FILE_ID <=",value,"taskFileId");return (Criteria)this;}public Criteria andTaskFileIdIn(List<Integer> values){addCriterion("TASK_FILE_ID in",values,"taskFileId");return (Criteria)this;}public Criteria andTaskFileIdNotIn(List<Integer> values){addCriterion("TASK_FILE_ID not in",values,"taskFileId");return (Criteria)this;}public Criteria andTaskFileIdBetween(Integer value1,Integer value2){addCriterion("TASK_FILE_ID between",value1,value2,"taskFileId");return (Criteria)this;}public Criteria andTaskFileIdNotBetween(Integer value1,Integer value2){addCriterion("TASK_FILE_ID not between",value1,value2,"taskFileId");return (Criteria)this;}public Criteria andTaskIdIsNull(){addCriterion("TASK_ID is null");return (Criteria)this;}public Criteria andTaskIdIsNotNull(){addCriterion("TASK_ID is not null");return (Criteria)this;}public Criteria andTaskIdEqualTo(Integer value){addCriterion("TASK_ID =",value,"taskId");return (Criteria)this;}public Criteria andTaskIdNotEqualTo(Integer value){addCriterion("TASK_ID <>",value,"taskId");return (Criteria)this;}public Criteria andTaskIdGreaterThan(Integer value){addCriterion("TASK_ID >",value,"taskId");return (Criteria)this;}public Criteria andTaskIdGreaterThanOrEqualTo(Integer value){addCriterion("TASK_ID >=",value,"taskId");return (Criteria)this;}public Criteria andTaskIdLessThan(Integer value){addCriterion("TASK_ID <",value,"taskId");return (Criteria)this;}public Criteria andTaskIdLessThanOrEqualTo(Integer value){addCriterion("TASK_ID <=",value,"taskId");return (Criteria)this;}public Criteria andTaskIdIn(List<Integer> values){addCriterion("TASK_ID in",values,"taskId");return (Criteria)this;}public Criteria andTaskIdNotIn(List<Integer> values){addCriterion("TASK_ID not in",values,"taskId");return (Criteria)this;}public Criteria andTaskIdBetween(Integer value1,Integer value2){addCriterion("TASK_ID between",value1,value2,"taskId");return (Criteria)this;}public Criteria andTaskIdNotBetween(Integer value1,Integer value2){addCriterion("TASK_ID not between",value1,value2,"taskId");return (Criteria)this;}public Criteria andFileNameIsNull(){addCriterion("FILE_NAME is null");return (Criteria)this;}public Criteria andFileNameIsNotNull(){addCriterion("FILE_NAME is not null");return (Criteria)this;}public Criteria andFileNameEqualTo(String value){addCriterion("FILE_NAME =",value,"fileName");return (Criteria)this;}public Criteria andFileNameNotEqualTo(String value){addCriterion("FILE_NAME <>",value,"fileName");return (Criteria)this;}public Criteria andFileNameGreaterThan(String value){addCriterion("FILE_NAME >",value,"fileName");return (Criteria)this;}public Criteria andFileNameGreaterThanOrEqualTo(String value){addCriterion("FILE_NAME >=",value,"fileName");return (Criteria)this;}public Criteria andFileNameLessThan(String value){addCriterion("FILE_NAME <",value,"fileName");return (Criteria)this;}public Criteria andFileNameLessThanOrEqualTo(String value){addCriterion("FILE_NAME <=",value,"fileName");return (Criteria)this;}public Criteria andFileNameLike(String value){addCriterion("FILE_NAME like",value,"fileName");return (Criteria)this;}public Criteria andFileNameNotLike(String value){addCriterion("FILE_NAME not like",value,"fileName");return (Criteria)this;}public Criteria andFileNameIn(List<String> values){addCriterion("FILE_NAME in",values,"fileName");return (Criteria)this;}public Criteria andFileNameNotIn(List<String> values){addCriterion("FILE_NAME not in",values,"fileName");return (Criteria)this;}public Criteria andFileNameBetween(String value1,String value2){addCriterion("FILE_NAME between",value1,value2,"fileName");return (Criteria)this;}public Criteria andFileNameNotBetween(String value1,String value2){addCriterion("FILE_NAME not between",value1,value2,"fileName");return (Criteria)this;}public Criteria andFileAddrIsNull(){addCriterion("FILE_ADDR is null");return (Criteria)this;}public Criteria andFileAddrIsNotNull(){addCriterion("FILE_ADDR is not null");return (Criteria)this;}public Criteria andFileAddrEqualTo(String value){addCriterion("FILE_ADDR =",value,"fileAddr");return (Criteria)this;}public Criteria andFileAddrNotEqualTo(String value){addCriterion("FILE_ADDR <>",value,"fileAddr");return (Criteria)this;}public Criteria andFileAddrGreaterThan(String value){addCriterion("FILE_ADDR >",value,"fileAddr");return (Criteria)this;}public Criteria andFileAddrGreaterThanOrEqualTo(String value){addCriterion("FILE_ADDR >=",value,"fileAddr");return (Criteria)this;}public Criteria andFileAddrLessThan(String value){addCriterion("FILE_ADDR <",value,"fileAddr");return (Criteria)this;}public Criteria andFileAddrLessThanOrEqualTo(String value){addCriterion("FILE_ADDR <=",value,"fileAddr");return (Criteria)this;}public Criteria andFileAddrLike(String value){addCriterion("FILE_ADDR like",value,"fileAddr");return (Criteria)this;}public Criteria andFileAddrNotLike(String value){addCriterion("FILE_ADDR not like",value,"fileAddr");return (Criteria)this;}public Criteria andFileAddrIn(List<String> values){addCriterion("FILE_ADDR in",values,"fileAddr");return (Criteria)this;}public Criteria andFileAddrNotIn(List<String> values){addCriterion("FILE_ADDR not in",values,"fileAddr");return (Criteria)this;}public Criteria andFileAddrBetween(String value1,String value2){addCriterion("FILE_ADDR between",value1,value2,"fileAddr");return (Criteria)this;}public Criteria andFileAddrNotBetween(String value1,String value2){addCriterion("FILE_ADDR not between",value1,value2,"fileAddr");return (Criteria)this;}public Criteria andFileSizeIsNull(){addCriterion("FILE_SIZE is null");return (Criteria)this;}public Criteria andFileSizeIsNotNull(){addCriterion("FILE_SIZE is not null");return (Criteria)this;}public Criteria andFileSizeEqualTo(String value){addCriterion("FILE_SIZE =",value,"fileSize");return (Criteria)this;}public Criteria andFileSizeNotEqualTo(String value){addCriterion("FILE_SIZE <>",value,"fileSize");return (Criteria)this;}public Criteria andFileSizeGreaterThan(String value){addCriterion("FILE_SIZE >",value,"fileSize");return (Criteria)this;}public Criteria andFileSizeGreaterThanOrEqualTo(String value){addCriterion("FILE_SIZE >=",value,"fileSize");return (Criteria)this;}public Criteria andFileSizeLessThan(String value){addCriterion("FILE_SIZE <",value,"fileSize");return (Criteria)this;}public Criteria andFileSizeLessThanOrEqualTo(String value){addCriterion("FILE_SIZE <=",value,"fileSize");return (Criteria)this;}public Criteria andFileSizeLike(String value){addCriterion("FILE_SIZE like",value,"fileSize");return (Criteria)this;}public Criteria andFileSizeNotLike(String value){addCriterion("FILE_SIZE not like",value,"fileSize");return (Criteria)this;}public Criteria andFileSizeIn(List<String> values){addCriterion("FILE_SIZE in",values,"fileSize");return (Criteria)this;}public Criteria andFileSizeNotIn(List<String> values){addCriterion("FILE_SIZE not in",values,"fileSize");return (Criteria)this;}public Criteria andFileSizeBetween(String value1,String value2){addCriterion("FILE_SIZE between",value1,value2,"fileSize");return (Criteria)this;}public Criteria andFileSizeNotBetween(String value1,String value2){addCriterion("FILE_SIZE not between",value1,value2,"fileSize");return (Criteria)this;}}

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