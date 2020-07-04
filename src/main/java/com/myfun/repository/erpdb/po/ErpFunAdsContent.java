package com.myfun.repository.erpdb.po;

import com.myfun.repository.support.generator.shard.ShardDb;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import io.swagger.annotations.ApiModelProperty;

public class ErpFunAdsContent extends ShardDb implements Serializable {

	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "主键")
	private Integer adsContentId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "房源ID")
	private Integer caseId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "房源类型")
	private Byte caseType;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "操作人")
	private Integer userId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "操作人的公司ID")
	private Integer compId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "操作人门店")
	private Integer deptId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "广告语")
	private String adsContent;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "创建时间")
	private Date creationTime;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "状态  0：撤销 1：点亮")
	private Byte adsStatus;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "取消时间")
	private Date cancleTime;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "房源编号")
	private String caseNo;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "推荐价")
	private BigDecimal recommendPrice;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "价格单位")
	private Byte priceUnit;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "广告房源增加见报手机字段")
	private String newspapperTel;
	/**
	 * @mbggenerated
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @mbggenerated 主键
	 */
	public Integer getAdsContentId() {
		return adsContentId;
	}

	/**
	 * @mbggenerated 主键
	 */
	public void setAdsContentId(Integer adsContentId) {
		this.adsContentId = adsContentId;
	}

	/**
	 * @mbggenerated 房源ID
	 */
	public Integer getCaseId() {
		return caseId;
	}

	/**
	 * @mbggenerated 房源ID
	 */
	public void setCaseId(Integer caseId) {
		this.caseId = caseId;
	}

	/**
	 * @mbggenerated 房源类型
	 */
	public Byte getCaseType() {
		return caseType;
	}

	/**
	 * @mbggenerated 房源类型
	 */
	public void setCaseType(Byte caseType) {
		this.caseType = caseType;
	}

	/**
	 * @mbggenerated 操作人
	 */
	public Integer getUserId() {
		return userId;
	}

	/**
	 * @mbggenerated 操作人
	 */
	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	/**
	 * @mbggenerated 操作人的公司ID
	 */
	public Integer getCompId() {
		return compId;
	}

	/**
	 * @mbggenerated 操作人的公司ID
	 */
	public void setCompId(Integer compId) {
		this.compId = compId;
	}

	/**
	 * @mbggenerated 操作人门店
	 */
	public Integer getDeptId() {
		return deptId;
	}

	/**
	 * @mbggenerated 操作人门店
	 */
	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}

	/**
	 * @mbggenerated 广告语
	 */
	public String getAdsContent() {
		return adsContent;
	}

	/**
	 * @mbggenerated 广告语
	 */
	public void setAdsContent(String adsContent) {
		this.adsContent = adsContent;
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
	 * @mbggenerated 状态  0：撤销 1：点亮
	 */
	public Byte getAdsStatus() {
		return adsStatus;
	}

	/**
	 * @mbggenerated 状态  0：撤销 1：点亮
	 */
	public void setAdsStatus(Byte adsStatus) {
		this.adsStatus = adsStatus;
	}

	/**
	 * @mbggenerated 取消时间
	 */
	public Date getCancleTime() {
		return cancleTime;
	}

	/**
	 * @mbggenerated 取消时间
	 */
	public void setCancleTime(Date cancleTime) {
		this.cancleTime = cancleTime;
	}

	/**
	 * @mbggenerated 房源编号
	 */
	public String getCaseNo() {
		return caseNo;
	}

	/**
	 * @mbggenerated 房源编号
	 */
	public void setCaseNo(String caseNo) {
		this.caseNo = caseNo;
	}

	/**
	 * @mbggenerated 推荐价
	 */
	public BigDecimal getRecommendPrice() {
		return recommendPrice;
	}

	/**
	 * @mbggenerated 推荐价
	 */
	public void setRecommendPrice(BigDecimal recommendPrice) {
		this.recommendPrice = recommendPrice;
	}

	/**
	 * @mbggenerated 价格单位
	 */
	public Byte getPriceUnit() {
		return priceUnit;
	}

	/**
	 * @mbggenerated 价格单位
	 */
	public void setPriceUnit(Byte priceUnit) {
		this.priceUnit = priceUnit;
	}

	/**
	 * @mbggenerated 广告房源增加见报手机字段
	 */
	public String getNewspapperTel() {
		return newspapperTel;
	}

	/**
	 * @mbggenerated 广告房源增加见报手机字段
	 */
	public void setNewspapperTel(String newspapperTel) {
		this.newspapperTel = newspapperTel;
	}

	/**
	 * @mbggenerated
	 */
	public ErpFunAdsContent() {
	}

	/**
	 * @mbggenerated
	 */
	public ErpFunAdsContent(Integer shardCityId, Integer adsContentId) {
		super(shardCityId);
		this.adsContentId = adsContentId;
	}
}