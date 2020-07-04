package com.myfun.repository.erpdb.po;

import com.myfun.repository.support.generator.shard.ShardDb;
import java.io.Serializable;
import java.util.Date;
import io.swagger.annotations.ApiModelProperty;

public class ErpFunTrackExtend extends ShardDb implements Serializable {

	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "主键ID")
	private Integer id;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "公司ID")
	private Integer compId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "审批ID")
	private Integer auditId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "跟进ID")
	private Integer trackId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "(出售)装修描述 出租(房屋配套)")
	private String fitmentDescribe;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "(出售)核心卖点   出租（房屋优势）")
	private String coreSellPoint;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "(出售)产权情况")
	private String propertyRights;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "(出售)户型介绍  (出租)户型介绍")
	private String layoutIntroduce;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "创建时间")
	private Date creationTime;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "房堪的其他信息")
	private String otherInfo;
	/**
	 * @mbggenerated
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @mbggenerated 主键ID
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @mbggenerated 主键ID
	 */
	public void setId(Integer id) {
		this.id = id;
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
	 * @mbggenerated 审批ID
	 */
	public Integer getAuditId() {
		return auditId;
	}

	/**
	 * @mbggenerated 审批ID
	 */
	public void setAuditId(Integer auditId) {
		this.auditId = auditId;
	}

	/**
	 * @mbggenerated 跟进ID
	 */
	public Integer getTrackId() {
		return trackId;
	}

	/**
	 * @mbggenerated 跟进ID
	 */
	public void setTrackId(Integer trackId) {
		this.trackId = trackId;
	}

	/**
	 * @mbggenerated (出售)装修描述 出租(房屋配套)
	 */
	public String getFitmentDescribe() {
		return fitmentDescribe;
	}

	/**
	 * @mbggenerated (出售)装修描述 出租(房屋配套)
	 */
	public void setFitmentDescribe(String fitmentDescribe) {
		this.fitmentDescribe = fitmentDescribe == null ? null : fitmentDescribe.trim();
	}

	/**
	 * @mbggenerated (出售)核心卖点   出租（房屋优势）
	 */
	public String getCoreSellPoint() {
		return coreSellPoint;
	}

	/**
	 * @mbggenerated (出售)核心卖点   出租（房屋优势）
	 */
	public void setCoreSellPoint(String coreSellPoint) {
		this.coreSellPoint = coreSellPoint == null ? null : coreSellPoint.trim();
	}

	/**
	 * @mbggenerated (出售)产权情况
	 */
	public String getPropertyRights() {
		return propertyRights;
	}

	/**
	 * @mbggenerated (出售)产权情况
	 */
	public void setPropertyRights(String propertyRights) {
		this.propertyRights = propertyRights == null ? null : propertyRights.trim();
	}

	/**
	 * @mbggenerated (出售)户型介绍  (出租)户型介绍
	 */
	public String getLayoutIntroduce() {
		return layoutIntroduce;
	}

	/**
	 * @mbggenerated (出售)户型介绍  (出租)户型介绍
	 */
	public void setLayoutIntroduce(String layoutIntroduce) {
		this.layoutIntroduce = layoutIntroduce == null ? null : layoutIntroduce.trim();
	}

	/**
	 * @mbggenerated 创建时间
	 */
	public Date getCreationTime() {
		return creationTime;
	}

	/**
	 * @mbggenerated 创建时间
	 */
	public void setCreationTime(Date creationTime) {
		this.creationTime = creationTime;
	}

	/**
	 * @mbggenerated 房堪的其他信息
	 */
	public String getOtherInfo() {
		return otherInfo;
	}

	/**
	 * @mbggenerated 房堪的其他信息
	 */
	public void setOtherInfo(String otherInfo) {
		this.otherInfo = otherInfo == null ? null : otherInfo.trim();
	}

	/**
	 * @mbggenerated
	 */
	public ErpFunTrackExtend() {
	}

	/**
	 * @mbggenerated
	 */
	public ErpFunTrackExtend(Integer shardCityId, Integer id) {
		super(shardCityId);
		this.id = id;
	}
}