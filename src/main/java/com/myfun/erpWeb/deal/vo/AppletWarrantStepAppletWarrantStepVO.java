package com.myfun.erpWeb.deal.vo;

import com.myfun.erpWeb.managecenter.transaction.vo.ErpProcessRuntimeStepDto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

@ApiModel
public class AppletWarrantStepAppletWarrantStepVO implements Serializable {
    @ApiModelProperty(value = "流程步骤")
    List<ErpProcessRuntimeStepDto> stepList;
    @ApiModelProperty("经纪人名字")
    private String userName;
    @ApiModelProperty("经纪人电话")
    private String userTel;
    @ApiModelProperty("经纪人头像")
    private String userImageUrl;
    @ApiModelProperty("门店名称")
    private String userDeptName;
    @ApiModelProperty("经纪人ID")
    private Integer userId;
    @ApiModelProperty("经纪人档案ID")
    private Integer archiveId;
    @ApiModelProperty("买方姓名")
    private String buyOwnerName;
    @ApiModelProperty("卖方姓名")
    private String sellOwnerName;
    @ApiModelProperty("签约完成时间")
    private String completeTime;
    @ApiModelProperty("房屋地址")
    private String houseAdress;
    @ApiModelProperty("合同状态 0=未完成 1=已完成 ")
    private Integer contractStatus;
    @ApiModelProperty("签约类型 0=线下 1=线上 2=均可")
    private Byte signType;
    @ApiModelProperty("合同审核状态 0=未审核，1=初审，2=复审，3=作废 4=未作废 5=初审中  6=复审中  7=作废中 8=撤销初审中 9=撤销复审中")
    private Byte dealAuditStatus;
    @ApiModelProperty("成交金额")
    private BigDecimal sellDealMoney;
    @ApiModelProperty("房屋面积")
    private BigDecimal area;
    @ApiModelProperty("社区名称")
    private String buildName;
    @ApiModelProperty("合同类型出售：101 出租 102")
    private String dealType  ;
    public List<ErpProcessRuntimeStepDto> getStepList() {
        return stepList;
    }

    public void setStepList(List<ErpProcessRuntimeStepDto> stepList) {
        this.stepList = stepList;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserTel() {
        return userTel;
    }

    public void setUserTel(String userTel) {
        this.userTel = userTel;
    }

    public String getUserImageUrl() {
        return userImageUrl;
    }

    public void setUserImageUrl(String userImageUrl) {
        this.userImageUrl = userImageUrl;
    }

    public String getUserDeptName() {
        return userDeptName;
    }

    public void setUserDeptName(String userDeptName) {
        this.userDeptName = userDeptName;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getArchiveId() {
        return archiveId;
    }

    public void setArchiveId(Integer archiveId) {
        this.archiveId = archiveId;
    }

    public String getBuyOwnerName() {
        return buyOwnerName;
    }

    public void setBuyOwnerName(String buyOwnerName) {
        this.buyOwnerName = buyOwnerName;
    }


    public String getSellOwnerName() {
        return sellOwnerName;
    }

    public void setSellOwnerName(String sellOwnerName) {
        this.sellOwnerName = sellOwnerName;
    }

    public String getHouseAdress() {
        return houseAdress;
    }

    public void setHouseAdress(String houseAdress) {
        this.houseAdress = houseAdress;
    }

    public String getCompleteTime() {
        return completeTime;
    }

    public void setCompleteTime(String completeTime) {
        this.completeTime = completeTime;
    }

    public Integer getContractStatus() {
        return contractStatus;
    }

    public void setContractStatus(Integer contractStatus) {
        this.contractStatus = contractStatus;
    }

    public Byte getSignType() {
        return signType;
    }

    public void setSignType(Byte signType) {
        this.signType = signType;
    }

    public Byte getDealAuditStatus() {
        return dealAuditStatus;
    }

    public void setDealAuditStatus(Byte dealAuditStatus) {
        this.dealAuditStatus = dealAuditStatus;
    }

    public BigDecimal getSellDealMoney() {
        return sellDealMoney;
    }

    public void setSellDealMoney(BigDecimal sellDealMoney) {
        this.sellDealMoney = sellDealMoney;
    }

    public BigDecimal getArea() {
        return area;
    }

    public void setArea(BigDecimal area) {
        this.area = area;
    }

    public String getBuildName() {
        return buildName;
    }

    public void setBuildName(String buildName) {
        this.buildName = buildName;
    }

    public String getDealType() {
        return dealType;
    }

    public void setDealType(String dealType) {
        this.dealType = dealType;
    }
}
