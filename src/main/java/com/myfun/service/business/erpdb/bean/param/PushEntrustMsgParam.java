package com.myfun.service.business.erpdb.bean.param;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

@ApiModel
public class PushEntrustMsgParam implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty("推送类型 mini:小程序消息  gzh：公众号消息(暂时传 mini)")
    private String type = "mini";
    @ApiModelProperty("小程序openId")
    private String miniOpenId;
    @ApiModelProperty("公众号openId")
    private String gzhOpenId;
    @ApiModelProperty("接受者用户id")
    private String userId;
    @ApiModelProperty("发送者用户id")
    private String sendId;
    @ApiModelProperty("模板消息类型(见模板消息类型)")
    private String templateType;
    @ApiModelProperty("推送给哪一端产品的公众号用户，优优好房公众号：youyou、微店：weidian")
    private String fromSource;
    @ApiModelProperty("小程序扩展参数")
    private String miniJsonParams;
    @ApiModelProperty("公众号扩展参数")
    private String gzhJsonParams;
    @ApiModelProperty("组织ID（0：优选好房，1：房口袋 2：友邻通 3：优优好房 6：子弹找房）")
    private Integer dorgId;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMiniOpenId() {
        return miniOpenId;
    }

    public void setMiniOpenId(String miniOpenId) {
        this.miniOpenId = miniOpenId;
    }

    public String getGzhOpenId() {
        return gzhOpenId;
    }

    public void setGzhOpenId(String gzhOpenId) {
        this.gzhOpenId = gzhOpenId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getSendId() {
        return sendId;
    }

    public void setSendId(String sendId) {
        this.sendId = sendId;
    }

    public String getTemplateType() {
        return templateType;
    }

    public void setTemplateType(String templateType) {
        this.templateType = templateType;
    }

    public String getFromSource() {
        return fromSource;
    }

    public void setFromSource(String fromSource) {
        this.fromSource = fromSource;
    }

    public String getMiniJsonParams() {
        return miniJsonParams;
    }

    public void setMiniJsonParams(String miniJsonParams) {
        this.miniJsonParams = miniJsonParams;
    }

    public String getGzhJsonParams() {
        return gzhJsonParams;
    }

    public void setGzhJsonParams(String gzhJsonParams) {
        this.gzhJsonParams = gzhJsonParams;
    }

    public Integer getDorgId() {
        return dorgId == null ? 0 : dorgId;
    }

    public void setDorgId(Integer dorgId) {
        this.dorgId = dorgId;
    }
}
