package com.myfun.repository.erpdb.po;

import com.myfun.repository.support.generator.shard.ShardDb;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ErpFunFinancPaymentExample extends ShardDb {
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
	 */public ErpFunFinancPaymentExample(){oredCriteria=new ArrayList<Criteria>();}

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
	 */protected abstract static class GeneratedCriteria {protected List<Criterion> criteria;protected GeneratedCriteria(){super();criteria=new ArrayList<Criterion>();}public boolean isValid(){return criteria.size() > 0;}public List<Criterion> getAllCriteria(){return criteria;}public List<Criterion> getCriteria(){return criteria;}protected void addCriterion(String condition){if (condition == null){throw new RuntimeException("Value for condition cannot be null");}criteria.add(new Criterion(condition));}protected void addCriterion(String condition,Object value,String property){if (value == null){throw new RuntimeException("Value for " + property + " cannot be null");}criteria.add(new Criterion(condition,value));}protected void addCriterion(String condition,Object value1,Object value2,String property){if (value1 == null || value2 == null){throw new RuntimeException("Between values for " + property + " cannot be null");}criteria.add(new Criterion(condition,value1,value2));}public Criteria andPaymentIdIsNull(){addCriterion("PAYMENT_ID is null");return (Criteria)this;}public Criteria andPaymentIdIsNotNull(){addCriterion("PAYMENT_ID is not null");return (Criteria)this;}public Criteria andPaymentIdEqualTo(Integer value){addCriterion("PAYMENT_ID =",value,"paymentId");return (Criteria)this;}public Criteria andPaymentIdNotEqualTo(Integer value){addCriterion("PAYMENT_ID <>",value,"paymentId");return (Criteria)this;}public Criteria andPaymentIdGreaterThan(Integer value){addCriterion("PAYMENT_ID >",value,"paymentId");return (Criteria)this;}public Criteria andPaymentIdGreaterThanOrEqualTo(Integer value){addCriterion("PAYMENT_ID >=",value,"paymentId");return (Criteria)this;}public Criteria andPaymentIdLessThan(Integer value){addCriterion("PAYMENT_ID <",value,"paymentId");return (Criteria)this;}public Criteria andPaymentIdLessThanOrEqualTo(Integer value){addCriterion("PAYMENT_ID <=",value,"paymentId");return (Criteria)this;}public Criteria andPaymentIdIn(List<Integer> values){addCriterion("PAYMENT_ID in",values,"paymentId");return (Criteria)this;}public Criteria andPaymentIdNotIn(List<Integer> values){addCriterion("PAYMENT_ID not in",values,"paymentId");return (Criteria)this;}public Criteria andPaymentIdBetween(Integer value1,Integer value2){addCriterion("PAYMENT_ID between",value1,value2,"paymentId");return (Criteria)this;}public Criteria andPaymentIdNotBetween(Integer value1,Integer value2){addCriterion("PAYMENT_ID not between",value1,value2,"paymentId");return (Criteria)this;}public Criteria andPaymentNameIsNull(){addCriterion("PAYMENT_NAME is null");return (Criteria)this;}public Criteria andPaymentNameIsNotNull(){addCriterion("PAYMENT_NAME is not null");return (Criteria)this;}public Criteria andPaymentNameEqualTo(String value){addCriterion("PAYMENT_NAME =",value,"paymentName");return (Criteria)this;}public Criteria andPaymentNameNotEqualTo(String value){addCriterion("PAYMENT_NAME <>",value,"paymentName");return (Criteria)this;}public Criteria andPaymentNameGreaterThan(String value){addCriterion("PAYMENT_NAME >",value,"paymentName");return (Criteria)this;}public Criteria andPaymentNameGreaterThanOrEqualTo(String value){addCriterion("PAYMENT_NAME >=",value,"paymentName");return (Criteria)this;}public Criteria andPaymentNameLessThan(String value){addCriterion("PAYMENT_NAME <",value,"paymentName");return (Criteria)this;}public Criteria andPaymentNameLessThanOrEqualTo(String value){addCriterion("PAYMENT_NAME <=",value,"paymentName");return (Criteria)this;}public Criteria andPaymentNameLike(String value){addCriterion("PAYMENT_NAME like",value,"paymentName");return (Criteria)this;}public Criteria andPaymentNameNotLike(String value){addCriterion("PAYMENT_NAME not like",value,"paymentName");return (Criteria)this;}public Criteria andPaymentNameIn(List<String> values){addCriterion("PAYMENT_NAME in",values,"paymentName");return (Criteria)this;}public Criteria andPaymentNameNotIn(List<String> values){addCriterion("PAYMENT_NAME not in",values,"paymentName");return (Criteria)this;}public Criteria andPaymentNameBetween(String value1,String value2){addCriterion("PAYMENT_NAME between",value1,value2,"paymentName");return (Criteria)this;}public Criteria andPaymentNameNotBetween(String value1,String value2){addCriterion("PAYMENT_NAME not between",value1,value2,"paymentName");return (Criteria)this;}public Criteria andCompIdIsNull(){addCriterion("COMP_ID is null");return (Criteria)this;}public Criteria andCompIdIsNotNull(){addCriterion("COMP_ID is not null");return (Criteria)this;}public Criteria andCompIdEqualTo(Integer value){addCriterion("COMP_ID =",value,"compId");return (Criteria)this;}public Criteria andCompIdNotEqualTo(Integer value){addCriterion("COMP_ID <>",value,"compId");return (Criteria)this;}public Criteria andCompIdGreaterThan(Integer value){addCriterion("COMP_ID >",value,"compId");return (Criteria)this;}public Criteria andCompIdGreaterThanOrEqualTo(Integer value){addCriterion("COMP_ID >=",value,"compId");return (Criteria)this;}public Criteria andCompIdLessThan(Integer value){addCriterion("COMP_ID <",value,"compId");return (Criteria)this;}public Criteria andCompIdLessThanOrEqualTo(Integer value){addCriterion("COMP_ID <=",value,"compId");return (Criteria)this;}public Criteria andCompIdIn(List<Integer> values){addCriterion("COMP_ID in",values,"compId");return (Criteria)this;}public Criteria andCompIdNotIn(List<Integer> values){addCriterion("COMP_ID not in",values,"compId");return (Criteria)this;}public Criteria andCompIdBetween(Integer value1,Integer value2){addCriterion("COMP_ID between",value1,value2,"compId");return (Criteria)this;}public Criteria andCompIdNotBetween(Integer value1,Integer value2){addCriterion("COMP_ID not between",value1,value2,"compId");return (Criteria)this;}public Criteria andSeqNoIsNull(){addCriterion("SEQ_NO is null");return (Criteria)this;}public Criteria andSeqNoIsNotNull(){addCriterion("SEQ_NO is not null");return (Criteria)this;}public Criteria andSeqNoEqualTo(Integer value){addCriterion("SEQ_NO =",value,"seqNo");return (Criteria)this;}public Criteria andSeqNoNotEqualTo(Integer value){addCriterion("SEQ_NO <>",value,"seqNo");return (Criteria)this;}public Criteria andSeqNoGreaterThan(Integer value){addCriterion("SEQ_NO >",value,"seqNo");return (Criteria)this;}public Criteria andSeqNoGreaterThanOrEqualTo(Integer value){addCriterion("SEQ_NO >=",value,"seqNo");return (Criteria)this;}public Criteria andSeqNoLessThan(Integer value){addCriterion("SEQ_NO <",value,"seqNo");return (Criteria)this;}public Criteria andSeqNoLessThanOrEqualTo(Integer value){addCriterion("SEQ_NO <=",value,"seqNo");return (Criteria)this;}public Criteria andSeqNoIn(List<Integer> values){addCriterion("SEQ_NO in",values,"seqNo");return (Criteria)this;}public Criteria andSeqNoNotIn(List<Integer> values){addCriterion("SEQ_NO not in",values,"seqNo");return (Criteria)this;}public Criteria andSeqNoBetween(Integer value1,Integer value2){addCriterion("SEQ_NO between",value1,value2,"seqNo");return (Criteria)this;}public Criteria andSeqNoNotBetween(Integer value1,Integer value2){addCriterion("SEQ_NO not between",value1,value2,"seqNo");return (Criteria)this;}public Criteria andCreateTimeIsNull(){addCriterion("CREATE_TIME is null");return (Criteria)this;}public Criteria andCreateTimeIsNotNull(){addCriterion("CREATE_TIME is not null");return (Criteria)this;}public Criteria andCreateTimeEqualTo(Date value){addCriterion("CREATE_TIME =",value,"createTime");return (Criteria)this;}public Criteria andCreateTimeNotEqualTo(Date value){addCriterion("CREATE_TIME <>",value,"createTime");return (Criteria)this;}public Criteria andCreateTimeGreaterThan(Date value){addCriterion("CREATE_TIME >",value,"createTime");return (Criteria)this;}public Criteria andCreateTimeGreaterThanOrEqualTo(Date value){addCriterion("CREATE_TIME >=",value,"createTime");return (Criteria)this;}public Criteria andCreateTimeLessThan(Date value){addCriterion("CREATE_TIME <",value,"createTime");return (Criteria)this;}public Criteria andCreateTimeLessThanOrEqualTo(Date value){addCriterion("CREATE_TIME <=",value,"createTime");return (Criteria)this;}public Criteria andCreateTimeIn(List<Date> values){addCriterion("CREATE_TIME in",values,"createTime");return (Criteria)this;}public Criteria andCreateTimeNotIn(List<Date> values){addCriterion("CREATE_TIME not in",values,"createTime");return (Criteria)this;}public Criteria andCreateTimeBetween(Date value1,Date value2){addCriterion("CREATE_TIME between",value1,value2,"createTime");return (Criteria)this;}public Criteria andCreateTimeNotBetween(Date value1,Date value2){addCriterion("CREATE_TIME not between",value1,value2,"createTime");return (Criteria)this;}public Criteria andIsDelIsNull(){addCriterion("IS_DEL is null");return (Criteria)this;}public Criteria andIsDelIsNotNull(){addCriterion("IS_DEL is not null");return (Criteria)this;}public Criteria andIsDelEqualTo(Byte value){addCriterion("IS_DEL =",value,"isDel");return (Criteria)this;}public Criteria andIsDelNotEqualTo(Byte value){addCriterion("IS_DEL <>",value,"isDel");return (Criteria)this;}public Criteria andIsDelGreaterThan(Byte value){addCriterion("IS_DEL >",value,"isDel");return (Criteria)this;}public Criteria andIsDelGreaterThanOrEqualTo(Byte value){addCriterion("IS_DEL >=",value,"isDel");return (Criteria)this;}public Criteria andIsDelLessThan(Byte value){addCriterion("IS_DEL <",value,"isDel");return (Criteria)this;}public Criteria andIsDelLessThanOrEqualTo(Byte value){addCriterion("IS_DEL <=",value,"isDel");return (Criteria)this;}public Criteria andIsDelIn(List<Byte> values){addCriterion("IS_DEL in",values,"isDel");return (Criteria)this;}public Criteria andIsDelNotIn(List<Byte> values){addCriterion("IS_DEL not in",values,"isDel");return (Criteria)this;}public Criteria andIsDelBetween(Byte value1,Byte value2){addCriterion("IS_DEL between",value1,value2,"isDel");return (Criteria)this;}public Criteria andIsDelNotBetween(Byte value1,Byte value2){addCriterion("IS_DEL not between",value1,value2,"isDel");return (Criteria)this;}public Criteria andCanDelIsNull(){addCriterion("CAN_DEL is null");return (Criteria)this;}public Criteria andCanDelIsNotNull(){addCriterion("CAN_DEL is not null");return (Criteria)this;}public Criteria andCanDelEqualTo(Integer value){addCriterion("CAN_DEL =",value,"canDel");return (Criteria)this;}public Criteria andCanDelNotEqualTo(Integer value){addCriterion("CAN_DEL <>",value,"canDel");return (Criteria)this;}public Criteria andCanDelGreaterThan(Integer value){addCriterion("CAN_DEL >",value,"canDel");return (Criteria)this;}public Criteria andCanDelGreaterThanOrEqualTo(Integer value){addCriterion("CAN_DEL >=",value,"canDel");return (Criteria)this;}public Criteria andCanDelLessThan(Integer value){addCriterion("CAN_DEL <",value,"canDel");return (Criteria)this;}public Criteria andCanDelLessThanOrEqualTo(Integer value){addCriterion("CAN_DEL <=",value,"canDel");return (Criteria)this;}public Criteria andCanDelIn(List<Integer> values){addCriterion("CAN_DEL in",values,"canDel");return (Criteria)this;}public Criteria andCanDelNotIn(List<Integer> values){addCriterion("CAN_DEL not in",values,"canDel");return (Criteria)this;}public Criteria andCanDelBetween(Integer value1,Integer value2){addCriterion("CAN_DEL between",value1,value2,"canDel");return (Criteria)this;}public Criteria andCanDelNotBetween(Integer value1,Integer value2){addCriterion("CAN_DEL not between",value1,value2,"canDel");return (Criteria)this;}public Criteria andIsProfitIsNull(){addCriterion("IS_PROFIT is null");return (Criteria)this;}public Criteria andIsProfitIsNotNull(){addCriterion("IS_PROFIT is not null");return (Criteria)this;}public Criteria andIsProfitEqualTo(Byte value){addCriterion("IS_PROFIT =",value,"isProfit");return (Criteria)this;}public Criteria andIsProfitNotEqualTo(Byte value){addCriterion("IS_PROFIT <>",value,"isProfit");return (Criteria)this;}public Criteria andIsProfitGreaterThan(Byte value){addCriterion("IS_PROFIT >",value,"isProfit");return (Criteria)this;}public Criteria andIsProfitGreaterThanOrEqualTo(Byte value){addCriterion("IS_PROFIT >=",value,"isProfit");return (Criteria)this;}public Criteria andIsProfitLessThan(Byte value){addCriterion("IS_PROFIT <",value,"isProfit");return (Criteria)this;}public Criteria andIsProfitLessThanOrEqualTo(Byte value){addCriterion("IS_PROFIT <=",value,"isProfit");return (Criteria)this;}public Criteria andIsProfitIn(List<Byte> values){addCriterion("IS_PROFIT in",values,"isProfit");return (Criteria)this;}public Criteria andIsProfitNotIn(List<Byte> values){addCriterion("IS_PROFIT not in",values,"isProfit");return (Criteria)this;}public Criteria andIsProfitBetween(Byte value1,Byte value2){addCriterion("IS_PROFIT between",value1,value2,"isProfit");return (Criteria)this;}public Criteria andIsProfitNotBetween(Byte value1,Byte value2){addCriterion("IS_PROFIT not between",value1,value2,"isProfit");return (Criteria)this;}public Criteria andEnNameIsNull(){addCriterion("EN_NAME is null");return (Criteria)this;}public Criteria andEnNameIsNotNull(){addCriterion("EN_NAME is not null");return (Criteria)this;}public Criteria andEnNameEqualTo(String value){addCriterion("EN_NAME =",value,"enName");return (Criteria)this;}public Criteria andEnNameNotEqualTo(String value){addCriterion("EN_NAME <>",value,"enName");return (Criteria)this;}public Criteria andEnNameGreaterThan(String value){addCriterion("EN_NAME >",value,"enName");return (Criteria)this;}public Criteria andEnNameGreaterThanOrEqualTo(String value){addCriterion("EN_NAME >=",value,"enName");return (Criteria)this;}public Criteria andEnNameLessThan(String value){addCriterion("EN_NAME <",value,"enName");return (Criteria)this;}public Criteria andEnNameLessThanOrEqualTo(String value){addCriterion("EN_NAME <=",value,"enName");return (Criteria)this;}public Criteria andEnNameLike(String value){addCriterion("EN_NAME like",value,"enName");return (Criteria)this;}public Criteria andEnNameNotLike(String value){addCriterion("EN_NAME not like",value,"enName");return (Criteria)this;}public Criteria andEnNameIn(List<String> values){addCriterion("EN_NAME in",values,"enName");return (Criteria)this;}public Criteria andEnNameNotIn(List<String> values){addCriterion("EN_NAME not in",values,"enName");return (Criteria)this;}public Criteria andEnNameBetween(String value1,String value2){addCriterion("EN_NAME between",value1,value2,"enName");return (Criteria)this;}public Criteria andEnNameNotBetween(String value1,String value2){addCriterion("EN_NAME not between",value1,value2,"enName");return (Criteria)this;}public Criteria andPerformanceTypeIsNull(){addCriterion("PERFORMANCE_TYPE is null");return (Criteria)this;}public Criteria andPerformanceTypeIsNotNull(){addCriterion("PERFORMANCE_TYPE is not null");return (Criteria)this;}public Criteria andPerformanceTypeEqualTo(Byte value){addCriterion("PERFORMANCE_TYPE =",value,"performanceType");return (Criteria)this;}public Criteria andPerformanceTypeNotEqualTo(Byte value){addCriterion("PERFORMANCE_TYPE <>",value,"performanceType");return (Criteria)this;}public Criteria andPerformanceTypeGreaterThan(Byte value){addCriterion("PERFORMANCE_TYPE >",value,"performanceType");return (Criteria)this;}public Criteria andPerformanceTypeGreaterThanOrEqualTo(Byte value){addCriterion("PERFORMANCE_TYPE >=",value,"performanceType");return (Criteria)this;}public Criteria andPerformanceTypeLessThan(Byte value){addCriterion("PERFORMANCE_TYPE <",value,"performanceType");return (Criteria)this;}public Criteria andPerformanceTypeLessThanOrEqualTo(Byte value){addCriterion("PERFORMANCE_TYPE <=",value,"performanceType");return (Criteria)this;}public Criteria andPerformanceTypeIn(List<Byte> values){addCriterion("PERFORMANCE_TYPE in",values,"performanceType");return (Criteria)this;}public Criteria andPerformanceTypeNotIn(List<Byte> values){addCriterion("PERFORMANCE_TYPE not in",values,"performanceType");return (Criteria)this;}public Criteria andPerformanceTypeBetween(Byte value1,Byte value2){addCriterion("PERFORMANCE_TYPE between",value1,value2,"performanceType");return (Criteria)this;}public Criteria andPerformanceTypeNotBetween(Byte value1,Byte value2){addCriterion("PERFORMANCE_TYPE not between",value1,value2,"performanceType");return (Criteria)this;}public Criteria andBeneficiaryIsNull(){addCriterion("BENEFICIARY is null");return (Criteria)this;}public Criteria andBeneficiaryIsNotNull(){addCriterion("BENEFICIARY is not null");return (Criteria)this;}public Criteria andBeneficiaryEqualTo(Byte value){addCriterion("BENEFICIARY =",value,"beneficiary");return (Criteria)this;}public Criteria andBeneficiaryNotEqualTo(Byte value){addCriterion("BENEFICIARY <>",value,"beneficiary");return (Criteria)this;}public Criteria andBeneficiaryGreaterThan(Byte value){addCriterion("BENEFICIARY >",value,"beneficiary");return (Criteria)this;}public Criteria andBeneficiaryGreaterThanOrEqualTo(Byte value){addCriterion("BENEFICIARY >=",value,"beneficiary");return (Criteria)this;}public Criteria andBeneficiaryLessThan(Byte value){addCriterion("BENEFICIARY <",value,"beneficiary");return (Criteria)this;}public Criteria andBeneficiaryLessThanOrEqualTo(Byte value){addCriterion("BENEFICIARY <=",value,"beneficiary");return (Criteria)this;}public Criteria andBeneficiaryIn(List<Byte> values){addCriterion("BENEFICIARY in",values,"beneficiary");return (Criteria)this;}public Criteria andBeneficiaryNotIn(List<Byte> values){addCriterion("BENEFICIARY not in",values,"beneficiary");return (Criteria)this;}public Criteria andBeneficiaryBetween(Byte value1,Byte value2){addCriterion("BENEFICIARY between",value1,value2,"beneficiary");return (Criteria)this;}public Criteria andBeneficiaryNotBetween(Byte value1,Byte value2){addCriterion("BENEFICIARY not between",value1,value2,"beneficiary");return (Criteria)this;}}

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