package com.myfun.repository.erpdb.po;

import com.myfun.repository.support.generator.shard.ShardDb;
import java.io.Serializable;
import java.util.Date;
import io.swagger.annotations.ApiModelProperty;

public class ErpFunDealPaytype extends ShardDb implements Serializable {

	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "主键ID")
	private Integer paytypeId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "支付类型名称")
	private String paytypeName;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "公司ID")
	private Integer compId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "序号")
	private Integer seqNo;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "创建时间")
	private Date createTime;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "是否删除0未删除1删除")
	private Byte isDel;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "能否删除0不能1能")
	private Integer canDel;
	/**
	 * @mbggenerated
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @mbggenerated 主键ID
	 */
	public Integer getPaytypeId() {
		return paytypeId;
	}

	/**
	 * @mbggenerated 主键ID
	 */
	public void setPaytypeId(Integer paytypeId) {
		this.paytypeId = paytypeId;
	}

	/**
	 * @mbggenerated 支付类型名称
	 */
	public String getPaytypeName() {
		return paytypeName;
	}

	/**
	 * @mbggenerated 支付类型名称
	 */
	public void setPaytypeName(String paytypeName) {
		this.paytypeName = paytypeName == null ? null : paytypeName.trim();
	}

	/**
	 * @mbggenerated 公司ID
	 */
	public Integer getCompId() {
		return compId;
	}

	/**
	 * @mbggenerated 公司ID
	 */
	public void setCompId(Integer compId) {
		this.compId = compId;
	}

	/**
	 * @mbggenerated 序号
	 */
	public Integer getSeqNo() {
		return seqNo;
	}

	/**
	 * @mbggenerated 序号
	 */
	public void setSeqNo(Integer seqNo) {
		this.seqNo = seqNo;
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
	 * @mbggenerated 是否删除0未删除1删除
	 */
	public Byte getIsDel() {
		return isDel;
	}

	/**
	 * @mbggenerated 是否删除0未删除1删除
	 */
	public void setIsDel(Byte isDel) {
		this.isDel = isDel;
	}

	/**
	 * @mbggenerated 能否删除0不能1能
	 */
	public Integer getCanDel() {
		return canDel;
	}

	/**
	 * @mbggenerated 能否删除0不能1能
	 */
	public void setCanDel(Integer canDel) {
		this.canDel = canDel;
	}

	/**
	 * @mbggenerated
	 */
	public ErpFunDealPaytype() {
	}

	/**
	 * @mbggenerated
	 */
	public ErpFunDealPaytype(Integer shardCityId, Integer paytypeId) {
		super(shardCityId);
		this.paytypeId = paytypeId;
	}
}