package com.myfun.repository.erpdb.param;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.myfun.framework.annotation.DefaultValue;
import com.myfun.repository.admindb.po.AdminYoujiaReserveHouseEva;
import com.myfun.repository.erpdb.dto.CaseInfoDto;
import com.myfun.repository.erpdb.po.ErpAuditRuntime;
import com.myfun.repository.erpdb.po.ErpFunDepts;
import com.myfun.repository.erpdb.po.ErpFunUsers;
import com.myfun.repository.param.EncryParamIfc;
import com.myfun.repository.support.constant.Const.StatisticDetailType;

import io.swagger.annotations.ApiModelProperty;

/**
 * 创建跟进参数
 * @author 张宏利
 * @since 2017年10月11日
 */
public class ErpCreateTrackInfoParam implements EncryParamIfc{
	//跟进扩展字段表
	private String    coreSellPoint      ; // (出售)核心卖点   出租（房屋优势）
	private String    fitmentDescribe     ; // (出售)装修描述 出租(房屋配套)
	private String    layoutIntroduce    ; // (出售)户型介绍  (出租)户型介绍
	private String    propertyRights     ; // (出售)产权情况
	private Byte      trackType          ;// 跟进类型
	private Integer   caseId             ;// 房源ID
	private Integer   caseType           ;// 房源类型
	private String    trackContent       ;// 跟进内容
	private String    photoIds           ;// 带看图片地址
	private String    trackNo            ;// 委托、带看编号
	private Integer   targetId           ;// 目标ID
	private String    targetNo           ;// 目标编号
	private Integer   targetUseage       ;// 单个用途
	private Integer   targetType         ;// 目标信息类型，DD:CASE_TYPE
	private String    trackNos           ;// 委托、带看编号多个值
	private String    targetIds          ;// 目标ID多个值
	private Integer   key                ;// 是否有收到钥匙，1=收到钥匙
	private Date      warmTime           ;// 提醒日期
	private String    warmContent        ;// 提醒内容
	private String    photoUrls          ;// 图片地址
	private String    videoUrls          ;//视频地址
	private String    videoIds           ;// 视频地址
	private String    vrIds              ;// VR视频地址
	private String    videoLocations     ;//视频位置
	private String    videoShootingTimes ;//视频拍摄时间
	private String    userIds            ;// 带看的人id，多个
	private String    userNames          ;// 带看的人名字，多个
	private String    deptNames          ;// 带看的人门店，多个
	private Date      targetTime         ;// 各种时间，考虑去掉上面的几个时间变量
	private boolean   isPrivateModel     ;// 是否是私盘模式
	private Integer   priceUnit          ;// 租金单位
	private BigDecimal lowestPrice       ;// 底价
	private BigDecimal   totalPrice      ;// 总价
	private Integer   sureToAviliable    ;// 1=确定转有效（其他需要确定的也可以使用此参数）
	private Integer   regionId           ;// 行政区id
	private Integer   sectionId          ;// 判断板块id
	private Integer   isMobileApi        ;// 是否来自手机端 1=手机端
	// 查询得到
	private CaseInfoDto targetCaseInfoDto;// 根据类型和ID查询得到的房源，带看的时候才会有值，带看的房源信息
	private CaseInfoDto caseInfoDto      ;// 根据类型和ID查询得到的房源或客源
	private Integer   caseAreaId         ;// 房源所属人大区ID
	private Integer   caseRegId          ;// 房源所属人片区ID
	private Integer   caseDeptId         ;// 房源所属人门店ID
	private Integer   caseGrId           ;// 房源所属人分组ID
	private Integer   caseUserId         ;// 房源所属人ID
	private String    caseNo             ;// 房源编号
	private Integer   casePlateType      ;// 房源盘别
	private Byte      caseLevel          ;// 房源级别
	private String    caseUseage         ;// 房屋用途
	private boolean   casePublish        ;// 是否发布
	private String    caseBuildName      ;// 楼盘名
	private boolean   caseCooperate      ;// 是否合作
	private Integer   saleLeaseId        ;// 租售房源ID
	private Byte      isSaleLease        ;// 是否是租售房源
	private Integer   oldStatus          ;// 之前数据的状态
	private Integer   trackId            ;// 跟进ID
	private ErpFunUsers createAuditUser  ;// 提交审核人用户信息
	private ErpFunDepts createAuditDept  ;// 提交审核人用户门店信息
	private boolean   hasFankan          ;// 是否房勘
	private Byte      status             ;// 选择数据跟进的状态（依据跟进类型自己设置）
	private Integer   keyDeptId          ;// 提交钥匙锁在门店id
	private Byte    syncSaleLeaseStatus;// 是否同步租售房源状态
	private String    warmedUsers        ;// 指定的提醒人，逗号隔开
	private Byte      isImmediate        ;// 是否立即发送提醒 1=是
	private String    newBuildName       ;// 新的楼盘名，楼盘变更时使用
	private String    taskSubject        ;// 生成的审批标题
	// 会话获取
	private Integer   cityId             ;// 城市ID
	private Integer   compId;// 公司ID
	private Integer   crmCompId; // 判断是否是大客户
	private Integer   selfAreaId;// 当前用户大区ID
	private Integer   selfRegId;// 当前用户片区ID
	private Integer   selfDeptId;// 当前用户门店ID
	private Integer   selfGrId;// 当前用户分组ID
	private Integer   selfUserId;// 当前用户ID
	private Integer   selfArchiveId;// 当前用户档案ID
	private Integer   compType;// 公司类型
	private String    userPosition;//角色定位
	private boolean   isPerLogin;// 是否是精英版登录
	private boolean   isPersonalVersion;// 是否是纯精英版
	private String    selfUserName;// 当前登录用户名
	private String    selfDeptName;// 当前用户门店名称
	private String    areaFlag;
	private boolean   isPublicModel;// 是否是私盘
	private boolean   isGeneralManager;// 是否总经理
	private String    pcname;// 是否是私盘
	private Integer   trackFromType;// 跟进来源类型，1=营销版或纯精英版 2=门店版自动审核 3=审核完成
	private String    selfCurrUserName;// 当前用户的信息门店名+用户名
	private String    createCurrUserName;// 创建跟进或审核的用户信息门店名+用户名
	private StatisticDetailType statisticDetailType;// 工作量类型
	// 审核之后需要设置的
	private ErpAuditRuntime auditRuntime;// 审核详情
	private Byte makeSure = (byte) 0;
	@ApiModelProperty(hidden = true)
	@DefaultValue(value = "false")
	private Boolean newOrganization;
	
	
	public Boolean getNewOrganization() {
		return newOrganization;
	}

