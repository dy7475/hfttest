package com.myfun.service.jms.bean;

import com.extension.framework.mq.context.MqMessage;

public class UpdateFunUserMessage extends MqMessage {

    private Integer cityId;
    private String userIds;
    private String updateRange;
    private Integer oldCompId;
    private Integer newCompId;
    private Integer delUserId;

    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    public String getUserIds() {
        return userIds;
    }

    public void setUserIds(String userIds) {
        this.userIds = userIds;
    }

    public String getUpdateRange() {
        return updateRange;
    }

    public void setUpdateRange(String updateRange) {
        this.updateRange = updateRange;
    }

    public Integer getOldCompId() {
        return oldCompId;
    }

    public void setOldCompId(Integer oldCompId) {
        this.oldCompId = oldCompId;
    }

    public Integer getNewCompId() {
        return newCompId;
    }

    public void setNewCompId(Integer newCompId) {
        this.newCompId = newCompId;
    }

    public Integer getDelUserId() {
        return delUserId;
    }

    public void setDelUserId(Integer delUserId) {
        this.delUserId = delUserId;
    }
}
