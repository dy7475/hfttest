package com.myfun.repository.erpdb.dto;

import java.math.BigDecimal;
import java.util.List;

import com.myfun.erpWeb.managecenter.sysmanager.vo.AuditDetailCommentVO;
import com.myfun.repository.erpdb.po.ErpAuditRuntime;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class ErpAuditRuntimeDto extends ErpAuditRuntime{
	private static final long serialVersionUID = 1L;
	
	@ApiModelProperty(value = "是否可以审核")
	private Integer canAuditTask;

	@ApiModelProperty(value = "楼盘名")
	private String buildName;

	@ApiModelProperty(value = "用途")
	private Byte useage;

	@ApiModelProperty(value = "面积")
	private BigDecimal houseArea;

	@ApiModelProperty(value = "几室")
	private Byte houseRoom;

	@ApiModelProperty(value = "几厅")
	private Byte houseHall;

	@ApiModelProperty(value = "租金单位，DD:PRICE_UNIT")
	private Byte housePriceUnit;

	@ApiModelProperty(value = "总价")
	private BigDecimal houseTotalPrice;

	@ApiModelProperty(value = "装修")
	private Byte houseFitment;

	@ApiModelProperty(value = "朝向")
	private Byte houseDirect;

	@ApiModelProperty(value = "房客源所属门店")
	private Integer houseCustDeptId;

	@ApiModelProperty(value = "所属人")
	private Integer houseCustUserId;

	@ApiModelProperty(value = "用户头像")
	private String userPhoto;

	@ApiModelProperty(value = "门店Id")
	private Integer deptId;

	@ApiModelProperty(value = "最小面积")
	private BigDecimal houseAreaLow;

	@ApiModelProperty(value = "最大面积")
	private BigDecimal houseAreaHigh;

	@ApiModelProperty(value = "最低价格")
	private BigDecimal housePriceLow;

	@ApiModelProperty(value = "最高价格")
	private BigDecimal housePriceHigh;

	@ApiModelProperty(value = "最少几室")
	private Byte houseRoomLow;

	@ApiModelProperty(value = "最多几室")
	private Byte houseRoomHigh;

	@ApiModelProperty(value = "带看的人员")
	private String custName;

	@ApiModelProperty(value = "当前待审批人的名字")
	private String nowAuditUsers;
	// 跟进扩展字段表

	@ApiModelProperty(value = "(出售)核心卖点   出租（房屋优势）")
	private String coreSellPoint;

	@ApiModelProperty(value = "(出售)装修描述 出租(房屋配套)")
	private String fitmentDescribe;

	@ApiModelProperty(value = "(出售)户型介绍  (出租)户型介绍")
	private String layoutIntroduce;

	@ApiModelProperty(value = "(出售)产权情况")
	private String propertyRights;

	@ApiModelProperty(value = "(出售)产权情况")
	private String otherInfo;

	@ApiModelProperty(value = "带看富文本标题")
	private String makeLookRichTitle;

	@ApiModelProperty(value = "所属人档案Id")
	private Integer houseCustArchiveId;

	@ApiModelProperty(value = "用户性别")
	private Integer userSex;
	
	@ApiModelProperty(value = "请假开始时间")
	private String leaveStartTime;
	
	@ApiModelProperty(value = "请假结束时间")
	private String leaveEndTime;
	
	@ApiModelProperty(value = "请假天数")
	private String leaveDay;
	
	@ApiModelProperty(value = "请假开始时间 1=上午 2=下午")
	private Byte leaveStartType;
	
	@ApiModelProperty(value = "请假结束时间 1=上午 2=下午")
	private Byte leaveEndType;
	
	@ApiModelProperty(value = "请假类型名称")
	private String leaveName;
	
	@ApiModelProperty(value = "请假类型id")
	private Integer leaveId;
	
	@ApiModelProperty(value = "房源信息")
	private String caseSummaryInfo;
    @ApiModelProperty(value = "如果auditSource=8 ,targetId 为踩盘id")
    private Integer targetId;

    @Override
    public Integer getTargetId() {
        return targetId;
    }

    @Override
    public void setTargetId(Integer targetId) {
        this.targetId = targetId;
    }

    @ApiModelProperty("审核的评论列表")
	private List<AuditDetailCommentVO> auditCommentList;

	public List<AuditDetailCommentVO> getAuditCommentList() {
		return auditCommentList;
	}

	public void setAuditCommentList(List<AuditDetailCommentVO> auditCommentList) {
		this.auditCommentList = auditCommentList;
	}

    public Integer getUserSex() {
        return userSex;
    }

    public void setUserSex(Integer userSex) {
        this.userSex = userSex;
    }

    public Integer getHouseCustArchiveId() {
		return houseCustArchiveId;
	}

	public void setHouseCustArchiveId(Integer houseCustArchiveId) {
		this.houseCustArchiveId = houseCustArchiveId;
	}

	public String getMakeLookRichTitle() {
		return makeLookRichTitle;
	}

	public void setMakeLookRichTitle(String makeLookRichTitle) {
		this.makeLookRichTitle = makeLookRichTitle;
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public Byte getHouseHall() {
		return houseHall;
	}

	public void setHouseHall(Byte houseHall) {
		this.houseHall = houseHall;
	}

	public Byte getHouseRoomLow() {
		return houseRoomLow;
	}

	public void setHouseRoomLow(Byte houseRoomLow) {
		this.houseRoomLow = houseRoomLow;
	}

	public Byte getHouseRoomHigh() {
		return houseRoomHigh;
	}

	public void setHouseRoomHigh(Byte houseRoomHigh) {
		this.houseRoomHigh = houseRoomHigh;
	}

	public BigDecimal getHousePriceLow() {
		return housePriceLow;
	}

	public void setHousePriceLow(BigDecimal housePriceLow) {
		this.housePriceLow = housePriceLow;
	}

	public BigDecimal getHousePriceHigh() {
		return housePriceHigh;
	}

	public void setHousePriceHigh(BigDecimal housePriceHigh) {
		this.housePriceHigh = housePriceHigh;
	}

	public BigDecimal getHouseAreaLow() {
		return houseAreaLow;
	}

	public void setHouseAreaLow(BigDecimal houseAreaLow) {
		this.houseAreaLow = houseAreaLow;
	}

	public BigDecimal getHouseAreaHigh() {
		return houseAreaHigh;
	}

	public void setHouseAreaHigh(BigDecimal houseAreaHigh) {
		this.houseAreaHigh = houseAreaHigh;
	}

	public Integer getDeptId() {
		return deptId;
	}

	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}

	public Byte getHouseRoom() {
		return houseRoom;
	}

	public void setHouseRoom(Byte houseRoom) {
		this.houseRoom = houseRoom;
	}

	public String getBuildName() {
		return buildName;
	}

	public void setBuildName(String buildName) {
		this.buildName = buildName;
	}

	public Byte getUseage() {
		return useage;
	}

	public void setUseage(Byte useage) {
		this.useage = useage;
	}

	public BigDecimal getHouseArea() {
		return houseArea;
	}

	public void setHouseArea(BigDecimal houseArea) {
		this.houseArea = houseArea;
	}

	public BigDecimal getHouseTotalPrice() {
		return houseTotalPrice;
	}

	public void setHouseTotalPrice(BigDecimal houseTotalPrice) {
		this.houseTotalPrice = houseTotalPrice;
	}

	public Byte getHouseFitment() {
		return houseFitment;
	}

	public void setHouseFitment(Byte houseFitment) {
		this.houseFitment = houseFitment;
	}

	public Byte getHouseDirect() {
		return houseDirect;
	}

	public void setHouseDirect(Byte houseDirect) {
		this.houseDirect = houseDirect;
	}

	public Integer getHouseCustUserId() {
		return houseCustUserId;
	}

	public void setHouseCustUserId(Integer houseCustUserId) {
		this.houseCustUserId = houseCustUserId;
	}
	public Integer getCanAuditTask() {
		return canAuditTask;
	}

	public void setCanAuditTask(Integer canAuditTask) {
		this.canAuditTask = canAuditTask;
	}

	public Byte getHousePriceUnit() {
		return housePriceUnit;
	}

	public void setHousePriceUnit(Byte housePriceUnit) {
		this.housePriceUnit = housePriceUnit;
	}

	public Integer getHouseCustDeptId() {
		return houseCustDeptId;
	}

	public void setHouseCustDeptId(Integer houseCustDeptId) {
		this.houseCustDeptId = houseCustDeptId;
	}

	public String getNowAuditUsers() {
		return nowAuditUsers;
	}

	public void setNowAuditUsers(String nowAuditUsers) {
		this.nowAuditUsers = nowAuditUsers;
	}

	public String getUserPhoto() {
		return userPhoto;
	}

	public void setUserPhoto(String userPhoto) {
		this.userPhoto = userPhoto;
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

	public String getOtherInfo() {
		return otherInfo;
	}

	public void setOtherInfo(String otherInfo) {
		this.otherInfo = otherInfo;
	}

	public String getLeaveStartTime() {
		return leaveStartTime;
	}

	public void setLeaveStartTime(String leaveStartTime) {
		this.leaveStartTime = leaveStartTime;
	}

	public String getLeaveEndTime() {
		return leaveEndTime;
	}

	public void setLeaveEndTime(String leaveEndTime) {
		this.leaveEndTime = leaveEndTime;
	}

	public String getLeaveDay() {
		return leaveDay;
	}

	public void setLeaveDay(String leaveDay) {
		this.leaveDay = leaveDay;
	}

	public Byte getLeaveStartType() {
		return leaveStartType;
	}

	public void setLeaveStartType(Byte leaveStartType) {
		this.leaveStartType = leaveStartType;
	}

	public Byte getLeaveEndType() {
		return leaveEndType;
	}

	public void setLeaveEndType(Byte leaveEndType) {
		this.leaveEndType = leaveEndType;
	}

	public String getLeaveName() {
		return leaveName;
	}

	public void setLeaveName(String leaveName) {
		this.leaveName = leaveName;
	}

	public Integer getLeaveId() {
		return leaveId;
	}

	public void setLeaveId(Integer leaveId) {
		this.leaveId = leaveId;
	}

	public String getCaseSummaryInfo() {
		return caseSummaryInfo;
	}

	public void setCaseSummaryInfo(String caseSummaryInfo) {
		this.caseSummaryInfo = caseSummaryInfo;
	}
	
}