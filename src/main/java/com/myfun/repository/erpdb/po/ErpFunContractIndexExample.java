package com.myfun.repository.erpdb.po;

import com.myfun.repository.support.generator.shard.ShardDb;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ErpFunContractIndexExample extends ShardDb {
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
	 */public ErpFunContractIndexExample(){oredCriteria=new ArrayList<Criteria>();}

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
	 */protected abstract static class GeneratedCriteria {protected List<Criterion> criteria;protected GeneratedCriteria(){super();criteria=new ArrayList<Criterion>();}public boolean isValid(){return criteria.size() > 0;}public List<Criterion> getAllCriteria(){return criteria;}public List<Criterion> getCriteria(){return criteria;}protected void addCriterion(String condition){if (condition == null){throw new RuntimeException("Value for condition cannot be null");}criteria.add(new Criterion(condition));}protected void addCriterion(String condition,Object value,String property){if (value == null){throw new RuntimeException("Value for " + property + " cannot be null");}criteria.add(new Criterion(condition,value));}protected void addCriterion(String condition,Object value1,Object value2,String property){if (value1 == null || value2 == null){throw new RuntimeException("Between values for " + property + " cannot be null");}criteria.add(new Criterion(condition,value1,value2));}public Criteria andIndexIdIsNull(){addCriterion("INDEX_ID is null");return (Criteria)this;}public Criteria andIndexIdIsNotNull(){addCriterion("INDEX_ID is not null");return (Criteria)this;}public Criteria andIndexIdEqualTo(Integer value){addCriterion("INDEX_ID =",value,"indexId");return (Criteria)this;}public Criteria andIndexIdNotEqualTo(Integer value){addCriterion("INDEX_ID <>",value,"indexId");return (Criteria)this;}public Criteria andIndexIdGreaterThan(Integer value){addCriterion("INDEX_ID >",value,"indexId");return (Criteria)this;}public Criteria andIndexIdGreaterThanOrEqualTo(Integer value){addCriterion("INDEX_ID >=",value,"indexId");return (Criteria)this;}public Criteria andIndexIdLessThan(Integer value){addCriterion("INDEX_ID <",value,"indexId");return (Criteria)this;}public Criteria andIndexIdLessThanOrEqualTo(Integer value){addCriterion("INDEX_ID <=",value,"indexId");return (Criteria)this;}public Criteria andIndexIdIn(List<Integer> values){addCriterion("INDEX_ID in",values,"indexId");return (Criteria)this;}public Criteria andIndexIdNotIn(List<Integer> values){addCriterion("INDEX_ID not in",values,"indexId");return (Criteria)this;}public Criteria andIndexIdBetween(Integer value1,Integer value2){addCriterion("INDEX_ID between",value1,value2,"indexId");return (Criteria)this;}public Criteria andIndexIdNotBetween(Integer value1,Integer value2){addCriterion("INDEX_ID not between",value1,value2,"indexId");return (Criteria)this;}public Criteria andIndexNameIsNull(){addCriterion("INDEX_NAME is null");return (Criteria)this;}public Criteria andIndexNameIsNotNull(){addCriterion("INDEX_NAME is not null");return (Criteria)this;}public Criteria andIndexNameEqualTo(String value){addCriterion("INDEX_NAME =",value,"indexName");return (Criteria)this;}public Criteria andIndexNameNotEqualTo(String value){addCriterion("INDEX_NAME <>",value,"indexName");return (Criteria)this;}public Criteria andIndexNameGreaterThan(String value){addCriterion("INDEX_NAME >",value,"indexName");return (Criteria)this;}public Criteria andIndexNameGreaterThanOrEqualTo(String value){addCriterion("INDEX_NAME >=",value,"indexName");return (Criteria)this;}public Criteria andIndexNameLessThan(String value){addCriterion("INDEX_NAME <",value,"indexName");return (Criteria)this;}public Criteria andIndexNameLessThanOrEqualTo(String value){addCriterion("INDEX_NAME <=",value,"indexName");return (Criteria)this;}public Criteria andIndexNameLike(String value){addCriterion("INDEX_NAME like",value,"indexName");return (Criteria)this;}public Criteria andIndexNameNotLike(String value){addCriterion("INDEX_NAME not like",value,"indexName");return (Criteria)this;}public Criteria andIndexNameIn(List<String> values){addCriterion("INDEX_NAME in",values,"indexName");return (Criteria)this;}public Criteria andIndexNameNotIn(List<String> values){addCriterion("INDEX_NAME not in",values,"indexName");return (Criteria)this;}public Criteria andIndexNameBetween(String value1,String value2){addCriterion("INDEX_NAME between",value1,value2,"indexName");return (Criteria)this;}public Criteria andIndexNameNotBetween(String value1,String value2){addCriterion("INDEX_NAME not between",value1,value2,"indexName");return (Criteria)this;}public Criteria andIndexTypeIsNull(){addCriterion("INDEX_TYPE is null");return (Criteria)this;}public Criteria andIndexTypeIsNotNull(){addCriterion("INDEX_TYPE is not null");return (Criteria)this;}public Criteria andIndexTypeEqualTo(String value){addCriterion("INDEX_TYPE =",value,"indexType");return (Criteria)this;}public Criteria andIndexTypeNotEqualTo(String value){addCriterion("INDEX_TYPE <>",value,"indexType");return (Criteria)this;}public Criteria andIndexTypeGreaterThan(String value){addCriterion("INDEX_TYPE >",value,"indexType");return (Criteria)this;}public Criteria andIndexTypeGreaterThanOrEqualTo(String value){addCriterion("INDEX_TYPE >=",value,"indexType");return (Criteria)this;}public Criteria andIndexTypeLessThan(String value){addCriterion("INDEX_TYPE <",value,"indexType");return (Criteria)this;}public Criteria andIndexTypeLessThanOrEqualTo(String value){addCriterion("INDEX_TYPE <=",value,"indexType");return (Criteria)this;}public Criteria andIndexTypeLike(String value){addCriterion("INDEX_TYPE like",value,"indexType");return (Criteria)this;}public Criteria andIndexTypeNotLike(String value){addCriterion("INDEX_TYPE not like",value,"indexType");return (Criteria)this;}public Criteria andIndexTypeIn(List<String> values){addCriterion("INDEX_TYPE in",values,"indexType");return (Criteria)this;}public Criteria andIndexTypeNotIn(List<String> values){addCriterion("INDEX_TYPE not in",values,"indexType");return (Criteria)this;}public Criteria andIndexTypeBetween(String value1,String value2){addCriterion("INDEX_TYPE between",value1,value2,"indexType");return (Criteria)this;}public Criteria andIndexTypeNotBetween(String value1,String value2){addCriterion("INDEX_TYPE not between",value1,value2,"indexType");return (Criteria)this;}public Criteria andIndexFormatIsNull(){addCriterion("INDEX_FORMAT is null");return (Criteria)this;}public Criteria andIndexFormatIsNotNull(){addCriterion("INDEX_FORMAT is not null");return (Criteria)this;}public Criteria andIndexFormatEqualTo(String value){addCriterion("INDEX_FORMAT =",value,"indexFormat");return (Criteria)this;}public Criteria andIndexFormatNotEqualTo(String value){addCriterion("INDEX_FORMAT <>",value,"indexFormat");return (Criteria)this;}public Criteria andIndexFormatGreaterThan(String value){addCriterion("INDEX_FORMAT >",value,"indexFormat");return (Criteria)this;}public Criteria andIndexFormatGreaterThanOrEqualTo(String value){addCriterion("INDEX_FORMAT >=",value,"indexFormat");return (Criteria)this;}public Criteria andIndexFormatLessThan(String value){addCriterion("INDEX_FORMAT <",value,"indexFormat");return (Criteria)this;}public Criteria andIndexFormatLessThanOrEqualTo(String value){addCriterion("INDEX_FORMAT <=",value,"indexFormat");return (Criteria)this;}public Criteria andIndexFormatLike(String value){addCriterion("INDEX_FORMAT like",value,"indexFormat");return (Criteria)this;}public Criteria andIndexFormatNotLike(String value){addCriterion("INDEX_FORMAT not like",value,"indexFormat");return (Criteria)this;}public Criteria andIndexFormatIn(List<String> values){addCriterion("INDEX_FORMAT in",values,"indexFormat");return (Criteria)this;}public Criteria andIndexFormatNotIn(List<String> values){addCriterion("INDEX_FORMAT not in",values,"indexFormat");return (Criteria)this;}public Criteria andIndexFormatBetween(String value1,String value2){addCriterion("INDEX_FORMAT between",value1,value2,"indexFormat");return (Criteria)this;}public Criteria andIndexFormatNotBetween(String value1,String value2){addCriterion("INDEX_FORMAT not between",value1,value2,"indexFormat");return (Criteria)this;}public Criteria andIndexUnitIsNull(){addCriterion("INDEX_UNIT is null");return (Criteria)this;}public Criteria andIndexUnitIsNotNull(){addCriterion("INDEX_UNIT is not null");return (Criteria)this;}public Criteria andIndexUnitEqualTo(String value){addCriterion("INDEX_UNIT =",value,"indexUnit");return (Criteria)this;}public Criteria andIndexUnitNotEqualTo(String value){addCriterion("INDEX_UNIT <>",value,"indexUnit");return (Criteria)this;}public Criteria andIndexUnitGreaterThan(String value){addCriterion("INDEX_UNIT >",value,"indexUnit");return (Criteria)this;}public Criteria andIndexUnitGreaterThanOrEqualTo(String value){addCriterion("INDEX_UNIT >=",value,"indexUnit");return (Criteria)this;}public Criteria andIndexUnitLessThan(String value){addCriterion("INDEX_UNIT <",value,"indexUnit");return (Criteria)this;}public Criteria andIndexUnitLessThanOrEqualTo(String value){addCriterion("INDEX_UNIT <=",value,"indexUnit");return (Criteria)this;}public Criteria andIndexUnitLike(String value){addCriterion("INDEX_UNIT like",value,"indexUnit");return (Criteria)this;}public Criteria andIndexUnitNotLike(String value){addCriterion("INDEX_UNIT not like",value,"indexUnit");return (Criteria)this;}public Criteria andIndexUnitIn(List<String> values){addCriterion("INDEX_UNIT in",values,"indexUnit");return (Criteria)this;}public Criteria andIndexUnitNotIn(List<String> values){addCriterion("INDEX_UNIT not in",values,"indexUnit");return (Criteria)this;}public Criteria andIndexUnitBetween(String value1,String value2){addCriterion("INDEX_UNIT between",value1,value2,"indexUnit");return (Criteria)this;}public Criteria andIndexUnitNotBetween(String value1,String value2){addCriterion("INDEX_UNIT not between",value1,value2,"indexUnit");return (Criteria)this;}public Criteria andUnderLineIsNull(){addCriterion("UNDER_LINE is null");return (Criteria)this;}public Criteria andUnderLineIsNotNull(){addCriterion("UNDER_LINE is not null");return (Criteria)this;}public Criteria andUnderLineEqualTo(Byte value){addCriterion("UNDER_LINE =",value,"underLine");return (Criteria)this;}public Criteria andUnderLineNotEqualTo(Byte value){addCriterion("UNDER_LINE <>",value,"underLine");return (Criteria)this;}public Criteria andUnderLineGreaterThan(Byte value){addCriterion("UNDER_LINE >",value,"underLine");return (Criteria)this;}public Criteria andUnderLineGreaterThanOrEqualTo(Byte value){addCriterion("UNDER_LINE >=",value,"underLine");return (Criteria)this;}public Criteria andUnderLineLessThan(Byte value){addCriterion("UNDER_LINE <",value,"underLine");return (Criteria)this;}public Criteria andUnderLineLessThanOrEqualTo(Byte value){addCriterion("UNDER_LINE <=",value,"underLine");return (Criteria)this;}public Criteria andUnderLineIn(List<Byte> values){addCriterion("UNDER_LINE in",values,"underLine");return (Criteria)this;}public Criteria andUnderLineNotIn(List<Byte> values){addCriterion("UNDER_LINE not in",values,"underLine");return (Criteria)this;}public Criteria andUnderLineBetween(Byte value1,Byte value2){addCriterion("UNDER_LINE between",value1,value2,"underLine");return (Criteria)this;}public Criteria andUnderLineNotBetween(Byte value1,Byte value2){addCriterion("UNDER_LINE not between",value1,value2,"underLine");return (Criteria)this;}public Criteria andCreationTimeIsNull(){addCriterion("CREATION_TIME is null");return (Criteria)this;}public Criteria andCreationTimeIsNotNull(){addCriterion("CREATION_TIME is not null");return (Criteria)this;}public Criteria andCreationTimeEqualTo(Date value){addCriterion("CREATION_TIME =",value,"creationTime");return (Criteria)this;}public Criteria andCreationTimeNotEqualTo(Date value){addCriterion("CREATION_TIME <>",value,"creationTime");return (Criteria)this;}public Criteria andCreationTimeGreaterThan(Date value){addCriterion("CREATION_TIME >",value,"creationTime");return (Criteria)this;}public Criteria andCreationTimeGreaterThanOrEqualTo(Date value){addCriterion("CREATION_TIME >=",value,"creationTime");return (Criteria)this;}public Criteria andCreationTimeLessThan(Date value){addCriterion("CREATION_TIME <",value,"creationTime");return (Criteria)this;}public Criteria andCreationTimeLessThanOrEqualTo(Date value){addCriterion("CREATION_TIME <=",value,"creationTime");return (Criteria)this;}public Criteria andCreationTimeIn(List<Date> values){addCriterion("CREATION_TIME in",values,"creationTime");return (Criteria)this;}public Criteria andCreationTimeNotIn(List<Date> values){addCriterion("CREATION_TIME not in",values,"creationTime");return (Criteria)this;}public Criteria andCreationTimeBetween(Date value1,Date value2){addCriterion("CREATION_TIME between",value1,value2,"creationTime");return (Criteria)this;}public Criteria andCreationTimeNotBetween(Date value1,Date value2){addCriterion("CREATION_TIME not between",value1,value2,"creationTime");return (Criteria)this;}public Criteria andOtherIsNull(){addCriterion("OTHER is null");return (Criteria)this;}public Criteria andOtherIsNotNull(){addCriterion("OTHER is not null");return (Criteria)this;}public Criteria andOtherEqualTo(String value){addCriterion("OTHER =",value,"other");return (Criteria)this;}public Criteria andOtherNotEqualTo(String value){addCriterion("OTHER <>",value,"other");return (Criteria)this;}public Criteria andOtherGreaterThan(String value){addCriterion("OTHER >",value,"other");return (Criteria)this;}public Criteria andOtherGreaterThanOrEqualTo(String value){addCriterion("OTHER >=",value,"other");return (Criteria)this;}public Criteria andOtherLessThan(String value){addCriterion("OTHER <",value,"other");return (Criteria)this;}public Criteria andOtherLessThanOrEqualTo(String value){addCriterion("OTHER <=",value,"other");return (Criteria)this;}public Criteria andOtherLike(String value){addCriterion("OTHER like",value,"other");return (Criteria)this;}public Criteria andOtherNotLike(String value){addCriterion("OTHER not like",value,"other");return (Criteria)this;}public Criteria andOtherIn(List<String> values){addCriterion("OTHER in",values,"other");return (Criteria)this;}public Criteria andOtherNotIn(List<String> values){addCriterion("OTHER not in",values,"other");return (Criteria)this;}public Criteria andOtherBetween(String value1,String value2){addCriterion("OTHER between",value1,value2,"other");return (Criteria)this;}public Criteria andOtherNotBetween(String value1,String value2){addCriterion("OTHER not between",value1,value2,"other");return (Criteria)this;}public Criteria andRequiredIsNull(){addCriterion("REQUIRED is null");return (Criteria)this;}public Criteria andRequiredIsNotNull(){addCriterion("REQUIRED is not null");return (Criteria)this;}public Criteria andRequiredEqualTo(Byte value){addCriterion("REQUIRED =",value,"required");return (Criteria)this;}public Criteria andRequiredNotEqualTo(Byte value){addCriterion("REQUIRED <>",value,"required");return (Criteria)this;}public Criteria andRequiredGreaterThan(Byte value){addCriterion("REQUIRED >",value,"required");return (Criteria)this;}public Criteria andRequiredGreaterThanOrEqualTo(Byte value){addCriterion("REQUIRED >=",value,"required");return (Criteria)this;}public Criteria andRequiredLessThan(Byte value){addCriterion("REQUIRED <",value,"required");return (Criteria)this;}public Criteria andRequiredLessThanOrEqualTo(Byte value){addCriterion("REQUIRED <=",value,"required");return (Criteria)this;}public Criteria andRequiredIn(List<Byte> values){addCriterion("REQUIRED in",values,"required");return (Criteria)this;}public Criteria andRequiredNotIn(List<Byte> values){addCriterion("REQUIRED not in",values,"required");return (Criteria)this;}public Criteria andRequiredBetween(Byte value1,Byte value2){addCriterion("REQUIRED between",value1,value2,"required");return (Criteria)this;}public Criteria andRequiredNotBetween(Byte value1,Byte value2){addCriterion("REQUIRED not between",value1,value2,"required");return (Criteria)this;}public Criteria andCompIdIsNull(){addCriterion("COMP_ID is null");return (Criteria)this;}public Criteria andCompIdIsNotNull(){addCriterion("COMP_ID is not null");return (Criteria)this;}public Criteria andCompIdEqualTo(Integer value){addCriterion("COMP_ID =",value,"compId");return (Criteria)this;}public Criteria andCompIdNotEqualTo(Integer value){addCriterion("COMP_ID <>",value,"compId");return (Criteria)this;}public Criteria andCompIdGreaterThan(Integer value){addCriterion("COMP_ID >",value,"compId");return (Criteria)this;}public Criteria andCompIdGreaterThanOrEqualTo(Integer value){addCriterion("COMP_ID >=",value,"compId");return (Criteria)this;}public Criteria andCompIdLessThan(Integer value){addCriterion("COMP_ID <",value,"compId");return (Criteria)this;}public Criteria andCompIdLessThanOrEqualTo(Integer value){addCriterion("COMP_ID <=",value,"compId");return (Criteria)this;}public Criteria andCompIdIn(List<Integer> values){addCriterion("COMP_ID in",values,"compId");return (Criteria)this;}public Criteria andCompIdNotIn(List<Integer> values){addCriterion("COMP_ID not in",values,"compId");return (Criteria)this;}public Criteria andCompIdBetween(Integer value1,Integer value2){addCriterion("COMP_ID between",value1,value2,"compId");return (Criteria)this;}public Criteria andCompIdNotBetween(Integer value1,Integer value2){addCriterion("COMP_ID not between",value1,value2,"compId");return (Criteria)this;}public Criteria andIndexStatusIsNull(){addCriterion("INDEX_STATUS is null");return (Criteria)this;}public Criteria andIndexStatusIsNotNull(){addCriterion("INDEX_STATUS is not null");return (Criteria)this;}public Criteria andIndexStatusEqualTo(Byte value){addCriterion("INDEX_STATUS =",value,"indexStatus");return (Criteria)this;}public Criteria andIndexStatusNotEqualTo(Byte value){addCriterion("INDEX_STATUS <>",value,"indexStatus");return (Criteria)this;}public Criteria andIndexStatusGreaterThan(Byte value){addCriterion("INDEX_STATUS >",value,"indexStatus");return (Criteria)this;}public Criteria andIndexStatusGreaterThanOrEqualTo(Byte value){addCriterion("INDEX_STATUS >=",value,"indexStatus");return (Criteria)this;}public Criteria andIndexStatusLessThan(Byte value){addCriterion("INDEX_STATUS <",value,"indexStatus");return (Criteria)this;}public Criteria andIndexStatusLessThanOrEqualTo(Byte value){addCriterion("INDEX_STATUS <=",value,"indexStatus");return (Criteria)this;}public Criteria andIndexStatusIn(List<Byte> values){addCriterion("INDEX_STATUS in",values,"indexStatus");return (Criteria)this;}public Criteria andIndexStatusNotIn(List<Byte> values){addCriterion("INDEX_STATUS not in",values,"indexStatus");return (Criteria)this;}public Criteria andIndexStatusBetween(Byte value1,Byte value2){addCriterion("INDEX_STATUS between",value1,value2,"indexStatus");return (Criteria)this;}public Criteria andIndexStatusNotBetween(Byte value1,Byte value2){addCriterion("INDEX_STATUS not between",value1,value2,"indexStatus");return (Criteria)this;}public Criteria andFunDealFieldIsNull(){addCriterion("FUN_DEAL_FIELD is null");return (Criteria)this;}public Criteria andFunDealFieldIsNotNull(){addCriterion("FUN_DEAL_FIELD is not null");return (Criteria)this;}public Criteria andFunDealFieldEqualTo(String value){addCriterion("FUN_DEAL_FIELD =",value,"funDealField");return (Criteria)this;}public Criteria andFunDealFieldNotEqualTo(String value){addCriterion("FUN_DEAL_FIELD <>",value,"funDealField");return (Criteria)this;}public Criteria andFunDealFieldGreaterThan(String value){addCriterion("FUN_DEAL_FIELD >",value,"funDealField");return (Criteria)this;}public Criteria andFunDealFieldGreaterThanOrEqualTo(String value){addCriterion("FUN_DEAL_FIELD >=",value,"funDealField");return (Criteria)this;}public Criteria andFunDealFieldLessThan(String value){addCriterion("FUN_DEAL_FIELD <",value,"funDealField");return (Criteria)this;}public Criteria andFunDealFieldLessThanOrEqualTo(String value){addCriterion("FUN_DEAL_FIELD <=",value,"funDealField");return (Criteria)this;}public Criteria andFunDealFieldLike(String value){addCriterion("FUN_DEAL_FIELD like",value,"funDealField");return (Criteria)this;}public Criteria andFunDealFieldNotLike(String value){addCriterion("FUN_DEAL_FIELD not like",value,"funDealField");return (Criteria)this;}public Criteria andFunDealFieldIn(List<String> values){addCriterion("FUN_DEAL_FIELD in",values,"funDealField");return (Criteria)this;}public Criteria andFunDealFieldNotIn(List<String> values){addCriterion("FUN_DEAL_FIELD not in",values,"funDealField");return (Criteria)this;}public Criteria andFunDealFieldBetween(String value1,String value2){addCriterion("FUN_DEAL_FIELD between",value1,value2,"funDealField");return (Criteria)this;}public Criteria andFunDealFieldNotBetween(String value1,String value2){addCriterion("FUN_DEAL_FIELD not between",value1,value2,"funDealField");return (Criteria)this;}public Criteria andIndexGroupIsNull(){addCriterion("INDEX_GROUP is null");return (Criteria)this;}public Criteria andIndexGroupIsNotNull(){addCriterion("INDEX_GROUP is not null");return (Criteria)this;}public Criteria andIndexGroupEqualTo(Byte value){addCriterion("INDEX_GROUP =",value,"indexGroup");return (Criteria)this;}public Criteria andIndexGroupNotEqualTo(Byte value){addCriterion("INDEX_GROUP <>",value,"indexGroup");return (Criteria)this;}public Criteria andIndexGroupGreaterThan(Byte value){addCriterion("INDEX_GROUP >",value,"indexGroup");return (Criteria)this;}public Criteria andIndexGroupGreaterThanOrEqualTo(Byte value){addCriterion("INDEX_GROUP >=",value,"indexGroup");return (Criteria)this;}public Criteria andIndexGroupLessThan(Byte value){addCriterion("INDEX_GROUP <",value,"indexGroup");return (Criteria)this;}public Criteria andIndexGroupLessThanOrEqualTo(Byte value){addCriterion("INDEX_GROUP <=",value,"indexGroup");return (Criteria)this;}public Criteria andIndexGroupIn(List<Byte> values){addCriterion("INDEX_GROUP in",values,"indexGroup");return (Criteria)this;}public Criteria andIndexGroupNotIn(List<Byte> values){addCriterion("INDEX_GROUP not in",values,"indexGroup");return (Criteria)this;}public Criteria andIndexGroupBetween(Byte value1,Byte value2){addCriterion("INDEX_GROUP between",value1,value2,"indexGroup");return (Criteria)this;}public Criteria andIndexGroupNotBetween(Byte value1,Byte value2){addCriterion("INDEX_GROUP not between",value1,value2,"indexGroup");return (Criteria)this;}public Criteria andCaseTypeIsNull(){addCriterion("CASE_TYPE is null");return (Criteria)this;}public Criteria andCaseTypeIsNotNull(){addCriterion("CASE_TYPE is not null");return (Criteria)this;}public Criteria andCaseTypeEqualTo(Byte value){addCriterion("CASE_TYPE =",value,"caseType");return (Criteria)this;}public Criteria andCaseTypeNotEqualTo(Byte value){addCriterion("CASE_TYPE <>",value,"caseType");return (Criteria)this;}public Criteria andCaseTypeGreaterThan(Byte value){addCriterion("CASE_TYPE >",value,"caseType");return (Criteria)this;}public Criteria andCaseTypeGreaterThanOrEqualTo(Byte value){addCriterion("CASE_TYPE >=",value,"caseType");return (Criteria)this;}public Criteria andCaseTypeLessThan(Byte value){addCriterion("CASE_TYPE <",value,"caseType");return (Criteria)this;}public Criteria andCaseTypeLessThanOrEqualTo(Byte value){addCriterion("CASE_TYPE <=",value,"caseType");return (Criteria)this;}public Criteria andCaseTypeIn(List<Byte> values){addCriterion("CASE_TYPE in",values,"caseType");return (Criteria)this;}public Criteria andCaseTypeNotIn(List<Byte> values){addCriterion("CASE_TYPE not in",values,"caseType");return (Criteria)this;}public Criteria andCaseTypeBetween(Byte value1,Byte value2){addCriterion("CASE_TYPE between",value1,value2,"caseType");return (Criteria)this;}public Criteria andCaseTypeNotBetween(Byte value1,Byte value2){addCriterion("CASE_TYPE not between",value1,value2,"caseType");return (Criteria)this;}public Criteria andUniqueKeyIsNull(){addCriterion("UNIQUE_KEY is null");return (Criteria)this;}public Criteria andUniqueKeyIsNotNull(){addCriterion("UNIQUE_KEY is not null");return (Criteria)this;}public Criteria andUniqueKeyEqualTo(String value){addCriterion("UNIQUE_KEY =",value,"uniqueKey");return (Criteria)this;}public Criteria andUniqueKeyNotEqualTo(String value){addCriterion("UNIQUE_KEY <>",value,"uniqueKey");return (Criteria)this;}public Criteria andUniqueKeyGreaterThan(String value){addCriterion("UNIQUE_KEY >",value,"uniqueKey");return (Criteria)this;}public Criteria andUniqueKeyGreaterThanOrEqualTo(String value){addCriterion("UNIQUE_KEY >=",value,"uniqueKey");return (Criteria)this;}public Criteria andUniqueKeyLessThan(String value){addCriterion("UNIQUE_KEY <",value,"uniqueKey");return (Criteria)this;}public Criteria andUniqueKeyLessThanOrEqualTo(String value){addCriterion("UNIQUE_KEY <=",value,"uniqueKey");return (Criteria)this;}public Criteria andUniqueKeyLike(String value){addCriterion("UNIQUE_KEY like",value,"uniqueKey");return (Criteria)this;}public Criteria andUniqueKeyNotLike(String value){addCriterion("UNIQUE_KEY not like",value,"uniqueKey");return (Criteria)this;}public Criteria andUniqueKeyIn(List<String> values){addCriterion("UNIQUE_KEY in",values,"uniqueKey");return (Criteria)this;}public Criteria andUniqueKeyNotIn(List<String> values){addCriterion("UNIQUE_KEY not in",values,"uniqueKey");return (Criteria)this;}public Criteria andUniqueKeyBetween(String value1,String value2){addCriterion("UNIQUE_KEY between",value1,value2,"uniqueKey");return (Criteria)this;}public Criteria andUniqueKeyNotBetween(String value1,String value2){addCriterion("UNIQUE_KEY not between",value1,value2,"uniqueKey");return (Criteria)this;}public Criteria andTemplateIdIsNull(){addCriterion("TEMPLATE_ID is null");return (Criteria)this;}public Criteria andTemplateIdIsNotNull(){addCriterion("TEMPLATE_ID is not null");return (Criteria)this;}public Criteria andTemplateIdEqualTo(Integer value){addCriterion("TEMPLATE_ID =",value,"templateId");return (Criteria)this;}public Criteria andTemplateIdNotEqualTo(Integer value){addCriterion("TEMPLATE_ID <>",value,"templateId");return (Criteria)this;}public Criteria andTemplateIdGreaterThan(Integer value){addCriterion("TEMPLATE_ID >",value,"templateId");return (Criteria)this;}public Criteria andTemplateIdGreaterThanOrEqualTo(Integer value){addCriterion("TEMPLATE_ID >=",value,"templateId");return (Criteria)this;}public Criteria andTemplateIdLessThan(Integer value){addCriterion("TEMPLATE_ID <",value,"templateId");return (Criteria)this;}public Criteria andTemplateIdLessThanOrEqualTo(Integer value){addCriterion("TEMPLATE_ID <=",value,"templateId");return (Criteria)this;}public Criteria andTemplateIdIn(List<Integer> values){addCriterion("TEMPLATE_ID in",values,"templateId");return (Criteria)this;}public Criteria andTemplateIdNotIn(List<Integer> values){addCriterion("TEMPLATE_ID not in",values,"templateId");return (Criteria)this;}public Criteria andTemplateIdBetween(Integer value1,Integer value2){addCriterion("TEMPLATE_ID between",value1,value2,"templateId");return (Criteria)this;}public Criteria andTemplateIdNotBetween(Integer value1,Integer value2){addCriterion("TEMPLATE_ID not between",value1,value2,"templateId");return (Criteria)this;}public Criteria andIndexSeqIsNull(){addCriterion("INDEX_SEQ is null");return (Criteria)this;}public Criteria andIndexSeqIsNotNull(){addCriterion("INDEX_SEQ is not null");return (Criteria)this;}public Criteria andIndexSeqEqualTo(Integer value){addCriterion("INDEX_SEQ =",value,"indexSeq");return (Criteria)this;}public Criteria andIndexSeqNotEqualTo(Integer value){addCriterion("INDEX_SEQ <>",value,"indexSeq");return (Criteria)this;}public Criteria andIndexSeqGreaterThan(Integer value){addCriterion("INDEX_SEQ >",value,"indexSeq");return (Criteria)this;}public Criteria andIndexSeqGreaterThanOrEqualTo(Integer value){addCriterion("INDEX_SEQ >=",value,"indexSeq");return (Criteria)this;}public Criteria andIndexSeqLessThan(Integer value){addCriterion("INDEX_SEQ <",value,"indexSeq");return (Criteria)this;}public Criteria andIndexSeqLessThanOrEqualTo(Integer value){addCriterion("INDEX_SEQ <=",value,"indexSeq");return (Criteria)this;}public Criteria andIndexSeqIn(List<Integer> values){addCriterion("INDEX_SEQ in",values,"indexSeq");return (Criteria)this;}public Criteria andIndexSeqNotIn(List<Integer> values){addCriterion("INDEX_SEQ not in",values,"indexSeq");return (Criteria)this;}public Criteria andIndexSeqBetween(Integer value1,Integer value2){addCriterion("INDEX_SEQ between",value1,value2,"indexSeq");return (Criteria)this;}public Criteria andIndexSeqNotBetween(Integer value1,Integer value2){addCriterion("INDEX_SEQ not between",value1,value2,"indexSeq");return (Criteria)this;}}

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