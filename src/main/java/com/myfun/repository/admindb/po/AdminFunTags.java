package com.myfun.repository.admindb.po;

import java.io.Serializable;
import io.swagger.annotations.ApiModelProperty;

public class AdminFunTags implements Serializable {

	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "主键")
	private Integer tagsId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "城市ID，0=全国 N=本城市")
	private Integer cityId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "标签类型，1=出售 2=出租")
	private Byte tagsType;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "标签名称")
	private String tagsName;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "排序编号")
	private Integer seqNo;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "状态，1=正常 -1=删除")
	private Byte tagsStatus;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "标签用途，DD:HOUSE_UESAGE")
	private Byte useage;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "null")
	private Integer score;
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
	 * @mbggenerated 主键
	 */
	public Integer getTagsId() {
		return tagsId;
	}

	/**
	 * @mbggenerated 主键
	 */
	public void setTagsId(Integer tagsId) {
		this.tagsId = tagsId;
	}

	/**
	 * @mbggenerated 城市ID，0=全国 N=本城市
	 */
	public Integer getCityId() {
		return cityId;
	}

	/**
	 * @mbggenerated 城市ID，0=全国 N=本城市
	 */
	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}

	/**
	 * @mbggenerated 标签类型，1=出售 2=出租
	 */
	public Byte getTagsType() {
		return tagsType;
	}

	/**
	 * @mbggenerated 标签类型，1=出售 2=出租
	 */
	public void setTagsType(Byte tagsType) {
		this.tagsType = tagsType;
	}

	/**
	 * @mbggenerated 标签名称
	 */
	public String getTagsName() {
		return tagsName;
	}

	/**
	 * @mbggenerated 标签名称
	 */
	public void setTagsName(String tagsName) {
		this.tagsName = tagsName;
	}

	/**
	 * @mbggenerated 排序编号
	 */
	public Integer getSeqNo() {
		return seqNo;
	}

	/**
	 * @mbggenerated 排序编号
	 */
	public void setSeqNo(Integer seqNo) {
		this.seqNo = seqNo;
	}

	/**
	 * @mbggenerated 状态，1=正常 -1=删除
	 */
	public Byte getTagsStatus() {
		return tagsStatus;
	}

	/**
	 * @mbggenerated 状态，1=正常 -1=删除
	 */
	public void setTagsStatus(Byte tagsStatus) {
		this.tagsStatus = tagsStatus;
	}

	/**
	 * @mbggenerated 标签用途，DD:HOUSE_UESAGE
	 */
	public Byte getUseage() {
		return useage;
	}

	/**
	 * @mbggenerated 标签用途，DD:HOUSE_UESAGE
	 */
	public void setUseage(Byte useage) {
		this.useage = useage;
	}

	/**
	 * @mbggenerated -
	 */
	public Integer getScore() {
		return score;
	}

	/**
	 * @mbggenerated -
	 */
	public void setScore(Integer score) {
		this.score = score;
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
		this.updateTime = updateTime;
	}
}