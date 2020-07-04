package com.myfun.repository.admindb.po;

import java.util.ArrayList;
import java.util.List;

public class AdminFunProvinceExample {
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
	 */public AdminFunProvinceExample(){oredCriteria=new ArrayList<Criteria>();}

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
	 */protected abstract static class GeneratedCriteria {protected List<Criterion> criteria;protected GeneratedCriteria(){super();criteria=new ArrayList<Criterion>();}public boolean isValid(){return criteria.size() > 0;}public List<Criterion> getAllCriteria(){return criteria;}public List<Criterion> getCriteria(){return criteria;}protected void addCriterion(String condition){if (condition == null){throw new RuntimeException("Value for condition cannot be null");}criteria.add(new Criterion(condition));}protected void addCriterion(String condition,Object value,String property){if (value == null){throw new RuntimeException("Value for " + property + " cannot be null");}criteria.add(new Criterion(condition,value));}protected void addCriterion(String condition,Object value1,Object value2,String property){if (value1 == null || value2 == null){throw new RuntimeException("Between values for " + property + " cannot be null");}criteria.add(new Criterion(condition,value1,value2));}public Criteria andProvinceIdIsNull(){addCriterion("PROVINCE_ID is null");return (Criteria)this;}public Criteria andProvinceIdIsNotNull(){addCriterion("PROVINCE_ID is not null");return (Criteria)this;}public Criteria andProvinceIdEqualTo(Short value){addCriterion("PROVINCE_ID =",value,"provinceId");return (Criteria)this;}public Criteria andProvinceIdNotEqualTo(Short value){addCriterion("PROVINCE_ID <>",value,"provinceId");return (Criteria)this;}public Criteria andProvinceIdGreaterThan(Short value){addCriterion("PROVINCE_ID >",value,"provinceId");return (Criteria)this;}public Criteria andProvinceIdGreaterThanOrEqualTo(Short value){addCriterion("PROVINCE_ID >=",value,"provinceId");return (Criteria)this;}public Criteria andProvinceIdLessThan(Short value){addCriterion("PROVINCE_ID <",value,"provinceId");return (Criteria)this;}public Criteria andProvinceIdLessThanOrEqualTo(Short value){addCriterion("PROVINCE_ID <=",value,"provinceId");return (Criteria)this;}public Criteria andProvinceIdIn(List<Short> values){addCriterion("PROVINCE_ID in",values,"provinceId");return (Criteria)this;}public Criteria andProvinceIdNotIn(List<Short> values){addCriterion("PROVINCE_ID not in",values,"provinceId");return (Criteria)this;}public Criteria andProvinceIdBetween(Short value1,Short value2){addCriterion("PROVINCE_ID between",value1,value2,"provinceId");return (Criteria)this;}public Criteria andProvinceIdNotBetween(Short value1,Short value2){addCriterion("PROVINCE_ID not between",value1,value2,"provinceId");return (Criteria)this;}public Criteria andProvinceNameIsNull(){addCriterion("PROVINCE_NAME is null");return (Criteria)this;}public Criteria andProvinceNameIsNotNull(){addCriterion("PROVINCE_NAME is not null");return (Criteria)this;}public Criteria andProvinceNameEqualTo(String value){addCriterion("PROVINCE_NAME =",value,"provinceName");return (Criteria)this;}public Criteria andProvinceNameNotEqualTo(String value){addCriterion("PROVINCE_NAME <>",value,"provinceName");return (Criteria)this;}public Criteria andProvinceNameGreaterThan(String value){addCriterion("PROVINCE_NAME >",value,"provinceName");return (Criteria)this;}public Criteria andProvinceNameGreaterThanOrEqualTo(String value){addCriterion("PROVINCE_NAME >=",value,"provinceName");return (Criteria)this;}public Criteria andProvinceNameLessThan(String value){addCriterion("PROVINCE_NAME <",value,"provinceName");return (Criteria)this;}public Criteria andProvinceNameLessThanOrEqualTo(String value){addCriterion("PROVINCE_NAME <=",value,"provinceName");return (Criteria)this;}public Criteria andProvinceNameLike(String value){addCriterion("PROVINCE_NAME like",value,"provinceName");return (Criteria)this;}public Criteria andProvinceNameNotLike(String value){addCriterion("PROVINCE_NAME not like",value,"provinceName");return (Criteria)this;}public Criteria andProvinceNameIn(List<String> values){addCriterion("PROVINCE_NAME in",values,"provinceName");return (Criteria)this;}public Criteria andProvinceNameNotIn(List<String> values){addCriterion("PROVINCE_NAME not in",values,"provinceName");return (Criteria)this;}public Criteria andProvinceNameBetween(String value1,String value2){addCriterion("PROVINCE_NAME between",value1,value2,"provinceName");return (Criteria)this;}public Criteria andProvinceNameNotBetween(String value1,String value2){addCriterion("PROVINCE_NAME not between",value1,value2,"provinceName");return (Criteria)this;}public Criteria andSeqNoIsNull(){addCriterion("SEQ_NO is null");return (Criteria)this;}public Criteria andSeqNoIsNotNull(){addCriterion("SEQ_NO is not null");return (Criteria)this;}public Criteria andSeqNoEqualTo(Short value){addCriterion("SEQ_NO =",value,"seqNo");return (Criteria)this;}public Criteria andSeqNoNotEqualTo(Short value){addCriterion("SEQ_NO <>",value,"seqNo");return (Criteria)this;}public Criteria andSeqNoGreaterThan(Short value){addCriterion("SEQ_NO >",value,"seqNo");return (Criteria)this;}public Criteria andSeqNoGreaterThanOrEqualTo(Short value){addCriterion("SEQ_NO >=",value,"seqNo");return (Criteria)this;}public Criteria andSeqNoLessThan(Short value){addCriterion("SEQ_NO <",value,"seqNo");return (Criteria)this;}public Criteria andSeqNoLessThanOrEqualTo(Short value){addCriterion("SEQ_NO <=",value,"seqNo");return (Criteria)this;}public Criteria andSeqNoIn(List<Short> values){addCriterion("SEQ_NO in",values,"seqNo");return (Criteria)this;}public Criteria andSeqNoNotIn(List<Short> values){addCriterion("SEQ_NO not in",values,"seqNo");return (Criteria)this;}public Criteria andSeqNoBetween(Short value1,Short value2){addCriterion("SEQ_NO between",value1,value2,"seqNo");return (Criteria)this;}public Criteria andSeqNoNotBetween(Short value1,Short value2){addCriterion("SEQ_NO not between",value1,value2,"seqNo");return (Criteria)this;}}

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