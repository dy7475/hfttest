package com.myfun.erpWeb.house.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @Author 蔡春林
 * @Date 2019/11/25 0025 下午 5:03
 **/
@ApiModel
public class MlEntrustVO implements Serializable {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "委托ID")
    private Integer entrustId; 
    @ApiModelProperty(value = "房源ID")
    private Integer caseId;
    @ApiModelProperty(value = "房源类型（1=出售；2=出租）")
    private Byte caseType;
    @ApiModelProperty(value = "委托业务（1=出售委托；2出租委托 3代表租售共用）")
    private Byte entrustBusiness;
    @ApiModelProperty(value = "产权地址")
    private String houseAddr;
    @ApiModelProperty(value = "委托类型（1=普通；2=独家）")
    private Byte entrustType;
    @ApiModelProperty(value = "是否电子委托（0=否；1=是）")
    private Byte electronicEntrust;
    @ApiModelProperty(value = "产权状态（1=完整产权；2=有抵押）")
    private Byte houseStatus;
    @ApiModelProperty(value = "委托编号")
    private String entrustNo;
    @ApiModelProperty(value = "委托起始期限")
    private String entrustStart;
    @ApiModelProperty(value = "委托截止期限")
    private String entrustEnd;
    @ApiModelProperty(value = "电子委托书类型（1=标准；2=简易）")
    private Byte electronicEntrustType;
    @ApiModelProperty(value = "代业主保管文件")
    private String depositFileForCustom;
    @ApiModelProperty(value = "看房方式（1=甲方将物业钥匙交予乙方作看房之用；2=双方另行约定时间看房）")
    private Byte inspectionType;
    @ApiModelProperty(value = "出售佣金")
    private BigDecimal saleCommission;
    @ApiModelProperty(value = "出租佣金")
    private BigDecimal leaseCommission;
    @ApiModelProperty(value = "是否有租约 1有 0无")
    private Byte hasLeaseContract;
    @ApiModelProperty(value = "租期到期")
    private Date leaseEndTime;
    @ApiModelProperty(value = "是否有效（1=有效；0=无效）")
    private Byte isEffective;
    @ApiModelProperty(value = "是否签约（1=签约完毕；0=待签约）")
    private Byte signStatus;
    @ApiModelProperty(value = "审核状态（0=待审核；1=审核失败；2审核成功）")
    private Byte auditStatus;
    @ApiModelProperty(value = "失效时间 即变更历史时间")
    private Date incalidDate;
    @ApiModelProperty(value = "签约完成时间")
    private Date signFinashDate;
    @ApiModelProperty(value = "审核时间")
    private Date auditDate;
    @ApiModelProperty(value = "审核人")
    private Integer auditUserId;
    @ApiModelProperty(value = "审核姓名")
    private String auditUserName;
    @ApiModelProperty(value = "失效原因 1 删除 2.撤销 3.业主超期未签署 4.委托到期 5.房源转暂缓 6.房源转内成交 7房源转外成交 8房源转删除 9备案清空 10价格变动 11.审核不通过")
    private Byte incalidReason;
    @ApiModelProperty(value = "备案人")
    private Integer recordUser;
    @ApiModelProperty(value = "备案人门店")
    private String recordUserDept;
    @ApiModelProperty(value = "备案日期")
    private Date recordTime;
    @ApiModelProperty(value = "备案号")
    private String recordNo;
    @ApiModelProperty(value = "备案修改时间")
    private Date recordUpdateTime;
    @ApiModelProperty(value = "备案状态（1=未备案 2=已备案 0=清空备案）")
    private Byte recordStatus;
    @ApiModelProperty(value = "申请人门店")
    private String approveDept;
    @ApiModelProperty(value = "申请人")
    private Integer approveUserId;
    @ApiModelProperty(value = "申请人姓名")
    private String approveUserName;
    @ApiModelProperty(value = "申请人头像")
    private String approveUserPhoto; 
    @ApiModelProperty(value = "组织名称")
    private String associationName;
    @ApiModelProperty(value = "申请时间 表示委托的上传时间")
    private Date createTime;
    @ApiModelProperty(value = "签约截止期")
    private Date signEndTime;
    @ApiModelProperty(value = "业主信息")
    private List<OwnerUserVO> ownerUserVOList;
    @ApiModelProperty(value = "产权信息")
    private List<EntrustCertificateVO> entrustCertificateVOList;
    @ApiModelProperty(value = "文件信息")
    private List<EntrustFilesVO> entrustFilesVOList;
    @ApiModelProperty(value = "控制撤销按钮 1展示 0隐藏 默认0")
    private Byte canCancel = 0;
    @ApiModelProperty(value = "控制删除按钮 1展示 0隐藏 默认0")
    private Byte canDelete = 0;
    @ApiModelProperty(value = "控制编辑按钮 1展示 0隐藏 默认0")
    private Byte canEdit = 0;
    @ApiModelProperty(value = "控制查看 1可以 0隐藏 默认0")
    private Byte canView = 0;
    @ApiModelProperty(value = "手动填写的租金")
    private BigDecimal customRentAmount;

    public BigDecimal getCustomRentAmount() {
        return this.customRentAmount;
    }

    public void setCustomRentAmount(final BigDecimal customRentAmount) {
        this.customRentAmount = customRentAmount;
    }

    public Byte getCanView() {
        return canView;
    }

    public void setCanView(Byte canView) {
        this.canView = canView;
    }

    public Integer getEntrustId() {
        return entrustId;
    }

    public void setEntrustId(Integer entrustId) {
        this.entrustId = entrustId;
    }

    public Integer getCaseId() {
        return caseId;
    }

    public void setCaseId(Integer caseId) {
        this.caseId = caseId;
    }

    public Byte getCaseType() {
        return caseType;
    }

    public void setCaseType(Byte caseType) {
        this.caseType = caseType;
    }

    public Byte getEntrustBusiness() {
        return entrustBusiness;
    }

    public void setEntrustBusiness(Byte entrustBusiness) {
        this.entrustBusiness = entrustBusiness;
    }
    public String getHouseAddr() {
        return houseAddr;
    }

    public void setHouseAddr(String houseAddr) {
        this.houseAddr = houseAddr;
    }

    public Byte getEntrustType() {
        return entrustType;
    }

    public void setEntrustType(Byte entrustType) {
        this.entrustType = entrustType;
    }

    public Byte getElectronicEntrust() {
        return electronicEntrust;
    }

    public void setElectronicEntrust(Byte electronicEntrust) {
        this.electronicEntrust = electronicEntrust;
    }

    public Byte getHouseStatus() {
        return houseStatus;
    }

    public void setHouseStatus(Byte houseStatus) {
        this.houseStatus = houseStatus;
    }

    public String getEntrustNo() {
        return entrustNo;
    }

    public void setEntrustNo(String entrustNo) {
        this.entrustNo = entrustNo;
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

    public Byte getElectronicEntrustType() {
        return electronicEntrustType;
    }

    public void setElectronicEntrustType(Byte electronicEntrustType) {
        this.electronicEntrustType = electronicEntrustType;
    }

    public String getDepositFileForCustom() {
        return depositFileForCustom;
    }

    public void setDepositFileForCustom(String depositFileForCustom) {
        this.depositFileForCustom = depositFileForCustom;
    }

    public Byte getInspectionType() {
        return inspectionType;
    }

    public void setInspectionType(Byte inspectionType) {
        this.inspectionType = inspectionType;
    }

    public BigDecimal getSaleCommission() {
        return saleCommission;
    }

    public void setSaleCommission(BigDecimal saleCommission) {
        this.saleCommission = saleCommission;
    }

    public BigDecimal getLeaseCommission() {
        return leaseCommission;
    }

    public void setLeaseCommission(BigDecimal leaseCommission) {
        this.leaseCommission = leaseCommission;
    }

    public Byte getHasLeaseContract() {
        return hasLeaseContract;
    }

    public void setHasLeaseContract(Byte hasLeaseContract) {
        this.hasLeaseContract = hasLeaseContract;
    }

    public Date getLeaseEndTime() {
        return leaseEndTime;
    }

    public void setLeaseEndTime(Date leaseEndTime) {
        this.leaseEndTime = leaseEndTime;
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

    public Date getIncalidDate() {
        return incalidDate;
    }

    public void setIncalidDate(Date incalidDate) {
        this.incalidDate = incalidDate;
    }

    public Date getSignFinashDate() {
        return signFinashDate;
    }

    public void setSignFinashDate(Date signFinashDate) {
        this.signFinashDate = signFinashDate;
    }

    public Date getAuditDate() {
        return auditDate;
    }

    public void setAuditDate(Date auditDate) {
        this.auditDate = auditDate;
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

    public Byte getIncalidReason() {
        return incalidReason;
    }

    public void setIncalidReason(Byte incalidReason) {
        this.incalidReason = incalidReason;
    }

    public Integer getRecordUser() {
        return recordUser;
    }

    public void setRecordUser(Integer recordUser) {
        this.recordUser = recordUser;
    }

    public String getRecordUserDept() {
        return recordUserDept;
    }

    public void setRecordUserDept(String recordUserDept) {
        this.recordUserDept = recordUserDept;
    }

    public Date getRecordTime() {
        return recordTime;
    }

    public void setRecordTime(Date recordTime) {
        this.recordTime = recordTime;
    }

    public String getRecordNo() {
        return recordNo;
    }

    public void setRecordNo(String recordNo) {
        this.recordNo = recordNo;
    }

    public Date getRecordUpdateTime() {
        return recordUpdateTime;
    }

    public void setRecordUpdateTime(Date recordUpdateTime) {
        this.recordUpdateTime = recordUpdateTime;
    }

    public Byte getRecordStatus() {
        return recordStatus;
    }

    public void setRecordStatus(Byte recordStatus) {
        this.recordStatus = recordStatus;
    }

    public String getApproveDept() {
        return approveDept;
    }

    public void setApproveDept(String approveDept) {
        this.approveDept = approveDept;
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

    public String getApproveUserPhoto() {
        return approveUserPhoto;
    }

    public void setApproveUserPhoto(String approveUserPhoto) {
        this.approveUserPhoto = approveUserPhoto;
    }

    public String getAssociationName() {
        return associationName;
    }

    public void setAssociationName(String associationName) {
        this.associationName = associationName;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getSignEndTime() {
        return signEndTime;
    }

    public void setSignEndTime(Date signEndTime) {
        this.signEndTime = signEndTime;
    }

    public List<OwnerUserVO> getOwnerUserVOList() {
        return ownerUserVOList;
    }

    public void setOwnerUserVOList(List<OwnerUserVO> ownerUserVOList) {
        this.ownerUserVOList = ownerUserVOList;
    }

    public List<EntrustCertificateVO> getEntrustCertificateVOList() {
        return entrustCertificateVOList;
    }

    public void setEntrustCertificateVOList(List<EntrustCertificateVO> entrustCertificateVOList) {
        this.entrustCertificateVOList = entrustCertificateVOList;
    }

    public List<EntrustFilesVO> getEntrustFilesVOList() {
        return entrustFilesVOList;
    }

    public void setEntrustFilesVOList(List<EntrustFilesVO> entrustFilesVOList) {
        this.entrustFilesVOList = entrustFilesVOList;
    }

    public Byte getCanCancel() {
        return canCancel == null ? 0 : canCancel;
    }

    public void setCanCancel(Byte canCancel) {
        this.canCancel = canCancel;
    }

    public Byte getCanDelete() {
        return canDelete == null ? 0 : canDelete;
    }

    public void setCanDelete(Byte canDelete) {
        this.canDelete = canDelete;
    }

    public Byte getCanEdit() {
        return canEdit == null ? 0 : canEdit;
    }

    public void setCanEdit(Byte canEdit) {
        this.canEdit = canEdit;
    }
}