	public void setNewOrganization(Boolean newOrganization) {
		this.newOrganization = newOrganization;
	}

	public Byte getMakeSure() {
		return makeSure;
	}

	public void setMakeSure(Byte makeSure) {
		this.makeSure = makeSure;
	}

	public Integer getCrmCompId() {
		return crmCompId;
	}

	public void setCrmCompId(Integer crmCompId) {
		this.crmCompId = crmCompId;
	}

	private List<AdminYoujiaReserveHouseEva> evaHouseList;

	private Integer targetIdLength;

	public Integer getTargetIdLength() {
		return targetIdLength;
	}

	public void setTargetIdLength(Integer targetIdLength) {
		this.targetIdLength = targetIdLength;
	}

	public List<AdminYoujiaReserveHouseEva> getEvaHouseList() {
		return evaHouseList;
	}

	
	public String getWarmedUsers() {
		return warmedUsers;
	}


	public void setWarmedUsers(String warmedUsers) {
		this.warmedUsers = warmedUsers;
	}


	public Byte getIsImmediate() {
		return isImmediate;
	}


	public void setIsImmediate(Byte isImmediate) {
		this.isImmediate = isImmediate;
	}


	public void setEvaHouseList(List<AdminYoujiaReserveHouseEva> evaHouseList) {
		this.evaHouseList = evaHouseList;
	}

	public Byte getSyncSaleLeaseStatus() {
		return syncSaleLeaseStatus;
	}

	public void setSyncSaleLeaseStatus(Byte syncSaleLeaseStatus) {
		this.syncSaleLeaseStatus = syncSaleLeaseStatus;
	}

