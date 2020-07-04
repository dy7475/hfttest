package com.myfun.repository.erpdb.po;

import com.myfun.repository.support.generator.shard.ShardDb;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ErpBuildLogExample extends ShardDb {
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
	 */public ErpBuildLogExample(){oredCriteria=new ArrayList<Criteria>();}

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
	 */protected abstract static class GeneratedCriteria {protected List<Criterion> criteria;protected GeneratedCriteria(){super();criteria=new ArrayList<Criterion>();}public boolean isValid(){return criteria.size() > 0;}public List<Criterion> getAllCriteria(){return criteria;}public List<Criterion> getCriteria(){return criteria;}protected void addCriterion(String condition){if (condition == null){throw new RuntimeException("Value for condition cannot be null");}criteria.add(new Criterion(condition));}protected void addCriterion(String condition,Object value,String property){if (value == null){throw new RuntimeException("Value for " + property + " cannot be null");}criteria.add(new Criterion(condition,value));}protected void addCriterion(String condition,Object value1,Object value2,String property){if (value1 == null || value2 == null){throw new RuntimeException("Between values for " + property + " cannot be null");}criteria.add(new Criterion(condition,value1,value2));}public Criteria andIdIsNull(){addCriterion("id is null");return (Criteria)this;}public Criteria andIdIsNotNull(){addCriterion("id is not null");return (Criteria)this;}public Criteria andIdEqualTo(Integer value){addCriterion("id =",value,"id");return (Criteria)this;}public Criteria andIdNotEqualTo(Integer value){addCriterion("id <>",value,"id");return (Criteria)this;}public Criteria andIdGreaterThan(Integer value){addCriterion("id >",value,"id");return (Criteria)this;}public Criteria andIdGreaterThanOrEqualTo(Integer value){addCriterion("id >=",value,"id");return (Criteria)this;}public Criteria andIdLessThan(Integer value){addCriterion("id <",value,"id");return (Criteria)this;}public Criteria andIdLessThanOrEqualTo(Integer value){addCriterion("id <=",value,"id");return (Criteria)this;}public Criteria andIdIn(List<Integer> values){addCriterion("id in",values,"id");return (Criteria)this;}public Criteria andIdNotIn(List<Integer> values){addCriterion("id not in",values,"id");return (Criteria)this;}public Criteria andIdBetween(Integer value1,Integer value2){addCriterion("id between",value1,value2,"id");return (Criteria)this;}public Criteria andIdNotBetween(Integer value1,Integer value2){addCriterion("id not between",value1,value2,"id");return (Criteria)this;}public Criteria andTrackTimeIsNull(){addCriterion("track_time is null");return (Criteria)this;}public Criteria andTrackTimeIsNotNull(){addCriterion("track_time is not null");return (Criteria)this;}public Criteria andTrackTimeEqualTo(Date value){addCriterion("track_time =",value,"trackTime");return (Criteria)this;}public Criteria andTrackTimeNotEqualTo(Date value){addCriterion("track_time <>",value,"trackTime");return (Criteria)this;}public Criteria andTrackTimeGreaterThan(Date value){addCriterion("track_time >",value,"trackTime");return (Criteria)this;}public Criteria andTrackTimeGreaterThanOrEqualTo(Date value){addCriterion("track_time >=",value,"trackTime");return (Criteria)this;}public Criteria andTrackTimeLessThan(Date value){addCriterion("track_time <",value,"trackTime");return (Criteria)this;}public Criteria andTrackTimeLessThanOrEqualTo(Date value){addCriterion("track_time <=",value,"trackTime");return (Criteria)this;}public Criteria andTrackTimeIn(List<Date> values){addCriterion("track_time in",values,"trackTime");return (Criteria)this;}public Criteria andTrackTimeNotIn(List<Date> values){addCriterion("track_time not in",values,"trackTime");return (Criteria)this;}public Criteria andTrackTimeBetween(Date value1,Date value2){addCriterion("track_time between",value1,value2,"trackTime");return (Criteria)this;}public Criteria andTrackTimeNotBetween(Date value1,Date value2){addCriterion("track_time not between",value1,value2,"trackTime");return (Criteria)this;}public Criteria andTrackContenIsNull(){addCriterion("track_conten is null");return (Criteria)this;}public Criteria andTrackContenIsNotNull(){addCriterion("track_conten is not null");return (Criteria)this;}public Criteria andTrackContenEqualTo(String value){addCriterion("track_conten =",value,"trackConten");return (Criteria)this;}public Criteria andTrackContenNotEqualTo(String value){addCriterion("track_conten <>",value,"trackConten");return (Criteria)this;}public Criteria andTrackContenGreaterThan(String value){addCriterion("track_conten >",value,"trackConten");return (Criteria)this;}public Criteria andTrackContenGreaterThanOrEqualTo(String value){addCriterion("track_conten >=",value,"trackConten");return (Criteria)this;}public Criteria andTrackContenLessThan(String value){addCriterion("track_conten <",value,"trackConten");return (Criteria)this;}public Criteria andTrackContenLessThanOrEqualTo(String value){addCriterion("track_conten <=",value,"trackConten");return (Criteria)this;}public Criteria andTrackContenLike(String value){addCriterion("track_conten like",value,"trackConten");return (Criteria)this;}public Criteria andTrackContenNotLike(String value){addCriterion("track_conten not like",value,"trackConten");return (Criteria)this;}public Criteria andTrackContenIn(List<String> values){addCriterion("track_conten in",values,"trackConten");return (Criteria)this;}public Criteria andTrackContenNotIn(List<String> values){addCriterion("track_conten not in",values,"trackConten");return (Criteria)this;}public Criteria andTrackContenBetween(String value1,String value2){addCriterion("track_conten between",value1,value2,"trackConten");return (Criteria)this;}public Criteria andTrackContenNotBetween(String value1,String value2){addCriterion("track_conten not between",value1,value2,"trackConten");return (Criteria)this;}public Criteria andUpdateUserIsNull(){addCriterion("update_user is null");return (Criteria)this;}public Criteria andUpdateUserIsNotNull(){addCriterion("update_user is not null");return (Criteria)this;}public Criteria andUpdateUserEqualTo(String value){addCriterion("update_user =",value,"updateUser");return (Criteria)this;}public Criteria andUpdateUserNotEqualTo(String value){addCriterion("update_user <>",value,"updateUser");return (Criteria)this;}public Criteria andUpdateUserGreaterThan(String value){addCriterion("update_user >",value,"updateUser");return (Criteria)this;}public Criteria andUpdateUserGreaterThanOrEqualTo(String value){addCriterion("update_user >=",value,"updateUser");return (Criteria)this;}public Criteria andUpdateUserLessThan(String value){addCriterion("update_user <",value,"updateUser");return (Criteria)this;}public Criteria andUpdateUserLessThanOrEqualTo(String value){addCriterion("update_user <=",value,"updateUser");return (Criteria)this;}public Criteria andUpdateUserLike(String value){addCriterion("update_user like",value,"updateUser");return (Criteria)this;}public Criteria andUpdateUserNotLike(String value){addCriterion("update_user not like",value,"updateUser");return (Criteria)this;}public Criteria andUpdateUserIn(List<String> values){addCriterion("update_user in",values,"updateUser");return (Criteria)this;}public Criteria andUpdateUserNotIn(List<String> values){addCriterion("update_user not in",values,"updateUser");return (Criteria)this;}public Criteria andUpdateUserBetween(String value1,String value2){addCriterion("update_user between",value1,value2,"updateUser");return (Criteria)this;}public Criteria andUpdateUserNotBetween(String value1,String value2){addCriterion("update_user not between",value1,value2,"updateUser");return (Criteria)this;}public Criteria andUpdateUserIdIsNull(){addCriterion("update_user_id is null");return (Criteria)this;}public Criteria andUpdateUserIdIsNotNull(){addCriterion("update_user_id is not null");return (Criteria)this;}public Criteria andUpdateUserIdEqualTo(Integer value){addCriterion("update_user_id =",value,"updateUserId");return (Criteria)this;}public Criteria andUpdateUserIdNotEqualTo(Integer value){addCriterion("update_user_id <>",value,"updateUserId");return (Criteria)this;}public Criteria andUpdateUserIdGreaterThan(Integer value){addCriterion("update_user_id >",value,"updateUserId");return (Criteria)this;}public Criteria andUpdateUserIdGreaterThanOrEqualTo(Integer value){addCriterion("update_user_id >=",value,"updateUserId");return (Criteria)this;}public Criteria andUpdateUserIdLessThan(Integer value){addCriterion("update_user_id <",value,"updateUserId");return (Criteria)this;}public Criteria andUpdateUserIdLessThanOrEqualTo(Integer value){addCriterion("update_user_id <=",value,"updateUserId");return (Criteria)this;}public Criteria andUpdateUserIdIn(List<Integer> values){addCriterion("update_user_id in",values,"updateUserId");return (Criteria)this;}public Criteria andUpdateUserIdNotIn(List<Integer> values){addCriterion("update_user_id not in",values,"updateUserId");return (Criteria)this;}public Criteria andUpdateUserIdBetween(Integer value1,Integer value2){addCriterion("update_user_id between",value1,value2,"updateUserId");return (Criteria)this;}public Criteria andUpdateUserIdNotBetween(Integer value1,Integer value2){addCriterion("update_user_id not between",value1,value2,"updateUserId");return (Criteria)this;}public Criteria andCreationTimeIsNull(){addCriterion("creation_time is null");return (Criteria)this;}public Criteria andCreationTimeIsNotNull(){addCriterion("creation_time is not null");return (Criteria)this;}public Criteria andCreationTimeEqualTo(Date value){addCriterion("creation_time =",value,"creationTime");return (Criteria)this;}public Criteria andCreationTimeNotEqualTo(Date value){addCriterion("creation_time <>",value,"creationTime");return (Criteria)this;}public Criteria andCreationTimeGreaterThan(Date value){addCriterion("creation_time >",value,"creationTime");return (Criteria)this;}public Criteria andCreationTimeGreaterThanOrEqualTo(Date value){addCriterion("creation_time >=",value,"creationTime");return (Criteria)this;}public Criteria andCreationTimeLessThan(Date value){addCriterion("creation_time <",value,"creationTime");return (Criteria)this;}public Criteria andCreationTimeLessThanOrEqualTo(Date value){addCriterion("creation_time <=",value,"creationTime");return (Criteria)this;}public Criteria andCreationTimeIn(List<Date> values){addCriterion("creation_time in",values,"creationTime");return (Criteria)this;}public Criteria andCreationTimeNotIn(List<Date> values){addCriterion("creation_time not in",values,"creationTime");return (Criteria)this;}public Criteria andCreationTimeBetween(Date value1,Date value2){addCriterion("creation_time between",value1,value2,"creationTime");return (Criteria)this;}public Criteria andCreationTimeNotBetween(Date value1,Date value2){addCriterion("creation_time not between",value1,value2,"creationTime");return (Criteria)this;}public Criteria andBuildIdIsNull(){addCriterion("build_id is null");return (Criteria)this;}public Criteria andBuildIdIsNotNull(){addCriterion("build_id is not null");return (Criteria)this;}public Criteria andBuildIdEqualTo(Integer value){addCriterion("build_id =",value,"buildId");return (Criteria)this;}public Criteria andBuildIdNotEqualTo(Integer value){addCriterion("build_id <>",value,"buildId");return (Criteria)this;}public Criteria andBuildIdGreaterThan(Integer value){addCriterion("build_id >",value,"buildId");return (Criteria)this;}public Criteria andBuildIdGreaterThanOrEqualTo(Integer value){addCriterion("build_id >=",value,"buildId");return (Criteria)this;}public Criteria andBuildIdLessThan(Integer value){addCriterion("build_id <",value,"buildId");return (Criteria)this;}public Criteria andBuildIdLessThanOrEqualTo(Integer value){addCriterion("build_id <=",value,"buildId");return (Criteria)this;}public Criteria andBuildIdIn(List<Integer> values){addCriterion("build_id in",values,"buildId");return (Criteria)this;}public Criteria andBuildIdNotIn(List<Integer> values){addCriterion("build_id not in",values,"buildId");return (Criteria)this;}public Criteria andBuildIdBetween(Integer value1,Integer value2){addCriterion("build_id between",value1,value2,"buildId");return (Criteria)this;}public Criteria andBuildIdNotBetween(Integer value1,Integer value2){addCriterion("build_id not between",value1,value2,"buildId");return (Criteria)this;}public Criteria andCompIdIsNull(){addCriterion("comp_id is null");return (Criteria)this;}public Criteria andCompIdIsNotNull(){addCriterion("comp_id is not null");return (Criteria)this;}public Criteria andCompIdEqualTo(Integer value){addCriterion("comp_id =",value,"compId");return (Criteria)this;}public Criteria andCompIdNotEqualTo(Integer value){addCriterion("comp_id <>",value,"compId");return (Criteria)this;}public Criteria andCompIdGreaterThan(Integer value){addCriterion("comp_id >",value,"compId");return (Criteria)this;}public Criteria andCompIdGreaterThanOrEqualTo(Integer value){addCriterion("comp_id >=",value,"compId");return (Criteria)this;}public Criteria andCompIdLessThan(Integer value){addCriterion("comp_id <",value,"compId");return (Criteria)this;}public Criteria andCompIdLessThanOrEqualTo(Integer value){addCriterion("comp_id <=",value,"compId");return (Criteria)this;}public Criteria andCompIdIn(List<Integer> values){addCriterion("comp_id in",values,"compId");return (Criteria)this;}public Criteria andCompIdNotIn(List<Integer> values){addCriterion("comp_id not in",values,"compId");return (Criteria)this;}public Criteria andCompIdBetween(Integer value1,Integer value2){addCriterion("comp_id between",value1,value2,"compId");return (Criteria)this;}public Criteria andCompIdNotBetween(Integer value1,Integer value2){addCriterion("comp_id not between",value1,value2,"compId");return (Criteria)this;}}

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