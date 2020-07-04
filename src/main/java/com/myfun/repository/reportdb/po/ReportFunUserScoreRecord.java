package com.myfun.repository.reportdb.po;

import java.io.Serializable;
import java.util.Date;
import io.swagger.annotations.ApiModelProperty;

public class ReportFunUserScoreRecord implements Serializable {
    /**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "主键自增")
	private Integer id;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "公司ID")
	private Integer compId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "城市ID")
	private Integer cityId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "大区ID")
	private Integer areaId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "片区ID")
	private Integer regId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "分组ID")
	private Integer grId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "用户ID")
	private Integer userId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "影响积分数")
	private Integer influenceScore;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "分数类型")
	private Integer scoreType;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "创建时间")
	private Date createTime;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "积分分类")
	private Byte scoreClass;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "房客源ID（合同成交时这里存的时dealId）")
	private Integer caseId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "房客源类型(合同成交时这里存的是合同类型)")
	private Byte caseType;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "跟进ID")
	private Integer trackId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "档案ID")
	private Integer archiveId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "门店ID")
	private Integer deptId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "月任务是否跑过， 新增时不用理会这个字段")
	private Integer monthTaskFinish;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "null")
	private Integer org1;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "null")
	private Integer org2;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "null")
	private Integer org3;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "null")
	private Integer org4;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "null")
	private Integer org5;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "null")
	private Integer org6;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "null")
	private Integer org7;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "null")
	private Integer org8;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "null")
	private Integer org9;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "null")
	private Integer org10;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "null")
	private Integer org11;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "null")
	private Integer org12;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "null")
	private Integer org13;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "null")
	private Integer org14;
	/**
	 * @mbggenerated
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @mbggenerated 主键自增
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @mbggenerated 主键自增
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
	 * @mbggenerated 大区ID
	 */
	public Integer getAreaId() {
		return areaId;
	}

	/**
	 * @mbggenerated 大区ID
	 */
	public void setAreaId(Integer areaId) {
		this.areaId = areaId;
	}

	/**
	 * @mbggenerated 片区ID
	 */
	public Integer getRegId() {
		return regId;
	}

	/**
	 * @mbggenerated 片区ID
	 */
	public void setRegId(Integer regId) {
		this.regId = regId;
	}

	/**
	 * @mbggenerated 分组ID
	 */
	public Integer getGrId() {
		return grId;
	}

	/**
	 * @mbggenerated 分组ID
	 */
	public void setGrId(Integer grId) {
		this.grId = grId;
	}

	/**
	 * @mbggenerated 用户ID
	 */
	public Integer getUserId() {
		return userId;
	}

	/**
	 * @mbggenerated 用户ID
	 */
	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	/**
	 * @mbggenerated 影响积分数
	 */
	public Integer getInfluenceScore() {
		return influenceScore;
	}

	/**
	 * @mbggenerated 影响积分数
	 */
	public void setInfluenceScore(Integer influenceScore) {
		this.influenceScore = influenceScore;
	}

	/**
	 * @mbggenerated 分数类型
	 */
	public Integer getScoreType() {
		return scoreType;
	}