	public Integer getKeyDeptId() {
		return keyDeptId;
	}
	public void setKeyDeptId(Integer keyDeptId) {
		this.keyDeptId = keyDeptId;
	}
	public boolean getHasFankan() {
		return hasFankan;
	}
	public void setHasFankan(boolean hasFankan) {
		this.hasFankan = hasFankan;
	}
	public Integer getTrackId() {
		return trackId;
	}
	public void setTrackId(Integer trackId) {
		this.trackId = trackId;
	}
	public Integer getTargetUseage() {
		return targetUseage;
	}
	public void setTargetUseage(Integer targetUseage) {
		this.targetUseage = targetUseage;
	}
	public boolean isPrivateModel() {
		return isPrivateModel;
	}
	public void setPrivateModel(boolean isPrivateModel) {
		this.isPrivateModel = isPrivateModel;
	}
	public boolean isPublicModel() {
		return isPublicModel;
	}
	public void setPublicModel(boolean isPublicModel) {
		this.isPublicModel = isPublicModel;
	}
	public String getAreaFlag() {
		return areaFlag;
	}
	public void setAreaFlag(String areaFlag) {
		this.areaFlag = areaFlag;
	}
	public String getUserIds() {
		return userIds;
	}
	public void setUserIds(String userIds) {
		this.userIds = userIds;
	}
	public String getUserNames() {
		return userNames;
	}
	public void setUserNames(String userNames) {
		this.userNames = userNames;
	}
	public String getDeptNames() {
		return deptNames;
	}
	public void setDeptNames(String deptNames) {
		this.deptNames = deptNames;
	}
	public String getTrackNos() {
		return trackNos;
	}
	public void setTrackNos(String trackNos) {
		this.trackNos = trackNos;
	}
	public String getTargetIds() {
		return targetIds;
	}
	public void setTargetIds(String targetIds) {
		this.targetIds = targetIds;
	}
	public String getSelfUserName() {
		return selfUserName;
	}
	public void setSelfUserName(String selfUserName) {
		this.selfUserName = selfUserName;
	}
	public String getSelfDeptName() {
		return selfDeptName;
	}
	public void setSelfDeptName(String selfDeptName) {
		this.selfDeptName = selfDeptName;
	}
	public Byte getTrackType() {
		return trackType;
	}
	public void setTrackType(Byte trackType) {
		this.trackType = trackType;
	}
	public Integer getCaseId() {
		return caseId;
	}
	public void setCaseId(Integer caseId) {
		this.caseId = caseId;
	}
	public String getCaseNo() {
		return caseNo;
	}
	public void setCaseNo(String caseNo) {
		this.caseNo = caseNo;
	}
	public Integer getCaseType() {
		return caseType;
	}
	public void setCaseType(Integer caseType) {
		this.caseType = caseType;
	}
	public Byte getStatus() {
		return status;
	}
	public void setStatus(Byte status) {
		this.status = status;
	}
	public Integer getOldStatus() {
		return oldStatus;
	}
	public void setOldStatus(Integer oldStatus) {
		this.oldStatus = oldStatus;
	}
	public String getTrackContent() {
		return trackContent;
	}
	public void setTrackContent(String trackContent) {
		this.trackContent = trackContent;
	}
	public String getTrackNo() {
		return trackNo;
	}
	public void setTrackNo(String trackNo) {
		this.trackNo = trackNo;
	}
	public Integer getTargetId() {
		return targetId;
	}
	public void setTargetId(Integer targetId) {
		this.targetId = targetId;
	}
	public String getTargetNo() {
		return targetNo;
	}
	public void setTargetNo(String targetNo) {
		this.targetNo = targetNo;
	}
	public Integer getTargetType() {
		return targetType;
	}
	public void setTargetType(Integer targetType) {
		this.targetType = targetType;
	}
	public Date getWarmTime() {
		return warmTime;
	}
	public void setWarmTime(Date warmTime) {
		this.warmTime = warmTime;
	}
	public String getWarmContent() {
		return warmContent;
	}
	public void setWarmContent(String warmContent) {
		this.warmContent = warmContent;
	}
	
	public String getPhotoUrls() {
		return photoUrls;
	}
	public void setPhotoUrls(String photoUrls) {
		this.photoUrls = photoUrls;
	}
	public Integer getPriceUnit() {
		return priceUnit;
	}
	public void setPriceUnit(Integer priceUnit) {
		this.priceUnit = priceUnit;
	}
	public BigDecimal getLowestPrice() {
		return lowestPrice;
	}
	public void setLowestPrice(BigDecimal lowestPrice) {
		this.lowestPrice = lowestPrice;
	}
	public BigDecimal getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(BigDecimal totalPrice) {
		this.totalPrice = totalPrice;
	}
	public Integer getCaseUserId() {
		return caseUserId;
	}
	public void setCaseUserId(Integer caseUserId) {
		this.caseUserId = caseUserId;
	}
	public Integer getCaseDeptId() {
		return caseDeptId;
	}
	public void setCaseDeptId(Integer caseDeptId) {
		this.caseDeptId = caseDeptId;
	}
	public Integer getCityId() {
		return cityId;
	}
	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}
	public Integer getCompId() {
		return compId;
	}
	public void setCompId(Integer compId) {
		this.compId = compId;
	}
	public Integer getSelfAreaId() {
		return selfAreaId;
	}
	public void setSelfAreaId(Integer selfAreaId) {
		this.selfAreaId = selfAreaId;
	}
	public Integer getSelfRegId() {
		return selfRegId;
	}
	public void setSelfRegId(Integer selfRegId) {
		this.selfRegId = selfRegId;
	}
	public Integer getSelfDeptId() {
		return selfDeptId;
	}
	public void setSelfDeptId(Integer selfDeptId) {
		this.selfDeptId = selfDeptId;
	}
	public Integer getSelfGrId() {
		return selfGrId;
	}
	public void setSelfGrId(Integer selfGrId) {
		this.selfGrId = selfGrId;
	}
	public Integer getSelfUserId() {
		return selfUserId;
	}
	public void setSelfUserId(Integer selfUserId) {
		this.selfUserId = selfUserId;
	}
	public Integer getCompType() {
		return compType;
	}
	public void setCompType(Integer compType) {
		this.compType = compType;
	}
