package com.myfun.erpWeb.managecenter.mlEntrustManage.vo;

import com.myfun.repository.param.EncryParamIfc;
import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author HuangJiang
 * @since 2019年12月05日 16:17:19
 * Modified XXX HuangJiang 2019年12月05日
 */
public class EntrusListVO {

    
    @ApiModelProperty(value = "委托ID")
    private Integer entrustId;
    @ApiModelProperty(value = "申请时间")
    private Date createTime;
    @ApiModelProperty(value = "楼盘名称")
    private String buildName;
    @ApiModelProperty(value = "楼层")
    private String floor;
    @ApiModelProperty(value = "总楼层")
    private String totalFloor;
    @ApiModelProperty(value = "栋座")
    private String roof;
    @ApiModelProperty(value = "单元")
    private String unit;
    @ApiModelProperty(value = "房号")
    private String roomNum;
    @ApiModelProperty(value = "委托开始时间")
    private String entrustStart;
    @ApiModelProperty(value = "委托结束时间")
    private String entrustEnd;
    @ApiModelProperty(value = "申请人ID")
    private Integer approveUserId;
    @ApiModelProperty(value = "申请人姓名")
    private String approveUserName;
    @ApiModelProperty(value = "申请人部门")
    private String approveOrganizationName;
    @ApiModelProperty(value = "备案编号")
    private String recordNo;
    @ApiModelProperty(value = "备案日期")
    private Date recordTime;
    @ApiModelProperty(value = "备案人ID")
    private Integer recordUser;
    @ApiModelProperty(value = "备案人姓名")
    private String recordUserName;
    @ApiModelProperty(value = "备案人部门")
    private String recordOrganizationName;
    @ApiModelProperty(value = "审核人ID")
    private Integer auditUserId;
    @ApiModelProperty(value = "审核人姓名")
    private String auditUserName;
    @ApiModelProperty(value = "审核日期")
    private Date auditDate;
    @ApiModelProperty(value = "房源ID")
    private Integer caseId;
    @ApiModelProperty(value = "房源类型 1=出售 2=出租")
    private Integer caseType;
    @ApiModelProperty(value = "是否电子委托：0=否（纸质委托）；1=是（电子委托）")
    private Byte electronicEntrust;
    @ApiModelProperty(value = "电子委托书类型（1=标准；2=简易）")
    private Byte electronicEntrustType;
    @ApiModelProperty(value = "是否有效（1=有效；0=无效）")
    private Byte isEffective;
    @ApiModelProperty(value = "是否签约（1=签约完毕；0=待签约）")
    private Byte signStatus;
    @ApiModelProperty(value = "审核状态（0=待审核 1=审核拒绝 2=审核完成）")
    private Byte auditStatus;
    @ApiModelProperty(value = "委托状态：1=正常 2=已过期 3=已撤销 4=已删除 5=已驳回 6=转暂缓 7=内成交 8=外成交 9=转删除 10=未签署 11=待签署 12=清空备案 13=修改价格")
    private Byte entrustStatus;
    @ApiModelProperty(value = "备案状态（1=正常；0=清空备案）")
    private Byte recordStatus;
    @ApiModelProperty(value = "审核ID")
    private Integer auditId;
    @ApiModelProperty(value = "是否当前审核人，不为空则是当前审核人")
    private Integer canAudit;
    @ApiModelProperty("出售委托价格")
    private BigDecimal saleEntrustPrice;
    @ApiModelProperty("出租委托价格")
    private BigDecimal leaseEntrustPrice;
    @ApiModelProperty(value = "出租 委托价格单位id")
    private Byte priceUnit;
    @ApiModelProperty("租售房源并且开启了租售共享")
    private Boolean saleLease;
    @ApiModelProperty("房屋用途")
    private Byte houseUseage;
    @ApiModelProperty(value="委托类型（1=普通；2=独家）")
    private Byte entrustType;

    public Byte getEntrustType() {
        return entrustType;
    }

    public void setEntrustType(Byte entrustType) {
        this.entrustType = entrustType;
    }

    public Byte getHouseUseage() {
        return houseUseage;
    }

    public void setHouseUseage(Byte houseUseage) {
        this.houseUseage = houseUseage;
    }

    public Boolean getSaleLease() {
        return saleLease;
    }

    public void setSaleLease(Boolean saleLease) {
        this.saleLease = saleLease;
    }

    public Byte getPriceUnit() {
        return priceUnit;
    }

    public void setPriceUnit(Byte priceUnit) {
        this.priceUnit = priceUnit;
    }

    public BigDecimal getSaleEntrustPrice() {
        return saleEntrustPrice;
    }

    public void setSaleEntrustPrice(BigDecimal saleEntrustPrice) {
        this.saleEntrustPrice = saleEntrustPrice == null ? null : new BigDecimal(saleEntrustPrice.stripTrailingZeros().toPlainString());
    }

    public BigDecimal getLeaseEntrustPrice() {
        return leaseEntrustPrice;
    }

    public void setLeaseEntrustPrice(BigDecimal leaseEntrustPrice) {
        this.leaseEntrustPrice = leaseEntrustPrice == null ? null : new BigDecimal(leaseEntrustPrice.stripTrailingZeros().toPlainString());
    }

    public Integer getEntrustId() {
        return entrustId;
    }
    
