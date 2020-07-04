package com.myfun.repository.erpdb.po;

import com.myfun.repository.support.generator.shard.ShardDb;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ErpBuildAllotExample extends ShardDb {
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
	 */public ErpBuildAllotExample(){oredCriteria=new ArrayList<Criteria>();}

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
	 */protected abstract static class GeneratedCriteria {protected List<Criterion> criteria;protected GeneratedCriteria(){super();criteria=new ArrayList<Criterion>();}public boolean isValid(){return criteria.size() > 0;}public List<Criterion> getAllCriteria(){return criteria;}public List<Criterion> getCriteria(){return criteria;}protected void addCriterion(String condition){if (condition == null){throw new RuntimeException("Value for condition cannot be null");}criteria.add(new Criterion(condition));}protected void addCriterion(String condition,Object value,String property){if (value == null){throw new RuntimeException("Value for " + property + " cannot be null");}criteria.add(new Criterion(condition,value));}protected void addCriterion(String condition,Object value1,Object value2,String property){if (value1 == null || value2 == null){throw new RuntimeException("Between values for " + property + " cannot be null");}criteria.add(new Criterion(condition,value1,value2));}public Criteria andIdIsNull(){addCriterion("id is null");return (Criteria)this;}public Criteria andIdIsNotNull(){addCriterion("id is not null");return (Criteria)this;}public Criteria andIdEqualTo(Integer value){addCriterion("id =",value,"id");return (Criteria)this;}public Criteria andIdNotEqualTo(Integer value){addCriterion("id <>",value,"id");return (Criteria)this;}public Criteria andIdGreaterThan(Integer value){addCriterion("id >",value,"id");return (Criteria)this;}public Criteria andIdGreaterThanOrEqualTo(Integer value){addCriterion("id >=",value,"id");return (Criteria)this;}public Criteria andIdLessThan(Integer value){addCriterion("id <",value,"id");return (Criteria)this;}public Criteria andIdLessThanOrEqualTo(Integer value){addCriterion("id <=",value,"id");return (Criteria)this;}public Criteria andIdIn(List<Integer> values){addCriterion("id in",values,"id");return (Criteria)this;}public Criteria andIdNotIn(List<Integer> values){addCriterion("id not in",values,"id");return (Criteria)this;}public Criteria andIdBetween(Integer value1,Integer value2){addCriterion("id between",value1,value2,"id");return (Criteria)this;}public Criteria andIdNotBetween(Integer value1,Integer value2){addCriterion("id not between",value1,value2,"id");return (Criteria)this;}public Criteria andBuildIdIsNull(){addCriterion("build_id is null");return (Criteria)this;}public Criteria andBuildIdIsNotNull(){addCriterion("build_id is not null");return (Criteria)this;}public Criteria andBuildIdEqualTo(Integer value){addCriterion("build_id =",value,"buildId");return (Criteria)this;}public Criteria andBuildIdNotEqualTo(Integer value){addCriterion("build_id <>",value,"buildId");return (Criteria)this;}public Criteria andBuildIdGreaterThan(Integer value){addCriterion("build_id >",value,"buildId");return (Criteria)this;}public Criteria andBuildIdGreaterThanOrEqualTo(Integer value){addCriterion("build_id >=",value,"buildId");return (Criteria)this;}public Criteria andBuildIdLessThan(Integer value){addCriterion("build_id <",value,"buildId");return (Criteria)this;}public Criteria andBuildIdLessThanOrEqualTo(Integer value){addCriterion("build_id <=",value,"buildId");return (Criteria)this;}public Criteria andBuildIdIn(List<Integer> values){addCriterion("build_id in",values,"buildId");return (Criteria)this;}public Criteria andBuildIdNotIn(List<Integer> values){addCriterion("build_id not in",values,"buildId");return (Criteria)this;}public Criteria andBuildIdBetween(Integer value1,Integer value2){addCriterion("build_id between",value1,value2,"buildId");return (Criteria)this;}public Criteria andBuildIdNotBetween(Integer value1,Integer value2){addCriterion("build_id not between",value1,value2,"buildId");return (Criteria)this;}public Criteria andCompIdIsNull(){addCriterion("comp_id is null");return (Criteria)this;}public Criteria andCompIdIsNotNull(){addCriterion("comp_id is not null");return (Criteria)this;}public Criteria andCompIdEqualTo(Integer value){addCriterion("comp_id =",value,"compId");return (Criteria)this;}public Criteria andCompIdNotEqualTo(Integer value){addCriterion("comp_id <>",value,"compId");return (Criteria)this;}public Criteria andCompIdGreaterThan(Integer value){addCriterion("comp_id >",value,"compId");return (Criteria)this;}public Criteria andCompIdGreaterThanOrEqualTo(Integer value){addCriterion("comp_id >=",value,"compId");return (Criteria)this;}public Criteria andCompIdLessThan(Integer value){addCriterion("comp_id <",value,"compId");return (Criteria)this;}public Criteria andCompIdLessThanOrEqualTo(Integer value){addCriterion("comp_id <=",value,"compId");return (Criteria)this;}public Criteria andCompIdIn(List<Integer> values){addCriterion("comp_id in",values,"compId");return (Criteria)this;}public Criteria andCompIdNotIn(List<Integer> values){addCriterion("comp_id not in",values,"compId");return (Criteria)this;}public Criteria andCompIdBetween(Integer value1,Integer value2){addCriterion("comp_id between",value1,value2,"compId");return (Criteria)this;}public Criteria andCompIdNotBetween(Integer value1,Integer value2){addCriterion("comp_id not between",value1,value2,"compId");return (Criteria)this;}public Criteria andDeptIdIsNull(){addCriterion("dept_id is null");return (Criteria)this;}public Criteria andDeptIdIsNotNull(){addCriterion("dept_id is not null");return (Criteria)this;}public Criteria andDeptIdEqualTo(Integer value){addCriterion("dept_id =",value,"deptId");return (Criteria)this;}public Criteria andDeptIdNotEqualTo(Integer value){addCriterion("dept_id <>",value,"deptId");return (Criteria)this;}public Criteria andDeptIdGreaterThan(Integer value){addCriterion("dept_id >",value,"deptId");return (Criteria)this;}public Criteria andDeptIdGreaterThanOrEqualTo(Integer value){addCriterion("dept_id >=",value,"deptId");return (Criteria)this;}public Criteria andDeptIdLessThan(Integer value){addCriterion("dept_id <",value,"deptId");return (Criteria)this;}public Criteria andDeptIdLessThanOrEqualTo(Integer value){addCriterion("dept_id <=",value,"deptId");return (Criteria)this;}public Criteria andDeptIdIn(List<Integer> values){addCriterion("dept_id in",values,"deptId");return (Criteria)this;}public Criteria andDeptIdNotIn(List<Integer> values){addCriterion("dept_id not in",values,"deptId");return (Criteria)this;}public Criteria andDeptIdBetween(Integer value1,Integer value2){addCriterion("dept_id between",value1,value2,"deptId");return (Criteria)this;}public Criteria andDeptIdNotBetween(Integer value1,Integer value2){addCriterion("dept_id not between",value1,value2,"deptId");return (Criteria)this;}public Criteria andCreateTimeIsNull(){addCriterion("create_time is null");return (Criteria)this;}public Criteria andCreateTimeIsNotNull(){addCriterion("create_time is not null");return (Criteria)this;}public Criteria andCreateTimeEqualTo(Date value){addCriterion("create_time =",value,"createTime");return (Criteria)this;}public Criteria andCreateTimeNotEqualTo(Date value){addCriterion("create_time <>",value,"createTime");return (Criteria)this;}public Criteria andCreateTimeGreaterThan(Date value){addCriterion("create_time >",value,"createTime");return (Criteria)this;}public Criteria andCreateTimeGreaterThanOrEqualTo(Date value){addCriterion("create_time >=",value,"createTime");return (Criteria)this;}public Criteria andCreateTimeLessThan(Date value){addCriterion("create_time <",value,"createTime");return (Criteria)this;}public Criteria andCreateTimeLessThanOrEqualTo(Date value){addCriterion("create_time <=",value,"createTime");return (Criteria)this;}public Criteria andCreateTimeIn(List<Date> values){addCriterion("create_time in",values,"createTime");return (Criteria)this;}public Criteria andCreateTimeNotIn(List<Date> values){addCriterion("create_time not in",values,"createTime");return (Criteria)this;}public Criteria andCreateTimeBetween(Date value1,Date value2){addCriterion("create_time between",value1,value2,"createTime");return (Criteria)this;}public Criteria andCreateTimeNotBetween(Date value1,Date value2){addCriterion("create_time not between",value1,value2,"createTime");return (Criteria)this;}public Criteria andIsDelIsNull(){addCriterion("is_del is null");return (Criteria)this;}public Criteria andIsDelIsNotNull(){addCriterion("is_del is not null");return (Criteria)this;}public Criteria andIsDelEqualTo(Byte value){addCriterion("is_del =",value,"isDel");return (Criteria)this;}public Criteria andIsDelNotEqualTo(Byte value){addCriterion("is_del <>",value,"isDel");return (Criteria)this;}public Criteria andIsDelGreaterThan(Byte value){addCriterion("is_del >",value,"isDel");return (Criteria)this;}public Criteria andIsDelGreaterThanOrEqualTo(Byte value){addCriterion("is_del >=",value,"isDel");return (Criteria)this;}public Criteria andIsDelLessThan(Byte value){addCriterion("is_del <",value,"isDel");return (Criteria)this;}public Criteria andIsDelLessThanOrEqualTo(Byte value){addCriterion("is_del <=",value,"isDel");return (Criteria)this;}public Criteria andIsDelIn(List<Byte> values){addCriterion("is_del in",values,"isDel");return (Criteria)this;}public Criteria andIsDelNotIn(List<Byte> values){addCriterion("is_del not in",values,"isDel");return (Criteria)this;}public Criteria andIsDelBetween(Byte value1,Byte value2){addCriterion("is_del between",value1,value2,"isDel");return (Criteria)this;}public Criteria andIsDelNotBetween(Byte value1,Byte value2){addCriterion("is_del not between",value1,value2,"isDel");return (Criteria)this;}public Criteria andCreateUserIsNull(){addCriterion("create_user is null");return (Criteria)this;}public Criteria andCreateUserIsNotNull(){addCriterion("create_user is not null");return (Criteria)this;}public Criteria andCreateUserEqualTo(String value){addCriterion("create_user =",value,"createUser");return (Criteria)this;}public Criteria andCreateUserNotEqualTo(String value){addCriterion("create_user <>",value,"createUser");return (Criteria)this;}public Criteria andCreateUserGreaterThan(String value){addCriterion("create_user >",value,"createUser");return (Criteria)this;}public Criteria andCreateUserGreaterThanOrEqualTo(String value){addCriterion("create_user >=",value,"createUser");return (Criteria)this;}public Criteria andCreateUserLessThan(String value){addCriterion("create_user <",value,"createUser");return (Criteria)this;}public Criteria andCreateUserLessThanOrEqualTo(String value){addCriterion("create_user <=",value,"createUser");return (Criteria)this;}public Criteria andCreateUserLike(String value){addCriterion("create_user like",value,"createUser");return (Criteria)this;}public Criteria andCreateUserNotLike(String value){addCriterion("create_user not like",value,"createUser");return (Criteria)this;}public Criteria andCreateUserIn(List<String> values){addCriterion("create_user in",values,"createUser");return (Criteria)this;}public Criteria andCreateUserNotIn(List<String> values){addCriterion("create_user not in",values,"createUser");return (Criteria)this;}public Criteria andCreateUserBetween(String value1,String value2){addCriterion("create_user between",value1,value2,"createUser");return (Criteria)this;}public Criteria andCreateUserNotBetween(String value1,String value2){addCriterion("create_user not between",value1,value2,"createUser");return (Criteria)this;}public Criteria andCreateUserIdIsNull(){addCriterion("create_user_id is null");return (Criteria)this;}public Criteria andCreateUserIdIsNotNull(){addCriterion("create_user_id is not null");return (Criteria)this;}public Criteria andCreateUserIdEqualTo(Integer value){addCriterion("create_user_id =",value,"createUserId");return (Criteria)this;}public Criteria andCreateUserIdNotEqualTo(Integer value){addCriterion("create_user_id <>",value,"createUserId");return (Criteria)this;}public Criteria andCreateUserIdGreaterThan(Integer value){addCriterion("create_user_id >",value,"createUserId");return (Criteria)this;}public Criteria andCreateUserIdGreaterThanOrEqualTo(Integer value){addCriterion("create_user_id >=",value,"createUserId");return (Criteria)this;}public Criteria andCreateUserIdLessThan(Integer value){addCriterion("create_user_id <",value,"createUserId");return (Criteria)this;}public Criteria andCreateUserIdLessThanOrEqualTo(Integer value){addCriterion("create_user_id <=",value,"createUserId");return (Criteria)this;}public Criteria andCreateUserIdIn(List<Integer> values){addCriterion("create_user_id in",values,"createUserId");return (Criteria)this;}public Criteria andCreateUserIdNotIn(List<Integer> values){addCriterion("create_user_id not in",values,"createUserId");return (Criteria)this;}public Criteria andCreateUserIdBetween(Integer value1,Integer value2){addCriterion("create_user_id between",value1,value2,"createUserId");return (Criteria)this;}public Criteria andCreateUserIdNotBetween(Integer value1,Integer value2){addCriterion("create_user_id not between",value1,value2,"createUserId");return (Criteria)this;}public Criteria andDeptNameIsNull(){addCriterion("dept_name is null");return (Criteria)this;}public Criteria andDeptNameIsNotNull(){addCriterion("dept_name is not null");return (Criteria)this;}public Criteria andDeptNameEqualTo(String value){addCriterion("dept_name =",value,"deptName");return (Criteria)this;}public Criteria andDeptNameNotEqualTo(String value){addCriterion("dept_name <>",value,"deptName");return (Criteria)this;}public Criteria andDeptNameGreaterThan(String value){addCriterion("dept_name >",value,"deptName");return (Criteria)this;}public Criteria andDeptNameGreaterThanOrEqualTo(String value){addCriterion("dept_name >=",value,"deptName");return (Criteria)this;}public Criteria andDeptNameLessThan(String value){addCriterion("dept_name <",value,"deptName");return (Criteria)this;}public Criteria andDeptNameLessThanOrEqualTo(String value){addCriterion("dept_name <=",value,"deptName");return (Criteria)this;}public Criteria andDeptNameLike(String value){addCriterion("dept_name like",value,"deptName");return (Criteria)this;}public Criteria andDeptNameNotLike(String value){addCriterion("dept_name not like",value,"deptName");return (Criteria)this;}public Criteria andDeptNameIn(List<String> values){addCriterion("dept_name in",values,"deptName");return (Criteria)this;}public Criteria andDeptNameNotIn(List<String> values){addCriterion("dept_name not in",values,"deptName");return (Criteria)this;}public Criteria andDeptNameBetween(String value1,String value2){addCriterion("dept_name between",value1,value2,"deptName");return (Criteria)this;}public Criteria andDeptNameNotBetween(String value1,String value2){addCriterion("dept_name not between",value1,value2,"deptName");return (Criteria)this;}}

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