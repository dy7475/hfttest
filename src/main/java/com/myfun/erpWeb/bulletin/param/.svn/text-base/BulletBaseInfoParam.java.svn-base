package com.myfun.erpWeb.bulletin.param;

import com.myfun.repository.param.EncryParamIfc;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * app基础信息修改（删除、置顶、开启评论）
 * 请求参数封装
 * create by 程二狗 on 2018/11/13 0013
 */
@ApiModel
public class BulletBaseInfoParam implements EncryParamIfc {
    @ApiModelProperty("帖子ID")
    private Integer bulletId;
    @ApiModelProperty("置顶0=普通 1=置顶")
    private Boolean stick = false;
    @ApiModelProperty("删除0=正常 1=删除")
    private Integer isDelete = 0;
    @ApiModelProperty("评论0=开启 1=关闭")
    private Integer replyStatus = 0;

    public Integer getReplyStatus() {
        return replyStatus;
    }

    public void setReplyStatus(Integer replyStatus) {
        this.replyStatus = replyStatus;
    }

    public Integer getBulletId() {
        return bulletId;
    }

    public void setBulletId(Integer bulletId) {
        this.bulletId = bulletId;
    }

    public Boolean getStick() {
        return stick;
    }

    public void setStick(Boolean stick) {
        this.stick = stick;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }
}