    public void setEntrustId(Integer entrustId) {
        this.entrustId = entrustId;
    }
    
    public Date getCreateTime() {
        return createTime;
    }
    
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
    
    public String getBuildName() {
        return buildName;
    }
    
    public void setBuildName(String buildName) {
        this.buildName = buildName;
    }
    
    public String getFloor() {
        return floor;
    }
    
    public void setFloor(String floor) {
        this.floor = floor;
    }
    
    public String getTotalFloor() {
        return totalFloor;
    }
    
    public void setTotalFloor(String totalFloor) {
        this.totalFloor = totalFloor;
    }
    
    public String getRoof() {
        return roof;
    }
    
    public void setRoof(String roof) {
        this.roof = roof;
    }
    
    public String getUnit() {
        return unit;
    }
    
    public void setUnit(String unit) {
        this.unit = unit;
    }
    
    public String getRoomNum() {
        return roomNum;
    }
    
    public void setRoomNum(String roomNum) {
        this.roomNum = roomNum;
    }
    
    public String getEntrustStart() {
        return entrustStart;
    }
    
    public void setEntrustStart(String entrustStart) {
        this.entrustStart = entrustStart;
    }
    
    public String getEntrustEnd() {
        return entrustEnd;
    }
    
    public void setEntrustEnd(String entrustEnd) {
        this.entrustEnd = entrustEnd;
    }
    
    public Integer getApproveUserId() {
        return approveUserId;
    }
    
    public void setApproveUserId(Integer approveUserId) {
        this.approveUserId = approveUserId;
    }
    
    public String getApproveUserName() {
        return approveUserName;
    }
    
    public void setApproveUserName(String approveUserName) {
        this.approveUserName = approveUserName;
    }
    
    public String getApproveOrganizationName() {
        return approveOrganizationName;
    }
    
    public void setApproveOrganizationName(String approveOrganizationName) {
        this.approveOrganizationName = approveOrganizationName;
    }
    
    public String getRecordNo() {
        return recordNo;
    }
    
    public void setRecordNo(String recordNo) {
        this.recordNo = recordNo;
    }
    
    public Date getRecordTime() {
        return recordTime;
    }
    
    public void setRecordTime(Date recordTime) {
        this.recordTime = recordTime;
    }
    
    public Integer getRecordUser() {
        return recordUser;
    }
    
    public void setRecordUser(Integer recordUser) {
        this.recordUser = recordUser;
    }
    
    public String getRecordUserName() {
        return recordUserName;
    }
    
    public void setRecordUserName(String recordUserName) {
        this.recordUserName = recordUserName;
    }
    
    public String getRecordOrganizationName() {
        return recordOrganizationName;
    }
    
    public void setRecordOrganizationName(String recordOrganizationName) {
        this.recordOrganizationName = recordOrganizationName;
    }
    
    public Integer getAuditUserId() {
        return auditUserId;
    }
    
    public void setAuditUserId(Integer auditUserId) {
        this.auditUserId = auditUserId;
    }
    
    public String getAuditUserName() {
        return auditUserName;
    }
    
    public void setAuditUserName(String auditUserName) {
        this.auditUserName = auditUserName;
    }
    
    public Date getAuditDate() {
        return auditDate;
    }
    
    public void setAuditDate(Date auditDate) {
        this.auditDate = auditDate;
    }
    
    public Integer getCaseId() {
        return caseId;
    }
    
    public void setCaseId(Integer caseId) {
        this.caseId = caseId;
    }
    
    public Integer getCaseType() {
        return caseType;
    }
    
    public void setCaseType(Integer caseType) {
        this.caseType = caseType;
    }
    
    public Byte getElectronicEntrust() {
        return electronicEntrust;
    }
    
    public void setElectronicEntrust(Byte electronicEntrust) {
        this.electronicEntrust = electronicEntrust;
    }
    
    public Byte getElectronicEntrustType() {
        return electronicEntrustType;
    }
    
    public void setElectronicEntrustType(Byte electronicEntrustType) {
        this.electronicEntrustType = electronicEntrustType;
    }
    
    public Byte getIsEffective() {
        return isEffective;
    }
    
    public void setIsEffective(Byte isEffective) {
        this.isEffective = isEffective;
    }
    
    public Byte getSignStatus() {
        return signStatus;
    }
    
    public void setSignStatus(Byte signStatus) {
        this.signStatus = signStatus;
    }
    
    public Byte getAuditStatus() {
        return auditStatus;
    }
    
    public void setAuditStatus(Byte auditStatus) {
        this.auditStatus = auditStatus;
    }
    
    public Byte getEntrustStatus() {
        return entrustStatus;
    }
    
    public void setEntrustStatus(Byte entrustStatus) {
        this.entrustStatus = entrustStatus;
    }
    
    public Byte getRecordStatus() {
        return recordStatus;
    }
    
    public void setRecordStatus(Byte recordStatus) {
        this.recordStatus = recordStatus;
    }
    
    public Integer getAuditId() {
        return auditId;
    }
    
    public void setAuditId(Integer auditId) {
        this.auditId = auditId;
    }
    
    public Integer getCanAudit() {
        return canAudit;
    }
    
    public void setCanAudit(Integer canAudit) {
        this.canAudit = canAudit;
    }
}
