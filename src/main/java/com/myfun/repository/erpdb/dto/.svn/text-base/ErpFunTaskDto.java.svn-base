package com.myfun.repository.erpdb.dto;
import com.myfun.repository.erpdb.po.ErpFunTask;
import com.myfun.repository.erpdb.po.ErpFunTrack;

import io.swagger.annotations.ApiModelProperty;

public class ErpFunTaskDto extends ErpFunTask {
    /**
	 * @author 臧铁
	 * @since 2017年7月11日
	 */
	private static final long serialVersionUID = 1L;
	private String deptName;// 部门名称
	private String userName;// 用户姓名
	private String trackUser;// 带看人和带看门店
	private Integer areaId;// 大区
	private Integer regId;// 片区
	private Integer grId;// 分组
	private Integer keyDeptId;// 钥匙相关的门店ID
	private String keyNum;// 钥匙编号
	private Integer biddingStatus;// 房源是否推广 0=未推广 1=推广
	private Integer caseUserId;// 跟进房客源所属人ID
	private Integer caseDeptId;// 跟进房客源所属门店ID
	private String proxyUrl;// 委托书地址
	private Byte caseStatus;// 信息状态，DD:HOUSE_STATUS
	private Integer dkPhotoCount;// 带看确认书数量
	private Integer fkPhotoCount;// 房勘数量
	private Byte isDeltrack;// 是否是删除图片跟进1=是
	private Integer isUserTrack;// 是否是用户自己手动写的跟进
	private Integer targetDept;// 目标门店
	private Boolean targetFlag;// 带看标记2008-11-19更新为所有审核通过标记，null=初始值 1=审核通过 0=审核未通过
	private Integer targetId;// 目标ID
	private String targetNo;// 目标编号
	private Byte targetType;// 目标信息类型，DD:CASE_TYPE
	private Byte targetUseage;// 目标房源用途
	private Integer targetUserId;// 带看目标源所属人ID
	private String trackClassic;// 跟进类型
	private String trackContent;// 跟进内容
	private String trackNo;// 跟进编号，委托、带看
	private Byte trackResult;// 看房点评和带看视频使用，1:包含视频
	private Boolean trackKey;// 钥匙类型，1=提交钥匙0=收回钥匙
	private Byte isDel;// 是否删除 1=已删除
	private Integer notReadCount;// 未读人数
	private Integer organizationId;// 发起人所在组织ID，新版组织架构使用
	private String creatorCompName;// 发起人组织名称
	private String creatorUserName;// 发起人姓名

	@ApiModelProperty(value = "对应房源就是小区名称，对应客源就是客源姓名")
	private String caseName;
	
	@ApiModelProperty(value = "对应房源就是房源面积，对应客源就是意向面积区间")
	private String caseArea;
	
	@ApiModelProperty(value = "对应房源就是房源价格，对应客源就是意向价格区间")
	private String casePrice;
	
	@ApiModelProperty(value = "几房/几室")
	private Byte room;
	
	@ApiModelProperty(value = "出租价格单位")
	private Byte priceUnit;
	
	@ApiModelProperty(value = "求租求购用户的性别")
	private Boolean caseSex;
	
	@ApiModelProperty(value = "房客源概要信息 如:谢先生 3室 100-120㎡ 150-180万")
	private String caseSummaryInfo;


	public Integer getOrganizationId() {
		return organizationId;
	}

	public void setOrganizationId(Integer organizationId) {
		this.organizationId = organizationId;
	}

	public Integer getFkPhotoCount() {
		return fkPhotoCount;
	}

	public void setFkPhotoCount(Integer fkPhotoCount) {
		this.fkPhotoCount = fkPhotoCount;
	}

	public Boolean getTrackKey() {
		return trackKey;
	}

	public void setTrackKey(Boolean trackKey) {
		this.trackKey = trackKey;
	}

	public Byte getIsDel() {
		return isDel;
	}

	public void setIsDel(Byte isDel) {
		this.isDel = isDel;
	}

	public Byte getCaseStatus() {
		return caseStatus;
	}

	public void setCaseStatus(Byte caseStatus) {
		this.caseStatus = caseStatus;
	}

	public Integer getDkPhotoCount() {
		return dkPhotoCount;
	}

	public void setDkPhotoCount(Integer dkPhotoCount) {
		this.dkPhotoCount = dkPhotoCount;
	}

	public Byte getIsDeltrack() {
		return isDeltrack;
	}

	public void setIsDeltrack(Byte isDeltrack) {
		this.isDeltrack = isDeltrack;
	}

