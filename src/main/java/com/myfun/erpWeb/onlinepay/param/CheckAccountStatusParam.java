package com.myfun.erpWeb.onlinepay.param;

import com.myfun.repository.param.EncryParamIfc;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class CheckAccountStatusParam implements EncryParamIfc {

    @ApiModelProperty(value = "查询账户的cityId", required = true)
    private Integer cityId;
    @ApiModelProperty(value = "查询账户的compId， 如果archiveId和compId 都为空时 根据 accountType 查询登陆人的信息 当archiveId 为空时必传", required = false)
    private Integer compId;
    @ApiModelProperty(value = "查询账户的archiveId 如果archiveId和compId 都为空时 根据 accountType 查询登陆人的信息 当compId 为空时必传", required = false)
    private Integer archiveId;
    @ApiModelProperty(value = "账户类型 1=个人账户(暂时不用)  2=企业账户", required = true)
    private Byte accountType;

    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    public Integer getCompId() {
        return compId;
    }

    public void setCompId(Integer compId) {
        this.compId = compId;
    }

    public Integer getArchiveId() {
        return archiveId;
    }

    public void setArchiveId(Integer archiveId) {
        this.archiveId = archiveId;
    }

    public Byte getAccountType() {
        return accountType;
    }

    public void setAccountType(Byte accountType) {
        this.accountType = accountType;
    }
}
