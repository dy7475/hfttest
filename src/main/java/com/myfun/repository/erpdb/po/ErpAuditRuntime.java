package com.myfun.repository.erpdb.po;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import com.myfun.repository.support.generator.shard.ShardDb;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class ErpAuditRuntime extends ShardDb implements Serializable {

	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "主键自增ID")
	private Integer id;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "公司ID")
	private Integer compId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "提交人大区ID")
	private Integer areaId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "提交人片区ID")
	private Integer regId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "提交人门店ID")
	private Integer deptId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "提交人分组ID")
	private Integer grId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "提交人用户ID")
	private Integer userId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "提交人档案ID")
	private Integer archiveId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "房客源类型")
	private Integer caseType;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "房客源ID")
	private Integer caseId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "审核类型，DD：TRACK_TYPE、OA_OUT_TYPE 、 5=HOUSE_COMPLAINT_TYPE")
	private Integer auditType;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "超期自动审核时间，分钟")
	private Integer overdueAuditTime;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "创建时间")
	private Date creationTime;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "审核标题，之前没用，后面用来存任务失效等的原因")
	private String auditTitle;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "审核说明（审核摘要）")
	private String auditExplain;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "审核状态，0=审核中 1=审核全部通过 2=未通过 3=已撤回 4=超期自动通过 5=已失效")
	private Byte auditStatus;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "上次审核修改时间")
	private Date lastAuditTime;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "审核来源，0=erp端 1=手机端")
	private Byte auditFrom;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "目标时间（封盘：封盘到期时间，预订：预订到期时间）")
	private Date targetTime;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "目标ID")
	private Integer targetId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "目标：类型（默认=房客源类型 钥匙：1=提交钥匙）")
	private Integer targetType;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "目标编号（带看：房源编号 钥匙：钥匙编号）")
	private String targetNo;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "目标用途")
	private Integer targetUseage;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "提醒时间")
	private Date warmTime;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "提醒内容（内容不为空则表示有提醒任务）")
	private String warmContent;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "当前审核人的信息（申请方门店-门店店长审核中，审核中）")
	private String nowAuditInfo;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "图片地址，多张图片URL用逗号隔开，格式：http://1.jpg,http://2.jpg,http://3.jpg")
	private String photoUrls;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "目标用途")
	private String targetUseages;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "带看用户IDs")
	private String userIds;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "带看用户名")
	private String userNames;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "带看门店名")
	private String deptNames;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "视频IDs")
	private String videoIds;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "VR的IDs")
	private String vrIds;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "目标IDs")
	private String targetIds;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "跟进编号")
	private String trackNo;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "图片IDs")
	private String photoIds;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "房源编号")
	private String caseNo;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "钥匙所在门店ID")
	private Integer keyDeptId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "视频地址")
	private String videoUrls;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "价格单位")
	private Integer priceUnit;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "底价")
	private BigDecimal lowestPrice;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "总金额")
	private BigDecimal totalPrice;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "跟进ID，写审批时关联的跟进ID")
	private Integer trackId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "审核资源，1=跟进类审核 2=请假审核 3=外出审核 4=权证合同类审核 5=房基地投诉审核")
	private Byte auditResource;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "目标开始时间")
	private Date targetStartTime;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "目标结束时间")
	private Date targetEndTime;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "目标天数")
	private BigDecimal targetDay;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "开始时间 1=上午 2=下午")
	private Byte targetStartType;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "结束时间 1=上午 2=下午")
	private Byte targetEndType;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "目标类型，逗号分隔和TARGET_IDS一一对应，也可以单独使用，代表其他意思")
	private String targetTypes;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "视频拍摄地址")
	private String videoLocations;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "视频拍摄时间")
	private String videoShootingTimes;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "审核时房源状态")
	private Byte caseStatus;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "确定按钮 1/0")
	private Byte makeSure;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "带看外部房源时输入的房源信息")
	private String dkHouseInfo;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "带看时关联的带看确认书ID")
	private Integer takeLookId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "收取佣金，单位：元")
	private Integer commissionPrice;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "是否有意向1=是")
	private Byte isIntention;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "跟进标签")
	private String trackTags;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "约看id")
	private Integer makeLookId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "视频缩略图地址，带看审核时带看视频的缩略图")
	private String videoThumbnailUrl;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "请假类型名称")
	private String className;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "请假类型id (只用于请假审批)")
	private Integer classId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "合作房源id")
	private Integer cooperateTargetId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "审批的参数JSON")
	private String paramJson;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "附件urls")
	private String attachmentUrls;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "通用审批业务类型ID")
	private Integer templateId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "通用审批业务类型名称")
	private String templateName;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "该审核是否为共享中心审核 0或者空为否 1=是")
	private Byte isShareAudit;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "组织综合查询字段")
	private String organizationPath;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "组织ID")
	private Integer organizationId;
	/**
	 * @mbggenerated
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @mbggenerated 主键自增ID
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @mbggenerated 主键自增ID
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
	 * @mbggenerated 提交人大区ID
	 */
	public Integer getAreaId() {
		return areaId;
	}

	/**
	 * @mbggenerated 提交人大区ID
	 */
	public void setAreaId(Integer areaId) {
		this.areaId = areaId;
	}

	/**
	 * @mbggenerated 提交人片区ID
	 */
	public Integer getRegId() {
		return regId;
	}

	/**
	 * @mbggenerated 提交人片区ID
	 */
	public void setRegId(Integer regId) {
		this.regId = regId;
	}

	/**
	 * @mbggenerated 提交人门店ID
	 */
	public Integer getDeptId() {
		return deptId;
	}

	/**
	 * @mbggenerated 提交人门店ID
	 */
	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}

	/**
	 * @mbggenerated 提交人分组ID
	 */
	public Integer getGrId() {
		return grId;
	}

	/**
	 * @mbggenerated 提交人分组ID
	 */
	public void setGrId(Integer grId) {
		this.grId = grId;
	}

	/**
	 * @mbggenerated 提交人用户ID
	 */
	public Integer getUserId() {
		return userId;
	}

	/**
	 * @mbggenerated 提交人用户ID
	 */
	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	/**
	 * @mbggenerated 提交人档案ID
	 */
	public Integer getArchiveId() {
		return archiveId;
	}

	/**
	 * @mbggenerated 提交人档案ID
	 */
	public void setArchiveId(Integer archiveId) {
		this.archiveId = archiveId;
	}

	/**
	 * @mbggenerated 房客源类型
	 */
	public Integer getCaseType() {
		return caseType;
	}

	/**
	 * @mbggenerated 房客源类型
	 */
	public void setCaseType(Integer caseType) {
		this.caseType = caseType;
	}

	/**
	 * @mbggenerated 房客源ID
	 */
	public Integer getCaseId() {
		return caseId;
	}

	/**
	 * @mbggenerated 房客源ID
	 */
	public void setCaseId(Integer caseId) {
		this.caseId = caseId;
	}

	/**
	 * @mbggenerated 审核类型，DD：TRACK_TYPE、OA_OUT_TYPE 、 5=HOUSE_COMPLAINT_TYPE
	 */
	public Integer getAuditType() {
		return auditType;
	}

	/**
	 * @mbggenerated 审核类型，DD：TRACK_TYPE、OA_OUT_TYPE 、 5=HOUSE_COMPLAINT_TYPE
	 */
	public void setAuditType(Integer auditType) {
		this.auditType = auditType;
	}

	/**
	 * @mbggenerated 超期自动审核时间，分钟
	 */
	public Integer getOverdueAuditTime() {
		return overdueAuditTime;
	}

	/**
	 * @mbggenerated 超期自动审核时间，分钟
	 */
	public void setOverdueAuditTime(Integer overdueAuditTime) {
		this.overdueAuditTime = overdueAuditTime;
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
	 * @mbggenerated 审核标题，之前没用，后面用来存任务失效等的原因
	 */
	public String getAuditTitle() {
		return auditTitle;
	}

	/**
	 * @mbggenerated 审核标题，之前没用，后面用来存任务失效等的原因
	 */
	public void setAuditTitle(String auditTitle) {
		this.auditTitle = auditTitle;
	}

	/**
	 * @mbggenerated 审核说明（审核摘要）
	 */
	public String getAuditExplain() {
		return auditExplain;
	}

	/**
	 * @mbggenerated 审核说明（审核摘要）
	 */
	public void setAuditExplain(String auditExplain) {
		this.auditExplain = auditExplain;
	}

	/**
	 * @mbggenerated 审核状态，0=审核中 1=审核全部通过 2=未通过 3=已撤回 4=超期自动通过 5=已失效
	 */
	public Byte getAuditStatus() {
		return auditStatus;
	}

	/**
	 * @mbggenerated 审核状态，0=审核中 1=审核全部通过 2=未通过 3=已撤回 4=超期自动通过 5=已失效
	 */
	public void setAuditStatus(Byte auditStatus) {
		this.auditStatus = auditStatus;
	}

	/**
	 * @mbggenerated 上次审核修改时间
	 */
	public Date getLastAuditTime() {
		return lastAuditTime;
	}

	/**
	 * @mbggenerated 上次审核修改时间
	 */
	public void setLastAuditTime(Date lastAuditTime) {
		this.lastAuditTime = lastAuditTime;
	}

	/**
	 * @mbggenerated 审核来源，0=erp端 1=手机端
	 */
	public Byte getAuditFrom() {
		return auditFrom;
	}

	/**
	 * @mbggenerated 审核来源，0=erp端 1=手机端
	 */
	public void setAuditFrom(Byte auditFrom) {
		this.auditFrom = auditFrom;
	}

	/**
	 * @mbggenerated 目标时间（封盘：封盘到期时间，预订：预订到期时间）
	 */
	public Date getTargetTime() {
		return targetTime;
	}

	/**
	 * @mbggenerated 目标时间（封盘：封盘到期时间，预订：预订到期时间）
	 */
	public void setTargetTime(Date targetTime) {
		this.targetTime = targetTime;
	}

	/**
	 * @mbggenerated 目标ID
	 */
	public Integer getTargetId() {
		return targetId;
	}

	/**
	 * @mbggenerated 目标ID
	 */
	public void setTargetId(Integer targetId) {
		this.targetId = targetId;
	}

	/**
	 * @mbggenerated 目标：类型（默认=房客源类型 钥匙：1=提交钥匙）
	 */
	public Integer getTargetType() {
		return targetType;
	}

	/**
	 * @mbggenerated 目标：类型（默认=房客源类型 钥匙：1=提交钥匙）
	 */
	public void setTargetType(Integer targetType) {
		this.targetType = targetType;
	}

	/**
	 * @mbggenerated 目标编号（带看：房源编号 钥匙：钥匙编号）
	 */
	public String getTargetNo() {
		return targetNo;
	}

	/**
	 * @mbggenerated 目标编号（带看：房源编号 钥匙：钥匙编号）
	 */
	public void setTargetNo(String targetNo) {
		this.targetNo = targetNo;
	}

	/**
	 * @mbggenerated 目标用途
	 */
	public Integer getTargetUseage() {
		return targetUseage;
	}

	/**
	 * @mbggenerated 目标用途
	 */
	public void setTargetUseage(Integer targetUseage) {
		this.targetUseage = targetUseage;
	}

	/**
	 * @mbggenerated 提醒时间
	 */
	public Date getWarmTime() {
		return warmTime;
	}

	/**
	 * @mbggenerated 提醒时间
	 */
	public void setWarmTime(Date warmTime) {
		this.warmTime = warmTime;
	}

	/**
	 * @mbggenerated 提醒内容（内容不为空则表示有提醒任务）
	 */
	public String getWarmContent() {
		return warmContent;
	}

	/**
	 * @mbggenerated 提醒内容（内容不为空则表示有提醒任务）
	 */
	public void setWarmContent(String warmContent) {
		this.warmContent = warmContent;
	}

	/**
	 * @mbggenerated 当前审核人的信息（申请方门店-门店店长审核中，审核中）
	 */
	public String getNowAuditInfo() {
		return nowAuditInfo;
	}

	/**
	 * @mbggenerated 当前审核人的信息（申请方门店-门店店长审核中，审核中）
	 */
	public void setNowAuditInfo(String nowAuditInfo) {
		this.nowAuditInfo = nowAuditInfo;
	}

	/**
	 * @mbggenerated 图片地址，多张图片URL用逗号隔开，格式：http://1.jpg,http://2.jpg,http://3.jpg
	 */
	public String getPhotoUrls() {
		return photoUrls;
	}

	/**
	 * @mbggenerated 图片地址，多张图片URL用逗号隔开，格式：http://1.jpg,http://2.jpg,http://3.jpg
	 */
	public void setPhotoUrls(String photoUrls) {
		this.photoUrls = photoUrls;
	}

	/**
	 * @mbggenerated 目标用途
	 */
	public String getTargetUseages() {
		return targetUseages;
	}

	/**
	 * @mbggenerated 目标用途
	 */
	public void setTargetUseages(String targetUseages) {
		this.targetUseages = targetUseages;
	}

	/**
	 * @mbggenerated 带看用户IDs
	 */
	public String getUserIds() {
		return userIds;
	}

	/**
	 * @mbggenerated 带看用户IDs
	 */
	public void setUserIds(String userIds) {
		this.userIds = userIds;
	}

	/**
	 * @mbggenerated 带看用户名
	 */
	public String getUserNames() {
		return userNames;
	}

	/**
	 * @mbggenerated 带看用户名
	 */
	public void setUserNames(String userNames) {
		this.userNames = userNames;
	}

	/**
	 * @mbggenerated 带看门店名
	 */
	public String getDeptNames() {
		return deptNames;
	}

	/**
	 * @mbggenerated 带看门店名
	 */
	public void setDeptNames(String deptNames) {
		this.deptNames = deptNames;
	}

	/**
	 * @mbggenerated 视频IDs
	 */
	public String getVideoIds() {
		return videoIds;
	}

	/**
	 * @mbggenerated 视频IDs
	 */
	public void setVideoIds(String videoIds) {
		this.videoIds = videoIds;
	}

	/**
	 * @mbggenerated VR的IDs
	 */
	public String getVrIds() {
		return vrIds;
	}

	/**
	 * @mbggenerated VR的IDs
	 */
	public void setVrIds(String vrIds) {
		this.vrIds = vrIds;
	}

	/**
	 * @mbggenerated 目标IDs
	 */
	public String getTargetIds() {
		return targetIds;
	}

	/**
	 * @mbggenerated 目标IDs
	 */
	public void setTargetIds(String targetIds) {
		this.targetIds = targetIds;
	}

	/**
	 * @mbggenerated 跟进编号
	 */
	public String getTrackNo() {
		return trackNo;
	}

	/**
	 * @mbggenerated 跟进编号
	 */
	public void setTrackNo(String trackNo) {
		this.trackNo = trackNo;
	}

	/**
	 * @mbggenerated 图片IDs
	 */
	public String getPhotoIds() {
		return photoIds;
	}

	/**
	 * @mbggenerated 图片IDs
	 */
	public void setPhotoIds(String photoIds) {
		this.photoIds = photoIds;
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
	 * @mbggenerated 钥匙所在门店ID
	 */
	public Integer getKeyDeptId() {
		return keyDeptId;
	}

	/**
	 * @mbggenerated 钥匙所在门店ID
	 */
	public void setKeyDeptId(Integer keyDeptId) {
		this.keyDeptId = keyDeptId;
	}

	/**
	 * @mbggenerated 视频地址
	 */
	public String getVideoUrls() {
		return videoUrls;
	}

	/**
	 * @mbggenerated 视频地址
	 */
	public void setVideoUrls(String videoUrls) {
		this.videoUrls = videoUrls;
	}

	/**
	 * @mbggenerated 价格单位
	 */
	public Integer getPriceUnit() {
		return priceUnit;
	}

	/**
	 * @mbggenerated 价格单位
	 */
	public void setPriceUnit(Integer priceUnit) {
		this.priceUnit = priceUnit;
	}

	/**
	 * @mbggenerated 底价
	 */
	public BigDecimal getLowestPrice() {
		return lowestPrice;
	}

	/**
	 * @mbggenerated 底价
	 */
	public void setLowestPrice(BigDecimal lowestPrice) {
		this.lowestPrice = lowestPrice;
	}

	/**
	 * @mbggenerated 总金额
	 */
	public BigDecimal getTotalPrice() {
		return totalPrice;
	}

	/**
	 * @mbggenerated 总金额
	 */
	public void setTotalPrice(BigDecimal totalPrice) {
		this.totalPrice = totalPrice;
	}

	/**
	 * @mbggenerated 跟进ID，写审批时关联的跟进ID
	 */
	public Integer getTrackId() {
		return trackId;
	}

	/**
	 * @mbggenerated 跟进ID，写审批时关联的跟进ID
	 */
	public void setTrackId(Integer trackId) {
		this.trackId = trackId;
	}

	/**
	 * @mbggenerated 审核资源，1=跟进类审核 2=请假审核 3=外出审核 4=权证合同类审核 5=房基地投诉审核
	 */
	public Byte getAuditResource() {
		return auditResource;
	}

	/**
	 * @mbggenerated 审核资源，1=跟进类审核 2=请假审核 3=外出审核 4=权证合同类审核 5=房基地投诉审核
	 */
	public void setAuditResource(Byte auditResource) {
		this.auditResource = auditResource;
	}

	/**
	 * @mbggenerated 目标开始时间
	 */
	public Date getTargetStartTime() {
		return targetStartTime;
	}

	/**
	 * @mbggenerated 目标开始时间
	 */
	public void setTargetStartTime(Date targetStartTime) {
		this.targetStartTime = targetStartTime;
	}

	/**
	 * @mbggenerated 目标结束时间
	 */
	public Date getTargetEndTime() {
		return targetEndTime;
	}

	/**
	 * @mbggenerated 目标结束时间
	 */
	public void setTargetEndTime(Date targetEndTime) {
		this.targetEndTime = targetEndTime;
	}

	/**
	 * @mbggenerated 目标天数
	 */
	public BigDecimal getTargetDay() {
		return targetDay;
	}

	/**
	 * @mbggenerated 目标天数
	 */
	public void setTargetDay(BigDecimal targetDay) {
		this.targetDay = targetDay;
	}

	/**
	 * @mbggenerated 开始时间 1=上午 2=下午
	 */
	public Byte getTargetStartType() {
		return targetStartType;
	}

	/**
	 * @mbggenerated 开始时间 1=上午 2=下午
	 */
	public void setTargetStartType(Byte targetStartType) {
		this.targetStartType = targetStartType;
	}

	/**
	 * @mbggenerated 结束时间 1=上午 2=下午
	 */
	public Byte getTargetEndType() {
		return targetEndType;
	}

	/**
	 * @mbggenerated 结束时间 1=上午 2=下午
	 */
	public void setTargetEndType(Byte targetEndType) {
		this.targetEndType = targetEndType;
	}

	/**
	 * @mbggenerated 目标类型，逗号分隔和TARGET_IDS一一对应，也可以单独使用，代表其他意思
	 */
	public String getTargetTypes() {
		return targetTypes;
	}

	/**
	 * @mbggenerated 目标类型，逗号分隔和TARGET_IDS一一对应，也可以单独使用，代表其他意思
	 */
	public void setTargetTypes(String targetTypes) {
		this.targetTypes = targetTypes;
	}

	/**
	 * @mbggenerated 视频拍摄地址
	 */
	public String getVideoLocations() {
		return videoLocations;
	}

	/**
	 * @mbggenerated 视频拍摄地址
	 */
	public void setVideoLocations(String videoLocations) {
		this.videoLocations = videoLocations;
	}

	/**
	 * @mbggenerated 视频拍摄时间
	 */
	public String getVideoShootingTimes() {
		return videoShootingTimes;
	}

	/**
	 * @mbggenerated 视频拍摄时间
	 */
	public void setVideoShootingTimes(String videoShootingTimes) {
		this.videoShootingTimes = videoShootingTimes;
	}

	/**
	 * @mbggenerated 审核时房源状态
	 */
	public Byte getCaseStatus() {
		return caseStatus;
	}

	/**
	 * @mbggenerated 审核时房源状态
	 */
	public void setCaseStatus(Byte caseStatus) {
		this.caseStatus = caseStatus;
	}

	/**
	 * @mbggenerated 确定按钮 1/0
	 */
	public Byte getMakeSure() {
		return makeSure;
	}

	/**
	 * @mbggenerated 确定按钮 1/0
	 */
	public void setMakeSure(Byte makeSure) {
		this.makeSure = makeSure;
	}

	/**
	 * @mbggenerated 带看外部房源时输入的房源信息
	 */
	public String getDkHouseInfo() {
		return dkHouseInfo;
	}

	/**
	 * @mbggenerated 带看外部房源时输入的房源信息
	 */
	public void setDkHouseInfo(String dkHouseInfo) {
		this.dkHouseInfo = dkHouseInfo;
	}

	/**
	 * @mbggenerated 带看时关联的带看确认书ID
	 */
	public Integer getTakeLookId() {
		return takeLookId;
	}

	/**
	 * @mbggenerated 带看时关联的带看确认书ID
	 */
	public void setTakeLookId(Integer takeLookId) {
		this.takeLookId = takeLookId;
	}

	/**
	 * @mbggenerated 收取佣金，单位：元
	 */
	public Integer getCommissionPrice() {
		return commissionPrice;
	}

	/**
	 * @mbggenerated 收取佣金，单位：元
	 */
	public void setCommissionPrice(Integer commissionPrice) {
		this.commissionPrice = commissionPrice;
	}

	/**
	 * @mbggenerated 是否有意向1=是
	 */
	public Byte getIsIntention() {
		return isIntention;
	}

	/**
	 * @mbggenerated 是否有意向1=是
	 */
	public void setIsIntention(Byte isIntention) {
		this.isIntention = isIntention;
	}

	/**
	 * @mbggenerated 跟进标签
	 */
	public String getTrackTags() {
		return trackTags;
	}

	/**
	 * @mbggenerated 跟进标签
	 */
	public void setTrackTags(String trackTags) {
		this.trackTags = trackTags;
	}

	/**
	 * @mbggenerated 约看id
	 */
	public Integer getMakeLookId() {
		return makeLookId;
	}

	/**
	 * @mbggenerated 约看id
	 */
	public void setMakeLookId(Integer makeLookId) {
		this.makeLookId = makeLookId;
	}

	/**
	 * @mbggenerated 视频缩略图地址，带看审核时带看视频的缩略图
	 */
	public String getVideoThumbnailUrl() {
		return videoThumbnailUrl;
	}

	/**
	 * @mbggenerated 视频缩略图地址，带看审核时带看视频的缩略图
	 */
	public void setVideoThumbnailUrl(String videoThumbnailUrl) {
		this.videoThumbnailUrl = videoThumbnailUrl;
	}

	/**
	 * @mbggenerated 请假类型名称
	 */
	public String getClassName() {
		return className;
	}

	/**
	 * @mbggenerated 请假类型名称
	 */
	public void setClassName(String className) {
		this.className = className;
	}

	/**
	 * @mbggenerated 请假类型id (只用于请假审批)
	 */
	public Integer getClassId() {
		return classId;
	}

	/**
	 * @mbggenerated 请假类型id (只用于请假审批)
	 */
	public void setClassId(Integer classId) {
		this.classId = classId;
	}

	/**
	 * @mbggenerated 合作房源id
	 */
	public Integer getCooperateTargetId() {
		return cooperateTargetId;
	}

	/**
	 * @mbggenerated 合作房源id
	 */
	public void setCooperateTargetId(Integer cooperateTargetId) {
		this.cooperateTargetId = cooperateTargetId;
	}

	/**
	 * @mbggenerated 审批的参数JSON
	 */
	public String getParamJson() {
		return paramJson;
	}

	/**
	 * @mbggenerated 审批的参数JSON
	 */
	public void setParamJson(String paramJson) {
		this.paramJson = paramJson;
	}

	/**
	 * @mbggenerated 附件urls
	 */
	public String getAttachmentUrls() {
		return attachmentUrls;
	}

	/**
	 * @mbggenerated 附件urls
	 */
	public void setAttachmentUrls(String attachmentUrls) {
		this.attachmentUrls = attachmentUrls;
	}

	/**
	 * @mbggenerated 通用审批业务类型ID
	 */
	public Integer getTemplateId() {
		return templateId;
	}

	/**
	 * @mbggenerated 通用审批业务类型ID
	 */
	public void setTemplateId(Integer templateId) {
		this.templateId = templateId;
	}

	/**
	 * @mbggenerated 通用审批业务类型名称
	 */
	public String getTemplateName() {
		return templateName;
	}

	/**
	 * @mbggenerated 通用审批业务类型名称
	 */
	public void setTemplateName(String templateName) {
		this.templateName = templateName;
	}

	/**
	 * @mbggenerated 该审核是否为共享中心审核 0或者空为否 1=是
	 */
	public Byte getIsShareAudit() {
		return isShareAudit;
	}

	/**
	 * @mbggenerated 该审核是否为共享中心审核 0或者空为否 1=是
	 */
	public void setIsShareAudit(Byte isShareAudit) {
		this.isShareAudit = isShareAudit;
	}

	/**
	 * @mbggenerated 组织综合查询字段
	 */
	public String getOrganizationPath() {
		return organizationPath;
	}

	/**
	 * @mbggenerated 组织综合查询字段
	 */
	public void setOrganizationPath(String organizationPath) {
		this.organizationPath = organizationPath;
	}

	/**
	 * @mbggenerated 组织ID
	 */
	public Integer getOrganizationId() {
		return organizationId;
	}

	/**
	 * @mbggenerated 组织ID
	 */
	public void setOrganizationId(Integer organizationId) {
		this.organizationId = organizationId;
	}

	/**
	 * @mbggenerated
	 */
	public ErpAuditRuntime() {
	}

	/**
	 * @mbggenerated
	 */
	public ErpAuditRuntime(Integer shardCityId, Integer id) {
		super(shardCityId);
		this.id = id;
	}
}