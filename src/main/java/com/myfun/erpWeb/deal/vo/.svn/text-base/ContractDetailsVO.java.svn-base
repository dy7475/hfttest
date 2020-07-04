package com.myfun.erpWeb.deal.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

@ApiModel
public class ContractDetailsVO implements Serializable {
    @ApiModelProperty("合同模板内容")
    private String contractTemplateContent;
    @ApiModelProperty("合同数据")
    private List indexList;
    @ApiModelProperty("合同审核状态 0=未审核，1=初审，2=复审，3=作废 4=初审中  5=复审中  6=作废中 7 撤销初审中 8=撤销复审中")
    private Byte auditStatus;
    @ApiModelProperty("合同签约状态 0,未签约 1 已经签约")
    private Byte signStatus;
    @ApiModelProperty("是否开通在线签约 是否开通了上上签在线合同签约 1=是")
    private Byte isOpenOnlineSign;
    @ApiModelProperty("签约配置 签约类型 0=线下 1=线上 2=均可")
    private Byte compOpenOlineContract;
    @ApiModelProperty("已经签约合同图片/PDF的url")
    private String fileUrl;
    @ApiModelProperty("logo位置")
    private String logoPosition;
    @ApiModelProperty("文案")
    private String document;
    @ApiModelProperty("路径")
    private String url;
    @ApiModelProperty("图片")
    private String image;
    @ApiModelProperty("小程序ID")
    private String appletId;
    @ApiModelProperty("甲方(卖方)是否完成了签字 1=是")
    private Byte partyAComplete;
    @ApiModelProperty("乙方(买方)是否完成了签字 1=是")
    private Byte partyBComplete;

    public String getContractTemplateContent() {
        return contractTemplateContent;
    }

    public void setContractTemplateContent(String contractTemplateContent) {
        this.contractTemplateContent = contractTemplateContent;
    }

    public List getIndexList() {
        return indexList;
    }

    public void setIndexList(List indexList) {
        this.indexList = indexList;
    }

    public Byte getAuditStatus() {
        return auditStatus;
    }

    public void setAuditStatus(Byte auditStatus) {
        this.auditStatus = auditStatus;
    }

    public Byte getSignStatus() {
        return signStatus;
    }

    public void setSignStatus(Byte signStatus) {
        this.signStatus = signStatus;
    }

    public Byte getIsOpenOnlineSign() {
        return isOpenOnlineSign;
    }

    public void setIsOpenOnlineSign(Byte isOpenOnlineSign) {
        this.isOpenOnlineSign = isOpenOnlineSign;
    }

    public Byte getCompOpenOlineContract() {
        return compOpenOlineContract;
    }

    public void setCompOpenOlineContract(Byte compOpenOlineContract) {
        this.compOpenOlineContract = compOpenOlineContract;
    }

    public String getFileUrl() {
        return fileUrl;
    }

    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl;
    }



    public void setLogoPosition(String logoPosition) {
        this.logoPosition = logoPosition;
    }

    public String getLogoPosition() {
        return logoPosition;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getAppletId() {
        return appletId;
    }

    public void setAppletId(String appletId) {
        this.appletId = appletId;
    }

    public Byte getPartyAComplete() {
        return partyAComplete;
    }

    public void setPartyAComplete(Byte partyAComplete) {
        this.partyAComplete = partyAComplete;
    }

    public Byte getPartyBComplete() {
        return partyBComplete;
    }

    public void setPartyBComplete(Byte partyBComplete) {
        this.partyBComplete = partyBComplete;
    }
}
