package com.myfun.repository.erpdb.po;

import com.myfun.repository.support.generator.shard.ShardDb;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;

public class ErpAuditUserTransmitLogExample extends ShardDb {
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
	 */public ErpAuditUserTransmitLogExample(){oredCriteria=new ArrayList<Criteria>();}

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
	 */protected abstract static class GeneratedCriteria {protected List<Criterion> criteria;protected GeneratedCriteria(){super();criteria=new ArrayList<Criterion>();}public boolean isValid(){return criteria.size() > 0;}public List<Criterion> getAllCriteria(){return criteria;}public List<Criterion> getCriteria(){return criteria;}protected void addCriterion(String condition){if (condition == null){throw new RuntimeException("Value for condition cannot be null");}criteria.add(new Criterion(condition));}protected void addCriterion(String condition,Object value,String property){if (value == null){throw new RuntimeException("Value for " + property + " cannot be null");}criteria.add(new Criterion(condition,value));}protected void addCriterion(String condition,Object value1,Object value2,String property){if (value1 == null || value2 == null){throw new RuntimeException("Between values for " + property + " cannot be null");}criteria.add(new Criterion(condition,value1,value2));}public Criteria andLogIdIsNull(){addCriterion("LOG_ID is null");return (Criteria)this;}public Criteria andLogIdIsNotNull(){addCriterion("LOG_ID is not null");return (Criteria)this;}public Criteria andLogIdEqualTo(Integer value){addCriterion("LOG_ID =",value,"logId");return (Criteria)this;}public Criteria andLogIdNotEqualTo(Integer value){addCriterion("LOG_ID <>",value,"logId");return (Criteria)this;}public Criteria andLogIdGreaterThan(Integer value){addCriterion("LOG_ID >",value,"logId");return (Criteria)this;}public Criteria andLogIdGreaterThanOrEqualTo(Integer value){addCriterion("LOG_ID >=",value,"logId");return (Criteria)this;}public Criteria andLogIdLessThan(Integer value){addCriterion("LOG_ID <",value,"logId");return (Criteria)this;}public Criteria andLogIdLessThanOrEqualTo(Integer value){addCriterion("LOG_ID <=",value,"logId");return (Criteria)this;}public Criteria andLogIdIn(List<Integer> values){addCriterion("LOG_ID in",values,"logId");return (Criteria)this;}public Criteria andLogIdNotIn(List<Integer> values){addCriterion("LOG_ID not in",values,"logId");return (Criteria)this;}public Criteria andLogIdBetween(Integer value1,Integer value2){addCriterion("LOG_ID between",value1,value2,"logId");return (Criteria)this;}public Criteria andLogIdNotBetween(Integer value1,Integer value2){addCriterion("LOG_ID not between",value1,value2,"logId");return (Criteria)this;}public Criteria andCompIdIsNull(){addCriterion("COMP_ID is null");return (Criteria)this;}public Criteria andCompIdIsNotNull(){addCriterion("COMP_ID is not null");return (Criteria)this;}public Criteria andCompIdEqualTo(Integer value){addCriterion("COMP_ID =",value,"compId");return (Criteria)this;}public Criteria andCompIdNotEqualTo(Integer value){addCriterion("COMP_ID <>",value,"compId");return (Criteria)this;}public Criteria andCompIdGreaterThan(Integer value){addCriterion("COMP_ID >",value,"compId");return (Criteria)this;}public Criteria andCompIdGreaterThanOrEqualTo(Integer value){addCriterion("COMP_ID >=",value,"compId");return (Criteria)this;}public Criteria andCompIdLessThan(Integer value){addCriterion("COMP_ID <",value,"compId");return (Criteria)this;}public Criteria andCompIdLessThanOrEqualTo(Integer value){addCriterion("COMP_ID <=",value,"compId");return (Criteria)this;}public Criteria andCompIdIn(List<Integer> values){addCriterion("COMP_ID in",values,"compId");return (Criteria)this;}public Criteria andCompIdNotIn(List<Integer> values){addCriterion("COMP_ID not in",values,"compId");return (Criteria)this;}public Criteria andCompIdBetween(Integer value1,Integer value2){addCriterion("COMP_ID between",value1,value2,"compId");return (Criteria)this;}public Criteria andCompIdNotBetween(Integer value1,Integer value2){addCriterion("COMP_ID not between",value1,value2,"compId");return (Criteria)this;}public Criteria andAuditIdIsNull(){addCriterion("AUDIT_ID is null");return (Criteria)this;}public Criteria andAuditIdIsNotNull(){addCriterion("AUDIT_ID is not null");return (Criteria)this;}public Criteria andAuditIdEqualTo(Integer value){addCriterion("AUDIT_ID =",value,"auditId");return (Criteria)this;}public Criteria andAuditIdNotEqualTo(Integer value){addCriterion("AUDIT_ID <>",value,"auditId");return (Criteria)this;}public Criteria andAuditIdGreaterThan(Integer value){addCriterion("AUDIT_ID >",value,"auditId");return (Criteria)this;}public Criteria andAuditIdGreaterThanOrEqualTo(Integer value){addCriterion("AUDIT_ID >=",value,"auditId");return (Criteria)this;}public Criteria andAuditIdLessThan(Integer value){addCriterion("AUDIT_ID <",value,"auditId");return (Criteria)this;}public Criteria andAuditIdLessThanOrEqualTo(Integer value){addCriterion("AUDIT_ID <=",value,"auditId");return (Criteria)this;}public Criteria andAuditIdIn(List<Integer> values){addCriterion("AUDIT_ID in",values,"auditId");return (Criteria)this;}public Criteria andAuditIdNotIn(List<Integer> values){addCriterion("AUDIT_ID not in",values,"auditId");return (Criteria)this;}public Criteria andAuditIdBetween(Integer value1,Integer value2){addCriterion("AUDIT_ID between",value1,value2,"auditId");return (Criteria)this;}public Criteria andAuditIdNotBetween(Integer value1,Integer value2){addCriterion("AUDIT_ID not between",value1,value2,"auditId");return (Criteria)this;}public Criteria andAuditSeqIsNull(){addCriterion("AUDIT_SEQ is null");return (Criteria)this;}public Criteria andAuditSeqIsNotNull(){addCriterion("AUDIT_SEQ is not null");return (Criteria)this;}public Criteria andAuditSeqEqualTo(Integer value){addCriterion("AUDIT_SEQ =",value,"auditSeq");return (Criteria)this;}public Criteria andAuditSeqNotEqualTo(Integer value){addCriterion("AUDIT_SEQ <>",value,"auditSeq");return (Criteria)this;}public Criteria andAuditSeqGreaterThan(Integer value){addCriterion("AUDIT_SEQ >",value,"auditSeq");return (Criteria)this;}public Criteria andAuditSeqGreaterThanOrEqualTo(Integer value){addCriterion("AUDIT_SEQ >=",value,"auditSeq");return (Criteria)this;}public Criteria andAuditSeqLessThan(Integer value){addCriterion("AUDIT_SEQ <",value,"auditSeq");return (Criteria)this;}public Criteria andAuditSeqLessThanOrEqualTo(Integer value){addCriterion("AUDIT_SEQ <=",value,"auditSeq");return (Criteria)this;}public Criteria andAuditSeqIn(List<Integer> values){addCriterion("AUDIT_SEQ in",values,"auditSeq");return (Criteria)this;}public Criteria andAuditSeqNotIn(List<Integer> values){addCriterion("AUDIT_SEQ not in",values,"auditSeq");return (Criteria)this;}public Criteria andAuditSeqBetween(Integer value1,Integer value2){addCriterion("AUDIT_SEQ between",value1,value2,"auditSeq");return (Criteria)this;}public Criteria andAuditSeqNotBetween(Integer value1,Integer value2){addCriterion("AUDIT_SEQ not between",value1,value2,"auditSeq");return (Criteria)this;}public Criteria andSourceUseridIsNull(){addCriterion("SOURCE_USERID is null");return (Criteria)this;}public Criteria andSourceUseridIsNotNull(){addCriterion("SOURCE_USERID is not null");return (Criteria)this;}public Criteria andSourceUseridEqualTo(Integer value){addCriterion("SOURCE_USERID =",value,"sourceUserid");return (Criteria)this;}public Criteria andSourceUseridNotEqualTo(Integer value){addCriterion("SOURCE_USERID <>",value,"sourceUserid");return (Criteria)this;}public Criteria andSourceUseridGreaterThan(Integer value){addCriterion("SOURCE_USERID >",value,"sourceUserid");return (Criteria)this;}public Criteria andSourceUseridGreaterThanOrEqualTo(Integer value){addCriterion("SOURCE_USERID >=",value,"sourceUserid");return (Criteria)this;}public Criteria andSourceUseridLessThan(Integer value){addCriterion("SOURCE_USERID <",value,"sourceUserid");return (Criteria)this;}public Criteria andSourceUseridLessThanOrEqualTo(Integer value){addCriterion("SOURCE_USERID <=",value,"sourceUserid");return (Criteria)this;}public Criteria andSourceUseridIn(List<Integer> values){addCriterion("SOURCE_USERID in",values,"sourceUserid");return (Criteria)this;}public Criteria andSourceUseridNotIn(List<Integer> values){addCriterion("SOURCE_USERID not in",values,"sourceUserid");return (Criteria)this;}public Criteria andSourceUseridBetween(Integer value1,Integer value2){addCriterion("SOURCE_USERID between",value1,value2,"sourceUserid");return (Criteria)this;}public Criteria andSourceUseridNotBetween(Integer value1,Integer value2){addCriterion("SOURCE_USERID not between",value1,value2,"sourceUserid");return (Criteria)this;}public Criteria andSourceDeptidIsNull(){addCriterion("SOURCE_DEPTID is null");return (Criteria)this;}public Criteria andSourceDeptidIsNotNull(){addCriterion("SOURCE_DEPTID is not null");return (Criteria)this;}public Criteria andSourceDeptidEqualTo(Integer value){addCriterion("SOURCE_DEPTID =",value,"sourceDeptid");return (Criteria)this;}public Criteria andSourceDeptidNotEqualTo(Integer value){addCriterion("SOURCE_DEPTID <>",value,"sourceDeptid");return (Criteria)this;}public Criteria andSourceDeptidGreaterThan(Integer value){addCriterion("SOURCE_DEPTID >",value,"sourceDeptid");return (Criteria)this;}public Criteria andSourceDeptidGreaterThanOrEqualTo(Integer value){addCriterion("SOURCE_DEPTID >=",value,"sourceDeptid");return (Criteria)this;}public Criteria andSourceDeptidLessThan(Integer value){addCriterion("SOURCE_DEPTID <",value,"sourceDeptid");return (Criteria)this;}public Criteria andSourceDeptidLessThanOrEqualTo(Integer value){addCriterion("SOURCE_DEPTID <=",value,"sourceDeptid");return (Criteria)this;}public Criteria andSourceDeptidIn(List<Integer> values){addCriterion("SOURCE_DEPTID in",values,"sourceDeptid");return (Criteria)this;}public Criteria andSourceDeptidNotIn(List<Integer> values){addCriterion("SOURCE_DEPTID not in",values,"sourceDeptid");return (Criteria)this;}public Criteria andSourceDeptidBetween(Integer value1,Integer value2){addCriterion("SOURCE_DEPTID between",value1,value2,"sourceDeptid");return (Criteria)this;}public Criteria andSourceDeptidNotBetween(Integer value1,Integer value2){addCriterion("SOURCE_DEPTID not between",value1,value2,"sourceDeptid");return (Criteria)this;}public Criteria andAcceptUseridIsNull(){addCriterion("ACCEPT_USERID is null");return (Criteria)this;}public Criteria andAcceptUseridIsNotNull(){addCriterion("ACCEPT_USERID is not null");return (Criteria)this;}public Criteria andAcceptUseridEqualTo(Integer value){addCriterion("ACCEPT_USERID =",value,"acceptUserid");return (Criteria)this;}public Criteria andAcceptUseridNotEqualTo(Integer value){addCriterion("ACCEPT_USERID <>",value,"acceptUserid");return (Criteria)this;}public Criteria andAcceptUseridGreaterThan(Integer value){addCriterion("ACCEPT_USERID >",value,"acceptUserid");return (Criteria)this;}public Criteria andAcceptUseridGreaterThanOrEqualTo(Integer value){addCriterion("ACCEPT_USERID >=",value,"acceptUserid");return (Criteria)this;}public Criteria andAcceptUseridLessThan(Integer value){addCriterion("ACCEPT_USERID <",value,"acceptUserid");return (Criteria)this;}public Criteria andAcceptUseridLessThanOrEqualTo(Integer value){addCriterion("ACCEPT_USERID <=",value,"acceptUserid");return (Criteria)this;}public Criteria andAcceptUseridIn(List<Integer> values){addCriterion("ACCEPT_USERID in",values,"acceptUserid");return (Criteria)this;}public Criteria andAcceptUseridNotIn(List<Integer> values){addCriterion("ACCEPT_USERID not in",values,"acceptUserid");return (Criteria)this;}public Criteria andAcceptUseridBetween(Integer value1,Integer value2){addCriterion("ACCEPT_USERID between",value1,value2,"acceptUserid");return (Criteria)this;}public Criteria andAcceptUseridNotBetween(Integer value1,Integer value2){addCriterion("ACCEPT_USERID not between",value1,value2,"acceptUserid");return (Criteria)this;}public Criteria andAcceptDeptidIsNull(){addCriterion("ACCEPT_DEPTID is null");return (Criteria)this;}public Criteria andAcceptDeptidIsNotNull(){addCriterion("ACCEPT_DEPTID is not null");return (Criteria)this;}public Criteria andAcceptDeptidEqualTo(Integer value){addCriterion("ACCEPT_DEPTID =",value,"acceptDeptid");return (Criteria)this;}public Criteria andAcceptDeptidNotEqualTo(Integer value){addCriterion("ACCEPT_DEPTID <>",value,"acceptDeptid");return (Criteria)this;}public Criteria andAcceptDeptidGreaterThan(Integer value){addCriterion("ACCEPT_DEPTID >",value,"acceptDeptid");return (Criteria)this;}public Criteria andAcceptDeptidGreaterThanOrEqualTo(Integer value){addCriterion("ACCEPT_DEPTID >=",value,"acceptDeptid");return (Criteria)this;}public Criteria andAcceptDeptidLessThan(Integer value){addCriterion("ACCEPT_DEPTID <",value,"acceptDeptid");return (Criteria)this;}public Criteria andAcceptDeptidLessThanOrEqualTo(Integer value){addCriterion("ACCEPT_DEPTID <=",value,"acceptDeptid");return (Criteria)this;}public Criteria andAcceptDeptidIn(List<Integer> values){addCriterion("ACCEPT_DEPTID in",values,"acceptDeptid");return (Criteria)this;}public Criteria andAcceptDeptidNotIn(List<Integer> values){addCriterion("ACCEPT_DEPTID not in",values,"acceptDeptid");return (Criteria)this;}public Criteria andAcceptDeptidBetween(Integer value1,Integer value2){addCriterion("ACCEPT_DEPTID between",value1,value2,"acceptDeptid");return (Criteria)this;}public Criteria andAcceptDeptidNotBetween(Integer value1,Integer value2){addCriterion("ACCEPT_DEPTID not between",value1,value2,"acceptDeptid");return (Criteria)this;}public Criteria andTransmitContentIsNull(){addCriterion("TRANSMIT_CONTENT is null");return (Criteria)this;}public Criteria andTransmitContentIsNotNull(){addCriterion("TRANSMIT_CONTENT is not null");return (Criteria)this;}public Criteria andTransmitContentEqualTo(String value){addCriterion("TRANSMIT_CONTENT =",value,"transmitContent");return (Criteria)this;}public Criteria andTransmitContentNotEqualTo(String value){addCriterion("TRANSMIT_CONTENT <>",value,"transmitContent");return (Criteria)this;}public Criteria andTransmitContentGreaterThan(String value){addCriterion("TRANSMIT_CONTENT >",value,"transmitContent");return (Criteria)this;}public Criteria andTransmitContentGreaterThanOrEqualTo(String value){addCriterion("TRANSMIT_CONTENT >=",value,"transmitContent");return (Criteria)this;}public Criteria andTransmitContentLessThan(String value){addCriterion("TRANSMIT_CONTENT <",value,"transmitContent");return (Criteria)this;}public Criteria andTransmitContentLessThanOrEqualTo(String value){addCriterion("TRANSMIT_CONTENT <=",value,"transmitContent");return (Criteria)this;}public Criteria andTransmitContentLike(String value){addCriterion("TRANSMIT_CONTENT like",value,"transmitContent");return (Criteria)this;}public Criteria andTransmitContentNotLike(String value){addCriterion("TRANSMIT_CONTENT not like",value,"transmitContent");return (Criteria)this;}public Criteria andTransmitContentIn(List<String> values){addCriterion("TRANSMIT_CONTENT in",values,"transmitContent");return (Criteria)this;}public Criteria andTransmitContentNotIn(List<String> values){addCriterion("TRANSMIT_CONTENT not in",values,"transmitContent");return (Criteria)this;}public Criteria andTransmitContentBetween(String value1,String value2){addCriterion("TRANSMIT_CONTENT between",value1,value2,"transmitContent");return (Criteria)this;}public Criteria andTransmitContentNotBetween(String value1,String value2){addCriterion("TRANSMIT_CONTENT not between",value1,value2,"transmitContent");return (Criteria)this;}public Criteria andTransmitPhotoIsNull(){addCriterion("TRANSMIT_PHOTO is null");return (Criteria)this;}public Criteria andTransmitPhotoIsNotNull(){addCriterion("TRANSMIT_PHOTO is not null");return (Criteria)this;}public Criteria andTransmitPhotoEqualTo(String value){addCriterion("TRANSMIT_PHOTO =",value,"transmitPhoto");return (Criteria)this;}public Criteria andTransmitPhotoNotEqualTo(String value){addCriterion("TRANSMIT_PHOTO <>",value,"transmitPhoto");return (Criteria)this;}public Criteria andTransmitPhotoGreaterThan(String value){addCriterion("TRANSMIT_PHOTO >",value,"transmitPhoto");return (Criteria)this;}public Criteria andTransmitPhotoGreaterThanOrEqualTo(String value){addCriterion("TRANSMIT_PHOTO >=",value,"transmitPhoto");return (Criteria)this;}public Criteria andTransmitPhotoLessThan(String value){addCriterion("TRANSMIT_PHOTO <",value,"transmitPhoto");return (Criteria)this;}public Criteria andTransmitPhotoLessThanOrEqualTo(String value){addCriterion("TRANSMIT_PHOTO <=",value,"transmitPhoto");return (Criteria)this;}public Criteria andTransmitPhotoLike(String value){addCriterion("TRANSMIT_PHOTO like",value,"transmitPhoto");return (Criteria)this;}public Criteria andTransmitPhotoNotLike(String value){addCriterion("TRANSMIT_PHOTO not like",value,"transmitPhoto");return (Criteria)this;}public Criteria andTransmitPhotoIn(List<String> values){addCriterion("TRANSMIT_PHOTO in",values,"transmitPhoto");return (Criteria)this;}public Criteria andTransmitPhotoNotIn(List<String> values){addCriterion("TRANSMIT_PHOTO not in",values,"transmitPhoto");return (Criteria)this;}public Criteria andTransmitPhotoBetween(String value1,String value2){addCriterion("TRANSMIT_PHOTO between",value1,value2,"transmitPhoto");return (Criteria)this;}public Criteria andTransmitPhotoNotBetween(String value1,String value2){addCriterion("TRANSMIT_PHOTO not between",value1,value2,"transmitPhoto");return (Criteria)this;}public Criteria andSourceUsernameIsNull(){addCriterion("SOURCE_USERNAME is null");return (Criteria)this;}public Criteria andSourceUsernameIsNotNull(){addCriterion("SOURCE_USERNAME is not null");return (Criteria)this;}public Criteria andSourceUsernameEqualTo(String value){addCriterion("SOURCE_USERNAME =",value,"sourceUsername");return (Criteria)this;}public Criteria andSourceUsernameNotEqualTo(String value){addCriterion("SOURCE_USERNAME <>",value,"sourceUsername");return (Criteria)this;}public Criteria andSourceUsernameGreaterThan(String value){addCriterion("SOURCE_USERNAME >",value,"sourceUsername");return (Criteria)this;}public Criteria andSourceUsernameGreaterThanOrEqualTo(String value){addCriterion("SOURCE_USERNAME >=",value,"sourceUsername");return (Criteria)this;}public Criteria andSourceUsernameLessThan(String value){addCriterion("SOURCE_USERNAME <",value,"sourceUsername");return (Criteria)this;}public Criteria andSourceUsernameLessThanOrEqualTo(String value){addCriterion("SOURCE_USERNAME <=",value,"sourceUsername");return (Criteria)this;}public Criteria andSourceUsernameLike(String value){addCriterion("SOURCE_USERNAME like",value,"sourceUsername");return (Criteria)this;}public Criteria andSourceUsernameNotLike(String value){addCriterion("SOURCE_USERNAME not like",value,"sourceUsername");return (Criteria)this;}public Criteria andSourceUsernameIn(List<String> values){addCriterion("SOURCE_USERNAME in",values,"sourceUsername");return (Criteria)this;}public Criteria andSourceUsernameNotIn(List<String> values){addCriterion("SOURCE_USERNAME not in",values,"sourceUsername");return (Criteria)this;}public Criteria andSourceUsernameBetween(String value1,String value2){addCriterion("SOURCE_USERNAME between",value1,value2,"sourceUsername");return (Criteria)this;}public Criteria andSourceUsernameNotBetween(String value1,String value2){addCriterion("SOURCE_USERNAME not between",value1,value2,"sourceUsername");return (Criteria)this;}public Criteria andSourceDeptnameIsNull(){addCriterion("SOURCE_DEPTNAME is null");return (Criteria)this;}public Criteria andSourceDeptnameIsNotNull(){addCriterion("SOURCE_DEPTNAME is not null");return (Criteria)this;}public Criteria andSourceDeptnameEqualTo(String value){addCriterion("SOURCE_DEPTNAME =",value,"sourceDeptname");return (Criteria)this;}public Criteria andSourceDeptnameNotEqualTo(String value){addCriterion("SOURCE_DEPTNAME <>",value,"sourceDeptname");return (Criteria)this;}public Criteria andSourceDeptnameGreaterThan(String value){addCriterion("SOURCE_DEPTNAME >",value,"sourceDeptname");return (Criteria)this;}public Criteria andSourceDeptnameGreaterThanOrEqualTo(String value){addCriterion("SOURCE_DEPTNAME >=",value,"sourceDeptname");return (Criteria)this;}public Criteria andSourceDeptnameLessThan(String value){addCriterion("SOURCE_DEPTNAME <",value,"sourceDeptname");return (Criteria)this;}public Criteria andSourceDeptnameLessThanOrEqualTo(String value){addCriterion("SOURCE_DEPTNAME <=",value,"sourceDeptname");return (Criteria)this;}public Criteria andSourceDeptnameLike(String value){addCriterion("SOURCE_DEPTNAME like",value,"sourceDeptname");return (Criteria)this;}public Criteria andSourceDeptnameNotLike(String value){addCriterion("SOURCE_DEPTNAME not like",value,"sourceDeptname");return (Criteria)this;}public Criteria andSourceDeptnameIn(List<String> values){addCriterion("SOURCE_DEPTNAME in",values,"sourceDeptname");return (Criteria)this;}public Criteria andSourceDeptnameNotIn(List<String> values){addCriterion("SOURCE_DEPTNAME not in",values,"sourceDeptname");return (Criteria)this;}public Criteria andSourceDeptnameBetween(String value1,String value2){addCriterion("SOURCE_DEPTNAME between",value1,value2,"sourceDeptname");return (Criteria)this;}public Criteria andSourceDeptnameNotBetween(String value1,String value2){addCriterion("SOURCE_DEPTNAME not between",value1,value2,"sourceDeptname");return (Criteria)this;}public Criteria andAcceptUsernameIsNull(){addCriterion("ACCEPT_USERNAME is null");return (Criteria)this;}public Criteria andAcceptUsernameIsNotNull(){addCriterion("ACCEPT_USERNAME is not null");return (Criteria)this;}public Criteria andAcceptUsernameEqualTo(String value){addCriterion("ACCEPT_USERNAME =",value,"acceptUsername");return (Criteria)this;}public Criteria andAcceptUsernameNotEqualTo(String value){addCriterion("ACCEPT_USERNAME <>",value,"acceptUsername");return (Criteria)this;}public Criteria andAcceptUsernameGreaterThan(String value){addCriterion("ACCEPT_USERNAME >",value,"acceptUsername");return (Criteria)this;}public Criteria andAcceptUsernameGreaterThanOrEqualTo(String value){addCriterion("ACCEPT_USERNAME >=",value,"acceptUsername");return (Criteria)this;}public Criteria andAcceptUsernameLessThan(String value){addCriterion("ACCEPT_USERNAME <",value,"acceptUsername");return (Criteria)this;}public Criteria andAcceptUsernameLessThanOrEqualTo(String value){addCriterion("ACCEPT_USERNAME <=",value,"acceptUsername");return (Criteria)this;}public Criteria andAcceptUsernameLike(String value){addCriterion("ACCEPT_USERNAME like",value,"acceptUsername");return (Criteria)this;}public Criteria andAcceptUsernameNotLike(String value){addCriterion("ACCEPT_USERNAME not like",value,"acceptUsername");return (Criteria)this;}public Criteria andAcceptUsernameIn(List<String> values){addCriterion("ACCEPT_USERNAME in",values,"acceptUsername");return (Criteria)this;}public Criteria andAcceptUsernameNotIn(List<String> values){addCriterion("ACCEPT_USERNAME not in",values,"acceptUsername");return (Criteria)this;}public Criteria andAcceptUsernameBetween(String value1,String value2){addCriterion("ACCEPT_USERNAME between",value1,value2,"acceptUsername");return (Criteria)this;}public Criteria andAcceptUsernameNotBetween(String value1,String value2){addCriterion("ACCEPT_USERNAME not between",value1,value2,"acceptUsername");return (Criteria)this;}public Criteria andAcceptDeptnameIsNull(){addCriterion("ACCEPT_DEPTNAME is null");return (Criteria)this;}public Criteria andAcceptDeptnameIsNotNull(){addCriterion("ACCEPT_DEPTNAME is not null");return (Criteria)this;}public Criteria andAcceptDeptnameEqualTo(String value){addCriterion("ACCEPT_DEPTNAME =",value,"acceptDeptname");return (Criteria)this;}public Criteria andAcceptDeptnameNotEqualTo(String value){addCriterion("ACCEPT_DEPTNAME <>",value,"acceptDeptname");return (Criteria)this;}public Criteria andAcceptDeptnameGreaterThan(String value){addCriterion("ACCEPT_DEPTNAME >",value,"acceptDeptname");return (Criteria)this;}public Criteria andAcceptDeptnameGreaterThanOrEqualTo(String value){addCriterion("ACCEPT_DEPTNAME >=",value,"acceptDeptname");return (Criteria)this;}public Criteria andAcceptDeptnameLessThan(String value){addCriterion("ACCEPT_DEPTNAME <",value,"acceptDeptname");return (Criteria)this;}public Criteria andAcceptDeptnameLessThanOrEqualTo(String value){addCriterion("ACCEPT_DEPTNAME <=",value,"acceptDeptname");return (Criteria)this;}public Criteria andAcceptDeptnameLike(String value){addCriterion("ACCEPT_DEPTNAME like",value,"acceptDeptname");return (Criteria)this;}public Criteria andAcceptDeptnameNotLike(String value){addCriterion("ACCEPT_DEPTNAME not like",value,"acceptDeptname");return (Criteria)this;}public Criteria andAcceptDeptnameIn(List<String> values){addCriterion("ACCEPT_DEPTNAME in",values,"acceptDeptname");return (Criteria)this;}public Criteria andAcceptDeptnameNotIn(List<String> values){addCriterion("ACCEPT_DEPTNAME not in",values,"acceptDeptname");return (Criteria)this;}public Criteria andAcceptDeptnameBetween(String value1,String value2){addCriterion("ACCEPT_DEPTNAME between",value1,value2,"acceptDeptname");return (Criteria)this;}public Criteria andAcceptDeptnameNotBetween(String value1,String value2){addCriterion("ACCEPT_DEPTNAME not between",value1,value2,"acceptDeptname");return (Criteria)this;}public Criteria andCreationTimeIsNull(){addCriterion("CREATION_TIME is null");return (Criteria)this;}public Criteria andCreationTimeIsNotNull(){addCriterion("CREATION_TIME is not null");return (Criteria)this;}public Criteria andCreationTimeEqualTo(Date value){addCriterion("CREATION_TIME =",value,"creationTime");return (Criteria)this;}public Criteria andCreationTimeNotEqualTo(Date value){addCriterion("CREATION_TIME <>",value,"creationTime");return (Criteria)this;}public Criteria andCreationTimeGreaterThan(Date value){addCriterion("CREATION_TIME >",value,"creationTime");return (Criteria)this;}public Criteria andCreationTimeGreaterThanOrEqualTo(Date value){addCriterion("CREATION_TIME >=",value,"creationTime");return (Criteria)this;}public Criteria andCreationTimeLessThan(Date value){addCriterion("CREATION_TIME <",value,"creationTime");return (Criteria)this;}public Criteria andCreationTimeLessThanOrEqualTo(Date value){addCriterion("CREATION_TIME <=",value,"creationTime");return (Criteria)this;}public Criteria andCreationTimeIn(List<Date> values){addCriterion("CREATION_TIME in",values,"creationTime");return (Criteria)this;}public Criteria andCreationTimeNotIn(List<Date> values){addCriterion("CREATION_TIME not in",values,"creationTime");return (Criteria)this;}public Criteria andCreationTimeBetween(Date value1,Date value2){addCriterion("CREATION_TIME between",value1,value2,"creationTime");return (Criteria)this;}public Criteria andCreationTimeNotBetween(Date value1,Date value2){addCriterion("CREATION_TIME not between",value1,value2,"creationTime");return (Criteria)this;}}

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