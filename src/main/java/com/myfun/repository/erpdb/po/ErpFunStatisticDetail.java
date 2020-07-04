package com.myfun.repository.erpdb.po;

import java.io.Serializable;
import java.util.Date;

import com.alibaba.fastjson.annotation.JSONField;
import com.myfun.repository.support.constant.Const.CacheStructure;
import com.myfun.repository.support.generator.shard.ShardDb;
import com.myfun.utils.StringUtil;
import com.myfun.utils.rest.DateUtil;

public class ErpFunStatisticDetail extends ShardDb implements Serializable {
	/**
	 * @mbggenerated 主键自增ID
	 */
	private Integer statisticDetailId;
	/**
	 * @mbggenerated 公司ID
	 */
	private Integer compId;
	/**
	 * @mbggenerated 大区ID
	 */
	private Integer areaId;
	/**
	 * @mbggenerated 片区ID
	 */
	private Integer regId;
	/**
	 * @mbggenerated 分店ID
	 */
	private Integer deptId;
	/**
	 * @mbggenerated 分组ID
	 */
	private Integer grId;
	/**
	 * @mbggenerated 用户ID
	 */
	private Integer userId;
	/**
	 * @mbggenerated 城市ID
	 */
	private Integer cityId;
	/**
	 * @mbggenerated 统计类型 1=新增登记 2=转有效 3=搜搜转入 4=转盘 5=分配 6=修改 7=状态变更 8=委托 9=跟进 10=房勘 11=钥匙提交 12=议价 13=图片上传 14=视频上传 15=查看电话 16=拨号 17=网络发布 18=网络刷新 19=带看、带盘 20=成交 21=速销房 22=视频带看 23=看房点评 24=朋友圈 25=VR上传 26=微店分享 27=房源分享
	 */
	private Integer statisticType;
	/**
	 * @mbggenerated 房客源类型,1=出售,2=出租,3=求购,4=求租
	 */
	private Integer caseType;
	/**
	 * @mbggenerated 房客源ID
	 */
	private Integer caseId;
	/**
	 * @mbggenerated --暂时没用
	 */
	private Integer statisticTotleId;
	/**
	 * @mbggenerated 创建时间
	 */
	private Date createTime;
	/**
	 * @mbggenerated 跟进ID
	 */
	private String trackId;
	/**
	 * @mbggenerated 档案id
	 */
	private Integer archiveId;
	/**
	 * @mbggenerated 房源的创建时间
	 */
	private Date caseCreateTime;
	/**
	 * @mbggenerated 房，客源当时的状态
	 */
	private Integer caseStatus;
	/**
	 * @mbggenerated 房客源所属的大区Id
	 */
	private Integer caseAreaId;
	/**
	 * @mbggenerated 房客源所属的片区ID
	 */
	private Integer caseRegId;
	/**
	 * @mbggenerated 房客源所属的门店ID
	 */
	private Integer caseDeptId;
	/**
	 * @mbggenerated 房客源所属的分组ID
	 */
	private Integer caseGrId;
	/**
	 * @mbggenerated 房客源所属人ID
	 */
	private Integer caseUserId;
	/**
	 * @mbggenerated 房客源所属人档案ID
	 */
	private Integer caseArchiveId;
	/**
	 * @mbggenerated
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @mbggenerated
	 */
	public Integer getStatisticDetailId() {
		return statisticDetailId;
	}

	/**
	 * @mbggenerated
	 */
	public void setStatisticDetailId(Integer statisticDetailId) {
		this.statisticDetailId = statisticDetailId;
	}

	/**
	 * @mbggenerated
	 */
	public Integer getCompId() {
		return compId;
	}

	/**
	 * @mbggenerated
	 */
	public void setCompId(Integer compId) {
		this.compId = compId;
	}

	/**
	 * @mbggenerated
	 */
	public Integer getAreaId() {
		return areaId;
	}

	/**
	 * @mbggenerated
	 */
	public void setAreaId(Integer areaId) {
		this.areaId = areaId;
	}

	/**
	 * @mbggenerated
	 */
	public Integer getRegId() {
		return regId;
	}

	/**
	 * @mbggenerated
	 */
	public void setRegId(Integer regId) {
		this.regId = regId;
	}

	/**
	 * @mbggenerated
	 */
	public Integer getDeptId() {
		return deptId;
	}

