package com.myfun.repository.erpdb.po;

import com.myfun.repository.support.generator.shard.ShardDb;
import java.io.Serializable;

public class ErpFunContractDeal extends ShardDb implements Serializable {

	/**
	 * @mbggenerated
	 */
	private Integer id;
	/**
	 * @mbggenerated FUN_DEAL合同的Id
	 */
	private Integer dealId;
	/**
	 * @mbggenerated 模板合同ID
	 */
	private Integer contractId;
	/**
	 * @mbggenerated 合同类型 1：合同 2：协议 3 居间合同 4 附属设施
	 */
	private Byte contractType;
	/**
	 * @mbggenerated 合同类型 101 出售  102 出租
	 */
	private Byte caseType;
	/**
	 * @mbggenerated
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @mbggenerated
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @mbggenerated
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @mbggenerated
	 */
	public Integer getDealId() {
		return dealId;
	}

	/**
	 * @mbggenerated
	 */
	public void setDealId(Integer dealId) {
		this.dealId = dealId;
	}

	/**
	 * @mbggenerated
	 */
	public Integer getContractId() {
		return contractId;
	}

	/**
	 * @mbggenerated
	 */
	public void setContractId(Integer contractId) {
		this.contractId = contractId;
	}

	/**
	 * @mbggenerated
	 */
	public Byte getContractType() {
		return contractType;
	}

	/**
	 * @mbggenerated
	 */
	public void setContractType(Byte contractType) {
		this.contractType = contractType;
	}

	/**
	 * @mbggenerated
	 */
	public Byte getCaseType() {
		return caseType;
	}

	/**
	 * @mbggenerated
	 */
	public void setCaseType(Byte caseType) {
		this.caseType = caseType;
	}

	/**
	 * @mbggenerated
	 */
	public ErpFunContractDeal() {
	}

	/**
	 * @mbggenerated
	 */
	public ErpFunContractDeal(Integer shardCityId, Integer id) {
		super(shardCityId);
		this.id = id;
	}
}