	public Integer getIsUserTrack() {
		return isUserTrack;
	}

	public void setIsUserTrack(Integer isUserTrack) {
		this.isUserTrack = isUserTrack;
	}

	public Integer getTargetDept() {
		return targetDept;
	}

	public void setTargetDept(Integer targetDept) {
		this.targetDept = targetDept;
	}

	public Boolean getTargetFlag() {
		return targetFlag;
	}

	public void setTargetFlag(Boolean targetFlag) {
		this.targetFlag = targetFlag;
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

	public Byte getTargetType() {
		return targetType;
	}

	public void setTargetType(Byte targetType) {
		this.targetType = targetType;
	}

	public Byte getTargetUseage() {
		return targetUseage;
	}

	public void setTargetUseage(Byte targetUseage) {
		this.targetUseage = targetUseage;
	}

	public Integer getTargetUserId() {
		return targetUserId;
	}

	public void setTargetUserId(Integer targetUserId) {
		this.targetUserId = targetUserId;
	}

	public String getTrackClassic() {
		return trackClassic;
	}

	public void setTrackClassic(String trackClassic) {
		this.trackClassic = trackClassic;
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

	public Byte getTrackResult() {
		return trackResult;
	}

	public void setTrackResult(Byte trackResult) {
		this.trackResult = trackResult;
	}

	public Integer getCaseDeptId() {
		return caseDeptId;
	}

	public void setCaseDeptId(Integer caseDeptId) {
		this.caseDeptId = caseDeptId;
	}

	public String getProxyUrl() {
		return proxyUrl;
	}

	public void setProxyUrl(String proxyUrl) {
		this.proxyUrl = proxyUrl;
	}

	public Integer getCaseUserId() {
		return caseUserId;
	}

	public void setCaseUserId(Integer caseUserId) {
		this.caseUserId = caseUserId;
	}

	public Integer getBiddingStatus() {
		return biddingStatus;
	}

	public void setBiddingStatus(Integer biddingStatus) {
		this.biddingStatus = biddingStatus;
	}

	public String getKeyNum() {
		return keyNum;
	}

	public void setKeyNum(String keyNum) {
		this.keyNum = keyNum;
	}

	public Integer getKeyDeptId() {
		return keyDeptId;
	}

	public void setKeyDeptId(Integer keyDeptId) {
		this.keyDeptId = keyDeptId;
	}

	public String getTrackUser() {
		return trackUser;
	}

	public void setTrackUser(String trackUser) {
		this.trackUser = trackUser;
	}

	public Integer getAreaId() {
		return areaId;
	}

	public void setAreaId(Integer areaId) {
		this.areaId = areaId;
	}

	public Integer getRegId() {
		return regId;
	}

	public void setRegId(Integer regId) {
		this.regId = regId;
	}

	public Integer getGrId() {
		return grId;
	}

	public void setGrId(Integer grId) {
		this.grId = grId;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Integer getNotReadCount() {
		return notReadCount;
	}

	public void setNotReadCount(Integer notReadCount) {
		this.notReadCount = notReadCount;
	}

	public String getCaseName() {
		return caseName;
	}

	public void setCaseName(String caseName) {
		this.caseName = caseName;
	}

	public String getCaseArea() {
		return caseArea;
	}

	public void setCaseArea(String caseArea) {
		this.caseArea = caseArea;
	}

	public String getCasePrice() {
		return casePrice;
	}

	public void setCasePrice(String casePrice) {
		this.casePrice = casePrice;
	}

	public Byte getRoom() {
		return room;
	}

	public void setRoom(Byte room) {
		this.room = room;
	}

	public Byte getPriceUnit() {
		return priceUnit;
	}

	public void setPriceUnit(Byte priceUnit) {
		this.priceUnit = priceUnit;
	}

	public Boolean getCaseSex() {
		return caseSex;
	}

	public void setCaseSex(Boolean caseSex) {
		this.caseSex = caseSex;
	}

	public String getCaseSummaryInfo() {
		return caseSummaryInfo;
	}

	public void setCaseSummaryInfo(String caseSummaryInfo) {
		this.caseSummaryInfo = caseSummaryInfo;
	}

	public String getCreatorCompName() {
		return creatorCompName;
	}

	public void setCreatorCompName(String creatorCompName) {
		this.creatorCompName = creatorCompName;
	}

	public String getCreatorUserName() {
		return creatorUserName;
	}

	public void setCreatorUserName(String creatorUserName) {
		this.creatorUserName = creatorUserName;
	}
}