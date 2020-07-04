package com.myfun.repository.erpdb.po;

import com.myfun.repository.support.generator.shard.ShardDb;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;

public class ErpFunWorkcountTargetTemplate extends ShardDb implements Serializable {

	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "主键")
	private Integer id;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "公司ID")
	private Integer compId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "跟进房源量")
	private Integer gjHouseCount;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "跟进客源量")
	private Integer gjCustomerCount;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "VR上传")
	private Integer vrCount;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "视频上传")
	private Integer spCount;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "空看")
	private Integer kkCount;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "房源群发")
	private Integer houseFafaCount;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "朋友圈分享")
	private Integer postShareCount;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "房源新增")
	private Integer houseAdd;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "客源新增")
	private Integer customerAdd;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "带客")
	private Integer dkCount;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "房堪")
	private Integer fkCount;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "钥匙提交")
	private Integer ysCount;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "独家委托")
	private Integer djwtCount;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "签单量,成交量")
	private Integer signDealCount;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "1=日目标  2=周目标  3=月目标")
	private Byte targetType;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "创建时间 周考核 存周一的时间")
	private Date createTime;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "图片上传")
	private Integer tpscCount;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "查看电话")
	private Integer ckdhCount;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "限时委托")
	private Integer xswtCount;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "包租委托")
	private Integer bzwtCount;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "委托")
	private Integer wtCount;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "范围类型1=公司2=大区3=片区4=门店5=分组")
	private Byte rangeType;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "门店id")
	private Integer deptId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "角色id 对应ERP库COMP_ROLES的ROLE_ID")
	private String userPosition;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "房源面谈")
	private Integer mtHouseCount;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "客源面谈")
	private Integer mtCustomerCount;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "约看")
	private Integer kyykCount;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "议价")
	private Integer yjCount;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "隐号拨打")
	private Integer ipcallCount;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "加盟id 0=总部，-1直营,>0加盟商的id")
	private Integer partnerId;
	/**
	 * @mbggenerated
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @mbggenerated 主键
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @mbggenerated 主键
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
	 * @mbggenerated 跟进房源量
	 */
	public Integer getGjHouseCount() {
		return gjHouseCount;
	}

	/**
	 * @mbggenerated 跟进房源量
	 */
	public void setGjHouseCount(Integer gjHouseCount) {
		this.gjHouseCount = gjHouseCount;
	}

	/**
	 * @mbggenerated 跟进客源量
	 */
	public Integer getGjCustomerCount() {
		return gjCustomerCount;
	}

	/**
	 * @mbggenerated 跟进客源量
	 */
	public void setGjCustomerCount(Integer gjCustomerCount) {
		this.gjCustomerCount = gjCustomerCount;
	}

	/**
	 * @mbggenerated VR上传
	 */
	public Integer getVrCount() {
		return vrCount;
	}

	/**
	 * @mbggenerated VR上传
	 */
	public void setVrCount(Integer vrCount) {
		this.vrCount = vrCount;
	}

	/**
	 * @mbggenerated 视频上传
	 */
	public Integer getSpCount() {
		return spCount;
	}

	/**
	 * @mbggenerated 视频上传
	 */
	public void setSpCount(Integer spCount) {
		this.spCount = spCount;
	}

	/**
	 * @mbggenerated 空看
	 */
	public Integer getKkCount() {
		return kkCount;
	}

	/**
	 * @mbggenerated 空看
	 */
	public void setKkCount(Integer kkCount) {
		this.kkCount = kkCount;
	}

	/**
	 * @mbggenerated 房源群发
	 */
	public Integer getHouseFafaCount() {
		return houseFafaCount;
	}

	/**
	 * @mbggenerated 房源群发
	 */
	public void setHouseFafaCount(Integer houseFafaCount) {
		this.houseFafaCount = houseFafaCount;
	}

	/**
	 * @mbggenerated 朋友圈分享
	 */
	public Integer getPostShareCount() {
		return postShareCount;
	}

	/**
	 * @mbggenerated 朋友圈分享
	 */
	public void setPostShareCount(Integer postShareCount) {
		this.postShareCount = postShareCount;
	}

	/**
	 * @mbggenerated 房源新增
	 */
	public Integer getHouseAdd() {
		return houseAdd;
	}

	/**
	 * @mbggenerated 房源新增
	 */
	public void setHouseAdd(Integer houseAdd) {
		this.houseAdd = houseAdd;
	}

	/**
	 * @mbggenerated 客源新增
	 */
	public Integer getCustomerAdd() {
		return customerAdd;
	}

	/**
	 * @mbggenerated 客源新增
	 */
	public void setCustomerAdd(Integer customerAdd) {
		this.customerAdd = customerAdd;
	}

	/**
	 * @mbggenerated 带客
	 */
	public Integer getDkCount() {
		return dkCount;
	}

	/**
	 * @mbggenerated 带客
	 */
	public void setDkCount(Integer dkCount) {
		this.dkCount = dkCount;
	}

	/**
	 * @mbggenerated 房堪
	 */
	public Integer getFkCount() {
		return fkCount;
	}

	/**
	 * @mbggenerated 房堪
	 */
	public void setFkCount(Integer fkCount) {
		this.fkCount = fkCount;
	}

	/**
	 * @mbggenerated 钥匙提交
	 */
	public Integer getYsCount() {
		return ysCount;
	}

	/**
	 * @mbggenerated 钥匙提交
	 */
	public void setYsCount(Integer ysCount) {
		this.ysCount = ysCount;
	}

	/**
	 * @mbggenerated 独家委托
	 */
	public Integer getDjwtCount() {
		return djwtCount;
	}

	/**
	 * @mbggenerated 独家委托
	 */
	public void setDjwtCount(Integer djwtCount) {
		this.djwtCount = djwtCount;
	}

	/**
	 * @mbggenerated 签单量,成交量
	 */
	public Integer getSignDealCount() {
		return signDealCount;
	}

	/**
	 * @mbggenerated 签单量,成交量
	 */
	public void setSignDealCount(Integer signDealCount) {
		this.signDealCount = signDealCount;
	}

	/**
	 * @mbggenerated 1=日目标  2=周目标  3=月目标
	 */
	public Byte getTargetType() {
		return targetType;
	}

	/**
	 * @mbggenerated 1=日目标  2=周目标  3=月目标
	 */
	public void setTargetType(Byte targetType) {
		this.targetType = targetType;
	}

	/**
	 * @mbggenerated 创建时间 周考核 存周一的时间
	 */
	public Date getCreateTime() {
		return createTime;
	}

	/**
	 * @mbggenerated 创建时间 周考核 存周一的时间
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	/**
	 * @mbggenerated 图片上传
	 */
	public Integer getTpscCount() {
		return tpscCount;
	}

	/**
	 * @mbggenerated 图片上传
	 */
	public void setTpscCount(Integer tpscCount) {
		this.tpscCount = tpscCount;
	}

	/**
	 * @mbggenerated 查看电话
	 */
	public Integer getCkdhCount() {
		return ckdhCount;
	}

	/**
	 * @mbggenerated 查看电话
	 */
	public void setCkdhCount(Integer ckdhCount) {
		this.ckdhCount = ckdhCount;
	}

	/**
	 * @mbggenerated 限时委托
	 */
	public Integer getXswtCount() {
		return xswtCount;
	}

	/**
	 * @mbggenerated 限时委托
	 */
	public void setXswtCount(Integer xswtCount) {
		this.xswtCount = xswtCount;
	}

	/**
	 * @mbggenerated 包租委托
	 */
	public Integer getBzwtCount() {
		return bzwtCount;
	}

	/**
	 * @mbggenerated 包租委托
	 */
	public void setBzwtCount(Integer bzwtCount) {
		this.bzwtCount = bzwtCount;
	}

	/**
	 * @mbggenerated 委托
	 */
	public Integer getWtCount() {
		return wtCount;
	}

	/**
	 * @mbggenerated 委托
	 */
	public void setWtCount(Integer wtCount) {
		this.wtCount = wtCount;
	}

	/**
	 * @mbggenerated 范围类型1=公司2=大区3=片区4=门店5=分组
	 */
	public Byte getRangeType() {
		return rangeType;
	}

	/**
	 * @mbggenerated 范围类型1=公司2=大区3=片区4=门店5=分组
	 */
	public void setRangeType(Byte rangeType) {
		this.rangeType = rangeType;
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
	 * @mbggenerated 角色id 对应ERP库COMP_ROLES的ROLE_ID
	 */
	public String getUserPosition() {
		return userPosition;
	}

	/**
	 * @mbggenerated 角色id 对应ERP库COMP_ROLES的ROLE_ID
	 */
	public void setUserPosition(String userPosition) {
		this.userPosition = userPosition == null ? null : userPosition.trim();
	}

	/**
	 * @mbggenerated 房源面谈
	 */
	public Integer getMtHouseCount() {
		return mtHouseCount;
	}

	/**
	 * @mbggenerated 房源面谈
	 */
	public void setMtHouseCount(Integer mtHouseCount) {
		this.mtHouseCount = mtHouseCount;
	}

	/**
	 * @mbggenerated 客源面谈
	 */
	public Integer getMtCustomerCount() {
		return mtCustomerCount;
	}

	/**
	 * @mbggenerated 客源面谈
	 */
	public void setMtCustomerCount(Integer mtCustomerCount) {
		this.mtCustomerCount = mtCustomerCount;
	}

	/**
	 * @mbggenerated 约看
	 */
	public Integer getKyykCount() {
		return kyykCount;
	}

	/**
	 * @mbggenerated 约看
	 */
	public void setKyykCount(Integer kyykCount) {
		this.kyykCount = kyykCount;
	}

	/**
	 * @mbggenerated 议价
	 */
	public Integer getYjCount() {
		return yjCount;
	}

	/**
	 * @mbggenerated 议价
	 */
	public void setYjCount(Integer yjCount) {
		this.yjCount = yjCount;
	}

	/**
	 * @mbggenerated 隐号拨打
	 */
	public Integer getIpcallCount() {
		return ipcallCount;
	}

	/**
	 * @mbggenerated 隐号拨打
	 */
	public void setIpcallCount(Integer ipcallCount) {
		this.ipcallCount = ipcallCount;
	}

	/**
	 * @mbggenerated 加盟id 0=总部，-1直营,>0加盟商的id
	 */
	public Integer getPartnerId() {
		return partnerId;
	}

	/**
	 * @mbggenerated 加盟id 0=总部，-1直营,>0加盟商的id
	 */
	public void setPartnerId(Integer partnerId) {
		this.partnerId = partnerId;
	}

	/**
	 * @mbggenerated
	 */
	public ErpFunWorkcountTargetTemplate() {
	}

	/**
	 * @mbggenerated
	 */
	public ErpFunWorkcountTargetTemplate(Integer shardCityId, Integer id) {
		super(shardCityId);
		this.id = id;
	}
}