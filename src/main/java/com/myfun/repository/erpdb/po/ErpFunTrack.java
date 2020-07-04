package com.myfun.repository.erpdb.po;

import com.myfun.repository.support.generator.shard.ShardDb;
import java.io.Serializable;
import java.util.Date;
import io.swagger.annotations.ApiModelProperty;

public class ErpFunTrack extends ShardDb implements Serializable {

	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="跟进ID，当前表为自增序列") private Integer trackId;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="公司ID") private Integer compId;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="分店ID") private Integer deptId;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="信息类型，DD: CASE_TYPE") private Byte caseType;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="房源ID 带看时是客源的ID") private Integer caseId;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="信息状态，DD:HOUSE_STATUS、涉及状态跟进时：即将要变更成为的状态") private Byte caseStatus;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="跟进方式，DD:TRACK_TYPE") private Byte trackType;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="跟进类型") private String trackClassic;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="目标ID") private Integer targetId;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="目标编号") private String targetNo;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="目标信息类型，DD:CASE_TYPE") private Byte targetType;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="目标范围，0-本店1-共享圈2-全系统") private Byte targetBound;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="带看标记2008-11-19更新为所有审核通过标记，null=初始值 1=审核通过 0=审核未通过") private Boolean targetFlag;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="审核时间") private String examinTime;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="跟进编号，委托、带看") private String trackNo;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="跟进内容") private String trackContent;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="跟进提醒`，1=是0=否") private Boolean trackWarm;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="提醒日期") private String warmTime;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="提醒内容") private String warmContent;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="钥匙类型，1=提交钥匙0=收回钥匙") private Boolean trackKey;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="创建者") private Integer creatorUid;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="创建时间") private String creationTime;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="房屋用途") private Byte useage;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="信息编号") private String caseNo;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="目标房源用途") private Byte targetUseage;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="是否在首页展示") private Boolean indexShow;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="钥匙编号，关联的FUN_KEY") private String keyNum;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="目标门店") private Integer targetDept;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="区分跟进子业务(参考：INCLUDE_TRACK数据字典)，例如：1:查看核心跟进2:提交钥匙跟进3:上传图片跟进4:视频上传") private Byte includeTrack;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="看房点评和带看视频使用，1:包含视频（房勘跟进上传视频）") private Byte trackResult;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="是否删除 1=已删除") private Byte isDel;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="删除时间") private String delTime;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="删除人ID") private Integer delUser;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="删除人名字") private String delUserName;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="来源 0 ERP、1 移动端、2新移动服务器") private Byte trackSource;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="封盘保护到期时间") private Date specialEndTime;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="预订保护到期时间") private Date scheduleEndTime;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="临时记录，用于补数据，后面会删除") private Integer dealId;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="委托书地址") private String proxyUrl;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="是否是用户自己手动写的跟进") private Integer isUserTrack;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="跟进房客源所属人ID") private Integer caseUserId;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="带看目标源所属人ID") private Integer targetUserId;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="房客源所属门店id") private Integer caseDeptId;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="是否是删除图片跟进1=是") private Byte isDeltrack;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="房堪传图数量") private Integer fkPhotoCount;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="带看确认书数量") private Integer dkPhotoCount;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="暂缓保护到期时间") private Date respiteEndTime;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="是否有vr标记，默认0没有，1有") private Integer vrPhoto;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="admin库YOUJIA_RESERVE_HOUSE_EVA 的主键") private Integer reserverHouseEvaId;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="委托截止日期") private Date entrustEndTime;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="分组名") private String grName;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="分组ID") private Integer grId;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="门店名") private String deptName;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="带看外部房源时输入的房源信息") private String dkHouseInfo;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="跟进标签(TRACK_TYPE=80笋盘时, TRACK_TAGS和房源标签同步)") private String trackTags;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="约看ID") private Integer makeLookId;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="带看的客户是否有意向1 =是") private Byte isIntention;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="带看次数") private Integer daikanNum;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="分享给客户的带看id，admin CUST_TAKE_LOOK") private Integer takeLookId;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="合作房源id") private Integer cooperateTargetId;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="跟进扩展字段") private String trackExt;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="组织架构线") private String organizationPath;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="组织机构ID") private Integer organizationId;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="新版组织代替 TARGET_DEPT") private Integer targetOrganizationId;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="新版组织代替 CASE_DEPT_ID") private Integer caseOrganizationId;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="新版组织代替 DEPT_NAME,GR_NAME ") private String organizationName;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="null") private String creatorUserName;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="null") private Integer keyVoucherCount;
	/**
	 * @mbggenerated
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @mbggenerated 跟进ID，当前表为自增序列
	 */
	public Integer getTrackId() {
		return trackId;
	}

	/**
	 * @mbggenerated 跟进ID，当前表为自增序列
	 */
	public void setTrackId(Integer trackId) {
		this.trackId = trackId;
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
	 * @mbggenerated 分店ID
	 */
	public Integer getDeptId() {
		return deptId;
	}

	/**
	 * @mbggenerated 分店ID
	 */
	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}

	/**
	 * @mbggenerated 信息类型，DD: CASE_TYPE
	 */
	public Byte getCaseType() {
		return caseType;
	}

	/**
	 * @mbggenerated 信息类型，DD: CASE_TYPE
	 */
	public void setCaseType(Byte caseType) {
		this.caseType = caseType;
	}

	/**
	 * @mbggenerated 房源ID 带看时是客源的ID
	 */
	public Integer getCaseId() {
		return caseId;
	}

	/**
	 * @mbggenerated 房源ID 带看时是客源的ID
	 */
	public void setCaseId(Integer caseId) {
		this.caseId = caseId;
	}

	/**
	 * @mbggenerated 信息状态，DD:HOUSE_STATUS、涉及状态跟进时：即将要变更成为的状态
	 */
	public Byte getCaseStatus() {
		return caseStatus;
	}

	/**
	 * @mbggenerated 信息状态，DD:HOUSE_STATUS、涉及状态跟进时：即将要变更成为的状态
	 */
	public void setCaseStatus(Byte caseStatus) {
		this.caseStatus = caseStatus;
	}

	/**
	 * @mbggenerated 跟进方式，DD:TRACK_TYPE
	 */
	public Byte getTrackType() {
		return trackType;
	}

	/**
	 * @mbggenerated 跟进方式，DD:TRACK_TYPE
	 */
	public void setTrackType(Byte trackType) {
		this.trackType = trackType;
	}

	/**
	 * @mbggenerated 跟进类型
	 */
	public String getTrackClassic() {
		return trackClassic;
	}

	/**
	 * @mbggenerated 跟进类型
	 */
	public void setTrackClassic(String trackClassic) {
		this.trackClassic = trackClassic;
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
	 * @mbggenerated 目标编号
	 */
	public String getTargetNo() {
		return targetNo;
	}

	/**
	 * @mbggenerated 目标编号
	 */
	public void setTargetNo(String targetNo) {
		this.targetNo = targetNo;
	}

	/**
	 * @mbggenerated 目标信息类型，DD:CASE_TYPE
	 */
	public Byte getTargetType() {
		return targetType;
	}

	/**
	 * @mbggenerated 目标信息类型，DD:CASE_TYPE
	 */
	public void setTargetType(Byte targetType) {
		this.targetType = targetType;
	}

	/**
	 * @mbggenerated 目标范围，0-本店1-共享圈2-全系统
	 */
	public Byte getTargetBound() {
		return targetBound;
	}

	/**
	 * @mbggenerated 目标范围，0-本店1-共享圈2-全系统
	 */
	public void setTargetBound(Byte targetBound) {
		this.targetBound = targetBound;
	}

	/**
	 * @mbggenerated 带看标记2008-11-19更新为所有审核通过标记，null=初始值 1=审核通过 0=审核未通过
	 */
	public Boolean getTargetFlag() {
		return targetFlag;
	}

	/**
	 * @mbggenerated 带看标记2008-11-19更新为所有审核通过标记，null=初始值 1=审核通过 0=审核未通过
	 */
	public void setTargetFlag(Boolean targetFlag) {
		this.targetFlag = targetFlag;
	}

	/**
	 * @mbggenerated 审核时间
	 */
	public String getExaminTime() {
		return examinTime;
	}

	/**
	 * @mbggenerated 审核时间
	 */
	public void setExaminTime(String examinTime) {
		this.examinTime = examinTime;
	}

	/**
	 * @mbggenerated 跟进编号，委托、带看
	 */
	public String getTrackNo() {
		return trackNo;
	}

	/**
	 * @mbggenerated 跟进编号，委托、带看
	 */
	public void setTrackNo(String trackNo) {
		this.trackNo = trackNo;
	}

	/**
	 * @mbggenerated 跟进内容
	 */
	public String getTrackContent() {
		return trackContent;
	}

	/**
	 * @mbggenerated 跟进内容
	 */
	public void setTrackContent(String trackContent) {
		this.trackContent = trackContent;
	}

	/**
	 * @mbggenerated 跟进提醒`，1=是0=否
	 */
	public Boolean getTrackWarm() {
		return trackWarm;
	}

	/**
	 * @mbggenerated 跟进提醒`，1=是0=否
	 */
	public void setTrackWarm(Boolean trackWarm) {
		this.trackWarm = trackWarm;
	}

	/**
	 * @mbggenerated 提醒日期
	 */
	public String getWarmTime() {
		return warmTime;
	}

	/**
	 * @mbggenerated 提醒日期
	 */
	public void setWarmTime(String warmTime) {
		this.warmTime = warmTime;
	}

	/**
	 * @mbggenerated 提醒内容
	 */
	public String getWarmContent() {
		return warmContent;
	}

	/**
	 * @mbggenerated 提醒内容
	 */
	public void setWarmContent(String warmContent) {
		this.warmContent = warmContent;
	}

	/**
	 * @mbggenerated 钥匙类型，1=提交钥匙0=收回钥匙
	 */
	public Boolean getTrackKey() {
		return trackKey;
	}

	/**
	 * @mbggenerated 钥匙类型，1=提交钥匙0=收回钥匙
	 */
	public void setTrackKey(Boolean trackKey) {
		this.trackKey = trackKey;
	}

	/**
	 * @mbggenerated 创建者
	 */
	public Integer getCreatorUid() {
		return creatorUid;
	}

	/**
	 * @mbggenerated 创建者
	 */
	public void setCreatorUid(Integer creatorUid) {
		this.creatorUid = creatorUid;
	}

	/**
	 * @mbggenerated 创建时间
	 */
	public String getCreationTime() {
		return creationTime;
	}

	/**
	 * @mbggenerated 创建时间
	 */
	public void setCreationTime(String creationTime) {
		this.creationTime = creationTime;
	}

	/**
	 * @mbggenerated 房屋用途
	 */
	public Byte getUseage() {
		return useage;
	}

	/**
	 * @mbggenerated 房屋用途
	 */
	public void setUseage(Byte useage) {
		this.useage = useage;
	}

	/**
	 * @mbggenerated 信息编号
	 */
	public String getCaseNo() {
		return caseNo;
	}

	/**
	 * @mbggenerated 信息编号
	 */
	public void setCaseNo(String caseNo) {
		this.caseNo = caseNo;
	}

	/**
	 * @mbggenerated 目标房源用途
	 */
	public Byte getTargetUseage() {
		return targetUseage;
	}

	/**
	 * @mbggenerated 目标房源用途
	 */
	public void setTargetUseage(Byte targetUseage) {
		this.targetUseage = targetUseage;
	}

	/**
	 * @mbggenerated 是否在首页展示
	 */
	public Boolean getIndexShow() {
		return indexShow;
	}

	/**
	 * @mbggenerated 是否在首页展示
	 */
	public void setIndexShow(Boolean indexShow) {
		this.indexShow = indexShow;
	}

	/**
	 * @mbggenerated 钥匙编号，关联的FUN_KEY
	 */
	public String getKeyNum() {
		return keyNum;
	}

	/**
	 * @mbggenerated 钥匙编号，关联的FUN_KEY
	 */
	public void setKeyNum(String keyNum) {
		this.keyNum = keyNum;
	}

	/**
	 * @mbggenerated 目标门店
	 */
	public Integer getTargetDept() {
		return targetDept;
	}

	/**
	 * @mbggenerated 目标门店
	 */
	public void setTargetDept(Integer targetDept) {
		this.targetDept = targetDept;
	}

	/**
	 * @mbggenerated 区分跟进子业务(参考：INCLUDE_TRACK数据字典)，例如：1:查看核心跟进2:提交钥匙跟进3:上传图片跟进4:视频上传
	 */
	public Byte getIncludeTrack() {
		return includeTrack;
	}

	/**
	 * @mbggenerated 区分跟进子业务(参考：INCLUDE_TRACK数据字典)，例如：1:查看核心跟进2:提交钥匙跟进3:上传图片跟进4:视频上传
	 */
	public void setIncludeTrack(Byte includeTrack) {
		this.includeTrack = includeTrack;
	}

	/**
	 * @mbggenerated 看房点评和带看视频使用，1:包含视频（房勘跟进上传视频）
	 */
	public Byte getTrackResult() {
		return trackResult;
	}

	/**
	 * @mbggenerated 看房点评和带看视频使用，1:包含视频（房勘跟进上传视频）
	 */
	public void setTrackResult(Byte trackResult) {
		this.trackResult = trackResult;
	}

	/**
	 * @mbggenerated 是否删除 1=已删除
	 */
	public Byte getIsDel() {
		return isDel;
	}

	/**
	 * @mbggenerated 是否删除 1=已删除
	 */
	public void setIsDel(Byte isDel) {
		this.isDel = isDel;
	}

	/**
	 * @mbggenerated 删除时间
	 */
	public String getDelTime() {
		return delTime;
	}

	/**
	 * @mbggenerated 删除时间
	 */
	public void setDelTime(String delTime) {
		this.delTime = delTime;
	}

	/**
	 * @mbggenerated 删除人ID
	 */
	public Integer getDelUser() {
		return delUser;
	}

	/**
	 * @mbggenerated 删除人ID
	 */
	public void setDelUser(Integer delUser) {
		this.delUser = delUser;
	}

	/**
	 * @mbggenerated 删除人名字
	 */
	public String getDelUserName() {
		return delUserName;
	}

	/**
	 * @mbggenerated 删除人名字
	 */
	public void setDelUserName(String delUserName) {
		this.delUserName = delUserName;
	}

	/**
	 * @mbggenerated 来源 0 ERP、1 移动端、2新移动服务器
	 */
	public Byte getTrackSource() {
		return trackSource;
	}

	/**
	 * @mbggenerated 来源 0 ERP、1 移动端、2新移动服务器
	 */
	public void setTrackSource(Byte trackSource) {
		this.trackSource = trackSource;
	}

	/**
	 * @mbggenerated 封盘保护到期时间
	 */
	public Date getSpecialEndTime() {
		return specialEndTime;
	}

	/**
	 * @mbggenerated 封盘保护到期时间
	 */
	public void setSpecialEndTime(Date specialEndTime) {
		this.specialEndTime = specialEndTime;
	}

	/**
	 * @mbggenerated 预订保护到期时间
	 */
	public Date getScheduleEndTime() {
		return scheduleEndTime;
	}

	/**
	 * @mbggenerated 预订保护到期时间
	 */
	public void setScheduleEndTime(Date scheduleEndTime) {
		this.scheduleEndTime = scheduleEndTime;
	}

	/**
	 * @mbggenerated 临时记录，用于补数据，后面会删除
	 */
	public Integer getDealId() {
		return dealId;
	}

	/**
	 * @mbggenerated 临时记录，用于补数据，后面会删除
	 */
	public void setDealId(Integer dealId) {
		this.dealId = dealId;
	}

	/**
	 * @mbggenerated 委托书地址
	 */
	public String getProxyUrl() {
		return proxyUrl;
	}

	/**
	 * @mbggenerated 委托书地址
	 */
	public void setProxyUrl(String proxyUrl) {
		this.proxyUrl = proxyUrl;
	}

	/**
	 * @mbggenerated 是否是用户自己手动写的跟进
	 */
	public Integer getIsUserTrack() {
		return isUserTrack;
	}

	/**
	 * @mbggenerated 是否是用户自己手动写的跟进
	 */
	public void setIsUserTrack(Integer isUserTrack) {
		this.isUserTrack = isUserTrack;
	}

	/**
	 * @mbggenerated 跟进房客源所属人ID
	 */
	public Integer getCaseUserId() {
		return caseUserId;
	}

	/**
	 * @mbggenerated 跟进房客源所属人ID
	 */
	public void setCaseUserId(Integer caseUserId) {
		this.caseUserId = caseUserId;
	}

	/**
	 * @mbggenerated 带看目标源所属人ID
	 */
	public Integer getTargetUserId() {
		return targetUserId;
	}

	/**
	 * @mbggenerated 带看目标源所属人ID
	 */
	public void setTargetUserId(Integer targetUserId) {
		this.targetUserId = targetUserId;
	}

	/**
	 * @mbggenerated 房客源所属门店id
	 */
	public Integer getCaseDeptId() {
		return caseDeptId;
	}

	/**
	 * @mbggenerated 房客源所属门店id
	 */
	public void setCaseDeptId(Integer caseDeptId) {
		this.caseDeptId = caseDeptId;
	}

	/**
	 * @mbggenerated 是否是删除图片跟进1=是
	 */
	public Byte getIsDeltrack() {
		return isDeltrack;
	}

	/**
	 * @mbggenerated 是否是删除图片跟进1=是
	 */
	public void setIsDeltrack(Byte isDeltrack) {
		this.isDeltrack = isDeltrack;
	}

	/**
	 * @mbggenerated 房堪传图数量
	 */
	public Integer getFkPhotoCount() {
		return fkPhotoCount;
	}

	/**
	 * @mbggenerated 房堪传图数量
	 */
	public void setFkPhotoCount(Integer fkPhotoCount) {
		this.fkPhotoCount = fkPhotoCount;
	}

	/**
	 * @mbggenerated 带看确认书数量
	 */
	public Integer getDkPhotoCount() {
		return dkPhotoCount;
	}

	/**
	 * @mbggenerated 带看确认书数量
	 */
	public void setDkPhotoCount(Integer dkPhotoCount) {
		this.dkPhotoCount = dkPhotoCount;
	}

	/**
	 * @mbggenerated 暂缓保护到期时间
	 */
	public Date getRespiteEndTime() {
		return respiteEndTime;
	}

	/**
	 * @mbggenerated 暂缓保护到期时间
	 */
	public void setRespiteEndTime(Date respiteEndTime) {
		this.respiteEndTime = respiteEndTime;
	}

	/**
	 * @mbggenerated 是否有vr标记，默认0没有，1有
	 */
	public Integer getVrPhoto() {
		return vrPhoto;
	}

	/**
	 * @mbggenerated 是否有vr标记，默认0没有，1有
	 */
	public void setVrPhoto(Integer vrPhoto) {
		this.vrPhoto = vrPhoto;
	}

	/**
	 * @mbggenerated admin库YOUJIA_RESERVE_HOUSE_EVA 的主键
	 */
	public Integer getReserverHouseEvaId() {
		return reserverHouseEvaId;
	}

	/**
	 * @mbggenerated admin库YOUJIA_RESERVE_HOUSE_EVA 的主键
	 */
	public void setReserverHouseEvaId(Integer reserverHouseEvaId) {
		this.reserverHouseEvaId = reserverHouseEvaId;
	}

	/**
	 * @mbggenerated 委托截止日期
	 */
	public Date getEntrustEndTime() {
		return entrustEndTime;
	}

	/**
	 * @mbggenerated 委托截止日期
	 */
	public void setEntrustEndTime(Date entrustEndTime) {
		this.entrustEndTime = entrustEndTime;
	}

	/**
	 * @mbggenerated 分组名
	 */
	public String getGrName() {
		return grName;
	}

	/**
	 * @mbggenerated 分组名
	 */
	public void setGrName(String grName) {
		this.grName = grName;
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
	 * @mbggenerated 门店名
	 */
	public String getDeptName() {
		return deptName;
	}

	/**
	 * @mbggenerated 门店名
	 */
	public void setDeptName(String deptName) {
		this.deptName = deptName;
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
	 * @mbggenerated 跟进标签(TRACK_TYPE=80笋盘时, TRACK_TAGS和房源标签同步)
	 */
	public String getTrackTags() {
		return trackTags;
	}

	/**
	 * @mbggenerated 跟进标签(TRACK_TYPE=80笋盘时, TRACK_TAGS和房源标签同步)
	 */
	public void setTrackTags(String trackTags) {
		this.trackTags = trackTags;
	}

	/**
	 * @mbggenerated 约看ID
	 */
	public Integer getMakeLookId() {
		return makeLookId;
	}

	/**
	 * @mbggenerated 约看ID
	 */
	public void setMakeLookId(Integer makeLookId) {
		this.makeLookId = makeLookId;
	}

	/**
	 * @mbggenerated 带看的客户是否有意向1 =是
	 */
	public Byte getIsIntention() {
		return isIntention;
	}

	/**
	 * @mbggenerated 带看的客户是否有意向1 =是
	 */
	public void setIsIntention(Byte isIntention) {
		this.isIntention = isIntention;
	}

	/**
	 * @mbggenerated 带看次数
	 */
	public Integer getDaikanNum() {
		return daikanNum;
	}

	/**
	 * @mbggenerated 带看次数
	 */
	public void setDaikanNum(Integer daikanNum) {
		this.daikanNum = daikanNum;
	}

	/**
	 * @mbggenerated 分享给客户的带看id，admin CUST_TAKE_LOOK
	 */
	public Integer getTakeLookId() {
		return takeLookId;
	}

	/**
	 * @mbggenerated 分享给客户的带看id，admin CUST_TAKE_LOOK
	 */
	public void setTakeLookId(Integer takeLookId) {
		this.takeLookId = takeLookId;
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
	 * @mbggenerated 跟进扩展字段
	 */
	public String getTrackExt() {
		return trackExt;
	}

	/**
	 * @mbggenerated 跟进扩展字段
	 */
	public void setTrackExt(String trackExt) {
		this.trackExt = trackExt;
	}

	/**
	 * @mbggenerated 组织架构线
	 */
	public String getOrganizationPath() {
		return organizationPath;
	}

	/**
	 * @mbggenerated 组织架构线
	 */
	public void setOrganizationPath(String organizationPath) {
		this.organizationPath = organizationPath;
	}

	/**
	 * @mbggenerated 组织机构ID
	 */
	public Integer getOrganizationId() {
		return organizationId;
	}

	/**
	 * @mbggenerated 组织机构ID
	 */
	public void setOrganizationId(Integer organizationId) {
		this.organizationId = organizationId;
	}

	/**
	 * @mbggenerated 新版组织代替 TARGET_DEPT
	 */
	public Integer getTargetOrganizationId() {
		return targetOrganizationId;
	}

	/**
	 * @mbggenerated 新版组织代替 TARGET_DEPT
	 */
	public void setTargetOrganizationId(Integer targetOrganizationId) {
		this.targetOrganizationId = targetOrganizationId;
	}

	/**
	 * @mbggenerated 新版组织代替 CASE_DEPT_ID
	 */
	public Integer getCaseOrganizationId() {
		return caseOrganizationId;
	}

	/**
	 * @mbggenerated 新版组织代替 CASE_DEPT_ID
	 */
	public void setCaseOrganizationId(Integer caseOrganizationId) {
		this.caseOrganizationId = caseOrganizationId;
	}

	/**
	 * @mbggenerated 新版组织代替 DEPT_NAME,GR_NAME 
	 */
	public String getOrganizationName() {
		return organizationName;
	}

	/**
	 * @mbggenerated 新版组织代替 DEPT_NAME,GR_NAME 
	 */
	public void setOrganizationName(String organizationName) {
		this.organizationName = organizationName;
	}

	/**
	 * @mbggenerated -
	 */
	public String getCreatorUserName() {
		return creatorUserName;
	}

	/**
	 * @mbggenerated -
	 */
	public void setCreatorUserName(String creatorUserName) {
		this.creatorUserName = creatorUserName;
	}

	/**
	 * @mbggenerated -
	 */
	public Integer getKeyVoucherCount() {
		return keyVoucherCount;
	}

	/**
	 * @mbggenerated -
	 */
	public void setKeyVoucherCount(Integer keyVoucherCount) {
		this.keyVoucherCount = keyVoucherCount;
	}

	/**
	 * @mbggenerated
	 */
	public ErpFunTrack() {
	}

	/**
	 * @mbggenerated
	 */
	public ErpFunTrack(Integer shardCityId, Integer trackId) {
		super(shardCityId);
		this.trackId = trackId;
	}
}