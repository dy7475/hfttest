package com.myfun.repository.erpdb.po;

import com.myfun.repository.support.generator.shard.ShardDb;
import java.io.Serializable;
import io.swagger.annotations.ApiModelProperty;

public class ErpRoleWagetypeRelative extends ShardDb implements Serializable {

	/**
	 * @mbggenerated
	 */@ApiModelProperty(value=" 主键id") private Integer id;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value=" 公司id") private Integer compId;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="过户id") private Integer transferId;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="总业绩id") private Integer totalId;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="二手业绩id ") private Integer secondhandId;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="租赁业绩id") private Integer leaseId;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="金融id") private Integer financeId;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="新房id") private Integer newhouseId;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="薪id资方案") private Integer salaryTypeId;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="null") private Byte manageType;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="0普通业务提成，1管理提成") private Byte countType;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="是否考核此项 1正常 0删除") private Byte isCheck;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="新的总业绩ID") private Integer newtotalId;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="业务提成1=分业务计算 2=合并计算(新增字段)") private Byte royaltyType;
	/**
	 * @mbggenerated
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @mbggenerated 主键id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @mbggenerated 主键id
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @mbggenerated 公司id
	 */
	public Integer getCompId() {
		return compId;
	}

	/**
	 * @mbggenerated 公司id
	 */
	public void setCompId(Integer compId) {
		this.compId = compId;
	}

	/**
	 * @mbggenerated 过户id
	 */
	public Integer getTransferId() {
		return transferId;
	}

	/**
	 * @mbggenerated 过户id
	 */
	public void setTransferId(Integer transferId) {
		this.transferId = transferId;
	}

	/**
	 * @mbggenerated 总业绩id
	 */
	public Integer getTotalId() {
		return totalId;
	}

	/**
	 * @mbggenerated 总业绩id
	 */
	public void setTotalId(Integer totalId) {
		this.totalId = totalId;
	}

	/**
	 * @mbggenerated 二手业绩id 
	 */
	public Integer getSecondhandId() {
		return secondhandId;
	}

	/**
	 * @mbggenerated 二手业绩id 
	 */
	public void setSecondhandId(Integer secondhandId) {
		this.secondhandId = secondhandId;
	}

	/**
	 * @mbggenerated 租赁业绩id
	 */
	public Integer getLeaseId() {
		return leaseId;
	}

	/**
	 * @mbggenerated 租赁业绩id
	 */
	public void setLeaseId(Integer leaseId) {
		this.leaseId = leaseId;
	}

	/**
	 * @mbggenerated 金融id
	 */
	public Integer getFinanceId() {
		return financeId;
	}

	/**
	 * @mbggenerated 金融id
	 */
	public void setFinanceId(Integer financeId) {
		this.financeId = financeId;
	}

	/**
	 * @mbggenerated 新房id
	 */
	public Integer getNewhouseId() {
		return newhouseId;
	}

	/**
	 * @mbggenerated 新房id
	 */
	public void setNewhouseId(Integer newhouseId) {
		this.newhouseId = newhouseId;
	}

	/**
	 * @mbggenerated 薪id资方案
	 */
	public Integer getSalaryTypeId() {
		return salaryTypeId;
	}

	/**
	 * @mbggenerated 薪id资方案
	 */
	public void setSalaryTypeId(Integer salaryTypeId) {
		this.salaryTypeId = salaryTypeId;
	}

	/**
	 * @mbggenerated -
	 */
	public Byte getManageType() {
		return manageType;
	}

	/**
	 * @mbggenerated -
	 */
	public void setManageType(Byte manageType) {
		this.manageType = manageType;
	}

	/**
	 * @mbggenerated 0普通业务提成，1管理提成
	 */
	public Byte getCountType() {
		return countType;
	}

	/**
	 * @mbggenerated 0普通业务提成，1管理提成
	 */
	public void setCountType(Byte countType) {
		this.countType = countType;
	}

	/**
	 * @mbggenerated 是否考核此项 1正常 0删除
	 */
	public Byte getIsCheck() {
		return isCheck;
	}

	/**
	 * @mbggenerated 是否考核此项 1正常 0删除
	 */
	public void setIsCheck(Byte isCheck) {
		this.isCheck = isCheck;
	}

	/**
	 * @mbggenerated 新的总业绩ID
	 */
	public Integer getNewtotalId() {
		return newtotalId;
	}

	/**
	 * @mbggenerated 新的总业绩ID
	 */
	public void setNewtotalId(Integer newtotalId) {
		this.newtotalId = newtotalId;
	}

	/**
	 * @mbggenerated 业务提成1=分业务计算 2=合并计算(新增字段)
	 */
	public Byte getRoyaltyType() {
		return royaltyType;
	}

	/**
	 * @mbggenerated 业务提成1=分业务计算 2=合并计算(新增字段)
	 */
	public void setRoyaltyType(Byte royaltyType) {
		this.royaltyType = royaltyType;
	}

	/**
	 * @mbggenerated
	 */
	public ErpRoleWagetypeRelative() {
	}

	/**
	 * @mbggenerated
	 */
	public ErpRoleWagetypeRelative(Integer shardCityId, Integer id) {
		super(shardCityId);
		this.id = id;
	}
}