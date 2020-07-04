package com.myfun.erpWeb.usercenter.param;

import com.myfun.repository.param.AbstractEncryParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class DeleteMessageMessageParam extends AbstractEncryParam {

    @ApiModelProperty("房源ID")
    private Integer caseId;
    @ApiModelProperty("房源类型")
    private Byte caseType;
    @ApiModelProperty("消息所属模块的详细类型  1=强制写跟进 2=IP拨号")
    private Integer msgModule;
    @ApiModelProperty("经纪人档案ID")
    private Integer archiveId;

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

    public Integer getMsgModule() {
        return msgModule;
    }

    public void setMsgModule(Integer msgModule) {
        this.msgModule = msgModule;
    }

    public Integer getArchiveId() {
        return archiveId;
    }

    public void setArchiveId(Integer archiveId) {
        this.archiveId = archiveId;
    }
}