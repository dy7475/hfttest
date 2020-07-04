package com.myfun.repository.erpdb.po;

import com.myfun.repository.support.generator.shard.ShardDb;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class ErpFunAssessmentStatistics extends ShardDb implements Serializable {

	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "主键   一个人一月最多：管理+个人的租赁+买卖，四条记录")
	private Integer id;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "城市ID")
	private Integer cityId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "公司ID")
	private Integer compId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "大区")
	private Integer areaId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "片区")
	private Integer regId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "门店ID")
	private Integer deptId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "分组")
	private Integer grId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "null")
	private String userPosition;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "null")
	private Date assessmentCycleStart;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "null")
	private Date assessmentCycleEnd;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "月份")
	private String assessmentMonth;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "人数")
	private BigDecimal userCount;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "创建时间")
	private Date createTime;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "房新增")
	private BigDecimal xzFxzCount;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "客新增")
	private BigDecimal xzKxzCount;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "跟进量")
	private BigDecimal xzGjCount;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "图片上传")
	private BigDecimal xzTpscCount;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "视频上传")
	private BigDecimal xzSpscCount;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "VR上传")
	private BigDecimal xzVrscCount;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "真房源")
	private BigDecimal xzZfyCount;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "IP拨打")
	private BigDecimal xzIpcallCount;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "看房点评")
	private BigDecimal xzKfdpCount;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "null")
	private BigDecimal xzHbfxCount;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "null")
	private BigDecimal xzYstjCount;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "null")
	private BigDecimal xzPtwtCount;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "null")
	private BigDecimal xzXswtCount;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "null")
	private BigDecimal xzDjwtCount;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "null")
	private BigDecimal xzBzwtCount;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "null")
	private BigDecimal xzFkCount;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "null")
	private BigDecimal xzYjCount;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "null")
	private BigDecimal xzDkCount;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "有效新增-房新增量")
	private BigDecimal xzyxFxzCount;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "有效新增-客新增量")
	private BigDecimal xzyxKxzCount;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "有效新增-跟进量")
	private BigDecimal xzyxGjCount;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "有效图片上传量")
	private BigDecimal xzyxTpscCount;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "null")
	private BigDecimal xzyxSpscCount;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "null")
	private BigDecimal xzyxVrscCount;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "null")
	private BigDecimal xzyxZfyCount;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "null")
	private BigDecimal xzyxIpcallCount;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "null")
	private BigDecimal xzyxKfdpCount;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "null")
	private BigDecimal xzyxHbfxCount;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "null")
	private BigDecimal xzyxYstjCount;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "null")
	private BigDecimal xzyxPtwtCount;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "null")
	private BigDecimal xzyxXswtCount;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "null")
	private BigDecimal xzyxDjwtCount;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "null")
	private BigDecimal xzyxBzwtCount;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "有效房堪")
	private BigDecimal xzyxFkCount;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "null")
	private BigDecimal xzyxYjCount;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "有效带看")
	private BigDecimal xzyxDkCount;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "被考核人")
	private Integer userId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "房客类型 1=买卖 2=租赁")
	private Byte caseType;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "工作量类型 1=个人 2=管理")
	private Byte checkType;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "角色配置模板ID")
	private Integer roleWageConfigId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "合同总业绩金额")
	private BigDecimal xzProfitAmount;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "合同有效业绩金额")
	private BigDecimal xzyxProfitAmount;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "1删除 0 正常")
	private Byte dealFlag;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "档案ID")
	private Integer archiveId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "房登记")
	private BigDecimal xzFdjCount;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "有效房登记")
	private BigDecimal xzyxFdjCount;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "楼盘资料转入")
	private BigDecimal xzBuildinfoCount;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "有效楼盘资料转入")
	private BigDecimal xzyxBuildinfoCount;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "搜搜转入")
	private BigDecimal xzSosoCount;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "有效搜搜转入")
	private BigDecimal xzyxSosoCount;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "null")
	private BigDecimal xzFpublicZpCount;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "null")
	private BigDecimal xzyxFpublicZpCount;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "null")
	private BigDecimal xzFshareZpCount;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "null")
	private BigDecimal xzyxFshareZpCount;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "null")
	private BigDecimal xzFzyxCount;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "null")
	private BigDecimal xzyxFzyxCount;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "null")
	private BigDecimal xzKdjCount;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "null")
	private BigDecimal xzyxKdjCount;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "null")
	private BigDecimal xzKpublicZpCount;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "null")
	private BigDecimal xzyxKpublicZpCount;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "null")
	private BigDecimal xzKshareZpCount;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "null")
	private BigDecimal xzyxKshareZpCount;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "null")
	private BigDecimal xzKzyxCount;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "null")
	private BigDecimal xzyxKzyxCount;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "取消暂缓")
	private BigDecimal xzQxzhCount;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "null")
	private BigDecimal xzyxQxzhCount;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "本月是否生效--新员工注册进来受系统参数控制是否生效 1:生效")
	private Byte effectiveStatus;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "null")
	private Integer organizationId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "null")
	private String organizationPath;
	/**
	 * @mbggenerated
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @mbggenerated 主键   一个人一月最多：管理+个人的租赁+买卖，四条记录
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @mbggenerated 主键   一个人一月最多：管理+个人的租赁+买卖，四条记录
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @mbggenerated 城市ID
	 */
	public Integer getCityId() {
		return cityId;
	}

	/**
	 * @mbggenerated 城市ID
	 */
	public void setCityId(Integer cityId) {
		this.cityId = cityId;
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
	 * @mbggenerated 大区
	 */
	public Integer getAreaId() {
		return areaId;
	}

	/**
	 * @mbggenerated 大区
	 */
	public void setAreaId(Integer areaId) {
		this.areaId = areaId;
	}

	/**
	 * @mbggenerated 片区
	 */
	public Integer getRegId() {
		return regId;
	}

	/**
	 * @mbggenerated 片区
	 */
	public void setRegId(Integer regId) {
		this.regId = regId;
	}

	/**
	 * @mbggenerated 门店ID
	 */
	public Integer getDeptId() {
		return deptId;
	}

	/**
	 * @mbggenerated 门店ID
	 */
	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}

	/**
	 * @mbggenerated 分组
	 */
	public Integer getGrId() {
		return grId;
	}

	/**
	 * @mbggenerated 分组
	 */
	public void setGrId(Integer grId) {
		this.grId = grId;
	}

	/**
	 * @mbggenerated -
	 */
	public String getUserPosition() {
		return userPosition;
	}

	/**
	 * @mbggenerated -
	 */
	public void setUserPosition(String userPosition) {
		this.userPosition = userPosition;
	}

	/**
	 * @mbggenerated -
	 */
	public Date getAssessmentCycleStart() {
		return assessmentCycleStart;
	}

	/**
	 * @mbggenerated -
	 */
	public void setAssessmentCycleStart(Date assessmentCycleStart) {
		this.assessmentCycleStart = assessmentCycleStart;
	}

	/**
	 * @mbggenerated -
	 */
	public Date getAssessmentCycleEnd() {
		return assessmentCycleEnd;
	}

	/**
	 * @mbggenerated -
	 */
	public void setAssessmentCycleEnd(Date assessmentCycleEnd) {
		this.assessmentCycleEnd = assessmentCycleEnd;
	}

	/**
	 * @mbggenerated 月份
	 */
	public String getAssessmentMonth() {
		return assessmentMonth;
	}

	/**
	 * @mbggenerated 月份
	 */
	public void setAssessmentMonth(String assessmentMonth) {
		this.assessmentMonth = assessmentMonth;
	}

	/**
	 * @mbggenerated 人数
	 */
	public BigDecimal getUserCount() {
		return userCount;
	}

	/**
	 * @mbggenerated 人数
	 */
	public void setUserCount(BigDecimal userCount) {
		this.userCount = userCount;
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
	 * @mbggenerated 房新增
	 */
	public BigDecimal getXzFxzCount() {
		return xzFxzCount;
	}

	/**
	 * @mbggenerated 房新增
	 */
	public void setXzFxzCount(BigDecimal xzFxzCount) {
		this.xzFxzCount = xzFxzCount;
	}

	/**
	 * @mbggenerated 客新增
	 */
	public BigDecimal getXzKxzCount() {
		return xzKxzCount;
	}

	/**
	 * @mbggenerated 客新增
	 */
	public void setXzKxzCount(BigDecimal xzKxzCount) {
		this.xzKxzCount = xzKxzCount;
	}

	/**
	 * @mbggenerated 跟进量
	 */
	public BigDecimal getXzGjCount() {
		return xzGjCount;
	}

	/**
	 * @mbggenerated 跟进量
	 */
	public void setXzGjCount(BigDecimal xzGjCount) {
		this.xzGjCount = xzGjCount;
	}

	/**
	 * @mbggenerated 图片上传
	 */
	public BigDecimal getXzTpscCount() {
		return xzTpscCount;
	}

	/**
	 * @mbggenerated 图片上传
	 */
	public void setXzTpscCount(BigDecimal xzTpscCount) {
		this.xzTpscCount = xzTpscCount;
	}

	/**
	 * @mbggenerated 视频上传
	 */
	public BigDecimal getXzSpscCount() {
		return xzSpscCount;
	}

	/**
	 * @mbggenerated 视频上传
	 */
	public void setXzSpscCount(BigDecimal xzSpscCount) {
		this.xzSpscCount = xzSpscCount;
	}

	/**
	 * @mbggenerated VR上传
	 */
	public BigDecimal getXzVrscCount() {
		return xzVrscCount;
	}

	/**
	 * @mbggenerated VR上传
	 */
	public void setXzVrscCount(BigDecimal xzVrscCount) {
		this.xzVrscCount = xzVrscCount;
	}

	/**
	 * @mbggenerated 真房源
	 */
	public BigDecimal getXzZfyCount() {
		return xzZfyCount;
	}

	/**
	 * @mbggenerated 真房源
	 */
	public void setXzZfyCount(BigDecimal xzZfyCount) {
		this.xzZfyCount = xzZfyCount;
	}

	/**
	 * @mbggenerated IP拨打
	 */
	public BigDecimal getXzIpcallCount() {
		return xzIpcallCount;
	}

	/**
	 * @mbggenerated IP拨打
	 */
	public void setXzIpcallCount(BigDecimal xzIpcallCount) {
		this.xzIpcallCount = xzIpcallCount;
	}

	/**
	 * @mbggenerated 看房点评
	 */
	public BigDecimal getXzKfdpCount() {
		return xzKfdpCount;
	}

	/**
	 * @mbggenerated 看房点评
	 */
	public void setXzKfdpCount(BigDecimal xzKfdpCount) {
		this.xzKfdpCount = xzKfdpCount;
	}

	/**
	 * @mbggenerated -
	 */
	public BigDecimal getXzHbfxCount() {
		return xzHbfxCount;
	}

	/**
	 * @mbggenerated -
	 */
	public void setXzHbfxCount(BigDecimal xzHbfxCount) {
		this.xzHbfxCount = xzHbfxCount;
	}

	/**
	 * @mbggenerated -
	 */
	public BigDecimal getXzYstjCount() {
		return xzYstjCount;
	}

	/**
	 * @mbggenerated -
	 */
	public void setXzYstjCount(BigDecimal xzYstjCount) {
		this.xzYstjCount = xzYstjCount;
	}

	/**
	 * @mbggenerated -
	 */
	public BigDecimal getXzPtwtCount() {
		return xzPtwtCount;
	}

	/**
	 * @mbggenerated -
	 */
	public void setXzPtwtCount(BigDecimal xzPtwtCount) {
		this.xzPtwtCount = xzPtwtCount;
	}

	/**
	 * @mbggenerated -
	 */
	public BigDecimal getXzXswtCount() {
		return xzXswtCount;
	}

	/**
	 * @mbggenerated -
	 */
	public void setXzXswtCount(BigDecimal xzXswtCount) {
		this.xzXswtCount = xzXswtCount;
	}

	/**
	 * @mbggenerated -
	 */
	public BigDecimal getXzDjwtCount() {
		return xzDjwtCount;
	}

	/**
	 * @mbggenerated -
	 */
	public void setXzDjwtCount(BigDecimal xzDjwtCount) {
		this.xzDjwtCount = xzDjwtCount;
	}

	/**
	 * @mbggenerated -
	 */
	public BigDecimal getXzBzwtCount() {
		return xzBzwtCount;
	}

	/**
	 * @mbggenerated -
	 */
	public void setXzBzwtCount(BigDecimal xzBzwtCount) {
		this.xzBzwtCount = xzBzwtCount;
	}

	/**
	 * @mbggenerated -
	 */
	public BigDecimal getXzFkCount() {
		return xzFkCount;
	}

	/**
	 * @mbggenerated -
	 */
	public void setXzFkCount(BigDecimal xzFkCount) {
		this.xzFkCount = xzFkCount;
	}

	/**
	 * @mbggenerated -
	 */
	public BigDecimal getXzYjCount() {
		return xzYjCount;
	}

	/**
	 * @mbggenerated -
	 */
	public void setXzYjCount(BigDecimal xzYjCount) {
		this.xzYjCount = xzYjCount;
	}

	/**
	 * @mbggenerated -
	 */
	public BigDecimal getXzDkCount() {
		return xzDkCount;
	}

	/**
	 * @mbggenerated -
	 */
	public void setXzDkCount(BigDecimal xzDkCount) {
		this.xzDkCount = xzDkCount;
	}

	/**
	 * @mbggenerated 有效新增-房新增量
	 */
	public BigDecimal getXzyxFxzCount() {
		return xzyxFxzCount;
	}

	/**
	 * @mbggenerated 有效新增-房新增量
	 */
	public void setXzyxFxzCount(BigDecimal xzyxFxzCount) {
		this.xzyxFxzCount = xzyxFxzCount;
	}

	/**
	 * @mbggenerated 有效新增-客新增量
	 */
	public BigDecimal getXzyxKxzCount() {
		return xzyxKxzCount;
	}

	/**
	 * @mbggenerated 有效新增-客新增量
	 */
	public void setXzyxKxzCount(BigDecimal xzyxKxzCount) {
		this.xzyxKxzCount = xzyxKxzCount;
	}

	/**
	 * @mbggenerated 有效新增-跟进量
	 */
	public BigDecimal getXzyxGjCount() {
		return xzyxGjCount;
	}

	/**
	 * @mbggenerated 有效新增-跟进量
	 */
	public void setXzyxGjCount(BigDecimal xzyxGjCount) {
		this.xzyxGjCount = xzyxGjCount;
	}

	/**
	 * @mbggenerated 有效图片上传量
	 */
	public BigDecimal getXzyxTpscCount() {
		return xzyxTpscCount;
	}

	/**
	 * @mbggenerated 有效图片上传量
	 */
	public void setXzyxTpscCount(BigDecimal xzyxTpscCount) {
		this.xzyxTpscCount = xzyxTpscCount;
	}

	/**
	 * @mbggenerated -
	 */
	public BigDecimal getXzyxSpscCount() {
		return xzyxSpscCount;
	}

	/**
	 * @mbggenerated -
	 */
	public void setXzyxSpscCount(BigDecimal xzyxSpscCount) {
		this.xzyxSpscCount = xzyxSpscCount;
	}

	/**
	 * @mbggenerated -
	 */
	public BigDecimal getXzyxVrscCount() {
		return xzyxVrscCount;
	}

	/**
	 * @mbggenerated -
	 */
	public void setXzyxVrscCount(BigDecimal xzyxVrscCount) {
		this.xzyxVrscCount = xzyxVrscCount;
	}

	/**
	 * @mbggenerated -
	 */
	public BigDecimal getXzyxZfyCount() {
		return xzyxZfyCount;
	}

	/**
	 * @mbggenerated -
	 */
	public void setXzyxZfyCount(BigDecimal xzyxZfyCount) {
		this.xzyxZfyCount = xzyxZfyCount;
	}

	/**
	 * @mbggenerated -
	 */
	public BigDecimal getXzyxIpcallCount() {
		return xzyxIpcallCount;
	}

	/**
	 * @mbggenerated -
	 */
	public void setXzyxIpcallCount(BigDecimal xzyxIpcallCount) {
		this.xzyxIpcallCount = xzyxIpcallCount;
	}

	/**
	 * @mbggenerated -
	 */
	public BigDecimal getXzyxKfdpCount() {
		return xzyxKfdpCount;
	}

	/**
	 * @mbggenerated -
	 */
	public void setXzyxKfdpCount(BigDecimal xzyxKfdpCount) {
		this.xzyxKfdpCount = xzyxKfdpCount;
	}

	/**
	 * @mbggenerated -
	 */
	public BigDecimal getXzyxHbfxCount() {
		return xzyxHbfxCount;
	}

	/**
	 * @mbggenerated -
	 */
	public void setXzyxHbfxCount(BigDecimal xzyxHbfxCount) {
		this.xzyxHbfxCount = xzyxHbfxCount;
	}

	/**
	 * @mbggenerated -
	 */
	public BigDecimal getXzyxYstjCount() {
		return xzyxYstjCount;
	}

	/**
	 * @mbggenerated -
	 */
	public void setXzyxYstjCount(BigDecimal xzyxYstjCount) {
		this.xzyxYstjCount = xzyxYstjCount;
	}

	/**
	 * @mbggenerated -
	 */
	public BigDecimal getXzyxPtwtCount() {
		return xzyxPtwtCount;
	}

	/**
	 * @mbggenerated -
	 */
	public void setXzyxPtwtCount(BigDecimal xzyxPtwtCount) {
		this.xzyxPtwtCount = xzyxPtwtCount;
	}

	/**
	 * @mbggenerated -
	 */
	public BigDecimal getXzyxXswtCount() {
		return xzyxXswtCount;
	}

	/**
	 * @mbggenerated -
	 */
	public void setXzyxXswtCount(BigDecimal xzyxXswtCount) {
		this.xzyxXswtCount = xzyxXswtCount;
	}

	/**
	 * @mbggenerated -
	 */
	public BigDecimal getXzyxDjwtCount() {
		return xzyxDjwtCount;
	}

	/**
	 * @mbggenerated -
	 */
	public void setXzyxDjwtCount(BigDecimal xzyxDjwtCount) {
		this.xzyxDjwtCount = xzyxDjwtCount;
	}

	/**
	 * @mbggenerated -
	 */
	public BigDecimal getXzyxBzwtCount() {
		return xzyxBzwtCount;
	}

	/**
	 * @mbggenerated -
	 */
	public void setXzyxBzwtCount(BigDecimal xzyxBzwtCount) {
		this.xzyxBzwtCount = xzyxBzwtCount;
	}

	/**
	 * @mbggenerated 有效房堪
	 */
	public BigDecimal getXzyxFkCount() {
		return xzyxFkCount;
	}

	/**
	 * @mbggenerated 有效房堪
	 */
	public void setXzyxFkCount(BigDecimal xzyxFkCount) {
		this.xzyxFkCount = xzyxFkCount;
	}

	/**
	 * @mbggenerated -
	 */
	public BigDecimal getXzyxYjCount() {
		return xzyxYjCount;
	}

	/**
	 * @mbggenerated -
	 */
	public void setXzyxYjCount(BigDecimal xzyxYjCount) {
		this.xzyxYjCount = xzyxYjCount;
	}

	/**
	 * @mbggenerated 有效带看
	 */
	public BigDecimal getXzyxDkCount() {
		return xzyxDkCount;
	}

	/**
	 * @mbggenerated 有效带看
	 */
	public void setXzyxDkCount(BigDecimal xzyxDkCount) {
		this.xzyxDkCount = xzyxDkCount;
	}

	/**
	 * @mbggenerated 被考核人
	 */
	public Integer getUserId() {
		return userId;
	}

	/**
	 * @mbggenerated 被考核人
	 */
	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	/**
	 * @mbggenerated 房客类型 1=买卖 2=租赁
	 */
	public Byte getCaseType() {
		return caseType;
	}

	/**
	 * @mbggenerated 房客类型 1=买卖 2=租赁
	 */
	public void setCaseType(Byte caseType) {
		this.caseType = caseType;
	}

	/**
	 * @mbggenerated 工作量类型 1=个人 2=管理
	 */
	public Byte getCheckType() {
		return checkType;
	}

	/**
	 * @mbggenerated 工作量类型 1=个人 2=管理
	 */
	public void setCheckType(Byte checkType) {
		this.checkType = checkType;
	}

	/**
	 * @mbggenerated 角色配置模板ID
	 */
	public Integer getRoleWageConfigId() {
		return roleWageConfigId;
	}

	/**
	 * @mbggenerated 角色配置模板ID
	 */
	public void setRoleWageConfigId(Integer roleWageConfigId) {
		this.roleWageConfigId = roleWageConfigId;
	}

	/**
	 * @mbggenerated 合同总业绩金额
	 */
	public BigDecimal getXzProfitAmount() {
		return xzProfitAmount;
	}

	/**
	 * @mbggenerated 合同总业绩金额
	 */
	public void setXzProfitAmount(BigDecimal xzProfitAmount) {
		this.xzProfitAmount = xzProfitAmount;
	}

	/**
	 * @mbggenerated 合同有效业绩金额
	 */
	public BigDecimal getXzyxProfitAmount() {
		return xzyxProfitAmount;
	}

	/**
	 * @mbggenerated 合同有效业绩金额
	 */
	public void setXzyxProfitAmount(BigDecimal xzyxProfitAmount) {
		this.xzyxProfitAmount = xzyxProfitAmount;
	}

	/**
	 * @mbggenerated 1删除 0 正常
	 */
	public Byte getDealFlag() {
		return dealFlag;
	}

	/**
	 * @mbggenerated 1删除 0 正常
	 */
	public void setDealFlag(Byte dealFlag) {
		this.dealFlag = dealFlag;
	}

	/**
	 * @mbggenerated 档案ID
	 */
	public Integer getArchiveId() {
		return archiveId;
	}

	/**
	 * @mbggenerated 档案ID
	 */
	public void setArchiveId(Integer archiveId) {
		this.archiveId = archiveId;
	}

	/**
	 * @mbggenerated 房登记
	 */
	public BigDecimal getXzFdjCount() {
		return xzFdjCount;
	}

	/**
	 * @mbggenerated 房登记
	 */
	public void setXzFdjCount(BigDecimal xzFdjCount) {
		this.xzFdjCount = xzFdjCount;
	}

	/**
	 * @mbggenerated 有效房登记
	 */
	public BigDecimal getXzyxFdjCount() {
		return xzyxFdjCount;
	}

	/**
	 * @mbggenerated 有效房登记
	 */
	public void setXzyxFdjCount(BigDecimal xzyxFdjCount) {
		this.xzyxFdjCount = xzyxFdjCount;
	}

	/**
	 * @mbggenerated 楼盘资料转入
	 */
	public BigDecimal getXzBuildinfoCount() {
		return xzBuildinfoCount;
	}

	/**
	 * @mbggenerated 楼盘资料转入
	 */
	public void setXzBuildinfoCount(BigDecimal xzBuildinfoCount) {
		this.xzBuildinfoCount = xzBuildinfoCount;
	}

	/**
	 * @mbggenerated 有效楼盘资料转入
	 */
	public BigDecimal getXzyxBuildinfoCount() {
		return xzyxBuildinfoCount;
	}

	/**
	 * @mbggenerated 有效楼盘资料转入
	 */
	public void setXzyxBuildinfoCount(BigDecimal xzyxBuildinfoCount) {
		this.xzyxBuildinfoCount = xzyxBuildinfoCount;
	}

	/**
	 * @mbggenerated 搜搜转入
	 */
	public BigDecimal getXzSosoCount() {
		return xzSosoCount;
	}

	/**
	 * @mbggenerated 搜搜转入
	 */
	public void setXzSosoCount(BigDecimal xzSosoCount) {
		this.xzSosoCount = xzSosoCount;
	}

	/**
	 * @mbggenerated 有效搜搜转入
	 */
	public BigDecimal getXzyxSosoCount() {
		return xzyxSosoCount;
	}

	/**
	 * @mbggenerated 有效搜搜转入
	 */
	public void setXzyxSosoCount(BigDecimal xzyxSosoCount) {
		this.xzyxSosoCount = xzyxSosoCount;
	}

	/**
	 * @mbggenerated -
	 */
	public BigDecimal getXzFpublicZpCount() {
		return xzFpublicZpCount;
	}

	/**
	 * @mbggenerated -
	 */
	public void setXzFpublicZpCount(BigDecimal xzFpublicZpCount) {
		this.xzFpublicZpCount = xzFpublicZpCount;
	}

	/**
	 * @mbggenerated -
	 */
	public BigDecimal getXzyxFpublicZpCount() {
		return xzyxFpublicZpCount;
	}

	/**
	 * @mbggenerated -
	 */
	public void setXzyxFpublicZpCount(BigDecimal xzyxFpublicZpCount) {
		this.xzyxFpublicZpCount = xzyxFpublicZpCount;
	}

	/**
	 * @mbggenerated -
	 */
	public BigDecimal getXzFshareZpCount() {
		return xzFshareZpCount;
	}

	/**
	 * @mbggenerated -
	 */
	public void setXzFshareZpCount(BigDecimal xzFshareZpCount) {
		this.xzFshareZpCount = xzFshareZpCount;
	}

	/**
	 * @mbggenerated -
	 */
	public BigDecimal getXzyxFshareZpCount() {
		return xzyxFshareZpCount;
	}

	/**
	 * @mbggenerated -
	 */
	public void setXzyxFshareZpCount(BigDecimal xzyxFshareZpCount) {
		this.xzyxFshareZpCount = xzyxFshareZpCount;
	}

	/**
	 * @mbggenerated -
	 */
	public BigDecimal getXzFzyxCount() {
		return xzFzyxCount;
	}

	/**
	 * @mbggenerated -
	 */
	public void setXzFzyxCount(BigDecimal xzFzyxCount) {
		this.xzFzyxCount = xzFzyxCount;
	}

	/**
	 * @mbggenerated -
	 */
	public BigDecimal getXzyxFzyxCount() {
		return xzyxFzyxCount;
	}

	/**
	 * @mbggenerated -
	 */
	public void setXzyxFzyxCount(BigDecimal xzyxFzyxCount) {
		this.xzyxFzyxCount = xzyxFzyxCount;
	}

	/**
	 * @mbggenerated -
	 */
	public BigDecimal getXzKdjCount() {
		return xzKdjCount;
	}

	/**
	 * @mbggenerated -
	 */
	public void setXzKdjCount(BigDecimal xzKdjCount) {
		this.xzKdjCount = xzKdjCount;
	}

	/**
	 * @mbggenerated -
	 */
	public BigDecimal getXzyxKdjCount() {
		return xzyxKdjCount;
	}

	/**
	 * @mbggenerated -
	 */
	public void setXzyxKdjCount(BigDecimal xzyxKdjCount) {
		this.xzyxKdjCount = xzyxKdjCount;
	}

	/**
	 * @mbggenerated -
	 */
	public BigDecimal getXzKpublicZpCount() {
		return xzKpublicZpCount;
	}

	/**
	 * @mbggenerated -
	 */
	public void setXzKpublicZpCount(BigDecimal xzKpublicZpCount) {
		this.xzKpublicZpCount = xzKpublicZpCount;
	}

	/**
	 * @mbggenerated -
	 */
	public BigDecimal getXzyxKpublicZpCount() {
		return xzyxKpublicZpCount;
	}

	/**
	 * @mbggenerated -
	 */
	public void setXzyxKpublicZpCount(BigDecimal xzyxKpublicZpCount) {
		this.xzyxKpublicZpCount = xzyxKpublicZpCount;
	}

	/**
	 * @mbggenerated -
	 */
	public BigDecimal getXzKshareZpCount() {
		return xzKshareZpCount;
	}

	/**
	 * @mbggenerated -
	 */
	public void setXzKshareZpCount(BigDecimal xzKshareZpCount) {
		this.xzKshareZpCount = xzKshareZpCount;
	}

	/**
	 * @mbggenerated -
	 */
	public BigDecimal getXzyxKshareZpCount() {
		return xzyxKshareZpCount;
	}

	/**
	 * @mbggenerated -
	 */
	public void setXzyxKshareZpCount(BigDecimal xzyxKshareZpCount) {
		this.xzyxKshareZpCount = xzyxKshareZpCount;
	}

	/**
	 * @mbggenerated -
	 */
	public BigDecimal getXzKzyxCount() {
		return xzKzyxCount;
	}

	/**
	 * @mbggenerated -
	 */
	public void setXzKzyxCount(BigDecimal xzKzyxCount) {
		this.xzKzyxCount = xzKzyxCount;
	}

	/**
	 * @mbggenerated -
	 */
	public BigDecimal getXzyxKzyxCount() {
		return xzyxKzyxCount;
	}

	/**
	 * @mbggenerated -
	 */
	public void setXzyxKzyxCount(BigDecimal xzyxKzyxCount) {
		this.xzyxKzyxCount = xzyxKzyxCount;
	}

	/**
	 * @mbggenerated 取消暂缓
	 */
	public BigDecimal getXzQxzhCount() {
		return xzQxzhCount;
	}

	/**
	 * @mbggenerated 取消暂缓
	 */
	public void setXzQxzhCount(BigDecimal xzQxzhCount) {
		this.xzQxzhCount = xzQxzhCount;
	}

	/**
	 * @mbggenerated -
	 */
	public BigDecimal getXzyxQxzhCount() {
		return xzyxQxzhCount;
	}

	/**
	 * @mbggenerated -
	 */
	public void setXzyxQxzhCount(BigDecimal xzyxQxzhCount) {
		this.xzyxQxzhCount = xzyxQxzhCount;
	}

	/**
	 * @mbggenerated 本月是否生效--新员工注册进来受系统参数控制是否生效 1:生效
	 */
	public Byte getEffectiveStatus() {
		return effectiveStatus;
	}

	/**
	 * @mbggenerated 本月是否生效--新员工注册进来受系统参数控制是否生效 1:生效
	 */
	public void setEffectiveStatus(Byte effectiveStatus) {
		this.effectiveStatus = effectiveStatus;
	}

	/**
	 * @mbggenerated -
	 */
	public Integer getOrganizationId() {
		return organizationId;
	}

	/**
	 * @mbggenerated -
	 */
	public void setOrganizationId(Integer organizationId) {
		this.organizationId = organizationId;
	}

	/**
	 * @mbggenerated -
	 */
	public String getOrganizationPath() {
		return organizationPath;
	}

	/**
	 * @mbggenerated -
	 */
	public void setOrganizationPath(String organizationPath) {
		this.organizationPath = organizationPath;
	}

	/**
	 * @mbggenerated
	 */
	public ErpFunAssessmentStatistics() {
	}

	/**
	 * @mbggenerated
	 */
	public ErpFunAssessmentStatistics(Integer shardCityId, Integer id) {
		super(shardCityId);
		this.id = id;
	}
}