	/**
	 * @mbggenerated
	 */
	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}

	/**
	 * @mbggenerated
	 */
	public Integer getGrId() {
		return grId;
	}

	/**
	 * @mbggenerated
	 */
	public void setGrId(Integer grId) {
		this.grId = grId;
	}

	/**
	 * @mbggenerated
	 */
	public Integer getUserId() {
		return userId;
	}

	/**
	 * @mbggenerated
	 */
	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	/**
	 * @mbggenerated
	 */
	public Integer getCityId() {
		return cityId;
	}

	/**
	 * @mbggenerated
	 */
	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}

	/**
	 * @mbggenerated
	 */
	public Integer getStatisticType() {
		return statisticType;
	}

	/**
	 * @mbggenerated
	 */
	public void setStatisticType(Integer statisticType) {
		this.statisticType = statisticType;
	}

	/**
	 * @mbggenerated
	 */
	public Integer getCaseType() {
		return caseType;
	}

	/**
	 * @mbggenerated
	 */
	public void setCaseType(Integer caseType) {
		this.caseType = caseType;
	}

	/**
	 * @mbggenerated
	 */
	public Integer getCaseId() {
		return caseId;
	}

	/**
	 * @mbggenerated
	 */
	public void setCaseId(Integer caseId) {
		this.caseId = caseId;
	}

	/**
	 * @mbggenerated
	 */
	public Integer getStatisticTotleId() {
		return statisticTotleId;
	}

	/**
	 * @mbggenerated
	 */
	public void setStatisticTotleId(Integer statisticTotleId) {
		this.statisticTotleId = statisticTotleId;
	}

	/**
	 * @mbggenerated
	 */
	public Date getCreateTime() {
		return createTime;
	}

	/**
	 * @mbggenerated
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	/**
	 * @mbggenerated
	 */
	public String getTrackId() {
		return trackId;
	}

	/**
	 * @mbggenerated
	 */
	public void setTrackId(String trackId) {
		this.trackId = trackId == null ? null : trackId.trim();
	}

	/**
	 * @mbggenerated
	 */
	public Integer getArchiveId() {
		return archiveId;
	}

	/**
	 * @mbggenerated
	 */
	public void setArchiveId(Integer archiveId) {
		this.archiveId = archiveId;
	}

	/**
	 * @mbggenerated
	 */
	public Date getCaseCreateTime() {
		return caseCreateTime;
	}

	/**
	 * @mbggenerated
	 */
	public void setCaseCreateTime(Date caseCreateTime) {
		this.caseCreateTime = caseCreateTime;
	}

	/**
	 * @mbggenerated
	 */
	public Integer getCaseStatus() {
		return caseStatus;
	}

	/**
	 * @mbggenerated
	 */
	public void setCaseStatus(Integer caseStatus) {
		this.caseStatus = caseStatus;
	}

	/**
	 * @mbggenerated
	 */
	public Integer getCaseAreaId() {
		return caseAreaId;
	}

	/**
	 * @mbggenerated
	 */
	public void setCaseAreaId(Integer caseAreaId) {
		this.caseAreaId = caseAreaId;
	}

	/**
	 * @mbggenerated
	 */
	public Integer getCaseRegId() {
		return caseRegId;
	}

	/**
	 * @mbggenerated
	 */
	public void setCaseRegId(Integer caseRegId) {
		this.caseRegId = caseRegId;
	}

	/**
	 * @mbggenerated
	 */
	public Integer getCaseDeptId() {
		return caseDeptId;
	}

	/**
	 * @mbggenerated
	 */
	public void setCaseDeptId(Integer caseDeptId) {
		this.caseDeptId = caseDeptId;
	}

	/**
	 * @mbggenerated
	 */
	public Integer getCaseGrId() {
		return caseGrId;
	}

	/**
	 * @mbggenerated
	 */
	public void setCaseGrId(Integer caseGrId) {
		this.caseGrId = caseGrId;
	}

	/**
	 * @mbggenerated
	 */
	public Integer getCaseUserId() {
		return caseUserId;
	}

	/**
	 * @mbggenerated
	 */
	public void setCaseUserId(Integer caseUserId) {
		this.caseUserId = caseUserId;
	}

	/**
	 * @mbggenerated
	 */
	public Integer getCaseArchiveId() {
		return caseArchiveId;
	}

	/**
	 * @mbggenerated
	 */
	public void setCaseArchiveId(Integer caseArchiveId) {
		this.caseArchiveId = caseArchiveId;
	}

	/**
	 * @mbggenerated
	 */
	public ErpFunStatisticDetail() {
	}

	/**
	 * @mbggenerated
	 */
	public ErpFunStatisticDetail(Integer shardCityId, Integer statisticDetailId) {
		super(shardCityId);
		this.statisticDetailId = statisticDetailId;
	}

	public String getCountFieldName() {
		return countFieldName;
	}

	public void setCountFieldName(String countFieldName) {
		this.countFieldName = countFieldName;
	}

	/**
	 *
	 * 手动加的冗余字段
	 */
	private String countFieldName;

	@JSONField(serialize=false)
	public String getCacheString() {
		StringBuilder sb= new StringBuilder();
		sb.append(CacheStructure.hfterpdb_StatisticDetail_CountCache_Key)
		.append(StringUtil.getBlankStr(cityId, "")).append("_")
		.append(StringUtil.getBlankStr(userId, "")).append("_")
		.append(StringUtil.getBlankStr(statisticType, "")).append("_")
		.append(StringUtil.getBlankStr(caseType, "")).append("_")
		.append(StringUtil.getBlankStr(caseId, "")).append("_")
		.append(DateUtil.dateToStr(createTime, DateUtil.NO_SLASH));
		return sb.toString();
	}
}