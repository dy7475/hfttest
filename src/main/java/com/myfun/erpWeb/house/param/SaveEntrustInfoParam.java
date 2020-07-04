package com.myfun.erpWeb.house.param;

import com.myfun.repository.param.EncryParamIfc;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @author HuangJiang
 * @since 2019年11月25日 15:43:10
 * Modified XXX HuangJiang 2019年11月25日
 */
@ApiModel(description = "保存委托参数")
public class SaveEntrustInfoParam implements EncryParamIfc {
    @ApiModelProperty(value = "委托ID（新增时不传，修改时一定要传）")
    private Integer entrustId;
    @ApiModelProperty(value = "房源ID")
    private Integer caseId;
    @ApiModelProperty(value = "房源类型（1=出售；2=出租）")
    private Byte caseType;
    @ApiModelProperty(value = "委托业务（1=出售委托；2出租委托；3=出售出租委托）")
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
    @ApiModelProperty(value = "代业主保管文件（多选,英文逗号隔开）：房地产复印件,产权人身份资料复印件,房地产买卖合同复印件,购买发票复印件,付清房款证明复印件,产权人委托书")
    private String depositFileForCustom;
    @ApiModelProperty(value = "代业主保管文件（其他）")
    private String depositFileForCustomOther;
    @ApiModelProperty(value = "看房方式（1=甲方将物业钥匙交予乙方作看房之用；2=双方另行约定时间看房）")
    private Byte inspectionType;
    @ApiModelProperty(value = "出售佣金")
    private BigDecimal saleCommission;
    @ApiModelProperty(value = "出租佣金")
    private BigDecimal leaseCommission; 
    @ApiModelProperty(value = "是否有租约 0=否 1=是")
    private Byte hasLeaseContract;
    @ApiModelProperty(value = "租期到期")
    private Date leaseEndTime;
    @ApiModelProperty(value = "原租约租金")
    private BigDecimal oldRentMoney;
    @ApiModelProperty(value = "业主信息list")
    private List<EntrustOwnersInfoParam> ownersList;
    @ApiModelProperty(value = "产权号list")
    private List<EntrustCertificateInfoParam> certificateList;
    @ApiModelProperty(value = "附件信息list")
    private List<EntrustFileInfoParam> fileList;
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

    //[2020-06-16] 12688 【bug转需求】出租租金，改为手动填写
    @ApiModelProperty(value = "出租单必填项！出租租金，手动填写")
    private BigDecimal customRentAmount;

    public BigDecimal getCustomRentAmount() {
        return customRentAmount;
    }

    public void setCustomRentAmount(BigDecimal customRentAmount) {
        this.customRentAmount = customRentAmount;
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
    
    public String getDepositFileForCustomOther() {
        return depositFileForCustomOther;
    }
    
    public void setDepositFileForCustomOther(String depositFileForCustomOther) {
        this.depositFileForCustomOther = depositFileForCustomOther;
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
    
    public BigDecimal getOldRentMoney() {
        return oldRentMoney;
    }
    
    public void setOldRentMoney(BigDecimal oldRentMoney) {
        this.oldRentMoney = oldRentMoney;
    }
    
    public List<EntrustOwnersInfoParam> getOwnersList() {
        return ownersList;
    }
    
    public void setOwnersList(List<EntrustOwnersInfoParam> ownersList) {
        this.ownersList = ownersList;
    }
    
    public List<EntrustCertificateInfoParam> getCertificateList() {
        return certificateList;
    }
    
    public void setCertificateList(List<EntrustCertificateInfoParam> certificateList) {
        this.certificateList = certificateList;
    }
    
    public List<EntrustFileInfoParam> getFileList() {
        return fileList;
    }
    
    public void setFileList(List<EntrustFileInfoParam> fileList) {
        this.fileList = fileList;
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