//	不能使用这个字段，判断版本，精英版登录有特殊处理的再想办法
//	原因：电脑版登录->手机端登录->isPerLogin=1，之后在电脑端写跟进判断就有问题了
//	导致这个值太不可控了，不要用
//	public boolean getIsPerLogin() {
//		return isPerLogin;
//	}
//	public void setIsPerLogin(boolean isPerLogin) {
//		this.isPerLogin = isPerLogin;
//	}
	public boolean getIsPersonalVersion() {
		return isPersonalVersion;
	}
	public void setIsPersonalVersion(boolean isPersonalVersion) {
		this.isPersonalVersion = isPersonalVersion;
	}
	public CaseInfoDto getCaseInfoDto() {
		return caseInfoDto;
	}
	public void setCaseInfoDto(CaseInfoDto caseInfoDto) {
		this.caseInfoDto = caseInfoDto;
	}
	public Integer getTrackFromType() {
		return trackFromType;
	}
	public void setTrackFromType(Integer trackFromType) {
		this.trackFromType = trackFromType;
	}
	public ErpFunUsers getCreateAuditUser() {
		return createAuditUser;
	}
	public void setCreateAuditUser(ErpFunUsers createAuditUser) {
		this.createAuditUser = createAuditUser;
	}
	public ErpFunDepts getCreateAuditDept() {
		return createAuditDept;
	}
	public void setCreateAuditDept(ErpFunDepts createAuditDept) {
		this.createAuditDept = createAuditDept;
	}
	public ErpAuditRuntime getAuditRuntime() {
		return auditRuntime;
	}
	public void setAuditRuntime(ErpAuditRuntime auditRuntime) {
		this.auditRuntime = auditRuntime;
	}
	public Date getTargetTime() {
		return targetTime;
	}
	public void setTargetTime(Date targetTime) {
		this.targetTime = targetTime;
	}
	public Integer getCaseAreaId() {
		return caseAreaId;
	}
	public void setCaseAreaId(Integer caseAreaId) {
		this.caseAreaId = caseAreaId;
	}
	public Integer getCaseRegId() {
		return caseRegId;
	}
	public void setCaseRegId(Integer caseRegId) {
		this.caseRegId = caseRegId;
	}
	public Integer getCaseGrId() {
		return caseGrId;
	}
	public void setCaseGrId(Integer caseGrId) {
		this.caseGrId = caseGrId;
	}
	public Integer getSelfArchiveId() {
		return selfArchiveId;
	}
	public void setSelfArchiveId(Integer selfArchiveId) {
		this.selfArchiveId = selfArchiveId;
	}
	public Integer getCasePlateType() {
		return casePlateType;
	}
	public void setCasePlateType(Integer casePlateType) {
		this.casePlateType = casePlateType;
	}
	public String getCaseUseage() {
		return caseUseage;
	}
	public void setCaseUseage(String caseUseage) {
		this.caseUseage = caseUseage;
	}
	public Integer getSaleLeaseId() {
		return saleLeaseId;
	}
	public void setSaleLeaseId(Integer saleLeaseId) {
		this.saleLeaseId = saleLeaseId;
	}
	public Byte getCaseLevel() {
		return caseLevel;
	}
	public void setCaseLevel(Byte caseLevel) {
		this.caseLevel = caseLevel;
	}
	public boolean getIsGeneralManager() {
		return isGeneralManager;
	}
	public void setIsGeneralManager(boolean isGeneralManager) {
		this.isGeneralManager = isGeneralManager;
	}
	public StatisticDetailType getStatisticDetailType() {
		return statisticDetailType;
	}
	public void setStatisticDetailType(StatisticDetailType statisticDetailType) {
		this.statisticDetailType = statisticDetailType;
	}
	public String getPcname() {
		return pcname;
	}
	public void setPcname(String pcname) {
		this.pcname = pcname;
	}
	public String getUserPosition() {
		return userPosition;
	}
	public void setUserPosition(String userPosition) {
		this.userPosition = userPosition;
	}
	public String getPhotoIds() {
		return photoIds;
	}
	public void setPhotoIds(String photoIds) {
		this.photoIds = photoIds;
	}
	public String getCreateCurrUserName() {
		return createCurrUserName;
	}
	public void setCreateCurrUserName(String createCurrUserName) {
		this.createCurrUserName = createCurrUserName;
	}
	public String getSelfCurrUserName() {
		return selfCurrUserName;
	}
	public void setSelfCurrUserName(String selfCurrUserName) {
		this.selfCurrUserName = selfCurrUserName;
	}
	public boolean getCasePublish() {
		return casePublish;
	}
	public void setCasePublish(boolean casePublish) {
		this.casePublish = casePublish;
	}
	public boolean getCaseCooperate() {
		return caseCooperate;
	}
	public void setCaseCooperate(boolean caseCooperate) {
		this.caseCooperate = caseCooperate;
	}
	public Integer getSureToAviliable() {
		return sureToAviliable;
	}
	public void setSureToAviliable(Integer sureToAviliable) {
		this.sureToAviliable = sureToAviliable;
	}
	public Integer getRegionId() {
		return regionId;
	}
	public void setRegionId(Integer regionId) {
		this.regionId = regionId;
	}
	public Integer getSectionId() {
		return sectionId;
	}
	public void setSectionId(Integer sectionId) {
		this.sectionId = sectionId;
	}

	public String getVideoIds() {
		return videoIds;
	}
	public void setVideoIds(String videoIds) {
		this.videoIds = videoIds;
	}
	public String getVrIds() {
		return vrIds;
	}
	public void setVrIds(String vrIds) {
		this.vrIds = vrIds;
	}

	public String getVideoUrls() {
		return videoUrls;
	}
	public void setVideoUrls(String videoUrls) {
		this.videoUrls = videoUrls;
	}

	public String getCaseBuildName() {
		return caseBuildName;
	}

	public void setCaseBuildName(String caseBuildName) {
		this.caseBuildName = caseBuildName;
	}

	public Byte getIsSaleLease() {
		return isSaleLease;
	}

	public void setIsSaleLease(Byte isSaleLease) {
		this.isSaleLease = isSaleLease;
	}

	public CaseInfoDto getTargetCaseInfoDto() {
		return targetCaseInfoDto;
	}

	public void setTargetCaseInfoDto(CaseInfoDto targetCaseInfoDto) {
		this.targetCaseInfoDto = targetCaseInfoDto;
	}

	public Integer getKey() {
		return key;
	}

	public void setKey(Integer key) {
		this.key = key;
	}

	public Integer getIsMobileApi() {
		return isMobileApi;
	}

	public void setIsMobileApi(Integer isMobileApi) {
		this.isMobileApi = isMobileApi;
	}


	public String getNewBuildName() {
		return newBuildName;
	}


	public void setNewBuildName(String newBuildName) {
		this.newBuildName = newBuildName;
	}

	public String getCoreSellPoint() {
		return coreSellPoint;
	}

	public void setCoreSellPoint(String coreSellPoint) {
		this.coreSellPoint = coreSellPoint;
	}

	public String getLayoutIntroduce() {
		return layoutIntroduce;
	}

	public void setLayoutIntroduce(String layoutIntroduce) {
		this.layoutIntroduce = layoutIntroduce;
	}

	public String getFitmentDescribe() {
		return fitmentDescribe;
	}

	public void setFitmentDescribe(String fitmentDescribe) {
		this.fitmentDescribe = fitmentDescribe;
	}

	public String getPropertyRights() {
		return propertyRights;
	}

	public void setPropertyRights(String propertyRights) {
		this.propertyRights = propertyRights;
	}

	public String getTaskSubject() {
		return taskSubject;
	}

	public void setTaskSubject(String taskSubject) {
		this.taskSubject = taskSubject;
	}

	public String getVideoLocations() {
		return videoLocations;
	}

	public void setVideoLocations(String videoLocations) {
		this.videoLocations = videoLocations;
	}

	public String getVideoShootingTimes() {
		return videoShootingTimes;
	}

	public void setVideoShootingTimes(String videoShootingTimes) {
		this.videoShootingTimes = videoShootingTimes;
	}

	
}

