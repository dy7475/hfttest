package com.myfun.erpWeb.house.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @Author 蔡春林
 * @Date 2019/11/23 0023 下午 3:15
 **/
@ApiModel(description = "委托协议详情")
public class EntrustProtocolDetailsVO implements Serializable {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty("业主证件信息")
    private List<OwnerUserVO> ownerUserVOList;
    @ApiModelProperty("委托楼盘名称+座落+房间号")
    private String EntrustSubject;   
    @ApiModelProperty("委托编号")
    private String entrustNo;    
    @ApiModelProperty("房源编号")
    private String houseNo;   
    @ApiModelProperty("委托类型 1出售 2出租 3出租出售共用")
    private Byte caseType; 
    @ApiModelProperty("产权状态（1=完整产权；2=有抵押）")
    private Byte houseStatus; 
    @ApiModelProperty("是否有租约 1有 0否")
    private Byte hasLeaseContract;
    @ApiModelProperty("租期到期时间")
    private Date leaseEndTime;
    @ApiModelProperty("原租约租金")
    private BigDecimal oldRentMoney; 
    @ApiModelProperty("原租约租金中文大写")
    private String oldRentMoneyCn; 
    @ApiModelProperty("委托起始期限")
    private String entrustStart;
    @ApiModelProperty("委托截止期限")
    private String entrustEnd;
    @ApiModelProperty("委托类型（1=普通；2=独家）")
    private Byte entrustType; 
    @ApiModelProperty("代业主保管文件")
    private String depositFileForCustom;
    @ApiModelProperty("看房方式（1=甲方将物业钥匙交予乙方作看房之用；2=双方另行约定时间看房）")
    private Byte inspectionType;
    @ApiModelProperty("出售佣金")
    private BigDecimal saleCommission;
    @ApiModelProperty("出售佣金中文大写")
    private String saleCommissionCn;  
    @ApiModelProperty("出租佣金")
    private BigDecimal leaseCommission;
    @ApiModelProperty("委托状态 1=有效；0=无效")
    private Byte isEffective;
    @ApiModelProperty(value = "委托Id")
    private Integer entrustId;
    @ApiModelProperty(value = "当前业主Id")
    private Integer currentOwerUserId;
    @ApiModelProperty("房屋面积")
    private BigDecimal houseArea;
    @ApiModelProperty("出售房屋价格")
    private BigDecimal salePrice;
    @ApiModelProperty("出售房屋价格中文")
    private String salePriceCn;
    @ApiModelProperty("出租房屋价格")
    private BigDecimal leasePrice;
    @ApiModelProperty("出租房屋价格中文")
    private String leasePriceCn;
    @ApiModelProperty("代业主保管文件(其他)")
    private String depositFileForCustomOther;
    @ApiModelProperty("城市Id")
    private Integer cityId;
    @ApiModelProperty("公司印章图片地址")
    private String companySealPicAddr;
    @ApiModelProperty(value = "是否有户口占用情况 0=否 1=是")
    private Byte hasAccountOccupancy;
    @ApiModelProperty(value = "是否有学位占用情况 0=否 1=是")
    private Byte hasDegreeOccupation;
    @ApiModelProperty(value = "物业情况")
    private BigDecimal propertySituation;
    @ApiModelProperty(value = "物业情况其他")
    private String propertySituationOther;
    @ApiModelProperty(value = "代保管钥匙数量")
    private Byte numberOfKeys;
    @ApiModelProperty(value = "产证文件")
    private String certificateOfProduction;
    @ApiModelProperty(value = "土地性质")
    private String landNature;
    @ApiModelProperty(value = "委托金额")
    private BigDecimal entrustedAmount;
    @ApiModelProperty(value = "委托面积")
    private BigDecimal entrustArea;
    @ApiModelProperty(value = "委托备注或者约定")
    private String entrustNote;

    public List<OwnerUserVO> getOwnerUserVOList() {
        return ownerUserVOList;
    }

    public void setOwnerUserVOList(List<OwnerUserVO> ownerUserVOList) {
        this.ownerUserVOList = ownerUserVOList;
    }

    public String getEntrustSubject() {
        return EntrustSubject;
    }

    public void setEntrustSubject(String entrustSubject) {
        EntrustSubject = entrustSubject;
    }

    public String getHouseNo() {
        return houseNo;
    }

    public void setHouseNo(String houseNo) {
        this.houseNo = houseNo;
    }

    public Byte getCaseType() {
        return caseType;
    }

    public void setCaseType(Byte caseType) {
        this.caseType = caseType;
    }

    public Byte getHouseStatus() {
        return houseStatus;
    }

