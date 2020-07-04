package com.myfun.repository.erpdb.po;

import com.myfun.repository.support.generator.shard.ShardDb;
import java.io.Serializable;
import io.swagger.annotations.ApiModelProperty;

public class ErpFunReg extends ShardDb implements Serializable {

	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "区域ID")
	private Integer regId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "城市ID")
	private Short cityId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "区域名称")
	private String regName;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "序号")
	private Byte seqNo;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "是否主城区，1=是")
	private Byte mainReg;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "是否有效 0=无效 1=有效")
	private Byte vertifyFlag;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "null")
	private String updateTime;
	/**
	 * @mbggenerated
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @mbggenerated 区域ID
	 */
	public Integer getRegId() {
		return regId;
	}

	/**
	 * @mbggenerated 区域ID
	 */
	public void setRegId(Integer regId) {
		this.regId = regId;
	}

	/**
	 * @mbggenerated 城市ID
	 */
	public Short getCityId() {
		return cityId;
	}

	/**
	 * @mbggenerated 城市ID
	 */
	public void setCityId(Short cityId) {
		this.cityId = cityId;
	}

	/**
	 * @mbggenerated 区域名称
	 */
	public String getRegName() {
		return regName;
	}

	/**
	 * @mbggenerated 区域名称
	 */
	public void setRegName(String regName) {
		this.regName = regName == null ? null : regName.trim();
	}

	/**
	 * @mbggenerated 序号
	 */
	public Byte getSeqNo() {
		return seqNo;
	}

	/**
	 * @mbggenerated 序号
	 */
	public void setSeqNo(Byte seqNo) {
		this.seqNo = seqNo;
	}

	/**
	 * @mbggenerated 是否主城区，1=是
	 */
	public Byte getMainReg() {
		return mainReg;
	}

	/**
	 * @mbggenerated 是否主城区，1=是
	 */
	public void setMainReg(Byte mainReg) {
		this.mainReg = mainReg;
	}

	/**
	 * @mbggenerated 是否有效 0=无效 1=有效
	 */
	public Byte getVertifyFlag() {
		return vertifyFlag;
	}

	/**
	 * @mbggenerated 是否有效 0=无效 1=有效
	 */
	public void setVertifyFlag(Byte vertifyFlag) {
		this.vertifyFlag = vertifyFlag;
	}

	/**
	 * @mbggenerated -
	 */
	public String getUpdateTime() {
		return updateTime;
	}

	/**
	 * @mbggenerated -
	 */
	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime == null ? null : updateTime.trim();
	}

	/**
	 * @mbggenerated
	 */
	public ErpFunReg() {
	}

	/**
	 * @mbggenerated
	 */
	public ErpFunReg(Integer shardCityId, Integer regId) {
		super(shardCityId);
		this.regId = regId;
	}
}