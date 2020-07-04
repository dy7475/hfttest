package com.myfun.service.jms.bean;

import com.extension.framework.mq.context.MqMessage;

/**
 * @Author 蔡春林 美联委托协议业主都签署完成 上传协议图片
 * @Date 2019/11/26 0026 下午 12:46
 **/
public class AgreementPictureMessage extends MqMessage {
    // 城市Id
    private Integer cityId; 
    // 城市Id
    private Integer entrustId;
    // 城市Id
    private Integer ownerId;

    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    public Integer getEntrustId() {
        return entrustId;
    }

    public void setEntrustId(Integer entrustId) {
        this.entrustId = entrustId;
    }

    public Integer getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Integer ownerId) {
        this.ownerId = ownerId;
    }
}
