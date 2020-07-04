package com.myfun.repository.erpdb.po;

import com.myfun.repository.support.generator.shard.ShardDb;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;

public class ErpFunPartnerDept extends ShardDb implements Serializable {

	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "id")
	private Integer id;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "公司id")
	private Integer compId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "加盟圈id")
	private Integer partnerId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "门店id")
	private Integer deptId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "类型：0.直营，1加盟")
	private Byte partnerType;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "0有效，1.已删除")
	private Byte isDel;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "删除人")
	private Integer delUserId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "创建时间")
	private Date createTime;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "修改时间")
	private Date updateTime;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "合作开始时间")
	private Date cooperateStartTime;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "合作结束时间")
	private Date cooperateEndTime;
	/**
	 * @mbggenerated
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @mbggenerated id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @mbggenerated id
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
	 * @mbggenerated 加盟圈id
	 */
	public Integer getPartnerId() {
		return partnerId;
	}

	/**
	 * @mbggenerated 加盟圈id
	 */
	public void setPartnerId(Integer partnerId) {
		this.partnerId = partnerId;
	}

	/**
	 * @mbggenerated 门店id
	 */
	public Integer getDeptId() {
		return deptId;
	}

	/**
	 * @mbggenerated 门店id
	 */
	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}

	/**
	 * @mbggenerated 类型：0.直营，1加盟
	 */
	public Byte getPartnerType() {
		return partnerType;
	}

	/**
	 * @mbggenerated 类型：0.直营，1加盟
	 */
	public void setPartnerType(Byte partnerType) {
		this.partnerType = partnerType;
	}

	/**
	 * @mbggenerated 0有效，1.已删除
	 */
	public Byte getIsDel() {
		return isDel;
	}

	/**
	 * @mbggenerated 0有效，1.已删除
	 */
	public void setIsDel(Byte isDel) {
		this.isDel = isDel;
	}

	/**
	 * @mbggenerated 删除人
	 */
	public Integer getDelUserId() {
		return delUserId;
	}

	/**
	 * @mbggenerated 删除人
	 */
	public void setDelUserId(Integer delUserId) {
		this.delUserId = delUserId;
	}

	/**
	 * @mbggenerated 创建时间
	 */
	public Date getCreateTime() {
		return createTime;
	}

	/**
	 * @mbggenerated 创建时间
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	/**
	 * @mbggenerated 修改时间
	 */
	public Date getUpdateTime() {
		return updateTime;
	}

	/**
	 * @mbggenerated 修改时间
	 */
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	/**
	 * @mbggenerated 合作开始时间
	 */
	public Date getCooperateStartTime() {
		return cooperateStartTime;
	}

	/**
	 * @mbggenerated 合作开始时间
	 */
	public void setCooperateStartTime(Date cooperateStartTime) {
		this.cooperateStartTime = cooperateStartTime;
	}

	/**
	 * @mbggenerated 合作结束时间
	 */
	public Date getCooperateEndTime() {
		return cooperateEndTime;
	}

	/**
	 * @mbggenerated 合作结束时间
	 */
	public void setCooperateEndTime(Date cooperateEndTime) {
		this.cooperateEndTime = cooperateEndTime;
	}

	/**
	 * @mbggenerated
	 */
	public ErpFunPartnerDept() {
	}

	/**
	 * @mbggenerated
	 */
	public ErpFunPartnerDept(Integer shardCityId, Integer id) {
		super(shardCityId);
		this.id = id;
	}
}