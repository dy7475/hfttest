package com.myfun.erpWeb.onlinepay.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

@ApiModel
public class SmallProgramInfoParamVO implements Serializable {

    @ApiModelProperty("title")
    private String title;
    @ApiModelProperty("appId")
    private String appId;
    @ApiModelProperty("shareAppPath")
    private String shareAppPath;
    @ApiModelProperty("imgUrl")
    private String imgUrl;
    @ApiModelProperty("description")
    private String description;
    @ApiModelProperty("shareUrl")
    private String shareUrl;

    public String getShareUrl() {
        return shareUrl;
    }

    public void setShareUrl(String shareUrl) {
        this.shareUrl = shareUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getShareAppPath() {
        return shareAppPath;
    }

    public void setShareAppPath(String shareAppPath) {
        this.shareAppPath = shareAppPath;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