    public void setHouseStatus(Byte houseStatus) {
        this.houseStatus = houseStatus;
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

    public BigDecimal getOldRentMoney() {
        return oldRentMoney;
    }

    public void setOldRentMoney(BigDecimal oldRentMoney) {
        this.oldRentMoney = oldRentMoney;
    }

    public String getOldRentMoneyCn() {
        return oldRentMoneyCn;
    }

    public void setOldRentMoneyCn(String oldRentMoneyCn) {
        this.oldRentMoneyCn = oldRentMoneyCn;
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

    public Byte getEntrustType() {
        return entrustType;
    }

    public void setEntrustType(Byte entrustType) {
        this.entrustType = entrustType;
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

    public String getSaleCommissionCn() {
        return saleCommissionCn;
    }

    public void setSaleCommissionCn(String saleCommissionCn) {
        this.saleCommissionCn = saleCommissionCn;
    }

    public BigDecimal getLeaseCommission() {
        return leaseCommission;
    }

    public void setLeaseCommission(BigDecimal leaseCommission) {
        this.leaseCommission = leaseCommission;
    }

    public Byte getIsEffective() {
        return isEffective;
    }

    public void setIsEffective(Byte isEffective) {
        this.isEffective = isEffective;
    }

    public Integer getEntrustId() {
        return entrustId;
    }

    public void setEntrustId(Integer entrustId) {
        this.entrustId = entrustId;
    }

    public Integer getCurrentOwerUserId() {
        return currentOwerUserId;
    }

    public void setCurrentOwerUserId(Integer currentOwerUserId) {
        this.currentOwerUserId = currentOwerUserId;
    }

    public BigDecimal getHouseArea() {
        return houseArea;
    }

    public void setHouseArea(BigDecimal houseArea) {
        this.houseArea = houseArea;
    }

    public BigDecimal getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(BigDecimal salePrice) {
        this.salePrice = salePrice;
    }

    public String getSalePriceCn() {
        return salePriceCn;
    }

    public void setSalePriceCn(String salePriceCn) {
        this.salePriceCn = salePriceCn;
    }

    public BigDecimal getLeasePrice() {
        return leasePrice;
    }

    public void setLeasePrice(BigDecimal leasePrice) {
        this.leasePrice = leasePrice;
    }

    public String getLeasePriceCn() {
        return leasePriceCn;
    }

    public void setLeasePriceCn(String leasePriceCn) {
        this.leasePriceCn = leasePriceCn;
    }

    public String getDepositFileForCustomOther() {
        return depositFileForCustomOther;
    }

    public void setDepositFileForCustomOther(String depositFileForCustomOther) {
        this.depositFileForCustomOther = depositFileForCustomOther;
    }

    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    public String getCompanySealPicAddr() {
        return companySealPicAddr;
    }

    public void setCompanySealPicAddr(String companySealPicAddr) {
        this.companySealPicAddr = companySealPicAddr;
    }
    public String getEntrustNo() {
        return entrustNo;
    }

    public void setEntrustNo(String entrustNo) {
        this.entrustNo = entrustNo;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Byte getHasAccountOccupancy() {
        return hasAccountOccupancy;
    }

    public void setHasAccountOccupancy(Byte hasAccountOccupancy) {
        this.hasAccountOccupancy = hasAccountOccupancy;
    }

    public Byte getHasDegreeOccupation() {
        return hasDegreeOccupation;
    }

    public void setHasDegreeOccupation(Byte hasDegreeOccupation) {
        this.hasDegreeOccupation = hasDegreeOccupation;
    }

    public BigDecimal getPropertySituation() {
        return propertySituation;
    }

    public void setPropertySituation(BigDecimal propertySituation) {
        this.propertySituation = propertySituation;
    }

    public String getPropertySituationOther() {
        return propertySituationOther;
    }

    public void setPropertySituationOther(String propertySituationOther) {
        this.propertySituationOther = propertySituationOther;
    }

    public Byte getNumberOfKeys() {
        return numberOfKeys;
    }

    public void setNumberOfKeys(Byte numberOfKeys) {
        this.numberOfKeys = numberOfKeys;
    }

    public String getCertificateOfProduction() {
        return certificateOfProduction;
    }

    public void setCertificateOfProduction(String certificateOfProduction) {
        this.certificateOfProduction = certificateOfProduction;
    }

    public String getLandNature() {
        return landNature;
    }

    public void setLandNature(String landNature) {
        this.landNature = landNature;
    }

    public BigDecimal getEntrustedAmount() {
        return entrustedAmount;
    }

    public void setEntrustedAmount(BigDecimal entrustedAmount) {
        this.entrustedAmount = entrustedAmount;
    }

    public BigDecimal getEntrustArea() {
        return entrustArea;
    }

    public void setEntrustArea(BigDecimal entrustArea) {
        this.entrustArea = entrustArea;
    }

    public String getEntrustNote() {
        return entrustNote;
    }

    public void setEntrustNote(String entrustNote) {
        this.entrustNote = entrustNote;
    }
}