	/**
	 * @mbggenerated 分数类型
	 */
	public void setScoreType(Integer scoreType) {
		this.scoreType = scoreType;
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
	 * @mbggenerated 积分分类
	 */
	public Byte getScoreClass() {
		return scoreClass;
	}

	/**
	 * @mbggenerated 积分分类
	 */
	public void setScoreClass(Byte scoreClass) {
		this.scoreClass = scoreClass;
	}

	/**
	 * @mbggenerated 房客源ID（合同成交时这里存的时dealId）
	 */
	public Integer getCaseId() {
		return caseId;
	}

	/**
	 * @mbggenerated 房客源ID（合同成交时这里存的时dealId）
	 */
	public void setCaseId(Integer caseId) {
		this.caseId = caseId;
	}

	/**
	 * @mbggenerated 房客源类型(合同成交时这里存的是合同类型)
	 */
	public Byte getCaseType() {
		return caseType;
	}

	/**
	 * @mbggenerated 房客源类型(合同成交时这里存的是合同类型)
	 */
	public void setCaseType(Byte caseType) {
		this.caseType = caseType;
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
	 * @mbggenerated 月任务是否跑过， 新增时不用理会这个字段
	 */
	public Integer getMonthTaskFinish() {
		return monthTaskFinish;
	}

	/**
	 * @mbggenerated 月任务是否跑过， 新增时不用理会这个字段
	 */
	public void setMonthTaskFinish(Integer monthTaskFinish) {
		this.monthTaskFinish = monthTaskFinish;
	}

	/**
	 * @mbggenerated -
	 */
	public Integer getOrg1() {
		return org1;
	}

	/**
	 * @mbggenerated -
	 */
	public void setOrg1(Integer org1) {
		this.org1 = org1;
	}

	/**
	 * @mbggenerated -
	 */
	public Integer getOrg2() {
		return org2;
	}

	/**
	 * @mbggenerated -
	 */
	public void setOrg2(Integer org2) {
		this.org2 = org2;
	}

	/**
	 * @mbggenerated -
	 */
	public Integer getOrg3() {
		return org3;
	}

	/**
	 * @mbggenerated -
	 */
	public void setOrg3(Integer org3) {
		this.org3 = org3;
	}

	/**
	 * @mbggenerated -
	 */
	public Integer getOrg4() {
		return org4;
	}

	/**
	 * @mbggenerated -
	 */
	public void setOrg4(Integer org4) {
		this.org4 = org4;
	}

	/**
	 * @mbggenerated -
	 */
	public Integer getOrg5() {
		return org5;
	}

	/**
	 * @mbggenerated -
	 */
	public void setOrg5(Integer org5) {
		this.org5 = org5;
	}

	/**
	 * @mbggenerated -
	 */
	public Integer getOrg6() {
		return org6;
	}

	/**
	 * @mbggenerated -
	 */
	public void setOrg6(Integer org6) {
		this.org6 = org6;
	}

	/**
	 * @mbggenerated -
	 */
	public Integer getOrg7() {
		return org7;
	}

	/**
	 * @mbggenerated -
	 */
	public void setOrg7(Integer org7) {
		this.org7 = org7;
	}

	/**
	 * @mbggenerated -
	 */
	public Integer getOrg8() {
		return org8;
	}

	/**
	 * @mbggenerated -
	 */
	public void setOrg8(Integer org8) {
		this.org8 = org8;
	}

	/**
	 * @mbggenerated -
	 */
	public Integer getOrg9() {
		return org9;
	}

	/**
	 * @mbggenerated -
	 */
	public void setOrg9(Integer org9) {
		this.org9 = org9;
	}

	/**
	 * @mbggenerated -
	 */
	public Integer getOrg10() {
		return org10;
	}

	/**
	 * @mbggenerated -
	 */
	public void setOrg10(Integer org10) {
		this.org10 = org10;
	}

	/**
	 * @mbggenerated -
	 */
	public Integer getOrg11() {
		return org11;
	}

	/**
	 * @mbggenerated -
	 */
	public void setOrg11(Integer org11) {
		this.org11 = org11;
	}

	/**
	 * @mbggenerated -
	 */
	public Integer getOrg12() {
		return org12;
	}

	/**
	 * @mbggenerated -
	 */
	public void setOrg12(Integer org12) {
		this.org12 = org12;
	}

	/**
	 * @mbggenerated -
	 */
	public Integer getOrg13() {
		return org13;
	}

	/**
	 * @mbggenerated -
	 */
	public void setOrg13(Integer org13) {
		this.org13 = org13;
	}

	/**
	 * @mbggenerated -
	 */
	public Integer getOrg14() {
		return org14;
	}

	/**
	 * @mbggenerated -
	 */
	public void setOrg14(Integer org14) {
		this.org14 = org14;
	}

	public void countUserScoreMouth(Integer compId, Integer userId, Date startTime) {
    }
}